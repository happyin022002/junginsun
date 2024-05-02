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
package com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.basic.ContainerMovementValidationBCImpl;
import com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.vo.CtmCommonVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration.ContainerMovementMgtDBDAOGetMaxCnmvCycNoForGateNewRSQL;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS ContainerMovementValidationDBDAO <br>
 * - OPUS-CTMCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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

	/** checkCtmBookingNo
	 * 
	 * @param bkgNo
	 * @return
	 * @throws DAOException
	 */
	public String checkCtmBookingNo(String bkgNo) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOCheckCtmBookingRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnStr.append(dbRowset.getString("BKG_NO_SPLIT")).append("||");
				rtnStr.append(dbRowset.getString("RCV_TERM_CD")).append("||");
				rtnStr.append(dbRowset.getString("POR_CD")).append("||");
				rtnStr.append(dbRowset.getString("POL_CD")).append("||");
				rtnStr.append(dbRowset.getString("BL_NO")).append("||");
				rtnStr.append(dbRowset.getString("BL_NO_TP")).append("||");
				rtnStr.append(dbRowset.getString("BL_NO_CHK")).append("||");
				rtnStr.append(dbRowset.getString("BL_TP_CD")).append("||");
				rtnStr.append(dbRowset.getString("VPS_ETD_DT")).append("||");
				rtnStr.append(dbRowset.getString("TRUNK_VVD")).append("||");
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

	/** checkCtmBookingNo
	 * 
	 * @param String CntrNo
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String checkCtmBookingContainer(String CntrNo, String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		StringBuffer rtnStr = new StringBuffer();
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("p_cntrno", CntrNo);
			mapVO.put("p_bkgno", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOsearchCtmBkgCntrListRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnStr.append(dbRowset.getString("FIND"));
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
     * @param String oscaBkgFlg
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String checkVVDCNTR(String yardCd, String vvdCd, String vvdTp, String oscaBkgFlg ) throws DAOException {
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
			mapVO.put("osca_bkg_flg", oscaBkgFlg);

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

	/** checkVVDCNTRAll
	 * 
	 * @param vvdCd
	 * @return String
	 * @throws DAOException
	 */
	public String checkVVDCNTRAll(String vvdCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnStr = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("p_vvdcd", vvdCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOCheckVVDCNTRAllRSQL(), param, velParam);
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
		StringBuffer rtnValue = new StringBuffer();
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("p_vender", vender);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOcheckServiceProviderRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue.append(dbRowset.getString("VNDR_LGL_ENG_NM")).append("|");
				rtnValue.append(dbRowset.getString("USA_EDI_CD"));
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
	 * Service Lane 존재 유무를 체크한다.<br>
	 *
	 * @param String slanCd
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String checkSlan(String slanCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("slanCd", slanCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOcheckSlanCdRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue=dbRowset.getString("VSL_SLAN_CD");
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
				//CNTR_NO, CNMV_STS_CD, CNTR_TPSZ_CD, CRNT_YD_CD, ACIAC_DIV_CD, CO_CRE_FLG, IMDT_EXT_FLG
				rtnValue.append(dbRowset.getString("CNTR_NO")).append("|");
				rtnValue.append(dbRowset.getString("CNMV_STS_CD")).append("|");
				rtnValue.append(dbRowset.getString("CNTR_TPSZ_CD")).append("|");
				rtnValue.append(dbRowset.getString("CRNT_YD_CD")).append("|");
				rtnValue.append(dbRowset.getString("ACIAC_DIV_CD")).append("|");
				rtnValue.append(dbRowset.getString("CO_CRE_FLG")).append("|");
				rtnValue.append(dbRowset.getString("IMDT_EXT_FLG")).append("|");
				rtnValue.append(dbRowset.getString("CNMV_DT")).append("|");
				rtnValue.append(dbRowset.getString("FULL_FLG"));
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
				//CNTR_NO, CNMV_STS_CD, CNTR_TPSZ_CD, CRNT_YD_CD, ACIAC_DIV_CD, CO_CRE_FLG, IMDT_EXT_FLG
				rtnValue.append(dbRowset.getString("CNTR_NO")).append("|");
				rtnValue.append(dbRowset.getString("CNMV_STS_CD")).append("|");
				rtnValue.append(dbRowset.getString("CNTR_TPSZ_CD")).append("|");
				rtnValue.append(dbRowset.getString("CRNT_YD_CD")).append("|");
				rtnValue.append(dbRowset.getString("ACIAC_DIV_CD")).append("|");
				rtnValue.append(dbRowset.getString("CO_CRE_FLG")).append("|");
				rtnValue.append(dbRowset.getString("IMDT_EXT_FLG")).append("|");
				rtnValue.append(dbRowset.getString("CNMV_DT")).append("|");
				rtnValue.append(dbRowset.getString("FULL_FLG"));
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
				//CNTR_NO, CNMV_STS_CD, CNTR_TPSZ_CD, CRNT_YD_CD, ACIAC_DIV_CD, CO_CRE_FLG, IMDT_EXT_FLG, NEW_FLG, ENTR_EX, FCNTR_FLG, LSTM_CD
				rtnValue.append(dbRowset.getString("CNTR_NO")).append("|");
				rtnValue.append(dbRowset.getString("CNMV_STS_CD")).append("|");
				rtnValue.append(dbRowset.getString("CNTR_TPSZ_CD")).append("|");
				rtnValue.append(dbRowset.getString("CRNT_YD_CD")).append("|");
				rtnValue.append(dbRowset.getString("ACIAC_DIV_CD")).append("|");
				rtnValue.append(dbRowset.getString("CO_CRE_FLG")).append("|");
				rtnValue.append(dbRowset.getString("IMDT_EXT_FLG")).append("|");
				rtnValue.append(dbRowset.getString("NEW_FLG")).append("|");
				rtnValue.append(dbRowset.getString("CNTR_EX")).append("|");
				rtnValue.append(dbRowset.getString("FCNTR_FLG")).append("|"); // 20150608
				rtnValue.append(dbRowset.getString("LSTM_CD")).append("|");	// 20160624
				rtnValue.append(dbRowset.getString("DMG_FLG"));	// 20160728
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
				//CNTR_NO, CNMV_STS_CD, CNTR_TPSZ_CD, CRNT_YD_CD, ACIAC_DIV_CD, CO_CRE_FLG, IMDT_EXT_FLG, NEW_FLG, CNTR_EX, FCNTR_FLG, LSTM_CD
				rtnValue.append(dbRowset.getString("CNTR_NO")).append("|");
				rtnValue.append(dbRowset.getString("CNMV_STS_CD")).append("|");
				rtnValue.append(dbRowset.getString("CNTR_TPSZ_CD")).append("|");
				rtnValue.append(dbRowset.getString("CRNT_YD_CD")).append("|");
				rtnValue.append(dbRowset.getString("ACIAC_DIV_CD")).append("|");
				rtnValue.append(dbRowset.getString("CO_CRE_FLG")).append("|");
				rtnValue.append(dbRowset.getString("IMDT_EXT_FLG")).append("|");
				rtnValue.append(dbRowset.getString("NEW_FLG")).append("|");
				rtnValue.append(dbRowset.getString("CNTR_EX")).append("|");
				rtnValue.append(dbRowset.getString("FCNTR_FLG")).append("|"); // 20150608
				rtnValue.append(dbRowset.getString("LSTM_CD")).append("|");	// 20160624
				rtnValue.append(dbRowset.getString("DMG_FLG"));	// 20160728
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
	 * Yard Office Code를 조회한다.<br>
	 *
	 * @param String yardCd
	 * @return String
	 * @throws DAOException
	 */
	public String checkYardOfcCode (String yardCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("yd_cd", yardCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOSearchYardOfcRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("OFC_CD");
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
	 * 로그인한 사용자의 Office Code로 Local Code를 조회한다.<br>
	 *
	 * @param String ydOfc
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String checkOfcCode (String ydOfc, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String ofc_lvl = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("ofc_cd", ofcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOSearchUserRHQRSQL(), param, velParam);
			if (dbRowset.next()) {
				ofc_lvl = dbRowset.getString("OFC_LVL");
			} else {
				ofc_lvl = "E";
			}

			mapVO.put("ofc_lvl", ofc_lvl);
			mapVO.put("yd_ofc", ydOfc);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOSearchOfcCdRSQL(), param, velParam);
			if (dbRowset.next()) {
				return "S";
			} else {
				return "E";
			}
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

	/**
	 * Office코드로 국가코드를 조회<br>
	 *
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String searchUserLocCode(String ofcCd) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOsearchUsrLocCdRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("LOC_CD");
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
	 * locCd로 Office Date 조회<br>
	 *
	 * @param String locCd
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String searchOfficeDt(String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", locCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOsearchOfficeDtRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("LOC_DT");
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
	 * cntrNo로 Max Cyce No를 조회<br>
	 *
	 * @param String cntrNo
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String searchMaxCycle(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetMaxCnmvCycNoForGateNewRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("CNMV_CYC_NO");
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
	 * cycNo로 Max Cycle Bkg를 조회<br>
	 *
	 * @param String cntrNo
	 * @param String cycNo
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String searchMaxBkg(String cntrNo, String cycNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("cyc_no", cycNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOsearchMaxBkgRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("BKG_NO");
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
	 * cntrNo로 Prev MVMT EQR Ref No를 조회<br>
	 *
	 * @param String cntrNo
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String searchPrevEqrRefNo(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOsearchPrevEqrRefNoRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("MTY_PLN_NO");
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
	 * checking EQR Ref No
	 * @param String mtyPlnNo
	 * @return String
	 * @throws DAOException
	 */
	public String checkEqrRefNo(String mtyPlnNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("mty_pln_no", mtyPlnNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOCheckEqrRefNoRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("EXIST");
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
	 * search Lstm Cd
	 * @param String cntrNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchLstmCd(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementValidationDBDAOSearchLstmCdRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("LSTM_CD");
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