/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Lista.java
 *
 * Created on 22/09/2010, 07:39:02
 */
package Forms;

import MP3.Criptografia;
import MP3.mp3Tags;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import javazoom.jl.decoder.JavaLayerException;
import org.apache.commons.io.FileUtils;
import org.farng.mp3.MP3File;
import org.farng.mp3.TagConstant;
import org.farng.mp3.TagException;
import org.farng.mp3.TagOptionSingleton;
import org.farng.mp3.id3.AbstractID3v2;
import org.farng.mp3.id3.ID3v1;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackListener;
import javazoom.jl.player.advanced.PlaybackEvent;

/**
 *
 * @author Igor Gottschalg
 */
public class jLista extends javax.swing.JFrame {
    /*
     * Declaração de Variáveis
     */

    private File mp;
    private AdvancedPlayer player;
    private int position = 0;
    int row;
    DefaultTableModel tmlista = new DefaultTableModel(null, new String[]{"Faixa", "Título", "Artista", "Albúm", "Ano", "Gênero", "Caminho"});
    List<mp3Tags> files;
    ListSelectionModel lslista;
    mp3Tags mp3 = new mp3Tags();
    jOrg org = new jOrg();
    jErro erro = new jErro();
    String path, mp3path;
    int status, tipo, quant = 0;
    int sf = 0;
    SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss:ms");

    /*
     * Inicio programa
     */
    /** Creates new form Lista */
    public jLista() {
        initComponents();
        this.setLocationRelativeTo(null);
        URL url = this.getClass().getResource("ICO.png");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTTabela = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        JPlayBar = new javax.swing.JToolBar();
        jPlay = new javax.swing.JButton();
        jStop = new javax.swing.JButton();
        jMp3Slide = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("iOrganizer");

        jSplitPane1.setBorder(null);
        jSplitPane1.setDividerLocation(245);
        jSplitPane1.setContinuousLayout(true);
        jSplitPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jSplitPane1.setOpaque(false);

        jToolBar1.setBorder(null);
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jLabel6.setText("jLabel6");
        jToolBar1.add(jLabel6);

        jButton1.setText("Remover da Lista");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jTTabela.setAutoCreateRowSorter(true);
        jTTabela.setModel(tmlista);
        jTTabela.setGridColor(new java.awt.Color(102, 102, 102));
        jTTabela.setOpaque(false);
        jTTabela.getTableHeader().setReorderingAllowed(false);
        jTTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTTabelaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTTabela);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSplitPane1.setRightComponent(jPanel3);

        jToggleButton3.setText("Organizar");
        jToggleButton3.setMaximumSize(new java.awt.Dimension(245, 23));
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Salvar TAG");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Ano:");

        jTextField5.setMaximumSize(new java.awt.Dimension(245, 2147483647));
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel4.setText("Albúm:");

        jTextField4.setMaximumSize(new java.awt.Dimension(245, 2147483647));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jTextField3.setMaximumSize(new java.awt.Dimension(245, 2147483647));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Título:");

        jTextField1.setMaximumSize(new java.awt.Dimension(6, 2147483647));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Faixa:");

        JPlayBar.setFloatable(false);
        JPlayBar.setRollover(true);

        jPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Play.png"))); // NOI18N
        jPlay.setFocusable(false);
        jPlay.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPlay.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPlayActionPerformed(evt);
            }
        });
        JPlayBar.add(jPlay);

        jStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Stop.png"))); // NOI18N
        jStop.setEnabled(false);
        jStop.setFocusable(false);
        jStop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jStop.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jStopActionPerformed(evt);
            }
        });
        JPlayBar.add(jStop);

        jMp3Slide.setValue(0);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JPlayBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jMp3Slide, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jMp3Slide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPlayBar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setText("Artista:");

        jTextField2.setMaximumSize(new java.awt.Dimension(245, 2147483647));
        jTextField2.setMinimumSize(new java.awt.Dimension(245, 20));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(219, 219, 219))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(jToggleButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(22, 22, 22)))
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jMenu1.setText("Arquivo");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Salvar Lista");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Sair");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        jMenuItem3.setText("Remover Item Selecionado");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);
        jMenu2.add(jSeparator2);

        jMenuItem6.setText("Opições");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ajuda");

        jMenuItem4.setText("Ajuda");
        jMenu3.add(jMenuItem4);

        jMenuItem5.setText("Sobre");
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        try {
            SalvarMP3();
        } catch (IOException ex) {
            erro.error(ex.getMessage());
            erro.show();
        } catch (TagException ex) {
            erro.error(ex.getMessage());
            erro.show();
        }
}//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        org.show();
        org.repaint();
        org.repaint();
        org.max = jTTabela.getModel().getRowCount();
        new Thread() {

            @Override
            public void run() {
                String destino, fil, album, artista, faixa, titulo, source;
                Date time1, time2;
                int q;
                for (q = 0; q < jTTabela.getModel().getRowCount(); q++) {
                    try {
                        if (org.cancel == 1) {
                            break;
                        }
                        try{
                            artista = jTTabela.getModel().getValueAt(q, 2).toString();
                        }catch(Exception e){
                            artista = "";
                        }
                        try{
                            album = jTTabela.getModel().getValueAt(q, 3).toString();
                        }catch(Exception e){
                            album = "";
                        }
                        try{
                            faixa = jTTabela.getModel().getValueAt(q, 0).toString();
                        }catch(Exception e){
                            faixa = "";
                        }
                        try{
                            titulo = jTTabela.getModel().getValueAt(q, 1).toString();
                        }catch(Exception e){
                            titulo = "";
                        }
                        source = jTTabela.getModel().getValueAt(q, 6).toString();
                        if (tipo == 1) {
                            if (!album.equals("") && !artista.equals("")) {
                                destino = path + "\\" + artista + " - " + album;
                            } else {
                                if (!artista.equals("")) {
                                    destino = path + "\\" + artista + " - " + "Albúm Desconhecido";
                                } else if (!album.equals("")) {
                                    destino = path + "\\" + "Artista Desconhecido" + " - " + album;
                                } else {
                                    destino = path + "\\" + "Artista Desconhecido" + " - " + "Albúm Desconhecido";
                                }
                            }
                        } else {
                            if (!album.equals("") && !artista.equals("")) {
                                destino = path + "\\" + artista + "\\" + album;
                            } else {
                                if (!artista.equals("")) {
                                    destino = path + "\\" + artista + "\\" + "Albúm Desconhecido";
                                } else if (!album.equals("")) {
                                    destino = path + "\\" + "Artista Desconhecido" + "\\" + album;
                                } else {
                                    destino = path + "\\" + "Artista Desconhecido" + "\\" + "Albúm Desconhecido";
                                }
                            }
                        }
                        if (!titulo.equals("") && !faixa.equals("")) {
                            fil = "\\" + faixa + " - " + titulo + ".mp3";
                        } else {
                            if (!titulo.equals("")) {
                                fil = "\\" + titulo + ".mp3";
                            } else if (!faixa.equals("")) {
                                File nome = new File(source);
                                String nomeFile;
                                if (nome.getName().toString().endsWith(".mp3")) {
                                    int len;
                                    len = nome.getName().length();
                                    nomeFile = nome.getName().toString().substring(0, len - 4);
                                } else {
                                    nomeFile = nome.getName().toString();
                                }
                                fil = "\\" + faixa + " - " + nomeFile + ".mp3";
                            } else {
                                File nome = new File(source);
                                String nomeFile;
                                if (nome.getName().toString().endsWith(".mp3")) {
                                    int len;
                                    len = nome.getName().length();
                                    nomeFile = nome.getName().toString().substring(0, len - 4);
                                } else {
                                    nomeFile = nome.getName().toString();
                                }
                                fil = "\\" + nomeFile + ".mp3";
                            }
                        }
                        try {
                            org.organizar(source, destino, fil, q);
                        } catch (JavaLayerException ex) {
                            Logger.getLogger(jLista.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        org.Label1(calcTempo());
                        if (sf <1) {
                            time1 = new Date();
                            try {
                                org.organizar(source, destino, fil, q);
                            } catch (JavaLayerException ex) {
                                Logger.getLogger(jLista.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            time2 = new Date();
                            calc(time1, time2);
                            System.out.println(time1+ "    "+ time2);
                        }
                        quant++;
                    } catch (IOException ex) {
                        erro.error(ex.getMessage());
                        erro.show();
                    } catch (TagException ex) {
                        erro.error(ex.getMessage());
                        erro.show();
                    }
                }
            }
        }.start();
    }
//GEN-LAST:event_jToggleButton3ActionPerformed
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jTextField5ActionPerformed

    private void jTTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTTabelaMouseClicked
        File source = new File(jTTabela.getValueAt(jTTabela.getSelectedRow(), 6).toString());
        mp3Tags fmp3;
        try {
            fmp3 = LerMP3(source);
            jTextField1.setText(fmp3.getFaixa());
            jTextField2.setText(fmp3.getTitulo());
            jTextField3.setText(fmp3.getArtista());
            jTextField4.setText(fmp3.getAlbum());
            jTextField5.setText(fmp3.getAno());
            row = jTTabela.getSelectedRow();
            mp3path = fmp3.getCaminho();
        } catch (IOException ex) {
            erro.error(ex.getMessage());
            erro.show();
        } catch (TagException ex) {
            erro.error(ex.getMessage());
            erro.show();
        }

    }//GEN-LAST:event_jTTabelaMouseClicked

    private void jPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPlayActionPerformed
        mp = new File(mp3path);
        jPlay.setEnabled(false);
        jStop.setEnabled(true);
        play();
    }//GEN-LAST:event_jPlayActionPerformed

    private void jStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jStopActionPerformed
        player.stop();
        ResetPosition();
        jPlay.setEnabled(true);
        jStop.setEnabled(false);
    }//GEN-LAST:event_jStopActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tmlista.removeRow(row);
        jTTabela.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        try {
            salvarXML();
        } catch (Exception ex) {
            erro.error(ex.getMessage());
            erro.show();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        tmlista.removeRow(row);
        jTTabela.repaint();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        this.setEnabled(false);
        jOpition op = new jOpition();
        op.show();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                jLista w = new jLista();
                w.setVisible(true);
                w.setLocationRelativeTo(null);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar JPlayBar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JSlider jMp3Slide;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jPlay;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton jStop;
    private javax.swing.JTable jTTabela;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
    /*
    Monta a lista e repassa para org
     */

    public void montarlista(final List<mp3Tags> lista) throws IOException {
        final jProgress p = new jProgress();
        p.show();
        new Thread() {

            @Override
            public void run() {

                int i;
                if (!lista.isEmpty()) {
                    String[] linha = new String[]{null, null, null, null, null, null, null};
                    for (i = 0; i < lista.size(); i++) {
                        tmlista.addRow(linha);
                        tmlista.setValueAt(lista.get(i).getFaixa(), i, 0);
                        tmlista.setValueAt(lista.get(i).getTitulo(), i, 1);
                        tmlista.setValueAt(lista.get(i).getArtista(), i, 2);
                        tmlista.setValueAt(lista.get(i).getAlbum(), i, 3);
                        tmlista.setValueAt(lista.get(i).getAno(), i, 4);
                        tmlista.setValueAt(lista.get(i).getGenero(), i, 5);
                        tmlista.setValueAt(lista.get(i).getCaminho(), i, 6);
                    }
                    p.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum tipo de arquivo mp3 dentro na pasta.\nSelecione outra pasta e tente novamente.");
                }
                jLabel6.setText("Quantidade de Arquivos: " + lista.size());
            }
        }.start();
    }

    /*
    lista todos os arquivos no diretorio
     */
    public List<mp3Tags> lista(String Pasta) throws IOException {
        int q = 0;
        List<mp3Tags> resultado = new ArrayList<mp3Tags>();
        File root = new File(Pasta);

        //Lista todos os arquivos da pasta....
        try {
            String[] extensions = {"mp3","wav"};
            boolean recursive = true;
            Collection fi = FileUtils.listFiles(root, extensions, recursive);
            for (Iterator iterator = fi.iterator(); iterator.hasNext();) {
                File file = (File) iterator.next();
                try {
                    resultado.add(LerMP3(file));
                    q++;
                } catch (Exception e) {
                    erro.error(e.getMessage());
                    erro.show();
                }
            }
        } catch (Exception e) {
            resultado = null;
            System.out.println(e);
        }
        return resultado;

    }
    /*
     * Ler as tag mp3 e retorna o objeto mp3tags
     */

    public static mp3Tags LerMP3(File sourceFile) throws IOException, TagException {
        mp3Tags tag = new mp3Tags();
        MP3File mp3file = new MP3File(sourceFile);
        tag.setCaminho(sourceFile.getPath());
        try {
            if (mp3file.hasFilenameTag() == true && mp3file.hasID3v1Tag() == true) {
                try {
                    tag.setAlbum(mp3file.getID3v1Tag().getAlbum());
                } catch (Exception e) {
                }
                try {
                    tag.setArtista(mp3file.getID3v1Tag().getArtist());
                } catch (Exception e) {
                }
                try {
                    tag.setTitulo(mp3file.getID3v1Tag().getSongTitle().replace("�", "").toString());
                } catch (Exception e) {
                }
                try {
                    tag.setComentario(mp3file.getID3v1Tag().getComment());
                } catch (Exception e) {
                }
                try {
                    tag.setAno(mp3file.getID3v1Tag().getYear());
                } catch (Exception e) {
                }
                try {
                    tag.setFaixa(mp3file.getID3v1Tag().getTrackNumberOnAlbum());
                } catch (Exception e) {
                }
                try {
                    tag.setGenero(String.valueOf((mp3file.getID3v1Tag().getGenre())));
                } catch (Exception e) {
                }

            } else {

                if (mp3file.hasFilenameTag() == true && mp3file.hasID3v2Tag() == true) {
                    try {
                        tag.setAlbum(mp3file.getID3v2Tag().getAlbumTitle());
                    } catch (Exception e) {
                    }
                    try {
                        tag.setArtista(mp3file.getID3v2Tag().getLeadArtist());
                    } catch (Exception e) {
                    }
                    try {
                        tag.setTitulo(mp3file.getID3v2Tag().getSongTitle());
                    } catch (Exception e) {
                    }
                    try {
                        tag.setComentario(mp3file.getID3v2Tag().getSongComment());
                    } catch (Exception e) {
                    }
                    try {
                        tag.setAno(mp3file.getID3v2Tag().getYearReleased());
                    } catch (Exception e) {
                    }
                    try {
                        tag.setFaixa(mp3file.getID3v2Tag().getTrackNumberOnAlbum());
                    } catch (Exception e) {
                    }
                    try {
                        tag.setGenero((mp3file.getID3v2Tag().getSongGenre()));
                    } catch (Exception e) {
                    }
                }
            }
        } catch (Exception e) {
        }
        return tag;
    }
    /*
     * Modifica e Salva as tags no mp3
     */

    private void SalvarMP3() throws IOException, TagException {
        File source = new File(jTTabela.getValueAt(row, 6).toString());
        MP3File mp3file = new MP3File(source);

        if (mp3file.hasID3v1Tag() == true) {
            ID3v1 id = mp3file.getID3v1Tag();
            TagOptionSingleton.getInstance().setDefaultSaveMode(TagConstant.MP3_FILE_SAVE_OVERWRITE);

            id.setTrackNumberOnAlbum(jTextField1.getText());
            id.setSongTitle(jTextField2.getText());
            id.setArtist(jTextField3.getText());
            id.setAlbumTitle(jTextField4.getText());
            id.setYear(jTextField5.getText());
            id.write(id);
            mp3file.setID3v1Tag(id);
            mp3file.save(source);
        } else {
            AbstractID3v2 id = mp3file.getID3v2Tag();
            TagOptionSingleton.getInstance().setDefaultSaveMode(TagConstant.MP3_FILE_SAVE_OVERWRITE);

            id.setTrackNumberOnAlbum(jTextField1.getText());
            id.setSongTitle(jTextField2.getText());
            id.setLeadArtist(jTextField3.getText());
            id.setAlbumTitle(jTextField4.getText());
            id.setYearReleased(jTextField5.getText());
            mp3file.setID3v2Tag(id);
            id.write(id);
            mp3file.save(source);
        }
        jTTabela.setValueAt(jTextField1.getText(), row, 0);
        jTTabela.setValueAt(jTextField2.getText(), row, 1);
        jTTabela.setValueAt(jTextField3.getText(), row, 2);
        jTTabela.setValueAt(jTextField4.getText(), row, 3);
        jTTabela.setValueAt(jTextField5.getText(), row, 4);
    }

    public void close() {
        if (player != null) {

            player.close();
        }
    }

    public void ResetPosition() {
        position = 0;
    }

    /*
     * Toca arquivo mp3 na placa
     */
    public void play() {
        try {
            FileInputStream fis = new FileInputStream(mp);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new AdvancedPlayer(bis);
        } catch (Exception e) {
            System.out.println("Problem playing file " + mp);
            System.out.println(e);
        }

        player.setPlayBackListener(new PlaybackListener() {

            @Override
            public void playbackStarted(PlaybackEvent playbackEvent) {
                status = 0;
            }

            @Override
            public void playbackFinished(PlaybackEvent playbackEvent) {
                status = 1;
            }
        });
        new Thread() {

            @Override
            public void run() {
                try {
                    player.play(position, Integer.MAX_VALUE);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }.start();
    }

    private void salvarXML() throws Exception {
        String conteudo = null;
        int q;
        for (q = 0; q < jTTabela.getModel().getRowCount(); q++) {
            conteudo += jTTabela.getModel().getValueAt(q, 6).toString() + "\n";
        }
        conteudo = Criptografia.encrypt(conteudo);
        FileFilter filter = new FileFilter() {

            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".ize") || f.isDirectory();
            }

            @Override
            public String getDescription() {
                return "Arquivos para Organização (.ize)";
            }
        };
        JFileChooser local = new JFileChooser();
        local.setFileFilter(filter);
        String localPath = null;
        local.showSaveDialog(this);
        if (local.getSelectedFile().getPath() != null) {
            if (!local.getSelectedFile().getPath().toLowerCase().endsWith(".ize")) {
                localPath = local.getSelectedFile().getPath();
            } else {
                localPath = local.getSelectedFile().getPath() + ".ize";
            }
        }
        System.out.println(localPath);
        try {
            FileWriter x = new FileWriter(localPath, true);
            conteudo += "\n\r"; // criando nova linha e recuo no arquivo
            x.write(conteudo); // armazena o texto no objeto x, que aponta para o arquivo
            x.close(); // cria o arquivo
            JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso", "Concluído", JOptionPane.INFORMATION_MESSAGE);
        } // em caso de erro apreenta mensagem abaixo
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void calc(Date t1, Date t2) {
        long s1, s2, m1, m2, mf, h1, h2, hf;

        h1 = t1.getHours();
        h2 = t2.getHours();
        m1 = t1.getMinutes();
        m2 = t2.getMinutes();
        s1 = t1.getSeconds();
        s2 = t2.getSeconds();
        
        hf = h2 - h1;
        mf = m2 - m1;
        sf = (int) (s2 - s1);

        sf += mf * 60;
        sf += hf * 3600;
        System.out.println(sf);
    }

    private String calcTempo() {
        String Retorno;
        int tempo;

        tempo = sf * jTTabela.getModel().getRowCount() - quant;

        if (tempo > 3600) {
            tempo /= 3600;
            Retorno = "Faltam " + String.valueOf(tempo) + " horas aprossimadamente";
        } else if (tempo > 60 && tempo < 3600) {
            tempo /= 60;
            Retorno = "Faltam " + String.valueOf(tempo) + " minutos aprossimadamente";
        } else {
            Retorno = "Faltam " + String.valueOf(tempo) + " segundos aprossimadamente";
        }
        return Retorno;
    }
}
