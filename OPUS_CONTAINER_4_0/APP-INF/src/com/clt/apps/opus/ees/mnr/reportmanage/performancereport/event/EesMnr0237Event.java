/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0237Event.java
*@FileTitle : MNR PFMC by Account/Cost Code
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.10.12 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.reportmanage.performancereport.event;

import com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo.RepairPFMCByACCTINVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * EES_MNR_0237 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0237HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Myoung Sin Park
 * @see EES_MNR_0237HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesMnr0237Event extends EventSupport {
	
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private RepairPFMCByACCTINVO repairPFMCByACCTINVO = null;

	public RepairPFMCByACCTINVO getRepairPFMCByACCTINVO() {
		return repairPFMCByACCTINVO;	
	}
		
	public void setRepairPFMCByACCTINVO(RepairPFMCByACCTINVO repairPFMCByACCTINVO) {
		this.repairPFMCByACCTINVO = repairPFMCByACCTINVO;
	}
		
	
}