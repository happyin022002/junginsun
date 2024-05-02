/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0032Event.java
*@FileTitle : Batch Management
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.25
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.25 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.batmanagement.event;

import com.hanjin.apps.alps.esm.acm.acmrequest.batmanagement.vo.BATManagementVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_ACM_0032 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0032HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM BONG-GYOON
 * @see ESM_ACM_0032HTMLAction 참조
 * @since J2EE 1.6
 */
public class EsmAcm0032Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private BATManagementVO batManagementVO = null;

	/** Table Value Object Multi Data 처리 */
	private BATManagementVO[] batManagementVOs = null;

	public EsmAcm0032Event() {}

	public BATManagementVO getBATManagementVO() {
		return batManagementVO;
	}

	public void setBATManagementVO(BATManagementVO batManagementVO) {
		this.batManagementVO = batManagementVO;
	}

	public BATManagementVO[] getBATManagementVOs() {
		return batManagementVOs;
	}

	public void setBATManagementVOs(BATManagementVO[] batManagementVOs) {
		this.batManagementVOs = batManagementVOs;
	}

}