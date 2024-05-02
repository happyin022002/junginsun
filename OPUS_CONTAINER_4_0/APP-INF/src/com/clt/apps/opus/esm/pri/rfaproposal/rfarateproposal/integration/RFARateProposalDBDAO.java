/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFARateProposalDBDAO.java
 *@FileTitle : RFARateProposalDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.19
 *@LastModifier : 박성수
 *@LastVersion : 1.0
 * 2009.08.19 박성수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.integration.RFANoteConversionProposalDBDAOPriRfaNoteConvCopyVOCSQL;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.integration.RFANoteConversionProposalDBDAOPriRfaNoteConvCopyVODSQL;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.integration.RFANoteConversionProposalDBDAOPriRfaNoteConvCopyVORSQL;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.integration.RFANoteConversionProposalDBDAOPriRfaNoteConvSeqVODSQL;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.integration.RFANoteConversionProposalDBDAOPriRfaNoteConvVOCSQL;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.integration.RFANoteConversionProposalDBDAOPriRfaNoteConvVORSQL;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.integration.RFANoteConversionProposalDBDAOPriRfaNoteConvVOUSQL;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.vo.PriRfaNoteConvCommVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.vo.PriRfaNoteConvListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.vo.RsltNoteConvVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.basic.RFARateProposalBCImpl;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RfaGlineCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltActCustListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltAllRtListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltCnoteNoteConvListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriRpScpRtCgoSpecVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRnoteNoteConvListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCheckDuplicateVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCmdtDtlListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCmdtHdrListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCmdtRnoteListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCnoteListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtDtlListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListHorizontalExcelVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListVerticalExcelVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtRoutDestPntListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtRoutDestViaListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtRoutHdrListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtRoutOrgPntListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtRoutOrgViaListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration.SCRateProposalDBDAOPriSpScpRtCmdtRnoteVOXlsUSQL;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.PriRfaNoteConvVO;
import com.clt.syscommon.common.table.PriRpMnVO;
import com.clt.syscommon.common.table.PriRpScpGriGrpVO;
import com.clt.syscommon.common.table.PriRpScpMnVO;
import com.clt.syscommon.common.table.PriRpScpRtActCustVO;
import com.clt.syscommon.common.table.PriRpScpRtCgoSpecVO;
import com.clt.syscommon.common.table.PriRpScpRtCmdtHdrVO;
import com.clt.syscommon.common.table.PriRpScpRtCmdtRnoteVO;
import com.clt.syscommon.common.table.PriRpScpRtCmdtRoutVO;
import com.clt.syscommon.common.table.PriRpScpRtCmdtVO;
import com.clt.syscommon.common.table.PriRpScpRtCnoteVO;
import com.clt.syscommon.common.table.PriRpScpRtRoutPntVO;
import com.clt.syscommon.common.table.PriRpScpRtRoutViaVO;
import com.clt.syscommon.common.table.PriRpScpRtVO;
import com.clt.syscommon.common.table.PriSpScpRtCmdtRoutVO;


/**
 * RFARateProposalDBDAO <br>
 * - RFAProposal system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Sungsoo, Park
 * @see RFARateProposalBCImpl 참조
 * @since J2EE 1.4
 */
public class RFARateProposalDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

///////////////////////////// 박성수 수정 시작 ///////////////////////////////////////

	/**
     * Rate CMDT Header의 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
     * @return List<RsltRtCmdtHdrListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtCmdtHdrListVO> searchRateCommodityHeaderList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtCmdtHdrListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtCmdtHdrVO != null) {
                Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new RFARateProposalDBDAORsltRtCmdtHdrListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCmdtHdrListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Rate Guideline CMDT Header의 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
     * @return List<RsltRtCmdtHdrListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtCmdtHdrListVO> searchRateCommodityHeaderInquiryList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtCmdtHdrListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtCmdtHdrVO != null) {
                Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new RFARateProposalDBDAORsltRtCmdtHdrInquiryListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCmdtHdrListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Rate Guideline CMDT Header의 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
     * @return List<RsltRtCmdtHdrListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtCmdtHdrListVO> searchRateCommodityHeaderHistoryList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtCmdtHdrListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtCmdtHdrVO != null) {
                Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new RFARateProposalDBDAORsltRtCmdtHdrHistoryListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCmdtHdrListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * CUD트랜잭션 처리 후, 화면표시를 위한 스타일정보 조회<br>
     *
     * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
     * @return List<RsltRtCmdtHdrListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtCmdtHdrListVO> searchRateCommodityHeaderStyleList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtCmdtHdrListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtCmdtHdrVO != null) {
                Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);

                velParam.put("IS_STYLE", "Y");
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new RFARateProposalDBDAORsltRtCmdtHdrListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCmdtHdrListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Rate CMDT Detail의 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
     * @return List<RsltRtCmdtDtlListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtCmdtDtlListVO> searchRateCommodityDetailList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtCmdtDtlListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtCmdtHdrVO != null) {
                Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new RFARateProposalDBDAORsltRtCmdtDtlListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCmdtDtlListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Rate Guideline CMDT Detail의 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
     * @return List<RsltRtCmdtDtlListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtCmdtDtlListVO> searchRateCommodityDetailInquiryList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtCmdtDtlListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtCmdtHdrVO != null) {
                Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new RFARateProposalDBDAORsltRtCmdtDtlInquiryListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCmdtDtlListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Rate Actual Customer의 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
     * @return List<RsltActCustListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltActCustListVO> searchActualCustomerList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltActCustListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtCmdtHdrVO != null) {
                Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltActCustListVORSQL(),
                    param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltActCustListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Rate Guideline CMDT Detail의 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
     * @return List<RsltActCustListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltActCustListVO> searchActualCustomerInquiryList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltActCustListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtCmdtHdrVO != null) {
                Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltActCustInquiryListVORSQL(),
                    param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltActCustListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Rate Commodity Note 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
     * @return List<RsltRtCnoteListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtCnoteListVO> searchRateCnoteList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtCnoteListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtCmdtHdrVO != null) {
                Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtCnoteListVORSQL(),
                    param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCnoteListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Rate Guideline CMDT Detail의 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
     * @return List<RsltRtCnoteListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtCnoteListVO> searchRateCnoteInquiryList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtCnoteListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtCmdtHdrVO != null) {
                Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtCnoteInquiryListVORSQL(),
                    param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCnoteListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Rate Commodity Note Conversion 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
     * @return List<RsltCnoteNoteConvListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltCnoteNoteConvListVO> searchRateCnoteNoteConvList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltCnoteNoteConvListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtCmdtHdrVO != null) {
                Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltCnoteNoteConvListRSQL(),
                    param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCnoteNoteConvListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Guideline MQC의 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
     * @return List<RsltRtRoutHdrListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtRoutHdrListVO> searchRateRouteList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtRoutHdrListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtCmdtRoutVO != null) {
                Map<String, String> mapVO = priRpScpRtCmdtRoutVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new RFARateProposalDBDAORsltRtRoutHdrListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutHdrListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Rate Inquiry - Route 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
     * @return List<RsltRtRoutHdrListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtRoutHdrListVO> searchRateRouteInquiryList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtRoutHdrListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtCmdtRoutVO != null) {
                Map<String, String> mapVO = priRpScpRtCmdtRoutVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new RFARateProposalDBDAORsltRtRoutHdrInquiryListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutHdrListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Rate History - Route 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
     * @return List<RsltRtRoutHdrListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtRoutHdrListVO> searchRateRouteHistoryList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtRoutHdrListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtCmdtRoutVO != null) {
                Map<String, String> mapVO = priRpScpRtCmdtRoutVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new RFARateProposalDBDAORsltRtRoutHdrHistoryListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutHdrListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * CUD트랜잭션 처리 후, 화면표시를 위한 스타일정보 조회<br>
     *
     * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
     * @return List<RsltRtRoutHdrListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtRoutHdrListVO> searchRateRouteStyleList(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtRoutHdrListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtCmdtRoutVO != null) {
                Map<String, String> mapVO = priRpScpRtCmdtRoutVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);

                velParam.put("IS_STYLE", "Y");
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new RFARateProposalDBDAORsltRtRoutHdrListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutHdrListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Rate 정보를 조회한다.<br>
     *
     * @param PriRpScpRtVO priRpScpRtVO
     * @return List<RsltRtDtlListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtDtlListVO> searchRateDetailList(PriRpScpRtVO priRpScpRtVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtDtlListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtVO != null) {
                Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtDtlListVORSQL(),
                    param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtDtlListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Rate Inquiry - Rate 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtVO priRpScpRtVO
     * @return List<RsltRtDtlListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtDtlListVO> searchRateDetailInquiryList(PriRpScpRtVO priRpScpRtVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtDtlListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtVO != null) {
                Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtDtlInquiryListVORSQL(),
                    param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtDtlListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Origin Point 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtVO priRpScpRtVO
     * @return List<RsltRtRoutOrgPntListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtRoutOrgPntListVO> searchRateRouteOriginPointList(PriRpScpRtVO priRpScpRtVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtRoutOrgPntListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtVO != null) {
                Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new RFARateProposalDBDAORsltRtRoutOrgPntListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutOrgPntListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Rate Inquiry - Origin Point 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtVO priRpScpRtVO
     * @return List<RsltRtRoutOrgPntListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtRoutOrgPntListVO> searchRateRouteOriginPointInquiryList(PriRpScpRtVO priRpScpRtVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtRoutOrgPntListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtVO != null) {
                Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new RFARateProposalDBDAORsltRtRoutOrgPntInquiryListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutOrgPntListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Origin Via. 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtVO priRpScpRtVO
     * @return List<RsltRtRoutOrgViaListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtRoutOrgViaListVO> searchRateRouteOriginViaList(PriRpScpRtVO priRpScpRtVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtRoutOrgViaListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtVO != null) {
                Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new RFARateProposalDBDAORsltRtRoutOrgViaListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutOrgViaListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Rate Inquiry - Origin Via. 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtVO priRpScpRtVO
     * @return List<RsltRtRoutOrgViaListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtRoutOrgViaListVO> searchRateRouteOriginViaInquiryList(PriRpScpRtVO priRpScpRtVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtRoutOrgViaListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtVO != null) {
                Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new RFARateProposalDBDAORsltRtRoutOrgViaInquiryListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutOrgViaListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Destination Via. 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtVO priRpScpRtVO
     * @return List<RsltRtRoutDestViaListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtRoutDestViaListVO> searchRateRouteDestinationViaList(PriRpScpRtVO priRpScpRtVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtRoutDestViaListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtVO != null) {
                Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new RFARateProposalDBDAORsltRtRoutDestViaListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutDestViaListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Rate Inquiry - Destination Via. 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtVO priRpScpRtVO
     * @return List<RsltRtRoutDestViaListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtRoutDestViaListVO> searchRateRouteDestinationViaInquiryList(PriRpScpRtVO priRpScpRtVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtRoutDestViaListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtVO != null) {
                Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new RFARateProposalDBDAORsltRtRoutDestViaInquiryListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutDestViaListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Destination Point 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtVO priRpScpRtVO
     * @return List<RsltRtRoutDestPntListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtRoutDestPntListVO> searchRateRouteDestinationPointList(PriRpScpRtVO priRpScpRtVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtRoutDestPntListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtVO != null) {
                Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new RFARateProposalDBDAORsltRtRoutDestPntListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutDestPntListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Rate Inquiry - Destination Point 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtVO priRpScpRtVO
     * @return List<RsltRtRoutDestPntListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtRoutDestPntListVO> searchRateRouteDestinationPointInquiryList(PriRpScpRtVO priRpScpRtVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtRoutDestPntListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtVO != null) {
                Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new RFARateProposalDBDAORsltRtRoutDestPntInquiryListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtRoutDestPntListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Route Note 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtVO priRpScpRtVO
     * @return List<RsltRtCmdtRnoteListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtCmdtRnoteListVO> searchRateCommodityRnoteList(PriRpScpRtVO priRpScpRtVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtCmdtRnoteListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtVO != null) {
                Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new RFARateProposalDBDAORsltRtCmdtRnoteListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCmdtRnoteListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Rate Inquiry - Route Note 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtVO priRpScpRtVO
     * @return List<RsltRtCmdtRnoteListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtCmdtRnoteListVO> searchRateCommodityRnoteInquiryList(PriRpScpRtVO priRpScpRtVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtCmdtRnoteListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtVO != null) {
                Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new RFARateProposalDBDAORsltRtCmdtRnoteInquiryListVORSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCmdtRnoteListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Route Note Conversion 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtVO priRpScpRtVO
     * @return List<RsltRnoteNoteConvListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRnoteNoteConvListVO> searchRateCommodityRnoteNoteConvList(PriRpScpRtVO priRpScpRtVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRnoteNoteConvListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtVO != null) {
                Map<String, String> mapVO = priRpScpRtVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new RFARateProposalDBDAORsltRnoteNoteConvListRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRnoteNoteConvListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Rate Excel Download 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
     * @return List<RsltRtListVerticalExcelVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtListVerticalExcelVO> searchRateListVerticalExcel(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtListVerticalExcelVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtCmdtHdrVO != null) {
                Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtListVerticalExcelVORSQL(),
                    param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtListVerticalExcelVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Rate Excel Download 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
     * @return List<RsltRtListHorizontalExcelVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtListHorizontalExcelVO> searchRateListHorizontalExcel(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtListHorizontalExcelVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtCmdtHdrVO != null) {
                Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtListHorizontalExcelVORSQL(),
                    param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtListHorizontalExcelVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Check Duplicate화면 리스트를 조회합니다. <br>
     * 데이터 내역 중 중복된 데이터 내역을 조회하여 화면에 반환합니다.
     *
     * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
     * @return List<RsltRtCheckDuplicateVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtCheckDuplicateVO> searchRateCheckDuplicate(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtCheckDuplicateVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtCmdtHdrVO != null) {
                Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtCheckDuplicateRSQL(),
                    param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCheckDuplicateVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Accept All 리스트를 조회한다.<br>
     *
     * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
     * @return List<RsltAllRtListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltAllRtListVO> searchAllRateList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltAllRtListVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtCmdtHdrVO != null) {
                Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltAllRtListVORSQL(),
                    param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltAllRtListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * Max Bullet No. 구하기<br>
     *
     * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
     * @return String
     * @exception DAOException
     */
    public String searchMaxBulletDispSeq(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        String cnt = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtCmdtHdrVO != null) {
                Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOGetMaxBletDpSeqRSQL(),
                    param, velParam);
            if (dbRowset != null && dbRowset.next()) {
                cnt = dbRowset.getString("max_blet_dp_seq");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return cnt;
    }

    /**
     * Max Bullet No. 구하기<br>
     *
     * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
     * @return String
     * @exception DAOException
     */
    public String searchMaxOldBulletDispSeq(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
        DBRowSet dbRowset = null;
        String cnt = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtCmdtHdrVO != null) {
                Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);

                velParam.put("IS_OLD", "Y");
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOGetMaxBletDpSeqRSQL(),
                    param, velParam);
            if (dbRowset != null && dbRowset.next()) {
                cnt = dbRowset.getString("max_blet_dp_seq");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return cnt;
    }

    /**
     * Max Bullet No. 구하기<br>
     *
     * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
     * @return String
     * @exception DAOException
     */
    public String searchMaxNoteDispSeq(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO) throws DAOException {
        DBRowSet dbRowset = null;
        String cnt = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpRtCmdtRoutVO != null) {
                Map<String, String> mapVO = priRpScpRtCmdtRoutVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOGetMaxNoteDpSeqRSQL(),
                    param, velParam);
            if (dbRowset != null && dbRowset.next()) {
                cnt = dbRowset.getString("max_note_dp_seq");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return cnt;
    }

    /**
     * Rate 데이터를 생성한다.<br>
     *
     * @param List<PriRpScpRtVO> insModels
     * @exception DAOException
     */
    public void addRate(List<PriRpScpRtVO> insModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if (insModels.size() > 0) {
                insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtVOCSQL(), insModels, null);
                for (int i = 0; i < insCnt.length; i++) {
                    if (insCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 다건의 데이터를 일괄적으로 생성한다.<br>
     *
     * @param RfaGlineCopyVO rfaGlineCopyVO
     * @return int
     * @exception DAOException
     */
    public int addRateGlineCopy(RfaGlineCopyVO rfaGlineCopyVO) throws DAOException {
        try {
            Map<String, Object> param = new HashMap<String, Object>();
            Map<String, Object> velParam = new HashMap<String, Object>();

            Map<String, String> mapVO = rfaGlineCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtGlineCpVOCSQL(), param,
                    velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }

            return result;
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Rate 데이터를 갱신한다.<br>
     *
     * @param List<PriRpScpRtVO> updModels
     * @param String isAccept
     * @exception DAOException
     */
    public void modifyRate(List<PriRpScpRtVO> updModels, String isAccept) throws DAOException {
        Map<String, Object> velParam = new HashMap<String, Object>();
        velParam.put("IS_ACCEPT", isAccept);

        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;
            if (updModels.size() > 0) {
                updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtVOUSQL(), updModels,
                        velParam);
                for (int i = 0; i < updCnt.length; i++) {
                    if (updCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Rate 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtVO> delModels
     * @exception DAOException
     */
    public void removeRate(List<PriRpScpRtVO> delModels) throws DAOException {
        try {
            HashMap<String, Object> velParam = new HashMap<String, Object>();
            velParam.put("CASCADE_LEVEL", "3");

            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtVODSQL(), delModels,
                        velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    

    /**
     * Rate 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtVO> delModels
     * @exception DAOException
     */
    public void removeRateCascadeCgoSpec(List<PriRpScpRtVO> delModels) throws DAOException {
        try {
            HashMap<String, Object> velParam = new HashMap<String, Object>();
            velParam.put("CASCADE_LEVEL", "3");

            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCgoSpecVODSQL(), delModels,
                        velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Actual Customer 데이터를 생성한다.<br>
     *
     * @param List<PriRpScpRtActCustVO> insModels
     * @exception DAOException
     */
    public void addRateActualCustomer(List<PriRpScpRtActCustVO> insModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if (insModels.size() > 0) {
                insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtActCustVOCSQL(),
                        insModels, null);
                for (int i = 0; i < insCnt.length; i++) {
                    if (insCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Actual Customer 데이터를 갱신한다.<br>
     *
     * @param List<PriRpScpRtActCustVO> updModels
     * @param String isAccept
     * @exception DAOException
     */
    public void modifyRateActualCustomer(List<PriRpScpRtActCustVO> updModels, String isAccept) throws DAOException {
        Map<String, Object> velParam = new HashMap<String, Object>();
        velParam.put("IS_ACCEPT", isAccept);

        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;
            if (updModels.size() > 0) {
                updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtActCustVOUSQL(),
                        updModels, velParam);
                for (int i = 0; i < updCnt.length; i++) {
                    if (updCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Actual Customer 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtActCustVO> delModels
     * @exception DAOException
     */
    public void removeRateActualCustomer(List<PriRpScpRtActCustVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "2");

                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtActCustVODSQL(),
                        delModels, velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity 데이터를 생성한다.<br>
     *
     * @param List<PriRpScpRtCnoteVO> insModels
     * @exception DAOException
     */
    public void addRateCnote(List<PriRpScpRtCnoteVO> insModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if (insModels.size() > 0) {
                insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCnoteVOCSQL(), insModels,
                        null);
                for (int i = 0; i < insCnt.length; i++) {
                    if (insCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity Note 데이터를 갱신한다.<br>
     *
     * @param List<PriRpScpRtCnoteVO> updModels
     * @param String isAccept
     * @exception DAOException
     */
    public void modifyRateCnote(List<PriRpScpRtCnoteVO> updModels, String isAccept) throws DAOException {
        Map<String, Object> velParam = new HashMap<String, Object>();
        velParam.put("IS_ACCEPT", isAccept);

        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;
            if (updModels.size() > 0) {
                updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCnoteVOUSQL(), updModels,
                        velParam);
                for (int i = 0; i < updCnt.length; i++) {
                    if (updCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity Note 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCnoteVO> delModels
     * @exception DAOException
     */
    public void removeRateCnote(List<PriRpScpRtCnoteVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "2");

                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCnoteVODSQL(), delModels,
                        velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity 데이터를 생성한다.<br>
     *
     * @param List<PriRpScpRtCmdtVO> insModels
     * @exception DAOException
     */
    public void addRateCommodity(List<PriRpScpRtCmdtVO> insModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if (insModels.size() > 0) {
                insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtVOCSQL(), insModels,
                        null);
                for (int i = 0; i < insCnt.length; i++) {
                    if (insCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity Guideline을 Copy한다.
     *
     * @param RfaGlineCopyVO rfaGlineCopyVO
     * @exception DAOException
     */
    public void addRateCommodityGlineCopy(RfaGlineCopyVO rfaGlineCopyVO) throws DAOException {
        try {
            Map<String, Object> param = new HashMap<String, Object>();
            Map<String, Object> velParam = new HashMap<String, Object>();

            Map<String, String> mapVO = rfaGlineCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtGlineCpVOCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity 데이터를 갱신한다.<br>
     *
     * @param List<PriRpScpRtCmdtVO> updModels
     * @param String isAccept
     * @exception DAOException
     */
    public void modifyRateCommodity(List<PriRpScpRtCmdtVO> updModels, String isAccept) throws DAOException {
        Map<String, Object> velParam = new HashMap<String, Object>();
        velParam.put("IS_ACCEPT", isAccept);

        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;
            if (updModels.size() > 0) {
                updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtVOUSQL(), updModels,
                        velParam);
                for (int i = 0; i < updCnt.length; i++) {
                    if (updCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodity(List<PriRpScpRtCmdtVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "2");

                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtVODSQL(), delModels,
                        velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity Header 데이터를 생성한다.<br>
     *
     * @param List<PriRpScpRtCmdtHdrVO> insModels
     * @exception DAOException
     */
    public void addRateCommodityHeader(List<PriRpScpRtCmdtHdrVO> insModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if (insModels.size() > 0) {
                insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtHdrVOCSQL(),
                        insModels, null);
                for (int i = 0; i < insCnt.length; i++) {
                    if (insCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity Header Guideline을 Copy한다.
     *
     * @param RfaGlineCopyVO rfaGlineCopyVO
     * @exception DAOException
     */
    public void addRateCommodityHeaderGlineCopy(RfaGlineCopyVO rfaGlineCopyVO) throws DAOException {
        try {
            Map<String, Object> param = new HashMap<String, Object>();
            Map<String, Object> velParam = new HashMap<String, Object>();

            Map<String, String> mapVO = rfaGlineCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtHdrGlineCpVOCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity Header 데이터를 갱신한다.<br>
     *
     * @param List<PriRpScpRtCmdtHdrVO> updModels
     * @param String isAccept
     * @exception DAOException
     */
    public void modifyRateCommodityHeader(List<PriRpScpRtCmdtHdrVO> updModels, String isAccept) throws DAOException {
        Map<String, Object> velParam = new HashMap<String, Object>();
        velParam.put("IS_ACCEPT", isAccept);

        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;
            if (updModels.size() > 0) {
                updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtHdrVOUSQL(),
                        updModels, velParam);
                for (int i = 0; i < updCnt.length; i++) {
                    if (updCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity Header 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtHdrVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityHeader(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "1");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");
                }

                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtHdrVODSQL(),
                        delModels, velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }

            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity Header 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtHdrVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityHeaderCascadeCmdt(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "1");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");
                }

                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtVODSQL(), delModels,
                        velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }

            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity Header 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtHdrVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityHeaderCascadeActCust(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "1");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");
                }

                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtActCustVODSQL(),
                        delModels, velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
                
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity Header 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtHdrVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityHeaderCascadeCnote(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "1");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");
                }

                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCnoteVODSQL(), delModels,
                        velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }

            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity Header 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtHdrVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityHeaderCascadeCmdtRout(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "1");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");
                }

                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRoutVODSQL(),
                        delModels, velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }

            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity Header 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtHdrVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityHeaderCascadeRoutPnt(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "1");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");
                }

                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntVODSQL(),
                        delModels, velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }

            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity Header 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtHdrVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityHeaderCascadeRoutVia(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "1");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");
                }

                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaVODSQL(),
                        delModels, velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }

            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity Header 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtHdrVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityHeaderCascadeRnote(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "1");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");
                }

                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteVODSQL(),
                        delModels, velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }

            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity Header 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtHdrVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityHeaderCascadeRt(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "1");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");
                }

                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtVODSQL(), delModels,
                        velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }

            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }


    /**
     * Commodity Header 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtHdrVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityHeaderCascadeCgoSpec(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "1");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");
                }

                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCgoSpecVODSQL(), delModels,
                        velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }

            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity Header 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtHdrVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityHeaderDelAmendCmdt(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "1");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");

                    delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtVOUSQL(),
                            delModels, velParam);
                    for (int i = 0; i < delCnt.length; i++) {
                        if (delCnt[i] == Statement.EXECUTE_FAILED)
                            throw new DAOException("Fail to insert No" + i + " SQL");
                    }

                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity Header 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtHdrVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityHeaderDelAmendActCust(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "1");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");

                    delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtActCustVOUSQL(),
                            delModels, velParam);
                    for (int i = 0; i < delCnt.length; i++) {
                        if (delCnt[i] == Statement.EXECUTE_FAILED)
                            throw new DAOException("Fail to insert No" + i + " SQL");
                    }

                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity Header 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtHdrVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityHeaderDelAmendCnote(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "1");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");

                    delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCnoteVOUSQL(),
                            delModels, velParam);
                    for (int i = 0; i < delCnt.length; i++) {
                        if (delCnt[i] == Statement.EXECUTE_FAILED)
                            throw new DAOException("Fail to insert No" + i + " SQL");
                    }

                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity Header 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtHdrVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityHeaderDelAmendRoutPnt(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "1");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");

                    delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntVOUSQL(),
                            delModels, velParam);
                    for (int i = 0; i < delCnt.length; i++) {
                        if (delCnt[i] == Statement.EXECUTE_FAILED)
                            throw new DAOException("Fail to insert No" + i + " SQL");
                    }

                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity Header 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtHdrVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityHeaderDelAmendRoutVia(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "1");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");

                    delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaVOUSQL(),
                            delModels, velParam);
                    for (int i = 0; i < delCnt.length; i++) {
                        if (delCnt[i] == Statement.EXECUTE_FAILED)
                            throw new DAOException("Fail to insert No" + i + " SQL");
                    }

                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity Header 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtHdrVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityHeaderDelAmendRnote(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "1");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");

                    delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteVOUSQL(),
                            delModels, velParam);
                    for (int i = 0; i < delCnt.length; i++) {
                        if (delCnt[i] == Statement.EXECUTE_FAILED)
                            throw new DAOException("Fail to insert No" + i + " SQL");
                    }

                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Commodity Header 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtHdrVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityHeaderDelAmendRt(List<PriRpScpRtCmdtHdrVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "1");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");

                    delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtVOUSQL(), delModels,
                            velParam);
                    for (int i = 0; i < delCnt.length; i++) {
                        if (delCnt[i] == Statement.EXECUTE_FAILED)
                            throw new DAOException("Fail to insert No" + i + " SQL");
                    }

                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Route Note 데이터를 생성한다.<br>
     *
     * @param List<PriRpScpRtCmdtRnoteVO> insModels
     * @exception DAOException
     */
    public void addRateCommodityRnote(List<PriRpScpRtCmdtRnoteVO> insModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if (insModels.size() > 0) {
                insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteVOCSQL(),
                        insModels, null);
                for (int i = 0; i < insCnt.length; i++) {
                    if (insCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Route Note 데이터를 갱신한다.<br>
     *
     * @param List<PriRpScpRtCmdtRnoteVO> updModels
     * @param String isAccept
     * @exception DAOException
     */
    public void modifyRateCommodityRnote(List<PriRpScpRtCmdtRnoteVO> updModels, String isAccept) throws DAOException {
        Map<String, Object> velParam = new HashMap<String, Object>();
        velParam.put("IS_ACCEPT", isAccept);

        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;
            if (updModels.size() > 0) {
                updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteVOUSQL(),
                        updModels, velParam);
                for (int i = 0; i < updCnt.length; i++) {
                    if (updCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Route Note 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtRnoteVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityRnote(List<PriRpScpRtCmdtRnoteVO> delModels) throws DAOException {
        try {
            HashMap<String, Object> velParam = new HashMap<String, Object>();
            velParam.put("CASCADE_LEVEL", "3");

            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteVODSQL(),
                        delModels, velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Route 데이터를 생성한다.<br>
     *
     * @param List<PriRpScpRtCmdtRoutVO> insModels
     * @exception DAOException
     */
    public void addRateCommodityRoute(List<PriRpScpRtCmdtRoutVO> insModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if (insModels.size() > 0) {
                insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRoutVOCSQL(),
                        insModels, null);
                for (int i = 0; i < insCnt.length; i++) {
                    if (insCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Route Guideline을 Copy한다.<br>
     *
     * @param RfaGlineCopyVO rfaGlineCopyVO
     * @exception DAOException
     */
    public void addRateCommodityRouteGlineCopy(RfaGlineCopyVO rfaGlineCopyVO) throws DAOException {
        try {
            Map<String, Object> param = new HashMap<String, Object>();
            Map<String, Object> velParam = new HashMap<String, Object>();

            Map<String, String> mapVO = rfaGlineCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRoutGlineCpVOCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Route 데이터를 갱신한다.<br>
     *
     * @param List<PriRpScpRtCmdtRoutVO> updModels
     * @param String isAccept
     * @exception DAOException
     */
    public void modifyRateCommodityRoute(List<PriRpScpRtCmdtRoutVO> updModels, String isAccept) throws DAOException {
        Map<String, Object> velParam = new HashMap<String, Object>();
        velParam.put("IS_ACCEPT", isAccept);

        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;
            if (updModels.size() > 0) {
                updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRoutVOUSQL(),
                        updModels, velParam);
                for (int i = 0; i < updCnt.length; i++) {
                    if (updCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Route 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtRoutVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityRoute(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "2");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");
                }

                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRoutVODSQL(),
                        delModels, velParam);

                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }

            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Route 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtRoutVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityRouteCascadeRoutPnt(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "2");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");
                }

                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntVODSQL(),
                        delModels, velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }

            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Route 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtRoutVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityRouteCascadeRoutVia(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "2");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");
                }

                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaVODSQL(),
                        delModels, velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }

            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Route 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtRoutVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityRouteCascadeRnote(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "2");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");
                }

                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteVODSQL(),
                        delModels, velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }

            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Route 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtRoutVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityRouteCascadeRt(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "2");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");
                }

                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtVODSQL(), delModels,
                        velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }

            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }


    
    /**
     * Route 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtRoutVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityRouteCascadeCgoSpec(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "2");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");
                }

                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCgoSpecVODSQL(), delModels,
                        velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }

            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Route 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtRoutVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityRouteDelAmendRoutPnt(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "2");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");

                    delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntVOUSQL(),
                            delModels, velParam);
                    for (int i = 0; i < delCnt.length; i++) {
                        if (delCnt[i] == Statement.EXECUTE_FAILED)
                            throw new DAOException("Fail to insert No" + i + " SQL");
                    }
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Route 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtRoutVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityRouteDelAmendRoutVia(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "2");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");

                    delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaVOUSQL(),
                            delModels, velParam);
                    for (int i = 0; i < delCnt.length; i++) {
                        if (delCnt[i] == Statement.EXECUTE_FAILED)
                            throw new DAOException("Fail to insert No" + i + " SQL");
                    }
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Route 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtRoutVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityRouteDelAmendRnote(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "2");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");

                    delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteVOUSQL(),
                            delModels, velParam);
                    for (int i = 0; i < delCnt.length; i++) {
                        if (delCnt[i] == Statement.EXECUTE_FAILED)
                            throw new DAOException("Fail to insert No" + i + " SQL");
                    }

                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Route 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtCmdtRoutVO> delModels
     * @exception DAOException
     */
    public void removeRateCommodityRouteDelAmendRt(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                HashMap<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("CASCADE_LEVEL", "2");
                velParam.put("IS_ACCEPT", "N");
                if (Integer.parseInt(delModels.get(0).getAmdtSeq()) > 0) {
                    velParam.put("IS_DEL_AMEND", "Y");

                    delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtVOUSQL(), delModels,
                            velParam);
                    for (int i = 0; i < delCnt.length; i++) {
                        if (delCnt[i] == Statement.EXECUTE_FAILED)
                            throw new DAOException("Fail to insert No" + i + " SQL");
                    }
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Route Point 데이터를 생성한다.<br>
     *
     * @param List<PriRpScpRtRoutPntVO> insModels
     * @exception DAOException
     */
    public void addRateRoutePoint(List<PriRpScpRtRoutPntVO> insModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if (insModels.size() > 0) {
                insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntVOCSQL(),
                        insModels, null);
                for (int i = 0; i < insCnt.length; i++) {
                    if (insCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Route Point Guideline을 Copy한다.
     *
     * @param RfaGlineCopyVO rfaGlineCopyVO
     * @exception DAOException
     */
    public void addRateRoutePointGlineCopy(RfaGlineCopyVO rfaGlineCopyVO) throws DAOException {
        try {
            Map<String, Object> param = new HashMap<String, Object>();
            Map<String, Object> velParam = new HashMap<String, Object>();

            Map<String, String> mapVO = rfaGlineCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntGlineCpVOCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Route Point 데이터를 갱신한다.<br>
     *
     * @param List<PriRpScpRtRoutPntVO> updModels
     * @param String isAccept
     * @exception DAOException
     */
    public void modifyRateRoutePoint(List<PriRpScpRtRoutPntVO> updModels, String isAccept) throws DAOException {
        Map<String, Object> velParam = new HashMap<String, Object>();
        velParam.put("IS_ACCEPT", isAccept);

        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;
            if (updModels.size() > 0) {
                updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntVOUSQL(),
                        updModels, velParam);
                for (int i = 0; i < updCnt.length; i++) {
                    if (updCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Route Point 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtRoutPntVO> delModels
     * @exception DAOException
     */
    public void removeRateRoutePoint(List<PriRpScpRtRoutPntVO> delModels) throws DAOException {
        try {
            HashMap<String, Object> velParam = new HashMap<String, Object>();
            velParam.put("CASCADE_LEVEL", "3");

            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntVODSQL(),
                        delModels, velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Route Via. 데이터를 생성한다.<br>
     *
     * @param List<PriRpScpRtRoutViaVO> insModels
     * @exception DAOException
     */
    public void addRateRouteVia(List<PriRpScpRtRoutViaVO> insModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if (insModels.size() > 0) {
                insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaVOCSQL(),
                        insModels, null);
                for (int i = 0; i < insCnt.length; i++) {
                    if (insCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Route Via. Guideline을 Copy한다.
     *
     * @param RfaGlineCopyVO rfaGlineCopyVO
     * @exception DAOException
     */
    public void addRateRouteViaGlineCopy(RfaGlineCopyVO rfaGlineCopyVO) throws DAOException {
        try {
            Map<String, Object> param = new HashMap<String, Object>();
            Map<String, Object> velParam = new HashMap<String, Object>();

            Map<String, String> mapVO = rfaGlineCopyVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaGlineCpVOCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Route Via. 데이터를 갱신한다.<br>
     *
     * @param List<PriRpScpRtRoutViaVO> updModels
     * @param String isAccept
     * @exception DAOException
     */
    public void modifyRateRouteVia(List<PriRpScpRtRoutViaVO> updModels, String isAccept) throws DAOException {
        Map<String, Object> velParam = new HashMap<String, Object>();
        velParam.put("IS_ACCEPT", isAccept);

        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;
            if (updModels.size() > 0) {
                updCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaVOUSQL(),
                        updModels, velParam);
                for (int i = 0; i < updCnt.length; i++) {
                    if (updCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Route Via. 데이터를 삭제한다.<br>
     *
     * @param List<PriRpScpRtRoutViaVO> delModels
     * @exception DAOException
     */
    public void removeRateRouteVia(List<PriRpScpRtRoutViaVO> delModels) throws DAOException {
        try {
            HashMap<String, Object> velParam = new HashMap<String, Object>();
            velParam.put("CASCADE_LEVEL", "3");

            SQLExecuter sqlExe = new SQLExecuter("");
            int delCnt[] = null;
            if (delModels.size() > 0) {
                delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaVODSQL(),
                        delModels, velParam);
                for (int i = 0; i < delCnt.length; i++) {
                    if (delCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * CUD후 Route Note의 Display Sequence를 재배열한다.<br>
     *
     * @param PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO
     * @param String cascadeLevel
     * @exception DAOException
     */
    public void modifyRouteNoteDispSeq(PriRpScpRtCmdtRoutVO priRpScpRtCmdtRoutVO, String cascadeLevel) throws DAOException {
        Map<String, Object> param = new HashMap<String, Object>();
        HashMap<String, Object> velParam = new HashMap<String, Object>();
        int result = 0;

        try {
            Map<String, String> mapVO = priRpScpRtCmdtRoutVO.getColumnValues();
            param.putAll(mapVO);

            velParam.put("CASCADE_LEVEL", cascadeLevel);

            SQLExecuter sqlExe = new SQLExecuter("");
//          result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOReorderRouteNoteDpSeqUSQL(), param,  velParam);
            result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOReorderRouteNoteDpSeqMergeUSQL(), param,  velParam);
            if (result == Statement.EXECUTE_FAILED)
                throw new DAOException("Fail to insert SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Rate Guideline CMDT Header의 리스트를 조회한다.<br>
     *
     * @param RfaGlineCopyVO rfaGlineCopyVO
     * @return RsltCdListVO
     * @exception DAOException
     */
    public RsltCdListVO searchGlineCopyGroupCodeExist(RfaGlineCopyVO rfaGlineCopyVO) throws DAOException {
        DBRowSet dbRowset = null;
        RsltCdListVO rsltVO = new RsltCdListVO();

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (rfaGlineCopyVO != null) {
                Map<String, String> mapVO = rfaGlineCopyVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }

            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new RFARateProposalDBDAOGlineCpChkGrpLocExistRSQL(), param, velParam);
            if (dbRowset != null && dbRowset.next()) {
                rsltVO.setEtc1(dbRowset.getString("cnt"));
            }

            dbRowset = null;
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new RFARateProposalDBDAOGlineCpChkGrpCmdtExistRSQL(), param, velParam);
            if (dbRowset != null && dbRowset.next()) {
                rsltVO.setEtc2(dbRowset.getString("cnt"));
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rsltVO;
    }

    /**
	 * Rate내의 모든항목을 Accept 처리한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllRateCmdt(PriRpScpRtVO priRpScpRtVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRpScpRtVO.getColumnValues();
			param.putAll(mapVO);

			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("IS_ACCEPT", "Y");
			velParam.put("CASCADE_LEVEL", "0");

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtVOUSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

    /**
	 * Rate내의 모든항목을 Accept 처리한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllRateActCust(PriRpScpRtVO priRpScpRtVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRpScpRtVO.getColumnValues();
			param.putAll(mapVO);

			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("IS_ACCEPT", "Y");
			velParam.put("CASCADE_LEVEL", "0");

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtActCustVOUSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

    /**
	 * Rate내의 모든항목을 Accept 처리한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllRateCnote(PriRpScpRtVO priRpScpRtVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRpScpRtVO.getColumnValues();
			param.putAll(mapVO);

			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("IS_ACCEPT", "Y");
			velParam.put("CASCADE_LEVEL", "0");

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCnoteVOUSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}
	
    /**
	 * Rate내의 모든항목을 Accept 처리한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllRateRoutPnt(PriRpScpRtVO priRpScpRtVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRpScpRtVO.getColumnValues();
			param.putAll(mapVO);

			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("IS_ACCEPT", "Y");
			velParam.put("CASCADE_LEVEL", "0");

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntVOUSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

    /**
	 * Rate내의 모든항목을 Accept 처리한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllRateRoutVia(PriRpScpRtVO priRpScpRtVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRpScpRtVO.getColumnValues();
			param.putAll(mapVO);

			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("IS_ACCEPT", "Y");
			velParam.put("CASCADE_LEVEL", "0");

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaVOUSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

    /**
	 * Rate내의 모든항목을 Accept 처리한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllRateRnote(PriRpScpRtVO priRpScpRtVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRpScpRtVO.getColumnValues();
			param.putAll(mapVO);

			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("IS_ACCEPT", "Y");
			velParam.put("CASCADE_LEVEL", "0");

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteVOUSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

    /**
	 * Rate내의 모든항목을 Accept 처리한다.<br>
	 * 
	 * @param PriRpScpRtVO priRpScpRtVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyAcceptAllRateRt(PriRpScpRtVO priRpScpRtVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = priRpScpRtVO.getColumnValues();
			param.putAll(mapVO);

			HashMap<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("IS_ACCEPT", "Y");
			velParam.put("CASCADE_LEVEL", "0");

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtVOUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return result;
	}

    /**
     * Rate 데이터에 GRI Calculation을 적용합니다.<br>
     *
     * @param PriRpScpGriGrpVO priRpScpGriGrpVO
     * @exception DAOException
     */
    public void modifyProposalScopeRateGRIApply(PriRpScpGriGrpVO priRpScpGriGrpVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priRpScpGriGrpVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
//          int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtGRIApplyVOUSQL(), param,  velParam);
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtGRIApplyMergeVOUSQL(), param,  velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            if (se.getErrorCode() == 30926) {
                throw new DAOException(new ErrorHandler("PRI01999").getMessage());
            } else {
                throw new DAOException(new ErrorHandler(se).getMessage(), se);
            }
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * GRI Apply<br>
     *
     * @param PriRpScpGriGrpVO priRpScpGriGrpVO
     * @return int
     * @exception DAOException
     */
    public int modifyProposalScopeRateGRICancel(PriRpScpGriGrpVO priRpScpGriGrpVO) throws DAOException {
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        int result = -1;
        
        try {
            Map<String, String> mapVO = priRpScpGriGrpVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtGRICancelVOUSQL(), param,
                    velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        
        return result;
    }
    
	
    
    
    
    
    /**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
     *
     * @param PriRpScpMnVO priRpScpMnVO
     * @exception DAOException
     */
    public void removeProposalMainRtCgoSpec(PriRpScpMnVO priRpScpMnVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            velParam.put("CASCADE_LEVEL", "0");
            velParam.put("IS_ACCEPT", "N");

            int result = -1;
            SQLExecuter sqlExe = new SQLExecuter("");

            result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCgoSpecVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
          

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }     
    
    /**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
     *
     * @param PriRpScpMnVO priRpScpMnVO
     * @exception DAOException
     */
    public void removeProposalMainRt(PriRpScpMnVO priRpScpMnVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            velParam.put("CASCADE_LEVEL", "0");
            velParam.put("IS_ACCEPT", "N");

            int result = -1;
            SQLExecuter sqlExe = new SQLExecuter("");

            result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtVODSQL(), param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
          

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }     
    
    /**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
     *
     * @param PriRpScpMnVO priRpScpMnVO
     * @exception DAOException
     */
    public void removeProposalMainRtRoutVia(PriRpScpMnVO priRpScpMnVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            velParam.put("CASCADE_LEVEL", "0");
            velParam.put("IS_ACCEPT", "N");

            int result = -1;
            SQLExecuter sqlExe = new SQLExecuter("");

            result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaVODSQL(), param,
                    velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
          

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }      
    
    /**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
     *
     * @param PriRpScpMnVO priRpScpMnVO
     * @exception DAOException
     */
    public void removeProposalMainRtRoutPnt(PriRpScpMnVO priRpScpMnVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            velParam.put("CASCADE_LEVEL", "0");
            velParam.put("IS_ACCEPT", "N");

            int result = -1;
            SQLExecuter sqlExe = new SQLExecuter("");

            result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntVODSQL(), param,
                    velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
          

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }   
    
    
    /**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
     *
     * @param PriRpScpMnVO priRpScpMnVO
     * @exception DAOException
     */
    public void removeProposalMainRtCmdtRnote (PriRpScpMnVO priRpScpMnVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            velParam.put("CASCADE_LEVEL", "0");
            velParam.put("IS_ACCEPT", "N");

            int result = -1;
            SQLExecuter sqlExe = new SQLExecuter("");

            result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteVODSQL(), param,
                    velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
          

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }     
    
    /**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
     *
     * @param PriRpScpMnVO priRpScpMnVO
     * @exception DAOException
     */
    public void removeProposalMainRtCmdtRout (PriRpScpMnVO priRpScpMnVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            velParam.put("CASCADE_LEVEL", "0");
            velParam.put("IS_ACCEPT", "N");

            int result = -1;
            SQLExecuter sqlExe = new SQLExecuter("");

            result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRoutVODSQL(), param,
                    velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
          

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }     
    
    /**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
     *
     * @param PriRpScpMnVO priRpScpMnVO
     * @exception DAOException
     */
    public void removeProposalMainRtCnote (PriRpScpMnVO priRpScpMnVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            velParam.put("CASCADE_LEVEL", "0");
            velParam.put("IS_ACCEPT", "N");

            int result = -1;
            SQLExecuter sqlExe = new SQLExecuter("");

            result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCnoteVODSQL(), param,
                    velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
          

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }    
    
    /**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
     *
     * @param PriRpScpMnVO priRpScpMnVO
     * @exception DAOException
     */
    public void removeProposalMainRtActCust (PriRpScpMnVO priRpScpMnVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            velParam.put("CASCADE_LEVEL", "0");
            velParam.put("IS_ACCEPT", "N");

            int result = -1;
            SQLExecuter sqlExe = new SQLExecuter("");

            result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtActCustVODSQL(), param,
                    velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
          

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }    
    
    /**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
     *
     * @param PriRpScpMnVO priRpScpMnVO
     * @exception DAOException
     */
    public void removeProposalMainRtCmdt (PriRpScpMnVO priRpScpMnVO) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            velParam.put("CASCADE_LEVEL", "0");
            velParam.put("IS_ACCEPT", "N");

            int result = -1;
            SQLExecuter sqlExe = new SQLExecuter("");

            result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtVODSQL(), param, velParam);
		    if (result == Statement.EXECUTE_FAILED) {
		        throw new DAOException("Fail to insert SQL");
		    }
          

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }        
     
     /**
 	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
      *
      * @param PriRpScpMnVO priRpScpMnVO
      * @exception DAOException
      */
     public void removeProposalMainRtCmdtHdr (PriRpScpMnVO priRpScpMnVO) throws DAOException {
         // query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         // velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();
         try {
             Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

             param.putAll(mapVO);
             velParam.putAll(mapVO);

             velParam.put("CASCADE_LEVEL", "0");
             velParam.put("IS_ACCEPT", "N");

             int result = -1;
             SQLExecuter sqlExe = new SQLExecuter("");

             result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtHdrVODSQL(), param,
                     velParam);
             if (result == Statement.EXECUTE_FAILED) {
                 throw new DAOException("Fail to insert SQL");
             }
           

         } catch (SQLException se) {
             log.error(se.getMessage(), se);
             throw new DAOException(new ErrorHandler(se).getMessage(), se);
         } catch (Exception ex) {
             log.error(ex.getMessage(), ex);
             throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
         }
     }         
    
//    /**
//	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
//     *
//     * @param PriRpScpMnVO priRpScpMnVO
//     * @exception DAOException
//     */
//    public void removeProposalMain(PriRpScpMnVO priRpScpMnVO) throws DAOException {
//        // query parameter
//        Map<String, Object> param = new HashMap<String, Object>();
//        // velocity parameter
//        Map<String, Object> velParam = new HashMap<String, Object>();
//        try {
//            Map<String, String> mapVO = priRpScpMnVO.getColumnValues();
//
//            param.putAll(mapVO);
//            velParam.putAll(mapVO);
//
//            velParam.put("CASCADE_LEVEL", "0");
//            velParam.put("IS_ACCEPT", "N");
//
//            int result = -1;
//            SQLExecuter sqlExe = new SQLExecuter("");
//
//            result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgVODSQL(), param, velParam);
//            if (result == Statement.EXECUTE_FAILED) {
//                throw new DAOException("Fail to insert SQL");
//            }
//
//            result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtScgRoutVODSQL(), param, velParam);
//            if (result == Statement.EXECUTE_FAILED) {
//                throw new DAOException("Fail to insert SQL");
//            }
//
//            result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCgoSpecVODSQL(), param, velParam);
//            if (result == Statement.EXECUTE_FAILED) {
//                throw new DAOException("Fail to insert SQL");
//            }
//
//            result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtVODSQL(), param, velParam);
//            if (result == Statement.EXECUTE_FAILED) {
//                throw new DAOException("Fail to insert SQL");
//            }
//
//            result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaVODSQL(), param,
//                    velParam);
//            if (result == Statement.EXECUTE_FAILED) {
//                throw new DAOException("Fail to insert SQL");
//            }
//
//            result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntVODSQL(), param,
//                    velParam);
//            if (result == Statement.EXECUTE_FAILED) {
//                throw new DAOException("Fail to insert SQL");
//            }
//
//            result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteVODSQL(), param,
//                    velParam);
//            if (result == Statement.EXECUTE_FAILED) {
//                throw new DAOException("Fail to insert SQL");
//            }
//
//            result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRoutVODSQL(), param,
//                    velParam);
//            if (result == Statement.EXECUTE_FAILED) {
//                throw new DAOException("Fail to insert SQL");
//            }
//
//            result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCnoteVODSQL(), param,
//                    velParam);
//            if (result == Statement.EXECUTE_FAILED) {
//                throw new DAOException("Fail to insert SQL");
//            }
//
//            result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtActCustVODSQL(), param,
//                    velParam);
//            if (result == Statement.EXECUTE_FAILED) {
//                throw new DAOException("Fail to insert SQL");
//            }
//
//            result = sqlExe
//                    .executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtVODSQL(), param, velParam);
//            if (result == Statement.EXECUTE_FAILED) {
//                throw new DAOException("Fail to insert SQL");
//            }
//
//            result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtHdrVODSQL(), param,
//                    velParam);
//            if (result == Statement.EXECUTE_FAILED) {
//                throw new DAOException("Fail to insert SQL");
//            }
//
//        } catch (SQLException se) {
//            log.error(se.getMessage(), se);
//            throw new DAOException(new ErrorHandler(se).getMessage(), se);
//        } catch (Exception ex) {
//            log.error(ex.getMessage(), ex);
//            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//        }
//    }

    /**
     * Excel Upload Check시 실제로 코드가 존재하는지 점검한다.
     *
     * @param RsltCdListVO rsltCdListVO
     * @return RsltCdListVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public RsltCdListVO searchActualCustomerExists(RsltCdListVO rsltCdListVO) throws DAOException {
        List<RsltCdListVO> list = null;
        DBRowSet dbRowset = null;

        Map<String, Object> param = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = rsltCdListVO.getColumnValues();
            param.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOLoadExcelCheckActCustRSQL(), param, null);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }

        if (list == null || list.size() <= 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

    /**
     * Excel Upload Check시 실제로 코드가 존재하는지 점검한다.
     *
     * @param RsltCdListVO rsltCdListVO
     * @return RsltCdListVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public RsltCdListVO searchCommodityCodeExists(RsltCdListVO rsltCdListVO) throws DAOException {
        List<RsltCdListVO> list = null;
        DBRowSet dbRowset = null;

        Map<String, Object> param = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = rsltCdListVO.getColumnValues();
            param.putAll(mapVO);

            if (rsltCdListVO.getCd().length() == 5) {
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOLoadExcelCheckGrpCmdtRSQL(), param, null);
            } else if (rsltCdListVO.getCd().length() == 4) {
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOLoadExcelCheckRepCmdtRSQL(), param, null);
            } else if (rsltCdListVO.getCd().length() == 6) {
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOLoadExcelCheckCmdtRSQL(), param, null);
            } else {
                return null;
            }
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }

        if (list == null || list.size() <= 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

    /**
     * Excel Upload Check시 실제로 코드가 존재하는지 점검한다.
     *
     * @param RsltCdListVO rsltCdListVO
     * @return RsltCdListVO
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public RsltCdListVO searchLocationCodeExists(RsltCdListVO rsltCdListVO) throws DAOException {
        List<RsltCdListVO> list = null;
        DBRowSet dbRowset = null;

        Map<String, Object> param = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = rsltCdListVO.getColumnValues();
            param.putAll(mapVO);

            if (rsltCdListVO.getCd().length() == 4) {
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOLoadExcelCheckGrpLocRSQL(), param, null);
            } else if (rsltCdListVO.getCd().length() == 5) {
                dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOLoadExcelCheckLocRSQL(), param, null);
            } else {
                return null;
            }
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }

        if (list == null || list.size() <= 0) {
            return null;
        } else {
            return list.get(0);
        }
    }

    /**
     * SCSalesGuidelineDAO 데이타 모델에 해당되는 값을 불러온다.<br>
     *
     * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
     * @return int
     * @exception DAOException
     */
    public int searchNextCmdtHdrSeq(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
        int nextSeq = -1;
        DBRowSet dbRowset = null;

        Map<String, Object> param = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();
            param.putAll(mapVO);

            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOGetNextCmdtHdrSeqRSQL(), param, null);
            if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
                nextSeq = dbRowset.getInt("next_seq");
            }

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return nextSeq;
    }

///////////////////////////// 박성수 수정 종료 ///////////////////////////////////////



/////////////////공백진수정 시작////////////////////////////////////////////////////

    /**
	 * Actual Customer의 데이터를 AMEND SEQ +1로 추가한다.<br>
     *
     * @param List<PriRpMnVO> insModels
     * @exception DAOException
     */
    public void addRateActualCustomerAmend(List<PriRpMnVO> insModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if (insModels.size() > 0) {
                insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtActCustAmdVOCSQL(),
                        insModels, null);
                for (int i = 0; i < insCnt.length; i++) {
                    if (insCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
	 * Rate Cnote의 데이터를 AMEND SEQ +1로 추가한다.<br>
     *
     * @param List<PriRpMnVO> insModels
     * @exception DAOException
     */
    public void addRateCnoteAmend(List<PriRpMnVO> insModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if (insModels.size() > 0) {
                insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCnoteAmdVOCSQL(),
                        insModels, null);
                for (int i = 0; i < insCnt.length; i++) {
                    if (insCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
	 * Rate Commodity 데이터를 AMEND SEQ +1로 추가한다.<br>
     *
     * @param List<PriRpMnVO> insModels
     * @exception DAOException
     */
    public void addRateCommodityAmend(List<PriRpMnVO> insModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if (insModels.size() > 0) {
                insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtAmdVOCSQL(),
                        insModels, null);
                for (int i = 0; i < insCnt.length; i++) {
                    if (insCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
	 * Rate Commodity Header 데이터를 AMEND SEQ +1로 추가한다.<br>
     *
     * @param List<PriRpMnVO> insModels
     * @exception DAOException
     */
    public void addRateCommodityHeaderAmend(List<PriRpMnVO> insModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if (insModels.size() > 0) {
                insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtHdrAmdVOCSQL(),
                        insModels, null);
                for (int i = 0; i < insCnt.length; i++) {
                    if (insCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
	 * Rate Commodity Route 데이터를 AMEND SEQ +1로 추가한다.<br>
     *
     * @param List<PriRpMnVO> insModels
     * @exception DAOException
     */
    public void addRateCommodityRouteAmend(List<PriRpMnVO> insModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if (insModels.size() > 0) {
                insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRoutAmdVOCSQL(),
                        insModels, null);
                for (int i = 0; i < insCnt.length; i++) {
                    if (insCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
	 * Rate 데이터를 AMEND SEQ +1로 추가한다.<br>
     *
     * @param List<PriRpMnVO> insModels
     * @exception DAOException
     */
    public void addRateAmend(List<PriRpMnVO> insModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if (insModels.size() > 0) {
                insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtAmdVOCSQL(), insModels,
                        null);
                for (int i = 0; i < insCnt.length; i++) {
                    if (insCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
	 * Rate Commodity Rnote 데이터를 AMEND SEQ +1로 추가한다.<br>
     *
     * @param List<PriRpMnVO> insModels
     * @exception DAOException
     */
    public void addRateCommodityRnoteAmend(List<PriRpMnVO> insModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if (insModels.size() > 0) {
                insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteAmdVOCSQL(),
                        insModels, null);
                for (int i = 0; i < insCnt.length; i++) {
                    if (insCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
	 * Rate Route Point 데이터를 AMEND SEQ +1로 추가한다.<br>
     *
     * @param List<PriRpMnVO> insModels
     * @exception DAOException
     */
    public void addRateRoutePointAmend(List<PriRpMnVO> insModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if (insModels.size() > 0) {
                insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntAmdVOCSQL(),
                        insModels, null);
                for (int i = 0; i < insCnt.length; i++) {
                    if (insCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
	 * Rate Route Via 데이터를 AMEND SEQ +1로 추가한다.<br>
     *
     * @param List<PriRpMnVO> insModels
     * @exception DAOException
     */
    public void addRateRouteViaAmend(List<PriRpMnVO> insModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if (insModels.size() > 0) {
                insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaAmdVOCSQL(),
                        insModels, null);
                for (int i = 0; i < insCnt.length; i++) {
                    if (insCnt[i] == Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No" + i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    
    /**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
     *
     * @param List<PriRpScpMnVO> updModels
     * @exception EventException
     */
    public void modifyProposalRtActCustReqCnl(List<PriRpScpMnVO> updModels) throws DAOException {
        try {

            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;

            if(updModels.size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new RFARateProposalDBDAOPriRpScpRtActCustRequestCancelVOUSQL(), updModels,null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }

            }

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }    
    /**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
     *
     * @param List<PriRpScpMnVO> updModels
     * @exception EventException
     */
    public void modifyProposalRtCmdtReqCnl(List<PriRpScpMnVO> updModels) throws DAOException {
        try {

            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;

            if(updModels.size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new RFARateProposalDBDAOPriRpScpRtCmdtRequestCancelVOUSQL(), updModels,null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }

            }

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }       
    
    /**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
     *
     * @param List<PriRpScpMnVO> updModels
     * @exception EventException
     */
    public void modifyProposalRtCmdtRnoteReqCnl(List<PriRpScpMnVO> updModels) throws DAOException {
        try {

            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;

            if(updModels.size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new RFARateProposalDBDAOPriRpScpRtCmdtRnoteRequestCancelVOUSQL(), updModels,null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }

            }

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }       
    
    /**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
     *
     * @param List<PriRpScpMnVO> updModels
     * @exception EventException
     */
    public void modifyProposalRtCnoteReqCnl(List<PriRpScpMnVO> updModels) throws DAOException {
        try {

            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;

            if(updModels.size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new RFARateProposalDBDAOPriRpScpRtCnoteRequestCancelVOUSQL(), updModels,null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }

            }

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }     
    
    /**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
     *
     * @param List<PriRpScpMnVO> updModels
     * @exception EventException
     */
    public void modifyProposalRtReqCnl(List<PriRpScpMnVO> updModels) throws DAOException {
        try {

            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;

            if(updModels.size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new RFARateProposalDBDAOPriRpScpRtRequestCancelVOUSQL(), updModels,null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }

            }

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }       

    /**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
     *
     * @param List<PriRpScpMnVO> updModels
     * @exception EventException
     */
    public void modifyProposalRtRoutePntReqCnl(List<PriRpScpMnVO> updModels) throws DAOException {
        try {

            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;

            if(updModels.size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new RFARateProposalDBDAOPriRpScpRtRoutePntRequestCancelVOUSQL(), updModels,null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }

            }

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }     
    
    /**
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
     *
     * @param List<PriRpScpMnVO> updModels
     * @exception EventException
     */
    public void modifyProposalRtRouteViaReqCnl(List<PriRpScpMnVO> updModels) throws DAOException {
        try {

            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;

            if(updModels.size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new RFARateProposalDBDAOPriRpScpRtRouteViaRequestCancelVOUSQL(), updModels,null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }

            }

        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }     




    /**
     * Rating Unit을 조회합니다.<br>
     *
     * @param PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO
     * @return RsltCdListVO
     * @exception DAOException
     */
    public RsltCdListVO checkRateCargoSepcification(PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO) throws DAOException {
         DBRowSet dbRowset = null;
            RsltCdListVO rsltVO = new RsltCdListVO();

            Map<String, Object> param = new HashMap<String, Object>();
            Map<String, Object> velParam = new HashMap<String, Object>();

            try {
                if (priRpScpRtCgoSpecVO != null) {
                    Map<String, String> mapVO = priRpScpRtCgoSpecVO.getColumnValues();

                    param.putAll(mapVO);
                    velParam.putAll(mapVO);
                }

                dbRowset = new SQLExecuter("").executeQuery(
                        (ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCgoSpecRSQL(), param, velParam);
                if (dbRowset != null && dbRowset.next()) {
                    rsltVO.setEtc2(dbRowset.getString("cnt"));
                }
            } catch (SQLException se) {
                log.error(se.getMessage(), se);
                throw new DAOException(new ErrorHandler(se).getMessage(), se);
            } catch (Exception ex) {
                log.error(ex.getMessage(), ex);
                throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
            }
            return rsltVO;
    }

    /**
     * Rate Cargo Specification 조회합니다.<br>
     *
     * @param PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO
     * @return List<RsltPriRpScpRtCgoSpecVO>
     * @exception DAOException
     */
     @SuppressWarnings("unchecked")
    public List<RsltPriRpScpRtCgoSpecVO> searchRateCargoSepcification(PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltPriRpScpRtCgoSpecVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(priRpScpRtCgoSpecVO != null){
                Map<String, String> mapVO = priRpScpRtCgoSpecVO .getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFARateProposalDBDAORsltPriRpScpRtCgoSpecVORSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltPriRpScpRtCgoSpecVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

     /**
     * 다건의 데이터를 일괄적으로 생성한다.<br>
     *
     * @param PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO
     * @exception DAOException
     */
    public void addRateCargoSepcification(PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = priRpScpRtCgoSpecVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate)new RFARateProposalDBDAOPriRpScpRtCgoSpecCSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * 다건의 데이터를 일괄적으로 갱신한다.<br>
     *
     * @param PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO
     * @exception DAOException
     */
    public void modifyRateCargoSepcification(PriRpScpRtCgoSpecVO priRpScpRtCgoSpecVO) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = priRpScpRtCgoSpecVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new RFARateProposalDBDAOPriRpScpRtCgoSpecUSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return;
    }



    /**
     * [Special Note Conversion ] 정보를 [조회] 합니다.<br>
     *
     * @param PriRfaNoteConvVO priRfaNoteConvVO
     * @return List<RsltNoteConvVO>
     * @exception DAOException
     */
     @SuppressWarnings("unchecked")
    public List<RsltNoteConvVO> searchNoteConversionList(PriRfaNoteConvVO priRfaNoteConvVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltNoteConvVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(priRfaNoteConvVO != null){
                Map<String, String> mapVO = priRfaNoteConvVO .getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRfaNoteConvVORSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltNoteConvVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * [Special Note Conversion] 정보를 [붙여넣기] 합니다.<br>
     *
     * @param PriRfaNoteConvVO priRfaNoteConvVO
     * @return List<RsltNoteConvVO>
     * @exception DAOException
     */
     @SuppressWarnings("unchecked")
    public List<RsltNoteConvVO> searchNoteConversionListCopy(PriRfaNoteConvVO priRfaNoteConvVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltNoteConvVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(priRfaNoteConvVO != null){
                Map<String, String> mapVO = priRfaNoteConvVO .getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRfaNoteConvCopyVORSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltNoteConvVO .class);
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    /**
     * [Special Note Conversion] 정보를 [추가] 합니다.<br>
     *
     * @param List<PriRfaNoteConvVO> insModels
     * @return int[]
     * @exception DAOException
     */
    public int[] addNoteConversion(List<PriRfaNoteConvVO> insModels) throws DAOException {
        int insCnt[] = null;
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            if(insModels.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRfaNoteConvVOCSQL(), insModels,null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return insCnt;
    }

    /**
     * [Special Note Conversion] 정보를 [수정] 합니다.<br>
     *
     * @param List<PriRfaNoteConvVO> updModels
     * @return int[]
     * @exception DAOException
     */
    public int[] modifyNoteConversion(List<PriRfaNoteConvVO> updModels) throws DAOException {
        int updCnt[] = null;
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            if(updModels.size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRfaNoteConvVOUSQL(), updModels,null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return updCnt;
    }

    /**
     * [Special Note Conversion] 정보를 [삭제] 합니다.<br>
     *
     * @param List<PriRfaNoteConvVO> delModels
     * @return int[]
     * @exception DAOException
     */
    public int[] removeNoteConversion(List<PriRfaNoteConvVO> delModels) throws DAOException {
        int delCnt[] = null;
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            if(delModels.size() > 0){
                delCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRfaNoteConvSeqVODSQL(), delModels, null);
                for(int i = 0; i < delCnt.length; i++){
                    if(delCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return delCnt;
    }


    /**
     * COPY된 데이터를 아이디별로 삭제한다.<br>
     *
     * @param PriRfaNoteConvListVO vo
     * @return int
     * @exception DAOException
     */
    public int removeNoteConversionCopy(PriRfaNoteConvListVO vo) throws DAOException {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        int result = 0;
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            result = sqlExe.executeUpdate((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRfaNoteConvCopyVODSQL(), param, velParam);
            if(result == Statement.EXECUTE_FAILED)
                    throw new DAOException("Fail to insert SQL");
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return result;
    }

    /**
     * Standard Note Conversion Creation 의 SHEET 데이터를 일괄적으로 COPY 한다.<br>
     *
     * @param List<PriRfaNoteConvListVO> insModels
     * @exception DAOException
     */
    public void addNoteConversionCopy(List<PriRfaNoteConvListVO> insModels) throws DAOException {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if(insModels.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new RFANoteConversionProposalDBDAOPriRfaNoteConvCopyVOCSQL(), insModels,null);
                for(int i = 0; i < insCnt.length; i++){
                    if(insCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to insert No"+ i + " SQL");
                }
            }
        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }
    

    /**
     * RFA Proposal Scope Rate Commodity Header 정보를 Copy 하여 생성합니다.<br>
     *
     * @param RsltRfaPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeRtCmdtHdr(RsltRfaPropCopyVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropCpPriRpScpRtCmdtHdrCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * RFA Proposal Scope Rate Actual Customer 정보를 Copy 하여 생성합니다.<br>
     *
     * @param RsltRfaPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeRtActCust(RsltRfaPropCopyVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropCpPriRpScpRtActCustCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * RFA Proposal Scope Rate Commodity 정보를 Copy 하여 생성합니다.<br>
     *
     * @param RsltRfaPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeRtCmdt(RsltRfaPropCopyVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropCpPriRpScpRtCmdtCSQL(), param,
                    velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * RFA Proposal Scope Rate Commodity Note 정보를 Copy 하여 생성합니다.<br>
     *
     * @param RsltRfaPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeRtCnote(RsltRfaPropCopyVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropCpPriRpScpRtCnoteCSQL(), param,
                    velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * RFA Proposal Scope Rate Commodity Route 정보를 Copy 하여 생성합니다.<br>
     *
     * @param RsltRfaPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeRtCmdtRout(RsltRfaPropCopyVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropCpPriRpScpRtCmdtRoutCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * RFA Proposal Scope Rate Route Point 정보를 Copy 하여 생성합니다.<br>
     *
     * @param RsltRfaPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeRtRoutPnt(RsltRfaPropCopyVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropCpPriRpScpRtRoutPntCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * RFA Proposal Scope Rate Route Via 정보를 Copy 하여 생성합니다.<br>
     *
     * @param RsltRfaPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeRtRoutVia(RsltRfaPropCopyVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropCpPriRpScpRtRoutViaCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * RFA Proposal Scope Rate 정보를 Copy 하여 생성합니다.<br>
     *
     * @param RsltRfaPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeRt(RsltRfaPropCopyVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropCpPriRpScpRtCSQL(), param,
                    velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * RFA Proposal Scope Rate Commodity Route Note 정보를 Copy 하여 생성합니다.<br>
     *
     * @param RsltRfaPropCopyVO vo
     * @exception DAOException
     */
    public void addCopyProposalScopeRtCmdtRnote(RsltRfaPropCopyVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPropCpPriRpScpRtCmdtRnoteCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Guideline Rate Commodity Header 를 Proposal Scope 에 Copy 합니다.<br>
     *
     * @param RpScpGlineCopyVO vo
     * @exception DAOException
     */
    public void addCopyScopeGuidelineRateCmdtHdr(RpScpGlineCopyVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOGlineCopyPriRpScpRtCmdtHdrCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Guideline Rate Commodity 를 Proposal Scope 에 Copy 합니다.<br>
     *
     * @param RpScpGlineCopyVO vo
     * @exception DAOException
     */
    public void addCopyScopeGuidelineRateCmdt(RpScpGlineCopyVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOGlineCopyPriRpScpRtCmdtCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Guideline Rate Commodity Route 를 Proposal 에 Copy 합니다.<br>
     *
     * @param RpScpGlineCopyVO vo
     * @exception DAOException
     */
    public void addCopyScopeGuidelineRateCmdtRout(RpScpGlineCopyVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOGlineCopyPriRpScpRtCmdtRoutCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Guideline Rate Route Point 를 Proposal 에 Copy 합니다.<br>
     *
     * @param RpScpGlineCopyVO vo
     * @exception DAOException
     */
    public void addCopyScopeGuidelineRateRoutPnt(RpScpGlineCopyVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOGlineCopyPriRpScpRtRoutPntCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * Guideline Rate Route Via 를 Proposal 에 Copy 합니다.<br>
     *
     * @param RpScpGlineCopyVO vo
     * @exception DAOException
     */
    public void addCopyScopeGuidelineRateRoutVia(RpScpGlineCopyVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOGlineCopyPriRpScpRtRoutViaCSQL(),
                    param, velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

    /**
     * SP Scope Rate 를 Proposal 에 Copy 합니다.<br>
     *
     * @param RpScpGlineCopyVO vo
     * @exception DAOException
     */
    public void addCopyScopeGuidelineRate(RpScpGlineCopyVO vo) throws DAOException {
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOGlineCopyPriRpScpRtCSQL(), param,
                    velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
    }

	/**
	 * RFA rate View All  
	 * 
	 * @param RsltPriRpMnCalcVO rsltPriRpMnCalcVO
	 * @return List<RsltPriRpMnCalcVO>
	 * @exception DAOException
	 */
	/*@SuppressWarnings("unchecked")
	public List<RsltPriRpMnCalcVO> searchPriRpMnCalc(
			RsltPriRpMnCalcVO rsltPriRpMnCalcVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltPriRpMnCalcVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltPriRpMnCalcVO != null) {
				Map<String, String> mapVO = rsltPriRpMnCalcVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFARateProposalDBDAORsltPriRpMnCalcVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltPriRpMnCalcVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}	
	*/

	
	/**
	 * Rate Cargo Spec 데이터를 AMEND SEQ +1로 추가한다.<br>
	 * 
	 * @param List<PriRpMnVO> insModels
	 * @exception DAOException
	 */
	public void addRateCargoSpecAmend(List<PriRpMnVO> insModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCgoSpecAmdVOCSQL(),
						insModels, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}		
	
    


	
    /**
     * 이전 AMDT_SEQ에 해당하는 메인의 EXPIRE DATE정보를 조회한다.<br>
     *
     * @param PriRpScpMnVO priRpScpMnVO
     * @return String
     * @exception DAOException
     */
    public String  searchBeforeExpireDate(PriRpScpMnVO priRpScpMnVO) throws DAOException {
        DBRowSet dbRowset = null;
        String sExpDt = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRpScpMnVO != null) {
                Map<String, String> mapVO = priRpScpMnVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOGetBeforeExpDtRSQL(),
                    param, velParam);
            if (dbRowset != null && dbRowset.next()) {
            	sExpDt = dbRowset.getString("EXP_DT");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return sExpDt;
    }
    
    
    
    /**
     * check the Excel Info.<br>
     * 
     * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
     * @param RsltRtListHorizontalExcelVO rsltRtListHorizontalExcelVO
     * @return List<RsltRtListHorizontalExcelVO>
     * @exception DAOException
     */
    public List<RsltRtListHorizontalExcelVO> chkPriRateExl(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO rsltRtListHorizontalExcelVO) throws DAOException,Exception {
    	DBRowSet dbRowset = null;
		List<RsltRtListHorizontalExcelVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rsltRtListHorizontalExcelVO != null) {
				Map<String, String> mapVO = rsltRtListHorizontalExcelVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			if (priRpScpRtCmdtHdrVO != null) {
				param.put("prop_no", priRpScpRtCmdtHdrVO.getPropNo());
				param.put("amdt_seq", priRpScpRtCmdtHdrVO.getAmdtSeq());
				param.put("svc_scp_cd", priRpScpRtCmdtHdrVO.getSvcScpCd());

				
				velParam.put("prop_no", priRpScpRtCmdtHdrVO.getPropNo());
				velParam.put("amdt_seq", priRpScpRtCmdtHdrVO.getAmdtSeq());
				velParam.put("svc_scp_cd", priRpScpRtCmdtHdrVO.getSvcScpCd());
			}
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFARateProposalDBDAORsltPriRateHorizontalExcelChkVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtListHorizontalExcelVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
    }
    
    /****************************************************************************************/
	/* ESM_PRI_2060  Start       */
	/****************************************************************************************/
    
    /**
     * search Commodity Info.<br>
     * 
     * @param PriRpScpRtCmdtHdrVO vo
     * @return List<PriRpScpRtCmdtVO>
     * @exception DAOException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PriRpScpRtCmdtVO> searchPriRpScpRtCmdtList(PriRpScpRtCmdtHdrVO vo) throws DAOException,Exception {
    	DBRowSet dbRowset = null;
		List<PriRpScpRtCmdtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRsltPriRpScpRtCmdtRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriRpScpRtCmdtVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
    }
    
    /**
     * search Commodity Customer Info.<br>
     * 
     * @param PriRpScpRtCmdtHdrVO vo
     * @return List<PriRpScpRtActCustVO>
     * @exception DAOException
     */
    public List<PriRpScpRtActCustVO> searchPriRpScpRtActCustList(PriRpScpRtCmdtHdrVO vo) throws DAOException,Exception {
    	DBRowSet dbRowset = null;
		List<PriRpScpRtActCustVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFARateProposalDBDAORsltRsltPriRpScpRtActCustRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriRpScpRtActCustVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
    }
    
    /**
     * search Rout Info.<br>
     * 
     * @param PriRpScpRtCmdtHdrVO vo
     * @param String orgDestTpCd
     * @param String cmdtHdrSeq
     * @param String routSeq
     * @return List<PriRpScpRtRoutPntVO>
     * @exception DAOException
     */
    public List<PriRpScpRtRoutPntVO> searchPriRpScpRtRoutPntList(PriRpScpRtCmdtHdrVO vo, String orgDestTpCd, String cmdtHdrSeq, String routSeq ) throws DAOException,Exception {
    	DBRowSet dbRowset = null;
		List<PriRpScpRtRoutPntVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			param.put("cmdt_hdr_seq",cmdtHdrSeq);
			velParam.put("cmdt_hdr_seq",cmdtHdrSeq);
			param.put("org_dest_tp_cd", orgDestTpCd);
			velParam.put("org_dest_tp_cd", orgDestTpCd);
			param.put("rout_seq",routSeq);
			velParam.put("rout_seq",routSeq);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFARateProposalDBDAORsltRsltPriRpScpRtRoutPntRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriRpScpRtRoutPntVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
    }
    
    /**
     * search Rout Via Info.<br>
     * 
     * @param PriRpScpRtCmdtHdrVO vo
     * @param String routViaPortTpCd
     * @param String cmdtHdrSeq
     * @param String routSeq
     * @return List<PriRpScpRtRoutViaVO>
     * @exception DAOException
     */
    public List<PriRpScpRtRoutViaVO> searchPriRpScpRtRoutViaList(PriRpScpRtCmdtHdrVO vo, String routViaPortTpCd, String cmdtHdrSeq, String routSeq ) throws DAOException,Exception {
    	DBRowSet dbRowset = null;
		List<PriRpScpRtRoutViaVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			param.put("cmdt_hdr_seq",cmdtHdrSeq);
			velParam.put("cmdt_hdr_seq",cmdtHdrSeq);
			param.put("org_dest_tp_cd", routViaPortTpCd);
			velParam.put("org_dest_tp_cd", routViaPortTpCd);
			param.put("rout_seq",routSeq);
			velParam.put("rout_seq",routSeq);

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFARateProposalDBDAORsltRsltPriRpScpRtRoutViaRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriRpScpRtRoutViaVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
    }
    
    /**
     * search Rate Info.<br>
     * 
     * @param PriRpScpRtCmdtHdrVO vo
     * @param String cmdtHdrSeq
     * @param String routSeq
     * @param String prcCgoTpCd
     * @return List<PriRpScpRtVO>
     * @exception DAOException
     */
    public List<PriRpScpRtVO> searchPriRpScpRtList(PriRpScpRtCmdtHdrVO vo, String cmdtHdrSeq, String routSeq, String prcCgoTpCd) throws DAOException,Exception {
    	DBRowSet dbRowset = null;
		List<PriRpScpRtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("cmdt_hdr_seq",cmdtHdrSeq);
				velParam.put("cmdt_hdr_seq",cmdtHdrSeq);
				param.put("rout_seq",routSeq);
				velParam.put("rout_seq",routSeq);
				param.put("prc_cgo_tp_cd",prcCgoTpCd);
				velParam.put("prc_cgo_tp_cd",prcCgoTpCd);
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new RFARateProposalDBDAORsltPriRpScpRtRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriRpScpRtVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
    }
    
    /**
	 * rerive the max of Rout Seq<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchNextRoutSeq(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws DAOException {
		int nextSeq = -1;
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = priRpScpRtCmdtHdrVO.getColumnValues();
			param.putAll(mapVO);
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAOGetNextRoutSeqRSQL(), param, null);
			if (dbRowset != null && dbRowset.getRowCount() > 0 && dbRowset.next()) {
				nextSeq = dbRowset.getInt("next_seq");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return nextSeq;
	}
	
	/**
	 * Rate 데이터를 삭제한다.<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO vo
	 * @param String cgoTpCd
	 * @exception DAOException
	 */
	public void removeRateCascadeRt(PriRpScpRtCmdtRoutVO vo, String cgoTpCd) throws DAOException, Exception {
		
		
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = -1;
		
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			param.put("prc_cgo_tp_cd", cgoTpCd);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtForExlVODSQL(), param,
					velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to delete SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}
	
	/**
	 * Route Via 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCascadeRoutVia(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();
				
				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaDSQL(),
						delModels, velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Route Pnt 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCascadeRoutPnt(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntDSQL(),
						delModels, velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ROUT 데이터를 삭제한다.<br>
	 * 
	 * @param List<PriRpScpRtCmdtRoutVO> delModels
	 * @exception DAOException
	 */
	public void removeRateCascadeCmdtRout(List<PriRpScpRtCmdtRoutVO> delModels) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (delModels.size() > 0) {
				HashMap<String, Object> velParam = new HashMap<String, Object>();

				delCnt = sqlExe.executeBatch((ISQLTemplate) new RFARateProposalDBDAOPriRpScpCmdtRoutVODSQL(), delModels,
						velParam);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * RFA Commodity Route note정보를 PRC_PROG_STS_CD = 'I', SRC_INFO_CD = 'AD'로 수정합니다.<br>
	 * 
	 * @param PriRpScpRtCmdtRoutVO vo
	 * @exception DAOException
	 */
	public void modifyProposalScopeCmdtRouteRnote(PriRpScpRtCmdtRoutVO vo) throws DAOException, Exception {	
		Map<String, Object> param = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);


			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtRnoteVOXlsUSQL(), param,
					null);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Commodity Header 데이터를 생성한다.<br>
	 * 
	 * @param PriRpScpRtCmdtHdrVO vo
	 * @exception DAOException
	 */
	public void addRateCommodityHeaderForExcel(PriRpScpRtCmdtHdrVO vo) throws DAOException, Exception {
		
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtHdrVOForExlCSQL(), param,
                    velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
	}
	
	/**
	 * Commodity 데이터를 생성한다.<br>
	 * 
	 * @param PriRpScpRtCmdtVO vo
	 * @exception DAOException
	 */
	public void addRateCommodityForExcel(PriRpScpRtCmdtVO vo) throws DAOException, Exception {
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtCmdtForExlVOCSQL(), param,
                    velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
	}
	
	/**
	 * Actual Customer 데이터를 생성한다.<br>
	 * 
	 * @param PriRpScpRtActCustVO vo
	 * @exception DAOException
	 */
	public void addRateActualCustomerForExcel(PriRpScpRtActCustVO vo) throws DAOException, Exception {
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtActCustForExlCSQL(), param,
                    velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
	}
	
	/**
	 * Route Point 데이터를 생성한다.<br>
	 * 
	 * @param PriRpScpRtRoutPntVO vo
	 * @exception DAOException
	 */
	public void addRateRoutePointForExcel(PriRpScpRtRoutPntVO vo) throws DAOException, Exception {
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutPntForExlVOCSQL(), param,
                    velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
	}
	
	/**
	 * Route Via. 데이터를 생성한다.<br>
	 * 
	 * @param PriRpScpRtRoutViaVO vo
	 * @exception DAOException
	 */
	public void addRateRouteViaForExcel(PriRpScpRtRoutViaVO vo) throws DAOException, Exception {
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtRoutViaForExlVOCSQL(), param,
                    velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
	}
	
	/**
	 * Rate 데이터를 생성한다.<br>
	 * 
	 * @param PriRpScpRtVO vo
	 * @exception DAOException
	 */
	public void addRateForExcel(PriRpScpRtVO vo) throws DAOException, Exception {
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        try {
            Map<String, String> mapVO = vo.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

            SQLExecuter sqlExe = new SQLExecuter("");
            int result = sqlExe.executeUpdate((ISQLTemplate) new RFARateProposalDBDAOPriRpScpRtForExlVOCSQL(), param,
                    velParam);
            if (result == Statement.EXECUTE_FAILED) {
                throw new DAOException("Fail to insert SQL");
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
	}
	
	/**
	 * Retrieving BackEndJob's status value<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comBakEndJbVOs(String key) throws DAOException,Exception {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException e) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), e);
		} catch (SQLException e) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), e);
		} catch (InterruptedException e) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), e);
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
    
    /****************************************************************************************/
	/* ESM_PRI_2060   End       */
	/****************************************************************************************/
    
    //########### ESM_PRI_2022 2015.05.19 ADD START ############
    
    /**
     * Rate Guideline CMDT Header의 리스트를 조회한다.<br>
     * 2016.05.19 ADD(change method arg) : reference by searchRateCommodityHeaderList
     * @param PriRfaNoteConvCommVO priRfaNoteConvCommVO
     * @return List<RsltRtCmdtHdrListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtCmdtHdrListVO> searchRateCommodityHeaderForCnoteList(PriRfaNoteConvCommVO priRfaNoteConvCommVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtCmdtHdrListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRfaNoteConvCommVO != null) {
                Map<String, String> mapVO = priRfaNoteConvCommVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery(
                    (ISQLTemplate) new RFARateProposalDBDAORsltRtCmdtHdrListVORSQL(), param, velParam);
                                       
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCmdtHdrListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    
    /**
     * Rate Commodity Note 리스트를 조회한다.<br>
     * 2016.05.19 ADD(CMDT_HDR_SEQ Condition) : reference by RFARateProposalDBDAORsltRtCnoteListVORSQL
     * @param PriRfaNoteConvCommVO priRfaNoteConvCommVO
     * @return List<RsltRtCnoteListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltRtCnoteListVO> searchRateCommodityCnoteList(PriRfaNoteConvCommVO priRfaNoteConvCommVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltRtCnoteListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRfaNoteConvCommVO != null) {
                Map<String, String> mapVO = priRfaNoteConvCommVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltRtCommodityCnoteListRSQL(),
                    param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltRtCnoteListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }
    
    /**
     * Rate Commodity Note Conversion 리스트를 조회한다.<br>
     * 2016.05.19 ADD(NOTE_CONV_MAPG_ID Condition) : reference by RFARateProposalDBDAORsltCnoteNoteConvListRSQL
     * @param PriRfaNoteConvCommVO priRfaNoteConvCommVO
     * @return List<RsltCnoteNoteConvListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<RsltCnoteNoteConvListVO> searchRateCommodityNoteConvList(PriRfaNoteConvCommVO priRfaNoteConvCommVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<RsltCnoteNoteConvListVO> list = null;

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (priRfaNoteConvCommVO != null) {
                Map<String, String> mapVO = priRfaNoteConvCommVO.getColumnValues();

                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new RFARateProposalDBDAORsltCommodityNoteConvListRSQL(),
                    param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCnoteNoteConvListVO.class);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return list;
    }

    //########### ESM_PRI_2022 2015.05.19 ADD END ############
    
}