/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BatchHistoryReportBC.java
*@FileTitle : Daily Batch Job Status Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.batchhistoryreport.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.batchhistoryreport.vo.BatHistParmVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.batchhistoryreport.vo.DmtBatHisVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * Dmtperformanceanalysis Business Logic Command Interface<br>
 * 
 * @author
 * @see Ees_dmt_7007EventResponse reference
 * @since J2EE 1.4
 */

public interface BatchHistoryReportBC {
	
	/** 
	 * 
	 * @param BatHistParmVO batHistParmVO
	 * @return List<DmtBatHisVO>
	 * @exception EventException
	 */
	public List<DmtBatHisVO> searchBatchHistory(BatHistParmVO batHistParmVO) throws EventException;
}
