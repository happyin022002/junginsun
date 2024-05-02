/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0120Event.java
*@FileTitle : MNR PFMC by VNDR/Manufacturer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.10.12 민정호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event;

import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCBySPINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCBySPVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_MNR_0120 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0120HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Ho Min
 * @see EES_MNR_0120HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0120Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RepairPFMCBySPINVO repairPFMCBySPINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RepairPFMCBySPVO[] repairPFMCBySPVOs = null;

	public EesMnr0120Event(){}
	
	public void setRepairPFMCBySPINVO(RepairPFMCBySPINVO repairPFMCBySPINVO){
		this. repairPFMCBySPINVO = repairPFMCBySPINVO;
	}

	public void setRepairPFMCBySPVOS(RepairPFMCBySPVO[] repairPFMCBySPVOs){
		if(repairPFMCBySPVOs != null){
			RepairPFMCBySPVO[] tmpVOs = java.util.Arrays.copyOf(repairPFMCBySPVOs, repairPFMCBySPVOs.length);
			this.repairPFMCBySPVOs = tmpVOs;
		}
	}

	public RepairPFMCBySPINVO getRepairPFMCBySPINVO(){
		return repairPFMCBySPINVO;
	}

	public RepairPFMCBySPVO[] getRepairPFMCBySPVOS(){
		RepairPFMCBySPVO[] rtnVOs = null;
		if (this.repairPFMCBySPVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(repairPFMCBySPVOs, repairPFMCBySPVOs.length);
		}
		return rtnVOs;
	}

}