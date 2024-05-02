/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVskXchSkdEvent.java
*@FileTitle : Coastal SKD Simulation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : Jung Jinwoo
*@LastVersion : 1.0
* 2009.06.11 Jung Jinwoo
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulesendmanagement.event;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.CstSkdSimDtlCalcInfoVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.SwapCstSkdSimVO;
import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VvdPortTariffVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.PfLaneTypeVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.VskPortDistVO;


/**
 * VOP_VSK_0015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jinwoo
 * @see VOP_VSK_0015HTMLAction 참조
 * @since J2EE 1.5
 */

public class VopVskXchSkdEvent extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SwapCstSkdSimVO swapCstSkdSimVO = null;
	
	private VvdVO vvdVO = null;
	
	private YardVO yardVO = null;
	
	private VskPortDistVO vskPortDistVO = null;
	
	private CstSkdSimDtlCalcInfoVO cstSkdSimDtlCalcInfoVO = null;
	
	private PfLaneTypeVO pfLaneTypeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SwapCstSkdSimVO[] swapCstSkdSimVOs = null;
	
	private VvdVO[] vvdVOs = null;
	
	private YardVO[] yardVOs = null;
	
	private VskPortDistVO[] vskPortDistVOs = null;
	
	private CstSkdSimDtlCalcInfoVO[] cstSkdSimDtlCalcInfoVOs = null;
	
	private PfLaneTypeVO[] pfLaneTypeVOs = null;
	
	private VvdPortTariffVO[]	vvdPortTariffVOs		= null;

	public VopVskXchSkdEvent(){}


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
		SwapCstSkdSimVO[] rtnVOs =  null;
		if(this.swapCstSkdSimVOs != null){
			rtnVOs = new SwapCstSkdSimVO[swapCstSkdSimVOs.length];
			System.arraycopy(swapCstSkdSimVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return swapCstSkdSimVOs;
	}


	/**
	 * @param swapCstSkdSimVOs the swapCstSkdSimVOs to set
	 */
	public void setSwapCstSkdSimVOs(SwapCstSkdSimVO[] swapCstSkdSimVOs) {
		if(swapCstSkdSimVOs != null){
			SwapCstSkdSimVO[] tmpVOs = new SwapCstSkdSimVO[swapCstSkdSimVOs.length];
			System.arraycopy(swapCstSkdSimVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.swapCstSkdSimVOs = tmpVOs;
		}
		//소스보안 2015.07.16
		//this.swapCstSkdSimVOs = swapCstSkdSimVOs;
	}


	/**
	 * @return the yardVOs
	 */
	public YardVO[] getYardVOs() {
		YardVO[] rtnVOs =  null;
		if(this.yardVOs != null){
			rtnVOs = new YardVO[yardVOs.length];
			System.arraycopy(yardVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return yardVOs;
	}


	/**
	 * @param yardVOs the yardVOs to set
	 */
	public void setYardVOs(YardVO[] yardVOs) {
		if(yardVOs != null){
			YardVO[] tmpVOs = new YardVO[yardVOs.length];
			System.arraycopy(yardVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.yardVOs = tmpVOs;
		}
		//소스보안 2015.07.16
		//this.yardVOs = yardVOs;
	}


	/**
	 * @return the vskPortDistVOs
	 */
	public VskPortDistVO[] getVskPortDistVOs() {
		VskPortDistVO[] rtnVOs =  null;
		if(this.vskPortDistVOs != null){
			rtnVOs = new VskPortDistVO[vskPortDistVOs.length];
			System.arraycopy(vskPortDistVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return vskPortDistVOs;
	}


	/**
	 * @param vskPortDistVOs the vskPortDistVOs to set
	 */
	public void setVskPortDistVOs(VskPortDistVO[] vskPortDistVOs) {
		if(vskPortDistVOs != null){
			VskPortDistVO[] tmpVOs = new VskPortDistVO[vskPortDistVOs.length];
			System.arraycopy(vskPortDistVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vskPortDistVOs = tmpVOs;
		}
		//소스보안 2015.07.16
		//this.vskPortDistVOs = vskPortDistVOs;
	}


	/**
	 * @return the cstSkdSimDtlCalcInfoVOs
	 */
	public CstSkdSimDtlCalcInfoVO[] getCstSkdSimDtlCalcInfoVOs() {
		CstSkdSimDtlCalcInfoVO[] rtnVOs =  null;
		if(this.cstSkdSimDtlCalcInfoVOs != null){
			rtnVOs = new CstSkdSimDtlCalcInfoVO[cstSkdSimDtlCalcInfoVOs.length];
			System.arraycopy(cstSkdSimDtlCalcInfoVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return cstSkdSimDtlCalcInfoVOs;
	}


	/**
	 * @param cstSkdSimDtlCalcInfoVOs the cstSkdSimDtlCalcInfoVOs to set
	 */
	public void setCstSkdSimDtlCalcInfoVOs(CstSkdSimDtlCalcInfoVO[] cstSkdSimDtlCalcInfoVOs) {
		if(cstSkdSimDtlCalcInfoVOs != null){
			CstSkdSimDtlCalcInfoVO[] tmpVOs = new CstSkdSimDtlCalcInfoVO[cstSkdSimDtlCalcInfoVOs.length];
			System.arraycopy(cstSkdSimDtlCalcInfoVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cstSkdSimDtlCalcInfoVOs = tmpVOs;
		}
		//소스보안 2015.07.16
		//this.cstSkdSimDtlCalcInfoVOs = cstSkdSimDtlCalcInfoVOs;
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
		VvdVO[] rtnVOs =  null;
		if(this.vvdVOs != null){
			rtnVOs = new VvdVO[vvdVOs.length];
			System.arraycopy(vvdVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return vvdVOs;
	}


	/**
	 * @param vvdVOs the vvdVOs to set
	 */
	public void setVvdVOs(VvdVO[] vvdVOs) {
		if(vvdVOs != null){
			VvdVO[] tmpVOs = new VvdVO[vvdVOs.length];
			System.arraycopy(vvdVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vvdVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this.vvdVOs = vvdVOs;
	}


	/**
	 * @return the pfLaneTypeVO
	 */
	public PfLaneTypeVO getPfLaneTypeVO() {
		return pfLaneTypeVO;
	}


	/**
	 * @param pfLaneTypeVO the pfLaneTypeVO to set
	 */
	public void setPfLaneTypeVO(PfLaneTypeVO pfLaneTypeVO) {
		this.pfLaneTypeVO = pfLaneTypeVO;
	}


	/**
	 * @return the pfLaneTypeVOs
	 */
	public PfLaneTypeVO[] getPfLaneTypeVOs() {
		PfLaneTypeVO[] rtnVOs =  null;
		if(this.pfLaneTypeVOs != null){
			rtnVOs = new PfLaneTypeVO[pfLaneTypeVOs.length];
			System.arraycopy(pfLaneTypeVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return pfLaneTypeVOs;
	}


	/**
	 * @param pfLaneTypeVOs the pfLaneTypeVOs to set
	 */
	public void setPfLaneTypeVOs(PfLaneTypeVO[] pfLaneTypeVOs) {
		if(pfLaneTypeVOs != null){
			PfLaneTypeVO[] tmpVOs = new PfLaneTypeVO[pfLaneTypeVOs.length];
			System.arraycopy(pfLaneTypeVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.pfLaneTypeVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this.pfLaneTypeVOs = pfLaneTypeVOs;
	}
	
	/**
	 * @return the vvdPortTariffVOs
	 */
	public VvdPortTariffVO[] getVvdPortTariffVOs() {
		VvdPortTariffVO[] rtnVOs =  null;
		if(this.vvdPortTariffVOs != null){
			rtnVOs = new VvdPortTariffVO[vvdPortTariffVOs.length];
			System.arraycopy(vvdPortTariffVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.07.20
		//return vvdPortTariffVOs;
	}
	
	/**
	 * @param vvdPortTariffVOs the vvdPortTariffVOs to set
	 */
	public void setVvdPortTariffVOs(VvdPortTariffVO[] vvdPortTariffVOs) {
		if(vvdPortTariffVOs != null){
			VvdPortTariffVO[] tmpVOs = new VvdPortTariffVO[vvdPortTariffVOs.length];
			System.arraycopy(vvdPortTariffVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vvdPortTariffVOs = tmpVOs;
		}
		//소스보안 2015.07.20
		//this.vvdPortTariffVOs = vvdPortTariffVOs;
	}
	
	
}


