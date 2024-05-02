/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0021Event.java
*@FileTitle : FAC Exclusion Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.03 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmmaster.acmcustomerinfo.event;

import com.hanjin.apps.alps.esm.acm.acmmaster.acmcustomerinfo.vo.FACExSettingVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0021 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0021HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_0021HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0021Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private FACExSettingVO facExSettingVO = null;

	/** Table Value Object Multi Data 처리 */
	private FACExSettingVO[] facExSettingVOs = null;

	public EsmAcm0021Event() {}

	public FACExSettingVO getFACExSettingVO() {
		return facExSettingVO;
	}

	public void setFACExSettingVO(FACExSettingVO facExSettingVO) {
		this.facExSettingVO = facExSettingVO;
	}

	public FACExSettingVO[] getFACExSettingVOs() {
		return facExSettingVOs;
	}

	public void setFACExSettingVOs(FACExSettingVO[] facExSettingVOs) {
		this.facExSettingVOs = facExSettingVOs;
	}


}