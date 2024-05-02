/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCLoadingAgentProposalBCImpl.java
*@FileTitle : S/C Proposal Loading Agent Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scloadingagentproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.scproposal.scloadingagentproposal.integration.SCLoadingAgentProposalDBDAO;
import com.clt.apps.opus.esm.pri.scproposal.scloadingagentproposal.vo.RsltLodgAgnListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpLodgAgnVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;

/**
 * SCProposal Business Logic Basic Command implementation<br>
 * - Handling a biz logic about SCProposal<br>
 *
 * @author 
 * @see ESM_PRI_0003_07EventResponse,SCLoadingAgentProposalBC refer to each DAO class
 * @since J2EE 1.6
 */
public class SCLoadingAgentProposalBCImpl extends BasicCommandSupport implements SCLoadingAgentProposalBC {

	// Database Access Object
	private transient SCLoadingAgentProposalDBDAO dbDao = null;

	/**
	 * Creating SCLoadingAgentProposalBCImpl Object<br>
	 * Creating SCLoadingAgentProposalDBDAO.<br>
	 */
	public SCLoadingAgentProposalBCImpl() {
		dbDao = new SCLoadingAgentProposalDBDAO();
	}
	/**
	 * Retrieving S/C Proposal Loading Agent information<br>
	 * 
	 * @param PriSpScpLodgAgnVO priSpScpLodgAgnVO  
	 * @return List<PriSpScpLodgAgnVO>
	 * @exception EventException
	 */
	public List<RsltLodgAgnListVO> searchLoadingAgentList(PriSpScpLodgAgnVO priSpScpLodgAgnVO) throws EventException {
		try {
			return dbDao.searchLoadingAgentList(priSpScpLodgAgnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	
	
	/**
	 * Deleting all data of SCOPE<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposal(priSpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Saving S/C Proposal Loading Agent information<br>
	 * 
	 * @param PriSpScpLodgAgnVO[] priSpScpLodgAgnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageLoadingAgent(PriSpScpLodgAgnVO[] priSpScpLodgAgnVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpScpLodgAgnVO> insertVoList = new ArrayList<PriSpScpLodgAgnVO>();
			List<PriSpScpLodgAgnVO> updateVoList = new ArrayList<PriSpScpLodgAgnVO>();
			List<PriSpScpLodgAgnVO> deleteVoList = new ArrayList<PriSpScpLodgAgnVO>();
			for ( int i=0; i<priSpScpLodgAgnVO .length; i++ ) {
				if ( priSpScpLodgAgnVO[i].getIbflag().equals("I")){
					priSpScpLodgAgnVO[i].setCreUsrId(account.getUsr_id());
					priSpScpLodgAgnVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priSpScpLodgAgnVO[i]);
				} else if ( priSpScpLodgAgnVO[i].getIbflag().equals("U")){
					priSpScpLodgAgnVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSpScpLodgAgnVO[i]);
				} else if ( priSpScpLodgAgnVO[i].getIbflag().equals("D")){
					deleteVoList.add(priSpScpLodgAgnVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addManageLoadingAgentS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyManageLoadingAgentS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeManageLoadingAgentS(deleteVoList);
			}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Accepting all acceptance of S/C Proposal Loading Agent information.<br>
	 * 
	 * @param PriSpScpLodgAgnVO[] priSpScpLodgAgnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllLoadingAgent(PriSpScpLodgAgnVO[] priSpScpLodgAgnVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpScpLodgAgnVO> updateVoList = new ArrayList<PriSpScpLodgAgnVO>();
			for ( int i=0; i<priSpScpLodgAgnVO .length; i++ ) {
				if ( priSpScpLodgAgnVO[i].getIbflag().equals("U")){
					priSpScpLodgAgnVO[i].setUpdUsrId(account.getUsr_id());			
					priSpScpLodgAgnVO[i].setAcptOfcCd(account.getOfc_cd());
					priSpScpLodgAgnVO[i].setAcptUsrId(account.getUsr_id());
					priSpScpLodgAgnVO[i].setAcptDt("1"); //'1'이면 SYSDATE											
					updateVoList.add(priSpScpLodgAgnVO[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyAcceptAllLoadingAgentS(updateVoList);
			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Canceling acceptance of S/C Proposal Loading Agent information<br>
	 * 
	 * @param PriSpScpLodgAgnVO[] priSpScpLodgAgnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelLoadingAgent(PriSpScpLodgAgnVO[] priSpScpLodgAgnVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpScpLodgAgnVO> updateVoList = new ArrayList<PriSpScpLodgAgnVO>();
			for ( int i=0; i<priSpScpLodgAgnVO .length; i++ ) {
				if ( priSpScpLodgAgnVO[i].getIbflag().equals("U")){
					priSpScpLodgAgnVO[i].setUpdUsrId(account.getUsr_id());
					
					priSpScpLodgAgnVO[i].setAcptOfcCd(null);
					priSpScpLodgAgnVO[i].setAcptUsrId(null);	
					priSpScpLodgAgnVO[i].setAcptDt(null);
					
					updateVoList.add(priSpScpLodgAgnVO[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCancelLoadingAgentS(updateVoList);
			}
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Accepting S/C Proposal Loading Agent information<br>
	 * 
	 * @param PriSpScpLodgAgnVO[] priSpScpLodgAgnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptLoadingAgent(PriSpScpLodgAgnVO[] priSpScpLodgAgnVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpScpLodgAgnVO> updateVoList = new ArrayList<PriSpScpLodgAgnVO>();
			for ( int i=0; i<priSpScpLodgAgnVO .length; i++ ) {
				if ( priSpScpLodgAgnVO[i].getIbflag().equals("U")){
					priSpScpLodgAgnVO[i].setUpdUsrId(account.getUsr_id());
					priSpScpLodgAgnVO[i].setAcptOfcCd(account.getOfc_cd());
					priSpScpLodgAgnVO[i].setAcptUsrId(account.getUsr_id());	
					priSpScpLodgAgnVO[i].setAcptDt("1"); //'1'이면 SYSDATE	
					updateVoList.add(priSpScpLodgAgnVO[i]);
				}
			}			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyAcceptLoadingAgentS(updateVoList);
			}			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Canceling all acceptance of S/C Proposal Loading Agent information<br>
	 * 
	 * @param PriSpScpLodgAgnVO[] priSpScpLodgAgnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllLoadingAgent(PriSpScpLodgAgnVO[] priSpScpLodgAgnVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpScpLodgAgnVO> updateVoList = new ArrayList<PriSpScpLodgAgnVO>();
			for ( int i=0; i<priSpScpLodgAgnVO .length; i++ ) {
				if ( priSpScpLodgAgnVO[i].getIbflag().equals("U")){
					priSpScpLodgAgnVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSpScpLodgAgnVO[i]);
					
					priSpScpLodgAgnVO[i].setAcptOfcCd(null);
					priSpScpLodgAgnVO[i].setAcptUsrId(null);	
					priSpScpLodgAgnVO[i].setAcptDt(null);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCancelAllLoadingAgentS(updateVoList);
			}			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Requesting Amend<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {

			List<PriSpMnVO> insertVoList = new ArrayList<PriSpMnVO>();
			
			priSpMnVO.setCreUsrId(account.getUsr_id());
			priSpMnVO.setUpdUsrId(account.getUsr_id());					
			insertVoList.add(priSpMnVO);
// (pri_sp_scp_lodg_agn)
			dbDao.addLoadingAgentAmend (insertVoList);
				
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	

    /**
     * Copying Proposal Scope Loading Agent information<br>
     * 
     * @param RsltPropCopyVO vo
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeLoading(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_SP_SCP_LODG_AGN COPY
            dbDao.addCopyProposalScopeLoading(vo);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

	/**
	 * Getting count of Terms data<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMn
	 * @return int
	 * @exception EventException
	 */
	public int searchProposalScopeDeleteCheck(PriSpScpMnVO  priSpScpMn) throws EventException {
		try {
			return dbDao.searchProposalScopeDeleteCheck(priSpScpMn);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}  
	/**
	 * Changing accepted data to "init" at once when canceling Request<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpScpMnVO != null  ) {
				priSpScpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalRequestCancel(priSpScpMnVO);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving S/C Proposal Loading Agent History information<br>
	 * 
	 * @param PriSpScpLodgAgnVO priSpScpLodgAgnVO  
	 * @return List<PriSpScpLodgAgnVO>
	 * @exception EventException
	 */
	public List<RsltLodgAgnListVO> searchLoadingAgentHistoryList(PriSpScpLodgAgnVO priSpScpLodgAgnVO) throws EventException {
		try {
			return dbDao.searchLoadingAgentHistoryList(priSpScpLodgAgnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * Retrieving S/C Proposal Loading Agent History information<br>
	 * 
	 * @param PriSpScpLodgAgnVO priSpScpLodgAgnVO  
	 * @return List<PriSpScpLodgAgnVO>
	 * @exception EventException
	 */
	public List<RsltLodgAgnListVO> searchLoadingAgentInquiryList(PriSpScpLodgAgnVO priSpScpLodgAgnVO) throws EventException {
		try {
			return dbDao.searchLoadingAgentInquiryList(priSpScpLodgAgnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
}