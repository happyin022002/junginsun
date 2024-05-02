/*=========================================================
 *Copyright(c) 2016 CyberLogitec
 *@FileName : ExceptionAckRailRoadBCImpl.java
 *@FileTitle : Exception Ack Rail Road
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016-04-19
 *@LastModifier : S.W. KIM
 *@LastVersion : 1.0
 * 2016-04-19 ksw	   	1.0  최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.exceptionackrailroad.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.trs.codemanage.exceptionackrailroad.event.EsdTrs0077Event;
import com.clt.apps.opus.esd.trs.codemanage.exceptionackrailroad.integration.ExceptionAckRailRoadDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.TrsExptAckRailVndrVO;

/**
 * ESD-ExceptionAckRailRoad Business Logic Basic Command implementation<br>
 * - ESD-ExceptionAckRailRoad handling business logic.<br>
 * 
 * @author
 * @see ESD_TRS_0077EventResponse,ExceptionAckRailRoadBC refer to each DAO classes
 * @since
 */
public class ExceptionAckRailRoadBCImpl extends BasicCommandSupport implements ExceptionAckRailRoadBC {

	private transient ExceptionAckRailRoadDBDAO dbDao = null;

	/**
	 * ExceptionAckRailRoadBCImpl objects creation<br>
	 * Generate ExceptionAckRailRoadDBDAO.<br>
	 */
	public ExceptionAckRailRoadBCImpl() {
		dbDao = new ExceptionAckRailRoadDBDAO();
	}

	/**
	 * Exception Rail Road Vendor - RETRIEVE
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchExceptionAckRailRoadVendorList(Event e) throws EventException {
		GeneralEventResponse response = new GeneralEventResponse();
		EsdTrs0077Event event = (EsdTrs0077Event) e;
		try {
			response.setRs(dbDao.searchExceptionAckRailRoadVendorList(event));
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage());
		}
		return response;
	}

	/**
	 * Exception Rail Road Vendor - SAVE
	 * 
	 * @param e
	 * @throws EventException
	 */
	public void multiExceptionAckRailRoadVendor(Event e) throws EventException {
		EsdTrs0077Event event = (EsdTrs0077Event) e;
		TrsExptAckRailVndrVO[] trsExptAckRailVndrVOs = event.getTrExptAckRailVndrVOs();
		List<TrsExptAckRailVndrVO> insertVos = new ArrayList<TrsExptAckRailVndrVO>();
		List<TrsExptAckRailVndrVO> updateVos = new ArrayList<TrsExptAckRailVndrVO>();
		String loginUserId = e.getSignOnUserAccount().getUsr_id();
		for (TrsExptAckRailVndrVO vo : trsExptAckRailVndrVOs) {
			vo.setCreUsrId(loginUserId);
			vo.setUpdUsrId(loginUserId);
			if ("I".equals(vo.getIbflag())) {
				insertVos.add(vo);
			} else if ("U".equals(vo.getIbflag()) || "D".equals(vo.getIbflag())) {
				updateVos.add(vo);
			}
		}
		if (!updateVos.isEmpty()) {
			try {
				for (TrsExptAckRailVndrVO vo : updateVos) {
					dbDao.multiExceptionAckRailRoadVendor(vo);
				}
			} catch (DAOException ex) {
				throw new EventException(ex.getMessage());
			}
		}
		if (!insertVos.isEmpty()) {
			try {
				if (!dbDao.checkDuplcateVendor(insertVos)) {
					for (TrsExptAckRailVndrVO vo : insertVos) {
						vo.setExptAckRailVndrSeq(vo.getVndrSeq());
						dbDao.multiExceptionAckRailRoadVendor(vo);
					}
				} else {
					throw new EventException(new ErrorHandler("TRS00007").getMessage());
				}
			} catch (DAOException ex) {
				throw new EventException(ex.getMessage());
			}
		}
	}

	/**
	 * 
	 */
	public void doEnd() {
		dbDao = null;
	}
}