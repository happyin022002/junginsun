/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFATransportationAdditionalChargeProposalBC.java
*@FileTitle : RFA Proposal Origin/Destination Arbitrary Charge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.05.18 김재연
* 1.0 Creation
 =========================================================
 * History
 * 2015.10.28 SELCMU/김현경 [CHM-201538236] RFA module 승인 절차 간소화 및 기능 개선
 * 2015.12.16 SELCMU/김현경 [CHM-201539304] Arbitrary GL Amt backendjob 으로 전환요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.PriRpComVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.ChkFontStyleVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.CstPriRpScpTrspAddChgVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.FicRouteGLineVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.GLineInfoByFICRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.RsltArbChgListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.RsltPriRpScpTrspAddChgVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.SearchGuidelineRouteInquiryVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.SearchGuidelineRoutePopupListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRpScpTrspAddChgVO;

/**
 * NIS2010-RFAproposal Business Logic Command Interface<br>
 * - NIS2010-RFAproposal에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author JaeYeon Kim
 * @see Esm_pri_2003_04EventResponse 참조
 * @since J2EE 1.4
 */

public interface RFATransportationAdditionalChargeProposalBC {
	
	/**
	 * Arbitrary List를 조회합니다. <br>
	 * 
	 * @param PriRpScpTrspAddChgVO priRpScpTrspAddChgVO
	 * @param boolean addOnFlag
	 * @return List<RsltArbChgListVO>
	 * @exception EventException
	 */
	public List<RsltArbChgListVO> searchArbitraryChargeList(PriRpScpTrspAddChgVO priRpScpTrspAddChgVO, boolean addOnFlag) throws EventException;
	
	/**
	 * Arbitrary를 수정합니다. <br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageArbitraryCharge(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Arbitrary accept를 실행한다. <br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptArbitraryCharge(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Arbitrary Accept Cancel 실행한다. <br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelArbitraryCharge(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Arbitrary Accept all을 실행한다. <br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllArbitraryCharge(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Arbitrary Accept Cancel을 실행한다. <br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void cancelAllArbitraryCharge(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Arbitrary의 Guideline을 Copy 한다. <br>
	 * 
	 * @param CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineArbitraryCharge(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Amend Data를 생성한다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException;			

    /**
     * RFA Proposal Scope Transportation Additional Charge 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeTransport(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException;

    /**
     * Guideline Origin/Destination Arbitrary 를 Proposal 로 Copy 합니다.<br>
     * 
     * @param RpScpGlineCopyVO rpScpGlineCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineArbitrary(RpScpGlineCopyVO rpScpGlineCopyVO, SignOnUserAccount account) throws EventException;

	/**
     * Guideline Copy 할 대상이 존재하는지 조회를 합니다. <br>
     * 
     * @param CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
     * @return boolean
     * @exception EventException
     */
	public boolean checkGuidelineArbitraryChargeExist(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws EventException;
	
	/**
     * Guideline Copy할 데이터의 GROUP LOCATION이 등록되어 있는지 확인한다.<br>
     * 
     * @param CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
     * @return boolean
     * @exception EventException
     */
	public boolean checkGuidelineArbitraryChargeGroupLocationExist(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws EventException;
	
	/**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpScpMnVO[] priRpScpMnVOs,SignOnUserAccount account) throws EventException;	
	
	/**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * 엑셀파일을 업로드합니다.<br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadArbitraryChargeProposal(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * 엑셀파일을 체크합니다.
	 * 
	 * @param RsltPriRpScpTrspAddChgVO[] rsltPriRpScpTrspAddChgVOs
	 * @return List<RsltPriRpScpTrspAddChgVO>
	 * @exception EventException
	 */
	public List<RsltPriRpScpTrspAddChgVO> searchCodeCheckResult(RsltPriRpScpTrspAddChgVO[] rsltPriRpScpTrspAddChgVOs) throws EventException;
	
	/**
	 * Arbitrary의 ORIGIN과 DESTINATION의 FONT STYLE를 조회합니다. <br>
	 * 
	 * @param CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
	 * @return List<ChkFontStyleVO>
	 * @exception EventException
	 */
	public List<ChkFontStyleVO> checkFontStyle(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws EventException;
	
	/**
	 * Arbitrary Amend History 리스트를 조회합니다. <br>
	 * 
	 * @param PriRpScpTrspAddChgVO priRpScpTrspAddChgVO
	 * @return List<RsltArbChgListVO>
	 * @exception EventException
	 */
	public List<RsltArbChgListVO> searchArbitraryChargeHistoryList(PriRpScpTrspAddChgVO priRpScpTrspAddChgVO) throws EventException;
	
	/**
	 * Arbitrary의 ORIGIN과 DESTINATION의 FONT STYLE를 조회합니다. <br>
	 * 
	 * @param CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO
	 * @return List<ChkFontStyleVO>
	 * @exception EventException
	 */
	public List<ChkFontStyleVO> checkHistoryFontStyle(CstPriRpScpTrspAddChgVO cstPriRpScpTrspAddChgVO) throws EventException;
	
	/**
	 * Arbitrary Inquiry List를 조회합니다. <br>
	 * 
	 * @param PriRpScpTrspAddChgVO priRpScpTrspAddChgVO
	 * @return List<RsltArbChgListVO>
	 * @exception EventException
	 */
	public List<RsltArbChgListVO> searchArbitraryChargeInquiryList(PriRpScpTrspAddChgVO priRpScpTrspAddChgVO) throws EventException;
	
	/**
	 * Guide Line을 이용하여 FIC Base Port List를 조회한다. <br>
	 * 
	 * @param FicRouteGLineVO ficRouteGLineVO
	 * @param boolean addOnFlag
	 * @return List<FicRouteGLineVO>
	 * @exception EventException
	 */
	public List<FicRouteGLineVO> searchFICBasePortListByGLine(FicRouteGLineVO ficRouteGLineVO, boolean addOnFlag) throws EventException;
	
	/**
	 * Guile Line에 의한 Route를 조회합니다.<br>
	 * 
	 * @param FicRouteGLineVO ficRouteGLineVO
	 * @param boolean addOnFlag
	 * @return List<FicRouteGLineVO>
	 * @exception EventException
	 */
	public List<FicRouteGLineVO> searchFICRouteByGLine(FicRouteGLineVO ficRouteGLineVO, boolean addOnFlag) throws EventException;
	
	/**
	 * Route 정보를 이용하여 Guide Line 정보를 조회한다.<br>
	 * 
	 * @param GLineInfoByFICRouteVO gLineInfoByFICRouteVO
	 * @param boolean addOnFlag
	 * @return List<GLineInfoByFICRouteVO>
	 * @exception EventException
	 */
	public List<GLineInfoByFICRouteVO> searchGLineInfoByFICRoute(GLineInfoByFICRouteVO gLineInfoByFICRouteVO, boolean addOnFlag) throws EventException;
	
	/**
	 *  ESM_PRI_2029 : Guideline Route Search Pop-Up
	 * @param searchGuidelineRouteInquiryVO
	 * @return List<SearchGuidelineRoutePopupListVO>
	 * @throws EventException
	 */
	public List<SearchGuidelineRoutePopupListVO> searchGuidelineRoutePopupList(SearchGuidelineRouteInquiryVO searchGuidelineRouteInquiryVO) throws EventException;	
	
	/**
	 * 엑셀파일을 업로드합니다.<br>
	 * 
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadArbitraryChargeProposalForIHC(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOs,SignOnUserAccount account) throws EventException;

	
	/**
	 * 엑셀파일을 체크합니다.
	 * 
	 * @param RsltPriRpScpTrspAddChgVO[] rsltPriRpScpTrspAddChgVOs
	 * @return List<RsltPriRpScpTrspAddChgVO>
	 * @exception EventException
	 */
	public List<RsltPriRpScpTrspAddChgVO> searchCodeCheckResultForIHC(RsltPriRpScpTrspAddChgVO[] rsltPriRpScpTrspAddChgVOs) throws EventException;	
	
	/**
	 * RFA Arbitrary 의 Guide 값을 업데이트 시켜줌.
	 * @param PriRpComVO priRpComVO
	 * @param SignOnUserAccount account 
	 * @return String
	 * @throws EventException
	 */
	public String managePriRpScpTrspAddChgCopy(PriRpComVO priRpComVO, SignOnUserAccount account) throws EventException;	

	/**
	 * Summary 팝업에서 승인 대상인 모든 Service Scope Arbitrary 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltArbChgListVO>
	 * @exception EventException
	 */
	public List<RsltArbChgListVO> searchAllArbitraryList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;
}