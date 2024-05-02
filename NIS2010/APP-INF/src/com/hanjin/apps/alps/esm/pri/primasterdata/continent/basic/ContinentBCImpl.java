/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContinentBCImpl.java
*@FileTitle : Continent-Subcontinent Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.14
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.08.14 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.continent.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.primasterdata.continent.integration.ContinentDBDAO;
import com.hanjin.apps.alps.esm.pri.primasterdata.continent.vo.ContinentVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.MdmContinentVO;
import com.hanjin.syscommon.common.table.MdmSubcontinentVO;

/**
 * ALPS-PRIMasterData Business Logic Basic Command implementation<br>
 * - ALPS-PRIMasterData에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author JaeYeon Kim
 * @see ESM_PRI_4021EventResponse,ContinentBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ContinentBCImpl extends BasicCommandSupport implements ContinentBC {

	// Database Access Object
	private transient ContinentDBDAO dbDao = null;

	/**
	 * ContinentBCImpl 객체 생성<br>
	 * ContinentDBDAO를 생성한다.<br>
	 */
	public ContinentBCImpl() {
		dbDao = new ContinentDBDAO();
	}
	/**
	 * Continent List를 조회합니다. <br>
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
	 * Sub Continent List를 조회합니다. <br>
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