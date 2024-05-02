/*=========================================================
* Copyright(c) 2006 CyberLogitec
* @FileName : CommodityDBDAO.java
* @FileTitle : Commodity정보조회(공통 Popup)
* Open Issues :
* Change history :
* @LastModifyDate : 2006-08-03
* @LastModifier : sungseok, choi
* @LastVersion : 1.0
* 2006-08-03 sungseok, choi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.commodity.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.bizcommon.comm.Constants;
import com.hanjin.bizcommon.commodity.basic.CommodityBCImpl;
import com.hanjin.bizcommon.commodity.vo.SearchCommodityListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ENIS-BIZCOMMON에 대한 DB 처리를 담당<br>
 * ENIS-BIZCOMMON Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author sungseok, choi
 * @see CommodityBCImpl 참조
 * @since J2EE 1.4
 */
public class CommodityDBDAO extends DBDAOSupport {

    /**
     * Commodity 리스트 조회 <br>
     * @param String cmdtCd
     * @param String repCmdtCd
     * @param String repImdgLvlCd
     * @param String cmdtNm
     * @param int iPage
     * @return List<SearchCommodityListVO>
     * @throws DAOException
     */
    public List<SearchCommodityListVO> searchCommodityList(String cmdtCd, String repCmdtCd, String repImdgLvlCd, String cmdtNm, int iPage) throws DAOException {
        /**
         * Add Title	: Data Transfer Object Including Parameters 
         * Add Date		: 2006.08.03
         * Add Author	: sungseok, choi
         * @return
         */
    	List<SearchCommodityListVO> list = null;
    	DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        
   	
        /**
         * Add Title	: Page 처리 
         * Add Date		: 2006.08.03
         * Add Author	: sungseok, choi
         * @return
         */        
    	int currentPage = iPage;
   		int startPart   = Constants.PAGE_SIZE_5000 * (currentPage - 1) + 1;
   		int endPart     = Constants.PAGE_SIZE_5000 * currentPage;
		
        if(!cmdtCd.equals("")) {
			param.put("cmdt_cd", cmdtCd);
			velParam.put("cmdt_cd", cmdtCd);
		}     
        
        if(!repCmdtCd.equals("")) {
			param.put("rep_cmdt_cd", repCmdtCd);
			velParam.put("rep_cmdt_cd", repCmdtCd);
		}     

        if(!repImdgLvlCd.equals("")) {
			param.put("rep_imdg_lvl_cd",repImdgLvlCd);
			velParam.put("rep_imdg_lvl_cd", repImdgLvlCd);
		}     

        if(!cmdtNm.equals("")) {
			param.put("cmdt_nm", cmdtNm);
			velParam.put("cmdt_nm", cmdtNm);
		}     
        
        velParam.put("ipage", currentPage);
        param.put("startpart", startPart);
        param.put("endpart", endPart);
		
        try {
        	dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate)new CommodityDBDAOTotalCommodityRSQL(), param, velParam);
			int cnt = 0;
			if (dbRowset.next()) {
				cnt = dbRowset.getInt(1);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommodityDBDAOSearchCommodityListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCommodityListVO.class);
			if (cnt > 0)
				list.get(0).setMaxRows(cnt);  
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