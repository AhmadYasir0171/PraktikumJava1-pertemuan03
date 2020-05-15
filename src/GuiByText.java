import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiByText extends JFrame {


    JLabel label1 = new JLabel("Masukkan Nama");
    JTextField textField1 = new JTextField();
    JButton button1 = new JButton("Greet");

    JLabel label2 = new JLabel("Panjang");
    JLabel label3 = new JLabel("Lebar");
    JLabel label4 = new JLabel("Hasil");
    JTextField tPanjang = new JTextField();
    JTextField tLebar = new JTextField();
    JTextField tHasil = new JTextField();
    JButton bHitung = new JButton("Hitung Luas");

    JButton bKlik = new JButton("Ganti Warna");
    Container konten = getContentPane();
    JColorChooser handler = new JColorChooser();
    Color color = Color.BLUE;

    GuiByText(){
        setSize(640,480);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        konten.setLayout(new FlowLayout(FlowLayout.CENTER));
        konten.add(bKlik);

    }

    void meletakkanKomponen(){
        getContentPane().setLayout(null);

        getContentPane().add(label1);
        getContentPane().add(textField1);
        getContentPane().add(button1);
        getContentPane().add(label2);
        getContentPane().add(label3);
        getContentPane().add(label4);
        getContentPane().add(tPanjang);
        getContentPane().add(tLebar);
        getContentPane().add(tHasil);
        getContentPane().add(bHitung);
        getContentPane().add(bKlik);

        label1.setBounds(16,32,100,25);
        textField1.setBounds(124,32,100,25);
        button1.setBounds(232,32,80,25);
        label2.setBounds(16,80,100,25);
        tPanjang.setBounds(124,80,100,25);
        label3.setBounds(16,113,100,25);
        tLebar.setBounds(124,113,100,25);
        bHitung.setBounds(16,146,208,25);
        label4.setBounds(16,179,100,25);
        tHasil.setBounds(124,179,100,25);
        bKlik.setBounds(232,179,100,25);
    }

    void menambhakanListener(){
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String nama = textField1.getText();
                JOptionPane.showMessageDialog(null, "Hai " + nama);
            }
        });
        bHitung.addActionListener(actionEvent ->{
            int panjang = Integer.parseInt(tPanjang.getText());
            int lebar = Integer.parseInt(tLebar.getText());

            int hasil = panjang * lebar;
            String sHasil = String.valueOf(hasil);

            tHasil.setText(sHasil);
        });
        bKlik.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent act) {
                color = handler.showDialog(GuiByText.this, "Pilih Warna", color);
                if(color == null){
                    color = Color.BLUE;
                }else{
                    konten.setBackground(color);
                }
            }
        });
    }

    public static void main(String[] args) {
        GuiByText guiByText = new GuiByText();
        guiByText.meletakkanKomponen();
        guiByText.setVisible(true);
        guiByText.menambhakanListener();
    }
}
