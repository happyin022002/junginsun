/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CommonBCImpl.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 2013-05-27
*@LastModifier :  SHIN DONG IL
*@LastVersion : 1.0
* 2013-05-27  SHIN DONG IL
* 1.0 Creation
=========================================================*/
 
package com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.basic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.event.EesEqrCodEvent;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.integration.CommonDBDAO;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.vo.CommonVO;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.vo.EesCommonConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.vo.EesCommonVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
 
/**
 * alps-Common Business Logic Basic Command implementation<br>
 * - alps-Common에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author SHIN DONG IL
 * @see ComboxEventResponse,CommonBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class CommonBCImpl extends BasicCommandSupport implements CommonBC {

	private transient CommonDBDAO dbDao = null;

	/**
	 * CommonBCImpl 객체를 생성<br>
	 * CommonDBDAO를  생성한다.<br>
	 */
	public CommonBCImpl() {
		dbDao = new CommonDBDAO();
	}

	/**
	 * Common 업무 시나리오 마감작업<br>
	 * Common업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Common화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e EsmSpcCodEvent
	 * @return EventResponse ESM_SPC_CODEventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse searchCommonCodeList(Event e) throws EventException {
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		GeneralEventResponse response = null;
		if (e.getEventName().equals("EesEqrCodEvent")) {
			// PDTO(Data Transfer Object including Parameters)
			EesEqrCodEvent event = (EesEqrCodEvent) e;
			String masterCode = event.getMasterCode();
			
			Method m;
			try {
				m = dbDao.getClass().getMethod("search" + masterCode + "List",
						new Class[] { HashMap.class });
				HashMap map = event.getParams();
				map.put("login_usr_id", event.getSignOnUserAccount().getUsr_id());
				map.put("login_usr_ofc_cd", event.getSignOnUserAccount().getOfc_cd());
				rowSet = (DBRowSet) m.invoke(dbDao, new Object[] { map });
			} catch (SecurityException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage());
			} catch (NoSuchMethodException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage());
			} catch (IllegalArgumentException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage());
			} catch (IllegalAccessException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage());
			} catch (InvocationTargetException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage());
			}
			response = new GeneralEventResponse();
			response.setRsVo(rowSet);
		}
		return response;
	}
	
	/**
	 * 현재주차 정보를 조회 
	 *     
	 * @param yyyyww
	 * @param nextNum 
	 * @param direction 
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO getCurrentWeek() throws EventException {
		CommonVO nextWeek = null;  

		try {				
			nextWeek = dbDao.todayWeekly();           
			return nextWeek;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 * LOC YARD INITIAL 검색 이벤트 처리<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 * @화면 기능 : Vendor 코드 조회 
	 */
	public EesCommonVO searchLocYardInitialInfo(EesCommonConditionVO conditionVO) throws EventException {
        String[] result = null;
        String ecc    = conditionVO.getLocyardinitialEcc();  // FROM LOCATION, TO LOCATION
        String vsl    = conditionVO.getLocyardinitialVsl();  // VVD 정보 (WATER 모드의 경우 VVD 가 없을수도 있음)
        String tmp   = conditionVO.getTmp(); // hard code 여부

    	String vslCd    = "";
    	String skdVoyNo = "";
    	String skdDirCd = "";    	        	    	
		
        String resultFlag = "";  // 검색결과 표현(중요)  1 : 1개 yard검색, 2 : 복수개 vessel yard 검색, 3 : mdm_yard 검색 
		try {
			/* ITEM (V, W) + VSL 정보로 1차 판단
			 * 1. Vessel OR Water(VVD 있는  경우) 
			 * - 1 STEP 
			 *     VSK_VSL_PORT_SKD 에서 YARD 검색 (VVD + LOCATION)  
			 * - 2 STEP 
			 *     1STEP 검색결과 NULL : MDM YARD 검색 (CODE, NAME)
			 *     1STEP 검색결과 존재   : 검색값을 화면에 표현 (1개 이거나 1개 이상)  
			 * 
			 * 2. Water(VVD 없는 경우)
			 * - 1 STEP 
			 *     PRD_PORT_TML_MTX 에서 YARD 검색 (FDR 검색)   
			 * - 2 STEP 
			 *     1STEP 검색결과 NULL : MDM YARD 검색 (CODE, NAME)
			 *     1STEP 검색결과 존재   : 검색값을 화면에 표현 (1개)   
			 */
			
			

				//1 STEP : VSK_VSL_PORT_SKD 에서 YARD 검색 (VVD + LOCATION)
				if(vsl.length() == 9) {
					vslCd    = vsl.substring(0,4);
		    		skdVoyNo = vsl.substring(4,8);
		    		skdDirCd = vsl.substring(8,9);    	        	    	
				} 
				
				result = dbDao.searchLocVesselYardInitialInfo(ecc, vslCd, skdVoyNo, skdDirCd, tmp).getResultStrArray();
				
				if((result[0]==null || result[0].equals("")) && (result[1]==null || result[1].equals(""))) resultFlag = "3"; // 1STEP 검색결과 NULL 
				else if(result[1]==null || result[1].equals("")) resultFlag = "1"; // 1개의   vessel schedule yard 검색됨.
				else				  			                 resultFlag = "2"; // 2개 이상의 vessel schedule yard 검색됨.
				
				//1STEP 검색결과 NULL : MDM VESSEL YARD 검색 (CODE, NAME)
				if(resultFlag.equals("3")) {  			
					result = dbDao.searchLocYardVesselInfo(ecc).getResultStrArray();		
					resultFlag = "3";		
				}				
				
					
			
			EesCommonVO eesCommonVO = new EesCommonVO();

			eesCommonVO.setResultset7(resultFlag);	 // resultFlag 3가지(1,2,3)중에 하나를 view 에서 봐야함.		
			eesCommonVO.setLocyardInitialResult(result);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 기준 week의 다음주(nextNum) 정보를 가져옵니다.
	 * ex) nextNum = 1 --> 기준주의 1주 다음
	 *     nextNum = 2 --> 기준주의 2주 다음
	 * ex) direction --> NEXT : 미래주차
	 *     direction --> PREV : 과거주차
	 *     
	 * @param yyyyww
	 * @param nextNum 
	 * @param direction 
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO getNextPrevWeek(String yyyyww, int nextNum, String direction) throws EventException {
		CommonVO nextWeek = null;  

		try {				
			nextWeek = dbDao.getNextPrevWeek(yyyyww, nextNum, direction);           
			return nextWeek;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 * LOC YARD Exist 이벤트 처리<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 * @화면 기능 : Vendor 코드 조회 
	 */
	public EesCommonVO searchLocYardExist(EesCommonConditionVO conditionVO) throws EventException {		
		EesCommonVO eesCommonVO = new EesCommonVO();
        String result = null;
        String ecc    = conditionVO.getLocyardexistEcc();
        String locyard= conditionVO.getLocyardexistLocyard();
       
		try {
			log.debug("------------------- COMMON BC IMPL ");
			result = dbDao.searchLocYardExist(locyard, ecc).getResultString();
			eesCommonVO.setLocyardExistResult(result);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * LOC YARD(vessel) 검색 이벤트 처리<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 * @화면 기능 : Vendor 코드 조회 
	 */
	public EesCommonVO searchLocYardVesselInfo(EesCommonConditionVO conditionVO) throws EventException {	
        String[] result = null;
       
		try {
			log.debug("BC 20 searchLocYardVesselInfo======");
			
			result = dbDao.searchLocYardVesselInfo(conditionVO.getLocyardSearchword()).getResultStrArray();
			EesCommonVO eesCommonVO = new EesCommonVO();
			
			eesCommonVO.setLocyardResult(result);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}		
		
}