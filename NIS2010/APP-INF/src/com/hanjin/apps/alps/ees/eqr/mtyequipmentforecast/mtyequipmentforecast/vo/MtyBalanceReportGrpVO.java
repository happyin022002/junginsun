/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MtyBalanceReportGrpVO.java
*@FileTitle : MtyBalanceReportGrpVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.23
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.07.23 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo;

import java.util.List;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 김종준
 * @since J2EE 1.5
 * @see
 */
public class MtyBalanceReportGrpVO 
{
	// 조회 결과값을 받기위한 테이블 VO리스트
	private List<MtyBalanceListVO> myBalanceListVO = null;
	// CRUD 변경값을 입력 받기위한 array
	private MtyBalanceListVO[] myBalanceListVOs = null;

	// 조회 결과값을 받기위한 테이블 VO리스트
	private List<MtyBalanceReferenceListVO> mtyBalanceReferenceListVO = null;
	// CRUD 변경값을 입력 받기위한 array
	private MtyBalanceReferenceListVO[] mtyBalanceReferenceListVOs = null;

	public MtyBalanceReportGrpVO() 
	{
	}

	public List<MtyBalanceListVO> getMyBalanceListVO() {
		return myBalanceListVO;
	}

	public void setMtyBalanceListVO(List<MtyBalanceListVO> myBalanceListVO) {
		this.myBalanceListVO = myBalanceListVO;
	}

	public MtyBalanceListVO[] getMtyBalanceListVOS() {
		return myBalanceListVOs;
	}

	public void setMtyBalanceListVO(MtyBalanceListVO[] myBalanceListVOs) {
		this.myBalanceListVOs = myBalanceListVOs;
	}
	
	

	public List<MtyBalanceReferenceListVO> getMtyBalanceReferenceListVO() {
		return mtyBalanceReferenceListVO;
	}

	public void setMtyBalanceReferenceListVO(List<MtyBalanceReferenceListVO> mtyBalanceReferenceListVO) {
		this.mtyBalanceReferenceListVO = mtyBalanceReferenceListVO;
	}

	public MtyBalanceReferenceListVO[] getMtyBalanceReferenceListVOS() {
		return mtyBalanceReferenceListVOs;
	}

	public void setMtyBalanceReferenceListVO(MtyBalanceReferenceListVO[] mtyBalanceReferenceListVOs) {
		this.mtyBalanceReferenceListVOs = mtyBalanceReferenceListVOs;
	}
}
