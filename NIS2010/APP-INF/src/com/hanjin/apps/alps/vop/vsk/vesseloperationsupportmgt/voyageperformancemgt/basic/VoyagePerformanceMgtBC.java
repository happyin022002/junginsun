/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VoyagePerformanceMgtBC.java
*@FileTitle : Voyage Performance
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.07
*@LastModifier : Choi Duk Woo
*@LastVersion : 1.0
*  2014.04.07 Choi Duk Woo
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.basic;

import java.util.List;

import com.hanjin.apps.alps.vop.vsk.vesseloperationsupportmgt.voyageperformancemgt.vo.VoyagePerformanceVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-VoyagePerformanceMgt Business Logic Command Interface<br>
 * - ALPS-VoyagePerformanceMgt에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Choi Duk Woo
 * @see Vop_vsk_0516EventResponse 참조
 * @since J2EE 1.6
 */

public interface VoyagePerformanceMgtBC {

	/**
	 *  Voyage Performance 을 조회 합니다.<br>
	 * 
	 * @param VoyagePerformanceVO voyagePerformanceVO
	 * @return List<VoyagePerformanceVO>
	 * @exception EventException
	 */
	public List<VoyagePerformanceVO> searchVoyagePerformance(VoyagePerformanceVO voyagePerformanceVO) throws EventException;
	
	/**
	 *  Vessel List 을 조회 합니다.<br>
	 * 
	 * @return List<VoyagePerformanceVO>
	 * @exception EventException
	 */
	public List<VoyagePerformanceVO> searchVesselList() throws EventException;
	
	/**
	 *  Lane List 을 조회 합니다.<br>
	 * 
	 * @return List<VoyagePerformanceVO>
	 * @exception EventException
	 */
	public List<VoyagePerformanceVO> searchLanelList() throws EventException;
	
	/**
	 *  VVD 유효성을 체크 합니다.<br>
	 * 
	 * @param VoyagePerformanceVO voyagePerformanceVO
	 * @return List<VoyagePerformanceVO>
	 * @exception EventException
	 */
	public List<VoyagePerformanceVO> checkVvdInvalid(VoyagePerformanceVO voyagePerformanceVO) throws EventException;

	/**
	 * VOP_VSK_0516 : Retrieve <br>
	 * VVD Port to Port 을 조회 합니다.<br>
	 * 
	 * @param VoyagePerformanceVO voyagePerformanceVO
	 * @return List<VoyagePerformanceVO>
	 * @exception EventException
	 */
	public List<VoyagePerformanceVO> searchPortToPort(VoyagePerformanceVO voyagePerformanceVO) throws EventException;
	
}