/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SDAnalysisResultDetailBCImpl.java
*@FileTitle : SD Analysis Result Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.09
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2015.03.09 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisresultdetail.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisresultdetail.integration.SDAnalysisResultDetailDBDAO;
import com.hanjin.apps.alps.esd.spe.performancereport.sdanalysisresultdetail.vo.SpeSDAnalysisDtlVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-PerformanceReport Business Logic Command Interface<br>
 * - ALPS-PerformanceReport에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author HI
 * @see
 * @since J2EE 1.6
 */
public class SDAnalysisResultDetailBCImpl extends BasicCommandSupport implements SDAnalysisResultDetailBC {

	// Database Access Object
	private transient SDAnalysisResultDetailDBDAO dbDao = null;

	/**
	 * SDAnalysisResultDetailBCImpl 객체 생성<br>
	 * SDAnalysisResultDetailDBDAO를 생성한다.<br>
	 */
	public SDAnalysisResultDetailBCImpl() {
		dbDao = new SDAnalysisResultDetailDBDAO();
	}

	
	/**
	 * SD Analysis Result Detail 데이터를 조회한다.<br>
	 * 
	 * @param SpeSDAnalysisDtlVO speSDAnalysisDtlVO
	 * @return List<SpeSDAnalysisDtlVO>
	 * @exception EventException
	 */
	public List<SpeSDAnalysisDtlVO> searchSDAnalysisDtl(SpeSDAnalysisDtlVO speSDAnalysisDtlVO) throws EventException {
		try {
			return dbDao.searchSDAnalysisDtl(speSDAnalysisDtlVO);
		} catch(DAOException ex) {
 			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}	
	
}