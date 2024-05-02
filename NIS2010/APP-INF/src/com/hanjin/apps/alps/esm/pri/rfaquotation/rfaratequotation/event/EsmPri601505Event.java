/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EsmPri600505Event.java
 *@FileTitle : S/C Quotation Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.11.06
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event;

import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RFARateQuotationVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_6015_04 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_6015_05HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Eun-Sup, Lee
 * @see ESM_PRI_6015_05HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri601505Event extends EventSupport {

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