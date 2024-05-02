/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1079Event.java
*@FileTitle : Audit by CNTR Qty Discrepancy
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.19
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.10.07 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event;

import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByCNTRQtyDiscrepancyListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchBLListbyAuditorVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.BkgRevUmchBkgVO;

/**
 * ESM_BKG_1079 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1079HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Day-Hoh, Kim
 * @see ESM_BKG_1079HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1079Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RsltSearchAuditByCNTRQtyDiscrepancyListVO rsltSearchAuditByCNTRQtyDiscrepancyListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public RsltSearchAuditByCNTRQtyDiscrepancyListVO[] rsltSearchAuditByCNTRQtyDiscrepancyListVOs = null;

	
	public void setRsltSearchAuditByCNTRQtyDiscrepancyListVO(RsltSearchAuditByCNTRQtyDiscrepancyListVO rsltSearchAuditByCNTRQtyDiscrepancyListVO){
		this. rsltSearchAuditByCNTRQtyDiscrepancyListVO = rsltSearchAuditByCNTRQtyDiscrepancyListVO;
	}

	public void setRsltSearchAuditByCNTRQtyDiscrepancyListVOS(RsltSearchAuditByCNTRQtyDiscrepancyListVO[] rsltSearchAuditByCNTRQtyDiscrepancyListVOs){
		this. rsltSearchAuditByCNTRQtyDiscrepancyListVOs = rsltSearchAuditByCNTRQtyDiscrepancyListVOs;
	}

	public RsltSearchAuditByCNTRQtyDiscrepancyListVO getRsltSearchAuditByCNTRQtyDiscrepancyListVO(){
		return rsltSearchAuditByCNTRQtyDiscrepancyListVO;
	}

	public RsltSearchAuditByCNTRQtyDiscrepancyListVO[] getRsltSearchAuditByCNTRQtyDiscrepancyListVOS(){
		return rsltSearchAuditByCNTRQtyDiscrepancyListVOs;
	}

	/**
	 * @return the bkgRevUmchBkgVOs
	 */
	public RsltSearchAuditByCNTRQtyDiscrepancyListVO[] getRsltSearchAuditByCNTRQtyDiscrepancyListVOs() {
		return rsltSearchAuditByCNTRQtyDiscrepancyListVOs;
	}

	/**
	 * @param bkgRevUmchBkgVOs the bkgRevUmchBkgVOs to set
	 */
	public void setRsltSearchAuditByCNTRQtyDiscrepancyListVOs(RsltSearchAuditByCNTRQtyDiscrepancyListVO[] rsltSearchAuditByCNTRQtyDiscrepancyListVOs) {
		this.rsltSearchAuditByCNTRQtyDiscrepancyListVOs = rsltSearchAuditByCNTRQtyDiscrepancyListVOs;
	}
	
}