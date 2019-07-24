/*
 * Autopsy Forensic Browser
 *
 * Copyright 2019 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.modules.plaso;

import org.sleuthkit.autopsy.ingest.IngestModuleIngestJobSettings;
import org.sleuthkit.autopsy.ingest.IngestModuleIngestJobSettingsPanel;

/**
 * Settings panel for the PlasoIngestModule.
 */
public class PlasoModuleSettingsPanel extends IngestModuleIngestJobSettingsPanel {

    private final PlasoModuleSettings settings;

    public PlasoModuleSettingsPanel(PlasoModuleSettings settings) {
        this.settings = settings;
        initComponents();
    }

    /** This method is called from within the constructor to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        winRegCheckBox = new javax.swing.JCheckBox();
        peCheckBox = new javax.swing.JCheckBox();
        plasoParserInfoTextArea = new javax.swing.JTextArea();
        noteLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        org.openide.awt.Mnemonics.setLocalizedText(winRegCheckBox, org.openide.util.NbBundle.getMessage(PlasoModuleSettingsPanel.class, "PlasoModuleSettingsPanel.winRegCheckBox.text")); // NOI18N
        winRegCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                winRegCheckBoxActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(peCheckBox, org.openide.util.NbBundle.getMessage(PlasoModuleSettingsPanel.class, "PlasoModuleSettingsPanel.peCheckBox.text")); // NOI18N
        peCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peCheckBoxActionPerformed(evt);
            }
        });

        plasoParserInfoTextArea.setEditable(false);
        plasoParserInfoTextArea.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        plasoParserInfoTextArea.setColumns(20);
        plasoParserInfoTextArea.setLineWrap(true);
        plasoParserInfoTextArea.setRows(5);
        plasoParserInfoTextArea.setText(org.openide.util.NbBundle.getMessage(PlasoModuleSettingsPanel.class, "PlasoModuleSettingsPanel.plasoParserInfoTextArea.text")); // NOI18N
        plasoParserInfoTextArea.setWrapStyleWord(true);
        plasoParserInfoTextArea.setBorder(null);

        org.openide.awt.Mnemonics.setLocalizedText(noteLabel, org.openide.util.NbBundle.getMessage(PlasoModuleSettingsPanel.class, "PlasoModuleSettingsPanel.noteLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(PlasoModuleSettingsPanel.class, "PlasoModuleSettingsPanel.jLabel1.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(plasoParserInfoTextArea)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(noteLabel)
                            .addComponent(peCheckBox)
                            .addComponent(winRegCheckBox)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(noteLabel)
                .addGap(18, 18, 18)
                .addComponent(plasoParserInfoTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(winRegCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(peCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void winRegCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_winRegCheckBoxActionPerformed
        settings.setParserEnabled("winreg", winRegCheckBox.isSelected());
    }//GEN-LAST:event_winRegCheckBoxActionPerformed

    private void peCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peCheckBoxActionPerformed
        settings.setParserEnabled("pe", peCheckBox.isSelected());
    }//GEN-LAST:event_peCheckBoxActionPerformed

    @Override
    public IngestModuleIngestJobSettings getSettings() {
        return settings;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel noteLabel;
    private javax.swing.JCheckBox peCheckBox;
    private javax.swing.JTextArea plasoParserInfoTextArea;
    private javax.swing.JCheckBox winRegCheckBox;
    // End of variables declaration//GEN-END:variables
}
