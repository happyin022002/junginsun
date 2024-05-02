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

public class OfficeGeneralInfoListGRPVO {

	private static final long serialVersionUID = 1L;
	
	
	private OfficeGeneralInfoMgtINVO officeGeneralInfoMgtINVO ;
	
	private List<CustomMnrOfcGenInfoVO> customMnrOfcGenInfoVOS;
	
	private CustomMnrOfcGenInfoVO[] arrCustomMnrOfcGenInfoVO;
	
	public OfficeGeneralInfoListGRPVO(){
		
	}

	public OfficeGeneralInfoMgtINVO getOfficeGeneralInfoMgtINVO() {
		return officeGeneralInfoMgtINVO;
	}

	public void setOfficeGeneralInfoMgtINVO(
			OfficeGeneralInfoMgtINVO officeGeneralInfoMgtINVO) {
		this.officeGeneralInfoMgtINVO = officeGeneralInfoMgtINVO;
	}

	public List<CustomMnrOfcGenInfoVO> getCustomMnrOfcGenInfoVOS() {
		return customMnrOfcGenInfoVOS;
	}

	public void setCustomMnrOfcGenInfoVOS(
			List<CustomMnrOfcGenInfoVO> customMnrOfcGenInfoVOS) {
		this.customMnrOfcGenInfoVOS = customMnrOfcGenInfoVOS;
	}

	public CustomMnrOfcGenInfoVO[] getArrCustomMnrOfcGenInfoVO() {
		return arrCustomMnrOfcGenInfoVO;
	}

	public void setArrCustomMnrOfcGenInfoVO(
			CustomMnrOfcGenInfoVO[] arrCustomMnrOfcGenInfoVO) {
		this.arrCustomMnrOfcGenInfoVO = arrCustomMnrOfcGenInfoVO;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
}
