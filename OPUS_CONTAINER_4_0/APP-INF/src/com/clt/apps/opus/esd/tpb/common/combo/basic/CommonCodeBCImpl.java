/*=========================================================
*Copyright(c) 2006~2010 CyberLogitec
*@FileName : CommonCodeBCImpl.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.common.combo.basic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;

import com.clt.apps.opus.esd.tpb.common.combo.event.CommonCodeEvent;
import com.clt.apps.opus.esd.tpb.common.combo.event.CommonCodeEventResponse;
import com.clt.apps.opus.esd.tpb.common.combo.integration.CommonCodeDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.CheckUtils;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

 
/**
 * -ESD Business Logic Basic Command implementation<br>
 * - -ESD Business Logic Processing<br>
 * 
 * @author 
 * @see EsdTpb0001EventResponse,CodeManageBC DAO class reference
 * @since J2EE 1.4
 */
public class CommonCodeBCImpl extends BasicCommandSupport implements CommonCodeBC {

	// Database Access Object
	private transient CommonCodeDBDAO dbDao=null;

	/**
	 * CodeManageBCImpl object creation<br>
	 * CodeManageDBDAO creation<br>
	 */
	public CommonCodeBCImpl(){
		dbDao = new CommonCodeDBDAO();
	}

	/**
	 * retrieving cnt_cd of MNR base by ofc_cd of session 
	 * @param ofc_cd
	 * @return String
	 * @throws EventException
	 */
	public String getMDMCntCd(String ofc_cd) throws EventException {
		String cntCd = null;
		
		try {
			cntCd = dbDao.getMDMCntCd(ofc_cd);
			
		} catch (DAOException de) {
			cntCd = null;
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			cntCd = null;
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage());
		}
		return cntCd;
	}	
	
	/**
	 * retrieve event<br>
	 * CodeManage screen retrieve event<br>
	 * 
	 * @param e EsdTpb001Event
	 * @return EventResponse EsdTpb001EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse searchCommonCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CommonCodeEvent event=(CommonCodeEvent)e;
		FormCommand formcommand = e.getFormCommand();
		
		DBRowSet rowSet=null;
		
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			HashMap params = event.getEventParams();
			String sMethod = (String)params.get("method");
			String bil_curr_cd = "";
			StringBuffer bil_curr_cd_buf = new StringBuffer();
			
			Class oClass = dbDao.getClass();
			Class[] parameterTypes = new Class[]{};
			Constructor constructor = oClass.getConstructor(parameterTypes);
			Object oObj = constructor.newInstance(new Object[]{});
			
			parameterTypes = new Class[]{CommonCodeEvent.class};
			Method method = oClass.getMethod(sMethod, parameterTypes);
			Object[] parameters = new Object[]{ event };
			rowSet = (DBRowSet)method.invoke(oObj, parameters);
			
			
			if(CheckUtils.isNull(formcommand)){
				eventResponse.setRs(rowSet);
				return eventResponse;
			}
			
			if(formcommand.isCommand(FormCommand.SEARCH01)){
				while(rowSet.next()){
//					bil_curr_cd = bil_curr_cd + "|" +rowSet.getString("BIL_CURR_CD");
					bil_curr_cd_buf.append("|").append(rowSet.getString("BIL_CURR_CD"));
				}
				bil_curr_cd = bil_curr_cd_buf.toString();
				eventResponse.setETCData("BIL_CURR_CD",bil_curr_cd);
				return eventResponse;
			} else{
				eventResponse.setRs(rowSet);
				return eventResponse;
			}
			
		} catch (Exception de) {
			log.error("err "+de.toString(),de);
				throw new EventException(de.getMessage());
		}
	}
	/**
	 * getting info retrieving for Html Text of Select Box<br>
	 * @param mainCode 
	 * @param sDefaultSelectCode 
	 * @param addOptionInfo 
	 * @param codeConditionPositiveArr 
	 * @param codeConditionNegativeArr 
	 * @param sortKey 
	 * @return 
	 * @exception EventException
	 */
	public DBRowSet searchCodeComboData(
			String mainCode, 
			String sDefaultSelectCode, 
			String[][] addOptionInfo, 
			String[] codeConditionPositiveArr, 
			String[] codeConditionNegativeArr, 
			int sortKey
			) throws EventException {
		
		try {
			return dbDao.searchCodeComboData(mainCode, sDefaultSelectCode, addOptionInfo, codeConditionPositiveArr, codeConditionNegativeArr, sortKey);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * Office Level retrieve process<br>
	 * @param officeCode - Office Code 
	 * @return String[] - Office Level / Office Code / RHQ Code / Head Office Code
	 * @exception EventException
	 */
	public String[] searchOfficeLevel(String officeCode) throws EventException{
		try {
			return dbDao.searchOfficeLevel(officeCode);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
 
	}
	/**
	 * Handling Office Level retrieve<br>
	 * @param String officeCode
	 * @param boolean isIncludeControlOffice
	 * @return String[] - Office Level / Office Code / RHQ Code / Head Office Code
	 * @exception EventException
	 */
	public String[] searchHandleOfficeLevel(String officeCode, boolean isIncludeControlOffice) throws EventException {
		try {
			return dbDao.searchHandleOfficeLevel(officeCode, isIncludeControlOffice);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * <br>
	 * 
	 * @param String officeCode
	 * @return String
	 * @exception EventException
	 */
	public String searchOfficeTopLevel(String officeCode) throws EventException{
		try {
			return dbDao.searchOfficeTopLevel(officeCode);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * <br>
	 * 
	 * @return String
	 * @exception EventException
	 */
	public String searchTPBSeq() throws EventException{
		try {
			return dbDao.searchTPBSeq();
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	/**
	 * <br>
	 * @param officeCode - Office Code 
	 * @return String - Y/N
	 * @exception EventException
	 */
	public String searchIsTPBOffice(String officeCode) throws EventException{
		try {
			return dbDao.searchIsTPBOffice(officeCode);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
 
	}
	
	/**
	 *  TPB Billing Case retrieve<br>
	 * @return EventResponse EsdTpb001EventResponse
	 * @exception EventException
	 */
	public EventResponse searchBillingCaseCodeByTES() throws EventException{
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse	= new GeneralEventResponse();
		
		try {
			eventResponse.setRs( dbDao.searchBillingCaseCodeByTES() );
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
}