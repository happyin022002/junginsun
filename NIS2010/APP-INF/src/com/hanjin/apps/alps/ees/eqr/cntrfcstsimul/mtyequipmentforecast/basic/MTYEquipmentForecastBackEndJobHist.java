/*========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MTYEquipmentForecastBackEndJobHist.java
*@FileTitle : MTYEquipmentForecastBackEndJobHist
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.22
*@LastModifier : 전지예
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.integration.MTYEquipmentForecastDBDAO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.mtyequipmentforecast.vo.SalesProjectionHistVO;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * ALPS-Containerleasemgt Business Logic Command Interface<br>
 * - ALPS-Containerleasemgt에 대한 비지니스 로직에 대한 BackEndJob 구상클래스<br>
 *
 * @author 전지예
 * @see Ees_lse_0020EventResponse 참조
 * @since J2EE 1.6
 */
public class MTYEquipmentForecastBackEndJobHist extends BackEndCommandSupport {

	/**
	 * SerialVersionUID
	 */
	private static final long serialVersionUID = 3299150605186384611L;

	private MTYEquipmentForecastDBDAO dbDao = new MTYEquipmentForecastDBDAO();

	private String jobType = null;

	private SalesProjectionHistVO salesProjectionHistVO;
	
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
			if(getJobType().equals("MTYEquipmentForecastHist")) {
				list = dbDao.searchEqFcstHist(salesProjectionHistVO);
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
	 * @return the searchParamVO
	 */
	public final SalesProjectionHistVO getSalesProjectionHistVO() {
		return salesProjectionHistVO;
	}
	
	/**
	 * @param searchParamVO the searchParamVO to set
	 */
	public void setSalesProjectionHistVO(SalesProjectionHistVO salesProjectionHistVO) {
		this.salesProjectionHistVO = salesProjectionHistVO;
	}
}
