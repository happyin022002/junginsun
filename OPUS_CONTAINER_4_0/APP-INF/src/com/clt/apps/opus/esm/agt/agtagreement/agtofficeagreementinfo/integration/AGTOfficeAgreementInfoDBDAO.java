/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AGTOfficeAgreementInfoDBDAO.java
 *@FileTitle : Agent Agreement Rate Creation 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.08.17
 *@LastModifier : 이호진
 *@LastVersion : 1.0
 * 2009.08.17 이호진
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.basic.AGTOfficeAgreementInfoBCImpl;
import com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.vo.AgtChargeDeductionVO;
import com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.vo.AgtCntrTypeSizeVO;
import com.clt.apps.opus.esm.agt.agtagreement.agtofficeagreementinfo.vo.AgtGeogOfcVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.AgtAgnAgmtMstVO;
import com.clt.syscommon.common.table.AgtAgnAgmtRtVO;
import com.clt.syscommon.common.table.AgtAgnAgmtVO;
import com.clt.syscommon.common.table.AgtAgnChgRefVO;
import com.clt.syscommon.common.table.AgtAgnCtrtRefVO;
import com.clt.syscommon.common.table.AgtAgnOtrRefVO;
import com.clt.syscommon.common.table.AgtAgnRoutRefVO;
import com.clt.syscommon.common.table.MdmOrganizationVO;

/**
 * OPUS AGTOfficeAgreementInfoDBDAO <br>
 * - OPUS-AGTAgreement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Lee Ho Jin
 * @see AGTOfficeAgreementInfoBCImpl 참조
 * @since J2EE 1.6
 */
public class AGTOfficeAgreementInfoDBDAO extends DBDAOSupport {

	/**
	 * EsmAgt0001 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return List<AgtAgnAgmtVO>
	 * @throws DAOException
	 * @Auther Ho-Jin Lee 2009-08-18 Creation
	 */
	@SuppressWarnings("unchecked")
	public List<AgtAgnAgmtVO> searchAgentInfoForAgreementbyCountry(
			AgtAgnAgmtVO agtAgnAgmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtAgnAgmtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (agtAgnAgmtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
			(ISQLTemplate) new AGTOfficeInfoAgreementDBDAOAgentInfoForAgreementbyCountryRSQL(),
			param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AgtAgnAgmtVO.class);
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
	 * EsmAgt0001 AGT_AGN_AGMT테이블의 데이터 삭제플래그 업데이트 처리<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return int 
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeAgentInfoForAgreement(AgtAgnAgmtVO agtAgnAgmtVO)
			throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if (agtAgnAgmtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate(
			(ISQLTemplate) new AGTOfficeAgreementInfoDBDAORemoveAgentInfoForAgreementDSQL(),
			param, velParam);

			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * EsmAgt0001 AGT_AGN_AGMT테이블의 데이터 삭제플래그 업데이트 처리<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return int result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int removeAgentInfoForAgreementMaster(AgtAgnAgmtVO agtAgnAgmtVO)
			throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if (agtAgnAgmtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate(
			(ISQLTemplate) new AGTOfficeAgreementInfoDBDAORemoveAgentInfoForAgreementMasterDSQL(),
			param, velParam);

			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * EsmAgt0001 AGT_AGN_AGMT테이블의 데이터 생성 처리<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return int result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int createAgentInfoForAgreement(AgtAgnAgmtVO agtAgnAgmtVO)
			throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if (agtAgnAgmtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate(
			(ISQLTemplate) new AGTOfficeAgreementInfoDBDAOCreateAgentInfoForAgreementCSQL(),
			param, velParam);

			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * EsmAgt0001 AGT_AGN_AGMT테이블 등의 데이터 복사 처리<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return AgtAgnAgmtVO
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public AgtAgnAgmtVO createOldAgreementNoVendortoNewSelect(
			AgtAgnAgmtVO agtAgnAgmtVO) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<AgtAgnAgmtVO> list = null;
		AgtAgnAgmtVO result = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

//		AgtAgnAgmtVO result = null;
		try {
			if (agtAgnAgmtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AGTOfficeAgreementInfoDBDAOCreateOldAgreementNoVendortoNewSelectRSQL(), param, velParam);
			if ( 0 < dbRowset.getRowCount())
			{
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, AgtAgnAgmtVO.class);
				result = list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * EsmAgt0001 AGT_AGN_AGMT_MST테이블의 데이터 복사 처리<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return int result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int createOldAgreementNoVendortoNewAgmtMst(AgtAgnAgmtVO agtAgnAgmtVO)
			throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if (agtAgnAgmtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementInfoDBDAOCreateOldAgreementNoVendortoNewAgmtMstCSQL(), param, velParam);

			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * EsmAgt0001 AGT_AGN_AGMT테이블의 데이터 복사 처리<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return int result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int createOldAgreementNoVendortoNewAgmt(AgtAgnAgmtVO agtAgnAgmtVO)
			throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if (agtAgnAgmtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementInfoDBDAOCreateOldAgreementNoVendortoNewAgmtCSQL(), param, velParam);

			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * EsmAgt0001 AGT_AGN_AGMT_RT테이블의 데이터 복사 처리<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return int result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int createOldAgreementNoVendortoNewAgmtRt(AgtAgnAgmtVO agtAgnAgmtVO)
			throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if (agtAgnAgmtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementInfoDBDAOCreateOldAgreementNoVendortoNewAgmtRtCSQL(), param, velParam);

			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * EsmAgt0001 AGT_AGN_ROUT_REF테이블의 데이터 복사 처리<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return int result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int createOldAgreementNoVendortoNewRoutRef(AgtAgnAgmtVO agtAgnAgmtVO)
			throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if (agtAgnAgmtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementInfoDBDAOCreateOldAgreementNoVendortoNewRoutRefCSQL(), param, velParam);

			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * EsmAgt0001 AGT_AGN_CHG_REF테이블의 데이터 복사 처리<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return int result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int createOldAgreementNoVendortoNewChgRef(AgtAgnAgmtVO agtAgnAgmtVO)
			throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if (agtAgnAgmtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementInfoDBDAOCreateOldAgreementNoVendortoNewChgRefCSQL(), param, velParam);

			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * EsmAgt0001 AGT_AGN_CTRT_REF테이블의 데이터 복사 처리<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return int result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int createOldAgreementNoVendortoNewCtrtRef(AgtAgnAgmtVO agtAgnAgmtVO)
			throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if (agtAgnAgmtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementInfoDBDAOCreateOldAgreementNoVendortoNewCtrtRefCSQL(), param, velParam);

			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * EsmAgt0001 AGT_AGN_OTR_REF테이블의 데이터 복사 처리<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return int result
	 * @throws DAOException
	 * @throws Exception
	 */
	public int createOldAgreementNoVendortoNewOtrRef(AgtAgnAgmtVO agtAgnAgmtVO)
			throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if (agtAgnAgmtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementInfoDBDAOCreateOldAgreementNoVendortoNewOtrRefCSQL(), param, velParam);

			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * (ESM_AGT_003) AgentRateInfo 의 정보를 가져온다.<br>
	 * 
	 * @param AgtAgnAgmtMstVO agtAgnAgmtMstVO
	 * @return List<AgtAgnAgmtMstVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AgtAgnAgmtMstVO> searchAgentRateInfoList(
			AgtAgnAgmtMstVO agtAgnAgmtMstVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtAgnAgmtMstVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (agtAgnAgmtMstVO != null) {
				Map<String, String> mapVO = agtAgnAgmtMstVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
			(ISQLTemplate) new AGTOfficeAgreementInfoDBDAOAgtAgnAgmtMstVORSQL(),
			param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AgtAgnAgmtMstVO.class);
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
	 * (ESM_AGT_003) AgentRateInfo 의 정보를 가져온다.<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return List<AgtAgnAgmtVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AgtAgnAgmtVO> searchAgentRateInfoList2(AgtAgnAgmtVO agtAgnAgmtVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtAgnAgmtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (agtAgnAgmtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
			(ISQLTemplate) new AGTOfficeAgreementInfoDBDAOAgtAgnAgmtVORSQL(),
			param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AgtAgnAgmtVO.class);
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
	 * [(ESM_AGT_003) AgentRateInfo Rt 의 정보를 가져온다.<br>
	 * 
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return List<AgtAgnAgmtRtVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AgtAgnAgmtRtVO> searchAgentRateDetailInfoList(
			AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtAgnAgmtRtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (agtAgnAgmtRtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AGTOfficeAgreementInfoDBDAOAgtAgnAgmtRtVORSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AgtAgnAgmtRtVO.class);
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
	 * [(ESM_AGT_003) AgentRateInfo Rt 의 정보의 cntr_inp_term_cd Setting 하기 위해
	 * Agt_Agn_Otr_Ref 조회
	 * 
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return List<AgtAgnOtrRefVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<AgtAgnOtrRefVO> setsearchCntrInpTermcd(
			AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws DAOException, Exception {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<AgtAgnOtrRefVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (agtAgnAgmtRtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
			(ISQLTemplate) new AGTOfficeAgreementDBDAOAgentRateDetailInfoList01RSQL(),
			param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AgtAgnOtrRefVO.class);
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
	 * [(ESM_AGT_003) AgentRateInfo Rt 의 정보의 chg_ddct_inp_cd Setting 하기 위해
	 * agt_agn_chg_ref 조회<br>
	 * 
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return List<AgtAgnChgRefVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<AgtAgnChgRefVO> setsearchChgDdctInpCd(
			AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws DAOException, Exception {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<AgtAgnChgRefVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (agtAgnAgmtRtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
			(ISQLTemplate) new AGTOfficeAgreementDBDAOAgentRateDetailInfoList02RSQL(),
			param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AgtAgnChgRefVO.class);
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
	 * [(ESM_AGT_003) AgentRateInfo Rt 의 정보의 cust_inp_term_cd Setting 하기 위해
	 * Agt_Agn_Otr_Ref 조회<br>
	 * 
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return List<AgtAgnOtrRefVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<AgtAgnOtrRefVO> setsearchCustInpTermCd(
			AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws DAOException, Exception {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<AgtAgnOtrRefVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (agtAgnAgmtRtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
			(ISQLTemplate) new AGTOfficeAgreementDBDAOAgentRateDetailInfoList03RSQL(),
			param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AgtAgnOtrRefVO.class);
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
	 * [(ESM_AGT_003) AgentRateInfo Rt 의 정보의 sc_inp_term_cd Setting 하기 위해
	 * agt_agn_chg_ref 조회<br>
	 * 
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return List<AgtAgnOtrRefVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<AgtAgnOtrRefVO> setsearchScInpTermCd(
			AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws DAOException, Exception {
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<AgtAgnOtrRefVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (agtAgnAgmtRtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery(
			(ISQLTemplate) new AGTOfficeAgreementDBDAOAgentRateDetailInfoList04RSQL(),
			param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AgtAgnOtrRefVO.class);
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
	 * [(ESM_AGT_003) AgentRateInfo Rt 의 정보의 rfa_inp_term_cd 결과에 setting 하기 위해
	 * agt_agn_otr_ref 조회<br>
	 * 
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return List<AgtAgnOtrRefVO> 
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<AgtAgnOtrRefVO> setsearchRfaInpTermCd(
			AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws DAOException, Exception {
		DBRowSet dbRowSet = null;
		List<AgtAgnOtrRefVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (agtAgnAgmtRtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtRtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowSet = new SQLExecuter("").executeQuery(
			(ISQLTemplate) new AGTOfficeAgreementDBDAOAgentRateDetailInfoList05RSQL(),
			param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowSet, AgtAgnOtrRefVO.class);
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
	 * [(ESM_AGT_003) AgentRateInfo Rt 의 정보의 agt_agn_ctrt_ref 조회 결과를
	 * sc_ofc_inp_cd 에 setting<br>
	 * 
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return List<AgtAgnCtrtRefVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<AgtAgnCtrtRefVO> setsearchScOfcInpCd(
			AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws DAOException, Exception {
		// TODO Auto-generated method stub
		DBRowSet dbRowSet = null;
		List<AgtAgnCtrtRefVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (agtAgnAgmtRtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtRtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowSet = new SQLExecuter("").executeQuery(
			(ISQLTemplate) new AGTOfficeAgreementDBDAOAgentRateDetailInfoList06RSQL(),
			param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowSet, AgtAgnCtrtRefVO.class);
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
	 * [(ESM_AGT_003) AgentRateInfo Rt 의 정보의 agt_agn_ctrt_ref 조회 결과를
	 * rfa_ofc_inp_cd 에 setting<br>
	 * 
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return List<AgtAgnCtrtRefVO> 
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<AgtAgnCtrtRefVO> setsearchRfaOfcInpCd(
			AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws DAOException, Exception {
		// TODO Auto-generated method stub
		DBRowSet dbRowSet = null;
		List<AgtAgnCtrtRefVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (agtAgnAgmtRtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtRtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowSet = new SQLExecuter("").executeQuery(
			(ISQLTemplate) new AGTOfficeAgreementDBDAOAgentRateDetailInfoList07RSQL(),
			param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowSet, AgtAgnCtrtRefVO.class);
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
	 * [(ESM_AGT_003) AgentRateInfo Rt 의 정보의 agt_agn_rout_ref 를 조회하여 결과를
	 * bkg_ofc_inp_term_cd 에 setting<br>
	 * 
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return List<AgtAgnRoutRefVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<AgtAgnRoutRefVO> setsearchBkgOfcInpTermCd(
			AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws DAOException, Exception {
		// TODO Auto-generated method stub
		DBRowSet dbRowSet = null;
		List<AgtAgnRoutRefVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (agtAgnAgmtRtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtRtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowSet = new SQLExecuter("").executeQuery(
			(ISQLTemplate) new AGTOfficeAgreementDBDAOAgentRateDetailInfoList08RSQL(),
			param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowSet, AgtAgnRoutRefVO.class);
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
	 * [(ESM_AGT_003) AgentRateInfo Rt 의 정보의 agt_agn_rout_ref 를 조회하여 결과를
	 * bkg_ofc_inp_term_cd 에 setting<br>
	 * 
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return List<AgtAgnRoutRefVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<AgtAgnRoutRefVO> setsearchSlsOfcInpTermCd(
			AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws DAOException, Exception {
		// TODO Auto-generated method stub
		DBRowSet dbRowSet = null;
		List<AgtAgnRoutRefVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (agtAgnAgmtRtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtRtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowSet = new SQLExecuter("").executeQuery(
			(ISQLTemplate) new AGTOfficeAgreementDBDAOAgentRateDetailInfoList09RSQL(),
			param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowSet, AgtAgnRoutRefVO.class);
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
	 * [(ESM_AGT_003) AgentRateInfo Rt 의 정보의 agt_agn_rout_ref 를 조회하여 결과를
	 * bkg_ofc_inp_term_cd 에 setting<br>
	 * 
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return List<AgtAgnRoutRefVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<AgtAgnRoutRefVO> setsearchBkgPorInpTermCd(
			AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws DAOException, Exception {
		// TODO Auto-generated method stub
		DBRowSet dbRowSet = null;
		List<AgtAgnRoutRefVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (agtAgnAgmtRtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtRtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowSet = new SQLExecuter("").executeQuery(
			(ISQLTemplate) new AGTOfficeAgreementDBDAOAgentRateDetailInfoList10RSQL(),
			param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowSet,AgtAgnRoutRefVO.class);
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
	 * [(ESM_AGT_003) AgentRateInfo Rt 의 정보의 agt_agn_rout_ref 를 조회하여 결과를
	 * bkg_ofc_inp_term_cd 에 setting<br>
	 * 
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return List<AgtAgnRoutRefVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<AgtAgnRoutRefVO> setsearchBkgPolInpTermCd(
			AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws DAOException, Exception {
		// TODO Auto-generated method stub
		DBRowSet dbRowSet = null;
		List<AgtAgnRoutRefVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (agtAgnAgmtRtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtRtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowSet = new SQLExecuter("")
	.executeQuery(
			(ISQLTemplate) new AGTOfficeAgreementDBDAOAgentRateDetailInfoList11RSQL(),
			param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowSet,
	AgtAgnRoutRefVO.class);
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
	 * [(ESM_AGT_003) AgentRateInfo Rt 의 정보의 agt_agn_rout_ref 를 조회하여 결과를
	 * bkg_ofc_inp_term_cd 에 setting<br>
	 * 
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return List<AgtAgnRoutRefVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<AgtAgnRoutRefVO> setsearchBkgPodInpTermCd(
			AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws DAOException, Exception {
		// TODO Auto-generated method stub
		DBRowSet dbRowSet = null;
		List<AgtAgnRoutRefVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (agtAgnAgmtRtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtRtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowSet = new SQLExecuter("")
	.executeQuery(
			(ISQLTemplate) new AGTOfficeAgreementDBDAOAgentRateDetailInfoList12RSQL(),
			param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowSet,
	AgtAgnRoutRefVO.class);
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
	 * [(ESM_AGT_003) AgentRateInfo Rt 의 정보의 agt_agn_rout_ref 를 조회하여 결과를
	 * bkg_ofc_inp_term_cd 에 setting<br>
	 * 
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return List<AgtAgnRoutRefVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<AgtAgnRoutRefVO> setsearchBkgDelInpTermCd(
			AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws DAOException, Exception {
		// TODO Auto-generated method stub
		DBRowSet dbRowSet = null;
		List<AgtAgnRoutRefVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (agtAgnAgmtRtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtRtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowSet = new SQLExecuter("")
	.executeQuery(
			(ISQLTemplate) new AGTOfficeAgreementDBDAOAgentRateDetailInfoList13RSQL(),
			param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowSet,
	AgtAgnRoutRefVO.class);
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
	 * [(ESM_AGT_003) AgentRateInfo Rt 의 정보의 agt_agn_rout_ref 를 조회하여 결과를
	 * bkg_ofc_inp_term_cd 에 setting<br>
	 * 
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return List<AgtAgnRoutRefVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<AgtAgnRoutRefVO> setsearchBkgPpdInpTermCd(
			AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws DAOException, Exception {
		// TODO Auto-generated method stub
		DBRowSet dbRowSet = null;
		List<AgtAgnRoutRefVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (agtAgnAgmtRtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtRtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowSet = new SQLExecuter("")
	.executeQuery(
			(ISQLTemplate) new AGTOfficeAgreementDBDAOAgentRateDetailInfoList14RSQL(),
			param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowSet,
	AgtAgnRoutRefVO.class);
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
	 * [(ESM_AGT_003) AgentRateInfo Rt 의 정보의 agt_agn_rout_ref 를 조회하여 결과를
	 * bkg_ofc_inp_term_cd 에 setting<br>
	 * 
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return List<AgtAgnRoutRefVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<AgtAgnRoutRefVO> setsearchBkgCltInpTermCd(
			AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws DAOException, Exception {
		// TODO Auto-generated method stub
		DBRowSet dbRowSet = null;
		List<AgtAgnRoutRefVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (agtAgnAgmtRtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtRtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowSet = new SQLExecuter("")
	.executeQuery(
			(ISQLTemplate) new AGTOfficeAgreementDBDAOAgentRateDetailInfoList15RSQL(),
			param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowSet,
	AgtAgnRoutRefVO.class);
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
	 * [(ESM_AGT_003) AgentRateInfo Rt 의 정보의 agt_agn_rout_ref 를 조회하여 결과를
	 * bkg_ofc_inp_term_cd 에 setting<br>
	 * 
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return List<AgtAgnRoutRefVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<AgtAgnRoutRefVO> setsearchBkgN3rdInpTermCd(
			AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws DAOException, Exception {
		// TODO Auto-generated method stub
		DBRowSet dbRowSet = null;
		List<AgtAgnRoutRefVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (agtAgnAgmtRtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtRtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowSet = new SQLExecuter("")
	.executeQuery(
			(ISQLTemplate) new AGTOfficeAgreementDBDAOAgentRateDetailInfoList16RSQL(),
			param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowSet,
	AgtAgnRoutRefVO.class);
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
	 * [(ESM_AGT_003) AgentRateInfo Rt 의 정보의 agt_agn_rout_ref 를 조회하여 결과를
	 * bkg_ofc_inp_term_cd 에 setting<br>
	 * 
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return List<AgtAgnRoutRefVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<AgtAgnOtrRefVO> setsearchLaneInpTermCd(
			AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws DAOException, Exception {
		// TODO Auto-generated method stub
		DBRowSet dbRowSet = null;
		List<AgtAgnOtrRefVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (agtAgnAgmtRtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtRtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowSet = new SQLExecuter("")
	.executeQuery(
			(ISQLTemplate) new AGTOfficeAgreementDBDAOAgentRateDetailInfoList17RSQL(),
			param, velParam);
			list = (List) RowSetUtil
	.rowSetToVOs(dbRowSet, AgtAgnOtrRefVO.class);
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
	 * [(ESM_AGT_003) AgentRateInfo Rt 의 정보의 agt_agn_rout_ref 를 조회하여 결과를
	 * bkg_ofc_inp_term_cd 에 setting<br>
	 * 
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return List<AgtAgnRoutRefVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<AgtAgnOtrRefVO> setsearchVslInpTermCd(
			AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws DAOException, Exception {
		// TODO Auto-generated method stub
		DBRowSet dbRowSet = null;
		List<AgtAgnOtrRefVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// query parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (agtAgnAgmtRtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtRtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowSet = new SQLExecuter("")
	.executeQuery(
			(ISQLTemplate) new AGTOfficeAgreementDBDAOAgentRateDetailInfoList18RSQL(),
			param, velParam);
			list = (List) RowSetUtil
	.rowSetToVOs(dbRowSet, AgtAgnOtrRefVO.class);
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
	 * ESM_AGT_003) Agreement 의 정보를 Agt_Agn_Agmt Table 에 Insert 한다.
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addmultiAgentRateInfo(AgtAgnAgmtVO agtAgnAgmtVO)
			throws DAOException, Exception {
		// TODO Auto-generated method stub
		int insCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			if (agtAgnAgmtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementDBDAOAgtAgnAgmtVOCSQL(), param, velParam);
			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
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
	 * ESM_AGT_003) Agreement 의 정보를 Agt_Agn_Agmt Table 에 update 한다.
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifymultiAgentRateInfo(AgtAgnAgmtVO agtAgnAgmtVO)
			throws DAOException, Exception {
		// TODO Auto-generated method stub
		int updCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {

			if (agtAgnAgmtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			updCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementDBDAOAgtAgnAgmtVOUSQL(), param, velParam);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}

	/**
	 * ESM_AGT_003) Agreement 의 정보를 Agt_Agn_Agmt Table 에 Delete 한다.
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int deletemultiAgentRateInfo(AgtAgnAgmtVO agtAgnAgmtVO)
			throws DAOException, Exception {
		// TODO Auto-generated method stub
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int delCnt = 0;
		try {
			if (agtAgnAgmtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			delCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementDBDAOAgtAgnAgmtVODSQL(), param, velParam);
			if (delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
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
	 * ESM_AGT_003) Agreement 의 정보를 Agt_Agn_Agmt Table 에 Delete 한다.
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return AgtAgnAgmtVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public AgtAgnAgmtVO searchAgentRateInfoAgnAgmtVerSeq(AgtAgnAgmtVO agtAgnAgmtVO) throws DAOException, Exception{
	    // TODO Auto-generated method stub
		DBRowSet dbRowSet = null;
		List<AgtAgnAgmtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		AgtAgnAgmtVO result = null;
		try {
			if (agtAgnAgmtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate) new AGTOfficeAgreementDBDAOAgentRateAgnAgmtVerSeqRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowSet, AgtAgnAgmtVO.class);
			if(list.size()>0){
				result = list.get(0);
			}
		}catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
    }
	/**
	 * (ESM_AGT_003) Agreement 의 정보를 Agt_Agn_Agmt Table 에 Copy한다.<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int copyAgentRateInfoAgtAgnAgmt(AgtAgnAgmtVO agtAgnAgmtVO)
			throws DAOException, Exception {
		// TODO Auto-generated method stub
		int insCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (agtAgnAgmtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementDBDAOAgtAgnAgmtVO2CSQL(),param, null);
			if (insCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * (ESM_AGT_003) (Agreement Copy Event) Agreement 의 정보를 Agt_Agn_Agmt_Rt Table 에 Copy한다.<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int copyAgentRateInfoAgtAgnAgmtRt(AgtAgnAgmtVO agtAgnAgmtVO) throws DAOException, Exception{
	    // TODO Auto-generated method stub
		int insCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (agtAgnAgmtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementDBDAOAgtAgnAgmtRtCopyVOCSQL(),param, null);
			if (insCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * (ESM_AGT_003) (Agreement Copy Event) Agreement 의 정보를 Agt_Agn_Agmt_Rt Table 에 Copy한다.<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int copyAgentRateInfoAgtAgnRoutRef(AgtAgnAgmtVO agtAgnAgmtVO) throws DAOException, Exception{
	    // TODO Auto-generated method stub
		int insCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (agtAgnAgmtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementDBDAOAgtAgnAgmtRoutRefCopyVOCSQL(),param, null);
			if (insCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * (ESM_AGT_003) (Agreement Copy Event) Agreement 의 정보를 Agt_Agn_Agmt_Rt Table 에 Copy한다.<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int copyAgentRateInfoAgtAgnChgRef(AgtAgnAgmtVO agtAgnAgmtVO) throws DAOException, Exception{
	    // TODO Auto-generated method stub
		int insCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (agtAgnAgmtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementDBDAOAgtAgnChgRefCopyVOCSQL(),param, null);
			if (insCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * (ESM_AGT_003) (Agreement Copy Event) Agreement 의 정보를 Agt_Agn_Agmt_Rt Table 에 Copy한다.<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int copyAgentRateInfoAgtAgnCtrtRef(AgtAgnAgmtVO agtAgnAgmtVO) throws DAOException, Exception{
	    // TODO Auto-generated method stub
		int insCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (agtAgnAgmtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementDBDAOAgtAgnCtrtRefCopyVOCSQL(),param, null);
			if (insCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * (ESM_AGT_003) (Agreement Copy Event) Agreement 의 정보를 Agt_Agn_Agmt_Rt Table 에 Copy한다.<br>
	 * 
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int copyAgentRateInfoAgtAgnOtrRef(AgtAgnAgmtVO agtAgnAgmtVO) throws DAOException, Exception{
	    // TODO Auto-generated method stub
		int insCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (agtAgnAgmtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementDBDAOAgtAgnOtrRefCopyVOCSQL(),param, null);
			if (insCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * (ESM_AGT_003) Agreement 의 정보를 Agt_Agn_Agmt_Rt Table 에 Max Agn_Seq 조회한다.<br>
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return AgtAgnAgmtRtVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public AgtAgnAgmtRtVO searchAgtAgnAgmtRtAgnSeq(AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws DAOException, Exception{
		// TODO Auto-generated method stub
		DBRowSet dbRowSet = null;
		List<AgtAgnAgmtRtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		AgtAgnAgmtRtVO result = null;
		try {
			if (agtAgnAgmtRtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate) new AGTOfficeAgreementDBDAOAgtAgnAgmtRtAgnSeqVORSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowSet, AgtAgnAgmtRtVO.class);
			if(list.size()>0){
				result = list.get(0);
			}
		}catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
		
	}
	/**
	 * AGTOfficeAgreementDBDAOAgtAgnAgmtRtVOCSQL
	 * (ESM_AGT_003) Agreement Rt 의 정보를 Agt_Agn_Agmt_Rt Table 에 저장
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addmultiRowCopySaveAgtAgnAgmtRt(AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws DAOException, Exception{
		int insCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if (agtAgnAgmtRtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementDBDAOAgtAgnAgmtRtVOCSQL(),param, null);
			if (insCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * 	AGTOfficeAgreementDBDAOAgtAgnAgmtRtVOUSQL
	 * (ESM_AGT_003) Agreement Rt 의 정보를 Agt_Agn_Agmt_Rt 수정
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifymultiRowCopySaveAgtAgnAgmtRt(AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws DAOException, Exception{
	    // TODO Auto-generated method stub
		int updCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if (agtAgnAgmtRtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			updCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementDBDAOAgtAgnAgmtRtVOUSQL(),param, null);
			if (updCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
    }
	/**
	 * AGTOfficeAgreementDBDAOAgtAgnAgmtRtVODSQL
	 * (ESM_AGT_003) Agreement Rt 의 정보를 Agt_Agn_Agmt_Rt 삭제
	 * @param AgtAgnAgmtRtVO agtAgnAgmtRtVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int deletemultiRowCopySaveAgtAgnAgmtRt(AgtAgnAgmtRtVO agtAgnAgmtRtVO) throws DAOException, Exception{
	    // TODO Auto-generated method stub
	    int delCnt = 0;
	    Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if (agtAgnAgmtRtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtRtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			delCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementDBDAOAgtAgnAgmtRtVODSQL(),param, null);
			if (delCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * AGTOfficeAgreementDBDAOAgtAgnAgmtChgRefVOCSQL
	 * ESM_AGT_003) Agreement Rt 의 정보를 Agt_Agn_Agmt_Chg_Ref 테이블에 입력
	 * @param AgtAgnChgRefVO agtAgnChgRefVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addmultiRowCopySaveAgtAgnChgRef(AgtAgnChgRefVO agtAgnChgRefVO) throws DAOException, Exception{
	    // TODO Auto-generated method stub
		int insCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if (agtAgnChgRefVO != null) {
				Map<String, String> mapVO = agtAgnChgRefVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementDBDAOAgtAgnAgmtChgRefVOCSQL(),param, null);
			if (insCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * AGTOfficeAgreementDBDAOAgtAgnAgmtChgRefVOCSQL
	 * ESM_AGT_003) Agreement Rt 의 정보를 Agt_Agn_Agmt_Chg_Ref 테이블에 입력
	 * @param AgtAgnOtrRefVO agtAgnOtrRefVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception.
	 */
	public int addmultiRowCopySaveAgtAgnOtrRef(AgtAgnOtrRefVO agtAgnOtrRefVO) throws DAOException, Exception{
	    // TODO Auto-generated method stub
	    int insCnt = 0;
	    // query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if (agtAgnOtrRefVO != null) {
				Map<String, String> mapVO = agtAgnOtrRefVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementDBDAOAgtAgnAgmtOtrRefVOCSQL(),param, null);
			if (insCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		}catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    return insCnt;
    }
	/**
	 * AGTOfficeAgreementDBDAOAgtAgnAgmtChgRefVOCSQL
	 * ESM_AGT_003) Agreement Rt 의 정보를 Agt_Agn_Agmt_Chg_Ref 테이블에 입력
	 * @param AgtAgnCtrtRefVO agnCtrtRefVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addmultiRowCopySaveAgtAgnCtrtRef(AgtAgnCtrtRefVO agnCtrtRefVO) throws DAOException, Exception{
	    // TODO Auto-generated method stub
		int insCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if (agnCtrtRefVO != null) {
				Map<String, String> mapVO = agnCtrtRefVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementDBDAOAgtAgnAgmtCtrtRefVOCSQL(),param, null);
			if (insCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		}catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	    
    }
	/**
	 * AGTOfficeAgreementDBDAOAgtAgnAgmtChgRefVOCSQL
	 * ESM_AGT_003) Agreement Rt 의 정보를 Agt_Agn_Agmt_Chg_Ref 테이블에 입력
	 * @param AgtAgnRoutRefVO agtAgnRoutRefVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addmultiRowCopySaveAgtAgnRoutRef(AgtAgnRoutRefVO agtAgnRoutRefVO) throws DAOException, Exception{
	    // TODO Auto-generated method stub
		int insCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if (agtAgnRoutRefVO != null) {
				Map<String, String> mapVO = agtAgnRoutRefVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementDBDAOAgtAgnAgmtRoutRefVOCSQL(),param, null);
			if (insCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		}catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
    }
	/**
	 * AGTOfficeAgreementDBDAOAgtAgnAgmtChgRefVOCSQL
	 * ESM_AGT_003) Agreement Rt 의 정보를 Agt_Agn_Agmt_Chg_Ref 테이블에 입력
	 * @param AgtAgnOtrRefVO agtAgnOtrRefVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int deletemultiRowCopySaveAgtAgnOtrRef(AgtAgnOtrRefVO agtAgnOtrRefVO) throws DAOException, Exception{
	    // TODO Auto-generated method stub
		int delCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if (agtAgnOtrRefVO != null) {
				Map<String, String> mapVO = agtAgnOtrRefVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			delCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementDBDAOAgtAgnAgmtOtrRefVODSQL(),param, null);
			if (delCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		}catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	    
    }
	/**
	 * AGTOfficeAgreementDBDAOAgtAgnAgmtChgRefVOCSQL
	 * ESM_AGT_003) Agreement Rt 의 정보를 Agt_Agn_Agmt_Chg_Ref 테이블에 입력
	 * @param AgtAgnCtrtRefVO agtAgnCtrtRefVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int deletemultiRowCopySaveAgtAgnCtrtRef(AgtAgnCtrtRefVO agtAgnCtrtRefVO) throws DAOException, Exception{
	    // TODO Auto-generated method stub
		int delCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if (agtAgnCtrtRefVO != null) {
				Map<String, String> mapVO = agtAgnCtrtRefVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			delCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementDBDAOAgtAgnAgmtCtrtRefVODSQL(),param, null);
			if (delCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		}catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt; 
	    
    }
	/**
	 * AGTOfficeAgreementDBDAOAgtAgnAgmtChgRefVOCSQL
	 * ESM_AGT_003) Agreement Rt 의 정보를 Agt_Agn_Agmt_Chg_Ref 테이블에 입력
	 * @param AgtAgnChgRefVO agtAgnChgRefVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int deletemultiRowCopySaveAgtAgnChgRef(AgtAgnChgRefVO agtAgnChgRefVO) throws DAOException, Exception{
	    // TODO Auto-generated method stub
		int delCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if (agtAgnChgRefVO != null) {
				Map<String, String> mapVO = agtAgnChgRefVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			delCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementDBDAOAgtAgnAgmtChgRefVODSQL(),param, null);
			if (delCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		}catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
    }
	/**
	 * AGTOfficeAgreementDBDAOAgtAgnAgmtChgRefVOCSQL
	 * ESM_AGT_003) Agreement Rt 의 정보를 Agt_Agn_Agmt_Chg_Ref 테이블에 입력
	 * @param AgtAgnRoutRefVO agtAgnRoutRefVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int deletemultiRowCopySaveAgtAgnRoutRef(AgtAgnRoutRefVO agtAgnRoutRefVO) throws DAOException, Exception{
	    // TODO Auto-generated method stub
		int delCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if (agtAgnRoutRefVO != null) {
				Map<String, String> mapVO = agtAgnRoutRefVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			delCnt = sqlExe.executeUpdate((ISQLTemplate) new AGTOfficeAgreementDBDAOAgtAgnAgmtRoutRefVODSQL(),param, null);
			if (delCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		}catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt; 
    }
	/**
	 * (ESM_AGT_044) 해당 지점의 Office 인지 체크한다.<br>
	 * @param AgtAgnAgmtVO agtAgnAgmtVO
	 * @param SignOnUserAccount account
	 * @return List<AgtAgnAgmtVO> 
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<AgtAgnAgmtVO> checkAgreementOffice(AgtAgnAgmtVO agtAgnAgmtVO, SignOnUserAccount account) throws DAOException, Exception{
	    // TODO Auto-generated method stub
		DBRowSet dbRowset = null;
		List<AgtAgnAgmtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (agtAgnAgmtVO != null) {
				Map<String, String> mapVO = agtAgnAgmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AGTOfficeInfoAgreementDBDAOCheckAgreementOfficeRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmOrganizationVO.class);
			
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
	 * ESM_AGT_004 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtCntrTypeSizeVO agtCntrTypeSizeVO
	 * @return List<AgtCntrTypeSizeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgtCntrTypeSizeVO> searchOtherInfoListRepType(AgtCntrTypeSizeVO agtCntrTypeSizeVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtCntrTypeSizeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agtCntrTypeSizeVO != null){
				Map<String, String> mapVO = agtCntrTypeSizeVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTOfficeAgreementInfoDBDAOSearchOtherInfoListRepTypeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtCntrTypeSizeVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	 * ESM_AGT_004 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtCntrTypeSizeVO agtCntrTypeSizeVO
	 * @return List<AgtCntrTypeSizeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgtCntrTypeSizeVO> searchOtherInfoSearchList(AgtCntrTypeSizeVO agtCntrTypeSizeVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtCntrTypeSizeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agtCntrTypeSizeVO != null){
				Map<String, String> mapVO = agtCntrTypeSizeVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTOfficeAgreementInfoDBDAOSearchOtherInfoSearchListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtCntrTypeSizeVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	 * ESM_AGT_004 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtCntrTypeSizeVO agtCntrTypeSizeVO
	 * @return List<AgtCntrTypeSizeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgtCntrTypeSizeVO> searchOtherInfoListRepSize(AgtCntrTypeSizeVO agtCntrTypeSizeVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtCntrTypeSizeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agtCntrTypeSizeVO != null){
				Map<String, String> mapVO = agtCntrTypeSizeVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTOfficeAgreementInfoDBDAOSearchOtherInfoListRepSizeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtCntrTypeSizeVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	 * ESM_AGT_004 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtCntrTypeSizeVO agtCntrTypeSizeVO
	 * @return List<AgtCntrTypeSizeVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgtCntrTypeSizeVO> searchOtherInfoListTypeSize(AgtCntrTypeSizeVO agtCntrTypeSizeVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtCntrTypeSizeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agtCntrTypeSizeVO != null){
				Map<String, String> mapVO = agtCntrTypeSizeVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTOfficeAgreementInfoDBDAOSearchOtherInfoListTypeSizeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtCntrTypeSizeVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * ESM_AGT_005 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtChargeDeductionVO agtChargeDeductionVO
	 * @return List<AgtChargeDeductionVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgtChargeDeductionVO> searchDeductionInfoList(AgtChargeDeductionVO agtChargeDeductionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtChargeDeductionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agtChargeDeductionVO != null){
				Map<String, String> mapVO = agtChargeDeductionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTOfficeAgreementInfoDBDAOSearchDeductionInfoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtChargeDeductionVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * ESM_AGT_005 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtChargeDeductionVO agtChargeDeductionVO
	 * @return List<AgtChargeDeductionVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgtChargeDeductionVO> searchDeductionInfoDetailList(AgtChargeDeductionVO agtChargeDeductionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtChargeDeductionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(agtChargeDeductionVO != null){
				Map<String, String> mapVO = agtChargeDeductionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTOfficeAgreementInfoDBDAOSearchDeductionInfoDetailListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtChargeDeductionVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * ESM_AGT_005 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtChargeDeductionVO agtChargeDeductionVO
	 * @return List<AgtChargeDeductionVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgtChargeDeductionVO> searchDeductionInfoChkDetailChkList(AgtChargeDeductionVO agtChargeDeductionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtChargeDeductionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(agtChargeDeductionVO != null){
				Map<String, String> mapVO = agtChargeDeductionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTOfficeAgreementInfoDBDAOSearchDeductionInfoChkDetailChkListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtChargeDeductionVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

		/**
		 * ESM_AGT_006 화면에 대한 조회 이벤트 처리<br>
		 * 
		 * @param AgtGeogOfcVO agtGeogOfcVO
		 * @return List<AgtGeogOfcVO>
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<AgtGeogOfcVO> searchGeogOfcInfoContiList(AgtGeogOfcVO agtGeogOfcVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<AgtGeogOfcVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(agtGeogOfcVO != null){
				Map<String, String> mapVO = agtGeogOfcVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTOfficeAgreementInfoDBDAOSearchGeogOfcInfoContiListRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtGeogOfcVO .class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
			/**
			 * ESM_AGT_006 화면에 대한 조회 이벤트 처리<br>
			 * 
			 * @param AgtGeogOfcVO agtGeogOfcVO
			 * @return List<AgtGeogOfcVO>
			 * @throws DAOException
			 */
			 @SuppressWarnings("unchecked")
			public List<AgtGeogOfcVO> searchGeogOfcInfoSubContiList(AgtGeogOfcVO agtGeogOfcVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<AgtGeogOfcVO> list = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				if(agtGeogOfcVO != null){
					Map<String, String> mapVO = agtGeogOfcVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTOfficeAgreementInfoDBDAOSearchGeogOfcInfoSubContiListRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtGeogOfcVO .class);
				} catch(SQLException se) {
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				} catch(Exception ex) {
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return list;
			}
	/**
	 * ESM_AGT_006 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtGeogOfcVO agtGeogOfcVO
	 * @return List<AgtGeogOfcVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgtGeogOfcVO> searchGeogOfcInfoCntryList(AgtGeogOfcVO agtGeogOfcVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtGeogOfcVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

	try{
		if(agtGeogOfcVO != null){
			Map<String, String> mapVO = agtGeogOfcVO .getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		}
		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTOfficeAgreementInfoDBDAOSearchGeogOfcInfoCntryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtGeogOfcVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	 * ESM_AGT_006 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtGeogOfcVO agtGeogOfcVO
	 * @return List<AgtGeogOfcVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgtGeogOfcVO> searchGeogOfcInfoLocList(AgtGeogOfcVO agtGeogOfcVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtGeogOfcVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(agtGeogOfcVO != null){
				Map<String, String> mapVO = agtGeogOfcVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTOfficeAgreementInfoDBDAOSearchGeogOfcInfoLocListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtGeogOfcVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	 * ESM_AGT_006 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtGeogOfcVO agtGeogOfcVO
	 * @return List<AgtGeogOfcVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgtGeogOfcVO> searchGeogOfcInfoOfcList(AgtGeogOfcVO agtGeogOfcVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgtGeogOfcVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agtGeogOfcVO != null){
				Map<String, String> mapVO = agtGeogOfcVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTOfficeAgreementInfoDBDAOSearchGeogOfcInfoOfcListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtGeogOfcVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**
	 * ESM_AGT_006 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtAgnOtrRefVO agtAgnOtrRefVO
	 * @return List<AgtAgnOtrRefVO>
	 * @throws DAOException
	 */
	public List<AgtAgnOtrRefVO> searchOtherInfoListInputAgtAgnOtrRef(AgtAgnOtrRefVO agtAgnOtrRefVO) throws DAOException{

		DBRowSet dbRowSet = null;
		List<AgtAgnOtrRefVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(agtAgnOtrRefVO != null){
				Map<String, String> mapVO = agtAgnOtrRefVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTOfficeAgreementInfoDBDAOSearchOtherInfoListInputAgtAgnOtrRefRSQL(), param, velParam); 
			list = (List)RowSetUtil.rowSetToVOs(dbRowSet, AgtAgnOtrRefVO.class);
		}catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	    return list;
    }
	/**
	 * ESM_AGT_006 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtAgnCtrtRefVO agtAgnCtrtRefVO
	 * @return List<AgtAgnCtrtRefVO>
	 * @throws DAOException
	 */
	public List<AgtAgnCtrtRefVO> searchOtherInfoListInputAgtAgnCtrtRef(AgtAgnCtrtRefVO agtAgnCtrtRefVO) throws DAOException{
	    // TODO Auto-generated method stub
		DBRowSet dbRowSet = null;
		List<AgtAgnCtrtRefVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(agtAgnCtrtRefVO != null){
				Map<String, String> mapVO = agtAgnCtrtRefVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTOfficeAgreementInfoDBDAOSearchOtherInfoListInputAgtAgnCntrRefRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowSet, AgtAgnCtrtRefVO.class);
		}catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	    return list;
    }

}