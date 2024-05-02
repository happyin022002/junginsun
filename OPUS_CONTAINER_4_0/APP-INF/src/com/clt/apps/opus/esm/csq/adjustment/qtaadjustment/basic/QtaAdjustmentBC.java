/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : QtaAdjustmentBC.java
*@FileTitle      : QtaAdjustment
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.30
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.30 CSQ USER
* 1.0 Creation
* 2013.10.21 PEJ [CHM-201327263] Figure Inquiry  조회 팝업 추가
*                        searchPotnFigureInquiryList 메소드 추가
* 2013.12.10 PEJ [CHM-201328059] QTA Edit_Office Add 팝업 추가
* 2014.09.25 이혜민 [CHM-201431935] Portion Adjustment 화면의 From, TO VVD 입력 시 Portion Connected <> 'I' 인 VVD alert.
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.basic;

import java.util.List;

import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.ManageQtaAdjustmentVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.ManageQtaEditIasSectorVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchLaneOfficeListVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchPotnAdjustmentListVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchPotnFigureInquiryListVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchQtaAdjustmentForSectorListVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchQtaAdjustmentListVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchQtaEditListVO;
import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CsqCfmQtaVO;
import com.clt.syscommon.common.table.CsqSctrCfmQtaVO;

/**
 * ALPS-QtaAdjustment Business Logic Command Interface<br>
 * - ALPS-QtaAdjustment 에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CSQ USER
 * @see
 * @since J2EE 1.6
 */
public interface QtaAdjustmentBC {
	
	/**
	 * ESM_CSQ_0050 : Retrieve 이벤트 처리<br>
	 * [QTA Adjustment by VVD]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchQtaAdjustmentListVO>
	 * @throws EventException
	 */
	public List<SearchQtaAdjustmentListVO> searchQtaAdjustmentList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0050 : MULTI 이벤트 처리<br>
	 * [QTA Adjustment by VVD]을 [조회] 합니다.
	 * 
	 * @param ManageQtaAdjustmentVO[] manageQtaAdjustmentVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaAdjustment(ManageQtaAdjustmentVO[] manageQtaAdjustmentVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0051 : [이벤트]<br>
	 * [Portion Adjustment]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchPotnAdjustmentListVO>
	 * @throws EventException
	 */
	public List<SearchPotnAdjustmentListVO> searchPotnAdjustmentList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0051 : [이벤트]<br>
	 * [Portion Adjustment]을 [저장] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SearchPotnAdjustmentListVO[] searchPotnAdjustmentListVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void managePotnAdjustment(ConditionVO conditionVO, SearchPotnAdjustmentListVO[] searchPotnAdjustmentListVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0051 : MULTI02 이벤트 처리<br>
	 * [Portion Adjustment]를 [생성] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchPotnAdjustmentListVO>
	 * @throws EventException
	 */
	public List<SearchPotnAdjustmentListVO> searchRhqGroupRowAdd(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0051 : SEARCH01 이벤트 처리<br>
	 * [Portion Adjustment]에서 vvd의 주차를 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String vvd
	 * @return String
	 * @throws EventException
	 */
	public String searchApplyWeek(ConditionVO conditionVO, String vvd) throws EventException;
	
	/**
	 * ESM_CSQ_0051 : SEARCH02 이벤트 처리<br>
	 * [Portion Adjustment by Head Office]에서 vvd 입력 시 해당 VVD가 Alloc 적용됐거나 QTA Edit에서 매뉴얼로 수정되었는지 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<String>
	 * @throws EventException
	 */
	public List<String> searchVvdCngTpCd(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_CSQ_0051,ESM_CSQ_0053 : MULTI01 이벤트 처리<br>
	 * [Portion Adjustment]에서 확정데이터를 [재생성] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createPotnAdjustment(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0055 : Retrieve 이벤트 처리<br>
	 * [Qta Edit]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaEditListVO>
	 * @throws EventException
	 */
	public List<SearchQtaEditListVO> searchQtaEditList(ConditionVO conditionVO) throws EventException;
	
	/**
	 * ESM_CSQ_0055 : MULTI 이벤트 처리<br>
	 * [Qta Edit]을을 [저장] 합니다.
	 * 
	 * @param CsqCfmQtaVO[] csqCfmQtaVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaEdit(CsqCfmQtaVO[] csqCfmQtaVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESM_CSQ_0055 : MULTI01 이벤트 처리<br>
	 * [CMCB adjust]을을 [생성] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws EventException
	 */
	public void createCmcbAdjust(ConditionVO conditionVO, String usrId) throws EventException;
	
	/**
	 * ESM_CSQ_0052/ESM_CSQ_0054 : Retrieve 이벤트 처리<br>
	 * [Figure Inquiry]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchPotnFigureInquiryListVO>
	 * @throws EventException
	 */
	public List<SearchPotnFigureInquiryListVO> searchPotnFigureInquiryList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_CSQ_0056 : Retrieve 이벤트 처리<br>
	 * [IAS Lane Office List]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchLaneOfficeListVO>
	 * @throws EventException
	 */
	public List<SearchLaneOfficeListVO> searchLaneOfficeList(ConditionVO conditionVO, SignOnUserAccount account) throws EventException;

	/**
	 * ESM_CSQ_0056 : Creation 이벤트 처리<br>
	 * [IAS QTA Office Add]을 [생성] 합니다.
	 * 
	 * @param SearchLaneOfficeListVO[] searchLaneOfficeListVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createQtaOfficeAdd(SearchLaneOfficeListVO[] searchLaneOfficeListVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException ;

	/**
	 * ESM_CSQ_0219 : Retrieve 이벤트 처리<br>
	 * [QTA Adjustment by VVD For Sector]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaAdjustmentForSectorListVO>
	 * @throws EventException
	 */
	public List<SearchQtaAdjustmentForSectorListVO> searchQtaAdjustmentForSectorList(ConditionVO conditionVO) throws EventException;

	/**
	 * ESM_CSQ_0219 : Creation<br>
	 * [QTA Adjustment by VVD For Sector]을 [복사][변경][삭제] 합니다.<br>
	 * 
	 * @param ManageQtaAdjustmentVO[] manageQtaAdjustmentVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createQtaAdjustmentForSector(ManageQtaAdjustmentVO[] manageQtaAdjustmentVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_CSQ_0220 : Retrieve 이벤트 처리<br>
	 * [Qta Edit for IAS Sector]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaEditListVO>
	 * @throws EventException
	 */
	public List<SearchQtaEditListVO> searchQtaEditIasSectorList(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_CSQ_0220 : MULTI 이벤트 처리<br>
	 * [Qta Edit for IAS Sector]을 [저장] 합니다.
	 * 
	 * @param CsqSctrCfmQtaVO[] csqSctrCfmQtaVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageQtaEditIasSector(CsqSctrCfmQtaVO[] csqSctrCfmQtaVOS, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_CSQ_0220 : MULTI01 이벤트 처리<br>
	 * [CMCB adjust for IAS Sector]을 [생성] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws EventException
	 */
	public void createCmcbAdjustIasSector(ConditionVO conditionVO, String usrId) throws EventException;
	/**
	 * ESM_CSQ_0221 : Retrieve 이벤트 처리<br>
	 * [Qta Edit POL-POD Pair Add for IAS Sector]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaEditListVO>
	 * @throws EventException
	 */
	public List<SearchQtaEditListVO> searchQtaEditPolPodPairAddIasSector(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_CSQ_0221 : CREATION<br>
	 * [Qta Edit POL-POD Pair Add for IAS Sector]을 [생성] 합니다.
	 * 
	 * @param ManageQtaEditIasSectorVO[] manageQtaEditIasSectorVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createQtaEditPolPodPairAddIasSector(ManageQtaEditIasSectorVO[] manageQtaEditIasSectorVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_CSQ_0222 : Retrieve 이벤트 처리<br>
	 * [Qta Edit Office Add for IAS Sector]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaEditListVO>
	 * @throws EventException
	 */
	public List<SearchQtaEditListVO> searchQtaEditOfficeAddIasSector(ConditionVO conditionVO) throws EventException;
	/**
	 * ESM_CSQ_0222 : CREATION<br>
	 * [Qta Edit Office Add for IAS Sector]을 [생성] 합니다.
	 * 
	 * @param ManageQtaEditIasSectorVO[] manageQtaEditIasSectorVOS
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void createQtaEditOfficeAddIasSector(ManageQtaEditIasSectorVO[] manageQtaEditIasSectorVOS, ConditionVO conditionVO, SignOnUserAccount account) throws EventException;
}