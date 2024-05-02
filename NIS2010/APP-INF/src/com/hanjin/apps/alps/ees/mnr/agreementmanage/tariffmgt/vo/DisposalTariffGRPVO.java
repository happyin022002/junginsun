/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DisposalTariffGRPVO.java
*@FileTitle : DisposalTariffGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 권영법
*@LastVersion : 1.0
* 2009.06.10 권영법 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo;

import java.util.List;

/**
 * DisposalTariff GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *
 * @author 김완규
 * @since J2EE 1.5
 * @see
 */
public class DisposalTariffGRPVO {
	//조회조건을 받기위한
	private DisposalTariffINVO disposalTariffINVO = null;
	//단건조회 결과를 받기위한
	private List<CustomMnrDispTrfHdrVO> customMnrDispTrfHdrVOs = null;
	private List<CustomMnrDispTrfDtlVO> customMnrDispTrfDtlVOs = null;
	//다중조회 결과를 받기위한
	private List<List<CustomMnrDispTrfDtlVO>> listCustomMnrDispTrfDtlVOs = null;
	//CUD처리를 위한 
	private CustomMnrDispTrfHdrVO customMnrDispTrfHdrVO = null;
	private CustomMnrDispTrfDtlVO[] arrayCustomMnrDispTrfDtlVOs = null;
	//InQuery 조회를 위한 	
	private List<CustomMnrDispTrfInQueryVO> customMnrDispTrfInQueryVOs = null;
			
	public List<CustomMnrDispTrfInQueryVO> getCustomMnrDispTrfInQueryVOs() {
		return customMnrDispTrfInQueryVOs;
	}
	public void setCustomMnrDispTrfInQueryVOs(List<CustomMnrDispTrfInQueryVO> customMnrDispTrfInQueryVOs) {
		this.customMnrDispTrfInQueryVOs = customMnrDispTrfInQueryVOs;
	}
	public DisposalTariffINVO getDisposalTariffINVO() {
		return disposalTariffINVO;
	}
	public void setDisposalTariffINVO(DisposalTariffINVO disposalTariffINVO) {
		this.disposalTariffINVO = disposalTariffINVO;
	}
	public List<CustomMnrDispTrfHdrVO> getCustomMnrDispTrfHdrVOs() {
		return customMnrDispTrfHdrVOs;
	}
	public void setCustomMnrDispTrfHdrVOs(
			List<CustomMnrDispTrfHdrVO> customMnrDispTrfHdrVOs) {
		this.customMnrDispTrfHdrVOs = customMnrDispTrfHdrVOs;
	}
	public List<CustomMnrDispTrfDtlVO> getCustomMnrDispTrfDtlVOs() {
		return customMnrDispTrfDtlVOs;
	}
	public void setCustomMnrDispTrfDtlVOs(
			List<CustomMnrDispTrfDtlVO> customMnrDispTrfDtlVOs) {
		this.customMnrDispTrfDtlVOs = customMnrDispTrfDtlVOs;
	}	
	
	public List<List<CustomMnrDispTrfDtlVO>> getListCustomMnrDispTrfDtlVOs() {
		return listCustomMnrDispTrfDtlVOs;
	}
	public void setListCustomMnrDispTrfDtlVOs(
			List<List<CustomMnrDispTrfDtlVO>> listCustomMnrDispTrfDtlVOs) {
		this.listCustomMnrDispTrfDtlVOs = listCustomMnrDispTrfDtlVOs;
	}
	public CustomMnrDispTrfHdrVO getCustomMnrDispTrfHdrVO() {
		return customMnrDispTrfHdrVO;
	}
	public void setCustomMnrDispTrfHdrVO(CustomMnrDispTrfHdrVO customMnrDispTrfHdrVO) {
		this.customMnrDispTrfHdrVO = customMnrDispTrfHdrVO;
	}
	public CustomMnrDispTrfDtlVO[] getArrayCustomMnrDispTrfDtlVOs() {
		return arrayCustomMnrDispTrfDtlVOs;
	}
	public void setArrayCustomMnrDispTrfDtlVOs(
			CustomMnrDispTrfDtlVO[] arrayCustomMnrDispTrfDtlVOs) {
		this.arrayCustomMnrDispTrfDtlVOs = arrayCustomMnrDispTrfDtlVOs;
	}
	
}
