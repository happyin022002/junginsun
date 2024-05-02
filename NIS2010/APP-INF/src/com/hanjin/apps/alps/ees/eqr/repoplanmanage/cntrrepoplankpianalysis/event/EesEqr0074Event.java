/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0074Event.java
*@FileTitle : Inventory Container List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.24 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo.EesEqr0074ConditionVO;

/**
 * EES_EQR_0074 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0074HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chae Change Ho
 * @see EES_EQR_0074HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0074Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	
	private EesEqr0074ConditionVO eesEqr0074ConditionVO = null;
	
	public EesEqr0074Event(){}
	
	/**
	 * @return the eesEqr0074ConditionVO
	 */
	public EesEqr0074ConditionVO getEesEqr0074ConditionVO() {
		return eesEqr0074ConditionVO;
	}

	/**
	 * @param eesEqr0074ConditionVO the eesEqr0074ConditionVO to set
	 */
	public void setEesEqr0074ConditionVO(EesEqr0074ConditionVO eesEqr0074ConditionVO) {
		this.eesEqr0074ConditionVO = eesEqr0074ConditionVO;
	}
 
	
}