/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt7016Event.java
*@FileTitle : Summary Report by Customer
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.09.29 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.SummaryReportByCustomerParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.UsLfdEdiAudidtListVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo.UsLfdEdiAudidtParmVO;


/**
 * EES_DMT_6005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DMT_6005HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Hwang HyoKeun
 * @see EES_DMT_6005HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDmt7016Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private UsLfdEdiAudidtParmVO usLfdEdiAudidtParmVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private UsLfdEdiAudidtParmVO[] usLfdEdiAudidtParmVOs = null;

	public EesDmt7016Event(){}

	public UsLfdEdiAudidtParmVO getUsLfdEdiAudidtParmVO() {
		return usLfdEdiAudidtParmVO;
	}

	public void setUsLfdEdiAudidtParmVO(UsLfdEdiAudidtParmVO usLfdEdiAudidtParmVO) {
		this.usLfdEdiAudidtParmVO = usLfdEdiAudidtParmVO;
	}

	public UsLfdEdiAudidtParmVO[] getUsLfdEdiAudidtParmVOs() {
		return usLfdEdiAudidtParmVOs;
	}

	public void setUsLfdEdiAudidtParmVOs(
			UsLfdEdiAudidtParmVO[] usLfdEdiAudidtParmVOs) {
		this.usLfdEdiAudidtParmVOs = usLfdEdiAudidtParmVOs;
	}
	
}