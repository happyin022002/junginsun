/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCRateProposalBCImpl.java
 *@FileTitle : Guideline MQC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.10.04
 *@LastModifier : 송호진
 *@LastVersion : 1.0
 * 2009.05.25 박성수
 * 1.0 Creation
 * 2010.10.04 송호진 CHM-201006291-01 - [긴급 요청사항] Session 정보 관련 getCre_usr_id - getUsr_id 로 교체
 * 2015.04.06 송호진 [CHM-201534007] Fixed index 개발 & Rate 표시 Grid 높이 조절
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.common.PRIUtil;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.PrsBatchVO;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.profitabilitysimulation.profitabilitysimulation.vo.InpPrsSurchargeDetailApplicableRouteVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.ScPropMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scrateproposal.integration.SCRateProposalDBDAO;
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
import com.hanjin.bizcommon.comm.Constants;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriPrsBatVO;
import com.hanjin.syscommon.common.table.PriSpCtrtPtyVO;
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
import com.hanjin.syscommon.common.util.ScheduleUtil;

/**
 * NIS2010-SCGuideline Business Logic Basic Command implementation<br>
 * - NIS2010-SCGuideline에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Sungsoo, Park
 * @see UI_PRI_0030EventResponse,SCRateProposalBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class SCRateProposalBCImpl extends BasicCommandSupport implements SCRateProposalBC {

    // Database Access Object
    private transient SCRateProposalDBDAO dbDao = null;

    /**
     * SCRateProposalBCImpl 객체 생성<br>
     * SCRateProposalDBDAO를 생성한다.<br>
     */
    public SCRateProposalBCImpl() {
        dbDao = new SCRateProposalDBDAO();
    }

    /**
     * Rate Type radio button스타일 처리를 위한 조회를 처리합니다.<br>
     * 
     * @param PriSpScpRtVO priSpScpRtVO
     * @return List<RsltRateTpVO>
     * @exception EventException
     */
    public List<RsltRateTpVO> searchRateType(PriSpScpRtVO priSpScpRtVO) throws EventException {
        try {
            return dbDao.searchRateType(priSpScpRtVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }
    
    /**
     * CUD트랜잭션 처리 후, 화면표시를 위한 스타일정보 조회<br>
     * 
     * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
     * @param PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO
     * @return RsltRtCmdtRoutListVO
     * @exception EventException
     */
    public RsltRtCmdtRoutListVO searchRateCmdtRoutStyle(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO) throws EventException {
        RsltRtCmdtRoutListVO rVo = new RsltRtCmdtRoutListVO();

        try {
            rVo.setRsltRtCmdtHdrListVOS(dbDao.searchRateCommodityHeaderStyleList(priSpScpRtCmdtHdrVO));
            rVo.setRsltRtRoutHdrListVOS(dbDao.searchRateRouteStyleList(priSpScpRtCmdtRoutVO));

            return rVo;
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Rate의 Commodity Group을 조회합니다.<br>
     * 
     * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
     * @return RsltRtCmdtListVO
     * @exception EventException
     */
    public RsltRtCmdtListVO searchRateCommodityList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws EventException {
        RsltRtCmdtListVO rVo = new RsltRtCmdtListVO();

        try {
            rVo.setRsltRtCmdtHdrListVOS(dbDao.searchRateCommodityHeaderList(priSpScpRtCmdtHdrVO));
            rVo.setRsltRtCmdtDtlListVOS(dbDao.searchRateCommodityDetailList(priSpScpRtCmdtHdrVO));
            rVo.setRsltActCustListVOS(dbDao.searchActualCustomerList(priSpScpRtCmdtHdrVO));
            rVo.setRsltRtCnoteListVOS(dbDao.searchRateCnoteList(priSpScpRtCmdtHdrVO));

            return rVo;
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }
    
    /**
     * Rate Inquiry - Commodity Group을 조회한다.<br>
     * 
     * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
     * @return RsltRtCmdtListVO
     * @exception EventException
     */
    public RsltRtCmdtListVO searchRateCommodityInquiryList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws EventException {
        RsltRtCmdtListVO rVo = new RsltRtCmdtListVO();

        try {
            rVo.setRsltRtCmdtHdrListVOS(dbDao.searchRateCommodityHeaderInquiryList(priSpScpRtCmdtHdrVO));
            rVo.setRsltRtCmdtDtlListVOS(dbDao.searchRateCommodityDetailInquiryList(priSpScpRtCmdtHdrVO));
            rVo.setRsltActCustListVOS(dbDao.searchActualCustomerInquiryList(priSpScpRtCmdtHdrVO));
            rVo.setRsltRtCnoteListVOS(dbDao.searchRateCnoteInquiryList(priSpScpRtCmdtHdrVO));

            return rVo;
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }
    
    /**
     * Rate History - Commodity Group을 조회한다.
     * 
     * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
     * @param String isConv
     * @return RsltRtCmdtListVO
     * @exception EventException
     */
    public RsltRtCmdtListVO searchRateCommodityHistoryList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, String isConv) throws EventException {
        RsltRtCmdtListVO rVo = new RsltRtCmdtListVO();

        try {
            rVo.setRsltRtCmdtHdrListVOS(dbDao.searchRateCommodityHeaderHistoryList(priSpScpRtCmdtHdrVO, isConv));
            rVo.setRsltRtCmdtDtlListVOS(dbDao.searchRateCommodityDetailList(priSpScpRtCmdtHdrVO));
            rVo.setRsltActCustListVOS(dbDao.searchActualCustomerList(priSpScpRtCmdtHdrVO));
            rVo.setRsltRtCnoteListVOS(dbDao.searchRateCnoteList(priSpScpRtCmdtHdrVO));

            return rVo;
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Rate의 Route 정보를 조회합니다.<br>
     * 
     * @param PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO
     * @return List<RsltRtRoutHdrListVO>
     * @exception EventException
     */
    public List<RsltRtRoutHdrListVO> searchRateRouteList(PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO) throws EventException {
        try {
            return dbDao.searchRateRouteList(priSpScpRtCmdtRoutVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }
    
    /**
     * Rate Inquiry - Route 리스트를 조회한다.<br>
     * 
     * @param PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO
     * @return List<RsltRtRoutHdrListVO>
     * @exception EventException
     */
    public List<RsltRtRoutHdrListVO> searchRateRouteInquiryList(PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO) throws EventException {
        try {
            return dbDao.searchRateRouteInquiryList(priSpScpRtCmdtRoutVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }
    
    /**
     * Rate History - Route 리스트를 조회한다.
     * 
     * @param PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO
     * @param String isConv
     * @return List<RsltRtRoutHdrListVO>
     * @exception EventException
     */
    public List<RsltRtRoutHdrListVO> searchRateRouteHistoryList(PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO, String isConv) throws EventException {
        try {
            return dbDao.searchRateRouteHistoryList(priSpScpRtCmdtRoutVO, isConv);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Rate의 Rate 관련정보를 조회합니다.<br>
     * 
     * @param PriSpScpRtVO priSpScpRtVO
     * @return RsltRtListVO
     * @exception EventException
     */
    public RsltRtListVO searchRateList(PriSpScpRtVO priSpScpRtVO) throws EventException {
        RsltRtListVO rVo = new RsltRtListVO();
        try {
            rVo.setRsltRtDtlListVOS(dbDao.searchRateDetailList(priSpScpRtVO));
            rVo.setRsltRtRoutOrgPntListVOS(dbDao.searchRateRouteOriginPointList(priSpScpRtVO));
            rVo.setRsltRtRoutOrgViaListVOS(dbDao.searchRateRouteOriginViaList(priSpScpRtVO));
            rVo.setRsltRtRoutDestViaListVOS(dbDao.searchRateRouteDestinationViaList(priSpScpRtVO));
            rVo.setRsltRtRoutDestPntListVOS(dbDao.searchRateRouteDestinationPointList(priSpScpRtVO));
            rVo.setRsltRtRoutDirCallListVOS(dbDao.searchRateRouteDirCallList(priSpScpRtVO));
            rVo.setRsltRtCmdtRnoteListVOS(dbDao.searchRateCommodityRnoteList(priSpScpRtVO));

            return rVo;
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }
    
    /**
     * Rate Inquiry - Rate 정보를 조회한다.<br>
     * 
     * @param PriSpScpRtVO priSpScpRtVO
     * @return RsltRtListVO
     * @exception EventException
     */
    public RsltRtListVO searchRateInquiryList(PriSpScpRtVO priSpScpRtVO) throws EventException {
        RsltRtListVO rVo = new RsltRtListVO();
        try {
            rVo.setRsltRtDtlListVOS(dbDao.searchRateDetailInquiryList(priSpScpRtVO));
            rVo.setRsltRtRoutOrgPntListVOS(dbDao.searchRateRouteOriginPointInquiryList(priSpScpRtVO));
            rVo.setRsltRtRoutOrgViaListVOS(dbDao.searchRateRouteOriginViaInquiryList(priSpScpRtVO));
            rVo.setRsltRtRoutDestViaListVOS(dbDao.searchRateRouteDestinationViaInquiryList(priSpScpRtVO));
            rVo.setRsltRtRoutDestPntListVOS(dbDao.searchRateRouteDestinationPointInquiryList(priSpScpRtVO));
            rVo.setRsltRtRoutDirCallListVOS(dbDao.searchRateRouteDirCallInquiryList(priSpScpRtVO));
            rVo.setRsltRtCmdtRnoteListVOS(dbDao.searchRateCommodityRnoteInquiryList(priSpScpRtVO));

            return rVo;
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Excel Download(Vertical)를 위한 조회를 실행한다.<br>
     * 
     * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
     * @return List<RsltRtListVerticalExcelVO>
     * @exception EventException
     */
    public List<RsltRtListVerticalExcelVO> searchRateListVerticalExcel(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws EventException {
        try {
            return dbDao.searchRateListVerticalExcel(priSpScpRtCmdtHdrVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }
    
    /**
     * Excel Download(Horizontal)를 위한 조회를 실행한다.<br>
     * 
     * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
     * @return List<RsltRtListHorizontalExcelVO>
     * @exception EventException
     */
    public List<RsltRtListHorizontalExcelVO> searchRateListHorizontalExcel(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws EventException {
        try {
            return dbDao.searchRateListHorizontalExcel(priSpScpRtCmdtHdrVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Accept All 화면의 리스트를 조회한다.<br>
     * 
     * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
     * @return List<RsltAllRtListVO>
     * @exception EventException
     */
    public List<RsltAllRtListVO> searchAllRateList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws EventException {
        try {
            return dbDao.searchAllRateList(priSpScpRtCmdtHdrVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * 조회 이벤트 처리<br>
     * SCRateProposal화면에 대한 조회 이벤트 처리<br>
     * 
     * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
     * @return String
     * @exception EventException
     */
    public String getMaxOldBulletDispSeq(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws EventException {
        try {
            return dbDao.searchMaxOldBulletDispSeq(priSpScpRtCmdtHdrVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Commodity Group 및 관련 정보의 멀티 트랜잭션을 처리한다.<br>
     * 
     * @param ScRtPropCmdtVO scRtPropCmdtVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageRateCommodity(ScRtPropCmdtVO scRtPropCmdtVO, SignOnUserAccount account) throws EventException {
        try {
            PriSpScpRtCmdtHdrVO[] vo = scRtPropCmdtVO.getPriSpScpRtCmdtHdrVOS();
            PriSpScpRtCmdtVO[] dtlvo = scRtPropCmdtVO.getPriSpScpRtCmdtVOS();
            PriSpScpRtActCustVO[] custvo = scRtPropCmdtVO.getPriSpScpRtActCustVOS();
            PriSpScpRtCnoteVO[] cnotevo = scRtPropCmdtVO.getPriSpScpRtCnoteVOS();

            List<PriSpScpRtCmdtHdrVO> insertVoList = new ArrayList<PriSpScpRtCmdtHdrVO>();
            List<PriSpScpRtCmdtHdrVO> updateVoList = new ArrayList<PriSpScpRtCmdtHdrVO>();
            List<PriSpScpRtCmdtHdrVO> deleteVoList = new ArrayList<PriSpScpRtCmdtHdrVO>();
            List<PriSpScpRtCmdtVO> insertDtlVoList = new ArrayList<PriSpScpRtCmdtVO>();
            List<PriSpScpRtCmdtVO> updateDtlVoList = new ArrayList<PriSpScpRtCmdtVO>();
            List<PriSpScpRtCmdtVO> deleteDtlVoList = new ArrayList<PriSpScpRtCmdtVO>();
            List<PriSpScpRtActCustVO> insertCustVoList = new ArrayList<PriSpScpRtActCustVO>();
            List<PriSpScpRtActCustVO> updateCustVoList = new ArrayList<PriSpScpRtActCustVO>();
            List<PriSpScpRtActCustVO> deleteCustVoList = new ArrayList<PriSpScpRtActCustVO>();
            List<PriSpScpRtCnoteVO> insertCnoteVoList = new ArrayList<PriSpScpRtCnoteVO>();
            List<PriSpScpRtCnoteVO> updateCnoteVoList = new ArrayList<PriSpScpRtCnoteVO>();
            List<PriSpScpRtCnoteVO> deleteCnoteVoList = new ArrayList<PriSpScpRtCnoteVO>();
            List<PriSpScpRtCmdtRoutVO> updateCmdtRoutVoList = new ArrayList<PriSpScpRtCmdtRoutVO>();

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
                        // Update 된 CMDT_HDR 의 FX_RT_FLG 를 CMDT_ROUT 에 적용함.
                    	PriSpScpRtCmdtRoutVO rtCmdtRoutVO = new PriSpScpRtCmdtRoutVO();
                    	
                    	rtCmdtRoutVO.setPropNo(vo[i].getPropNo());
                    	rtCmdtRoutVO.setAmdtSeq(vo[i].getAmdtSeq());
                    	rtCmdtRoutVO.setSvcScpCd(vo[i].getSvcScpCd());
                    	rtCmdtRoutVO.setGenSpclRtTpCd(vo[i].getGenSpclRtTpCd());
                    	rtCmdtRoutVO.setCmdtHdrSeq(vo[i].getCmdtHdrSeq());
                    	rtCmdtRoutVO.setUpdUsrId(vo[i].getUpdUsrId());
                    	rtCmdtRoutVO.setFxRtFlg(vo[i].getFxRtFlg());
                    	
                    	updateCmdtRoutVoList.add(rtCmdtRoutVO);
                        
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
            if (updateCmdtRoutVoList.size() > 0) {
            	dbDao.modifyRateCommodityRouteFxRtFlg(updateCmdtRoutVoList);
            }

            if (deleteCustVoList.size() > 0) {
                dbDao.removeRateActualCustomer(deleteCustVoList);
            }
            if (deleteCnoteVoList.size() > 0) {
                dbDao.removeRateCnote(deleteCnoteVoList);
            }
            if (deleteDtlVoList.size() > 0) {
                dbDao.removeRateCommodity(deleteDtlVoList);
            }
            if (deleteVoList.size() > 0) {
                dbDao.removeRateCommodityHeaderCascadeScg(deleteVoList);
                dbDao.removeRateCommodityHeaderCascadeScgRout(deleteVoList);
                dbDao.removeRateCommodityHeaderCascadeUsdRoutCs(deleteVoList);
                dbDao.removeRateCommodityHeaderCascadeRt(deleteVoList);
                dbDao.removeRateCommodityHeaderCascadeRnote(deleteVoList);
                dbDao.removeRateCommodityHeaderCascadeRoutDir(deleteVoList);
                dbDao.removeRateCommodityHeaderCascadeRoutVia(deleteVoList);
                dbDao.removeRateCommodityHeaderCascadeRoutPnt(deleteVoList);
                dbDao.removeRateCommodityHeaderCascadeCmdtRout(deleteVoList);
                dbDao.removeRateCommodityHeaderCascadeCnote(deleteVoList);
                dbDao.removeRateCommodityHeaderCascadeActCust(deleteVoList);
                dbDao.removeRateCommodityHeaderCascadeCmdt(deleteVoList);
                dbDao.removeRateCommodityHeader(deleteVoList);
                
                dbDao.removeRateCommodityHeaderDelAmendCmdt(deleteVoList);
                dbDao.removeRateCommodityHeaderDelAmendActCust(deleteVoList);
                dbDao.removeRateCommodityHeaderDelAmendCnote(deleteVoList);
                dbDao.removeRateCommodityHeaderDelAmendRoutPnt(deleteVoList);
                dbDao.removeRateCommodityHeaderDelAmendRoutVia(deleteVoList);
                dbDao.removeRateCommodityHeaderDelAmendRoutDir(deleteVoList);
                dbDao.removeRateCommodityHeaderDelAmendRnote(deleteVoList);
                dbDao.removeRateCommodityHeaderDelAmendRt(deleteVoList);
            }

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Route 및 Rate 데이터의 멀티 트랜잭션을 처리한다.<br>
     * 
     * @param ScRtPropRtVO scRtPropRtVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageRate(ScRtPropRtVO scRtPropRtVO, SignOnUserAccount account) throws EventException {
        try {
            PriSpScpRtCmdtRoutVO noteSeqVO = scRtPropRtVO.getPriSpScpRtCmdtRoutVO();
            PriSpScpRtCmdtRoutVO[] routvo = scRtPropRtVO.getPriSpScpRtCmdtRoutVOS();
            PriSpScpRtRoutPntVO[] orgpntvo = scRtPropRtVO.getPriSpScpRtRoutOrgPntVOS();
            PriSpScpRtRoutViaVO[] orgviavo = scRtPropRtVO.getPriSpScpRtRoutOrgViaVOS();
            PriSpScpRtRoutViaVO[] destviavo = scRtPropRtVO.getPriSpScpRtRoutDestViaVOS();
            PriSpScpRtRoutPntVO[] destpntvo = scRtPropRtVO.getPriSpScpRtRoutDestPntVOS();
            PriSpScpRtRoutDirVO[] dircallvo = scRtPropRtVO.getPriSpScpRtRoutDirVOS();
            PriSpScpRtCmdtRnoteVO[] rnotevo = scRtPropRtVO.getPriSpScpRtCmdtRnoteVOS();
            PriSpScpRtVO[] rtvo = scRtPropRtVO.getPriSpScpRtVOS();

            List<PriSpScpRtCmdtRoutVO> insertRoutList = new ArrayList<PriSpScpRtCmdtRoutVO>();
            List<PriSpScpRtCmdtRoutVO> updateRoutList = new ArrayList<PriSpScpRtCmdtRoutVO>();
            List<PriSpScpRtCmdtRoutVO> deleteRoutList = new ArrayList<PriSpScpRtCmdtRoutVO>();
            List<PriSpScpRtRoutPntVO> insertPntList = new ArrayList<PriSpScpRtRoutPntVO>();
            List<PriSpScpRtRoutPntVO> updatePntList = new ArrayList<PriSpScpRtRoutPntVO>();
            List<PriSpScpRtRoutPntVO> deletePntList = new ArrayList<PriSpScpRtRoutPntVO>();
            List<PriSpScpRtRoutViaVO> insertViaList = new ArrayList<PriSpScpRtRoutViaVO>();
            List<PriSpScpRtRoutViaVO> updateViaList = new ArrayList<PriSpScpRtRoutViaVO>();
            List<PriSpScpRtRoutViaVO> deleteViaList = new ArrayList<PriSpScpRtRoutViaVO>();
            List<PriSpScpRtRoutDirVO> insertDirList = new ArrayList<PriSpScpRtRoutDirVO>();
            List<PriSpScpRtRoutDirVO> updateDirList = new ArrayList<PriSpScpRtRoutDirVO>();
            List<PriSpScpRtRoutDirVO> deleteDirList = new ArrayList<PriSpScpRtRoutDirVO>();
            List<PriSpScpRtCmdtRnoteVO> insertRnoteList = new ArrayList<PriSpScpRtCmdtRnoteVO>();
            List<PriSpScpRtCmdtRnoteVO> updateRnoteList = new ArrayList<PriSpScpRtCmdtRnoteVO>();
            List<PriSpScpRtCmdtRnoteVO> deleteRnoteList = new ArrayList<PriSpScpRtCmdtRnoteVO>();
            List<PriSpScpRtVO> insertRtList = new ArrayList<PriSpScpRtVO>();
            List<PriSpScpRtVO> updateRtList = new ArrayList<PriSpScpRtVO>();
            List<PriSpScpRtVO> deleteRtList = new ArrayList<PriSpScpRtVO>();
            List<PriSpScpRtVO> amendCancelRtList = new ArrayList<PriSpScpRtVO>();

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
            for (int i = 0; dircallvo != null && i < dircallvo.length; i++) {
                if (dircallvo[i].getIbflag().equals("I")) {
                    dircallvo[i].setCreUsrId(account.getUsr_id());
                    dircallvo[i].setUpdUsrId(account.getUsr_id());
                    insertDirList.add(dircallvo[i]);
                } else if (dircallvo[i].getIbflag().equals("U")) {
                    dircallvo[i].setUpdUsrId(account.getUsr_id());
                    updateDirList.add(dircallvo[i]);
                } else if (dircallvo[i].getIbflag().equals("D")) {
                    deleteDirList.add(dircallvo[i]);
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
            if (insertDirList.size() > 0) {
                dbDao.addRateRouteDirectCall(insertDirList);
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
            if (updateDirList.size() > 0) {
                dbDao.modifyRateRouteDirectCall(updateDirList, "N");
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
                dbDao.removeRate(deleteRtList);
            }
            if (deleteRnoteList.size() > 0) {
                dbDao.removeRateCommodityRnote(deleteRnoteList);
            }
            if (deleteDirList.size() > 0) {
                dbDao.removeRateRouteDirectCall(deleteDirList);
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
                dbDao.removeRateCommodityRouteCascadeRt(deleteRoutList);
                dbDao.removeRateCommodityRouteCascadeRnote(deleteRoutList);
                dbDao.removeRateCommodityRouteCascadeRoutDir(deleteRoutList);
                dbDao.removeRateCommodityRouteCascadeRoutVia(deleteRoutList);
                dbDao.removeRateCommodityRouteCascadeRoutPnt(deleteRoutList);
                dbDao.removeRateCommodityRoute(deleteRoutList);
                
                dbDao.removeRateCommodityRouteDelAmendRoutPnt(deleteRoutList);
                dbDao.removeRateCommodityRouteDelAmendRoutVia(deleteRoutList);
                dbDao.removeRateCommodityRouteDelAmendRoutDir(deleteRoutList);
                dbDao.removeRateCommodityRouteDelAmendRnote(deleteRoutList);
                dbDao.removeRateCommodityRouteDelAmendRt(deleteRoutList);
            }

            dbDao.modifyRouteNoteDispSeq(noteSeqVO, "1");
            // CMDT_ROUT 의 UPDATE 가 있는 경우 현재 CMDT_ROUT.FX_RT_FLG 구성에 따라서
            // CMDT_HDR 의 FX_RT_FLG 를 UPDATE 한다. 2015.03.12 송호진 
            if (updateRoutList.size() > 0) {
                dbDao.modifyRateCommodityHeaderFxRtFlg(updateRoutList.get(0));
            }

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Actual Customer 데이터를 Accept합니다.<br>
     * 
     * @param PriSpScpRtActCustVO[] priSpScpRtActCustVOs
     * @param account SignOnUserAccount
     * @exception EventException
     */
    public void acceptActualCustomer(PriSpScpRtActCustVO[] priSpScpRtActCustVOs, SignOnUserAccount account) throws EventException {
        try {
            List<PriSpScpRtActCustVO> updateVoList = new ArrayList<PriSpScpRtActCustVO>();

            for (int i = 0; priSpScpRtActCustVOs != null && i < priSpScpRtActCustVOs.length; i++) {
                if (priSpScpRtActCustVOs[i].getIbflag().equals("U")) {
                    priSpScpRtActCustVOs[i].setPrcProgStsCd("A");
                    priSpScpRtActCustVOs[i].setAcptUsrId(account.getUsr_id());
                    priSpScpRtActCustVOs[i].setAcptOfcCd(account.getOfc_cd());
                    priSpScpRtActCustVOs[i].setAcptDt(com.hanjin.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
                            "yyyy-MM-dd HH:mm:ss"));

                    priSpScpRtActCustVOs[i].setUpdUsrId(account.getUsr_id());

                    updateVoList.add(priSpScpRtActCustVOs[i]);
                }
            }

            if (updateVoList.size() > 0) {
                dbDao.modifyRateActualCustomer(updateVoList, "Y");
            }

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Actual Customer 데이터를 Accept Cancel합니다.<br>
     * 
     * @param PriSpScpRtActCustVO[] priSpScpRtActCustVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void cancelActualCustomer(PriSpScpRtActCustVO[] priSpScpRtActCustVOs, SignOnUserAccount account) throws EventException {
        try {
            List<PriSpScpRtActCustVO> updateVoList = new ArrayList<PriSpScpRtActCustVO>();

            for (int i = 0; priSpScpRtActCustVOs != null && i < priSpScpRtActCustVOs.length; i++) {
                if (priSpScpRtActCustVOs[i].getIbflag().equals("U")) {
                    // priSpScpRtActCustVOs[i].setPrcProgStsCd("I");
                    priSpScpRtActCustVOs[i].setAcptUsrId(null);
                    priSpScpRtActCustVOs[i].setAcptOfcCd(null);
                    priSpScpRtActCustVOs[i].setAcptDt(null);

                    priSpScpRtActCustVOs[i].setUpdUsrId(account.getUsr_id());

                    updateVoList.add(priSpScpRtActCustVOs[i]);
                }
            }

            if (updateVoList.size() > 0) {
                dbDao.modifyRateActualCustomer(updateVoList, "Y");
            }

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Rate 데이터를 Accept한다.<br>
     * 
     * @param PriSpScpRtVO[] priSpScpRtVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void acceptRate(PriSpScpRtVO[] priSpScpRtVOs, SignOnUserAccount account) throws EventException {
        try {
            List<PriSpScpRtVO> updateVoList = new ArrayList<PriSpScpRtVO>();

            for (int i = 0; priSpScpRtVOs != null && i < priSpScpRtVOs.length; i++) {
                if (priSpScpRtVOs[i].getIbflag().equals("U")) {
                    priSpScpRtVOs[i].setPrcProgStsCd("A");
                    priSpScpRtVOs[i].setAcptUsrId(account.getUsr_id());
                    priSpScpRtVOs[i].setAcptOfcCd(account.getOfc_cd());
                    priSpScpRtVOs[i].setAcptDt(com.hanjin.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
                            "yyyy-MM-dd HH:mm:ss"));

                    priSpScpRtVOs[i].setUpdUsrId(account.getUsr_id());

                    updateVoList.add(priSpScpRtVOs[i]);
                }
            }

            if (updateVoList.size() > 0) {
                dbDao.modifyRate(updateVoList, "Y");
            }

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Rate 데이터를 Accept Cancel한다.<br>
     * 
     * @param PriSpScpRtVO[] priSpScpRtVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void cancelRate(PriSpScpRtVO[] priSpScpRtVOs, SignOnUserAccount account) throws EventException {
        try {
            List<PriSpScpRtVO> updateVoList = new ArrayList<PriSpScpRtVO>();

            for (int i = 0; priSpScpRtVOs != null && i < priSpScpRtVOs.length; i++) {
                if (priSpScpRtVOs[i].getIbflag().equals("U")) {
                    // priSpScpRtVOs[i].setPrcProgStsCd("I");
                    priSpScpRtVOs[i].setAcptUsrId(null);
                    priSpScpRtVOs[i].setAcptOfcCd(null);
                    priSpScpRtVOs[i].setAcptDt(null);

                    priSpScpRtVOs[i].setUpdUsrId(account.getUsr_id());

                    updateVoList.add(priSpScpRtVOs[i]);
                }
            }

            if (updateVoList.size() > 0) {
                dbDao.modifyRate(updateVoList, "Y");
            }

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Commodity Note 데이터를 Accept Cancel한다.<br>
     * 
     * @param PriSpScpRtCnoteVO[] priSpScpRtCnoteVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void acceptRateCnote(PriSpScpRtCnoteVO[] priSpScpRtCnoteVOs, SignOnUserAccount account) throws EventException {
        try {
            List<PriSpScpRtCnoteVO> updateVoList = new ArrayList<PriSpScpRtCnoteVO>();

            for (int i = 0; priSpScpRtCnoteVOs != null && i < priSpScpRtCnoteVOs.length; i++) {
                if (priSpScpRtCnoteVOs[i].getIbflag().equals("U")) {
                    priSpScpRtCnoteVOs[i].setPrcProgStsCd("A");
                    priSpScpRtCnoteVOs[i].setAcptUsrId(account.getUsr_id());
                    priSpScpRtCnoteVOs[i].setAcptOfcCd(account.getOfc_cd());
                    priSpScpRtCnoteVOs[i].setAcptDt(com.hanjin.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
                            "yyyy-MM-dd HH:mm:ss"));

                    priSpScpRtCnoteVOs[i].setUpdUsrId(account.getUsr_id());

                    updateVoList.add(priSpScpRtCnoteVOs[i]);
                }
            }

            if (updateVoList.size() > 0) {
                dbDao.modifyRateCnote(updateVoList, "Y");
            }

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Commodity Note 데이터를 Accept Cancel한다.<br>
     * 
     * @param PriSpScpRtCnoteVO[] priSpScpRtCnoteVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void cancelRateCnote(PriSpScpRtCnoteVO[] priSpScpRtCnoteVOs, SignOnUserAccount account) throws EventException {
        try {
            List<PriSpScpRtCnoteVO> updateVoList = new ArrayList<PriSpScpRtCnoteVO>();

            for (int i = 0; priSpScpRtCnoteVOs != null && i < priSpScpRtCnoteVOs.length; i++) {
                if (priSpScpRtCnoteVOs[i].getIbflag().equals("U")) {
                    // priSpScpRtCnoteVOs[i].setPrcProgStsCd("I");
                    priSpScpRtCnoteVOs[i].setAcptUsrId(null);
                    priSpScpRtCnoteVOs[i].setAcptOfcCd(null);
                    priSpScpRtCnoteVOs[i].setAcptDt(null);

                    priSpScpRtCnoteVOs[i].setUpdUsrId(account.getUsr_id());

                    updateVoList.add(priSpScpRtCnoteVOs[i]);
                }
            }

            if (updateVoList.size() > 0) {
                dbDao.modifyRateCnote(updateVoList, "Y");
            }

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Commodity 데이터를 Accept한다.<br>
     * 
     * @param PriSpScpRtCmdtVO[] priSpScpRtCmdtVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void acceptRateCommodityDetail(PriSpScpRtCmdtVO[] priSpScpRtCmdtVOs, SignOnUserAccount account) throws EventException {
        try {
            List<PriSpScpRtCmdtVO> updateVoList = new ArrayList<PriSpScpRtCmdtVO>();

            for (int i = 0; priSpScpRtCmdtVOs != null && i < priSpScpRtCmdtVOs.length; i++) {
                if (priSpScpRtCmdtVOs[i].getIbflag().equals("U")) {
                    priSpScpRtCmdtVOs[i].setPrcProgStsCd("A");
                    priSpScpRtCmdtVOs[i].setAcptUsrId(account.getUsr_id());
                    priSpScpRtCmdtVOs[i].setAcptOfcCd(account.getOfc_cd());
                    priSpScpRtCmdtVOs[i].setAcptDt(com.hanjin.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
                            "yyyy-MM-dd HH:mm:ss"));

                    priSpScpRtCmdtVOs[i].setUpdUsrId(account.getUsr_id());

                    updateVoList.add(priSpScpRtCmdtVOs[i]);
                }
            }

            if (updateVoList.size() > 0) {
                dbDao.modifyRateCommodity(updateVoList, "Y");
            }

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Commodity 데이터를 Accept Cancel한다.<br>
     * 
     * @param PriSpScpRtCmdtVO[] priSpScpRtCmdtVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void cancelRateCommodityDetail(PriSpScpRtCmdtVO[] priSpScpRtCmdtVOs, SignOnUserAccount account) throws EventException {
        try {
            List<PriSpScpRtCmdtVO> updateVoList = new ArrayList<PriSpScpRtCmdtVO>();

            for (int i = 0; priSpScpRtCmdtVOs != null && i < priSpScpRtCmdtVOs.length; i++) {
                if (priSpScpRtCmdtVOs[i].getIbflag().equals("U")) {
                    // priSpScpRtCmdtVOs[i].setPrcProgStsCd("I");
                    priSpScpRtCmdtVOs[i].setAcptUsrId(null);
                    priSpScpRtCmdtVOs[i].setAcptOfcCd(null);
                    priSpScpRtCmdtVOs[i].setAcptDt(null);

                    priSpScpRtCmdtVOs[i].setUpdUsrId(account.getUsr_id());

                    updateVoList.add(priSpScpRtCmdtVOs[i]);
                }
            }

            if (updateVoList.size() > 0) {
                dbDao.modifyRateCommodity(updateVoList, "Y");
            }

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Route Note 데이터를 Accept한다.<br>
     * 
     * @param PriSpScpRtCmdtRnoteVO[] priSpScpRtCmdtRnoteVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void acceptRateCommodityRnote(PriSpScpRtCmdtRnoteVO[] priSpScpRtCmdtRnoteVOs, SignOnUserAccount account) throws EventException {
        try {
            List<PriSpScpRtCmdtRnoteVO> updateVoList = new ArrayList<PriSpScpRtCmdtRnoteVO>();

            for (int i = 0; priSpScpRtCmdtRnoteVOs != null && i < priSpScpRtCmdtRnoteVOs.length; i++) {
                if (priSpScpRtCmdtRnoteVOs[i].getIbflag().equals("U")) {
                    priSpScpRtCmdtRnoteVOs[i].setPrcProgStsCd("A");
                    priSpScpRtCmdtRnoteVOs[i].setAcptUsrId(account.getUsr_id());
                    priSpScpRtCmdtRnoteVOs[i].setAcptOfcCd(account.getOfc_cd());
                    priSpScpRtCmdtRnoteVOs[i].setAcptDt(com.hanjin.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
                            "yyyy-MM-dd HH:mm:ss"));

                    priSpScpRtCmdtRnoteVOs[i].setUpdUsrId(account.getUsr_id());

                    updateVoList.add(priSpScpRtCmdtRnoteVOs[i]);
                }
            }

            if (updateVoList.size() > 0) {
                dbDao.modifyRateCommodityRnote(updateVoList, "Y");
            }

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Route Note 데이터를 Accept Cancel한다.<br>
     * 
     * @param PriSpScpRtCmdtRnoteVO[] priSpScpRtCmdtRnoteVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void cancelRateCommodityRnote(PriSpScpRtCmdtRnoteVO[] priSpScpRtCmdtRnoteVOs, SignOnUserAccount account) throws EventException {
        try {
            List<PriSpScpRtCmdtRnoteVO> updateVoList = new ArrayList<PriSpScpRtCmdtRnoteVO>();

            for (int i = 0; priSpScpRtCmdtRnoteVOs != null && i < priSpScpRtCmdtRnoteVOs.length; i++) {
                if (priSpScpRtCmdtRnoteVOs[i].getIbflag().equals("U")) {
                    // priSpScpRtCmdtRnoteVOs[i].setPrcProgStsCd("I");
                    priSpScpRtCmdtRnoteVOs[i].setAcptUsrId(null);
                    priSpScpRtCmdtRnoteVOs[i].setAcptOfcCd(null);
                    priSpScpRtCmdtRnoteVOs[i].setAcptDt(null);

                    priSpScpRtCmdtRnoteVOs[i].setUpdUsrId(account.getUsr_id());

                    updateVoList.add(priSpScpRtCmdtRnoteVOs[i]);
                }
            }

            if (updateVoList.size() > 0) {
                dbDao.modifyRateCommodityRnote(updateVoList, "Y");
            }

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Direct Call 데이터를 Accept한다.<br>
     * 
     * @param PriSpScpRtRoutDirVO[] priSpScpRtRoutDirVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void acceptRateRouteDirCallDetail(PriSpScpRtRoutDirVO[] priSpScpRtRoutDirVOs, SignOnUserAccount account) throws EventException {
        try {
            List<PriSpScpRtRoutDirVO> updateVoList = new ArrayList<PriSpScpRtRoutDirVO>();

            for (int i = 0; priSpScpRtRoutDirVOs != null && i < priSpScpRtRoutDirVOs.length; i++) {
                if (priSpScpRtRoutDirVOs[i].getIbflag().equals("U")) {
                    priSpScpRtRoutDirVOs[i].setPrcProgStsCd("A");
                    priSpScpRtRoutDirVOs[i].setAcptUsrId(account.getUsr_id());
                    priSpScpRtRoutDirVOs[i].setAcptOfcCd(account.getOfc_cd());
                    priSpScpRtRoutDirVOs[i].setAcptDt(com.hanjin.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
                            "yyyy-MM-dd HH:mm:ss"));

                    priSpScpRtRoutDirVOs[i].setUpdUsrId(account.getUsr_id());

                    updateVoList.add(priSpScpRtRoutDirVOs[i]);
                }
            }

            if (updateVoList.size() > 0) {
                dbDao.modifyRateRouteDirectCall(updateVoList, "Y");
            }

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Direct Call 데이터를 Accept Cancel한다.<br>
     * 
     * @param PriSpScpRtRoutDirVO[] priSpScpRtRoutDirVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void cancelRateRouteDirCallDetail(PriSpScpRtRoutDirVO[] priSpScpRtRoutDirVOs, SignOnUserAccount account) throws EventException {
        try {
            List<PriSpScpRtRoutDirVO> updateVoList = new ArrayList<PriSpScpRtRoutDirVO>();

            for (int i = 0; priSpScpRtRoutDirVOs != null && i < priSpScpRtRoutDirVOs.length; i++) {
                if (priSpScpRtRoutDirVOs[i].getIbflag().equals("U")) {
                    // priSpScpRtRoutDirVOs[i].setPrcProgStsCd("I");
                    priSpScpRtRoutDirVOs[i].setAcptUsrId(null);
                    priSpScpRtRoutDirVOs[i].setAcptOfcCd(null);
                    priSpScpRtRoutDirVOs[i].setAcptDt(null);

                    priSpScpRtRoutDirVOs[i].setUpdUsrId(account.getUsr_id());

                    updateVoList.add(priSpScpRtRoutDirVOs[i]);
                }
            }

            if (updateVoList.size() > 0) {
                dbDao.modifyRateRouteDirectCall(updateVoList, "Y");
            }

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Route Point 데이터를 Accept한다.<br>
     * 
     * @param PriSpScpRtRoutPntVO[] priSpScpRtRoutPntVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void acceptRateRoutePointDetail(PriSpScpRtRoutPntVO[] priSpScpRtRoutPntVOs, SignOnUserAccount account) throws EventException {
        try {
            List<PriSpScpRtRoutPntVO> updateVoList = new ArrayList<PriSpScpRtRoutPntVO>();

            for (int i = 0; priSpScpRtRoutPntVOs != null && i < priSpScpRtRoutPntVOs.length; i++) {
                if (priSpScpRtRoutPntVOs[i].getIbflag().equals("U")) {
                    priSpScpRtRoutPntVOs[i].setPrcProgStsCd("A");
                    priSpScpRtRoutPntVOs[i].setAcptUsrId(account.getUsr_id());
                    priSpScpRtRoutPntVOs[i].setAcptOfcCd(account.getOfc_cd());
                    priSpScpRtRoutPntVOs[i].setAcptDt(com.hanjin.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
                            "yyyy-MM-dd HH:mm:ss"));

                    priSpScpRtRoutPntVOs[i].setUpdUsrId(account.getUsr_id());

                    updateVoList.add(priSpScpRtRoutPntVOs[i]);
                }
            }

            if (updateVoList.size() > 0) {
                dbDao.modifyRateRoutePoint(updateVoList, "Y");
            }

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Route Point 데이터를 Accept Cancel한다.<br>
     * 
     * @param PriSpScpRtRoutPntVO[] priSpScpRtRoutPntVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void cancelRateRoutePointDetail(PriSpScpRtRoutPntVO[] priSpScpRtRoutPntVOs, SignOnUserAccount account) throws EventException {
        try {
            List<PriSpScpRtRoutPntVO> updateVoList = new ArrayList<PriSpScpRtRoutPntVO>();

            for (int i = 0; priSpScpRtRoutPntVOs != null && i < priSpScpRtRoutPntVOs.length; i++) {
                if (priSpScpRtRoutPntVOs[i].getIbflag().equals("U")) {
                    // priSpScpRtRoutPntVOs[i].setPrcProgStsCd("I");
                    priSpScpRtRoutPntVOs[i].setAcptUsrId(null);
                    priSpScpRtRoutPntVOs[i].setAcptOfcCd(null);
                    priSpScpRtRoutPntVOs[i].setAcptDt(null);

                    priSpScpRtRoutPntVOs[i].setUpdUsrId(account.getUsr_id());

                    updateVoList.add(priSpScpRtRoutPntVOs[i]);
                }
            }

            if (updateVoList.size() > 0) {
                dbDao.modifyRateRoutePoint(updateVoList, "Y");
            }

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * 멀티 이벤트 처리<br>
     * In화면에 대한 멀티 이벤트 처리<br>
     * 
     * @param PriSpScpRtRoutViaVO[] priSpScpRtRoutViaVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void acceptRateRouteViaDetail(PriSpScpRtRoutViaVO[] priSpScpRtRoutViaVOs, SignOnUserAccount account) throws EventException {
        try {
            List<PriSpScpRtRoutViaVO> updateVoList = new ArrayList<PriSpScpRtRoutViaVO>();

            for (int i = 0; priSpScpRtRoutViaVOs != null && i < priSpScpRtRoutViaVOs.length; i++) {
                if (priSpScpRtRoutViaVOs[i].getIbflag().equals("U")) {
                    priSpScpRtRoutViaVOs[i].setPrcProgStsCd("A");
                    priSpScpRtRoutViaVOs[i].setAcptUsrId(account.getUsr_id());
                    priSpScpRtRoutViaVOs[i].setAcptOfcCd(account.getOfc_cd());
                    priSpScpRtRoutViaVOs[i].setAcptDt(com.hanjin.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
                            "yyyy-MM-dd HH:mm:ss"));

                    priSpScpRtRoutViaVOs[i].setUpdUsrId(account.getUsr_id());

                    updateVoList.add(priSpScpRtRoutViaVOs[i]);
                }
            }

            if (updateVoList.size() > 0) {
                dbDao.modifyRateRouteVia(updateVoList, "Y");
            }

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * 멀티 이벤트 처리<br>
     * In화면에 대한 멀티 이벤트 처리<br>
     * 
     * @param PriSpScpRtRoutViaVO[] priSpScpRtRoutViaVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void cancelRateRouteViaDetail(PriSpScpRtRoutViaVO[] priSpScpRtRoutViaVOs, SignOnUserAccount account) throws EventException {
        try {
            List<PriSpScpRtRoutViaVO> updateVoList = new ArrayList<PriSpScpRtRoutViaVO>();

            for (int i = 0; priSpScpRtRoutViaVOs != null && i < priSpScpRtRoutViaVOs.length; i++) {
                if (priSpScpRtRoutViaVOs[i].getIbflag().equals("U")) {
                    // priSpScpRtRoutViaVOs[i].setPrcProgStsCd("I");
                    priSpScpRtRoutViaVOs[i].setAcptUsrId(null);
                    priSpScpRtRoutViaVOs[i].setAcptOfcCd(null);
                    priSpScpRtRoutViaVOs[i].setAcptDt(null);

                    priSpScpRtRoutViaVOs[i].setUpdUsrId(account.getUsr_id());

                    updateVoList.add(priSpScpRtRoutViaVOs[i]);
                }
            }

            if (updateVoList.size() > 0) {
                dbDao.modifyRateRouteVia(updateVoList, "Y");
            }

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Rate의 모든 항목을 Accept한다.<br>
     * 
     * @param PriSpScpRtVO priSpScpRtVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void acceptAllRate(PriSpScpRtVO priSpScpRtVO, SignOnUserAccount account) throws EventException {
        try {
            if (priSpScpRtVO != null) {
                priSpScpRtVO.setPrcProgStsCd("A");
                priSpScpRtVO.setAcptUsrId(account.getUsr_id());
                priSpScpRtVO.setAcptOfcCd(account.getOfc_cd());
                priSpScpRtVO.setAcptDt(com.hanjin.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
                        "yyyy-MM-dd HH:mm:ss"));
                priSpScpRtVO.setUpdUsrId(account.getUsr_id());

                dbDao.modifyAcceptAllRateCmdt(priSpScpRtVO);
                dbDao.modifyAcceptAllRateActCust(priSpScpRtVO);
                dbDao.modifyAcceptAllRateCnote(priSpScpRtVO);
                dbDao.modifyAcceptAllRateRoutPnt(priSpScpRtVO);
                dbDao.modifyAcceptAllRateRoutVia(priSpScpRtVO);
                dbDao.modifyAcceptAllRateRoutDir(priSpScpRtVO);
                dbDao.modifyAcceptAllRateRnote(priSpScpRtVO);
                dbDao.modifyAcceptAllRateRt(priSpScpRtVO);
            }

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Rate의 모든 항목을 Accept Cancel한다.<br>
     * 
     * @param PriSpScpRtVO priSpScpRtVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void cancelAllRate(PriSpScpRtVO priSpScpRtVO, SignOnUserAccount account) throws EventException {
        try {
            if (priSpScpRtVO != null) {
                priSpScpRtVO.setPrcProgStsCd("I");
                priSpScpRtVO.setAcptUsrId(null);
                priSpScpRtVO.setAcptOfcCd(null);
                priSpScpRtVO.setAcptDt(null);
                priSpScpRtVO.setUpdUsrId(account.getUsr_id());

                dbDao.modifyAcceptAllRateCmdt(priSpScpRtVO);
                dbDao.modifyAcceptAllRateActCust(priSpScpRtVO);
                dbDao.modifyAcceptAllRateCnote(priSpScpRtVO);
                dbDao.modifyAcceptAllRateRoutPnt(priSpScpRtVO);
                dbDao.modifyAcceptAllRateRoutVia(priSpScpRtVO);
                dbDao.modifyAcceptAllRateRoutDir(priSpScpRtVO);
                dbDao.modifyAcceptAllRateRnote(priSpScpRtVO);
                dbDao.modifyAcceptAllRateRt(priSpScpRtVO);
            }

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Guideline의 데이터를 복사해온다.<br>
     * 
     * @param ScGlineCopyVO scGlineCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyGuidelineRate(ScGlineCopyVO scGlineCopyVO, SignOnUserAccount account) throws EventException {
        try {
            if (scGlineCopyVO != null) {
                scGlineCopyVO.setCreUsrId(account.getUsr_id());
                scGlineCopyVO.setUpdUsrId(account.getUsr_id());

                dbDao.addRateCommodityHeaderGlineCopy(scGlineCopyVO);
                dbDao.addRateCommodityGlineCopy(scGlineCopyVO);
                dbDao.addRateCommodityRouteGlineCopy(scGlineCopyVO);
                dbDao.addRateRoutePointGlineCopy(scGlineCopyVO);
                dbDao.addRateRouteViaGlineCopy(scGlineCopyVO);
                dbDao.addRateRouteDirectCallGlineCopy(scGlineCopyVO);
                dbDao.addRateCommodityRnoteGlineCopy(scGlineCopyVO);
                int rtCnt = dbDao.addRateGlineCopy(scGlineCopyVO);
                
                if (rtCnt > 0) {
                    PriSpScpRtCmdtRoutVO routVO = new PriSpScpRtCmdtRoutVO();
                    routVO.setPropNo(scGlineCopyVO.getPropNo());
                    routVO.setAmdtSeq(scGlineCopyVO.getAmdtSeq());
                    routVO.setSvcScpCd(scGlineCopyVO.getSvcScpCd());

                    dbDao.modifyRouteNoteDispSeq(routVO, "0");
                }
            }
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Guideline Copy전 Group Location, Group Commodity가 존재하는지 확인한다.<br>
     * 
     * @param ScGlineCopyVO scGlineCopyVO
     * @return RsltCdListVO
     * @exception EventException
     */
    public RsltCdListVO checkGlineCopyGroupCodeExist(ScGlineCopyVO scGlineCopyVO) throws EventException {
        try {
            return dbDao.searchGlineCopyGroupCodeExist(scGlineCopyVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Amend Request를 처리합니다.<br>
     * 
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void amendProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException {
        try {

            List<PriSpMnVO> insertVoList = new ArrayList<PriSpMnVO>();

            priSpMnVO.setCreUsrId(account.getUsr_id());
            priSpMnVO.setUpdUsrId(account.getUsr_id());
            insertVoList.add(priSpMnVO);
            dbDao.addRateCommodityHeaderAmend(insertVoList);
            dbDao.addRateCommodityRouteAmend(insertVoList);
            dbDao.addRateAmend(insertVoList);
            
            dbDao.addRateActualCustomerAmend(insertVoList);
            dbDao.addRateCnoteAmend(insertVoList);
            dbDao.addRateCommodityAmend(insertVoList);
            
            dbDao.addRateRouteDirectAmend(insertVoList);
            dbDao.addRateCommodityRnoteAmend(insertVoList);
            dbDao.addRateRoutePointAmend(insertVoList);
            dbDao.addRateRouteViaAmend(insertVoList);
            
            dbDao.addRateSurchargeAmend(insertVoList);
            dbDao.addRateSurchargeRouteAmend(insertVoList);
            dbDao.addRateSurchargeUSCRouteAmend(insertVoList);

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * S/C Proposal Rate 정보를 Copy 합니다.<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeRate(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException {
        try {
            String prcPropCreTpCd = vo.getPrcPropCreTpCd();
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_SP_SCP_RT_CMDT_HDR COPY
            dbDao.addCopyProposalScopeRtCmdtHdr(vo);
            // PRI_SP_SCP_RT_ACT_CUST COPY
            dbDao.addCopyProposalScopeRtActCust(vo);
            // PRI_SP_SCP_RT_CMDT COPY
            dbDao.addCopyProposalScopeRtCmdt(vo);
            // 이행/Legacy Interface 인 경우 Note 는 Copy 하지 않음
            if (!JSPUtil.getNull(prcPropCreTpCd).equals("I")) {
                // PRI_SP_SCP_RT_CNOTE COPY
                dbDao.addCopyProposalScopeRtCnote(vo);
            }
            // PRI_SP_SCP_RT_CMDT_ROUT COPY
            dbDao.addCopyProposalScopeRtCmdtRout(vo);
            // PRI_SP_SCP_RT_ROUT_PNT COPY
            dbDao.addCopyProposalScopeRtRoutPnt(vo);
            // PRI_SP_SCP_RT_ROUT_DIR COPY
            dbDao.addCopyProposalScopeRtRoutDir(vo);
            // PRI_SP_SCP_RT_ROUT_VIA COPY
            dbDao.addCopyProposalScopeRtRoutVia(vo);
            // PRI_SP_SCP_RT COPY
            dbDao.addCopyProposalScopeRt(vo);
            // 이행/Legacy Interface 인 경우 Note 는 Copy 하지 않음
            if (!JSPUtil.getNull(prcPropCreTpCd).equals("I")) {
                // PRI_SP_SCP_RT_CMDT_RNOTE COPY
                dbDao.addCopyProposalScopeRtCmdtRnote(vo);
            }

            // PRI_SP_SCP_RT_CMDT_RNOTE Display Seq Update
            PriSpScpRtCmdtRoutVO routVO = new PriSpScpRtCmdtRoutVO();
            routVO.setPropNo(vo.getNewPropNo());
            routVO.setAmdtSeq("0");
            routVO.setSvcScpCd(vo.getSvcScpCd());

            dbDao.modifyRouteNoteDispSeq(routVO, "0");
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Rate 데이터에 GRI Calculation을 적용합니다.<br>
     * 
     * @param PriSpScpGriGrpVO priSpScpGriGrpVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void applyGRICalculation(PriSpScpGriGrpVO priSpScpGriGrpVO, SignOnUserAccount account) throws EventException {
        try {
            if (priSpScpGriGrpVO != null) {
                priSpScpGriGrpVO.setUpdUsrId(account.getUsr_id());

                dbDao.modifyProposalScopeRateGRIApply(priSpScpGriGrpVO);
            }
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * 적용한 GRI Calculation을 취소합니다.<br>
     * 
     * @param PriSpScpGriGrpVO priSpScpGriGrpVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void cancelGRICalculation(PriSpScpGriGrpVO priSpScpGriGrpVO, SignOnUserAccount account) throws EventException {
        try {
            if (priSpScpGriGrpVO != null) {
                priSpScpGriGrpVO.setCreUsrId(account.getUsr_id());
                priSpScpGriGrpVO.setUpdUsrId(account.getUsr_id());
                
                if (!"0".equals(priSpScpGriGrpVO.getAmdtSeq())) {
                    dbDao.removeRateScgOnGRICancel(priSpScpGriGrpVO);
                    dbDao.removeRateScgRoutOnGRICancel(priSpScpGriGrpVO);
                    dbDao.removeRateUsdRoutCsOnGRICancel(priSpScpGriGrpVO);
                    
                    dbDao.addCopyPrevRateScgOnGRICancel(priSpScpGriGrpVO);
                    dbDao.addCopyPrevRateScgRoutOnGRICancel(priSpScpGriGrpVO);
                    dbDao.addCopyPrevRateUsdRoutCsOnGRICancel(priSpScpGriGrpVO);
                }
                
                dbDao.modifyProposalScopeRateGRICancel(priSpScpGriGrpVO);
//              int rslt = dbDao.modifyProposalScopeRateGRICancel(priSpScpGriGrpVO);
//              if (rslt <= 0) {
//                  throw new EventException(new ErrorHandler("PRI00352").getMessage());
//              }
            }
        } catch(EventException ex) {
            throw ex;
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
     * 
     * @param PriSpScpMnVO priSpScpMnVO
     * @exception EventException
     */
    public void removeProposalMain(PriSpScpMnVO priSpScpMnVO) throws EventException {
        try {
            if (priSpScpMnVO != null) {
                dbDao.removeSurchargeAdjustInitCancel(priSpScpMnVO);
                dbDao.removeProposalRtScg(priSpScpMnVO);                
                dbDao.removeProposalRtScgRout(priSpScpMnVO);
                dbDao.removeProposalRtUsdRoutCs(priSpScpMnVO);
                dbDao.removeProposalRt(priSpScpMnVO);               
                dbDao.removeProposalRtRoutVia(priSpScpMnVO);
                dbDao.removeProposalRtRoutPnt(priSpScpMnVO);                
                dbDao.removeProposalRtRoutDir(priSpScpMnVO);
                dbDao.removeProposalRtCmdtRnote(priSpScpMnVO);              
                dbDao.removeProposalRtCmdtRout(priSpScpMnVO);
                dbDao.removeProposalRtCnote(priSpScpMnVO);              
                dbDao.removeProposalRtActCust(priSpScpMnVO);
                dbDao.removeProposalRtCmdt(priSpScpMnVO);               
                dbDao.removeProposalRtCmdtHdr(priSpScpMnVO);
                
            }
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * S/C Proposal을 Request 할때 자동으로 Accept를 합니다.<br>
     * 
     * @param PriSpScpRtVO priSpScpRtVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void acceptRateDirectCall(PriSpScpRtVO priSpScpRtVO, SignOnUserAccount account) throws EventException {
        try {
            if (priSpScpRtVO != null) {
                priSpScpRtVO.setAcptUsrId(account.getUsr_id());
                priSpScpRtVO.setAcptOfcCd(account.getOfc_cd());
                priSpScpRtVO.setUpdUsrId(account.getUsr_id());
                priSpScpRtVO.setAcptDt(" ");
                dbDao.modifyAcceptRateDirectCall(priSpScpRtVO); // modifyAcceptRateDirectCall
            }

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * S/C Proposal을 Request Cancel 할때 Accept 데이터를 자동으로 Accept Cancel 합니다.<br>
     * 
     * @param PriSpScpRtVO priSpScpRtVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void cancelRateDirectCall(PriSpScpRtVO priSpScpRtVO, SignOnUserAccount account) throws EventException {
        try {
            if (priSpScpRtVO != null) {
                priSpScpRtVO.setAcptUsrId("");
                priSpScpRtVO.setAcptOfcCd("");
                priSpScpRtVO.setAcptDt(null);
                priSpScpRtVO.setUpdUsrId(account.getUsr_id());

                dbDao.modifyAcceptRateDirectCall(priSpScpRtVO); // modifyAcceptRateDirectCall
            }

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Guideline Rate 를 Proposal 에 Copy 합니다.<br>
     * 
     * @param SpScpGlineCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineRate(SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException {
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            // vo.setOfcCd(account.getOfc_cd());
            // PRI_SP_SCP_RT_CMDT_HDR COPY
            dbDao.addCopyScopeGuidelineRateCmdtHdr(vo);
            // PRI_SP_SCP_RT_CMDT COPY
            dbDao.addCopyScopeGuidelineRateCmdt(vo);
            // PRI_SP_SCP_RT_CMDT_ROUT COPY
            dbDao.addCopyScopeGuidelineRateCmdtRout(vo);
            // PRI_SP_SCP_RT_ROUT_PNT COPY
            dbDao.addCopyScopeGuidelineRateRoutPnt(vo);

            // PRI_SP_SCP_RT_ROUT_DIR COPY
            dbDao.addCopyScopeGuidelineRateRoutDir(vo);
            // PRI_SP_SCP_RT_ROUT_VIA COPY
            dbDao.addCopyScopeGuidelineRateRoutVia(vo);
            // PRI_SP_SCP_RT COPY
            dbDao.addCopyScopeGuidelineRate(vo);
            // PRI_SP_SCP_RT_CMDT_RNOTE COPY
            dbDao.addCopyScopeGuidelineRateCmdtRnote(vo);

            // PRI_SP_SCP_RT_CMDT_RNOTE Display Seq Update
            PriSpScpRtCmdtRoutVO routVO = new PriSpScpRtCmdtRoutVO();
            routVO.setPropNo(vo.getPropNo());
            routVO.setAmdtSeq(vo.getAmdtSeq());
            routVO.setSvcScpCd(vo.getSvcScpCd());

            dbDao.modifyRouteNoteDispSeq(routVO, "0");
        } catch (DAOException ex) {
            // log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            // log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * PRS- Applicable Route, Surcharge Detail을 조회 처리합니다.<br>
     * 
     * @param InpPrsSurchargeDetailApplicableRouteVO inpPrsSurchargeDetailApplicableRouteVO
     * @return RsltPrsSurchargeDetailListVO
     * @exception EventException
     */
    public RsltPrsSurchargeDetailListVO searchRateSurchargeList(InpPrsSurchargeDetailApplicableRouteVO inpPrsSurchargeDetailApplicableRouteVO)
            throws EventException {
        try {
            RsltPrsSurchargeDetailListVO rsltPrsSurchargeDetailListVO = new RsltPrsSurchargeDetailListVO();
            rsltPrsSurchargeDetailListVO.setRsltPrsSurchargeDetailVOS(dbDao
                    .searchSurchargeDetailList(inpPrsSurchargeDetailApplicableRouteVO));
            rsltPrsSurchargeDetailListVO.setRsltPrsSurchargeDetailApplicableRouteVOS(dbDao
                    .searchSurchargeList(inpPrsSurchargeDetailApplicableRouteVO));
            return rsltPrsSurchargeDetailListVO;
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * PRS- Surcharge Detail 내용을 추가,삭제,갱신처리 합니다.<br>
     * 
     * @param PriSpScpRtScgVO[] priSpScpRtScgVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageRateSurcharge(PriSpScpRtScgVO[] priSpScpRtScgVOs, SignOnUserAccount account)
            throws EventException {
        try {
            List<PriSpScpRtScgVO> insertVoList = new ArrayList<PriSpScpRtScgVO>();
            List<PriSpScpRtScgVO> updateVoList = new ArrayList<PriSpScpRtScgVO>();
            List<PriSpScpRtScgVO> deleteVoList = new ArrayList<PriSpScpRtScgVO>();
            PriSpScpRtScgVO priSpScpRtScgVo = null; 

            for (int i = 0; i < priSpScpRtScgVOs.length; i++) {
                if (priSpScpRtScgVOs[i].getIbflag().equals("I")) {
                    priSpScpRtScgVOs[i].setCreUsrId(account.getUsr_id());
                    priSpScpRtScgVOs[i].setUpdUsrId(account.getUsr_id());
                    priSpScpRtScgVOs[i].setTrfAdjTpCd("I");
                    insertVoList.add(priSpScpRtScgVOs[i]);
                } else if (priSpScpRtScgVOs[i].getIbflag().equals("U")) {
                    priSpScpRtScgVOs[i].setUpdUsrId(account.getUsr_id());
                    priSpScpRtScgVOs[i].setTrfAdjTpCd("I");
                    updateVoList.add(priSpScpRtScgVOs[i]);
                } else if (priSpScpRtScgVOs[i].getIbflag().equals("D")) {
                    priSpScpRtScgVOs[i].setUpdUsrId(account.getUsr_id());
                    deleteVoList.add(priSpScpRtScgVOs[i]);
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
            //chg_cd를 뺀 나머지 Key 부분만 있으면 되기때문에 
            // CUD중 하나의 key만 있으면 된다.
            if( deleteVoList.size() > 0 ){
                priSpScpRtScgVo = deleteVoList.get(0);
            }else if( updateVoList.size() > 0){
                priSpScpRtScgVo = updateVoList.get(0);
            }else if(insertVoList.size() > 0){
                priSpScpRtScgVo = insertVoList.get(0);
            }
            if(priSpScpRtScgVo != null){
                dbDao.modifyPrsRateSurchargeCmpb(priSpScpRtScgVo,"2");
                dbDao.modifyPrsRateCmdtRoutCmpb(priSpScpRtScgVo,"2");
                
            }
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * PRS- Surcharge Adjust을 조회합니다.<br>
     * 
     * @param RsltPriSurchargeAdjustListVO rsltPriSurchargeAdjustListVO
     * @return List<RsltPriSurchargeAdjustListVO>
     * @exception EventException
     */
    public List<RsltPriSurchargeAdjustListVO> searchSurchargeAdjustList(
            RsltPriSurchargeAdjustListVO rsltPriSurchargeAdjustListVO) throws EventException {
        try {
            List<RsltPriSurchargeAdjustListVO> rsltPriSurchargeAdjustListVOs = dbDao.searchSurchargeAdjustList(rsltPriSurchargeAdjustListVO);
            
            List<RsltPriSurchargeAdjustListVO>  returnVOs = new ArrayList<RsltPriSurchargeAdjustListVO>()   ;
            RsltPriSurchargeAdjustListVO vo ; 
            int cnt = rsltPriSurchargeAdjustListVOs.size();
            String ctnt = null;
            String chgCds = "|";
            boolean flg ;
            for(int i =0 ; i < cnt ; i++ ){
                vo = rsltPriSurchargeAdjustListVOs.get(i);
                ctnt = vo.getRplcNoteCtnt();
                
                flg = PRIUtil.checkSpecificText(ctnt, "SUBJECT" , "NOT" );
                if( flg == true){ //해당 text가 존재함 리스트에서 제외시킴
                    continue;
                }else{
                    flg = PRIUtil.checkSpecificText(ctnt, "APPLICABLE" , "NOT" );
                }
                if( flg == true){//해당 text가 존재함 리스트에서 제외시킴
                    continue;
                }else{
                    flg = PRIUtil.checkSpecificText(ctnt, "APPLY" , "NOT" );
                }   
                if( flg == true){//해당 text가 존재함 리스트에서 제외시킴
                    continue;
                }else{
                    flg = PRIUtil.checkSpecificText(ctnt, "APPLIED" , "NOT" );
                }   
                if( flg == true){//해당 text가 존재함 리스트에서 제외시킴
                    continue;
                }else{
                    flg = PRIUtil.checkSpecificText(ctnt, "NOTINCLUSIVE" , null);
                }   
                if( flg == true){//해당 text가 존재함 리스트에서 제외시킴
                    continue;
                }else{
                    flg = PRIUtil.checkSpecificText(ctnt, "NOTINCLUDED" , null);
                }   
                if( flg == true){//해당 text가 존재함 리스트에서 제외시킴
                    continue;
                }
                
 
                
                if( "I".equals(vo.getIbflag()) ){
	                //chg_cd를 unique 하게 한다.
	                if( chgCds.indexOf("|"+ vo.getChgCd() +"|") >=0 ){
	                	continue;
	                }
	                chgCds = chgCds + vo.getChgCd() + "|" ;
                }
                
                
                returnVOs.add( vo);
            }
            return returnVOs;
            
            
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }
    
    
    /**
     * PRS- Surcharge Adjust 팝업을 띄이기 전 해당 surcharge에 대해 note가 존재하는지 체크합니다.<br>
     * 
     * @param RsltPriCheckSurchargeNoteListVO rsltPriCheckSurchargeNoteListVO
     * @return List<RsltPriCheckSurchargeNoteListVO>
     * @exception EventException
     */
    public List<RsltPriCheckSurchargeNoteListVO> searchCheckSurchargeNoteList(
            RsltPriCheckSurchargeNoteListVO rsltPriCheckSurchargeNoteListVO) throws EventException{
        try {
            //Wording 검사 //
            //Case1 - Subject/Applicable/Apply/applied (단어 앞에 not이 없어야 함)
            //Case1 - Inclusive/INCLUDED (단어 앞에 not이 있어야 함)
            List<RsltPriCheckSurchargeNoteListVO>  rsltPriCheckSurchargeNoteListVOs =  dbDao.searchCheckSurchargeNoteList(rsltPriCheckSurchargeNoteListVO);
            
            List<RsltPriCheckSurchargeNoteListVO>  returnVOs = new ArrayList<RsltPriCheckSurchargeNoteListVO>()   ;
            RsltPriCheckSurchargeNoteListVO vo ; 
            int cnt = rsltPriCheckSurchargeNoteListVOs.size();
            String ctnt = null;
            StringBuffer chgCds = new StringBuffer(); 
            chgCds.append( "|" );
            boolean flg ;
            for(int i =0 ; i < cnt ; i++ ){
                vo = rsltPriCheckSurchargeNoteListVOs.get(i);
                ctnt = vo.getRplcNoteCtnt();
                
                flg = PRIUtil.checkSpecificText(ctnt, "SUBJECT" , "NOT" );
                if( flg == true){ //해당 text가 존재함 리스트에서 제외시킴
                    continue;
                }else{
                    flg = PRIUtil.checkSpecificText(ctnt, "APPLICABLE" , "NOT" );
                }
                if( flg == true){//해당 text가 존재함 리스트에서 제외시킴
                    continue;
                }else{
                    flg = PRIUtil.checkSpecificText(ctnt, "APPLY" , "NOT" );
                }   
                if( flg == true){//해당 text가 존재함 리스트에서 제외시킴
                    continue;
                }else{
                    flg = PRIUtil.checkSpecificText(ctnt, "APPLIED" , "NOT" );
                }   
                if( flg == true){//해당 text가 존재함 리스트에서 제외시킴
                    continue;
                }else{
                    flg = PRIUtil.checkSpecificText(ctnt, "NOTINCLUSIVE" , null);
                }   
                if( flg == true){//해당 text가 존재함 리스트에서 제외시킴
                    continue;
                }else{
                    flg = PRIUtil.checkSpecificText(ctnt, "NOTINCLUDED" , null);
                }   
                if( flg == true){//해당 text가 존재함 리스트에서 제외시킴
                    continue;
                }
                
                //chg_cd를 unique 하게 한다.
                if( chgCds.indexOf("|"+ vo.getChgCd() +"|") >=0 ){
                	continue;
                }
//                chgCds =  chgCds + vo.getChgCd() + "|" ;
                chgCds.append( vo.getChgCd()).append("|");
                returnVOs.add( vo);
            }
            return returnVOs;
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }   

    /**
     * PRS- Surcharge Adjust 내용을 추가,삭제,갱신처리 합니다.<br>
     * 
     * @param PriSpScpScgAdjVO[] priSpScpScgAdjVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageSurchargeAdjust(PriSpScpScgAdjVO[] priSpScpScgAdjVO, SignOnUserAccount account)
            throws EventException {
        try {
            List<PriSpScpScgAdjVO> insertVoList = new ArrayList<PriSpScpScgAdjVO>();
            List<PriSpScpScgAdjVO> updateVoList = new ArrayList<PriSpScpScgAdjVO>();
            List<PriSpScpScgAdjVO> deleteVoList = new ArrayList<PriSpScpScgAdjVO>();


            for (int i = 0; i < priSpScpScgAdjVO.length; i++) {
                if (priSpScpScgAdjVO[i].getIbflag().equals("I")) {
                    priSpScpScgAdjVO[i].setCreUsrId(account.getUsr_id());
                    priSpScpScgAdjVO[i].setUpdUsrId(account.getUsr_id());
                    insertVoList.add(priSpScpScgAdjVO[i]);
                } else if (priSpScpScgAdjVO[i].getIbflag().equals("U")) {
                    priSpScpScgAdjVO[i].setUpdUsrId(account.getUsr_id());
                    updateVoList.add(priSpScpScgAdjVO[i]);
                } else if (priSpScpScgAdjVO[i].getIbflag().equals("D")) {
                    priSpScpScgAdjVO[i].setUpdUsrId(account.getUsr_id());
                    deleteVoList.add(priSpScpScgAdjVO[i]);
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
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * PRS- Surcharge Adjust 내용을 바탕으로 calc 로직을 수행 합니다.<br>
     * 
     * @param PriSpScpScgAdjVO priSpScpScgAdjVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageSurchargeAdjustCalc(PriSpScpScgAdjVO priSpScpScgAdjVO, SignOnUserAccount account)
            throws EventException {
        PriSpScpScgAdjVO tmpPriSpScpScgAdjVO = new PriSpScpScgAdjVO();
        RsltPriPrsCostListVO rsltPriPrsCostListVO = null;
        PriSpScpRtScgVO priSpScpRtScgVo = null; 
        try {
            if( tmpPriSpScpScgAdjVO != null ){
                rsltPriPrsCostListVO = new RsltPriPrsCostListVO();
                rsltPriPrsCostListVO.setUpdUsrId(account.getUsr_id());
                rsltPriPrsCostListVO.setPropNo(priSpScpScgAdjVO.getPropNo());
                rsltPriPrsCostListVO.setAmdtSeq(priSpScpScgAdjVO.getAmdtSeq());
                rsltPriPrsCostListVO.setSvcScpCd(priSpScpScgAdjVO.getSvcScpCd());
                rsltPriPrsCostListVO.setGenSpclRtTpCd(priSpScpScgAdjVO.getGenSpclRtTpCd());

                priSpScpRtScgVo = new PriSpScpRtScgVO();
                priSpScpRtScgVo.setUpdUsrId(account.getUsr_id());
                priSpScpRtScgVo.setPropNo(priSpScpScgAdjVO.getPropNo());
                priSpScpRtScgVo.setAmdtSeq(priSpScpScgAdjVO.getAmdtSeq());
                priSpScpRtScgVo.setSvcScpCd(priSpScpScgAdjVO.getSvcScpCd());
                priSpScpRtScgVo.setGenSpclRtTpCd(priSpScpScgAdjVO.getGenSpclRtTpCd());
                
                //Calc의 일부 로직
                dbDao.addPriSpScpRtScgAmtCostDetail(rsltPriPrsCostListVO,"1");//mergePRI_SP_SCP_RT_SCG
                dbDao.modifyPrsRateSurchargeCmpb(priSpScpRtScgVo,"1");
                dbDao.modifyPrsRateCmdtRoutCmpb(priSpScpRtScgVo,"1");
            }
            
            
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Commodity Group을 조회합니다.<br>
     * 
     * @param RsltPriSurchargeAdjustCommodityVO rsltPriSurchargeAdjustCommodityVO
     * @return List<RsltPriSurchargeAdjustCommodityVO>
     * @exception EventException
     */
    public List<RsltPriSurchargeAdjustCommodityVO> searchRateCommodityAllList(
            RsltPriSurchargeAdjustCommodityVO rsltPriSurchargeAdjustCommodityVO) throws EventException {
        try {
            return dbDao.searchRateCommodityAllList(rsltPriSurchargeAdjustCommodityVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Surcharge Adjust-Commodity group에 대한 상세 내용을 조회합니다.<br>
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
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Surcharge Adjust-Location Group을 조회 합니다.<br>
     * 
     * @param rsltPriSurchargeAdjustLocationGroupVO RsltPriSurchargeAdjustLocationGroupVO
     * @return List<RsltPriSurchargeAdjustLocationGroupVO>
     * @exception EventException
     */
    public List<RsltPriSurchargeAdjustLocationGroupVO> searchRateLocationAllList(
            RsltPriSurchargeAdjustLocationGroupVO rsltPriSurchargeAdjustLocationGroupVO) throws EventException {
        try {
            return dbDao.searchRateLocationAllList(rsltPriSurchargeAdjustLocationGroupVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Surcharge Adjust-Location Group에 상세 정보를 조회 합니다.<br>
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
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
     * 
     * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalRequestCancel(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException {
        try {
            if (priSpScpMnVO != null) {
                priSpScpMnVO.setUpdUsrId(account.getUsr_id());
            }
            dbDao.modifyProposalRtActCustReqCnl(priSpScpMnVO);
            dbDao.modifyProposalRtCmdtReqCnl(priSpScpMnVO);
            dbDao.modifyProposalRtCmdtRnoteReqCnl(priSpScpMnVO);
            dbDao.modifyProposalRtCnoteReqCnl(priSpScpMnVO);
            dbDao.modifyProposalRtReqCnl(priSpScpMnVO);
            dbDao.modifyProposalRtRoutDirReqCnl(priSpScpMnVO);
            dbDao.modifyProposalRtRoutPntReqCnl(priSpScpMnVO);
            dbDao.modifyProposalRtRoutViaReqCnl(priSpScpMnVO);
            
        } catch (DAOException ex) {
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
    }
    
    /**
     * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
     * 
     * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalRequestCancelDirectCall(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException {
        try {
            if (priSpScpMnVO != null) {
                priSpScpMnVO.setUpdUsrId(account.getUsr_id());
            }
            dbDao.modifyProposalRtRoutDirReqCnl(priSpScpMnVO);
            
        } catch (DAOException ex) {
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
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
    public List<RsltPriPrsCostListVO> searchCostDetailList(RsltPriPrsCostListVO rsltPriPrsCostListVO)
            throws EventException {
        try {
            return dbDao.searchCostDetailList(rsltPriPrsCostListVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
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
    public List<RsltPriPrsCostDetailVO> searchCostDetailInquiryList(RsltPriPrsCostDetailVO rsltPriPrsCostDetailVO)
            throws EventException {
        try {
            return dbDao.searchCostDetailInquiryList(rsltPriPrsCostDetailVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    

    /**
     * CM/OP View 내용을 조회 합니다.<br>
     * 
     * @param RsltPriRateCmViewAllVO rsltPriRateCmViewAllVO
     * @return List<RsltPriRateCmViewAllVO>
     * @exception EventException
     */
    public List<RsltPriRateCmViewAllVO> searchRateCmViewAllList(
            RsltPriRateCmViewAllVO rsltPriRateCmViewAllVO) throws EventException {
        try {
            return dbDao.searchRateCmViewAllList(rsltPriRateCmViewAllVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * 멀티 이벤트 처리<br>
     * CM/OP View 의 load 값을  갱신처리 합니다.<BR>
     * 
     * @param priSpScpRtCmdtRoutSetVO PriSpScpRtCmdtRoutSetVO
     * @param account SignOnUserAccount
     * @exception EventException
     */
    public void modifyPrsPfmc(PriSpScpRtCmdtRoutSetVO priSpScpRtCmdtRoutSetVO, SignOnUserAccount account)
            throws EventException {
        try {
            List<PriSpScpRtCmdtRoutVO> updateVoList = new ArrayList<PriSpScpRtCmdtRoutVO>();
            String pfmcUnit = priSpScpRtCmdtRoutSetVO.getPfmcUnit();
            PriSpScpRtCmdtRoutVO[] priSpScpRtCmdtRoutVO = priSpScpRtCmdtRoutSetVO.getPriSpScpRtCmdtRoutVOS();
 
            for (int i = 0; i < priSpScpRtCmdtRoutVO.length; i++) {
                if (priSpScpRtCmdtRoutVO[i].getIbflag().equals("U")) {
                    priSpScpRtCmdtRoutVO[i].setUpdUsrId(account.getUsr_id());
                    updateVoList.add(priSpScpRtCmdtRoutVO[i]);
                }
            }

            if (updateVoList.size() > 0) {
                dbDao.modifyPrsPfmc(updateVoList,pfmcUnit);
                //추가 로직수행 MN Table에 summary값 update
                dbDao.modifyMainSummary(updateVoList.get(0));
            }
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * S/C Amendment CM/OP View 내용을 조회 합니다.<br>
     * 
     * @param RsltPriAmdCmViewAllVO rsltPriAmdCmViewAllVO
     * @return List<RsltPriAmdCmViewAllVO>
     * @exception EventException
     */
    public List<RsltPriAmdCmViewAllVO> searchAmdtRateCmViewAllList(
            RsltPriAmdCmViewAllVO rsltPriAmdCmViewAllVO) throws EventException {
        try {
            return dbDao.searchAmdtRateCmViewAllList(rsltPriAmdCmViewAllVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
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
            if( list != null && list.size() > 0){
                rsltPriAmdCmpbOpbViewAllVO =  list.get(0);
            }
            return rsltPriAmdCmpbOpbViewAllVO;
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }
    

    /**
     * S/C Amendment CM/OP View 의 load값을 갱신처리 합니다.
     * 
     * @param PriSpScpRtCmdtRoutSetVO priSpScpRtCmdtRoutSetVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyAmdtPrsPfmc(PriSpScpRtCmdtRoutSetVO priSpScpRtCmdtRoutSetVO, SignOnUserAccount account)
            throws EventException {
        try {
            List<PriSpScpRtCmdtRoutVO> updateVoList = new ArrayList<PriSpScpRtCmdtRoutVO>();
            String pfmcUnit = priSpScpRtCmdtRoutSetVO.getPfmcUnit();
            PriSpScpRtCmdtRoutVO[] priSpScpRtCmdtRoutVO = priSpScpRtCmdtRoutSetVO.getPriSpScpRtCmdtRoutVOS();
 
            for (int i = 0; i < priSpScpRtCmdtRoutVO.length; i++) {
                if (priSpScpRtCmdtRoutVO[i].getIbflag().equals("U")) {
                    priSpScpRtCmdtRoutVO[i].setUpdUsrId(account.getUsr_id());
                    updateVoList.add(priSpScpRtCmdtRoutVO[i]);
                }
            }

            if (updateVoList.size() > 0) {
                dbDao.modifyAmdtPrsPfmc(updateVoList,pfmcUnit);
                //추가 로직수행 MN Table에 summary값 update
                dbDao.modifyMainSummary(updateVoList.get(0));               
            }
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    
     
    
    /**
     * Load된 엑셀 데이터가 올바른지 Check한다.<br>
     * 
     * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
     * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> checkRateExcelVertical(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs) throws EventException {
        List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();
        
        try {
            int cnt = rsltRtListVerticalExcelVOs.length;
            RsltRtListVerticalExcelVO row = null;
            String strCmdtCd = null;
            String strCustSeq = null;
            String strOrgPntCd = null;
            String strOrgViaCd = null;
            String strDestViaCd = null;
            String strDestPntCd = null;
            for (int i = 0 ; i < cnt ; i++) {
                row = rsltRtListVerticalExcelVOs[i];
                
                strCmdtCd = row.getPrcCmdtDefCd();
                strCustSeq = row.getCustSeq();
                strOrgPntCd = row.getOrgRoutPntLocDefCd();
                strOrgViaCd = row.getOrgRoutViaPortDefCd();
                strDestViaCd = row.getDestRoutViaPortDefCd();
                strDestPntCd = row.getDestRoutPntLocDefCd();
                
                if (strCmdtCd != null && !"".equals(strCmdtCd)) {
                    RsltCdListVO paramVO = new RsltCdListVO();
                    paramVO.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
                    paramVO.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
                    paramVO.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
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
                    paramVO.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
                    paramVO.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
                    paramVO.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
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
                    paramVO.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
                    paramVO.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
                    paramVO.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
                    paramVO.setCd(strOrgPntCd);
                    
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
                    paramVO.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
                    paramVO.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
                    paramVO.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
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
                    paramVO.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
                    paramVO.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
                    paramVO.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
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
                    paramVO.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
                    paramVO.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
                    paramVO.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
                    paramVO.setCd(strDestPntCd);
                    
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
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
        
        return rslt;
    }
    
    /**
     * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
     * 
     * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
     * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String uploadRateExcelVertical(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs, SignOnUserAccount account) throws EventException {
        BackEndJobManager backEndJobManager = new BackEndJobManager();
        UploadRateExcelVerticalBackEndJobImpl jobImpl = new UploadRateExcelVerticalBackEndJobImpl();
        String key = null;
        
        try {
            jobImpl.setPriSpScpRtCmdtHdrVO(priSpScpRtCmdtHdrVO);
            jobImpl.setRsltRtListVerticalExcelVOs(rsltRtListVerticalExcelVOs);
            jobImpl.setAccount(account);
            
            key = backEndJobManager.execute(jobImpl, account.getUsr_id(), "ESM_PRI_0029");
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(),ex);
        }
        
        return key;
    }
    
    /**
     * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
     * 
     * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
     * @param RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void uploadRateExcelVerticalOnline(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, RsltRtListVerticalExcelVO[] rsltRtListVerticalExcelVOs, SignOnUserAccount account) throws EventException {
      List<PriSpScpRtCmdtHdrVO> cmdtHdrVoList = new ArrayList<PriSpScpRtCmdtHdrVO>();
      List<PriSpScpRtCmdtVO> cmdtVoList = new ArrayList<PriSpScpRtCmdtVO>();
      List<PriSpScpRtActCustVO> custVoList = new ArrayList<PriSpScpRtActCustVO>();
      List<PriSpScpRtCmdtRoutVO> routVoList = new ArrayList<PriSpScpRtCmdtRoutVO>();
      List<PriSpScpRtRoutPntVO> pntVoList = new ArrayList<PriSpScpRtRoutPntVO>();
      List<PriSpScpRtRoutViaVO> viaVoList = new ArrayList<PriSpScpRtRoutViaVO>();
      List<PriSpScpRtRoutDirVO> dcallVoList = new ArrayList<PriSpScpRtRoutDirVO>();
      List<PriSpScpRtVO> rtVoList = new ArrayList<PriSpScpRtVO>();
      List<PriSpScpRtScgVO> scgVoList = new ArrayList<PriSpScpRtScgVO>();
      
      try {
          int nextCmdtHdrSeq = dbDao.searchNextCmdtHdrSeq(priSpScpRtCmdtHdrVO);
          int nextBletDpSeq = Integer.parseInt(dbDao.searchMaxBulletDispSeq(priSpScpRtCmdtHdrVO));
          int nextCmdtSeq = 0;
          int nextActCustSeq = 0;
          
          int nextRoutSeq = 0;
          int nextRoutPntSeq = 0;
          int nextRoutViaSeq = 0;
          int nextRtSeq = 0;
          
          String strPropNo = priSpScpRtCmdtHdrVO.getPropNo();
          String strAmdtSeq = priSpScpRtCmdtHdrVO.getAmdtSeq();
          String strSvcScpCd = priSpScpRtCmdtHdrVO.getSvcScpCd();
          String strGenSpclRtTpCd = priSpScpRtCmdtHdrVO.getGenSpclRtTpCd();
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
              String strDirCall = (row.getDirCallFlg() == null || "".equals(row.getDirCallFlg())) ? "N" : row.getDirCallFlg();
              
              String strPerTypeCd = row.getRatUtCd();
              String strCgoTypeCd = row.getPrcCgoTpCd();
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
                  
                  PriSpScpRtCmdtHdrVO cmdtHdr = new PriSpScpRtCmdtHdrVO();
                  cmdtHdr.setPropNo(strPropNo);
                  cmdtHdr.setAmdtSeq(strAmdtSeq);
                  cmdtHdr.setSvcScpCd(strSvcScpCd);
                  cmdtHdr.setGenSpclRtTpCd(strGenSpclRtTpCd);
                  cmdtHdr.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
                  cmdtHdr.setBletDpSeq(String.valueOf(nextBletDpSeq));
                  cmdtHdr.setN1stCmncAmdtSeq(strAmdtSeq);
                  cmdtHdr.setCreUsrId(strCreUsrId);
                  cmdtHdr.setUpdUsrId(strUpdUsrId);
                  
                  cmdtHdrVoList.add(cmdtHdr);
              }
              
              if (strCmdtCd != null && !"".equals(strCmdtCd)) {
                  nextCmdtSeq++;
                  
                  String cmdtTpCd = strCmdtCd.length() == 5 ? "G" : "C";
                  
                  PriSpScpRtCmdtVO cmdt = new PriSpScpRtCmdtVO();
                  cmdt.setPropNo(strPropNo);
                  cmdt.setAmdtSeq(strAmdtSeq);
                  cmdt.setSvcScpCd(strSvcScpCd);
                  cmdt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                  
                  PriSpScpRtActCustVO cust = new PriSpScpRtActCustVO();
                  cust.setPropNo(strPropNo);
                  cust.setAmdtSeq(strAmdtSeq);
                  cust.setSvcScpCd(strSvcScpCd);
                  cust.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                  
                  PriSpScpRtCmdtRoutVO rout = new PriSpScpRtCmdtRoutVO();
                  rout.setPropNo(strPropNo);
                  rout.setAmdtSeq(strAmdtSeq);
                  rout.setSvcScpCd(strSvcScpCd);
                  rout.setGenSpclRtTpCd(strGenSpclRtTpCd);
                  rout.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
                  rout.setRoutSeq(String.valueOf(nextRoutSeq));
                  rout.setN1stCmncAmdtSeq(strAmdtSeq);
                  rout.setCreUsrId(strCreUsrId);
                  rout.setUpdUsrId(strUpdUsrId);
                  
                  routVoList.add(rout);
                  
                  PriSpScpRtRoutDirVO dir = new PriSpScpRtRoutDirVO();
                  dir.setPropNo(strPropNo);
                  dir.setAmdtSeq(strAmdtSeq);
                  dir.setSvcScpCd(strSvcScpCd);
                  dir.setGenSpclRtTpCd(strGenSpclRtTpCd);
                  dir.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
                  dir.setRoutSeq(String.valueOf(nextRoutSeq));
                  dir.setDirCallFlg(strDirCall);
                  dir.setPrcProgStsCd("I");
                  dir.setSrcInfoCd("NW");
                  dir.setN1stCmncAmdtSeq(strAmdtSeq);
                  dir.setCreUsrId(strCreUsrId);
                  dir.setUpdUsrId(strUpdUsrId);
                  
                  dcallVoList.add(dir);
              }
              
              if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
                  nextRoutPntSeq++;
                  
                  String locTpCd = strOrgPntCd.length() == 4 ? "G" : "L";
                  
                  PriSpScpRtRoutPntVO pnt = new PriSpScpRtRoutPntVO();
                  pnt.setPropNo(strPropNo);
                  pnt.setAmdtSeq(strAmdtSeq);
                  pnt.setSvcScpCd(strSvcScpCd);
                  pnt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                  
                  PriSpScpRtRoutViaVO via = new PriSpScpRtRoutViaVO();
                  via.setPropNo(strPropNo);
                  via.setAmdtSeq(strAmdtSeq);
                  via.setSvcScpCd(strSvcScpCd);
                  via.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                  
                  PriSpScpRtRoutViaVO via = new PriSpScpRtRoutViaVO();
                  via.setPropNo(strPropNo);
                  via.setAmdtSeq(strAmdtSeq);
                  via.setSvcScpCd(strSvcScpCd);
                  via.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                  
                  PriSpScpRtRoutPntVO pnt = new PriSpScpRtRoutPntVO();
                  pnt.setPropNo(strPropNo);
                  pnt.setAmdtSeq(strAmdtSeq);
                  pnt.setSvcScpCd(strSvcScpCd);
                  pnt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                  
                  PriSpScpRtVO rt = new PriSpScpRtVO();
                  rt.setPropNo(strPropNo);
                  rt.setAmdtSeq(strAmdtSeq);
                  rt.setSvcScpCd(strSvcScpCd);
                  rt.setGenSpclRtTpCd(strGenSpclRtTpCd);
                  rt.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
                  rt.setRoutSeq(String.valueOf(nextRoutSeq));
                  rt.setRtSeq(String.valueOf(nextRtSeq));
                  rt.setRatUtCd(strPerTypeCd);
                  rt.setPrcCgoTpCd(strCgoTypeCd);
                  rt.setCurrCd("USD");
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
                      PriSpScpRtScgVO scg = new PriSpScpRtScgVO();
                      scg.setPropNo(strPropNo);
                      scg.setAmdtSeq(strAmdtSeq);
                      scg.setSvcScpCd(strSvcScpCd);
                      scg.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                      PriSpScpRtScgVO scg = new PriSpScpRtScgVO();
                      scg.setPropNo(strPropNo);
                      scg.setAmdtSeq(strAmdtSeq);
                      scg.setSvcScpCd(strSvcScpCd);
                      scg.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                      PriSpScpRtScgVO scg = new PriSpScpRtScgVO();
                      scg.setPropNo(strPropNo);
                      scg.setAmdtSeq(strAmdtSeq);
                      scg.setSvcScpCd(strSvcScpCd);
                      scg.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
          if (dcallVoList.size() > 0) {
              dbDao.addRateRouteDirectCall(dcallVoList);
          }
          
          if (rtVoList.size() > 0) {
              dbDao.addRate(rtVoList);
          }
          if (scgVoList.size() > 0) {
              dbDao.addRateSurcharge(scgVoList);
          }
          
      } catch (DAOException ex) {
          log.error("err " + ex.toString(), ex);
          throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
      } catch (Exception ex) {
          log.error("err " + ex.toString(), ex);
          throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
      }
    }

    /**
     * Load된 엑셀 데이터가 올바른지 Check한다.<br>
     * 
     * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
     * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> checkRateExcelHorizontal(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs) throws EventException {
        List<RsltCdListVO> rslt = new ArrayList<RsltCdListVO>();
        
        try {
            int cnt = rsltRtListHorizontalExcelVOs.length;
            RsltRtListHorizontalExcelVO row = null;

            String strCmdtCd = null;
            String strCustSeq = null;
            String strOrgPntCd = null;
            String strOrgViaCd = null;
            String strDestViaCd = null;
            String strDestPntCd = null;
            for (int i = 0 ; i < cnt ; i++) {
                row = rsltRtListHorizontalExcelVOs[i];

                strCmdtCd = row.getPrcCmdtDefCd();
                strCustSeq = row.getCustSeq();
                strOrgPntCd = row.getOrgRoutPntLocDefCd();
                strOrgViaCd = row.getOrgRoutViaPortDefCd();
                strDestViaCd = row.getDestRoutViaPortDefCd();
                strDestPntCd = row.getDestRoutPntLocDefCd();

                if (strCmdtCd != null && !"".equals(strCmdtCd)) {
                    RsltCdListVO paramVO = new RsltCdListVO();
                    paramVO.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
                    paramVO.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
                    paramVO.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
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
                    paramVO.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
                    paramVO.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
                    paramVO.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
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
                    paramVO.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
                    paramVO.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
                    paramVO.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
                    paramVO.setCd(strOrgPntCd);

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
                    paramVO.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
                    paramVO.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
                    paramVO.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
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
                    paramVO.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
                    paramVO.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
                    paramVO.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
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
                    paramVO.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
                    paramVO.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
                    paramVO.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
                    paramVO.setCd(strDestPntCd);
                    
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
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
        
        return rslt;
    }
    
    /**
     * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
     * 
     * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
     * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String uploadRateExcelHorizontal(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs, SignOnUserAccount account) throws EventException {
        BackEndJobManager backEndJobManager = new BackEndJobManager();
        UploadRateExcelHorizontalBackEndJobImpl jobImpl = new UploadRateExcelHorizontalBackEndJobImpl();
        String key = null;
        
        try {
            jobImpl.setPriSpScpRtCmdtHdrVO(priSpScpRtCmdtHdrVO);
            jobImpl.setRsltRtListHorizontalExcelVOs(rsltRtListHorizontalExcelVOs);
            jobImpl.setAccount(account);
            
            key = backEndJobManager.execute(jobImpl, account.getUsr_id(), "ESM_PRI_0099");
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(),ex);
        }
        
        return key;
    }
    
    /**
     * Sheet에 로드된 엑셀 데이터를 입력한다.<br>
     * 
     * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
     * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void uploadRateExcelHorizontalOnline(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOs, SignOnUserAccount account) throws EventException {
      List<PriSpScpRtCmdtHdrVO> cmdtHdrVoList = new ArrayList<PriSpScpRtCmdtHdrVO>();
      List<PriSpScpRtCmdtVO> cmdtVoList = new ArrayList<PriSpScpRtCmdtVO>();
      List<PriSpScpRtActCustVO> custVoList = new ArrayList<PriSpScpRtActCustVO>();
      List<PriSpScpRtCmdtRoutVO> routVoList = new ArrayList<PriSpScpRtCmdtRoutVO>();
      List<PriSpScpRtRoutPntVO> pntVoList = new ArrayList<PriSpScpRtRoutPntVO>();
      List<PriSpScpRtRoutViaVO> viaVoList = new ArrayList<PriSpScpRtRoutViaVO>();
      List<PriSpScpRtRoutDirVO> dcallVoList = new ArrayList<PriSpScpRtRoutDirVO>();
      List<PriSpScpRtVO> rtVoList = new ArrayList<PriSpScpRtVO>();
      List<PriSpScpRtScgVO> scgVoList = new ArrayList<PriSpScpRtScgVO>();
      
      try {
          int nextCmdtHdrSeq = dbDao.searchNextCmdtHdrSeq(priSpScpRtCmdtHdrVO);
          int nextBletDpSeq = Integer.parseInt(dbDao.searchMaxBulletDispSeq(priSpScpRtCmdtHdrVO));
          int nextCmdtSeq = 0;
          int nextActCustSeq = 0;
          
          int nextRoutSeq = 0;
          int nextRoutPntSeq = 0;
          int nextRoutViaSeq = 0;
          int nextRtSeq = 0;
          
          String strPropNo = priSpScpRtCmdtHdrVO.getPropNo();
          String strAmdtSeq = priSpScpRtCmdtHdrVO.getAmdtSeq();
          String strSvcScpCd = priSpScpRtCmdtHdrVO.getSvcScpCd();
          String strGenSpclRtTpCd = priSpScpRtCmdtHdrVO.getGenSpclRtTpCd();
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
              String strDirCall = (row.getDirCallFlg() == null || "".equals(row.getDirCallFlg())) ? "N" : row.getDirCallFlg();
              
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
                  
                  PriSpScpRtCmdtHdrVO cmdtHdr = new PriSpScpRtCmdtHdrVO();
                  cmdtHdr.setPropNo(strPropNo);
                  cmdtHdr.setAmdtSeq(strAmdtSeq);
                  cmdtHdr.setSvcScpCd(strSvcScpCd);
                  cmdtHdr.setGenSpclRtTpCd(strGenSpclRtTpCd);
                  cmdtHdr.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
                  cmdtHdr.setBletDpSeq(String.valueOf(nextBletDpSeq));
                  cmdtHdr.setN1stCmncAmdtSeq(strAmdtSeq);
                  cmdtHdr.setCreUsrId(strCreUsrId);
                  cmdtHdr.setUpdUsrId(strUpdUsrId);
                  
                  cmdtHdrVoList.add(cmdtHdr);
              }
              
              if (strCmdtCd != null && !"".equals(strCmdtCd)) {
                  nextCmdtSeq++;
                  
                  String cmdtTpCd = strCmdtCd.length() == 5 ? "G" : "C";
                  
                  PriSpScpRtCmdtVO cmdt = new PriSpScpRtCmdtVO();
                  cmdt.setPropNo(strPropNo);
                  cmdt.setAmdtSeq(strAmdtSeq);
                  cmdt.setSvcScpCd(strSvcScpCd);
                  cmdt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                  
                  PriSpScpRtActCustVO cust = new PriSpScpRtActCustVO();
                  cust.setPropNo(strPropNo);
                  cust.setAmdtSeq(strAmdtSeq);
                  cust.setSvcScpCd(strSvcScpCd);
                  cust.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                  
                  PriSpScpRtCmdtRoutVO rout = new PriSpScpRtCmdtRoutVO();
                  rout.setPropNo(strPropNo);
                  rout.setAmdtSeq(strAmdtSeq);
                  rout.setSvcScpCd(strSvcScpCd);
                  rout.setGenSpclRtTpCd(strGenSpclRtTpCd);
                  rout.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
                  rout.setRoutSeq(String.valueOf(nextRoutSeq));
                  rout.setN1stCmncAmdtSeq(strAmdtSeq);
                  rout.setCreUsrId(strCreUsrId);
                  rout.setUpdUsrId(strUpdUsrId);
                  
                  routVoList.add(rout);
                  
                  PriSpScpRtRoutDirVO dir = new PriSpScpRtRoutDirVO();
                  dir.setPropNo(strPropNo);
                  dir.setAmdtSeq(strAmdtSeq);
                  dir.setSvcScpCd(strSvcScpCd);
                  dir.setGenSpclRtTpCd(strGenSpclRtTpCd);
                  dir.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
                  dir.setRoutSeq(String.valueOf(nextRoutSeq));
                  dir.setDirCallFlg(strDirCall);
                  dir.setPrcProgStsCd("I");
                  dir.setSrcInfoCd("NW");
                  dir.setN1stCmncAmdtSeq(strAmdtSeq);
                  dir.setCreUsrId(strCreUsrId);
                  dir.setUpdUsrId(strUpdUsrId);
                  
                  dcallVoList.add(dir);
              }
              
              if (strOrgPntCd != null && !"".equals(strOrgPntCd)) {
                  nextRoutPntSeq++;
                  
                  String locTpCd = strOrgPntCd.length() == 4 ? "G" : "L";
                  
                  PriSpScpRtRoutPntVO pnt = new PriSpScpRtRoutPntVO();
                  pnt.setPropNo(strPropNo);
                  pnt.setAmdtSeq(strAmdtSeq);
                  pnt.setSvcScpCd(strSvcScpCd);
                  pnt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                  
                  PriSpScpRtRoutViaVO via = new PriSpScpRtRoutViaVO();
                  via.setPropNo(strPropNo);
                  via.setAmdtSeq(strAmdtSeq);
                  via.setSvcScpCd(strSvcScpCd);
                  via.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                  
                  PriSpScpRtRoutViaVO via = new PriSpScpRtRoutViaVO();
                  via.setPropNo(strPropNo);
                  via.setAmdtSeq(strAmdtSeq);
                  via.setSvcScpCd(strSvcScpCd);
                  via.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                  
                  PriSpScpRtRoutPntVO pnt = new PriSpScpRtRoutPntVO();
                  pnt.setPropNo(strPropNo);
                  pnt.setAmdtSeq(strAmdtSeq);
                  pnt.setSvcScpCd(strSvcScpCd);
                  pnt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                  
                  PriSpScpRtVO rt = new PriSpScpRtVO();
                  rt.setPropNo(strPropNo);
                  rt.setAmdtSeq(strAmdtSeq);
                  rt.setSvcScpCd(strSvcScpCd);
                  rt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                      PriSpScpRtScgVO scg = new PriSpScpRtScgVO();
                      scg.setPropNo(strPropNo);
                      scg.setAmdtSeq(strAmdtSeq);
                      scg.setSvcScpCd(strSvcScpCd);
                      scg.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                      PriSpScpRtScgVO scg = new PriSpScpRtScgVO();
                      scg.setPropNo(strPropNo);
                      scg.setAmdtSeq(strAmdtSeq);
                      scg.setSvcScpCd(strSvcScpCd);
                      scg.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                      PriSpScpRtScgVO scg = new PriSpScpRtScgVO();
                      scg.setPropNo(strPropNo);
                      scg.setAmdtSeq(strAmdtSeq);
                      scg.setSvcScpCd(strSvcScpCd);
                      scg.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                  
                  PriSpScpRtVO rt = new PriSpScpRtVO();
                  rt.setPropNo(strPropNo);
                  rt.setAmdtSeq(strAmdtSeq);
                  rt.setSvcScpCd(strSvcScpCd);
                  rt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                      PriSpScpRtScgVO scg = new PriSpScpRtScgVO();
                      scg.setPropNo(strPropNo);
                      scg.setAmdtSeq(strAmdtSeq);
                      scg.setSvcScpCd(strSvcScpCd);
                      scg.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                      PriSpScpRtScgVO scg = new PriSpScpRtScgVO();
                      scg.setPropNo(strPropNo);
                      scg.setAmdtSeq(strAmdtSeq);
                      scg.setSvcScpCd(strSvcScpCd);
                      scg.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                      PriSpScpRtScgVO scg = new PriSpScpRtScgVO();
                      scg.setPropNo(strPropNo);
                      scg.setAmdtSeq(strAmdtSeq);
                      scg.setSvcScpCd(strSvcScpCd);
                      scg.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                  
                  PriSpScpRtVO rt = new PriSpScpRtVO();
                  rt.setPropNo(strPropNo);
                  rt.setAmdtSeq(strAmdtSeq);
                  rt.setSvcScpCd(strSvcScpCd);
                  rt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                      PriSpScpRtScgVO scg = new PriSpScpRtScgVO();
                      scg.setPropNo(strPropNo);
                      scg.setAmdtSeq(strAmdtSeq);
                      scg.setSvcScpCd(strSvcScpCd);
                      scg.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                      PriSpScpRtScgVO scg = new PriSpScpRtScgVO();
                      scg.setPropNo(strPropNo);
                      scg.setAmdtSeq(strAmdtSeq);
                      scg.setSvcScpCd(strSvcScpCd);
                      scg.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                      PriSpScpRtScgVO scg = new PriSpScpRtScgVO();
                      scg.setPropNo(strPropNo);
                      scg.setAmdtSeq(strAmdtSeq);
                      scg.setSvcScpCd(strSvcScpCd);
                      scg.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                  
                  PriSpScpRtVO rt = new PriSpScpRtVO();
                  rt.setPropNo(strPropNo);
                  rt.setAmdtSeq(strAmdtSeq);
                  rt.setSvcScpCd(strSvcScpCd);
                  rt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                      PriSpScpRtScgVO scg = new PriSpScpRtScgVO();
                      scg.setPropNo(strPropNo);
                      scg.setAmdtSeq(strAmdtSeq);
                      scg.setSvcScpCd(strSvcScpCd);
                      scg.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                      PriSpScpRtScgVO scg = new PriSpScpRtScgVO();
                      scg.setPropNo(strPropNo);
                      scg.setAmdtSeq(strAmdtSeq);
                      scg.setSvcScpCd(strSvcScpCd);
                      scg.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                      PriSpScpRtScgVO scg = new PriSpScpRtScgVO();
                      scg.setPropNo(strPropNo);
                      scg.setAmdtSeq(strAmdtSeq);
                      scg.setSvcScpCd(strSvcScpCd);
                      scg.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                  
                  PriSpScpRtVO rt = new PriSpScpRtVO();
                  rt.setPropNo(strPropNo);
                  rt.setAmdtSeq(strAmdtSeq);
                  rt.setSvcScpCd(strSvcScpCd);
                  rt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                      PriSpScpRtScgVO scg = new PriSpScpRtScgVO();
                      scg.setPropNo(strPropNo);
                      scg.setAmdtSeq(strAmdtSeq);
                      scg.setSvcScpCd(strSvcScpCd);
                      scg.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                      PriSpScpRtScgVO scg = new PriSpScpRtScgVO();
                      scg.setPropNo(strPropNo);
                      scg.setAmdtSeq(strAmdtSeq);
                      scg.setSvcScpCd(strSvcScpCd);
                      scg.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                      PriSpScpRtScgVO scg = new PriSpScpRtScgVO();
                      scg.setPropNo(strPropNo);
                      scg.setAmdtSeq(strAmdtSeq);
                      scg.setSvcScpCd(strSvcScpCd);
                      scg.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                  
                  PriSpScpRtVO rt = new PriSpScpRtVO();
                  rt.setPropNo(strPropNo);
                  rt.setAmdtSeq(strAmdtSeq);
                  rt.setSvcScpCd(strSvcScpCd);
                  rt.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                      PriSpScpRtScgVO scg = new PriSpScpRtScgVO();
                      scg.setPropNo(strPropNo);
                      scg.setAmdtSeq(strAmdtSeq);
                      scg.setSvcScpCd(strSvcScpCd);
                      scg.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                      PriSpScpRtScgVO scg = new PriSpScpRtScgVO();
                      scg.setPropNo(strPropNo);
                      scg.setAmdtSeq(strAmdtSeq);
                      scg.setSvcScpCd(strSvcScpCd);
                      scg.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
                      PriSpScpRtScgVO scg = new PriSpScpRtScgVO();
                      scg.setPropNo(strPropNo);
                      scg.setAmdtSeq(strAmdtSeq);
                      scg.setSvcScpCd(strSvcScpCd);
                      scg.setGenSpclRtTpCd(strGenSpclRtTpCd);
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
          if (dcallVoList.size() > 0) {
              dbDao.addRateRouteDirectCall(dcallVoList);
          }
          
          if (rtVoList.size() > 0) {
              dbDao.addRate(rtVoList);
          }
          if (scgVoList.size() > 0) {
              dbDao.addRateSurcharge(scgVoList);
          }
          
      } catch (DAOException ex) {
          log.error("err " + ex.toString(), ex);
          throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
      } catch (Exception ex) {
          log.error("err " + ex.toString(), ex);
          throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
      }
    }
    
    /**
     * Trans.Mode에 따른 Cost 상세정보를 조회 합니다.<br>
     *  
     * @param RsltPriCostDetailByTransModeListVO rsltPriCostDetailByTransModeListVO
     * @return List<RsltPriCostDetailByTransModeListVO>
     * @exception EventException
     */
    public  List<RsltPriCostDetailByTransModeListVO> searchCostDetailByTransModeList(RsltPriCostDetailByTransModeListVO rsltPriCostDetailByTransModeListVO) throws EventException {
        try {
            return dbDao.searchCostDetailByTransModeList(rsltPriCostDetailByTransModeListVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }   
    

    
    /**
     * S/C Proposal/Amendment CMPB 또는 OPB 를 조회 합니다.<br>
     *  
     * @param RsltPriRateCmpbViewAllListVO rsltPriRateCmpbViewAllListVO
     * @return List<RsltPriRateCmpbViewAllListVO>
     * @exception EventException
     */
    public  List<RsltPriRateCmpbViewAllListVO> searchRateCmpbViewAllList(RsltPriRateCmpbViewAllListVO rsltPriRateCmpbViewAllListVO) throws EventException {
        try {
            return dbDao.searchRateCmpbViewAllList(rsltPriRateCmpbViewAllListVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }
    
    /**
     * ScrateProposal View All Rate를 페이징 조회한다.<br>
     * 
     * @param ViewAllRatesListPagingVO viewAllRatesListPagingVO
     * @return DBRowSet
     * @exception EventException
     */
    public DBRowSet searchViewAllRatesListPaging(ViewAllRatesListPagingVO viewAllRatesListPagingVO) throws EventException {
        DBRowSet rowSet = null;
        int totalCnt = 0;
        int pageNo   = 1;
        int startRow = 0;
        int endRow   = 0;
        int pageRows = Constants.PAGE_SIZE_100;
        
        try {
            
            totalCnt = dbDao.searchViewAllRatesListTotalCnt(viewAllRatesListPagingVO);
            
            pageNo   = Integer.parseInt(JSPUtil.getNull(viewAllRatesListPagingVO.getPageNo(), ""+pageNo));
            pageRows = Integer.parseInt(JSPUtil.getNull(viewAllRatesListPagingVO.getPagerows(), ""+pageRows));
            
            startRow = pageRows * (pageNo - 1) + 1;
            endRow   = pageRows * pageNo;

            viewAllRatesListPagingVO.setStartRow(""+startRow);
            viewAllRatesListPagingVO.setEndRow(""+endRow);
            
            rowSet = dbDao.searchViewAllRatesListPaging(viewAllRatesListPagingVO);
            
            rowSet.setMaxRows(totalCnt);
            
            return rowSet;
            
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }
    
    /**
     * ScrateProposal View All Rate 조회한다.<br>
     * 
     * @param ViewAllRatesListVO viewAllRatesListVO
     * @return List<ViewAllRatesListVO>
     * @exception EventException
     */
    public List<ViewAllRatesListVO> searchViewAllRatesList(ViewAllRatesListVO viewAllRatesListVO) throws EventException {
        try {
            return dbDao.searchViewAllRatesList(viewAllRatesListVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }
    
    /**
     * RATE관련 Cost, CMPB,OPB 값을 갱신하고 그 갱신여부를 Mark해둔다..<BR>
     * 
     * @param RsltPriPrsCostListVO[] rsltPriPrsCostListVOS
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyPrsCost(RsltPriPrsCostListVO[] rsltPriPrsCostListVOS, SignOnUserAccount account)
            throws EventException {
        try {
            List<RsltPriPrsCostListVO> rateUpdateVoList = new ArrayList<RsltPriPrsCostListVO>();
            List<RsltPriPrsCostListVO> routCsUpdateVoList = new ArrayList<RsltPriPrsCostListVO>();

            for (int i = 0; i < rsltPriPrsCostListVOS.length; i++) {
                if (rsltPriPrsCostListVOS[i].getIbflag().equals("U")) {     
                    rsltPriPrsCostListVOS[i].setUpdUsrId(account.getUpd_usr_id());
                    if( "Y".equals(rsltPriPrsCostListVOS[i].getUsdRoutCsSelFlg() ) || "1".equals(rsltPriPrsCostListVOS[i].getUsdRoutCsSelFlg() ) ){
                        rateUpdateVoList.add(rsltPriPrsCostListVOS[i]);
                        rsltPriPrsCostListVOS[i].setUsdRoutCsSelFlg("Y");
                    }else{
                        rsltPriPrsCostListVOS[i].setUsdRoutCsSelFlg("N");
                    }
                    routCsUpdateVoList.add(rsltPriPrsCostListVOS[i]);
                }
            }
            
            if (routCsUpdateVoList.size() > 0) {
                this.modifyPrsRateCommodityRoute(routCsUpdateVoList);
            }
            if (rateUpdateVoList.size() > 0) {
                this.modifyCalculateLogicData( rateUpdateVoList);
            }           
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }   
    /**
     * Route의 선택여부를 Mark해둔다..<BR>
     * 
     * @param List<RsltPriPrsCostListVO> rsltPriPrsCostListVO
     * @exception EventException
     */
    public void modifyPrsRateCommodityRoute(List<RsltPriPrsCostListVO>  rsltPriPrsCostListVO) throws EventException{
        try {
            dbDao.modifyPrsRateCommodityRoute(rsltPriPrsCostListVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    
    /**
     * Calculate Logic을 이용해 data를 갱신한다..<BR>
     * 
     * @param List<RsltPriPrsCostListVO> rsltPriPrsCostListVO
     * @exception EventException
     */
    public void modifyCalculateLogicData(List<RsltPriPrsCostListVO>  rsltPriPrsCostListVO) throws EventException{
        try {
            dbDao.modifyRate(rsltPriPrsCostListVO);
            //SCProposalCalculate Logic시작
            dbDao.removePriSpScpRtScgRoutCostDetail(rsltPriPrsCostListVO.get(0));   //deletePRI_SP_SCP_RT_SCG_ROUT
            dbDao.addPriSpScpRtScgRoutCostDetail(rsltPriPrsCostListVO.get(0));      //insertPRI_SP_SCP_RT_SCG_ROUT
            dbDao.removePriSpScpRtScgCostDetail(rsltPriPrsCostListVO.get(0));       //deletePRI_SP_SCP_RT_SCG
            rsltPriPrsCostListVO.get(0).setIsOnlineCall("Y");   // online call
            this.addPriSpScpRtScgCostDetail(rsltPriPrsCostListVO.get(0));           //insert_PRI_SP_SCP_RT_SCG
            dbDao.addPriSpScpRtScgAmtCostDetail(rsltPriPrsCostListVO.get(0),"2");       //mergePRI_SP_SCP_RT_SCG
            dbDao.modifyPriSpScpRtSurchargeCostDetail(rsltPriPrsCostListVO.get(0)); //updateSURCHARGE_PRI_SP_SCP_RT
            dbDao.modifyPriSpScpRtCMPBCostDetail(rsltPriPrsCostListVO.get(0));      //updatePRI_SP_SCP_RT_CMPB
            dbDao.modifyPriSpScpRtSvcLaneCostDetail(rsltPriPrsCostListVO.get(0));   //updatePRI_SP_SCP_RT_SVC_LANE
            dbDao.modifyPriSpScpRtGlineMappingCostDetail(rsltPriPrsCostListVO.get(0));//updateGLINE_MAPPING
            dbDao.modifyPriSpScpRtCmdtRoutEstmCostDetail(rsltPriPrsCostListVO.get(0));//updatePRI_SP_SCP_RT_CMDT_ROUT_ESTM
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    /**
     * Calculate Logic 중 Surcharge 재 계산 부분만을 분리 해 놓았다. <BR>
     * 왜냐하면 Batch Program에서도 이 부분을 공유 하기 때문이다.
     * 
     * @param RsltPriPrsCostListVO rsltPriPrsCostListVO
     * @exception EventException
     */
    public void addPriSpScpRtScgCostDetail(RsltPriPrsCostListVO  rsltPriPrsCostListVO) throws EventException{
        try {

            dbDao.addPriSpScpRtScgCostDetail(rsltPriPrsCostListVO);         //insert_PRI_SP_SCP_RT_SCG
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
     
        

    
    /**
     * Calculate Batch를 비동기 적으로 실행킨다.<br>
     * 
     * @param PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO
     * @param String rotationPrsBatId
     * @param SignOnUserAccount account
     * @return PriPrsBatVO
     * @exception EventException
     */
    public PriPrsBatVO executeCalculate(PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO, String rotationPrsBatId,SignOnUserAccount account) throws EventException {
        try {
            //컨테이너 vo
//          RateQuotationVO rateQuotationVO = new RateQuotationVO();
            ScheduleUtil schedule = new ScheduleUtil();
            PriSpCtrtPtyVO priSpCtrtPtyVO = new PriSpCtrtPtyVO();
            PriPrsBatVO priPrsBatVO = null;
            List<PriSpCtrtPtyVO> priSpCtrtPtyVOList;
            String params = "";
            String jobID = "";
            String pgmNm = "";
            
 
            
            priSpCtrtPtyVO.setPropNo(priSpScpRtCmdtRoutVO.getPropNo() );
            priSpCtrtPtyVO.setAmdtSeq(priSpScpRtCmdtRoutVO.getAmdtSeq());
            
            priSpCtrtPtyVOList = dbDao.searchPriSpScpMn(priSpCtrtPtyVO);
            if( priSpCtrtPtyVOList.size() != 0){
            
                params = priSpScpRtCmdtRoutVO.getPropNo() 
                        + "#" + priSpScpRtCmdtRoutVO.getAmdtSeq()
                        + "#" + priSpScpRtCmdtRoutVO.getSvcScpCd()
                        + "#" + priSpScpRtCmdtRoutVO.getGenSpclRtTpCd()
                        + "#" + priSpCtrtPtyVOList.get(0).getCustCntCd()
                        + "#" + priSpCtrtPtyVOList.get(0).getCustSeq()
                        + "#" + account.getUsr_id();
                        
                /********************************************************************/
                 
                if ( rotationPrsBatId.length() == 1 ) {
                    pgmNm = "0"+rotationPrsBatId;
                }else{
                    pgmNm = rotationPrsBatId;
                }
                pgmNm = "ESM_PRI_B007-"+pgmNm;
                log.debug("== pgmNm == "+pgmNm);
                if(!schedule.isRunning(pgmNm)){
                    jobID = schedule.directExecuteJob(pgmNm, params);   
                    
                    priPrsBatVO = new PriPrsBatVO();
                    priPrsBatVO.setPrsBatId(jobID);
                    priPrsBatVO.setParaInfoCtnt(params);
                    priPrsBatVO.setPgmNo(pgmNm);
                }else{
                    throw new EventException(new ErrorHandler("PRI03027", new String[]{}).getMessage());
                }
                log.debug("== jobID == "+jobID);
                /********************************************************************/
                
//              jobID = schedule.directExecuteJob("ESM_PRI_B007", params);
//              
//              priPrsBatVO = new PriPrsBatVO();
//              priPrsBatVO.setPrsBatId(jobID);
//              priPrsBatVO.setParaInfoCtnt(params);
//              priPrsBatVO.setPgmNo("ESM_PRI_B007");
                
            }
            return priPrsBatVO;
            
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
        
    }

    /**
     * Calculate Batch ID를 조회 하기 위한 Parameter를 조합한다.<br>
     * 
     * @param PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO
     * @return PriPrsBatVO
     * @exception EventException
     */
    public PriPrsBatVO searchMonitorCalculateParam(PriSpScpRtCmdtRoutVO priSpScpRtCmdtRoutVO) throws EventException {
        try {
            PriSpCtrtPtyVO priSpCtrtPtyVO = new PriSpCtrtPtyVO();
            PriPrsBatVO priPrsBatVO = null;
            List<PriSpCtrtPtyVO> priSpCtrtPtyVOList;
            String params = "";
            
            //조회불가 메시지
            if( priSpScpRtCmdtRoutVO.getPropNo() == null || priSpScpRtCmdtRoutVO.getAmdtSeq() == null){
                throw new EventException(new ErrorHandler("PRI02014").getMessage());
            }
            priSpCtrtPtyVO.setPropNo(priSpScpRtCmdtRoutVO.getPropNo() );
            priSpCtrtPtyVO.setAmdtSeq(priSpScpRtCmdtRoutVO.getAmdtSeq() );
            
            priSpCtrtPtyVOList = dbDao.searchPriSpScpMn(priSpCtrtPtyVO);
            if( priSpCtrtPtyVOList.size() != 0){
                params = priSpScpRtCmdtRoutVO.getPropNo() 
                        + "#" + priSpScpRtCmdtRoutVO.getAmdtSeq()
                        + "#" + priSpScpRtCmdtRoutVO.getSvcScpCd()
                        + "#" + priSpScpRtCmdtRoutVO.getGenSpclRtTpCd()
                        + "#" + priSpCtrtPtyVOList.get(0).getCustCntCd()
                        + "#" + priSpCtrtPtyVOList.get(0).getCustSeq()  
                        + "#" ; //USER ID정보는  parameter 정보에서 빼고 like 검색으로 batch id를 검색한다.

                priPrsBatVO = new PriPrsBatVO();
                priPrsBatVO.setParaInfoCtnt(params);
                priPrsBatVO.setPgmNo("ESM_PRI_B007");
                
            }else{ //조회 불가 메시지
                throw new EventException(new ErrorHandler("PRI02014").getMessage());
            }
            return priPrsBatVO;
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
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
            if( prsBatchVO != null ){
                status = su.getJobStatus(prsBatchVO.getPrsBatId(),prsBatchVO.getPgmNo());
                if( status == 0 ){
                    float min = Float.valueOf(prsBatchVO.getExecMinutes());
                    if( Float.compare(min,10.0f) > 0 ){  // Batch 서버가 해당 Calc를 돌려주지 못했다고 판단한다. Code 99
                        status = 99;
                    }else{
                        // 기존에 nothing으로 표현 하던 내용으로 pri_prs_bat에는 데이터가 있으나 batch에서 null을 return할때는 Running...으로 표현한다.
                        status = 80;
                    }
                    log.debug(" =================  status === "+status);
                }
            }
             
            return String.valueOf(status);
        //} catch (DAOException ex) {
        //    throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
        
    }
    
    
    /**
     * Quotation 에서 proposal로 데이터를 copy한다.<br>
     * COPY TO PROPOSAL - 대상테이블 : PRI_SP_SCP_RT_CMDT_HDR,PRI_SP_SCP_RT_CMDT,PRI_SP_SCP_RT_CMDT_ROUT,PRI_SP_SCP_RT_ROUT_DIR,<br>
     * 								PRI_SP_SCP_RT_ROUT_PNT,PRI_SP_SCP_RT_ROUT_VIA,PRI_SP_SCP_RT
     * 
     * @param RsltCopyToProposalVO rsltCopyToProposalVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyToProposalRate(RsltCopyToProposalVO rsltCopyToProposalVO, SignOnUserAccount account) 
        throws EventException{
        try {
            rsltCopyToProposalVO.setCreUsrId(account.getUsr_id());
            rsltCopyToProposalVO.setUpdUsrId(account.getUsr_id());
            //office
            rsltCopyToProposalVO.setQttnOfcCd(account.getOfc_cd());
            
            //PRI_SP_SCP_RT_CMDT_HDR
            dbDao.addCopyToProposalSpScpRtCmdtHdr(rsltCopyToProposalVO);
            //PRI_SP_SCP_RT_CMDT
            dbDao.addCopyToProposalSpScpRtCmdt(rsltCopyToProposalVO);
            //PRI_SP_SCP_RT_CMDT_ROUT
            dbDao.addCopyToProposalSpScpRtCmdtRout(rsltCopyToProposalVO);
            //PRI_SP_SCP_RT_ROUT_DIR
            dbDao.addCopyToProposalSpScpRtRoutDir(rsltCopyToProposalVO);
            //PRI_SP_SCP_RT_ROUT_PNT
            dbDao.addCopyToProposalSpScpRtRoutPnt(rsltCopyToProposalVO);
            //PRI_SP_SCP_RT_ROUT_VIA
            dbDao.addCopyToProposalSpScpRtRoutVia(rsltCopyToProposalVO);
            //PRI_SP_SCP_RT
            dbDao.addCopyToProposalSpScpRt(rsltCopyToProposalVO);
            
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
        }
    }
    
    
    /**
     * Route Case No 의 Max +1 값을 조회한다..<br>
     * 
     * @param RsltRouteCaseCostVersionVO rsltRouteCaseCostVersionVO
     * @return RsltNewRoutCaseNoVO
     * @exception EventException
     */
//  public RsltNewRoutCaseNoVO searchNewRouteCaseNo( RsltRouteCaseCostVersionVO rsltRouteCaseCostVersionVO ) throws EventException {
//      try {
//          RsltNewRoutCaseNoVO rsltNewRoutCaseNoVO = null;
//          List<RsltNewRoutCaseNoVO> list =  dbDao.searchNewRouteCaseNo(rsltRouteCaseCostVersionVO);
//          if( list.size() !=0){
//              rsltNewRoutCaseNoVO = list.get(0);
//          }
//          return rsltNewRoutCaseNoVO;
//      } catch (DAOException ex) {
//          throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
//        } catch (Exception ex) {
//            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
//      }
//  }       
    
    
    /**
     * Rate Route Case를 추가 한다. .<br>
     * 
     * @param PriSpScpRtUsdRoutCsVO priSpScpRtUsdRoutCsVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void managePriRateUsedRouteCase(PriSpScpRtUsdRoutCsVO priSpScpRtUsdRoutCsVO, SignOnUserAccount account) throws EventException{   
        try {
            List<PriSpScpRtUsdRoutCsVO> priSpScpRtUsdRoutCsVOs = new ArrayList<PriSpScpRtUsdRoutCsVO>();
            if (priSpScpRtUsdRoutCsVO != null) {
                priSpScpRtUsdRoutCsVO.setUpdUsrId(account.getUsr_id());
                priSpScpRtUsdRoutCsVO.setUsdRoutCsSelFlg("Y");
                priSpScpRtUsdRoutCsVOs.add(priSpScpRtUsdRoutCsVO);
            }
            dbDao.addPriRateUsedRouteCase(priSpScpRtUsdRoutCsVOs);
        } catch (DAOException ex) {
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
    }
    
    

    
 
    

    
    /**
     * 현재 사용해야 할 PARA_INFO_CTNT(ROUT_CS_SRC_DT)  , PRS_BAT_ID(ROUT_CS_CLSS_NO)를 SELECT한다.<br>
     * 
     * @return RsltRouteCaseCostVersionVO
     * @exception EventException
     */
    public RsltRouteCaseCostVersionVO searchRouteCaseCostVersion( ) throws EventException {
        try {
            RsltRouteCaseCostVersionVO rsltRouteCaseCostVersionVO = null;
            List<RsltRouteCaseCostVersionVO> list =  dbDao.searchRouteCaseCostVersion();
            if( list.size() !=0){
                rsltRouteCaseCostVersionVO = list.get(0);
            }
            return rsltRouteCaseCostVersionVO;
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }       
    
    

    /**
     * COST CM/OP PRE SIMULATION 화면에서 ROUTE정보를 조회 한다.<br>
     * 
     * @param InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO
     * @return List<RsltPriCostSimulationCheckRouteVO>
     * @exception EventException
     */
    public List<RsltPriCostSimulationCheckRouteVO> searchCostSimulationCheckRoutList(
            InCostSimulationCheckRouteVO inCostSimulationCheckRouteVO) throws EventException {
        try {
            List<RsltPriCostSimulationCheckRouteVO> rsltPriCostSimulationCheckRouteVOs = dbDao.searchCostSimulationCheckRoutList(inCostSimulationCheckRouteVO);
             
            return rsltPriCostSimulationCheckRouteVOs;
            
            
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }
    
    /**
     * Conversion Update 시 Amend Seq.를 기준으로 다음 Amend Seq의 Note 유형을 수정한다.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account 
     * @exception EventException
     */
    public void manageConversionUpdate (PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
        try {
            priSpMnVO.setUpdUsrId(account.getUsr_id());

            dbDao.modifyConversionCNote(priSpMnVO);
            dbDao.modifyConversionRNote(priSpMnVO);
            
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }       
        
    
    
    
    /**
     * S/C Proposal - Rate Tab의 Surcharge View All Popup의 내용을 조회를 처리합니다.<br>
     * 
     * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
     * @return List<RsltPriSurchargeViewAllVO>
     * @exception EventException
     */
    public List<RsltPriSurchargeViewAllVO> searchSurchargeViewAllList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws EventException {
        try {
            return dbDao.searchSurchargeViewAllList(priSpScpRtCmdtHdrVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }    
    
    
    /**
     * S/C Proposal - Rate Tab의 Surcharge View All Popup에서 Surcharge 값이 언제 만들어 졌는지를 조회 처리합니다.<br>
     * 
     * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
     * @return List<RsltPriSurchargeLastAccessDateVO>
     * @exception EventException
     */
    public List<RsltPriSurchargeLastAccessDateVO> searchSurchargeLastAccessDateList(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) throws EventException {
        try {
            return dbDao.searchSurchargeLastAccessDateList(priSpScpRtCmdtHdrVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }    
    
    /**
     *  Surcharge 정보를 삭제 합니다.<br>
     * 
     * @param ScPropMnVO scPropMnVO
     * @exception EventException
     */
    public void manageProposalScopeSurchargeRemove(ScPropMnVO scPropMnVO) throws EventException {
        try {
            PriSpScpMnVO[] scpVo = scPropMnVO.getPriSpScpMnVOs();       

            for ( int i = 0; scpVo != null && i < scpVo.length; i++ ) {
                if ( scpVo[i].getIbflag().equals("D")){
                    dbDao.removeSurchargeAdjustInitCancel(scpVo[i]);
                }
            }
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }   
    
    
}