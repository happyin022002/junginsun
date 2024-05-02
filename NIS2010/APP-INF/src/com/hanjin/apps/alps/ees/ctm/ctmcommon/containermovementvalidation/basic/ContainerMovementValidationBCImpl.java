/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementValidationBCImpl.java
*@FileTitle : CTM Common Util
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.05.06 우경민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.basic;

import com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.integration.ContainerMovementValidationDBDAO;
import com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.vo.CtmCommonVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-CTMCommon Business Logic Basic Command implementation<br>
 * - ALPS-CTMCommon에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author KyungMin Woo
 * @see CTMCommonEventResponse,ContainerMovementValidationBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class ContainerMovementValidationBCImpl extends BasicCommandSupport implements ContainerMovementValidationBC {

	// Database Access Object
	private transient ContainerMovementValidationDBDAO dbDao = null;

	/**
	 * ContainerMovementValidationBCImpl 객체 생성<br>
	 * ContainerMovementValidationDBDAO를 생성한다.<br>
	 */
	public ContainerMovementValidationBCImpl() {
		dbDao = new ContainerMovementValidationDBDAO();
	}

	/**
	 * Yard를 얻어서 Combo에서 사용되는 YardList를 생성한다.<br>
	 *
	 * @param String orgYdCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkYard(String orgYdCd) throws EventException {
		try {
			String returnValue =  dbDao.checkYard(orgYdCd);
			return returnValue;
//			if (returnValue == null || returnValue.trim().equals("")) {
////		returnValue = "M";
//		throw new EventException(new ErrorHandler("CTM10001", new String[]{"container no"}).getMessage());
////		return returnValue;
//	}
	
//} catch (EventException ex) {
//	log.error(ex.getMessage(), ex);
//	throw ex;

		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * Yard를 존재 유무를 체크한다.<br>
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
	 * Vender의 Name을 조회한다. (Grid Data Validation).<br>
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
	 * Combo세팅을 위한 Reson 코드 List를 생성한다<br>
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
	 * 컨테이너 번호를 읽어오고 해당하는 컨테이너의 상태등을 리턴한다. <br>
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
			if (cntrNo.length() == 10)
				returnValue = dbDao.checkContainerNo(cntrNo, mvmtStsCd);
			else
				returnValue = dbDao.checkContainerNoNotLike(cntrNo, mvmtStsCd);
//			if (returnValue == null || returnValue.trim().equals("")) {
////				returnValue = "M";
//				throw new EventException(new ErrorHandler("CTM10001", new String[]{"container no"}).getMessage());
////				return returnValue;
//			}
			
			return returnValue;
//		} catch (EventException ex) {
//			log.error(ex.getMessage(), ex);
//			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * 컨테이너와 야드정보를 읽어오고 해당하는 컨테이너의 상태등을 리턴한다. <br>
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
			if (cntrNo.length() == 10)
				returnValue = dbDao.checkContainerYard(cntrNo, yardCD);
			else
				returnValue = dbDao.checkContainerYardNotLike(cntrNo, yardCD);
//			if (returnValue == null || returnValue.trim().equals("")) {
////		returnValue = "M";
//		throw new EventException(new ErrorHandler("CTM10001", new String[]{"container no"}).getMessage());
////		return returnValue;
//	}
	
	return returnValue;
//} catch (EventException ex) {
//	log.error(ex.getMessage(), ex);
//	throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * Yard, VVD, Type을 받아서 VVD가 존재하는지 체크한다. 성공 S.<br>
	 *
	 * @param String yardCd
     * @param String vvdCd
     * @param String vvdTp
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkVVDCNTR(String yardCd, String vvdCd, String vvdTp) throws EventException {
		try {
			String returnValue = dbDao.checkVVDCNTR(yardCd, vvdCd, vvdTp);
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
	 * 국가코드를 넘겨받고 서버아이디를 리턴한다<br>
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
	 * Value, Column, Table을 Param으로 받아서 Value(rows data)를 가져옴<br>
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
	 * Value, Column, Table을 Param으로 받아서 Value가 존재하는지 Check.<br>
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
	 * 넘겨받은 Booking No를 Validation한다.<br>
	 * OP일경우호출. BKG_NO_SPLIT || CNMV_RCV_TERM || DST_YD_CD
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

	/**
	 * 로그인한 사용자의 Country Code로 Local Code를 조회한다.<br>
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
	 * MDM_MVMT_STS 테이블에서 사용자가 입력한 Movement Status Code의 유효성을 체크한다.<br>
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
	 * Chassis Code의 유효성을 체크한다.<br>
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
	 * Chassis Code의 유효성을 체크한다.<br>
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
	 * Location의 Name을 조회한다. (Grid Data Validation).<br>
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
	 * Office코드로 국가코드를 조회<br>
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
}