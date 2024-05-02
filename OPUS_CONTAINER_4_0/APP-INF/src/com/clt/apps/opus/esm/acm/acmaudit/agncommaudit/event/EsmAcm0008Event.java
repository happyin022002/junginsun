/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0008Event.java
*@FileTitle : Commission Agreement Creation_Master
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.02
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.02 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmaudit.agncommaudit.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.acm.acmaudit.agncommaudit.vo.AGNCommAuditVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_0008HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0008Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AGNCommAuditVO agnCommAuditVO = null;

	/** Table Value Object Multi Data 처리 */
	private AGNCommAuditVO[] agnCommAuditVOs = null;

	public EsmAcm0008Event() {}

	public AGNCommAuditVO getAGNCommAuditVO() {
		return agnCommAuditVO;
	}

	public void setAGNCommAuditVO(AGNCommAuditVO agnCommAuditVO) {
		this.agnCommAuditVO = agnCommAuditVO;
	}

	public AGNCommAuditVO[] getAGNCommAuditVOs() {
		AGNCommAuditVO[] rtnVOs = null;
		if (this.agnCommAuditVOs != null) {
			rtnVOs = Arrays.copyOf(agnCommAuditVOs, agnCommAuditVOs.length);
		}
		return rtnVOs;
	}

	public void setAGNCommAuditVOs(AGNCommAuditVO[] agnCommAuditVOs) {
		if(agnCommAuditVOs != null){
			AGNCommAuditVO[] tmpVOs = Arrays.copyOf(agnCommAuditVOs, agnCommAuditVOs.length);
			this.agnCommAuditVOs  = tmpVOs;
		}
	}
	
}