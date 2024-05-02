/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0038Event.java
*@FileTitle : Other Feederage Deduction Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.17
*@LastModifier : 김원녕
*@LastVersion : 1.0
* 2015.03.17 김원녕
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.event;

import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.vo.FeederageInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0038 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0038HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Won-Nyeong
 * @see ESM_ACM_0038HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0038Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private FeederageInfoVO feederageInfoVO = null;

	/** Table Value Object Multi Data 처리 */
	private FeederageInfoVO[] feederageInfoVOs = null;

	public EsmAcm0038Event() {}

	public FeederageInfoVO getFeederageInfoVO() {
		return feederageInfoVO;
	}

	public void setFeederageInfoVO(FeederageInfoVO feederageInfoVO) {
		this.feederageInfoVO = feederageInfoVO;
	}

	public FeederageInfoVO[] getFeederageInfoVOs() {
		return feederageInfoVOs;
	}

	public void setFeederageInfoVOs(FeederageInfoVO[] feederageInfoVOs) {
		this.feederageInfoVOs = feederageInfoVOs;
	}

}