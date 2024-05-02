/*========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableRentalCostAuditBackEndJob.java
*@FileTitle : Payable Rental Cost Invoice Audit Search
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.basic;

import java.util.List;

import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.integration.PayableRentalCostDBDAO;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostAuditVO;
import com.clt.apps.opus.ees.lse.containerrentalcost.payablerentalcost.vo.PayableRentalCostVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;


/**
 * Containerrentalcost Business Logic Command Interface<br>
 *
 * @author 
 * @see Ees_lse_0008EventResponse 
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
