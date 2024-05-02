/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri6098Event.java
 *@FileTitle :Rate Quotation Vertical Load Excel
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.11.01
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event;

import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RFARateQuotationVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_6098 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_6098HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Eun-Sup, Lee
 * @see ESM_PRI_6098HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6098Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	private RFARateQuotationVO rateQuotationVO = new RFARateQuotationVO();
	public RFARateQuotationVO getRateQuotationVO() {
		return rateQuotationVO;
	}

	public void setRateQuotationVO(RFARateQuotationVO rateQuotationVO) {
		this.rateQuotationVO = rateQuotationVO;
	}

}