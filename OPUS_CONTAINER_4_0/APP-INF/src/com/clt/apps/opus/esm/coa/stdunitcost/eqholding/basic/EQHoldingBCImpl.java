/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EQHoldingBCImpl.java
*@FileTitle : 실적장비비 표준단가 조회, 생성
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2009.08.26 송호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.eqholding.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.eqholding.integration.EQHoldingDBDAO;
import com.clt.apps.opus.esm.coa.stdunitcost.eqholding.vo.EqHoldingCostVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-STDUnitCost Business Logic Command Interface<br>
 * - OPUS-STDUnitCost에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Song Ho Jin
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class EQHoldingBCImpl extends BasicCommandSupport implements EQHoldingBC {

	// Database Access Object
	private transient EQHoldingDBDAO dbDao = null;

	/**
	 * EQHoldingBCImpl 객체 생성<br>
	 * EQHoldingDBDAO를 생성한다.<br>
	 */
	public EQHoldingBCImpl() {
		dbDao = new EQHoldingDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchConditionVO conditionVO
	 * @return List<EqHoldingCostVO>
	 * @exception EventException
	 */
	public List<EqHoldingCostVO> searchEQHoldingCost(SearchConditionVO conditionVO) throws EventException {
		conditionVO.unDataFormat();
		try {
			return dbDao.searchEQHoldingCost(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param EqHoldingCostVO[] eqHoldingCostVO
	 * @param SearchConditionVO conditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiEQHoldingCost(EqHoldingCostVO[] eqHoldingCostVO, SearchConditionVO conditionVO, SignOnUserAccount account) throws EventException{
		try {			
			List<EqHoldingCostVO> updateVoList = new ArrayList<EqHoldingCostVO>();
			List<EqHoldingCostVO> deleteVoList = new ArrayList<EqHoldingCostVO>();
			List<EqHoldingCostVO> insertVoList = new ArrayList<EqHoldingCostVO>();
			for ( int i=0; i<eqHoldingCostVO .length; i++ ) {
				if ( eqHoldingCostVO[i].getIbflag().equals("U")){
					eqHoldingCostVO[i].setUpdUsrId(account.getUsr_id());
					eqHoldingCostVO[i].setCostYrmon(conditionVO.getFCostYrmon().replaceAll("-", ""));
					eqHoldingCostVO[i].setCntrChssDivCd(conditionVO.getFCalcTermCd());
					updateVoList.add(eqHoldingCostVO[i]);
				} else if ( eqHoldingCostVO[i].getIbflag().equals("D")){
					eqHoldingCostVO[i].setCostYrmon(conditionVO.getFCostYrmon().replaceAll("-", ""));
					eqHoldingCostVO[i].setCntrChssDivCd(conditionVO.getFCalcTermCd());
					deleteVoList.add(eqHoldingCostVO[i]);
				} else if ( eqHoldingCostVO[i].getIbflag().equals("I")){
					eqHoldingCostVO[i].setCostYrmon(conditionVO.getFCostYrmon().replaceAll("-", ""));
					eqHoldingCostVO[i].setCntrChssDivCd(conditionVO.getFCalcTermCd());
					eqHoldingCostVO[i].setUpdUsrId(account.getUsr_id());
					eqHoldingCostVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(eqHoldingCostVO[i]);
				}
			}
						
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyEQHoldingCost(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeEQHoldingCost(deleteVoList);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addEQHoldingCost(insertVoList);
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