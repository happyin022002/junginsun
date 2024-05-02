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
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.Edi323AdjustmentLaneVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.Edi323AdjustmentVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.RouteForBLVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.AdjustmentVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.BlockLaneVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.ExceptionalRouteVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.PartnerVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.laneservice.vo.SearchGetPartnerVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.CustomerVO;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-CustomerScheduleEdi Business Logic Command Interface<br>
 * - NIS2010-CustomerScheduleEdi에 대한 비지니스 로직에 대한 인터페이스<br>
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
	
	/**
	 * ESD_SCE_123 : PortPairPartner 검색 콤보 리스트 조회
	 * @return List<PartnerVO>
	 * @throws EventException
	 */
	public List<PartnerVO> searchPortPairPartner() throws EventException;
	
	/**
	 * ESD_SCE_123 : Edi 323 Adjustment 검색 리스트 조회
	 * @param Edi323AdjustmentVO vo
	 * @return List<Edi323AdjustmentVO>
	 * @throws EventException
	 */
	public List<Edi323AdjustmentVO> searchEdi323Adjustment(Edi323AdjustmentVO vo) throws EventException;
	
	/**
	 * ESD_SCE_123 : Edi 323 Adjustment 검색 리스트 저장
	 * @param Edi323AdjustmentVO[] adjustmentVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void manageEdi323Adjustment(Edi323AdjustmentVO[] adjustmentVOs,
			SignOnUserAccount account) throws EventException;
	
	/**
	 * ESD_SCE_127 : Edi 323 Adjustment Lane 검색 리스트 조회
	 * @param Event e
	 * @return List<Edi323AdjustmentLaneVO>
	 * @throws EventException
	 */
	public List<Edi323AdjustmentLaneVO> searchEdi323AdjustmentLane(Event e) throws EventException;
}
