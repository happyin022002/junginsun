/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : SCRateProposalBCImpl.java
 *@FileTitle : Guideline MQC
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.basic;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.integration.SCRateProposalDBDAO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.InCostSimulationCheckRouteVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltAllRtListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltPriCostSimulationCheckRouteVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRateTpVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtCmdtListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtCmdtRoutListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtListHorizontalExcelVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtListVerticalExcelVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtRoutHdrListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.ScGlineCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.ScRtPropCmdtVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.ScRtPropRtVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.ViewAllRatesListPagingVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.ViewAllRatesListVO;
import com.clt.bizcommon.comm.Constants;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpGriGrpVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;
import com.clt.syscommon.common.table.PriSpScpRtActCustVO;
import com.clt.syscommon.common.table.PriSpScpRtCmdtHdrVO;
import com.clt.syscommon.common.table.PriSpScpRtCmdtRnoteVO;
import com.clt.syscommon.common.table.PriSpScpRtCmdtRoutVO;
import com.clt.syscommon.common.table.PriSpScpRtCmdtVO;
import com.clt.syscommon.common.table.PriSpScpRtCnoteVO;
import com.clt.syscommon.common.table.PriSpScpRtRoutDirVO;
import com.clt.syscommon.common.table.PriSpScpRtRoutPntVO;
import com.clt.syscommon.common.table.PriSpScpRtRoutViaVO;
import com.clt.syscommon.common.table.PriSpScpRtVO;

/**
 * SCGuideline Business Logic Basic Command implementation<br>
 * - Handling a biz logic about SCGuideline<br>
 * 
 * @author 
 * @see UI_PRI_0030EventResponse,SCRateProposalBC - refer to each DAO class
 * @since J2EE 1.4
 */

public class SCRateProposalBCImpl extends BasicCommandSupport implements SCRateProposalBC {

    // Database Access Object
    private transient SCRateProposalDBDAO dbDao = null;

    /**
     * Creating SCRateProposalBCImpl object<br>
     * Creating SCRateProposalDBDAO <br>
     */
    public SCRateProposalBCImpl() {
        dbDao = new SCRateProposalDBDAO();
    }

    /**
     * Retrieving datas for handling Rate Type radio button style.<br>
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
     * Retrieving style informations after CUD transactions<br>
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
     * Retrieving Rate's Commodity Group.<br>
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
     * Retrieving Rate Inquiry - Commodity Group<br>
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
     * Retrieving Rate History - Commodity Group
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
     * Retrieving Rate's Route information<br>
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
     * Retrieving Rate Inquiry - Route list.<br>
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
     * Retrieving Rate History - Route list
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
     * Retrieving Rate's Rate information.<br>
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
     * Retrieving Rate Inquiry - Rate information<br>
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
     * Retrieving Excel Download(Vertical)<br>
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
     * Retrieving Excel Download(Horizontal)<br>
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
     * Retrieving a list on Accept ALL screen<br>
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
     * Handling retrieving event for SCRateProposal screen<br>
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
     * Handling multi transaction of Commodity Group & related information<br>
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
     * Handling multi transaction of  Route & Rate data<br>
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

            if (deleteRtList.size() > 0) {
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

        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Accepting Actual Customer data<br>
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
                    priSpScpRtActCustVOs[i].setAcptDt(com.clt.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
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
     * Cancelling acceptance of Actual Customer data<br>
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
     * Accepting Rate data<br>
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
                    priSpScpRtVOs[i].setAcptDt(com.clt.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
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
     * Cancelling an acceptance of Rate data<br>
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
     * Cancelling an acceptance of Commodity Note data<br>
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
                    priSpScpRtCnoteVOs[i].setAcptDt(com.clt.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
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
     * Cancellation an acceptance of Commodity Note data<br>
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
     * Accepting Commodity data<br>
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
                    priSpScpRtCmdtVOs[i].setAcptDt(com.clt.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
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
     * Cancelling an acceptance of Commodity data<br>
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
     * Accepting Route Note data<br>
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
                    priSpScpRtCmdtRnoteVOs[i].setAcptDt(com.clt.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
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
     * Canclling an acceptance of Route Note data<br>
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
     * Accepting Direct Call data<br>
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
                    priSpScpRtRoutDirVOs[i].setAcptDt(com.clt.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
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
     * Cancelling an acceptance of Direct Call data<br>
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
     * Accepting Route Point data<br>
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
                    priSpScpRtRoutPntVOs[i].setAcptDt(com.clt.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
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
     * Cancelling an acceptance of Route Point data<br>
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
     * Handling multi events<br>
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
                    priSpScpRtRoutViaVOs[i].setAcptDt(com.clt.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
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
     * Handling multi event
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
     * Accepting all items of Rate<br>
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
                priSpScpRtVO.setAcptDt(com.clt.framework.component.util.DateTime.getFormatDate(new java.util.Date(),
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
     * Cancelling an acceptance about all items of rate<br>
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
     * Copying Guideline's data<br>
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
     * Checking whether Group Location, Group Commodity exists or not before copying Guideline <br>
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
     * Requesting Amendment<br>
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
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Copying S/C Proposal Rate information<br>
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
            // In case of legacy interface, prohibiting from copying note
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
            // In case of legacy interface, prohibiting from copying note
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
     * Applying GRI Calculation to Rate data<br>
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
     * Canceling an applied GRI Calculation<br>
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
     * Deleting all data with related Amend Seq No when canceling init status of main<br>
     * 
     * @param PriSpScpMnVO priSpScpMnVO
     * @exception EventException
     */
    public void removeProposalMain(PriSpScpMnVO priSpScpMnVO) throws EventException {
        try {
            if (priSpScpMnVO != null) {
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
     * Accepting aumatically when requesting S/C Proposal<br>
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
     * Canceling an acceptance of accepted data automatically when canceling a request of S/C Proposal<br>
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
     * Copying Guideline Rate to Proposal<br>
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
     * Changing an accepted data of main duration to "init" at one time when cancelling a rquest of main duration<br>
     * 
     * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalRequestCancel(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException {
        try {
            if (priSpScpMnVO != null) {
                priSpScpMnVO.setUpdUsrId(account.getUsr_id());
                
                dbDao.modifyProposalRtActCustReqCnl(priSpScpMnVO);
                dbDao.modifyProposalRtCmdtReqCnl(priSpScpMnVO);
                dbDao.modifyProposalRtCmdtRnoteReqCnl(priSpScpMnVO);
                dbDao.modifyProposalRtCnoteReqCnl(priSpScpMnVO);
                dbDao.modifyProposalRtReqCnl(priSpScpMnVO);
                dbDao.modifyProposalRtRoutDirReqCnl(priSpScpMnVO);
                dbDao.modifyProposalRtRoutPntReqCnl(priSpScpMnVO);
                dbDao.modifyProposalRtRoutViaReqCnl(priSpScpMnVO);
            }  
        } catch (DAOException ex) {
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
    }
    
    /**
     * Changing an accepted data of main duration to "init" at one time when cancelling a rquest of main duration.<br>
     * 
     * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalRequestCancelDirectCall(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException {
        try {
            if (priSpScpMnVO != null) {
                priSpScpMnVO.setUpdUsrId(account.getUsr_id());
                dbDao.modifyProposalRtRoutDirReqCnl(priSpScpMnVO);
            }
            
        } catch (DAOException ex) {
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
    }   

    /**
     * Checking whether loaded excel data is valid or not<br>
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
     * Saving loaded excel data on Sheet<br>
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
          
      } catch (DAOException ex) {
          log.error("err " + ex.toString(), ex);
          throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
      } catch (Exception ex) {
          log.error("err " + ex.toString(), ex);
          throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
      }
    }

    /**
     * Checking whether loaded excel data is valid or not<br>
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
     * Retrieving ScrateProposal View All Rate as paging<br>
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
     * Retrieving ScrateProposal View All Rate<br>
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
     * Retrieving route information on COST CM/OP PRE SIMULATION screen<br>
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
     * Modify a note style of next amend seq based on amend seq when updating <br>
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
    
    

    
    /****************************************************************************************/
	/* ESM_PRI_0099  BackEndJob Start       */
	/****************************************************************************************/
	
    /**
	 *  call backEndJob to Check SC Contract with Excel and get BackEndJob's Key<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS
	 * @param ArrayList<CodeInfo> termOrgCodeList
	 * @param ArrayList<CodeInfo> termDestCodeList
	 * @param ArrayList<CodeInfo> trspModCodeList
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */	
    public String checkRateExcelHorizontalBackEndJob(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS, ArrayList<CodeInfo> termOrgCodeList, ArrayList<CodeInfo> termDestCodeList, ArrayList<CodeInfo> trspModCodeList, SignOnUserAccount account) throws EventException {
    	SCRateProposalCheckRateExcelHorizontalBackEndJob backEndJob = new SCRateProposalCheckRateExcelHorizontalBackEndJob();
		backEndJob.setPriSpScpRtCmdtHdrVO(priSpScpRtCmdtHdrVO);
		backEndJob.setRsltRtListHorizontalExcelVO(rsltRtListHorizontalExcelVOS);
		backEndJob.setSignOnUserAccount(account);
		backEndJob.setTermOrg(termOrgCodeList);
		backEndJob.setTermDest(termDestCodeList);
		backEndJob.setTrspMod(trspModCodeList);
		
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "ESM_PRI_0099 - CHECK EXCEL");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
    
	/**
	 *  call backEndJob to Save SC Contract with Excel and get BackEndJob's Key<br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS
	 * @param ArrayList<CodeInfo> termOrgCodeList
	 * @param ArrayList<CodeInfo> termDestCodeList
	 * @param ArrayList<CodeInfo> trspModCodeList
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */	
    public String uploadRateExcelHorizontalBackEndJob(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS, ArrayList<CodeInfo> termOrgCodeList, ArrayList<CodeInfo> termDestCodeList, ArrayList<CodeInfo> trspModCodeList, SignOnUserAccount account) throws EventException {
		SCRateProposalUploadRateExcelHorizontalBackEndJob backEndJob = new SCRateProposalUploadRateExcelHorizontalBackEndJob();
		backEndJob.setPriSpScpRtCmdtHdrVO(priSpScpRtCmdtHdrVO);
		backEndJob.setRsltRtListHorizontalExcelVO(rsltRtListHorizontalExcelVOS);
		backEndJob.setSignOnUserAccount(account);
		backEndJob.setTermOrg(termOrgCodeList);
		backEndJob.setTermDest(termDestCodeList);
		backEndJob.setTrspMod(trspModCodeList);
		
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		try {
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "ESM_PRI_0099 - EXCEL UPLOAD");
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
    
    /**
	 * Check SC Contract with Excel <br>
	 * Only using in SCRateProposalUploadRateExcelHorizontalBackEndJob <br>
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS
	 * @param ArrayList<CodeInfo> termOrgCodeList
	 * @param ArrayList<CodeInfo> termDestCodeList
	 * @param ArrayList<CodeInfo> trspModCodeList
	 * @param SignOnUserAccount account
	 * @return List<RsltRtListHorizontalExcelVO>
	 * @exception EventException
	 */	
	public List<RsltRtListHorizontalExcelVO> checkRateExcelHorizontal(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS, ArrayList<CodeInfo> termOrgCodeList, ArrayList<CodeInfo> termDestCodeList, ArrayList<CodeInfo> trspModCodeList, SignOnUserAccount account) throws EventException {
		List<RsltRtListHorizontalExcelVO> 	returnVO 	= new ArrayList<RsltRtListHorizontalExcelVO>();
		
		try {
			int rowcnt = rsltRtListHorizontalExcelVOS.length;
			for(int i = 0; i < rowcnt; i++){
				returnVO.add(rsltRtListHorizontalExcelVOS[i]);
				String strType = rsltRtListHorizontalExcelVOS[i].getType();
				if(strType.equals("C") || strType.equals("U")){
					List<RsltRtListHorizontalExcelVO> resultVO = dbDao.chkPriRateExl(priSpScpRtCmdtHdrVO, rsltRtListHorizontalExcelVOS[i]);
					if(resultVO != null && resultVO.size() > 0){
						String strCmdt = resultVO.get(0).getChkPrcCmdtDefCd();
						String strCust = resultVO.get(0).getChkCustSeq();
						String strOrgCd = resultVO.get(0).getChkOrgRoutPntLocDefCd();
						String strOrgTerm = resultVO.get(0).getChkOrgRcvDeTermNm();
						String strOrgTrsp = resultVO.get(0).getChkOrgPrcTrspModNm();
						String strDestCd = resultVO.get(0).getChkDestRoutPntLocDefCd();
						String strDestTerm = resultVO.get(0).getChkDestRcvDeTermNm();
						String strDestTrsp = resultVO.get(0).getChkDestPrcTrspModNm();
						String strOrgVia = resultVO.get(0).getChkOrgRoutViaPortDefCd();
						String strDestVia = resultVO.get(0).getChkDestRoutViaPortDefCd();
						String strCmdtDup = resultVO.get(0).getChkPrcCmdtDefDup();
						String strOrgDestDup = resultVO.get(0).getChkOrgDestDup();
						String strCmdtHdrSeq = resultVO.get(0).getChkCmdtHdrSeq();
						String strRoutSeq = resultVO.get(0).getChkRoutSeq();
						String strOrgSemi = resultVO.get(0).getChkOrgSemi();
						String strDestSemi = resultVO.get(0).getChkDestSemi();
						
						returnVO.get(i).setChkPrcCmdtDefCd(strCmdt);
						returnVO.get(i).setChkCustSeq(strCust);
						returnVO.get(i).setChkOrgRoutPntLocDefCd(strOrgCd);
						returnVO.get(i).setChkOrgRcvDeTermNm(strOrgTerm);
						returnVO.get(i).setChkOrgPrcTrspModNm(strOrgTrsp);
						returnVO.get(i).setChkDestRoutPntLocDefCd(strDestCd);
						returnVO.get(i).setChkDestRcvDeTermNm(strDestTerm);
						returnVO.get(i).setChkDestPrcTrspModNm(strDestTrsp);
						returnVO.get(i).setChkOrgRoutViaPortDefCd(strOrgVia);
						returnVO.get(i).setChkDestRoutViaPortDefCd(strDestVia);
						returnVO.get(i).setChkPrcCmdtDefDup(strCmdtDup);
						returnVO.get(i).setChkOrgDestDup(strOrgDestDup);
						returnVO.get(i).setChkCmdtHdrSeq(strCmdtHdrSeq);
						returnVO.get(i).setChkRoutSeq(strRoutSeq);
						returnVO.get(i).setChkOrgSemi(strOrgSemi);
						returnVO.get(i).setChkDestSemi(strDestSemi);
					}
				} 

			}
			
			return returnVO;
			
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}
	
	
	/**
	 * Save SC Contract with Excel <br>
	 * Only using in SCRateProposalUploadRateExcelHorizontalBackEndJob <br>
	 * 
	 * 
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS
	 * @param ArrayList<CodeInfo> termOrgCodeList
	 * @param ArrayList<CodeInfo> termDestCodeList
	 * @param ArrayList<CodeInfo> trspModCodeList
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void uploadRateExcelHorizontal(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS, ArrayList<CodeInfo> termOrgCodeList, ArrayList<CodeInfo> termDestCodeList, ArrayList<CodeInfo> trspModCodeList, SignOnUserAccount account) throws EventException {
			 try {
				 
		         String strCreUsrId = account.getUsr_id();
		         String strUpdUsrId = account.getUsr_id();

				 List<PriSpScpRtCmdtRoutVO> d_H_routVoList 		= null;
				 List<PriSpScpRtCmdtHdrVO> 	d_cmdtHdrVoList 	= null;	
				 List<PriSpScpRtCmdtRoutVO> d_routVoList 		= null;
				 List<PriSpScpRtRoutDirVO> 	d_dcallVoList 	    = null;
			     
			     //----------------------------------------
			     //(1) INSERT
			     //----------------------------------------
			     
			     List<PriSpScpRtCmdtHdrVO> 	cmdtHdrVoList 	= null;
				 List<PriSpScpRtCmdtVO> 	cmdtVoList 		= null;
				 List<PriSpScpRtActCustVO> 	custVoList 		= null;
				 List<PriSpScpRtCmdtRoutVO> routVoList 		= null;
				 List<PriSpScpRtRoutPntVO> 	pntVoList 		= null;
				 List<PriSpScpRtRoutViaVO> 	viaVoList 		= null;
				 List<PriSpScpRtRoutDirVO> 	dcallVoList 	= null;
				 List<PriSpScpRtVO> 		rtVoList 		= null;
				 List<PriSpScpRtCnoteVO>      cnoteVoList 	= null;
				 List<PriSpScpRtCmdtRnoteVO>  rnoteVoList 	= null;
				 List<PriSpScpRtCmdtRnoteVO>  convVoList 	= null;

				 for (int i = 0; i < rsltRtListHorizontalExcelVOS.length; i++) {
					 
					 int delcnt    = 0;
				     int updatecnt = 0;
				     int insertcnt = 0;
				     int deletecnt = 0;
				     boolean skipRoute = false;
				     boolean skipUpdate = false;
				     
					 d_H_routVoList 	= new ArrayList<PriSpScpRtCmdtRoutVO>();
					 d_cmdtHdrVoList 	= new ArrayList<PriSpScpRtCmdtHdrVO>();	
					 d_routVoList 		= new ArrayList<PriSpScpRtCmdtRoutVO>();
					 d_dcallVoList 	    = new ArrayList<PriSpScpRtRoutDirVO>();
					 
					 cmdtHdrVoList 	= new ArrayList<PriSpScpRtCmdtHdrVO>();
					 cmdtVoList 	= new ArrayList<PriSpScpRtCmdtVO>();
					 custVoList 	= new ArrayList<PriSpScpRtActCustVO>();
					 routVoList 	= new ArrayList<PriSpScpRtCmdtRoutVO>();
					 pntVoList 		= new ArrayList<PriSpScpRtRoutPntVO>();
					 viaVoList 		= new ArrayList<PriSpScpRtRoutViaVO>();
					 dcallVoList 	= new ArrayList<PriSpScpRtRoutDirVO>();
					 rtVoList 		= new ArrayList<PriSpScpRtVO>();
					 cnoteVoList    = new ArrayList<PriSpScpRtCnoteVO>();
					 rnoteVoList    = new ArrayList<PriSpScpRtCmdtRnoteVO>();
					 convVoList     = new ArrayList<PriSpScpRtCmdtRnoteVO>();
					 
		             RsltRtListHorizontalExcelVO row = rsltRtListHorizontalExcelVOS[i];
		             String rowType = row.getType();
            
		             if(rowType.equals("U")){
	            		 // Type U인 경우, CGO TYPE이전까지 동일한 DATA가 수행된 적이 있으면 Rate 테이블을 제외하고 SKIP
			        	 for (int j = 0; j < i; j++) {
			        		 if (rsltRtListHorizontalExcelVOS[j].getType().equals(row.getType()) 
			        		  && rsltRtListHorizontalExcelVOS[j].getCmdtHdrSeq().equals(row.getCmdtHdrSeq())
			        		  && rsltRtListHorizontalExcelVOS[j].getRoutSeq().equals(row.getRoutSeq())
			        		  && rsltRtListHorizontalExcelVOS[j].getOrgRoutPntLocDefCd().equals(row.getOrgRoutPntLocDefCd())
			        		  && rsltRtListHorizontalExcelVOS[j].getOrgRcvDeTermNm().equals(row.getOrgRcvDeTermNm())
			        		  && rsltRtListHorizontalExcelVOS[j].getOrgPrcTrspModNm().equals(row.getOrgPrcTrspModNm())
			        		  && rsltRtListHorizontalExcelVOS[j].getOrgRoutViaPortDefCd().equals(row.getOrgRoutViaPortDefCd())
			        		  && rsltRtListHorizontalExcelVOS[j].getDestRoutViaPortDefCd().equals(row.getDestRoutViaPortDefCd())
			        		  && rsltRtListHorizontalExcelVOS[j].getDestRoutPntLocDefCd().equals(row.getDestRoutPntLocDefCd())
			        		  && rsltRtListHorizontalExcelVOS[j].getDestRcvDeTermNm().equals(row.getDestRcvDeTermNm())
			        		  && rsltRtListHorizontalExcelVOS[j].getDestPrcTrspModNm().equals(row.getDestPrcTrspModNm())
			        		  && rsltRtListHorizontalExcelVOS[j].getDirCallFlg().equals(row.getDirCallFlg())){
			        			 skipUpdate = true;
			        		 }
			        	 }
			        	 
		            	 delcnt++;
		            	 
		            	 //PRI_SP_SCP_RT, /PRI_SP_SCP_RT_ROUT_VIA, PRI_SP_SCP_RT_ROUT_PNT
		            	 if(!exsitsCmdtHdrRout(d_routVoList, row)) {
		            		 PriSpScpRtCmdtRoutVO rout = makeRoutForDel(row, priSpScpRtCmdtHdrVO);
			            	 d_routVoList.add(rout);
		            	 }
		            	 
		            	 //PRI_SP_SCP_RT_ROUT_DIR
		            	 if(!exsitsCmdtRoutForDirCall(d_dcallVoList, row)) {
		            		 PriSpScpRtRoutDirVO dir = makeDirForDel(row, priSpScpRtCmdtHdrVO);
			            	 d_dcallVoList.add(dir);
		            	 }
		            	 
		            	 //PRI_SP_SCP_RT_ACT_CUST, PRI_SP_SCP_RT_CMDT
		            	 if(!existsCmdtHdr(d_cmdtHdrVoList, row)) {
		            		 PriSpScpRtCmdtHdrVO cmdthdr = makeCmdtHdrForDel(row, priSpScpRtCmdtHdrVO);
			            	 d_cmdtHdrVoList.add(cmdthdr);
		            	 }
		            	 
		             } else if(rowType.equals("D")){
		            	 
		            	 delcnt++;
		            	 
		            	 //PRI_SP_SCP_RT, /PRI_SP_SCP_RT_ROUT_VIA, PRI_SP_SCP_RT_ROUT_PNT
		            	 if(!exsitsCmdtHdrRout(d_routVoList, row)) {
		            		 PriSpScpRtCmdtRoutVO rout = makeRoutForDel(row, priSpScpRtCmdtHdrVO);
			            	 d_routVoList.add(rout);
			            	 
			            	 if(priSpScpRtCmdtHdrVO.getAmdtSeq().equals("0")){
			            		 d_H_routVoList.add(rout);
			            	 }
		            	 }
		            	 
		            	 //PRI_SP_SCP_RT_ROUT_DIR
		            	 if(!exsitsCmdtRoutForDirCall(d_dcallVoList, row)) {
		            		 PriSpScpRtRoutDirVO dir = makeDirForDel(row, priSpScpRtCmdtHdrVO);
			            	 d_dcallVoList.add(dir);
		            	 }
		            	 
		            	 //PRI_SP_SCP_RT_ACT_CUST, PRI_SP_SCP_RT_CMDT
		            	 if(!existsCmdtHdr(d_cmdtHdrVoList, row)) {
		            		 PriSpScpRtCmdtHdrVO cmdthdr = makeCmdtHdrForDel(row, priSpScpRtCmdtHdrVO);
			            	 d_cmdtHdrVoList.add(cmdthdr);
		            	 }

		             }

		             if(rowType.equals("U")){

		            	 updatecnt++;
		            	 
		            	 makeCmdtDirCallForCreate(rowType, dcallVoList, row, priSpScpRtCmdtHdrVO, -1, -1, strCreUsrId, strUpdUsrId);
		            	 
		            	 makeLocForCreate(rowType, pntVoList, row, priSpScpRtCmdtHdrVO, "O", termOrgCodeList, termDestCodeList, trspModCodeList, -1, -1, strCreUsrId, strUpdUsrId);
		            	 
		            	 makeLocForCreate(rowType, pntVoList, row, priSpScpRtCmdtHdrVO, "D", termOrgCodeList, termDestCodeList, trspModCodeList, -1, -1, strCreUsrId, strUpdUsrId);
		            	 
		            	 makeViaLocForCreate(rowType, viaVoList, row, priSpScpRtCmdtHdrVO, "O", -1, -1, strCreUsrId, strUpdUsrId);
		            	 
		            	 makeViaLocForCreate(rowType, viaVoList, row, priSpScpRtCmdtHdrVO, "D", -1, -1, strCreUsrId, strUpdUsrId);
		            	 
		            	 makeRtForCreate(rowType, rtVoList, row, priSpScpRtCmdtHdrVO, -1, -1, strCreUsrId, strUpdUsrId);
		            	 
		             } else if(rowType.equals("D")){
		            	 
		            	 deletecnt++;
		            	 
		            	 makeCmdtDirCallForCreate(rowType, dcallVoList, row, priSpScpRtCmdtHdrVO, -1, -1, strCreUsrId, strUpdUsrId);
		            	 
		            	 makeLocForCreate(rowType, pntVoList, row, priSpScpRtCmdtHdrVO, "O", termOrgCodeList, termDestCodeList, trspModCodeList, -1, -1, strCreUsrId, strUpdUsrId);
		            	 
		            	 makeLocForCreate(rowType, pntVoList, row, priSpScpRtCmdtHdrVO, "D", termOrgCodeList, termDestCodeList, trspModCodeList, -1, -1, strCreUsrId, strUpdUsrId);
		            	 
		            	 makeViaLocForCreate(rowType, viaVoList, row, priSpScpRtCmdtHdrVO, "O", -1, -1, strCreUsrId, strUpdUsrId);
		            	 
		            	 makeViaLocForCreate(rowType, viaVoList, row, priSpScpRtCmdtHdrVO, "D", -1, -1, strCreUsrId, strUpdUsrId);
		            	 
		            	 makeRtForCreate(rowType, rtVoList, row, priSpScpRtCmdtHdrVO, -1, -1, strCreUsrId, strUpdUsrId);
		            	 
		             } else if(rowType.equals("C")){
		            	 
		            	 insertcnt++;

		            	 int nextCmdtHdrSeq = dbDao.searchNextCmdtHdrSeq(priSpScpRtCmdtHdrVO);
						 int nextRoutSeq    = 0;
		            	 
						 boolean isCmdtHdrSeq = false;
		            	 
						 //-----------------------
		            	 //2016.02.15
		            	 //(1) In Excel Info, when there is the same commodity code with type C, <<share the cmdtHdrSeq>>
		            	 String curPrcCmdtDefCd = row.getPrcCmdtDefCd();
		            	 String[] preCmdtInfo = findPrcCmdtDefCd(rsltRtListHorizontalExcelVOS, curPrcCmdtDefCd, i);
						 
		            	 if((row.getCmdtHdrSeq() == null || row.getCmdtHdrSeq().equals("")) && StringUtils.isEmpty(preCmdtInfo[0])){
		            		 nextCmdtHdrSeq++;
		            		 makeCmdtHdrForCreate(cmdtHdrVoList, row, priSpScpRtCmdtHdrVO, nextCmdtHdrSeq, strCreUsrId, strUpdUsrId);
		            	 } else {
		            		 if(!StringUtils.isEmpty(preCmdtInfo[1])){
		            			 nextCmdtHdrSeq = Integer.valueOf( preCmdtInfo[1] );
		            		 } else {
		            			 nextCmdtHdrSeq = Integer.valueOf(row.getCmdtHdrSeq()); 
		            		 }
		            		 isCmdtHdrSeq = true;
		            	 }
		            	 //------------------------
		            	 
		            	 if(!isCmdtHdrSeq){
		            		 makeCmdtForCreate(rowType, cmdtVoList, row, priSpScpRtCmdtHdrVO, nextCmdtHdrSeq, strCreUsrId, strUpdUsrId);
		            		 makeActCustForCreate(rowType, custVoList, row, priSpScpRtCmdtHdrVO, nextCmdtHdrSeq, strCreUsrId, strUpdUsrId);
		            	 } 
		            	 
		            	 if(row.getRoutSeq() == null || row.getRoutSeq().equals("")){
		            		 priSpScpRtCmdtHdrVO.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
		            		 nextRoutSeq = dbDao.searchNextRoutSeq(priSpScpRtCmdtHdrVO);
		            		 skipRoute = true;
		            		 
		            		 // Type C인 경우, 존재하는 ROUTE아래로 CGO TYPE만 다른 RATE를 넣는다. 
				        	 String existRoutSeq = "" ;
				        	 for (int j = 0; j < i; j++) {
				        		 if (rsltRtListHorizontalExcelVOS[j].getType().equals("C") 
				        		  && rsltRtListHorizontalExcelVOS[j].getCmdtHdrSeq().equals(String.valueOf(nextCmdtHdrSeq))
				        		  && rsltRtListHorizontalExcelVOS[j].getOrgRoutPntLocDefCd().equals(row.getOrgRoutPntLocDefCd())
				        		  && rsltRtListHorizontalExcelVOS[j].getOrgRcvDeTermNm().equals(row.getOrgRcvDeTermNm())
				        		  && rsltRtListHorizontalExcelVOS[j].getOrgPrcTrspModNm().equals(row.getOrgPrcTrspModNm())
				        		  && rsltRtListHorizontalExcelVOS[j].getOrgRoutViaPortDefCd().equals(row.getOrgRoutViaPortDefCd())
				        		  && rsltRtListHorizontalExcelVOS[j].getDestRoutViaPortDefCd().equals(row.getDestRoutViaPortDefCd())
				        		  && rsltRtListHorizontalExcelVOS[j].getDestRoutPntLocDefCd().equals(row.getDestRoutPntLocDefCd())
				        		  && rsltRtListHorizontalExcelVOS[j].getDestRcvDeTermNm().equals(row.getDestRcvDeTermNm())
				        		  && rsltRtListHorizontalExcelVOS[j].getDestPrcTrspModNm().equals(row.getDestPrcTrspModNm())
				        		  && rsltRtListHorizontalExcelVOS[j].getDirCallFlg().equals(row.getDirCallFlg())
				        		  && rsltRtListHorizontalExcelVOS[j].getCmdtNoteCopy().equals(row.getCmdtNoteCopy())
				        		  && !row.getRoutNoteCopy().equals("")
				        		  && rsltRtListHorizontalExcelVOS[j].getRoutNoteCopy().equals(row.getRoutNoteCopy())){
				        			 existRoutSeq = rsltRtListHorizontalExcelVOS[j].getRoutSeq();
				        			 nextRoutSeq = Integer.valueOf(existRoutSeq);
				        		 }
				        	 }
				        	 if(existRoutSeq == ""){
				        		 nextRoutSeq++;
				        		 skipRoute = false;
				        	 }
		            		 makeCmdtRoutForCreate(routVoList, row, priSpScpRtCmdtHdrVO, nextCmdtHdrSeq, nextRoutSeq, strCreUsrId, strUpdUsrId, cnoteVoList, rnoteVoList, convVoList);
		            	 } else {
		            		 nextRoutSeq = Integer.valueOf(row.getRoutSeq()); 
		            	 }

		            	 makeCmdtDirCallForCreate(rowType, dcallVoList, row, priSpScpRtCmdtHdrVO, nextCmdtHdrSeq, nextRoutSeq, strCreUsrId, strUpdUsrId);
		            	 
		            	 makeLocForCreate(rowType, pntVoList, row, priSpScpRtCmdtHdrVO, "O", termOrgCodeList, termDestCodeList, trspModCodeList, nextCmdtHdrSeq, nextRoutSeq, strCreUsrId, strUpdUsrId);
		            	 
		            	 makeLocForCreate(rowType, pntVoList, row, priSpScpRtCmdtHdrVO, "D", termOrgCodeList, termDestCodeList, trspModCodeList, nextCmdtHdrSeq, nextRoutSeq, strCreUsrId, strUpdUsrId);
		            	 
		            	 makeViaLocForCreate(rowType, viaVoList, row, priSpScpRtCmdtHdrVO, "O", nextCmdtHdrSeq, nextRoutSeq, strCreUsrId, strUpdUsrId);
		            	 
		            	 makeViaLocForCreate(rowType, viaVoList, row, priSpScpRtCmdtHdrVO, "D", nextCmdtHdrSeq, nextRoutSeq, strCreUsrId, strUpdUsrId);
		            	 
		            	 makeRtForCreate(rowType, rtVoList, row, priSpScpRtCmdtHdrVO, nextCmdtHdrSeq, nextRoutSeq, strCreUsrId, strUpdUsrId);
		            	 
		            	 //------------------------
		            	 //2016.02.15
		            	 //(1) In Excel Info, when there is the same commodity code with type C, <<share the cmdtHdrSeq>>
		            	 row.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
		            	 row.setRoutSeq(String.valueOf(nextRoutSeq));
		            	 //------------------------
		             }
		             
		             if((rowType.equals("U") || rowType.equals("D")) && delcnt > 0){

						 if(d_dcallVoList != null && d_dcallVoList.size() > 0){
							 dbDao.removeRateCascadeRoutDir(d_dcallVoList);
						 }
						 
						 if(d_routVoList != null && d_routVoList.size() > 0){
							 String cgoTpCd = rsltRtListHorizontalExcelVOS[i].getPrcCgoTpCd();
							 dbDao.removeRateCascadeRt(d_routVoList.get(0), cgoTpCd);
							 if(!skipUpdate){
								 dbDao.removeRateCascadeRoutVia(d_routVoList);
								 dbDao.removeRateCascadeRoutPnt(d_routVoList);
							 }
						 }
						 if(d_H_routVoList != null && d_H_routVoList.size() > 0){
							 dbDao.removeRateCascadeCmdtRout(d_H_routVoList);
						 }
						 
						 if(rowType.equals("D")){
							 d_routVoList.get(0).setUpdUsrId(account.getUpd_usr_id());
							 dbDao.modifyProposalScopeCmdtRouteRnote(d_routVoList.get(0));
						 }
					 }
		             
		             if(updatecnt > 0 || deletecnt > 0 || insertcnt > 0){

						 if (cmdtHdrVoList.size() > 0) {
							 dbDao.addRateCommodityHeaderForExcel(cmdtHdrVoList.get(0));
			             }
				         if (cmdtVoList.size() > 0) {
				             List<PriSpScpRtCmdtVO> bVoList = getBlankCmdtSeqCmdt(cmdtVoList);
				             for(int x = 0; x < cmdtVoList.size() ; x++){
				            	 String val = cmdtVoList.get(x).getCmdtSeq();
				            	 if(!StringUtils.isEmpty(val)){
				            		 dbDao.addRateCommodityForExcel(cmdtVoList.get(x));
				            	 }
							 }
				             if(bVoList.size() > 0){
				            	 for(int x = 0; x < bVoList.size() ; x++){
				            		 dbDao.addRateCommodityForExcel(bVoList.get(x));
					             } 
				             }
				         }
				         if (cnoteVoList.size()> 0) {
				        	 int copycount = 0 ;
				        	 for (int j = 0; j < i; j++) {
				        		 if (rsltRtListHorizontalExcelVOS[j].getType().equals("C") 
				        		  && rsltRtListHorizontalExcelVOS[j].getCmdtHdrSeq().equals(cnoteVoList.get(0).getCmdtHdrSeq())
				        		  && rsltRtListHorizontalExcelVOS[j].getCmdtNoteCopy().equals(cnoteVoList.get(0).getAcptUsrId())){
				        			 copycount++ ;
				        		 }
				        	 }	
				        	 if(copycount == 0){
					        	 dbDao.addRateCommodityNoteForExcel(cnoteVoList.get(0));
					        	 dbDao.addNoteConvForExcel(convVoList.get(0));
				        	 }
				         }
				         if (custVoList.size() > 0) {
				             for(int x = 0; x < custVoList.size() ; x++){
				            	 String val = custVoList.get(x).getCustSeq();
				            	 if(!StringUtils.isEmpty(val)){
				            		 dbDao.addRateActualCustomerForExcel(custVoList.get(x));
				            	 }
							 }
				         }
				         if (routVoList.size() > 0 && !skipRoute && !skipUpdate) {
				        	 dbDao.addRateCommodityRoute(routVoList);
			             }
				         if (rnoteVoList.size()> 0 && !skipRoute && !skipUpdate) {
				        	 dbDao.addRateRouteNoteForExcel(rnoteVoList.get(0));
				        	 dbDao.addNoteConvForExcel(rnoteVoList.get(0));
				        	 
				        	 //CMDT Note copy를 안했을 경우 해준다.
				        	 int copycount = 0 ;
				        	 for (int j = 0; j < i; j++) {
				        		 if (rsltRtListHorizontalExcelVOS[j].getType().equals("C") 
				        		  && rsltRtListHorizontalExcelVOS[j].getCmdtHdrSeq().equals(rnoteVoList.get(0).getCmdtHdrSeq())
				        		  && rsltRtListHorizontalExcelVOS[j].getCmdtNoteCopy().equals(rnoteVoList.get(0).getAcptUsrId())){
				        			 copycount++ ;
				        		 }
				        	 }	
				        	 if(copycount == 0){
				        		 rnoteVoList.get(0).setAcptOfcCd(null);
				        		 
				        		 PriSpScpRtCnoteVO cnotevo = new PriSpScpRtCnoteVO() ;
				        		 cnotevo.setPropNo(rnoteVoList.get(0).getPropNo());
				        		 cnotevo.setAmdtSeq(rnoteVoList.get(0).getAmdtSeq());
				        		 cnotevo.setSvcScpCd(rnoteVoList.get(0).getSvcScpCd());
				        		 cnotevo.setGenSpclRtTpCd(rnoteVoList.get(0).getGenSpclRtTpCd());
				        		 cnotevo.setCmdtHdrSeq(rnoteVoList.get(0).getCmdtHdrSeq());
				        		 cnotevo.setAcptUsrId(rnoteVoList.get(0).getAcptUsrId());
				        		 cnotevo.setCreUsrId(rnoteVoList.get(0).getCreUsrId());
				        		 cnotevo.setUpdUsrId(rnoteVoList.get(0).getUpdUsrId());
				        		 
					        	 dbDao.addRateCommodityNoteForExcel(cnotevo);
					        	 dbDao.addNoteConvForExcel(rnoteVoList.get(0));
				        	 }
				         }
				         if (pntVoList.size() > 0 && !skipRoute && !skipUpdate) {
				             List<PriSpScpRtRoutPntVO> bVoList = getBlankRoutPntSeqLocation(pntVoList);
				             for(int x = 0; x < pntVoList.size() ; x++){
				            	 String val = pntVoList.get(x).getRoutPntSeq();
				            	 if(!StringUtils.isEmpty(val)){
				            		 dbDao.addRateRoutePointForExcel(pntVoList.get(x));
				            	 }
							 }
				             if(bVoList.size() > 0){
				            	 for(int x = 0; x < bVoList.size() ; x++){
				            		 dbDao.addRateRoutePointForExcel(bVoList.get(x));
					             } 
				             }
				         }
				         if (viaVoList.size() > 0 && !skipRoute && !skipUpdate) {
				             List<PriSpScpRtRoutViaVO> bVoList = getBlankRoutViaSeqLocationVia(viaVoList);
				             for(int x = 0; x < viaVoList.size() ; x++){
				            	 String val = viaVoList.get(x).getRoutViaSeq();
				            	 if(!StringUtils.isEmpty(val)){
				            		 dbDao.addRateRouteViaForExcel(viaVoList.get(x));
				            	 }
							 }
				             if(bVoList.size() > 0){
				            	 for(int x = 0; x < bVoList.size() ; x++){
				            		 dbDao.addRateRouteViaForExcel(bVoList.get(x));
					             } 
				             }
				             
				         }
				         if (dcallVoList.size() > 0 && !skipRoute && !skipUpdate) {
				             dbDao.addRateRouteDirectCallForExcel(dcallVoList);
				         }
				         if (rtVoList.size() > 0) {
				        	 List<PriSpScpRtVO> bVoList = getBlankRtSeqRate(rtVoList);
				             for(int x = 0; x < rtVoList.size() ; x++){
				            	 String val = rtVoList.get(x).getRtSeq();
				            	 if(!StringUtils.isEmpty(val)){
				            		 dbDao.addRateForExcel(rtVoList.get(x));
				            	 }
							 }
				             if(bVoList.size() > 0){
				            	 for(int x = 0; x < bVoList.size() ; x++){
				            		 dbDao.addRateForExcel(bVoList.get(x));
					             } 
				             }
				         }
					 }
				 }
	        } catch (DAOException ex) {
	            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
	        } catch (Exception ex) {
	            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
	        }
	}
	
	/**
	 * before RowIdx, When there is the same commodity, share cmdt_hdr_seq
	 * 
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS
	 * @param String prcCmdtDefCd
	 * @param int RowIdx
	 * @return String[] ([0]:PrcCmdtDefCd, [1]:CmdtHdrSeq)
	 */
	private String[] findPrcCmdtDefCd(RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS, String prcCmdtDefCd, int RowIdx){
		String[] result = new String[2];
		if(rsltRtListHorizontalExcelVOS == null || rsltRtListHorizontalExcelVOS.length == 0 || RowIdx == 0) return result;
		for(int i = 0; i < RowIdx; i++){
			String tmpPrcCmdtDefCd = rsltRtListHorizontalExcelVOS[i].getPrcCmdtDefCd();
			String tmpCmdtHdrSeq = rsltRtListHorizontalExcelVOS[i].getCmdtHdrSeq();
			if(prcCmdtDefCd.equals(tmpPrcCmdtDefCd) && rsltRtListHorizontalExcelVOS[i].getType().equals("C")){
				result[0] = tmpPrcCmdtDefCd;
				result[1] = tmpCmdtHdrSeq;
				break;
			}
		}
		return result;
	}
	
	/** 
	 * return Object that cmdt_seq is null <br>
	 * @param List<PriSpScpRtCmdtVO> vo
	 * @return List<PriSpScpRtCmdtVO>	
	 */
	private List<PriSpScpRtCmdtVO> getBlankCmdtSeqCmdt(List<PriSpScpRtCmdtVO> vo){
		List<PriSpScpRtCmdtVO> rtnVo = new ArrayList<PriSpScpRtCmdtVO>();
		
		if(vo != null && vo.size() > 0){
			for(int i = 0; i < vo.size(); i++){
				String val = vo.get(i).getCmdtSeq();
				if(StringUtils.isEmpty(val)){
					rtnVo.add(vo.get(i));
				}
			}
		}
		
		return rtnVo;
	}
	
	
	/** 
	 * return Object that rout_pnt_seq is null <br>
	 * @param List<PriSpScpRtRoutPntVO> vo
	 * @return List<PriSpScpRtRoutPntVO>	
	 */
	private List<PriSpScpRtRoutPntVO> getBlankRoutPntSeqLocation(List<PriSpScpRtRoutPntVO> vo){
		List<PriSpScpRtRoutPntVO> rtnVo = new ArrayList<PriSpScpRtRoutPntVO>();
		
		if(vo != null && vo.size() > 0){
			for(int i = 0; i < vo.size(); i++){
				String val = vo.get(i).getRoutPntSeq();
				if(StringUtils.isEmpty(val)){
					rtnVo.add(vo.get(i));
				}
			}
		}
		
		return rtnVo;
	}

	/** 
	 * return Object that rout_via_seq is null <br>
	 * @param List<PriSpScpRtRoutViaVO> vo
	 * @return List<PriSpScpRtRoutViaVO>	
	 */
	private List<PriSpScpRtRoutViaVO> getBlankRoutViaSeqLocationVia(List<PriSpScpRtRoutViaVO> vo){
		List<PriSpScpRtRoutViaVO> rtnVo = new ArrayList<PriSpScpRtRoutViaVO>();
		
		if(vo != null && vo.size() > 0){
			for(int i = 0; i < vo.size(); i++){
				String val = vo.get(i).getRoutViaSeq();
				if(StringUtils.isEmpty(val)){
					rtnVo.add(vo.get(i));
				}
			}
		}
		return rtnVo;
	}
	
	/** 
	 * return Object that rt_seq is null <br>
	 * @param List<PriSpScpRtVO> vo
	 * @return List<PriSpScpRtVO>	
	 */
	private List<PriSpScpRtVO> getBlankRtSeqRate(List<PriSpScpRtVO> vo){
		List<PriSpScpRtVO> rtnVo = new ArrayList<PriSpScpRtVO>();
		
		if(vo != null && vo.size() > 0){
			for(int i = 0; i < vo.size(); i++){
				String val = vo.get(i).getRtSeq();
				if(StringUtils.isEmpty(val)){
					rtnVo.add(vo.get(i));
				}
			}
		}
		
		return rtnVo;
	}
		
	/** 
	 * check to exists Commdity header <br>
	 * @param List<PriSpScpRtCmdtHdrVO> d_cmdtHdrVoList
	 * @param RsltRtListHorizontalExcelVO row
	 * @return String	
	 */
	 private boolean existsCmdtHdr(List<PriSpScpRtCmdtHdrVO> d_cmdtHdrVoList, RsltRtListHorizontalExcelVO row){
		 boolean result = false;
		 
		 String strOrg = row.getCmdtHdrSeq();
		 
		 if(d_cmdtHdrVoList != null && d_cmdtHdrVoList.size() > 0){
			 for(int i = 0 ; i < d_cmdtHdrVoList.size(); i++){
				 String strTarget = d_cmdtHdrVoList.get(i).getCmdtHdrSeq();
				 if(strOrg.equals(strTarget)){
					 result = true;
					 break;
				 }
			 }
		 }
		 
		 return result;
	 }
	 /**
	  * get the true/false result <br>
	  * whether the parameter value(CmdtHdrSeq+RoutSeq) exists in List<PriSpScpRtCmdtRoutVO> <br>
	  * 
	  * @param List<PriSpScpRtCmdtRoutVO> d_dcallVoList
	  * @param RsltRtListHorizontalExcelVO row
	  * @return boolean
	  */
	 private boolean exsitsCmdtHdrRout(List<PriSpScpRtCmdtRoutVO> d_routVoList, RsltRtListHorizontalExcelVO row){
		 boolean result = false;
		 
		 String strOrg = row.getCmdtHdrSeq()+row.getRoutSeq();
		 
		 if(d_routVoList != null && d_routVoList.size() > 0){
			 for(int i = 0 ; i < d_routVoList.size(); i++){
				 String strTarget = d_routVoList.get(i).getCmdtHdrSeq()+d_routVoList.get(i).getRoutSeq();
				 if(strOrg.equals(strTarget)){
					 result = true;
					 break;
				 }
			 }
		 }
		 
		 return result;
	 }
	 /**
	  * get the true/false result <br>
	  * whether the parameter value(CmdtHdrSeq+RoutSeq) exists in List<PriSpScpRtRoutDirVO> <br>
	  * 
	  * @param List<PriSpScpRtRoutDirVO> d_dcallVoList
	  * @param RsltRtListHorizontalExcelVO row
	  * @return boolean
	  */	 
	 private boolean exsitsCmdtRoutForDirCall(List<PriSpScpRtRoutDirVO> d_dcallVoList, RsltRtListHorizontalExcelVO row){
		 boolean result = false;
		 
		 String strOrg = row.getCmdtHdrSeq()+row.getRoutSeq();
		 
		 if(d_dcallVoList != null && d_dcallVoList.size() > 0){
			 for(int i = 0 ; i < d_dcallVoList.size(); i++){
				 String strTarget = d_dcallVoList.get(i).getCmdtHdrSeq()+d_dcallVoList.get(i).getRoutSeq();
				 if(strOrg.equals(strTarget)){
					 result = true;
					 break;
				 }
			 }
		 }
		 
		 return result;
	 }
	 /**
	  * get the true/false result whether the parameter value exists in List<PriSpScpRtRoutPntVO> <br>
	  * 
	  * @param List<PriSpScpRtRoutPntVO> pntVoList
	  * @param String strLocTermTrspMod
	  * @return boolean
	  */
	 private boolean exsitsCmdtRoutLocTermTrspMod(List<PriSpScpRtRoutPntVO> pntVoList, String strLocTermTrspMod){
		 boolean result = false;
		 
		 if(pntVoList != null && pntVoList.size() > 0){
			 for(int i = 0 ; i < pntVoList.size(); i++){
				 String strTarget = pntVoList.get(i).getRoutPntLocDefCd()+pntVoList.get(i).getRcvDeTermCd()+pntVoList.get(i).getPrcTrspModCd();
				 if(strLocTermTrspMod.equals(strTarget)){
					 result = true;
					 break;
				 }
			 }
		 }
		 
		 return result;
	 }
	 /** 
	  * check to exists Commdity <br>
	  * isSame(true) -> if the same data exist, return true<br>
	  * isSame(false) -> if the no same data exist, return true<br>
	  * @param List<PriSpScpRtCmdtVO> vo
	  * @param String code
	  * @return boolean	
	  */
	 private boolean existsCmdt(List<PriSpScpRtCmdtVO> vo, String code){
		 boolean result = false;
		 
		 if(vo != null && vo.size() > 0){
			 for(int i = 0 ; i < vo.size(); i++){
				 String strTarget = vo.get(i).getPrcCmdtDefCd();
				 if(code.equals(strTarget)){
					 result = true;
					 break;
				 } 
			 }
		 }
		 
		 return result;
	 }
	 /** 
	  * check to exists Customer <br>
	  * @param List<PriSpScpRtActCustVO> vo
	  * @param String code
	  * @return boolean	
	  */
	 private boolean existsCust(List<PriSpScpRtActCustVO> vo, String code){
		 boolean result = false;
		 
		 if(vo != null && vo.size() > 0){
			 for(int i = 0 ; i < vo.size(); i++){
				 String strCntCd = vo.get(i).getCustCntCd();
				 String strCustSeq = vo.get(i).getCustSeq();
				 String strTarget = strCntCd+strCustSeq;
				 if(code.equals(strTarget)){
					 result = true;
					 break;
				 }
			 }
		 }
		 
		 return result;
	 }

	 /** 
	  * check to exists Rout Via <br>
	  * @param List<PriSpScpRtRoutViaVO> vo
	  * @param String code
	  * @return boolean	
	  */
	 private boolean existsLocationVia(List<PriSpScpRtRoutViaVO> vo, String code){
		 boolean result = false;
		 
		 if(vo != null && vo.size() > 0){
			 for(int i = 0 ; i < vo.size(); i++){
				 String strTarget = vo.get(i).getRoutViaPortDefCd();
				 if(code.equals(strTarget)){
					 result = true;
					 break;
				 }
			 }
		 }
		 
		 return result;
	 }
	 
	 
	 /** 
	  * check to exists Rate <br>
	  * @param List<PriSpScpRtVO> vo
	  * @param String code
	  * @return boolean	
	  */
	 private boolean existsRate(List<PriSpScpRtVO> vo, String code){
		 boolean result = false;
		 if(vo != null && vo.size() > 0){
			 for(int i = 0 ; i < vo.size(); i++){
				 String strRatUtCd = vo.get(i).getRatUtCd();
				 String strPrcCgoTpCd = vo.get(i).getPrcCgoTpCd();
				 String strPropFrtRtAmt = vo.get(i).getPropFrtRtAmt();
				 String strTarget = strRatUtCd+strPrcCgoTpCd+strPropFrtRtAmt;
				 if(code.equals(strTarget)){
					 result = true;
					 break;
				 }
			 }
		 }
		 
		 return result;
	 }
	 
	 /** 
	  * check Whether the Data of Current DB are AM <br>
	  * @param List<PriSpScpRtCmdtVO> vo
	  * @return boolean	
	  */
	 private boolean isAllAmendedInDataCmdt(List<PriSpScpRtCmdtVO> vo) {
		 boolean result = false;
		 
		 if(vo.size() > 0){
			 int cnt = 0;
			 for(int i = 0; i < vo.size(); i++){
				 String strVal = vo.get(i).getSrcInfoCd();
				 if(strVal != null && strVal.equals("AM")){
					 cnt++;
				 }
			 }
			 if(cnt > 0 && (cnt == vo.size())){
				 result = true;
			 }
		 }

		 return result;
		 
	 }
	 
	 /** 
	  * check Whether the Data of Current DB are AM <br>
	  * @param List<PriSpScpRtActCustVO> vo
	  * @return boolean	
	  */
	 private boolean isAllAmendedInDataCust(List<PriSpScpRtActCustVO> vo) {
		 boolean result = false;
		 
		 if(vo.size() > 0){
			 int cnt = 0;
			 for(int i = 0; i < vo.size(); i++){
				 String strVal = vo.get(i).getSrcInfoCd();
				 if(strVal != null && strVal.equals("AM")){
					 cnt++;
				 }
			 }
			 if(cnt > 0 && (cnt == vo.size())){
				 result = true;
			 }
		 }

		 return result;
		 
	 }
	 
	 /** 
	  * check Whether the Data of Current DB are AM <br>
	  * @param List<PriSpScpRtRoutPntVO> vo
	  * @return boolean	
	  */
	 private boolean isAllAmendedInDataLocation(List<PriSpScpRtRoutPntVO> vo) {
		 boolean result = false;
		 
		 if(vo.size() > 0){
			 int cnt = 0;
			 for(int i = 0; i < vo.size(); i++){
				 String strVal = vo.get(i).getSrcInfoCd();
				 if(strVal != null && strVal.equals("AM")){
					 cnt++;
				 }
			 }
			 if(cnt > 0 && (cnt == vo.size())){
				 result = true;
			 }
		 }

		 return result;
		 
	 }
	 
	 /** 
	  * check Whether the Data of Current DB are AM <br>
	  * @param List<PriSpScpRtRoutViaVO> vo
	  * @return boolean	
	  */
	 private boolean isAllAmendedInDataLocationVia(List<PriSpScpRtRoutViaVO> vo) {
		 boolean result = false;
		 
		 if(vo.size() > 0){
			 int cnt = 0;
			 for(int i = 0; i < vo.size(); i++){
				 String strVal = vo.get(i).getSrcInfoCd();
				 if(strVal != null && strVal.equals("AM")){
					 cnt++;
				 }
			 }
			 if(cnt > 0 && (cnt == vo.size())){
				 result = true;
			 }
		 }

		 return result;
		 
	 }
	 
	 /** 
	  * check Whether the Data of Current DB are AM <br>
	  * @param List<PriSpScpRtVO> vo
	  * @return boolean	
	  */
	 private boolean isAllAmendedInDataRate(List<PriSpScpRtVO> vo) {
		 boolean result = false;
		 
		 if(vo.size() > 0){
			 int cnt = 0;
			 for(int i = 0; i < vo.size(); i++){
				 String strVal = vo.get(i).getSrcInfoCd();
				 if(strVal != null && strVal.equals("AM")){
					 cnt++;
				 }
			 }
			 if(cnt > 0 && (cnt == vo.size())){
				 result = true;
			 }
		 }

		 return result;
		 
	 }
	 

	 
	 /** 
	  * change to exists Commdity <br>
	  * @param List<PriSpScpRtCmdtVO> voList
	  * @param  PriSpScpRtCmdtVO vo
	  */
	 private void changeSameCmdt(List<PriSpScpRtCmdtVO> voList, PriSpScpRtCmdtVO vo){

		 if(voList != null && voList.size() > 0){
			 for(int i = 0 ; i < voList.size(); i++){
				 String strCd = vo.getPrcCmdtDefCd();
				 String strTarget = voList.get(i).getPrcCmdtDefCd();
				 if(strCd.equals(strTarget)){
					 voList.set(i, vo);
					 break;
				 }
			 }
		 }

	 }
	 
	 /** 
	  * change to exists Customer <br>
	  * @param List<PriSpScpRtActCustVO> voList
	  * @param  PriSpScpRtActCustVO vo
	  */
	 private void changeSameCust(List<PriSpScpRtActCustVO> voList, PriSpScpRtActCustVO vo){
		 
		 if(voList != null && voList.size() > 0){
			 for(int i = 0 ; i < voList.size(); i++){
				 
				 String strOCntCd = vo.getCustCntCd();
				 String strOCustSeq = vo.getCustSeq();
				 String strCd = strOCntCd+strOCustSeq;
				 
				 String strCntCd = voList.get(i).getCustCntCd();
				 String strCustSeq = voList.get(i).getCustSeq();
				 String strTarget = strCntCd+strCustSeq;
				 if(strCd.equals(strTarget)){
					 voList.set(i, vo);
				 }
			 }
		 }
		 
	 }

	 /** 
	  * change to exists Rout <br>
	  * @param List<PriSpScpRtRoutPntVO> voList
	  * @param  PriSpScpRtRoutPntVO vo
	  */
	 private void changeSameLocation(List<PriSpScpRtRoutPntVO> voList, PriSpScpRtRoutPntVO vo){

		 if(voList != null && voList.size() > 0){
			 for(int i = 0 ; i < voList.size(); i++){
				 String strCd = vo.getRoutPntLocDefCd();
				 String strTarget = voList.get(i).getRoutPntLocDefCd();
				 if(strCd.equals(strTarget)){
					 voList.set(i, vo);
					 break;
				 }
			 }
		 }

	 }
	 
	 /** 
	  * change to exists Rout Via <br>
	  * @param List<PriSpScpRtRoutViaVO> voList
	  * @param  PriSpScpRtRoutViaVO vo
	  */
	 private void changeSameLocationVia(List<PriSpScpRtRoutViaVO> voList, PriSpScpRtRoutViaVO vo){

		 if(voList != null && voList.size() > 0){
			 for(int i = 0 ; i < voList.size(); i++){
				 String strCd = vo.getRoutViaPortDefCd();
				 String strTarget = voList.get(i).getRoutViaPortDefCd();
				 if(strCd.equals(strTarget)){
					 voList.set(i, vo);
					 break;
				 }
			 }
		 }

	 }

	 /** 
	  * change to exists Rate <br>
	  * @param List<PriSpScpRtVO> voList
	  * @param  PriSpScpRtVO vo
	  */
	 private void changeSameRate(List<PriSpScpRtVO> voList, PriSpScpRtVO vo){
		 
		 if(voList != null && voList.size() > 0){
			 for(int i = 0 ; i < voList.size(); i++){
				 
				 String strORatUtCd = vo.getRatUtCd();
				 String strOPrcCgoTpCd = vo.getPrcCgoTpCd();
				 String strOPropFrtRtAmt = vo.getPropFrtRtAmt();
				 String strCd = strORatUtCd+strOPrcCgoTpCd+strOPropFrtRtAmt;
				 
				 String strRatUtCd = voList.get(i).getRatUtCd();
				 String strPrcCgoTpCd = voList.get(i).getPrcCgoTpCd();
				 String strPropFrtRtAmt = voList.get(i).getPropFrtRtAmt();
				 String strTarget = strRatUtCd+strPrcCgoTpCd+strPropFrtRtAmt;
				 if(strCd.equals(strTarget)){
					 voList.set(i, vo);
				 }
			 }
		 }
		 
	 }
	 
	 /**
	  * make PriSpScpRtCmdtRoutVO for delete <br>
	  * 
	  * @param RsltRtListHorizontalExcelVO row : a row of the uploaded excel(target row)
	  * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO : the master data of contract(include with prop_no, amdt_seq etc...)
	  * @return PriSpScpRtCmdtRoutVO
	  */
	 private PriSpScpRtCmdtRoutVO makeRoutForDel(RsltRtListHorizontalExcelVO row, PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO){
		 
		 PriSpScpRtCmdtRoutVO vo = new PriSpScpRtCmdtRoutVO();
		 vo.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
		 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
		 vo.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
		 vo.setGenSpclRtTpCd(priSpScpRtCmdtHdrVO.getGenSpclRtTpCd());
		 vo.setCmdtHdrSeq(row.getCmdtHdrSeq());
		 vo.setRoutSeq(row.getRoutSeq());
    	 
    	 return vo;
	 }
	 /**
	  * make PriSpScpRtRoutDirVO for delete <br>
	  * 
	  * @param RsltRtListHorizontalExcelVO row : a row of the uploaded excel(target row)
	  * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO : the master data of contract(include with prop_no, amdt_seq etc...)
	  * @return PriSpScpRtRoutDirVO
	  */
	 private PriSpScpRtRoutDirVO makeDirForDel(RsltRtListHorizontalExcelVO row, PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO){
		 
		 PriSpScpRtRoutDirVO vo = new PriSpScpRtRoutDirVO();
		 vo.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
		 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
		 vo.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
		 vo.setGenSpclRtTpCd(priSpScpRtCmdtHdrVO.getGenSpclRtTpCd());
		 vo.setCmdtHdrSeq(row.getCmdtHdrSeq());
		 vo.setRoutSeq(row.getRoutSeq());
    	 
    	 return vo;
	 }
	 /**
	  * make PriSpScpRtCmdtHdrVO for delete <br>
	  * 
	  * @param RsltRtListHorizontalExcelVO row : a row of the uploaded excel(target row)
	  * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO : the master data of contract(include with prop_no, amdt_seq etc...)
	  * @return PriSpScpRtCmdtHdrVO
	  */
	 private PriSpScpRtCmdtHdrVO makeCmdtHdrForDel(RsltRtListHorizontalExcelVO row, PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO){
		 
		 PriSpScpRtCmdtHdrVO vo = new PriSpScpRtCmdtHdrVO();
		 vo.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
		 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
		 vo.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
		 vo.setGenSpclRtTpCd(priSpScpRtCmdtHdrVO.getGenSpclRtTpCd());
		 vo.setCmdtHdrSeq(row.getCmdtHdrSeq());

    	 return vo;
	 }
	 /**
	  * make PriSpScpRtCmdtHdrVO with RsltRtListHorizontalExcelVO and add it to List<PriSpScpRtCmdtHdrVO> <br>
	  * 
	  * @param List<PriSpScpRtCmdtHdrVO> cmdtHdrVoList : the result object to be created
	  * @param RsltRtListHorizontalExcelVO row : a row of the uploaded excel(target row)
	  * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO : the master data of contract(include with prop_no, amdt_seq etc...)
	  * @param int nextCmdtHdrSeq
	  * @param String strCreUsrId
	  * @param String strUpdUsrId
	  */
	 private void makeCmdtHdrForCreate(List<PriSpScpRtCmdtHdrVO> 	cmdtHdrVoList, RsltRtListHorizontalExcelVO row, PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, 
			      int nextCmdtHdrSeq, String strCreUsrId, String strUpdUsrId){
		 
		 PriSpScpRtCmdtHdrVO vo = new PriSpScpRtCmdtHdrVO();
		 vo.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
		 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
		 vo.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
		 vo.setGenSpclRtTpCd(priSpScpRtCmdtHdrVO.getGenSpclRtTpCd());
		 vo.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
		 vo.setBletDpSeq("");
		 vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
         vo.setCreUsrId(strCreUsrId);
         vo.setUpdUsrId(strUpdUsrId);
         cmdtHdrVoList.add(vo);
	 } 
	 
	 /**
	  * check the param value(SrcInfoCd) is the same code like NW <br>
	  * 
	  * @param String val : SrcInfoCd
	  * @exception boolean (true/false)
	  */
	 private boolean isSrcInfoNw(String val){
		 boolean result = false;
		 
		 if(val.equals("NW") || val.equals("PC") || val.equals("PM") || val.equals("GC") || val.equals("GM")){
			 result = true;
		 }
		 
		 return result;
	 }
	 
	 /**
	  * make PriSpScpRtCmdtVO with RsltRtListHorizontalExcelVO and add it to List<PriSpScpRtCmdtVO> <br>
	  * 
	  * @param String rowType
	  * @param List<PriSpScpRtCmdtVO> cmdtVoList : the result object to be created
	  * @param RsltRtListHorizontalExcelVO row : a row of the uploaded excel(target row)
	  * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO : the master data of contract(include with prop_no, amdt_seq etc...)
	  * @param int nextCmdtHdrSeq
	  * @param String strCreUsrId
	  * @param String strUpdUsrId
	  * @exception EventException
	  */
	 private void makeCmdtForCreate(String rowType, List<PriSpScpRtCmdtVO> cmdtVoList, RsltRtListHorizontalExcelVO row, PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, 
			                         int nextCmdtHdrSeq, String strCreUsrId, String strUpdUsrId) throws EventException {

		 
		 try {
			 //CUR CMDT LIST
			 List<PriSpScpRtCmdtVO> cTmpCmdtVoList = new ArrayList<PriSpScpRtCmdtVO>();
			 //get current info data to compare
			 List<PriSpScpRtCmdtVO> tVO            = new ArrayList<PriSpScpRtCmdtVO>();
			 //previous AmdtSeq's DB Info
			 List<PriSpScpRtCmdtVO> preDBVO        = new ArrayList<PriSpScpRtCmdtVO>();
			 //current AmdtSeq's DB Info
			 List<PriSpScpRtCmdtVO> curDBVO        = new ArrayList<PriSpScpRtCmdtVO>();
			 if(rowType.equals("U") || (rowType.equals("D") && !priSpScpRtCmdtHdrVO.getAmdtSeq().equals("0") )){
				 
				 tVO = dbDao.searchPriSpScpRtCmdtList(priSpScpRtCmdtHdrVO);
				 if(tVO.size() == 0){
					 return;
				 }
				 
				 preDBVO        = getCmdtInfoForAmdtSeq(tVO, priSpScpRtCmdtHdrVO.getAmdtSeq(), false);
				 curDBVO        = getCmdtInfoForAmdtSeq(tVO, priSpScpRtCmdtHdrVO.getAmdtSeq(), true);
				 
			 }
			 
			 //TYPE(C) OR TYPE(U) -> CREATE DATA WITH EXCEL
			 if(rowType.equals("U") || rowType.equals("C")){
				 
				 if( priSpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && (curDBVO == null || curDBVO.size() == 0) && rowType.equals("U") ){
					 return;
				 }
				 
				 String cmdtCds = row.getPrcCmdtDefCd();
				 if(cmdtCds != null && !cmdtCds.equals("")) {
					 String[] arrCmdtCd = cmdtCds.split(";");
					 if(arrCmdtCd.length > 0) {
						 
						 String txCmdtSeq = "";
						 if(rowType.equals("C") && row.getCmdtHdrSeq().equals("")){
							 txCmdtSeq = String.valueOf(nextCmdtHdrSeq);
				         } else {
				        	 txCmdtSeq = row.getCmdtHdrSeq();
				         }
					 
						 for(int i = 0; i < arrCmdtCd.length; i++) {

							 String strPrcCmdtDefCd = arrCmdtCd[i];
							 String strPrcCmdtTpCd = arrCmdtCd[i].length() == 5 ? "G" : "C";
					         
					         PriSpScpRtCmdtVO vo = new PriSpScpRtCmdtVO();
					         vo.setIbflag(rowType);
					         
					         vo.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
					         vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
					         vo.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
					         vo.setGenSpclRtTpCd(priSpScpRtCmdtHdrVO.getGenSpclRtTpCd());
					         vo.setCmdtHdrSeq(txCmdtSeq);
					         vo.setCmdtSeq("");
					         vo.setPrcCmdtTpCd(strPrcCmdtTpCd);
					         vo.setPrcCmdtDefCd(strPrcCmdtDefCd);
					         vo.setPrcProgStsCd("I");
					         vo.setSrcInfoCd("NW");	
					         vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
					         vo.setCreUsrId(strCreUsrId);
					         vo.setUpdUsrId(strUpdUsrId);
					         
					         if(rowType.equals("C")){
					        	 cmdtVoList.add(vo);
					         } else {
					        	 cTmpCmdtVoList.add(vo);
					         }
					         
						 }
					 }
				 }
			 } else if(rowType.equals("D")){
				 if( priSpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && rowType.equals("D") ){
					 return;
				 }

				 //TYPE(D) AND EXSITS DATA IN DB
				 if(curDBVO != null && curDBVO.size() > 0){
					 
					 for(int i = 0; i < curDBVO.size(); i++){
						 curDBVO.get(i).setIbflag(rowType);
						 curDBVO.get(i).setPrcProgStsCd("I");
						 curDBVO.get(i).setSrcInfoCd("AD");
						 curDBVO.get(i).setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
						 curDBVO.get(i).setCreUsrId(strCreUsrId);
						 curDBVO.get(i).setUpdUsrId(strUpdUsrId);
					 }
					 
					 cmdtVoList.addAll(curDBVO);
				 }
				 
			 }
			 
			 if(!priSpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && rowType.equals("U")){
				 
				 
				 if(curDBVO != null && curDBVO.size() > 0){
					 
					 if(curDBVO.size() != cTmpCmdtVoList.size()){
						 //------------
						 // current db row count != current(excel) row count
						 //------------
						 
						 //when current db codes(NW,AM) are equal with current data, use current db info
						 //when current data code are not equal with current db code -> already include in current data
						 //(1)
						 for(int i = 0; i < curDBVO.size(); i++){
							 String curDbCd       = curDBVO.get(i).getPrcCmdtDefCd();
							 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
							 String curDbPagerows = curDBVO.get(i).getPagerows();
							 for(int x = 0; x < cTmpCmdtVoList.size(); x++){
								 String curCd = cTmpCmdtVoList.get(x).getPrcCmdtDefCd();
								 if(curDbCd.equals(curCd) && ( isSrcInfoNw(curDbSrc) || curDbSrc.equals("AM") ) && StringUtils.isEmpty(curDbPagerows) ){
									 curDBVO.get(i).setPagerows("X");
									 PriSpScpRtCmdtVO vo = curDBVO.get(i);
									 changeSameCmdt(cTmpCmdtVoList, vo);
								 }
							 }
						 }
						 
						 int noUseCurDbCnt = getNoUseDataCntForVOCmdt(curDBVO);
						 int noUseCurCnt   = getNoUseDataCntForVOCmdt(cTmpCmdtVoList);
						 
						 boolean isAmendedAll1 = isAllAmendedInDataCmdt(curDBVO);
						 if(!isAmendedAll1){
							 //when there are some diffent codes
							 //different codes(NW) -> using current db code(with AD)
							 //different codes(AM) -> compare preDB
							 //                       current db code is different with previous db code and it's seq is same and there is no comparing current data
							 //						  	-->using previous db info(with AD)
							 //						  current db code is same with previous db code and it's seq is not same and there are comparing current datas
							 //                         -->using prevois db info
							 
							 for(int i = 0; i < curDBVO.size(); i++){
								 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
								 String curDbCd       = curDBVO.get(i).getPrcCmdtDefCd();
								 String curDbCmdtSeq  = curDBVO.get(i).getCmdtSeq();
								 String curDbPagerows = curDBVO.get(i).getPagerows();
								 if(StringUtils.isEmpty(curDbPagerows) && isSrcInfoNw(curDbSrc)){
									 curDBVO.get(i).setPagerows("X");
									 PriSpScpRtCmdtVO vo = curDBVO.get(i);
									 vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
									 vo.setPrcProgStsCd("I");
									 vo.setSrcInfoCd("AD");
									 cTmpCmdtVoList.add(vo);								 
								 } else if(StringUtils.isEmpty(curDbPagerows) && curDbSrc.equals("AM")){
									 if(preDBVO != null && preDBVO.size() > 0){
										 for(int x = 0; x < preDBVO.size(); x++){
											 String preDbCd       = preDBVO.get(x).getPrcCmdtDefCd();
											 String preDbCmdtSeq  = preDBVO.get(x).getCmdtSeq();
											 String preDbPagerows = preDBVO.get(x).getPagerows();
											 if( !curDbCd.equals(preDbCd) && curDbCmdtSeq.equals(preDbCmdtSeq) && noUseCurCnt == 0 && StringUtils.isEmpty(preDbPagerows)){
												 preDBVO.get(x).setPagerows("X");
												 PriSpScpRtCmdtVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
												 vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
												 vo.setPrcProgStsCd("I");
												 vo.setSrcInfoCd("AD");
												 changeSameCmdt(cTmpCmdtVoList, vo);
												 break;
												 
											 } else if( curDbCd.equals(preDbCd) && !curDbCmdtSeq.equals(preDbCmdtSeq) && noUseCurCnt != 0 && StringUtils.isEmpty(preDbPagerows)){
												 preDBVO.get(x).setPagerows("X");
												 curDBVO.get(i).setPagerows("X");
												 PriSpScpRtCmdtVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameCmdt(cTmpCmdtVoList, vo);
												 break;
												 
											 }
										 }
									 }
									 
								 }
							 }
							 
						 } else if(isAmendedAll1 && noUseCurDbCnt != 0){
							 //if(noUseCurDbCnt > 0 && noUseCurDbCnt == curDBVO.size()){
							 //when diffent codes are all, compare previous db and current data
							 
							 //previous data codes are same with current data code     -> use previous datas
							 //previous data codes are not same with current data code -> use previous datas(AD)
							 List<PriSpScpRtCmdtVO> tmpCmdt1 =  new ArrayList<PriSpScpRtCmdtVO>();
							 tmpCmdt1.addAll(cTmpCmdtVoList);
							 if(preDBVO != null && preDBVO.size() > 0){
								 for(int x = 0; x < preDBVO.size(); x++){
									 String preDbCd       = preDBVO.get(x).getPrcCmdtDefCd();

									 boolean isExists = existsCmdt(tmpCmdt1, preDbCd);
									 if(isExists){
										 for(int i = 0; i < tmpCmdt1.size(); i++){
											 String cd       = tmpCmdt1.get(i).getPrcCmdtDefCd();
											 if(preDbCd.equals(cd) && tmpCmdt1.get(i).getPagerows() == null){
												 preDBVO.get(x).setPagerows("X");
												 PriSpScpRtCmdtVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameCmdt(cTmpCmdtVoList, vo);
												 changeSameCmdt(tmpCmdt1, vo);
												 break;
											 }
										 }
										 continue;
									 } else {
										 
										 preDBVO.get(x).setPagerows("X");
										 PriSpScpRtCmdtVO vo = preDBVO.get(x);
										 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setPrcProgStsCd("I");
										 vo.setSrcInfoCd("AD");
										 cTmpCmdtVoList.add(vo);
										 continue;
									 }
									 
									 
								 } 
							 }
							 
						 }

						 
					 } else {
						 //------------
						 // current db row count == current(excel) row count
						 //------------
						 
						 //
						 //when current db srcInfoCd is all AM     -> remove current db and compare previous db (2)
						 //when current db srcInfoCd is not all AM -> (1) current db code(NW,AM) equal with current data
						 //													-> using current db info
						 //												  current db code(AD) do not equal with current data
						 //													-> using current db info
						 //                                           (3) current db code(AM) does not exists in current data
						 //(1)
						 
						 boolean isAmendedAll2 = isAllAmendedInDataCmdt(curDBVO);
						 
						 List<PriSpScpRtCmdtVO> tmpCmdt1 =  new ArrayList<PriSpScpRtCmdtVO>();
						 tmpCmdt1.addAll(cTmpCmdtVoList);
						 
						 for(int i = (curDBVO.size() - 1); i >= 0; i--){
							 String curDbCd       = curDBVO.get(i).getPrcCmdtDefCd();
							 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
							 String curDbPages    = curDBVO.get(i).getPagerows();
							 int    noCntInCur = 0;
							 boolean isExists = existsCmdt(tmpCmdt1, curDbCd);
							 if(isExists){
								 for(int x = 0; x < tmpCmdt1.size(); x++){

									 String cd       = tmpCmdt1.get(x).getPrcCmdtDefCd();
									 String pages    = tmpCmdt1.get(x).getPagerows();
									 if(!curDbCd.equals(cd) && curDbSrc.equals("AM")){
										 noCntInCur++;
										 break;
									 }

									 if(curDbCd.equals(cd) && StringUtils.isEmpty(pages)){
										 curDBVO.get(i).setPagerows("X");
										 PriSpScpRtCmdtVO vo = curDBVO.get(i);
										 changeSameCmdt(cTmpCmdtVoList, vo);
										 changeSameCmdt(tmpCmdt1, vo);
										 break;
									 }
								 }
							 } else {
								 
								 for(int x = 0; x < cTmpCmdtVoList.size(); x++){
									 String cd       = cTmpCmdtVoList.get(x).getPrcCmdtDefCd();
									 if(!curDbCd.equals(cd) && !curDbSrc.equals("AD")){
										 noCntInCur++;
										 break;
									 }
									 
									 if(!curDbCd.equals(cd) && StringUtils.isEmpty(curDbPages)){
										 curDBVO.get(i).setPagerows("X");
										 PriSpScpRtCmdtVO vo = curDBVO.get(i);
										 cTmpCmdtVoList.add(vo);
										 break;
									 }
								 }
							 }
							 
							 if(noCntInCur > 0 && curDbSrc.equals("AM") ){
								 curDBVO.remove(i);
							 }
						 	 
						 }
						 
						 int noUseCurDbCnt = getNoUseDataCntForVOCmdt(curDBVO);
						 int noUseCurCnt   = getNoUseDataCntForVOCmdt(cTmpCmdtVoList);
						 
						 //(2)
						 //compare preDB data with cur data
						 //when preDB code equal with cur data        -> use preDB Info
						 //when preDB code do not equal with cur data -> use preDB Info and srcInfoCd(AD)
						 if(isAmendedAll2){
							 if(preDBVO != null && preDBVO.size() > 0 && noUseCurCnt > 0){
								 
								 for(int x = 0; x < preDBVO.size(); x++){
									 String preDbCd       = preDBVO.get(x).getPrcCmdtDefCd();
									 
									 boolean isExists = existsCmdt(cTmpCmdtVoList, preDbCd);
									 if(isExists){
										 for(int i = 0; i < cTmpCmdtVoList.size(); i++){
											 String cd       = cTmpCmdtVoList.get(i).getPrcCmdtDefCd();
											 if(preDbCd.equals(cd) && cTmpCmdtVoList.get(i).getPagerows() == null){
												 preDBVO.get(x).setPagerows("X");
												 PriSpScpRtCmdtVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameCmdt(cTmpCmdtVoList, vo);
												 break;
											 }
										 }
										 continue;
									 } else {
										 
										 preDBVO.get(x).setPagerows("X");
										 PriSpScpRtCmdtVO vo = preDBVO.get(x);
										 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setPrcProgStsCd("I");
										 vo.setSrcInfoCd("AD");
										 cTmpCmdtVoList.add(vo);
										 continue;
									 }

								 } 
							 }
						 }
						 
						 //(3)
						 //no use code in current db code(AM) 1 and no use code in current data is 1
						 //change current db code to current code
						 noUseCurCnt   = getNoUseDataCntForVOCmdt(cTmpCmdtVoList);
						 if(noUseCurCnt > 0){
							 for(int x = 0; x < cTmpCmdtVoList.size(); x++){
								 String curDbPagerows   = cTmpCmdtVoList.get(x).getPagerows();
								 //change curDB to cur
								 //using new(=cur) info and only change to the CmdtHdrSeq and CmdtSeq in curDB 
								 if((curDbPagerows == null || curDbPagerows.equals("")) && ((noUseCurDbCnt >= 1 && noUseCurCnt >= 1) && (noUseCurDbCnt == noUseCurCnt))){
									 if(curDBVO != null && curDBVO.size() > 0){
										 for(int i = 0; i < curDBVO.size(); i++){
											 String curPagerows  = curDBVO.get(i).getPagerows();
											 String curSrcInfoCd = curDBVO.get(i).getSrcInfoCd();
											 if(StringUtils.isEmpty(curPagerows) && isSrcInfoNw(curSrcInfoCd)){
												 curDBVO.get(i).setPagerows("X");
												 cTmpCmdtVoList.get(x).setCmdtHdrSeq(curDBVO.get(i).getCmdtHdrSeq());
												 cTmpCmdtVoList.get(x).setCmdtSeq(curDBVO.get(i).getCmdtSeq());
												 cTmpCmdtVoList.get(x).setPrcProgStsCd("I");
												 cTmpCmdtVoList.get(x).setSrcInfoCd("AM");
												 break;
											 }

										 }
									 }
									 
								 }
							 }
						 }
						 
					 }
					 
					 
					 
					 
				 } //end if(curDBVO != null && curDBVO.size() > 0){
			 } // end if(rowType.equals("U")){
			 
			 cmdtVoList.addAll(cTmpCmdtVoList);
			 
		 } catch (DAOException ex) {
			 throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
         } catch (Exception ex) {
        	 throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
         }
		 
	 }
	 /**
	  * make PriSpScpRtActCustVO with RsltRtListHorizontalExcelVO and add it to List<PriSpScpRtActCustVO> <br>
	  * 
	  * @param String rowType
	  * @param List<PriSpScpRtActCustVO> custVoList : the result object to be created
	  * @param RsltRtListHorizontalExcelVO row : a row of the uploaded excel(target row)
	  * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO : the master data of contract(include with prop_no, amdt_seq etc...)
	  * @param int nextCmdtHdrSeq
	  * @param String strCreUsrId
	  * @param String strUpdUsrId
	  * @exception EventException
	  */
	 private void makeActCustForCreate(String rowType, List<PriSpScpRtActCustVO> custVoList, RsltRtListHorizontalExcelVO row, PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, 
			                            int nextCmdtHdrSeq, String strCreUsrId, String strUpdUsrId) throws EventException {

		 try {
			 //CUR LIST
			 List<PriSpScpRtActCustVO> curTmpVoList = new ArrayList<PriSpScpRtActCustVO>();
			 //get current info data to compare
			 List<PriSpScpRtActCustVO> tVO            = new ArrayList<PriSpScpRtActCustVO>();
			 //previous AmdtSeq's DB Info
			 List<PriSpScpRtActCustVO> preDBVO        = new ArrayList<PriSpScpRtActCustVO>();
			 //current AmdtSeq's DB Info
			 List<PriSpScpRtActCustVO> curDBVO        = new ArrayList<PriSpScpRtActCustVO>();
			 if(rowType.equals("U") || (rowType.equals("D") && !priSpScpRtCmdtHdrVO.getAmdtSeq().equals("0") )){
				 
				 tVO = dbDao.searchPriSpScpRtActCustList(priSpScpRtCmdtHdrVO);
				 if(tVO.size() == 0){
					 return;
				 }
				 
				 preDBVO        = getCustForAmdtSeq(tVO, priSpScpRtCmdtHdrVO.getAmdtSeq(), false);
				 curDBVO        = getCustForAmdtSeq(tVO, priSpScpRtCmdtHdrVO.getAmdtSeq(), true);
				 
			 }

			 //TYPE(C) OR TYPE(U) -> CREATE DATA WITH EXCEL
			 if(rowType.equals("U") || rowType.equals("C")){
				 
				 if( priSpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && (curDBVO == null || curDBVO.size() == 0) && rowType.equals("U") ){
					 return;
				 }
				 
				 String custs = row.getCustSeq();
				 if(custs != null && !custs.equals("")) {
					 String[] arrCust = custs.split(";");
					 if(arrCust.length > 0) {
						 
						 String txCmdtSeq = "";
						 if(rowType.equals("C") && row.getCmdtHdrSeq().equals("")){
							 txCmdtSeq = String.valueOf(nextCmdtHdrSeq);
				         } else {
				        	 txCmdtSeq = row.getCmdtHdrSeq();
				         }
					 
						 for(int i = 0; i < arrCust.length; i++) {

							 
					         String strCustCntCd = arrCust[i].substring(0,2);
							 String strCustSeq = arrCust[i].substring(2);
					         
							 PriSpScpRtActCustVO vo = new PriSpScpRtActCustVO();
							 vo.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
					         vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
					         vo.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
					         vo.setGenSpclRtTpCd(priSpScpRtCmdtHdrVO.getGenSpclRtTpCd());
					         
					         vo.setCmdtHdrSeq(txCmdtSeq);
					         
			                 vo.setActCustSeq("");
			                 vo.setCustCntCd(strCustCntCd);
			                 vo.setCustSeq(strCustSeq);
			                 vo.setPrcProgStsCd("I");
			                 vo.setSrcInfoCd("NW");	
			                 vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
			                 vo.setCreUsrId(strCreUsrId);
			                 vo.setUpdUsrId(strUpdUsrId);
					         
					         
					         if(rowType.equals("C")){
					        	 custVoList.add(vo);
					         } else {
					        	 curTmpVoList.add(vo);
					         }
					         
						 }
					 }
				 }
			 } else if(rowType.equals("D")){
				 
				 if( priSpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && rowType.equals("D") ){
					 return;
				 }
				 
				 //TYPE(D) AND EXSITS DATA IN DB
				 if(curDBVO != null && curDBVO.size() > 0){
					 
					 for(int i = 0; i < curDBVO.size(); i++){
						 curDBVO.get(i).setIbflag(rowType);
						 curDBVO.get(i).setPrcProgStsCd("I");
						 curDBVO.get(i).setSrcInfoCd("AD");
						 curDBVO.get(i).setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
						 curDBVO.get(i).setCreUsrId(strCreUsrId);
						 curDBVO.get(i).setUpdUsrId(strUpdUsrId);
					 }
					 
					 custVoList.addAll(curDBVO);
				 }
				 
			 }
			 
			 if(!priSpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && rowType.equals("U")){
				 if(curDBVO != null && curDBVO.size() > 0){
					 
					 if(curDBVO.size() != curTmpVoList.size()){
						 //------------
						 // current db row count != current(excel) row count
						 //------------
						 
						 //when current db codes(NW,AM) are equal with current data, use current db info
						 //when current data code are not equal with current db code -> already include in current data
						 //(1)
						 for(int i = 0; i < curDBVO.size(); i++){
							 String curDbCustCntCd= curDBVO.get(i).getCustCntCd();
							 String curDbCustSeq  = curDBVO.get(i).getCustSeq();
							 String curDbCd       = curDbCustCntCd + curDbCustSeq;
							 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
							 String curDbPagerows = curDBVO.get(i).getPagerows();
							 for(int x = 0; x < curTmpVoList.size(); x++){
								 String curCustCntCd = curTmpVoList.get(x).getCustCntCd();
								 String curCustSeq   = curTmpVoList.get(x).getCustSeq();
								 String curCd        = curCustCntCd + curCustSeq;
								 if(curDbCd.equals(curCd) && ( isSrcInfoNw(curDbSrc) || curDbSrc.equals("AM") ) && StringUtils.isEmpty(curDbPagerows)){
									 curDBVO.get(i).setPagerows("X");
									 PriSpScpRtActCustVO vo = curDBVO.get(i);
									 changeSameCust(curTmpVoList, vo);
								 }
							 }
						 }
						 
						 int noUseCurDbCnt = getNoUseDataCntForVOCust(curDBVO);
						 int noUseCurCnt   = getNoUseDataCntForVOCust(curTmpVoList);
						 
						 boolean isAmendedAll1 = isAllAmendedInDataCust(curDBVO);
						 if(!isAmendedAll1){
							 //when there are some diffent codes
							 
							 //different codes(NW) -> using current db code(with AD)
							 //different codes(AM) -> compare preDB
							 //                       current db code is different with previous db code and it's seq is same and there is no comparing current data
							 //						  	-->using previous db info(with AD)
							 //						  current db code is same with previous db code and it's seq is not same and there are comparing current datas
							 //                         -->using prevois db info
							 for(int i = 0; i < curDBVO.size(); i++){
								 String curDbSrc        = curDBVO.get(i).getSrcInfoCd();
								 String curDbCustCntCd  = curDBVO.get(i).getCustCntCd();
								 String curDbCustSeq    = curDBVO.get(i).getCustSeq();
								 String curDbCd         = curDbCustCntCd + curDbCustSeq;
								 String curDbActCustSeq = curDBVO.get(i).getActCustSeq();
								 String curDbPagerows   = curDBVO.get(i).getPagerows();
								 if(StringUtils.isEmpty(curDbPagerows) && isSrcInfoNw(curDbSrc)){
									 curDBVO.get(i).setPagerows("X");
									 PriSpScpRtActCustVO vo = curDBVO.get(i);
									 vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
									 vo.setPrcProgStsCd("I");
									 vo.setSrcInfoCd("AD");
									 curTmpVoList.add(vo);								 
								 } else if(StringUtils.isEmpty(curDbPagerows) && curDbSrc.equals("AM")){
									 if(preDBVO != null && preDBVO.size() > 0){
										 for(int x = 0; x < preDBVO.size(); x++){
											 String preDbCustCntCd   = preDBVO.get(x).getCustCntCd();
											 String preDbCustSeq     = preDBVO.get(x).getCustSeq();
											 String preDbCd          = preDbCustCntCd + preDbCustSeq;
											 String preDbActCustSeq  = preDBVO.get(x).getActCustSeq();
											 String preDbPagerows    = preDBVO.get(x).getPagerows();
											 if( !curDbCd.equals(preDbCd) && curDbActCustSeq.equals(preDbActCustSeq) && noUseCurCnt == 0 && StringUtils.isEmpty(preDbPagerows)){
												 preDBVO.get(x).setPagerows("X");
												 PriSpScpRtActCustVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
												 vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
												 vo.setPrcProgStsCd("I");
												 vo.setSrcInfoCd("AD");
												 changeSameCust(curTmpVoList, vo);
												 break;
												 
											 } else if( curDbCd.equals(preDbCd) && !curDbActCustSeq.equals(preDbActCustSeq) && noUseCurCnt != 0 && StringUtils.isEmpty(preDbPagerows)){
												 preDBVO.get(x).setPagerows("X");
												 curDBVO.get(i).setPagerows("X");
												 PriSpScpRtActCustVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameCust(curTmpVoList, vo);
												 break;
												 
											 }
										 }
									 }
									 
								 }
							 }
							 
						 } else if(isAmendedAll1 && noUseCurDbCnt != 0){
							 //when diffent codes are all, compare previous db and current data
							 
							 //previous data codes are same with current data code     -> use previous datas
							 //previous data codes are not same with current data code -> use previous datas(AD)
							 List<PriSpScpRtActCustVO> tmpCmdt1 =  new ArrayList<PriSpScpRtActCustVO>();
							 tmpCmdt1.addAll(curTmpVoList);
							 if(preDBVO != null && preDBVO.size() > 0){
								 for(int x = 0; x < preDBVO.size(); x++){
									 String preDbCustCntCd   = preDBVO.get(x).getCustCntCd();
									 String preDbCustSeq     = preDBVO.get(x).getCustSeq();
									 String preDbCd          = preDbCustCntCd + preDbCustSeq;
									 
									 boolean isExists = existsCust(tmpCmdt1, preDbCd);
									 if(isExists){
										 for(int i = 0; i < tmpCmdt1.size(); i++){
											 
											 String curCustCntCd  = tmpCmdt1.get(i).getCustCntCd();
											 String curCustSeq    = tmpCmdt1.get(i).getCustSeq();
											 String cd            = curCustCntCd + curCustSeq;
											 
											 if(preDbCd.equals(cd) && tmpCmdt1.get(i).getPagerows() == null){
												 preDBVO.get(x).setPagerows("X");
												 PriSpScpRtActCustVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameCust(curTmpVoList, vo);
												 changeSameCust(tmpCmdt1, vo);
												 break;
											 }
										 }
										 continue;
									 } else {
										 
										 preDBVO.get(x).setPagerows("X");
										 PriSpScpRtActCustVO vo = preDBVO.get(x);
										 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setPrcProgStsCd("I");
										 vo.setSrcInfoCd("AD");
										 curTmpVoList.add(vo);
										 continue;
									 }
									 
									 
								 } 
							 }
							 
						 }

						 
					 } else {
						 //------------
						 // current db row count == current(excel) row count
						 //------------
						 
						 //
						 //when current db srcInfoCd is all AM     -> remove current db and compare previous db (2)
						 //when current db srcInfoCd is not all AM -> (1) current db code(NW,AM) equal with current data
						 //													-> using current db info
						 //												  current db code(AD) do not equal with current data
						 //													-> using current db info
						 //                                           (3) current db code(AM) does not exists in current data
						 //(1)
						 
						 boolean isAmendedAll2 = isAllAmendedInDataCust(curDBVO);
						 
						 List<PriSpScpRtActCustVO> tmpCmdt1 =  new ArrayList<PriSpScpRtActCustVO>();
						 tmpCmdt1.addAll(curTmpVoList);
						 
						 for(int i = (curDBVO.size() - 1); i >= 0; i--){

							 String curDbCustCntCd  = curDBVO.get(i).getCustCntCd();
							 String curDbCustSeq    = curDBVO.get(i).getCustSeq();
							 String curDbCd         = curDbCustCntCd + curDbCustSeq;
							 String curDbSrc        = curDBVO.get(i).getSrcInfoCd();
							 String curDbPages      = curDBVO.get(i).getPagerows();
							 int    noCntInCur = 0;
							 boolean isExists = existsCust(tmpCmdt1, curDbCd);
							 if(isExists){
								 for(int x = 0; x < tmpCmdt1.size(); x++){
									 String curCustCntCd  = tmpCmdt1.get(x).getCustCntCd();
									 String curCustSeq    = tmpCmdt1.get(x).getCustSeq();
									 String cd            = curCustCntCd + curCustSeq;
									 
									 String pages    = tmpCmdt1.get(x).getPagerows();
									 if(!curDbCd.equals(cd) && curDbSrc.equals("AM")){
										 noCntInCur++;
										 break;
									 }

									 if(curDbCd.equals(cd) && StringUtils.isEmpty(pages)){
										 curDBVO.get(i).setPagerows("X");
										 PriSpScpRtActCustVO vo = curDBVO.get(i);
										 changeSameCust(curTmpVoList, vo);
										 changeSameCust(tmpCmdt1, vo);
										 break;
									 }
								 }
							 } else {
								 
								 for(int x = 0; x < curTmpVoList.size(); x++){
									 String curCustCntCd  = curTmpVoList.get(x).getCustCntCd();
									 String curCustSeq    = curTmpVoList.get(x).getCustSeq();
									 String cd            = curCustCntCd + curCustSeq;
									 
									 if(!curDbCd.equals(cd) && !curDbSrc.equals("AD")){
										 noCntInCur++;
										 break;
									 }
									 
									 if(!curDbCd.equals(cd) && StringUtils.isEmpty(curDbPages)){
										 curDBVO.get(i).setPagerows("X");
										 PriSpScpRtActCustVO vo = curDBVO.get(i);
										 curTmpVoList.add(vo);
										 break;
									 }
								 }
							 }
							 
							 if(noCntInCur > 0 && curDbSrc.equals("AM") ){
								 curDBVO.remove(i);
							 }
						 	 
						 }
						 
						 int noUseCurDbCnt = getNoUseDataCntForVOCust(curDBVO);
						 int noUseCurCnt   = getNoUseDataCntForVOCust(curTmpVoList);
						 
						 //(2)
						 //compare preDB data with cur data
						 //when preDB code equal with cur data        -> use preDB Info
						 //when preDB code do not equal with cur data -> use preDB Info and srcInfoCd(AD)
						 if(isAmendedAll2){
							 if(preDBVO != null && preDBVO.size() > 0 && noUseCurCnt > 0){
								 for(int x = 0; x < preDBVO.size(); x++){
									 String preDbCustCntCd   = preDBVO.get(x).getCustCntCd();
									 String preDbCustSeq     = preDBVO.get(x).getCustSeq();
									 String preDbCd          = preDbCustCntCd + preDbCustSeq;
									 
									 boolean isExists = existsCust(curTmpVoList, preDbCd);
									 if(isExists){
										 for(int i = 0; i < curTmpVoList.size(); i++){
											 String curCustCntCd   = curTmpVoList.get(i).getCustCntCd();
											 String curCustSeq     = curTmpVoList.get(i).getCustSeq();
											 String cd             = curCustCntCd + curCustSeq;
											 
											 if(preDbCd.equals(cd) && curTmpVoList.get(i).getPagerows() == null){
												 preDBVO.get(x).setPagerows("X");
												 PriSpScpRtActCustVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameCust(curTmpVoList, vo);
												 break;
											 }
										 }
										 continue;
									 } else {
										 
										 preDBVO.get(x).setPagerows("X");
										 PriSpScpRtActCustVO vo = preDBVO.get(x);
										 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setPrcProgStsCd("I");
										 vo.setSrcInfoCd("AD");
										 curTmpVoList.add(vo);
										 continue;
									 }
									 
									 
								 } 
							 }
						 }
						 
						 //(3)
						 //no use code in current db code(AM) 1 and no use code in current data is 1
						 //change current db code to current code
						 noUseCurCnt   = getNoUseDataCntForVOCust(curTmpVoList);
						 if(noUseCurCnt > 0){
							 for(int x = 0; x < curTmpVoList.size(); x++){
								 String curDbPagerows   = curTmpVoList.get(x).getPagerows();
								 //change curDB to cur
								 //using new(=cur) info and only change to the CmdtHdrSeq and CmdtSeq in curDB 
								 if((curDbPagerows == null || curDbPagerows.equals("")) && ((noUseCurDbCnt >= 1 && noUseCurCnt >= 1) && (noUseCurDbCnt == noUseCurCnt))){
									 if(curDBVO != null && curDBVO.size() > 0){
										 for(int i = 0; i < curDBVO.size(); i++){
											 String curPagerows  = curDBVO.get(i).getPagerows();
											 String curSrcInfoCd = curDBVO.get(i).getSrcInfoCd();
											 if(StringUtils.isEmpty(curPagerows) && isSrcInfoNw(curSrcInfoCd)){
												 curDBVO.get(i).setPagerows("X");
												 curTmpVoList.get(x).setCmdtHdrSeq(curDBVO.get(i).getCmdtHdrSeq());
												 curTmpVoList.get(x).setActCustSeq(curDBVO.get(i).getActCustSeq());
												 curTmpVoList.get(x).setPrcProgStsCd("I");
												 curTmpVoList.get(x).setSrcInfoCd("AM");
												 break;
											 }
										 }
									 }
									 
								 }
							 }
						 }
						 
					 }
					 
				 } //end if(curDBVO != null && curDBVO.size() > 0)
			 } // end if(rowType.equals("U"))

			 custVoList.addAll(curTmpVoList);
			 
		 } catch (DAOException ex) {
			 throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
         } catch (Exception ex) {
        	 throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
         }
		 
	 }
	 /**
	  * make PriSpScpRtCmdtRoutVO with RsltRtListHorizontalExcelVO and add it to List<PriSpScpRtCmdtRoutVO> <br>
	  * 
	  * @param List<PriSpScpRtCmdtRoutVO> routVoList : the result object to be created
	  * @param RsltRtListHorizontalExcelVO row : a row of the uploaded excel(target row)
	  * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO : the master data of contract(include with prop_no, amdt_seq etc...)
	  * @param int nextCmdtHdrSeq
	  * @param int nextRoutSeq
	  * @param String strCreUsrId
	  * @param String strUpdUsrId
	  */
	 private void makeCmdtRoutForCreate(List<PriSpScpRtCmdtRoutVO> routVoList, RsltRtListHorizontalExcelVO row, PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
			                          , int nextCmdtHdrSeq, int nextRoutSeq, String strCreUsrId, String strUpdUsrId, List<PriSpScpRtCnoteVO> cnoteVoList
			                          , List<PriSpScpRtCmdtRnoteVO> rnoteVoList, List<PriSpScpRtCmdtRnoteVO> convVoList ){ 
	 
		 PriSpScpRtCmdtRoutVO vo = new PriSpScpRtCmdtRoutVO();
		 vo.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
	     vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
	     vo.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
	     vo.setGenSpclRtTpCd(priSpScpRtCmdtHdrVO.getGenSpclRtTpCd());
	     vo.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
	     vo.setRoutSeq(String.valueOf(nextRoutSeq));
	     vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
	     vo.setCreUsrId(strCreUsrId);
	     vo.setUpdUsrId(strUpdUsrId);
	     routVoList.add(vo);
	     
	     // CMDT Note
	     if(!row.getCmdtNoteCopy().equals("") && row.getRoutNoteCopy().equals("")){
	         PriSpScpRtCnoteVO cnvo = new PriSpScpRtCnoteVO();
	         cnvo.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
	         cnvo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
	         cnvo.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
	         cnvo.setGenSpclRtTpCd(priSpScpRtCmdtHdrVO.getGenSpclRtTpCd());
	         cnvo.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));	         
	         cnvo.setAcptUsrId(row.getCmdtNoteCopy()); // For copy, use other columns 
	         cnvo.setCreUsrId(strCreUsrId);
	         cnvo.setUpdUsrId(strUpdUsrId);
	         cnoteVoList.add(cnvo);
	         
	         PriSpScpRtCmdtRnoteVO cvvo = new PriSpScpRtCmdtRnoteVO();
	         cvvo.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
	         cvvo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
	         cvvo.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
	         cvvo.setGenSpclRtTpCd(priSpScpRtCmdtHdrVO.getGenSpclRtTpCd());
	         cvvo.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));	         
	         cvvo.setAcptUsrId(row.getCmdtNoteCopy()); // For copy, use other columns 
	         cvvo.setCreUsrId(strCreUsrId);
	         cvvo.setUpdUsrId(strUpdUsrId);
	         convVoList.add(cvvo);
	     }
	     
	     // ROUTE NOTE
	     if(!row.getCmdtNoteCopy().equals("") && !row.getRoutNoteCopy().equals("")){
		     PriSpScpRtCmdtRnoteVO rnvo = new PriSpScpRtCmdtRnoteVO();
		     rnvo.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
		     rnvo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
		     rnvo.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
		     rnvo.setGenSpclRtTpCd(priSpScpRtCmdtHdrVO.getGenSpclRtTpCd());
		     rnvo.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
		     rnvo.setRoutSeq(String.valueOf(nextRoutSeq));		
		     rnvo.setAcptUsrId(row.getCmdtNoteCopy()); // For copy, use other columns 
		     rnvo.setAcptOfcCd(row.getRoutNoteCopy()); // For copy, use other columns 	 
		     rnvo.setCreUsrId(strCreUsrId);
		     rnvo.setUpdUsrId(strUpdUsrId); 
		     rnoteVoList.add(rnvo);
	     }
	     
     }
	 /**
	  * make PriSpScpRtRoutDirVO with RsltRtListHorizontalExcelVO and add it to List<PriSpScpRtRoutDirVO> <br>
	  * 
	  * @param String rowType
	  * @param List<PriSpScpRtRoutDirVO> dcallVoList : the result object to be created
	  * @param RsltRtListHorizontalExcelVO row : a row of the uploaded excel(target row)
	  * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO : the master data of contract(include with prop_no, amdt_seq etc...)
	  * @param int nextCmdtHdrSeq
	  * @param int nextRoutSeq
	  * @param String strCreUsrId
	  * @param String strUpdUsrId
	  * @exception EventException
	  */
	 private void makeCmdtDirCallForCreate(String rowType, List<PriSpScpRtRoutDirVO> dcallVoList, RsltRtListHorizontalExcelVO row, PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, 
			                                int nextCmdtHdrSeq, int nextRoutSeq, String strCreUsrId, String strUpdUsrId) throws EventException {
		 try {
			 
			 //CUR LIST
			 List<PriSpScpRtRoutDirVO> curTmpVoList   = new ArrayList<PriSpScpRtRoutDirVO>();
			 //get current info data to compare
			 List<PriSpScpRtRoutDirVO> tVO            = new ArrayList<PriSpScpRtRoutDirVO>();
			 //previous AmdtSeq's DB Info
			 List<PriSpScpRtRoutDirVO> preDBVO        = new ArrayList<PriSpScpRtRoutDirVO>();
			 //current AmdtSeq's DB Info
			 List<PriSpScpRtRoutDirVO> curDBVO        = new ArrayList<PriSpScpRtRoutDirVO>();
			 if(rowType.equals("U") || (rowType.equals("D") && !priSpScpRtCmdtHdrVO.getAmdtSeq().equals("0") )){
				 
				 tVO = dbDao.searchPriSpScpRtRoutDirList(priSpScpRtCmdtHdrVO, row.getCmdtHdrSeq(), row.getRoutSeq());
				 if(tVO.size() == 0){
					 return;
				 }
				 
				 preDBVO        = getRoutDirForAmdtSeq(tVO, priSpScpRtCmdtHdrVO.getAmdtSeq(), false);
				 curDBVO        = getRoutDirForAmdtSeq(tVO, priSpScpRtCmdtHdrVO.getAmdtSeq(), true);
				 
			 }

			 //TYPE(C) OR TYPE(U) -> CREATE DATA WITH EXCEL
			 if(rowType.equals("U") || rowType.equals("C")){
				 
				 if( priSpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && (curDBVO == null || curDBVO.size() == 0) && rowType.equals("U") ){
					 return;
				 }
				 
				 PriSpScpRtRoutDirVO vo = new PriSpScpRtRoutDirVO();
				 vo.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
		         vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
		         vo.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
		         vo.setGenSpclRtTpCd(priSpScpRtCmdtHdrVO.getGenSpclRtTpCd());
		         if(rowType.equals("C") && row.getCmdtHdrSeq().equals("")){
		        	 vo.setCmdtHdrSeq(String.valueOf(nextCmdtHdrSeq));
		         } else {
		        	 vo.setCmdtHdrSeq(row.getCmdtHdrSeq());
		         }
		         if(rowType.equals("C") && row.getRoutSeq().equals("")){
		        	 vo.setRoutSeq(String.valueOf(nextRoutSeq));
		         } else {
		        	 vo.setRoutSeq(row.getRoutSeq());
		         }
		         
		         vo.setDirCallFlg(row.getDirCallFlg());
		         vo.setPrcProgStsCd("I");
		         vo.setSrcInfoCd("NW");
		         vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
		         vo.setCreUsrId(strCreUsrId);
		         vo.setUpdUsrId(strUpdUsrId);
		         
		         if(rowType.equals("C")){
		        	 dcallVoList.add(vo);
		         } else {
		        	 curTmpVoList.add(vo);
		         }
				 
			 } else if(rowType.equals("D")){
				 
				 if( priSpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && rowType.equals("D") ){
					 return;
				 }
				 
				 //TYPE(D) AND EXSITS DATA IN DB
				 if(curDBVO != null && curDBVO.size() > 0){
					 
					 curDBVO.get(0).setIbflag(rowType);
					 curDBVO.get(0).setPrcProgStsCd("I");
					 curDBVO.get(0).setSrcInfoCd("AD");
					 curDBVO.get(0).setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
					 curDBVO.get(0).setCreUsrId(strCreUsrId);
					 curDBVO.get(0).setUpdUsrId(strUpdUsrId);
					 
					 dcallVoList.addAll(curDBVO);
				 }
				 
			 }
			 
			 if(!priSpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && rowType.equals("U")){
				 String curDbCd      = curDBVO.get(0).getDirCallFlg();
				 String curDbSrcInfo = curTmpVoList.get(0).getSrcInfoCd();
				 String curCd        = curTmpVoList.get(0).getDirCallFlg();
				 
				 if(curDbCd.equals(curCd)){
					 if(curDbSrcInfo.equals("AD")){
						 if(preDBVO != null && preDBVO.size() > 0){
							 PriSpScpRtRoutDirVO vo = preDBVO.get(0);
							 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
							 curTmpVoList.set(0, vo);
						 }
					 } else if(isSrcInfoNw(curDbSrcInfo) || curDbSrcInfo.equals("AM")){
						 PriSpScpRtRoutDirVO vo = curDBVO.get(0);
						 curTmpVoList.set(0, vo);
					 }
				 } else {
					 if(isSrcInfoNw(curDbSrcInfo)){
						 if(curDBVO != null && curDBVO.size() > 0){
							 PriSpScpRtRoutDirVO vo = curTmpVoList.get(0);
							 vo.setSrcInfoCd("AM");
							 vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
							 vo.setPrcProgStsCd("I");
							 curTmpVoList.set(0, vo);
						 }
					 } else if(curDbSrcInfo.equals("AM")){
						 if(preDBVO != null && preDBVO.size() > 0){
							 PriSpScpRtRoutDirVO vo = preDBVO.get(0);
							 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
							 curTmpVoList.set(0, vo);
						 }
					 } else if(curDbSrcInfo.equals("AD")){
						 PriSpScpRtRoutDirVO vo = curDBVO.get(0);
						 curTmpVoList.set(0, vo);
					 }
				 }
			 }
			 dcallVoList.addAll(curTmpVoList);
		 } catch (DAOException ex) {
			 throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
         } catch (Exception ex) {
        	 throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
         }
         
	 }
	 /**
	  * make PriSpScpRtRoutPntVO with RsltRtListHorizontalExcelVO and add it to List<PriSpScpRtRoutPntVO> <br>
	  * 
	  * @param String rowType
	  * @param List<PriSpScpRtRoutPntVO> pntVoList : the result object to be created
	  * @param RsltRtListHorizontalExcelVO row : a row of the uploaded excel(target row)
	  * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO : the master data of contract(include with prop_no, amdt_seq etc...)
	  * @param ArrayList<CodeInfo> termOrgCodeList
	  * @param ArrayList<CodeInfo> termDestCodeList
	  * @param ArrayList<CodeInfo> trspModCodeList
	  * @param int nextCmdtHdrSeq
	  * @param int nextRoutSeq
	  * @param String strCreUsrId
	  * @param String strUpdUsrId
	  * @exception EventException
	  */
	 private void makeLocForCreate(String rowType, List<PriSpScpRtRoutPntVO> pntVoList, RsltRtListHorizontalExcelVO row, PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
			                     , String strOrgDestTpCd, ArrayList<CodeInfo> termOrgCodeList, ArrayList<CodeInfo> termDestCodeList, ArrayList<CodeInfo> trspModCodeList
			                     , int nextCmdtHdrSeq, int nextRoutSeq, String strCreUsrId, String strUpdUsrId) throws EventException {		 
		 try {			 
			 //CUR LIST
			 List<PriSpScpRtRoutPntVO> curTmpVoList = new ArrayList<PriSpScpRtRoutPntVO>();
			 //get current info data to compare
			 List<PriSpScpRtRoutPntVO> tVO			= new ArrayList<PriSpScpRtRoutPntVO>();
			 //previous AmdtSeq's DB Info
			 List<PriSpScpRtRoutPntVO> preDBVO      = new ArrayList<PriSpScpRtRoutPntVO>();
			 //current AmdtSeq's DB Info
			 List<PriSpScpRtRoutPntVO> curDBVO      = new ArrayList<PriSpScpRtRoutPntVO>();
			 
			 if(rowType.equals("U") || (rowType.equals("D") && !priSpScpRtCmdtHdrVO.getAmdtSeq().equals("0") )){				 
				 tVO = dbDao.searchPriSpScpRtRoutPntList(priSpScpRtCmdtHdrVO, strOrgDestTpCd, row.getCmdtHdrSeq(), row.getRoutSeq());
				 if(tVO.size() == 0){
					 return;
				 }
				 
				 preDBVO        = getRoutPntForAmdtSeq(tVO, priSpScpRtCmdtHdrVO.getAmdtSeq(), false);
				 curDBVO        = getRoutPntForAmdtSeq(tVO, priSpScpRtCmdtHdrVO.getAmdtSeq(), true);
				 
			 }
			 
			 if(rowType.equals("U") || rowType.equals("C")){
				 
				 if( priSpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && (curDBVO == null || curDBVO.size() == 0) && rowType.equals("U") ){
					 return;
				 }
				 
				 String locs = "";
				 if(strOrgDestTpCd.equals("O")){
					 locs = row.getOrgRoutPntLocDefCd();
				 } else {
					 locs = row.getDestRoutPntLocDefCd();
				 }
				 
				 if(locs != null && !locs.equals("")) {
					 String terms = "";
					 if(strOrgDestTpCd.equals("O")){
						 terms = row.getOrgRcvDeTermNm();
					 } else {
						 terms = row.getDestRcvDeTermNm();
					 }
					 String trspMods = "";
					 if(strOrgDestTpCd.equals("O")){
						 trspMods = row.getOrgPrcTrspModNm();
					 } else {
						 trspMods = row.getDestPrcTrspModNm();
					 }
					 
					 //----------------------------------------------------------
					 //(1) compound the number of LOC, TERM and TRSPMOD
					//----------------------------------------------------------
					 String[] arrLoc = locs.split(";");
					 String[] arrTerms = terms.split(";");
					 String[] arrTrspMods = trspMods.split(";");
					 
					 int arrLocCnt = arrLoc.length;
					 int arrTermCnt = arrTerms.length == 0 ? 1 : arrTerms.length;
					 int arrTrspModCnt = arrTrspMods.length == 0 ? 1 : arrTrspMods.length;
					 int arrTotal = arrLocCnt * arrTermCnt * arrTrspModCnt;
					 StringBuilder sb = new StringBuilder();
					 if(arrTotal > 0){
						 for(int i = 0; i < arrTotal; i++){
							 String tmpVal = "";
							 
							 //ILOC
							 int iTLoc = (arrTermCnt*arrTrspModCnt);
							 int iLoc = i / iTLoc;
							 if(arrLoc != null && !arrLoc[iLoc].equals("")){
								 tmpVal = arrLoc[iLoc];
							 }
							 
							 //TERM
							 int iTTerm = arrTrspModCnt;
							 int iTerm = 0;
							 
							 if(iTTerm > 1 && ((i - iTTerm) >= 0)){
								 int i_temp = i % iTTerm;
								 iTerm = i_temp / iTTerm;
							 } else {
								 if(arrTermCnt == 1){
									 iTerm = i % iTTerm;
								 } else	if(arrTermCnt > 1){
									 iTerm = i % arrTermCnt;
								 }
							 }
							 
							 if(arrTerms != null && arrTerms[iTerm] != null && !arrTerms[iTerm].equals("") && arrTerms[iTerm].length() > 0){
								 tmpVal += ","+arrTerms[iTerm];
							 } else {
								 tmpVal += ",&";
							 }
							 
							 //TRSP
							 int iTrspMod = i % arrTrspModCnt;
							 if(arrTrspMods != null && arrTrspMods[iTrspMod] != null && !arrTrspMods[iTrspMod].equals("") && arrTrspMods[iTrspMod].length() > 0){
								 tmpVal += ","+arrTrspMods[iTrspMod];
							 } else {
								 tmpVal += ",&";
							 }
							 
							 sb.append(tmpVal+"|");
							 
						 } //end for arrLoc
					 }
					 

					 //----------------------------------------------------------
					 //(2) make the location object as many as the number of LOC, TERM and TRSPMOD
					 //----------------------------------------------------------
					 
					 String strLocTermTrsp = sb.toString();
					 String[] arrLocTermTrsp = strLocTermTrsp.split("\\|");
					 
					 if(arrLocTermTrsp != null && arrLocTermTrsp.length > 0) {
					 
						 //int iLocSeq = 0;
						 
						 String txCmdtSeq = "";
						 String txRoutSeq = "";
						 if(rowType.equals("C") && row.getCmdtHdrSeq().equals("")){
							 txCmdtSeq = String.valueOf(nextCmdtHdrSeq);
				         } else {
				        	 txCmdtSeq = row.getCmdtHdrSeq();
				         }
						 if(rowType.equals("C") && row.getRoutSeq().equals("")){
				        	 txRoutSeq = String.valueOf(nextRoutSeq);
				         } else {
				        	 txRoutSeq = row.getRoutSeq();
				         }
				         //iLocSeq = getMaxRoutPntSeq(pntVoList, txCmdtSeq, txRoutSeq);	
						 
						 for(int i = 0; i < arrLocTermTrsp.length; i++) {

							 String tmpLocTermTrsp = arrLocTermTrsp[i];
							 String[] arrTmpLocTermTrsp = tmpLocTermTrsp.split(",");
							 String strLoc = arrTmpLocTermTrsp[0].equals("&") ? "" : arrTmpLocTermTrsp[0];
							 String strRcvDeTermCd = arrTmpLocTermTrsp[1].equals("&") ? "" : arrTmpLocTermTrsp[1];
							 String strPrcTrspModCd = arrTmpLocTermTrsp[2].equals("&") ? "" : arrTmpLocTermTrsp[2];;
							 String strCompareOrg = strLoc+strRcvDeTermCd+strPrcTrspModCd;
							 
							 String locCd = strLoc;
							 String locTpCd = strLoc.length() == 4 ? "G" : "L";
							 
							 if(exsitsCmdtRoutLocTermTrspMod(pntVoList, strCompareOrg)){
								 continue;
							 }
							 
							 //iLocSeq += 1;
			                 
			                 PriSpScpRtRoutPntVO vo = new PriSpScpRtRoutPntVO();
			                 vo.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
			                 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
			                 vo.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
			                 vo.setGenSpclRtTpCd(priSpScpRtCmdtHdrVO.getGenSpclRtTpCd());

			    	         vo.setCmdtHdrSeq(txCmdtSeq);
			    	         vo.setRoutSeq(txRoutSeq);
			                 
			                 vo.setOrgDestTpCd(strOrgDestTpCd);
			                 vo.setRoutPntSeq("");
			                 vo.setRoutPntLocTpCd(locTpCd);
			                 vo.setRoutPntLocDefCd(locCd);
			                 
			                 if(strOrgDestTpCd.equals("O")) {
			                	 String strCode = getCodeInCodeBook(termOrgCodeList, strRcvDeTermCd);
			                	 if(!strCode.equals("")){
			                		 vo.setRcvDeTermCd(strCode);
			                	 }
			                 } else {
			                	 String strCode = getCodeInCodeBook(termDestCodeList, strRcvDeTermCd);
			                	 if(!strCode.equals("")){
			                		 vo.setRcvDeTermCd(strCode);
			                	 }
			                 }
			                 
			                 String strPrcTrspModCode = getCodeInCodeBook(trspModCodeList, strPrcTrspModCd);
			                 vo.setPrcTrspModCd(strPrcTrspModCode);

			                 vo.setPrcProgStsCd("I");
			                 vo.setSrcInfoCd("NW");	
			                 vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
			                 vo.setCreUsrId(strCreUsrId);
			                 vo.setUpdUsrId(strUpdUsrId);
			                 
			                 if(rowType.equals("C")){
					        	 pntVoList.add(vo);
					         } else {
					        	 curTmpVoList.add(vo);
					         }
						 }
					 }
				 }
			 } else if(rowType.equals("D")){
				 
				 if( priSpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && rowType.equals("D") ){
					 return;
				 }
				 
				 //TYPE(D) AND EXSITS DATA IN DB
				 if(curDBVO != null && curDBVO.size() > 0){
					 
					 for(int i = 0; i < curDBVO.size(); i++){
						 curDBVO.get(i).setIbflag(rowType);
						 curDBVO.get(i).setPrcProgStsCd("I");
						 curDBVO.get(i).setSrcInfoCd("AD");
						 curDBVO.get(i).setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
						 curDBVO.get(i).setCreUsrId(strCreUsrId);
						 curDBVO.get(i).setUpdUsrId(strUpdUsrId);
					 }
					 
					 pntVoList.addAll(curDBVO);
				 }
				 
			 }
			 
			 
			 if(!priSpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && rowType.equals("U")){
				 if(curDBVO != null && curDBVO.size() > 0){
					 if(curDBVO.size() != curTmpVoList.size()){
						 //------------
						 // current db row count != current(excel) row count
						 //------------
						 
						 //when current db codes(NW,AM) are equal with current data, use current db info
						 //when current data code are not equal with current db code -> already include in current data
						 //(1)
						 for(int i = 0; i < curDBVO.size(); i++){
							 String curDbCd       = curDBVO.get(i).getRoutPntLocDefCd()+curDBVO.get(i).getRcvDeTermCd()+curDBVO.get(i).getPrcTrspModCd();
							 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
							 String curDbPagerows = curDBVO.get(i).getPagerows();
							 for(int x = 0; x < curTmpVoList.size(); x++){
								 String curCd = curTmpVoList.get(x).getRoutPntLocDefCd()+curTmpVoList.get(x).getRcvDeTermCd()+curTmpVoList.get(x).getPrcTrspModCd();
								 if(curDbCd.equals(curCd) && ( isSrcInfoNw(curDbSrc) || curDbSrc.equals("AM") ) && StringUtils.isEmpty(curDbPagerows)){
									 curDBVO.get(i).setPagerows("X");
									 PriSpScpRtRoutPntVO vo = curDBVO.get(i);
									 changeSameLocation(curTmpVoList, vo);
								 }
							 }
						 }
						 
						 int noUseCurDbCnt = getNoUseDataCntForVOLocation(curDBVO);
						 int noUseCurCnt   = getNoUseDataCntForVOLocation(curTmpVoList);
						 
						 boolean isAmendedAll1 = isAllAmendedInDataLocation(curDBVO);
						 if(!isAmendedAll1){
							 //when there are some diffent codes
							 
							 //different codes(NW) -> using current db code(with AD)
							 //different codes(AM) -> compare preDB
							 //                       current db code is different with previous db code and it's seq is same and there is no comparing current data
							 //						  	-->using previous db info(with AD)
							 //						  current db code is same with previous db code and it's seq is not same and there are comparing current datas
							 //                         -->using prevois db info
							 for(int i = 0; i < curDBVO.size(); i++){
								 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
								 String curDbCd       = curDBVO.get(i).getRoutPntLocDefCd()+curDBVO.get(i).getRcvDeTermCd()+curDBVO.get(i).getPrcTrspModCd();
								 String curDbRoutPntSeq  = curDBVO.get(i).getRoutPntSeq();
								 String curDbPagerows = curDBVO.get(i).getPagerows();
								 if(StringUtils.isEmpty(curDbPagerows) && isSrcInfoNw(curDbSrc)){
									 curDBVO.get(i).setPagerows("X");
									 PriSpScpRtRoutPntVO vo = curDBVO.get(i);
									 vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
									 vo.setPrcProgStsCd("I");
									 vo.setSrcInfoCd("AD");
									 curTmpVoList.add(vo);								 
								 } else if(StringUtils.isEmpty(curDbPagerows) && curDbSrc.equals("AM")){
									 if(preDBVO != null && preDBVO.size() > 0){
										 for(int x = 0; x < preDBVO.size(); x++){
											 String preDbCd       = preDBVO.get(x).getRoutPntLocDefCd()+preDBVO.get(x).getRcvDeTermCd()+preDBVO.get(x).getPrcTrspModCd();
											 String preDbRoutPntSeq  = preDBVO.get(x).getRoutPntSeq();
											 String preDbPagerows = preDBVO.get(x).getPagerows();
											 if( !curDbCd.equals(preDbCd) && curDbRoutPntSeq.equals(preDbRoutPntSeq) && noUseCurCnt == 0 && StringUtils.isEmpty(preDbPagerows)){
												 preDBVO.get(x).setPagerows("X");
												 PriSpScpRtRoutPntVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
												 vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
												 vo.setPrcProgStsCd("I");
												 vo.setSrcInfoCd("AD");
												 changeSameLocation(curTmpVoList, vo);
												 break;
												 
											 } else if( curDbCd.equals(preDbCd) && !curDbRoutPntSeq.equals(preDbRoutPntSeq) && noUseCurCnt != 0 && StringUtils.isEmpty(preDbPagerows)){
												 preDBVO.get(x).setPagerows("X");
												 curDBVO.get(i).setPagerows("X");
												 PriSpScpRtRoutPntVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameLocation(curTmpVoList, vo);
												 break;
												 
											 }
										 }
									 }
									 
								 }
							 }
							 
						 } else if(isAmendedAll1 && noUseCurDbCnt != 0){
							 //when diffent codes are all, compare previous db and current data
							 
							 //previous data codes are same with current data code     -> use previous datas
							 //previous data codes are not same with current data code -> use previous datas(AD)
							 List<PriSpScpRtRoutPntVO> tmpCmdt1 =  new ArrayList<PriSpScpRtRoutPntVO>();
							 tmpCmdt1.addAll(curTmpVoList);
							 if(preDBVO != null && preDBVO.size() > 0){
								 for(int x = 0; x < preDBVO.size(); x++){
									 String preDbCd       = preDBVO.get(x).getRoutPntLocDefCd()+preDBVO.get(x).getRcvDeTermCd()+preDBVO.get(x).getPrcTrspModCd();
									 
									 boolean isExists = exsitsCmdtRoutLocTermTrspMod(tmpCmdt1, preDbCd);
									 if(isExists){
										 for(int i = 0; i < tmpCmdt1.size(); i++){
											 String cd     = tmpCmdt1.get(i).getRoutPntLocDefCd()+tmpCmdt1.get(i).getRcvDeTermCd()+tmpCmdt1.get(i).getPrcTrspModCd();
											 
											 if(preDbCd.equals(cd) && tmpCmdt1.get(i).getPagerows() == null){
												 preDBVO.get(x).setPagerows("X");
												 PriSpScpRtRoutPntVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameLocation(curTmpVoList, vo);
												 changeSameLocation(tmpCmdt1, vo);
												 break;
											 }
										 }
										 continue;
									 } else {
										 
										 preDBVO.get(x).setPagerows("X");
										 PriSpScpRtRoutPntVO vo = preDBVO.get(x);
										 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setPrcProgStsCd("I");
										 vo.setSrcInfoCd("AD");
										 curTmpVoList.add(vo);
										 continue;
									 }
									 
									 
								 } 
							 }
							 
						 }

						 
					 } else {
						 //------------
						 // current db row count == current(excel) row count
						 //------------
						 
						 //
						 //when current db srcInfoCd is all AM     -> remove current db and compare previous db (2)
						 //when current db srcInfoCd is not all AM -> (1) current db code(NW,AM) equal with current data
						 //													-> using current db info
						 //												  current db code(AD) do not equal with current data
						 //													-> using current db info
						 //                                           (3) current db code(AM) does not exists in current data
						 //(1)
						 boolean isAmendedAll2 = isAllAmendedInDataLocation(curDBVO);
						 
						 List<PriSpScpRtRoutPntVO> tmpCmdt1 =  new ArrayList<PriSpScpRtRoutPntVO>();
						 tmpCmdt1.addAll(curTmpVoList);
						 
						 for(int i = (curDBVO.size() - 1); i >= 0; i--){
							 String curDbCd       = curDBVO.get(i).getRoutPntLocDefCd()+curDBVO.get(i).getRcvDeTermCd()+curDBVO.get(i).getPrcTrspModCd();
							 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
							 String curDbPages    = curDBVO.get(i).getPagerows();
							 int    noCntInCur = 0;
							 boolean isExists = exsitsCmdtRoutLocTermTrspMod(tmpCmdt1, curDbCd);
							 if(isExists){
								 for(int x = 0; x < tmpCmdt1.size(); x++){
									 String cd       = tmpCmdt1.get(x).getRoutPntLocDefCd()+tmpCmdt1.get(x).getRcvDeTermCd()+tmpCmdt1.get(x).getPrcTrspModCd();
									 String pages    = tmpCmdt1.get(x).getPagerows();
									 if(!curDbCd.equals(cd) && curDbSrc.equals("AM")){
										 noCntInCur++;
										 break;
									 }

									 if(curDbCd.equals(cd) && StringUtils.isEmpty(pages)){
										 curDBVO.get(i).setPagerows("X");
										 PriSpScpRtRoutPntVO vo = curDBVO.get(i);
										 changeSameLocation(curTmpVoList, vo);
										 changeSameLocation(tmpCmdt1, vo);
										 break;
									 }
								 }
							 } else {
								 
								 for(int x = 0; x < curTmpVoList.size(); x++){
									 String cd       = curTmpVoList.get(x).getRoutPntLocDefCd()+curTmpVoList.get(x).getRcvDeTermCd()+curTmpVoList.get(x).getPrcTrspModCd();
									 if(!curDbCd.equals(cd) && !curDbSrc.equals("AD")){
										 noCntInCur++;
										 break;
									 }
									 
									 if(!curDbCd.equals(cd) && StringUtils.isEmpty(curDbPages)){
										 curDBVO.get(i).setPagerows("X");
										 PriSpScpRtRoutPntVO vo = curDBVO.get(i);
										 curTmpVoList.add(vo);
										 break;
									 }
								 }
							 }
							 
							 if(noCntInCur > 0 && curDbSrc.equals("AM") ){
								 curDBVO.remove(i);
							 }
						 	 
						 }
						 
						 int noUseCurDbCnt = getNoUseDataCntForVOLocation(curDBVO);
						 int noUseCurCnt   = getNoUseDataCntForVOLocation(curTmpVoList);
						 
						 //(2)
						 //compare preDB data with cur data
						 //when preDB code equal with cur data        -> use preDB Info
						 //when preDB code do not equal with cur data -> use preDB Info and srcInfoCd(AD)
						 if(isAmendedAll2){
							 if(preDBVO != null && preDBVO.size() > 0 && noUseCurCnt > 0){
								 for(int x = 0; x < preDBVO.size(); x++){
									 String preDbCd       = preDBVO.get(x).getRoutPntLocDefCd()+preDBVO.get(x).getRcvDeTermCd()+preDBVO.get(x).getPrcTrspModCd();
									 
									 boolean isExists = exsitsCmdtRoutLocTermTrspMod(curTmpVoList, preDbCd);
									 if(isExists){
										 for(int i = 0; i < curTmpVoList.size(); i++){
											 String cd = curTmpVoList.get(i).getRoutPntLocDefCd()+curTmpVoList.get(i).getRcvDeTermCd()+curTmpVoList.get(i).getPrcTrspModCd();
											 
											 if(preDbCd.equals(cd) && curTmpVoList.get(i).getPagerows() == null){
												 preDBVO.get(x).setPagerows("X");
												 PriSpScpRtRoutPntVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameLocation(curTmpVoList, vo);
												 break;
											 }
										 }
										 continue;
									 } else {
										 
										 preDBVO.get(x).setPagerows("X");
										 PriSpScpRtRoutPntVO vo = preDBVO.get(x);
										 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setPrcProgStsCd("I");
										 vo.setSrcInfoCd("AD");
										 curTmpVoList.add(vo);
										 continue;
									 }
									 
									 
								 } 
							 }
						 }
						 
						 //(3)
						 //no use code in current db code(AM) 1 and no use code in current data is 1
						 //change current db code to current code
						 noUseCurCnt   = getNoUseDataCntForVOLocation(curTmpVoList);
						 if(noUseCurCnt > 0){
							 for(int x = 0; x < curTmpVoList.size(); x++){
								 String curDbPagerows   = curTmpVoList.get(x).getPagerows();
								 //change curDB to cur
								 //using new(=cur) info and only change to the CmdtHdrSeq and CmdtSeq in curDB 
								 if((curDbPagerows == null || curDbPagerows.equals("")) && ((noUseCurDbCnt >= 1 && noUseCurCnt >= 1) && (noUseCurDbCnt == noUseCurCnt))){
									 if(curDBVO != null && curDBVO.size() > 0){
										 for(int i = 0; i < curDBVO.size(); i++){
											 String curPagerows  = curDBVO.get(i).getPagerows();
											 String curSrcInfoCd = curDBVO.get(i).getSrcInfoCd();
											 if(StringUtils.isEmpty(curPagerows) && isSrcInfoNw(curSrcInfoCd)){
												 curDBVO.get(i).setPagerows("X");
												 curTmpVoList.get(x).setCmdtHdrSeq(curDBVO.get(i).getCmdtHdrSeq());
												 curTmpVoList.get(x).setRoutSeq(curDBVO.get(i).getRoutSeq());
												 curTmpVoList.get(x).setRoutPntSeq(curDBVO.get(i).getRoutPntSeq());
												 curTmpVoList.get(x).setPrcProgStsCd("I");
												 curTmpVoList.get(x).setSrcInfoCd("AM");
												 break;
											 }
										 }
									 }
									 
								 }
							 }
						 }
						 
					 }
					 	 
				 } //end if(curDBVO != null && curDBVO.size() > 0)
			 } // end if(rowType.equals("U"))

			 pntVoList.addAll(curTmpVoList);
			 
		 } catch (DAOException ex) {
			 throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
         } catch (Exception ex) {
        	 throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
         }
	 }
	 /**
	  * make PriSpScpRtRoutViaVO with RsltRtListHorizontalExcelVO and add it to List<PriSpScpRtVO> <br>
	  * 
	  * @param String rowType
	  * @param List<PriSpScpRtRoutViaVO> viaVoList : the result object to be created
	  * @param RsltRtListHorizontalExcelVO row : a row of the uploaded excel(target row)
	  * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO : the master data of contract(include with prop_no, amdt_seq etc...)
	  * @param String strOrgDestTpCd
	  * @param int nextCmdtHdrSeq
	  * @param int nextRoutSeq
	  * @param String strCreUsrId
	  * @param String strUpdUsrId
	  * @exception EventException
	  */
	 private void makeViaLocForCreate(String rowType, List<PriSpScpRtRoutViaVO> viaVoList, RsltRtListHorizontalExcelVO row, PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, 
			                           String strOrgDestTpCd, int nextCmdtHdrSeq, int nextRoutSeq, String strCreUsrId, String strUpdUsrId) throws EventException {

		 try {
			 //CUR LIST
			 List<PriSpScpRtRoutViaVO> curTmpVoList = new ArrayList<PriSpScpRtRoutViaVO>();
			 //get current info data to compare
			 List<PriSpScpRtRoutViaVO> tVO          = new ArrayList<PriSpScpRtRoutViaVO>();
			 //previous AmdtSeq's DB Info
			 List<PriSpScpRtRoutViaVO> preDBVO      = new ArrayList<PriSpScpRtRoutViaVO>();
			 //current AmdtSeq's DB Info
			 List<PriSpScpRtRoutViaVO> curDBVO      = new ArrayList<PriSpScpRtRoutViaVO>();
			 
			 if(rowType.equals("U") || (rowType.equals("D") && !priSpScpRtCmdtHdrVO.getAmdtSeq().equals("0") )){
				 //apply only to via(2016.01.29)
				 tVO = dbDao.searchPriSpScpRtRoutViaList(priSpScpRtCmdtHdrVO, strOrgDestTpCd, row.getCmdtHdrSeq(), row.getRoutSeq());
				 if(!rowType.equals("U") && tVO.size() == 0){
					 return; 
				 }
				 
				 if(tVO.size() > 0){
					 preDBVO        = getRoutViaForAmdtSeq(tVO, priSpScpRtCmdtHdrVO.getAmdtSeq(), false);
					 curDBVO        = getRoutViaForAmdtSeq(tVO, priSpScpRtCmdtHdrVO.getAmdtSeq(), true);
				 }
			 }
			 
			 if(rowType.equals("U") || rowType.equals("C")){
				 String viaLocCds = "";
				 if(strOrgDestTpCd.equals("O")){
					 viaLocCds = row.getOrgRoutViaPortDefCd();
				 } else {
					 viaLocCds = row.getDestRoutViaPortDefCd();
				 }
				 
				 if(viaLocCds != null && !viaLocCds.equals("")) {
					 String[] arrLocCd = viaLocCds.split(";");
					 if(arrLocCd.length > 0) {
						 //int iRoutViaSeq = 0;						 
						 String txCmdtSeq = "";
						 String txRoutSeq = "";
						 if(rowType.equals("C") && row.getCmdtHdrSeq().equals("")){
							 txCmdtSeq = String.valueOf(nextCmdtHdrSeq);
				         } else {
				        	 txCmdtSeq = row.getCmdtHdrSeq();
				         }
						 if(rowType.equals("C") && row.getRoutSeq().equals("")){
				        	 txRoutSeq = String.valueOf(nextRoutSeq);
				         } else {
				        	 txRoutSeq = row.getRoutSeq();
				         }
				         //iRoutViaSeq = getMaxRoutViaSeq(viaVoList, txCmdtSeq, txRoutSeq);	 						 
						 for(int i = 0; i < arrLocCd.length; i++) {
							 //iRoutViaSeq+=1;
							 
							 String locCd = arrLocCd[i];
							 String locTpCd = arrLocCd[i].length() == 4 ? "G" : "L";
			                  
							 PriSpScpRtRoutViaVO vo = new PriSpScpRtRoutViaVO();
		                     vo.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
			                 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
			                 vo.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
			                 vo.setGenSpclRtTpCd(priSpScpRtCmdtHdrVO.getGenSpclRtTpCd());
			    	         
			    	         vo.setCmdtHdrSeq(txCmdtSeq);
			    	         vo.setRoutSeq(txRoutSeq);
			    	         
			                 vo.setOrgDestTpCd(strOrgDestTpCd);
		                     vo.setRoutViaSeq("");
		                     vo.setRoutViaPortTpCd(locTpCd);
		                     vo.setRoutViaPortDefCd(locCd);
		                     vo.setPrcProgStsCd("I");
		                     vo.setSrcInfoCd("NW");
		                     vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
		                     vo.setCreUsrId(strCreUsrId);
		                     vo.setUpdUsrId(strUpdUsrId);
		                  
		                     if(rowType.equals("C")){
		                    	 viaVoList.add(vo);
					         } else {
					        	 curTmpVoList.add(vo);
					         }

						 }
					 }
				 }
			 } else if(rowType.equals("D")){
				 
				 if( priSpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && rowType.equals("D") ){
					 return;
				 }
				 
				 //TYPE(D) AND EXSITS DATA IN DB
				 if(curDBVO != null && curDBVO.size() > 0){
					 
					 for(int i = 0; i < curDBVO.size(); i++){
						 curDBVO.get(i).setIbflag(rowType);
						 curDBVO.get(i).setPrcProgStsCd("I");
						 curDBVO.get(i).setSrcInfoCd("AD");
						 curDBVO.get(i).setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
						 curDBVO.get(i).setCreUsrId(strCreUsrId);
						 curDBVO.get(i).setUpdUsrId(strUpdUsrId);
					 }
					 
					 viaVoList.addAll(curDBVO);
				 }
				 
			 }

			 if(!priSpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && rowType.equals("U")){
				 if(curDBVO != null && curDBVO.size() > 0){
					 
					 if(curDBVO.size() != curTmpVoList.size()){
						 //------------
						 // current db row count != current(excel) row count
						 //------------
						 
						 //when current db codes(NW,AM) are equal with current data, use current db info
						 //when current data code are not equal with current db code -> already include in current data
						 //(1)
						 for(int i = 0; i < curDBVO.size(); i++){
							 String curDbCd       = curDBVO.get(i).getRoutViaPortDefCd();
							 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
							 String curDbPagerows = curDBVO.get(i).getPagerows();
							 for(int x = 0; x < curTmpVoList.size(); x++){
								 String curCd = curTmpVoList.get(x).getRoutViaPortDefCd();
								 if(curDbCd.equals(curCd) && ( isSrcInfoNw(curDbSrc) || curDbSrc.equals("AM") ) && StringUtils.isEmpty(curDbPagerows)){
									 curDBVO.get(i).setPagerows("X");
									 PriSpScpRtRoutViaVO vo = curDBVO.get(i);
									 changeSameLocationVia(curTmpVoList, vo);
								 }
							 }
						 }
						 
						 int noUseCurDbCnt = getNoUseDataCntForVOLocationVia(curDBVO);
						 int noUseCurCnt   = getNoUseDataCntForVOLocationVia(curTmpVoList);
						 
						 boolean isAmendedAll1 = isAllAmendedInDataLocationVia(curDBVO);
						 if(!isAmendedAll1){
							 //when there are some diffent codes
							 
							 //different codes(NW) -> using current db code(with AD)
							 //different codes(AM) -> compare preDB
							 //                       current db code is different with previous db code and it's seq is same and there is no comparing current data
							 //						  	-->using previous db info(with AD)
							 //						  current db code is same with previous db code and it's seq is not same and there are comparing current datas
							 //                         -->using prevois db info
							 for(int i = 0; i < curDBVO.size(); i++){
								 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
								 String curDbCd       = curDBVO.get(i).getRoutViaPortDefCd();
								 String curDbRoutViaSeq  = curDBVO.get(i).getRoutViaSeq();
								 String curDbPagerows = curDBVO.get(i).getPagerows();
								 if(StringUtils.isEmpty(curDbPagerows) && isSrcInfoNw(curDbSrc)){
									 curDBVO.get(i).setPagerows("X");
									 PriSpScpRtRoutViaVO vo = curDBVO.get(i);
									 vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
									 vo.setPrcProgStsCd("I");
									 vo.setSrcInfoCd("AD");
									 curTmpVoList.add(vo);								 
								 } else if(StringUtils.isEmpty(curDbPagerows) && curDbSrc.equals("AM")){
									 if(preDBVO != null && preDBVO.size() > 0){
										 for(int x = 0; x < preDBVO.size(); x++){
											 String preDbCd       = preDBVO.get(x).getRoutViaPortDefCd();
											 String preDbRoutViaSeq  = preDBVO.get(x).getRoutViaSeq();
											 String preDbPagerows = preDBVO.get(x).getPagerows();
											 if( !curDbCd.equals(preDbCd) && curDbRoutViaSeq.equals(preDbRoutViaSeq) && noUseCurCnt == 0 && StringUtils.isEmpty(preDbPagerows)){
												 preDBVO.get(x).setPagerows("X");
												 PriSpScpRtRoutViaVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
												 vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
												 vo.setPrcProgStsCd("I");
												 vo.setSrcInfoCd("AD");
												 changeSameLocationVia(curTmpVoList, vo);
												 break;
												 
											 } else if( curDbCd.equals(preDbCd) && !curDbRoutViaSeq.equals(preDbRoutViaSeq) && noUseCurCnt != 0 && StringUtils.isEmpty(preDbPagerows)){
												 preDBVO.get(x).setPagerows("X");
												 curDBVO.get(i).setPagerows("X");
												 PriSpScpRtRoutViaVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameLocationVia(curTmpVoList, vo);
												 break;
												 
											 }
										 }
									 }
									 
								 }
							 }
							 
						 } else if(isAmendedAll1 && noUseCurDbCnt != 0){
							 //when diffent codes are all, compare previous db and current data
							 
							 //previous data codes are same with current data code     -> use previous datas
							 //previous data codes are not same with current data code -> use previous datas(AD)
							 List<PriSpScpRtRoutViaVO> tmpCmdt1 =  new ArrayList<PriSpScpRtRoutViaVO>();
							 tmpCmdt1.addAll(curTmpVoList);
							 if(preDBVO != null && preDBVO.size() > 0){
								 for(int x = 0; x < preDBVO.size(); x++){
									 String preDbCd       = preDBVO.get(x).getRoutViaPortDefCd();
									 
									 boolean isExists = existsLocationVia(tmpCmdt1, preDbCd);
									 if(isExists){
										 for(int i = 0; i < tmpCmdt1.size(); i++){
											 String cd       = tmpCmdt1.get(i).getRoutViaPortDefCd();
											 if(preDbCd.equals(cd) && tmpCmdt1.get(i).getPagerows() == null){
												 preDBVO.get(x).setPagerows("X");
												 PriSpScpRtRoutViaVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameLocationVia(curTmpVoList, vo);
												 changeSameLocationVia(tmpCmdt1, vo);
												 break;
											 }
										 }
										 continue;
									 } else {
										 
										 preDBVO.get(x).setPagerows("X");
										 PriSpScpRtRoutViaVO vo = preDBVO.get(x);
										 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setPrcProgStsCd("I");
										 vo.setSrcInfoCd("AD");
										 curTmpVoList.add(vo);
										 continue;
									 }
									 
									 
									 
								 } 
							 }
							 
						 }

						 
					 } else {
						 //------------
						 // current db row count == current(excel) row count
						 //------------
						 
						 //
						 //when current db srcInfoCd is all AM     -> remove current db and compare previous db (2)
						 //when current db srcInfoCd is not all AM -> (1) current db code(NW,AM) equal with current data
						 //													-> using current db info
						 //												  current db code(AD) do not equal with current data
						 //													-> using current db info
						 //                                           (3) current db code(AM) does not exists in current data
						 //(1)
						 
						 boolean isAmendedAll2 = isAllAmendedInDataLocationVia(curDBVO);
						 
						 List<PriSpScpRtRoutViaVO> tmpCmdt1 =  new ArrayList<PriSpScpRtRoutViaVO>();
						 tmpCmdt1.addAll(curTmpVoList);
						 
						 for(int i = (curDBVO.size() - 1); i >= 0; i--){
							 String curDbCd       = curDBVO.get(i).getRoutViaPortDefCd();
							 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
							 String curDbPages    = curDBVO.get(i).getPagerows();
							 int    noCntInCur = 0;
							 
							 boolean isExists = existsLocationVia(tmpCmdt1, curDbCd);
							 if(isExists){
								 for(int x = 0; x < tmpCmdt1.size(); x++){
									 String cd       = tmpCmdt1.get(x).getRoutViaPortDefCd();
									 String pages    = tmpCmdt1.get(x).getPagerows();
									 if(!curDbCd.equals(cd) && curDbSrc.equals("AM")){
										 noCntInCur++;
										 break;
									 }

									 if(curDbCd.equals(cd) && StringUtils.isEmpty(pages)){
										 curDBVO.get(i).setPagerows("X");
										 PriSpScpRtRoutViaVO vo = curDBVO.get(i);
										 changeSameLocationVia(curTmpVoList, vo);
										 changeSameLocationVia(tmpCmdt1, vo);
										 break;
									 }
								 }
							 } else {
								 
								 for(int x = 0; x < curTmpVoList.size(); x++){
									 String cd       = curTmpVoList.get(x).getRoutViaPortDefCd();
									 if(!curDbCd.equals(cd) && !curDbSrc.equals("AD")){
										 noCntInCur++;
										 break;
									 }
									 
									 if(!curDbCd.equals(cd) && StringUtils.isEmpty(curDbPages)){
										 curDBVO.get(i).setPagerows("X");
										 PriSpScpRtRoutViaVO vo = curDBVO.get(i);
										 curTmpVoList.add(vo);
										 break;
									 }
								 }
							 }
							 
							 if(noCntInCur > 0 && curDbSrc.equals("AM") ){
								 curDBVO.remove(i);
							 }
						 	 
						 }
						 
						 int noUseCurDbCnt = getNoUseDataCntForVOLocationVia(curDBVO);
						 int noUseCurCnt   = getNoUseDataCntForVOLocationVia(curTmpVoList);
						 
						 //(2)
						 //compare preDB data with cur data
						 //when preDB code equal with cur data        -> use preDB Info
						 //when preDB code do not equal with cur data -> use preDB Info and srcInfoCd(AD)
						 if(isAmendedAll2){
							 if(preDBVO != null && preDBVO.size() > 0 && noUseCurCnt > 0){
								 for(int x = 0; x < preDBVO.size(); x++){
									 String preDbCd       = preDBVO.get(x).getRoutViaPortDefCd();
									 
									 boolean isExists = existsLocationVia(curTmpVoList, preDbCd);
									 if(isExists){
										 for(int i = 0; i < curTmpVoList.size(); i++){
											 String cd       = curTmpVoList.get(i).getRoutViaPortDefCd();
											 if(preDbCd.equals(cd) && curTmpVoList.get(i).getPagerows() == null){
												 preDBVO.get(x).setPagerows("X");
												 PriSpScpRtRoutViaVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameLocationVia(curTmpVoList, vo);
												 break;
											 }
										 }
										 continue;
									 } else {
										 
										 preDBVO.get(x).setPagerows("X");
										 PriSpScpRtRoutViaVO vo = preDBVO.get(x);
										 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setPrcProgStsCd("I");
										 vo.setSrcInfoCd("AD");
										 curTmpVoList.add(vo);
										 continue;
									 }
									 
									 
								 } 
							 }
						 }
						 
						 //(3)
						 //no use code in current db code(AM) 1 and no use code in current data is 1
						 //change current db code to current code
						 noUseCurCnt   = getNoUseDataCntForVOLocationVia(curTmpVoList);
						 if(noUseCurCnt > 0){
							 for(int x = 0; x < curTmpVoList.size(); x++){
								 String curDbPagerows   = curTmpVoList.get(x).getPagerows();
								 //change curDB to cur
								 //using new(=cur) info and only change to the CmdtHdrSeq and CmdtSeq in curDB 
								 if((curDbPagerows == null || curDbPagerows.equals("")) && ((noUseCurDbCnt >= 1 && noUseCurCnt >= 1) && (noUseCurDbCnt == noUseCurCnt))){
									 if(curDBVO != null && curDBVO.size() > 0){
										 for(int i = 0; i < curDBVO.size(); i++){
											 String curPagerows  = curDBVO.get(i).getPagerows();
											 String curSrcInfoCd = curDBVO.get(i).getSrcInfoCd();
											 if(StringUtils.isEmpty(curPagerows) && isSrcInfoNw(curSrcInfoCd)){
												 curDBVO.get(i).setPagerows("X");
												 curTmpVoList.get(x).setCmdtHdrSeq(curDBVO.get(i).getCmdtHdrSeq());
												 curTmpVoList.get(x).setRoutSeq(curDBVO.get(i).getRoutSeq());
												 curTmpVoList.get(x).setRoutViaSeq(curDBVO.get(i).getRoutViaSeq());
												 curTmpVoList.get(x).setPrcProgStsCd("I");
												 curTmpVoList.get(x).setSrcInfoCd("AM");
												 break;
											 }
										 }
									 }
									 
								 }
							 }
						 }
						 
					 }

				 } //end if(curDBVO != null && curDBVO.size() > 0)
			 } // end if(rowType.equals("U"))

			 viaVoList.addAll(curTmpVoList);

		 } catch (DAOException ex) {
			 throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
         } catch (Exception ex) {
        	 throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
         }
	 }
	 /**
	  * make PriSpScpRtVO with RsltRtListHorizontalExcelVO and add it to List<PriSpScpRtVO> <br>
	  * 
	  * @param String rowType
	  * @param List<PriSpScpRtVO> rtVoList : the result object to be created
	  * @param RsltRtListHorizontalExcelVO row : a row of the uploaded excel(target row)
	  * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO : the master data of contract(include with prop_no, amdt_seq etc...)
	  * @param int nextCmdtHdrSeq
	  * @param int nextRoutSeq
	  * @param String strCreUsrId
	  * @param String strUpdUsrId
	  * @exception EventException
	  */
	 private void makeRtForCreate(String rowType, List<PriSpScpRtVO> rtVoList, RsltRtListHorizontalExcelVO row, PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO, 
			                       int nextCmdtHdrSeq, int nextRoutSeq, String strCreUsrId, String strUpdUsrId) throws EventException {

		 try {
			 //CUR LIST
			 List<PriSpScpRtVO> curTmpVoList   = new ArrayList<PriSpScpRtVO>();
			 //get current info data to compare
			 List<PriSpScpRtVO> tVO            = new ArrayList<PriSpScpRtVO>();
			 //previous AmdtSeq's DB Info
			 List<PriSpScpRtVO> preDBVO        = new ArrayList<PriSpScpRtVO>();
			 //current AmdtSeq's DB Info
			 List<PriSpScpRtVO> curDBVO        = new ArrayList<PriSpScpRtVO>();
			 
			 if(rowType.equals("U") || (rowType.equals("D") && !priSpScpRtCmdtHdrVO.getAmdtSeq().equals("0") )){				 
				 tVO = dbDao.searchPriSpScpRtList(priSpScpRtCmdtHdrVO, row.getCmdtHdrSeq(), row.getRoutSeq(), row.getPrcCgoTpCd());
				 if(tVO.size() == 0){
					 return;
				 }
				 preDBVO        = getRtForAmdtSeq(tVO, priSpScpRtCmdtHdrVO.getAmdtSeq(), false);
				 curDBVO        = getRtForAmdtSeq(tVO, priSpScpRtCmdtHdrVO.getAmdtSeq(), true);
			 }

			 if(rowType.equals("U") || rowType.equals("C")){
				 
				 if( priSpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && (curDBVO == null || curDBVO.size() == 0) && rowType.equals("U") ){
					 return;
				 }
				 
				 String tmpPrcCgoTpCd = row.getPrcCgoTpCd();
				 String rates = row.getRate20()+";"+row.getRate40()+";"+row.getRate40hc()+";"+row.getRate45()+";";
				 
				 if(rates != null && !rates.equals("")) {
					 String[] arrRate = rates.split(";");
					 
					 if(arrRate.length > 0) {
						 String txCmdtSeq = "";
						 String txRoutSeq = "";
						 if(rowType.equals("C") && row.getCmdtHdrSeq().equals("")){
							 txCmdtSeq = String.valueOf(nextCmdtHdrSeq);
				         } else {
				        	 txCmdtSeq = row.getCmdtHdrSeq();
				         }
						 if(rowType.equals("C") && row.getRoutSeq().equals("")){
				        	 txRoutSeq = String.valueOf(nextRoutSeq);
				         } else {
				        	 txRoutSeq = row.getRoutSeq();
				         } 
								 
						 for(int i = 0; i < arrRate.length; i++) {
							 String strRatUtCd = "";
							 if(arrRate[i] != null && !arrRate[i].equals("")) {
								 String strPrefix = row.getPrefixNm();
								 if(i == 0){
									 strRatUtCd = strPrefix+"2";
								 } else if(i == 1){
									 strRatUtCd = strPrefix+"4";
								 } else if(i == 2){
									 strRatUtCd = strPrefix+"5";
								 } else if(i == 3){
									 strRatUtCd = strPrefix+"7";
								 }
							 } 
							 
							 if(arrRate[i] == null || arrRate[i].equals("")) {
								 continue;
							 }

							 PriSpScpRtVO vo = new PriSpScpRtVO();
							 vo.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
				             vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
				             vo.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
				             vo.setGenSpclRtTpCd(priSpScpRtCmdtHdrVO.getGenSpclRtTpCd());
				             
				             vo.setCmdtHdrSeq(txCmdtSeq);
				             vo.setRoutSeq(txRoutSeq);

			                 vo.setRtSeq("");
			                 vo.setRatUtCd(strRatUtCd);
			                 vo.setPrcCgoTpCd(tmpPrcCgoTpCd);
			                 vo.setCurrCd("USD");
			                 vo.setPropFrtRtAmt(arrRate[i]);
			                 vo.setGriApplTpCd("N");
			                 vo.setGriApplAmt("0");
			                 vo.setPrcProgStsCd("I");
			                 vo.setSrcInfoCd("NW");
			                 vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
			                 vo.setCreUsrId(strCreUsrId);
			                 vo.setUpdUsrId(strUpdUsrId);
			                  
			                 if(rowType.equals("C")){
					        	 rtVoList.add(vo);
					         } else {
					        	 curTmpVoList.add(vo);
					         }
							 
						 }
					 }
				 }
			 } else if(rowType.equals("D")){
				 
				 if( priSpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && rowType.equals("D") ){
					 return;
				 }
				 
				 //TYPE(D) AND EXSITS DATA IN DB
				 if(curDBVO != null && curDBVO.size() > 0){
					 
					 for(int i = 0; i < curDBVO.size(); i++){
						 curDBVO.get(i).setIbflag(rowType);
						 curDBVO.get(i).setPrcProgStsCd("I");
						 curDBVO.get(i).setSrcInfoCd("AD");
						 curDBVO.get(i).setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
						 curDBVO.get(i).setCreUsrId(strCreUsrId);
						 curDBVO.get(i).setUpdUsrId(strUpdUsrId);
					 }
					 
					 rtVoList.addAll(curDBVO);
				 }
				 
			 }
			 
			 if(!priSpScpRtCmdtHdrVO.getAmdtSeq().equals("0") && rowType.equals("U")){
				 if(curDBVO != null && curDBVO.size() > 0){
					 
					 if(curDBVO.size() != curTmpVoList.size()){
						 //------------
						 // current db row count != current(excel) row count
						 //------------
						 
						 //when current db codes(NW,AM) are equal with current data, use current db info
						 //when current data code are not equal with current db code -> already include in current data
						 //(1)
						 for(int i = 0; i < curDBVO.size(); i++){
							 String curDbCd       = curDBVO.get(i).getRatUtCd()+curDBVO.get(i).getPrcCgoTpCd()+curDBVO.get(i).getPropFrtRtAmt();
							 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
							 String curDbPagerows = curDBVO.get(i).getPagerows();
							 for(int x = 0; x < curTmpVoList.size(); x++){
								 String curCd = curTmpVoList.get(x).getRatUtCd()+curTmpVoList.get(x).getPrcCgoTpCd()+curTmpVoList.get(x).getPropFrtRtAmt();
								 if(curDbCd.equals(curCd) && ( isSrcInfoNw(curDbSrc) || curDbSrc.equals("AM") ) && StringUtils.isEmpty(curDbPagerows)){
									 curDBVO.get(i).setPagerows("X");
									 PriSpScpRtVO vo = curDBVO.get(i);
									 changeSameRate(curTmpVoList, vo);
								 }
							 }
						 }
						 
						 int noUseCurDbCnt = getNoUseDataCntForVORate(curDBVO);
						 int noUseCurCnt   = getNoUseDataCntForVORate(curTmpVoList);
						 
						 boolean isAmendedAll1 = isAllAmendedInDataRate(curDBVO);
						 if(!isAmendedAll1){
							 //when there are some diffent codes
							 
							 //different codes(NW) -> using current db code(with AD)
							 //different codes(AM) -> compare preDB
							 //                       current db code is different with previous db code and it's seq is same and there is no comparing current data
							 //						  	-->using previous db info(with AD)
							 //						  current db code is same with previous db code and it's seq is not same and there are comparing current datas
							 //                         -->using prevois db info
							 for(int i = 0; i < curDBVO.size(); i++){
								 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
								 String curDbCd       = curDBVO.get(i).getRatUtCd()+curDBVO.get(i).getPrcCgoTpCd()+curDBVO.get(i).getPropFrtRtAmt();
								 String curDbRtSeq  = curDBVO.get(i).getRtSeq();
								 String curDbPagerows = curDBVO.get(i).getPagerows();
								 if(StringUtils.isEmpty(curDbPagerows) && isSrcInfoNw(curDbSrc)){
									 curDBVO.get(i).setPagerows("X");
									 PriSpScpRtVO vo = curDBVO.get(i);
									 vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
									 vo.setPrcProgStsCd("I");
									 vo.setSrcInfoCd("AD");
									 curTmpVoList.add(vo);								 
								 } else if(StringUtils.isEmpty(curDbPagerows) && curDbSrc.equals("AM")){
									 if(preDBVO != null && preDBVO.size() > 0){
										 for(int x = 0; x < preDBVO.size(); x++){
											 String preDbCd       = preDBVO.get(x).getRatUtCd()+preDBVO.get(x).getPrcCgoTpCd()+preDBVO.get(x).getPropFrtRtAmt();
											 String preDbRtSeq    = preDBVO.get(x).getRtSeq();
											 String preDbPagerows = preDBVO.get(x).getPagerows();
											 if( !curDbCd.equals(preDbCd) && curDbRtSeq.equals(preDbRtSeq) && noUseCurCnt == 0 && StringUtils.isEmpty(preDbPagerows)){
												 preDBVO.get(x).setPagerows("X");
												 PriSpScpRtVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
												 vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
												 vo.setPrcProgStsCd("I");
												 vo.setSrcInfoCd("AD");
												 changeSameRate(curTmpVoList, vo);
												 break;
												 
											 } else if( curDbCd.equals(preDbCd) && !curDbRtSeq.equals(preDbRtSeq) && noUseCurCnt != 0 && StringUtils.isEmpty(preDbPagerows)){
												 preDBVO.get(x).setPagerows("X");
												 curDBVO.get(i).setPagerows("X");
												 PriSpScpRtVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameRate(curTmpVoList, vo);
												 break;
												 
											 }
										 }
									 }
									 
								 }
							 }
							 
						 } else if(isAmendedAll1 && noUseCurDbCnt != 0){
							 //when diffent codes are all, compare previous db and current data
							 
							 //previous data codes are same with current data code     -> use previous datas
							 //previous data codes are not same with current data code -> use previous datas(AD)
							 List<PriSpScpRtVO> tmpCmdt1 =  new ArrayList<PriSpScpRtVO>();
							 tmpCmdt1.addAll(curTmpVoList);
							 if(preDBVO != null && preDBVO.size() > 0){
								 for(int x = 0; x < preDBVO.size(); x++){
									 String preDbCd       = preDBVO.get(x).getRatUtCd()+preDBVO.get(x).getPrcCgoTpCd()+preDBVO.get(x).getPropFrtRtAmt();
									 
									 
									 boolean isExists = existsRate(tmpCmdt1, preDbCd);
									 if(isExists){
										 for(int i = 0; i < tmpCmdt1.size(); i++){
											 String cd = tmpCmdt1.get(i).getRatUtCd()+tmpCmdt1.get(i).getPrcCgoTpCd()+tmpCmdt1.get(i).getPropFrtRtAmt();
											 
											 if(preDbCd.equals(cd) && tmpCmdt1.get(i).getPagerows() == null){
												 preDBVO.get(x).setPagerows("X");
												 PriSpScpRtVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameRate(curTmpVoList, vo);
												 changeSameRate(tmpCmdt1, vo);
												 break;
											 }
										 }
										 continue;
									 } else {
										 
										 preDBVO.get(x).setPagerows("X");
										 PriSpScpRtVO vo = preDBVO.get(x);
										 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setPrcProgStsCd("I");
										 vo.setSrcInfoCd("AD");
										 curTmpVoList.add(vo);
										 continue;
									 }
									 
								 } 
							 }
							 
						 }

						 
					 } else {
						 //------------
						 // current db row count == current(excel) row count
						 //------------
						 
						 //
						 //when current db srcInfoCd is all AM     -> remove current db and compare previous db (2)
						 //when current db srcInfoCd is not all AM -> (1) current db code(NW,AM) equal with current data
						 //													-> using current db info
						 //												  current db code(AD) do not equal with current data
						 //													-> using current db info
						 //                                           (3) current db code(AM) does not exists in current data
						 //(1)
						 
						 boolean isAmendedAll2 = isAllAmendedInDataRate(curDBVO);
						 
						 List<PriSpScpRtVO> tmpCmdt1 =  new ArrayList<PriSpScpRtVO>();
						 tmpCmdt1.addAll(curTmpVoList);
						 
						 for(int i = (curDBVO.size() - 1); i >= 0; i--){
							 String curDbCd       = curDBVO.get(i).getRatUtCd()+curDBVO.get(i).getPrcCgoTpCd()+curDBVO.get(i).getPropFrtRtAmt();
							 String curDbSrc      = curDBVO.get(i).getSrcInfoCd();
							 String curDbPages    = curDBVO.get(i).getPagerows();
							 int    noCntInCur = 0;
							 boolean isExists = existsRate(tmpCmdt1, curDbCd);
							 if(isExists){
								 for(int x = 0; x < tmpCmdt1.size(); x++){
									 String cd       = tmpCmdt1.get(x).getRatUtCd()+tmpCmdt1.get(x).getPrcCgoTpCd()+tmpCmdt1.get(x).getPropFrtRtAmt();
									 String pages    = tmpCmdt1.get(x).getPagerows();
									 if(!curDbCd.equals(cd) && curDbSrc.equals("AM")){
										 noCntInCur++;
										 break;
									 }

									 if(curDbCd.equals(cd) && StringUtils.isEmpty(pages)){
										 curDBVO.get(i).setPagerows("X");
										 PriSpScpRtVO vo = curDBVO.get(i);
										 changeSameRate(curTmpVoList, vo);
										 changeSameRate(tmpCmdt1, vo);
										 break;
									 }
								 }
							 } else {
								 
								 for(int x = 0; x < curTmpVoList.size(); x++){
									 String cd       = curTmpVoList.get(x).getRatUtCd()+curTmpVoList.get(x).getPrcCgoTpCd()+curTmpVoList.get(x).getPropFrtRtAmt();
									 if(!curDbCd.equals(cd) && !curDbSrc.equals("AD")){
										 noCntInCur++;
										 break;
									 }
									 
									 if(!curDbCd.equals(cd) && StringUtils.isEmpty(curDbPages)){
										 curDBVO.get(i).setPagerows("X");
										 PriSpScpRtVO vo = curDBVO.get(i);
										 curTmpVoList.add(vo);
										 break;
									 }
								 }
							 }
							 
							 if(noCntInCur > 0 && curDbSrc.equals("AM") ){
								 curDBVO.remove(i);
							 }
						 	 
						 }
						 
						 int noUseCurDbCnt = getNoUseDataCntForVORate(curDBVO);
						 int noUseCurCnt   = getNoUseDataCntForVORate(curTmpVoList);
						 
						 //(2)
						 //compare preDB data with cur data
						 //when preDB code equal with cur data        -> use preDB Info
						 //when preDB code do not equal with cur data -> use preDB Info and srcInfoCd(AD)
						 if(isAmendedAll2){
							 if(preDBVO != null && preDBVO.size() > 0 && noUseCurCnt > 0){
								 for(int x = 0; x < preDBVO.size(); x++){
									 String preDbCd       = preDBVO.get(x).getRatUtCd()+preDBVO.get(x).getPrcCgoTpCd()+preDBVO.get(x).getPropFrtRtAmt();
									 
									 boolean isExists = existsRate(curTmpVoList, preDbCd);
									 if(isExists){
										 for(int i = 0; i < curTmpVoList.size(); i++){
											 String cd = curTmpVoList.get(i).getRatUtCd()+curTmpVoList.get(i).getPrcCgoTpCd()+curTmpVoList.get(i).getPropFrtRtAmt();
											 
											 if(preDbCd.equals(cd) && curTmpVoList.get(i).getPagerows() == null){
												 preDBVO.get(x).setPagerows("X");
												 PriSpScpRtVO vo = preDBVO.get(x);
												 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
												 changeSameRate(curTmpVoList, vo);
												 break;
											 }
										 }
										 continue;
									 } else {
										 
										 preDBVO.get(x).setPagerows("X");
										 PriSpScpRtVO vo = preDBVO.get(x);
										 vo.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setN1stCmncAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
										 vo.setPrcProgStsCd("I");
										 vo.setSrcInfoCd("AD");
										 curTmpVoList.add(vo);
										 continue;
									 }
									 
									 
								 } 
							 }
						 }
						 
						 //(3)
						 //no use code in current db code(AM) 1 and no use code in current data is 1
						 //change current db code to current code
						 noUseCurCnt   = getNoUseDataCntForVORate(curTmpVoList);
						 if(noUseCurCnt > 0){
							 for(int x = 0; x < curTmpVoList.size(); x++){
								 String curDbPagerows   = curTmpVoList.get(x).getPagerows();
								 //change curDB to cur
								 //using new(=cur) info and only change to the CmdtHdrSeq and CmdtSeq in curDB 
								 if((curDbPagerows == null || curDbPagerows.equals("")) && ((noUseCurDbCnt >= 1 && noUseCurCnt >= 1) && (noUseCurDbCnt == noUseCurCnt))){
									 if(curDBVO != null && curDBVO.size() > 0){
										 for(int i = 0; i < curDBVO.size(); i++){
											 String curPagerows  = curDBVO.get(i).getPagerows();
											 String curSrcInfoCd = curDBVO.get(i).getSrcInfoCd();
											 if(StringUtils.isEmpty(curPagerows) && isSrcInfoNw(curSrcInfoCd)){
												 curDBVO.get(i).setPagerows("X");
												 curTmpVoList.get(x).setCmdtHdrSeq(curDBVO.get(i).getCmdtHdrSeq());
												 curTmpVoList.get(x).setRoutSeq(curDBVO.get(i).getRoutSeq());
												 curTmpVoList.get(x).setRtSeq(curDBVO.get(i).getRtSeq());
												 curTmpVoList.get(x).setPrcProgStsCd("I");
												 curTmpVoList.get(x).setSrcInfoCd("AM");
												 break;
											 }
										 }
									 }
									 
								 }
							 }
						 }
					 }
				 } //end if(curDBVO != null && curDBVO.size() > 0)
			 } // end if(rowType.equals("U"))

			 rtVoList.addAll(curTmpVoList); 
			 
		 } catch (DAOException ex) {
			 throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
         } catch (Exception ex) {
        	 throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
         }
	 }	
	 
	 /**
	  * return the code of the parameter code name(strOrgVal) in code book list<br>
	  * 
	  * @param ArrayList<CodeInfo> codeList
	  * @param String strOrgVal
	  * @return String
	  */
	 private String getCodeInCodeBook(ArrayList<CodeInfo> codeList, String strOrgVal){
		 String result = "";
		 
		 String strOrg = strOrgVal.toLowerCase().replaceAll("\\s", "");//replace blank
		 for(int i = 0; i < codeList.size(); i++){
			 String strTarget = codeList.get(i).getName().toLowerCase().replaceAll("\\s", "");
			 if(strOrg.equals(strTarget)){
				 result = codeList.get(i).getCode();
				 break;
			 }
		 }
		 
		 return result;
	 }
	 /**
	  * return the same data with the parameter amdtSeq when isEqual is true<br>
	  * return the no same data with the parameter amdtSeq when isEqual is false<br>
	  * 
	  * @param List<PriSpScpRtCmdtVO> tmpVO
	  * @param String amdtSeq
	  * @param boolean isEqual
	  * @return List<PriSpScpRtCmdtVO>
	  */
	 private List<PriSpScpRtCmdtVO> getCmdtInfoForAmdtSeq(List<PriSpScpRtCmdtVO> tmpVO, String amdtSeq, boolean isEqual){
		 
		 List<PriSpScpRtCmdtVO> vo = new ArrayList<PriSpScpRtCmdtVO>(); 
		 if(tmpVO != null && tmpVO.size() > 0){
			 for(int i = 0; i < tmpVO.size(); i++){
				 String strAmdtSeq = tmpVO.get(i).getAmdtSeq();
				 if(isEqual){
					 if(strAmdtSeq.equals(amdtSeq)){
						 vo.add(tmpVO.get(i)); 
					 }
				 } else {
					 if(!strAmdtSeq.equals(amdtSeq)){
						 vo.add(tmpVO.get(i)); 
					 }
				 }
			 }
			 
		 }
		 
		 return vo;
	 }
	 /**
	  * return the same data with the parameter amdtSeq when isEqual is true<br>
	  * return the no same data with the parameter amdtSeq when isEqual is false<br>
	  * 
	  * @param List<PriSpScpRtActCustVO> tmpVO
	  * @param String amdtSeq
	  * @param boolean isEqual
	  * @return List<PriSpScpRtActCustVO>
	  */
	 private List<PriSpScpRtActCustVO> getCustForAmdtSeq(List<PriSpScpRtActCustVO> tmpVO, String amdtSeq, boolean isEqual){
		 
		 List<PriSpScpRtActCustVO> vo = new ArrayList<PriSpScpRtActCustVO>(); 
		 if(tmpVO != null && tmpVO.size() > 0){
			 for(int i = 0; i < tmpVO.size(); i++){
				 String strAmdtSeq = tmpVO.get(i).getAmdtSeq();
				 if(isEqual){
					 if(strAmdtSeq.equals(amdtSeq)){
						 vo.add(tmpVO.get(i)); 
					 }
				 } else {
					 if(!strAmdtSeq.equals(amdtSeq)){
						 vo.add(tmpVO.get(i)); 
					 }
				 }
			 }
			 
		 }
		 
		 return vo;
	 }
	 /**
	  * return the same data with the parameter amdtSeq when isEqual is true<br>
	  * return the no same data with the parameter amdtSeq when isEqual is false<br>
	  * 
	  * @param List<PriSpScpRtRoutPntVO> tmpVO
	  * @param String amdtSeq
	  * @param boolean isEqual
	  * @return List<PriSpScpRtRoutPntVO>
	  */
	 private List<PriSpScpRtRoutPntVO> getRoutPntForAmdtSeq(List<PriSpScpRtRoutPntVO> tmpVO, String amdtSeq, boolean isEqual){
		 
		 List<PriSpScpRtRoutPntVO> vo = new ArrayList<PriSpScpRtRoutPntVO>(); 
		 if(tmpVO != null && tmpVO.size() > 0){
			 for(int i = 0; i < tmpVO.size(); i++){
				 String strAmdtSeq = tmpVO.get(i).getAmdtSeq();
				 if(isEqual){
					 if(strAmdtSeq.equals(amdtSeq)){
						 vo.add(tmpVO.get(i)); 
					 }
				 } else {
					 if(!strAmdtSeq.equals(amdtSeq)){
						 vo.add(tmpVO.get(i)); 
					 }
				 }
			 }
			 
		 }
		 
		 return vo;
	 }
	 /**
	  * return the same data with the parameter amdtSeq when isEqual is true<br>
	  * return the no same data with the parameter amdtSeq when isEqual is false<br>
	  * 
	  * @param List<PriSpScpRtRoutViaVO> tmpVO
	  * @param String amdtSeq
	  * @param boolean isEqual
	  * @return List<PriSpScpRtRoutViaVO>
	  */
	 private List<PriSpScpRtRoutViaVO> getRoutViaForAmdtSeq(List<PriSpScpRtRoutViaVO> tmpVO, String amdtSeq, boolean isEqual){
		 
		 List<PriSpScpRtRoutViaVO> vo = new ArrayList<PriSpScpRtRoutViaVO>(); 
		 if(tmpVO != null && tmpVO.size() > 0){
			 for(int i = 0; i < tmpVO.size(); i++){
				 String strAmdtSeq = tmpVO.get(i).getAmdtSeq();
				 if(isEqual){
					 if(strAmdtSeq.equals(amdtSeq)){
						 vo.add(tmpVO.get(i)); 
					 }
				 } else {
					 if(!strAmdtSeq.equals(amdtSeq)){
						 vo.add(tmpVO.get(i)); 
					 }
				 }
			 }
			 
		 }
		 
		 return vo;
	 }
	 /**
	  * return the same data with the parameter amdtSeq when isEqual is true<br>
	  * return the no same data with the parameter amdtSeq when isEqual is false<br>
	  * 
	  * @param List<PriSpScpRtRoutDirVO> tmpVO
	  * @param String amdtSeq
	  * @param boolean isEqual
	  * @return List<PriSpScpRtRoutDirVO>
	  */
	 private List<PriSpScpRtRoutDirVO> getRoutDirForAmdtSeq(List<PriSpScpRtRoutDirVO> tmpVO, String amdtSeq, boolean isEqual){
		 
		 List<PriSpScpRtRoutDirVO> vo = new ArrayList<PriSpScpRtRoutDirVO>(); 
		 if(tmpVO != null && tmpVO.size() > 0){
			 for(int i = 0; i < tmpVO.size(); i++){
				 String strAmdtSeq = tmpVO.get(i).getAmdtSeq();
				 if(isEqual){
					 if(strAmdtSeq.equals(amdtSeq)){
						 vo.add(tmpVO.get(i)); 
					 }
				 } else {
					 if(!strAmdtSeq.equals(amdtSeq)){
						 vo.add(tmpVO.get(i)); 
					 }
				 }
			 }
			 
		 }
		 
		 return vo;
	 }
	 
	 /**
	  * return the same data with the parameter amdtSeq when isEqual is true<br>
	  * return the no same data with the parameter amdtSeq when isEqual is false<br>
	  * 
	  * @param List<PriSpScpRtVO> tmpVO
	  * @param String amdtSeq
	  * @param boolean isEqual
	  * @return List<PriSpScpRtVO>
	  */
	 private List<PriSpScpRtVO> getRtForAmdtSeq(List<PriSpScpRtVO> tmpVO, String amdtSeq, boolean isEqual){
		 
		 List<PriSpScpRtVO> vo = new ArrayList<PriSpScpRtVO>(); 
		 if(tmpVO != null && tmpVO.size() > 0){
			 for(int i = 0; i < tmpVO.size(); i++){
				 String strAmdtSeq = tmpVO.get(i).getAmdtSeq();
				 if(isEqual){
					 if(strAmdtSeq.equals(amdtSeq)){
						 vo.add(tmpVO.get(i)); 
					 }
				 } else {
					 if(!strAmdtSeq.equals(amdtSeq)){
						 vo.add(tmpVO.get(i)); 
					 }
				 }
			 }
			 
		 }
		 
		 return vo;
	 }

	 
	 /**
	  * count the no using data<br>
	  * (mark X in the compared data already) <br>
	  * 
	  * @param List<PriSpScpRtCmdtVO> vo
	  * @return int
	  */
	 private int getNoUseDataCntForVOCmdt(List<PriSpScpRtCmdtVO> vo) {
		 int result = 0;
		 if(vo.size() > 0){
			 for(int i = 0; i < vo.size(); i++){
				 String flgCnt = vo.get(i).getPagerows();

				 if(StringUtils.isEmpty(flgCnt)){
					 result++;
				 }
			 }
		 }
		 return result;
	 }
	 
	 /**
	  * count the no using data<br>
	  * (mark X in the compared data already) <br>
	  * 
	  * @param List<PriSpScpRtActCustVO> vo
	  * @return int
	  */
	 private int getNoUseDataCntForVOCust(List<PriSpScpRtActCustVO> vo) {
		 int result = 0;
		 if(vo.size() > 0){
			 for(int i = 0; i < vo.size(); i++){
				 String flgCnt = vo.get(i).getPagerows();

				 if(StringUtils.isEmpty(flgCnt)){
					 result++;
				 }
			 }
		 }
		 return result;
	 }
	 
	 /**
	  * count the no using data<br>
	  * (mark X in the compared data already) <br>
	  * 
	  * @param List<PriSpScpRtRoutPntVO> vo
	  * @return int
	  */
	 private int getNoUseDataCntForVOLocation(List<PriSpScpRtRoutPntVO> vo) {
		 int result = 0;
		 if(vo.size() > 0){
			 for(int i = 0; i < vo.size(); i++){
				 String flgCnt = vo.get(i).getPagerows();

				 if(StringUtils.isEmpty(flgCnt)){
					 result++;
				 }
			 }
		 }
		 return result;
	 }
	 
	 /**
	  * count the no using data<br>
	  * (mark X in the compared data already) <br>
	  * 
	  * @param List<PriSpScpRtRoutViaVO> vo
	  * @return int
	  */
	 private int getNoUseDataCntForVOLocationVia(List<PriSpScpRtRoutViaVO> vo) {
		 int result = 0;
		 if(vo.size() > 0){
			 for(int i = 0; i < vo.size(); i++){
				 String flgCnt = vo.get(i).getPagerows();

				 if(StringUtils.isEmpty(flgCnt)){
					 result++;
				 }
			 }
		 }
		 return result;
	 }
	 
	 /**
	  * count the no using data<br>
	  * (mark X in the compared data already) <br>
	  * 
	  * @param List<PriSpScpRtVO> vo
	  * @return int
	  */
	 private int getNoUseDataCntForVORate(List<PriSpScpRtVO> vo) {
		 int result = 0;
		 if(vo.size() > 0){
			 for(int i = 0; i < vo.size(); i++){
				 String flgCnt = vo.get(i).getPagerows();

				 if(StringUtils.isEmpty(flgCnt)){
					 result++;
				 }
			 }
		 }
		 return result;
	 }

	/**
	 * Retrieving BackEndJob's status value<br>
	 * 
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String comBakEndJbVOs(String key) throws EventException {
        try {
        	return dbDao.comBakEndJbVOs(key);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    
    
	/****************************************************************************************/
	/* ESM_PRI_0099  BackEndJob End       */
	/****************************************************************************************/
    
}