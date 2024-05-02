/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri60051Event.java
*@FileTitle : S/C Quotation Location Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.09
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.09 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scgrouplocationquotation.event;

import com.hanjin.apps.alps.esm.pri.scquotation.scgrouplocationquotation.vo.GroupLocationQuotationVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_6013_1 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6013_1HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6005_01HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri601301Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	GroupLocationQuotationVO groupLocationQuotationVO = new GroupLocationQuotationVO();

	/**
	 * @return the groupLocationQuotationVO
	 */
	public GroupLocationQuotationVO getGroupLocationQuotationVO() {
		return groupLocationQuotationVO;
	}

	/**
	 * @param groupLocationQuotationVO the groupLocationQuotationVO to set
	 */
	public void setGroupLocationQuotationVO(
			GroupLocationQuotationVO groupLocationQuotationVO) {
		this.groupLocationQuotationVO = groupLocationQuotationVO;
	}

	
	
}