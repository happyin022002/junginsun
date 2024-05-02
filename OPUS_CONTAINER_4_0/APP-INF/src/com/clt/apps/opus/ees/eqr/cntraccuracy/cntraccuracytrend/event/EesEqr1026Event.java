/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName 		: EesEqr1026Event.java
*@FileTitle 	: Discharging result
*Open Issues 	:
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.event;


import com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1026ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_1026  PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_1026HTMLAction<br>
 * - ServiceCommand Layer<br>
 *
 * @author SHIN DONG IL
 * @see EES_EQR_1026HTMLAction 
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