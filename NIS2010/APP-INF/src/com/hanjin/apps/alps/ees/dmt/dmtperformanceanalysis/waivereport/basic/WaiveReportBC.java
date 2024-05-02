/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WaiveReportBC.java
*@FileTitle : WAIVE REPORT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : mun jung cheol
*@LastVersion : 1.0
* 2009.10.20 mun jung cheol
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.vo.AfterBookingFileLetterVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportSummaryVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Invoicemgt Business Logic Command Interface<br>
 * - ALPS-WaiveReport에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Mun Jung Cheol
 * @see Ees_dmt_6009EventResponse 참조
 * @since J2EE 1.6
 */
public interface WaiveReportBC {

    /**
     * [Waive Report by Office]을 [SEARCH] 합니다.<br>
     * 
     * @param WaiveReportParmVO  waiveReportParmVO 
     * @return List<WaiveReportSummaryVO>
     * @exception EventException
     */
    public List<WaiveReportSummaryVO> searchWaiveReportByOfficeList ( WaiveReportParmVO  waiveReportParmVO  ) throws EventException;
    
    /**
     * [Waive Report by Office - Detail(s)]을 [SEARCH] 합니다.<br>
     * 
     * @param WaiveReportParmVO  waiveReportParmVO 
     * @return List<WaiveReportDetailVO>
     * @exception EventException
     */
    public List<WaiveReportDetailVO> searchWaiveReportByOfficeDetailList ( WaiveReportParmVO  waiveReportParmVO  ) throws EventException;

    /**
     * [After Booking Guarantee Letter REPORT] 정보를 [SEARCH] 합니다.<br>
     * 
     * @param AfterBookingFileLetterVO afterBookingFileLetterVO
     * @return List<AfterBookingFileLetterVO>
     * @exception EventException
     */
    public List<AfterBookingFileLetterVO> searchAfterBookingFileLetterList ( AfterBookingFileLetterVO  afterBookingFileLetterVO  ) throws EventException;
}
