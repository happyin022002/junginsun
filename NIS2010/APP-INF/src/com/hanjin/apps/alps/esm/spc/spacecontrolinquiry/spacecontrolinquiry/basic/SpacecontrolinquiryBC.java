/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpacecontrolinquiryBC.java
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.10 한상훈
* 1.0 Creation
* 2010.08.25 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 - 메소드 추가
* 2010.08.26 김민아 [CHM-201005553-01] RDR 실적 중 POL/POD 세부 Data Download 기능 개발 - 메소드 추가
* 2010.10.19 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발.
* 2011.11.22 김종준 [CHM-201007116] Weekly L/F by POL/POD 화면 - 기능추가 개발
* 2011.06.01 김종준 [CHM-201110708-01] F"cast 입력 요청 메세지 송부 기능 createSendMail 추가
* 2011.10.12 김종준 [CHM-201113896-01] Login Office가 ISTSC인 경우에는 Origin Office가 아닌 Login Office가 Loading Office와 일치할 경우 Alloc 이 조회될 수 있도록 수정 요청
* 2012.12.04 최윤성 [CHM-201221640-01] FCST&PFMC by ACCT 신규 탭 추가
* 2013.10.30 최윤성 [CHM-201327083-01] IPC Sector 판매 활성화 Tool 개발 - Space Utilization 화면 신규 개발
* 2016.05.12 이혜민 CHM-201640880 T/S History 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ComplexMainVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ExcelDownSpaceUtilizationPortListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.ExcelDownSpaceUtilizationLaneListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiry021SusrLaneViewListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryConditionVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceUtilizationListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchWeeklyLfByPolPodListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SpaceControlInquiryVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchTsPlanGuideListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SpcBsaMgmtVO;
import com.hanjin.syscommon.common.table.SpcTeamQtaRtoVO;
import com.hanjin.syscommon.common.table.SpcTgtVvdVO;


/**
 * ALPS-Spacecontrolinquiry Business Logic Command Interface<br>
 * - ALPS-Spacecontrolinquiry에 대한 비지니스 로직에 대한 인터페이스<br>
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
	 * @param String ui_name
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiry021AllocPortViewList2(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account, String ui_name) throws EventException;
	
	/**
	 * [ESM_SPC_0021]을 [행 위] 합니다.<br>
	 * SHKIM 20120613
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @param String ui_name
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiry021AllocPortViewList3(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account, String ui_name) throws EventException;
	
	/**
	 * [ESM_SPC_0021]을 [행 위] 합니다.<br>
	 * SHKIM 20120613
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @param String ui_name
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiry021PfmcRatio(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account, String ui_name) throws EventException;


	/**
	 * [ESM_SPC_0021]을 [행 위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @param String ui_name
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiry021AllocPortViewList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account, String ui_name) throws EventException;
	
	/**
	 * [ESM_SPC_0021-SPC_USR_LANE_INFO]을 [조회] 합니다.<br> 2012.01.19 SHKIM
	 * 
	 * @param SearchSpaceControlInquiry021SusrLaneViewListVO	search021SusrLaneViewListVO
	 * @param account SignOnUserAccount
	 * @param String ui_name
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<SearchSpaceControlInquiry021SusrLaneViewListVO> searchSpaceControlInquiry021SusrLaneViewList(SearchSpaceControlInquiry021SusrLaneViewListVO search021SusrLaneViewListVO, SignOnUserAccount account, String ui_name) throws EventException;
	
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
	
	/*=====================================================================================
	 * 2010.08.26 김민아 [CHM-201005553-01] RDR 실적 중 POL/POD 세부 Data Download 조회 메소드 추가
	 *=====================================================================================*/
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
	
	/**
	 * [ESM_SPC_0084]을 BSA INPUT DATA를 저장 합니다.<br>
	 * @param SpcBsaMgmtVO[] spcBsaMgmtVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void multiSpaceContorlInquiryBSA( SpcBsaMgmtVO[] spcBsaMgmtVOs, SignOnUserAccount signOnUserAccount) throws EventException;


	/**
     * F'cast 입력 요청 메세지 송부 기능 이벤트 처리<br>
     * 
     * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
	public String createSendMail(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account) throws EventException;

	/**
     * [ESM_SPC_0042] 선택한 Lane 정보를 저장합니다.<br>
     * @param SearchSpaceControlInquiry021SusrLaneViewListVO searchSpaceControlInquiry021SusrLaneViewListVO
     * @param SignOnUserAccount account
     * @param String ui_name
     * @exception EventException
     */
	public void searchSpaceControlInquiry021SusrLaneUpdate(	SearchSpaceControlInquiry021SusrLaneViewListVO searchSpaceControlInquiry021SusrLaneViewListVO,	SignOnUserAccount account, String ui_name) throws EventException;


	/**
	 * [ESM_SPC_0021]을 [행 위] 합니다.<br>
	 * SHKIM 20120613
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @param String ui_name
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiry021AllocPortViewList4(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account, String ui_name) throws EventException;


	/**
	 * [ESM_SPC_0021]을 [행 위] 합니다.<br>
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @param String ui_name
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiry021AllocPortViewList5(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account, String ui_name) throws EventException;

	/**
	 * [ESM_SPC_0021]을 [행 위] 합니다.<br>
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @param String ui_name
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiry021AllocPortViewList6(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account, String ui_name) throws EventException;
	
	/**
	 * [ESM_SPC_0021]을 [행 위] 합니다.<br>
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @param account SignOnUserAccount
	 * @return List<ComplexMainVO>
	 * @exception EventException
	 */
	public List<ComplexMainVO> searchSpaceControlInquiry021FcstPfmcAcctViewList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO, SignOnUserAccount account) throws EventException;
	

	/**
	 * ESM_SPC_0086 : [Save] <br>
	 * 	Report에서 조회할 VVD List를 조회한다.
	 * 
	 * @param SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO
	 * @return List<ComplexMainVO>
	 * @throws EventException
	 */
	public List<ComplexMainVO> searchSpcTgtVvdList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException;


	/**
	 * ESM_SPC_0086 : [Save] 
	 *  Report에서 조회할 VVD List를 저장한다.
	 *  
	 * @param SpcTgtVvdVO[] spcTgtVvdVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiSpcTgtVvdList(SpcTgtVvdVO[] spcTgtVvdVOs,SignOnUserAccount account) throws EventException;


	/**
	 * ESM_SPC_0085 : [Save] 
	 *  한국지점 팀별 QTA RATIO를 저장한다.
	 *  
	 * @param SpcTeamQtaRtoVO[] spcTeamQtaRtoVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiSpcTeamQtaRtos(SpcTeamQtaRtoVO[] spcTeamQtaRtoVOs,SignOnUserAccount account) throws EventException;


	/**
	 * ESM_SPC_0085 : [Save] 
	 *  한국지점 팀별 QTA RATIO를 조회한다.
	 *  
	 * @param ConditionVO conditionVO
	 * @return List<ComplexMainVO>
	 * @throws EventException
	 */
	public List<ComplexMainVO> searchSpcTeamQtaRtoList(ConditionVO conditionVO) throws EventException;
	

	/**
	 * [ESM_SPC_0057]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @return List<SearchSpaceUtilizationListVO>
	 * @exception EventException
	 */
	public List<SearchSpaceUtilizationListVO> searchSpaceUtilizationList(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0057] : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다.
	 * 
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @param SignOnUserAccount account
	 * @return List<ExcelDownSpaceUtilizationPortListVO>
	 * @exception EventException
	 */
	public List<ExcelDownSpaceUtilizationPortListVO> excelDownSpaceUtilizationPort(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO,SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_SPC_0057] : Raw Data Export 이벤트 처리<br>
	 * Sheet 에 보여주지 않고 필수 조회조건에 해당하는 전체 Data Excel Down 합니다.
	 * 
	 * @param SearchSpaceControlInquiryConditionVO	searchSpaceControlInquiryConditionVO
	 * @param SignOnUserAccount account
	 * @return List<ExcelDownSpaceUtilizationLaneListVO>
	 * @exception EventException
	 */
	public List<ExcelDownSpaceUtilizationLaneListVO> excelDownSpaceUtilizationLane(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO,SignOnUserAccount account) throws EventException;

	
	/**
	 * [ESM_SPC_0058]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceControlInquiryVO>
	 * @exception EventException
	 */
	public List<SpaceControlInquiryVO> searchSpaceControlInquiry058VVDList(
			ConditionVO conditionVO) throws EventException;

	/**
	 * [ESM_SPC_0058]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceControlInquiryVO>
	 * @exception EventException
	 */
	public List<SpaceControlInquiryVO> searchSpaceControlInquiry058VVDInfo(
			ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0058]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceControlInquiryVO>
	 * @exception EventException
	 */
	public List<SpaceControlInquiryVO> searchSpaceControlInquiry058QtyList(
			ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SPC_0087 : [Retrieve]<br>
	 * [T/S Plan & guide main list]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchTsPlanGuideListVO>
	 * @exception EventException
	 */
	public List<SearchTsPlanGuideListVO> searchTsPlanGuideMainList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SPC_0087 : [Save] 전<br>
	 * [T/S Plan & guide Main]을 [저장] 전에 VSK 와 겹치는 목록이 있는지 확인한다.<br>
	 * 
	 * @param SearchTsPlanGuideListVO[] searchTsPlanGuideListVOs
	 * @return String[]
	 * @throws EventException
	 */
	public String[] searchTsPlanGuideDupVvd(SearchTsPlanGuideListVO[] searchTsPlanGuideListVOs) throws EventException;
	
	/**
	 * ESM_SPC_0087 : [Save]<br>
	 * [T/S Plan & guide Main]을 [저장]합니다.<br>
	 * 
	 * @param SearchTsPlanGuideListVO[] searchTsPlanGuideListVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageTsPlanGuideMainList(SearchTsPlanGuideListVO[] searchTsPlanGuideListVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SPC_0087 : [Sheet1 Dbl Click]<br>
	 * [T/S Plan & guide detail list]을 [조회]합니다.<br>
	 * 
	 * @param SearchTsPlanGuideListVO searchTsPlanGuideListVO
	 * @return List<SearchTsPlanGuideListVO>
	 * @exception EventException
	 */
	public List<SearchTsPlanGuideListVO> searchTsPlanGuideDetailList(SearchTsPlanGuideListVO searchTsPlanGuideListVO) throws EventException;
	
	/**
	 * ESM_SPC_0087 : [Sheet1,2 onChange]<br>
	 * [T/S Plan & guide vvd에 맞는 Sub trade, lane, BD, Week, Operator, Yard, ETD, Lane]을 [조회]합니다.<br>
	 * 
	 * @param SearchTsPlanGuideListVO searchTsPlanGuideListVO
	 * @return String[]
	 * @exception EventException
	 */
	public String[] searchTsPlanGuideValidData(SearchTsPlanGuideListVO searchTsPlanGuideListVO) throws EventException;
	
	/**
	 * ESM_SPC_0087 : [Save]<br>
	 * [T/S Plan & guide Detail]을 [저장]합니다.<br>
	 * 
	 * @param SearchTsPlanGuideListVO[] searchTsPlanGuideListVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageTsPlanGuideDetailList(SearchTsPlanGuideListVO[] searchTsPlanGuideListVOs, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_SPC_0087 : [Sheet1 onChange]<br>
	 * [T/S Plan & guide vvd에 맞는 Rlane 목록]을 [조회]합니다.<br>
	 * 
	 * @param SearchTsPlanGuideListVO searchTsPlanGuideListVO
	 * @return List<SearchTsPlanGuideListVO>
	 * @throws EventException
	 */
	public List<SearchTsPlanGuideListVO> searchTsPlanGuideVvdRlane(SearchTsPlanGuideListVO searchTsPlanGuideListVO) throws EventException;
	/**
	 * ESM_SPC_0088 : [Load Page]<br>
	 * [T/S Plan & guide Attach list]을 [조회]합니다.<br>
	 * 
	 * @param SearchTsPlanGuideListVO searchTsPlanGuideListVO
	 * @return List<SearchTsPlanGuideListVO>
	 * @throws EventException
	 */
	public List<SearchTsPlanGuideListVO> searchTsPlanGuideAtchList(SearchTsPlanGuideListVO searchTsPlanGuideListVO) throws EventException;
	
	/**
	 * ESM_SPC_0088 : [upload]<br>
	 * [T/S Plan & guide Attach]을 [저장]합니다.<br>
	 * 
	 * @param SearchTsPlanGuideListVO[] searchTsPlanGuideListVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageTsPlanGuideAtch(SearchTsPlanGuideListVO[] searchTsPlanGuideListVOs, SignOnUserAccount account) throws EventException;
	
}
