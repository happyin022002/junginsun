/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementValidationBC.java
*@FileTitle : CTM Common Util
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.basic;

import com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.vo.CtmCommonVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;

/**
 * OPUS-Ctmcommon Business Logic Command Interface
 * Interface for- OPUS-Ctmcommon business logic
 *
 * @author 
 * @see CtmcommonEventResponse reference
 * @since J2EE 1.4
 */

@SuppressWarnings("unused")
public interface ContainerMovementValidationBC {

	/**
	 * creating yard list used in combo
	 *
	 * @param String orgYdCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkYard(String orgYdCd) throws EventException;

	/**
	 * checking yard existence
	 *
	 * @param String orgYdCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchYard(String orgYdCd) throws EventException;

	/**
	 * checking yard existence
	 *
	 * @param String orgYdCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkYardOnly(String orgYdCd) throws EventException;

	/**
	 * checking slanCd existence
	 *
	 * @param String slanCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkSlan(String slanCd) throws EventException;

	/**
	 * searching ofcCd's LocCd existence
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchUserLocCode(String ofcCd) throws EventException;

	/**
	 * searching LocalDate existence
	 *
	 * @param String locCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchOfficeDt(String locCd) throws EventException;

	/**
	 * searching Max Cycle No
	 *
	 * @param String cntrNo
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchMaxCycle(String cntrNo) throws EventException;

	/**
	 * searching Lstm Cd
	 *
	 * @param String cntrNo
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchLstmCd(String cntrNo) throws EventException;

	/**
	 * searching Max Cycle Bkg
	 * 
	 * @param String cntrNo
	 * @param String cycNo
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchMaxBkg(String cntrNo, String cycNo) throws EventException;

	/**
	 * searching Prev MVMT EQR Ref No
	 *
	 * @param String cntrNo
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchPrevEqrRefNo(String cntrNo) throws EventException;

	/**
	 * retrieving Vender Name(Grid Data Validation)
	 *
	 * @param String vender
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkServiceProvider(String vender) throws EventException;

	/**
	 * creating Reason code list for setting Combo
	 *
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchReasonList() throws EventException;

	/**
	 * getting container number and checking container status
	 *
	 * @param String cntrNo
	 * @param String mvmtStsCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkContainerNo(String cntrNo, String mvmtStsCd) throws EventException;

	/**
	 * getting container and yard information and checking container status
	 *
	 * @param String cntrNo
	 * @param String yardCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkContainerYard(String cntrNo, String yardCd) throws EventException;

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
	public String checkVVDCNTR(String yardCd, String vvdCd, String vvdTp, String oscaBkgFlg) throws EventException;
	
	/** checkVVDCNTRAll
	 * 
	 * @param vvdCd
	 * @return String
	 * @throws EventException
	 */
	public String checkVVDCNTRAll(String vvdCd) throws EventException;
	/**
	 * getting country code and returning server ID
	 * 
	 * @param String cntCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchUserLocalCode(String cntCd) throws EventException;

	/**
	 * getting Value, Column, Table and returning Value(rows data)
	 *
	 * @param CtmCommonVO ctmCommonVO
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String getCodeValue(CtmCommonVO ctmCommonVO) throws EventException;

	/**
	 * getting Value, Column, Table as parameter and checking Value existence
	 *
	 * @param CtmCommonVO ctmCommonVO
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchCodeExist(CtmCommonVO ctmCommonVO) throws EventException;

	/**
	 * validating inputed booking number
	 * call in case of OP. BKG_NO_SPLIT || CNMV_RCV_TERM || DST_YD_CD
	 * @param String bkgNo
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkBookingNo(String bkgNo) throws EventException;

	/** checkCtmBookingNo
	 * 
	 * @param bkgNo
	 * @return String
	 * @throws EventException
	 */
	public String checkCtmBookingNo(String bkgNo) throws EventException;

	/** checkCtmBookingNo
	 * 
	 * @param String CntrNo
	 * @param String bkgNo
	 * @return String
	 * @throws EventException
	 */
	public String checkCtmBookingContainer(String CntrNo, String bkgNo) throws EventException;
	/**
	 * retrieving local code with login user's country code
	 *
	 * @param String yardCd
	 * @param String cntCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkSvrCode (String yardCd, String cntCd) throws EventException;
	/**
	 * retrieving office code with yard code
	 *
	 * @param String yardCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkYardOfcCode (String yardCd) throws EventException;
	/**
	 * retrieving office code with login user's office code
	 *
	 * @param String ydOfc
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkOfcCode (String ydOfc, String ofcCd) throws EventException;

	/**
	 * validating Movement Status Code from MDM_MVMT_STS table
	 *
	 * @param String    mvmtStsCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchMvmtStsCd (String mvmtStsCd) throws EventException;

	/**
	 * validating Chassis Code
	 *
	 * @param String    chassisCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchChassisCd (String chassisCd) throws EventException;

	/**
	 * validating MGSet Code
	 *
	 * @param String    mgset
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchMGSet (String mgset) throws EventException;

	/**
	 * retrieving Location Name(Grid Data Validation)
	 *
	 * @param String locCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String getLocationName(String locCd) throws EventException;

	/**
	 * retrieving country with Office code
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchUserCntCode(String ofcCd) throws EventException;

	/**
	 * checking EQR Ref No
	 *
	 * @param String mtyPlnNo
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkEqrRefNo(String mtyPlnNo) throws EventException;
}