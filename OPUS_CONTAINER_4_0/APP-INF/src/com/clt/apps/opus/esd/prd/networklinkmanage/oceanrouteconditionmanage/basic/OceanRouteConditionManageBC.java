/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : OceanRouteConditionManageBC.java
 *@FileTitle : Ocean Route Condition Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo.SearchCallingTmlMtxExptVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo.SearchEmbargoVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo.SearchOceanRouteConditionVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * PRD Business Logic Command Interface<br>
 *
 * @author jungsunyoung
 * @see ESD_PRD_011EventResponse 
 * @since J2EE 1.4
 */
public interface OceanRouteConditionManageBC{

	/**
	 * multi event - ESD_PRD_0011<br>
	 * 
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	public void multiOceanRouteConditionManage(SearchOceanRouteConditionVO[] vos, SignOnUserAccount account) throws EventException;

	/**
	 * retrieving - OceanRouteConditionManage<br>
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchOceanRouteConditionVO> searchOceanRouteConditionManageList(SearchOceanRouteConditionVO vo) throws EventException;

	/**
	 * OceanRouteConditionManageBC's searchEmbargoManageList\
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchEmbargoVO> searchEmbargoManageList(SearchEmbargoVO vo) throws EventException;

	/**
	 * OceanRouteConditionManageBC's multiEmbargoManage
	 *  
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	public void multiEmbargoManage(SearchEmbargoVO[] vos, SignOnUserAccount account) throws EventException;

	/**
	 * OceanRouteConditionManageBC's searchCallingTmlMtxExptList
	 * 
	 * @param vo
	 * @return
	 * @throws EventException EventResponse
	 */
	public List<SearchCallingTmlMtxExptVO> searchCallingTmlMtxExptList(SearchCallingTmlMtxExptVO vo) throws EventException;

	/**
	 * OceanRouteConditionManageBC's multiCallingTmlMtxExptList
	 * 
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	public void multiCallingTmlMtxExptList(SearchCallingTmlMtxExptVO[] vos, SignOnUserAccount account) throws EventException;
}
