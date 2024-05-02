/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MtyRepoSelectPopupBCImpl.java
*@FileTitle : 엠티리포
*Open Issues :
*Change history :
*@LastModifyDate : 2009-03-19
*@LastModifier : eunju son
*@LastVersion : 1.0
* 2009-03-19 eunju son
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.mtyreposelectpopup.basic;


import com.hanjin.apps.alps.esd.trs.common.mtyreposelectpopup.event.EsdTrs0909Event;
import com.hanjin.apps.alps.esd.trs.common.mtyreposelectpopup.integration.MtyRepoSelectPopupDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;



/**
 * ENIS-MtyRepoSelectPopup Business Logic Basic Command implementation<br>
 * - ENIS-MtyRepoSelectPopup에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author eunju son
 * @see ESD_TRS_909EventResponse,MtyRepoSelectPopupBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class MtyRepoSelectPopupBCImpl   extends BasicCommandSupport implements MtyRepoSelectPopupBC {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Database Access Object
	private transient MtyRepoSelectPopupDBDAO dbDao=null;

	/**
	 * MtyRepoSelectPopupBCImpl 객체 생성<br>
	 * MtyRepoSelectPopupDBDAO를 생성한다.<br>
	 */
	public MtyRepoSelectPopupBCImpl(){
		dbDao = new MtyRepoSelectPopupDBDAO();
	}

	
	/**
	 * 조회 이벤트 처리<br>
	 * MtyRepoSelectPopup화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e ESD_TRS_909Event
	 * @return EventResponse GeneralEventResponse
	 * @exception EventException
	 */
	public EventResponse searchMtyRepoSelectPopup(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0909Event event=(EsdTrs0909Event)e;
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet=null;
		
		try {
			rowSet=dbDao.searchMtyRepoSelectPopup(event);
			//return new EsdTrs909EventResponse(rowSet,"SUCCESS");
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			eventResponse.setRsVo(rowSet);
			return eventResponse;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	


	/**
	 * MtyRepoSelectPopup 업무 시나리오 마감작업<br>
	 * MtyRepoSelectPopup업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}