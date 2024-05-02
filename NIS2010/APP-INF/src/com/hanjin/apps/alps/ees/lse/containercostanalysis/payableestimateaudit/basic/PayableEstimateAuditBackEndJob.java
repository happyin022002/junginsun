/*========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableEstimateAuditBackEndJob.java
*@FileTitle : Payable Estimate Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.19
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.10.19 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containercostanalysis.payableestimateaudit.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.containercostanalysis.payableestimateaudit.integration.PayableEstimateAuditDBDAO;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.payableestimateaudit.vo.EstimatedAuditVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;


/**
 * ALPS-Containerleasemgt Business Logic Command Interface<br>
 * - ALPS-Containerleasemgt에 대한 비지니스 로직에 대한 BackEndJob 구상클래스<br>
 *
 * @author Jang Jun-Woo
 * @see Ees_lse_0020EventResponse 참조
 * @since J2EE 1.6
 */
public class PayableEstimateAuditBackEndJob extends BackEndCommandSupport {

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 3299150605186851611L;

	private PayableEstimateAuditDBDAO dbDao = new PayableEstimateAuditDBDAO();

	private String jobType = null;

	private EstimatedAuditVO estimatedAuditVO;
	
	/**
	 * 요청작업의 수행을 BackEndJob으로 처리합니다.<br>
	 *
	 * @return List list
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List doStart() throws Exception {
		List list = null;

		try {
			if(getJobType().equals("SearchPayableEstimateAuditService")) {
				list = dbDao.calculationPayableEstimateAuditData(this.estimatedAuditVO);
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
	 * @return the estimatedAuditVO 
	 */
	public EstimatedAuditVO getestimatedAuditVO() {
		return estimatedAuditVO;
	}

	/**
	 * @param estimatedAuditVO the estimatedAuditVO to set
	 */
	public void setEstimatedAuditVO(EstimatedAuditVO estimatedAuditVO) {
		this.estimatedAuditVO = estimatedAuditVO;
	}	
	
}
