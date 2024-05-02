/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomerBCImpl.java
*@FileTitle : Customer Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.customer.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.primasterdata.customer.integration.CustomerDBDAO;
import com.clt.apps.opus.esm.pri.primasterdata.customer.vo.MdmCustVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * PRIMasterData Business Logic Basic Command implementation<br>
 * - Handling a biz logic about PRIMasterData<br>
 *
 * @author 
 * @see ESM_PRI_4014EventResponse,CustomerBC refer to each DAO class
 * @since J2EE 1.4
 */

public class CustomerBCImpl extends BasicCommandSupport implements CustomerBC {

	// Database Access Object
	private transient CustomerDBDAO dbDao = null;

	/**
	 * Creating  CustomerBCImpl Object <br>
	 * Creating CustomerDBDAO.<br>
	 */
	public CustomerBCImpl() {
		dbDao = new CustomerDBDAO();
	}
	/**
	 *  Retrieving Customer List<br>
	 * 
	 * @param MdmCustVO mdmCustVO
	 * @return List<MdmCustVO>
	 * @exception EventException
	 */
	public List<MdmCustVO> searchCustomerList(MdmCustVO mdmCustVO) throws EventException {
		try {
			return dbDao.searchCustomerList(mdmCustVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
}