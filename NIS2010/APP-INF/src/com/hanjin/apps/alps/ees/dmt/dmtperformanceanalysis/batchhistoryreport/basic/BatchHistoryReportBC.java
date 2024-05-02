/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BatchHistoryReportBC.java
*@FileTitle : Daily Batch Job Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.05.12 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.batchhistoryreport.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.batchhistoryreport.vo.BatHistParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.batchhistoryreport.vo.DmtBatHisVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * NIS2010-Dmtperformanceanalysis Business Logic Command Interface<br>
 * - NIS2010-Dmtperformanceanalysis에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Choi Sung Hwan
 * @see Ees_dmt_7007EventResponse 참조
 * @since J2EE 1.4
 */

public interface BatchHistoryReportBC {
	/**
	 * 각 지역 서버별로 배치 이력을 조회 한다<br>
	 * Batchhistoryreport화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param BatHistParmVO batHistParmVO
	 * @return List<DmtBatHisVO>
	 * @exception EventException
	 */
	public List<DmtBatHisVO> searchBatchHistory(BatHistParmVO batHistParmVO) throws EventException;
}