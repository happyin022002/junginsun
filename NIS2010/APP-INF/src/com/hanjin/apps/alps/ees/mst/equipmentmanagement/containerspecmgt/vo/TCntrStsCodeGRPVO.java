/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TContainerStatusCodeVO.java
*@FileTitle : Equipment Status Code Creation, Update & Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 김석준
*@LastVersion : 1.0
* 2009.05.06 김석준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentmanagement.containerspecmgt.vo;

import java.util.List;

import com.hanjin.syscommon.common.table.MstCntrPreStsVO;
import com.hanjin.syscommon.common.table.MstCntrStsVO;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 김석준
 * @since J2EE 1.5
 * @see
 */
public class TCntrStsCodeGRPVO 
{
	// 조회 결과값을 받기위한 테이블 VO리스트
	private List<MstCntrStsVO> mstCntrStsVO = null;
	// 조회 결과값을 받기위한 테이블 VO리스트
	private List<MstCntrPreStsVO> mstCntrPreStsVO = null;
	// CRUD 변경값을 입력 받기위한 array
	private MstCntrStsVO[] mstCntrStsVOS = null;
	// CRUD 변경값을 입력 받기위한 array
	private MstCntrPreStsVO[] mstCntrPreStsVOS = null;

	public TCntrStsCodeGRPVO() 
	{
	}

	public List<MstCntrStsVO> getMstCntrStsVO() {
		return mstCntrStsVO;
	}

	public void setMstCntrStsVO(List<MstCntrStsVO> mstCntrStsVO) {
		this.mstCntrStsVO = mstCntrStsVO;
	}

	public MstCntrStsVO[] getMstCntrStsVOS() {
		return mstCntrStsVOS;
	}

	public void setMstCntrStsVOS(MstCntrStsVO[] mstCntrStsVOS) {
		this.mstCntrStsVOS = mstCntrStsVOS;
	}

	public List<MstCntrPreStsVO> getMstCntrPreStsVO() {
		return mstCntrPreStsVO;
	}

	public void setMstCntrPreStsVO(List<MstCntrPreStsVO> mstCntrPreStsVO) {
		this.mstCntrPreStsVO = mstCntrPreStsVO;
	}

	public MstCntrPreStsVO[] getMstCntrPreStsVOS() {
		return mstCntrPreStsVOS;
	}

	public void setMstCntrPreStsVOS(MstCntrPreStsVO[] mstCntrPreStsVOS) {
		this.mstCntrPreStsVOS = mstCntrPreStsVOS;
	}
	
}
