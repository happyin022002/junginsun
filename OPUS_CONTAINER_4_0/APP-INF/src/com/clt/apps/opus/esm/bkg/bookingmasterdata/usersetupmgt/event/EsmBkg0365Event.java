/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UiBkg0365Event.java
*@FileTitle : Mark & Description Template
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.04.27 김영출
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgUsrTmpltVO;


/**
 * UI_BKG-0365 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  UI_BKG-0365HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Youngchul
 * @see UI_BKG-0365HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0365Event extends EventSupport {

	private static final long serialVersionUID = 1L;

    /** Table Value Object 조회 조건 및 단건 처리 */
    private BkgUsrTmpltVO     bkgUsrTmpltVO    = null;
    private BkgUsrTmpltVO[]   bkgUsrTmpltVOs   = null;
    private String            tmpltTpCd        = null;
    private String            returnObject     = null;
    private String            bkgNo            = null;

	public EsmBkg0365Event(){}
	
	/**
	 * 
	 * @param bkgUsrTmpltVO
	 */
	public void setBkgUsrTmpltVO(BkgUsrTmpltVO bkgUsrTmpltVO){
		this. bkgUsrTmpltVO = bkgUsrTmpltVO;
	}

	/**
	 * 
	 * @param bkgUsrTmpltVOs
	 */
//	public void setBkgUsrTmpltVOS(BkgUsrTmpltVO[] bkgUsrTmpltVOs){
//		this. bkgUsrTmpltVOs = bkgUsrTmpltVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public void setBkgUsrTmpltVOS(BkgUsrTmpltVO[] bkgUsrTmpltVOs){
		if (bkgUsrTmpltVOs != null) {
			BkgUsrTmpltVO[] tmpVOs = new BkgUsrTmpltVO[bkgUsrTmpltVOs.length];
			System.arraycopy(bkgUsrTmpltVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgUsrTmpltVOs = tmpVOs;
		}		
	}	
	
	/**
	 * 
	 * @return
	 */
	public BkgUsrTmpltVO getBkgUsrTmpltVO(){
		return bkgUsrTmpltVO;
	}

	/**
	 * 
	 * @return
	 */
//	public BkgUsrTmpltVO[] getBkgUsrTmpltVOS(){
//		return bkgUsrTmpltVOs;
//	}

	//2015.04.10 Secure Coding 적용[CWE-496]
	public BkgUsrTmpltVO[] getBkgUsrTmpltVOS(){
		BkgUsrTmpltVO[] tmpVOs = null;
		if (this.bkgUsrTmpltVOs != null) {
			tmpVOs = new BkgUsrTmpltVO[bkgUsrTmpltVOs.length];
			System.arraycopy(bkgUsrTmpltVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	}
	
	/**
	 * 
	 * @return
	 */
    public String getTmpltTpCd() {
        return tmpltTpCd;
    }
    
    /**
     * 
     * @param tmpltTpCd
     */
    public void setTmpltTpCd(String tmpltTpCd) {
        this.tmpltTpCd  = tmpltTpCd;
    }

    /**
     * 
     * @return
     */
    public String getReturnObject() {
        return returnObject;
    }

    /**
     * 
     * @param rtnObj
     */
    public void setReturnObject(String rtnObj) {
        this.returnObject  = rtnObj;
    }

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

}