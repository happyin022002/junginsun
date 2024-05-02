/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AGTCustomerAgreementInfoBC.java
*@FileTitle : Agent Commission Customer Agreement Infomation Management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.agt.agtagreement.agtcustomeragreementinfo.basic;

import java.util.List;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.AgtBrogAgmtRtVO;
import com.clt.syscommon.common.table.AgtFacAgmtGrpLocListVO;
import com.clt.syscommon.common.table.AgtFacAgmtRtVO;

/**
 * OPUS-AGT Business Logic Command Interface<br>
 * - OPUS-AGThandling Business Logic Command Interface<br>
 *
 * @author 
 * @see ESM_AGT_035EventResponse 
 * @since J2EE 1.4
 */

public interface AGTCustomerAgreementInfoBC  {
	
	/**
	 * retrieve event process<br>
	 * ESM_AGT_0007 retrieve event process<br>
	 * 
	 * @param AgtBrogAgmtRtVO agtBrogAgmtRtVO
	 * @return List<AgtBrogAgmtRtVO>
	 * @exception EventException
	 */
	public List<AgtBrogAgmtRtVO> searchUSABrokerageRateInfoList(AgtBrogAgmtRtVO agtBrogAgmtRtVO) throws EventException;
	
	/**
	 * multi event process<br>
	 * ESM_AGT_0007 multi event process<br>
	 * 
	 * @param AgtBrogAgmtRtVO[] agtBrogAgmtRtVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiUSABrokerageRateInfo(AgtBrogAgmtRtVO[] agtBrogAgmtRtVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * ESM_AGT_0008 retrieve event process<br>
	 * 
	 * @param AgtFacAgmtRtVO agtFacAgmtRtVO
	 * @return List<AgtFacAgmtRtVO>
	 * @exception EventException
	 */
	public List<AgtFacAgmtRtVO> searchFACRateInfoList(AgtFacAgmtRtVO agtFacAgmtRtVO) throws EventException;
	
	/**
	 * multi event process<br>
	 * ESM_AGT_0008 multi event process<br>
	 * 
	 * @param AgtFacAgmtRtVO[] agtFacAgmtRtVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiFACRateInfo(AgtFacAgmtRtVO[] agtFacAgmtRtVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * ESM_AGT_0008 when adding row, F.Forwarder Default information retrieve event process<br>
	 * 
	 * @param AgtFacAgmtRtVO agtFacAgmtRtVO
	 * @return List<AgtFacAgmtRtVO>
	 * @exception EventException
	 */
	public List<AgtFacAgmtRtVO> searchFACCustomerInfo(AgtFacAgmtRtVO agtFacAgmtRtVO) throws EventException;
	
	/**
	 * Request event process<br>
	 * ESM_AGT_0008 Request event process<br>
	 * 
	 * @param AgtFacAgmtRtVO[] agtFacAgmtRtVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyFACRateRequest(AgtFacAgmtRtVO[] agtFacAgmtRtVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * Approval event process<br>
	 * ESM_AGT_0008 Approval event process<br>
	 * 
	 * @param AgtFacAgmtRtVO[] agtFacAgmtRtVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyFACRateApproval(AgtFacAgmtRtVO[] agtFacAgmtRtVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * Reject event process<br>
	 * ESM_AGT_0008 Reject event process<br>
	 * 
	 * @param AgtFacAgmtRtVO[] agtFacAgmtRtVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyFACRateReject(AgtFacAgmtRtVO[] agtFacAgmtRtVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * retrieve event process<br>
	 * ESM_AGT_0035 retrieve event process<br>
	 * 
	 * @param AgtFacAgmtGrpLocListVO agtFacAgmtGrpLocListVO
	 * @return List<AgtFacAgmtGrpLocListVO>
	 * @exception EventException
	 */
	public List<AgtFacAgmtGrpLocListVO> searchFACGrpLocList(AgtFacAgmtGrpLocListVO agtFacAgmtGrpLocListVO) throws EventException;

	

	
	
}