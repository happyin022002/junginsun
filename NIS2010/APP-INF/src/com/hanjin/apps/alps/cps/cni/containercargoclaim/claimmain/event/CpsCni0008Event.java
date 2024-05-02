/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CpsCni0008Event.java
 *@FileTitle : Payment
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 양정란
 *@LastVersion : 1.0
 * 2009.10.05 양정란 
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.event;


import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmVO;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo.PaymentVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * [CPS_CNI_0002] Payment
 * @author 양정란 
 * @see CPS_CNI_0008HTMLAction 참조
 * @since J2EE 1.4
 */

public class CpsCni0008Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
    /* 조회 문자열 */
    private String cgoClmNo;
    
	private String pageNo;

    /* VO */
    private PaymentVO paymentVO;
    private CniCgoClmVO cniCgoClmVO;

	public CniCgoClmVO getCniCgoClmVO() {
		return cniCgoClmVO;
	}

	public void setCniCgoClmVO(CniCgoClmVO cniCgoClmVO) {
		this.cniCgoClmVO = cniCgoClmVO;
	}

	public String getCgoClmNo() {
		return cgoClmNo;
	}

	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public PaymentVO getPaymentVO() {
		return paymentVO;
	}

	public void setPaymentVO(PaymentVO paymentVO) {
		this.paymentVO = paymentVO;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
    
    
}