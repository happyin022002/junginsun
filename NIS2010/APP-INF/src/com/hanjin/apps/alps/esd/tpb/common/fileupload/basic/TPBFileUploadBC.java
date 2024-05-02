/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FileUploadBC.java
*@FileTitle : 3자구상 파일업로드 공통팝업
*Open Issues :
*Change history :
*@LastModifyDate : 2009-12-02
*@LastModifier : Sun, CHOI
*@LastVersion : 1.1
* 2009-08-20 O Wan-Ki  1.0 최초 생성
* 2009-12-02 Sun, CHOI 1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.fileupload.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * NIS-3rd Party Billing Business Logic Command Interface<br>
 * - NIS-3rd Party Billing에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Sun, CHOI
 * @see TPBFileUploadEventResponse 참조
 * @since J2EE 1.4
 */
public interface TPBFileUploadBC  {

	/**
	 * 해당 fileNo의 업로드된 파일정보 조회 이벤트 처리<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUploadFileInfo(Event e) throws EventException; 
	/**
	 * FileUpload정보 저장(생성) 이벤트 처리<br>
	 * @param e TPBFileUploadEvent
	 * @return EventResponse TPBFileUploadEventResponse
	 * @exception EventException
	 */
	public EventResponse createUploadFileInfo(Event e) throws EventException;
	/**
	 * FileUpload정보 삭제(file system, db) 이벤트 처리<br>
	 * @param e TPBFileUploadEvent
	 * @return EventResponse TPBFileUploadEventResponse
	 * @exception EventException
	 */
	public EventResponse removeUploadFiles(Event e) throws EventException;
}