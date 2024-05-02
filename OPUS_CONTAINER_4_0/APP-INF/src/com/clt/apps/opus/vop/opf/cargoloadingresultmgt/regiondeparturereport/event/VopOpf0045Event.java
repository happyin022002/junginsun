/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0045Event.java
*@FileTitle : RDR Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.07.20 이선영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRListOptionVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportCondVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_OPF_0045 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0045HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SunyoungLee
 * @see VOP_OPF_0045HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf0045Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RDRListOptionVO rdrListOptionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RDRListOptionVO[] rdrListOptionVOs = null;


	public VopOpf0045Event(){}
	
	public void setRDRListOptionVO(RDRListOptionVO rdrListOptionVO){
		this. rdrListOptionVO = rdrListOptionVO;
	}

	public void setRDRListOptionVOS(RDRListOptionVO[] rdrListOptionVOs){
		if (rdrListOptionVOs != null) {
			RDRListOptionVO[] tmpVOs = Arrays.copyOf(rdrListOptionVOs, rdrListOptionVOs.length);
			this.rdrListOptionVOs = tmpVOs;
		} // end if
	}

	public RDRListOptionVO getRDRListOptionVO(){
		return rdrListOptionVO;
	}

	public RDRListOptionVO[] getRDRListOptionVOS(){
		RDRListOptionVO[] rtnVOs = null;
		if (this.rdrListOptionVOs != null) {
			rtnVOs = Arrays.copyOf(this.rdrListOptionVOs, this.rdrListOptionVOs.length);
		} // end if
		return rtnVOs;
	}
	
	//KJH ADD 2014.11.14( Receiver Information) 
	private TerminalDepartureReportCondVO terminalDepartureReportCondVO = null;
	/**
	 * @param terminalDepartureReportCondVO the terminalDepartureReportCondVO to set
	 */
	public void setTerminalDepartureReportCondVO(
			TerminalDepartureReportCondVO terminalDepartureReportCondVO) {
		this.terminalDepartureReportCondVO = terminalDepartureReportCondVO;
	}
	/**
	 * @return the terminalDepartureReportCondVO
	 */
	public TerminalDepartureReportCondVO getTerminalDepartureReportCondVO() {
		return terminalDepartureReportCondVO;
	}
	
}