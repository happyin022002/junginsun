/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6005Event.java
*@FileTitle : S/C Quotation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.06
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.06 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.event;

import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_6034 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6034HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6034HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6033Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	RsltCopyToProposalVO rsltCopyToProposalVO = new RsltCopyToProposalVO();

	/**
	 * @return the rsltCopyToProposalVO
	 */
	public RsltCopyToProposalVO getRsltCopyToProposalVO() {
		return rsltCopyToProposalVO;
	}

	/**
	 * @param rsltCopyToProposalVO the rsltCopyToProposalVO to set
	 */
	public void setRsltCopyToProposalVO(RsltCopyToProposalVO rsltCopyToProposalVO) {
		this.rsltCopyToProposalVO = rsltCopyToProposalVO;
	}

}