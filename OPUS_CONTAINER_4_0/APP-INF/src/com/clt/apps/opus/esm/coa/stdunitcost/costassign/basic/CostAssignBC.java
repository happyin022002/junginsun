/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CostAssignBC.java
*@FileTitle : Batch Test Page
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 임옥영
*@LastVersion : 1.0
* 2009.09.25 임옥영
* 1.0 Creation
* ------------------------------------------------------------------------------------------------
* History
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic;

import java.util.List;

import com.clt.framework.core.layer.event.EventException;
import com.clt.syscommon.common.table.CoaBkgComIfVO;
import com.clt.syscommon.common.table.CoaBkgCostCalcVO;

/**
 * opus-Stdunitcost Business Logic Command Interface<br>
 * - opus-Stdunitcost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author OKYOUNG IM
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public interface CostAssignBC {

	/**
	 * 조회 이벤트 처리<br>
	 * MnsAsgn 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String coaBatCd
	 * @return List<CoaBkgCostCalcVO>
	 * @exception EventException
	 */
	public List<CoaBkgCostCalcVO> searchListAssign(String coaBatCd) throws EventException; 

	
	/**
	 * PRD로부터 호출된 Cost Assign 생성 이벤트 처리..
	 * 
	 * @param startPctlNo
	 * @param endPctlNo
	 * @param userId
	 * @return int
	 * @throws EventException
	 */
	public int createCostAssignPrd(String startPctlNo, String endPctlNo, String userId) throws EventException;

	/**
	 * 실제로 COP에서 호출하는 것이 아니라 BATCH Scheduler 에서 호출됨
	 * @param bkgNo
	 * @param userId
	 * @param delPara
	 * @return int
	 * @throws EventException
	 */
	public int modifyBkgStsAgt(String bkgNo, String userId, String delPara) throws EventException;
	/**
	 * COP로부터 호출된 Cost Assign 생성 이벤트 처리..
	 * 실제로 COP에서 호출하는 것이 아니라 BATCH Scheduler 에서 호출됨
	 * 
	 * @param bkgNo
	 * @param userId
	 * @param delPara
	 * @param level
	 * @return int
	 * @throws EventException
	 */
	public int createCostAssignCop(String bkgNo, String userId, String delPara, String level) throws EventException;

	/**
	 * Cost Assign 생성 이벤트 처리..
	 * 
	 * @param BkgNo
	 * @param DelPara
	 * @param level
	 * @param userId
	 * @return int
	 * @throws EventException
	 */
	public int createCostAssignCopLoop(String BkgNo, String DelPara, String level, String userid)
			throws EventException;

	/**
	 * Cost Assign 생성 이벤트 처리..
	 * 
	 * @param str
	 * @throws EventException
	 */
	public void receiveCostAssignCop(String str) throws EventException;
	
	/**
	 * TRS에서 SO CANCEL발생했을때 배치작업 수행을 위해 IF
	 * 
	 * @param bkgNo
	 * @return int
	 * @throws EventException
	 */
	public int updateBkgIfTrs2CoaSoCancel(String bkgNo)	throws EventException;
	
	/**
	 * BKG시스템의 변경사항을 배치작업 수행하기위해 IF
	 * 
	 * @param CoaBkgComIfVO coaBkgComIfVo
	 * @return int
	 * @throws EventException
	 */
	public int  modifyCoaCommonInterface(CoaBkgComIfVO coaBkgComIfVo)	throws EventException;
}