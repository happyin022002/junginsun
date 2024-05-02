/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : InboundTSInfoGRPVO.java
*@FileTitle : InboundTSInfoGRPVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.11.01
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2013.11.01 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.vo;

import java.util.List;

import com.hanjin.framework.component.common.AbstractValueObject;


/**
 * Group Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object들의 묶음
 * 
 * InboundTSCntrVO.java
 * InboundTSCustVO.java
 * InboundTSDownExcelVO.java
 * InboundTSGRPVO.java
 * InboundTSInfoBLVO.java
 * InboundTSInfoSKDVO.java
 *
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
public class InboundTSGRPVO {

	private InboundTSInfoBLVO inboundTSInfoBLVO = null;
	private InboundTSInfoSKDVO inboundTSInfoSKDVO = null;
	private InboundTSCustVO inboundTSCustVO = null;
	private List<InboundTSCntrVO> inboundTSCntrVOList = null;
	private List<InboundTSDownExcelVO> inboundTSDownExcelVOList = null;

	public InboundTSGRPVO() {}

	public InboundTSInfoBLVO getInboundTSInfoBLVO() {
		return inboundTSInfoBLVO;
	}

	public void setInboundTSInfoBLVO(InboundTSInfoBLVO inboundTSInfoBLVO) {
		this.inboundTSInfoBLVO = inboundTSInfoBLVO;
	}

	public InboundTSInfoSKDVO getInboundTSInfoSKDVO() {
		return inboundTSInfoSKDVO;
	}

	public void setInboundTSInfoSKDVO(InboundTSInfoSKDVO inboundTSInfoSKDVO) {
		this.inboundTSInfoSKDVO = inboundTSInfoSKDVO;
	}

	public InboundTSCustVO getInboundTSCustVO() {
		return inboundTSCustVO;
	}

	public void setInboundTSCustVO(InboundTSCustVO inboundTSCustVO) {
		this.inboundTSCustVO = inboundTSCustVO;
	}

	public List<InboundTSCntrVO> getInboundTSCntrVOList() {
		return inboundTSCntrVOList;
	}

	public void setInboundTSCntrVOList(List<InboundTSCntrVO> inboundTSCntrVOList) {
		this.inboundTSCntrVOList = inboundTSCntrVOList;
	}

	public List<InboundTSDownExcelVO> getInboundTSDownExcelVOList() {
		return inboundTSDownExcelVOList;
	}

	public void setInboundTSDownExcelVOList(List<InboundTSDownExcelVO> inboundTSDownExcelVOList) {
		this.inboundTSDownExcelVOList = inboundTSDownExcelVOList;
	}

}
