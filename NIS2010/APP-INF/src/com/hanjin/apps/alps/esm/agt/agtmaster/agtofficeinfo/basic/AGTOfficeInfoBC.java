/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTOfficeInfoBC.java
*@FileTitle : 중국 Outbound 대리점 정보 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.07.28 이호진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtmaster.agtofficeinfo.basic;

import java.util.List;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.AgtChnLaneAgnVO;
import com.hanjin.syscommon.common.table.AgtChnVslAgnVO;
import com.hanjin.syscommon.common.table.BkgChnAgnVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgChinaAgentVO;

/**
 * ALPS-Agtmaster Business Logic Command Interface<br>
 * - ALPS-Agtmaster에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Lee Ho Jin
 * @see Esm_agt_022EventResponse 참조
 * @since J2EE 1.6
 */

public interface AGTOfficeInfoBC {

	/**
	 * (ESM_AGT_022) 중국 Outbound 대리점 정보 관리의 모든 목록을 가져온다<br>
	 * @param BkgChnAgnVO	bkgChnAgnVO
	 * @return List<BkgChnAgnVO>
	 * @exception EventException
	 */
	public List<BkgChnAgnVO> searchChinaBKGAgentList(BkgChnAgnVO bkgChnAgnVO) throws EventException;
	/**
	 * (ESM_AGT_022) 중국 Outbound 대리점 정보 C,U,D 한다.<br>
	 * @param BkgChinaAgentVO[] bkgChnAgnVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiChinaBKGAgentList(BkgChinaAgentVO[] bkgChnAgnVOS,SignOnUserAccount account) throws EventException;
	/**
	 * (ESM_AGT_023) 중국 Inbound 대리점 정보 C,U,D 한다.<br>
	 * @param AgtChnLaneAgnVO agtChnLaneAgnVO
	 * @return List<AgtChnLaneAgnVO> 
	 * @throws EventException
	 */
	public List<AgtChnLaneAgnVO> searchLaneInboundAgentList(AgtChnLaneAgnVO agtChnLaneAgnVO) throws EventException;
	/**
	 * (ESM_AGT_023) 중국 Inbound 대리점 정보 C,U,D 한다.<br>
	 * 
	 * @param AgtChnLaneAgnVO[] agtChnLaneAgnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiLaneInboundAgentList(AgtChnLaneAgnVO[] agtChnLaneAgnVO,SignOnUserAccount account) throws EventException;
	/**
	 * (ESM_AGT_024) Inbound China Agent Office Info for Vessel 의 정보를 가져온다.<br>
	 * @param AgtChnVslAgnVO agtChnVslAgnVO
	 * @return List<AgtChnVslAgnVO>
	 * @throws EventException
	 */
	public List<AgtChnVslAgnVO> searchInboundChinaOfficeInfoForVessel(AgtChnVslAgnVO agtChnVslAgnVO) throws EventException;
	/**
	 * (ESM_AGT_024) Inbound China Agent Office Info for Vessel 의 정보를 C,U,D 한다.<br>
	 * @param AgtChnVslAgnVO[] agtChnVslAgnVOS
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiInboundChinaOfficeInfoForVessel(AgtChnVslAgnVO[] agtChnVslAgnVOS, SignOnUserAccount account) throws EventException;
	
}