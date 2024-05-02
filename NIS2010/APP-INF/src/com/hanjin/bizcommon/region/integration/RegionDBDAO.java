/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RegionDBDAO.java
*@FileTitle : Region
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-16
*@LastModifier : Hyung Choon_Roh
*@LastVersion : 1.0
* 2006-10-16 Hyung Choon_Roh
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.region.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.hanjin.bizcommon.comm.Constants;
import com.hanjin.bizcommon.region.basic.RegionBCImpl;
import com.hanjin.bizcommon.region.vo.SearchRegionListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * eNIS-BIZCOMMON에 대한 DB 처리를 담당<br>
 * - eNIS-BIZCOMMON Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Hyung Choon_Roh
 * @see RegionBCImpl 참조
 * @since J2EE 1.4
 */
public class RegionDBDAO extends DBDAOSupport {

	/**
     * 1. 기능 : Region count<p>
     * 2. 처리개요 : Region의 총 카운트를 조회한다.<p> 
     * - totalRegion<p>
     * 3. 주의사항 : <p>
     * ===================================<br>
     * 4. 작성자/작성일 : HyungChoonRoh/2006.10.16<br>
     * ===================================<br>
     * 5. 수정사항<p>
     * 5.1 요구사항 ID :<p>
     * - 수정자/수정일 :<p>
     * - 수정사유/내역 :<p>
     * ===================================<br>
     * <p/>
	 * @param SearchRegionListVO searchRegionListVO
     * @return int
     * @throws DAOException
     *
     */
	public int totalRegion(SearchRegionListVO searchRegionListVO) throws DAOException {
		DBRowSet dbRowset = null;
    	// PDTO(Data Transfer Object including Parameters)
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

        try {
			if(!searchRegionListVO.getCntCd().equals("")) {
				param.put("cnt_cd", searchRegionListVO.getCntCd());
				velParam.put("cnt_cd", searchRegionListVO.getCntCd());
			}
			if(!searchRegionListVO.getRgnCd().equals("")) {
				param.put("rgn_cd", searchRegionListVO.getRgnCd());
				velParam.put("rgn_cd", searchRegionListVO.getRgnCd());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RegionDBDAOTotalRegionRSQL(), param, velParam);
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
	 * Region의 모든 목록을 가져온다.<br>
	 * @param SearchRegionListVO searchRegionListVO
	 * @param int iPage
	 * @return List<SearchRegionListVO>
	 * @throws DAOException
	 */
	public List<SearchRegionListVO> searchRegionList(SearchRegionListVO searchRegionListVO, int iPage) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
    	DBRowSet dbRowset = null;
		//List
		List<SearchRegionListVO> list = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        // 페이징 처리
		int currentPage = iPage;
		int startpart   = Constants.PAGE_SIZE_5000 * (currentPage - 1) + 1;
		int endpart     = Constants.PAGE_SIZE_5000 * currentPage;
		
		try{
			if(!searchRegionListVO.getCntCd().equals("")) {
				param.put("cnt_cd", searchRegionListVO.getCntCd());
				velParam.put("cnt_cd", searchRegionListVO.getCntCd());
			}
			if(!searchRegionListVO.getRgnCd().equals("")) {
				param.put("rgn_cd", searchRegionListVO.getRgnCd());
				velParam.put("rgn_cd", searchRegionListVO.getRgnCd());
			}
			param.put("startpart", startpart);
			param.put("endpart", endpart);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RegionDBDAOSearchRegionListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRegionListVO.class);
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