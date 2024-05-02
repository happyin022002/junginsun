/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailTransitReportBCImpl.java
*@FileTitle : RailTransit Report BC Impl
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-16
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-11-16 Seong-mun Kang
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.common.setup.basic;

import com.hanjin.apps.alps.esd.sce.common.setup.integration.CustomizedReportSetupDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * user별 customized Rpt Setup 정보를 access Component. <br>
 * 
 * @author HanSung Shin.
 * @see UI_ID_11EventResponse 참조
 * @since J2EE 1.4
 */
public class CustomizedReportSetupBCImpl extends BasicCommandSupport implements CustomizedReportSetupBC {

    // Database Access Object
    private transient CustomizedReportSetupDBDAO dbDao=null;

    /**
     * RailTransitReportBCImpl 객체 생성<br>
     * RailTransitReportDBDAO를 생성한다.<br>
     */
    public CustomizedReportSetupBCImpl(){
        dbDao = new CustomizedReportSetupDBDAO();
    }
    
    
    
	/**
     * 기본 default report setup 정보를 조회한다 (master table: SCE_USA_INLND_OP_RPT_COL)
     * 
     * @param String usrId
	 * @param String usrOfcCd
	 * @param String pgmNo
	 * @return DBRowSet
     * @throws EventException
     */
	public DBRowSet searchRptForm(String usrId, String usrOfcCd) throws EventException {
		log.debug("searchRptForm!! ");
		
		try {
			return dbDao.searchRptForm(usrId, usrOfcCd);
		} catch (DAOException ex) {
    		throw new EventException(ex.getMessage(),ex);
    	} catch (Exception ex) {
    		throw new EventException(ex.getMessage(),ex);
    	}
	}
		
	/**
     * user별로 등록되어 저장된 report 정보를 조회한다 (customized table: SCE_USA_INLND_OP_RPT_FOM)
     * 
     * @param String usrId
	 * @param String usrOfcCd
	 * @param String pgmNo
	 * @return DBRowSet
     * @throws EventException
     */
	public DBRowSet searchCustmRptForm(String usrId, String usrOfcCd) throws EventException {
		log.debug("searchCustmRptForm!! ");  
		
		try {
			return dbDao.searchCustmRptForm(usrId, usrOfcCd);
		} catch (DAOException ex) {
    		throw new EventException(ex.getMessage(),ex);
    	} catch (Exception ex) {
    		throw new EventException(ex.getMessage(),ex);
    	}
	}
	
	/**
     * user가 customizing하여 선택한 항목에 대한 report setup 정보를 등록 한다.
     * 
     * @param String usrId
	 * @param String usrOfcCd
	 * @param String pgmNo
	 * @param String rptInfoCtnt
     * @throws EventException
     */
	public void insertCustmRptForm(String usrId, String usrOfcCd, String[] coldesc2, String[] chk2) throws EventException {
		
		try {
			dbDao.insertCustmRptForm(usrId, usrOfcCd, coldesc2, chk2);
		} catch (DAOException ex) {
    		throw new EventException(ex.getMessage(),ex);
    	} catch (Exception ex) {
    		throw new EventException(ex.getMessage(),ex);
    	}
	}
	
	/**
     * customized report 저장시 리셋을 위해 기존 user별로 등록된 report setup 정보를 삭제 한다.
     * 
     * @param String usrId
	 * @param String usrOfcCd
	 * @param String pgmNo
	 * @param String rptInfoCtnt
     * @throws EventException
     */
	public void deleteCustmRptForm(String usrId, String usrOfcCd) throws EventException {
		
	
		try {
			dbDao.deleteCustmRptForm(usrId, usrOfcCd);
		} catch (DAOException ex) {
    		throw new EventException(ex.getMessage(),ex);
    	} catch (Exception ex) {
    		throw new EventException(ex.getMessage(),ex);
    	}
	}
	
}