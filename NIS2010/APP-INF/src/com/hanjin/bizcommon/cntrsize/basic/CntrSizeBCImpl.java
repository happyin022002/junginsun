/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CntrSizeBCImpl.java
*@FileTitle :CntrSize
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-17
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-10-17 Hyung Choon_Roh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.cntrsize.basic;

import com.hanjin.bizcommon.cntrsize.event.ComCom0003EventResponse;
import com.hanjin.bizcommon.cntrsize.integration.CntrSizeDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * eNIS-BIZCOMMON Business Logic Basic Command implementation<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Hyung Choon_Roh
 * @see COM_ENS_0G1EventResponse,CntrTpSzBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CntrSizeBCImpl   extends BasicCommandSupport implements CntrSizeBC {

	// Database Access Object
	private transient CntrSizeDBDAO dbDao=null;

	/**
	 * CntrTpSzBCImpl 객체 생성<br>
	 * CntrTpSzDBDAO를 생성한다.<br>
	 */
	public CntrSizeBCImpl(){
		dbDao = new CntrSizeDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * CntrSize화면에 대한 조회 이벤트 처리<br>
	 * @param Event e
	 * @return EventResponse COM_ENS_0G1EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntrSzList(Event e) throws EventException {
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
        int cnt = 0;
        
        try {
        	cnt    = dbDao.totalCntrSize(e);
            rowSet = dbDao.searchCntrSizeList(e);
            
            ComCom0003EventResponse eventResponse = new ComCom0003EventResponse(rowSet,"SUCCESS");
			eventResponse.setCnt(cnt);
			return eventResponse;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}

	/**
	 * BIZCOMMON 업무 시나리오 마감작업<br>
	 * CntrTpSz업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}
