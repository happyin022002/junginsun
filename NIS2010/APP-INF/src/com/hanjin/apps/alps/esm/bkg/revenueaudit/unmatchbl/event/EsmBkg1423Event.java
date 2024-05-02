/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1423Event.java
*@FileTitle : Audit by CNTR Qty Discrepancy
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.29
*@LastModifier : 조창우
*@LastVersion : 1.0
* 2016.04.29 조창우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event;

import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.IndiaDthBKGListForAuditVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1423 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1423HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Changwoo Cho
 * @see ESM_BKG_1423HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1423Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private IndiaDthBKGListForAuditVO IndiaDthBKGListForAuditVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public IndiaDthBKGListForAuditVO[] IndiaDthBKGListForAuditVOs = null;

	
	public void setIndiaDthBKGListForAuditVO(IndiaDthBKGListForAuditVO IndiaDthBKGListForAuditVO){
		this. IndiaDthBKGListForAuditVO = IndiaDthBKGListForAuditVO;
	}

	public void setIndiaDthBKGListForAuditVOS(IndiaDthBKGListForAuditVO[] IndiaDthBKGListForAuditVOs){
		this. IndiaDthBKGListForAuditVOs = IndiaDthBKGListForAuditVOs;
	}

	public IndiaDthBKGListForAuditVO getIndiaDthBKGListForAuditVO(){
		return IndiaDthBKGListForAuditVO;
	}

	public IndiaDthBKGListForAuditVO[] getIndiaDthBKGListForAuditVOS(){
		return IndiaDthBKGListForAuditVOs;
	}

	/**
	 * @return the IndiaDthBKGListForAuditVOs
	 */
	public IndiaDthBKGListForAuditVO[] getIndiaDthBKGListForAuditVOs() {
		return IndiaDthBKGListForAuditVOs;
	}
	/**
	 * @param IndiaDthBKGListForAuditVOs the IndiaDthBKGListForAuditVOs to set
	 */
	public void setIndiaDthBKGListForAuditVOs(IndiaDthBKGListForAuditVO[] IndiaDthBKGListForAuditVOs) {
		this.IndiaDthBKGListForAuditVOs = IndiaDthBKGListForAuditVOs;
	}
	
}