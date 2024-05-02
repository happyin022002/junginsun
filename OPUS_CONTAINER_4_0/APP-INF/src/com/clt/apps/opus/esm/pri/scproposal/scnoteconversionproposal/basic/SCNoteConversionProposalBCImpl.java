/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCNoteConversionProposalBCImpl.java
*@FileTitle : Special Note Conversion
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.vo.RsltPriSgStndNoteHdrCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.integration.SCNoteConversionProposalDBDAO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.vo.PriScNoteConvListVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteconversionproposal.vo.RsltNoteConvVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.NotePropVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteCtntListVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.PriSpScpNoteListVO;
import com.clt.apps.opus.esm.pri.scproposal.scnoteproposal.vo.RsltNoteCtntListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtCnoteListVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.ScRtPropCmdtVO;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.ScRtPropRtVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriScNoteConvVO;
import com.clt.syscommon.common.table.PriSgStndNoteCtntVO;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;
import com.clt.syscommon.common.table.PriSpScpNoteCtntVO;
import com.clt.syscommon.common.table.PriSpScpRtCmdtHdrVO;
import com.clt.syscommon.common.table.PriSpScpRtCmdtRnoteVO;
import com.clt.syscommon.common.table.PriSpScpRtCmdtRoutVO;
import com.clt.syscommon.common.table.PriSpScpRtCnoteVO;

/**
 * SCProposal Business Logic Basic Command implementation<br>
 * - handling biz logic about SCProposal<br>
 *
 * @author 
 * @see ESM_PRI_0032EventResponse,SCNoteConversionProposalBC reference each DAO class 
 * @since J2EE 1.6
 */
public class SCNoteConversionProposalBCImpl extends BasicCommandSupport implements SCNoteConversionProposalBC {

	// Database Access Object
	private transient SCNoteConversionProposalDBDAO dbDao = null;

	/**
	 * SCNoteConversionProposalBCImpl object creation<br>
	 * creating SCNoteConversionProposalDBDAO<br>
	 */
	public SCNoteConversionProposalBCImpl() {
		dbDao = new SCNoteConversionProposalDBDAO();
	}


	/**
	 * Retrieving [Special Note DETAIL]<br>
	 * 
	 * @param PriSpScpNoteCtntVO priSpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchNoteContentList(PriSpScpNoteCtntVO priSpScpNoteCtntVO) throws EventException {
		try {
			return dbDao.searchNoteContentList(priSpScpNoteCtntVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving [Commodity Note DETAIL]<br>
	 * 
	 * @param PriSpScpRtCnoteVO priSpScpRtCnoteVO
	 * @return List<RsltRtCnoteListVO>
	 * @exception EventException
	 */
	public List<RsltRtCnoteListVO> searchCommodityNoteContentList(PriSpScpRtCnoteVO priSpScpRtCnoteVO) throws EventException {
		try {
			return dbDao.searchCommodityNoteContentList(priSpScpRtCnoteVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving [Commodity Note DETAIL]<br>
	 * 
	 * @param PriSpScpRtCnoteVO priSpScpRtCnoteVO
	 * @return List<RsltRtCnoteListVO>
	 * @exception EventException
	 */
	public List<RsltRtCnoteListVO> searchCommodityNoteContentInquiryList(PriSpScpRtCnoteVO priSpScpRtCnoteVO) throws EventException {
		try {
			return dbDao.searchCommodityNoteContentInquiryList(priSpScpRtCnoteVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving [Special Note Conversion]<br>
	 * 
	 * @param PriScNoteConvVO priScNoteConvVO
	 * @return List<RsltNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltNoteConvVO> searchNoteConversionList(PriScNoteConvVO priScNoteConvVO) throws EventException {
		try {
			return dbDao.searchNoteConversionList(priScNoteConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving [copied Special Note Conversion]<br>
	 * 
	 * @param PriScNoteConvVO priScNoteConvVO
	 * @param SignOnUserAccount account
	 * @return List<RsltNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltNoteConvVO> searchNoteConversionListCopy(PriScNoteConvVO priScNoteConvVO , SignOnUserAccount account) throws EventException {
		try {

			priScNoteConvVO.setCreUsrId(account.getUsr_id());
			
			return dbDao.searchNoteConversionListCopy(priScNoteConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
		
	/**
	 * Handling [Special Note Conversion] CUD transaction<br>
	 * 
	 * @param PriScNoteConvListVO[] priScNoteConvListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversion(PriScNoteConvListVO[] priScNoteConvListVOs, SignOnUserAccount account) throws EventException{
		try {			
			List<PriScNoteConvListVO> insertVoList = new ArrayList<PriScNoteConvListVO>();
			List<PriScNoteConvListVO> updateVoList = new ArrayList<PriScNoteConvListVO>();
			List<PriScNoteConvListVO> deleteVoList = new ArrayList<PriScNoteConvListVO>();
			
			for ( int i=0; i<priScNoteConvListVOs .length; i++ ) {
				if ( priScNoteConvListVOs[i].getIbflag().equals("I")){
					priScNoteConvListVOs[i].setCreUsrId(account.getUsr_id());
					priScNoteConvListVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priScNoteConvListVOs[i]);
				} else if ( priScNoteConvListVOs[i].getIbflag().equals("U")){
					priScNoteConvListVOs[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(priScNoteConvListVOs[i]);
				} else if ( priScNoteConvListVOs[i].getIbflag().equals("D")){
					deleteVoList.add(priScNoteConvListVOs[i]);
				}
			}
						
			if ( insertVoList.size() > 0 ) {
				dbDao.addNoteConversion(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyNoteConversion(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeNoteConversion(deleteVoList);
			}
			/*
			if ( priScNoteConvCommVO != null ) {
				dbDao.modifyNoteChargeTypeCode(priScNoteConvCommVO, priScNoteConvVO[0].getNoteConvTpCd()); //Proposal Special Note
			}
			*/		
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	

	/**
	 * Copying [Special Note Conversion]<br>
	 * 
	 * @param PriScNoteConvListVO[] priScNoteConvListVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCopy(PriScNoteConvListVO[] priScNoteConvListVO, SignOnUserAccount account) throws EventException{
		try {			
			List<PriScNoteConvListVO> insertVoList = new ArrayList<PriScNoteConvListVO>();
			
			for ( int i=0; i<priScNoteConvListVO .length; i++ ) {
				if ( priScNoteConvListVO[i].getIbflag().equals("I")){
					priScNoteConvListVO[i].setCreUsrId(account.getUsr_id());
					priScNoteConvListVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priScNoteConvListVO[i]);
				}
			}			
			if ( insertVoList.size() > 0 ) {
				dbDao.removeNoteConversionCopy(priScNoteConvListVO[0]);				
				dbDao.addNoteConversionCopy(insertVoList);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
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
		
			dbDao.addProposalNoteConversionAmend (insertVoList);
				
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	
	
	/**
	 * Changing Conversion's Expire Date when Changing Main Duration Expire Date<br>
	 * 
	 * @param PriSpScpMnVO[] priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionExpireDate(PriSpScpMnVO[] priSpScpMnVO,SignOnUserAccount account)throws EventException{
		try {		
			if ( priSpScpMnVO != null ) {
				List<PriSpScpMnVO> updateVoList = new ArrayList<PriSpScpMnVO>();
				for ( int i=0; i<priSpScpMnVO .length; i++ ) {
					if ("U".equals(priSpScpMnVO[i].getIbflag())){
						priSpScpMnVO[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(priSpScpMnVO[i]);
						log.debug("manageNoteConversionExpireDate============"+priSpScpMnVO[i].getIbflag());						
					}
				}
				if ( updateVoList.size() > 0 ) {
					dbDao.modifyNoteConversionExpDate(updateVoList); //Proposal Special Note
				}				
			}			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Changing Conversion's Effective Date when Changing Duration Effective Date <br>
	 * 
	 * @param PriSpScpMnVO[] priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionEffectiveDate(PriSpScpMnVO[] priSpScpMnVO,SignOnUserAccount account)throws EventException{
		try {		
			if ( priSpScpMnVO != null ) {
				List<PriSpScpMnVO> updateVoList = new ArrayList<PriSpScpMnVO>();
				for ( int i=0; i<priSpScpMnVO .length; i++ ) {
					if ("U".equals(priSpScpMnVO[i].getIbflag())){
						priSpScpMnVO[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(priSpScpMnVO[i]);							
					}
				}
				if ( updateVoList.size() > 0 ) {
					dbDao.modifyNoteConversionEffDate(updateVoList); //Proposal Special Note
				}
				
			}			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
	
	
    /**
     * Copying S/C Proposal Special Note Conversion<br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScNoteConversion(RsltPropCopyVO rsltPropCopyVO, SignOnUserAccount account) throws EventException{
        try {
        	rsltPropCopyVO.setCreUsrId(account.getUsr_id());
        	rsltPropCopyVO.setUpdUsrId(account.getUsr_id());
        	rsltPropCopyVO.setOfcCd(account.getOfc_cd());
            // PRI_SC_NOTE_CONV COPY
            dbDao.addCopyProposalScNoteConversion(rsltPropCopyVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Copying S/C Proposal Rate Route Note Conversion <br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalRoutNoteConversion(RsltPropCopyVO rsltPropCopyVO, SignOnUserAccount account) throws EventException{
        try {
        	rsltPropCopyVO.setCreUsrId(account.getUsr_id());
        	rsltPropCopyVO.setUpdUsrId(account.getUsr_id());
        	rsltPropCopyVO.setOfcCd(account.getOfc_cd());
            // PRI_SC_NOTE_CONV COPY
            dbDao.addCopyProposalRoutNoteConversion(rsltPropCopyVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Copying S/C Proposal Rate Commodity Note Conversion <br>
     * 
     * @param RsltPropCopyVO rsltPropCopyVO
     * @param SignOnUserAccount account
     * @throws DAOException
     */
    public void copyProposalCmdtNoteConversion(RsltPropCopyVO rsltPropCopyVO, SignOnUserAccount account) throws EventException{
        try {
        	rsltPropCopyVO.setCreUsrId(account.getUsr_id());
        	rsltPropCopyVO.setUpdUsrId(account.getUsr_id());
        	rsltPropCopyVO.setOfcCd(account.getOfc_cd());
            // PRI_SC_NOTE_CONV COPY
            dbDao.addCopyProposalCmdtNoteConversion(rsltPropCopyVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    
    /**
	 * Deleting all CONVERSION data selected SCOPE <br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalConversion(priSpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Saving S/C Standard Note Conversion <br>
	 * 
	 * @param NotePropVO notePropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNote(NotePropVO notePropVO, SignOnUserAccount account) throws EventException{
		try {
			PriSpScpNoteListVO priSpScpNoteListVO = notePropVO.getPriSpScpNoteListVO();
			PriSpScpNoteListVO[] vo = notePropVO.getPriSpScpNoteListVOs();
			PriSpScpNoteCtntListVO[] dtlvo = notePropVO.getPriSpScpNoteCtntListVOs();
			String masterDelChk = notePropVO.getMasterDelChk();
			
			List<PriSpScpNoteListVO> insertVoList = new ArrayList<PriSpScpNoteListVO>();
			List<PriSpScpNoteListVO> updateVoList = new ArrayList<PriSpScpNoteListVO>();
			List<PriSpScpNoteListVO> deleteVoList = new ArrayList<PriSpScpNoteListVO>();
			List<PriSpScpNoteCtntListVO> insertDtlVoList = new ArrayList<PriSpScpNoteCtntListVO>();
			List<PriSpScpNoteCtntListVO> updateDtlVoList = new ArrayList<PriSpScpNoteCtntListVO>();
			List<PriSpScpNoteCtntListVO> deleteDtlVoList = new ArrayList<PriSpScpNoteCtntListVO>();			
			
			for ( int i = 0; vo != null && i < vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("I")){
					vo[i].setCreUsrId(account.getUsr_id());
					vo[i].setUpdUsrId(account.getUsr_id());					
					insertVoList.add(vo[i]);
				} else if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());
					
					vo[i].setEffDt(priSpScpNoteListVO.getEffDt());
					vo[i].setExpDt(priSpScpNoteListVO.getExpDt());
					
					updateVoList.add(vo[i]);
				} else if ( vo[i].getIbflag().equals("D")){
					deleteVoList.add(vo[i]);
				}
			}
			
			for ( int i = 0; dtlvo != null && i < dtlvo.length; i++ ) {
				if ( dtlvo[i].getIbflag().equals("I")){
					dtlvo[i].setCreUsrId(account.getUsr_id());
					dtlvo[i].setUpdUsrId(account.getUsr_id());					
					insertDtlVoList.add(dtlvo[i]);
				} else if ( dtlvo[i].getIbflag().equals("U")){
					dtlvo[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(dtlvo[i]);
				} else if ( dtlvo[i].getIbflag().equals("D")){
					deleteDtlVoList.add(dtlvo[i]);
				}
			}	
									
			if ( updateVoList.size() > 0 ) {
				if("Y".equals(masterDelChk)) {
					// Deleting all CONVERSION   
					dbDao.removeNoteMasterAmend(updateVoList);
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeNote(deleteVoList);
			}
			
			if ( updateDtlVoList.size() > 0 && !"Y".equals(masterDelChk)) {
				//CONVERSION 
				PriSpScpNoteCtntListVO priSpScpNoteCtntListVO = new PriSpScpNoteCtntListVO();				
								
				for(int i = 0; i<updateDtlVoList.size(); i++) {
					priSpScpNoteCtntListVO = updateDtlVoList.get(i);
					
					////////////
					// 11-COMMAND01 : AMEND
					// 12-COMMAND02 : AMEND CANCEL
					//  8-IBDELETE : AMEND DELETE
					
					if("11".equals(priSpScpNoteCtntListVO.getActionMode())) {				            
			            //1. delete data in case of date is not in
						dbDao.removeNoteContentAmend(priSpScpNoteCtntListVO);
			            
			            //2. change date
						dbDao.modifyNoteContentAmend(priSpScpNoteCtntListVO);			            
						
					} else if("12".equals(priSpScpNoteCtntListVO.getActionMode())) {							
						//1. delete existing data
						dbDao.removeNoteContentAmend(priSpScpNoteCtntListVO);
						
						//2. roll back
						dbDao.addNoteContentAmend(priSpScpNoteCtntListVO);
						
					} else if("8".equals(priSpScpNoteCtntListVO.getActionMode())) {

						priSpScpNoteCtntListVO.setActionMode("XX");
						dbDao.removeNoteContentAmend(priSpScpNoteCtntListVO);
						
						//1. delete data in case of date is not in
						//dbDao.removeNoteContentAmend(priSpScpNoteCtntListVO);
			            
			            //2. change date
						//dbDao.modifyNoteContentAmend(priSpScpNoteCtntListVO);
					} 
				}				
			}
			
			if ( deleteDtlVoList.size() > 0 && !"Y".equals(masterDelChk)) {
				dbDao.removeNoteContent(deleteDtlVoList);
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
     * Creating Conversion data when S/C Standard Note Copy <br>
     * 
     * @param RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScStndNoteConversion(RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO, SignOnUserAccount account) throws EventException{
        try {
        	rsltPriSgStndNoteHdrCopyVO.setCreUsrId(account.getUsr_id());
        	rsltPriSgStndNoteHdrCopyVO.setUpdUsrId(account.getUsr_id());
        	
            // PRI_SC_NOTE_CONV COPY
            dbDao.addCopyScStndNoteConversion(rsltPriSgStndNoteHdrCopyVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    
    
    /**
     * Deleting CONVERSION when deleting CTNT of STANDARD NOTEbr>
     * 
     * @param PriSgStndNoteCtntVO priSgStndNoteCtntVO
     * @exception EventException
     */
    public void removeScStndNoteConversion(PriSgStndNoteCtntVO priSgStndNoteCtntVO) throws EventException{
        try {
        	 // PRI_SC_NOTE_CONV remove
            dbDao.removeScStndNoteConversion(priSgStndNoteCtntVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    
    /**
     * Modifying Conversion's DURATION when updating S/C Standard Note DURATION  <br>
     * 
     * @param RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyDurationScStndNoteConversion(RsltPriSgStndNoteHdrCopyVO rsltPriSgStndNoteHdrCopyVO, SignOnUserAccount account) throws EventException{
        try {
        	rsltPriSgStndNoteHdrCopyVO.setUpdUsrId(account.getUsr_id());
        	
            // PRI_SC_NOTE_CONV duration update
            dbDao.modifyDurationScStndNoteConversion(rsltPriSgStndNoteHdrCopyVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    
	/**
	 * Changing Conversion's Effective Date when filing <br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionEffectiveDateFiling(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException{
		try {
			priSpMnVO.setUpdUsrId(account.getUsr_id());
			dbDao.modifyNoteConversionEffDateFiling(priSpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}    
    
	
	/**
	 * Handling Commodity Group CUD transaction<br>
	 * 
	 * @param ScRtPropCmdtVO scRtPropCmdtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRateCommodity(ScRtPropCmdtVO scRtPropCmdtVO, SignOnUserAccount account) throws EventException {
		try {
			PriSpScpRtCmdtHdrVO[] vo = scRtPropCmdtVO.getPriSpScpRtCmdtHdrVOS();
			PriSpScpRtCnoteVO[] cnotevo = scRtPropCmdtVO.getPriSpScpRtCnoteVOS();

			List<PriSpScpRtCmdtHdrVO> deleteVoList = new ArrayList<PriSpScpRtCmdtHdrVO>();
			List<PriSpScpRtCnoteVO> deleteCnoteVoList = new ArrayList<PriSpScpRtCnoteVO>();
			List<PriSpScpRtCnoteVO> amendCnoteVoList = new ArrayList<PriSpScpRtCnoteVO>();
			List<PriSpScpRtCnoteVO> amendCancelCnoteVoList = new ArrayList<PriSpScpRtCnoteVO>();
			
			for (int i = 0; vo != null && i < vo.length; i++) {
				if (vo[i].getIbflag().equals("U")) {
					// pass when AMDT_SEQ = 0 
					// this part makes unstable deleting conversion on prop step so moving here  2010-05-13 17:12 
					if ("0".equals(vo[i].getAmdtSeq())) {
						continue;
					}
					vo[i].setUpdUsrId(account.getUsr_id());
					if ("-1".equals(vo[i].getN1stCmncAmdtSeq())) {
						deleteVoList.add(vo[i]);
					}
				} else if (vo[i].getIbflag().equals("D")) {
					vo[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(vo[i]);
				}
			}
			for (int i = 0; cnotevo != null && i < cnotevo.length; i++) {
				if (cnotevo[i].getIbflag().equals("U")) {
					// pass when AMDT_SEQ = 0 
					// this part makes unstable deleting conversion on prop step so moving here  2010-05-13 17:12 
					if ("0".equals(cnotevo[i].getAmdtSeq())) {
						continue;
					}
					cnotevo[i].setCreUsrId(account.getUsr_id());
					cnotevo[i].setUpdUsrId(account.getUsr_id());
					if (("AM".equals(cnotevo[i].getSrcInfoCd())
							|| "AD".equals(cnotevo[i].getSrcInfoCd())) && cnotevo[i].getAmdtSeq().equals(cnotevo[i].getN1stCmncAmdtSeq())) {
						amendCnoteVoList.add(cnotevo[i]);
					} else if (!cnotevo[i].getAmdtSeq().equals(cnotevo[i].getN1stCmncAmdtSeq())) {
						amendCancelCnoteVoList.add(cnotevo[i]);
					}
				} else if (cnotevo[i].getIbflag().equals("D")) {
					deleteCnoteVoList.add(cnotevo[i]);
				}
			}

			if (amendCnoteVoList.size() > 0) {
				dbDao.modifyNoteConversionDurationCascadeCNote(amendCnoteVoList);
			}
			if (amendCancelCnoteVoList.size() > 0) {
				dbDao.removeNoteConversionCascadeCNote(amendCancelCnoteVoList);
				dbDao.addCopyNoteConversionCascadeCNote(amendCancelCnoteVoList);
			}
			if (deleteCnoteVoList.size() > 0) {
				dbDao.removeNoteConversionCascadeCNote(deleteCnoteVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.modifyNoteConversionDurationCascadeCommodityCNote(deleteVoList);
				dbDao.modifyNoteConversionDurationCascadeCommodityRNote(deleteVoList);
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
	 * Handling [Route and Rate] CUD transaction<br>
	 * 
	 * @param ScRtPropRtVO scRtPropRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageRate(ScRtPropRtVO scRtPropRtVO, SignOnUserAccount account) throws EventException {
		try {
			PriSpScpRtCmdtRoutVO[] routvo = scRtPropRtVO.getPriSpScpRtCmdtRoutVOS();
			PriSpScpRtCmdtRnoteVO[] rnotevo = scRtPropRtVO.getPriSpScpRtCmdtRnoteVOS();

			List<PriSpScpRtCmdtRoutVO> deleteRoutList = new ArrayList<PriSpScpRtCmdtRoutVO>();
			List<PriSpScpRtCmdtRnoteVO> deleteRnoteList = new ArrayList<PriSpScpRtCmdtRnoteVO>();
			List<PriSpScpRtCmdtRnoteVO> amendRnoteList = new ArrayList<PriSpScpRtCmdtRnoteVO>();
			List<PriSpScpRtCmdtRnoteVO> amendCancelRnoteList = new ArrayList<PriSpScpRtCmdtRnoteVO>();

			for (int i = 0; routvo != null && i < routvo.length; i++) {
				if (routvo[i].getIbflag().equals("U")) {
					// pass when AMDT_SEQ = 0 
					// this part makes unstable deleting conversion on prop step so moving here  2010-05-13 17:12 
					if ("0".equals(routvo[i].getAmdtSeq())) {
						continue;
					}
					routvo[i].setUpdUsrId(account.getUsr_id());
					if ("-1".equals(routvo[i].getN1stCmncAmdtSeq())) {
						deleteRoutList.add(routvo[i]);
					}
				} else if (routvo[i].getIbflag().equals("D")) {
					routvo[i].setUpdUsrId(account.getUsr_id());
					deleteRoutList.add(routvo[i]);
				}
			}
			for (int i = 0; rnotevo != null && i < rnotevo.length; i++) {
				if (rnotevo[i].getIbflag().equals("U")) {
					// pass when AMDT_SEQ = 0 
					// this part makes unstable deleting conversion on prop step so moving here  2010-05-13 17:12 
					if ("0".equals(rnotevo[i].getAmdtSeq())) {
						continue;
					}
					rnotevo[i].setCreUsrId(account.getUsr_id());
					rnotevo[i].setUpdUsrId(account.getUsr_id());
					if (("AM".equals(rnotevo[i].getSrcInfoCd())
							|| "AD".equals(rnotevo[i].getSrcInfoCd())) && rnotevo[i].getAmdtSeq().equals(rnotevo[i].getN1stCmncAmdtSeq())) {
						amendRnoteList.add(rnotevo[i]);
					} else if (!rnotevo[i].getAmdtSeq().equals(rnotevo[i].getN1stCmncAmdtSeq())) {
						amendCancelRnoteList.add(rnotevo[i]);
					}
				} else if (rnotevo[i].getIbflag().equals("D")) {
					deleteRnoteList.add(rnotevo[i]);
				}
			}

			if (amendRnoteList.size() > 0) {
				dbDao.modifyNoteConversionDurationCascadeRNote(amendRnoteList);
			}
			if (amendCancelRnoteList.size() > 0) {
				dbDao.removeNoteConversionCascadeRNote(amendCancelRnoteList);
				dbDao.addCopyNoteConversionCascadeRNote(amendCancelRnoteList);
			}
			if (deleteRnoteList.size() > 0) {
				dbDao.removeNoteConversionCascadeRNote(deleteRnoteList);
			}
			if (deleteRoutList.size() > 0) {
				dbDao.modifyNoteConversionDurationCascadeRouteRNote(deleteRoutList);
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
	 * Retrieving header information for dividing transfer data <br>
	 * 
	 * @param PriScNoteConvVO priScNoteConvVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCreationTypeCode(PriScNoteConvVO priScNoteConvVO) throws EventException {
		try {
			return dbDao.searchCreationTypeCode(priScNoteConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving CONVERSION CONFIRM FLAG for inputting CONVERSION <br>
	 * 
	 * @param PriScNoteConvVO priScNoteConvVO
	 * @return String
	 * @exception EventException
	 */
	public String searchConversionConfirmFlag(PriScNoteConvVO priScNoteConvVO) throws EventException {
		try {
			return dbDao.searchConversionConfirmFlag(priScNoteConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

    /**
     * Adding Conversion based on previous Amend Seq.<br>
     *
     * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account 
     * @exception EventException
     */
    public void manageConversionUpdate (PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			priSpMnVO.setUpdUsrId(account.getUsr_id());

			//deleting conversion 
			dbDao.removeConversionUpdate(priSpMnVO);
			//special note
			dbDao.addConversionSpecialNote(priSpMnVO);
			dbDao.addConversionRateCnote(priSpMnVO);
			dbDao.addConversionRateCommodity(priSpMnVO);
			
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}   	
	
	/**
	 * Retrieving current AMDT_SEQ EXP_DT's DURATION for EXP_DT when inputting CONVERSION HISTORY <br>
	 * 
	 * @param PriScNoteConvVO priScNoteConvVO
	 * @return String
	 * @exception EventException
	 */
	public String searchDurationExpDate(PriScNoteConvVO priScNoteConvVO) throws EventException {
		try {
			return dbDao.searchDurationExpDate(priScNoteConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
}