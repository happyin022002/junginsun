/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SubContinentDBDAO.java
*@FileTitle : SubContinent
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-16
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-10-16 Hyung Choon_Roh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.scontinent.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.hanjin.bizcommon.scontinent.basic.SubContinentBCImpl;
import com.hanjin.bizcommon.scontinent.vo.SearchSubContinentListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
//import com.hanjin.bizcommon.comm.Constants;
/**
 * eNIS-BIZCOMMON에 대한 DB 처리를 담당<br>
 * - eNIS-BIZCOMMON Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Hyung Choon_Roh
 * @see SubContinentBCImpl 참조
 * @since J2EE 1.4
 */
public class SubContinentDBDAO extends DBDAOSupport {

	/**
     * 1. 기능 : Continent count<p>
     * 2. 처리개요 : Continent의 총 카운트를 조회한다.<p>
     * - totalContinent<p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : HyungChoonRoh/2006.08.03<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
	 * @param SearchSubContinentListVO searchSubContinentListVO
     * @return int
     * @throws DAOException
     *
     */
	public int totalContinent(SearchSubContinentListVO searchSubContinentListVO) throws DAOException {
		DBRowSet dbRowset = null;
    	// PDTO(Data Transfer Object including Parameters)
        try {
        	Map<String,String> mapParam = new HashMap<String,String>();
        	if(!searchSubContinentListVO.getContiCd().equals("")){
        		mapParam.put("sconti_cd", searchSubContinentListVO.getContiCd());
        	}
        	if(!searchSubContinentListVO.getContiNm().equals("")){
        		mapParam.put("sconti_nm", searchSubContinentListVO.getContiNm());
        	}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SubContinentDBDAOTotalContinentRSQL(), mapParam, mapParam);
			if (dbRowset.next()) {
				return dbRowset.getInt(1);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return 0;
	}
	
	/**
	 * SubContinent의 모든 목록을 가져온다.<br>
	 * @param SearchSubContinentListVO searchSubContinentListVO
	 * @param int iPage
	 * @return List<SearchSubContinentListVO>
	 * @throws DAOException
	 */
	public List<SearchSubContinentListVO> searchSubContinentList(SearchSubContinentListVO searchSubContinentListVO, int iPage) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
    	DBRowSet dbRowset = null;
		//List
		List<SearchSubContinentListVO> list = null; 
		
		//Map<String, Object> param = new HashMap<String, Object>();
    	Map<String,String> mapParam = new HashMap<String,String>();
        // 페이징 처리
		//int currentPage = iPage;
		//int startPart   = Constants.PAGE_SIZE_50 * (currentPage - 1) + 1;
		//int endPart     = Constants.PAGE_SIZE_50 * currentPage;
    	
    	if(!searchSubContinentListVO.getContiCd().equals("")){
    		mapParam.put("sconti_cd", searchSubContinentListVO.getContiCd());
    	}
    	if(!searchSubContinentListVO.getContiNm().equals("")){
    		mapParam.put("sconti_nm", searchSubContinentListVO.getContiNm());
    	}
		//param.put("startpart", startPart);
		//param.put("endpart", endPart);
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SubContinentDBDAOSearchSubContinentListRSQL(), mapParam, mapParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSubContinentListVO.class);
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