/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchChargeSummaryReportSummaryViewBackEndJob.java
*@FileTitle : Charge Summary Report
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.13
*@LastModifier : 이혜민
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.pri.screport.screport.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.screport.screport.integration.SCReportDBDAO;
import com.hanjin.apps.alps.esm.pri.screport.screport.vo.RptSearchChargeSummaryReportSummaryViewVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;

/**
 *  대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author 이혜민
 * @see SCReportDBDAO
 * @since J2EE 1.6
 */
public class SearchChargeSummaryReportSummaryViewBackEndJob extends BackEndCommandSupport{

	private static final long serialVersionUID = 6952105465428416158L;

	private  SCReportDBDAO dbDao = new SCReportDBDAO();
	
	private RptSearchChargeSummaryReportSummaryViewVO rptSearchChargeSummaryReportSummaryViewVO; 

	/**
	 * Charge Summary Report - Summary View Tab 조회 조건을 셋팅한다. <br>
	 *  
	 * @param RptSearchChargeSummaryReportSummaryViewVO rptSearchChargeSummaryReportSummaryViewVO
	 */	
	public void setRptSearchChargeSummaryReportSummaryViewVO(RptSearchChargeSummaryReportSummaryViewVO rptSearchChargeSummaryReportSummaryViewVO) {
		this.rptSearchChargeSummaryReportSummaryViewVO = rptSearchChargeSummaryReportSummaryViewVO;
	}

	/**
	 * Charge Summary Report - Summary View Tab을 조회한다.
	 *  
	 * @return List
	 * @exception Exception
	 */
    @SuppressWarnings("unchecked")		
	public List doStart() throws Exception {
		List list = null;
		try {
			list = dbDao.searchChargeSummaryReportSummaryView(this.rptSearchChargeSummaryReportSummaryViewVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return list;
	}
}
