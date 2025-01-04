package com.github.NlFramework.DB;

import com.github.NlFramework.utils.CL;

import java.io.IOException;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import com.github.NlFramework.utils.FILE;
import org.bukkit.plugin.java.JavaPlugin;

public class SQLITE {
    private final File databaseFile;
    private final String tableName;
    private final JavaPlugin instance;

    public static void InitDatabase(JavaPlugin instance) {
        FILE.createFolderINE(instance.getDataFolder());

        File DB = new File(instance.getDataFolder(), "data.db");
        if (!DB.exists()) {
            try {
                boolean res = DB.createNewFile();
                if (res) {
                    CL.Send("&9[SQLITE] &7Successfully created a Database", instance);
                } else {
                    CL.Send("&9[SQLITE] &cFailed to create a Database", instance);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public SQLITE(String tableName, JavaPlugin instance) {
        this.databaseFile = new File(instance.getDataFolder(), "data.db");
        this.tableName = tableName;
        this.instance = instance;
        CreateTable();
    }

    private Connection getConnection() throws Exception {
        String url = "jdbc:sqlite:" + databaseFile.getAbsolutePath();
        return DriverManager.getConnection(url);
    }

    private void CreateTable() {
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " (KEY TEXT PRIMARY KEY, VALUE TEXT);";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            CL.Send("&9[SQLITE] &7Successfully created a Table", instance);
        } catch (Exception e) {
            CL.Send("&9[SQLITE] &cFailed to create a Table", instance);
            e.printStackTrace();
        }
    }

    public void set(String KEY, String VALUE) {
        if (VALUE == null) { return; }
        String sql = "INSERT OR REPLACE INTO " + tableName + " (KEY, VALUE) VALUES (?, ?);";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, KEY);
            pstmt.setString(2, VALUE);
            pstmt.executeUpdate();
        } catch (Exception e) {
            CL.Send("&9[SQLITE] &cFailed to insert key-value pair", instance);
            e.printStackTrace();
        }
    }

    public String get(String KEY) {
        String sql = "SELECT VALUE FROM " + tableName + " WHERE KEY = ?;";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, KEY);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getString("VALUE");
            } else {
                return null;
            }
        } catch (Exception e) {
            CL.Send("&9[SQLITE] &cFailed to get value", instance);
            e.printStackTrace();
            return null;
        }
    }
}
