/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : TesBkgAudBCImpl.java
*@FileTitle : Rehandling(BKG COD)
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.12
*@LastModifier : 김현주
*@LastVersion : 1.0
* 2015.03.12 김현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.expnaud.tesbkgaud.basic;



import java.util.List;

import com.hanjin.apps.alps.esd.eas.expnaud.tesbkgaud.integration.TesBkgAudDBDAO;
import com.hanjin.apps.alps.esd.eas.expnaud.tesbkgaud.vo.RehandlingBkgCodVO;
import com.hanjin.apps.alps.esd.eas.expnaud.testoraud.basic.TesTorAudBC;
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

public class TesBkgAudBCImpl extends BasicCommandSupport implements TesBkgAudBC {
	
	// Database Access Object
	private transient TesBkgAudDBDAO dbDao = null;

	/**
	 * TesTorAudBCImpl 객체 생성<br>
	 * EacMgtDBDAO를 생성한다.<br>
	 */
	public TesBkgAudBCImpl() {
		dbDao = new TesBkgAudDBDAO();
	}
	
	 /**
	  * Rehandling(BKG COD) 조회한다.<br>
	  * 
	  * @param RehandlingBkgCodVO rehandlingBkgCodVO
	  * @return List<RehandlingBkgCodVO>
	  * @exception EventException
	  */
	 @SuppressWarnings("unchecked")
	 public List<RehandlingBkgCodVO> searchCodCostList(RehandlingBkgCodVO rehandlingBkgCodVO) throws EventException{ 
			try {
				return dbDao.searchCodCostList(rehandlingBkgCodVO);
			} catch(DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}
	 }
}
