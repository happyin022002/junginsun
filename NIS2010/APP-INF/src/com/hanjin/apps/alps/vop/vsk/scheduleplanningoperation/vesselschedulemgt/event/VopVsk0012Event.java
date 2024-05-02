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
* 
* History
* 2015.09.04 이병훈 [CHM-201537542] Yarc Code 말풍선 도움말 기능 지원
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.event;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.PortSkdOnLongRangeVO;
import com.hanjin.framework.support.layer.event.EventSupport;


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
	
	private String ydCd = null;
	
	
	public VopVsk0012Event(){}

	public PortSkdOnLongRangeVO getPortSkdOnLongRangeVO() {
		return portSkdOnLongRangeVO;
	}

	public void setPortSkdOnLongRangeVO(PortSkdOnLongRangeVO portSkdOnLongRangeVO) {
		this.portSkdOnLongRangeVO = portSkdOnLongRangeVO;
	}

	public PortSkdOnLongRangeVO[] getPortSkdOnLongRangeVOS() {
		PortSkdOnLongRangeVO[] rtnVOs =  null;
		if(this.portSkdOnLongRangeVOs != null){
			rtnVOs = new PortSkdOnLongRangeVO[portSkdOnLongRangeVOs.length];
			System.arraycopy(portSkdOnLongRangeVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
		//소스보안 2015.08
		//return portSkdOnLongRangeVOs;
	}

	public void setPortSkdOnLongRangeVOS(PortSkdOnLongRangeVO[] portSkdOnLongRangeVOs) {
		if(portSkdOnLongRangeVOs != null){
			PortSkdOnLongRangeVO[] tmpVOs = new PortSkdOnLongRangeVO[portSkdOnLongRangeVOs.length];
			System.arraycopy(portSkdOnLongRangeVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.portSkdOnLongRangeVOs = tmpVOs;
		}
		//소스보안 2015.08
		//this.portSkdOnLongRangeVOs = portSkdOnLongRangeVOs;
	}
	
	public String getYdCd() {
		return ydCd;
	}

	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
}