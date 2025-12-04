package com.example.lab7;

import android.content.ContentUris;
import android.net.Uri;

public class FriendsContract {

    public static final String TABLE_NAME = "friends";
    public static final String CONTENT_AUTHORITY = "com.example.friendsprovider";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, TABLE_NAME);

    public static final String CONTENT_TYPE = "vnd.android.cursor.dir/" + CONTENT_AUTHORITY + "." + TABLE_NAME;
    public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/" + CONTENT_AUTHORITY + "." + TABLE_NAME;

    public static class Columns {
        public static final String _ID = "_id";
        public static final String NAME = "name";
        public static final String EMAIL = "email";
        public static final String PHONE = "phone";
    }

    public static Uri buildFriendUri(long id) {
        return ContentUris.withAppendedId(CONTENT_URI, id);
    }

    public static long getFriendId(Uri uri) {
        return ContentUris.parseId(uri);
    }
}
