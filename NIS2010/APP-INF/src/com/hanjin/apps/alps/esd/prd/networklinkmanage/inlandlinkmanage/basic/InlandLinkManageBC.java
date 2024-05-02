/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : InlandLinkManageBC.java
 *@FileTitle : Inland Link 정보관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-19
 *@LastModifier : jungsunyong
 *@LastVersion : 1.0
 * 2006-09-19 jungsunyong
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.basic;

import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.vo.PrdInlndEachLnkVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandlinkmanage.vo.SearchInlandLinkManageListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-PRD Business Logic Command Interface<br>
 * - alps-PRD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author jungsunyong
 * @see ESD_PRD_009EventResponse 참조
 * @since J2EE 1.4
 */
public interface InlandLinkManageBC{

	/**
	 * InlandLinkManageBC's multiInlandLinkManage
	 * ★2009-08-13 KIM KWIJIN 생성
	 * @param vo
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public Map<String, String> multiInlandLinkManage(SearchInlandLinkManageListVO[] vo, SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * ★2009-08-14 KIM KWIJIN 수정
	 * InlandLinkManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param vo
	 * @return response ESD_PRD_009EventResponse
	 * @exception EventException
	 */
	public List<PrdInlndEachLnkVO> searchInlandLinkManageList(PrdInlndEachLnkVO vo) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchInlandLinkManageListVO> searchInlandLinkManagePopup(SearchInlandLinkManageListVO vo) throws EventException;

	/**
	 * 
	 * @param vo
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public List<PrdInlndEachLnkVO> multiAgmtNo(PrdInlndEachLnkVO[] vo, SignOnUserAccount account) throws EventException;
}
