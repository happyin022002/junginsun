/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName 		: EesEqr1066Event.java
*@FileTitle 	: Loading Trend by Port
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
 
import com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1066ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_1066 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * EES_EQR_1068HTMLAction에서 작성<br>
 * ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SHIN DONG IL
 * @see EES_EQR_1066HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesEqr1066Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	private EesEqr1066ConditionVO eesEqr1066ConditionVO = null;

	public EesEqr1066ConditionVO getEesEqr1066ConditionVO() {
		return eesEqr1066ConditionVO;
	}

	public void setEesEqr1066ConditionVO(EesEqr1066ConditionVO eesEqr1066ConditionVO) {
		this.eesEqr1066ConditionVO = eesEqr1066ConditionVO;
	}


}