/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeaseTermBCImpl.java
*@FileTitle : Lease Term Search
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.leaseterm.basic;

import java.util.List;

import com.clt.apps.opus.ees.lse.lsecommon.leaseterm.integration.LeaseTermDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.MstLseTermVO;

/**
 * LeaseTerm Business Logic Basic Command implementation<br>
 *
 * @author
 * @see LeaseTermBC 
 * @since J2EE 1.4
 */

public class LeaseTermBCImpl extends BasicCommandSupport implements LeaseTermBC {

	// Database Access Object
	private transient LeaseTermDBDAO dbDao = null;

	/**
	 * creating LeaseTermBCImpl object<br>
	 * creating LeaseTermDBDAO<br>
	 */
	public LeaseTermBCImpl() {
		dbDao = new LeaseTermDBDAO();
	}

	/**
	 * retrieving for Lease Term<br>
	 *
	 * @return List<MstLseTermVO>
	 * @exception EventException
	 */
	public List<MstLseTermVO> searchLeaseTermComboItemBasic() throws EventException {
		try {

			return dbDao.searchLeaseTermComboItemData();
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
	}
}