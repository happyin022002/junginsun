/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGOHChargeProposalBCImpl.java
*@FileTitle : S/C Proposal 및 Amendment시  GOH 생성/수정하는 화면
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scgohchargeproposal.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.esm.pri.scproposal.scgohchargeproposal.integration.SCGOHChargeProposalDBDAO;
import com.clt.apps.opus.esm.pri.scproposal.scgohchargeproposal.vo.CstPriSpScpGohChgVO;
import com.clt.apps.opus.esm.pri.scproposal.scgohchargeproposal.vo.RsltGohChgListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpGohChgVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;

/**
 * SCProposal Business Logic Basic Command implementation<br>
 * - Handling a biz logic about SCProposal<br>
 *
 * @author 
 * @see ESM_PRI_0003_06EventResponse,SCGOHChargeProposalBC - refer to each DAO class
 * @since J2EE 1.6
 */
public class SCGOHChargeProposalBCImpl extends BasicCommandSupport implements SCGOHChargeProposalBC {

	// Database Access Object
	private transient SCGOHChargeProposalDBDAO dbDao = null;

	/**
	 * Creating SCGOHChargeProposalBCImpl object<br>
	 * Creating SCGOHChargeProposalDBDAO<br>
	 */
	public SCGOHChargeProposalBCImpl() {
		dbDao = new SCGOHChargeProposalDBDAO();
	}
	
	/**
	 * Retrieving S/C Proposal Creation - GOH List <br>
	 * 
	 * @param PriSpScpGohChgVO priSpScpGohChgVO
	 * @return List<RsltGohChgListVO>
	 * @exception EventException
	 */
	public List<RsltGohChgListVO> searchGOHChargeList(PriSpScpGohChgVO priSpScpGohChgVO) throws EventException {
		try {
			return dbDao.searchGOHChargeList(priSpScpGohChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Modifying S/C Proposal Creation - GOH List. <br>
	 * 
	 * @param PriSpScpGohChgVO[] priSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGOHCharge(PriSpScpGohChgVO[] priSpScpGohChgVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpScpGohChgVO> insertVoList = new ArrayList<PriSpScpGohChgVO>();
			List<PriSpScpGohChgVO> updateVoList = new ArrayList<PriSpScpGohChgVO>();
			List<PriSpScpGohChgVO> deleteVoList = new ArrayList<PriSpScpGohChgVO>();
			for ( int i=0; i<priSpScpGohChgVO .length; i++ ) {
				if ( priSpScpGohChgVO[i].getIbflag().equals("I")){
					priSpScpGohChgVO[i].setCreUsrId(account.getUsr_id());
					priSpScpGohChgVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priSpScpGohChgVO[i]);
				} else if ( priSpScpGohChgVO[i].getIbflag().equals("U")){
					priSpScpGohChgVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSpScpGohChgVO[i]);
				} else if ( priSpScpGohChgVO[i].getIbflag().equals("D")){
					deleteVoList.add(priSpScpGohChgVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addProposalGOHCharge(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalGOHCharge(updateVoList, "N");
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeProposalGOHCharge(deleteVoList);
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Accepting S/C Proposal Creation - GOH <br>
	 * 
	 * @param PriSpScpGohChgVO priSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptGOHCharge(PriSpScpGohChgVO[] priSpScpGohChgVO, SignOnUserAccount account) throws EventException {
		try {
		
			List<PriSpScpGohChgVO> updateVoList = new ArrayList<PriSpScpGohChgVO>();
			
			for(int i=0; priSpScpGohChgVO != null && i < priSpScpGohChgVO.length; i++) {
				if(priSpScpGohChgVO[i].getIbflag().equals("U")) {
					priSpScpGohChgVO[i].setUpdUsrId(account.getUsr_id());	
					priSpScpGohChgVO[i].setAcptUsrId(account.getUsr_id());
					priSpScpGohChgVO[i].setAcptOfcCd(account.getOfc_cd());			
					String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());			
					priSpScpGohChgVO[i].setAcptDt(currentDate);
					updateVoList.add(priSpScpGohChgVO[i]);
				}	
			}
			
			if(updateVoList.size() > 0) {
				dbDao.modifyProposalGOHCharge(updateVoList, "Y");
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Canceling an acceptance of S/C Proposal Creation - GOH<br>
	 * 
	 * @param PriSpScpGohChgVO priSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGOHCharge(PriSpScpGohChgVO[] priSpScpGohChgVO, SignOnUserAccount account) throws EventException {
		try {
		
			List<PriSpScpGohChgVO> updateVoList = new ArrayList<PriSpScpGohChgVO>();
			
			for(int i=0; priSpScpGohChgVO != null && i < priSpScpGohChgVO.length; i++) {
				if(priSpScpGohChgVO[i].getIbflag().equals("U")) {
					priSpScpGohChgVO[i].setUpdUsrId(account.getUsr_id());	
					priSpScpGohChgVO[i].setAcptUsrId("");
					priSpScpGohChgVO[i].setAcptOfcCd("");			
					priSpScpGohChgVO[i].setAcptDt(null);
		
					updateVoList.add(priSpScpGohChgVO[i]);
				}
			}
			
			if(updateVoList.size() > 0) {
				dbDao.modifyProposalGOHCharge(updateVoList, "Y");
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Accepting all of S/C Proposal Creation - GOH <br>
	 * 
	 * @param PriSpScpGohChgVO[] priSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptAllGOHCharge(PriSpScpGohChgVO[] priSpScpGohChgVO, SignOnUserAccount account) throws EventException {
		try {
		
			List<PriSpScpGohChgVO> updateVoList = new ArrayList<PriSpScpGohChgVO>();
			
			for(int i=0; priSpScpGohChgVO != null && i < priSpScpGohChgVO.length; i++) {
				if(priSpScpGohChgVO[i].getIbflag().equals("U")) {
					priSpScpGohChgVO[i].setUpdUsrId(account.getUsr_id());
					priSpScpGohChgVO[i].setAcptUsrId(account.getUsr_id());
					priSpScpGohChgVO[i].setAcptOfcCd(account.getOfc_cd());			
					String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());			
					priSpScpGohChgVO[i].setAcptDt(currentDate);
					updateVoList.add(priSpScpGohChgVO[i]);
				}
			}
			
			if(updateVoList.size() > 0)	{
				dbDao.modifyProposalGOHCharge(updateVoList, "Y");
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Canceling all acceptance of S/C Proposal Creation - GOH = <br>
	 * 
	 * @param PriSpScpGohChgVO[] priSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelAllGOHCharge(PriSpScpGohChgVO[] priSpScpGohChgVO, SignOnUserAccount account) throws EventException {
		try {
		
			List<PriSpScpGohChgVO> updateVoList = new ArrayList<PriSpScpGohChgVO>();
			
			for(int i=0; priSpScpGohChgVO != null && i < priSpScpGohChgVO.length; i++) {
				if(priSpScpGohChgVO[i].getIbflag().equals("U")) {
					priSpScpGohChgVO[i].setUpdUsrId(account.getUsr_id());
					priSpScpGohChgVO[i].setAcptUsrId("");
					priSpScpGohChgVO[i].setAcptOfcCd("");			
					priSpScpGohChgVO[i].setAcptDt(null);
					updateVoList.add(priSpScpGohChgVO[i]);
				}
			}
			
			if(updateVoList.size() > 0)	{
				dbDao.modifyProposalGOHCharge(updateVoList, "Y");
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Copying S/C Proposal Creation - GOH Cuideline<br>
	 * 
	 * @param CstPriSpScpGohChgVO cstPriSpScpGohChgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineGOHCharge(CstPriSpScpGohChgVO cstPriSpScpGohChgVO, SignOnUserAccount account) throws EventException {
		try {
			cstPriSpScpGohChgVO.setCreUsrId(account.getUpd_usr_id());
			cstPriSpScpGohChgVO.setUpdUsrId(account.getUpd_usr_id());
			
			dbDao.addCopyGuidelineGOHCharge(cstPriSpScpGohChgVO, account);

		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
	/**
	 * Amending data<br>
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
			
			dbDao.addProposalGOHChargeAmend (insertVoList);
				
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}	

    /**
     * Copying Proposal Scope GOH Charge information<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeGohChg(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_SP_SCP_GOH_CHG COPY
            dbDao.addCopyProposalScopeGohChg(vo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Copying Guideline GOH Charge to  Proposal Scope<br>
     * 
     * @param SpScpGlineCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineGohChg(SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            // PRI_SP_SCP_GOH_CHG COPY
            dbDao.addCopyScopeGuidelineGohChg(vo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

	
	/**
     * Checking whether copiable Guideline exists or not.<br>
     * 
     * @param CstPriSpScpGohChgVO cstPriSpScpGohChgVO
     * @return boolean
     * @exception EventException
     */
	public boolean checkGuidelineGOHChargeExist(CstPriSpScpGohChgVO cstPriSpScpGohChgVO) throws EventException {
		try {
			return dbDao.searchCheckGuidelineGOHChargeExist(cstPriSpScpGohChgVO);			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Modifying accepted data to "inot" when canceling request<br>
	 * all data by sequence is target<br>
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
	 * deleting all data by SCOPE<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void manageProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.removeProposal(priSpScpMnVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * Retrieving S/C Proposal Creation - GOH Amend History List <br>
	 * 
	 * @param PriSpScpGohChgVO priSpScpGohChgVO
	 * @return List<RsltGohChgListVO>
	 * @exception EventException
	 */
	public List<RsltGohChgListVO> searchGOHChargeHistoryList(PriSpScpGohChgVO priSpScpGohChgVO) throws EventException {
		try {
			return dbDao.searchGOHChargeHistoryList(priSpScpGohChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Retrieving SC GOH Inquiry List<br>
	 * 
	 * @param PriSpScpGohChgVO priSpScpGohChgVO
	 * @return List<RsltGohChgListVO>
	 * @exception EventException
	 */
	public List<RsltGohChgListVO> searchGOHChargeInquiryList(PriSpScpGohChgVO priSpScpGohChgVO) throws EventException {
		try {
			return dbDao.searchGOHChargeInquiryList(priSpScpGohChgVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
}