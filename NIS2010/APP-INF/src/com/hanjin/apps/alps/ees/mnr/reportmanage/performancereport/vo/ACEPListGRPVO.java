/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ACEPListGRPVO
*@FileTitle : ACEP Candidate Cntr List
*Open Issues : 
*Change history :
*@LastModifyDate : 2009. 10. 22
*@LastModifier : 
*@LastVersion : 1.0
*2009. 10. 22. 김완규 
** 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.reportmanage.performancereport.vo;

import java.util.List;

/**
 * ACEPListGRPVO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *  
 * @author 김완규
 * @since J2EE 1.5 
 * @see ..
 */
public class ACEPListGRPVO {
	//조회조건을 받기 위한
	private ACEPListINVO aCEPListINVO = null;
	//조회결과을 받기 위한
	private  List <ACEPListVO> listACEPListVO = null;
	
	public ACEPListINVO getACEPListINVO() {
		return aCEPListINVO;
	}
	public void setACEPListINVO(ACEPListINVO listINVO) {
		aCEPListINVO = listINVO;
	}
	public List<ACEPListVO> getListACEPListVO() {
		return listACEPListVO;
	}
	public void setListACEPListVO(List<ACEPListVO> listACEPListVO) {
		this.listACEPListVO = listACEPListVO;
	}
}
