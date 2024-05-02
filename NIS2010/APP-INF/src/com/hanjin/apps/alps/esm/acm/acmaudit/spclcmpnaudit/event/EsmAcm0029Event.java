/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0029Event.java
*@FileTitle : Special Compensation Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.23
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.23 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmaudit.spclcmpnaudit.event;

import com.hanjin.apps.alps.esm.acm.acmaudit.spclcmpnaudit.vo.SPCLCmpnAuditVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0029 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0029HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Young-Oh
 * @see ESM_ACM_0029HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0029Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SPCLCmpnAuditVO spcLCmpnAuditVO = null;

	/** Table Value Object Multi Data 처리 */
	private SPCLCmpnAuditVO[] spcLCmpnAuditVOs = null;

	public EsmAcm0029Event() {}

	public SPCLCmpnAuditVO getSpcLCmpnAuditVO() {
		return spcLCmpnAuditVO;
	}

	public void setSpcLCmpnAuditVO(SPCLCmpnAuditVO spcLCmpnAuditVO) {
		this.spcLCmpnAuditVO = spcLCmpnAuditVO;
	}

	public SPCLCmpnAuditVO[] getSpcLCmpnAuditVOs() {
		return spcLCmpnAuditVOs;
	}

	public void setSpcLCmpnAuditVOs(SPCLCmpnAuditVO[] spcLCmpnAuditVOs) {
		this.spcLCmpnAuditVOs = spcLCmpnAuditVOs;
	}

}