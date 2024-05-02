/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0937Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.25
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.05.12 임진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgDoCntrVO;
import com.hanjin.syscommon.common.table.BkgDoVO;

/**
 * esm_bkg_0937 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0937HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author An Jin Eung
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

	public BkgDoVO[] getBkgDoVOs() {
		return bkgDoVOs;
	}

	public void setBkgDoVOs(BkgDoVO[] bkgDoVOs) {
		this.bkgDoVOs = bkgDoVOs;
	}

	public BkgDoCntrVO[] getBkgDoCntrVOs() {
		return bkgDoCntrVOs;
	}

	public void setBkgDoCntrVOs(BkgDoCntrVO[] bkgDoCntrVOs) {
		this.bkgDoCntrVOs = bkgDoCntrVOs;
	}

    
}