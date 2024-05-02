/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AGTCustomerAgreementInfoBC.java
*@FileTitle : Agent Commission Customer Agreement Infomation Management
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-30
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2006-11-30 Hwang GyeongNam
* 1.0 최초 생성
* 2009-09-04 : Ho-Jin Lee searchFACRateInfoList 추가
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtagreement.agtcustomeragreementinfo.basic;

import java.util.List;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.AgtBrogAgmtRtVO;
import com.hanjin.syscommon.common.table.AgtFacAgmtGrpLocListVO;
import com.hanjin.syscommon.common.table.AgtFacAgmtRtVO;
import com.hanjin.syscommon.common.table.AgtScsAgmtRtVO;

/**
 * eNIS-AGT Business Logic Command Interface<br>
 * - eNIS-AGT에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Hwang GyeongNam
 * @see ESM_AGT_035EventResponse 참조
 * @since J2EE 1.4
 */
public interface AGTCustomerAgreementInfoBC  {
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_0007 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtBrogAgmtRtVO agtBrogAgmtRtVO
	 * @return List<AgtBrogAgmtRtVO>
	 * @exception EventException
	 */
	public List<AgtBrogAgmtRtVO> searchUSABrokerageRateInfoList(AgtBrogAgmtRtVO agtBrogAgmtRtVO) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_AGT_0007 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param AgtBrogAgmtRtVO[] agtBrogAgmtRtVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiUSABrokerageRateInfo(AgtBrogAgmtRtVO[] agtBrogAgmtRtVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_0008 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtFacAgmtRtVO agtFacAgmtRtVO
	 * @return List<AgtFacAgmtRtVO>
	 * @exception EventException
	 */
	public List<AgtFacAgmtRtVO> searchFACRateInfoList(AgtFacAgmtRtVO agtFacAgmtRtVO) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_AGT_0008 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param AgtFacAgmtRtVO[] agtFacAgmtRtVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiFACRateInfo(AgtFacAgmtRtVO[] agtFacAgmtRtVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_0008 화면 행추가지 해당 F.Forwarder Default 정보 조회 이벤트 처리<br>
	 * 
	 * @param AgtFacAgmtRtVO agtFacAgmtRtVO
	 * @return List<AgtFacAgmtRtVO>
	 * @exception EventException
	 */
	public List<AgtFacAgmtRtVO> searchFACCustomerInfo(AgtFacAgmtRtVO agtFacAgmtRtVO) throws EventException;
	
	/**
	 * Request 이벤트 처리<br>
	 * ESM_AGT_0008 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param AgtFacAgmtRtVO[] agtFacAgmtRtVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyFACRateRequest(AgtFacAgmtRtVO[] agtFacAgmtRtVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * Approval 이벤트 처리<br>
	 * ESM_AGT_0008 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param AgtFacAgmtRtVO[] agtFacAgmtRtVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyFACRateApproval(AgtFacAgmtRtVO[] agtFacAgmtRtVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * Reject 이벤트 처리<br>
	 * ESM_AGT_0008 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param AgtFacAgmtRtVO[] agtFacAgmtRtVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyFACRateReject(AgtFacAgmtRtVO[] agtFacAgmtRtVOS, SignOnUserAccount account) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_0035 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtFacAgmtGrpLocListVO agtFacAgmtGrpLocListVO
	 * @return List<AgtFacAgmtGrpLocListVO>
	 * @exception EventException
	 */
	public List<AgtFacAgmtGrpLocListVO> searchFACGrpLocList(AgtFacAgmtGrpLocListVO agtFacAgmtGrpLocListVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_0057 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtScsAgmtRtVO agtScsAgmtRtVO
	 * @return List<AgtScsAgmtRtVO>
	 * @exception EventException
	 */
	public List<AgtScsAgmtRtVO> searchScsRateInfoList(AgtScsAgmtRtVO agtScsAgmtRtVO) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_AGT_0057 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param AgtScsAgmtRtVO[] agtScsAgmtRtVOS
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiScsRateInfo(AgtScsAgmtRtVO[] agtScsAgmtRtVOS, SignOnUserAccount account) throws EventException;
	
}