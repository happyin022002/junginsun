/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EesDod0005Event.java
*@FileTitle : Tariff Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.02
*@LastModifier : YOON, Yong-Sang
*@LastVersion : 1.0
* 2015.11.02 YOON, Yong-Sang
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.event;

import com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.vo.SearchDodTariffListVO;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * EES_DOD_0005 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  EES_DOD_0005HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author YOON, Yong-Sang
 * @see EES_DOD_0005HTMLAction 참조
 * @since J2EE 1.6
 */

public class EesDod0005Event extends EventSupport {

	private static final long serialVersionUID = 1L;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private SearchDodTariffListVO searchDodTariffListVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private SearchDodTariffListVO[] searchDodTariffListVOs = null;

	public EesDod0005Event(){}
	
	public void setSearchDodTariffListVO(SearchDodTariffListVO searchDodTariffListVO){
		this. searchDodTariffListVO = searchDodTariffListVO;
	}

	public void setSearchDodTariffListVOS(SearchDodTariffListVO[] searchDodTariffListVOs){
		if(searchDodTariffListVOs != null){
			SearchDodTariffListVO[] tmpVOs = new SearchDodTariffListVO[searchDodTariffListVOs.length];
			System.arraycopy(searchDodTariffListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.searchDodTariffListVOs = tmpVOs;
		}
	}

	public SearchDodTariffListVO getSearchDodTariffListVO(){
		return searchDodTariffListVO;
	}

	public SearchDodTariffListVO[] getSearchDodTariffListVOS(){
		SearchDodTariffListVO[] rtnVOs = null;
		if (this.searchDodTariffListVOs != null) {
			rtnVOs = new SearchDodTariffListVO[searchDodTariffListVOs.length];
			System.arraycopy(searchDodTariffListVOs, 0, rtnVOs, 0, rtnVOs.length);
		}
		return rtnVOs;
	}

}