/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UnmatchBLBC.java
*@FileTitle : Unmatch B/L Inquiry by Regional Group
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRfaOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTaaOftAutoratingListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.AutoRdnInfoVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByCNTRQtyDiscrepancyListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByCommodityAndRouteListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByHangerInstallationListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchChargeFilteringListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchUnmatchItemListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchUnmatchTypeListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchBLListbyAuditorVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchDiffAmountVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchStatusReportVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.UnmatchBLVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.RlstSearchSelfAuditListVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo.ScNoteConversionVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgRevUmchBkgVO;

/**
 * OPUS-RevenueAudit Business Logic Basic Command interface<br>
 * - OPUS-RevenueAudit handling business transaction.<br>
 * 
 * @author 
 * @see 
 * @since J2EE 1.6
 */

public interface UnmatchBLBC {
	
	/**
	 *  Handling retrieving event of Wharfage 
	 * 
	 * @param SignOnUserAccount account 
	 * @param RsltUnmatchBLListbyAuditorVO rsltUnmatchBLListbyAuditorVO 
	 * @return String
	 * @throws EventException
	 */
	public String searchFilterdBkgCount(SignOnUserAccount account, RsltUnmatchBLListbyAuditorVO rsltUnmatchBLListbyAuditorVO) 
	throws EventException;
	
	/**
	 *  unmatch bl list by auditor.<br>
	 * 
	 * @param RsltUnmatchBLListbyAuditorVO rsltUnmatchBLListbyAuditorVO
	 * @return List<RsltUnmatchBLListbyAuditorVO>
	 * @exception EventException
	 */
	public List<RsltUnmatchBLListbyAuditorVO> searchUnmatchBLListbyAuditor(RsltUnmatchBLListbyAuditorVO rsltUnmatchBLListbyAuditorVO) 
	throws EventException;
	
	
	/**
	 *  unmatch bl list by auditor.<br>
	 * 
	 * @param RsltUnmatchBLListbyAuditorVO rsltUnmatchBLListbyAuditorVO
	 * @return List<RsltUnmatchBLListbyAuditorVO>
	 * @exception EventException
	 */
	public List<RsltUnmatchBLListbyAuditorVO> searchUnmatchBLListbyRegionalOffice(RsltUnmatchBLListbyAuditorVO rsltUnmatchBLListbyAuditorVO) 
	throws EventException;
	
	
	/**
	 *  retrieving event of unmatched result<br>
	 * 
	 * @param RsltUnmatchDiffAmountVO rsltUnmatchDiffAmountVO
	 * @return List<RsltUnmatchDiffAmountVO>
	 * @exception EventException
	 */
	public List<RsltUnmatchDiffAmountVO> searchUnmatchItemDetailList(RsltUnmatchDiffAmountVO rsltUnmatchDiffAmountVO) 
	throws EventException;
	
	
	/**
	 *  unmatch status report list search.<br>
	 * 
	 * @param RsltUnmatchStatusReportVO resltUnmatchStatusReportVO
	 * @return List<RsltUnmatchStatusReportVO>
	 * @exception EventException
	 */
	public List<RsltUnmatchStatusReportVO> searchUnmatchBLStatusList(RsltUnmatchStatusReportVO resltUnmatchStatusReportVO) 
	throws EventException;
	
	
	/**
	 * UNMACH LIST SETTLE <br>
	 * 
	 * @param BkgRevUmchBkgVO[] bkgRevUmchBkgVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void settleUnmatchBL(BkgRevUmchBkgVO[] bkgRevUmchBkgVO, SignOnUserAccount account) throws EventException;
	/**
	 * UNMACH LIST SETTLE <br>
	 * 
	 * @param BkgRevUmchBkgVO[] bkgRevUmchBkgVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void settleOfficeUnmatchBL(BkgRevUmchBkgVO[] bkgRevUmchBkgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * MODIFY of UNMACH LIST RMK <br>
	 * 
	 * @param BkgRevUmchBkgVO[] bkgRevUmchBkgVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyUnmatchBL(BkgRevUmchBkgVO[] bkgRevUmchBkgVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * MODIFY of Unmatch B/L Inquiry by Office<br>
	 * 
	 * @param BkgRevUmchBkgVO[] bkgRevUmchBkgVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyUnmatchBLRegionalOffice(BkgRevUmchBkgVO[] bkgRevUmchBkgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * retrieving Unmatch Details List<br>
	 * 
	 * @param RsltSearchUnmatchItemListVO rsltSearchUnmatchItemListVO
	 * @return List<RsltSearchUnmatchItemListVO>
	 * @exception EventException
	 */
	public List<RsltSearchUnmatchItemListVO> searchUnmatchItemList(RsltSearchUnmatchItemListVO rsltSearchUnmatchItemListVO) throws EventException;
	
	/**
	 * retrieving Unmatch Description <br>
	 * 
	 * @param RsltSearchUnmatchTypeListVO rsltSearchUnmatchTypeListVO
	 * @return List<RsltSearchUnmatchTypeListVO>
	 * @exception EventException
	 */
	public List<RsltSearchUnmatchTypeListVO> searchUnmatchTypeList(RsltSearchUnmatchTypeListVO rsltSearchUnmatchTypeListVO) throws EventException;	

	/**
	 * for Charge Filtering handling requested job by BackEndJob<br>
	 * 
	 * @param SignOnUserAccount account
	 * @param RsltSearchChargeFilteringListVO rsltSearchChargeFilteringListVO
	 * @return String
	 * @exception EventException
	 */	
	public String searchChargeFilteringList(SignOnUserAccount account, RsltSearchChargeFilteringListVO rsltSearchChargeFilteringListVO) 
	throws EventException;

	/**
	 * for Audit by Commodity And Route handling requested job by BackEndJob<br>
	 * 
	 * @param SignOnUserAccount account
	 * @param RsltSearchAuditByCommodityAndRouteListVO rsltSearchAuditByCommodityAndRouteListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchAuditByCommodityAndRouteList(SignOnUserAccount account, RsltSearchAuditByCommodityAndRouteListVO rsltSearchAuditByCommodityAndRouteListVO) 
	throws EventException;

	/**
	 * Retrieving event of Audit by CNTR Qty Discrepancy List<br>
	 * 
	 * @param RsltSearchAuditByCNTRQtyDiscrepancyListVO rsltSearchAuditByCNTRQtyDiscrepancyListVO
	 * @return List<RsltSearchAuditByCNTRQtyDiscrepancyListVO>
	 * @exception EventException
	 */	
	public List<RsltSearchAuditByCNTRQtyDiscrepancyListVO> searchAuditByCNTRQtyDiscrepancyList(RsltSearchAuditByCNTRQtyDiscrepancyListVO rsltSearchAuditByCNTRQtyDiscrepancyListVO) throws EventException;
	
	/**
	 *  Handling manage event of Audit by CNTR Qty Discrepancy List<br>
	 * 
	 * @param RsltSearchAuditByCNTRQtyDiscrepancyListVO[] rsltSearchAuditByCNTRQtyDiscrepancyListVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */	
	public  void  manageAuditByCNTRQtyDiscrepancyList(RsltSearchAuditByCNTRQtyDiscrepancyListVO[] rsltSearchAuditByCNTRQtyDiscrepancyListVOs, SignOnUserAccount account) throws EventException;
	/**
	 *  Handling retrieving event of Audit by Hanger Installation List<br>
	 * 
	 * @param RsltSearchAuditByHangerInstallationListVO pVO
	 * @return List<RsltSearchAuditByHangerInstallationListVO>
	 * @exception EventException
	 */	
	public List<RsltSearchAuditByHangerInstallationListVO> searchAuditByHangerInstallationList(RsltSearchAuditByHangerInstallationListVO pVO) throws EventException;

	/**
	 * Handling Audit by Hanger Installation RMK <br>
	 * @param RsltSearchAuditByHangerInstallationListVO[] rsltSearchAuditByHangerInstallationListVOs
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */	
	public  void  manageAuditByHangerInstallationList(RsltSearchAuditByHangerInstallationListVO[] rsltSearchAuditByHangerInstallationListVOs, SignOnUserAccount account) throws EventException;
	/**
	 * retrieving event of BackEndJob state.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comBakEndJbVO(String key) throws EventException;
	
	/**
	 *  Handling retrieving event of B/L No to BkgNo and caFlg, ctrtTpCD<br>
	 * 
	 * @param String blNo
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> searchBkgCaFlg(String blNo) throws EventException;
	
	/**
	 *  Handling retrieving event of Booking No to aFlg, ctrtTpCD<br>
	 * 
	 * @param String bkgNo
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> searchBkgStatus(String bkgNo) throws EventException;

	/**
	 * retrieving of Self Audit - RFA A ~ F <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaUnmatchBLbyBooking(String bkgNo, String caFlg, String mod) throws EventException;
	
	/**
	 * retrieving of Self Audit - RFA A ~ F <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaUnmatchSCRA(String bkgNo, String caFlg, String mod) throws EventException;
	
	/**
	 * retrieving Self Audit - SC A ~ D<br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkScUnmatchBLbyBooking(String bkgNo, String caFlg, String mod) throws EventException;

	/**
	 * Audit TAA A ~ F <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @return List<unmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkTaaUnmatchBLbyBooking(String bkgNo, String caFlg, String mod) throws EventException;
	
	/**
	 * Self Audit TAA A ~ F <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @return List<unmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkTaaSelfBLbyBooking(String bkgNo, String caFlg, String mod) throws EventException;
	
	/**
	 * Self Audit TAA A ~ F <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @return List<unmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkTaaUnmatchSCRA(String bkgNo, String caFlg, String mod) throws EventException;

	/**
	 * update state.<br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyReauditUnmatchBLStatus(UnmatchBLVO pVo, SignOnUserAccount account) throws EventException;
		
	/**
	 * manage event of BKG_REV_UMCH_BKG Table.<br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @exception EventException
	*/
	public void modifyCompareBkgRevUmchBkg(UnmatchBLVO pVo) throws EventException;

	/**
	 * Create RFA Surcharge<br>
	 * 
	 * @param String bkgNo
	 * @param List<SearchRfaOftAutoratingListVO> oftList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createRfaSurchargeInput(String bkgNo, List<SearchRfaOftAutoratingListVO> oftList, SignOnUserAccount account) throws EventException;
	
	/**
	 * Create TAA Surcharge<br>
	 * 
	 * @param String bkgNo
	 * @param List<SearchTaaOftAutoratingListVO> oftList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createTaaSurchargeInput(String bkgNo, List<SearchTaaOftAutoratingListVO> oftList, SignOnUserAccount account) throws EventException;

	/**
	 * get RFA Surcharge<br>
	 * 
	 * @param String[][] caseList
	 * @return ArrayList<String[]>
	 * @exception EventException
	 */
	public ArrayList<String[]> makeOccurenceCase(String[][] caseList) throws EventException;
	
	/**
	 * find RFA Surcharge<br>
	 * 
	 * @param ArrayList<String[]> occurList
	 * @param String[][] caseList
	 * @param String[] route
	 * @param int idx
	 * @exception EventException
	 */
	public void findCase(ArrayList<String[]> occurList, String[][] caseList, String[] route, int idx) throws EventException;

	/**
	 * Create RFA, TAA RevenueAuditOft<br>
	 *  
	 * @exception EventException
	 */
	public void createRevenueAuditOft() throws EventException;

	/**
	 * Create RFA, TAA RevenueAudit Surcharge<br>
	 * 
	 * @param List<SearchScOftAutoratingListVO> surList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createRevenueAuditSurcharge(List<SearchScOftAutoratingListVO> surList, SignOnUserAccount account) throws EventException;
	
	/**
	 * retrieving maxseq <br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchMaxUmchBkgSeq(UnmatchBLVO pVo, SignOnUserAccount account) throws EventException;
	
	/**
	 * Crate Unmatch data<br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @param List<UnmatchBLVO> unmatchList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addCompareBkgRevUmchAll(UnmatchBLVO pVo, List<UnmatchBLVO> unmatchList, SignOnUserAccount account) throws EventException;
	
	/**
	 * retrieving of BKG_REV_UMCH_BKG state<br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @return String
	 * @exception EventException
	 */
	public String selectCompareBkgRevUmchBkg(UnmatchBLVO pVo) throws EventException;
	
	/**
	 * retrieving of BKG_REV_UMCH_ITM <br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @return String
	 * @exception EventException
	 */
	public String selectCompareBkgRevUmchItm(UnmatchBLVO pVo) throws EventException;
	
	/**
	 * retrieving of BKG_REV_UMCH_ITM_DTL  <br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @return String
	 * @exception EventException
	 */
	public String selectCompareBkgRevUmchItmDtl(UnmatchBLVO pVo) throws EventException;
	
	
	/**
	 * delete Unmatch data<br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @exception EventException
	 */
	public void removeCompareBkgRevUmchAll(UnmatchBLVO pVo) throws EventException;

	/**
	 * Modify BKG_REV_UMCH_BKG TABLE LST_UMCH_FND_DT<br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCompareBkgRevUmchBkgFndDt(UnmatchBLVO pVo, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving of RFA, TAA
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return String
	 * @exception EventException
	 */
	public String searchAuditRtAplyDt(String bkgNo, String caFlg) throws EventException;	

	/**
	 * Retrieving RDN
	 * @param unmatchBLVO
	 * @return AutoRdnInfoVO
	 * @throws EventException
	 */
	public AutoRdnInfoVO searchAutoRdnInfo(UnmatchBLVO unmatchBLVO) throws EventException;
	
	/**
	 * Self Audit 
	 * @param String blNo
	 * @param String caFlg
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String searchSelfAuditListBackEndJob(String blNo, String caFlg, SignOnUserAccount account) throws EventException;
	
	/**
	 * ctrtTpCD  <br>
	 * 
	 * @param String blNo
	 * @param String caFlg
	 * @return UnmatchBLVO
	 * @exception EventException
	 */
	public UnmatchBLVO searchBkgCaFlg(String blNo, String caFlg) throws EventException;
	
	/**
	 * Self Audit - RFA A1을 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaEffectiveDateDiscrepancy(String bkgNo, String caFlg) throws EventException;

	/**
	 * Self Audit - RFA A2을 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkApplicationDateDiscrepancy(String bkgNo, String caFlg) throws EventException;

	/**
	 * Self Audit - RFA B을 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaCustomerDiscrepancy(String bkgNo, String caFlg) throws EventException;

	/**
	 * Self Audit - RFA C을 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaCommodityDiscrepancy(String bkgNo, String caFlg) throws EventException;

	/**
	 * Self Audit - RFA D을 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaNonchargedBl(String bkgNo, String caFlg) throws EventException;

	/**
	 * Audit - RFA E을 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaOftDiscrepancy(String bkgNo, String caFlg) throws EventException;
	
	/**
	 * Self Audit - RFA E을 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaSelfOftDiscrepancy(String bkgNo, String caFlg) throws EventException;

	/**
	 * Audit - RFA F을 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaSurchargeDiscrepancy(String bkgNo, String caFlg) throws EventException;
	
	/**
	 * Self Audit - RFA F을 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaSelfSurchargeDiscrepancy(String bkgNo, String caFlg) throws EventException;

	/**
	 * Self Audit - checkRfaOftDiscrepancyDetail <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaOftDiscrepancyDetail(String bkgNo, String caFlg) throws EventException;

	/**
	 * Self Audit - checkRfaSurchargeDiscrepancyDetail <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaSurchargeDiscrepancyDetail(String bkgNo, String caFlg) throws EventException;


	/**
	 * SC Surcharge를 생성한다.<br>
	 * 
	 * @param String bkgNo
	 * @param List<SearchScOftAutoratingListVO> oftList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createScSurchargeInput(String bkgNo, List<SearchScOftAutoratingListVO> oftList, SignOnUserAccount account) throws EventException;
	
	/**
	 * Audit - SC A ~ E 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkScUnmatchBLIncludeOFTbyBooking(String bkgNo, String caFlg, String mod) throws EventException;
	
	/**
	 * Self Audit - SC A ~ E 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkScUnmatchBLIncludeSelfOFTbyBooking(String bkgNo, String caFlg, String mod) throws EventException;
	
	/**
	 * Self Audit - SC A ~ E 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkScUnmatchSCRA(String bkgNo, String caFlg, String mod) throws EventException;
	
	
	/**
	 * Self Audit 리스트 조회
	 * @param String key
	 * @return RlstSearchSelfAuditListVO
	 * @throws EventException
	 */
	public RlstSearchSelfAuditListVO searchSelfAuditList(String key) throws EventException;

	/**
	 * 심사를 위해 특정 Rule Type (Conversion Table상 Code)을 포함하는 SC Note를 조회 <br>
	 * 
	 * @param ScNoteConversionVO vo
	 * @return List<ScNoteConversionVO>
	 * @exception EventException
	 */	
	public List<ScNoteConversionVO> searchScNoteConversionListByRule(ScNoteConversionVO vo) throws EventException;
	
	/**
	 * Customer EDI로 전송 BackEndJob 결과확인<br>
	 * 
	 * @param String key
	 * @return String
	 * @throws EventException
	 */
	public String searchReauditBackEndJobResult(String key) throws EventException;
	
	/**
	 * ESM_BKG_0256 : reaudit click <br>
	 * ESM_BKG_0701 : reaudit click <br>
	 * 선택한 BL들에 대한 re-audit을 수행한다.<br>
	 * 
	 * @param String[] bkgNoArr
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String reauditUnmatchBL(String[] bkgNoArr, SignOnUserAccount account) throws EventException;


}