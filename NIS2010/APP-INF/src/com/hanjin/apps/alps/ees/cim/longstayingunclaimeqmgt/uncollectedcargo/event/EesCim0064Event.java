/*=========================================================
 *@FileName : EesCim0064Event.java
 *@FileTitle :  UC Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.07.04 
 *@LastModifier : DO-HYUN KIM
 *@LastVersion : 1.0
 * 1.0 최초 생성
=========================================================*/

package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event;

import java.util.Arrays;

import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.SearchUncollectedInquiryListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
/**
 * EES_CIM_0064 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_CIM_0064HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author DO-HYUN KIM
 * @see HTMLAction 참조
 * @since J2EE 1.5
 */
public class EesCim0064Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	private SearchUncollectedInquiryListVO searchApprovalMgmtVO = null;
	private SearchUncollectedInquiryListVO[] searchApprovalMgmtVOs = null;
	String sUcCsNo = null;
	String sBlNo = null;
	String sCntrNo = null;
	String sCneeUcDtGb = null;
	String sCneeUcDtFr = null;
	String sCneeUcDtTo = null;
	String sUcDysGb = null;
	String sUcDysFr = null;
	String sUcDysTo = null;
	String sUcStsCd = null;
	String sUcRsnCd = null;
	String sHndlRhqCd = null;
	String sKntrRhqCd = null;
	String sUcDispOptCd = null;
	String sPolCd = null;
	String sHndlBrncCd = null;
	String sKntrBrncCd = null;
	String sPodCd = null;
	String sRetrieveGb = null;
	String sByCase = null;

	public SearchUncollectedInquiryListVO getSearchUncollectedInquiryListVO() {
		return searchApprovalMgmtVO;
	}
	public void setSearchUncollectedInquiryListVO(SearchUncollectedInquiryListVO searchApprovalMgmtVO) {
		this.searchApprovalMgmtVO = searchApprovalMgmtVO;
	}
	public SearchUncollectedInquiryListVO[] getSearchUncollectedInquiryListVOs() {
		SearchUncollectedInquiryListVO[] rtnVOs = null;
		if (this.searchApprovalMgmtVOs != null) {
			rtnVOs = Arrays.copyOf(searchApprovalMgmtVOs, searchApprovalMgmtVOs.length);
		}
		return rtnVOs;
	}
	public void setSearchUncollectedInquiryListVOs(
			SearchUncollectedInquiryListVO[] searchApprovalMgmtVOs) {
		if (searchApprovalMgmtVOs != null) {
			SearchUncollectedInquiryListVO[] tmpVOs = Arrays.copyOf(searchApprovalMgmtVOs, searchApprovalMgmtVOs.length);
			this.searchApprovalMgmtVOs = tmpVOs;
		}
	}
	public SearchUncollectedInquiryListVO getSearchApprovalMgmtVO() {
		return searchApprovalMgmtVO;
	}
	public void setSearchApprovalMgmtVO(
			SearchUncollectedInquiryListVO searchApprovalMgmtVO) {
		this.searchApprovalMgmtVO = searchApprovalMgmtVO;
	}
	public SearchUncollectedInquiryListVO[] getSearchApprovalMgmtVOs() {
		SearchUncollectedInquiryListVO[] rtnVOs = null;
		if (this.searchApprovalMgmtVOs != null) {
			rtnVOs = Arrays.copyOf(searchApprovalMgmtVOs, searchApprovalMgmtVOs.length);
		}
		return rtnVOs;
	}
	public void setSearchApprovalMgmtVOs(
			SearchUncollectedInquiryListVO[] searchApprovalMgmtVOs) {
		if (searchApprovalMgmtVOs != null) {
			SearchUncollectedInquiryListVO[] tmpVOs = Arrays.copyOf(searchApprovalMgmtVOs, searchApprovalMgmtVOs.length);
			this.searchApprovalMgmtVOs = tmpVOs;
		}
	}
	public String getsUcCsNo() {
		return sUcCsNo;
	}
	public void setsUcCsNo(String sUcCsNo) {
		this.sUcCsNo = sUcCsNo;
	}
	public String getsBlNo() {
		return sBlNo;
	}
	public void setsBlNo(String sBlNo) {
		this.sBlNo = sBlNo;
	}
	public String getsCntrNo() {
		return sCntrNo;
	}
	public void setsCntrNo(String sCntrNo) {
		this.sCntrNo = sCntrNo;
	}
	public String getsCneeUcDtGb() {
		return sCneeUcDtGb;
	}
	public void setsCneeUcDtGb(String sCneeUcDtGb) {
		this.sCneeUcDtGb = sCneeUcDtGb;
	}
	public String getsCneeUcDtFr() {
		return sCneeUcDtFr;
	}
	public void setsCneeUcDtFr(String sCneeUcDtFr) {
		this.sCneeUcDtFr = sCneeUcDtFr;
	}
	public String getsCneeUcDtTo() {
		return sCneeUcDtTo;
	}
	public void setsCneeUcDtTo(String sCneeUcDtTo) {
		this.sCneeUcDtTo = sCneeUcDtTo;
	}
	public String getsUcDysGb() {
		return sUcDysGb;
	}
	public void setsUcDysGb(String sUcDysGb) {
		this.sUcDysGb = sUcDysGb;
	}
	public String getsUcDysFr() {
		return sUcDysFr;
	}
	public void setsUcDysFr(String sUcDysFr) {
		this.sUcDysFr = sUcDysFr;
	}
	public String getsUcDysTo() {
		return sUcDysTo;
	}
	public void setsUcDysTo(String sUcDysTo) {
		this.sUcDysTo = sUcDysTo;
	}
	public String getsUcStsCd() {
		return sUcStsCd;
	}
	public void setsUcStsCd(String sUcStsCd) {
		this.sUcStsCd = sUcStsCd;
	}
	public String getsUcRsnCd() {
		return sUcRsnCd;
	}
	public void setsUcRsnCd(String sUcRsnCd) {
		this.sUcRsnCd = sUcRsnCd;
	}
	public String getsHndlRhqCd() {
		return sHndlRhqCd;
	}
	public void setsHndlRhqCd(String sHndlRhqCd) {
		this.sHndlRhqCd = sHndlRhqCd;
	}
	public String getsKntrRhqCd() {
		return sKntrRhqCd;
	}
	public void setsKntrRhqCd(String sKntrRhqCd) {
		this.sKntrRhqCd = sKntrRhqCd;
	}
	public String getsUcDispOptCd() {
		return sUcDispOptCd;
	}
	public void setsUcDispOptCd(String sUcDispOptCd) {
		this.sUcDispOptCd = sUcDispOptCd;
	}
	public String getsPolCd() {
		return sPolCd;
	}
	public void setsPolCd(String sPolCd) {
		this.sPolCd = sPolCd;
	}
	public String getsHndlBrncCd() {
		return sHndlBrncCd;
	}
	public void setsHndlBrncCd(String sHndlBrncCd) {
		this.sHndlBrncCd = sHndlBrncCd;
	}
	public String getsKntrBrncCd() {
		return sKntrBrncCd;
	}
	public void setsKntrBrncCd(String sKntrBrncCd) {
		this.sKntrBrncCd = sKntrBrncCd;
	}
	public String getsPodCd() {
		return sPodCd;
	}
	public void setsPodCd(String sPodCd) {
		this.sPodCd = sPodCd;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getsRetrieveGb() {
		return sRetrieveGb;
	}
	public void setsRetrieveGb(String sRetrieveGb) {
		this.sRetrieveGb = sRetrieveGb;
	}
	public String getsByCase() {
		return sByCase;
	}
	public void setsByCase(String sByCase) {
		this.sByCase = sByCase;
	}

	
}
