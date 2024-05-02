/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepairExpensePlanGRPVO.java
*@FileTitle : RepairExpensePlanGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.05.25 정영훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.planmanage.planmgt.vo;

import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정영훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RepairExpensePlanGRPVO {
	
	private RepairExpensePlanINVO repairExpensePlanINVO = null;
	
	private  CustomMnrPlnHdrVO[] customMnrPlnHdrVOS = null;
	
	private  CustomMnrPlnDtlVO[] customMnrPlnDtlVOS = null;
	
    private  List <CustomMnrPlnHdrVO> hdrLst = null;
	
	private  List <CustomMnrPlnDtlVO> dtlLst = null;

	
	public RepairExpensePlanINVO getRepairExpensePlanINVO() {
		return repairExpensePlanINVO;
	}

	public void setRepairExpensePlanINVO(RepairExpensePlanINVO invo) {
		this.repairExpensePlanINVO = invo;
	}

	public CustomMnrPlnHdrVO[] getCustomMnrPlnHdrVOS() {
		return customMnrPlnHdrVOS;
	}

	public void setCustomMnrPlnHdrVOS(CustomMnrPlnHdrVO[] hdrvos) {
		this.customMnrPlnHdrVOS = hdrvos;
	}

	public CustomMnrPlnDtlVO[] getCustomMnrPlnDtlVOS() {
		return customMnrPlnDtlVOS;
	}

	public void setCustomMnrPlnDtlVOS(CustomMnrPlnDtlVO[] dtlvos) {
		this.customMnrPlnDtlVOS = dtlvos;
	}

	public List<CustomMnrPlnHdrVO> getCustomMnrPlnHdrVOLst() {
		return hdrLst;
	}

	public void setCustomMnrPlnHdrVOLst(List<CustomMnrPlnHdrVO> hdrLst) {
		this.hdrLst = hdrLst;
	}

	public List<CustomMnrPlnDtlVO> getCustomMnrPlnDtlVOLst() {
		return dtlLst;
	}

	public void setCustomMnrPlnDtlVOLst(List<CustomMnrPlnDtlVO> dtlLst) {
		this.dtlLst = dtlLst;
	}


	
	

}
