/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GenExpenseBCImpl.java
*@FileTitle : General Expense
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.23
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2012.02.23 최성민
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.genexpense.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.coa.stdunitcost.genexpense.integration.GenExpenseDBDAO;
import com.clt.apps.opus.esm.coa.stdunitcost.genexpense.vo.SearchGeneralExpenseVO;
import com.clt.apps.opus.esm.coa.stdunitcost.genexpense.vo.SearchGeneralExpenseByVesselVO;
import com.clt.apps.opus.esm.coa.stdunitcost.mtcost.vo.EqRepoCostVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CoaDmdtN3rdPtyVO;

/**
 * OPUS-Stdunitcost Business Logic Command Interface<br>
 * - OPUS-Stdunitcost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CHOI SUGMIN
 * @see 각 DAO 클래스 참조 
 * @since J2EE 1.6
 */
public class GenExpenseBCImpl extends BasicCommandSupport implements GenExpenseBC {

	// Database Access Object
	private transient GenExpenseDBDAO dbDao = null;

	/**
	 * GenExpenseBCImpl 객체 생성<br>
	 * GenExpenseDBDAO를 생성한다.<br>
	 */
	public GenExpenseBCImpl() {
		dbDao = new GenExpenseDBDAO();
	}
	/**
	 * [일반관리비]을 [조회] 합니다.<br>
	 * 
	 * @param CoaDmdtN3rdPtyVO coaDmdtN3rdPtyVO
	 * @return List<SearchGeneralExpenseVO>
	 * @exception EventException
	 */
	public List<SearchGeneralExpenseVO> searchGeneralExpenseList(CoaDmdtN3rdPtyVO coaDmdtN3rdPtyVO) throws EventException {
		try {
			coaDmdtN3rdPtyVO.setCostYrmon(coaDmdtN3rdPtyVO.getCostYrmon().replaceAll("-", ""));
			return dbDao.searchGeneralExpenseList(coaDmdtN3rdPtyVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * [일반관리비]을 [저장] 합니다.<br>
	 * 
	 * @param CoaDmdtN3rdPtyVO[] coaDmdtN3rdPtyVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiGeneralExpense(CoaDmdtN3rdPtyVO[] coaDmdtN3rdPtyVO, SignOnUserAccount account) throws EventException{
		try {
			List<CoaDmdtN3rdPtyVO> updateVoList = new ArrayList<CoaDmdtN3rdPtyVO>();
			for ( int i=0; i<coaDmdtN3rdPtyVO .length; i++ ) {
				if ( coaDmdtN3rdPtyVO[i].getIbflag().equals("U")){
					coaDmdtN3rdPtyVO[i].setCostYrmon(coaDmdtN3rdPtyVO[i].getCostYrmon().replaceAll("-", ""));
					coaDmdtN3rdPtyVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(coaDmdtN3rdPtyVO[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiGeneralExpenseS(updateVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * [VSL별 General Expense]을 [조회] 합니다.<br>
	 * 
	 * @param CoaDmdtN3rdPtyVO	coaDmdtN3rdPtyVO
	 * @return List<SearchOwnDailyHireVO>
	 * @exception EventException
	 */
	public List<SearchGeneralExpenseByVesselVO> searchGeneralExpenseByVessel(CoaDmdtN3rdPtyVO coaDmdtN3rdPtyVO) throws EventException {
		try {
			coaDmdtN3rdPtyVO.setCostYrmon(coaDmdtN3rdPtyVO.getCostYrmon().replaceAll("-", ""));
			return dbDao.searchGeneralExpenseByVessel(coaDmdtN3rdPtyVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}

	/**
	 * [VSL Class별 평균 General Expense]을 [조회] 합니다.<br>
	 * 
	 * @param CoaDmdtN3rdPtyVO	coaDmdtN3rdPtyVO
	 * @return List<SearchOwnDailyHireVO>
	 * @exception EventException
	 */
	public List<SearchGeneralExpenseByVesselVO> searchGeneralExpenseByVesselClass(CoaDmdtN3rdPtyVO coaDmdtN3rdPtyVO) throws EventException {
		try {
			coaDmdtN3rdPtyVO.setCostYrmon(coaDmdtN3rdPtyVO.getCostYrmon().replaceAll("-", ""));
			return dbDao.searchGeneralExpenseByVesselClass(coaDmdtN3rdPtyVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	
	/**
	 * [VSL별 GeneralExpense]을 [생성] 합니다.<br>
	 * 
	 * @param CoaDmdtN3rdPtyVO	coaDmdtN3rdPtyVO
	 * @exception EventException
	 */
	public void createGeneralExpenseByVessel(CoaDmdtN3rdPtyVO coaDmdtN3rdPtyVO) throws EventException{
		try {			
			coaDmdtN3rdPtyVO.setCostYrmon(coaDmdtN3rdPtyVO.getCostYrmon().replaceAll("-", ""));
			dbDao.addGeneralExpenseByVessel(coaDmdtN3rdPtyVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * [일반관리비]을 [저장] 합니다.<br>
	 * 
	 * @param CoaDmdtN3rdPtyVO[] coaDmdtN3rdPtyVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 * @author SJH.20141229.ADD
	 */
	public void multiGeneralExpense3(CoaDmdtN3rdPtyVO[] coaDmdtN3rdPtyVO, SignOnUserAccount account) throws EventException{
		try {
			List<CoaDmdtN3rdPtyVO> updateVoList = new ArrayList<CoaDmdtN3rdPtyVO>();
			for ( int i=0; i<coaDmdtN3rdPtyVO .length; i++ ) {
				if ( coaDmdtN3rdPtyVO[i].getIbflag().equals("U")){
					coaDmdtN3rdPtyVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(coaDmdtN3rdPtyVO[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifymultiGeneralExpense3(updateVoList);
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * [일반관리비]을 [저장] 합니다.<br>
	 * 
	 * @param CoaDmdtN3rdPtyVO[] coaDmdtN3rdPtyVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 * @author SJH.20141229.ADD
	 */
	public void multiGeneralExpense4(CoaDmdtN3rdPtyVO[] coaDmdtN3rdPtyVO, SignOnUserAccount account) throws EventException{
		try {
			//SJH.20141229.ADD
			List<CoaDmdtN3rdPtyVO> insertVoList = new ArrayList<CoaDmdtN3rdPtyVO>();
			List<CoaDmdtN3rdPtyVO> updateVoList = new ArrayList<CoaDmdtN3rdPtyVO>();
			List<CoaDmdtN3rdPtyVO> deleteVoList = new ArrayList<CoaDmdtN3rdPtyVO>();
			
			for ( int i=0; i<coaDmdtN3rdPtyVO .length; i++ ) {
				if ( coaDmdtN3rdPtyVO[i].getIbflag().equals("I")){
					coaDmdtN3rdPtyVO[i].setCreUsrId(account.getUsr_id());
					coaDmdtN3rdPtyVO[i].setUpdUsrId(account.getUsr_id());	
					 insertVoList.add(coaDmdtN3rdPtyVO[i]);
				} else if ( coaDmdtN3rdPtyVO[i].getIbflag().equals("U")){
					coaDmdtN3rdPtyVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(coaDmdtN3rdPtyVO[i]);
				} else if ( coaDmdtN3rdPtyVO[i].getIbflag().equals("D")){
					coaDmdtN3rdPtyVO[i].setUpdUsrId(account.getUsr_id());	
					deleteVoList.add(coaDmdtN3rdPtyVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {	
				dbDao.addGeneralExpense4(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyGeneralExpense4(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeGeneralExpense4(deleteVoList);
			}
			
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	

	
}