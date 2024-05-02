/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName 		: EesEqr1025Event.java
*@FileTitle 	: Loading Trend by Lane
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

import com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1025ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_1025 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_1025HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SHIN DONG IL
 * @see EES_EQR_1025HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesEqr1025Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	private EesEqr1025ConditionVO eesEqr1025ConditionVO = null;

	public EesEqr1025ConditionVO getEesEqr1025ConditionVO() {
		return eesEqr1025ConditionVO;
	}

	public void setEesEqr1025ConditionVO(EesEqr1025ConditionVO eesEqr1025ConditionVO) {
		this.eesEqr1025ConditionVO = eesEqr1025ConditionVO;
	}

}