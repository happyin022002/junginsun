/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TContainerStatusCodeVO.java
*@FileTitle : Equipment Status Code Creation, Update & Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.09 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.vo;

import java.util.List;

import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.vo.CntrMstHeadVO;
import com.hanjin.apps.alps.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusListVO;

public class CntrStatusGrpVO
{
	// 조회 결과값을 받기위한 테이블 VO리스트
	private List<CntrMstHeadVO> cntrMstHeadVO = null;
	// 조회 결과값을 받기위한 테이블 VO리스트
	private List<CntrStatusListVO> cntrStatusListVO = null;
	

	public CntrStatusGrpVO() 
	{
	}

	/**
	 * @return the cntrMstHeadVO
	 */
	public List<CntrMstHeadVO> getCntrMstHeadVO() {
		return cntrMstHeadVO;
	}


	/**
	 * @param cntrMstHeadVO the cntrMstHeadVO to set
	 */
	public void setCntrMstHeadVO(List<CntrMstHeadVO> cntrMstHeadVO) {
		this.cntrMstHeadVO = cntrMstHeadVO;
	}


	/**
	 * @return the cntrStatusListVO
	 */
	public List<CntrStatusListVO> getCntrStatusListVO() {
		return cntrStatusListVO;
	}


	/**
	 * @param cntrStatusListVO the cntrStatusListVO to set
	 */
	public void setCntrStatusListVO(List<CntrStatusListVO> cntrStatusListVO) {
		this.cntrStatusListVO = cntrStatusListVO;
	}

	
}
