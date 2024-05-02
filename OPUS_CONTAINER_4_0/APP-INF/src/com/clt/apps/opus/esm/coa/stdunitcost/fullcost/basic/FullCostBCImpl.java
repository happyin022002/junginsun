/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : FullCostBCImpl.java
*@FileTitle : Node Cost (PA/RA)
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.coa.stdunitcost.fullcost.basic;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.integration.FullCostDBDAO;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.vo.SearchLinkCostListByPRDVO;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.vo.SearchLinkCostListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.vo.SearchMonthNodeCostListVO;
import com.clt.apps.opus.esm.coa.stdunitcost.fullcost.vo.SearchMonthYardCodeListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import java.util.ArrayList;
import java.util.List;


/**
 * OPUS-COA Business Logic Basic Command implementation<br>
 * 
 *
 * @author
 * @see EsmCoa0004GS2ViewAdapter,FullCostBC, reference the each DBDAO class 
 * @since J2EE 1.5
 */
public class FullCostBCImpl   extends BasicCommandSupport implements FullCostBC {

	// Database Access Object
	private transient FullCostDBDAO dbDao=null;

	/**
	 * FullCostBCImpl Object creation<br>
	 * FullCostDBDAO Creation<br>
	 */
	public FullCostBCImpl(){
		dbDao = new FullCostDBDAO();
	}

	/**
	 * Handling the inquiry event<br>
	 * FullCost, Handling the inquiry event, sheet1<br>
	 * ESM_COA_0004 Inquiry
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
	 * Handling the inquiry event<br>
	 * FullCost, Handling the inquiry event, sheet2<br>
	 * ESM_COA_0004 Inquiry
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
	 * Handling the inquiry event<br>
	 * Standard unit cost by a link, Handling the inquiry event<br>
	 * ESM_COA_0008 Inquiry
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
	 * Handling the inquiry event<br>
	 * Standard unit cost popup by a link, Handling the inquiry event<br>
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