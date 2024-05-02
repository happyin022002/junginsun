/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri0025Event.java
*@FileTitle : Proposal Affiliate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2009.06.02 공백진
* 1.0 Creation
* 
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.pri.scproposal.scaffiliateproposal.vo.RsltAfilListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;

/**
 * ESM_PRI_0057_09 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_0057_09HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kong Back Jin
 * @see ESM_PRI_0057_09HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri005709Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltAfilListVO rsltAfilListVO = null;
	/** Table Value Object Multi Data 처리 */
	private RsltAfilListVO[] rsltAfilListVOs = null;
 
	private PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO = null;
	
	public EsmPri005709Event(){}
	
	/* set */
	public void setRsltAfilListVO(RsltAfilListVO rsltAfilListVO){
		this. rsltAfilListVO = rsltAfilListVO;
	}
	public void setRsltAfilListVOS(RsltAfilListVO[] rsltAfilListVOs){
		this. rsltAfilListVOs = rsltAfilListVOs;
	}

	/* get */
	public RsltAfilListVO getRsltAfilListVO(){
		return rsltAfilListVO;
	}
	public RsltAfilListVO[] getRsltAfilListVOS(){
		return rsltAfilListVOs;
	}

	public PriSpHistoryInquiryParamVO getPriSpHistoryInquiryParamVO() {
		return priSpHistoryInquiryParamVO;
	}

	public void setPriSpHistoryInquiryParamVO(
			PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) {
		this.priSpHistoryInquiryParamVO = priSpHistoryInquiryParamVO;
	}

}