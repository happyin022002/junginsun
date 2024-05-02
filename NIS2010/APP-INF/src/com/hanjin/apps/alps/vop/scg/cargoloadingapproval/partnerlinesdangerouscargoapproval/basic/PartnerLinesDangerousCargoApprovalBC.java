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
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.PartnerApprovalRequestVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionOutputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstCgoVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstVO;


/**
 * ALPS-Cargoloadingapproval Business Logic Command Interface<br>
 * - ALPS-Cargoloadingapproval에 대한 비지니스 로직에 대한 인터페이스<br>
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
	 * VOP_SCG_0022 : Save <br>
	 * SPCL CGO APVL for Partner Lines 를 생성, 수정, 삭제 합니다. <br>
	 * 
	 * @param partnerApprovalRequestVO
	 * @param keys
	 * @param account SignOnUserAccount
	 * @return int
	 * @exception EventException
	 */
	public int managePartnerSCG(PartnerApprovalRequestVO partnerApprovalRequestVO, List<String> keys, SignOnUserAccount account) throws EventException;
	
	/**
	 * VOP_SCG_0023 : Save <br>
	 * SPCL CGO APVL for Partner Lines 를 수정 합니다. <br>
	 * 
	 * @param ScgPrnrAproRqstCgoVO[] scgPrnrAproRqstCgoVOs 
	 * @param SignOnUserAccount account
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
	 * @param ScgPrnrAproRqstVO scgPrnrAproRqstVO 
	 * @return String
	 * @exception EventException
	 */
	public String searchPatnerSCGMpa1NetSum(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws EventException;
	
	/**
	 * Pre Checking Report 를 조회 합니다. <br>
	 * 
	 * @param PreRestrictionInputVO preRestrictionInputVO
	 * @return PreRestrictionOutputVO
	 * @exception EventException
	 */
	public PreRestrictionOutputVO checkPreRestriction(PreRestrictionInputVO preRestrictionInputVO) throws EventException;

	/**
	 * Pre Checking Report(VVD별 채크기능 추가) 를 조회 합니다. <br>
	 * 
	 * @param PreRestrictionInputVO preRestrictionInputVO
	 * @param boolean segChk
	 * @param boolean vslChk
	 * @param boolean prtChk
	 * @param boolean bkgRequestchk 
	 * @return PreRestrictionOutputVO
	 * @exception EventException
	 */
	public PreRestrictionOutputVO checkPreRestriction(PreRestrictionInputVO preRestrictionInputVO, boolean segChk, boolean vslChk, boolean prtChk, boolean bkgRequestchk) throws EventException;

	/**
	 * Pre Checking Report summary 을 조회 합니다. <br>
	 * 
	 * @param PreRestrictionInputVO preRestrictionInputVO
	 * @return PreRestrictionOutputVO
	 * @exception EventException
	 */
	public PreRestrictionOutputVO searchPreCheckingSummaryList(PreRestrictionInputVO preRestrictionInputVO) throws EventException;
	
}