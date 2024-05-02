/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName 		: EesEqr1066Event.java
*@FileTitle 	: Loading Trend by Port
*Open Issues 	:
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.event;

import com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1066ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_1066 PDTO(Data Transfer Object including Parameters)<br>
 * @author 
 * @see EES_EQR_1066HTMLAction 
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