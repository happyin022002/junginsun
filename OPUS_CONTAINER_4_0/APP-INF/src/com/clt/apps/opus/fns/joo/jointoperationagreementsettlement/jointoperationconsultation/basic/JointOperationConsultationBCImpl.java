/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationConsultationBCImpl.java
*@FileTitle : Tax Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.basic;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration.JointOperationConsultationDBDAO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CmbConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CombinedGrpVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CombinedVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CsrSlipVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CsrVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.LostCombinedDataVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipProcessVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.TaxVO;
import com.clt.apps.opus.fns.joo.joocommonutil.BizComJooUtil;
import com.clt.apps.opus.fns.joo.joocommonutil.JooConstants;
import com.clt.bizcommon.approval.util.ApprovalUtil;
import com.clt.framework.component.backend.support.BackEndJobException;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ComAproCsrDtlVO;
import com.clt.syscommon.common.table.ComAproRqstHdrVO;
import com.clt.syscommon.common.table.ComAproRqstRoutVO;
import com.clt.syscommon.common.table.JooSettlementVO;
import com.clt.syscommon.common.table.JooSlipVO;
import com.clt.syscommon.common.table.JooStlCmbDtlVO;
import com.clt.syscommon.common.table.JooStlCmbVO;
import com.clt.syscommon.common.table.JooTaxDtlVO;
import com.clt.syscommon.common.table.JooTaxVO;


/**
 * OPUS-JointOperationAgreementSettlement Business Logic Basic Command implementation<br>
 * - OPUS-JointOperationAgreementSettlement: handling business logic<br>
 *
 * @author
 * @see FNS_JOO_0044EventResponse,JointOperationConsultationBC DAO class
 * @since J2EE 1.4
 */

public class JointOperationConsultationBCImpl extends BasicCommandSupport implements JointOperationConsultationBC {

	// Database Access Object
	private transient JointOperationConsultationDBDAO dbDao = null;
	//private transient JointOperationConsultationEAIDAO eaiDao = null;

	/**
	 * JointOperationConsultationBCImpl object creation<br>
	 * JointOperationConsultationDBDAO creation<br>
	 */
	public JointOperationConsultationBCImpl() {
		dbDao = new JointOperationConsultationDBDAO();
		//eaiDao = new JointOperationConsultationEAIDAO();
	}

	/**
	 * retrieving Tax
	 * @param String taxInvYrmonFr
	 * @param String taxInvYrmonTo
	 * @return List<TaxVO>
	 * @throws EventException
	 */
	public List<TaxVO> searchTaxList(String taxInvYrmonFr, String taxInvYrmonTo) throws EventException {
		try {
			return dbDao.searchTaxList(taxInvYrmonFr, taxInvYrmonTo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Tax", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Tax", "Retrieve"}).getMessage(), ex);
		}
	}

//	/**
//	 * 
//	 * @param String erpIfFlg
//	 * @param String dtFlg
//	 * @param String fmDt
//	 * @param String toDt
//	 * @return List<ErpIfVO>
//	 * @throws EventException
//	 */
//	public List<ErpIfVO> searchARERPInterfaceList(String erpIfFlg, String dtFlg, String fmDt, String toDt) throws EventException {
//		try {
//			return dbDao.searchARERPInterfaceList(erpIfFlg, dtFlg, fmDt, toDt);
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AR ERP Interface data", "Retrieve"}).getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AR ERP Interface data", "Retrieve"}).getMessage(), ex);
//		}
//	}

//	/**
//	 * 
//	 * @param String erpIfFlg
//	 * @param String dtFlg
//	 * @param String fmDt
//	 * @param String toDt
//	 * @return List<ErpIfVO>
//	 * @throws EventException
//	 */
//	public List<ErpIfVO> searchAPERPInterfaceList(String erpIfFlg, String dtFlg, String fmDt, String toDt) throws EventException {
//		try {
//			return dbDao.searchAPERPInterfaceList(erpIfFlg, dtFlg, fmDt, toDt);
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AP ERP Interface data", "Retrieve"}).getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AP ERP Interface data", "Retrieve"}).getMessage(), ex);
//		}
//	} 
	
	/**
	 * retrieving Slip 
	 * @param SlipConditionVO slipConditionVO
	 * @return List<SlipVO>
	 * @throws EventException
	 */
	public List<SlipVO> searchDetailSlipList(SlipConditionVO slipConditionVO) throws EventException {
		try {
			return dbDao.searchDetailSlipList(slipConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Slip", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Slip", "Retrieve"}).getMessage(), ex);
		}
	} 

	/**
	 * retrieving CSR list to approve
	 * @param CsrVO csrVO
	 * @return List<CsrVO>
	 * @throws EventException
	 */
	public List<CsrVO> searchConsultationList(CsrVO csrVO) throws EventException {
		try {
			return dbDao.searchConsultationList(csrVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"The List for Approval", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"The List for Approval", "Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param CsrVO csrVO
	 * @return List<CsrVO>
	 * @throws EventException
	 */
	public List<CsrVO> searchDetailConsultation(CsrVO csrVO) throws EventException {
		try {
			return dbDao.searchDetailConsultation(csrVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"The Data for Approval", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"The Data for Approval", "Retrieve"}).getMessage(), ex);
		}
	}
	/**
	 * 
	 * @param CsrVO csrVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @throws EventException
	 */
	public String approvalConsultation(CsrVO csrVO, SignOnUserAccount signOnUserAccount) throws EventException{
        try {
    		JointOperationConsultationBackEndJob backEndResult = new JointOperationConsultationBackEndJob();
    		
    		//BackEndJobManager backEndJobManager = new BackEndJobManager();
    		backEndResult.setCsrVO(csrVO);
    		backEndResult.setSignOnUserAccount(signOnUserAccount);
    		
    		return backEndResult.doStart();
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"JOO Consultation", "Approval"}).getMessage(), ex);
        }
	}

	/**
	 * 
	 * @param CsrVO csrVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
//	public void approvalConsultation(CsrVO csrVO, SignOnUserAccount signOnUserAccount) throws EventException{
//		try {
//			csrVO.setUpdUsrId(signOnUserAccount.getUsr_id());
//
//			dbDao.modifyComAproRqstRout(csrVO);
//			dbDao.modifyComAproRqstHdr (csrVO);
//
//			if (!"Y".equals(csrVO.getCxlFlg()) && !"Y".equals(csrVO.getLstAproFlg())){
//				return;
//			}
//			
//			dbDao.modifyCsr(csrVO);
//
//			String csrNo = csrVO.getCsrNo();
//			
//			if ("Y".equals(csrVO.getAproFlg())){
//				if ("18".equals(csrNo.substring(0,2))){
//				
//					List<ArMnChgVO> list = dbDao.searchArInfoForApproval(csrVO);
//					
//					Iterator iterator = list.iterator();
//					
//					ArMnChgVO arMnChgVO = null;
//					
//					int seq = 0;
//					String arIfNo = "";
//					
//					boolean isFirst = true;
//					while(iterator.hasNext()){
//						arMnChgVO = (ArMnChgVO)iterator.next();
//						arMnChgVO.setUsrId(signOnUserAccount.getUsr_id());
//						
//						if (isFirst){
//							seq = Integer.parseInt(arMnChgVO.getArIfNo());
//							isFirst = false;
//						}
//						
//						seq++;
//						arIfNo = "JOO"+JSPUtil.getLPAD(seq+"", 7, "0");
//						arMnChgVO.setArIfNo(arIfNo);
//						dbDao.addJooArMn(arMnChgVO);
//						
//						dbDao.addJooArChg(arMnChgVO);
//					}
//					eaiDao.sendSlipApprovalToAR(csrNo, list);
//				}else{
//					List<InvHdrVO>  list  = dbDao.searchApHeaderInfoForApproval(csrVO);
//					List<InvDtrbVO> list1 = dbDao.searchApDetailInfoForApproval(csrVO);
//					
//					InvHdrVO invHdrVO = list.get(0);
//					invHdrVO.setCreUsrId(signOnUserAccount.getUsr_id());
//					
//					dbDao.addApInvHdr(invHdrVO);
//					
//
//					InvDtrbVO invDtrbVO = null;
//					InvIfVO invIfVO = null;
//					int totCnt = list1.size();
//
//					for (int i=0; i < list1.size(); i++){
//						invDtrbVO = list1.get(i);
//
//						invDtrbVO.setCreUsrId(signOnUserAccount.getUsr_id());
//						//AP_INV_DTRB��INSERT
//						dbDao.addApInvDtrb(invDtrbVO);
//						
//						invIfVO = new InvIfVO();
//						setInvIfVO(invIfVO, invHdrVO, invDtrbVO, totCnt, i+1);
//						//AP_INV_IF��INSERT
//						dbDao.addApInvIf(invIfVO);
//					}
//					
//					eaiDao.sendSlipApprovalToAP(csrNo, list, list1);
//				}
//			}
//			
//			if ("Y".equals(csrVO.getCxlFlg())){
//				dbDao.removeSlipByCsr          (csrVO);
//				dbDao.removeTaxByCsr           (csrVO);
//				dbDao.removeTaxDtlByCsr        (csrVO);
//				dbDao.modifyJooStlCmbClearCsrNo(csrVO);
//			}
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"CSR", "Approval"}).getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"CSR", "Approval"}).getMessage(), ex);
//		}
//	}
	
	/**
	 * 
	 * @param String csrNo
	 * @return TaxGrpVO
	 * @throws EventException
	 */
//	public TaxGrpVO searchAPEvidence(String csrNo) throws EventException {
//		TaxGrpVO grpVO = new TaxGrpVO();
//		try {
//			List<JooTaxVO>    jooTaxVOs    = dbDao.searchTaxMasterList(csrNo);
//			List<JooTaxDtlVO> jooTaxDtlVOs = null;
//
//			JooTaxVO jooTaxVO = null;
//			if (!jooTaxVOs.isEmpty())
//				jooTaxVO = jooTaxVOs.get(0);
//			
//			if (jooTaxVO!=null){
//				jooTaxDtlVOs = dbDao.searchTaxDetailList(jooTaxVO);
//			}
//			grpVO.setJooTaxVOs   (jooTaxVOs);
//			grpVO.setJooTaxDtlVOs(jooTaxDtlVOs);
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AP Evidence", "Retrieve"}).getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AP Evidence", "Retrieve"}).getMessage(), ex);
//		}
//		return grpVO;
//	}
	
	/**
	 * 
	 * @param String vndrSeq
	 * @return List<JooTaxVO>
	 * @throws EventException
	 */
//	public List<JooTaxVO> searchVendorInfo(String vndrSeq) throws EventException {
//		try {
//			return dbDao.searchVendorInfo(vndrSeq);
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Vendor Information", "Retrieve"}).getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Vendor Information", "Retrieve"}).getMessage(), ex);
//		}
//	}
	
	/**
	 * retrieving CSR list
	 * @param SlipConditionVO slipConditionVO
	 * @return List<CsrSlipVO>
	 * @throws EventException
	 */
	public List<CsrSlipVO> searchSlipList(SlipConditionVO slipConditionVO) throws EventException {
		try {
			return dbDao.searchSlipList(slipConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"CSR List", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"CSR List", "Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * retrieving office code of CSR
	 * @param SlipConditionVO slipConditionVO
	 * @return List<SlipConditionVO>
	 * @throws EventException
	 */
	public List<SlipConditionVO> searchCsrOfcList(SlipConditionVO slipConditionVO) throws EventException {
		try {
			return dbDao.searchCsrOfcList(slipConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"CSR Office Code List", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"CSR Office Code List", "Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * retrieving Lane List, Settlement list of combined settlement
	 * @param CmbConditionVO cmbConditionVO
	 * @return CombinedGrpVO
	 * @throws EventException
	 */
	public CombinedGrpVO searchCombinedMonthlyClearanceList(CmbConditionVO cmbConditionVO) throws EventException {
		CombinedGrpVO combinedGrpVO = new CombinedGrpVO();
		try {
			List<JooSettlementVO> list  = dbDao.searchCombinedRlaneList(cmbConditionVO);
			List<CombinedVO>      list1 = dbDao.searchCombinedMonthlyClearanceByLaneList(cmbConditionVO);
			combinedGrpVO.setJooSettlementVOs(list);
			combinedGrpVO.setCombinedVOs(list1);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"The Data for Combining", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"The Data for Combining", "Retrieve"}).getMessage(), ex);
		}
		return combinedGrpVO;
	}

	/**
	 * retrieving Lane List to combine
	 * @param CmbConditionVO cmbConditionVO
	 * @return List<JooSettlementVO>
	 * @throws EventException
	 */
	public List<JooSettlementVO> searchCombinedRlaneList(CmbConditionVO cmbConditionVO) throws EventException {
		try {
			return dbDao.searchCombinedRlaneList(cmbConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"The Data for Combining", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"The Data for Combining", "Retrieve"}).getMessage(), ex);
		}
	}
	
	/**
	 * retrieving settlement to combine in case of selecting multiple combined lane
	 * @param CmbConditionVO cmbConditionVO
	 * @return List<CombinedVO>
	 * @throws EventException
	 */
	public List<CombinedVO> searchCombinedMonthlyClearanceByLaneList (CmbConditionVO cmbConditionVO) throws EventException {
		try {
			return dbDao.searchCombinedMonthlyClearanceByLaneList (cmbConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"The Data for Combining", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"The Data for Combining", "Retrieve"}).getMessage(), ex);
		}
	}
	
	/**
	 * processing combining
	 * @param CmbConditionVO cmbConditionVO
	 * @param CombinedVO[] combinedVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return int
	 * @throws EventException
	 */
	public int manageCombinedMonthlyClearance(CmbConditionVO cmbConditionVO, CombinedVO[] combinedVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		int nextStlCmbSeq = 1;
		try {
			
			nextStlCmbSeq = dbDao.searchNextStlSeq(cmbConditionVO);
			
			
			JooStlCmbVO jooStlCmbVO = new JooStlCmbVO();

			jooStlCmbVO.setAcctYrmon(cmbConditionVO.getAcctYrmon());
			jooStlCmbVO.setJoCrrCd  (cmbConditionVO.getJoCrrCd  ());
			jooStlCmbVO.setStlCmbSeq(nextStlCmbSeq+"");
			jooStlCmbVO.setCreUsrId (signOnUserAccount.getUsr_id());
			jooStlCmbVO.setRvsCmbFlg("N");

			int eCnt = 0;
			int rCnt = 0;

			
			for(int i=0; i<combinedVOs.length; i++){
				if ("E".equals(combinedVOs[i].getReDivrCd()))
					eCnt++;

				if ("R".equals(combinedVOs[i].getReDivrCd()))
					rCnt++;
			}
			
			if (rCnt > 0){
				jooStlCmbVO.setReDivrCd("R");
				dbDao.addJooStlCmb(jooStlCmbVO);
			}
			
			if (eCnt > 0){
				jooStlCmbVO.setReDivrCd("E");
				dbDao.addJooStlCmb(jooStlCmbVO);
			}

			
			JooStlCmbDtlVO jooStlCmbDtlVO = new JooStlCmbDtlVO();
			
			for(int i=0; i<combinedVOs.length; i++){
				jooStlCmbDtlVO.setAcctYrmon(combinedVOs[i].getAcctYrmon());
				jooStlCmbDtlVO.setJoCrrCd  (combinedVOs[i].getJoCrrCd  ());
				jooStlCmbDtlVO.setStlCmbSeq(nextStlCmbSeq+"");
				jooStlCmbDtlVO.setReDivrCd (combinedVOs[i].getReDivrCd ());
				jooStlCmbDtlVO.setStlVvdSeq(combinedVOs[i].getStlVvdSeq());
				jooStlCmbDtlVO.setStlSeq   (combinedVOs[i].getStlSeq   ());
				jooStlCmbDtlVO.setCreUsrId (signOnUserAccount.getUsr_id());
				
				
				jooStlCmbDtlVO.setStlCmbSeq(nextStlCmbSeq+"");
				jooStlCmbDtlVO.setCreUsrId(signOnUserAccount.getUsr_id());

				
				dbDao.addJooStlCmbDtlSkipForDup(jooStlCmbDtlVO);
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Combining", "Processing"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Combining", "Processing"}).getMessage(), ex);
		}
		
		return nextStlCmbSeq;
	}

	/**
	 * canceling combined settlement information
	 * @param CmbConditionVO cmbConditionVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void removeCombinedMonthlyClearance(CmbConditionVO cmbConditionVO, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			
			dbDao.removeJooStlCmbDtlS(cmbConditionVO);

			
			dbDao.removeJooStlCmbS(cmbConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Combining", "Cancelation"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Combining", "Cancelation"}).getMessage(), ex);
		}
	}

	/**
	 * retrieving AP CSR
	 * @param SlipProcessVO slipProcessVO
	 * @return List<SlipProcessVO>
	 * @throws EventException
	 */
	public List<SlipProcessVO> searchAPConsultation(SlipProcessVO slipProcessVO) throws EventException {
		try {
			return dbDao.searchAPConsultation (slipProcessVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AP CSR Information", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AP CSR Information", "Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * creating AP CSR
	 * @param SlipProcessVO[] slipProcessVOs
	 * @param JooTaxVO[] jooTaxVOs
	 * @param JooTaxDtlVO[] jooTaxDtlVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @throws EventException
	 */
	public String createAPConsultation(SlipProcessVO[] slipProcessVOs, JooTaxVO[] jooTaxVOs, JooTaxDtlVO[] jooTaxDtlVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		String csrNo = "";
		String slpSerNo = "";
		try {
			SlipProcessVO slipProcessVO = new SlipProcessVO();
			for(int i=0; i<slipProcessVOs.length; i++){
				slipProcessVO = slipProcessVOs[i];
				//2014.10.02 NYK Modify yyMM 으로 변경. yyyymmdd > yymm 으로 변경
				slipProcessVO.setSlpIssDt(BizComJooUtil.getFormatSlpIssueDate(slipProcessVO.getSlpIssDt()));				
				
				if (i==0){
					slpSerNo = dbDao.searchNextSlpSerNo(slipProcessVO);
					slipProcessVO.setSlpSerNo(slpSerNo);
					
					csrNo = slipProcessVO.getSlpTpCd()
							+ slipProcessVO.getSlpFuncCd()
							+ slipProcessVO.getSlpOfcCd()
							+ slipProcessVO.getSlpIssDt()
							+ slpSerNo;
					
					//2014.10.02 NYK Modify
					this.manageCsulSlpSeq(slipProcessVO , slpSerNo);
					/*
					if ("00001".equals(slpSerNo)){
						dbDao.addJooSlpSeq(slipProcessVO);
					
					}else{
						dbDao.modifyJooSlpSeq(slipProcessVO);
					}
					*/
					dbDao.modifyJooStlCmb(slipProcessVO);
					
					dbDao.addJooCsr(slipProcessVO);
				}

				slipProcessVO.setSlpSerNo(slpSerNo);
				
				
				dbDao.addJooSlp(slipProcessVO);
			}
			
			slipProcessVO.setDrCrCd  (JooConstants.KEY_DR_CR_TP_CD_CR);//CR
			slipProcessVO.setKeyNo   (csrNo);
			slipProcessVO.setCrLocCd ("");
			slipProcessVO.setRlaneCd ("");
			slipProcessVO.setVslCd   ("");
			slipProcessVO.setSkdVoyNo("");
			slipProcessVO.setSkdDirCd("");
			slipProcessVO.setRevDirCd("");
			slipProcessVO.setStlVvdSeq("0");
			slipProcessVO.setStlSeq   ("0");
			slipProcessVO.setSlpDesc (slipProcessVO.getJoCrrCd()+"/"+slipProcessVO.getCsrDesc());
			
			dbDao.addJooSlp(slipProcessVO);
			
			//NYK Modify 2014.11.07
			/* KOR Only Process. TAX Biz 타지 않도록 주석 처리함.
			JooTaxVO jooTaxVO = null;
			JooTaxDtlVO jooTaxDtlVO = null;
			String taxSerNo = "";
			if (jooTaxVOs != null){
				for (int i=0; i < jooTaxVOs.length; i++){
					jooTaxVO = jooTaxVOs[i];
					taxSerNo = dbDao.searchNextTaxSerNo(jooTaxVO);
					jooTaxVO.setSlpSerNo(slpSerNo);
					jooTaxVO.setTaxSerNo(taxSerNo);
					jooTaxVO.setCreUsrId(signOnUserAccount.getUsr_id());
					
					//2014.10.02 NYK Modify yyMM 으로 변경.
					jooTaxVO.setSlpIssDt(BizComFmsUtil.getFormatSlpIssueDate(jooTaxVO.getSlpIssDt()));
										
					dbDao.addJooTax(jooTaxVOs[0]);
					
					jooTaxDtlVO = jooTaxDtlVOs[i];
					jooTaxDtlVO.setTaxSerNo(taxSerNo);
					jooTaxDtlVO.setCreUsrId(signOnUserAccount.getUsr_id());
					
					dbDao.addJooTaxDtl(jooTaxDtlVO);
				}
			}*/
			
			this.createCSREPApproval(slipProcessVOs[0], signOnUserAccount);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AP CSR", "Create"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AP CSR", "Create"}).getMessage(), ex);
		}
		
		return csrNo;
	}

	/**
	 * retrieving monthly closing status in case of inputting effective date
	 * @param SlipProcessVO slipProcessVO
	 * @return SlipProcessVO
	 * @throws EventException
	 */
	public SlipProcessVO searchCloseYn(SlipProcessVO slipProcessVO) throws EventException {
		try {
			return dbDao.searchCloseYn(slipProcessVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Effective Date", "Closing Check"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Effective Date", "Closing Check"}).getMessage(), ex);
		}
	}

	/**
	 * creating AP CSR
	 * @param SlipProcessVO[] slipProcessVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @throws EventException
	 */
	public String createARConsultation(SlipProcessVO[] slipProcessVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		String newCsrNo = "";
		String newSlpSerNo = "";
		String keyNo ="";
		try {
			SlipProcessVO slipProcessVO = new SlipProcessVO();
			
			for(int i=0; i<slipProcessVOs.length; i++){
				slipProcessVO = slipProcessVOs[i];
				
				//2014.10.02 NYK Modify yyMM 으로 변경.
				slipProcessVO.setSlpIssDt(BizComJooUtil.getFormatSlpIssueDate(slipProcessVO.getSlpIssDt()));				
				
				if (i==0){
					newSlpSerNo = dbDao.searchNextSlpSerNo(slipProcessVO);
					slipProcessVO.setSlpSerNo(newSlpSerNo);
					
					newCsrNo = slipProcessVO.getSlpTpCd()
							+ slipProcessVO.getSlpFuncCd()
							+ slipProcessVO.getSlpOfcCd()
							+ slipProcessVO.getSlpIssDt()
							+ newSlpSerNo;
					
					//2014.10.02 NYK Modify
					this.manageCsulSlpSeq(slipProcessVO , newSlpSerNo);
					/*					
					if ("00001".equals(slpSerNo)){
						dbDao.addJooSlpSeq(slipProcessVO);
					
					}else{
						dbDao.modifyJooSlpSeq(slipProcessVO);
					}
					*/
					
					
					dbDao.modifyJooStlCmb(slipProcessVO);
					
					dbDao.addJooCsr(slipProcessVO);
				}

				slipProcessVO.setSlpSerNo(newSlpSerNo);
				keyNo = 
					slipProcessVO.getJoCrrCd()
					//+"J"
					+(slipProcessVO.getAcctYrmon().replace("-", "")).substring(2)
					+JSPUtil.getLPAD(slipProcessVO.getStlCmbSeq(), 2, "0")
					+JSPUtil.getLPAD((i+1)+"", 3, "0");
				
				slipProcessVO.setKeyNo(keyNo);
				
				
				dbDao.addJooSlp(slipProcessVO);
			}
			
			for(int i=0; i<slipProcessVOs.length; i++){
				slipProcessVO = slipProcessVOs[i];

				slipProcessVO.setSlpSerNo(newSlpSerNo);
				slipProcessVO.setDrCrCd  (JooConstants.KEY_DR_CR_TP_CD_CR);//CR
				
				slipProcessVO.setSlpDesc (slipProcessVO.getJoCrrCd()+"/"+slipProcessVO.getCsrDesc());

				keyNo = 
					slipProcessVO.getJoCrrCd()
					//+"J"
					+(slipProcessVO.getAcctYrmon().replace("-", "")).substring(2)
					+JSPUtil.getLPAD(slipProcessVO.getStlCmbSeq(), 2, "0")
					+JSPUtil.getLPAD((i+1)+"", 3, "0");
				
				slipProcessVO.setKeyNo   (keyNo);
				
				dbDao.addJooSlp(slipProcessVO);
			}
			
			slipProcessVO.setMaxRows(slipProcessVOs.length); 
			this.createCSREPApproval(slipProcessVOs[0], signOnUserAccount);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AR CSR", "Creation"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AR CSR", "Creation"}).getMessage(), ex);
		}
		
		return newCsrNo;
	}
	
	/**
	 * 
	 * 1. JOO_STL_CMB.RVS_CMB_FLG = 'Y' UPDATE
	 * 2. JOO_STL_CMB_DTL, JOO_SLIP 議고쉶
	 * 3. JOO_SLP_SEQ INSERT OR UPDATE (SLP_SER_NO )
	 * 4. JOO_CSR INSERT
	 * 5. JOO_STL_CMB INSERT
	 * 6. JOO_STL_CMB_DTL INSERT
	 * 7. JOO_SLIP INSERT
	 * @param CsrVO csrVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @return List<JooStlCmbDtlVO>
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	public List<JooStlCmbDtlVO> reverseConsultation(CsrVO csrVO, SignOnUserAccount signOnUserAccount) throws EventException{
		List<JooStlCmbDtlVO> list = null;

		try {
			/******************************************
			 * 1. 기존 JOO_STL_CMB.RVS_CMB_FLG를 Y로 UPDATE한다.
			 *******************************************/
			csrVO.setUpdUsrId(signOnUserAccount.getUsr_id());
			csrVO.setRvsCmbFlg ("Y");
			csrVO.setRjctCmbFlg("N");

			dbDao.modifyJooStlCmbByReverse(csrVO);
			
			/******************************************
			 * 2. JOO_SETTLEMENT.CMB_CFM_FLG를 N으로 UPDATE하기 위해 JOO_STL_CMB_DTL정보를 조회한다.
			 * 2-1. JOO_SLIP을 copy하기 위해 조회한다.
			 *******************************************/
			//NYK Modify 2014.11.10
			//yyyymmdd > yymm : 20141108 > 1411 로 변환한다.
			csrVO.setSlpIssDt(BizComJooUtil.getFormatSlpIssueDateYmdToYyMm(csrVO.getSlpIssDt()));
			
			//2010.03.22 REVERSE 전표생성 후 SETTLEMENT자료를 삭제하려고 하면 JOO_STL_DTL에 DATA가 남아있어 FK오류가 발생한다.
			// 이에 해결방안 => 기존 SETTLEMENT는 COMBINED된 상태로 놔두고 새로운 SETTLEMENT를 COPY하여 대체한다.
			list = dbDao.searchJooStlCmbDtlForReverse(csrVO);
			List<JooSlipVO> list1 = dbDao.searchJooSlipForReverse(csrVO);

			/******************************************
			 * 3. 새로운 CSR 번호를 채번하여 JOO_SLP_SEQ에 입력 또는 수정한다.
			 *******************************************/
			SlipProcessVO slipProcessVO = new SlipProcessVO();
			
			slipProcessVO.setSlpTpCd  (csrVO.getSlpTpCd  ());
			if (JooConstants.KEY_SLIP_TP_CD_AP_06.equals(csrVO.getSlpTpCd())){//06
				if (JooConstants.KEY_SLIP_FUNC_CD_S.equals(csrVO.getSlpFuncCd())){//S
					slipProcessVO.setSlpFuncCd(JooConstants.KEY_SLIP_FUNC_CD_C);//C
				}else{
					slipProcessVO.setSlpFuncCd(JooConstants.KEY_SLIP_FUNC_CD_S);//S
				}
			}else{
				slipProcessVO.setSlpFuncCd(csrVO.getSlpFuncCd());
			}
			slipProcessVO.setSlpOfcCd (csrVO.getSlpOfcCd ());
			
			
			//2014.10.02 NYK Modify yyMM 으로 변경.
			String newSlpIssDt = BizComJooUtil.getFormatSlpIssueDate(JSPUtil.getKST("yyyyMMdd"));
			slipProcessVO.setSlpIssDt(newSlpIssDt);	
			//slipProcessVO.setSlpIssDt (JSPUtil.getKST("yyyyMMdd"));
			
			String newSlpSerNo = dbDao.searchNextSlpSerNo(slipProcessVO);
			
			slipProcessVO.setSlpSerNo(newSlpSerNo);
			slipProcessVO.setIssuerId(signOnUserAccount.getUsr_id());
			
			//2014.11.10 NYK Modify
			this.manageCsulSlpSeq(slipProcessVO , newSlpSerNo);
			
			/*if ("00001".equals(slpSerNo)){
				dbDao.addJooSlpSeq(slipProcessVO);
			
			}else{
				dbDao.modifyJooSlpSeq(slipProcessVO);
			}*/
			
			/******************************************
			 * 4. 새로운 reverse 정보를 JOO_CSR에 INSERT 
			 *******************************************/
			csrVO.setCreUsrId    (signOnUserAccount.getUsr_id());
			csrVO.setOrgSlpTpCd  (csrVO.getSlpTpCd  ());
			csrVO.setOrgSlpFuncCd(csrVO.getSlpFuncCd());
			csrVO.setOrgSlpOfcCd (csrVO.getSlpOfcCd ());
			csrVO.setOrgSlpIssDt (csrVO.getSlpIssDt ());//위에서 yyMM 포맷으로 변경함.
			csrVO.setOrgSlpSerNo (csrVO.getSlpSerNo ());
			csrVO.setSlpIssDt    (newSlpIssDt);
			csrVO.setSlpSerNo    (newSlpSerNo);
			csrVO.setCsrDesc     ("REVERSE CSR("+csrVO.getCsrDesc()+")");
			csrVO.setAproFlg     ("N");
			csrVO.setAproDt      ("");
			csrVO.setCxlFlg      ("N");
			csrVO.setCxlDesc     ("");
			csrVO.setDdctFlg     ("N");
			csrVO.setDdctLoclAmt ("0");
			csrVO.setDdctDesc    ("");
			csrVO.setRqstLoclAmt ("0");
			csrVO.setRvsCsrFlg   ("Y");
			csrVO.setRjctCsrFlg  ("N");
			
			if (JooConstants.KEY_SLIP_TP_CD_AP_06.equals(csrVO.getSlpTpCd())){//06
				if (JooConstants.KEY_SLIP_FUNC_CD_S.equals(csrVO.getSlpFuncCd())){//"S"
					csrVO.setSlpFuncCd(JooConstants.KEY_SLIP_FUNC_CD_C);//C
					csrVO.setCsrTpCd  (JooConstants.KEY_CSR_TP_CD_CREDIT);//"CREDIT"
				}else{
					csrVO.setSlpFuncCd(JooConstants.KEY_SLIP_FUNC_CD_S);//"S"
					csrVO.setCsrTpCd  (JooConstants.KEY_CSR_TP_CD_STANDARD);//"STANDARD"
				}
			}
			
			csrVO.setCsrLoclAmt  ((Double.parseDouble(csrVO.getCsrLoclAmt())*-1)+"");
			dbDao.addCsr(csrVO);
			
			/******************************************
			 * 5. JOO_STL_CMB에 Insert 
			 *******************************************/
			CmbConditionVO cmbConditionVO = new CmbConditionVO();
			cmbConditionVO.setAcctYrmon(csrVO.getAcctYrmon());
			cmbConditionVO.setJoCrrCd  (csrVO.getJoCrrCd  ());
			int nextStlCmbSeq = dbDao.searchNextStlSeq(cmbConditionVO);

			JooStlCmbVO jooStlCmbVO = new JooStlCmbVO();

			jooStlCmbVO.setAcctYrmon(csrVO.getAcctYrmon());
			jooStlCmbVO.setJoCrrCd  (csrVO.getJoCrrCd  ());
			jooStlCmbVO.setStlCmbSeq(nextStlCmbSeq+"");
			jooStlCmbVO.setReDivrCd (csrVO.getReDivrCd ());
			jooStlCmbVO.setSlpTpCd  (csrVO.getSlpTpCd  ());
			jooStlCmbVO.setSlpFuncCd(csrVO.getSlpFuncCd());
			jooStlCmbVO.setSlpOfcCd (csrVO.getSlpOfcCd ());
			jooStlCmbVO.setSlpIssDt (csrVO.getSlpIssDt ());//위에서 yyMM 포맷으로 변경함.
			jooStlCmbVO.setSlpSerNo (csrVO.getSlpSerNo ());
			jooStlCmbVO.setRvsCmbFlg("Y");
			jooStlCmbVO.setRjctCmbFlg("N");			
			jooStlCmbVO.setCreUsrId (signOnUserAccount.getUsr_id());
			dbDao.addJooStlCmb(jooStlCmbVO);
			
			/******************************************
			 * 6. JOO_STL_CMB_DTL에 Insert 
			 *******************************************/
			Iterator iterator = list.iterator();
			
			while(iterator.hasNext()){
				JooStlCmbDtlVO jooStlCmbDtlVO = (JooStlCmbDtlVO)iterator.next();

				jooStlCmbDtlVO.setStlCmbSeq(nextStlCmbSeq+"");
				jooStlCmbDtlVO.setReDivrCd (csrVO.getReDivrCd());
				jooStlCmbDtlVO.setCreUsrId (signOnUserAccount.getUsr_id());
				dbDao.addJooStlCmbDtl(jooStlCmbDtlVO);
			}

			/******************************************
			 * 7. JOO_SLIP에 Insert 
			 *******************************************/
			iterator = list1.iterator();
			
			double csrLoclAmt = 0;
			int    totCnt = 0;
			while(iterator.hasNext()){
				JooSlipVO jooSlipVO = (JooSlipVO)iterator.next();
				
				jooSlipVO.setSlpIssDt  (csrVO.getSlpIssDt ());//위에서 yyMM 포맷으로 변경함.
				jooSlipVO.setSlpSerNo  (csrVO.getSlpSerNo ());
				jooSlipVO.setSlpFuncCd (csrVO.getSlpFuncCd());
				jooSlipVO.setCsrLoclAmt((Double.parseDouble(jooSlipVO.getCsrLoclAmt())*-1)+"");
				//jooSlipVO.setCsrUsdAmt ((Double.parseDouble(jooSlipVO.getCsrUsdAmt ())*-1)+"");
				
				//결재선지정에 넣을 자료
				if (JooConstants.KEY_DR_CR_TP_CD_DR.equals(jooSlipVO.getDrCrCd())){//DR
					csrLoclAmt += (Double.parseDouble(jooSlipVO.getCsrLoclAmt()));
					totCnt++;
				}

				//VVD가 없는 AP의 CR 데이터는 EFF_DT를 조회할 수 없으므로 CSR의 EFF_DT를 넣는다.
				if (jooSlipVO.getVslCd() == null || "".equals(jooSlipVO.getVslCd())){
					jooSlipVO.setEffDt(csrVO.getEffDt());
					jooSlipVO.setVvdCxlFlg("N");
				}
				jooSlipVO.setCreUsrId(signOnUserAccount.getUsr_id());
				dbDao.addJooSlpByReverse(jooSlipVO);
			}

			/*************************
			 * 8. 결재선 지정
			 *************************/
			slipProcessVO.setTotAmount  (csrLoclAmt+"");
			slipProcessVO.setAproStep   (csrVO.getAproStep());
			slipProcessVO.setCustVndrSeq(csrVO.getCustSeq());
			slipProcessVO.setLoclCurrCd (csrVO.getCsrLoclCurrCd());
			slipProcessVO.setMaxRows    (totCnt);
			slipProcessVO.setRqstDt     (csrVO.getRqstDt());
			
			this.createCSREPApproval(slipProcessVO, signOnUserAccount);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reverse Slip", "Creation"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reverse Slip", "Creation"}).getMessage(), ex);
		}
		
		return list;
	}

	/**
	 * retrieving lost combined data 
	 * @param SlipConditionVO slipConditionVO
	 * @return List<LostCombinedDataVO>
	 * @throws EventException
	 */
	public List<LostCombinedDataVO> searchLostCombinedDataList(SlipConditionVO slipConditionVO) throws EventException {
		try {
			return dbDao.searchLostCombinedDataList(slipConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Lost Combined Data", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Lost Combined Data", "Retrieve"}).getMessage(), ex);
		}
	}


	/**
	 * retrieving office code of CSR
	 * @param SlipConditionVO slipConditionVO
	 * @return List<SlipConditionVO>
	 * @throws EventException
	 */
	public List<SlipConditionVO> searchStlOfcList(SlipConditionVO slipConditionVO) throws EventException {
		try {
			return dbDao.searchStlOfcList(slipConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement Office Code List", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Settlement Office Code List", "Retrieve"}).getMessage(), ex);
		}
	}
	
	/**
	 * setting Approval process
	 * @param SlipProcessVO slipProcessVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void createCSREPApproval(SlipProcessVO slipProcessVO, SignOnUserAccount signOnUserAccount) throws EventException {
		String  sCsrNo        = slipProcessVO.getSlpTpCd()
								+ slipProcessVO.getSlpFuncCd()
								+ slipProcessVO.getSlpOfcCd ()
								+ slipProcessVO.getSlpIssDt () //yyMM 포맷으로 변경된 데이타.
								+ slipProcessVO.getSlpSerNo ();
		
		String  sTotalAmt     = slipProcessVO.getTotAmount ();
		String  sCostOfcCd    = slipProcessVO.getSlpOfcCd  ();
		String  sUsrNm        = signOnUserAccount.getUsr_nm();
		
		String  sCreUsrId     = signOnUserAccount.getUsr_id();
		//String  sAproStep     = slipProcessVO.getAproStep  ();
		String  sOfcNm        = signOnUserAccount.getOfc_eng_nm();
		String  sVndrSeq      = slipProcessVO.getCustVndrSeq  ();
		String  sCurrCd       = slipProcessVO.getLoclCurrCd   ();
		String  sCntCd        = (JooConstants.KEY_SLIP_TP_CD_AP_06.equals(slipProcessVO.getSlpTpCd())?"1":slipProcessVO.getMaxRows()+""); //06
		String  sPaymentDueDt = slipProcessVO.getRqstDt       ();
		String  sInvSubSysCd  = JooConstants.KEY_MODULE_ID;//"JOO";				
		String  sAproKndCd    = (JooConstants.KEY_SLIP_TP_CD_AP_06.equals(slipProcessVO.getSlpTpCd())?JooConstants.KEY_APPROVAL_KIND_TYPE_CSR:JooConstants.KEY_APPROVAL_KIND_TYPE_REV); //06

		try {
			ApprovalUtil util = new ApprovalUtil();

			// COM_APRO_RQST_HDR
			ComAproRqstHdrVO header = new ComAproRqstHdrVO();
			header.setSubSysCd (sInvSubSysCd);
			header.setAproKndCd(sAproKndCd); 
			header.setRqstOfcCd(sCostOfcCd);
			header.setRqstOfcNm(sOfcNm);
			header.setRqstUsrJbTitNm(""); 
			header.setRqstUsrId(sCreUsrId);
			header.setRqstUsrNm(sUsrNm);
			header.setCreUsrId (sCreUsrId); 

			// COM_APRO_RQST_ROUT 
			//String apro_step = com.clt.bizcommon.approval.util.ApprovalUtil.getApprovalRoute("SELHO", "SCE");
			//ComAproRqstRoutVO[] route = util.convertApprovalRoute(sAproStep);
			//OFC �⑥쐞 寃곗옱濡�蹂�꼍. APRO_STEP �명똿���꾩슂 �놁쓬 (OFC 留��명똿)
			ComAproRqstRoutVO route = new ComAproRqstRoutVO();
			route.setAproOfcCd(sCostOfcCd);
			route.setAproOfcNm(sOfcNm);

			// COM_APRO_CSR_DTL
			ComAproCsrDtlVO csr = new ComAproCsrDtlVO();
			csr.setCsrNo(sCsrNo);
			csr.setCostOfcCd(sCostOfcCd);
			csr.setInvKnt(sCntCd);
			csr.setVndrSeq(sVndrSeq);
			//csr.setPay_due_dt(sGen_pay_term_cd);
			csr.setPayDueDt(sPaymentDueDt);
			csr.setCurrCd(sCurrCd);
			csr.setAproTtlAmt(sTotalAmt.replace(",", ""));
			csr.setCreUsrId(sCreUsrId);
			csr.setUpdUsrId(sCreUsrId);

			
			util.saveCsrApro(header, route, csr);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Approval Line", "Save"}).getMessage(), ex);
		}
	}

	/**
	 * @param CsrVO csrVO
	 * @return List<CsrVO>
	 * @throws EventException
	 */
	public List<CsrVO> searchCsrDetail(CsrVO csrVO) throws EventException {
		try {
			return dbDao.searchCsrDetail(csrVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"The Data for Approval", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"The Data for Approval", "Retrieve"}).getMessage(), ex);
		}
	}

    /**
     * retrieving result of BackEndJob
     * @param String key
     * @return String
     * @throws EventException
     */
	public String searchBakEndJobStatus(String key) throws EventException {
		DBRowSet rowSet;
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException ex) {
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Approval Consultation", "Search BackendJob Status"}).getMessage(), ex);
		} catch (SQLException ex) {
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Approval Consultation", "Search BackendJob Status"}).getMessage(), ex);
		} catch (InterruptedException ex) {
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Approval Consultation", "Search BackendJob Status"}).getMessage(), ex);
		} catch(Exception ex){
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Approval Consultation", "Search BackendJob Status"}).getMessage(), ex);
		}
	}
	

	/**
	 * manageCsulSlpSeq Dao.
	 * @param slipProcessVO SlipProcessVO
	 * @param slpSerNo String
	 * @throws EventException
	 */
	public void manageCsulSlpSeq(SlipProcessVO slipProcessVO, String slpSerNo) throws EventException {
		try {
			//0001
			if (JooConstants.DEFAULT_VALUE_SLP_SER_NO.equals(slpSerNo)){
				dbDao.addJooSlpSeq(slipProcessVO);			
			}else{
				dbDao.modifyJooSlpSeq(slipProcessVO);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"CSR Number", "Create"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"CSR Number", "Create"}).getMessage(), ex);
		}
	}


	/**
	 * AR_MST_REV_VVD Checked.
	 * @param SlipProcessVO slipProcessVO
	 * @return String
	 * @throws EventException
	 */
	public String getCheckArMasterRevenueVvd(SlipProcessVO slipProcessVO) throws EventException {
		try {
			String chkData = dbDao.getCheckArMasterRevenueVvd (slipProcessVO); 
			if(StringUtils.isEmpty(chkData)){
				return "F";
			}else{
				return "S";
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AP/AR CSR Information", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AP/AR CSR Information", "Retrieve"}).getMessage(), ex);
		}
	}
    
//	/**
//	 * Reject전표생성시
//	 * 
//	 * ★ Interface Error인 경우
//	 * 1. JOO_STL_CMB_DTL 조회
//	 * 2. JOO_TAX_DTL삭제
//	 * 3. JOO_TAX 삭제
//	 * 4. JOO_SLIP 삭제
//	 * 5. JOO_CSR 삭제
//	 * 6. JOO_STL_CMB_DTL 삭제
//	 * 7. JOO_STL_CMB 삭제
//	 * 
//	 * ★ ERP Reject 된 경우 
//	 * 1. JOO_STL_CMB.RJCT_CMB_FLG = 'Y' UPDATE
//	 * 2. JOO_STL_CMB_DTL, JOO_SLIP 조회
//	 * 3. JOO_SLP_SEQ INSERT OR UPDATE (SLP_SER_NO 채번)
//	 * 4. JOO_CSR INSERT
//	 * 5. JOO_STL_CMB INSERT
//	 * 6. JOO_STL_CMB_DTL INSERT
//	 * 7. JOO_SLIP INSERT
//	 * JOO_SETTLEMENT 의 CMB_CFM_FLG = 'N'으로 UPDATE하기 위해 JOO_STL_CMB_DTL LIST를 RETURN한다.
//	 * @param CsrVO csrVO
//	 * @param SignOnUserAccount signOnUserAccount
//	 * @return List<JooStlCmbDtlVO>
//	 * @throws EventException
//	 */
//	public List<JooStlCmbDtlVO> rejectConsultation(CsrVO csrVO, SignOnUserAccount signOnUserAccount) throws EventException{
//		List<JooStlCmbDtlVO> list = null;
//
//		try {
//				csrVO.setUpdUsrId(signOnUserAccount.getUsr_id());
//				
//				dbDao.modifyComAproRqstRout(csrVO);
//				dbDao.modifyComAproRqstHdr (csrVO);
//				
//				dbDao.modifyCsr(csrVO);
//				//cancel 된 건이면 CSR No로 slip, tax master, tax detail을 모두 삭제한다.
//				//2011.04.07 이준범[CHM-201110018-01] dbDao.removeTaxByCsr, removeTaxDtlByCsr 호출 순서 변경
//				if ("Y".equals(csrVO.getCxlFlg())){
//					dbDao.removeSlipByCsr          (csrVO);
//					dbDao.removeTaxDtlByCsr        (csrVO);
//					dbDao.removeTaxByCsr           (csrVO);
//					dbDao.modifyJooStlCmbClearCsrNo(csrVO);
//				}
//				
////				/******************************************
////				 * 1. 기존 JOO_STL_CMB.RJCT_CMB_FLG를 Y로 UPDATE한다.
////				 *******************************************/
////				csrVO.setUpdUsrId(signOnUserAccount.getUsr_id());
////				csrVO.setRvsCmbFlg ("N");
////				csrVO.setRjctCmbFlg("Y");
////	
////				dbDao.modifyJooStlCmbByReverse(csrVO);
////				
////				//NYK Modify 2014.11.10
////				//yyyymmdd > yymm : 20141108 > 1411 로 변환한다.
////				csrVO.setSlpIssDt(BizComJooUtil.getFormatSlpIssueDateYmdToYyMm(csrVO.getSlpIssDt()));
////				
////				/******************************************
////				 * 2. JOO_SETTLEMENT.CMB_CFM_FLG를 N으로 UPDATE하기 위해 JOO_STL_CMB_DTL정보를 조회한다.
////				 * 2-1. JOO_SLIP을 copy하기 위해 조회한다.
////				 *******************************************/
////				list = dbDao.searchJooStlCmbDtlForReverse(csrVO);
////				List<JooSlipVO> list1 = dbDao.searchJooSlipForReverse(csrVO);
////	
////				/******************************************
////				 * 3. 새로운 CSR 번호를 채번하여 JOO_SLP_SEQ에 입력 또는 수정한다.
////				 *******************************************/
////				SlipProcessVO slipProcessVO = new SlipProcessVO();
////				
////				slipProcessVO.setSlpTpCd  (csrVO.getSlpTpCd  ());
////				if (JooConstants.KEY_SLIP_TP_CD_06.equals(csrVO.getSlpTpCd())){//06
////					if (JooConstants.KEY_SLIP_FUNC_CD_S.equals(csrVO.getSlpFuncCd())){//S
////						slipProcessVO.setSlpFuncCd(JooConstants.KEY_SLIP_FUNC_CD_C);//C
////					}else{
////						slipProcessVO.setSlpFuncCd(JooConstants.KEY_SLIP_FUNC_CD_S);//S
////					}
////				}else{
////					slipProcessVO.setSlpFuncCd(csrVO.getSlpFuncCd());
////				}
////				
////				slipProcessVO.setSlpOfcCd (csrVO.getSlpOfcCd ());
////				
////				//2014.10.02 NYK Modify yyMM 으로 변경.
////				String newSlpIssDt = BizComJooUtil.getFormatSlpIssueDate(JSPUtil.getKST("yyyyMMdd"));
////				slipProcessVO.setSlpIssDt(newSlpIssDt);
////	
////				String newSlpSerNo = dbDao.searchNextSlpSerNo(slipProcessVO);
////				
////				slipProcessVO.setSlpSerNo(newSlpSerNo);
////				slipProcessVO.setIssuerId(signOnUserAccount.getUsr_id());
////				
////				//JOO_SLP_SEQ에 한 건을 입력한다.
////				//2014.11.10 NYK Modify
////				this.manageCsulSlpSeq(slipProcessVO , newSlpSerNo);
////				
////				
////				/******************************************
////				 * 4. 새로운 REJECT 정보를 JOO_CSR에 INSERT 
////				 *******************************************/
////				csrVO.setCreUsrId    (signOnUserAccount.getUsr_id());
////				csrVO.setOrgSlpTpCd  (csrVO.getSlpTpCd  ());
////				csrVO.setOrgSlpFuncCd(csrVO.getSlpFuncCd());
////				csrVO.setOrgSlpOfcCd (csrVO.getSlpOfcCd ());
////				csrVO.setOrgSlpIssDt (csrVO.getSlpIssDt ());
////				csrVO.setOrgSlpSerNo (csrVO.getSlpSerNo ());
////				csrVO.setSlpIssDt    (newSlpIssDt);
////				csrVO.setSlpSerNo    (newSlpSerNo);
////				csrVO.setCsrDesc     ("REJECT CSR("+csrVO.getCsrDesc()+")");
////				csrVO.setAproFlg     ("Y"); //임의로 APROVAL 처리한다.
////				csrVO.setAproDt      (JSPUtil.getKST("yyyyMMdd"));
////				csrVO.setCxlFlg      ("N");
////				csrVO.setCxlDesc     ("");
////				csrVO.setDdctFlg     ("N");
////				csrVO.setDdctLoclAmt ("0");
////				csrVO.setDdctDesc    ("");
////				csrVO.setRqstLoclAmt ("0");
////				csrVO.setRvsCsrFlg   ("N");
////				csrVO.setRjctCsrFlg  ("Y"); //Reject Flag Y로 마킹.
////				
////				if (JooConstants.KEY_SLIP_TP_CD_06.equals(csrVO.getSlpTpCd())){//06
////					if (JooConstants.KEY_SLIP_FUNC_CD_S.equals(csrVO.getSlpFuncCd())){//"S"
////						csrVO.setSlpFuncCd(JooConstants.KEY_SLIP_FUNC_CD_C);//C
////						csrVO.setCsrTpCd  (JooConstants.KEY_CSR_TP_CD_CREDIT);//"CREDIT"
////					}else{
////						csrVO.setSlpFuncCd(JooConstants.KEY_SLIP_FUNC_CD_S);//"S"
////						csrVO.setCsrTpCd  (JooConstants.KEY_CSR_TP_CD_STANDARD);//"STANDARD"
////					}
////				}
////				
////				csrVO.setCsrLoclAmt  ((Double.parseDouble(csrVO.getCsrLoclAmt())*-1)+"");
////				dbDao.addCsr(csrVO);
////				
////				/******************************************
////				 * 5. JOO_STL_CMB에 Insert 
////				 *******************************************/
////				CmbConditionVO cmbConditionVO = new CmbConditionVO();
////				cmbConditionVO.setAcctYrmon(csrVO.getAcctYrmon());
////				cmbConditionVO.setJoCrrCd  (csrVO.getJoCrrCd  ());
////				int nextStlCmbSeq = dbDao.searchNextStlSeq(cmbConditionVO);
////	
////				JooStlCmbVO jooStlCmbVO = new JooStlCmbVO();
////	
////				jooStlCmbVO.setAcctYrmon(csrVO.getAcctYrmon());
////				jooStlCmbVO.setJoCrrCd  (csrVO.getJoCrrCd  ());
////				jooStlCmbVO.setStlCmbSeq(nextStlCmbSeq+"");
////				jooStlCmbVO.setReDivrCd (csrVO.getReDivrCd ());
////				jooStlCmbVO.setSlpTpCd  (csrVO.getSlpTpCd  ());
////				jooStlCmbVO.setSlpFuncCd(csrVO.getSlpFuncCd());
////				jooStlCmbVO.setSlpOfcCd (csrVO.getSlpOfcCd ());
////				jooStlCmbVO.setSlpIssDt (csrVO.getSlpIssDt ());
////				jooStlCmbVO.setSlpSerNo (csrVO.getSlpSerNo ());
////				jooStlCmbVO.setRvsCmbFlg("N");
////				jooStlCmbVO.setRjctCmbFlg("Y");
////				jooStlCmbVO.setCreUsrId (signOnUserAccount.getUsr_id());
////				dbDao.addJooStlCmb(jooStlCmbVO);
////				
////				/******************************************
////				 * 6. JOO_STL_CMB_DTL에 Insert 
////				 *******************************************/
////				Iterator iterator = list.iterator();
////				
////				while(iterator.hasNext()){
////					JooStlCmbDtlVO jooStlCmbDtlVO = (JooStlCmbDtlVO)iterator.next();
////	
////					jooStlCmbDtlVO.setStlCmbSeq(nextStlCmbSeq+"");
////					jooStlCmbDtlVO.setReDivrCd (csrVO.getReDivrCd());
////					jooStlCmbDtlVO.setCreUsrId (signOnUserAccount.getUsr_id());
////					dbDao.addJooStlCmbDtl(jooStlCmbDtlVO);
////				}
////	
////				/******************************************
////				 * 7. JOO_SLIP에 Insert 
////				 *******************************************/
////				iterator = list1.iterator();
////				
////				while(iterator.hasNext()){
////					JooSlipVO jooSlipVO = (JooSlipVO)iterator.next();
////					
////					jooSlipVO.setSlpIssDt  (csrVO.getSlpIssDt ());
////					jooSlipVO.setSlpSerNo  (csrVO.getSlpSerNo ());
////					jooSlipVO.setSlpFuncCd (csrVO.getSlpFuncCd());
////					jooSlipVO.setCsrLoclAmt((Double.parseDouble(jooSlipVO.getCsrLoclAmt())*-1)+"");
////					//jooSlipVO.setCsrUsdAmt ((Double.parseDouble(jooSlipVO.getCsrUsdAmt ())*-1)+"");
////	
////					//VVD가 없는 AP의 CR 데이터는 EFF_DT를 조회할 수 없으므로 CSR의 EFF_DT를 넣는다.
////					if (jooSlipVO.getVslCd() == null || "".equals(jooSlipVO.getVslCd())){
////						jooSlipVO.setEffDt(csrVO.getEffDt());
////						jooSlipVO.setVvdCxlFlg("N");
////					}
////					jooSlipVO.setCreUsrId(signOnUserAccount.getUsr_id());
////					dbDao.addJooSlpByReverse(jooSlipVO);
////				}
//		} catch (DAOException ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reject Slip", "Creation"}).getMessage(), ex);
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reject Slip", "Creation"}).getMessage(), ex);
//		}
//		
//		return list;
//	}
}
