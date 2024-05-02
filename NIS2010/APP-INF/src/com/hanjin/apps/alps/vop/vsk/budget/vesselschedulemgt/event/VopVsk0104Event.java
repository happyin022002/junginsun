/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopVsk0104Event.java
*@FileTitle : Budget L/R SKD Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.22
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2011.02.10 진마리아
* 1.0 Creation
* 
* History
* 2011.02.22 진마리아 CHM-201108456-01 사업계획용 스케줄 정보 노출 대응을 위한 시스템 업데이트건
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.budget.vesselschedulemgt.event;

import com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo.PortSkdOnLongRangeVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_VSK-0104 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_VSK-0104HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Maria Chin
 * @see VOP_VSK_0104HTMLAction 참조
 * @since J2EE 1.4
 */

public class VopVsk0104Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PortSkdOnLongRangeVO portSkdOnLongRangeVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PortSkdOnLongRangeVO[] portSkdOnLongRangeVOs = null;
	
	public VopVsk0104Event(){}

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
	
}