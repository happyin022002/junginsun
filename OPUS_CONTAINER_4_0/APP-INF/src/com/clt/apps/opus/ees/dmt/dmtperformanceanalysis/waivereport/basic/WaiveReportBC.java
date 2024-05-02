/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WaiveReportBC.java
*@FileTitle : WAIVE REPORT
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.waivereport.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportDetailVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportParmVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportSummaryVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * Invoicemgt Business Logic Command Interface<br>
 * @author 
 * @see Ees_dmt_6009EventResponse reference
 * @since J2EE 1.6
 */
public interface WaiveReportBC {

    /**
     * [Waive Report by Office][SEARCH] .<br>
     * 
     * @param WaiveReportParmVO  waiveReportParmVO 
     * @return List<WaiveReportSummaryVO>
     * @exception EventException
     */
    public List<WaiveReportSummaryVO> searchWaiveReportByOfficeList ( WaiveReportParmVO  waiveReportParmVO  ) throws EventException;
    
    /**
     * [Waive Report by Office - Detail(s)][SEARCH] .<br>
     * 
     * @param WaiveReportParmVO  waiveReportParmVO 
     * @return List<WaiveReportDetailVO>
     * @exception EventException
     */
    public List<WaiveReportDetailVO> searchWaiveReportByOfficeDetailList ( WaiveReportParmVO  waiveReportParmVO  ) throws EventException;
}
