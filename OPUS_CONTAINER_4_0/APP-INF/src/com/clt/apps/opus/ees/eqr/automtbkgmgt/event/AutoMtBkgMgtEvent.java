/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UdevComOpusvskTActskdEvent.java
*@FileTitle : EDI to Terminal
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 서창열
*@LastVersion : 1.0
* 2009.07.10 서창열
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
 * receiving from MQ<br>
 *
 * @author Park Young JIn
 * @see
 * @since J2EE 1.6
 */

public class AutoMtBkgMgtEvent extends EventSupport {

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
	

	public String flatFile = null;

	public String getFlatFile() {
		return flatFile;
	}

	public void setFlatFile(String flatFile) { 
		this.flatFile = flatFile;
	}

	
	
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