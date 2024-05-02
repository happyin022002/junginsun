/**
 * 
 */
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

import java.util.HashMap;
import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * @author 박미옥
 *
 */
public class PkupNoVerifyVO extends AbstractValueObject {
	
	private static final long serialVersionUID = 1L;

	/** Pickup Notice No Verify Result Info */
	private List<PkupNoRptVO> pkupNoRptVOs;

	/** Pickup Notice Hour Info */
	private List<PkupNoMnlUpldVO> pkupNoMnlUpldVOs;

	

	/**
	 * @param pkupNoRptVOs the pkupNoRptVOs to set
	 */
	public void setPkupNoRptVOs(List<PkupNoRptVO> pkupNoRptVOs) {
		this.pkupNoRptVOs = pkupNoRptVOs;
	}

	/**
	 * @return the pkupNoRptVOs
	 */
	public List<PkupNoRptVO> getPkupNoRptVOs() {
		return pkupNoRptVOs;
	}

	/**
	 * @param pkupNoMnlUpldVOs the pkupNoMnlUpldVOs to set
	 */
	public void setPkupNoMnlUpldVOs(List<PkupNoMnlUpldVO> pkupNoMnlUpldVOs) {
		this.pkupNoMnlUpldVOs = pkupNoMnlUpldVOs;
	}

	/**
	 * @return the pkupNoMnlUpldVOs
	 */
	public List<PkupNoMnlUpldVO> getPkupNoMnlUpldVOs() {
		return pkupNoMnlUpldVOs;
	}

	/* (non-Javadoc)
	 * @see com.hanjin.framework.component.common.AbstractValueObject#getColumnValues()
	 */
	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.hanjin.framework.component.common.AbstractValueObject#getFieldNames()
	 */
	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}
}
