/*========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableRentalCostAuditBackEndJob.java
*@FileTitle : Payable Rental Cost Invoice Audit Search
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.10
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2010.02.10 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration.PayableRentalCostDBDAO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostAuditVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;


/**
 * ALPS-Containerrentalcost Business Logic Command Interface<br>
 * - ALPS-Containerrentalcost에 대한 비지니스 로직에 대한 BackEndJob 구상클래스<br>
 *
 * @author Jeong Yong Noh
 * @see Ees_lse_0008EventResponse 참조
 * @since J2EE 1.6
 */
public class PayableRentalCostAuditBackEndJob extends BackEndCommandSupport {

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = -3764034350774773427L;

	private PayableRentalCostDBDAO dbDao = new PayableRentalCostDBDAO();

	private String jobType = null;

	private PayableRentalCostVO payableRentalCostVO = null;

	/**
	 * 요청작업의 수행을 BackEndJob으로 처리합니다.<br>
	 *
	 * @return List list
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List doStart() throws Exception {
		//List list = null;
		List<PayableRentalCostAuditVO> list = null;

		try {
			if(getJobType().equals("SearchPayableRentalAuditList")) {
				list = dbDao.searchPayableRentalAuditData(getPayableRentalCostVO());
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

	public void setPayableRentalCostVO(PayableRentalCostVO payableRentalCostVO) {
		this.payableRentalCostVO = payableRentalCostVO;
	}

	public PayableRentalCostVO getPayableRentalCostVO() {
		return payableRentalCostVO;
	}
}
