/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ComNtc0002Event.java
*@FileTitle : Contract Creation Users
*Open Issues :
*Change history :
*@LastModifyDate : 2014.02.07	
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2014.02.07 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.agreementnotice.event;

import com.hanjin.bizcommon.agreementnotice.vo.SearchContractCreationUserVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * AgreementNotice 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  COM_NTC_0002HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author CHLOE MIJIN SEO
 * @see COM_NTC_0002HTMLAction 참조
 * @since J2EE 1.6
 */

public class ComNtc0002Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	public ComNtc0002Event(){}
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	SearchContractCreationUserVO searchContractCreationUserVO = null;

	public SearchContractCreationUserVO getSearchContractCreationUserVO() {
		return searchContractCreationUserVO;
	}

	public void setSearchContractCreationUserVO(
			SearchContractCreationUserVO searchContractCreationUserVO) {
		this.searchContractCreationUserVO = searchContractCreationUserVO;
	}
	
}