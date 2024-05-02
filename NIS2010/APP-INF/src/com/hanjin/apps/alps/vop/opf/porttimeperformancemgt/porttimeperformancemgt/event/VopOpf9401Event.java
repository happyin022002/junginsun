/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VopOpf9401Event.java
*@FileTitle : Port Time Performance Dashboard Report
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.08
*@LastModifier : 
*@LastVersion : 1.0
* 2012.06.08
* 1.0 Creation
* 2012.06.08 허철용 [CHM-201217512-01] PTRP 화면에 Dashboard 기능 추가
=========================================================*/
package com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimePerformanceConditionVO;
import com.hanjin.apps.alps.vop.opf.porttimeperformancemgt.porttimeperformancemgt.vo.PortTimeVVDRemarkVO;


/**
 * VOP_OPF_0401 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_9401HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see VOP_OPF_9401HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf9401Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private PortTimeVVDRemarkVO portTimeVVDRemarkVO = null;
	private PortTimePerformanceConditionVO portTimePerformanceConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private PortTimeVVDRemarkVO[] portTimeVVDRemarkVOs = null;

	public VopOpf9401Event(){}

	public PortTimePerformanceConditionVO getPortTimePerformanceConditionVO() {
		return portTimePerformanceConditionVO;
	}

	public void setPortTimePerformanceConditionVO(PortTimePerformanceConditionVO portTimePerformanceConditionVO) {
		this.portTimePerformanceConditionVO = portTimePerformanceConditionVO;
	}
	
	public PortTimeVVDRemarkVO getPortTimeVVDRemarkVO() {
		return portTimeVVDRemarkVO;
	}
	
	public void setPortTimeVVDRemarkVO(PortTimeVVDRemarkVO portTimeVVDRemarkVO) {
		this.portTimeVVDRemarkVO = portTimeVVDRemarkVO;
	}

	public PortTimeVVDRemarkVO[] getPortTimeVVDRemarkVOs() {
		PortTimeVVDRemarkVO[] rtnVOs = null;

 		if (this.portTimeVVDRemarkVOs != null) {
 			rtnVOs = new PortTimeVVDRemarkVO[portTimeVVDRemarkVOs.length];
 			System.arraycopy(portTimeVVDRemarkVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}
	
	public void setPortTimeVVDRemarkVOs(PortTimeVVDRemarkVO[] portTimeVVDRemarkVOs) {
		if (portTimeVVDRemarkVOs != null) {
			PortTimeVVDRemarkVO[] tmpVOs = new PortTimeVVDRemarkVO[portTimeVVDRemarkVOs.length];
			System.arraycopy(portTimeVVDRemarkVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.portTimeVVDRemarkVOs = tmpVOs;
		}
	}
}