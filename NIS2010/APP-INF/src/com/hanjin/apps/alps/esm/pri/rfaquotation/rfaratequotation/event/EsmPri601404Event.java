/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EsmPri600503Event.java
 *@FileTitle : Quotation Rate Creation (For AEW/AEE)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.07.16
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.event;

import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaratequotation.vo.RFARateQuotationVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_6014_04 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_6005_03HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Eun-Sup, Lee
 * @see ESM_PRI_6014_04HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri601404Event extends EventSupport {

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