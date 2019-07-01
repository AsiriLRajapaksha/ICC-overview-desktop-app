import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class cricket extends JFrame{
    private JPanel panel1;
    private JButton button1;
    private JTextField textField1;
    private JComboBox comboBox1;
    private JTextField textField3;
    private JTable table1;
    private JTextField textField2;
    private JComboBox comboBox2;
    private JPanel label1;
    private JLabel Label2;
    private JLabel Label1;
    private JTextField textField4;

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;


    public static void main(String[] args) {
        JFrame frame = new JFrame("cricket");
        frame.setContentPane(new cricket().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public cricket() {

        con = (Connection) DBconnection.connect();
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{

                    String mid = textField4.getText();

                    String q = "select * from overview where id="+mid+" " ;
                    pst = con.prepareStatement(q);
                    rs=pst.executeQuery();

                    while(rs.next()){


                        String tm1_country = rs.getString("tm1_country"); //from database
                        String tm2_country = rs.getString("tm2_country");
                        String tm_won = rs.getString("tm_won");
                        String tm1_summary = rs.getString("tm1_summary");
                        String tm2_summary = rs.getString("tm2_summary");


                        String c1 = tm1_country ;
                        String c2 = tm2_country ;
                        String s1 = tm1_summary ;
                        String s2 = tm2_summary ;
                        String w =tm_won;

                        textField1.setText(s1);
                        textField2.setText(s2);
                        textField3.setText(w);
                        Label2.setText(c2);
                        Label1.setText(c1);

                    }
                }catch (Exception e){

                }
            }
        });


        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try{

                    String ining = (String) comboBox1.getSelectedItem();

                    String q = "select * from "+ining+" ";
                    pst = con.prepareStatement(q);
                    rs=pst.executeQuery();

                    while(rs.next()){

                        table1.setModel(DbUtils.resultSetToTableModel(rs));

                    }
                }catch (Exception e){

                }

            }
        });

    }

}
