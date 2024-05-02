/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0012Event.java
*@FileTitle : Long Range SKD Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.23
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.07.01 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.PortSkdOnLongRangeVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK-0012 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK-0012HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Ryu Hyuk
 * @see VOP_VSK_0012HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0012Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PortSkdOnLongRangeVO portSkdOnLongRangeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PortSkdOnLongRangeVO[] portSkdOnLongRangeVOs = null;
	
	public VopVsk0012Event(){}

	public PortSkdOnLongRangeVO getPortSkdOnLongRangeVO() {
		return portSkdOnLongRangeVO;
	}

	public void setPortSkdOnLongRangeVO(PortSkdOnLongRangeVO portSkdOnLongRangeVO) {
		this.portSkdOnLongRangeVO = portSkdOnLongRangeVO;
	}

	public PortSkdOnLongRangeVO[] getPortSkdOnLongRangeVOS() {
		PortSkdOnLongRangeVO[] rtnVOs = null;
		if (this.portSkdOnLongRangeVOs != null) {
			rtnVOs = Arrays.copyOf(this.portSkdOnLongRangeVOs, this.portSkdOnLongRangeVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setPortSkdOnLongRangeVOS(PortSkdOnLongRangeVO[] portSkdOnLongRangeVOs) {
		if (portSkdOnLongRangeVOs != null) {
			PortSkdOnLongRangeVO[] tmpVOs = Arrays.copyOf(portSkdOnLongRangeVOs, portSkdOnLongRangeVOs.length);
			this.portSkdOnLongRangeVOs = tmpVOs;
		} // end if
	}
	
}