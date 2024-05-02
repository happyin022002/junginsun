/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : EsmSqm0037Event.java
*@FileTitle      : QTA Inquiry_Quarterly Overall
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.22
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.22 SQM USER
* 1.0 Creation
* 2015.10.14 김용습 [CHM-201538195] SQM 내 report의 main grid상 데이터 display 기준 revenue month로 변경
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtainquiry.event;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_SQM_0037 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_SQM_0037HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SQM USER
 * @see ESM_SQM_0037HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSqm0037Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public EsmSqm0037Event(){}
	
	private ConditionVO conditionVO = null;
	
	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}

}