package com.extremelf.Forms;


public class main {
    public static void main(String[] args) {
       /* String dbURL = "jdbc:oracle:thin:@localhost:1521:XE";
        String username = "DataBaseProj";
        String password = "123";


        try {
            Connection connection = DriverManager.getConnection(dbURL, username, password);
            System.out.println("Connected successfully");

            String sql = "INSERT INTO CARGO (DESCRICAO) VALUES (?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1,"Teste");

            int rows = statement.executeUpdate();

            if(rows > 0){
                System.out.println("A row has been selected");
            }
            statement.close();
            connection.close();

        } catch(SQLException e){
            System.out.println("Error connecting database: ");
            e.printStackTrace();
        }


        */


        new start();



    }

}
