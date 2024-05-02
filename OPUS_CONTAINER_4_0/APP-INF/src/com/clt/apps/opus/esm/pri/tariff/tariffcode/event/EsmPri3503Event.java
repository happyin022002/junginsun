/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EsmPri3503Event.java
*@FileTitle : Tariff Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.25
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2010.10.12 서미진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.tariffcode.event;

import com.clt.apps.opus.esm.pri.tariff.tariffcode.vo.SearchTariffCodeALLVO;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_3503 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_PRI_3503HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SEO	MIJIN
 * @see ESM_PRI_3503HTMLAction 참조
 * @since J2EE 1.6
 */

public class EsmPri3503Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	

	public EsmPri3503Event(){}
	
	private SearchTariffCodeALLVO searchTariffCodeALLVO = null;


	public SearchTariffCodeALLVO getSearchTariffCodeALLVO() {
		return searchTariffCodeALLVO;
	}

	public void setSearchTariffCodeALLVO(SearchTariffCodeALLVO searchTariffCodeALLVO) {
		this.searchTariffCodeALLVO = searchTariffCodeALLVO;
	}

	

}