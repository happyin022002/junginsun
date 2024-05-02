/**
 * 
 */
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

import java.util.HashMap;
import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.syscommon.common.table.BkgPkupNtcStupVO;

/**
 * @author
 *
 */
public class PkupNtcFormVO extends AbstractValueObject {
	
	private static final long serialVersionUID = 1L;

	/** Pickup Notice Setup Info */
	private BkgPkupNtcStupVO bkgPkupNtcStupVO;

	/** Pickup Notice Word Info */
	private PkupWdVO[] bkgPkupWdVOs;
	
	/** Pickup Notice Hour Info */
	private List<PkupNtcHrVO> [] bkgPkupNtcHrVOs;

	
	/**
	 * @return the bkgPkupWdVOs
	 */
	public PkupWdVO[] getBkgPkupWdVOs() {
		return bkgPkupWdVOs;
	}

	public PkupWdVO getBkgPkupWdVO(int index) {
		return bkgPkupWdVOs[index];
	}

	/**
	 * @param bkgPkupWdVOs the bkgPkupWdVOs to set
	 */
	public void setBkgPkupWdVOs(PkupWdVO[] bkgPkupWdVOs) {
		this.bkgPkupWdVOs = bkgPkupWdVOs;
	}

	/**
	 * @return the bkgPkupNtcHrVOs
	 */
	public List<PkupNtcHrVO>[] getBkgPkupNtcHrVOs() {
		return bkgPkupNtcHrVOs;
	}

	public List<PkupNtcHrVO> getBkgPkupNtcHrVO(int index) {
		return bkgPkupNtcHrVOs[index];
	}

	
	/**
	 * @param bkgPkupNtcHrVOs the bkgPkupNtcHrVOs to set
	 */
	public void setBkgPkupNtcHrVOs(List<PkupNtcHrVO>[] bkgPkupNtcHrVOs) {
		this.bkgPkupNtcHrVOs = bkgPkupNtcHrVOs;
	}


	/**
	 * @param bkgPkupNtcStupVO the bkgPkupNtcStupVO to set
	 */
	public void setBkgPkupNtcStupVO(BkgPkupNtcStupVO bkgPkupNtcStupVO) {
		this.bkgPkupNtcStupVO = bkgPkupNtcStupVO;
	}
	
	/**
	 * @return the bkgPkupNtcStupVO
	 */
	public BkgPkupNtcStupVO getBkgPkupNtcStupVO() {
		return bkgPkupNtcStupVO;
	}
	

	/* (non-Javadoc)
	 * @see com.clt.framework.component.common.AbstractValueObject#getColumnValues()
	 */
	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.clt.framework.component.common.AbstractValueObject#getFieldNames()
	 */
	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}
}
