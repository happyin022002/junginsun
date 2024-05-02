/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VesselPositionPollingManagementBC.java
*@FileTitle : Position Polling Receive Management
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.18
*@LastModifier : Lim Ye Ji
*@LastVersion : 1.0
* 2014.05.18 Lim Ye Ji
* 1.0 Creation
* 
* History
* 
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.basic;



import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.vo.PositionPollingHeaderVO;
import com.hanjin.framework.core.layer.event.EventException;

public interface VesselPositionPollingManagementBC {


	/**
	 * Position Polling Receive Header
	 *
	 * @param String sFlatFile
	 * @return PositionPollingHeaderVO
	 * @exception EventException
	 */
	public PositionPollingHeaderVO createPositionPollingHeaderFromEdi(String sFlatFile) throws EventException;

	/**
	 * Position Polling Receive Detail
	 *
	 * @param String sFlatFile
	 * @return void
	 * @exception EventException
	 */
	public void createPositionPollingDetailFromEdiBackEndJob(PositionPollingHeaderVO positionPollingHeaderVO, String sFlatFile) throws EventException;
	
	
	
}