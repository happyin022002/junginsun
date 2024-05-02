/*=========================================================
*Copyright(c) 2006~2010 CyberLogitec
*@FileName : CommonCodeBCImpl.java
*@FileTitle : 3자구상 유형등록
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-19
*@LastModifier : Sun, CHOI
*@LastVersion : 1.2
*-------------------------------------------------------
* History
* 2006.10.09 Youngchang_Kim 1.0 최초 생성
* 2008.09.10 O Wan-Ki  		1.1  수정 : searchOfficeTopLevel method 추가
* 2009.11.19 Sun, CHOI      1.2 ALPS Migration
* 2010.10.22 손은주 [CHM-201006504-01] [TPB] Currency Change Validation 보완 -  formCommand에 따라 리턴값 형태 변경
* 2010.11.04 변종건 [CHM-201006896-01] [TPB] 소스품질 형상관리
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.combo.basic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;

import com.hanjin.apps.alps.esd.tpb.common.combo.event.CommonCodeEvent;
import com.hanjin.apps.alps.esd.tpb.common.combo.event.CommonCodeEventResponse;
import com.hanjin.apps.alps.esd.tpb.common.combo.integration.CommonCodeDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.CheckUtils;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

 
/**
 * alps-ESD Business Logic Basic Command implementation<br>
 * - alps-ESD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Sun, CHOI
 * @see EsdTpb0001EventResponse,CodeManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CommonCodeBCImpl extends BasicCommandSupport implements CommonCodeBC {

	// Database Access Object
	private transient CommonCodeDBDAO dbDao=null;

	/**
	 * CodeManageBCImpl 객체 생성<br>
	 * CodeManageDBDAO를 생성한다.<br>
	 */
	public CommonCodeBCImpl(){
		dbDao = new CommonCodeDBDAO();
	}

	/**
	 * Office change기능 추가로 인해 session의 ofc_cd를 기준으로 (session이 아닌) MDM의 cnt_cd를 조회 
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
	 * 조회 이벤트 처리<br>
	 * CodeManage화면에 대한 조회 이벤트 처리<br>
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
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			HashMap params = event.getEventParams();
			String sMethod = (String)params.get("method");
			String bil_curr_cd = "";
			
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
					bil_curr_cd = bil_curr_cd + "|" +rowSet.getString("BIL_CURR_CD");
				}
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
	 * Select Box용 Html Text를 얻기 위한 정보 조회 처리<br>
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
	 * Office Code를 기초로 Office Level조회 처리<br>
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
	 * Office Code를 기초로 Handling Office Level조회 처리<br>
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
	 * [비즈니스대상]을 [행위] 합니다.<br>
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
	 * [비즈니스대상]을 [행위] 합니다.<br>
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
	 * Office가 TPB Office인지 여부 Y/N 조회 <br>
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
	 * TES내에서 TPB Billing Case 조회 처리<br>
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
	
	/**
	 * ROC office Code 조회.<br>
	 * @param String n3ptyCd
	 * @return String
	 * @throws EventException
	 */
	public String searchCheckTPBROCOffice(String n3ptyCd) throws EventException {

		DBRowSet rowSet = null;							
        String retVal = "";
        
        try {
            rowSet=dbDao.searchCheckTPBROCOffice(n3ptyCd);
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