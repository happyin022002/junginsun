/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ChargeBCImpl.java
*@FileTitle : Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2012-02-20
*@LastModifier : JunBum Lee
*@LastVersion : 1.0
* 202-02-20 JunBum Lee
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.daylightsavingtime.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.bizcommon.daylightsavingtime.integration.DaylightSavingTimeDBDAO;
import com.hanjin.bizcommon.daylightsavingtime.vo.DaylightSavingTimeListVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
/**
 * eNIS-BIZCOMMON Business Logic Basic Command implementation<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Hyung Choon_Roh
 * @see COM_ENS_0N1EventResponse,ChargeBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class DaylightSavingTimeBCImpl   extends BasicCommandSupport implements DaylightSavingTimeBC {

	// Database Access Object
	private transient DaylightSavingTimeDBDAO dbDao=null;

	/**
	 * ChargeBCImpl 객체 생성<br>
	 * ChargeDBDAO를 생성한다.<br>
	 */
	public DaylightSavingTimeBCImpl(){
		dbDao = new DaylightSavingTimeDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * DaylightSavingTimeList 화면에 대한 조회 이벤트 처리<br>
	 * @param DaylightSavingTimeListVO daylightSavingTimeListVO
	 * @param int iPage
	 * @return List<DaylightSavingTimeListVO>
	 * @exception EventException
	 */
	public List<DaylightSavingTimeListVO> searchDaylightSavingTimeList(DaylightSavingTimeListVO daylightSavingTimeListVO, int iPage) throws EventException {
        int cnt = 0;
        List<DaylightSavingTimeListVO> list = null;
        
        try {
        	cnt    = dbDao.totalDaylightSavingTime(daylightSavingTimeListVO);
        	list   = dbDao.searchDaylightSavingTimeList(daylightSavingTimeListVO, iPage);
        	if(list.size()>0){
        		list.get(0).setMaxRows(cnt);
        	}
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
		} catch (Exception e2) {
			log.error("err "+e2.toString(),e2);
            throw new EventException(e2.getMessage());
		}
		return list;
	}
	
	/**
	 * BIZCOMMON 업무 시나리오 마감작업<br>
	 * Charge업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}