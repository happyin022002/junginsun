/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepairCodeFindListGRPVO.java
*@FileTitle : Pop Up_Tariff Code Finding
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.06.11 정영훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo;

import java.util.List;

/**
 * @author zero
 *
 */
public class RepairCodeFindListGRPVO {
	
	
	private CustomMnrEqCmpoCdVO customMnrEqCmpoCdVO ;
	private RepairCodeFindListINVO repairCodeFindListINVO;
	private List<CustomTariffCodeFindDataVO>  customTariffCodeFindDataVOS;
	
	public RepairCodeFindListGRPVO(){
		//constructor
	}

	public CustomMnrEqCmpoCdVO getCustomMnrEqCmpoCdVO() {
		return customMnrEqCmpoCdVO;
	}

	public void setCustomMnrEqCmpoCdVO(CustomMnrEqCmpoCdVO customMnrEqCmpoCdVO) {
		this.customMnrEqCmpoCdVO = customMnrEqCmpoCdVO;
	}

	public RepairCodeFindListINVO getRepairCodeFindListINVO() {
		return repairCodeFindListINVO;
	}

	public void setRepairCodeFindListINVO(
			RepairCodeFindListINVO repairCodeFindListINVO) {
		this.repairCodeFindListINVO = repairCodeFindListINVO;
	}

	public List<CustomTariffCodeFindDataVO> getCustomMnrEqCmpoCdVOS() {
		return customTariffCodeFindDataVOS;
	}

	public void setCustomMnrEqCmpoCdVOS(
			List<CustomTariffCodeFindDataVO> customMnrEqCmpoCdVOS) {
		this.customTariffCodeFindDataVOS = customMnrEqCmpoCdVOS;
	}

	

	
	

}
