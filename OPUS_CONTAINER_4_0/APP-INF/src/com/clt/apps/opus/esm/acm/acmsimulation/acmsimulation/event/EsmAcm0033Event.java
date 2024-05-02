/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0033Event.java
*@FileTitle : EsmAcm0033Event
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.23
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.23 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.event;

import com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.vo.AGNCommMassSimVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0033 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0033HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Bong-Gyoon
 * @see ESM_ACM_0033HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0033Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private AGNCommMassSimVO agnCommMassSimVO = null;

	public EsmAcm0033Event() {}

	public AGNCommMassSimVO getAGNCommMassSimVO() {
		return agnCommMassSimVO;
	}

	public void setAGNCommMassSimVO(AGNCommMassSimVO agnCommMassSimVO) {
		this.agnCommMassSimVO = agnCommMassSimVO;
	}

}