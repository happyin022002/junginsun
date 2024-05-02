/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EsmSam0010Event.java
*@FileTitle : Customer PFMC Group Detail
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

import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchCustomerCodeGroupingVO;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchCustomerVO;
/**
 * ESM_SAM_0010 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SAM_0010HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SHKIM
 * @see ESM_SAM_0010HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSam0010Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public void setSearchCustomerVO(SearchCustomerVO searchCustomerVO){
		this. searchCustomerVO = searchCustomerVO;
	}

	public void setSearchCustomerVOS(SearchCustomerVO[] searchCustomerVOs){
		if(searchCustomerVOs != null){
			SearchCustomerVO[] tmpVOs = Arrays.copyOf(searchCustomerVOs, searchCustomerVOs.length);
			this.searchCustomerVOs = tmpVOs;
		}
	}
	
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchCustomerCodeGroupingVO searchCustomerCodeGroupingVO = null;
	private SearchCustomerVO searchCustomerVO = null;
	/** Table Value Object Multi Data 처리 */
	private SearchCustomerCodeGroupingVO[] searchCustomerCodeGroupingVOs = null;	
	private SearchCustomerVO[] searchCustomerVOs = null;
	
	public EsmSam0010Event(){}
	
	public void setSearchCustomerCodeGroupingVO(SearchCustomerCodeGroupingVO searchCustomerCodeGroupingVO){
		this. searchCustomerCodeGroupingVO = searchCustomerCodeGroupingVO;
	}

	public void setSearchCustomerCodeGroupingVOS(SearchCustomerCodeGroupingVO[] SearchCustomerCodeGroupingVOs){
		if(SearchCustomerCodeGroupingVOs != null){
			SearchCustomerCodeGroupingVO[] tmpVOs = Arrays.copyOf(SearchCustomerCodeGroupingVOs, SearchCustomerCodeGroupingVOs.length);
			this.searchCustomerCodeGroupingVOs = tmpVOs;
		}
	}

	public SearchCustomerCodeGroupingVO getSearchCustomerCodeGroupingVO(){
		return searchCustomerCodeGroupingVO;
	}

	public SearchCustomerCodeGroupingVO[] getSearchCustomerCodeGroupingVOS(){
		SearchCustomerCodeGroupingVO[] rtnVOs = null;
		if (this.searchCustomerCodeGroupingVOs != null) {
			rtnVOs = Arrays.copyOf(searchCustomerCodeGroupingVOs, searchCustomerCodeGroupingVOs.length);
		}
		return rtnVOs;
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