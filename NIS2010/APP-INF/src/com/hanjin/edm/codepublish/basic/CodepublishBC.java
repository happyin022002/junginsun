/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CodepublishBC.java
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

import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * edm-edm Business Logic Command Interface<br>
 * - edm-edm에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SeongWook Kim
 * @see ComEdm001EventResponse 참조
 * @since J2EE 1.4
 */
public interface CodepublishBC  {

	/**
	 * 멀티 이벤트 처리<br>
	 * UI_COM_EDM_001 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e UI_COM_EDM_001Event
	 * @param SignOnUserAccount a
	 * @return EventResponse UI_COM_EDM_001EventResponse
	 * @exception EventException
	 */
	public EventResponse multiCodepublish(Event e, SignOnUserAccount a) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Codepublish화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchEDMCodeList(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Codepublish화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchEDMCodeDetailList(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Codepublish화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchAPPCodeList(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Codepublish화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchAPPCodeDetailList(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Codepublish화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchEDMCodeListByCode(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Codepublish화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return response UI_COM_EDM_001EventResponse
	 * @exception EventException
	 */
	public DBRowSet searchEDMCodeDetailListByCode(Event e) throws EventException;

}