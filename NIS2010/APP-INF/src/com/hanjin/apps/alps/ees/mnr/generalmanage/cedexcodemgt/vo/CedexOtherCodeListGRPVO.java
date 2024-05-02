/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CedexOtherCodeListGRPVO
*@FileTitle : 
*Open Issues :	
*Change history :
*@LastModifyDate : 2009. 5. 11.
*@LastModifier : 
*@LastVersion : 1.0
*2009. 5. 11. 박명신
* 1.0 Creation
=========================================================*/
   
package com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo;
 
import java.util.List;
 
/**
 * CedexOtherCodeListGRPVO GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 * 
 * @author 박명신 
 * @since J2EE 1.5 
 * @see   
 */

public class CedexOtherCodeListGRPVO {    
	//조회조건을 받기위한          
	private CedexOtherCodeListINVO cedexOtherCodeListINVO= null;  
	//CUD 처리를 위한       
	private CustomMnrCedexOtrCdVO[] arrCustomMnrCedexOtrCdVOS = null;
	//조회 결과를 받기 위한 
	private List<CustomMnrCedexOtrCdVO> customMnrCedexOtrCdVOS = null;
	
	public CedexOtherCodeListINVO getCedexOtherCodeListINVO() {
		return cedexOtherCodeListINVO;
	}
	public void setCedexOtherCodeListINVO(
			CedexOtherCodeListINVO cedexOtherCodeListINVO) {
		this.cedexOtherCodeListINVO = cedexOtherCodeListINVO;
	}
	public CustomMnrCedexOtrCdVO[] getArrCustomMnrCedexOtrCdVOS() {
		return arrCustomMnrCedexOtrCdVOS;
	}
	public void setArrCustomMnrCedexOtrCdVOS(
			CustomMnrCedexOtrCdVO[] arrCustomMnrCedexOtrCdVOS) {
		this.arrCustomMnrCedexOtrCdVOS = arrCustomMnrCedexOtrCdVOS;
	}
	public List<CustomMnrCedexOtrCdVO> getCustomMnrCedexOtrCdVOS() {
		return customMnrCedexOtrCdVOS;
	}
	public void setCustomMnrCedexOtrCdVOS(
			List<CustomMnrCedexOtrCdVO> customMnrCedexOtrCdVOS) {
		this.customMnrCedexOtrCdVOS = customMnrCedexOtrCdVOS;
	}  
}
