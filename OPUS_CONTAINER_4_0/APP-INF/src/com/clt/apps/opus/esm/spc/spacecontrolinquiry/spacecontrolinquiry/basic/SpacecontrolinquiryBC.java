/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : SpacecontrolinquiryBC.java
*@FileTitle      : Spacecontrolinquiry
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.08.10
*@LastModifier   : 한상훈
*@LastVersion    : 1.0
* 2009.08.10
=========================================================*/
package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.basic;

import java.util.List;

import com.clt.apps.opus.esm.spc.common.common.vo.ConditionVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryConditionVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchWeeklyLfByPolPodListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SpcBsaMgmtVO;


/**
 * Spacecontrolinquiry Business Logic Command Interface<br>
 * - Spacecontrolinquiry에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Han Sang Hoon
 * @see Esm_spc_0021EventResponse 참조
 * @since J2EE 1.6
 */

public interface SpacecontrolinquiryBC {

	
	/**
	 * [ESM_SPC_0021]을 [행 위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiry021FcastPortViewList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException;


	/**
	 * [ESM_SPC_0021]을 [행 위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiry021AllocPortViewList2(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account) throws EventException;


	/**
	 * [ESM_SPC_0021]을 [행 위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiry021AllocPortViewList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_SPC_0022]을 [행 위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiryTradeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException;

	/**
	 * [ESM_SPC_0022]을 [행 위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquirySalesOrgList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException;

	/**
	 * [ESM_SPC_0022]을 [행 위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiryPolPodList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException;

	/**
	 * [ESM_SPC_0022]을 [행 위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiryCustomerList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_SPC_0022]을 [행 위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiryContractor(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException;

	/**
	 * [ESM_SPC_0024]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiryNoShowSummaryList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException;
	

	/**
	 * [ESM_SPC_0024]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiryNoShowTradeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException;

	/**
	 * [ESM_SPC_0024]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiryNoShowOfficeLaneList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException;
	

	/**
	 * [ESM_SPC_0024]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiryNoShowLaneOfficeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException;
	

	/**
	 * [ESM_SPC_0024]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiryNoShowSubOfficeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException;


	/**
	 * [ESM_SPC_0028]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiryOfficeList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException;


	/**
	 * [ESM_SPC_0028]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiryOfficeSalesOrgList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException;

	/**
	 * [ESM_SPC_0056]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlTsVolumnList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException;
	
	
	/**
	 * [ESM_SPC_0026]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO 
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiryList( ConditionVO conditionVO) throws EventException;
	
	
	/**
	 * [ESM_SPC_0080]을 [행위] 합니다.<br>
	 * 
	 * 2010.08.25 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 - 메소드 추가
	 * 
	 * @param ConditionVO conditionVO 
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlRDRSummaryList( ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0080]을 [행위] 합니다.<br>
	 * 
	 * 2010.08.25 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 - 메소드 추가
	 * 
	 * @param ConditionVO conditionVO 
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlRDRSummaryDown( ConditionVO conditionVO) throws EventException;

	/**
	 * [ESM_SPC_0081]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO 
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiryRDRDetailList( ConditionVO conditionVO) throws EventException;

	/**
	 * [ESM_SPC_0082]을 [행위] 합니다.<br>
	 * 
	 * 2010.10.19 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발.
	 * 
	 * @param ConditionVO conditionVO 
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlLFSummaryList( ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0082]을 [행위] 합니다.<br>
	 * 
	 * 2010.10.19 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발.
	 * 
	 * @param ConditionVO conditionVO 
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlLFSummaryDown( ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0183]을 Weekly L/F by POL/POD 리스트를 조회 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO 
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchWeeklyLfByPolPodList( ConditionVO conditionVO) throws EventException;

	
	/**
	 * [ESM_SPC_0083]의 주어진 기간의 주차,년월 목록을 조회<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchLoadingByPolPodListVO>
	 * @exception EventException
	 */
	public List<SearchWeeklyLfByPolPodListVO> searchMonthWeekList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0084]을 BSA INPUT DATA 조회 합니다.<br> 
	 * @param SpcBsaMgmtVO spcBsaMgmtVO 
	 * @return List<SpcBsaMgmtVO>
	 * @exception EventException
	 */
	public List<SpcBsaMgmtVO> searchSpaceContorlInquiryBSA( SpcBsaMgmtVO spcBsaMgmtVO) throws EventException;

}