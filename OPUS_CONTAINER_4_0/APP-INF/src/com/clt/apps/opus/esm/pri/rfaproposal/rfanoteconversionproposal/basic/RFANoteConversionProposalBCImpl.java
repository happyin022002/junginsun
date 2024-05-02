/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFANoteConversionProposalBCImpl.java
*@FileTitle : Special Note Conversion
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.integration.RFANoteConversionProposalDBDAO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.vo.PriRfaNoteConvListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.vo.RsltNoteConvVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.vo.NotePropVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.vo.PriRpScpNoteCtntListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.vo.PriRpScpNoteListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.vo.RsltNoteCtntListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RfaRtPropCmdtVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RfaRtPropRtVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRfaNoteConvVO;
import com.clt.syscommon.common.table.PriRpMnVO;
import com.clt.syscommon.common.table.PriRpScpMnVO;
import com.clt.syscommon.common.table.PriRpScpNoteCtntVO;
import com.clt.syscommon.common.table.PriRpScpRtCmdtHdrVO;
import com.clt.syscommon.common.table.PriRpScpRtCmdtRnoteVO;
import com.clt.syscommon.common.table.PriRpScpRtCmdtRoutVO;
import com.clt.syscommon.common.table.PriRpScpRtCnoteVO;

/**
 * SCProposal Business Logic Basic Command implementation<br>
 * - Handling a biz logic about SCProposal<br>
 *
 * @author
 * @see ESM_PRI_0032EventResponse,RFANoteConversionProposalBC - refer to each DAO class
 * @since J2EE 1.6
 */
public class RFANoteConversionProposalBCImpl extends BasicCommandSupport implements RFANoteConversionProposalBC {

	// Database Access Object
	private transient RFANoteConversionProposalDBDAO dbDao = null;

	/**
	 * Creating RFANoteConversionProposalBCImpl object<br>
	 * Creating RFANoteConversionProposalDBDAO.<br>
	 */
	public RFANoteConversionProposalBCImpl() {
		dbDao = new RFANoteConversionProposalDBDAO();
	}


	/**
	 * Retrieving [Special Note's DETAIL].<br>
	 * 
	 * @param PriRpScpNoteCtntVO priRpScpNoteCtntVO
	 * @return List<RsltNoteCtntListVO>
	 * @exception EventException
	 */
	public List<RsltNoteCtntListVO> searchNoteContentList(PriRpScpNoteCtntVO priRpScpNoteCtntVO) throws EventException {
		try {
			return dbDao.searchNoteContentList(priRpScpNoteCtntVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * Retrieving [Special Note Conversion]<br>
	 * 
	 * @param PriRfaNoteConvVO priRfaNoteConvVO
	 * @return List<PriRfaNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltNoteConvVO> searchNoteConversionList(PriRfaNoteConvVO priRfaNoteConvVO) throws EventException {
		try {
			return dbDao.searchNoteConversionList(priRfaNoteConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Pasting [Special Note Conversion].<br>
	 * 
	 * @param PriRfaNoteConvVO priRfaNoteConvVO
	 * @param SignOnUserAccount account
	 * @return List<PriRfaNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltNoteConvVO> searchNoteConversionListCopy(PriRfaNoteConvVO priRfaNoteConvVO , SignOnUserAccount account) throws EventException {
		try {

			priRfaNoteConvVO.setCreUsrId(account.getUsr_id());
			
			return dbDao.searchNoteConversionListCopy(priRfaNoteConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Copying [Special Note Conversion]<br>
	 * 
	 * @param PriRfaNoteConvListVO[] priRfaNoteConvListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCopy(PriRfaNoteConvListVO[] priRfaNoteConvListVOs, SignOnUserAccount account) throws EventException{
		try {			
			List<PriRfaNoteConvListVO> insertVoList = new ArrayList<PriRfaNoteConvListVO>();
			
			for ( int i=0; i<priRfaNoteConvListVOs.length; i++ ) {
				if ( priRfaNoteConvListVOs[i].getIbflag().equals("I")){
					priRfaNoteConvListVOs[i].setCreUsrId(account.getUsr_id());
					priRfaNoteConvListVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priRfaNoteConvListVOs[i]);
				}
			}			
			if ( insertVoList.size() > 0 ) {
				dbDao.removeNoteConversionCopy(priRfaNoteConvListVOs[0]);				
				dbDao.addNoteConversionCopy(insertVoList);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving [Commodity Note's DETAIL]<br>
	 * 
	 * @param PriRpScpRtCnoteVO priRpScpRtCnoteVO
	 * @return List<PriRpScpRtCnoteVO>
	 * @exception EventException
	 */
	public List<PriRpScpRtCnoteVO> searchCommodityNoteContentList(PriRpScpRtCnoteVO priRpScpRtCnoteVO) throws EventException {
		try {
			return dbDao.searchCommodityNoteContentList(priRpScpRtCnoteVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
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
// pri_sc_note_conv) creation
// pri_sp_scp_note_ctnt creation	
			log.debug("amendProposal==exp_dt==conversion="+priRpMnVO.getExpDt());
			
			dbDao.addProposalNoteConversionAmend (insertVoList);
			if (!priRpMnVO.getExpDt().equals("")){
				dbDao.modifyProposalNoteConversionAmendExp (insertVoList);	
				log.debug("exp_dt==============conversion="+priRpMnVO.getExpDt());
			}
			
				
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	

	/**
	 * Modifying expire data of conversion when modifying expire data of Main Duration <br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionExpireDate(PriRpScpMnVO[] priRpScpMnVO,SignOnUserAccount account)throws EventException{
		try {		
			if ( priRpScpMnVO != null ) {
				List<PriRpScpMnVO> updateVoList = new ArrayList<PriRpScpMnVO>();
				for ( int i=0; i<priRpScpMnVO .length; i++ ) {
					if ("U".equals(priRpScpMnVO[i].getIbflag())){
						priRpScpMnVO[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(priRpScpMnVO[i]);						
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
     * Copying RFA Proposal Special Note Conversion information<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalRfaNoteConversion(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException{
        try {
        	rsltRfaPropCopyVO.setCreUsrId(account.getUsr_id());
        	rsltRfaPropCopyVO.setUpdUsrId(account.getUsr_id());
        	rsltRfaPropCopyVO.setOfcCd(account.getOfc_cd());
            // PRI_RFA_NOTE_CONV COPY
            dbDao.addCopyProposalRfaNoteConversion(rsltRfaPropCopyVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Copying RFA Proposal Rate Route Note Conversion information<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalRoutNoteConversion(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException{
        try {
        	rsltRfaPropCopyVO.setCreUsrId(account.getUsr_id());
        	rsltRfaPropCopyVO.setUpdUsrId(account.getUsr_id());
        	rsltRfaPropCopyVO.setOfcCd(account.getOfc_cd());
            // PRI_RFA_NOTE_CONV COPY
            dbDao.addCopyProposalRoutNoteConversion(rsltRfaPropCopyVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Copying RFA Proposal Rate Commodity Note Conversion information<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
     * @param SignOnUserAccount account
     * @throws DAOException
     */
    public void copyProposalCmdtNoteConversion(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException{
        try {
        	rsltRfaPropCopyVO.setCreUsrId(account.getUsr_id());
        	rsltRfaPropCopyVO.setUpdUsrId(account.getUsr_id());
        	rsltRfaPropCopyVO.setOfcCd(account.getOfc_cd());
            // PRI_RFA_NOTE_CONV COPY
            dbDao.addCopyProposalCmdtNoteConversion(rsltRfaPropCopyVO);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

	/**
	 * Saving conversion data when saving SPECIAL NOTE<br>
	 * 
	 * @param NotePropVO notePropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversion(NotePropVO notePropVO, SignOnUserAccount account) throws EventException{
		try {
			PriRpScpNoteListVO[] vo = notePropVO.getPriRpScpNoteListVOs();
			PriRpScpNoteCtntListVO[] dtlvo = notePropVO.getPriRpScpNoteCtntListVOs();
			PriRfaNoteConvListVO[] priRfaNoteConvListVO = notePropVO.getPriRfaNoteConvListVOs();
			String masterDelChk = notePropVO.getMasterDelChk();
			PriRpScpNoteListVO priRpScpNoteListVO = notePropVO.getPriRpScpNoteListVO();
			
			List<PriRpScpNoteListVO> insertVoList = new ArrayList<PriRpScpNoteListVO>();
			List<PriRpScpNoteListVO> updateVoList = new ArrayList<PriRpScpNoteListVO>();
			List<PriRpScpNoteListVO> deleteVoList = new ArrayList<PriRpScpNoteListVO>();
			List<PriRpScpNoteCtntListVO> insertDtlVoList = new ArrayList<PriRpScpNoteCtntListVO>();
			List<PriRpScpNoteCtntListVO> updateDtlVoList = new ArrayList<PriRpScpNoteCtntListVO>();
			List<PriRpScpNoteCtntListVO> deleteDtlVoList = new ArrayList<PriRpScpNoteCtntListVO>();		
			List<PriRfaNoteConvListVO> insertConvVoList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> updateConvVoList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> deleteConvVoList = new ArrayList<PriRfaNoteConvListVO>();
			
			for ( int i = 0; vo != null && i < vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("I")){
					vo[i].setCreUsrId(account.getUsr_id());
					vo[i].setUpdUsrId(account.getUsr_id());					
					insertVoList.add(vo[i]);
				} else if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());
					vo[i].setEffDt(priRpScpNoteListVO.getEffDt()); //in case of CONVERSION modification
					vo[i].setExpDt(priRpScpNoteListVO.getExpDt()); //in case of CONVERSION modification
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
			
			for ( int i = 0; priRfaNoteConvListVO != null && i < priRfaNoteConvListVO.length; i++ ) {
				if ( priRfaNoteConvListVO[i].getIbflag().equals("I")){
					priRfaNoteConvListVO[i].setCreUsrId(account.getUsr_id());
					priRfaNoteConvListVO[i].setUpdUsrId(account.getUsr_id());
					insertConvVoList.add(priRfaNoteConvListVO[i]);
				} else if ( priRfaNoteConvListVO[i].getIbflag().equals("U")){
					priRfaNoteConvListVO[i].setUpdUsrId(account.getUsr_id());
					updateConvVoList.add(priRfaNoteConvListVO[i]);
				} else if ( priRfaNoteConvListVO[i].getIbflag().equals("D")){
					deleteConvVoList.add(priRfaNoteConvListVO[i]);
				}
			}

			if ( updateVoList.size() > 0 ) {
				if("Y".equals(masterDelChk)) {
					//Deleting all CONVERSION- handling NOTE deletion in advance : sperating deleting data by source code
					dbDao.removeNoteMasterAmend(updateVoList);
				}
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeNote(deleteVoList);
			}
			
			if ( updateDtlVoList.size() > 0 ) {
				//AMEND CANCEL�대㈃ CONVERSION DELETE
				//1) Showing STATUS="I' onto sheet as retrieving previous SEQ's data on screen
				//2) Deleting from server(this part)
				//3) Saving sheet data setted on screen(if ( insertConvVoList.size() > 0 ) {})
				if(priRpScpNoteListVO.getAmendFunc().equals("12")){	// COMMAND02 - AMEND CANCEL
					PriRpScpNoteCtntVO priRpScpNoteCtntVO = new PriRpScpNoteCtntVO();
					ObjectCloner.build(priRpScpNoteListVO, priRpScpNoteCtntVO);
					dbDao.removeNoteConversion(priRpScpNoteCtntVO);
				} 
				//AMEND DELETE
				//Deleting all converation from server because of multi deletable amendment data in detail in case of deleting amendment from master 
				else if(priRpScpNoteListVO.getAmendFunc().equals("8")) { //IBDELETE
					dbDao.removeNoteContent(updateDtlVoList);
				}
				else {
					//In case of AMEND, no need to handle here because modification happens on conversion sheet
					//dbDao.modifyNoteContent(updateDtlVoList);
				}
				
			}
			
			if ( deleteDtlVoList.size() > 0 ) {
				dbDao.removeNoteContent(deleteDtlVoList);
			}
			
			if ( insertConvVoList.size() > 0 ) {
				dbDao.addNoteConversion(insertConvVoList);
			}
			
			if ( updateConvVoList.size() > 0 ) {
				dbDao.modifyNoteConversion(updateConvVoList);
			}
			
			if ( deleteConvVoList.size() > 0 ) {
				dbDao.removeNoteConversion(deleteConvVoList);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Handling conversion information at same time when deleting Rate's Commodity &Note<br>
	 * 
	 * @param RfaRtPropCmdtVO rfaRtPropCmdtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCascadeCommodity(RfaRtPropCmdtVO rfaRtPropCmdtVO, SignOnUserAccount account) throws EventException {
		try {
			PriRpScpRtCmdtHdrVO[] vo = rfaRtPropCmdtVO.getPriRpScpRtCmdtHdrVOS();
			PriRpScpRtCnoteVO[] cnotevo = rfaRtPropCmdtVO.getPriRpScpRtCnoteVOS();
			PriRfaNoteConvListVO[] convvo = rfaRtPropCmdtVO.getPriRfaNoteConvListVOS();

			List<PriRpScpRtCmdtHdrVO> deleteVoList = new ArrayList<PriRpScpRtCmdtHdrVO>();
			List<PriRpScpRtCnoteVO> deleteCnoteVoList = new ArrayList<PriRpScpRtCnoteVO>();
			List<PriRfaNoteConvListVO> insertConvVoList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> updateConvVoList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> deleteConvVoList = new ArrayList<PriRfaNoteConvListVO>();

			for (int i = 0; vo != null && i < vo.length; i++) {
				if (vo[i].getIbflag().equals("U")) {
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
				if (cnotevo[i].getIbflag().equals("D")) {
					deleteCnoteVoList.add(cnotevo[i]);
				}
			}
			for (int i = 0; convvo != null && i < convvo.length; i++) {
				if (convvo[i].getIbflag().equals("I")) {
					convvo[i].setCreUsrId(account.getUsr_id());
					convvo[i].setUpdUsrId(account.getUsr_id());
					insertConvVoList.add(convvo[i]);
				} else if (convvo[i].getIbflag().equals("U")) {
					convvo[i].setUpdUsrId(account.getUsr_id());
					updateConvVoList.add(convvo[i]);
				} else if (convvo[i].getIbflag().equals("D")) {
					deleteConvVoList.add(convvo[i]);
				}
			}


			if (deleteConvVoList.size() > 0) {
				dbDao.removeNoteConversion(deleteConvVoList);
			}
			if (deleteCnoteVoList.size() > 0) {
				dbDao.removeCNoteConvCascadeCnote(deleteCnoteVoList);
			}
			if (deleteVoList.size() > 0) {
				dbDao.removeCNoteConvCascadeCommodity(deleteVoList);
				dbDao.removeRNoteConvCascadeCommodity(deleteVoList);
			}
			if (updateConvVoList.size() > 0) {
				dbDao.modifyRfaNoteConv(updateConvVoList, "N");
			}
			if (insertConvVoList.size() > 0) {
				dbDao.addRfaNoteConv(insertConvVoList);
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
	 * Handling conversion information at same time when modifying Rate's route note<br>
	 * 
	 * @param RfaRtPropRtVO rfaRtPropRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCascadeRoute(RfaRtPropRtVO rfaRtPropRtVO, SignOnUserAccount account) throws EventException {
		try {
			PriRpScpRtCmdtRoutVO[] routvo = rfaRtPropRtVO.getPriRpScpRtCmdtRoutVOS();
			PriRpScpRtCmdtRnoteVO[] rnotevo = rfaRtPropRtVO.getPriRpScpRtCmdtRnoteVOS();
			PriRfaNoteConvListVO[] convvo = rfaRtPropRtVO.getPriRfaNoteConvListVOS();
	
			List<PriRpScpRtCmdtRoutVO> deleteRoutList = new ArrayList<PriRpScpRtCmdtRoutVO>();
			List<PriRpScpRtCmdtRnoteVO> deleteRnoteList = new ArrayList<PriRpScpRtCmdtRnoteVO>();
			List<PriRfaNoteConvListVO> insertConvList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> updateConvList = new ArrayList<PriRfaNoteConvListVO>();
			List<PriRfaNoteConvListVO> deleteConvList = new ArrayList<PriRfaNoteConvListVO>();
	
			for (int i = 0; routvo != null && i < routvo.length; i++) {
				if (routvo[i].getIbflag().equals("U")) {
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
				if (rnotevo[i].getIbflag().equals("D")) {
					deleteRnoteList.add(rnotevo[i]);
				}
			}
			for (int i = 0; convvo != null && i < convvo.length; i++) {
				if (convvo[i].getIbflag().equals("I")) {
					convvo[i].setCreUsrId(account.getUsr_id());
					convvo[i].setUpdUsrId(account.getUsr_id());
					insertConvList.add(convvo[i]);
				} else if (convvo[i].getIbflag().equals("U")) {
					convvo[i].setUpdUsrId(account.getUsr_id());
					updateConvList.add(convvo[i]);
				} else if (convvo[i].getIbflag().equals("D")) {
					deleteConvList.add(convvo[i]);
				}
			}
	
			if (deleteConvList.size() > 0) {
				dbDao.removeNoteConversion(deleteConvList);
			}
			if (deleteRnoteList.size() > 0) {
				dbDao.removeRNoteConvCascadeRnote(deleteRnoteList);
			}
			if (deleteRoutList.size() > 0) {
				dbDao.removeRNoteConvCascadeRoute(deleteRoutList);
			}
			if (updateConvList.size() > 0) {
				dbDao.modifyRfaNoteConv(updateConvList, "N");
			}
			if (insertConvList.size() > 0) {
				dbDao.addRfaNoteConv(insertConvList);
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
	 * Changing effective data of conversion when changing effective date of main duration<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionEffectiveDate(PriRpScpMnVO[] priRpScpMnVO,SignOnUserAccount account)throws EventException{
		try {		
			if ( priRpScpMnVO != null ) {
				List<PriRpScpMnVO> updateVoList = new ArrayList<PriRpScpMnVO>();
				for ( int i=0; i<priRpScpMnVO .length; i++ ) {
					if ("U".equals(priRpScpMnVO[i].getIbflag())){
						priRpScpMnVO[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(priRpScpMnVO[i]);
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
	 * Deleting conversion when canceling proposal<br>
	 * 
	 * @param PriRpMnVO priRpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriRpMnVO priRpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalConversion(priRpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
			
}