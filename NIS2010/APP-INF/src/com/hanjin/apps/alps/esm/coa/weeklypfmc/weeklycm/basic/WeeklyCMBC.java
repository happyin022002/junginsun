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
* 2008.07.23 전성진 CSR No.N200807230006
*					- SUM 단가 저장 기능 추가
* 2008.08.29 박은주 CSR No. N200807298360 Expense Detail로 테이블 변경하면서 화면단 모두 변경[060,062]   
* 2008.09.08 전윤주 115번 화면 사용하지 않는 Method 삭제 
* 2009.09.04 박수훈 0030(029S)화면 New FrameWork 적용
* 2009.09.10 박수훈 0112화면 New FrameWork 적용
* 2009.09.16 박수훈 0115 화면 New FrameWork 적용
* 2009.09.18 박수훈 0117 화면 New FrameWork 적용
* 2009.09.30 박수훈 0118 화면 New FrameWork 적용
* 2009.10.09 박수훈 0119 화면 New FrameWork 적용
* 2010.01.11 김기식 0175 화면 New FrameWork 적용
* 2011.06.02 최성민 [CHM-201111115-01] Split 02-Split 03-ALPS Error 처리 요청 - BackEndJob으로 변환
* 2012.07.17 이석준 [CHM-201218919-01] SMU Cost (RA) 화면 Create 기능 추가    
* 2012.07.18 이석준 [CHM-201219046-01] [COA] Target VVD 배치 기능 추가 
* 2012.09.12 이석준 [CHM-201220073-01] EMU Cost (RA) 에 Month Copy 기능 추가
* 2013.05.08 성미영 [CHM-201324182] SMU 단가 화면 전월 copy 기능 추가
* 2014.04.10 최성민 [CHM-201429154] Target VVD BSA Flag 처리 후 BSA 시스템 연동 로직 변경 요청
=========================================================*/
package com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.CoaEMUCreditListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.MultiCoaMonVvdVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchEMUPfmcListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchOPCreditRtPortPairVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchOwnTMLPfmcListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchSMUPfmcListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchSeasonalSMUCostListVO;	//shkim0529
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchSeasonalSMUCostPopListVO;	//shkim0529
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchUOM0119ListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchVVDCheckListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchVVDChkWithARListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchWeeklyTargetVVD0030ListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.SearchWeeklyTargetVVDListVO;
import com.hanjin.apps.alps.esm.coa.weeklypfmc.weeklycm.vo.WeeklyCMCommonVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.CoaInterOwnTmlCostVO;
import com.hanjin.syscommon.common.table.CoaLaneDirConvVO;	// 20120604 SHKIM
import com.hanjin.syscommon.common.table.CoaMonVvdVO;
import com.hanjin.syscommon.common.table.CoaSltMgmtUtVO;
import com.hanjin.syscommon.common.table.CoaTmlTrfGrpVO;
/**
 * eNIS-COA Business Logic Command Interface<br>
 * - eNIS-COA에 대한 비지니스 로직에 대한 인터페이스<br> 
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
     * @param MultiCoaMonVvdVO[] tVos
     * @param SignOnUserAccount account
     * @return EventResponse
     * @exception EventException
     */
	public EventResponse multiWeeklyTargetVVD(SearchConditionVO searchVo, WeeklyCMCommonVO vo, WeeklyCMCommonVO[] vos, MultiCoaMonVvdVO[] tVos, SignOnUserAccount account) throws EventException;
	
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
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
     */
	public String createTargetVVD(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * WeeklyCM화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0115.do 조회
	 * @param SearchEMUPfmcListVO	searchEMUPfmcListVO
	 * @param SearchConditionVO	searchConditionVO
	 * @return List<SearchEMUPfmcListVO>
	 * @exception EventException
	 */
	public List<SearchEMUPfmcListVO> searchEMUPfmcList(SearchEMUPfmcListVO searchEMUPfmcListVO
			                                          ,SearchConditionVO searchConditionVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * WeeklyCM화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0117 조회
	 * @param SearchSMUPfmcListVO	searchSMUPfmcListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchSMUPfmcListVO>
	 * @exception EventException
	 */
	public List<SearchSMUPfmcListVO> searchSMUPfmcList(SearchSMUPfmcListVO searchSMUPfmcListVO
			                                          ,SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * 저장 이벤트 처리<br>
	 * SMU 단가 화면에 대한 저장 이벤트 처리<br>
	 * ESM_COA_0117 저장
	 * @param CoaSltMgmtUtVO[] coaSltMgmtUtVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiSMUPfmc(CoaSltMgmtUtVO[] coaSltMgmtUtVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * WeeklyCM화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0120 조회
	 * @param SearchSeasonalSMUCostListVO	searchSeasonalSMUCostListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchSeasonalSMUCostListVO>
	 * @exception EventException
	 */
	public List<SearchSeasonalSMUCostListVO> searchSeasonalSMUCostList(SearchSeasonalSMUCostListVO searchSeasonalSMUCostListVO
			                                          ,SearchConditionVO searchConditionVO) throws EventException;
	/**
	 * 조회 이벤트 처리<br>
	 * WeeklyCM화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0121 조회
	 * @param SearchSeasonalSMUCostPopListVO	searchSeasonalSMUCostPopListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchSeasonalSMUCostPopListVO>
	 * @exception EventException
	 */
	public List<SearchSeasonalSMUCostPopListVO> searchLaneBoundSwitchList(SearchSeasonalSMUCostPopListVO searchSeasonalSMUCostPopListVO
			                                          ,SearchConditionVO searchConditionVO) throws EventException;
	/**
	 * [Seasonal SMU Cost (RA) POPUP]을 [수정] 합니다.<br>
	 * 
	 * @param CoaLaneDirConvVO[] coaLaneDirConvVOs
	 * @param account SignOnUserAccount
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiLaneBoundSwitch(CoaLaneDirConvVO[] coaLaneDirConvVOs, SignOnUserAccount account) throws EventException;
//	/**
//	 * 저장 이벤트 처리<br>
//	 * SMU 단가 화면에 대한 저장 이벤트 처리<br>
//	 * ESM_COA_01120 저장
//	 * @param CoaSltMgmtUtVO[] coaSltMgmtUtVO
//	 * @param account SignOnUserAccount
//	 * @exception EventException
//	 */
//	public void multiSMUPfmc(CoaSltMgmtUtVO[] coaSltMgmtUtVO,SignOnUserAccount account) throws EventException;
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * ESM_COA_0118 조회
	 * @param SearchOwnTMLPfmcListVO searchOwnTMLPfmcListVO
	 * @param SearchConditionVO	searchConditionVO
	 * @return List<SearchOwnTMLPfmcListVO>
	 * @exception EventException
	 */
	public List<SearchOwnTMLPfmcListVO> searchOwnTMLPfmcList(SearchOwnTMLPfmcListVO searchOwnTMLPfmcListVO
			                                                ,SearchConditionVO searchConditionVO) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * WeeklyCM 화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0118 저장
	 * @param CoaInterOwnTmlCostVO[] coaInterOwnTmlCostVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiOwnTMLPfmc(CoaInterOwnTmlCostVO[] coaInterOwnTmlCostVO,SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * WeeklyCM화면에 대한 조회 이벤트 처리<br>
	 * ESM_COA_0119 화면 조회
	 * @param SearchUOM0119ListVO	searchUOM0119ListVO
	 * @return List<SearchUOM0119ListVO>
	 * @exception EventException
	 */
	public List<SearchUOM0119ListVO> searchUOM0119List(SearchUOM0119ListVO searchUOM0119ListVO) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * WeeklyCM화면에 대한 멀티 이벤트 처리<br>
	 * ESM_COA_0119 화면 수정, 추가
	 * @param CoaTmlTrfGrpVO[] coaTmlTrfGrpVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiUOM0119(CoaTmlTrfGrpVO[] coaTmlTrfGrpVO,SignOnUserAccount account) throws EventException;	

	/**
	 * WeeklyCM 주간 대상항차화면에 대한 조회 이벤트 처리.<br>
	 * ESM_COA_0030 화면
	 * @param SearchWeeklyTargetVVD0030ListVO	searchWeeklyTargetVVD0030ListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchWeeklyTargetVVD0030ListVO>
	 * @exception EventException
	 */
	public List<SearchWeeklyTargetVVD0030ListVO> searchWeeklyTargetVVD0030List(SearchWeeklyTargetVVD0030ListVO searchWeeklyTargetVVD0030ListVO
			                                                          ,SearchConditionVO searchConditionVO) throws EventException;

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
	 * 생성 이벤트 처리<br>
	 * NetworkCost화면에 대한 생성 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param String userId
	 * @return EventResponse ESM_COA_175EventResponse
	 * @exception EventException
	 */
	public EventResponse createFixCostByVVDOP4(SearchConditionVO searchVo, String userId) throws EventException;
			
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String object
	 * @return String
	 * @exception EventException
	 */
	public String searchBackEndJobStatus(String object) throws EventException;

	/**
	 * ESM_COA_0029 : 수동배치 처리 #1<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param String commandId
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
    public String dailyBatch(SearchConditionVO searchConditionVO, String commandId, SignOnUserAccount account) throws EventException;
	
	/**
	 * 1. 기능 : WeeklyCM 주간 대상항차관리 화면에 대한 Create 이벤트 처리(ESM_COA_0029)<p>
	 * 2. 처리개요 : <p>
	 *    - 주간 대상항차관리에 대한 Create처리<br> 
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param String commandId
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */	
	public String createTSQty(SearchConditionVO searchConditionVO, String commandId, SignOnUserAccount account) throws EventException;

	/**
	 * 1. 기능 : SMU 단가 관리 화면에서화면에 대한 Create 이벤트 처리(ESM_COA_0117)<p>
	 * 2. 처리개요 : <p>
	 *    - SMU 단가에 대한 Create처리<br> 
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void createSMUPfmc(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * 생성 이벤트 처리<br>
	 * EMU Cost를월단가를 복사해서 생성한다.<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createEMUCostMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_COA_0173 에서 호출 <br>
	 * SMU Cost를 월 단가를 복사해서 생성한다.<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void createSMUPfmcMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException;	

	/**
	 * Target VVD 화면에서 BSA Flag 나  Cost Week 정보를 변경했을 때 BSA 배치를 호출한다.<br>
	 * @param MultiCoaMonVvdVO[] multiVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiBsaDailyBatch(MultiCoaMonVvdVO[] multiVOs, SignOnUserAccount account) throws EventException;
	

	/**
	 * [EMU Credit Ratio&Amount]을 [조회] 합니다.<br>
	 * 
	 * @param SearchConditionVO searchConditionVO
	 * @return List<CoaEMUCreditListVO>
	 * @exception EventException
	 */
	public List<CoaEMUCreditListVO> searchEmuCreditTableList (SearchConditionVO searchConditionVO) throws EventException;

	
	
	/**
	 * Del Credit Ratio by Port-Pair.<br>
	 * ESM_COA_0222 화면 조회
	 * @param SearchOPCreditRtPortPairVO	searchOPCreditRtPortPairVO
	 * @param String queryType
	 * @return List<SearchOPCreditRtPortPairVO>
	 * @exception EventException
	 */
	public List<SearchOPCreditRtPortPairVO> searchCreditRtPortPairList(SearchOPCreditRtPortPairVO searchOPCreditRtPortPairVO,String queryType) throws EventException;	
}