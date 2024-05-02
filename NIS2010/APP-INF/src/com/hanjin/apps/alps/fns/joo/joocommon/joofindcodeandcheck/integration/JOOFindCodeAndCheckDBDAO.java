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
*
* 2012.01.26 조병연[CHM-201215460-01]
* 제목 : [ALPS JOO] Estimate Performance Change Status I 신규개발 (2011년 12월 4차)
* 내용 : 매월 결산 후 "공동운항 선복 용/대선료 실적 현황" 보고 시, 전월 대상항차의 Estimate 변동 현황 분석을 위해 
* 첨부와 같이 신규개발을 요청 드립니다.
* (동일한 대상 기간의 추정실적 Data를 비교하여 변동 건을 포착/분석하는 기능)
* - 기대효과 1 : 기존의 Excel 수작업 업무를 시스템화함으로써 업무 편의성 및 효율성 제고
* - 기대효과 2 : Initial Estimate(ALPS BSA 모듈의 Data) 뿐 아니라 Adjusted Estimate
*   (ALPS JOO 모듈의 추정실적 생성 메뉴에서 User가 Manual로 조정한 Data)까지 자동으로 비교함으로써 변동 현황 
*  분석의 다각화 가능
*  
* 2012.02.10 조병연[CHM-201215990-01]
* Title : [ALPS JOO] Estimate Performance Change Status II 신규개발 (2012년 1월 2차)
* 내용 :
* - ALPS JOO 전월 대상항차 Estimate 변동 현황 분석기능 개발		
=========================================================*/
package com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.TdrLoadVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.RdrLoadVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusVO;

import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration.JOOFindCodeAndCheckDBDAOSearchAuthOfficeListRSQL;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.basic.JOOFindCodeAndCheckBCImpl;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeInfoVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusIIVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipConditionVO;


/**
 * ALPS JOOFindCodeAndCheckDBDAO <br>
 * - ALPS-JOOCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Park Hee Dong
 * @see JOOFindCodeAndCheckBCImpl 참조
 * @since J2EE 1.4
 */
public class JOOFindCodeAndCheckDBDAO extends DBDAOSupport {

	/**
	 * MDM TRADE CODE를 조회한다.
	 * 조회조건 : code = trade 코드 (optional) 
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
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
			}
/*			
			//Lane Code 3자리만 잘라서 가져오기 
			String gb = jooCodeParamVO.getName()==null?"":jooCodeParamVO.getName();
			 if( !gb .equals("FOR_3CODE")){
			     dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOJooLaneRSQL(), param, velParam);
			 }else{
                 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOJooLanebyThreeCodeRSQL(), param, velParam);			     
			 }
*/
			// 소스 보완 수정(2015.02)			
			String gb = "";			
			if(jooCodeParamVO == null){				
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOJooLaneRSQL(), param, velParam);
			}else{				
				gb = jooCodeParamVO.getName();				

				if(gb == null){
					gb = "";
				}
				
				 if( !gb .equals("FOR_3CODE")){
					 log.debug("gb5 = "+gb);
				     dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOJooLaneRSQL(), param, velParam);
				 }else{
					 log.debug("gb6 = "+gb);
	                 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOJooLanebyThreeCodeRSQL(), param, velParam);			     
				 }				
			}
			 
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
	 * 공동운항에서 사용하는 TRADE와 LANE을 중복되지 않게 LIST 조회한다.
	 * 조회조건 : 없음
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
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
	 * TDR Inquiry by VVD에서 사용하는 Carrier Code 조회
	 * @param TdrLoadVO tdrLoadVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	public List<JooCodeInfoVO> searchTDRCarrierCodeListByPeriodAndRlane(TdrLoadVO tdrLoadVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (tdrLoadVO != null) {
				 Map<String, String> mapVO = tdrLoadVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOTDRCarrierByPeriodAndLaneRSQL(),	param, velParam);
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
	 * RDR Inquiry by Lane에서 사용하는 Carrier Code 조회
	 * @param RdrLoadVO rdrLoadVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	public List<JooCodeInfoVO> searchRDRCarrierCodeListByPeriodAndRlane(RdrLoadVO rdrLoadVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rdrLoadVO != null) {
				 Map<String, String> mapVO = rdrLoadVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAORDRCarrierByPeriodAndLaneRSQL(),	param, velParam);
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
	 *  - super_cd2 : trade code (optional)
	 *  - super_cd1 : rlane code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
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
	 * 추정테이블에서 REV_YRMON From~ TO를 조회한다
	 * @param EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO
	 * @return List<EstmPerformanceChangeStatusVO>
	 * @throws DAOException
	 */
	public List<EstmPerformanceChangeStatusVO> searchEstmRevYrmonFrTo(EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmPerformanceChangeStatusVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (estmPerformanceChangeStatusVO != null) {
				 Map<String, String> mapVO = estmPerformanceChangeStatusVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOEstmRevYrmonRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EstmPerformanceChangeStatusVO.class);
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
	 * @param EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO
	 * @return List<EstmPerformanceChangeStatusVO>
	 * @throws DAOException
	 */
	public List<EstmPerformanceChangeStatusVO> searchEstmTradeCodeListEstm(EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmPerformanceChangeStatusVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (estmPerformanceChangeStatusVO != null) {
				 Map<String, String> mapVO = estmPerformanceChangeStatusVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOEstmTradeRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EstmPerformanceChangeStatusVO.class);
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
	 * @param EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO
	 * @return List<EstmPerformanceChangeStatusVO>
	 * @throws DAOException
	 */
	public List<EstmPerformanceChangeStatusVO> searchEstmRlaneCodeListEstm(EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmPerformanceChangeStatusVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (estmPerformanceChangeStatusVO != null) {
				 Map<String, String> mapVO = estmPerformanceChangeStatusVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOEstmRlaneRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EstmPerformanceChangeStatusVO.class);
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
	 * @param EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO
	 * @return List<EstmPerformanceChangeStatusVO>
	 * @throws DAOException
	 */
	public List<EstmPerformanceChangeStatusVO> searchEstmCarrierCodeListEstm(EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmPerformanceChangeStatusVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (estmPerformanceChangeStatusVO != null) {
				 Map<String, String> mapVO = estmPerformanceChangeStatusVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOEstmCarrierRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EstmPerformanceChangeStatusVO.class);
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
	public List<JooCodeInfoVO> searchComCodeNmList(JooCodeParamVO jooCodeParamVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOCommonCodeNmRSQL(),	param, velParam);
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
	 * @param EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusIIVO
	 * @return List<EstmPerformanceChangeStatusIIVO>
	 * @throws DAOException
	 */
	public List<EstmPerformanceChangeStatusIIVO> searchEstmRevYrmonFrToEstmII(EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusIIVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmPerformanceChangeStatusIIVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (estmPerformanceChangeStatusIIVO != null) {
				 Map<String, String> mapVO = estmPerformanceChangeStatusIIVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOEstmRevYrmonRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EstmPerformanceChangeStatusIIVO.class);
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
	 * @param EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusIIVO
	 * @return List<EstmPerformanceChangeStatusIIVO>
	 * @throws DAOException
	 */
	public List<EstmPerformanceChangeStatusIIVO> searchEstmTradeCodeListEstmII(EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusIIVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmPerformanceChangeStatusIIVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (estmPerformanceChangeStatusIIVO != null) {
				 Map<String, String> mapVO = estmPerformanceChangeStatusIIVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOEstmTradeRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EstmPerformanceChangeStatusIIVO.class);
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
	 * @param EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusIIVO
	 * @return List<EstmPerformanceChangeStatusIIVO>
	 * @throws DAOException
	 */
	public List<EstmPerformanceChangeStatusIIVO> searchEstmRlaneCodeListEstmII(EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusIIVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmPerformanceChangeStatusIIVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (estmPerformanceChangeStatusIIVO != null) {
				 Map<String, String> mapVO = estmPerformanceChangeStatusIIVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOEstmRlaneRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EstmPerformanceChangeStatusIIVO.class);
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
	 * @param EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusIIVO
	 * @return List<EstmPerformanceChangeStatusIIVO>
	 * @throws DAOException
	 */
	public List<EstmPerformanceChangeStatusIIVO> searchEstmCarrierCodeListEstmII(EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusIIVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmPerformanceChangeStatusIIVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (estmPerformanceChangeStatusIIVO != null) {
				 Map<String, String> mapVO = estmPerformanceChangeStatusIIVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOEstmCarrierRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EstmPerformanceChangeStatusIIVO.class);
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
	 * VVD code를 파라미터로 입력하여 Lane과 Region를 조회한다.
	 * 조회조건 
	 *  - code : carrier code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	public List<JooCodeInfoVO> searchLaneRegionList(JooCodeParamVO jooCodeParamVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOsearchLaneRegionListRSQL(),	param, velParam);
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
	 * RDR Inquiry by Lane에서 사용하는 Carrier Code 조회
	 * @param RdrLoadVO rdrLoadVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */		
	public List<JooCodeInfoVO> searchRDRCarrierCodeListByPeriodAndServiceLane(RdrLoadVO rdrLoadVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (rdrLoadVO != null) {
				 Map<String, String> mapVO = rdrLoadVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAORDRCarrierByPeriodAndServiceLaneRSQL(),	param, velParam);
			
			
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
	 * 공통 : Lane Code 변경
	 * Lane변경시 Lane Code, Trade Code를 조회조건으로 VSK_VSL_PORT_SKD, MDM_REV_LANE 테이블에서 vsl_cd를 조회한다.
	 *  - super_cd1 : Lane code (optional)
	 *  - super_cd2 : Trade code (optional)
	 *  - code : Lane code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	public List<JooCodeInfoVO> searchRVslCodeWithoutAuthorityList(JooCodeParamVO jooCodeParamVO) throws DAOException {
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
		    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOVslCodeWithoutAuthorityRSQL(), param, velParam);
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
	 * 공통 : Lane Code 변경
	 * Lane변경시 Lane Code, Trade Code, Vsl Code를 조회조건으로 VSK_VSL_PORT_SKD, MDM_REV_LANE 테이블에서 VPS_PORT_CD를 조회한다.
	 *  - super_cd1 : Lane code (optional)
	 *  - super_cd2 : Trade code (optional)
	 *  - super_cd3 : Vsl code (optional)
	 *  - code : Lane code (optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	public List<JooCodeInfoVO> searchRVpsPortCodeWithoutAuthorityList(JooCodeParamVO jooCodeParamVO) throws DAOException {
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
		    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOVpsPortWithoutAuthorityRSQL(), param, velParam);
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
	 * BSA Information Entry 공통 MDM_VSL_CNTR 테이블에서 VSL_CD 조회
	 * 조회조건 
	 *  - super_cd1 : VSL_CD (optional)
	 *  - code : VSL_CD 코드(optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	public List<JooCodeInfoVO> searchVslCodeList(JooCodeParamVO jooCodeParamVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOSearchVslCodeListRSQL(),	param, velParam);
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
	 * BSA Information Entry 공통 MDM_LOCATION 테이블에서 LOC_CD 조회
	 * 조회조건 
	 *  - super_cd1 : LOC_CD (optional)
	 *  - code : LOC_CD 코드(optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	public List<JooCodeInfoVO> searchLocCodeList(JooCodeParamVO jooCodeParamVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOSearchLocCodeListRSQL(),	param, velParam);
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
	 * BSA Information Entry 공통 VSK_VSL_PORT_SKD 테이블에서 VSL_CD 조회
	 * 조회조건 
	 *  - super_cd1 : VSL_CD (optional)
	 *  - super_cd2 : SKD_VOY_NO (optional)
	 *  - super_cd3 : SKD_DIR_CD (optional)
	 *  - code : VSL_CD 코드(optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	public List<JooCodeInfoVO> searchVslPortSkdCodeList(JooCodeParamVO jooCodeParamVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOSearchVslPortSkdCodeListRSQL(),	param, velParam);
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
	 * Blank Voyage Status 공통 AR_MST_REV_VVD 테이블에서 Voyage 조회
	 * 조회조건 
	 *  - super_cd1 : VSL_CD 
	 *  - super_cd2 : SKD_VOY_NO 
	 *  - super_cd3 : SKD_DIR_CD 
	 *  - code : VSL_CD 코드(optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	public List<JooCodeInfoVO> searchArVvd(JooCodeParamVO jooCodeParamVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOsearchArVvdRSQL(),	param, velParam);
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
	 * Additional Slot Manager 공통 VSK_VSL_PORT_SKD 테이블에서 Vvd, Port 조회
	 * 조회조건 
	 *  - super_cd1 : VVD_CD 
	 *  - code : VSL_CD 코드(optional)
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	public List<JooCodeInfoVO> searchVvdPortCodeList(JooCodeParamVO jooCodeParamVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOSearchVvdPortCodeListRSQL(),	param, velParam);
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
	 * Settlement Target에서 Carrier Code를 조회한다.
	 * 
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	public List<JooCodeInfoVO> searchTgtCrrCodeList(JooCodeParamVO jooCodeParamVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOTgtCrrCodeRSQL(),	param, velParam);
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
	 * Additional Slot Manager 공통 COM_USER에서 user정보를 조회한다.
	 *  
	 * @param JooCodeParamVO jooCodeParamVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	public List<JooCodeInfoVO> searchUsrInfo(JooCodeParamVO jooCodeParamVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOSearchUsrInfoRSQL(),	param, velParam);
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
	 * CSR List Inquiry JOO_STL_CMB 테이블에서 JO_CRR_CD 조회.
	 *  
	 * @param SlipConditionVO slipConditionVO
	 * @return List<JooCodeInfoVO>
	 * @throws DAOException
	 */
	public List<JooCodeInfoVO> searchCarrierListByCsr(SlipConditionVO slipConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooCodeInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (slipConditionVO != null) {
				 Map<String, String> mapVO = slipConditionVO.getColumnValues();

				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JOOFindCodeAndCheckDBDAOSearchCarrierListByCsrRSQL(),	param, velParam);
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
}
