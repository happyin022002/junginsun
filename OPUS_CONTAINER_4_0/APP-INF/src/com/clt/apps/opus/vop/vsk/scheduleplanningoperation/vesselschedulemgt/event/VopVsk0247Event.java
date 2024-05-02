/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0247Event.java
*@FileTitle : SHA Loadable weight 계산/조회
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : Jung Jinwoo
*@LastVersion : 1.0
* 2009.07.01 Jung Jinwoo
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.LoadWgtVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.VskVslPortSkdVO;


/**
 * VOP_VSK_0247 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0247HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Jinwoo
 * @see VOP_VSK_0247HTMLAction 참조
 * @since J2EE 1.5
 */

public class VopVsk0247Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private LoadWgtVO loadWgtVO = null;
	private VskVslPortSkdVO vskVslPortSkdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private LoadWgtVO[] loadWgtVOs = null;
	private VskVslPortSkdVO[] vskVslPortSkdVOs = null;

	public VopVsk0247Event(){}

	/**
	 * @return the loadWgtVO
	 */
	public LoadWgtVO getLoadWgtVO() {
		return loadWgtVO;
	}

	/**
	 * @param loadWgtVO the loadWgtVO to set
	 */
	public void setLoadWgtVO(LoadWgtVO loadWgtVO) {
		this.loadWgtVO = loadWgtVO;
	}

	/**
	 * @return the loadWgtVOs
	 */
	public LoadWgtVO[] getLoadWgtVOs() {
		LoadWgtVO[] rtnVOs = null;
		if (this.loadWgtVOs != null) {
			rtnVOs = Arrays.copyOf(this.loadWgtVOs, this.loadWgtVOs.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param loadWgtVOs the loadWgtVOs to set
	 */
	public void setLoadWgtVOs(LoadWgtVO[] loadWgtVOs) {
		if (loadWgtVOs != null) {
			LoadWgtVO[] tmpVOs = Arrays.copyOf(loadWgtVOs, loadWgtVOs.length);
			this.loadWgtVOs = tmpVOs;
		} // end if
	}

	/**
	 * @return the vskVslPortSkdVO
	 */
	public VskVslPortSkdVO getVskVslPortSkdVO() {
		return vskVslPortSkdVO;
	}

	/**
	 * @param vskVslPortSkdVO the vskVslPortSkdVO to set
	 */
	public void setVskVslPortSkdVO(VskVslPortSkdVO vskVslPortSkdVO) {
		this.vskVslPortSkdVO = vskVslPortSkdVO;
	}

	/**
	 * @return the vskVslPortSkdVOs
	 */
	public VskVslPortSkdVO[] getVskVslPortSkdVOs() {
		VskVslPortSkdVO[] rtnVOs = null;
		if (this.vskVslPortSkdVOs != null) {
			rtnVOs = Arrays.copyOf(this.vskVslPortSkdVOs, this.vskVslPortSkdVOs.length);
		} // end if
		return rtnVOs;
	}

	/**
	 * @param vskVslPortSkdVOs the vskVslPortSkdVOs to set
	 */
	public void setVskVslPortSkdVOs(VskVslPortSkdVO[] vskVslPortSkdVOs) {
		if (vskVslPortSkdVOs != null) {
			VskVslPortSkdVO[] tmpVOs = Arrays.copyOf(vskVslPortSkdVOs, vskVslPortSkdVOs.length);
			this.vskVslPortSkdVOs = tmpVOs;
		} // end if
	}
}