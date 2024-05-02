/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : EsmSpc0022Event.java
*@FileTitle      : Inquiry by Trade
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.10.06
*@LastModifier   : 한상훈
*@LastVersion    : 1.0
* 2009.10.06
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import java.util.Arrays;

import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryConditionVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryContractorVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryCustomerListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryPolPodListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquirySalesOrgListVO;
import com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryTradeListVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * ESM_SPC_0022 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_SPC_0022HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Han Sang Hoon
 * @see ESM_SPC_0022HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmSpc0022Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceControlInquiryCustomerListVO searchSpaceControlInquiryCustomerListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceControlInquiryCustomerListVO[] searchSpaceControlInquiryCustomerListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceControlInquiryTradeListVO searchSpaceControlInquiryTradeListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceControlInquiryTradeListVO[] searchSpaceControlInquiryTradeListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceControlInquiryContractorVO searchSpaceControlInquiryContractorVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceControlInquiryContractorVO[] searchSpaceControlInquiryContractorVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceControlInquirySalesOrgListVO searchSpaceControlInquirySalesOrgListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceControlInquirySalesOrgListVO[] searchSpaceControlInquirySalesOrgListVOs = null;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchSpaceControlInquiryPolPodListVO searchSpaceControlInquiryPolPodListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchSpaceControlInquiryPolPodListVO[] searchSpaceControlInquiryPolPodListVOs = null;

	private SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO = null;
	
	public EsmSpc0022Event(){}
	
	public void setSearchSpaceControlInquiryCustomerListVO(SearchSpaceControlInquiryCustomerListVO searchSpaceControlInquiryCustomerListVO){
		this.searchSpaceControlInquiryCustomerListVO = searchSpaceControlInquiryCustomerListVO;
	}

	public void setSearchSpaceControlInquiryCustomerListVOS(SearchSpaceControlInquiryCustomerListVO[] searchSpaceControlInquiryCustomerListVOs){
		if(searchSpaceControlInquiryCustomerListVOs != null){
			SearchSpaceControlInquiryCustomerListVO[] tmpVOs = Arrays.copyOf(searchSpaceControlInquiryCustomerListVOs, searchSpaceControlInquiryCustomerListVOs.length);
			this.searchSpaceControlInquiryCustomerListVOs  = tmpVOs;
		}
	}

	public void setSearchSpaceControlInquiryTradeListVO(SearchSpaceControlInquiryTradeListVO searchSpaceControlInquiryTradeListVO){
		this.searchSpaceControlInquiryTradeListVO = searchSpaceControlInquiryTradeListVO;
	}

	public void setSearchSpaceControlInquiryTradeListVOS(SearchSpaceControlInquiryTradeListVO[] searchSpaceControlInquiryTradeListVOs){
		if(searchSpaceControlInquiryTradeListVOs != null){
			SearchSpaceControlInquiryTradeListVO[] tmpVOs = Arrays.copyOf(searchSpaceControlInquiryTradeListVOs, searchSpaceControlInquiryTradeListVOs.length);
			this.searchSpaceControlInquiryTradeListVOs  = tmpVOs;
		}
	}

	public void setSearchSpaceControlInquiryContractorVO(SearchSpaceControlInquiryContractorVO searchSpaceControlInquiryContractorVO){
		this.searchSpaceControlInquiryContractorVO = searchSpaceControlInquiryContractorVO;
	}

	public void setSearchSpaceControlInquiryContractorVOS(SearchSpaceControlInquiryContractorVO[] searchSpaceControlInquiryContractorVOs){
		if(searchSpaceControlInquiryContractorVOs != null){
			SearchSpaceControlInquiryContractorVO[] tmpVOs = Arrays.copyOf(searchSpaceControlInquiryContractorVOs, searchSpaceControlInquiryContractorVOs.length);
			this.searchSpaceControlInquiryContractorVOs  = tmpVOs;
		}
	}

	public void setSearchSpaceControlInquirySalesOrgListVO(SearchSpaceControlInquirySalesOrgListVO searchSpaceControlInquirySalesOrgListVO){
		this.searchSpaceControlInquirySalesOrgListVO = searchSpaceControlInquirySalesOrgListVO;
	}

	public void setSearchSpaceControlInquirySalesOrgListVOS(SearchSpaceControlInquirySalesOrgListVO[] searchSpaceControlInquirySalesOrgListVOs){
		if(searchSpaceControlInquirySalesOrgListVOs != null){
			SearchSpaceControlInquirySalesOrgListVO[] tmpVOs = Arrays.copyOf(searchSpaceControlInquirySalesOrgListVOs, searchSpaceControlInquirySalesOrgListVOs.length);
			this.searchSpaceControlInquirySalesOrgListVOs  = tmpVOs;
		}
	}

	public void setSearchSpaceControlInquiryPolPodListVO(SearchSpaceControlInquiryPolPodListVO searchSpaceControlInquiryPolPodListVO){
		this.searchSpaceControlInquiryPolPodListVO = searchSpaceControlInquiryPolPodListVO;
	}

	public void setSearchSpaceControlInquiryPolPodListVOS(SearchSpaceControlInquiryPolPodListVO[] searchSpaceControlInquiryPolPodListVOs){
		if(searchSpaceControlInquiryPolPodListVOs != null){
			SearchSpaceControlInquiryPolPodListVO[] tmpVOs = Arrays.copyOf(searchSpaceControlInquiryPolPodListVOs, searchSpaceControlInquiryPolPodListVOs.length);
			this.searchSpaceControlInquiryPolPodListVOs  = tmpVOs;
		}
	}

	public SearchSpaceControlInquiryCustomerListVO getSearchSpaceControlInquiryCustomerListVO(){
		return searchSpaceControlInquiryCustomerListVO;
	}

	public SearchSpaceControlInquiryCustomerListVO[] getSearchSpaceControlInquiryCustomerListVOS(){
		SearchSpaceControlInquiryCustomerListVO[] rtnVOs = null;
		if (this.searchSpaceControlInquiryCustomerListVOs != null) {
			rtnVOs = Arrays.copyOf(searchSpaceControlInquiryCustomerListVOs, searchSpaceControlInquiryCustomerListVOs.length);
		}
		return rtnVOs;
	}

	public SearchSpaceControlInquiryTradeListVO getSearchSpaceControlInquiryTradeListVO(){
		return searchSpaceControlInquiryTradeListVO;
	}

	public SearchSpaceControlInquiryTradeListVO[] getSearchSpaceControlInquiryTradeListVOS(){
		SearchSpaceControlInquiryTradeListVO[] rtnVOs = null;
		if (this.searchSpaceControlInquiryTradeListVOs != null) {
			rtnVOs = Arrays.copyOf(searchSpaceControlInquiryTradeListVOs, searchSpaceControlInquiryTradeListVOs.length);
		}
		return rtnVOs;
	}

	public SearchSpaceControlInquiryContractorVO getSearchSpaceControlInquiryContractorVO(){
		return searchSpaceControlInquiryContractorVO;
	}

	public SearchSpaceControlInquiryContractorVO[] getSearchSpaceControlInquiryContractorVOS(){
		SearchSpaceControlInquiryContractorVO[] rtnVOs = null;
		if (this.searchSpaceControlInquiryContractorVOs != null) {
			rtnVOs = Arrays.copyOf(searchSpaceControlInquiryContractorVOs, searchSpaceControlInquiryContractorVOs.length);
		}
		return rtnVOs;
	}

	public SearchSpaceControlInquirySalesOrgListVO getSearchSpaceControlInquirySalesOrgListVO(){
		return searchSpaceControlInquirySalesOrgListVO;
	}

	public SearchSpaceControlInquirySalesOrgListVO[] getSearchSpaceControlInquirySalesOrgListVOS(){
		SearchSpaceControlInquirySalesOrgListVO[] rtnVOs = null;
		if (this.searchSpaceControlInquirySalesOrgListVOs != null) {
			rtnVOs = Arrays.copyOf(searchSpaceControlInquirySalesOrgListVOs, searchSpaceControlInquirySalesOrgListVOs.length);
		}
		return rtnVOs;
	}

	public SearchSpaceControlInquiryPolPodListVO getSearchSpaceControlInquiryPolPodListVO(){
		return searchSpaceControlInquiryPolPodListVO;
	}

	public SearchSpaceControlInquiryPolPodListVO[] getSearchSpaceControlInquiryPolPodListVOS(){
		SearchSpaceControlInquiryPolPodListVO[] rtnVOs = null;
		if (this.searchSpaceControlInquiryPolPodListVOs != null) {
			rtnVOs = Arrays.copyOf(searchSpaceControlInquiryPolPodListVOs, searchSpaceControlInquiryPolPodListVOs.length);
		}
		return rtnVOs;
	}

	public SearchSpaceControlInquiryConditionVO getSearchSpaceControlInquiryConditionVO() {
		return searchSpaceControlInquiryConditionVO;
	}

	public void setSearchSpaceControlInquiryConditionVO(SearchSpaceControlInquiryConditionVO searchSpaceControlInquiryConditionVO) {
		this.searchSpaceControlInquiryConditionVO = searchSpaceControlInquiryConditionVO;
	}

}