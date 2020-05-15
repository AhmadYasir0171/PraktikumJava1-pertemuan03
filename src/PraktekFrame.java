import javax.swing.*;


public class PraktekFrame extends JFrame {
    JLabel judul = new JLabel("BIODATA DIRI");
    JLabel jNama = new JLabel("Nama Lengkap");
    JTextField tNama = new JTextField();
    JLabel jnamaPanggilan = new JLabel("Nama Panggilan");
    JTextField tnamaPanggilan = new JTextField();

    JRadioButton laki = new JRadioButton("Laki-Laki");
    JRadioButton perempuan = new JRadioButton("Perempuan");
    ButtonGroup groupRadio=new ButtonGroup();
    public ButtonGroup getGroupRadio(){
        groupRadio.add(laki);
        groupRadio.add(perempuan);
        return groupRadio;
    }
    JLabel jkelaminn = new JLabel("Jenis Kelamin");

    String[] jpendidikan = {"SD","SLTP","SLTA","S1"};
    JComboBox jp = new JComboBox(jpendidikan);
    JLabel tpendidikan = new JLabel("Pendidikan");

    JLabel jAlamat = new JLabel("Alamat");
    JTextField tAlamat = new JTextField();

    JButton bersih = new JButton("Bersih");
    JButton tampil = new JButton("Tampil");
    JButton keluar = new JButton("Keluar");

    JTextArea aTampil = new JTextArea();


    PraktekFrame() {
        setSize(640, 480);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    void meletakkanKomponen(){
            getContentPane().setLayout(null);
            getContentPane().add(judul);

            getContentPane().add(jNama);
            getContentPane().add(tNama);
            getContentPane().add(jnamaPanggilan);
            getContentPane().add(tnamaPanggilan);

            getContentPane().add(laki);
            getContentPane().add(perempuan);
            getContentPane().add(jkelaminn);

            getContentPane().add(jp);
            getContentPane().add(tpendidikan);

            getContentPane().add(jAlamat);
            getContentPane().add(tAlamat);

            getContentPane().add(keluar);
            getContentPane().add(tampil);
            getContentPane().add(bersih);
            getContentPane().add(aTampil);

            judul.setBounds(100,0,100,25);
            jNama.setBounds(16,32,100,25);
            tNama.setBounds(164,32,185,25);

            jnamaPanggilan.setBounds(16,62,100,25);
            tnamaPanggilan.setBounds(164,62,100,25);

            jkelaminn.setBounds(16,90,100,25);
            laki.setBounds(164,90,100,25);
            perempuan.setBounds(260,90,100,25);

            tpendidikan.setBounds(16,120,100,25);
            jp.setBounds(164,120,100,25);

            jAlamat.setBounds(16,150,100,25);
            tAlamat.setBounds(164,150,185,25);

            keluar.setBounds(232,180,100,25);
            tampil.setBounds(124,180,100,25);
            bersih.setBounds(16,180,100,25);
            aTampil.setBounds(16,220,400,300);
    }

    void menambhakanListener(){
        tampil.addActionListener(actionEvent -> {
            int pilih = JOptionPane.showConfirmDialog(this, "Lanjut Untuk Menampilkan Data?", "Tampil",JOptionPane.INFORMATION_MESSAGE);
            switch(pilih){
                case JOptionPane.YES_OPTION:
                String nama = tNama.getText();
                String namapanggilan = tnamaPanggilan.getText();

                String jKelamin;
                if (laki.isSelected()){
                    jKelamin = "Laki-laki";
                }else{
                    jKelamin = "Perempuan";
                }

                String pendidikan;
                pendidikan= (String)jp.getSelectedItem();

                String alamat = tAlamat.getText();


                aTampil.setText(aTampil.getText()+ "===============BIODATA DIRI================");
                aTampil.setText(aTampil.getText()+ "\nNama              : " +nama);
                aTampil.setText(aTampil.getText()+ "\nNama Panggilan    : " +namapanggilan);
                aTampil.setText(aTampil.getText()+ "\nJenis Kelamin     : " +jKelamin);
                aTampil.setText(aTampil.getText()+ "\nPendidikan        : " +pendidikan);
                aTampil.setText(aTampil.getText()+ "\nAlamat            : " +alamat);
                aTampil.setText(aTampil.getText()+ "\n==========================================\n");
                aTampil.requestFocus();
                break;
            }
        });

        bersih.addActionListener(actionEvent -> {
            int pilih = JOptionPane.showConfirmDialog(this, "Lanjut Untuk Bersihkan data?", "Bersih",JOptionPane.INFORMATION_MESSAGE);
            switch(pilih){
                case JOptionPane.YES_OPTION:
                    aTampil.setText("");
                    tNama.setText("");
                    tnamaPanggilan.setText("");
                    tAlamat.setText("");
                    tNama.requestFocus();
                    break;
            }

        });
        keluar.addActionListener(actionEvent -> {
            int pilih = JOptionPane.showConfirmDialog(this, "Yakin Ingin Keluar?", "Keluar",JOptionPane.INFORMATION_MESSAGE);
            switch(pilih){
                case JOptionPane.YES_OPTION:
                    System.exit(0);
                    break;
            }
        });
    }
}
