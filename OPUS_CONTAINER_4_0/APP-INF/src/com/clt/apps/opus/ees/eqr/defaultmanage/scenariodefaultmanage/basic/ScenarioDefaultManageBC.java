/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : scenariodefaultmanageBC.java
*@FileTitle : Demand Forecast Parameter Management 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0116ConditionVO;
import com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchEccMasterVO;
import com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchEccTsTmlVO;
import com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchSafetyStockVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.EqrEccLnkVO;
import com.clt.syscommon.common.table.EqrEccMstVO;
import com.clt.syscommon.common.table.EqrTsTmlVO;
/**
 * -Defaultmanage Business Logic Command Interface<br>
 *
 * @author 
 * @see EventResponse 참조
 * @since J2EE 1.6
 */


public interface ScenarioDefaultManageBC {
	
	/**
	 * [ EES_EQR_0115 : Retrieve ]
	 * retrieving for ECC<br>
	 * 
	 * @param String status
	 * @param String location
	 * @return List<SearchEccMasterVO>
	 * @exception EventException
	 */
	public List<SearchEccMasterVO> searchDefaultECCInfo(String status, String location) throws EventException;
	
	/**
	 * [ EES_EQR_0115 : upper Sheet-TS column DoubleClick ]
	 * retrieving for TS <br>
	 * 
	 * @param eccCd String
	 * @return List<SearchEccTsTmlVO>
	 * @exception EventException
	 */
	public List<SearchEccTsTmlVO> searchDefaultTSTMLInfo(String eccCd) throws EventException;
	
	/**
	 * [ EES_EQR_0115 : Save ]
	 * saving ECC<br>
	 * 
	 * @param eqrEccMstVOs EqrEccMstVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyDefaultECCInfo(EqrEccMstVO[] eqrEccMstVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * [ EES_EQR_0115 : Save ]
	 * saving ECC <br>
	 * 
	 * @param eqrTsTmlVOs EqrTsTmlVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyDefaultTSTMLInfo(EqrTsTmlVO[] eqrTsTmlVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * retrieving for ECC Link <br>
	 * @param condiVo EesEqr116ConditionVO
	 * @param fromEccAL ArrayList<String>
	 * @param toEccAL ArrayList<String>
	 * @return List<EqrEccLnkVO>
	 * @exception EventException
	 */	
	public List<EqrEccLnkVO> searchDefaultECCLinkInfo(EesEqr0116ConditionVO condiVo, ArrayList<String> fromEccAL , ArrayList<String> toEccAL) throws EventException;

	/**
   * saving Link<br>
	 * @param vos EqrEccLnkVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */	
	public void modifyDefaultECCLinkInfo(EqrEccLnkVO[] vos, SignOnUserAccount account) throws EventException;

}
