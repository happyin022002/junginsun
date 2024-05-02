/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FnsJoo0106Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.03
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2015.08.03 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationsettlement.settlementprocess.event;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * FNS_JOO_0106 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  FNS_JOO_0106HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0106HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsJoo0106Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    private String acctYrmon = "";	
		
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ProcSettlementVO procSettlementVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ProcSettlementVO[] procSettlementVOs = null;

	public FnsJoo0106Event(){}
	
	public void setProcSettlementVO(ProcSettlementVO procSettlementVO){
		this. procSettlementVO = procSettlementVO;
	}

	public void setProcSettlementVOS(ProcSettlementVO[] procSettlementVOs){
		if (procSettlementVOs != null) {
			ProcSettlementVO[] tmpVOs = new ProcSettlementVO[procSettlementVOs.length];
			System.arraycopy(procSettlementVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.procSettlementVOs = tmpVOs;
		}		
	}

	public ProcSettlementVO getProcSettlementVO(){
		return procSettlementVO;
	}

	public ProcSettlementVO[] getProcSettlementVOS(){
		ProcSettlementVO[] rtnVOs = null;
		if (this.procSettlementVOs != null) {
			rtnVOs = new ProcSettlementVO[procSettlementVOs.length];
			System.arraycopy(procSettlementVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;		
	}
	
    /**
     * @return the acctYrmon
     */
    public String getAcctYrmon() {
        return acctYrmon;
    }	

    /**
     * @param acctYrmon the acctYrmon to set
     */
    public void setAcctYrmon(String acctYrmon) {
        this.acctYrmon = acctYrmon;
    }    
}