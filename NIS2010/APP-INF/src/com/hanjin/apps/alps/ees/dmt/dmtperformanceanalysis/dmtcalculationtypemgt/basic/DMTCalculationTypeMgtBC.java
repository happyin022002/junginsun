/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationTypeMgtBC.java
*@FileTitle : Tariff Type Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.05.13 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.basic;

import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.CalculationTypeParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtOfcUsrTrfOptVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtTrfTpVO;

/**
 * NIS2010-Dmtperformanceanalysis Business Logic Command Interface<br>
 * - NIS2010-Dmtperformanceanalysis에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Hwang Hyo Keun
 * @see Ees_dmt_7001EventResponse 참조
 * @since J2EE 1.4
 */

public interface DMTCalculationTypeMgtBC {
	
	
	/**
	 * Tariff Type List 정보를 조회한다.
	 * 
	 * @param DmtTrfTpVO dmtTrfTpVO
	 * @return List<DmtTrfTpVO>
	 * @exception EventException
	 */
	public List<DmtTrfTpVO> searchTariffTypeList(DmtTrfTpVO dmtTrfTpVO) throws EventException;

	/**
	 * Calculation Type List 정보를 조회한다.
	 *  
	 * @param CalculationTypeParmVO calculationTypeParmVO
	 * @return List<CalculationTypeParmVO>
	 * @throws EventException
	 */
	public List<CalculationTypeParmVO> searchCalculationTypeList(CalculationTypeParmVO calculationTypeParmVO) throws EventException;

	/**
	 * Tariff Type Setup 정보를 수정한다.
	 * 
	 * @param DmtOfcUsrTrfOptVO dmtOfcUsrTrfOptVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyTariffTypeSetup(DmtOfcUsrTrfOptVO dmtOfcUsrTrfOptVO, SignOnUserAccount account) throws EventException;
}