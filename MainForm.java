import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class MainForm {
    private JPanel mainPanel;
    private JButton button;
    private JTextArea surnameArea;
    private JLabel surnameLabel;
    private JLabel nameLabel;
    private JTextArea nameArea;
    private JLabel fathersNameLabel;
    private JTextArea fathersNameArea;


    public JPanel getMainPanel(){
        return mainPanel;
    }
    public MainForm(){
        surnameArea.setSize(200, 50);
        nameArea.setSize(200, 50);
        fathersNameArea.setSize(200, 50);
        button.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                if(button.getText().equals("Collapse")){
                    if(surnameArea.getText().isEmpty() || nameArea.getText().isEmpty()){
                        JOptionPane.showMessageDialog(new JFrame(), "Данные введены некорректно! \n" +
                                "Попробуйте еще раз", "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
                    } else {
                        nameArea.setVisible(false);
                        nameLabel.setVisible(false);
                        fathersNameArea.setVisible(false);
                        fathersNameLabel.setVisible(false);
                        surnameLabel.setText("Ф.И.О.: ");
                        surnameArea.setText(surnameArea.getText() + " " + nameArea.getText() + " " +
                                fathersNameArea.getText());
                        button.setText("Expand");
                    }
                } else if(button.getText().equals("Expand")){
                    var fio = surnameArea.getText().split("\s");
                    if (fio.length < 2 || fio.length > 3){
                        JOptionPane.showMessageDialog(new JFrame(), "Данные введены некорректно! \n" +
                                "Попробуйте еще раз", "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
                    } else {
                        surnameArea.setSize(250, 50);
                        surnameLabel.setText("Фамилия: ");
                        surnameArea.setText(fio[0]);
                        nameLabel.setVisible(true);
                        nameArea.setVisible(true);
                        nameArea.setText(fio[1]);
                        if (fio.length == 3){
                            fathersNameLabel.setVisible(true);
                            fathersNameArea.setVisible(true);
                            fathersNameArea.setText(fio[2]);
                        }
                        button.setText("Collapse");
                    }
                }
            }
        });
    }
}
