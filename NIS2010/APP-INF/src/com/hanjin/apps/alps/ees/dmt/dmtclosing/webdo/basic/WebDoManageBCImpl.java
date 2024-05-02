/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : WebDoManageBCImpl.java
*@FileTitle : DMT_CHG_CALC Table을 업데이트한다.
*Open Issues :
*Change history :
*@LastModifyDate : 2011-10-20
*@LastModifier : Kwon Min
*@LastVersion : 1.0
* 2011-10-07 Kwon Min
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo.integration.WebDoManageDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.webdo.vo.IfSchemaVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-ReplanManage Business Logic Command Interface<br>
 * - ALPS-ReplanManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author	Kwon Min
 * @see		BasicCommandSupport , WebDoManageBC
 * @since	J2EE 1.6
 */
public class WebDoManageBCImpl extends BasicCommandSupport implements WebDoManageBC {

	// Database Access Object
	private transient WebDoManageDBDAO dbDao = null;

	/**
	 * WebDoManageDBDAO를 생성한다.<br>
	 */
	public WebDoManageBCImpl() {
		dbDao = new WebDoManageDBDAO();
	}

	/**
	 * @param ifSchemaVO
	 * @return int
	 * @throws EventException
	 */
	public int multiUsDo (IfSchemaVO ifSchemaVO) throws EventException {
		int cnt = 0;
		
		try {
			cnt = dbDao.multiUsDo(ifSchemaVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	
	/**
	 * @param ifSchemaVO
	 * @return ifSchemaVO
	 * @throws EventException
	 */
	public List<IfSchemaVO> searchPrecalOverday (IfSchemaVO ifSchemaVO) throws EventException {
		List<IfSchemaVO> list	= null;
		
		try {
			list = dbDao.searchPrecalOverday(ifSchemaVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}