/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesEqr1052Event.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.30
*@LastModifier : 신용찬
*@LastVersion : 1.0
* 2013.07.30 신용찬
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.event;

import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1052ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1052MultiVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_EQR_1052 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_1052HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see EES_EQR_1052HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr1052Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EesEqr1052ConditionVO conditionVO = null;
	private EesEqr1052ConditionVO eesEqr1052ConditionVO = null;	
	private EesEqr1052MultiVO eesEqr1052MultiVO = null;
	public EesEqr1052MultiVO[] eesEqr1052MultiVOs = null;
	
	public EesEqr1052Event(){}

	public EesEqr1052ConditionVO getConditionVO() {
		return conditionVO;
	}
	
	public EesEqr1052ConditionVO getEesEqr1052ConditionVO() {
		return eesEqr1052ConditionVO;
	}

	public void setEesEqr1052ConditionVO(EesEqr1052ConditionVO eesEqr1052ConditionVO) {
		this.eesEqr1052ConditionVO = eesEqr1052ConditionVO;
	}
	
	public EesEqr1052MultiVO getEesEqr1052MultiVO() {
		return eesEqr1052MultiVO;
	}

	public void setEesEqr1052MultiVO(EesEqr1052MultiVO eesEqr1052MultiVO) {
		this.eesEqr1052MultiVO = eesEqr1052MultiVO;
	}

	public EesEqr1052MultiVO[] getEesEqr1052MultiVOs() {
		return eesEqr1052MultiVOs;
	}

	public void setEesEqr1052MultiVOs(EesEqr1052MultiVO[] eesEqr1052MultiVOs) {
		this.eesEqr1052MultiVOs = eesEqr1052MultiVOs;
	}	


}