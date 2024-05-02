/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CNTRInventoryReportBC.java
*@FileTitle : EQ Operation Trend (Inventory Trend)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.basic;

import java.util.List;

import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtCntrListVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtCodeCommonVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtOptionVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtSmryVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.StockByCntrListVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.StockSmryVO;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.TrendListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-Containersupplydemandforecast Business Logic Command Interface
 * Interface for - OPUS-Containersupplydemandforecast business logic
 *
 * @author 
 * @see Ees_cim_0001EventResponse reference
 * @since J2EE 1.4
 */

public interface CNTRInventoryReportBC {
	/**
	 * retrieving Inventory Trend for regional container inventory management
	 * @param InvtOptionVO invtOptionVO
	 * @return List<TrendListVO>
	 * @exception EventException
	 */
	public List<TrendListVO> searchTrendListByInvt(InvtOptionVO invtOptionVO) throws EventException;

	/**
	 * retrieving week, month information from today
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return InvtOptionVO
	 * @exception EventException
	 */
	public InvtOptionVO searchDefaultMonthWeek(InvtOptionVO invtOptionVO) throws EventException;
	

	/**
	 * retrieving week, year, month for inputed period
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<TrendListVO>
	 * @exception EventException
	 */
	public List<TrendListVO> searchMonthWeekList(InvtOptionVO invtOptionVO) throws EventException;
	
	/**
	 * retrieving container TYPE/SIZE list
	 * 
	 * @return List<InvtCodeCommonVO>
	 * @exception EventException
	 */
	public List<InvtCodeCommonVO> searchCntrTypeSizeList() throws EventException;
	
	/**
	 * retrieving Long Staying Ratio by region, EQ TY/SZ
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<TrendListVO>
	 * @exception EventException
	 */
	public List<TrendListVO> searchTrendListByLongStaying(InvtOptionVO invtOptionVO) throws EventException;

	/**
	 * retrieving Full & MTY CNTR inventory for Land & Sea route by Lease Term
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtSmryVO>
	 * @exception EventException
	 */
	public List<InvtSmryVO> searchTotalInvtList(InvtOptionVO invtOptionVO) throws EventException;
	
	/**
	 * retrieving Land container inventory by Lease Term, Movement Status 
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtSmryVO>
	 * @exception EventException
	 */
	public List<InvtSmryVO> searchLandInvtListByTerm(InvtOptionVO invtOptionVO) throws EventException;
	
	/**
	 * retrieving Land inventory by Location 
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtSmryVO>
	 * @exception EventException
	 */
	public InvtSmryVO[] searchLandInvtListByLoc(InvtOptionVO invtOptionVO) throws EventException;

	/**
	 * retrieving container quantity in VVD by Lease Term and Style(FL/MTY)
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtSmryVO>
	 * @exception EventException
	 */
	public List<InvtSmryVO> searchSeaInvtListInvt(InvtOptionVO invtOptionVO) throws EventException;

	/**
	 * retrieving container quantity in VVD by POL/POD 
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtSmryVO>
	 * @exception EventException
	 */
	public List<InvtSmryVO> searchSeaInvtListByPolPod(InvtOptionVO invtOptionVO) throws EventException;

	/**
	 * retrieving container no, related booking and EQ management information in VVD
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtCntrListVO>
	 * @exception EventException
	 */
	public List<InvtCntrListVO> searchSeaInvtListByCntr(InvtOptionVO invtOptionVO) throws EventException;

	/**
	 * retrieving container no, related booking and EQ management information by region 
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return int
	 * @exception EventException
	 */
	public int searchCntrTotalCntByLoc(InvtOptionVO invtOptionVO) throws EventException;
	
	/**
	 * retrieving container no, related booking and EQ management information by region 
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtCntrListVO>
	 * @exception EventException
	 */
	public List<InvtCntrListVO> searchCntrListByLoc(InvtOptionVO invtOptionVO) throws EventException;

	/**
	 * retrieving Today's available EQ quantity with Europe region EQ management plan
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<StockSmryVO>
	 * @exception EventException
	 */
	
	public List<StockSmryVO> searchStockList(InvtOptionVO invtOptionVO) throws EventException;
	/**
	 * retrieving MT inventory in Europe SCC or Yard by container type (pop up)
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<StockByCntrListVO>
	 * @exception EventException
	 */
	public List<StockByCntrListVO> searchStockCntrList(InvtOptionVO invtOptionVO) throws EventException;

	/**
	 * retrieving In/Out container information in yard by checking MTY container Release/Redelivery Order approval list in Europe region (pop up)
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<StockByCntrListVO>
	 * @exception EventException
	 */
	public List<StockByCntrListVO> searchStockDueDateList(InvtOptionVO invtOptionVO) throws EventException;

	/**
	 * creating and modifying available MTY inventory in LCC/ECC in Europe region
	 * 
	 * @param StockSmryVO[] stockSmryVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageStock(StockSmryVO[] stockSmryVOs,SignOnUserAccount account) throws EventException;
	
	/**
	 * retrieving container no, related booking and EQ management information by region
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return int
	 * @exception EventException
	 */
	public int searchSeaInvtTotalByCntr(InvtOptionVO invtOptionVO) throws EventException;
	
}