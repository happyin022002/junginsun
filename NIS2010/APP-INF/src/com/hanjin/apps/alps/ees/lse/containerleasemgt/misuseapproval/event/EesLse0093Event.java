/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesLse0093Event.java
*@FileTitle : Mis Use In & Out Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.07.14 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.event;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.MisUseInOutInquiryVO;
import com.hanjin.apps.alps.ees.lse.containerleasemgt.misuseapproval.vo.SearchParamVO;


/**
 * EES_LSE_0093 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_LSE_0093HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Jang Jun-Woo
 * @see EES_LSE_0093HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesLse0093Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchParamVO searchParamVO = null;
	
	/** Table Value Object Multi Data 처리 */
	public MisUseInOutInquiryVO[] misUseInOutInquiryVOs = null;

	public EesLse0093Event(){}
	
	public void setSearchParamVO(SearchParamVO searchParamVO){
		this. searchParamVO = searchParamVO;
	}

	public void setMisUseInOutInquiryVOs(MisUseInOutInquiryVO[] misUseInOutInquiryVOs){
		this. misUseInOutInquiryVOs = misUseInOutInquiryVOs;
	}

	public SearchParamVO getSearchParamVO(){
		return searchParamVO;
	}

	public MisUseInOutInquiryVO[] getMisUseInOutInquiryVOs(){
		return misUseInOutInquiryVOs;
	}
}