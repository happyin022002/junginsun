/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TesAdvanceAuditDBDAO.java
*@FileTitle : Port (Service) Charge
*Open Issues :
*Change history :
*@LastModifyDate : 2015-04-13
*@LastModifier : Jong-Ock Kim
*@LastVersion : 1.0
* 2015-04-13 Jong-Ock Kim
* 1.0 최초 생성
*  
=========================================================*/
package com.hanjin.apps.alps.esd.eas.tesadvanceaudit.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.LgsCostSubjCdVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesAudCfgVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesAuditConditionVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesAuditMRHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesAuditOndockRailHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesInvoiceAuditVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesInvoiceConfirmVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesMRStorageFreeDayHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesMRStorageFreePoolHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesMarineStorageDetailCostByDayVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesMarineStorageDetailCostByPoolVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesMarineTerminalDetailVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYDetailCostByDayVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYDetailCostByPoolVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYDetailTMNLVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYFreeDayHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYFreePoolHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYGateOutDateVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOffdockCYTerminalHistoryVO;
import com.hanjin.apps.alps.esd.eas.tesadvanceaudit.vo.TesOndockRailChargeInvoiceVO;
import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.integration.TrsAdvanceAuditDBDAOconfirmTrsPreAuditCSQL;
import com.hanjin.apps.alps.esd.eas.trsadvanceaudit.integration.TrsAdvanceAuditDBDAOsearchReBatchTargetCheckRSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TesTmlSoDtlVO;

/**
 * TesAdvanceAuditDBDAO ���� PDTO(Data Transfer Object including Parameters)<br>
 * 
 * @author Jong-Ock Kim
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class TesAdvanceAuditDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = -1132976440312128013L;
	
	/**
	 * ESD_EAS_0370 - Retrieve
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesAudCfgVO>
	 * @throws DAOException
	 */
	public List<TesAudCfgVO> searchTesAudCfgList(TesAuditConditionVO tesAuditConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesAudCfgVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = tesAuditConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOTesAudCfgRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesAudCfgVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
    /**
     * ESD_EAS_0370 - Modify
     *
     * @param  List<TesAudCfgVO> multiList
     * @throws DAOException
     */
	public void modifyTesAudCfg(List<TesAudCfgVO> multiList) throws DAOException {
        int updCnt[] = null;
        try{
            SQLExecuter sqlExe = new SQLExecuter("");
            if(multiList != null ){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new TesAdvanceAuditDBDAOTesAudCfgUSQL(), multiList, null);
                for(int i = 0; i < updCnt.length; i++){
                    if(updCnt[i]== Statement.EXECUTE_FAILED)
                        throw new DAOException("Fail to update No"+ i + " SQL");
                }
            }
        }catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
	
	/**
	 * ESD_EAS_0370 - Cost Group
	 * 
	 * @return List<LgsCostSubjCdVO>
	 * @throws DAOException
	 */
	public List<LgsCostSubjCdVO> searchLgsCostSubjCd() throws DAOException {
		DBRowSet dbRowset = null;
		List<LgsCostSubjCdVO> list = null;
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOLgsCostSubjCdRSQL(), null, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, LgsCostSubjCdVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_0378 - 조회
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesAuditMRHistoryVO>
	 * @throws DAOException
	 */
	public List<TesAuditMRHistoryVO> searchTesAuditMRHistoryList(TesAuditConditionVO tesAuditConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesAuditMRHistoryVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(tesAuditConditionVO != null){
				
				Map<String, String> mapVO = tesAuditConditionVO .getColumnValues();
				
				if(tesAuditConditionVO.getSCntrVslClssCapa() != "") {
					String[] capaArr = tesAuditConditionVO.getSCntrVslClssCapa().split("[|]");
					param.put("s_from_cntr_vsl_clss_capa", capaArr[0]);
					param.put("s_to_cntr_vsl_clss_capa", capaArr[1]);
				}
				
				//Cost Code 
	            List<String> lgs_cost_dtl_cd = new ArrayList();
	            String[] lgs_cost_dtl_cds = tesAuditConditionVO.getSLgsCostDtlCd().split(",");
	            for(int i = 0; i < lgs_cost_dtl_cds.length; i++){
	            	lgs_cost_dtl_cd.add(lgs_cost_dtl_cds[i]);   
	            }
				if(tesAuditConditionVO.getSLgsCostDtlCd() != "") {
					velParam.put("lgs_cost_dtl_cds", lgs_cost_dtl_cd);
				}
				
				//TP/SZ
	            List<String> cntr_tpsz_cd = new ArrayList();
	            String[] cntr_tpsz_cds = tesAuditConditionVO.getSCntrTpszCd().split(",");
	            for(int i = 0; i < cntr_tpsz_cds.length; i++){
	            	cntr_tpsz_cd.add(cntr_tpsz_cds[i]);   
	            }
				if(tesAuditConditionVO.getSCntrTpszCd() != "") {
					velParam.put("cntr_tpsz_cds", cntr_tpsz_cd);
				}
	            
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOTesAuditMRHistoryRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesAuditMRHistoryVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_0379 - Retrieve
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesOndockRailChargeInvoiceVO>
	 * @throws DAOException
	 */
	public List<TesOndockRailChargeInvoiceVO> searchTesOndockRailChargeInvoiceAuditDetailList(TesAuditConditionVO tesAuditConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesOndockRailChargeInvoiceVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = tesAuditConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOTesOndockRailChargeInvoiceRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesOndockRailChargeInvoiceVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_0371 - Retrieve
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesInvoiceConfirmVO>
	 * @throws DAOException
	 */
	public List<TesInvoiceConfirmVO> searchTesInvoiceConfirmList(TesAuditConditionVO tesAuditConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesInvoiceConfirmVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = tesAuditConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOTesInvoiceConfirmRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesInvoiceConfirmVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_0373 - init
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesOffdockCYGateOutDateVO>
	 * @throws DAOException
	 */
	public List<TesOffdockCYGateOutDateVO> searchTesOffdockCYInvoiceGateOutDate(TesAuditConditionVO tesAuditConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesOffdockCYGateOutDateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = tesAuditConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOTesOffdockCYGateOutDateRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesOffdockCYGateOutDateVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_0373 - Cost Calc.(TMNL)
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesOffdockCYDetailTMNLVO>
	 * @throws DAOException
	 */
	public List<TesOffdockCYDetailTMNLVO> searchTesOffdockCYInvoiceAuditDetailTMNLList(TesAuditConditionVO tesAuditConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesOffdockCYDetailTMNLVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = tesAuditConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOTesOffdockCYDetailTMNLRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesOffdockCYDetailTMNLVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_0373 - Cost Calc.(SRbyFD)
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesOffdockCYDetailCostByDayVO>
	 * @throws DAOException
	 */
	public List<TesOffdockCYDetailCostByDayVO> searchTesOffdockCYInvoiceAuditDetailCostByDayList(TesAuditConditionVO tesAuditConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesOffdockCYDetailCostByDayVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = tesAuditConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOTesOffdockCYDetailCostByDayRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesOffdockCYDetailCostByDayVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_0373 - Cost Calc.(SRbyFP)
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesOffdockCYDetailCostByPoolVO>
	 * @throws DAOException
	 */
	public List<TesOffdockCYDetailCostByPoolVO> searchTesOffdockCYInvoiceAuditDetailCostByPoolList(TesAuditConditionVO tesAuditConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesOffdockCYDetailCostByPoolVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = tesAuditConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOTesOffdockCYDetailCostByPoolRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesOffdockCYDetailCostByPoolVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_0375 - Cost Calc.(SRbyFD)
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesMarineStorageDetailCostByDayVO>
	 * @throws DAOException
	 */
	public List<TesMarineStorageDetailCostByDayVO> searchTesMarineStorageInvoiceAuditDetailCostByDayList(TesAuditConditionVO tesAuditConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesMarineStorageDetailCostByDayVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = tesAuditConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOTesMarineStorageDetailCostByDayRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesMarineStorageDetailCostByDayVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_0375 - Cost Calc.(SRbyFP)
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesMarineStorageDetailCostByPoolVO>
	 * @throws DAOException
	 */
	public List<TesMarineStorageDetailCostByPoolVO> searchTesMarineStorageInvoiceAuditDetailCostByPoolList(TesAuditConditionVO tesAuditConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesMarineStorageDetailCostByPoolVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = tesAuditConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOTesMarineStorageDetailCostByPoolRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesMarineStorageDetailCostByPoolVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_0377 - Retrieve
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesMarineTerminalDetailVO>
	 * @throws DAOException
	 */
	public List<TesMarineTerminalDetailVO> searchTesMarineTerminalInvoiceAuditDetailList(TesAuditConditionVO tesAuditConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesMarineTerminalDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = tesAuditConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOTesMarineTerminalDetailRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesMarineTerminalDetailVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_0380 - 조회
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesAuditOndockRailHistoryVO>
	 * @throws DAOException
	 */
	public List<TesAuditOndockRailHistoryVO> searchTesAuditOndockRailHistoryList(TesAuditConditionVO tesAuditConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesAuditOndockRailHistoryVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(tesAuditConditionVO != null){
				Map<String, String> mapVO = tesAuditConditionVO .getColumnValues();
	            List<String> lgs_cost_dtl_cd = new ArrayList();
	            String[] lgs_cost_dtl_cds = tesAuditConditionVO.getSLgsCostDtlCd().split(",");
	            for(int i = 0; i < lgs_cost_dtl_cds.length; i++){
	            	lgs_cost_dtl_cd.add(lgs_cost_dtl_cds[i]);   
	            }

				if(tesAuditConditionVO.getSLgsCostDtlCd() != "") {
					velParam.put("lgs_cost_dtl_cds", lgs_cost_dtl_cd);
				}
	            
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOTesAuditOndockRailHistoryRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesAuditOndockRailHistoryVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_0372 - Retrieve
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesInvoiceAuditVO>
	 * @throws DAOException
	 */
	public List<TesInvoiceAuditVO> searchTesInvoiceAuditList(TesAuditConditionVO tesAuditConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesInvoiceAuditVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = tesAuditConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			if(tesAuditConditionVO.getSInvNo() != null && tesAuditConditionVO.getSInvNo().length() > 0) {
				List<String> invNos = new ArrayList<String>();
				String[] arrInvNo = tesAuditConditionVO.getSInvNo().split(",");
				for(int i = 0; i < arrInvNo.length; i++) {
					invNos.add(arrInvNo[i]);
				}
				param.put("invNos", invNos);
				velParam.put("invNos", invNos);
			}
		 
			if(tesAuditConditionVO.getSCsrNo() != null && tesAuditConditionVO.getSCsrNo().length() > 0) {
				List<String> csrNos = new ArrayList<String>();
				String[] arrCsrNo = tesAuditConditionVO.getSCsrNo().split(",");
				for(int i = 0; i < arrCsrNo.length; i++) {
					csrNos.add(arrCsrNo[i]);
				}
				param.put("csrNos", csrNos);
				velParam.put("csrNos", csrNos);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOTesInvoiceAuditRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesInvoiceAuditVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
    /**
     * ESD_EAS_0372 - Modify
     *
     * @param  TesInvoiceAuditVO tesInvoiceAuditVO
     * @throws DAOException
     */
	public void modifyTesInvoiceAudit(TesInvoiceAuditVO tesInvoiceAuditVO) throws DAOException {
   		 Map<String, Object> param = new HashMap<String, Object>();

   		 try {
   			 SQLExecuter sqlExe = new SQLExecuter("");
   			 DBRowSet dbRowset = null;
   			 if (tesInvoiceAuditVO != null) {
   				 //query parameter
   				 Map<String, String> mapVO = tesInvoiceAuditVO.getColumnValues();
   				 param.putAll(mapVO);
   			
   				 //실시간 배치대상에 이미 포함되어 있는지를 검사한다.
   				TesAdvanceAuditDBDAOSearchReBatchTargetCheckRSQL chkSQL = new TesAdvanceAuditDBDAOSearchReBatchTargetCheckRSQL();
   				 dbRowset = sqlExe.executeQuery(chkSQL, param, param);
   				 String progFlg = "";
   	
   				 if (dbRowset.next()) {
   					 progFlg = dbRowset.getString("prog_flg");
   					 if ("Y".equals(progFlg)) {
   						 throw new DAOException((new ErrorHandler("EAS99999",new String[]{"It is included in the re-batch target."})).getMessage());
   					 }
   				 }
   			
   				 int result = sqlExe.executeUpdate((ISQLTemplate) new TesAdvanceAuditDBDAOTesInvoiceAuditUSQL(), param, param);

   				 if (result == Statement.EXECUTE_FAILED) {
   					 throw new DAOException("Fail to update SQL");
   				 }
   			 }	
   			
            
        } catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
	

	/**
	 * ESD_EAS_0372 - Batch(5분 매뉴얼) 등록
	 *
	 * @param  TesInvoiceAuditVO tesInvoiceAuditVO
	 * @throws DAOException
	 */
	public void createTesInvoiceAuditBatch(TesInvoiceAuditVO tesInvoiceAuditVO) throws DAOException {
		 Map<String, Object> param = new HashMap<String, Object>();

		 try {
			 SQLExecuter sqlExe = new SQLExecuter("");
			 DBRowSet dbRowset = null;
			 if (tesInvoiceAuditVO != null) {
				 //query parameter
				 Map<String, String> mapVO = tesInvoiceAuditVO.getColumnValues();
				 param.putAll(mapVO);
			
				 //실시간 배치대상에 이미 포함되어 있는지를 검사한다.
				TesAdvanceAuditDBDAOSearchReBatchTargetCheckRSQL chkSQL = new TesAdvanceAuditDBDAOSearchReBatchTargetCheckRSQL();
				 dbRowset = sqlExe.executeQuery(chkSQL, param, param);
				 String progFlg = "";
	
				 if (dbRowset.next()) {
					 progFlg = dbRowset.getString("prog_flg");
					 if ("Y".equals(progFlg)) {
						 throw new DAOException((new ErrorHandler("EAS99999",new String[]{"It is included in the re-batch target."})).getMessage());
					 }
				 }
			
				 int result = sqlExe.executeUpdate((ISQLTemplate) new TesAdvanceAuditDBDAOCreateTesInvoiceAuditBatchCSQL(), param, param);

				 if (result == Statement.EXECUTE_FAILED) {
					 throw new DAOException("Fail to update SQL");
				 }
			 }	
			
		} catch (SQLException se) {
			log.error("err " + se.toString(), se);
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * ESD_EAS_0374 - TMNL
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesOffdockCYTerminalHistoryVO>
	 * @throws DAOException
	 */
	public List<TesOffdockCYTerminalHistoryVO> searchTesAuditOffdockCYTerminalHistoryList(TesAuditConditionVO tesAuditConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesOffdockCYTerminalHistoryVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = tesAuditConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOTesOffdockCYTerminalHistoryRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesOffdockCYTerminalHistoryVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_0374 - SR by FD
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesOffdockCYFreeDayHistoryVO>
	 * @throws DAOException
	 */
	public List<TesOffdockCYFreeDayHistoryVO> searchTesAuditOffdockCYFreeDayHistoryList(TesAuditConditionVO tesAuditConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesOffdockCYFreeDayHistoryVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = tesAuditConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOTesOffdockCYFreeDayHistoryRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesOffdockCYFreeDayHistoryVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_0374 - SR by FP
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesOffdockCYFreePoolHistoryVO>
	 * @throws DAOException
	 */
	public List<TesOffdockCYFreePoolHistoryVO> searchTesAuditOffdockCYFreePoolHistoryList(TesAuditConditionVO tesAuditConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesOffdockCYFreePoolHistoryVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = tesAuditConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOTesOffdockCYFreePoolHistoryRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesOffdockCYFreePoolHistoryVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_0376 - SR by FD
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesMRStorageFreeDayHistoryVO>
	 * @throws DAOException
	 */
	public List<TesMRStorageFreeDayHistoryVO> searchTesAuditMRStorageFreeDayHistoryList(TesAuditConditionVO tesAuditConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesMRStorageFreeDayHistoryVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = tesAuditConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOTesMRStorageFreeDayHistoryRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesMRStorageFreeDayHistoryVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_0376 - SR by FP
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesMRStorageFreePoolHistoryVO>
	 * @throws DAOException
	 */
	public List<TesMRStorageFreePoolHistoryVO> searchTesAuditMRStorageFreePoolHistoryList(TesAuditConditionVO tesAuditConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesMRStorageFreePoolHistoryVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = tesAuditConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOTesMRStorageFreePoolHistoryRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesMRStorageFreePoolHistoryVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	

	/********************	Batch Method START	*******************************/	
	/**
	 * ESD_EAS_B003
	 * VVD 물량 집계
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesInvoiceAuditVO>
	 * @throws DAOException
	 */
	public List<TesInvoiceAuditVO> searchVvdQty(TesAuditConditionVO tesAuditConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesInvoiceAuditVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = tesAuditConditionVO.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOSearchVvdQtyRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesInvoiceAuditVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_B003
	 * VVD 물량 등록
	 * 
	 * @param List<TesInvoiceAuditVO> multiList
	 * @throws DAOException
	 */
	public void multiVvdQty(List<TesInvoiceAuditVO> multiList) throws DAOException {
        int updCnt[] = null;
        
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            
            if (multiList.size() > 0 ) {
                updCnt = sqlExe.executeBatch((ISQLTemplate)new TesAdvanceAuditDBDAOMultiVvdQtyCSQL(), multiList, null);
                for (int i = 0; i < updCnt.length; i++) {
                    if (updCnt[i]== Statement.EXECUTE_FAILED) {
                        throw new DAOException("Fail to update No"+ i + " SQL");
                    }
                }
            }
            
        } catch (SQLException se) {
            log.error("err " + se.toString(), se);
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }

	/**
	 * ESD_EAS_B003
	 * 심사 기준 자료가 없을 경우 심사 내역을 초기화
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyInitialInvAud(TesAuditConditionVO tesAuditConditionVO) throws DAOException {
		int resultCnt = 0;
		
		//query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if (tesAuditConditionVO != null ) {
				Map<String, String> mapVO = tesAuditConditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			resultCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new TesAdvanceAuditDBDAOModifyInitialInvAudUSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return resultCnt;			
	}
	
	
	/**
	 * ESD_EAS_B003
	 * 
	 * @param TesAuditConditionVO tesAuditConditionVO
	 * @return List<TesInvoiceAuditVO>
	 * @throws DAOException
	 */
	public List<TesInvoiceAuditVO> searchTesAutoAuditList(TesAuditConditionVO tesAuditConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesInvoiceAuditVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = tesAuditConditionVO.getColumnValues();
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOSearchTesAutoAuditListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesInvoiceAuditVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_B003
	 * Marine Terminal Invoice Audit
	 * 
	 * @param TesInvoiceAuditVO tesInvoiceAuditVO
	 * @return List<TesInvoiceAuditVO>
	 * @throws DAOException
	 */
	public List<TesInvoiceAuditVO> searchMrInvAud(TesInvoiceAuditVO tesInvoiceAuditVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesInvoiceAuditVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = tesInvoiceAuditVO.getColumnValues();
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOSearchMrInvAudRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesInvoiceAuditVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_B003
	 * Off-Dock Terminal Invoice Audit
	 * 
	 * @param TesInvoiceAuditVO tesInvoiceAuditVO
	 * @return List<TesInvoiceAuditVO>
	 * @throws DAOException
	 */
	public List<TesInvoiceAuditVO> searchOffDockTmnlAud(TesInvoiceAuditVO tesInvoiceAuditVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesInvoiceAuditVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = tesInvoiceAuditVO.getColumnValues();
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOSeachOffDockTmnlAudRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesInvoiceAuditVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_B003
	 * Marine Terminal Storage & Off-Dock Storage Invoice FreeDay Audit
	 * 
	 * @param TesInvoiceAuditVO tesInvoiceAuditVO
	 * @return List<TesInvoiceAuditVO>
	 * @throws DAOException
	 */
	public List<TesInvoiceAuditVO> searchFreeDayAud(TesInvoiceAuditVO tesInvoiceAuditVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesInvoiceAuditVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = tesInvoiceAuditVO.getColumnValues();
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOSearchFreeDayAudRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesInvoiceAuditVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_B003
	 * Marine Terminal Storage & Off-Dock Storage Invoice FreePool Audit
	 * 
	 * @param TesInvoiceAuditVO tesInvoiceAuditVO
	 * @return List<TesInvoiceAuditVO>
	 * @throws DAOException
	 */
	public List<TesInvoiceAuditVO> searchFreePoolAud(TesInvoiceAuditVO tesInvoiceAuditVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesInvoiceAuditVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = tesInvoiceAuditVO.getColumnValues();
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOSearchFreePoolAudRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesInvoiceAuditVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESD_EAS_B003
	 * On-Dock Rail Ramp Invoice Audit
	 * 
	 * @param TesInvoiceAuditVO tesInvoiceAuditVO
	 * @return List<TesInvoiceAuditVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TesInvoiceAuditVO> searchOnDockRailAud(TesInvoiceAuditVO tesInvoiceAuditVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesInvoiceAuditVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = tesInvoiceAuditVO.getColumnValues();
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TesAdvanceAuditDBDAOSearchOnDockRailAudRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesInvoiceAuditVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	/**
	 * ESD_EAS_B003
	 * 심사 결과를 등록 수정한다.
	 * 
	 * @param List<TesInvoiceAuditVO> multiList
	 * @throws DAOException
	 */
	public void createInvAud(List<TesInvoiceAuditVO> multiList) throws DAOException {
		int updCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (multiList != null && multiList.size() > 0 ) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TesAdvanceAuditDBDAOCreateInvAudCSQL(), multiList, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to update No" + i + " SQL");
					}
				}
			}
			
		} catch (SQLException se) {
			log.error("err " + se.toString(), se);
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESD_EAS_B007
	 * 실시간 배치 상태를 수정한다.
	 * 
	 * @param List<TesInvoiceAuditVO> multiList
	 * @throws DAOException
	 */
	public void updateBatchStatus(List<TesInvoiceAuditVO> multiList) throws DAOException {
		int updCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (multiList != null && multiList.size() > 0 ) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TesAdvanceAuditDBDAOUpdateBatchStatusUSQL(), multiList, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to update No" + i + " SQL");
					}
				}
			}
			
		} catch (SQLException se) {
			log.error("err " + se.toString(), se);
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/********************	Batch Method END	*******************************/	

}