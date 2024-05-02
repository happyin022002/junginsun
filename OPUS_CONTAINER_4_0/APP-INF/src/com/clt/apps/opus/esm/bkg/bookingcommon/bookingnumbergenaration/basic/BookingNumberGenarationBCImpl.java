/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingNumberGenarationBCImpl.java
*@FileTitle : BookingNumberGenarationBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.05
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.02.05 김기종
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingnumbergenaration.basic;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingnumbergenaration.integration.BookingNumberGenarationDBDAO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgReferenceNoGenerationVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * -Bookingcommon Business Logic Command Interface<br>
 * - Bookingcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Kim Ki Jong
 * @see BookingNumberGenarationBC 참조
 * @since J2EE 1.5
 */
public class BookingNumberGenarationBCImpl extends BasicCommandSupport implements BookingNumberGenarationBC {

	// Database Access Object
	private transient BookingNumberGenarationDBDAO dbDao = null;

	/**
	 * BookingNumberGenarationBCImpl 객체 생성<br>
	 * BookingNumberGenarationDBDAO를 생성한다.<br>
	 */
	public BookingNumberGenarationBCImpl() {
		dbDao = new BookingNumberGenarationDBDAO();
	}
	
	/**
	 * Bkg No,Bl no 등 생성.<br>
	 * @param String divCd 
	 * @param String officeCd 
	 * @param String usrId 
	 * @return BkgBlNoVO
	 * @throws Exception
	 * @throws DAOException
	 */
		
	public BkgBlNoVO manageBkgNumberGeneration(String divCd,String officeCd,String usrId )throws EventException {
		try {
			return dbDao.manageBkgNumberGeneration(divCd,officeCd,usrId);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * RPT ,JPD,D/O,CAD,UIT,C/A,KOR NO 등  ReferenceNumber 생성.<br>
	 * @param String divCd 
	 * @param String officeCd 
	 * @param String usrId 
	 * @return BkgReferenceNoGenerationVO
	 * @throws Exception
	 * @throws DAOException
	 */
		
	public BkgReferenceNoGenerationVO manageBkgReferenceNumberGeneration(String divCd,String officeCd,String usrId )throws EventException {
		try {
			return dbDao.manageBkgReferenceNumberGeneration(divCd,officeCd,usrId);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 
	 * @param divCd
	 * @param officeCd
	 * @param usrId
	 * @return
	 * @throws EventException
	 */
	public BkgBlNoVO manageToyotaBlNumberGeneration(String divCd,String officeCd,String usrId )throws EventException {
		try {
			return dbDao.manageToyotaBlNumberGeneration(divCd,officeCd,usrId);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
	
	/**
	 * 
	 * @param bkgBlNoVO
	 * @return
	 * @throws EventException
	 */
	public String validationToyotaBlNo(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.validationToyotaBlNo(bkgBlNoVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
	}
}	
	