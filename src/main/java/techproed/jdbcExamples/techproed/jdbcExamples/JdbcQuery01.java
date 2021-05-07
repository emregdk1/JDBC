package techproed.jdbcExamples.techproed.jdbcExamples;

import java.sql.*;
;

public class JdbcQuery01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.Adim => ilgili driver'i yuklemeliyiz
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2.Adim => baglanti olusturmaliyiz
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost"
				+ ":1521/ORCLCDB.localdomain", "emre_guduk", "1234");
		
		//3.Adim => SQL komutlari icin bir Statement nesnesi olustur
		Statement st = con.createStatement();
		
		//4.Adim => SQL ifadelerini yazabiliriz ve calistirabiliriz
		//(Personel tablosundaki personel_id'si 7369 olan personelin adini sorgulayin)
		
		ResultSet isim = st.executeQuery
				("SELECT personel_isim, maas FROM personel WHERE personel_id=7369");
		
		//5.Adim => 
		while (isim.next()) {
			System.out.println("Personel Adi : " + isim.getString("personel_isim"));
			System.out.println("Personel Adi : " + isim.getString(1) + " Maas : " + isim.getInt(2));
		}
		
		//6.Adim => Olusturulan nesneleri bellekten kaldiralim
		con.close();
		st.close();
		isim.close();
		
		
		
		

	}

}
