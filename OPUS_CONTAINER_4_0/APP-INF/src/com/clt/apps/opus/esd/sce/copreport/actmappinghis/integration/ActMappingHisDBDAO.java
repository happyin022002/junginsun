/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ActMappingHisDBDAO.java
*@FileTitle : Actual Mapping History
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.copreport.actmappinghis.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.sce.copreport.actmappinghis.basic.ActMappingHisBCImpl;
import com.clt.apps.opus.esd.sce.copreport.actmappinghis.vo.SearchActMappingHisVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * 
 * - Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author 김성일
 * @see ActMappingHisBCImpl 참조
 * @since J2EE 1.4
 */
public class ActMappingHisDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * Actual Mapping History 조회
	 * 	 
	 * @param SearchActMappingHisVO searchActMappingHisVO
	 * @return List<SearchActMappingHisVO>
	 * @exception DAOException
	 */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<SearchActMappingHisVO> searchActMappingHisList(SearchActMappingHisVO searchActMappingHisVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchActMappingHisVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (searchActMappingHisVO != null) {
				Map<String, String> mapVO = searchActMappingHisVO
						.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				// VVD MULTI 처리
				if (velParam.get("vvd") != null & !((String) velParam.get("vvd")).trim().equals("")) {
					velParam.put("vvd", ((String) velParam.get("vvd")).toUpperCase().split(","));
				}

				// POR_CD MULTI 처리
				if (velParam.get("por_cd") != null & !((String) velParam.get("por_cd")).trim().equals("")) {
					velParam.put("por_cd", ((String) velParam.get("por_cd")).toUpperCase().split(","));
				}
				
				// POL_CD MULTI 처리
				if (velParam.get("pol_cd") != null & !((String) velParam.get("pol_cd")).trim().equals("")) {
					velParam.put("pol_cd", ((String) velParam.get("pol_cd")).toUpperCase().split(","));
				}

				// POD_CD MULTI 처리
				if (velParam.get("pod_cd") != null & !((String) velParam.get("pod_cd")).trim().equals("")) {
					velParam.put("pod_cd", ((String) velParam.get("pod_cd")).toUpperCase().split(","));
				}

				// DEL_CD MULTI 처리
				if (velParam.get("del_cd") != null & !((String) velParam.get("del_cd")).trim().equals("")) {
					velParam.put("del_cd", ((String) velParam.get("del_cd")).toUpperCase().split(","));
				}
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ActMappingHisDBDAOSearchActMappingHisRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					SearchActMappingHisVO.class);

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