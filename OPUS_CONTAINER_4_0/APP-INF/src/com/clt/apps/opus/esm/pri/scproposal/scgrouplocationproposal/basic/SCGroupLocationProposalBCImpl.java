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
package com.clt.apps.opus.esm.pri.scproposal.scgrouplocationproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.scproposal.scgrouplocationproposal.integration.SCGroupLocationProposalDBDAO;
import com.clt.apps.opus.esm.pri.scproposal.scgrouplocationproposal.vo.GrpLocPropVO;
import com.clt.apps.opus.esm.pri.scproposal.scgrouplocationproposal.vo.RsltGrpLocDtlListVO;
import com.clt.apps.opus.esm.pri.scproposal.scgrouplocationproposal.vo.RsltGrpLocListVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpMnVO;
import com.clt.syscommon.common.table.PriSpScpGrpLocDtlVO;
import com.clt.syscommon.common.table.PriSpScpGrpLocVO;
import com.clt.syscommon.common.table.PriSpScpMnVO;

/**
 * SCProposal Business Logic Basic Command implementation<br>
 * - Handling a biz logic about SCProposal<br>
 *
 * @author 
 * @see ESM_PRI_0003_02EventResponse,SCGroupLocationProposalBC
 * @since J2EE 1.4
 */

public class SCGroupLocationProposalBCImpl extends BasicCommandSupport implements SCGroupLocationProposalBC {

	// Database Access Object
	private transient SCGroupLocationProposalDBDAO dbDao = null;

	/**
	 * Creating SCGroupLocationProposalBCImpl object<br>
	 * Creating SCGroupLocationProposalDBDAO<br>
	 */
	public SCGroupLocationProposalBCImpl() {
		dbDao = new SCGroupLocationProposalDBDAO();
	}
	
	/**
	 * Handling retrieving event for UI_PRI_0003_02<br>
	 * 
	 * @param priSpScpGrpLocDtlVO   PriSpScpGrpLocDtlVO
	 * @return List<PriSpScpGrpLocDtlVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchGroupLocationDetailList (PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO) throws EventException {
		try {
			return dbDao.searchGroupLocationDetailList (priSpScpGrpLocDtlVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Handling retrieving event for UI_PRI_0003_02
	 *  Handling retrieving event for  SCGroupLocationProposal screen<br>
	 * 
	 * @param priSpScpGrpLocVO   PriSpScpGrpLocVO
	 * @return List<PriSpScpGrpLocVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationList (PriSpScpGrpLocVO priSpScpGrpLocVO) throws EventException {
		try {
			return dbDao.searchGroupLocationList (priSpScpGrpLocVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Handling retrieving event
	 * Handling retrieving event for SCGroupLocationProposal screen<br>
	 * 
	 * @param PriSpScpGrpLocVO[] priSpScpGrpLocVOs
	 * @return List<PriSpScpGrpLocVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationRateApplyList (PriSpScpGrpLocVO[] priSpScpGrpLocVOs) throws EventException {
		try {
			PriSpScpGrpLocVO vo = new PriSpScpGrpLocVO();
			vo.setPropNo(priSpScpGrpLocVOs[0].getPropNo());
			vo.setAmdtSeq(priSpScpGrpLocVOs[0].getAmdtSeq());
			vo.setSvcScpCd(priSpScpGrpLocVOs[0].getSvcScpCd());
			List<String> txtArr = new ArrayList<String>();
			for(int i=0;i<priSpScpGrpLocVOs.length;i++){
				txtArr.add(priSpScpGrpLocVOs[i].getGrpLocSeq());
			}
			return dbDao.searchGroupLocationRateApplyList (vo, txtArr);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Handling retrieving event
	 * Handling retrieving event for  SCGroupLocationProposal screen<br>
	 * 
	 * @param PriSpScpGrpLocVO[] priSpScpGrpLocVOs
	 * @return List<PriSpScpGrpLocVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationRateAcceptedList (PriSpScpGrpLocVO[] priSpScpGrpLocVOs) throws EventException {
		try {
			PriSpScpGrpLocVO vo = new PriSpScpGrpLocVO();
			vo.setPropNo(priSpScpGrpLocVOs[0].getPropNo());
			vo.setAmdtSeq(priSpScpGrpLocVOs[0].getAmdtSeq());
			vo.setSvcScpCd(priSpScpGrpLocVOs[0].getSvcScpCd());
			List<String> txtArr = new ArrayList<String>();
			for(int i=0;i<priSpScpGrpLocVOs.length;i++){
				txtArr.add(priSpScpGrpLocVOs[i].getGrpLocSeq());
			}
			return dbDao.searchGroupLocationRateAcceptedList (vo, txtArr);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}	

	/**
	 * Handling multi event for UI_PRI_0003_02<br>
	 * Handling multi event for G/L Copy<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyGuidelineGroupLocation(PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO, SignOnUserAccount account) throws EventException{
		try {
			List<PriSpScpGrpLocDtlVO> insertVoList = new ArrayList<PriSpScpGrpLocDtlVO>();
			priSpScpGrpLocDtlVO.setCreUsrId(account.getUsr_id());
			priSpScpGrpLocDtlVO.setUpdUsrId(account.getUsr_id());
			insertVoList.add(priSpScpGrpLocDtlVO);
			if ( insertVoList.size() > 0 ) {
				dbDao.addProposalMainGroupLocationGlineCopy (insertVoList);
				dbDao.addProposalMainGroupLocationDetailGlineCopy (insertVoList);				
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
	 * Handling multi event for UI_PRI_0003_02<br>
	 * Handling saving event<br>
	 * 
	 * @param GrpLocPropVO grpLocPropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGroupLocation(GrpLocPropVO grpLocPropVO, SignOnUserAccount account) throws EventException{
		try {
			PriSpScpGrpLocVO[] vo = grpLocPropVO.getPrispscpgrplocvos();
			PriSpScpGrpLocDtlVO[] dtlvo = grpLocPropVO.getPrispscpgrplocdtlvos();
			
			List<PriSpScpGrpLocVO> insertVoList = new ArrayList<PriSpScpGrpLocVO>();
			List<PriSpScpGrpLocVO> updateVoList = new ArrayList<PriSpScpGrpLocVO>();
			List<PriSpScpGrpLocVO> deleteVoList = new ArrayList<PriSpScpGrpLocVO>();
			List<PriSpScpGrpLocDtlVO> insertDtlVoList = new ArrayList<PriSpScpGrpLocDtlVO>();
			List<PriSpScpGrpLocDtlVO> updateDtlVoList = new ArrayList<PriSpScpGrpLocDtlVO>();
			List<PriSpScpGrpLocDtlVO> deleteDtlVoList = new ArrayList<PriSpScpGrpLocDtlVO>();			
			
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
				dbDao.removeAddedGroupLocationDtl(deleteVoList);
				dbDao.modifyDeleteGroupLocationDtl(deleteVoList);					
				dbDao.removeGroupLocation(deleteVoList);
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
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}

	/**
	 * Handling multi event for  UI_PRI_0003_02<br>
	 * Handling multi event for Accept All<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String acceptAllGroupLocation(PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO, SignOnUserAccount account) throws EventException{
		
		String result = "FAIL";
		
		try {
			priSpScpGrpLocDtlVO.setPrcProgStsCd("A");
			priSpScpGrpLocDtlVO.setAcptUsrId(account.getUsr_id());
			priSpScpGrpLocDtlVO.setAcptOfcCd(account.getOfc_cd());					
			priSpScpGrpLocDtlVO.setUpdUsrId(account.getUsr_id());
			int cnt = dbDao.searchGroupLocationDetailStatusList(priSpScpGrpLocDtlVO);

			if(cnt>0){
				dbDao.modifyAllGroupLocationDetail(priSpScpGrpLocDtlVO);	
				result = "OK";
			}
			
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
	 * Handling multi event for UI_PRI_0003_02<br>
	 * Handling multi event for Cancel All<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String cancelAllGroupLocation(PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO, SignOnUserAccount account) throws EventException{
	
		String result = "";
		
		try {
			priSpScpGrpLocDtlVO.setPrcProgStsCd("I");
			priSpScpGrpLocDtlVO.setAcptUsrId(account.getUsr_id());
			priSpScpGrpLocDtlVO.setAcptOfcCd(account.getOfc_cd());					
			priSpScpGrpLocDtlVO.setUpdUsrId(account.getUsr_id());
			int cnt = dbDao.searchGroupLocationDetailStatusList(priSpScpGrpLocDtlVO);

			if(cnt>0){
				dbDao.modifyAllGroupLocationDetail(priSpScpGrpLocDtlVO);	
				result = "OK";
			}
			
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
	 * Handling multi event for UI_PRI_0003_02<br>
	 * Handling multi event for Accept<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO[] vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptGroupLocation(PriSpScpGrpLocDtlVO[] vo, SignOnUserAccount account) throws EventException{
		try {

			List<PriSpScpGrpLocDtlVO> updateDtlVoList = new ArrayList<PriSpScpGrpLocDtlVO>();
			
			for ( int i = 0; vo != null && i < vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("U")){
					vo[i].setAcptUsrId(account.getUsr_id());
					vo[i].setAcptOfcCd(account.getOfc_cd());
					vo[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(vo[i]);
				}
			}
		
			if ( updateDtlVoList.size() > 0 ) {
				dbDao.modifyGroupLocationDetail(updateDtlVoList);
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
	 * Handling multi event for UI_PRI_0003_02<br>
	 * Handling multi event for cancel<br>
	 * 
	 * @param PriSpScpGrpLocDtlVO[] vo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGroupLocation(PriSpScpGrpLocDtlVO[] vo, SignOnUserAccount account) throws EventException{
		try {

			List<PriSpScpGrpLocDtlVO> updateDtlVoList = new ArrayList<PriSpScpGrpLocDtlVO>();
			
			for ( int i = 0; vo != null && i < vo.length; i++ ) {
				if ( vo[i].getIbflag().equals("U")){
					vo[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(vo[i]);
				}
			}
		
			if ( updateDtlVoList.size() > 0 ) {
				dbDao.modifyGroupLocationDetail(updateDtlVoList);
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
	 * Requesting amendment<br>
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

			dbDao.addGroupLocationAmend (insertVoList);
			dbDao.addGroupLocationDetailAmend (insertVoList);
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}	

    /**
     * Copying Proposal Scope Group Location information<br>
     * 
     * @param vo RsltPropCopyVO
     * @param account SignOnUserAccount
     * @exception EventException
     */
    public void copyProposalScopeLocation(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
            vo.setOfcCd(account.getOfc_cd());
            // PRI_SP_SCP_GRP_LOC COPY
            dbDao.addCopyProposalScopeLocation(vo);
            // PRI_SP_SCP_GRP_LOC_DTL COPY
            dbDao.addCopyProposalScopeLocationDtl(vo);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }

    /**
     * Copying Guideline Location Group to Proposal<br>
     * 
     * @param vo SpScpGlineCopyVO
     * @param account SignOnUserAccount
     * @exception EventException
     */
    public void copyScopeGuidelineGrpLoc(SpScpGlineCopyVO vo, SignOnUserAccount account) throws EventException{
        try {
            vo.setCreUsrId(account.getUsr_id());
            vo.setUpdUsrId(account.getUsr_id());
//            vo.setOfcCd(account.getOfc_cd());
            // PRI_SP_SCP_GRP_LOC COPY
            dbDao.addCopyScopeGuidelineGrpLoc(vo);
            // PRI_SP_SCP_GRP_LOC_DTL COPY
            dbDao.addCopyScopeGuidelineGrpLocDtl(vo);
        } catch (DAOException ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            //log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
 
//	/**
//	 * Modifying N1_cmnc_dt  - in case that filing data is later when proposaling and filing<br>
//	 * 
//	 * @param priSpScpDurVO PriSpScpDurVO
//	 * @return 
//	 * @exception EventException
//	 */
//	public void manageProposalTerms(PriSpScpDurVO priSpScpDurVO, SignOnUserAccount account) throws EventException{
//		try {
//
//			if (priSpScpDurVO != null  ) {
//				priSpScpDurVO.setUpdUsrId(account.getUsr_id());					
//			}
//
//			dbDao.modifyProposalTerms (priSpScpDurVO);
//
//
//		} catch (DAOException de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		} catch (Exception de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//	}	
	
	/**
	 * handling deletion event for SCOPE <br>
	 * Deleting all data by scope<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriSpScpMnVO priSpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalGrpLocDtl(priSpScpMnVO);
			dbDao.removeProposalGrpLoc(priSpScpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00202",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00202",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Modifying accepted data to "init" when canceling Request<br>
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
	 * Retrieving Location Group History Detail information.<br>
	 * 
	 * @param priSpScpGrpLocDtlVO   PriSpScpGrpLocDtlVO
	 * @return List<PriSpScpGrpLocDtlVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchGroupLocationDetailHistoryList (PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO) throws EventException {
		try {
			return dbDao.searchGroupLocationDetailHistoryList (priSpScpGrpLocDtlVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Location Group History information<br>
	 * 
	 * @param priSpScpGrpLocVO   PriSpScpGrpLocVO
	 * @return List<PriSpScpGrpLocVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationHistoryList (PriSpScpGrpLocVO priSpScpGrpLocVO) throws EventException {
		try {
			return dbDao.searchGroupLocationHistoryList (priSpScpGrpLocVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Location Group History Detail information<br>
	 * 
	 * @param priSpScpGrpLocDtlVO   PriSpScpGrpLocDtlVO
	 * @return List<PriSpScpGrpLocDtlVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchGroupLocationDetailInquiryList (PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO) throws EventException {
		try {
			return dbDao.searchGroupLocationDetailInquiryList (priSpScpGrpLocDtlVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Location Group History information<br>
	 * 
	 * @param priSpScpGrpLocVO   PriSpScpGrpLocVO
	 * @return List<PriSpScpGrpLocVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationInquiryList (PriSpScpGrpLocVO priSpScpGrpLocVO) throws EventException {
		try {
			return dbDao.searchGroupLocationInquiryList (priSpScpGrpLocVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
	
	
}