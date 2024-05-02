/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : CountryBCImpl.java
 *@FileTitle : Country
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012-05-09
 *@LastModifier : 
 *@LastVersion : 
=========================================================*/
package com.hanjin.apps.alps.esm.pri.tariff.country.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.tariff.country.integration.CountryDBDAO;
import com.hanjin.apps.alps.esm.pri.tariff.country.vo.CountryListVO;
import com.hanjin.apps.alps.esm.pri.tariff.ficcostinterface.integration.FICCostInterfaceDBDAO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * Business Logic Basic Command implementation<br>
 * 비지니스 로직을 처리한다.<br>
 * 
 * @author LEE EUN-SUP
 * @see FICCostInterfaceDBDAO 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CountryBCImpl extends BasicCommandSupport implements CountryBC {

	private transient CountryDBDAO dbDao = null;

	/**
	 * CountryBCImpl 객체를 생성
	 */
	public CountryBCImpl() {
		dbDao = new CountryDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Country화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param CountryListVO countryListVO
	 * @param int iPage
	 * @return List<CountryListVO>
	 * @exception EventException
	 */
	public List<CountryListVO> searchCountryList(CountryListVO countryListVO) throws EventException {
		List<CountryListVO> list = null;
		int cnt = 0;

		try {
			cnt = dbDao.totalCountry(countryListVO);
			list = dbDao.searchCountryList(countryListVO);
			if (list.size() > 0) {
				list.get(0).setMaxRows(cnt);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e2) {
			log.error("err " + e2.toString(), e2);
			throw new EventException(e2.getMessage());
		}
		return list;
	}

	public void doEnd() {
		dbDao = null;
	}
}