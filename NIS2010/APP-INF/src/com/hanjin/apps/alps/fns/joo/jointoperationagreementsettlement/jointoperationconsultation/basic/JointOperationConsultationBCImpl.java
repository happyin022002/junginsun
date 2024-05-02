/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationConsultationBCImpl.java
*@FileTitle : Tax Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.18 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomContractVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ArDisabledVVDVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration.JointOperationConsultationDBDAO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration.JointOperationConsultationEAIDAO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.ApIfErrVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.ArDataInqVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CmbConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CombinedGrpVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CombinedVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CsrSlipVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CsrVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.ErpIfVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.LostCombinedDataVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipProcessVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.TaxGrpVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.TaxVO;
import com.hanjin.bizcommon.approval.util.ApprovalUtil;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ComAproCsrDtlVO;
import com.hanjin.syscommon.common.table.ComAproRqstHdrVO;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;
import com.hanjin.syscommon.common.table.JooCrrMrgVO;
import com.hanjin.syscommon.common.table.JooSettlementVO;
import com.hanjin.syscommon.common.table.JooSlipVO;
import com.hanjin.syscommon.common.table.JooStlCmbDtlVO;
import com.hanjin.syscommon.common.table.JooStlCmbVO;
import com.hanjin.syscommon.common.table.JooTaxDtlVO;
import com.hanjin.syscommon.common.table.JooTaxVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.AgmtDocVO;

/**
 * ALPS-JointOperationAgreementSettlement Business Logic Basic Command implementation<br>
 * - ALPS-JointOperationAgreementSettlement에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Park Hee Dong
 * @see FNS_JOO_0044EventResponse,JointOperationConsultationBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class JointOperationConsultationBCImpl extends BasicCommandSupport implements JointOperationConsultationBC {

	// Database Access Object
	private transient JointOperationConsultationDBDAO dbDao = null;
	private transient JointOperationConsultationEAIDAO eaiDao = null;

	/**
	 * JointOperationConsultationBCImpl 객체 생성<br>
	 * JointOperationConsultationDBDAO를 생성한다.<br>
	 */
	public JointOperationConsultationBCImpl() {
		dbDao = new JointOperationConsultationDBDAO();
		eaiDao = new JointOperationConsultationEAIDAO();
	}

	/**
	 * Tax를 조회한다.
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

	/**
	 * AR Data ERP Interface를 조회한다.
	 * @param String erpIfFlg
	 * @param String dtFlg
	 * @param String fmDt
	 * @param String toDt
	 * @return List<ErpIfVO>
	 * @throws EventException
	 */
	public List<ErpIfVO> searchARERPInterfaceList(String erpIfFlg, String dtFlg, String fmDt, String toDt) throws EventException {
		try {
			return dbDao.searchARERPInterfaceList(erpIfFlg, dtFlg, fmDt, toDt);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AR ERP Interface data", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AR ERP Interface data", "Retrieve"}).getMessage(), ex);
		}
	}

	/**
	 * AP Data ERP Interface를 조회한다.
	 * @param String erpIfFlg
	 * @param String dtFlg
	 * @param String fmDt
	 * @param String toDt
	 * @return List<ErpIfVO>
	 * @throws EventException
	 */
	public List<ErpIfVO> searchAPERPInterfaceList(String erpIfFlg, String dtFlg, String fmDt, String toDt) throws EventException {
		try {
			return dbDao.searchAPERPInterfaceList(erpIfFlg, dtFlg, fmDt, toDt);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AP ERP Interface data", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AP ERP Interface data", "Retrieve"}).getMessage(), ex);
		}
	} 
	
	/**
	 * 전표를 조회한다. 
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
	 * 승인할 CSR 리스트를 조회한다.
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
	 * CSR No.로 Approval 대상 CSR정보를 조회한다.
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
	 * CSR 승인처리 한다.
	 * @param CsrVO csrVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @throws EventException
	 */
	public String approvalConsultation(CsrVO csrVO, SignOnUserAccount signOnUserAccount) throws EventException{
        try {
    		JointOperationConsultationBackEndJob backEndResult = new JointOperationConsultationBackEndJob();
    		
    		BackEndJobManager backEndJobManager = new BackEndJobManager();
    		backEndResult.setCsrVO(csrVO);
    		backEndResult.setSignOnUserAccount(signOnUserAccount);
    		
    		return backEndJobManager.execute(backEndResult, signOnUserAccount.getUsr_id(), "JOO Approval Consultation!!!");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"JOO Consultation", "Approval"}).getMessage(), ex);
        }
	}

	/**
	 * CSR 승인처리 한다.
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
//			//반려 이면 최종결재권자 여부 상관없이 cancel처리하고 (2010.01.29 박효숙 차장)  승인인경우 최종 결재권자가 아니면 approval step process 만 처리한다.
//			if (!"Y".equals(csrVO.getCxlFlg()) && !"Y".equals(csrVO.getLstAproFlg())){
//				return;
//			}
//			
//			dbDao.modifyCsr(csrVO);
//
//			String csrNo = csrVO.getCsrNo();
//			
//			//승인된 건이면 EAI를 통해 처리한다.
//			if ("Y".equals(csrVO.getAproFlg())){
//				//AR인 경우
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
//						//JOO_AR_MN 테이블에 INSERT한다.
//						dbDao.addJooArMn(arMnChgVO);
//						
//						//JOO_AR_CHG 테이블에 INSERT한다.
//						dbDao.addJooArChg(arMnChgVO);
//					}
//					//==========================================
//					// ERP로 전송한다.
//					//==========================================
//					eaiDao.sendSlipApprovalToAR(csrNo, list);
//				//AP인 경우
//				}else{
//					List<InvHdrVO>  list  = dbDao.searchApHeaderInfoForApproval(csrVO);
//					List<InvDtrbVO> list1 = dbDao.searchApDetailInfoForApproval(csrVO);
//					
//					InvHdrVO invHdrVO = list.get(0);
//					invHdrVO.setCreUsrId(signOnUserAccount.getUsr_id());
//					
//					//AP_INV_HDR에 INSERT
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
//						//AP_INV_DTRB에 INSERT
//						dbDao.addApInvDtrb(invDtrbVO);
//						
//						invIfVO = new InvIfVO();
//						setInvIfVO(invIfVO, invHdrVO, invDtrbVO, totCnt, i+1);
//						//AP_INV_IF에 INSERT
//						dbDao.addApInvIf(invIfVO);
//					}
//					
//					//==========================================
//					// ERP로 전송한다.
//					//==========================================
//					eaiDao.sendSlipApprovalToAP(csrNo, list, list1);
//				}
//			}
//			
//			//cancel 된 건이면 CSR No로 slip, tax master, tax detail을 모두 삭제한다.
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
	 * AP CSR의 Evience를 조회한다.
	 * @param String csrNo
	 * @return TaxGrpVO
	 * @throws EventException
	 */
	public TaxGrpVO searchAPEvidence(String csrNo) throws EventException {
		TaxGrpVO grpVO = new TaxGrpVO();
		try {
			List<JooTaxVO>    jooTaxVOs    = dbDao.searchTaxMasterList(csrNo);
			List<JooTaxDtlVO> jooTaxDtlVOs = null;

			JooTaxVO jooTaxVO = null;
			if (!jooTaxVOs.isEmpty())
				jooTaxVO = jooTaxVOs.get(0);
			
			if (jooTaxVO!=null){
				jooTaxDtlVOs = dbDao.searchTaxDetailList(jooTaxVO);
			}
			grpVO.setJooTaxVOs   (jooTaxVOs);
			grpVO.setJooTaxDtlVOs(jooTaxDtlVOs);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AP Evidence", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AP Evidence", "Retrieve"}).getMessage(), ex);
		}
		return grpVO;
	}
	
	/**
	 * AP CSR의 Evidence정보를 입력하기 위해 Vendor 정보 조회한다.
	 * @param String vndrSeq
	 * @return List<JooTaxVO>
	 * @throws EventException
	 */
	public List<JooTaxVO> searchVendorInfo(String vndrSeq) throws EventException {
		try {
			return dbDao.searchVendorInfo(vndrSeq);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Vendor Information", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Vendor Information", "Retrieve"}).getMessage(), ex);
		}
	}
	
	/**
	 * CSR List를 조회한다.
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
	 * CSR의 Office code를 distinct로 조회한다.
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
	 * Combined 된 Settlement의 Lane List와 Settlement list를 동시에 조회한다. 
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
	 * Combined 대상 Lane List를 조회한다.
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
	 * Combined Lane 을 multi 선택한 경우 선택된 Lane들의 Combined 대상 Settlement를 조회한다.
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
	 * Combining 처리한다.
	 * @param CmbConditionVO cmbConditionVO
	 * @param CombinedVO[] combinedVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return int
	 * @throws EventException
	 */
	public int manageCombinedMonthlyClearance(CmbConditionVO cmbConditionVO, CombinedVO[] combinedVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		int nextStlCmbSeq = 1;
		try {
			//Next Val을 조회하여 insert한다.
			nextStlCmbSeq = dbDao.searchNextStlSeq(cmbConditionVO);
			
			//JOO_STL_CMB에 INSERT한다.
			JooStlCmbVO jooStlCmbVO = new JooStlCmbVO();

			jooStlCmbVO.setAcctYrmon(cmbConditionVO.getAcctYrmon());
			jooStlCmbVO.setJoCrrCd  (cmbConditionVO.getJoCrrCd  ());
			jooStlCmbVO.setStlCmbSeq(nextStlCmbSeq+"");
			jooStlCmbVO.setCreUsrId (signOnUserAccount.getUsr_id());
			jooStlCmbVO.setRvsCmbFlg("N");

			int eCnt = 0;
			int rCnt = 0;

			//2010.02.26 FK때문에 Loop를 2회 돌리게 됨...(Parent먼저 입력하기 위함)
			for(int i=0; i<combinedVOs.length; i++){
				if ("E".equals(combinedVOs[i].getReDivrCd()))
					eCnt++;

				if ("R".equals(combinedVOs[i].getReDivrCd()))
					rCnt++;
			}
			//R이 있는 경우
			if (rCnt > 0){
				jooStlCmbVO.setReDivrCd("R");
				dbDao.addJooStlCmb(jooStlCmbVO);
			}
			//E가 있는 경우
			if (eCnt > 0){
				jooStlCmbVO.setReDivrCd("E");
				dbDao.addJooStlCmb(jooStlCmbVO);
			}

			//JOO_STL_CMB_DTL에 data 저장
			JooStlCmbDtlVO jooStlCmbDtlVO = new JooStlCmbDtlVO();
			
			for(int i=0; i<combinedVOs.length; i++){
				jooStlCmbDtlVO.setAcctYrmon(combinedVOs[i].getAcctYrmon());
				jooStlCmbDtlVO.setJoCrrCd  (combinedVOs[i].getJoCrrCd  ());
				jooStlCmbDtlVO.setStlCmbSeq(nextStlCmbSeq+"");
				jooStlCmbDtlVO.setReDivrCd (combinedVOs[i].getReDivrCd ());
				jooStlCmbDtlVO.setStlVvdSeq(combinedVOs[i].getStlVvdSeq());
				jooStlCmbDtlVO.setStlSeq   (combinedVOs[i].getStlSeq   ());
				jooStlCmbDtlVO.setCreUsrId (signOnUserAccount.getUsr_id());
				
				//JOO_STL_CMB_DTL 저장
				jooStlCmbDtlVO.setStlCmbSeq(nextStlCmbSeq+"");
				jooStlCmbDtlVO.setCreUsrId(signOnUserAccount.getUsr_id());

				
				//2009.10.12 JOO_SETTLEMENT와 JOO_STL_DTL을 JOIN거는 것이라...
				//같은 ACCT_YRMON, STL_VVD_SEQ, STL_SEQ가 중복되어 나올 수 있다... <= dup error가 나면 skip하는 것으로 수정한다.
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
	 * Combined 된 Settlement 정보를 취소한다.
	 * @param CmbConditionVO cmbConditionVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void removeCombinedMonthlyClearance(CmbConditionVO cmbConditionVO, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			//JOO_STL_CMB_DTL 삭제
			dbDao.removeJooStlCmbDtlS(cmbConditionVO);

			//JOO_STL_CMB 삭제
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
	 * AP CSR 정보를 조회한다.
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
	 * AP CSR정보를 생성한다.
	 * - slp_ser_no 채번 (단건)
	 * - joo_stl_seq에 update 또는 insert (단건)
	 * - joo_stl_cmb에 csr no. update (단건)
	 * - joo_csr에 입력 (단건)
	 * - joo_slip에 입력 (DR n건)
	 * - joo_slip에 입력 (CR 단건)
	 * - joo_tax 에 입력
	 * - joo_tax_dtl 에 입력
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
				
				//csrNo 채번
				if (i==0){
					slpSerNo = dbDao.searchNextSlpSerNo(slipProcessVO);
					slipProcessVO.setSlpSerNo(slpSerNo);
					
					csrNo = slipProcessVO.getSlpTpCd()
							+ slipProcessVO.getSlpFuncCd()
							+ slipProcessVO.getSlpOfcCd()
							+ slipProcessVO.getSlpIssDt().substring(2)
							+ slpSerNo;
					
					//JOO_SLP_SEQ에 한 건을 입력한다.
					if ("00001".equals(slpSerNo)){
						dbDao.addJooSlpSeq(slipProcessVO);
					//slp_tp_cd, slp_func_cd, slp_ofc_cd, slp_iss_dt로 있는 data면 update한다.
					}else{
						dbDao.modifyJooSlpSeq(slipProcessVO);
					}
					//JOO_STL_CMB에 CSR No.를 Update한다.
					dbDao.modifyJooStlCmb(slipProcessVO);
					//JOO_CSR에 한건 입력
					dbDao.addJooCsr(slipProcessVO);
				}

				slipProcessVO.setSlpSerNo(slpSerNo);
				
				//JOO_SLIP 테이블에 입력
				dbDao.addJooSlp(slipProcessVO);
			}
			
			slipProcessVO.setDrCrCd  ("CR");
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
			//JOO_SLIP 테이블에 summary 입력
			dbDao.addJooSlp(slipProcessVO);
			
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
					//JOO_TAX입력
					dbDao.addJooTax(jooTaxVOs[0]);
					
					jooTaxDtlVO = jooTaxDtlVOs[i];
					jooTaxDtlVO.setTaxSerNo(taxSerNo);
					jooTaxDtlVO.setCreUsrId(signOnUserAccount.getUsr_id());
					dbDao.addJooTaxDtl(jooTaxDtlVO);
				}
			}
			
			/***************************
			 * 결재라인 지정
			 ***************************/
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
	 * CSR Creation 에서 Effective Date 입력시 해당 월의 마감여부를 조회한다.
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
	 * AR CSR을 생성한다.
	 * - slp_ser_no 채번 (단건)
	 * - joo_stl_seq에 update 또는 insert (단건)
	 * - joo_stl_cmb에 csr no. update (단건)
	 * - joo_csr에 입력 (단건)
	 * - joo_slip에 입력 (DR n건)
	 * - joo_slip에 입력 (CR n건)
	 * @param SlipProcessVO[] slipProcessVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @return String
	 * @throws EventException
	 */
	public String createARConsultation(SlipProcessVO[] slipProcessVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		String csrNo = "";
		String slpSerNo = "";
		String keyNo ="";
		try {
			SlipProcessVO slipProcessVO = new SlipProcessVO();
			
			for(int i=0; i<slipProcessVOs.length; i++){
				slipProcessVO = slipProcessVOs[i];
				
				//csrNo 채번
				if (i==0){
					slpSerNo = dbDao.searchNextSlpSerNo(slipProcessVO);
					slipProcessVO.setSlpSerNo(slpSerNo);
					
					csrNo = slipProcessVO.getSlpTpCd()
							+ slipProcessVO.getSlpFuncCd()
							+ slipProcessVO.getSlpOfcCd()
							+ slipProcessVO.getSlpIssDt().substring(2)
							+ slpSerNo;
					
					//JOO_SLP_SEQ에 한 건을 입력한다.
					if ("00001".equals(slpSerNo)){
						dbDao.addJooSlpSeq(slipProcessVO);
					//slp_tp_cd, slp_func_cd, slp_ofc_cd, slp_iss_dt로 있는 data면 update한다.
					}else{
						dbDao.modifyJooSlpSeq(slipProcessVO);
					}
					//JOO_STL_CMB에 CSR No.를 Update한다.
					dbDao.modifyJooStlCmb(slipProcessVO);
					//JOO_CSR에 한건 입력
					dbDao.addJooCsr(slipProcessVO);
				}

				slipProcessVO.setSlpSerNo(slpSerNo);
				keyNo = 
					slipProcessVO.getJoCrrCd()
					+"J"
					+(slipProcessVO.getAcctYrmon().replace("-", "")).substring(2)
					+JSPUtil.getLPAD(slipProcessVO.getStlCmbSeq(), 2, "0")
					+JSPUtil.getLPAD((i+1)+"", 3, "0");
				
				slipProcessVO.setKeyNo(keyNo);
				
				//JOO_SLIP 테이블에 입력
				dbDao.addJooSlp(slipProcessVO);
			}
			
			/***************************
			 * CR 입력
			 ***************************/
			for(int i=0; i<slipProcessVOs.length; i++){
				slipProcessVO = slipProcessVOs[i];

				slipProcessVO.setSlpSerNo(slpSerNo);
				slipProcessVO.setDrCrCd  ("CR");
				//slipProcessVO.setCrLocCd (""); ==> 2009.09.16 최초 null이었으나 ERP로 넘길 때 필요하여 다시 DR과 같은 값으로 함.  by 이수진 수석
				slipProcessVO.setSlpDesc (slipProcessVO.getJoCrrCd()+"/"+slipProcessVO.getCsrDesc());

				keyNo = 
					slipProcessVO.getJoCrrCd()
					+"J"
					+(slipProcessVO.getAcctYrmon().replace("-", "")).substring(2)
					+JSPUtil.getLPAD(slipProcessVO.getStlCmbSeq(), 2, "0")
					+JSPUtil.getLPAD((i+1)+"", 3, "0");
				
				slipProcessVO.setKeyNo   (keyNo);
				//JOO_SLIP 테이블에 summary 입력
				dbDao.addJooSlp(slipProcessVO);
			}
			
			/***************************
			 * 결재라인 지정
			 ***************************/
			slipProcessVO.setMaxRows(slipProcessVOs.length); //결재라인의 count를 위해
			this.createCSREPApproval(slipProcessVOs[0], signOnUserAccount);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AR CSR", "Creation"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AR CSR", "Creation"}).getMessage(), ex);
		}
		
		return csrNo;
	}
	
	/**
	 * Reverse전표생성시 
	 * 1. JOO_STL_CMB.RVS_CMB_FLG = 'Y' UPDATE
	 * 2. JOO_STL_CMB_DTL, JOO_SLIP 조회
	 * 3. JOO_SLP_SEQ INSERT OR UPDATE (SLP_SER_NO 채번)
	 * 4. JOO_CSR INSERT
	 * 5. JOO_STL_CMB INSERT
	 * 6. JOO_STL_CMB_DTL INSERT
	 * 7. JOO_SLIP INSERT
	 * JOO_SETTLEMENT 의 CMB_CFM_FLG = 'N'으로 UPDATE하기 위해 JOO_STL_CMB_DTL LIST를 RETURN한다.
	 * @param CsrVO csrVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @return List<JooStlCmbDtlVO>
	 * @throws EventException
	 */
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
			//2010.03.22 REVERSE 전표생성 후 SETTLEMENT자료를 삭제하려고 하면 JOO_STL_DTL에 DATA가 남아있어 FK오류가 발생한다.
			// 이에 해결방안 => 기존 SETTLEMENT는 COMBINED된 상태로 놔두고 새로운 SETTLEMENT를 COPY하여 대체한다.
			list = dbDao.searchJooStlCmbDtlForReverse(csrVO);
			List<JooSlipVO> list1 = dbDao.searchJooSlipForReverse(csrVO);

			/******************************************
			 * 3. 새로운 CSR 번호를 채번하여 JOO_SLP_SEQ에 입력 또는 수정한다.
			 *******************************************/
			SlipProcessVO slipProcessVO = new SlipProcessVO();
			
			slipProcessVO.setSlpTpCd  (csrVO.getSlpTpCd  ());
			if ("06".equals(csrVO.getSlpTpCd())){
				if ("S".equals(csrVO.getSlpFuncCd())){
					slipProcessVO.setSlpFuncCd("C");
				}else{
					slipProcessVO.setSlpFuncCd("S");
				}
			}else{
				slipProcessVO.setSlpFuncCd(csrVO.getSlpFuncCd());
			}
			slipProcessVO.setSlpOfcCd (csrVO.getSlpOfcCd ());
			slipProcessVO.setSlpIssDt (JSPUtil.getKST("yyyyMMdd"));

			String slpSerNo = dbDao.searchNextSlpSerNo(slipProcessVO);
			
			slipProcessVO.setSlpSerNo(slpSerNo);
			slipProcessVO.setIssuerId(signOnUserAccount.getUsr_id());
			//JOO_SLP_SEQ에 한 건을 입력한다.
			if ("00001".equals(slpSerNo)){
				dbDao.addJooSlpSeq(slipProcessVO);
			//slp_tp_cd, slp_func_cd, slp_ofc_cd, slp_iss_dt로 있는 data면 update한다.
			}else{
				dbDao.modifyJooSlpSeq(slipProcessVO);
			}
			/******************************************
			 * 4. 새로운 reverse 정보를 JOO_CSR에 INSERT 
			 *******************************************/
			csrVO.setCreUsrId    (signOnUserAccount.getUsr_id());
			csrVO.setOrgSlpTpCd  (csrVO.getSlpTpCd  ());
			csrVO.setOrgSlpFuncCd(csrVO.getSlpFuncCd());
			csrVO.setOrgSlpOfcCd (csrVO.getSlpOfcCd ());
			csrVO.setOrgSlpIssDt (csrVO.getSlpIssDt ());
			csrVO.setOrgSlpSerNo (csrVO.getSlpSerNo ());
			csrVO.setSlpIssDt    (JSPUtil.getKST("yyyyMMdd"));
			csrVO.setSlpSerNo    (slpSerNo);
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
			
			if ("06".equals(csrVO.getSlpTpCd())){
				if ("S".equals(csrVO.getSlpFuncCd())){
					csrVO.setSlpFuncCd("C");
					csrVO.setCsrTpCd  ("CREDIT");
				}else{
					csrVO.setSlpFuncCd("S");
					csrVO.setCsrTpCd  ("STANDARD");
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
			jooStlCmbVO.setSlpIssDt (csrVO.getSlpIssDt ());
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
				
				jooSlipVO.setSlpIssDt  (csrVO.getSlpIssDt ());
				jooSlipVO.setSlpSerNo  (csrVO.getSlpSerNo ());
				jooSlipVO.setSlpFuncCd (csrVO.getSlpFuncCd());
				jooSlipVO.setCsrLoclAmt((Double.parseDouble(jooSlipVO.getCsrLoclAmt())*-1)+"");
				//jooSlipVO.setCsrUsdAmt ((Double.parseDouble(jooSlipVO.getCsrUsdAmt ())*-1)+"");
				
				//결재선지정에 넣을 자료
				if ("DR".equals(jooSlipVO.getDrCrCd())){
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
	 * InvHdrVO, InvDtrbVO로 InvIfVO를 생성한다.
	 * @param InvIfVO invIfVO
	 * @param InvHdrVO invHdrVO
	 * @param InvDtrbVO invDtrbVO
	 * @param int totCnt
	 * @param int inx
	 * @throws EventException
	 */
//	private void setInvIfVO(InvIfVO invIfVO, InvHdrVO invHdrVO, InvDtrbVO invDtrbVO, int totCnt, int inx) throws EventException{
//		try{
//			invIfVO.setApPgmNo          ("ESDJOOXXXYYYYMMDD");
//			invIfVO.setInvSeq           ("1");
//			invIfVO.setTtlRowKnt        (totCnt+"");
//			invIfVO.setRowKnt           (inx+"");
//			invIfVO.setHdrCsrNo         (invHdrVO .getCsrNo            ());
//			invIfVO.setHdrCsrTpCd       (invHdrVO .getCsrTpCd          ());
//			invIfVO.setHdrInvDt         (invHdrVO .getInvDt            ());
//			invIfVO.setHdrInvTermDt     (invHdrVO .getInvTermDt        ());
//			invIfVO.setHdrGlDt          (invHdrVO .getGlDt             ());
//			invIfVO.setHdrVndrNo        (invHdrVO .getVndrNo           ());
//			invIfVO.setHdrCsrAmt        (invHdrVO .getCsrAmt           ());
//			invIfVO.setHdrPayAmt        (invHdrVO .getPayAmt           ());
//			invIfVO.setHdrPayDt         (invHdrVO .getPayDt            ());
//			invIfVO.setHdrCsrCurrCd     (invHdrVO .getCsrCurrCd        ());
//			invIfVO.setHdrVndrTermNm    (invHdrVO .getVndrTermNm       ());
//			invIfVO.setHdrInvDesc       (invHdrVO .getInvDesc          ());
//			invIfVO.setHdrAttrCateNm    (invHdrVO .getAttrCateNm       ());
//			invIfVO.setHdrAttrCtnt1     (invHdrVO .getAttrCtnt1        ());
//			invIfVO.setHdrAttrCtnt2     (invHdrVO .getAttrCtnt2        ());
//			invIfVO.setHdrAttrCtnt3     (invHdrVO .getAttrCtnt3        ());
//			invIfVO.setHdrAttrCtnt4     (invHdrVO .getAttrCtnt4        ());
//			invIfVO.setHdrAttrCtnt5     (invHdrVO .getAttrCtnt5        ());
//			invIfVO.setHdrAttrCtnt6     (invHdrVO .getAttrCtnt6        ());
//			invIfVO.setHdrAttrCtnt7     (invHdrVO .getAttrCtnt7        ());
//			invIfVO.setHdrAttrCtnt8     (invHdrVO .getAttrCtnt8        ());
//			invIfVO.setHdrAttrCtnt9     (invHdrVO .getAttrCtnt9        ());
//			invIfVO.setHdrAttrCtnt10    (invHdrVO .getAttrCtnt10       ());
//			invIfVO.setHdrAttrCtnt11    (invHdrVO .getAttrCtnt11       ());
//			invIfVO.setHdrAttrCtnt12    (invHdrVO .getAttrCtnt12       ());
//			invIfVO.setHdrAttrCtnt13    (invHdrVO .getAttrCtnt13       ());
//			invIfVO.setHdrAttrCtnt14    (invHdrVO .getAttrCtnt14       ());
//			invIfVO.setHdrAttrCtnt15    (invHdrVO .getAttrCtnt15       ());
//			invIfVO.setHdrGloAttrCtnt1  (invHdrVO .getGloAttrCtnt1     ());
//			invIfVO.setHdrGloAttrCtnt2  (invHdrVO .getGloAttrCtnt2     ());
//			invIfVO.setHdrGloAttrCtnt3  (invHdrVO .getGloAttrCtnt3     ());
//			invIfVO.setHdrGloAttrCtnt4  (invHdrVO .getGloAttrCtnt4     ());
//			invIfVO.setHdrGloAttrCtnt5  (invHdrVO .getGloAttrCtnt5     ());
//			invIfVO.setHdrGloAttrCtnt6  (invHdrVO .getGloAttrCtnt6     ());
//			invIfVO.setHdrGloAttrCtnt7  (invHdrVO .getGloAttrCtnt7     ());
//			invIfVO.setHdrGloAttrCtnt8  (invHdrVO .getGloAttrCtnt8     ());
//			invIfVO.setHdrGloAttrCtnt9  (invHdrVO .getGloAttrCtnt9     ());
//			invIfVO.setHdrGloAttrCtnt10 (invHdrVO .getGloAttrCtnt10    ());
//			invIfVO.setHdrGloAttrCtnt11 (invHdrVO .getGloAttrCtnt11    ());
//			invIfVO.setHdrGloAttrCtnt12 (invHdrVO .getGloAttrCtnt12    ());
//			invIfVO.setHdrGloAttrCtnt13 (invHdrVO .getGloAttrCtnt13    ());
//			invIfVO.setHdrGloAttrCtnt14 (invHdrVO .getGloAttrCtnt14    ());
//			invIfVO.setHdrGloAttrCtnt15 (invHdrVO .getGloAttrCtnt15    ());
//			invIfVO.setHdrGloAttrCtnt16 (invHdrVO .getGloAttrCtnt16    ());
//			invIfVO.setHdrGloAttrCtnt17 (invHdrVO .getGloAttrCtnt17    ());
//			invIfVO.setHdrGloAttrCtnt18 (invHdrVO .getGloAttrCtnt18    ());
//			invIfVO.setHdrSrcCtnt       (invHdrVO .getSrcCtnt          ());
//			invIfVO.setHdrPayMzdLuCd    (invHdrVO .getPayMzdLuCd       ());
//			invIfVO.setHdrPayGrpLuCd    (invHdrVO .getPayGrpLuCd       ());
//			invIfVO.setHdrCoaCoCd       (invHdrVO .getCoaCoCd          ());
//			invIfVO.setHdrCoaRgnCd      (invHdrVO .getCoaRgnCd         ());
//			invIfVO.setHdrCoaCtrCd      (invHdrVO .getCoaCtrCd         ());
//			invIfVO.setHdrCoaAcctCd     (invHdrVO .getCoaAcctCd        ());
//			invIfVO.setHdrCoaVvdCd      (invHdrVO .getCoaVvdCd         ());
//			invIfVO.setHdrCoaInterCoCd  (invHdrVO .getCoaInterCoCd     ());
//			invIfVO.setHdrCoaFtuN1stCd  (invHdrVO .getCoaFtuN1stCd     ());
//			invIfVO.setHdrCoaFtuN2ndCd  (invHdrVO .getCoaFtuN2ndCd     ());
//			invIfVO.setHdrPpdNo         (invHdrVO .getPpdNo            ());
//			invIfVO.setHdrPpdDtrbNo     (invHdrVO .getPpdDtrbNo        ());
//			invIfVO.setHdrPpdAplyAmt    (invHdrVO .getPpdAplyAmt       ());
//			invIfVO.setHdrPpdGlDt       (invHdrVO .getPpdGlDt          ());
//			invIfVO.setHdrAproFlg       (invHdrVO .getAproFlg          ());
//			invIfVO.setHdrTaxDeclFlg    (invHdrVO .getTaxDeclFlg       ());
//			invIfVO.setHdrErrCsrNo      (invHdrVO .getErrCsrNo         ());
//			invIfVO.setHdrIfFlg         (invHdrVO .getIfFlg            ());
//			invIfVO.setHdrIfDt          (invHdrVO .getIfDt             ());
//			invIfVO.setHdrIfErrRsn      (invHdrVO .getIfErrRsn         ());
//			invIfVO.setHdrPpayAplyFlg   (invHdrVO .getPpayAplyFlg      ());
//			invIfVO.setHdrTjOfcCd       (invHdrVO .getTjOfcCd          ());
//			invIfVO.setHdrActXchRt      (invHdrVO .getActXchRt         ());
//			invIfVO.setHdrImpErrFlg     (invHdrVO .getImpErrFlg        ());
//			invIfVO.setHdrRcvErrFlg     (invHdrVO .getRcvErrFlg        ());
//			invIfVO.setHdrTaxCurrXchFlg (invHdrVO .getTaxCurrXchFlg    ());
//			invIfVO.setHdrUsrEml        (invHdrVO .getUsrEml           ());
//			invIfVO.setHdrImpErrRsn     (invHdrVO .getImpErrRsn        ());
//			invIfVO.setHdrRcvErrRsn     (invHdrVO .getRcvErrRsn        ());
//			invIfVO.setHdrFtuUseCtnt1   (invHdrVO .getFtuUseCtnt1      ());
//			invIfVO.setHdrFtuUseCtnt2   (invHdrVO .getFtuUseCtnt2      ());
//			invIfVO.setHdrFtuUseCtnt3   (invHdrVO .getFtuUseCtnt3      ());
//			invIfVO.setHdrFtuUseCtnt4   (invHdrVO .getFtuUseCtnt4      ());
//			invIfVO.setHdrFtuUseCtnt5   (invHdrVO .getFtuUseCtnt5      ());
//			invIfVO.setCsrNo            (invDtrbVO.getCsrNo            ());
//			invIfVO.setLineSeq          (invDtrbVO.getLineSeq          ());
//			invIfVO.setLineNo           (invDtrbVO.getLineNo           ());
//			invIfVO.setLineTpLuCd       (invDtrbVO.getLineTpLuCd       ());
//			invIfVO.setInvAmt           (invDtrbVO.getInvAmt           ());
//			invIfVO.setInvDesc          (invDtrbVO.getInvDesc          ());
//			invIfVO.setInvTaxCd         (invDtrbVO.getInvTaxCd         ());
//			invIfVO.setDtrbCoaCoCd      (invDtrbVO.getDtrbCoaCoCd      ());
//			invIfVO.setDtrbCoaRgnCd     (invDtrbVO.getDtrbCoaRgnCd     ());
//			invIfVO.setDtrbCoaCtrCd     (invDtrbVO.getDtrbCoaCtrCd     ());
//			invIfVO.setDtrbCoaAcctCd    (invDtrbVO.getDtrbCoaAcctCd    ());
//			invIfVO.setDtrbCoaVvdCd     (invDtrbVO.getDtrbCoaVvdCd     ());
//			invIfVO.setDtrbCoaInterCoCd (invDtrbVO.getDtrbCoaInterCoCd ());
//			invIfVO.setDtrbCoaFtuN1stCd (invDtrbVO.getDtrbCoaFtuN1stCd ());
//			invIfVO.setDtrbCoaFtuN2ndCd (invDtrbVO.getDtrbCoaFtuN2ndCd ());
//			invIfVO.setAttrCateNm       (invDtrbVO.getAttrCateNm       ());
//			invIfVO.setAttrCtnt1        (invDtrbVO.getAttrCtnt1        ());
//			invIfVO.setAttrCtnt2        (invDtrbVO.getAttrCtnt2        ());
//			invIfVO.setAttrCtnt3        (invDtrbVO.getAttrCtnt3        ());
//			invIfVO.setAttrCtnt4        (invDtrbVO.getAttrCtnt4        ());
//			invIfVO.setAttrCtnt5        (invDtrbVO.getAttrCtnt5        ());
//			invIfVO.setAttrCtnt6        (invDtrbVO.getAttrCtnt6        ());
//			invIfVO.setAttrCtnt7        (invDtrbVO.getAttrCtnt7        ());
//			invIfVO.setAttrCtnt8        (invDtrbVO.getAttrCtnt8        ());
//			invIfVO.setAttrCtnt9        (invDtrbVO.getAttrCtnt9        ());
//			invIfVO.setAttrCtnt10       (invDtrbVO.getAttrCtnt10       ());
//			invIfVO.setAttrCtnt11       (invDtrbVO.getAttrCtnt11       ());
//			invIfVO.setAttrCtnt12       (invDtrbVO.getAttrCtnt12       ());
//			invIfVO.setAttrCtnt13       (invDtrbVO.getAttrCtnt13       ());
//			invIfVO.setAttrCtnt14       (invDtrbVO.getAttrCtnt14       ());
//			invIfVO.setAttrCtnt15       (invDtrbVO.getAttrCtnt15       ());
//			invIfVO.setBkgNo            (invDtrbVO.getBkgNo            ());
//			invIfVO.setCntrTpszCd       (invDtrbVO.getCntrTpszCd       ());
//			invIfVO.setActVvdCd         (invDtrbVO.getActVvdCd         ());
//			invIfVO.setPlnSctrDivCd     (invDtrbVO.getPlnSctrDivCd     ());
//			invIfVO.setSoCrrCd          (invDtrbVO.getSoCrrCd          ());
//			invIfVO.setYdCd             (invDtrbVO.getYdCd             ());
//			invIfVO.setFtuUseCtnt1      (invDtrbVO.getFtuUseCtnt1      ());
//			invIfVO.setFtuUseCtnt2      (invDtrbVO.getFtuUseCtnt2      ());
//			invIfVO.setFtuUseCtnt3      (invDtrbVO.getFtuUseCtnt3      ());
//			invIfVO.setFtuUseCtnt4      (invDtrbVO.getFtuUseCtnt4      ());
//			invIfVO.setFtuUseCtnt5      (invDtrbVO.getFtuUseCtnt5      ());
//			invIfVO.setSndFlg           ("");
//			invIfVO.setCreDt            ("");
//			invIfVO.setCreUsrId         (invDtrbVO.getCreUsrId         ());
//			invIfVO.setEaiEvntDt        ("");
//			invIfVO.setEstmErrRsn       ("");
//			invIfVO.setTrspSoTpCd       ("");
//			invIfVO.setSoOfcCtyCd       ("");
//			invIfVO.setSoSeq            ("");
//			invIfVO.setCgoTpCd          ("");			                                          
//		} catch (Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("JOO10007", new String[]{"VO Transfer", "SET"}).getMessage(), ex);
//		}
//	}
    /**
     * 
     * AR정보를 조회합니다.<br>
     *
     * @param  ArDataInqVO arDataInqVO
     * @throws EventException
     * @return List<ArDataInqVO>
     * @author jang kang cheol
     */
    public List<ArDataInqVO> searchARDataInquiry(ArDataInqVO arDataInqVO ) throws EventException{
        try {
            return dbDao.searchARDataInquiry(arDataInqVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Ar Data Inquiry", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Ar Data Inquiry", "Retrieve"}).getMessage(), ex);
        }       
    }
    /**
     * 
     * AR_total정보를 조회합니다.<br>
     *
     * @param  ArDataInqVO arDataInqVO
     * @throws EventException
     * @return List<ArDataInqVO>
     * @author jang kang cheol
     */
    public List<ArDataInqVO> searchARDataInquirySum(ArDataInqVO arDataInqVO ) throws EventException{
        try {
            return dbDao.searchARDataInquirySum(arDataInqVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Ar Data Inquiry", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"Ar Data Inquiry", "Retrieve"}).getMessage(), ex);
        }       
    }
    
    
    
    /**
     * AR정보중 Disabled된 VVD 정보를 조회합니다.<br>
     * @param  ArDisabledVVDVO arDisabledVVDVO
     * @return List<ArDisabledVVDVO>
     * @throws EventException
     */
    public List<ArDisabledVVDVO> searchARDisabledVVD(ArDisabledVVDVO arDisabledVVDVO)  throws EventException {
        try {
             return dbDao.searchARDisabledVVD(arDisabledVVDVO);
        } catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"AR Disabled VVD", "Retrieve"}).getMessage(), ex);
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("JOO10007", new String[]{"AR Disabled VVD", "Retrieve"}).getMessage(), ex);
        }
    }
 

	/**
	 * AP I/F Error난 list를 조회한다.
	 * @param CsrVO csrVO
	 * @return List<ApIfErrVO>
	 * @throws EventException
	 */
	public List<ApIfErrVO> searchApIfErrList(CsrVO csrVO) throws EventException {
		try {
			return dbDao.searchApIfErrList(csrVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AP I/F Error List for Reject", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"AP I/F Error List for Reject", "Retrieve"}).getMessage(), ex);
		}
	}
    
	/**
	 * Reject전표생성시
	 * 
	 * ★ Interface Error인 경우
	 * 1. JOO_STL_CMB_DTL 조회
	 * 2. JOO_TAX_DTL삭제
	 * 3. JOO_TAX 삭제
	 * 4. JOO_SLIP 삭제
	 * 5. JOO_CSR 삭제
	 * 6. JOO_STL_CMB_DTL 삭제
	 * 7. JOO_STL_CMB 삭제
	 * 
	 * ★ ERP Reject 된 경우 
	 * 1. JOO_STL_CMB.RJCT_CMB_FLG = 'Y' UPDATE
	 * 2. JOO_STL_CMB_DTL, JOO_SLIP 조회
	 * 3. JOO_SLP_SEQ INSERT OR UPDATE (SLP_SER_NO 채번)
	 * 4. JOO_CSR INSERT
	 * 5. JOO_STL_CMB INSERT
	 * 6. JOO_STL_CMB_DTL INSERT
	 * 7. JOO_SLIP INSERT
	 * JOO_SETTLEMENT 의 CMB_CFM_FLG = 'N'으로 UPDATE하기 위해 JOO_STL_CMB_DTL LIST를 RETURN한다.
	 * @param CsrVO csrVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @return List<JooStlCmbDtlVO>
	 * @throws EventException
	 */
	public List<JooStlCmbDtlVO> rejectConsultation(CsrVO csrVO, SignOnUserAccount signOnUserAccount) throws EventException{
		List<JooStlCmbDtlVO> list = null;

		try {
			/*###############################################
			 * Interface Error인 경우
			 *###############################################*/
			if ("E".equals(csrVO.getIfFlg())){
				/***********************************************
				 * 1. JOO_SETTLEMENT.CMB_CFM_FLG를 N으로 UPDATE하기 위해 JOO_STL_CMB_DTL정보를 조회한다.
				 ***********************************************/
				list = dbDao.searchJooStlCmbDtlForReverse(csrVO);
				
				/***********************************************
				 * 2. JOO_TAX_DTL을 삭제한다.
				 ***********************************************/
				dbDao.removeJooTaxDtlForIFE(csrVO);

				/***********************************************
				 * 3. JOO_TAX을 삭제한다.
				 ***********************************************/
				dbDao.removeJooTaxForIFE(csrVO);

				/***********************************************
				 * 4. JOO_SLIP을 삭제한다.
				 ***********************************************/
				dbDao.removeJooSlipForIFE(csrVO);
				
				/***********************************************
				 * 5. JOO_CSR을 삭제한다.
				 ***********************************************/
				dbDao.removeJooCsrForIFE(csrVO);
				
				/***********************************************
				 * 6. JOO_STL_CMB_DTL을 삭제한다.
				 ***********************************************/
				dbDao.removeJooStlCmbDtlForIFE(csrVO);

				/***********************************************
				 * 7. JOO_STL_CMB을 삭제한다.
				 ***********************************************/
				dbDao.removeJooStlCmbForIFE(csrVO);
				
			/*###############################################
			 * ERP Reject 인 경우
			 *###############################################*/
			}else{
				/******************************************
				 * 1. 기존 JOO_STL_CMB.RJCT_CMB_FLG를 Y로 UPDATE한다.
				 *******************************************/
				csrVO.setUpdUsrId(signOnUserAccount.getUsr_id());
				csrVO.setRvsCmbFlg ("N");
				csrVO.setRjctCmbFlg("Y");
	
				dbDao.modifyJooStlCmbByReverse(csrVO);
				
				/******************************************
				 * 2. JOO_SETTLEMENT.CMB_CFM_FLG를 N으로 UPDATE하기 위해 JOO_STL_CMB_DTL정보를 조회한다.
				 * 2-1. JOO_SLIP을 copy하기 위해 조회한다.
				 *******************************************/
				list = dbDao.searchJooStlCmbDtlForReverse(csrVO);
				List<JooSlipVO> list1 = dbDao.searchJooSlipForReverse(csrVO);
	
				/******************************************
				 * 3. 새로운 CSR 번호를 채번하여 JOO_SLP_SEQ에 입력 또는 수정한다.
				 *******************************************/
				SlipProcessVO slipProcessVO = new SlipProcessVO();
				
				slipProcessVO.setSlpTpCd  (csrVO.getSlpTpCd  ());
				if ("06".equals(csrVO.getSlpTpCd())){
					if ("S".equals(csrVO.getSlpFuncCd())){
						slipProcessVO.setSlpFuncCd("C");
					}else{
						slipProcessVO.setSlpFuncCd("S");
					}
				}
				slipProcessVO.setSlpOfcCd (csrVO.getSlpOfcCd ());
				slipProcessVO.setSlpIssDt (JSPUtil.getKST("yyyyMMdd"));
	
				String slpSerNo = dbDao.searchNextSlpSerNo(slipProcessVO);
				
				slipProcessVO.setSlpSerNo(slpSerNo);
				slipProcessVO.setIssuerId(signOnUserAccount.getUsr_id());
				//JOO_SLP_SEQ에 한 건을 입력한다.
				if ("00001".equals(slpSerNo)){
					dbDao.addJooSlpSeq(slipProcessVO);
				//slp_tp_cd, slp_func_cd, slp_ofc_cd, slp_iss_dt로 있는 data면 update한다.
				}else{
					dbDao.modifyJooSlpSeq(slipProcessVO);
				}
				/******************************************
				 * 4. 새로운 REJECT 정보를 JOO_CSR에 INSERT 
				 *******************************************/
				csrVO.setCreUsrId    (signOnUserAccount.getUsr_id());
				csrVO.setOrgSlpTpCd  (csrVO.getSlpTpCd  ());
				csrVO.setOrgSlpFuncCd(csrVO.getSlpFuncCd());
				csrVO.setOrgSlpOfcCd (csrVO.getSlpOfcCd ());
				csrVO.setOrgSlpIssDt (csrVO.getSlpIssDt ());
				csrVO.setOrgSlpSerNo (csrVO.getSlpSerNo ());
				csrVO.setSlpIssDt    (JSPUtil.getKST("yyyyMMdd"));
				csrVO.setSlpSerNo    (slpSerNo);
				csrVO.setCsrDesc     ("REJECT CSR("+csrVO.getCsrDesc()+")");
				csrVO.setAproFlg     ("Y"); //임의로 APROVAL 처리한다.
				csrVO.setAproDt      (JSPUtil.getKST("yyyyMMdd"));
				csrVO.setCxlFlg      ("N");
				csrVO.setCxlDesc     ("");
				csrVO.setDdctFlg     ("N");
				csrVO.setDdctLoclAmt ("0");
				csrVO.setDdctDesc    ("");
				csrVO.setRqstLoclAmt ("0");
				csrVO.setRvsCsrFlg   ("N");
				csrVO.setRjctCsrFlg  ("Y");
				if ("06".equals(csrVO.getSlpTpCd())){
					if ("S".equals(csrVO.getSlpFuncCd())){
						csrVO.setSlpFuncCd("C");
						csrVO.setCsrTpCd  ("CREDIT");
					}else{
						csrVO.setSlpFuncCd("S");
						csrVO.setCsrTpCd  ("STANDARD");
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
				jooStlCmbVO.setSlpIssDt (csrVO.getSlpIssDt ());
				jooStlCmbVO.setSlpSerNo (csrVO.getSlpSerNo ());
				jooStlCmbVO.setRvsCmbFlg("N");
				jooStlCmbVO.setRjctCmbFlg("Y");
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
				
				while(iterator.hasNext()){
					JooSlipVO jooSlipVO = (JooSlipVO)iterator.next();
					
					jooSlipVO.setSlpIssDt  (csrVO.getSlpIssDt ());
					jooSlipVO.setSlpSerNo  (csrVO.getSlpSerNo ());
					jooSlipVO.setSlpFuncCd (csrVO.getSlpFuncCd());
					jooSlipVO.setCsrLoclAmt((Double.parseDouble(jooSlipVO.getCsrLoclAmt())*-1)+"");
					//jooSlipVO.setCsrUsdAmt ((Double.parseDouble(jooSlipVO.getCsrUsdAmt ())*-1)+"");
	
					//VVD가 없는 AP의 CR 데이터는 EFF_DT를 조회할 수 없으므로 CSR의 EFF_DT를 넣는다.
					if (jooSlipVO.getVslCd() == null || "".equals(jooSlipVO.getVslCd())){
						jooSlipVO.setEffDt(csrVO.getEffDt());
						jooSlipVO.setVvdCxlFlg("N");
					}
					jooSlipVO.setCreUsrId(signOnUserAccount.getUsr_id());
					dbDao.addJooSlpByReverse(jooSlipVO);
				}
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reject Slip", "Creation"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Reject Slip", "Creation"}).getMessage(), ex);
		}
		
		return list;
	}

	/**
	 * Settlement되었는데 Combined 되지 않거나 Comined되었으나 CSR생성되지 않은 data를 조회한다.
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
	 * CSR의 Office code를 distinct로 조회한다.
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
	 * 결재라인 setting 하는 Process
	 * @param SlipProcessVO slipProcessVO
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	private void createCSREPApproval(SlipProcessVO slipProcessVO, SignOnUserAccount signOnUserAccount) throws EventException {
		String  sCsrNo        = slipProcessVO.getSlpTpCd()
								+ slipProcessVO.getSlpFuncCd()
								+ slipProcessVO.getSlpOfcCd ()
								+ slipProcessVO.getSlpIssDt ().substring(2)
								+ slipProcessVO.getSlpSerNo ();
		
		String  sTotalAmt     = slipProcessVO.getTotAmount ();
		String  sCostOfcCd    = slipProcessVO.getSlpOfcCd  ();
		String  sUsrNm        = signOnUserAccount.getUsr_nm();
		
		String  sCreUsrId     = signOnUserAccount.getUsr_id();
		String  sAproStep     = slipProcessVO.getAproStep  ();
		String  sOfcNm        = signOnUserAccount.getOfc_eng_nm();
		String  sVndrSeq      = slipProcessVO.getCustVndrSeq  ();
		String  sCurrCd       = slipProcessVO.getLoclCurrCd   ();
		String  sCntCd        = ("06".equals(slipProcessVO.getSlpTpCd())?"1":slipProcessVO.getMaxRows()+""); // Invoice 숫자? AP = 1, AR BL# 갯수? <= 권상준수석
		String  sPaymentDueDt = slipProcessVO.getRqstDt       ();
		String  sInvSubSysCd  = "JOO";				
		String  sAproKndCd    = ("06".equals(slipProcessVO.getSlpTpCd())?"CSR":"REV"); //AP면 CSR, AR이면 REV

		try {
			ApprovalUtil util = new ApprovalUtil();

			// COM_APRO_RQST_HDR
			ComAproRqstHdrVO header = new ComAproRqstHdrVO();
			header.setSubSysCd (sInvSubSysCd);
			header.setAproKndCd(sAproKndCd); 
			header.setRqstOfcCd(sCostOfcCd);
			header.setRqstOfcNm(sOfcNm);
			header.setRqstUsrJbTitNm(""); // 직책
			header.setRqstUsrId(sCreUsrId);
			header.setRqstUsrNm(sUsrNm);
			header.setCreUsrId (sCreUsrId); 

			// COM_APRO_RQST_ROUT 
			//String apro_step = com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute("SELHO", "SCE");
			ComAproRqstRoutVO[] route = util.convertApprovalRoute(sAproStep);

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

			// 결재 등록
			util.saveCsrApro(header, route, csr);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Approval Line", "Save"}).getMessage(), ex);
		}
	}

	/**
	 * CSR No.로 Approval 대상 CSR정보를 조회한다.
	 * FNS_JOO_0068 에서 사용한다. (Reverse가능, Approval Step과 무관하게 query)
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
     * BackEndJob의 수행결과를 조회한다.
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
	 * GW문서를 저장한다( 수정)<br>
	 * 
	 * @param csrNo String
	 * @param updUsrId String 
	 * @param slipProcessVOs  SlipProcessVO[]
	 * @exception EventException
	 */
	public void manageGW(String csrNo, String updUsrId, SlipProcessVO[] slipProcessVOs) throws EventException {

		try {	

			SlipProcessVO slipProcessVO = new SlipProcessVO();
			CsrVO  csrVO = new  CsrVO();
			
			csrVO.setCsrNo(csrNo);
			csrVO.setUpdUsrId(updUsrId);			
			if(slipProcessVOs != null){
				slipProcessVO = slipProcessVOs[0];
				csrVO.setAgmtDocNo(slipProcessVO.getAgmtDocNo());
				csrVO.setAgmtDocDesc(slipProcessVO.getAgmtDocDesc());				
			}else{
				csrVO.setAgmtDocNo("");
				csrVO.setAgmtDocDesc("");				
			}
			
			dbDao.manageGW(csrVO);
						
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("JOO10007",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007",new String[]{}).getMessage(), ex);
		}
	}	
	
	/**
	 * CSR No.로 GW Contract Link 목록 조회한다.<br>
	 * 
	 * @param String csrNo
	 * @return List<AgmtDocVO>
	 * @throws EventException
	 */
	public List<AgmtDocVO> searchGWDoc(String csrNo) throws EventException {
		try {
			return dbDao.searchGWDoc(csrNo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"GW Contract Linkl", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"GW Contract Linkl", "Retrieve"}).getMessage(), ex);
		}
	}	
	
	/**
	 * GW Contract Link 목록 정보를 저장한다.
	 *  
	 * @param String csrNo
	 * @param AgmtDocVO[] agmtDocVOs
	 * @param SignOnUserAccount signOnUserAccount
	 * @throws EventException
	 */
	public void manageGWDoc(String csrNo, AgmtDocVO[] agmtDocVOs, SignOnUserAccount signOnUserAccount) throws EventException{
		try {
			List<AgmtDocVO> insertVoList = new ArrayList<AgmtDocVO>();
			List<AgmtDocVO> updateVoList = new ArrayList<AgmtDocVO>();
			List<AgmtDocVO> deleteVoList = new ArrayList<AgmtDocVO>();
			
			for (int inx=0; inx<agmtDocVOs.length; inx++){
				if ("I".equals(agmtDocVOs[inx].getIbflag())){
					agmtDocVOs[inx].setCsrNo(csrNo);
					agmtDocVOs[inx].setCreUsrId(signOnUserAccount.getUsr_id());
					agmtDocVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					insertVoList.add(agmtDocVOs[inx]);
				}else if("U".equals(agmtDocVOs[inx].getIbflag())){
					agmtDocVOs[inx].setCsrNo(csrNo);					
					agmtDocVOs[inx].setUpdUsrId(signOnUserAccount.getUsr_id());
					updateVoList.add(agmtDocVOs[inx]);
				}else if("D".equals(agmtDocVOs[inx].getIbflag())){
					agmtDocVOs[inx].setCsrNo(csrNo);					
					deleteVoList.add(agmtDocVOs[inx]);
				}
			}

			if ( insertVoList.size() > 0 ) {
				dbDao.addGWDoc(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyGWDoc(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeGWDoc(deleteVoList);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"GW Contract Link", "Save"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"GW Contract Link", "Save"}).getMessage(), ex);
		}
	}
	
	/**
	 * 기 정산된 데이타가 존재하는 경우 Double Click시 History 조회
	 * @param CmbConditionVO cmbConditionVO
	 * @return CombinedGrpVO
	 * @throws EventException
	 */
	public List<CombinedVO> searchCombinedDupList(CmbConditionVO cmbConditionVO) throws EventException {
		try {
			return dbDao.searchCombinedDupList(cmbConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"VVD ITEM DUP History", "Retrieve"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"VVD ITEM DUP History", "Retrieve"}).getMessage(), ex);
		}
	}
	
	/**
	 * CSR cancel 처리한다.
	 * @param CsrVO csrVO
	 * @throws EventException
	 */
	public void manageCsrCancel(CsrVO csrVO) throws EventException{
		
		try {
			dbDao.removeComAproRqstHdr(csrVO);		
			dbDao.removeComAproRqstRout(csrVO);
			dbDao.removeComAproCsrDtl(csrVO);
			
			dbDao.modifyCsr(csrVO);					
			dbDao.removeSlipByCsr          (csrVO);
			dbDao.removeTaxDtlByCsr        (csrVO);
			dbDao.removeTaxByCsr           (csrVO);				
			dbDao.modifyJooStlCmbClearCsrNo(csrVO);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Combining", "Processing"}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("JOO10007", new String[]{"Combining", "Processing"}).getMessage(), ex);
		}
		
	}
}