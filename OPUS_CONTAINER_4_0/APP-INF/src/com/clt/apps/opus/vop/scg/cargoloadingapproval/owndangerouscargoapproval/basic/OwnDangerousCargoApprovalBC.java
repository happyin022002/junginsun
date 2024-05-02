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
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic;

import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.OwnApprovalEmlVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.OwnApprovalRequestVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionOutputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.RestrictionInputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.RestrictionOutputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.ScgRequestListOptionVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnDGListVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchOwnScgListVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgAprovalAuthCdVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestApvlTimeDetailVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestApvlTimeInputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestApvlTimeOutputVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SearchScgRequestDetailVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.SendDgEdiRequestVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ScgAproRqstVO;
import com.clt.syscommon.common.table.ScgAuthorizationVO;
import com.clt.syscommon.common.table.ScgDgCgoVO;
import com.clt.syscommon.common.table.ScgVvdAproRqstVO;


/**
 * OPUS-Cargoloadingapproval Business Logic Command Interface<br>
 * - OPUS-Cargoloadingapproval에 대한 비지니스 로직에 대한 인터페이스<br>
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
	
	/**
	 * Pre Checking Report 를 조회 합니다. <br>
	 * 
	 * @param preRestrictionInputVO
	 * @return PreRestrictionOutputVO
	 * @exception EventException
	 */
	public PreRestrictionOutputVO checkPreRestriction(PreRestrictionInputVO preRestrictionInputVO) throws EventException;
	
	/**
	 * Pre Checking Report(VVD별 채크기능 추가) 를 조회 합니다. <br>
	 * 
	 * @param preRestrictionInputVO
	 * @param segChk
	 * @param vslChk
	 * @param prtChk
	 * @return PreRestrictionOutputVO
	 * @exception EventException
	 */
	public PreRestrictionOutputVO checkPreRestriction(PreRestrictionInputVO preRestrictionInputVO, boolean segChk, boolean vslChk, boolean prtChk) throws EventException;
	
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
	 * Mail Target retrieve <br>
	 * 
	 * @param mapVO
	 * @return String
	 * @exception EventException
	 */
	public String searchSCGMailAdrsList(Map<String, String> mapVO) throws EventException;
	
	/**
	 * Mail Target <br>
	 *  
	 * @param ownApprovalEmlVO
	 * @param ownApprovalRequestVO
	 * @param account 	  
	 * @return String
	 * @exception EventException
	 */
	public String specialCargoRequestApprovalEml(OwnApprovalEmlVO ownApprovalEmlVO , OwnApprovalRequestVO ownApprovalRequestVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * SPCL CGO APVL for Own BKG의DG Cancel대상 목록 조회 <br>
	 * 
	 * @param scgRequestListOptionVO
	 * @param account
	 * @return SearchOwnScgListVO
	 * @exception EventException
	 */
	public SearchOwnScgListVO searchEdiCancelRequestList(ScgRequestListOptionVO scgRequestListOptionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * edi cancel 대상 조회 <br>
	 * 
	 * @param Map<String, String> mapVO
	 * @return List<SendDgEdiRequestVO>
	 * @exception EventException
	 */
	public List<SendDgEdiRequestVO> searchEdiCancelStatus(Map<String, String> mapVO) throws EventException;
	
	/**
	 * edi cancel 대상 조회 <br>
	 * 
	 * @param Map<String, String> mapVO
	 * @return List<SendDgEdiRequestVO>
	 * @exception EventException
	 */
	public List<SendDgEdiRequestVO> searchVVDAproRqstForNormal(Map<String, String> mapVO) throws EventException;
	
	/**
	 * DG CGO Detail 조회 <br>
	 * 
	 * @param ScgDgCgoVO scgDgCgoVO
	 * @return List<ScgDgCgoVO>
	 * @exception EventException
	 */
	public List<ScgDgCgoVO> searchScgDgCgoRctDetail(ScgDgCgoVO scgDgCgoVO) throws EventException;
	
	/**
	 * BKG POL의 CONTINENT CODE 조회 <br>
	 * 
	 * @param String sBkgNo
	 * @return String
	 * @throws EventException
	 */
	//public String searchContiCdforBKGRSQL(String sBkgNo) throws EventException;
	
	/**
	 * SPCL CGO Approved Details DG List를 조회 합니다. <br>
	 * 
	 * @param scgRequestListOptionVO
	 * @param account
	 * @return SearchOwnScgListVO
	 * @exception EventException
	 */
	public SearchOwnScgListVO searchScgAprvDetailtList(ScgRequestListOptionVO scgRequestListOptionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * SPCL CGO Approved Details DG IF Remark Update <br>
	 * @param SearchScgAprovalAuthCdVO	searchScgAprovalAuthCdVO
	 * @param account
	 * @exception EventException
	 */
	public void modifySCGRequestIfRmk(SearchScgAprovalAuthCdVO	searchScgAprovalAuthCdVO, SignOnUserAccount account) throws EventException;
	
	
}