/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName 		: EesEqr1026Event.java
*@FileTitle 	: Discharging result
*Open Issues 	:
*Change history :
* No.	Ver.		Modifier          modifier date    explanation
* 1     1.0      	SHIN DONG IL	  2013.07.11		 Creation
*
*@LastModifyDate : 2013.07.11
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2013.07.11 SHIN DONG IL
* 1.0 Creation
=========================================================*/
 
package com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.event;


import com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1026ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_1026 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_1026HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SHIN DONG IL
 * @see EES_EQR_1026HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesEqr1026Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	private EesEqr1026ConditionVO eesEqr1026ConditionVO = null;

	public EesEqr1026ConditionVO getEesEqr1026ConditionVO() {
		return eesEqr1026ConditionVO;
	}

	public void setEesEqr1026ConditionVO(EesEqr1026ConditionVO eesEqr1026ConditionVO) {
		this.eesEqr1026ConditionVO = eesEqr1026ConditionVO;
	}

	

}