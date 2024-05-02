/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0072Event.java
*@FileTitle : Forecasted M/B
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 정은호
*@LastVersion : 1.0
* 2009.10.07 정은호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo.EesEqr0072ConditionVO;


/**
 * EES_EQR_0072 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0072HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author ChungEunHo
 * @see EES_EQR_0072HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0072Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0072ConditionVO eesEqr0072ConditionVO = null;
	

	public EesEqr0072Event(){}
	
	public void setEesEqr0072ConditionVO(EesEqr0072ConditionVO eesEqr0072ConditionVO){
		this. eesEqr0072ConditionVO = eesEqr0072ConditionVO;
	}

	public EesEqr0072ConditionVO getEesEqr0072ConditionVO(){
		return eesEqr0072ConditionVO;
	}


}