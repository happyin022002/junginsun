/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOSettlementBCImpl.java
*@FileTitle : Owner's Account to Expenses
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.basic;

import java.util.List;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.integration.TCharterIOSettlementDBDAO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.CondSearchPrepaymentSettleVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.CondSearchPrepaymentSettleVvdVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchPrepaymentSettleListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchPrepaymentSettleVvdListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-TimeCharterInOutAccounting Business Logic Basic Command implementation<br>
 * - Handling Business Logic of OPUS-TimeCharterInOutAccounting<br>
 *
 * @author 
 * @see ESM_FMS_0039EventResponse,TCharterIOSettlementBC Reference to each DAO Class
 * @since J2EE 1.6
 */
public class TCharterIOSettlementBCImpl extends BasicCommandSupport implements TCharterIOSettlementBC {

	// Database Access Object
	private transient TCharterIOSettlementDBDAO dbDao = null;

	/**
	 * Generating TCharterIOSettlementBCImpl object<br>
	 * Generating TCharterIOSettlementDBDAO<br>
	 */
	public TCharterIOSettlementBCImpl() {
		dbDao = new TCharterIOSettlementDBDAO();
	}
	
	/**
	 * Retrieving unsorted Prepayment Slip<br>
	 * 
	 * @param condSearchPrepaymentSettleVO CondSearchPrepaymentSettleVO
	 * @param account SignOnUserAccount
	 * @return List<SearchPrepaymentSettleListVO>
	 * @throws EventException
	 */
	public List<SearchPrepaymentSettleListVO> searchPrepaymentSettleList(CondSearchPrepaymentSettleVO condSearchPrepaymentSettleVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchPrepaymentSettleList(condSearchPrepaymentSettleVO, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01501",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("FMS01501",new String[]{}).getMessage(), ex);
		}
	}
	/**
	 * Separating unsorted Prepayment Slip by Voyage<br>
	 * 
	 * @param condSearchPrepaymentSettleVvdVO CondSearchPrepaymentSettleVvdVO
	 * @return List<SearchPrepaymentSettleVvdListVO>
	 * @exception EventException
	 */
	public List<SearchPrepaymentSettleVvdListVO> searchPrepaymentSettleVvdList(CondSearchPrepaymentSettleVvdVO condSearchPrepaymentSettleVvdVO) throws EventException {
		try {
			return dbDao.searchPrepaymentSettleVvdList(condSearchPrepaymentSettleVvdVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("FMS01502",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("FMS01502",new String[]{}).getMessage(), ex);
		}
	}
	
}