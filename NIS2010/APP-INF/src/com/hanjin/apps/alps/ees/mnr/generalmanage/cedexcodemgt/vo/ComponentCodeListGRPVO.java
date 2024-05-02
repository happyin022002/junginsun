/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ComponentCodeListGRPVO
*@FileTitle : 
*Open Issues : 
*Change history :
*@LastModifyDate : 2009. 5. 29.
*@LastModifier : 
*@LastVersion : 1.0
*2009. 5. 29. 김완규 
** 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo;

import java.util.List;
/**
 * ComponentCodeList GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *
 * @author 김완규
 * @since J2EE 1.5
 * @see
 */
public class ComponentCodeListGRPVO {
	//콤보조회를 위한 리스트
	private List<CustomMnrEqCmpoCdVO> customMnrEqCmpoCdVOS = null;
	//조회조건을 받기위한
	private ComponentCodeListINVO componentCodeListINVO= null;
	//CUD처리를 위한 
	private CustomMnrEqCmpoCdVO[] customMnrEqCmpoCdVOs = null;
	//다중조회 처리를 위한
	private List<List<CustomMnrEqCmpoCdVO>> listCustomMnrEqCmpoCdVOS = null;

	public List<CustomMnrEqCmpoCdVO> getCustomMnrEqCmpoCdVOS() {
		return customMnrEqCmpoCdVOS;
	}
	public void setCustomMnrEqCmpoCdVOS(List<CustomMnrEqCmpoCdVO> customMnrEqCmpoCdVOS) {
		this.customMnrEqCmpoCdVOS = customMnrEqCmpoCdVOS;
	} 	
	public ComponentCodeListINVO getComponentCodeListINVO() {
		return componentCodeListINVO;
	}
	
	public void setComponentCodeListINVO(ComponentCodeListINVO componentCodeListINVO) {
		this.componentCodeListINVO = componentCodeListINVO;
	}
	
	public CustomMnrEqCmpoCdVO[] getCustomMnrEqCmpoCdVOs() {
		return customMnrEqCmpoCdVOs;
	}
	
	public void setCustomMnrEqCmpoCdVOs(CustomMnrEqCmpoCdVO[] customMnrEqCmpoCdVOs) {
		this.customMnrEqCmpoCdVOs = customMnrEqCmpoCdVOs;
	} 

	public List<List<CustomMnrEqCmpoCdVO>> getListCustomMnrEqCmpoCdVOS() {
		return listCustomMnrEqCmpoCdVOS;
	}
	public void setListCustomMnrEqCmpoCdVOS(
			List<List<CustomMnrEqCmpoCdVO>> listCustomMnrEqCmpoCdVOS) {
		this.listCustomMnrEqCmpoCdVOS = listCustomMnrEqCmpoCdVOS;
	}     
	

}
