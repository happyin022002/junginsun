/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrSafetyStockManageBCImpl.java
*@FileTitle : Safty Stock
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.11 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrsafetystockmanage.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrsafetystockmanage.integration.CntrSafetyStockManageDBDAO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrsafetystockmanage.vo.EesEqr0026ConditionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrScnrEccSftStkVO;

/**
 * ALPS-ScenarioManage Business Logic Basic Command implementation<br>
 * - ALPS-ScenarioManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Haeng-ji,Lee
 * @see EES_EQR_0026EventResponse,CntrSafetyStockManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CntrSafetyStockManageBCImpl extends BasicCommandSupport implements CntrSafetyStockManageBC {

	// Database Access Object
	private transient CntrSafetyStockManageDBDAO dbDao = null;

	/**
	 * CntrSafetyStockManageBCImpl 객체 생성<br>
	 * CntrSafetyStockManageDBDAO를 생성한다.<br>
	 */
	public CntrSafetyStockManageBCImpl() {
		dbDao = new CntrSafetyStockManageDBDAO();
	}
	/**
	 * [EES_EQR_0026 : Safty Stock - Search ]<br>
	 * 
	 * @param EesEqr0026ConditionVO eesEqr0026ConditionVO
	 * @return List<SearchCntrSafetyStockVO>
	 * @exception EventException
	 */
	public CommonRsVO searchCntrSafetyStock(EesEqr0026ConditionVO eesEqr0026ConditionVO) throws EventException {
		try {
			return dbDao.searchCntrSafetyStock(eesEqr0026ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [EES_EQR_0026 : Safty Stock - Cheeck SFST_VOL_QTY ]<br>
	 * 
	 * @param EesEqr0026ConditionVO eesEqr0026ConditionVO
	 * @return List<SearchCntrSafetyStockVO>
	 * @exception EventException
	 */
	public CommonRsVO searchCntrSafetyStockQty(EesEqr0026ConditionVO eesEqr0026ConditionVO) throws EventException {
		try {
			return dbDao.searchCntrSafetyStockQty(eesEqr0026ConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [EES_EQR_0026 : Safty Stock - Merge, Delete ]<br>
	 * 
	 * @param EqrScnrEccSftStkVO[] eqrScnrEccSftStkVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiCntrSafetyStock(EqrScnrEccSftStkVO[] eqrScnrEccSftStkVO, SignOnUserAccount account) throws EventException{
		try {
			List<EqrScnrEccSftStkVO> updateVoList = new ArrayList<EqrScnrEccSftStkVO>();
			List<EqrScnrEccSftStkVO> deleteVoList = new ArrayList<EqrScnrEccSftStkVO>();
			for ( int i=0; i<eqrScnrEccSftStkVO .length; i++ ) {
				if ( eqrScnrEccSftStkVO[i].getIbflag().equals("U")){
					eqrScnrEccSftStkVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eqrScnrEccSftStkVO[i]);
				} else if ( eqrScnrEccSftStkVO[i].getIbflag().equals("D")){
					deleteVoList.add(eqrScnrEccSftStkVO[i]);
				}
			}
			
		
			if ( updateVoList.size() > 0 ) {
				dbDao.multiCntrSafetyStock(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeCntrSafetyStock(deleteVoList);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
}