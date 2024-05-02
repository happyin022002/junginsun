/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LocationBCImpl.java
*@FileTitle : Location Inquiry
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.location.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.primasterdata.location.integration.LocationDBDAO;
import com.clt.apps.opus.esm.pri.primasterdata.location.vo.RsltCntListVO;
import com.clt.apps.opus.esm.pri.primasterdata.location.vo.RsltGrpLocDtlListVO;
import com.clt.apps.opus.esm.pri.primasterdata.location.vo.RsltGrpLocListVO;
import com.clt.apps.opus.esm.pri.primasterdata.location.vo.RsltLocListVO;
import com.clt.apps.opus.esm.pri.primasterdata.location.vo.RsltRgnListVO;
import com.clt.apps.opus.esm.pri.primasterdata.location.vo.RsltSteListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * PRIMasterData Business Logic Basic Command implementation<br>
 * - Handling a biz logic about PRIMasterData<br>
 *
 * @author
 * @see ESM_PRI_4026EventResponse,LocationBC - refer to each DAO class
 * @since J2EE 1.4
 */

public class LocationBCImpl extends BasicCommandSupport implements LocationBC {

	// Database Access Object
	private transient LocationDBDAO dbDao = null;

	/**
	 * Creating LocationBCImpl object<br>
	 * Creating LocationDBDAO=<br>
	 */
	public LocationBCImpl() {
		dbDao = new LocationDBDAO();
	}
	/**
	 * Retrieving COUNTRY CODE.<br>
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
	 * Retrieving LOCATION CODE<br>
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
	 * Retrieving STATE CODE.<br>
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
	 * Retrieving SERVICE SCOPE GROUP LOCATION CODE<br>
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
	 * Retrieving RFA GUIDELINE GROUP LOCATION CODE<br>
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
	 * Retrieving S/C GUIDELINE GROUP LOCATION CODE<br>
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
	 * Retrieving RFA PROPOSAL GROUP LOCATION CODE<br>
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
	 * Retrieving SURCHARGE GROUP LOCATION CODE<br>
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
	 * Retrieving REGION CODE<br>
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
	 * Retrieving COUNTRY CODE as COMBO<br>
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
	 * Retrieving S/C GUIDELINE GROUP LOCATION CODE DETAIL <br>
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
	 * Retrieving SURCHARGE GROUP LOCATION CODE DETAIL<br>
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
	 * Retrieving RFA PROPOSAL GROUP LOCATION CODE DETAIL <br>
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
	 * Retrieving S/C PROPOSAL GROUP LOCATION CODE DETAIL <br>
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
	 * Retrieving RFA PROPOSAL GROUP LOCATION CODE DETAIL <br>
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
	
 
 
}