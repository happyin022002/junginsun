/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCGroupLocationProposalBCImpl.java
*@FileTitle : S/C Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 변영주
*@LastVersion : 1.0
* 2009.05.06 변영주
* 1.0 Creation
* =========================================================
* History
* 2015.10.28 SELCMU/김현경 [CHM-201538236] RFA module 승인 절차 간소화 및 기능 개선
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.integration.RFAGroupLocationProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.vo.GrpLocPropVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.vo.RsltGrpLocDtlListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagrouplocationproposal.vo.RsltGrpLocListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriRpScpGrpLocVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;

/**
 * NIS2010-SCProposal Business Logic Basic Command implementation<br>
 * - NIS2010-SCProposal에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0003_02EventResponse,SCGroupLocationProposalBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class RFAGroupLocationProposalBCImpl extends BasicCommandSupport implements RFAGroupLocationProposalBC {

	// Database Access Object
	private transient RFAGroupLocationProposalDBDAO dbDao = null;

	/**
	 * SCGroupLocationProposalBCImpl 객체 생성<br>
	 * SCGroupLocationProposalDBDAO를 생성한다.<br>
	 */
	public RFAGroupLocationProposalBCImpl() {
		dbDao = new RFAGroupLocationProposalDBDAO();
	}
	
	/**
	 * LOCATION GROUP DETAIL를 조회합니다.<br>
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
	 * LOCATION GROUP MASTER를 조회합니다.<br>
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
	 * RATE에서의 사용유무를 조회합니다.<br>
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
	 * GUIDELINE LOCATION GROUP을 COPY합니다.<br>
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
	 * LOCATION GROUP을 저장합니다.<br>
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
				// Proposal 일 경우
				if(deleteVoList.get(0).getAmdtSeq().equals("0")){
					dbDao.removeMasterGroupLocationDetail(deleteVoList);
					
					dbDao.removeMasterGroupLocation(deleteVoList);				
				}else{
					// Amend 일 경우
					// 대상 loc_seq 에 대해서 I, NW 인 녀석 삭제
					// sts = A, src_info = AD 로 업데이트		
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
	 * LOCATION GROUP을 ALL ACCEPT합니다.<br>
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
	 * LOCATION GROUP을 ALL CANCEL합니다.<br>
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
	 * LOCATION GROUP을 ACCEPT합니다.<br>
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
	 *  LOCATION GROUP을 CANCEL합니다.<br>
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
	 * LOCATION GROUP을 AMEND합니다.<br>
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
     * RFA Proposal Scope Group Location 을 Copy 합니다.<br>
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
     * GUIDELINE LOCATION GROUP을 PROPOSAL로 COPY합니다.<br>
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
	 * SCOPE에 해당하는 모든 데이터를 삭제처리한다.<br>
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
	 * Request Cancel시 Main Duration의 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
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
	 * LOCATION GROUP DETAIL를 조회합니다.<br>
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
	 * LOCATION GROUP MASTER를 조회합니다.<br>
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
	 * ORI/DEST TYPE의 선택유무를 체크한다.<br>
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
	 * LOCATION GROUP DETAIL를 조회합니다.<br>
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
	 * LOCATION GROUP MASTER를 조회합니다.<br>
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
	
	
	/**
     * PRS 정보를 Copy 하여 PriRpScpGrpLoc 정보를 생성합니다.<br>
     * 
     * @param RsltCopyToProposalVO rsltCopyToProposalVO
	 * @param SignOnUserAccount account
     * @throws DAOException
     */
    public void copyToProposalLocation (RsltCopyToProposalVO rsltCopyToProposalVO, SignOnUserAccount account) throws EventException{
       try {
    	   rsltCopyToProposalVO.setCreUsrId(account.getUsr_id());
    	   rsltCopyToProposalVO.setUpdUsrId(account.getUsr_id());
			//office
    	   rsltCopyToProposalVO.setQttnOfcCd(account.getOfc_cd());
			
			//PRI_SP_SCP_CMDT
			dbDao.addCopyRfaQuotationPriRpScpGrpLoc(rsltCopyToProposalVO);
			//PRI_SP_SCP_CMDT_DTL
			dbDao.addCopyRfaQuotationPriRpScpGrpLocDtl(rsltCopyToProposalVO);
       } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
       } catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
       }
    }
    
    /**
     * Summary 팝업에서 승인 대상인 모든 Service Scope Location 변경 리스트를 조회한다.<br>
     * 
     * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
     * @return List<RsltGrpLocDtlListVO>
     * @throws EventException
     */
	public List<RsltGrpLocDtlListVO> searchAllGroupLocationList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchAllGroupLocationList(priRpScpRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
}