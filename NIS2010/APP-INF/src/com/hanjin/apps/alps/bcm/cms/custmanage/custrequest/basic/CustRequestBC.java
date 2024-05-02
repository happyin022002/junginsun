/*=========================================================
*Copyright(c) 2017 Hipluscard
*@FileName : CustRequestBC.java
*@FileTitle : Customer Request
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custrequest.basic;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BlHistVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custgroup.vo.CustomerGroupCodeVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custgroup.vo.SearchCustGroupVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.BkgSalesRepVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CustCoverTeamVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CustomerAddressVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CustomerContactVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CustomerIntegrationVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.CustomerVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.MdmCustomerVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custmain.vo.SearchCustomerVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * Common code Business Logic Command Interface<br>
 * An interface to the business logic for Common code<br>
 *
 * @author 
 * @see 
 * @since J2EE 1.4 
 */

public interface CustRequestBC {
	
	/**
	 * Customer 정보를 EAI로 전송한다. <BR>
	 * @param String eaiIfTp
	 * @param String eaiIfMsg
	 * @param CustomerVO customerVo
	 */
	public void sendCustRqstToMdm(String rqstNo, String usrId, String creFlag) throws EventException;
	
	/**
	 * multi event process<br>
	 * Customer Code Creation  multi event process(BCM_CMS_0309)<br>
	 * 
	 * @param CustomerVO customerVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public CustomerVO manageCustRqst(CustomerVO customerVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * multi event process<br>
	 * Customer approve  multi event process(BCM_CMS_0309)<br>
	 * 
	 * @param String rqstNo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public String approveCustRqst(String rqstNo, SignOnUserAccount account) throws EventException;
	
	/**
	 * multi event process<br>
	 * Customer approve  multi event process(BCM_CMS_0309)<br>
	 * 
	 * @param String rqstNo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public String approveCustRqstGrp(String rqstNo, SignOnUserAccount account) throws EventException;
	
	/**
	 * Request No checking.<br>
	 * 
	 * @param String rqstNo
	 * @return String
	 * @exception EventException
	 */
	public String checkCustRqst(String rqstNo) throws EventException;
	
	/**
	 * Customer Code retrieve.(BCM_CMS_0309)<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return CustomerVO
	 * @exception DAOException
	 */
	public CustomerVO searchCustRqst(String rqstNo) throws EventException;
	
	/**
	 * CustGroup List 조회<br>
	 * @param String rqstNo
	 * @param String custNm
	 * @param String ofcCd
	 * @param int iPage
	 * @param String deltFlg
	 * @return List<CustomerVO>
	 * @throws EventException
	 */
	public List<CustomerVO> searchRqstCustomer(String rqstNo, String custNm, String ofcCd, int iPage, String deltFlg, String rqstFmDt, String rqstToDt, String creFmDt, String creToDt) throws EventException;
	
	/**
	 * MDM User Auth checking.<br>
	 * 
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String checkUserMdmAuth(String usrId) throws EventException;
	
	/**
	 * Customer Request Status update. <BR>
	 * @param CustomerVO customerVo
	 */
	public void modifyCustomerRqstSts(CustomerVO customerVO) throws EventException;
	
	
}
