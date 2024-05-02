/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ComNtc0001Event.java
*@FileTitle : Agreement notice
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.27
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2014.01.27 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.agreementnotice.event;

import com.hanjin.bizcommon.agreementnotice.vo.CodeNameVO;
import com.hanjin.bizcommon.agreementnotice.vo.SearchMailingListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * AgreementNotice 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  COM_NTC_0001HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHLOE MIJIN SEO
 * @see COM_NTC_0001HTMLAction 참조
 * @since J2EE 1.6
 */

public class ComNtc0001Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	CodeNameVO codeNameVO = null;
	/** Table Value Object 조회 조건 및 단건 처리  */
	SearchMailingListVO searchMailingListVO = null;
	/** Table Value Object Multi Data 처리 */
	SearchMailingListVO[] searchMailingListVOs = null;

	public ComNtc0001Event(){}

	public CodeNameVO getCodeNameVO() {
		return codeNameVO;
	}

	public void setCodeNameVO(CodeNameVO codeNameVO) {
		this.codeNameVO = codeNameVO;
	}

	public SearchMailingListVO getSearchMailingListVO() {
		return searchMailingListVO;
	}

	public void setSearchMailingListVO(SearchMailingListVO searchMailingListVO) {
		this.searchMailingListVO = searchMailingListVO;
	}

	public SearchMailingListVO[] getSearchMailingListVOs() {
		return searchMailingListVOs;
	}

	public void setSearchMailingListVOs(SearchMailingListVO[] searchMailingListVOs) {
		this.searchMailingListVOs = searchMailingListVOs;
	}

}