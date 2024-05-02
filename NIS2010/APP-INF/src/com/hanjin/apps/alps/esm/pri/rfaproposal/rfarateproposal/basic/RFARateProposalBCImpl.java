/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFARateProposalBCImpl.java
 *@FileTitle : RFARateProposalBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.10.04
 *@LastModifier : 송호진
 *@LastVersion : 1.0
 * 2009.08.20 박성수
 * 1.0 Creation
=========================================================
 * History
 * 2010.10.04 송호진 CHM-201006291-01 - [긴급 요청사항] Session 정보 관련 getCre_usr_id - getUsr_id 로 교체
 * 2013.12.20 서미진 [CHM-201328281] RFA에 계약 구분인자 추가 (C : Contract, S : Spot)
 * 2014.03.11 서미진 [CHM-201429293] Route 중에 term이 빠진 Location check
 * 2015.04.22 전지예 [CHM-201535165] RFA match back 팝업화면 추가
 * 2015.11.26 SELCMU/김현경 [CHM-201538236] RFA module 승인 절차 간소화 및 기능 개선
 * 2016.05.03 RFA 효율화를 위한 요청 (1차) (CHM-201640671)
 * 2016.07.20 [CHM-201642287] Master RFA Cancel시 Basic RFA 점검 로직 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.CompareToBuilder;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PrsBatchVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.profitabilitysimulation.vo.InpPrsSurchargeDetailApplicableRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.vo.PriRfaNoteConvListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfanoteconversionproposal.vo.RsltNoteConvVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.basic.RFAProposalMainBC;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.basic.RFAProposalMainBCImpl;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropMnVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.integration.RFARateProposalDBDAO;
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
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltFicRateByRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriAmdCmViewAllVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriAmdCmpbOpbViewAllVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriCostDetailByTransModeListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriCostSimulationCheckRouteVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriPrsCostDetailVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriPrsCostListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriRateCmViewAllVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriRateCmpbViewAllListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriRpMnCalcVO;
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
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriPrsBatVO;
import com.hanjin.syscommon.common.table.PriRfaNoteConvVO;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpAmdtSmryVO;
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
import com.hanjin.syscommon.common.util.ScheduleUtil;

/**
 * NIS2010-SCGuideline Business Logic Basic Command implementation<br>
 * - NIS2010-SCGuideline에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Sungsoo, Park
 * @see UI_PRI_0030EventResponse,SCRateGuidelineBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class RFARateProposalBCImpl extends BasicCommandSupport implements RFARateProposalBC {

	// Database Access Object
	private transient RFARateProposalDBDAO dbDao = null;

	/**
	 * RFARateProposalBCImpl 객체 생성<br>
	 * RFARateProposalDBDAO를 생성한다.<br>
	 */
	public RFARateProposalBCImpl() {
		dbDao = new RFARateProposalDBDAO();
	}

	/**
	 * CUD트랜잭션 처리 후, 화면표시를 위한 스타일정보 조회<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return RsltRtCmdtRoutListVO
	 * @exception EventException
	 */
	public RsltRtCmdtRoutListVO searchRateCmdtRoutStyle(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws EventException {
		RsltRtCmdtRoutListVO rVo = new RsltRtCmdtRoutListVO();

		try {
			rVo.setRsltRtCmdtHdrListVOS(dbDao.searchRateCommodityHeaderStyleList(priRpScpRtCmdtHdrVO));
			rVo.setRsltRtRoutHdrListVOS(dbDao.searchRateRouteStyleList(priRpScpRtCmdtRoutVO));

			return rVo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Rate의 Route Detail에 해당하는 모든 Origin/Dest의 장비상태<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param String orgDestTpCd
	 * @param String cntrTpszCd
	 * @return List<RsltRtRouteMBListVO> 
	 * @exception EventException
	 */
	public List<RsltRtRouteMBListVO> searchRateRouteMBList(PriRpScpRtVO priRpScpRtVO, String orgDestTpCd, String cntrTpszCd) throws EventException {
		try {
			return dbDao.searchRateRouteMBList(priRpScpRtVO, orgDestTpCd, cntrTpszCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Origin/Dest 선택 시 장비 타입 사이즈 별 상태 리스트 조회 이벤트 처리<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param String orgDestTpCd
	 * @param String fcntrEccCd
	 * @return List<RsltRtRouteMBListVO> 
	 * @exception EventException
	 */
	public List<RsltRtRouteMBListVO> searchRatePortMBList(PriRpScpRtVO priRpScpRtVO, String orgDestTpCd, String fcntrEccCd) throws EventException {
		try {
			return dbDao.searchRatePortMBList(priRpScpRtVO, orgDestTpCd, fcntrEccCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Rate M/B 조회 시 플래그 변경 이벤트 처리<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPrsMBFlgOnChangeStatus(PriRpScpRtVO priRpScpRtVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.modifyPrsMBFlgOnChangeStatus(priRpScpRtVO, account.getUsr_id());
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Rate의 Commodity Group을 조회합니다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		RsltRtCmdtListVO rVo = new RsltRtCmdtListVO();

		try {
			rVo.setRsltRtCmdtHdrListVOS(dbDao.searchRateCommodityHeaderList(priRpScpRtCmdtHdrVO));
			rVo.setRsltRtCmdtDtlListVOS(dbDao.searchRateCommodityDetailList(priRpScpRtCmdtHdrVO));
			rVo.setRsltActCustListVOS(dbDao.searchActualCustomerList(priRpScpRtCmdtHdrVO));
			rVo.setRsltRtCnoteListVOS(dbDao.searchRateCnoteList(priRpScpRtCmdtHdrVO));
			rVo.setRsltCnoteNoteConvListVOS(dbDao.searchRateCnoteNoteConvList(priRpScpRtCmdtHdrVO));

			return rVo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Master RFA의 Commodity를 조회합니다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchMstRateCommodityList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		RsltRtCmdtListVO rVo = new RsltRtCmdtListVO();

		try {
			rVo.setRsltRtCmdtHdrListVOS(dbDao.searchRateCommodityHeaderList(priRpScpRtCmdtHdrVO));
			rVo.setRsltRtCmdtDtlListVOS(dbDao.searchRateCommodityDetailList(priRpScpRtCmdtHdrVO));
			
			return rVo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Rate Inquiry - Commodity Group을 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityInquiryList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		RsltRtCmdtListVO rVo = new RsltRtCmdtListVO();

		try {
			rVo.setRsltRtCmdtHdrListVOS(dbDao.searchRateCommodityHeaderInquiryList(priRpScpRtCmdtHdrVO));
			rVo.setRsltRtCmdtDtlListVOS(dbDao.searchRateCommodityDetailInquiryList(priRpScpRtCmdtHdrVO));
			rVo.setRsltActCustListVOS(dbDao.searchActualCustomerInquiryList(priRpScpRtCmdtHdrVO));
			rVo.setRsltRtCnoteListVOS(dbDao.searchRateCnoteInquiryList(priRpScpRtCmdtHdrVO));
			rVo.setRsltCnoteNoteConvListVOS(dbDao.searchRateCnoteNoteConvList(priRpScpRtCmdtHdrVO));

			return rVo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Rate History - Commodity Group을 조회한다.
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return RsltRtCmdtListVO
	 * @exception EventException
	 */
	public RsltRtCmdtListVO searchRateCommodityHistoryList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		RsltRtCmdtListVO rVo = new RsltRtCmdtListVO();

		try {
			rVo.setRsltRtCmdtHdrListVOS(dbDao.searchRateCommodityHeaderHistoryList(priRpScpRtCmdtHdrVO));
			rVo.setRsltRtCmdtDtlListVOS(dbDao.searchRateCommodityDetailList(priRpScpRtCmdtHdrVO));
			rVo.setRsltActCustListVOS(dbDao.searchActualCustomerList(priRpScpRtCmdtHdrVO));
			rVo.setRsltRtCnoteListVOS(dbDao.searchRateCnoteList(priRpScpRtCmdtHdrVO));
			rVo.setRsltCnoteNoteConvListVOS(dbDao.searchRateCnoteNoteConvList(priRpScpRtCmdtHdrVO));

			return rVo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Rate의 Route 정보를 조회합니다.<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception EventException
	 */
	public List<RsltRtRoutHdrListVO> searchRateRouteList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws EventException {
		try {
			return dbDao.searchRateRouteList(priRpScpRtCmdtRoutVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Master RFA의 Route & Summary 정보를 조회합니다.<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return List<RsltRoutHdrSmryListVO>
	 * @exception EventException
	 */
	public List<RsltRoutHdrSmryListVO> searchRouteSummaryList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws EventException {
		try {
			return dbDao.searchRouteSummaryList(priRpScpRtCmdtRoutVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Rate Inquiry - Route 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrInquiryListVO>
	 * @exception EventException
	 */
	public List<RsltRtRoutHdrInquiryListVO> searchRateRouteInquiryList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws EventException {
		try {
			return dbDao.searchRateRouteInquiryList(priRpScpRtCmdtRoutVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Rate History - Route 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return List<RsltRtRoutHdrListVO>
	 * @exception EventException
	 */
	public List<RsltRtRoutHdrListVO> searchRateRouteHistoryList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws EventException {
		try {
			return dbDao.searchRateRouteHistoryList(priRpScpRtCmdtRoutVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Rate 정보를 조회한다.
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param boolean addOnFlag
	 * @return RsltRtListVO
	 * @exception EventException
	 */
	public RsltRtListVO searchRateList(PriRpScpRtVO priRpScpRtVO, boolean addOnFlag) throws EventException {
		RsltRtListVO rVo = new RsltRtListVO();
		try {
			Map<String, List<RsltFicRateByRouteVO>> route = new HashMap<String, List<RsltFicRateByRouteVO>>();
			rVo.setRsltRtDtlListVOS(dbDao.searchRateDetailList(priRpScpRtVO));
			rVo.setRsltRtRoutOrgPntListVOS(dbDao.searchRateRouteOriginPointList(priRpScpRtVO, addOnFlag));
			rVo.setRsltRtRoutOrgViaListVOS(dbDao.searchRateRouteOriginViaList(priRpScpRtVO));
			rVo.setRsltRtRoutDestViaListVOS(dbDao.searchRateRouteDestinationViaList(priRpScpRtVO));
			rVo.setRsltRtRoutDestPntListVOS(dbDao.searchRateRouteDestinationPointList(priRpScpRtVO, addOnFlag));
			rVo.setRsltRtCmdtRnoteListVOS(dbDao.searchRateCommodityRnoteList(priRpScpRtVO));
			rVo.setRsltRnoteNoteConvListVOS(dbDao.searchRateCommodityRnoteNoteConvList(priRpScpRtVO));

			if (addOnFlag) {
				route.put("O", dbDao.searchAddOnIhcRateList(priRpScpRtVO, addOnFlag, "O"));
				route.put("D", dbDao.searchAddOnIhcRateList(priRpScpRtVO, addOnFlag, "D"));
			} else {
				route.put("X", dbDao.searchAddOnIhcRateList(priRpScpRtVO, addOnFlag, null));
			}
			rVo.setRsltFicRateByRouteVO(route);

			return rVo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Rate 정보를 조회한다.
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param boolean addOnFlag
	 * @return RsltRtListVO
	 * @exception EventException
	 */
	public RsltRtListVO searchMstRateList(PriRpScpRtVO priRpScpRtVO, boolean addOnFlag) throws EventException {
		RsltRtListVO rVo = new RsltRtListVO();
		try {
			Map<String, List<RsltFicRateByRouteVO>> route = new HashMap<String, List<RsltFicRateByRouteVO>>();
			rVo.setRsltRtDtlListVOS(dbDao.searchRateDetailList(priRpScpRtVO));
			rVo.setRsltRtRoutOrgPntListVOS(dbDao.searchRateRouteOriginPointList(priRpScpRtVO, addOnFlag));
			rVo.setRsltRtRoutOrgViaListVOS(dbDao.searchRateRouteOriginViaList(priRpScpRtVO));
			rVo.setRsltRtRoutDestViaListVOS(dbDao.searchRateRouteDestinationViaList(priRpScpRtVO));
			rVo.setRsltRtRoutDestPntListVOS(dbDao.searchRateRouteDestinationPointList(priRpScpRtVO, addOnFlag));
			rVo.setRsltRtCmdtRnoteListVOS(dbDao.searchRateCommodityRnoteList(priRpScpRtVO));
			rVo.setRsltRnoteNoteConvListVOS(dbDao.searchMstRateCommodityRnoteNoteConvList(priRpScpRtVO));
			
			route.put("X", dbDao.searchAddOnIhcRateList(priRpScpRtVO, addOnFlag, null));
			rVo.setRsltFicRateByRouteVO(route);

			return rVo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Rate Inquiry - Rate 정보를 조회한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return RsltRtListVO
	 * @exception EventException
	 */
	public RsltRtListVO searchRateInquiryList(PriRpScpRtVO priRpScpRtVO) throws EventException {
		RsltRtListVO rVo = new RsltRtListVO();
		try {
			rVo.setRsltRtDtlListVOS(dbDao.searchRateDetailInquiryList(priRpScpRtVO));
			rVo.setRsltRtRoutOrgPntListVOS(dbDao.searchRateRouteOriginPointInquiryList(priRpScpRtVO));
			rVo.setRsltRtRoutOrgViaListVOS(dbDao.searchRateRouteOriginViaInquiryList(priRpScpRtVO));
			rVo.setRsltRtRoutDestViaListVOS(dbDao.searchRateRouteDestinationViaInquiryList(priRpScpRtVO));
			rVo.setRsltRtRoutDestPntListVOS(dbDao.searchRateRouteDestinationPointInquiryList(priRpScpRtVO));
			rVo.setRsltRtCmdtRnoteListVOS(dbDao.searchRateCommodityRnoteInquiryList(priRpScpRtVO));
			rVo.setRsltRnoteNoteConvListVOS(dbDao.searchRateCommodityRnoteNoteConvList(priRpScpRtVO));

			return rVo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Excel Download(Vertical)를 위한 조회를 실행한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtListVerticalExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListVerticalExcelVO> searchRateListVerticalExcel(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchRateListVerticalExcel(priRpScpRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Excel Download(Horizontal)를 위한 조회를 실행한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtListHorizontalExcelVO>
	 * @exception EventException
	 */
	public List<RsltRtListHorizontalExcelVO> searchRateListHorizontalExcel(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchRateListHorizontalExcel(priRpScpRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Check Duplicate화면 - 중복된 Rate 리스트를 조회합니다. <br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtCheckDuplicateVO>/
	 * @exception EventException
	 */
	public List<RsltRtCheckDuplicateVO> searchRateCheckDuplicate(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchRateCheckDuplicate(priRpScpRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Accept All 화면의 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltAllRtListVO>
	 * @exception EventException
	 */
	public List<RsltAllRtListVO> searchAllRateList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchAllRateList(priRpScpRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Accept All 화면의 리스트를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltAllRtListVO>
	 * @exception EventException
	 */
	public List<RsltAllRtListVO> searchAllSpotRateList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchAllSpotRateList(priRpScpRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Rate의 Commodity의 마지막 Bullet No. 값을 조회합니다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return String
	 * @exception EventException
	 */
	public String getMaxOldBulletDispSeq(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchMaxOldBulletDispSeq(priRpScpRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Commodity Group 및 관련 정보의 멀티 트랜잭션을 처리한다.<br>
	 * 
	 * @param RfaRtPropCmdtVO rfaRtPropCmdtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateCommodity(RfaRtPropCmdtVO rfaRtPropCmdtVO, SignOnUserAccount account) throws EventException {
		try {
			PriRpScpRtCmdtHdrVO[] vo = rfaRtPropCmdtVO.getPriRpScpRtCmdtHdrVOS();
			PriRpScpRtCmdtVO[] dtlvo = rfaRtPropCmdtVO.getPriRpScpRtCmdtVOS();
			PriRpScpRtActCustVO[] custvo = rfaRtPropCmdtVO.getPriRpScpRtActCustVOS();
			PriRpScpRtCnoteVO[] cnotevo = rfaRtPropCmdtVO.getPriRpScpRtCnoteVOS();
			PriRfaNoteConvListVO[] convvo = rfaRtPropCmdtVO.getPriRfaNoteConvListVOS();

			List<PriRpScpRtCmdtHdrVO> insertVoList = new ArrayList<PriRpScpRtCmdtHdrVO>();
			List<PriRpScpRtCmdtHdrVO> updateVoList = new ArrayList<PriRpScpRtCmdtHdrVO>();
			List<PriRpScpRtCmdtHdrVO> deleteVoList = new ArrayList<PriRpScpRtCmdtHdrVO>();
			List<PriRpScpRtCmdtVO> insertDtlVoList = new ArrayList<PriRpScpRtCmdtVO>();
			List<PriRpScpRtCmdtVO> updateDtlVoList = new ArrayList<PriRpScpRtCmdtVO>();
			List<PriRpScpRtCmdtVO> deleteDtlVoList = new ArrayList<PriRpScpRtCmdtVO>();
			List<PriRpScpRtActCustVO> insertCustVoList = new ArrayList<PriRpScpRtActCustVO>();
			List<PriRpScpRtActCustVO> updateCustVoList = new ArrayList<PriRpScpRtActCustVO>();
			List<PriRpScpRtActCustVO> deleteCustVoList = new ArrayList<PriRpScpRtActCustVO>();
			List<PriRpScpRtCnoteVO> insertCnoteVoList = new ArrayList<PriRpScpRtCnoteVO>();
			List<PriRpScpRtCnoteVO> updateCnoteVoList = new ArrayList<PriRpScpRtCnoteVO>();
			List<PriRpScpRtCnoteVO> deleteCnoteVoList = new ArrayList<PriRpScpRtCnoteVO>();
			List<PriRfaNoteConvListVO> insertConvVoList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> updateConvVoList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> deleteConvVoList = new ArrayList<PriRfaNoteConvListVO>();

			for (int i = 0; vo != null && i < vo.length; i++) {
				if (vo[i].getIbflag().equals("I")) {
					vo[i].setCreUsrId(account.getUsr_id());
					vo[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(vo[i]);
				} else if (vo[i].getIbflag().equals("U")) {
					vo[i].setUpdUsrId(account.getUsr_id());
					if ("-1".equals(vo[i].getN1stCmncAmdtSeq())) {
						vo[i].setN1stCmncAmdtSeq(vo[i].getAmdtSeq());
						deleteVoList.add(vo[i]);
					} else {
						updateVoList.add(vo[i]);
					}
				} else if (vo[i].getIbflag().equals("D")) {
					vo[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(vo[i]);
				}
			}
			for (int i = 0; dtlvo != null && i < dtlvo.length; i++) {
				if (dtlvo[i].getIbflag().equals("I")) {
					dtlvo[i].setCreUsrId(account.getUsr_id());
					dtlvo[i].setUpdUsrId(account.getUsr_id());
					insertDtlVoList.add(dtlvo[i]);
				} else if (dtlvo[i].getIbflag().equals("U")) {
					dtlvo[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(dtlvo[i]);
				} else if (dtlvo[i].getIbflag().equals("D")) {
					deleteDtlVoList.add(dtlvo[i]);
				}
			}
			for (int i = 0; custvo != null && i < custvo.length; i++) {
				if (custvo[i].getIbflag().equals("I")) {
					custvo[i].setCreUsrId(account.getUsr_id());
					custvo[i].setUpdUsrId(account.getUsr_id());
					insertCustVoList.add(custvo[i]);
				} else if (custvo[i].getIbflag().equals("U")) {
					custvo[i].setUpdUsrId(account.getUsr_id());
					updateCustVoList.add(custvo[i]);
				} else if (custvo[i].getIbflag().equals("D")) {
					deleteCustVoList.add(custvo[i]);
				}
			}
			for (int i = 0; cnotevo != null && i < cnotevo.length; i++) {
				if (cnotevo[i].getIbflag().equals("I")) {
					cnotevo[i].setCreUsrId(account.getUsr_id());
					cnotevo[i].setUpdUsrId(account.getUsr_id());
					insertCnoteVoList.add(cnotevo[i]);
				} else if (cnotevo[i].getIbflag().equals("U")) {
					cnotevo[i].setUpdUsrId(account.getUsr_id());
					updateCnoteVoList.add(cnotevo[i]);
				} else if (cnotevo[i].getIbflag().equals("D")) {
					deleteCnoteVoList.add(cnotevo[i]);
				}
			}
			for (int i = 0; convvo != null && i < convvo.length; i++) {
				if (convvo[i].getIbflag().equals("I")) {
					convvo[i].setCreUsrId(account.getUsr_id());
					convvo[i].setUpdUsrId(account.getUsr_id());
					insertConvVoList.add(convvo[i]);
				} else if (convvo[i].getIbflag().equals("U")) {
					convvo[i].setUpdUsrId(account.getUsr_id());
					updateConvVoList.add(convvo[i]);
				} else if (convvo[i].getIbflag().equals("D")) {
					deleteConvVoList.add(convvo[i]);
				}
			}

			if (insertVoList.size() > 0) {
				dbDao.addRateCommodityHeader(insertVoList);
			}
			if (insertDtlVoList.size() > 0) {
				dbDao.addRateCommodity(insertDtlVoList);
			}
			if (insertCustVoList.size() > 0) {
				dbDao.addRateActualCustomer(insertCustVoList);
			}
			if (insertCnoteVoList.size() > 0) {
				dbDao.addRateCnote(insertCnoteVoList);
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateCommodityHeader(updateVoList, "N");
			}
			if (updateDtlVoList.size() > 0) {
				dbDao.modifyRateCommodity(updateDtlVoList, "N");
			}
			if (updateCustVoList.size() > 0) {
				dbDao.modifyRateActualCustomer(updateCustVoList, "N");
			}
			if (updateCnoteVoList.size() > 0) {
				dbDao.modifyRateCnote(updateCnoteVoList, "N");
			}

			if (deleteCnoteVoList.size() > 0) {
				dbDao.removeRateCnote(deleteCnoteVoList);
			}
			if (deleteCustVoList.size() > 0) {
				dbDao.removeRateActualCustomer(deleteCustVoList);
			}
			if (deleteDtlVoList.size() > 0) {
				dbDao.removeRateCommodity(deleteDtlVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeRateCommodityHeaderCascadeScg(deleteVoList);
				dbDao.removeRateCommodityHeaderCascadeScgRout(deleteVoList);
				dbDao.removeRateCommodityHeaderCascadeUsdRoutCs(deleteVoList);
				dbDao.removeRateCommodityHeaderCascadeCgoSpec(deleteVoList);
				dbDao.removeRateCommodityHeaderCascadeRt(deleteVoList);
				dbDao.removeRateCommodityHeaderCascadeRnote(deleteVoList);
				dbDao.removeRateCommodityHeaderCascadeRoutVia(deleteVoList);
				dbDao.removeRateCommodityHeaderCascadeRoutPnt(deleteVoList);
				dbDao.removeRateCommodityHeaderCascadeCmdtRout(deleteVoList);
				dbDao.removeRateCommodityHeaderCascadeCnote(deleteVoList);
				dbDao.removeRateCommodityHeaderCascadeActCust(deleteVoList);
				dbDao.removeRateCommodityHeaderCascadeCmdt(deleteVoList);
				dbDao.removeRateCommodityHeader(deleteVoList);

				dbDao.removeRateCommodityHeaderDelAmendRt(deleteVoList);
				dbDao.removeRateCommodityHeaderDelAmendRnote(deleteVoList);
				dbDao.removeRateCommodityHeaderDelAmendRoutVia(deleteVoList);
				dbDao.removeRateCommodityHeaderDelAmendRoutPnt(deleteVoList);
				dbDao.removeRateCommodityHeaderDelAmendCnote(deleteVoList);
				dbDao.removeRateCommodityHeaderDelAmendActCust(deleteVoList);
				dbDao.removeRateCommodityHeaderDelAmendCmdt(deleteVoList);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Route 및 Rate 데이터의 멀티 트랜잭션을 처리한다.<br>
	 * 
	 * @param RfaRtPropRtVO rfaRtPropRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRate(RfaRtPropRtVO rfaRtPropRtVO, SignOnUserAccount account) throws EventException {
		try {
			PriRpScpRtCmdtRoutVO noteSeqVO = rfaRtPropRtVO.getPriRpScpRtCmdtRoutVO();
			PriRpScpRtCmdtRoutVO[] routvo = rfaRtPropRtVO.getPriRpScpRtCmdtRoutVOS();
			PriRpScpRtRoutPntVO[] orgpntvo = rfaRtPropRtVO.getPriRpScpRtRoutOrgPntVOS();
			PriRpScpRtRoutViaVO[] orgviavo = rfaRtPropRtVO.getPriRpScpRtRoutOrgViaVOS();
			PriRpScpRtRoutViaVO[] destviavo = rfaRtPropRtVO.getPriRpScpRtRoutDestViaVOS();
			PriRpScpRtRoutPntVO[] destpntvo = rfaRtPropRtVO.getPriRpScpRtRoutDestPntVOS();
			PriRpScpRtCmdtRnoteVO[] rnotevo = rfaRtPropRtVO.getPriRpScpRtCmdtRnoteVOS();
			PriRfaNoteConvListVO[] convvo = rfaRtPropRtVO.getPriRfaNoteConvListVOS();
			PriRpScpRtVO[] rtvo = rfaRtPropRtVO.getPriRpScpRtVOS();

			List<PriRpScpRtCmdtRoutVO> insertRoutList = new ArrayList<PriRpScpRtCmdtRoutVO>();
			List<PriRpScpRtCmdtRoutVO> updateRoutList = new ArrayList<PriRpScpRtCmdtRoutVO>();
			List<PriRpScpRtCmdtRoutVO> deleteRoutList = new ArrayList<PriRpScpRtCmdtRoutVO>();
			List<PriRpScpRtRoutPntVO> insertPntList = new ArrayList<PriRpScpRtRoutPntVO>();
			List<PriRpScpRtRoutPntVO> updatePntList = new ArrayList<PriRpScpRtRoutPntVO>();
			List<PriRpScpRtRoutPntVO> deletePntList = new ArrayList<PriRpScpRtRoutPntVO>();
			List<PriRpScpRtRoutViaVO> insertViaList = new ArrayList<PriRpScpRtRoutViaVO>();
			List<PriRpScpRtRoutViaVO> updateViaList = new ArrayList<PriRpScpRtRoutViaVO>();
			List<PriRpScpRtRoutViaVO> deleteViaList = new ArrayList<PriRpScpRtRoutViaVO>();
			List<PriRpScpRtCmdtRnoteVO> insertRnoteList = new ArrayList<PriRpScpRtCmdtRnoteVO>();
			List<PriRpScpRtCmdtRnoteVO> updateRnoteList = new ArrayList<PriRpScpRtCmdtRnoteVO>();
			List<PriRpScpRtCmdtRnoteVO> deleteRnoteList = new ArrayList<PriRpScpRtCmdtRnoteVO>();
			List<PriRfaNoteConvListVO> insertConvList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> updateConvList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> deleteConvList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRpScpRtVO> insertRtList = new ArrayList<PriRpScpRtVO>();
			List<PriRpScpRtVO> updateRtList = new ArrayList<PriRpScpRtVO>();
			List<PriRpScpRtVO> deleteRtList = new ArrayList<PriRpScpRtVO>();
			List<PriRpScpRtVO> amendCancelRtList = new ArrayList<PriRpScpRtVO>();

			for (int i = 0; routvo != null && i < routvo.length; i++) {
				if (routvo[i].getIbflag().equals("I")) {
					routvo[i].setCreUsrId(account.getUsr_id());
					routvo[i].setUpdUsrId(account.getUsr_id());
					insertRoutList.add(routvo[i]);
				} else if (routvo[i].getIbflag().equals("U")) {
					routvo[i].setUpdUsrId(account.getUsr_id());
					if ("-1".equals(routvo[i].getN1stCmncAmdtSeq())) {
						routvo[i].setN1stCmncAmdtSeq(routvo[i].getAmdtSeq());
						deleteRoutList.add(routvo[i]);
					} else {
						updateRoutList.add(routvo[i]);
					}
				} else if (routvo[i].getIbflag().equals("D")) {
					routvo[i].setUpdUsrId(account.getUsr_id());
					deleteRoutList.add(routvo[i]);
				}
			}
			for (int i = 0; orgpntvo != null && i < orgpntvo.length; i++) {
				if (orgpntvo[i].getIbflag().equals("I")) {
					orgpntvo[i].setCreUsrId(account.getUsr_id());
					orgpntvo[i].setUpdUsrId(account.getUsr_id());
					insertPntList.add(orgpntvo[i]);
				} else if (orgpntvo[i].getIbflag().equals("U")) {
					orgpntvo[i].setUpdUsrId(account.getUsr_id());
					updatePntList.add(orgpntvo[i]);
				} else if (orgpntvo[i].getIbflag().equals("D")) {
					deletePntList.add(orgpntvo[i]);
				}
			}
			for (int i = 0; orgviavo != null && i < orgviavo.length; i++) {
				if (orgviavo[i].getIbflag().equals("I")) {
					orgviavo[i].setCreUsrId(account.getUsr_id());
					orgviavo[i].setUpdUsrId(account.getUsr_id());
					insertViaList.add(orgviavo[i]);
				} else if (orgviavo[i].getIbflag().equals("U")) {
					orgviavo[i].setUpdUsrId(account.getUsr_id());
					updateViaList.add(orgviavo[i]);
				} else if (orgviavo[i].getIbflag().equals("D")) {
					deleteViaList.add(orgviavo[i]);
				}
			}
			for (int i = 0; destviavo != null && i < destviavo.length; i++) {
				if (destviavo[i].getIbflag().equals("I")) {
					destviavo[i].setCreUsrId(account.getUsr_id());
					destviavo[i].setUpdUsrId(account.getUsr_id());
					insertViaList.add(destviavo[i]);
				} else if (destviavo[i].getIbflag().equals("U")) {
					destviavo[i].setUpdUsrId(account.getUsr_id());
					updateViaList.add(destviavo[i]);
				} else if (destviavo[i].getIbflag().equals("D")) {
					deleteViaList.add(destviavo[i]);
				}
			}
			for (int i = 0; destpntvo != null && i < destpntvo.length; i++) {
				if (destpntvo[i].getIbflag().equals("I")) {
					destpntvo[i].setCreUsrId(account.getUsr_id());
					destpntvo[i].setUpdUsrId(account.getUsr_id());
					insertPntList.add(destpntvo[i]);
				} else if (destpntvo[i].getIbflag().equals("U")) {
					destpntvo[i].setUpdUsrId(account.getUsr_id());
					updatePntList.add(destpntvo[i]);
				} else if (destpntvo[i].getIbflag().equals("D")) {
					deletePntList.add(destpntvo[i]);
				}
			}
			for (int i = 0; rnotevo != null && i < rnotevo.length; i++) {
				if (rnotevo[i].getIbflag().equals("I")) {
					rnotevo[i].setCreUsrId(account.getUsr_id());
					rnotevo[i].setUpdUsrId(account.getUsr_id());
					insertRnoteList.add(rnotevo[i]);
				} else if (rnotevo[i].getIbflag().equals("U")) {
					rnotevo[i].setUpdUsrId(account.getUsr_id());
					updateRnoteList.add(rnotevo[i]);
				} else if (rnotevo[i].getIbflag().equals("D")) {
					deleteRnoteList.add(rnotevo[i]);
				}
			}
			for (int i = 0; convvo != null && i < convvo.length; i++) {
				if (convvo[i].getIbflag().equals("I")) {
					convvo[i].setCreUsrId(account.getUsr_id());
					convvo[i].setUpdUsrId(account.getUsr_id());
					insertConvList.add(convvo[i]);
				} else if (convvo[i].getIbflag().equals("U")) {
					convvo[i].setUpdUsrId(account.getUsr_id());
					updateConvList.add(convvo[i]);
				} else if (convvo[i].getIbflag().equals("D")) {
					deleteConvList.add(convvo[i]);
				}
			}
			for (int i = 0; rtvo != null && i < rtvo.length; i++) {
				if (rtvo[i].getIbflag().equals("I")) {
					rtvo[i].setCreUsrId(account.getUsr_id());
					rtvo[i].setUpdUsrId(account.getUsr_id());
					insertRtList.add(rtvo[i]);
				} else if (rtvo[i].getIbflag().equals("U")) {
					rtvo[i].setUpdUsrId(account.getUsr_id());
					updateRtList.add(rtvo[i]);

					if ("0".equals(rtvo[i].getAmdtSeq())) {
						continue;
					}
					if (!rtvo[i].getAmdtSeq().equals(rtvo[i].getN1stCmncAmdtSeq())) {
						rtvo[i].setCreUsrId(account.getUsr_id());
						rtvo[i].setUpdUsrId(account.getUsr_id());
						amendCancelRtList.add(rtvo[i]);
					}
				} else if (rtvo[i].getIbflag().equals("D")) {
					deleteRtList.add(rtvo[i]);
				}
			}

			if (insertRoutList.size() > 0) {
				dbDao.addRateCommodityRoute(insertRoutList);
			}
			if (insertPntList.size() > 0) {
				dbDao.addRateRoutePoint(insertPntList);
			}
			if (insertViaList.size() > 0) {
				dbDao.addRateRouteVia(insertViaList);
			}
			if (insertRnoteList.size() > 0) {
				dbDao.addRateCommodityRnote(insertRnoteList);
			}
			if (insertRtList.size() > 0) {
				dbDao.addRate(insertRtList);
			}

			if (updateRoutList.size() > 0) {
				dbDao.modifyRateCommodityRoute(updateRoutList, "N");
			}
			if (updatePntList.size() > 0) {
				dbDao.modifyRateRoutePoint(updatePntList, "N");
			}
			if (updateViaList.size() > 0) {
				dbDao.modifyRateRouteVia(updateViaList, "N");
			}
			if (updateRnoteList.size() > 0) {
				dbDao.modifyRateCommodityRnote(updateRnoteList, "N");
			}
			if (updateRtList.size() > 0) {
				dbDao.modifyRate(updateRtList, "N");
			}
			if (amendCancelRtList.size() > 0) {
				dbDao.removeRateCascadeScg(amendCancelRtList);
				dbDao.removeRateCascadeScgRout(amendCancelRtList);
				dbDao.removeRateCascadeUsdRoutCs(amendCancelRtList);

				dbDao.addCopyRateSurchargeAmendCancel(amendCancelRtList);
				dbDao.addCopyRateSurchargeRouteAmendCancel(amendCancelRtList);
				dbDao.addCopyRateUsdRouteCsAmendCancel(amendCancelRtList);
			}

			if (deleteRtList.size() > 0) {
				dbDao.removeRateCascadeScg(deleteRtList);
				dbDao.removeRateCascadeScgRout(deleteRtList);
				dbDao.removeRateCascadeUsdRoutCs(deleteRtList);
				dbDao.removeRateCascadeCgoSpec(deleteRtList);
				dbDao.removeRate(deleteRtList);
			}
			if (deleteRnoteList.size() > 0) {
				dbDao.removeRateCommodityRnote(deleteRnoteList);
			}
			if (deleteViaList.size() > 0) {
				dbDao.removeRateRouteVia(deleteViaList);
			}
			if (deletePntList.size() > 0) {
				dbDao.removeRateRoutePoint(deletePntList);
			}
			if (deleteRoutList.size() > 0) {
				dbDao.removeRateCommodityRouteCascadeScg(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeScgRout(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeUsdRoutCs(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeCgoSpec(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeRt(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeRnote(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeRoutVia(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeRoutPnt(deleteRoutList);
				dbDao.removeRateCommodityRoute(deleteRoutList);

				dbDao.removeRateCommodityRouteDelAmendRt(deleteRoutList);
				dbDao.removeRateCommodityRouteDelAmendRnote(deleteRoutList);
				dbDao.removeRateCommodityRouteDelAmendRoutVia(deleteRoutList);
				dbDao.removeRateCommodityRouteDelAmendRoutPnt(deleteRoutList);
			}

			dbDao.modifyRouteNoteDispSeq(noteSeqVO, "1");

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Master RFA에서 Route 및 Rate 데이터의 멀티 트랜잭션을 처리한다.<br>
	 * 
	 * @param RfaRtPropRtVO rfaRtPropRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateMst(RfaRtPropRtVO rfaRtPropRtVO, SignOnUserAccount account) throws EventException {
		try {
			PriRpScpRtCmdtRoutVO noteSeqVO = rfaRtPropRtVO.getPriRpScpRtCmdtRoutVO();
			PriRpScpRtCmdtRoutVO[] routvo = rfaRtPropRtVO.getPriRpScpRtCmdtRoutVOS();
			PriRpScpRtRoutPntVO[] orgpntvo = rfaRtPropRtVO.getPriRpScpRtRoutOrgPntVOS();
			PriRpScpRtRoutViaVO[] orgviavo = rfaRtPropRtVO.getPriRpScpRtRoutOrgViaVOS();
			PriRpScpRtRoutViaVO[] destviavo = rfaRtPropRtVO.getPriRpScpRtRoutDestViaVOS();
			PriRpScpRtRoutPntVO[] destpntvo = rfaRtPropRtVO.getPriRpScpRtRoutDestPntVOS();
			PriRpScpRtCmdtRnoteVO[] rnotevo = rfaRtPropRtVO.getPriRpScpRtCmdtRnoteVOS();
			PriRfaNoteConvListVO[] convvo = rfaRtPropRtVO.getPriRfaNoteConvListVOS();
			PriRpScpRtVO[] rtvo = rfaRtPropRtVO.getPriRpScpRtVOS();

			List<PriRpScpRtCmdtRoutVO> insertRoutList = new ArrayList<PriRpScpRtCmdtRoutVO>();
			List<PriRpScpRtCmdtRoutVO> updateRoutList = new ArrayList<PriRpScpRtCmdtRoutVO>();
			List<PriRpScpRtCmdtRoutVO> deleteRoutList = new ArrayList<PriRpScpRtCmdtRoutVO>();
			List<PriRpScpRtRoutPntVO> insertPntList = new ArrayList<PriRpScpRtRoutPntVO>();
			List<PriRpScpRtRoutPntVO> updatePntList = new ArrayList<PriRpScpRtRoutPntVO>();
			List<PriRpScpRtRoutPntVO> deletePntList = new ArrayList<PriRpScpRtRoutPntVO>();
			List<PriRpScpRtRoutViaVO> insertViaList = new ArrayList<PriRpScpRtRoutViaVO>();
			List<PriRpScpRtRoutViaVO> updateViaList = new ArrayList<PriRpScpRtRoutViaVO>();
			List<PriRpScpRtRoutViaVO> deleteViaList = new ArrayList<PriRpScpRtRoutViaVO>();
			List<PriRpScpRtCmdtRnoteVO> insertRnoteList = new ArrayList<PriRpScpRtCmdtRnoteVO>();
			List<PriRpScpRtCmdtRnoteVO> updateRnoteList = new ArrayList<PriRpScpRtCmdtRnoteVO>();
			List<PriRpScpRtCmdtRnoteVO> deleteRnoteList = new ArrayList<PriRpScpRtCmdtRnoteVO>();
			List<PriRfaNoteConvListVO> insertConvList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> updateConvList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> deleteConvList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRpScpRtVO> insertRtList = new ArrayList<PriRpScpRtVO>();
			List<PriRpScpRtVO> updateRtList = new ArrayList<PriRpScpRtVO>();
			List<PriRpScpRtVO> deleteRtList = new ArrayList<PriRpScpRtVO>();
			List<PriRpScpRtVO> amendCancelRtList = new ArrayList<PriRpScpRtVO>();

			for (int i = 0; routvo != null && i < routvo.length; i++) {
				if (routvo[i].getIbflag().equals("I")) {
					routvo[i].setCreUsrId(account.getUsr_id());
					routvo[i].setUpdUsrId(account.getUsr_id());
					insertRoutList.add(routvo[i]);
				} else if (routvo[i].getIbflag().equals("U")) {
					routvo[i].setUpdUsrId(account.getUsr_id());
					if ("-1".equals(routvo[i].getN1stCmncAmdtSeq())) {
						routvo[i].setN1stCmncAmdtSeq(routvo[i].getAmdtSeq());
						deleteRoutList.add(routvo[i]);
					} else {
						updateRoutList.add(routvo[i]);
					}
				} else if (routvo[i].getIbflag().equals("D")) {
					routvo[i].setUpdUsrId(account.getUsr_id());
					deleteRoutList.add(routvo[i]);
				}
			}
			for (int i = 0; orgpntvo != null && i < orgpntvo.length; i++) {
				if (orgpntvo[i].getIbflag().equals("I")) {
					orgpntvo[i].setCreUsrId(account.getUsr_id());
					orgpntvo[i].setUpdUsrId(account.getUsr_id());
					insertPntList.add(orgpntvo[i]);
				} else if (orgpntvo[i].getIbflag().equals("U")) {
					orgpntvo[i].setUpdUsrId(account.getUsr_id());
					updatePntList.add(orgpntvo[i]);
				} else if (orgpntvo[i].getIbflag().equals("D")) {
					deletePntList.add(orgpntvo[i]);
				}
			}
			for (int i = 0; orgviavo != null && i < orgviavo.length; i++) {
				if (orgviavo[i].getIbflag().equals("I")) {
					orgviavo[i].setCreUsrId(account.getUsr_id());
					orgviavo[i].setUpdUsrId(account.getUsr_id());
					insertViaList.add(orgviavo[i]);
				} else if (orgviavo[i].getIbflag().equals("U")) {
					orgviavo[i].setUpdUsrId(account.getUsr_id());
					updateViaList.add(orgviavo[i]);
				} else if (orgviavo[i].getIbflag().equals("D")) {
					deleteViaList.add(orgviavo[i]);
				}
			}
			for (int i = 0; destviavo != null && i < destviavo.length; i++) {
				if (destviavo[i].getIbflag().equals("I")) {
					destviavo[i].setCreUsrId(account.getUsr_id());
					destviavo[i].setUpdUsrId(account.getUsr_id());
					insertViaList.add(destviavo[i]);
				} else if (destviavo[i].getIbflag().equals("U")) {
					destviavo[i].setUpdUsrId(account.getUsr_id());
					updateViaList.add(destviavo[i]);
				} else if (destviavo[i].getIbflag().equals("D")) {
					deleteViaList.add(destviavo[i]);
				}
			}
			for (int i = 0; destpntvo != null && i < destpntvo.length; i++) {
				if (destpntvo[i].getIbflag().equals("I")) {
					destpntvo[i].setCreUsrId(account.getUsr_id());
					destpntvo[i].setUpdUsrId(account.getUsr_id());
					insertPntList.add(destpntvo[i]);
				} else if (destpntvo[i].getIbflag().equals("U")) {
					destpntvo[i].setUpdUsrId(account.getUsr_id());
					updatePntList.add(destpntvo[i]);
				} else if (destpntvo[i].getIbflag().equals("D")) {
					deletePntList.add(destpntvo[i]);
				}
			}
			for (int i = 0; rnotevo != null && i < rnotevo.length; i++) {
				if (rnotevo[i].getIbflag().equals("I")) {
					rnotevo[i].setCreUsrId(account.getUsr_id());
					rnotevo[i].setUpdUsrId(account.getUsr_id());
					insertRnoteList.add(rnotevo[i]);
				} else if (rnotevo[i].getIbflag().equals("U")) {
					rnotevo[i].setUpdUsrId(account.getUsr_id());
					updateRnoteList.add(rnotevo[i]);
				} else if (rnotevo[i].getIbflag().equals("D")) {
					deleteRnoteList.add(rnotevo[i]);
				}
			}
			for (int i = 0; convvo != null && i < convvo.length; i++) {
				if (convvo[i].getIbflag().equals("I")) {
					convvo[i].setCreUsrId(account.getUsr_id());
					convvo[i].setUpdUsrId(account.getUsr_id());
					insertConvList.add(convvo[i]);
				} else if (convvo[i].getIbflag().equals("U")) {
					convvo[i].setUpdUsrId(account.getUsr_id());
					updateConvList.add(convvo[i]);
				} else if (convvo[i].getIbflag().equals("D")) {
					deleteConvList.add(convvo[i]);
				}
			}
			for (int i = 0; rtvo != null && i < rtvo.length; i++) {
				if (rtvo[i].getIbflag().equals("I")) {
					rtvo[i].setCreUsrId(account.getUsr_id());
					rtvo[i].setUpdUsrId(account.getUsr_id());
					insertRtList.add(rtvo[i]);
				} else if (rtvo[i].getIbflag().equals("U")) {
					rtvo[i].setUpdUsrId(account.getUsr_id());
					updateRtList.add(rtvo[i]);

					if ("0".equals(rtvo[i].getAmdtSeq())) {
						continue;
					}
					if (!rtvo[i].getAmdtSeq().equals(rtvo[i].getN1stCmncAmdtSeq())) {
						rtvo[i].setCreUsrId(account.getUsr_id());
						rtvo[i].setUpdUsrId(account.getUsr_id());
						amendCancelRtList.add(rtvo[i]);
					}
				} else if (rtvo[i].getIbflag().equals("D")) {
					deleteRtList.add(rtvo[i]);
				}
			}

			if (insertRoutList.size() > 0) {
				dbDao.addRateCommodityRouteMst(insertRoutList);
			}
			if (insertPntList.size() > 0) {
				dbDao.addRateRoutePoint(insertPntList);
			}
			if (insertViaList.size() > 0) {
				dbDao.addRateRouteVia(insertViaList);
			}
			if (insertRnoteList.size() > 0) {
				dbDao.addRateCommodityRnote(insertRnoteList);
			}
			if (insertRtList.size() > 0) {
				dbDao.addRate(insertRtList);
			}

			if (updateRoutList.size() > 0) {
				dbDao.modifyRateCommodityRoute(updateRoutList, "N");
			}
			if (updatePntList.size() > 0) {
				dbDao.modifyRateRoutePoint(updatePntList, "N");
			}
			if (updateViaList.size() > 0) {
				dbDao.modifyRateRouteVia(updateViaList, "N");
			}
			if (updateRnoteList.size() > 0) {
				dbDao.modifyRateCommodityRnote(updateRnoteList, "N");
			}
			if (updateRtList.size() > 0) {
				dbDao.modifyRate(updateRtList, "N");
			}
			if (amendCancelRtList.size() > 0) {
				dbDao.removeRateCascadeScg(amendCancelRtList);
				dbDao.removeRateCascadeScgRout(amendCancelRtList);
				dbDao.removeRateCascadeUsdRoutCs(amendCancelRtList);

				dbDao.addCopyRateSurchargeAmendCancel(amendCancelRtList);
				dbDao.addCopyRateSurchargeRouteAmendCancel(amendCancelRtList);
				dbDao.addCopyRateUsdRouteCsAmendCancel(amendCancelRtList);
			}

			if (deleteRtList.size() > 0) {
				dbDao.removeRateCascadeScg(deleteRtList);
				dbDao.removeRateCascadeScgRout(deleteRtList);
				dbDao.removeRateCascadeUsdRoutCs(deleteRtList);
				dbDao.removeRateCascadeCgoSpec(deleteRtList);
				dbDao.removeRate(deleteRtList);
			}
			if (deleteRnoteList.size() > 0) {
				dbDao.removeRateCommodityRnote(deleteRnoteList);
			}
			if (deleteViaList.size() > 0) {
				dbDao.removeRateRouteVia(deleteViaList);
			}
			if (deletePntList.size() > 0) {
				dbDao.removeRateRoutePoint(deletePntList);
			}
			if (deleteRoutList.size() > 0) {
				dbDao.removeRateCommodityRouteCascadeScg(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeScgRout(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeUsdRoutCs(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeCgoSpec(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeRt(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeRnote(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeRoutVia(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeRoutPnt(deleteRoutList);
				dbDao.removeRateCommodityRoute(deleteRoutList);

				dbDao.removeRateCommodityRouteDelAmendRt(deleteRoutList);
				dbDao.removeRateCommodityRouteDelAmendRnote(deleteRoutList);
				dbDao.removeRateCommodityRouteDelAmendRoutVia(deleteRoutList);
				dbDao.removeRateCommodityRouteDelAmendRoutPnt(deleteRoutList);
			}

			dbDao.modifyRouteNoteDispSeq(noteSeqVO, "1");

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Actual Customer 데이터를 Accept합니다.<br>
	 * 
	 * @param PriRpScpRtActCustVO[] priRpScpRtActCustVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptActualCustomer(PriRpScpRtActCustVO[] priRpScpRtActCustVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtActCustVO> updateVoList = new ArrayList<PriRpScpRtActCustVO>();

			for (int i = 0; priRpScpRtActCustVOs != null && i < priRpScpRtActCustVOs.length; i++) {
				if (priRpScpRtActCustVOs[i].getIbflag().equals("U")) {
					priRpScpRtActCustVOs[i].setPrcProgStsCd("A");
					priRpScpRtActCustVOs[i].setAcptUsrId(account.getUsr_id());
					priRpScpRtActCustVOs[i].setAcptOfcCd(account.getOfc_cd());
					priRpScpRtActCustVOs[i].setAcptDt(com.hanjin.framework.component.util.DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd HH:mm:ss"));

					priRpScpRtActCustVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtActCustVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateActualCustomer(updateVoList, "Y");
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Actual Customer 데이터를 Accept Cancel합니다.<br>
	 * 
	 * @param PriRpScpRtActCustVO[] priRpScpRtActCustVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelActualCustomer(PriRpScpRtActCustVO[] priRpScpRtActCustVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtActCustVO> updateVoList = new ArrayList<PriRpScpRtActCustVO>();

			for (int i = 0; priRpScpRtActCustVOs != null && i < priRpScpRtActCustVOs.length; i++) {
				if (priRpScpRtActCustVOs[i].getIbflag().equals("U")) {
					priRpScpRtActCustVOs[i].setAcptUsrId(null);
					priRpScpRtActCustVOs[i].setAcptOfcCd(null);
					priRpScpRtActCustVOs[i].setAcptDt(null);

					priRpScpRtActCustVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtActCustVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateActualCustomer(updateVoList, "Y");
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Rate 데이터를 Accept한다.<br>
	 * 
	 * @param PriRpScpRtVO[] priRpScpRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRate(PriRpScpRtVO[] priRpScpRtVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtVO> updateVoList = new ArrayList<PriRpScpRtVO>();
			for (int i = 0; priRpScpRtVOs != null && i < priRpScpRtVOs.length; i++) {
				if (priRpScpRtVOs[i].getIbflag().equals("U")) {
					priRpScpRtVOs[i].setPrcProgStsCd("A");
					priRpScpRtVOs[i].setAcptUsrId(account.getUsr_id());
					priRpScpRtVOs[i].setAcptOfcCd(account.getOfc_cd());
					priRpScpRtVOs[i].setAcptDt(com.hanjin.framework.component.util.DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd HH:mm:ss"));

					priRpScpRtVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtVOs[i]);
				}
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyRate(updateVoList, "Y");
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Rate 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param PriRpScpRtVO[] priRpScpRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRate(PriRpScpRtVO[] priRpScpRtVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtVO> updateVoList = new ArrayList<PriRpScpRtVO>();
			for (int i = 0; priRpScpRtVOs != null && i < priRpScpRtVOs.length; i++) {
				if (priRpScpRtVOs[i].getIbflag().equals("U")) {
					priRpScpRtVOs[i].setAcptUsrId(null);
					priRpScpRtVOs[i].setAcptOfcCd(null);
					priRpScpRtVOs[i].setAcptDt(null);
					priRpScpRtVOs[i].setFicOrgFnlRtAmt(null);
					priRpScpRtVOs[i].setFicDestFnlRtAmt(null);
					priRpScpRtVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priRpScpRtVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRate(updateVoList, "Y");
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Commodity Note 데이터를 Accept한다.<br>
	 * 
	 * @param PriRpScpRtCnoteVO[] priRpScpRtCnoteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateCnote(PriRpScpRtCnoteVO[] priRpScpRtCnoteVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtCnoteVO> updateVoList = new ArrayList<PriRpScpRtCnoteVO>();

			for (int i = 0; priRpScpRtCnoteVOs != null && i < priRpScpRtCnoteVOs.length; i++) {
				if (priRpScpRtCnoteVOs[i].getIbflag().equals("U")) {
					priRpScpRtCnoteVOs[i].setPrcProgStsCd("A");
					priRpScpRtCnoteVOs[i].setAcptUsrId(account.getUsr_id());
					priRpScpRtCnoteVOs[i].setAcptOfcCd(account.getOfc_cd());
					priRpScpRtCnoteVOs[i].setAcptDt(com.hanjin.framework.component.util.DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd HH:mm:ss"));

					priRpScpRtCnoteVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtCnoteVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateCnote(updateVoList, "Y");
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Commodity Note 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param PriRpScpRtCnoteVO[] priRpScpRtCnoteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateCnote(PriRpScpRtCnoteVO[] priRpScpRtCnoteVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtCnoteVO> updateVoList = new ArrayList<PriRpScpRtCnoteVO>();

			for (int i = 0; priRpScpRtCnoteVOs != null && i < priRpScpRtCnoteVOs.length; i++) {
				if (priRpScpRtCnoteVOs[i].getIbflag().equals("U")) {
					priRpScpRtCnoteVOs[i].setAcptUsrId(null);
					priRpScpRtCnoteVOs[i].setAcptOfcCd(null);
					priRpScpRtCnoteVOs[i].setAcptDt(null);

					priRpScpRtCnoteVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtCnoteVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateCnote(updateVoList, "Y");
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Commodity 데이터를 Accept한다.<br>
	 * 
	 * @param PriRpScpRtCmdtVO[] priRpScpRtCmdtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateCommodityDetail(PriRpScpRtCmdtVO[] priRpScpRtCmdtVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtCmdtVO> updateVoList = new ArrayList<PriRpScpRtCmdtVO>();

			for (int i = 0; priRpScpRtCmdtVOs != null && i < priRpScpRtCmdtVOs.length; i++) {
				if (priRpScpRtCmdtVOs[i].getIbflag().equals("U")) {
					priRpScpRtCmdtVOs[i].setPrcProgStsCd("A");
					priRpScpRtCmdtVOs[i].setAcptUsrId(account.getUsr_id());
					priRpScpRtCmdtVOs[i].setAcptOfcCd(account.getOfc_cd());
					priRpScpRtCmdtVOs[i].setAcptDt(com.hanjin.framework.component.util.DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd HH:mm:ss"));

					priRpScpRtCmdtVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtCmdtVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateCommodity(updateVoList, "Y");
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Commodity 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param PriRpScpRtCmdtVO[] priRpScpRtCmdtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateCommodityDetail(PriRpScpRtCmdtVO[] priRpScpRtCmdtVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtCmdtVO> updateVoList = new ArrayList<PriRpScpRtCmdtVO>();

			for (int i = 0; priRpScpRtCmdtVOs != null && i < priRpScpRtCmdtVOs.length; i++) {
				if (priRpScpRtCmdtVOs[i].getIbflag().equals("U")) {
					priRpScpRtCmdtVOs[i].setAcptUsrId(null);
					priRpScpRtCmdtVOs[i].setAcptOfcCd(null);
					priRpScpRtCmdtVOs[i].setAcptDt(null);

					priRpScpRtCmdtVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtCmdtVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateCommodity(updateVoList, "Y");
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Route Note 데이터를 Accept한다.<br>
	 * 
	 * @param PriRpScpRtCmdtRnoteVO[] priRpScpRtCmdtRnoteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateCommodityRnote(PriRpScpRtCmdtRnoteVO[] priRpScpRtCmdtRnoteVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtCmdtRnoteVO> updateVoList = new ArrayList<PriRpScpRtCmdtRnoteVO>();

			for (int i = 0; priRpScpRtCmdtRnoteVOs != null && i < priRpScpRtCmdtRnoteVOs.length; i++) {
				if (priRpScpRtCmdtRnoteVOs[i].getIbflag().equals("U")) {
					priRpScpRtCmdtRnoteVOs[i].setPrcProgStsCd("A");
					priRpScpRtCmdtRnoteVOs[i].setAcptUsrId(account.getUsr_id());
					priRpScpRtCmdtRnoteVOs[i].setAcptOfcCd(account.getOfc_cd());
					priRpScpRtCmdtRnoteVOs[i].setAcptDt(com.hanjin.framework.component.util.DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd HH:mm:ss"));

					priRpScpRtCmdtRnoteVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtCmdtRnoteVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateCommodityRnote(updateVoList, "Y");
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Route Note 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param PriRpScpRtCmdtRnoteVO[] priRpScpRtCmdtRnoteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateCommodityRnote(PriRpScpRtCmdtRnoteVO[] priRpScpRtCmdtRnoteVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtCmdtRnoteVO> updateVoList = new ArrayList<PriRpScpRtCmdtRnoteVO>();

			for (int i = 0; priRpScpRtCmdtRnoteVOs != null && i < priRpScpRtCmdtRnoteVOs.length; i++) {
				if (priRpScpRtCmdtRnoteVOs[i].getIbflag().equals("U")) {
					priRpScpRtCmdtRnoteVOs[i].setAcptUsrId(null);
					priRpScpRtCmdtRnoteVOs[i].setAcptOfcCd(null);
					priRpScpRtCmdtRnoteVOs[i].setAcptDt(null);

					priRpScpRtCmdtRnoteVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtCmdtRnoteVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateCommodityRnote(updateVoList, "Y");
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Route Point 데이터를 Accept한다.<br>
	 * 
	 * @param PriRpScpRtRoutPntVO[] priRpScpRtRoutPntVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateRoutePointDetail(PriRpScpRtRoutPntVO[] priRpScpRtRoutPntVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtRoutPntVO> updateVoList = new ArrayList<PriRpScpRtRoutPntVO>();

			for (int i = 0; priRpScpRtRoutPntVOs != null && i < priRpScpRtRoutPntVOs.length; i++) {
				if (priRpScpRtRoutPntVOs[i].getIbflag().equals("U")) {
					priRpScpRtRoutPntVOs[i].setPrcProgStsCd("A");
					priRpScpRtRoutPntVOs[i].setAcptUsrId(account.getUsr_id());
					priRpScpRtRoutPntVOs[i].setAcptOfcCd(account.getOfc_cd());
					priRpScpRtRoutPntVOs[i].setAcptDt(com.hanjin.framework.component.util.DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd HH:mm:ss"));

					priRpScpRtRoutPntVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtRoutPntVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateRoutePoint(updateVoList, "Y");
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Route Point 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param PriRpScpRtRoutPntVO[] priRpScpRtRoutPntVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateRoutePointDetail(PriRpScpRtRoutPntVO[] priRpScpRtRoutPntVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtRoutPntVO> updateVoList = new ArrayList<PriRpScpRtRoutPntVO>();

			for (int i = 0; priRpScpRtRoutPntVOs != null && i < priRpScpRtRoutPntVOs.length; i++) {
				if (priRpScpRtRoutPntVOs[i].getIbflag().equals("U")) {
					priRpScpRtRoutPntVOs[i].setAcptUsrId(null);
					priRpScpRtRoutPntVOs[i].setAcptOfcCd(null);
					priRpScpRtRoutPntVOs[i].setAcptDt(null);

					priRpScpRtRoutPntVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtRoutPntVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateRoutePoint(updateVoList, "Y");
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Route Via. 데이터를 Accept한다.<br>
	 * 
	 * @param PriRpScpRtRoutViaVO[] priRpScpRtRoutViaVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateRouteViaDetail(PriRpScpRtRoutViaVO[] priRpScpRtRoutViaVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtRoutViaVO> updateVoList = new ArrayList<PriRpScpRtRoutViaVO>();

			for (int i = 0; priRpScpRtRoutViaVOs != null && i < priRpScpRtRoutViaVOs.length; i++) {
				if (priRpScpRtRoutViaVOs[i].getIbflag().equals("U")) {
					priRpScpRtRoutViaVOs[i].setPrcProgStsCd("A");
					priRpScpRtRoutViaVOs[i].setAcptUsrId(account.getUsr_id());
					priRpScpRtRoutViaVOs[i].setAcptOfcCd(account.getOfc_cd());
					priRpScpRtRoutViaVOs[i].setAcptDt(com.hanjin.framework.component.util.DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd HH:mm:ss"));

					priRpScpRtRoutViaVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtRoutViaVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateRouteVia(updateVoList, "Y");
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Route Point 데이터를 Accept Cancel한다.<br>
	 * 
	 * @param PriRpScpRtRoutViaVO[] priRpScpRtRoutViaVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateRouteViaDetail(PriRpScpRtRoutViaVO[] priRpScpRtRoutViaVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtRoutViaVO> updateVoList = new ArrayList<PriRpScpRtRoutViaVO>();

			for (int i = 0; priRpScpRtRoutViaVOs != null && i < priRpScpRtRoutViaVOs.length; i++) {
				if (priRpScpRtRoutViaVOs[i].getIbflag().equals("U")) {
					priRpScpRtRoutViaVOs[i].setAcptUsrId(null);
					priRpScpRtRoutViaVOs[i].setAcptOfcCd(null);
					priRpScpRtRoutViaVOs[i].setAcptDt(null);

					priRpScpRtRoutViaVOs[i].setUpdUsrId(account.getUsr_id());

					updateVoList.add(priRpScpRtRoutViaVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyRateRouteVia(updateVoList, "Y");
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Rate내의 모든항목을 Accept 처리한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param String ficRtTpCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllRate(PriRpScpRtVO priRpScpRtVO, String ficRtTpCd, SignOnUserAccount account) throws EventException {
		try {
			if (priRpScpRtVO != null) {
				priRpScpRtVO.setPrcProgStsCd("A");
				priRpScpRtVO.setAcptUsrId(account.getUsr_id());
				priRpScpRtVO.setAcptOfcCd(account.getOfc_cd());
				priRpScpRtVO.setAcptDt(com.hanjin.framework.component.util.DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd HH:mm:ss"));
				priRpScpRtVO.setUpdUsrId(account.getUsr_id());

				dbDao.modifyAcceptAllRateCmdt(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateActCust(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateCnote(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateRoutPnt(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateRoutVia(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateRnote(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateRt(priRpScpRtVO, ficRtTpCd);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Master RFA Rate내의 모든항목을 Accept 처리한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param String ficRtTpCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllMstRate(PriRpScpRtVO priRpScpRtVO, String ficRtTpCd, SignOnUserAccount account) throws EventException {
		try {
			if (priRpScpRtVO != null) {
				priRpScpRtVO.setPrcProgStsCd("A");
				priRpScpRtVO.setAcptUsrId(account.getUsr_id());
				priRpScpRtVO.setAcptOfcCd(account.getOfc_cd());
				priRpScpRtVO.setAcptDt(com.hanjin.framework.component.util.DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd HH:mm:ss"));
				priRpScpRtVO.setUpdUsrId(account.getUsr_id());

				dbDao.modifyAcceptAllRateCmdt(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateActCust(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateCnote(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateRoutPnt(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateRoutVia(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateRnote(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateRt(priRpScpRtVO, ficRtTpCd);
				// Note Conversion
				dbDao.modifyAcceptAllMstNoteConv(priRpScpRtVO, ficRtTpCd);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Rate의 모든 항목을 Accept Cancel한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param String ficRtTpCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllRate(PriRpScpRtVO priRpScpRtVO, String ficRtTpCd, SignOnUserAccount account) throws EventException {
		try {
			if (priRpScpRtVO != null) {
				priRpScpRtVO.setPrcProgStsCd("I");
				priRpScpRtVO.setAcptUsrId(null);
				priRpScpRtVO.setAcptOfcCd(null);
				priRpScpRtVO.setAcptDt(null);
				priRpScpRtVO.setUpdUsrId(account.getUsr_id());

				dbDao.modifyAcceptAllRateCmdt(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateActCust(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateCnote(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateRoutPnt(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateRoutVia(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateRnote(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateRt(priRpScpRtVO, ficRtTpCd);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Master RFA Rate의 모든 항목을 Accept Cancel한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param String ficRtTpCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllMstRate(PriRpScpRtVO priRpScpRtVO, String ficRtTpCd, SignOnUserAccount account) throws EventException {
		try {
			if (priRpScpRtVO != null) {
				priRpScpRtVO.setPrcProgStsCd("I");
				priRpScpRtVO.setAcptUsrId(null);
				priRpScpRtVO.setAcptOfcCd(null);
				priRpScpRtVO.setAcptDt(null);
				priRpScpRtVO.setUpdUsrId(account.getUsr_id());

				dbDao.modifyAcceptAllRateCmdt(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateActCust(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateCnote(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateRoutPnt(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateRoutVia(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateRnote(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateRt(priRpScpRtVO, ficRtTpCd);
				// Note Conversion
				dbDao.modifyAcceptAllMstNoteConv(priRpScpRtVO, ficRtTpCd);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Guideline의 데이터를 복사해온다.<br>
	 * 
	 * @param RfaGlineCopyVO rfaGlineCopyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineRate(RfaGlineCopyVO rfaGlineCopyVO, SignOnUserAccount account) throws EventException {
		try {
			if (rfaGlineCopyVO != null) {
				rfaGlineCopyVO.setCreUsrId(account.getUsr_id());
				rfaGlineCopyVO.setUpdUsrId(account.getUsr_id());

				dbDao.addRateCommodityHeaderGlineCopy(rfaGlineCopyVO);
				dbDao.addRateCommodityGlineCopy(rfaGlineCopyVO);
				dbDao.addRateCommodityRouteGlineCopy(rfaGlineCopyVO);
				dbDao.addRateRoutePointGlineCopy(rfaGlineCopyVO);
				dbDao.addRateRouteViaGlineCopy(rfaGlineCopyVO);
				int rtCnt = dbDao.addRateGlineCopy(rfaGlineCopyVO);
				if (rtCnt > 0) {
					PriRpScpRtCmdtRoutVO routVO = new PriRpScpRtCmdtRoutVO();
					routVO.setPropNo(rfaGlineCopyVO.getPropNo());
					routVO.setAmdtSeq(rfaGlineCopyVO.getAmdtSeq());
					routVO.setSvcScpCd(rfaGlineCopyVO.getSvcScpCd());

					dbDao.modifyRouteNoteDispSeq(routVO, "0");
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Guideline Copy전 Group Location, Group Commodity가 존재하는지 확인한다.<br>
	 * 
	 * @param RfaGlineCopyVO rfaGlineCopyVO
	 * @return RsltCdListVO
	 * @exception EventException
	 */
	public RsltCdListVO checkGlineCopyGroupCodeExist(RfaGlineCopyVO rfaGlineCopyVO) throws EventException {
		try {
			return dbDao.searchGlineCopyGroupCodeExist(rfaGlineCopyVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Rate 데이터에 GRI Calculation을 적용합니다.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void applyGRICalculation(PriRpScpGriGrpVO priRpScpGriGrpVO, SignOnUserAccount account) throws EventException {
		try {
			if (priRpScpGriGrpVO != null) {
				priRpScpGriGrpVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyProposalScopeRateGRIApply(priRpScpGriGrpVO);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 적용한 GRI Calculation을 취소합니다.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGRICalculation(PriRpScpGriGrpVO priRpScpGriGrpVO, SignOnUserAccount account) throws EventException {
		try {
			if (priRpScpGriGrpVO != null) {
				priRpScpGriGrpVO.setCreUsrId(account.getUsr_id());
				priRpScpGriGrpVO.setUpdUsrId(account.getUsr_id());

				if (!"0".equals(priRpScpGriGrpVO.getAmdtSeq())) {
					dbDao.removeRateScgOnGRICancel(priRpScpGriGrpVO);
					dbDao.removeRateScgRoutOnGRICancel(priRpScpGriGrpVO);
					dbDao.removeRateUsdRoutCsOnGRICancel(priRpScpGriGrpVO);

					dbDao.addCopyPrevRateScgOnGRICancel(priRpScpGriGrpVO);
					dbDao.addCopyPrevRateScgRoutOnGRICancel(priRpScpGriGrpVO);
					dbDao.addCopyPrevRateUsdRoutCsOnGRICancel(priRpScpGriGrpVO);
				}

				dbDao.modifyProposalScopeRateGRICancel(priRpScpGriGrpVO);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @exception EventException
	 */
	public void removeProposalMain(PriRpScpMnVO priRpScpMnVO) throws EventException {
		try {
			if (priRpScpMnVO != null) {

				dbDao.removeSurchargeAdjustInitCancel(priRpScpMnVO);

				dbDao.removeProposalMainRtScg(priRpScpMnVO);
				dbDao.removeProposalMainRtScgRout(priRpScpMnVO);
				log.debug("removeProposalMainRtScgUsdRout=====================start");
				dbDao.removeProposalMainRtScgUsdRout(priRpScpMnVO);
				log.debug("removeProposalMainRtScgUsdRout=====================end");
				dbDao.removeProposalMainRtCgoSpec(priRpScpMnVO);
				dbDao.removeProposalMainRt(priRpScpMnVO);
				dbDao.removeProposalMainRtRoutVia(priRpScpMnVO);
				dbDao.removeProposalMainRtRoutPnt(priRpScpMnVO);
				dbDao.removeProposalMainRtCmdtRnote(priRpScpMnVO);
				dbDao.removeProposalMainRtCmdtRout(priRpScpMnVO);

				dbDao.removeProposalMainRtCnote(priRpScpMnVO);
				dbDao.removeProposalMainRtActCust(priRpScpMnVO);
				dbDao.removeProposalMainRtCmdt(priRpScpMnVO);
				dbDao.removeProposalMainRtCmdtHdr(priRpScpMnVO);

			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Load된 엑셀 데이터가 올바른지 Check한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelVertical(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs)
			throws EventException {
		List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();

		try {
			RsltRtListVerticalExcelVO row = new RsltRtListVerticalExcelVO();

			String strCmdtCd = null;
			String strCustSeq = null;
			String strOrgPntCd = null;
			String strOrgViaCd = null;
			String strDestViaCd = null;
			String strDestPntCd = null;
			for (int i = 0; i < rsltRtListVerticalExcelVOs.length; i++) {
				row = rsltRtListVerticalExcelVOs[i];

				strCmdtCd = row.getPrcCmdtDefCd();
				strCustSeq = row.getCustSeq();
				strOrgPntCd = row.getOrgRoutPntLocDefCd();
				strOrgViaCd = row.getOrgRoutViaPortDefCd();
				strDestViaCd = row.getDestRoutViaPortDefCd();
				strDestPntCd = row.getDestRoutPntLocDefCd();

				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strCmdtCd);

					RsltCdListVO cdVO = dbDao.searchCommodityCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strCmdtCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("prc_cmdt_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strCustSeq != null && !"".equals(strCustSeq)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strCustSeq);

					RsltCdListVO cdVO = dbDao.searchActualCustomerExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strCustSeq);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("cust_seq");

						rslt.add(cdVO);
					}
				}
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strOrgPntCd);
					paramVO.setEtc1("O");

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strOrgPntCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("org_rout_pnt_loc_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strOrgViaCd);

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strOrgViaCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("org_rout_via_port_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strDestViaCd);

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strDestViaCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("dest_rout_via_port_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strDestPntCd);
					paramVO.setEtc1("D");

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strDestPntCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("dest_rout_pnt_loc_def_cd");

						rslt.add(cdVO);
					}
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return rslt;
	}

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
			throws EventException {
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		UploadRateExcelVerticalBackEndJobImpl jobImpl = new UploadRateExcelVerticalBackEndJobImpl();
		String key = null;

		try {
			jobImpl.setPriRpScpRtCmdtHdrVO(priRpScpRtCmdtHdrVO);
			jobImpl.setRsltRtListVerticalExcelVOs(rsltRtListVerticalExcelVOs);
			jobImpl.setAccount(account);

			key = backEndJobManager.execute(jobImpl, account.getUsr_id(), "ESM_PRI_0065");
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return key;
	}

	/**
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelVerticalOnline(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs, SignOnUserAccount account)
			throws EventException {
		List<PriRpScpRtCmdtHdrVO> cmdtHdrVoList = new ArrayList<PriRpScpRtCmdtHdrVO>();
		List<PriRpScpRtCmdtVO> cmdtVoList = new ArrayList<PriRpScpRtCmdtVO>();
		List<PriRpScpRtActCustVO> custVoList = new ArrayList<PriRpScpRtActCustVO>();
		List<PriRpScpRtCmdtRoutVO> routVoList = new ArrayList<PriRpScpRtCmdtRoutVO>();
		List<PriRpScpRtRoutPntVO> pntVoList = new ArrayList<PriRpScpRtRoutPntVO>();
		List<PriRpScpRtRoutViaVO> viaVoList = new ArrayList<PriRpScpRtRoutViaVO>();
		List<PriRpScpRtVO> rtVoList = new ArrayList<PriRpScpRtVO>();
		List<PriRpScpRtScgVO> scgVoList = new ArrayList<PriRpScpRtScgVO>();

		try {
			int nextCmdtHdrSeq = dbDao.searchNextCmdtHdrSeq(priRpScpRtCmdtHdrVO);
			int nextBletDpSeq = Integer.parseInt(dbDao.searchMaxBulletDispSeq(priRpScpRtCmdtHdrVO));
			int nextCmdtSeq = 0;
			int nextActCustSeq = 0;

			int nextRoutSeq = 0;
			int nextRoutPntSeq = 0;
			int nextRoutViaSeq = 0;
			int nextRtSeq = 0;

			String strPropNo = priRpScpRtCmdtHdrVO.getPropNo();
			String strAmdtSeq = priRpScpRtCmdtHdrVO.getAmdtSeq();
			String strSvcScpCd = priRpScpRtCmdtHdrVO.getSvcScpCd();
			String strCreUsrId = account.getUsr_id();
			String strUpdUsrId = account.getUsr_id();

			for (int i = 0; i < rsltRtListVerticalExcelVOs.length; i++) {
				RsltRtListVerticalExcelVO row = rsltRtListVerticalExcelVOs[i];

				String strCmdtDpSeq = row.getCmdtDpSeq();
				String strCmdtCd = row.getPrcCmdtDefCd();
				String strCustSeq = row.getCustSeq();

				String strRoutDpSeq = row.getRoutDpSeq();
				String strOrgPntCd = row.getOrgRoutPntLocDefCd();
				String strOrgRcvDeTermCd = row.getOrgRcvDeTermNm();
				String strOrgPrcTrspModCd = row.getOrgPrcTrspModNm();
				String strOrgViaCd = row.getOrgRoutViaPortDefCd();
				String strDestViaCd = row.getDestRoutViaPortDefCd();
				String strDestPntCd = row.getDestRoutPntLocDefCd();
				String strDestRcvDeTermCd = row.getDestRcvDeTermNm();
				String strDestPrcTrspModCd = row.getDestPrcTrspModNm();

				String strPerTypeCd = row.getRatUtCd();
				String strCgoTypeCd = row.getPrcCgoTpCd();
				String strCurrCd = row.getCurrCd();
				String strRateAmt = row.getPropFrtRtAmt();

				String strBucAmt = row.getBucUsdAmt();
				String strIfcAmt = row.getIfcUsdAmt();
				String strPscAmt = row.getPscUsdAmt();

				if (strCmdtDpSeq != null && !"".equals(strCmdtDpSeq)) {
					nextCmdtHdrSeq++;
					nextBletDpSeq++;
					nextCmdtSeq = 0;
					nextActCustSeq = 0;
					nextRoutSeq = 0;

					PriRpScpRtCmdtHdrVO cmdtHdr = new PriRpScpRtCmdtHdrVO();
					cmdtHdr.setPropNo(strPropNo);
					cmdtHdr.setAmdtSeq(strAmdtSeq);
					cmdtHdr.setSvcScpCd(strSvcScpCd);
					cmdtHdr.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdtHdr.setBletDpSeq(String.valueOf(nextBletDpSeq));
					cmdtHdr.setN1stCmncAmdtSeq(strAmdtSeq);
					cmdtHdr.setCreUsrId(strCreUsrId);
					cmdtHdr.setUpdUsrId(strUpdUsrId);
					cmdtHdr.setFicRtTpCd(priRpScpRtCmdtHdrVO.getFicRtTpCd());
					cmdtHdrVoList.add(cmdtHdr);
				}

				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					nextCmdtSeq++;

					String cmdtTpCd = "";
					if (strCmdtCd.length() == 5) {
						cmdtTpCd = "G";
					} else if (strCmdtCd.length() == 4) {
						cmdtTpCd = "R";
					} else if (strCmdtCd.length() == 6) {
						cmdtTpCd = "C";
					}

					PriRpScpRtCmdtVO cmdt = new PriRpScpRtCmdtVO();
					cmdt.setPropNo(strPropNo);
					cmdt.setAmdtSeq(strAmdtSeq);
					cmdt.setSvcScpCd(strSvcScpCd);
					cmdt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdt.setCmdtSeq(String.valueOf(nextCmdtSeq));
					cmdt.setPrcCmdtTpCd(cmdtTpCd);
					cmdt.setPrcCmdtDefCd(strCmdtCd);
					cmdt.setPrcProgStsCd("I");
					cmdt.setSrcInfoCd("NW");
					cmdt.setN1stCmncAmdtSeq(strAmdtSeq);
					cmdt.setCreUsrId(strCreUsrId);
					cmdt.setUpdUsrId(strUpdUsrId);

					cmdtVoList.add(cmdt);
				}
				if (strCustSeq != null && !"".equals(strCustSeq)) {
					nextActCustSeq++;

					PriRpScpRtActCustVO cust = new PriRpScpRtActCustVO();
					cust.setPropNo(strPropNo);
					cust.setAmdtSeq(strAmdtSeq);
					cust.setSvcScpCd(strSvcScpCd);
					cust.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cust.setActCustSeq(String.valueOf(nextActCustSeq));
					cust.setCustCntCd(strCustSeq.substring(0, 2));
					cust.setCustSeq(strCustSeq.substring(2));
					cust.setPrcProgStsCd("I");
					cust.setSrcInfoCd("NW");
					cust.setN1stCmncAmdtSeq(strAmdtSeq);
					cust.setCreUsrId(strCreUsrId);
					cust.setUpdUsrId(strUpdUsrId);

					custVoList.add(cust);
				}

				if (strRoutDpSeq != null && !"".equals(strRoutDpSeq)) {
					nextRoutSeq++;
					nextRoutPntSeq = 0;
					nextRoutViaSeq = 0;
					nextRtSeq = 0;

					PriRpScpRtCmdtRoutVO rout = new PriRpScpRtCmdtRoutVO();
					rout.setPropNo(strPropNo);
					rout.setAmdtSeq(strAmdtSeq);
					rout.setSvcScpCd(strSvcScpCd);
					rout.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rout.setRoutSeq(String.valueOf(nextRoutSeq));
					rout.setN1stCmncAmdtSeq(strAmdtSeq);
					rout.setCreUsrId(strCreUsrId);
					rout.setUpdUsrId(strUpdUsrId);

					routVoList.add(rout);
				}

				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					nextRoutPntSeq++;

					String locTpCd = strOrgPntCd.length() == 4 ? "G" : "L";

					PriRpScpRtRoutPntVO pnt = new PriRpScpRtRoutPntVO();
					pnt.setPropNo(strPropNo);
					pnt.setAmdtSeq(strAmdtSeq);
					pnt.setSvcScpCd(strSvcScpCd);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("O");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strOrgPntCd);
					pnt.setRcvDeTermCd(strOrgRcvDeTermCd);
					pnt.setPrcTrspModCd(strOrgPrcTrspModCd);
					pnt.setPrcProgStsCd("I");
					pnt.setSrcInfoCd("NW");
					pnt.setN1stCmncAmdtSeq(strAmdtSeq);
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);

					pntVoList.add(pnt);
				}
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					nextRoutViaSeq++;

					String locTpCd = strOrgViaCd.length() == 4 ? "G" : "L";

					PriRpScpRtRoutViaVO via = new PriRpScpRtRoutViaVO();
					via.setPropNo(strPropNo);
					via.setAmdtSeq(strAmdtSeq);
					via.setSvcScpCd(strSvcScpCd);
					via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					via.setRoutSeq(String.valueOf(nextRoutSeq));
					via.setOrgDestTpCd("O");
					via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
					via.setRoutViaPortTpCd(locTpCd);
					via.setRoutViaPortDefCd(strOrgViaCd);
					via.setPrcProgStsCd("I");
					via.setSrcInfoCd("NW");
					via.setN1stCmncAmdtSeq(strAmdtSeq);
					via.setCreUsrId(strCreUsrId);
					via.setUpdUsrId(strUpdUsrId);

					viaVoList.add(via);
				}
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					nextRoutViaSeq++;

					String locTpCd = strDestViaCd.length() == 4 ? "G" : "L";

					PriRpScpRtRoutViaVO via = new PriRpScpRtRoutViaVO();
					via.setPropNo(strPropNo);
					via.setAmdtSeq(strAmdtSeq);
					via.setSvcScpCd(strSvcScpCd);
					via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					via.setRoutSeq(String.valueOf(nextRoutSeq));
					via.setOrgDestTpCd("D");
					via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
					via.setRoutViaPortTpCd(locTpCd);
					via.setRoutViaPortDefCd(strDestViaCd);
					via.setPrcProgStsCd("I");
					via.setSrcInfoCd("NW");
					via.setN1stCmncAmdtSeq(strAmdtSeq);
					via.setCreUsrId(strCreUsrId);
					via.setUpdUsrId(strUpdUsrId);

					viaVoList.add(via);
				}
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					nextRoutPntSeq++;

					String locTpCd = strDestPntCd.length() == 4 ? "G" : "L";

					PriRpScpRtRoutPntVO pnt = new PriRpScpRtRoutPntVO();
					pnt.setPropNo(strPropNo);
					pnt.setAmdtSeq(strAmdtSeq);
					pnt.setSvcScpCd(strSvcScpCd);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("D");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strDestPntCd);
					pnt.setRcvDeTermCd(strDestRcvDeTermCd);
					pnt.setPrcTrspModCd(strDestPrcTrspModCd);
					pnt.setPrcProgStsCd("I");
					pnt.setSrcInfoCd("NW");
					pnt.setN1stCmncAmdtSeq(strAmdtSeq);
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);

					pntVoList.add(pnt);
				}

				if (strRateAmt != null && !"".equals(strRateAmt)) {
					nextRtSeq++;

					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd(strPerTypeCd);
					rt.setPrcCgoTpCd(strCgoTypeCd);
//					rt.setCurrCd("USD");
					rt.setCurrCd(strCurrCd);
					rt.setPropFrtRtAmt(strRateAmt);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					rtVoList.add(rt);

					if (strBucAmt != null && !"".equals(strBucAmt)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd(strPerTypeCd);
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucAmt);
						scg.setAdjScgUsdAmt(strBucAmt);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strIfcAmt != null && !"".equals(strIfcAmt)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd(strPerTypeCd);
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcAmt);
						scg.setAdjScgUsdAmt(strIfcAmt);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strPscAmt != null && !"".equals(strPscAmt)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd(strPerTypeCd);
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscAmt);
						scg.setAdjScgUsdAmt(strPscAmt);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
				}
			}

			if (cmdtHdrVoList.size() > 0) {
				dbDao.addRateCommodityHeader(cmdtHdrVoList);
			}
			if (cmdtVoList.size() > 0) {
				dbDao.addRateCommodity(cmdtVoList);
			}
			if (custVoList.size() > 0) {
				dbDao.addRateActualCustomer(custVoList);
			}

			if (routVoList.size() > 0) {
				dbDao.addRateCommodityRoute(routVoList);
			}
			if (pntVoList.size() > 0) {
				dbDao.addRateRoutePoint(pntVoList);
			}
			if (viaVoList.size() > 0) {
				dbDao.addRateRouteVia(viaVoList);
			}

			if (rtVoList.size() > 0) {
				dbDao.addRate(rtVoList);
			}
			if (scgVoList.size() > 0) {
				dbDao.addRateSurcharge(scgVoList);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Load된 엑셀 데이터가 올바른지 Check한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelHorizontal(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs)
			throws EventException {
		List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();

		try {
			RsltRtListHorizontalExcelVO row = new RsltRtListHorizontalExcelVO();

			String strCmdtCd = null;
			String strCustSeq = null;
			String strOrgPntCd = null;
			String strOrgViaCd = null;
			String strDestViaCd = null;
			String strDestPntCd = null;

			for (int i = 0; i < rsltRtListHorizontalExcelVOs.length; i++) {
				row = rsltRtListHorizontalExcelVOs[i];

				strCmdtCd = row.getPrcCmdtDefCd();
				strCustSeq = row.getCustSeq();
				strOrgPntCd = row.getOrgRoutPntLocDefCd();
				strOrgViaCd = row.getOrgRoutViaPortDefCd();
				strDestViaCd = row.getDestRoutViaPortDefCd();
				strDestPntCd = row.getDestRoutPntLocDefCd();

				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strCmdtCd);

					RsltCdListVO cdVO = dbDao.searchCommodityCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strCmdtCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("prc_cmdt_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strCustSeq != null && !"".equals(strCustSeq)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strCustSeq);

					RsltCdListVO cdVO = dbDao.searchActualCustomerExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strCustSeq);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("cust_seq");

						rslt.add(cdVO);
					}
				}
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strOrgPntCd);
					paramVO.setEtc1("O");

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strOrgPntCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("org_rout_pnt_loc_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strOrgViaCd);

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strOrgViaCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("org_rout_via_port_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strDestViaCd);

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strDestViaCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("dest_rout_via_port_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strDestPntCd);
					paramVO.setEtc1("D");

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strDestPntCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("dest_rout_pnt_loc_def_cd");

						rslt.add(cdVO);
					}
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return rslt;
	}
	

	/**
	 * Load된 엑셀 데이터가 올바른지 Check한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkMstRateExcelHorizontal(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs)
			throws EventException {
		List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();

		try {
			RsltRtListHorizontalExcelVO row = new RsltRtListHorizontalExcelVO();

			String strCmdtCd = null;
			String strOrgPntCd = null;
			String strOrgViaCd = null;
			String strDestViaCd = null;
			String strDestPntCd = null;

			for (int i = 0; i < rsltRtListHorizontalExcelVOs.length; i++) {
				row = rsltRtListHorizontalExcelVOs[i];

				strCmdtCd = row.getPrcCmdtDefCd();				
				strOrgPntCd = row.getOrgRoutPntLocDefCd();
				strOrgViaCd = row.getOrgRoutViaPortDefCd();
				strDestViaCd = row.getDestRoutViaPortDefCd();
				strDestPntCd = row.getDestRoutPntLocDefCd();

				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strCmdtCd);

					RsltCdListVO cdVO = dbDao.searchCommodityCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strCmdtCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("prc_cmdt_def_cd");

						rslt.add(cdVO);
					}
				}				
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strOrgPntCd);
					paramVO.setEtc1("O");

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strOrgPntCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("org_rout_pnt_loc_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strOrgViaCd);

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strOrgViaCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("org_rout_via_port_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strDestViaCd);

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strDestViaCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("dest_rout_via_port_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strDestPntCd);
					paramVO.setEtc1("D");

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strDestPntCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("dest_rout_pnt_loc_def_cd");

						rslt.add(cdVO);
					}
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return rslt;
	}

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
			throws EventException {
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		UploadRateExcelHorizontalBackEndJobImpl jobImpl = new UploadRateExcelHorizontalBackEndJobImpl();
		String key = null;

		try {
			jobImpl.setPriRpScpRtCmdtHdrVO(priRpScpRtCmdtHdrVO);
			jobImpl.setRsltRtListHorizontalExcelVOs(rsltRtListHorizontalExcelVOs);
			jobImpl.setAccount(account);

			key = backEndJobManager.execute(jobImpl, account.getUsr_id(), "ESM_PRI_0099");
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return key;
	}
	
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
			throws EventException {
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		UploadRfaRateExcelHorizontalBackEndJobImpl jobImpl = new UploadRfaRateExcelHorizontalBackEndJobImpl();
		String key = null;

		try {
			jobImpl.setPriRpScpRtCmdtHdrVO(priRpScpRtCmdtHdrVO);
			jobImpl.setRsltRtListHorizontalExcelVOs(rsltRtListHorizontalExcelVOs);
			jobImpl.setAccount(account);

			key = backEndJobManager.execute(jobImpl, account.getUsr_id(), "ESM_PRI_0099");
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return key;
	}

	/**
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelHorizontalOnline(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs,
			SignOnUserAccount account) throws EventException {
		List<PriRpScpRtCmdtHdrVO> cmdtHdrVoList = new ArrayList<PriRpScpRtCmdtHdrVO>();
		List<PriRpScpRtCmdtVO> cmdtVoList = new ArrayList<PriRpScpRtCmdtVO>();
		List<PriRpScpRtActCustVO> custVoList = new ArrayList<PriRpScpRtActCustVO>();
		List<PriRpScpRtCmdtRoutVO> routVoList = new ArrayList<PriRpScpRtCmdtRoutVO>();
		List<PriRpScpRtRoutPntVO> pntVoList = new ArrayList<PriRpScpRtRoutPntVO>();
		List<PriRpScpRtRoutViaVO> viaVoList = new ArrayList<PriRpScpRtRoutViaVO>();
		List<PriRpScpRtVO> rtVoList = new ArrayList<PriRpScpRtVO>();
		List<PriRpScpRtScgVO> scgVoList = new ArrayList<PriRpScpRtScgVO>();

		try {
			int nextCmdtHdrSeq = dbDao.searchNextCmdtHdrSeq(priRpScpRtCmdtHdrVO);
			int nextBletDpSeq = Integer.parseInt(dbDao.searchMaxBulletDispSeq(priRpScpRtCmdtHdrVO));
			int nextCmdtSeq = 0;
			int nextActCustSeq = 0;

			int nextRoutSeq = 0;
			int nextRoutPntSeq = 0;
			int nextRoutViaSeq = 0;
			int nextRtSeq = 0;

			String strPropNo = priRpScpRtCmdtHdrVO.getPropNo();
			String strAmdtSeq = priRpScpRtCmdtHdrVO.getAmdtSeq();
			String strSvcScpCd = priRpScpRtCmdtHdrVO.getSvcScpCd();
			String strCreUsrId = account.getUsr_id();
			String strUpdUsrId = account.getUsr_id();

			for (int i = 0; i < rsltRtListHorizontalExcelVOs.length; i++) {
				RsltRtListHorizontalExcelVO row = rsltRtListHorizontalExcelVOs[i];

				String strCmdtDpSeq = row.getCmdtDpSeq();
				String strCmdtCd = row.getPrcCmdtDefCd();
				String strCustSeq = row.getCustSeq();

				String strRoutDpSeq = row.getRoutDpSeq();
				String strOrgPntCd = row.getOrgRoutPntLocDefCd();
				String strOrgRcvDeTermCd = row.getOrgRcvDeTermNm();
				String strOrgPrcTrspModCd = row.getOrgPrcTrspModNm();
				String strOrgViaCd = row.getOrgRoutViaPortDefCd();
				String strDestViaCd = row.getDestRoutViaPortDefCd();
				String strDestPntCd = row.getDestRoutPntLocDefCd();
				String strDestRcvDeTermCd = row.getDestRcvDeTermNm();
				String strDestPrcTrspModCd = row.getDestPrcTrspModNm();

				String strRateDry20 = row.getRateDry20();
				String strRateDry40 = row.getRateDry40();
				String strRateDry40hc = row.getRateDry40hc();
				String strRateDry45 = row.getRateDry45();
				String strRateRf40hc = row.getRateRf40hc();
				String strRateRd40hc = row.getRateRd40hc();

				String strBucDry20 = row.getBucDry20();
				String strBucDry40 = row.getBucDry40();
				String strBucDry40hc = row.getBucDry40hc();
				String strBucDry45 = row.getBucDry45();
				String strBucRf40hc = row.getBucRf40hc();
				String strBucRd40hc = row.getBucRd40hc();

				String strIfcDry20 = row.getIfcDry20();
				String strIfcDry40 = row.getIfcDry40();
				String strIfcDry40hc = row.getIfcDry40hc();
				String strIfcDry45 = row.getIfcDry45();
				String strIfcRf40hc = row.getIfcRf40hc();
				String strIfcRd40hc = row.getIfcRd40hc();

				String strPscDry20 = row.getPscDry20();
				String strPscDry40 = row.getPscDry40();
				String strPscDry40hc = row.getPscDry40hc();
				String strPscDry45 = row.getPscDry45();
				String strPscRf40hc = row.getPscRf40hc();
				String strPscRd40hc = row.getPscRd40hc();

				if (strCmdtDpSeq != null && !"".equals(strCmdtDpSeq)) {
					nextCmdtHdrSeq++;
					nextBletDpSeq++;
					nextCmdtSeq = 0;
					nextActCustSeq = 0;
					nextRoutSeq = 0;

					PriRpScpRtCmdtHdrVO cmdtHdr = new PriRpScpRtCmdtHdrVO();
					cmdtHdr.setPropNo(strPropNo);
					cmdtHdr.setAmdtSeq(strAmdtSeq);
					cmdtHdr.setSvcScpCd(strSvcScpCd);
					cmdtHdr.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdtHdr.setBletDpSeq(String.valueOf(nextBletDpSeq));
					cmdtHdr.setN1stCmncAmdtSeq(strAmdtSeq);
					cmdtHdr.setCreUsrId(strCreUsrId);
					cmdtHdr.setUpdUsrId(strUpdUsrId);
					cmdtHdr.setFicRtTpCd(priRpScpRtCmdtHdrVO.getFicRtTpCd());
					cmdtHdrVoList.add(cmdtHdr);
				}

				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					nextCmdtSeq++;

					String cmdtTpCd = "";
					if (strCmdtCd.length() == 5) {
						cmdtTpCd = "G";
					} else if (strCmdtCd.length() == 4) {
						cmdtTpCd = "R";
					} else if (strCmdtCd.length() == 6) {
						cmdtTpCd = "C";
					}

					PriRpScpRtCmdtVO cmdt = new PriRpScpRtCmdtVO();
					cmdt.setPropNo(strPropNo);
					cmdt.setAmdtSeq(strAmdtSeq);
					cmdt.setSvcScpCd(strSvcScpCd);
					cmdt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdt.setCmdtSeq(String.valueOf(nextCmdtSeq));
					cmdt.setPrcCmdtTpCd(cmdtTpCd);
					cmdt.setPrcCmdtDefCd(strCmdtCd);
					cmdt.setPrcProgStsCd("I");
					cmdt.setSrcInfoCd("NW");
					cmdt.setN1stCmncAmdtSeq(strAmdtSeq);
					cmdt.setCreUsrId(strCreUsrId);
					cmdt.setUpdUsrId(strUpdUsrId);

					cmdtVoList.add(cmdt);
				}
				if (strCustSeq != null && !"".equals(strCustSeq)) {
					nextActCustSeq++;

					PriRpScpRtActCustVO cust = new PriRpScpRtActCustVO();
					cust.setPropNo(strPropNo);
					cust.setAmdtSeq(strAmdtSeq);
					cust.setSvcScpCd(strSvcScpCd);
					cust.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cust.setActCustSeq(String.valueOf(nextActCustSeq));
					cust.setCustCntCd(strCustSeq.substring(0, 2));
					cust.setCustSeq(strCustSeq.substring(2));
					cust.setPrcProgStsCd("I");
					cust.setSrcInfoCd("NW");
					cust.setN1stCmncAmdtSeq(strAmdtSeq);
					cust.setCreUsrId(strCreUsrId);
					cust.setUpdUsrId(strUpdUsrId);

					custVoList.add(cust);
				}

				if (strRoutDpSeq != null && !"".equals(strRoutDpSeq)) {
					nextRoutSeq++;
					nextRoutPntSeq = 0;
					nextRoutViaSeq = 0;
					nextRtSeq = 0;

					PriRpScpRtCmdtRoutVO rout = new PriRpScpRtCmdtRoutVO();
					rout.setPropNo(strPropNo);
					rout.setAmdtSeq(strAmdtSeq);
					rout.setSvcScpCd(strSvcScpCd);
					rout.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rout.setRoutSeq(String.valueOf(nextRoutSeq));
					rout.setN1stCmncAmdtSeq(strAmdtSeq);
					rout.setCreUsrId(strCreUsrId);
					rout.setUpdUsrId(strUpdUsrId);

					routVoList.add(rout);
				}

				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					nextRoutPntSeq++;

					String locTpCd = strOrgPntCd.length() == 4 ? "G" : "L";

					PriRpScpRtRoutPntVO pnt = new PriRpScpRtRoutPntVO();
					pnt.setPropNo(strPropNo);
					pnt.setAmdtSeq(strAmdtSeq);
					pnt.setSvcScpCd(strSvcScpCd);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("O");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strOrgPntCd);
					pnt.setRcvDeTermCd(strOrgRcvDeTermCd);
					pnt.setPrcTrspModCd(strOrgPrcTrspModCd);
					pnt.setPrcProgStsCd("I");
					pnt.setSrcInfoCd("NW");
					pnt.setN1stCmncAmdtSeq(strAmdtSeq);
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);

					pntVoList.add(pnt);
				}
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					nextRoutViaSeq++;

					String locTpCd = strOrgViaCd.length() == 4 ? "G" : "L";

					PriRpScpRtRoutViaVO via = new PriRpScpRtRoutViaVO();
					via.setPropNo(strPropNo);
					via.setAmdtSeq(strAmdtSeq);
					via.setSvcScpCd(strSvcScpCd);
					via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					via.setRoutSeq(String.valueOf(nextRoutSeq));
					via.setOrgDestTpCd("O");
					via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
					via.setRoutViaPortTpCd(locTpCd);
					via.setRoutViaPortDefCd(strOrgViaCd);
					via.setPrcProgStsCd("I");
					via.setSrcInfoCd("NW");
					via.setN1stCmncAmdtSeq(strAmdtSeq);
					via.setCreUsrId(strCreUsrId);
					via.setUpdUsrId(strUpdUsrId);

					viaVoList.add(via);
				}
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					nextRoutViaSeq++;

					String locTpCd = strDestViaCd.length() == 4 ? "G" : "L";

					PriRpScpRtRoutViaVO via = new PriRpScpRtRoutViaVO();
					via.setPropNo(strPropNo);
					via.setAmdtSeq(strAmdtSeq);
					via.setSvcScpCd(strSvcScpCd);
					via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					via.setRoutSeq(String.valueOf(nextRoutSeq));
					via.setOrgDestTpCd("D");
					via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
					via.setRoutViaPortTpCd(locTpCd);
					via.setRoutViaPortDefCd(strDestViaCd);
					via.setPrcProgStsCd("I");
					via.setSrcInfoCd("NW");
					via.setN1stCmncAmdtSeq(strAmdtSeq);
					via.setCreUsrId(strCreUsrId);
					via.setUpdUsrId(strUpdUsrId);

					viaVoList.add(via);
				}
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					nextRoutPntSeq++;

					String locTpCd = strDestPntCd.length() == 4 ? "G" : "L";

					PriRpScpRtRoutPntVO pnt = new PriRpScpRtRoutPntVO();
					pnt.setPropNo(strPropNo);
					pnt.setAmdtSeq(strAmdtSeq);
					pnt.setSvcScpCd(strSvcScpCd);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("D");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strDestPntCd);
					pnt.setRcvDeTermCd(strDestRcvDeTermCd);
					pnt.setPrcTrspModCd(strDestPrcTrspModCd);
					pnt.setPrcProgStsCd("I");
					pnt.setSrcInfoCd("NW");
					pnt.setN1stCmncAmdtSeq(strAmdtSeq);
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);

					pntVoList.add(pnt);
				}

				if (strRateDry20 != null && !"".equals(strRateDry20)) {
					nextRtSeq++;

					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("D2");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setPropFrtRtAmt(strRateDry20);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					rtVoList.add(rt);

					if (strBucDry20 != null && !"".equals(strBucDry20)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd("D2");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucDry20);
						scg.setAdjScgUsdAmt(strBucDry20);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strIfcDry20 != null && !"".equals(strIfcDry20)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd("D2");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcDry20);
						scg.setAdjScgUsdAmt(strIfcDry20);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strPscDry20 != null && !"".equals(strPscDry20)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd("D2");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscDry20);
						scg.setAdjScgUsdAmt(strPscDry20);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
				}

				if (strRateDry40 != null && !"".equals(strRateDry40)) {
					nextRtSeq++;

					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("D4");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setPropFrtRtAmt(strRateDry40);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					rtVoList.add(rt);

					if (strBucDry40 != null && !"".equals(strBucDry40)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd("D4");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucDry40);
						scg.setAdjScgUsdAmt(strBucDry40);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strIfcDry40 != null && !"".equals(strIfcDry40)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd("D4");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcDry40);
						scg.setAdjScgUsdAmt(strIfcDry40);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strPscDry40 != null && !"".equals(strPscDry40)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd("D4");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscDry40);
						scg.setAdjScgUsdAmt(strPscDry40);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
				}

				if (strRateDry40hc != null && !"".equals(strRateDry40hc)) {
					nextRtSeq++;

					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("D5");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setPropFrtRtAmt(strRateDry40hc);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					rtVoList.add(rt);

					if (strBucDry40hc != null && !"".equals(strBucDry40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd("D5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucDry40hc);
						scg.setAdjScgUsdAmt(strBucDry40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strIfcDry40hc != null && !"".equals(strIfcDry40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd("D5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcDry40hc);
						scg.setAdjScgUsdAmt(strIfcDry40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strPscDry40hc != null && !"".equals(strPscDry40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd("D5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscDry40hc);
						scg.setAdjScgUsdAmt(strPscDry40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
				}

				if (strRateDry45 != null && !"".equals(strRateDry45)) {
					nextRtSeq++;

					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("D7");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setPropFrtRtAmt(strRateDry45);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					rtVoList.add(rt);

					if (strBucDry45 != null && !"".equals(strBucDry45)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd("D7");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucDry45);
						scg.setAdjScgUsdAmt(strBucDry45);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strIfcDry45 != null && !"".equals(strIfcDry45)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd("D7");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcDry45);
						scg.setAdjScgUsdAmt(strIfcDry45);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strPscDry45 != null && !"".equals(strPscDry45)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd("D7");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscDry45);
						scg.setAdjScgUsdAmt(strPscDry45);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
				}

				if (strRateRf40hc != null && !"".equals(strRateRf40hc)) {
					nextRtSeq++;

					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("R5");
					rt.setPrcCgoTpCd("RF");
					rt.setCurrCd("USD");
					rt.setPropFrtRtAmt(strRateRf40hc);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					rtVoList.add(rt);

					if (strBucRf40hc != null && !"".equals(strBucRf40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd("R5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucRf40hc);
						scg.setAdjScgUsdAmt(strBucRf40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strIfcRf40hc != null && !"".equals(strIfcRf40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd("R5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcRf40hc);
						scg.setAdjScgUsdAmt(strIfcRf40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strPscRf40hc != null && !"".equals(strPscRf40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd("R5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscRf40hc);
						scg.setAdjScgUsdAmt(strPscRf40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
				}

				if (strRateRd40hc != null && !"".equals(strRateRd40hc)) {
					nextRtSeq++;

					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("R5");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setPropFrtRtAmt(strRateRd40hc);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					rtVoList.add(rt);

					if (strBucRd40hc != null && !"".equals(strBucRd40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd("R5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucRd40hc);
						scg.setAdjScgUsdAmt(strBucRd40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strIfcRd40hc != null && !"".equals(strIfcRd40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd("R5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcRd40hc);
						scg.setAdjScgUsdAmt(strIfcRd40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strPscRd40hc != null && !"".equals(strPscRd40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd("R5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscRd40hc);
						scg.setAdjScgUsdAmt(strPscRd40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
				}
			}

			if (cmdtHdrVoList.size() > 0) {
				dbDao.addRateCommodityHeader(cmdtHdrVoList);
			}
			if (cmdtVoList.size() > 0) {
				dbDao.addRateCommodity(cmdtVoList);
			}
			if (custVoList.size() > 0) {
				dbDao.addRateActualCustomer(custVoList);
			}

			if (routVoList.size() > 0) {
				dbDao.addRateCommodityRoute(routVoList);
			}
			if (pntVoList.size() > 0) {
				dbDao.addRateRoutePoint(pntVoList);
			}
			if (viaVoList.size() > 0) {
				dbDao.addRateRouteVia(viaVoList);
			}

			if (rtVoList.size() > 0) {
				dbDao.addRate(rtVoList);
			}
			if (scgVoList.size() > 0) {
				dbDao.addRateSurcharge(scgVoList);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}
	

	/**
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadMstRateExcelHorizontalOnline(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs,
			SignOnUserAccount account) throws EventException {
		List<PriRpScpRtCmdtRoutVO> routVoList = new ArrayList<PriRpScpRtCmdtRoutVO>();
		List<PriRpScpRtRoutPntVO> pntVoList = new ArrayList<PriRpScpRtRoutPntVO>();
		List<PriRpScpRtRoutViaVO> viaVoList = new ArrayList<PriRpScpRtRoutViaVO>();
		List<PriRpScpRtVO> rtVoList = new ArrayList<PriRpScpRtVO>();
		List<PriRpScpRtScgVO> scgVoList = new ArrayList<PriRpScpRtScgVO>();
		List<PriRfaNoteConvVO> noteConvVoList = new ArrayList<PriRfaNoteConvVO>();
		List<PriRpScpRtCmdtRnoteVO> rNoteVoList = new ArrayList<PriRpScpRtCmdtRnoteVO>();
		List<String> noteCtntList = new ArrayList<String>();
		List<RsltRoutHdrSmryListVO> routHdrSmryList = new ArrayList<RsltRoutHdrSmryListVO>();
		
		try {			
			int nextRoutSeq = 0;
			int insertNextRoutSeq = 0;
			int updateNextRoutSeq = 0;
			int nextCmdtHdrSeq = 1;
			int nextRoutPntSeq = 1;
			int nextRoutViaSeq = 1;
			int nextRtSeq = 0;
			int nextNoteConvSeq = 0;
			int nextRoutNoteSeq = 1;
			
			boolean routHdrSmryDiv = false;
			boolean routMaxSeqDiv = false;
			 
			String strPropNo = priRpScpRtCmdtHdrVO.getPropNo();
			String strAmdtSeq = priRpScpRtCmdtHdrVO.getAmdtSeq();
			String strSvcScpCd = priRpScpRtCmdtHdrVO.getSvcScpCd();
			String strCreUsrId = account.getUsr_id();
			String strUpdUsrId = account.getUsr_id();
			String preNoteConvMapgId = "";
		    String strNoteCtnt = "";
		    String routMaxSeq = "";
		    
			String updateStrPropNo = "";
			String updateStrAmdtSeq = "";
			String updateStrSvcScpCd = "";
			String updateNextCmdtHdrSeq = "";
			String updateStrN1stCmncAmdtSeq = "";
		    
		    for (int i = 0; i < rsltRtListHorizontalExcelVOs.length; i++) {
		    	RsltRtListHorizontalExcelVO row = rsltRtListHorizontalExcelVOs[i];
		    	
		    	String strNoteConvRuleCd = row.getNoteConvRuleCd();
		    	String strNoteConvChgCd = row.getNoteConvChgCd();
		    	
			    if (("APP".equals(strNoteConvRuleCd) && i > 0)) {
			    	noteCtntList.add(strNoteCtnt);
			    }		
			    
			    if ("APP".equals(strNoteConvRuleCd)) {			    	
			    	strNoteCtnt = "";
			    	strNoteCtnt = strNoteConvRuleCd;
			    }
			    
			    if (!"".equals(strNoteConvChgCd)) {			    	
			    	strNoteCtnt = strNoteCtnt + ", " + strNoteConvChgCd;
			    }
			    
			    if (i == rsltRtListHorizontalExcelVOs.length - 1) {
			    	noteCtntList.add(strNoteCtnt);
			    }
		    }
		    
			for (int i = 0; i < rsltRtListHorizontalExcelVOs.length; i++) {
				RsltRtListHorizontalExcelVO row = rsltRtListHorizontalExcelVOs[i];

				String strOrgPntCd = row.getOrgRoutPntLocDefCd();
				String strOrgRcvDeTermCd = row.getOrgRcvDeTermNm();
				String strOrgViaCd = row.getOrgRoutViaPortDefCd();
				String strDestViaCd = row.getDestRoutViaPortDefCd();
				String strDestPntCd = row.getDestRoutPntLocDefCd();
				String strDestRcvDeTermCd = row.getDestRcvDeTermNm();
				
				String strAppBkgDirCallFlg = row.getAppBkgDirCallFlg();
			    String strAppBkgTsPortDefCd = row.getAppBkgTsPortDefCd();
			    String strAppBkgSlanCd = row.getAppBkgSlanCd();
			    String strChgRuleDefCd = row.getChgRuleDefCd();
			    String strRtApplTpCd = row.getRtApplTpCd();
			    String strCurrCd = row.getCurrCd();
			    
				String strRateDry20 = row.getRateDry20();
				String strRateDry40 = row.getRateDry40();
				String strRateDry40hc = row.getRateDry40hc();
				
			    String strBkgRatUtCdBl = row.getBkgRatUtCdBl();
			    String strBkgRatUtCdCm = row.getBkgRatUtCdCm();
			    String strBkgRatUtCdBx = row.getBkgRatUtCdBx();
			    
			    String strConvBkgDirCallFlg = row.getConvBkgDirCallFlg();
			    String strConvBkgTsPortDefCd = row.getConvBkgTsPortDefCd();
			    String strConvBkgSlanCd = row.getConvBkgSlanCd();
			    String strPayTermCd = row.getPayTermCd();
			    String strBkgYdCd = row.getBkgYdCd();
			    String strBkgMinCgoWgt = row.getBkgMinCgoWgt();
			    String strBkgMaxCgoWgt = row.getBkgMaxCgoWgt();
			    
			    String strNoteConvMapgId = row.getNoteConvMapgId();
			    String strNoteConvTpCd = "R";
			    String strEffDt = row.getEffDt();
			    String strExpDt = row.getExpDt();
			    String strN1stCmncAmdtSeq = row.getN1stCmncAmdtSeq();
			    String strChgRuleTpCd = row.getChgRuleTpCd();
			    String strNoteConvChgCd = row.getNoteConvChgCd();
			    String strNoteConvRuleCd = row.getNoteConvRuleCd();
			    String strAppBkgVslCd = row.getAppBkgVslCd();
			    String strAppBkgSkdVoyNo = row.getAppBkgSkdVoyNo();
			    String strAppBkgSkdDirCd = row.getAppBkgSkdDirCd();
			    String strAppBkgTsPortTpCd = row.getAppBkgTsPortTpCd();
			    String strConvBkgVslCd = row.getConvBkgVslCd();
			    String strConvBkgSkdVoyNo = row.getConvBkgSkdVoyNo();
			    String strConvBkgSkdDirCd = row.getConvBkgSkdDirCd();
			    String strConvBkgTsPortTpCd = row.getConvBkgTsPortTpCd();
			    String strSrcInfoCd = row.getSrcInfoCd();
			    String strAppBkgVvdCd = row.getAppBkgVvdCd();
			    
			    RsltRoutHdrSmryListVO routSmry = new RsltRoutHdrSmryListVO();
			    
			    routSmry.setPropNo(strPropNo);
			    routSmry.setAmdtSeq(strAmdtSeq);
			    routSmry.setSvcScpCd(strSvcScpCd);
			    routSmry.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
			    routSmry.setBkgDirCallFlg(strAppBkgDirCallFlg);
			    routSmry.setBkgTsPortDefCd(strAppBkgTsPortDefCd);
			    routSmry.setBkgSlanCd(strAppBkgSlanCd);
			    routSmry.setBkgVvdCd(strAppBkgVvdCd);
			    routSmry.setOrgRoutPntLocDefCd(strOrgPntCd);
			    routSmry.setRcvDeTermCdOri(strOrgRcvDeTermCd);
			    routSmry.setOrgRoutViaPortDefCd(strOrgViaCd);
			    routSmry.setDestRoutViaPortDefCd(strDestViaCd);
			    routSmry.setDestRoutPntLocDefCd(strDestPntCd);
			    routSmry.setRcvDeTermCdDest(strDestRcvDeTermCd);

			    if (!"".equals(strOrgPntCd) && !"".equals(strOrgViaCd) 
			    	&& !"".equals(strDestViaCd) && !"".equals(strDestPntCd)) {
			    	routHdrSmryList = dbDao.searchRoutHdrSmryList(routSmry);
			    	
			    	nextRoutSeq++;
			    	
			    	if (routHdrSmryList.size() > 0) {		
				    	
				    	// Insert(false) or Update(true) 구분  
				    	routHdrSmryDiv = true;
				    	
				    	for (int j = 0; routHdrSmryList != null && j < routHdrSmryList.size(); j++) {	
					    	updateStrPropNo = routHdrSmryList.get(j).getPropNo();
					    	updateStrAmdtSeq = routHdrSmryList.get(j).getAmdtSeq();
					    	updateStrSvcScpCd = routHdrSmryList.get(j).getSvcScpCd();
					    	updateNextCmdtHdrSeq = routHdrSmryList.get(j).getCmdtHdrSeq();
					    	updateNextRoutSeq = Integer.parseInt(routHdrSmryList.get(j).getRoutSeq());
					    	updateStrN1stCmncAmdtSeq = routHdrSmryList.get(j).getN1stCmncAmdtSeq();
						}
					} else {
						// Insert(false) or Update(true) 구분 
				    	routHdrSmryDiv = false;
				    	
						PriRpScpRtCmdtRoutVO cmdtRout = new PriRpScpRtCmdtRoutVO();
				    	cmdtRout.setPropNo(strPropNo);
				    	cmdtRout.setAmdtSeq(strAmdtSeq);
				    	cmdtRout.setSvcScpCd(strSvcScpCd);
				    	
				    	routMaxSeq = dbDao.searchCmdtRoutMaxSeq(cmdtRout);
				    	if (!routMaxSeq.equals("") && !routMaxSeqDiv) {
				    		routMaxSeqDiv = true;
				    		
				    		insertNextRoutSeq = Integer.parseInt(routMaxSeq);
				    	}						
					}
			    }
			    		    
			    if (!routHdrSmryDiv) {	// Insert
					if (strOrgPntCd != null && !"".equals(strOrgPntCd)
						&& strDestPntCd != null && !"".equals(strDestPntCd)
						&& strChgRuleDefCd != null && !"".equals(strChgRuleDefCd)
						&& strRtApplTpCd != null && !"".equals(strRtApplTpCd)) {
					    
					    insertNextRoutSeq++;
					    
						nextRoutPntSeq = 1;
						nextRoutViaSeq = 1;
						nextRtSeq = 0;
						nextNoteConvSeq = 0;
						nextRoutNoteSeq = 1;
						
						PriRpScpRtCmdtRoutVO rout = new PriRpScpRtCmdtRoutVO();					
						
						rout.setPropNo(strPropNo);
						rout.setAmdtSeq(strAmdtSeq);
						rout.setSvcScpCd(strSvcScpCd);
						rout.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						rout.setRoutSeq(String.valueOf(insertNextRoutSeq));
						rout.setN1stCmncAmdtSeq(strAmdtSeq);
						rout.setCreUsrId(strCreUsrId);
						rout.setUpdUsrId(strUpdUsrId);
	
						routVoList.add(rout);						
					}
					
					if (strOrgPntCd != null && !"".equals(strOrgPntCd)
						&& strDestPntCd != null && !"".equals(strDestPntCd)
						&& strChgRuleDefCd != null && !"".equals(strChgRuleDefCd)
						&& strRtApplTpCd != null && !"".equals(strRtApplTpCd)
						&& strNoteConvMapgId != null && !"".equals(strNoteConvMapgId)) {
						
						PriRpScpRtCmdtRnoteVO rNote = new PriRpScpRtCmdtRnoteVO();
						
				    	rNote.setPropNo(strPropNo);
				    	rNote.setAmdtSeq(strAmdtSeq);
				    	rNote.setSvcScpCd(strSvcScpCd);
				    	rNote.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
				    	rNote.setRoutSeq(String.valueOf(insertNextRoutSeq));
				    	rNote.setRoutNoteSeq(String.valueOf(nextRoutNoteSeq));
				    	rNote.setNoteCtnt(noteCtntList.get((nextRoutSeq-1)));
				    	rNote.setNoteConvMapgId(strNoteConvMapgId);
				    	rNote.setPrcProgStsCd("I");
				    	rNote.setSrcInfoCd("NW");
				    	rNote.setN1stCmncAmdtSeq(strAmdtSeq);
				    	rNote.setCreUsrId(strCreUsrId);
				    	rNote.setUpdUsrId(strUpdUsrId);
				    	
				    	rNoteVoList.add(rNote);
					}
	
					if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
						
						String locTpCd = strOrgPntCd.length() == 4 ? "G" : "L";
	
						PriRpScpRtRoutPntVO pnt = new PriRpScpRtRoutPntVO();
						pnt.setPropNo(strPropNo);
						pnt.setAmdtSeq(strAmdtSeq);
						pnt.setSvcScpCd(strSvcScpCd);
						pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						pnt.setRoutSeq(String.valueOf(insertNextRoutSeq));
						pnt.setOrgDestTpCd("O");
						pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
						pnt.setRoutPntLocTpCd(locTpCd);
						pnt.setRoutPntLocDefCd(strOrgPntCd);
						pnt.setRcvDeTermCd(strOrgRcvDeTermCd);
						pnt.setPrcProgStsCd("I");
						pnt.setSrcInfoCd("NW");
						pnt.setN1stCmncAmdtSeq(strAmdtSeq);
						pnt.setCreUsrId(strCreUsrId);
						pnt.setUpdUsrId(strUpdUsrId);
	
						pntVoList.add(pnt);
					}
					if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
						
						String locTpCd = strOrgViaCd.length() == 4 ? "G" : "L";
	
						PriRpScpRtRoutViaVO via = new PriRpScpRtRoutViaVO();
						via.setPropNo(strPropNo);
						via.setAmdtSeq(strAmdtSeq);
						via.setSvcScpCd(strSvcScpCd);
						via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						via.setRoutSeq(String.valueOf(insertNextRoutSeq));
						via.setOrgDestTpCd("O");
						via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
						via.setRoutViaPortTpCd(locTpCd);
						via.setRoutViaPortDefCd(strOrgViaCd);
						via.setPrcProgStsCd("I");
						via.setSrcInfoCd("NW");
						via.setN1stCmncAmdtSeq(strAmdtSeq);
						via.setCreUsrId(strCreUsrId);
						via.setUpdUsrId(strUpdUsrId);
	
						viaVoList.add(via);
					}
					if (strDestViaCd != null && !"".equals(strDestViaCd)) {
						
						String locTpCd = strDestViaCd.length() == 4 ? "G" : "L";
	
						PriRpScpRtRoutViaVO via = new PriRpScpRtRoutViaVO();
						via.setPropNo(strPropNo);
						via.setAmdtSeq(strAmdtSeq);
						via.setSvcScpCd(strSvcScpCd);
						via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						via.setRoutSeq(String.valueOf(insertNextRoutSeq));
						via.setOrgDestTpCd("D");
						via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
						via.setRoutViaPortTpCd(locTpCd);
						via.setRoutViaPortDefCd(strDestViaCd);
						via.setPrcProgStsCd("I");
						via.setSrcInfoCd("NW");
						via.setN1stCmncAmdtSeq(strAmdtSeq);
						via.setCreUsrId(strCreUsrId);
						via.setUpdUsrId(strUpdUsrId);
	
						viaVoList.add(via);
					}
					
					if (strDestPntCd != null && !"".equals(strDestPntCd)) {
						
						String locTpCd = strDestPntCd.length() == 4 ? "G" : "L";
						
						PriRpScpRtRoutPntVO pnt = new PriRpScpRtRoutPntVO();
						pnt.setPropNo(strPropNo);
						pnt.setAmdtSeq(strAmdtSeq);
						pnt.setSvcScpCd(strSvcScpCd);
						pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						pnt.setRoutSeq(String.valueOf(insertNextRoutSeq));
						pnt.setOrgDestTpCd("D");
						pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
						pnt.setRoutPntLocTpCd(locTpCd);
						pnt.setRoutPntLocDefCd(strDestPntCd);
						pnt.setRcvDeTermCd(strDestRcvDeTermCd);
						pnt.setPrcProgStsCd("I");
						pnt.setSrcInfoCd("NW");
						pnt.setN1stCmncAmdtSeq(strAmdtSeq);
						pnt.setCreUsrId(strCreUsrId);
						pnt.setUpdUsrId(strUpdUsrId);
	
						pntVoList.add(pnt);
					}
	
					if (strRateDry20 != null && !"".equals(strRateDry20) && "OFT".equals(strChgRuleDefCd)) {
						nextRtSeq++;
						
						PriRpScpRtVO rt = new PriRpScpRtVO();
						rt.setPropNo(strPropNo);
						rt.setAmdtSeq(strAmdtSeq);
						rt.setSvcScpCd(strSvcScpCd);
						rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						rt.setRoutSeq(String.valueOf(insertNextRoutSeq));
						rt.setRtSeq(String.valueOf(nextRtSeq));
						rt.setRatUtCd("D2");
						rt.setPrcCgoTpCd("DR");
						rt.setCurrCd("USD");
						rt.setPropFrtRtAmt(strRateDry20);
						rt.setGriApplTpCd("N");
						rt.setGriApplAmt("0");
						rt.setPrcProgStsCd("I");
						rt.setSrcInfoCd("NW");
						rt.setN1stCmncAmdtSeq(strAmdtSeq);
						rt.setCreUsrId(strCreUsrId);
						rt.setUpdUsrId(strUpdUsrId);
	
						rtVoList.add(rt);
					}
	
					if (strRateDry40 != null && !"".equals(strRateDry40) && "OFT".equals(strChgRuleDefCd)) {
						nextRtSeq++;
						
						PriRpScpRtVO rt = new PriRpScpRtVO();
						rt.setPropNo(strPropNo);
						rt.setAmdtSeq(strAmdtSeq);
						rt.setSvcScpCd(strSvcScpCd);
						rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						rt.setRoutSeq(String.valueOf(insertNextRoutSeq));
						rt.setRtSeq(String.valueOf(nextRtSeq));
						rt.setRatUtCd("D4");
						rt.setPrcCgoTpCd("DR");
						rt.setCurrCd("USD");
						rt.setPropFrtRtAmt(strRateDry40);
						rt.setGriApplTpCd("N");
						rt.setGriApplAmt("0");
						rt.setPrcProgStsCd("I");
						rt.setSrcInfoCd("NW");
						rt.setN1stCmncAmdtSeq(strAmdtSeq);
						rt.setCreUsrId(strCreUsrId);
						rt.setUpdUsrId(strUpdUsrId);
	
						rtVoList.add(rt);
					}
	
					if (strRateDry40hc != null && !"".equals(strRateDry40hc) && "OFT".equals(strChgRuleDefCd)) {
						nextRtSeq++;
						
						PriRpScpRtVO rt = new PriRpScpRtVO();
						rt.setPropNo(strPropNo);
						rt.setAmdtSeq(strAmdtSeq);
						rt.setSvcScpCd(strSvcScpCd);
						rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						rt.setRoutSeq(String.valueOf(insertNextRoutSeq));
						rt.setRtSeq(String.valueOf(nextRtSeq));
						rt.setRatUtCd("D5");
						rt.setPrcCgoTpCd("DR");
						rt.setCurrCd("USD");
						rt.setPropFrtRtAmt(strRateDry40hc);
						rt.setGriApplTpCd("N");
						rt.setGriApplAmt("0");
						rt.setPrcProgStsCd("I");
						rt.setSrcInfoCd("NW");
						rt.setN1stCmncAmdtSeq(strAmdtSeq);
						rt.setCreUsrId(strCreUsrId);
						rt.setUpdUsrId(strUpdUsrId);
	
						rtVoList.add(rt);
					}
		
					// APP Charge
					if (strNoteConvMapgId != null && !"".equals(strNoteConvMapgId) && "OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
				    	
				    	noteConv.setNoteConvMapgId(strNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(strPropNo);
				    	noteConv.setAmdtSeq(strAmdtSeq);
				    	noteConv.setSvcScpCd(strSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd("");
				    	noteConv.setFrtRtAmt("");
				    	noteConv.setPayTermCd("");
				    	noteConv.setBkgRatUtCd("");
				    	noteConv.setBkgPrcCgoTpCd("");
				    	noteConv.setBkgSlanCd(strAppBkgSlanCd);
				    	noteConv.setBkgVslCd(strAppBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strAppBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strAppBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt("");
				    	noteConv.setBkgMaxCgoWgt("");
				    	noteConv.setBkgTsPortTpCd(strAppBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strAppBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strAppBkgDirCallFlg);
				    	noteConv.setBkgYdCd("");
				    	noteConv.setSrcInfoCd("NW");
				    	noteConv.setN1stCmncAmdtSeq(strAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    	
				    	noteConvVoList.add(noteConv);
				    }
					
				    if (   strNoteConvMapgId != null && !"".equals(strNoteConvMapgId) 
				    	&& strRateDry20 != null && !"".equals(strRateDry20) && !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
				    	
				    	noteConv.setNoteConvMapgId(strNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(strPropNo);
				    	noteConv.setAmdtSeq(strAmdtSeq);
				    	noteConv.setSvcScpCd(strSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd(strCurrCd);
				    	noteConv.setFrtRtAmt(strRateDry20);
				    	noteConv.setPayTermCd(strPayTermCd);
				    	noteConv.setBkgRatUtCd("D2");
				    	noteConv.setBkgPrcCgoTpCd("DR");
				    	noteConv.setBkgSlanCd(strConvBkgSlanCd);
				    	noteConv.setBkgVslCd(strConvBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strConvBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strConvBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strConvBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strConvBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strConvBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd("NW");
				    	noteConv.setN1stCmncAmdtSeq(strAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    				    	
				    	noteConvVoList.add(noteConv);			    	
				    }
				    
				    if (   strNoteConvMapgId != null && !"".equals(strNoteConvMapgId) 
				    	&& strRateDry40 != null && !"".equals(strRateDry40) && !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
				    	
				    	noteConv.setNoteConvMapgId(strNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(strPropNo);
				    	noteConv.setAmdtSeq(strAmdtSeq);
				    	noteConv.setSvcScpCd(strSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd(strCurrCd);
				    	noteConv.setFrtRtAmt(strRateDry40);
				    	noteConv.setPayTermCd(strPayTermCd);
				    	noteConv.setBkgRatUtCd("D4");
				    	noteConv.setBkgPrcCgoTpCd("DR");
				    	noteConv.setBkgSlanCd(strConvBkgSlanCd);
				    	noteConv.setBkgVslCd(strConvBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strConvBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strConvBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strConvBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strConvBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strConvBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd("NW");
				    	noteConv.setN1stCmncAmdtSeq(strAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    	
				    	noteConvVoList.add(noteConv);
				    }
				    
				    if (   strNoteConvMapgId != null && !"".equals(strNoteConvMapgId) 
				    	&& strRateDry40hc != null && !"".equals(strRateDry40hc) && !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
				    	
				    	noteConv.setNoteConvMapgId(strNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(strPropNo);
				    	noteConv.setAmdtSeq(strAmdtSeq);
				    	noteConv.setSvcScpCd(strSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd(strCurrCd);
				    	noteConv.setFrtRtAmt(strRateDry40hc);
				    	noteConv.setPayTermCd(strPayTermCd);
				    	noteConv.setBkgRatUtCd("D5");
				    	noteConv.setBkgPrcCgoTpCd("DR");
				    	noteConv.setBkgSlanCd(strConvBkgSlanCd);
				    	noteConv.setBkgVslCd(strConvBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strConvBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strConvBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strConvBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strConvBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strConvBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd("NW");
				    	noteConv.setN1stCmncAmdtSeq(strAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    	
				    	noteConvVoList.add(noteConv);
				    }
				    
				    if (   strNoteConvMapgId != null && !"".equals(strNoteConvMapgId) 
				    	&& strBkgRatUtCdBl != null && !"".equals(strBkgRatUtCdBl) && !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
				    	
				    	noteConv.setNoteConvMapgId(strNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(strPropNo);
				    	noteConv.setAmdtSeq(strAmdtSeq);
				    	noteConv.setSvcScpCd(strSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd(strCurrCd);
				    	noteConv.setFrtRtAmt(strBkgRatUtCdBl);
				    	noteConv.setPayTermCd(strPayTermCd);
				    	noteConv.setBkgRatUtCd("BL");
				    	noteConv.setBkgPrcCgoTpCd("DR");
				    	noteConv.setBkgSlanCd(strConvBkgSlanCd);
				    	noteConv.setBkgVslCd(strConvBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strConvBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strConvBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strConvBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strConvBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strConvBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd("NW");
				    	noteConv.setN1stCmncAmdtSeq(strAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    	
				    	noteConvVoList.add(noteConv);
				    }
				    
				    if (   strNoteConvMapgId != null && !"".equals(strNoteConvMapgId) 
				    	&& strBkgRatUtCdCm != null && !"".equals(strBkgRatUtCdCm) && !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
				    	
				    	noteConv.setNoteConvMapgId(strNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(strPropNo);
				    	noteConv.setAmdtSeq(strAmdtSeq);
				    	noteConv.setSvcScpCd(strSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd(strCurrCd);
				    	noteConv.setFrtRtAmt(strBkgRatUtCdCm);
				    	noteConv.setPayTermCd(strPayTermCd);
				    	noteConv.setBkgRatUtCd("CM");
				    	noteConv.setBkgPrcCgoTpCd("DR");
				    	noteConv.setBkgSlanCd(strConvBkgSlanCd);
				    	noteConv.setBkgVslCd(strConvBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strConvBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strConvBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strConvBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strConvBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strConvBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd("NW");
				    	noteConv.setN1stCmncAmdtSeq(strAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    	
				    	noteConvVoList.add(noteConv);
				    }
				    
				    if (   strNoteConvMapgId != null && !"".equals(strNoteConvMapgId) 
				    	&& strBkgRatUtCdBx != null && !"".equals(strBkgRatUtCdBx) && !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
	
				    	noteConv.setNoteConvMapgId(strNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(strPropNo);
				    	noteConv.setAmdtSeq(strAmdtSeq);
				    	noteConv.setSvcScpCd(strSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd(strCurrCd);
				    	noteConv.setFrtRtAmt(strBkgRatUtCdBx);
				    	noteConv.setPayTermCd(strPayTermCd);
				    	noteConv.setBkgRatUtCd("BX");
				    	noteConv.setBkgPrcCgoTpCd("DR");
				    	noteConv.setBkgSlanCd(strConvBkgSlanCd);
				    	noteConv.setBkgVslCd(strConvBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strConvBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strConvBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strConvBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strConvBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strConvBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd("NW");
				    	noteConv.setN1stCmncAmdtSeq(strAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    	
				    	noteConvVoList.add(noteConv);			    	
				    }
				    
				    // Include or Subject
				    if (   strNoteConvMapgId != null && !"".equals(strNoteConvMapgId) 
				    	&& "".equals(strRateDry20) && "".equals(strRateDry40)
				    	&& "".equals(strRateDry40hc) && "".equals(strBkgRatUtCdBl)
						&& "".equals(strBkgRatUtCdCm) && "".equals(strBkgRatUtCdBx)
						&& !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
				    	
				    	noteConv.setNoteConvMapgId(strNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(strPropNo);
				    	noteConv.setAmdtSeq(strAmdtSeq);
				    	noteConv.setSvcScpCd(strSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd("");
				    	noteConv.setFrtRtAmt("");
				    	noteConv.setPayTermCd("");
				    	noteConv.setBkgRatUtCd("");
				    	noteConv.setBkgPrcCgoTpCd("");
				    	noteConv.setBkgSlanCd(strAppBkgSlanCd);
				    	noteConv.setBkgVslCd(strAppBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strAppBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strAppBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strAppBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strAppBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strAppBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd("NW");
				    	noteConv.setN1stCmncAmdtSeq(strAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    	
				    	noteConvVoList.add(noteConv);
				    }				    
			    } else {	// Update			    	
			    	if (strOrgPntCd != null && !"".equals(strOrgPntCd)
						&& strDestPntCd != null && !"".equals(strDestPntCd)
						&& strChgRuleDefCd != null && !"".equals(strChgRuleDefCd)
						&& strRtApplTpCd != null && !"".equals(strRtApplTpCd)) {
					    
						nextRoutPntSeq = 1;
						nextRoutViaSeq = 1;
						nextRtSeq = 0;
						nextNoteConvSeq = 1;
						nextRoutNoteSeq = 1;
						
						PriRpScpRtCmdtRnoteVO rNote = new PriRpScpRtCmdtRnoteVO();
						rNote.setPropNo(updateStrPropNo);
						rNote.setAmdtSeq(updateStrAmdtSeq);
						rNote.setSvcScpCd(updateStrSvcScpCd);
						rNote.setRoutSeq(String.valueOf(updateNextRoutSeq));
						
						// 기존 Mapping ID
						preNoteConvMapgId = dbDao.searchMstRateCommodityRnoteMapgId(rNote);

						// APP를 제외한 나머지 Conversion 삭제 (Amend 처리가 힘드니 삭제하고 Insert 하기로 협의)
						if (preNoteConvMapgId != null && !"".equals(preNoteConvMapgId)) {
							PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
							
							noteConv.setNoteConvMapgId(preNoteConvMapgId);
							noteConv.setPropNo(strPropNo);
							noteConv.setAmdtSeq(strAmdtSeq);
							noteConv.setSvcScpCd(strSvcScpCd);
							
							// Note Conversion Delete
							dbDao.removeMstNoteConversion(noteConv);
						}		
					}
					
					// Rate Update
					if (strRateDry20 != null && !"".equals(strRateDry20) && "OFT".equals(strChgRuleDefCd)) {
						nextRtSeq++;
						
						PriRpScpRtVO rt = new PriRpScpRtVO();
						rt.setPropNo(updateStrPropNo);
						rt.setAmdtSeq(updateStrAmdtSeq);
						rt.setSvcScpCd(updateStrSvcScpCd);
						rt.setCmdtHdrSeq(String.valueOf(updateNextCmdtHdrSeq));
						rt.setRoutSeq(String.valueOf(updateNextRoutSeq));
						rt.setRtSeq(String.valueOf(nextRtSeq));
						rt.setRatUtCd("D2");
						rt.setPrcCgoTpCd("DR");
						rt.setCurrCd("USD");
						rt.setPropFrtRtAmt(strRateDry20);
						rt.setGriApplTpCd("N");
						rt.setGriApplAmt("0");
						rt.setPrcProgStsCd("I");
						if(updateStrAmdtSeq.equals(updateStrN1stCmncAmdtSeq) && strSrcInfoCd.equals("AM")) {
							rt.setSrcInfoCd("AM");
						} else if( !updateStrAmdtSeq.equals(updateStrN1stCmncAmdtSeq)) {
							rt.setSrcInfoCd("AM");
						} else {
							rt.setSrcInfoCd("NW");
						}
						rt.setN1stCmncAmdtSeq(updateStrAmdtSeq);
						rt.setCreUsrId(strCreUsrId);
						rt.setUpdUsrId(strUpdUsrId);
						rtVoList.add(rt);
					}
	
					if (strRateDry40 != null && !"".equals(strRateDry40) && "OFT".equals(strChgRuleDefCd)) {
						nextRtSeq++;
						
						PriRpScpRtVO rt = new PriRpScpRtVO();
						rt.setPropNo(updateStrPropNo);
						rt.setAmdtSeq(updateStrAmdtSeq);
						rt.setSvcScpCd(updateStrSvcScpCd);
						rt.setCmdtHdrSeq(String.valueOf(updateNextCmdtHdrSeq));
						rt.setRoutSeq(String.valueOf(updateNextRoutSeq));
						rt.setRtSeq(String.valueOf(nextRtSeq));
						rt.setRatUtCd("D4");
						rt.setPrcCgoTpCd("DR");
						rt.setCurrCd("USD");
						rt.setPropFrtRtAmt(strRateDry40);
						rt.setGriApplTpCd("N");
						rt.setGriApplAmt("0");
						rt.setPrcProgStsCd("I");
						if(updateStrAmdtSeq.equals(updateStrN1stCmncAmdtSeq) && strSrcInfoCd.equals("AM")) {
							rt.setSrcInfoCd("AM");
						} else if( !updateStrAmdtSeq.equals(updateStrN1stCmncAmdtSeq)) {
							rt.setSrcInfoCd("AM");
						} else {
							rt.setSrcInfoCd("NW");
						}
						rt.setN1stCmncAmdtSeq(updateStrAmdtSeq);
						rt.setCreUsrId(strCreUsrId);
						rt.setUpdUsrId(strUpdUsrId);
	
						rtVoList.add(rt);
					}
	
					if (strRateDry40hc != null && !"".equals(strRateDry40hc) && "OFT".equals(strChgRuleDefCd)) {
						nextRtSeq++;
						
						PriRpScpRtVO rt = new PriRpScpRtVO();
						rt.setPropNo(updateStrPropNo);
						rt.setAmdtSeq(updateStrAmdtSeq);
						rt.setSvcScpCd(updateStrSvcScpCd);
						rt.setCmdtHdrSeq(String.valueOf(updateNextCmdtHdrSeq));
						rt.setRoutSeq(String.valueOf(updateNextRoutSeq));
						rt.setRtSeq(String.valueOf(nextRtSeq));
						rt.setRatUtCd("D5");
						rt.setPrcCgoTpCd("DR");
						rt.setCurrCd("USD");
						rt.setPropFrtRtAmt(strRateDry40hc);
						rt.setGriApplTpCd("N");
						rt.setGriApplAmt("0");
						rt.setPrcProgStsCd("I");
						if(updateStrAmdtSeq.equals(updateStrN1stCmncAmdtSeq) && strSrcInfoCd.equals("AM")) {
							rt.setSrcInfoCd("AM");
						} else if( !updateStrAmdtSeq.equals(updateStrN1stCmncAmdtSeq)) {
							rt.setSrcInfoCd("AM");
						} else {
							rt.setSrcInfoCd("NW");
						}
						rt.setN1stCmncAmdtSeq(updateStrAmdtSeq);
						rt.setCreUsrId(strCreUsrId);
						rt.setUpdUsrId(strUpdUsrId);
	
						rtVoList.add(rt);
					}
					
					// Conversion Insert
				    if (   preNoteConvMapgId != null && !"".equals(preNoteConvMapgId) 
				    	&& strRateDry20 != null && !"".equals(strRateDry20) && !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
				    	
				    	noteConv.setNoteConvMapgId(preNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(updateStrPropNo);
				    	noteConv.setAmdtSeq(updateStrAmdtSeq);
				    	noteConv.setSvcScpCd(updateStrSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd(strCurrCd);
				    	noteConv.setFrtRtAmt(strRateDry20);
				    	noteConv.setPayTermCd(strPayTermCd);
				    	noteConv.setBkgRatUtCd("D2");
				    	noteConv.setBkgPrcCgoTpCd("DR");
				    	noteConv.setBkgSlanCd(strConvBkgSlanCd);
				    	noteConv.setBkgVslCd(strConvBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strConvBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strConvBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strConvBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strConvBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strConvBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd(strSrcInfoCd);
				    	noteConv.setN1stCmncAmdtSeq(strN1stCmncAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    				    	
				    	noteConvVoList.add(noteConv);			    	
				    }
				    
				    if (   preNoteConvMapgId != null && !"".equals(preNoteConvMapgId) 
				    	&& strRateDry40 != null && !"".equals(strRateDry40) && !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
				    	
				    	noteConv.setNoteConvMapgId(preNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(updateStrPropNo);
				    	noteConv.setAmdtSeq(updateStrAmdtSeq);
				    	noteConv.setSvcScpCd(updateStrSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd(strCurrCd);
				    	noteConv.setFrtRtAmt(strRateDry40);
				    	noteConv.setPayTermCd(strPayTermCd);
				    	noteConv.setBkgRatUtCd("D4");
				    	noteConv.setBkgPrcCgoTpCd("DR");
				    	noteConv.setBkgSlanCd(strConvBkgSlanCd);
				    	noteConv.setBkgVslCd(strConvBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strConvBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strConvBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strConvBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strConvBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strConvBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd(strSrcInfoCd);
				    	noteConv.setN1stCmncAmdtSeq(strN1stCmncAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    	
				    	noteConvVoList.add(noteConv);
				    }
				    
				    if (   preNoteConvMapgId != null && !"".equals(preNoteConvMapgId) 
				    	&& strRateDry40hc != null && !"".equals(strRateDry40hc) && !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
				    	
				    	noteConv.setNoteConvMapgId(preNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(updateStrPropNo);
				    	noteConv.setAmdtSeq(updateStrAmdtSeq);
				    	noteConv.setSvcScpCd(updateStrSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd(strCurrCd);
				    	noteConv.setFrtRtAmt(strRateDry40hc);
				    	noteConv.setPayTermCd(strPayTermCd);
				    	noteConv.setBkgRatUtCd("D5");
				    	noteConv.setBkgPrcCgoTpCd("DR");
				    	noteConv.setBkgSlanCd(strConvBkgSlanCd);
				    	noteConv.setBkgVslCd(strConvBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strConvBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strConvBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strConvBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strConvBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strConvBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd(strSrcInfoCd);
				    	noteConv.setN1stCmncAmdtSeq(strN1stCmncAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    	
				    	noteConvVoList.add(noteConv);
				    }
				    
				    if (   preNoteConvMapgId != null && !"".equals(preNoteConvMapgId) 
				    	&& strBkgRatUtCdBl != null && !"".equals(strBkgRatUtCdBl) && !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
				    	
				    	noteConv.setNoteConvMapgId(preNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(updateStrPropNo);
				    	noteConv.setAmdtSeq(updateStrAmdtSeq);
				    	noteConv.setSvcScpCd(updateStrSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd(strCurrCd);
				    	noteConv.setFrtRtAmt(strBkgRatUtCdBl);
				    	noteConv.setPayTermCd(strPayTermCd);
				    	noteConv.setBkgRatUtCd("BL");
				    	noteConv.setBkgPrcCgoTpCd("DR");
				    	noteConv.setBkgSlanCd(strConvBkgSlanCd);
				    	noteConv.setBkgVslCd(strConvBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strConvBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strConvBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strConvBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strConvBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strConvBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd(strSrcInfoCd);
				    	noteConv.setN1stCmncAmdtSeq(strN1stCmncAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    	
				    	noteConvVoList.add(noteConv);
				    }
				    
				    if (   preNoteConvMapgId != null && !"".equals(preNoteConvMapgId) 
				    	&& strBkgRatUtCdCm != null && !"".equals(strBkgRatUtCdCm) && !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
				    	
				    	noteConv.setNoteConvMapgId(preNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(updateStrPropNo);
				    	noteConv.setAmdtSeq(updateStrAmdtSeq);
				    	noteConv.setSvcScpCd(updateStrSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd(strCurrCd);
				    	noteConv.setFrtRtAmt(strBkgRatUtCdCm);
				    	noteConv.setPayTermCd(strPayTermCd);
				    	noteConv.setBkgRatUtCd("CM");
				    	noteConv.setBkgPrcCgoTpCd("DR");
				    	noteConv.setBkgSlanCd(strConvBkgSlanCd);
				    	noteConv.setBkgVslCd(strConvBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strConvBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strConvBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strConvBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strConvBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strConvBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd(strSrcInfoCd);
				    	noteConv.setN1stCmncAmdtSeq(strN1stCmncAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    	
				    	noteConvVoList.add(noteConv);
				    }
				    
				    if (   preNoteConvMapgId != null && !"".equals(preNoteConvMapgId) 
				    	&& strBkgRatUtCdBx != null && !"".equals(strBkgRatUtCdBx) && !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
	
				    	noteConv.setNoteConvMapgId(preNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(updateStrPropNo);
				    	noteConv.setAmdtSeq(updateStrAmdtSeq);
				    	noteConv.setSvcScpCd(updateStrSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd(strCurrCd);
				    	noteConv.setFrtRtAmt(strBkgRatUtCdBx);
				    	noteConv.setPayTermCd(strPayTermCd);
				    	noteConv.setBkgRatUtCd("BX");
				    	noteConv.setBkgPrcCgoTpCd("DR");
				    	noteConv.setBkgSlanCd(strConvBkgSlanCd);
				    	noteConv.setBkgVslCd(strConvBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strConvBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strConvBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt(strBkgMinCgoWgt);
				    	noteConv.setBkgMaxCgoWgt(strBkgMaxCgoWgt);
				    	noteConv.setBkgTsPortTpCd(strConvBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strConvBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strConvBkgDirCallFlg);
				    	noteConv.setBkgYdCd(strBkgYdCd);
				    	noteConv.setSrcInfoCd(strSrcInfoCd);
				    	noteConv.setN1stCmncAmdtSeq(strN1stCmncAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    	
				    	noteConvVoList.add(noteConv);			    	
				    }
				    
				    // Include & Subject
				    if (   preNoteConvMapgId != null && !"".equals(preNoteConvMapgId) 
				    	&& "".equals(strRateDry20) && "".equals(strRateDry40)
				    	&& "".equals(strRateDry40hc) && "".equals(strBkgRatUtCdBl)
						&& "".equals(strBkgRatUtCdCm) && "".equals(strBkgRatUtCdBx)
						&& !"OFT".equals(strChgRuleDefCd)) {
				    	nextNoteConvSeq++;
				    	
				    	PriRfaNoteConvVO noteConv = new PriRfaNoteConvVO();
				    	
				    	noteConv.setNoteConvMapgId(preNoteConvMapgId);
				    	noteConv.setNoteConvSeq(String.valueOf(nextNoteConvSeq));
				    	noteConv.setNoteConvTpCd(strNoteConvTpCd);
				    	noteConv.setPropNo(updateStrPropNo);
				    	noteConv.setAmdtSeq(updateStrAmdtSeq);
				    	noteConv.setSvcScpCd(updateStrSvcScpCd);
				    	noteConv.setChgRuleTpCd(strChgRuleTpCd);
				    	noteConv.setNoteConvChgCd(strNoteConvChgCd);
				    	noteConv.setNoteConvRuleCd(strNoteConvRuleCd);
				    	noteConv.setEffDt(strEffDt);
				    	noteConv.setExpDt(strExpDt);
				    	noteConv.setRtApplTpCd(strRtApplTpCd);
				    	noteConv.setCurrCd("");
				    	noteConv.setFrtRtAmt("");
				    	noteConv.setPayTermCd("");
				    	noteConv.setBkgRatUtCd("");
				    	noteConv.setBkgPrcCgoTpCd("");
				    	noteConv.setBkgSlanCd(strAppBkgSlanCd);
				    	noteConv.setBkgVslCd(strAppBkgVslCd);
				    	noteConv.setBkgSkdVoyNo(strAppBkgSkdVoyNo);
				    	noteConv.setBkgSkdDirCd(strAppBkgSkdDirCd);
				    	noteConv.setBkgMinCgoWgt("");
				    	noteConv.setBkgMaxCgoWgt("");
				    	noteConv.setBkgTsPortTpCd(strAppBkgTsPortTpCd);
				    	noteConv.setBkgTsPortDefCd(strAppBkgTsPortDefCd);
				    	noteConv.setBkgDirCallFlg(strAppBkgDirCallFlg);
				    	noteConv.setBkgYdCd("");
				    	noteConv.setSrcInfoCd(strSrcInfoCd);
				    	noteConv.setN1stCmncAmdtSeq(strN1stCmncAmdtSeq);
				    	noteConv.setCreUsrId(strCreUsrId);
				    	noteConv.setUpdUsrId(strUpdUsrId);
				    	
				    	noteConvVoList.add(noteConv);
				    }			    	
				    routMaxSeqDiv = false;
			    }			    
			}			
			
			if (routVoList.size() > 0) {
				dbDao.addMstRateCommodityRoute(routVoList);
			}
			
			if (pntVoList.size() > 0) {
				dbDao.addMstRateRoutePoint(pntVoList);
			}
			
			if (viaVoList.size() > 0) {
				dbDao.addMstRateRouteVia(viaVoList);
			}

			if (rtVoList.size() > 0) {
				dbDao.addMstRate(rtVoList);
			}
			
			if (scgVoList.size() > 0) {
				dbDao.addMstRateSurcharge(scgVoList);
			}
			
			if (noteConvVoList.size() > 0) {
				dbDao.addMstNoteConversion(noteConvVoList);
			}

			if (rNoteVoList.size() > 0) {
				dbDao.addMstRateCommodityRnote(rNoteVoList);
			}
			
			// Rate에 Amend가 있다는것을 알려주기 위함.
			RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();
            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
            smryVO.setPropNo(strPropNo);
            smryVO.setAmdtSeq(strAmdtSeq);
            smryVO.setSvcScpCd(strSvcScpCd);
            smryVO.setPropScpTermTpCd("71");
            cmdMain.manageScopeAmendmentSummary(smryVO, account);
            
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	// /////////////////////////// 박성수 수정 종료 ///////////////////////////////////////

	// // 이건 몰까... DAO에는 있는데... 마킹은 안되어 있네... 일단 냅둬보자... /////

	// /// 여기까지 일단 냅둬보자... /////////////////////////////////////////////////

	// ///////////////공백진수정 시작////////////////////////////////////////////////////

	/**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpScpMnVO[] priRpScpMnVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpMnVO> updateVoList = new ArrayList<PriRpScpMnVO>();

			for (int i = 0; priRpScpMnVOs != null && i < priRpScpMnVOs.length; i++) {
				priRpScpMnVOs[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(priRpScpMnVOs[i]);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyProposalRtActCustReqCnl(updateVoList);
				dbDao.modifyProposalRtCmdtReqCnl(updateVoList);
				dbDao.modifyProposalRtCmdtRnoteReqCnl(updateVoList);
				dbDao.modifyProposalRtCnoteReqCnl(updateVoList);
				dbDao.modifyProposalRtReqCnl(updateVoList);
				dbDao.modifyProposalRtRoutePntReqCnl(updateVoList);
				dbDao.modifyProposalRtRouteViaReqCnl(updateVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Amend Request를 처리합니다.<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException {
		try {

			List<PriRpMnVO> insertVoList = new ArrayList<PriRpMnVO>();

			priRpMnVO.setCreUsrId(account.getUsr_id());
			priRpMnVO.setUpdUsrId(account.getUsr_id());
			insertVoList.add(priRpMnVO);

			dbDao.addRateCommodityHeaderAmend(insertVoList);
			dbDao.addRateActualCustomerAmend(insertVoList);
			dbDao.addRateCnoteAmend(insertVoList);
			dbDao.addRateCommodityAmend(insertVoList);
			dbDao.addRateCommodityRouteAmend(insertVoList);
			dbDao.addRateAmend(insertVoList);
			dbDao.addRateCommodityRnoteAmend(insertVoList);
			dbDao.addRateRoutePointAmend(insertVoList);
			dbDao.addRateRouteViaAmend(insertVoList);
			dbDao.addRateSurchargeAmend(insertVoList);
			dbDao.addRateSurchargeRouteAmend(insertVoList);
			dbDao.addRateSurchargeUSCRouteAmend(insertVoList);
			dbDao.addRateCargoSpecAmend(insertVoList);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	// ///////////////공백진수정 종료////////////////////////////////////////////////////

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// 송민석 변경 내용 시작

	/**
	 * Surcharge Adjust List 확인하는 데이터<br>
	 * 
	 * @param RsltPriSurchargeAdjustListVO schPriSurchargeAdjustListVO
	 * @return List<RsltPriSurchargeAdjustListVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustListVO> searchSurchargeAdjustList(RsltPriSurchargeAdjustListVO schPriSurchargeAdjustListVO) throws EventException {
		try {
			return dbDao.searchSurchargeAdjustList(schPriSurchargeAdjustListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Surcharge Adjust 대한 멀티 이벤트 처리<br>
	 * 
	 * @param PriRpScpScgAdjVO[] priSpScpScgAdjVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSurchargeAdjust(PriRpScpScgAdjVO[] priSpScpScgAdjVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpScgAdjVO> insertVoList = new ArrayList<PriRpScpScgAdjVO>();
			List<PriRpScpScgAdjVO> updateVoList = new ArrayList<PriRpScpScgAdjVO>();
			List<PriRpScpScgAdjVO> deleteVoList = new ArrayList<PriRpScpScgAdjVO>();

			for (int i = 0; i < priSpScpScgAdjVOs.length; i++) {
				if (priSpScpScgAdjVOs[i].getIbflag().equals("I")) {
					priSpScpScgAdjVOs[i].setCreUsrId(account.getUsr_id());
					priSpScpScgAdjVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priSpScpScgAdjVOs[i]);
				} else if (priSpScpScgAdjVOs[i].getIbflag().equals("U")) {
					priSpScpScgAdjVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSpScpScgAdjVOs[i]);
				} else if (priSpScpScgAdjVOs[i].getIbflag().equals("D")) {
					priSpScpScgAdjVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(priSpScpScgAdjVOs[i]);
				}
			}

			if (deleteVoList.size() > 0) {
				dbDao.removeSurchargeAdjust(deleteVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifySurchargeAdjust(updateVoList);
			}
			if (insertVoList.size() > 0) {
				dbDao.addSurchargeAdjust(insertVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PRS- Surcharge Adjust 내용을 바탕으로 calc 로직을 수행 합니다.<br>
	 * 
	 * @param PriRpScpScgAdjVO priRpScpScgAdjVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSurchargeAdjustCalc(PriRpScpScgAdjVO priRpScpScgAdjVO, SignOnUserAccount account) throws EventException {
		PriRpScpScgAdjVO tmpPriRpScpScgAdjVO = new PriRpScpScgAdjVO();
		RsltPriPrsCostListVO rsltPriPrsCostListVO = null;
		PriRpScpRtScgVO priRpScpRtScgVo = null;
		try {
			if (tmpPriRpScpScgAdjVO != null) {
				rsltPriPrsCostListVO = new RsltPriPrsCostListVO();
				rsltPriPrsCostListVO.setUpdUsrId(account.getUsr_id());
				rsltPriPrsCostListVO.setPropNo(priRpScpScgAdjVO.getPropNo());
				rsltPriPrsCostListVO.setAmdtSeq(priRpScpScgAdjVO.getAmdtSeq());
				rsltPriPrsCostListVO.setSvcScpCd(priRpScpScgAdjVO.getSvcScpCd());

				priRpScpRtScgVo = new PriRpScpRtScgVO();
				priRpScpRtScgVo.setUpdUsrId(account.getUsr_id());
				priRpScpRtScgVo.setPropNo(priRpScpScgAdjVO.getPropNo());
				priRpScpRtScgVo.setAmdtSeq(priRpScpScgAdjVO.getAmdtSeq());
				priRpScpRtScgVo.setSvcScpCd(priRpScpScgAdjVO.getSvcScpCd());

				// Calc의 일부 로직
				dbDao.addPriRpScpRtScgAmtCostDetail(rsltPriPrsCostListVO, "1");// mergePRI_RP_SCP_RT_SCG
				dbDao.modifyPrsRateSurchargeCmpb(priRpScpRtScgVo, "1");
				dbDao.modifyPrsRateCmdtRoutCmpb(priRpScpRtScgVo, "1");
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Surcharge Adjust-Commodity 조회 처리<br>
	 * Commodity Group 선택 리스트 조회 이벤트 처리<br>
	 * 
	 * @param RsltPriSurchargeAdjustCommodityVO rsltPriSurchargeAdjustCommodityVO
	 * @return List<RsltPriSurchargeAdjustCommodityVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustCommodityVO> searchRateCommodityAllList(RsltPriSurchargeAdjustCommodityVO rsltPriSurchargeAdjustCommodityVO) throws EventException {
		try {
			return dbDao.searchRateCommodityAllList(rsltPriSurchargeAdjustCommodityVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Surcharge Adjust-Commodity 조회 처리<br>
	 * Commodity 상세 리스트 조회 이벤트 처리<br>
	 * 
	 * @param RsltPriSurchargeAdjustCommodityDetailVO rsltPriSurchargeAdjustCommodityDetailVO
	 * @return List<RsltPriSurchargeAdjustCommodityDetailVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustCommodityDetailVO> searchRateGroupCommodityDetailList(
			RsltPriSurchargeAdjustCommodityDetailVO rsltPriSurchargeAdjustCommodityDetailVO) throws EventException {
		try {
			return dbDao.searchRateGroupCommodityDetailList(rsltPriSurchargeAdjustCommodityDetailVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Surcharge Adjust-Location 조회 처리<br>
	 * Location Group 선택 리스트 조회 이벤트 처리<br>
	 * 
	 * @param RsltPriSurchargeAdjustLocationGroupVO rsltPriSurchargeAdjustLocationGroupVO
	 * @return List<RsltPriSurchargeAdjustLocationGroupVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustLocationGroupVO> searchRateLocationAllList(RsltPriSurchargeAdjustLocationGroupVO rsltPriSurchargeAdjustLocationGroupVO)
			throws EventException {
		try {
			return dbDao.searchRateLocationAllList(rsltPriSurchargeAdjustLocationGroupVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Surcharge Adjust-Location 조회 처리<br>
	 * Location Group 상세 리스트 조회 이벤트 처리<br>
	 * 
	 * @param RsltPriSurchargeAdjustLocationGroupDetailVO rsltPriSurchargeAdjustLocationGroupVO
	 * @return List<RsltPriSurchargeAdjustLocationGroupDetailVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeAdjustLocationGroupDetailVO> searchRateGroupLocationDetailList(
			RsltPriSurchargeAdjustLocationGroupDetailVO rsltPriSurchargeAdjustLocationGroupVO) throws EventException {
		try {
			return dbDao.searchRateGroupLocationDetailList(rsltPriSurchargeAdjustLocationGroupVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PRS- Cost Detail 조회 처리<br>
	 * PRS- Cost Detail List 확인 리스트 조회 이벤트 처리<br>
	 * 
	 * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
	 * @return List<RsltPriPrsCostListVO>
	 * @exception EventException
	 */
	public List<RsltPriPrsCostListVO> searchCostDetailList(RsltPriPrsCostListVO rsltPriPrsCostListVO) throws EventException {
		try {
			return dbDao.searchCostDetailList(rsltPriPrsCostListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PRS- Cost Detail 조회 처리<br>
	 * PRS- Cost Detail List 확인 리스트 조회 이벤트 처리<br>
	 * 
	 * @param RsltPriPrsCostDetailVO rsltPriPrsCostDetailVO
	 * @return List<RsltPriPrsCostDetailVO>
	 * @exception EventException
	 */
	public List<RsltPriPrsCostDetailVO> searchCostDetailInquiryList(RsltPriPrsCostDetailVO rsltPriPrsCostDetailVO) throws EventException {
		try {
			return dbDao.searchCostDetailInquiryList(rsltPriPrsCostDetailVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PRS- Applicable Route, Surcharge Detail을 조회 처리합니다.<br>
	 * 
	 * @param InpPrsSurchargeDetailApplicableRouteVO rsltPriSpScpRtScgVO
	 * @return RsltPrsSurchargeDetailListVO
	 * @exception EventException
	 */
	public RsltPrsSurchargeDetailListVO searchSurchargeList(InpPrsSurchargeDetailApplicableRouteVO rsltPriSpScpRtScgVO) throws EventException {
		try {

			RsltPrsSurchargeDetailListVO rsltPrsSurchargeDetailListVO = new RsltPrsSurchargeDetailListVO();
			rsltPrsSurchargeDetailListVO.setRsltPrsSurchargeDetailVOS(dbDao.searchSurchargeDetailList(rsltPriSpScpRtScgVO));
			rsltPrsSurchargeDetailListVO.setRsltPrsSurchargeDetailApplicableRouteVOS(dbDao.searchSurchargeList(rsltPriSpScpRtScgVO));
			return rsltPrsSurchargeDetailListVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PRS- Surcharge Detail 내용을 추가,삭제,갱신처리 합니다.<br>
	 * 
	 * @param PriRpScpRtScgVO[] priRpScpRtScgVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateSurcharge(PriRpScpRtScgVO[] priRpScpRtScgVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtScgVO> insertVoList = new ArrayList<PriRpScpRtScgVO>();
			List<PriRpScpRtScgVO> updateVoList = new ArrayList<PriRpScpRtScgVO>();
			List<PriRpScpRtScgVO> deleteVoList = new ArrayList<PriRpScpRtScgVO>();
			PriRpScpRtScgVO priRpScpRtScgVO = null;

			for (int i = 0; i < priRpScpRtScgVOs.length; i++) {
				if (priRpScpRtScgVOs[i].getIbflag().equals("I")) {
					priRpScpRtScgVOs[i].setCreUsrId(account.getUsr_id());
					priRpScpRtScgVOs[i].setUpdUsrId(account.getUsr_id());
					priRpScpRtScgVOs[i].setTrfAdjTpCd("I");
					insertVoList.add(priRpScpRtScgVOs[i]);
				} else if (priRpScpRtScgVOs[i].getIbflag().equals("U")) {
					priRpScpRtScgVOs[i].setUpdUsrId(account.getUsr_id());
					priRpScpRtScgVOs[i].setTrfAdjTpCd("I");
					updateVoList.add(priRpScpRtScgVOs[i]);
				} else if (priRpScpRtScgVOs[i].getIbflag().equals("D")) {
					priRpScpRtScgVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(priRpScpRtScgVOs[i]);
				}
			}

			if (deleteVoList.size() > 0) {
				dbDao.removeRateSurcharge(deleteVoList);
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyRateSurcharge(updateVoList);
			}
			if (insertVoList.size() > 0) {
				dbDao.addRateSurcharge(insertVoList);
			}
			// chg_cd를 뺀 나머지 Key 부분만 있으면 되기때문에
			// CUD중 하나의 key만 있으면 된다.
			if (deleteVoList.size() > 0) {
				priRpScpRtScgVO = deleteVoList.get(0);
			} else if (updateVoList.size() > 0) {
				priRpScpRtScgVO = updateVoList.get(0);
			} else if (insertVoList.size() > 0) {
				priRpScpRtScgVO = insertVoList.get(0);
			}
			if (priRpScpRtScgVO != null) {
				dbDao.modifyPrsRateSurchargeCmpb(priRpScpRtScgVO, "2");
				dbDao.modifyPrsRateCmdtRoutCmpb(priRpScpRtScgVO, "2");

			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Cost Detail by Trans.Mode 를 조회 합니다.<br>
	 * 
	 * @param RsltPriCostDetailByTransModeListVO rsltPriCostDetailByTransModeListVO
	 * @return List<RsltPriCostDetailByTransModeListVO>
	 * @exception EventException
	 */
	public List<RsltPriCostDetailByTransModeListVO> searchCostDetailByTransModeList(RsltPriCostDetailByTransModeListVO rsltPriCostDetailByTransModeListVO)
			throws EventException {
		try {
			return dbDao.searchCostDetailByTransModeList(rsltPriCostDetailByTransModeListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * CM/OP View All 팝업화면 조회 처리<br>
	 * 
	 * @param RsltPriRateCmViewAllVO rsltPriRateCmViewAllVO
	 * @return List<RsltPriRateCmViewAllVO>
	 * @exception EventException
	 */
	public List<RsltPriRateCmViewAllVO> searchRateCmViewAllList(RsltPriRateCmViewAllVO rsltPriRateCmViewAllVO) throws EventException {
		try {
			return dbDao.searchRateCmViewAllList(rsltPriRateCmViewAllVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * CM/OP View 의 Load 값을 갱신처리 합니다.<BR>
	 * 
	 * @param PriRpScpRtCmdtRoutSetVO priRpScpRtCmdtRoutSetVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPrsPfmc(PriRpScpRtCmdtRoutSetVO priRpScpRtCmdtRoutSetVO, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtCmdtRoutVO> updateVoList = new ArrayList<PriRpScpRtCmdtRoutVO>();
			String pfmcUnit = priRpScpRtCmdtRoutSetVO.getPfmcUnit();
			PriRpScpRtCmdtRoutVO[] priRpScpRtCmdtRoutVO = priRpScpRtCmdtRoutSetVO.getPriRpScpRtCmdtRoutVOS();

			for (int i = 0; i < priRpScpRtCmdtRoutVO.length; i++) {
				if (priRpScpRtCmdtRoutVO[i].getIbflag().equals("U")) {
					priRpScpRtCmdtRoutVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priRpScpRtCmdtRoutVO[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyPrsPfmc(updateVoList, pfmcUnit);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * RFA Amendment CM/OP View 내용을 조회 합니다.<br>
	 * 
	 * @param RsltPriAmdCmViewAllVO rsltPriAmdCmViewAllVO
	 * @return List<RsltPriAmdCmViewAllVO>
	 * @exception EventException
	 */
	public List<RsltPriAmdCmViewAllVO> searchAmdtRateCmViewAllList(RsltPriAmdCmViewAllVO rsltPriAmdCmViewAllVO) throws EventException {
		try {
			return dbDao.searchAmdtRateCmViewAllList(rsltPriAmdCmViewAllVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * CM/OP화면의 CMPB/OPB를 1건 조회한다..<br>
	 * 
	 * @param RsltPriAmdCmViewAllVO rsltPriAmdCmViewAllVO
	 * @return RsltPriAmdCmpbOpbViewAllVO
	 * @exception EventException
	 */

	public RsltPriAmdCmpbOpbViewAllVO searchAmdtRateCmpbAndOpbViewAll(RsltPriAmdCmViewAllVO rsltPriAmdCmViewAllVO) throws EventException {
		try {
			List<RsltPriAmdCmpbOpbViewAllVO> list = dbDao.searchAmdtRateCmpbAndOpbViewAll(rsltPriAmdCmViewAllVO);
			RsltPriAmdCmpbOpbViewAllVO rsltPriAmdCmpbOpbViewAllVO = null;
			if (list != null && list.size() > 0) {
				rsltPriAmdCmpbOpbViewAllVO = list.get(0);
			}
			return rsltPriAmdCmpbOpbViewAllVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * RFA Amendment CM/OP View 의 Load 값을 갱신처리 합니다.
	 * 
	 * @param PriRpScpRtCmdtRoutSetVO priRpScpRtCmdtRoutSetVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAmdtPrsPfmc(PriRpScpRtCmdtRoutSetVO priRpScpRtCmdtRoutSetVO, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtCmdtRoutVO> updateVoList = new ArrayList<PriRpScpRtCmdtRoutVO>();
			String pfmcUnit = priRpScpRtCmdtRoutSetVO.getPfmcUnit();
			PriRpScpRtCmdtRoutVO[] priRpScpRtCmdtRoutVO = priRpScpRtCmdtRoutSetVO.getPriRpScpRtCmdtRoutVOS();

			for (int i = 0; i < priRpScpRtCmdtRoutVO.length; i++) {
				if (priRpScpRtCmdtRoutVO[i].getIbflag().equals("U")) {
					priRpScpRtCmdtRoutVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priRpScpRtCmdtRoutVO[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyAmdtPrsPfmc(updateVoList, pfmcUnit);

			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * RFA Proposal/Amendment CMPB 또는 OPB 를 조회 합니다.<br>
	 * 
	 * @param RsltPriRateCmpbViewAllListVO rsltPriRateCmpbViewAllListVO
	 * @return List<RsltPriRateCmpbViewAllListVO>
	 * @exception EventException
	 */
	public List<RsltPriRateCmpbViewAllListVO> searchRateCmpbViewAllList(RsltPriRateCmpbViewAllListVO rsltPriRateCmpbViewAllListVO) throws EventException {
		try {
			return dbDao.searchRateCmpbViewAllList(rsltPriRateCmpbViewAllListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	// 송민석 변경 내용 종료
	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Rate Cargo Specification 조회합니다.<br>
	 * 
	 * @param PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO
	 * @return List<RsltPriRpScpRtCgoSpecVO>
	 * @exception EventException
	 */
	public List<RsltPriRpScpRtCgoSpecVO> searchRateCargoSepcification(PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO) throws EventException {
		try {
			return dbDao.searchRateCargoSepcification(priRpScpRtCgoSpecVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Rate Cargo Specification를 수정합니다. <br>
	 * 
	 * @param PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateCargoSepcification(PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO, SignOnUserAccount account) throws EventException {
		try {
			if (Integer.parseInt(dbDao.checkRateCargoSepcification(priRpScpRtCgoSpecVO).getEtc2()) > 0) {
				priRpScpRtCgoSpecVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyRateCargoSepcification(priRpScpRtCgoSpecVO);
			} else {
				priRpScpRtCgoSpecVO.setCreUsrId(account.getUsr_id());
				priRpScpRtCgoSpecVO.setUpdUsrId(account.getUsr_id());
				dbDao.addRateCargoSepcification(priRpScpRtCgoSpecVO);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * RATE관련 Cost, CMPB,OPB 값을 갱신하고 그 갱신여부를 Mark해둔다..<BR>
	 * 
	 * @param RsltPriPrsCostListVO[] rsltPriPrsCostListVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPrsCost(RsltPriPrsCostListVO[] rsltPriPrsCostListVOS, SignOnUserAccount account) throws EventException {
		try {
			List<RsltPriPrsCostListVO> rateUpdateVoList = new ArrayList<RsltPriPrsCostListVO>();
			List<RsltPriPrsCostListVO> routCsUpdateVoList = new ArrayList<RsltPriPrsCostListVO>();

			for (int i = 0; i < rsltPriPrsCostListVOS.length; i++) {
				if (rsltPriPrsCostListVOS[i].getIbflag().equals("U")) {
					rsltPriPrsCostListVOS[i].setUpdUsrId(account.getUpd_usr_id());
					if ("Y".equals(rsltPriPrsCostListVOS[i].getUsdRoutCsSelFlg()) || "1".equals(rsltPriPrsCostListVOS[i].getUsdRoutCsSelFlg())) {
						rateUpdateVoList.add(rsltPriPrsCostListVOS[i]);
						rsltPriPrsCostListVOS[i].setUsdRoutCsSelFlg("Y");
					} else {
						rsltPriPrsCostListVOS[i].setUsdRoutCsSelFlg("N");
					}
					routCsUpdateVoList.add(rsltPriPrsCostListVOS[i]);
				}
			}

			if (routCsUpdateVoList.size() > 0) {
				this.modifyPrsRateCommodityRoute(routCsUpdateVoList);
			}
			if (rateUpdateVoList.size() > 0) {
				this.modifyCalculateLogicData(rateUpdateVoList);
			}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Route의 선택여부를 Mark해둔다..<BR>
	 * 
	 * @param List<RsltPriPrsCostListVO> rsltPriPrsCostListVO
	 * @exception EventException
	 */
	public void modifyPrsRateCommodityRoute(List<RsltPriPrsCostListVO> rsltPriPrsCostListVO) throws EventException {
		try {
			dbDao.modifyPrsRateCommodityRoute(rsltPriPrsCostListVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Calculate Logic을 이용해 data를 갱신한다..<BR>
	 * 
	 * @param List<RsltPriPrsCostListVO> rsltPriPrsCostListVO
	 * @exception EventException
	 */
	public void modifyCalculateLogicData(List<RsltPriPrsCostListVO> rsltPriPrsCostListVO) throws EventException {
		try {

			dbDao.modifyRate(rsltPriPrsCostListVO);
			// SCProposalCalculate Logic시작
			dbDao.removePriRpScpRtScgRoutCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.addPriRpScpRtScgRoutCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.removePriRpScpRtScgCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.addPriRpScpRtScgCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.addPriRpScpRtScgAmtCostDetail(rsltPriPrsCostListVO.get(0), "2");
			dbDao.modifyPriRpScpRtSurchargeCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.modifyPriRpScpRtCMPBCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.modifyPriRpScpRtSvcLaneCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.modifyPriRpScpRtGlineMappingCostDetail(rsltPriPrsCostListVO.get(0));
			dbDao.modifyPriRpScpRtCmdtRoutEstmCostDetail(rsltPriPrsCostListVO.get(0));

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Pre CM/OP Simulation Cost관련 Cost, CMPB,OPB 값을 갱신.
	 * 
	 * @param RsltPriPrsCostListVO[] rsltPriPrsCostListVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyPrsSimulationCost(RsltPriPrsCostListVO[] rsltPriPrsCostListVOS, SignOnUserAccount account) throws EventException {
		try {
			List<RsltPriPrsCostListVO> rateUpdateVoList = new ArrayList<RsltPriPrsCostListVO>();

			for (int i = 0; i < rsltPriPrsCostListVOS.length; i++) {
				rateUpdateVoList.add(rsltPriPrsCostListVOS[i]);
			}
			if (rateUpdateVoList.size() > 0) {
				dbDao.modifyRate(rateUpdateVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * [Special Note Conversion]을 [조회] 합니다.<br>
	 * 
	 * @param PriRfaNoteConvVO priRfaNoteConvVO
	 * @return List<RsltNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltNoteConvVO> searchNoteConversionList(PriRfaNoteConvVO priRfaNoteConvVO) throws EventException {
		try {
			return dbDao.searchNoteConversionList(priRfaNoteConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * [Special Note Conversion]을 [붙여넣기] 합니다.<br>
	 * 
	 * @param PriRfaNoteConvVO priRfaNoteConvVO
	 * @param SignOnUserAccount account
	 * @return List<RsltNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltNoteConvVO> searchNoteConversionListCopy(PriRfaNoteConvVO priRfaNoteConvVO, SignOnUserAccount account) throws EventException {
		try {
			// 로그인 아이디로 조회
			priRfaNoteConvVO.setCreUsrId(account.getUsr_id());

			return dbDao.searchNoteConversionListCopy(priRfaNoteConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * [Special Note Conversion]을 [복사] 합니다.<br>
	 * 
	 * @param PriRfaNoteConvListVO[] priRfaNoteConvListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCopy(PriRfaNoteConvListVO[] priRfaNoteConvListVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRfaNoteConvListVO> insertVoList = new ArrayList<PriRfaNoteConvListVO>();

			for (int i = 0; i < priRfaNoteConvListVOs.length; i++) {
				if (priRfaNoteConvListVOs[i].getIbflag().equals("I")) {
					priRfaNoteConvListVOs[i].setCreUsrId(account.getUsr_id());
					priRfaNoteConvListVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priRfaNoteConvListVOs[i]);
				}
			}
			if (insertVoList.size() > 0) {
				priRfaNoteConvListVOs[0].setCreUsrId(account.getUsr_id());
				dbDao.removeNoteConversionCopy(priRfaNoteConvListVOs[0]);
				dbDao.addNoteConversionCopy(insertVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * RFA Proposal Rate 정보를 Copy 합니다.<br>
	 * 
	 * @param RsltRfaPropCopyVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyProposalScopeRate(RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException {
		try {
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			vo.setOfcCd(account.getOfc_cd());
			// PRI_RP_SCP_RT_CMDT_HDR COPY
			dbDao.addCopyProposalScopeRtCmdtHdr(vo);
			// PRI_RP_SCP_RT_ACT_CUST COPY
			dbDao.addCopyProposalScopeRtActCust(vo);
			// PRI_RP_SCP_RT_CMDT COPY
			dbDao.addCopyProposalScopeRtCmdt(vo);
			// PRI_RP_SCP_RT_CNOTE COPY
			dbDao.addCopyProposalScopeRtCnote(vo);
			// PRI_RP_SCP_RT_CMDT_ROUT COPY
			dbDao.addCopyProposalScopeRtCmdtRout(vo);
			// PRI_RP_SCP_RT_ROUT_PNT COPY
			dbDao.addCopyProposalScopeRtRoutPnt(vo);
			// PRI_RP_SCP_RT_ROUT_VIA COPY
			dbDao.addCopyProposalScopeRtRoutVia(vo);
			// PRI_RP_SCP_RT COPY
			dbDao.addCopyProposalScopeRt(vo);
			// PRI_RP_SCP_RT_CMDT_RNOTE COPY
			dbDao.addCopyProposalScopeRtCmdtRnote(vo);

			// PRI_RP_SCP_RT_CMDT_RNOTE Display Seq Update
			PriRpScpRtCmdtRoutVO routVO = new PriRpScpRtCmdtRoutVO();
			routVO.setPropNo(vo.getNewPropNo());
			routVO.setAmdtSeq("0");
			routVO.setSvcScpCd(vo.getSvcScpCd());

			dbDao.modifyRouteNoteDispSeq(routVO, "0");
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Master RFA Proposal Rate 정보를 Copy 합니다.<br>
	 * 
	 * @param RsltRfaPropCopyVO vo
	 * @param RsltRoutHdrSmryListVO[] rsltRoutHdrSmryListVOs
	 * @param SignOnUserAccount account
	 * @param String rfaTypeCode
	 * @exception EventException
	 */
	public void copyProposalScopeRateMst(RsltRfaPropCopyVO vo, RsltRoutHdrSmryListVO[] rsltRoutHdrSmryListVOs, SignOnUserAccount account, String rfaTypeCode) throws EventException {
		try {
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			vo.setOfcCd(account.getOfc_cd());
			// PRI_RP_SCP_RT_CMDT_HDR COPY
			dbDao.addCopyProposalScopeRtCmdtHdr(vo);
			// PRI_RP_SCP_RT_CMDT COPY
			dbDao.addCopyProposalScopeRtCmdtMst(vo);
			
            List<String> routSeqList = new ArrayList();
			
			// Batch 일괄 수행을 위해 list로 변경 
			for(int i = 0; i < rsltRoutHdrSmryListVOs.length; i++){
				// 선택한 Route 의 route seq
				routSeqList.add(rsltRoutHdrSmryListVOs[i].getRoutSeq());
			}
			
			RsltRoutHdrSmryListVO smryVo = rsltRoutHdrSmryListVOs[0];
			
			smryVo.setCreUsrId(account.getUsr_id());
			smryVo.setUpdUsrId(account.getUsr_id());
			smryVo.setOfcCd(account.getOfc_cd());
			smryVo.setNewPropNo(vo.getNewPropNo());
			
			// PRI_RP_SCP_RT_CMDT_ROUT COPY
			dbDao.addCopyProposalScopeRtCmdtRoutMst(smryVo, routSeqList, rfaTypeCode);
			// PRI_RP_SCP_RT_ROUT_PNT COPY
			dbDao.addCopyProposalScopeRtRoutPntMst(smryVo, routSeqList);
			// PRI_RP_SCP_RT_ROUT_VIA COPY
			dbDao.addCopyProposalScopeRtRoutViaMst(smryVo, routSeqList);
			// PRI_RP_SCP_RT COPY
			dbDao.addCopyProposalScopeRtMst(smryVo, routSeqList);
			// PRI_RP_SCP_RT_CMDT_RNOTE COPY
			dbDao.addCopyProposalScopeRtCmdtRnoteMst(smryVo, routSeqList);
			
			// PRI_RP_SCP_RT_CMDT_RNOTE Display Seq Update
			PriRpScpRtCmdtRoutVO routVO = new PriRpScpRtCmdtRoutVO();
			routVO.setPropNo(vo.getNewPropNo());
			routVO.setAmdtSeq("0");
			routVO.setSvcScpCd(vo.getSvcScpCd());

			dbDao.modifyRouteNoteDispSeq(routVO, "0");
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Guideline Rate 를 Proposal 에 Copy 합니다.<br>
	 * 
	 * @param RpScpGlineCopyVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyScopeGuidelineRate(RpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException {
		try {
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			// PRI_RP_SCP_RT_CMDT_HDR COPY
			dbDao.addCopyScopeGuidelineRateCmdtHdr(vo);
			// PRI_RP_SCP_RT_CMDT COPY
			dbDao.addCopyScopeGuidelineRateCmdt(vo);
			// PRI_RP_SCP_RT_CMDT_ROUT COPY
			dbDao.addCopyScopeGuidelineRateCmdtRout(vo);
			// PRI_RP_SCP_RT_ROUT_PNT COPY
			dbDao.addCopyScopeGuidelineRateRoutPnt(vo);

			// PRI_RP_SCP_RT_ROUT_VIA COPY
			dbDao.addCopyScopeGuidelineRateRoutVia(vo);
			// PRI_RP_SCP_RT COPY
			dbDao.addCopyScopeGuidelineRate(vo);

			// PRI_RP_SCP_RT_CMDT_RNOTE Display Seq Update
			PriRpScpRtCmdtRoutVO routVO = new PriRpScpRtCmdtRoutVO();
			routVO.setPropNo(vo.getPropNo());
			routVO.setAmdtSeq(vo.getAmdtSeq());
			routVO.setSvcScpCd(vo.getSvcScpCd());

			dbDao.modifyRouteNoteDispSeq(routVO, "0");
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * PRS 정보를 Copy 하여 Rate 정보를 생성합니다.<br>
	 * 
	 * @param RsltCopyToProposalVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyToProposalRate(RsltCopyToProposalVO vo, SignOnUserAccount account) throws EventException {
		try {
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			// office
			vo.setQttnOfcCd(account.getOfc_cd());

			dbDao.addCopyRfaQuotationPriRpScpRtCmdtHdr(vo);
			dbDao.addCopyRfaQuotationPriRpScpRtCmdt(vo);
			dbDao.addCopyRfaQuotationPriRpScpRtCmdtRout(vo);
			dbDao.addCopyRfaQuotationPriRpScpRtRoutPnt(vo);
			dbDao.addCopyRfaQuotationPriRpScpRtRoutVia(vo);
			dbDao.addCopyRfaQuotationPriRpScpRt(vo);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Calculate Batch를 비동기 적으로 실행킨다.<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @param String rotationPrsBatId
	 * @param SignOnUserAccount account
	 * @return PriPrsBatVO
	 * @exception EventException
	 */
	public PriPrsBatVO executeCalculate(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO, String rotationPrsBatId, SignOnUserAccount account) throws EventException {
		try {
			// 컨테이너 vo
			// RateQuotationVO rateQuotationVO = new RateQuotationVO();
			ScheduleUtil schedule = new ScheduleUtil();
			RsltPriRpMnCalcVO rsltPriRpMnCalcVO = new RsltPriRpMnCalcVO();
			PriPrsBatVO priPrsBatVO = null;
			List<RsltPriRpMnCalcVO> priSpCtrtPtyVOList;
			String params = "";
			String jobID = "";

			String pgmNm = "";

			// PGM_NM 에 사용할 number update후 값을 조회한다.

			rsltPriRpMnCalcVO.setPropNo(priRpScpRtCmdtRoutVO.getPropNo());
			rsltPriRpMnCalcVO.setAmdtSeq(priRpScpRtCmdtRoutVO.getAmdtSeq());

			priSpCtrtPtyVOList = dbDao.searchPriRpMnCalc(rsltPriRpMnCalcVO);
			if (priSpCtrtPtyVOList.size() != 0) {

				params = priRpScpRtCmdtRoutVO.getPropNo() + "#" + priRpScpRtCmdtRoutVO.getAmdtSeq() + "#" + priRpScpRtCmdtRoutVO.getSvcScpCd() + "#"
						+ priSpCtrtPtyVOList.get(0).getCtrtCustCntCd() + "#" + priSpCtrtPtyVOList.get(0).getCtrtCustSeq() + "#" + account.getUsr_id();

				/********************************************************************/

				if (rotationPrsBatId.length() == 1) {
					pgmNm = "0" + rotationPrsBatId;
				} else {
					pgmNm = rotationPrsBatId;
				}
				pgmNm = "ESM_PRI_B009-" + pgmNm;
				log.debug("== pgmNm == " + pgmNm);
				if (!schedule.isRunning(pgmNm)) {
					jobID = schedule.directExecuteJob(pgmNm, params);

					priPrsBatVO = new PriPrsBatVO();
					priPrsBatVO.setPrsBatId(jobID);
					priPrsBatVO.setParaInfoCtnt(params);
					priPrsBatVO.setPgmNo(pgmNm);
				} else {
					throw new EventException(new ErrorHandler("PRI03027", new String[] {}).getMessage());
				}
				log.debug("== jobID == " + jobID);
				/********************************************************************/

				// jobID = schedule.directExecuteJob("ESM_PRI_B009", params);
				//
				// priPrsBatVO = new PriPrsBatVO();
				// priPrsBatVO.setPrsBatId(jobID);
				// priPrsBatVO.setParaInfoCtnt(params);
				// priPrsBatVO.setPgmNo("ESM_PRI_B009");

			}
			return priPrsBatVO;

		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * Calculate Batch ID를 조회 하기 위한 Parameter를 조합한다.<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
	 * @return PriPrsBatVO
	 * @exception EventException
	 */
	public PriPrsBatVO searchMonitorCalculateParam(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws EventException {
		try {
			RsltPriRpMnCalcVO rsltPriRpMnCalcVO = new RsltPriRpMnCalcVO();
			PriPrsBatVO priPrsBatVO = null;
			List<RsltPriRpMnCalcVO> priSpCtrtPtyVOList;
			String params = "";

			// 조회불가 메시지
			if (priRpScpRtCmdtRoutVO.getPropNo() == null || priRpScpRtCmdtRoutVO.getAmdtSeq() == null) {
				throw new EventException(new ErrorHandler("PRI02014").getMessage());
			}
			rsltPriRpMnCalcVO.setPropNo(priRpScpRtCmdtRoutVO.getPropNo());
			rsltPriRpMnCalcVO.setAmdtSeq(priRpScpRtCmdtRoutVO.getAmdtSeq());

			priSpCtrtPtyVOList = dbDao.searchPriRpMnCalc(rsltPriRpMnCalcVO);
			if (priSpCtrtPtyVOList.size() != 0) {
				params = priRpScpRtCmdtRoutVO.getPropNo() + "#" + priRpScpRtCmdtRoutVO.getAmdtSeq() + "#" + priRpScpRtCmdtRoutVO.getSvcScpCd() + "#"
						+ priSpCtrtPtyVOList.get(0).getCtrtCustCntCd() + "#" + priSpCtrtPtyVOList.get(0).getCtrtCustSeq() + "#"; // USER ID정보는 parameter 정보에서 빼고 like 검색으로
																																	// batch id를 검색한다.

				priPrsBatVO = new PriPrsBatVO();
				priPrsBatVO.setParaInfoCtnt(params);
				priPrsBatVO.setPgmNo("ESM_PRI_B009");

			} else { // 조회 불가 메시지
				throw new EventException(new ErrorHandler("PRI02014").getMessage());
			}
			return priPrsBatVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * Calculate Batch의 상태 조회.<br>
	 * 
	 * @param PrsBatchVO prsBatchVO
	 * @return String
	 * @exception EventException
	 */
	public String monitorCalculate(PrsBatchVO prsBatchVO) throws EventException {
		try {
			ScheduleUtil su = new ScheduleUtil();
			int status = 0;
			if (prsBatchVO != null) {
				status = su.getJobStatus(prsBatchVO.getPrsBatId(), prsBatchVO.getPgmNo());
				if (status == 0) {
					float min = Float.valueOf(prsBatchVO.getExecMinutes());
					if (Float.compare(min, 10.0f) > 0) { // 10분이 지다도 0이 return될때 Batch 서버가 해당 Calc를 돌려주지 못했다고 판단한다. Code 99
						status = 99;
					} else {
						// 기존에 nothing으로 표현 하던 내용으로 pri_prs_bat에는 데이터가 있으나 batch에서 null을 return할때는 Running...으로 표현한다.
						status = 80;
					}
					log.debug(" =================  status === " + status);
				}
			}

			return String.valueOf(status);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

	}

	/**
	 * Rate Route Case를 추가 한다. .<br>
	 * 
	 * @param PriRpScpRtUsdRoutCsVO priRpScpRtUsdRoutCsVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePriRateUsedRouteCase(PriRpScpRtUsdRoutCsVO priRpScpRtUsdRoutCsVO, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpScpRtUsdRoutCsVO> priRpScpRtUsdRoutCsVOs = new ArrayList<PriRpScpRtUsdRoutCsVO>();
			if (priRpScpRtUsdRoutCsVO != null) {
				priRpScpRtUsdRoutCsVO.setUpdUsrId(account.getUsr_id());
				priRpScpRtUsdRoutCsVO.setUsdRoutCsSelFlg("Y");
				priRpScpRtUsdRoutCsVOs.add(priRpScpRtUsdRoutCsVO);
			}
			dbDao.addPriRateUsedRouteCase(priRpScpRtUsdRoutCsVOs);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * COST CM/OP PRE SIMULATION 화면에서 ROUTE정보를 조회 한다.<br>
	 * 
	 * @param InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO
	 * @return List<RsltPriCostSimulationCheckRouteVO>
	 * @exception EventException
	 */
	public List<RsltPriCostSimulationCheckRouteVO> searchCostSimulationCheckRoutList(InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO) throws EventException {
		try {
			return dbDao.searchCostSimulationCheckRoutList(inCostSimulationCheckRouteVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * RFA Proposal - Rate Tab의 Surcharge View All Popup의 내용을 조회를 처리합니다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltPriSurchargeViewAllVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeViewAllVO> searchSurchargeViewAllList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchSurchargeViewAllList(priRpScpRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * RFA Proposal - Rate Tab의 Surcharge View All Popup에서 Surcharge 값이 언제 만들어 졌는지를 조회 처리합니다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltPriSurchargeLastAccessDateVO>
	 * @exception EventException
	 */
	public List<RsltPriSurchargeLastAccessDateVO> searchSurchargeLastAccessDateList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchSurchargeLastAccessDateList(priRpScpRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Surcharge 정보를 삭제 합니다.<br>
	 * 
	 * @param RfaPropMnVO rfaPropMnVO
	 * @exception EventException
	 */
	public void manageProposalScopeSurchargeRemove(RfaPropMnVO rfaPropMnVO) throws EventException {
		try {
			PriRpScpMnVO[] scpVo = rfaPropMnVO.getPriRpScpMnVOs();

			for (int i = 0; scpVo != null && i < scpVo.length; i++) {
				if (scpVo[i].getIbflag().equals("D")) {
					dbDao.removeSurchargeAdjustInitCancel(scpVo[i]);
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 이전 AMDT_SEQ에 해당하는 메인의 EXPIRE DATE정보를 조회한다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @return String
	 * @exception EventException
	 */
	public String searchBeforeExpireDate(PriRpScpMnVO priRpScpMnVO) throws EventException {
		try {
			return dbDao.searchBeforeExpireDate(priRpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Rate의 General(CY)와 IHC의 FONT STYLE를 조회합니다. <br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<ChkFontStyleVO>
	 * @exception EventException
	 */
	public List<ChkFontStyleVO> checkFontStyle(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchFontStyle(priRpScpRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 조건에 일치하는 최대 Commmodity Header Sequence를 조회한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return String
	 * @exception EventException
	 */
	public String searchMaxCmdtHdrSeq(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchMaxCmdtHdrSeq(priRpScpRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * FIC Route Group을 조회한다.<br>
	 * 
	 * @param FicRouteGroupVO ficRouteGroupVO
	 * @param boolean addOnFlag
	 * @return List<FicRouteGroupVO>
	 * @exception EventException
	 */
	public List<FicRouteGroupVO> searchFicRouteGroup(FicRouteGroupVO ficRouteGroupVO, boolean addOnFlag) throws EventException {
		try {
			return dbDao.searchFicRouteGroup(ficRouteGroupVO, addOnFlag);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Local FIC Guide Line RT Amount 조회한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return String
	 * @exception EventException
	 */
	public String searchLocalFicGlineRtAmt(PriRpScpRtVO priRpScpRtVO) throws EventException {
		try {
			return dbDao.searchLocalFicGlineRtAmt(priRpScpRtVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * location code또는 group location code에 CY가 포함돼 있는 확인한다.<br>
	 * 
	 * @param FicCheckCYPortLocationVO ficCheckCYPortLocationVO
	 * @return List<RsltFicCheckCYPortLocationVO>
	 * @exception EventException
	 */
	public List<RsltFicCheckCYPortLocationVO> checkCYPortLocationCode(FicCheckCYPortLocationVO ficCheckCYPortLocationVO) throws EventException {
		try {
			return dbDao.searchCYPortLocationCode(ficCheckCYPortLocationVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Route Via. 데이터를 Accept한다.<br>
	 * 
	 * @param PriRpScpRtRoutViaVO priRpScpRtRoutViaVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAutoRateRouteViaDetail(PriRpScpRtRoutViaVO priRpScpRtRoutViaVO, SignOnUserAccount account) throws EventException {
		try {
			priRpScpRtRoutViaVO.setPrcProgStsCd("A");
			priRpScpRtRoutViaVO.setAcptUsrId(account.getUsr_id());
			priRpScpRtRoutViaVO.setAcptOfcCd(account.getOfc_cd());
			priRpScpRtRoutViaVO.setUpdUsrId(account.getUsr_id());

			dbDao.modifyRateRouteViaAllStatus(priRpScpRtRoutViaVO);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Route Via. 데이터를 Accept한다.<br>
	 * 
	 * @param PriRpScpRtRoutViaVO priRpScpRtRoutViaVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptCancelAutoRateRouteViaDetail(PriRpScpRtRoutViaVO priRpScpRtRoutViaVO, SignOnUserAccount account) throws EventException {
		try {
			priRpScpRtRoutViaVO.setPrcProgStsCd("I");
			priRpScpRtRoutViaVO.setAcptUsrId("");
			priRpScpRtRoutViaVO.setAcptOfcCd("");
			priRpScpRtRoutViaVO.setUpdUsrId(account.getUsr_id());

			dbDao.modifyRateRouteViaAllStatus(priRpScpRtRoutViaVO);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * AEE.AEW를 위한 Excel Download(Vertical)를 위한 조회를 실행한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtListVerticalExcelForAeeAewVO>
	 * @exception EventException
	 */
	public List<RsltRtListVerticalExcelForAeeAewVO> searchRateListVerticalExcelForAeeAew(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchRateListVerticalExcelForAeeAew(priRpScpRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * AEE.AEW를 위한 Excel Download(Horizontal)를 위한 조회를 실행한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtListHorizontalExcelForAeeAewVO>
	 * @exception EventException
	 */
	public List<RsltRtListHorizontalExcelForAeeAewVO> searchRateListHorizontalExcelForAeeAew(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchRateListHorizontalExcelForAeeAew(priRpScpRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelForAeeAewVO[] rsltRtListVerticalExcelForAeeAewVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelVerticalOnlineForAeeAew(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListVerticalExcelForAeeAewVO[] rsltRtListVerticalExcelForAeeAewVOs,
			SignOnUserAccount account) throws EventException {
		List<PriRpScpRtCmdtHdrVO> cmdtHdrVoList = new ArrayList<PriRpScpRtCmdtHdrVO>();
		List<PriRpScpRtCmdtVO> cmdtVoList = new ArrayList<PriRpScpRtCmdtVO>();
		List<PriRpScpRtActCustVO> custVoList = new ArrayList<PriRpScpRtActCustVO>();
		List<PriRpScpRtCmdtRoutVO> routVoList = new ArrayList<PriRpScpRtCmdtRoutVO>();
		List<PriRpScpRtRoutPntVO> pntVoList = new ArrayList<PriRpScpRtRoutPntVO>();
		List<PriRpScpRtRoutViaVO> viaVoList = new ArrayList<PriRpScpRtRoutViaVO>();
		List<PriRpScpRtVO> rtVoList = new ArrayList<PriRpScpRtVO>();
		List<PriRpScpRtScgVO> scgVoList = new ArrayList<PriRpScpRtScgVO>();

		try {
			int nextCmdtHdrSeq = dbDao.searchNextCmdtHdrSeq(priRpScpRtCmdtHdrVO);
			int nextBletDpSeq = Integer.parseInt(dbDao.searchMaxBulletDispSeq(priRpScpRtCmdtHdrVO));
			int nextCmdtSeq = 0;
			int nextActCustSeq = 0;

			int nextRoutSeq = 0;
			int nextRoutPntSeq = 0;
			int nextRoutViaSeq = 0;
			int nextRtSeq = 0;

			String strPropNo = priRpScpRtCmdtHdrVO.getPropNo();
			String strAmdtSeq = priRpScpRtCmdtHdrVO.getAmdtSeq();
			String strSvcScpCd = priRpScpRtCmdtHdrVO.getSvcScpCd();
			String strCreUsrId = account.getUsr_id();
			String strUpdUsrId = account.getUsr_id();

			for (int i = 0; i < rsltRtListVerticalExcelForAeeAewVOs.length; i++) {
				RsltRtListVerticalExcelForAeeAewVO row = rsltRtListVerticalExcelForAeeAewVOs[i];

				String strCmdtDpSeq = row.getCmdtDpSeq();
				String strCmdtCd = row.getPrcCmdtDefCd();
				String strCustSeq = row.getCustSeq();

				String strRoutDpSeq = row.getRoutDpSeq();
				String strOrgPntCd = row.getOrgRoutPntLocDefCd();
				String strOrgRcvDeTermCd = row.getOrgRcvDeTermNm();
				String strOrgPrcTrspModCd = row.getOrgPrcTrspModNm();
				String strOrgViaCd = row.getOrgRoutViaPortDefCd();
				String strDestViaCd = row.getDestRoutViaPortDefCd();
				String strDestPntCd = row.getDestRoutPntLocDefCd();
				String strDestRcvDeTermCd = row.getDestRcvDeTermNm();
				String strDestPrcTrspModCd = row.getDestPrcTrspModNm();

				String strPerTypeCd = row.getRatUtCd();
				String strCgoTypeCd = row.getPrcCgoTpCd();
				String strCurrCd = row.getCurrCd();
				String strRateAmt = row.getPropFrtRtAmt();

				String strBucAmt = row.getBucUsdAmt();
				String strIfcAmt = row.getIfcUsdAmt();
				String strPscAmt = row.getPscUsdAmt();

				// IHC Amount
				String strFicPropRtAmt = row.getFicPropRtAmt();
				// FIC_GLINE_RT_AMT
				String strFicGlineRtAmt = row.getFicGlineRtAmt();

				String strOptmTrspModFlg = row.getOptmTrspModFlg();
				String strFicRtUseStsCd = row.getFicRtUseStsCd();
				String strBasePortLocCd = row.getBsePortLocCd();
				String strFicRoutCmbTpCd = row.getFicRoutCmbTpCd();

				if (strCmdtDpSeq != null && !"".equals(strCmdtDpSeq)) {
					nextCmdtHdrSeq++;
					nextBletDpSeq++;
					nextCmdtSeq = 0;
					nextActCustSeq = 0;
					nextRoutSeq = 0;

					PriRpScpRtCmdtHdrVO cmdtHdr = new PriRpScpRtCmdtHdrVO();
					cmdtHdr.setPropNo(strPropNo);
					cmdtHdr.setAmdtSeq(strAmdtSeq);
					cmdtHdr.setSvcScpCd(strSvcScpCd);
					cmdtHdr.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdtHdr.setBletDpSeq(String.valueOf(nextBletDpSeq));
					cmdtHdr.setN1stCmncAmdtSeq(strAmdtSeq);
					cmdtHdr.setCreUsrId(strCreUsrId);
					cmdtHdr.setUpdUsrId(strUpdUsrId);
					cmdtHdr.setFicRtTpCd(priRpScpRtCmdtHdrVO.getFicRtTpCd());

					cmdtHdrVoList.add(cmdtHdr);
				}

				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					nextCmdtSeq++;

					String cmdtTpCd = "";
					if (strCmdtCd.length() == 5) {
						cmdtTpCd = "G";
					} else if (strCmdtCd.length() == 4) {
						cmdtTpCd = "R";
					} else if (strCmdtCd.length() == 6) {
						cmdtTpCd = "C";
					}

					PriRpScpRtCmdtVO cmdt = new PriRpScpRtCmdtVO();
					cmdt.setPropNo(strPropNo);
					cmdt.setAmdtSeq(strAmdtSeq);
					cmdt.setSvcScpCd(strSvcScpCd);
					cmdt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdt.setCmdtSeq(String.valueOf(nextCmdtSeq));
					cmdt.setPrcCmdtTpCd(cmdtTpCd);
					cmdt.setPrcCmdtDefCd(strCmdtCd);
					cmdt.setPrcProgStsCd("I");
					cmdt.setSrcInfoCd("NW");
					cmdt.setN1stCmncAmdtSeq(strAmdtSeq);
					cmdt.setCreUsrId(strCreUsrId);
					cmdt.setUpdUsrId(strUpdUsrId);

					cmdtVoList.add(cmdt);
				}
				if (strCustSeq != null && !"".equals(strCustSeq)) {
					nextActCustSeq++;

					PriRpScpRtActCustVO cust = new PriRpScpRtActCustVO();
					cust.setPropNo(strPropNo);
					cust.setAmdtSeq(strAmdtSeq);
					cust.setSvcScpCd(strSvcScpCd);
					cust.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cust.setActCustSeq(String.valueOf(nextActCustSeq));
					cust.setCustCntCd(strCustSeq.substring(0, 2));
					cust.setCustSeq(strCustSeq.substring(2));
					cust.setPrcProgStsCd("I");
					cust.setSrcInfoCd("NW");
					cust.setN1stCmncAmdtSeq(strAmdtSeq);
					cust.setCreUsrId(strCreUsrId);
					cust.setUpdUsrId(strUpdUsrId);

					custVoList.add(cust);
				}

				if (strRoutDpSeq != null && !"".equals(strRoutDpSeq)) {
					nextRoutSeq++;
					nextRoutPntSeq = 0;
					nextRoutViaSeq = 0;
					nextRtSeq = 0;

					PriRpScpRtCmdtRoutVO rout = new PriRpScpRtCmdtRoutVO();
					rout.setPropNo(strPropNo);
					rout.setAmdtSeq(strAmdtSeq);
					rout.setSvcScpCd(strSvcScpCd);
					rout.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rout.setRoutSeq(String.valueOf(nextRoutSeq));
					rout.setN1stCmncAmdtSeq(strAmdtSeq);
					rout.setCreUsrId(strCreUsrId);
					rout.setUpdUsrId(strUpdUsrId);

					routVoList.add(rout);
				}

				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					nextRoutPntSeq++;

					String locTpCd = strOrgPntCd.length() == 4 ? "G" : "L";

					PriRpScpRtRoutPntVO pnt = new PriRpScpRtRoutPntVO();
					pnt.setPropNo(strPropNo);
					pnt.setAmdtSeq(strAmdtSeq);
					pnt.setSvcScpCd(strSvcScpCd);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("O");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strOrgPntCd);
					pnt.setRcvDeTermCd(strOrgRcvDeTermCd);
					pnt.setPrcTrspModCd(strOrgPrcTrspModCd);
					pnt.setPrcProgStsCd("I");
					pnt.setSrcInfoCd("NW");
					pnt.setN1stCmncAmdtSeq(strAmdtSeq);
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);

					if ("AEE".equals(strSvcScpCd)) {
						pnt.setBsePortLocCd(strBasePortLocCd);
						pnt.setFicRoutCmbTpCd(strFicRoutCmbTpCd);
					}

					pntVoList.add(pnt);
				}
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					boolean dupChk = false;
					if ("AEE".equals(strSvcScpCd)) {
						dupChk = duplicateRouteVia(viaVoList, strPropNo, strAmdtSeq, strSvcScpCd, nextCmdtHdrSeq, nextRoutSeq, strOrgViaCd);
					}
					if (!dupChk) {
						nextRoutViaSeq++;
						String locTpCd = strOrgViaCd.length() == 4 ? "G" : "L";

						PriRpScpRtRoutViaVO via = new PriRpScpRtRoutViaVO();
						via.setPropNo(strPropNo);
						via.setAmdtSeq(strAmdtSeq);
						via.setSvcScpCd(strSvcScpCd);
						via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						via.setRoutSeq(String.valueOf(nextRoutSeq));
						via.setOrgDestTpCd("O");
						via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
						via.setRoutViaPortTpCd(locTpCd);
						via.setRoutViaPortDefCd(strOrgViaCd);
						via.setPrcProgStsCd("I");
						via.setSrcInfoCd("NW");
						via.setN1stCmncAmdtSeq(strAmdtSeq);
						via.setCreUsrId(strCreUsrId);
						via.setUpdUsrId(strUpdUsrId);

						viaVoList.add(via);
					}
				}
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					boolean dupChk = false;
					if ("AEW".equals(strSvcScpCd)) {
						dupChk = duplicateRouteVia(viaVoList, strPropNo, strAmdtSeq, strSvcScpCd, nextCmdtHdrSeq, nextRoutSeq, strDestViaCd);
					}

					if (!dupChk) {
						nextRoutViaSeq++;
						String locTpCd = strDestViaCd.length() == 4 ? "G" : "L";

						PriRpScpRtRoutViaVO via = new PriRpScpRtRoutViaVO();
						via.setPropNo(strPropNo);
						via.setAmdtSeq(strAmdtSeq);
						via.setSvcScpCd(strSvcScpCd);
						via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						via.setRoutSeq(String.valueOf(nextRoutSeq));
						via.setOrgDestTpCd("D");
						via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
						via.setRoutViaPortTpCd(locTpCd);
						via.setRoutViaPortDefCd(strDestViaCd);
						via.setPrcProgStsCd("I");
						via.setSrcInfoCd("NW");
						via.setN1stCmncAmdtSeq(strAmdtSeq);
						via.setCreUsrId(strCreUsrId);
						via.setUpdUsrId(strUpdUsrId);

						viaVoList.add(via);
					}
				}
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					nextRoutPntSeq++;

					String locTpCd = strDestPntCd.length() == 4 ? "G" : "L";

					PriRpScpRtRoutPntVO pnt = new PriRpScpRtRoutPntVO();
					pnt.setPropNo(strPropNo);
					pnt.setAmdtSeq(strAmdtSeq);
					pnt.setSvcScpCd(strSvcScpCd);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("D");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strDestPntCd);
					pnt.setRcvDeTermCd(strDestRcvDeTermCd);
					pnt.setPrcTrspModCd(strDestPrcTrspModCd);
					pnt.setPrcProgStsCd("I");
					pnt.setSrcInfoCd("NW");
					pnt.setN1stCmncAmdtSeq(strAmdtSeq);
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);
					// 추가
					if ("AEW".equals(strSvcScpCd)) {
						pnt.setBsePortLocCd(strBasePortLocCd);
						pnt.setFicRoutCmbTpCd(strFicRoutCmbTpCd);
					}
					pntVoList.add(pnt);
				}

				if (strRateAmt != null && !"".equals(strRateAmt)) {
					nextRtSeq++;

					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd(strPerTypeCd);
					rt.setPrcCgoTpCd(strCgoTypeCd);
					rt.setCurrCd(strCurrCd);
					rt.setPropFrtRtAmt(strRateAmt);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					/**
					 * Guide Line 정보 저장
					 */
					rt.setFicPropRtAmt(strFicPropRtAmt);
					rt.setFicGlineRtAmt(strFicGlineRtAmt);
					rt.setOptmTrspModFlg(strOptmTrspModFlg);
					rt.setFicRtUseStsCd(strFicRtUseStsCd);

					rtVoList.add(rt);

					if (strBucAmt != null && !"".equals(strBucAmt)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd(strPerTypeCd);
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucAmt);
						scg.setAdjScgUsdAmt(strBucAmt);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strIfcAmt != null && !"".equals(strIfcAmt)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd(strPerTypeCd);
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcAmt);
						scg.setAdjScgUsdAmt(strIfcAmt);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strPscAmt != null && !"".equals(strPscAmt)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd(strPerTypeCd);
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscAmt);
						scg.setAdjScgUsdAmt(strPscAmt);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
				}
			}

			if (cmdtHdrVoList.size() > 0) {
				dbDao.addRateCommodityHeader(cmdtHdrVoList);
			}
			if (cmdtVoList.size() > 0) {
				dbDao.addRateCommodity(cmdtVoList);
			}
			if (custVoList.size() > 0) {
				dbDao.addRateActualCustomer(custVoList);
			}

			if (routVoList.size() > 0) {
				dbDao.addRateCommodityRoute(routVoList);
			}
			if (pntVoList.size() > 0) {
				dbDao.addRateRoutePoint(pntVoList);
			}
			if (viaVoList.size() > 0) {
				dbDao.addRateRouteVia(viaVoList);
			}

			if (rtVoList.size() > 0) {
				dbDao.addRate(rtVoList);
			}
			if (scgVoList.size() > 0) {
				dbDao.addRateSurcharge(scgVoList);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Load된 엑셀 데이터가 올바른지 Check한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelForAeeAewVO[] rsltRtListVerticalExcelForAeeAewVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelVerticalForAeeAew(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO,
			RsltRtListVerticalExcelForAeeAewVO[] rsltRtListVerticalExcelForAeeAewVOs) throws EventException {
		List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();
		try {
			RsltRtListVerticalExcelForAeeAewVO row = new RsltRtListVerticalExcelForAeeAewVO();
			String strCmdtCd = null;
			String strCustSeq = null;
			String strOrgPntCd = null;
			String strOrgViaCd = null;
			String strDestViaCd = null;
			String strDestPntCd = null;
			for (int i = 0; i < rsltRtListVerticalExcelForAeeAewVOs.length; i++) {
				row = rsltRtListVerticalExcelForAeeAewVOs[i];

				strCmdtCd = row.getPrcCmdtDefCd();
				strCustSeq = row.getCustSeq();
				strOrgPntCd = row.getOrgRoutPntLocDefCd();
				strOrgViaCd = row.getOrgRoutViaPortDefCd();
				strDestViaCd = row.getDestRoutViaPortDefCd();
				strDestPntCd = row.getDestRoutPntLocDefCd();

				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strCmdtCd);

					RsltCdListVO cdVO = dbDao.searchCommodityCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strCmdtCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("prc_cmdt_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strCustSeq != null && !"".equals(strCustSeq)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strCustSeq);

					RsltCdListVO cdVO = dbDao.searchActualCustomerExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strCustSeq);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("cust_seq");

						rslt.add(cdVO);
					}
				}
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strOrgPntCd);
					paramVO.setEtc1("O");

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strOrgPntCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("org_rout_pnt_loc_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strOrgViaCd);

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strOrgViaCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("org_rout_via_port_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strDestViaCd);

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strDestViaCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("dest_rout_via_port_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strDestPntCd);
					paramVO.setEtc1("D");

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strDestPntCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("dest_rout_pnt_loc_def_cd");

						rslt.add(cdVO);
					}
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return rslt;
	}

	/**
	 * Load된 엑셀 데이터의 FIC Rate를 조회한다.<br>
	 * 
	 * @param FicRateLoadExcelGuidelineCheckVO ficRateLoadExcelGuidelineCheckVO
	 * @param FicRateLoadExcelGuidelineCheckVO[] ficRateLoadExcelGuidelineCheckVOs
	 * @return List<RsltFicGuidelineRateVO>
	 * @exception EventException
	 */
	public List<RsltFicGuidelineRateVO> searchFicGuidelineRateForAeeAew(FicRateLoadExcelGuidelineCheckVO ficRateLoadExcelGuidelineCheckVO,
			FicRateLoadExcelGuidelineCheckVO[] ficRateLoadExcelGuidelineCheckVOs) throws EventException {
		List<RsltFicGuidelineRateVO> rslt = new ArrayList<RsltFicGuidelineRateVO>();
		try {

			rslt = dbDao.searchFicGuidelineRateForAeeAew(ficRateLoadExcelGuidelineCheckVO, ficRateLoadExcelGuidelineCheckVOs);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return rslt;
	}

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
			SignOnUserAccount account) throws EventException {
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		UploadRateExcelVerticalForAeeAewBackEndJobImpl jobImpl = new UploadRateExcelVerticalForAeeAewBackEndJobImpl();
		String key = null;

		try {
			jobImpl.setPriRpScpRtCmdtHdrVO(priRpScpRtCmdtHdrVO);
			jobImpl.setRsltRtListVerticalExcelForAeeAewVOs(rsltRtListVerticalExcelForAeeAewVOs);
			jobImpl.setAccount(account);

			key = backEndJobManager.execute(jobImpl, account.getUsr_id(), "ESM_PRI_2067");
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return key;
	}

	/**
	 * Load된 엑셀 데이터가 올바른지 Check한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalLoadExcelForAeeAewVO[] rsltRtListHorizontalLoadExcelForAeeAewVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelHorizontalForAeeAew(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO,
			RsltRtListHorizontalLoadExcelForAeeAewVO[] rsltRtListHorizontalLoadExcelForAeeAewVOs) throws EventException {
		List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();

		try {
			RsltRtListHorizontalLoadExcelForAeeAewVO row = new RsltRtListHorizontalLoadExcelForAeeAewVO();

			String strCmdtCd = null;
			String strCustSeq = null;
			String strOrgPntCd = null;
			String strOrgViaCd = null;
			String strDestViaCd = null;
			String strDestPntCd = null;

			for (int i = 0; i < rsltRtListHorizontalLoadExcelForAeeAewVOs.length; i++) {
				row = rsltRtListHorizontalLoadExcelForAeeAewVOs[i];

				strCmdtCd = row.getPrcCmdtDefCd();
				strCustSeq = row.getCustSeq();
				strOrgPntCd = row.getOrgRoutPntLocDefCd();
				strOrgViaCd = row.getOrgRoutViaPortDefCd();
				strDestViaCd = row.getDestRoutViaPortDefCd();
				strDestPntCd = row.getDestRoutPntLocDefCd();

				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strCmdtCd);

					RsltCdListVO cdVO = dbDao.searchCommodityCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strCmdtCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("prc_cmdt_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strCustSeq != null && !"".equals(strCustSeq)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strCustSeq);

					RsltCdListVO cdVO = dbDao.searchActualCustomerExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strCustSeq);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("cust_seq");

						rslt.add(cdVO);
					}
				}
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strOrgPntCd);
					paramVO.setEtc1("O");

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strOrgPntCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("org_rout_pnt_loc_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strOrgViaCd);

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strOrgViaCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("org_rout_via_port_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strDestViaCd);

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strDestViaCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("dest_rout_via_port_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strDestPntCd);
					paramVO.setEtc1("D");

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strDestPntCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("dest_rout_pnt_loc_def_cd");

						rslt.add(cdVO);
					}
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return rslt;
	}

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
			RsltRtListHorizontalLoadExcelForAeeAewVO[] rsltRtListHorizontalLoadExcelForAeeAewVOs, SignOnUserAccount account) throws EventException {
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		UploadRateExcelHorizontalForAeeAewBackEndJobImpl jobImpl = new UploadRateExcelHorizontalForAeeAewBackEndJobImpl();
		String key = null;

		try {
			jobImpl.setPriRpScpRtCmdtHdrVO(priRpScpRtCmdtHdrVO);
			jobImpl.setRsltRtListHorizontalLoadExcelForAeeAewVOs(rsltRtListHorizontalLoadExcelForAeeAewVOs);
			jobImpl.setAccount(account);

			key = backEndJobManager.execute(jobImpl, account.getUsr_id(), "ESM_PRI_0099");
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return key;
	}

	/**
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalLoadExcelForAeeAewVO[] rsltRtListHorizontalLoadExcelForAeeAewVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelHorizontalOnlineForAeeAew(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO,
			RsltRtListHorizontalLoadExcelForAeeAewVO[] rsltRtListHorizontalLoadExcelForAeeAewVOs, SignOnUserAccount account) throws EventException {
		List<PriRpScpRtCmdtHdrVO> cmdtHdrVoList = new ArrayList<PriRpScpRtCmdtHdrVO>();
		List<PriRpScpRtCmdtVO> cmdtVoList = new ArrayList<PriRpScpRtCmdtVO>();
		List<PriRpScpRtActCustVO> custVoList = new ArrayList<PriRpScpRtActCustVO>();
		List<PriRpScpRtCmdtRoutVO> routVoList = new ArrayList<PriRpScpRtCmdtRoutVO>();
		List<PriRpScpRtRoutPntVO> pntVoList = new ArrayList<PriRpScpRtRoutPntVO>();
		List<PriRpScpRtRoutViaVO> viaVoList = new ArrayList<PriRpScpRtRoutViaVO>();
		List<PriRpScpRtVO> rtVoList = new ArrayList<PriRpScpRtVO>();
		List<PriRpScpRtScgVO> scgVoList = new ArrayList<PriRpScpRtScgVO>();

		try {
			int nextCmdtHdrSeq = dbDao.searchNextCmdtHdrSeq(priRpScpRtCmdtHdrVO);
			int nextBletDpSeq = Integer.parseInt(dbDao.searchMaxBulletDispSeq(priRpScpRtCmdtHdrVO));
			int nextCmdtSeq = 0;
			int nextActCustSeq = 0;

			int nextRoutSeq = 0;
			int nextRoutPntSeq = 0;
			int nextRoutViaSeq = 0;
			int nextRtSeq = 0;

			String strPropNo = priRpScpRtCmdtHdrVO.getPropNo();
			String strAmdtSeq = priRpScpRtCmdtHdrVO.getAmdtSeq();
			String strSvcScpCd = priRpScpRtCmdtHdrVO.getSvcScpCd();
			String strCreUsrId = account.getUsr_id();
			String strUpdUsrId = account.getUsr_id();

			for (int i = 0; i < rsltRtListHorizontalLoadExcelForAeeAewVOs.length; i++) {
				RsltRtListHorizontalLoadExcelForAeeAewVO row = rsltRtListHorizontalLoadExcelForAeeAewVOs[i];

				String strCmdtDpSeq = row.getCmdtDpSeq();
				String strCmdtCd = row.getPrcCmdtDefCd();
				String strCustSeq = row.getCustSeq();

				String strRoutDpSeq = row.getRoutDpSeq();
				String strOrgPntCd = row.getOrgRoutPntLocDefCd();
				String strOrgRcvDeTermCd = row.getOrgRcvDeTermNm();
				String strOrgPrcTrspModCd = row.getOrgPrcTrspModNm();
				String strOrgViaCd = row.getOrgRoutViaPortDefCd();
				String strDestViaCd = row.getDestRoutViaPortDefCd();
				String strDestPntCd = row.getDestRoutPntLocDefCd();
				String strDestRcvDeTermCd = row.getDestRcvDeTermNm();
				String strDestPrcTrspModCd = row.getDestPrcTrspModNm();

				String strRateDry20 = row.getRateDry20();
				String strRateDry40 = row.getRateDry40();
				String strRateDry40hc = row.getRateDry40hc();
				String strRateDry45 = row.getRateDry45();
				String strRateRf40hc = row.getRateRf40hc();
				String strRateRd40hc = row.getRateRd40hc();

				String strBucDry20 = row.getBucDry20();
				String strBucDry40 = row.getBucDry40();
				String strBucDry40hc = row.getBucDry40hc();
				String strBucDry45 = row.getBucDry45();
				String strBucRf40hc = row.getBucRf40hc();
				String strBucRd40hc = row.getBucRd40hc();

				String strIfcDry20 = row.getIfcDry20();
				String strIfcDry40 = row.getIfcDry40();
				String strIfcDry40hc = row.getIfcDry40hc();
				String strIfcDry45 = row.getIfcDry45();
				String strIfcRf40hc = row.getIfcRf40hc();
				String strIfcRd40hc = row.getIfcRd40hc();

				String strPscDry20 = row.getPscDry20();
				String strPscDry40 = row.getPscDry40();
				String strPscDry40hc = row.getPscDry40hc();
				String strPscDry45 = row.getPscDry45();
				String strPscRf40hc = row.getPscRf40hc();
				String strPscRd40hc = row.getPscRd40hc();

				/**
				 * 2012.07.02 추가
				 */
				String strBasePortLocCd = row.getBsePortLocCd();
				String strFicRoutCmbTpCd = row.getFicRoutCmbTpCd();

				String strRatePropDry20 = row.getRatePropDry20();
				String strRatePropDry40 = row.getRatePropDry40();
				String strRatePropDry40hc = row.getRatePropDry40hc();
				String strRatePropDry45 = row.getRatePropDry45();
				String strRatePropRf40hc = row.getRatePropRf40hc();
				String strRatePropRd40hc = row.getRatePropRd40hc();

				String strFicGlineRtAmtRateDry20 = row.getFicGlineRtAmtRateDry20();
				String strFicGlineRtAmtRateDry40 = row.getFicGlineRtAmtRateDry40();
				String strFicGlineRtAmtRateDry40hc = row.getFicGlineRtAmtRateDry40hc();
				String strFicGlineRtAmtRateDry45 = row.getFicGlineRtAmtRateDry45();
				String strFicGlineRtAmtRateRf40hc = row.getFicGlineRtAmtRateRf40hc();
				String strFicGlineRtAmtRateRd40hc = row.getFicGlineRtAmtRateRd40hc();

				String strFicRtUseStsCdRateDry20 = row.getFicRtUseStsCdRateDry20();
				String strFicRtUseStsCdRateDry40 = row.getFicRtUseStsCdRateDry40();
				String strFicRtUseStsCdRateDry40hc = row.getFicRtUseStsCdRateDry40hc();
				String strFicRtUseStsCdRateDry45 = row.getFicRtUseStsCdRateDry45();
				String strFicRtUseStsCdRateRf40hc = row.getFicRtUseStsCdRateRf40hc();
				String strFicRtUseStsCdRateRd40hc = row.getFicRtUseStsCdRateRd40hc();

				String strOptmTrspModFlgRateDry20 = row.getOptmTrspModFlgRateDry20();
				String strOptmTrspModFlgRateDry40 = row.getOptmTrspModFlgRateDry40();
				String strOptmTrspModFlgRateDry40hc = row.getOptmTrspModFlgRateDry40hc();
				String strOptmTrspModFlgRateDry45 = row.getOptmTrspModFlgRateDry45();
				String strOptmTrspModFlgRateRf40hc = row.getOptmTrspModFlgRateRf40hc();
				String strOptmTrspModFlgRateRd40hc = row.getOptmTrspModFlgRateRd40hc();

				if (strCmdtDpSeq != null && !"".equals(strCmdtDpSeq)) {
					nextCmdtHdrSeq++;
					nextBletDpSeq++;
					nextCmdtSeq = 0;
					nextActCustSeq = 0;
					nextRoutSeq = 0;

					PriRpScpRtCmdtHdrVO cmdtHdr = new PriRpScpRtCmdtHdrVO();
					cmdtHdr.setPropNo(strPropNo);
					cmdtHdr.setAmdtSeq(strAmdtSeq);
					cmdtHdr.setSvcScpCd(strSvcScpCd);
					cmdtHdr.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdtHdr.setBletDpSeq(String.valueOf(nextBletDpSeq));
					cmdtHdr.setN1stCmncAmdtSeq(strAmdtSeq);
					cmdtHdr.setCreUsrId(strCreUsrId);
					cmdtHdr.setUpdUsrId(strUpdUsrId);
					cmdtHdr.setFicRtTpCd(priRpScpRtCmdtHdrVO.getFicRtTpCd());
					cmdtHdrVoList.add(cmdtHdr);
				}

				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					nextCmdtSeq++;

					String cmdtTpCd = "";
					if (strCmdtCd.length() == 5) {
						cmdtTpCd = "G";
					} else if (strCmdtCd.length() == 4) {
						cmdtTpCd = "R";
					} else if (strCmdtCd.length() == 6) {
						cmdtTpCd = "C";
					}

					PriRpScpRtCmdtVO cmdt = new PriRpScpRtCmdtVO();
					cmdt.setPropNo(strPropNo);
					cmdt.setAmdtSeq(strAmdtSeq);
					cmdt.setSvcScpCd(strSvcScpCd);
					cmdt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdt.setCmdtSeq(String.valueOf(nextCmdtSeq));
					cmdt.setPrcCmdtTpCd(cmdtTpCd);
					cmdt.setPrcCmdtDefCd(strCmdtCd);
					cmdt.setPrcProgStsCd("I");
					cmdt.setSrcInfoCd("NW");
					cmdt.setN1stCmncAmdtSeq(strAmdtSeq);
					cmdt.setCreUsrId(strCreUsrId);
					cmdt.setUpdUsrId(strUpdUsrId);

					cmdtVoList.add(cmdt);
				}
				if (strCustSeq != null && !"".equals(strCustSeq)) {
					nextActCustSeq++;

					PriRpScpRtActCustVO cust = new PriRpScpRtActCustVO();
					cust.setPropNo(strPropNo);
					cust.setAmdtSeq(strAmdtSeq);
					cust.setSvcScpCd(strSvcScpCd);
					cust.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cust.setActCustSeq(String.valueOf(nextActCustSeq));
					cust.setCustCntCd(strCustSeq.substring(0, 2));
					cust.setCustSeq(strCustSeq.substring(2));
					cust.setPrcProgStsCd("I");
					cust.setSrcInfoCd("NW");
					cust.setN1stCmncAmdtSeq(strAmdtSeq);
					cust.setCreUsrId(strCreUsrId);
					cust.setUpdUsrId(strUpdUsrId);

					custVoList.add(cust);
				}

				if (strRoutDpSeq != null && !"".equals(strRoutDpSeq)) {
					nextRoutSeq++;
					nextRoutPntSeq = 0;
					nextRoutViaSeq = 0;
					nextRtSeq = 0;

					PriRpScpRtCmdtRoutVO rout = new PriRpScpRtCmdtRoutVO();
					rout.setPropNo(strPropNo);
					rout.setAmdtSeq(strAmdtSeq);
					rout.setSvcScpCd(strSvcScpCd);
					rout.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rout.setRoutSeq(String.valueOf(nextRoutSeq));
					rout.setN1stCmncAmdtSeq(strAmdtSeq);
					rout.setCreUsrId(strCreUsrId);
					rout.setUpdUsrId(strUpdUsrId);

					routVoList.add(rout);
				}

				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					nextRoutPntSeq++;

					String locTpCd = strOrgPntCd.length() == 4 ? "G" : "L";

					PriRpScpRtRoutPntVO pnt = new PriRpScpRtRoutPntVO();
					pnt.setPropNo(strPropNo);
					pnt.setAmdtSeq(strAmdtSeq);
					pnt.setSvcScpCd(strSvcScpCd);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("O");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strOrgPntCd);
					pnt.setRcvDeTermCd(strOrgRcvDeTermCd);
					pnt.setPrcTrspModCd(strOrgPrcTrspModCd);
					pnt.setPrcProgStsCd("I");
					pnt.setSrcInfoCd("NW");
					pnt.setN1stCmncAmdtSeq(strAmdtSeq);
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);

					if ("AEE".equals(strSvcScpCd)) {
						pnt.setBsePortLocCd(strBasePortLocCd);
						pnt.setFicRoutCmbTpCd(strFicRoutCmbTpCd);
					}

					pntVoList.add(pnt);
				}
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					boolean dupChk = false;
					if ("AEE".equals(strSvcScpCd)) {
						dupChk = duplicateRouteVia(viaVoList, strPropNo, strAmdtSeq, strSvcScpCd, nextCmdtHdrSeq, nextRoutSeq, strOrgViaCd);
					}
					if (!dupChk) {
						nextRoutViaSeq++;

						String locTpCd = strOrgViaCd.length() == 4 ? "G" : "L";

						PriRpScpRtRoutViaVO via = new PriRpScpRtRoutViaVO();
						via.setPropNo(strPropNo);
						via.setAmdtSeq(strAmdtSeq);
						via.setSvcScpCd(strSvcScpCd);
						via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						via.setRoutSeq(String.valueOf(nextRoutSeq));
						via.setOrgDestTpCd("O");
						via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
						via.setRoutViaPortTpCd(locTpCd);
						via.setRoutViaPortDefCd(strOrgViaCd);
						via.setPrcProgStsCd("I");
						via.setSrcInfoCd("NW");
						via.setN1stCmncAmdtSeq(strAmdtSeq);
						via.setCreUsrId(strCreUsrId);
						via.setUpdUsrId(strUpdUsrId);

						viaVoList.add(via);
					}
				}
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					boolean dupChk = false;
					if ("AEW".equals(strSvcScpCd)) {
						dupChk = duplicateRouteVia(viaVoList, strPropNo, strAmdtSeq, strSvcScpCd, nextCmdtHdrSeq, nextRoutSeq, strDestViaCd);
					}

					if (!dupChk) {
						nextRoutViaSeq++;

						String locTpCd = strDestViaCd.length() == 4 ? "G" : "L";

						PriRpScpRtRoutViaVO via = new PriRpScpRtRoutViaVO();
						via.setPropNo(strPropNo);
						via.setAmdtSeq(strAmdtSeq);
						via.setSvcScpCd(strSvcScpCd);
						via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						via.setRoutSeq(String.valueOf(nextRoutSeq));
						via.setOrgDestTpCd("D");
						via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
						via.setRoutViaPortTpCd(locTpCd);
						via.setRoutViaPortDefCd(strDestViaCd);
						via.setPrcProgStsCd("I");
						via.setSrcInfoCd("NW");
						via.setN1stCmncAmdtSeq(strAmdtSeq);
						via.setCreUsrId(strCreUsrId);
						via.setUpdUsrId(strUpdUsrId);

						viaVoList.add(via);
					}
				}
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					nextRoutPntSeq++;

					String locTpCd = strDestPntCd.length() == 4 ? "G" : "L";

					PriRpScpRtRoutPntVO pnt = new PriRpScpRtRoutPntVO();
					pnt.setPropNo(strPropNo);
					pnt.setAmdtSeq(strAmdtSeq);
					pnt.setSvcScpCd(strSvcScpCd);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("D");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strDestPntCd);
					pnt.setRcvDeTermCd(strDestRcvDeTermCd);
					pnt.setPrcTrspModCd(strDestPrcTrspModCd);
					pnt.setPrcProgStsCd("I");
					pnt.setSrcInfoCd("NW");
					pnt.setN1stCmncAmdtSeq(strAmdtSeq);
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);

					// 추가
					if ("AEW".equals(strSvcScpCd)) {
						pnt.setBsePortLocCd(strBasePortLocCd);
						pnt.setFicRoutCmbTpCd(strFicRoutCmbTpCd);
					}
					pntVoList.add(pnt);
				}

				if (strRateDry20 != null && !"".equals(strRateDry20)) {
					nextRtSeq++;

					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("D2");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setPropFrtRtAmt(strRateDry20);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					/**
					 * Guide Line 정보 저장
					 */
					rt.setFicPropRtAmt(strRatePropDry20);
					rt.setFicGlineRtAmt(strFicGlineRtAmtRateDry20);
					rt.setOptmTrspModFlg(strOptmTrspModFlgRateDry20);
					rt.setFicRtUseStsCd(strFicRtUseStsCdRateDry20);

					rtVoList.add(rt);

					if (strBucDry20 != null && !"".equals(strBucDry20)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd("D2");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucDry20);
						scg.setAdjScgUsdAmt(strBucDry20);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strIfcDry20 != null && !"".equals(strIfcDry20)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd("D2");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcDry20);
						scg.setAdjScgUsdAmt(strIfcDry20);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strPscDry20 != null && !"".equals(strPscDry20)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd("D2");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscDry20);
						scg.setAdjScgUsdAmt(strPscDry20);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
				}

				if (strRateDry40 != null && !"".equals(strRateDry40)) {
					nextRtSeq++;

					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("D4");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setPropFrtRtAmt(strRateDry40);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					/**
					 * Guide Line 정보 저장
					 */
					rt.setFicPropRtAmt(strRatePropDry40);
					rt.setFicGlineRtAmt(strFicGlineRtAmtRateDry40);
					rt.setOptmTrspModFlg(strOptmTrspModFlgRateDry40);
					rt.setFicRtUseStsCd(strFicRtUseStsCdRateDry40);

					rtVoList.add(rt);

					if (strBucDry40 != null && !"".equals(strBucDry40)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd("D4");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucDry40);
						scg.setAdjScgUsdAmt(strBucDry40);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strIfcDry40 != null && !"".equals(strIfcDry40)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd("D4");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcDry40);
						scg.setAdjScgUsdAmt(strIfcDry40);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strPscDry40 != null && !"".equals(strPscDry40)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd("D4");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscDry40);
						scg.setAdjScgUsdAmt(strPscDry40);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
				}

				if (strRateDry40hc != null && !"".equals(strRateDry40hc)) {
					nextRtSeq++;

					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("D5");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setPropFrtRtAmt(strRateDry40hc);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					/**
					 * Guide Line 정보 저장
					 */
					rt.setFicPropRtAmt(strRatePropDry40hc);
					rt.setFicGlineRtAmt(strFicGlineRtAmtRateDry40hc);
					rt.setOptmTrspModFlg(strOptmTrspModFlgRateDry40hc);
					rt.setFicRtUseStsCd(strFicRtUseStsCdRateDry40hc);

					rtVoList.add(rt);

					if (strBucDry40hc != null && !"".equals(strBucDry40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd("D5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucDry40hc);
						scg.setAdjScgUsdAmt(strBucDry40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strIfcDry40hc != null && !"".equals(strIfcDry40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd("D5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcDry40hc);
						scg.setAdjScgUsdAmt(strIfcDry40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strPscDry40hc != null && !"".equals(strPscDry40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd("D5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscDry40hc);
						scg.setAdjScgUsdAmt(strPscDry40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
				}

				if (strRateDry45 != null && !"".equals(strRateDry45)) {
					nextRtSeq++;

					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("D7");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setPropFrtRtAmt(strRateDry45);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					/**
					 * Guide Line 정보 저장
					 */
					rt.setFicPropRtAmt(strRatePropDry45);
					rt.setFicGlineRtAmt(strFicGlineRtAmtRateDry45);
					rt.setOptmTrspModFlg(strOptmTrspModFlgRateDry45);
					rt.setFicRtUseStsCd(strFicRtUseStsCdRateDry45);

					rtVoList.add(rt);

					if (strBucDry45 != null && !"".equals(strBucDry45)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd("D7");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucDry45);
						scg.setAdjScgUsdAmt(strBucDry45);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strIfcDry45 != null && !"".equals(strIfcDry45)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd("D7");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcDry45);
						scg.setAdjScgUsdAmt(strIfcDry45);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strPscDry45 != null && !"".equals(strPscDry45)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd("D7");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscDry45);
						scg.setAdjScgUsdAmt(strPscDry45);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
				}

				if (strRateRf40hc != null && !"".equals(strRateRf40hc)) {
					nextRtSeq++;

					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("R5");
					rt.setPrcCgoTpCd("RF");
					rt.setCurrCd("USD");
					rt.setPropFrtRtAmt(strRateRf40hc);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					/**
					 * Guide Line 정보 저장
					 */
					rt.setFicPropRtAmt(strRatePropRf40hc);
					rt.setFicGlineRtAmt(strFicGlineRtAmtRateRf40hc);
					rt.setOptmTrspModFlg(strOptmTrspModFlgRateRf40hc);
					rt.setFicRtUseStsCd(strFicRtUseStsCdRateRf40hc);

					rtVoList.add(rt);

					if (strBucRf40hc != null && !"".equals(strBucRf40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd("R5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucRf40hc);
						scg.setAdjScgUsdAmt(strBucRf40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strIfcRf40hc != null && !"".equals(strIfcRf40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd("R5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcRf40hc);
						scg.setAdjScgUsdAmt(strIfcRf40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strPscRf40hc != null && !"".equals(strPscRf40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd("R5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscRf40hc);
						scg.setAdjScgUsdAmt(strPscRf40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
				}

				if (strRateRd40hc != null && !"".equals(strRateRd40hc)) {
					nextRtSeq++;

					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("R5");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setPropFrtRtAmt(strRateRd40hc);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					/**
					 * Guide Line 정보 저장
					 */
					rt.setFicPropRtAmt(strRatePropRd40hc);
					rt.setFicGlineRtAmt(strFicGlineRtAmtRateRd40hc);
					rt.setOptmTrspModFlg(strOptmTrspModFlgRateRd40hc);
					rt.setFicRtUseStsCd(strFicRtUseStsCdRateRd40hc);

					rtVoList.add(rt);

					if (strBucRd40hc != null && !"".equals(strBucRd40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd("R5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucRd40hc);
						scg.setAdjScgUsdAmt(strBucRd40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strIfcRd40hc != null && !"".equals(strIfcRd40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd("R5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcRd40hc);
						scg.setAdjScgUsdAmt(strIfcRd40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strPscRd40hc != null && !"".equals(strPscRd40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd("R5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscRd40hc);
						scg.setAdjScgUsdAmt(strPscRd40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
				}
			}

			if (cmdtHdrVoList.size() > 0) {
				dbDao.addRateCommodityHeader(cmdtHdrVoList);
			}
			if (cmdtVoList.size() > 0) {
				dbDao.addRateCommodity(cmdtVoList);
			}
			if (custVoList.size() > 0) {
				dbDao.addRateActualCustomer(custVoList);
			}

			if (routVoList.size() > 0) {
				dbDao.addRateCommodityRoute(routVoList);
			}
			if (pntVoList.size() > 0) {
				dbDao.addRateRoutePoint(pntVoList);
			}
			if (viaVoList.size() > 0) {
				dbDao.addRateRouteVia(viaVoList);
			}

			if (rtVoList.size() > 0) {
				dbDao.addRate(rtVoList);
			}
			if (scgVoList.size() > 0) {
				dbDao.addRateSurcharge(scgVoList);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Route Via 중복 체크
	 * 
	 * @param vias
	 * @param strPropNo
	 * @param strAmdtSeq
	 * @param strSvcScpCd
	 * @param nextCmdtHdrSeq
	 * @param nextRoutSeq
	 * @param strViaCd
	 * @return
	 */
	private boolean duplicateRouteVia(List<PriRpScpRtRoutViaVO> vias, String strPropNo, String strAmdtSeq, String strSvcScpCd, int nextCmdtHdrSeq, int nextRoutSeq,
			String strViaCd) {
		for (int i = 0; i < vias.size(); i++) {
			CompareToBuilder builder = new CompareToBuilder();
			builder.append(vias.get(i).getPropNo(), strPropNo);
			builder.append(vias.get(i).getAmdtSeq(), strAmdtSeq);
			builder.append(vias.get(i).getSvcScpCd(), strSvcScpCd);
			builder.append(vias.get(i).getCmdtHdrSeq(), String.valueOf(nextCmdtHdrSeq));
			builder.append(vias.get(i).getRoutSeq(), String.valueOf(nextRoutSeq));
			builder.append(vias.get(i).getRoutViaPortDefCd(), strViaCd);
			if (builder.toComparison() == 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Rate의 General(CY)와 IHC의 FONT STYLE를 조회합니다. <br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<ChkFontStyleVO>
	 * @exception EventException
	 */
	public List<ChkFontStyleVO> checkHistoryFontStyle(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchHistoryFontStyle(priRpScpRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Rate 데이터에 GRI Calculation Validation 처리.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @param SignOnUserAccount account
	 * @return List<CheckGRICalculationValidationVO>
	 * @exception EventException
	 */
	public List<CheckGRICalculationValidationVO> checkGRICalculationValidation(PriRpScpGriGrpVO priRpScpGriGrpVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.checkGRICalculationValidation(priRpScpGriGrpVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Rate 데이터에 GRI Calculation을 적용합니다.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @param CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void applyGRICalculationForIHC(PriRpScpGriGrpVO priRpScpGriGrpVO, CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs, SignOnUserAccount account)
			throws EventException {
		try {
			if (priRpScpGriGrpVO != null) {
				priRpScpGriGrpVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyProposalScopeRateGRIApplyForIHC(priRpScpGriGrpVO, checkGRICalculationValidationVOs);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 적용한 GRI Calculation을 취소합니다.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @param CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGRICalculationForIHC(PriRpScpGriGrpVO priRpScpGriGrpVO, CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs,
			SignOnUserAccount account) throws EventException {
		try {
			if (priRpScpGriGrpVO != null) {
				priRpScpGriGrpVO.setCreUsrId(account.getUsr_id());
				priRpScpGriGrpVO.setUpdUsrId(account.getUsr_id());

				if (!"0".equals(priRpScpGriGrpVO.getAmdtSeq())) {
					dbDao.removeRateScgOnGRICancel(priRpScpGriGrpVO);
					dbDao.removeRateScgRoutOnGRICancel(priRpScpGriGrpVO);
					dbDao.removeRateUsdRoutCsOnGRICancel(priRpScpGriGrpVO);

					dbDao.addCopyPrevRateScgOnGRICancel(priRpScpGriGrpVO);
					dbDao.addCopyPrevRateScgRoutOnGRICancel(priRpScpGriGrpVO);
					dbDao.addCopyPrevRateUsdRoutCsOnGRICancel(priRpScpGriGrpVO);
				}

				dbDao.modifyProposalScopeRateGRICancelForIHC(priRpScpGriGrpVO, checkGRICalculationValidationVOs);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * AEE.AEW를 위한 Excel Download(Vertical)를 위한 조회를 실행한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtListVerticalExcelForAddOnTariffVO>
	 * @exception EventException
	 */
	public List<RsltRtListVerticalExcelForAddOnTariffVO> searchRateListVerticalExcelForAddOnTariff(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchRateListVerticalExcelForAddOnTariff(priRpScpRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * AEE.AEW를 위한 Excel Download(Horizontal)를 위한 조회를 실행한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return List<RsltRtListHorizontalExcelForAddOnTariffVO>
	 * @exception EventException
	 */
	public List<RsltRtListHorizontalExcelForAddOnTariffVO> searchRateListHorizontalExcelForAddOnTariff(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchRateListHorizontalExcelForAddOnTariff(priRpScpRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

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
			FicRateLoadExcelGuidelineCheckVO[] ficRateLoadExcelGuidelineCheckVOs, String inOrgDestTpCd) throws EventException {
		try {
			return dbDao.searchFicGuidelineRateForAddOnTariff(ficRateLoadExcelGuidelineCheckVO, ficRateLoadExcelGuidelineCheckVOs, inOrgDestTpCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Load된 엑셀 데이터가 올바른지 Check한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelForAddOnTariffVO[] rsltRtListVerticalExcelForAddOnTariffVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelVerticalForAddOnTariff(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO,
			RsltRtListVerticalExcelForAddOnTariffVO[] rsltRtListVerticalExcelForAddOnTariffVOs) throws EventException {
		List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();
		try {
			RsltRtListVerticalExcelForAddOnTariffVO row = new RsltRtListVerticalExcelForAddOnTariffVO();
			String strCmdtCd = null;
			String strCustSeq = null;
			String strOrgPntCd = null;
			String strOrgViaCd = null;
			String strDestViaCd = null;
			String strDestPntCd = null;
			for (int i = 0; i < rsltRtListVerticalExcelForAddOnTariffVOs.length; i++) {
				row = rsltRtListVerticalExcelForAddOnTariffVOs[i];

				strCmdtCd = row.getPrcCmdtDefCd();
				strCustSeq = row.getCustSeq();
				strOrgPntCd = row.getOrgRoutPntLocDefCd();
				strOrgViaCd = row.getOrgRoutViaPortDefCd();
				strDestViaCd = row.getDestRoutViaPortDefCd();
				strDestPntCd = row.getDestRoutPntLocDefCd();

				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strCmdtCd);

					RsltCdListVO cdVO = dbDao.searchCommodityCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strCmdtCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("prc_cmdt_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strCustSeq != null && !"".equals(strCustSeq)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strCustSeq);

					RsltCdListVO cdVO = dbDao.searchActualCustomerExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strCustSeq);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("cust_seq");

						rslt.add(cdVO);
					}
				}
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strOrgPntCd);
					paramVO.setEtc1("O");

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strOrgPntCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("org_rout_pnt_loc_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strOrgViaCd);

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strOrgViaCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("org_rout_via_port_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strDestViaCd);

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strDestViaCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("dest_rout_via_port_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strDestPntCd);
					paramVO.setEtc1("D");

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strDestPntCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("dest_rout_pnt_loc_def_cd");

						rslt.add(cdVO);
					}
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}

		return rslt;
	}

	/**
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListVerticalExcelForAddOnTariffVO[] rsltRtListVerticalExcelForAddOnTariffVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelVerticalOnlineForAddOnTariff(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO,
			RsltRtListVerticalExcelForAddOnTariffVO[] rsltRtListVerticalExcelForAddOnTariffVOs, SignOnUserAccount account) throws EventException {
		List<PriRpScpRtCmdtHdrVO> cmdtHdrVoList = new ArrayList<PriRpScpRtCmdtHdrVO>();
		List<PriRpScpRtCmdtVO> cmdtVoList = new ArrayList<PriRpScpRtCmdtVO>();
		List<PriRpScpRtActCustVO> custVoList = new ArrayList<PriRpScpRtActCustVO>();
		List<PriRpScpRtCmdtRoutVO> routVoList = new ArrayList<PriRpScpRtCmdtRoutVO>();
		List<PriRpScpRtRoutPntVO> pntVoList = new ArrayList<PriRpScpRtRoutPntVO>();
		List<PriRpScpRtRoutViaVO> viaVoList = new ArrayList<PriRpScpRtRoutViaVO>();
		List<PriRpScpRtVO> rtVoList = new ArrayList<PriRpScpRtVO>();
		List<PriRpScpRtScgVO> scgVoList = new ArrayList<PriRpScpRtScgVO>();

		try {
			int nextCmdtHdrSeq = dbDao.searchNextCmdtHdrSeq(priRpScpRtCmdtHdrVO);
			int nextBletDpSeq = Integer.parseInt(dbDao.searchMaxBulletDispSeq(priRpScpRtCmdtHdrVO));
			int nextCmdtSeq = 0;
			int nextActCustSeq = 0;

			int nextRoutSeq = 0;
			int nextRoutPntSeq = 0;
			int nextRoutViaSeq = 0;
			int nextRtSeq = 0;

			String strPropNo = priRpScpRtCmdtHdrVO.getPropNo();
			String strAmdtSeq = priRpScpRtCmdtHdrVO.getAmdtSeq();
			String strSvcScpCd = priRpScpRtCmdtHdrVO.getSvcScpCd();
			String strCreUsrId = account.getUsr_id();
			String strUpdUsrId = account.getUsr_id();

			for (int i = 0; i < rsltRtListVerticalExcelForAddOnTariffVOs.length; i++) {
				RsltRtListVerticalExcelForAddOnTariffVO row = rsltRtListVerticalExcelForAddOnTariffVOs[i];

				String strCmdtDpSeq = row.getCmdtDpSeq();
				String strCmdtCd = row.getPrcCmdtDefCd();
				String strCustSeq = row.getCustSeq();

				String strRoutDpSeq = row.getRoutDpSeq();
				String strOrgPntCd = row.getOrgRoutPntLocDefCd();
				String strOrgRcvDeTermCd = row.getOrgRcvDeTermNm();
				String strOrgPrcTrspModCd = row.getOrgPrcTrspModNm();
				String strOrgViaCd = row.getOrgRoutViaPortDefCd();
				String strDestViaCd = row.getDestRoutViaPortDefCd();
				String strDestPntCd = row.getDestRoutPntLocDefCd();
				String strDestRcvDeTermCd = row.getDestRcvDeTermNm();
				String strDestPrcTrspModCd = row.getDestPrcTrspModNm();

				String strPerTypeCd = row.getRatUtCd();
				String strCgoTypeCd = row.getPrcCgoTpCd();
				String strCurrCd = row.getCurrCd();
				String strRateAmt = row.getPropFrtRtAmt();

				String strBucAmt = row.getBucUsdAmt();
				String strIfcAmt = row.getIfcUsdAmt();
				String strPscAmt = row.getPscUsdAmt();

				// FIC_ORG_PROP_RT_AMT
				String strFicOrgPropRtAmt = row.getFicOrgPropRtAmt();

				// FIC_DEST_PROP_RT_AMT
				String strFicDestPropRtAmt = row.getFicDestPropRtAmt();

				// FIC_ORG_GLINE_RT_AMT
				String strFicOrgGlineRtAmt = row.getFicOrgGlineRtAmt();

				// FIC_DEST_GLINE_RT_AMT
				String strFicDestGlineRtAmt = row.getFicDestGlineRtAmt();

				// ORG_OPTM_TRSP_MOD_FLAG
				String strOrgOptmTrspModFlg = row.getOrgOptmTrspModFlg();

				// DEST_OPTM_TRSP_MOD_FLAG
				String strDestOptmTrspModFlg = row.getDestOptmTrspModFlg();

				String strFicOrgRtUseStsCd = row.getFicOrgRtUseStsCd();
				String strFicDestRtUseStsCd = row.getFicDestRtUseStsCd();

				String strOrgBasePortLocCd = row.getOrgBsePortLocCd();
				String strDestBasePortLocCd = row.getDestBsePortLocCd();

				String strFicOrgRoutCmbTpCd = row.getFicOrgRoutCmbTpCd();
				String strFicDestRoutCmbTpCd = row.getFicDestRoutCmbTpCd();

				if (strCmdtDpSeq != null && !"".equals(strCmdtDpSeq)) {
					nextCmdtHdrSeq++;
					nextBletDpSeq++;
					nextCmdtSeq = 0;
					nextActCustSeq = 0;
					nextRoutSeq = 0;

					PriRpScpRtCmdtHdrVO cmdtHdr = new PriRpScpRtCmdtHdrVO();
					cmdtHdr.setPropNo(strPropNo);
					cmdtHdr.setAmdtSeq(strAmdtSeq);
					cmdtHdr.setSvcScpCd(strSvcScpCd);
					cmdtHdr.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdtHdr.setBletDpSeq(String.valueOf(nextBletDpSeq));
					cmdtHdr.setN1stCmncAmdtSeq(strAmdtSeq);
					cmdtHdr.setCreUsrId(strCreUsrId);
					cmdtHdr.setUpdUsrId(strUpdUsrId);
					cmdtHdr.setFicRtTpCd(priRpScpRtCmdtHdrVO.getFicRtTpCd());
					cmdtHdrVoList.add(cmdtHdr);
				}

				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					nextCmdtSeq++;

					String cmdtTpCd = "";
					if (strCmdtCd.length() == 5) {
						cmdtTpCd = "G";
					} else if (strCmdtCd.length() == 4) {
						cmdtTpCd = "R";
					} else if (strCmdtCd.length() == 6) {
						cmdtTpCd = "C";
					}

					PriRpScpRtCmdtVO cmdt = new PriRpScpRtCmdtVO();
					cmdt.setPropNo(strPropNo);
					cmdt.setAmdtSeq(strAmdtSeq);
					cmdt.setSvcScpCd(strSvcScpCd);
					cmdt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdt.setCmdtSeq(String.valueOf(nextCmdtSeq));
					cmdt.setPrcCmdtTpCd(cmdtTpCd);
					cmdt.setPrcCmdtDefCd(strCmdtCd);
					cmdt.setPrcProgStsCd("I");
					cmdt.setSrcInfoCd("NW");
					cmdt.setN1stCmncAmdtSeq(strAmdtSeq);
					cmdt.setCreUsrId(strCreUsrId);
					cmdt.setUpdUsrId(strUpdUsrId);

					cmdtVoList.add(cmdt);
				}
				if (strCustSeq != null && !"".equals(strCustSeq)) {
					nextActCustSeq++;

					PriRpScpRtActCustVO cust = new PriRpScpRtActCustVO();
					cust.setPropNo(strPropNo);
					cust.setAmdtSeq(strAmdtSeq);
					cust.setSvcScpCd(strSvcScpCd);
					cust.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cust.setActCustSeq(String.valueOf(nextActCustSeq));
					cust.setCustCntCd(strCustSeq.substring(0, 2));
					cust.setCustSeq(strCustSeq.substring(2));
					cust.setPrcProgStsCd("I");
					cust.setSrcInfoCd("NW");
					cust.setN1stCmncAmdtSeq(strAmdtSeq);
					cust.setCreUsrId(strCreUsrId);
					cust.setUpdUsrId(strUpdUsrId);

					custVoList.add(cust);
				}

				if (strRoutDpSeq != null && !"".equals(strRoutDpSeq)) {
					nextRoutSeq++;
					nextRoutPntSeq = 0;
					nextRoutViaSeq = 0;
					nextRtSeq = 0;

					PriRpScpRtCmdtRoutVO rout = new PriRpScpRtCmdtRoutVO();
					rout.setPropNo(strPropNo);
					rout.setAmdtSeq(strAmdtSeq);
					rout.setSvcScpCd(strSvcScpCd);
					rout.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rout.setRoutSeq(String.valueOf(nextRoutSeq));
					rout.setN1stCmncAmdtSeq(strAmdtSeq);
					rout.setCreUsrId(strCreUsrId);
					rout.setUpdUsrId(strUpdUsrId);
					rout.setOrgCyDorRtTpCd(row.getOrgCyDorRtTpCd());
					rout.setDestCyDorRtTpCd(row.getDestCyDorRtTpCd());
					routVoList.add(rout);
				}

				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					nextRoutPntSeq++;

					String locTpCd = strOrgPntCd.length() == 4 ? "G" : "L";

					PriRpScpRtRoutPntVO pnt = new PriRpScpRtRoutPntVO();
					pnt.setPropNo(strPropNo);
					pnt.setAmdtSeq(strAmdtSeq);
					pnt.setSvcScpCd(strSvcScpCd);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("O");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strOrgPntCd);
					pnt.setRcvDeTermCd(strOrgRcvDeTermCd);
					pnt.setPrcTrspModCd(strOrgPrcTrspModCd);
					pnt.setPrcProgStsCd("I");
					pnt.setSrcInfoCd("NW");
					pnt.setN1stCmncAmdtSeq(strAmdtSeq);
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);
					pnt.setBsePortLocCd(strOrgBasePortLocCd);
					pnt.setFicRoutCmbTpCd(strFicOrgRoutCmbTpCd);

					pntVoList.add(pnt);
				}
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					boolean dupChk = false;
					dupChk = duplicateRouteVia(viaVoList, strPropNo, strAmdtSeq, strSvcScpCd, nextCmdtHdrSeq, nextRoutSeq, strOrgViaCd);
					if (!dupChk) {
						nextRoutViaSeq++;
						String locTpCd = strOrgViaCd.length() == 4 ? "G" : "L";

						PriRpScpRtRoutViaVO via = new PriRpScpRtRoutViaVO();
						via.setPropNo(strPropNo);
						via.setAmdtSeq(strAmdtSeq);
						via.setSvcScpCd(strSvcScpCd);
						via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						via.setRoutSeq(String.valueOf(nextRoutSeq));
						via.setOrgDestTpCd("O");
						via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
						via.setRoutViaPortTpCd(locTpCd);
						via.setRoutViaPortDefCd(strOrgViaCd);
						via.setPrcProgStsCd("I");
						via.setSrcInfoCd("NW");
						via.setN1stCmncAmdtSeq(strAmdtSeq);
						via.setCreUsrId(strCreUsrId);
						via.setUpdUsrId(strUpdUsrId);

						viaVoList.add(via);
					}
				}
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					boolean dupChk = false;
					dupChk = duplicateRouteVia(viaVoList, strPropNo, strAmdtSeq, strSvcScpCd, nextCmdtHdrSeq, nextRoutSeq, strDestViaCd);

					if (!dupChk) {
						nextRoutViaSeq++;
						String locTpCd = strDestViaCd.length() == 4 ? "G" : "L";

						PriRpScpRtRoutViaVO via = new PriRpScpRtRoutViaVO();
						via.setPropNo(strPropNo);
						via.setAmdtSeq(strAmdtSeq);
						via.setSvcScpCd(strSvcScpCd);
						via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						via.setRoutSeq(String.valueOf(nextRoutSeq));
						via.setOrgDestTpCd("D");
						via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
						via.setRoutViaPortTpCd(locTpCd);
						via.setRoutViaPortDefCd(strDestViaCd);
						via.setPrcProgStsCd("I");
						via.setSrcInfoCd("NW");
						via.setN1stCmncAmdtSeq(strAmdtSeq);
						via.setCreUsrId(strCreUsrId);
						via.setUpdUsrId(strUpdUsrId);

						viaVoList.add(via);
					}
				}
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					nextRoutPntSeq++;

					String locTpCd = strDestPntCd.length() == 4 ? "G" : "L";

					PriRpScpRtRoutPntVO pnt = new PriRpScpRtRoutPntVO();
					pnt.setPropNo(strPropNo);
					pnt.setAmdtSeq(strAmdtSeq);
					pnt.setSvcScpCd(strSvcScpCd);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("D");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strDestPntCd);
					pnt.setRcvDeTermCd(strDestRcvDeTermCd);
					pnt.setPrcTrspModCd(strDestPrcTrspModCd);
					pnt.setPrcProgStsCd("I");
					pnt.setSrcInfoCd("NW");
					pnt.setN1stCmncAmdtSeq(strAmdtSeq);
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);
					pnt.setBsePortLocCd(strDestBasePortLocCd);
					pnt.setFicRoutCmbTpCd(strFicDestRoutCmbTpCd);
					pntVoList.add(pnt);
				}

				if (strRateAmt != null && !"".equals(strRateAmt)) {
					nextRtSeq++;

					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd(strPerTypeCd);
					rt.setPrcCgoTpCd(strCgoTypeCd);
					rt.setCurrCd(strCurrCd);
					rt.setPropFrtRtAmt(strRateAmt);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					/**
					 * Guide Line 정보 저장
					 */
					rt.setFicOrgPropRtAmt(strFicOrgPropRtAmt);
					rt.setFicOrgGlineRtAmt(strFicOrgGlineRtAmt);
					rt.setOrgOptmTrspModFlg(strOrgOptmTrspModFlg);
					rt.setFicOrgRtUseStsCd(strFicOrgRtUseStsCd);

					rt.setFicDestPropRtAmt(strFicDestPropRtAmt);
					rt.setFicDestGlineRtAmt(strFicDestGlineRtAmt);
					rt.setDestOptmTrspModFlg(strDestOptmTrspModFlg);
					rt.setFicDestRtUseStsCd(strFicDestRtUseStsCd);

					rtVoList.add(rt);

					if (strBucAmt != null && !"".equals(strBucAmt)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd(strPerTypeCd);
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucAmt);
						scg.setAdjScgUsdAmt(strBucAmt);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strIfcAmt != null && !"".equals(strIfcAmt)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd(strPerTypeCd);
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcAmt);
						scg.setAdjScgUsdAmt(strIfcAmt);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strPscAmt != null && !"".equals(strPscAmt)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd(strPerTypeCd);
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscAmt);
						scg.setAdjScgUsdAmt(strPscAmt);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
				}
			}

			if (cmdtHdrVoList.size() > 0) {
				dbDao.addRateCommodityHeader(cmdtHdrVoList);
			}
			if (cmdtVoList.size() > 0) {
				dbDao.addRateCommodity(cmdtVoList);
			}
			if (custVoList.size() > 0) {
				dbDao.addRateActualCustomer(custVoList);
			}

			if (routVoList.size() > 0) {
				dbDao.addRateCommodityRoute(routVoList);
			}
			if (pntVoList.size() > 0) {
				dbDao.addRateRoutePoint(pntVoList);
			}
			if (viaVoList.size() > 0) {
				dbDao.addRateRouteVia(viaVoList);
			}

			if (rtVoList.size() > 0) {
				dbDao.addRateForAddOnTariff(rtVoList);
			}
			if (scgVoList.size() > 0) {
				dbDao.addRateSurcharge(scgVoList);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

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
			RsltRtListVerticalExcelForAddOnTariffVO[] rsltRtListVerticalExcelForAddOnTariffVOs, SignOnUserAccount account) throws EventException {
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		UploadRateExcelVerticalForAddOnTariffBackEndJobImpl jobImpl = new UploadRateExcelVerticalForAddOnTariffBackEndJobImpl();
		String key = null;

		try {
			jobImpl.setPriRpScpRtCmdtHdrVO(priRpScpRtCmdtHdrVO);
			jobImpl.setRsltRtListVerticalExcelForAddOnTariffVOs(rsltRtListVerticalExcelForAddOnTariffVOs);
			jobImpl.setAccount(account);

			key = backEndJobManager.execute(jobImpl, account.getUsr_id(), "ESM_PRI_2067");
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return key;
	}

	/**
	 * Load된 엑셀 데이터가 올바른지 Check한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelForAddOnTariffVO[] rsltRtListHorizontalExcelForAddOnTariffVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> checkRateExcelHorizontalForAddOnTariff(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO,
			RsltRtListHorizontalExcelForAddOnTariffVO[] rsltRtListHorizontalExcelForAddOnTariffVOs) throws EventException {
		List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();

		try {
			RsltRtListHorizontalExcelForAddOnTariffVO row = new RsltRtListHorizontalExcelForAddOnTariffVO();

			String strCmdtCd = null;
			String strCustSeq = null;
			String strOrgPntCd = null;
			String strOrgViaCd = null;
			String strDestViaCd = null;
			String strDestPntCd = null;

			for (int i = 0; i < rsltRtListHorizontalExcelForAddOnTariffVOs.length; i++) {
				row = rsltRtListHorizontalExcelForAddOnTariffVOs[i];

				strCmdtCd = row.getPrcCmdtDefCd();
				strCustSeq = row.getCustSeq();
				strOrgPntCd = row.getOrgRoutPntLocDefCd();
				strOrgViaCd = row.getOrgRoutViaPortDefCd();
				strDestViaCd = row.getDestRoutViaPortDefCd();
				strDestPntCd = row.getDestRoutPntLocDefCd();

				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strCmdtCd);

					RsltCdListVO cdVO = dbDao.searchCommodityCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strCmdtCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("prc_cmdt_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strCustSeq != null && !"".equals(strCustSeq)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strCustSeq);

					RsltCdListVO cdVO = dbDao.searchActualCustomerExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strCustSeq);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("cust_seq");

						rslt.add(cdVO);
					}
				}
				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strOrgPntCd);
					paramVO.setEtc1("O");

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strOrgPntCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("org_rout_pnt_loc_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strOrgViaCd);

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strOrgViaCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("org_rout_via_port_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strDestViaCd);

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strDestViaCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("dest_rout_via_port_def_cd");

						rslt.add(cdVO);
					}
				}
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					RsltCdListVO paramVO = new RsltCdListVO();
					paramVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
					paramVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
					paramVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
					paramVO.setCd(strDestPntCd);
					paramVO.setEtc1("D");

					RsltCdListVO cdVO = dbDao.searchLocationCodeExists(paramVO);
					if (cdVO == null) {
						cdVO = new RsltCdListVO();
						cdVO.setCd(strDestPntCd);
						cdVO.setNm("");
						cdVO.setEtc1(String.valueOf(i));
						cdVO.setEtc2("dest_rout_pnt_loc_def_cd");

						rslt.add(cdVO);
					}
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return rslt;
	}

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
			RsltRtListHorizontalExcelForAddOnTariffVO[] rsltRtListHorizontalExcelForAddOnTariffVOs, SignOnUserAccount account) throws EventException {
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		UploadRateExcelHorizontalForAddOnTariffBackEndJobImpl jobImpl = new UploadRateExcelHorizontalForAddOnTariffBackEndJobImpl();
		String key = null;

		try {
			jobImpl.setPriRpScpRtCmdtHdrVO(priRpScpRtCmdtHdrVO);
			jobImpl.setRsltRtListHorizontalExcelForAddOnTariffVOs(rsltRtListHorizontalExcelForAddOnTariffVOs);
			jobImpl.setAccount(account);

			key = backEndJobManager.execute(jobImpl, account.getUsr_id(), "ESM_PRI_0099");
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return key;
	}

	/**
	 * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelForAddOnTariffVO[] rsltRtListHorizontalExcelForAddOnTariffVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void uploadRateExcelHorizontalOnlineForAddOnTariff(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO,
			RsltRtListHorizontalExcelForAddOnTariffVO[] rsltRtListHorizontalExcelForAddOnTariffVOs, SignOnUserAccount account) throws EventException {
		List<PriRpScpRtCmdtHdrVO> cmdtHdrVoList = new ArrayList<PriRpScpRtCmdtHdrVO>();
		List<PriRpScpRtCmdtVO> cmdtVoList = new ArrayList<PriRpScpRtCmdtVO>();
		List<PriRpScpRtActCustVO> custVoList = new ArrayList<PriRpScpRtActCustVO>();
		List<PriRpScpRtCmdtRoutVO> routVoList = new ArrayList<PriRpScpRtCmdtRoutVO>();
		List<PriRpScpRtRoutPntVO> pntVoList = new ArrayList<PriRpScpRtRoutPntVO>();
		List<PriRpScpRtRoutViaVO> viaVoList = new ArrayList<PriRpScpRtRoutViaVO>();
		List<PriRpScpRtVO> rtVoList = new ArrayList<PriRpScpRtVO>();
		List<PriRpScpRtScgVO> scgVoList = new ArrayList<PriRpScpRtScgVO>();

		try {
			int nextCmdtHdrSeq = dbDao.searchNextCmdtHdrSeq(priRpScpRtCmdtHdrVO);
			int nextBletDpSeq = Integer.parseInt(dbDao.searchMaxBulletDispSeq(priRpScpRtCmdtHdrVO));
			int nextCmdtSeq = 0;
			int nextActCustSeq = 0;

			int nextRoutSeq = 0;
			int nextRoutPntSeq = 0;
			int nextRoutViaSeq = 0;
			int nextRtSeq = 0;

			String strPropNo = priRpScpRtCmdtHdrVO.getPropNo();
			String strAmdtSeq = priRpScpRtCmdtHdrVO.getAmdtSeq();
			String strSvcScpCd = priRpScpRtCmdtHdrVO.getSvcScpCd();
			String strCreUsrId = account.getUsr_id();
			String strUpdUsrId = account.getUsr_id();

			for (int i = 0; i < rsltRtListHorizontalExcelForAddOnTariffVOs.length; i++) {
				RsltRtListHorizontalExcelForAddOnTariffVO row = rsltRtListHorizontalExcelForAddOnTariffVOs[i];

				String strCmdtDpSeq = row.getCmdtDpSeq();
				String strCmdtCd = row.getPrcCmdtDefCd();
				String strCustSeq = row.getCustSeq();

				String strRoutDpSeq = row.getRoutDpSeq();
				String strOrgPntCd = row.getOrgRoutPntLocDefCd();
				String strOrgRcvDeTermCd = row.getOrgRcvDeTermNm();
				String strOrgPrcTrspModCd = row.getOrgPrcTrspModNm();
				String strOrgViaCd = row.getOrgRoutViaPortDefCd();
				String strDestViaCd = row.getDestRoutViaPortDefCd();
				String strDestPntCd = row.getDestRoutPntLocDefCd();
				String strDestRcvDeTermCd = row.getDestRcvDeTermNm();
				String strDestPrcTrspModCd = row.getDestPrcTrspModNm();

				String strRateDry20 = row.getRateDry20();
				String strRateDry40 = row.getRateDry40();
				String strRateDry40hc = row.getRateDry40hc();
				String strRateDry45 = row.getRateDry45();
				String strRateRf40hc = row.getRateRf40hc();
				String strRateRd40hc = row.getRateRd40hc();

				String strBucDry20 = row.getBucDry20();
				String strBucDry40 = row.getBucDry40();
				String strBucDry40hc = row.getBucDry40hc();
				String strBucDry45 = row.getBucDry45();
				String strBucRf40hc = row.getBucRf40hc();
				String strBucRd40hc = row.getBucRd40hc();

				String strIfcDry20 = row.getIfcDry20();
				String strIfcDry40 = row.getIfcDry40();
				String strIfcDry40hc = row.getIfcDry40hc();
				String strIfcDry45 = row.getIfcDry45();
				String strIfcRf40hc = row.getIfcRf40hc();
				String strIfcRd40hc = row.getIfcRd40hc();

				String strPscDry20 = row.getPscDry20();
				String strPscDry40 = row.getPscDry40();
				String strPscDry40hc = row.getPscDry40hc();
				String strPscDry45 = row.getPscDry45();
				String strPscRf40hc = row.getPscRf40hc();
				String strPscRd40hc = row.getPscRd40hc();

				/**
				 * 2012.07.02 추가
				 */
				String strOrgBasePortLocCd = row.getOrgBsePortLocCd();
				String strFicOrgRoutCmbTpCd = row.getFicOrgRoutCmbTpCd();

				String strOrgRatePropDry20 = row.getFicOrgRatePropDry20();
				String strOrgRatePropDry40 = row.getFicOrgRatePropDry40();
				String strOrgRatePropDry40hc = row.getFicOrgRatePropDry40hc();
				String strOrgRatePropDry45 = row.getFicOrgRatePropDry45();
				String strOrgRatePropRf40hc = row.getFicOrgRatePropRf40hc();
				String strOrgRatePropRd40hc = row.getFicOrgRatePropRd40hc();

				String strFicOrgGlineRtAmtDry20 = row.getFicOrgGlineRtAmtDry20();
				String strFicOrgGlineRtAmtDry40 = row.getFicOrgGlineRtAmtDry40();
				String strFicOrgGlineRtAmtDry40hc = row.getFicOrgGlineRtAmtDry40hc();
				String strFicOrgGlineRtAmtDry45 = row.getFicOrgGlineRtAmtDry45();
				String strFicOrgGlineRtAmtRf40hc = row.getFicOrgGlineRtAmtRf40hc();
				String strFicOrgGlineRtAmtRd40hc = row.getFicOrgGlineRtAmtRd40hc();

				String strFicOrgRtUseStsCdDry20 = row.getFicOrgRtUseStsCdDry20();
				String strFicOrgRtUseStsCdDry40 = row.getFicOrgRtUseStsCdDry40();
				String strFicOrgRtUseStsCdDry40hc = row.getFicOrgRtUseStsCdDry40hc();
				String strFicOrgRtUseStsCdDry45 = row.getFicOrgRtUseStsCdDry45();
				String strFicOrgRtUseStsCdRf40hc = row.getFicOrgRtUseStsCdRf40hc();
				String strFicOrgRtUseStsCdRd40hc = row.getFicOrgRtUseStsCdRd40hc();

				String strOrgOptmTrspModFlgDry20 = row.getOrgOptmTrspModFlgDry20();
				String strOrgOptmTrspModFlgDry40 = row.getOrgOptmTrspModFlgDry40();
				String strOrgOptmTrspModFlgDry40hc = row.getOrgOptmTrspModFlgDry40hc();
				String strOrgOptmTrspModFlgDry45 = row.getOrgOptmTrspModFlgDry45();
				String strOrgOptmTrspModFlgRf40hc = row.getOrgOptmTrspModFlgRf40hc();
				String strOrgOptmTrspModFlgRd40hc = row.getOrgOptmTrspModFlgRd40hc();

				String strDestBasePortLocCd = row.getDestBsePortLocCd();
				String strFicDestRoutCmbTpCd = row.getFicDestRoutCmbTpCd();

				String strDestRatePropDry20 = row.getFicDestRatePropDry20();
				String strDestRatePropDry40 = row.getFicDestRatePropDry40();
				String strDestRatePropDry40hc = row.getFicDestRatePropDry40hc();
				String strDestRatePropDry45 = row.getFicDestRatePropDry45();
				String strDestRatePropRf40hc = row.getFicDestRatePropRf40hc();
				String strDestRatePropRd40hc = row.getFicDestRatePropRd40hc();

				String strFicDestGlineRtAmtDry20 = row.getFicDestGlineRtAmtDry20();
				String strFicDestGlineRtAmtDry40 = row.getFicDestGlineRtAmtDry40();
				String strFicDestGlineRtAmtDry40hc = row.getFicDestGlineRtAmtDry40hc();
				String strFicDestGlineRtAmtDry45 = row.getFicDestGlineRtAmtDry45();
				String strFicDestGlineRtAmtRf40hc = row.getFicDestGlineRtAmtRf40hc();
				String strFicDestGlineRtAmtRd40hc = row.getFicDestGlineRtAmtRd40hc();

				String strFicDestRtUseStsCdDry20 = row.getFicDestRtUseStsCdDry20();
				String strFicDestRtUseStsCdDry40 = row.getFicDestRtUseStsCdDry40();
				String strFicDestRtUseStsCdDry40hc = row.getFicDestRtUseStsCdDry40hc();
				String strFicDestRtUseStsCdDry45 = row.getFicDestRtUseStsCdDry45();
				String strFicDestRtUseStsCdRf40hc = row.getFicDestRtUseStsCdRf40hc();
				String strFicDestRtUseStsCdRd40hc = row.getFicDestRtUseStsCdRd40hc();

				String strDestOptmTrspModFlgDry20 = row.getDestOptmTrspModFlgDry20();
				String strDestOptmTrspModFlgDry40 = row.getDestOptmTrspModFlgDry40();
				String strDestOptmTrspModFlgDry40hc = row.getDestOptmTrspModFlgDry40hc();
				String strDestOptmTrspModFlgDry45 = row.getDestOptmTrspModFlgDry45();
				String strDestOptmTrspModFlgRf40hc = row.getDestOptmTrspModFlgRf40hc();
				String strDestOptmTrspModFlgRd40hc = row.getDestOptmTrspModFlgRd40hc();

				if (strCmdtDpSeq != null && !"".equals(strCmdtDpSeq)) {
					nextCmdtHdrSeq++;
					nextBletDpSeq++;
					nextCmdtSeq = 0;
					nextActCustSeq = 0;
					nextRoutSeq = 0;

					PriRpScpRtCmdtHdrVO cmdtHdr = new PriRpScpRtCmdtHdrVO();
					cmdtHdr.setPropNo(strPropNo);
					cmdtHdr.setAmdtSeq(strAmdtSeq);
					cmdtHdr.setSvcScpCd(strSvcScpCd);
					cmdtHdr.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdtHdr.setBletDpSeq(String.valueOf(nextBletDpSeq));
					cmdtHdr.setN1stCmncAmdtSeq(strAmdtSeq);
					cmdtHdr.setCreUsrId(strCreUsrId);
					cmdtHdr.setUpdUsrId(strUpdUsrId);
					cmdtHdr.setFicRtTpCd(priRpScpRtCmdtHdrVO.getFicRtTpCd());
					cmdtHdrVoList.add(cmdtHdr);
				}

				if (strCmdtCd != null && !"".equals(strCmdtCd)) {
					nextCmdtSeq++;

					String cmdtTpCd = "";
					if (strCmdtCd.length() == 5) {
						cmdtTpCd = "G";
					} else if (strCmdtCd.length() == 4) {
						cmdtTpCd = "R";
					} else if (strCmdtCd.length() == 6) {
						cmdtTpCd = "C";
					}

					PriRpScpRtCmdtVO cmdt = new PriRpScpRtCmdtVO();
					cmdt.setPropNo(strPropNo);
					cmdt.setAmdtSeq(strAmdtSeq);
					cmdt.setSvcScpCd(strSvcScpCd);
					cmdt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cmdt.setCmdtSeq(String.valueOf(nextCmdtSeq));
					cmdt.setPrcCmdtTpCd(cmdtTpCd);
					cmdt.setPrcCmdtDefCd(strCmdtCd);
					cmdt.setPrcProgStsCd("I");
					cmdt.setSrcInfoCd("NW");
					cmdt.setN1stCmncAmdtSeq(strAmdtSeq);
					cmdt.setCreUsrId(strCreUsrId);
					cmdt.setUpdUsrId(strUpdUsrId);

					cmdtVoList.add(cmdt);
				}
				if (strCustSeq != null && !"".equals(strCustSeq)) {
					nextActCustSeq++;

					PriRpScpRtActCustVO cust = new PriRpScpRtActCustVO();
					cust.setPropNo(strPropNo);
					cust.setAmdtSeq(strAmdtSeq);
					cust.setSvcScpCd(strSvcScpCd);
					cust.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					cust.setActCustSeq(String.valueOf(nextActCustSeq));
					cust.setCustCntCd(strCustSeq.substring(0, 2));
					cust.setCustSeq(strCustSeq.substring(2));
					cust.setPrcProgStsCd("I");
					cust.setSrcInfoCd("NW");
					cust.setN1stCmncAmdtSeq(strAmdtSeq);
					cust.setCreUsrId(strCreUsrId);
					cust.setUpdUsrId(strUpdUsrId);

					custVoList.add(cust);
				}

				if (strRoutDpSeq != null && !"".equals(strRoutDpSeq)) {
					nextRoutSeq++;
					nextRoutPntSeq = 0;
					nextRoutViaSeq = 0;
					nextRtSeq = 0;

					PriRpScpRtCmdtRoutVO rout = new PriRpScpRtCmdtRoutVO();
					rout.setPropNo(strPropNo);
					rout.setAmdtSeq(strAmdtSeq);
					rout.setSvcScpCd(strSvcScpCd);
					rout.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rout.setRoutSeq(String.valueOf(nextRoutSeq));
					rout.setN1stCmncAmdtSeq(strAmdtSeq);
					rout.setCreUsrId(strCreUsrId);
					rout.setUpdUsrId(strUpdUsrId);
					rout.setOrgCyDorRtTpCd(row.getOrgCyDorRtTpCd());
					rout.setDestCyDorRtTpCd(row.getDestCyDorRtTpCd());
					routVoList.add(rout);
				}

				if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
					nextRoutPntSeq++;

					String locTpCd = strOrgPntCd.length() == 4 ? "G" : "L";

					PriRpScpRtRoutPntVO pnt = new PriRpScpRtRoutPntVO();
					pnt.setPropNo(strPropNo);
					pnt.setAmdtSeq(strAmdtSeq);
					pnt.setSvcScpCd(strSvcScpCd);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("O");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strOrgPntCd);
					pnt.setRcvDeTermCd(strOrgRcvDeTermCd);
					pnt.setPrcTrspModCd(strOrgPrcTrspModCd);
					pnt.setPrcProgStsCd("I");
					pnt.setSrcInfoCd("NW");
					pnt.setN1stCmncAmdtSeq(strAmdtSeq);
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);

					pnt.setBsePortLocCd(strOrgBasePortLocCd);
					pnt.setFicRoutCmbTpCd(strFicOrgRoutCmbTpCd);

					pntVoList.add(pnt);
				}
				if (strOrgViaCd != null && !"".equals(strOrgViaCd)) {
					boolean dupChk = false;
					dupChk = duplicateRouteVia(viaVoList, strPropNo, strAmdtSeq, strSvcScpCd, nextCmdtHdrSeq, nextRoutSeq, strOrgViaCd);
					if (!dupChk) {
						nextRoutViaSeq++;

						String locTpCd = strOrgViaCd.length() == 4 ? "G" : "L";

						PriRpScpRtRoutViaVO via = new PriRpScpRtRoutViaVO();
						via.setPropNo(strPropNo);
						via.setAmdtSeq(strAmdtSeq);
						via.setSvcScpCd(strSvcScpCd);
						via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						via.setRoutSeq(String.valueOf(nextRoutSeq));
						via.setOrgDestTpCd("O");
						via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
						via.setRoutViaPortTpCd(locTpCd);
						via.setRoutViaPortDefCd(strOrgViaCd);
						via.setPrcProgStsCd("I");
						via.setSrcInfoCd("NW");
						via.setN1stCmncAmdtSeq(strAmdtSeq);
						via.setCreUsrId(strCreUsrId);
						via.setUpdUsrId(strUpdUsrId);

						viaVoList.add(via);
					}
				}
				if (strDestViaCd != null && !"".equals(strDestViaCd)) {
					boolean dupChk = false;
					dupChk = duplicateRouteVia(viaVoList, strPropNo, strAmdtSeq, strSvcScpCd, nextCmdtHdrSeq, nextRoutSeq, strDestViaCd);
					if (!dupChk) {
						nextRoutViaSeq++;

						String locTpCd = strDestViaCd.length() == 4 ? "G" : "L";

						PriRpScpRtRoutViaVO via = new PriRpScpRtRoutViaVO();
						via.setPropNo(strPropNo);
						via.setAmdtSeq(strAmdtSeq);
						via.setSvcScpCd(strSvcScpCd);
						via.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						via.setRoutSeq(String.valueOf(nextRoutSeq));
						via.setOrgDestTpCd("D");
						via.setRoutViaSeq(String.valueOf(nextRoutViaSeq));
						via.setRoutViaPortTpCd(locTpCd);
						via.setRoutViaPortDefCd(strDestViaCd);
						via.setPrcProgStsCd("I");
						via.setSrcInfoCd("NW");
						via.setN1stCmncAmdtSeq(strAmdtSeq);
						via.setCreUsrId(strCreUsrId);
						via.setUpdUsrId(strUpdUsrId);

						viaVoList.add(via);
					}
				}
				if (strDestPntCd != null && !"".equals(strDestPntCd)) {
					nextRoutPntSeq++;

					String locTpCd = strDestPntCd.length() == 4 ? "G" : "L";

					PriRpScpRtRoutPntVO pnt = new PriRpScpRtRoutPntVO();
					pnt.setPropNo(strPropNo);
					pnt.setAmdtSeq(strAmdtSeq);
					pnt.setSvcScpCd(strSvcScpCd);
					pnt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					pnt.setRoutSeq(String.valueOf(nextRoutSeq));
					pnt.setOrgDestTpCd("D");
					pnt.setRoutPntSeq(String.valueOf(nextRoutPntSeq));
					pnt.setRoutPntLocTpCd(locTpCd);
					pnt.setRoutPntLocDefCd(strDestPntCd);
					pnt.setRcvDeTermCd(strDestRcvDeTermCd);
					pnt.setPrcTrspModCd(strDestPrcTrspModCd);
					pnt.setPrcProgStsCd("I");
					pnt.setSrcInfoCd("NW");
					pnt.setN1stCmncAmdtSeq(strAmdtSeq);
					pnt.setCreUsrId(strCreUsrId);
					pnt.setUpdUsrId(strUpdUsrId);

					pnt.setBsePortLocCd(strDestBasePortLocCd);
					pnt.setFicRoutCmbTpCd(strFicDestRoutCmbTpCd);
					pntVoList.add(pnt);
				}

				if (strRateDry20 != null && !"".equals(strRateDry20)) {
					nextRtSeq++;

					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("D2");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setPropFrtRtAmt(strRateDry20);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					/**
					 * Guide Line 정보 저장
					 */
					rt.setFicOrgPropRtAmt(strOrgRatePropDry20);
					rt.setFicOrgGlineRtAmt(strFicOrgGlineRtAmtDry20);
					rt.setOrgOptmTrspModFlg(strOrgOptmTrspModFlgDry20);
					rt.setFicOrgRtUseStsCd(strFicOrgRtUseStsCdDry20);

					rt.setFicDestPropRtAmt(strDestRatePropDry20);
					rt.setFicDestGlineRtAmt(strFicDestGlineRtAmtDry20);
					rt.setDestOptmTrspModFlg(strDestOptmTrspModFlgDry20);
					rt.setFicDestRtUseStsCd(strFicDestRtUseStsCdDry20);

					rtVoList.add(rt);

					if (strBucDry20 != null && !"".equals(strBucDry20)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd("D2");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucDry20);
						scg.setAdjScgUsdAmt(strBucDry20);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strIfcDry20 != null && !"".equals(strIfcDry20)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd("D2");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcDry20);
						scg.setAdjScgUsdAmt(strIfcDry20);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strPscDry20 != null && !"".equals(strPscDry20)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd("D2");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscDry20);
						scg.setAdjScgUsdAmt(strPscDry20);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
				}

				if (strRateDry40 != null && !"".equals(strRateDry40)) {
					nextRtSeq++;

					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("D4");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setPropFrtRtAmt(strRateDry40);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					/**
					 * Guide Line 정보 저장
					 */
					rt.setFicOrgPropRtAmt(strOrgRatePropDry40);
					rt.setFicOrgGlineRtAmt(strFicOrgGlineRtAmtDry40);
					rt.setOrgOptmTrspModFlg(strOrgOptmTrspModFlgDry40);
					rt.setFicOrgRtUseStsCd(strFicOrgRtUseStsCdDry40);

					rt.setFicDestPropRtAmt(strDestRatePropDry40);
					rt.setFicDestGlineRtAmt(strFicDestGlineRtAmtDry40);
					rt.setDestOptmTrspModFlg(strDestOptmTrspModFlgDry40);
					rt.setFicDestRtUseStsCd(strFicDestRtUseStsCdDry40);

					rtVoList.add(rt);

					if (strBucDry40 != null && !"".equals(strBucDry40)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd("D4");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucDry40);
						scg.setAdjScgUsdAmt(strBucDry40);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strIfcDry40 != null && !"".equals(strIfcDry40)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd("D4");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcDry40);
						scg.setAdjScgUsdAmt(strIfcDry40);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strPscDry40 != null && !"".equals(strPscDry40)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd("D4");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscDry40);
						scg.setAdjScgUsdAmt(strPscDry40);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
				}

				if (strRateDry40hc != null && !"".equals(strRateDry40hc)) {
					nextRtSeq++;

					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("D5");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setPropFrtRtAmt(strRateDry40hc);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					/**
					 * Guide Line 정보 저장
					 */
					rt.setFicOrgPropRtAmt(strOrgRatePropDry40hc);
					rt.setFicOrgGlineRtAmt(strFicOrgGlineRtAmtDry40hc);
					rt.setOrgOptmTrspModFlg(strOrgOptmTrspModFlgDry40hc);
					rt.setFicOrgRtUseStsCd(strFicOrgRtUseStsCdDry40hc);

					rt.setFicDestPropRtAmt(strDestRatePropDry40hc);
					rt.setFicDestGlineRtAmt(strFicDestGlineRtAmtDry40hc);
					rt.setDestOptmTrspModFlg(strDestOptmTrspModFlgDry40hc);
					rt.setFicDestRtUseStsCd(strFicDestRtUseStsCdDry40hc);

					rtVoList.add(rt);

					if (strBucDry40hc != null && !"".equals(strBucDry40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd("D5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucDry40hc);
						scg.setAdjScgUsdAmt(strBucDry40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strIfcDry40hc != null && !"".equals(strIfcDry40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd("D5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcDry40hc);
						scg.setAdjScgUsdAmt(strIfcDry40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strPscDry40hc != null && !"".equals(strPscDry40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd("D5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscDry40hc);
						scg.setAdjScgUsdAmt(strPscDry40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
				}

				if (strRateDry45 != null && !"".equals(strRateDry45)) {
					nextRtSeq++;

					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("D7");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setPropFrtRtAmt(strRateDry45);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					/**
					 * Guide Line 정보 저장
					 */
					rt.setFicOrgPropRtAmt(strOrgRatePropDry45);
					rt.setFicOrgGlineRtAmt(strFicOrgGlineRtAmtDry45);
					rt.setOrgOptmTrspModFlg(strOrgOptmTrspModFlgDry45);
					rt.setFicOrgRtUseStsCd(strFicOrgRtUseStsCdDry45);

					rt.setFicDestPropRtAmt(strDestRatePropDry45);
					rt.setFicDestGlineRtAmt(strFicDestGlineRtAmtDry45);
					rt.setDestOptmTrspModFlg(strDestOptmTrspModFlgDry45);
					rt.setFicDestRtUseStsCd(strFicDestRtUseStsCdDry45);

					rtVoList.add(rt);

					if (strBucDry45 != null && !"".equals(strBucDry45)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd("D7");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucDry45);
						scg.setAdjScgUsdAmt(strBucDry45);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strIfcDry45 != null && !"".equals(strIfcDry45)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd("D7");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcDry45);
						scg.setAdjScgUsdAmt(strIfcDry45);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strPscDry45 != null && !"".equals(strPscDry45)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd("D7");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscDry45);
						scg.setAdjScgUsdAmt(strPscDry45);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
				}

				if (strRateRf40hc != null && !"".equals(strRateRf40hc)) {
					nextRtSeq++;

					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("R5");
					rt.setPrcCgoTpCd("RF");
					rt.setCurrCd("USD");
					rt.setPropFrtRtAmt(strRateRf40hc);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					/**
					 * Guide Line 정보 저장
					 */
					rt.setFicOrgPropRtAmt(strOrgRatePropRf40hc);
					rt.setFicOrgGlineRtAmt(strFicOrgGlineRtAmtRf40hc);
					rt.setOrgOptmTrspModFlg(strOrgOptmTrspModFlgRf40hc);
					rt.setFicOrgRtUseStsCd(strFicOrgRtUseStsCdRf40hc);

					rt.setFicDestPropRtAmt(strDestRatePropRf40hc);
					rt.setFicDestGlineRtAmt(strFicDestGlineRtAmtRf40hc);
					rt.setDestOptmTrspModFlg(strDestOptmTrspModFlgRf40hc);
					rt.setFicDestRtUseStsCd(strFicDestRtUseStsCdRf40hc);

					rtVoList.add(rt);

					if (strBucRf40hc != null && !"".equals(strBucRf40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd("R5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucRf40hc);
						scg.setAdjScgUsdAmt(strBucRf40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strIfcRf40hc != null && !"".equals(strIfcRf40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd("R5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcRf40hc);
						scg.setAdjScgUsdAmt(strIfcRf40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strPscRf40hc != null && !"".equals(strPscRf40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd("R5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscRf40hc);
						scg.setAdjScgUsdAmt(strPscRf40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
				}

				if (strRateRd40hc != null && !"".equals(strRateRd40hc)) {
					nextRtSeq++;

					PriRpScpRtVO rt = new PriRpScpRtVO();
					rt.setPropNo(strPropNo);
					rt.setAmdtSeq(strAmdtSeq);
					rt.setSvcScpCd(strSvcScpCd);
					rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
					rt.setRoutSeq(String.valueOf(nextRoutSeq));
					rt.setRtSeq(String.valueOf(nextRtSeq));
					rt.setRatUtCd("R5");
					rt.setPrcCgoTpCd("DR");
					rt.setCurrCd("USD");
					rt.setPropFrtRtAmt(strRateRd40hc);
					rt.setGriApplTpCd("N");
					rt.setGriApplAmt("0");
					rt.setPrcProgStsCd("I");
					rt.setSrcInfoCd("NW");
					rt.setN1stCmncAmdtSeq(strAmdtSeq);
					rt.setCreUsrId(strCreUsrId);
					rt.setUpdUsrId(strUpdUsrId);

					/**
					 * Guide Line 정보 저장
					 */
					rt.setFicOrgPropRtAmt(strOrgRatePropRd40hc);
					rt.setFicOrgGlineRtAmt(strFicOrgGlineRtAmtRd40hc);
					rt.setOrgOptmTrspModFlg(strOrgOptmTrspModFlgRd40hc);
					rt.setFicOrgRtUseStsCd(strFicOrgRtUseStsCdRd40hc);

					rt.setFicDestPropRtAmt(strDestRatePropRd40hc);
					rt.setFicDestGlineRtAmt(strFicDestGlineRtAmtRd40hc);
					rt.setDestOptmTrspModFlg(strDestOptmTrspModFlgRd40hc);
					rt.setFicDestRtUseStsCd(strFicDestRtUseStsCdRd40hc);

					rtVoList.add(rt);

					if (strBucRd40hc != null && !"".equals(strBucRd40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("BUC");
						scg.setBkgRatUtCd("R5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strBucRd40hc);
						scg.setAdjScgUsdAmt(strBucRd40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strIfcRd40hc != null && !"".equals(strIfcRd40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("IFC");
						scg.setBkgRatUtCd("R5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strIfcRd40hc);
						scg.setAdjScgUsdAmt(strIfcRd40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
					if (strPscRd40hc != null && !"".equals(strPscRd40hc)) {
						PriRpScpRtScgVO scg = new PriRpScpRtScgVO();
						scg.setPropNo(strPropNo);
						scg.setAmdtSeq(strAmdtSeq);
						scg.setSvcScpCd(strSvcScpCd);
						scg.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
						scg.setRoutSeq(String.valueOf(nextRoutSeq));
						scg.setRtSeq(String.valueOf(nextRtSeq));
						scg.setChgCd("PSC");
						scg.setBkgRatUtCd("R5");
						scg.setCurrCd("USD");
						scg.setTrfScgAmt("0");
						scg.setAdjScgAmt(strPscRd40hc);
						scg.setAdjScgUsdAmt(strPscRd40hc);
						scg.setAdjFlg("N");
						scg.setCreUsrId(strCreUsrId);
						scg.setUpdUsrId(strUpdUsrId);

						scgVoList.add(scg);
					}
				}
			}

			if (cmdtHdrVoList.size() > 0) {
				dbDao.addRateCommodityHeader(cmdtHdrVoList);
			}
			if (cmdtVoList.size() > 0) {
				dbDao.addRateCommodity(cmdtVoList);
			}
			if (custVoList.size() > 0) {
				dbDao.addRateActualCustomer(custVoList);
			}

			if (routVoList.size() > 0) {
				dbDao.addRateCommodityRoute(routVoList);
			}
			if (pntVoList.size() > 0) {
				dbDao.addRateRoutePoint(pntVoList);
			}
			if (viaVoList.size() > 0) {
				dbDao.addRateRouteVia(viaVoList);
			}

			if (rtVoList.size() > 0) {
				dbDao.addRateForAddOnTariff(rtVoList);
			}
			if (scgVoList.size() > 0) {
				dbDao.addRateSurcharge(scgVoList);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Route 및 Rate 데이터의 멀티 트랜잭션을 처리한다.<br>
	 * 
	 * @param RfaRtPropRtVO rfaRtPropRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateForAddOnTariff(RfaRtPropRtVO rfaRtPropRtVO, SignOnUserAccount account) throws EventException {
		try {
			PriRpScpRtCmdtRoutVO noteSeqVO = rfaRtPropRtVO.getPriRpScpRtCmdtRoutVO();
			PriRpScpRtCmdtRoutVO[] routvo = rfaRtPropRtVO.getPriRpScpRtCmdtRoutVOS();
			PriRpScpRtRoutPntVO[] orgpntvo = rfaRtPropRtVO.getPriRpScpRtRoutOrgPntVOS();
			PriRpScpRtRoutViaVO[] orgviavo = rfaRtPropRtVO.getPriRpScpRtRoutOrgViaVOS();
			PriRpScpRtRoutViaVO[] destviavo = rfaRtPropRtVO.getPriRpScpRtRoutDestViaVOS();
			PriRpScpRtRoutPntVO[] destpntvo = rfaRtPropRtVO.getPriRpScpRtRoutDestPntVOS();
			PriRpScpRtCmdtRnoteVO[] rnotevo = rfaRtPropRtVO.getPriRpScpRtCmdtRnoteVOS();
			PriRfaNoteConvListVO[] convvo = rfaRtPropRtVO.getPriRfaNoteConvListVOS();
			PriRpScpRtVO[] rtvo = rfaRtPropRtVO.getPriRpScpRtVOS();

			List<PriRpScpRtCmdtRoutVO> insertRoutList = new ArrayList<PriRpScpRtCmdtRoutVO>();
			List<PriRpScpRtCmdtRoutVO> updateRoutList = new ArrayList<PriRpScpRtCmdtRoutVO>();
			List<PriRpScpRtCmdtRoutVO> deleteRoutList = new ArrayList<PriRpScpRtCmdtRoutVO>();
			List<PriRpScpRtRoutPntVO> insertPntList = new ArrayList<PriRpScpRtRoutPntVO>();
			List<PriRpScpRtRoutPntVO> updatePntList = new ArrayList<PriRpScpRtRoutPntVO>();
			List<PriRpScpRtRoutPntVO> deletePntList = new ArrayList<PriRpScpRtRoutPntVO>();
			List<PriRpScpRtRoutViaVO> insertViaList = new ArrayList<PriRpScpRtRoutViaVO>();
			List<PriRpScpRtRoutViaVO> updateViaList = new ArrayList<PriRpScpRtRoutViaVO>();
			List<PriRpScpRtRoutViaVO> deleteViaList = new ArrayList<PriRpScpRtRoutViaVO>();
			List<PriRpScpRtCmdtRnoteVO> insertRnoteList = new ArrayList<PriRpScpRtCmdtRnoteVO>();
			List<PriRpScpRtCmdtRnoteVO> updateRnoteList = new ArrayList<PriRpScpRtCmdtRnoteVO>();
			List<PriRpScpRtCmdtRnoteVO> deleteRnoteList = new ArrayList<PriRpScpRtCmdtRnoteVO>();
			List<PriRfaNoteConvListVO> insertConvList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> updateConvList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> deleteConvList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRpScpRtVO> insertRtList = new ArrayList<PriRpScpRtVO>();
			List<PriRpScpRtVO> updateRtList = new ArrayList<PriRpScpRtVO>();
			List<PriRpScpRtVO> deleteRtList = new ArrayList<PriRpScpRtVO>();
			List<PriRpScpRtVO> amendCancelRtList = new ArrayList<PriRpScpRtVO>();

			for (int i = 0; routvo != null && i < routvo.length; i++) {
				if (routvo[i].getIbflag().equals("I")) {
					routvo[i].setCreUsrId(account.getUsr_id());
					routvo[i].setUpdUsrId(account.getUsr_id());
					insertRoutList.add(routvo[i]);
				} else if (routvo[i].getIbflag().equals("U")) {
					routvo[i].setUpdUsrId(account.getUsr_id());
					if ("-1".equals(routvo[i].getN1stCmncAmdtSeq())) {
						routvo[i].setN1stCmncAmdtSeq(routvo[i].getAmdtSeq());
						deleteRoutList.add(routvo[i]);
					} else {
						updateRoutList.add(routvo[i]);
					}
				} else if (routvo[i].getIbflag().equals("D")) {
					routvo[i].setUpdUsrId(account.getUsr_id());
					deleteRoutList.add(routvo[i]);
				}
			}
			for (int i = 0; orgpntvo != null && i < orgpntvo.length; i++) {
				if (orgpntvo[i].getIbflag().equals("I")) {
					orgpntvo[i].setCreUsrId(account.getUsr_id());
					orgpntvo[i].setUpdUsrId(account.getUsr_id());
					insertPntList.add(orgpntvo[i]);
				} else if (orgpntvo[i].getIbflag().equals("U")) {
					orgpntvo[i].setUpdUsrId(account.getUsr_id());
					updatePntList.add(orgpntvo[i]);
				} else if (orgpntvo[i].getIbflag().equals("D")) {
					deletePntList.add(orgpntvo[i]);
				}
			}
			for (int i = 0; orgviavo != null && i < orgviavo.length; i++) {
				if (orgviavo[i].getIbflag().equals("I")) {
					orgviavo[i].setCreUsrId(account.getUsr_id());
					orgviavo[i].setUpdUsrId(account.getUsr_id());
					insertViaList.add(orgviavo[i]);
				} else if (orgviavo[i].getIbflag().equals("U")) {
					orgviavo[i].setUpdUsrId(account.getUsr_id());
					updateViaList.add(orgviavo[i]);
				} else if (orgviavo[i].getIbflag().equals("D")) {
					deleteViaList.add(orgviavo[i]);
				}
			}
			for (int i = 0; destviavo != null && i < destviavo.length; i++) {
				if (destviavo[i].getIbflag().equals("I")) {
					destviavo[i].setCreUsrId(account.getUsr_id());
					destviavo[i].setUpdUsrId(account.getUsr_id());
					insertViaList.add(destviavo[i]);
				} else if (destviavo[i].getIbflag().equals("U")) {
					destviavo[i].setUpdUsrId(account.getUsr_id());
					updateViaList.add(destviavo[i]);
				} else if (destviavo[i].getIbflag().equals("D")) {
					deleteViaList.add(destviavo[i]);
				}
			}
			for (int i = 0; destpntvo != null && i < destpntvo.length; i++) {
				if (destpntvo[i].getIbflag().equals("I")) {
					destpntvo[i].setCreUsrId(account.getUsr_id());
					destpntvo[i].setUpdUsrId(account.getUsr_id());
					insertPntList.add(destpntvo[i]);
				} else if (destpntvo[i].getIbflag().equals("U")) {
					destpntvo[i].setUpdUsrId(account.getUsr_id());
					updatePntList.add(destpntvo[i]);
				} else if (destpntvo[i].getIbflag().equals("D")) {
					deletePntList.add(destpntvo[i]);
				}
			}
			for (int i = 0; rnotevo != null && i < rnotevo.length; i++) {
				if (rnotevo[i].getIbflag().equals("I")) {
					rnotevo[i].setCreUsrId(account.getUsr_id());
					rnotevo[i].setUpdUsrId(account.getUsr_id());
					insertRnoteList.add(rnotevo[i]);
				} else if (rnotevo[i].getIbflag().equals("U")) {
					rnotevo[i].setUpdUsrId(account.getUsr_id());
					updateRnoteList.add(rnotevo[i]);
				} else if (rnotevo[i].getIbflag().equals("D")) {
					deleteRnoteList.add(rnotevo[i]);
				}
			}
			for (int i = 0; convvo != null && i < convvo.length; i++) {
				if (convvo[i].getIbflag().equals("I")) {
					convvo[i].setCreUsrId(account.getUsr_id());
					convvo[i].setUpdUsrId(account.getUsr_id());
					insertConvList.add(convvo[i]);
				} else if (convvo[i].getIbflag().equals("U")) {
					convvo[i].setUpdUsrId(account.getUsr_id());
					updateConvList.add(convvo[i]);
				} else if (convvo[i].getIbflag().equals("D")) {
					deleteConvList.add(convvo[i]);
				}
			}
			for (int i = 0; rtvo != null && i < rtvo.length; i++) {
				if (rtvo[i].getIbflag().equals("I")) {
					rtvo[i].setCreUsrId(account.getUsr_id());
					rtvo[i].setUpdUsrId(account.getUsr_id());
					insertRtList.add(rtvo[i]);
				} else if (rtvo[i].getIbflag().equals("U")) {
					rtvo[i].setUpdUsrId(account.getUsr_id());
					updateRtList.add(rtvo[i]);

					if ("0".equals(rtvo[i].getAmdtSeq())) {
						continue;
					}
					if (!rtvo[i].getAmdtSeq().equals(rtvo[i].getN1stCmncAmdtSeq())) {
						rtvo[i].setCreUsrId(account.getUsr_id());
						rtvo[i].setUpdUsrId(account.getUsr_id());
						amendCancelRtList.add(rtvo[i]);
					}
				} else if (rtvo[i].getIbflag().equals("D")) {
					deleteRtList.add(rtvo[i]);
				}
			}

			if (insertRoutList.size() > 0) {
				dbDao.addRateCommodityRoute(insertRoutList);
			}
			if (insertPntList.size() > 0) {
				dbDao.addRateRoutePoint(insertPntList);
			}
			if (insertViaList.size() > 0) {
				dbDao.addRateRouteVia(insertViaList);
			}
			if (insertRnoteList.size() > 0) {
				dbDao.addRateCommodityRnote(insertRnoteList);
			}
			if (insertRtList.size() > 0) {
				dbDao.addRateForAddOnTariff(insertRtList);
			}

			if (updateRoutList.size() > 0) {
				dbDao.modifyRateCommodityRoute(updateRoutList, "N");
			}
			if (updatePntList.size() > 0) {
				dbDao.modifyRateRoutePoint(updatePntList, "N");
			}
			if (updateViaList.size() > 0) {
				dbDao.modifyRateRouteVia(updateViaList, "N");
			}
			if (updateRnoteList.size() > 0) {
				dbDao.modifyRateCommodityRnote(updateRnoteList, "N");
			}
			if (updateRtList.size() > 0) {
				dbDao.modifyRateForAddOnTariff(updateRtList, "N");
			}
			if (amendCancelRtList.size() > 0) {
				dbDao.removeRateCascadeScg(amendCancelRtList);
				dbDao.removeRateCascadeScgRout(amendCancelRtList);
				dbDao.removeRateCascadeUsdRoutCs(amendCancelRtList);

				dbDao.addCopyRateSurchargeAmendCancel(amendCancelRtList);
				dbDao.addCopyRateSurchargeRouteAmendCancel(amendCancelRtList);
				dbDao.addCopyRateUsdRouteCsAmendCancel(amendCancelRtList);
			}

			if (deleteRtList.size() > 0) {
				dbDao.removeRateCascadeScg(deleteRtList);
				dbDao.removeRateCascadeScgRout(deleteRtList);
				dbDao.removeRateCascadeUsdRoutCs(deleteRtList);
				dbDao.removeRateCascadeCgoSpec(deleteRtList);
				dbDao.removeRate(deleteRtList);
			}
			if (deleteRnoteList.size() > 0) {
				dbDao.removeRateCommodityRnote(deleteRnoteList);
			}
			if (deleteViaList.size() > 0) {
				dbDao.removeRateRouteVia(deleteViaList);
			}
			if (deletePntList.size() > 0) {
				dbDao.removeRateRoutePoint(deletePntList);
			}
			if (deleteRoutList.size() > 0) {
				dbDao.removeRateCommodityRouteCascadeScg(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeScgRout(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeUsdRoutCs(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeCgoSpec(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeRt(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeRnote(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeRoutVia(deleteRoutList);
				dbDao.removeRateCommodityRouteCascadeRoutPnt(deleteRoutList);
				dbDao.removeRateCommodityRoute(deleteRoutList);

				dbDao.removeRateCommodityRouteDelAmendRt(deleteRoutList);
				dbDao.removeRateCommodityRouteDelAmendRnote(deleteRoutList);
				dbDao.removeRateCommodityRouteDelAmendRoutVia(deleteRoutList);
				dbDao.removeRateCommodityRouteDelAmendRoutPnt(deleteRoutList);
			}

			dbDao.modifyRouteNoteDispSeq(noteSeqVO, "1");

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}
	
	
	/**
	 * Rate 데이터에 GRI Calculation을 적용합니다.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @param CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void applyGRICalculationForAddOnTariff(PriRpScpGriGrpVO priRpScpGriGrpVO, CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs, SignOnUserAccount account)
			throws EventException {
		try {
			if (priRpScpGriGrpVO != null) {
				priRpScpGriGrpVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyApplyGRICalculationForAddOnTariff(priRpScpGriGrpVO, checkGRICalculationValidationVOs);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 적용한 GRI Calculation을 취소합니다.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @param CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGRICalculationForAddOnTariff(PriRpScpGriGrpVO priRpScpGriGrpVO, CheckGRICalculationValidationVO[] checkGRICalculationValidationVOs,
			SignOnUserAccount account) throws EventException {
		try {
			if (priRpScpGriGrpVO != null) {
				priRpScpGriGrpVO.setCreUsrId(account.getUsr_id());
				priRpScpGriGrpVO.setUpdUsrId(account.getUsr_id());

				if (!"0".equals(priRpScpGriGrpVO.getAmdtSeq())) {
					dbDao.removeRateScgOnGRICancel(priRpScpGriGrpVO);
					dbDao.removeRateScgRoutOnGRICancel(priRpScpGriGrpVO);
					dbDao.removeRateUsdRoutCsOnGRICancel(priRpScpGriGrpVO);

					dbDao.addCopyPrevRateScgOnGRICancel(priRpScpGriGrpVO);
					dbDao.addCopyPrevRateScgRoutOnGRICancel(priRpScpGriGrpVO);
					dbDao.addCopyPrevRateUsdRoutCsOnGRICancel(priRpScpGriGrpVO);
				}

				dbDao.modifyProposalScopeRateGRICancelForIHC(priRpScpGriGrpVO, checkGRICalculationValidationVOs);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Rate 데이터에 GRI Calculation Validation 처리.<br>
	 * 
	 * @param PriRpScpGriGrpVO priRpScpGriGrpVO
	 * @param SignOnUserAccount account
	 * @return List<CheckGRICalculationValidationVO>
	 * @exception EventException
	 */
	public List<CheckGRICalculationValidationVO> checkGRICalculationValidationForAddOnTariff(PriRpScpGriGrpVO priRpScpGriGrpVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.checkGRICalculationValidationForAddOnTariff(priRpScpGriGrpVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * RFA Type이 Contract 일때, actual customer check<br>
	 * 
	 * @param PriRpScpRtActCustVO priRpScpRtActCustVO
	 * @return List<PriRpScpRtActCustVO>
	 * @exception EventException
	 */
	public List<PriRpScpRtActCustVO> checkActualCustomer(PriRpScpRtActCustVO priRpScpRtActCustVO) throws EventException {
		try {
			return dbDao.checkActualCustomer(priRpScpRtActCustVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Route 중에 term이 빠진 Location check<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<PriRpScpRtRoutPntVO>
	 * @exception EventException
	 */
	public List<PriRpScpRtRoutPntVO> checkRouteTermMissing(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.checkRouteTermMissing(priRpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * [Basic] Rate내의 모든항목을 Accept 처리한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllRateBasic(PriRpScpRtVO priRpScpRtVO, SignOnUserAccount account) throws EventException {
		try {
			if (priRpScpRtVO != null) {
				priRpScpRtVO.setPrcProgStsCd("A");
				priRpScpRtVO.setAcptUsrId("AUTO");
				priRpScpRtVO.setAcptOfcCd("AUTO");
				priRpScpRtVO.setAcptDt(com.hanjin.framework.component.util.DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd HH:mm:ss"));
				priRpScpRtVO.setUpdUsrId("AUTO");
				String ficRtTpCd  = "";
				dbDao.modifyAcceptAllRateCmdt(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateActCust(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateCnote(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateRoutPnt(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateRoutVia(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateRnote(priRpScpRtVO, ficRtTpCd);
				dbDao.modifyAcceptAllRateRt(priRpScpRtVO, ficRtTpCd);
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Master RFA의 Route Note Conversion 데이터를 Accept한다.<br>
	 * RFA 효율화를 위한 요청 (1차) (CHM-201640671) <br>
	 * 
	 * @param PriRfaNoteConvListVO[] priRfaNoteConvListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptRateCommodityRnoteConv(PriRfaNoteConvListVO[] priRfaNoteConvListVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRfaNoteConvListVO> updateVoList = new ArrayList<PriRfaNoteConvListVO>();
			for (int i = 0; priRfaNoteConvListVOs != null && i < priRfaNoteConvListVOs.length; i++) {
				if (priRfaNoteConvListVOs[i].getIbflag().equals("U")) {
					priRfaNoteConvListVOs[i].setPrcProgStsCd("A");
//					priRfaNoteConvListVOs[i].setAcptUsrId(account.getUsr_id());
//					priRfaNoteConvListVOs[i].setAcptOfcCd(account.getOfc_cd());
//					priRfaNoteConvListVOs[i].setAcptDt(com.hanjin.framework.component.util.DateTime.getFormatDate(new java.util.Date(), "yyyy-MM-dd HH:mm:ss"));
					
					priRfaNoteConvListVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priRfaNoteConvListVOs[i]);
				}
			}
			if (updateVoList.size() > 0) {
				dbDao.modifyMstNoteConv(updateVoList, "Y");
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}


	/**
	 * Master RFA의 Route Note Conversion 데이터를 Accept Cancel한다.<br>
	 * RFA 효율화를 위한 요청 (1차) (CHM-201640671) <br>
	 * 
	 * @param PriRfaNoteConvListVO[] priRfaNoteConvListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelRateCommodityRnoteConv(PriRfaNoteConvListVO[] priRfaNoteConvListVOs, SignOnUserAccount account) throws EventException {
		try {
			List<PriRfaNoteConvListVO> updateVoList = new ArrayList<PriRfaNoteConvListVO>();
			for (int i = 0; priRfaNoteConvListVOs != null && i < priRfaNoteConvListVOs.length; i++) {
				if (priRfaNoteConvListVOs[i].getIbflag().equals("U")) {
//					priRfaNoteConvListVOs[i].setAcptUsrId(null);
//					priRfaNoteConvListVOs[i].setAcptOfcCd(null);
//					priRfaNoteConvListVOs[i].setAcptDt(null);
					
					priRfaNoteConvListVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priRfaNoteConvListVOs[i]);
				}
			}

			if (updateVoList.size() > 0) {
				dbDao.modifyMstNoteConv(updateVoList, "Y");
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
		
	}
	
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
	public List<RsltRoutHdrSmryListVO> searchMstRouteSummaryList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO, String mstRfaNo, String isExists) throws EventException {
		try {
			return dbDao.searchMstRouteSummaryList(priRpScpRtCmdtRoutVO, mstRfaNo, isExists);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Basic Amend Request를 처리합니다. <br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param RsltRoutHdrSmryListVO amdBasicVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposalBasic(PriRpMnVO priRpMnVO, RsltRoutHdrSmryListVO amdBasicVo, SignOnUserAccount account) throws EventException {
		try {

			List<PriRpMnVO> insertVoList = new ArrayList<PriRpMnVO>();
			List<RsltRoutHdrSmryListVO> copyMasterVoList = new ArrayList<RsltRoutHdrSmryListVO>();

			priRpMnVO.setCreUsrId(account.getUsr_id());
			priRpMnVO.setUpdUsrId(account.getUsr_id());
			insertVoList.add(priRpMnVO);
			
			amdBasicVo.setCreUsrId(account.getUsr_id());
			amdBasicVo.setUpdUsrId(account.getUsr_id());
			copyMasterVoList.add(amdBasicVo);

			dbDao.addRateCommodityHeaderAmend(insertVoList);
			dbDao.addRateActualCustomerAmend(insertVoList);
			dbDao.addRateCnoteAmend(insertVoList);
			dbDao.addRateCommodityAmend(insertVoList);
			dbDao.addRateCommodityRouteAmend(insertVoList);
			
			// Master의 정보를 copy and insert
			dbDao.addRateAmendBasic(copyMasterVoList);	
			dbDao.addRateCommodityRnoteAmendBasic(copyMasterVoList);
			dbDao.addRateRoutePointAmendBasic(copyMasterVoList);
			dbDao.addRateRouteViaAmendBasic(copyMasterVoList);
			
			
			dbDao.addRateSurchargeAmend(insertVoList);
			dbDao.addRateSurchargeRouteAmend(insertVoList);
			dbDao.addRateSurchargeUSCRouteAmend(insertVoList);
			dbDao.addRateCargoSpecAmend(insertVoList);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}
	
	///////////////////
	   /**
     * Basic RFA에서 amend를 통해 추가적으로 Master RFA Proposal Rate 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param RsltRoutHdrSmryListVO[] rsltRoutHdrSmryListVOs
     * @param SignOnUserAccount account
     * @param String rfaTypeCode
     * @exception EventException
     */
    public void copyAmendProposalScopeRateMst(RsltRfaPropCopyVO vo, RsltRoutHdrSmryListVO[] rsltRoutHdrSmryListVOs, SignOnUserAccount account) throws EventException {
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            
             
            // Batch 일괄 수행을 위해 list로 변경 
//            for(int i = 0; i < rsltRoutHdrSmryListVOs.length; i++){
//                // 선택한 Route 의 route seq
//                routSeqList.add(rsltRoutHdrSmryListVOs[i].getRoutSeq());
//            }
            

            
            //
            //TODO : 1. Basic RFA의 Route SEQ를 조회 한다.
            //       2. Master RFA의 값을 Basic RFA로 copy한다. 이때 route Seq와 n1st_amdt_seq 는 새로운 amdt_seq값으로 해야 한다.
            PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO = new PriRpScpRtCmdtRoutVO();
            priRpScpRtCmdtRoutVO.setPropNo(vo.getNewPropNo() );
            priRpScpRtCmdtRoutVO.setAmdtSeq(vo.getNewAmdtSeq() );
            priRpScpRtCmdtRoutVO.setSvcScpCd(vo.getSvcScpCd());
            String routSeq = dbDao.searchMaxCmdtRoutSeq( priRpScpRtCmdtRoutVO);
            int iRoutSeq = Integer.parseInt(routSeq);
            iRoutSeq++;
            if( rsltRoutHdrSmryListVOs != null && rsltRoutHdrSmryListVOs.length != 0){
                for(int i = 0; i < rsltRoutHdrSmryListVOs.length; i++){
                    RsltRoutHdrSmryListVO smryVo = rsltRoutHdrSmryListVOs[i];
                    smryVo.setCreUsrId(account.getUsr_id());
                    smryVo.setUpdUsrId(account.getUsr_id());
                    smryVo.setOfcCd(account.getOfc_cd());
                    smryVo.setNewPropNo(vo.getNewPropNo());
                    smryVo.setNewAmdtSeq(vo.getNewAmdtSeq());
                    iRoutSeq = iRoutSeq+i;
                    // PRI_RP_SCP_RT_CMDT_ROUT COPY
                    smryVo.setNewRoutSeq(String.valueOf(iRoutSeq));
                    dbDao.addAmendCopyProposalScopeRtCmdtRoutMst(smryVo);
                    // PRI_RP_SCP_RT_ROUT_PNT COPY
                    dbDao.addAmendCopyProposalScopeRtRoutPntMst(smryVo);
                    // PRI_RP_SCP_RT_ROUT_VIA COPY
                    dbDao.addAmendCopyProposalScopeRtRoutViaMst(smryVo);
                    // PRI_RP_SCP_RT COPY
                    dbDao.addAmendCopyProposalScopeRtMst(smryVo);
                    // PRI_RP_SCP_RT_CMDT_RNOTE COPY
                    dbDao.addAmendCopyProposalScopeRtCmdtRnoteMst(smryVo);
                    // PRI_RFA_NOTE_CONV
                    dbDao.addAmendCopyProposalRfaNoteConvMst(smryVo);

                    
                }
                
                // PRI_RP_SCP_RT_CMDT_RNOTE Display Seq Update
                PriRpScpRtCmdtRoutVO routVO = new PriRpScpRtCmdtRoutVO();
                routVO.setPropNo(vo.getNewPropNo());
                if( vo.getNewAmdtSeq() == null || vo.getNewAmdtSeq().length() == 0){
                    routVO.setAmdtSeq("0");
    
                }else{
                    routVO.setAmdtSeq(vo.getNewAmdtSeq());
                }
                routVO.setSvcScpCd(vo.getSvcScpCd());
    
                dbDao.modifyRouteNoteDispSeq(routVO, "0");
            }
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
        }
    }
}
