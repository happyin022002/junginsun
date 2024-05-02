/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0044Event.java
*@FileTitle : Receivable Invoice - Container List
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.09.09 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.event;

import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.ReceivableInvoiceCostVO;
import com.hanjin.apps.alps.ees.lse.containerrentalcost.receivablerentalcost.vo.SearchParamVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * UI_LSE_0044 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0044HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Jun-Woo
 * @see EES_LSE_0044HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0044Event extends EventSupport {
	/*
	 * 객체직렬화 버젼 UID
	 */
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchParamVO searchParamVO = null;	
	
	/** Table Value Object Multi Data 처리 */
	public ReceivableInvoiceCostVO[] receivableInvoiceCostVOs = null;
	
	/**
	 * Default Constructor.
	 */
	public EesLse0044Event(){}
	
	/**
	 * 단건처리 DataModel를 설정한다.
	 * @param searchParamVO
	 */
	public void setSearchParamVO(SearchParamVO searchParamVO){
		this.searchParamVO = searchParamVO;
	}
	
	public void setReceivableInvoiceCostVOs(ReceivableInvoiceCostVO[] receivableInvoiceCostVOs) {
		this.receivableInvoiceCostVOs = receivableInvoiceCostVOs; 
	}
		
	/**
	 * 단건처리 DataModel를 반환한다.
	 * @return PlanSearchVO
	 */
	public SearchParamVO getSearchParamVO(){
		return searchParamVO;
	}
	
	public ReceivableInvoiceCostVO[] getReceivableInvoiceCostVOs() {
		return receivableInvoiceCostVOs;
	}
}