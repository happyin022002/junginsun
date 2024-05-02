/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf2069Event.java
*@FileTitle : TDR Details
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
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_OPF_2069 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_2069HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see VOP_OPF_2069HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf2069Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TerminalDepartureReportVO terminalDepartureReportVO = null;
	private TerminalDepartureReportConditionVO terminalDepartureReportConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TerminalDepartureReportVO[] terminalDepartureReportVOs = null;

	public VopOpf2069Event(){}
	
	public void setTerminalDepartureReportVO(TerminalDepartureReportVO terminalDepartureReportVO){
		this. terminalDepartureReportVO = terminalDepartureReportVO;
	}

	public void setTerminalDepartureReportVOS(TerminalDepartureReportVO[] terminalDepartureReportVOs){
		if (terminalDepartureReportVOs != null) {
			TerminalDepartureReportVO[] tmpVOs = Arrays.copyOf(terminalDepartureReportVOs, terminalDepartureReportVOs.length);
			this.terminalDepartureReportVOs = tmpVOs;
		} // end if
	}

	public TerminalDepartureReportVO getTerminalDepartureReportVO(){
		return terminalDepartureReportVO;
	}

	public TerminalDepartureReportVO[] getTerminalDepartureReportVOS(){
		TerminalDepartureReportVO[] rtnVOs = null;
		if (this.terminalDepartureReportVOs != null) {
			rtnVOs = Arrays.copyOf(this.terminalDepartureReportVOs, this.terminalDepartureReportVOs.length);
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