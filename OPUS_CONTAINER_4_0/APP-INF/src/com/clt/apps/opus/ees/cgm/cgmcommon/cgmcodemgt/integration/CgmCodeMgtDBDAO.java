/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CgmCodeMgtDBDAO.java
 *@FileTitle : CgmCodeMgt
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.12
 *@LastModifier : 김창식
 *@LastVersion : 1.0
 * 2009.05.12 김창식
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.basic.CgmCodeMgtBCImpl;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.AgreementINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.AgreementMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.EqOrzChtINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.EqOrzChtMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.MdmOrganizationINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.MdmOrganizationMGTVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * CgmCodeMgtDBDAO <br>
 * - -CgmCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author KIM CHANG SIK
 * @see CgmCodeMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class CgmCodeMgtDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Chassis Pool 로 등록된 Agreement 정보를 조회한다.<br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchAgreementByPoolData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (comboINVO != null) {
				Map<String, String> mapVO = comboINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchAgreementByPoolDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * Chassis Pool 로 등록된 리스트를 조회한다.<br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchPoolListData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (comboINVO != null) {
				Map<String, String> mapVO = comboINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchPoolListDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * CGM_EQ_SPEC 테이블에서 Spec No 리스트를 조회한다..<br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchSpecListData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (comboINVO != null) {
				Map<String, String> mapVO = comboINVO.getColumnValues();
				log.debug("☆★☆ mapVO ---------->> " + mapVO);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchSpecListDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * Chassis 또는 M.G.Set 의 Type Size 목록을 조회한다.<br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchEqTpszListData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (comboINVO != null) {
				Map<String, String> mapVO = comboINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchEqTpszListDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * MDM 테이블에서 Manufacture리스트를 조회한다.<br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchManuListData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (comboINVO != null) {
				Map<String, String> mapVO = comboINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchManuListDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * Neutral Pool 로 등록된 Agreement 리스트를 조회한다.<br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchMgsetNoFindData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (comboINVO != null) {
				Map<String, String> mapVO = comboINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchMgsetNoFindDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * CGM에서 사용하는 공통코드 리스트를 조회한다.<br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchCommonCodeListData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (comboINVO != null) {
				Map<String, String> mapVO = comboINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchCommonCodeListDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * MDM_VENDOR 테이블에서 Vendor Code 및 Name 을 조회한다.<br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchVendorCodeListData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (comboINVO != null) {
				Map<String, String> mapVO = comboINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchVendorCodeListDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * MDM_STATE 테이블에서 미주지역의 State 정보를 조회한다.<br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchStateCodeListData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (comboINVO != null) {
				Map<String, String> mapVO = comboINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchStateCodeListDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * CGM_EQ_LOT 에 등록된 Cert No 리스트를 조회한다..<br>
	 * 
	 * @param mdmOrganizationINVO
	 *            MdmOrganizationINVO
	 * @return List<MdmOrganizationMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MdmOrganizationMGTVO> searchOrganizationData(MdmOrganizationINVO mdmOrganizationINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmOrganizationMGTVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mdmOrganizationINVO != null) {
				Map<String, String> mapVO = mdmOrganizationINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchOrganizationDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmOrganizationMGTVO.class);

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
	 * MDM_ORGANIZATION 테이블 정보를 조회한다.<br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchCertChassisListData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (comboINVO != null) {
				Map<String, String> mapVO = comboINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchCertChassisListDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * MMDM 테이블에서 Financing Company리스트를 조회한다.<br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchFinancingCoData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (comboINVO != null) {
				Map<String, String> mapVO = comboINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchFinancingCoDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * CgmCodeMgtDBDAO의 Agreement No 의 Data 목록을 불러온다.<br>
	 * 
	 * @param agreementINVO
	 *            AgreementINVO
	 * @return List<AgreementMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<AgreementMGTVO> searchAgreementMainData(AgreementINVO agreementINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgreementMGTVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (agreementINVO != null) {
				Map<String, String> mapVO = agreementINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchAgreementMainDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AgreementMGTVO.class);

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
	 * mdm_mvmt_sts 테이블 정보를 조회한다.<br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchMovementStatusListData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (comboINVO != null) {
				Map<String, String> mapVO = comboINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchMovementStatusListDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * CGM Agreement 엔터티에서 NP 로 등록된 계약의 Agreement No (agmt_ofc_cty_cd,agmt_seq),
	 * Vendor sequence, Vendor Name( From MDM_VENDOR.VNDR_LGL_ENG_NM), Reference
	 * No (AGMT_REF_NO) 를 조회한다..<br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchNuPoolListData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (comboINVO != null) {
				Map<String, String> mapVO = comboINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchNuPoolListDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * DATE에 해당하는 PLN_YR, PLN_WK, PLN_MON, WK_ST_DT, WK_END_DT 를 조회한다.<br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchWeekFmToDateData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (comboINVO != null) {
				Map<String, String> mapVO = comboINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchWeekFmToDateDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * WEEK에 해당하는 PLN_YR, PLN_WK, PLN_MON, WK_ST_DT, WK_END_DT 를 조회한다. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchWeekFmToDateByWeekData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (comboINVO != null) {
				Map<String, String> mapVO = comboINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchWeekFmToDateByWeekDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * RCC,LCC,SCC 조회 및 Validation 체크. <br>
	 * 
	 * @param eqOrzChtINVO
	 *            EqOrzChtINVO
	 * @return List<EqOrzChtMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<EqOrzChtMGTVO> searchEqOrzChtData(EqOrzChtINVO eqOrzChtINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EqOrzChtMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (eqOrzChtINVO != null) {
				Map<String, String> mapVO = eqOrzChtINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOsearchEqOrzChtDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EqOrzChtMGTVO.class);
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
	 * COST COFFICE CODE 를 조회한다. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchCostOfficeData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (comboINVO != null) {
				Map<String, String> mapVO = comboINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchCostOfficeDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * Invoice Service Provier를 조회한다. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchInvSerProviderData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (comboINVO != null) {
				Map<String, String> mapVO = comboINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchInvSerProviderDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * Office Code 로 Local Time 을 조회한다. <br>
	 * 
	 * @param comboINVO
	 *            ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchLocalTimeByOfficeData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (comboINVO != null) {
				Map<String, String> mapVO = comboINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchLocalTimeByOfficeDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * @param ComboINVO comboINVO
	 * @return List<ComboMGTVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ComboMGTVO> searchChssPoolCoListData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (comboINVO != null) {
				Map<String, String> mapVO = comboINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOsearchChssPoolCoListDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * @param List<ComboMGTVO> comboMGTVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addChssPoolCoListData(List<ComboMGTVO> comboMGTVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (comboMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new CgmCodeMgtDBDAOAddChssPoolCoDataCSQL(), comboMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * 
	 * @param List<ComboMGTVO> comboMGTVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyChssPoolCoListData(List<ComboMGTVO> comboMGTVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (comboMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new CgmCodeMgtDBDAOModifyChssPoolCoDataUSQL(), comboMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modify No" + i + " SQL");
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
	 * 
	 * @param List<ComboMGTVO> comboMGTVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeChssPoolCoListData(List<ComboMGTVO> comboMGTVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (comboMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new CgmCodeMgtDBDAORemoveChssPoolCoDataDSQL(), comboMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to remove No" + i + " SQL");
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
	 * Local Time을 조회한다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception SQLException
	 * @exception Exception
	 */
	public String searchLocalTimeData(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String result = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ofc_cd", ofcCd);
			velParam.put("ofc_cd", ofcCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOsaerchLocalTimeDataRSQL(), param, velParam);
			if (dbRowset.next()) {
				result = dbRowset.getString("LOC_TIME");
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
}
