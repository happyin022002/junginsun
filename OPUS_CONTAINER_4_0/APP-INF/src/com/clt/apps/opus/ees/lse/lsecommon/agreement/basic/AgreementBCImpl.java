/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgreementRegistrationBCImpl.java
*@FileTitle : Lease Agreement Creation & Update
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.agreement.basic;

import java.util.List;

import com.clt.apps.opus.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementVO;
import com.clt.apps.opus.ees.lse.lsecommon.agreement.integration.AgreementDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * LseCommon Business Logic Basic Command implementation<br>
 *
 * @author
 * @see EES_LSE_0001EventResponse,AgreementRegistrationBC 
 * @since J2EE 1.6
 */
public class AgreementBCImpl extends BasicCommandSupport implements AgreementBC {

	// Database Access Object
	private transient AgreementDBDAO dbDao = null;

	/**
	 * creating AgreementBCImpl object <br>
	 * creating AgreementDBDAO<br>
	 */
	public AgreementBCImpl() {
		dbDao = new AgreementDBDAO();
	}

	/**
	 * retrieving for Lease Agreement with Lease Agreement No.<br>
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
	 * retrieving for Lease Agreement by Vendor term<br>
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
	 * retrieving for Lease Agreement by Vendor <br>
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