/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : InlandRouteManageUsaBC.java
 *@FileTitle : Inland Route USA FULL
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteUSDetVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchConditionVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.inlandroutemanage.vo.lnlandRouteUSVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * PRD Business Logic Command Interface<br>
 *
 * @author jungsunyong
 * @see ESD_PRD_057EventResponse 
 * @since J2EE 1.4
 */
public interface InlandRouteManageUsaBC{

	/**
	 * InlandRouteManageUsaBC's searchInlandRouteMasterUSA
	 * @param inlandRouteUSVO
	 * @return
	 * @throws EventException
	 */
	public List<lnlandRouteUSVO> searchInlandRouteMasterUSA(lnlandRouteUSVO inlandRouteUSVO) throws EventException;

	/**
	 * InlandRouteManageUsaBC's searchInlandRouteDetailUSA
	 * @param searchConditionVO
	 * @return
	 * @throws EventException  
	 */
	public List<InlandRouteUSDetVO> searchInlandRouteDetailUSA(SearchConditionVO searchConditionVO) throws EventException;

	/**
	 * InlandRouteManageUsaBC's saveInlandRouteMasterUSA
	 * @param inlandRouteUSVO 
	 * @param params
	 * @param account
	 * @throws EventException
	 */
	public void saveInlandRouteMasterUSA(lnlandRouteUSVO[] inlandRouteUSVO, lnlandRouteUSVO params, SignOnUserAccount account) throws EventException;

	/**
	 * InlandRouteManageUsaBC's saveInlandRoutePriorityUSA
	 * @param inlandRouteUSVO
	 * @param account
	 * @throws EventException void
	 */
	public void saveInlandRoutePriorityUSA(lnlandRouteUSVO[] inlandRouteUSVO, SignOnUserAccount account) throws EventException;
}
