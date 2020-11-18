import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//db접속정보 필요
				//드라이버 정보(다운로드받은거) 어떤 dbms드라이버인지 알려줄라고
				String driver="com.mysql.cj.jdbc.Driver"; //localhost내컴퓨터
				//dbms주소
				String url="jdbc:mysql://localhost:3306/t1?servTimeZone=UTC";;
				//사용자계정
				String user="sbsst";
				//사용자비밀번호
				String pass="sbs123414";	
				Class.forName(driver); //driver세팅
				Connection conn = DriverManager.getConnection(url,user,pass); //dbms선택->담당자 connection부여받음
				//=================================조회====================================
				String sql="SELECT * FROM article";
				PreparedStatement pstmt = conn.prepareStatement(sql); //prepareStatement를 통해서 sql세팅
				ResultSet rs = pstmt.executeQuery(); //조회결과 있는경우 구분해서 쓸 줄 알아야함 resultset상자에 담아지게됨
				pstmt.executeUpdate(); //조회결과 없는경우
				
				while(rs.next()) {
					String title = rs.getString("title");
					int id = rs.getInt("id");
					String body = rs.getString("body");
					String nickname = rs.getString("nickname");
					System.out.println(id + " "+ title + " " + body + " " + nickname + " ");	
				}
				//================================삽입==============================================
				String sql2 = "INSERT INTO article SET title = 'aaa' ,`body` = 'bbb',  nickname = '홍길동', hit = 10";
				pstmt.executeUpdate(sql2);
	}
}
