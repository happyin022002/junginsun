/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCContractPartyProposalBCImpl.java
*@FileTitle : Contract Parties Information
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.integration.SCContractPartyProposalDBDAO;
import com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.vo.CstPriSpCtrtPtyHVO;
import com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.vo.CstPriSpCtrtPtyVO;
import com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.vo.PriSpCtrtPtyInqVO;
import com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.vo.RsltPriSpCtrtCustTpVO;
import com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.vo.RsltPriSpCtrtPtyTypeVO;
import com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.vo.RsltPriSpCtrtPtyVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.ScPropMnVO;
//import com.clt.apps.opus.esm.pri.scquotation.scquotationmain.vo.RsltCopyToProposalVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpCtrtCustTpVO;
import com.clt.syscommon.common.table.PriSpCtrtPtyVO;
import com.clt.syscommon.common.table.PriSpMnVO;

/**
 * SCProposal Business Logic Basic Command implementation<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0022EventResponse,SCContractPartyProposalBC
 * @since J2EE 1.4
 */
public class SCContractPartyProposalBCImpl extends BasicCommandSupport implements SCContractPartyProposalBC {

	// Database Access Object
	private transient SCContractPartyProposalDBDAO dbDao = null;

	/**
	 * creating the object of SCContractPartyProposalBCImpl<br>
	 * Creating SCContractPartyProposalDBDAO<br>
	 */
	public SCContractPartyProposalBCImpl() {
		dbDao = new SCContractPartyProposalDBDAO();
	}
	
	/**
	 * Handling Amend Request <br>
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
 
			dbDao.addProposalContractPartyAmend(insertVoList);
			dbDao.addProposalContractCustomerTypeAmend(insertVoList);				
			
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		

	/**
	 * Retrieving Contract Customer Type  List<br>
	 * 
	 * @param PriSpCtrtCustTpVO priSpCtrtCustTpVO
	 * @return List<RsltPriSpCtrtCustTpVO>
	 * @exception EventException
	 */
	public List<RsltPriSpCtrtCustTpVO> searchProposalContractCustomerTypeList(PriSpCtrtCustTpVO priSpCtrtCustTpVO) throws EventException {
		try {
			return dbDao.searchProposalContractCustomerTypeList(priSpCtrtCustTpVO);			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Accepting Contract Customer Type data<br>
	 * 
	 * @param PriSpCtrtCustTpVO priSpCtrtCustTpVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalContractCustomerType(PriSpCtrtCustTpVO priSpCtrtCustTpVO,SignOnUserAccount account)  throws EventException{
		try {
		
			List<PriSpCtrtCustTpVO> updateVoList = new ArrayList<PriSpCtrtCustTpVO>();
			
			priSpCtrtCustTpVO.setUpdUsrId(account.getUsr_id());	
			priSpCtrtCustTpVO.setAcptUsrId(account.getUsr_id());
			priSpCtrtCustTpVO.setAcptOfcCd(account.getOfc_cd());			
			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());			
			priSpCtrtCustTpVO.setAcptDt(currentDate);
			
			updateVoList.add(priSpCtrtCustTpVO);

			dbDao.modifyProposalContractCustomerType (updateVoList);		
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	/**
	 * Cancelling a acceptance of Contract Customer Type data<br>
	 * 
	 * @param PriSpCtrtCustTpVO priSpCtrtCustTpVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposalContractCustomerType(PriSpCtrtCustTpVO priSpCtrtCustTpVO,SignOnUserAccount account) throws EventException{
		try {
		
			List<PriSpCtrtCustTpVO> updateVoList = new ArrayList<PriSpCtrtCustTpVO>();
			
			priSpCtrtCustTpVO.setUpdUsrId(account.getUsr_id());	
			//cancel 
			priSpCtrtCustTpVO.setAcptUsrId("C");
			priSpCtrtCustTpVO.setAcptOfcCd("C");		
			priSpCtrtCustTpVO.setAcptDt("C");

			updateVoList.add(priSpCtrtCustTpVO);

			dbDao.modifyProposalContractCustomerType (updateVoList);
		
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	/**
	 * Saving Contract Customer Type data<br>
	 * 
	 * @param PriSpCtrtCustTpVO[] priSpCtrtCustTpVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalContractCustomerType(PriSpCtrtCustTpVO[] priSpCtrtCustTpVO,SignOnUserAccount account) throws EventException{
		try {
			List<PriSpCtrtCustTpVO> updateVoList = new ArrayList<PriSpCtrtCustTpVO>();
			for ( int i=0; i<priSpCtrtCustTpVO.length; i++ ) {
				if ( priSpCtrtCustTpVO[i].getIbflag().equals("U")){
					priSpCtrtCustTpVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priSpCtrtCustTpVO[i]);
				}
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalContractCustomerType (updateVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	
	
	/**
	 * Retrieving Contract Parties List<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltPriSpCtrtPtyVO>
	 * @exception EventException
	 */
	public List<RsltPriSpCtrtPtyVO> searchProposalContractPartyList(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException {
		try {
			return dbDao.searchProposalContractPartyList(priSpCtrtPtyVO);			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	/**
	 * Retrieving Contract Party Type<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltPriSpCtrtPtyTypeVO>
	 * @exception EventException
	 */
	public List<RsltPriSpCtrtPtyTypeVO> searchProposalContractPartyTypeList(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException {
		try {
			return dbDao.searchProposalContractPartyTypeList(priSpCtrtPtyVO);			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}		
	
	/**
	 * Accepting Contract Parties data<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalContractParty(PriSpCtrtPtyVO priSpCtrtPtyVO,SignOnUserAccount account)  throws EventException{
		try {
		
			List<PriSpCtrtPtyVO> updateVoList = new ArrayList<PriSpCtrtPtyVO>();
			
			priSpCtrtPtyVO.setUpdUsrId(account.getUsr_id());	
			priSpCtrtPtyVO.setAcptUsrId(account.getUsr_id());
			priSpCtrtPtyVO.setAcptOfcCd(account.getOfc_cd());			
			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());			
			priSpCtrtPtyVO.setAcptDt(currentDate);
			
			updateVoList.add(priSpCtrtPtyVO);

			dbDao.modifyProposalContractParty (updateVoList);		
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	/**
	 * Cancelling a acceptance of Contract Parties data<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposalContractParty(PriSpCtrtPtyVO priSpCtrtPtyVO,SignOnUserAccount account) throws EventException{
		try {
		
			List<PriSpCtrtPtyVO> updateVoList = new ArrayList<PriSpCtrtPtyVO>();			
			priSpCtrtPtyVO.setUpdUsrId(account.getUsr_id());	
			priSpCtrtPtyVO.setAcptUsrId("");
			priSpCtrtPtyVO.setAcptOfcCd("");		
			priSpCtrtPtyVO.setAcptDt(null);
			updateVoList.add(priSpCtrtPtyVO);
			dbDao.modifyProposalContractParty (updateVoList);	
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	/**
	 * Saving Contract Parties data<br>
	 * 
	 * @param PriSpCtrtPtyVO[] priSpCtrtPtyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalContractParty(PriSpCtrtPtyVO[] priSpCtrtPtyVO,SignOnUserAccount account) throws EventException{
		try {
			List<PriSpCtrtPtyVO> updateVoList = new ArrayList<PriSpCtrtPtyVO>();
			for ( int i=0; i<priSpCtrtPtyVO.length; i++ ) {
				if ( priSpCtrtPtyVO[i].getIbflag().equals("U")){
					priSpCtrtPtyVO[i].setUpdUsrId(account.getUsr_id());
					if (priSpCtrtPtyVO[i].getPrcCtrtPtyTpCd().equals("P")){
						priSpCtrtPtyVO[i].setCustSeq("");
					}
					updateVoList.add(priSpCtrtPtyVO[i]);
				} 
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalContractParty (updateVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
		
	/**
	 * Saving Contract Parties,Customer Type data<br>
	 * 
	 * @param ScPropMnVO scPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(ScPropMnVO scPropMnVO, SignOnUserAccount account) throws EventException{
		try {
			
			PriSpCtrtCustTpVO[] custVo = scPropMnVO.getPriSpCtrtCustTpVOs();
			PriSpCtrtPtyVO[] ptyVo = scPropMnVO.getPriSpCtrtPtyVOs();	
			PriSpMnVO[] mnVo = scPropMnVO.getPriSpMnVOs();
			
			List<PriSpCtrtCustTpVO> insertCustVoList = new ArrayList<PriSpCtrtCustTpVO>();			
			List<CstPriSpCtrtPtyVO> insertPtyVoList = new ArrayList<CstPriSpCtrtPtyVO>();			
			List<CstPriSpCtrtPtyHVO> insertPtyHanVoList = new ArrayList<CstPriSpCtrtPtyHVO>();			
			List<PriSpCtrtCustTpVO> updateCustVoList = new ArrayList<PriSpCtrtCustTpVO>();
			List<PriSpCtrtPtyVO> updatePtyVoList = new ArrayList<PriSpCtrtPtyVO>();

			String propNo = dbDao.searchCreationProposalNo(mnVo[0].getPropOfcCd());
			for ( int i = 0; custVo != null && i < custVo.length; i++ ) {
				if ( custVo[i].getIbflag().equals("I")){
					custVo[i].setPropNo(propNo);
					custVo[i].setCreUsrId(account.getUsr_id());
					custVo[i].setUpdUsrId(account.getUsr_id());					
					insertCustVoList.add(custVo[i]);
				} else if ( custVo[i].getIbflag().equals("U")){
					custVo[i].setUpdUsrId(account.getUsr_id());
					updateCustVoList.add(custVo[i]);
				} 
			}

			for ( int i = 0; ptyVo != null && i < ptyVo.length; i++ ) {
				if ( ptyVo[i].getIbflag().equals("I")){
					ptyVo[i].setPropNo(propNo);
					ptyVo[i].setCreUsrId(account.getUsr_id());
					ptyVo[i].setUpdUsrId(account.getUsr_id());	
					
					CstPriSpCtrtPtyVO cstPtyVO = new CstPriSpCtrtPtyVO();
					CstPriSpCtrtPtyHVO ptyHVo = new CstPriSpCtrtPtyHVO();
					
					ObjectCloner.build(ptyVo[i], cstPtyVO);
					cstPtyVO.setOfcCd(mnVo[0].getPropOfcCd());					
					insertPtyVoList.add(cstPtyVO);					
					ObjectCloner.build(ptyVo[i], ptyHVo);
					//hamjin contract party
					ptyHVo.setOfcCd(mnVo[0].getPropOfcCd());
					insertPtyHanVoList.add(ptyHVo);
				} else if ( ptyVo[i].getIbflag().equals("U")){
					ptyVo[i].setUpdUsrId(account.getUsr_id());
					updatePtyVoList.add(ptyVo[i]);
				} 
			}

			//in case adding MN
			if ( insertCustVoList.size() > 0 ) {
				dbDao.addProposalContractParty(insertPtyVoList);		
				dbDao.addProposalContractPartyProvider(insertPtyHanVoList);	
				dbDao.addProposalContractCustomerType(insertCustVoList);
			}

			//update existing mn
			if ( updateCustVoList.size() > 0 ) {
				dbDao.modifyProposalContractPartyForMain(updatePtyVoList);				
				dbDao.modifyProposalContractCustomerType(updateCustVoList);
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}

    /**
     * Copying Proposal Contract Party Information.<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalContractParty(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_SP_CTRT_PTY COPY
            dbDao.addCopyProposalContractParty(vo);
            // PRI_SP_CTRT_CUST_TP COPY
            dbDao.addCopyProposalContractCustType(vo);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
        	throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    
	/**
	 * Deleting all data of related Amend Seq No when cancelling Init status of Main<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalCustTp(priSpMnVO);
			dbDao.removeProposalCtrtPty(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	 
	/**
	 * Modifying accepted datas to Init status when cancelling request<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpMnVO != null  ) {
				priSpMnVO.setUpdUsrId(account.getUsr_id());		
				dbDao.modifyProposalCustTpRequestCancel(priSpMnVO);
				dbDao.modifyProposalCtrtPtyRequestCancel(priSpMnVO);
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
	 *  Modifying Cust Type Accepted datas to Init status when cancelling request<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancelCustType(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpMnVO != null  ) {
				priSpMnVO.setUpdUsrId(account.getUsr_id());		
				dbDao.modifyProposalCustTpRequestCancel(priSpMnVO);
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	
	/**
	 *Handling Option's Font<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalContractPartyFont(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException {
		try {
			return dbDao.searchProposalContractPartyFont(priSpCtrtPtyVO);			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Contract Parties Amend History List<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltPriSpCtrtPtyVO>
	 * @exception EventException
	 */
	public List<RsltPriSpCtrtPtyVO> searchProposalContractPartyHistoryList(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException {
		try {
			return dbDao.searchProposalContractPartyHistoryList(priSpCtrtPtyVO);			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Handling SC Contract Party History Option's Font<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalContractPartyHistoryFont(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException {
		try {
			return dbDao.searchProposalContractPartyHistoryFont(priSpCtrtPtyVO);			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
     * Retrieving Contract Parties Information Inquiry List<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<PriSpCtrtPtyInqVO>
	 * @exception EventException
	 */
	public List<PriSpCtrtPtyInqVO> searchProposalContractPartyInquiryList(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException {
		try {
			return dbDao.searchProposalContractPartyInquiryList(priSpCtrtPtyVO);			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 *Retrieving Inquiry - Option's Font<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalContractPartyFontInquiry(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException {
		try {
			return dbDao.searchProposalContractPartyFontInquiry(priSpCtrtPtyVO);			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
}