/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MnrAdvanceAuditBCImpl
*@FileTitle : Equipment Auto Audit
*Open Issues :   
*Change history :
*@LastModifyDate : 2015-04-13
*@LastModifier : Jeong-Min Park
*@LastVersion : 1.0
* 2015-04-13 Jeong-Min Park
* 1.0 筌ㅼ뮇�겧 占쎄문占쎄쉐
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.basic;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration.MnrAdvanceAuditDBDAO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.AuditMnrInvoiceVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.CleaningContainerInquiryDetailVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MNRPreAuditCriterionVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrChargeDetailListVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrChargeListVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrGeneralCodeVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrInvoiceChargeINVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrMovementEmailSendHistoryVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrMovementVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrReportINVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MultipleRepairCNTRByAreaDetailVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MultipleRepairCNTRByPeriodDetailVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.util.ScheduleUtil;

/**
 * MnrAdvanceAuditBCImpl PDTO(Data Transfer Object including Parameters)<br>
 * 
 * @author Jeong-Min Park
 * @see EventResponse 李몄“
 * @since J2EE 1.4
 */
public class MnrAdvanceAuditBCImpl extends BasicCommandSupport implements MnrAdvanceAuditBC {
	
	// Database Access Object
	private transient MnrAdvanceAuditDBDAO dbDao = null;
	
	/**
	 * MnrAdvanceAuditBCImpl 揶쏆빘猿� 占쎄문占쎄쉐<br>
	 * MnrAdvanceAuditDBDAO 占쎄문占쎄쉐占쎈립占쎈뼄.<br>
	 */
	public MnrAdvanceAuditBCImpl() {
		dbDao = new MnrAdvanceAuditDBDAO();
	}
	
	/**
	 * MNR Invoice Charge History List
	 * 
	 * @category EDS_EAS_0360
	 * @param mnrInvoiceChargeINVO MNRInvoiceChargeINVO
	 * @param account
	 * @return String
	 * @throws EventException
	 */
	public List<MnrChargeListVO> searchMNRChargeList(MnrInvoiceChargeINVO mnrInvoiceChargeINVO, SignOnUserAccount account) throws EventException{
		try {
			return dbDao.searchPreAuditList(mnrInvoiceChargeINVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	//20160311 BackEndJob 제거-->
//	public String searchMNRChargeList(MnrInvoiceChargeINVO mnrInvoiceChargeINVO, SignOnUserAccount account) throws EventException {
//		
//		try {
//			
//			MnrAdvanceAuditBackEndJob backEndJob = new MnrAdvanceAuditBackEndJob();
//			backEndJob.setJobType("MNR_ADVANCE_AUDIT_AUTO_AUDIT");
//			backEndJob.setMnrInvoiceChargeINVO(mnrInvoiceChargeINVO);
//			
//			BackEndJobManager backEndJobManager = new BackEndJobManager();
//			
//			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "MNR_ADVANCE_AUDIT_AUTO_AUDIT BackEndJob");
//		} catch(Exception de) {
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
//	}
	//<--20160311 BackEndJob 제거
	/**
	 * MNR Invoice Charge Detail List 鈺곌퀬�돳.
	 * 
	 * @category EDS_EAS_0361
	 * @param mnrInvoiceChargeINVO MNRInvoiceChargeINVO
	 * @return List<MNRChargeDetailListVO>
	 * @throws EventException
	 */
	public List<MnrChargeDetailListVO> searchMNRChargeDetailList(MnrInvoiceChargeINVO mnrInvoiceChargeINVO) throws EventException {
		
		try {
			List<MnrChargeDetailListVO> list = dbDao.searchPreAuditDetailList(mnrInvoiceChargeINVO);
			return list;
			
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * MNR General Code List
	 * 
	 * @param mnrInvoiceChargeINVO
	 * @return List<MnrGeneralCodeVO>
	 * @throws EventException
	 */
	public List<MnrGeneralCodeVO> searchMnrGeneralCode(MnrInvoiceChargeINVO mnrInvoiceChargeINVO) throws EventException {
		
		try {
			List<MnrGeneralCodeVO> list = dbDao.searchMnrGeneralCode(mnrInvoiceChargeINVO);
			return list;
			
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Confirm MNR Invoice List
	 * 
	 * @param mnrChargeListVOS
	 * @param account
	 * @throws EventException
	 */
	public void manageMNRChargeList(MnrChargeListVO[] mnrChargeListVOS, SignOnUserAccount account) throws EventException {
		
		try {
			dbDao.manageMNRChargeList(mnrChargeListVOS, account);
			
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * searchMultipleRepairCNTRByAreaList
	 * 
	 * @param mnrReportINVO
	 * @param account
	 * @return String
	 * @throws EventException
	 */
	public String searchMultipleRepairCNTRByAreaList(MnrReportINVO mnrReportINVO, SignOnUserAccount account) throws EventException {
		try {
			MnrAdvanceAuditBackEndJob backEndJob = new MnrAdvanceAuditBackEndJob();
			backEndJob.setJobType("MNR_ADVANCE_AUDIT_MULTIPLE_REPAIR_CNTR_BY_AREA");
			backEndJob.setMnrReportINVO(mnrReportINVO);
			
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "MNR_ADVANCE_AUDIT_MULTIPLE_REPAIR_CNTR_BY_AREA BackEndJob");
		} catch(Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * searchMultipleRepairCNTRByAreaDetail
	 * 
	 * @param mnrReportINVO
	 * @return List<MultipleRepairCNTRByAreaDetailVO>
	 * @throws EventException
	 */
	public List<MultipleRepairCNTRByAreaDetailVO> searchMultipleRepairCNTRByAreaDetail(MnrReportINVO mnrReportINVO) throws EventException {
		try {
			List<MultipleRepairCNTRByAreaDetailVO> list = dbDao.searchMultipleRepairCNTRByAreaDetail(mnrReportINVO);
			return list;
			
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * searchMultipleRepairCNTRByPeriodList
	 * 
	 * @param mnrReportINVO
	 * @param account
	 * @return String
	 * @throws EventException
	 */
	public String searchMultipleRepairCNTRByPeriodList(MnrReportINVO mnrReportINVO, SignOnUserAccount account) throws EventException {
		try {
			MnrAdvanceAuditBackEndJob backEndJob = new MnrAdvanceAuditBackEndJob();
			backEndJob.setJobType("MNR_ADVANCE_AUDIT_MULTIPLE_REPAIR_CNTR_BY_PERIOD");
			backEndJob.setMnrReportINVO(mnrReportINVO);
			
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "MNR_ADVANCE_AUDIT_MULTIPLE_REPAIR_CNTR_BY_PERIOD BackEndJob");
		} catch(Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * searchMultipleRepairCNTRByPeriodDetail
	 * 
	 * @param mnrReportINVO
	 * @return List<MultipleRepairCNTRByPeriodDetailVO>
	 * @throws EventException
	 */
	public List<MultipleRepairCNTRByPeriodDetailVO> searchMultipleRepairCNTRByPeriodDetail(MnrReportINVO mnrReportINVO) throws EventException {
		try {
			List<MultipleRepairCNTRByPeriodDetailVO> list = dbDao.searchMultipleRepairCNTRByPeriodDetail(mnrReportINVO);
			return list;
			
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * searchCleaningContainerInquiryList
	 * 
	 * @param mnrReportINVO
	 * @param account
	 * @return String
	 * @throws EventException
	 */
	public String searchCleaningContainerInquiryList(MnrReportINVO mnrReportINVO, SignOnUserAccount account) throws EventException {
		try {
			MnrAdvanceAuditBackEndJob backEndJob = new MnrAdvanceAuditBackEndJob();
			backEndJob.setJobType("MNR_ADVANCE_AUDIT_CLEANING_CNTR_INQUIRY");
			backEndJob.setMnrReportINVO(mnrReportINVO);
			
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "MNR_ADVANCE_AUDIT_CLEANING_CNTR_INQUIRY BackEndJob");
			
		} catch(Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * searchCleaningContainerInquiryDetail
	 * 
	 * @param mnrReportINVO
	 * @return List<CleaningContainerInquiryDetailVO>
	 * @throws EventException
	 */
	public List<CleaningContainerInquiryDetailVO> searchCleaningContainerInquiryDetail(MnrReportINVO mnrReportINVO) throws EventException {
		try {
			List<CleaningContainerInquiryDetailVO> list = dbDao.searchCleaningContainerInquiryDetail(mnrReportINVO);
			return list;
			
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * searchCleaningContainerBKGList
	 * 
	 * @param mnrReportINVO
	 * @param account
	 * @return String
	 * @throws EventException
	 */
	public String searchCleaningContainerBKGList(MnrReportINVO mnrReportINVO, SignOnUserAccount account) throws EventException {
		try {
			MnrAdvanceAuditBackEndJob backEndJob = new MnrAdvanceAuditBackEndJob();
			backEndJob.setJobType("MNR_ADVANCE_AUDIT_CLEANING_CNTR_BKG");
			backEndJob.setMnrReportINVO(mnrReportINVO);
			
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "MNR_ADVANCE_AUDIT_CLEANING_CNTR_BKG BackEndJob");
			
		} catch(Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * MNR Pre-Audit Criterion By Error Code
	 * 
	 * @param mnrPreAuditCriterionVO
	 * @return List<MNRPreAuditCriterionVO>
	 * @throws EventException
	 */
	public List<MNRPreAuditCriterionVO> searchMnrPreAuditCriterionByErrorCode(MNRPreAuditCriterionVO mnrPreAuditCriterionVO) throws EventException {
		try {
			List<MNRPreAuditCriterionVO> list = dbDao.searchMNRPreAuditCriterionByErrorCode(mnrPreAuditCriterionVO);
			return list;
			
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * MNR Pre-Audit Criterion By Difference W/O & INV AMT
	 * 
	 * @param mnrPreAuditCriterionVO
	 * @return List<MNRPreAuditCriterionVO>
	 * @throws EventException
	 */
	public List<MNRPreAuditCriterionVO> searchMnrPreAuditCriterionByDifference(MNRPreAuditCriterionVO mnrPreAuditCriterionVO) throws EventException {
		// TODO Auto-generated method stub
		try {
			List<MNRPreAuditCriterionVO> list = dbDao.searchMNRPreAuditCriterionByDifference(mnrPreAuditCriterionVO);
			return list;
			
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * MNR Pre-Audit Criterion By Error Code
	 * 
	 * @param mnrPreAuditCriterionVO
	 * @param account
	 * @throws EventException
	 */
	public void deleteMnrPreAuditCriterionByErrorCode(MNRPreAuditCriterionVO mnrPreAuditCriterionVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.deleteMNRPreAuditCriterionByErrorCode(mnrPreAuditCriterionVO, account);
			
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
	}
	
	/**
	 * MNR Pre-Audit Criterion By Error Code
	 * 
	 * @param MNRPreAuditCriterionVO mnrPreAuditCriterionVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void insertMnrPreAuditCriterionByErrorCode(MNRPreAuditCriterionVO mnrPreAuditCriterionVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.insertMNRPreAuditCriterionByErrorCode(mnrPreAuditCriterionVO, account);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * MNR Pre-Audit Criterion By Error Code
	 * 
	 * @param MNRPreAuditCriterionVO mnrPreAuditCriterionVO
	 * @param SignOnUserAccount account
	 * @return String[] Validation 결과
	 * @throws EventException
	 */
	public String[] searchMNROfficeCodeForValidation(MNRPreAuditCriterionVO mnrPreAuditCriterionVO, SignOnUserAccount account) throws EventException {
		try {
			String[] string = dbDao.searchMNROfficeCodeForValidation(mnrPreAuditCriterionVO);
			return string;
			
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * MNR Pre-Audit Criterion By Error Code
	 * 
	 * @param mnrPreAuditCriterionVOs
	 * @param account
	 * @throws EventException
	 */
	public void updateMnrPreAuditCriterionByErrorCode(MNRPreAuditCriterionVO[] mnrPreAuditCriterionVOs, SignOnUserAccount account) throws EventException {
		try {
			dbDao.updateMNRPreAuditCriterionByErrorCode(mnrPreAuditCriterionVOs, account);
			
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
	}
	
	/**
	 * MNR Pre-Audit Criterion By Difference W/O & INV AMT
	 * 
	 * @param mnrPreAuditCriterionVO
	 * @param account
	 * @throws EventException
	 */
	public void deleteMnrPreAuditCriterionByDifference(MNRPreAuditCriterionVO mnrPreAuditCriterionVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.deleteMNRPreAuditCriterionByDifference(mnrPreAuditCriterionVO, account);
			
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
	}
	
	/**
	 * MNR Pre-Audit Criterion By Difference W/O & INV AMT
	 * 
	 * @param mnrPreAuditCriterionVO
	 * @param account
	 * @throws EventException
	 */
	public void insertMnrPreAuditCriterionByDifference(MNRPreAuditCriterionVO mnrPreAuditCriterionVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.insertMNRPreAuditCriterionByDifference(mnrPreAuditCriterionVO, account);
			
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
	}
	
	/**
	 * MNR Pre-Audit Criterion By Difference W/O & INV AMT
	 * 
	 * @param mnrPreAuditCriterionVOs
	 * @param account
	 * @throws EventException
	 */
	public void updateMnrPreAuditCriterionByDifference(MNRPreAuditCriterionVO[] mnrPreAuditCriterionVOs, SignOnUserAccount account) throws EventException {
		try {
			dbDao.updateMNRPreAuditCriterionByDifference(mnrPreAuditCriterionVOs, account);
			
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
	}
	
	/**
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchComBackEndJobStatusBasic(String key) throws EventException {
		DBRowSet rowSet;
		
		try {
			rowSet = new BackEndJobMetaDataSelector(key).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch(BackEndJobException e) {
			throw new EventException(e.getMessage());
		} catch(SQLException e) {
			throw new EventException(e.getMessage());
		} catch(InterruptedException e) {
			throw new EventException(e.getMessage());
		} catch(Exception e) {
			throw new EventException(e.getMessage());
		}
	}
	
	/**
	 * MNR Invoice에 심사결과 Return
	 * MNR 심사 Logic이 변경될경우 같이 수정해야 함
	 * 
	 * @param String invNo
	 * @param String vndrSeq
	 * @return String
	 * @throws EventException
	 */
	public String auditMnrInvoice(String invNo, String vndrSeq) throws EventException {
		String auditDesc = "";
		try {
			
			List<AuditMnrInvoiceVO> list = dbDao.auditMnrInvoice(invNo, vndrSeq);
			
			// AUDIT 심사 대상할수 없는 INVOICE의 경우
			// 현재는 C, F, S 에 대해서만 구별하며 Audit Status가 추가되면 로직을 바꿔야 함
			if(list == null || list.size() == 0){
				auditDesc = "N/A";
			} else {
				AuditMnrInvoiceVO vo = null;
				for(int i=0; i<list.size(); i++){
					vo = list.get(i);
					
					// Candidate EAC가 발생되면 무조건 중지
					if("C".equals(vo.getAutoAudit())){
						auditDesc = vo.getAutoAuditDesc();
						break;
					} else if("F".equals(vo.getAutoAudit())) {	// F인 경우 담아놓음
						auditDesc = vo.getAutoAuditDesc();
					} else {
						continue;
					}
				}
				if("".equals(auditDesc)) {
					auditDesc = "Coincidence";
				}
			}

			return auditDesc;
			
		} catch(Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Transportation Invoice Auto Audit 대상 조회 (배치에서 사용)<br>
	 * 
	 * @param MnrPreAudListVO mnrPreAudListVO
	 * @return List<MnrPreAudListVO>
	 * @exception EventException
	 */
	public List<MnrChargeListVO> searchMnrAutoAudList(MnrChargeListVO mnrPreAudListVO) throws EventException {
		try{
			return dbDao.searchMnrAutoAudList(mnrPreAudListVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Audit History를 저장한다.<br>
	 * 
	 * @param MnrPreAudListVO mnrPreAudListVO
	 * @exception EventException
	 */
	public void addAutoAuditHis(MnrChargeListVO mnrPreAudListVO) throws EventException{
		try {
			dbDao.addAutoAuditHis(mnrPreAudListVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Auto Audit 내역을 삭제 한다.<br>
	 * 
	 * @param MnrPreAudListVO mnrPreAudListVO
	 * @exception EventException
	 */
	public void removeAutoAudit(MnrChargeListVO mnrPreAudListVO) throws EventException{
		try {
			dbDao.removeAutoAudit(mnrPreAudListVO);
			dbDao.removeAutoAuditDetail(mnrPreAudListVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * 실시간 배치 대상을 저장한다.<br>
	 * 
	 * @param MnrChargeListVO[] mnrChargeListVOs
	 * @exception EventException
	 */
	public void saveReBatchTarget(MnrChargeListVO[] mnrChargeListVOs) throws EventException{
		try{
			MnrChargeListVO mnrChargeListVO = new MnrChargeListVO();
			for(int i=0;i<mnrChargeListVOs.length;i++){
				mnrChargeListVO = mnrChargeListVOs[i];
				dbDao.saveReBatchTarget(mnrChargeListVO);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Futile Trip Container 조회.<br>
	 * 
	 * @param MnrMovementVO mnrMovementVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchMovementList(MnrMovementVO mnrMovementVO, SignOnUserAccount account) throws EventException{
		try {
			MnrAdvanceAuditBackEndJob backEndJob = new MnrAdvanceAuditBackEndJob();
			backEndJob.setJobType("MNR_ADVANCE_AUDIT_FUTILE_TRIP_CNTR");
			backEndJob.setMnrMovementVO(mnrMovementVO);
			
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "MNR_ADVANCE_AUDIT_FUTILE_TRIP_CNTR BackEndJob");
			
		} catch(Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage()); 
		}
	}
	
	/**
	 * Futile Trip Container 조회.<br>
	 * 
	 * @param MnrMovementVO mnrMovementVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchMovementListMail(MnrMovementVO mnrMovementVO, SignOnUserAccount account) throws EventException{
		ScheduleUtil su = new ScheduleUtil();
        String params = "";
		try {
			//id search
			String id = dbDao.getMovementEmailSendJobId();
			String cnmvEvntStDt = mnrMovementVO.getFdate().replace("-", "");
			String cnmvEvntEndDt = mnrMovementVO.getTdate().replace("-", "");
			String mvmtStsCd = mnrMovementVO.getMvmtStsCd();
			String orgYdCd = mnrMovementVO.getLocCd() + mnrMovementVO.getYdCd();
			String cntrNo = mnrMovementVO.getCntrNo();
			String cntrTpszCd = mnrMovementVO.getCntrTpszCd();
			String emlSndAddr = mnrMovementVO.getEmlSndAddr();
			String creUsrId = account.getUsr_id();
			String fcntrFlg = mnrMovementVO.getFcntrFlg();
			
			if(fcntrFlg == null || fcntrFlg.equals("")){
				fcntrFlg = "E";
			}
			
			MnrMovementEmailSendHistoryVO mailVo = new MnrMovementEmailSendHistoryVO();
			
			mailVo.setJbId(id);
			mailVo.setCnmvEvntStDt(cnmvEvntStDt);
			mailVo.setCnmvEvntEndDt(cnmvEvntEndDt);
			mailVo.setMvmtStsCdCtnt(mvmtStsCd);
			mailVo.setOrgYdCd(orgYdCd);
			mailVo.setCntrNoCtnt(cntrNo);
			mailVo.setCntrTpszCdCtnt(cntrTpszCd);
			mailVo.setCreUsrId(creUsrId);
			mailVo.setEmlSndAddr(emlSndAddr);
			
			//params insert
			dbDao.insertMovementEmailSendHistory(mailVo);
			
			params = id + "#" + emlSndAddr + "#" + fcntrFlg;
			
			su.directExecuteJob("ESD_EAS_B016",params);
		} catch (IOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"TS Allocation Creation"}).getMessage(),e);
		} catch (InterruptedException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"TS Allocation Creation"}).getMessage(),e);
		} catch (DAOException e) {
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"TS Allocation Creation"}).getMessage(),e);
		} catch (Exception e){
			log.error("err "+e.toString(),e);
			throw new EventException(new ErrorHandler("COM12213", new String[]{"TS Allocation Creation"}).getMessage(),e);
		}
		return "R";//실행 성공
	}
}
