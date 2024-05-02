/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0107Event.java
*@FileTitle : Audit Confirm 팝업
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.05
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.05 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmaudit.agncommaudit.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.acm.acmaudit.agncommaudit.vo.AGNCommAuditConfirmVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0107 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0107HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Young-Oh
 * @see ESM_ACM_0008HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0107Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AGNCommAuditConfirmVO agnCommAuditConfirmVO = null;

	/** Table Value Object Multi Data 처리 */
	private AGNCommAuditConfirmVO[] agnCommAuditConfirmVOs = null;

	public EsmAcm0107Event() {}

	public AGNCommAuditConfirmVO getAgnCommAuditConfirmVO() {
		return agnCommAuditConfirmVO;
	}

	public void setAgnCommAuditConfirmVO(AGNCommAuditConfirmVO agnCommAuditConfirmVO) {
		this.agnCommAuditConfirmVO = agnCommAuditConfirmVO;
	}

	public AGNCommAuditConfirmVO[] getAgnCommAuditConfirmVOs() {
		AGNCommAuditConfirmVO[] rtnVOs = null;
		if (this.agnCommAuditConfirmVOs != null) {
			rtnVOs = Arrays.copyOf(agnCommAuditConfirmVOs, agnCommAuditConfirmVOs.length);
		}
		return rtnVOs;
	}

	public void setAgnCommAuditConfirmVOs(
			AGNCommAuditConfirmVO[] agnCommAuditConfirmVOs) {
		if(agnCommAuditConfirmVOs != null){
			AGNCommAuditConfirmVO[] tmpVOs = Arrays.copyOf(agnCommAuditConfirmVOs, agnCommAuditConfirmVOs.length);
			this.agnCommAuditConfirmVOs  = tmpVOs;
		}
	}
}