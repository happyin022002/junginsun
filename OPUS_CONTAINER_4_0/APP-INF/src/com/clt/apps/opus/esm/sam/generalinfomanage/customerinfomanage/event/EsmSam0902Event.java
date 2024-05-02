/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmSam0902Event.java
*@FileTitle : Customer Group Code Assignment
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.09
*@LastModifier : SHKIM
*@LastVersion : 1.0
* 2012.02.09 SHKIM
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchCustomerVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_SAM_0902 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAM_0902HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SHKIM
 * @see ESM_SAM_0902HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSam0902Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCustomerVO searchCustomerVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchCustomerVO[] searchCustomerVOs = null;

	public EsmSam0902Event(){}
	
	public void setSearchCustomerVO(SearchCustomerVO searchCustomerVO){
		this. searchCustomerVO = searchCustomerVO;
	}

	public void setSearchCustomerVOS(SearchCustomerVO[] SearchCustomerVOs){
		if(SearchCustomerVOs != null){
			SearchCustomerVO[] tmpVOs = Arrays.copyOf(SearchCustomerVOs, SearchCustomerVOs.length);
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