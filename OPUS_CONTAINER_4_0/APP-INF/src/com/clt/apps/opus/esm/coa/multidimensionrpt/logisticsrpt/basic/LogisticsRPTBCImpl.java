/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MultiDimensionRPTBCImpl.java
*@FileTitle : Inquiry the logistics performance analysis RPT
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.basic;

import java.util.List;

import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.integration.LogisticsRPTDBDAO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLgstConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0080ListVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0080ListVO2;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0081ListVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0081ListVO2;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0082ListVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0082ListVO2;
import com.clt.apps.opus.esm.coa.multidimensionrpt.logisticsrpt.vo.SearchLogisticsRPT0158ListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;



/**
 * OPUS-COA Business Logic Basic Command implementation<br>
 * 
 * 
 * @author
 * @see ESM_COA_060EventResponse,MultiDimensionRPTBC reference the each DAO class 
 * @since J2EE 1.4
 */
public class LogisticsRPTBCImpl extends BasicCommandSupport implements LogisticsRPTBC {

	// Database Access Object
	private transient LogisticsRPTDBDAO dbDao=null;

	/**
	 * MultiDimensionRPTBCImpl Object creation<br>
	 * MultiDimensionRPTDBDAO Creation<br>
	 */
	public LogisticsRPTBCImpl(){
		dbDao = new LogisticsRPTDBDAO();
	}	
	
	/**
	 * Handling the inquiry event<br>
	 * About the ESM_COA_0080, Handling the inquiry event<br>
	 * sheet1<br>
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT0080ListVO>
	 * @exception EventException
	 */
	public List<SearchLogisticsRPT0080ListVO> searchLogisticsRPT0080List(SearchLgstConditionVO searchLgstConditionVO) throws EventException {
		
		try {
			return dbDao.searchLogisticsRPT0080List(searchLgstConditionVO);
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
	 * About the ESM_COA_0080, Handling the inquiry event<br>
	 * sheet2-detail<br>
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT0080ListVO2>
	 * @exception EventException
	 */
	public List<SearchLogisticsRPT0080ListVO2> searchLogisticsRPT0080List2(SearchLgstConditionVO searchLgstConditionVO) throws EventException {
		
		try {
			String sCostMon = searchLgstConditionVO.getSCostYrmon2();
			String sCostWk = searchLgstConditionVO.getSCostWk2();
			String sLoad = searchLgstConditionVO.getSLoad();
			String sTrdCd = searchLgstConditionVO.getSTrdCd();
			String sRlaneCd = searchLgstConditionVO.getSRlaneCd();
			String sSkdDDirCd = searchLgstConditionVO.getSSkdDirCd();
			
			if(!sCostMon.equals("")) sCostMon = sCostMon.substring(4);
				
			if("X".equals(sCostMon)) sCostMon = "";
			if("X".equals(sCostWk)) sCostWk = "";
			if("X".equals(sTrdCd)) sTrdCd = "";
			if("X".equals(sRlaneCd)) sRlaneCd = "";
			if("X".equals(sSkdDDirCd)) sSkdDDirCd = "";

			searchLgstConditionVO.setSCostYrmon2(sCostMon);
			searchLgstConditionVO.setSCostWk2(sCostWk);
			searchLgstConditionVO.setSLoad(sLoad);
			searchLgstConditionVO.setSTrdCd(sTrdCd);
			searchLgstConditionVO.setSRlaneCd(sRlaneCd);
			searchLgstConditionVO.setSSkdDirCd(sSkdDDirCd);			
			
			return dbDao.searchLogisticsRPT0080List2(searchLgstConditionVO);
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
	 * About the ESM_COA_0081, Handling the inquiry event<br>
	 * sheet1<br>
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT0081ListVO>
	 * @exception EventException
	 */
	public List<SearchLogisticsRPT0081ListVO> searchLogisticsRPT0081List(SearchLgstConditionVO searchLgstConditionVO) throws EventException {
		
		try {
			String fYear = searchLgstConditionVO.getFYear();
			String fFmMon = searchLgstConditionVO.getFFmMon();
			String fToMon = searchLgstConditionVO.getFToMon();
			String fSlsMon = searchLgstConditionVO.getFSlsMon();
			String fFmWk = searchLgstConditionVO.getFFmWk();
			String fToWk = searchLgstConditionVO.getFToWk();
			
			if(!"".equals(fFmMon)){
				fFmMon=fYear + fFmMon;
			}else{
				fFmMon="";
			}

			if(!"".equals(fToMon)){
				fToMon=fYear + fToMon;
			}else{
				fToMon="";
			}

			if("".equals(fSlsMon)) fSlsMon="";
			if("".equals(fFmWk)) fFmWk="";
			if("".equals(fToWk)) fToWk="";
			
			searchLgstConditionVO.setFFmMon(fFmMon);
			searchLgstConditionVO.setFToMon(fToMon);
			searchLgstConditionVO.setFSlsMon(fSlsMon);
			searchLgstConditionVO.setFFmWk(fFmWk);
			searchLgstConditionVO.setFToWk(fToWk);
		
			return dbDao.searchLogisticsRPT0081List(searchLgstConditionVO);
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
	 * About the ESM_COA_0081, Handling the inquiry event<br>
	 * sheet2-detail window<br>
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT0081ListVO2>
	 * @exception EventException
	 */
	public List<SearchLogisticsRPT0081ListVO2> searchLogisticsRPT0081List2(SearchLgstConditionVO searchLgstConditionVO) throws EventException {
		
		try {
			String sCostMon2 = searchLgstConditionVO.getSCostYrmon2();
			String sCostWk2 = searchLgstConditionVO.getSCostWk2();
			String sRhqCd = searchLgstConditionVO.getSRhqCd();
			String sCntrOfcCd = searchLgstConditionVO.getSCntrOfcCd();
			String sLgsKpiCostGrpCd = searchLgstConditionVO.getSLgsKpiCostGrpCd();
			String sKpiCd = searchLgstConditionVO.getSKpiCd();
			
			if (!sCostMon2.equals("")) sCostMon2 = sCostMon2.substring(4);
			
			if("X".equals(sCostWk2)) sCostWk2 = "";
			if("X".equals(sCostMon2)) sCostMon2 = "";
			if("X".equals(sRhqCd)) sRhqCd = "";
			if("X".equals(sCntrOfcCd)) sCntrOfcCd = "";
			if("X".equals(sLgsKpiCostGrpCd)) sLgsKpiCostGrpCd = "";
			if("X".equals(sKpiCd)) sKpiCd = "";
			
			searchLgstConditionVO.setSCostYrmon2(sCostMon2);
			searchLgstConditionVO.setSCostWk2(sCostWk2);
			searchLgstConditionVO.setSRhqCd(sRhqCd);
			searchLgstConditionVO.setSCntrOfcCd(sCntrOfcCd);
			searchLgstConditionVO.setSLgsKpiCostGrpCd(sLgsKpiCostGrpCd);
			searchLgstConditionVO.setSKpiCd(sKpiCd);
			
			return dbDao.searchLogisticsRPT0081List2(searchLgstConditionVO);
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
	 * About the ESM_COA_0082, Handling the inquiry event<br>
	 * sheet1<br>
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT0082ListVO>
	 * @exception EventException
	 */
	public List<SearchLogisticsRPT0082ListVO> searchLogisticsRPT0082List(SearchLgstConditionVO searchLgstConditionVO) throws EventException {
		
		try {
			 return dbDao.searchLogisticsRPT0082List(searchLgstConditionVO);
			
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
	 * About the ESM_COA_0082, Handling the inquiry event<br>
	 * sheet1<br>
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT0082ListVO2>
	 * @exception EventException
	 */
	public List<SearchLogisticsRPT0082ListVO2> searchLogisticsRPT0082List2(SearchLgstConditionVO searchLgstConditionVO) throws EventException {
		
		try {
 			  return dbDao.searchLogisticsRPT0082List2(searchLgstConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Logistics Vol. by Offic Inquiry<br>
	 * About the ESM_COA_0158, Handling the inquiry event<br>
	 * 
	 * @param SearchLgstConditionVO searchLgstConditionVO
	 * @return List<SearchLogisticsRPT0158ListVO>
	 * @exception EventException
	 */
	public List<SearchLogisticsRPT0158ListVO> searchLogisticsRPT0158List(SearchLgstConditionVO searchLgstConditionVO) throws EventException {
		
		try {
			return dbDao.searchLogisticsRPT0158List(searchLgstConditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}


}