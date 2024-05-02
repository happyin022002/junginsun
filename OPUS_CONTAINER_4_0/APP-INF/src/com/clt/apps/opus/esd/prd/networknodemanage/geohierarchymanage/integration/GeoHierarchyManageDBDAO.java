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
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.geohierarchymanage.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.prd.networknodemanage.geohierarchymanage.vo.SearchGeoHierarchyManageVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * PRD에 대한 DB 처리를 담당<br>
 * PRD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author kimyoungchul
 * @see GeoHierarchyManageBCImpl 참조
 * @since J2EE 1.4
 */
public class GeoHierarchyManageDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * GeoHierarchyManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * N200903020010 2009-03-02 'Geographical Inquiry' 화면 변경 요청
	 * 
	 * @param vo
	 * @return List<SearchGeoHierarchyManageVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchGeoHierarchyManageVO> searchGeoHierarchyManage(SearchGeoHierarchyManageVO vo) throws DAOException {
		List<SearchGeoHierarchyManageVO> list = new ArrayList<SearchGeoHierarchyManageVO>();
		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if (vo != null) {
				mapVO = vo.getColumnValues();
			}
			list = (List) new SQLExecuter("").executeQuery((ISQLTemplate) new GeoHierarchyManageDBDAOSearchGeoHierarchyManageRSQL(), mapVO, mapVO, SearchGeoHierarchyManageVO.class);
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
