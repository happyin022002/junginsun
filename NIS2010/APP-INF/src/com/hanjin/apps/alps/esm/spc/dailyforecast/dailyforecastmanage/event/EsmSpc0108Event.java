/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0108Event.java
*@FileTitle : Accumulated Guide&PFMC
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 Creation
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
=========================================================*/
package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.event;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_SPC_0108 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0108HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0108HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0108Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	public EsmSpc0108Event(){}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
}