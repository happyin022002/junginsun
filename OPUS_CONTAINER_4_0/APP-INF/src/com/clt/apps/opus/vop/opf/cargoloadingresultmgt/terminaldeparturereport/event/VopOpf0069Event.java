/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0069Event.java
*@FileTitle : Terminal Productivity Report
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.09.03 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportConditionVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TmnlPerformVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_OPF_0069 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0069HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see VOP_OPF_0069HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf0069Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TmnlPerformVO tmnlPerformVO = null;
	private TerminalDepartureReportConditionVO terminalDepartureReportConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TmnlPerformVO[] tmnlPerformVOs = null;

	public VopOpf0069Event(){}
	
	public void setTmnlPerformVO(TmnlPerformVO tmnlPerformVO){
		this. tmnlPerformVO = tmnlPerformVO;
	}

	public void setTmnlPerformVOS(TmnlPerformVO[] tmnlPerformVOs){
		if (tmnlPerformVOs != null) {
			TmnlPerformVO[] tmpVOs = Arrays.copyOf(tmnlPerformVOs, tmnlPerformVOs.length);
			this.tmnlPerformVOs = tmpVOs;
		} // end if
	}

	public TmnlPerformVO getTmnlPerformVO(){
		return tmnlPerformVO;
	}

	public TmnlPerformVO[] getTmnlPerformVOS(){
		TmnlPerformVO[] rtnVOs = null;
		if (this.tmnlPerformVOs != null) {
			rtnVOs = Arrays.copyOf(this.tmnlPerformVOs, this.tmnlPerformVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setTerminalDepartureReportConditionVO(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) {
		this.terminalDepartureReportConditionVO = terminalDepartureReportConditionVO;
	}
	
	public TerminalDepartureReportConditionVO getTerminalDepartureReportConditionVO() {
		return terminalDepartureReportConditionVO;
	}	
}