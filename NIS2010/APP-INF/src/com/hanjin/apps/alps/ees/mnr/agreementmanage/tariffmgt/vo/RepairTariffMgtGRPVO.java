/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepairTariffMgtGRPVO.java
*@FileTitle : RepairTariffMgtGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.06.10 김완규 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo;

import java.util.List;

/**
 * RepairTariffMgt GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *
 * @author 김완규
 * @since J2EE 1.5
 * @see
 */
public class RepairTariffMgtGRPVO {
	//조회조건을 받기위한
	private RepairTariffMgtINVO repairTariffMgtINVO = null;
	//단건조회 결과를 받기위한
	private List<CustomMnrRprTrfHdrVO> customMnrRprTrfHdrVOs = null;
	//다중조회 결과를 받기위한
	private List<List<CustomMnrRprTrfDtlVO>> listCustomMnrRprTrfDtlVOs = null;
	//CUD처리를 위한 
	private CustomMnrRprTrfHdrVO customMnrRprTrfHdrVO = null;
	private CustomMnrRprTrfDtlVO[] arrayCustomMnrRprTrfDtlVOs = null;
	
	public RepairTariffMgtINVO getRepairTariffMgtINVO() {
		return repairTariffMgtINVO;
	}
	public void setRepairTariffMgtINVO(RepairTariffMgtINVO repairTariffMgtINVO) {
		this.repairTariffMgtINVO = repairTariffMgtINVO;
	}
	public List<CustomMnrRprTrfHdrVO> getCustomMnrRprTrfHdrVOs() {
		return customMnrRprTrfHdrVOs;
	}
	public void setCustomMnrRprTrfHdrVOs(
			List<CustomMnrRprTrfHdrVO> customMnrRprTrfHdrVOs) {
		this.customMnrRprTrfHdrVOs = customMnrRprTrfHdrVOs;
	}
	public List<List<CustomMnrRprTrfDtlVO>> getListCustomMnrRprTrfDtlVOs() {
		return listCustomMnrRprTrfDtlVOs;
	}
	public void setListCustomMnrRprTrfDtlVOs(
			List<List<CustomMnrRprTrfDtlVO>> listCustomMnrRprTrfDtlVOs) {
		this.listCustomMnrRprTrfDtlVOs = listCustomMnrRprTrfDtlVOs;
	}
	public CustomMnrRprTrfHdrVO getCustomMnrRprTrfHdrVO() {
		return customMnrRprTrfHdrVO;
	}
	public void setCustomMnrRprTrfHdrVO(CustomMnrRprTrfHdrVO customMnrRprTrfHdrVO) {
		this.customMnrRprTrfHdrVO = customMnrRprTrfHdrVO;
	}
	public CustomMnrRprTrfDtlVO[] getArrayCustomMnrRprTrfDtlVOs() {
		return arrayCustomMnrRprTrfDtlVOs;
	}
	public void setArrayCustomMnrRprTrfDtlVOs(
			CustomMnrRprTrfDtlVO[] arrayCustomMnrRprTrfDtlVOs) {
		this.arrayCustomMnrRprTrfDtlVOs = arrayCustomMnrRprTrfDtlVOs;
	}
	
}
