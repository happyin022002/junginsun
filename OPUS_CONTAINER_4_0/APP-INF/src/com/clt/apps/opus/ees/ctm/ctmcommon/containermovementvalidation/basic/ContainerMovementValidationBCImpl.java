/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementValidationBCImpl.java
*@FileTitle : CTM Common Util
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.basic;

import com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.integration.ContainerMovementValidationDBDAO;
import com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.vo.CtmCommonVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-CTMCommon Business Logic Basic Command implementation<br>
 * handling OPUS-CTMCommon business logic
 *
 * @author KyungMin Woo
 * @see CTMCommonEventResponse,ContainerMovementValidationBC DAO class reference
 * @since J2EE 1.4
 */

public class ContainerMovementValidationBCImpl extends BasicCommandSupport implements ContainerMovementValidationBC {

	// Database Access Object
	private transient ContainerMovementValidationDBDAO dbDao = null;

	/**
	 * creating ContainerMovementValidationBCImpl object
	 * creating ContainerMovementValidationDBDAO
	 */
	public ContainerMovementValidationBCImpl() {
		dbDao = new ContainerMovementValidationDBDAO();
	}

	/**
	 * creating yard list used in combo
	 *
	 * @param String orgYdCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkYard(String orgYdCd) throws EventException {
		try {
			String returnValue =  dbDao.checkYard(orgYdCd);
			if (returnValue == null || returnValue.trim().equals("")) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"yard code"}).getMessage());
			}
			return returnValue;
		} catch (EventException ex) {
			log.error(ex.getMessage(),ex);
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * checking yard existence
	 *
	 * @param String orgYdCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchYard(String orgYdCd) throws EventException {
		try {
			String returnValue = dbDao.searchYard(orgYdCd);
			if (returnValue == null || returnValue.trim().equals("")) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"yard code"}).getMessage());
			}
			return returnValue;
		} catch (EventException ex) {
			log.error(ex.getMessage(),ex);
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * checking yard existence
	 *
	 * @param String orgYdCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkYardOnly(String orgYdCd) throws EventException {
		try {
			String returnValue = dbDao.searchYard(orgYdCd);
			if (returnValue == null || returnValue.trim().equals("")) {
				returnValue = "";
			}
			return returnValue;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * checking slanCd existence
	 *
	 * @param String slanCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkSlan(String slanCd) throws EventException {
		try {
			String returnValue = dbDao.checkSlan(slanCd);
			if (returnValue == null || returnValue.trim().equals("")) {
				returnValue = "";
			}
			return returnValue;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * retrieving Vender Name(Grid Data Validation)
	 *
	 * @param String vender
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkServiceProvider(String vender) throws EventException {
		try {
			String returnValue = dbDao.checkServiceProvider(vender);
			if (returnValue == null || returnValue.trim().equals("")) {
				throw new EventException(new ErrorHandler("CTM10013", new String[]{"service provider"}).getMessage());
			}
			return returnValue;
		} catch (EventException ex) {
			log.error(ex.getMessage(),ex);
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * creating Reason code list for setting Combo
	 *
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchReasonList() throws EventException {
		try {
			String returnValue = dbDao.searchReasonList();
			if (returnValue == null || returnValue.trim().equals("")) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"reason list"}).getMessage());
			}
			return returnValue;
		} catch (EventException ex) {
			log.error(ex.getMessage(),ex);
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * getting container number and checking container status
	 *
	 * @param String cntrNo
	 * @param String mvmtStsCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkContainerNo(String cntrNo, String mvmtStsCd) throws EventException {
		try {
			String returnValue = "";
//			if (cntrNo.length() == 10)
//				returnValue = dbDao.checkContainerNo(cntrNo, mvmtStsCd);
//			else
				returnValue = dbDao.checkContainerNoNotLike(cntrNo, mvmtStsCd);
			if (returnValue == null || returnValue.trim().equals("")) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"container no"}).getMessage());
			}
			return returnValue;
		} catch (EventException ex) {
			log.error(ex.getMessage(), ex);
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * getting container and yard information and checking container status
	 *
	 * @param String cntrNo
	 * @param String yardCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkContainerYard(String cntrNo, String yardCD) throws EventException {
		try {
			String returnValue = "";
//			if (cntrNo.length() == 10)
//				returnValue = dbDao.checkContainerYard(cntrNo, yardCD);
//			else
				returnValue = dbDao.checkContainerYardNotLike(cntrNo, yardCD);
			if (returnValue == null || returnValue.trim().equals("")) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"container no"}).getMessage());
			}
			return returnValue;
		} catch (EventException ex) {
			log.error(ex.getMessage(),ex);
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * checking VVD with Yard, VVD, Type
	 *
	 * @param String yardCd
     * @param String vvdCd
     * @param String vvdTp
     * @param String oscaBkgFlg
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkVVDCNTR(String yardCd, String vvdCd, String vvdTp, String oscaBkgFlg) throws EventException {
		try {
			String returnValue = dbDao.checkVVDCNTR(yardCd, vvdCd, vvdTp, oscaBkgFlg);
			if (returnValue == null || returnValue.equals("")) {
				throw new EventException(new ErrorHandler("CTM10027", new String[]{"container no"}).getMessage());
			}
			return returnValue;
		} catch (EventException ex) {
			log.error(ex.getMessage(),ex);
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/** checkVVDCNTRAll
	 * 
     * @param String vvdCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkVVDCNTRAll(String vvdCd) throws EventException {
		try {
			String returnValue = dbDao.checkVVDCNTRAll(vvdCd);
			if (returnValue == null || returnValue.equals("")) {
				throw new EventException(new ErrorHandler("CTM10027", new String[]{"container no"}).getMessage());
			}
			return returnValue;
		} catch (EventException ex) {
			log.error(ex.getMessage(),ex);
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}
	
	/**
	 * getting country code and returning server ID
	 *
	 * @param String cntCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchUserLocalCode(String cntCd) throws EventException {
		try {
			String returnValue = dbDao.searchUserLocalCode(cntCd);
			if (returnValue == null || returnValue.trim().equals("")) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"user local code"}).getMessage());
			}
			return returnValue;
		} catch (EventException ex) {
			log.error(ex.getMessage(),ex);
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * getting Value, Column, Table and returning Value(rows data)
	 *
	 * @param CtmCommonVO ctmCommonVO
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String getCodeValue(CtmCommonVO ctmCommonVO) throws EventException {
		try {
			return dbDao.getCodeValue(ctmCommonVO);
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * getting Value, Column, Table as parameter and checking Value existence
	 *
	 * @param CtmCommonVO ctmCommonVO
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchCodeExist(CtmCommonVO ctmCommonVO) throws EventException {
		try {
			String returnValue = dbDao.searchCodeExist(ctmCommonVO);
			if (returnValue == null || returnValue.trim().equals("")) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{ctmCommonVO.getColumnNm().toLowerCase()}).getMessage());
			}
			return returnValue;
		} catch (EventException ex) {
			log.error(ex.getMessage(),ex);
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * validating inputed booking number
	 * call in case of OP. BKG_NO_SPLIT || CNMV_RCV_TERM || DST_YD_CD
	 * @param String bkgNo
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkBookingNo(String bkgNo) throws EventException {
		try {
			return dbDao.checkBookingNo(bkgNo);
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/** checkCtmBookingNo
	 * @param String bkgNo
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkCtmBookingNo(String bkgNo) throws EventException {
		try {
			return dbDao.checkCtmBookingNo(bkgNo);
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/** checkCtmBookingNo
	 *
	 * @param String CntrNo
	 * @param String bkgNo
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkCtmBookingContainer(String CntrNo, String bkgNo) throws EventException {
		try {
			return dbDao.checkCtmBookingContainer(CntrNo, bkgNo);
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * retrieving local code with login user's country code
	 *
	 * @param String yardCd
	 * @param String cntCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkSvrCode (String yardCd, String cntCd) throws EventException {
		try {
			String returnValue = dbDao.checkSvrCode(yardCd, cntCd);
			if (returnValue == null || returnValue.trim().equals("")) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"area id"}).getMessage());
			}
			return returnValue;
		} catch (EventException ex) {
			log.error(ex.getMessage(),ex);
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}
	
	/**
	 * retrieving office code with yard code
	 *
	 * @param String yardCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkYardOfcCode (String yardCd) throws EventException {
		try {
			String returnValue = dbDao.checkYardOfcCode(yardCd);
			if (returnValue == null || returnValue.trim().equals("")) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"yard code"}).getMessage());
			}
			return returnValue;
		} catch (EventException ex) {
			log.error(ex.getMessage(),ex);
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}
	
	/**
	 * retrieving office code with login user's office code
	 *
	 * @param String ydOfc
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkOfcCode (String ydOfc, String ofcCd) throws EventException {
		try {
			String returnValue = dbDao.checkOfcCode(ydOfc, ofcCd);
			if (returnValue == null || returnValue.trim().equals("")) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"office code"}).getMessage());
			}
			return returnValue;
		} catch (EventException ex) {
			log.error(ex.getMessage(),ex);
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * validating Movement Status Code from MDM_MVMT_STS table
	 *
	 * @param String mvmtStsCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchMvmtStsCd (String mvmtStsCd) throws EventException {
		try {
			String returnValue = dbDao.searchMvmtStsCd(mvmtStsCd);
			if (returnValue == null || returnValue.trim().equals("")) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"movement status code"}).getMessage());
			}
			return returnValue;
		} catch (EventException ex) {
			log.error(ex.getMessage(),ex);
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * validating Chassis Code
	 *
	 * @param String    chassisCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchChassisCd (String chassisCd) throws EventException {
		try {
			String returnValue = dbDao.searchChassisCd(chassisCd);
			if (returnValue == null || returnValue.trim().equals("")) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"chassis code"}).getMessage());
			}
			return returnValue;
		} catch (EventException ex) {
			log.error(ex.getMessage(),ex);
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * validating MGSet Code
	 *
	 * @param String    mgset
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchMGSet (String mgset) throws EventException {
		try {
			String returnValue = dbDao.searchMGSet(mgset);
			if (returnValue == null || returnValue.trim().equals("")) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"MG-Set code"}).getMessage());
			}
			return returnValue;
		} catch (EventException ex) {
			log.error(ex.getMessage(),ex);
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * retrieving Location Name(Grid Data Validation)
	 *
	 * @param String locCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String getLocationName(String locCd) throws EventException {
		try {
			String returnValue = dbDao.getLocationName(locCd);
			if (returnValue == null || returnValue.trim().equals("")) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"Location name"}).getMessage());
			}
			return returnValue;
		} catch (EventException ex) {
			log.error(ex.getMessage(),ex);
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * retrieving country with Office code
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchUserCntCode(String ofcCd) throws EventException {
		try {
			String returnValue = dbDao.searchUserCntCode(ofcCd);
			if (returnValue == null || returnValue.trim().equals("")) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"user country code"}).getMessage());
			}
			return returnValue;
		} catch (EventException ex) {
			log.error(ex.getMessage(),ex);
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * searching OfficeDate existence
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchUserLocCode(String ofcCd) throws EventException {
		try {
			String returnValue = dbDao.searchUserLocCode(ofcCd);
			if (returnValue == null || returnValue.trim().equals("")) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"office date"}).getMessage());
			}
			return returnValue;
		} catch (EventException ex) {
			log.error(ex.getMessage(),ex);
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * searching LocalDate existence
	 *
	 * @param String locCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchOfficeDt(String locCd) throws EventException {
		try {
			String returnValue = dbDao.searchOfficeDt(locCd);
			if (returnValue == null || returnValue.trim().equals("")) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"office date"}).getMessage());
			}
			return returnValue;
		} catch (EventException ex) {
			log.error(ex.getMessage(),ex);
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * searching Max Cycle No
	 *
	 * @param String cntrNo
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchMaxCycle(String cntrNo) throws EventException {
		try {
			String returnValue = dbDao.searchMaxCycle(cntrNo);
			return returnValue;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * searching Max Cycle Bkg
	 *
	 * @param String cntrNo
	 * @param String cycNo
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchMaxBkg(String cntrNo, String cycNo) throws EventException {
		try {
			String returnValue = dbDao.searchMaxBkg(cntrNo, cycNo);
			if (returnValue == null || returnValue.trim().equals("")) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"Max Cycle Bkg"}).getMessage());
			}
			return returnValue;
		} catch (EventException ex) {
			log.error(ex.getMessage(),ex);
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * searching Prev MVMT EQR Ref No
	 *
	 * @param String cntrNo
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchPrevEqrRefNo(String cntrNo) throws EventException {
		try {
			String returnValue = dbDao.searchPrevEqrRefNo(cntrNo);
			if (returnValue == null || returnValue.trim().equals("")) {
				throw new EventException(new ErrorHandler("CTM10001", new String[]{"Prev MVMT EQR Ref No"}).getMessage());
			}
			return returnValue;
		} catch (EventException ex) {
			log.error(ex.getMessage(),ex);
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * checking EQR Ref No
	 *
	 * @param String mtyPlnNo
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkEqrRefNo(String mtyPlnNo) throws EventException {
		try {
			String returnValue = dbDao.checkEqrRefNo(mtyPlnNo);
			if (returnValue == null || returnValue.trim().equals("")) {
				returnValue = "N";
			}
			return returnValue;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * search Lstm Cd
	 *
	 * @param String cntrNo
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchLstmCd(String cntrNo) throws EventException {
		try {
			String returnValue = dbDao.searchLstmCd(cntrNo);
			if (returnValue == null || returnValue.trim().equals("")) {
				returnValue = "N";
			}
			return returnValue;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}
}