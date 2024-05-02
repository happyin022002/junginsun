/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0065Event.java
*@FileTitle : VSL SKD history Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : Jung Jinwoo
*@LastVersion : 1.0
* 2009.06.29 Jung Jinwoo
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_0065 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0065HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jinwoo
 * @see VOP_VSK_0065HTMLAction 참조
 * @since J2EE 1.5
 */

public class VopVsk0065Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VvdPortLaneOtherVO vvdPortLaneOtherVO = null;
	
	private VvdVO vvdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VvdPortLaneOtherVO[] vvdPortLaneOtherVOs = null;
	
	private VvdVO[] vvdVOs = null;

	public VopVsk0065Event(){}

	/**
	 * @return the vvdPortLaneOtherVO
	 */
	public VvdPortLaneOtherVO getVvdPortLaneOtherVO() {
		return vvdPortLaneOtherVO;
	}

	/**
	 * @param vvdPortLaneOtherVO the vvdPortLaneOtherVO to set
	 */
	public void setVvdPortLaneOtherVO(VvdPortLaneOtherVO vvdPortLaneOtherVO) {
		this.vvdPortLaneOtherVO = vvdPortLaneOtherVO;
	}

	/**
	 * @return the vvdPortLaneOtherVOs
	 */
	public VvdPortLaneOtherVO[] getVvdPortLaneOtherVOs() {
		VvdPortLaneOtherVO[] rtnVOs = null;
		if (this.vvdPortLaneOtherVOs != null) {
			rtnVOs = Arrays.copyOf(this.vvdPortLaneOtherVOs, this.vvdPortLaneOtherVOs.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param vvdPortLaneOtherVOs the vvdPortLaneOtherVOs to set
	 */
	public void setVvdPortLaneOtherVOs(VvdPortLaneOtherVO[] vvdPortLaneOtherVOs) {
		if (vvdPortLaneOtherVOs != null) {
			VvdPortLaneOtherVO[] tmpVOs = Arrays.copyOf(vvdPortLaneOtherVOs, vvdPortLaneOtherVOs.length);
			this.vvdPortLaneOtherVOs = tmpVOs;
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