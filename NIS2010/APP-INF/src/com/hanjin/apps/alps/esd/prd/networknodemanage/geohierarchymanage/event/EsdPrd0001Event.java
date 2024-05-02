/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0001Event.java
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
package com.hanjin.apps.alps.esd.prd.networknodemanage.geohierarchymanage.event;

import com.hanjin.apps.alps.esd.prd.networknodemanage.geohierarchymanage.vo.SearchGeoHierarchyManageVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_001 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimyoungchul
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0001Event extends EventSupport{

	/**
	 * 
	 */
	public EsdPrd0001Event(){
	}
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchGeoHierarchyManageVO searchGeoHierarchyManageVO;

	/**
	 *
	 * @return
	 */
	public SearchGeoHierarchyManageVO getSearchGeoHierarchyManageVO(){
		return searchGeoHierarchyManageVO;
	}

	/**
	 *
	 * @param searchGeoHierarchyManageVO
	 */
	public void setSearchGeoHierarchyManageVO(SearchGeoHierarchyManageVO searchGeoHierarchyManageVO){
		this.searchGeoHierarchyManageVO = searchGeoHierarchyManageVO;
	}
}
