/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MonthlyQuotaCreationDBDAO.java
 *@FileTitle : MonthlyQuotaCreationDBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.03.09
 *@LastModifier : 김종호
 *@LastVersion : 1.5
 * 2006-12-22 byyoo
 * 1.0 최초 생성
 * 2008.10.08 Y.S.CHOI   : searchMonthlyQuotaInfoList 메소드에 qta_tgt_cd = 'Q' 조건 추가.
 * 2009.04.01 Kim MIn Ah : CSR No.R200903270002 - 품질검토 결과조치
 * 						  searchMonthlyQuotaCheckList() - 파라미터중 year, bse_qtr_cd 제거
 * 2009.08.24 김종호
 * 1.1 Creation (new F/W 전환작업) 
 * 2009.08.27 김종호 : ESM_SAQ_0077 부분 추가
 * 2009.10.08 김종호 : 메소드 뒤에 코드 추가
 * 2009.11.12 김종호 : 메소드 주석 정리
 * 2010.03.09 김종호 : SearchMonthlyQuotaInfoList0077VO 사용
=========================================================*/
package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.saq.common.common.vo.QuotaConditionVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.basic.MonthlyQuotaCreationBCImpl;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.BaseDataFromCoaListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.BaseDataInterfaceVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.SearchMonthlyQuotaCheckListVO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.SearchMonthlyQuotaInfoList0077VO;
import com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotacreation.vo.SearchMonthlyQuotaModelLogListVO;
import com.clt.apps.opus.esm.spc.dailyforecast.basicdata.integration.BasicDataDBDAOCheckOfficeValidRSQL;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.integration.DailyForecastManageDBDAOSearchVvdCdCheckRSQL;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.integration.DailyForecastManageDBDAOSpcDlyFcastCustCSQL;
import com.clt.apps.opus.esm.spc.dailyforecast.dailyforecastmanage.vo.DlyFctInpListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * MonthlyQuotaCreationDBDAO <br>
 * - MonthlySalesQuotaManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jong-Ho Kim
 * @see MonthlyQuotaCreationBCImpl 참조
 * @since J2EE 1.6
 */
public class MonthlyQuotaCreationDBDAO extends DBDAOSupport {
	/**
	 * [ESM_SAQ_0047]을 [SEARCHLIST01] 합니다.<br>
	 * 
	 * @param quotaConditionVO
	 * @return List<SearchMonthlyQuotaCheckListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaCheckListVO> searchMonthlyQuotaCheckList0047Tab01(QuotaConditionVO quotaConditionVO) throws DAOException {
		// <SearchMonthlyQuotaCheckListVO> 형식의 파라미터만 받는 List 타입의 메소드인 searchMonthlyQuotaCheckList.
		// 이 메소드의 파라미터는 조회조건VO인 QuotaConditionVO이며 이 페이지 내에서는 앞으로 변수인 quotaConditionVO 으로 사용한다.
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaCheckListVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MonthlyQuotaCreationDBDAOSearchMonthlyQuotaCheckList0047Tab01RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaCheckListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_SAQ_0047]을 [SEARCHLIST02] 합니다.<br>
	 * 
	 * @param quotaConditionVO
	 * @return List<SearchMonthlyQuotaCheckListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaModelLogListVO> searchMonthlyQuotaModelLogList0047Tab02(QuotaConditionVO quotaConditionVO) throws DAOException {
		// <...VO> 형식의 파라미터만 받는 List 타입의 메소드인 searchMonthlyQuotaCheckList.
		// 이 메소드의 파라미터는 조회조건VO인 QuotaConditionVO이며 이 페이지 내에서는 앞으로 변수인 quotaConditionVO 으로 사용한다.
		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaModelLogListVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (quotaConditionVO != null) {
				Map<String, String> mapVO = quotaConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MonthlyQuotaCreationDBDAOSearchMonthlyQuotaModelLogList0047Tab02RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaModelLogListVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_SAQ_0077]을 [SEARCHLIST01~03] 합니다.<br>
	 * 
	 * @param quotaConditionVO
	 * @return List<SearchMonthlyQuotaCheckListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchMonthlyQuotaInfoList0077VO> searchMonthlyQuotaInfoList0077(QuotaConditionVO quotaConditionVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<SearchMonthlyQuotaInfoList0077VO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, String> mapVO = quotaConditionVO.getColumnValues();

		param.putAll(mapVO);
		velParam.putAll(mapVO);

		param.put("month", quotaConditionVO.getRepMonth());
		int month = Integer.parseInt(quotaConditionVO.getRepMonth()); // String -> int 로 변환은 타입캐스팅이 안되고 이와 같이 가능
		velParam.put("month", month);

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MonthlyQuotaCreationDBDAOSearchMonthlyQuotaInfoList0077RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchMonthlyQuotaInfoList0077VO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_SAQ_0077]의 [COMMAND01]를 위해 Search 합니다.<br>
	 * 화면과 무관하므로 메소드 뒤에 코드를 붙이지 않음.
	 * 
	 * @param year
	 * @param bseQtrCd
	 * @return
	 * @throws DAOException
	 */
	public QuotaConditionVO searchSaqMonthlyModelResultStatusList(String year, String bseQtrCd) throws DAOException {
		// 리턴타입을 QuotaConditionVO로 하는 것은 이 컨디션VO에 결과값을 담아서 BCImpl에서 사용하는 분기문의 조건에 사용하기 위함이다.
		// 원래 이 메소드의 결과값은 str 하나인데 리턴값을 VO로 넘기라는 권고에 의해, 리턴타입을 String으로 하지 않고 SAQ공용 조건VO에 추가.

		DBRowSet dbRowset = null;
		// List<QuotaConditionVO> list = null;
		// 리턴값이 리스트가 아닌 단건이기 때문에 위의 리스트 대신 아래 방식을 사용
		QuotaConditionVO resultVO = new QuotaConditionVO();

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String str = ""; //소스 품질 수정 요청건

		param.put("year", year);
		param.put("bseQtrCd", bseQtrCd);

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MonthlyQuotaCreationDBDAOSearchSaqMonthlyModelResultStatusListRSQL(), param, velParam);
			// DBRowSet 이란 한진 프레임 웍에서 만든, java의 ResultSet 형식의 데이터 셋으로
			// 로우와 컬럼으로 이뤄져있지만 인덱스가 없는 목록으로서 검색이 불가능하고 순차적인 접근만 가능한 타입.
			// 따라서 DBRowSet 에서 데이터를 접근하려면 그 다음 로우가 있는지 없는지 확인을 하는 메소드를 통해
			// 반복문을 사용하여 각 로우의 원하는 컬럼의 데이터를 추출해와야함.
			while (dbRowset.next()) // dbRowset의 next()메소드는 다음 로우가 있는지 확인을 통해 boolean 타입의 리턴값을 반환하므로
									// false가 될 때까지 while문이 순환.
			{
				str = dbRowset.getString("tgt_vvd_sts_cd");
			}
			// dbRowset에서 각 로우마다 원하는 컬럼의 데이터를 가져올 때는 varchar2등의 string 타입의 경우 getString 메소드를,int의 경우 getInt 메소드를 사용.
			// getString 메소드는 두 가지 사용방법이 있어서, 원하는 컬럼명을 사용하여 데이터를 추출할 수 있고, 원하는 컬럼의 번호를 대입하여 (좌측부터 0부터 시작)사용할 수도 있음
			// 따라서 select 쿼리가 반환한 결과값에 컬럼이 하나 밖에 없는 위와 같은 경우 {str = dbRowset.getString(0);} 으로 사용해도 같은 결과가 산출됨.

			// list = (List)RowSetUtil.rowSetToVOs(dbRowset, QuotaConditionVO.class);
			// 리스트의 경우 DBRowSet에서 가져온 데이터를 VO로 하나씩 받아서 VO[]배열로 묶어서 만들게 되는데, 이때 사용하는 메소드가 RowSetUtil의 rowSetToVOs 이다.
			// 아큐먼트의 경우 (dbRowset, 변경을 원하는 VO.class) 를 사용한다.
			// 단건이기 때문에 list를 사용하지 않았기 때문에 위의 rowSetToVOs 메소드 대신 아래와 같이 원하는 VO에 값을 세팅만 해서 사용한다.
			resultVO.setStr(str);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultVO; // list를 사용한 경우 리턴값이 list겠지만 단건이기 때문에 resultVO를 사용.
	}

	/**
	 * [ESM_SAQ_0077] 정보를 [COMMAND01] 합니다.<br>
	 * final version을 update
	 * 
	 * @param year
	 * @param bseQtrCd
	 * @param version
	 * @param userId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void confirmMonthlyQuotaFinalVersion0077(String year, String bseQtrCd, String version, String userId) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			param.put("year", year);
			param.put("bseQtrCd", bseQtrCd);
			param.put("version", version);
			param.put("userId", userId);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new MonthlyQuotaCreationDBDAOConfirmMonthlyQuotaFinalVersion0077USQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_SAQ_0077] 정보를 [COMMAND01] 합니다.<br>
	 * guideline data 생성 (1.version)
	 * 
	 * @param version
	 * @param userId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createMonthlyQuotaGuidelineInfoVer0077(String version, String userId) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			param.put("version", version);
			param.put("userId", userId);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new MonthlyQuotaCreationDBDAOCreateMonthlyQuotaGuidelineInfoVer0077CSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_SAQ_0077] 정보를 [COMMAND01] 합니다.<br>
	 * guideline data 생성 (2.trade)
	 * 
	 * @param version
	 * @param userId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createMonthlyQuotaGuidelineInfoTrd0077(String version, String userId) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			param.put("version", version);
			param.put("userId", userId);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new MonthlyQuotaCreationDBDAOCreateMonthlyQuotaGuidelineInfoTrd0077CSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_SAQ_0077] 정보를 [COMMAND01] 합니다.<br>
	 * guideline data 생성 (3. sub trade )
	 * 
	 * @param version
	 * @param userId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createMonthlyQuotaGuidelineInfoSub0077(String version, String userId) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			param.put("version", version);
			param.put("userId", userId);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new MonthlyQuotaCreationDBDAOCreateMonthlyQuotaGuidelineInfoSub0077CSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESM_SAQ_0178 : 기 존재하는 COA interface data 를 삭제한다.
	 * 
	 * @param baseDataFromCoaListVO
	 * @throws DAOException
	 */
	public void deleteCoaInterfaceList(BaseDataFromCoaListVO baseDataFromCoaListVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (baseDataFromCoaListVO != null) {
				Map<String, String> mapVO = baseDataFromCoaListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new MonthlyQuotaCreationDBDAODeleteCoaInterfaceListDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESM_SAQ_0178 : COA interface data 를 생성한다.
	 * 
	 * @param baseDataFromCoaListVO
	 * @throws DAOException
	 */
	public void createCoaInterfaceList(BaseDataFromCoaListVO baseDataFromCoaListVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			List<String> slctYrmon = new ArrayList();
			String[] slctYrmons = baseDataFromCoaListVO.getSlctYrmon().split(",");

			for (int i = 0; i < slctYrmons.length; i++) {
				slctYrmon.add(slctYrmons[i]);
			}

			List<String> qtrYrmon = new ArrayList();
			String[] qtrYrmons = baseDataFromCoaListVO.getHMonths().split(",");

			for (int i = 0; i < qtrYrmons.length; i++) {
				qtrYrmon.add(baseDataFromCoaListVO.getYear() + qtrYrmons[i]);
			}

			if (baseDataFromCoaListVO != null) {
				Map<String, String> mapVO = baseDataFromCoaListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("slct_yrmon", slctYrmon);
				velParam.put("qtr_yrmon", qtrYrmon);
			}

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new MonthlyQuotaCreationDBDAOCreateCoaInterfaceListCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESM_SAQ_0078 : COA interface data 를 조회한다.
	 * 
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws DAOException
	 */
	public List<BaseDataInterfaceVO> searchInterfaceList(BaseDataInterfaceVO baseDataInterfaceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BaseDataInterfaceVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (baseDataInterfaceVO != null) {
				Map<String, String> mapVO = baseDataInterfaceVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MonthlyQuotaCreationDBDAOSearchInterfaceListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BaseDataInterfaceVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * ESM_SAQ_0179 : Contract Office Verify data 를 조회한다.
	 * 
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws DAOException
	 */
	public List<BaseDataInterfaceVO> searchCOfcVerify(BaseDataInterfaceVO baseDataInterfaceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BaseDataInterfaceVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (baseDataInterfaceVO != null) {

				Map<String, String> mapVO = baseDataInterfaceVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MonthlyQuotaCreationDBDAOSearchCOfcVerifyRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BaseDataInterfaceVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * ESM_SAQ_0179 : Loading Office Verify data 를 조회한다.
	 * 
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws DAOException
	 */
	public List<BaseDataInterfaceVO> searchLOfcVerify(BaseDataInterfaceVO baseDataInterfaceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BaseDataInterfaceVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (baseDataInterfaceVO != null) {
				Map<String, String> mapVO = baseDataInterfaceVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MonthlyQuotaCreationDBDAOSearchLOfcVerifyRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BaseDataInterfaceVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * ESM_SAQ_0179 : Check Office Validation
	 * 
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws DAOException
	 */
	public String checkOfficeValid(BaseDataInterfaceVO baseDataInterfaceVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtn = "N";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (baseDataInterfaceVO != null) {
				Map<String, String> mapVO = baseDataInterfaceVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MonthlyQuotaCreationDBDAOCheckOfficeValidRSQL(), param, velParam);
			if(dbRowset != null){
				 if(dbRowset.next()){
					 String ofc = dbRowset.getString(1);
					 if(!"".equals(ofc)){
						 rtn = "Y";
					 }
				 }
			 }
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}	
	
	/**
	 * ESM_SAQ_0179 : Office 정보를 수정한다.<br> 
	 * 
	 * @param uptModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int updateOfcVerify(List<BaseDataInterfaceVO> uptModels) throws DAOException, Exception {
		int insCnt = 0;		
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");		
			
			if(uptModels.size() > 0){
				for (int i = 0; i < uptModels.size(); i++) {
					Map<String, String> mapVO = uptModels.get(i).getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);					
					
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaCreationDBDAOupdateOfcVerifyUSQL(), param, velParam);
					if(insCnt == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert SQL");		
					}
					insCnt++;
				}
			}				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * ESM_SAQ_0179 : Office 정보를 삭제한다.<br> 
	 * 
	 * @param delModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int deleteOfcVerify(List<BaseDataInterfaceVO> delModels) throws DAOException, Exception {
		int delCnt = 0;		
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");			
			
			if(delModels.size() > 0){
				for (int i = 0; i < delModels.size(); i++) {
					Map<String, String> mapVO = delModels.get(i).getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					delCnt = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaCreationDBDAODeleteOfcVerifyDSQL(), param, velParam);
					if(delCnt == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to delete SQL");		
					}
					delCnt++;
				}
			}	
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	
	/**
	 * ESM_SAQ_0179 : RPB CPB를 재 계산한다.<br> 
	 * 
	 * @param uptModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int updateReCalRpbCpb(List<BaseDataInterfaceVO> uptModels) throws DAOException, Exception {
		int insCnt = 0;		
		//query parameter ,String usrId
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");			
			
			if(uptModels.size() > 0){
				for (int i = 0; i < uptModels.size(); i++) {
					Map<String, String> mapVO = uptModels.get(i).getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new MonthlyQuotaCreationDBDAOUpdateReCalRpbCpbUSQL(), param, velParam);
					if(insCnt == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert SQL");		
					}
					insCnt++;
				}
			}				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * ESM_SAQ_0078 : Base Data Preparation Confirm Check<br> 
	 * 
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public String checkConfirmFlg(BaseDataInterfaceVO baseDataInterfaceVO) throws DAOException, Exception {		
		DBRowSet dbRowset = null;
		String retval = "";
		
		try {			
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
			
			if (baseDataInterfaceVO != null) {	
				Map<String, String> mapVO = baseDataInterfaceVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);			
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MonthlyQuotaCreationDBDAOCheckConfirmFlgRSQL(), param, velParam);

				if (dbRowset.next()) {
					retval = dbRowset.getString("CNF_YN");
				}
			}				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
		return retval;
	}
	
	/**
	 * ESM_SAQ_0078 : Base Data Preparation Confirm<br> 
	 * 
	 * @param baseDataInterfaceVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateConfirm(BaseDataInterfaceVO baseDataInterfaceVO) throws DAOException, Exception {		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
			
			if (baseDataInterfaceVO != null) {	
				Map<String, String> mapVO = baseDataInterfaceVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);			
				
				int result = sqlExe.executeUpdate((ISQLTemplate) new MonthlyQuotaCreationDBDAOUpdateConfirmUSQL(), param, velParam);

				if (result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to Confirm SQL");
				}
			}				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * ESM_SAQ_0078 : Base Data Preparation Cancel Confirmation<br> 
	 * 
	 * @param baseDataInterfaceVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateCancel(BaseDataInterfaceVO baseDataInterfaceVO) throws DAOException, Exception {		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
			
			if (baseDataInterfaceVO != null) {	
				Map<String, String> mapVO = baseDataInterfaceVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);							
				
				
				int result = sqlExe.executeUpdate((ISQLTemplate) new MonthlyQuotaCreationDBDAOUpdateCancelUSQL(), param, velParam);

				if (result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to Cancel SQL");
				}
			}				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * ESM_SAQ_0078 : Base Data Preparation Notify 
	 * @param baseDataInterfaceVO BaseDataInterfaceVO  
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateNotify(BaseDataInterfaceVO baseDataInterfaceVO) throws DAOException, Exception {		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
			
			if (baseDataInterfaceVO != null) {	
				Map<String, String> mapVO = baseDataInterfaceVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);			
				
				int result = sqlExe.executeUpdate((ISQLTemplate) new MonthlyQuotaCreationDBDAOUpdateNotifyUSQL(), param, velParam);

				if (result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to Notify SQL");
				}
			}				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * ESM_SAQ_0078 : Base Data Preparation Notify check<br> 
	 * 
	 * @param baseDataInterfaceVO BaseDataInterfaceVO
	 *            
	 * @return String
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchNotifyCheck(BaseDataInterfaceVO baseDataInterfaceVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String retval = "";

		try {
			if (baseDataInterfaceVO != null) {
				Map<String, String> mapVO = baseDataInterfaceVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MonthlyQuotaCreationDBDAOSearchNotifyCheckRSQL(), param, velParam);

			if (dbRowset.next()) {
				retval = dbRowset.getString("CHK_TXT");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retval;
	}

	/**
	 * ESM_SAQ_0184 : Office Adjust data 를 조회한다.
	 * 
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws DAOException
	 */
	public List<BaseDataInterfaceVO> searchOfcAdjust(BaseDataInterfaceVO baseDataInterfaceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BaseDataInterfaceVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (baseDataInterfaceVO != null) {
				Map<String, String> mapVO = baseDataInterfaceVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MonthlyQuotaCreationDBDAOSearchOfcAdjustRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BaseDataInterfaceVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESM_SAQ_0184 : Office Adjust 정보를 입력한다.<br> 
	 * 
	 * @param uptModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] createOfcAdjust(List<BaseDataInterfaceVO> uptModels) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
			
			if (uptModels.size() > 0) {	
				Map<String, String> mapVO= uptModels.get(0).getColumnValues();
				velParam.putAll(mapVO);			
				
				insCnt = sqlExe.executeBatch((ISQLTemplate) new MonthlyQuotaCreationDBDAOCreateOfcAdjustCSQL(), uptModels, velParam);

				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Adjust Office No " + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * ESM_SAQ_0184 : Office Adjust 정보를 수정한다.<br> 
	 * 
	 * @param uptModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] updateOfcAdjust(List<BaseDataInterfaceVO> uptModels) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
			
			if (uptModels.size() > 0) {	
				Map<String, String> mapVO= uptModels.get(0).getColumnValues();
				velParam.putAll(mapVO);			
				
				insCnt = sqlExe.executeBatch((ISQLTemplate) new MonthlyQuotaCreationDBDAOUpdateOfcAdjustUSQL(), uptModels, velParam);

				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Adjust Office No " + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * ESM_SAQ_0184 : Office Adjust 정보를 삭제한다. 
	 * @param delModels List<BaseDataInterfaceVO> 
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] deleteOfcAdjust(List<BaseDataInterfaceVO> delModels) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
			
			if (delModels.size() > 0) {	
				Map<String, String> mapVO= delModels.get(0).getColumnValues();
				velParam.putAll(mapVO);			
				
				insCnt = sqlExe.executeBatch((ISQLTemplate) new MonthlyQuotaCreationDBDAODeleteOfcAdjustDSQL(), delModels, velParam);

				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Adjust Office No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * ESM_SAQ_0181 : Lane Adjust data 를 조회한다.
	 * 
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws DAOException
	 */
	public List<BaseDataInterfaceVO> searchLaneAdjust(BaseDataInterfaceVO baseDataInterfaceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BaseDataInterfaceVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (baseDataInterfaceVO != null) {
				Map<String, String> mapVO = baseDataInterfaceVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MonthlyQuotaCreationDBDAOSearchLaneAdjustRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BaseDataInterfaceVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * ESM_SAQ_0181 : Lane Adjust 정보를 생성한다.<br> 
	 * 
	 * @param uptModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] createLaneAdjust(List<BaseDataInterfaceVO> uptModels) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
			
			if (uptModels.size() > 0) {	
				Map<String, String> mapVO= uptModels.get(0).getColumnValues();
				velParam.putAll(mapVO);			
				
				insCnt = sqlExe.executeBatch((ISQLTemplate) new MonthlyQuotaCreationDBDAOCreateLaneAdjustCSQL(), uptModels, velParam);

				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Create Lane Adjust" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * ESM_SAQ_0181 : Lane Adjust 정보를 수정한다.<br> 
	 * 
	 * @param uptModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] updateLaneAdjust(List<BaseDataInterfaceVO> uptModels) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
			
			if (uptModels.size() > 0) {	
				Map<String, String> mapVO= uptModels.get(0).getColumnValues();
				velParam.putAll(mapVO);			
				
				insCnt = sqlExe.executeBatch((ISQLTemplate) new MonthlyQuotaCreationDBDAOUpdateLaneAdjustUSQL(), uptModels, velParam);

				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update Lane Adjust" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * ESM_SAQ_0181 : Lane Adjust 정보를 삭제한다. 
	 * @param delModels List<BaseDataInterfaceVO> 
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] deleteLaneAdjust(List<BaseDataInterfaceVO> delModels) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
			
			if (delModels.size() > 0) {	
				Map<String, String> mapVO= delModels.get(0).getColumnValues();
				velParam.putAll(mapVO);			
				
				insCnt = sqlExe.executeBatch((ISQLTemplate) new MonthlyQuotaCreationDBDAODeleteLaneAdjustDSQL(), delModels, velParam);

				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Adjust Lane No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * ESM_SAQ_0183 : CPB Adjust data 를 조회한다.
	 * 
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws DAOException
	 */
	public List<BaseDataInterfaceVO> searchCPBAdjust(BaseDataInterfaceVO baseDataInterfaceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BaseDataInterfaceVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (baseDataInterfaceVO != null) {
				Map<String, String> mapVO = baseDataInterfaceVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MonthlyQuotaCreationDBDAOSearchCPBAdjustRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BaseDataInterfaceVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * ESM_SAQ_0181 : CPB Adjust 정보를 수정한다.<br> 
	 * 
	 * @param uptModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] updateCPBAdjust(List<BaseDataInterfaceVO> uptModels) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
			
			if (uptModels.size() > 0) {	
				Map<String, String> mapVO= uptModels.get(0).getColumnValues();
				velParam.putAll(mapVO);			
				
				insCnt = sqlExe.executeBatch((ISQLTemplate) new MonthlyQuotaCreationDBDAOUpdateCPBAdjustUSQL(), uptModels, velParam);

				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Adjust Lane No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * ESM_SAQ_0181 : Lane Adjust 정보를 삭제한다. 
	 * @param delModels List<BaseDataInterfaceVO> 
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] deleteCPBAdjust(List<BaseDataInterfaceVO> delModels) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
			
			if (delModels.size() > 0) {	
				Map<String, String> mapVO= delModels.get(0).getColumnValues();
				velParam.putAll(mapVO);			
				
				insCnt = sqlExe.executeBatch((ISQLTemplate) new MonthlyQuotaCreationDBDAODeleteCPBAdjustDSQL(), delModels, velParam);

				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Adjust Lane No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * ESM_SAQ_0182 : Guideline Initial Data 를 조회한다.
	 * 
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws DAOException
	 */
	public List<BaseDataInterfaceVO> searchGuidelineInitList(BaseDataInterfaceVO baseDataInterfaceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BaseDataInterfaceVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (baseDataInterfaceVO != null) {
				Map<String, String> mapVO = baseDataInterfaceVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MonthlyQuotaCreationDBDAOSearchGuidelineInitListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BaseDataInterfaceVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	

	/**
	 * ESM_SAQ_0182 : Guideline data 를 조회한다.
	 * 
	 * @param baseDataInterfaceVO
	 * @return
	 * @throws DAOException
	 */
	public List<BaseDataInterfaceVO> searchGuidelineList(BaseDataInterfaceVO baseDataInterfaceVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BaseDataInterfaceVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (baseDataInterfaceVO != null) {
				Map<String, String> mapVO = baseDataInterfaceVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new MonthlyQuotaCreationDBDAOSearchGuidelineListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BaseDataInterfaceVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESM_SAQ_0182 : Guideline Data 를 수정한다.<br> 
	 * 
	 * @param uptModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] updateGuideline(List<BaseDataInterfaceVO> uptModels) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
			
			if (uptModels.size() > 0) {	
				Map<String, String> mapVO= uptModels.get(0).getColumnValues();
				velParam.putAll(mapVO);			
				
				insCnt = sqlExe.executeBatch((ISQLTemplate) new MonthlyQuotaCreationDBDAOUpdateGuidelineUSQL(), uptModels, velParam);

				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update Guideline No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 * ESM_SAQ_0182 : Guideline Init Data 를 삭제한다..<br> 
	 * 
	 * @param baseDataInterfaceVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void deleteGuidelineInit(BaseDataInterfaceVO baseDataInterfaceVO) throws DAOException, Exception {		
		try {			
			SQLExecuter sqlExe = new SQLExecuter("");
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
			
			if (baseDataInterfaceVO != null) {	
				Map<String, String> mapVO = baseDataInterfaceVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);			
				
				int result = sqlExe.executeUpdate((ISQLTemplate) new MonthlyQuotaCreationDBDAODeleteGuidelineInitDSQL(), param, velParam);

				if (result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to Delete Guideline Init SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * ESM_SAQ_0182 : Guideline Init Data 를 생성한다.<br> 
	 * 
	 * @param baseDataInterfaceVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createGuidelineInit(BaseDataInterfaceVO baseDataInterfaceVO) throws DAOException, Exception {		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
			
			if (baseDataInterfaceVO != null) {	
				Map<String, String> mapVO = baseDataInterfaceVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);			
				
				int result = sqlExe.executeUpdate((ISQLTemplate) new MonthlyQuotaCreationDBDAOCreateGuidelineInitCSQL(), param, velParam);

				if (result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to Create Guideline Init SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * ESM_SAQ_0182 : Guideline L/F, CM 을 Fcast_Trans 테이블에 반영한다.<br> 
	 * 
	 * @param baseDataInterfaceVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateFcastTrans(BaseDataInterfaceVO baseDataInterfaceVO) throws DAOException, Exception {		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
			
			if (baseDataInterfaceVO != null) {	
				Map<String, String> mapVO = baseDataInterfaceVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);			
				
				int result = sqlExe.executeUpdate((ISQLTemplate) new MonthlyQuotaCreationDBDAOUpdateFcastTransUSQL(), param, velParam);

				if (result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to Update Fcast_Trans SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * ESM_SAQ_0182 : Guide line Confirm 
	 * @param baseDataInterfaceVO BaseDataInterfaceVO  
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateGuidelineConfirm(BaseDataInterfaceVO baseDataInterfaceVO) throws DAOException, Exception {		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
			
			if (baseDataInterfaceVO != null) {	
				Map<String, String> mapVO = baseDataInterfaceVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);			
				
				int result = sqlExe.executeUpdate((ISQLTemplate) new MonthlyQuotaCreationDBDAOUpdateGuidelineConfirmUSQL(), param, velParam);

				if (result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to Confirm SQL");
				}
			}				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * ESM_SAQ_0182 : Guide line Cancel Confirmation 
	 * @param baseDataInterfaceVO BaseDataInterfaceVO  
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateGuidelineCancelConfirm(BaseDataInterfaceVO baseDataInterfaceVO) throws DAOException, Exception {		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
			
			if (baseDataInterfaceVO != null) {	
				Map<String, String> mapVO = baseDataInterfaceVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);			
				
				int result = sqlExe.executeUpdate((ISQLTemplate) new MonthlyQuotaCreationDBDAOUpdateGuidelineCancelConfirmUSQL(), param, velParam);

				if (result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to Confirm SQL");
				}
			}				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * ESM_SAQ_0182 : Guide line Notify 
	 * @param baseDataInterfaceVO BaseDataInterfaceVO  
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateGuidelineNotify(BaseDataInterfaceVO baseDataInterfaceVO) throws DAOException, Exception {		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
			
			if (baseDataInterfaceVO != null) {	
				Map<String, String> mapVO = baseDataInterfaceVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);			
				
				int result = sqlExe.executeUpdate((ISQLTemplate) new MonthlyQuotaCreationDBDAOUpdateGuidelineNotifyUSQL(), param, velParam);

				if (result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to Confirm SQL");
				}
			}				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * ESM_SAQ_0182 : Guide line Cancel Notification 
	 * @param baseDataInterfaceVO BaseDataInterfaceVO 
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateGuidelineCancelNotify(BaseDataInterfaceVO baseDataInterfaceVO) throws DAOException, Exception {		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	
			
			if (baseDataInterfaceVO != null) {	
				Map<String, String> mapVO = baseDataInterfaceVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);			
				
				int result = sqlExe.executeUpdate((ISQLTemplate) new MonthlyQuotaCreationDBDAOUpdateGuidelineCancelNotifyUSQL(), param, velParam);

				if (result == Statement.EXECUTE_FAILED){
					throw new DAOException("Fail to Confirm SQL");
				}
			}				
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}

}