/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeaseSubleaseBC.java
*@FileTitle : Manageing lease History
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.basic;

import java.util.List;

import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusGrpVO;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusListVO;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusOptionVO;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusReportListVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * Equipmentleasehistory Business Logic Command Interface<br>
 *
 * @author
 * @see Ees_mst_0029EventResponse
 * @since J2EE 1.6
 */

public interface LeaseSubleaseBC {
	/**
	 * EES_MST_0029 : retrieve<br>
	 * retrieving for Container Status Inquiry<br>
	 * @category EES_MST_0029_1
	 * @category searchCntrStatusListByCntrNoBasic     
	 * @param CntrStatusOptionVO cntrStatusOptionVO
	 * @return CntrStatusGrpVO
	 * @exception EventException
	 */
	public CntrStatusGrpVO searchCntrStatusListByCntrNoBasic(CntrStatusOptionVO cntrStatusOptionVO) throws EventException;
	/**
	 * EES_MST_0035 : retrieve<br>
	 * retrieving for Container Check Digit and Container Checking Inquiry <br>
	 * @category EES_MST_0035_1
	 * @category searchCntrCheckDigitListBasic    
	 * @param CntrStatusOptionVO cntrStatusOptionVO
	 * @return List<CntrStatusListVO>
	 * @exception EventException
	 */
	public List<CntrStatusListVO> searchCntrCheckDigitListBasic(CntrStatusOptionVO cntrStatusOptionVO) throws EventException;
	
	/**
	 * EES_MST_0027 : retrieve<br>
	 * retrieving for Container Status List about Lost & Found<br>
	 * 
	 * @param CntrStatusOptionVO cntrStatusOptionVO
	 * @return List<CntrStatusReportListVO>	
	 * @exception EventException
	 */	
	public List<CntrStatusReportListVO> searchCntrStatusReportListBasic(CntrStatusOptionVO cntrStatusOptionVO) throws EventException;	
	
}