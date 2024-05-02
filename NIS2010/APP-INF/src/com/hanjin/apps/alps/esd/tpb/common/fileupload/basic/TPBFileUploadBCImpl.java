/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : FileUploadBCImpl.java
*@FileTitle : 3자구상 파일업로드 공통팝업
*Open Issues :
*Change history :
*@LastModifyDate : 2009-12-02
*@LastModifier : Sun, CHOI
*@LastVersion : 1.1
* 2009-08-20 O Wan-Ki  1.0 최초생성
* 2009-12-02 Sun, CHOI 1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.fileupload.basic;

import java.util.HashMap;

import com.hanjin.apps.alps.esd.tpb.common.fileupload.event.TPBFileUploadEvent;
import com.hanjin.apps.alps.esd.tpb.common.fileupload.event.TPBFileUploadEventResponse;
import com.hanjin.apps.alps.esd.tpb.common.fileupload.integration.TPBFileUploadDBDAO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * NIS-3rd Party Billing Business Logic Basic Command implementation<br>
 * - NIS-3rd Party Billing에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Sun, CHOI
 * @see TPBFileUploadEventResponse,FileUploadBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class TPBFileUploadBCImpl   extends BasicCommandSupport implements TPBFileUploadBC {

	// Database Access Object
	private transient TPBFileUploadDBDAO dbDao=null;

	/**
	 * FileUploadBCImpl 객체 생성<br>
	 * FileUploadDBDAO를 생성한다.<br>
	 */
	public TPBFileUploadBCImpl(){
		dbDao = new TPBFileUploadDBDAO();
	}
	
	/**
	 * 해당 fileNo의 업로드된 파일정보 조회 이벤트 처리<br>
	 * @param e TPBFileUploadEvent
	 * @return response TPBFileUploadEvent
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse searchUploadFileInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		TPBFileUploadEvent event=(TPBFileUploadEvent)e;
		DBRowSet rowSet=null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		try {
			SignOnUserAccount sa = event.getSignOnUserAccount();
			event.getEventParams().put("user_ofc_cd", sa.getOfc_cd()); /// Add in 2007-04-05

			rowSet=dbDao.searchUploadFileInfo(event);
			return new TPBFileUploadEventResponse(rowSet,"SUCCESS");
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * FileUpload정보 저장(생성) 이벤트 처리<br>
	 * @param e TPBFileUploadEvent
	 * @return EventResponse TPBFileUploadEventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse createUploadFileInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		TPBFileUploadEvent event=(TPBFileUploadEvent)e;
		try {
			SignOnUserAccount sa = event.getSignOnUserAccount();
			event.getEventParams().put("user_id", sa.getUsr_id());
			event.getEventParams().put("user_ofc_cd", sa.getOfc_cd());
			
			String[] fileNoVal = dbDao.createUploadFileInfo(event.getTPB_TTL_FILE_MGMTS(), event);
			return new TPBFileUploadEventResponse(fileNoVal);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * FileUpload정보 삭제(file system, db) 이벤트 처리<br>
	 * @param e TPBFileUploadEvent
	 * @return EventResponse TPBFileUploadEventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse removeUploadFiles(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		TPBFileUploadEvent event=(TPBFileUploadEvent)e;
		HashMap params = event.getEventParams(); 
		try {
			SignOnUserAccount sa = event.getSignOnUserAccount();
			params.put("user_id", sa.getUsr_id());
			params.put("user_ofc_cd", sa.getOfc_cd());
			
			boolean isSuccessFlag = dbDao.removeUploadFiles(event);

			String strSuccessFlag = "false";
			if ( isSuccessFlag ) {
				strSuccessFlag = "true";
			}

			return new TPBFileUploadEventResponse(strSuccessFlag);

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 3rd Party Billing 업무 시나리오 마감작업<br>
	 * FileUpload업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}