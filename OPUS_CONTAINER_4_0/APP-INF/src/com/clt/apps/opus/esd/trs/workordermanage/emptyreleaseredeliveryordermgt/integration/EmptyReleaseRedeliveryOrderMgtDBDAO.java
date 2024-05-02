/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EmptyReleaseRedeliveryOrderMgtDBDAO.java
 *@FileTitle : EmptyReleaseRedeliveryOrderMgtDBDAO
 *Open Issues :
 *Change history : 2009.05.04 (김상수) - ESD_TRS_0428 관련업무 최초생성
 *                 2009.08.18 (김상수) - ESD_TRS_0429 관련업무 추가
 *@LastModifyDate : 2009.08.18
 *@LastModifier : 김상수
 *@LastVersion : 1.2
 * 2009.05.04 김상수
 * 1.0 Creation
 * 2009.07.27 김상수
 * 1.1 Modification
 * 2009.08.18 김상수
 * 1.21 Modification
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.esd.trs.common.util.CommonUtil;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.basic.EmptyReleaseRedeliveryOrderMgtBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.vo.CimCStockVO;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.vo.MdmCountryVO;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.vo.MdmOrganizationVO;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.vo.SearchFaxInfoVO;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.vo.SearchRelredMasterForEdiVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.vo.WorkOrderPreviewVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.MdmYardVO;

/**
 * OPUS EmptyReleaseRedeliveryOrderMgtDBDAO <br>
 * - OPUS-EmptyReleaseRedeliveryOrderMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author KIM, Sang Soo
 * @see EmptyReleaseRedeliveryOrderMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class EmptyReleaseRedeliveryOrderMgtDBDAO extends DBDAOSupport {

	/**
	 * ESD_TRS_0428 : MdmCountry에 해당되는 값을 불러온다.<br>
	 * 
	 * @param MdmCountryVO mdmCountryVO
	 * @return List<MdmCountryVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmCountryVO> selectComboCountry(MdmCountryVO mdmCountryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCountryVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (mdmCountryVO != null) {
				Map<String, String> mapVO = mdmCountryVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOMdmCountryVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmCountryVO.class);
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
	 * ESD_TRS_0428 : MdmOrganization에 해당되는 값을 불러온다.<br>
	 * 
	 * @param MdmOrganizationVO mdmOrganizationVO
	 * @return List<MdmOrganizationVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmOrganizationVO> selectComboOrganization(MdmOrganizationVO mdmOrganizationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmOrganizationVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mdmOrganizationVO != null) {
				Map<String, String> mapVO = mdmOrganizationVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOMdmOrganizationVORSQL(), param, velParam);
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
	 * ESD_TRS_0429 : Issued Release List를 조회<br>
	 * 
	 * @param CimCStockVO cimCStockVO
	 * @return List<AbstractValueObject>
	 * @throws DAOException
	 */
	public List<AbstractValueObject> searchIssuedReleaseList(CimCStockVO cimCStockVO) throws DAOException {
		try {
			Map<String, String> mapVO = cimCStockVO.getColumnValues();
			return new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchIssuedReleaseListRSQL(), mapVO, mapVO, CimCStockVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESD_TRS_0429 : Issued Redelivery List를 조회<br>
	 * 
	 * @param CimCStockVO cimCStockVO
	 * @return List<CimCStockVO>
	 * @throws DAOException
	 */
	public List<AbstractValueObject> searchIssuedReDeliveryList(CimCStockVO cimCStockVO) throws DAOException {
		try {
			Map<String, String> mapVO = cimCStockVO.getColumnValues();
			return new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseReDeliveryOrderMgtDBDAOSearchIssuedReDeliveryListRSQL(), mapVO, mapVO, CimCStockVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESD_TRS_0429 : Settle 대상 Release CH List를 조회<br>
	 * 
	 * @param CimCStockVO cimCStockVO
	 * @return List<CimCStockVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CimCStockVO> searchSettleReleaseCHList(CimCStockVO cimCStockVO) throws DAOException {
		List<CimCStockVO> list = null;
		try {
			Map<String, String> mapVO = cimCStockVO.getColumnValues();
			DBRowSet dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchSettleReleaseCHListRSQL(), mapVO, mapVO);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CimCStockVO.class);
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
	 * ESD_TRS_0429 : Settle 대상 Release MH List를 조회<br>
	 * 
	 * @param CimCStockVO cimCStockVO
	 * @return List<CimCStockVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CimCStockVO> searchSettleReleaseMHList(CimCStockVO cimCStockVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CimCStockVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cimCStockVO != null) {
				Map<String, String> mapVO = cimCStockVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchSettleReleaseMHListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CimCStockVO.class);
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
	 * ESD_TRS_0429 : Settle 대상 Release RP List를 조회<br>
	 * 
	 * @param CimCStockVO cimCStockVO
	 * @return List<CimCStockVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CimCStockVO> searchSettleReleaseRPList(CimCStockVO cimCStockVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CimCStockVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cimCStockVO != null) {
				Map<String, String> mapVO = cimCStockVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchSettleReleaseRPListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CimCStockVO.class);
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
	 * ESD_TRS_0429 : Settle 대상 Release ST List를 조회<br>
	 * 
	 * @param CimCStockVO cimCStockVO
	 * @return List<CimCStockVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CimCStockVO> searchSettleReleaseSTList(CimCStockVO cimCStockVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CimCStockVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cimCStockVO != null) {
				Map<String, String> mapVO = cimCStockVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchSettleReleaseSTListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CimCStockVO.class);
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
	 * ESD_TRS_0429 : Issued Order List를 다건 settle<br>
	 * 
	 * @param List<CimCStockVO> cimCStockVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifySettleIssuedOrders(List<CimCStockVO> cimCStockVOs) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter();
			if (cimCStockVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOManageSettleIssuedOrderUSQL(), cimCStockVOs, null);
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
	 * ESD_TRS_0429 : RD fax내용에 사용될 Header 정보를 조회<br>
	 * 
	 * @param String UserLocCd
	 * @param String userOfcCd
	 * @param String userCntCd
	 * @return List<SearchFaxInfoVO>
	 * @throws DAOException
	 */
	public String[] searchFaxInfoHeader(String userLocCd, String userOfcCd, String userCntCd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		String[] returnValues = new String[3];

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("user_loc", userLocCd);
			mapVO.put("user_ofc", userOfcCd);
			mapVO.put("user_cnt", userCntCd);

			param.putAll(mapVO);
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxInfoHeaderRSQL(), param, null);
			if (dbRowset.next()) {
				returnValues[0] = dbRowset.getString("OFC_ENG_NM");
				returnValues[1] = dbRowset.getString("ADDRESS");
				returnValues[2] = dbRowset.getString("LOCAL_TIME");
			} else {
				returnValues[0] = "";
				returnValues[1] = "";
				returnValues[2] = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValues;
	}

	/**
	 * ESD_TRS_0429 : RD fax 상세내용 목록을 조회<br>
	 * 
	 * @param CimCStockVO cimCStockVO
	 * @return List<SearchFaxInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchFaxInfoVO> searchFaxInfoDetailList(CimCStockVO cimCStockVO) throws DAOException {
		List<SearchFaxInfoVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (cimCStockVO != null) {
				param.putAll(cimCStockVO.getColumnValues());
				DBRowSet dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxInfoDetailListRSQL(), param, null);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchFaxInfoVO.class);
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
	 * ESD_TRS_0429 : fax전송 후 저장할 Release - C - Issue 대상을 조회<br>
	 * 
	 * @param CimCStockVO cimCStockVO
	 * @return List<CimCStockVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CimCStockVO> searchFaxEmailReleaseCIssued(CimCStockVO cimCStockVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CimCStockVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cimCStockVO != null) {
				Map<String, String> mapVO = cimCStockVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxEmailReleaseCIssuedListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CimCStockVO.class);
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
	 * ESD_TRS_0429 : fax전송 후 저장할 Release - C - Reissue 대상을 조회<br>
	 * 
	 * @param CimCStockVO cimCStockVO
	 * @return List<CimCStockVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CimCStockVO> searchFaxEmailReleaseCReissued(CimCStockVO cimCStockVO) throws DAOException {
		List<CimCStockVO> list = null;
		try {
			Map<String, String> mapVO = cimCStockVO.getColumnValues();
			DBRowSet dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxEmailReleaseCReissueListRSQL(), mapVO, mapVO);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CimCStockVO.class);
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
	 * ESD_TRS_0429 : fax전송 후 저장할 Release - M - Issue 대상을 조회<br>
	 * 
	 * @param CimCStockVO cimCStockVO
	 * @return List<CimCStockVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CimCStockVO> searchFaxEmailReleaseMIssued(CimCStockVO cimCStockVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CimCStockVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (cimCStockVO != null) {
				Map<String, String> mapVO = cimCStockVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxEmailReleaseMIssuedListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CimCStockVO.class);
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
	 * ESD_TRS_0429 : fax전송 후 저장할 Release - M - Reissue 대상을 조회<br>
	 * 
	 * @param CimCStockVO cimCStockVO
	 * @return List<CimCStockVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CimCStockVO> searchFaxEmailReleaseMReissued(CimCStockVO cimCStockVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CimCStockVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cimCStockVO != null) {
				Map<String, String> mapVO = cimCStockVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxEmailReleaseMReissueListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CimCStockVO.class);
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
	 * ESD_TRS_0429 : fax전송 후 저장할 Release - R,S - Issue 대상을 조회<br>
	 * 
	 * @param CimCStockVO cimCStockVO
	 * @return List<CimCStockVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CimCStockVO> searchFaxEmailReleaseRSIssued(CimCStockVO cimCStockVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CimCStockVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cimCStockVO != null) {
				Map<String, String> mapVO = cimCStockVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxEmailReleaseRSIssuedListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CimCStockVO.class);
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
	 * ESD_TRS_0429 : fax전송 후 저장할 Release - R,S - Reissued 대상을 조회<br>
	 * 
	 * @param CimCStockVO cimCStockVO
	 * @return List<CimCStockVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CimCStockVO> searchFaxEmailReleaseRSReissued(CimCStockVO cimCStockVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CimCStockVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cimCStockVO != null) {
				Map<String, String> mapVO = cimCStockVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxEmailReleaseRSReissueListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CimCStockVO.class);
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
	 * ESD_TRS_0429 : fax전송 후 저장할 Release - D - Issued 내용을 조회<br>
	 * 
	 * @param CimCStockVO cimCStockVO
	 * @return List<CimCStockVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CimCStockVO> searchFaxEmailReleaseDIssued(CimCStockVO cimCStockVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CimCStockVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cimCStockVO != null) {
				Map<String, String> mapVO = cimCStockVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxEmailReleaseDIssuedListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CimCStockVO.class);
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
	 * ESD_TRS_0429 : fax전송 후 저장할 Release - D - Reissued 내용을 조회<br>
	 * 
	 * @param CimCStockVO cimCStockVO
	 * @return List<CimCStockVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CimCStockVO> searchFaxEmailReleaseDReissued(CimCStockVO cimCStockVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CimCStockVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cimCStockVO != null) {
				Map<String, String> mapVO = cimCStockVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchFaxEmailReleaseDReissueListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CimCStockVO.class);
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
	 * ESD_TRS_0429 : fax결과 정보를 다건 생성 (STOCK테이블)<br>
	 * 
	 * @param List<CimCStockVO> cimCStockVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addSendReleaseRedeliveryFaxEmail(List<CimCStockVO> cimCStockVOs) throws DAOException, Exception {
		// velocity parameter
		Map<String, Object> velParams = null;
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter();
			if (cimCStockVOs.size() > 0) {
				velParams = new HashMap<String, Object>();
				Map<String, String> mapVO = cimCStockVOs.get(0).getColumnValues();
				velParams.putAll(mapVO);
				insCnt = sqlExe.executeBatch((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOManageSTKSendFaxEmailCSQL(), cimCStockVOs, velParams);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
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
	 * ESD_TRS_0429 : fax결과 정보를 다건 갱신 (STOCK테이블)<br>
	 * 
	 * @param List<CimCStockVO> cimCStockVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifySendReleaseRedeliveryFaxEmail(List<CimCStockVO> cimCStockVOs) throws DAOException, Exception {
		Map<String, Object> velParams = null;
		int updCnt[] = null;
		try {
			if (cimCStockVOs.size() > 0) {
				velParams = new HashMap<String, Object>();
				Map<String, String> mapVO = cimCStockVOs.get(0).getColumnValues();
				velParams.putAll(mapVO);
				updCnt = new SQLExecuter().executeBatch((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOManageSTKSendFaxEmailUSQL(), cimCStockVOs, velParams);
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
	 * ESD_TRS_0429 : fax결과 정보를 다건 삭제 (STOCK테이블)<br>
	 * 
	 * @param List<CimCStockVO> cimCStockVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeSendReleaseRedeliveryFaxEmail(List<CimCStockVO> cimCStockVOs) throws DAOException, Exception {
		Map<String, Object> velParams = null;
		int delCnt[] = null;
		try {
			if (cimCStockVOs.size() > 0) {
				velParams = new HashMap<String, Object>();
				Map<String, String> mapVO = cimCStockVOs.get(0).getColumnValues();
				velParams.putAll(mapVO);

				delCnt = new SQLExecuter().executeBatch((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOManageSTKSendFaxEmailDSQL(), cimCStockVOs, velParams);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
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
	 * ESD_TRS_0429 : fax결과 정보를 다건 생성 (STOCK테이블)<br>
	 * 
	 * @param List<CimCStockVO> cimCStockVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addManageSTKSendFaxEmails(List<CimCStockVO> cimCStockVOs) throws DAOException, Exception {
		// velocity parameter
		Map<String, Object> velParams = null;
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter();
			if (cimCStockVOs.size() > 0) {
				velParams = new HashMap<String, Object>();
				Map<String, String> mapVO = cimCStockVOs.get(0).getColumnValues();
				velParams.putAll(mapVO);
				insCnt = sqlExe.executeBatch((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOManageSTKSendFaxEmailCSQL(), cimCStockVOs, velParams);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
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
	 * ESD_TRS_0429 : fax결과 정보를 다건 갱신 (STOCK테이블)<br>
	 * 
	 * @param List<CimCStockVO> cimCStockVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyManageSTKSendFaxEmails(List<CimCStockVO> cimCStockVOs) throws DAOException, Exception {
		// velocity parameter
		Map<String, Object> velParams = null;
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter();
			if (cimCStockVOs.size() > 0) {
				velParams = new HashMap<String, Object>();
				Map<String, String> mapVO = cimCStockVOs.get(0).getColumnValues();
				velParams.putAll(mapVO);
				updCnt = sqlExe.executeBatch((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOManageSTKSendFaxEmailUSQL(), cimCStockVOs, velParams);
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
	 * ESD_TRS_0429 : fax결과 정보를 다건 삭제 (STOCK테이블)<br>
	 * 
	 * @param List<CimCStockVO> cimCStockVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeManageSTKSendFaxEmails(List<CimCStockVO> cimCStockVOs) throws DAOException, Exception {
		// velocity parameter
		Map<String, Object> velParams = null;
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter();
			if (cimCStockVOs.size() > 0) {
				velParams = new HashMap<String, Object>();
				Map<String, String> mapVO = cimCStockVOs.get(0).getColumnValues();
				velParams.putAll(mapVO);

				delCnt = sqlExe.executeBatch((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOManageSTKSendFaxEmailDSQL(), cimCStockVOs, velParams);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
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
	 * ESD_TRS_0429 : (Redelivery - M - Issued) So_Ofc와 NextVAL을 조회<br>
	 * 
	 * @param String userOfcCd
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] getSoOfcNextVal(String userOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] returnValues = new String[2];

		try {
			if (userOfcCd != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("user_ofc", userOfcCd);

				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOGetSoSeqRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValues[0] = dbRowset.getString("SO_OFC_CTY_CD");
				returnValues[1] = dbRowset.getString("SO_SEQ");
			} else {
				returnValues[0] = "";
				returnValues[1] = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValues;
	}

	/**
	 * ESD_TRS_0429 : 사용자ID로 LOC_CD를 조회<br>
	 * 
	 * @param userId
	 * @return
	 * @throws DAOException
	 */
	public String getUserLocCd(String userId) throws DAOException {
		Map<String, String> mapVO = new HashMap<String, String>();
		String returnValue = "";
		try {
			mapVO.put("user_id", userId);
			DBRowSet dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOGetUserLocCdRSQL(), mapVO, null);
			if (dbRowset != null && dbRowset.next()) {
				returnValue = dbRowset.getString("loc_cd");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * CTM Common : CTM MOVEMENT 등록시 서버가 EUR인경우 STOCK Update.<br>
	 * 
	 * @param CrossItemVO crossItemVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateCimCntrStk(CrossItemVO crossItemVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		CusCtmMovementVO cusCtmMovementVO = crossItemVO.getCusCtmMovementVO();
		int result = 0;
		try {
			Map<String, String> mapVO = cusCtmMovementVO.getColumnValues();
			mapVO.put("prev_sts_cd", crossItemVO.getPrevSts());
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter();
			result = sqlExe.executeUpdate((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOupdateCimCntrStkUSQL(), param, velParam);
			if (result == 0 && (cusCtmMovementVO.getMvmtStsCd().equals("EN") || cusCtmMovementVO.getMvmtStsCd().equals("TN"))) {
				// EN/ 혹은 TN이고 실행 결과가 0인 경우 prev_sts_cd를 지우고 다시 실행
				param.put("prev_sts_cd", "");
				velParam.put("prev_sts_cd", "");
				result = sqlExe.executeUpdate((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOupdateCimCntrStkUSQL(), param, velParam);
			} else if (result == 0 && cusCtmMovementVO.getMvmtStsCd().equals("OP")) {
				if (cusCtmMovementVO.getCntrTpszCd().equals("D4")) {
					cusCtmMovementVO.setCntrTpszCd("D5");
					result = sqlExe.executeUpdate((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOupdateCimCntrStkUSQL(), param, velParam);
				} else if (cusCtmMovementVO.getCntrTpszCd().equals("D5")) {
					cusCtmMovementVO.setCntrTpszCd("D4");
					result = sqlExe.executeUpdate((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOupdateCimCntrStkUSQL(), param, velParam);
				}
			}
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
	 * ESD_TRS_0429 : 사용자ID로 Default Email을 조회 (Account Email정보와 다름)<br>
	 * 
	 * @param String userId
	 * @return String
	 * @throws DAOException
	 */
	public String getUserDefaultEmail(String userId) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String returnValue = "";
		try {
			param.put("user_id", userId);
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOGetUserDefaultEmailRSQL(), param, null);
			if (dbRowset.next()) {
				returnValue = dbRowset.getString(1) + "";
			} else {
				returnValue = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * ESD_TRS_0429 : Yard Code로 해당Yard의 FAX No와 Email가져옴<br>
	 * 
	 * @param String yardCd
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] getYardFaxEmailInfo(String yardCd) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String[] returnValues = { "", "", "", "" };
		try {
			param.put("empty_cy", yardCd);
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOGetYardFaxEmailInfoRSQL(), param, null);
			if (dbRowset.next()) {
				returnValues[0] = dbRowset.getString("yd_cd");
				returnValues[1] = dbRowset.getString("fax_no");
				returnValues[2] = dbRowset.getString("yd_eml");
				returnValues[3] = dbRowset.getString("yd_nm");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValues;
	}

	/**
	 * ESD_TRS_0429 : RD Content저장을 위한 Seq 조회<br>
	 * 
	 * @return String
	 * @throws DAOException
	 */
	public String getCimFaxMailSendSeq() throws DAOException {
		String returnValue = "";
		try {
			DBRowSet dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchCimFaxMailSendSeqRSQL(), null, null);
			dbRowset.next();
			returnValue = dbRowset.getString("cim_fax_mail_send_seq");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * ESD_TRS_0429 : RD Content를 저장<br>
	 * 
	 * @param String stkFaxSndNo
	 * @param String paraInfoCtnt
	 * @param String stkIssCd
	 * @param String senderUsrId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCimFaxSndInfo(String stkFaxSndNo, String paraInfoCtnt, String stkIssCd, String senderUsrId) throws DAOException, Exception {
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("stk_fax_snd_no", stkFaxSndNo);
			mapVO.put("para_info_ctnt", paraInfoCtnt);
			mapVO.put("stk_iss_cd", stkIssCd);
			mapVO.put("sender_usr_id", senderUsrId);
			new SQLExecuter().executeUpdate((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOManageCimFaxSndInfoCSQL(), mapVO, mapVO);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new Exception(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESD_TRS_0429 : RD Content를 수정<br>
	 * 저장된 RD Content에 Fax/Mail키를 update
	 * 
	 * @param String stkFaxSndNo
	 * @param String faxSndNo
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyCimFaxSndInfo(String stkFaxSndNo, String faxSndNo) throws DAOException, Exception {
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("stk_fax_snd_no", stkFaxSndNo);
			mapVO.put("fax_snd_no", faxSndNo);
			new SQLExecuter().executeUpdate((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOManageCimFaxSndInfoUSQL(), mapVO, mapVO);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new Exception(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESD_TRS_0429 : RD Content를 조회<br>
	 * 
	 * @param String stkFaxSndNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchCimFaxSndInfo(String stkFaxSndNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		String returnValue = "";
		try {
			param.put("stk_fax_snd_no", stkFaxSndNo);
			DBRowSet dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchCimFaxSndInfoRSQL(), param, param);
			if (dbRowset.next()) {
				returnValue = dbRowset.getString("para_info_ctnt");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * ESD_TRS_0429 : Receiver Id를 조회<br>
	 * 
	 * @param cimCStockVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchEdiRcvId(SearchRelredMasterForEdiVO cimCStockVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		String returnValue = "";
		try {
			param.put("yard_cd", cimCStockVO.getEmptyCy());
			param.put("trsp_cost_dtl_mod_cd", cimCStockVO.getTrspCostDtlModCd());
			DBRowSet dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchEdiRcvIdRSQL(), param, param);
			if (dbRowset.next()) {
				returnValue = dbRowset.getString("EDI_RCV_ID");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * searchMdmYardInfo<br>
	 * 
	 * @param String emptyCy
	 * @return mdmYardVO
	 */
	public MdmYardVO searchMdmYardInfo(String emptyCy) {
		Map<String, String> param = new HashMap<String, String>();
		MdmYardVO mdmYardVO = new MdmYardVO();
		try {
			param.put("yard_cd", emptyCy);
			DBRowSet dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchMdmYardInfoRSQL(), param, null);
			if (dbRowset.next()) {
				mdmYardVO.setYdCd(dbRowset.getString("yd_cd"));
				mdmYardVO.setYdNm(dbRowset.getString("yd_nm"));
				mdmYardVO.setFaxNo(dbRowset.getString("fax_no"));
				mdmYardVO.setYdEml(dbRowset.getString("yd_eml"));
			}
		} catch (SQLException se) {
			log.error(se.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
		return mdmYardVO;

	}

	/**
	 * ESD_TRS_0429 : Sender Id를 조회<br>
	 * 
	 * @param rcvId
	 * @param cimCStockVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchEdiSndId(String rcvId, SearchRelredMasterForEdiVO cimCStockVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		String returnValue = "";
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("rcv_id", rcvId);
			mapVO.put("yard_cd", cimCStockVO.getEmptyCy());
			mapVO.put("trsp_cost_dtl_mod_cd", cimCStockVO.getTrspCostDtlModCd());

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchEdiSndIdRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue = dbRowset.getString("HOST_TP_ID");
			} else {
				returnValue = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * ESD_TRS_0429 : 각종 desc를 조회<br>
	 * 
	 * @param String emptyCy
	 * @param String vvd
	 * @param String pol
	 * @param String pod
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchEdiDesc(String emptyCy, String vvd, String pol, String pod) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		String[] returnValue = new String[12];
		try {
			param.put("empty_cy", emptyCy);
			param.put("vvd", vvd);
			param.put("pol", pol);
			param.put("pod", pod);
			DBRowSet dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchEdiDescRSQL(), param, param);
			if (dbRowset.next()) {
				returnValue[0] = dbRowset.getString("MTY_CY_DESC");
				returnValue[1] = dbRowset.getString("VSL_CALL");
				returnValue[2] = dbRowset.getString("VSL_NAME");
				returnValue[3] = dbRowset.getString("POL_DESC");
				returnValue[4] = dbRowset.getString("POD_DESC");
				returnValue[5] = dbRowset.getString("VVD_ETD");
				returnValue[6] = dbRowset.getString("VVD_ETA");
				returnValue[7] = dbRowset.getString("EQREL_LOC");
				returnValue[8] = dbRowset.getString("EQREL_NAME");
				returnValue[9] = dbRowset.getString("VSL_LOYD");
				returnValue[10] = dbRowset.getString("CONSORT_VOY_O");
				returnValue[11] = dbRowset.getString("CONSORT_VOY_I");
			} else {
				returnValue[0] = "";
				returnValue[1] = "";
				returnValue[2] = "";
				returnValue[3] = "";
				returnValue[4] = "";
				returnValue[5] = "";
				returnValue[6] = "";
				returnValue[7] = "";
				returnValue[8] = "";
				returnValue[9] = "";
				returnValue[10] = "";
				returnValue[11] = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * ESD_TRS_0429 : Bkg_Rf_Cgo 테이블을 조회<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchBkgRfCgoforEdi(String bkgNo, String cntrNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		String[] returnValue = new String[11];
		try {
			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			DBRowSet dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgRfCgoforEdiRSQL(), param, param);
			if (dbRowset.next()) {
				returnValue[0] = dbRowset.getString("FDO_TEMP");
				returnValue[1] = dbRowset.getString("CDO_TEMP");
				returnValue[2] = dbRowset.getString("VLTG_NO");
				returnValue[3] = dbRowset.getString("HUMID_NO");
				returnValue[4] = dbRowset.getString("DIFF_RMK");
				returnValue[5] = dbRowset.getString("CNTR_DRN_CD");
				returnValue[6] = dbRowset.getString("PWR_SPL_CBL_FLG");
				returnValue[7] = dbRowset.getString("CNTR_VENT_TP_CD");
				returnValue[8] = dbRowset.getString("VENT_RTO");
				returnValue[9] = dbRowset.getString("VENT_CMH");
				returnValue[10] = "TRUE";
			} else {
				returnValue[0] = "";
				returnValue[1] = "";
				returnValue[2] = "";
				returnValue[3] = "";
				returnValue[4] = "";
				returnValue[5] = "";
				returnValue[6] = "";
				returnValue[7] = "";
				returnValue[8] = "";
				returnValue[9] = "";
				returnValue[10] = "FALSE";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * ESD_TRS_0429 : Bkg_Awk_Cgo 테이블을 조회<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchBkgAwkCgoforEdi(String bkgNo, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] returnValue = new String[18];
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("cntr_no", cntrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgAwkCgoforEdiRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue[0] = dbRowset.getString("OVR_BKWD_LEN");
				returnValue[1] = dbRowset.getString("OVR_FWRD_LEN");
				returnValue[2] = dbRowset.getString("OVR_HGT");
				returnValue[3] = dbRowset.getString("OVR_LF_LEN");
				returnValue[4] = dbRowset.getString("OVR_RT_LEN");
				returnValue[5] = dbRowset.getString("OVR_VOID_SLT_QTY");
				returnValue[6] = dbRowset.getString("TTL_DIM_LEN");
				returnValue[7] = dbRowset.getString("TTL_DIM_WDT");
				returnValue[8] = dbRowset.getString("TTL_DIM_HGT");
				returnValue[9] = dbRowset.getString("OVWGT");
				returnValue[10] = dbRowset.getString("STWG_RQST_DESC");
				returnValue[11] = dbRowset.getString("GWGTUNIT");
				returnValue[12] = dbRowset.getString("GWGT");
				returnValue[13] = dbRowset.getString("TWGTUNIT");
				returnValue[14] = dbRowset.getString("TWGT");
				returnValue[15] = dbRowset.getString("CMD");
				returnValue[16] = dbRowset.getString("CMDD");
				returnValue[17] = "TRUE";
			} else {
				returnValue[0] = "";
				returnValue[1] = "";
				returnValue[2] = "";
				returnValue[3] = "";
				returnValue[4] = "";
				returnValue[5] = "";
				returnValue[6] = "";
				returnValue[7] = "";
				returnValue[8] = "";
				returnValue[9] = "";
				returnValue[10] = "";
				returnValue[11] = "";
				returnValue[12] = "";
				returnValue[13] = "";
				returnValue[14] = "";
				returnValue[15] = "";
				returnValue[16] = "";
				returnValue[17] = "FALSE";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * 
	 * @param woVO
	 * @param type
	 * @return
	 * @throws DAOException
	 */
	public List<AbstractValueObject> searchRelredMasterForEdi(WorkOrderPreviewVO woVO, String type) throws DAOException {
		try {
			Map<String, String> param = new HashMap<String, String>();
			param.put("wo_prv_grp_seq", woVO.getWoPrvGrpSeq());
			param.put("wo_iss_no", woVO.getWoIssNo());
			param.put("wo_iss_sts_cd", woVO.getEdiWoIssStsCd());
			param.put("type", type);
			return new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchRelredMasterForEdiRSQL(), param, param, SearchRelredMasterForEdiVO.class);
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
	 * @param woVO
	 * @param type
	 * @return
	 * @throws DAOException
	 */
	public List<AbstractValueObject> searchRelredMasterForEdi(CimCStockVO woVO, String type) throws DAOException {
		try {
			Map<String, String> param = new HashMap<String, String>();
			param.put("trsp_wo_ofc_cty_cd", woVO.getWoNo().substring(0, 3));
			param.put("trsp_wo_seq", woVO.getWoNo().substring(3));
			param.put("issue_flag", woVO.getIssueFlag());
			param.put("type", type);
			return new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchRelredMasterForEdiResendRSQL(), param, param, SearchRelredMasterForEdiVO.class);
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
	 * @param String iWoPrvGrpSeq
	 * @param String iWoIssNo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchRelredInfoForEdi(String iWoPrvGrpSeq, String iWoIssNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			param.put("wo_prv_grp_seq", iWoPrvGrpSeq);
			param.put("wo_iss_no", iWoIssNo);
			param.putAll(mapVO);
			return new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchRelredInfoForEdiRSQL(), param, param);
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
	 * @param inTrspSoOfcCtyCd
	 * @param inTrspSoSeq
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchBkgDgCgoforEdi(String inTrspSoOfcCtyCd, String inTrspSoSeq) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("trsp_so_ofc_cty_cd", inTrspSoOfcCtyCd);
			mapVO.put("trsp_so_seq", inTrspSoSeq);
			param.putAll(mapVO);
			return new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgDgCgoforEdiRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ESD_TRS_0429 : Bkg_Container 테이블을 조회<br>
	 * 
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchBkgContainerforEdi(String bkgNo, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] returnValue = new String[5];
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("cntr_no", cntrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgContainerforEdiRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue[0] = dbRowset.getString("DCGO_FLG");
				returnValue[1] = dbRowset.getString("AWK_CGO_FLG");
				returnValue[2] = dbRowset.getString("RC_FLG");
				returnValue[3] = dbRowset.getString("RD_CGO_FLG");
				returnValue[4] = dbRowset.getString("CNTR_SEAL_NO");
			} else {
				returnValue[0] = "";
				returnValue[1] = "";
				returnValue[2] = "";
				returnValue[3] = "";
				returnValue[4] = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * ESD_TRS_0429 : Bkg_Booking 테이블을 조회<br>
	 * 
	 * @param String bkgNo
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchBkgBookingforEdi(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] returnValue = new String[3];
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgBookingforEdiRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue[0] = dbRowset.getString("DCGO_FLG");
				returnValue[1] = dbRowset.getString("RC_FLG");
				returnValue[2] = dbRowset.getString("AWK_CGO_FLG");
			} else {
				returnValue[0] = "";
				returnValue[1] = "";
				returnValue[2] = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}

	/**
	 * 
	 * @param wono
	 * @param rowcount
	 * @return
	 * @throws DAOException
	 */
	public String searchSlotNumber(String wono, int rowcount) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		String slot_number = "";
		try {
			param.put("wo_no", wono);
			param.put("slot_cnt", rowcount);
			DBRowSet dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchSlotNumberRSQL(), param, param);
			if (dbRowset.next()) {
				slot_number = dbRowset.getString("slot_num");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return slot_number;
	}

	/**
	 * BKG_AWK_CGO
	 * 
	 * @param bkgNo
	 * @param cntrNo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchOLInfo(String bkgNo, String cntrNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			return new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchOLInfoRSQL(), param, param);
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
	 * @param cimCStockVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void mergeCimCntrStk(CimCStockVO cimCStockVO) throws DAOException, Exception {
		try {
			Map<String, String> param = cimCStockVO.getColumnValues();
			new SQLExecuter().executeUpdate((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOMergeCimCntrStkCSQL(), param, param);
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
	 * @param cimCStockVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateFaxEmlSndNo(CimCStockVO cimCStockVO) throws DAOException, Exception {
		try {
			Map<String, String> param = cimCStockVO.getColumnValues();
			new SQLExecuter().executeUpdate((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOUpdateFaxEmlSndNoUSQL(), param, param);
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
	 * @param cimCStockVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeCimCntrStk(CimCStockVO cimCStockVO) throws DAOException, Exception {
		try {
			Map<String, String> param = cimCStockVO.getColumnValues();
			new SQLExecuter().executeUpdate((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOManageSTKSendFaxEmailDSQL(), param, param);
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
	 * @param bkgNo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet search301EdiKind(String bkgNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			return new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearch301EdiKindRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * RELRED Resend Info data
	 * 
	 * @param cimCStockVOs
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchRelredInfoForEdi(CimCStockVO[] cimCStockVOs) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		StringBuilder fmSoOfcCtyCd = new StringBuilder();
		StringBuilder fmSoSeq = new StringBuilder();
		try {
			for (int i = 0; i < cimCStockVOs.length; i++) {
				fmSoOfcCtyCd.append(cimCStockVOs[i].getSoOfcCtyCd() + ",");
				fmSoSeq.append(cimCStockVOs[i].getSoSeq() + ",");
			}

			Map<String, String> mapVO = new HashMap<String, String>();
			param.put("trsp_wo_ofc_cty_cd", cimCStockVOs[0].getWoNo().substring(0, 3));
			param.put("trsp_wo_seq", cimCStockVOs[0].getWoNo().substring(3));
			param.put("trsp_so_ofc_cty_cd", CommonUtil.seperationParameter(fmSoOfcCtyCd.toString(), ","));
			param.put("trsp_so_seq", CommonUtil.seperationParameter(fmSoSeq.toString(), ","));
			param.putAll(mapVO);
			return new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchRelredInfoForEdiResendRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 301F 발송을 위한 BKG DG Cargo Confirm여부 조회 메소드 1) Non-DG Booking : Y 2) DG Booking before SCG approval : N 3) DG Booking after SCG approval : Y
	 * 
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String getDgCfmFlg(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String returnValue = "";
		try {
			param.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOGetDgCfmFlgRSQL(), param, param);
			if (dbRowset.next()) {
				returnValue = dbRowset.getString("DG_CFM_FLG");
			} else {
				returnValue = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}
	
	/**
	 * BKG VGM
	 * 
	 * @param bkgNo
	 * @param cntrNo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchBkgVgmForEdi(String bkgNo, String cntrNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			return new SQLExecuter().executeQuery((ISQLTemplate) new EmptyReleaseRedeliveryOrderMgtDBDAOSearchBkgVgmForEdiRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}
