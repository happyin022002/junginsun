/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EsmPri601405Event.java
 *@FileTitle : Quotation Rate Creation (For Add-On Tariff)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.10.26
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event;

import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RFARateQuotationVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_6014_05 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_6005_05HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Eun-Sup, Lee
 * @see ESM_PRI_6014_05HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri601405Event extends EventSupport {

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