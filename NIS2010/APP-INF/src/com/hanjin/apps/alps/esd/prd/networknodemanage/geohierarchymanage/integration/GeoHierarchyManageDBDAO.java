/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : GeoHierarchyManageDBDAO.java
 *@FileTitle : Geographic Hierarchy 정보관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-08-30
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-08-30 kimyoungchul
 * 1.0 최초 생성
 * N200903020010 2009-03-02 'Geographical Inquiry' 화면 변경 요청
 * 2009.07.01 alps framework 구조로 변경 Noh Seung Bae
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.geohierarchymanage.integration;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.prd.networknodemanage.geohierarchymanage.vo.SearchGeoHierarchyManageVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * alps-PRD에 대한 DB 처리를 담당<br>
 * - alps-PRD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author kimyoungchul
 * @see GeoHierarchyManageBCImpl 참조
 * @since J2EE 1.4
 */
public class GeoHierarchyManageDBDAO extends DBDAOSupport{

	/**
	 * GeoHierarchyManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * N200903020010 2009-03-02 'Geographical Inquiry' 화면 변경 요청
	 * @param vo
	 * @return List<SearchGeoHierarchyManageVO>
	 * @throws DAOException
	 */
	public List<SearchGeoHierarchyManageVO> searchGeoHierarchyManage(SearchGeoHierarchyManageVO vo) throws DAOException{
		List<SearchGeoHierarchyManageVO> list = null;
		Map<String, String> mapVO = null;

		try{
			if(vo != null){
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery(
					(ISQLTemplate) new GeoHierarchyManageDBDAOSearchGeoHierarchyManageRSQL(), mapVO, mapVO, SearchGeoHierarchyManageVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}
