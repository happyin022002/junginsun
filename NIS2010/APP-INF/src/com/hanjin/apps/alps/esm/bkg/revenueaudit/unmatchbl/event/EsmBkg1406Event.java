/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1406Event.java
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

import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.IhcBKGListForAuditVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1406 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1406HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Day-Hoh, Kim
 * @see ESM_BKG_1406HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1406Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private IhcBKGListForAuditVO ihcBKGListForAuditVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public IhcBKGListForAuditVO[] ihcBKGListForAuditVOs = null;

	
	public void setIhcBKGListForAuditVO(IhcBKGListForAuditVO ihcBKGListForAuditVO){
		this. ihcBKGListForAuditVO = ihcBKGListForAuditVO;
	}

	public void setIhcBKGListForAuditVOS(IhcBKGListForAuditVO[] ihcBKGListForAuditVOs){
		this. ihcBKGListForAuditVOs = ihcBKGListForAuditVOs;
	}

	public IhcBKGListForAuditVO getIhcBKGListForAuditVO(){
		return ihcBKGListForAuditVO;
	}

	public IhcBKGListForAuditVO[] getIhcBKGListForAuditVOS(){
		return ihcBKGListForAuditVOs;
	}

	/**
	 * @return the IhcBKGListForAuditVOs
	 */
	public IhcBKGListForAuditVO[] getIhcBKGListForAuditVOs() {
		return ihcBKGListForAuditVOs;
	}

	/**
	 * @param IhcBKGListForAuditVOs the IhcBKGListForAuditVOs to set
	 */
	public void setIhcBKGListForAuditVOs(IhcBKGListForAuditVO[] ihcBKGListForAuditVOs) {
		this.ihcBKGListForAuditVOs = ihcBKGListForAuditVOs;
	}
	
}