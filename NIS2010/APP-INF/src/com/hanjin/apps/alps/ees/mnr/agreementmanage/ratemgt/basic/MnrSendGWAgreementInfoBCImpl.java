/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MnrSendGWAgreementInfoBCImpl.java
*@FileTitle : G/W 전송 xmlData Agreement, AttachFile Info
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.04
*@LastModifier : Chang Young Kim
*@LastVersion : 1.0
* 2009.05.19 Chang Young Kim
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.integration.MnrSendGWAgreementInfoDBDAO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestFileVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**  
 * ALPS MnrSendGWAgreementInfoBCImpl <br>
 * - ALPS - G/W 전송 xmlData Agreement, AttachFile Info의 Business Logic을 처리한다.<br>
 *
 * @author 	Chang Young Kim
 * @see 	ComCsrApprovalBCImpl 참조
 * @since 	J2EE 1.4   
 */
public class MnrSendGWAgreementInfoBCImpl extends BasicCommandSupport implements MnrSendGWAgreementInfoBC {
	
	// Database Access Object
	private transient MnrSendGWAgreementInfoDBDAO dbDao = null;
	 
	/**
	 * MnrSendGWAgreementInfoBCImpl 객체 생성<br>
	 * MnrSendGWAgreementInfoDBDAO 생성한다.<br>
	 */
	public MnrSendGWAgreementInfoBCImpl() {  
		dbDao = new MnrSendGWAgreementInfoDBDAO();  
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
	
	/**
	 * CSR Agreement File Info <br>
	 * 
	 * @param csrNo
	 * * @return List<ComCsrRequestFileVO>
	 */
	public List<ComCsrRequestFileVO> printComCsrFileInfo(String csrNo) throws EventException {
		try {
			return dbDao.printComCsrFileInfo(csrNo);
		} catch (Exception ex) {
			log.error("err "+ex.toString(),ex);
			throw new EventException(ex.getMessage());
		}
	}
}