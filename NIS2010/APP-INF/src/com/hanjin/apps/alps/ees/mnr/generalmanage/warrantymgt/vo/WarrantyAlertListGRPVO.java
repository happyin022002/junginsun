/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WarrantyAlertListGRPVO
*@FileTitle : 
*Open Issues : 
*Change history :
*@LastModifyDate : 2009. 6. 3
*@LastModifier : 
*@LastVersion : 1.0
*2009. 6. 3. 박명신 
** 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.vo;

import java.util.List;
 
/**
 * WarrantyAlertListGRPVO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *
 * @author 박명신
 * @since J2EE 1.5 
 * @see
 */
public class WarrantyAlertListGRPVO {
	//저장 조건을 받기 위한 
	private CustomWarrantyAlertListVO[] arrCustomWarrantyAlertListVOS = null;
	//조회 결과를 받기 위한  
	private List<CustomWarrantyAlertListVO> customWarrantyAlertListVOS = null;
	//조회조건을 받기위한
	private WarrantyAlertListINVO warrantyAlertListINVO= null;
    	   
	public CustomWarrantyAlertListVO[] getArrCustomWarrantyAlertListVOS() {
		return arrCustomWarrantyAlertListVOS;
	}
	public void setArrCustomWarrantyAlertListVOS(
			CustomWarrantyAlertListVO[] arrCustomWarrantyAlertListVOS) {
		this.arrCustomWarrantyAlertListVOS = arrCustomWarrantyAlertListVOS;
	}
	public List<CustomWarrantyAlertListVO> getCustomWarrantyAlertListVOS() {
		return customWarrantyAlertListVOS;
	}
	public void setCustomWarrantyAlertListVOS(
			List<CustomWarrantyAlertListVO> customWarrantyAlertListVOS) {
		this.customWarrantyAlertListVOS = customWarrantyAlertListVOS;
	}
	public WarrantyAlertListINVO getWarrantyAlertListINVO() {
		return warrantyAlertListINVO;
	}
	public void setWarrantyAlertListINVO(WarrantyAlertListINVO warrantyAlertListINVO) {
		this.warrantyAlertListINVO = warrantyAlertListINVO;
	}
	
	
}
