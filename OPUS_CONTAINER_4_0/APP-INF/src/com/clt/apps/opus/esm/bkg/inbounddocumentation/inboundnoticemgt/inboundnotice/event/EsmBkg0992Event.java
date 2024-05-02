/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0992Event.java
*@FileTitle : Pickup No Notice Setup copy Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcFormCopyVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0992 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0992HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_0992HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0992Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private String ofcCd = "";
	
	private String delCd = "";
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PkupNtcFormCopyVO pkupNtcFormCopy = null;
	
	public EsmBkg0992Event(){}

	/**
	 * @param ofcCd the ofcCd to set
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	/**
	 * @return the ofcCd
	 */
	public String getOfcCd() {
		return ofcCd;
	}

	/**
	 * @param delCd the delCd to set
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}

	/**
	 * @return the delCd
	 */
	public String getDelCd() {
		return delCd;
	}

	/**
	 * @param pkupNtcFormCopy the pkupNtcFormCopy to set
	 */
	public void setPkupNtcFormCopy(PkupNtcFormCopyVO pkupNtcFormCopy) {
		this.pkupNtcFormCopy = pkupNtcFormCopy;
	}

	/**
	 * @return the pkupNtcFormCopy
	 */
	public PkupNtcFormCopyVO getPkupNtcFormCopy() {
		return pkupNtcFormCopy;
	}


}