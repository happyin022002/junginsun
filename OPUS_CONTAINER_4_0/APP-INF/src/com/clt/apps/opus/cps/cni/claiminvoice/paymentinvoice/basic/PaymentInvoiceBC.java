/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PaymentInvoiceBC.java
 *@FileTitle : 지불전표 리스트 조회 관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.10.05 박제성 , 진윤오 , 정행룡 , 양정란 , 윤세영
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.basic;

import java.util.List;

import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo.ArRevenueVVDVO;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo.CsrManagerListCondVO;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo.CsrManagerListVO;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo.PaymentInvoiceInfoVO;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo.PaymentInvoiceVO;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo.VendorInfoVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * 지불전표 리스트 Logic Command Interface<br>
 * @author 
 * @see 
 * @since J2EE 1.4
 */

public interface PaymentInvoiceBC {
    
	

    // ===========================================================================
    // 진윤오
    // ===========================================================================
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0048] CSR Manager 
	// ---------------------------------------------------------------------------
	/**
	 * Payment Invoice 리스트<br>
	 * @author 진윤오
	 * @category CPS_CNI_0048
	 * @category searchCsrManagerList 
	 * @param CsrManagerListCondVO condVo	
     * @return List<CsrManagerListVO>
     * @throws EventException
     */
	public List<CsrManagerListVO> searchCsrManagerList(CsrManagerListCondVO condVo) throws EventException;
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0045] Invoice Creation
	// ---------------------------------------------------------------------------

	/**
	 * Payment Invoice 리스트<br>
	 * @author 진윤오
	 * @category CPS_CNI_0045
	 * @category searchPaymentInvoiceList 
	 * @param String cgoClmNo
	 * @param String hdlrUsrId
     * @return List<PaymentInvoiceVO>
     * @throws EventException
     */
	public List<PaymentInvoiceVO> searchPaymentInvoiceList(String cgoClmNo ,String hdlrUsrId) throws EventException;
	
	/**
	 * Payment Invoice 정보<br>
	 * @author 진윤오
	 * @category CPS_CNI_0045
	 * @category searchPaymentInvoiceInfo 
	 * @param String cgoClmPayNo
     * @return PaymentInvoiceInfoVO
     * @throws EventException
     */
	public PaymentInvoiceInfoVO searchPaymentInvoiceInfo(String cgoClmPayNo) throws EventException;

	/**
	 * 비용처리오피스 취득
	 * @author 진윤오
	 * @category CPS_CNI_0045
	 * @category searchCostOfcCd
	 * @param String ofcCd
     * @return String
     * @throws EventException
     */
	public String searchCostOfcCd(String ofcCd) throws EventException;
	
	
	/**
	 * Vendor 정보<br>
	 * @author 진윤오
	 * @category CPS_CNI_0045
	 * @category searchVendorInfo
	 * @param String vndrSeq
     * @return VendorInfoVO
     * @throws EventException
     */
	public VendorInfoVO searchVendorInfo(String vndrSeq) throws EventException;	
	
	/**
	 * RevenueVVD 재무항차 정보<br>
	 * 재무항차가 존재 하는경우는 재무항차로 설정
	 * 존재하지 않을경우에는 공통항차를 설정한다.
	 * @author 진윤오
	 * @category CPS_CNI_0045
	 * @category searchRevenueVVDInfo
	 * @param ArRevenueVVDVO vo
	 * @param String invIssDt 
	 * @param String costOfcCd
     * @return ArRevenueVVDVO
     * @throws EventException
     */
	 public ArRevenueVVDVO searchRevenueVVDInfo(ArRevenueVVDVO vo ,String invIssDt , String costOfcCd) throws EventException;
 
}