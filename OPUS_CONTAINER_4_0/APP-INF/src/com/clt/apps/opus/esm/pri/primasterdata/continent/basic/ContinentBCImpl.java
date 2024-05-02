/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContinentBCImpl.java
*@FileTitle : Continent-Subcontinent Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.continent.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.primasterdata.continent.integration.ContinentDBDAO;
import com.clt.apps.opus.esm.pri.primasterdata.continent.vo.ContinentVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.MdmContinentVO;
import com.clt.syscommon.common.table.MdmSubcontinentVO;

/**
 * PRIMasterData Business Logic Basic Command implementation<br>
 * - handling biz logic about PRIMasterData<br>
 *
 * @author 
 * @see ESM_PRI_4021EventResponse,ContinentBC reference each DAO class 
 * @since J2EE 1.6
 */
public class ContinentBCImpl extends BasicCommandSupport implements ContinentBC {

	// Database Access Object
	private transient ContinentDBDAO dbDao = null;

	/**
	 * ContinentBCImpl object creation<br>
	 * creating ContinentDBDAO<br>
	 */
	public ContinentBCImpl() {
		dbDao = new ContinentDBDAO();
	}
	/**
	 * Retrieving Continent List<br>
	 * 
	 * @param ContinentVO continentVO
	 * @return List<MdmContinentVO>
	 * @exception EventException
	 */
	public List<MdmContinentVO> searchContinentList(ContinentVO continentVO) throws EventException {
		try {
			return dbDao.searchContinentList(continentVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * Retrieving Sub Continent List<br>
	 * 
	 * @param ContinentVO continentVO
	 * @return List<MdmSubcontinentVO>
	 * @exception EventException
	 */
	public List<MdmSubcontinentVO> searchSubcontinentList(ContinentVO continentVO) throws EventException {
		try {
			return dbDao.searchSubcontinentList(continentVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
	}
	
}