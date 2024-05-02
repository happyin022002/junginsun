/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WarrantyAlertInfoGRPVO
*@FileTitle : 
*Open Issues : 
*Change history :
*@LastModifyDate : 2009. 6. 3
*@LastModifier : 
*@LastVersion : 1.0
*2009. 6. 3. 박명신 
** 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.warrantymgt.vo;

import java.util.List;
 
/**
 * WarrantyAlertInfoGRPVO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *
 * @author 박명신
 * @since J2EE 1.5 
 * @see
 */
public class WarrantyAlertInfoGRPVO {
	//조회 결과를 받기 위한  
	private List<CustomMnrEqRngStsVO> customMnrEqRngStsVOS = null;
	//조회조건을 받기위한
	private WarrantyAlertInfoINVO warrantyAlertInfoINVO= null;
	
	public List<CustomMnrEqRngStsVO> getCustomMnrEqRngStsVOS() {
		return customMnrEqRngStsVOS;
	}
	public void setCustomMnrEqRngStsVOS(
			List<CustomMnrEqRngStsVO> customMnrEqRngStsVOS) {
		this.customMnrEqRngStsVOS = customMnrEqRngStsVOS;
	}
	public WarrantyAlertInfoINVO getWarrantyAlertInfoINVO() {
		return warrantyAlertInfoINVO;
	}
	public void setWarrantyAlertInfoINVO(WarrantyAlertInfoINVO warrantyAlertInfoINVO) {
		this.warrantyAlertInfoINVO = warrantyAlertInfoINVO;
	}
}
