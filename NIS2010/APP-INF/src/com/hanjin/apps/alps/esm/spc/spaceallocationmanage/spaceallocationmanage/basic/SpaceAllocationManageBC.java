/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpaceAllocationManageBC.java
*@FileTitle : Allocation Change by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2009.07.29 최윤성
* 1.0 Creation
History ------------------------------------------
2010.08.27 이행지 [CHM-201005552-01] Allocation Control by Main Office 화면 Remark 기능 보완
                                   - Remark 가능한 Office인지 체크하기
2011.05.03 이석준 [CHM-201110568-01] Bottleneck Check 화면 조건 보완
                                   - SearchSpaceAllocationManage045VVDInfo method 추가                                       
2011.08.08 이행지 [CHM-201112741-01] Control by HO/RHQ 화면 보완 1차 - 주차별 CMB 항목 조회되도록 수정
2011.08.16 이행지 [CHM-201112741-01] Control by HO/RHQ 화면 보완 2차 - WAFIE Allocation 팝업 추가
2011.08.25 김종준 [CHM-201113071-01] control by HO/RHQ 화면과 COA 링크 팝업 추가
2011.09.15 이행지 [CHM-201113449-01] COA 링크 화면 보완 - 메소드명 변경
2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
2013.06.26 진마리아 [CHM-201325016-01] 성수기 Alloc copy 기능 개발
2014.01.03 진마리아 [SRM-201341166] Yield Group의 확대
2014.12.08 신자영 [CHM-201433097] Control Option - A/C 및 CDMT추가 건 상세
2015.01.02 Arie [CHM-201433401]Control Option Registration - Upload기능 추가 요청
2015.03.25 박은주 [CHM-201534916] Allocation by HO/RHQ 의 Edit기능에 Yield Group추가 요청 ->Sync 옵션추가
2015.06.11 김성욱 [CHM-201535211] SPC BKG 연동
2015.06.24 이혜민 [CHM-201535810] [SPC] Fixed Rate 계약 정보의 SPC 적용 개발 요청 
=========================================================
*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SalesRPTCommonVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchActualCustomerVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSPCAllocBKGListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0033LaneRgstVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0042MListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0053ManageListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchVesselSKDListVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SpaceAllocationManageSummaryVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SpaceAllocationManageVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SpcAlocCtrlOptVO;
import com.hanjin.syscommon.common.table.SpcAlocCustPolPodVO;
import com.hanjin.syscommon.common.table.SpcAlocPolPodVO;
import com.hanjin.syscommon.common.table.SpcFcastDwnLodSkdVO;
import com.hanjin.syscommon.common.table.SpcMdlVerMstVO;
import com.hanjin.syscommon.common.table.SpcNshwRsltVO;

/**
 * ALPS-Spaceallocationmanage Business Logic Command Interface<br>
 * - ALPS-Spaceallocationmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CHOI Yun Sung
 * @see Esm_spc_0042EventResponse 참조
 * @since J2EE 1.6
 */

public interface SpaceAllocationManageBC {

	/**
	 * [ESM_SPC_0042]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocationDetailList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_SPC_0042]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0042MListVO>
	 * @exception EventException
	 */
	public List<SearchSpaceAllocation0042MListVO> searchSpaceAllocationMasterList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0042]을 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocPolPodVO[] spcAlocPolPodVO
	 * @param account SignOnUserAccount
	 * @param ConditionVO conditionVO
	 * @return List<SearchSPCAllocBKGListVO>
	 * @exception EventException
	 */
	public List<SearchSPCAllocBKGListVO> multiSpaceAllocation(SpcAlocPolPodVO[] spcAlocPolPodVO, SignOnUserAccount account, ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0042]을 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocCustPolPodVO[] spcAlocCustPolPodVO
	 * @param account SignOnUserAccount
	 * @param ConditionVO conditionVO
	 * @return List<SearchSPCAllocBKGListVO>
	 * @exception EventException
	 */
	public List<SearchSPCAllocBKGListVO> multiSpaceAllocationSmp(SpcAlocCustPolPodVO[] spcAlocCustPolPodVO, SignOnUserAccount account, ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0042]을 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocCtrlOptVO[] spcAlocCtrlOptVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiControlOption(SpcAlocCtrlOptVO[] spcAlocCtrlOptVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [ESM_SPC_0065]을 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocPolPodVO[] spcAlocPolPodVO
	 * @param account SignOnUserAccount
	 * @param Event e
	 * @exception EventException
	 */
	public void multiSpaceAllocationManageTemp(SpcAlocPolPodVO[] spcAlocPolPodVO, SignOnUserAccount account, Event e) throws EventException;
	
	/**
	 * [ESM_SPC_0066]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocationManageTempList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0071]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SearchVesselSKDListVO> searchVesselSKDList(ConditionVO conditionVO) throws EventException;

	/**
	 * [ESM_SPC_0044]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocation0044MasterList(
			ConditionVO conditionVO) throws EventException;

	/**
	 * [ESM_SPC_0044]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocation0044DetailList(
			ConditionVO conditionVO) throws EventException;

	/**
	 * [ESM_SPC_0044]을 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocPolPodVO[] spcAlocPolPodVOS
	 * @param account SignOnUserAccount
	 * @return List<SearchSPCAllocBKGListVO>
	 * @exception EventException
	 */
	public List<SearchSPCAllocBKGListVO> multiSpaceAllocation0044Manage(
			SpcAlocPolPodVO[] spcAlocPolPodVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * [ESM_SPC_0044]을 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocCustPolPodVO[] spcAlocCustPolPodVO
	 * @param SignOnUserAccount account
	 * @param ConditionVO conditionVO
	 * @return List<SearchSPCAllocBKGListVO>
	 * @exception EventException
	 */
	public List<SearchSPCAllocBKGListVO> multiSpaceAllocation0044ManageSMP(SpcAlocCustPolPodVO[] spcAlocCustPolPodVO, SignOnUserAccount account, ConditionVO conditionVO) throws EventException;

	/**
	 * [ESM_SPC_0045]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocationManage045VVDList(
			ConditionVO conditionVO) throws EventException;

	/**
	 * [ESM_SPC_0045]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocationManage045VVDInfo(
			ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0045]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocationManage045QtyList(
			ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0047]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocation0047MasterList(
			ConditionVO conditionVO) throws EventException;

	/**
	 * [ESM_SPC_0047]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocation0047DetailList(
			ConditionVO conditionVO) throws EventException;

	/**
	 * [ESM_SPC_0047]을 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocPolPodVO[] spcAlocPolPodVOS
	 * @param SignOnUserAccount account
	 * @param ConditionVO conditionVO
	 * @return List<SearchSPCAllocBKGListVO>
	 * @exception EventException
	 */
	public List<SearchSPCAllocBKGListVO> multiSpaceAllocation0047Manage(SpcAlocPolPodVO[] spcAlocPolPodVOS, SignOnUserAccount account, ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0047]을 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocCustPolPodVO[] spcAlocCustPolPodVO 
	 * @param SignOnUserAccount account
	 * @param ConditionVO conditionVO
	 * @return List<SearchSPCAllocBKGListVO>
	 * @exception EventException
	 */
	public List<SearchSPCAllocBKGListVO> multiSpaceAllocation0047ManageSmp(SpcAlocCustPolPodVO[] spcAlocCustPolPodVO, SignOnUserAccount account, ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0053]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0053ManageListVO>
	 * @exception EventException
	 */
	public List<SearchSpaceAllocation0053ManageListVO> searchSpaceAllocationManageList(
			ConditionVO conditionVO) throws EventException;
	
	
	/**
	 * [ESM_SPC_0054]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSpaceAllocation0054ManageListVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocationModelRun0054List(
			ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0041]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocationModelList(
			ConditionVO conditionVO) throws EventException;

	/**
	 * [ESM_SPC_0070]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchNoShowAdjustmentList(
			ConditionVO conditionVO) throws EventException;


	/**
	 * [ESM_SPC_0070]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchNoShowDownloadDateList(
			ConditionVO conditionVO) throws EventException;

	/**
	 * [ESM_SPC_0070]을 [행위] 합니다.<br>
	 * 
	 * @param SpcNshwRsltVO[] SpcNshwRsltVOS
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiNoShowAdjustment(
			SpcNshwRsltVO[] SpcNshwRsltVOS, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_SPC_0070]을 [행위] 합니다.<br>
	 * 
	 * @param SpcFcastDwnLodSkdVO[] spcFcastDwnLodSkdVOS
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiForcastDownloadDate(
			SpcFcastDwnLodSkdVO[] spcFcastDwnLodSkdVOS, SignOnUserAccount account) throws EventException;

	/**
	 * [ESM_SPC_0044]을 [행위] 합니다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	public String searchRemarkFlagOffice(String ofcCd) throws EventException;
	
	/**
	 * [ESM_SPC_0042, ESM_SPC_0047]을 Weekly CMB 4주를 표현하기 위한 Header.<br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchWeek() throws EventException;
	
	/**
	 * [ESM_SPC_0048]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpcAlocPolPodVO>
	 * @exception EventException
	 */
	public List<SpcAlocPolPodVO> searchWAFAlloc(ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0048]을 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocPolPodVO[] spcAlocPolPodVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiWAFAlloc(SpcAlocPolPodVO[] spcAlocPolPodVO, SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Inquiry by Customized Condition화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SearchConditionVO searchVo
	 * @param SalesRPTCommonVO vo
	 * @param String userId
	 * @return SalesRPTCommonVO
	 * @exception EventException
	 */
	public SalesRPTCommonVO searchInqByCondition0049List(SearchConditionVO searchVo, SalesRPTCommonVO vo, String userId) throws EventException;

    /**
     * group code 목록을 조회한다. 
     *
     * @param SearchConditionVO searchVo
     * @param SalesRPTCommonVO vo
     * @param String userId
     * @return SalesRPTCommonVO
     * @exception EventException
     */ 
	public SalesRPTCommonVO searchInqByCondition0049List2(SearchConditionVO searchVo, SalesRPTCommonVO vo, String userId) throws EventException;
	
	/**
	 * [ESM_SPC_0049]을 Select Customized RPT Form 조회.<br>
	 *	
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchRptFormList(SignOnUserAccount account) throws EventException;
	

	/**
	 * [ESM_SPC_0046]을 [행위] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SearchSpaceAllocation0042MListVO> searchSpaceAllocation0046List(
			ConditionVO conditionVO) throws EventException;

	
	/**
	 * [ESM_SPC_0046]을 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocPolPodVO[] spcAlocPolPodVO
	 * @param String grpAcct
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiSpaceAllocation0046ManageByHO(
			SpcAlocPolPodVO[] spcAlocPolPodVO, String grpAcct, SignOnUserAccount account) throws EventException;


	/**
	 * [ESM_SPC_0046]을 [행위] 합니다.<br>
	 * 
	 * @param SpcAlocPolPodVO[] spcAlocPolPodVO
	 * @param String grpAcct
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiSpaceAllocation0046ManageByRHQ(
			SpcAlocPolPodVO[] spcAlocPolPodVO, String grpAcct, SignOnUserAccount account) throws EventException;


	/**
	 * TRD, SUB TRD, VVD, 주차에 해당하는 정보를 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageSummaryVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageSummaryVO> searchStatusByVvd(ConditionVO conditionVO) throws EventException;
	
	/**
	 * TRD, SUB TRD, OFC, 주차에 해당하는 항차들의 정보를 조회합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SpaceAllocationManageSummaryVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageSummaryVO> searchStatusByLofc(ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ESM_SPC_0033]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO
	 * @return List<SearchSpaceAllocation0033LaneRgstVO>
	 * @exception EventException
	 */
	public List<SearchSpaceAllocation0033LaneRgstVO> searchSpaceAllocation0033LaneRgstList(SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO) throws EventException;
	
	/**
	 * [ESM_SPC_0033]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO
	 * @return List<SearchSpaceAllocation0033LaneRgstVO>
	 * @exception EventException
	 */
	public List<SearchSpaceAllocation0033LaneRgstVO> searchSpaceAllocation0033LanePortRgstList(SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO) throws EventException;
	
	/**
	 * [ESM_SPC_0033]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO
	 * @return List<SearchSpaceAllocation0033LaneRgstVO>
	 * @exception EventException
	 */
	public List<SearchSpaceAllocation0033LaneRgstVO> searchSpaceAllocation0033VVDLaneRgstList(SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO) throws EventException;
	
	/**
	 * [ESM_SPC_0033]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO
	 * @return List<SearchSpaceAllocation0033LaneRgstVO>
	 * @exception EventException
	 */
	public List<SearchSpaceAllocation0033LaneRgstVO> searchSpaceAllocation0033VVDLanePortRgstList(SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO) throws EventException;
	
	/**
	 * [ESM_SPC_0033]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO
	 * @return List<SearchSpaceAllocation0033LaneRgstVO>
	 * @exception EventException
	 */
	public List<SearchSpaceAllocation0033LaneRgstVO> searchSpaceAllocation0033BSACapaList(SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO) throws EventException;
	
	/**
	 * [ESM_SPC_0033]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO
	 * @return List<SearchSpaceAllocation0033LaneRgstVO>
	 * @exception EventException
	 */
	public List<SearchSpaceAllocation0033LaneRgstVO> searchSpaceAllocation0033BSACapaByPort(SearchSpaceAllocation0033LaneRgstVO searchSpaceAllocation0033LaneRgstVO) throws EventException;
	
	/**
	 * [ESM_SPC_0070]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO[] searchSpaceAllocation0033LaneRgstVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiSpaceAllocation0033LaneRgstList(SearchSpaceAllocation0033LaneRgstVO[] searchSpaceAllocation0033LaneRgstVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * [ESM_SPC_0070]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO[] searchSpaceAllocation0033LaneRgstVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiSpaceAllocation0033LanePortRgstList(SearchSpaceAllocation0033LaneRgstVO[] searchSpaceAllocation0033LaneRgstVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * [ESM_SPC_0070]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO[] searchSpaceAllocation0033LaneRgstVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiSpaceAllocation0033VVDLaneRgstList(SearchSpaceAllocation0033LaneRgstVO[] searchSpaceAllocation0033LaneRgstVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * [ESM_SPC_0070]을 [행위] 합니다.<br>
	 * 
	 * @param SearchSpaceAllocation0033LaneRgstVO[] searchSpaceAllocation0033LaneRgstVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiSpaceAllocation0033VVDLanePortRgstList(SearchSpaceAllocation0033LaneRgstVO[] searchSpaceAllocation0033LaneRgstVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Season 내 first version의 confirm시 Alloc 데이터 정리<br>
	 * 
	 * @param SpcMdlVerMstVO spcMdlVerMstVO
	 * @exception EventException
	 */
	public void multiCustCtrlAlloc(SpcMdlVerMstVO spcMdlVerMstVO) throws EventException;
	
	
	/**
	 * [ESM_SPC_0073]을 [행위] 합니다.
	 * 
	 * @param SearchActualCustomerVO searchActualCustomerVO
	 * @return List<SearchActualCustomerVO>
	 * @exception EventException
	 */
	public List<SearchActualCustomerVO> searchActualCustomer(SearchActualCustomerVO searchActualCustomerVO) throws EventException;

	/**
	 * [ESM_SPC_0042]을 [행위] 합니다.<br>
	 * doRowSearch 시에 사용하고 있음
	 * 
	 * @param ConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @return List<SpaceAllocationManageVO>
	 * @exception EventException
	 */
	public List<SpaceAllocationManageVO> searchSpaceAllocationControlFlagList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	


}