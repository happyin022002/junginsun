/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OwnDangerousCargoApprovalBC.java
*@FileTitle : SPCL CGO APVL for Own BKG
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.06.04 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic;


import java.util.List;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SegrGrpVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.vo.CBFIFSummaryListVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.OwnApprovalRequestVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionOutputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.RestrictionInputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.RestrictionOutputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.ScgRequestListOptionVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnScgListVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgAprovalAuthCdVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestApvlTimeDetailVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestApvlTimeInputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestApvlTimeOutputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestDetailVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.ScgNonDcgoRequestVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgNonDgCgoKwVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.UndeclaredHistoryVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;
import com.hanjin.syscommon.common.table.OpfVnorItmVO;
import com.hanjin.syscommon.common.table.OpfVnorVO;
import com.hanjin.syscommon.common.table.ScgAproRqstVO;
import com.hanjin.syscommon.common.table.ScgAuthorizationVO;
import com.hanjin.syscommon.common.table.ScgDgCgoVO;
import com.hanjin.syscommon.common.table.ScgRgnShpOprCdVO;
import com.hanjin.syscommon.common.table.ScgVvdAproRqstVO;

/**
 * ALPS-Cargoloadingapproval Business Logic Command Interface<br>
 * - ALPS-Cargoloadingapproval에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Dohyoung Lee
 * @see Vop_scg-0014EventResponse 참조
 * @since J2EE 1.6
 */

public interface OwnDangerousCargoApprovalBC {
	
	/**
	 * Booking에서의 SCG에대한 Request의 요청내용을 저장 합니다. <br>
	 * 
	 * @param scgAproRqstVOs
	 * @param scgVvdAproRqstVOs
	 * @param account
	 * @exception EventException
	 */
	public void requestSpecialCargoApproval(ScgAproRqstVO[] scgAproRqstVOs, ScgVvdAproRqstVO[] scgVvdAproRqstVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Booking에서의 SCG CARGO에 대한 CANCEL 및 DELETE의 요청내용을 저장 합니다. <br>
	 * 
	 * @param scgFlg String
	 * @param bkgNo String
	 * @param cgoSeqs String[]
	 * @param spclCgoAproCds	String[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 * @description scgFlg:'DG','AK','BB','RF', 
	 * 
	 */
	public void cancelSpecialCargoRequest(String scgFlg, String bkgNo, String[] cgoSeqs, String[] spclCgoAproCds, SignOnUserAccount account) throws EventException;
	
	/**
	 * SPCL CGO APVL for Own BKG의 List를 조회 합니다. <br>
	 * 
	 * @param scgRequestListOptionVO
	 * @param account
	 * @return SearchOwnScgListVO
	 * @exception EventException
	 */
	public SearchOwnScgListVO searchScgRequestList(ScgRequestListOptionVO scgRequestListOptionVO, SignOnUserAccount account) throws EventException;

	/**
	 * SPCL CGO APVL for Own BKG의 승인내용을 저장 합니다. <br>
	 * 
	 * @param scgAuthorizationVO
	 * @param arrCrrCd
	 * @param arrPolCd
	 * @param strScgFlg
	 * @param account
	 * @return List<SearchScgAprovalAuthCdVO
	 * @exception EventException
	 */
	public List<SearchScgAprovalAuthCdVO> manageSCGApproval(ScgAuthorizationVO[] scgAuthorizationVO, String[] arrCrrCd, String[] arrPolCd, String strScgFlg, SignOnUserAccount account) throws EventException;
	
	/**
	 * SPCL CGO APVL for Own BKG 수정내용을 저장 합니다. <br>
	 * 
	 * @param scgAuthorizationVOs
	 * @param account
	 * @exception EventException
	 */
	public void manageSCGApproved(ScgAuthorizationVO[] scgAuthorizationVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * SPCL CGO APVL for Own BKG의 메일전송 결과를 저장 합니다. <br>
	 * 
	 * @param scgRequestListOptionVO
	 * @param account
	 * @exception EventException
	 */
	public void modifySCGApprovalMail(ScgRequestListOptionVO scgRequestListOptionVO, SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Application Request & Approval Status 의 List를 조회 합니다. <br>
	 * 
	 * @param scgRequestListOptionVO
	 * @return SearchOwnScgListVO
	 * @exception EventException
	 */
	public SearchOwnScgListVO searchScgApprovalStatusList(ScgRequestListOptionVO scgRequestListOptionVO) throws EventException;

	/**
	 * Application Request & Approval Status 에서 apro_ref_no를 수정 합니다. <br>
	 * 
	 * @param scgRequestListOptionVOs
	 * @param account
	 * @exception EventException
	 */
	public void modifySCGAproRefNoByHis(ScgRequestListOptionVO[] scgRequestListOptionVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Dangerous CGO Application Details for Own BKG 의 Detail를 조회 합니다. <br>
	 * 
	 * @param scgDgCgoVO
	 * @return List<SearchScgDgRequestDetailVO>
	 * @exception EventException
	 */
	public List<SearchScgRequestDetailVO> searchScgRequestDetail(ScgDgCgoVO scgDgCgoVO) throws EventException;
	
//	/**
//	 * Pre Checking Report 를 조회 합니다. <br>
//	 * 
//	 * @param preRestrictionInputVO
//	 * @return PreRestrictionOutputVO
//	 * @exception EventException
//	 */
//	public PreRestrictionOutputVO checkPreRestriction(PreRestrictionInputVO preRestrictionInputVO) throws EventException;
//	
//	/**
//	 * Pre Checking Report(VVD별 채크기능 추가) 를 조회 합니다. <br>
//	 * 
//	 * @param preRestrictionInputVO
//	 * @param segChk
//	 * @param vslChk
//	 * @param prtChk
//	 * @return PreRestrictionOutputVO
//	 * @exception EventException
//	 */
//	public PreRestrictionOutputVO checkPreRestriction(PreRestrictionInputVO preRestrictionInputVO, boolean segChk, boolean vslChk, boolean prtChk) throws EventException;
	
	/**
	 * Mail Preview 를 조회 합니다. <br>
	 * 
	 * @param ownApprovalRequestVO
	 * @return List<OwnApprovalRequestVO>
	 * @exception EventException
	 */
	public List<OwnApprovalRequestVO> searchSCGMailingList(OwnApprovalRequestVO ownApprovalRequestVO) throws EventException;
	
	/**
	 * Dangerous CGO Application Details for Partner Lines 의 Restrictions 을 조회 합니다. <br>
	 * 
	 * @param restrictionInputVO
	 * @return List<RestrictionOutputVO>
	 * @exception EventException
	 */
	public List<RestrictionOutputVO> searchRestrictions(RestrictionInputVO restrictionInputVO) throws EventException;
	
	/**
	 * Time of SPCL CGO Request APVL 의 KPI 를 조회 합니다. <br>
	 * 
	 * @param searchScgRequestApvlTimeInputVO
	 * @return List<SearchScgRequestApvlTimeOutputVO>
	 * @exception EventException
	 */
	public List<SearchScgRequestApvlTimeOutputVO> searchScgRequestApvlTimeList(SearchScgRequestApvlTimeInputVO searchScgRequestApvlTimeInputVO) throws EventException;
	
	/**
	 * Time of SPCL CGO Request APVL 의 KPI 상세정보 를 조회 합니다. <br>
	 * 
	 * @param searchScgRequestApvlTimeInputVO
	 * @return List<SearchScgRequestApvlTimeDetailVO>
	 * @exception EventException
	 */
	public List<SearchScgRequestApvlTimeDetailVO> searchScgRequestApvlTimeDetailList(SearchScgRequestApvlTimeInputVO searchScgRequestApvlTimeInputVO) throws EventException;
	
	/**
	 * 유사한 화학적 특성을 갖는 위험물 격리군(Segregation Groups) ( ComboList) 조회.<br>
	 * 
	 * @return List<SegrGrpVO>
	 * @throws EventException
	 */
	public List<SegrGrpVO> searchSegrGrp() throws EventException;
	
	/**
     * Target LaneCode for SPCL CGO APVL 체크한다. <br>
	 * 
	 * @param  String vslSlanCd
	 * @return List<MdmVslSvcLaneVO> 
	 * @exception EventException
	 */
	public List<MdmVslSvcLaneVO> checkLaneCd(String vslSlanCd) throws EventException;

	/**
     * Systematic Inspection Filtering Text정보를 조회 합니다. <br>
	 * 
	 * @param scgNonDcgoRequestVO
	 * @return List<ScgNonDcgoRequestVO>
	 * @exception EventException
	 */
	public List<ScgNonDcgoRequestVO> scgNonDcgoRequestList(ScgNonDcgoRequestVO scgNonDcgoRequestVO) throws EventException;
	
	/**
	 * Systematic Inspection Filtering Text정보를 수정 합니다. <br>
	 * 
	 * @param scgNonDcgoRequestVOs
	 * @param account
	 * @exception EventException
	 */
	public void modifyScgNonDcgoRequest(ScgNonDcgoRequestVO[] scgNonDcgoRequestVOs,SignOnUserAccount account) throws EventException;

	/**
	 * BOOKING의 KEYWORD정보결과를 저장하는 Interface입니다. <br>
	 * 
	 * @param scgNonDcgoRequestVO
	 * @param keySeq
	 * @exception EventException
	 */
	public void addScgNonDgCgoKwRqst(ScgNonDcgoRequestVO scgNonDcgoRequestVO, String[] keySeq) throws EventException;
	
	/**
	 * Systematic Inspection Filtering Text의 메일전송 결과를 저장 합니다. <br>
	 * 
	 * @param scgNonDcgoRequestVO
	 * @param account
	 * @exception EventException
	 */
	public void scgNonDcgoRequestMail(ScgNonDcgoRequestVO scgNonDcgoRequestVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Systematic Inspection Filtering Text의 메일Format을 조회 합니다. <br>
	 * 
	 * @param scgNonDcgoRequestVO
	 * @param account
	 * @return List<ScgNonDcgoRequestVO>
	 * @exception EventException
	 */
	public List<ScgNonDcgoRequestVO> scgNonDcgoRequestMailFormat(ScgNonDcgoRequestVO scgNonDcgoRequestVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Systematic Inspection Filtering Text 자동 메일을 전송한다.<br>
	 * 
	 * @param scgNonDcgoRequestVO
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public String sendVnorEmail(ScgNonDcgoRequestVO scgNonDcgoRequestVO, SignOnUserAccount account) throws EventException;
	
	/*====================================================================================*/
	/**
	 * Undeclared History 정보를 조회합니다.<br>
	 * 
	 * @param UndeclaredHistoryVO undeclaredHistoryVO
	 * @return List<UndeclaredHistoryVO>
	 * @exception EventException
	 */
	public List<UndeclaredHistoryVO> searchUndeclaredHistoryList(UndeclaredHistoryVO undeclaredHistoryVO) throws EventException ;
	
	/**
	 * Undeclared History 생성/수정 합니다.<br>
	 * 
	 * @param undeclaredHistoryVOs
	 * @param account
	 * @return List<UndeclaredHistoryVO>
	 * @exception EventException
	 */
	public String manageUndeclaredHistory(UndeclaredHistoryVO[] undeclaredHistoryVOs, List<String> keys, SignOnUserAccount account) throws EventException ;
	
	/**
	 * Undeclared History BKG_NO. 체크<br>
	 * 
	 * @param UndeclaredHistoryVO undeclaredHistoryVO
	 * @return String
	 * @exception EventException
	 */
	public String checkUndeclaredHistory(UndeclaredHistoryVO undeclaredHistoryVO) throws EventException;
	
}