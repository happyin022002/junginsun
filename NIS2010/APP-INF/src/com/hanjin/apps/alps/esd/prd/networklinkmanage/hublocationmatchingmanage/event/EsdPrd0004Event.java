/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0004Event.java
 *@FileTitle : HubLocation 정보관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-08-30
 *@LastModifier : jungsunyong
 *@LastVersion : 1.0
 * 2006-08-30 jungsunyong
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.hublocationmatchingmanage.event;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.hublocationmatchingmanage.vo.SearchHubLocationListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 *
 * @author jungsunyong
 * @see ESD_PRD_004Event , ESD_PRD_004EventResponse 참조
 * @since J2EE 1.4
 */
public class EsdPrd0004Event extends EventSupport{

	private static final long serialVersionUID = 1L;
	private SearchHubLocationListVO searchHubLocationListVO = null;
	private SearchHubLocationListVO[] searchHubLocationListVOs = null;

	/**
	 *
	 * @return
	 */
	public SearchHubLocationListVO getSearchHubLocationListVO(){
		return searchHubLocationListVO;
	}

	/**
	 *
	 * @param searchHubLocationListVO
	 */
	public void setSearchHubLocationListVO(
			SearchHubLocationListVO searchHubLocationListVO){
		this.searchHubLocationListVO = searchHubLocationListVO;
	}

	/**
	 *
	 * @return
	 */
	public SearchHubLocationListVO[] getSearchHubLocationListVOs(){
		return searchHubLocationListVOs;
	}

	/**
	 *
	 * @param searchHubLocationListVOs
	 */
	public void setSearchHubLocationListVOs(SearchHubLocationListVO[] searchHubLocationListVOs){
		this.searchHubLocationListVOs = searchHubLocationListVOs;
	}
}
