/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VopOpf0401Event.java
*@FileTitle : Port Time Performance Report
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.03
*@LastModifier : 
*@LastVersion : 1.0
* 2012.01.03
* 1.0 Creation
* 2012.01.16 김민아 [CHM-201215697-01] Port Time Reduction관리 시스템 개발(1차)
=========================================================*/
package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.event;

import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PerformanceSummaryVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimePerformanceConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.OpfTmlProdRptRsnCdVO;


/**
 * VOP_OPF_0401 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0401HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see VOP_OPF_0401HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf0401Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PortTimePerformanceConditionVO portTimePerformanceConditionVO = null;
	private PerformanceSummaryVO performanceSummaryVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PortTimePerformanceConditionVO[] portTimePerformanceConditionVOs = null;
	private PerformanceSummaryVO[] performanceSummaryVOs = null;

	public VopOpf0401Event(){}

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
//
	public void setPerformanceSummaryVO(PerformanceSummaryVO performanceSummaryVO){
		this. performanceSummaryVO = performanceSummaryVO;
	}

	public void setPerformanceSummaryVOS(PerformanceSummaryVO[] performanceSummaryVOs){
		if (performanceSummaryVOs != null) {
			PerformanceSummaryVO[] tmpVOs = new PerformanceSummaryVO[performanceSummaryVOs.length];
			System.arraycopy(performanceSummaryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.performanceSummaryVOs = tmpVOs;
		}
	}
	
	public PerformanceSummaryVO getPerformanceSummaryVO(){
		return performanceSummaryVO;
	}

	public PerformanceSummaryVO[] getPerformanceSummaryVOS(){
		PerformanceSummaryVO[] rtnVOs = null;

 		if (this.performanceSummaryVOs != null) {
 			rtnVOs = new PerformanceSummaryVO[performanceSummaryVOs.length];
 			System.arraycopy(performanceSummaryVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}
}