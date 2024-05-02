/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : EsdPrd0003Event.java
 *@FileTitle : YardManage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-24
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-10-24 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.event;

import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.vo.SearchLeaseListVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author kimyoungchul
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0003Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public EsdPrd0003Event() {
	}

	private SearchLeaseListVO searchLeaseListRSQLVO = null;
	private SearchLeaseListVO[] searchLeaseListRSQLVOs = null;

	/**
	 * 
	 * @return
	 */
	public SearchLeaseListVO getSearchLeaseListRSQLVO() {
		return searchLeaseListRSQLVO;
	}

	/**
	 * 
	 * @param searchLeaseListRSQLVO
	 */
	public void setSearchLeaseListRSQLVO(SearchLeaseListVO searchLeaseListRSQLVO) {
		this.searchLeaseListRSQLVO = searchLeaseListRSQLVO;
	}

	/**
	 * 
	 * @return
	 */
	public SearchLeaseListVO[] getSearchLeaseListRSQLVOs() {
		SearchLeaseListVO[] tmpVOs = null;
		if (this.searchLeaseListRSQLVOs != null) {
			tmpVOs = new SearchLeaseListVO[this.searchLeaseListRSQLVOs.length];
			System.arraycopy(this.searchLeaseListRSQLVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	/**
	 * 
	 * @param searchLeaseListRSQLVOs
	 */
	public void setSearchLeaseListRSQLVOs(SearchLeaseListVO[] searchLeaseListRSQLVOs) {
		if (searchLeaseListRSQLVOs != null) {
			SearchLeaseListVO[] tmpVOs = new SearchLeaseListVO[searchLeaseListRSQLVOs.length];
			System.arraycopy(searchLeaseListRSQLVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchLeaseListRSQLVOs = tmpVOs;
		}
	}
}
