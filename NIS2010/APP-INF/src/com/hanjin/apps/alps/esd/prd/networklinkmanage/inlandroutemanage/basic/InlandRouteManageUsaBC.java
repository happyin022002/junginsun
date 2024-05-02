/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : InlandRouteManageUsaBC.java
 *@FileTitle : Inland Route USA FULL
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-04
 *@LastModifier : jungsunyong
 *@LastVersion : 1.0
 * 2006-09-04 jungsunyong
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteMsUSVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteUSDetVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchConditionVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.lnlandRouteUSVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-PRD Business Logic Command Interface<br>
 * - alps-PRD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author jungsunyong
 * @see ESD_PRD_057EventResponse 참조
 * @since J2EE 1.4
 */
public interface InlandRouteManageUsaBC{

	/**
	 * InlandRouteManageUsaBC's searchInlandRouteMasterUSA
	 * @param inlandRouteUSVO
	 * @return
	 * @throws EventException
	 * 2009/08/04 kim kwijin 생성
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
