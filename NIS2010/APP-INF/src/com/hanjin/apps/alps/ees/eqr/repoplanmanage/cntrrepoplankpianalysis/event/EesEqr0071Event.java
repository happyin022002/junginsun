/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0071Event.java
*@FileTitle : 컨테이너 이송 계획 KPI 요약 조회
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1		1.0		jungran yang					2006-11-17		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun				2009.09.16		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.09.16
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.event;

import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo.EesEqr0071ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_0071 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0071HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0071HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0071Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0071ConditionVO eesEqr0071ConditionVO = null;

	public EesEqr0071Event(){}

	/**
	 * @return the eesEqr0071ConditionVO
	 */
	public EesEqr0071ConditionVO getEesEqr0071ConditionVO() {
		return eesEqr0071ConditionVO;
	}

	/**
	 * @param eesEqr0071ConditionVO the eesEqr0071ConditionVO to set
	 */
	public void setEesEqr0071ConditionVO(EesEqr0071ConditionVO eesEqr0071ConditionVO) {
		this.eesEqr0071ConditionVO = eesEqr0071ConditionVO;
	}

}