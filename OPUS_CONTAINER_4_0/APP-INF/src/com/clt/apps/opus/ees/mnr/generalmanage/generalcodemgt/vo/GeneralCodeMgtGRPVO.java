/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeMgtGRPVO
*@FileTitle : 
*Open Issues : 
*Change history :
*@LastModifyDate : 2009. 5. 14.
*@LastModifier : 
*@LastVersion : 1.0
*2009. 5. 14. 김완규 
** 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.vo;

import java.util.List;
/**
 * GeneralCodeMgt GROUP VO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *
 * @author 김완규
 * @since J2EE 1.5
 * @see
 */
public class GeneralCodeMgtGRPVO  {
	//콤보조회를 위한 리스트
	private List<CustomMnrGenCdVO> customMnrGenCdVOs = null;
	//조회조건을 받기위한
	private GeneralCodeMgtINVO generalCodeMgtINVO= null;
	//CUD처리를 위한 
	private CustomMnrGenCdVO[] arrayCustomMnrGenCdVOs = null;
	//다중조회 처리를 위한
	private List<List<CustomMnrGenCdVO>> listCustomMnrGenCdVOs = null;
	
	public List<CustomMnrGenCdVO> getCustomMnrGenCdVOs() {
		return customMnrGenCdVOs;
	}
	public void setCustomMnrGenCdVOs(List<CustomMnrGenCdVO> customMnrGenCdVOs) {
		this.customMnrGenCdVOs = customMnrGenCdVOs;
	}
	
	public GeneralCodeMgtINVO getGeneralCodeMgtINVO() {
		return generalCodeMgtINVO;
	}
	public void setGeneralCodeMgtINVO(GeneralCodeMgtINVO generalCodeMgtINVO) {
		this.generalCodeMgtINVO = generalCodeMgtINVO;
	}
	
	public CustomMnrGenCdVO[] getArrayCustomMnrGenCdVOs() {
		return arrayCustomMnrGenCdVOs;
	}
	public void setArrayCustomMnrGenCdVOs(CustomMnrGenCdVO[] arrayCustomMnrGenCdVOs) {
		this.arrayCustomMnrGenCdVOs = arrayCustomMnrGenCdVOs;
	}
	
	public List<List<CustomMnrGenCdVO>> getListCustomMnrGenCdVOs() {
		return listCustomMnrGenCdVOs;
	}
	public void setListCustomMnrGenCdVOs(
			List<List<CustomMnrGenCdVO>> listCustomMnrGenCdVOs) {
		this.listCustomMnrGenCdVOs = listCustomMnrGenCdVOs;
	}

	

}
