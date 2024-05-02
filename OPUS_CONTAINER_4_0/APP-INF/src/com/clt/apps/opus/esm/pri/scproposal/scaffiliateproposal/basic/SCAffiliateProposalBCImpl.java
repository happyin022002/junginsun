/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCAffiliateProposalBCImpl.java
*@FileTitle : Proposal Affiliate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scaffiliateproposal.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.esm.pri.scproposal.scaffiliateproposal.integration.SCAffiliateProposalDBDAO;
import com.clt.apps.opus.esm.pri.scproposal.scaffiliateproposal.vo.CstPriSpAfilVO;
import com.clt.apps.opus.esm.pri.scproposal.scaffiliateproposal.vo.RsltAfilListVO;
import com.clt.apps.opus.esm.pri.scproposal.scaffiliateproposal.vo.RsltPriSpAfilInqVO;
import com.clt.apps.opus.esm.pri.scproposal.scaffiliateproposal.vo.RsltPriSpAfilVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpAfilVO;
import com.clt.syscommon.common.table.PriSpMnVO;

/**
 * SCProposal Business Logic Basic Command implementation<br>
 * - Handling a biz transaction about SCProposal<br>
 *
 * @author 
 * @see ESM_PRI_0025EventResponse,SCAffiliateProposalBC - refer to each DAO class
 * @since J2EE 1.6
 */
public class SCAffiliateProposalBCImpl extends BasicCommandSupport implements SCAffiliateProposalBC {

	// Database Access Object
	private transient SCAffiliateProposalDBDAO dbDao = null;

	/**
	 * Creating SCAffiliateProposalBCImpl object<br>
	 * Creating SCAffiliateProposalDBDAO<br>
	 */
	public SCAffiliateProposalBCImpl() {
		dbDao = new SCAffiliateProposalDBDAO();
	}
	/**
	 * Retrieving Affiliate Company list<br>
	 * 
	 * @param PriSpAfilVO priSpAfilVO
	 * @return List<RsltPriSpAfilVO>
	 * @exception EventException
	 */
	public List<RsltPriSpAfilVO> searchAffiliateList(PriSpAfilVO priSpAfilVO) throws EventException {
		try {
			return dbDao.searchAffiliateList(priSpAfilVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Amendment History Inquiry - Affiliate Company list<br>
	 * 
	 * @param RsltAfilListVO pVo
	 * @return List<RsltAfilListVO>
	 * @exception EventException
	 */
	public List<RsltAfilListVO> searchAffiliateHistoryList(RsltAfilListVO pVo) throws EventException {
		try {
			return dbDao.searchAffiliateHistoryList(pVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Saving Affiliate Company  data.<br>
	 * 
	 * @param PriSpAfilVO[] priSpAfilVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAffiliate(PriSpAfilVO[] priSpAfilVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpAfilVO> insertVoList = new ArrayList<PriSpAfilVO>();
			List<PriSpAfilVO> updateVoList = new ArrayList<PriSpAfilVO>();
			List<PriSpAfilVO> deleteVoList = new ArrayList<PriSpAfilVO>();
			for ( int i=0; i<priSpAfilVO .length; i++ ) {
				if ( priSpAfilVO[i].getIbflag().equals("I")){
					priSpAfilVO[i].setCreUsrId(account.getUsr_id());
					priSpAfilVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priSpAfilVO[i]);
				} else if ( priSpAfilVO[i].getIbflag().equals("U")){
					priSpAfilVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSpAfilVO[i]);
				} else if ( priSpAfilVO[i].getIbflag().equals("D")){
					deleteVoList.add(priSpAfilVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addAffiliateS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyAffiliateS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeAffiliateS(deleteVoList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Accept Affiliate Company data<br>
	 * 
	 * @param PriSpAfilVO[] priSpAfilVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAffiliate(PriSpAfilVO[] priSpAfilVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpAfilVO> updateVoList = new ArrayList<PriSpAfilVO>();
			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
			
			for ( int i=0; i<priSpAfilVO .length; i++ ) {
				if ( priSpAfilVO[i].getIbflag().equals("U")){
					priSpAfilVO[i].setUpdUsrId(account.getUsr_id());
					priSpAfilVO[i].setAcptUsrId(account.getUsr_id());
					priSpAfilVO[i].setAcptOfcCd(account.getOfc_cd());								
					priSpAfilVO[i].setAcptDt(currentDate);						
					updateVoList.add(priSpAfilVO[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyAffiliateS(updateVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
	/**
	 * Canceling an acceptance Affiliate Company data<br>
	 * 
	 * @param PriSpAfilVO[] priSpAfilVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAffiliate(PriSpAfilVO[] priSpAfilVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpAfilVO> updateVoList = new ArrayList<PriSpAfilVO>();

			for ( int i=0; i<priSpAfilVO .length; i++ ) {
				if ( priSpAfilVO[i].getIbflag().equals("U")){
					priSpAfilVO[i].setUpdUsrId(account.getUsr_id());
					priSpAfilVO[i].setAcptUsrId("");
					priSpAfilVO[i].setAcptOfcCd("");								
					priSpAfilVO[i].setAcptDt(null);							
					updateVoList.add(priSpAfilVO[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyAffiliateS(updateVoList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}		
	
	/**
	 * Accepting all data except already accepted data in Affiliate Company data<br>
	 * 
	 * @param CstPriSpAfilVO cstPriSpAfilVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int acceptAllAffiliate(CstPriSpAfilVO cstPriSpAfilVO, SignOnUserAccount account) throws EventException{
		int rValue = 0;
		try {

			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
			if (cstPriSpAfilVO != null  ) {
				cstPriSpAfilVO.setUpdUsrId(account.getUsr_id());					
				cstPriSpAfilVO.setAcptUsrId(account.getUsr_id());
				cstPriSpAfilVO.setAcptOfcCd(account.getOfc_cd());
				cstPriSpAfilVO.setPrcProgStsCd(cstPriSpAfilVO.getStsCd());
				cstPriSpAfilVO.setAcptDt(currentDate);
				rValue = dbDao.modifyAcceptAllAffiliate (cstPriSpAfilVO);
			}


		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return rValue;
	}		
	/**
	 * Canceling all acceptance of Affiliate Company  data<br>
	 * 
	 * @param CstPriSpAfilVO cstPriSpAfilVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int cancelAllAffiliate(CstPriSpAfilVO cstPriSpAfilVO, SignOnUserAccount account) throws EventException{
		int rValue = 0;
		try {
			if (cstPriSpAfilVO != null  ) {
				cstPriSpAfilVO.setUpdUsrId(account.getUsr_id());					
				cstPriSpAfilVO.setAcptUsrId("");
				cstPriSpAfilVO.setAcptOfcCd("");								
				cstPriSpAfilVO.setAcptDt(null);	
				cstPriSpAfilVO.setPrcProgStsCd(cstPriSpAfilVO.getStsCd());
				rValue = dbDao.modifyAcceptAllAffiliate (cstPriSpAfilVO);
			}		

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return rValue;
	}			
	
	/**
	 * Request Amendment<br>
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
// pri_sp_afil creation
			dbDao.addAffiliateAmend (insertVoList);
				
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	

    /**
     * Copying Proposal Affiliate information<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalAffiliate (RsltPropCopyVO vo, SignOnUserAccount account) throws EventException {
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_SP_AFIL COPY
            dbDao.addCopyProposalAffiliate(vo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
    }
	    
	/**
	 * Deleting all data with related amend seq no when cancelling init status of main<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposal(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
	/**
	 * Changing an accepted data to "init" at one time when canceling request<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpMnVO != null  ) {
				priSpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalRequestCancel(priSpMnVO);
			}
			
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Retrieving Inquiry - Affiliate Company list<br>
	 * 
	 * @param PriSpAfilVO priSpAfilVO
	 * @return List<RsltPriSpAfilInqVO>
	 * @exception EventException
	 */
	public List<RsltPriSpAfilInqVO> searchAffiliateInquiryList(PriSpAfilVO priSpAfilVO) throws EventException {
		try {
			return dbDao.searchAffiliateInquiryList(priSpAfilVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}		
}