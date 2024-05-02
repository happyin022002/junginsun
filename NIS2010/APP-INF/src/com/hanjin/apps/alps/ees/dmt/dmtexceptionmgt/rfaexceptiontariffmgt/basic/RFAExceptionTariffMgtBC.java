/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAExceptionTariffMgtBC.java
*@FileTitle : DEM/DET Adjustment Request - Before Booking Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.06.11 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.ApprovalRequestUserListVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.ApprovalRequestUserVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeAfterStatusInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeAfterStatusVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionListInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionListVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFACopyMstToBzcVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionCoverageVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionCustomerVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionGRPVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionRateAdjustVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAProgressVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-Dmtexceptionmgt Business Logic Command Interface<br>
 * - NIS2010-Dmtexceptionmgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SungHoon, Lee
 * @see EES_DMT_2003EventResponse 참조
 * @since J2EE 1.6
 */
public interface RFAExceptionTariffMgtBC {
	/**
	 * Before Booking의 Proposal No. 에 해당되는 DAR No.를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchBeforeDARList(RFAProgressVO rFAProgressVO) throws EventException;
	
	
	/**
	 * Before Booking의 DAR No. 에 해당되는 Version을 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchBeforeVERList(RFAProgressVO rFAProgressVO) throws EventException;
	
	
	/**
	 * Before Booking Exception을 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<BeforeExceptionVO>
	 * @exception EventException
	 */
	public List<BeforeExceptionVO> searchBeforeExceptionList(RFAProgressVO rFAProgressVO) throws EventException;
	
	
	/**
	 * Actual Customer를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCustomerVO>
	 * @exception EventException
	 */	
	public List<RFAExceptionCustomerVO> searchCustomerListByRFA(RFAProgressVO rFAProgressVO) throws EventException;
	
	
	/**
	 * Proposal No. 에 해당되는 Affiliate를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCustomerVO>
	 * @exception EventException
	 */	
	public List<RFAExceptionCustomerVO> searchAffiliateListByRFA(RFAProgressVO rFAProgressVO) throws EventException;
	
	
	/**
	 * DAR No. 나 Approval No. 로 Proposal No.를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */	
	public List<RFAProgressVO> searchPropNoByDARApprovalNo(RFAProgressVO rFAProgressVO) throws EventException;	
	
	
	/**
	 * DAR No. 를 생성, 조회 합니다. <br>
	 * 
	 * @param String bkgTpCd
	 * @param String usrId
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */	
	public String searchNewDAR(String bkgTpCd, String usrId, String ofcCd) throws EventException;	
	
	
	/**
	 * Version 에 해당되는 Comment History를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */		
	public List<RFAProgressVO> searchCommentHistory(RFAProgressVO rFAProgressVO) throws EventException;
	
	
	/**
	 * Before Booking Exception 을 생성, 수정, 삭제 합니다.<br>
	 * 
	 * @param RFAExceptionGRPVO rFAExceptionGRPVO
	 * @param SignOnUserAccount account
	 * @return RFAProgressVO
	 * @exception EventException
	 */	
	public RFAProgressVO modifyBeforeException(RFAExceptionGRPVO rFAExceptionGRPVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * DAR No. 와 Ver No. 에 대한 기존 Approval No. 를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return String
	 * @exception EventException
	 */	
	public String searchPrevApprovalNo(RFAProgressVO rFAProgressVO) throws EventException;	
	

	/**
	 * Approval No. 를 신규 생성 한다. <br>
	 * 
	 * @param String usrId
	 * @param String rhqOfcCd
	 * @param String bkgTpCd
	 * @return String
	 * @exception EventException
	 */	
	public String searchNewApprovalNo(String usrId, String rhqOfcCd, String bkgTpCd) throws EventException;	
	
	/**
	 * Before Booking Exception Version 의 상태를 'Request'로 수정 합니다.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */	
	public void requestBeforeException(RFAProgressVO rFAProgressVO) throws EventException;	
	
	/**
	 * Before Booking Exception Version 의 상태를 'Cancel'로 수정 합니다.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */	
	public void cancelBeforeException(RFAProgressVO rFAProgressVO) throws EventException;	
	
	/**
	 * Before Booking Exception Version 의 상태를 'Approved'로 수정 합니다.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */	
	public void approvalBeforeException(RFAProgressVO rFAProgressVO) throws EventException;		
	
	/**
	 * Before Booking Exception Version 의 상태를 'Counter Offer'로 수정 합니다.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */	
	public void counterofferBeforeException(RFAProgressVO rFAProgressVO) throws EventException;	
	
	
	/**
	 * Before Booking Exception Version 의 상태를 'Reject'로 수정 합니다.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */	
	public void rejectBeforeException(RFAProgressVO rFAProgressVO) throws EventException;	
	
	
	/**
	 * DAR No. 에 해당되는 Approval No.를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchBeforeAPROList(RFAProgressVO rFAProgressVO) throws EventException;
	
	
	/**
	 * Proposal No. 에 해당되는 Customer를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchCustomerByProp(RFAProgressVO rFAProgressVO) throws EventException;	
	
	
	/**
	 * Proposal No. 에 해당되는 RFA No.를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchRFAByProp(RFAProgressVO rFAProgressVO) throws EventException;	
	
	
	/**
	 * DAR No. 와 Version No. 에 해당되는 모든 Multi Origin or Destination를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCoverageVO>
	 * @exception EventException
	 */
	public List<RFAExceptionCoverageVO> searchMultiCoverageByRFA(RFAProgressVO rFAProgressVO) throws EventException;
	
	
	/**
	 * DAR No. 와 Version No. 에 해당되는 모든 Rate Adjustment를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionRateAdjustVO>
	 * @exception EventException
	 */
	public List<RFAExceptionRateAdjustVO> searchRateAdjustmentByRFA(RFAProgressVO rFAProgressVO) throws EventException;	
	
	
	/**
	 * Proposal No. 에 해당되는 RFA No. 와 Customer를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAExceptionCustomerVO>
	 * @exception EventException
	 */
	public List<RFAExceptionCustomerVO> searchRFANoCustomerByProposalNo(RFAProgressVO rFAProgressVO) throws EventException;
	
	
	/**
	 * Approval No. 에 해당되는 Version를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchVERByApprovalNo(RFAProgressVO rFAProgressVO) throws EventException;
	
	
	/**
	 * DAR No. 에 해당되는 Approval Office를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchApprovalOfcByDAR(RFAProgressVO rFAProgressVO) throws EventException;
	
	
	/**
	 * S/C, Before Booking, After Booking를 조회 합니다. <br>
	 * 
	 * @param BeforeAfterStatusInputVO inputVO
	 * @return List<BeforeAfterStatusVO>
	 * @exception EventException
	 */
	public List<BeforeAfterStatusVO> searchBeforeAfterStatusList(BeforeAfterStatusInputVO inputVO) throws EventException;
	
	
	/**
	 * Before Booking Customer여부를 조회 합니다. <br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isBeforeBKGCustomer(String custCntCd, String custSeq) throws EventException;	
	
	
	/**
	 * Proposal No. 에 해당되는 Before Booking를 조회 합니다. <br>
	 * 
	 * @param BeforeExceptionListInputVO inputVO
	 * @return List<BeforeExceptionListVO>
	 * @exception EventException
	 */
	public List<BeforeExceptionListVO> searchBeforeExceptionListByPropNo(BeforeExceptionListInputVO inputVO) throws EventException;
	
	
	/**
	 * Customer Code 와 RFA No. 에 해당되는 Before Booking를 조회 합니다. <br>
	 * 
	 * @param BeforeExceptionListInputVO inputVO
	 * @return List<BeforeExceptionListVO>
	 * @exception EventException
	 */
	public List<BeforeExceptionListVO> searchBeforeExceptionListByCustomer(BeforeExceptionListInputVO inputVO) throws EventException;	
	
	
	/**
	 * 승인권한자를 조회 합니다. <br>
	 * 
	 * @param ApprovalRequestUserVO approvalRequestUserVO
	 * @param String condType
	 * @return List<ApprovalRequestUserListVO>
	 * @exception EventException
	 */
	public List<ApprovalRequestUserListVO> searchApprovalAuthorityList(ApprovalRequestUserVO approvalRequestUserVO, String condType) throws EventException;
	
	/**
	 * Update 버튼 클릭시 'Approved', 'Rejected' 상태의 Before Booking Request 정보를 새로운 버전으로 생성 합니다.<br>
	 * 
	 * @param RFAProgressVO rRFAProgressVO
	 * @exception EventException
	 */
	public void addBeforeExceptionByUpdate(RFAProgressVO rRFAProgressVO) throws EventException;
	
	/**
	 * 현재 버전에 있는 정보를 삭제하고 현재 버전에 DAR History 에서 선택한 버전의 정보로 생성 합니다.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addBeforeExceptionByHistoryCopy(RFAProgressVO rFAProgressVO, SignOnUserAccount account) throws EventException;		
	
	/**
	 * 선택한 Before Exception Request 의 Detail 과 그 하위항목을 모두 삭제 합니다.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @exception EventException
	 */
	public void removeBeforeException(RFAProgressVO rFAProgressVO) throws EventException;
	
	/**
	 * 화면에서 입력한 RFA 정보와 기등록된 RFA 정보중 중복된 데이터가 있는지 조회 합니다.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return String
	 * @exception EventException
	 */
	public String isDuplicateRFA(RFAProgressVO rFAProgressVO) throws EventException;
	
	/**
	 * Approval, Counter Offer, Reject 시 최종 Update Date 를 조회 합니다.<br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return String
	 * @exception EventException
	 */
	public String searchUpdateDate(RFAProgressVO rFAProgressVO) throws EventException;
	
	/**
	 * Before Booking의 APVL No. 에 해당되는 APVL OFC, DAR No., Version, Status 를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return List<RFAProgressVO>
	 * @exception EventException
	 */
	public List<RFAProgressVO> searchRFATariffByAPVLNo(RFAProgressVO rFAProgressVO) throws EventException;
	
	/**
	 * Proposal No.나 DAR No. 로 Approval No.를 조회 합니다. <br>
	 * 
	 * @param RFAProgressVO rFAProgressVO
	 * @return RFAProgressVO
	 * @throws EventException
	 */
	public RFAProgressVO searchAproNoByPropApprovalNo(RFAProgressVO rFAProgressVO) throws EventException;	

	/**
	 * 호출메뉴 : EES_DMT_2003 ( DEM/DET Adjustment Request - Before Booking Request )
	 * Basic RFA 인지 여부를 조회합니다.<br>
	 * 
	 * @param String propNo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isBzcRfa(String propNo) throws EventException;
	
	/**
	 * 호출메뉴 : EES_DMT_2003 ( DEM/DET Adjustment Request - Before Booking Request )
	 * Master RFA 의 Proposal No. 를 조회합니다.<br>
	 * 
	 * @param String propNo
	 * @return String
	 * @exception EventException
	 */
	public String searchPropNoOfMstRfa(String propNo) throws EventException;
	
	/**
	 * 호출메뉴 : EES_DMT_2003 ( DEM/DET Adjustment Request - Before Booking Request )
	 * Master RFA 의 유효한 버전이 Basic RFA 보다 상위 버전인지 여부를 조회합니다.<br>
	 * 
	 * @param String mstPropNo
	 * @param String bzcPropNo
	 * @return boolean
	 * @exception EventException
	 */
	public boolean isUpprMstRfaVerThanBzcRfaVer(String mstPropNo, String bzcPropNo) throws EventException;
	
	/**
	 * 호출메뉴 : EES_DMT_2003 ( DEM/DET Adjustment Request - Before Booking Request )
	 * Auto Update 버튼 클릭시 Master RFA 의 유효한 상위버전 정보를 Basic RFA 에 Copy 합니다.<br>
	 * 
	 * @param RFACopyMstToBzcVO paramVO
	 * @exception EventException
	 */
	public void copyMstRfaVerToBzcRfaVer(RFACopyMstToBzcVO paramVO) throws EventException;
	
	/**
	 * 호출메뉴 : EES_DMT_2003 ( DEM/DET Adjustment Request - Before Booking Request )
	 * Request 버튼 클릭시 승인까지 일괄적으로 처리한다.<br>
	 * 
	 * @param RFAProgressVO paramVO
	 * @exception EventException
	 */	
	public void approvalByBzcRfa(RFAProgressVO paramVO) throws EventException;
	
	/**
	 * 호출메뉴 : EES_DMT_2003 ( DEM/DET Adjustment Request - Before Booking Request )
	 * 화면 Load 시 Prop No. 에 대한 BBE( Before Booking Exception )이 등록되었는지 여부를 조회합니다.<br>
	 * 
	 * @param String propNo
	 * @return boolean
	 * @exception EventException
	 */	
	public boolean isExistRfa(String propNo) throws EventException;	
}
