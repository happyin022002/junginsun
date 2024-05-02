/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrTpSzBCImpl.java
*@FileTitle : Currency Code Search
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.04.27 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.lsecommon.currency.basic;

import java.util.List;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.MdmCurrencyVO;
import com.hanjin.apps.alps.ees.lse.lsecommon.currency.integration.CurrencyDBDAO;

/**
 * ALPS-Currency Business Logic Basic Command implementation<br>
 * - ALPS-Currency에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Nho Jung Yong
 * @see CurrencyBC 각 DAO 클래스 참조
 * @since J2EE 1.4
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
	 * Currency 코드목록을 조회합니다.<br>
	 * 
	 * @param String currCd
	 * @return List<MdmCurrencyVO>
	 * @exception EventException
	 */
	public List<MdmCurrencyVO> searchCurrencyListBasic(String currCd) throws EventException {
		List<MdmCurrencyVO> list = null;
		try {
			
			list = dbDao.searchCurrencyListData(currCd);
			
			if ( list.size() < 1 ) {
				throw new EventException(new ErrorHandler("LSE01048").getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			log.error(ex.getMessage());
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return list;
	}
}