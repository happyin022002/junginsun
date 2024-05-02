/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : OceanRouteConditionManageBC.java
 *@FileTitle : Carrier별 이용터미널 정보관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-10-02
 *@LastModifier : jungsunyoung
 *@LastVersion : 1.0
 * 2006-10-02 jungsunyoung
 * 1.0 최초 생성
 * N200902100240 2009-02-27 Terminal Matrix Exception UI 추가 개발 (ESD_PRD_041)
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo.SearchCallingTmlMtxExptVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo.SearchEmbargoVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanrouteconditionmanage.vo.SearchOceanRouteConditionVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-PRD Business Logic Command Interface<br>
 * - alps-PRD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author jungsunyoung
 * @see ESD_PRD_011EventResponse 참조
 * @since J2EE 1.4
 */
public interface OceanRouteConditionManageBC{

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_PRD_0011 화면에 대한 멀티 이벤트 처리<br>
	 * ★2009-09-16 kim kwijin생성
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	public void multiOceanRouteConditionManage(SearchOceanRouteConditionVO[] vos, SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * OceanRouteConditionManage화면에 대한 조회 이벤트 처리<br>
	 * ★2009-09-16 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchOceanRouteConditionVO> searchOceanRouteConditionManageList(SearchOceanRouteConditionVO vo) throws EventException;

	/**
	 * OceanRouteConditionManageBC's searchEmbargoManageList\
	 * ★2009-09-18 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchEmbargoVO> searchEmbargoManageList(SearchEmbargoVO vo) throws EventException;

	/**
	 * OceanRouteConditionManageBC's multiEmbargoManage
	 *  ★2009-09-18 kim kwijin생성
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	public void multiEmbargoManage(SearchEmbargoVO[] vos, SignOnUserAccount account) throws EventException;

	/**
	 * OceanRouteConditionManageBC's searchCallingTmlMtxExptList
	 * ★2009-09-17 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws EventException EventResponse
	 */
	public List<SearchCallingTmlMtxExptVO> searchCallingTmlMtxExptList(SearchCallingTmlMtxExptVO vo) throws EventException;

	/**
	 * OceanRouteConditionManageBC's multiCallingTmlMtxExptList
	 * ★2009-09-17 kim kwijin생성
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	public void multiCallingTmlMtxExptList(SearchCallingTmlMtxExptVO[] vos, SignOnUserAccount account) throws EventException;
}
