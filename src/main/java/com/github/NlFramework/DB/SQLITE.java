package com.github.NlFramework.DB;

import com.github.NaleumFramework;
import com.github.NlFramework.utils.CL;
import java.sql.*;
import java.io.File;
import java.sql.Connection;
import java.util.HashMap;

public class SQLITE {
    public static HashMap<String, Connection> database = new HashMap<>();
    public static void Connect(String DB) {
        File dbFile = new File(NaleumFramework.getInstance().getDataFolder(), "DB" + File.separator + DB + ".db");

        String url = "jdbc:sqlite:" + dbFile.getAbsolutePath();

        try {
            database.put(DB, DriverManager.getConnection(url));
            CL.Send("&9[SQLITE] &7Successfully connected to &a" + DB + ".db", NaleumFramework.getInstance());
            CL.Send("&9[SQLITE] &8- " + dbFile.getAbsolutePath(), NaleumFramework.getInstance());
        } catch (Exception e) {
            CL.Send("&9[SQLITE] &cFailed to connect to " + DB + ".db");
        }
    }
    public static void CreateTable(String DB, String table, String[] fields, String pri) {
        StringBuilder SQL = new StringBuilder
                ("CREATE TABLE IF NOT EXISTS " + table + " (" + pri + " TEXT PRIMARY KEY");

        for (int i = 0; i < fields.length; i++) {
            SQL.append(", ").append(fields[i]).append(" TEXT NOT NULL");
        }

        SQL.append(");");

        try (Statement stmt = database.get(DB).createStatement()) {
            int rs = stmt.executeUpdate(SQL.toString());
            if (!(rs == 0)) {
                stmt.execute(SQL.toString());
                CL.Send("&9[SQLITE] &7successfully created a table &a" + DB + ".db -> " + table, NaleumFramework.getInstance());
            }
        } catch (SQLException e) {
            CL.Send("&9[SQLITE] &cFailed to create table", NaleumFramework.getInstance());
            CL.Send("&9[SQLITE] &8- " + DB + ".db -> " + table, NaleumFramework.getInstance());
        }
    }
    public static String Get(String DB, String table, String field, String key, String keyValue) {
        if (database.get(DB) == null) {
            CL.Send("&9[SQLITE] &cDatabase not found", NaleumFramework.getInstance());
            return null;
        }

        String SQL = "SELECT " + field + " FROM " + table + " WHERE " + key + " = ?";

        try (PreparedStatement stmt = database.get(DB).prepareStatement(SQL)) {
            stmt.setString(1, keyValue);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString(field);
                }
                CL.Send("&9[SQLITE] &cFailed to retrieve the field value", NaleumFramework.getInstance());
                CL.Send("&9[SQLITE] &8- " + DB + ".db -> " + table + " -> " + keyValue + "-" + field, NaleumFramework.getInstance());
            }
        } catch (SQLException e) {
            CL.Send("&9[SQLITE] &cFailed to retrieve the field value", NaleumFramework.getInstance());
            CL.Send("&9[SQLITE] &8- " + DB + ".db -> " + table + " -> " + keyValue + "-" + field, NaleumFramework.getInstance());
            return null;
        }
        return null;
    }
    public static void Insert(String DB, String table, String[] field, String[] value) {
        if (!(database.get(DB) == null)) {
            StringBuilder SQL = new StringBuilder("INSERT OR REPLACE INTO " + table + " (");

            for (String f : field) { SQL.append(f).append(", "); }
            SQL.delete(SQL.length() - 2, SQL.length());
            SQL.append(") VALUES (");
            for (String v : value) { SQL.append("'").append(v).append("', "); }
            SQL.delete(SQL.length() - 2, SQL.length());
            SQL.append(");");

            try (Statement stmt = database.get(DB).createStatement()) {
                stmt.executeUpdate(SQL.toString());
            } catch (SQLException e) {
                CL.Send("&9[SQLITE] &cFailed to add values to table", NaleumFramework.getInstance());
                CL.Send("&9[SQLITE] &8- " + DB + ".db -> " + table, NaleumFramework.getInstance());
            }
        }
    }
}
