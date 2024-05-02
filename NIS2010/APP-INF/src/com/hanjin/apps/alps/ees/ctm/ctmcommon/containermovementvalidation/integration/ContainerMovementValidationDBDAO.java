/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerMovementValidationDBDAO.java
*@FileTitle : CTM Common Util
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 우경민
*@LastVersion : 1.0
* 2009.05.06 우경민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.basic.ContainerMovementValidationBCImpl;
import com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.vo.CtmCommonVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS ContainerMovementValidationDBDAO <br>
 * - ALPS-CTMCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KyungMin Woo
 * @see ContainerMovementValidationBCImpl 참조
 * @since J2EE 1.4
 */
public class ContainerMovementValidationDBDAO extends DBDAOSupport {

	/**
	 * 넘겨받은 Booking No, Split을 Validation한다.<br>
	 * OP일경우호출. BKG_NO_SPLIT || CNMV_RCV_TERM || DST_YD_CD
	 * @param String bkgNo
	 * @param String bkgNoSplit
	 * @return String
	 * @throws DAOException
	 *
	 */
	public String checkBookingNO(String bkgNo, String bkgNoSplit) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		StringBuffer rtnStr = new StringBuffer();
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("p_bkg_no", bkgNo);
			mapVO.put("p_bkg_no_split", bkgNoSplit);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOcheckBKGNoRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnStr.append(dbRowset.getString("BKG_NO_SPLIT")).append("||");
				rtnStr.append(dbRowset.getString("CNMV_RCV_TERM")).append("||");
				rtnStr.append(dbRowset.getString("DST_YD_CD"));
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr.toString();
	}

	/**
	 * 넘겨받은 Booking No를 Validation한다.<br>
	 * OP일경우호출. BKG_NO_SPLIT || CNMV_RCV_TERM || DST_YD_CD
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String checkBookingNo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		StringBuffer rtnStr = new StringBuffer();
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("p_bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOcheckBookingRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnStr.append(dbRowset.getString("BKG_NO_SPLIT")).append("||");
				rtnStr.append(dbRowset.getString("RCV_TERM_CD")).append("||");
				rtnStr.append(dbRowset.getString("POR_CD")).append("||");
				rtnStr.append(dbRowset.getString("POL_CD")).append("||");
				rtnStr.append(dbRowset.getString("BL_NO")).append("||");
				rtnStr.append(dbRowset.getString("BL_NO_TP")).append("||");
				rtnStr.append(dbRowset.getString("BL_NO_CHK")).append("||");
				rtnStr.append(dbRowset.getString("BL_TP_CD")).append("||");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr.toString();
	}

	/**
	 * Yard, VVD, Type을 받아서 VVD가 존재하는지 체크한다. 성공 S.<br>
	 *
	 * @param String yardCd
     * @param String vvdCd
     * @param String vvdTp
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String checkVVDCNTR(String yardCd, String vvdCd, String vvdTp) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnStr = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("p_yardcd", yardCd);
			mapVO.put("p_vvdcd", vvdCd);
			mapVO.put("p_vvd_type", vvdTp);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOcheckVVDCNTRRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnStr = "S";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}

	/**
	 * Vender의 Name을 조회한다. (Grid Data Validation).<br>
	 *
	 * @param String vender
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String checkServiceProvider(String vender) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnStr = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("p_vender", vender);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOcheckServiceProviderRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnStr = dbRowset.getString("VNDR_LGL_ENG_NM");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}

	/**
	 * Yard를 얻어서 Combo에서 사용되는 YardList를 생성한다.<br>
	 *
	 * @param String orgYdCd
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String checkYard(String orgYdCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		StringBuffer rtnValues = new StringBuffer();
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("p_yard1", orgYdCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOcheckYardRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnValues.append(dbRowset.getString("YD_S")).append("|").append(dbRowset.getString("YD_NM")).append("|").append(dbRowset.getString("YD_S")).append("^");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValues.toString();
	}

	/**
	 * Yard를 존재 유무를 체크한다.<br>
	 *
	 * @param String orgYdCd
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String searchYard(String orgYdCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("p_yard1", orgYdCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOsearchYardRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = "S";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * 컨테이너 번호를 읽어오고 해당하는 컨테이너의 상태등을 리턴한다. 10바이트로 넘어오는 자료<br>
	 *
	 * @param String cntrNo
	 * @param String mvmtStsCd
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String checkContainerNo(String cntrNo, String mvmtStsCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		StringBuffer rtnValue = new StringBuffer();
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("yard_cd", cntrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOcheckContainerNoRSQL(), param, velParam);

			while (dbRowset.next()) {
				//CNTR_NO, CNMV_STS_CD, CNTR_TPSZ_CD, CRNT_YD_CD, ACIAC_DIV_CD, HJS_CRE_FLG, IMDT_EXT_FLG
				rtnValue.append(dbRowset.getString("CNTR_NO")).append("|");
				rtnValue.append(dbRowset.getString("CNMV_STS_CD")).append("|");
				rtnValue.append(dbRowset.getString("CNTR_TPSZ_CD")).append("|");
				rtnValue.append(dbRowset.getString("CRNT_YD_CD")).append("|");
				rtnValue.append(dbRowset.getString("ACIAC_DIV_CD")).append("|");
				rtnValue.append(dbRowset.getString("HJS_CRE_FLG")).append("|");
				rtnValue.append(dbRowset.getString("IMDT_EXT_FLG")).append("|");
				rtnValue.append(dbRowset.getString("CNTR_RSK_FLG"));
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue.toString();
	}

	/**
	 * 컨테이너 번호를 읽어오고 해당하는 컨테이너의 상태등을 리턴한다. 임대장비 혹은 10바이트 미만<br>
	 *
	 * @param String cntrNo
	 * @param String mvmtStsCd
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String checkContainerNoNotLike(String cntrNo, String mvmtStsCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		StringBuffer rtnValue = new StringBuffer();
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("yard_cd", cntrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOcheckContainerNoNotLikeRSQL(), param, velParam);
			while (dbRowset.next()) {
				//CNTR_NO, CNMV_STS_CD, CNTR_TPSZ_CD, CRNT_YD_CD, ACIAC_DIV_CD, HJS_CRE_FLG, IMDT_EXT_FLG
				rtnValue.append(dbRowset.getString("CNTR_NO")).append("|");
				rtnValue.append(dbRowset.getString("CNMV_STS_CD")).append("|");
				rtnValue.append(dbRowset.getString("CNTR_TPSZ_CD")).append("|");
				rtnValue.append(dbRowset.getString("CRNT_YD_CD")).append("|");
				rtnValue.append(dbRowset.getString("ACIAC_DIV_CD")).append("|");
				rtnValue.append(dbRowset.getString("HJS_CRE_FLG")).append("|");
				rtnValue.append(dbRowset.getString("IMDT_EXT_FLG"));
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue.toString();
	}

	/**
	 * 컨테이너와 야드정보를 읽어오고 해당하는 컨테이너의 상태등을 리턴한다. 10바이트<br>
	 *
	 * @param String cntrNo
	 * @param String yardCd
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String checkContainerYard(String cntrNo, String yardCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		StringBuffer rtnValue = new StringBuffer();
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("yard_cd", yardCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOgetContainerYardRSQL(), param, velParam);
			while (dbRowset.next()) {
				//CNTR_NO, CNMV_STS_CD, CNTR_TPSZ_CD, CRNT_YD_CD, ACIAC_DIV_CD, HJS_CRE_FLG, IMDT_EXT_FLG
				rtnValue.append(dbRowset.getString("CNTR_NO")).append("|");
				rtnValue.append(dbRowset.getString("CNMV_STS_CD")).append("|");
				rtnValue.append(dbRowset.getString("CNTR_TPSZ_CD")).append("|");
				rtnValue.append(dbRowset.getString("CRNT_YD_CD")).append("|");
				rtnValue.append(dbRowset.getString("ACIAC_DIV_CD")).append("|");
				rtnValue.append(dbRowset.getString("HJS_CRE_FLG")).append("|");
				rtnValue.append(dbRowset.getString("IMDT_EXT_FLG")).append("|");
				rtnValue.append(dbRowset.getString("NEW_FLG")).append("|");
				rtnValue.append(dbRowset.getString("CNTR_EX"));
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue.toString();
	}

	/**
	 * 컨테이너와 야드정보를 읽어오고 해당하는 컨테이너의 상태등을 리턴한다. 10바이트 미만<br>
	 *
	 * @param String cntrNo
	 * @param String yardCd
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String checkContainerYardNotLike(String cntrNo, String yardCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		StringBuffer rtnValue = new StringBuffer();
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("yard_cd", yardCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOgetContainerYardNotLikeRSQL(), param, velParam);
			while (dbRowset.next()) {
				//CNTR_NO, CNMV_STS_CD, CNTR_TPSZ_CD, CRNT_YD_CD, ACIAC_DIV_CD, HJS_CRE_FLG, IMDT_EXT_FLG, CNTR_EX
				rtnValue.append(dbRowset.getString("CNTR_NO")).append("|");
				rtnValue.append(dbRowset.getString("CNMV_STS_CD")).append("|");
				rtnValue.append(dbRowset.getString("CNTR_TPSZ_CD")).append("|");
				rtnValue.append(dbRowset.getString("CRNT_YD_CD")).append("|");
				rtnValue.append(dbRowset.getString("ACIAC_DIV_CD")).append("|");
				rtnValue.append(dbRowset.getString("HJS_CRE_FLG")).append("|");
				rtnValue.append(dbRowset.getString("IMDT_EXT_FLG")).append("|");
				rtnValue.append(dbRowset.getString("NEW_FLG")).append("|");
				rtnValue.append(dbRowset.getString("CNTR_EX"));
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue.toString();
	}

	/**
	 * Combo세팅을 위한 Reson 코드 List를 생성한다<br>
	 *
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String searchReasonList() throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		StringBuffer rtnValue = new StringBuffer();
		try{
			Map<String, String> mapVO = new HashMap<String, String>();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOSearchResonListRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnValue.append(dbRowset.getString("XCH_RSN_CD")).append("|").append(dbRowset.getString("XCH_ABBR_NM")).append("|").append(dbRowset.getString("XCH_RSN_CD")).append("^");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue.toString();
	}

	/**
	 * 국가코드를 넘겨받고 서버아이디를 리턴한다<br>
	 *
	 * @param String cntCd
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String searchUserLocalCode(String cntCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cnt_cd", cntCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOSearchUserLocalCodeRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("SVR_ID");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue.toString();
	}

	/**
	 * Value, Column, Table을 Param으로 받아서 Value(rows data)를 가져옴<br>
	 *
	 * @param CtmCommonVO ctmCommonVO
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String getCodeValue(CtmCommonVO ctmCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		StringBuilder rtnValues = new StringBuilder();
		try{
			Map<String, String> mapVO = ctmCommonVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOGetCodeValueRSQL(), param, velParam);
			while (dbRowset.next()) {
				rtnValues.append(dbRowset.getString("RETURN_NM")).append("^#^");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValues.toString();
	}

	/**
	 * Value, Column, Table을 Param으로 받아서 Value가 존재하는지 Check.<br>
	 *
	 * @param CtmCommonVO ctmCommonVO
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String searchCodeExist(CtmCommonVO ctmCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = ctmCommonVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOSearchCodeExistRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("COLUMN_NM");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * 로그인한 사용자의 Country Code로 Local Code를 조회한다.<br>
	 *
	 * @param String yardCd
	 * @param String cntCd
	 * @return String
	 * @throws DAOException
	 */
	public String checkSvrCode (String yardCd, String cntCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String svrId1 = "";
		String svrId2 = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("cnt_cd", cntCd.substring(0,2));
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOSearchUserLocalCodeRSQL(), param, velParam);
			if (dbRowset.next()) {
				svrId1 = dbRowset.getString("SVR_ID");
			} else {
				svrId1 = "E";
			}

			mapVO.clear();

			mapVO.put("cnt_cd", yardCd.substring(0,2));
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOSearchUserLocalCodeRSQL(), param, velParam);
			if (dbRowset.next()) {
				svrId2 = dbRowset.getString("SVR_ID");
			} else {
				svrId2 = "E";
			}
			if (svrId1.equals(svrId2)) return "S";
			else return "E";
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * MDM_MVMT_STS 테이블에서 사용자가 입력한 Movement Status Code의 유효성을 체크한다.<br>
	 *
	 * @param String    chassisCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchChassisCd(String chassisCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("chassis_cd", chassisCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOCheckChassisCdRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("FIND");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * CGM_EQUIPMENT 테이블에서 사용자가 입력한 MG Set Code의 유효성을 체크한다.<br>
	 *
	 * @param String    mgset
	 * @return String
	 * @throws DAOException
	 */
	public String searchMGSet(String mgset) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("mgset", mgset);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOSearchMGSetRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("FIND");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}


	/**
	 * MDM_MVMT_STS 테이블에서 사용자가 입력한 Movement Status Code의 유효성을 체크한다.<br>
	 *
	 * @param String    mvmtStsCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchMvmtStsCd(String mvmtStsCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("mvmt_sts_cd", mvmtStsCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOsearchMvmtStsCdRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("FIND");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * Loc의 Location Name을 조회한다.<br>
	 *
	 * @param String    locCd
	 * @return String
	 * @throws DAOException
	 */
	public String getLocationName(String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("loc_cd", locCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOGetLocationNmRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("LOC_NM");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * Office코드로 국가코드를 조회<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String searchUserCntCode(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOSearchUserCntCodeRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("CNT_CD");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue.toString();
	}
}