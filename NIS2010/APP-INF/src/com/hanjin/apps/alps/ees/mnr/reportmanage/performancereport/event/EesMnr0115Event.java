/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0115Event.java
*@FileTitle : Expense Plan and PFMC by HO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.10.07 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairExpensePFMCINVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairExpensePFMCRPTVO;


/**
 * EES_MNR_0115 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0115HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Ho Min
 * @see EES_MNR_0115HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0115Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RepairExpensePFMCINVO repairExpensePFMCINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RepairExpensePFMCRPTVO[] repairExpensePFMCRPTVOs = null;

	public EesMnr0115Event(){}
	
	public void setRepairExpensePFMCINVO(RepairExpensePFMCINVO repairExpensePFMCINVO){
		this. repairExpensePFMCINVO = repairExpensePFMCINVO;
	}

	public void setRepairExpensePFMCRPTVOS(RepairExpensePFMCRPTVO[] repairExpensePFMCRPTVOs){
		this. repairExpensePFMCRPTVOs = repairExpensePFMCRPTVOs;
	}

	public RepairExpensePFMCINVO getRepairExpensePFMCINVO(){
		return repairExpensePFMCINVO;
	}

	public RepairExpensePFMCRPTVO[] getRepairExpensePFMCRPTVOS(){
		return repairExpensePFMCRPTVOs;
	}

}