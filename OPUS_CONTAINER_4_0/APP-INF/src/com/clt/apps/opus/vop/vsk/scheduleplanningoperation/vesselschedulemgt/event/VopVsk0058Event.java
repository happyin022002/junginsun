/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0058Event.java
*@FileTitle : VSL SKD Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : Jung Jinwoo
*@LastVersion : 1.0
* 2009.08.26 Jung Jinwoo
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdSimDtlCalcInfoVO;
import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SwapCstSkdSimVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.VskPortDistVO;


/**
 * VOP_VSK_0058 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - VOP_VSK_0058HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jinwoo
 * @see VOP_VSK_0058HTMLAction 참조
 * @since J2EE 1.5
 */

public class VopVsk0058Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SwapCstSkdSimVO swapCstSkdSimVO = null;
	
	private VvdVO vvdVO = null;
	
	private YardVO yardVO = null;
	
	private VskPortDistVO vskPortDistVO = null;
	
	private CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SwapCstSkdSimVO[] swapCstSkdSimVOs = null;
	
	private VvdVO[] vvdVOs = null;
	
	private YardVO[] yardVOs = null;
	
	private VskPortDistVO[] vskPortDistVOs = null;
	
	private CstSkdSimDtlCalcInfoVO[] cstSkdSimDtlCalcInfoVOs = null;
	

	public VopVsk0058Event(){}


	/**
	 * @return the swapCstSkdSimVO
	 */
	public SwapCstSkdSimVO getSwapCstSkdSimVO() {
		return swapCstSkdSimVO;
	}


	/**
	 * @param swapCstSkdSimVO the swapCstSkdSimVO to set
	 */
	public void setSwapCstSkdSimVO(SwapCstSkdSimVO swapCstSkdSimVO) {
		this.swapCstSkdSimVO = swapCstSkdSimVO;
	}


	/**
	 * @return the yardVO
	 */
	public YardVO getYardVO() {
		return yardVO;
	}


	/**
	 * @param yardVO the yardVO to set
	 */
	public void setYardVO(YardVO yardVO) {
		this.yardVO = yardVO;
	}


	/**
	 * @return the vskPortDistVO
	 */
	public VskPortDistVO getVskPortDistVO() {
		return vskPortDistVO;
	}


	/**
	 * @param vskPortDistVO the vskPortDistVO to set
	 */
	public void setVskPortDistVO(VskPortDistVO vskPortDistVO) {
		this.vskPortDistVO = vskPortDistVO;
	}


	/**
	 * @return the cstSkdSimDtlCalcInfoVO
	 */
	public CstSkdSimDtlCalcInfoVO getCstSkdSimDtlCalcInfoVO() {
		return cstSkdSimDtlCalcInfoVO;
	}


	/**
	 * @param cstSkdSimDtlCalcInfoVO the cstSkdSimDtlCalcInfoVO to set
	 */
	public void setCstSkdSimDtlCalcInfoVO(
			CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO) {
		this.cstSkdSimDtlCalcInfoVO = cstSkdSimDtlCalcInfoVO;
	}


	/**
	 * @return the swapCstSkdSimVOs
	 */
	public SwapCstSkdSimVO[] getSwapCstSkdSimVOs() {
		SwapCstSkdSimVO[] rtnVOs = null;
		if (this.swapCstSkdSimVOs != null) {
			rtnVOs = Arrays.copyOf(this.swapCstSkdSimVOs, this.swapCstSkdSimVOs.length);
		} // end if
		return rtnVOs;
	}


	/**
	 * @param swapCstSkdSimVOs the swapCstSkdSimVOs to set
	 */
	public void setSwapCstSkdSimVOs(SwapCstSkdSimVO[] swapCstSkdSimVOs) {
		if (swapCstSkdSimVOs != null) {
			SwapCstSkdSimVO[] tmpVOs = Arrays.copyOf(swapCstSkdSimVOs, swapCstSkdSimVOs.length);
			this.swapCstSkdSimVOs = tmpVOs;
		} // end if
	}


	/**
	 * @return the yardVOs
	 */
	public YardVO[] getYardVOs() {
		YardVO[] rtnVOs = null;
		if (this.yardVOs != null) {
			rtnVOs = Arrays.copyOf(this.yardVOs, this.yardVOs.length);
		} // end if
		return rtnVOs;
	}


	/**
	 * @param yardVOs the yardVOs to set
	 */
	public void setYardVOs(YardVO[] yardVOs) {
		if (yardVOs != null) {
			YardVO[] tmpVOs = Arrays.copyOf(yardVOs, yardVOs.length);
			this.yardVOs = tmpVOs;
		} // end if
	}


	/**
	 * @return the vskPortDistVOs
	 */
	public VskPortDistVO[] getVskPortDistVOs() {
		VskPortDistVO[] rtnVOs = null;
		if (this.vskPortDistVOs != null) {
			rtnVOs = Arrays.copyOf(this.vskPortDistVOs, this.vskPortDistVOs.length);
		} // end if
		return rtnVOs;
	}


	/**
	 * @param vskPortDistVOs the vskPortDistVOs to set
	 */
	public void setVskPortDistVOs(VskPortDistVO[] vskPortDistVOs) {
		if (vskPortDistVOs != null) {
			VskPortDistVO[] tmpVOs = Arrays.copyOf(vskPortDistVOs, vskPortDistVOs.length);
			this.vskPortDistVOs = tmpVOs;
		} // end if
	}


	/**
	 * @return the cstSkdSimDtlCalcInfoVOs
	 */
	public CstSkdSimDtlCalcInfoVO[] getCstSkdSimDtlCalcInfoVOs() {
		CstSkdSimDtlCalcInfoVO[] rtnVOs = null;
		if (this.cstSkdSimDtlCalcInfoVOs != null) {
			rtnVOs = Arrays.copyOf(this.cstSkdSimDtlCalcInfoVOs, this.cstSkdSimDtlCalcInfoVOs.length);
		} // end if
		return rtnVOs;
	}


	/**
	 * @param cstSkdSimDtlCalcInfoVOs the cstSkdSimDtlCalcInfoVOs to set
	 */
	public void setCstSkdSimDtlCalcInfoVOs(
			CstSkdSimDtlCalcInfoVO[] cstSkdSimDtlCalcInfoVOs) {
		if (cstSkdSimDtlCalcInfoVOs != null) {
			CstSkdSimDtlCalcInfoVO[] tmpVOs = Arrays.copyOf(cstSkdSimDtlCalcInfoVOs, cstSkdSimDtlCalcInfoVOs.length);
			this.cstSkdSimDtlCalcInfoVOs = tmpVOs;
		} // end if
	}


	/**
	 * @return the vvdVO
	 */
	public VvdVO getVvdVO() {
		return vvdVO;
	}


	/**
	 * @param vvdVO the vvdVO to set
	 */
	public void setVvdVO(VvdVO vvdVO) {
		this.vvdVO = vvdVO;
	}


	/**
	 * @return the vvdVOs
	 */
	public VvdVO[] getVvdVOs() {
		VvdVO[] rtnVOs = null;
		if (this.vvdVOs != null) {
			rtnVOs = Arrays.copyOf(this.vvdVOs, this.vvdVOs.length);
		} // end if
		return rtnVOs;
	}


	/**
	 * @param vvdVOs the vvdVOs to set
	 */
	public void setVvdVOs(VvdVO[] vvdVOs) {
		if (vvdVOs != null) {
			VvdVO[] tmpVOs = Arrays.copyOf(vvdVOs, vvdVOs.length);
			this.vvdVOs = tmpVOs;
		} // end if
	}
}