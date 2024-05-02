/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : YardManageBC.java
 *@FileTitle : YardManage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.basic;

import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.vo.SearchLeaseListVO;
import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.vo.SearchNodeListVO;
import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.vo.SearchYardDetailVO;
import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.vo.SearchZoneDetailVO;
import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.vo.SearchZonePostCodeVO;
import com.clt.framework.core.layer.event.EventException;
import java.util.List;

/**
 * PRD Business Logic Command Interface<br>
 *
 * @author kimyoungchul
 * @see ESD_PRD_002EventResponse 
 * @since J2EE 1.4
 */
public interface YardManageBC{

	/**
	 * retrieving - YardManage
	 * 
	 * @param searchNodeListVO
	 * @return List
	 * @throws com.clt.framework.core.layer.event.EventException
	 */
	public List<SearchNodeListVO> searchNodeList(SearchNodeListVO searchNodeListVO) throws EventException;

	/**
	 * retrieving - YardManage
	 *
	 * @param searchYardDetailVO
	 * @return List
	 * @throws com.clt.framework.core.layer.event.EventException
	 */
	public List<SearchYardDetailVO> searchYardDetail(SearchYardDetailVO searchYardDetailVO) throws EventException;

	/**
	 * retrieving - YardManage
	 *
	 * @param searchZoneDetailVO
	 * @return List
	 * @throws com.clt.framework.core.layer.event.EventException
	 */
	public List<SearchZoneDetailVO> searchZoneDetail(SearchZoneDetailVO searchZoneDetailVO) throws EventException;

	/**
	 * 
	 * @param searchZonePostCodeVO
	 * @return List
	 * @throws com.clt.framework.core.layer.event.EventException
	 */
	public List<SearchZonePostCodeVO> searchZonePostCode(SearchZonePostCodeVO searchZonePostCodeVO) throws EventException;

	/**
	 * YardManageBC's searchLeaseList
	 *
	 * @param searchLeaseListVO
	 * @return List
	 * @throws com.clt.framework.core.layer.event.EventException
	 */
	public List<SearchLeaseListVO> searchLeaseList(SearchLeaseListVO searchLeaseListVO) throws EventException;
}
