/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0059Event.java
*@FileTitle : VSL SKD Delete & Closing(CCA)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.08.07 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.ActivationVvdVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.VskVslSkdHisVO;

/**
 * VOP_VSK_0059 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0059HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO CHANG YUL
 * @see VOP_VSK_0059HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0059Event extends EventSupport {

private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ActivationVvdVO activationVvdVO = null;
	
	private VskVslSkdHisVO vskVslSkdHisVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ActivationVvdVO[] activationVvdVOs = null;
	
	private VskVslSkdHisVO[] vskVslSkdHisVOs = null;

	public VopVsk0059Event(){}
	
	public void setActivationVvdVO(ActivationVvdVO activationVvdVO){
		this.activationVvdVO = activationVvdVO;
	}
	
	public void setVskVslSkdHisVO(VskVslSkdHisVO vskVslSkdHisVO){
		this.vskVslSkdHisVO = vskVslSkdHisVO;
	}

	public void setActivationVvdVOS(ActivationVvdVO[] activationVvdVOs){
		if (activationVvdVOs != null) {
			ActivationVvdVO[] tmpVOs = Arrays.copyOf(activationVvdVOs, activationVvdVOs.length);
			this.activationVvdVOs = tmpVOs;
		} // end if
	}
	
	public void setVskVslSkdHisVOS(VskVslSkdHisVO[] vskVslSkdHisVOs){
		if (vskVslSkdHisVOs != null) {
			VskVslSkdHisVO[] tmpVOs = Arrays.copyOf(vskVslSkdHisVOs, vskVslSkdHisVOs.length);
			this.vskVslSkdHisVOs = tmpVOs;
		} // end if
	}

	public ActivationVvdVO getActivationVvdVO(){
		return activationVvdVO;
	}
	
	public VskVslSkdHisVO getVskVslSkdHisVO(){
		return vskVslSkdHisVO;
	}

	public ActivationVvdVO[] getActivationVvdVOS(){
		ActivationVvdVO[] rtnVOs = null;
		if (this.activationVvdVOs != null) {
			rtnVOs = Arrays.copyOf(this.activationVvdVOs, this.activationVvdVOs.length);
		} // end if
		return rtnVOs;
	}
	
	public VskVslSkdHisVO[] getVskVslSkdHisVOS(){
		VskVslSkdHisVO[] rtnVOs = null;
		if (this.vskVslSkdHisVOs != null) {
			rtnVOs = Arrays.copyOf(this.vskVslSkdHisVOs, this.vskVslSkdHisVOs.length);
		} // end if
		return rtnVOs;
	}

}