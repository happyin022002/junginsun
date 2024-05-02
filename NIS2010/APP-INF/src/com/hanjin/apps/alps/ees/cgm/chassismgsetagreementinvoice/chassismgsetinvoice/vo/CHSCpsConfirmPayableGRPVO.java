/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSCpsConfirmPayableGRPVO.java
*@FileTitle : CHSCpsConfirmPayableGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.01
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2013.04.01 조경완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo;

import java.util.List;


/**
 * Search Param VO Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 조경완
 * @since J2EE 1.6
 * @see OnOffHireAuditDetailVO, OnOffHireAuditSearchVO
 */
public class CHSCpsConfirmPayableGRPVO {

	private static final long serialVersionUID = 1L;

	/** Table Value Object Multi Data 처리 */

	private  List<List<CHSCpsPayableInvoiceCreationMGTVO>> cHSCpsPayableInvoiceCreationMGTVOs = null;
	
	private List<CHSCpsInvoiceAuditResultCmmtCrMGTVO> cHSCpsInvoiceAuditResultCmmtCrMGTVO = null;

	public List<List<CHSCpsPayableInvoiceCreationMGTVO>> getCHSCpsPayableInvoiceCreationMGTVOs() {
		return cHSCpsPayableInvoiceCreationMGTVOs;
	}

	public void setCHSCpsPayableInvoiceCreationMGTVOs(
			List<List<CHSCpsPayableInvoiceCreationMGTVO>> cpsPayableInvoiceCreationMGTVOs) {
		cHSCpsPayableInvoiceCreationMGTVOs = cpsPayableInvoiceCreationMGTVOs;
	}
	
	public List<CHSCpsInvoiceAuditResultCmmtCrMGTVO> getcHSCpsInvoiceAuditResultCmmtCrMGTVO() {
		return cHSCpsInvoiceAuditResultCmmtCrMGTVO;
	}
	
	public void setcHSCpsInvoiceAuditResultCmmtCrMGTVO(
			List<CHSCpsInvoiceAuditResultCmmtCrMGTVO> cHSCpsInvoiceAuditResultCmmtCrMGTVO) {
		this.cHSCpsInvoiceAuditResultCmmtCrMGTVO = cHSCpsInvoiceAuditResultCmmtCrMGTVO;
	}
	
}
