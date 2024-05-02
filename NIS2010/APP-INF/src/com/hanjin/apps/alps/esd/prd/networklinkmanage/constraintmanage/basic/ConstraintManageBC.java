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
 * 2012.06.07 이준근 [CHM-201217814-01] Constraint Management 입력 Data Validation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.basic;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.CheckCommodityVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.ConstraintVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.SearchLinkConstraintVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.SearchListCnstExptVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.SearchNodeConstraintVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.constraintmanage.vo.SearchRouteConstraintVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

import java.util.List;

/**
 * alps-PRD Business Logic Command Interface<br>
 * - alps-PRD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kimyoungchul
 * @see ESD_PRD_022EventResponse 참조
 * @since J2EE 1.4
 */
public interface ConstraintManageBC{

	/**
	 * 조회 이벤트 처리<br>
	 * ConstraintManage화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param constraintVO
	 * @return response ESD_PRD_022EventResponse
	 * @exception EventException
	 */
	public List searchNodeConstraintList(ConstraintVO constraintVO) throws EventException;

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
	public List searchLinkConstraintList(ConstraintVO constraintVO) throws EventException;

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
	 * @param constraintVO
	 * @return EventResponse
	 * @throws EventException
	 */
	public List searchRouteConstraintList(ConstraintVO constraintVO) throws EventException;

	/**
	 * ConstraintManageBC's multiRouteConstraint
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	public void multiRouteConstraint(SearchRouteConstraintVO[] vos, SignOnUserAccount account) throws EventException;
	
	/**
	 * 저장 할 대상의 validation를 체크 합니다. <br>
	 * @param vos
	 * @return List<SearchRouteConstraintVO>
	 * @throws EventException
	 */
	public List<SearchRouteConstraintVO> checkRouteConstraint(SearchRouteConstraintVO[] vos) throws EventException;
	

	/**
	 * 
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<CheckCommodityVO> checkCommodity(CheckCommodityVO vo) throws EventException;
	
	public List searchListExptCust(SearchListCnstExptVO searchListCnstExptVO) throws EventException;
	
	public void multiExptCust(SearchListCnstExptVO[] vos, String nod_cd, String nod_cnst_itm_cd, String nod_cnst_seq, SignOnUserAccount account) throws EventException;
}
