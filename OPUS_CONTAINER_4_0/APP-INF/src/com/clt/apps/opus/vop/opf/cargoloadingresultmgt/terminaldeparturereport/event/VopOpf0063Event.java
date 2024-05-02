/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0063Event.java
*@FileTitle : Terminal Performance Port / Lane
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.21
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.08.21 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportConditionVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TmnlPerformInputVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_OPF_0063 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0063HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see VOP_OPF_0063HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf0063Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TmnlPerformInputVO tmnlPerformInputVO = null;
	private TerminalDepartureReportConditionVO terminalDepartureReportConditionVO = null;	
	
	/** Table Value Object Multi Data 처리 */
	private TmnlPerformInputVO[] tmnlPerformInputVOs = null;

	public VopOpf0063Event(){}
	
	public void setTmnlPerformInputVO(TmnlPerformInputVO tmnlPerformInputVO){
		this. tmnlPerformInputVO = tmnlPerformInputVO;
	}

	public void setTmnlPerformInputVOS(TmnlPerformInputVO[] tmnlPerformInputVOs){
		if (tmnlPerformInputVOs != null) {
			TmnlPerformInputVO[] tmpVOs = Arrays.copyOf(tmnlPerformInputVOs, tmnlPerformInputVOs.length);
			this.tmnlPerformInputVOs = tmpVOs;
		} // end if
	}

	public TmnlPerformInputVO getTmnlPerformInputVO(){
		return tmnlPerformInputVO;
	}

	public TmnlPerformInputVO[] getTmnlPerformInputVOS(){
		TmnlPerformInputVO[] rtnVOs = null;
		if (this.tmnlPerformInputVOs != null) {
			rtnVOs = Arrays.copyOf(this.tmnlPerformInputVOs, this.tmnlPerformInputVOs.length);
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