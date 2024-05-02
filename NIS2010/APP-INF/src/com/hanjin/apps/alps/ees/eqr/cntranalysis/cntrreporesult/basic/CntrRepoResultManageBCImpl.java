/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoResultManageBCImpl.java
*@FileTitle : CntrRepoResultManageBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.29
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2010.11.29 
* 1.0 Creation
* 2010.12.03 양봉준 [CHM-201007345-01] EES_EQR_0144 화면 신규 개발
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntranalysis.cntrreporesult.basic;

import com.hanjin.apps.alps.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.cntranalysis.cntrreporesult.vo.EmptyRepoResultOptionVO;
import com.hanjin.apps.alps.ees.eqr.cntranalysis.cntrreporesult.integration.CntrRepoResultManageDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-CntrRepoResultManage Business Logic Command Interface<br>
 * - ALPS-CntrRepoResultManage 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Bong-jun,Yang
 * @see EvetnException 참조
 * @since J2EE 1.6
 */
public class CntrRepoResultManageBCImpl extends BasicCommandSupport implements CntrRepoResultManageBC {

	// Database Access Object
	private transient CntrRepoResultManageDBDAO dbDao = null;

	/**
	 * CntrRepoResultManageBCImpl 객체 생성<br>
	 * CntrRepoResultManageDBDAO 생성한다.<br>
	 */
	public CntrRepoResultManageBCImpl() {
		dbDao = new CntrRepoResultManageDBDAO();
	}
	/**
	 * [ EES_EQR_0144 : Empty Repo Result ]<br>
	 * 
	 * @param EmptyRepoResultOptionVO emptyRepoResultOptionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchEmptyRepoResult(EmptyRepoResultOptionVO emptyRepoResultOptionVO) throws EventException {
		try {
			return dbDao.searchEmptyRepoResult(emptyRepoResultOptionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
}