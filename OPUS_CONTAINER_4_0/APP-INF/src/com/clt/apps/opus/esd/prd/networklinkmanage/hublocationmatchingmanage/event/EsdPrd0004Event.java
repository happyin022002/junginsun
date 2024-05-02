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
package com.clt.apps.opus.esd.prd.networklinkmanage.hublocationmatchingmanage.event;

import com.clt.apps.opus.esd.prd.networklinkmanage.hublocationmatchingmanage.vo.SearchHubLocationListVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * 
 * @author jungsunyong
 * @see ESD_PRD_004Event , ESD_PRD_004EventResponse 참조
 * @since J2EE 1.4
 */
public class EsdPrd0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private SearchHubLocationListVO searchHubLocationListVO = null;
	private SearchHubLocationListVO[] searchHubLocationListVOs = null;

	/**
	 * 
	 * @return
	 */
	public SearchHubLocationListVO getSearchHubLocationListVO() {
		return searchHubLocationListVO;
	}

	/**
	 * 
	 * @param searchHubLocationListVO
	 */
	public void setSearchHubLocationListVO(SearchHubLocationListVO searchHubLocationListVO) {
		this.searchHubLocationListVO = searchHubLocationListVO;
	}

	/**
	 * 
	 * @return
	 */
	public SearchHubLocationListVO[] getSearchHubLocationListVOs() {
		SearchHubLocationListVO[] tmpVOs = null;
		if (this.searchHubLocationListVOs != null) {
			tmpVOs = new SearchHubLocationListVO[this.searchHubLocationListVOs.length];
			System.arraycopy(this.searchHubLocationListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param searchHubLocationListVOs
	 */
	public void setSearchHubLocationListVOs(SearchHubLocationListVO[] searchHubLocationListVOs) {
		if (searchHubLocationListVOs != null) {
			SearchHubLocationListVO[] tmpVOs = new SearchHubLocationListVO[searchHubLocationListVOs.length];
			System.arraycopy(searchHubLocationListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchHubLocationListVOs = tmpVOs;
		}
	}
}