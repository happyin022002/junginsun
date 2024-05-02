/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri6014Event.java
*@FileTitle : RFA Quotation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.02
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.09.02 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.event;

import com.hanjin.apps.alps.esm.pri.rfaquotation.rfaquotationmain.vo.RFAQutationMainVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_6015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6015HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri6015Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	RFAQutationMainVO qutationMainVO = new RFAQutationMainVO();

	/**
	 * @return the qutationMainVO
	 */
	public RFAQutationMainVO getQutationMainVO() {
		return qutationMainVO;
	}

	/**
	 * @param qutationMainVO the qutationMainVO to set
	 */
	public void setQutationMainVO(RFAQutationMainVO qutationMainVO) {
		this.qutationMainVO = qutationMainVO;
	}
	
	 
}