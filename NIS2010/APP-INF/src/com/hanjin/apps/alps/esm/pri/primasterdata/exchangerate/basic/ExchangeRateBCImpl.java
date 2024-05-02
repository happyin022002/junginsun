/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExchangeRateBCImpl.java
*@FileTitle : Exchange Rate Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : 김재연
*@LastVersion : 1.0
* 2009.09.24 김재연
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.primasterdata.exchangerate.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.pri.primasterdata.exchangerate.integration.ExchangeRateDBDAO;
import com.hanjin.apps.alps.esm.pri.primasterdata.exchangerate.vo.CstGlMonXchRtVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.exchangerate.vo.RsltGlMonXchRtVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-PRIMasterData Business Logic Command Interface<br>
 * - ALPS-PRIMasterData에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author JaeYeon Kim
 * @see Esm_pri_4024EventResponse 참조
 * @since J2EE 1.6
 */
public class ExchangeRateBCImpl extends BasicCommandSupport implements ExchangeRateBC {

	// Database Access Object
	private transient ExchangeRateDBDAO dbDao = null;

	/**
	 * ExchangeRateBCImpl 객체 생성<br>
	 * ExchangeRateDBDAO를 생성한다.<br>
	 */
	public ExchangeRateBCImpl() {
		dbDao = new ExchangeRateDBDAO();
	}
	/**
	 * Exchange Rate를 조회합니다.<br>
	 * 
	 * @param CstGlMonXchRtVO cstGlMonXchRtVO
	 * @return List<RsltGlMonXchRtVO>
	 * @exception EventException
	 */
	public List<RsltGlMonXchRtVO> searchExchangeRateList(CstGlMonXchRtVO cstGlMonXchRtVO) throws EventException {
		try {
			return dbDao.searchExchangeRateList(cstGlMonXchRtVO);
		} catch(DAOException ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[]{}).getMessage(), ex);
		}
		
	}
	
}