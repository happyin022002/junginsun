/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri601401Event.java
*@FileTitle : RFA Quotation Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.09.03 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.event;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.vo.RsltGrpLocDtlListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.vo.RFAGroupLocationQuotationVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_6014_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6014_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6014_01HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri601401Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	RFAGroupLocationQuotationVO groupLocationQuotationVO = new RFAGroupLocationQuotationVO();
	/** Table Value Object Multi Data 처리 */
	private RsltGrpLocDtlListVO[] rsltGrpLocDtlListVOs = null;
	/**
	 * @return the groupLocationQuotationVO
	 */
	public RFAGroupLocationQuotationVO getGroupLocationQuotationVO() {
		return groupLocationQuotationVO;
	}

	/**
	 * @param groupLocationQuotationVO the groupLocationQuotationVO to set
	 */
	public void setGroupLocationQuotationVO(
			RFAGroupLocationQuotationVO groupLocationQuotationVO) {
		this.groupLocationQuotationVO = groupLocationQuotationVO;
	}
	
	public RsltGrpLocDtlListVO[] getRsltGrpLocDtlListVOs() {
		return rsltGrpLocDtlListVOs;
	}

	public void setRsltGrpLocDtlListVOs(RsltGrpLocDtlListVO[] rsltGrpLocDtlListVOs) {
		this.rsltGrpLocDtlListVOs = rsltGrpLocDtlListVOs;
	}	

}