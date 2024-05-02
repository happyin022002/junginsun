/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PnLReportBCImpl.java
*@FileTitle : Profit & Loss Report
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
* --------------------------------------------------------
* History
* 2012.07.17 변종건 [CHM-201217633] Profit & Loss Report for Inland BIZ 생성
* 2013.03.26 이재위 [CHM-201323626] AOC P&L Report 대상 확대 - BKG/TRS DATA 요청
=========================================================*/
package com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.basic;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.integration.PnlReportDBDAO;
import com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.vo.PnLBkgDtlListVO;
import com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.vo.PnLBkgListVO;
import com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.vo.PnLRptOptionVO;
import com.hanjin.apps.alps.esd.aoc.aocreport.pnlreport.vo.PnLRptSmryListVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

 
/**
 * ESD-AOC Business Logic Basic Command implementation<br>
 * - ESD-AOC에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author 
 * @see EventResponse,DistanceCreationBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class PnlReportBCImpl   extends BasicCommandSupport implements PnlReportBC {

	// Database Access Object
	private transient PnlReportDBDAO dbDao=null;

	/**
	 * CostBatchBCImpl 객체 생성<br>
	 * CostBatchDBDAO를 생성한다.<br>
	 */
	public PnlReportBCImpl(){
		dbDao = new PnlReportDBDAO();
	}
	
	
	/**
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public List<PnLRptSmryListVO> searchPnLSlsVwList(PnLRptOptionVO inputVO) throws EventException{
		try {
			return dbDao.searchPnLSlsVwList(inputVO);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public List<PnLRptSmryListVO> searchPnLOpVwList(PnLRptOptionVO inputVO) throws EventException{
		try {
			return dbDao.searchPnLOpVwList(inputVO);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public List<PnLBkgListVO> searchPnLBkgList(PnLRptOptionVO inputVO) throws EventException{
		try {
			return dbDao.searchPnLBkgList(inputVO);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public List<PnLBkgDtlListVO> searchPnLBkgDtlList(PnLBkgDtlListVO inputVO) throws EventException{
		try {
			return dbDao.searchPnLBkgDtlList(inputVO);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	/**
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public String[] searchSvcScp(PnLRptOptionVO inputVO) throws EventException{
		try {
			return dbDao.searchSvcScp(inputVO);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchCustomerInfo(PnLRptOptionVO inputVO) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet dbRowset = null;
		
		try {
			dbRowset = dbDao.searchCustomerInfo(inputVO);
			if(dbRowset != null && dbRowset.next()){
				eventResponse.setRsVo(dbRowset);
				eventResponse.setETCData("cust_cd",  dbRowset.getString("CUST_CD"));
				eventResponse.setETCData("cust_nm",   dbRowset.getString("CUST_NM"));
			}
			return eventResponse;
			
		} catch (SQLException se) {
			log.error("err "+se.toString(),se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
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