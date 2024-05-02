/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CurrencyBCImpl.java
*@FileTitle : Currency Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.09
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.10.09 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.currency.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.primasterdata.currency.integration.CurrencyDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.MdmCurrencyVO;

/**
 * ALPS-PRIMasterData Business Logic Command Interface<br>
 * - ALPS-PRIMasterData에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author JaeYeon Kim
 * @see Esm_pri_4020EventResponse 참조
 * @since J2EE 1.6
 */
public class CurrencyBCImpl extends BasicCommandSupport implements CurrencyBC {

	// Database Access Object
	private transient CurrencyDBDAO dbDao = null;

	/**
	 * CurrencyBCImpl 객체 생성<br>
	 * CurrencyDBDAO를 생성한다.<br>
	 */
	public CurrencyBCImpl() {
		dbDao = new CurrencyDBDAO();
	}
	/**
	 * Currency List를 조회합니다. <br>
	 * 
	 * @param MdmCurrencyVO mdmCurrencyVO
	 * @return List<MdmCurrencyVO>
	 * @exception EventException
	 */
	public List<MdmCurrencyVO> searchCurrencyList(MdmCurrencyVO mdmCurrencyVO) throws EventException {
		try {
			return dbDao.searchCurrencyList(mdmCurrencyVO);
		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
		
	}
	
}