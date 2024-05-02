/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0037Event.java
*@FileTitle : 컨테이너 수급 예측실적 및 정확도 조회
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1		1.0		jungran yang					2006-11-21		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun				2009.10.09		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.10.09
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.10.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.event;

import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.vo.EesEqr0037ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_0037 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0037HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0037HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0037Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0037ConditionVO eesEqr0037ConditionVO = null;

	public EesEqr0037Event(){}

	/**
	 * @return the eesEqr0037ConditionVO
	 */
	public EesEqr0037ConditionVO getEesEqr0037ConditionVO() {
		return eesEqr0037ConditionVO;
	}

	/**
	 * @param eesEqr0037ConditionVO the eesEqr0037ConditionVO to set
	 */
	public void setEesEqr0037ConditionVO(EesEqr0037ConditionVO eesEqr0037ConditionVO) {
		this.eesEqr0037ConditionVO = eesEqr0037ConditionVO;
	}

}