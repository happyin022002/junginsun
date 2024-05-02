/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0238Event.java
*@FileTitle : MNR PFMC by Work Order
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.28
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2010.01.28 권영법
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event;

import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByWOINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByWOVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_MNR_0238 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0238HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Ho Min
 * @see EES_MNR_0238HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0238Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RepairPFMCByWOINVO repairPFMCByWOINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RepairPFMCByWOVO[] repairPFMCByWOVOs = null;

	public EesMnr0238Event(){}
	
	public void setRepairPFMCByWOINVO(RepairPFMCByWOINVO RepairPFMCByWOINVO){
		this. repairPFMCByWOINVO = RepairPFMCByWOINVO;
	}

	public void setRepairPFMCByWOVOS(RepairPFMCByWOVO[] RepairPFMCByWOVOs){
		if(RepairPFMCByWOVOs != null){
			RepairPFMCByWOVO[] tmpVOs = java.util.Arrays.copyOf(RepairPFMCByWOVOs, RepairPFMCByWOVOs.length);
			this.repairPFMCByWOVOs = tmpVOs;
		}
	}

	public RepairPFMCByWOINVO getRepairPFMCByWOINVO(){
		return repairPFMCByWOINVO;
	}

	public RepairPFMCByWOVO[] getRepairPFMCByWOVOS(){
		RepairPFMCByWOVO[] rtnVOs = null;
		if (this.repairPFMCByWOVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(repairPFMCByWOVOs, repairPFMCByWOVOs.length);
		}
		return rtnVOs;
	}

}