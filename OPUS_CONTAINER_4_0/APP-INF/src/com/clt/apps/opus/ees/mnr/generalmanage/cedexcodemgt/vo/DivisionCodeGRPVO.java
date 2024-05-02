/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DivisionCodeGRPVO.java
*@FileTitle : Division Code Creation
*Open Issues :
*Change history : 
*@LastModifyDate : 2009.10.13 
*@LastModifier : 박명신  
*@LastVersion : 1.0   
* 2009.10.13 박명신  
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo;

import java.util.List; 
  
/**
 * DivisionCodeGRPVO <br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 * @author 박명신
 * @since J2EE 1.5
 * @see
 */
public class DivisionCodeGRPVO { 
	//조회 조건    
	private DivisionCodeINVO divisionCodeINVO = null;
	//조회 결과 
	private List<CustomMnrCdRltVO> listCustomMnrCdRltVOS = null;
	//CUD처리를 위한 
	private CustomMnrCdRltVO[] arrCustomMnrCdRltVOS = null;
	
	public DivisionCodeINVO getDivisionCodeINVO() {
		return divisionCodeINVO;
	}
	public void setDivisionCodeINVO(DivisionCodeINVO divisionCodeINVO) {
		this.divisionCodeINVO = divisionCodeINVO;
	}
	public List<CustomMnrCdRltVO> getListCustomMnrCdRltVOS() {
		return listCustomMnrCdRltVOS;
	}
	public void setListCustomMnrCdRltVOS(
			List<CustomMnrCdRltVO> listCustomMnrCdRltVOS) {
		this.listCustomMnrCdRltVOS = listCustomMnrCdRltVOS;
	}
	public CustomMnrCdRltVO[] getArrCustomMnrCdRltVOS() {
		return arrCustomMnrCdRltVOS;
	}
	public void setArrCustomMnrCdRltVOS(CustomMnrCdRltVO[] arrCustomMnrCdRltVOS) {
		this.arrCustomMnrCdRltVOS = arrCustomMnrCdRltVOS;
	}
}
