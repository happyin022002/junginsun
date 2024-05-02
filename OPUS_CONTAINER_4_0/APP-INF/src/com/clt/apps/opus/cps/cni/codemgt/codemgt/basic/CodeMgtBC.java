/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CNICodeMgtBC.java
 *@FileTitle : 공통코드및 기준정보 관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.10.05 박제성 , 진윤오 , 정행룡 , 양정란 , 윤세영
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.12.10 이준범 [CHM-201007236-01]
 * 1.제목 : CNI Main Code Creation Logic 보완 및 Popup 화면 추가 요청
 * 2.처리내역
 *  2.1 Main code creation시 Code 생성 규칙에 따른 중복 유사 Code를 검색하여 
 *      그 결과를 Popup display하며 User의 선택에  따라 생성 또는 Detail 
 *      information을 확인할 수 있는 Main Code View 화면으로 이동하도록 보완 
=========================================================*/
package com.clt.apps.opus.cps.cni.codemgt.codemgt.basic;

import java.util.List;

import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.ClassCodeVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.CniClassCodeVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.CniMiscCodeVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.CniPartyVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.ContactPointVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.HandlerHistoryVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.MdmOrganizationVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.MiscCodeVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.MiscellaneousVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.PartyCntVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.PartyInquiryCondVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.PartyInquiryVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.PartyVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.SearchClaimCodeListVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.VvdSkdCondVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.VvdSkdVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.SearchAgentVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.SearchRoeListVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.SearchVesselListVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.SearchVesselVvdListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;


/**
 * CNI Code Business Logic Command Interface<br>
 * @author 
 * @see 
 * @since J2EE 1.4
 */

public interface CodeMgtBC {
    
	
    // ---------------------------------------------------------------------------
    // 공통 
    // ---------------------------------------------------------------------------
	
	/**
	 * CNI GMT(YYYY-MM-DD)  조회<br>
	 * @author 진윤오
	 * @category common
	 * @category searchGmtDate 
	 * @param String userId
     * @return String
     * @throws EventException
     */
    public String searchGmtDate(String userId) throws EventException ;

    // ===========================================================================
    // 진윤오
    // ===========================================================================

	// ---------------------------------------------------------------------------
	// [CPS_CNI_0025] Main Code Creation
	// ---------------------------------------------------------------------------

	/**
	 * Claim Party 정보 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0025
	 * @category searchPartyInfo 
	 * @param String clmPtyNo
     * @return PartyVO 
     * @throws EventException
     */
	public PartyVO searchPartyInfo(String clmPtyNo) throws EventException;

	/**
	 * Claim Party 별 Cni Contact Point 리스트 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0025
	 * @category searchContactPointList 
	 * @param String clmPtyNo
     * @return List<ContactPointVO> 
     * @throws EventException
     */
	public List<ContactPointVO> searchContactPointList(String clmPtyNo) throws EventException;

	/**
	 * Claim Party 정보 및 Contact Point  수정 ,입력<br>
	 * @author 진윤오
	 * @category CPS_CNI_0025
	 * @category managePartyContactPoint 
	 * @param PartyCntVO partyCntVO
	 * @return String
	 * @exception EventException
	 */
	public String managePartyContactPoint(PartyCntVO partyCntVO) throws EventException;
	
	/**
	 * Claim Party 정보 삭제<br>
	 * @author 진윤오
	 * @category CPS_CNI_0025
	 * @category removeParty 
	 * @param CniPartyVO cniPartyVO
	 * @exception EventException
	 */
	public void removeParty(CniPartyVO cniPartyVO) throws EventException;	
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0026] Main Code-Inquiry
	// ---------------------------------------------------------------------------
	/**
	 * Claim Party 리스트 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0026
	 * @category searchPartyInquiryList 
	 * @param PartyInquiryCondVO partyInquiryCondVO
     * @return List<PartyInquiryVO>
     * @throws EventException
     */
	public List<PartyInquiryVO> searchPartyInquiryList(PartyInquiryCondVO partyInquiryCondVO) throws EventException;
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0095] Main Code-Popup
	// ---------------------------------------------------------------------------
	/**
	 * Claim Party 리스트 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0095
	 * @category searchPartyPopupList 
	 * @param String ptyNm
     * @return List<PartyInquiryVO>
     * @throws EventException
     */	
	public List<PartyInquiryVO> searchPartyPopupList(String ptyNm) throws EventException ;
	// ---------------------------------------------------------------------------
	// [CPS_CNI-0042] 
	// ---------------------------------------------------------------------------    
    /**
     * CCC VVD & SKD Inquiry 
	 * vvd  Vessel schedule 리스트 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0042
	 * @category searchVvdSkdList 
	 * @param VvdSkdCondVO vvdSkdCondVO
     * @return List<VvdSkdVO>
     * @throws EventException
     */
    public List<VvdSkdVO> searchVvdSkdList(VvdSkdCondVO vvdSkdCondVO) throws EventException;	
	
	// ===========================================================================
    // 정행룡
    // ===========================================================================
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0004] Handler History
	// ---------------------------------------------------------------------------
	/**
	 * Claim No별 Handler History 리스트 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0004
	 * @category searchHandlerHistoryList 
	 * @param String cgoClmNo 
	 * @param String mgrHdlrDivCd 
     * @return List<HandlerHistoryVO> 
     * @throws EventException
     */
	public List<HandlerHistoryVO> searchHandlerHistoryList(String cgoClmNo, String mgrHdlrDivCd) throws EventException;
    
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0005] Manager History
	// ---------------------------------------------------------------------------
	/**
	 * Claim No별 Manager History 리스트 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0005
	 * @category searchManagerManagerHistoryList 
	 * @param String cgoClmNo
	 * @param String mgrHdlrDivCd
     * @return List<HandlerHistoryVO>  
     * @throws EventException
     */
	public List<HandlerHistoryVO> searchManagerHistoryList(String cgoClmNo, String mgrHdlrDivCd) throws EventException;
    
	/**
	 * Claim Manager 정보 등록, 수정, 삭제 처리<br>
	 * @author 정행룡
	 * @category CPS_CNI_0005
	 * @category manageManagerHistory 
	 * @param HandlerHistoryVO[] HandlerHistoryVO
	 * @exception EventException
	 */
	
	public void manageManagerHistory(HandlerHistoryVO[] HandlerHistoryVO) throws EventException;
	
	/**
	 * Handler History 정보 등록<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category addHandlerHistory
	 * @param HandlerHistoryVO handlerHistoryVO
	 * @exception EventException
	 */
	public void addHandlerHistory(HandlerHistoryVO handlerHistoryVO) throws EventException;
	
	
	/**
	 * Claim Handler 정보 등록, 수정<br>
	 * @author 정행룡
	 * @category CPS_CNI_0005
	 * @category manageHandlerHistory 
	 * @param HandlerHistoryVO HandlerHistoryVO 
	 * @param String afterCgoClmStsCd
	 * @exception EventException
	 */
	public void manageHandlerHistory(HandlerHistoryVO handlerHistoryVO, String afterCgoClmStsCd) throws EventException;
		
	/**
	 * Handler History 정보 수정<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category modifyHandlerHistory
	 * @param HandlerHistoryVO handlerHistoryVO
	 * @exception EventException
	 */
	public void modifyHandlerHistory(HandlerHistoryVO handlerHistoryVO) throws EventException;
	
	
	/**
	 * Class Code Validation 체크 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0003
	 * @category searchMiscCodeExist
	 * @param String clssClmMiscCd
	 * @param String clmMiscCd
     * @return String
     * @throws EventException
     */
	public String searchMiscCodeExist(String clssClmMiscCd, String clmMiscCd) throws EventException;
	

   
	
     /**
 	 * Office Code 체크 조회<br>
 	 * @author 정행룡
 	 * @category CPS_CNI_0003
 	 * @category searchMdmOrganizationExist
 	 * @param String ofcCd
      * @return String
     * @throws EventException
     */
	public String searchMdmOrganizationExist(String ofcCd) throws EventException;
	
    // ===========================================================================
    // 양정란
    // ===========================================================================

	// ---------------------------------------------------------------------------
	// [CPS_CNI_0007] Office Code Table
	// ---------------------------------------------------------------------------
	
	/**
	 * Office Code 리스트 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0007
	 * @category searchMdmOrganization 
	 * @param String ofcCd
     * @return List<MdmOrganizationVO> 
     * @throws EventException
     */
	public List<MdmOrganizationVO> searchMdmOrganizationList(String ofcCd) throws EventException;
	
	/**
	 * Office Code 입력값 validation<br>
	 * @author 양정란
	 * @category CPS_CNI_0036
	 * @category searchOfcCd 
	 * @param String ofcCd
     * @return String[] 
     * @throws EventException
     */
	public String[] searchOfcCd(String ofcCd) throws EventException;
	
	/**
	 * UsrId 입력값 validation<br>
	 * @author 양정란
	 * @category CPS_CNI_0036
	 * @category searchUsrId 
	 * @param String ofcCd
	 * @param String usrId
     * @return String[] 
     * @throws EventException
     */
	public String[] searchUsrId(String ofcCd, String usrId) throws EventException;	


    // ===========================================================================
    // 박제성
    // ===========================================================================

	// ---------------------------------------------------------------------------
	// [CPS_CNI_0039] Class Code Creation
	// ---------------------------------------------------------------------------

	/**
	 * Class Code 리스트 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0039
	 * @category searchClassCodeList 	 
     * @return Class Code 리스트 정보 
     * @throws EventException
     */
	public List<ClassCodeVO> searchClassCodeList() throws EventException;
	
	/**
	 * Class Code 멀티 이벤트 처리<br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0039
	 * @category manageClassCode
	 * 
	 * @param CniClassCodeVO[] cniClassCodeVO
	 *            
	 * @throws EventException
	 */
	public void manageClassCode(CniClassCodeVO[] cniClassCodeVO) throws EventException;	
	
	
    // ===========================================================================
    // 박제성
    // ===========================================================================

	// ---------------------------------------------------------------------------
	// [CPS_CNI_0028] Miscellaneous Code Creation
	// ---------------------------------------------------------------------------
	/**
	 * Miscellaneous Code 리스트 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0028
	 * @category searchMiscellaneousList  
	 * @param String clssClmMiscCd
     * @return List<MiscellaneousVO>
     * @throws EventException
     */
	public List<MiscellaneousVO> searchMiscellaneousList (String clssClmMiscCd) throws EventException;
	
	/**
	 * Miscellaneous Code 리스트 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0028
	 * @category searchMiscCodeList 
	 * @param String clssClmMiscCd
	 * @param String clmMiscCd
	 * @param String clmMiscNm
     * @return Miscellaneous Code 리스트 정보 
     * @throws EventException
     */
	public List<MiscCodeVO> searchMiscCodeList(String clssClmMiscCd, String clmMiscCd, String clmMiscNm) throws EventException;
	
	/**
	 * Miscellaneous Code 멀티 이벤트 처리<br>
	 * 
	 * @author 박제성
	 * @category CPS_CNI_0028
	 * @category manageMiscCode
	 * 
	 * @param CniMiscCodeVO[] cniMiscCodeVO
	 *            
	 * @exception EventException
	 */
	public void manageMiscCode(CniMiscCodeVO[] cniMiscCodeVO) throws EventException;
	
	/**
	 * Currency Check<br>
	 * 
	 * @param String currCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCurrency(String currCd) throws EventException ;
	
	/**
	 * Agent 에 관련된 전화번호, e-Mail 정보를 조회한다.<br>
	 * 
	 * @param String agentCd
	 * @return List<SearchAgentVO>
	 * @exception EventException
	 */
	public List<SearchAgentVO> searchAgent(String agentCd ) throws EventException ;

	/**
	 * 선박명을 조회한다.<br>
	 * 
	 * @param String vslCd
	 * @return String
	 * @exception EventException
	 */
	public String searchVesselName(String vslCd) throws EventException ;

	/**
	 * 선박 항차 정보를 조회한다.<br>
	 * 
	 * @param String vvdCd
	 * @param String vslEngNm
	 * @return List<SearchVesselVvdListVO>
	 * @exception EventException
	 */
	public List<SearchVesselVvdListVO> searchVesselVvdList(String vvdCd, String vslEngNm) throws EventException ;
	
	/**
	 * 경리환율 정보를 조회한다.<br>
	 * 
	 * @param String fmDt
	 * @param String toDt
	 * @param String currCd
	 * @return List<SearchRoeListVO>
	 * @exception EventException
	 */
	public List<SearchRoeListVO> searchRoeList(String fmDt, String toDt, String currCd) throws EventException ;
	
	/**
	 * 선박 정보를 조회한다.<br>
	 * 
	 * @param String vslCd
	 * @param String vslNm
	 * @return List<SearchVesselListVO>
	 * @exception EventException
	 */
	public List<SearchVesselListVO> searchVesselList(String vslCd, String vslNm) throws EventException ;
	
	/**
	 * MISCELLANEOUS  코드를 조회한다.<br>
	 * 
	 * @param String typeCd
	 * @return List<SearchClaimCodeListVO>
	 * @exception EventException
	 */
	public List<SearchClaimCodeListVO> searchClaimCodeList(String typeCd) throws EventException ;
	
}