/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SpPerformanceComparisonBC.java
*@FileTitle : S/P Performace Comparison Report
*Open Issues :
*Change history :
*@LastModifyDate : 2016-05-18
*@LastModifier : CJH
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.spperformancecomparison.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.trs.report.spperformancecomparison.vo.ComparisonCondVO;
import com.hanjin.apps.alps.esd.trs.report.spperformancecomparison.vo.SearchComparisonVO;
import com.hanjin.framework.core.layer.event.EventException;


/**
 * S/P Performace Comparison Report Business Logic Command Interface<br>
 * - S/P Performace Comparison Report 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CJH
 * @see ESD_TRS_0114EventResponse 참조
 * @since J2EE 1.6
 */
public interface SpPerformanceComparisonBC  {

	/**
	 * S/P Performace Comparison Report<br>
	 * 
	 * @param ComparisonCondVO comparisonCondVO
	 * @return List<SearchComparisonVO>
	 * @exception EventException
	 */
	public List<SearchComparisonVO> searchComparison(ComparisonCondVO comparisonCondVO) throws EventException;

}
