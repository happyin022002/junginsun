/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpenseMgtBC.java
*@FileTitle : ExpenseMgtBC
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.25
*@LastModifier : Chagn Young Kim
*@LastVersion : 1.0
* 2009.08.17 함형석
* 1.0 Creation
* 2014-10-06 Chang Young Kim 10만불 비용지급 결재 3차 Invoice File Attatch 기능 추가
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.basic;

import java.util.List;
import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.vo.PayableInvoiceGRPVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.vo.GLEstimateINVO;
import com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.vo.GLEstimateVO;

/**
 * alps-AccountManage Business Logic Command Interface<br>
 * - alps-AccountManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author 함형석
 * @see Ees_mnr_0041EventResponse 참조
 * @since J2EE 1.4
 */	
     
public interface ExpenseMgtBC {  

	/**
	 * [EES_MNR_0042]M&R Invoice Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param PayableInvoiceGRPVO payableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return PayableInvoiceGRPVO
	 * @exception EventException
	 */
	public PayableInvoiceGRPVO searchPayableINVInquiryListBasic(PayableInvoiceGRPVO payableInvoiceGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0042]M&R Invoice Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param PayableInvoiceGRPVO payableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return PayableInvoiceGRPVO
	 * @exception EventException
	 */
	public PayableInvoiceGRPVO searchPayableINVInquiryDetailBasic(PayableInvoiceGRPVO payableInvoiceGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0041]M&R Invoice Creation & Correction의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param PayableInvoiceGRPVO payableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return PayableInvoiceGRPVO
	 * @exception EventException
	 */
	public PayableInvoiceGRPVO manageRepairPayableInvoiceBasic(PayableInvoiceGRPVO payableInvoiceGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0041]M&R Invoice Creation & Correction의 정보를 삭제 합니다. <br>
	 *
	 * @param PayableInvoiceGRPVO payableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return PayableInvoiceGRPVO
	 * @exception EventException
	 */
	public PayableInvoiceGRPVO removePayableInvoiceBasic(PayableInvoiceGRPVO payableInvoiceGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0229]M&R Estimate expense를 조회합니다.<br>
	 * 
	 * @param GLEstimateINVO gLEstimateINVO
	 * @param SignOnUserAccount account
	 * @return List<GLEstimateVO>
	 * @exception EventException
	 */
	public List<GLEstimateVO> searchGLEstimateIFListBasic(GLEstimateINVO gLEstimateINVO, SignOnUserAccount account) throws EventException;
    
	/**
	 * [EES_MNR_0229]M&R Estimate expense를 조회합니다.<br>
	 *  
	 * @param GLEstimateINVO gLEstimateINVO
	 * @param SignOnUserAccount account 
	 * @exception EventException
	 */
	public void manageGLEstimateIFListBasic(GLEstimateINVO gLEstimateINVO,SignOnUserAccount account) throws EventException;
	 
	/**
	 * [EES_MNR_0096]Total Loss 정보를 Invoice 정보에 저장합니다.<br>
	 * 
	 * @param  payableInvoiceGRPVO PayableInvoiceGRPVO
	 * @param SignOnUserAccount account 
	 * @return String[] 
	 * @exception EventException   
	 */ 
	public String[] manageTotalLossPayableInvoiceBasic(PayableInvoiceGRPVO payableInvoiceGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0096]Total Loss 정보를 Invoice 정보에 수정합니다.<br>
	 * 
	 * @param String payInvSeq
	 * @param String invRgstNo
	 * @param SignOnUserAccount account 
	 * @exception EventException   
	 */ 
	public void modifyTotalLossPayableInvoiceBasic(String payInvSeq, String invRgstNo,SignOnUserAccount account, String fileSeq) throws EventException;
	
	/**
	 * [EES_MNR_0041]Payable Invoice 상태정보를 수정 합니다. <br>
	 * 
	 * @param PayableInvoiceGRPVO payableInvoiceGRPVO
	 * @param SignOnUserAccount account 
	 * @exception EventException   
	 */ 
	public void modifyPayableInvoiceStatusBasic(PayableInvoiceGRPVO payableInvoiceGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0229]M&R Estimate expense를 excel download합니다.<br>
	 * 
	 * @param
	 * @return String[]
	 * @exception
	 */
	public String[] getTitle();
		
	/**
	 * [EES_MNR_0229]M&R Estimate expense를 excel download합니다.<br>
	 * 
	 * @param
	 * @return String[]
	 * @exception
	 */
	public String[] getColumns();
} 