/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQWorkOrderHistoryListGRPVO
*@FileTitle : Repair History_Pop Up
*Open Issues : 
*Change history :
*@LastModifyDate : 2009. 6. 3
*@LastModifier : 
*@LastVersion : 1.0
*2009. 6. 3. 박명신 
** 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo;

import java.util.List; 
  
/**
 * EQWorkOrderHistoryListGRPVO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *  
 * @author 박명신
 * @since J2EE 1.5 
 * @see ..
 */ 
public class EQWorkOrderHistoryListGRPVO {
	//조회 결과를 받기 위한   
	private List<CustomEQWorkOrderHistoryListVO> customEQWorkOrderHistoryListVOS = null;
	//조회조건을 받기위한
	private EQWorkOrderHistoryListINVO eQWorkOrderHistoryListINVO= null;
	
	public List<CustomEQWorkOrderHistoryListVO> getCustomEQWorkOrderHistoryListVOS() {
		return customEQWorkOrderHistoryListVOS;
	}
	public void setCustomEQWorkOrderHistoryListVOS(
			List<CustomEQWorkOrderHistoryListVO> customEQWorkOrderHistoryListVOS) {
		this.customEQWorkOrderHistoryListVOS = customEQWorkOrderHistoryListVOS;
	}
	public EQWorkOrderHistoryListINVO getEQWorkOrderHistoryListINVO() {
		return eQWorkOrderHistoryListINVO;
	}
	public void setEQWorkOrderHistoryListINVO(
			EQWorkOrderHistoryListINVO workOrderHistoryListINVO) {
		eQWorkOrderHistoryListINVO = workOrderHistoryListINVO;
	}
}
