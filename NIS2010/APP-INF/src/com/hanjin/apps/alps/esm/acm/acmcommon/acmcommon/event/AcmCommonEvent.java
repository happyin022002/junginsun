/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AcmCommonEvent.java
*@FileTitle : ACM_Common
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.07
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.07 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.event;

import com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.vo.CommonVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ACM_Common 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ACM_CommonHTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ACM_COMMON_HTMLAction 참조
 * @since J2EE 1.6
 */

public class AcmCommonEvent extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CommonVO commonVO = null;

	/** Table Value Object Multi Data 처리 */
	private CommonVO[] commonVOs = null;

	public AcmCommonEvent() {}

	public CommonVO getCommonVO() {
		return commonVO;
	}

	public void setCommonVO(CommonVO commonVO) {
		this.commonVO = commonVO;
	}

	public CommonVO[] getCommonVOs() {
		return commonVOs;
	}

	public void setCommonVOs(CommonVO[] commonVOs) {
		this.commonVOs = commonVOs;
	}

}