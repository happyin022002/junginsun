/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : EsmPri7027Event.java
 *@FileTitle : Country search
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.5.08
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 * 2012.5.08 이은섭
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.country.event;

import com.hanjin.apps.alps.esm.pri.tariff.country.vo.CountryListVO;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_7027 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESM_PRI_7027HTMLAction 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author LEE EUN SUP
 * @see ESM_PRI_7027HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsmPri7027Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	private CountryListVO countryListVO;

	public CountryListVO getCountryListVO() {
		return countryListVO;
	}

	public void setCountryListVO(CountryListVO countryListVO) {
		this.countryListVO = countryListVO;
	}
}
