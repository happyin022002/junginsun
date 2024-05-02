/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EDI_ENS_001EventResponse.java
 *@FileTitle : USARail WO 신고 정보
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-12-20
 *@LastModifier : Lee Sang-Woo
 *@LastVersion : 1.0
 * 2006-12-20 Lee Sang-Woo
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.usarailwoack.basic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ServerExportException;

import com.clt.apps.opus.esd.trs.servicesio.usarailwoack.integration.USARailWoAckManageDBDAO;
import com.clt.apps.opus.esd.trs.servicesio.usarailwoack.integration.USARailWoAckManageEAIDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * eNIS-BIZCOMMON Business Logic Basic Command implementation<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Lee Sang-Woo
 * @see EdiEns001EventResponse,USARailWoAckManageBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class USARailWoAckManageBCImpl extends BasicCommandSupport implements USARailWoAckManageBC {

	private transient USARailWoAckManageDBDAO dbDao = null;
	private transient USARailWoAckManageEAIDAO eaiDao = null;

	/**
	 * USARailWoAckManageBCImpl 객체 생성<br>
	 * USARailWoAckManageDBDAO를 생성한다.<br>
	 */
	public USARailWoAckManageBCImpl() {
		dbDao = new USARailWoAckManageDBDAO();
		eaiDao = new USARailWoAckManageEAIDAO();
	}

	/**
	 * MQueue를 Receive 처리한다.<br>
	 * 중요 : Receive 경우임; queue-mapping.xml 에 정의되어야 서비스 받을 수 있음.
	 * 
	 * @param param
	 * @return
	 * @throws EventException
	 */
	public int receiveUSARailWoAckManageList(HashMap<Object, Object> param) throws EventException {
		try {
			return dbDao.addUSARailWoAckManageList(param);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * MQueue를 Receive 처리한다.<br>
	 * 중요 : Receive 경우임; queue-mapping.xml 에 정의되어야 서비스 받을 수 있음.
	 * 
	 * @param param
	 * @return
	 * @throws EventException
	 */
	public int receiveUSARailReWoAckManageList(HashMap<Object, Object> param) throws EventException {
		try {
			return dbDao.receiveUSARailReWoAckManageList(param);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * MQueue를 Receive 처리한다.<br>
	 * 중요 : Receive 경우임; queue-mapping.xml 에 정의되어야 서비스 받을 수 있음.
	 * 
	 * @param param
	 * @return
	 * @throws EventException
	 */
	public int receiveManageUSARail417WoAck(HashMap<Object, Object> param) throws EventException {
		try {
			return dbDao.receiveManageUSARail417WoAck(param);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * SPP 해당 경우 fax, mail 전송 처리한다.<br>
	 * 중요 : W 경우만 서비스 받을 수 있음.
	 * 
	 * @param param
	 * @return
	 * @throws arr_param
	 */
	@SuppressWarnings("rawtypes")
	public Collection searchUSARailWoAckManageList(HashMap<Object, Object> param) throws EventException {
		try {
			return dbDao.selectUSARailWoAckManage(param);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry의 event에 대한 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry MESSAGE Send FAX
	 * 
	 * @param arr_param
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	public void faxEdiSendConfirm(ArrayList arr_param) throws EventException {
		try {
			eaiDao.faxEdiSendConfirm(arr_param);
		} catch (ServerExportException se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry의 event에 대한 멀티 이벤트 처리<br>
	 * USA404EDIStatusInquiry MESSAGE Send E-mail
	 * 
	 * @param arr_param
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	public void emailEdiSendConfirm(ArrayList arr_param) throws EventException {
		try {
			eaiDao.emailEdiSendConfirm(arr_param);
		} catch (ServerExportException se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * searchCreditSeqUsaEdiCd
	 * 
	 * @param params
	 * @return DBRowSet
	 * @exception EventException
	 */
	public DBRowSet searchCreditSeqUsaEdiCd(HashMap<String, String> params) throws EventException {
		try {
			return dbDao.searchCreditSeqUsaEdiCd(params);
		} catch (ServerExportException se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * BIZCOMMON 업무 시나리오 마감작업<br>
	 * Continent업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}

}
