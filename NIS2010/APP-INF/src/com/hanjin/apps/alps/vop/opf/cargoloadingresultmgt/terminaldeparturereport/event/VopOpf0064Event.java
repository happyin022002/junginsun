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
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TdrListOptionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportConditionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TmnlPerformInputVO;


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
			TdrListOptionVO[] tmpVOs = new TdrListOptionVO[tdrListOptionVOs.length];
			System.arraycopy(tdrListOptionVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.tdrListOptionVOs = tmpVOs;
		}
	}

	public TdrListOptionVO getTdrListOptionVO(){
		return tdrListOptionVO;
	}

	public TdrListOptionVO[] getTdrListOptionVOS(){
		TdrListOptionVO[] rtnVOs = null;
 		
 		if (this.tdrListOptionVOs != null) {
 			rtnVOs = new TdrListOptionVO[tdrListOptionVOs.length];
 			System.arraycopy(tdrListOptionVOs, 0, rtnVOs, 0, rtnVOs.length);
 		 }		
 		 return rtnVOs;
	}

	public void setTerminalDepartureReportConditionVO(TerminalDepartureReportConditionVO terminalDepartureReportConditionVO) {
		this.terminalDepartureReportConditionVO = terminalDepartureReportConditionVO;
	}
	
	public TerminalDepartureReportConditionVO getTerminalDepartureReportConditionVO() {
		return terminalDepartureReportConditionVO;
	}		
	
}