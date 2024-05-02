/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0948Event.java
*@FileTitle : Hold Mail/Alert Set-Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.BkgHldNtcUsrVO;



/**
 * ESM_BKG-0948 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG-0948HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG-0948HTMLAction 참조
 * @since J2EE 1.4
 */

public class EsmBkg0948Event extends EventSupport {
	   
	private static final long serialVersionUID = 1L;
	
	/** Location Code */
	private String locCd = "";
	
	/** User ID */
	private String userId = "";
	
	/** Country Code */
	private String cntCd = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BkgHldNtcUsrVO bkgHldNtcUsrVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private BkgHldNtcUsrVO[] bkgHldNtcUsrVOs = null;

	public EsmBkg0948Event(){}
	
	public void setBkgHldNtcUsrVO(BkgHldNtcUsrVO bkgHldNtcUsrVO){
		this. bkgHldNtcUsrVO = bkgHldNtcUsrVO;
	}

//	public void setBkgHldNtcUsrVOS(BkgHldNtcUsrVO[] bkgHldNtcUsrVOs){
//		this. bkgHldNtcUsrVOs = bkgHldNtcUsrVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public void setBkgHldNtcUsrVOS(BkgHldNtcUsrVO[] bkgHldNtcUsrVOs){
		if (bkgHldNtcUsrVOs != null) {
			BkgHldNtcUsrVO[] tmpVOs = new BkgHldNtcUsrVO[bkgHldNtcUsrVOs.length];
			System.arraycopy(bkgHldNtcUsrVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.bkgHldNtcUsrVOs = tmpVOs;
		}		
	} 
	
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public BkgHldNtcUsrVO getBkgHldNtcUsrVO(){
		return bkgHldNtcUsrVO;
	}

//	public BkgHldNtcUsrVO[] getBkgHldNtcUsrVOS(){
//		return bkgHldNtcUsrVOs;
//	}

	//2015.04.14 Secure Coding 적용[CWE-496]
	public BkgHldNtcUsrVO[] getBkgHldNtcUsrVOS(){
		BkgHldNtcUsrVO[] tmpVOs = null;
		if (this.bkgHldNtcUsrVOs != null) {
			tmpVOs = new BkgHldNtcUsrVO[bkgHldNtcUsrVOs.length];
			System.arraycopy(bkgHldNtcUsrVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;		
	} 
	
	public String getLocCd() {
		return locCd;
	}

	public String getUserId() {
		return userId;
	}

	/**
	 * @param cntCd the cntCd to set
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}

	/**
	 * @return the cntCd
	 */
	public String getCntCd() {
		return cntCd;
	}

}