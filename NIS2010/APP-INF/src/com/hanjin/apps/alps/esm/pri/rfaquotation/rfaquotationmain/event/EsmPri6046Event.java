/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6046Event.java
*@FileTitle : RFA Quotation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.06 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.event;

import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_6046 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6046HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6046HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6046Event extends EventSupport {

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