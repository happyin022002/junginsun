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
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdPortLaneOtherVO;
import com.hanjin.apps.alps.vop.vsk.vskcommon.vskcodefinder.vo.VvdVO;
import com.hanjin.framework.support.layer.event.EventSupport;


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
		VvdPortLaneOtherVO[] rtnVOs =  null;
		if(this.vvdPortLaneOtherVOs != null){
			rtnVOs = new VvdPortLaneOtherVO[vvdPortLaneOtherVOs.length];
			System.arraycopy(vvdPortLaneOtherVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return vvdPortLaneOtherVOs;
	}

	/**
	 * @param vvdPortLaneOtherVOs the vvdPortLaneOtherVOs to set
	 */
	public void setVvdPortLaneOtherVOs(VvdPortLaneOtherVO[] vvdPortLaneOtherVOs) {
		if(vvdPortLaneOtherVOs != null){
			VvdPortLaneOtherVO[] tmpVOs = new VvdPortLaneOtherVO[vvdPortLaneOtherVOs.length];
			System.arraycopy(vvdPortLaneOtherVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vvdPortLaneOtherVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.vvdPortLaneOtherVOs = vvdPortLaneOtherVOs;
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
		//소스보안 2015.08
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
		//소스보안 2015.08
		//this.vvdVOs = vvdVOs;
	}

}