/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0119Event.java
*@FileTitle : MNR PFMC by AGMT TRIFF
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2009.10.13 민정호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event;

import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByRepairCodeINVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_MNR_0119 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0119HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jung Ho Min
 * @see EES_MNR_0119HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0119Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RepairPFMCByRepairCodeINVO repairPFMCByRepairCodeINVO = null;
	
	public EesMnr0119Event(){}
	
	public void setRepairPFMCByRepairCodeINVO(RepairPFMCByRepairCodeINVO repairPFMCByRepairCodeINVO){
		this. repairPFMCByRepairCodeINVO = repairPFMCByRepairCodeINVO;
	}

	public RepairPFMCByRepairCodeINVO getRepairPFMCByRepairCodeINVO(){
		return repairPFMCByRepairCodeINVO;
	}
}