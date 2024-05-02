/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CurrencyBCImpl.java
*@FileTitle : Currency Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.currency.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.primasterdata.currency.integration.CurrencyDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.MdmCurrencyVO;

/**
 * PRIMasterData Business Logic Command Interface<br>
 * - handling biz logic about PRIMasterData<br>
 *
 * @author 
 * @see Esm_pri_4020EventResponse 
 * @since J2EE 1.6
 */
public class CurrencyBCImpl extends BasicCommandSupport implements CurrencyBC {

	// Database Access Object
	private transient CurrencyDBDAO dbDao = null;

	/**
	 * CurrencyBCImpl  object creation<br>
	 * creating CurrencyDBDAO<br>
	 */
	public CurrencyBCImpl() {
		dbDao = new CurrencyDBDAO();
	}
	/**
	 * Retrieving Currency Inquiry<br>
	 * 
	 * @param MdmCurrencyVO mdmCurrencyVO
	 * @return List<MdmCurrencyVO>
	 * @exception EventException
	 */
	public List<MdmCurrencyVO> searchCurrencyList(MdmCurrencyVO mdmCurrencyVO) throws EventException {
		try {
			return dbDao.searchCurrencyList(mdmCurrencyVO);
		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
		
	}
	
}