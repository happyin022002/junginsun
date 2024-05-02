/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0937Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgDoCntrVO;
import com.clt.syscommon.common.table.BkgDoVO;

/**
 * esm_bkg_0937 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0937HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0937HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0937Event extends EventSupport {

    /**
     *
     */
    private static final long serialVersionUID = 6505397460113280378L;

    private String doNo      = "";
    private String doNoSplit = "";
	private BkgDoVO[] bkgDoVOs = null;
	private BkgDoCntrVO[] bkgDoCntrVOs = null;
	
    public EsmBkg0937Event(){}

	public String getDoNo() {
		return doNo;
	}

	public void setDoNo(String doNo) {
		this.doNo = doNo;
	}

	public String getDoNoSplit() {
		return doNoSplit;
	}

	public void setDoNoSplit(String doNoSplit) {
		this.doNoSplit = doNoSplit;
	}

//	public BkgDoVO[] getBkgDoVOs() {
//		return bkgDoVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public BkgDoVO[] getBkgDoVOs() {
		BkgDoVO[] tmpVOs = null;
		if (this.bkgDoVOs != null) {
			tmpVOs = new BkgDoVO[bkgDoVOs.length];
			System.arraycopy(bkgDoVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 	

//	public void setBkgDoVOs(BkgDoVO[] bkgDoVOs) {
//		this.bkgDoVOs = bkgDoVOs;
//	}
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setBkgDoVOs(BkgDoVO[] bkgDoVOs) {
		if (bkgDoVOs != null) {
			BkgDoVO[] tmpVOs = new BkgDoVO[bkgDoVOs.length];
			System.arraycopy(bkgDoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgDoVOs = tmpVOs;
		}		
	}

//	public BkgDoCntrVO[] getBkgDoCntrVOs() {
//		return bkgDoCntrVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public BkgDoCntrVO[] getBkgDoCntrVOs() {
		BkgDoCntrVO[] tmpVOs = null;
		if (this.bkgDoCntrVOs != null) {
			tmpVOs = new BkgDoCntrVO[bkgDoCntrVOs.length];
			System.arraycopy(bkgDoCntrVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 	
	
//	public void setBkgDoCntrVOs(BkgDoCntrVO[] bkgDoCntrVOs) {
//		this.bkgDoCntrVOs = bkgDoCntrVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setBkgDoCntrVOs(BkgDoCntrVO[] bkgDoCntrVOs) {
		if (bkgDoCntrVOs != null) {
			BkgDoCntrVO[] tmpVOs = new BkgDoCntrVO[bkgDoCntrVOs.length];
			System.arraycopy(bkgDoCntrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgDoCntrVOs = tmpVOs;
		}		
	}
}