/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusHistoryGRPVO.java
*@FileTitle : StatusHistoryGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.09.25 김완규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.generalmanage.statushistorymgt.vo;

import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김완규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class StatusHistoryGRPVO {
	//조회조건을 받기위한
	private StatusHistoryINVO statusHistoryINVO = null;
	//조회결과을 받기위한
	private  List <CustomMnrStsHisVO> listCustomMnrStsHisVO = null;
	//CUD처리를 위한
	private CustomMnrStsHisVO[] arrayCustomMnrStsHisVO = null;
	//MNR STS REF No 를 받기 위한
	private String mnrStsRefNo = null;
	public StatusHistoryINVO getStatusHistoryINVO() {
		return statusHistoryINVO;
	}
	public void setStatusHistoryINVO(StatusHistoryINVO statusHistoryINVO) {
		this.statusHistoryINVO = statusHistoryINVO;
	}
	public List<CustomMnrStsHisVO> getListCustomMnrStsHisVO() {
		return listCustomMnrStsHisVO;
	}
	public void setListCustomMnrStsHisVO(
			List<CustomMnrStsHisVO> listCustomMnrStsHisVO) {
		this.listCustomMnrStsHisVO = listCustomMnrStsHisVO;
	}
	public CustomMnrStsHisVO[] getArrayCustomMnrStsHisVO() {
		return arrayCustomMnrStsHisVO;
	}
	public void setArrayCustomMnrStsHisVO(CustomMnrStsHisVO[] arrayCustomMnrStsHisVO) {
		this.arrayCustomMnrStsHisVO = arrayCustomMnrStsHisVO;
	}
	public String getMnrStsRefNo() {
		return mnrStsRefNo;
	}
	public void setMnrStsRefNo(String mnrStsRefNo) {
		this.mnrStsRefNo = mnrStsRefNo;
	}
}
