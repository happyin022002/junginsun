/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : EsdPrd0054Event.java
 *@FileTitle : Inland Route 정보관리화면
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-02-10
 *@LastModifier : noh seung bae
 *@LastVersion : 1.0
 * 2010-02-10 noh seung bae
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandmulticreation.event;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandmulticreation.vo.SearchInlandRouteVO;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_0054 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_0054HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author noh seung bae
 * @see HTMLAction 참조
 * @since J2EE 1.5
 */
public class EsdPrd0054Event extends EventSupport{

	private SearchInlandRouteVO searchInlandRouteVO;
	private SearchInlandRouteVO[] searchInlandRouteVOs;

	/**
	 * @return the searchInlandRouteVO
	 */
	public SearchInlandRouteVO getSearchInlandRouteVO(){
		return searchInlandRouteVO;
	}

	/**
	 * @param searchInlandRouteVO the searchInlandRouteVO to set
	 */
	public void setSearchInlandRouteVO(SearchInlandRouteVO searchInlandRouteVO){
		this.searchInlandRouteVO = searchInlandRouteVO;
	}

	/**
	 * @return the searchInlandRouteVOs
	 */
	public SearchInlandRouteVO[] getSearchInlandRouteVOs(){
		return searchInlandRouteVOs;
	}

	/**
	 * @param searchInlandRouteVOs the searchInlandRouteVOs to set
	 */
	public void setSearchInlandRouteVOs(SearchInlandRouteVO[] searchInlandRouteVOs){
		this.searchInlandRouteVOs = searchInlandRouteVOs;
	}
}
