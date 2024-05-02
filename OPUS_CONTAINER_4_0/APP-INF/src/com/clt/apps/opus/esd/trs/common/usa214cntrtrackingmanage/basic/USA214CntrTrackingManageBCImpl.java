/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : Usa214CntrTrackingManageBCImpl.java
*@FileTitle : USA 214 CONTAINER TRACKING
*Open Issues :
*Change history :
*@LastModifyDate : 2008-07-18
*@LastModifier : Park Jun-Yong
*@LastVersion : 1.0
* 2008-07-18 Park Jun-Yong
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.common.usa214cntrtrackingmanage.basic;

import com.clt.apps.opus.esd.trs.common.usa214cntrtrackingmanage.event.USA214CntrTrackingManageEvent;
import com.clt.apps.opus.esd.trs.common.usa214cntrtrackingmanage.integration.USA214CntrTrackingManageDBDAO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * USA 214 CONTAINER TRACKING<br>
 * - TRS 테이블 갱신을 위해 SCEM에 제공하는 메소드<br>
 * 
 * @author Park Jun-Yong
 * @see USA214CntrTrackingBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class USA214CntrTrackingManageBCImpl   extends BasicCommandSupport implements USA214CntrTrackingManageBC {

	// Database Access Object
	private transient USA214CntrTrackingManageDBDAO dbDao=null;

	/**
	 * USA214CntrTrackingManageBCImpl 객체 생성<br>
	 * USA214CntrTrackingManageDBDAO 생성한다.<br>
	 */
	public USA214CntrTrackingManageBCImpl(){
		dbDao = new USA214CntrTrackingManageDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * USA214CntrTracking화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e USA214CntrTrackingManageEvent
	 * @return NULL
	 * @exception EventException
	 */
	public String usa214CntrTracking(Event e) throws EventException {	
		USA214CntrTrackingManageEvent event = (USA214CntrTrackingManageEvent)e;
		try {
			dbDao.usa214CntrTracking(event);
			return null;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}


	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * USA214CntrTracking업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}