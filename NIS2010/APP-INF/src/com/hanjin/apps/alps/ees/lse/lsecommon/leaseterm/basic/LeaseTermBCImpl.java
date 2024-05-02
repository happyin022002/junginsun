/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeaseTermBCImpl.java
*@FileTitle : Lease Term Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.leaseterm.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.lsecommon.leaseterm.integration.LeaseTermDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.MstLseTermVO;

/**
 * NIS2010-LeaseTerm Business Logic Basic Command implementation<br>
 * - NIS2010-LeaseTerm 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Nho Jung Yong
 * @see LeaseTermBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class LeaseTermBCImpl extends BasicCommandSupport implements LeaseTermBC {

	// Database Access Object
	private transient LeaseTermDBDAO dbDao = null;

	/**
	 * LeaseTermBCImpl 객체 생성<br>
	 * LeaseTermDBDAO를 생성한다.<br>
	 */
	public LeaseTermBCImpl() {
		dbDao = new LeaseTermDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 *  Lease Term에 대한 조회 이벤트 처리<br>
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