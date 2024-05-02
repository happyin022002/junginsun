/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : TESCommonDBDAO.java
 *@FileTitle : TES Common 관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 *2016-03-08 KHS
 *1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.tescommon.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.tes.common.tescommon.integration.TESCommonDBDAOGetNodeCodeRSQL;
import com.clt.apps.opus.esd.tes.common.tescommon.integration.TESCommonDBDAOSearchAuthOfcCdRSQL;
import com.clt.apps.opus.esd.tes.common.tescommon.integration.TESCommonDBDAOSearchBkgCntrTPCDListRSQL;
import com.clt.apps.opus.esd.tes.common.tescommon.integration.TESCommonDBDAOSearchCostOFCRSQL;
import com.clt.apps.opus.esd.tes.common.tescommon.integration.TESCommonDBDAOSearchCurrencyListRSQL;
import com.clt.apps.opus.esd.tes.common.tescommon.integration.TESCommonDBDAOSearchDBdateRSQL;
import com.clt.apps.opus.esd.tes.common.tescommon.integration.TESCommonDBDAOSearchEQNoRSQL;
import com.clt.apps.opus.esd.tes.common.tescommon.integration.TESCommonDBDAOSearchTESInvoiceCommonCodeListRSQL;
import com.clt.apps.opus.esd.tes.common.tescommon.integration.TESCommonDBDAOValidateCostOFC2RSQL;
import com.clt.apps.opus.esd.tes.common.tescommon.integration.TESCommonDBDAOValidateCostOFCRSQL;
import com.clt.apps.opus.esd.tes.common.tescommon.integration.TESCommonDBDAOValidateVndrCode2RSQL;
import com.clt.apps.opus.esd.tes.common.tescommon.integration.TESCommonDBDAOValidateVndrCodeRSQL;
import com.clt.apps.opus.esd.tes.common.tescommon.integration.TESCommonDBDAOValidateYardCode2RSQL;
import com.clt.apps.opus.esd.tes.common.tescommon.integration.TESCommonDBDAOValidateYardCodeNsearchYdCostCodeListRSQL;
import com.clt.apps.opus.esd.tes.common.tesinvoicecommon.integration.TESInvoiceCommonDBDAOGetAgmtCurrCDRSQL;
import com.clt.apps.opus.esd.tes.common.tesinvoicecommon.integration.TESInvoiceCommonDBDAOGetAgmtStsRSQL;
import com.clt.apps.opus.esd.tes.common.tesinvoicecommon.integration.TESInvoiceCommonDBDAOGetWHTmodeRSQL;
import com.clt.apps.opus.esd.tes.common.tesinvoicecommon.integration.TESInvoiceCommonDBDAOIsValidErrInvNoRSQL;
import com.clt.apps.opus.esd.tes.tescommon.basic.TESCommonBCImpl;
import com.clt.apps.opus.esd.tes.tescommon.event.TESCommonEvent;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * TES에 대한 DB 처리를 담당<br>
 * TES Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author KHS
 * @see TESCommonBCImpl 참조
 * @since J2EE 1.4
 */
public class TESCommonDBDAO extends DBDAOSupport {

	/**
	 * Retrieve Currency Code List <br>
	 * 
	 * @param event TESCommonEvent
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCurrencyCodeList(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESCommonDBDAOSearchCurrencyListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}

	/**
	 * Retrieve Common Code List <br>
	 * CNTR_TPSZ_CD, MT_A_LGS_COST_CD, ON_A_LGS_COST_CD, OT_A_LGS_COST_CD, OS_A_LGS_COST_CD, ST_A_LGS_COST_CD, CARR_CD, EQ_TPSZ_CD <br>
	 * 
	 * @param event TESCommonEvent
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCommonCodeList(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESCommonDBDAOSearchTESInvoiceCommonCodeListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}

	/**
	 * Retrieve WHLD_TAX_AMT_MODE <br>
	 * 
	 * @param event TESCommonEvent
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchWhldTaxAmtMode(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESInvoiceCommonDBDAOGetWHTmodeRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}

	/**
	 * Retrieve Manual Lgs Cost Cd <br>
	 * 
	 * @param event TESCommonEvent
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchManualLgsCostCdList(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESCommonDBDAOSearchManualLgsCostCodeListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}

	/**
	 * Retrieve Service Provider Name <br>
	 * 
	 * @param event TESCommonEvent
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchServiceProviderName(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESCommonDBDAOValidateVndrCodeRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}

	/**
	 * Retrieve Invoice Duplication YN <br>
	 * 
	 * @param event TESCommonEvent
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchInvDuplicateYN(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESCommonDBDAOSearchInvoiceDupYNRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}

	/**
	 * Retrieve Error Invoice Validation YN <br>
	 * 
	 * @param event TESCommonEvent
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchErrInvValidYN(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESInvoiceCommonDBDAOIsValidErrInvNoRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}

	/**
	 * Retrieve Yard Code Validation & Cost Code List <br>
	 * 
	 * @param event TESCommonEvent
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchYdCdCostCdList(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESCommonDBDAOValidateYardCodeNsearchYdCostCodeListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}

	/**
	 * Retrieve Office Code <br>
	 * 
	 * @param event TESCommonEvent
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchOfcCd(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESCommonDBDAOSearchCostOFCRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}

	/**
	 * Retrieve Sub Trade Code List <br>
	 * 
	 * @param event TESCommonEvent
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchSubTrdCdList(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESCommonDBDAOSearchSubTrdCdListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}

	/**
	 * Retrieve Agreement Cost Code List <br>
	 * 
	 * @param event TESCommonEvent
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchAgmtCostCdList(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESCommonDBDAOSearchAgmtCostCdListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}
	
	/**
	 * Retrieve Agreement Status Code <br>
	 * 
	 * @param event TESCommonEvent
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchAgmtStatusCd(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESInvoiceCommonDBDAOGetAgmtStsRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}
	
	/**
	 * Retrieve SLane Code <br>
	 * 
	 * @param event TESCommonEvent
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchSLanCd(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESCommonDBDAOSearchLanCdListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}
	
	/**
	 * Retrieve Cost Office Validation YN <br>
	 * 
	 * @param event TESCommonEvent
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCostOfcValidYN(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESCommonDBDAOValidateCostOFCRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}
	
	/**
	 * Retrieve Agreement Curr Cd <br>
	 * 
	 * @param event TESCommonEvent
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchAgmtCurrCd(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESInvoiceCommonDBDAOGetAgmtCurrCDRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}
	
	/**
	 * Retrieve Equipment Type Size <br>
	 * 
	 * @param event TESCommonEvent
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchEquipTypeCd(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESCommonDBDAOSearchEQNoRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}
	
	/**
	 * Retrieve Authorization Office Code <br>
	 * 
	 * @param event TESCommonEvent
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchAuthOfcCd(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESCommonDBDAOSearchAuthOfcCdRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}
	
	/**
	 * Retrieve Yard Code Validation <br>
	 * 
	 * @param event TESCommonEvent
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchYdCdValid(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESCommonDBDAOValidateYardCode2RSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}
	
	/**
	 * Retrieve Vendor Code Validation <br>
	 * 
	 * @param event TESCommonEvent
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchVndrCdValid(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESCommonDBDAOValidateVndrCode2RSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}
	
	/**
	 * Retrieve CURR_DATE (GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC) <br>
	 * 
	 * @param event TESCommonEvent
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchDBDate(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( !"".equals( event.getSignOnUserAccount().getOfc_cd() ) ) {
				param.put("ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
				velParam.put("ofc_cd", event.getSignOnUserAccount().getOfc_cd() );
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESCommonDBDAOSearchDBdateRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}
	
	/**
	 * Retrieve Cost Office Validation Delete YN <br>
	 * 
	 * @param event TESCommonEvent
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCostOfcValidDelYN(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESCommonDBDAOValidateCostOFC2RSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}
	
	/**
	 * Retrieve Invoice Office Validation Delete YN <br>
	 * 
	 * @param event TESCommonEvent
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchInvOfcValidDelYN(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if ( !"".equals( event.getTesCommonVO().getInvOfcCd() ) ) {
				param.put("cost_ofc_cd", event.getTesCommonVO().getInvOfcCd() );
				velParam.put("cost_ofc_cd", event.getTesCommonVO().getInvOfcCd() );
				param.put("yd_cd", event.getTesCommonVO().getYdCd() );
				velParam.put("yd_cd", event.getTesCommonVO().getYdCd() );
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESCommonDBDAOValidateCostOFC2RSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}
	
	/**
	 * Retrieve Cost Code <br>
	 * 
	 * @param event TESCommonEvent
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCostCode(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESCommonDBDAOSearchCostCodeListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}
	
	/**
	 * Retrieve Node Code List <br>
	 * 
	 * @param event TESCommonEvent
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchNodeCdList(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESCommonDBDAOGetNodeCodeRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}
	
	/**
	 * Retrieve Container Type Size <br>
	 * 
	 * @param event TESCommonEvent
	 * @return dbRowset DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCntrTpSz(TESCommonEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = event.getTesCommonVO().getColumnValues();

			if (mapVO != null) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESCommonDBDAOSearchBkgCntrTPCDListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}
}