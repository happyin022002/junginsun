/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ImmediateExitBCImpl.java
*@FileTitle : Immediate Exit Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.immediateexit.basic;

import java.util.List;

import com.clt.apps.opus.ees.lse.containerleasemgt.immediateexit.integration.ImmediateExitDBDAO;
import com.clt.apps.opus.ees.lse.containerleasemgt.immediateexit.vo.ImmediateExitCreationVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.immediateexit.vo.SearchParamVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;


/**
 * ContainerLeaseMgt Business Logic Basic Command implementation<br>
 * - Handling a business transaction about ContainerLeaseMgt<br>
 *
 * @author 
 * @see EES_LSE_0025EventResponse,ImmediateExitBC - refer to each DAO class
 * @since J2EE 1.6
 */
public class ImmediateExitBCImpl extends BasicCommandSupport implements ImmediateExitBC {

	// Database Access Object
	private transient ImmediateExitDBDAO dbDao = null;

	/**
	 * Creating ImmediateExitBCImpl object<br>
	 * Creating ImmediateExitDBDAO<br>
	 */
	public ImmediateExitBCImpl() {
		dbDao = new ImmediateExitDBDAO();
	}

	/**
	 * Retrieving equipment list for Immediate Exit Creation<br>
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