/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0027Event.java
*@FileTitle : FF Compensation Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.15
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.02 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmaudit.ffcmpnaudit.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.acm.acmaudit.ffcmpnaudit.vo.FFCmpnAuditVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0027 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0027HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Young-Oh
 * @see ESM_ACM_0027HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0027Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private FFCmpnAuditVO agnCommAuditVO = null;

	/** Table Value Object Multi Data 처리 */
	private FFCmpnAuditVO[] ffcmpnAuditVOs = null;

	public EsmAcm0027Event() {}

	public FFCmpnAuditVO getAgnCommAuditVO() {
		return agnCommAuditVO;
	}

	public void setAgnCommAuditVO(FFCmpnAuditVO agnCommAuditVO) {
		this.agnCommAuditVO = agnCommAuditVO;
	}

	public FFCmpnAuditVO[] getFfcmpnAuditVOs() {
		FFCmpnAuditVO[] rtnVOs = null;
		if (this.ffcmpnAuditVOs != null) {
			rtnVOs = Arrays.copyOf(ffcmpnAuditVOs, ffcmpnAuditVOs.length);
		}
		return rtnVOs;
	}

	public void setFfcmpnAuditVOs(FFCmpnAuditVO[] ffcmpnAuditVOs) {
		if(ffcmpnAuditVOs != null){
			FFCmpnAuditVO[] tmpVOs = Arrays.copyOf(ffcmpnAuditVOs, ffcmpnAuditVOs.length);
			this.ffcmpnAuditVOs  = tmpVOs;
		}
	}



}