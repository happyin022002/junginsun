/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DlvrLocBCImpl.java
*@FileTitle : Container Type/Size Search
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.lse.lsecommon.dlvrloc.basic;

import java.util.List;

import com.clt.apps.opus.ees.lse.lsecommon.dlvrloc.integration.DeliveryLocationDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.MdmEqOrzChtVO;
import com.clt.syscommon.common.table.MdmLocationVO;
import com.clt.syscommon.common.table.MdmYardVO;

/**
 * DlvrLoc Business Logic Basic Command implementation<br>
 * - Handling a business transaction about DlvrLoc<br>
 *
 * @author 
 * @see DeliveryLocationBC - refer to each DAO class
 * @since J2EE 1.4
 */

public class DeliveryLocationBCImpl extends BasicCommandSupport implements DeliveryLocationBC {

	// Database Access Object
	private transient DeliveryLocationDBDAO dbDao = null;

	/**
	 * Creating DlvrLocBCImpl object<br>
	 * Creating DlvrLocDBDAO<br>
	 */
	public DeliveryLocationBCImpl() {
		dbDao = new DeliveryLocationDBDAO();
	}

	/**
	 * Retrieving code list for Delivery Location<br>
	 *
	 * @param String locCd
	 * @return List<MdmLocationVO>
	 * @exception EventException
	 */
	public List<MdmLocationVO> searchDeliveryLocationBrieflyBasic(String locCd) throws EventException {
		List<MdmLocationVO> list = null;

		try {
			list = dbDao.searchDeliveryLocationBrieflyData(locCd);

			if ( list.size() < 1 ) {
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Retrieving code list for kind of type Delivery Location<br>
	 *
	 * @param String locCd
	 * @param String locTp
	 * @return List<MdmEqOrzChtVO>
	 * @exception EventException
	 */
	public List<MdmEqOrzChtVO> searchLocationBrieflyBasic(String locCd, String locTp) throws EventException {
		List<MdmEqOrzChtVO> list = null;

		try {
			list = dbDao.searchLocationBrieflyData(locCd, locTp);

			if ( list.size() < 1 ) {
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return list;
	}
	
	
	
	/**
	 * Retrieving code list for kind of type Delivery Location<br>
	 *
	 * @param String locCd
	 * @param String eqLocTpCd
	 * @param String sheetIdx
	 * @return List<MdmEqOrzChtVO>
	 * @exception EventException
	 */
	public List<MdmEqOrzChtVO> searchLocationBasic(String locCd, String eqLocTpCd, String sheetIdx) throws EventException {
		List<MdmEqOrzChtVO> list = null;

		try {
			list = dbDao.searchLocationData(locCd, eqLocTpCd, sheetIdx);

			if ( list.size() < 1 ) {
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Retrieving code list for Delivery Location - RCC<br>
	 *
	 * @return List<MdmEqOrzChtVO>
	 * @exception EventException
	 */
	public List<MdmEqOrzChtVO> searchDeliveryLocationRCCListBasic() throws EventException {
		List<MdmEqOrzChtVO> list = null;

		try {
			list = dbDao.searchDeliveryLocationRCCListData();

			if ( list.size() < 1 ) {
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Retrieving code list for Delivery Location - Country<br>
	 *
	 * @param String locCd
	 * @return List<MdmLocationVO>
	 * @exception EventException
	 */
	public List<MdmLocationVO> searchDeliveryLocationCountryBasic(String locCd) throws EventException {
		List<MdmLocationVO>  list = null;

		try {
			list = dbDao.searchDeliveryLocationCountryData(locCd);

			if ( list.size() < 1 ) {
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Retrieving code list for Delivery Location - Off-Hire Yard<br>
	 *
	 * @param String ydCd
	 * @return List<MdmYardVO>
	 * @exception EventException
	 */
	public List<MdmYardVO> searchOffHireYardListBasic(String ydCd) throws EventException {
		List<MdmYardVO>  list = null;

		try {
			list = dbDao.searchOffHireYardListData(ydCd);

			if ( list.size() < 1 ) {
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return list;
	}
}