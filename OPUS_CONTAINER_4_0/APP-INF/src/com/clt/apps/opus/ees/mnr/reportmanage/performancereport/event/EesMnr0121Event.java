/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0121Event.java
*@FileTitle : MNR PFMC by Estimation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.08
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.10.08 민정호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event;

import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByESTINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByESTVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_MNR_0121 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0121HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Ho Min
 * @see EES_MNR_0121HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0121Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RepairPFMCByESTINVO repairPFMCByESTINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RepairPFMCByESTVO[] repairPFMCByESTVOs = null;

	public EesMnr0121Event(){}
	
	public void setRepairPFMCByESTINVO(RepairPFMCByESTINVO repairPFMCByESTINVO){
		this. repairPFMCByESTINVO = repairPFMCByESTINVO;
	}

	public void setRepairPFMCByESTVOS(RepairPFMCByESTVO[] repairPFMCByESTVOs){
		if(repairPFMCByESTVOs != null){
			RepairPFMCByESTVO[] tmpVOs = java.util.Arrays.copyOf(repairPFMCByESTVOs, repairPFMCByESTVOs.length);
			this.repairPFMCByESTVOs = tmpVOs;
		}
	}

	public RepairPFMCByESTINVO getRepairPFMCByESTINVO(){
		return repairPFMCByESTINVO;
	}

	public RepairPFMCByESTVO[] getRepairPFMCByESTVOS(){
		RepairPFMCByESTVO[] rtnVOs = null;
		if (this.repairPFMCByESTVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(repairPFMCByESTVOs, repairPFMCByESTVOs.length);
		}
		return rtnVOs;
	}

}