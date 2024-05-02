/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0064Event.java
*@FileTitle : VSL Condition Statistics
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.08.24 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event;

import java.util.Arrays;

import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrListOptionVO;
import com.clt.apps.opus.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportConditionVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * VOP_OPF_0064 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0064HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see VOP_OPF_0064HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf0064Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private TdrListOptionVO tdrListOptionVO = null;
	private TerminalDepartureReportConditionVO terminalDepartureReportConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TdrListOptionVO[] tdrListOptionVOs = null;

	public VopOpf0064Event(){}
	
	public void setTdrListOptionVO(TdrListOptionVO tdrListOptionVO){
		this. tdrListOptionVO = tdrListOptionVO;
	}

	public void setTdrListOptionVOS(TdrListOptionVO[] tdrListOptionVOs){
		if (tdrListOptionVOs != null) {
			TdrListOptionVO[] tmpVOs = Arrays.copyOf(tdrListOptionVOs, tdrListOptionVOs.length);
			this.tdrListOptionVOs = tmpVOs;
		} // end if
	}

	public TdrListOptionVO getTdrListOptionVO(){
		return tdrListOptionVO;
	}

	public TdrListOptionVO[] getTdrListOptionVOS(){
		TdrListOptionVO[] rtnVOs = null;
		if (this.tdrListOptionVOs != null) {
			rtnVOs = Arrays.copyOf(this.tdrListOptionVOs, this.tdrListOptionVOs.length);
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