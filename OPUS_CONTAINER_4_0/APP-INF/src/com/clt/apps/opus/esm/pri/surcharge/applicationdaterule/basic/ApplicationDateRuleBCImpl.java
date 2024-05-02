/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ApplicationDateRuleBCImpl.java
*@FileTitle : Route Location Conversion
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.surcharge.applicationdaterule.basic;

import java.util.List;


import com.clt.apps.opus.esm.pri.surcharge.applicationdaterule.integration.ApplicationDateRuleDBDAO;
import com.clt.apps.opus.esm.pri.surcharge.applicationdaterule.vo.RoutLocCdVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;



/**
 * Applicationdaterule Business Logic Basic Command implementation<br>
 * - Applicationdaterule business logic handling<br>
 *
 * @author 
 * @see ESM_PRI_4034EventResponse,ApplicationDateRuleBC 
 * @since J2EE 1.6
 */
public class ApplicationDateRuleBCImpl extends BasicCommandSupport implements ApplicationDateRuleBC {

	// Database Access Object
	private transient ApplicationDateRuleDBDAO dbDao = null;

	/**
	 * ApplicationDateRuleDBDAO object creation.<br>
	 */
	public ApplicationDateRuleBCImpl() {
		dbDao = new ApplicationDateRuleDBDAO();
	}
	
	
	/**
	 * Route Location conversion List select<br>
	 * @param routLocCdVO
	 * @return List<RoutLocCdVO>
	 * @throws EventException
	 */
	public List<RoutLocCdVO> searchLocationInfo(RoutLocCdVO routLocCdVO) throws EventException {
		try {
			return dbDao.searchLocationInfo(routLocCdVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	/**
	 * Scope code select from Route Location conversion
	 * @return String
	 * @throws EventException
	 */
	public String[] searchScpCd() throws EventException {
		try {
			return dbDao.searchScpCd();
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			
			
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	/**Route Location conversion List Insert, Update, Delete.<br>
	 * @param routLocCdVOs
	 * @param account
	 * @throws EventException
	 */
	public void manageLocationInfo(RoutLocCdVO[] routLocCdVOs,SignOnUserAccount account) throws EventException{
		
		try {			

			
			if(routLocCdVOs!=null && routLocCdVOs.length>0){
				for(int i=0; i<routLocCdVOs.length; i++) {
	
					if (routLocCdVOs[i].getIbflag().equals("I")) {
						dbDao.addLocationInfo(routLocCdVOs[i],account);					
					}else if (routLocCdVOs[i].getIbflag().equals("D")) {
						dbDao.removeLocationInfo(routLocCdVOs[i],account);
					}else if (routLocCdVOs[i].getIbflag().equals("U")) {
						dbDao.modifyLocationInfo(routLocCdVOs[i],account);
	
					}
				}
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), de);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
	}	
	
	/**
	 * check if there is the same data in Route Location conversion List
	 * @param chkScpCd
	 * @param chkOrgCd
	 * @param chkConvCd
	 * @return String
	 * @throws EventException
	 */
	public String checkLocationInfo(String chkScpCd,String chkOrgCd,String chkConvCd) throws EventException{
		

		DBRowSet rowSet = null;						
        String retVal = "";
        try {
            rowSet=dbDao.checkLocationInfo(chkScpCd,chkOrgCd,chkConvCd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		retVal = rowSet.getString(1);
            	}
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        
        return retVal;  
	
	}
	/**
	 * check if there is Location code
	 * @param chkLocation
	 * @return String
	 * @throws EventException
	 */
	public String checkLocationName(String chkLocation) throws EventException{
	
		DBRowSet rowSet = null;							
        String retVal = "";
        try {
            rowSet=dbDao.checkLocationName(chkLocation);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		retVal = rowSet.getString(1);
            	}
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        
        return retVal;  
	}
	/**check if there are the same data in DB
	 * @param chkLocation
	 * @param check_flg
	 * @param chk_scp_cd
	 * @return String
	 * @throws EventException
	 */
	public String checkForScp(String chkLocation,String check_flg,String chk_scp_cd) throws EventException{
		
		DBRowSet rowSet = null;							
        String retVal = "";
        try {
            rowSet=dbDao.checkForScp(chkLocation,check_flg,chk_scp_cd);
            if(rowSet!=null) {
            	while(rowSet.next()){
            		retVal = rowSet.getString(1);
            	}
            }
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        } catch (Exception e){
            log.error("err "+e.toString(),e);
            throw new EventException(e.getMessage());
        }
        
        return retVal;  
	}
}