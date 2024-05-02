/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoResultManageBCImpl.java
*@FileTitle : CntrRepoResultManageBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntranalysis.cntrreporesult.basic;

import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.cntranalysis.cntrreporesult.vo.EmptyRepoResultOptionVO;
import com.clt.apps.opus.ees.eqr.cntranalysis.cntrreporesult.integration.CntrRepoResultManageDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-CntrRepoResultManage Business Logic Command Interface<br>
 * - OPUS-CntrRepoResultManage <br>
 *
 * @author 
 * @see EvetnException 
 * @since J2EE 1.6
 */
public class CntrRepoResultManageBCImpl extends BasicCommandSupport implements CntrRepoResultManageBC {

	// Database Access Object
	private transient CntrRepoResultManageDBDAO dbDao = null;

	/**
	 * CntrRepoResultManageBCImpl <br>
	 * CntrRepoResultManageDBDAO <br>
	 */
	public CntrRepoResultManageBCImpl() {
		dbDao = new CntrRepoResultManageDBDAO();
	}
	/**
	 * [ EES_EQR_0144 : Empty Repo Result ]<br>
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