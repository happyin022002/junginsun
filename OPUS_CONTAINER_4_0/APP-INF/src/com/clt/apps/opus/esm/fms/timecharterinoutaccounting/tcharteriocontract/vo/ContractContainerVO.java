/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContractContainerVO.java
*@FileTitle : Agreement Creation 화면에서 계약정보를 담는 컨테이너 VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.23
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.04.23 정윤태
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo;

import java.util.List;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.event.EsmFms0001Event;

/**
 * HTTP Parser<br>
 * - 각 탭의 정보를 담을 통합 컨테이너 VO<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TimeCharterInOutAccountingSC로 실행요청<br>
 * - TimeCharterInOutAccountingSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author JUNGYOONTAE
 * @see EsmFms0001Event 참조
 * @since J2EE 1.5
 */
public class ContractContainerVO {
	
	private List<SearchHireListVO> searchHireListVOs;
	private List<SearchOtrExpnListVO> searchOtrExpnListVOs;
	private List<SearchPayTermListVO> searchPayTermListVOs;
	private SearchContractVO searchContractVO;             
	private List<SearchCharterPtyFileListVO> searchCharterPtyFileListVOs;
	private List<SearchFileCertificationListVO> searchFileCertificationListVOs;
	private List<SearchIdVslListVO> searchIdVslListVOs;
	private List<SearchOtrExpnSysDateListVO> searchOtrExpnSysDateListVOs;
	private SearchHireSysDateVO searchHireSysDateVO;
	private SearchContractByInvoiceVO searchContractByInvoiceVO;
	private SearchContractByPrepaymentVO searchContractByPrepaymentVO;  
	 
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public ContractContainerVO() {}
	
	public List<SearchHireListVO> getSearchHireListVOs() {
		return searchHireListVOs;
	}
	
	public void setSearchHireListVOs(List<SearchHireListVO> searchHireListVOs) {
		this.searchHireListVOs = searchHireListVOs;
	}
	
	public List<SearchOtrExpnListVO> getSearchOtrExpnListVOs() {
		return searchOtrExpnListVOs;
	}
	
	public void setSearchOtrExpnListVOs(List<SearchOtrExpnListVO> searchOtrExpnListVOs) {
		this.searchOtrExpnListVOs = searchOtrExpnListVOs;
	}
	
	public List<SearchPayTermListVO> getSearchPayTermListVOs() {
		return searchPayTermListVOs;
	}
	
	public void setSearchPayTermListVOs(List<SearchPayTermListVO> searchPayTermListVOs) {
		this.searchPayTermListVOs = searchPayTermListVOs;
	}
	
	public SearchContractVO getSearchContractVO() {
		return searchContractVO;
	}
	
	public void setSearchContractVO(SearchContractVO searchContractVO) {
		this.searchContractVO = searchContractVO;
	}
	
	public List<SearchCharterPtyFileListVO> getSearchCharterPtyFileListVOs() {
		return searchCharterPtyFileListVOs;
	}
	
	public void setSearchCharterPtyFileListVOs(List<SearchCharterPtyFileListVO> searchCharterPtyFileListVOs) {
		this.searchCharterPtyFileListVOs = searchCharterPtyFileListVOs;
	}
	
	public List<SearchFileCertificationListVO> getSearchFileCertificationListVOs() {
		return searchFileCertificationListVOs;
	}
	
	public void setSearchFileCertificationListVOs(List<SearchFileCertificationListVO> searchFileCertificationListVOs) {
		this.searchFileCertificationListVOs = searchFileCertificationListVOs;
	}
	
	public List<SearchIdVslListVO> getSearchIdVslListVOs() {
		return searchIdVslListVOs;
	}
	
	public void setSearchIdVslListVOs(List<SearchIdVslListVO> searchIdVslListVOs) {
		this.searchIdVslListVOs = searchIdVslListVOs;
	}
	
	public List<SearchOtrExpnSysDateListVO> getSearchOtrExpnSysDateListVOs() {
		return searchOtrExpnSysDateListVOs;
	}
	
	public void setSearchOtrExpnSysDateListVOs(List<SearchOtrExpnSysDateListVO> searchOtrExpnSysDateListVOs) {
		this.searchOtrExpnSysDateListVOs = searchOtrExpnSysDateListVOs;
	}
	
	public SearchHireSysDateVO getSearchHireSysDateVO() {
		return searchHireSysDateVO;
	}
	
	public void setSearchHireSysDateVO(SearchHireSysDateVO searchHireSysDateVO) {
		this.searchHireSysDateVO = searchHireSysDateVO;
	}
	
	public SearchContractByInvoiceVO getSearchContractByInvoiceVO() {
		return searchContractByInvoiceVO;
	}
	
	public void setSearchContractByInvoiceVO(SearchContractByInvoiceVO searchContractByInvoiceVO) {
		this.searchContractByInvoiceVO = searchContractByInvoiceVO;
	}
	
	public SearchContractByPrepaymentVO getSearchContractByPrepaymentVO() {
		return searchContractByPrepaymentVO;
	}
	
	public void setSearchContractByPrepaymentVO(SearchContractByPrepaymentVO searchContractByPrepaymentVO) {
		this.searchContractByPrepaymentVO = searchContractByPrepaymentVO;
	}

}
