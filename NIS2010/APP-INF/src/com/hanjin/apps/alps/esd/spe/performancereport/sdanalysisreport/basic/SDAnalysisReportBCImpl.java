/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SDAnalysisReportBCImpl.java
*@FileTitle : SD Analysis Report
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisreport.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.spe.egmapping.egandevaluator.vo.SpeEGEVMappingVO;
import com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisreport.integration.SDAnalysisReportDBDAO;
import com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisreport.vo.SpeSDAnalysisVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-PerformanceReport Business Logic Command Interface<br>
 * - ALPS-PerformanceReport에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */
public class SDAnalysisReportBCImpl extends BasicCommandSupport implements SDAnalysisReportBC {

	// Database Access Object
	private transient SDAnalysisReportDBDAO dbDao = null;

	/**
	 * SDAnalysisReportBCImpl 객체 생성<br>
	 * SDAnalysisReportDBDAO를 생성한다.<br>
	 */
	public SDAnalysisReportBCImpl() {
		dbDao = new SDAnalysisReportDBDAO();
	}

	
	/**
	 * SD Analysis Report 데이터를 조회한다.<br>
	 * 
	 * @param SpeSDAnalysisVO speSDAnalysisVO
	 * @return List<SpeSDAnalysisVO>
	 * @exception EventException
	 */
	public List<SpeSDAnalysisVO> searchSDAnalysis(SpeSDAnalysisVO speSDAnalysisVO) throws EventException {
		try {
			// SUM 하는 부분을 만들어서 넘겨주어야 한다.
			String[] fromDt = speSDAnalysisVO.getFromDt().split("-");
			String[] toDt = speSDAnalysisVO.getToDt().split("-");
			String fromYear = fromDt[0];
			String toYear = toDt[0];
			String fromMonth = fromDt[1];
			String toMonth = toDt[1];

			speSDAnalysisVO.setEvFromYr(fromYear);
			speSDAnalysisVO.setEvToYr(toYear);
			speSDAnalysisVO.setEvFromMon(fromMonth);
			speSDAnalysisVO.setEvToMon(toMonth);
			
			return dbDao.searchSDAnalysis(speSDAnalysisVO);
		} catch(DAOException ex) {
 			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}			

	
}