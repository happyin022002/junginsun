/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WaiveReportBCImpl.java
*@FileTitle : WAIVE REPORT
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.waivereport.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.waivereport.integration.WaiveReportDBDAO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportDetailVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportParmVO;
import com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.waivereport.vo.WaiveReportSummaryVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * InvoiceMgt Business Logic Basic Command implementation<br>
 * @author 
 * @see EES_DMT_6009EventResponse,WaiveReportBC DAO class reference
 * @since J2EE 1.6
 */
public class WaiveReportBCImpl extends BasicCommandSupport implements WaiveReportBC {

    // Database Access Object
    private transient WaiveReportDBDAO dbDao = null;

    /**
     * WaiveReportBCImpl Create object<br>
     * WaiveReportDBDAO Create<br>
     */
    public WaiveReportBCImpl() {
        dbDao = new WaiveReportDBDAO();
    }
    
    /**
    * [Waive Report by Office] [SEARCH] .<br>
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
    * [Waive Report by Office - Detail(s)] [SEARCH] .<br>
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
}
