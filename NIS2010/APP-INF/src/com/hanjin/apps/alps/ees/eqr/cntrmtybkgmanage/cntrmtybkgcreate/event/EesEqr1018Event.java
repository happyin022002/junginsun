/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesEqr1018Event.java
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

import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1018ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.EesEqr1018MultiVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.EqrCtrlMtyBkgExeVO;


/**
 * EES_EQR_1018 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_1018HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 신용찬
 * @see EES_EQR_1018HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr1018Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqrCtrlMtyBkgExeVO eqrCtrlMtyBkgExeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public EqrCtrlMtyBkgExeVO[] eqrCtrlMtyBkgExeVOs = null;

	private EesEqr1018ConditionVO eesEqr1018ConditionVO = null;
	private EesEqr1018MultiVO eesEqr1018MultiVO = null;
	public EesEqr1018MultiVO[] eesEqr1018MultiVOs = null;
	

	public EesEqr1018Event(){}
	
	public EqrCtrlMtyBkgExeVO getEqrCtrlMtyBkgExeVO() {
		return eqrCtrlMtyBkgExeVO;
	}

	public void setEqrCtrlMtyBkgExeVO(EqrCtrlMtyBkgExeVO eqrCtrlMtyBkgExeVO) {
		this.eqrCtrlMtyBkgExeVO = eqrCtrlMtyBkgExeVO;
	}

	public EqrCtrlMtyBkgExeVO[] getEqrCtrlMtyBkgExeVOs() {
		return eqrCtrlMtyBkgExeVOs;
	}

	public void setEqrCtrlMtyBkgExeVOs(EqrCtrlMtyBkgExeVO[] eqrCtrlMtyBkgExeVOs) {
		this.eqrCtrlMtyBkgExeVOs = eqrCtrlMtyBkgExeVOs;
	}

	public EesEqr1018ConditionVO getEesEqr1018ConditionVO() {
		return eesEqr1018ConditionVO;
	}

	public void setEesEqr1018ConditionVO(EesEqr1018ConditionVO eesEqr1018ConditionVO) {
		this.eesEqr1018ConditionVO = eesEqr1018ConditionVO;
	}

	public EesEqr1018MultiVO getEesEqr1018MultiVO() {
		return eesEqr1018MultiVO;
	}

	public void setEesEqr1018MultiVO(EesEqr1018MultiVO eesEqr1018MultiVO) {
		this.eesEqr1018MultiVO = eesEqr1018MultiVO;
	}

	public EesEqr1018MultiVO[] getEesEqr1018MultiVOs() {
		return eesEqr1018MultiVOs;
	}

	public void setEesEqr1018MultiVOs(EesEqr1018MultiVO[] eesEqr1018MultiVOs) {
		this.eesEqr1018MultiVOs = eesEqr1018MultiVOs;
	}
	
}