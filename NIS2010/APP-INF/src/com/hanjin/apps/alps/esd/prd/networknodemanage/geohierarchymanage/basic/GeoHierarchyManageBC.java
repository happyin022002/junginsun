/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : GeoHierarchyManageBC.java
 *@FileTitle : Geographic Hierarchy 정보관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-08-30
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-08-30 kimyoungchul
 * 1.0 최초 생성
 * 2009.07.01 alps framework 구조로 변경 Noh Seung Bae
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.geohierarchymanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.prd.networknodemanage.geohierarchymanage.vo.SearchGeoHierarchyManageVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * alps-PRD Business Logic Command Interface<br>
 * - alps-PRD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kimyoungchul
 * @see EsdPrd001EventResponse 참조
 * @since J2EE 1.4
 */
public interface GeoHierarchyManageBC{

	/**
	 * GeoHierarchyManageBC's searchGeoHierarchyList
	 * @param vo
	 * @return List
	 * @throws com.hanjin.framework.core.layer.event.EventException
	 */
	public List<SearchGeoHierarchyManageVO> searchGeoHierarchyList(SearchGeoHierarchyManageVO vo) throws EventException;
}
