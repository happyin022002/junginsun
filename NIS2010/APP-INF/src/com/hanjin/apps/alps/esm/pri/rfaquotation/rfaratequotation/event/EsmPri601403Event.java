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
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event;

import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RFARateQuotationVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_6005_03 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6005_03HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6014_03HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri601403Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	RFARateQuotationVO rateQuotationVO = new RFARateQuotationVO();

	/**
	 * @return the rateQuotationVO
	 */
	public RFARateQuotationVO getRateQuotationVO() {
		return rateQuotationVO;
	}

	/**
	 * @param rateQuotationVO the rateQuotationVO to set
	 */
	public void setRateQuotationVO(RFARateQuotationVO rateQuotationVO) {
		this.rateQuotationVO = rateQuotationVO;
	}

	
	
}