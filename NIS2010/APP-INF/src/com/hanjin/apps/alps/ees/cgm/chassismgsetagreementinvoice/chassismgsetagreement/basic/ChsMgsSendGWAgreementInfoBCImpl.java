/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ChsMgsSendGWAgreementInfoBCImpl.java
*@FileTitle : G/W 전송 xmlData Agreement Info
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.13
*@LastModifier : Chang Young Kim
*@LastVersion : 1.0
* 2009.05.19 Chang Young Kim
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.integration.ChsMgsSendGWAgreementInfoDBDAO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS ChsMgsSendGWAgreementInfoBCImpl <br>
 * - ALPS - G/W 전송 xmlData Agreement Info의 Business Logic을 처리한다.<br>
 * 
 * @author Chang Young Kim
 * @see ComCsrApprovalBCImpl, ChsMgsSendGWAgreementInfoBC, 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ChsMgsSendGWAgreementInfoBCImpl extends BasicCommandSupport implements ChsMgsSendGWAgreementInfoBC {

	// Database Access Object
	private transient ChsMgsSendGWAgreementInfoDBDAO dbDao = null;

	/**
	 * ChsMgsSendGWAgreementInfoBCImpl 객체 생성<br>
	 * ChassisMgsetAgreementDBDAO를 생성한다.<br>
	 */
	public ChsMgsSendGWAgreementInfoBCImpl() {
		dbDao = new ChsMgsSendGWAgreementInfoDBDAO();
	}
	
	/**
	 * CSR Agreement Info List <br>
	 * 
	 * @param csrNo
	 * @return List<ComCsrRequestAgmtVO>
	 */
	public List<ComCsrRequestAgmtVO> printComCsrAgmtInfo(String csrNo) throws EventException {
		try {
			return dbDao.printComCsrAgmtInfo(csrNo);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage());
		}
	}
	
	/**
	 * CSR Agreement Info List <br>
	 * CSR No. + VNDR Seq. + Inv No. 추가
	 * 
	 * @param csrNo
	 * @return List<ComCsrRequestAgmtVO>
	 */
	public List<ComCsrRequestAgmtVO> printComCsrAgmtInfo2(String csrNo) throws EventException {
		try {
			return dbDao.printComCsrAgmtInfo2(csrNo);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage());
		}
	}
}