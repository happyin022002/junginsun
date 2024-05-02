/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AGTCustomerInfoBC.java
*@FileTitle : Agent Commission Customer Infomation Management
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-22
*@LastModifier : Junghyung_kim
*@LastVersion : 1.0
* 2006-11-22 Junghyung_kim
* 1.0 최초 생성
* 2009-10-14 : Ho-Jin Lee Alps 전환
* 1.1 2011.04.22 박성진 [CHM-201109104-01] Customer Vs Vendor for S. America 추가
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtmaster.agtcustomerinfo.basic;

import java.util.List;

import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.AgtBrogCustIntVO;
import com.hanjin.syscommon.common.table.AgtBrogCustMtchVO;
import com.hanjin.syscommon.common.table.AgtCmpnCustMtchVO;
import com.hanjin.syscommon.common.table.AgtFacCustRltVO;

/**
 * eNIS-AGT Business Logic Command Interface<br>
 * - eNIS-AGT에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Junghyung_kim
 * @see ESM_AGT_038EventResponse 참조
 * @since J2EE 1.4
 */
public interface AGTCustomerInfoBC  {

	/**
	 * ESM_AGT_0025 화면에 대한 조회 이벤트 처리<br>
	 * @param AgtBrogCustMtchVO agtBrogCustMtchVO
	 * @return List<AgtBrogCustMtchVO>
	 * @throws EventException
	 */
	public List<AgtBrogCustMtchVO> searchFForwarderVendorMatchingInfoForBrokerage(AgtBrogCustMtchVO agtBrogCustMtchVO) throws EventException;

	/**
	 * ESM_AGT_0025 화면에 대한 멀티 이벤트 처리<br>
	 * @param AgtBrogCustMtchVO[] agtBrogCustMtchVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiFForwarderVendorMatchingInfoForBrokerage(AgtBrogCustMtchVO[] agtBrogCustMtchVOs, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_AGT_026 화면 조회<br>
	 * @param agtBrogCustIntVO
	 * @return List<AgtBrogCustIntVO> 
	 * @exception EventException
	 */
	public List<AgtBrogCustIntVO> searchBRKGCustomerToShipperInterestList(AgtBrogCustIntVO agtBrogCustIntVO) throws EventException;
	/**
	 * ESM_AGT_026 화면 Multi<br>
	 * @param AgtBrogCustIntVO[] agtBrogCustIntVOs
	 * @param account
	 * @exception EventException
	 */
	public void multiBRKGCustomerToShipperInterestInfo(AgtBrogCustIntVO[] agtBrogCustIntVOs, SignOnUserAccount account) throws EventException;


	/**
	 * 조회 이벤트 처리<br>
	 * ESM_AGT_030 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param AgtFacCustRltVO agtFacCustRltVO
	 * @return List<AgtFacCustRltVO>
	 * @exception EventException
	 */
	public List<AgtFacCustRltVO> searchFACCustomerToShipperInterestList(AgtFacCustRltVO agtFacCustRltVO) throws EventException;
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_AGT_030 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param AgtFacCustRltVO[] agtFacCustRltVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void multiFACCustomerToShipperInterestList(AgtFacCustRltVO[] agtFacCustRltVOs, SignOnUserAccount account) throws EventException;
	/**
	 * ESM_AGT_0058 화면에 대한 조회 이벤트 처리<br>
	 * @param AgtCmpnCustMtchVO agtCmpnCustMtchVO
	 * @return List<AgtCmpnCustMtchVO>
	 * @throws EventException
	 */
	public List<AgtCmpnCustMtchVO> searchShipperVendorMatchingInfo(AgtCmpnCustMtchVO agtCmpnCustMtchVO) throws EventException;

	/**
	 * ESM_AGT_0058 화면에 대한 멀티 이벤트 처리<br>
	 * @param AgtCmpnCustMtchVO[] agtCmpnCustMtchVOs
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void multiShipperVendorMatchingInfo(AgtCmpnCustMtchVO[] agtCmpnCustMtchVOs, SignOnUserAccount account) throws EventException;
}