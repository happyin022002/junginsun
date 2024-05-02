/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri601401Event.java
*@FileTitle : RFA Quotation Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.09.03 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.event;

import com.hanjin.apps.alps.esm.pri.rfaquotation.rfagrouplocationquotation.vo.RFAGroupLocationQuotationVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_6015_01 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6015_01HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6015_01HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri601501Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	RFAGroupLocationQuotationVO groupLocationQuotationVO = new RFAGroupLocationQuotationVO();

	/**
	 * @return the groupLocationQuotationVO
	 */
	public RFAGroupLocationQuotationVO getGroupLocationQuotationVO() {
		return groupLocationQuotationVO;
	}

	/**
	 * @param groupLocationQuotationVO the groupLocationQuotationVO to set
	 */
	public void setGroupLocationQuotationVO(
			RFAGroupLocationQuotationVO groupLocationQuotationVO) {
		this.groupLocationQuotationVO = groupLocationQuotationVO;
	}
	
	

}