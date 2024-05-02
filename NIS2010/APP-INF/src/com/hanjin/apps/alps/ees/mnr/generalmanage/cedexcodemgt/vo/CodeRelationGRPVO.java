/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CodeRelationGRPVO
 *@FileTitle : 
 *Open Issues : 
 *Change history :
 *@LastModifyDate : 2009. 5. 11.
 *@LastModifier : 
 *@LastVersion : 1.0
 *2009. 5. 11. 김완규
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.cedexcodemgt.vo;

import java.util.List;

/**
 * CodeRelation GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *
 * @author 김완규
 * @since J2EE 1.5
 * @see
 */
public class CodeRelationGRPVO {
	//조회조건을 받기위한
	private CodeRelationINVO codeRelationINVO= null;
	//조회결과를 받기위한
	private List<CustomMnrCdRltByLocVO> listCustomMnrCdRltByLocVO = null;
	private List<CustomMnrCdRltByDmgVO> listCustomMnrCdRltByDmgVO = null;
	private List<CustomMnrCdRltByRprVO> listCustomMnrCdRltByRprVO = null;
	
	//CUD처리를 위한 
	private CustomMnrCdRltByLocVO[] customMnrCdRltByLocVOs = null;
	private CustomMnrCdRltByDmgVO[] customMnrCdRltByDmgVOs = null;
	private CustomMnrCdRltByRprVO[] customMnrCdRltByRprVOs = null;	
		
	//조회조건을 받기위한
	public CodeRelationINVO getCodeRelationINVO() {
		return codeRelationINVO;
	}
	public void setCodeRelationINVO(CodeRelationINVO codeRelationINVO) {
		this.codeRelationINVO = codeRelationINVO;
	}

	//조회결과를 받기위한					
	public List<CustomMnrCdRltByLocVO> getListCustomMnrCdRltByLocVO() {
		return listCustomMnrCdRltByLocVO;
	}
	public void setListCustomMnrCdRltByLocVO(
			List<CustomMnrCdRltByLocVO> listCustomMnrCdRltByLocVO) {
		this.listCustomMnrCdRltByLocVO = listCustomMnrCdRltByLocVO;
	}
	public List<CustomMnrCdRltByDmgVO> getListCustomMnrCdRltByDmgVO() {
		return listCustomMnrCdRltByDmgVO;
	}
	public void setListCustomMnrCdRltByDmgVO(
			List<CustomMnrCdRltByDmgVO> listCustomMnrCdRltByDmgVO) {
		this.listCustomMnrCdRltByDmgVO = listCustomMnrCdRltByDmgVO;
	}
	public List<CustomMnrCdRltByRprVO> getListCustomMnrCdRltByRprVO() {
		return listCustomMnrCdRltByRprVO;
	}
	public void setListCustomMnrCdRltByRprVO(
			List<CustomMnrCdRltByRprVO> listCustomMnrCdRltByRprVO) {
		this.listCustomMnrCdRltByRprVO = listCustomMnrCdRltByRprVO;
	}
	
	//CUD처리를 위한 
	public CustomMnrCdRltByLocVO[] getCustomMnrCdRltByLocVOS() {
		return customMnrCdRltByLocVOs;
	}
	public void setCustomMnrCdRltByLocVOS(
			CustomMnrCdRltByLocVO[] customMnrCdRltByLocVOs) {
		this.customMnrCdRltByLocVOs = customMnrCdRltByLocVOs;
	}
	public CustomMnrCdRltByDmgVO[] getCustomMnrCdRltByDmgVOS() {
		return customMnrCdRltByDmgVOs;
	}
	public void setCustomMnrCdRltByDmgVO(
			CustomMnrCdRltByDmgVO[] customMnrCdRltByDmgVOs) {
		this.customMnrCdRltByDmgVOs = customMnrCdRltByDmgVOs;
	}
	public CustomMnrCdRltByRprVO[] getCustomMnrCdRltByRprVOs() {
		return customMnrCdRltByRprVOs;
	}
	public void setCustomMnrCdRltByRprVOs(
			CustomMnrCdRltByRprVO[] customMnrCdRltByRprVOs) {
		this.customMnrCdRltByRprVOs = customMnrCdRltByRprVOs;
	}
}
