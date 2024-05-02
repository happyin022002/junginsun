/*========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MnrAdvanceAuditBackEndJob.java
*@FileTitle : MnrAdvanceAuditBackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.08
*@LastModifier : 박정민
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.basic;

import java.util.List;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.integration.MnrAdvanceAuditDBDAO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrInvoiceChargeINVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrMovementVO;
import com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo.MnrReportINVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 * ALPS-Containerleasemgt Business Logic Command Interface<br>
 * - ALPS-Containerleasemgt에 대한 비지니스 로직에 대한 BackEndJob 구상클래스<br>
 *
 * @author Jeong-Min Park
 * @see EventResponse 참조
 * @since J2EE 1.6
 */
public class MnrAdvanceAuditBackEndJob extends BackEndCommandSupport {


	private static final long serialVersionUID = -6366637441518491087L;

	private MnrAdvanceAuditDBDAO dbDao = new MnrAdvanceAuditDBDAO();

	private String jobType = null;

	private MnrReportINVO mnrReportINVO;
	private MnrInvoiceChargeINVO mnrInvoiceChargeINVO;
	private MnrMovementVO mnrMovementVO;
	/**
	 * 요청작업의 수행을 BackEndJob으로 처리합니다.<br>
	 *
	 * @return List list
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public Object doStart() throws Exception {
		List list = null;

		try {
			if(getJobType().equals("MNR_ADVANCE_AUDIT_AUTO_AUDIT")){
				list = dbDao.searchPreAuditList(mnrInvoiceChargeINVO);
			} else if(getJobType().equals("MNR_ADVANCE_AUDIT_MULTIPLE_REPAIR_CNTR_BY_AREA")) {
				list = dbDao.searchMultipleRepairCNTRByAreaList(mnrReportINVO);
			} else if(getJobType().equals("MNR_ADVANCE_AUDIT_MULTIPLE_REPAIR_CNTR_BY_PERIOD")) {
				list = dbDao.searchMultipleRepairCNTRByPeriodList(mnrReportINVO);
			} else if(getJobType().equals("MNR_ADVANCE_AUDIT_CLEANING_CNTR_INQUIRY")){
				list = dbDao.searchCleaningContainerInquiryList(mnrReportINVO);
			}else if(getJobType().equals("MNR_ADVANCE_AUDIT_CLEANING_CNTR_BKG")){
				list = dbDao.searchCleaningContainerBKGList(mnrReportINVO);
			}else if(getJobType().equals("MNR_ADVANCE_AUDIT_FUTILE_TRIP_CNTR")){
				list = dbDao.searchMovementList(mnrMovementVO); 
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}

		return list;
	}
	
	/**
	 * @return the jobType
	 */
	public String getJobType() {
		return jobType;
	}

	/**
	 * @param jobType the jobType to set
	 */
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	
	/** 
	 * @return MnrReportINVO
	 */
	public final MnrReportINVO getMnrReportINVO() {
		return mnrReportINVO;
	}
	
	/** 
	 * @return MnrInvoiceChargeINVO
	 */
	public final MnrInvoiceChargeINVO getMnrInvoiceChargeINVO() {
		return mnrInvoiceChargeINVO;
	}

	
	/**
	 * 
	 * @param mnrReportINVO
	 */
	public void setMnrReportINVO(MnrReportINVO mnrReportINVO) {
		this.mnrReportINVO = mnrReportINVO;
	}
	
	/**
	 * 
	 * @param mnrInvoiceChargeINVO
	 */
	public void setMnrInvoiceChargeINVO(MnrInvoiceChargeINVO mnrInvoiceChargeINVO) {
		this.mnrInvoiceChargeINVO = mnrInvoiceChargeINVO;
	}

	public final MnrMovementVO getMnrMovementVO() {
		return mnrMovementVO;
	}

	public void setMnrMovementVO(MnrMovementVO mnrMovementVO) {
		this.mnrMovementVO = mnrMovementVO;
	}
	
}
