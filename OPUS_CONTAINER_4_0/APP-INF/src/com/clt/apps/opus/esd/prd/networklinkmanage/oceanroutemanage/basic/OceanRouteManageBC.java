/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : OceanRouteManageBC.java
 *@FileTitle : OceanLink Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.RowSearchOceanRouteManageVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SaveOceanRouteVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchConditionVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanLaneVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteAutoCreationVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteListVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteMultiCreationVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteSingleCreationVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * PRD Business Logic Command Interface<br>
 *
 * @author kimyoungchul
 * @see ESD_PRD_014EventResponse 
 * @since J2EE 1.4
 */
public interface OceanRouteManageBC{

	/**
	 * retrieving - OceanRouteManage
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchOceanRouteListVO> searchOceanRouteList(SearchConditionVO vo) throws EventException;

	/**
	 * multi event - ESD_PRD_014
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	public void multiOceanRoute(SaveOceanRouteVO[] vos, SignOnUserAccount account) throws EventException;

	/**
	 * retrieving
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchOceanRouteAutoCreationVO> searchOceanRouteAutoCreationList(SearchOceanRouteAutoCreationVO vo) throws EventException;

	
	/**
	 * retrieving
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<RowSearchOceanRouteManageVO> rowSearchOceanRouteManage(RowSearchOceanRouteManageVO vo) throws EventException;

	/**
	 * OceanRouteManageBC's searchOceanLane
	 * 
	 * @param vo
	 * @param eventName
	 * @return
	 * @throws EventException
	 */
	public List<SearchOceanLaneVO> searchOceanLane(SearchOceanLaneVO vo, String eventName) throws EventException;

	/**
	 * OceanRouteManageBC's searchOceanRouteMultiCreationList
	 * Multi Creation - duplication check of Inserted Row
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchOceanRouteMultiCreationVO> searchOceanRouteMultiCreationList(SearchOceanRouteMultiCreationVO vo) throws EventException;

	/**
	 * retrieving
	 * 
	 * @param vo
	 * @return String
	 * @throws EventException
	 */
	public String searchSameOceanRoute(SaveOceanRouteVO vo) throws EventException;

	/**
	 * OceanRouteManageBC's searchOceanRouteSingleCreation
	 * Multi Creation - retrieving  Information(T/Time + S/Time, Priority, etc) with Node of Inserted Row
	 * @param vo
	 * @return List<SearchOceanRouteSingleCreationVO>
	 * @throws EventException
	 */
	public List<SearchOceanRouteSingleCreationVO> searchOceanRouteSingleCreation(SearchOceanRouteSingleCreationVO vo) throws EventException;
	
}
