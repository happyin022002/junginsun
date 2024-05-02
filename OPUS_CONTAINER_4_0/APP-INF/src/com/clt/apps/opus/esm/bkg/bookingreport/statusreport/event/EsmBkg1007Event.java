/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1006Event.java
*@FileTitle : 1007 Queue Detail Amend Reason Detail을 조회합니다.
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

import com.clt.apps.opus.esm.bkg.bookingreport.statusreport.vo.DocsQueueDetailVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_1007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 김경섭
 * @see ESM_BKG_1007HTMLAction 참조
 * @since J2EE 1.5
 */

public class EsmBkg1007Event extends EventSupport {

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
	private DocsQueueDetailVO infoVO = null;
	/** Table Value Object Multi Data 처리 */
	private DocsQueueDetailVO[] infoVOs = null;

	public DocsQueueDetailVO getInfoVO() {
		return infoVO;
	}

	public void setInfoVO(DocsQueueDetailVO infoVO) {
		this.infoVO = infoVO;
	}

	public DocsQueueDetailVO[] getInfoVOs() {
		DocsQueueDetailVO[] rtnVOs = null;
		if (this.infoVOs != null) {
			rtnVOs = Arrays.copyOf(infoVOs, infoVOs.length);
		}
		return rtnVOs;
	}

	public void setInfoVOs(DocsQueueDetailVO[] infoVOs) {
		if (infoVOs != null) {
			DocsQueueDetailVO[] tmpVOs = Arrays.copyOf(infoVOs, infoVOs.length);
			this.infoVOs = tmpVOs;
		}
	}

	private  String bkgNo;
	private  String srNo;
	private  String srKndCd	;
	private  String srHisSeq	;
	
	public String getSrHisSeq() {
		return srHisSeq;
	}

	public void setSrHisSeq(String srHisSeq) {
		this.srHisSeq = srHisSeq;
	}

	public EsmBkg1007Event(){}
	
	private static final long serialVersionUID = 1L;


	
	
}