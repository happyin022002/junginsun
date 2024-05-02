/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmSam0004Event.java
*@FileTitle : Customer PFMC Group Detail
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.01
*@LastModifier : 이창원
*@LastVersion : 1.0
* 2011.06.01 이창원
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchCustomerVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_SAM_0004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAM_0004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author NAMKOONGJINHO
 * @see ESM_SAM_0004HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSam0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCustomerVO searchCustomerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchCustomerVO[] searchCustomerVOs = null;

	public EsmSam0004Event(){}
	
	public void setSearchCustomerVO(SearchCustomerVO searchCustomerVO){
		this. searchCustomerVO = searchCustomerVO;
	}

	public void setSearchCustomerVOS(SearchCustomerVO[] searchCustomerVOs){
		if(searchCustomerVOs != null){
			SearchCustomerVO[] tmpVOs = Arrays.copyOf(searchCustomerVOs, searchCustomerVOs.length);
			this.searchCustomerVOs = tmpVOs;
		}
	}

	public SearchCustomerVO getSearchCustomerVO(){
		return searchCustomerVO;
	}

	public SearchCustomerVO[] getSearchCustomerVOS(){
		SearchCustomerVO[] rtnVOs = null;
		if (this.searchCustomerVOs != null) {
			rtnVOs = Arrays.copyOf(searchCustomerVOs, searchCustomerVOs.length);
		}
		return rtnVOs;	
	}
}