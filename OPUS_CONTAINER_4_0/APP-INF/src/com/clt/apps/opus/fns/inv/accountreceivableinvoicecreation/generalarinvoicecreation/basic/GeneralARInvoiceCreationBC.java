/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingARCreationBC.java
*@FileTitle : Invoice Update by User ID
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic;

import java.util.List;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfCntrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * AccountReceivableInvoiceCreation Business Logic Basic Command implementation<br>
 * - AccountReceivableInvoiceCreation logic process<br>
 *
 * @author Jung Hwi Taek
 * @see GeneralARInvoiceCreationBC
 * @since J2EE 1.6
 */
public interface GeneralARInvoiceCreationBC {

	/**
	 * DEM, DET, TPB, MNR, LSE publication receivables information Interface. <br>
	 * 
	 * @param List<ARInterfaceCreationVO> genIfVos
	 * @return List<ARInterfaceCreationVO>
	 * @exception EventException
	 */
	public List<ARInterfaceCreationVO> interfaceGeneralARInvoiceToIF(List<ARInterfaceCreationVO> genIfVos) throws EventException;
	
	/**
	 * Creation information by DEM, DET, TPB, MNR, LSE Interface information. <br>
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
	//public DOMDestInvoiceVO[] esm0670001Receive(XmlObject xmlObject) throws EventException;
	
	/**
	 * INV_AR_IF_MN Table retrieve <br>
	 * 
	 * @param String srcIfDt
	 * @param String srcIfSeq
	 * @return InvArIfMnVO
	 * @exception EventException
	 */
	public InvArIfMnVO searchInvArIfMain(String srcIfDt, String srcIfSeq) throws EventException;
	
	/**
	 * INV_AR_IF_CHG Table retrieve <br>
	 * 
	 * @param String srcIfDt
	 * @param String srcIfSeq
	 * @return List<InvArIfChgVO>
	 * @exception EventException
	 */
	public List<InvArIfChgVO> searchInvArIfChg(String srcIfDt, String srcIfSeq) throws EventException;
	
	/**
	 * INV_AR_IF_CNTR Table retrieve <br>
	 * 
	 * @param String srcIfDt
	 * @param String srcIfSeq
	 * @return List<InvArIfCntrVO>
	 * @exception EventException
	 */
	public List<InvArIfCntrVO> searchInvArIfCntr(String srcIfDt, String srcIfSeq) throws EventException;
	
	/**
	 * INV_AR_MN Table delete <br>
	 * 
	 * @param String arIfNo
	 * @exception EventException
	 */
	public void removeArIfMain(String arIfNo) throws EventException;
	
	/**
	 * INV_AR_AMT Table delete <br>
	 * 
	 * @param String arIfNo
	 * @exception EventException
	 */
	public void removeArIfAmt(String arIfNo) throws EventException;
	
	/**
	 * INV_AR_CHG Table delete <br>
	 * 
	 * @param String arIfNo
	 * @exception EventException
	 */
	public void removeArIfChg(String arIfNo) throws EventException;
	
	/**
	 * INV_AR_CNTR Table delete <br>
	 * 
	 * @param String arIfNo
	 * @exception EventException
	 */
	public void removeArIfCntr(String arIfNo) throws EventException;
	
}