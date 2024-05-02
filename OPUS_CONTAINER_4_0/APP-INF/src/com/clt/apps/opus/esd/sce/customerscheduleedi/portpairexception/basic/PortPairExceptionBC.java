/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PortPairExceptionBC.java
 *@FileTitle : PortPairExceptionBC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.07.15
 *@LastModifier : 함대성
 *@LastVersion : 1.0
 * 2010.07.15 함대성
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.basic;

import java.util.List;

import com.clt.apps.opus.esd.sce.customerscheduleedi.laneservice.vo.SearchGetPartnerVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo.AdjustmentVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo.BlockLaneVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo.CustomerVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo.ExceptionalRouteVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo.RouteForBLVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * CustomerScheduleEdi Business Logic Command Interface<br>
 * - CustomerScheduleEdi에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author HAM DAE SUNG
 * @see
 * @since J2EE 1.4
 */
public interface PortPairExceptionBC {
	
	/**
	 * ESD_SCE_0123 : 저장
	 * @param AdjustmentVO[] adjustmentVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageAdjustment(AdjustmentVO[] adjustmentVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESD_SCE_0125 : 저장
	 * @param ExceptionalRouteVO[] exceptionRouteVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageExceptionRoute(ExceptionalRouteVO[] exceptionRouteVOs, SignOnUserAccount account) throws EventException;
	
   /**
    * BATCH의  TP ID을 조회합니다.<br>
    * @param SearchGetPartnerVO searchGetPartnerVO
    * @return  List<SearchGetPartnerVO>
    * @exception EventException
    */ 
   public List<SearchGetPartnerVO> searchTpId(SearchGetPartnerVO searchGetPartnerVO) throws EventException;  
	
	/**
	 * Port Pair Detail 조회<br>
	 * @param AdjustmentVO adjustmentVO
	 * @return List<AdjustmentVO>
	 * @exception EventException
	 */
	public List<AdjustmentVO> searchRouteListForAdjustment(AdjustmentVO adjustmentVO) throws EventException;	
	
	/**
	 * BlockLane List 조회<br>
	 * @param RouteForBLVO routeForBLVO
	 * @return List<RouteForBLVO>
	 * @exception EventException
	 */
	public List<RouteForBLVO> searchRouteListForBlockLane(RouteForBLVO routeForBLVO) throws EventException;	
	
	/**
	 * ESD_SCE_124 : list조회
	 * @param BlockLaneVO blockLaneVO
	 * @return List<BlockLaneVO>
	 * @throws EventException
	 */
	public List<BlockLaneVO> searchBlockLaneList(BlockLaneVO blockLaneVO) throws EventException;
	
	/**
	 * ESD_SCE_124 : CUS
	 * 
	 * @param BlockLaneVO[] blockLaneVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBlockLane(BlockLaneVO[] blockLaneVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * ESD_SCE_124 : 화면 open
	 * @param CustomerVO customerVO
	 * @return List<CustomerVO>
	 * @throws EventException
	 */
	public List<CustomerVO> searchLaneCombo(CustomerVO customerVO) throws EventException;
	
	/**
	 * ESD_SCE_125 : Route Exception 검색 리스트 조회
	 * @param ExceptionalRouteVO exceptionalRouteVO
	 * @return List<ExceptionalRouteVO>
	 * @throws EventException
	 */
	public List<ExceptionalRouteVO> searchExceptionalRouteList(ExceptionalRouteVO exceptionalRouteVO) throws EventException;
}
