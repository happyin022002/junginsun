/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UnmatchBLBC.java
*@FileTitle : Unmatch B/L Inquiry by Regional Group
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.06.22 이승준
* 1.0 Creation
* --------------------------------------------------------------------------------------
* History
* 2011.05.12 이일민 [CHM-201109862-01] [BKG/DOC] BKG Creation Charge화면의 Self Audit기능 Transaction Time 변경 요청
* 2012.04.02 김진주 [CHM-201216859] [BKG/DOC - Revenue Audit System] 미주발 S/C B/L OFT 자동심사기능 개발
* 2012.10.05 조정민 [CHM-201219854] [BKG] BKG 생성시 S/C 에 운임 조회 후 부재시 G/W 메일 SALES REP/PRICING STAFF 전송 기능 추가 
* 2012.11.02 김진주 [CHM-201220005] [BKG/DOC - Revenue Audit System] S/C B/L Surcharge 자동심사 시스템 보완 요청
* 2013.02.04 김진주 [CHM-201322626] [BKG/DOC - Revenue Audit System] SZPBB, HKGBB의 DHF 심사로직 추가
* 2013.07.30 김진주 [CHM-201325469] [BKG/DOC - Revenue Audit System] COD BKG Inquiry 기능 개발 요청
* 2013.10.01 김진주 [CHM-201326784] [BKG/DOC - Revenue Audit Syste] Error B/L Inquiry 기능의 Manual Settle(OFC) 기능 로직 추가
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRfaOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTaaOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.AutoRdnInfoVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.AwkwardBKGListForAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.BayPlanVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.BKGvsBayPlanVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.CODBookingListInVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.CODBookingListOutVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.DiversionCAVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.EqSubErrSchVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.IhcBKGListForAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.IndiaDthBKGListForAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.IranDthBKGListForAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.MultiRateBkgList1VO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.MultiRateBkgListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.OblSurrenderForAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.NonAutoratedChargeVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RetroActFilterSchVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RetroactiveBLStatusListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RlstSearchSelfAuditListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByCNTRQtyDiscrepancyListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByCommodityAndRouteListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchAuditByHangerInstallationListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchChargeFilteringListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchRetroActFilterVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchUnmatchItemListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltSearchUnmatchTypeListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchBLListbyAuditorVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchDiffAmountVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.RsltUnmatchStatusReportVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.ScNoteConversionVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.SearchStopOffBkgListforAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.TxsBkgListForAuditSchVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.TxsBkgListForAuditVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.UmchErrBlReportVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.UnmatchBLVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.UnmatchSettlementListVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.WscBkgListForAuditSchVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgRevUmchBkgVO;

/**
 * NIS2010-Revenueaudit Business Logic Command Interface<br>
 * - NIS2010-Revenueaudit에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Seung Jun Lee
 * @see Esm_bkg_0256EventResponse 참조
 * @since J2EE 1.6
 */

public interface UnmatchBLBC {
	
	/**
	 * UNMATCH BL INQUERY 시 조건에 해당되는 BKG COUNT SEARCH<br>
	 * 
	 * @param SignOnUserAccount account
	 * @param RsltUnmatchBLListbyAuditorVO rsltUnmatchBLListbyAuditorVO
	 * @return String
	 * @exception DAOException
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
	 *  차이금액 상세내역을 조회한다.<br>
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
	 *  unmatch settlement status report list search.<br>
	 * 
	 * @param UnmatchSettlementListVO unmatchSettlementListVO
	 * @return List<UnmatchSettlementListVO>
	 * @exception EventException
	 */
	public List<UnmatchSettlementListVO> searchUnmatchBLSettlementList(UnmatchSettlementListVO unmatchSettlementListVO) 
	throws EventException;

	/**
	 *  Retroactive B/L status report list search.<br>
	 * 
	 * @param RetroactiveBLStatusListVO retroactiveBLStatusListVO
	 * @return List<RetroactiveBLStatusListVO>
	 * @exception EventException
	 */
	public List<RetroactiveBLStatusListVO> searchRetroactiveBlStatusList(RetroactiveBLStatusListVO retroactiveBLStatusListVO)  throws EventException;
	
	/**
	 * UNMACH LIST를 SETTLE 시킴<br>
	 * 
	 * @param BkgRevUmchBkgVO[] bkgRevUmchBkgVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void settleUnmatchBL(BkgRevUmchBkgVO[] bkgRevUmchBkgVO, SignOnUserAccount account) throws EventException;
	/**
	 * UNMACH LIST를 SETTLE 시킴<br>
	 * 
	 * @param BkgRevUmchBkgVO bkgRevUmchBkgVO
	 * @exception EventException
	 */
	public void settleUnmatchBL(BkgRevUmchBkgVO bkgRevUmchBkgVO) throws EventException;
	/**
	 * UNMACH LIST를 SETTLE 시킴<br>
	 * 
	 * @param BkgRevUmchBkgVO[] bkgRevUmchBkgVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void settleOfficeUnmatchBL(BkgRevUmchBkgVO[] bkgRevUmchBkgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * UNMACH LIST를 RMK 수정<br>
	 * 
	 * @param BkgRevUmchBkgVO[] bkgRevUmchBkgVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyUnmatchBL(BkgRevUmchBkgVO[] bkgRevUmchBkgVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * Unmatch B/L Inquiry by Office 를 RMK 수정<br>
	 * 
	 * @param BkgRevUmchBkgVO[] bkgRevUmchBkgVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyUnmatchBLRegionalOffice(BkgRevUmchBkgVO[] bkgRevUmchBkgVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Unmatch Details 리스트를 조회한다. <br>
	 * 
	 * @param RsltSearchUnmatchItemListVO rsltSearchUnmatchItemListVO
	 * @return List<RsltSearchUnmatchItemListVO>
	 * @exception EventException
	 */
	public List<RsltSearchUnmatchItemListVO> searchUnmatchItemList(RsltSearchUnmatchItemListVO rsltSearchUnmatchItemListVO) throws EventException;
	
	/**
	 * Unmatch Description 리스트를 조회한다. <br>
	 * 
	 * @param RsltSearchUnmatchTypeListVO rsltSearchUnmatchTypeListVO
	 * @return List<RsltSearchUnmatchTypeListVO>
	 * @exception EventException
	 */
	public List<RsltSearchUnmatchTypeListVO> searchUnmatchTypeList(RsltSearchUnmatchTypeListVO rsltSearchUnmatchTypeListVO) throws EventException;	

	/**
	 * Charge Filtering 리스트 조회를 위해 BackEndJob을 실행한다. <br>
	 * 
	 * @param SignOnUserAccount account
	 * @param RsltSearchChargeFilteringListVO rsltSearchChargeFilteringListVO
	 * @return String
	 * @exception EventException
	 */	
	public String searchChargeFilteringList(SignOnUserAccount account, RsltSearchChargeFilteringListVO rsltSearchChargeFilteringListVO) 
	throws EventException;

	/**
	 * Audit by Commodity And Route 리스트 조회를 위해 BackEndJob을 실행한다. <br>
	 * 
	 * @param SignOnUserAccount account
	 * @param RsltSearchAuditByCommodityAndRouteListVO rsltSearchAuditByCommodityAndRouteListVO
	 * @return String
	 * @exception EventException
	 */	
	public String searchAuditByCommodityAndRouteList(SignOnUserAccount account, RsltSearchAuditByCommodityAndRouteListVO rsltSearchAuditByCommodityAndRouteListVO) 
	throws EventException;

	/**
	 * Audit by CNTR Qty Discrepancy 리스트를 조회한다. <br>
     *
	 * @param RsltSearchAuditByCNTRQtyDiscrepancyListVO rsltSearchAuditByCNTRQtyDiscrepancyListVO
	 * @return List<RsltSearchAuditByCNTRQtyDiscrepancyListVO>
	 * @exception EventException
	 */
	public List<RsltSearchAuditByCNTRQtyDiscrepancyListVO> searchAuditByCNTRQtyDiscrepancyList(RsltSearchAuditByCNTRQtyDiscrepancyListVO rsltSearchAuditByCNTRQtyDiscrepancyListVO) throws EventException;
	
	/**
	 * remark 업데이트 한다. <br>
	 * @param RsltSearchAuditByCNTRQtyDiscrepancyListVO[] rsltSearchAuditByCNTRQtyDiscrepancyListVOs
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public  void  manageAuditByCNTRQtyDiscrepancyList(RsltSearchAuditByCNTRQtyDiscrepancyListVO[] rsltSearchAuditByCNTRQtyDiscrepancyListVOs, SignOnUserAccount account) throws EventException;
	/**
	 * Audit by Hanger Installation 리스트를 조회한다. <br>
     *
	 * @param RsltSearchAuditByHangerInstallationListVO pVO
	 * @return List<RsltSearchAuditByHangerInstallationListVO>
	 * @exception EventException
	 */
	public List<RsltSearchAuditByHangerInstallationListVO> searchAuditByHangerInstallationList(RsltSearchAuditByHangerInstallationListVO pVO) throws EventException;

	/**
	 * remark 업데이트 한다. <br> 
	 * @param RsltSearchAuditByHangerInstallationListVO[] rsltSearchAuditByHangerInstallationListVOs
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public  void  manageAuditByHangerInstallationList(RsltSearchAuditByHangerInstallationListVO[] rsltSearchAuditByHangerInstallationListVOs, SignOnUserAccount account) throws EventException;
	/**
	 * BackEndJob의 상태값을 조회한다.<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comBakEndJbVO(String key) throws EventException;
	
	/**
	 * B/L No 로 BkgNo, ctrtTpCD 를 조회한다. <br>
	 * 
	 * @param String blNo
	 * @param String caFlg
	 * @return UnmatchBLVO
	 * @exception EventException
	 */
	public UnmatchBLVO searchBkgCaFlg(String blNo, String caFlg) throws EventException;
	
	/**
	 * Booking No 로 caFlg, ctrtTpCD 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @return List<unmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> searchBkgStatus(String bkgNo) throws EventException;

	/**
	 * Self Audit RFA A ~ F 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @return List<unmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaUnmatchBLbyBooking(String bkgNo, String caFlg, String mod) throws EventException;
	
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
	 * Self Audit - RFA E을 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaOftDiscrepancy(String bkgNo, String caFlg) throws EventException;

	/**
	 * Self Audit - RFA F을 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String selfFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkRfaSurchargeDiscrepancy(String bkgNo, String caFlg, String selfFlg) throws EventException;

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
	 * Self Audit - G 을 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkAwkwardVoidSlotDiscrepancy(String bkgNo, String caFlg) throws EventException;

	/**
	 * Self Audit SC A ~ D 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @return List<unmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkScUnmatchBLbyBooking(String bkgNo, String caFlg, String mod) throws EventException;

	/**
	 * Self Audit - SC A ~ E 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @param String batFlg
	 * @return List<UnmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkScUnmatchBLIncludeOFTbyBooking(String bkgNo, String caFlg, String mod, String batFlg) throws EventException;

	/**
	 * Self Audit TAA A ~ F 를 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String mod
	 * @return List<unmatchBLVO>
	 * @exception EventException
	 */
	public List<UnmatchBLVO> checkTaaUnmatchBLbyBooking(String bkgNo, String caFlg, String mod) throws EventException;

	/**
	 * booking status 가 X 일때 Re Audit 상태를 업데이트 한다.<br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyReauditUnmatchBLStatus(UnmatchBLVO pVo, SignOnUserAccount account) throws EventException;
		
	/**
	 * 신규생성된 BKG_REV_UMCH_BKG 테이블을 새로이 갱신한다.<br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @exception EventException
	 */
	public void modifyCompareBkgRevUmchBkg(UnmatchBLVO pVo) throws EventException;

	/**
	 * RFA Surcharge를 생성한다.<br>
	 * 
	 * @param String bkgNo
	 * @param List<SearchRfaOftAutoratingListVO> oftList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createRfaSurchargeInput(String bkgNo, List<SearchRfaOftAutoratingListVO> oftList, SignOnUserAccount account) throws EventException;
	
	/**
	 * TAA Surcharge를 생성한다.<br>
	 * 
	 * @param String bkgNo
	 * @param List<SearchTaaOftAutoratingListVO> oftList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createTaaSurchargeInput(String bkgNo, List<SearchTaaOftAutoratingListVO> oftList, SignOnUserAccount account) throws EventException;

	/**
	 * SC Surcharge를 생성한다.<br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @param List<SearchScOftAutoratingListVO> oftList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createScSurchargeInput(String bkgNo, String caFlg, List<SearchScOftAutoratingListVO> oftList, SignOnUserAccount account) throws EventException;


	/**
	 * RFA Surcharge 경우의 수 만큼 가져온다.<br>
	 * 
	 * @param String[][] caseList
	 * @return ArrayList<String[]>
	 * @exception EventException
	 */
	public ArrayList<String[]> makeOccurenceCase(String[][] caseList) throws EventException;
	
	/**
	 * RFA Surcharge 경우의 수 만큼 가져온다.<br>
	 * 
	 * @param ArrayList<String[]> occurList
	 * @param String[][] caseList
	 * @param String[] route
	 * @param int idx
	 * @exception EventException
	 */
	public void findCase(ArrayList<String[]> occurList, String[][] caseList, String[] route, int idx) throws EventException;

	/**
	 * RFA, TAA RevenueAuditOft를 생성한다.<br>
	 * 
	 * @exception EventException
	 */
	public void createRevenueAuditOft() throws EventException;
	
	/**
	 * Group & Multi B/L Rating을위해 RevenueAuditOft를 생성한다.<br>
	 *  
	 * @exception EventException
	 */
	public void createRevenueAuditOftForMultiRating() throws EventException;

	/**
	 * RFA, TAA RevenueAudit Surcharge를 생성한다.<br>
	 * 
	 * @param List<SearchScOftAutoratingListVO> surList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createRevenueAuditSurcharge(List<SearchScOftAutoratingListVO> surList, SignOnUserAccount account) throws EventException;
	
	/**
	 * 특정 SC에 대해 OTH <> ORC 상호 호환하여 심사할 수 있도록 Charge Code를 업데이트<br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @exception EventException
	 */
	public void modifyORCOTHChargeRate(String bkgNo, String caFlg) throws EventException;
	
	/**
	 * 비교 데이터 생성위한 maxseq 를 조회한다. <br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchMaxUmchBkgSeq(UnmatchBLVO pVo, SignOnUserAccount account) throws EventException;
	
	/**
	 * 비교할 Unmatch 데이터를 모두 생성한다.<br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @param List<UnmatchBLVO> unmatchList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addCompareBkgRevUmchAll(UnmatchBLVO pVo, List<UnmatchBLVO> unmatchList, SignOnUserAccount account) throws EventException;
	
	/**
	 * BKG_REV_UMCH_BKG 상태를 비교 조회한다. <br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @return String
	 * @exception EventException
	 */
	public String selectCompareBkgRevUmchBkg(UnmatchBLVO pVo) throws EventException;
	
	/**
	 * BKG_REV_UMCH_ITM 상태를 비교 조회한다. <br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @return String
	 * @exception EventException
	 */
	public String selectCompareBkgRevUmchItm(UnmatchBLVO pVo) throws EventException;
	
	/**
	 * BKG_REV_UMCH_ITM_DTL 상태를 비교 조회한다. <br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @return String
	 * @exception EventException
	 */
	public String selectCompareBkgRevUmchItmDtl(UnmatchBLVO pVo) throws EventException;
	
	
	/**
	 * 비교 Unmatch 데이터를 모두 삭제한다.<br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @exception EventException
	 */
	public void removeCompareBkgRevUmchAll(UnmatchBLVO pVo) throws EventException;

	/**
	 * BKG_REV_UMCH_BKG 테이블의 LST_UMCH_FND_DT 를 갱신한다.<br>
	 * 
	 * @param UnmatchBLVO pVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyCompareBkgRevUmchBkgFndDt(UnmatchBLVO pVo, SignOnUserAccount account) throws EventException;
	
	/**
	 * RFA, TAA 심사 에서 OFT 와 SURCHARGE Autorating 을 Call 할때 필요한 rtAplyDt 를 YYYYMMDD 형식으로 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return String
	 * @exception EventException
	 */
	public String searchAuditRtAplyDt(String bkgNo, String caFlg) throws EventException;	

	/**
	 * RDN 자동 발행 대상을 조회
	 * @param unmatchBLVO
	 * @return AutoRdnInfoVO
	 * @throws EventException
	 */
	public AutoRdnInfoVO searchAutoRdnInfo(UnmatchBLVO unmatchBLVO) throws EventException;

	/**
	 * Self Audit 리스트 조회
	 * @param String blNo
	 * @param String caFlg
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String searchSelfAuditListBackEndJob(String blNo, String caFlg, SignOnUserAccount account) throws EventException; 

	/**
	 * Self Audit 리스트 조회
	 * @param String key
	 * @return RlstSearchSelfAuditListVO
	 * @throws EventException
	 */
	public RlstSearchSelfAuditListVO searchSelfAuditList(String key) throws EventException;
	
	/**
	 * Audit by CNTR Qty Discrepancy 리스트 정보를 CNTR별로 조회한다. <br>
     *
	 * @param EqSubErrSchVO eqSubErrSchVO
	 * @return List<EqSubErrSchVO>
	 * @exception EventException
	 */
	public List<EqSubErrSchVO> searchAuditByEqSubErrList(EqSubErrSchVO eqSubErrSchVO) throws EventException;
	
	/**
	 * EQ. Sub. Inquiry 리스트의 변경 사항을 저장한다. <br>
	 * @param EqSubErrSchVO[] eqSubErrSchVOs
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public  void  manageAuditByEqSubErrList(EqSubErrSchVO[] eqSubErrSchVOs, SignOnUserAccount account) throws EventException;
	/**
	 * COD BKG Inquiry 리스트를 조회한다. <br>
	 * 
	 * @param CODBookingListInVO vo
	 * @return List<CODBookingListOutVO>
	 * @exception EventException
	 */	
	public List<CODBookingListOutVO> searchCODBookingList(CODBookingListInVO vo) throws EventException;
	
	/**
	 * Merchant Request에 의한 Diversion C/A 목록을 조회한다 <br>
	 * 
	 * @param DiversionCAVO vo
	 * @return List<DiversionCAVO>
	 * @exception EventException
	 */	
	public List<DiversionCAVO> searchDiversionCAList(DiversionCAVO vo) throws EventException;
	
	/**
	 * COD BKG Inquiry 리마크를 관리한다. <br>
	 * @param CODBookingListOutVO[] vos
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */	
	
	public void manageCodBookingList(CODBookingListOutVO[] vos, SignOnUserAccount account) throws EventException;

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

	/**
	 * ESM_BKG_0701 : manual settle click <br>
	 * 선택한 BL들에 대한 manual settle을 수행한다.<br>
	 * 
	 * @param String[] bkgNoArr
	 * @param String settleKindCode
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String settleUnmatchBL(String[] bkgNoArr, String settleKindCode, SignOnUserAccount account) throws EventException;

	/**
	 * Customer EDI로 전송 BackEndJob 결과확인<br>
	 * 
	 * @param String key
	 * @return String
	 * @throws EventException
	 */
	public String searchReauditBackEndJobResult(String key) throws EventException;
	/**
	 * 심사를 위한 AK BKG 리스트를 조회한다. <br>
	 * 
	 * @param AwkwardBKGListForAuditVO vo
	 * @return List<AwkwardBKGListForAuditVO>
	 * @exception EventException
	 */	
	public List<AwkwardBKGListForAuditVO> searchAwkwardBKGListforAudit(AwkwardBKGListForAuditVO vo) throws EventException;

	/**
	 * AK Application vs Bay Plan Discrepancy 조회 <br>
	 * 
	 * @param BKGvsBayPlanVO vo
	 * @return List<BKGvsBayPlanVO>
	 * @exception EventException
	 */	
	public List<BKGvsBayPlanVO> searchAwkwardBKGvsBayPlanList(BKGvsBayPlanVO vo) throws EventException;
	
	/**
	 * 심사를 위한 IHC BKG 리스트를 조회한다. <br>
	 * 
	 * @param IhcBKGListForAuditVO vo
	 * @return List<IhcBKGListForAuditVO>
	 * @exception EventException
	 */	
	public List<IhcBKGListForAuditVO> searchIhcBKGListforAudit(IhcBKGListForAuditVO vo) throws EventException;
	
	/**
	 * 소급적용 BKG 리스트를 조회한다. <br>
	 * 
	 * @param RetroActFilterSchVO vo
	 * @return List<RsltSearchRetroActFilterVO>
	 * @exception EventException
	 */	
	public List<RsltSearchRetroActFilterVO> searchRetroactBLFilterList(RetroActFilterSchVO vo) throws EventException;

	/**
	 * TXS BKG List for Audit 리스트를 조회한다. <br>
	 * 
	 * @param TxsBkgListForAuditSchVO vo
	 * @return List<TxsBkgListForAuditVO>
	 * @exception EventException
	 */	
	public List<TxsBkgListForAuditVO> searchTxsBkgListForAudit(TxsBkgListForAuditSchVO vo) throws EventException;

	/**
     * Stop Off BKG List for Audit 정보를 조회한다.<br>
     *
     * @param String fmDt
     * @param String toDt
     * @return List<SearchStopOffBkgListforAuditVO>
     * @exception EventException
     */
    public List<SearchStopOffBkgListforAuditVO> searchStopOffBkgListforAudit(String fmDt, String toDt) throws EventException;

	
	/**
	 * 심사를 위해 특정 Rule Type (Conversion Table상 Code)을 포함하는 Contract Note를 조회 <br>
	 * 
	 * @param ScNoteConversionVO vo
	 * @return List<ScNoteConversionVO>
	 * @exception EventException
	 */	
	public List<ScNoteConversionVO> searchCtrtNoteConversionListByRule(ScNoteConversionVO vo) throws EventException;
	
	/**
	 * BKG별 Bay Plan을 조회한다 <br>
	 * 
	 * @param String bkgNo
	 * @return List<BayPlanVO>
	 * @exception EventException
	 */	
	public List<BayPlanVO> searchBayPlanByBooking(String bkgNo) throws EventException;
	

	/**
	 * OFT성 운임 총합을 비교 조회한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String caFlg
	 * @return String
	 * @exception EventException
	 */
	public String checkTotalBlAmount(String bkgNo, String caFlg) throws EventException;
	

	/**
	 * 심사를 위한 O B/L Surrencer 목록을 조회한다. <br>
	 * 
	 * @param OblSurrenderForAuditVO vo
	 * @return List<OblSurrenderForAuditVO>
	 * @exception EventException
	 */	
	public List<OblSurrenderForAuditVO> searchOblSurrenderForAudit(OblSurrenderForAuditVO vo) throws EventException;
	
	
	/**
	 * 심사를 위한 Non Autorated Charge 목록을 조회한다. <br>
	 * 
	 * @param NonAutoratedChargeVO vo
	 * @return List<NonAutoratedChargeVO>
	 * @exception EventException
	 */	
	public List<NonAutoratedChargeVO> searchNonAutoratedChargeForAudit(NonAutoratedChargeVO vo) throws EventException;
	
	
	/**
	 * Wsc BKG List for Audit 리스트를 조회한다. <br>
	 * 
	 * @param WscBkgListForAuditSchVO vo
	 * @return List<WscBkgListForAuditSchVO>
	 * @exception EventException
	 */	
	public List<WscBkgListForAuditSchVO> searchWscBkgListForAudit(WscBkgListForAuditSchVO vo) throws EventException;
	
	/**
	 * India DTH BKG 리스트를 조회한다. <br>
	 * 
	 * @param IndiaDthBKGListForAuditVO vo
	 * @return List<IndiaDthBKGListForAuditVO>
	 * @exception EventException
	 */	
	public List<IndiaDthBKGListForAuditVO> searchIndiaDthBKGListforAudit(IndiaDthBKGListForAuditVO vo) throws EventException;
	
	
	/**
	 * Iran DTH BKG 리스트를 조회한다. <br>
	 * 
	 * @param IranDthBKGListForAuditVO vo
	 * @return List<IranDthBKGListForAuditVO>
	 * @exception EventException
	 */	
	public List<IranDthBKGListForAuditVO> searchIranDthBKGListforAudit(IranDthBKGListForAuditVO vo) throws EventException;
	
	
    /**
     * unmatch bl age 리스트를 조회한다.
     * @param UmchErrBlReportVO vo
     * @return List<UmchErrBlReportVO>
     * @throws EventException
     */
    public List<UmchErrBlReportVO> searchUnmatchBLAgingList(UmchErrBlReportVO vo) throws EventException;
    
    
    /**
     * rating시 OFT가 2개 이상 뜨는 건에 대해 조회한다.
     * @param MultiRateBkgListVO vo
     * @return List<MultiRateBkgListVO>
     * @throws EventException
     */
    public List<MultiRateBkgListVO> searchMultiRateBkgList(MultiRateBkgListVO vo) throws EventException;

    /**
     * Multi Rate BKG List for Audit(1) 조회
     * @param MultiRateBkgListVO vo
     * @return List<MultiRateBkgListVO>
     * @throws EventException
     */
    public List<MultiRateBkgList1VO> searchMultiRateBkgList_1(MultiRateBkgList1VO vo) throws EventException;
    
    /**
     * Multi Rate BKG List for Audit(1) 수정(Save 버튼)
     * @param multiRateBkgList1VOs
     * @param account
     * @throws EventException
     */
    public void manageMultiRateBkgList_1(MultiRateBkgList1VO[] multiRateBkgList1VOs, SignOnUserAccount account) throws EventException;
    
    /**
     * Multi Rate BKG List for Audit(1) 확인(Confirm 버튼)
     * @param multiRateBkgList1VOs
     * @param account
     * @throws EventException
     */
    public void confirmMultiRateBkgList_1(MultiRateBkgList1VO[] multiRateBkgList1VOs, SignOnUserAccount account) throws EventException;
    
    /**
     * Multi Rate BKG List for Audit(1) 확인 취소(Release 버튼)
     * @param multiRateBkgList1VOs
     * @param account
     * @throws EventException
     */
    public void releaseMultiRateBkgList_1(MultiRateBkgList1VO[] multiRateBkgList1VOs, SignOnUserAccount account) throws EventException; 
}
