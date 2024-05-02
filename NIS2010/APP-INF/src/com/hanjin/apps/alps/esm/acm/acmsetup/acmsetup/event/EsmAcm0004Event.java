/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0004Event.java
*@FileTitle : Container TP/SZ Grouping
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.19
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.19 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.event;

import com.hanjin.apps.alps.esm.acm.acmsetup.acmsetup.vo.FinanceOfficeInfoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_0004HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private FinanceOfficeInfoVO financeOfficeInfoVO = null;

	/** Table Value Object Multi Data 처리 */
	private FinanceOfficeInfoVO[] financeOfficeInfoVOs = null;

	public EsmAcm0004Event() {}

	public FinanceOfficeInfoVO getFinanceOfficeInfoVO() {
		return financeOfficeInfoVO;
	}

	public void setFinanceOfficeInfoVO(FinanceOfficeInfoVO financeOfficeInfoVO) {
		this.financeOfficeInfoVO = financeOfficeInfoVO;
	}

	public FinanceOfficeInfoVO[] getFinanceOfficeInfoVOs() {
		return financeOfficeInfoVOs;
	}

	public void setFinanceOfficeInfoVOs(FinanceOfficeInfoVO[] financeOfficeInfoVOs) {
		this.financeOfficeInfoVOs = financeOfficeInfoVOs;
	}

}