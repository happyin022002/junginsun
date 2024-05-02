/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SpPerformanceComparisonBCImpl.java
*@FileTitle : S/P Performace Comparison Report
*Open Issues :
*Change history :
*@LastModifyDate : 2016-05-18
*@LastModifier : CJH
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.spperformancecomparison.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.trs.report.spperformancecomparison.integration.SpPerformanceComparisonDBDAO;
import com.hanjin.apps.alps.esd.trs.report.spperformancecomparison.vo.ComparisonCondVO;
import com.hanjin.apps.alps.esd.trs.report.spperformancecomparison.vo.SearchComparisonVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
 
/**
 * S/P Performace Comparison Report Business Logic Basic Command implementation<br>
 * - S/P Performace Comparison Report에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author CJH
 * @see ESD_TRS_0114EventResponse,SpPerformanceComparisonBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class SpPerformanceComparisonBCImpl extends BasicCommandSupport implements SpPerformanceComparisonBC {
	
	// Database Access Object
	private transient SpPerformanceComparisonDBDAO dbDao = null;

	/**
	 * SpPerformanceComparisonBCImpl 객체 생성<br>
	 * SpPerformanceComparisonDBDAO를 생성한다.<br>
	 */
	public SpPerformanceComparisonBCImpl() {
		dbDao = new SpPerformanceComparisonDBDAO();
	}

	/**
	 * Surcharge Report - Summary<br>
	 * 
	 * @param ComparisonCondVO comparisonCondVO
	 * @return List<SearchComparisonVO>
	 * @exception EventException
	 */
	public List<SearchComparisonVO> searchComparison(ComparisonCondVO comparisonCondVO) throws EventException {
		try {
			return dbDao.searchComparison(comparisonCondVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		        
	}


}