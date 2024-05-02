/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EacRegRptBC.java
*@FileTitle : Expense Audit case Report
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.basic;



import java.util.List;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchOfcPerfVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchOfcStatisticsVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchRegRptVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchRhqStatisticsVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchSpPerfVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Eac Business Logic Command Interface<br>
 * - ALPS-Eac에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CHOI JONG HYEK
 * @see EacRegRptBCImpl  참조
 * @since J2EE 1.6
 */

public interface EacRegRptBC {

	/**
	 * 오피스/월별 비용심사 실적 조회<br>
	 * @param SearchRegRptVO searchRegRptVO
	 * @return List<SearchOfcStatisticsVO> 
	 * @exception EventException
	 */
	public List<SearchOfcStatisticsVO> searchOfcStatistics(SearchRegRptVO searchRegRptVO) throws EventException;

	/**
	 * RHQ/월별 비용심사 실적 조회<br>
	 * @param SearchRegRptVO searchRegRptVO
	 * @return List<SearchRhqStatisticsVO> 
	 * @exception EventException
	 */
	public List<SearchRhqStatisticsVO> searchRhqStatistics(SearchRegRptVO searchRegRptVO) throws EventException;

	/**
	 * Audit office 또는 Responsible Office별 실적 조회<br>
	 * @param SearchRegRptVO searchRegRptVO
	 * @return List<SearchOfcPerfVO> 
	 * @exception EventException
	 */
	public List<SearchOfcPerfVO> searchOfcPerf(SearchRegRptVO searchRegRptVO) throws EventException;
	
	/**
	 * S/P별 실적 조회<br>
	 * @param SearchRegRptVO searchRegRptVO
	 * @return List<SearchSpPerfVO> 
	 * @exception EventException
	 */
	public List<SearchSpPerfVO> searchSpPerf(SearchRegRptVO searchRegRptVO) throws EventException;
}