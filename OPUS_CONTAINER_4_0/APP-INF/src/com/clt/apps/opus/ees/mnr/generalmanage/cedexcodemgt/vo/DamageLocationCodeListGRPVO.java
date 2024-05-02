/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DamageLocationCodeListGRPVO
*@FileTitle : 
*Open Issues :	
*Change history :
*@LastModifyDate : 2009. 4. 29.
*@LastModifier : 
*@LastVersion : 1.0
*2009. 4. 29. 박명신
* 1.0 Creation
=========================================================*/
   
package com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo;
 
import java.util.List;
 
/**
 * DamageLocationCodeList GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 * 
 * @author 박명신 
 * @since J2EE 1.5 
 * @see   
 */

public class DamageLocationCodeListGRPVO {   
	//콤보조회를 위한 리스트               
	private List<CustomMnrEqLocCdVO> customMnrEqLocCdVOS = null;     
	//조회조건을 받기위한          
	private DamageLocationCodeListINVO damageLocationCodeListINVO= null;  
	//CUD 처리를 위한       
	private CustomMnrEqLocCdVO[] arrCustomMnrEqLocCdVOS = null;
	//다중조회 처리를 위한          
	private List<List<CustomMnrEqLocCdVO>> listCustomMnrEqLocCdVOS = null;
	         
	public List<CustomMnrEqLocCdVO> getCustomMnrEqLocCdVOS() {
		return customMnrEqLocCdVOS;
	}
	public void setCustomMnrEqLocCdVOS(List<CustomMnrEqLocCdVO> customMnrEqLocCdVOS) {
		this.customMnrEqLocCdVOS = customMnrEqLocCdVOS;
	} 
	public DamageLocationCodeListINVO getDamageLocationCodeListINVO() {
		return damageLocationCodeListINVO;
	}
	public void setDamageLocationCodeListINVO(
			DamageLocationCodeListINVO damageLocationCodeListINVO) {
		this.damageLocationCodeListINVO = damageLocationCodeListINVO;
	}
	public CustomMnrEqLocCdVO[] getArrCustomMnrEqLocCdVOS() {
		return arrCustomMnrEqLocCdVOS;
	}
	public void setArrCustomMnrEqLocCdVOS(
			CustomMnrEqLocCdVO[] arrCustomMnrEqLocCdVOS) {
		this.arrCustomMnrEqLocCdVOS = arrCustomMnrEqLocCdVOS;
	}
	public List<List<CustomMnrEqLocCdVO>> getListCustomMnrEqLocCdVOS() {
		return listCustomMnrEqLocCdVOS;
	}
	public void setListCustomMnrEqLocCdVOS(
			List<List<CustomMnrEqLocCdVO>> listCustomMnrEqLocCdVOS) {
		this.listCustomMnrEqLocCdVOS = listCustomMnrEqLocCdVOS;
	}     
	           
}
