/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LocationBCImpl.java
*@FileTitle : Location Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.04.28 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.location.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.integration.LocationDBDAO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltCntListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltGrpLocDtlListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltGrpLocListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltLocListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltRgnListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.location.vo.RsltSteListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * NIS2010-PRIMasterData Business Logic Basic Command implementation<br>
 * - NIS2010-PRIMasterData에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author CHOI SUNG MIN
 * @see ESM_PRI_4026EventResponse,LocationBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class LocationBCImpl extends BasicCommandSupport implements LocationBC {

	// Database Access Object
	private transient LocationDBDAO dbDao = null;

	/**
	 * LocationBCImpl 객체 생성<br>
	 * LocationDBDAO를 생성한다.<br>
	 */
	public LocationBCImpl() {
		dbDao = new LocationDBDAO();
	}
	/**
	 * COUNTRY CODE를 조회한다.<br>
	 * 
	 * @param RsltCntListVO rsltCntListVO  
	 * @return List<RsltCntListVO>
	 * @exception EventException
	 */
	public List<RsltCntListVO> searchCountryList(RsltCntListVO rsltCntListVO) throws EventException {
		try {
			return dbDao.searchCountryList(rsltCntListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	/**
	 * LOCATION CODE를 조회한다.<br>
	 * 
	 * @param RsltLocListVO rsltLocListVO  
	 * @return List<RsltLocListVO>
	 * @exception EventException
	 */
	public List<RsltLocListVO> searchLocationList(RsltLocListVO rsltLocListVO) throws EventException {
		try {			
			return dbDao.searchLocationList(rsltLocListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * STATE CODE를 조회한다.<br>
	 * 
	 * @param RsltSteListVO rsltSteListVO  
	 * @return List<RsltSteListVO>
	 * @exception EventException
	 */
	public List<RsltSteListVO> searchStateList(RsltSteListVO rsltSteListVO) throws EventException {
		try {
			return dbDao.searchStateList(rsltSteListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	/**
	 * SERVICE SCOPE GROUP LOCATION CODE를 조회한다.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO  
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchSpScpGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws EventException {
		try {
			return dbDao.searchSpScpGroupLocationList(rsltGrpLocListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	/**
	 * RFA GUIDELINE GROUP LOCATION CODE를 조회한다.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchRgGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws EventException {
		try {
			return dbDao.searchRgGroupLocationList(rsltGrpLocListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	/**
	 * S/C GUIDELINE GROUP LOCATION CODE를 조회한다.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchSgGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws EventException {
		try {
			return dbDao.searchSgGroupLocationList(rsltGrpLocListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	/**
	 * RFA PROPOSAL GROUP LOCATION CODE를 조회한다.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchRpScpGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws EventException {
		try {
			return dbDao.searchRpScpGroupLocationList(rsltGrpLocListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * SURCHARGE GROUP LOCATION CODE를 조회한다.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchScgGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws EventException {
		try {
			return dbDao.searchScgGroupLocationList(rsltGrpLocListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * CMPB GROUP LOCATION CODE 정보를 조회한다.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchCMPBGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws EventException {
		try {
			return dbDao.searchCMPBGroupLocationList(rsltGrpLocListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * REGION CODE를 조회한다.<br>
	 * 
	 * @param RsltRgnListVO rsltRgnListVO  
	 * @return List<RsltRgnListVO>
	 * @exception EventException
	 */
	public List<RsltRgnListVO> searchRegionList(RsltRgnListVO rsltRgnListVO) throws EventException {
		try {
			return dbDao.searchRegionList(rsltRgnListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * COUNTRY CODE를 COMBO로 조회한다.<br>
	 * 
	 * @param RsltCdListVO rsltCobCntListVO  
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */	
	public List<RsltCdListVO> searchComboCountryList(RsltCdListVO rsltCobCntListVO) throws EventException {
		try {
			return dbDao.searchComboCountryList(rsltCobCntListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * S/C GUIDELINE GROUP LOCATION CODE DETAIL 정보를 조회한다.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO  
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */	
	public List<RsltGrpLocDtlListVO> searchSgGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws EventException {
		try {
			return dbDao.searchSgGroupLocationDetailList(rsltGrpLocDtlListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * SURCHARGE GROUP LOCATION CODE DETAIL 정보를 조회한다.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */	
	public List<RsltGrpLocDtlListVO> searchScgGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws EventException {
		try {
			return dbDao.searchScgGroupLocationDetailList(rsltGrpLocDtlListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	} 
	
	/**
	 * RFA PROPOSAL GROUP LOCATION CODE DETAIL 정보를 조회한다.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */	
	public List<RsltGrpLocDtlListVO> searchRpScpGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws EventException {
		try {
			return dbDao.searchRpScpGroupLocationDetailList(rsltGrpLocDtlListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * CMPB GROUP LOCATION CODE DETAIL 정보를 조회한다.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */	
	public List<RsltGrpLocDtlListVO> searchCMPBGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws EventException {
		try {
			return dbDao.searchCMPBGroupLocationDetailList(rsltGrpLocDtlListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * S/C PROPOSAL GROUP LOCATION CODE DETAIL 정보를 조회한다.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */	
	public List<RsltGrpLocDtlListVO> searchSpScpGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws EventException {
		try {
			return dbDao.searchSpScpGroupLocationDetailList(rsltGrpLocDtlListVO);
		}  catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}


	/**
	 * RFA PROPOSAL GROUP LOCATION CODE DETAIL 정보를 조회한다.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */	
	public List<RsltGrpLocDtlListVO> searchRgGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws EventException {
		try {
			return dbDao.searchRgGroupLocationDetailList(rsltGrpLocDtlListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	
	/**
	 * SQ GROUP LOCATION CODE 정보를 조회한다.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO  
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchSQGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws EventException {
		try {
			return dbDao.searchSQGroupLocationList(rsltGrpLocListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * SQ GROUP LOCATION CODE DETAIL 정보를 조회한다.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO  
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */	
	public List<RsltGrpLocDtlListVO> searchSQGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws EventException {
		try {
			return dbDao.searchSQGroupLocationDetailList(rsltGrpLocDtlListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * RQ GROUP LOCATION CODE 정보를 조회한다.<br>
	 * 
	 * @param RsltGrpLocListVO rsltGrpLocListVO  
	 * @return List<RsltGrpLocListVO>
	 * @exception EventException
	 */
	public List<RsltGrpLocListVO> searchRQGroupLocationList(RsltGrpLocListVO rsltGrpLocListVO) throws EventException {
		try {
			return dbDao.searchRQGroupLocationList(rsltGrpLocListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * RQ GROUP LOCATION CODE DETAIL 정보를 조회한다.<br>
	 * 
	 * @param RsltGrpLocDtlListVO rsltGrpLocDtlListVO  
	 * @return List<RsltGrpLocDtlListVO>
	 * @exception EventException
	 */	
	public List<RsltGrpLocDtlListVO> searchRQGroupLocationDetailList(RsltGrpLocDtlListVO rsltGrpLocDtlListVO) throws EventException {
		try {
			return dbDao.searchRQGroupLocationDetailList(rsltGrpLocDtlListVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
	}
			
	
}