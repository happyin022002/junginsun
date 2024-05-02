/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ImmediateExitBCImpl.java
*@FileTitle : Immediate Exit Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.10 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.immediateexit.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.lse.containerleasemgt.immediateexit.integration.ImmediateExitDBDAO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.immediateexit.vo.ImmediateExitCreationVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.immediateexit.vo.SearchParamVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;


/**
 * ALPS-ContainerLeaseMgt Business Logic Basic Command implementation<br>
 * - ALPS-ContainerLeaseMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jang Jun-Woo
 * @see EES_LSE_0025EventResponse,ImmediateExitBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ImmediateExitBCImpl extends BasicCommandSupport implements ImmediateExitBC {

	// Database Access Object
	private transient ImmediateExitDBDAO dbDao = null;

	/**
	 * ImmediateExitBCImpl 객체 생성<br>
	 * ImmediateExitDBDAO를 생성한다.<br>
	 */
	public ImmediateExitBCImpl() {
		dbDao = new ImmediateExitDBDAO();
	}

	/**
	 * Immediate Exit Creation 대상 장비목록을 조회합니다.<br>
	 *
	 * @param SearchParamVO searchParamVO
	 * @return List<ImmediateExitCreationVO>
	 * @exception EventException
	 */
	public List<ImmediateExitCreationVO> searchImmediateExitCreationListBasic(SearchParamVO searchParamVO) throws EventException {
		List<ImmediateExitCreationVO> resultVOs = null;

		try {
			resultVOs = dbDao.searchImmediateExitCreationListData(searchParamVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ImmediateExitCreationList Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ImmediateExitCreationList Search"}).getMessage(),ex);
		}

		return resultVOs;
	}
}