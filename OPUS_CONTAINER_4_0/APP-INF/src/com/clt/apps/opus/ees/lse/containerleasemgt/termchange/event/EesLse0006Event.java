/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0006Event.java
*@FileTitle : Term Change Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.03 장준우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt.termchange.event;

import com.clt.apps.opus.ees.lse.containerleasemgt.termchange.vo.SearchParamVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.termchange.vo.TermChangeInquiryVO;
import com.clt.framework.support.layer.event.EventSupport;


/**
 * EES_LSE_0006 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0006HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Jun-Woo
 * @see EES_LSE_0006HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0006Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchParamVO searchParamVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private TermChangeInquiryVO[] termChangeInquiryVOs = null;

	public EesLse0006Event(){}
	
	public void setSearchParamVO(SearchParamVO searchParamVO){
		this. searchParamVO = searchParamVO;
	}

	public void setTermChangeInquiryVOs(TermChangeInquiryVO[] termChangeInquiryVOs){
		if (termChangeInquiryVOs != null) {
			TermChangeInquiryVO[] tmpVOs = new TermChangeInquiryVO[termChangeInquiryVOs.length];
			System.arraycopy(termChangeInquiryVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.termChangeInquiryVOs = tmpVOs;
		}
	}

	public SearchParamVO getSearchParamVO(){
		return searchParamVO;
	}

	public TermChangeInquiryVO[] getTermChangeInquiryVOs(){
		TermChangeInquiryVO[] tmpVOs = null;
		if (this.termChangeInquiryVOs != null) {
			tmpVOs = new TermChangeInquiryVO[termChangeInquiryVOs.length];
			System.arraycopy(termChangeInquiryVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

}