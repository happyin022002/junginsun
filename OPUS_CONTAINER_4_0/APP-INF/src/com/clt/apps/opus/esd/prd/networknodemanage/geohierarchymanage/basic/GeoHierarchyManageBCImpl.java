/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : GeoHierarchyManageBCImpl.java
 *@FileTitle : Geographic Hierarchy Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.geohierarchymanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.prd.networknodemanage.geohierarchymanage.integration.GeoHierarchyManageDBDAO;
import com.clt.apps.opus.esd.prd.networknodemanage.geohierarchymanage.vo.SearchGeoHierarchyManageVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * PRD Business Logic Basic Command implementation<br>
 * 
 * @author kimyoungchul
 * @see EsdPrd001EventResponse,GeoHierarchyManageBC
 * @since J2EE 1.4
 */
public class GeoHierarchyManageBCImpl extends BasicCommandSupport implements GeoHierarchyManageBC{

	// Database Access Object
	private transient GeoHierarchyManageDBDAO dbDao = null;

	/**
	 * creating GeoHierarchyManageBCImpl Object<br>
	 * creating GeoHierarchyManageDBDAO<br>
	 */
	public GeoHierarchyManageBCImpl(){
		dbDao = new GeoHierarchyManageDBDAO();
	}

	/**
	 * retrieving - GeoHierarchyManage<br>
	 * @param vo
	 * @return List
	 * @throws com.clt.framework.core.layer.event.EventException
	 */
	@Override
	public List<SearchGeoHierarchyManageVO> searchGeoHierarchyList(SearchGeoHierarchyManageVO vo) throws EventException{
		try{
			return dbDao.searchGeoHierarchyManage(vo);
		}catch(DAOException ex){
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * biz scenario closing - PRD<br>
	 * clearing related objects<br>
	 */
	public void doEnd(){
		dbDao = null;
	}
}
