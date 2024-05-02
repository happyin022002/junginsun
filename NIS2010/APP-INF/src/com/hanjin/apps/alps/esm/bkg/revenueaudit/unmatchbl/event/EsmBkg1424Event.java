/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1424Event.java
*@FileTitle : India THC BKG List for Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.28
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2016.06.28 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event;

import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.IranDthBKGListForAuditVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1424 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1424HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeongmin Cho
 * @see ESM_BKG_1424HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1424Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private IranDthBKGListForAuditVO iranDthBKGListForAuditVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public IranDthBKGListForAuditVO[] iranDthBKGListForAuditVOs = null;

	
	public void setIranDthBKGListForAuditVO(IranDthBKGListForAuditVO iranDthBKGListForAuditVO){
		this. iranDthBKGListForAuditVO = iranDthBKGListForAuditVO;
	}

	public void setIranDthBKGListForAuditVOS(IranDthBKGListForAuditVO[] iranDthBKGListForAuditVOs){
		this. iranDthBKGListForAuditVOs = iranDthBKGListForAuditVOs;
	}

	public IranDthBKGListForAuditVO getIranDthBKGListForAuditVO(){
		return iranDthBKGListForAuditVO;
	}

	public IranDthBKGListForAuditVO[] getIranDthBKGListForAuditVOS(){
		return iranDthBKGListForAuditVOs;
	}

	/**
	 * @return the iranDthBKGListForAuditVOs
	 */
	public IranDthBKGListForAuditVO[] getIranDthBKGListForAuditVOs() {
		return iranDthBKGListForAuditVOs;
	}
	/**
	 * @param iranDthBKGListForAuditVOs the iranDthBKGListForAuditVOs to set
	 */
	public void setIranDthBKGListForAuditVOs(IranDthBKGListForAuditVO[] iranDthBKGListForAuditVOs) {
		this.iranDthBKGListForAuditVOs = iranDthBKGListForAuditVOs;
	}
	
}