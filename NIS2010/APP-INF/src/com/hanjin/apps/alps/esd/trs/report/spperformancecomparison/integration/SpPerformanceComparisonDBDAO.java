/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SpPerformanceComparisonDBDAO.java
*@FileTitle : S/P Performace Comparison Report
*Open Issues :
*Change history :
*@LastModifyDate : 2016-05-18
*@LastModifier : CJH
*@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esd.trs.report.spperformancecomparison.integration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.report.spperformancecomparison.basic.SpPerformanceComparisonBCImpl;
import com.hanjin.apps.alps.esd.trs.report.spperformancecomparison.vo.ComparisonCondVO;
import com.hanjin.apps.alps.esd.trs.report.spperformancecomparison.vo.SearchComparisonVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS SpPerformanceComparisonDBDAO <br>
 * - S/P Performace Comparison Report system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CJH
 * @see SpPerformanceComparisonBCImpl 참조
 * @since J2EE 1.6
 */
public class SpPerformanceComparisonDBDAO extends DBDAOSupport {

	/**
	 * S/P Performace Comparison Report<br>
	 * 
	 * @param ComparisonCondVO comparisonCondVO
	 * @return List<SearchComparisonVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchComparisonVO> searchComparison(ComparisonCondVO comparisonCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchComparisonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(comparisonCondVO != null){			
				Map<String, String> mapVO = comparisonCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				List<String> ofcCdList = new ArrayList();
				String sOfcCd = JSPUtil.getNull(comparisonCondVO.getSelInputOffice());
				if(!sOfcCd.equals("")){
					String arrOfcCd[] = sOfcCd.split(",");
					for(int i=0;i<arrOfcCd.length;i++){   
						ofcCdList.add(arrOfcCd[i]);   
					} 
				}
				param.put("arr_ofc_cd",ofcCdList);
				velParam.put("arr_ofc_cd",ofcCdList);

				List<String> bkgNoList = new ArrayList();
				String sBkgNo = JSPUtil.getNull(comparisonCondVO.getSelBkgno());
				if(!sBkgNo.equals("")){
					String arrBkgNo[] = sBkgNo.split(",");
					for(int i=0;i<arrBkgNo.length;i++){   
						bkgNoList.add(arrBkgNo[i]);   
					} 
				}
				param.put("arr_bkg_no",bkgNoList);
				velParam.put("arr_bkg_no",bkgNoList);
				
				
				List<String> eqNoList = new ArrayList();
				String sEqNo = JSPUtil.getNull(comparisonCondVO.getSelCntrno());
				if(!sEqNo.equals("")){
					String arrEqNo[] = sEqNo.split(",");
					for(int i=0;i<arrEqNo.length;i++){   
						eqNoList.add(arrEqNo[i]);   
					} 
				}
				param.put("arr_eq_no",eqNoList);
				velParam.put("arr_eq_no",eqNoList);
				
				List<String> soNoList = new ArrayList();
				String sSoNo = JSPUtil.getNull(comparisonCondVO.getSelSono());
				if(!sSoNo.equals("")){
					String arrSoNo[] = sSoNo.split(",");
					for(int i=0;i<arrSoNo.length;i++){   
						soNoList.add(arrSoNo[i]);   
					} 
				}
				param.put("arr_so_no",soNoList);
				velParam.put("arr_so_no",soNoList);
				
				List<String> woNoList = new ArrayList();
				String sWoNo = JSPUtil.getNull(comparisonCondVO.getSelWono());
				if(!sWoNo.equals("")){
					String arrWoNo[] = sWoNo.split(",");
					for(int i=0;i<arrWoNo.length;i++){   
						woNoList.add(arrWoNo[i]);   
					} 
				}
				param.put("arr_wo_no",woNoList);
				velParam.put("arr_wo_no",woNoList);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpPerformanceComparisonDBDAOsearchComparisonRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchComparisonVO.class);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

}