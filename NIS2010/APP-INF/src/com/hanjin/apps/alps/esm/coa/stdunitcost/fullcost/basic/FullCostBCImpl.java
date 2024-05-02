/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : FullCostBCImpl.java
*@FileTitle : Node Cost (PA/RA)
*Open Issues :
*Change history :2007-06-07=EMS_COA_008 관련 메소드:prd과 프로그램 공유를 위해 sheet1, 2, 3삭제하고 4를 1로 대체
*@LastModifyDate : 2009-09-01
*@LastModifier : 장영석
*@LastVersion : 1.8
* 2006-12-04 IM OKYOUNG
* 2009-07-24 박수훈  New Framework 적용 [0004, 0008]
* 2009-09-01 장영석  New Framework 적용 [0141]
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.coa.stdunitcost.fullcost.basic;

import com.hanjin.apps.alps.esm.coa.stdunitcost.fullcost.integration.FullCostDBDAO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import java.util.ArrayList;
import java.util.List;
import com.hanjin.apps.alps.esm.coa.common.vo.SearchConditionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.apps.alps.esm.coa.stdunitcost.fullcost.vo.SearchMonthYardCodeListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.fullcost.vo.SearchMonthNodeCostListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.fullcost.vo.SearchLinkCostListVO;
import com.hanjin.apps.alps.esm.coa.stdunitcost.fullcost.vo.SearchLinkCostListByPRDVO;


/**
 * ALPS-COA Business Logic Basic Command implementation<br>
 * - ALPS-COA에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author IM OKYOUNG
 * @see EsmCoa0004GS2ViewAdapter,FullCostBC, 각 DBDAO 클래스 참조
 * @since J2EE 1.5
 */
public class FullCostBCImpl   extends BasicCommandSupport implements FullCostBC {

	// Database Access Object
	private transient FullCostDBDAO dbDao=null;

	/**
	 * FullCostBCImpl 객체 생성<br>
	 * FullCostDBDAO를 생성한다.<br>
	 */
	public FullCostBCImpl(){
		dbDao = new FullCostDBDAO();
	}

	/**
	 * 조회 이벤트 처리<br>
	 * FullCost화면에 대한 조회 이벤트 처리, sheet1<br>
	 * ESM_COA_0004 조회
	 * 
	 * @param SearchMonthYardCodeListVO searchMonthYardCodeListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMonthYardCodeListVO>
	 * @exception EventException
	 */
	public List<SearchMonthYardCodeListVO> searchMonthYardCodeList(SearchMonthYardCodeListVO searchMonthYardCodeListVO
			                                                      ,SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchMonthYardCodeList(searchMonthYardCodeListVO, searchConditionVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * FullCost화면에 대한 조회 이벤트 처리, sheet2<br>
	 * ESM_COA_0004 조회
	 * 
	 * @param SearchMonthYardCodeListVO searchMonthYardCodeListVO
	 * @param SearchMonthNodeCostListVO searchMonthNodeCostListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchMonthNodeCostListVO>
	 * @exception EventException
	 */                                                              
	public List<SearchMonthNodeCostListVO> searchMonthNodeCostList (SearchMonthYardCodeListVO searchMonthYardCodeListVO
			                                                       ,SearchMonthNodeCostListVO searchMonthNodeCostListVO
			                                                       ,SearchConditionVO searchConditionVO) throws EventException {
		
		List<SearchMonthNodeCostListVO> rtnList = null;
		try{
			List<String> nodeCdList  = new ArrayList<String>();  
			nodeCdList.add(searchMonthYardCodeListVO.getNodCd());	
				rtnList = dbDao.searchMonthNodeCostList(searchMonthYardCodeListVO,searchConditionVO);
			return rtnList;
		} 
		catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} 
		catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
		
	/**
	 * 조회 이벤트 처리<br>
	 * Link별 표준단가 조회 이벤트 처리<br>
	 * ESM_COA_0008 조회
	 * 
	 * @param SearchLinkCostListVO searchLinkCostListVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchLinkCostListVO>
	 * @exception EventException
	 */
	public List<SearchLinkCostListVO> searchLinkCostList(SearchLinkCostListVO searchLinkCostListVO
			                                            ,SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchLinkCostList(searchLinkCostListVO, searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
		
	
	/**
	 * 조회 이벤트 처리<br>
	 * Link별 표준단가 팝업 조회 이벤트 처리<br>
	 * sheet
	 *
	 * @param SearchLinkCostListByPRDVO searchLinkCostListByPRDVO
	 * @param SearchConditionVO searchConditionVO
	 * @return List<SearchLinkCostListByPRDVO> 
	 * @exception EventException
	 */
	public List<SearchLinkCostListByPRDVO> searchLinkCostListByPRD(SearchLinkCostListByPRDVO searchLinkCostListByPRDVO,SearchConditionVO searchConditionVO) throws EventException {
		try {
			return dbDao.searchLinkCostListByPRD(searchConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}	


}