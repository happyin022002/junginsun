/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TRINoteConversionProposalBCImpl.java
*@FileTitle : Tariff Fomula Rule Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.integration.TRINoteConversionProposalDBDAO;
import com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.vo.PriTriNoteConvListVO;
import com.clt.apps.opus.esm.pri.triproposal.trinoteconversionproposal.vo.RsltPriTriNoteConvVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.TriPropGRIVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.TriPropVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriTriNoteConvVO;
import com.clt.syscommon.common.table.PriTriNoteVO;
import com.clt.syscommon.common.table.PriTriRtVO;

/**
 * TRIProposal Business Logic Command Interface<br>
 * - Handling a biz logic about TRIProposal<br>
 *
 * @author SHKIM
 * @see EsmPri3005EventResponse,TRINoteConversionProposalBC - Refer to each DAO class
 * @since J2EE 1.6
 */
public class TRINoteConversionProposalBCImpl extends BasicCommandSupport implements TRINoteConversionProposalBC {

	// Database Access Object
	private transient TRINoteConversionProposalDBDAO dbDao = null;

	/**
	 * Creating TRINoteConversionProposalBCImpl Object <br>
	 * Creating TRINoteConversionProposalDBDAO.<br>
	 */
	public TRINoteConversionProposalBCImpl() {
		dbDao = new TRINoteConversionProposalDBDAO();
	}

	/**
	 * Retrieving Duration list on Tariff Fomula Rule screen<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @return List<PriTriNoteVO>
	 * @exception EventException
	 */
	public List<PriTriNoteVO> searchTRIFomulaRuleInfo(PriTriNoteVO priTriNoteVO) throws EventException {
		try {
			return dbDao.searchTRIFomulaRuleInfo(priTriNoteVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 *Retrieving TRI Note information.<br>
	 * 
	 * @param PriTriNoteConvVO priTriNoteConvVO
	 * @return List<RsltPriTriNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltPriTriNoteConvVO> searchNoteConversionList(PriTriNoteConvVO priTriNoteConvVO) throws EventException {
		try {
			return dbDao.searchNoteConversionList(priTriNoteConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving copied TRI NOTE CONVERSION .<br>
	 * 
	 * @param PriTriNoteConvVO priTriNoteConvVO
	 * @param SignOnUserAccount account
	 * @return List<RsltPriTriNoteConvVO>
	 * @exception EventException
	 */
	public List<RsltPriTriNoteConvVO> searchNoteConversionCopyList(PriTriNoteConvVO priTriNoteConvVO, SignOnUserAccount account) throws EventException {
		try {

			priTriNoteConvVO.setCreUsrId(account.getUsr_id());
			
			return dbDao.searchNoteConversionCopyList(priTriNoteConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Saving TRI Note Conversion information<br>
	 * 
	 * @param PriTriNoteConvListVO[] priTriNoteConvListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversion(PriTriNoteConvListVO[] priTriNoteConvListVOs, SignOnUserAccount account) throws EventException{
		try {			
			List<PriTriNoteConvListVO> insertVoList = new ArrayList<PriTriNoteConvListVO>();
			List<PriTriNoteConvListVO> updateVoList = new ArrayList<PriTriNoteConvListVO>();
			List<PriTriNoteConvListVO> deleteVoList = new ArrayList<PriTriNoteConvListVO>();
			
			if(priTriNoteConvListVOs != null){
				for ( int i=0; i<priTriNoteConvListVOs .length; i++ ) {
					if ( priTriNoteConvListVOs[i].getIbflag().equals("I")){
						priTriNoteConvListVOs[i].setCreUsrId(account.getUsr_id());
						priTriNoteConvListVOs[i].setUpdUsrId(account.getUsr_id());
						insertVoList.add(priTriNoteConvListVOs[i]);
					} else if ( priTriNoteConvListVOs[i].getIbflag().equals("U")){
						priTriNoteConvListVOs[i].setUpdUsrId(account.getUsr_id());
						updateVoList.add(priTriNoteConvListVOs[i]);
					} else if ( priTriNoteConvListVOs[i].getIbflag().equals("D")){
						deleteVoList.add(priTriNoteConvListVOs[i]);
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
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Copying TRI Note Conversion information.<br>
	 * 
	 * @param PriTriNoteConvListVO[] priTriNoteConvListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNoteConversionCopy(PriTriNoteConvListVO[] priTriNoteConvListVOs, SignOnUserAccount account) throws EventException{
		try {			
			List<PriTriNoteConvListVO> insertVoList = new ArrayList<PriTriNoteConvListVO>();
			
			for ( int i=0; i<priTriNoteConvListVOs .length; i++ ) {
				if ( priTriNoteConvListVOs[i].getIbflag().equals("I")){
					priTriNoteConvListVOs[i].setCreUsrId(account.getUsr_id());
					priTriNoteConvListVOs[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(priTriNoteConvListVOs[i]);
				}
			}			
			if ( insertVoList.size() > 0 ) {
				dbDao.removeNoteConversionCopy(priTriNoteConvListVOs[0]);				
				dbDao.addNoteConversionCopy(insertVoList);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 *Retrieving SERVICE SCOPE CODE<br>
	 * 
	 * @param PriTriNoteConvVO priTriNoteConvVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchServiceScopeCodeList(PriTriNoteConvVO priTriNoteConvVO) throws EventException {
		try {
			return dbDao.searchServiceScopeCodeList(priTriNoteConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}
	
	
	/**
	 * Saving Tariff Fomula Rule information<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTRIFomulaRule(PriTriNoteVO priTriNoteVO, SignOnUserAccount account) throws EventException{
		try {
			String tNoteSeq = priTriNoteVO.getNoteSeq();
			boolean isValidDate = dbDao.searchTRIFomulaRuleEffDate(priTriNoteVO);

			if (!isValidDate) {
				throw new EventException(new ErrorHandler("PRI08018").getMessage());
			}
			
			if(tNoteSeq.equals("") || tNoteSeq.equals("X")) {
				priTriNoteVO.setUpdUsrId(account.getUsr_id());
				priTriNoteVO.setCreUsrId(account.getUsr_id());
				//create
				dbDao.addTRIFomulaRule(priTriNoteVO);
			} else {
				priTriNoteVO.setUpdUsrId(account.getUsr_id());				
				//update
				dbDao.modifyTRIFomulaRule(priTriNoteVO, "N");
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Confirming Tariff Fomula Rule information<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void confirmTRIFomulaRule(PriTriNoteVO priTriNoteVO, SignOnUserAccount account) throws EventException{
		try {			
			priTriNoteVO.setCfmFlg("Y");
			priTriNoteVO.setCfmUsrId(account.getUsr_id());
			priTriNoteVO.setCfmOfcCd(account.getOfc_cd());
			priTriNoteVO.setUpdUsrId(account.getUsr_id());
			
			dbDao.modifyTRIFomulaRule(priTriNoteVO, "Y");
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	

	/**
	 * Canceling Confirmmation of Tariff Fomula Rule information  <br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelTRIFomulaRule(PriTriNoteVO priTriNoteVO, SignOnUserAccount account) throws EventException{
		try {			
			priTriNoteVO.setCfmFlg("N");
			priTriNoteVO.setCfmUsrId("");
			priTriNoteVO.setCfmOfcCd("");
			priTriNoteVO.setUpdUsrId(account.getUsr_id());
			
			dbDao.modifyTRIFomulaRule(priTriNoteVO, "Y");
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	

	/**
	 * Deleting Tariff Fomula Rule information.<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @exception EventException
	 */
	public void deleteTRIFomulaRule(PriTriNoteVO priTriNoteVO) throws EventException{
		try {		
			dbDao.removeNoteConversion(priTriNoteVO);
			dbDao.removeTRIFomulaRule(priTriNoteVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * Handling multi transaction of TRI Proposal , Rate data<br>
	 * 
	 * @param TriPropVO triPropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageTRIRateProposal(TriPropVO triPropVO, SignOnUserAccount account) throws EventException {
		try {
			PriTriRtVO[] rtvo = triPropVO.getPriTriRtVOS();

			List<PriTriRtVO> updateRtList = new ArrayList<PriTriRtVO>();

			for (int i = 0; rtvo != null && i < rtvo.length; i++) {
				if (rtvo[i].getIbflag().equals("U")) {
					rtvo[i].setUpdUsrId(account.getUsr_id());
					updateRtList.add(rtvo[i]);
				}
			}

			if (updateRtList.size() > 0) {
				dbDao.modifyNoteConversionDurationCascadeRt(updateRtList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Amending TRI Proposal data<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException {
		try {
			if (priTriRtVO != null) {
				priTriRtVO.setCreUsrId(account.getUsr_id());
				priTriRtVO.setUpdUsrId(account.getUsr_id());
				dbDao.addCopyNoteConversionOnAmend(priTriRtVO);
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
	 * Canceling TRI Proposal data.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException {
		try {
			if (priTriRtVO != null) {
				String sPropStsCd = priTriRtVO.getPropStsCd();
				
				if ("I".equals(sPropStsCd)) { // Initial.
					dbDao.removeNoteConversionOnCancel(priTriRtVO);
				}
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
	 * Canceling several TRI Proposal data<br>
	 * 
	 * @param PriTriRtVO[] priTriRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelMultiTRIRateProposal(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException {
		try {
			if (priTriRtVOs != null && priTriRtVOs.length > 0) {
				for (int i = 0; i < priTriRtVOs.length; i++) {
					String sPropStsCd = priTriRtVOs[i].getPropStsCd();
				
					if ("I".equals(sPropStsCd)) { // Initial. 
						dbDao.removeNoteConversionOnCancel(priTriRtVOs[i]);
					}
				}
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
	 * Publishing TRI Proposal data<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException {
		try {
			if (priTriRtVO != null) {
				priTriRtVO.setPropStsCd("F");
				priTriRtVO.setUpdUsrId(account.getUsr_id());

				dbDao.modifyNoteConversionDurationOnPublish(priTriRtVO);
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
	 * Publishing several TRI Proposal data<br>
	 * 
	 * @param PriTriRtVO[] priTriRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishMultiTRIRateProposal(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException {
		try {
			if (priTriRtVOs != null && priTriRtVOs.length > 0) {
				for (int i = 0; i < priTriRtVOs.length; i++) {
					priTriRtVOs[i].setPropStsCd("F");
					priTriRtVOs[i].setUpdUsrId(account.getUsr_id());

					dbDao.modifyNoteConversionDurationOnPublish(priTriRtVOs[i]);
				}
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
	 * Applying GRI Calculation<br>
	 * 
	 * @param TriPropGRIVO triPropGRIVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void applyGRICalculation(TriPropGRIVO triPropGRIVO, SignOnUserAccount account) throws EventException {
		try {
			if (triPropGRIVO != null) {
				dbDao.addCopyNoteConversionOnGRIApply(triPropGRIVO);
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
	 * Canceling applied GRI Calculation<br>
	 * 
	 * @param TriPropGRIVO triPropGRIVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGRICalculation(TriPropGRIVO triPropGRIVO, SignOnUserAccount account) throws EventException {
		try {
			if (triPropGRIVO != null) {
				dbDao.removeNoteConversionOnGRICancel(triPropGRIVO);
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
	 * Retrieving checking whether user have authority for approval by scope<br>
	 * 
	 * @param PriTriNoteVO priTriNoteVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchAuthScopeCount(PriTriNoteVO priTriNoteVO, SignOnUserAccount account) throws EventException {
		try {
			String authCount = "";
		  	String noteSeq = priTriNoteVO.getNoteSeq();
            if(noteSeq.equals("") || noteSeq.equals("X")) {
            	priTriNoteVO.setCreUsrId(account.getUsr_id());
            	authCount = dbDao.searchAuthScopeCount(priTriNoteVO);
            } else {
            	authCount = "0";
            }
            
            return authCount;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * Retrieving rule Code,Charge Code by service scope for Tariff Code<br>
	 * 
	 * @param PriTriNoteConvVO priTriNoteConvVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchRuleChargeCodeList(PriTriNoteConvVO priTriNoteConvVO) throws EventException {
		try {
			return dbDao.searchRuleChargeCodeList(priTriNoteConvVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}

}