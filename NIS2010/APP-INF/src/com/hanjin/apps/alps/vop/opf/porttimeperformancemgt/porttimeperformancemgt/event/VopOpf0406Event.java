/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : VopOpf0406Event.java
*@FileTitle : Port Time Activity Report by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2012.02.15
* 1.0 Creation
* 2012.02.15 김민아 [CHM-201215901-01] Port Time Reduction project 개발 (2차)
=========================================================*/
package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimeActivityVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimePerformanceConditionVO;


/**
 * VOP_OPF_0406 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0406HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see VOP_OPF_0406HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf0406Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PortTimePerformanceConditionVO portTimePerformanceConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PortTimePerformanceConditionVO[] portTimePerformanceConditionVOs = null;

	public VopOpf0406Event(){}

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