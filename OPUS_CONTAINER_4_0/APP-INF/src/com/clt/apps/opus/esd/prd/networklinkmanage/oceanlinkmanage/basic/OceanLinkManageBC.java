/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : OceanLinkManageBC.java
 *@FileTitle : OceanLink 정보관리 (본사관리)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-19
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-09-19 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.vo.SaveOceanLinkRHQVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.vo.SaveOceanLinkVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.vo.SearchOceanLinkRHQVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanlinkmanage.vo.SearchOceanLinkVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * PRD Business Logic Command Interface<br>
 * PRD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kimyoungchul
 * @see ESD_PRD_012EventResponse 참조
 * @since J2EE 1.4
 */
public interface OceanLinkManageBC{

	/**
	 * 조회 이벤트 처리<br>
	 * OceanLinkManage화면에 대한 조회 이벤트 처리<br>
	 * ★2009-09-14 kim kwijin생성
	 * @param vo
	 * @return response ESD_PRD_012EventResponse
	 * @exception EventException
	 */
	public List<SearchOceanLinkVO> searchOceanLinkList(SearchOceanLinkVO vo) throws EventException;

	/**
	 * 수정 이벤트 처리<br>
	 * ESD_PRD_012 에 대한 추가 이벤트 처리<br>
	 * ★2009-09-15 kim kwijin생성
	 * @param vos
	 * @param account
	 * @return String
	 * @throws EventException
	 */
	public String modifyOceanLink(SaveOceanLinkVO[] vos, SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * ESD_PRD_013 화면에 대한 조회 이벤트 처리<br>
	 * ★2009-09-16 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchOceanLinkRHQVO> searchOceanLinkListRHQ(SearchOceanLinkRHQVO vo) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_PRD_013 화면에 대한 멀티 이벤트 처리<br>
	 * ★2009-09-17 kim kwijin생성
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	public void multiOceanLinkRHQ(SaveOceanLinkRHQVO[] vos, SignOnUserAccount account) throws EventException;
}
