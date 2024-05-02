/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri601402Event.java
*@FileTitle : RFA Quotation Commodity Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.09.03 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfagroupcommodityquotation.event;

import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagroupcommodityquotation.vo.RFAGroupCommodityQuotationVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_6015_02 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6015_02HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6015_02HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri601502Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	RFAGroupCommodityQuotationVO groupCommodityQuotationVO = new RFAGroupCommodityQuotationVO();

	/**
	 * @return the groupCommodityQuotationVO
	 */
	public RFAGroupCommodityQuotationVO getGroupCommodityQuotationVO() {
		return groupCommodityQuotationVO;
	}

	/**
	 * @param groupCommodityQuotationVO the groupCommodityQuotationVO to set
	 */
	public void setGroupCommodityQuotationVO(
			RFAGroupCommodityQuotationVO groupCommodityQuotationVO) {
		this.groupCommodityQuotationVO = groupCommodityQuotationVO;
	}

	
	
	
}