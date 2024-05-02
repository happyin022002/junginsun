/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VopOpf0057Event.java
*@FileTitle : Cargo Handling Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.08.05 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.event;

import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.CgoHndPerformInputVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.terminaldeparturereport.vo.TerminalDepartureReportConditionVO;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;


/**
 * VOP_OPF_0057 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  VOP_OPF_0057HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Jong Ock
 * @see VOP_OPF_0057HTMLAction 참조
 * @since J2EE 1.6
 */

public class VopOpf0057Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CgoHndPerformInputVO cgoHndPerformInputVO = null;
	private TerminalDepartureReportConditionVO terminalDepartureReportConditionVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CgoHndPerformInputVO[] cgoHndPerformInputVOs = null;

	public VopOpf0057Event(){}
	
	public void setCgoHndPerformInputVO(CgoHndPerformInputVO cgoHndPerformInputVO){
		this. cgoHndPerformInputVO = cgoHndPerformInputVO;
	}

	public void setCgoHndPerformInputVOS(CgoHndPerformInputVO[] cgoHndPerformInputVOs){
		if (cgoHndPerformInputVOs != null) {
			CgoHndPerformInputVO[] tmpVOs = new CgoHndPerformInputVO[cgoHndPerformInputVOs.length];
			System.arraycopy(cgoHndPerformInputVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.cgoHndPerformInputVOs = tmpVOs;
		}
	}

	public CgoHndPerformInputVO getCgoHndPerformInputVO(){
		return cgoHndPerformInputVO;
	}

	public CgoHndPerformInputVO[] getCgoHndPerformInputVOS(){
		CgoHndPerformInputVO[] rtnVOs = null;
 		
 		if (this.cgoHndPerformInputVOs != null) {
 			rtnVOs = new CgoHndPerformInputVO[cgoHndPerformInputVOs.length];
 			System.arraycopy(cgoHndPerformInputVOs, 0, rtnVOs, 0, rtnVOs.length);
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