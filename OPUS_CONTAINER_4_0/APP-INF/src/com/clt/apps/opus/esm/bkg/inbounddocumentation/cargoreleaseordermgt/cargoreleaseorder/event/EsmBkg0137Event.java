/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0137Event.java
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
import com.clt.syscommon.common.table.BkgDoFomVO;

/**
 * esm_bkg_0137 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0137HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0137HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0137Event extends EventSupport {

    /**
     *
     */
    private static final long serialVersionUID = 6505397460113280378L;

    private String office      = "";
    
	/** PickUp Notice Setup Table Value Object 조회 조건 및 단건 처리  */
	private BkgDoFomVO bkgDoFomVO = null;
    /** Table Value Object Multi Data 처리 */
    private BkgDoFomVO[] bkgDoFomVOs = null;
	
    public EsmBkg0137Event(){}

    /**
     * @return the office
     */
    public String getOffice() {
        return office;
    }

    /**
     * @param rqstNo the rqstNo to set
     */
    public void setOffice(String office) {
        this.office = office;
    }
    
	/**
	 * @param bkgDoFomVO the bkgDoFomVO to set
	 */
	public void setBkgDoFomVO(BkgDoFomVO bkgDoFomVO) {
		this.bkgDoFomVO = bkgDoFomVO;
	}

	/**
	 * @return the bkgDoFomVO
	 */
	public BkgDoFomVO getBkgDoFomVO() {
		return bkgDoFomVO;
	}
	
    /**
     * @return the doStsVOs
     */
//    public BkgDoFomVO[] getBkgDoFomVOs() {
//        return bkgDoFomVOs;
//    }

	//2015.04.14 Secure Coding 적용[CWE-496]
    public BkgDoFomVO[] getBkgDoFomVOs() {
    	BkgDoFomVO[] tmpVOs = null;
		if (this.bkgDoFomVOs != null) {
			tmpVOs = new BkgDoFomVO[bkgDoFomVOs.length];
			System.arraycopy(bkgDoFomVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 
    
    /**
     * @param bkgDoFomVOs the bkgDoFomVOs to set
     */
//    public void setBkgDoFomVOs(BkgDoFomVO[] bkgDoFomVOs) {
//        this.bkgDoFomVOs = bkgDoFomVOs;
//    }
    
	//2015.04.14 Secure Coding 적용[CWE-496]
    public void setBkgDoFomVOs(BkgDoFomVO[] bkgDoFomVOs) {
		if (bkgDoFomVOs != null) {
			BkgDoFomVO[] tmpVOs = new BkgDoFomVO[bkgDoFomVOs.length];
			System.arraycopy(bkgDoFomVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgDoFomVOs = tmpVOs;
		}		
	}     
}