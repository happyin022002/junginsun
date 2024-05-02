/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1401Event.java
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

import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.AwkwardBKGListForAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.BKGvsBayPlanVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1401 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1401HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Day-Hoh, Kim
 * @see ESM_BKG_1401HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1401Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private AwkwardBKGListForAuditVO awkwardBKGListForAuditVO = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private BKGvsBayPlanVO bKGvsBayPlanVO = null;
	
	/** Table Value Object Multi Data 처리 */
//	public AwkwardBKGListForAuditVO[] awkwardBKGListForAuditVOs = null;

	
	public void setAwkwardBKGListForAuditVO(AwkwardBKGListForAuditVO awkwardBKGListForAuditVO){
		this. awkwardBKGListForAuditVO = awkwardBKGListForAuditVO;
	}

//	public void setAwkwardBKGListForAuditVOS(AwkwardBKGListForAuditVO[] awkwardBKGListForAuditVOs){
//		this. awkwardBKGListForAuditVOs = awkwardBKGListForAuditVOs;
//	}

	public AwkwardBKGListForAuditVO getAwkwardBKGListForAuditVO(){
		return awkwardBKGListForAuditVO;
	}

//	public AwkwardBKGListForAuditVO[] getAwkwardBKGListForAuditVOS(){
//		return awkwardBKGListForAuditVOs;
//	}

//	/**
//	 * @return the AwkwardBKGListForAuditVOs
//	 */
//	public AwkwardBKGListForAuditVO[] getAwkwardBKGListForAuditVOs() {
//		return awkwardBKGListForAuditVOs;
//	}
//
//	/**
//	 * @param AwkwardBKGListForAuditVOs the AwkwardBKGListForAuditVOs to set
//	 */
//	public void setAwkwardBKGListForAuditVOs(AwkwardBKGListForAuditVO[] awkwardBKGListForAuditVOs) {
//		this.awkwardBKGListForAuditVOs = awkwardBKGListForAuditVOs;
//	}
	
	public void setBKGvsBayPlanVO(BKGvsBayPlanVO bKGvsBayPlanVO){
		this. bKGvsBayPlanVO = bKGvsBayPlanVO;
	}
	
	public BKGvsBayPlanVO getBKGvsBayPlanVO(){
		return bKGvsBayPlanVO;
	}
	
}