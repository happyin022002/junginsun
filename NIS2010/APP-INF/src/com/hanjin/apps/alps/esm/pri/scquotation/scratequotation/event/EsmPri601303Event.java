/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri600503Event.java
*@FileTitle : S/C Quotation Rate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.12 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.event;

import com.hanjin.apps.alps.esm.pri.scquotation.scratequotation.vo.RateQuotationVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_6013_03 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6013_03HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6013_03HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri601303Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	RateQuotationVO rateQuotationVO = new RateQuotationVO();

	/**
	 * @return the rateQuotationVO
	 */
	public RateQuotationVO getRateQuotationVO() {
		return rateQuotationVO;
	}

	/**
	 * @param rateQuotationVO the rateQuotationVO to set
	 */
	public void setRateQuotationVO(RateQuotationVO rateQuotationVO) {
		this.rateQuotationVO = rateQuotationVO;
	}

	
}