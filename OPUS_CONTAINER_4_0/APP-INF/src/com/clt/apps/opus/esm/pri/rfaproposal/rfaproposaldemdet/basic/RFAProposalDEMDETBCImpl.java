/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RfaProposalDEMDETBCImpl.java
*@FileTitle : RFA Proposal Creation [Amend] (DEM&DET)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposaldemdet.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposaldemdet.integration.RFAProposalDEMDETDBDAO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposaldemdet.vo.RsltDmdtExptHisListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposaldemdet.vo.RsltDmdtExptListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropMnVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRpDmdtVO;
import com.clt.syscommon.common.table.PriRpMnVO;

/**
 * RFAProposal Business Logic Basic Command implementation<br>
 * - Handling a biz logic about RFAProposal<br>
 *
 * @author
 * @see ESM_PRI_2058EventResponse,RfaProposalDEMDETBC - refer to each DAO class
 * @since J2EE 1.6
 */
public class RFAProposalDEMDETBCImpl extends BasicCommandSupport implements RFAProposalDEMDETBC {

	// Database Access Object
	private transient RFAProposalDEMDETDBDAO dbDao = null;

	/**
	 * Creating RfaProposalDEMDETBCImpl <br>
	 * Creating RfaProposalDEMDETDBDAO<br>
	 */
	public RFAProposalDEMDETBCImpl() {
		dbDao = new RFAProposalDEMDETDBDAO();
	}
	/**
	 * Retrieving DEM&DET<br>
	 * 
	 * @param PriRpDmdtVO priRpDmdtVO
	 * @return List<RsltDmdtExptListVO>
	 * @exception EventException
	 */
	public List<RsltDmdtExptListVO> searchDEMDETExceptionList(PriRpDmdtVO priRpDmdtVO) throws EventException {
		try {
			return dbDao.searchDEMDETExceptionList(priRpDmdtVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * Modifying DEM&DET<br>
	 * 
	 * @param PriRpDmdtVO[] priRpDmdtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageDEMDETException(PriRpDmdtVO[] priRpDmdtVOs, SignOnUserAccount account) throws EventException{
		try {
			List<PriRpDmdtVO> insertVoList = new ArrayList<PriRpDmdtVO>();
			List<PriRpDmdtVO> updateVoList = new ArrayList<PriRpDmdtVO>();
			List<PriRpDmdtVO> deleteVoList = new ArrayList<PriRpDmdtVO>();
			for ( int i=0; i<priRpDmdtVOs .length; i++ ) {
				if ( priRpDmdtVOs[i].getIbflag().equals("I")){
					priRpDmdtVOs[i].setCreUsrId(account.getUsr_id());
					priRpDmdtVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priRpDmdtVOs[i]);
				} else if ( priRpDmdtVOs[i].getIbflag().equals("U")){
					priRpDmdtVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priRpDmdtVOs[i]);
				} else if ( priRpDmdtVOs[i].getIbflag().equals("D")){
					priRpDmdtVOs[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(priRpDmdtVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addDEMDETExceptionList(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyDEMDETExceptionList(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeDEMDETExceptionList(deleteVoList);
			}
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * Accepting DEM&DET<br>
	 * 
	 * @param PriRpDmdtVO[] priRpDmdtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptDEMDETException(PriRpDmdtVO[] priRpDmdtVO, SignOnUserAccount account) throws EventException {
		try {
			List<PriRpDmdtVO> updateVoList = new ArrayList<PriRpDmdtVO>();
			
			for(int i=0; priRpDmdtVO != null && i < priRpDmdtVO.length; i++) {
				if(priRpDmdtVO[i].getIbflag().equals("U")) {
					priRpDmdtVO[i].setUpdUsrId(account.getUsr_id());
					priRpDmdtVO[i].setAcptUsrId(account.getUsr_id());
					priRpDmdtVO[i].setAcptOfcCd(account.getOfc_cd());			
					String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());			
					priRpDmdtVO[i].setAcptDt(currentDate);
					updateVoList.add(priRpDmdtVO[i]);
				}
			}

			if(updateVoList.size() > 0)	{
				dbDao.modifyDEMDETExceptionList(updateVoList);
			}
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * Cancelling an acceptance of DEM&DET<br>
	 * 
	 * @param PriRpDmdtVO[] priRpDmdtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelDEMDETException(PriRpDmdtVO[] priRpDmdtVOs, SignOnUserAccount account) throws EventException {
		try {
		
			List<PriRpDmdtVO> updateVoList = new ArrayList<PriRpDmdtVO>();
			
			for(int i=0; priRpDmdtVOs != null && i < priRpDmdtVOs.length; i++) {
				if(priRpDmdtVOs[i].getIbflag().equals("U")) {
					priRpDmdtVOs[i].setUpdUsrId(account.getUsr_id());
					priRpDmdtVOs[i].setAcptUsrId("");
					priRpDmdtVOs[i].setAcptOfcCd("");			
					priRpDmdtVOs[i].setAcptDt(null);
					updateVoList.add(priRpDmdtVOs[i]);
				}
			}
			
			if(updateVoList.size() > 0)	{
				dbDao.modifyDEMDETExceptionList(updateVoList);
			}
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}

	
	/**
	 * Adding/Modifying DEM&DET<br>
	 * 
	 * @param RfaPropMnVO rfaPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(RfaPropMnVO rfaPropMnVO, SignOnUserAccount account) throws EventException{
		try {
			
			PriRpDmdtVO[] dmdtVo = rfaPropMnVO.getPriRpDmdtVOs();
			PriRpMnVO[] mnVo = rfaPropMnVO.getPriRpMnVOs();
			
			List<PriRpDmdtVO> insertVoList = new ArrayList<PriRpDmdtVO>();
			List<PriRpDmdtVO> updateVoList = new ArrayList<PriRpDmdtVO>();
			
			String propNo = dbDao.searchCreationProposalNo(mnVo[0].getPropOfcCd());
			for ( int i = 0; dmdtVo != null && i < dmdtVo.length; i++ ) {
				if ( dmdtVo[i].getIbflag().equals("I")){
					dmdtVo[i].setPropNo(propNo);
					dmdtVo[i].setAmdtSeq("0");
					dmdtVo[i].setCreUsrId(account.getUsr_id());
					dmdtVo[i].setUpdUsrId(account.getUsr_id());	
					
					dmdtVo[i].setPrcProgStsCd("I");
					dmdtVo[i].setSrcInfoCd("NW");
					dmdtVo[i].setN1stCmncAmdtSeq("0");
					insertVoList.add(dmdtVo[i]);
				} else if ( dmdtVo[i].getIbflag().equals("U")){
					dmdtVo[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(dmdtVo[i]);
				} 
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addDEMDETExceptionList (insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalDEMDETException (updateVoList);
			}
		
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * Checking accepted data to "init" at one tome when cancelling request<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priRpMnVO != null  ) {
				priRpMnVO.setUpdUsrId(account.getUsr_id());		
				dbDao.modifyProposalRequestCancel(priRpMnVO);
			}						
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
	 * Deleting all datas of related amend seq no when cancelling init status of main<br>
	 * 
	 * @param PriRpMnVO priRpMnVO 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {
			if (priRpMnVO != null){
				dbDao.removeProposalDmdt(priRpMnVO);
			}
			
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * Accepting automatically when requesting Main<br>
	 * 
	 * @param PriRpDmdtVO priRpDmdtVO 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalDEMDETException(PriRpDmdtVO priRpDmdtVO, SignOnUserAccount account) throws EventException{
		try {
			if (priRpDmdtVO != null  ) {
				priRpDmdtVO.setUpdUsrId(account.getUsr_id());	
				priRpDmdtVO.setAcptUsrId(account.getUsr_id());
				priRpDmdtVO.setAcptOfcCd(account.getOfc_cd());
				dbDao.modifyProposalAutoAccept(priRpDmdtVO);

			}						
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
	 * Requesting amendment<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {

			List<PriRpMnVO> insertVoList = new ArrayList<PriRpMnVO>();
			
			priRpMnVO.setCreUsrId(account.getUsr_id());
			priRpMnVO.setUpdUsrId(account.getUsr_id());					
			insertVoList.add(priRpMnVO);
// pri_sp_afil creation
			dbDao.addProposalDmdtAmend (insertVoList);
				
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
	 * Retrieving DEM&DET Amendment History <br>
	 * 
	 * @param PriRpDmdtVO priRpScpDmdtVO
	 * @return List<RsltDmdtExptHisListVO>
	 * @exception EventException
	 */
	public List<RsltDmdtExptHisListVO> searchDEMDETExceptionHistoryList(PriRpDmdtVO priRpScpDmdtVO) throws EventException {
		try {
			return dbDao.searchDEMDETExceptionHistoryList(priRpScpDmdtVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	

    /**
     * Copying RFA Proposal DEM/DET<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalDemDet(RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_RP_DMDT COPY
            dbDao.addCopyProposalDemDet(vo);
        } catch (DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
        } catch (Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
        }
    }
    
    
    /**
     * Creating RFA Proposal DEM/DET after copying PRS information.<br>
     * 
     * @param RsltCopyToProposalVO vo 
     * @param SignOnUserAccount account
     * @throws DAOException
     */
    /*public void copyToProposalRqDmdt(RsltCopyToProposalVO vo, SignOnUserAccount account) throws EventException{
       try {
    	    vo.setCreUsrId(account.getUsr_id());
    	    vo.setUpdUsrId(account.getUsr_id());
			//office
    	    vo.setQttnOfcCd(account.getOfc_cd());
			
    	    int chk = 0;
    	    
			//PRI_RP_DMDT
			chk = dbDao.addCopyRfaQuotationPriRqCpPriRpDmdt(vo);
			if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
       } catch(EventException ex) {
			throw ex;		
       } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
       } catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
       }
    }*/
    
}