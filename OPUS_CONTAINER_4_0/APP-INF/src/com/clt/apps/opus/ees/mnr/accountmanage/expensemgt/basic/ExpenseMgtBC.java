/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpenseMgtBC.java
*@FileTitle : ExpenseMgtBC
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo.GLEstimateINVO;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo.GLEstimateVO;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo.PayableInvoiceGRPVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * COM-AccountManage Business Logic Command Interface<br>
 *
 * @author 
 * @see Ees_mnr_0041EventResponse reference
 * @since J2EE 1.4
 */	
     
public interface ExpenseMgtBC {  

	/**
	 * [EES_MNR_0042] retrieving M&R Invoice Inquiry. <br>
	 *
	 * @param PayableInvoiceGRPVO payableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return PayableInvoiceGRPVO
	 * @exception EventException
	 */
	public PayableInvoiceGRPVO searchPayableINVInquiryListBasic(PayableInvoiceGRPVO payableInvoiceGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0042] retrieving M&R Invoice Inquiry. <br>
	 *
	 * @param PayableInvoiceGRPVO payableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return PayableInvoiceGRPVO
	 * @exception EventException
	 */
	public PayableInvoiceGRPVO searchPayableINVInquiryDetailBasic(PayableInvoiceGRPVO payableInvoiceGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0041] adding/modification/deletion M&R Invoice Creation & Correction. <br>
	 *
	 * @param PayableInvoiceGRPVO payableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return PayableInvoiceGRPVO
	 * @exception EventException
	 */
	public PayableInvoiceGRPVO manageRepairPayableInvoiceBasic(PayableInvoiceGRPVO payableInvoiceGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0041] deleting M&R Invoice Creation & Correction. <br>
	 *
	 * @param PayableInvoiceGRPVO payableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return PayableInvoiceGRPVO
	 * @exception EventException
	 */
	public PayableInvoiceGRPVO removePayableInvoiceBasic(PayableInvoiceGRPVO payableInvoiceGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0229] retrieving M&R Estimate expense.<br>
	 * 
	 * @param GLEstimateINVO gLEstimateINVO
	 * @param SignOnUserAccount account
	 * @return List<GLEstimateVO>
	 * @exception EventException
	 */
	public List<GLEstimateVO> searchGLEstimateIFListBasic(GLEstimateINVO gLEstimateINVO, SignOnUserAccount account) throws EventException;
    
	/**
	 * [EES_MNR_0229] retrieving M&R Estimate expense.<br>
	 *  
	 * @param GLEstimateINVO gLEstimateINVO
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void manageGLEstimateIFListBasic(GLEstimateINVO gLEstimateINVO,SignOnUserAccount account) throws EventException;
	 
	/**
	 * [EES_MNR_0096] saving Total Loss on Invoice .<br>
	 * 
	 * @param  payableInvoiceGRPVO PayableInvoiceGRPVO
	 * @param SignOnUserAccount account 
	 * @return String[] 
	 * @exception EventException   
	 */ 
	public String[] manageTotalLossPayableInvoiceBasic(PayableInvoiceGRPVO payableInvoiceGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0096] modifying Total Loss on Invoice. <br>
	 * 
	 * @param String payInvSeq
	 * @param String invRgstNo
	 * @param SignOnUserAccount account 
	 * @exception EventException   
	 */ 
	public void modifyTotalLossPayableInvoiceBasic(String payInvSeq, String invRgstNo,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0041] modifying Payable Invoice status. <br>
	 * 
	 * @param PayableInvoiceGRPVO payableInvoiceGRPVO
	 * @param SignOnUserAccount account 
	 * @exception EventException   
	 */ 
	public void modifyPayableInvoiceStatusBasic(PayableInvoiceGRPVO payableInvoiceGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0229] downloading excel M&R Estimate expense.<br>
	 * 
	 * @param
	 * @return String[]
	 * @exception
	 */
	public String[] getTitle();
		
	/**
	 * [EES_MNR_0229] downloading excel M&R Estimate expense.<br>
	 * 
	 * @param
	 * @return String[]
	 * @exception
	 */
	public String[] getColumns();
} 