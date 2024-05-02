/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceContainerVO.java
*@FileTitle : Prepayments 화면에서 Invoice 정보를 담는 컨테이너 VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.06.09 정윤태
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

import java.util.List;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractListByPrepaymentHireNoVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchHireSysDateVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchOtrExpnSysDateListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0012Event;

/**
 * HTTP Parser<br>
 * - 각 탭의 정보를 담을 통합 컨테이너 VO<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TimeCharterInOutAccountingSC로 실행요청<br>
 * - TimeCharterInOutAccountingSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author JUNGYOONTAE
 * @see EsmFms0012Event 참조
 * @since J2EE 1.5
 */
public class InvoiceContainerVO {
	
	private List<SearchContractListByPrepaymentHireNoVO> searchContractListByPrepaymentHireNoVOs;
	private SearchPrepaymentInvoiceVO searchPrepaymentInvoiceVO;  
	private SearchHireSysDateVO searchHireSysDateVO;
	private List<SearchOtrExpnSysDateListVO> searchOtrExpnSysDateListVOs;
	private List<SearchPrepaymentHireNoListVO> searchPrepaymentHireNoListVOs;
	private List<SearchPrepaymentHireNoListSumVO> searchPrepaymentHireNoListSumVOs; 
	
	/**
	 * 생성자
	 * @param
	 * @return 
	 */
	public InvoiceContainerVO() {}
	
	public List<SearchContractListByPrepaymentHireNoVO> getSearchContractListByPrepaymentHireNoVOs() {
		return searchContractListByPrepaymentHireNoVOs;
	}
	
	public List<SearchPrepaymentHireNoListVO> getSearchPrepaymentHireNoListVOs() {
		return searchPrepaymentHireNoListVOs;
	}
	
	public void setSearchContractListByPrepaymentHireNoVOs(List<SearchContractListByPrepaymentHireNoVO> searchContractListByPrepaymentHireNoVOs) {
		this.searchContractListByPrepaymentHireNoVOs = searchContractListByPrepaymentHireNoVOs;
	}
	
	public void setSearchPrepaymentHireNoListVOs(List<SearchPrepaymentHireNoListVO> searchPrepaymentHireNoListVOs) {
		this.searchPrepaymentHireNoListVOs = searchPrepaymentHireNoListVOs;
	}
	
	public SearchPrepaymentInvoiceVO getSearchPrepaymentInvoiceVO() {
		return searchPrepaymentInvoiceVO;
	}
	
	public void setSearchPrepaymentInvoiceVO(SearchPrepaymentInvoiceVO searchPrepaymentInvoiceVO) {
		this.searchPrepaymentInvoiceVO = searchPrepaymentInvoiceVO;
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
	
	public List<SearchPrepaymentHireNoListSumVO> getSearchPrepaymentHireNoListSumVOs() {
		return searchPrepaymentHireNoListSumVOs;
	}
	
	public void setSearchPrepaymentHireNoListSumVOs(List<SearchPrepaymentHireNoListSumVO> searchPrepaymentHireNoListSumVOs) {
		this.searchPrepaymentHireNoListSumVOs = searchPrepaymentHireNoListSumVOs;
	}

}
