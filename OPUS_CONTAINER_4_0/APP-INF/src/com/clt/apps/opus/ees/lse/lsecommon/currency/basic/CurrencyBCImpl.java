/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrTpSzBCImpl.java
*@FileTitle : Currency Code Search
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.currency.basic;

import java.util.List;

import com.clt.apps.opus.ees.lse.lsecommon.currency.integration.CurrencyDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.MdmCurrencyVO;

/**
 * Currency Business Logic Basic Command implementation<br>
 * - Handling a business transaction about Currency<br>
 *
 * @author
 * @see CurrencyBC - refer to each DAO class
 * @since J2EE 1.4
 */

public class CurrencyBCImpl extends BasicCommandSupport implements CurrencyBC {

	// Database Access Object
	private transient CurrencyDBDAO dbDao = null;

	/**
	 * Creating CurrencyBCImpl object<br>
	 * Creating CurrencyDBDAO<br> 
	 */
	public CurrencyBCImpl() {
		dbDao = new CurrencyDBDAO();
	}

	/**
	 * Retrieving code list for Currency<br>
	 * 
	 * @param String currCd
	 * @return List<MdmCurrencyVO>
	 * @exception EventException
	 */
	public List<MdmCurrencyVO> searchCurrencyListBasic(String currCd) throws EventException {
		List<MdmCurrencyVO> list = null;
		try {
			
			list = dbDao.searchCurrencyListData(currCd);
			
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