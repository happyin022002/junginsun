/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WarrantyMgtBC.java
*@FileTitle :WarrantyMgtBC
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.04.27 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.basic;

import com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.vo.WarrantyAlertInfoGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.warrantymgt.vo.WarrantyAlertListGRPVO;
import com.hanjin.framework.core.layer.event.EventException;
   
/**
 * alps-Generalmanage Business Logic Command Interface<br>
 * - alps-Generalmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author park myoung sin
 * @see Ees_mnr_0213EventResponse 참조
 * @see Ees_mnr_0170EventResponse 참조
 * @since J2EE 1.4
 */

public interface WarrantyMgtBC {  
	/**
	 * [EES_MNR_0213]Warranty Alert_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param WarrantyAlertInfoGRPVO warrantyAlertInfoGRPVO
	 * @return WarrantyAlertInfoGRPVO
	 * @exception EventException
	 */
	public WarrantyAlertInfoGRPVO searchWarrantyAlertInfoBasic(WarrantyAlertInfoGRPVO warrantyAlertInfoGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0170]Reefer Unit Warranty Period의 정보를 조회 합니다. <br>
	 *
	 * @param WarrantyAlertListGRPVO warrantyAlertListGRPVO
	 * @return WarrantyAlertListGRPVO
	 * @exception EventException
	 */
	public WarrantyAlertListGRPVO searchWarrantyAlertListBasic(WarrantyAlertListGRPVO warrantyAlertListGRPVO) throws EventException;
	         
	
} 