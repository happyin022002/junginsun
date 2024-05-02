/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : InlandLinkManageBC.java
 *@FileTitle : Inland Link Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.basic;

import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.vo.PrdInlndEachLnkVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandlinkmanage.vo.SearchInlandLinkManageListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * PRD Business Logic Command Interface<br>
 *
 * @author jungsunyong
 * @see ESD_PRD_009EventResponse 
 * @since J2EE 1.4
 */
public interface InlandLinkManageBC{

	/**
	 * InlandLinkManageBC's multiInlandLinkManage
	 * @param vo
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public Map<String, String> multiInlandLinkManage(SearchInlandLinkManageListVO[] vo, SignOnUserAccount account) throws EventException;

	/**
	 * retrieving - InlandLinkManage<br>
	 * 
	 * @param vo
	 * @return response ESD_PRD_009EventResponse
	 * @exception EventException
	 */
	public List<PrdInlndEachLnkVO> searchInlandLinkManageList(PrdInlndEachLnkVO vo) throws EventException;

	/**
	 * retrieving<br>
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
