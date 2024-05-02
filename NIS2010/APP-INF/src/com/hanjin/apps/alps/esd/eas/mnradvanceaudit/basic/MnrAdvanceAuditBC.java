/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MnrAdvanceAuditBC   
*@FileTitle : Equipment Auto Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-13
*@LastModifier : Jeong-Min Park
*@LastVersion : 1.0
* 2015-04-13 Jeong-Min Park
* 1.0 理쒖큹 �깮�꽦
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.basic;

import java.util.List;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.CleaningContainerInquiryDetailVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MNRPreAuditCriterionVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrChargeDetailListVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrChargeListVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrGeneralCodeVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrInvoiceChargeINVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrMovementVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrReportINVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MultipleRepairCNTRByAreaDetailVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MultipleRepairCNTRByAreaListVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MultipleRepairCNTRByPeriodDetailVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MultipleRepairCNTRbyPeriodListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * MnrAdvanceAuditBC PDTO(Data Transfer Object including Parameters)<br>
 * 
 * @author Jeong-Min Park
 * @see EventResponse 李몄“
 * @since J2EE 1.4
 */
public interface MnrAdvanceAuditBC { 
	
	/**
	 * MNR Charge Invoice List
	 * 
	 * @category EDS_EAS_0360
	 * @param mnrInvoiceChargeINVO MNRInvoiceChargeINVO
	 * @param account
	 * @return String
	 * @throws EventException
	 */
	public List<MnrChargeListVO> searchMNRChargeList(MnrInvoiceChargeINVO mnrInvoiceChargeINVO, SignOnUserAccount account) throws EventException;
	//20160311 BackEndJob 제거-->
	//public String searchMNRChargeList(MnrInvoiceChargeINVO mnrInvoiceChargeINVO, SignOnUserAccount account) throws EventException;
	//<--20160311 BackEndJob 제거	
	
	/**
	 * MNR Charge Invoice Detail List
	 * 
	 * @category EDS_EAS_0361
	 * @param mnrInvoiceChargeINVO
	 *            MNRInvoiceChargeINVO
	 * @return List<MNRChargeDetailListVO>
	 * @throws EventException
	 */
	public List<MnrChargeDetailListVO> searchMNRChargeDetailList(MnrInvoiceChargeINVO mnrInvoiceChargeINVO) throws EventException;
	
	/**
	 * MNR General Code List
	 * 
	 * @param mnrInvoiceChargeINVO
	 * @return List<MnrGeneralCodeVO>
	 * @throws EventException
	 */
	public List<MnrGeneralCodeVO> searchMnrGeneralCode(MnrInvoiceChargeINVO mnrInvoiceChargeINVO) throws EventException;
	
	/**
	 * Confirm MNR Invoice List
	 * 
	 * @param mnrChargeListVOS
	 * @param account
	 * @throws EventException
	 */
	public void manageMNRChargeList(MnrChargeListVO[] mnrChargeListVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * searchMultipleRepairCNTRByAreaList
	 * 
	 * @param mnrReportINVO
	 * @param account
	 * @return String
	 * @throws EventException
	 */
	public String searchMultipleRepairCNTRByAreaList(MnrReportINVO mnrReportINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * searchMultipleRepairCNTRByAreaDetail
	 * 
	 * @param mnrReportINVO
	 * @return List<MultipleRepairCNTRByAreaDetailVO>
	 * @throws EventException
	 */
	public List<MultipleRepairCNTRByAreaDetailVO> searchMultipleRepairCNTRByAreaDetail(MnrReportINVO mnrReportINVO) throws EventException;
	
	/**
	 * searchMultipleRepairCNTRByPeriodList
	 * 
	 * @param mnrReportINVO
	 * @param account
	 * @return String
	 * @throws EventException
	 */
	public String searchMultipleRepairCNTRByPeriodList(MnrReportINVO mnrReportINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * searchMultipleRepairCNTRByPeriodDetail
	 * 
	 * @param mnrReportINVO
	 * @return List<MultipleRepairCNTRByPeriodDetailVO>
	 * @throws EventException
	 */
	public List<MultipleRepairCNTRByPeriodDetailVO> searchMultipleRepairCNTRByPeriodDetail(MnrReportINVO mnrReportINVO) throws EventException;
	
	/**
	 * searchCleaningContainerInqiuryList
	 * 
	 * @param mnrReportINVO
	 * @param account
	 * @return String
	 * @throws EventException
	 */
	public String searchCleaningContainerInquiryList(MnrReportINVO mnrReportINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * searchCleaningContainerInqiuryDetail
	 * 
	 * @param mnrReportINVO
	 * @return List<CleaningContainerInquiryDetailVO>
	 * @throws EventException
	 */
	public List<CleaningContainerInquiryDetailVO> searchCleaningContainerInquiryDetail(MnrReportINVO mnrReportINVO) throws EventException;
	
	/**
	 * searchCleaningContainerBKGList
	 * 
	 * @param mnrReportINVO
	 * @param account
	 * @return String
	 * @throws EventException
	 */
	public String searchCleaningContainerBKGList(MnrReportINVO mnrReportINVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * MNR Pre-Audit Criterion By Error Code
	 * 
	 * @category ESD_EAS_0362
	 * @param mnrPreAuditCriterionVO
	 * @return List<MNRPreAuditCriterionVO>
	 * @throws EventException
	 */
	public List<MNRPreAuditCriterionVO> searchMnrPreAuditCriterionByErrorCode(MNRPreAuditCriterionVO mnrPreAuditCriterionVO) throws EventException;
	
	/**
	 * MNR Pre-Audit Criterion By Difference W/O & INV AMT
	 * 
	 * @category ESD_EAS_0363
	 * @param mnrPreAuditCriterionVO
	 * @return List<MNRPreAuditCriterionVO>
	 * @throws EventException
	 */
	public List<MNRPreAuditCriterionVO> searchMnrPreAuditCriterionByDifference(MNRPreAuditCriterionVO mnrPreAuditCriterionVO) throws EventException;
	
	/**
	 * MNR Pre-Audit Criterion By Error Code
	 * 
	 * @category ESD_EAS_0362
	 * @param mnrPreAuditCriterionVO
	 * @param account
	 * @throws EventException
	 */
	public void deleteMnrPreAuditCriterionByErrorCode(MNRPreAuditCriterionVO mnrPreAuditCriterionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * MNR Pre-Audit Criterion By Error Code
	 * 
	 * @category ESD_EAS_0362
	 * @param mnrPreAuditCriterionVO
	 * @param account
	 * @throws EventException
	 */
	public void insertMnrPreAuditCriterionByErrorCode(MNRPreAuditCriterionVO mnrPreAuditCriterionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * MNR Pre-Audit Criterion By Error Code
	 * 
	 * @category ESD_EAS_0362
	 * @return String[]
	 * @param mnrPreAuditCriterionVO
	 * @param account
	 * @throws EventException
	 */
	public String[] searchMNROfficeCodeForValidation(MNRPreAuditCriterionVO mnrPreAuditCriterionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * MNR Pre-Audit Criterion By Error Code
	 * 
	 * @category ESD_EAS_0362
	 * @param mnrPreAuditCriterionVOs
	 * @param account
	 * @throws EventException
	 */
	public void updateMnrPreAuditCriterionByErrorCode(MNRPreAuditCriterionVO[] mnrPreAuditCriterionVOs, SignOnUserAccount account) throws 	EventException;
	
	/**
	 * MNR Pre-Audit Criterion By Difference
	 * 
	 * @category ESD_EAS_0363
	 * @param mnrPreAuditCriterionVO
	 * @param account
	 * @throws EventException
	 */
	public void deleteMnrPreAuditCriterionByDifference(MNRPreAuditCriterionVO mnrPreAuditCriterionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * MNR Pre-Audit Criterion By Difference
	 * 
	 * @category ESD_EAS_0363
	 * @param mnrPreAuditCriterionVO
	 * @param account
	 * @throws EventException
	 */
	public void insertMnrPreAuditCriterionByDifference(MNRPreAuditCriterionVO mnrPreAuditCriterionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * MNR Pre-Audit Criterion By Difference
	 * 
	 * @param MNRPreAuditCriterionVO[] mnrPreAuditCriterionVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void updateMnrPreAuditCriterionByDifference(MNRPreAuditCriterionVO[] mnrPreAuditCriterionVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * BackEndJob의 실행결과에 대한 상태값을 조회합니다.<br>
	 *
	 * @param String key
	 * @return String
	 * @exception EventException
	 */
	public String searchComBackEndJobStatusBasic(String key) throws EventException;
	
	/**
	 * MNR Invoice에 심사결과 Return
	 * MNR 심사 Logic이 변경될경우 같이 수정해야 함
	 * @param String invNo
	 * @param String vndrSeq
	 * @return String
	 * @throws EventException
	 */
	public String auditMnrInvoice(String invNo, String vndrSeq) throws EventException;
	
	/**
	 * Transportation Invoice Auto Audit 대상 조회 (배치에서 사용)<br>
	 * 
	 * @param MnrPreAudListVO mnrPreAudListVO
	 * @return List<MnrPreAudListVO>
	 * @exception EventException
	 */
	public List<MnrChargeListVO> searchMnrAutoAudList(MnrChargeListVO mnrPreAudListVO) throws EventException;
	/**
	 * Audit History를 저장한다.<br>
	 * 
	 * @param MnrPreAudListVO mnrPreAudListVO
	 * @exception EventException
	 */
	public void addAutoAuditHis(MnrChargeListVO mnrPreAudListVO) throws EventException;
	/**
	 * Auto Audit 내역을 삭제 한다.<br>
	 * 
	 * @param MnrPreAudListVO mnrPreAudListVO
	 * @exception EventException
	 */
	public void removeAutoAudit(MnrChargeListVO mnrPreAudListVO) throws EventException;
	/**
	 * 실시간 배치 대상을 저장한다.<br>
	 * 
	 * @param MnrChargeListVO[] mnrChargeListVOs
	 * @exception EventException
	 */
	public void saveReBatchTarget(MnrChargeListVO[] mnrChargeListVOs) throws EventException;
	
	/**
	 * Futile Trip Container 조회.<br>
	 * 
	 * @param MnrMovementVO mnrMovementVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchMovementList(MnrMovementVO mnrMovementVO, SignOnUserAccount account) throws EventException;
	/**
	 * Futile Trip Container 배치조회.<br>
	 * 
	 * @param MnrMovementVO mnrMovementVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchMovementListMail(MnrMovementVO mnrMovementVO, SignOnUserAccount account) throws EventException;
}
