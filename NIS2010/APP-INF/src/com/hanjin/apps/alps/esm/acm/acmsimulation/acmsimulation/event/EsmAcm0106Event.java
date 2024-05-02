/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : EsmAcm0106Event.java
*@FileTitle : EsmAcm0106Event
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.09
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.04.09 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.event;

import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.SearchAgreementVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * ESM_ACM_0106 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_ACM_0106HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Sang-Soo
 * @see ESM_ACM_0106HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmAcm0106Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchAgreementVO searchAgreementVO = null;

	public EsmAcm0106Event() {}

	public SearchAgreementVO getSearchAgreementVO() {
		return searchAgreementVO;
	}

	public void setSearchAgreementVO(SearchAgreementVO searchAgreementVO) {
		this.searchAgreementVO = searchAgreementVO;
	}

}