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
* 2010.02.05 임옥영 소스품질검토 결과 반영 (클래스주석)
* 2012.08.02 이석준[CHM-201219334-01] EQ Holding Cost 화면 Month Copy 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.eqholding.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.hanjin.apps.alps.esm.coa.stdunitcost.eqholding.integration.EQHoldingDBDAO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.eqholding.vo.EqHoldingCostVO;

/**
 * ALPS-STDUnitCost Business Logic Command Interface<br>
 * - ALPS-STDUnitCost에 대한 비지니스 로직에 대한 인터페이스<br>
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
				}
			}
						
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyEQHoldingCost(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeEQHoldingCost(deleteVoList);
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 생성 이벤트 처리<br>
	 * EQ Holding Cost를월단가를 복사해서 생성한다.<br>
	 *
	 * @param SearchConditionVO searchConditionVO
	 * @param SignOnUserAccount account
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createEqHoldingMonthCopy(SearchConditionVO searchConditionVO, SignOnUserAccount account) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		HashMap<String, String> param = new HashMap<String, String>();

		try {
			//파라미터 세팅
			param.put("f_src_mon"		, searchConditionVO.getFSrcMon().replaceAll("-", ""));
			param.put("f_tar_mon"		, searchConditionVO.getFTarMon().replaceAll("-", ""));
            param.put("user_id"   		, account.getUsr_id());

          //1.COA_HLD_COST테이블에서  TARGET 해당월을 삭제한다.
            dbDao.removeEqHoldingCost(param);
          //2.COA_HLD_COST테이블에  SOURCE 해당월을 복사해서  TARGET 데이타를 생성한다.
            dbDao.createEqHoldingMonthCopy(param);
          //3. 복사 상태를 단가 관리 table에 insert 한다.
            dbDao.modifyEqHoldingCreationStatus(param);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(new ErrorHandler(de).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}

		return eventResponse;
	}	
	
}