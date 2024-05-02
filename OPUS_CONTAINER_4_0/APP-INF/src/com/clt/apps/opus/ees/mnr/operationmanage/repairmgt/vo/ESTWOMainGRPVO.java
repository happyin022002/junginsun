/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESTWOMainGRPVO
*@FileTitle : W/O Creation
*Open Issues : 
*Change history :
*@LastModifyDate : 2009. 8. 3
*@LastModifier : 
*@LastVersion : 1.0
*2009. 8. 3. 김완규 
** 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo;

import java.util.List;
/**
 * ESTWOMainGRPVO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *  
 * @author 김완규
 * @since J2EE 1.5 
 * @see ..
 */ 
public class ESTWOMainGRPVO {
	//조회 조건을 받기 위한 
	private ESTWOMainINVO eSTWOMainINVO = null;
	//조회 결과를 받기 위한   	  
	private List<CustomESTWOMainSMRVO> customESTWOMainSMRVO = null;
	//조회 결과를 받기 위한   	
	private List<CustomESTWOMainINFOVO> customESTWOMainINFOVO = null;
	//CRUD처리를 위한
	private CustomESTWOMainINFOVO[] arrayCustomESTWOMainINFOVOs = null;
	//WO No를 받기 위한
	private String woNos = null;
	public ESTWOMainINVO getESTWOMainINVO() {
		return eSTWOMainINVO;
	}
	public void setESTWOMainINVO(ESTWOMainINVO mainINVO) {
		eSTWOMainINVO = mainINVO;
	}
	public List<CustomESTWOMainSMRVO> getCustomESTWOMainSMRVO() {
		return customESTWOMainSMRVO;
	}
	public void setCustomESTWOMainSMRVO(
			List<CustomESTWOMainSMRVO> customESTWOMainSMRVO) {
		this.customESTWOMainSMRVO = customESTWOMainSMRVO;
	}
	public List<CustomESTWOMainINFOVO> getCustomESTWOMainINFOVO() {
		return customESTWOMainINFOVO;
	}
	public void setCustomESTWOMainINFOVO(
			List<CustomESTWOMainINFOVO> customESTWOMainINFOVO) {
		this.customESTWOMainINFOVO = customESTWOMainINFOVO;
	}
	public CustomESTWOMainINFOVO[] getArrayCustomESTWOMainINFOVOs() {
		return arrayCustomESTWOMainINFOVOs;
	}
	public void setArrayCustomESTWOMainINFOVOs(
			CustomESTWOMainINFOVO[] arrayCustomESTWOMainINFOVOs) {
		this.arrayCustomESTWOMainINFOVOs = arrayCustomESTWOMainINFOVOs;
	}
	public String getWoNos() {
		return woNos;
	}
	public void setWoNos(String woNos) {
		this.woNos = woNos;
	}

}
