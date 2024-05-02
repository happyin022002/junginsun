/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCalculationTypeMgtBCImpl.java
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

import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.integration.DMTCalculationTypeMgtDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.CalculationTypeParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtOfcUsrTrfOptVO;
import com.hanjin.apps.alps.ees.dmt.dmtperformanceanalysis.dmtcalculationtypemgt.vo.DmtTrfTpVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-DMTPerformanceAnalysis Business Logic Basic Command implementation<br>
 * - NIS2010-DMTPerformanceAnalysis에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Hwang Hyo Keun
 * @see EES_DMT_7001EventResponse,DMTCalculationTypeMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class DMTCalculationTypeMgtBCImpl extends BasicCommandSupport implements DMTCalculationTypeMgtBC {

	// Database Access Object
	private transient DMTCalculationTypeMgtDBDAO dbDao = null;

	/**
	 * DMTCalculationTypeMgtBCImpl 객체 생성<br>
	 * DMTCalculationTypeMgtDBDAO를 생성한다.<br>
	 */
	public DMTCalculationTypeMgtBCImpl() {
		dbDao = new DMTCalculationTypeMgtDBDAO();
	}
	
	/**
	 * Tariff Type List 정보를 조회한다.
	 * 
	 * @param DmtTrfTpVO dmtTrfTpVO
	 * @return List<DmtTrfTpVO>
	 * @exception EventException
	 */
	public List<DmtTrfTpVO> searchTariffTypeList(DmtTrfTpVO dmtTrfTpVO) throws EventException {
		try {
			return dbDao.searchTariffTypeList(dmtTrfTpVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Calculation Type List 정보를 조회한다.
	 * 
	 * @param CalculationTypeParmVO calculationTypeParmVO
	 * @return List<CalculationTypeParmVO>
	 * @exception EventException
	 */
	public List<CalculationTypeParmVO> searchCalculationTypeList(CalculationTypeParmVO calculationTypeParmVO) throws EventException {
		try {
			return dbDao.searchCalculationTypeList(calculationTypeParmVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * Tariff Type Setup 정보의 존재여부를 조회한 후, 존재시 해당 정보를 수정하고 비존재시 추가한다.
	 * 
	 * @param DmtOfcUsrTrfOptVO dmtOfcUsrTrfOptVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyTariffTypeSetup(DmtOfcUsrTrfOptVO dmtOfcUsrTrfOptVO, SignOnUserAccount account)
			throws EventException {
		try {
			dmtOfcUsrTrfOptVO.setOfcCd(account.getOfc_cd());
			dmtOfcUsrTrfOptVO.setUsrId(account.getUsr_id());
			String isExist = dbDao.searchTariffTypeSetup(dmtOfcUsrTrfOptVO);
			
			if(isExist.equals("N")) {
				dbDao.addTariffTypeSetup(dmtOfcUsrTrfOptVO);
			} else {
				dbDao.modifyTariffTypeSetup(dmtOfcUsrTrfOptVO);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}
	
}