/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupLocationProposalBCImpl.java
*@FileTitle : S/C Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.integration.RFAGroupLocationProposalDBDAO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.vo.GrpLocPropVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.vo.RsltGrpLocDtlListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.vo.RsltGrpLocListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRpMnVO;
import com.clt.syscommon.common.table.PriRpScpGrpLocDtlVO;
import com.clt.syscommon.common.table.PriRpScpGrpLocVO;
import com.clt.syscommon.common.table.PriRpScpMnVO;

/**
 * SCProposal Business Logic Basic Command implementation<br>
 * - Handling a biz logic about SCProposal<br>
 *
 * @author 
 * @see ESM_PRI_0003_02EventResponse,SCGroupLocationProposalBC refer to each DAO class
 * @since J2EE 1.4
 */

public class RFAGroupLocationProposalBCImpl extends BasicCommandSupport implements RFAGroupLocationProposalBC {

	// Database Access Object
	private transient RFAGroupLocationProposalDBDAO dbDao = null;

	/**
	 * Creating SCGroupLocationProposalBCImpl Object<br>
	 * Creating SCGroupLocationProposalDBDAO.<br>
	 */
	public RFAGroupLocationProposalBCImpl() {
		dbDao = new RFAGroupLocationProposalDBDAO();
	}
	
	/**
	 * Retrieving LOCATION GROUP DETAIL<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO  
	 * @return List<PriRpScpGrpLocDtlVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchGroupLocationDetailList (PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO) throws EventException {
		try {
			return dbDao.searchGroupLocationDetailList (priRpScpGrpLocDtlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving LOCATION GROUP MASTER<br>
	 * 
	 * @param PriRpScpGrpLocVO priRpScpGrpLocVO  
	 * @return List<PriRpScpGrpLocVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationList (PriRpScpGrpLocVO priRpScpGrpLocVO) throws EventException {
		try {
			return dbDao.searchGroupLocationList (priRpScpGrpLocVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving whether use in RATE<br>
	 * 
	 * @param PriRpScpGrpLocVO[] priRpScpGrpLocVOs  
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationRateApplyList (PriRpScpGrpLocVO[] priRpScpGrpLocVOs) throws EventException {
		try {
			PriRpScpGrpLocVO vo = new PriRpScpGrpLocVO();
			vo.setPropNo(priRpScpGrpLocVOs[0].getPropNo());
			vo.setAmdtSeq(priRpScpGrpLocVOs[0].getAmdtSeq());
			vo.setSvcScpCd(priRpScpGrpLocVOs[0].getSvcScpCd());
			List<String> txtArr = new ArrayList<String>();
			for(int i=0;i<priRpScpGrpLocVOs.length;i++){
				txtArr.add(priRpScpGrpLocVOs[i].getGrpLocSeq());
			}
			return dbDao.searchGroupLocationRateApplyList (vo, txtArr);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	

	/**
	 *Copying GUIDELINE LOCATION GROUP<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int copyGuidelineGroupLocation(PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO, SignOnUserAccount account) throws EventException{
		try {
			int result = 0;
			priRpScpGrpLocDtlVO.setCreUsrId(account.getUsr_id());
			priRpScpGrpLocDtlVO.setUpdUsrId(account.getUsr_id());
			if ( priRpScpGrpLocDtlVO != null ) {
				result = dbDao.addProposalMainGroupLocationGlineCopy (priRpScpGrpLocDtlVO);				
				dbDao.addProposalMainGroupLocationDetailGlineCopy (priRpScpGrpLocDtlVO);				
			}
			
			return result;
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Saving LOCATION GROUP<br>
	 * 
	 * @param GrpLocPropVO grpLocPropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGroupLocation(GrpLocPropVO grpLocPropVO, SignOnUserAccount account) throws EventException{
		try {
			PriRpScpGrpLocVO[] vo = grpLocPropVO.getPrirpscpgrplocvos();
			PriRpScpGrpLocDtlVO[] dtlvo = grpLocPropVO.getPrirpscpgrplocdtlvos();
			
			List<PriRpScpGrpLocVO> insertVoList = new ArrayList<PriRpScpGrpLocVO>();
			List<PriRpScpGrpLocVO> updateVoList = new ArrayList<PriRpScpGrpLocVO>();
			List<PriRpScpGrpLocVO> deleteVoList = new ArrayList<PriRpScpGrpLocVO>();
			List<PriRpScpGrpLocDtlVO> insertDtlVoList = new ArrayList<PriRpScpGrpLocDtlVO>();
			List<PriRpScpGrpLocDtlVO> updateDtlVoList = new ArrayList<PriRpScpGrpLocDtlVO>();
			List<PriRpScpGrpLocDtlVO> deleteDtlVoList = new ArrayList<PriRpScpGrpLocDtlVO>();			
			
			for ( int i = 0; vo != null && i < vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("I")){
					vo[i].setCreUsrId(account.getUsr_id());
					vo[i].setUpdUsrId(account.getUsr_id());					
					insertVoList.add(vo[i]);
				} else if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(vo[i]);
				} else if ( vo[i].getIbflag().equals("D")){
					vo[i].setUpdUsrId(account.getUsr_id());					
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
					dtlvo[i].setUpdUsrId(account.getUsr_id());					
					deleteDtlVoList.add(dtlvo[i]);
				}
			}			

			if ( insertVoList.size() > 0 ) {
				dbDao.addGroupLocation(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyGroupLocation(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				// in case of Proposal 
				if(deleteVoList.get(0).getAmdtSeq().equals("0")){
					dbDao.removeMasterGroupLocationDetail(deleteVoList);
					
					dbDao.removeMasterGroupLocation(deleteVoList);				
				}else{
					// in case of Amend
					// delete data with I,NW 
					// update sts = A, src_info = AD 
					dbDao.removeMasterGroupLocationAmend(deleteVoList);
										
					dbDao.modifyMasterGroupLocationAmend(deleteVoList);
					
					dbDao.removeMasterGroupLocation(deleteVoList);
				}				
			}
			if ( insertDtlVoList.size() > 0 ) {
				dbDao.addGroupLocationDetail(insertDtlVoList);
			}
			
			if ( updateDtlVoList.size() > 0 ) {
				dbDao.modifyGroupLocationDetail(updateDtlVoList);
			}
			
			if ( deleteDtlVoList.size() > 0 ) {
				dbDao.removeGroupLocationDetail(deleteDtlVoList);
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 *Accepting LOCATION GROUP all<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String acceptAllGroupLocation(PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO, SignOnUserAccount account) throws EventException{
		
		String result = "FAIL";
		
		try {
			priRpScpGrpLocDtlVO.setPrcProgStsCd("A");
			priRpScpGrpLocDtlVO.setAcptUsrId(account.getUsr_id());
			priRpScpGrpLocDtlVO.setAcptOfcCd(account.getOfc_cd());					
			priRpScpGrpLocDtlVO.setUpdUsrId(account.getUsr_id());
			int cnt = dbDao.searchGroupLocationDetailStatusList(priRpScpGrpLocDtlVO);

			if(cnt>0){
				dbDao.modifyAllGroupLocationDetail(priRpScpGrpLocDtlVO);	
				result = "OK";
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		
		return result;
	}

	/**
	 * Canceling LOCATION GROUP all <br>
	 * 
	 * @param PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String cancelAllGroupLocation(PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO, SignOnUserAccount account) throws EventException{
	
		String result = "";
		
		try {
			priRpScpGrpLocDtlVO.setPrcProgStsCd("I");
			priRpScpGrpLocDtlVO.setAcptUsrId(account.getUsr_id());
			priRpScpGrpLocDtlVO.setAcptOfcCd(account.getOfc_cd());					
			priRpScpGrpLocDtlVO.setUpdUsrId(account.getUsr_id());
			int cnt = dbDao.searchGroupLocationDetailStatusList(priRpScpGrpLocDtlVO);

			if(cnt>0){
				dbDao.modifyAllGroupLocationDetail(priRpScpGrpLocDtlVO);	
				result = "OK";
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		
		return result;
	}
	
	/**
	 * Accepting LOCATION GROUP<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO[] priRpScpGrpLocDtlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptGroupLocation(PriRpScpGrpLocDtlVO[] priRpScpGrpLocDtlVOs, SignOnUserAccount account) throws EventException{
		try {

			List<PriRpScpGrpLocDtlVO> updateDtlVoList = new ArrayList<PriRpScpGrpLocDtlVO>();
			
			for ( int i = 0; priRpScpGrpLocDtlVOs != null && i < priRpScpGrpLocDtlVOs.length; i++ ) {
				if ( priRpScpGrpLocDtlVOs[i].getIbflag().equals("U")){
					priRpScpGrpLocDtlVOs[i].setAcptUsrId(account.getUsr_id());
					priRpScpGrpLocDtlVOs[i].setAcptOfcCd(account.getOfc_cd());
					priRpScpGrpLocDtlVOs[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(priRpScpGrpLocDtlVOs[i]);
				}
			}
		
			if ( updateDtlVoList.size() > 0 ) {
				dbDao.modifyGroupLocationDetail(updateDtlVoList);
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	
	
	/**
	 *  Cancelling LOCATION GROUP<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO[] priRpScpGrpLocDtlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGroupLocation(PriRpScpGrpLocDtlVO[] priRpScpGrpLocDtlVOs, SignOnUserAccount account) throws EventException{
		try {

			List<PriRpScpGrpLocDtlVO> updateDtlVoList = new ArrayList<PriRpScpGrpLocDtlVO>();
			
			for ( int i = 0; priRpScpGrpLocDtlVOs != null && i < priRpScpGrpLocDtlVOs.length; i++ ) {
				if ( priRpScpGrpLocDtlVOs[i].getIbflag().equals("U")){
					priRpScpGrpLocDtlVOs[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(priRpScpGrpLocDtlVOs[i]);
				}
			}
		
			if ( updateDtlVoList.size() > 0 ) {
				dbDao.modifyGroupLocationDetail(updateDtlVoList);
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);;
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Ameding LOCATION GROUP.<br>
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

			dbDao.addGroupLocationAmend (insertVoList);
			dbDao.addGroupLocationDetailAmend (insertVoList);
				
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	

    /**
     * Copying RFA Proposal Scope Group Location <br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeLocation(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException{
        try {
        	rsltRfaPropCopyVO.setCreUsrId(account.getUsr_id());
        	rsltRfaPropCopyVO.setUpdUsrId(account.getUsr_id());
        	rsltRfaPropCopyVO.setOfcCd(account.getOfc_cd());
            // PRI_RP_SCP_GRP_LOC COPY
            dbDao.addCopyProposalScopeLocation(rsltRfaPropCopyVO);
            // PRI_RP_SCP_GRP_LOC_DTL COPY
            dbDao.addCopyProposalScopeLocationDtl(rsltRfaPropCopyVO);
        } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
    }

    /**
     * Copying GUIDELINE LOCATION GROUP to PROPOSAL<br>
     * 
     * @param RpScpGlineCopyVO rpScpGlineCopyVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineGrpLoc(RpScpGlineCopyVO rpScpGlineCopyVO, SignOnUserAccount account) throws EventException{
        try {
        	rpScpGlineCopyVO.setCreUsrId(account.getUsr_id());
        	rpScpGlineCopyVO.setUpdUsrId(account.getUsr_id());
            // PRI_RP_SCP_GRP_LOC COPY
            dbDao.addCopyScopeGuidelineGrpLoc(rpScpGlineCopyVO);
            // PRI_RP_SCP_GRP_LOC_DTL COPY
            dbDao.addCopyScopeGuidelineGrpLocDtl(rpScpGlineCopyVO);
        } catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
    }
  
	/**
	 * Deleting all data of scope<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalContent(priRpScpMnVO);
			dbDao.removeProposal(priRpScpMnVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Changing Main's duration's Accepted data to "init" at once when cancelling Request<br>
	 * 
	 * @param PriRpScpMnVO[] priRpScpMnVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriRpScpMnVO[] priRpScpMnVOs,SignOnUserAccount account) throws EventException{
		try {
			List<PriRpScpMnVO> updateVoList = new ArrayList<PriRpScpMnVO>();
			
			for ( int i = 0; priRpScpMnVOs != null && i < priRpScpMnVOs.length; i++ ) {
				priRpScpMnVOs[i].setUpdUsrId(account.getUsr_id());
				updateVoList.add(priRpScpMnVOs[i]);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyProposalRequestCancel(updateVoList);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 *  Retrieving LOCATION GROUP DETAIL<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO  
	 * @return List<PriRpScpGrpLocDtlVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchGroupLocationDetailHistoryList (PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO) throws EventException {
		try {
			return dbDao.searchGroupLocationDetailHistoryList (priRpScpGrpLocDtlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 *  Retrieving LOCATION GROUP MASTER<br>
	 * 
	 * @param PriRpScpGrpLocVO priRpScpGrpLocVO  
	 * @return List<PriRpScpGrpLocVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationHistoryList (PriRpScpGrpLocVO priRpScpGrpLocVO) throws EventException {
		try {
			return dbDao.searchGroupLocationHistoryList (priRpScpGrpLocVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * Checking whether common code exists or not<br>
	 * 
	 * @param RsltGrpLocDtlListVO[] rsltGrpLocDtlListVOs
	 * @return String[]
	 * @exception EventException
	 */
	public String[] checkGroupLocationCode(RsltGrpLocDtlListVO[] rsltGrpLocDtlListVOs) throws EventException {
		try {
			RsltCdListVO rsltCdListVO = new RsltCdListVO();
			List<RsltCdListVO> cdList = new ArrayList<RsltCdListVO>();
			String strLocCd = "";
			String[] arrLocCd = new String[2];
			
			for (int i = 0; rsltGrpLocDtlListVOs != null && i < rsltGrpLocDtlListVOs.length; i++) {
				if ( !rsltGrpLocDtlListVOs[i].getIbflag().equals("D")){				
					rsltCdListVO.setCd(rsltGrpLocDtlListVOs[i].getLocCd());
					rsltCdListVO.setEtc1(rsltGrpLocDtlListVOs[0].getOrgDestTpCd());
					rsltCdListVO.setSvcScpCd(rsltGrpLocDtlListVOs[i].getSvcScpCd());
					
					cdList = dbDao.searchServiceScopeLocationCodeList(rsltCdListVO);
					
					if(cdList != null && cdList.size()>0) {
						continue;
					} else {
						strLocCd = strLocCd + rsltGrpLocDtlListVOs[i].getLocCd()+",";
					}
				}
			}
				
			if(!strLocCd.equals("") ) {
				arrLocCd[0] = strLocCd.substring(0, strLocCd.lastIndexOf(","));
				arrLocCd[1] = rsltGrpLocDtlListVOs[0].getOrgDestTpNm();
				
				//throw new EventException(new ErrorHandler("PRI01099",arrLocCd).getMessage());
			}
			
			return arrLocCd;
			
		//} catch(EventException ex) {
		//	log.error("err " + ex.toString(), ex);
		//	throw ex;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
	}
	
	
	/**
	 * Retrieving LOCATION GROUP DETAIL<br>
	 * 
	 * @param PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO  
	 * @return List<PriRpScpGrpLocDtlVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchGroupLocationDetailInquiryList (PriRpScpGrpLocDtlVO priRpScpGrpLocDtlVO) throws EventException {
		try {
			return dbDao.searchGroupLocationDetailInquiryList (priRpScpGrpLocDtlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving LOCATION GROUP MASTER<br>
	 * 
	 * @param PriRpScpGrpLocVO priRpScpGrpLocVO  
	 * @return List<PriRpScpGrpLocVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationInquiryList (PriRpScpGrpLocVO priRpScpGrpLocVO) throws EventException {
		try {
			return dbDao.searchGroupLocationInquiryList (priRpScpGrpLocVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
}