/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingInterfaceMgtBCImpl.java
*@FileTitle : 11111
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.10.22 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinginterfacemgt.basic;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinginterfacemgt.integration.BookingInterfaceMgtDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinginterfacemgt.vo.SearchBkgInfoForINVVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * NIS2010-Bookingcommon Business Logic Command Interface<br>
 * - NIS2010-Bookingcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Kim Youngchul
 * @see BookingInterfaceMgtBC 참조
 * @since J2EE 1.4
 */
public class BookingInterfaceMgtBCImpl extends BasicCommandSupport implements BookingInterfaceMgtBC {

	// Database Access Object
	private transient BookingInterfaceMgtDBDAO dbDao = null;

	/**
	 * BookingInterfaceMgtBCImpl 객체 생성<br>
	 * BookingInterfaceMgtDBDAO를 생성한다.<br>
	 */
	public BookingInterfaceMgtBCImpl() {
		dbDao = new BookingInterfaceMgtDBDAO();
	}
	/**
	 * BKG에서 INV로 INTERFACE할 정보를 조회한다.<br>
	 * 
	 * @param String bkgNo
	 * @return SearchBkgInfoForINVVO
	 * @exception EventException
	 */
	public SearchBkgInfoForINVVO searchBkgInfoForINVVO(String bkgNo) throws EventException {
		try {
			return dbDao.searchBkgInfoForINVVO(bkgNo);
		} catch(DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
		
	}
	
}