/**
 * Copyright(c) 2009 CyberLogitec
 * @FileName : GuaranteeCommonBCImpl.java
 * @FileTitle : GuaranteeCommon
 * Open Issues :
 * Change history :
 * @LastModifyDate :
 * @LastModifier :
 * @LastVersion : 1.0
 */
package com.clt.apps.opus.esd.tes.common.guaranteecommon.basic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.tes.common.guaranteecommon.event.GuaranteeCommonHTMLAction;
import com.clt.apps.opus.esd.tes.common.guaranteecommon.integration.GuaranteeCommonDBDAO;
import com.clt.apps.opus.esd.tes.common.guaranteecommon.vo.SearchRefNoListVO;
import com.clt.apps.opus.esd.tes.common.tescommon.event.TESCommonEvent;
import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.TesGnteCntrListVO;
import com.clt.syscommon.common.table.TesGnteHdrVO;

/**
 * GuaranteeCommon Business Logic Command Interface<br>
 * Coding business logic for GuaranteeCommonBCImpl<br>
 * 
 * @author yOng hO lEE
 * @see GuaranteeCommonHTMLAction
 * @since J2EE 1.6
 */
public class GuaranteeCommonBCImpl extends BasicCommandSupport implements GuaranteeCommonBC {

	// Database Access Object
	private transient GuaranteeCommonDBDAO dbDao = null;

	/**
	 * GuaranteeCommonBCImpl object creation<br>
	 * Creating GuaranteeCommonDBDAO<br>
	 */
	public GuaranteeCommonBCImpl() {
		dbDao = new GuaranteeCommonDBDAO();
	}

	/**
	 * Searching Reference No(Guarantee No. Or Irregular No.).<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchRefNoListVO>
	 * @exception EventException
	 */
	public List<SearchRefNoListVO> searchRefNoList(GuaranteeCommonVO guaranteeCommonVO) throws EventException {
		try {
			return dbDao.searchRefNoList(guaranteeCommonVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Searching Guarantee Container Bkg No & Bl No & VVD Info.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchUSGuaranteeCntrInfoVO>
	 * @exception EventException
	 */
	public DBRowSet searchUSGuaranteeCntrInfo(GuaranteeCommonVO guaranteeCommonVO) throws EventException {
		try {
			return dbDao.searchUSGuaranteeCntrInfo(guaranteeCommonVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Validating Customer Code.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<ValidateCustomerCodeVO>
	 * @exception EventException
	 */
	public DBRowSet validateCustomerCode(GuaranteeCommonVO guaranteeCommonVO) throws EventException {
		try {
			return dbDao.validateCustomerCode(guaranteeCommonVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * validateCustomerCode2
	 * 
	 * @param guaranteeCommonVO
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse validateCustomerCode2(GuaranteeCommonVO guaranteeCommonVO) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String custNm = "";
		Map<String, String> etcData = new HashMap<String, String>();

		try {
			custNm = dbDao.validateCustomerCode2(guaranteeCommonVO);

			etcData.put("cust_nm", custNm);
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Searching that delete flag.<br>
	 * 
	 * @param TesGnteCntrListVO tesGnteCntrListVO
	 * @return List<TesGnteCntrListVO>
	 * @exception EventException
	 */
	public List<TesGnteCntrListVO> checkNonTPB(TesGnteCntrListVO tesGnteCntrListVO) throws EventException {
		List<TesGnteCntrListVO> list = null;

		try {
			list = dbDao.checkNonTPB(tesGnteCntrListVO);

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Checking Container No. Duplication.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return boolean
	 * @exception EventException
	 */
	public boolean checkDupCntr(GuaranteeCommonVO guaranteeCommonVO) throws EventException {
		try {
			return dbDao.checkDupCntr(guaranteeCommonVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Searching Guarantee Container Bkg No & Bl No & VVD Info.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchUSGuaranteeCntrInfoVO>
	 * @exception EventException
	 */
	public DBRowSet searchCntrBkgNo(GuaranteeCommonVO guaranteeCommonVO) throws EventException {
		try {
			return dbDao.searchCntrBkgNo(guaranteeCommonVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * validateYardCode
	 * 
	 * @param tesGnteHdrVO
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse validateYardCode(TesGnteHdrVO tesGnteHdrVO) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String sYdNm = "";
		Map<String, String> etcData = new HashMap<String, String>();

		try {
			sYdNm = dbDao.validateYardCode(tesGnteHdrVO);

			etcData.put("yd_nm", sYdNm);
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Validating Cost OFC.
	 * @param tesGnteHdrVO
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse validateOfficeCode(TesGnteHdrVO tesGnteHdrVO) throws EventException {
		String sFlg = "";		
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();		
		Map<String, String>		etcData			= new HashMap<String, String>();

		try {
			sFlg = dbDao.validateOfficeCode(tesGnteHdrVO);

			etcData.put("ofc_yn", sFlg);				
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
}
