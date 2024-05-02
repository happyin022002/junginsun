/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesEqr1051Event.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.30
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.event;

import com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1051ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_1051 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_1051HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_1051HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr1051Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private EesEqr1051ConditionVO eesEqr1051ConditionVO = null;
	

	public EesEqr1051Event(){}
	
	public EesEqr1051ConditionVO getEesEqr1051ConditionVO() {
		return eesEqr1051ConditionVO;
	}

	public void setEesEqr1051ConditionVO(EesEqr1051ConditionVO eesEqr1051ConditionVO) {
		this.eesEqr1051ConditionVO = eesEqr1051ConditionVO;
	}

	
}