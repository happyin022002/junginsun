/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0015Event.java
*@FileTitle : Other Commission Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.12
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.12 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmaudit.otrcommaudit.event;

import com.hanjin.apps.alps.esm.acm.acmaudit.otrcommaudit.vo.OTRCommAuditVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Young-Oh
 * @see ESM_ACM_0015HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0015Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private OTRCommAuditVO otrCommAuditVO = null;

	private OTRCommAuditVO[] otrCommAuditVOs = null;

	public OTRCommAuditVO[] getOtrCommAuditVOs() {
		return otrCommAuditVOs;
	}

	public void setOtrCommAuditVOs(OTRCommAuditVO[] otrCommAuditVOs) {
		this.otrCommAuditVOs = otrCommAuditVOs;
	}

	public EsmAcm0015Event() {}

	public OTRCommAuditVO getOtrCommAuditVO() {
		return otrCommAuditVO;
	}

	public void setOtrCommAuditVO(OTRCommAuditVO otrCommAuditVO) {
		this.otrCommAuditVO = otrCommAuditVO;
	}

}