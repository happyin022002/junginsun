/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesMnrS027Event.java
*@FileTitle : Repair Cancellation and Deletion
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.20 
*@LastModifier : 박명신  
*@LastVersion : 1.0
* 2009.06.09 박명신 	
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event;
	
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.RepairCollectionGRPVO;
import com.clt.framework.support.layer.event.EventSupport;
 
/**
 * ees_mnr_0027 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ees_mnr_0027HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 박명신	
 * @see ees_mnr_S027HTMLAction 참조
 * @since J2EE 1.6		
 */    
		
public class EesMnrS027Event extends EventSupport {
	private static final long serialVersionUID = 1L; 
	
	public EesMnrS027Event(){}   
	
	private RepairCollectionGRPVO repairCollectionGRPVO = null;

	public RepairCollectionGRPVO getRepairCollectionGRPVO() {
		return repairCollectionGRPVO;
	}

	public void setRepairCollectionGRPVO(RepairCollectionGRPVO repairCollectionGRPVO) {
		this.repairCollectionGRPVO = repairCollectionGRPVO;
	} 
	
	
}