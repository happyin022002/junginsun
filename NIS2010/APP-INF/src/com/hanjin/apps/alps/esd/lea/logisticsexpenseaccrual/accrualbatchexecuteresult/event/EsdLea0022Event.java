/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsdLea0022Event.java
*@FileTitle : Monthly Budget Creation
*Open Issues :
*Change history : 
*@LastModifyDate :2015.04.08
*@LastModifier : KIM HYUN HWA
*@LastVersion : 1.0
* 2015.04.08 KIM HYUN HWA
* 1.0 Creation
*=========================================================*/
package com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esd.lea.logisticsexpenseaccrual.accrualbatchexecuteresult.vo.ActCostMonBudgetVO;


/**
 * ESD_LEA_0022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESD_LEA_0022HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM HYUN HWA
 * @see ESD_LEA_0022HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsdLea0022Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ActCostMonBudgetVO ActCostMonBudgetVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ActCostMonBudgetVO[] ActCostMonBudgetVOs = null;
	
	private String bseYr = null; 
	
	private String rhqCd = null; 

	public EsdLea0022Event(){}

	public ActCostMonBudgetVO getActCostMonBudgetVO() {
		return ActCostMonBudgetVO;
	}

	public void setActCostMonBudgetVO(
			ActCostMonBudgetVO ActCostMonBudgetVO) {
		this.ActCostMonBudgetVO = ActCostMonBudgetVO;
	}

	public ActCostMonBudgetVO[] getActCostMonBudgetVOs() {
		ActCostMonBudgetVO[] rtnVOs = null;
		if (this.ActCostMonBudgetVOs != null) {
			rtnVOs = new ActCostMonBudgetVO[ActCostMonBudgetVOs.length];
			System.arraycopy(ActCostMonBudgetVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public void setActCostMonBudgetVOs(ActCostMonBudgetVO[] ActCostMonBudgetVOs){
		if(ActCostMonBudgetVOs != null){
			ActCostMonBudgetVO[] tmpVOs = new ActCostMonBudgetVO[ActCostMonBudgetVOs.length];
			System.arraycopy(ActCostMonBudgetVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.ActCostMonBudgetVOs = tmpVOs;
		}
	}

	public String getBseYr() {
		return bseYr;
	}

	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}

	public String getRhqCd() {
		return rhqCd;
	}

	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}

}