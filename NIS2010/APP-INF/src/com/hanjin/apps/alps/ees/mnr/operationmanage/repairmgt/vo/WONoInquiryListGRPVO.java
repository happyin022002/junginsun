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

package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo;

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

public class WONoInquiryListGRPVO {
	
	private static final long serialVersionUID = 1L;
	
	private WONoInquiryListINVO wONoInquiryListINVO = null;
	private List<WONoInquiryVO> arrWONoInquiryVOS = null;
    public WONoInquiryListGRPVO(){}

	public WONoInquiryListINVO getWONoInquiryListINVO() {
		return wONoInquiryListINVO;
	}

	public void setWONoInquiryListINVO(WONoInquiryListINVO noInquiryListINVO) {
		wONoInquiryListINVO = noInquiryListINVO;
	}

	public List<WONoInquiryVO> getArrWONoInquiryVOS() {
		return arrWONoInquiryVOS;
	}

	public void setArrWONoInquiryVOS(List<WONoInquiryVO> arrWONoInquiryVOS) {
		this.arrWONoInquiryVOS = arrWONoInquiryVOS;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	
	

}
