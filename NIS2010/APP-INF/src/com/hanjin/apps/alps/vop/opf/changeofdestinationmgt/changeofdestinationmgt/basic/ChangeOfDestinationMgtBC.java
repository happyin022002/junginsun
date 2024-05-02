/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChangeOfDestinationMgtBC.java
*@FileTitle : COD Approve Main Screen
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.07.20 김종옥
* 1.0 Creation
*=========================================================
* History
* 2010.07.26 LHJ [Ticket-ID:CHM-201004935] COD application 조회 기능 추가 요청 및 에러 수정건
* 2015.03.06 이병훈 [CHM-201534196] COD charges DVC 비용 관련 로직 수정
*=========================================================*/
package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodRehandlingInfoVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.ApprovalInformationVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.BkgCodCostListVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.CODRequestInformationVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.CODRequestListVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.ChangeOfDestinationMgtConditionVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.OpfCodDvsFeeBoxBlVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.OpfCodDvsFeeViewVO;
import com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.OpfCodOldNewPodVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCodCostVO;
import com.hanjin.syscommon.common.table.ComIntgCdDtlVO;
import com.hanjin.syscommon.common.table.MdmCurrencyVO;
import com.hanjin.syscommon.common.table.OpfCodDvsFeeVO;
import com.hanjin.syscommon.common.table.OpfCodRjctCdVO;
import com.hanjin.syscommon.common.table.ScgRgnShpOprCdVO;

/**
 * ALPS-Changeofdestinationmgt Business Logic Command Interface<br>
 * - ALPS-Changeofdestinationmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Jong Ock
 * @see Vop_opf_0033EventResponse 참조
 * @since J2EE 1.6
 */

public interface ChangeOfDestinationMgtBC {

	/**
	 * COD Approval을 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO	changeOfDestinationMgtConditionVO
	 * @return List<CODRequestListVO>
	 * @exception EventException
	 */
	public List<CODRequestListVO> searchCODRequestList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;
	
	 /**
	 * RSO, LANE 별 EMAIL 을 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<CODRequestInformationVO>
	 * @exception EventException
	 */
	public List<CODRequestInformationVO> searchCODEmailsendList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;

	 /**
	 * 해당 VVD의 CARRIER CODE 를 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<CODRequestInformationVO>
	 * @exception EventException
	 */
	public List<CODRequestInformationVO> searchCODCarrierCd(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;

	 /**
	 * 해당 BKG의 NEW,OLD POD CODE 를 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<CODRequestInformationVO>
	 * @exception EventException
	 */
	public List<CODRequestInformationVO> searchCODNewOldPODCd(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;

	/**
	 * RSO 콤보생성을 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<ScgRgnShpOprCdVO>
	 * @exception EventException
	 */
	public List<ScgRgnShpOprCdVO> searchRsoCombo(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;

	/**
	 * Freight & Charges for COD에 CUR 콤보생성을 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO   changeOfDestinationMgtConditionVO
	 * @return List<MdmCurrencyVO>
	 * @exception EventException
	 */
	public List<MdmCurrencyVO> searchCurrCdCombo(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;
	
	
	/**
	 * COD Condition 콤보생성을 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<ComIntgCdDtlVO>
	 * @exception EventException
	 */
	public List<ComIntgCdDtlVO> searchCodCombo(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;
	
	/**
	 * Auth Result 콤보생성을 조회 합니다.
	 * 2010.07.23 추가 by LHJ<br>
	 * 
	 * @return List<ComIntgCdDtlVO>
	 * @exception EventException
	 */
	public List<ComIntgCdDtlVO> searchAuthCombo() throws EventException;
	
	/**
	 * COD Reason 콤보생성을 조회 합니다.
	 * 2010.07.23 추가 by LHJ<br>
	 * 
	 * @return List<ComIntgCdDtlVO>
	 * @exception EventException
	 */
	public List<ComIntgCdDtlVO> searchCodRsnCombo() throws EventException;

	/**
	 * 로그인사용자의 소속오피스에 해당되는 RSO 찾기
	 * 2010.07.26 추가 by LHJ<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchOfcRso(SignOnUserAccount account) throws EventException;

	/**
	 * Reject Reason 콤보생성을 조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO   changeOfDestinationMgtConditionVO
	 * @return List<OpfCodRjctCdVO>
	 * @exception EventException
	 */
	public List<OpfCodRjctCdVO> searchCODRejectCodeList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;

	
	/**
	 * COD Request Information 을 조회합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO	changeOfDestinationMgtConditionVO
	 * @return List<CODRequestInformationVO>
	 * @exception EventException
	 */
	public List<CODRequestInformationVO> searchCODDetail(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;

	/**
	 * Approval Information 을 조회합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<ApprovalInformationVO>
	 * @exception EventException
	 */
	public List<ApprovalInformationVO> searchRsoDetail(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;
	
	/**
	 * Freight & Charges for COD 을 조회합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO	changeOfDestinationMgtConditionVO
	 * @return List<BkgCodCostVO>
	 * @exception EventException
	 */
	public List<BkgCodCostVO> searchRehandlingList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;	

	/**
	 * Row Add 시 CHR, CUR, Rate 을 조회합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @param CodRehandlingInfoVO codRehandlingInfoVO
	 * @return List<BkgCodCostListVO>
	 * @exception EventException
	 */
	public List<BkgCodCostListVO> searchRehandlingQTY(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO, CodRehandlingInfoVO codRehandlingInfoVO) throws EventException;

	/**
	 * CNTR Q'ty 시 Container List 을 조회합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @param CodRehandlingInfoVO codRehandlingInfoVO
	 * @return List<BkgCodCostListVO>
	 * @exception EventException
	 */
	public List<BkgCodCostListVO> searchRehandlingContainerList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO, CodRehandlingInfoVO codRehandlingInfoVO) throws EventException;
	
	/**
	 * CNTR Type/SIZE시 유효성 체크를 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<BkgCodCostVO>
	 * @exception EventException
	 */
	public List<BkgCodCostVO> searchRatUtCdCheck(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;	
	
	/**
	 * CHR, CUR, Rate 을 조회합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @param String strCurrCd
	 * @param String strRate
	 * @return List<BkgCodCostVO>
	 * @exception EventException
	 */
	public List<BkgCodCostVO> searchRehandlingRate(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO, String strCurrCd, String strRate) throws EventException;	
	
	/**
	 * Bay Plan 을 조회합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<ChangeOfDestinationMgtConditionVO>
	 * @exception EventException
	 */
	public List<ChangeOfDestinationMgtConditionVO> searchBayPlanCheck(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;

	/**
	 * Region COD MIN. Tariff 을 조회합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<OpfCodDvsFeeVO>
	 * @exception EventException
	 */
	public List<OpfCodDvsFeeVO> searchDiversionList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;

	/**
	 * Region COD MIN. Tariff View 을 조회합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO	
	 * @return List<OpfCodDvsFeeViewVO>
	 * @exception EventException
	 */
	public List<OpfCodDvsFeeViewVO> searchDiversionViewList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;
	
	/**
	 * Region COD MIN. Tariff 을 저장 합니다.<br>
	 * 
	 * @param OpfCodDvsFeeVO[] opfCodDvsFeeVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCodDivFee(OpfCodDvsFeeVO[] opfCodDvsFeeVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * OpfCodDvsFeeBoxBl 을 조회합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<OpfCodDvsFeeBoxBlVO>
	 * @exception EventException
	 */
	public List<OpfCodDvsFeeBoxBlVO> searchCodDiversionFeeList(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;
	
	/**
	 * OpfCodDvsFeeBoxBl 을 조회합니다.<br>
	 * 
	 * @param  List<BkgCodCostListVO> searchList
	 * @return List<List<BkgCodCostVO>>
	 * @exception EventException
	 */
	public List<List<BkgCodCostVO>> searchRehandlingCost(List<BkgCodCostListVO> searchList)  throws EventException;
			
	/**
	 * Old POD ETA & New POD ETA & CNTR TP/SZ & QTY조회 합니다.<br>
	 * 
	 * @param ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO
	 * @return List<OpfCodOldNewPodVO>
	 * @exception EventException
	 */
	public List<OpfCodOldNewPodVO> searchOldNewPodCntr(ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO) throws EventException;
}