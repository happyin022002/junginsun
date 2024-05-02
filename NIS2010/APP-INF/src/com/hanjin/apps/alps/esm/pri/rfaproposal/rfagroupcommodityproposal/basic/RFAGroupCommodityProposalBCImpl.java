/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupCommodityProposalBCImpl.java
*@FileTitle : S/C Commodity Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.05.25 최성민
* 1.0 Creation
=========================================================
* History
* 2015.10.28 SELCMU/김현경 [CHM-201538236] RFA module 승인 절차 간소화 및 기능 개선
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.integration.RFAGroupCommodityProposalDBDAO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.vo.GrpCmdtPropVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.vo.RsltGrpCmdtDtlListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfagroupcommodityproposal.vo.RsltGrpCmdtListVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToProposalVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriRpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpGrpCmdtDtlVO;
import com.hanjin.syscommon.common.table.PriRpScpGrpCmdtVO;
import com.hanjin.syscommon.common.table.PriRpScpMnVO;
import com.hanjin.syscommon.common.table.PriRpScpRtCmdtHdrVO;

/**
 * NIS2010-SCProposal Business Logic Basic Command implementation<br>
 * - NIS2010-SCProposal에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_0003_03EventResponse,RFAGroupCommodityProposalBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class RFAGroupCommodityProposalBCImpl extends BasicCommandSupport implements RFAGroupCommodityProposalBC {

	// Database Access Object
	private transient RFAGroupCommodityProposalDBDAO dbDao = null;

	/**
	 * RFAGroupCommodityProposalBCImpl 객체 생성<br>
	 * RFAGroupCommodityProposalDBDAO를 생성한다.<br>
	 */
	public RFAGroupCommodityProposalBCImpl() {
		dbDao = new RFAGroupCommodityProposalDBDAO();
	}
		
	/**
	 * RFA PROPOSAL COMMODITY GROUP DETAIL 정보를 조회한다.<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO  
	 * @return List<PriRpScpGrpCmdtDtlVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtDtlListVO> searchGroupCommodityDetailList(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO) throws EventException {
		try {
			return dbDao.searchGroupCommodityDetailList(priRpScpGrpCmdtDtlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * RFA PROPOSAL COMMODITY GROUP MASTER 정보를 조회한다.<br>
	 * 
	 * @param PriRpScpGrpCmdtVO priRpScpGrpCmdtVO  
	 * @return List<PriRpScpGrpCmdtVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityList(PriRpScpGrpCmdtVO priRpScpGrpCmdtVO) throws EventException {
		try {
			return dbDao.searchGroupCommodityList(priRpScpGrpCmdtVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * GRI COMMODITY GROUP & GRP COMMODITY GROUP에서 사용중인 데이터를 조회한다. <br>
	 * 삭제하기전에 위 2개의 테이블에 데이터가 존재하면 삭제불가<br>
	 * 
	 * @param PriRpScpGrpCmdtVO[] priRpScpGrpCmdtVOs  
	 * @return List<RsltGrpCmdtListVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityRateApplyList(PriRpScpGrpCmdtVO[] priRpScpGrpCmdtVOs) throws EventException {
		try {
			PriRpScpGrpCmdtVO vo = new PriRpScpGrpCmdtVO();
			vo.setPropNo(priRpScpGrpCmdtVOs[0].getPropNo());
			vo.setAmdtSeq(priRpScpGrpCmdtVOs[0].getAmdtSeq());
			vo.setSvcScpCd(priRpScpGrpCmdtVOs[0].getSvcScpCd());
			List<String> txtArr = new ArrayList<String>();
			for(int i=0;i<priRpScpGrpCmdtVOs.length;i++){
				txtArr.add(priRpScpGrpCmdtVOs[i].getGrpCmdtSeq());
			}
			return dbDao.searchGroupCommodityRateApplyList (vo, txtArr);			

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * RFA GUIDELINE의 COMMODITY GROUP 정보를 COPY한다.<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int copyGuidelineGroupCommodity(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO, SignOnUserAccount account) throws EventException{
		try {	
			int result = 0;
			priRpScpGrpCmdtDtlVO.setCreUsrId(account.getUsr_id());
			priRpScpGrpCmdtDtlVO.setUpdUsrId(account.getUsr_id());
			if ( priRpScpGrpCmdtDtlVO != null ) {
				result = dbDao.addProposalMainGroupCommodityGlineCopy (priRpScpGrpCmdtDtlVO);
				dbDao.addProposalMainGroupCommodityDetailGlineCopy (priRpScpGrpCmdtDtlVO);			
			}			
			return result;			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * RFA PROPOSAL COMMODITY GROUP 정보를 저장한다.<br>
	 * 
	 * @param GrpCmdtPropVO grpCmdtPropVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageGroupCommodity(GrpCmdtPropVO grpCmdtPropVO, SignOnUserAccount account) throws EventException{
		try {
			PriRpScpGrpCmdtVO[] vo = grpCmdtPropVO.getPriRpScpGrpCmdtVOs();
			PriRpScpGrpCmdtDtlVO[] dtlvo = grpCmdtPropVO.getPriRpScpGrpCmdtDtlVOs();
			
			List<PriRpScpGrpCmdtVO> insertVoList = new ArrayList<PriRpScpGrpCmdtVO>();
			List<PriRpScpGrpCmdtVO> updateVoList = new ArrayList<PriRpScpGrpCmdtVO>();
			List<PriRpScpGrpCmdtVO> deleteVoList = new ArrayList<PriRpScpGrpCmdtVO>();
			List<PriRpScpGrpCmdtDtlVO> insertDtlVoList = new ArrayList<PriRpScpGrpCmdtDtlVO>();
			List<PriRpScpGrpCmdtDtlVO> updateDtlVoList = new ArrayList<PriRpScpGrpCmdtDtlVO>();
			List<PriRpScpGrpCmdtDtlVO> deleteDtlVoList = new ArrayList<PriRpScpGrpCmdtDtlVO>();			
			
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
				dbDao.addGroupCommodity(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyGroupCommodity(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				// Proposal 일 경우
				if(deleteVoList.get(0).getAmdtSeq().equals("0")){
					dbDao.removeMasterGroupCommodityDetail(deleteVoList);
					
					dbDao.removeMasterGroupCommodity(deleteVoList);				
				}else{
					// Amend 일 경우
					// 대상 Cmdt_seq 에 대해서 I, NW 인 녀석 삭제
					// sts = A, src_info = AD 로 업데이트						
					dbDao.removeMasterGroupCommodityAmend(deleteVoList);
										
					dbDao.modifyMasterGroupCommodity(deleteVoList);
					
					dbDao.removeMasterGroupCommodity(deleteVoList);
				}
			}
			if ( insertDtlVoList.size() > 0 ) {
				dbDao.addGroupCommodityDetail(insertDtlVoList);
			}
			
			if ( updateDtlVoList.size() > 0 ) {
				dbDao.modifyGroupCommodityDetail(updateDtlVoList);
			}
			
			if ( deleteDtlVoList.size() > 0 ) {
				dbDao.removeGroupCommodityDetail(deleteDtlVoList);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * RFA PROPOSAL COMMODITY GROUP DETAIL 정보를 ALL ACCEPT 한다.<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String acceptAllGroupCommodity(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO, SignOnUserAccount account) throws EventException{
		
		String result = "FAIL";
		
		try {
			priRpScpGrpCmdtDtlVO.setPrcProgStsCd("A");
			priRpScpGrpCmdtDtlVO.setAcptUsrId(account.getUsr_id());
			priRpScpGrpCmdtDtlVO.setAcptOfcCd(account.getOfc_cd());					
			priRpScpGrpCmdtDtlVO.setUpdUsrId(account.getUsr_id());
			int cnt = dbDao.searchGroupCommodityDetailStatusList(priRpScpGrpCmdtDtlVO);

			if(cnt>0){
				dbDao.modifyAllGroupCommodityDetail(priRpScpGrpCmdtDtlVO);	
				result = "OK";
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		
		return result;
	}

	/**
	 * RFA PROPOSAL COMMODITY GROUP DETAIL 정보를 ALL ACCEPT CANCEL 한다.<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String cancelAllGroupCommodity(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO, SignOnUserAccount account) throws EventException{
	
		String result = "";
		
		try {
			priRpScpGrpCmdtDtlVO.setPrcProgStsCd("I");
			priRpScpGrpCmdtDtlVO.setAcptUsrId(account.getUsr_id());
			priRpScpGrpCmdtDtlVO.setAcptOfcCd(account.getOfc_cd());					
			priRpScpGrpCmdtDtlVO.setUpdUsrId(account.getUsr_id());
			int cnt = dbDao.searchGroupCommodityDetailStatusList(priRpScpGrpCmdtDtlVO);

			if(cnt>0){
				dbDao.modifyAllGroupCommodityDetail(priRpScpGrpCmdtDtlVO);	
				result = "OK";
			}
			
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
		
		return result;
	}    

	/**
	 * RFA PROPOSAL COMMODITY GROUP DETAIL 정보를 ACCEPT 한다.<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO[] priRpScpGrpCmdtDtlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptGroupCommodity(PriRpScpGrpCmdtDtlVO[] priRpScpGrpCmdtDtlVOs, SignOnUserAccount account) throws EventException{
		try {

			List<PriRpScpGrpCmdtDtlVO> updateDtlVoList = new ArrayList<PriRpScpGrpCmdtDtlVO>();
			
			for ( int i = 0; priRpScpGrpCmdtDtlVOs != null && i < priRpScpGrpCmdtDtlVOs.length; i++ ) {
				if ( priRpScpGrpCmdtDtlVOs[i].getIbflag().equals("U")){
					priRpScpGrpCmdtDtlVOs[i].setAcptUsrId(account.getUsr_id());
					priRpScpGrpCmdtDtlVOs[i].setAcptOfcCd(account.getOfc_cd());
					priRpScpGrpCmdtDtlVOs[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(priRpScpGrpCmdtDtlVOs[i]);
				}
			}
		
			if ( updateDtlVoList.size() > 0 ) {
				dbDao.modifyGroupCommodityDetail(updateDtlVoList);
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
	 * RFA PROPOSAL COMMODITY GROUP DETAIL 정보를 ACCEPT CANCEL 한다.<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO[] priRpScpGrpCmdtDtlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelGroupCommodity(PriRpScpGrpCmdtDtlVO[] priRpScpGrpCmdtDtlVOs, SignOnUserAccount account) throws EventException{
		try {

			List<PriRpScpGrpCmdtDtlVO> updateDtlVoList = new ArrayList<PriRpScpGrpCmdtDtlVO>();
			
			for ( int i = 0; priRpScpGrpCmdtDtlVOs != null && i < priRpScpGrpCmdtDtlVOs.length; i++ ) {
				if ( priRpScpGrpCmdtDtlVOs[i].getIbflag().equals("U")){
					priRpScpGrpCmdtDtlVOs[i].setUpdUsrId(account.getUsr_id());
					updateDtlVoList.add(priRpScpGrpCmdtDtlVOs[i]);
				}
			}
		
			if ( updateDtlVoList.size() > 0 ) {
				dbDao.modifyGroupCommodityDetail(updateDtlVoList);
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
	 * RFA PROPOSAL COMMODITY GROUP DETAIL 정보를 AMEND 처리한다.<br>
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
// pri_rp_scp_grp_cmdt 생성
// pri_rp_scp_grp_cmdt_dtl 생성
			dbDao.addGroupCommodityAmend (insertVoList);
			dbDao.addGroupCommodityDetailAmend (insertVoList);
				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), de);
		}
	}

    /**
     * RFA Proposal Scope Group Commodity 정보를 Copy 합니다.<br>
     * 
     * @param RsltRfaPropCopyVO rsltRfaPropCopyVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalScopeCommodity(RsltRfaPropCopyVO rsltRfaPropCopyVO, SignOnUserAccount account) throws EventException{
        try {
        	rsltRfaPropCopyVO.setCreUsrId(account.getUsr_id());
        	rsltRfaPropCopyVO.setUpdUsrId(account.getUsr_id());
        	rsltRfaPropCopyVO.setOfcCd(account.getOfc_cd());
            // PRI_RP_SCP_GRP_CMDT COPY
            dbDao.addCopyProposalScopeCommodity(rsltRfaPropCopyVO);
            // PRI_RP_SCP_GRP_CMDT_DTL COPY
            dbDao.addCopyProposalScopeCommodityDtl(rsltRfaPropCopyVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
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
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * Main의 Init 상태를 Cancel시 해당 Amend Seq NO.의 모든 데이터를 삭제합니다.<br>
	 * 
	 * @param PriRpScpMnVO priRpScpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(PriRpScpMnVO priRpScpMnVO, SignOnUserAccount account) throws EventException{
		try {
			dbDao.removeProposalContent(priRpScpMnVO);
			dbDao.removeProposal(priRpScpMnVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
	}
 
	/**
	 * RFA PROPOSAL COMMODITY GROUP DETAIL 정보를 조회한다.<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO  
	 * @return List<PriRpScpGrpCmdtDtlVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtDtlListVO> searchGroupCommodityDetailHistoryList(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO) throws EventException {
		try {
			return dbDao.searchGroupCommodityDetailHistoryList(priRpScpGrpCmdtDtlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * RFA PROPOSAL COMMODITY GROUP MASTER 정보를 조회한다.<br>
	 * 
	 * @param PriRpScpGrpCmdtVO priRpScpGrpCmdtVO  
	 * @return List<PriRpScpGrpCmdtVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityHistoryList(PriRpScpGrpCmdtVO priRpScpGrpCmdtVO) throws EventException {
		try {
			return dbDao.searchGroupCommodityHistoryList(priRpScpGrpCmdtVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * RFA PROPOSAL COMMODITY GROUP DETAIL 정보를 조회한다.<br>
	 * 
	 * @param PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO  
	 * @return List<PriRpScpGrpCmdtDtlVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtDtlListVO> searchGroupCommodityDetailInquiryList(PriRpScpGrpCmdtDtlVO priRpScpGrpCmdtDtlVO) throws EventException {
		try {
			return dbDao.searchGroupCommodityDetailInquiryList(priRpScpGrpCmdtDtlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * RFA PROPOSAL COMMODITY GROUP MASTER 정보를 조회한다.<br>
	 * 
	 * @param PriRpScpGrpCmdtVO priRpScpGrpCmdtVO  
	 * @return List<PriRpScpGrpCmdtVO>
	 * @exception EventException
	 */
	public List<RsltGrpCmdtListVO> searchGroupCommodityInquiryList(PriRpScpGrpCmdtVO priRpScpGrpCmdtVO) throws EventException {
		try {
			return dbDao.searchGroupCommodityInquiryList(priRpScpGrpCmdtVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

    /**
     * Guideline Commodity Group 을 Proposal 로 Copy 합니다.<br>
     * 
     * @param RpScpGlineCopyVO rpScpGlineCopyVO
	 * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyScopeGuidelineGrpCmdt (RpScpGlineCopyVO rpScpGlineCopyVO, SignOnUserAccount account) throws EventException{
        try {
        	rpScpGlineCopyVO.setCreUsrId(account.getUsr_id());
        	rpScpGlineCopyVO.setUpdUsrId(account.getUsr_id());
            // PRI_RP_SCP_GRP_CMDT COPY
            dbDao.addCopyScopeGuidelineGrpCmdt(rpScpGlineCopyVO);
            // PRI_RP_SCP_GRP_CMDT_DTL COPY
            dbDao.addCopyScopeGuidelineGrpCmdtDtl(rpScpGlineCopyVO);
        } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        } catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
    }
    
    
    /**
     * PRS 정보를 Copy 하여 PriRpScpGrpCmdt 정보를 생성합니다.<br>
     * 
     * @param RsltCopyToProposalVO rsltCopyToProposalVO
	 * @param SignOnUserAccount account
     * @throws DAOException
     */
    public void copyToProposalCommodity (RsltCopyToProposalVO rsltCopyToProposalVO, SignOnUserAccount account) throws EventException{
       try {
    	   	rsltCopyToProposalVO.setCreUsrId(account.getUsr_id());
    	   	rsltCopyToProposalVO.setUpdUsrId(account.getUsr_id());
			//office
    	   	rsltCopyToProposalVO.setQttnOfcCd(account.getOfc_cd());
			
			//PRI_SP_SCP_CMDT
			dbDao.addCopyRfaQuotationPriRpScpGrpCmdt(rsltCopyToProposalVO);
			//PRI_SP_SCP_CMDT_DTL
			dbDao.addCopyRfaQuotationPriRpScpGrpCmdtDtl(rsltCopyToProposalVO);
       } catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
       } catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
       }
    }

    /**
     * Summary 팝업에서 승인 대상인 모든 Service Scope Commodity 변경 리스트를 조회한다.<br>
     * 
     * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
     * @return List<RsltGrpCmdtDtlListVO>
     * @throws EventException
     */
	public List<RsltGrpCmdtDtlListVO> searchAllGroupCommodityList(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) throws EventException {
		try {
			return dbDao.searchAllGroupCommodityList(priRpScpRtCmdtHdrVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
}