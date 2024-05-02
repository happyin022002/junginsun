/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalBC.java
*@FileTitle : SPCL CGO APVL for Partner Lines (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.24 김현욱
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.basic;

import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.PartnerApprovalRequestVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstCgoVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrRequestListOptionVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.SearchPrnrScgListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Cargoloadingapproval Business Logic Command Interface<br>
 * - OPUS-Cargoloadingapproval에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HyunUk Kim
 * @see Vop_scg_0022EventResponse 참조
 * @since J2EE 1.6
 */

public interface PartnerLinesDangerousCargoApprovalBC {
 	
	/**
	 * VOP_SCG_0022 : Retrieve <br>
	 * SPCL CGO APVL for Partner Lines 를 조회 합니다. <br>
	 * 
	 * @param partnerApprovalRequestVO
	 * @return List<PartnerApprovalRequestVO>
	 * @exception EventException
	 */
	public List<PartnerApprovalRequestVO> searchPatnerSCGList(PartnerApprovalRequestVO partnerApprovalRequestVO) throws EventException;
	
	/**
	 * VOP_SCG_0022, VOP_SCG_1022 : Save <br>
	 * SPCL CGO APVL for Partner Lines 를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param PartnerApprovalRequestVO partnerApprovalRequestVO
	 * @param List<String> keys
	 * @param SignOnUserAccount account
	 * @return List<Map>
	 * @exception EventException
	 */
	public List<Map> managePartnerSCGReturn(PartnerApprovalRequestVO partnerApprovalRequestVO, List<String> keys, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_SCG_0022(AwKward) : Save <br>
	 * SPCL CGO APVL for Partner Lines 를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param partnerApprovalRequestVO
	 * @param keys
	 * @param account SignOnUserAccount
	 * @return int
	 * @exception EventException
	 */
	public int managePartnerSCGAK(PartnerApprovalRequestVO partnerApprovalRequestVO, List<String> keys, SignOnUserAccount account) throws EventException;

	/**
	 * VOP_SCG_0023 : Save <br>
	 * SPCL CGO APVL for Partner Lines 를 수정 합니다. <br>
	 * 
	 * @param scgPrnrAproRqstCgoVOs ScgPrnrAproRqstCgoVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void updatePartnerSCGCGOApproved(ScgPrnrAproRqstCgoVO[] scgPrnrAproRqstCgoVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_SCG_1022 : Retrieve <br>
	 * Dangerous CGO Application Details for Partner Lines 를 조회 합니다. <br>
	 * 
	 * @param scgPrnrAproRqstVO ScgPrnrAproRqstVO
	 * @return PartnerApprovalRequestVO
	 * @exception EventException
	 */
	public PartnerApprovalRequestVO searchPartnerSCGDetailList(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws EventException;
	
	/**
	 * VOP_SCG_1022 : Validation <br>
	 * Dangerous CGO Application Details for Partner Lines 의 MPA1의 NET Weight 합을 조회 합니다. <br>
	 * 
	 * @param scgPrnrAproRqstVO ScgPrnrAproRqstVO
	 * @return String
	 * @exception EventException
	 */
	public String searchPatnerSCGMpa1NetSum(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws EventException;
	
	/**
	 * VOP_SCG_1022 : Save <br>
	 * DG Ref. No. Duplication Check <br>
	 * 
	 * @param ScgPrnrAproRqstVO   scgPrnrAproRqstVO
	 * @return String
	 * @exception EventException
	 */
	public String searchPatnerDcgoRefNo(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws EventException;
	
	/**
	 * VOP_SCG_1022 : Save <br>
	 * BKG Ref. No. Duplication Check <br>
	 * 
	 * @param ScgPrnrAproRqstVO   scgPrnrAproRqstVO
	 * @param PartnerApprovalRequestVO partnerApprovalRequestVO
	 * @return String
	 * @exception EventException
	 */
	public String searchPatnerBkgRefNo(ScgPrnrAproRqstVO scgPrnrAproRqstVO, PartnerApprovalRequestVO partnerApprovalRequestVO) throws EventException;
	
	/**
	 * VOP_SCG_5822 : Retrieve <br>
	 * Application Request & Approval Status For Partner Lines의 List를 조회 합니다. <br>
	 * 
	 * @param ScgPrnrRequestListOptionVO scgPrnrRequestListOptionVO
	 * @return SearchPrnrScgListVO
	 * @exception EventException
	 */
	public SearchPrnrScgListVO searchScgApprovalStatusListPartner(ScgPrnrRequestListOptionVO scgPrnrRequestListOptionVO) throws EventException;
	
	/**
	 * SPCL CGO APVL for Own BKG의 메일전송 결과를 저장 합니다. <br>
	 * 
	 * @param ScgPrnrAproRqstVO scgPrnrAproRqstVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPartnerSCGApprovalMail(ScgPrnrAproRqstVO scgPrnrAproRqstVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_SCG_1022 : Retrieve(Updated Items) <br>
	 * Dangerous CGO Application Details for Partner Lines 를 조회 합니다. <br>
	 * 
	 * @param scgPrnrAproRqstVO ScgPrnrAproRqstVO
	 * @return PartnerApprovalRequestVO
	 * @exception EventException
	 */
	public PartnerApprovalRequestVO searchPartnerSCGDetailListBefore(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws EventException;

	/**
	 * VOP_SCG_5001 : Save <br>
	 * SPCL CGO APVL for Partner Lines 를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param partnerApprovalRequestVO
	 * @param keys
	 * @param account SignOnUserAccount
	 * @return List
	 * @exception EventException
	 */
	public List<Map> managePartnerSCGApvl(PartnerApprovalRequestVO partnerApprovalRequestVO, List<String> keys, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_SCG_5001 : Update <br>
	 * SPCL CGO APVL for Partner Lines modify <br>
	 * 
	 * @param PartnerApprovalRequestVO partnerApprovalRequestVO
	 * @param SignOnUserAccount account
	 * @exception EventException  
	 */
	public void managePartnerCntrNm(PartnerApprovalRequestVO partnerApprovalRequestVO, SignOnUserAccount account) throws EventException;
}