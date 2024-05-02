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
package com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.vo.SearchParamVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.termchange.vo.TermChangeInquiryVO;


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
	public TermChangeInquiryVO[] termChangeInquiryVOs = null;

	public EesLse0006Event(){}
	
	public void setSearchParamVO(SearchParamVO searchParamVO){
		this. searchParamVO = searchParamVO;
	}

	public void setTermChangeInquiryVOs(TermChangeInquiryVO[] termChangeInquiryVOs){
		this. termChangeInquiryVOs = termChangeInquiryVOs;
	}

	public SearchParamVO getSearchParamVO(){
		return searchParamVO;
	}

	public TermChangeInquiryVO[] getTermChangeInquiryVOs(){
		return termChangeInquiryVOs;
	}

}