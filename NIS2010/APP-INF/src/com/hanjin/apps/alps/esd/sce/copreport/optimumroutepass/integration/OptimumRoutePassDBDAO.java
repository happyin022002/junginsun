/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OptimumRoutePassDBDAO.java
*@FileTitle : Optimum Route Pass
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.basic.OptimumRoutePassBCImpl;
import com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.vo.OptmRoutPassCondVO;
import com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.vo.OptmRoutPassDtlVO;
import com.hanjin.apps.alps.esd.sce.copreport.optimumroutepass.vo.OptmRoutPassSmryVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS OptimumRoutePassDBDAO <br>
 * - ALPS-OptimumRoutePass system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Jong Ock
 * @see OptimumRoutePassBCImpl 참조
 * @since J2EE 1.6
 */
public class OptimumRoutePassDBDAO extends DBDAOSupport {

	/**
	 * Optimum Route Pass - Summary<br>
	 * 
	 * @param OptmRoutPassCondVO optmRoutPassCondVO
	 * @return List<OptmRoutPassSmryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OptmRoutPassSmryVO> searchOptmRoutPassSmry(OptmRoutPassCondVO optmRoutPassCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OptmRoutPassSmryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(optmRoutPassCondVO != null){
				Map<String, String> mapVO = optmRoutPassCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OptimumRoutePassDBDAOsearchOptmRoutPassSmryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OptmRoutPassSmryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * Optimum Route Pass - Detail<br>
	 * 
	 * @param OptmRoutPassCondVO optmRoutPassCondVO
	 * @return List<OptmRoutPassDtlVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OptmRoutPassDtlVO> searchOptmRoutPassDtl(OptmRoutPassCondVO optmRoutPassCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OptmRoutPassDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(optmRoutPassCondVO != null){
				Map<String, String> mapVO = optmRoutPassCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if(!"SINGLE".equals(optmRoutPassCondVO.getSelOpTp())){
				
					List<String> condtions = new ArrayList<String>();
					String strComma = "#";
					
					String[] arrBndCd =  optmRoutPassCondVO.getBndCd().split(strComma);
					String[] arrTrspModCd =  optmRoutPassCondVO.getTrspModCd().split(strComma);
					String[] arrInputOffice =  optmRoutPassCondVO.getInputOffice().split(strComma);
					String arrSum = "";
					
					for(int i = 0; i < arrBndCd.length; i ++){
						arrSum = "";
						arrSum = "('"+arrInputOffice[i]+"', '"+arrBndCd[i]+"', DECODE(1, DECODE('"+arrTrspModCd[i]+"', 'ALL', 1, SIGN(INSTR('"+arrTrspModCd[i]+"', B.TRSP_CRR_MOD_CD))), B.TRSP_CRR_MOD_CD))";
//						arrSum = "('"+arrInputOffice[i]+"', '"+arrInputOffice[i]+"', '"+arrBndCd[i]+"', decode('"+arrTrspModCd[i]+"', 'ALL',  b.TRSP_CRR_MOD_CD , '"+arrTrspModCd[i]+"'))";
						
						condtions.add(arrSum);
					}
					
					velParam.put("condtions", condtions);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OptimumRoutePassDBDAOsearchOptmRoutPassDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OptmRoutPassDtlVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}