/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmFms0090Event.java
*@FileTitle : Off-Hire Expenses
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.13
*@LastModifier : 차상영
*@LastVersion : 1.0
* 2015.02.13 차상영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event;

import java.util.Arrays;
import java.util.List;

import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondCalOffhireInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffInvDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalOffhireInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireExpensesListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/** 
 * ESM_FMS_0090 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_FMS_0090HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author JUNGYOONTAE
 * @see ESM_FMS_0090HTMLAction 참조
 * @since J2EE 1.5
 */

public class EsmFms0090Event extends EventSupport {

	public EsmFms0090Event(){}
	
	private static final long serialVersionUID = 1L;	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchOffhireExpensesListVO searchOffhireExpensesListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchOffhireExpensesListVO[] searchOffhireExpensesListVOs = null;

	public SearchOffhireExpensesListVO getSearchOffhireExpensesListVO() {
		return searchOffhireExpensesListVO;
	}

	public void setSearchOffhireExpensesListVO(
			SearchOffhireExpensesListVO searchOffhireExpensesListVO) {
		this.searchOffhireExpensesListVO = searchOffhireExpensesListVO;
	}

	public SearchOffhireExpensesListVO[] getSearchOffhireExpensesListVOs() {
		SearchOffhireExpensesListVO[] rtnVOs = null;
		if (this.searchOffhireExpensesListVOs != null) {
			rtnVOs = Arrays.copyOf(searchOffhireExpensesListVOs, searchOffhireExpensesListVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchOffhireExpensesListVOs(
			SearchOffhireExpensesListVO[] searchOffhireExpensesListVOs) {
		if (searchOffhireExpensesListVOs != null) {
			SearchOffhireExpensesListVO[] tmpVOs = Arrays.copyOf(searchOffhireExpensesListVOs, searchOffhireExpensesListVOs.length);
			this.searchOffhireExpensesListVOs = tmpVOs;
		}
	}

}
