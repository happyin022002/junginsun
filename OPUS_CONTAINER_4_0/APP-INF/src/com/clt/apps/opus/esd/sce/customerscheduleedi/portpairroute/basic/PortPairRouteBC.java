/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PortPairRouteBC.java
 *@FileTitle : Exception Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.basic;

import java.util.List;

import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteConditionVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteDetailVO;
import com.clt.apps.opus.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteMstVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;

/**
 * Port Pair Route Business Logic Command Interface<br>
 * - <br>
 * 
 * @author 
 * @see ESD_SCE_0120EventResponse
 * @since J2EE 1.6
 */

public interface PortPairRouteBC {

	/** 
	 * <br>
	 * retrieving OceanRouteManage Data<br>
	 * @param String partnerId
	 * @return String 
	 * @exception EventException
	 */
	public String searchPartnerName(String partnerId) throws EventException;
	
	/**
	 * retrieving Port Pair Mater
	 * @param PortPairRouteMstVO model
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet searchPortPairMaster(PortPairRouteMstVO model) throws EventException;
	
	/**
	 * retrieving Port Pair Mater
	 * @param PortPairRouteDetailVO model
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet searchPortPairMaster(PortPairRouteDetailVO model) throws EventException;
	
	/**
	 * retrieving Port Pair Master
	 * @param PortPairRouteConditionVO portPairRouteConditionVO
	 * @return List<PortPairRouteMstVO>
	 * @throws EventException
	 */
	public List<PortPairRouteMstVO> searchPortPairMasters(PortPairRouteConditionVO portPairRouteConditionVO) throws EventException;

	/**
	 * retrieving Port Pair Detail List
	 * @param PortPairRouteConditionVO condition
	 * @return List<PortPairRouteDetailVO>
	 * @throws EventException
	 */
	public List<PortPairRouteDetailVO> searchPortPairDetails(PortPairRouteConditionVO condition) throws EventException;
	
	/**
	 * retrieving Port Pair Detail Data
	 * @param PortPairRouteMstVO mstVO
	 * @return List<PortPairRouteDetailVO>
	 * @throws EventException
	 */
	public List<PortPairRouteDetailVO> searchPortPairDetails(PortPairRouteMstVO mstVO) throws EventException;
	

	/**
	 * checking duplicated route at Port Pair Detail
	 * @param PortPairRouteDetailVO model
	 * @return boolean
	 * @throws EventException
	 */ 
	public boolean hasSameRoute(PortPairRouteDetailVO model) throws EventException;
	
	/**
	 * retrieving next route sequence.
	 * @return String
	 * @throws EventException
	 */ 
	public String getNextRouteSeq() throws EventException;
	
	/**
	 * returning current date
	 * @return String
	 * @throws EventException
	 */ 
	public String getCurrentDate() throws EventException;
	
	/**
	 * registering partner
	 * @param PortPairRouteConditionVO condition
	 * @throws EventException
	 */
	public void insertPartnerCode(PortPairRouteConditionVO condition) throws EventException;
	
	/**
	 * update PortPairMaster data
	 * @param PortPairRouteConditionVO condition
	 * @param PortPairRouteMstVO[] models
	 * @throws EventException
	 */
	public void modifyPortPairMaster(PortPairRouteConditionVO condition, PortPairRouteMstVO[] models) throws EventException;
	
	/**
	 * update detail status when PortPairDetail Master changed status(USE_FL).
	 * @param PortPairRouteConditionVO condition
	 * @param PortPairRouteMstVO[] models
	 * @throws EventException
	 */
	public void modifyPortPairDetail(PortPairRouteConditionVO condition, PortPairRouteMstVO[] models) throws EventException;
	
	/**
	 * update PortPairDetail 
	 * @param PortPairRouteConditionVO condition
	 * @param PortPairRouteDetailVO[]  models
	 * @throws EventException
	 */
	public void modifyPortPairDetail(PortPairRouteConditionVO condition, PortPairRouteDetailVO[] models) throws EventException;
	
	/**
	 * calling daily batch for PRD profomatransittime
	 * Call From : com.clt.apps.opus.esd.prd.batch.profomatransittime.basic.ProfomaTransitTime.java
	 * @throws EventException
	 */
	public void modifyPortPairRoute() throws EventException;
	
}