/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CommonBCImpl.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :  
*@LastVersion : 1.0
=========================================================*/
 
package com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.basic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.event.EesEqrCodEvent;
import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.integration.CommonDBDAO;
import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.vo.CommonVO;
import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.vo.EesCommonConditionVO;
import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.vo.EesCommonVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EqrCommonVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
 
/**
 * opus-Common Business Logic Basic Command implementation<br>
 *
 * @author 
 * @see ComboxEventResponse,CommonBC 
 * @since J2EE 1.4
 */

public class CommonBCImpl extends BasicCommandSupport implements CommonBC {

	private transient CommonDBDAO dbDao = null;

	/**
	 * CommonBCImpl <br>
	 */
	public CommonBCImpl() {
		dbDao = new CommonDBDAO();
	}

	/**
	 * Common <br>
	 */
	public void doEnd() {
		dbDao = null;
	}

	/**
	 * 
	 * @param e EsmSpcCodEvent
	 * @return EventResponse ESM_SPC_CODEventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse searchCommonCodeList(Event e) throws EventException {
		DBRowSet rowSet = null; 
		GeneralEventResponse response = null;
		if (e.getEventName().equals("EesEqrCodEvent")) {

			EesEqrCodEvent event = (EesEqrCodEvent) e;
			String masterCode = event.getMasterCode();
			//masterCode = "TradeCombo";
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
	 * Search current week  
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
	 * LOC YARD INITIAL <br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 * @화면 기능 : Vendor 코드 조회 
	 */
	public EesCommonVO searchLocYardInitialInfo(EesCommonConditionVO conditionVO) throws EventException {
        String[] result = null;
        String ecc    = conditionVO.getLocyardinitialEcc();  // FROM LOCATION, TO LOCATION
        String vsl    = conditionVO.getLocyardinitialVsl();  // VVD 

    	String vslCd    = "";
    	String skdVoyNo = "";
    	String skdDirCd = "";    	        	    	
		
        String resultFlag = "";  
		try {
				if(vsl.length() == 9) {
					vslCd    = vsl.substring(0,4);
		    		skdVoyNo = vsl.substring(4,8);
		    		skdDirCd = vsl.substring(8,9);    	        	    	
				}
				
				result = dbDao.searchLocVesselYardInitialInfo(ecc, vslCd, skdVoyNo, skdDirCd).getResultStrArray();
				
				if((result[0]==null || result[0].equals("")) && (result[1]==null || result[1].equals(""))) resultFlag = "3";  
				else if(result[1]==null || result[1].equals("")) resultFlag = "1"; 
				else				  			                 resultFlag = "2"; 
				
				if(resultFlag.equals("3")) {  			
					result = dbDao.searchLocYardVesselInfo(ecc).getResultStrArray();		
					resultFlag = "3";		
				}				
				
					
			
			EesCommonVO eesCommonVO = new EesCommonVO();

			eesCommonVO.setResultset7(resultFlag);	 	
			eesCommonVO.setLocyardInitialResult(result);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Search next week
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
	 *  search  Trade List.
	 * 
	 * @return List<EqrCommonVO>
	 * @exception EventException
	 */	
	public List<EqrCommonVO> searchTradeList() throws EventException {
		try {
			return dbDao.searchTradeList();
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
}