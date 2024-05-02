/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAProposalMainBCImpl.java
*@FileTitle : Proposal & Amendment Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.integration.RFAProposalMainDBDAO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.CstApprovalVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.CstRequestCheckVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.CstShHistVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.CstShRInqVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.DmtScExptVerVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RequestCheckForCalculationVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropMnVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RfaPropProgVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltAmdtHisMnVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPriRpAmdHstMnVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPriRpInqVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropAmdtSmryVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropCustInfoVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropInqListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropScpAmdtSmryVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltReturnVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaAproRqstRefVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaMainStsVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltStatusVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.component.util.code.CodeUtil;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRpAmdtSmryVO;
import com.clt.syscommon.common.table.PriRpAproRqstRefUsrVO;
import com.clt.syscommon.common.table.PriRpAproRqstRefVO;
import com.clt.syscommon.common.table.PriRpHdrVO;
import com.clt.syscommon.common.table.PriRpMnVO;
import com.clt.syscommon.common.table.PriRpProgVO;
import com.clt.syscommon.common.table.PriRpScpAmdtSmryVO;
import com.clt.syscommon.common.table.PriRpScpMnVO;
import com.clt.syscommon.common.table.PriRpScpProgVO;
import com.clt.syscommon.common.table.PriSpCtrtPtyVO;


/**
 * RFAProposal Business Logic Basic Command implementation<br>
 * - handling biz logic about  RFAProposal<br>
 *
 * @author 
 * @see ESM_PRI_2003EventResponse,RFAProposalMainBC reference each DAO class
 * @since J2EE 1.4
 */

public class RFAProposalMainBCImpl extends BasicCommandSupport implements RFAProposalMainBC {

	// Database Access Object
	private transient RFAProposalMainDBDAO dbDao = null;

	/**
	 * RFAProposalMainBCImpl object creation<br>
	 * creating RFAProposalMainDBDAO <br>
	 */
	public RFAProposalMainBCImpl() {
		dbDao = new RFAProposalMainDBDAO();
	}
	/**
	 *  Retrieving RFA Proposal<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @param SignOnUserAccount account
	 * @return RsltPropListVO
	 * @exception EventException
	 */
	public RsltPropListVO searchProposalMain(PriRpHdrVO priRpHdrVO, SignOnUserAccount account) throws EventException {
		try {
			RsltPropListVO vo = new RsltPropListVO();
			vo.setRsltPropMnVOs(dbDao.searchProposalMain(priRpHdrVO, account));
			vo.setRsltPropMnScpListVOs(dbDao.searchProposalMainScpList(priRpHdrVO, account.getUsr_id()));			

			return vo;
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 *  Retrieving Customer information <br>
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
	 * saving RFA Main<br>
	 * 
	 * @param RfaPropMnVO rfaPropMnVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String manageProposal(RfaPropMnVO rfaPropMnVO, SignOnUserAccount account) throws EventException{
		String newPropNo = "";
		try {			
			PriRpHdrVO[] hdrVo = rfaPropMnVO.getPriRpHdrVOs();
			PriRpMnVO[] vo = rfaPropMnVO.getPriRpMnVOs();
			PriRpScpMnVO[] scpVo = rfaPropMnVO.getPriRpScpMnVOs();
			
			PriRpProgVO[] progVo = rfaPropMnVO.getPriRpProgVOs();
			PriRpAmdtSmryVO[] smryVo = rfaPropMnVO.getPriRpAmdtSmryVOs();			
			PriRpScpProgVO[] scpProgVo = rfaPropMnVO.getPriRpScpProgVOs();
			PriRpScpAmdtSmryVO[] scpSmryVo = rfaPropMnVO.getPriRpScpAmdtSmryVOs();
			
			List<PriRpHdrVO> insertHdrVoList = new ArrayList<PriRpHdrVO>();
			List<PriRpMnVO> insertVoList = new ArrayList<PriRpMnVO>();
			List<PriRpScpMnVO> insertScpVoList = new ArrayList<PriRpScpMnVO>();
			
			List<PriRpProgVO> insertProgVoList = new ArrayList<PriRpProgVO>();
			List<PriRpAmdtSmryVO> insertSmryVoList = new ArrayList<PriRpAmdtSmryVO>();			
			List<PriRpScpProgVO> insertScpProgVoList = new ArrayList<PriRpScpProgVO>();
			List<PriRpScpAmdtSmryVO> insertScpSmryVoList = new ArrayList<PriRpScpAmdtSmryVO>();

			List<PriRpHdrVO> updateHdrVoList = new ArrayList<PriRpHdrVO>();
			List<PriRpMnVO> updateVoList = new ArrayList<PriRpMnVO>();
			List<PriRpScpMnVO> updateScpVoList = new ArrayList<PriRpScpMnVO>();
		
			newPropNo = dbDao.searchCreationProposalNo(vo[0].getPropOfcCd());

			for ( int i = 0; hdrVo != null && i < hdrVo.length; i++ ) {
			    if (JSPUtil.getNull(hdrVo[i].getPrcPropCreTpCd()).equals("")) {
			        hdrVo[i].setPrcPropCreTpCd("G");
			    }
			    
				if ( hdrVo[i].getIbflag().equals("I")){
					hdrVo[i].setPropNo(newPropNo);
					hdrVo[i].setCreUsrId(account.getUsr_id());
					hdrVo[i].setUpdUsrId(account.getUsr_id());					
					insertHdrVoList.add(hdrVo[i]);
				} else if ( hdrVo[i].getIbflag().equals("U")){
					hdrVo[i].setUpdUsrId(account.getUsr_id());
					updateHdrVoList.add(hdrVo[i]);
				}
			}			
			
			for ( int i = 0; vo != null && i < vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("I")){
					vo[i].setPropNo(newPropNo);	
					vo[i].setCreUsrId(account.getUsr_id());
					vo[i].setUpdUsrId(account.getUsr_id());	

					insertVoList.add(vo[i]);
				} else if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());				
					updateVoList.add(vo[i]);
				} 
			}
			
			
			for ( int i = 0; progVo != null && i < progVo.length; i++ ) {
				if ( progVo[i].getIbflag().equals("I")){
					progVo[i].setPropNo(newPropNo);	
					progVo[i].setCreUsrId(account.getUsr_id());
					progVo[i].setUpdUsrId(account.getUsr_id());		
					progVo[i].setProgOfcCd(account.getOfc_cd());
					progVo[i].setProgUsrId(account.getUsr_id());								
					insertProgVoList.add(progVo[i]);
				}
			}
			
			for ( int i = 0; smryVo != null && i < smryVo.length; i++ ) {
				if ( smryVo[i].getIbflag().equals("I")){
					smryVo[i].setPropNo(newPropNo);	
					smryVo[i].setCreUsrId(account.getUsr_id());
					smryVo[i].setUpdUsrId(account.getUsr_id());					
					insertSmryVoList.add(smryVo[i]);
				}
			}			

			for ( int i = 0; scpVo != null && i < scpVo.length; i++ ) {
				if ( scpVo[i].getIbflag().equals("I")){
					if(scpVo[i].getPropNo().equals("")){
						scpVo[i].setPropNo(newPropNo);
						scpVo[i].setAmdtSeq("0");
					}
					scpVo[i].setCreUsrId(account.getUsr_id());
					scpVo[i].setUpdUsrId(account.getUsr_id());					
					insertScpVoList.add(scpVo[i]);
				} else if ( scpVo[i].getIbflag().equals("U")){
					scpVo[i].setUpdUsrId(account.getUsr_id());
					updateScpVoList.add(scpVo[i]);
				}
			}

			for ( int i = 0; scpProgVo != null && i < scpProgVo.length; i++ ) {
				if ( scpProgVo[i].getIbflag().equals("I")){
					if(scpProgVo[i].getPropNo().equals("")){
						scpProgVo[i].setPropNo(newPropNo);
						scpProgVo[i].setAmdtSeq("0");
					}					
					scpProgVo[i].setCreUsrId(account.getUsr_id());
					scpProgVo[i].setUpdUsrId(account.getUsr_id());
					scpProgVo[i].setProgOfcCd(account.getOfc_cd());
					scpProgVo[i].setProgUsrId(account.getUsr_id());					
					insertScpProgVoList.add(scpProgVo[i]);
				}
			}
			
			for ( int i = 0; scpSmryVo != null && i < scpSmryVo.length; i++ ) {
				if ( scpSmryVo[i].getIbflag().equals("I")){
					if(scpSmryVo[i].getPropNo().equals("")){
						scpSmryVo[i].setPropNo(newPropNo);
						scpSmryVo[i].setAmdtSeq("0");
					}						
					scpSmryVo[i].setCreUsrId(account.getUsr_id());
					scpSmryVo[i].setUpdUsrId(account.getUsr_id());					
					insertScpSmryVoList.add(scpSmryVo[i]);
				}
			}			
			
			//adding new mn 
			if ( insertVoList.size() > 0 ) {
				dbDao.addProposalHeader(insertHdrVoList);
				dbDao.addProposalMain(insertVoList);
				dbDao.addProposalProgress(insertProgVoList);
				dbDao.addProposalAmendmentSummary(insertSmryVoList);
			}
			
			if ( updateHdrVoList.size() > 0 ) {
				dbDao.modifyProposalHeader(updateHdrVoList);
			}			

			// update existing mn
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalMain(updateVoList);
			}		
			
			// adding new scp mn
			if ( insertScpVoList.size() > 0 ) {
				dbDao.addProposalScopeMain(insertScpVoList);
				dbDao.addProposalScopeProgress(insertScpProgVoList);
				dbDao.addProposalScopeAmendmentSummary(insertScpSmryVoList);
			}
			
			// update existing scp mn 
			if ( updateScpVoList.size() > 0 ) {
				dbDao.modifyProposalScopeMain(updateScpVoList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
		return newPropNo;
	}		
	
	/**
	 * changing RFA Proposal Master Creation's state<br>
	 * 
	 * @param RfaPropProgVO rfaPropProgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void counterofferProposal(RfaPropProgVO rfaPropProgVO, SignOnUserAccount account) throws EventException{
		try {			
			PriRpMnVO[] vo =  rfaPropProgVO.getPriRpMnVOs();
			PriRpProgVO[] pVo = rfaPropProgVO.getPriRpProgVOs();			
			List<PriRpMnVO> updateVoList = new ArrayList<PriRpMnVO>();
			List<PriRpProgVO> insertVoList = new ArrayList<PriRpProgVO>();	
			
			if (vo != null){
				for ( int i = 0; i< vo.length ; i++ ) {
					if ( vo[i].getIbflag().equals("U")){
						vo[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(vo[i]);
					} 
				}
			}
			for ( int i = 0; i < pVo.length; i++ ) {
				if ( pVo[i].getIbflag().equals("U")){
					pVo[i].setUpdUsrId(account.getUsr_id());
					pVo[i].setCreUsrId(account.getUsr_id());
					pVo[i].setProgUsrId(account.getUsr_id());
					pVo[i].setProgOfcCd(account.getOfc_cd());
					pVo[i].setProgDt(account.getUpd_dt());					
					insertVoList.add(pVo[i]);
				} 
			}			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalMain(updateVoList);
			}
			if ( insertVoList.size() > 0 ) {
				dbDao.addProposalProgress(insertVoList);	
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
     * changing Accept's state when Request, Request Canceling <br>
	 * @param PriRpAmdtSmryVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyProposalAutoAcceptAmendmentSummary(PriRpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriRpAmdtSmryVO> updateVoList = new ArrayList<PriRpAmdtSmryVO>();
		
			vo.setUpdUsrId(account.getUsr_id());
			vo.setAcptFlg("Y");
			updateVoList.add(vo);
			
			dbDao.modifyProposalAutoAcceptAmendmentSummary(updateVoList);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
     * modifying Summary about automatic accepted when S/C Proposal Request <br>
	 * 
	 * @param PriRpScpAmdtSmryVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeAutoAcceptAmendmentSummary(PriRpScpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriRpScpAmdtSmryVO> updateVoList = new ArrayList<PriRpScpAmdtSmryVO>();		
			vo.setUpdUsrId(account.getUsr_id());
			vo.setAcptFlg("Y");
			updateVoList.add(vo);			
			dbDao.modifyProposalScopeAutoAcceptAmendmentSummary(updateVoList);			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	
	/**
	 * deleting all selected Amend seq. data when deleting scope<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalScopeAmdtSmry(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalScopeAmdtSmry(priRpScpMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
	 *  deleting all selected Amend seq. data when deleting scope<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalScopeProgress(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalScopeProgress(priRpScpMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
     * Retrieving Terms's Summary<br>
	 * @param PriRpAmdtSmryVO priRpAmdtSmryVO
	 * @return List<RsltPropAmdtSmryVO>
	 * @exception EventException
	 */
	public List<RsltPropAmdtSmryVO> searchProposalAmendmentSummary(PriRpAmdtSmryVO priRpAmdtSmryVO) throws EventException {
		try {
			return dbDao.searchProposalAmendmentSummary(priRpAmdtSmryVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
     * Retrieving Scope Summary<br>
	 * 
	 * @param PriRpScpAmdtSmryVO priRpScpAmdtSmryVO
	 * @return List<RsltPropScpAmdtSmryVO>
	 * @exception EventException
	 */
	public List<RsltPropScpAmdtSmryVO> searchProposalScopeAmendmentSummary(PriRpScpAmdtSmryVO priRpScpAmdtSmryVO) throws EventException {
		try {
			return dbDao.searchProposalScopeAmendmentSummary(priRpScpAmdtSmryVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}  	
	
	/**
     * retrieving Terms for checking Accept <br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<PriRpMnVO>
	 * @exception EventException
	 */
	public List<PriRpMnVO> searchProposalAcceptCheck(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchProposalAcceptCheck(priRpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}   	
	
	/**
     * checking existence of init data in Terms to C/offer<br>
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltStatusVO>
	 * @exception EventException
	 */
	public List<RsltStatusVO> searchCountOfferStatus(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchCountOfferStatus(priRpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	/**
	 * when Request, retrieving mandatory data <br>
	 * @param PriRpMnVO priRpMnVO
	 * @return List<CstRequestCheckVO>
	 * @exception EventException
	 */
	public List<CstRequestCheckVO> searchRequestTermsCheck(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchRequestTermsCheck(priRpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	


	/**
     * when Request, retrieving scope not Calculate<br>
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @return List<RequestCheckForCalculationVO>
	 * @exception EventException
	 */
	public List<RequestCheckForCalculationVO> searchRequestCheckCalculate(PriRpScpMnVO priRpScpMnVO) throws EventException {
		try {
			return dbDao.searchRequestCheckCalculate(priRpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}


	
	/**
	 * retrieving Scope's state<br>
	 * 
	 * @param PriRpScpMnVO  priRpScpMn
     * @return List<PriRpScpMnVO>
	 * @exception EventException
	 */
	public List<PriRpScpMnVO> searchProposalScopeStatusCheck(PriRpScpMnVO  priRpScpMn) throws EventException {
		try {
			return dbDao.searchProposalScopeStatusCheck(priRpScpMn);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

	/**
	 * when deleting Scope, checking existence of Terms data<br>
	 * 
	 * @param PriRpScpMnVO  priRpScpMn
     * @return int
	 * @exception EventException
	 */
	public int searchProposalScopeDeleteCheck(PriRpScpMnVO  priRpScpMn) throws EventException {
		try {
			return dbDao.searchProposalScopeDeleteCheck(priRpScpMn);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}     
	
	/**
	 * Approving RFA main <br>
	 * 
	 * @param RfaPropProgVO rfaPropProgVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String approveProposal(RfaPropProgVO rfaPropProgVO, SignOnUserAccount account) throws EventException{
		String rfaNo = "";
		try {
			
			PriRpMnVO[] vo =  rfaPropProgVO.getPriRpMnVOs();
			PriRpProgVO[] pVo = rfaPropProgVO.getPriRpProgVOs();			
			PriRpHdrVO[] hVo = rfaPropProgVO.getPriRpHdrVOs();
			List<PriRpMnVO> updateVoList = new ArrayList<PriRpMnVO>();
			List<PriRpProgVO> insertVoList = new ArrayList<PriRpProgVO>();	
			
			
			for ( int i = 0; i< vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());					
					vo[i].setPropAproOfcCd(account.getOfc_cd());
					vo[i].setPropAproDt(account.getUpd_dt());					
					updateVoList.add(vo[i]);
				} 
			}
			
			for ( int i = 0; i< pVo.length; i++ ) {
				if ( pVo[i].getIbflag().equals("U")){
					pVo[i].setUpdUsrId(account.getUsr_id());
					pVo[i].setCreUsrId(account.getUsr_id());
					pVo[i].setProgUsrId(account.getUsr_id());
					pVo[i].setProgOfcCd(account.getOfc_cd());
					pVo[i].setProgDt(account.getUpd_dt());					
					insertVoList.add(pVo[i]);
				} 
			}			
			dbDao.modifyProposalMain(updateVoList);
			dbDao.addProposalProgress(insertVoList);	
			//APPROVAL DATE
			dbDao.modifyProposalApprovalDate(updateVoList);
			
			if (vo[0].getAmdtSeq().equals("0") && hVo[0].getRfaNo().equals("") ){
				PriRpHdrVO hdrVo = new PriRpHdrVO();
				List<PriRpHdrVO> updateHdrVoList = new ArrayList<PriRpHdrVO>();				
				hdrVo.setUpdUsrId(account.getUsr_id());
				//2014.10.15 (Modify : When it is Tariff, create RFA No -> TrfCtrtFlg add)
				rfaNo = dbDao.searchCreationRFANo(vo[0].getPropOfcCd(), vo[0].getTrfCtrtFlg());
				hdrVo.setRfaNo(rfaNo);
				hdrVo.setPropNo(vo[0].getPropNo());
				updateHdrVoList.add(hdrVo);
				dbDao.modifyProposalRFANO(updateHdrVoList);//RFA No Update				
			}

			List<PriRpMnVO> insertMnVoList = new ArrayList<PriRpMnVO>();
			PriRpMnVO mnVo = new PriRpMnVO();
			ObjectCloner.build(vo[0], mnVo);
			mnVo.setAmdtSeq(String.valueOf(Integer.valueOf(vo[0].getAmdtSeq())-1));
			mnVo.setUpdUsrId(account.getUsr_id());
			
			insertMnVoList.add(mnVo);
			dbDao.modifyProposalMainAmend(insertMnVoList);
			dbDao.modifyProposalScopeMainAmend(insertMnVoList);	
			/////////////////////////////
						
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		return rfaNo;
	}
	
	/**
	 * setting RFA Main state with previous state<br>
	 * 
	 * @param RfaPropProgVO rfaPropProgVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposal(RfaPropProgVO rfaPropProgVO, SignOnUserAccount account) throws EventException{
		try {
			
			PriRpMnVO[] vo =  rfaPropProgVO.getPriRpMnVOs();
			PriRpProgVO[] pVo = rfaPropProgVO.getPriRpProgVOs();
			
			List<PriRpMnVO> updateVoList = new ArrayList<PriRpMnVO>();
			List<PriRpProgVO> insertVoList = new ArrayList<PriRpProgVO>();			
			
			for ( int i = 0; i< vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());
					if (vo[i].getPropStsCd().equals("Q")){
						vo[i].setPropAproOfcCd("A");
					}
					updateVoList.add(vo[i]);
				} 
			}
			
			for ( int i = 0; i< pVo.length; i++ ) {
				if ( pVo[i].getIbflag().equals("U")){
					pVo[i].setUpdUsrId(account.getUsr_id());
					pVo[i].setCreUsrId(account.getUsr_id());
					pVo[i].setProgUsrId(account.getUsr_id());
					pVo[i].setProgOfcCd(account.getOfc_cd());
					pVo[i].setProgDt(account.getUpd_dt());					
					insertVoList.add(pVo[i]);
				} 
			}			
			
			dbDao.modifyProposalMain(updateVoList);
			dbDao.addProposalProgress(insertVoList);		
						
//			if (vo[0].getAmdtSeq().equals("0") && vo[0].getPropStsCd().equals("Q")){
//				PriRpHdrVO hdrVo = new PriRpHdrVO();
//				List<PriRpHdrVO> updateHdrVoList = new ArrayList<PriRpHdrVO>();		
//				hdrVo.setUpdUsrId(account.getUpd_usr_id());
//				hdrVo.setRfaNo("XX");
//				hdrVo.setPropNo(vo[0].getPropNo());
//				updateHdrVoList.add(hdrVo);
//				dbDao.modifyProposalHeader(updateHdrVoList);//RFA No Update
//			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		

	/**
     * when automatic accept canceling, updating (Main)
	 * @param PriRpAmdtSmryVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancelAmendmentSummary(PriRpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriRpAmdtSmryVO> updateVoList = new ArrayList<PriRpAmdtSmryVO>();
		
			vo.setUpdUsrId(account.getUsr_id());
			vo.setAcptFlg("N");
			updateVoList.add(vo);
			
			dbDao.modifyProposalRequestCancelAmendmentSummary(updateVoList);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
     * when automatic accept canceling, updating (Scope)
	 * @param PriRpScpAmdtSmryVO vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeRequestCancelAmendmentSummary(PriRpScpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriRpScpAmdtSmryVO> updateVoList = new ArrayList<PriRpScpAmdtSmryVO>();		
			vo.setUpdUsrId(account.getUsr_id());
			vo.setAcptFlg("N");
			updateVoList.add(vo);			
			dbDao.modifyProposalScopeRequestCancelAmendmentSummary(updateVoList);			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
	 * setting all Scope state with INIT<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyAllScopeStatus(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
				
			priRpScpMnVO.setUpdUsrId(account.getUsr_id());
			priRpScpMnVO.setPropScpStsCd("I");
			dbDao.modifyAllScopeStatus(priRpScpMnVO);
			

			PriRpScpProgVO vo = new PriRpScpProgVO();
			ObjectCloner.build(priRpScpMnVO, vo);
			vo.setProgOfcCd(account.getOfc_cd());
			vo.setProgUsrId(account.getUsr_id());
			vo.setPropScpStsCd("I");
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			dbDao.addProposalScopeProgressChange(vo);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	
	/**
	 * in case of Proposal's state = Init and canceling Initial state, modifying Main Expire Date <br>
	 * 
	 * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalMainExpiryCancel(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException{
		try {
			int amdtSeq = 0;
			
			if (priRpMnVO != null  ) {
				priRpMnVO.setUpdUsrId(account.getUsr_id());	
				PriRpMnVO vo = new PriRpMnVO();
				ObjectCloner.build(priRpMnVO, vo);
				amdtSeq = Integer.parseInt(vo.getAmdtSeq()) -1 ;				
				vo.setAmdtSeq(String.valueOf(amdtSeq));
				dbDao.modifyProposalMainExpiry (vo);
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
	 * when Init Canceling, all data deleting<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalAproRqstRefUsr(priRpMnVO);
			dbDao.removeProposalAproRqstRef(priRpMnVO);			
			dbDao.removeProposal(priRpMnVO);
			if (priRpMnVO.getAmdtSeq().equals("0")){
				dbDao.removeProposalHdr(priRpMnVO);
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
	 * when Init Canceling, all data deleting<br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalforContract(PriRpHdrVO priRpHdrVO, PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {
			String amdtSeq = priRpMnVO.getAmdtSeq();
			String minAmdtSeq = dbDao.searchCancelMinAmdtSeq(priRpMnVO);
			
			dbDao.addContractAmendmentDeleteHistory(priRpMnVO, account);
			dbDao.removeProposalAproRqstRefUsr(priRpMnVO);
			dbDao.removeProposalAproRqstRef(priRpMnVO);
			dbDao.removeProposal(priRpMnVO);
			
			if(amdtSeq.equals("0") || (!amdtSeq.equals("0") && amdtSeq.equals(minAmdtSeq))){
				dbDao.modifyContractHdrDeleteHistory(priRpHdrVO, amdtSeq);
				dbDao.removeProposalHdr(priRpMnVO);
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
	 * when Init Canceling, deleting data about this Amend seq <br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalProgress(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalProgress(priRpMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
	 * when Init Canceling, deleting data about this Amend seq <br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposalAmdtSmry(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalAmdtSmry(priRpMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
	 * when Init Canceling, deleting data about this Amend seq <br>
	 * 
	 * @param priRpScpMnVO PriRpScpMnVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void removeProposalScopeMain(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalScopeMain(priRpScpMnVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
	 * in case of Proposal's state = Init and canceling Initial state, modifying Main Expire Date <br>
	 * 
	 * @param priRpScpMnVO PriRpScpMnVO
     * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageProposalScopeMainExpiryCancel(PriRpScpMnVO priRpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			int amdtSeq = 0;
			if (priRpScpMnVO != null  ) {
				priRpScpMnVO.setUpdUsrId(account.getUsr_id());	
				PriRpScpMnVO vo = new PriRpScpMnVO();
				ObjectCloner.build(priRpScpMnVO, vo);
				amdtSeq = Integer.parseInt(vo.getAmdtSeq()) -1 ;				
				vo.setAmdtSeq(String.valueOf(amdtSeq));
				dbDao.modifyProposalScopeMainExpiryChange (vo);
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
     * Proposal Main Amendment Summary modifying <br>
	 * 
	 * @param PriRpAmdtSmryVO vo
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalAmendmentSummary(PriRpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {			
			List<PriRpAmdtSmryVO> updateVoList = new ArrayList<PriRpAmdtSmryVO>();		
			vo.setUpdUsrId(account.getUsr_id());
			updateVoList.add(vo);
			
			dbDao.modifyProposalAmendmentSummary(updateVoList);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
     * Proposal Main Amendment Summary modifying <br>
	 * @param PriRpAmdtSmryVO vo
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageAmendmentSummary(PriRpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {			
			List<PriRpAmdtSmryVO> updateVoList = new ArrayList<PriRpAmdtSmryVO>();
		
			vo.setUpdUsrId(account.getUsr_id());
			updateVoList.add(vo);			
			dbDao.modifyProposalAmendmentSummary(updateVoList);
			
			PriRpMnVO priRpMnVO = new PriRpMnVO();
			ObjectCloner.build(vo, priRpMnVO);
			dbDao.modifyAutoChangeMainStatus(priRpMnVO);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	
	
	
	/**
     * when changing Terms's state, Terms Summary modifying by Scope  <br>
	 * 
	 * @param PriRpScpAmdtSmryVO vo
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeAmendmentSummary(PriRpScpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {
			
			List<PriRpScpAmdtSmryVO> updateVoList = new ArrayList<PriRpScpAmdtSmryVO>();
		
			vo.setUpdUsrId(account.getUsr_id());
			updateVoList.add(vo);
			
			dbDao.modifyProposalScopeAmendmentSummary(updateVoList);
			dbDao.modifyProposalScopeStatus(updateVoList);

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}		
	
	/**
     * when changing Terms's state, Terms Summary modifying by Scope  <br>
	 * 
	 * @param PriRpScpAmdtSmryVO vo
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageScopeAmendmentSummary(PriRpScpAmdtSmryVO vo, SignOnUserAccount account) throws EventException{
		try {			
			List<PriRpScpAmdtSmryVO> updateVoList = new ArrayList<PriRpScpAmdtSmryVO>();		
			vo.setUpdUsrId(account.getUsr_id());
			updateVoList.add(vo);			
			dbDao.modifyProposalScopeAmendmentSummary(updateVoList);
			dbDao.modifyProposalScopeStatus(updateVoList);			
			
			PriRpScpMnVO scpVo = new PriRpScpMnVO();
			ObjectCloner.build(vo, scpVo);
			int cnt = dbDao.searchProposalScopeAcceptCheck(scpVo);
			
			if (cnt == 0) {// scope status ALL accept
				List<PriRpScpMnVO> updateScpVoList = new ArrayList<PriRpScpMnVO>();
				List<PriRpScpProgVO> insertProgVoList =  new ArrayList<PriRpScpProgVO>(); 
				PriRpScpMnVO[] priRpScpMnVO = new PriRpScpMnVO[1];
				priRpScpMnVO[0] = new PriRpScpMnVO();				
				ObjectCloner.build(scpVo, priRpScpMnVO[0]);
				priRpScpMnVO[0].setPropScpStsCd("A");
				priRpScpMnVO[0].setUpdUsrId(account.getUsr_id());				
				updateScpVoList.add(priRpScpMnVO[0]);				
				PriRpScpProgVO progVo = new PriRpScpProgVO();
				ObjectCloner.build(priRpScpMnVO[0], progVo);
				progVo.setProgOfcCd(account.getOfc_cd());	
				progVo.setProgUsrId(account.getUsr_id());
				progVo.setCreUsrId(account.getUsr_id());
				insertProgVoList .add(progVo);				
				if ( updateScpVoList.size() > 0 ) {				
					dbDao.modifyScopeStatus(updateScpVoList);
				}
	
				if ( insertProgVoList.size() > 0 ) {				
					dbDao.addProposalScopeProgress(insertProgVoList);
				}
				
			} else {				
				List<PriRpScpProgVO> insertProgVoList =  new ArrayList<PriRpScpProgVO>();				
            	scpVo.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyAutoScopeReturnStatus (scpVo);				
				if (dbDao.searchScopeProgressStatus(scpVo) == 0){
		
					PriRpScpProgVO rpScpProgVo = new PriRpScpProgVO();
					ObjectCloner.build(scpVo, rpScpProgVo);
					rpScpProgVo.setProgOfcCd(account.getOfc_cd());	
					rpScpProgVo.setProgUsrId(account.getUsr_id());
					rpScpProgVo.setCreUsrId(account.getUsr_id());
					insertProgVoList .add(rpScpProgVo);	
					if ( insertProgVoList.size() > 0 ) {				
						dbDao.addProposalScopeProgressScopeMn(insertProgVoList);
					}
				}	
			}

			PriRpMnVO mnVo = new PriRpMnVO();
            ObjectCloner.build(vo, mnVo); 
            mnVo.setUpdUsrId(account.getUsr_id());            
            dbDao.modifyAutoChangeMainStatus(mnVo);			

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	
	/**
	 * checking all TERMS ACCEPT <br>
	 * 
	 * @param PriRpScpMnVO  priRpScpMn
	 * @return int
	 * @exception EventException
	 */
	public int searchProposalScopeAcceptCheck(PriRpScpMnVO  priRpScpMn) throws EventException {
		try {
			return dbDao.searchProposalScopeAcceptCheck(priRpScpMn);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	} 	
	
	/**
     * modifying scope state by scope<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyScopeStatus(PriRpScpMnVO[] priRpScpMnVOs, SignOnUserAccount account) throws EventException{
		try {
			List<PriRpScpMnVO> updateVoList = new ArrayList<PriRpScpMnVO>();
			List<PriRpScpProgVO> insertProgVoList =  new ArrayList<PriRpScpProgVO>(); 
			
			for ( int i=0; i<priRpScpMnVOs .length; i++ ) {
				if ( priRpScpMnVOs[i].getIbflag().equals("U")){
					priRpScpMnVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priRpScpMnVOs[i]);
					PriRpScpProgVO vo = new PriRpScpProgVO();
					ObjectCloner.build(priRpScpMnVOs[i], vo);
					vo.setProgOfcCd(account.getOfc_cd());	
					vo.setProgUsrId(account.getUsr_id());
					vo.setCreUsrId(account.getUsr_id());
					insertProgVoList .add(vo);					
				}

			}		
			
			if ( updateVoList.size() > 0 ) {				
				dbDao.modifyScopeStatus(updateVoList);
			}
		
			if ( insertProgVoList.size() > 0 ) {				
				dbDao.addProposalScopeProgress(insertProgVoList);
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
	 * in case of Returned in terms, setting Scope's state = Returned<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeAutoScopeReturnStatus(PriRpScpMnVO priRpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			List<PriRpScpProgVO> insertProgVoList =  new ArrayList<PriRpScpProgVO>(); 
			if (priRpScpMnVO != null  ) {
				priRpScpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyAutoScopeReturnStatus (priRpScpMnVO);
				
				if (dbDao.searchScopeProgressStatus(priRpScpMnVO) == 0){
		
					PriRpScpProgVO vo = new PriRpScpProgVO();
					ObjectCloner.build(priRpScpMnVO, vo);
					vo.setProgOfcCd(account.getOfc_cd());	
					vo.setProgUsrId(account.getUsr_id());
					vo.setCreUsrId(account.getUsr_id());
					insertProgVoList .add(vo);	
					if ( insertProgVoList.size() > 0 ) {				
						dbDao.addProposalScopeProgressScopeMn(insertProgVoList);
					}						
				}
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
     * Proposal  Main's Status updating<br>
     * 
     * @param PriRpMnVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyMainStatus (PriRpMnVO vo, SignOnUserAccount account) throws EventException {
        try {
            vo.setUpdUsrId(account.getUsr_id());
            
            dbDao.modifyMainStatus(vo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
    }		
    
	/**
     * MAIN's  Expire Date modifying<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalMainExpiry(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priRpMnVO != null  ) {
				priRpMnVO.setUpdUsrId(account.getUsr_id());					
				dbDao.modifyProposalMainExpiry (priRpMnVO);
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
     * Scope MAIN's  Expire Date modifying<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalScopeMainExpiry(PriRpMnVO priRpMnVO,SignOnUserAccount account) throws EventException{
		try {

			if (priRpMnVO != null  ) {
				priRpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalScopeMainExpiry (priRpMnVO);
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
	 * when changing DURATION, SCOPE MAIN  Expire Date modifying<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void changeProposalScopeMainExpiry(PriRpScpMnVO priRpScpMnVO,SignOnUserAccount account) throws EventException{
		try {

			if (priRpScpMnVO != null  ) {
				priRpScpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalScopeMainExpiryChange (priRpScpMnVO);
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
     * creating Amend Data in RFA Main <br>
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
			priRpMnVO.setPropOfcCd(account.getOfc_cd());
			
			insertVoList.add(priRpMnVO);
			
			dbDao.addProposalMainAmend(priRpMnVO);
			dbDao.addProposalScopeMainAmend(insertVoList);			
			log.debug("amendProposal==exp_dt=="+priRpMnVO.getExpDt());
			if (!priRpMnVO.getExpDt().equals("")){
				log.debug("exp_dt===========main=="+priRpMnVO.getExpDt());
				dbDao.modifyProposalScopeMainAmd(insertVoList);
			}
			
			dbDao.addProposalProgressAmend(insertVoList);
			dbDao.addProposalAmendmentSummaryAmend(insertVoList);
			dbDao.addProposalScopeProgressAmend(insertVoList);
			dbDao.addProposalScopeAmendmentSummaryAmend(insertVoList);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
	 * in case of c/offer in terms, retrieving returned data<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltReturnVO>
	 * @exception EventException
	 */
	public List<RsltReturnVO> searchProposalReturnedList(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchProposalReturnedList(priRpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
    /**
     * updating Proposal  Main's Status from Returned to Request <br>
     * 
     * @param PriRpMnVO vo
     * @param SignOnUserAccount account
     * @return int
     * @exception EventException
     */
    public int changeAutoRequestMainStatus (PriRpMnVO vo, SignOnUserAccount account) throws EventException {
        int result = 0;
    	try {
            vo.setUpdUsrId(account.getUsr_id());
            
            result = dbDao.modifyAutoChangeMainStatus(vo);
            log.debug("changeAutoRequestMainStatus==result=="+result);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
        return result;
    }	
    
	/**
	 * when Amending, automatically modifying duration's amenddentSummary<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalAmendmentSummaryDuration(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {			
			log.debug("amendProposal==exp_dt==amendsummary="+priRpMnVO.getExpDt());
			if (!priRpMnVO.getExpDt().equals("")){
				log.debug("exp_dt==============summaryduration="+priRpMnVO.getExpDt());
				List<PriRpAmdtSmryVO> updateVoList = new ArrayList<PriRpAmdtSmryVO>();
				PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
				ObjectCloner.build(priRpMnVO, priRpAmdtSmryVO);
				priRpAmdtSmryVO.setPropTermTpCd("01");
				priRpAmdtSmryVO.setAmdtSeq(String.valueOf(Integer.parseInt(priRpAmdtSmryVO.getAmdtSeq()) + 1));
				priRpAmdtSmryVO.setUpdUsrId(account.getUsr_id());
				updateVoList.add(priRpAmdtSmryVO);			
				dbDao.modifyProposalAmendmentSummary(updateVoList);
				
				List<PriRpScpAmdtSmryVO> updateScpVoList = new ArrayList<PriRpScpAmdtSmryVO>();
				List<PriRpScpMnVO> list = dbDao.searchProposalScope(priRpMnVO);
				if (list != null && list.size() > 0){
					for (int i = 0; i< list.size(); i++){
						PriRpScpAmdtSmryVO vo = new PriRpScpAmdtSmryVO();
						ObjectCloner.build(priRpMnVO, vo);
            			vo.setSvcScpCd(list.get(i).getSvcScpCd());
            			vo.setPropScpTermTpCd("11");
            			vo.setAmdtSeq(String.valueOf(Integer.parseInt(vo.getAmdtSeq()) + 1)) ;
            			
            			vo.setUpdUsrId(account.getUsr_id());
            			updateScpVoList.add(vo);	
            			dbDao.modifyProposalScopeAmendmentSummary(updateScpVoList);
					}
				}
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
	 * when Approve Canceling, setting Main,Scope Expire Date to previous Approve value<br>
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalApproveCancel(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {			
			PriRpMnVO mnVo = new PriRpMnVO();
			List<PriRpMnVO> updateVoList = new ArrayList<PriRpMnVO>();

			if (priRpMnVO != null  ) {
				mnVo.setUpdUsrId(account.getUsr_id());
				mnVo.setPropNo(priRpMnVO.getPropNo());
				mnVo.setAmdtSeq(String.valueOf(Integer.valueOf(priRpMnVO.getAmdtSeq())-1));
				
				priRpMnVO.setUpdUsrId(account.getUsr_id());				
				updateVoList.add(priRpMnVO);
				
				
//				priRpMnVO.setUpdUsrId(account.getUsr_id());
//				priRpMnVO.setAmdtSeq(String.valueOf(Integer.valueOf(priRpMnVO.getAmdtSeq())-1));
				log.debug("<<<<<<<<<<<<<<<<<<<<<<<manageProposalApproveCancel<<<<<<<<<<<<<<<<<<<<<<<");
				dbDao.modifyProposalApproveCancelMain(mnVo);
				dbDao.modifyProposalApproveCancelScopeMain(mnVo);
				//APPROVAL DATE
				dbDao.modifyProposalApprovalDate(updateVoList);
				log.debug("<<<<<<<<<<<<<<<<<<<<<<<manageProposalApproveCancel<<<<<<<<<<<<<<<<<<<<<<<");
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
	 * when Request, getting DEM/DET Exception's Status for validation<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<DmtScExptVerVO>
	 * @exception EventException
	 */
	public List<DmtScExptVerVO> searchCheckDmdtList(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchCheckDmdtList(priRpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * retrieving Duration(Main,Scope) and Dem/Det change<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchCheckDurationList(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchCheckDurationList(priRpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}	
	
	
	
	
	/**
	 * retrieving Amend History Main <br>
	 * 
	 * @param PriRpHdrVO priRpHdrVO
	 * @return List<RsltPriRpAmdHstMnVO>
	 * @exception EventException
	 */
	public List<RsltPriRpAmdHstMnVO> searchAmendmentHistoryMain(PriRpHdrVO priRpHdrVO) throws EventException {
		try {
			
			return dbDao.searchAmendmentHistoryMain(priRpHdrVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}   	
	
	/**
	 * retrieving Amend History Scope List <br>
	 * 
	 * @param CstShHistVO CstShHistVO
	 * @return List<RsltAmdtHisMnVO>
	 * @exception EventException
	 */
	public List<RsltAmdtHisMnVO> searchAmendmentHistoryList(CstShHistVO cstShHistVO) throws EventException {
		try {
			return dbDao.searchAmendmentHistoryList(cstShHistVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	} 	
	
	
	
	
	/**
	 * retrieving Amended Terms
	 * @param PriRpMnVO priRpMnVO
	 * @return List<PriSpScpGrpLocDtlVO>
	 * @exception EventException
	 */	
	public List<RsltPropScpAmdtSmryVO> searchHistoryAmendTermList(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchHistoryAmendTermList(priRpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}
	
	/**
     * retrieving modified data in Terms <br>
	 * 
	 * @param CstShHistVO cstShHistVO
	 * @return List<RsltPropScpAmdtSmryVO> 
	 * @exception EventException
	 */
	public List<RsltPropScpAmdtSmryVO> searchAmendmentHistorySummary(CstShHistVO cstShHistVO) throws EventException {
		try {
			return dbDao.searchAmendmentHistorySummary(cstShHistVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}  		
	
	/**
	 * retrieving all scope by Proposal No.
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */	
	public List<RsltCdListVO> searchHistoryScopeList(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchHistoryScopeList(priRpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	} 		
	
    /**
     * retrieving RFA Proposal Affiliate's Copy<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @return List<RsltRfaPropCopyVO>
     * @exception EventException
     */
    public List<RsltRfaPropCopyVO> searchProposalCopyAfilList (RsltRfaPropCopyVO rsltRfaPropCopyVO) throws EventException {
        try {
            return dbDao.searchProposalCopyAfilList (rsltRfaPropCopyVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * retrieving RFA Proposal Main / Scope's Copy <br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @return List<RsltRfaPropCopyVO>
     * @exception EventException
     */
    public List<RsltRfaPropCopyVO> searchProposalCopyList (RsltRfaPropCopyVO rsltRfaPropCopyVO) throws EventException {
        try {
            return dbDao.searchProposalCopyList (rsltRfaPropCopyVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * when RFA Proposal Copy, retrieving new Proposal Number<br>
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String searchMaxPropNo (SignOnUserAccount account) throws EventException {
        try {
            return dbDao.searchCreationProposalNo(account.getOfc_cd());
        } catch (DAOException ex) {

            throw new EventException(new ErrorHandler("PRI00201", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
       
            throw new EventException(new ErrorHandler("PRI00201", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * RFA Proposal Main Copy <br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalMain(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException{
        try {
            rsltRfaPropCopyVO.setCreUsrId(account.getUsr_id());
            rsltRfaPropCopyVO.setUpdUsrId(account.getUsr_id());
            rsltRfaPropCopyVO.setOfcCd(account.getOfc_cd());
            rsltRfaPropCopyVO.setSrepCd(account.getSrep_cd());

            // PRI_RP_HDR COPY
            dbDao.addCopyProposalHdr(rsltRfaPropCopyVO);

            // PRI_RP_MN COPY
            dbDao.addCopyProposalMain(rsltRfaPropCopyVO);

            // PRI_RP_AMDT_SMRY
            PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
            priRpAmdtSmryVO.setPropNo(rsltRfaPropCopyVO.getNewPropNo());
            priRpAmdtSmryVO.setAmdtSeq("0");
            priRpAmdtSmryVO.setCreUsrId(account.getUsr_id());
            priRpAmdtSmryVO.setUpdUsrId(account.getUsr_id());
            dbDao.addProposalAmendmentSummary(priRpAmdtSmryVO);

            // PRI_RP_PROG
            dbDao.addCopyProposalProg(rsltRfaPropCopyVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201", new String[]{}).getMessage(), ex);
        }
    }

    /**
     *  RFA Proposal Main Amendment Summary modifying<br>
     * 
     * @param PriRpAmdtSmryVO priRpAmdtSmryVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public void manageProposalAmendmentSummaryAll(PriRpAmdtSmryVO priRpAmdtSmryVO, SignOnUserAccount account) throws EventException{
        try {
            priRpAmdtSmryVO.setUpdUsrId(account.getUsr_id());
            CodeUtil cdUtil = CodeUtil.getInstance();
            ArrayList<CodeInfo> cdList =(ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01739",0);
            
            for (int j = 0, m = cdList.size(); j < m; j++) {
                priRpAmdtSmryVO.setPropTermTpCd(cdList.get(j).getCode());
                dbDao.modifyProposalAmendmentSummary(priRpAmdtSmryVO);
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
     * RFA Proposal Scope Copy <br>
     * 
     * @param RsltRfaPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeMain(RsltRfaPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_RP_SCP_MN COPY
            dbDao.addCopyProposalScopeMain(vo);
            
            List<PriRpScpProgVO> progList = new ArrayList<PriRpScpProgVO>();
            PriRpScpProgVO scpVo = new PriRpScpProgVO();
            scpVo.setPropNo(vo.getNewPropNo());
            scpVo.setAmdtSeq("0");
            scpVo.setSvcScpCd(vo.getSvcScpCd());
            scpVo.setPropScpStsCd("I");
            scpVo.setProgUsrId(account.getUsr_id());
            scpVo.setProgOfcCd(account.getOfc_cd());
            scpVo.setCreUsrId(account.getUsr_id());
            scpVo.setUpdUsrId(account.getUsr_id());
            progList.add(scpVo);
            
            // PRI_RP_SCP_PROG
            dbDao.addProposalScopeProgress(progList);
            
            List<PriRpScpAmdtSmryVO> smryList = new ArrayList<PriRpScpAmdtSmryVO>();
            PriRpScpAmdtSmryVO smVo = new PriRpScpAmdtSmryVO();
            smVo.setPropNo(vo.getNewPropNo());
            smVo.setAmdtSeq("0");
            smVo.setSvcScpCd(vo.getSvcScpCd());
            smVo.setCreUsrId(account.getUsr_id());
            smVo.setUpdUsrId(account.getUsr_id());
            smryList.add(smVo);
            
            // PRI_RP_SCP_AMDT_SMRY INSERT
            dbDao.addProposalScopeAmendmentSummary(smryList);
            
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * RFA Proposal Scope Amendment Summary modifying<br>
     * 
     * @param RsltRfaPropCopyVO[] vos
     * @param SignOnUserAccount account
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public void copyProposalScopeAmdtSmry(RsltRfaPropCopyVO[] vos, SignOnUserAccount account) throws EventException{
        try {
            PriRpScpAmdtSmryVO smVo = new PriRpScpAmdtSmryVO();
            
            CodeUtil cdUtil = CodeUtil.getInstance();
            ArrayList<CodeInfo> cdList =(ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01740",0);
            
            for (int i = 0, n = vos.length; i < n; i++) {
                for (int j = 0, m = cdList.size(); j < m; j++) {
                    smVo = new PriRpScpAmdtSmryVO();
                    smVo.setPropNo(vos[i].getNewPropNo());
                    smVo.setAmdtSeq("0");
                    smVo.setSvcScpCd(vos[i].getSvcScpCd());
                    smVo.setPropScpTermTpCd(cdList.get(j).getCode());
                    smVo.setUpdUsrId(account.getUsr_id());
                    dbDao.modifyProposalScopeAmendmentSummary(smVo);
                }
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
     * Proposal Request saving <br>
     * 
     * @param PriRpAproRqstRefUsrVO[] priRpAproRqstRefUsrVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageProposalRequestMessage(PriRpAproRqstRefUsrVO[] priRpAproRqstRefUsrVOs, SignOnUserAccount account) throws EventException{
        try {
            PriRpAproRqstRefVO priRpAproRqstRefVO = new PriRpAproRqstRefVO();
            if (priRpAproRqstRefUsrVOs != null && priRpAproRqstRefUsrVOs[0] != null) {
                priRpAproRqstRefVO.setPropNo(priRpAproRqstRefUsrVOs[0].getPropNo());
                priRpAproRqstRefVO.setAmdtSeq(priRpAproRqstRefUsrVOs[0].getAmdtSeq());
            }
            
            String newSeq = dbDao.searchProposalRequestNewSeq(priRpAproRqstRefVO);
            priRpAproRqstRefVO.setAproRqstSeq(newSeq);
            priRpAproRqstRefVO.setAproRqstUsrOfcCd(account.getOfc_cd());
            priRpAproRqstRefVO.setAproRqstUsrId(account.getUsr_id());
            priRpAproRqstRefVO.setPrcAproRqstStsCd("R");
            priRpAproRqstRefVO.setCreUsrId(account.getUsr_id());
            priRpAproRqstRefVO.setUpdUsrId(account.getUsr_id());

            dbDao.addProposalRequestRef(priRpAproRqstRefVO);
            
            for ( int i = 0; i < priRpAproRqstRefUsrVOs.length ; i++ ) {
                if (priRpAproRqstRefUsrVOs[i].getIbflag().equals("I")){
                    priRpAproRqstRefUsrVOs[i].setCreUsrId(account.getUsr_id());
                    priRpAproRqstRefUsrVOs[i].setUpdUsrId(account.getUsr_id());
                    priRpAproRqstRefUsrVOs[i].setAproRqstSeq(newSeq);
                    
                    dbDao.addProposalRequestRefUser(priRpAproRqstRefUsrVOs[i]);
                }
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
     * Proposal Request state modifying<br>
     * 
     * @param PriRpAproRqstRefVO priRpAproRqstRefVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyProposalRequestStatus(PriRpAproRqstRefVO priRpAproRqstRefVO, SignOnUserAccount account) throws EventException{
        try {
            priRpAproRqstRefVO.setUpdUsrId(account.getUsr_id());
            dbDao.modifyProposalRequestStatus(priRpAproRqstRefVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
    }

    /**
     * retrieving Proposal Request for RFA approve<br>
     * 
     * @param RsltRfaAproRqstRefVO rsltRfaAproRqstRefVO
     * @return List<RsltRfaAproRqstRefVO>
     * @exception EventException
     */
    public List<RsltRfaAproRqstRefVO> searchProposalRequestList (RsltRfaAproRqstRefVO rsltRfaAproRqstRefVO) throws EventException {
        try {
            if (JSPUtil.getNull(rsltRfaAproRqstRefVO.getTransTpCd()).equals("S")) {
                return dbDao.searchProposalSentRequestList(rsltRfaAproRqstRefVO);
            } else {
                return dbDao.searchProposalReceivedRequestList(rsltRfaAproRqstRefVO);
            }
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }
    
	/**
	 * Proposal & Amendment Search List retrieving<br>
	 * 
	 * @param CstShRInqVO cstShRInqVO
	 * @return List<RsltPriRpInqVO>
	 * @exception EventException
	 */
	public List<RsltPriRpInqVO> searchProposalMainInquiryList(CstShRInqVO cstShRInqVO) throws EventException {
		try {
			return dbDao.searchProposalMainInquiryList (cstShRInqVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

	/**
	 * Proposal & Amendment retrieving<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @return RsltPropInqListVO
	 * @exception EventException
	 */
	public RsltPropInqListVO searchProposalMainInquiry(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException {
		try {
			RsltPropInqListVO vo = new RsltPropInqListVO();
			vo.setRsltPropMnInqVOs(dbDao.searchProposalMainInquiry(priRpMnVO));
			vo.setRsltPropMnScpInqListVOs(dbDao.searchProposalMainScpInquiryList(priRpMnVO));	

			return vo;
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

	/**
	 *  retrieving Customer <br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltPropCustInfoVO>
	 * @exception EventException
	 */
	public List<RsltPropCustInfoVO> searchProposalCustomerInfoInquiry(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException {
		try {
			return dbDao.searchProposalCustomerInfoInquiry(priSpCtrtPtyVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

    /**
     * retrieving Terms data<br>
     *
     * @param PriRpScpAmdtSmryVO priRpScpAmdtSmryVO
     * @return List<RsltPropScpAmdtSmryVO>
     * @exception EventException
     */
	public List<RsltPropScpAmdtSmryVO> searchProposalScopeAmendmentSummaryInquiry(PriRpScpAmdtSmryVO priRpScpAmdtSmryVO) throws EventException {
		try {
			return dbDao.searchProposalScopeAmendmentSummaryInquiry(priRpScpAmdtSmryVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}    

	/**
	 * when Approval Cancel, retrieving RFA NO. using on BKG<br>
	 * @param CstApprovalVO cstApprovalVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchApprovalCancelCheck(CstApprovalVO cstApprovalVO) throws EventException {
		try {
			return dbDao.searchApprovalCancelCheck(cstApprovalVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	}

    /**
     * retrieving Guideline Copy target<br>
     * 
     * @param RpScpGlineCopyVO rpScpGlineCopyVO
     * @return List<RpScpGlineCopyVO>
     * @exception EventException
     */
    public List<RpScpGlineCopyVO> searchGuidelineCopyCheck(RpScpGlineCopyVO rpScpGlineCopyVO) throws EventException {
        try {
            return dbDao.searchGuidelineCopyCheck(rpScpGlineCopyVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }

    /**
     * getting Guideline's gline_seq to Copy <br>
     * 
     * @param RpScpGlineCopyVO rpScpGlineCopyVO
     * @return String
     * @exception EventException
     */
    public String searchCopyGlineSeq(RpScpGlineCopyVO rpScpGlineCopyVO) throws EventException {
        try {
            return dbDao.searchCopyGlineSeq(rpScpGlineCopyVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
    }
    
    /**
     * updating Proposal Scope Amendment Summary <br>
     * 
     * @param RpScpGlineCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    public void copyScopeGuidelineScopeAmdtSmry(RpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            PriRpScpAmdtSmryVO smVo = new PriRpScpAmdtSmryVO();
            
            CodeUtil cdUtil = CodeUtil.getInstance();
            ArrayList<CodeInfo> cdList =(ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01740",0);
            
            for (int i = 0, m = cdList.size(); i < m; i++) {
                smVo = new PriRpScpAmdtSmryVO();
                smVo.setPropNo(vo.getPropNo());
                smVo.setAmdtSeq(vo.getAmdtSeq());
                smVo.setSvcScpCd(vo.getSvcScpCd());
                smVo.setPropScpTermTpCd(cdList.get(i).getCode());
                smVo.setUpdUsrId(account.getUsr_id());
                dbDao.modifyProposalScopeAmendmentSummary(smVo);
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
     * creating RFA Proposal Main based on copied PRS<br>
     * 
     * @param RsltCopyToProposalVO vo 
     * @param SignOnUserAccount account
     * @throws DAOException
     */
    /*public void copyToProposalBase(RsltCopyToProposalVO vo, SignOnUserAccount account) throws EventException{
       try {
    	    vo.setCreUsrId(account.getUsr_id());
    	    vo.setUpdUsrId(account.getUsr_id());
			//office
    	    vo.setQttnOfcCd(account.getOfc_cd());
    	    
    	    int chk = 0;
			
			//PRI_RP_HDR
    	    chk  = dbDao.addCopyRfaQuotationPriRpHdr(vo);
    	    if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
    	    
			//PRI_RP_MN
    	    chk  = dbDao.addCopyRfaQuotationPriRpMn(vo);
    	    if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
    	    
			//PRI_RP_Amdt_Smry
    	    chk  = dbDao.addCopyRfaQuotationPriRpAmdtSmry(vo);
    	    if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
    	    
			//PRI_RP_Prog
    	    chk  = dbDao.addCopyRfaQuotationPriRpProg(vo);
    	    if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
			
			//PRI_SP_RP_MN
    	    chk  = dbDao.addCopyRfaQuotationPriRpScpMn(vo);
    	    if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
    	    
			//PRI_SP_RP_Prog
    	    chk  = dbDao.addCopyRfaQuotationPriRpScpProg(vo);
    	    if (chk < 1) {
				throw new EventException(new ErrorHandler("PRI03016").getMessage());
			}
    	    
			//PRI_SP_RP_Amdt_Smry
    	    chk  = dbDao.addCopyRfaQuotationPriRpScpAmdtSmry(vo);
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

    
    /**
     * retrieving PRS CM Data <br>
     *
     * @param PriRpMnVO priRpMnVO
     * @return List<RsltRfaPRSCMDataVO>
     * @exception EventException
     */
	/*public List<RsltRfaPRSCMDataVO> searchProposalMainPRSCMData(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchProposalMainPRSCMData (priRpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	*/  
	
	
	/**
     * retrieving Main's state<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltRfaMainStsVO>
	 * @exception EventException
	 */
	public List<RsltRfaMainStsVO> searchProposalMainStatus(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchProposalMainStatus(priRpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	} 	
	
	
	/**
	 * deleting RFA Main <br>
	 * 
	 * @param RfaPropMnVO rfaPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRemove(RfaPropMnVO rfaPropMnVO, SignOnUserAccount account) throws EventException{

		try {			
			PriRpScpMnVO[] scpVo = rfaPropMnVO.getPriRpScpMnVOs();
			List<PriRpScpMnVO> deleteScpVoList = new ArrayList<PriRpScpMnVO>();

			for ( int i = 0; scpVo != null && i < scpVo.length; i++ ) {
				if ( scpVo[i].getIbflag().equals("D")){
					deleteScpVoList.add(scpVo[i]);
				}
			}

			if ( deleteScpVoList.size() > 0 ) {				
				dbDao.removeProposalScopeAmdtSmry(deleteScpVoList);
				dbDao.removeProposalScopeProgress(deleteScpVoList);
				dbDao.removeProposalScopeMain(deleteScpVoList);
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
	 * retrieving Scope by Proposal No.,Amend Seq 
	 * @param PriRpMnVO priRpMnVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */	
	public List<RsltCdListVO> searchScopeList(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchScopeList(priRpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        }
	} 	
	
	/**
	 * when C/Offer/Request Cancel, modifying Rate  CALCULATE  Flag <br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRateCalcFlag(PriRpScpMnVO priRpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priRpScpMnVO != null) {
				priRpScpMnVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyPrsCalcFlgOnChangeStatus(priRpScpMnVO);
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
     * when Reqeust Cancel, checking existence of Accept, Returned data<br>
     * @param PriRpMnVO priRpMnVO
     * @return List<CstRequestCheckVO>
     * @exception EventException
     */
	public List<CstRequestCheckVO> searchProposalRequestCancelCheck(PriRpMnVO priRpMnVO) throws EventException {
		try {
			return dbDao.searchProposalRequestCancelCheck(priRpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}  
	
	/**
     * check the RFA No. to exists<br>
     * @param PriRpHdrVO priRpHdrVo
     * @return String : Y/N
     * @exception EventException
     * @LastModifyDate : 2014.11.04
     */
    public String checkRFAno(PriRpHdrVO priRpHdrVo) throws EventException {
    	try {
			return dbDao.checkRFAno(priRpHdrVo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
    }   
	
}