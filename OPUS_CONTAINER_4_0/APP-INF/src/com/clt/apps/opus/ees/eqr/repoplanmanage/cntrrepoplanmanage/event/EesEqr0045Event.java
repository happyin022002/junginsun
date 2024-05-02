/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0045Event.java
*@FileTitle : 컨테이너 이송 계획 목록 조회
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1		1.0		sangyool pak					2006-09-15		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun				2009.08.14		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.08.14
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.event;

import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0045ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_0045 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0045HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0045HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0045Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0045ConditionVO eesEqr0045ConditionVO = null;

	public EesEqr0045Event(){}

	/**
	 * @return the eesEqr0045ConditionVO
	 */
	public EesEqr0045ConditionVO getEesEqr0045ConditionVO() {
		return eesEqr0045ConditionVO;
	}

	/**
	 * @param eesEqr0045ConditionVO the eesEqr0045ConditionVO to set
	 */
	public void setEesEqr0045ConditionVO(EesEqr0045ConditionVO eesEqr0045ConditionVO) {
		this.eesEqr0045ConditionVO = eesEqr0045ConditionVO;
	}

}