/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTOfficeInfoBC.java
*@FileTitle : China Outbound Agent Information management
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.agt.agtmaster.agtofficeinfo.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgChinaAgentVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.AgtChnLaneAgnVO;
import com.clt.syscommon.common.table.AgtChnVslAgnVO;
import com.clt.syscommon.common.table.BkgChnAgnVO;

/**
 * OPUS-Agtmaster Business Logic Command Interface<br>
 * - OPUS-Agtmaster handling Business Logic Command Interface<br>
 *
 * @author 
 * @see Esm_agt_022EventResponse 
 * @since J2EE 1.6
 */

public interface AGTOfficeInfoBC {

	/**
	 * (ESM_AGT_022) China Outbound Agent Information retrieve event process<br>
	 * @param BkgChnAgnVO	bkgChnAgnVO
	 * @return List<BkgChnAgnVO>
	 * @exception EventException
	 */
	public List<BkgChnAgnVO> searchChinaBKGAgentList(BkgChnAgnVO bkgChnAgnVO) throws EventException;
	/**
	 * (ESM_AGT_022) China Outbound Agent Information C,U,D event process<br>
	 * @param BkgChinaAgentVO[] bkgChnAgnVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiChinaBKGAgentList(BkgChinaAgentVO[] bkgChnAgnVOS,SignOnUserAccount account) throws EventException;
	/**
	 * (ESM_AGT_023) China Inbound Agent Information retrieve event process.<br>
	 * @param AgtChnLaneAgnVO agtChnLaneAgnVO
	 * @return List<AgtChnLaneAgnVO> 
	 * @throws EventException
	 */
	public List<AgtChnLaneAgnVO> searchLaneInboundAgentList(AgtChnLaneAgnVO agtChnLaneAgnVO) throws EventException;
	/**
	 * (ESM_AGT_023) China Inbound Agent Information C,U,D event process.<br>
	 * 
	 * @param AgtChnLaneAgnVO[] agtChnLaneAgnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiLaneInboundAgentList(AgtChnLaneAgnVO[] agtChnLaneAgnVO,SignOnUserAccount account) throws EventException;
	/**
	 * (ESM_AGT_024) Inbound China Agent Office Info for Vessel retrieve event process.<br>
	 * @param AgtChnVslAgnVO agtChnVslAgnVO
	 * @return List<AgtChnVslAgnVO>
	 * @throws EventException
	 */
	public List<AgtChnVslAgnVO> searchInboundChinaOfficeInfoForVessel(AgtChnVslAgnVO agtChnVslAgnVO) throws EventException;
	/**
	 * (ESM_AGT_024) Inbound China Agent Office Info for Vessel C,U,D event process.<br>
	 * @param AgtChnVslAgnVO[] agtChnVslAgnVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiInboundChinaOfficeInfoForVessel(AgtChnVslAgnVO[] agtChnVslAgnVOS, SignOnUserAccount account) throws EventException;
	
}