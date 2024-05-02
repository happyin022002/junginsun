/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EstimateGRPVO
*@FileTitle : Repair Estimate Creation
*Open Issues : 
*Change history :
*@LastModifyDate : 2009. 7. 7
*@LastModifier : 
*@LastVersion : 1.0
*2009. 7. 7. 박명신 
** 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo;

import java.util.List;

import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo.CustomMnrDatVrfyVO;
  
/**
 * EstimateGRPVO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *  
 * @author 박명신
 * @since J2EE 1.5 
 * @see ..
 */  
public class EstimateGRPVO { 
	//SPP ALPS를 구분하기 위한 
	private String currSystem = "ALP";

	//조회 결과를 받기 위한   	  
	private List<CustomMnrRprRqstDtlVO> customMnrRprRqstDtlVOS = null;
	//조회 결과를 받기 위한   	
	private List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = null; 
	//조회 조건을 받기 위한 
	private EstimateINVO estimateINVO = null;
	//verify를 위한 	
	private CustomMnrDatVrfyVO[] customMnrDatVrfyVOS = null;
	//verify and verify Save을 위한  	 	 
	private CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = null; 
	//verify 결과를 조회하기위한      	
	private List<CustomMnrDatVrfyVO> listCustomMnrDatVrfyVOS = null;	  
	//Estimate Save을 위한    	   
	private CustomMnrRprRqstDtlVO[] arrCustomMnrRprRqstDtlVOS = null;
	
	//그룹 오디팅용 		
	private CustomMnrRprRqstHdrVO[] arrCustomMnrRprRqstHdrVOS = null;
	//액션 구분자 	
	private String groupAuditAction = ""; 
	//Current Damage Flag 를 조회하기 위한 
	private String currDmgFlg = ""; 
	
	//EDI 구분 플레그 
	private String isEDI = "N";	 
	
	
		
	public String getCurrSystem() {
		return currSystem;
	}

	public void setCurrSystem(String currSystem) {
		this.currSystem = currSystem;
	}

	public String getIsEDI() {		
		return isEDI;
	}
	
	public void setIsEDI(String isEDI) {
		this.isEDI = isEDI;
	}
	
	public String getCurrDmgFlg() {
		return currDmgFlg;
	}
	public void setCurrDmgFlg(String currDmgFlg) {
		this.currDmgFlg = currDmgFlg;
	}
	public String getGroupAuditAction() {
		return groupAuditAction;
	}
	public void setGroupAuditAction(String groupAuditAction) {
		this.groupAuditAction = groupAuditAction;
	}
	public CustomMnrRprRqstHdrVO[] getArrCustomMnrRprRqstHdrVOS() {
		return arrCustomMnrRprRqstHdrVOS;
	}
	public void setArrCustomMnrRprRqstHdrVOS(
			CustomMnrRprRqstHdrVO[] arrCustomMnrRprRqstHdrVOS) {
		this.arrCustomMnrRprRqstHdrVOS = arrCustomMnrRprRqstHdrVOS;
	}
	public CustomMnrRprRqstDtlVO[] getArrCustomMnrRprRqstDtlVOS() {
		return arrCustomMnrRprRqstDtlVOS;
	}
	public void setArrCustomMnrRprRqstDtlVOS(
			CustomMnrRprRqstDtlVO[] arrCustomMnrRprRqstDtlVOS) {
		this.arrCustomMnrRprRqstDtlVOS = arrCustomMnrRprRqstDtlVOS;
	}
	public List<CustomMnrDatVrfyVO> getListCustomMnrDatVrfyVOS() {
		return listCustomMnrDatVrfyVOS;
	}
	public void setListCustomMnrDatVrfyVOS(
			List<CustomMnrDatVrfyVO> listCustomMnrDatVrfyVOS) {
		this.listCustomMnrDatVrfyVOS = listCustomMnrDatVrfyVOS;
	}
	public CustomMnrRprRqstHdrVO getCustomMnrRprRqstHdrVO() {
		return customMnrRprRqstHdrVO;  
	}
	public void setCustomMnrRprRqstHdrVO(CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO) {
		this.customMnrRprRqstHdrVO = customMnrRprRqstHdrVO;
	}
	public CustomMnrDatVrfyVO[] getCustomMnrDatVrfyVOS() {
		return customMnrDatVrfyVOS;
	}
	public void setCustomMnrDatVrfyVOS(CustomMnrDatVrfyVO[] customMnrDatVrfyVOS) {
		this.customMnrDatVrfyVOS = customMnrDatVrfyVOS;
	}
	public List<CustomMnrRprRqstDtlVO> getCustomMnrRprRqstDtlVOS() {
		return customMnrRprRqstDtlVOS; 
	}
	public void setCustomMnrRprRqstDtlVOS(
			List<CustomMnrRprRqstDtlVO> customMnrRprRqstDtlVOS) {
		this.customMnrRprRqstDtlVOS = customMnrRprRqstDtlVOS;
	}
	public List<CustomMnrRprRqstHdrVO> getCustomMnrRprRqstHdrVOS() {
		return customMnrRprRqstHdrVOS;
	}
	public void setCustomMnrRprRqstHdrVOS(
			List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS) {
		this.customMnrRprRqstHdrVOS = customMnrRprRqstHdrVOS;
	}
	public EstimateINVO getEstimateINVO() {
		return estimateINVO;
	}
	public void setEstimateINVO(EstimateINVO estimateINVO) {
		this.estimateINVO = estimateINVO;
	}
}
