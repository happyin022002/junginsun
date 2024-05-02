/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EASCommonBCImpl.java
*@FileTitle : EAS_Common
*Open Issues :
*Change history :
*@LastModifyDate : 2015-05-13
*@LastModifier : Jong-Ock Kim
*@LastVersion : 1.0
* 2015-05-13 Jong-Ock Kim
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eascommon.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.eas.eascommon.integration.EASCommonDBDAO;
import com.hanjin.apps.alps.esd.eas.eascommon.vo.EasCommonVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.MdmVendorVO;
import com.hanjin.syscommon.common.table.MdmYardVO;

/**
 * ALPS-EASCommon Business Logic Command Interface<br>
 * - ALPS-EASCommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jong-Ock Kim
 * @see Esd_Eas_CommonEvent,EASCommonBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class EASCommonBCImpl extends BasicCommandSupport implements EASCommonBC {

	// Database Access Object 
	private transient EASCommonDBDAO dbDao = null;

	/**
	 * EASCommonBCImpl 객체 생성<br>
	 * EASCommonDBDAO를 생성한다.<br>
	 */
	public EASCommonBCImpl() {
		dbDao = new EASCommonDBDAO();
	}

	/**
	 * 공통 : Yard에 Loc_cd 해당하는 Nod_code 조회<br>
	 *
	 * @param EasCommonVO easCommonVO
	 * @return List<EasCommonVO>
	 * @exception EventException
	 */
	public List<EasCommonVO> getYardLocCdNodCdList(EasCommonVO easCommonVO) throws EventException {
		try {
			return dbDao.getYardLocCdNodCdList(easCommonVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : Yard에 기항하는 Lane 조회<br>
	 *
	 * @param EasCommonVO easCommonVO
	 * @return List<EasCommonVO>
	 * @exception EventException
	 */
	public List<EasCommonVO> getYardByLaneList(EasCommonVO easCommonVO) throws EventException {
		try {
			return dbDao.getYardByLaneList(easCommonVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 공통 : Vessel Class에 기항하는 Vessel 조회<br>
	 *
	 * @param EasCommonVO easCommonVO
	 * @return List<EasCommonVO>
	 * @exception EventException
	 */
	public List<EasCommonVO> getVesselClassByVesselList(EasCommonVO easCommonVO) throws EventException {
		try {
			return dbDao.getVesselClassByVesselList(easCommonVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 공통 : Yard 정보 조회<br>
	 *
	 * @param EasCommonVO easCommonVO
	 * @return List<MdmYardVO>
	 * @exception EventException
	 */
	public List<MdmYardVO> getYardNameList(MdmYardVO mdmYardVO) throws EventException {
		try {
			return dbDao.getYardNameList(mdmYardVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 공통 : VENDOR 정보 조회<br>
	 *
	 * @param MdmVendorVO mdmVendorV
	 * @return List<MdmVendorVO>
	 * @exception EventException
	 */
	public List<MdmVendorVO> getVendorNameList(MdmVendorVO mdmVendorVO) throws EventException {
		try {
			return dbDao.getVendorNameList(mdmVendorVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
}