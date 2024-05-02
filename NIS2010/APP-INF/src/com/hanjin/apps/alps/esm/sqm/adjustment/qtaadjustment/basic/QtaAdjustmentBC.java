/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : QtaAdjustmentBC.java
*@FileTitle      : QtaAdjustment
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.30
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.30 SQM USER
* 1.0 Creation
* 2013.10.21 PEJ [CHM-201327263] Figure Inquiry  조회 팝업 추가
*                        searchPotnFigureInquiryList 메소드 추가
* 2013.12.10 PEJ [CHM-201328059] QTA Edit_Office Add 팝업 추가
* 2014.09.25 이혜민 [CHM-201431935] Portion Adjustment 화면의 From, TO VVD 입력 시 Portion Connected <> 'I' 인 VVD alert.
* 2015.02.23 이혜민 [CHM-201534159] Alloc = QTA 화면 내 Alloc Delete 기능 추가
* 2015.05.15 이혜민 [CHM-201535608] Adjustment 화면 3개 Creation전 RHQ별 Portion 존재하고, 
									Office portion이 없는 List 조회.
* 2015.07.22 김용습 [CHM-201537172] [CSR 전환건] QTA Adjustment by VVD 화면 내 신규 기능 추가	
* 2015.10.01 김용습 [CHM-201537934] [CSR 전환건] Allocation = QTA의 "SPC Alloc Apply" 로직 수정			
* 2015.10.06 김용습 [CHM-201538196] Portion Adjustment by RHQ, Head Office 화면 내 해당 분기 값만 입력 가능토록 Validation 설정		
* 2015.12.09 김용습 [CHM-201539254] VVD Adjustment, VVD Adjustment for IAS Sector에서 Currently Updated에서 BSA 매뉴얼로 수정가능하도록 로직 수정.	
* 2016.01.15 CHM-201639770 VVD Adjustment의 Update Option 추가 CSR		
* 2016.03.23 CHM-201640708 Office별 포션 자동 입력 로직 수정
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.ManageQtaAdjustmentVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.ManageQtaEditIasSectorVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchAllocQtaListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchLaneOfficeListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchPotnAdjustmentListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchPotnFigureInquiryListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchQtaAdjustmentForSectorListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchQtaAdjustmentListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchQtaEditListVO;
import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SqmAlocQtaVO;
import com.hanjin.syscommon.common.table.SqmCfmQtaVO;
import com.hanjin.syscommon.common.table.SqmSctrCfmQtaVO;

/**
 * ALPS-QtaAdjustment Business Logic Command Interface<br>
 * - ALPS-QtaAdjustment 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SQM USER
 * @see
 * @since J2EE 1.6
 */
public interface QtaAdjustmentBC {
	
	/**
	 * ESM_SQM_0031 : Retrieve 이벤트 처리<br>
	 * [QTA Adjustment by VVD]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaAdjustmentListVO>
	 * @throws EventException
	 */
	public List<SearchQtaAdjustmentListVO> searchQtaAdjustmentList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0031 : SEARCH03 이벤트 처리<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaAdjustmentListVO>
	 * @throws EventException
	 */
	public List<SearchQtaAdjustmentListVO> findVvdFromOtherQuarter(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0031 : COMMAND02 이벤트 처리<br>
	 * [QTA Adjustment by VVD]와 [Portion adjustment by Head Office]와의 결과 비교
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaAdjustmentListVO>
	 * @throws EventException
	 */
	public List<SearchQtaAdjustmentListVO> comparisonWithHo(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0031 : COMMAND03 이벤트 처리<br>
	 * [QTA Adjustment by VVD]와 [Portion adjustment by RHQ]와의 결과 비교
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaAdjustmentListVO>
	 * @throws EventException
	 */
	public List<SearchQtaAdjustmentListVO> comparisonWithRhq(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0031 : MULTI 이벤트 처리<br>
	 * [QTA Adjustment by VVD]을 [조회] 합니다.
	 * 
	 * @param ManageQtaAdjustmentVO[] manageQtaAdjustmentVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaAdjustment(ManageQtaAdjustmentVO[] manageQtaAdjustmentVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0031 : MULTI01 이벤트 처리<br>
	 * [QTA Adjustment by VVD]을 [저장] 합니다.
	 * 
	 * @param ManageQtaAdjustmentVO[] manageQtaAdjustmentVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void saveSupply(ManageQtaAdjustmentVO[] manageQtaAdjustmentVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0031,0032,0033 : Creation 이벤트 처리<br>
	 * Adjustment화면에서 Creation 전 RHQ에는 Portion을 부여했으나 해당 RHQ 산하의 Office에게 Portion을 부여하지 않은 RHQ List를 조회합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<String>
	 * @exception EventException
	 */
	public List<String> searchOfcZeroPortion(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0032 : [이벤트]<br>
	 * [Portion Adjustment]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchPotnAdjustmentListVO>
	 * @throws EventException
	 */
	public List<SearchPotnAdjustmentListVO> searchPotnAdjustmentList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0032 : [이벤트]<br>
	 * [Portion Adjustment]을 [저장] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SearchPotnAdjustmentListVO[] searchPotnAdjustmentListVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void managePotnAdjustment(ConditionVO conditionVO, SearchPotnAdjustmentListVO[] searchPotnAdjustmentListVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0032 : MULTI02 이벤트 처리<br>
	 * [Portion Adjustment]를 [생성] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchPotnAdjustmentListVO>
	 * @throws EventException
	 */
	public List<SearchPotnAdjustmentListVO> searchRhqGroupRowAdd(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0032 : SEARCH01 이벤트 처리<br>
	 * [Portion Adjustment]에서 vvd의 주차를 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String vvd
	 * @return String[]
	 * @throws EventException
	 */
	public String[] searchApplyWeek(ConditionVO conditionVO, String vvd) throws EventException;
	
	/**
	 * ESM_SQM_0032 : SEARCH02 이벤트 처리<br>
	 * [Portion Adjustment by Head Office]에서 vvd 입력 시 해당 VVD가 Alloc 적용됐거나 QTA Edit에서 매뉴얼로 수정되었는지 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<String>
	 * @throws EventException
	 */
	public List<String> searchVvdCngTpCd(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0032 : MULTI01 이벤트 처리<br>
	 * [Portion Adjustment HO]에서 확정데이터를 [재생성] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createPotnAdjustmentByHO(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0033 : MULTI01 이벤트 처리<br>
	 * [Portion Adjustment RHQ]에서 확정데이터를 [재생성] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createPotnAdjustmentByRHQ(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0034 : Retrieve 이벤트 처리<br>
	 * [Qta Edit]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaEditListVO>
	 * @throws EventException
	 */
	public List<SearchQtaEditListVO> searchQtaEditList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0034 : MULTI 이벤트 처리<br>
	 * [Qta Edit]을을 [저장] 합니다.
	 * 
	 * @param SqmCfmQtaVO[] sqmCfmQtaVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaEdit(SqmCfmQtaVO[] sqmCfmQtaVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0034 : MULTI01 이벤트 처리<br>
	 * [CMCB adjust]을을 [생성] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws EventException
	 */
	public void createCmcbAdjust(ConditionVO conditionVO, String usrId) throws EventException;
	
	/**
	 * ESM_SQM_0035 : Retrieve 이벤트 처리<br>
	 * [Allocation = QTA Setting]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchAllocQtaListVO>
	 * @throws EventException
	 */
	public List<SearchAllocQtaListVO> searchAllocQtaList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_SQM_0035 : MULTI 이벤트 처리<br>
	 * [Allocation = QTA Setting]을을 [저장] 합니다.
	 * 
	 * @param SqmAlocQtaVO[] sqmAlocQtaVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageAllocQta(SqmAlocQtaVO[] sqmAlocQtaVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0035 : MULTI01 이벤트 처리<br>
	 * [Allocation = QTA Setting]을을 [confirm] 합니다.
	 * 
	 * @param SqmAlocQtaVO[] sqmAlocQtaVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaEditForAlloc(SqmAlocQtaVO[] sqmAlocQtaVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0035 : MULTI02 이벤트 처리<br>
	 * [Allocation = QTA Setting]을을 [delete] 합니다.
	 * 
	 * @param SqmAlocQtaVO[] sqmAlocQtaVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void deleteQtaEditForAlloc(SqmAlocQtaVO[] sqmAlocQtaVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_SQM_0035 : MULTI03 이벤트 처리<br>
	 * [Allocation = QTA Setting]을 [activate] 합니다.
	 * 
	 * @param SqmAlocQtaVO[] sqmAlocQtaVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void activateData(SqmAlocQtaVO[] sqmAlocQtaVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * SPC ALOC 정보를 I/F.
	 * 
	 * @param String trd_cd
	 * @param String rlane_cd
	 * @param String vvd
	 * @param String usr_id
	 * @throws EventException
	 */
	public void manageSpcAlocIf(String trd_cd, String rlane_cd, String vvd, String usr_id) throws EventException;

	/**
	 * ESM_SQM_0043/ESM_SQM_0044 : Retrieve 이벤트 처리<br>
	 * [Figure Inquiry]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchPotnFigureInquiryListVO>
	 * @throws EventException
	 */
	public List<SearchPotnFigureInquiryListVO> searchPotnFigureInquiryList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_SQM_0045 : Retrieve 이벤트 처리<br>
	 * [IAS Lane Office List]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchLaneOfficeListVO>
	 * @throws EventException
	 */
	public List<SearchLaneOfficeListVO> searchLaneOfficeList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_SQM_0045 : Creation 이벤트 처리<br>
	 * [IAS QTA Office Add]을 [생성] 합니다.
	 * 
	 * @param SearchLaneOfficeListVO[] searchLaneOfficeListVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createQtaOfficeAdd(SearchLaneOfficeListVO[] searchLaneOfficeListVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException ;

	/**
	 * ESM_SQM_0219 : Retrieve 이벤트 처리<br>
	 * [QTA Adjustment by VVD For Sector]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaAdjustmentForSectorListVO>
	 * @throws EventException
	 */
	public List<SearchQtaAdjustmentForSectorListVO> searchQtaAdjustmentForSectorList(ConditionVO conditionVO) throws EventException;

	/**
	 * ESM_SQM_0219 : Creation<br>
	 * [QTA Adjustment by VVD For Sector]을 [복사][변경][삭제] 합니다.<br>
	 * 
	 * @param ManageQtaAdjustmentVO[] manageQtaAdjustmentVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createQtaAdjustmentForSector(ManageQtaAdjustmentVO[] manageQtaAdjustmentVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_SQM_0219 : Save Supply<br>
	 * [QTA Adjustment by VVD For Sector]을 [저장] 합니다.<br>
	 * 
	 * @param ManageQtaAdjustmentVO[] manageQtaAdjustmentVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void saveSupplyForSector(ManageQtaAdjustmentVO[] manageQtaAdjustmentVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_SQM_0220 : Retrieve 이벤트 처리<br>
	 * [Qta Edit for IAS Sector]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaEditListVO>
	 * @throws EventException
	 */
	public List<SearchQtaEditListVO> searchQtaEditIasSectorList(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0220 : MULTI 이벤트 처리<br>
	 * [Qta Edit for IAS Sector]을 [저장] 합니다.
	 * 
	 * @param SqmSctrCfmQtaVO[] sqmSctrCfmQtaVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaEditIasSector(SqmSctrCfmQtaVO[] sqmSctrCfmQtaVOS, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_SQM_0220 : MULTI01 이벤트 처리<br>
	 * [CMCB adjust for IAS Sector]을 [생성] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws EventException
	 */
	public void createCmcbAdjustIasSector(ConditionVO conditionVO, String usrId) throws EventException;
	/**
	 * ESM_SQM_0221 : Retrieve 이벤트 처리<br>
	 * [Qta Edit POL-POD Pair Add for IAS Sector]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaEditListVO>
	 * @throws EventException
	 */
	public List<SearchQtaEditListVO> searchQtaEditPolPodPairAddIasSector(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0221 : CREATION<br>
	 * [Qta Edit POL-POD Pair Add for IAS Sector]을 [생성] 합니다.
	 * 
	 * @param ManageQtaEditIasSectorVO[] manageQtaEditIasSectorVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createQtaEditPolPodPairAddIasSector(ManageQtaEditIasSectorVO[] manageQtaEditIasSectorVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_SQM_0222 : Retrieve 이벤트 처리<br>
	 * [Qta Edit Office Add for IAS Sector]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaEditListVO>
	 * @throws EventException
	 */
	public List<SearchQtaEditListVO> searchQtaEditOfficeAddIasSector(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0222 : CREATION<br>
	 * [Qta Edit Office Add for IAS Sector]을 [생성] 합니다.
	 * 
	 * @param ManageQtaEditIasSectorVO[] manageQtaEditIasSectorVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createQtaEditOfficeAddIasSector(ManageQtaEditIasSectorVO[] manageQtaEditIasSectorVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_SQM_0224 : Retrieve 이벤트 처리<br>
	 * [RBCCO PFMC = QTA Setting for IAS Sector]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaEditListVO>
	 * @throws EventException
	 */
	public List<SearchQtaEditListVO> searchRbccoPfmcQtaSetIasSector(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_SQM_0224 : Apply 이벤트 처리<br>
	 * [RBCCO PFMC = QTA Setting for IAS Sector]을 [Apply] 합니다.
	 * 
	 * @param SearchQtaEditListVO[] searchQtaEditListVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageRbccoPfmcQtaSetIasSector(SearchQtaEditListVO[] searchQtaEditListVOS, SignOnUserAccount account) throws EventException;
}