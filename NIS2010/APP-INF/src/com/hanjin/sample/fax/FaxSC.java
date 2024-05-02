/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FaxSC.java
 *@FileTitle : fax_send
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.01
 *@LastModifier : 김정훈
 *@LastVersion : 1.0
 * 2009.06.01 김정훈
 * 1.0 Creation
=========================================================*/
package com.hanjin.sample.fax;

import com.hanjin.framework.component.util.InformationUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.sample.fax.faxsend.basic.FaxSendBC;
import com.hanjin.sample.fax.faxsend.basic.FaxSendBCImpl;
import com.hanjin.sample.fax.faxsend.event.FaxSendEvent;

/**
 * NIS2010-Fax Business Logic ServiceCommand - NIS2010-Fax 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Jeong-Hoon, Kim
 * @see FaxSendDBDAO
 * @since J2EE 1.6
 */

public class FaxSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Fax system 업무 시나리오 선행작업<br>
	 * fax_send업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("FaxSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * Fax system 업무 시나리오 마감작업<br>
	 * fax_send 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("FaxSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-Fax system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		begin();
		eventResponse = comFaxSndInfoVO(e);
		commit();

		/**
		 * BPM 연동 처리 부분 ( BPM POC 이후 삭제 필요 )
		 */
		String serverName = com.hanjin.framework.component.util.InformationUtil.getWebApplicationServerName();
		if ("AdminServer".equals(serverName) // Local Server
				|| "ALPSDEVMA".equals(serverName) // ALPS Test A
				|| "ALPSDEVMB".equals(serverName) // ALPS Test B
				|| "ktx6600b".equals(serverName.substring(0, 7)) // ALPS Batch
		) {
			/*
			 * Procedure Argument Setting 단계별로 정해진 correlation 와 message XML 을 설정한다. ( 각 Event 별 설정 필요 )
			 */
			String correlation = "BPM_TEST_01";
			String msgXml = "<BUSINESS_DATA_DOC xmlns=\"http://koemsoa.koem.or.kr/bpm/MasterTypes\">" + "<CORRELATION_ID>dpcs_siid_20110314_02</CORRELATION_ID>" + "<EVENT_KEY>20110314_02</EVENT_KEY>" + "<APPROVER>system</APPROVER>" + "<NEXT_APPROVER></NEXT_APPROVER>" + "</BUSINESS_DATA_DOC>";
			bpmInterface(correlation, msgXml);
		}

		return eventResponse;
	}

	/**
	 * BPM Interface 를 위한 method 로 203.246.151.29 에 설치된 Oracle 에 Connection 해서 Procedure 호출로 AQ 에 DATA 를 넣는 기능을 처리한다. ( BPM POC 이후 삭제 필요 )
	 * 
	 * @param correlation
	 *            String
	 * @param msgXml
	 *            String
	 * @return void
	 * @exception EventException
	 */
	private void bpmInterface(String correlation, String msgXml) {
		java.sql.Connection connection = null;
		java.sql.CallableStatement statement = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			java.sql.DriverManager.setLoginTimeout(10); // Login Timeout 설정
			String url = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=203.246.151.29)(PORT=1521))(CONNECT_DATA=(SERVER=DEDICATED)(SID=ORASOA)))";
			connection = java.sql.DriverManager.getConnection(url, "orabpm", "orabpm");
			statement = connection.prepareCall("{ CALL BPM_ALPS_IF_PRC(?,?)}");
			statement.setString(1, correlation); // Correlation
			statement.setString(2, msgXml); // Message XML

			statement.setQueryTimeout(20); // Login Timeout 설정
			statement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (Exception e) {
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
				}
			}
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * FaxSend의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse comFaxSndInfoVO(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FaxSendEvent event = (FaxSendEvent) e;
		FaxSendBC command = new FaxSendBCImpl();

		try {
			String returnKey = command.comFaxSndInfoVO(event.getComFaxSndInfoVO());
			eventResponse.setCustomData("key", returnKey);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
}