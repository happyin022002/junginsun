/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ExceptionDataDBDAO.java
*@FileTitle : ExceptionData Manage
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-05
*@LastModifier : Se-Hoon PARK
*@LastVersion : 1.0
* 2006-08-29 Se-Hoon PARK
* 1.0 최초 생성
* 
* 2009-04-10 iskim 
* 	(1) N200904030080	[SCEM] Actual Data Receiving Status 기능 보완
* 		기존 method 모두 주석처리
* 		searchPagedActualSourceList, searchTotCnt method 추가
* 2011.07.06 손은주 [CHM-201111830]Split 13-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 - 의미없는 주석 및 미사용 소스 제거		
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.activitydata.basic.ActivityDataBCImpl;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.vo.SearchActualDataInfoVO;
import com.hanjin.apps.alps.esd.sce.masterdatamanage.actualdata.vo.SearchActualDataListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmActivityVO;

/**
 * ENIS-SCEM Commission에 대한 DB 처리를 담당<br>
 * - ENIS-SCEM Commission Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Se-Hoon PARK
 * @see ActivityDataBCImpl 참조
 * @since J2EE 1.4
 */
public class ActualDataDBDAO extends DBDAOSupport {
    
    /**
     * Actual Source Registration 조회<br>
     * N200904030080	[SCEM] Actual Data Receiving Status 기능 보완 으로 최초 추가
     * 
     * @param SearchActualDataInfoVO actInfo
     * @return List<SearchActualDataListVO>
     * @throws DAOException
     */
	public List<SearchActualDataListVO> searchPagedActualSourceList(SearchActualDataInfoVO actInfo) throws DAOException {

		log.debug("searchPagedActualSourceList 실행합니다.");
    	DBRowSet dbRowset = null;
		List<SearchActualDataListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (actInfo != null) {
				Map<String, String> mapVO = actInfo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				log.debug("velParam==" + velParam);
			}
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new ActualDataDBDAOSearchActualDataListRSQL(),
					param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,SearchActualDataListVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Activity 콤보를 조회 합니다.<br>
	 * 
	 * @return List<MdmActivityVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmActivityVO> searchActivityCombo() throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmActivityVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ActualDataDBDAOSearchActualCodeListRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmActivityVO .class);
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

