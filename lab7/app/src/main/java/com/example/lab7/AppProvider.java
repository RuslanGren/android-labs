package com.example.lab7;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class AppProvider extends ContentProvider {

    private DatabaseHelper dbHelper;
    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    private static final int ALL_FRIENDS = 1;
    private static final int FRIEND_BY_ID = 2;

    static {
        URI_MATCHER.addURI(FriendsContract.CONTENT_AUTHORITY, FriendsContract.TABLE_NAME, ALL_FRIENDS);
        URI_MATCHER.addURI(FriendsContract.CONTENT_AUTHORITY, FriendsContract.TABLE_NAME + "/#", FRIEND_BY_ID);
    }

    @Override
    public boolean onCreate() {
        dbHelper = DatabaseHelper.getInstance(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection,
                        @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        switch (URI_MATCHER.match(uri)) {
            case ALL_FRIENDS:
                builder.setTables(FriendsContract.TABLE_NAME);
                break;
            case FRIEND_BY_ID:
                builder.setTables(FriendsContract.TABLE_NAME);
                long id = FriendsContract.getFriendId(uri);
                builder.appendWhere(FriendsContract.Columns._ID + "=" + id);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        return builder.query(db, projection, selection, selectionArgs, null, null, sortOrder);
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (URI_MATCHER.match(uri)) {
            case ALL_FRIENDS:
                return FriendsContract.CONTENT_TYPE;
            case FRIEND_BY_ID:
                return FriendsContract.CONTENT_ITEM_TYPE;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        if (URI_MATCHER.match(uri) != ALL_FRIENDS)
            throw new IllegalArgumentException("Cannot insert for URI: " + uri);

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long rowId = db.insert(FriendsContract.TABLE_NAME, null, values);

        if (rowId > 0) return FriendsContract.buildFriendUri(rowId);
        throw new SQLException("Failed to insert row into " + uri);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sel = selection;

        switch (URI_MATCHER.match(uri)) {
            case ALL_FRIENDS:
                return db.delete(FriendsContract.TABLE_NAME, sel, selectionArgs);
            case FRIEND_BY_ID:
                long id = FriendsContract.getFriendId(uri);
                sel = FriendsContract.Columns._ID + "=" + id + (selection != null ? " AND (" + selection + ")" : "");
                return db.delete(FriendsContract.TABLE_NAME, sel, selectionArgs);
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values,
                      @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sel = selection;

        switch (URI_MATCHER.match(uri)) {
            case ALL_FRIENDS:
                return db.update(FriendsContract.TABLE_NAME, values, sel, selectionArgs);
            case FRIEND_BY_ID:
                long id = FriendsContract.getFriendId(uri);
                sel = FriendsContract.Columns._ID + "=" + id + (selection != null ? " AND (" + selection + ")" : "");
                return db.update(FriendsContract.TABLE_NAME, values, sel, selectionArgs);
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }
}
