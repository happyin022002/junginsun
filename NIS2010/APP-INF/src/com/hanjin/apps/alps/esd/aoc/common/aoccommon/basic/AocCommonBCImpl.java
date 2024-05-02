/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AocCommonBCImpl.java
*@FileTitle : Common
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
* 1.0 Creation
* -----------------------------------------------------------------
* History
* 2012.10.04 변종건 [CHM-201220395] Add-on Tariff Management 개선 프로젝트
* =========================================================*/
package com.hanjin.apps.alps.esd.aoc.common.aoccommon.basic;

import java.sql.SQLException;

import com.hanjin.apps.alps.esd.aoc.common.aoccommon.event.EsdAoc0999Event;
import com.hanjin.apps.alps.esd.aoc.common.aoccommon.integration.AocCommonDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * ALPS-Common Business Logic Command Interface<br>
 * - ALPS-Common에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 
 * @see ESD_AOC_0999EventResponse 참조
 * @since J2EE 1.6
 */
public class AocCommonBCImpl extends BasicCommandSupport implements AocCommonBC {

	// Database Access Object
	private transient AocCommonDBDAO dbDao = null;

	/**
	 * AocCommonBCImpl 객체 생성<br>
	 * AocCommonDBDAO를 생성한다.<br>
	 */
	public AocCommonBCImpl() {
		dbDao = new AocCommonDBDAO();
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 월별,주차별 검색기간 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response ESD_AOC_0999EventResponse
	 * @exception EventException
	 */
	public EventResponse searchPeriod(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdAoc0999Event event=(EsdAoc0999Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FormCommand formcommand = e.getFormCommand();
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet=dbDao.searchPeriod(event);
			eventResponse.setRsVo(rowSet);
			
			if( rowSet.next() ){				
				if( formcommand.isCommand(FormCommand.SEARCH01) ){
					eventResponse.setETCData("FM_DATE", rowSet.getString("FM_DATE"));
					eventResponse.setETCData("TO_DATE", rowSet.getString("TO_DATE"));
				}
			}
			return eventResponse;
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());						
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());			
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} 
	}
	
	
	/**
	 * RHQ Office 조회 : ESD_AOC_3004화면의 SEARCH01 이벤트 처리<br>
	 * 
	 * @param ofcCd
	 * @return
	 * @throws EventException
	 */
	public String searchRHQOfficeCode(String ofcCd) throws EventException{    
		String rhqCd = "";

		try {
			rhqCd = dbDao.searchRHQOfficeCode(ofcCd);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return rhqCd;
	}
	
	/**
	 * Country Code Verify<br>
	 * 
	 * @param cntCd
	 * @return
	 * @throws EventException
	 */
	public String verifyCountryCode(String cntCd) throws EventException{    
		String errFlg = "N";

		try {
			errFlg = dbDao.verifyCountryCode(cntCd);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
		return errFlg;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESD_AOC_0999 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public String searchSubOfficeSOManageList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdAoc0999Event event=(EsdAoc0999Event)e;
		try {
			String subOfcCdArr[] = dbDao.searchSubOfficeSOManageList(event);
			String subOfcCd = "";
			for( int idx = 0; idx < subOfcCdArr.length; idx++ ){
				subOfcCd = subOfcCd  + "," + subOfcCdArr[idx];
			}
			return subOfcCd;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
}