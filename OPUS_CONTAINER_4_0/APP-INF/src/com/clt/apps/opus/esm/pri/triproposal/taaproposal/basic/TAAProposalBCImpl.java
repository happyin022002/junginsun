/*========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TAAProposalBCImpl.java
 *@FileTitle : TAA Creation & Amendment
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.taaproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropCustInfoVO;
import com.clt.apps.opus.esm.pri.triproposal.taaproposal.integration.TAAProposalDBDAO;
import com.clt.apps.opus.esm.pri.triproposal.taaproposal.vo.RsltTaaListVO;
import com.clt.apps.opus.esm.pri.triproposal.taaproposal.vo.RsltTaaMnVO;
import com.clt.apps.opus.esm.pri.triproposal.taaproposal.vo.RsltTaaTriListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriAuthorizationVO;
import com.clt.syscommon.common.table.PriSpCtrtPtyVO;
import com.clt.syscommon.common.table.PriTriMnVO;

/**
 * TRIProposal Business Logic Command Interface<br>
 * - Handling a biz logic about TRIProposal<br>
 * 
 * @author SHKIM
 * @see EsmPri3004EventResponse,TAAProposalBC - Refer to each DAO class
 * @since J2EE 1.6
 */
public class TAAProposalBCImpl extends BasicCommandSupport implements TAAProposalBC {

    // Database Access Object
    private transient TAAProposalDBDAO dbDao = null;

    /**
     * Creating TAAProposalBCImpl Object<br>
     * Creating TAAProposalDBDAO.<br>
     */
    public TAAProposalBCImpl() {
        dbDao = new TAAProposalDBDAO();
    }

    /**
     *  Retrieving TRI Proposal TAA Main , TRI List.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return RsltTaaListVO
     * @exception EventException
     */
    public RsltTaaListVO searchTRIProposalTAAList (RsltTaaMnVO rsltTaaMnVO) throws EventException {
        try {
            RsltTaaListVO rsltTaalistVO = new RsltTaaListVO();
            List<RsltTaaMnVO> taaList = dbDao.searchTRIProposalTAAMain(rsltTaaMnVO);
            List<RsltTaaTriListVO> triList = dbDao.searchTRIProposalTAAList(rsltTaaMnVO);
            rsltTaalistVO.setRsltTaaMnVOs(taaList);
            rsltTaalistVO.setRsltTaaTriListVOs(triList);
            return rsltTaalistVO;
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Retrieving TRI Proposal TAA Main's Amdt Seq Combo Item <br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchTRIProposalTAAAmdtSeqList (RsltTaaMnVO rsltTaaMnVO) throws EventException {
        try {
            return dbDao.searchTRIProposalTAAAmdtSeqList (rsltTaaMnVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Retrieving Customer information<br>
     * 
     * @param PriSpCtrtPtyVO priSpCtrtPtyVO
     * @return List<RsltPropCustInfoVO>
     * @exception EventException
     */
    public List<RsltPropCustInfoVO> searchProposalCustomerInfo(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException {
        try {
            return dbDao.searchProposalCustomerInfo(priSpCtrtPtyVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Retrieving TRI Proposal new TAA Proposal Number<br>
     * 
     * @param String ofcCd
     * @return String
     * @exception EventException
     */
    public String searchTRIProposalTAAPropNo(String ofcCd) throws EventException {
        try {
            String taaPropNo = dbDao.searchTRIProposalTAAPropNo(ofcCd);
            return taaPropNo;
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Retrieving TRI Proposal new TAA Number <br>
     * 
     * @param String ofcCd
     * @return String
     * @exception EventException
     */
    public String searchTRIProposalTAANo(String ofcCd) throws EventException {
        try {
            String taaPropNo = dbDao.searchTRIProposalTAANo(ofcCd);
            return taaPropNo;
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Saving TRI Proposal TAA Header information<br>
     * 
     * @param RsltTaaMnVO[] rsltTaaMnVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageTRIProposalTAAHeader (RsltTaaMnVO[] rsltTaaMnVOs, SignOnUserAccount account) throws EventException {
        try {
            for (int i = 0; i < rsltTaaMnVOs.length; i++) {
                if (rsltTaaMnVOs[i].getIbflag().equals("I")) {
                    rsltTaaMnVOs[i].setCreUsrId(account.getUsr_id());
                    rsltTaaMnVOs[i].setUpdUsrId(account.getUsr_id());
                    dbDao.addmanageTRIProposalTAAHeader(rsltTaaMnVOs[i]);
                } else if (rsltTaaMnVOs[i].getIbflag().equals("D")) {
                    dbDao.removemanageTRIProposalTAAHeader(rsltTaaMnVOs[i]);
                }
            }
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     *Saving TRI Proposal TAA Main information.<br>
     * 
     * @param RsltTaaMnVO[] rsltTaaMnVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageTRIProposalTAAMain (RsltTaaMnVO[] rsltTaaMnVOs, SignOnUserAccount account) throws EventException {
        try {
            for (int i = 0; i < rsltTaaMnVOs.length; i++) {
                if (rsltTaaMnVOs[i].getIbflag().equals("I")) {
                    rsltTaaMnVOs[i].setCreUsrId(account.getUsr_id());
                    rsltTaaMnVOs[i].setUpdUsrId(account.getUsr_id());
                    dbDao.addmanageTRIProposalTAAMain(rsltTaaMnVOs[i]);
                } else if (rsltTaaMnVOs[i].getIbflag().equals("U")) {
                    rsltTaaMnVOs[i].setUpdUsrId(account.getUsr_id());
                    dbDao.modifymanageTRIProposalTAAMain(rsltTaaMnVOs[i]);
                } else if (rsltTaaMnVOs[i].getIbflag().equals("D")) {
                    dbDao.removemanageTRIProposalTAAMain(rsltTaaMnVOs[i]);
                }
            }
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Saving TRI Proposal TAA TRI List information<br>
     * 
     * @param RsltTaaTriListVO[] rsltTaaTriListVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageTRIProposalTAAList (RsltTaaTriListVO[] rsltTaaTriListVOs, SignOnUserAccount account) throws EventException {
        try {
            List<RsltTaaTriListVO> insertVoList = new ArrayList<RsltTaaTriListVO>();
            List<RsltTaaTriListVO> deleteVoList = new ArrayList<RsltTaaTriListVO>();
            for (int i = 0; i < rsltTaaTriListVOs.length; i++) {
                if (rsltTaaTriListVOs[i].getIbflag().equals("I")) {
                    rsltTaaTriListVOs[i].setCreUsrId(account.getUsr_id());
                    rsltTaaTriListVOs[i].setUpdUsrId(account.getUsr_id());
                    insertVoList.add(rsltTaaTriListVOs[i]);
                } else if (rsltTaaTriListVOs[i].getIbflag().equals("D")) {
                    deleteVoList.add(rsltTaaTriListVOs[i]);
                }
            }

            if (deleteVoList.size() > 0) {
                dbDao.removemanageTRIProposalTAAList(deleteVoList);
            }

            if (insertVoList.size() > 0) {
                dbDao.addmanageTRIProposalTAAList(insertVoList);
            }
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Confirming TRI Proposal TAA information<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void confirmTRIProposalTAA (RsltTaaMnVO rsltTaaMnVO, SignOnUserAccount account) throws EventException {
        try {
            rsltTaaMnVO.setCfmFlg("Y");
            rsltTaaMnVO.setUpdUsrId(account.getUsr_id());
            dbDao.modifyConfirmTRIProposalTAA(rsltTaaMnVO);
            dbDao.modifyAmendConfirmTRIProposalTAA(rsltTaaMnVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Canceling confirmation of TRI Proposal TAA information<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void confirmCancelTRIProposalTAA (RsltTaaMnVO rsltTaaMnVO, SignOnUserAccount account) throws EventException {
        try {
            rsltTaaMnVO.setCfmFlg("N");
            rsltTaaMnVO.setUpdUsrId(account.getUsr_id());
            dbDao.modifyConfirmTRIProposalTAA(rsltTaaMnVO);
            dbDao.modifyAmendConfirmTRIProposalTAA(rsltTaaMnVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Deleting information of current TRI Proposal TAA .<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void cancelTRIProposalTAA (RsltTaaMnVO rsltTaaMnVO, SignOnUserAccount account) throws EventException {
        try {
            dbDao.removemanageTRIProposalTAAListAll(rsltTaaMnVO);
            dbDao.removemanageTRIProposalTAAMain(rsltTaaMnVO);
            if (JSPUtil.getNull(rsltTaaMnVO.getAmdtSeq()).equals("0")) {
                // if SEQ =0,Deleting Header
                dbDao.removemanageTRIProposalTAAHeader(rsltTaaMnVO);
            } else {
                //if SEQ !=0,rolling back to previous sequence's Duration
                rsltTaaMnVO.setCfmFlg("N");
                rsltTaaMnVO.setUpdUsrId(account.getUsr_id());
                dbDao.modifyAmendConfirmTRIProposalTAA(rsltTaaMnVO);
            }
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00202",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00202",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Amending TRI Proposal TAA information.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void amendTRIProposalTAA (RsltTaaMnVO rsltTaaMnVO, SignOnUserAccount account) throws EventException {
        try {
            rsltTaaMnVO.setCreUsrId(account.getUsr_id());
            rsltTaaMnVO.setUpdUsrId(account.getUsr_id());
            // TAA Main Amend
            dbDao.addAmendTRIProposalTAAMain(rsltTaaMnVO);
            // TAA TRI List Amend
            dbDao.addAmendTRIProposalTAAList(rsltTaaMnVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    
    /**
     * Retrieving TRI Inquiry List <br>
     * 
     * @param PriTriMnVO priTriMnVO
     * @return List<RsltTaaMnVO>
     * @exception EventException
     */
    public List<RsltTaaMnVO> searchTRIProposalTAAInquiryList(PriTriMnVO priTriMnVO) throws EventException {
        try {
            return dbDao.searchTRIProposalTAAInquiryList(priTriMnVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Retrieving TRI Proposal Select List<br>
     * 
     * @param RsltTaaTriListVO rsltTaaTriListVO
     * @return List<RsltTaaTriListVO>
     * @exception EventException
     */
    public List<RsltTaaTriListVO> searchTRIProposalSelectList(RsltTaaTriListVO rsltTaaTriListVO) throws EventException {
        try {
            return dbDao.searchTRIProposalSelectList(rsltTaaTriListVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Retrieving TRI Proposal TAA No List  <br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return List<RsltTaaMnVO>
     * @exception EventException
     */
    public List<RsltTaaMnVO> searchTRIProposalTAANoList(RsltTaaMnVO rsltTaaMnVO) throws EventException {
        try {
            return dbDao.searchTRIProposalTAANoList(rsltTaaMnVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     *  Checking whether TRI Proposal TAA information is in use at Booking .<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return String[]
     * @exception EventException
     */
    public String[] searchTRIProposalTAACheckUseBkg(RsltTaaMnVO rsltTaaMnVO) throws EventException {
        try {
            return dbDao.searchTRIProposalTAACheckUseBkg(rsltTaaMnVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Retrieving TRI Proposal TAA 's approval authority<br>
     * 
     * @param PriAuthorizationVO priAuthorizationVO
     * @return String
     * @exception EventException
     */
    public String searchTRIProposalTAAApprovalAuth(PriAuthorizationVO priAuthorizationVO) throws EventException {
        try {
            return dbDao.searchTRIProposalTAAApprovalAuth(priAuthorizationVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

}