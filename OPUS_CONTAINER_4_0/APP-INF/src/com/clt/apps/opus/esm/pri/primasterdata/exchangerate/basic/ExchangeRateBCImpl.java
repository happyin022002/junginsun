/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExchangeRateBCImpl.java
*@FileTitle : Exchange Rate Inquiry
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0

=========================================================*/
package com.clt.apps.opus.esm.pri.primasterdata.exchangerate.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.primasterdata.exchangerate.integration.ExchangeRateDBDAO;
import com.clt.apps.opus.esm.pri.primasterdata.exchangerate.vo.CstGlMonXchRtVO;
import com.clt.apps.opus.esm.pri.primasterdata.exchangerate.vo.RsltGlMonXchRtVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * PRIMasterData Business Logic Command Interface<br>
 * - Handling a biz logic about PRIMasterData<br>
 *
 * @author 
 * @see Esm_pri_4024EventResponse
 * @since J2EE 1.6
 */
public class ExchangeRateBCImpl extends BasicCommandSupport implements ExchangeRateBC {

	// Database Access Object
	private transient ExchangeRateDBDAO dbDao = null;

	/**
	 * Creating ExchangeRateBCImpl object<br>
	 * Creating ExchangeRateDBDAO <br>
	 */
	public ExchangeRateBCImpl() {
		dbDao = new ExchangeRateDBDAO();
	}
	/**
	 * Retrieving Exchange Rate<br>
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