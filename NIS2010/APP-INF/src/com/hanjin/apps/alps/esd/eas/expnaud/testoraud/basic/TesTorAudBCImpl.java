/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TesTorAudBCImpl.java
*@FileTitle : Expense Audit case Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.testoraud.basic;



import java.util.List;

import com.hanjin.apps.alps.esd.eas.expnaud.testoraud.integration.TesTorAudDBDAO;
import com.hanjin.apps.alps.esd.eas.expnaud.testoraud.vo.RehandlingExpenseTorVsTpbVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * ALPS-Eac Business Logic Command Interface<br>
 * - ALPS-Eac에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author BAEK HYOUNG IN
 * @see  EventResponse,EacMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */

public class TesTorAudBCImpl extends BasicCommandSupport implements TesTorAudBC {

	// Database Access Object
	private transient TesTorAudDBDAO dbDao = null;

	/**
	 * TesTorAudBCImpl 객체 생성<br>
	 * EacMgtDBDAO를 생성한다.<br>
	 */
	public TesTorAudBCImpl() {
		dbDao = new TesTorAudDBDAO();
	}

	 /**
	  * Rehandling Expense - TOR vs. TPB 조회한다.<br>
	  * 
	  * @param RehandlingExpenseTorVsTpbVO rehandlingExpenseTorVsTpbVO
	  * @return List<RehandlingExpenseTorVsTpbVO>
	  * @exception EventException
	  */
	 @SuppressWarnings("unchecked")
	 public List<RehandlingExpenseTorVsTpbVO> searchRhndList(RehandlingExpenseTorVsTpbVO rehandlingExpenseTorVsTpbVO) throws EventException	{
		try {
			return dbDao.searchRhndList(rehandlingExpenseTorVsTpbVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
			
	}

}