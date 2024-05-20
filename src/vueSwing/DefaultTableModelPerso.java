/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vueSwing;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author WalidDev
 */
public class DefaultTableModelPerso extends DefaultTableModel {

    public DefaultTableModelPerso(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

   
    
    
   
    
}
