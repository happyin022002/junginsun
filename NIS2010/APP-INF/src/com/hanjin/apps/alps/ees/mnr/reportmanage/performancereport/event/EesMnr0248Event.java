/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EesMnr0121Event.java
*@FileTitle : M&R PFMC by Estimate
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.10
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2011.02.10 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.event;

import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByEqNoINVO;
import com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByEqNoVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_MNR_0248 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0248HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Yung Oh Kim
 * @see EES_MNR_0248HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0248Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RepairPFMCByEqNoINVO repairPFMCByEqNoINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RepairPFMCByEqNoVO[] repairPFMCByESTVOs = null;

	public EesMnr0248Event(){}

	public RepairPFMCByEqNoINVO getRepairPFMCByEqNoINVO() {
		return repairPFMCByEqNoINVO;
	}

	public void setRepairPFMCByEqNoINVO(RepairPFMCByEqNoINVO repairPFMCByEqNoINVO) {
		this.repairPFMCByEqNoINVO = repairPFMCByEqNoINVO;
	}

	public RepairPFMCByEqNoVO[] getRepairPFMCByESTVOs() {
		return repairPFMCByESTVOs;
	}

	public void setRepairPFMCByESTVOs(RepairPFMCByEqNoVO[] repairPFMCByESTVOs) {
		this.repairPFMCByESTVOs = repairPFMCByESTVOs;
	}
	
	
}