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
* 2012.02.23 이석준[CHM-201216153-01] S/C Amendment History 화면 기능 개선 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.integration.SCGroupLocationProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.vo.GrpLocPropVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.vo.RsltGrpLocDtlListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scgrouplocationproposal.vo.RsltGrpLocListVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.SpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.scquotation.scquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriSpMnVO;
import com.hanjin.syscommon.common.table.PriSpScpGrpLocDtlVO;
import com.hanjin.syscommon.common.table.PriSpScpGrpLocVO;
import com.hanjin.syscommon.common.table.PriSpScpMnVO;
import com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo.PriSpHistoryInquiryParamVO;

/**
 * NIS2010-SCProposal Business Logic Basic Command implementation<br>
 * - NIS2010-SCProposal에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Byeon Young Joo
 * @see ESM_PRI_0003_02EventResponse,SCGroupLocationProposalBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */ 

public class SCGroupLocationProposalBCImpl extends BasicCommandSupport implements SCGroupLocationProposalBC {

	// Database Access Object
	private transient SCGroupLocationProposalDBDAO dbDao = null;

	/**
	 * SCGroupLocationProposalBCImpl 객체 생성<br>
	 * SCGroupLocationProposalDBDAO를 생성한다.<br>
	 */
	public SCGroupLocationProposalBCImpl() {
		dbDao = new SCGroupLocationProposalDBDAO();
	}
	 
	/**
	 * UI_PRI_0003_02조회 이벤트 처리<br>
	 *  SCGroupLocationProposal화면에 대한 조회 이벤트 처리<br>
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
	 * UI_PRI_0003_02조회 이벤트 처리
	 *  SCGroupLocationProposal화면에 대한 조회 이벤트 처리<br>
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
	 * 조회 이벤트 처리
	 *  SCGroupLocationProposal화면에 대한 조회 이벤트 처리<br>
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
	 * 조회 이벤트 처리
	 *  SCGroupLocationProposal화면에 대한 조회 이벤트 처리<br>
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
	 * UI_PRI_0003_02 멀티 이벤트 처리<br>
	 * G/L Copy 에 대한 멀티 이벤트 처리<br>
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
	 * UI_PRI_0003_02멀티 이벤트 처리<br>
	 * Save에 대한 멀티 이벤트 처리<br>
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
	 * UI_PRI_0003_02 멀티 이벤트 처리<br>
	 * Accept All에 대한 멀티 이벤트 처리<br>
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
	 * UI_PRI_0003_02 멀티 이벤트 처리<br>
	 * Cancel All 에 대한 멀티 이벤트 처리<br>
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
	 * UI_PRI_0003_02 멀티 이벤트 처리<br>
	 * Accept 에 대한 멀티 이벤트 처리<br>
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
	 * UI_PRI_0003_02 멀티 이벤트 처리<br>
	 * cancel에 대한 멀티 이벤트 처리<br>
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
	 * Amend Request를 처리합니다.<br>
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
     * Proposal Scope Group Location 정보를 Copy 합니다.<br>
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
     * Guideline Location Group 을 Proposal 로 Copy 합니다.<br>
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
//	 * 멀티 이벤트 처리<br>
//	 * N1_cmnc_dt 변경 - Proposal이거나 Filing시 filing Date가 더 늦을 경우 변경<br>
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
	 * SCOPE 삭제 이벤트 처리<br>
	 * SCOPE에 해당하는 모든 데이터를 삭제처리한다.<br>
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
	 * Request Cancel시 Accepted 데이터를 일괄 Init 으로 변경합니다.<br>
	 * 
	 * @param PriSpScpMnVO priSpScpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpScpMnVO priSpScpMnVO,SignOnUserAccount account) throws EventException{
		try {
			if (priSpScpMnVO != null  ) {
				priSpScpMnVO.setUpdUsrId(account.getUsr_id());					
			}
			dbDao.modifyProposalRequestCancel(priSpScpMnVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Location Group History Detail 정보를 조회한다.<br>
	 * 
	 * @param priSpScpGrpLocDtlVO   PriSpScpGrpLocDtlVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<PriSpScpGrpLocDtlVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocDtlListVO> searchGroupLocationDetailHistoryList (PriSpScpGrpLocDtlVO priSpScpGrpLocDtlVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException {
		try {
			return dbDao.searchGroupLocationDetailHistoryList (priSpScpGrpLocDtlVO,priSpHistoryInquiryParamVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Location Group History 정보를 조회한다.<br>
	 * 
	 * @param priSpScpGrpLocVO   PriSpScpGrpLocVO
	 * @param PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO
	 * @return List<PriSpScpGrpLocVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchGroupLocationHistoryList (PriSpScpGrpLocVO priSpScpGrpLocVO,PriSpHistoryInquiryParamVO priSpHistoryInquiryParamVO) throws EventException {
		try {
			return dbDao.searchGroupLocationHistoryList (priSpScpGrpLocVO,priSpHistoryInquiryParamVO);
		} catch (DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Location Group History Detail 정보를 조회한다.<br>
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
	 * Location Group History 정보를 조회한다.<br>
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
	
	/**
	 * Quotation 에서 proposal로 데이터를 copy한다.<br>
	 * COPY TO PROPOSAL 대상테이블 : PRI_SP_SCP_CMDT, PRI_SP_SCP_CMDT_DTL <br>
	 * 
	 * @param RsltCopyToProposalVO rsltCopyToProposalVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyToProposalLoc(RsltCopyToProposalVO rsltCopyToProposalVO, SignOnUserAccount account) 
		throws EventException{
		try {
			rsltCopyToProposalVO.setCreUsrId(account.getUsr_id());
			rsltCopyToProposalVO.setUpdUsrId(account.getUsr_id());
			//office
			rsltCopyToProposalVO.setQttnOfcCd(account.getOfc_cd());
			
			//PRI_SP_SCP_CMDT
			dbDao.addCopyToProposalSpScpGrpLoc(rsltCopyToProposalVO);
			//PRI_SP_SCP_CMDT_DTL
			dbDao.addCopyToProposalSpScpGrpLocDtl(rsltCopyToProposalVO);
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}
	
}