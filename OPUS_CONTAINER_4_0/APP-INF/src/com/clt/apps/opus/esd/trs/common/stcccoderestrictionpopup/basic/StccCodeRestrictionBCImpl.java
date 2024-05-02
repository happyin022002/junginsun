/*=========================================================
 *	Copyright(c) 2015 CyberLogitec
 *	@FileName 			: StccCodeRestrictionBCImpl.java
 *	@FileTitle 			: 
 *	Open Issues			:
 *	Change history		:
 *	@LastModifyDate 	: 
 *	@LastModifier 		: 
 *	@LastVersion 		: 1.0
 *	1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.common.stcccoderestrictionpopup.basic;

import java.util.List;

import com.clt.apps.opus.esd.trs.common.stcccoderestrictionpopup.event.EsdTrs0939Event;
import com.clt.apps.opus.esd.trs.common.stcccoderestrictionpopup.integration.StccCodeRestrictionDBDAO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.TrsStccCdRstrVO;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * Business Logic Basic Command implementation<br>
 * 
 * @author
 * @see StccCodeRestrictionBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class StccCodeRestrictionBCImpl extends BasicCommandSupport implements StccCodeRestrictionBC {

	private transient StccCodeRestrictionDBDAO dbDao = null;

	/**
	 * StccCodeRestrictionBCImpl<br>
	 * StccCodeRestrictionDBDAO<br>
	 */
	public StccCodeRestrictionBCImpl() {
		dbDao = new StccCodeRestrictionDBDAO();
	}

	/**
	 * 
	 * @param Event event
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	public EventResponse searchStccCodeRestriction(Event event) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			int totalRow = 0;
			EsdTrs0939Event esdTrs0939Event = (EsdTrs0939Event) event;
			TrsStccCdRstrVO searchVo = esdTrs0939Event.getSearchVo();
			List<TrsStccCdRstrVO> trsStccCdRstrVOs = dbDao.searchStccCodeRestriction(searchVo, esdTrs0939Event.getiPage());
			if (trsStccCdRstrVOs.size() > 0) {
				totalRow = dbDao.searchTotalStccCodeRestriction(searchVo);
				trsStccCdRstrVOs.get(0).setMaxRows(totalRow);
			}
			eventResponse.setRsVoList(trsStccCdRstrVOs);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e2) {
			log.error("err " + e2.toString(), e2);
			throw new EventException(e2.getMessage());
		}
		return eventResponse;
	}

	/**
	 * BIZCOMMON 업무 시나리오 마감작업<br>
	 * ServiceProvider업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}
