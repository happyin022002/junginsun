/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepairCollectionGRPVO
*@FileTitle : Repair Cancellation and Deletion
*Open Issues : 
*Change history :
*@LastModifyDate : 2009. 7. 7
*@LastModifier : 
*@LastVersion : 1.0	
*2009. 7. 7. 박명신 
** 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo;

import java.util.List;	

/**
 * RepairCollectionGRPVO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *  
 * @author 박명신
 * @since J2EE 1.5 
 * @see ..
 */ 
public class RepairCollectionGRPVO {  
	//SPP ALPS를 구분하기 위한  
	private String currSystem = "ALP";
	//조회 결과를 받기 위한 	  	 	 
	private List<CustomRepairCollectionVO> customRepairCollectionVOS = null;
	//조회 조건을 받기 위한 
	private RepairCollectionINVO repairCollectionINVO = null;
		
	private CustomRepairCollectionVO[] arrCustomRepairCollectionVOS = null;
	
	public String getCurrSystem() {
		return currSystem;
	}
	public void setCurrSystem(String currSystem) {
		this.currSystem = currSystem;
	}
	public CustomRepairCollectionVO[] getArrCustomRepairCollectionVOS() {
		return arrCustomRepairCollectionVOS;
	}
	public void setArrCustomRepairCollectionVOS(
			CustomRepairCollectionVO[] arrCustomRepairCollectionVOS) {
		this.arrCustomRepairCollectionVOS = arrCustomRepairCollectionVOS;
	}
	public List<CustomRepairCollectionVO> getCustomRepairCollectionVOS() {
		return customRepairCollectionVOS;
	}
	public void setCustomRepairCollectionVOS(
			List<CustomRepairCollectionVO> customRepairCollectionVOS) {
		this.customRepairCollectionVOS = customRepairCollectionVOS;
	}
	public RepairCollectionINVO getRepairCollectionINVO() {
		return repairCollectionINVO;
	}
	public void setRepairCollectionINVO(RepairCollectionINVO repairCollectionINVO) {
		this.repairCollectionINVO = repairCollectionINVO;
	}
		
}
