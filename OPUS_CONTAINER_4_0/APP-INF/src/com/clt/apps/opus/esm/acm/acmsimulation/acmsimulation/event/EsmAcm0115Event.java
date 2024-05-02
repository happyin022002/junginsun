/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0115Event.java
*@FileTitle : Simulation Agreement Copy From
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.05
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.06.05 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.event;

import com.clt.apps.opus.esm.acm.acmsimulation.acmsimulation.vo.SimAgnRateMasterVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0115 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0115HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_0115HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0115Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SimAgnRateMasterVO simAgnRateMasterVO = null;

	public EsmAcm0115Event() {}

	public SimAgnRateMasterVO getSimAgnRateMasterVO() {
		return simAgnRateMasterVO;
	}

	public void setSimAgnRateMasterVO(SimAgnRateMasterVO simAgnRateMasterVO) {
		this.simAgnRateMasterVO = simAgnRateMasterVO;
	}

}