/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CNTRInventoryReportBCImpl.java
*@FileTitle : EQ Operation Trend (Inventory Trend)
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration.CNTRInventoryReportDBDAO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtCntrListVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtCodeCommonVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtOptionVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtSmryVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.StockByCntrListVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.StockSmryVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.TrendListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-ContainerSupplyDemandForecast Business Logic Basic Command implementation<br>
 * handling - OPUS-ContainerSupplyDemandForecast business logic 
 *
 * @author
 * @see EES_CIM_0001EventResponse,CNTRInventoryReportBC DAO class reference
 * @since J2EE 1.4
 */

public class CNTRInventoryReportBCImpl extends BasicCommandSupport implements CNTRInventoryReportBC {

	// Database Access Object
	private transient CNTRInventoryReportDBDAO dbDao = null;

	/**
	 * creating CNTRInventoryReportBCImpl Object
	 * creating ${DAO}DAO
	 */
	public CNTRInventoryReportBCImpl() {
		dbDao = new CNTRInventoryReportDBDAO();
	}
	/**
	 * retrieving Inventory Trend for regional container inventory management
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<TrendListVO>
	 * @exception EventException
	 */
	public List<TrendListVO> searchTrendListByInvt(InvtOptionVO invtOptionVO) throws EventException {
		try {
			return dbDao.searchTrendListByInvt(invtOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"EQ Operation Trend (Inventory Trend) Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"EQ Operation Trend (Inventory Trend) Retrieve"}).getMessage(),ex);
		}
	}
	
	/**
	 * retrieving Long Staying Ratio by region ,EQ TY/SZ 
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<TrendListVO>
	 * @exception EventException
	 */
	public List<TrendListVO> searchTrendListByLongStaying(InvtOptionVO invtOptionVO) throws EventException {
		try {
			return dbDao.searchTrendListByLongStaying(invtOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"EQ Operation Trend (Long Staying) Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"EQ Operation Trend (Long Staying) Retrieve"}).getMessage(),ex);
		}
	}	
	
	/**
	 * retrieving week, year, month for inputed period
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return InvtOptionVO
	 * @exception EventException
	 */
	public InvtOptionVO searchDefaultMonthWeek(InvtOptionVO invtOptionVO) throws EventException {
		InvtOptionVO invtOptionVo = null;
		try {
			invtOptionVo = dbDao.searchDefaultMonthWeek(invtOptionVO);
			return invtOptionVo;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Month Week Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Month Week Retrieve"}).getMessage(),ex);
		}
	}		

	/**
	 * retrieving week, year, month list for inputed period
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<TrendListVO>
	 * @exception EventException
	 */
	public List<TrendListVO> searchMonthWeekList(InvtOptionVO invtOptionVO) throws EventException {
		List<TrendListVO> list = null;
		try {
			list = dbDao.searchMonthWeekList(invtOptionVO);
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Month Week List"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Month Week List"}).getMessage(),ex);
		}		
	}		

	/**
	 * retrieving container TYPE/SIZE list
	 * 
	 * @return List<InvtCodeCommonVO>
	 * @exception EventException
	 */
	public List<InvtCodeCommonVO> searchCntrTypeSizeList() throws EventException {
		// Object implementing DB ResultSet to transmit data
		List<InvtCodeCommonVO> list = null;
		try {
			list = dbDao.searchCntrTypeSizeList();
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Container Type Size List"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Container Type Size List"}).getMessage(),ex);
		}
	}

	/**
	 * retrieving Full & MTY CNTR inventory for Land & Sea route by Lease Term
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtSmryVO>
	 * @exception EventException
	 */
	public List<InvtSmryVO> searchTotalInvtList(InvtOptionVO invtOptionVO) throws EventException {
		try { 
			return dbDao.searchTotalInvtList(invtOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Total Inventory by Lease Term"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Total Inventory by Lease Term"}).getMessage(),ex);
		}
	}
	
	/**
	 * retrieving Land container inventory by Lease Term, Movement Status 
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtSmryVO>
	 * @exception EventException
	 */
	public List<InvtSmryVO> searchLandInvtListByTerm(InvtOptionVO invtOptionVO) throws EventException {
		try { 
			return dbDao.searchLandInvtListByTerm(invtOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Land Inventory (By Lease Term) Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Land Inventory (By Lease Term) Retrieve"}).getMessage(),ex);
		}
	}

	/**
	 * retrieving Land inventory by Location 
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtSmryVO>
	 * @exception EventException
	 */
	public InvtSmryVO[] searchLandInvtListByLoc(InvtOptionVO invtOptionVO) throws EventException {
		InvtSmryVO[] invtSmryVOs=null; 
		try {
			invtSmryVOs=dbDao.searchLandInvtListByLoc(invtOptionVO);
			
			return invtSmryVOs;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			//throw new EventException(de.getMessage());
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Land Inventory (By Location)"}).getMessage(),de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Land Inventory (By Location)"}).getMessage(),ex);
		}
	}

	/**
	 * retrieving container quantity in VVD by Lease Term and Style(FL/MTY)
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtSmryVO>
	 * @exception EventException
	 */
	public List<InvtSmryVO> searchSeaInvtListInvt(InvtOptionVO invtOptionVO) throws EventException {
		List<InvtSmryVO> rtnList = new ArrayList<InvtSmryVO>();
		try { 
			if(invtOptionVO != null){
				if ( invtOptionVO.getCntrTpszCd().equals("") ) {
					if ( invtOptionVO.getD2PayldFlg().equals("Y") ) {
						invtOptionVO.setCntrTpszCd("D2");
					}	
					if ( !invtOptionVO.getRfTpCdC().equals("") 
							|| !invtOptionVO.getRfTpCdH().equals("") 
							|| !invtOptionVO.getRfCntr().equals("") 
							|| !invtOptionVO.getRdCgoFlg().equals("") 
					) {
						invtOptionVO.setCntrTpszCd("R2,R5");
					}			
				}
			}
			
			if(invtOptionVO != null){
				rtnList = dbDao.searchSeaInvtListInvt(invtOptionVO);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Sea Inventory (by VVD) Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Sea Inventory (by VVD) Retrieve"}).getMessage(),ex);
		}
		
		return rtnList;
	}

	/**
	 * retrieving container quantity in VVD by POL/POD 
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtSmryVO>
	 * @exception EventException
	 */
	public List<InvtSmryVO> searchSeaInvtListByPolPod(InvtOptionVO invtOptionVO) throws EventException {
		List<InvtSmryVO> rtnList = new ArrayList<InvtSmryVO>();
		try { 
			if(invtOptionVO != null){
				if ( invtOptionVO.getCntrTpszCd().equals("") ) {
					if ( invtOptionVO.getD2PayldFlg().equals("Y") ) {
						invtOptionVO.setCntrTpszCd("D2");
					}			
					if ( !invtOptionVO.getRfTpCdC().equals("") 
							|| !invtOptionVO.getRfTpCdH().equals("") 
							|| !invtOptionVO.getRfCntr().equals("") 
							|| !invtOptionVO.getRdCgoFlg().equals("") 
					) {
						invtOptionVO.setCntrTpszCd("R2,R5");
					}			
				}
			}
			if(invtOptionVO != null){
				rtnList =  dbDao.searchSeaInvtListByPolPod(invtOptionVO);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Sea Inventory (by POL-POD) Retrieve"}).getMessage(),ex);			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Sea Inventory (by POL-POD) Retrieve"}).getMessage(),ex);			
		}
		
		return rtnList;
	}

	
	/**
	 * retrieving container no, related booking and EQ management information by region
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return int
	 * @exception EventException
	 */
	public int searchSeaInvtTotalByCntr(InvtOptionVO invtOptionVO) throws EventException {
		int totalCnt = 0; 	
		try { 
			if(invtOptionVO != null){
				if ( invtOptionVO.getCntrTpszCd().equals("") ) {
					if ( invtOptionVO.getD2PayldFlg().equals("Y") ) {
						invtOptionVO.setCntrTpszCd("D2");
					}			
					if ( !invtOptionVO.getRfTpCdC().equals("") 
							|| !invtOptionVO.getRfTpCdH().equals("") 
							|| !invtOptionVO.getRfCntr().equals("") 
							|| !invtOptionVO.getRdCgoFlg().equals("") 
					) {
						invtOptionVO.setCntrTpszCd("R2,R5");
					}			
				}
			}
			
			if(invtOptionVO != null){
				totalCnt = dbDao.searchSeaInvtTotalByCntr(invtOptionVO);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Land Inventory With CNTR List Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Land Inventory With CNTR List Retrieve"}).getMessage(),ex);
		}
		
		return totalCnt;
	}
	
	
	/**
	 * retrieving container no, related booking and EQ management information in VVD
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtCntrListVO>
	 * @exception EventException
	 */
	public List<InvtCntrListVO> searchSeaInvtListByCntr(InvtOptionVO invtOptionVO) throws EventException {
		List<InvtCntrListVO> rtnList = new ArrayList<InvtCntrListVO>();
		try { 
			if(invtOptionVO != null){
				if ( invtOptionVO.getCntrTpszCd().equals("") ) {
					if ( invtOptionVO.getD2PayldFlg().equals("Y") ) {
						invtOptionVO.setCntrTpszCd("D2");
					}			
					if ( !invtOptionVO.getRfTpCdC().equals("") 
							|| !invtOptionVO.getRfTpCdH().equals("") 
							|| !invtOptionVO.getRfCntr().equals("") 
							|| !invtOptionVO.getRdCgoFlg().equals("") 
					) {
						invtOptionVO.setCntrTpszCd("R2,R5");
					}			
				}
			}
			
			if(invtOptionVO != null){
				rtnList = dbDao.searchSeaInvtListByCntr(invtOptionVO);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Sea Inventory (CNTR List) Retrieve"}).getMessage(),ex);			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Sea Inventory (CNTR List) Retrieve"}).getMessage(),ex);			
		}
		
		return rtnList;
	}
	
	
	/**
	 * retrieving container no, related booking and EQ management information by region
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return int
	 * @exception EventException
	 */
	public int searchCntrTotalCntByLoc(InvtOptionVO invtOptionVO) throws EventException {
		int totalCnt = 0; 
		try { 			
			List<InvtCntrListVO> invtCntrListVOS = dbDao.searchRccDateList(invtOptionVO);
			invtOptionVO.setRccDate(invtCntrListVOS.get(0).getRccDate());
			invtOptionVO.setRccCd(invtCntrListVOS.get(0).getRccCd());
			
			if ( invtOptionVO.getViewFlg().equals("eq")) {
				totalCnt = dbDao.searchCntrListEqWiseByTotalLoc(invtOptionVO);
			} else {
				totalCnt = dbDao.searchCntrListBkgWiseByTotalLoc(invtOptionVO);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Land Inventory With CNTR List Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Land Inventory With CNTR List Retrieve"}).getMessage(),ex);
		}
		
		return totalCnt;
	}
	
	
	/**
	 * retrieving container no, related booking and EQ management information by region
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtCntrListVO>
	 * @exception EventException
	 */
	public List<InvtCntrListVO> searchCntrListByLoc(InvtOptionVO invtOptionVO) throws EventException {
		try { 
			List<InvtCntrListVO> invtCntrListVOS = dbDao.searchRccDateList(invtOptionVO);
			invtOptionVO.setRccDate(invtCntrListVOS.get(0).getRccDate());
			invtOptionVO.setRccCd(invtCntrListVOS.get(0).getRccCd());
			
			if ( invtOptionVO.getViewFlg().equals("eq")) {
				return dbDao.searchCntrListEqWiseByLoc(invtOptionVO);
			} else {
				return dbDao.searchCntrListBkgWiseByLoc(invtOptionVO);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Land Inventory With CNTR List Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Land Inventory With CNTR List Retrieve"}).getMessage(),ex);
		}
	}
	
	/**
	 * retrieving Today's available EQ quantity with Europe region EQ management plan
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<StockSmryVO>
	 * @exception EventException
	 */
	public List<StockSmryVO> searchStockList(InvtOptionVO invtOptionVO) throws EventException {
		try {
			return dbDao.searchStockList(invtOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Stock Report Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Stock Report Retrieve"}).getMessage(),ex);
		}
	}
	
	/**
	 * retrieving MT inventory in Europe SCC or Yard by container type (pop up)
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<StockByCntrListVO>
	 * @exception EventException
	 */
	public List<StockByCntrListVO> searchStockCntrList(InvtOptionVO invtOptionVO) throws EventException {
		try {
			return dbDao.searchStockCntrList(invtOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Stock Report (CNTR Data) Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Stock Report (CNTR Data) Retrieve"}).getMessage(),ex);
		}
	}	

	/**
	 * retrieving In/Out container information in yard by checking MTY container Release/Redelivery Order approval list in Europe region (pop up)
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<StockByCntrListVO>
	 * @exception EventException
	 */
	public List<StockByCntrListVO> searchStockDueDateList(InvtOptionVO invtOptionVO) throws EventException {
		try {
			return dbDao.searchStockDueDateList(invtOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Stock Report (Due Data) Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Stock Report (Due Data) Retrieve"}).getMessage(),ex);
		}
	}

	/**
	 * creating and modifying available expected MTY EQ Supply & Demand for next 2 weeks by region
	 * 
	 * @param StockSmryVO[] stockSmryVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageStock(StockSmryVO[] stockSmryVOs, SignOnUserAccount account) throws EventException {
		try {
			List<StockSmryVO> insertVoList = new ArrayList<StockSmryVO>();
			List<StockSmryVO> updateVoList = new ArrayList<StockSmryVO>();
			for ( int i=0; i<stockSmryVOs .length; i++ ) {
				int checkAddModifyCnt = dbDao.checkAddModifyStock(stockSmryVOs[i]);
				stockSmryVOs[i].setCreUsrId(account.getUsr_id());
				stockSmryVOs[i].setUpdUsrId(account.getUsr_id());
				stockSmryVOs[i].unDataFormat();
				if ( checkAddModifyCnt == 0) {
					insertVoList.add(stockSmryVOs[i]);
				} else {
					updateVoList.add(stockSmryVOs[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addStock(insertVoList);
			}
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyStock(updateVoList);
			}			
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Stock Report Create"}).getMessage(),ex);
			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Stock Report Create"}).getMessage(),ex);
		}
	}
}