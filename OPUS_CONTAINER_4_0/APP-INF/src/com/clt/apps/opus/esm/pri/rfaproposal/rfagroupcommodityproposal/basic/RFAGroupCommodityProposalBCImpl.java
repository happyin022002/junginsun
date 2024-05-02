/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFAGroupCommodityProposalBCImpl.java
*@FileTitle : S/C Commodity Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.integration.RFAGroupCommodityProposalDBDAO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.vo.GrpCmdtPropVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.vo.RsltGrpCmdtDtlListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.vo.RsltGrpCmdtListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
//import com.clt.apps.opus.esm.pri.rfaquotation.rfaquotationmain.vo.RsltCopyToProposalVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRpMnVO;
import com.clt.syscommon.common.table.PriRpScpGrpCmdtDtlVO;
import com.clt.syscommon.common.table.PriRpScpGrpCmdtVO;
import com.clt.syscommon.common.table.PriRpScpMnVO;

/**
 * SCProposal Business Logic Basic Command implementation<br>
 * - Handling a biz logic about SCProposal<br>
 *
 * @author 
 * @see ESM_PRI_0003_03EventResponse,RFAGroupCommodityProposalBC - Refer to each DAO class
 * @since J2EE 1.6
 */
public class RFAGroupCommodityProposalBCImpl extends BasicCommandSupport implements RFAGroupCommodityProposalBC {

	// Database Access Object
	private transient RFAGroupCommodityProposalDBDAO dbDao = null;

	/**
	 * Creating RFAGroupCommodityProposalBCImpl object<br>
	 * Creating RFAGroupCommodityProposalDBDAO<br>
	 */
	public RFAGroupCommodityProposalBCImpl() {
		dbDao = new RFAGroupCommodityProposalDBDAO();
	}
		
	/**
	 * Retrieving RFA PROPOSAL COMMODITY GROUP DETAIL information<br>
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
	 * Retrieving RFA PROPOSAL COMMODITY GROUP MASTER <br>
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
	 * Retrieving GRI COMMODITY GROUP & GRP COMMODITY GROUP<br>
	 * Prohibiting from deleting in case that datas exist in above two table before deleting<br>
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
	 * Copying RFA GUIDELINE의 COMMODITY GROUP Information<br>
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
	 * Saving RFA PROPOSAL COMMODITY GROUP Information.<br>
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
				// In case of Proposal 
				if(deleteVoList.get(0).getAmdtSeq().equals("0")){
					dbDao.removeMasterGroupCommodityDetail(deleteVoList);
					
					dbDao.removeMasterGroupCommodity(deleteVoList);				
				}else{
					// In case of Amend
					// Deleting I,NW about related Cmdt_seq
					// update sts = A, src_info = AD					
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
	 * Accepting all RFA PROPOSAL COMMODITY GROUP DETAIL Information<br>
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
	 * Cancelling all acceptance of RFA PROPOSAL COMMODITY GROUP DETAIL Information<br>
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
	 * Accepting RFA PROPOSAL COMMODITY GROUP DETAIL Information<br>
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
	 * Cancelling RFA PROPOSAL COMMODITY GROUP DETAIL Information's Acceptance<br>
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
	 * Amending RFA PROPOSAL COMMODITY GROUP DETAIL Information<br>
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
// pri_rp_scp_grp_cmdt creation
// pri_rp_scp_grp_cmdt_dtl creation
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
     * Copying RFA Proposal Scope Group Commodity Information<br>
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
	 * Changing Accepted datas of Main duration to "Init" when Cancelling request<br>
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
	 * Deleting all data of related Amend Seq No when cancelling "Init" status of Main<br>
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
	 * Retrieving RFA PROPOSAL COMMODITY GROUP DETAIL Information<br>
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
	 * Retrieving RFA PROPOSAL COMMODITY GROUP MASTER Information<br>
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
	 * Retrieving RFA PROPOSAL COMMODITY GROUP DETAIL Information<br>
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
	 * Retrieving RFA PROPOSAL COMMODITY GROUP MASTER Information<br>
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
     * Copying Guideline Commodity Group to Proposal<br>
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
    
}