/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesEqr0059Event.java
*@FileTitle : Execution Plan
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.17
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.13 이행지
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.automtbkgmgt.event;

import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonConditionVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059ConditionVO;
import com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoexecutionplanestablish.vo.EesEqr0059MultiVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.EqrVslLodgDchgExePlnVO;


/**
 * EES_EQR_0059 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_0059HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Haeng-ji,Lee
 * @see EES_EQR_0059HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesEqr0059Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private EqrVslLodgDchgExePlnVO eqrVslLodgDchgExePlnVO = null; 
	private EesCommonConditionVO eesCommonConditionVO = null;
	private EesCommonVO eesCommonVO = null;

	/** Table Value Object Multi Data 처리 */
	private EqrVslLodgDchgExePlnVO[] eqrVslLodgDchgExePlnVOs = null;
	private EesCommonConditionVO[] eesCommonConditionVOS = null;
	private EesCommonVO[] eesCommonVOS = null;
	
	private EesEqr0059ConditionVO eesEqr0059ConditionVO = null;
	private EesEqr0059MultiVO eesEqr0059MultiVO = null;
	private EesEqr0059MultiVO[] eesEqr0059MultiVOs = null;
	

	public EesEqr0059Event(){}
	
	public EqrVslLodgDchgExePlnVO getEqrVslLodgDchgExePlnVO() {
		return eqrVslLodgDchgExePlnVO;
	}

	public void setEqrVslLodgDchgExePlnVO(EqrVslLodgDchgExePlnVO eqrVslLodgDchgExePlnVO) {
		this.eqrVslLodgDchgExePlnVO = eqrVslLodgDchgExePlnVO;
	}
	
	public EesCommonConditionVO getEesCommonConditionVO() {
		return eesCommonConditionVO;
	}
	public void setEesCommonConditionVO(EesCommonConditionVO eesCommonConditionVO) {
		this.eesCommonConditionVO = eesCommonConditionVO;
	}
	
	public EesCommonVO getEesCommonVO() {
		return eesCommonVO;
	}
	public void setEesCommonVO(EesCommonVO eesCommonVO) {
		this.eesCommonVO = eesCommonVO;
	}
	
	public EqrVslLodgDchgExePlnVO[] getEqrVslLodgDchgExePlnVOs() {
		EqrVslLodgDchgExePlnVO[] tmpVOs = null;
		if (this.eqrVslLodgDchgExePlnVOs != null) {
			tmpVOs = new EqrVslLodgDchgExePlnVO[eqrVslLodgDchgExePlnVOs.length];
			System.arraycopy(eqrVslLodgDchgExePlnVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setEqrVslLodgDchgExePlnVOs(EqrVslLodgDchgExePlnVO[] eqrVslLodgDchgExePlnVOs) {
		if (eqrVslLodgDchgExePlnVOs != null) {
			EqrVslLodgDchgExePlnVO[] tmpVOs = new EqrVslLodgDchgExePlnVO[eqrVslLodgDchgExePlnVOs.length];
			System.arraycopy(eqrVslLodgDchgExePlnVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eqrVslLodgDchgExePlnVOs = tmpVOs;
		}
	}
	
	public EesCommonConditionVO[] getEesCommonConditionVOS() {
		EesCommonConditionVO[] tmpVOs = null;
		if (this.eesCommonConditionVOS != null) {
			tmpVOs = new EesCommonConditionVO[eesCommonConditionVOS.length];
			System.arraycopy(eesCommonConditionVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	public void setEesCommonConditionVOS(
			EesCommonConditionVO[] eesCommonConditionVOS) {
		if (eesCommonConditionVOS != null) {
			EesCommonConditionVO[] tmpVOs = new EesCommonConditionVO[eesCommonConditionVOS.length];
			System.arraycopy(eesCommonConditionVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.eesCommonConditionVOS = tmpVOs;
		}
	}
	
	public EesCommonVO[] getEesCommonVOS() {
		EesCommonVO[] tmpVOs = null;
		if (this.eesCommonVOS != null) {
			tmpVOs = new EesCommonVO[eesCommonVOS.length];
			System.arraycopy(eesCommonVOS, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}
	public void setEesCommonVOS(EesCommonVO[] eesCommonVOS) {
		if (eesCommonVOS != null) {
			EesCommonVO[] tmpVOs = new EesCommonVO[eesCommonVOS.length];
			System.arraycopy(eesCommonVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.eesCommonVOS = tmpVOs;
		}
	}

	public EesEqr0059ConditionVO getEesEqr0059ConditionVO() {
		return eesEqr0059ConditionVO;
	}

	public void setEesEqr0059ConditionVO(EesEqr0059ConditionVO eesEqr0059ConditionVO) {
		this.eesEqr0059ConditionVO = eesEqr0059ConditionVO;
	}

	public EesEqr0059MultiVO getEesEqr0059MultiVO() {
		return eesEqr0059MultiVO;
	}

	public void setEesEqr0059MultiVO(EesEqr0059MultiVO eesEqr0059MultiVO) {
		this.eesEqr0059MultiVO = eesEqr0059MultiVO;
	}

	public EesEqr0059MultiVO[] getEesEqr0059MultiVOs() {
		EesEqr0059MultiVO[] tmpVOs = null;
		if (this.eesEqr0059MultiVOs != null) {
			tmpVOs = new EesEqr0059MultiVO[eesEqr0059MultiVOs.length];
			System.arraycopy(eesEqr0059MultiVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setEesEqr0059MultiVOs(EesEqr0059MultiVO[] eesEqr0059MultiVOs) {
		if (eesEqr0059MultiVOs != null) {
			EesEqr0059MultiVO[] tmpVOs = new EesEqr0059MultiVO[eesEqr0059MultiVOs.length];
			System.arraycopy(eesEqr0059MultiVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.eesEqr0059MultiVOs = tmpVOs;
		}
	}
	
}