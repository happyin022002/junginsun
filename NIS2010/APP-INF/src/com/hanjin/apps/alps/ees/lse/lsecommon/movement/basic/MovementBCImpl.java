/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MovementBCImpl.java
*@FileTitle : Container Movement Status Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.08.10 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.movement.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.lsecommon.movement.intergration.MovementDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.MdmMvmtStsVO;


/**
 * ALPS-Movement Business Logic Basic Command implementation<br>
 * - ALPS-Movement 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jang Jun-Woo
 * @see MovementBCImpl 각 DAO 클래스 참조
 * @since J2EE 1.6
 */

public class MovementBCImpl extends BasicCommandSupport implements MovementBC {

	// Database Access Object
	private transient MovementDBDAO dbDao = null;

	/**
	 * MovementBCImpl 객체 생성<br>
	 * MovementDBDAO를 생성한다.<br>
	 */
	public MovementBCImpl() {
		dbDao = new MovementDBDAO();
	}

	/**
	 * Container Movement Status 코드목록을 조회합니다.<br>
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