/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFARateProposalBC.java
 *@FileTitle : RFARateProposalBC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.20
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.08.20 박성수
 * 1.0 Creation
=========================================================
* History
* 2013.12.20 서미진 [CHM-201328281] RFA에 계약 구분인자 추가 (C : Contract, S : Spot)
* 2014.03.11 서미진 [CHM-201429293] Route 중에 term이 빠진 Location check
* 2015.04.22 전지예 [CHM-201535165] RFA match back 팝업화면 추가
* 2015.11.26 SELCMU/김현경 [CHM-201538236] RFA module 승인 절차 간소화 및 기능 개선
 * 2016.05.03 RFA 효율화를 위한 요청 (1차) (CHM-201640671)
 * 2016.07.20 [CHM-201642287] Master RFA Cancel시 Basic RFA 점검 로직 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PrsBatchVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.profitabilitysimulation.vo.InpPrsSurchargeDetailApplicableRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.vo.PriRfaNoteConvListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.vo.RsltNoteConvVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropMnVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.CheckGRICalculationValidationVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.ChkFontStyleVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.FicCheckCYPortLocationVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.FicRateLoadExcelGuidelineCheckVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.FicRouteGroupVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.InCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.PriRpScpRtCmdtRoutSetVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RfaGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RfaRtPropCmdtVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RfaRtPropRtVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltAllRtListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltFicCheckCYPortLocationVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltFicGuidelineRateVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriAmdCmViewAllVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriAmdCmpbOpbViewAllVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriCostDetailByTransModeListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriPrsCostDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriPrsCostListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriRateCmViewAllVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriRateCmpbViewAllListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriRpScpRtCgoSpecVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeAdjustCommodityDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeAdjustCommodityVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeAdjustListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeAdjustLocationGroupDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeAdjustLocationGroupVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeLastAccessDateVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriSurchargeViewAllVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPrsSurchargeDetailListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRoutHdrSmryListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCheckDuplicateVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCmdtListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCmdtRoutListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListHorizontalExcelForAddOnTariffVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListHorizontalExcelForAeeAewVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListHorizontalExcelVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListHorizontalLoadExcelForAeeAewVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListVerticalExcelForAddOnTariffVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListVerticalExcelForAeeAewVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListVerticalExcelVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtRoutHdrInquiryListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtRoutHdrListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtRouteMBListVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriPrsBatVO;
import com.hanjin.syscommon.common.table.PriRfaNoteConvVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpGriGrpVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpRtActCustVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCgoSpecVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRnoteVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCnoteVO;
import com.hanjin.syscommon.common.table.PriRpScpRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriRpScpRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriRpScpRtScgVO;
import com.hanjin.syscommon.common.table.PriRpScpRtUsdRoutCsVO;
import com.hanjin.syscommon.common.table.PriRpScpRtVO;
import com.hanjin.syscommon.common.table.PriRpScpScgAdjVO;

/**
 * NIS2010-Scguideline Business Logic Command Interface<br>
 * - NIS2010-Scguideline에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Moon Dong Gyu
 * @see Ui_pri_0030EventResponse 참조
 * @since J2EE 1.4
 */

public interface RFARateProposalBC {

	/**
	 * CUD트랜잭션 처리 후, 화면표시를 위한 스타일정보 조회<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return RsltRtCmdtRoutListVO
	 * @exception EventException
	 */
	public RsltRtCmdtRoutListVO searchRateCmdtRoutStyle(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws EventException;

	/**
	 * Rate의 Commodity Group을 조회합니다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Master RFA의 Commodity를 조회합니다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchMstRateCommodityList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Rate Inquiry - Commodity Group을 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityInquiryList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Rate History - Commodity Group을 조회한다.
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityHistoryList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Rate의 Route 정보를 조회합니다.<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception EventException
	 */
	public List<RsltRtRoutHdrListVO> searchRateRouteList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws EventException;

	/**
	 * Master RFA의 Route & Summary 정보를 조회합니다.<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return List<RsltRoutHdrSmryListVO>
	 * @exception EventException
	 */
	public List<RsltRoutHdrSmryListVO> searchRouteSummaryList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws EventException;
	
	/**
	 * Rate Inquiry - Route 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrInquiryListVO>
	 * @exception EventException
	 */
	public List<RsltRtRoutHdrInquiryListVO> searchRateRouteInquiryList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws EventException;

	/**
	 * Rate History - Route 리스트를 조회한다.
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception EventException
	 */
	public List<RsltRtRoutHdrListVO> searchRateRouteHistoryList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws EventException;

	/**
	 * Rate 정보를 조회한다.
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param boolean addOnFlag
	 * @return RsltRtListVO
	 * @exception EventException
	 */
	public RsltRtListVO searchRateList(PriRpScpRtVO priRpScpRtVO, boolean addOnFlag) throws EventException;

	/**
	 * Rate 정보를 조회한다.
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param boolean addOnFlag
	 * @return RsltRtListVO
	 * @exception EventException
	 */
	public RsltRtListVO searchMstRateList(PriRpScpRtVO priRpScpRtVO, boolean addOnFlag) throws EventException;

	/**
	 * Rate Inquiry - Rate 정보를 조회한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return RsltRtListVO
	 * @exception EventException
	 */
	public RsltRtListVO searchRateInquiryList(PriRpScpRtVO priRpScpRtVO) throws EventException;

	/**
	 * Excel Download(Vertical)를 위한 조회를 실행한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtListVerticalExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListVerticalExcelVO> searchRateListVerticalExcel(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Excel Download(Horizontal)를 위한 조회를 실행한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtListHorizontalExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListHorizontalExcelVO> searchRateListHorizontalExcel(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Check Duplicate화면 - 중복된 Rate 리스트를 조회합니다. <br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtCheckDuplicateVO>
	 * @exception EventException
	 */
	public List<RsltRtCheckDuplicateVO> searchRateCheckDuplicate(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Accept All 화면의 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltAllRtListVO>
	 * @exception EventException
	 */
	public List<RsltAllRtListVO> searchAllRateList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Accept All 화면의 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltAllRtListVO>
	 * @exception EventException
	 */
	public List<RsltAllRtListVO> searchAllSpotRateList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;
	
	/**
	 * Rate의 Commodity의 마지막 Bullet No. 값을 조회합니다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return String
	 * @exception EventException
	 */
	public String getMaxOldBulletDispSeq(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Commodity Group 및 관련 정보의 멀티 트랜잭션을 처리한다.<br>
	 * 
	 * @param RfaRtPropCmdtVO rfaRtPropCmdtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateCommodity(RfaRtPropCmdtVO rfaRtPropCmdtVO, SignOnUserAccount account) throws EventException;

	/**
	 * Route 및 Rate 데이터의 멀티 트랜잭션을 처리한다.<br>
	 * 
	 * @param RfaRtPropRtVO rfaRtPropRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRate(RfaRtPropRtVO rfaRtPropRtVO, SignOnUserAccount account) throws EventException;

	/**
	 * Master RFA에서 Route 및 Rate 데이터의 멀티 트랜잭션을 처리한다.<br>
	 * 
	 * @param RfaRtPropRtVO rfaRtPropRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateMst(RfaRtPropRtVO rfaRtPropRtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Actual Customer 데이터를 Accept합니다.<br>
	 * 
	 * @param PriRpScpRtActCustVO[] priRpScpRtActCustVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptActualCustomer(PriRpScpRtActCustVO[] priRpScpRtActCustVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Actual Customer 데이터를 Accept Cancel합니다.<br>
	 * 
	 * @param PriRpScpRtActCustVO[] priRpScpRtActCustVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelActualCustomer(PriRpScpRtActCustVO[] priRpScpRtActCustVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Rate 데이터를 Accept한다.<br>
	 * 
	 * @param PriRpScpRtVO[] priRpScpRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRate(PriRpScpRtVO[] priRpScpRtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Rate 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param PriRpScpRtVO[] priRpScpRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRate(PriRpScpRtVO[] priRpScpRtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Commodity Note 데이터를 Accept한다.<br>
	 * 
	 * @param PriRpScpRtCnoteVO[] priRpScpRtCnoteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateCnote(PriRpScpRtCnoteVO[] priRpScpRtCnoteVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Commodity Note 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param PriRpScpRtCnoteVO[] priRpScpRtCnoteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateCnote(PriRpScpRtCnoteVO[] priRpScpRtCnoteVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Commodity 데이터를 Accept한다.<br>
	 * 
	 * @param PriRpScpRtCmdtVO[] priRpScpRtCmdtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateCommodityDetail(PriRpScpRtCmdtVO[] priRpScpRtCmdtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Commodity 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param PriRpScpRtCmdtVO[] priRpScpRtCmdtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateCommodityDetail(PriRpScpRtCmdtVO[] priRpScpRtCmdtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Route Note 데이터를 Accept한다.<br>
	 * 
	 * @param PriRpScpRtCmdtRnoteVO[] priRpScpRtCmdtRnoteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateCommodityRnote(PriRpScpRtCmdtRnoteVO[] priRpScpRtCmdtRnoteVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Route Note 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param PriRpScpRtCmdtRnoteVO[] priRpScpRtCmdtRnoteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateCommodityRnote(PriRpScpRtCmdtRnoteVO[] priRpScpRtCmdtRnoteVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Route Point 데이터를 Accept한다.<br>
	 * 
	 * @param PriRpScpRtRoutPntVO[] priRpScpRtRoutPntVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateRoutePointDetail(PriRpScpRtRoutPntVO[] priRpScpRtRoutPntVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Route Point 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param PriRpScpRtRoutPntVO[] priRpScpRtRoutPntVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateRoutePointDetail(PriRpScpRtRoutPntVO[] priRpScpRtRoutPntVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Route Via. 데이터를 Accept한다.<br>
	 * 
	 * @param PriRpScpRtRoutViaVO[] priRpScpRtRoutViaVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateRouteViaDetail(PriRpScpRtRoutViaVO[] priRpScpRtRoutViaVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Route Point 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param PriRpScpRtRoutViaVO[] priRpScpRtRoutViaVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateRouteViaDetail(PriRpScpRtRoutViaVO[] priRpScpRtRoutViaVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Rate내의 모든항목을 Accept 처리한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param String ficRtTpCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllRate(PriRpScpRtVO priRpScpRtVO, String ficRtTpCd, SignOnUserAccount account) throws EventException;

	/**
	 * Master RFA Rate내의 모든항목을 Accept 처리한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param String ficRtTpCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllMstRate(PriRpScpRtVO priRpScpRtVO, String ficRtTpCd, SignOnUserAccount account) throws EventException;

	/**
	 * Rate의 모든 항목을 Accept Cancel한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param String ficRtTpCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllRate(PriRpScpRtVO priRpScpRtVO, String ficRtTpCd, SignOnUserAccount account) throws EventException;

	/**
	 * Master RFA Rate의 모든 항목을 Accept Cancel한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param String ficRtTpCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllMstRate(PriRpScpRtVO priRpScpRtVO, String ficRtTpCd, SignOnUserAccount account) throws EventException;

	/**
	 * Guideline의 데이터를 복사해온다.<br>
	 * 
	 * @param RfaGlineCopyVO rfaGlineCopyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineRate(RfaGlineCopyVO rfaGlineCopyVO, SignOnUserAccount account) throws EventException;

	/**
	 * Guideline Copy전 Group Location, Group Commodity가 존재하는지 확인한다.<br>
	 * 
	 * @param RfaGlineCopyVO rfaGlineCopyVO
	 * @return RsltCdListVO
	 * @exception EventException
	 */
	public RsltCdListVO checkGlineCopyGroupCodeExist(RfaGlineCopyVO rfaGlineCopyVO) throws EventException;

	/**
	 * Rate 데이터에 GRI Calculation을 적용합니다.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void applyGRICalculation(PriRpScpGriGrpVO priRpScpGriGrpVO, SignOnUserAccount account) throws EventException;

	/**
	 * 적용한 GRI Calculation을 취소합니다.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGRICalculation(PriRpScpGriGrpVO priRpScpGriGrpVO, SignOnUserAccount account) throws EventException;

	/**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @exception EventException
	 */
	public void removeProposalMain(PriRpScpMnVO priRpScpMnVO) throws EventException;

	/**
	 * Load된 엑셀 데이터가 올바른지 Check한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelVertical(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs)
			throws EventException;

	/**
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String uploadRateExcelVertical(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs, SignOnUserAccount account)
			throws EventException;

	/**
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelVerticalOnline(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs, SignOnUserAccount account)
			throws EventException;

	/**
	 * Load된 엑셀 데이터가 올바른지 Check한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelHorizontal(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs)
			throws EventException;
	
	/**
	 * Load된 엑셀 데이터가 올바른지 Check한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkMstRateExcelHorizontal(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs)
			throws EventException;

	/**
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String uploadRateExcelHorizontal(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs, SignOnUserAccount account)
			throws EventException;

	/**
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String uploadMstRateExcelHorizontal(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs, SignOnUserAccount account)
			throws EventException;
	
	/**
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelHorizontalOnline(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs,
			SignOnUserAccount account) throws EventException;

	/**
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadMstRateExcelHorizontalOnline(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs,
			SignOnUserAccount account) throws EventException;
	
	// /////////////////////////// 박성수 수정 종료 ///////////////////////////////////////

	/**
	 * 조회 이벤트 처리<br>
	 * CM/OP 산출 이후, Rout별 적용된 Surcharge 상세정보 확인하는 Applicable Route 데이터<br>
	 * 
	 * @param InpPrsSurchargeDetailApplicableRouteVO inpPrsSurchargeDetailApplicableRouteVO
	 * @return RsltPrsSurchargeDetailListVO
	 * @exception EventException
	 */
	public RsltPrsSurchargeDetailListVO searchSurchargeList(InpPrsSurchargeDetailApplicableRouteVO inpPrsSurchargeDetailApplicableRouteVO) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * PRS- Surcharge Detail 내용을 추가,삭제,갱신처리 합니다.<br>
	 * 
	 * @param PriRpScpRtScgVO[] priRpScpRtScgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateSurcharge(PriRpScpRtScgVO[] priRpScpRtScgVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Surcharge Adjust List 확인하는 데이터<br>
	 * 
	 * @param RsltPriSurchargeAdjustListVO schPriSurchargeAdjustListVO
	 * @return List<RsltPriSurchargeAdjustListVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustListVO> searchSurchargeAdjustList(RsltPriSurchargeAdjustListVO schPriSurchargeAdjustListVO) throws EventException;

	/**
	 * PRS- Surcharge Adjust 내용을 추가,삭제,갱신실행 합니다.<br>
	 * 
	 * @param PriRpScpScgAdjVO[] priSpScpScgAdjVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSurchargeAdjust(PriRpScpScgAdjVO[] priSpScpScgAdjVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Surcharge Adjust-Commodity 조회 처리<br>
	 * Commodity Group 선택 리스트 조회 이벤트 처리<br>
	 * 
	 * @param RsltPriSurchargeAdjustCommodityVO rsltPriSurchargeAdjustCommodityVO
	 * @return List<RsltPriSurchargeAdjustCommodityVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustCommodityVO> searchRateCommodityAllList(RsltPriSurchargeAdjustCommodityVO rsltPriSurchargeAdjustCommodityVO) throws EventException;

	/**
	 * Surcharge Adjust-Commodity 조회 처리<br>
	 * Commodity 상세 리스트 조회 이벤트 처리<br>
	 * 
	 * @param RsltPriSurchargeAdjustCommodityDetailVO rsltPriSurchargeAdjustCommodityVO
	 * @return List<RsltPriSurchargeAdjustCommodityDetailVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustCommodityDetailVO> searchRateGroupCommodityDetailList(RsltPriSurchargeAdjustCommodityDetailVO rsltPriSurchargeAdjustCommodityVO)
			throws EventException;

	/**
	 * Surcharge Adjust-Location 조회 처리<br>
	 * Location Group 선택 리스트 조회 이벤트 처리<br>
	 * 
	 * @param RsltPriSurchargeAdjustLocationGroupVO rsltPriSurchargeAdjustLocationGroupVO
	 * @return List<RsltPriSurchargeAdjustLocationGroupVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustLocationGroupVO> searchRateLocationAllList(RsltPriSurchargeAdjustLocationGroupVO rsltPriSurchargeAdjustLocationGroupVO)
			throws EventException;

	/**
	 * Surcharge Adjust-Location 조회 처리<br>
	 * Location Group 상세 리스트 조회 이벤트 처리<br>
	 * 
	 * @param RsltPriSurchargeAdjustLocationGroupDetailVO rsltPriSurchargeAdjustLocationGroupVO
	 * @return List<RsltPriSurchargeAdjustLocationGroupDetailVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustLocationGroupDetailVO> searchRateGroupLocationDetailList(
			RsltPriSurchargeAdjustLocationGroupDetailVO rsltPriSurchargeAdjustLocationGroupVO) throws EventException;

	/**
	 * PRS- Cost Detail 조회 처리<br>
	 * PRS- Cost Detail List 확인 리스트 조회 이벤트 처리<br>
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @return List<RsltPriPrsCostListVO>
	 * @exception EventException
	 */
	public List<RsltPriPrsCostListVO> searchCostDetailList(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws EventException;

	/**
	 * PRS- Cost Detail 조회 처리<br>
	 * PRS- Cost Detail List 확인 리스트 조회 이벤트 처리<br>
	 * 
	 * @param RsltPriPrsCostDetailVO rsltPriPrsCostDetailVO
	 * @return List<RsltPriPrsCostDetailVO>
	 * @exception EventException
	 */
	public List<RsltPriPrsCostDetailVO> searchCostDetailInquiryList(RsltPriPrsCostDetailVO rsltPriPrsCostDetailVO) throws EventException;

	/**
	 * Trans.Mode에 따른 Cost 상세정보를 조회 합니다.<br>
	 * 
	 * @param RsltPriCostDetailByTransModeListVO rsltPriCostDetailByTransModeListVO
	 * @return List<RsltPriCostDetailByTransModeListVO>
	 * @exception EventException
	 */
	public List<RsltPriCostDetailByTransModeListVO> searchCostDetailByTransModeList(RsltPriCostDetailByTransModeListVO rsltPriCostDetailByTransModeListVO)
			throws EventException;

	/**
	 * CM/OP View 의 Load 값을 갱신처리 합니다.
	 * 
	 * @param PriRpScpRtCmdtRoutSetVO priRpScpRtCmdtRoutSetVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPrsPfmc(PriRpScpRtCmdtRoutSetVO priRpScpRtCmdtRoutSetVO, SignOnUserAccount account) throws EventException;

	/**
	 * CM/OP View All 팝업화면 조회 처리<br>
	 * 
	 * @param RsltPriRateCmViewAllVO rsltPriRateCmViewAllVO
	 * @return List<RsltPriRateCmViewAllVO>
	 * @exception EventException
	 */
	public List<RsltPriRateCmViewAllVO> searchRateCmViewAllList(RsltPriRateCmViewAllVO rsltPriRateCmViewAllVO) throws EventException;

	/**
	 * RFA Amendment CM/OP View 내용을 조회 합니다.<br>
	 * 
	 * @param RsltPriAmdCmViewAllVO rsltPriAmdCmViewAllVO
	 * @return List<RsltPriAmdCmViewAllVO>
	 * @exception EventException
	 */
	public List<RsltPriAmdCmViewAllVO> searchAmdtRateCmViewAllList(RsltPriAmdCmViewAllVO rsltPriAmdCmViewAllVO) throws EventException;

	/**
	 * CM/OP화면의 CMPB/OPB를 1건 조회한다..<br>
	 * 
	 * @param RsltPriAmdCmViewAllVO rsltPriAmdCmViewAllVO
	 * @return RsltPriAmdCmpbOpbViewAllVO
	 * @exception EventException
	 */
	public RsltPriAmdCmpbOpbViewAllVO searchAmdtRateCmpbAndOpbViewAll(RsltPriAmdCmViewAllVO rsltPriAmdCmViewAllVO) throws EventException;

	/**
	 * RFA Amendment CM/OP View 의 Load 값을 갱신처리 합니다.
	 * 
	 * @param PriRpScpRtCmdtRoutSetVO priRpScpRtCmdtRoutSetVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAmdtPrsPfmc(PriRpScpRtCmdtRoutSetVO priRpScpRtCmdtRoutSetVO, SignOnUserAccount account) throws EventException;

	/**
	 * RFA Proposal/Amendment CMPB 또는 OPB 를 조회 합니다.<br>
	 * 
	 * @param RsltPriRateCmpbViewAllListVO rsltPriRateCmpbViewAllListVO
	 * @return List<RsltPriRateCmpbViewAllListVO>
	 * @exception EventException
	 */
	public List<RsltPriRateCmpbViewAllListVO> searchRateCmpbViewAllList(RsltPriRateCmpbViewAllListVO rsltPriRateCmpbViewAllListVO) throws EventException;

	/**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpScpMnVO[] priRpScpMnVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Amend Request를 처리합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * Rate Cargo Specification 조회합니다.<br>
	 * 
	 * @param PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO
	 * @return List<RsltPriRpScpRtCgoSpecVO>
	 * @exception EventException
	 */
	public List<RsltPriRpScpRtCgoSpecVO> searchRateCargoSepcification(PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO) throws EventException;

	/**
	 * Rate Cargo Specification를 수정합니다. <br>
	 * 
	 * @param PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateCargoSepcification(PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO, SignOnUserAccount account) throws EventException;

	/**
	 * RATE관련 Cost, CMPB,OPB 값을 갱신하고 그 갱신여부를 Mark해둔다..<BR>
	 * 
	 * @param rsltPriPrsCostListVOS RsltPriPrsCostListVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyPrsCost(RsltPriPrsCostListVO[] rsltPriPrsCostListVOS, SignOnUserAccount account) throws EventException;

	/**
	 * Pre CM/OP Simulation Cost관련 Cost, CMPB,OPB 값을 갱신.
	 * 
	 * @param RsltPriPrsCostListVO[] rsltPriPrsCostListVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPrsSimulationCost(RsltPriPrsCostListVO[] rsltPriPrsCostListVOS, SignOnUserAccount account) throws EventException;

	/**
	 * [Rate Note Conversion]을 [조회] 합니다.<br>
	 * 
	 * @param PriRfaNoteConvVO priRfaNoteConvVO
	 * @return List<RsltNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltNoteConvVO> searchNoteConversionList(PriRfaNoteConvVO priRfaNoteConvVO) throws EventException;

	/**
	 * [복사된 Rate Note Conversion]을 [조회] 합니다.<br>
	 * 
	 * @param PriRfaNoteConvVO priRfaNoteConvVO
	 * @param SignOnUserAccount account
	 * @return List<RsltNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltNoteConvVO> searchNoteConversionListCopy(PriRfaNoteConvVO priRfaNoteConvVO, SignOnUserAccount account) throws EventException;

	/**
	 * [Rate Note Conversion]을 [복사] 합니다.<br>
	 * 
	 * @param PriRfaNoteConvListVO[] priRfaNoteConvListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCopy(PriRfaNoteConvListVO[] priRfaNoteConvListVOs, SignOnUserAccount account) throws EventException;

	/**
	 * RFA Proposal Rate 정보를 Copy 합니다.<br>
	 * 
	 * @param RsltRfaPropCopyVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyProposalScopeRate(RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * Master RFA Proposal Rate 정보를 Copy 합니다.<br>
	 * 
	 * @param RsltRfaPropCopyVO vo
	 * @param RsltRoutHdrSmryListVO[] rsltRoutHdrSmryListVOs
	 * @param SignOnUserAccount account
	 * @param String rfaTypeCode
	 * @exception EventException
	 */
	public void copyProposalScopeRateMst(RsltRfaPropCopyVO vo, RsltRoutHdrSmryListVO[] rsltRoutHdrSmryListVOs, SignOnUserAccount account, String rfaTypeCode) throws EventException;
	
	/**
	 * Guideline Rate 를 Proposal 에 Copy 합니다.<br>
	 * 
	 * @param RpScpGlineCopyVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyScopeGuidelineRate(RpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * PRS 정보를 Copy 하여 Rate 정보를 생성합니다.<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyToProposalRate(RsltCopyToProposalVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * Calculate Batch를 비동기 적으로 실행킨다.<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @param String rotationPrsBatId
	 * @param SignOnUserAccount account
	 * @return PriPrsBatVO
	 * @exception EventException
	 */
	public PriPrsBatVO executeCalculate(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO, String rotationPrsBatId, SignOnUserAccount account) throws EventException;

	/**
	 * Calculate Batch ID를 조회 하기 위한 Parameter를 조합한다.<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return PriPrsBatVO
	 * @exception EventException
	 */
	public PriPrsBatVO searchMonitorCalculateParam(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws EventException;

	/**
	 * Calculate Batch의 상태 조회.<br>
	 * 
	 * @param PrsBatchVO prsBatchVO
	 * @return String
	 * @exception EventException
	 */
	public String monitorCalculate(PrsBatchVO prsBatchVO) throws EventException;

	/**
	 * Rate Route Case를 추가 한다. .<br>
	 * 
	 * @param PriRpScpRtUsdRoutCsVO priRpScpRtUsdRoutCsVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriRateUsedRouteCase(PriRpScpRtUsdRoutCsVO priRpScpRtUsdRoutCsVO, SignOnUserAccount account) throws EventException;

	/**
	 * Route의 선택여부를 Mark해둔다..<BR>
	 * 
	 * @param List<RsltPriPrsCostListVO> rsltPriPrsCostListVO
	 * @exception EventException
	 */
	public void modifyPrsRateCommodityRoute(List<RsltPriPrsCostListVO> rsltPriPrsCostListVO) throws EventException;

	/**
	 * Calculate Logic을 이용해 data를 갱신한다..<BR>
	 * 
	 * @param List<RsltPriPrsCostListVO> rsltPriPrsCostListVO
	 * @exception EventException
	 */
	public void modifyCalculateLogicData(List<RsltPriPrsCostListVO> rsltPriPrsCostListVO) throws EventException;

	/**
	 * PRS- Surcharge Adjust 내용을 바탕으로 calc 로직을 수행 합니다.<br>
	 * 
	 * @param PriRpScpScgAdjVO priRpScpScgAdjVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSurchargeAdjustCalc(PriRpScpScgAdjVO priRpScpScgAdjVO, SignOnUserAccount account) throws EventException;

	/**
	 * COST CM/OP PRE SIMULATION 화면에서 ROUTE정보를 조회 한다.<br>
	 * 
	 * @param InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO
	 * @return List<RsltPriCostSimulationCheckRouteVO>
	 * @exception EventException
	 */
	public List<RsltPriCostSimulationCheckRouteVO> searchCostSimulationCheckRoutList(InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO) throws EventException;

	/**
	 * RFA Proposal - Rate Tab의 Surcharge View All Popup의 내용을 조회를 처리합니다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltPriSurchargeViewAllVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeViewAllVO> searchSurchargeViewAllList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * RFA Proposal - Rate Tab의 Surcharge View All Popup에서 Surcharge 값이 언제 만들어 졌는지를 조회 처리합니다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltPriSurchargeLastAccessDateVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeLastAccessDateVO> searchSurchargeLastAccessDateList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Surcharge 정보를 삭제 합니다.<br>
	 * 
	 * @param RfaPropMnVO rfaPropMnVO
	 * @exception EventException
	 */
	public void manageProposalScopeSurchargeRemove(RfaPropMnVO rfaPropMnVO) throws EventException;

	/**
	 * 이전 AMDT_SEQ에 해당하는 메인의 EXPIRE DATE정보를 조회한다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @return String
	 * @exception EventException
	 */
	public String searchBeforeExpireDate(PriRpScpMnVO priRpScpMnVO) throws EventException;

	/**
	 * Rate의 General(CY)와 IHC의 FONT STYLE를 조회합니다. <br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<ChkFontStyleVO>
	 * @exception EventException
	 */
	public List<ChkFontStyleVO> checkFontStyle(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * 조건에 일치하는 최대 Commmodity Header Sequence를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<PriRpScpRtCmdtHdrVO>
	 * @exception EventException
	 */
	public String searchMaxCmdtHdrSeq(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * FIC Route Group을 조회한다.<br>
	 * 
	 * @param FicRouteGroupVO ficRouteGroupVO
	 * @param boolean addOnFlag
	 * @return List<FicRouteGroupVO>
	 * @exception EventException
	 */
	public List<FicRouteGroupVO> searchFicRouteGroup(FicRouteGroupVO ficRouteGroupVO, boolean addOnFlag) throws EventException;

	/**
	 * Local FIC Guide Line RT Amount 조회한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return String
	 * @exception EventException
	 */
	public String searchLocalFicGlineRtAmt(PriRpScpRtVO priRpScpRtVO) throws EventException;

	/**
	 * location code또는 group location code에 CY가 포함돼 있는 확인한다.<br>
	 * 
	 * @param FicCheckCYPortLocationVO ficCheckCYPortLocationVO
	 * @return List<RsltFicCheckCYPortLocationVO>
	 * @exception EventException
	 */
	public List<RsltFicCheckCYPortLocationVO> checkCYPortLocationCode(FicCheckCYPortLocationVO ficCheckCYPortLocationVO) throws EventException;

	/**
	 * Route Via. 데이터를 Accept한다.<br>
	 * 
	 * @param PriRpScpRtRoutViaVO priRpScpRtRoutViaVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAutoRateRouteViaDetail(PriRpScpRtRoutViaVO priRpScpRtRoutViaVO, SignOnUserAccount account) throws EventException;

	/**
	 * Route Via. 데이터를 Accept한다.<br>
	 * 
	 * @param PriRpScpRtRoutViaVO priRpScpRtRoutViaVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptCancelAutoRateRouteViaDetail(PriRpScpRtRoutViaVO priRpScpRtRoutViaVO, SignOnUserAccount account) throws EventException;

	/**
	 * AEE.AEW를 위한 Excel Download(Vertical)를 위한 조회를 실행한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtListVerticalExcelForAeeAewVO>
	 * @exception EventException
	 */
	public List<RsltRtListVerticalExcelForAeeAewVO> searchRateListVerticalExcelForAeeAew(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * AEE.AEW를 위한 Excel Download(Horizontal)를 위한 조회를 실행한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtListHorizontalExcelForAeeAewVO>
	 * @exception EventException
	 */
	public List<RsltRtListHorizontalExcelForAeeAewVO> searchRateListHorizontalExcelForAeeAew(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelForAeeAewVO[] rsltRtListVerticalExcelForAeeAewVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelVerticalOnlineForAeeAew(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListVerticalExcelForAeeAewVO[] rsltRtListVerticalExcelForAeeAewVOs,
			SignOnUserAccount account) throws EventException;

	/**
	 * Load된 엑셀 데이터가 올바른지 Check한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelForAeeAewVO[] rsltRtListVerticalExcelForAeeAewVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelVerticalForAeeAew(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO,
			RsltRtListVerticalExcelForAeeAewVO[] rsltRtListVerticalExcelForAeeAewVOs) throws EventException;

	/**
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelForAeeAewVO[] rsltRtListVerticalExcelForAeeAewVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String uploadRateExcelVerticalForAeeAew(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListVerticalExcelForAeeAewVO[] rsltRtListVerticalExcelForAeeAewVOs,
			SignOnUserAccount account) throws EventException;

	/**
	 * Load된 엑셀 데이터가 올바른지 Check한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalLoadExcelForAeeAewVO[] rsltRtListHorizontalLoadExcelForAeeAewVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelHorizontalForAeeAew(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO,
			RsltRtListHorizontalLoadExcelForAeeAewVO[] rsltRtListHorizontalLoadExcelForAeeAewVOs) throws EventException;

	/**
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalLoadExcelForAeeAewVO[] rsltRtListHorizontalLoadExcelForAeeAewVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String uploadRateExcelHorizontalForAeeAew(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO,
			RsltRtListHorizontalLoadExcelForAeeAewVO[] rsltRtListHorizontalLoadExcelForAeeAewVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalLoadExcelForAeeAewVO[] rsltRtListHorizontalLoadExcelForAeeAewVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelHorizontalOnlineForAeeAew(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO,
			RsltRtListHorizontalLoadExcelForAeeAewVO[] rsltRtListHorizontalLoadExcelForAeeAewVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Rate의 General(CY)와 IHC의 FONT STYLE를 조회합니다. <br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<ChkFontStyleVO>
	 * @exception EventException
	 */
	public List<ChkFontStyleVO> checkHistoryFontStyle(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Rate 데이터에 GRI Calculation Validation 처리.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @param SignOnUserAccount account
	 * @return List<CheckGRICalculationValidationVO>
	 * @exception EventException
	 */
	public List<CheckGRICalculationValidationVO> checkGRICalculationValidation(PriRpScpGriGrpVO priRpScpGriGrpVO, SignOnUserAccount account) throws EventException;

	/**
	 * Rate 데이터에 GRI Calculation을 적용합니다.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @param CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void applyGRICalculationForIHC(PriRpScpGriGrpVO priRpScpGriGrpVO, CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs, SignOnUserAccount account)
			throws EventException;

	/**
	 * Rate 데이터에 GRI Calculation을 취조.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @param CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGRICalculationForIHC(PriRpScpGriGrpVO priRpScpGriGrpVO, CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs,
			SignOnUserAccount account) throws EventException;

	/**
	 * Load된 엑셀 데이터의 FIC Rate를 조회한다.<br>
	 * 
	 * @param FicRateLoadExcelGuidelineCheckVO ficRateLoadExcelGuidelineCheckVO
	 * @param FicRateLoadExcelGuidelineCheckVO[] ficRateLoadExcelGuidelineCheckVOs
	 * @return List<RsltFicGuidelineRateVO>
	 * @exception EventException
	 */
	public List<RsltFicGuidelineRateVO> searchFicGuidelineRateForAeeAew(FicRateLoadExcelGuidelineCheckVO ficRateLoadExcelGuidelineCheckVO,
			FicRateLoadExcelGuidelineCheckVO[] ficRateLoadExcelGuidelineCheckVOs) throws EventException;

	/**
	 * AEE.AEW를 위한 Excel Download(Vertical)를 위한 조회를 실행한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtListVerticalExcelForAddOnTariffVO>
	 * @exception EventException
	 */
	public List<RsltRtListVerticalExcelForAddOnTariffVO> searchRateListVerticalExcelForAddOnTariff(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * AEE.AEW를 위한 Excel Download(Horizontal)를 위한 조회를 실행한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtListHorizontalExcelForAddOnTariffVO>
	 * @exception EventException
	 */
	public List<RsltRtListHorizontalExcelForAddOnTariffVO> searchRateListHorizontalExcelForAddOnTariff(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Load된 엑셀 데이터의 FIC Rate를 조회한다.<br>
	 * 
	 * @param FicRateLoadExcelGuidelineCheckVO ficRateLoadExcelGuidelineCheckVO
	 * @param FicRateLoadExcelGuidelineCheckVO[] ficRateLoadExcelGuidelineCheckVOs
	 * @param String inOrgDestTpCd
	 * @return List<RsltFicGuidelineRateVO>
	 * @exception EventException
	 */
	public List<RsltFicGuidelineRateVO> searchFicGuidelineRateForAddOnTariff(FicRateLoadExcelGuidelineCheckVO ficRateLoadExcelGuidelineCheckVO,
			FicRateLoadExcelGuidelineCheckVO[] ficRateLoadExcelGuidelineCheckVOs, String inOrgDestTpCd) throws EventException;

	/**
	 * Load된 엑셀 데이터가 올바른지 Check한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelForAddOnTariffVO[] rsltRtListVerticalExcelForAddOnTariffVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelVerticalForAddOnTariff(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO,
			RsltRtListVerticalExcelForAddOnTariffVO[] rsltRtListVerticalExcelForAddOnTariffVOs) throws EventException;

	/**
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelForAddOnTariffVO[] rsltRtListVerticalExcelForAddOnTariffVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelVerticalOnlineForAddOnTariff(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO,
			RsltRtListVerticalExcelForAddOnTariffVO[] rsltRtListVerticalExcelForAddOnTariffVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelForAddOnTariffVO[] rsltRtListVerticalExcelForAddOnTariffVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String uploadRateExcelVerticalForAddOnTariff(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO,
			RsltRtListVerticalExcelForAddOnTariffVO[] rsltRtListVerticalExcelForAddOnTariffVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Load된 엑셀 데이터가 올바른지 Check한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelForAddOnTariffVO[] rsltRtListHorizontalExcelForAddOnTariffVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelHorizontalForAddOnTariff(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO,
			RsltRtListHorizontalExcelForAddOnTariffVO[] rsltRtListHorizontalExcelForAddOnTariffVOs) throws EventException;

	/**
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelForAddOnTariffVO[] rsltRtListHorizontalExcelForAddOnTariffVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String uploadRateExcelHorizontalForAddOnTariff(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO,
			RsltRtListHorizontalExcelForAddOnTariffVO[] rsltRtListHorizontalExcelForAddOnTariffVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelForAddOnTariffVO[] rsltRtListHorizontalExcelForAddOnTariffVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelHorizontalOnlineForAddOnTariff(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO,
			RsltRtListHorizontalExcelForAddOnTariffVO[] rsltRtListHorizontalExcelForAddOnTariffVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Route 및 Rate 데이터의 멀티 트랜잭션을 처리한다.<br>
	 * 
	 * @param RfaRtPropRtVO rfaRtPropRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateForAddOnTariff(RfaRtPropRtVO rfaRtPropRtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Rate 데이터에 GRI Calculation을 적용합니다.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @param CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void applyGRICalculationForAddOnTariff(PriRpScpGriGrpVO priRpScpGriGrpVO, CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs, SignOnUserAccount account)
			throws EventException;

	/**
	 * Rate 데이터에 GRI Calculation을 취조.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @param CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGRICalculationForAddOnTariff(PriRpScpGriGrpVO priRpScpGriGrpVO, CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs,
			SignOnUserAccount account) throws EventException;
	
	/**
	 * Rate 데이터에 GRI Calculation Validation 처리.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @param SignOnUserAccount account
	 * @return List<CheckGRICalculationValidationVO>
	 * @exception EventException
	 */
	public List<CheckGRICalculationValidationVO> checkGRICalculationValidationForAddOnTariff(PriRpScpGriGrpVO priRpScpGriGrpVO, SignOnUserAccount account) throws EventException;	
	
	/**
	 * RFA Type이 Contract 일때, actual customer check<br>
	 * 
	 * @param PriRpScpRtActCustVO priRpScpRtActCustVO
	 * @return List<PriRpScpRtActCustVO>
	 * @exception EventException
	 */
	public List<PriRpScpRtActCustVO> checkActualCustomer(PriRpScpRtActCustVO priRpScpRtActCustVO) throws EventException;
	
	/**
	 * Calculate 후, 지역별  컨테이너 장비 상태 조회<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<PriRpScpRtRoutPntVO>
	 * @exception EventException
	 */
	public List<PriRpScpRtRoutPntVO> checkRouteTermMissing(PriRpMnVO priRpMnVO) throws EventException;

	/**
	 * Rate의 Route Detail에 해당하는 모든 Origin/Dest의 장비상태 <br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param String orgDestTpCd
	 * @param String cntrTpszCd
	 * @return List<RsltRtRouteMBListVO> 
	 * @exception EventException
	 */
	public List<RsltRtRouteMBListVO> searchRateRouteMBList(PriRpScpRtVO priRpScpRtVO, String orgDestTpCd, String cntrTpszCd) throws EventException;

	/**
	 * Origin/Dest 선택 시 장비 타입 사이즈 별 상태 리스트 조회 이벤트 처리<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param String orgDestTpCd
	 * @param String fcntrEccCd
	 * @return List<RsltRtRouteMBListVO> 
	 * @exception EventException
	 */
	public List<RsltRtRouteMBListVO> searchRatePortMBList(PriRpScpRtVO priRpScpRtVO, String orgDestTpCd, String fcntrEccCd) throws EventException;

	/**
	 * Rate M/B 조회 시 플래그 변경 이벤트 처리<br>
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPrsMBFlgOnChangeStatus(PriRpScpRtVO priRpScpRtVO, SignOnUserAccount account) throws EventException;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Basic 시 Rate내의 모든항목을 Accept 처리한다.<br>
	 * RFA 효율화를 위한 요청 (1차) (CHM-201640671) <br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllRateBasic(PriRpScpRtVO priRpScpRtVO, SignOnUserAccount account) throws EventException;

	/**
	 * Master RFA의 Route Note Conversion 데이터를 Accept한다.<br>
	 * RFA 효율화를 위한 요청 (1차) (CHM-201640671) <br>
	 * 
	 * @param PriRfaNoteConvListVO[] priRfaNoteConvListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateCommodityRnoteConv(PriRfaNoteConvListVO[] priRfaNoteConvListVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Master RFA의 Route Note Conversion 데이터를 Accept Cancel한다.<br>
	 * RFA 효율화를 위한 요청 (1차) (CHM-201640671) <br>
	 * 
	 * @param PriRfaNoteConvListVO[] priRfaNoteConvListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateCommodityRnoteConv(PriRfaNoteConvListVO[] priRfaNoteConvListVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Basic RFA가 상속한 Master RFA의 Route Summary를 조회한다.<br>
	 * isExists가 Y일경우 Basic이 가지고 있는 Route를 N일경우 Basic이 없는 Route를 조회한다.<br> 
	 * (CHM-201642287) <br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @param String mstRfaNo 
	 * @param String isExists
	 * @return List<RsltRoutHdrSmryListVO>
	 * @exception EventException
	 */
	public List<RsltRoutHdrSmryListVO> searchMstRouteSummaryList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO, String mstRfaNo, String isExists) throws EventException;

	/**
	 * Basic Amend Request를 처리합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param RsltRoutHdrSmryListVO amdBasicVo 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposalBasic(PriRpMnVO priRpMnVO, RsltRoutHdrSmryListVO amdBasicVo, SignOnUserAccount account) throws EventException;
	
	
	
	
    /**
   * Basic RFA에서 amend를 통해 추가적으로 Master RFA Proposal Rate 정보를 Copy 합니다.<br>
   * 
   * @param RsltRfaPropCopyVO vo
   * @param RsltRoutHdrSmryListVO[] rsltRoutHdrSmryListVOs
   * @param SignOnUserAccount account
   * @param String rfaTypeCode
   * @exception EventException
   */
	public void copyAmendProposalScopeRateMst(RsltRfaPropCopyVO vo, RsltRoutHdrSmryListVO[] rsltRoutHdrSmryListVOs, SignOnUserAccount account) throws EventException ;

}
