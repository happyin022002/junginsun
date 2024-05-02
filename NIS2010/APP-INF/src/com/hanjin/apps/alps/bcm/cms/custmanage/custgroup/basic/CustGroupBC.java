/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : CustGroupBC.java
*@FileTitle : CustGroup
*Open Issues :
*Change history :
*@LastModifyDate : 2017-07-12
*@LastModifier : Lim Jaekwan
*@LastVersion : 1.0
* 2017-07-12 Lim Jaekwan
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custgroup.basic;

import java.util.List;

import com.hanjin.apps.alps.bcm.cms.custmanage.custgroup.vo.CustomerGroupCodeVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custgroup.vo.SearchCustGroupVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CustomerPerformanceVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ENIS-BIZCOMMON Business Logic Command Interface<br>
 * - ENIS-BIZCOMMON에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Lim Jaekwan
 * @see ComCom006EventResponse 참조
 * @since J2EE 1.4
 */
public interface CustGroupBC  {
	
	/**
	 * Group Customer retrieve.(BCM_CMS_0306)<br>
	 * 
	 * @param String custCd
	 * @return CustomerPerformanceVO
	 * @exception EventException
	 */
	public CustomerPerformanceVO searchCustPerfCode(String custCd) throws EventException;

	/**
	 * CustGroup List 조회<br>
	 * @param String custGrpId
	 * @param String custGrpNm
	 * @param String ofcCd
	 * @param int iPage
	 * @param String mdmYn
	 * @param String deltFlg
	 * @param String custGrpAbbrNm
	 * @return List<SearchCustGroupVO>
	 * @throws EventException
	 */
	public List<SearchCustGroupVO> searchCustGroupList(String custGrpId, String custGrpNm, String ofcCd, int iPage, String mdmYn, String deltFlg, String custGrpAbbrNm) throws EventException;
	
	/**
	 * BCM_CMS_0306 : Retrieve<br>
	 * Group Code에 해당하는 Customer Detail 정보를 조회합니다.<br>
	 * 
	 * @param CustomerGroupCodeVO customerGroupCodeVO
	 * @return List<CustomerGroupCodeVO>
	 * @exception EventException
	 */	
	public List<CustomerGroupCodeVO> searchCustGroupDetail(String custCd)throws EventException;
	
	/**
	 * multi event process<br>
	 * Group Customer Code  multi event process(BCM_CMS_0306)<br>
	 * 
	 * @param CustomerPerformanceVO customerPerformanceVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustPerfCode(CustomerPerformanceVO customerPerformanceVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * multi event process<br>
	 * Customer Address  multi event process(BCM_CMS_0306)<br>
	 * 
	 * @param CustomerAddressVO[] custAddrVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCustGroupCode(CustomerGroupCodeVO[] custGroupVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * Group Customer 정보를 EAI로 전송한다. <BR>
	 * @param String custCd
	 * @param String usrId
	 * @param String creFlag
	 */
	public void sendCustGrpToMdm(String custCd, String usrId, String creFlag) throws EventException ;


}