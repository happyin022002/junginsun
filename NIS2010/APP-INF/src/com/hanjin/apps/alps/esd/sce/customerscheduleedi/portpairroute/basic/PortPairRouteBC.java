/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PortPairRouteBC.java
 *@FileTitle : Exception Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.03.04
 *@LastModifier : 신한성
 *@LastVersion : 1.0
 * 2010.03.04 신한성
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.vo.PortPairOceanRouteInformationVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteConditionVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteDetailVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteMstVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Port Pair Route Business Logic Command Interface<br>
 * - ALPS-Port Pair Route에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author HS.SHin
 * @see ESD_SCE_0120EventResponse 참조
 * @since J2EE 1.6
 */

public interface PortPairRouteBC {

	/** 
	 * 조회 이벤트 처리<br>
	 * OceanRouteManage화면에 대한 조회 이벤트 처리<br>
	 * @param String partnerId
	 * @return String 
	 * @exception EventException
	 */
	public String searchPartnerName(String partnerId) throws EventException;
	
	/**
	 * Port Pair Mater 조회
	 * @param PortPairRouteMstVO model
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet searchPortPairMaster(PortPairRouteMstVO model) throws EventException;
	
	/**
	 * Port Pair Mater 조회
	 * @param PortPairRouteDetailVO model
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet searchPortPairMaster(PortPairRouteDetailVO model) throws EventException;
	
	/**
	 * Port Pair Master 조회
	 * @param PortPairRouteConditionVO portPairRouteConditionVO
	 * @return List<PortPairRouteMstVO>
	 * @throws EventException
	 */
	public List<PortPairRouteMstVO> searchPortPairMasters(PortPairRouteConditionVO portPairRouteConditionVO) throws EventException;

	/**
	 * Port Pair Detail 검색 리스트 조회
	 * @param PortPairRouteConditionVO condition
	 * @return List<PortPairRouteDetailVO>
	 * @throws EventException
	 */
	public List<PortPairRouteDetailVO> searchPortPairDetails(PortPairRouteConditionVO condition) throws EventException;
	
	/**
	 * Port Pair Detail 마스터별 상세 조회
	 * @param PortPairRouteMstVO mstVO
	 * @return List<PortPairRouteDetailVO>
	 * @throws EventException
	 */
	public List<PortPairRouteDetailVO> searchPortPairDetails(PortPairRouteMstVO mstVO) throws EventException;
	
//	/**
//	 * EAI 로 전달할 정보 조회
//	 * @param PortPairRouteDetailVO model
//	 * @return
//	 * @throws EventException
//	 */
//	public List<PortPairRouteDetailVO> searchPortPairDetailForEAI(PortPairRouteDetailVO model) throws EventException;
	
	/**
	 * Port Pair Detail에 동일한 경로가 존재하는지 확인한다.
	 * @param PortPairRouteDetailVO model
	 * @return boolean
	 * @throws EventException
	 */ 
	public boolean hasSameRoute(PortPairRouteDetailVO model) throws EventException;
	
	/**
	 * Port Pair Detail에 동일한 경로가 존재하는지 확인한다.
	 * @return String
	 * @throws EventException
	 */ 
	public String getNextRouteSeq() throws EventException;
	
	/**
	 * 현재 일자를 반환한다.
	 * @return String
	 * @throws EventException
	 */ 
	public String getCurrentDate() throws EventException;
	
	/**
	 * 파트너 등록한다.
	 * @param PortPairRouteConditionVO condition
	 * @throws EventException
	 */
	public void insertPartnerCode(PortPairRouteConditionVO condition) throws EventException;
	
	/**
	 * PortPairMaster 정보 관리.
	 * @param PortPairRouteConditionVO condition
	 * @param PortPairRouteMstVO[] models
	 * @throws EventException
	 */
	public void modifyPortPairMaster(PortPairRouteConditionVO condition, PortPairRouteMstVO[] models) throws EventException;
	
	/**
	 * PortPairDetail 마스터의 상태(USE_FL) 변경에 따른 디테일의 상태정보 변경.
	 * @param PortPairRouteConditionVO condition
	 * @param PortPairRouteMstVO[] models
	 * @throws EventException
	 */
	public void modifyPortPairDetail(PortPairRouteConditionVO condition, PortPairRouteMstVO[] models) throws EventException;
	
	/**
	 * PortPairDetail 정보 등록/수정/삭제.
	 * @param PortPairRouteConditionVO condition
	 * @param PortPairRouteDetailVO[]  models
	 * @throws EventException
	 */
	public void modifyPortPairDetail(PortPairRouteConditionVO condition, PortPairRouteDetailVO[] models) throws EventException;
	
	/**
	 * PRD profomatransittime 일배치 처리 시에 제공.
	 * Call From : com.hanjin.apps.alps.esd.prd.batch.profomatransittime.basic.ProfomaTransitTime.java
	 * @throws EventException
	 */
	public void modifyPortPairRoute() throws EventException;

	/**
	 * @param portPairRouteDetailVO
	 * @return List<PortPairOceanRouteInformationVO>
	 * @throws EventException
	 */
	public List<PortPairOceanRouteInformationVO> searchPortPairOceanRouteInformation(
			PortPairRouteDetailVO portPairRouteDetailVO)throws EventException;

//	public List<SceComboVO> searchPartnerCombo()throws EventException;
	
//	/**
//	 * PortPair I/F 전송.
//	 * @param PortPairRouteConditionVO portPairRouteConditionVO
//	 * @return
//	 * @throws EventException
//	 */ 
//	public void addPortPairRouteIF(PortPairRouteConditionVO condition, Collection<PortPairRouteDetailVO> models) throws EventException;

}