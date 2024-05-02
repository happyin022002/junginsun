/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0006Event.java
*@FileTitle : Commission Agreement Creation_Master
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.26
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.26 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.event;

import com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.vo.AGNCommRequestVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_0006HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0006Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AGNCommRequestVO agnCommRequestVO = null;

	/** Table Value Object Multi Data 처리 */
	private AGNCommRequestVO[] agnCommRequestVOs = null;

	public EsmAcm0006Event() {}

	public AGNCommRequestVO getAGNCommRequestVO() {
		return agnCommRequestVO;
	}

	public void setAGNCommRequestVO(AGNCommRequestVO agnCommRequestVO) {
		this.agnCommRequestVO = agnCommRequestVO;
	}

	public AGNCommRequestVO[] getAGNCommRequestVOs() {
		return agnCommRequestVOs;
	}

	public void setAGNCommRequestVOs(AGNCommRequestVO[] agnCommRequestVOs) {
		this.agnCommRequestVOs = agnCommRequestVOs;
	}


}