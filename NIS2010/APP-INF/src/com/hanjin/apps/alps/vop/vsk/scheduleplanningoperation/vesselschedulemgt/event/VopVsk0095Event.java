/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VopVsk0095Event.java
*@FileTitle : VVD SKD Interface To ERP
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.10
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.12.10 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.VslSkdRepeatErpIfVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK_0095 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK_0095HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see VOP_VSK_0095HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopVsk0095Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private VslSkdRepeatErpIfVO vslSkdRepeatErpIfVO = null;

	/** Table Value Object Multi Data 처리 */
	private VslSkdRepeatErpIfVO[] vslSkdRepeatErpIfVOs = null;

	public VopVsk0095Event() {}

	public VslSkdRepeatErpIfVO getVslSkdRepeatErpIfVO() {
		return vslSkdRepeatErpIfVO;
	}

	public void setVslSkdRepeatErpIfVO(VslSkdRepeatErpIfVO vslSkdRepeatErpIfVO) {
		this.vslSkdRepeatErpIfVO = vslSkdRepeatErpIfVO;
	}

	public VslSkdRepeatErpIfVO[] getVslSkdRepeatErpIfVOs() {
		VslSkdRepeatErpIfVO[] rtnVOs =  null;
		if(this.vslSkdRepeatErpIfVOs != null){
			rtnVOs = new VslSkdRepeatErpIfVO[vslSkdRepeatErpIfVOs.length];
			System.arraycopy(vslSkdRepeatErpIfVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return vslSkdRepeatErpIfVOs;
	}

	public void setVslSkdRepeatErpIfVOs(VslSkdRepeatErpIfVO[] vslSkdRepeatErpIfVOs) {
		if(vslSkdRepeatErpIfVOs != null){
			VslSkdRepeatErpIfVO[] tmpVOs = new VslSkdRepeatErpIfVO[vslSkdRepeatErpIfVOs.length];
			System.arraycopy(vslSkdRepeatErpIfVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.vslSkdRepeatErpIfVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.vslSkdRepeatErpIfVOs = vslSkdRepeatErpIfVOs;
	}

}
