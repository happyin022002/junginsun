/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : LaneDBDAO.java
*@FileTitle : Lane 조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-09
*@LastModifier : Hyung Choon
*@LastVersion : 1.0
* 2006-08-09 Hyung Choon
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.lane.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.bizcommon.comm.Constants;
import com.hanjin.bizcommon.lane.basic.LaneBCImpl;
import com.hanjin.bizcommon.lane.vo.SearchLaneListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ENIS-BIZCOMMON에 대한 DB 처리를 담당<br>
 * - ENIS-BIZCOMMON Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Hyung Choon
 * @see LaneBCImpl 참조
 * @since J2EE 1.4
 */
public class LaneDBDAO extends DBDAOSupport {

	/**
	 * Lane의 모든 목록을 가져온다.<br>
	 * @param tradeCd
	 * @param subTradeCd
	 * @param svcTp
	 * @param laneCd
	 * @param laneNm
	 * @param mode
	 * @param iPage
	 * @return List<SearchLaneListVO>
	 * @throws DAOException
	 */
    public List<SearchLaneListVO> searchLaneList(String tradeCd, String subTradeCd, String svcTp, String laneCd, String laneNm, String mode, int iPage) throws DAOException {
    	// PDTO(Data Transfer Object including Parameters)
    	List<SearchLaneListVO> list = null;
		DBRowSet dbRowset = null;
		
    	try{
            // 페이징 처리
    		int currentPage = iPage;
    		int startPart   = Constants.PAGE_SIZE_5000 * (currentPage - 1) + 1;
    		int endPart     = Constants.PAGE_SIZE_5000 * currentPage;

    		Map<String, Object> param = new HashMap<String, Object>();

    		param.put("trade_cd", tradeCd);
    		param.put("sub_trade_cd", subTradeCd);
    		param.put("mode", mode);
    		param.put("svc_tp", svcTp);
    		param.put("lane_cd", laneCd);
    		param.put("lane_nm", laneNm);
    		param.put("startpart", startPart);
    		param.put("endpart", endPart);
    		
    		dbRowset =  new SQLExecuter("").executeQuery((ISQLTemplate)new LaneDBDAOTotalLaneRSQL(), param, param);
			int cnt = 0;
			if (dbRowset.next()) {
				cnt = dbRowset.getInt(1);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LaneDBDAOSearchLaneListRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLaneListVO.class);
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