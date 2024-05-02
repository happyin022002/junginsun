/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgmValidationBCImpl.java
*@FileTitle : cgm_validation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.integration.CgmValidationDBDAO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.AgrementINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.AgrementMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.CgmChssPoolINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.CgmChssPoolMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.ChsMasterMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.LocationMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.MdmCurrencyMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.MdmVendorMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.OfficeINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.OfficeMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.TpSzDupChkINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.TpSzDupChkMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.YardINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmvalidation.vo.YardMGTVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-CgmCommon Business Logic Basic Command implementation<br>
 * - OPUS-CgmCommon biz logic handling.<br>
 * 
 * @author KIM CHANG SIK
 * @see cgm_validationEventResponse,CgmValidationBC each DAO class reference
 * @since J2EE 1.6
 */
public class CgmValidationBCImpl extends BasicCommandSupport implements CgmValidationBC {

	// Database Access Object
	private transient CgmValidationDBDAO dbDao = null;

	/**
	 * CgmValidationBCImpl objects creation<br>
	 * CgmValidationDBDAO creation.<br>
	 */
	public CgmValidationBCImpl() {
		dbDao = new CgmValidationDBDAO();
	}

	/**
	 * Office code check . Retrieve. <br>
	 * 
	 * @param officeINVO
	 *            OfficeINVO
	 * @return List<OfficeMGTVO>
	 * @exception EventException
	 */
	public List<OfficeMGTVO> checkOfficeBasic(OfficeINVO officeINVO) throws EventException {
		try {
			return dbDao.checkOfficeData(officeINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * yard code valid check . Retrieve. <br>
	 * 
	 * @param yardINVO
	 *            YardINVO
	 * @return List<YardMGTVO>
	 * @exception EventException
	 */
	public List<YardMGTVO> checkYardBasic(YardINVO yardINVO) throws EventException {
		try {
			return dbDao.checkYardData(yardINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * available yard code valid check . Retrieve. <br>
	 * 
	 * @param yardINVO
	 *            YardINVO
	 * @return List<YardMGTVO>
	 * @exception EventException
	 */
	public List<YardMGTVO> checkYardAvailableYardBasic(YardINVO yardINVO) throws EventException {
		try {
			return dbDao.checkYardAvailableYardData(yardINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * Agreement existing check . Retrieve. <br>
	 * 
	 * @param agrementINVO
	 *            AgrementINVO
	 * @return List<AgrementMGTVO>
	 * @exception EventException
	 */
	public List<AgrementMGTVO> checkAgreementBasic(AgrementINVO agrementINVO) throws EventException {
		try {
			log.debug("agrementINVO.setAgmtOfcCtyCd=======================");
			String sTmp = agrementINVO.getAgmtOfcCtyCd();
			log.debug("agrementINVO. sTmp=======================" + sTmp);
			int seq = Integer.parseInt(sTmp.substring(3, sTmp.length()));

			agrementINVO.setAgmtOfcCtyCd(sTmp.substring(0, 3));
			agrementINVO.setAgmtSeq(Integer.toString(seq));
			//
			log.debug("agrementINVO.setAgmtOfcCtyCd=======================" + agrementINVO.getAgmtOfcCtyCd());
			log.debug("agrementINVO.setAgmtSeq============================" + agrementINVO.getAgmtSeq());

			return dbDao.checkAgreementData(agrementINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * CGM EQUIPMENT table Chassis master information retrieve . Retrieve. <br>
	 * 
	 * @param chsMasterMGTVO
	 *            ChsMasterMGTVO
	 * @return List<ChsMasterMGTVO>
	 * @exception EventException
	 */
	public List<ChsMasterMGTVO> searchCGMMasterBasic(ChsMasterMGTVO chsMasterMGTVO) throws EventException {
		// Map object for Response object
		try {
			return dbDao.searchCGMMasterData(chsMasterMGTVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}

	}

	/**
	 * Retrieve DM_VENDOR table Vendor information . Retrieve. <br>
	 * 
	 * @param mdmVendorMGTVO
	 *            MdmVendorMGTVO
	 * @return List<MdmVendorMGTVO>
	 * @exception EventException
	 */
	public List<MdmVendorMGTVO> searchVendorListBasic(MdmVendorMGTVO mdmVendorMGTVO) throws EventException {
		// Map object for Response object
		try {
			return dbDao.searchVendorListData(mdmVendorMGTVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * CGM_EQ_TP_SZ table information retrieve . Retrieve. <br>
	 * 
	 * @param tpSzDupChkINVO
	 *            TpSzDupChkINVO
	 * @return List<TpSzDupChkMGTVO>
	 * @exception EventException
	 */
	public List<TpSzDupChkMGTVO> searchEqTpSzDupChkBasic(TpSzDupChkINVO tpSzDupChkINVO) throws EventException {
		try {
			return dbDao.searchEqTpSzDupChkData(tpSzDupChkINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * MST_CONTAINER information retrieve . Retrieve. <br>
	 * 
	 * @param chsMasterMGTVO
	 *            ChsMasterMGTVO
	 * @return List<ChsMasterMGTVO>
	 * @exception EventException
	 */
	public List<ChsMasterMGTVO> searchCNTRMasterBasic(ChsMasterMGTVO chsMasterMGTVO) throws EventException {
		try {
			// List<ChsMasterMGTVO> list =
			// dbDao.searchCNTRMasterData(chsMasterMGTVO);
			//
			//
			// if(list != null){
			// if(list.size() > 0){
			// for(int i = 0; i < list.size(); i++){
			// tmpMGTVO = (ChsMasterMGTVO)list.get(0);
			// }
			// }
			// }
			return dbDao.searchCNTRMasterData(chsMasterMGTVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * Location Code check . Retrieve. <br>
	 * 
	 * @param locationMGTVO
	 *            LocationMGTVO
	 * @return List<LocationMGTVO>
	 * @exception EventException
	 */
	public List<LocationMGTVO> checkLocationBasic(LocationMGTVO locationMGTVO) throws EventException {
		try {
			return dbDao.checkLocationData(locationMGTVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * CGM_CHSS_POOL table information retrieve Retrieve. <br>
	 * 
	 * @param cgmChssPoolINVO
	 *            CgmChssPoolINVO
	 * @return List<CgmChssPoolMGTVO>
	 * @exception EventException
	 */
	public List<CgmChssPoolMGTVO> seachChssPoolListBasic(CgmChssPoolINVO cgmChssPoolINVO) throws EventException {
		try {
			return dbDao.searchChssPoolData(cgmChssPoolINVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * MDM_CURRENCY table information retrieve Retrieve. <br>
	 * 
	 * @param mdmCurrencyMGTVO
	 *            MdmCurrencyMGTVO
	 * @return List<MdmCurrencyMGTVO>
	 * @exception EventException
	 */
	public List<MdmCurrencyMGTVO> searchMDMCurrencyBasic(MdmCurrencyMGTVO mdmCurrencyMGTVO) throws EventException {
		try {
			return dbDao.searchMDMCurrencyData(mdmCurrencyMGTVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * Location Code check . Retrieve. <br>
	 * 
	 * @param locationMGTVO
	 *            LocationMGTVO
	 * @return List<LocationMGTVO>
	 * @exception EventException
	 */
	public List<LocationMGTVO> searchOfficeYardControlOfficeMatchBasic(LocationMGTVO locationMGTVO) throws EventException {
		try {
			return dbDao.searchOfficeYardControlOfficeMatchData(locationMGTVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("CGM20031").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
}