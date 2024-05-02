/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AocPopUpBCImpl.java
*@FileTitle : AOC PopUp
*Open Issues :
*Change history :
*@LastModifyDate : 2012.10.04
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.common.aocpopup.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.aoc.common.aocpopup.integration.AocPopUpDBDAO;
import com.hanjin.apps.alps.esd.aoc.common.aocpopup.vo.FdrCostBatchErrorVO;
import com.hanjin.apps.alps.esd.aoc.common.aocpopup.vo.InlandCostBatchErrorVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

 
/**
 * ESD-AOC Business Logic Basic Command implementation<br>
 * - ESD-AOC에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author 
 * @see BC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class AocPopUpBCImpl   extends BasicCommandSupport implements AocPopUpBC {

	// Database Access Object
	private transient AocPopUpDBDAO dbDao=null;

	/**
	 * CostBatchBCImpl 객체 생성<br>
	 * CostBatchDBDAO를 생성한다.<br>
	 */
	public AocPopUpBCImpl(){
		dbDao = new AocPopUpDBDAO();
	}
	
	
	/**
	 * @param inlandCostBatchErrorVO
	 * @return
	 * @throws EventException
	 */
	public List<InlandCostBatchErrorVO> searchInlandCostBatchError(InlandCostBatchErrorVO inlandCostBatchErrorVO) throws EventException{
		try {
			return dbDao.searchInlandCostBatchError(inlandCostBatchErrorVO);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * @param fdrCostBatchErrorVO
	 * @return
	 * @throws EventException
	 */
	public List<FdrCostBatchErrorVO> searchFdrCostBatchError(FdrCostBatchErrorVO fdrCostBatchErrorVO) throws EventException{
		try {
			return dbDao.searchFdrCostBatchError(fdrCostBatchErrorVO);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * AOC 업무 시나리오 마감작업<br>
	 * DistanceCreation업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}