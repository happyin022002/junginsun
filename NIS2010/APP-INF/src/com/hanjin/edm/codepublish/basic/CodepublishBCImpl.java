/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : CodepublishBCImpl.java
 *@FileTitle : 공통코드관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-07
 *@LastModifier : SeongWook Kim
 *@LastVersion : 1.0
 * 2006-09-07 SeongWook Kim
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.edm.codepublish.basic;

import java.util.Collection;
import java.util.Iterator;

import com.hanjin.edm.codepublish.event.ComEdm001Event;
import com.hanjin.edm.codepublish.integration.CodepublishDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.COM_CODEDOMAIN;

/**
 * edm-edm Business Logic Basic Command implementation<br>
 * - edm-edm에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author SeongWook Kim
 * @see CodepublishBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class CodepublishBCImpl extends BasicCommandSupport implements CodepublishBC {

	// Database Access Object
	private transient CodepublishDBDAO dbDao = null;

	/**
	 * CodepublishBCImpl 객체 생성<br>
	 * CodepublishDBDAO를 생성한다.<br>
	 */
	public CodepublishBCImpl() {
		dbDao = new CodepublishDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Codepublish화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response UI_COM_EDM_001EventResponse
	 * @exception EventException
	 */
	/*
	 * public EventResponse searchCodepublishList() throws EventException {
	 * DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체 try {
	 * rowSet=dbDao.searchCodepublishList(); return new
	 * UI_COM_EDM_001EventResponse(rowSet,"SUCCESS"); } catch (DAOException de)
	 * { log.error("err "+de.toString(),de); throw new
	 * EventException(de.getMessage()); } }
	 */

	/**
	 * 조회 이벤트 처리<br>
	 * Codepublish화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            UI_COM_EDM_001Event
	 * @return EventResponse UI_COM_EDM_001EventResponse
	 * @exception EventException
	 */
	/*
	 * public EventResponse searchCodepublish(Event e) throws EventException {
	 * // PDTO(Data Transfer Object including Parameters) UI_COM_EDM_001Event
	 * event=(UI_COM_EDM_001Event)e;
	 * 
	 * // 데이터 전송을 위해 DB ResultSet을 구현한 객체 DBRowSet rowSet=null;
	 * 
	 * try { rowSet=dbDao.searchCodepublish(event.get<<테이블모델>>()); return new
	 * UI_COM_EDM_001EventResponse(rowSet,"SUCCESS"); } catch (DAOException de)
	 * { log.error("err "+de.toString(),de); throw new
	 * EventException(de.getMessage()); } }
	 */

	/**
	 * 추가 이벤트 처리<br>
	 * UI_COM_EDM_001 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e
	 *            UI_COM_EDM_001Event
	 * @return EventResponse UI_COM_EDM_001EventResponse
	 * @exception EventException
	 */
	/*
	 * public EventResponse addCodepublish(Event e) throws EventException { //
	 * PDTO(Data Transfer Object including Parameters) UI_COM_EDM_001Event
	 * event=(UI_COM_EDM_001Event)e;
	 * 
	 * try { dbDao.add<<테이블모델>>(event.get<<테이블모델>>()); return null; } catch
	 * (DAOException de) { log.error("err "+de.toString(),de); throw new
	 * EventException(de.getMessage()); } }
	 */

	/**
	 * 수정 이벤트 처리<br>
	 * UI_COM_EDM_001 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e
	 *            UI_COM_EDM_001Event
	 * @return EventResponse UI_COM_EDM_001EventResponse
	 * @exception EventException
	 */
	/*
	 * public EventResponse modifyCodepublish(Event e) throws EventException {
	 * // PDTO(Data Transfer Object including Parameters) UI_COM_EDM_001Event
	 * event=(UI_COM_EDM_001Event)e;
	 * 
	 * try { dbDao.modify<<테이블모델>>(event.get<<테이블모델>>()); return null; } catch
	 * (DAOException de) { log.error("err "+de.toString(),de); throw new
	 * EventException(de.getMessage()); } }
	 */

	/**
	 * 삭제 이벤트 처리<br>
	 * UI_COM_EDM_001 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param e
	 *            UI_COM_EDM_001Event
	 * @return EventResponse UI_COM_EDM_001EventResponse
	 * @exception EventException
	 */
	/*
	 * public EventResponse removeCodepublish(Event e) throws EventException {
	 * // PDTO(Data Transfer Object including Parameters) UI_COM_EDM_001Event
	 * event=(UI_COM_EDM_001Event)e;
	 * 
	 * try { dbDao.remove<<테이블모델>>(event.get<<테이블모델>>()); return null; } catch
	 * (DAOException de) { log.error("err "+de.toString(),de); throw new
	 * EventException(de.getMessage()); } }
	 */

	/**
	 * 조회 이벤트 처리<br>
	 * Codepublish화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return response UI_COM_EDM_001EventResponse
	 * @exception EventException
	 */
	public DBRowSet searchEDMCodeList(Event e) throws EventException {
		DBRowSet rowSet = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			rowSet = dbDao.searchEDMCodeList(e);
			return rowSet;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Codepublish화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchEDMCodeDetailList(Event e) throws EventException {
		try {
			return dbDao.searchEDMCodeDetailList(e);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Codepublish화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchAPPCodeList(Event e) throws EventException {
		try {
			return dbDao.searchAPPCodeList(e);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Codepublish화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchAPPCodeDetailList(Event e) throws EventException {
		try {
			return dbDao.searchAPPCodeDetailList(e);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * UI_COM_EDM_001 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e UI_COM_EDM_001Event
	 * @param SignOnUserAccount account
	 * @return EventResponse UI_COM_EDM_001EventResponse
	 * @exception EventException
	 */
	public EventResponse multiCodepublish(Event e, SignOnUserAccount account) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ComEdm001Event event = (ComEdm001Event) e;
		Collection models = event.getT_CODEDOMAINS();
		DBRowSet rsMaster = event.getDbrowset1();
		DBRowSet rsDetail = event.getDbrowset2();
		Iterator itr = models.iterator();
		COM_CODEDOMAIN model = null;
		try {
			while (itr.hasNext()) {
				model = (COM_CODEDOMAIN) itr.next();
				if (model.getIbflag().length() > 0) {
					dbDao.deleteAPPCode(model);
				}
			}
			if (rsMaster != null){
				dbDao.addAPPCodeList(rsMaster, account);
			}
			if (rsDetail != null){
				dbDao.addAPPCodeDetailList(rsDetail, account);
			}

		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(),ee);
			throw new EventException(ee.getMessage());
		}
		return null;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * UI_COM_EDM_001 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 * @return EventResponse UI_COM_EDM_001EventResponse
	 * @exception EventException
	 */
	public DBRowSet searchEDMCodeListByCode(Event e) throws EventException {
		try {
			return dbDao.searchEDMCodeListByCode(e);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * UI_COM_EDM_001 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e
	 *            UI_COM_EDM_001Event
	 * @return EventResponse UI_COM_EDM_001EventResponse
	 * @exception EventException
	 */
	public DBRowSet searchEDMCodeDetailListByCode(Event e) throws EventException {
		try {
			return dbDao.searchEDMCodeDetailListByCode(e);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * edm 업무 시나리오 마감작업<br>
	 * Codepublish업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}