/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : EsdTrs0977Event.java
 *@FileTitle : Change Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier :
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderissue.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo.SearchTrsSvcOrdBkgChmHisVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo.WoIssueListVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0977 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0977HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author poong_yeon
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0977Event extends EventSupport {

	private WoIssueListVO[] woIssueListVOs = null;

	private SearchTrsSvcOrdBkgChmHisVO[] searchTrsSvcOrdBkgChmHisVOs = null;

	public WoIssueListVO[] getWoIssueListVOs() {
		WoIssueListVO[] rtnVOs = null;
		if (this.woIssueListVOs != null) {
			rtnVOs = Arrays.copyOf(this.woIssueListVOs, this.woIssueListVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setWoIssueListVOs(WoIssueListVO[] woIssueListVOs) {
		if (woIssueListVOs != null) {
			WoIssueListVO[] tmpVOs = Arrays.copyOf(woIssueListVOs, woIssueListVOs.length);
			this.woIssueListVOs = tmpVOs;
		} // end if
	}

	public SearchTrsSvcOrdBkgChmHisVO[] getSearchTrsSvcOrdBkgChmHisVOs() {
		SearchTrsSvcOrdBkgChmHisVO[] rtnVOs = null;
		if (this.searchTrsSvcOrdBkgChmHisVOs != null) {
			rtnVOs = Arrays.copyOf(this.searchTrsSvcOrdBkgChmHisVOs, this.searchTrsSvcOrdBkgChmHisVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setSearchTrsSvcOrdBkgChmHisVOs(SearchTrsSvcOrdBkgChmHisVO[] searchTrsSvcOrdBkgChmHisVOs) {
		if (searchTrsSvcOrdBkgChmHisVOs != null) {
			SearchTrsSvcOrdBkgChmHisVO[] tmpVOs = Arrays.copyOf(searchTrsSvcOrdBkgChmHisVOs, searchTrsSvcOrdBkgChmHisVOs.length);
			this.searchTrsSvcOrdBkgChmHisVOs = tmpVOs;
		} // end if
	}

}
