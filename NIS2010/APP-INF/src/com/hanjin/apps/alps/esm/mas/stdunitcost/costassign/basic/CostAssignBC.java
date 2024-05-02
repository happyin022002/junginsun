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
* 2009.09.25 임옥영 ALPS BKG시스템과의 IFMethod(modifyMasCommoninterface()) 추가
* 2009.10.12 임옥영 callOther 삭제(사용하지 않는 메소드) 
* 2010.02.05 임옥영 소스품질검토 결과 반영 (클래스주석)
* 2010.08.19 이윤정 [CHM-201005008-01] BKG cancel 시 MAS에서 AGT 재계산 method 호출 요청
* 2010.09.29 박은주 비용생성 단계추가(디버깅을 위해서 소스 변경) Ticket ID : ITM-201003077
*                  createCostAssignCopLoop level 인자추가
*                  createCostAssignCop level 인자추가
* 2011.03.17 박은주 BPM에 정보 제공을 위해서 소스 수정(BKG의 비용정보를 제공함)
* 2011.05.04 박은주 [CHM-201110492-01]BPM POC 작업 종료에 따른 소스 제거 요청
* 2011.08.31 전윤주 [CHM-201113180-01] MAS 쪽 Customer 정보, ALPS 변경분 I/F 요청
*                  modifyMasDailyInterface 추가
* 2012.05.21 전윤주 [CHM-201217633] 구주 Hinterland 업무 개선 T/F
*                  Cost table 생성 후 mas_com_cost_para 테이블 삭제를 위해 별도로 method 생성
*                  removeMasComCostPara 추가
* 2013.01.16 성미영 [CHM-201322341] [AOC] Batch creation 시 기준 WGT 입력 기능추가 요청
*                 기존 createCostAssignPrd 를 overloading 해서 aocBatSeq 를 추가                
* 2015.06.30 이윤정 [CHM-201534179] [SPC-BKG 연동 BKG 통제 프로젝트] COST 산출 요청 ( EMU CREDIT + AGENT COMMISSION)                   
=========================================================*/
package com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic;

import java.util.List;


import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.common.table.MasBkgComIfVO;
import com.hanjin.syscommon.common.table.MasBkgCostCalcVO;

/**
 * ALPS-Stdunitcost Business Logic Command Interface<br>
 * - ALPS-Stdunitcost에 대한 비지니스 로직에 대한 인터페이스<br>
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
	 * @param String masBatCd
	 * @return List<MasBkgCostCalcVO>
	 * @exception EventException
	 */
	public List<MasBkgCostCalcVO> searchListAssign(String masBatCd) throws EventException; 

	
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
	 * CHM-201534179 : BKG로부터 호출된 Cost Assign 생성 이벤트 처리.. (CMPB 연관)
	 * 
	 * @param startPctlNo
	 * @param endPctlNo
	 * @param userId
	 * @return int
	 * @throws EventException
	 */
	public int createCostAssignBkg(String startPctlNo, String endPctlNo, String userId) throws EventException;
	
	/**
	 * SPC CMPB 재계산 로직 변경에 따른 신규 추가부분 [CHM-201539244] - 2015.12.10
	 * 
	 * @param bkgNo
	 * @param startPctlNo
	 * @param endPctlNo
	 * @param userId
	 * @return int
	 * @throws EventException
	 */
	public int createCostAssignBkg2(String bkgNo, String startPctlNo, String endPctlNo, String userId) throws EventException;


	/**
	 * PRD로부터 호출된 Cost Assign 생성 이벤트 처리..
	 * 
	 * @param startPctlNo
	 * @param endPctlNo
	 * @param userId
	 * @param aocBatSeq	  
	 * @return int
	 * @throws EventException
	 */
	public int createCostAssignPrd(String startPctlNo, String endPctlNo, String userId,String aocBatSeq) throws EventException;
	
	
	/**
	 * 2010.08.03 이윤정 [CHM-201005008-01] BKG cancel 시 MAS에서 AGT 재계산 method 호출 요청
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
	public int updateBkgIfTrs2MasSoCancel(String bkgNo)	throws EventException;
	
	/**
	 * BKG시스템의 변경사항을 배치작업 수행하기위해 IF
	 *  
	 * @param masBkgComIfVo
	 * @return int
	 * @throws EventException
	 */
	public int  modifyMasCommonInterface(MasBkgComIfVO masBkgComIfVo)	throws EventException;
	
	/**
	 * BKG시스템의 변경사항을 배치작업 수행하기위해 IF(일배치 method)
	 * 
	 * @param masBkgComIfVo
	 * @return int
	 * @throws EventException
	 */
	public int  modifyMasDailyInterface(MasBkgComIfVO masBkgComIfVo)	throws EventException;	
	
	
	/**
	 * MAS_COM_COST_PARA 테이블의 data를 삭제한다.
	 * Cost table 생성 시 process 가 끝난 후 mas_com_cost_para data 삭제
	 * 
	 * @param start_pctl_no
	 * @param end_pctl_no
	 * @return int
	 * @throws EventException
	 */
	public int removeMasComCostPara(String start_pctl_no, String end_pctl_no) throws EventException;
	
//	/**
//	 * BPM에 제공하는 정보를 조회한다.
//	 * 
//	 * @param bkg_no
//	 * @return
//	 * @throws EventException
//	 */
//	public List<SearchBpmInfoVO> searchBpmInfo(String bkg_no) throws EventException;
}