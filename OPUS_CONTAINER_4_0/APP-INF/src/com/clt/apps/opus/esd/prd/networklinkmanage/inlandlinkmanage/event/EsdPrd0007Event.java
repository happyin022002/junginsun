/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0007Event.java
 *@FileTitle : Link  List 정보조회
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-25
 *@LastModifier : jungsunyong
 *@LastVersion : 1.0
 * 2006-09-25 jungsunyong
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.event;

import com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.vo.SearchInlandLinkManageListVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_007HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author jungsunyong
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0007Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private SearchInlandLinkManageListVO searchInlandLinkManageListVO = null;
	private SearchInlandLinkManageListVO[] searchInlandLinkManageListVOs = null;
	private String row = "";

	/**
	 * 
	 * @return
	 */
	public String getRow() {
		return row;
	}

	/**
	 * 
	 * @param row
	 */
	public void setRow(String row) {
		this.row = row;
	}

	/**
	 * 
	 * @return
	 */
	public SearchInlandLinkManageListVO getSearchInlandLinkManageListVO() {
		return searchInlandLinkManageListVO;
	}

	/**
	 * 
	 * @param searchInlandLinkManageListVO
	 */
	public void setSearchInlandLinkManageListVO(SearchInlandLinkManageListVO searchInlandLinkManageListVO) {
		this.searchInlandLinkManageListVO = searchInlandLinkManageListVO;
	}

	/**
	 * 
	 * @return
	 */
	public SearchInlandLinkManageListVO[] getSearchInlandLinkManageListVOs() {
		SearchInlandLinkManageListVO[] tmpVOs = null;
		if (this.searchInlandLinkManageListVOs != null) {
			tmpVOs = new SearchInlandLinkManageListVO[this.searchInlandLinkManageListVOs.length];
			System.arraycopy(this.searchInlandLinkManageListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param searchInlandLinkManageListVOs
	 */
	public void setSearchInlandLinkManageListVOs(SearchInlandLinkManageListVO[] searchInlandLinkManageListVOs) {
		if (searchInlandLinkManageListVOs != null) {
			SearchInlandLinkManageListVO[] tmpVOs = new SearchInlandLinkManageListVO[searchInlandLinkManageListVOs.length];
			System.arraycopy(searchInlandLinkManageListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchInlandLinkManageListVOs = tmpVOs;
		}
	}
}
