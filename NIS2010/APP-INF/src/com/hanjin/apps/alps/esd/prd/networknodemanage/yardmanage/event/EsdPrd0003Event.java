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
package com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.event;

import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchLeaseListVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_PRD_003 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_PRD_003HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author kimyoungchul
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdPrd0003Event extends EventSupport{

	private SearchLeaseListVO searchLeaseListRSQLVO = null;
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public EsdPrd0003Event(){
	}
	private SearchLeaseListVO[] searchLeaseListRSQLVOs = null;

	/**
	 *
	 * @return
	 */
	public SearchLeaseListVO getSearchLeaseListRSQLVO(){
		return searchLeaseListRSQLVO;
	}

	/**
	 *
	 * @param searchLeaseListRSQLVO
	 */
	public void setSearchLeaseListRSQLVO(SearchLeaseListVO searchLeaseListRSQLVO){
		this.searchLeaseListRSQLVO = searchLeaseListRSQLVO;
	}

	/**
	 *
	 * @return
	 */
	public SearchLeaseListVO[] getSearchLeaseListRSQLVOs(){
		return searchLeaseListRSQLVOs;
	}

	/**
	 *
	 * @param searchLeaseListRSQLVOs
	 */
	public void setSearchLeaseListRSQLVOs(SearchLeaseListVO[] searchLeaseListRSQLVOs){
		this.searchLeaseListRSQLVOs = searchLeaseListRSQLVOs;
	}
}
