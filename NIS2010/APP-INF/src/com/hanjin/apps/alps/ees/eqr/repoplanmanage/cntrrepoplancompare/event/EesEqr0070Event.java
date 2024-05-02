/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0070Event.java
*@FileTitle : compare
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.28 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplancompare.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplancompare.vo.EesEqr0070ConditionVO;

/**
 * EES_EQR_0070 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0070HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Chae Change Ho
 * @see EES_EQR_0070HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0070Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/**  조회 조건 및 단건 처리  */
	private EesEqr0070ConditionVO eesEqr0070ConditionVO = null;
	
	public EesEqr0070Event(){}

	/**
	 * @return the eesEqr0070ConditionVO
	 */
	public EesEqr0070ConditionVO getEesEqr0070ConditionVO() {
		return eesEqr0070ConditionVO;
	}

	/**
	 * @param eesEqr0070ConditionVO the eesEqr0070ConditionVO to set
	 */
	public void setEesEqr0070ConditionVO(EesEqr0070ConditionVO eesEqr0070ConditionVO) {
		this.eesEqr0070ConditionVO = eesEqr0070ConditionVO;
	}
	
	

}