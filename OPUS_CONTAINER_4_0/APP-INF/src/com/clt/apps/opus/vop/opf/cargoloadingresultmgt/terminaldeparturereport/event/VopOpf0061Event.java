/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0061Event.java
*@FileTitle : Cargo Re-Handling Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.07
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.08.07 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.CgoRhndPerformInputVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_OPF_0061 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0061HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see VOP_OPF_0061HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf0061Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CgoRhndPerformInputVO cgoRhndPerformInputVO = null;
	private TerminalDepartureReportConditionVO terminalDepartureReportConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CgoRhndPerformInputVO[] cgoRhndPerformInputVOs = null;

	public VopOpf0061Event(){}
	
	public void setCgoRhndPerformInputVO(CgoRhndPerformInputVO cgoRhndPerformInputVO){
		this. cgoRhndPerformInputVO = cgoRhndPerformInputVO;
	}

	public void setCgoRhndPerformInputVOS(CgoRhndPerformInputVO[] cgoRhndPerformInputVOs){
		if (cgoRhndPerformInputVOs != null) {
			CgoRhndPerformInputVO[] tmpVOs = Arrays.copyOf(cgoRhndPerformInputVOs, cgoRhndPerformInputVOs.length);
			this.cgoRhndPerformInputVOs = tmpVOs;
		} // end if
	}

	public CgoRhndPerformInputVO getCgoRhndPerformInputVO(){
		return cgoRhndPerformInputVO;
	}

	public CgoRhndPerformInputVO[] getCgoRhndPerformInputVOS(){
		CgoRhndPerformInputVO[] rtnVOs = null;
		if (this.cgoRhndPerformInputVOs != null) {
			rtnVOs = Arrays.copyOf(this.cgoRhndPerformInputVOs, this.cgoRhndPerformInputVOs.length);
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