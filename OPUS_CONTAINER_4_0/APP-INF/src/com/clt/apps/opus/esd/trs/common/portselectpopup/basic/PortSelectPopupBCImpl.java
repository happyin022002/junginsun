/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortSelectPopupBCImpl.java
*@FileTitle : PortSelectPopupBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.common.portselectpopup.basic;

import java.util.List;

import com.clt.apps.opus.esd.trs.common.portselectpopup.integration.PortSelectPopupDBDAO;
import com.clt.apps.opus.esd.trs.common.portselectpopup.vo.PortVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.MdmCountryVO;

/**
 * Common Business Logic Basic Command implementation<br>
 * - Handling business logic of Common<br>
 *
 * @author 
 * @see PortSelectPopupBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class PortSelectPopupBCImpl extends BasicCommandSupport implements PortSelectPopupBC {

	// Database Access Object
	private transient PortSelectPopupDBDAO dbDao = null;

	/**
	 * VSKCodeFinderBCImpl object creation<br>
	 * Creating VSKCodeFinderDBDAO<br>
	 */
	public PortSelectPopupBCImpl() {
		dbDao = new PortSelectPopupDBDAO();
	}

	/**
	 * Retrieving Port
	 * 
	 * @param PortVO portVO
	 * @return List<PortVO>
	 * @exception EventException
	 */
	public List<PortVO> searchPortList(PortVO portVO) throws EventException {
		try {
			return dbDao.searchPortList(portVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
	/**
	 * Retrieving Country
	 * 
	 * @param String cntCd
	 * @return List<MdmCountryVO>
	 * @exception EventException
	 */
	public List<MdmCountryVO> searchCountryList(String cntCd) throws EventException {
		try {
			return dbDao.searchCountryList(cntCd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("VSK10035").getMessage(), ex);
		}
	}
}