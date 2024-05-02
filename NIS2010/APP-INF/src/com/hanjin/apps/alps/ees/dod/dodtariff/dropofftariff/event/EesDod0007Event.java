/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EesDod0007Event.java
*@FileTitle : Invoice Creation & Correction
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.02
*@LastModifier : 신영재
*@LastVersion : 1.0
* 2015.11.02 신영재
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.event;

import java.util.Arrays;

import com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.vo.SearchDodTariffListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_DOD_0007 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - EES_DOD_0007HTMLAction에서 작성<br>
 * - ServiceCommand Layer 로 전달하는 PDTO로 사용<br>
 * 
 * @author Youngje Shin
 * @see EES_DOD_0007HTMLAction 참조
 * @since J2EE 1.6
 *
 */



public class EesDod0007Event extends EventSupport{
	
	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchDodTariffListVO searchDodTariffListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchDodTariffListVO[] searchDodTariffListVOs = null;
	
	private String sTrfDivCd = null;
	
	public EesDod0007Event(){}
	
	
	public void setSearchDodTariffListVO(SearchDodTariffListVO searchDodTariffListVO){
		this.searchDodTariffListVO = searchDodTariffListVO;
	}
	
	public SearchDodTariffListVO getSearchDodTariffListVO(){
		return searchDodTariffListVO;
	}
	
//	public void setSearchDodTariffListVOs(SearchDodTariffListVO[] searchDodTarifffListVOs){
//		if(searchDodTariffListVOs != null){
//			SearchDodTariffListVO[] tmpVOs = new SearchDodTariffListVO[searchDodTariffListVOs.length];
//			System.arraycopy(searchDodTariffListVOs, 0, tmpVOs, 0, tmpVOs.length);
//			this.searchDodTariffListVOs = tmpVOs;
//		}
//	}
	
	public SearchDodTariffListVO[] getSearchDodTariffListVOs(){
		SearchDodTariffListVO[] rtnVOs = null;
		if (this.searchDodTariffListVOs != null) {
			rtnVOs = Arrays.copyOf(searchDodTariffListVOs, searchDodTariffListVOs.length);
		}
		return rtnVOs;
	}

	public void setSearchDodTariffListVOs(SearchDodTariffListVO[] searchDodTariffListVOs){
		if(searchDodTariffListVOs != null){
			SearchDodTariffListVO[] tmpVOs = new SearchDodTariffListVO[searchDodTariffListVOs.length];
			System.arraycopy(searchDodTariffListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchDodTariffListVOs = tmpVOs;
		}
	}

	public String getsTrfDivCd() {
		return sTrfDivCd;
	}


//	public SearchDodTariffListVO[] getSearchDodTariffListVOs() {
//		return searchDodTariffListVOs;
//	}


	public void setsTrfDivCd(String sTrfDivCd) {
		this.sTrfDivCd = sTrfDivCd;
	}
	
	
}
