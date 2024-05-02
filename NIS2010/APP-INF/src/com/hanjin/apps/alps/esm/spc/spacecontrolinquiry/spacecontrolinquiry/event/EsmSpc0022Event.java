/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EsmSpc0022Event.java
*@FileTitle : spacecontrolinquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.10.06 한상훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryConditionVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryCustomerListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryTradeListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryContractorVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquirySalesOrgListVO;
import com.hanjin.apps.alps.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo.SearchSpaceControlInquiryPolPodListVO;


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
		this. searchSpaceControlInquiryCustomerListVO = searchSpaceControlInquiryCustomerListVO;
	}

	public void setSearchSpaceControlInquiryCustomerListVOS(SearchSpaceControlInquiryCustomerListVO[] searchSpaceControlInquiryCustomerListVOs){
		if (searchSpaceControlInquiryCustomerListVOs != null) {
			SearchSpaceControlInquiryCustomerListVO[] tmpVOs = new SearchSpaceControlInquiryCustomerListVO[searchSpaceControlInquiryCustomerListVOs.length];
			System.arraycopy(searchSpaceControlInquiryCustomerListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchSpaceControlInquiryCustomerListVOs = tmpVOs;
		}
	}

	public void setSearchSpaceControlInquiryTradeListVO(SearchSpaceControlInquiryTradeListVO searchSpaceControlInquiryTradeListVO){
		this. searchSpaceControlInquiryTradeListVO = searchSpaceControlInquiryTradeListVO;
	}

	public void setSearchSpaceControlInquiryTradeListVOS(SearchSpaceControlInquiryTradeListVO[] searchSpaceControlInquiryTradeListVOs){
		if (searchSpaceControlInquiryTradeListVOs != null) {
			SearchSpaceControlInquiryTradeListVO[] tmpVOs = new SearchSpaceControlInquiryTradeListVO[searchSpaceControlInquiryTradeListVOs.length];
			System.arraycopy(searchSpaceControlInquiryTradeListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchSpaceControlInquiryTradeListVOs = tmpVOs;
		}
	}

	public void setSearchSpaceControlInquiryContractorVO(SearchSpaceControlInquiryContractorVO searchSpaceControlInquiryContractorVO){
		this. searchSpaceControlInquiryContractorVO = searchSpaceControlInquiryContractorVO;
	}

	public void setSearchSpaceControlInquiryContractorVOS(SearchSpaceControlInquiryContractorVO[] searchSpaceControlInquiryContractorVOs){
		if (searchSpaceControlInquiryContractorVOs != null) {
			SearchSpaceControlInquiryContractorVO[] tmpVOs = new SearchSpaceControlInquiryContractorVO[searchSpaceControlInquiryContractorVOs.length];
			System.arraycopy(searchSpaceControlInquiryContractorVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchSpaceControlInquiryContractorVOs = tmpVOs;
		}
	}

	public void setSearchSpaceControlInquirySalesOrgListVO(SearchSpaceControlInquirySalesOrgListVO searchSpaceControlInquirySalesOrgListVO){
		this. searchSpaceControlInquirySalesOrgListVO = searchSpaceControlInquirySalesOrgListVO;
	}

	public void setSearchSpaceControlInquirySalesOrgListVOS(SearchSpaceControlInquirySalesOrgListVO[] searchSpaceControlInquirySalesOrgListVOs){
		if (searchSpaceControlInquirySalesOrgListVOs != null) {
			SearchSpaceControlInquirySalesOrgListVO[] tmpVOs = new SearchSpaceControlInquirySalesOrgListVO[searchSpaceControlInquirySalesOrgListVOs.length];
			System.arraycopy(searchSpaceControlInquirySalesOrgListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchSpaceControlInquirySalesOrgListVOs = tmpVOs;
		}
	}

	public void setSearchSpaceControlInquiryPolPodListVO(SearchSpaceControlInquiryPolPodListVO searchSpaceControlInquiryPolPodListVO){
		this. searchSpaceControlInquiryPolPodListVO = searchSpaceControlInquiryPolPodListVO;
	}

	public void setSearchSpaceControlInquiryPolPodListVOS(SearchSpaceControlInquiryPolPodListVO[] searchSpaceControlInquiryPolPodListVOs){
		if (searchSpaceControlInquiryPolPodListVOs != null) {
			SearchSpaceControlInquiryPolPodListVO[] tmpVOs = new SearchSpaceControlInquiryPolPodListVO[searchSpaceControlInquiryPolPodListVOs.length];
			System.arraycopy(searchSpaceControlInquiryPolPodListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchSpaceControlInquiryPolPodListVOs = tmpVOs;
		}
	}

	public SearchSpaceControlInquiryCustomerListVO getSearchSpaceControlInquiryCustomerListVO(){
		return searchSpaceControlInquiryCustomerListVO;
	}

	public SearchSpaceControlInquiryCustomerListVO[] getSearchSpaceControlInquiryCustomerListVOS(){
		SearchSpaceControlInquiryCustomerListVO[] rtnVOs = null;
		if (this.searchSpaceControlInquiryCustomerListVOs != null) {
			rtnVOs = new SearchSpaceControlInquiryCustomerListVO[searchSpaceControlInquiryCustomerListVOs.length];
			System.arraycopy(searchSpaceControlInquiryCustomerListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public SearchSpaceControlInquiryTradeListVO getSearchSpaceControlInquiryTradeListVO(){
		return searchSpaceControlInquiryTradeListVO;
	}

	public SearchSpaceControlInquiryTradeListVO[] getSearchSpaceControlInquiryTradeListVOS(){
		SearchSpaceControlInquiryTradeListVO[] rtnVOs = null;
		if (this.searchSpaceControlInquiryTradeListVOs != null) {
			rtnVOs = new SearchSpaceControlInquiryTradeListVO[searchSpaceControlInquiryTradeListVOs.length];
			System.arraycopy(searchSpaceControlInquiryTradeListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public SearchSpaceControlInquiryContractorVO getSearchSpaceControlInquiryContractorVO(){
		return searchSpaceControlInquiryContractorVO;
	}

	public SearchSpaceControlInquiryContractorVO[] getSearchSpaceControlInquiryContractorVOS(){
		SearchSpaceControlInquiryContractorVO[] rtnVOs = null;
		if (this.searchSpaceControlInquiryContractorVOs != null) {
			rtnVOs = new SearchSpaceControlInquiryContractorVO[searchSpaceControlInquiryContractorVOs.length];
			System.arraycopy(searchSpaceControlInquiryContractorVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public SearchSpaceControlInquirySalesOrgListVO getSearchSpaceControlInquirySalesOrgListVO(){
		return searchSpaceControlInquirySalesOrgListVO;
	}

	public SearchSpaceControlInquirySalesOrgListVO[] getSearchSpaceControlInquirySalesOrgListVOS(){
		SearchSpaceControlInquirySalesOrgListVO[] rtnVOs = null;
		if (this.searchSpaceControlInquirySalesOrgListVOs != null) {
			rtnVOs = new SearchSpaceControlInquirySalesOrgListVO[searchSpaceControlInquirySalesOrgListVOs.length];
			System.arraycopy(searchSpaceControlInquirySalesOrgListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

	public SearchSpaceControlInquiryPolPodListVO getSearchSpaceControlInquiryPolPodListVO(){
		return searchSpaceControlInquiryPolPodListVO;
	}

	public SearchSpaceControlInquiryPolPodListVO[] getSearchSpaceControlInquiryPolPodListVOS(){
		SearchSpaceControlInquiryPolPodListVO[] rtnVOs = null;
		if (this.searchSpaceControlInquiryPolPodListVOs != null) {
			rtnVOs = new SearchSpaceControlInquiryPolPodListVO[searchSpaceControlInquiryPolPodListVOs.length];
			System.arraycopy(searchSpaceControlInquiryPolPodListVOs, 0, rtnVOs, 0, rtnVOs.length);
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