/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACommAuditBCImpl.java
*@FileTitle : FACommAuditBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.26
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.04.26 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmaudit.facommaudit.basic;

import java.util.List;

import com.clt.apps.opus.esm.acm.acmaudit.facommaudit.integration.FACommAuditDBDAO;
import com.clt.apps.opus.esm.acm.acmaudit.facommaudit.vo.FACCommListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-ACMRequest Business Logic Command Interface<br>
 * - OPUS-ACMReques에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Young-Oh
 * @see Esm_Acm_0028Event,FACommAuditBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class FACommAuditBCImpl extends BasicCommandSupport implements FACommAuditBC {

	// Database Access Object
	private transient FACommAuditDBDAO dbDao = null;

	/**
	 * FACommAuditBCImpl 객체 생성<br>
	 * FACommAuditDBDAO 생성한다.<br>
	 */
	public FACommAuditBCImpl() {
		dbDao = new FACommAuditDBDAO();
	}

	/**
	 * [ESM_ACM_0028]
	 * FAC Audit 목록을 조회<br>
	 *
	 * @param FACCommListVO facCommListVO
	 * @return List<FACCommListVO>
	 * @exception EventException
	 */
	public List<FACCommListVO> searchFACommAudit(FACCommListVO facCommListVO) throws EventException {
		try {
			return dbDao.searchFACommAudit(facCommListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
//	/**
//	 * [ESM_ACM_0028]
//	 * FAC Audit Re Calculate 버튼 클릭 시 처리 한다.<br>
//	 *
//	 * @param String bkg_no
//	 * @param SignOnUserAccount account
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse reCalculateFACAudit(String bkg_no, SignOnUserAccount account) throws EventException{
//		// FAC Commission 계산을 위한 객체
//		ACMCalculationSC acmCalcSC = new ACMCalculationSC();
//		try {
//		    acmCalcSC.reCalculateFACComm(bkg_no, account);
//     		//acmCalcSC.reCalculateFACComm("GOA71150060","  ");
//			return null;
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
//		}
//
//	}

}