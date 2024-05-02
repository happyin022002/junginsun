/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : GeoHierarchyManageBC.java
 *@FileTitle : Geographic Hierarchy Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.geohierarchymanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.prd.networknodemanage.geohierarchymanage.vo.SearchGeoHierarchyManageVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * PRD Business Logic Command Interface<br>
 *
 * @author kimyoungchul
 * @see EsdPrd001EventResponse 
 * @since J2EE 1.4
 */
public interface GeoHierarchyManageBC{

	/**
	 * GeoHierarchyManageBC's searchGeoHierarchyList
	 * @param vo
	 * @return List
	 * @throws com.clt.framework.core.layer.event.EventException
	 */
	public List<SearchGeoHierarchyManageVO> searchGeoHierarchyList(SearchGeoHierarchyManageVO vo) throws EventException;
}
