/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DlvrLocBCImpl.java
*@FileTitle : Container Type/Size Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.dlvrloc.basic;

import java.util.List;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.MdmEqOrzChtVO;
import com.hanjin.syscommon.common.table.MdmLocationVO;
import com.hanjin.syscommon.common.table.MdmYardVO;
import com.hanjin.apps.alps.ees.lse.lsecommon.dlvrloc.integration.DeliveryLocationDBDAO;

/**
 * ALPS-DlvrLoc Business Logic Basic Command implementation<br>
 * - ALPS-DlvrLoc에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Nho Jung Yong
 * @see DeliveryLocationBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class DeliveryLocationBCImpl extends BasicCommandSupport implements DeliveryLocationBC {

	// Database Access Object
	private transient DeliveryLocationDBDAO dbDao = null;

	/**
	 * DlvrLocBCImpl 객체 생성<br>
	 * DlvrLocDBDAO를 생성한다.<br>
	 */
	public DeliveryLocationBCImpl() {
		dbDao = new DeliveryLocationDBDAO();
	}

	/**
	 * Delivery Location 코드목록을 조회합니다.<br>
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
	 * 유형별 Delivery Location 코드목록을 조회합니다.<br>
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
	 * Delivery Location - RCC 코드목록을 조회합니다.<br>
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
	 * Delivery Location - Country 코드목록을 조회합니다.<br>
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
	 * Delivery Location - Off-Hire Yard 코드목록을 조회합니다.<br>
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