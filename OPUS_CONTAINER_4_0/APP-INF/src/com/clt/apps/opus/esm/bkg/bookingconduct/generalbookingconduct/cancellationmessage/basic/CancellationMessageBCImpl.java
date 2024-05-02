/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingListSearchBCImpl.java
*@FileTitle : Compulsory Firm
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.05.26 김병규
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.cancellationmessage.basic;

import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.cancellationmessage.integration.CancellationMessageDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * 
 * @author c9014850
 * @see CancellationMessageBCImpl 참조
 * @since J2EE 1.6
 */
public class CancellationMessageBCImpl extends BasicCommandSupport implements CancellationMessageBC {

	// Database Access Object
	private transient CancellationMessageDBDAO dbDao = null;

	/**
	 * Generating CancellationMessageBCImpl Object<br>
	 * Generating CancellationMessageDBDAO<br>
	 */
	public CancellationMessageBCImpl() {
		dbDao = new CancellationMessageDBDAO();
	}

	/**
	 * 
	 * @param bkgNo
	 * @param type
	 * @return
	 * @throws EventException
	 */
	public int sned301UEdiCheck(String bkgNo, String type) throws EventException {
		try {
			return dbDao.sned301UEdiCheck(bkgNo, type);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);       
		}
	}

}