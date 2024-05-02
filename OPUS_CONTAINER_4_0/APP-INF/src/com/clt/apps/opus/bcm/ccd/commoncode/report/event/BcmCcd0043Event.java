/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BcmCcd0025Event.java
*@FileTitle : activity
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.report.event;

import com.clt.apps.opus.bcm.ccd.commoncode.report.vo.CustomerReportVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * BCM_CCD_0047 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  BCM_CCD_0047HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 
 * @see BCM_CCD_0047HTMLAction 참조
 * @since J2EE 1.6
 */

public class BcmCcd0043Event extends EventSupport {

private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private CustomerReportVO customerReportVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private CustomerReportVO[] customerReportVOs = null;

	public BcmCcd0043Event(){}
	
	public void setCustomerReportVO(CustomerReportVO customerReportVO){
		this. customerReportVO = customerReportVO;
	}

	public void setCustomerReportVOS(CustomerReportVO[] customerReportVOs){
		if(customerReportVOs != null){
			CustomerReportVO[] tmpVOs = java.util.Arrays.copyOf(customerReportVOs, customerReportVOs.length);
			this.customerReportVOs = tmpVOs;
		}
	}

	public CustomerReportVO getCustomerReportVO(){
		return customerReportVO;
	}

	public CustomerReportVO[] getCustomerReportVOS(){
		CustomerReportVO[] rtnVOs = null;
		if (this.customerReportVOs != null) {
			rtnVOs = java.util.Arrays.copyOf(customerReportVOs, customerReportVOs.length);
		}
		return rtnVOs;
	}
}