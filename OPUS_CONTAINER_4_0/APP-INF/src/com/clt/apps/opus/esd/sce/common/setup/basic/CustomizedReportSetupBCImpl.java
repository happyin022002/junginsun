/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailTransitReportBCImpl.java
*@FileTitle : RailTransit Report BC Impl
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esd.sce.common.setup.basic;

import com.clt.apps.opus.esd.sce.common.setup.integration.CustomizedReportSetupDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;



/**
 * by user customized Rpt Setup information access Component. <br>
 * 
 * @author 
 * @see UI_ID_11EventRespons
 * @since J2EE 1.4
 */
public class CustomizedReportSetupBCImpl extends BasicCommandSupport implements CustomizedReportSetupBC {

    // Database Access Object
    private transient CustomizedReportSetupDBDAO dbDao=null;


    /**
     * RailTransitReportBCImpl object creation<br>
     * RailTransitReportDBDAO creation.<br>
     */
    public CustomizedReportSetupBCImpl(){
        dbDao = new CustomizedReportSetupDBDAO();
    }
    
    
	
	/**
     *Rpt Setup information is viewed by user
     * 
     * @param String usrId
	 * @param String usrOfcCd
	 * @param String pgmNo
	 * @return DBRowSet
     * @throws EventException
     */
	public DBRowSet searchCustmRptForm(String usrId, String usrOfcCd, String pgmNo) throws EventException {
		log.debug("searchCustmRptForm!! ");
		
		try {
			return dbDao.searchCustmRptForm(usrId, usrOfcCd, pgmNo);
		} catch (DAOException ex) {
    		throw new EventException(ex.getMessage(),ex);
    	} catch (Exception ex) {
    		throw new EventException(ex.getMessage(),ex);
    	}
	}
	
	/**
     *Rpt Setup information is registered by user.
     * 
     * @param String usrId
	 * @param String usrOfcCd
	 * @param String pgmNo
	 * @param String rptInfoCtnt
     * @throws EventException
     */
	public void insertCustmRptForm(String usrId, String usrOfcCd, String pgmNo, String rptInfoCtnt) throws EventException {
		
		try {
			dbDao.insertCustmRptForm(usrId, usrOfcCd, pgmNo, rptInfoCtnt);
		} catch (DAOException ex) {
    		throw new EventException(ex.getMessage(),ex);
    	} catch (Exception ex) {
    		throw new EventException(ex.getMessage(),ex);
    	}
	}
	
	/**
     * Rpt Setup information is modified by user.
     * 
     * @param String usrId
	 * @param String usrOfcCd
	 * @param String pgmNo
	 * @param String rptInfoCtnt
     * @throws EventException
     */
	public void updateCustmRptForm(String usrId, String usrOfcCd, String pgmNo, String rptInfoCtnt) throws EventException {
		
		try {
			dbDao.updateCustmRptForm(usrId, usrOfcCd, pgmNo, rptInfoCtnt);
		} catch (DAOException ex) {
    		throw new EventException(ex.getMessage(),ex);
    	} catch (Exception ex) {
    		throw new EventException(ex.getMessage(),ex);
    	}
	}
	
}