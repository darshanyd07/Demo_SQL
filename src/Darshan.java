import java.io.*;
import java.sql.*;

public class Darshan
{
    public static void main(String darsh[])throws IOException
    {
        DataInputStream d = new DataInputStream(System.in);

        try{
            System.out.println("----------SQL Operations------------");
            String dbURL = "jdbc:mysql://localhost/demo";
            System.out.println("DataBase Has Connected");
            String username = "root";
            String password = "yuktadarsh";
            Connection conn = DriverManager.getConnection(dbURL,username,password);
            Statement stmt = conn.createStatement();
            String nameT = null;

            System.out.println("You want to Create Table ?");
            String state = d.readLine();
            if( state.equals("yes"))
            {
                System.out.println("Enter Table Name");
                nameT = d.readLine();

                String create = " create table "+nameT+ "(nid int primary key,Name varchar(30) NOT NULL,age int NOT NULL,city varchar(30)NOT NULL)";
                stmt.executeUpdate(create);
                System.out.println(nameT+" Table  Created");
            }
            else if(state.equals("no"))
            {
                System.out.println("Ok Darsh....");
            }


            System.out.println("You Want To Insert Rows ? ");
            String in_sta = d.readLine();
            if( in_sta.equals("yes"))
            {
                System.out.println("How Many Rows You Want ? ");
                int num = Integer.parseInt(d.readLine());

                for( int i = 0 ; i<num;i++)
                {
                    System.out.println("Enter ID ");
                    int id = Integer.parseInt(d.readLine());

                    System.out.println("Enter Name ");
                    String name = d.readLine();
                    System.out.println("Enter Age ");
                    int age = Integer.parseInt(d.readLine());


                    System.out.println("Enter City ");
                    String city = d.readLine();

                    String inserT ="insert into "+nameT+" values("+id+",'"+name+"',"+age+",'"+city+"');";
                    PreparedStatement st = conn.prepareStatement(inserT);
                    st.execute();
                    System.out.println("Insert Records Successfully");
                }

            }
            else if(in_sta.equals("no"))
            {
                System.out.println("Ok Darsh....");
            }


            System.out.println("You want Delate Some Records");
            String del_sta = d.readLine();

            if( del_sta.equals("yes"))
            {
                System.out.println("How Many Rows You Want ? ");
                int del_num = Integer.parseInt(d.readLine());

                for(int j = 0;j < del_num;j++)
                {
                    System.out.println("Enter delate  ID you want to delete ");
                    int del_id = Integer.parseInt(d.readLine());
                    String delete = " delete from "+nameT+ " where nid  = "+del_id+"";
//						Statement stmt = conn.createStatement();
                    stmt.executeUpdate(delete);
                    System.out.println("Delete Record Successfully");
//						System.exit(0);
                }
            }
            else if(del_sta.equals("no"))
            {
                System.out.println("Ok Darsh....");
            }


            System.out.println("You want Update Some Records");
            String upa_sta = d.readLine();

					if( upa_sta.equals("yes"))
					{
						System.out.println("How Many Rows You Want Update ? ");
						int upa_num = Integer.parseInt(d.readLine());
						for(int y = 0;y < upa_num;y++)
						{
						System.out.println("Enter You Want Update Name ");
						String up_name = d.readLine();

						System.out.println("Enter You Want that update Id    ");
						int up_id = Integer.parseInt(d.readLine());

						String update = "update  " +nameT+ "  set Name  = '"+up_name+"'  where nid = " +up_id+";";
						stmt.executeUpdate(update);
						System.out.println("Update Record Successfully");
					}

					}
					else if(upa_sta.equals("no"))
					{
						System.out.println("Ok Darsh....");


					}


        System.out.println("You Want To Table Display ? ");
        String se_sta = d.readLine();
        if(se_sta.equals("yes"))
        {
            System.out.println("Enter Table Name ");
            String table = d.readLine();
            String sql = "select * from "+table+";";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("eid   ename  age   city");
            System.out.println("-----------------------------");
            while (rs.next())
            {
                int eid = rs.getInt("nid");
                String ename = rs.getString("Name");
                int eage = rs.getInt("age");
                String ecity = rs.getString("city");
                System.out.println(+eid+"   "+ename+"   "+eage+"  "+ecity);
            }
            System.out.println("-----------------------------");
            System.out.println("Display Table  Successfully");
            System.out.println("-----------------------------");
            System.exit(0);

        }
        else if(se_sta.equals("no"))
        {
            System.out.println("Exit Successfully");
            System.exit(0);
        }
        conn.close();
    }
        catch(Exception e)
    {
        System.out.print(e);
    }
    }
}
