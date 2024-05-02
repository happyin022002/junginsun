/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmBkg1422Event.java
*@FileTitle : WSC BKG List for audit
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.15
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2009.10.07 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.event;

import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.WscBkgListForAuditSchVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_BKG_1422 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_BKG_1422HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jeongmin Cho
 * @see ESM_BKG_1422HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmBkg1422Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private WscBkgListForAuditSchVO wscBkgListForAuditSchVO = null;

	public WscBkgListForAuditSchVO getWscBkgListForAuditSchVO() {
		return wscBkgListForAuditSchVO;
	}

	public void setWscBkgListForAuditSchVO(WscBkgListForAuditSchVO wscBkgListForAuditSchVO) {
		this.wscBkgListForAuditSchVO = wscBkgListForAuditSchVO;
	}

}