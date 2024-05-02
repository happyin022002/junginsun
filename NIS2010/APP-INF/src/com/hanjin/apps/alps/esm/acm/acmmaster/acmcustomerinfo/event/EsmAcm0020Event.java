/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0020Event.java
*@FileTitle : FF vs Shipper Interest Info for Brokerage
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.03
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.05.03 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmmaster.acmcustomerinfo.event;

import com.hanjin.apps.alps.esm.acm.acmmaster.acmcustomerinfo.vo.FFCmpnExSettingVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0020 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0020HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_0020HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0020Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private FFCmpnExSettingVO ffCmpnExSettingVO = null;

	/** Table Value Object Multi Data 처리 */
	private FFCmpnExSettingVO[] ffCmpnExSettingVOs = null;

	public EsmAcm0020Event() {}

	public FFCmpnExSettingVO getFFCmpnExSettingVO() {
		return ffCmpnExSettingVO;
	}

	public void setFFCmpnExSettingVO(FFCmpnExSettingVO ffCmpnExSettingVO) {
		this.ffCmpnExSettingVO = ffCmpnExSettingVO;
	}

	public FFCmpnExSettingVO[] getFFCmpnExSettingVOs() {
		return ffCmpnExSettingVOs;
	}

	public void setFFCmpnExSettingVOs(FFCmpnExSettingVO[] ffCmpnExSettingVOs) {
		this.ffCmpnExSettingVOs = ffCmpnExSettingVOs;
	}


}