/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : FnsInv0116Event.java
 *@FileTitle : Transaction Data Comparison Report 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.12.28
 *@LastModifier : 최도순
 *@LastVersion : 1.0
 * 2010.12.28 최도순
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.event;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.TransDataComparisonReportInputVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * FNS_INV_0115 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - FNS_INV_0115HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author KIM HYUN HWA
 * @see FNS_INV_0115HTMLAction 참조
 * @since J2EE 1.6
 */

public class FnsInv0116Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리 */
	private TransDataComparisonReportInputVO transDataComparisonReportInputVO = null;

	
	public FnsInv0116Event() {
	}


	/**
	 * @return the transDataComparisonReportInputVO
	 */
	public TransDataComparisonReportInputVO getTransDataComparisonReportInputVO() {
		return transDataComparisonReportInputVO;
	}


	/**
	 * @param transDataComparisonReportInputVO the transDataComparisonReportInputVO to set
	 */
	public void setTransDataComparisonReportInputVO(
			TransDataComparisonReportInputVO transDataComparisonReportInputVO) {
		this.transDataComparisonReportInputVO = transDataComparisonReportInputVO;
	}

	
	
}