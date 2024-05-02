/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UserSetupMgtBC.java
*@FileTitle : Mark & Description Template
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.04.27 김영출
* 1.0 Creation
* ------------------------------------------------------
* HISTORY
* 2014.10.20 김도현[CHM-201431786] 테스트_온라인(WEB) Booking 개선 (1차) - Web Booking Manual Upload Setup Table 추가 
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.MandatoryItemSetupListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgAlocMgmtVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgChkPntItemTpVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgChkPntItemVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgCustChkPntVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgInternetAuthorityVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgSrchSetVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BlckKwListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.CustChkPntAttachVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.DraftBlImageVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.RptItmStupVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.TroRmkStupVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCorrectionVO;
import com.hanjin.syscommon.common.table.BkgUsrDfltSetVO;
import com.hanjin.syscommon.common.table.BkgUsrTmpltVO;
import com.hanjin.syscommon.common.table.BkgXterSrchSetVO;
import com.hanjin.syscommon.common.table.MdmOrganizationVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.WebBkgManualUploadSetupVO;

/**
 * NIS2010-Bookingmaterdata Business Logic Command Interface<br>
 * - NIS2010-Bookingmaterdata에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Youngchul
 * @see Ui_bkg-0365EventResponse 참조
 * @since J2EE 1.4
 */

public interface UserSetupMgtBC {
    
	/**
	 * User Template List 조회 메소드.<br>
	 *
	 * @author KimYoungchul
	 * @param usrTmpltVo
	 * @return List<BkgUsrTmpltVO>
	 * @exception EventException
	 */
	public List<BkgUsrTmpltVO> searchUserTmpltList(BkgUsrTmpltVO usrTmpltVo) throws EventException;
    
    /**
     * User Template List 관리 메소드.<br>
     *
     * @author KimYoungchul
     * @param usrTmpltVo
     * @param account
     * @exception EventException
     */
    public void manageUserTmpltList(BkgUsrTmpltVO[] usrTmpltVo, SignOnUserAccount account) throws EventException;
    	
	/**
	 * 조회 이벤트 처리<br>
	 * Usersetupmgt2화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param BkgUsrTmpltVO usrTmpltVo
	 * @return List<BkgUsrTmpltVO>
	 * @exception EventException
	 */
	public List<BkgUsrTmpltVO> searchRmkTemplate(BkgUsrTmpltVO usrTmpltVo) throws EventException;
	
	/**
    * 조회 이벤트 처리<br>
    * UserSetupMgt화면에 대한 조회 이벤트 처리<br>
    * booking담당자별 각각의 화면에서 미리 정의된 Data를 Display해 주는 Data를 User별 조회한다<br>
    * 
    * @param String userid
    * @return BkgUsrDfltSetVO
    * @exception EventException
    */
	public BkgUsrDfltSetVO searchUserDefaultSetting (String userid) throws EventException ;
	
	/**
     * 멀티 이벤트 처리<br>
     * In화면에 대한 멀티 이벤트 처리<br>
     * booking담당자별 각각의 화면에서 미리 정의된 Data를 Display해 주는 Data를 User별 입력해놓는다<br>
     * 
     * @param BkgUsrDfltSetVO vo
     * @exception EventException
     */
    public void createUserDefaultSettingByBooking(BkgUsrDfltSetVO vo) throws EventException ;

	/**
	 * 조회 이벤트 처리<br>
	 * Usersetupmgt화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String usrId
	 * @return List<BkgXterSrchSetVO>
	 * @exception EventException
	 */
	public List<BkgXterSrchSetVO> searchUserXterSearchSet(String usrId) throws EventException;

    /**
     * 멀티 이벤트 처리<br>
     * Usersetupmgt 화면에 대한 멀티 이벤트 처리<br>
     * 
     * @param BkgXterSrchSetVO[] bkgXterSrchSetVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageUserXterSearchSet(BkgXterSrchSetVO[] bkgXterSrchSetVO,SignOnUserAccount account) throws EventException;

    
	/**
	 * Internet O/BL 승인권한에 등록된 유저를 조회한다.
	 * @param BkgInternetAuthorityVO bkgInternetAuthorityVO
	 * @return  List<BkgInternetAuthorityVO>
	 * @exception EventException
	 */		
	public List<BkgInternetAuthorityVO> searchUserInternetAuth(BkgInternetAuthorityVO bkgInternetAuthorityVO) throws EventException;
	
    /**
     * 멀티 이벤트 처리<br>
     * Usersetupmgt 화면에 대한 멀티 이벤트 처리<br>
     * 
     * @param BkgInternetAuthorityVO[] bkgInternetAuthorityVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageUserInternetAuth(BkgInternetAuthorityVO[] bkgInternetAuthorityVO,SignOnUserAccount account) throws EventException;

    /**
	 * 0743,0064 B/L Print 옵션을 조회합니다.<br>
	 * @param BkgUsrDfltSetVO bkgUsrDfltSetVO
	 * @param SignOnUserAccount account
	 * @return List<BkgUsrDfltSetVO>
	 * @throws EventException
	 */
	public List<BkgUsrDfltSetVO> searchUserPrintSetup(BkgUsrDfltSetVO bkgUsrDfltSetVO, SignOnUserAccount account) throws EventException;
	
	/**
	  * 0743 C/A No 옵션을 조회합니다.<br>
	  * @param String bkgNo
	  * @param SignOnUserAccount account
	  * @return List<BkgCorrectionVO>
	  * @throws EventException
	  */
	 public List<BkgCorrectionVO> searchUserPrintSetup2(String bkgNo, SignOnUserAccount account) throws EventException;
	 
	 /**
	  * 0743_01 그룹 프린트를 위해 초기 조건들을 조회한다.<br>
	  * @param BkgUsrDfltSetVO bkgUsrDfltSetVO 
	  * @param String module
	  * @return List<BkgUsrDfltSetVO>
	  * @throws EventException
	  */
	 public List<BkgUsrDfltSetVO> searchUserPrintSetup3(BkgUsrDfltSetVO bkgUsrDfltSetVO, String module) throws EventException;
	 /**
	  * 0743_01 프린트 설정을 조회한다.<br>
	  * @param BkgUsrDfltSetVO bkgUsrDfltSetVO 
	  * @return List<BkgUsrDfltSetVO>
	  * @throws EventException
	  */
	 public List<BkgUsrDfltSetVO> searchUserPrintSetup4(BkgUsrDfltSetVO bkgUsrDfltSetVO) throws EventException;
    /**
	 *  0743,0064 B/L Print 옵션을 저장합니다.<br>
	 *  
	 * @param bkgUsrDfltSetVO BkgUsrDfltSetVO
	 * @param SignOnUserAccount account
     * @exception EventException
	 */
	public void manageUserPrintSetup(BkgUsrDfltSetVO bkgUsrDfltSetVO, SignOnUserAccount account) throws EventException;
	
	/**
	  * 0922 Office 상세정보를 조회합니다.<br>
	  * @param String ofcCd 
	  * @param SignOnUserAccount account
	  * @return List<MdmOrganizationVO>
	  * @throws EventException
	  */
	 public List<MdmOrganizationVO> searchOfficeDetail(String ofcCd, SignOnUserAccount account) throws EventException;

    /**
     * searchRptItmStup
     * 
     * @author KimYoungchul
     * @param ofcCd
     * @param custCd
     * @return List<RptItmStupVO>
     * @throws EventException
     */
    public List<RptItmStupVO> searchRptItmStup(String ofcCd, String custCd) throws EventException;

    /**
     * manageRptItmStup
     * 
     * @author KimYoungchul
     * @param rptItmStupVOs
     * @param account 
     * @throws EventException
     */
    public void manageRptItmStup(RptItmStupVO[] rptItmStupVOs, SignOnUserAccount account) throws EventException;

    /**
     * searchOfcCd
     * 
     * @author KimYoungchul
     * @return List<BkgComboVO>
     * @throws EventException
     */
    public List<BkgComboVO> searchOfcCd() throws EventException;
    
    /**
     * searchTroRmkStup
     * 
     * @author Chowonjoo
     * @param String bkgTroOfcCd
     * @return List<TroRmkStupVO>
     * @throws EventException
     */
    public List<TroRmkStupVO> searchTroRmkStup(String bkgTroOfcCd) throws EventException;
    
    /**
     * manageTroRmkStup
     * 
     * @author Wonjoo Cho
     * @param TroRmkStupVO[] troRmkStupVOs
     * @param account 
     * @throws EventException
     */
    public void manageTroRmkStup(TroRmkStupVO[] troRmkStupVOs, SignOnUserAccount account) throws EventException;
    
    /**
     * Booking Allocation Master Table 화면 조회 메소드
     * 
     * @author ChoiMoonHwan
     * @param BkgAlocMgmtVO bkgAlocMgmtVO
     * @return List<BkgAlocMgmtVO>
     * @throws EventException
     */
    public List<BkgAlocMgmtVO> searchBkgAlocMgmt(BkgAlocMgmtVO bkgAlocMgmtVO) throws EventException;
    
    /**
     * Booking Allocation Master Table 화면 관리 메소드.<br>
     *
     * @author ChoiMoonHwan
     * @param BkgAlocMgmtVO[] bkgAlocMgmtVO
     * @param account
     * @exception EventException
     */
    public void manageBkgAlocMgmt(BkgAlocMgmtVO[] bkgAlocMgmtVO, SignOnUserAccount account) throws EventException;
    
    /**
     * Booking Allocation Master Table 화면에서 단건의 Seq별로 삭제를 처리한다.<br>
     * 
	 * @author 		ChoiMoonHwan
     * @param 		BkgAlocMgmtVO bkgAlocMgmtVO
	 * @exception 	EventException
     */
    public void removeBkgAlocMgmt(BkgAlocMgmtVO bkgAlocMgmtVO) throws EventException;
    
    /**
	 * Booking Allocation Master Table 화면에서 T.Lane과 BD값을 검증 한다.<br>
	 * 
	 * @param String valType
	 * @param String valValue
	 * @return List<BkgAlocMgmtVO>
	 * @exception EventException
	 */	
	public List<BkgAlocMgmtVO> searchBkgAlocValidationData(String valType, String valValue) throws EventException;

	/**
     * Booking Allocation Master Table 화면에 Commodity Name을 찾아온다.
     * 
     * @author ChoiMoonHwan
     * @param BkgAlocMgmtVO bkgAlocMgmtVO
     * @return List<BkgAlocMgmtVO>
     * @throws EventException
     */
    public List<BkgAlocMgmtVO> searchCmdtNm(BkgAlocMgmtVO bkgAlocMgmtVO) throws EventException;    
    
    /**
     * Booking Allocation Master Table 화면에 Group Commodity Name을 찾아온다.
     * 
     * @author ChoiMoonHwan
     * @param BkgAlocMgmtVO bkgAlocMgmtVO
     * @return List<BkgAlocMgmtVO>
     * @throws EventException
     */
    public List<BkgAlocMgmtVO> searchGrpCmdtNm(BkgAlocMgmtVO bkgAlocMgmtVO) throws EventException;    
    
    /**
     * Draft B/L image 목록을 조회한다.
     * 
     * @author ChaSangyoung
     * @param DraftBlImageVO draftBlImageVO
     * @return List<DraftBlImageVO>
     * @throws EventException
     */
    public List<DraftBlImageVO> searchDraftBlImageList(DraftBlImageVO draftBlImageVO) throws EventException;    
    
    

	/**
     * 멀티 이벤트 처리<br>
     * draft B/L image 화면에 대한 멀티 이벤트 처리<br>
     * 
     * @param DraftBlImageVO[] draftBlImageVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageDraftBlImage(DraftBlImageVO[] draftBlImageVOs, SignOnUserAccount account) throws EventException ;
    

    /**
     * draft b/l image customer code 존재여부 조회
     * 
     * @author ChaSangyoung
     * @param DraftBlImageVO draftBlImageVO
     * @return String
     * @throws EventException
     */
    public String searchDraftBlImageCustCodeYN(DraftBlImageVO draftBlImageVO) throws EventException;
    
    /**
     * Web Booking Manual Upload Setup Table 화면 조회 메소드
     * 
     * @param WebBkgManualUploadSetupVO webBkgManualUploadSetupVO
     * @return List<WebBkgManualUploadSetupVO>
     * @throws EventException
     */
    public List<WebBkgManualUploadSetupVO> searchWebBkgManualUploadSetup(WebBkgManualUploadSetupVO webBkgManualUploadSetupVO) throws EventException;
    
    /**
     * Web Booking Manual Upload Setup Table 화면 관리 메소드.<br>
     *
     * @param WebBkgManualUploadSetupVO[] webBkgManualUploadSetupVO
     * @param account
     * @exception EventException
     */
    public void manageWebBkgManualUploadSetup(WebBkgManualUploadSetupVO[] webBkgManualUploadSetupVO, SignOnUserAccount account) throws EventException;
    
    /**
     * Web Booking Manual Upload Setup Table 등록 항목이 중복되는지 체크
     * 
     * @param WebBkgManualUploadSetupVO webBkgManualUploadSetupVO
     * @return String
     * @throws EventException
     */
    public String searchWebBkgManualUploadSetupDupChk(WebBkgManualUploadSetupVO[] webBkgManualUploadSetupVO) throws EventException;
    
	/**
	 * Web Booking Manual Upload Setup Table 등록 시 VVD와 Country 체크.<br>
	 * 
	 * @param String vslCd 
	 * @param String voyNo 
	 * @param String dirCd 
	 * @param String cntCd 
	 * @return String
     * @throws EventException
     */
    public String searchWebBkgManualUploadSetupvalidateVvdCnt(String vslCd, String voyNo, String dirCd, String cntCd) throws EventException;
    
    
    
    /**
     * 유저id 별로 조회조건정보를 조회한다.
     * @param String usrId
     * @return List<BkgSrchSetVO>
     * @throws EventException
     */
    public List<BkgSrchSetVO> searchUserSearchSet(String usrId) throws EventException;
    
    /**
     * 유저id 별로 조회조건정보를 저장한다.
     * @param BkgSrchSetVO[] bkgSrchSetVOs
     * @param SignOnUserAccount account
     * @throws EventException
     */
    public void manageUserSearchSet(BkgSrchSetVO[] bkgSrchSetVOs,SignOnUserAccount account) throws EventException;   
    
    /**
     *Customer Check Point 조회
     * @param BkgCustChkPntVO bkgCustChkPntVO
     * @return  List<BkgCustChkPntVO>
     * @throws EventException
     */    
    public List<BkgCustChkPntVO> searchCustChkPnt(BkgCustChkPntVO bkgCustChkPntVO) throws EventException;
    
    /**
     * Customer Check Point 관리<br>
     *
     * @param BkgCustChkPntVO[] bkgCustChkPntVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageBkgCustChkPnt(BkgCustChkPntVO[] bkgCustChkPntVOs, SignOnUserAccount account) throws EventException;
    
    /**
     *Customer Check Point Item 조회
     * @param BkgChkPntItemVO bkgChkPntItemVO
     * @return  List<BkgChkPntItemVO>
     * @throws EventException
     */    
    public List<BkgChkPntItemVO> searchChkPntItem(BkgChkPntItemVO bkgChkPntItemVO) throws EventException;
    
    /**
     * Check Point Item 관리<br>
     *
     * @param BkgChkPntItemVO[] bkgChkPntItemVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageBkgChkPntItem(BkgChkPntItemVO[] bkgChkPntItemVOs, SignOnUserAccount account) throws EventException;
    
    /**
     *Check Point Item Type조회
     * @param BkgChkPntItemTpVO bkgChkPntItemTpVO
     * @return  List<BkgChkPntItemTpVO>
     * @throws EventException
     */    
    public List<BkgChkPntItemTpVO> searchChkPntItemTp(BkgChkPntItemTpVO bkgChkPntItemTpVO) throws EventException;
    
    /**
     * Check Point Item Type 관리<br>
     *
     * @param BkgChkPntItemTpVO[] bkgChkPntItemTpVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageBkgChkPntItemTp(BkgChkPntItemTpVO[] bkgChkPntItemTpVOs, SignOnUserAccount account) throws EventException;
    
    /**
	 *  Attachment File 목록 조회<br>
	 * 
	 * @param CustChkPntAttachVO vo
	 * @return List<CustChkPntAttachVO>
	 * @exception EventException
	 */
	public List<CustChkPntAttachVO> searchCustChkPntAttach(CustChkPntAttachVO vo) throws EventException;
	
	/**
	 * ESM_BKG_0239 멀티 이벤트 처리<br>
	 * @param CustChkPntAttachVO[] vos
	 * @param String[] fileSavId
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustChkPntAttach(CustChkPntAttachVO[] vos, String[] fileSavId, SignOnUserAccount account) throws EventException;
	
	/**
	 * Block Keyword List 조회<br>
	 * 
	 * @param  String blckKwTpCd
	 * @return List<BlckKwListVO>
	 * @exception EventException
	 */
	public List<BlckKwListVO> searchBkgBlckKwList(String blckKwTpCd) throws EventException;
	
	/**
	 * BKG Blck kw list SAVE 처리.<br>
	 * 
	 * @param BlckKwListVO[] vos
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBkgBlckKwList(BlckKwListVO[] vos,SignOnUserAccount account) throws EventException;
    
}