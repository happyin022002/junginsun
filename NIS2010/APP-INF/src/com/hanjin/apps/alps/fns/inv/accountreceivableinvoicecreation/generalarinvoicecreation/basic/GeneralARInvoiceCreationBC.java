/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingARCreationBC.java
*@FileTitle : Invoice Update by User ID
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.06.01 한동훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic;

import java.util.List;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.DOMDestInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-Accountreceivableinvoicecreation Business Logic Command Interface<br>
 * - ALPS-Accountreceivableinvoicecreation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Jung Hwi Taek
 * @see Fns_inv_0026EventResponse 참조
 * @since J2EE 1.6
 */

public interface GeneralARInvoiceCreationBC {

	/**
	 * Terminal 에서 발생한 매출채권 정보를 Interface 받는다. <br>
	 * 
	 * @param String rcvMsg
	 * @param String userId
	 * @param String integrationId
	 * @return List<ARInterfaceCreationVO>
	 * @exception EventException
	 */
	public List<ARInterfaceCreationVO> interfaceTerminalARInvoiceToIF(String rcvMsg, String userId, String integrationId) throws EventException;
	
	/**
	 * Booking 이외에 타 시스템 (DEM, DET, TPB, MNR, LSE )에서 발생한 매출채권 정보를 Interface 받는다. <br>
	 * 
	 * @param List<ARInterfaceCreationVO> genIfVos
	 * @return List<ARInterfaceCreationVO>
	 * @exception EventException
	 */
	public List<ARInterfaceCreationVO> interfaceGeneralARInvoiceToIF(List<ARInterfaceCreationVO> genIfVos) throws EventException;
	
	/**
	 * Booking 이외에 타 시스템 (DEM, DET, TPB, MNR, LSE )에서 Interface 받은 정보로 Invoice 정보를 생성하고 ERP 로 Interface 한다. <br>
	 * 
	 * @param List<ARInterfaceCreationVO> genIfVos
	 * @return String
	 * @exception EventException
	 */
	public String interfaceGeneralARInvoiceToINV(List<ARInterfaceCreationVO> genIfVos) throws EventException;

	/**
	 * ESM0670001Document XMLparsing <br>
	 * 
	 * @param XmlObject xmlObject
	 * @return DOMDestInvoiceVO[]
	 * @exception EventException
	 */
	public DOMDestInvoiceVO[] esm0670001Receive(XmlObject xmlObject) throws EventException;
	
	/**
	 * INV_AR_IF_MN Table 조회 <br>
	 * 
	 * @param String srcIfDt
	 * @param String srcIfSeq
	 * @return InvArIfMnVO
	 * @exception EventException
	 */
	public InvArIfMnVO searchInvArIfMain(String srcIfDt, String srcIfSeq) throws EventException;
	
	/**
	 * INV_AR_IF_CHG Table 조회 <br>
	 * 
	 * @param String srcIfDt
	 * @param String srcIfSeq
	 * @return List<InvArIfChgVO>
	 * @exception EventException
	 */
	public List<InvArIfChgVO> searchInvArIfChg(String srcIfDt, String srcIfSeq) throws EventException;
	
	/**
	 * INV_AR_IF_CNTR Table 조회 <br>
	 * 
	 * @param String srcIfDt
	 * @param String srcIfSeq
	 * @return List<InvArIfCntrVO>
	 * @exception EventException
	 */
	public List<InvArIfCntrVO> searchInvArIfCntr(String srcIfDt, String srcIfSeq) throws EventException;
	
	/**
	 * INV_AR_MN Table 삭제 <br>
	 * 
	 * @param String arIfNo
	 * @exception EventException
	 */
	public void removeArIfMain(String arIfNo) throws EventException;
	
	/**
	 * INV_AR_AMT Table 삭제 <br>
	 * 
	 * @param String arIfNo
	 * @exception EventException
	 */
	public void removeArIfAmt(String arIfNo) throws EventException;
	
	/**
	 * INV_AR_CHG Table 삭제 <br>
	 * 
	 * @param String arIfNo
	 * @exception EventException
	 */
	public void removeArIfChg(String arIfNo) throws EventException;
	
	/**
	 * INV_AR_CNTR Table 삭제 <br>
	 * 
	 * @param String arIfNo
	 * @exception EventException
	 */
	public void removeArIfCntr(String arIfNo) throws EventException;
	
	/**
	 * INV 에서 발생한 매출채권 정보를 EAI를 통해(FNS012-0001) ERP AR로 전송다 한<br> 
	 * 
	 * @param String ifNo
	 * @exception EventException
	 */
	public void interfaceARInvoiceToERPAR(String ifNo) throws EventException;
	
}