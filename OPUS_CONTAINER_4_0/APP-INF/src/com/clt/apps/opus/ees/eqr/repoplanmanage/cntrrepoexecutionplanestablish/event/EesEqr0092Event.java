/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0092Event.java
*@FileTitle : Total
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.30 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.event;

import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059ConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_0092 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0092HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see EES_EQR_0092HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0092Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private EesEqr0059ConditionVO eesEqr0059ConditionVO = null;

	public EesEqr0092Event(){}
	
	public EesEqr0059ConditionVO getEesEqr0059ConditionVO() {
		return eesEqr0059ConditionVO;
	}

	public void setEesEqr0059ConditionVO(EesEqr0059ConditionVO eesEqr0059ConditionVO) {
		this.eesEqr0059ConditionVO = eesEqr0059ConditionVO;
	}
	

}