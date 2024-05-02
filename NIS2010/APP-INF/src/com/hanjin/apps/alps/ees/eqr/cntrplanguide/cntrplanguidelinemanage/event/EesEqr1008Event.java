/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrPlanGuidelineManageDBDAO.java
*@FileTitle : Container Guideline Manage
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1     1.0      	SHIN DONG IL						2013.05.27		 Creation
*
*@LastModifyDate : 2013.05.27
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2013.05.27 SHIN DONG IL
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelinemanage.event;

import java.util.List;

import com.hanjin.apps.alps.ees.eqr.cntrplanguide.cntrplanguidelinemanage.vo.EesEqr1008ConditionVO;

import com.hanjin.syscommon.common.table.EqrCtrlGlineHdrVO;
import com.hanjin.syscommon.common.table.EqrCtrlLodgGlineVO;
import com.hanjin.syscommon.common.table.EqrCtrlDchgGlineVO;
import com.hanjin.syscommon.common.table.EqrCtrlDchgGlineValVO;

import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_EQR_1008 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_EQR_1008HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SHIN DONG IL
 * @see EES_EQR_1008HTMLAction 참조
 * @since J2EE 1.6
 */
public class EesEqr1008Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private EesEqr1008ConditionVO eesEqr1008ConditionVO = null;
	
	private EqrCtrlGlineHdrVO 		eqrCtrlGlineHdrVO 		= null;
	private EqrCtrlDchgGlineVO 		eqrCtrlDchgGlineVO 		= null;
	private EqrCtrlDchgGlineValVO 	eqrCtrlDchgGlineValVO 	= null;
	
	private List<EqrCtrlGlineHdrVO> 	eqrCtrlGlineHdrVOs 		= null;	
	private List<EqrCtrlLodgGlineVO> 	eqrCtrlLodgGlineVOs 	= null;
	private List<EqrCtrlDchgGlineVO> 	eqrCtrlDchgGlineVOs 	= null;
	private List<EqrCtrlDchgGlineValVO> eqrCtrlDchgGlineValVOs 	= null;
	
	String cntr_tpsz_cd = null;

	public EesEqr1008ConditionVO getEesEqr1008ConditionVO() {
		return eesEqr1008ConditionVO;
	}

	public void setEesEqr1008ConditionVO(EesEqr1008ConditionVO eesEqr1008ConditionVO) {
		this.eesEqr1008ConditionVO = eesEqr1008ConditionVO;
	}

	public EqrCtrlGlineHdrVO getEqrCtrlGlineHdrVO() {
		return eqrCtrlGlineHdrVO;
	}

	public void setEqrCtrlGlineHdrVO(EqrCtrlGlineHdrVO eqrCtrlGlineHdrVO) {
		this.eqrCtrlGlineHdrVO = eqrCtrlGlineHdrVO;
	}

	public EqrCtrlDchgGlineVO getEqrCtrlDchgGlineVO() {
		return eqrCtrlDchgGlineVO;
	}

	public void setEqrCtrlDchgGlineVO(EqrCtrlDchgGlineVO eqrCtrlDchgGlineVO) {
		this.eqrCtrlDchgGlineVO = eqrCtrlDchgGlineVO;
	}

	public EqrCtrlDchgGlineValVO getEqrCtrlDchgGlineValVO() {
		return eqrCtrlDchgGlineValVO;
	}

	public void setEqrCtrlDchgGlineValVO(EqrCtrlDchgGlineValVO eqrCtrlDchgGlineValVO) {
		this.eqrCtrlDchgGlineValVO = eqrCtrlDchgGlineValVO;
	}

	public List<EqrCtrlGlineHdrVO> getEqrCtrlGlineHdrVOs() {
		return eqrCtrlGlineHdrVOs;
	}

	public void setEqrCtrlGlineHdrVOs(List<EqrCtrlGlineHdrVO> eqrCtrlGlineHdrVOs) {
		this.eqrCtrlGlineHdrVOs = eqrCtrlGlineHdrVOs;
	}

	public List<EqrCtrlLodgGlineVO> getEqrCtrlLodgGlineVOs() {
		return eqrCtrlLodgGlineVOs;
	}

	public void setEqrCtrlLodgGlineVOs(List<EqrCtrlLodgGlineVO> eqrCtrlLodgGlineVOs) {
		this.eqrCtrlLodgGlineVOs = eqrCtrlLodgGlineVOs;
	}

	public List<EqrCtrlDchgGlineVO> getEqrCtrlDchgGlineVOs() {
		return eqrCtrlDchgGlineVOs;
	}

	public void setEqrCtrlDchgGlineVOs(List<EqrCtrlDchgGlineVO> eqrCtrlDchgGlineVOs) {
		this.eqrCtrlDchgGlineVOs = eqrCtrlDchgGlineVOs;
	}

	public List<EqrCtrlDchgGlineValVO> getEqrCtrlDchgGlineValVOs() {
		return eqrCtrlDchgGlineValVOs;
	}

	public void setEqrCtrlDchgGlineValVOs(
			List<EqrCtrlDchgGlineValVO> eqrCtrlDchgGlineValVOs) {
		this.eqrCtrlDchgGlineValVOs = eqrCtrlDchgGlineValVOs;
	}

	public String getCntr_tpsz_cd() {
		return cntr_tpsz_cd;
	}

	public void setCntr_tpsz_cd(String cntr_tpsz_cd) {
		this.cntr_tpsz_cd = cntr_tpsz_cd;
	}

}