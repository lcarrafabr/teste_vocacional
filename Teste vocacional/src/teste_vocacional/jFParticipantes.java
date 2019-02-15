/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * jFParticipantes.java
 *
 * Created on 15/02/2014, 11:44:07
 */

package teste_vocacional;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import teste_vocacional.classes.ClassConecta;
import teste_vocacional.classes.ColorRenderer;

/**
 *
 * @author Luciano Carrafa Benfica
 */
public class jFParticipantes extends javax.swing.JFrame {

    /** Creates new form jFParticipantes */
    public jFParticipantes() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/resources/universitario.png")).getImage());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        totalParticipantesjLabel = new javax.swing.JLabel();
        sairjButton = new javax.swing.JButton();
        carregaInformacoesjButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gradeParticipantesjTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        gerarRelatoriojButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Form"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(teste_vocacional.Teste_vocacionalApp.class).getContext().getResourceMap(jFParticipantes.class);
        jPanel1.setBackground(resourceMap.getColor("jPanel1.background")); // NOI18N
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(1, null, resourceMap.getColor("jPanel1.border.highlightInnerColor"), null, null)); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        totalParticipantesjLabel.setText(resourceMap.getString("totalParticipantesjLabel.text")); // NOI18N
        totalParticipantesjLabel.setName("totalParticipantesjLabel"); // NOI18N

        sairjButton.setIcon(resourceMap.getIcon("sairjButton.icon")); // NOI18N
        sairjButton.setText(resourceMap.getString("sairjButton.text")); // NOI18N
        sairjButton.setToolTipText(resourceMap.getString("sairjButton.toolTipText")); // NOI18N
        sairjButton.setContentAreaFilled(false);
        sairjButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sairjButton.setName("sairjButton"); // NOI18N
        sairjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairjButtonActionPerformed(evt);
            }
        });

        carregaInformacoesjButton.setText(resourceMap.getString("carregaInformacoesjButton.text")); // NOI18N
        carregaInformacoesjButton.setContentAreaFilled(false);
        carregaInformacoesjButton.setName("carregaInformacoesjButton"); // NOI18N
        carregaInformacoesjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregaInformacoesjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(totalParticipantesjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 444, Short.MAX_VALUE)
                .addComponent(carregaInformacoesjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(sairjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(carregaInformacoesjButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(totalParticipantesjLabel))))
                    .addComponent(sairjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setName("jPanel2"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        gradeParticipantesjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id#", "Participante", "Cidade", "UF", "Telefone", "Email", "Vocação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        gradeParticipantesjTable.setName("gradeParticipantesjTable"); // NOI18N
        gradeParticipantesjTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(gradeParticipantesjTable);
        gradeParticipantesjTable.getColumnModel().getColumn(0).setResizable(false);
        gradeParticipantesjTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        gradeParticipantesjTable.getColumnModel().getColumn(0).setHeaderValue(resourceMap.getString("gradeParticipantesjTable.columnModel.title0")); // NOI18N
        gradeParticipantesjTable.getColumnModel().getColumn(1).setResizable(false);
        gradeParticipantesjTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        gradeParticipantesjTable.getColumnModel().getColumn(1).setHeaderValue(resourceMap.getString("gradeParticipantesjTable.columnModel.title1")); // NOI18N
        gradeParticipantesjTable.getColumnModel().getColumn(2).setResizable(false);
        gradeParticipantesjTable.getColumnModel().getColumn(2).setPreferredWidth(60);
        gradeParticipantesjTable.getColumnModel().getColumn(2).setHeaderValue(resourceMap.getString("gradeParticipantesjTable.columnModel.title2")); // NOI18N
        gradeParticipantesjTable.getColumnModel().getColumn(3).setResizable(false);
        gradeParticipantesjTable.getColumnModel().getColumn(3).setPreferredWidth(1);
        gradeParticipantesjTable.getColumnModel().getColumn(3).setHeaderValue(resourceMap.getString("gradeParticipantesjTable.columnModel.title3")); // NOI18N
        gradeParticipantesjTable.getColumnModel().getColumn(4).setResizable(false);
        gradeParticipantesjTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        gradeParticipantesjTable.getColumnModel().getColumn(4).setHeaderValue(resourceMap.getString("gradeParticipantesjTable.columnModel.title4")); // NOI18N
        gradeParticipantesjTable.getColumnModel().getColumn(5).setResizable(false);
        gradeParticipantesjTable.getColumnModel().getColumn(5).setPreferredWidth(150);
        gradeParticipantesjTable.getColumnModel().getColumn(5).setHeaderValue(resourceMap.getString("gradeParticipantesjTable.columnModel.title5")); // NOI18N
        gradeParticipantesjTable.getColumnModel().getColumn(6).setResizable(false);
        gradeParticipantesjTable.getColumnModel().getColumn(6).setPreferredWidth(175);
        gradeParticipantesjTable.getColumnModel().getColumn(6).setHeaderValue(resourceMap.getString("gradeParticipantesjTable.columnModel.title6")); // NOI18N

        jPanel3.setBackground(resourceMap.getColor("jPanel3.background")); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N

        gerarRelatoriojButton.setIcon(resourceMap.getIcon("gerarRelatoriojButton.icon")); // NOI18N
        gerarRelatoriojButton.setText(resourceMap.getString("gerarRelatoriojButton.text")); // NOI18N
        gerarRelatoriojButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        gerarRelatoriojButton.setName("gerarRelatoriojButton"); // NOI18N
        gerarRelatoriojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerarRelatoriojButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(596, Short.MAX_VALUE)
                .addComponent(gerarRelatoriojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gerarRelatoriojButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ClassConecta conexao = new ClassConecta();

    public int totalParticipante = 0;


    //******************************************************************************************************
    public void getGradeParticipante() throws ParseException{
       //Consultar Cidades
        Participantes oParticipante = new Participantes();


//        if ( cidadejTextField.getText().length() > 0 ){
//            oCidade.setCidade(cidadejTextField.getText()+"%");
//        }

        ResultSet resultSet = null;

        String[] colunasTabela = new String[]{"Id#", "Participante", "Cidade", "UF", "Telefone", "Email", "Vocação"};
        DefaultTableModel modeloTabela = new DefaultTableModel(null, colunasTabela) {

            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        gradeParticipantesjTable.setModel(modeloTabela);
        gradeParticipantesjTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        gradeParticipantesjTable.getColumnModel().getColumn(1).setPreferredWidth(150);
        gradeParticipantesjTable.getColumnModel().getColumn(2).setPreferredWidth(60);
        gradeParticipantesjTable.getColumnModel().getColumn(3).setPreferredWidth(1);
        gradeParticipantesjTable.getColumnModel().getColumn(4).setPreferredWidth(60);
        gradeParticipantesjTable.getColumnModel().getColumn(5).setPreferredWidth(150);
        gradeParticipantesjTable.getColumnModel().getColumn(6).setPreferredWidth(175);

        gradeParticipantesjTable.setDefaultRenderer(Object.class, new ColorRenderer());

try {
            resultSet = oParticipante.getConsultarParticipantesVocacoes();

            if (resultSet.getRow() == 1){
             resultSet.first();
            }


        } catch (SQLException ex) {
            Logger.getLogger(Participantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            while (resultSet.next()) {

                modeloTabela.addRow(new String[]{
                    Funcoes.getCodigoFormat(resultSet.getInt("codParticipante")),
                    resultSet.getString("participante"),
                    resultSet.getString("cidade") ,
                    resultSet.getString("uf"),
                    resultSet.getString("tel"),
                    resultSet.getString("email"),
                    resultSet.getString("vocacao"),
                });

            }

        } catch (SQLException ex) {
            Logger.getLogger(Participantes.class.getName()).log(Level.SEVERE, null, ex);
        }

           }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:

        ClassConecta.conecta();
        
        carregaInformacoesjButtonActionPerformed(null);
        carregaInformacoesjButton.setVisible(false);


    }//GEN-LAST:event_formWindowOpened

    private void sairjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairjButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_sairjButtonActionPerformed

    private void carregaInformacoesjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregaInformacoesjButtonActionPerformed
        try {
            // TODO add your handling code here:
            getGradeParticipante();
        } catch (ParseException ex) {
            Logger.getLogger(jFParticipantes.class.getName()).log(Level.SEVERE, null, ex);
        }

        Participantes oParticipante = new Participantes();
        try {
            totalParticipante = Integer.parseInt(oParticipante.getQuantidadeParticipante().toString());
        } catch (SQLException ex) {
            Logger.getLogger(jFParticipantes.class.getName()).log(Level.SEVERE, null, ex);
        }
        totalParticipantesjLabel.setText(String.valueOf(totalParticipante));


    }//GEN-LAST:event_carregaInformacoesjButtonActionPerformed


    private void gerarRelatoriojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerarRelatoriojButtonActionPerformed
        // TODO add your handling code here:
        ClassConecta.conecta();
        try {
                Participantes oParticipante = new Participantes();
                String caminhoRelJasper = "relatorios/report2.jasper";
                ResultSet rs;
            try {


                rs = oParticipante.getConsultarParticipantesVocacoes();

                JRResultSetDataSource ds = new JRResultSetDataSource(rs);

                URL arquivo = getClass().getResource(caminhoRelJasper);

                if (arquivo == null)
                JOptionPane.showMessageDialog(null,"Arquivo jasper não encontrado");
                JasperReport report;
            try {

                    report = JasperManager.loadReport(arquivo.openStream());
                    JasperPrint jasperPrint = JasperFillManager.fillReport(report, new HashMap(), ds);
                    JasperViewer jrviewer = new JasperViewer(jasperPrint, false);
                    jrviewer.setVisible(true);


            } catch (JRException ex) {
                System.out.println("Problema ao gerar relatorio: " +  ex.getMessage());
                Logger.getLogger(jFParticipantes.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Problema ao gerar relatorio: " +  ex.getMessage());
            }

            } catch (IOException ex) {
                System.out.println("Problema ao gerar relatorio: " +  ex.getMessage());
                Logger.getLogger(jFParticipantes.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Problema ao gerar relatorio: " +  ex.getMessage());
            }


            } catch (SQLException ex) {
                System.out.println("Problema ao gerar relatorio: " +  ex.getMessage());
               Logger.getLogger(jFParticipantes.class.getName()).log(Level.SEVERE, null, ex);
               JOptionPane.showMessageDialog(null, "Problema ao gerar relatorio: " +  ex.getMessage());
            }

    }//GEN-LAST:event_gerarRelatoriojButtonActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new jFParticipantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton carregaInformacoesjButton;
    private javax.swing.JButton gerarRelatoriojButton;
    private javax.swing.JTable gradeParticipantesjTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton sairjButton;
    private javax.swing.JLabel totalParticipantesjLabel;
    // End of variables declaration//GEN-END:variables

}
