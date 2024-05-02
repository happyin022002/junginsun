/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : COPManageDBDAO.java
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*2008-06-25: SCE_EXPT_SUBSC_MST 테이블조인 및 검색조건 ACT_FLG='Y'추가
*2008-07-01: rowSize추가
*@LastModifyDate : 2008-07-01
*@LastModifier : Hun-Il Jung
*@LastVersion : 1.9
* 2006-11-20 minestar
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.copreport.exceptionreport.integration;


import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.sce.copreport.cophsitory.basic.COPHistoryBCImpl;
import com.clt.apps.opus.esd.sce.copreport.exceptionreport.vo.SearchNotifyFailureVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * SCE에 대한 DB 처리를 담당<br>
 * - SCE Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author minestar
 * @see COPHistoryBCImpl 참조
 * @since J2EE 1.4
 */
public class ExceptionReportDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * Exception_Notification Failure Report 의 Count를  조회한다.
	 * 
     * @param  SearchNotifyFailureVO searchNotifyFailureVO
     * @return int
     * @exception DAOException
	 */
	public int searchNotifyFailureCount(SearchNotifyFailureVO searchNotifyFailureVO) throws DAOException {
		DBRowSet dbRowset = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (searchNotifyFailureVO != null) {
				Map<String, String> mapVO = searchNotifyFailureVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				// VVD MULTI 처리
				if (velParam.get("vvd") != null & !((String) velParam.get("vvd")).trim().equals("")) {
					velParam.put("vvd", ((String) velParam.get("vvd")).split(","));
				}

				// Control Ofc. MULTI 처리
				if (velParam.get("cre_ofc_cd") != null & !((String) velParam.get("cre_ofc_cd")).trim().equals("")) {
					velParam.put("cre_ofc_cd", ((String) velParam.get("cre_ofc_cd")).split(","));
				}
				
				// POR_CD MULTI 처리
				if (velParam.get("por_cd") != null & !((String) velParam.get("por_cd")).trim().equals("")) {
					velParam.put("por_cd", ((String) velParam.get("por_cd")).split(","));
				}

				// POL_CD MULTI 처리
				if (velParam.get("pol_cd") != null & !((String) velParam.get("pol_cd")).trim().equals("")) {
					velParam.put("pol_cd", ((String) velParam.get("pol_cd")).split(","));
				}

				// POD_CD MULTI 처리
				if (velParam.get("pod_cd") != null & !((String) velParam.get("pod_cd")).trim().equals("")) {
					velParam.put("pod_cd", ((String) velParam.get("pod_cd")).split(","));
				}

				// DEL_CD MULTI 처리
				if (velParam.get("del_cd") != null & !((String) velParam.get("del_cd")).trim().equals("")) {
					velParam.put("del_cd", ((String) velParam.get("del_cd")).split(","));
				}
				
				// BKG_NO&BKG_NO_SPLIT MULTI 처리
				if (velParam.get("bkg_no") != null & !((String) velParam.get("bkg_no")).trim().equals("")) {
					velParam.put("bkg_no", ((String) velParam.get("bkg_no")).split(","));
				}
				// BL_NO MULTI 처리
				if (velParam.get("bl_no") != null & !((String) velParam.get("bl_no")).trim().equals("")) {
					velParam.put("bl_no", ((String) velParam.get("bl_no")).split(","));
				}									
				// CNTR_NO MULTI 처리
				if (velParam.get("cntr_no") != null & !((String) velParam.get("cntr_no")).trim().equals("")) {
					velParam.put("cntr_no", ((String) velParam.get("cntr_no")).split(","));
				}		
				// COP_NO MULTI 처리
				if (velParam.get("cop_no") != null & !((String) velParam.get("cop_no")).trim().equals("")) {
					velParam.put("cop_no", ((String) velParam.get("cop_no")).split(","));
				}					
		
			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ExceptionReportDBDAOSearchNotifyFailureCountRSQL(), param, velParam);

			if(dbRowset.getRowCount()>0){
		    	dbRowset.next();
		    	return dbRowset.getInt(1);
		    }else{
		    	return 0;
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
	 * Exception_Notification Failure Report 를  조회한다.
	 * 
	 * @param SearchNotifyFailureVO searchNotifyFailureVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchNotifyFailure(SearchNotifyFailureVO searchNotifyFailureVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (searchNotifyFailureVO != null) {
				Map<String, String> mapVO = searchNotifyFailureVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				// VVD MULTI 처리
				if (velParam.get("vvd") != null & !((String) velParam.get("vvd")).trim().equals("")) {
					velParam.put("vvd", ((String) velParam.get("vvd")).split(","));
				}

				// Control Ofc. MULTI 처리
				if (velParam.get("cre_ofc_cd") != null & !((String) velParam.get("cre_ofc_cd")).trim().equals("")) {
					velParam.put("cre_ofc_cd", ((String) velParam.get("cre_ofc_cd")).split(","));
				}
				
				// POR_CD MULTI 처리
				if (velParam.get("por_cd") != null & !((String) velParam.get("por_cd")).trim().equals("")) {
					velParam.put("por_cd", ((String) velParam.get("por_cd")).split(","));
				}

				// POL_CD MULTI 처리
				if (velParam.get("pol_cd") != null & !((String) velParam.get("pol_cd")).trim().equals("")) {
					velParam.put("pol_cd", ((String) velParam.get("pol_cd")).split(","));
				}

				// POD_CD MULTI 처리
				if (velParam.get("pod_cd") != null & !((String) velParam.get("pod_cd")).trim().equals("")) {
					velParam.put("pod_cd", ((String) velParam.get("pod_cd")).split(","));
				}

				// DEL_CD MULTI 처리
				if (velParam.get("del_cd") != null & !((String) velParam.get("del_cd")).trim().equals("")) {
					velParam.put("del_cd", ((String) velParam.get("del_cd")).split(","));
				}
				
				// BKG_NO&BKG_NO_SPLIT MULTI 처리
				if (velParam.get("bkg_no") != null & !((String) velParam.get("bkg_no")).trim().equals("")) {
					velParam.put("bkg_no", ((String) velParam.get("bkg_no")).split(","));
				}
				
				// BL_NO MULTI 처리
				if (velParam.get("bl_no") != null & !((String) velParam.get("bl_no")).trim().equals("")) {
					velParam.put("bl_no", ((String) velParam.get("bl_no")).split(","));
				}				
				// CNTR_NO MULTI 처리
				if (velParam.get("cntr_no") != null & !((String) velParam.get("cntr_no")).trim().equals("")) {
					velParam.put("cntr_no", ((String) velParam.get("cntr_no")).split(","));
				}		
				// COP_NO MULTI 처리
				if (velParam.get("cop_no") != null & !((String) velParam.get("cop_no")).trim().equals("")) {
					velParam.put("cop_no", ((String) velParam.get("cop_no")).split(","));
				}					

			}

			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ExceptionReportDBDAOSearchNotifyFailureRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}		
	
}