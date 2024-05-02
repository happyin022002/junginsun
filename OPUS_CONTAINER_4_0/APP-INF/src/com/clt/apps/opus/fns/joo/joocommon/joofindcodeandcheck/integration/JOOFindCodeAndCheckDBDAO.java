/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : JOOFindCodeAndCheckDBDAO.java
 *@FileTitle : 공통
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.07
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2009.05.07 박희동
 * 1.0 Creation
* ----------------------------------------------------------
* History
* 2010.11.08 이준범 [CHM-201006731-01]
* 1. 대상 기능
*   - JO Member Information Creation(JOO_0066)
*   - Inquiry of JO Member Information(JOO_0067)
* 2. 보완 대상
*   - Revenue Lane 정보 반영 
*   - MS Office( Excel, Worl, Power Point등) 첨부
*   - Carrier Name등 컬럼 반영
* 3. 목 적
*   - 그동안 Excel로 관리되던  선사별 이력 관리를 시스템내에서 관리하도록 하며
*   - Pending 사항에 대한 등록을 통해 선사별  Pending 사항이 간과 , 누락되지 않도록 함
=========================================================*/
package com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration.JOOFindCodeAndCheckDBDAOSearchAuthOfficeListRSQL;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.basic.JOOFindCodeAndCheckBCImpl;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooComActualCarrierVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooComCodeVO;
import com.clt.apps.opus.fns.joo.joocommon.joofindcodeandcheck.vo.JooComRlaneVO;
import com.clt.apps.opus.fns.joo.joocommonutil.BizComJooUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS JOOFindCodeAndCheckDBDAO <br>
 * - OPUS-JOOCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Park Hee Dong
 * @see JOOFindCodeAndCheckBCImpl 참조
 * @since J2EE 1.4
 */
public class JOOFindCodeAndCheckDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * MDM TRADE CODE를 조회한다.
	 * 조회조건 : code = trade 코드 (optional) 
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchMdmTrdCdList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOMdmTradeRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * MDM Revenue Lane을 조회한다.
	 * 조회조건 
	 * - super_cd1 : 대표Trade코드
	 * - code : Lane코드 
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchMdmRlaneCdList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAORLaneRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * Common Code 조회 (com_intg_cd_dtl)
	 * 조회조건
	 *  - super_cd1 : 그룹코드(intg_cd_id) - mandatory
	 *  - code : 코드(intg_cd_val_ctnt) - optional
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchComCodeList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOCommonCodeRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * Key-in으로 customer code를 입력했을 경우 validation check 및 Customer 명을 조회한다.
	 * 조회조건 
	 *  - code : cust_cnt_cd, cust_seq를 붙여서 넘기고 substring으로 잘라서 사용 - mandatory
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchCustomerList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOCustomerRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * Key-in으로 Vendor code를 입력했을 경우 올바른 Vendor코드인지 validation check 및 Vendor명을 조회하여 return한다.
	 * 조회조건
	 *  - code : vendor code - optional
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchVendorList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOVendorRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * 공동운항에서 사용하는 Trade 코드 List를 조회한다. 
	 * 조회조건
	 *  - super_cd1 : Carrier (optional)
	 *  - code : trade code
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchTradeCodeList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 List<String> superCdsList = new ArrayList<String>();
				 superCdsList = BizComJooUtil.getSeperationParameterList(jooCodeParamVO.getSuperCds1(), ",");
				 if(superCdsList != null && superCdsList.size() > 0){
					 param.put("super_cds1"		, superCdsList);
					 velParam.put("super_cds1"	, superCdsList);
				 }else{
					 param.put("super_cds1"		, "");
					 velParam.put("super_cds1"	, "");
				 }
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOTradeRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * 공동운항에서 사용하는 Lane 코드리스트를 조회한다.
	 * 조회조건 
	 *  - super_cd1 : Carrier code (optional)
	 *  - super_cd2 : Trade code (optional)
	 *  - code : Lane code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchRLaneCodeList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			
				//Lane Code 3자리만 잘라서 가져오기 
				String gb = jooCodeParamVO.getName()==null?"":jooCodeParamVO.getName();
				 if( !"FOR_3CODE".equals(gb)){
				     dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOJooLaneRSQL(), param, velParam);
				 }else{
	                 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOJooLanebyThreeCodeRSQL(), param, velParam);			     
				 }
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
			}
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
	 * 공동운항에서 사용하는 TRADE와 LANE을 중복되지 않게 LIST 조회한다.
	 * 조회조건 : 없음
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchRLaneCodeListByTrade(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOJooLaneByTrdRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * 공동운항에서만 사용하는 Carrier Code 조회
	 * 조회조건 
	 *  - super_cd1 : trade code (optional)
	 *  - super_cd2 : rlane code (optional)
	 *  - code : carrier code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchCarrierCodeList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOCarrierRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * Vessel schedule에서 VVD Validation Check한다.
	 * 조회조건 
	 *  - code : Vessel Code, Voyage Number, Direction을 concat해서 substring으로 잘라서 사용한다. (mandatory)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> checkVVD(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOCheckVVDRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * KEY-IN 한 Account Item을 MDM_ACCOUNT에서 해당 account item의 validation 을 check한다.
	 * 조회조건 
	 *  - code : account item 코드(optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchItemAcctList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOCheckAccountRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * Settlement Account Code List를 조회한다. (joo_stl_itm)
	 * 조회조건
	 *  - super_cd1 : jo_auto_cre_flg (optional)
	 *  - super_cd2 : jo_mnl_cre_flg (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchStlItemCodeList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOAbbrRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * Carrier, Lane코드, VVD에 해당하는 Basic Port의 1,2,3 Basic Port list와 ETA, ETD list를 조회한다.
	 * 조회조건 
	 *  - super_cd1 : lane code
	 *  - super_cd2 : VVD (9자리)
	 *  - code : carrier code
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchRevDirBasicPortList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOBasicPortRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * Carrier, Lane코드, VVD에 해당하는 Basic Port의 1,2,3 Pair Port list와 ETA, ETD list를 조회한다.
	 * 조회조건 
	 *  - super_cd1 : lane code
	 *  - super_cd2 : VVD (9자리)
	 *  - code : carrier code
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchPairPortList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOPairPortRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * Lane코드와 VVD를 조회조건으로 Unit Cost Port를 Vessel Port Schedule에서 읽어온다.
	 * 조회조건
	 *  - super_cd1 : lane code - mandatory
	 *  - super_cd2 : VVD (9자리) - mandatory
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchUnitCostPortList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOUnitCostPortRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * Vessel Port Schedule 에서 Rlane 변경시 ETA 일자가 100일전 이후 인 Port list를 조회한다.
	 * 조회조건
	 *  - super_cd1 : lane code 
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchPortListByLane(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOPortByLaneRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * VSK_CARRIER 를 조회
	 * 조회조건
	 *  - code : Carrier code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchVskCarrierList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOVskCarrierRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * AP_WORKPLACE 에서 Office Code와 name을 조회한다.
	 * 조회조건 : 없음
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchTaxOfcList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOOfficeCodeRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * Settlement의 OUS RDR, OUS TDR, Reefer에서 적용할 Lane, RTU, Currency를 조회한다.
	 * 조회조건
	 *  - super_cd1 : Carrier (mandatory)
	 *  - super_cd2 : Trade  (mandatory)
	 *  - code : 정산 ITEM (mandatory)
	 *  - name : 용,대선 구분(re_divr_cd) (mandatory)  
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchRLaneRTUList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAORlaneRTURSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * Trade변경시 Rlane과 Financial Matrix의 Currency를 가져온다.
	 * OUS RDR, TDR, Reefer를 제외한 Settlement에서 사용한다.
	 * 조회조건
	 *  - super_cd1 : Carrier (mandatory)
	 *  - super_cd2 : Trade  (mandatory)
	 *  - code : 정산 ITEM (mandatory)
	 *  - name : 용,대선 구분(re_divr_cd) (mandatory)  
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchRLaneCurrList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAORlaneCurrRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * JOO_STL_CMB 에서 Combined No를 조회한다.
	 * 조회조건
	 *  - super_cd1 : Account Month (ACCT_YRMON)
	 *  - super_cd2 : Carrier Code (JO_CRR_CD)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchCombinedNoList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOStlCmbSeqRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
     * JOO_STL_ITM 조회 합니다.<br>
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO>
     * @throws DAOException
     * @author jang kang cheol
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<JooCodeInfoVO> searchSettlementItemCodeList(JooCodeParamVO jooCodeParamVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<JooCodeInfoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (jooCodeParamVO != null) {
                 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

                 param.putAll(mapVO);
                 velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOSearchSettlementItemCodeListRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
     * 시행월의 마감여부를 체크한다.
     * @param JooCodeParamVO jooCodeParamVO
     * @return JooCodeInfoVO
     * @throws DAOException
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public JooCodeInfoVO searchCheckEstmClz(JooCodeParamVO jooCodeParamVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<JooCodeInfoVO> list = null;
        JooCodeInfoVO jooCodeInfoVO = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (jooCodeParamVO != null) {
                 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

                 param.putAll(mapVO);
                 velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOCheckEstmClzRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
            
            
            if (list.isEmpty()){
            	jooCodeInfoVO = new JooCodeInfoVO();
            	jooCodeInfoVO.setCode("N");
            }else{
            	jooCodeInfoVO = (JooCodeInfoVO)list.get(0);
            }
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return jooCodeInfoVO;
    }


	/**
	 * 공동운항에서만 사용하는 Carrier Code 조회
	 * 조회조건 
	 *  - super_cd2 : trade code (optional)
	 *  - super_cd1 : rlane code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchCarrierCodeListByTradeAndRlane(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOCarrierByTradeAndLaneRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * 추정테이블에서 REV_YRMON From~ TO를 조회한다
	 * @param EstmConditionVO estmConditionVO
	 * @return List<EstmConditionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EstmConditionVO> searchRevYrmonFrTo(EstmConditionVO estmConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmConditionVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (estmConditionVO != null) {
				 Map<String, String> mapVO = estmConditionVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOEstmRevYrmonRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EstmConditionVO.class);
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
	 * 추정테이블에서 TRADE코드를 조회합니다.
	 * @param EstmConditionVO estmConditionVO
	 * @return List<EstmConditionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EstmConditionVO> searchTradeCodeListEstm(EstmConditionVO estmConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmConditionVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (estmConditionVO != null) {
				 Map<String, String> mapVO = estmConditionVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOEstmTradeRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EstmConditionVO.class);
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
	 * 추정테이블에서 RLANE코드를 조회합니다.
	 * @param EstmConditionVO estmConditionVO
	 * @return List<EstmConditionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EstmConditionVO> searchRlaneCodeListEstm(EstmConditionVO estmConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmConditionVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (estmConditionVO != null) {
				 Map<String, String> mapVO = estmConditionVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOEstmRlaneRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EstmConditionVO.class);
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
	 * 추정테이블에서 CARRIER코드를 조회합니다.
	 * @param EstmConditionVO estmConditionVO
	 * @return List<EstmConditionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EstmConditionVO> searchCarrierCodeListEstm(EstmConditionVO estmConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmConditionVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (estmConditionVO != null) {
				 Map<String, String> mapVO = estmConditionVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOEstmCarrierRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EstmConditionVO.class);
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
     * 공동운항에서 사용하는 MDM_VSL_SVC_LANE Rlane 코드리스트를 조회한다.
     * 조회조건 
     *  - code : Lane code (optional)
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO>
     * @throws DAOException
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<JooCodeInfoVO> searchSvcRlaneCodeList(JooCodeParamVO jooCodeParamVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<JooCodeInfoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (jooCodeParamVO != null) {
                 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

                 param.putAll(mapVO);
                 velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOSearchSvcRlaneCodeListRSQL(), param, velParam);              
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * Trade변경시 Rlane과 JO_STL_OPT_CD를 조회한다.
	 * 조회조건
	 *  - super_cd1 : Carrier (mandatory)
	 *  - super_cd2 : Trade  (mandatory)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchRLaneStlOptList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAORlaneWithOptRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * Login한 User의 소속 HQ AR Office Code를 return한다.
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchArHqOfcList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOArHqOfcCdRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * Login한 User의 Office Code로 Local Code를 구해 Local DateTime을 return한다.
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public String searchLocalDateTime(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String locDateTime = "";
		try {
			 Map<String, String> mapVO = new HashMap<String, String>();
			 
			 mapVO.put("ofc_cd", ofcCd);

			 param.putAll(mapVO);
			 velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOGetLocalDateTimeRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
			
			locDateTime = list.get(0).getName();
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return locDateTime;
	}

	/**
	 * Lane코드와 VVD를 조회조건으로 Rev Dir.과 Unit Cost Port를 Vessel Port Schedule에서 읽어온다.
	 * 조회조건
	 *  - super_cd1 : lane code - mandatory
	 *  - super_cd2 : VVD (9자리) - mandatory
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchRevDirAndUnitCostPortList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAORevDirAndUnitCostPortsRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
     * JOO_SLIP의 SLP_OFC_CD을 조회한다. 
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO> 
     * @throws EventException
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<JooCodeInfoVO> searchOfcCdSlip(JooCodeParamVO jooCodeParamVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<JooCodeInfoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (jooCodeParamVO != null) {
                 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

                 param.putAll(mapVO);
                 velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOSearchOfcCdSlipRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
     * Authority Office Code를 조회한다. 
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO> 
     * @throws EventException
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<JooCodeInfoVO> searchAuthOfficeList(JooCodeParamVO jooCodeParamVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<JooCodeInfoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (jooCodeParamVO != null) {
                 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

                 param.putAll(mapVO);
                 velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOSearchAuthOfficeListRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
     * RHQ Code 를 조회한다. 
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO> 
     * @throws EventException
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<JooCodeInfoVO> searchArHqOfcAllList(JooCodeParamVO jooCodeParamVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<JooCodeInfoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (jooCodeParamVO != null) {
                 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

                 param.putAll(mapVO);
                 velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOSearchArHqOfcAllListRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
            log.debug("list2:"+list);
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
     *  Office Code를 조회한다.
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO>
     * @throws DAOException
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<JooCodeInfoVO> searchOfcCd(JooCodeParamVO jooCodeParamVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<JooCodeInfoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (jooCodeParamVO != null) {
                 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

                 param.putAll(mapVO);
                 velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOSearchOfcCdRSQL (), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
     * Carrier 코드 조회 3자리 조회 
     * 조회조건
     *  - super_cd1 : Carrier (mandatory)
     *  - super_cd2 : Trade  (mandatory)
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO>
     * @throws DAOException
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<JooCodeInfoVO> searchRLaneStlOpt3CodeList(JooCodeParamVO jooCodeParamVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<JooCodeInfoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (jooCodeParamVO != null) {
                 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

                 param.putAll(mapVO);
                 velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOSearchRLaneStlOpt3CodeListRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
     * Combined No 조회한다. 
     *
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO>
     * @throws DAOException
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<JooCodeInfoVO> searchCombinedNoOptAuthList(JooCodeParamVO jooCodeParamVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<JooCodeInfoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (jooCodeParamVO != null) {
                 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

                 param.putAll(mapVO);
                 velParam.putAll(mapVO);
            } 
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOSearchCombinedNoOptAuthListRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
     * 
     * VSL CODE + VOYAGE NUMBER 조합의 KEY 입력값 valide 체크.
     *
     * @param  JooCodeParamVO jooCodeParamVO
     * @throws DAOException
     * @return List<JooCodeInfoVO>
     * @author jang kang cheol
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<JooCodeInfoVO> searchVslVoyageList(JooCodeParamVO jooCodeParamVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<JooCodeInfoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (jooCodeParamVO != null) {
                 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

                 param.putAll(mapVO);
                 velParam.putAll(mapVO);
            } 
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOSearchVslVoyageListRSQL(), param, velParam);
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * 공동운항에서만 사용하는 Carrier Code 조회 (Authority 없이)
	 * 조회조건 
	 *  - super_cd1 : trade code (optional)
	 *  - super_cd2 : rlane code (optional)
	 *  - code : carrier code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchCarrierCodeWithoutAuthorityList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOCarrierWithoutAuthorityRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * 공동운항에서 사용하는 Trade 코드 List를 조회한다. 
	 * 조회조건
	 *  - super_cd1 : Carrier (optional)
	 *  - code : trade code
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchTradeCodeWithoutAuthorityList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOTradeWithoutAuthorityRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * 공동운항에서 사용하는 Lane 코드리스트를 조회한다.
	 * 조회조건 
	 *  - super_cd1 : Carrier code (optional)
	 *  - super_cd2 : Trade code (optional)
	 *  - code : Lane code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchRLaneCodeWithoutAuthorityList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
		    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOLaneWithoutAuthorityRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * 공동운항에서 사용하는 Carrier 및 Lane 코드리스트를 조회한다.
	 * 조회조건 
	 * @param String ofcCd
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchCarrierByLaneList(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ofc_cd", ofcCd);
		    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOCarrierByLaneRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * Carrier, Trade, Lane 조회
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchCarrierTradeLaneWithoutAuthorityList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOCarrierTradeLaneWithoutAuthorityRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * Common Tax Type 조회
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return Collection
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchTaxTypeList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO>  codeList = new ArrayList();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOTaxTypeRSQL(),	param, velParam);
			codeList = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return codeList;
	}
	
	/**
	 * Vsl Slan Dir Cd Search.
	 * 조회조건
	 *  - super_cd1 : lane code 
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchVslSlanDirCdByLane(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOVslSlanDirCdByLaneRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * JOO_COM_PPT Search.
	 * 조회조건
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooComCodeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooComCodeVO> searchJooComCodeList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooComCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOSearchJooComCodeListRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooComCodeVO.class);
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
	 * JOO_COM_PPT Laden Search.
	 * 조회조건
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooComCodeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooComCodeVO> searchJooComCodeByLadenList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooComCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOSearchJooComCodeListByLadenRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooComCodeVO.class);
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
	 * JOO_COM_PPT Empty Search.
	 * 조회조건
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooComCodeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooComCodeVO> searchJooComCodeByEmptyList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooComCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOSearchJooComCodeListByEmptyRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooComCodeVO.class);
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
     * 공동운항에서 사용하는 VSK_VSL_SKD, MDM_VSL_SVC_LANE vsl_slan_cd 코드리스트를 조회한다.
     * 조회조건 
     *  - code : vsl_cd + skd_voy_no
     * @param JooCodeParamVO jooCodeParamVO
     * @return List<JooCodeInfoVO>
     * @throws DAOException
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<JooCodeInfoVO> searchVslSlanCdInfoByVvd(JooCodeParamVO jooCodeParamVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<JooCodeInfoVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (jooCodeParamVO != null) {
                 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

                 param.putAll(mapVO);
                 velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOSearchVslSlanCdInfoRSQL(), param, velParam);              
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 *  JOO_STL_CMB 전표 번호를 체크 한다.
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchCheckDBDAOCheckSlipByStlCmbSeq(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String csrNo = "";
		try {
			Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

            param.putAll(mapVO);
            velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOCheckSlipByStlCmbSeqRSQL(),	param, velParam);
			if (dbRowset.next()) {
				csrNo = dbRowset.getString("CSR_NO");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return csrNo;
	}
	
    /**
     * 공통 Rlane_cd 조회 
     *  -rlane_cd, JO_CRR_CD, TRD_CD, JO_STL_OPT_CD, JO_CRR_AUTH_CD, LOCL_CURR_CD, JO_STL_TGT_TP_CD
     * @param JooComRlaneVO jooComRlaneVO
     * @return List<JooComRlaneVO>
     * @throws DAOException
     */
	@SuppressWarnings({ "unchecked", "rawtypes" })
    public List<JooComRlaneVO> searchRlaneCodeList(JooComRlaneVO jooComRlaneVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<JooComRlaneVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            if (jooComRlaneVO != null) {
                 Map<String, String> mapVO = jooComRlaneVO.getColumnValues();

                 param.putAll(mapVO);
                 velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOSearchRlaneCodeListRSQL(), param, velParam);              
            list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooComRlaneVO.class);
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
	 * Common Code(Region) 조회 (com_intg_cd_dtl)
	 * 조회조건
	 *  - super_cd1 : 그룹코드(intg_cd_id) - mandatory
	 *  - code : 코드(intg_cd_val_ctnt) - optional
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooCodeInfoVO> searchRegionList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOSearchRegionListRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooCodeInfoVO.class);
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
	 * Actual Carrier/Vender/Coustomer 조회합니다.
	 * 
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooComActualCarrierVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooComActualCarrierVO> searchActualCarrierList(JooCodeParamVO jooCodeParamVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooComActualCarrierVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooCodeParamVO != null) {
				 Map<String, String> mapVO = jooCodeParamVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOSearchActualCarrierListRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooComActualCarrierVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}
