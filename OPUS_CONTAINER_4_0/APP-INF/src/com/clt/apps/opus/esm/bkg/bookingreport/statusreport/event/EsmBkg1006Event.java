/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1006Event.java
*@FileTitle : 1006 Queue Detail Amend Reason Detail을 조회합니다.
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingreport.statusreport.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.DocsAmendReasonCDVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_1006HTMLAction 참조
 * @since J2EE 1.5
 */

public class EsmBkg1006Event extends EventSupport {

	public DocsAmendReasonCDVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(DocsAmendReasonCDVO infoVO) {
		this.infoVO = infoVO;
	}
	
	public DocsAmendReasonCDVO[] getInfoVOs() {
		DocsAmendReasonCDVO[] rtnVOs = null;
		if (this.infoVOs != null) {
			rtnVOs = Arrays.copyOf(infoVOs, infoVOs.length);
		}
		return rtnVOs;
	}

	public void setInfoVOs(DocsAmendReasonCDVO[] infoVOs) {
		if (infoVOs != null) {
			DocsAmendReasonCDVO[] tmpVOs = Arrays.copyOf(infoVOs, infoVOs.length);
			this.infoVOs = tmpVOs;
		}
	}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getSrNo() {
		return srNo;
	}

	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}

	public String getSrKndCd() {
		return srKndCd;
	}

	public void setSrKndCd(String srKndCd) {
		this.srKndCd = srKndCd;
	}

	/** Table Value Object 조회 조건 및 단건 처리  */
	private DocsAmendReasonCDVO infoVO = null;
	/** Table Value Object Multi Data 처리 */
	private DocsAmendReasonCDVO[] infoVOs = null;

	private  String bkgNo;
	private  String srNo;
	private  String srKndCd	;
	
	public EsmBkg1006Event(){}
	
	private static final long serialVersionUID = 1L;


	
	
}