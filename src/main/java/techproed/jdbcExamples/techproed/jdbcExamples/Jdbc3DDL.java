package techproed.jdbcExamples.techproed.jdbcExamples;

import java.sql.*;

public class Jdbc3DDL {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String yol = "jdbc:oracle:thin:@localhost:1521/ORCLCDB.localdomain";

		Class.forName("oracle.jdbc.driver.OracleDriver");

		Connection con = DriverManager.getConnection(yol, "emre_guduk", "1234");

		Statement st = con.createStatement();

		/*
		 
		  A) CREATE TABLE, DROP TABLE, ALTER TABLE gibi DDL ifadeleri icin sonuc kümesi
		  (ResultSet) dondurmeyen metotlar kullanilmalidir. Bunun icin JDBC’de 2
		  alternatif bulunmaktadir. 
			  1) execute() metodu 
			  2) excuteUpdate() metodu.
		  
		  B) - execute() metodu hertur SQL ifadesiyle kullanibilen genel bir komuttur.
		  - execute(), Boolean bir deger dondurur. DDL islemlerin false dondururken, -
		  DML islemlerinde true deger dondurur. - Ozellikle hangi tip SQL ifadesinin
		  kullanilmasinin gerektiginin belli olmadigi durumlarda tercih edilmektedir.
		  
		  C) - executeUpdate() metodu ise INSERT, Update gibi DML islemlerinde yaygin
		  kullanilir. - bu islemlerde islemden etkilenen satir sayisini dondurur. -
		  Ayrıca, DDL islemlerinde de kullanilabilir ve bu islemlerde 0 dondurur.
		 
		 */
		
		
		//ORNEK2:isciler adinda bir tablo olusturunuz id NUMBER(3), 
		//birim VARCHAR2(10), maas NUMBER(5)
		
		String createQuery = "CREATE TABLE isciler"
				         + " (id NUMBER(3),"
					     + " birim VARCHAR2(10),"
					     + " maas NUMBER(5))";
		
		//1.YONTEM => (excute()method'u ile)
		
		//boolean s1 = st.execute(createQuery); // false deger dondurecek (DDL)
		//System.out.println("isciler tablosu olusturuldu " + s1);
		
		//st.execute(createQuery); 
		//System.out.println("isciler tablosu olusturuldu..");
		
		//2.YONTEM => (executeUpdate()method'u ile)
		//int s2 = st.executeUpdate(createQuery); // DDL islemleri 0 degerinin döndürür
		//System.out.println("isciler tablosu olusturuldu.." + s2);
		
		//st.executeUpdate(createQuery);
		//System.out.println("isciler tablosu olusturuldu..");
		
		// ORNEK1:isciler tablosunu kalici olarak siliniz 
		
		//String dropQuery1 = "DROP TABLE isciler PURGE";
		//st.execute(dropQuery1);
		//System.out.println("isciler tablosu silindi..");
		
		// ORNEK3:isciler tablosuna yeni bir sutun {isim Varchar2(20)} ekleyiniz. 
		
		//String alterQuery1 = "ALTER TABLE isciler ADD isim VARCHAR2(20)";
		//st.executeUpdate(alterQuery1);
		//System.out.println("isciler tablosuna isim sutunu eklendi..");
		
		// ORNEK4:isciler tablosuna soyisim VARCHAR2(20) ve sehir VARCHAR2(10)) 
	    // adinda 2 yeni sutun ekleyiniz.
		
		//String alterQuery2 = "ALTER TABLE isciler ADD (soyisim VARCHAR2(20),"
				//+ " sehir VARCHAR2(10))";
		//st.execute(alterQuery2);
		//System.out.println("isciler tablosuna soyisim ve sehir sutunu eklendi");
		
		// ORNEK5:isciler tablosundaki soyisim sutunu siliniz.
		
		//String alterQuery3 = "ALTER TABLE isciler DROP COLUMN soyisim";
		//st.execute(alterQuery3);
		//System.out.println("isciler tablosuna soyisim sutunu silindi");
		
		// ORNEK6:isciler tablosununadini calisanlar olarak degistiriniz.
		
		//String alterQuery4 = "ALTER TABLE isciler RENAME TO calisanlar1";
		//st.execute(alterQuery4);
		//System.out.println("isciler tablosunun adi calisanlar olarak degistirildi..");
		
		con.close();
		st.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
