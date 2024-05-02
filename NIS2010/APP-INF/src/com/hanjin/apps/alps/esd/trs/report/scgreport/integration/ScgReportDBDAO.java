/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ScgReportDBDAO.java
*@FileTitle : Surcharge Report
*Open Issues :
*Change history :
*@LastModifyDate : 2013-10-16
*@LastModifier : 조인영
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.scgreport.integration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.report.scgreport.vo.ScgCondVO;
import com.hanjin.apps.alps.esd.trs.report.scgreport.vo.ScgDtlVO;
import com.hanjin.apps.alps.esd.trs.report.scgreport.vo.ScgSmryVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS ScgReportDBDAO <br>
 * - ALPS-Surcharge Report system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 조인영
 * @see ScgReportBCImpl 참조
 * @since J2EE 1.6
 */
public class ScgReportDBDAO extends DBDAOSupport {

	/**
	 * Surcharge Report - Summary<br>
	 * 
	 * @param ScgCondVO ScgCondVO
	 * @return List<ScgSmryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ScgSmryVO> searchScgSmry(ScgCondVO ScgCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgSmryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ScgCondVO != null){
				Map<String, String> mapVO = ScgCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScgReportDBDAOsearchScgSmryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgSmryVO .class);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * Surcharge Report - Detail<br>
	 * 
	 * @param ScgCondVO ScgCondVO
	 * @return List<ScgDtlVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ScgDtlVO> searchScgDtl(ScgCondVO ScgCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ScgCondVO != null){
				Map<String, String> mapVO = ScgCondVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				if(!"SINGLE".equals(ScgCondVO.getSelOpTp())){
				
					List<String> conditions = new ArrayList<String>();
					String strComma = "#";
					
					String[] arrWoOfcCd =  ScgCondVO.getWoOfcCd().split(strComma);
					String[] arrInvOfcCd = ScgCondVO.getInvOfcCd().split(strComma);
					String[] arrMonth = ScgCondVO.getMonth().split(strComma);
					String arrSum = "";
					
					if("inv".equals(ScgCondVO.getSelDate())){
						for(int i = 0; i < arrMonth.length; i ++){
							arrSum = "";
							arrSum = "(1=1 AND C.CRE_OFC_CD = '"+arrWoOfcCd[i]+"' AND D.CRE_OFC_CD = '"+arrInvOfcCd[i]+"' AND D.INV_CFM_DT BETWEEN TO_DATE(REPLACE('"+arrMonth[i]+"','-','')||'01', 'YYYYMMDD') AND LAST_DAY(TO_DATE(REPLACE('"+arrMonth[i]+"','-',''),'YYYYMM'))+0.99999999)";
							conditions.add(arrSum);
						}
					}else{
						for(int i = 0; i < arrMonth.length; i ++){
							arrSum = "";
							arrSum = "(1=1 AND C.CRE_OFC_CD = '"+arrWoOfcCd[i]+"' AND D.CRE_OFC_CD = '"+arrInvOfcCd[i]+"' AND E.LOCL_CRE_DT BETWEEN TO_DATE(REPLACE('"+arrMonth[i]+"','-','')||'01', 'YYYYMMDD') AND LAST_DAY(TO_DATE(REPLACE('"+arrMonth[i]+"','-',''),'YYYYMM'))+0.99999999)";
							conditions.add(arrSum);
						}
					}
					velParam.put("conditions", conditions);
				}
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScgReportDBDAOsearchScgDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgDtlVO .class);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

}