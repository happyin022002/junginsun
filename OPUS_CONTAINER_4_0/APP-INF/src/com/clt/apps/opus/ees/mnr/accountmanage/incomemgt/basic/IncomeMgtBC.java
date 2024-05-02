/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IncomeMgtBC.java
*@FileTitle : IncomeMgtBC
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.accountmanage.incomemgt.basic;


import com.clt.apps.opus.ees.mnr.accountmanage.incomemgt.vo.ReceivableInvoiceGRPVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * COM-AccountManage Business Logic Command Interface<br>
 *
 * @author 
 * @see Ees_mnr_0161EventResponse reference
 * @since J2EE 1.4
 */	
     
public interface IncomeMgtBC {  

	/**
	 * retrieving [EES_MNR_0161] <br>
	 *
	 * @param ReceivableInvoiceGRPVO receivableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return ReceivableInvoiceGRPVO
	 * @exception EventException
	 */ 
	public ReceivableInvoiceGRPVO searchReceivableInvoiceListBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0161]retrieving Disposal Invoice Issue. <br>
	 *
	 * @param ReceivableInvoiceGRPVO receivableInvoiceGRPVO
	 * @return ReceivableInvoiceGRPVO
	 * @exception EventException
	 */
	public ReceivableInvoiceGRPVO searchReceivableInvoiceDetailListBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO) throws EventException;

	/**
	 * [EES_MNR_0161]adding/modification/deletion Disposal Invoice Issue. <br>
	 *
	 * @param ReceivableInvoiceGRPVO receivableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return ReceivableInvoiceGRPVO
	 * @exception EventException
	 */ 
	public ReceivableInvoiceGRPVO manageRepairReceivableInvoiceBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0161]deleting Disposal Invoice Issue. <br>
	 *
	 * @param ReceivableInvoiceGRPVO receivableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return ReceivableInvoiceGRPVO
	 * @exception EventException
	 */ 
	public ReceivableInvoiceGRPVO removeReceivableInvoiceBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0161]modifying Disposal Invoice Issue. <br>
	 * 
	 * @param ReceivableInvoiceGRPVO receivableInvoiceGRPVO
	 * @param SignOnUserAccount account 
	 * @exception EventException   
	 */ 
	public void modifyReceivableInvoiceStatusBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO,SignOnUserAccount account) throws EventException;

} 