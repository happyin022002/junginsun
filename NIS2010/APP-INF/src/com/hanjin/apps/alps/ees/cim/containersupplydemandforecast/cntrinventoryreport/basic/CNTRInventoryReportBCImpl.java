/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CNTRInventoryReportBCImpl.java
*@FileTitle : EQ Operation Trend (Inventory Trend)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.05.04 김종준
* 1.0 Creation
* =========================================================
* 2010.09.07 남궁진호 [CHM-201005814-01] 소스품질 결함 조치.List<VO >공백제거
=========================================================*/
package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.integration.CNTRInventoryReportDBDAO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtCntrListVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtCodeCommonVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtOptionVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtSmryVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.StockByCntrListVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.StockSmryVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.TrendListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-ContainerSupplyDemandForecast Business Logic Basic Command implementation<br>
 * - ALPS-ContainerSupplyDemandForecast에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author kim jong jun
 * @see EES_CIM_0001EventResponse,CNTRInventoryReportBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class CNTRInventoryReportBCImpl extends BasicCommandSupport implements CNTRInventoryReportBC {

	// Database Access Object
	private transient CNTRInventoryReportDBDAO dbDao = null;

	/**
	 * CNTRInventoryReportBCImpl 객체 생성<br>
	 * ${DAO}DAO를 생성한다.<br>
	 */
	public CNTRInventoryReportBCImpl() {
		dbDao = new CNTRInventoryReportDBDAO();
	}
	/**
	 * 지역기준의 CNTR 재고관리 운영지표인 Inventory Trend 조회 <br>
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
	 * 지역별,EQ TY/SZ 별 Long Staying Ratio를 조회<br>
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
	 * 현재일을 기준으로 주차와,년월을 구해 주어진 기간의 주차와,년월을 조회<br>
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
	 * 주어진 기간의 주차와,년월 목록을 조회<br>
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
	 * 컨테이너 TYPE/SIZE 목록을 조회<br>
	 * 
	 * @return List<InvtCodeCommonVO>
	 * @exception EventException
	 */
	public List<InvtCodeCommonVO> searchCntrTypeSizeList() throws EventException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
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
	 * Land 및 Sea 구간의 Full & MTY CNTR 재고를 Lease Term으로 구분하여 조회<br>
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
	 * Land Inventory with Optimum Stock 화면에서 Location 별로 구분하여 조회<br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtSmryVO>
	 * @exception EventException
	 */
	public List<InvtSmryVO> searchInvtOptmStkList(InvtOptionVO invtOptionVO) throws EventException {
		try { 
			return dbDao.searchInvtOptmStkList(invtOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Land Inventory with Optimum Stock"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Land Inventory with Optimum Stock"}).getMessage(),ex);
		}
	}	
	
	/**
	 * batch week, this week 조회<br>
	 * 
	 * @return List<InvtOptionVO>
	 * @exception EventException
	 */
	public List<InvtOptionVO> searchYearWk() throws EventException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		List<InvtOptionVO> list = null;
		try {
			list = dbDao.searchYearWk();
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Year Week List"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Year Week List"}).getMessage(),ex);
		}
	}
	
	/**
	 * Land의 CNTR 재고를 Lease Term,Movement Status 별로 구분하여 조회<br>
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
	 * Land의 CNTR 재고를 Location별로 구분하여 조회<br> 
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
	 * 조회시점 기준, 해상에 VVD별로 소재하고 있는 컨테이너의 Lease Term 별,Style(FL/MTY) 수량 조회<br> 
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtSmryVO>
	 * @exception EventException
	 */
	public List<InvtSmryVO> searchSeaInvtListInvt(InvtOptionVO invtOptionVO) throws EventException {
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
			return dbDao.searchSeaInvtListInvt(invtOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Sea Inventory (by VVD) Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Sea Inventory (by VVD) Retrieve"}).getMessage(),ex);
		}
	}

	/**
	 * 조회시점 기준, 해상에 VVD별로 소재하고 있는 컨테이너의 POL/POD 별 수량 조회<br> 
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtSmryVO>
	 * @exception EventException
	 */
	public List<InvtSmryVO> searchSeaInvtListByPolPod(InvtOptionVO invtOptionVO) throws EventException {
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
			return dbDao.searchSeaInvtListByPolPod(invtOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Sea Inventory (by POL-POD) Retrieve"}).getMessage(),ex);			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Sea Inventory (by POL-POD) Retrieve"}).getMessage(),ex);			
		}
	}

	/**
	 * 조회시점 기준, 해상에 VVD별로 소재하고 있는 컨테이너 번호,관련 Booking 및 장비관리 정보 조회 <br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtCntrListVO>
	 * @exception EventException
	 */
	public List<InvtCntrListVO> searchSeaInvtListByCntr(InvtOptionVO invtOptionVO) throws EventException {
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
			return dbDao.searchSeaInvtListByCntr(invtOptionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Sea Inventory (CNTR List) Retrieve"}).getMessage(),ex);			
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CIM00011", new String[]{"Sea Inventory (CNTR List) Retrieve"}).getMessage(),ex);			
		}
	}
	
	/**
	 * 조회시점 기준, 지역별로 소재하고 있는 컨테이너 넘버 및 관련 Booking 및 장비관리 정보를 조회<br>
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
	 * 구주지역내 장비수급 계획을 감안하여, 금일 기준의 Available 장비 대수를 조회한다. <br>
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
	 * 구주지역내 SCC 또는 Yard별 MT 재고를 컨테이너별로 조회한다.(팝업)
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
	 * 구주지역내 MTY 컨테이너의 Release/ Redelivery Order 승인리스트를 확인하여, 해당야드에 반입/ 반출되는 컨테이너 정보를 조회한다.(팝업)
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
	 * 지점별로 향후 2 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력한 내용을 생성,수정<br>
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