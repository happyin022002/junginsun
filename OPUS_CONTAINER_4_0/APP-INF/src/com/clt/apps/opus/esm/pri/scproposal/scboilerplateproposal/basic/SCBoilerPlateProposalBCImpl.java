/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCBoilerPlateProposalBCImpl.java
*@FileTitle : Bolier Plate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.integration.SCBoilerPlateProposalDBDAO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.BlplPropVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.CstBlplCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.CstBlplSearchVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.CstPriSpBlplVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.RsltBlplGcCntVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplCtntInqVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplCtntVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplExcelVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplHeaderVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplInqVO;
import com.clt.apps.opus.esm.pri.scproposal.scboilerplateproposal.vo.RsltPriSpBlplVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpBlplCtntVO;
import com.clt.syscommon.common.table.PriSpBlplVO;
import com.clt.syscommon.common.table.PriSpMnVO;

/**
 * SCProposal Business Logic Basic Command implementation<br>
 * - handling biz logic about SCProposal<br>
 *
 * @author 
 * @see ESM_PRI_0023EventResponse,SCBoilerPlateProposalBC reference each DAO class
 * @since J2EE 1.6
 */
public class SCBoilerPlateProposalBCImpl extends BasicCommandSupport implements SCBoilerPlateProposalBC {

	// Database Access Object
	private transient SCBoilerPlateProposalDBDAO dbDao = null;

	/**
	 * SCBoilerPlateProposalBCImpl object creation<br>
	 * creating SCBoilerPlateProposalDBDAO<br>
	 */
	public SCBoilerPlateProposalBCImpl() {
		dbDao = new SCBoilerPlateProposalDBDAO();
	}
	/**
	 * retrieving Boiler Plate List <br>
	 * 
	 * @param CstBlplSearchVO cstBlplSearchVO
	 * @return List<RsltPriSpBlplVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplVO> searchBoilerPlateList(CstBlplSearchVO cstBlplSearchVO) throws EventException {
		try {
			
			return dbDao.searchBoilerPlateList(cstBlplSearchVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * retrieving Boiler Plate Detail List <br>
	 * 
	 * @param PriSpBlplCtntVO priSpBlplCtntVO
	 * @return List<RsltPriSpBlplCtntVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplCtntVO> searchBoilerPlateDetailList(PriSpBlplCtntVO priSpBlplCtntVO) throws EventException {
		try {
			return dbDao.searchBoilerPlateDetailList(priSpBlplCtntVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * saving Boiler Plate data<br>
	 * 
	 * @param BlplPropVO blplPropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBoilerPlate(BlplPropVO blplPropVO, SignOnUserAccount account) throws EventException{
		try {
			PriSpBlplVO[] vo = blplPropVO.getPriSpBlplVOs();
			PriSpBlplCtntVO[] dtlvo = blplPropVO.getPriSpBlplCtntVOs();
			
			List<PriSpBlplVO> insertVoList = new ArrayList<PriSpBlplVO>();
			List<PriSpBlplVO> updateVoList = new ArrayList<PriSpBlplVO>();
			List<PriSpBlplVO> deleteVoList = new ArrayList<PriSpBlplVO>();
			List<PriSpBlplCtntVO> insertDtlVoList = new ArrayList<PriSpBlplCtntVO>();
			List<PriSpBlplCtntVO> updateDtlVoList = new ArrayList<PriSpBlplCtntVO>();
			List<PriSpBlplCtntVO> deleteDtlVoList = new ArrayList<PriSpBlplCtntVO>();			
			
			List<PriSpBlplVO> updateAmdVoList = new ArrayList<PriSpBlplVO>();
			List<PriSpBlplVO> deleteAmdVoList = new ArrayList<PriSpBlplVO>();
			
			
			for ( int i = 0; vo != null && i < vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("I")){
					vo[i].setCreUsrId(account.getUsr_id());
					vo[i].setUpdUsrId(account.getUsr_id());					
					insertVoList.add(vo[i]);
					log.debug("manageBoilerPlate===insert===1");
				} else if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(vo[i]);
					log.debug("manageBoilerPlate===update===2");
					if (vo[i].getSrcInfoCd().equals("AD")){
						updateAmdVoList.add(vo[i]);//detail update in case of amend delete 
						log.debug("manageBoilerPlate===amend delete update===3");
						deleteAmdVoList.add(vo[i]); //detail delete
						log.debug("manageBoilerPlate_===amend delete ===4");
					}
				} else if ( vo[i].getIbflag().equals("D")){

					deleteVoList.add(vo[i]);
					log.debug("manageBoilerPlate=== delete ===4");
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

			if ( insertVoList.size() > 0 ) {
				dbDao.addBoilerPlateS(insertVoList);				
			}
			if ( insertDtlVoList.size() > 0 ) {
				dbDao.addBoilerPlateDetailS(insertDtlVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyBoilerPlateS(updateVoList);
				
			}
			if ( updateDtlVoList.size() > 0 ) {
				dbDao.modifyBoilerPlateDetailS(updateDtlVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				//PRI_SP_BLPL_MIG_HIS & PRI_SP_BLPL_CTNT_MIG_HIS (2016.02.11)
				dbDao.addHistoryBoilerPlateS(deleteVoList);
				dbDao.addHistoryBoilerPlateDetailS(deleteVoList);
			}
			
			if ( deleteDtlVoList.size() > 0 ) {
				dbDao.removeBoilerPlateDetailS(deleteDtlVoList);
			}	
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeBoilerPlateDetailAllS(deleteVoList);
				dbDao.removeBoilerPlateS(deleteVoList);
			}
			
			if ( updateAmdVoList.size() > 0 ) {
				dbDao.modifyBoilerPlateDetailAmendS(updateAmdVoList);
			}
			if ( deleteAmdVoList.size() > 0 ) {
				dbDao.removeBoilerPlateDetailAllAmendS(deleteAmdVoList);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	
	
	/**
	 * retrieving Boiler Plate Header <br>
	 * 
	 * @param RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO
	 * @return List<RsltPriSpBlplHeaderVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplHeaderVO> searchBoilerPlateHeader(RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO) throws EventException {
		try {
			return dbDao.searchBoilerPlateHeader(rsltPriSpBlplHeaderVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	
	
	/**
	 * Copying GuideLine data<br>
	 * 
	 * @param CstBlplCopyVO vo
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String copyGuidelineBoilerPlate(CstBlplCopyVO vo, SignOnUserAccount account) throws EventException{
		String hdrBlplSeq = "";
		try {			
			
			if (vo != null){
				vo.setN1stCmncDt(vo.getEffDt());
				vo.setCreUsrId(account.getUsr_id());
				vo.setUpdUsrId(account.getUsr_id());
				hdrBlplSeq = dbDao.searchBoilerPlateHeaderSeq(vo);
				vo.setBlplHdrSeq(hdrBlplSeq);
				dbDao.addBoilerPlateCopy(vo);
				dbDao.addBoilerPlateCtntCopy(vo);				
			}
					
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return hdrBlplSeq;
	}	
	
	/**
	 * retrieving Boiler Plate Title and Content for sending Boiler Plate data Excel file <br>
	 * 
	 * @param PriSpBlplVO priSpBlplVO
	 * @return List<RsltPriSpBlplExcelVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplExcelVO> searchBoilerPlateListExcel(PriSpBlplVO priSpBlplVO) throws EventException {
		try {
			return dbDao.searchBoilerPlateListExcel(priSpBlplVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Accepting Boiler Plate Title data<br>
	 * 
	 * @param PriSpBlplVO[] priSpBlplVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptBoilerPlate(PriSpBlplVO[] priSpBlplVO, SignOnUserAccount account) throws EventException{
		try {

			List<PriSpBlplVO> updateVoList = new ArrayList<PriSpBlplVO>();
			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
			for ( int i = 0; priSpBlplVO != null && i < priSpBlplVO.length; i++ ) {

				if ( priSpBlplVO[i].getIbflag().equals("U")){
					priSpBlplVO[i].setUpdUsrId(account.getUsr_id());					
					priSpBlplVO[i].setAcptUsrId(account.getUsr_id());
					priSpBlplVO[i].setAcptOfcCd(account.getOfc_cd());								
					priSpBlplVO[i].setAcptDt(currentDate);					
					updateVoList.add(priSpBlplVO[i]);
				}
			}
			dbDao.modifyBoilerPlateS (updateVoList);	
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}		
	/**
	 * Boiler Plate Title data Accept Canceling<br>
	 * 
	 * @param PriSpBlplVO[] priSpBlplVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelBoilerPlate(PriSpBlplVO[] priSpBlplVO, SignOnUserAccount account) throws EventException{
		try {
		
			List<PriSpBlplVO> updateVoList = new ArrayList<PriSpBlplVO>();
			
			for ( int i = 0; priSpBlplVO != null && i < priSpBlplVO.length; i++ ) {

				if ( priSpBlplVO[i].getIbflag().equals("U")){
					priSpBlplVO[i].setUpdUsrId(account.getUsr_id());					
					priSpBlplVO[i].setAcptUsrId("");
					priSpBlplVO[i].setAcptOfcCd("");								
					priSpBlplVO[i].setAcptDt(null);					
					updateVoList.add(priSpBlplVO[i]);
				}
			}	
			dbDao.modifyBoilerPlateS (updateVoList);	
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}		
	
	/**
	 * Boiler Plate Content data Accepting<br>
	 * 
	 * @param PriSpBlplCtntVO[] priSpBlplCtntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptBoilerPlateContent(PriSpBlplCtntVO[] priSpBlplCtntVO, SignOnUserAccount account) throws EventException{
		try {
		
			List<PriSpBlplCtntVO> updateVoList = new ArrayList<PriSpBlplCtntVO>();			
			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
			for ( int i = 0; priSpBlplCtntVO != null && i < priSpBlplCtntVO.length; i++ ) {

				if ( priSpBlplCtntVO[i].getIbflag().equals("U")){
					priSpBlplCtntVO[i].setUpdUsrId(account.getUsr_id());					
					priSpBlplCtntVO[i].setAcptUsrId(account.getUsr_id());
					priSpBlplCtntVO[i].setAcptOfcCd(account.getOfc_cd());								
					priSpBlplCtntVO[i].setAcptDt(currentDate);					
					updateVoList.add(priSpBlplCtntVO[i]);
				}
			}				
			dbDao.modifyBoilerPlateDetailS (updateVoList);
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}		
	/**
	 * Boiler Plate Content data Accept Canceling<br>
	 * 
	 * @param PriSpBlplCtntVO[] priSpBlplCtntVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelBoilerPlateContent(PriSpBlplCtntVO[] priSpBlplCtntVO, SignOnUserAccount account) throws EventException{
		try {
		
			List<PriSpBlplCtntVO> updateVoList = new ArrayList<PriSpBlplCtntVO>();
			
			for ( int i = 0; priSpBlplCtntVO != null && i < priSpBlplCtntVO.length; i++ ) {

				if ( priSpBlplCtntVO[i].getIbflag().equals("U")){
					priSpBlplCtntVO[i].setUpdUsrId(account.getUsr_id());					
					priSpBlplCtntVO[i].setAcptUsrId("");
					priSpBlplCtntVO[i].setAcptOfcCd("");								
					priSpBlplCtntVO[i].setAcptDt(null);					
					updateVoList.add(priSpBlplCtntVO[i]);
				}
			}				
	
			dbDao.modifyBoilerPlateDetailS (updateVoList);	
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}			
	
	/**
	 * all data Accepting except already Accepted data in Boiler Plate<br>
	 * 
	 * @param CstPriSpBlplVO cstPriSpBlplVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int acceptAllBoilerPlate(CstPriSpBlplVO cstPriSpBlplVO, SignOnUserAccount account) throws EventException{
		int rValue = 0;
		try {			
			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
			if (cstPriSpBlplVO != null  ) {
				cstPriSpBlplVO.setUpdUsrId(account.getUsr_id());					
				cstPriSpBlplVO.setAcptUsrId(account.getUsr_id());
				cstPriSpBlplVO.setAcptOfcCd(account.getOfc_cd());
				cstPriSpBlplVO.setPrcProgStsCd(cstPriSpBlplVO.getStsCd());
				cstPriSpBlplVO.setAcptDt(currentDate);		
				rValue = dbDao.modifyAcceptAllBoilerPlate (cstPriSpBlplVO);	
				rValue += dbDao.modifyAcceptAllBoilerPlateContent (cstPriSpBlplVO);

			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return rValue;
		
	}		
	/**
	 * already Accepted data in Boiler Plate all Accept Canceling<br>
	 * 
	 * @param CstPriSpBlplVO cstPriSpBlplVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int cancelAllBoilerPlate(CstPriSpBlplVO cstPriSpBlplVO, SignOnUserAccount account) throws EventException{
		int rValue = 0;
		try {		
			if (cstPriSpBlplVO != null  ) {
				cstPriSpBlplVO.setUpdUsrId(account.getUsr_id());					
				cstPriSpBlplVO.setAcptUsrId("");
				cstPriSpBlplVO.setAcptOfcCd("");								
				cstPriSpBlplVO.setAcptDt(null);	
				cstPriSpBlplVO.setPrcProgStsCd(cstPriSpBlplVO.getStsCd());
				rValue = dbDao.modifyCancelAllBoilerPlate (cstPriSpBlplVO);	
				rValue += dbDao.modifyCancelAllBoilerPlateContent (cstPriSpBlplVO);	
			}	
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return rValue;
	}		
	
	
	/**
	 * Amend Request <br>
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

			dbDao.addBoilerPlateAmend(insertVoList);
			dbDao.addBoilerPlateContentAmend (insertVoList);
				
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

    /**
     * Proposal Boiler Plate Copying<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalBoilerPlate(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_SP_BLPL COPY
            dbDao.addCopyProposalBoilerPlate(vo);
            // PRI_SP_BLPL_CTNT COPY
            dbDao.addCopyProposalBoilerPlateCtnt(vo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
    }
    
    /**
	 * saving Excel Uploaded data to Boiler Plate<br>
	 * 
	 * @param BlplPropVO blplPropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBoilerPlateExl(BlplPropVO blplPropVO, SignOnUserAccount account) throws EventException{
		try {
			PriSpBlplVO[] vo = blplPropVO.getPriSpBlplVOs();
			PriSpBlplCtntVO[] dtlvo = blplPropVO.getPriSpBlplCtntVOs();
	
			List<PriSpBlplVO> insertVoList = new ArrayList<PriSpBlplVO>();
			List<PriSpBlplCtntVO> insertDtlVoList = new ArrayList<PriSpBlplCtntVO>();
	
			for ( int i = 0; vo != null && i < vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("I")){
					vo[i].setCreUsrId(account.getUsr_id());
					vo[i].setUpdUsrId(account.getUsr_id());					
					insertVoList.add(vo[i]);
				}
			}
			
			for ( int i = 0; dtlvo != null && i < dtlvo.length; i++ ) {
				if ( dtlvo[i].getIbflag().equals("I")){
					dtlvo[i].setCreUsrId(account.getUsr_id());
					dtlvo[i].setUpdUsrId(account.getUsr_id());					
					insertDtlVoList.add(dtlvo[i]);
				}
			}	

			if ( insertVoList.size() > 0 ) {
				dbDao.addBoilerPlateS(insertVoList);				
			}		
			
			if ( insertDtlVoList.size() > 0 ) {
				dbDao.addBoilerPlateDetailS(insertDtlVoList);
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
	 * when Canceling Main's init state, deleting all this Amend Seq NO. data <br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalCtnt(priSpMnVO);
			dbDao.removeProposalTitle(priSpMnVO);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * when Canceling Main's init state, deleting all this Amend Seq NO. data <br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void addProposalBlplMigHis(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.addProposalTitleMigHis(priSpMnVO);
			dbDao.addProposalCtntMigHis(priSpMnVO);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * when canceling Request, setting Accepted data with Init state<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpMnVO != null  ) {
				priSpMnVO.setUpdUsrId(account.getUsr_id());	
				dbDao.modifyProposalCtntRequestCancel(priSpMnVO);
				dbDao.modifyProposalTitleRequestCancel(priSpMnVO);
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
	 * returning Boiler Plate Record Count<br>
	 * 
	 * @param BlplPropVO blplPropVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int searchBoilerPlateCount(BlplPropVO blplPropVO, SignOnUserAccount account) throws EventException{
		int returnCnt = 0;
		try {
			PriSpBlplVO[] vo = blplPropVO.getPriSpBlplVOs();
			returnCnt = dbDao.searchBoilerPlateCount(vo[0]);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return returnCnt;
	}	
	
	/**
	 * Boiler Plate Amend History Title retrieving<br>
	 * 
	 * @param RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO
	 * @return List<RsltPriSpBlplHeaderVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplHeaderVO> searchBoilerPlateTitle(RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO) throws EventException {
		try {
			return dbDao.searchBoilerPlateTitle(rsltPriSpBlplHeaderVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	
	/**
	 * Boiler Plate Amend History Content retrieving<br>
	 * 
	 * @param PriSpBlplCtntVO priSpBlplCtntVO
	 * @return List<RsltPriSpBlplCtntVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplCtntVO> searchBoilerPlateDetailHistoryList(PriSpBlplCtntVO priSpBlplCtntVO) throws EventException {
		try {
			return dbDao.searchBoilerPlateDetailHistoryList(priSpBlplCtntVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Boiler Plate Amend History List retrieving<br>
	 * 
	 * @param CstBlplSearchVO cstBlplSearchVO
	 * @return List<RsltPriSpBlplVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplVO> searchBoilerPlateHistoryList(CstBlplSearchVO cstBlplSearchVO) throws EventException {
		try {
			
			return dbDao.searchBoilerPlateHistoryList(cstBlplSearchVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * retrieving Boiler Plate Header <br>
	 * 
	 * @param RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO
	 * @return List<RsltPriSpBlplHeaderVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplHeaderVO> searchBoilerPlateHeaderInquiry(RsltPriSpBlplHeaderVO rsltPriSpBlplHeaderVO) throws EventException {
		try {
			return dbDao.searchBoilerPlateHeaderInquiry(rsltPriSpBlplHeaderVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * retrieving Boiler Plate Title <br>
	 * 
	 * @param CstBlplSearchVO cstBlplSearchVO
	 * @return List<RsltPriSpBlplInqVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplInqVO> searchBoilerPlateInquiryList(CstBlplSearchVO cstBlplSearchVO) throws EventException {
		try {
			
			return dbDao.searchBoilerPlateInquiryList(cstBlplSearchVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * retrieving Boiler Plate Contents <br>
	 * 
	 * @param PriSpBlplCtntVO priSpBlplCtntVO
	 * @return List<RsltPriSpBlplCtntInqVO>
	 * @exception EventException
	 */
	public List<RsltPriSpBlplCtntInqVO> searchBoilerPlateDetailInquiryList(PriSpBlplCtntVO priSpBlplCtntVO) throws EventException {
		try {
			return dbDao.searchBoilerPlateDetailInquiryList(priSpBlplCtntVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
     * when deleting Master, checking existence of accepted data in detail<br>
     * can not deleting when accepted data exist<br>
	 * 
	 * @param PriSpBlplVO[] priSpBlplVOs
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchDetailAccept(PriSpBlplVO[] priSpBlplVOs) throws EventException {
		try {
			PriSpBlplVO blplVo = new PriSpBlplVO();
			blplVo.setPropNo(priSpBlplVOs[0].getPropNo());
			blplVo.setAmdtSeq(priSpBlplVOs[0].getAmdtSeq());
			List<String> txtArr = new ArrayList<String>();
			for(int i=0;i<priSpBlplVOs.length;i++){
				log.debug("for==========i==="+i);
				txtArr.add(priSpBlplVOs[i].getBlplSeq());
				log.debug("taxArr==="+priSpBlplVOs[i].getBlplSeq());
			}
			log.debug("searchDetailAccept=======================bc=== 2 ");
			return dbDao.searchDetailAccept(blplVo, txtArr);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}  	
	/**
	 * automatically Accepting, when all SRC_INFO_CD = GC and deleted data doesn't exist<br>
	 * 
	 * @param PriSpBlplvo priSpBlplvo
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int autoAcceptProposalBoilerPlate(PriSpBlplVO priSpBlplVO, SignOnUserAccount account) throws EventException{
		int rValue = 0;
		try {			
			//checking all data are GC.
			RsltBlplGcCntVO rsltBlplGcCntVO = dbDao.searchRowCountNotFromGuideline( priSpBlplVO);
			if(rsltBlplGcCntVO.getBlplCnt().equals("0") 
					&& rsltBlplGcCntVO.getBlplCtntCnt().equals("0") 
					&& rsltBlplGcCntVO.getBlplMnsCnt().equals("0")
					&& rsltBlplGcCntVO.getBlplCtntMnsCnt().equals("0")){
				String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
				priSpBlplVO.setPrcProgStsCd("A");
				priSpBlplVO.setUpdUsrId(account.getUsr_id());					
				priSpBlplVO.setAcptUsrId(account.getUsr_id());
				priSpBlplVO.setAcptOfcCd(account.getOfc_cd());
				priSpBlplVO.setAcptDt(currentDate);					
				rValue = dbDao.modifyAutoAcceptOrCancelBoilerPlate (priSpBlplVO);	
				rValue += dbDao.modifyAutoAcceptOrCancelBoilerPlateContent (priSpBlplVO);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return rValue;
	}
	
	/**
	 * automatically Canceling, when all SRC_INFO_CD = GC and deleted data doesn't exist<br>
	 * 
	 * @param PriSpBlplvo priSpBlplvo
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int autoCancelProposalBoilerPlate(PriSpBlplVO priSpBlplVO, SignOnUserAccount account) throws EventException{
		int rValue = 0;
		try {			
			//checking all data are GC
			RsltBlplGcCntVO rsltBlplGcCntVO = dbDao.searchRowCountNotFromGuideline( priSpBlplVO);
			if(rsltBlplGcCntVO.getBlplCnt().equals("0") 
					&& rsltBlplGcCntVO.getBlplCtntCnt().equals("0")
					&& rsltBlplGcCntVO.getBlplMnsCnt().equals("0")
					&& rsltBlplGcCntVO.getBlplCtntMnsCnt().equals("0")	){
				priSpBlplVO.setPrcProgStsCd("I");				 
				priSpBlplVO.setUpdUsrId(account.getUsr_id());					
				priSpBlplVO.setAcptUsrId("");
				priSpBlplVO.setAcptOfcCd("");
				priSpBlplVO.setAcptDt("");					
				rValue = dbDao.modifyAutoAcceptOrCancelBoilerPlate (priSpBlplVO);	
				rValue += dbDao.modifyAutoAcceptOrCancelBoilerPlateContent (priSpBlplVO);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return rValue;
	}
	
	
}