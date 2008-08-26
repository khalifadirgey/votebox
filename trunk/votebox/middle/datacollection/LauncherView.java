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
package votebox.middle.datacollection;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridBagLayout;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.filechooser.FileFilter;

import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.io.File;
import javax.swing.JCheckBox;

public class LauncherView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JPanel southPanel = null;

	private JButton launchButton = null;

	private JPanel centerPanel = null;

	private JLabel directoryLabel = null;

	private JLabel filenameLabel = null;

	private JTextField directoryField = null;

	private JTextField filenameField = null;

	private JButton directoryBrowseButton = null;

	private Launcher parent = null;

	private JTextField ballotLocationField = null;

	private JButton ballotBrowseButton = null;

	private JLabel ballotLabel = null;

	private JButton killButton = null;

	private JCheckBox debugCheckBox = null;

	private JLabel debugLabel = null;

	/**
	 * This is the default constructor
	 */
	public LauncherView(Launcher parent) {
		super();
		initialize();
		this.parent = parent;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(618, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("VoteBox Launcher");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getSouthPanel(), BorderLayout.SOUTH);
			jContentPane.add(getCenterPanel(), BorderLayout.NORTH);
		}
		return jContentPane;
	}

	/**
	 * This method initializes southPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getSouthPanel() {
		if (southPanel == null) {
			southPanel = new JPanel();
			southPanel.setLayout(new FlowLayout());
			southPanel.add(getKillButton(), null);
			southPanel.add(getLaunchButton(), null);
		}
		return southPanel;
	}

	/**
	 * This method initializes launchButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getLaunchButton() {
		if (launchButton == null) {
			launchButton = new JButton();
			launchButton.setText("Launch");
			launchButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					parent
							.launch(getBallotLocationField().getText(),
									getDirectoryField().getText(),
									getFilenameField().getText(),
									getDebugCheckBox().isSelected());
				}
			});
		}
		return launchButton;
	}

	/**
	 * This method initializes centerPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getCenterPanel() {
		if (centerPanel == null) {
			GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
			gridBagConstraints22.gridx = 0;
			gridBagConstraints22.anchor = GridBagConstraints.WEST;
			gridBagConstraints22.gridy = 3;
			debugLabel = new JLabel();
			debugLabel.setText("Windowed instead of full-screen:");
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridx = 1;
			gridBagConstraints12.anchor = GridBagConstraints.WEST;
			gridBagConstraints12.gridy = 3;
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.gridx = 0;
			gridBagConstraints31.anchor = GridBagConstraints.WEST;
			gridBagConstraints31.gridy = 1;
			ballotLabel = new JLabel();
			ballotLabel.setText("Ballot.ZIP File:");
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 2;
			gridBagConstraints21.gridy = 1;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.fill = GridBagConstraints.BOTH;
			gridBagConstraints11.gridy = 1;
			gridBagConstraints11.weightx = 1.0;
			gridBagConstraints11.gridx = 1;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 2;
			gridBagConstraints4.gridheight = 1;
			gridBagConstraints4.ipadx = 0;
			gridBagConstraints4.ipady = 0;
			gridBagConstraints4.weightx = 0.0D;
			gridBagConstraints4.weighty = 0.0D;
			gridBagConstraints4.gridy = 0;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.BOTH;
			gridBagConstraints3.gridy = 2;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.gridx = 1;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.BOTH;
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.gridx = 1;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.ipady = 10;
			gridBagConstraints1.ipadx = 0;
			gridBagConstraints1.anchor = GridBagConstraints.WEST;
			gridBagConstraints1.gridy = 2;
			filenameLabel = new JLabel();
			filenameLabel.setText("Log Filename:");
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.ipadx = 10;
			gridBagConstraints.anchor = GridBagConstraints.WEST;
			gridBagConstraints.gridy = 0;
			directoryLabel = new JLabel();
			directoryLabel.setText("Log Directory:");
			centerPanel = new JPanel();
			centerPanel.setLayout(new GridBagLayout());
			centerPanel.add(directoryLabel, gridBagConstraints);
			centerPanel.add(filenameLabel, gridBagConstraints1);
			centerPanel.add(getDirectoryField(), gridBagConstraints2);
			centerPanel.add(getFilenameField(), gridBagConstraints3);
			centerPanel.add(getDirectoryBrowseButton(), gridBagConstraints4);
			centerPanel.add(getBallotLocationField(), gridBagConstraints11);
			centerPanel.add(getBallotBrowseButton(), gridBagConstraints21);
			centerPanel.add(ballotLabel, gridBagConstraints31);
			centerPanel.add(getDebugCheckBox(), gridBagConstraints12);
			centerPanel.add(debugLabel, gridBagConstraints22);
		}
		return centerPanel;
	}

	/**
	 * This method initializes directoryField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getDirectoryField() {
		if (directoryField == null) {
			directoryField = new JTextField();
			directoryField.setEditable(false);
		}
		return directoryField;
	}

	/**
	 * This method initializes filenameField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getFilenameField() {
		if (filenameField == null) {
			filenameField = new JTextField();
		}
		return filenameField;
	}

	/**
	 * This method initializes directoryBrowseButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getDirectoryBrowseButton() {
		if (directoryBrowseButton == null) {
			directoryBrowseButton = new JButton();
			directoryBrowseButton.setText("Browse");
			directoryBrowseButton
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							directoryField.setText(getDir());
						}
					});
		}
		return directoryBrowseButton;
	}

	/**
	 * Launch a chooser and get a directory.
	 * 
	 * @return
	 */
	private String getDir() {
		JFileChooser chooser = new JFileChooser();

		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION)
			return chooser.getSelectedFile().getAbsolutePath();
		return "";
	}

	/**
	 * Launch a chooser and get a zip file.
	 * 
	 * @return
	 */
	private String getZipFile() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileFilter() {

			@Override
			public boolean accept(File arg0) {
				return arg0.isDirectory()
						|| arg0.getName().toLowerCase().endsWith(".zip");
			}

			@Override
			public String getDescription() {
				return "Zip Files";
			}
		});
		
		int returnVal = chooser.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION)
			return chooser.getSelectedFile().getAbsolutePath();
		return "";
	}

	/**
	 * This method initializes ballotLocationField
	 * 
	 * @return javax.swing.JTextField
	 */
	private JTextField getBallotLocationField() {
		if (ballotLocationField == null) {
			ballotLocationField = new JTextField();
			ballotLocationField.setEditable(false);
		}
		return ballotLocationField;
	}

	/**
	 * This method initializes ballotBrowseButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBallotBrowseButton() {
		if (ballotBrowseButton == null) {
			ballotBrowseButton = new JButton();
			ballotBrowseButton.setText("Browse");
			ballotBrowseButton
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							ballotLocationField.setText(getZipFile());
						}
					});
		}
		return ballotBrowseButton;
	}

	/**
	 * Call this method to dispaly a message to the user.
	 * 
	 * @param title This is the title of the message.
	 * @param message This is the message body.
	 */
	public void statusMessage(String title, String message) {
		JOptionPane.showMessageDialog(null, message, title,
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Call this method to ask the user a question.
	 * 
	 * @param title This is the title of the question.
	 * @param message This is the actual question.
	 * @return This method will return true if the user's answer was 'yes',
	 *         false otherwise.
	 */
	public boolean askQuestion(String title, String message) {
		return JOptionPane.showOptionDialog(this, message, title,
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
				null, null, null) == JOptionPane.OK_OPTION;

	}

	/**
	 * Call this method to set the text fields to some intended values.
	 * 
	 * @param logdir The "Log Directory.." field will get set to this.
	 * @param ballot The "Ballot Location.." field will get set to this.
	 * @param logfile The "Filename.." field will get set to this.
	 */
	public void setFields(String logdir, String ballot, String logfile) {
		getDirectoryField().setText(logdir);
		getBallotLocationField().setText(ballot);
		getFilenameField().setText(logfile);
	}

	/**
	 * Set the "enabled" state of the "launch" and "kill" buttons to reflect
	 * whether there is an instance of votebox currently running.
	 * 
	 * @param running Set this to true if there is an instance running, or false
	 *            if there is not.
	 */
	public void setRunning(boolean running) {
		if (running) {
			getKillButton().setEnabled(true);
			getLaunchButton().setEnabled(false);
		} else {
			getKillButton().setEnabled(false);
			getLaunchButton().setEnabled(true);
		}
	}

	/**
	 * This method initializes killButton
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getKillButton() {
		if (killButton == null) {
			killButton = new JButton();
			killButton.setText("Kill");
			killButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					parent.kill();
				}
			});
		}
		return killButton;
	}

	/**
	 * This method initializes debugCheckBox
	 * 
	 * @return javax.swing.JCheckBox
	 */
	private JCheckBox getDebugCheckBox() {
		if (debugCheckBox == null) {
			debugCheckBox = new JCheckBox();
		}
		return debugCheckBox;
	}

} // @jve:decl-index=0:visual-constraint="531,13"