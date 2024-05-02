/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExtraWOGRPVO.java
*@FileTitle : ExtraWOGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.07.09 정영훈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo;

import java.util.List;

import com.clt.framework.component.common.AbstractValueObject;

/** 
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정영훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RepairResultGRPVO {
	
	private static final long serialVersionUID = 1L;
	
    private RepairResultINVO repairResultINVO = null;

    private  List <CustomBzcAmtVO> customBzcAmtVOLST = null;
    

    private  RepairResultListVO[] arrRepairResultListVO = null;
    private  List <RepairResultListVO> repairResultListVOLst = null;
	
	private RepairResultListVO[] arrRepairResultListVOS = null;
	public RepairResultGRPVO(){}

	public RepairResultINVO getRepairResultINVO() {
		return repairResultINVO;
	}

	public void setRepairResultINVO(RepairResultINVO repairResultINVO) {
		this.repairResultINVO = repairResultINVO;
	}



	public RepairResultListVO[] getArrRepairResultListVO() {
		return arrRepairResultListVO;
	}

	public void setArrRepairResultListVO(RepairResultListVO[] arrRepairResultListVO) {
		this.arrRepairResultListVO = arrRepairResultListVO;
	}
	
	public RepairResultListVO[] getArrRepairResultListVOS() {
		return arrRepairResultListVOS;
	}
	public void setArrRepairResultListVOS(
			RepairResultListVO[] arrRepairResultListVOS) {
		this.arrRepairResultListVOS = arrRepairResultListVOS;
	}

	public List<RepairResultListVO> getRepairResultListVOLst() {
		return repairResultListVOLst;
	}

	public void setRepairResultListVOLst(List<RepairResultListVO> repairResultListVOLst) {
		this.repairResultListVOLst = repairResultListVOLst;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public List<CustomBzcAmtVO> getCustomBzcAmtVOLST() {
		return customBzcAmtVOLST;
	}

	public void setCustomBzcAmtVOLST(List<CustomBzcAmtVO> customBzcAmtVOLST) {
		this.customBzcAmtVOLST = customBzcAmtVOLST;
	}

	

}
