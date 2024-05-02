/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : HubLocationMatchingManageBC.java
 *@FileTitle : HubLocation 정보관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-08-30
 *@LastModifier : jungsunyong
 *@LastVersion : 1.0
 * 2006-08-30 jungsunyong
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.hublocationmatchingmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.hublocationmatchingmanage.vo.SearchHubLocationListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-PRD Business Logic Command Interface<br>
 * - alps-PRD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author jungsunyong
 * @see ESD_PRD_004EventResponse 참조
 * @since J2EE 1.4
 */
public interface HubLocationMatchingManageBC{

	/**
	 * HubLocationMatchingManageBC's searchHubLocationMatchingManage
	 * @param searchHubLocationListVO
	 * @return EventResponse
	 * @throws EventException
	 */
	public List<SearchHubLocationListVO> searchHubLocationMatchingManage(SearchHubLocationListVO searchHubLocationListVO) throws EventException;

	/**
	 * 멀티이벤트처리
	 * HubLocationMatchingManageBC's multiHubLocationMatchingManage
	 * @param searchHubLocationListVO
	 * @param account
	 * @throws EventException
	 */
	public void multiHubLocationMatchingManage(SearchHubLocationListVO[] searchHubLocationListVO, SignOnUserAccount account) throws EventException;
}
