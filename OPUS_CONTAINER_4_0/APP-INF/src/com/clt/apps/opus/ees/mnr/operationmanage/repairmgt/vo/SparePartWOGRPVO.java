/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SparePartWOGRPVO
*@FileTitle : Recent Reefer Parts Supply Information_Pop Up
*Open Issues : 
*Change history :
*@LastModifyDate : 2009. 09.07
*@LastModifier : 
*@LastVersion : 1.0
*2009. 09.07. 권영법 
** 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo;

import java.util.List; 
  
/**
 * EQWorkOrderHistoryListGRPVO<br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 *  
 * @author 권영법
 * @since J2EE 1.5 
 * @see ..
 */ 
public class SparePartWOGRPVO {
	//조회 결과를 받기 위한   
	private List<MnrOrderInfoBySparePartVO> mnrOrderInfoBySparePartVOS = null;
	//조회조건을 받기위한
	private SparePartWOINVO sparePartWOINVO= null;
	
	public List<MnrOrderInfoBySparePartVO> getMnrOrderInfoBySparePartVOS() {
		return mnrOrderInfoBySparePartVOS;
	}
	public void setMnrOrderInfoBySparePartVOS(
			List<MnrOrderInfoBySparePartVO> mnrOrderInfoBySparePartVOS) {
		this.mnrOrderInfoBySparePartVOS = mnrOrderInfoBySparePartVOS;
	}
	public SparePartWOINVO getSparePartWOINVO() {
		return sparePartWOINVO;
	}
	public void setSparePartWOINVO(SparePartWOINVO sparePartWOINVO) {
		this.sparePartWOINVO = sparePartWOINVO;
	}
}
