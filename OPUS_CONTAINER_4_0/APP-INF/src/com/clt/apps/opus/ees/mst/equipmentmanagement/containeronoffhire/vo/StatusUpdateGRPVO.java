/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusUpdateGRPVO.java
*@FileTitle : Container Status Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.08.25 이호선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo;

import java.util.List;

import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrMstHeadVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.MovementVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.StatusHistoryVO;

public class StatusUpdateGRPVO
{
	// 조회 결과값을 받기위한 테이블 VO리스트
	private CntrMstHeadVO cntrMstHeadVO = null;	

	// 조회 결과값을 받기위한 테이블 VO리스트
	private List<StatusHistoryVO> statusHistoryVOs = null;
	
	// 조회 결과값을 받기위한 테이블 VO리스트
	private List<MovementVO> movementVOs = null;

	/**
	 * @return the cntrMstHeadVO
	 */
	public CntrMstHeadVO getCntrMstHeadVO() {
		return cntrMstHeadVO;
	}

	/**
	 * @param cntrMstHeadVO the cntrMstHeadVO to set
	 */
	public void setCntrMstHeadVO(CntrMstHeadVO cntrMstHeadVO) {
		this.cntrMstHeadVO = cntrMstHeadVO;
	}

	/**
	 * @return the statusHistoryVOs
	 */
	public List<StatusHistoryVO> getStatusHistoryVOs() {
		return statusHistoryVOs;
	}

	/**
	 * @param statusHistoryVOs the statusHistoryVOs to set
	 */
	public void setStatusHistoryVOs(List<StatusHistoryVO> statusHistoryVOs) {
		this.statusHistoryVOs = statusHistoryVOs;
	}

	/**
	 * @return the movementVOs
	 */
	public List<MovementVO> getMovementVOs() {
		return movementVOs;
	}

	/**
	 * @param movementVOs the movementVOs to set
	 */
	public void setMovementVOs(List<MovementVO> movementVOs) {
		this.movementVOs = movementVOs;
	}

	public StatusUpdateGRPVO() 
	{
	}
}
