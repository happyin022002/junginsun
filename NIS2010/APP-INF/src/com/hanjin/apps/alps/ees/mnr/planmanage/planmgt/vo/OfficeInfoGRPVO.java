/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeSearchGRPVO
*@FileTitle : 
*Open Issues :	
*Change history :
*@LastModifyDate : 2009. 5. 12.
*@LastModifier : 
*@LastVersion : 1.0
*2009. 5. 12. 정영훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo;

import java.util.List;

/**
 * DamageLocationCodeList GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 * 
 * @author 정영훈 
 * @since J2EE 1.5 
 * @see	  ..   
 */
 
public class OfficeInfoGRPVO {
	private OfficeCodeINVO officeCodeINVO = null;
	private List<OfficeInfoListVO> officeInfoListVOS = null;
	public OfficeCodeINVO getOfficeCodeINVO() {
		return officeCodeINVO;
	}
	public void setOfficeCodeINVO(OfficeCodeINVO officeCodeINVO) {
		this.officeCodeINVO = officeCodeINVO;
	}
	public List<OfficeInfoListVO> getOfficeInfoListVOS() {
		return officeInfoListVOS;
	}
	public void setOfficeInfoListVOS(List<OfficeInfoListVO> officeInfoListVOS) {
		this.officeInfoListVOS = officeInfoListVOS;
	} 
}
