/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpensePlanBCImpl.java
*@FileTitle : Lease Expense-CNTR/CHSS
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2009.06.24 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.integration.ExpensePlanDBDAO;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.vo.ExpensePlanPerformanceVO;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.vo.ExpensePlanVO;
import com.hanjin.apps.alps.ees.lse.containercostanalysis.expenseplan.vo.SearchParamVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-ContainerCostAnalysis Business Logic Basic Command implementation<br>
 * - ALPS-ContainerCostAnalysis에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Jang Jun-Woo
 * @see EES_LSE_0033EventResponse,ExpensePlanBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ExpensePlanBCImpl extends BasicCommandSupport implements ExpensePlanBC {

	// Database Access Object
	private transient ExpensePlanDBDAO dbDao = null;

	/**
	 * ExpensePlanBCImpl 객체 생성<br>
	 * ExpensePlanDBDAO를 생성한다.<br>
	 */
	public ExpensePlanBCImpl() {
		dbDao = new ExpensePlanDBDAO();
	}

	/**
	 * CNTR/CHSS에 대한 년간 사업계획 목록을 조회합니다.<br>
	 *
	 * @param  String plnYr
	 * @param  String verSeq
	 * @param  String cmdType
	 * @return List<ExpensePlanVO>
	 * @exception EventException
	 */
	public List<ExpensePlanVO> searchLeaseExpensePlanListBasic(String plnYr, String verSeq, String cmdType) throws EventException {
		List<ExpensePlanVO> resultVOs = null;

		try {
			resultVOs = dbDao.searchLeaseExpensePlanListData(plnYr, verSeq, cmdType);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"LeaseExpensePlanList Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"LeaseExpensePlanList Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

	/**
	 * 년간/월간 장비임차 형태별 임차료 실적자료를 일괄 저장합니다.<br>
	 *
	 * @param ExpensePlanVO[] expensePlanVOs
	 * @param SignOnUserAccount userAccount
	 * @exception EventException
	 */
	public void manageLeaseExpensePlanListBasic(ExpensePlanVO[] expensePlanVOs, SignOnUserAccount userAccount) throws EventException {
		try {
			List<ExpensePlanVO> insertVoList = new ArrayList<ExpensePlanVO>();

			int verSeq = dbDao.searchLeaseExpenseVersionSeqData(expensePlanVOs[0].getPlnYr());

			for(int i = 0; i < expensePlanVOs.length; i++ ) {
				expensePlanVOs[i].setCreUsrId(userAccount.getUsr_id());
				expensePlanVOs[i].setUpdUsrId(userAccount.getUsr_id());

				if(expensePlanVOs[i].getIbflag().equals("I")) {
					expensePlanVOs[i].setVerSeq(Integer.toString(verSeq));
					insertVoList.add(expensePlanVOs[i]);
				} else if(expensePlanVOs[i].getIbflag().equals("U")) {
					insertVoList.add(expensePlanVOs[i]);
				}
			}

			if(insertVoList.size() > 0) {
				dbDao.addLeaseExpensePlanListData(insertVoList);
			}
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"LeaseExpensePlanList Manage"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"LeaseExpensePlanList Manage"}).getMessage(),ex);
		}
	}

	/**
	 * 년간/월별 장비임차 형태별 임차료 실적목록을 조회합니다.<br>
	 *
	 * @param  SearchParamVO searchParamVO
	 * @return List<ExpensePlanPerformanceVO>
	 * @exception EventException
	 */
	public List<ExpensePlanPerformanceVO> searchExpensePlanPerformanceListBasic(SearchParamVO searchParamVO) throws EventException {
		List<ExpensePlanPerformanceVO> resultVOs = null; // 데이터 전송을 위해 VO 객체

		try {
			resultVOs = dbDao.searchExpensePlanPerformanceListData(searchParamVO);
		} catch(DAOException de) {
			log.error("err " + de.getMessage(), de);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ExpensePlanPerformance Search"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler("LSE10005", new String[]{"ExpensePlanPerformance Search"}).getMessage(),ex);
		}

		return resultVOs;
	}

}