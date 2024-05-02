/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : CountryBC.java
 *@FileTitle : Country
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012-05-09
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.country.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.tariff.country.vo.CountryListVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * eNIS-BIZCOMMON Business Logic Command Interface<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author
 * @see ComEns0M1EventResponse 참조
 * @since J2EE 1.4
 */
public interface CountryBC {

	/**
	 * 조회 이벤트 처리<br>
	 * Country화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param CountryListVO countryListVO
	 * @param int iPage
	 * @return List<CountryListVO>
	 * @exception EventException
	 */
	public List<CountryListVO> searchCountryList(CountryListVO countryListVO) throws EventException;

}