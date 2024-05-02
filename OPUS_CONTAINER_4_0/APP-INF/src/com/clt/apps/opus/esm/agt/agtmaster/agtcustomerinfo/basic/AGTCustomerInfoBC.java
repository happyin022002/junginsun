/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AGTCustomerInfoBC.java
*@FileTitle : Agent Commission Customer Infomation Management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.agt.agtmaster.agtcustomerinfo.basic;

import java.util.List;

import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.AgtBrogCustIntVO;
import com.clt.syscommon.common.table.AgtBrogCustMtchVO;
import com.clt.syscommon.common.table.AgtFacCustRltVO;

/**
 * OPUS-AGT Business Logic Command Interface<br>
 * - OPUS-AGT handling Business Logic Command Interface<br>
 *
 * @author 
 * @see ESM_AGT_038EventResponse 
 * @since J2EE 1.4
 */
public interface AGTCustomerInfoBC  {

	/**
	 * ESM_AGT_0025 retrieve event process<br>
	 * @param AgtBrogCustMtchVO agtBrogCustMtchVO
	 * @return List<AgtBrogCustMtchVO>
	 * @throws EventException
	 */
	public List<AgtBrogCustMtchVO> searchFForwarderVendorMatchingInfoForBrokerage(AgtBrogCustMtchVO agtBrogCustMtchVO) throws EventException;

	/**
	 * ESM_AGT_0025 multi event process<br>
	 * @param AgtBrogCustMtchVO[] agtBrogCustMtchVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiFForwarderVendorMatchingInfoForBrokerage(AgtBrogCustMtchVO[] agtBrogCustMtchVOs, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_AGT_026 retrieve event process<br>
	 * @param agtBrogCustIntVO
	 * @return List<AgtBrogCustIntVO> 
	 * @exception EventException
	 */
	public List<AgtBrogCustIntVO> searchBRKGCustomerToShipperInterestList(AgtBrogCustIntVO agtBrogCustIntVO) throws EventException;
	/**
	 * ESM_AGT_026 multi event process<br>
	 * @param AgtBrogCustIntVO[] agtBrogCustIntVOs
	 * @param account
	 * @exception EventException
	 */
	public void multiBRKGCustomerToShipperInterestInfo(AgtBrogCustIntVO[] agtBrogCustIntVOs, SignOnUserAccount account) throws EventException;


	/**
	 * retrieve event process<br>
	 * ESM_AGT_030 retrieve event process<br>
	 * 
	 * @param AgtFacCustRltVO agtFacCustRltVO
	 * @return List<AgtFacCustRltVO>
	 * @exception EventException
	 */
	public List<AgtFacCustRltVO> searchFACCustomerToShipperInterestList(AgtFacCustRltVO agtFacCustRltVO) throws EventException;
	
	/**
	 * multi event process<br>
	 * ESM_AGT_030 multi event process<br>
	 * 
	 * @param AgtFacCustRltVO[] agtFacCustRltVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiFACCustomerToShipperInterestList(AgtFacCustRltVO[] agtFacCustRltVOs, SignOnUserAccount account) throws EventException;
}