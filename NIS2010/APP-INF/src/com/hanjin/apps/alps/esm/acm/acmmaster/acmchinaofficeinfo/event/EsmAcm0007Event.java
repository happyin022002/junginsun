/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0007Event.java
*@FileTitle : O/B Booking Office Info for China
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.06
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.06 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmmaster.acmchinaofficeinfo.event;

import com.hanjin.apps.alps.esm.acm.acmmaster.acmchinaofficeinfo.vo.ChinaOfficeInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_0007HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0007Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 처리  */
	private ChinaOfficeInfoVO chinaOfficeInfoVO = null;

	/** Table Value Object Multi Data 처리 */
	private ChinaOfficeInfoVO[] chinaOfficeInfoVOs = null;

	public EsmAcm0007Event() {}

	public ChinaOfficeInfoVO getChinaOfficeInfoVO() {
		return chinaOfficeInfoVO;
	}

	public void setChinaOfficeInfoVO(ChinaOfficeInfoVO chinaOfficeInfoVO) {
		this.chinaOfficeInfoVO = chinaOfficeInfoVO;
	}

	public ChinaOfficeInfoVO[] getChinaOfficeInfoVOs() {
		return chinaOfficeInfoVOs;
	}

	public void setChinaOfficeInfoVOs(ChinaOfficeInfoVO[] chinaOfficeInfoVOs) {
		this.chinaOfficeInfoVOs = chinaOfficeInfoVOs;
	}
}