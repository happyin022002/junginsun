/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OfficegeneralinfomgtINVO.java
*@FileTitle : OfficegeneralinfomgtINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.05
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.06.05 정영훈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.generalmanage.officegeneralinfomgt.vo;

import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정영훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ColleagueTreeGRPVO {

	private static final long serialVersionUID = 1L;
	
	
	private OfficeGeneralInfoMgtINVO officeGeneralInfoMgtINVO ;
	private CustomMnrOfcCntcPsonVO customMnrOfcCntcPsonVO ;
	private List<CustomMnrOfcCntcPsonVO> customMnrOfcCntcPsonVOS;
	private CustomMnrOfcCntcPsonVO[] arrCustomMnrOfcCntcPsonVO;

	public ColleagueTreeGRPVO(){
		
	}


	public OfficeGeneralInfoMgtINVO getOfficeGeneralInfoMgtINVO() {
		return officeGeneralInfoMgtINVO;
	}


	public void setOfficeGeneralInfoMgtINVO(
			OfficeGeneralInfoMgtINVO officeGeneralInfoMgtINVO) {
		this.officeGeneralInfoMgtINVO = officeGeneralInfoMgtINVO;
	}


	public CustomMnrOfcCntcPsonVO getCustomMnrOfcCntcPsonVO() {
		return customMnrOfcCntcPsonVO;
	}


	public void setCustomMnrOfcCntcPsonVO(
			CustomMnrOfcCntcPsonVO customMnrOfcCntcPsonVO) {
		this.customMnrOfcCntcPsonVO = customMnrOfcCntcPsonVO;
	}


	public List<CustomMnrOfcCntcPsonVO> getCustomMnrOfcCntcPsonVOS() {
		return customMnrOfcCntcPsonVOS;
	}


	public void setCustomMnrOfcCntcPsonVOS(
			List<CustomMnrOfcCntcPsonVO> customMnrOfcCntcPsonVOS) {
		this.customMnrOfcCntcPsonVOS = customMnrOfcCntcPsonVOS;
	}


	public CustomMnrOfcCntcPsonVO[] getArrCustomMnrOfcCntcPsonVO() {
		return arrCustomMnrOfcCntcPsonVO;
	}


	public void setArrCustomMnrOfcCntcPsonVO(
			CustomMnrOfcCntcPsonVO[] arrCustomMnrOfcCntcPsonVO) {
		this.arrCustomMnrOfcCntcPsonVO = arrCustomMnrOfcCntcPsonVO;
	}
	

	
	
}
