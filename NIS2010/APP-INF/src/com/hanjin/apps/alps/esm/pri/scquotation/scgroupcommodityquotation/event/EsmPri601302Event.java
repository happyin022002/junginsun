/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmPri600502Event.java
*@FileTitle : S/C Quotation Commodity Group Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.09
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.08.09 이승준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.event;

import com.hanjin.apps.alps.esm.pri.scquotation.scgroupcommodityquotation.vo.GroupCommodityQuotationVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_PRI_6013_02 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_6013_02HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Seung-Jun,Lee
 * @see ESM_PRI_6013_02HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri601302Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	GroupCommodityQuotationVO groupCommodityQuotationVO = new GroupCommodityQuotationVO();

	/**
	 * @return the groupCommodityQuotationVO
	 */
	public GroupCommodityQuotationVO getGroupCommodityQuotationVO() {
		return groupCommodityQuotationVO;
	}

	/**
	 * @param groupCommodityQuotationVO the groupCommodityQuotationVO to set
	 */
	public void setGroupCommodityQuotationVO(
			GroupCommodityQuotationVO groupCommodityQuotationVO) {
		this.groupCommodityQuotationVO = groupCommodityQuotationVO;
	}

}