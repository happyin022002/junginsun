/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0111Event.java
*@FileTitle : CSR Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.16
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.16 김봉균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmreport.acmreport.event;

import com.hanjin.apps.alps.esm.acm.acmreport.acmreport.vo.CSRDetailVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0111 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0111HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Bong-Gyoon
 * @see ESM_ACM_0111HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0111Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private CSRDetailVO csrDetailVO = null;

	/** Table Value Object Multi Data 처리 */
	private CSRDetailVO[] csrDetailVOs = null;

	public EsmAcm0111Event() {}

	public CSRDetailVO getCsrDetailVO() {
		return csrDetailVO;
	}

	public void setCsrDetailVO(CSRDetailVO csrDetailVO) {
		this.csrDetailVO = csrDetailVO;
	}

	public CSRDetailVO[] getCsrDetailVOs() {
		return csrDetailVOs;
	}

	public void setCsrDetailVOs(CSRDetailVO[] csrDetailVOs) {
		this.csrDetailVOs = csrDetailVOs;
	}
}