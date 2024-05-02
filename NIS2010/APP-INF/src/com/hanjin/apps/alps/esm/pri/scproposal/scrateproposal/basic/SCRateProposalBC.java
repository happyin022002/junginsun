/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCRateProposalBC.java
 *@FileTitle : Rate Proposal
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.20
 *@LastModifier : 문동규
 *@LastVersion : 1.0
 * 2009.04.20 문동규
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PrsBatchVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.profitabilitysimulation.vo.InpPrsSurchargeDetailApplicableRouteVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.ScPropMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.InCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.PriSpScpRtCmdtRoutSetVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltAllRtListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriAmdCmViewAllVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriAmdCmpbOpbViewAllVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriCheckSurchargeNoteListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriCostDetailByTransModeListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriPrsCostDetailVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriPrsCostListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriRateCmViewAllVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriRateCmpbViewAllListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriSurchargeAdjustCommodityDetailVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriSurchargeAdjustCommodityVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriSurchargeAdjustListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriSurchargeAdjustLocationGroupDetailVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriSurchargeAdjustLocationGroupVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriSurchargeLastAccessDateVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPriSurchargeViewAllVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltPrsSurchargeDetailListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRateTpVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRouteCaseCostVersionVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRtCmdtListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRtCmdtRoutListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRtListHorizontalExcelVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRtListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRtListVerticalExcelVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.RsltRtRoutHdrListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.ScGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.ScRtPropCmdtVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.ScRtPropRtVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.ViewAllRatesListPagingVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.vo.ViewAllRatesListVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriPrsBatVO;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpGriGrpVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpRtActCustVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtHdrVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtRnoteVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtRoutVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCmdtVO;
import com.hanjin.syscommon.common.table.PriSpScpRtCnoteVO;
import com.hanjin.syscommon.common.table.PriSpScpRtRoutDirVO;
import com.hanjin.syscommon.common.table.PriSpScpRtRoutPntVO;
import com.hanjin.syscommon.common.table.PriSpScpRtRoutViaVO;
import com.hanjin.syscommon.common.table.PriSpScpRtScgVO;
import com.hanjin.syscommon.common.table.PriSpScpRtUsdRoutCsVO;
import com.hanjin.syscommon.common.table.PriSpScpRtVO;
import com.hanjin.syscommon.common.table.PriSpScpScgAdjVO;
 

/**
 * NIS2010-Scguideline Business Logic Command Interface<br>
 * - NIS2010-Scguideline에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Moon Dong Gyu
 * @see Ui_pri_0030EventResponse 참조
 * @since J2EE 1.4
 */

public interface SCRateProposalBC {
	/**
	 * Rate Type radio button스타일 처리를 위한 조회를 처리합니다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return List<RsltRateTpVO>
	 * @exception EventException
	 */
	public List<RsltRateTpVO> searchRateType(PriSpScpRtVO priSpScpRtVO) throws EventException;
	
	/**
	 * CUD트랜잭션 처리 후, 화면표시를 위한 스타일정보 조회<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @param PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO
	 * @return RsltRtCmdtRoutListVO
	 * @exception EventException
	 */
	public RsltRtCmdtRoutListVO searchRateCmdtRoutStyle(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO) throws EventException;

	/**
	 * Rate의 Commodity Group을 조회합니다.<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws EventException;
	
	/**
	 * Rate Inquiry - Commodity Group을 조회한다.<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityInquiryList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws EventException;
	
	/**
	 * Rate History - Commodity Group을 조회한다.
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @param String isConv
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityHistoryList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, String isConv) throws EventException;
	
	/**
	 * Rate의 Route 정보를 조회합니다.<br>
	 * 
	 * @param PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception EventException
	 */
	public List<RsltRtRoutHdrListVO> searchRateRouteList(PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO) throws EventException;

	/**
	 * Rate Inquiry - Route 리스트를 조회한다.<br>
	 * 
	 * @param PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception EventException
	 */
	public List<RsltRtRoutHdrListVO> searchRateRouteInquiryList(PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO) throws EventException;

	/**
	 * Rate History - Route 리스트를 조회한다.
	 * 
	 * @param PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO
	 * @param String isConv
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception EventException
	 */
	public List<RsltRtRoutHdrListVO> searchRateRouteHistoryList(PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO, String isConv) throws EventException;

	/**
	 * Rate의 Rate 관련정보를 조회합니다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return RsltRtListVO
	 * @exception EventException
	 */
	public RsltRtListVO searchRateList(PriSpScpRtVO priSpScpRtVO) throws EventException;

	/**
	 * Rate Inquiry - Rate 정보를 조회한다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @return RsltRtListVO
	 * @exception EventException
	 */
	public RsltRtListVO searchRateInquiryList(PriSpScpRtVO priSpScpRtVO) throws EventException;

	/**
	 * Excel Download(Vertical)를 위한 조회를 실행한다.<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return List<RsltRtListVerticalExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListVerticalExcelVO> searchRateListVerticalExcel(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Excel Download(Horizontal)를 위한 조회를 실행한다.<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return List<RsltRtListHorizontalExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListHorizontalExcelVO> searchRateListHorizontalExcel(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Accept All 화면의 리스트를 조회한다.<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return List<RsltAllRtListVO>
	 * @exception EventException
	 */
	public List<RsltAllRtListVO> searchAllRateList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Rate Commodity Group의 최종 Bullet NO.를 조회합니다.<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return String
	 * @exception EventException
	 */
	public String getMaxOldBulletDispSeq(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws EventException;

	/**
	 * Commodity Group 및 관련 정보의 멀티 트랜잭션을 처리한다.<br>
	 * 
	 * @param ScRtPropCmdtVO scRtPropCmdtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateCommodity(ScRtPropCmdtVO scRtPropCmdtVO, SignOnUserAccount account) throws EventException;

	/**
	 * Route 및 Rate 데이터의 멀티 트랜잭션을 처리한다.<br>
	 * 
	 * @param ScRtPropRtVO scRtPropRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRate(ScRtPropRtVO scRtPropRtVO, SignOnUserAccount account) throws EventException;

	/**
	 * Actual Customer 데이터를 Accept합니다.<br>
	 * 
	 * @param PriSpScpRtActCustVO[] priSpScpRtActCustVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptActualCustomer(PriSpScpRtActCustVO[] priSpScpRtActCustVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Actual Customer 데이터를 Accept Cancel합니다.<br>
	 * 
	 * @param PriSpScpRtActCustVO[] priSpScpRtActCustVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelActualCustomer(PriSpScpRtActCustVO[] priSpScpRtActCustVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Rate 데이터를 Accept한다.<br>
	 * 
	 * @param PriSpScpRtVO[] priSpScpRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRate(PriSpScpRtVO[] priSpScpRtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Rate 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param PriSpScpRtVO[] priSpScpRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRate(PriSpScpRtVO[] priSpScpRtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Commodity Note 데이터를 Accept한다.<br>
	 * 
	 * @param PriSpScpRtCnoteVO[] priSpScpRtCnoteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateCnote(PriSpScpRtCnoteVO[] priSpScpRtCnoteVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Commodity Note 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param PriSpScpRtCnoteVO[] priSpScpRtCnoteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateCnote(PriSpScpRtCnoteVO[] priSpScpRtCnoteVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Commodity 데이터를 Accept한다.<br>
	 * 
	 * @param PriSpScpRtCmdtVO[] priSpScpRtCmdtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateCommodityDetail(PriSpScpRtCmdtVO[] priSpScpRtCmdtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Commodity 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param PriSpScpRtCmdtVO[] priSpScpRtCmdtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateCommodityDetail(PriSpScpRtCmdtVO[] priSpScpRtCmdtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Route Note 데이터를 Accept한다.<br>
	 * 
	 * @param PriSpScpRtCmdtRnoteVO[] priSpScpRtCmdtRnoteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateCommodityRnote(PriSpScpRtCmdtRnoteVO[] priSpScpRtCmdtRnoteVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Route Note 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param PriSpScpRtCmdtRnoteVO[] priSpScpRtCmdtRnoteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateCommodityRnote(PriSpScpRtCmdtRnoteVO[] priSpScpRtCmdtRnoteVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Direct Call 데이터를 Accept한다.<br>
	 * 
	 * @param PriSpScpRtRoutDirVO[] priSpScpRtRoutDirVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateRouteDirCallDetail(PriSpScpRtRoutDirVO[] priSpScpRtRoutDirVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Direct Call 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param PriSpScpRtRoutDirVO[] priSpScpRtRoutDirVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateRouteDirCallDetail(PriSpScpRtRoutDirVO[] priSpScpRtRoutDirVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Route Point 데이터를 Accept한다.<br>
	 * 
	 * @param PriSpScpRtRoutPntVO[] priSpScpRtRoutPntVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateRoutePointDetail(PriSpScpRtRoutPntVO[] priSpScpRtRoutPntVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Route Point 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param PriSpScpRtRoutPntVO[] priSpScpRtRoutPntVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateRoutePointDetail(PriSpScpRtRoutPntVO[] priSpScpRtRoutPntVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * ScrateProposal 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param PriSpScpRtRoutViaVO[] priSpScpRtRoutViaVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateRouteViaDetail(PriSpScpRtRoutViaVO[] priSpScpRtRoutViaVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * ScrateProposal 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param PriSpScpRtRoutViaVO[] priSpScpRtRoutViaVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateRouteViaDetail(PriSpScpRtRoutViaVO[] priSpScpRtRoutViaVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Rate의 모든 항목을 Accept한다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllRate(PriSpScpRtVO priSpScpRtVO, SignOnUserAccount account) throws EventException;

	/**
	 * Rate의 모든 항목을 Accept Cancel한다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllRate(PriSpScpRtVO priSpScpRtVO, SignOnUserAccount account) throws EventException;

	/**
	 * Guideline의 데이터를 복사해온다.<br>
	 * 
	 * @param ScGlineCopyVO scGlineCopyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineRate(ScGlineCopyVO scGlineCopyVO, SignOnUserAccount account) throws EventException;

	/**
	 * Guideline Copy전 Group Location, Group Commodity가 존재하는지 확인한다.<br>
	 * 
	 * @param ScGlineCopyVO scGlineCopyVO
	 * @return RsltCdListVO
	 * @exception EventException
	 */
	public RsltCdListVO checkGlineCopyGroupCodeExist(ScGlineCopyVO scGlineCopyVO) throws EventException;

	/**
	 * Amend Request를 처리합니다.<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * S/C Proposal Scope Rate 를 Copy 합니다.<br>
	 * 
	 * @param RsltPropCopyVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyProposalScopeRate(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * Rate 데이터에 GRI Calculation을 적용합니다.<br>
	 * 
	 * @param PriSpScpGriGrpVO priSpScpGriGrpVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void applyGRICalculation(PriSpScpGriGrpVO priSpScpGriGrpVO, SignOnUserAccount account) throws EventException;

	/**
	 * 적용한 GRI Calculation을 취소합니다.<br>
	 * 
	 * @param PriSpScpGriGrpVO priSpScpGriGrpVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGRICalculation(PriSpScpGriGrpVO priSpScpGriGrpVO, SignOnUserAccount account) throws EventException;

	/**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @exception EventException
	 */
	public void removeProposalMain(PriSpScpMnVO priSpScpMnVO) throws EventException;

	/**
	 * S/C Proposal을 Request 할때 자동으로 Accept를 합니다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateDirectCall(PriSpScpRtVO priSpScpRtVO, SignOnUserAccount account) throws EventException;

	/**
	 * S/C Proposal을 Request Cancel 할때 자동으로 Accept Cancel 합니다.<br>
	 * 
	 * @param PriSpScpRtVO priSpScpRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateDirectCall(PriSpScpRtVO priSpScpRtVO, SignOnUserAccount account) throws EventException;

	/**
	 * Guideline Rate 를 Proposal 에 Copy 합니다.<br>
	 * 
	 * @param SpScpGlineCopyVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyScopeGuidelineRate(SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * PRS- Applicable Route, Surcharge Detail을 조회 처리합니다.<br>
	 * 
	 * @param InpPrsSurchargeDetailApplicableRouteVO inpPrsSurchargeDetailApplicableRouteVO
	 * @return RsltPrsSurchargeDetailListVO
	 * @exception EventException
	 */
	public RsltPrsSurchargeDetailListVO searchRateSurchargeList(InpPrsSurchargeDetailApplicableRouteVO inpPrsSurchargeDetailApplicableRouteVO)
			throws EventException;

	/**
	 * PRS- Surcharge Detail 내용을 추가,삭제,갱신처리 합니다.<br>
	 * 
	 * @param PriSpScpRtScgVO[] priSpScpRtScgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateSurcharge(PriSpScpRtScgVO[] priSpScpRtScgVOs, SignOnUserAccount account)
			throws EventException;

	/**
	 * PRS- Surcharge Adjust을 조회합니다.<br>
	 * 
	 * @param RsltPriSurchargeAdjustListVO schPriSurchargeAdjustListVO
	 * @return List<RsltPriSurchargeAdjustListVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustListVO> searchSurchargeAdjustList(
			RsltPriSurchargeAdjustListVO schPriSurchargeAdjustListVO) throws EventException;

	/**
	 * PRS- Surcharge Adjust 내용을 추가,삭제,갱신처리 합니다.<br>
	 * 
	 * @param PriSpScpScgAdjVO[] priSpScpScgAdjVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSurchargeAdjust(PriSpScpScgAdjVO[] priSpScpScgAdjVO, SignOnUserAccount account)
			throws EventException;

	
	/**
	 * PRS- Surcharge Adjust 내용을 바탕으로 calc 로직을 수행 합니다.<br>
	 * 
	 * @param PriSpScpScgAdjVO priSpScpScgAdjVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSurchargeAdjustCalc(PriSpScpScgAdjVO priSpScpScgAdjVO, SignOnUserAccount account)
	throws EventException;

	
	/**
	 * PRS- Surcharge Adjust 내용을 추가,삭제,갱신처리 합니다.<br>
	 * 
	 * @param RsltPriSurchargeAdjustCommodityVO rsltPriSurchargeAdjustCommodityVO
	 * @return List<RsltPriSurchargeAdjustCommodityVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustCommodityVO> searchRateCommodityAllList(
			RsltPriSurchargeAdjustCommodityVO rsltPriSurchargeAdjustCommodityVO) throws EventException;

	/**
	 * Surcharge Adjust-Commodity group에 대한 상세 내용을 조회합니다.<br>
	 * 
	 * @param RsltPriSurchargeAdjustCommodityDetailVO rsltPriSurchargeAdjustCommodityVO
	 * @return List<RsltPriSurchargeAdjustCommodityDetailVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustCommodityDetailVO> searchRateGroupCommodityDetailList(
			RsltPriSurchargeAdjustCommodityDetailVO rsltPriSurchargeAdjustCommodityVO) throws EventException;

	/**
	 * Surcharge Adjust-Location Group을 조회 합니다.<br>
	 * 
	 * @param RsltPriSurchargeAdjustLocationGroupVO rsltPriSurchargeAdjustLocationGroupVO
	 * @return List<RsltPriSurchargeAdjustLocationGroupVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustLocationGroupVO> searchRateLocationAllList(
			RsltPriSurchargeAdjustLocationGroupVO rsltPriSurchargeAdjustLocationGroupVO) throws EventException;

	/**
	 * Surcharge Adjust-Location Group에 상세 정보를 조회 합니다.<br>
	 * 
	 * @param RsltPriSurchargeAdjustLocationGroupDetailVO rsltPriSurchargeAdjustLocationGroupVO
	 * @return List<RsltPriSurchargeAdjustLocationGroupDetailVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustLocationGroupDetailVO> searchRateGroupLocationDetailList(
			RsltPriSurchargeAdjustLocationGroupDetailVO rsltPriSurchargeAdjustLocationGroupVO) throws EventException;

	/**
	 * Request Cancel시  Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Request Cancel시  Direct Call Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void manageProposalRequestCancelDirectCall(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException;	

	/**
	 * PRS- Cost Detail 조회 처리<br>
	 * PRS- Cost Detail List 확인 리스트 조회 이벤트 처리<br>
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @return List<RsltPriPrsCostListVO>
	 * @exception EventException
	 */
	public List<RsltPriPrsCostListVO> searchCostDetailList(RsltPriPrsCostListVO rsltPriPrsCostListVO)
			throws EventException;

	/**
	 * PRS- Cost Detail 조회 처리<br>
	 * PRS- Cost Detail List 확인 리스트 조회 이벤트 처리<br>
	 * 
	 * @param RsltPriPrsCostDetailVO rsltPriPrsCostDetailVO
	 * @return List<RsltPriPrsCostDetailVO>
	 * @exception EventException
	 */
	public List<RsltPriPrsCostDetailVO> searchCostDetailInquiryList(RsltPriPrsCostDetailVO rsltPriPrsCostDetailVO)
			throws EventException;

	
	/**
	 * CM/OP View 내용을 조회 합니다.<br>
	 *  
	 * @param RsltPriRateCmViewAllVO rsltPriRateCmViewAllVO
	 * @return List<RsltPriRateCmViewAllVO>
	 * @exception EventException
	 */
	public List<RsltPriRateCmViewAllVO> searchRateCmViewAllList(RsltPriRateCmViewAllVO rsltPriRateCmViewAllVO) throws EventException ;
	/**
	 * CM/OP View 의 load 값을  갱신처리 합니다.<BR>
	 * 
	 * @param PriSpScpRtCmdtRoutSetVO priSpScpRtCmdtRoutSetVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPrsPfmc(PriSpScpRtCmdtRoutSetVO priSpScpRtCmdtRoutSetVO, SignOnUserAccount account) throws EventException;

	/**
	 * S/C Amendment CM/OP View 내용을 조회 합니다.<br>
	 *  
	 * @param RsltPriAmdCmViewAllVO rsltPriAmdCmViewAllVO
	 * @return List<RsltPriAmdCmViewAllVO>
	 * @exception EventException
	 */
	public List<RsltPriAmdCmViewAllVO> searchAmdtRateCmViewAllList(RsltPriAmdCmViewAllVO rsltPriAmdCmViewAllVO) throws EventException ;
	
	/**
	 * CM/OP화면의 CMPB/OPB를 1건 조회한다..<br>
	 *  
	 * @param RsltPriAmdCmViewAllVO rsltPriAmdCmViewAllVO
	 * @return RsltPriAmdCmpbOpbViewAllVO
	 * @exception EventException
	 */
	public RsltPriAmdCmpbOpbViewAllVO searchAmdtRateCmpbAndOpbViewAll(RsltPriAmdCmViewAllVO rsltPriAmdCmViewAllVO) throws EventException ;

	
	
	/**
	 * S/C Amendment CM/OP View 의 load값을 갱신처리 합니다.
	 * 
	 * @param PriSpScpRtCmdtRoutSetVO priSpScpRtCmdtRoutSetVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAmdtPrsPfmc(PriSpScpRtCmdtRoutSetVO priSpScpRtCmdtRoutSetVO, SignOnUserAccount account) throws EventException;
	
	
 
	/**
	 * Load된 엑셀 데이터가 올바른지 Check한다.<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelVertical(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs) throws EventException;

	/**
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String uploadRateExcelVertical(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelVerticalOnline(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Load된 엑셀 데이터가 올바른지 Check한다.<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelHorizontal(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs) throws EventException;

	/**
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String uploadRateExcelHorizontal(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelHorizontalOnline(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Trans.Mode에 따른 Cost 상세정보를 조회 합니다.<br>
	 *  
	 * @param RsltPriCostDetailByTransModeListVO rsltPriCostDetailByTransModeListVO
	 * @return List<RsltPriCostDetailByTransModeListVO>
	 * @exception EventException
	 */
	public List<RsltPriCostDetailByTransModeListVO> searchCostDetailByTransModeList(RsltPriCostDetailByTransModeListVO rsltPriCostDetailByTransModeListVO) throws EventException ;

	
	/**
	 * S/C Proposal/Amendment CMPB 또는 OPB 를 조회 합니다.<br>
	 *  
	 * @param RsltPriRateCmpbViewAllListVO rsltPriRateCmpbViewAllListVO
	 * @return List<RsltPriRateCmpbViewAllListVO>
	 * @exception EventException
	 */
	public List<RsltPriRateCmpbViewAllListVO> searchRateCmpbViewAllList(RsltPriRateCmpbViewAllListVO rsltPriRateCmpbViewAllListVO) throws EventException ;

	/**
	 * ScrateProposal View All Rate를 페이징 조회한다.<br>
	 * 
	 * @param ViewAllRatesListPagingVO viewAllRatesListPagingVO
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchViewAllRatesListPaging(ViewAllRatesListPagingVO viewAllRatesListPagingVO) throws EventException;	
	
	/**
	 * ScrateProposal View All Rate를 조회한다.<br>
	 * 
	 * @param ViewAllRatesListVO viewAllRatesListVO
	 * @return List<ViewAllRatesListVO>
	 * @exception EventException
	 */
	public List<ViewAllRatesListVO> searchViewAllRatesList(ViewAllRatesListVO viewAllRatesListVO) throws EventException;

	/**
	 * RRATE관련 Cost, CMPB,OPB 값을 갱신하고 그 갱신여부를 Mark해둔다.
	 * 
	 * @param RsltPriPrsCostListVO[] rsltPriPrsCostListVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPrsCost(RsltPriPrsCostListVO[] rsltPriPrsCostListVOS, SignOnUserAccount account) throws EventException;

 
	
	/**
	 * Calculate Batch를 비동기 적으로 실행킨다.<br>
	 * 
	 * @param PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO
	 * @param String rotationPrsBatId
	 * @param SignOnUserAccount account
	 * @return PriPrsBatVO
	 * @exception EventException
	 */
	public PriPrsBatVO executeCalculate(PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO,String rotationPrsBatId,SignOnUserAccount account) throws EventException ;
	
	/**
	 * Calculate Batch의 상태 조회.<br>
	 * 
	 * @param PrsBatchVO prsBatchVO
	 * @return String
	 * @exception EventException
	 */
	public String monitorCalculate(PrsBatchVO prsBatchVO) throws EventException ;
	
	/**
	 * COPY TO PROPOSAL RATE<br>
	 * 
	 * @param RsltCopyToProposalVO rsltCopyToProposalVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyToProposalRate(RsltCopyToProposalVO rsltCopyToProposalVO, SignOnUserAccount account) 
		throws EventException;
	
	/**
	 * PRS- Surcharge Adjust 팝업을 띄이기 전 해당 surcharge에 대해 note가 존재하는지 체크합니다.<br>
	 * 
	 * @param RsltPriCheckSurchargeNoteListVO rsltPriCheckSurchargeNoteListVO
	 * @return List<RsltPriCheckSurchargeNoteListVO>
	 * @exception EventException
	 */
	public List<RsltPriCheckSurchargeNoteListVO> searchCheckSurchargeNoteList(
			RsltPriCheckSurchargeNoteListVO rsltPriCheckSurchargeNoteListVO) throws EventException;
	
	/**
	 * Calculate Batch ID를 조회 하기 위한 Parameter를 조합한다.<br>
	 * 
	 * @param PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO
	 * @return PriPrsBatVO
	 * @exception EventException
	 */
	public PriPrsBatVO searchMonitorCalculateParam(PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO ) throws EventException ;
	
	/**
	 * Route Case No 의 Max +1 값을 조회한다..<br>
	 * 
	 * @param RsltRouteCaseCostVersionVO rsltRouteCaseCostVersionVO
	 * @return RsltNewRoutCaseNoVO
	 * @exception EventException
	 */
//	public RsltNewRoutCaseNoVO searchNewRouteCaseNo(RsltRouteCaseCostVersionVO rsltRouteCaseCostVersionVO ) throws EventException ;
	
	/**
	 * Rate Route Case를 추가 한다. .<br>
	 * 
	 * @param PriSpScpRtUsdRoutCsVO priSpScpRtUsdRoutCsVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriRateUsedRouteCase(PriSpScpRtUsdRoutCsVO priSpScpRtUsdRoutCsVO, SignOnUserAccount account) throws EventException;
	
	
	/**
	 * Route의 선택여부를 Mark해둔다..<BR>
	 * 
	 * @param List<RsltPriPrsCostListVO> rsltPriPrsCostListVO
	 * @exception EventException
	 */
	public void modifyPrsRateCommodityRoute(List<RsltPriPrsCostListVO>  rsltPriPrsCostListVO) throws EventException;
	
	
	/**
	 * Calculate Logic을 이용해 data를 갱신한다..<BR>
	 * 
	 * @param List<RsltPriPrsCostListVO> rsltPriPrsCostListVO
	 * @exception EventException
	 */
	public void modifyCalculateLogicData(List<RsltPriPrsCostListVO>  rsltPriPrsCostListVO) throws EventException;
	
	
 


	
	/**
	 * 현재 사용해야 할 PARA_INFO_CTNT(ROUT_CS_SRC_DT)  , PRS_BAT_ID(ROUT_CS_CLSS_NO)를 SELECT한다.<br>
	 * 
	 * @return RsltRouteCaseCostVersionVO
	 * @exception EventException
	 */
	public RsltRouteCaseCostVersionVO searchRouteCaseCostVersion( ) throws EventException;
	
	/**
	 * Calculate Logic 중 Surcharge 재 계산 부분만을 분리 해 놓았다. <BR>
	 * 왜냐하면 Batch Program에서도 이 부분을 공유 하기 때문이다.
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @exception EventException
	 */
	public void addPriSpScpRtScgCostDetail(RsltPriPrsCostListVO  rsltPriPrsCostListVO) throws EventException;
		
	/**
	 * COST CM/OP PRE SIMULATION 화면에서 ROUTE정보를 조회 한다.<br>
	 * 
	 * @param InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO
	 * @return List<RsltPriCostSimulationCheckRouteVO>
	 * @exception EventException
	 */
	public List<RsltPriCostSimulationCheckRouteVO> searchCostSimulationCheckRoutList(
			InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO) throws EventException ;
	
    /**
     * Conversion Update 시 Amend Seq.를 기준으로 다음 Amend Seq의 Note 유형을 수정한다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account 
     * @exception EventException
     */
    public void manageConversionUpdate (PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException ; 	
    
	/**
	 * S/C Proposal - Rate Tab의 Surcharge View All Popup의 내용을 조회를 처리합니다.<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return List<RsltPriSurchargeViewAllVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeViewAllVO> searchSurchargeViewAllList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws EventException ;
	

	/**
	 * S/C Proposal - Rate Tab의 Surcharge View All Popup에서 Surcharge 값이 언제 만들어 졌는지를 조회 처리합니다.<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @return List<RsltPriSurchargeLastAccessDateVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeLastAccessDateVO> searchSurchargeLastAccessDateList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws EventException;
	
	
	/**
	 *  Surcharge 정보를 삭제 합니다.<br>
	 * 
	 * @param ScPropMnVO scPropMnVO
	 * @exception EventException
	 */
	public void manageProposalScopeSurchargeRemove(ScPropMnVO scPropMnVO) throws EventException;		
}