/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WeeklyPFMCBC.java
*@FileTitle : Weekly PFMC BC
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-23
*@LastModifier : Park Eun Ju
*@LastVersion : 1.0
* 2006-10-23 Park Eun Ju
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.basic;

import java.util.List;

import com.clt.apps.opus.esm.coa.common.vo.GetCodeSelectVO;
import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.SearchVVDCheckListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.SearchVVDChkWithARListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.SearchWeeklyTargetVVDListVO;
import com.clt.apps.opus.esm.coa.weeklypfmc.weeklycm.vo.WeeklyCMCommonVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaMonVvdVO;

/**
 * COA Business Logic Command Interface<br>
 * - COA에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Park Eun Ju
 * @see ESM_COA_029EventResponse 참조
 * @since J2EE 1.4
 */
public interface WeeklyCMBC  {
	/**
	 * WeeklyCM 주간 대상항차화면에 대한 조회 이벤트 처리.<br>
	 * ESM_COA_0142 화면 조회
	 * @param SearchVVDCheckListVO	searchVVDCheckListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchVVDCheckListVO>
	 * @exception EventException
	 */
	public List<SearchVVDCheckListVO> searchVVDCheckList(SearchVVDCheckListVO searchVVDCheckListVO
			                                            ,SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * WeeklyCM 주간 대상항차화면에 대한 조회 이벤트 처리.<br>
	 * ESM_COA_0142 화면 수정
	 * @param CoaMonVvdVO[] coaMonVvdVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyVVDCheck(CoaMonVvdVO[] coaMonVvdVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * 1. 기능 : WeeklyCM 주간 대상항차관리 화면에 대한 조회 이벤트 처리(ESM_COA_029)<p>
	 * 2. 처리개요 : <p>
	 *    - 주간 대상항차관리에 대한 리스트를 조회
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2006.10.23<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchWeeklyTargetVVDListVO>
	 * @exception EventException
	 */
	public List<SearchWeeklyTargetVVDListVO> searchWeeklyTargetVVDList(SearchConditionVO searchConditionVO) throws EventException;
	
    /**
     * 1. 기능 : WeeklyCM 주간 대상항차관리 화면에 대한 멀티 이벤트 처리(ESM_COA_029)<p>
     * 2. 처리개요 : <p>
     *    - 주간 대상항차관리에 대한 멀티처리 
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : Park eun ju /2006.10.23<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * 
     * @param SearchConditionVO searchVo
     * @param WeeklyCMCommonVO vo
     * @param WeeklyCMCommonVO[] vos
     * @param CoaMonVvdVO[] tVos
     * @param SignOnUserAccount account
     * @return EventResponse
     * @exception EventException
     */
	public EventResponse multiWeeklyTargetVVD(SearchConditionVO searchVo, WeeklyCMCommonVO vo, WeeklyCMCommonVO[] vos, CoaMonVvdVO[] tVos, SignOnUserAccount account) throws EventException;
	
    /**
     * 1. 기능 : WeeklyCM 주간 대상항차관리 화면에 대한 Create 이벤트 처리(ESM_COA_029)<p>
     * 2. 처리개요 : <p>
     *    - 주간 대상항차관리에 대한 Create처리 
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : Park eun ju /2006.10.23<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
     * 
     * @param SearchConditionVO searchVo 
     * @param SignOnUserAccount account
     * @return EventResponse
     * @exception EventException
     */
	public EventResponse createTargetVVD(SearchConditionVO searchVo, SignOnUserAccount account) throws EventException;
	
	/**
	 * 1. 기능 : WeeklyCM 주간 대상항차관리 화면에 대한 Create 이벤트 처리(ESM_COA_0029)<p>
	 * 2. 처리개요 : <p>
	 *    - 주간 대상항차관리에 대한 Create처리 
	 * 3. 주의사항 : <p>
	 * ===================================<br>
	 * 4. 작성자/작성일 : Park eun ju /2006.10.23<br>
	 * ===================================<br>
	 * 5. 수정사항<p>
	 * 5.1 요구사항 ID :<p>
	 * - 수정자/수정일 :<p>
	 * - 수정사유/내역 :<p>
	 * ===================================<br>
	 * <p/>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse createTSQty(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;

	
	/**
	 * ESM_COA_0029 : 수동배치 처리 #1<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse dailyBatch(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_COA_0029 : BSA Flag가 Y인것들을 BSA VVD의 값을 0으로 만들어 준다<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse batchBSAVVDZero(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * VVD Check With AR List 조회 이벤트 처리<br>
	 * ESM_COA_0112 조회
	 * @param SearchVVDChkWithARListVO	searchVVDChkWithARListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchVVDChkWithARListVO>
	 * @exception EventException
	 */
	public List<SearchVVDChkWithARListVO> searchVVDChkWithARList (SearchVVDChkWithARListVO searchVVDChkWithARListVO
			                                                     ,SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * 저장 이벤트 처리<br>
	 * VVD Check With AR List 저장 이벤트 처리<br>
	 * ESM_COA_0112 저장
	 * @param CoaMonVvdVO[] coaMonVvdVO
	 * @param SearchConditionVO searchConditionVO
	 * @param SearchVVDChkWithARListVO[] searchVVDChkWithARListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiVVDChkWithARList(CoaMonVvdVO[] coaMonVvdVO, SearchConditionVO searchConditionVO, SearchVVDChkWithARListVO[] searchVVDChkWithARListVO, SignOnUserAccount account) throws EventException;
	

	/**
	 * 조회 이벤트 처리<br>
	 * Month VVD I/F 조회 이벤트 처리<br>
	 * ESM_COA_0112 조회
	 * @param SearchVVDChkWithARListVO	searchVVDChkWithARListVO
	 * @exception EventException
	 */
	public void multiMonthVVDIFStatus(SearchVVDChkWithARListVO searchVVDChkWithARListVO) throws EventException;
	
}