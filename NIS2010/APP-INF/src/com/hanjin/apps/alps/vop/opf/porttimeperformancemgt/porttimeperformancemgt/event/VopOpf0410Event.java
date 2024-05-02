/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VopOpf0410Event.java
*@FileTitle : Port Time KPI Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.06
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.06
* 1.0 Creation
* 2012.02.06 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
=========================================================*/
package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.event;

import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimeKPIDetailVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimePerformanceConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * VOP_OPF_0410 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0410HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see VOP_OPF_0410HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf0410Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PortTimeKPIDetailVO portTimeKPIDetailVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PortTimeKPIDetailVO[] portTimeKPIDetailVOs = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private PortTimePerformanceConditionVO portTimePerformanceConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PortTimePerformanceConditionVO[] portTimePerformanceConditionVOs = null;

	public VopOpf0410Event(){}

	public PortTimeKPIDetailVO getPortTimeKPIDetailVO() {
		return portTimeKPIDetailVO;
	}

	public PortTimeKPIDetailVO[] getPortTimeKPIDetailVOs() {
		PortTimeKPIDetailVO[] rtnVOs = null;

 		if (this.portTimeKPIDetailVOs != null) {
 			rtnVOs = new PortTimeKPIDetailVO[portTimeKPIDetailVOs.length];
 			System.arraycopy(portTimeKPIDetailVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}

	public PortTimePerformanceConditionVO getPortTimePerformanceConditionVO() {
		return portTimePerformanceConditionVO;
	}

	public PortTimePerformanceConditionVO[] getPortTimePerformanceConditionVOs() {
		PortTimePerformanceConditionVO[] rtnVOs = null;

 		if (this.portTimePerformanceConditionVOs != null) {
 			rtnVOs = new PortTimePerformanceConditionVO[portTimePerformanceConditionVOs.length];
 			System.arraycopy(portTimePerformanceConditionVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}

	public void setPortTimeKPIDetailVO(PortTimeKPIDetailVO portTimeKPIDetailVO) {
		this.portTimeKPIDetailVO = portTimeKPIDetailVO;
	}

	public void setPortTimeKPIDetailVOs(PortTimeKPIDetailVO[] portTimeKPIDetailVOs) {
		if (portTimeKPIDetailVOs != null) {
			PortTimeKPIDetailVO[] tmpVOs = new PortTimeKPIDetailVO[portTimeKPIDetailVOs.length];
			System.arraycopy(portTimeKPIDetailVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.portTimeKPIDetailVOs = tmpVOs;
		}
	}

	public void setPortTimePerformanceConditionVO(
			PortTimePerformanceConditionVO portTimePerformanceConditionVO) {
		this.portTimePerformanceConditionVO = portTimePerformanceConditionVO;
	}

	public void setPortTimePerformanceConditionVOs(
			PortTimePerformanceConditionVO[] portTimePerformanceConditionVOs) {
		if (portTimePerformanceConditionVOs != null) {
			PortTimePerformanceConditionVO[] tmpVOs = new PortTimePerformanceConditionVO[portTimePerformanceConditionVOs.length];
			System.arraycopy(portTimePerformanceConditionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.portTimePerformanceConditionVOs = tmpVOs;
		}
	}
	
	
}