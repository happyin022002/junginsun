/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg0256Event.java
*@FileTitle : Unmatch B/L Inquiry by Regional Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.22 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event;

import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.UnmatchSettlementListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_BKG_0569 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_0569HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung Jun Lee
 * @see ESM_BKG_0569HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg0569Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private UnmatchSettlementListVO unmatchSettlementListVO = null;

	/**
	 * @return the unmatchSettlementListVO
	 */
	public UnmatchSettlementListVO getUnmatchSettlementListVO() {
		return unmatchSettlementListVO;
	}

	/**
	 * @param unmatchSettlementListVO the unmatchSettlementListVO to set
	 */
	public void setUnmatchSettlementListVO(
			UnmatchSettlementListVO unmatchSettlementListVO) {
		this.unmatchSettlementListVO = unmatchSettlementListVO;
	}


}