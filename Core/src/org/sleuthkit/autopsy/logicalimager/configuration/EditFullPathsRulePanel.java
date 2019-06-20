/*
 * Autopsy Forensic Browser
 *
 * Copyright 2011-2019 Basis Technology Corp.
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
package org.sleuthkit.autopsy.logicalimager.configuration;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.openide.util.NbBundle;

/**
 * Edit full paths rule panel
 */
@SuppressWarnings("PMD.SingularField") // UI widgets cause lots of false positives
final class EditFullPathsRulePanel extends javax.swing.JPanel {

    private JButton okButton;
    private JButton cancelButton;
    private final JTextArea fullPathsTextArea;

    /**
     * Creates new form EditFullPathsRulePanel
     */
    @NbBundle.Messages({
        "EditFullPathsRulePanel.example=Example: "
    })
    EditFullPathsRulePanel(JButton okButton, JButton cancelButton, String ruleName, LogicalImagerRule rule, boolean editing) {
        initComponents();

        if (editing) {
            ruleNameTextField.setEnabled(!editing);
        }

        this.setRule(ruleName, rule);
        this.setButtons(okButton, cancelButton);

        fullPathsTextArea = new JTextArea();
        initTextArea(fullPathsScrollPane, fullPathsTextArea);
        setTextArea(fullPathsTextArea, rule.getFullPaths());

        EditRulePanel.setTextFieldPrompts(fullPathsTextArea,
                "<html>" + Bundle.EditFullPathsRulePanel_example() + "<br>/Program Files/Common Files/system/wab32.dll<br>/Windows/System32/1033/VsGraphicsResources.dll</html>"); // NON-NLS
        ruleNameTextField.requestFocus();
        addDocumentListeners();
        validate();
        repaint();
    }

    /**
     * Update the OK button when contents of a field change
     */
    private void addDocumentListeners() {
        SwingUtilities.invokeLater(() -> {
            setOkButton();  //ensure initial state before listeners added is correct
        });
        DocumentListener docListener;
        docListener = new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                setOkButton();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                setOkButton();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                setOkButton();
            }           
        };
        ruleNameTextField.getDocument().addDocumentListener(docListener);
        fullPathsTextArea.getDocument().addDocumentListener(docListener);
    }
    
    private void initTextArea(JScrollPane pane, JTextArea textArea) {
        textArea.setColumns(20);
        textArea.setRows(5);
        pane.setViewportView(textArea);
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    if (e.getModifiers() > 0) {
                        textArea.transferFocusBackward();
                    } else {
                        textArea.transferFocus();
                    }
                    e.consume();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        shouldSaveCheckBox = new javax.swing.JCheckBox();
        shouldAlertCheckBox = new javax.swing.JCheckBox();
        fullPathsLabel = new javax.swing.JLabel();
        descriptionTextField = new javax.swing.JTextField();
        ruleNameLabel = new javax.swing.JLabel();
        ruleNameTextField = new javax.swing.JTextField();
        fullPathsScrollPane = new javax.swing.JScrollPane();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        descriptionCheckbox = new javax.swing.JCheckBox();

        shouldSaveCheckBox.setSelected(true);
        org.openide.awt.Mnemonics.setLocalizedText(shouldSaveCheckBox, org.openide.util.NbBundle.getMessage(EditFullPathsRulePanel.class, "EditFullPathsRulePanel.shouldSaveCheckBox.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(shouldAlertCheckBox, org.openide.util.NbBundle.getMessage(EditFullPathsRulePanel.class, "EditFullPathsRulePanel.shouldAlertCheckBox.text")); // NOI18N
        shouldAlertCheckBox.setActionCommand(org.openide.util.NbBundle.getMessage(EditFullPathsRulePanel.class, "EditFullPathsRulePanel.shouldAlertCheckBox.actionCommand")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(fullPathsLabel, org.openide.util.NbBundle.getMessage(EditFullPathsRulePanel.class, "EditFullPathsRulePanel.fullPathsLabel.text")); // NOI18N
        fullPathsLabel.setToolTipText(org.openide.util.NbBundle.getMessage(EditFullPathsRulePanel.class, "EditFullPathsRulePanel.fullPathsLabel.toolTipText")); // NOI18N
        fullPathsLabel.setPreferredSize(new java.awt.Dimension(101, 14));

        descriptionTextField.setEnabled(false);

        org.openide.awt.Mnemonics.setLocalizedText(ruleNameLabel, org.openide.util.NbBundle.getMessage(EditFullPathsRulePanel.class, "EditFullPathsRulePanel.ruleNameLabel.text")); // NOI18N
        ruleNameLabel.setPreferredSize(new java.awt.Dimension(101, 14));

        org.openide.awt.Mnemonics.setLocalizedText(descriptionCheckbox, org.openide.util.NbBundle.getMessage(EditFullPathsRulePanel.class, "EditFullPathsRulePanel.descriptionCheckbox.text")); // NOI18N
        descriptionCheckbox.setPreferredSize(new java.awt.Dimension(101, 23));
        descriptionCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionCheckboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ruleNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descriptionCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fullPathsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ruleNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
                            .addComponent(descriptionTextField)
                            .addComponent(fullPathsScrollPane)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(shouldSaveCheckBox)
                            .addComponent(shouldAlertCheckBox))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ruleNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ruleNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descriptionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descriptionCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fullPathsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 93, Short.MAX_VALUE))
                    .addComponent(fullPathsScrollPane))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shouldSaveCheckBox)
                .addGap(3, 3, 3)
                .addComponent(shouldAlertCheckBox)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void descriptionCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionCheckboxActionPerformed
        descriptionTextField.setEnabled(descriptionCheckbox.isSelected());
    }//GEN-LAST:event_descriptionCheckboxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox descriptionCheckbox;
    private javax.swing.JTextField descriptionTextField;
    private javax.swing.JLabel fullPathsLabel;
    private javax.swing.JScrollPane fullPathsScrollPane;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel ruleNameLabel;
    private javax.swing.JTextField ruleNameTextField;
    private javax.swing.JCheckBox shouldAlertCheckBox;
    private javax.swing.JCheckBox shouldSaveCheckBox;
    // End of variables declaration//GEN-END:variables

    /**
     * Sets whether or not the OK button should be enabled based upon other UI
     * elements
     */
    void setOkButton() {
        if (this.okButton != null) {
            this.okButton.setEnabled(!StringUtils.isBlank(ruleNameTextField.getText()) && !StringUtils.isBlank(fullPathsTextArea.getText()));
        }
    }

    /**
     * Gets the JOptionPane that is used to contain this panel if there is one
     *
     * @param parent
     *
     * @return
     */
    private JOptionPane getOptionPane(JComponent parent) {
        JOptionPane pane;
        if (!(parent instanceof JOptionPane)) {
            pane = getOptionPane((JComponent) parent.getParent());
        } else {
            pane = (JOptionPane) parent;
        }
        return pane;
    }

    /**
     * Sets the buttons for ending the panel
     *
     * @param ok     The ok button
     * @param cancel The cancel button
     */
    private void setButtons(JButton ok, JButton cancel) {
        this.okButton = ok;
        this.cancelButton = cancel;
        okButton.addActionListener((ActionEvent e) -> {
            JOptionPane pane = getOptionPane(okButton);
            pane.setValue(okButton);
        });
        cancelButton.addActionListener((ActionEvent e) -> {
            JOptionPane pane = getOptionPane(cancelButton);
            pane.setValue(cancelButton);
        });
    }

    private void setRule(String ruleName, LogicalImagerRule rule) {
        ruleNameTextField.setText(ruleName);
        descriptionTextField.setText(rule.getDescription());
        descriptionCheckbox.setSelected(!StringUtils.isBlank(descriptionTextField.getText()));
        descriptionTextField.setEnabled(descriptionCheckbox.isSelected());
        shouldAlertCheckBox.setSelected(rule.isShouldAlert());
        shouldSaveCheckBox.setSelected(rule.isShouldSave());
    }

    private void setTextArea(JTextArea textArea, List<String> set) {
        String text = "";
        for (String s : set) {
            text += s + System.getProperty("line.separator"); // NON-NLS
        }
        textArea.setText(text);
    }

    @NbBundle.Messages({
        "EditFullPathsRulePanel.fullPaths=Full paths",})
    ImmutablePair<String, LogicalImagerRule> toRule() throws IOException {
        List<String> fullPaths = EditRulePanel.validateTextList(fullPathsTextArea, Bundle.EditFullPathsRulePanel_fullPaths());
        String ruleName = EditRulePanel.validRuleName(ruleNameTextField.getText());
        LogicalImagerRule.Builder builder = new LogicalImagerRule.Builder();
        builder.getShouldAlert(shouldAlertCheckBox.isSelected())
                .getShouldSave(shouldSaveCheckBox.isSelected())
                .getName(ruleName)
                .getDescription(descriptionTextField.getText())
                .getFullPaths(fullPaths);
        LogicalImagerRule rule = builder.build();
        return new ImmutablePair<>(ruleName, rule);
    }
}
