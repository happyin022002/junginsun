/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQFlagMgtBC.java
*@FileTitle : Damage Flagging/Unflagging Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.05.19 박명신
* 1.0 Creation
--------------------------------------------------------
* History
* 2011.12.20 김상수 [CHM-201115062-01] ALPS MNR-Hanger-hanger rack and Bar History에 Report 보턴 추가 및 처리
*                                      - [UI_MNR_0257] Hanger Rack/Bar Using Report 신규 개발
* 2012.01.04 신혜정 [CHM-201215407-01] Hanger Rack/Bar Using Report 의 Detail EQ no 내역 팝업 조회                                          
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.vo.WarrantyAlertListGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMnrEqStsVVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.DisposalCandidateFlagGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.EqListForDisposalVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.eqflagmgt.vo.HangerRackReportVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-Operationmanage Business Logic Command Interface<br>
 * - alps-Operationmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author park myoung sin
 * @see Ees_mnr_0139EventResponse 참조
 * @since J2EE 1.4
 */

public interface EQFlagMgtBC {
	/**
	 * [EES_MNR_0122]Hanger Bar Attatch/Detach Qty by CNTR의 정보를 조회 합니다. <br>
	 *
	 * @param EQFlagListGRPVO eQFlagListGRPVO
	 * @return EQFlagListGRPVO
	 * @exception EventException
	 */
	public EQFlagListGRPVO searchEQFlagListBasic(EQFlagListGRPVO eQFlagListGRPVO) throws EventException;


	/**
	 * [EES_MNR_0122]W/O Creation의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param EQFlagListGRPVO eQFlagListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageEQFlagListBasic(EQFlagListGRPVO eQFlagListGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [Damage Flagging/Unflagging Interface] Flagging , CTM 호출 전용 외부 Interface Method <br>
	 * MNR, MST, CGM 에 정보를 업데이트 합니다.
	 *
	 * @param CustomMnrEqStsVO customMnrEqStsVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageIFFlagForOtherBasic(CustomMnrEqStsVO customMnrEqStsVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0125]Hanger Bar CNTR History의 정보를 조회 합니다. <br>
	 *
	 * @param EQFlagListGRPVO 	eQFlagListGRPVO
	 * @param SignOnUserAccount account
	 * @return EQFlagListGRPVO
	 * @exception EventException
	 */
	public EQFlagListGRPVO searchEQFlagHistoryListBasic(EQFlagListGRPVO eQFlagListGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0151]Disposal Candidate Selection의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO
	 * @return DisposalCandidateFlagGRPVO
	 * @exception EventException
	 */
	public DisposalCandidateFlagGRPVO searchDisposalCandidatePopupListBasic(DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO) throws EventException;

	/**
	 * [EES_MNR_0158]Disposal Candidate Inquiry_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO
	 * @param SignOnUserAccount account
	 * @return DisposalCandidateFlagGRPVO
	 * @exception EventException
	 */
	public DisposalCandidateFlagGRPVO searchDisposalCandidateFlagListBasic(DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO, SignOnUserAccount account) throws EventException;


	/**
	 * [EES_MNR_0151]Disposal Candidate Selection의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDisposalCandidateFlagBasic(DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0156] MNR_EQ_STS 의 mkr_nm,mdl_nm 추가/수정 합니다. <br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageEqStsMkrNmMdlNmBasic(DisposalGRPVO disposalGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0151] Range 안에 EQ NO 리스트의 정보를 조회 합니다. <br>
	 *
	 * @param DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO
	 * @return DisposalCandidateFlagGRPVO
	 * @exception EventException
	 */
	public DisposalCandidateFlagGRPVO searchRangeToEQNoBasic(DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO) throws EventException;

	/**
	 * [EES_MNR_0019] EQ NO 정보 단건 조회<br>
	 *
	 * @param String  eqNo
	 * @return String
	 * @exception EventException
	 */
	public  CustomMnrEqStsVVO searchEqInfoBasic(String  eqNo) throws EventException;

	/**
	 * [EES_MNR_0170]Reefer Unit Warranty Period의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param WarrantyAlertListGRPVO warrantyAlertListGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageWarrantyAlertBasic(WarrantyAlertListGRPVO warrantyAlertListGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0058] Hanger Bar Attatch/Detach Qty by CNTR의 정보를 조회 합니다. <br>
	 * WO 삭제전 EQ_STS 테이블 정보를 참조한다.
	 * @param EQFlagListGRPVO eQFlagListGRPVO
	 * @return EQFlagListGRPVO
	 * @exception EventException
	 */
	public EQFlagListGRPVO searchHangerEQFlagListBasic(EQFlagListGRPVO eQFlagListGRPVO) throws EventException;

	/**
	 * [EES_MNR_0257] Hanger Rack/Bar Using Report의 정보를 조회 합니다. <br>
	 *
	 * @param HangerRackReportVO hangerRackReportVO
	 * @param SignOnUserAccount account
	 * @return List<HangerRackReportVO>
	 * @exception EventException
	 */
	public List<HangerRackReportVO> searchHangerRackReportListBasic(HangerRackReportVO hangerRackReportVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0258] Hanger Rack/Bar Using Report Pop Up 정보를 조회 합니다. <br>
	 * 
	 * @param HangerRackReportVO hangerRackReportVO
	 * @param SignOnUserAccount account
	 * @return List<HangerRackReportVO>
	 * @throws EventException
	 */
	public List<HangerRackReportVO> searchHangerRackReportDtlListBasic(HangerRackReportVO hangerRackReportVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0151]Load Excel로 전달 받은 EQ들에 대한 정보를 조회합니다. <br>
	 *
	 * @param EqListForDisposalVO[] EqListForDisposalVOs
	 * @param String eqKndCd
	 * @return List<CustomMnrEqStsVO>
	 * @exception EventException
	 */
	public List<CustomMnrEqStsVO> searchEQDataForDisposalRSQL(EqListForDisposalVO[] EqListForDisposalVOs, String eqKndCd) throws EventException;

}