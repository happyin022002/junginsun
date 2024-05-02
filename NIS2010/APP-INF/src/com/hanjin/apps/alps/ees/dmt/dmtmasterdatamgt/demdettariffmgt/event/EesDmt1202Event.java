/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EesDmt1202Event.java
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

import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.BasicTariffVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchBasicTariffNotiListVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinentParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.SearchContinentVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES-DMT-1202 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES-DMT-1202HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author Kim Tae Kyun
 * @see EES-DMT-1202HTMLAction 참조
 * @since J2EE 1.4
 */
public class EesDmt1202Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	/** Param Value Object */
	private SearchContinentParamVO searchContinentParamVO = null;
	
	private SearchBasicTariffNotiListVO[] searchBasicTariffNotiListVOs = null;	

	public SearchContinentParamVO getSearchContinentParamVO() {
		return searchContinentParamVO;
	}

	public void setSearchContinentParamVO(SearchContinentParamVO searchContinentParamVO) {
		this.searchContinentParamVO = searchContinentParamVO;
	}

	public SearchBasicTariffNotiListVO[] getSearchBasicTariffNotiListVOs() {
		return searchBasicTariffNotiListVOs;
	}

	public void setSearchBasicTariffNotiListVOs(
			SearchBasicTariffNotiListVO[] searchBasicTariffNotiListVOs) {
		this.searchBasicTariffNotiListVOs = searchBasicTariffNotiListVOs;
	}

}
