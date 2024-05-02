/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0136Event.java
*@FileTitle : Forecasted M/B
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1		1.0		ChangHo chae					2008-02-04		1.0 최초 생성
* 2					ChangHo chae					2008.02.29		CSRNO : N200801230019
* 																						CSR NAME : Forecasted Sea Inventory 화면 재개발
* 3      	1.0      	Lee Byoung Hun				2009.09.22		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.09.22
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.22 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.event;

import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplankpianalysis.vo.EesEqr0136ConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_0136 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0136HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see EES_EQR_0136HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0136Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr0136ConditionVO eesEqr0136ConditionVO = null;

	public EesEqr0136Event(){}

	/**
	 * @return the eesEqr0136ConditionVO
	 */
	public EesEqr0136ConditionVO getEesEqr0136ConditionVO() {
		return eesEqr0136ConditionVO;
	}

	/**
	 * @param eesEqr0136ConditionVO the eesEqr0136ConditionVO to set
	 */
	public void setEesEqr0136ConditionVO(EesEqr0136ConditionVO eesEqr0136ConditionVO) {
		this.eesEqr0136ConditionVO = eesEqr0136ConditionVO;
	}

}