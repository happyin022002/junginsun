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
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByCNTRQtyDiscrepancyListVO;
import com.clt.framework.support.layer.event.EventSupport;

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
	private RsltSearchAuditByCNTRQtyDiscrepancyListVO[] rsltSearchAuditByCNTRQtyDiscrepancyListVOs = null;

	
	public void setRsltSearchAuditByCNTRQtyDiscrepancyListVO(RsltSearchAuditByCNTRQtyDiscrepancyListVO rsltSearchAuditByCNTRQtyDiscrepancyListVO){
		this. rsltSearchAuditByCNTRQtyDiscrepancyListVO = rsltSearchAuditByCNTRQtyDiscrepancyListVO;
	}

	public RsltSearchAuditByCNTRQtyDiscrepancyListVO getRsltSearchAuditByCNTRQtyDiscrepancyListVO(){
		return rsltSearchAuditByCNTRQtyDiscrepancyListVO;
	}

	public RsltSearchAuditByCNTRQtyDiscrepancyListVO[] getRsltSearchAuditByCNTRQtyDiscrepancyListVOs() {
		RsltSearchAuditByCNTRQtyDiscrepancyListVO[] rtnVOs = null;
		if (this.rsltSearchAuditByCNTRQtyDiscrepancyListVOs != null) {
			rtnVOs = Arrays.copyOf(rsltSearchAuditByCNTRQtyDiscrepancyListVOs,rsltSearchAuditByCNTRQtyDiscrepancyListVOs.length);
		}
		return rtnVOs;
	}

	public void setRsltSearchAuditByCNTRQtyDiscrepancyListVOs(RsltSearchAuditByCNTRQtyDiscrepancyListVO[] rsltSearchAuditByCNTRQtyDiscrepancyListVOs) {
		if (rsltSearchAuditByCNTRQtyDiscrepancyListVOs != null) {
			RsltSearchAuditByCNTRQtyDiscrepancyListVO[] tmpVOs = Arrays.copyOf(rsltSearchAuditByCNTRQtyDiscrepancyListVOs,rsltSearchAuditByCNTRQtyDiscrepancyListVOs.length);
			this.rsltSearchAuditByCNTRQtyDiscrepancyListVOs = tmpVOs;
		}
	}
	public RsltSearchAuditByCNTRQtyDiscrepancyListVO[] getRsltSearchAuditByCNTRQtyDiscrepancyListVOS() {
		RsltSearchAuditByCNTRQtyDiscrepancyListVO[] rtnVOs = null;
		if (this.rsltSearchAuditByCNTRQtyDiscrepancyListVOs != null) {
			rtnVOs = Arrays.copyOf(rsltSearchAuditByCNTRQtyDiscrepancyListVOs,rsltSearchAuditByCNTRQtyDiscrepancyListVOs.length);
		}
		return rtnVOs;
	}

	public void setRsltSearchAuditByCNTRQtyDiscrepancyListVOS(RsltSearchAuditByCNTRQtyDiscrepancyListVO[] rsltSearchAuditByCNTRQtyDiscrepancyListVOs) {
		if (rsltSearchAuditByCNTRQtyDiscrepancyListVOs != null) {
			RsltSearchAuditByCNTRQtyDiscrepancyListVO[] tmpVOs = Arrays.copyOf(rsltSearchAuditByCNTRQtyDiscrepancyListVOs,rsltSearchAuditByCNTRQtyDiscrepancyListVOs.length);
			this.rsltSearchAuditByCNTRQtyDiscrepancyListVOs = tmpVOs;
		}
	}

	
	
}