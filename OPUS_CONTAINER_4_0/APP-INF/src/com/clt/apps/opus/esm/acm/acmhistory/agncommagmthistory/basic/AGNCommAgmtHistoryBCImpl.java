/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AgentRateMasterBCImpl.java
*@FileTitle : AgentRateMasterBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.02
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.02 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.basic;

import java.util.List;

import com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.integration.AgncommagmthistoryDBDAO;
import com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.vo.AgncommagmtDetailHistoryVO;
import com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.vo.AgncommagmtMasterHistoryVO;
import com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.vo.AgncommagmthistoryVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;


/**
 * OPUS-ACMAgreement Business Logic Command Interface<br>
 * - OPUS-ACMAgreement에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Young-Oh
 * @see Esm_Acm_0017Event,AGNCommAgmtHistoryBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AGNCommAgmtHistoryBCImpl extends BasicCommandSupport implements AGNCommAgmtHistoryBC {

	// Database Access Object
	private transient AgncommagmthistoryDBDAO dbDao = null;

	/**
	 * FFCmpnAgreementBCImpl 객체 생성<br>
	 * AGNCommAgreementDBDAO를 생성한다.<br>
	 */
	public AGNCommAgmtHistoryBCImpl() {
		dbDao = new AgncommagmthistoryDBDAO();
	}

	/**
	 * [ESM_ACM_0017]
	 * Agent Commission Agreement History (master) - Agreement List 목록을 조회<br>
	 *
	 * @param AgncommagmthistoryVO agncommagmthistoryVO
	 * @return List<AgncommagmthistoryVO>
	 * @exception EventException
	 */
	public List<AgncommagmthistoryVO> searchAgncommagmthistory(AgncommagmthistoryVO agncommagmthistoryVO) throws EventException {
		try {
			return dbDao.searchAgncommagmthistory(agncommagmthistoryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0017]
	 * Agent Commission Agreement History (master) - Master History 목록을 조회<br>
	 *
	 * @param AgncommagmtMasterHistoryVO agncommagmtMasterHistoryVO
	 * @return List<AgncommagmtMasterHistoryVO>
	 * @exception EventException
	 */
	public List<AgncommagmtMasterHistoryVO> searchAgncommagmtMasterHistory(AgncommagmtMasterHistoryVO agncommagmtMasterHistoryVO) throws EventException {
		try {
			return dbDao.searchAgncommagmtMasterHistory(agncommagmtMasterHistoryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * [ESM_ACM_0017]
	 * Agent Commission Agreement History (master) - Detail(Compensation) History 목록을 조회<br>
	 *
	 * @param AgncommagmtDetailHistoryVO agncommagmtDetailHistoryVO
	 * @return List<AgncommagmtDetailHistoryVO>
	 * @exception EventException
	 */
	public List<AgncommagmtDetailHistoryVO> searchAgncommagmtDetailHistory(AgncommagmtDetailHistoryVO agncommagmtDetailHistoryVO) throws EventException {
		try {
			return dbDao.searchAgncommagmtDetailHistory(agncommagmtDetailHistoryVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}