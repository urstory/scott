package my.examples.scott.jdbcexam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectExam {
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");

        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/scott?useUnicode=yes&characterEncoding=UTF-8","scott","scott")){

            String sql = "select empno, name, job from employee";

            try(PreparedStatement ps = conn.prepareStatement(sql)){
                try(ResultSet rs = ps.executeQuery()){
                    while(rs.next()) {
                        int empno = rs.getInt(1);
                        String name = rs.getString(2);
                        String job = rs.getString(3);
                        System.out.println(empno + "," + name + "," + job);
                    }
                }
            }

        }
    }
}

