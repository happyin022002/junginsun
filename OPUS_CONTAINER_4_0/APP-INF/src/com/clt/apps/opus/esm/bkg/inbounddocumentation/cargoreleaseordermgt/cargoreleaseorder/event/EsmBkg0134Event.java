/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0134Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 
*@LastVersion : 1.0
* 2009.06.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgEdoLogVO;

/**
 * esm_bkg_0134 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0134HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0134HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0134Event extends EventSupport {

    /**
     *
     */
    private static final long serialVersionUID = 6505397460113280378L;

    private String rcvToDt      = "";
    private String rcvFmDt      = "";
    private String blNo         = "";

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgEdoLogVO bkgEdoLogVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgEdoLogVO[] bkgEdoLogVOs = null;
    

    public EsmBkg0134Event(){}

    /**
     * @return the rcvToDt
     */
    public String getRcvToDt() {
        return rcvToDt;
    }

    /**
     * @param rcvToDt the rcvToDt to set
     */
    public void setRcvToDt(String rcvToDt) {
        this.rcvToDt = rcvToDt;
    }

    /**
     * @return the rcvFmDt
     */
    public String getRcvFmDt() {
        return rcvFmDt;
    }

    /**
     * @param rcvFmDt the rcvFmDt to set
     */
    public void setRcvFmDt(String rcvFmDt) {
        this.rcvFmDt = rcvFmDt;
    }

    /**
     * @return the blNo
     */
    public String getBlNo() {
        return blNo;
    }

    /**
     * @param blNo the blNo to set
     */
    public void setBlNo(String blNo) {
        this.blNo = blNo;
    }    
    
	/**
	 * @return the bkgEdoLogVO
	 */
	public BkgEdoLogVO getBkgEdoLogVO() {
		return bkgEdoLogVO;
	}

	/**
	 * @param bkgEdoLogVO the bkgEdoLogVO to set
	 */
	public void setBkgEdoLogVO(BkgEdoLogVO bkgEdoLogVO) {
		this.bkgEdoLogVO = bkgEdoLogVO;
	}

	/**
	 * @return the BkgEdoLogVOs
	 */
//	public BkgEdoLogVO[] getBkgEdoLogVOs() {
//		return bkgEdoLogVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public BkgEdoLogVO[] getBkgEdoLogVOs() {
		BkgEdoLogVO[] tmpVOs = null;
		if (this.bkgEdoLogVOs != null) {
			tmpVOs = new BkgEdoLogVO[bkgEdoLogVOs.length];
			System.arraycopy(bkgEdoLogVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 
	
	/**
	 * @param bkgEdoLogVOs the BkgEdoLogVOs to set
	 */
//	public void setBkgEdoLogVOs(
//			BkgEdoLogVO[] bkgEdoLogVOs) {
//		this.bkgEdoLogVOs = bkgEdoLogVOs;
//	}  
	
	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setBkgEdoLogVOs(BkgEdoLogVO[] bkgEdoLogVOs) {
		if (bkgEdoLogVOs != null) {
			BkgEdoLogVO[] tmpVOs = new BkgEdoLogVO[bkgEdoLogVOs.length];
			System.arraycopy(bkgEdoLogVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgEdoLogVOs = tmpVOs;
		}		
	} 	
}