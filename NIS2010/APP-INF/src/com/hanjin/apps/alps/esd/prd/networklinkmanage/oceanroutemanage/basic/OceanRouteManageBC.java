/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : OceanRouteManageBC.java
 *@FileTitle : OceanLink 정보관리 (본사관리)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-22
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-09-22 kimyoungchul
 * 1.0 최초 생성
 * 2011.09.19 변종건 [CHM-201113069-01] Ocean Route Management상의 Auto & Multi Creation 화면 관련 변경사항
 * 2011.12.06 변종건 [CHM-201114917-01] Ocean Route Upload Excel 신규 기능 추가건
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.RowSearchOceanRouteManageVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SaveOceanRouteStatusVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SaveOceanRouteVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchConditionVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchLaneConnectionVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanLaneVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteAutoCreationVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteListVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteMultiCreationVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteSingleCreationVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteStatusVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS-PRD Business Logic Command Interface<br>
 * - NIS-PRD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kimyoungchul
 * @see ESD_PRD_014EventResponse 참조
 * @since J2EE 1.4
 */
public interface OceanRouteManageBC{

	/**
	 * 조회 이벤트 처리<br>
	 * OceanRouteManage화면에 대한 조회 이벤트 처리<br>
	 * ★2009-08-20 kim kwijin생성
	 * @param vo
	 * @param iPage 
	 * @return List<SearchOceanRouteListVO>
	 * @throws EventException
	 */
	public List<SearchOceanRouteListVO> searchOceanRouteList(SearchConditionVO vo, int iPage) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_PRD_014 화면에 대한 멀티 이벤트 처리<br>
	 * @param vos
	 * @param account
	 * @throws EventException
	 */
	public void multiOceanRoute(SaveOceanRouteVO[] vos, SignOnUserAccount account) throws EventException;

	/**
	 *  조회 이벤트 처리<br>
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchOceanRouteAutoCreationVO> searchOceanRouteAutoCreationList(SearchOceanRouteAutoCreationVO vo) throws EventException;

	/**
	 * OceanRouteStatus 조회 이벤트 처리<br>
	 * ★2009-09-18 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchOceanRouteStatusVO> searchOceanRouteStatusList(SearchOceanRouteStatusVO vo) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * ★2009-08-31 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<RowSearchOceanRouteManageVO> rowSearchOceanRouteManage(RowSearchOceanRouteManageVO vo) throws EventException;

	/**
	 * * 수정 이벤트 처리<br>
	 * ESD_PRD_0016 에 대한 추가 이벤트 처리<br>
	 * ★2009-09-18 kim kwijin생성
	 * @param vos
	 * @param vo
	 * @param account
	 * @throws EventException
	 */
	public void modifyOceanRouteStatus(SaveOceanRouteStatusVO[] vos, SearchOceanRouteStatusVO vo, SignOnUserAccount account) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * LaneConnection화면에 대한 조회 이벤트 처리<br>
	 * ★2009-09-18 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchLaneConnectionVO> searchLaneConnection(SearchLaneConnectionVO vo) throws EventException;

	/**
	 * OceanRouteManageBC's searchOceanLane
	 * ★2009-08-31 kim kwijin생성
	 * @param vo
	 * @param eventName
	 * @return
	 * @throws EventException
	 */
	public List<SearchOceanLaneVO> searchOceanLane(SearchOceanLaneVO vo, String eventName) throws EventException;

	/**
	 * OceanRouteManageBC's searchOceanRouteMultiCreationList
	 * Multi Creation시 Insert 한 Row에 대하여 중복 여부 Validation Check 
	 * ★2009-09-01 kim kwijin생성
	 * @param vo
	 * @return
	 * @throws EventException
	 */
	public List<SearchOceanRouteMultiCreationVO> searchOceanRouteMultiCreationList(SearchOceanRouteMultiCreationVO vo) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ★2011-07-11 Lee Su Jin 생성
	 * @param vo
	 * @return String
	 * @throws EventException
	 */
	public String searchSameOceanRoute(SaveOceanRouteVO vo) throws EventException;
	
	/**
	 * OceanRouteManageBC's searchOceanRouteSingleCreation
	 * Multi Creation시 Insert 한 Row의 각 Node 입력에 대하여 T/Time + S/Time, Priority 등의 정보 조회
	 * @param vo
	 * @return List<SearchOceanRouteSingleCreationVO>
	 * @throws EventException
	 */
	public List<SearchOceanRouteSingleCreationVO> searchOceanRouteSingleCreation(SearchOceanRouteSingleCreationVO vo) throws EventException;
	
	/**
	 * Verify 버튼 이벤트 처리<br>
	 * ESD_PRD_0086 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param inputVOs
	 * @return List<SaveOceanRouteVO>
	 * @throws EventException
	 */
	public List<SaveOceanRouteVO> searchOceanRouteValidationList(SaveOceanRouteVO[] inputVOs) throws EventException;
}
