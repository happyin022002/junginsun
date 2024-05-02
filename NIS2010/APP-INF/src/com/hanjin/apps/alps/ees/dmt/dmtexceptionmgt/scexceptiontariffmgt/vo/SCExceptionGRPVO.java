/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCExceptionGRPVO.java
*@FileTitle : SCExceptionGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.28
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.05.28 이성훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이성훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class SCExceptionGRPVO {

	private List<SCExceptionVO> 			sCExceptionVOS 				= null;
	
	private List<SCExceptionCoverageVO> 	sCExceptionCoverageVOS 		= null;
	
	private List<SCExceptionFreeTimeVO> 	sCExceptionFreeTimeVOS 		= null;
	
	private List<SCExceptionRateAdjustVO> 	sCExceptionRateAdjustVOS 	= null;

	private List<SCExceptionCustomerVO> 	sCExceptionCustomerVOS 		= null;
	
	private List<SCExceptionCommodityVO> 	sCExceptionCommodityVOS 	= null;
	
	private SCExceptionDeleteVO 			sCExceptionDeleteVO 		= null;
	
	private SCExceptionVersionVO 			sCExceptionVersionVO 		= null;
	
	public void setSCExceptionVOS(List<SCExceptionVO> sCExceptionVOS) {
		this.sCExceptionVOS = sCExceptionVOS;
	}
	
	public void setSCExceptionCoverageVOS(List<SCExceptionCoverageVO> sCExceptionCoverageVOS) {
		this.sCExceptionCoverageVOS = sCExceptionCoverageVOS;
	}

	public void setSCExceptionFreeTimeVOS(List<SCExceptionFreeTimeVO> sCExceptionFreeTimeVOS) {
		this.sCExceptionFreeTimeVOS = sCExceptionFreeTimeVOS;
	}
	
	public void setSCExceptionRateAdjustVOS(List<SCExceptionRateAdjustVO> sCExceptionRateAdjustVOS) {
		this.sCExceptionRateAdjustVOS = sCExceptionRateAdjustVOS;
	}	
	
	public void setSCExceptionCustomerVOS(List<SCExceptionCustomerVO> sCExceptionCustomerVOS) {
		this.sCExceptionCustomerVOS = sCExceptionCustomerVOS;
	}
	
	public void setSCExceptionCommodityVOS(List<SCExceptionCommodityVO> sCCExceptionCommodityVOS) {
		this.sCExceptionCommodityVOS = sCCExceptionCommodityVOS;
	}
	
	public void setSCExceptionVOS(SCExceptionVO[] sCExceptionList) {
		if (sCExceptionList != null && sCExceptionList.length > 0) {
			sCExceptionVOS = new ArrayList<SCExceptionVO>();
			for (int i = 0 ; i < sCExceptionList.length ; i++) {
				sCExceptionVOS.add(sCExceptionList[i]);
			}
		}
	}
	
	public void setSCExceptionCoverageVOS(SCExceptionCoverageVO[] sCExceptionCoverageList) {
		if (sCExceptionCoverageList != null && sCExceptionCoverageList.length > 0) {
			sCExceptionCoverageVOS = new ArrayList<SCExceptionCoverageVO>();
			for (int i = 0 ; i < sCExceptionCoverageList.length ; i++) {
				sCExceptionCoverageVOS.add(sCExceptionCoverageList[i]);
			}
		}
	}

	public void setSCExceptionFreeTimeVOS(SCExceptionFreeTimeVO[] sCExceptionFreeTimeList) {
		if (sCExceptionFreeTimeList != null && sCExceptionFreeTimeList.length > 0) {
			sCExceptionFreeTimeVOS = new ArrayList<SCExceptionFreeTimeVO>();
			for (int i = 0 ; i < sCExceptionFreeTimeList.length ; i++) {
				sCExceptionFreeTimeVOS.add(sCExceptionFreeTimeList[i]);
			}
		}		
	}
	
	public void setSCExceptionRateAdjustVOS(SCExceptionRateAdjustVO[] sCExceptionRateAdjustList) {
		if (sCExceptionRateAdjustList != null && sCExceptionRateAdjustList.length > 0) {
			sCExceptionRateAdjustVOS = new ArrayList<SCExceptionRateAdjustVO>();
			for (int i = 0 ; i < sCExceptionRateAdjustList.length ; i++) {
				sCExceptionRateAdjustVOS.add(sCExceptionRateAdjustList[i]);
			}
		}		
	}	
	
	public void setSCExceptionCustomerVOS(SCExceptionCustomerVO[] sCExceptionCustomerList) {
		if (sCExceptionCustomerList != null && sCExceptionCustomerList.length > 0) {
			sCExceptionCustomerVOS = new ArrayList<SCExceptionCustomerVO>();
			for (int i = 0 ; i < sCExceptionCustomerList.length ; i++) {
				sCExceptionCustomerVOS.add(sCExceptionCustomerList[i]);
			}
		}		
	}

	public void setSCExceptionCommodityVOS(SCExceptionCommodityVO[] sCExceptionCommodityList) {
		if (sCExceptionCommodityList != null && sCExceptionCommodityList.length > 0) {
			sCExceptionCommodityVOS = new ArrayList<SCExceptionCommodityVO>();
			for (int i = 0 ; i < sCExceptionCommodityList.length ; i++) {
				sCExceptionCommodityVOS.add(sCExceptionCommodityList[i]);
			}
		}		
	}
	
	public void setSCExceptionDeleteVO(SCExceptionDeleteVO sCExceptionDeleteVO) {
		this.sCExceptionDeleteVO = sCExceptionDeleteVO;
	}
	
	public void setSCExceptionVersionVO(SCExceptionVersionVO sCExceptionVersionVO) {
		this.sCExceptionVersionVO = sCExceptionVersionVO;
	}
	
	public List<SCExceptionVO> getSCExceptionVOS() {
		return sCExceptionVOS;
	}
	
	public List<SCExceptionCoverageVO> getSCExceptionCoverageVOS() {
		return sCExceptionCoverageVOS;
	}
	
	public List<SCExceptionFreeTimeVO> getSCExceptionFreeTimeVOS() {
		return sCExceptionFreeTimeVOS;
	}
	
	public List<SCExceptionRateAdjustVO> getSCExceptionRateAdjustVOS() {
		return sCExceptionRateAdjustVOS;
	}	
	
	public List<SCExceptionCustomerVO> getSCExceptionCustomerVOS() {
		return sCExceptionCustomerVOS;
	}
	
	public List<SCExceptionCommodityVO> getSCExceptionCommodityVOS() {
		return sCExceptionCommodityVOS;
	}
	
	public SCExceptionDeleteVO getSCExceptionDeleteVO() {
		return sCExceptionDeleteVO;
	}
	
	public SCExceptionVersionVO getSCExceptionVersionVO() {
		return sCExceptionVersionVO;
	}	
}
