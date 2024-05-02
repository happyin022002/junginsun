/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HangerInventoryListINVO.java
*@FileTitle : HangerInventoryListINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.07.15 함형석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.generalmanage.hangerinventorymgt.vo;


import java.util.List;

import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListINVO;
import com.hanjin.framework.component.common.AbstractValueObject;


/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 함형석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class HangerInventoryListGRPVO {
	//저장 조건을 받기 위한 
	private CustomHangerInventoryListVO[] arrCustomHangerInventoryListVOs = null;

	//저장 조건을 받기 위한 
	private CustomNewHangerInventoryListVO[] arrCustomNewHangerInventoryListVOs = null;

	//조회 INVO	
	private HangerInventoryListINVO hangerInventoryListINVO = null;

	//조회 INVO
	private EQFlagListINVO eQFlagListINVO = null;
	
	private CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = null;   
	
	//Hanger Bar Inventory  조회용[EES_MNR_0110] 
	private List<CustomHangerInventoryListVO> customHangerInventoryListVOs = null;
	
	//Hanger Bar Inventory  조회용[EES_MNR_0113]
	private List<CustomNewHangerInventoryListVO> customNewHangerInventoryListVOs = null;

	public EQFlagListINVO getEQFlagListINVO() {
		return eQFlagListINVO;
	}
	public void setEQFlagListINVO(EQFlagListINVO flagListINVO) {
		eQFlagListINVO = flagListINVO;
	}
	
	public CustomHangerInventoryListVO[] getArrCustomHangerInventoryListVOs() {
		return arrCustomHangerInventoryListVOs;
	}
	public void setArrCustomHangerInventoryListVOs(
			CustomHangerInventoryListVO[] arrCustomHangerInventoryListVOs) {
		this.arrCustomHangerInventoryListVOs = arrCustomHangerInventoryListVOs;
	}
	
	public CustomNewHangerInventoryListVO[] getArrCustomNewHangerInventoryListVOs() {
		return arrCustomNewHangerInventoryListVOs;
	}
	
	public void setArrCustomNewHangerInventoryListVOs(CustomNewHangerInventoryListVO[] arrCustomNewHangerInventoryListVOs) {
		this.arrCustomNewHangerInventoryListVOs = arrCustomNewHangerInventoryListVOs;
	}

	public List<CustomHangerInventoryListVO> getCustomHangerInventoryListVOs() {
		return customHangerInventoryListVOs;
	}
	
	public List<CustomNewHangerInventoryListVO> getCustomNewHangerInventoryListVOs() {
		return customNewHangerInventoryListVOs;
	}


	public void setCustomHangerInventoryListVOs(
			List<CustomHangerInventoryListVO> customHangerInventoryListVOs) {
		this.customHangerInventoryListVOs = customHangerInventoryListVOs;
	}
	
	public void setCustomNewHangerInventoryListVOs(List<CustomNewHangerInventoryListVO> customNewHangerInventoryListVOs) {
		this.customNewHangerInventoryListVOs = customNewHangerInventoryListVOs;
	}

	public HangerInventoryListINVO getHangerInventoryListINVO() {
		return hangerInventoryListINVO;
	}
	 
	public void setHangerInventoryListINVO(HangerInventoryListINVO hangerInventoryListINVO) {
		this.hangerInventoryListINVO = hangerInventoryListINVO;
	}
	 

	public CustomMnrEqStsVO[] getArrCustomMnrEqStsVOS() {
		return arrCustomMnrEqStsVOS;
	}
	public void setArrCustomMnrEqStsVOS(CustomMnrEqStsVO[] arrCustomMnrEqStsVOS) {
		this.arrCustomMnrEqStsVOS = arrCustomMnrEqStsVOS;
	}
}
