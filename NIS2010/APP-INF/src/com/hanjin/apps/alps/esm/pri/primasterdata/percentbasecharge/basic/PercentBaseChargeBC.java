/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PercentBaseChargeBC.java
*@FileTitle : Percent Base CHG Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.02
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2013.09.02 송호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.percentbasecharge.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.PriScgPctBseChgVO;
import com.hanjin.syscommon.common.table.PriScgPctBseVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.percentbasecharge.vo.RsltPercentBaseChargeVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.percentbasecharge.vo.RsltPercentBaseChargeGroupingVO;

/**
 * ALPS-Primasterdata Business Logic Command Interface<br>
 * - ALPS-Primasterdata에 대한 비지니스 로직에 대한 인터페이스<br>
 * Percent Base Charge 구성의 조회 및 관리를 위한 Business Component 
 *
 * @author SongHoJin
 * @see Esm_pri_4034EventResponse 참조
 * @since J2EE 1.6
 */

public interface PercentBaseChargeBC {

	/**
	 * ESM_PRI_4034 : Retrieve <br>
	 * 
	 * @return List<RsltPercentBaseChargeVO>
	 * @exception EventException
	 */
	public List<RsltPercentBaseChargeVO> searchPercentBaseCharge() throws EventException ;
	
	/**
	 * ESM_PRI_4034 : sheet1 on select cell <br>
	 * 
	 * @param PriScgPctBseVO priScgPctBseVO
	 * @return List<RsltPercentBaseChargeGroupingVO>
	 * @exception EventException
	 */
	public List<RsltPercentBaseChargeGroupingVO> searchPercentBaseChargeGrouping(PriScgPctBseVO priScgPctBseVO) throws EventException ;
	
	/**
	 * ESM_PRI_4034 : sheet1 SAVE <br>
	 * 
	 * @param PriScgPctBseVO[] priScgPctBseVOs
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void managePercentBaseCharge(PriScgPctBseVO[] priScgPctBseVOs , SignOnUserAccount account) throws EventException ;
	
	/**
	 * ESM_PRI_4034 : sheet2 SAVE <br>
	 * 
	 * @param PriScgPctBseChgVO[] priScgPctBseChgVOs
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void managePercentBaseChargeGrouping(PriScgPctBseChgVO[] priScgPctBseChgVOs , SignOnUserAccount account) throws EventException ;
	
}