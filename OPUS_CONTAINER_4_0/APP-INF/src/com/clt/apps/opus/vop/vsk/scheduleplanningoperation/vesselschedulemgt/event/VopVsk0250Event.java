/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0250Event.java
*@FileTitle : Add Call Information (Pop-Up)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.06.05 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslPortSkdVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_0250 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0250HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_VSK_0250HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0250Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private VslPortSkdVO vslPortSkdVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private VslPortSkdVO[] vslPortSkdVOs = null;
	
	public VopVsk0250Event(){}

	public VslPortSkdVO getVslPortSkdVO() {
		return vslPortSkdVO;
	}

	public void setVslPortSkdVO(VslPortSkdVO vslPortSkdVO) {
		this.vslPortSkdVO = vslPortSkdVO;
	}

	public VslPortSkdVO[] getVslPortSkdVOS() {
		VslPortSkdVO[] rtnVOs = null;
		if (this.vslPortSkdVOs != null) {
			rtnVOs = Arrays.copyOf(this.vslPortSkdVOs, this.vslPortSkdVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setVslPortSkdVOS(VslPortSkdVO[] vslPortSkdVOs) {
		if (vslPortSkdVOs != null) {
			VslPortSkdVO[] tmpVOs = Arrays.copyOf(vslPortSkdVOs, vslPortSkdVOs.length);
			this.vslPortSkdVOs = tmpVOs;
		} // end if
	}
	
}