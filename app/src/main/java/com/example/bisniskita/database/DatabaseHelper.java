package com.example.bisniskita.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "bisnisKita.db";
    private static final int DATABASE_VERSION = 1;

    // Nama tabel dan kolom
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_USER_ID = "id";
    private static final String COLUMN_USER_NAME = "name";
    private static final String COLUMN_USER_EMAIL = "email";
    private static final String COLUMN_USER_PASSWORD = "password";
    // tambahkan kolom lainnya sesuai kebutuhan

    // tambahan tabel shop
    private static final String TABLE_SHOPS = "shops";
    private static final String COLUMN_SHOP_ID = "id";
    private static final String COLUMN_SHOP_NAME = "name";
    // tambahkan kolom lainnya sesuai kebutuhan

    private static final String TABLE_PRODUCTS = "products";
    private static final String COLUMN_PRODUCT_ID = "id";
    private static final String COLUMN_PRODUCT_NAME = "name";
    private static final String COLUMN_PRODUCT_PRICE = "price";
    private static final String COLUMN_PRODUCT_DESCRIPTION = "description";
    private static final String COLUMN_PRODUCT_SHOP_ID = "shop_id";
    // tambahkan kolom lainnya sesuai kebutuhan

    // tambahan tabel cart
    private static final String TABLE_CART = "cart";
    private static final String COLUMN_CART_ID = "id";
    private static final String COLUMN_CART_USER_ID = "user_id";
    private static final String COLUMN_CART_PRODUCT_ID = "product_id";
    private static final String COLUMN_CART_QTY = "qty";

    private static final String TABLE_ORDERS = "orders";
    private static final String COLUMN_ORDER_ID = "id";
    private static final String COLUMN_ORDER_USER_ID = "user_id";
    private static final String COLUMN_ORDER_PRODUCT_ID = "product_id";
    private static final String COLUMN_ORDER_TOTAL_PRICE = "product_id";
    // tambahkan kolom lainnya sesuai kebutuhan

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Membuat tabel pengguna
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + COLUMN_USER_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_USER_NAME + " TEXT,"
                + COLUMN_USER_EMAIL + " TEXT,"
                + COLUMN_USER_PASSWORD + "TEXT"
                // tambahkan kolom lainnya sesuai kebutuhan
                + ")";
        db.execSQL(CREATE_USERS_TABLE);

        // Membuat tabel list toko yg ada di biniskita
        String CREATE_SHOPS_TABLE = "CREATE TABLE " + TABLE_SHOPS + "("
                + COLUMN_SHOP_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_SHOP_NAME + " TEXT"
                // tambahkan kolom lainnya sesuai kebutuhan
                + ")";
        db.execSQL(CREATE_SHOPS_TABLE);

        // Membuat tabel produk
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS + "("
                + COLUMN_PRODUCT_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_PRODUCT_NAME + " TEXT,"
                + COLUMN_PRODUCT_PRICE + " REAL,"
                + COLUMN_PRODUCT_DESCRIPTION + "TEXT,"
                + COLUMN_PRODUCT_SHOP_ID + "INTEGER,"
                // tambah foreign key buat hubungin tabel shop sama tabel produk
                + "FOREIGN KEY ("
                + COLUMN_PRODUCT_SHOP_ID + ") REFERENCES " + TABLE_SHOPS + "(" + COLUMN_SHOP_ID + ")"
                // tambahkan kolom lainnya sesuai kebutuhan
                + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);

        // Membuat tabel cart
        String CREATE_CART_TABLE = "CREATE TABLE " + TABLE_CART + "("
                + COLUMN_CART_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_CART_USER_ID + " INTEGER,"
                + COLUMN_CART_PRODUCT_ID + " INTEGER,"
                + COLUMN_CART_QTY + " INTEGER"
                // tambahkan kolom lainnya sesuai kebutuhan
                + ")";
        db.execSQL(CREATE_CART_TABLE);

        // Membuat tabel pesanan
        String CREATE_ORDERS_TABLE = "CREATE TABLE " + TABLE_ORDERS + "("
                + COLUMN_ORDER_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_ORDER_USER_ID + " INTEGER,"
                + COLUMN_ORDER_PRODUCT_ID + " INTEGER,"
                + COLUMN_ORDER_TOTAL_PRICE + " INTEGER"
                // tambahkan kolom lainnya sesuai kebutuhan
                + ")";
        db.execSQL(CREATE_ORDERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop tabel jika sudah ada
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHOPS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }
}