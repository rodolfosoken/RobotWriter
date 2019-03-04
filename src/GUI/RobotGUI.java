package GUI;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.FlavorEvent;
import java.awt.datatransfer.FlavorListener;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author Rodolfo
 */
public class RobotGUI extends javax.swing.JFrame {
    
    Robot robot;
    int status;
    boolean goodToGo = false;

    /**
     * Creates new form RobotGUI
     */
    public RobotGUI() {
        initComponents();
        try {
            robot = new Robot();
        } catch (AWTException ex) {
            JOptionPane.showConfirmDialog(this, "Erro ao criar Bot: "
                    + ex.getLocalizedMessage(), "Error", JOptionPane.ERROR);
            Logger.getLogger(RobotGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Toolkit.getDefaultToolkit().getSystemClipboard().addFlavorListener(new FlavorListener() {
            @Override
            public void flavorsChanged(FlavorEvent e) {
                try {
                    if (Toolkit.getDefaultToolkit().getSystemClipboard().isDataFlavorAvailable(DataFlavor.stringFlavor)) {
                        jTextArea1.setText(Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor).toString());
                        if(jCheckBoxInit.isSelected())
                            jButtonDigitar.doClick();
                    }
                } catch (UnsupportedFlavorException ex) {
                    Logger.getLogger(RobotGUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(RobotGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
    }
    
    public void sendKeys(Robot robot, String keys) {
        status = 0;
        int count = 0;
        int delay = Integer.parseInt(jFormattedTextField1.getText());
        updateStatus("Iniciando digitação...");
        jProgressBar1.setMaximum(keys.length());
        for (char c : keys.toCharArray()) {
            if (!goodToGo) {
                updateStatus("Operação Cancelada pelo usuário.");
                break;
            }
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            if (KeyEvent.CHAR_UNDEFINED == keyCode) {
                jLabelStatus.setText("Erro ao processar caractere:' " + c + " ' keycode= " + keyCode);
                throw new RuntimeException(
                        "Key code not found for character '" + c + "'");
            }
            try {
                boolean isUpper = false;
                if (Character.isUpperCase(c)) {
                    isUpper = true;
                    robot.keyPress(KeyEvent.VK_CAPS_LOCK);
                    robot.delay(delay);
                    robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
                }
                
                if (Character.toString(c).equals("?")) {
                    robot.keyPress(KeyEvent.VK_ALT);
                    robot.delay(delay);
                    robot.keyPress(KeyEvent.VK_NUMPAD6);
                    robot.delay(delay);
                    robot.keyRelease(KeyEvent.VK_NUMPAD6);
                    robot.delay(delay);
                    robot.keyPress(KeyEvent.VK_NUMPAD3);
                    robot.delay(delay);
                    robot.keyRelease(KeyEvent.VK_NUMPAD3);
                    robot.delay(delay);
                    robot.keyRelease(KeyEvent.VK_ALT);
                    robot.delay(delay);
                } else if ((Character.toString(c).toLowerCase()).equals("ã")) {
                    robot.keyPress(KeyEvent.VK_A);
                    robot.delay(delay);
                    robot.keyRelease(KeyEvent.VK_A);
                    robot.delay(delay);
                } else if ((Character.toString(c).toLowerCase()).equals("à")) {
                    robot.keyPress(KeyEvent.VK_A);
                    robot.delay(delay);
                    robot.keyRelease(KeyEvent.VK_A);
                    robot.delay(delay);
                } else if ((Character.toString(c).toLowerCase()).equals("á")) {
                    robot.keyPress(KeyEvent.VK_A);
                    robot.delay(delay);
                    robot.keyRelease(KeyEvent.VK_A);
                    robot.delay(delay);
                } else if ((Character.toString(c).toLowerCase()).equals("â")) {
                    robot.keyPress(KeyEvent.VK_A);
                    robot.delay(delay);
                    robot.keyRelease(KeyEvent.VK_A);
                    robot.delay(delay);
                } else if ((Character.toString(c).toLowerCase()).equals("é")) {
                    robot.keyPress(KeyEvent.VK_E);
                    robot.delay(delay);
                    robot.keyRelease(KeyEvent.VK_E);
                    robot.delay(delay);
                } else if ((Character.toString(c).toLowerCase()).equals("ê")) {
                    robot.keyPress(KeyEvent.VK_E);
                    robot.delay(delay);
                    robot.keyRelease(KeyEvent.VK_E);
                    robot.delay(delay);
                } else if ((Character.toString(c).toLowerCase()).equals("í")) {
                    robot.keyPress(KeyEvent.VK_I);
                    robot.delay(delay);
                    robot.keyRelease(KeyEvent.VK_I);
                    robot.delay(delay);
                } else if ((Character.toString(c).toLowerCase()).equals("õ")) {
                    robot.keyPress(KeyEvent.VK_O);
                    robot.delay(delay);
                    robot.keyRelease(KeyEvent.VK_O);
                    robot.delay(delay);
                } else if ((Character.toString(c).toLowerCase()).equals("ó")) {
                    robot.keyPress(KeyEvent.VK_O);
                    robot.delay(delay);
                    robot.keyRelease(KeyEvent.VK_O);
                    robot.delay(delay);
                } else if ((Character.toString(c).toLowerCase()).equals("ú")) {
                    robot.keyPress(KeyEvent.VK_U);
                    robot.delay(delay);
                    robot.keyRelease(KeyEvent.VK_U);
                    robot.delay(delay);
                } else if (keyCode == 0 && !Character.toString(c).equals("%")) {
                    goodToGo = false;
                    jButtonCancelar.setEnabled(goodToGo);
                    jButtonDigitar.setEnabled(!goodToGo);
                    throw new RuntimeException("Erro ao processar caractere:' " + c + " ' keycode= " + keyCode);
                } else {
                    switch (keyCode) {
                        case KeyEvent.VK_EXCLAMATION_MARK:
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            robot.keyPress(KeyEvent.VK_1);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_1);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            break;
                        case KeyEvent.VK_BRACELEFT:
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            robot.keyPress(KeyEvent.VK_OPEN_BRACKET);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_OPEN_BRACKET);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            break;
                        case KeyEvent.VK_BRACERIGHT:
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_CLOSE_BRACKET);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            break;
                        case KeyEvent.VK_LEFT_PARENTHESIS:
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            robot.keyPress(KeyEvent.VK_9);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_9);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            break;
                        case KeyEvent.VK_RIGHT_PARENTHESIS:
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            robot.keyPress(KeyEvent.VK_0);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_0);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            break;
                        case KeyEvent.VK_UNDERSCORE:
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            robot.keyPress(KeyEvent.VK_MINUS);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_MINUS);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            break;
                        case KeyEvent.VK_COLON:
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            robot.keyPress(KeyEvent.VK_SEMICOLON);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_SEMICOLON);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            break;
                        case KeyEvent.VK_QUOTEDBL:
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            robot.keyPress(KeyEvent.VK_QUOTE);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_QUOTE);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            break;
                        case KeyEvent.VK_AT:
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            robot.keyPress(KeyEvent.VK_2);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_2);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            break;
                        case KeyEvent.VK_NUMBER_SIGN:
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            robot.keyPress(KeyEvent.VK_3);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_3);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            break;
                        case KeyEvent.VK_DOLLAR:
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            robot.keyPress(KeyEvent.VK_4);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_4);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            break;
                        case 0:
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            robot.keyPress(KeyEvent.VK_5);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_5);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            break;
                        case KeyEvent.VK_AMPERSAND:
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            robot.keyPress(KeyEvent.VK_7);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_7);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            break;
                        case KeyEvent.VK_ASTERISK:
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            robot.keyPress(KeyEvent.VK_8);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_8);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            break;
                        case KeyEvent.VK_PLUS:
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            robot.keyPress(KeyEvent.VK_EQUALS);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_EQUALS);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            break;
                        case KeyEvent.VK_LESS:
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            robot.keyPress(KeyEvent.VK_COMMA);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_COMMA);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            break;
                        case KeyEvent.VK_GREATER:
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            robot.keyPress(KeyEvent.VK_PERIOD);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_PERIOD);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            break;
                        case KeyEvent.VK_BACK_QUOTE:
                            robot.keyPress(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            robot.keyPress(KeyEvent.VK_DEAD_ACUTE);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_DEAD_ACUTE);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_SHIFT);
                            robot.delay(delay);
                            robot.keyPress(KeyEvent.VK_SPACE);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_SPACE);
                            robot.delay(delay);
                            break;
                        case 16777396:
                            robot.keyPress(KeyEvent.VK_DEAD_ACUTE);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_DEAD_ACUTE);
                            robot.delay(delay);
                            robot.keyPress(KeyEvent.VK_SPACE);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_SPACE);
                            robot.delay(delay);
                            break;
                        case 16777415:
                            robot.keyPress(KeyEvent.VK_C);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_C);
                            robot.delay(delay);
                            break;
                        case KeyEvent.VK_SLASH:
                            robot.keyPress(KeyEvent.VK_ALT);
                            robot.delay(delay);
                            robot.keyPress(KeyEvent.VK_NUMPAD0);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_NUMPAD0);
                            robot.delay(delay);
                            robot.keyPress(KeyEvent.VK_NUMPAD0);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_NUMPAD0);
                            robot.delay(delay);
                            robot.keyPress(KeyEvent.VK_NUMPAD4);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_NUMPAD4);
                            robot.delay(delay);
                            robot.keyPress(KeyEvent.VK_NUMPAD7);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_NUMPAD7);
                            robot.delay(delay);
                            robot.keyRelease(KeyEvent.VK_ALT);
                            robot.delay(delay);
                            break;
                        default:
                            robot.keyPress(keyCode);
                            robot.delay(delay);
                            robot.keyRelease(keyCode);
                            robot.delay(delay);
                            break;
                    };
                    if (isUpper) {
                        robot.keyPress(KeyEvent.VK_CAPS_LOCK);
                        robot.delay(delay);
                        robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
                    }
                }
                
                status = ++count;
                updateStatus((int) (jProgressBar1.getPercentComplete() * 100) + "% ...");
            } catch (Exception ex) {
                jLabelStatus.setText("Erro ao processar caractere:' " + c + " ' keycode= " + keyCode
                        + ". Erro: " + ex.getLocalizedMessage());
                jProgressBar1.setBackground(Color.red);
                goodToGo = false;
                jButtonCancelar.setEnabled(goodToGo);
                jButtonDigitar.setEnabled(!goodToGo);
                throw new RuntimeException("Erro ao processar caractere:' " + c + " ' keycode= " + keyCode
                        + ". Erro: " + ex.getLocalizedMessage());
            }
        }
        if (goodToGo) {
            jProgressBar1.setValue(keys.length());
            updateStatus("Digitação concluída com sucesso!");
            goodToGo = false;
            jButtonCancelar.setEnabled(goodToGo);
            jButtonDigitar.setEnabled(!goodToGo);
        }
    }
    
    public void updateStatus(String message) {
        jProgressBar1.setValue(status);
        jLabelStatus.setText("Status: " + message);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButtonDigitar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextFieldTime = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jButtonCancelar = new javax.swing.JButton();
        jCheckBoxInit = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Robot Writer");

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setDragEnabled(true);
        jScrollPane1.setViewportView(jTextArea1);

        jButtonDigitar.setText("Digitar");
        jButtonDigitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDigitarActionPerformed(evt);
            }
        });

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jProgressBar1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Insira o Texto a ser Digitado pelo Bot:");

        jLabelStatus.setText("Status: ");

        jLabel3.setText("Tempo de Espera (ms):");

        jFormattedTextFieldTime.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextFieldTime.setText("5000");

        jLabel2.setText("Tempo digitação (ms):");

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextField1.setText("10");

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jCheckBoxInit.setText("Iniciar Automaticamente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
        					.addComponent(jCheckBoxInit))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel3)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(jFormattedTextFieldTime, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(jLabel2)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jFormattedTextField1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
        				.addComponent(jLabelStatus)
        				.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
        				.addComponent(jProgressBar1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(jButtonDigitar, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
        				.addComponent(jButtonCancelar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(jButtonLimpar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(jFormattedTextFieldTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel2)
        				.addComponent(jFormattedTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jCheckBoxInit))
        			.addGap(11)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jButtonLimpar)
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jProgressBar1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jLabelStatus)
        					.addContainerGap(29, Short.MAX_VALUE))
        				.addGroup(layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(jButtonDigitar)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jButtonCancelar)
        					.addContainerGap())))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>                        

    private void jButtonDigitarActionPerformed(java.awt.event.ActionEvent evt) {                                               
        int time = Integer.parseInt(jFormattedTextFieldTime.getText());
        jProgressBar1.setMaximum(time);
        Runnable run = () -> {
            try {
                // TODO add your handling code here:
                jLabelStatus.setText("Iniciando digitação em " + time + " ms...");
                goodToGo = true;
                jButtonCancelar.setEnabled(goodToGo);
                jButtonDigitar.setEnabled(!goodToGo);
                for (int i = 0; i < time; i++) {
                    if (!goodToGo) {
                        jButtonCancelar.setEnabled(goodToGo);
                        jButtonDigitar.setEnabled(!goodToGo);
                        updateStatus("Operação Cancelada pelo usuário.");
                        break;
                    }
                    status = i;
                    updateStatus("Tempo de espera..." + i + " ms.");
                    Thread.sleep(1);
                }
                
            } catch (InterruptedException ex) {
                JOptionPane.showConfirmDialog(this, "Erro ao pausar a thread: "
                        + ex.getLocalizedMessage(), "Error: Thread sleep.", JOptionPane.ERROR);
                Logger.getLogger(RobotGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            sendKeys(robot, jTextArea1.getText());
        };
        Thread thread = new Thread(run);
        thread.start();
    }                                              

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        jTextArea1.setText("");
        status = 0;
        updateStatus("Área de Texo limpa.");
    }                                             

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
        goodToGo = false;
        jButtonCancelar.setEnabled(goodToGo);
        jButtonDigitar.setEnabled(!goodToGo);
    }                                               

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RobotGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RobotGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RobotGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RobotGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RobotGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonDigitar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JCheckBox jCheckBoxInit;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextFieldTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration                   
}
