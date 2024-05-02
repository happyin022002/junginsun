/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MovementBCImpl.java
*@FileTitle : Container Movement Status Search
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.movement.basic;

import java.util.List;

import com.clt.apps.opus.ees.lse.lsecommon.movement.intergration.MovementDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.MdmMvmtStsVO;


/**
 * Movement Business Logic Basic Command implementation<br>
 * - Handling a business transaction about Movement<br>
 *
 * @author
 * @see MovementBCImpl - refer to each DAO class
 * @since J2EE 1.6
 */

public class MovementBCImpl extends BasicCommandSupport implements MovementBC {

	// Database Access Object
	private transient MovementDBDAO dbDao = null;

	/**
	 * Creating MovementBCImpl object<br>
	 * Creating MovementDBDAO<br>  
	 */
	public MovementBCImpl() {
		dbDao = new MovementDBDAO();
	}

	/**
	 * Retrieving code list for Container Movement Status<br>
	 *  
	 * @return List<MdmMvmtSts>
	 * @exception EventException
	 */
	public List<MdmMvmtStsVO> searchContainerMovementStatusListBasic() throws EventException {
		List<MdmMvmtStsVO> list = null;
		try {
			list = dbDao.searchContainerMovementStatusListData();

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