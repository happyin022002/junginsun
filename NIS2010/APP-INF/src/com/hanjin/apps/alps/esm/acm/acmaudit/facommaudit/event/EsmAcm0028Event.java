/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0028Event
*@FileTitle : FAC Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.15
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.15 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmaudit.facommaudit.event;

import com.hanjin.apps.alps.esm.acm.acmaudit.facommaudit.vo.FACCommListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0028 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0028HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Young-Oh
 * @see ESM_ACM_0028HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0028Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private FACCommListVO facCommListVO = null;

	/** Table Value Object Multi Data 처리 */
	private FACCommListVO[] facCommListVOs = null;

	public EsmAcm0028Event() {}

	public FACCommListVO getFacCommListVO() {
		return facCommListVO;
	}

	public void setFacCommListVO(FACCommListVO facCommListVO) {
		this.facCommListVO = facCommListVO;
	}

	public FACCommListVO[] getFacCommListVOs() {
		return facCommListVOs;
	}

	public void setFacCommListVOs(FACCommListVO[] facCommListVOs) {
		this.facCommListVOs = facCommListVOs;
	}

	
}