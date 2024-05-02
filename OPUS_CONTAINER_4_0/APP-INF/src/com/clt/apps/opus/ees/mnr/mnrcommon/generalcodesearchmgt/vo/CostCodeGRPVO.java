/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CostCodeGRPVO
*@FileTitle : 
*Open Issues :	
*Change history :
*@LastModifyDate : 2009. 8. 17.
*@LastModifier : 
*@LastVersion : 1.0
*2009. 8. 17. 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo;

import java.util.List;

/**
 * CostCodeGRPVO <br>
 * 이벤트에서 받아온 정보를 그룹VO에 담아서 BC로 넘긴다.<br>
 * 
 * @author 박명신 
 * @since J2EE 1.5 
 * @see	  ..   
 */

public class CostCodeGRPVO {
	private CostCodeINVO costCodeINVO = null;
	private List<CustomCostCodeVO> customCostCodeVOS = null;
	
	public CostCodeINVO getCostCodeINVO() {
		return costCodeINVO;
	}
	public void setCostCodeINVO(CostCodeINVO costCodeINVO) {
		this.costCodeINVO = costCodeINVO;
	}
	public List<CustomCostCodeVO> getCustomCostCodeVOS() {
		return customCostCodeVOS;
	}
	public void setCustomCostCodeVOS(List<CustomCostCodeVO> customCostCodeVOS) {
		this.customCostCodeVOS = customCostCodeVOS;
	}
}
