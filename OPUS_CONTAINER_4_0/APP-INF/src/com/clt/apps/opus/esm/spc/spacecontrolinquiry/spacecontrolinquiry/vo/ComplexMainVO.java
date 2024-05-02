/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ComplexMainVO.java
*@FileTitle : ComplexMainVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 한상훈
*@LastVersion : 1.0
* 2009.08.12 한상훈 
* 1.0 Creation
* 2010.08.25 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 - 2010년 시스템 개발 계획
* 2010.08.26 김민아 [CHM-201005553-01] RDR 실적 중 POL/POD 세부 Data Download 기능 개발
* 2010.11.01 최윤성 [CHM-201006585-01] 2010년 연간개발계획 - full+empty L/F summary 화면 개발
=========================================================*/

package com.clt.apps.opus.esm.spc.spacecontrolinquiry.spacecontrolinquiry.vo;

import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esm.spc.common.common.vo.ConditionVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.syscommon.common.table.SpcTeamQtaRtoVO;
import com.clt.syscommon.common.table.SpcTgtVvdVO;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 한상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ComplexMainVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private String eventCommand = null;
	
	private List<ETCVO> etc = null;
	private List<SearchSpaceControlInquiry021FcastPortViewListVO> inquiry021FcastPortViewListVO = null;
	
	private SearchSpaceControlInquiryConditionVO condition = null;
	
	private DBRowSet rstitle = null;
	private DBRowSet rs = null;
	private DBRowSet rsNoShowSumList = null;
	
	private List<SearchSpaceControlInquiry021AllocPortViewListVO> inquiry021AllocPortViewListVO = null;
	private List<SearchSpaceControlInquiryTradeListVO> searchSpaceControlInquiryTradeListVO = null;
	private List<SearchSpaceControlInquirySalesOrgListVO> searchSpaceControlInquirySalesOrgListVO = null;
	private List<SearchSpaceControlInquiryPolPodListVO> searchSpaceControlInquiryPolPodListVO = null;
	private List<SearchSpaceControlInquiryCustomerListVO> searchSpaceControlInquiryCustomerListVO = null;
	private List<SearchSpaceControlInquiryContractorVO> searchSpaceControlInquiryContractorVO = null;
	private List<SearchSpaceControlInquiryOfficeListVO> searchSpaceControlInquiryOfficeListVO = null;
	private List<SearchSpaceAllocationControlFlagListVO> searchSpaceAllocationControlFlagListVO = null;
	private List<SearchSpaceControlInquiryOfficeSalesOrgListVO> searchSpaceControlInquiryOfficeSalesOrgListVO = null;
	private List<SearchSpaceControlInquiryOfficeCustomerListVO> searchSpaceControlInquiryOfficeCustomerListVO = null;
	private List<SearchSpaceControlInquiryOfficeCustomerListVO> searchSpaceControlInquiryOfficeCustomerList2VO = null;
	private List<SearchSpaceControlTsVolumnListVO> searchSpaceControlTsVolumnListVO = null;
	private List<SearchSpaceControlInquiryListVO> SearchSpaceControlInquiryListVO = null;
	private List<SearchSpaceControlInquiryListVO> SearchSpaceControlInquiryListVOs = null;
	private List<SearchSpaceControlRDRSummaryListVO> searchSpaceControlRDRSummaryListVO = null;
	private List<SearchSpaceControlRDRSummaryListVO> searchSpaceControlRDRSummaryListVOs = null;
	private List<SearchSpaceControlRDRSummaryDownVO> searchSpaceControlRDRSummaryDownVO = null;
	private List<SearchSpaceControlRDRSummaryDownVO> searchSpaceControlRDRSummaryDownVOs = null;
	private List<SearchSpaceControlInquiryRDRDetailListVO> SearchSpaceControlInquiryRDRDetailListVO = null;
	private List<SearchSpaceControlInquiryRDRDetailListVO> SearchSpaceControlInquiryRDRDetailListVOs = null;
	private List<SearchSpaceControlLFSummaryListVO> searchSpaceControlLFSummaryListVO = null;
	private List<SearchSpaceControlLFSummaryListVO> searchSpaceControlLFSummaryListVOs = null;
	private List<SearchSpaceControlLFSummaryDownVO> searchSpaceControlLFSummaryDownVO = null;
	private List<SearchSpaceControlLFSummaryDownVO> searchSpaceControlLFSummaryDownVOs = null;
	private List<SearchWeeklyLfByPolPodListVO> searchWeeklyLfByPolPodListVO = null;
	private List<SearchWeeklyLfByPolPodListVO> searchWeeklyLfByPolPodListVOs = null;
	private List<SearchSpaceControlInquiry021AllocPortViewListVO> searchSpaceControlInquiry021AllocPortViewListVO = null;	// 20120614 SHKIM
	private List<SearchSpaceControlInquiry021AllocPortViewListVO> searchSpaceControlInquiry021AllocPortViewListVOs = null;	// 20120614 SHKIM
	private List<SearchSpaceControlInquiry021PfmcRatioVO> searchSpaceControlInquiry021PfmcRatioVOs = null;
	private List<SearchSpaceControlInquiry021AllocPortViewList5BySRepVO> searchSpaceControlInquiry021AllocPortViewList5BySRepVOs = null;
	private List<SpcTgtVvdVO> spcTgtVvdVOs = null;
	private List<SpcTeamQtaRtoVO> spcTeamQtaRtoVOs = null;
	
	
	
	/**
	 * @return the searchSpaceControlInquiry021PfmcRatioVOs
	 */
	public List<SearchSpaceControlInquiry021PfmcRatioVO> getSearchSpaceControlInquiry021PfmcRatioVOs() {
		return searchSpaceControlInquiry021PfmcRatioVOs;
	}

	/**
	 * @param searchSpaceControlInquiry021PfmcRatioVOs the searchSpaceControlInquiry021PfmcRatioVOs to set
	 */
	public void setSearchSpaceControlInquiry021PfmcRatioVOs(
			List<SearchSpaceControlInquiry021PfmcRatioVO> searchSpaceControlInquiry021PfmcRatioVOs) {
		this.searchSpaceControlInquiry021PfmcRatioVOs = searchSpaceControlInquiry021PfmcRatioVOs;
	}

	public ComplexMainVO() {}
		
	public List<ETCVO> getEtc() {
		return etc;
	}
	public void setEtc(List<ETCVO> etc) {
		this.etc = etc;
	}
	

	public DBRowSet getRsNoShowSumList() {
		return rsNoShowSumList;
	}

	public void setRsNoShowSumList(DBRowSet rsNoShowSumList) {
		this.rsNoShowSumList = rsNoShowSumList;
	}

	public DBRowSet getRstitle() {
		return rstitle;
	}

	public void setRstitle(DBRowSet rstitle) {
		this.rstitle = rstitle;
	}

	public DBRowSet getRs() {
		return rs;
	}

	public void setRs(DBRowSet rs) {
		this.rs = rs;
	}
	public List<SearchSpaceControlInquiry021FcastPortViewListVO> getInquiry021FcastPortViewListVO() {
		return inquiry021FcastPortViewListVO;
	}
	public void setInquiry021FcastPortViewListVO(
			List<SearchSpaceControlInquiry021FcastPortViewListVO> inquiry021FcastPortViewListVO) {
		this.inquiry021FcastPortViewListVO = inquiry021FcastPortViewListVO;
	}

	public String getEventCommand() {
		return eventCommand;
	}

	public void setEventCommand(String eventCommand) {
		this.eventCommand = eventCommand;
	}
	
	
	

	public SearchSpaceControlInquiryConditionVO getCondition() {
		return condition;
	}

	public void setCondition(SearchSpaceControlInquiryConditionVO condition) {
		this.condition = condition;
	}

	public List<SearchSpaceControlInquiry021AllocPortViewListVO> getInquiry021AllocPortViewListVO() {
		return inquiry021AllocPortViewListVO;
	}

	public void setInquiry021AllocPortViewListVO(
			List<SearchSpaceControlInquiry021AllocPortViewListVO> inquiry021AllocPortViewListVO) {
		this.inquiry021AllocPortViewListVO = inquiry021AllocPortViewListVO;
	}


	public List<SearchSpaceControlInquiryTradeListVO> getSearchSpaceControlInquiryTradeListVO() {
		return searchSpaceControlInquiryTradeListVO;
	}

	public void setSearchSpaceControlInquiryTradeListVO(
			List<SearchSpaceControlInquiryTradeListVO> searchSpaceControlInquiryTradeListVO) {
		this.searchSpaceControlInquiryTradeListVO = searchSpaceControlInquiryTradeListVO;
	}

	public List<SearchSpaceControlInquirySalesOrgListVO> getSearchSpaceControlInquirySalesOrgListVO() {
		return searchSpaceControlInquirySalesOrgListVO;
	}

	public void setSearchSpaceControlInquirySalesOrgListVO(
			List<SearchSpaceControlInquirySalesOrgListVO> searchSpaceControlInquirySalesOrgListVO) {
		this.searchSpaceControlInquirySalesOrgListVO = searchSpaceControlInquirySalesOrgListVO;
	}

	public List<SearchSpaceControlInquiryPolPodListVO> getSearchSpaceControlInquiryPolPodListVO() {
		return searchSpaceControlInquiryPolPodListVO;
	}

	public void setSearchSpaceControlInquiryPolPodListVO(
			List<SearchSpaceControlInquiryPolPodListVO> searchSpaceControlInquiryPolPodListVO) {
		this.searchSpaceControlInquiryPolPodListVO = searchSpaceControlInquiryPolPodListVO;
	}

	public List<SearchSpaceControlInquiryCustomerListVO> getSearchSpaceControlInquiryCustomerListVO() {
		return searchSpaceControlInquiryCustomerListVO;
	}

	public void setSearchSpaceControlInquiryCustomerListVO(
			List<SearchSpaceControlInquiryCustomerListVO> searchSpaceControlInquiryCustomerListVO) {
		this.searchSpaceControlInquiryCustomerListVO = searchSpaceControlInquiryCustomerListVO;
	}

	public List<SearchSpaceControlInquiryContractorVO> getSearchSpaceControlInquiryContractorVO() {
		return searchSpaceControlInquiryContractorVO;
	}

	public void setSearchSpaceControlInquiryContractorVO(
			List<SearchSpaceControlInquiryContractorVO> searchSpaceControlInquiryContractorVO) {
		this.searchSpaceControlInquiryContractorVO = searchSpaceControlInquiryContractorVO;
	}

	public List<SearchSpaceControlInquiryOfficeListVO> getSearchSpaceControlInquiryOfficeListVO() {
		return searchSpaceControlInquiryOfficeListVO;
	}

	public void setSearchSpaceControlInquiryOfficeListVO(
			List<SearchSpaceControlInquiryOfficeListVO> searchSpaceControlInquiryOfficeListVO) {
		this.searchSpaceControlInquiryOfficeListVO = searchSpaceControlInquiryOfficeListVO;
	}

	public List<SearchSpaceAllocationControlFlagListVO> getSearchSpaceAllocationControlFlagListVO() {
		return searchSpaceAllocationControlFlagListVO;
	}

	public void setSearchSpaceAllocationControlFlagListVO(
			List<SearchSpaceAllocationControlFlagListVO> searchSpaceAllocationControlFlagListVO) {
		this.searchSpaceAllocationControlFlagListVO = searchSpaceAllocationControlFlagListVO;
	}

	public List<SearchSpaceControlInquiryOfficeSalesOrgListVO> getSearchSpaceControlInquiryOfficeSalesOrgListVO() {
		return searchSpaceControlInquiryOfficeSalesOrgListVO;
	}

	public void setSearchSpaceControlInquiryOfficeSalesOrgListVO(
			List<SearchSpaceControlInquiryOfficeSalesOrgListVO> searchSpaceControlInquiryOfficeSalesOrgListVO) {
		this.searchSpaceControlInquiryOfficeSalesOrgListVO = searchSpaceControlInquiryOfficeSalesOrgListVO;
	}

	public List<SearchSpaceControlInquiryOfficeCustomerListVO> getSearchSpaceControlInquiryOfficeCustomerListVO() {
		return searchSpaceControlInquiryOfficeCustomerListVO;
	}

	public void setSearchSpaceControlInquiryOfficeCustomerListVO(
			List<SearchSpaceControlInquiryOfficeCustomerListVO> searchSpaceControlInquiryOfficeCustomerListVO) {
		this.searchSpaceControlInquiryOfficeCustomerListVO = searchSpaceControlInquiryOfficeCustomerListVO;
	}

	public List<SearchSpaceControlInquiryOfficeCustomerListVO> getSearchSpaceControlInquiryOfficeCustomerList2VO() {
		return searchSpaceControlInquiryOfficeCustomerList2VO;
	}

	public void setSearchSpaceControlInquiryOfficeCustomerList2VO(
			List<SearchSpaceControlInquiryOfficeCustomerListVO> searchSpaceControlInquiryOfficeCustomerList2VO) {
		this.searchSpaceControlInquiryOfficeCustomerList2VO = searchSpaceControlInquiryOfficeCustomerList2VO;
	}

	public List<SearchSpaceControlTsVolumnListVO> getSearchSpaceControlTsVolumnListVO() {
		return searchSpaceControlTsVolumnListVO;
	}

	public void setSearchSpaceControlTsVolumnListVO(
			List<SearchSpaceControlTsVolumnListVO> searchSpaceControlTsVolumnListVO) {
		this.searchSpaceControlTsVolumnListVO = searchSpaceControlTsVolumnListVO;
	}

	public List<SearchSpaceControlInquiryListVO> getSearchSpaceControlInquiryListVO() {
		return SearchSpaceControlInquiryListVO;
	}

	public void setSearchSpaceControlInquiryListVO(
			List<SearchSpaceControlInquiryListVO> searchSpaceControlInquiryListVO) {
		SearchSpaceControlInquiryListVO = searchSpaceControlInquiryListVO;
	}
	
	
	
	public List<SearchSpaceControlInquiryListVO> getSearchSpaceControlInquiryListVOs() {
		return SearchSpaceControlInquiryListVOs;
	}

	public void setSearchSpaceControlInquiryListVOs(
			List<SearchSpaceControlInquiryListVO> searchSpaceControlInquiryListVOs) {
		SearchSpaceControlInquiryListVOs = searchSpaceControlInquiryListVOs;
	}
	
	
	// 2010.08.25 최윤성 [CHM-201005492-01] RDR 실적 Summary 기능 개발 관련 소스 추가
	
	public List<SearchSpaceControlRDRSummaryListVO> getSearchSpaceControlRDRSummaryListVO() {
		return searchSpaceControlRDRSummaryListVO;
	}

	public void setSearchSpaceControlRDRSummaryListVO(
			List<SearchSpaceControlRDRSummaryListVO> searchSpaceControlRDRSummaryListVO) {
		this.searchSpaceControlRDRSummaryListVO = searchSpaceControlRDRSummaryListVO;
	}
	
	public List<SearchSpaceControlRDRSummaryListVO> getSearchSpaceControlRDRSummaryListVOs() {
		return searchSpaceControlRDRSummaryListVOs;
	}

	public void setSearchSpaceControlRDRSummaryListVOs(
			List<SearchSpaceControlRDRSummaryListVO> searchSpaceControlRDRSummaryListVOs) {
		this.searchSpaceControlRDRSummaryListVOs = searchSpaceControlRDRSummaryListVOs;
	}
	
	public List<SearchSpaceControlRDRSummaryDownVO> getSearchSpaceControlRDRSummaryDownVO() {
		return searchSpaceControlRDRSummaryDownVO;
	}

	public void setSearchSpaceControlRDRSummaryDownVO(
			List<SearchSpaceControlRDRSummaryDownVO> searchSpaceControlRDRSummaryDownVO) {
		this.searchSpaceControlRDRSummaryDownVO = searchSpaceControlRDRSummaryDownVO;
	}
	
	public List<SearchSpaceControlRDRSummaryDownVO> getSearchSpaceControlRDRSummaryDownVOs() {
		return searchSpaceControlRDRSummaryDownVOs;
	}

	public void setSearchSpaceControlRDRSummaryDownVOs(
			List<SearchSpaceControlRDRSummaryDownVO> searchSpaceControlRDRSummaryDownVOs) {
		this.searchSpaceControlRDRSummaryDownVOs = searchSpaceControlRDRSummaryDownVOs;
	}
	
	public List<SearchSpaceControlInquiryRDRDetailListVO> getSearchSpaceControlInquiryRDRDetailListVO() {
		return SearchSpaceControlInquiryRDRDetailListVO;
	}

	public void setSearchSpaceControlInquiryRDRDetailListVO(
			List<SearchSpaceControlInquiryRDRDetailListVO> searchSpaceControlInquiryRDRDetailListVO) {
		SearchSpaceControlInquiryRDRDetailListVO = searchSpaceControlInquiryRDRDetailListVO;
	}

	public List<SearchSpaceControlInquiryRDRDetailListVO> getSearchSpaceControlInquiryRDRDetailListVOs() {
		return SearchSpaceControlInquiryRDRDetailListVOs;
	}

	public void setSearchSpaceControlInquiryRDRDetailListVOs(
			List<SearchSpaceControlInquiryRDRDetailListVO> searchSpaceControlInquiryRDRDetailListVOs) {
		SearchSpaceControlInquiryRDRDetailListVOs = searchSpaceControlInquiryRDRDetailListVOs;
	}	
	
	// 2010.11.01 최윤성 [CHM-201006585-01] L/F summary 관련 소스 추가
	
	public List<SearchSpaceControlLFSummaryListVO> getSearchSpaceControlLFSummaryListVO() {
		return searchSpaceControlLFSummaryListVO;
	}

	public void setSearchSpaceControlLFSummaryListVO(
			List<SearchSpaceControlLFSummaryListVO> searchSpaceControlLFSummaryListVO) {
		this.searchSpaceControlLFSummaryListVO = searchSpaceControlLFSummaryListVO;
	}
	
	public List<SearchSpaceControlLFSummaryListVO> getSearchSpaceControlLFSummaryListVOs() {
		return searchSpaceControlLFSummaryListVOs;
	}

	public void setSearchSpaceControlLFSummaryListVOs(
			List<SearchSpaceControlLFSummaryListVO> searchSpaceControlLFSummaryListVOs) {
		this.searchSpaceControlLFSummaryListVOs = searchSpaceControlLFSummaryListVOs;
	}
	
	public List<SearchSpaceControlLFSummaryDownVO> getSearchSpaceControlLFSummaryDownVO() {
		return searchSpaceControlLFSummaryDownVO;
	}

	public void setSearchSpaceControlLFSummaryDownVO(
			List<SearchSpaceControlLFSummaryDownVO> searchSpaceControlLFSummaryDownVO) {
		this.searchSpaceControlLFSummaryDownVO = searchSpaceControlLFSummaryDownVO;
	}
	
	public List<SearchSpaceControlLFSummaryDownVO> getSearchSpaceControlLFSummaryDownVOs() {
		return searchSpaceControlLFSummaryDownVOs;
	}

	public void setSearchSpaceControlLFSummaryDownVOs(
			List<SearchSpaceControlLFSummaryDownVO> searchSpaceControlLFSummaryDownVOs) {
		this.searchSpaceControlLFSummaryDownVOs = searchSpaceControlLFSummaryDownVOs;
	}
	
	
	
	// 2010.11.01 김종준 [CHM-201007116-01] Weekly L/F by POL/POD 관련 소스 추가
	public List<SearchWeeklyLfByPolPodListVO> getSearchWeeklyLfByPolPodListVO() {
		return searchWeeklyLfByPolPodListVO;
	}

	public void setSearchWeeklyLfByPolPodListVO(
			List<SearchWeeklyLfByPolPodListVO> searchWeeklyLfByPolPodListVO) {
		this.searchWeeklyLfByPolPodListVO = searchWeeklyLfByPolPodListVO;
	}
	
	public List<SearchWeeklyLfByPolPodListVO> getSearchWeeklyLfByPolPodListVOs() {
		return searchWeeklyLfByPolPodListVOs;
	}

	public void setSearchWeeklyLfByPolPodListVOs(
			List<SearchWeeklyLfByPolPodListVO> searchWeeklyLfByPolPodListVOs) {
		this.searchWeeklyLfByPolPodListVOs = searchWeeklyLfByPolPodListVOs;
	}
	
	// 20120614 SHKIM S
	public List<SearchSpaceControlInquiry021AllocPortViewListVO> getSearchSpaceControlInquiry021AllocPortViewListVO() {
		return searchSpaceControlInquiry021AllocPortViewListVO;
	}

	public void setSearchSpaceControlInquiry021AllocPortViewListVO(
			List<SearchSpaceControlInquiry021AllocPortViewListVO> searchSpaceControlInquiry021AllocPortViewListVO) {
		this.searchSpaceControlInquiry021AllocPortViewListVO = searchSpaceControlInquiry021AllocPortViewListVO;
	}
	
	public List<SearchSpaceControlInquiry021AllocPortViewListVO> getSearchSpaceControlInquiry021AllocPortViewListVOs() {
		return searchSpaceControlInquiry021AllocPortViewListVOs;
	}

	public void setSearchSpaceControlInquiry021AllocPortViewListVOs(
			List<SearchSpaceControlInquiry021AllocPortViewListVO> searchSpaceControlInquiry021AllocPortViewListVOs) {
		this.searchSpaceControlInquiry021AllocPortViewListVOs = searchSpaceControlInquiry021AllocPortViewListVOs;
	}
	// 20120614 SHKIM E
	
	
	private ConditionVO conditionVO = null;
	
	/**
	 * @return the searchSpaceControlInquiry021AllocPortViewList5BySRepVOs
	 */
	public List<SearchSpaceControlInquiry021AllocPortViewList5BySRepVO> getSearchSpaceControlInquiry021AllocPortViewList5BySRepVOs() {
		return searchSpaceControlInquiry021AllocPortViewList5BySRepVOs;
	}

	/**
	 * @param searchSpaceControlInquiry021AllocPortViewList5BySRepVOs the searchSpaceControlInquiry021AllocPortViewList5BySRepVO to set
	 */
	public void setSearchSpaceControlInquiry021AllocPortViewList5BySRepVOs(
			List<SearchSpaceControlInquiry021AllocPortViewList5BySRepVO> searchSpaceControlInquiry021AllocPortViewList5BySRepVOs) {
		this.searchSpaceControlInquiry021AllocPortViewList5BySRepVOs = searchSpaceControlInquiry021AllocPortViewList5BySRepVOs;
	}

	public void setConditionVO(ConditionVO conditionVO){
		this. conditionVO = conditionVO;
	}
	
	public ConditionVO getConditionVO(){
		return conditionVO;
	}
	
	
	
	// ---------------------------------------------------------------------------------------
	
	/**
	 * @return the spcTgtVvdVOs
	 */
	public List<SpcTgtVvdVO> getSpcTgtVvdVOs() {
		return spcTgtVvdVOs;
	}

	/**
	 * @param spcTgtVvdVOs the spcTgtVvdVOs to set
	 */
	public void setSpcTgtVvdVOs(List<SpcTgtVvdVO> spcTgtVvdVOs) {
		this.spcTgtVvdVOs = spcTgtVvdVOs;
	}
	
	

	/**
	 * @return the spcTeamQtaRtoVOs
	 */
	public List<SpcTeamQtaRtoVO> getSpcTeamQtaRtoVOs() {
		return spcTeamQtaRtoVOs;
	}

	/**
	 * @param spcTeamQtaRtoVOs the spcTeamQtaRtoVOs to set
	 */
	public void setSpcTeamQtaRtoVOs(List<SpcTeamQtaRtoVO> spcTeamQtaRtoVOs) {
		this.spcTeamQtaRtoVOs = spcTeamQtaRtoVOs;
	}

	@Override
	public HashMap<String, String> getColumnValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, String> getFieldNames() {
		// TODO Auto-generated method stub
		return null;
	}

}
