package kursovoy.jdbc;

import kursovoy.model.Note;
import kursovoy.model.User;

import org.springframework.beans.factory.annotation.Value;

import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by zaporozhec on 5/6/15.
 */
public class JDBCUtil {
	final static String jdbcDriver = "com.mysql.jdbc.Driver";
	final static String connectionString = "jdbc:mysql://localhost/KURSOVOY?useServerPrepStmts=false&rewriteBatchedStatements=true&useUnicode=true&characterEncoding=UTF-8";
	final static String userName = "root";
	final static String password = "";

	public List<User> getAllUsers() {
		return getUser(null, null);
	}

	public List<User> getUser(String userId) {
		return getUser("USER_ID", userId);
	}
	public void saveUser(User u) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(connectionString, userName,
					password);

			String sql;
			if (u.getUserId() == 0) {
				sql = "INSERT INTO USERS(FIRST_NAME,LAST_NAME,AGE,LOGIN,PASSWORD) VALUES (?,?,?,?,?)";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, u.getFirstName());
				stmt.setString(2, u.getLastName());
				stmt.setInt(3, u.getAge());
				stmt.setString(4, u.getLogin());
				stmt.setString(5, u.getPassword());
				stmt.executeUpdate();
				// add user
			} else {
				sql = "UPDATE USERS SET FIRST_NAME =?, LAST_NAME=?, AGE=?, LOGIN=?, PASSWORD=? WHERE USER_ID = ?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, u.getFirstName());
				stmt.setString(2, u.getLastName());
				stmt.setInt(3, u.getAge());
				stmt.setString(4, u.getLogin());
				stmt.setString(5, u.getPassword());
				stmt.setInt(6, u.getUserId());
				stmt.executeUpdate();
				// update user
			}

			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}
	}

	public void delete(int userId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(connectionString, userName,
					password);

			String sql = "DELETE FROM USERS WHERE USER_ID=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, userId);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}
	}

	public List<User> getUser(String attrName, String attrVal) {
		List<User> userList = new ArrayList<User>();
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(connectionString, userName,
					password);
			stmt = conn.createStatement();
			String sql;
			if (attrName != null && attrVal != null) {
				sql = "SELECT * FROM USERS WHERE " + attrName + "='" + attrVal
						+ "'";
			} else {
				sql = "SELECT * FROM USERS";
			}
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				User u = new User();
				u.setUserId(rs.getInt("USER_ID"));
				u.setFirstName(rs.getString("FIRST_NAME"));
				u.setLastName(rs.getString("LAST_NAME"));
				u.setAge(rs.getInt("AGE"));
				u.setLogin(rs.getString("LOGIN"));
				u.setPassword(rs.getString("PASSWORD"));
				userList.add(u);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			return userList;
		}
	}

	public List<Note> getNoteByUserId(String userId) {
		return getNote("USER_ID", userId);
	}

	public List<Note> getNote(String noteID) {
		return getNote("NOTE_ID", noteID);
	}

	public List<Note> getNote(String attrName, String attrVal) {
		List<Note> userList = new ArrayList<Note>();
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(connectionString, userName,
					password);
			stmt = conn.createStatement();
			String sql;
			if (attrName != null && attrVal != null) {
				sql = "SELECT * FROM NOTE WHERE " + attrName + "='" + attrVal
						+ "'";
			} else {
				sql = "SELECT * FROM NOTE";
			}
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Note u = new Note();
				u.setNoteId(rs.getInt("NOTE_ID"));
				u.setNoteName(rs.getString("NOTE_NAME"));
				u.setDate(rs.getDate("NOTE_DATE"));
				u.setNoteBody(rs.getString("NOTE_BODY"));
				u.setUserId(rs.getInt("USER_ID"));
				userList.add(u);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			return userList;
		}
	}

	public void saveNote(Note u) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(connectionString, userName,
					password);

			String sql;
			if (u.getNoteId() == 0) {
				sql = "INSERT INTO NOTE(NOTE_NAME,NOTE_DATE,NOTE_BODY,USER_ID) VALUES (?,?,?,?)";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, u.getNoteName());
				if (u.getDate() != null)
					stmt.setDate(2, new Date(u.getDate().getTime()));
				else {
					stmt.setDate(2, new Date(new java.util.Date().getTime()));
				}
				stmt.setString(3, u.getNoteBody());
				stmt.setInt(4, u.getUserId());
				stmt.executeUpdate();
				// add note
			} else {
				sql = "UPDATE NOTE SET NOTE_NAME=?, NOTE_DATE=?, NOTE_BODY=?, USER_ID=? WHERE NOTE_ID = ?";
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, u.getNoteName());
				if (u.getDate() != null)
					stmt.setDate(2, new Date(u.getDate().getTime()));
				else {
					stmt.setDate(2, new Date(new java.util.Date().getTime()));
				}
				stmt.setString(3, u.getNoteBody());
				stmt.setInt(4, u.getUserId());
				stmt.setInt(5, u.getNoteId());
				stmt.executeUpdate();
				// update note
			}

			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}
	}
	public void deleteNote(int noteId) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			Class.forName(jdbcDriver);
			conn = DriverManager.getConnection(connectionString, userName,
					password);

			String sql = "DELETE FROM NOTE WHERE NOTE_ID=?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, noteId);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}
	}

}
