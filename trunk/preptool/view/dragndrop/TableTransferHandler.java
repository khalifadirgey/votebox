/**
  * This file is part of VoteBox.
  * 
  * VoteBox is free software: you can redistribute it and/or modify
  * it under the terms of the GNU General Public License as published by
  * the Free Software Foundation, either version 3 of the License, or
  * (at your option) any later version.
  * 
  * VoteBox is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  * 
  * You should have received a copy of the GNU General Public License
  * along with VoteBox.  If not, see <http://www.gnu.org/licenses/>.
 */
package preptool.view.dragndrop;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import preptool.view.IMovableTableModel;


/**
 * <p>
 * Handler for drag and drop events in a JTable. This handler is specific in
 * that it does not package any information in the Transferable, rather it
 * requires the drag be only within the table (by checking if the components are
 * the same), and moves the row from the old index to the new index.
 * </p>
 * Inspired by Copied from
 * http://java.sun.com/docs/books/tutorial/uiswing/examples/dnd/ExtendedDnDDemoProject/src/dnd/TableTransferHandler.java
 * <br>
 * Modifications by cshaw
 */
public class TableTransferHandler extends StringTransferHandler {

    private static final long serialVersionUID = 1L;

    /**
     * Index the drag originated from
     */
    private int remIndex;

    /**
     * Index to insert the row at
     */
    private int addIndex;

    /**
     * Records the current selected row index
     */
    @Override
    protected String exportString(JComponent c) {
        JTable table = (JTable) c;
        remIndex = table.getSelectedRow();
        return "";
    }

    /**
     * Records the target selected index. Fails if the indices are the same
     */
    @Override
    protected void importString(JComponent c, String str) {
        JTable target = (JTable) c;
        AbstractTableModel model = (AbstractTableModel) target.getModel();
        addIndex = target.getSelectedRow();

        if (remIndex == addIndex) {
            remIndex = -1;
            addIndex = -1;
            return;
        }

        int max = model.getRowCount();
        if (addIndex < 0 || addIndex > max - 1)
            addIndex = max - 1;
    }

    /**
     * Performs the move operation by moving the row from its old index to the
     * new one.
     */
    @Override
    protected void cleanup(JComponent c, boolean remove) {
        JTable source = (JTable) c;
        if (remove && remIndex != -1) {
            AbstractTableModel model = (AbstractTableModel) source.getModel();
            if (model instanceof IMovableTableModel)
                ((IMovableTableModel) model).moveRow( remIndex, addIndex );
            else if (model instanceof DefaultTableModel)
                ((DefaultTableModel) model).moveRow( remIndex, remIndex,
                    addIndex );
            c.validate();
            c.repaint();
        }
        remIndex = -1;
        addIndex = -1;
    }
}