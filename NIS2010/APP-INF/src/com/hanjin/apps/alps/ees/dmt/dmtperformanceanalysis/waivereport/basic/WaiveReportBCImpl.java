/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WaiveReportBCImpl.java
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
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.integration.WaiveReportDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.vo.AfterBookingFileLetterVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportSummaryVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-InvoiceMgt Business Logic Basic Command implementation<br>
 * - ALPS-WaiveReport에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Mun Jung Cheol
 * @see EES_DMT_6009EventResponse,WaiveReportBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class WaiveReportBCImpl extends BasicCommandSupport implements WaiveReportBC {

    // Database Access Object
    private transient WaiveReportDBDAO dbDao = null;

    /**
     * WaiveReportBCImpl 객체 생성<br>
     * WaiveReportDBDAO 생성한다.<br>
     */
    public WaiveReportBCImpl() {
        dbDao = new WaiveReportDBDAO();
    }
    
    /**
    * [Waive Report by Office]을 [SEARCH] 합니다.<br>
    * 
    * @param WaiveReportParmVO waiveReportParmVO
    * @return List<WaiveReportSummaryVO>
    * @exception EventException
    */
    public List<WaiveReportSummaryVO> searchWaiveReportByOfficeList ( WaiveReportParmVO waiveReportParmVO ) throws EventException {
        try {
            return dbDao.searchWaiveReportByOfficeList ( waiveReportParmVO ); 
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
    }
   
    /**
    * [Waive Report by Office - Detail(s)]을 [SEARCH] 합니다.<br>
    * 
    * @param WaiveReportParmVO waiveReportParmVO
    * @return List<WaiveReportDetailVO>
    * @exception EventException
    */
    public List<WaiveReportDetailVO> searchWaiveReportByOfficeDetailList ( WaiveReportParmVO waiveReportParmVO ) throws EventException {
        try {
            return dbDao.searchWaiveReportByOfficeDetailList ( waiveReportParmVO ); 
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
    }
    /**
     * [After Booking Guarantee Letter REPORT] 정보를 [SEARCH] 합니다.<br>
     * 
     * @param AfterBookingFileLetterVO afterBookingFileLetterVO
     * @return List<AfterBookingFileLetterVO>
     * @exception EventException
     */
    public List<AfterBookingFileLetterVO> searchAfterBookingFileLetterList ( AfterBookingFileLetterVO  afterBookingFileLetterVO  ) throws EventException {
        try {
            return dbDao.searchAfterBookingFileLetterList ( afterBookingFileLetterVO ); 
        } catch (DAOException ex) {
        	log.error("[DAOException]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch (Exception ex) {
        	log.error("[Exception]"+ex.getMessage());
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
    }
}
