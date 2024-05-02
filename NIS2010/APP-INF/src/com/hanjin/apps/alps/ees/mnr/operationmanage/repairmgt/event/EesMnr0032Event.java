/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnr0032Event.java
*@FileTitle : M&R Repair Result creatioln by W/O
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.24
*@LastModifier : 권영법 
*@LastVersion : 1.0
* 2009.08.24 권영법
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event;

import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.RepairResultGRPVO;
import com.hanjin.framework.support.layer.event.EventSupport;
         
/** 
 * ESS_MNR_0032 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_MNR_0032HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 권영법 
 * @see EES_MNR_0058HTMLAction 참조
 * @since J2EE 1.4 
 */

public class EesMnr0032Event extends EventSupport {
    
	private static final long serialVersionUID = 1L;
	private RepairResultGRPVO  repairResultGRPVO = null;
	
	public EesMnr0032Event(){}

	public RepairResultGRPVO getRepairResultGRPVO() {
		return repairResultGRPVO;
	}

	public void setRepairResultGRPVO(RepairResultGRPVO repairResultGRPVO) {
		this.repairResultGRPVO = repairResultGRPVO;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
    
	
}