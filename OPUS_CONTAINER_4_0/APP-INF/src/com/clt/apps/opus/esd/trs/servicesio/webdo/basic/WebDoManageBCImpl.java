/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : WebDoManageBCImpl.java
 *@FileTitle : USA Delivery Order class 를 구동한다.
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011-10-07
 *@LastModifier : Choi jonghyek
 *@LastVersion : 1.0
 * 2011-10-07 Choi jonghyek
 * 1.0 Creation
 * 2011.12.09 김종호 [CHM-201113793] [TRS] HJS Homepage Renewal - ALPS 외부 I/F 개발(Webservice)
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.webdo.basic;

import com.clt.apps.opus.esd.trs.servicesio.webdo.integration.WebDoManageDBDAO;
import com.clt.apps.opus.esd.trs.servicesio.webdo.vo.IfSchemaVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-ReplanManage Business Logic Command Interface<br>
 * - ALPS-ReplanManage에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author Choi jonghyek
 * @see BasicCommandSupport , WebDoManageBC
 * @since J2EE 1.6
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
	public int multiUsDo(IfSchemaVO ifSchemaVO) throws EventException {
		int cnt = 0;

		try {
			cnt = dbDao.multiUsDo(ifSchemaVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
}