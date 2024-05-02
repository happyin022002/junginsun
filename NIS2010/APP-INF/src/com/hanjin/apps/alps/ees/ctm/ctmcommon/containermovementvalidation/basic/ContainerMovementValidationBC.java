/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementValidationBC.java
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

import com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.vo.CtmCommonVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;

/**
 * ALPS-Ctmcommon Business Logic Command Interface<br>
 * - ALPS-Ctmcommon에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KyungMin Woo
 * @see CtmcommonEventResponse 참조
 * @since J2EE 1.4
 */

@SuppressWarnings("unused")
public interface ContainerMovementValidationBC {

	/**
	 * Yard를 얻어서 Combo에서 사용되는 YardList를 생성한다.<br>
	 *
	 * @param String orgYdCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkYard(String orgYdCd) throws EventException;

	/**
	 * Yard를 존재 유무를 체크한다.<br>
	 *
	 * @param String orgYdCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchYard(String orgYdCd) throws EventException;

	/**
	 * Vender의 Name을 조회한다. (Grid Data Validation).<br>
	 *
	 * @param String vender
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkServiceProvider(String vender) throws EventException;

	/**
	 * Combo세팅을 위한 Reson 코드 List를 생성한다<br>
	 *
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchReasonList() throws EventException;

	/**
	 * 컨테이너 번호를 읽어오고 해당하는 컨테이너의 상태등을 리턴한다.<br>
	 *
	 * @param String cntrNo
	 * @param String mvmtStsCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkContainerNo(String cntrNo, String mvmtStsCd) throws EventException;

	/**
	 * 컨테이너와 야드정보를 읽어오고 해당하는 컨테이너의 상태등을 리턴한다.<br>
	 *
	 * @param String cntrNo
	 * @param String yardCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkContainerYard(String cntrNo, String yardCd) throws EventException;

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
	public String checkVVDCNTR(String yardCd, String vvdCd, String vvdTp) throws EventException;

	/**
	 * 국가코드를 넘겨받고 서버아이디를 리턴한다<br>
	 *
	 * @param String cntCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchUserLocalCode(String cntCd) throws EventException;

	/**
	 * Value, Column, Table을 Param으로 받아서 Value(rows data)를 가져옴<br>
	 *
	 * @param CtmCommonVO ctmCommonVO
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String getCodeValue(CtmCommonVO ctmCommonVO) throws EventException;

	/**
	 * Value, Column, Table을 Param으로 받아서 Value가 존재하는지 Check<br>
	 *
	 * @param CtmCommonVO ctmCommonVO
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchCodeExist(CtmCommonVO ctmCommonVO) throws EventException;

	/**
	 * 넘겨받은 Booking No를 Validation한다.<br>
	 * OP일경우호출. BKG_NO_SPLIT || CNMV_RCV_TERM || DST_YD_CD
	 * @param String bkgNo
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkBookingNo(String bkgNo) throws EventException;

	/**
	 * 로그인한 사용자의 Country Code로 Local Code를 조회한다.<br>
	 *
	 * @param String yardCd
	 * @param String cntCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String checkSvrCode (String yardCd, String cntCd) throws EventException;

	/**
	 * MDM_MVMT_STS 테이블에서 사용자가 입력한 Movement Status Code의 유효성을 체크한다.<br>
	 *
	 * @param String    mvmtStsCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchMvmtStsCd (String mvmtStsCd) throws EventException;

	/**
	 * Chassis Code의 유효성을 체크한다.<br>
	 *
	 * @param String    chassisCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchChassisCd (String chassisCd) throws EventException;

	/**
	 * MGSet Code의 유효성을 체크한다.<br>
	 *
	 * @param String    mgset
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchMGSet (String mgset) throws EventException;
	
	/**
	 * Location의 Name을 조회한다. (Grid Data Validation).<br>
	 *
	 * @param String locCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String getLocationName(String locCd) throws EventException;

	/**
	 * Office코드로 국가코드를 조회<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws EventException
	 * @Exception DAOException, Exception
	 */
	public String searchUserCntCode(String ofcCd) throws EventException;
}