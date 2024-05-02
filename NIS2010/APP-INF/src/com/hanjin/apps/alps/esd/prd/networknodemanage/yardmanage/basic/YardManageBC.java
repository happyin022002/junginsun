/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : YardManageBC.java
 *@FileTitle : YardManage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-24
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-10-24 kimyoungchul
 * 1.0 최초 생성
 * 2009-07-13 alps framework 구조 변경 noh seung bae
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.basic;

import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.event.EsdPrd0008Event;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchLeaseListVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchNodeDefaultSpInfoListVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchNodeListVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchYardDetailVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchYardDwellHistoryVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchZoneDetailVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchZonePostCodeVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

import java.util.List;

/**
 * alps-PRD Business Logic Command Interface<br>
 * - alps-PRD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kimyoungchul
 * @see ESD_PRD_002EventResponse 참조
 * @since J2EE 1.4
 */
public interface YardManageBC{

	/**
	 * 조회 이벤트 처리<br>
	 * YardManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param searchNodeListVO
	 * @return List
	 * @throws com.hanjin.framework.core.layer.event.EventException
	 */
	public List<SearchNodeListVO> searchNodeList(SearchNodeListVO searchNodeListVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * YardManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param searchYardDetailVO
	 * @return List
	 * @throws com.hanjin.framework.core.layer.event.EventException
	 */
	public List<SearchYardDetailVO> searchYardDetail(SearchYardDetailVO searchYardDetailVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * YardManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param searchZoneDetailVO
	 * @return List
	 * @throws com.hanjin.framework.core.layer.event.EventException
	 */
	public List<SearchZoneDetailVO> searchZoneDetail(SearchZoneDetailVO searchZoneDetailVO) throws EventException;

	/**
	 * 
	 * @param searchZonePostCodeVO
	 * @return List
	 * @throws com.hanjin.framework.core.layer.event.EventException
	 */
	public List searchZonePostCode(SearchZonePostCodeVO searchZonePostCodeVO) throws EventException;

	/**
	 * YardManageBC's searchLeaseList
	 *
	 * @param searchLeaseListVO
	 * @return List
	 * @throws com.hanjin.framework.core.layer.event.EventException
	 */
	public List<SearchLeaseListVO> searchLeaseList(SearchLeaseListVO searchLeaseListVO) throws EventException;

	/**
	 * @param event
	 * @return
	 * @throws EventException
	 */
	public List<SearchYardDwellHistoryVO> searchDwellTimeHIstory(EsdPrd0008Event event) throws EventException;
	/**
	 * @param searchNodeDefaultSpInfoListVO
	 * @return List
	 * @throws EventException
	 */
	public List searchNodeDefaultSpInfoList(SearchNodeDefaultSpInfoListVO searchNodeDefaultSpInfoListVO) throws EventException;
	/**
	 * @param searchNodeDefaultSpInfoListVO
	 * @return List
	 * @throws EventException
	 */
	public List searchSubOfficeSOManageList(SearchNodeDefaultSpInfoListVO searchNodeDefaultSpInfoListVO) throws EventException;
	/**
	 * @param searchNodeDefaultSpInfoListVOS
	 * @param account
	 * @return 
	 * @throws EventException
	 */
	public void modifyNodeDefaultSpInfoList(	SearchNodeDefaultSpInfoListVO[] searchNodeDefaultSpInfoListVOS,SignOnUserAccount account)throws EventException;
	/**
	 * @param searchNodeDefaultSpInfoListVO
	 * @return List
	 * @throws EventException
	 */
	public List searchSubOfficeCList(SearchNodeDefaultSpInfoListVO searchNodeDefaultSpInfoListVO)throws EventException;
	
}
