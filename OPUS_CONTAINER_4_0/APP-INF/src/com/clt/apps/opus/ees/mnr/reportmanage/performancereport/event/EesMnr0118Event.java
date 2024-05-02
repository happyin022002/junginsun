/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0118Event.java
*@FileTitle : MNR PFMC by Type/Size
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.10.12 민정호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event;

import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByTSINVO;
import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByTSVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_MNR_0118 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0118HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Ho Min
 * @see EES_MNR_0118HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0118Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RepairPFMCByTSINVO repairPFMCByTSINVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private RepairPFMCByTSVO[] repairPFMCByTSVOs = null;

	public EesMnr0118Event(){}
	
	public void setRepairPFMCByTSINVO(RepairPFMCByTSINVO repairPFMCByTSINVO){
		this. repairPFMCByTSINVO = repairPFMCByTSINVO;
	}

	public void setRepairPFMCByTSVOS(RepairPFMCByTSVO[] repairPFMCByTSVOs){
		if(repairPFMCByTSVOs != null){
			RepairPFMCByTSVO[] tmpVOs = java.util.Arrays.copyOf(repairPFMCByTSVOs, repairPFMCByTSVOs.length);
			this.repairPFMCByTSVOs = tmpVOs;
		}
	}

	public RepairPFMCByTSINVO getRepairPFMCByTSINVO(){
		return repairPFMCByTSINVO;
	}

	public RepairPFMCByTSVO[] getRepairPFMCByTSVOS(){
		RepairPFMCByTSVO[] rtnVOs = null;
		if (this.repairPFMCByTSVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(repairPFMCByTSVOs, repairPFMCByTSVOs.length);
		}
		return rtnVOs;
	}

}