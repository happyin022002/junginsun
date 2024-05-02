/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ConstraintManageBC.java
 *@FileTitle : Node Constraint Manage
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-16
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-10-16 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.basic;

import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.CheckCommodityVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.ConstraintVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.SearchHubConstraintListVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.SearchLinkConstraintVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.SearchNodeConstraintVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.constraintmanage.vo.SearchRouteConstraintVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

import java.util.List;

/**
 * PRD Business Logic Command Interface<br>
 * PRD에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author kimyoungchul
 * @see ESD_PRD_022EventResponse 참조
 * @since J2EE 1.4
 */
public interface ConstraintManageBC {

	/**
	 * 조회 이벤트 처리<br>
	 * ConstraintManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param constraintVO
	 * @return response ESD_PRD_022EventResponse
	 * @exception EventException
	 */
	public List<SearchNodeConstraintVO> searchNodeConstraintList(ConstraintVO constraintVO) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_PRD_022 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param vos
	 * @param account
	 * @exception EventException
	 */
	public void multiNodeConstraint(SearchNodeConstraintVO[] vos, SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * ConstraintManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param constraintVO
	 * @return response ESD_PRD_023EventResponse
	 * @exception EventException
	 */
	public List<SearchLinkConstraintVO> searchLinkConstraintList(ConstraintVO constraintVO) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_PRD_023 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param vos
	 * @param account
	 * @exception EventException
	 */
	public void multiLinkConstraint(SearchLinkConstraintVO[] vos, SignOnUserAccount account) throws EventException;

	/**
	 * ConstraintManageBC's searchRouteConstraintList
	 * 
	 * @param constraintVO
	 * @return EventResponse
	 * @throws EventException
	 */
	public List<SearchRouteConstraintVO> searchRouteConstraintList(ConstraintVO constraintVO) throws EventException;

	/**
	 * ConstraintManageBC's multiRouteConstraint
	 * 
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	public void multiRouteConstraint(SearchRouteConstraintVO[] vos, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<CheckCommodityVO> checkCommodity(CheckCommodityVO vo) throws EventException;

	/**
	 * 
	 * @param constraintVO
	 * @return response ESD_PRD_022EventResponse
	 * @exception EventException
	 */
	public List<AbstractValueObject> searchHubConstraintList(ConstraintVO constraintVO) throws EventException;

	/**
	 * 
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	public void multiHubConstraint(SearchHubConstraintListVO[] vos, SignOnUserAccount account) throws EventException;

	/**
	 * 
	 * @param constraintVO
	 * @return
	 * @throws EventException
	 */
	public DBRowSet searchContainerTypeSize(ConstraintVO constraintVO) throws EventException;
}
