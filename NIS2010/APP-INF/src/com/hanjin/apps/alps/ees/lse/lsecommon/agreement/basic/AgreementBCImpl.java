/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgreementRegistrationBCImpl.java
*@FileTitle : Lease Agreement Creation & Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.05.22 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.agreement.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementVO;
import com.hanjin.apps.alps.ees.lse.lsecommon.agreement.integration.AgreementDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * NIS2010-LseCommon Business Logic Basic Command implementation<br>
 * - NIS2010-LseCommon 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Nho Jung Yong
 * @see EES_LSE_0001EventResponse,AgreementRegistrationBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AgreementBCImpl extends BasicCommandSupport implements AgreementBC {

	// Database Access Object
	private transient AgreementDBDAO dbDao = null;

	/**
	 * AgreementBCImpl 객체 생성<br>
	 * AgreementDBDAO를 생성한다.<br>
	 */
	public AgreementBCImpl() {
		dbDao = new AgreementDBDAO();
	}

	/**
	 *Lease Agreement No. 로 Lease Agreement 조회<br>
	 * 
	 * @param String agmtCytCd
	 * @param String agmtSeq  
	 * @return List<AgreementVO>
	 * @exception EventException
	 */
	public List<AgreementVO> searchAgreementListBrieflyBasic(String agmtCytCd, String agmtSeq) throws EventException {
		List<AgreementVO> list = null;
		try {
			list = dbDao.searchAgreementBrieflyData(agmtCytCd, agmtSeq);

			if ( list.size() < 1 ) {
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Vendor 가 해당하는 Term의 Lease Agreement 조회<br>
	 * 
	 * @param String vndrSeq
	 * @param String lstmCd
	 * @return List<AgreementVO>
	 * @exception EventException
	 */
	public List<AgreementVO> searchAgreementLessorListBrieflyBasic(String vndrSeq, String lstmCd) throws EventException {
		List<AgreementVO> list = null;
		try {
			list = dbDao.searchAgreementLessorBrieflyData(vndrSeq, lstmCd);

			if ( list.size() < 1 ) {
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return list;
	}

	/**
	 * Vendor 의 Lease Agreement 조회<br>
	 * 
	 * @param String vndrSeq
	 * @return List<AgreementVO>
	 * @exception EventException
	 */
	public List<AgreementVO> searchAgreementByVendorListBrieflyBasic(String vndrSeq) throws EventException {
		List<AgreementVO> list = null;
		try {
			list = dbDao.searchAgreementByVendorBrieflyData(vndrSeq);

			if ( list.size() < 1 ) {
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return list;
	}
}