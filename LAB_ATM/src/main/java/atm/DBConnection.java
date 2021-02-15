package atm;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static String URL = "jdbc:postgresql://localhost:5432/atm_db";

    private static String USERNAME = "postgres";
    private static String PASSWORD = "postgres";

    private static Connection connection;
//
//    static {
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        try {
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }

    public void open() throws Exception{
        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
    public void doInit() {
        try {
            open();
        } catch (Exception ex) {
            System.out.println("Connection failed!");
            System.out.println(ex);
        }
    }

    public void close() throws Exception{
        connection.close();
    }

    public void doDestroy() {
        try {
            close();
        } catch (Exception ex) {
            System.out.println("Connection failed!");
            System.out.println(ex);
        }
    }

    public ArrayList<cardDataBase> card(){
        ArrayList<cardDataBase> cardDataBases = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Card";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()){
                cardDataBase cardDataBase = new cardDataBase();
                cardDataBase.setCardNum(resultSet.getString("cardnum"));
                cardDataBase.setPassword(resultSet.getString("password"));
                cardDataBase.setBalance(resultSet.getInt("balance"));

                cardDataBases.add(cardDataBase);
                System.out.println(cardDataBases);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cardDataBases;
    }

    public void topUp(int num, String cardN){
        try {
            String SQL = "UPDATE card SET balance = balance + ? WHERE cardnum = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, num);
            preparedStatement.setString(2, cardN);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("OK!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void withDraw(int num,String cardN){
        try {
            String SQL = "UPDATE card SET balance = balance - ?  WHERE cardnum = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1, num);
            preparedStatement.setString(2, cardN);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("OK!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
