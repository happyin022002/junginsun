/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt4015Event.java
*@FileTitle : Basic Tariff Detail(s) Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.05.20 김태균
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event;

import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinentParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinentVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES-DMT-4015 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES-DMT-4015HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Tae Kyun
 * @see EES-DMT-4015HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesDmt4015Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchContinentVO searchContinentVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchContinentVO[] searchContinentVOs = null;

	/** Param Value Object */
	private SearchContinentParamVO searchContinentParamVO = null;

	public SearchContinentVO getSearchContinentVO() {
		return searchContinentVO;
	}

	public void setSearchContinentVO(SearchContinentVO searchContinentVO) {
		this.searchContinentVO = searchContinentVO;
	}

	public SearchContinentVO[] getSearchContinentVOs() {
		return searchContinentVOs;
	}

	public void setSearchContinentVOs(SearchContinentVO[] searchContinentVOs) {
		this.searchContinentVOs = searchContinentVOs;
	}

	public SearchContinentParamVO getSearchContinentParamVO() {
		return searchContinentParamVO;
	}

	public void setSearchContinentParamVO(SearchContinentParamVO searchContinentParamVO) {
		this.searchContinentParamVO = searchContinentParamVO;
	}

	

}
