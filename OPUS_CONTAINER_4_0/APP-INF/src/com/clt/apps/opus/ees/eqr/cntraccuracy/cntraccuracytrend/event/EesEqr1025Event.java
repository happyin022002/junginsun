/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName 		: EesEqr1025Event.java
*@FileTitle 	: Loading Trend by Lane
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :  
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.event;

import com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1025ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_1025  PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_1025HTMLAction
 * @author 
 * @see EES_EQR_1025HTMLAction 
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