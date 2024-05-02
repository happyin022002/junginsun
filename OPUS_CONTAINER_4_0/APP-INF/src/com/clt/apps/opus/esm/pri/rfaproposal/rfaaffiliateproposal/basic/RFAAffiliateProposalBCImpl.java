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
package com.clt.apps.opus.esm.pri.rfaproposal.rfaaffiliateproposal.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.esm.pri.rfaproposal.rfaaffiliateproposal.integration.RFAAffiliateProposalDBDAO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaaffiliateproposal.vo.CstPriRpAfilVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaaffiliateproposal.vo.PriRpAfilInqVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaaffiliateproposal.vo.RsltAfilListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaaffiliateproposal.vo.RsltPriRpAfilHdrVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaaffiliateproposal.vo.RsltPriRpAfilVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRpAfilVO;
import com.clt.syscommon.common.table.PriRpMnVO;

/**
 * SCProposal Business Logic Basic Command implementation<br>
 * - Handling a biz logic about SCProposal<br>
 *
 * @author 
 * @see ESM_PRI_0025EventResponse,SCAffiliateProposalBC - refer to each DAO class
 * @since J2EE 1.6
 */
public class RFAAffiliateProposalBCImpl extends BasicCommandSupport implements RFAAffiliateProposalBC {

	// Database Access Object
	private transient RFAAffiliateProposalDBDAO dbDao = null;

	/**
	 * creating SCAffiliateProposalBCImpl object<br>
	 * creating SCAffiliateProposalDBDAO.<br>
	 */
	public RFAAffiliateProposalBCImpl() {
		dbDao = new RFAAffiliateProposalDBDAO();
	}
	
	/**
	 * Retrieving Affiliate List<br>
	 * 
	 * @param PriRpAfilVO priRpAfilVO
	 * @return List<RsltPriRpAfilVO>
	 * @exception EventException
	 */
	public List<RsltPriRpAfilVO> searchAffiliateList(PriRpAfilVO priRpAfilVO) throws EventException {
		try {
			return dbDao.searchAffiliateList(priRpAfilVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * Modifying Affiliate List <br>
	 * 
	 * @param PriRpAfilVO[] priRpAfilVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAffiliate(PriRpAfilVO[] priRpAfilVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriRpAfilVO> insertVoList = new ArrayList<PriRpAfilVO>();
			List<PriRpAfilVO> updateVoList = new ArrayList<PriRpAfilVO>();
			List<PriRpAfilVO> deleteVoList = new ArrayList<PriRpAfilVO>();
			for ( int i=0; i<priRpAfilVO .length; i++ ) {
				if ( priRpAfilVO[i].getIbflag().equals("I")){
					priRpAfilVO[i].setCreUsrId(account.getUsr_id());
					priRpAfilVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priRpAfilVO[i]);
				} else if ( priRpAfilVO[i].getIbflag().equals("U")){
					priRpAfilVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priRpAfilVO[i]);
				} else if ( priRpAfilVO[i].getIbflag().equals("D")){
					deleteVoList.add(priRpAfilVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addmanageAffiliateS(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymanageAffiliateS(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removemanageAffiliateS(deleteVoList);
			}
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * Accepting Affiliate<br>
	 * 
	 * @param PriRpAfilVO[] priRpAfilVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAffiliate(PriRpAfilVO[] priRpAfilVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriRpAfilVO> updateVoList = new ArrayList<PriRpAfilVO>();
			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
			
			for ( int i=0; i<priRpAfilVO .length; i++ ) {
				if ( priRpAfilVO[i].getIbflag().equals("U")){
					priRpAfilVO[i].setUpdUsrId(account.getUsr_id());
					priRpAfilVO[i].setAcptUsrId(account.getUsr_id());
					priRpAfilVO[i].setAcptOfcCd(account.getOfc_cd());								
					priRpAfilVO[i].setAcptDt(currentDate);						
					updateVoList.add(priRpAfilVO[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymanageAffiliateS(updateVoList);
			}

        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	/**
	 * Cancelling accepting Affiliate<br>
	 * 
	 * @param PriRpAfilVO[] priRpAfilVO 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAffiliate(PriRpAfilVO[] priRpAfilVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriRpAfilVO> updateVoList = new ArrayList<PriRpAfilVO>();

			for ( int i=0; i<priRpAfilVO .length; i++ ) {
				if ( priRpAfilVO[i].getIbflag().equals("U")){
					priRpAfilVO[i].setUpdUsrId(account.getUsr_id());
					priRpAfilVO[i].setAcptUsrId("");
					priRpAfilVO[i].setAcptOfcCd("");								
					priRpAfilVO[i].setAcptDt(null);							
					updateVoList.add(priRpAfilVO[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymanageAffiliateS(updateVoList);
			}

        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}		
	
	/**
	 * Accepting all acceptance of Affiliate<br>
	 * 
	 * @param CstPriRpAfilVO cstPriRpAfilVO 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllAffiliate(CstPriRpAfilVO cstPriRpAfilVO, SignOnUserAccount account) throws EventException{
		try {

			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
			if (cstPriRpAfilVO != null  ) {
				cstPriRpAfilVO.setUpdUsrId(account.getUsr_id());					
				cstPriRpAfilVO.setAcptUsrId(account.getUsr_id());
				cstPriRpAfilVO.setAcptOfcCd(account.getOfc_cd());
				cstPriRpAfilVO.setPrcProgStsCd(cstPriRpAfilVO.getStsCd());
				cstPriRpAfilVO.setAcptDt(currentDate);			
				dbDao.modifyAcceptAllAffiliate (cstPriRpAfilVO);	

			}


        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}		
	/**
	 * Cancelling all acceptance of Affiliate<br>
	 * 
	 * @param CstPriRpAfilVO cstPriRpAfilVO 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllAffiliate(CstPriRpAfilVO cstPriRpAfilVO, SignOnUserAccount account) throws EventException{
		try {
			if (cstPriRpAfilVO != null  ) {
				cstPriRpAfilVO.setUpdUsrId(account.getUsr_id());					
				cstPriRpAfilVO.setAcptUsrId("");
				cstPriRpAfilVO.setAcptOfcCd("");								
				cstPriRpAfilVO.setAcptDt(null);	
				cstPriRpAfilVO.setPrcProgStsCd(cstPriRpAfilVO.getStsCd());
				dbDao.modifyAcceptAllAffiliate (cstPriRpAfilVO);
			}	

        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}			
	
	/**
	 * Requesting Amend <br>
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

			dbDao.addAffiliateAmend (insertVoList);
				
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	

    /**
     * Copying RFA Proposal Affiliate<br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalAffiliate (RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException {
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_RP_AFIL COPY
            dbDao.addCopyProposalAffiliate(vo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    

	/**
	 * Deleting all datas with related amend seq<br>
	 * 
	 * @param PriRpMnVO priRpMnVO 
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposal(priRpMnVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	
	/**
	 * Modifying accepted datas of main duration to "Init" at one time when cancelling request<br>
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
	 * Retrieving affiliate Amend History<br>
	 * 
	 * @param PriRpAfilVO priRpAfilVO
     * @return List<RsltAfilListVO>
	 * @exception EventException
	 */
	public List<RsltAfilListVO> searchAffiliateHistoryList(PriRpAfilVO priRpAfilVO) throws EventException {
		try {
			return dbDao.searchAffiliateHistoryList(priRpAfilVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * Retrieving Affiliate Inquiry<br>
	 * 
	 * @param PriRpAfilVO priRpAfilVO 
	 * @return List<PriRpAfilInqVO>
	 * @exception EventException
	 */
	public List<PriRpAfilInqVO> searchAffiliateInquiryList(PriRpAfilVO priRpAfilVO) throws EventException {
		try {
			return dbDao.searchAffiliateInquiryList(priRpAfilVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * Retrieving basic Affiliate information by proposal no when calling from DEM/DET<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltPriRpAfilHdrVO>
	 * @exception EventException
	 */
	public List<RsltPriRpAfilHdrVO> searchAffiliateHeader(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchAffiliateHeader(priRpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
}