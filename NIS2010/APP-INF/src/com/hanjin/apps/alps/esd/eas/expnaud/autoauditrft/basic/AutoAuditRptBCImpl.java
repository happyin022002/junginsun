/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AudPerfBCImpl
*@FileTitle : Performance For Logistics Expense
*Open Issues :   
*Change history :
*@LastModifyDate : 2015-02-02
*@LastModifier : 9014613
*@LastVersion : 1.0
* 2015-02-02 9014613
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.autoauditrft.basic;


import java.util.List;

import com.hanjin.apps.alps.esd.eas.expnaud.autoauditrft.integration.AutoAuditRptDAO;
import com.hanjin.apps.alps.esd.eas.expnaud.autoauditrft.vo.SearchAutoAuditChangeHistoryVO;
import com.hanjin.apps.alps.esd.eas.expnaud.autoauditrft.vo.SearchAutoAuditStatisticsVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * AudPerfBCImpl PDTO(Data Transfer Object including Parameters)<br>
 * @author 9014613
 * @see EventResponse 참조
 * @since J2EE 1.4
 */
public class AutoAuditRptBCImpl extends BasicCommandSupport implements AutoAuditRptBC {

	
	// Database Access Object
	private transient AutoAuditRptDAO dbDao = null;

	/**
	 * AudPerfBCImpl 객체 생성<br>
	 * AudPerfDAO 생성한다.<br>
	 */
	public AutoAuditRptBCImpl(){
		dbDao = new AutoAuditRptDAO();
	}

	/**
	 * Performance For Logistics Expense 조회
	 * 
	 * @category EDS_EAS_0227
	 * @param e EsdEas0227Event
	 * @return List<SearchAutoAuditChangeHistoryVO>
	 * @throws EventException
	 */

	public List<SearchAutoAuditChangeHistoryVO> searchAutoAuditChangeHistory(SearchAutoAuditChangeHistoryVO searchAutoAuditChangeHistoryVO) throws EventException {
		try {
			return dbDao.searchAutoAuditChangeHistory(searchAutoAuditChangeHistoryVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Auto Audit Statistics 조회
	 * 
	 * @category EDS_EAS_0228
	 * @param e EsdEas0228Event
	 * @return List<SearchAutoAuditStatisticsVO>
	 * @throws EventException
	 */

	public List<SearchAutoAuditStatisticsVO> searchAutoAuditStatistics(SearchAutoAuditStatisticsVO searchAutoAuditStatisticsVO) throws EventException {
		try {
			return dbDao.searchAutoAuditStatistics(searchAutoAuditStatisticsVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
}
