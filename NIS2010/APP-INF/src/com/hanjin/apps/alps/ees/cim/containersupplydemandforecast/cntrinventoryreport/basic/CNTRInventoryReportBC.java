/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CNTRInventoryReportBC.java
*@FileTitle : EQ Operation Trend (Inventory Trend)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.05.04 김종준
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtCntrListVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtCodeCommonVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtOptionVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtSmryVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.StockByCntrListVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.StockSmryVO;
import com.hanjin.apps.alps.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.TrendListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Containersupplydemandforecast Business Logic Command Interface<br>
 * - ALPS-Containersupplydemandforecast에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author kim jong jun
 * @see Ees_cim_0001EventResponse 참조
 * @since J2EE 1.4
 */

public interface CNTRInventoryReportBC {
	/**
	 * 지역기준의 CNTR 재고관리 운영지표인 Inventory Trend 조회 <br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<TrendListVO>
	 * @exception EventException
	 */
	public List<TrendListVO> searchTrendListByInvt(InvtOptionVO invtOptionVO) throws EventException;

	/**
	 * 현재일을 기준으로 주차와,년월을 구해 주어진 기간의 주차와,년월을 조회<br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return InvtOptionVO
	 * @exception EventException
	 */
	public InvtOptionVO searchDefaultMonthWeek(InvtOptionVO invtOptionVO) throws EventException;
	

	/**
	 * 주어진 기간의 주차와,년월 목록을 조회<br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<TrendListVO>
	 * @exception EventException
	 */
	public List<TrendListVO> searchMonthWeekList(InvtOptionVO invtOptionVO) throws EventException;
	
	/**
	 * 컨테이너 TYPE/SIZE 목록을 조회<br>
	 * 
	 * @return List<InvtCodeCommonVO>
	 * @exception EventException
	 */
	public List<InvtCodeCommonVO> searchCntrTypeSizeList() throws EventException;
	
	/**
	 * 지역별,EQ TY/SZ 별 Long Staying Ratio를 조회<br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<TrendListVO>
	 * @exception EventException
	 */
	public List<TrendListVO> searchTrendListByLongStaying(InvtOptionVO invtOptionVO) throws EventException;

	/**
	 * Land 및 Sea 구간의 Full & MTY CNTR 재고를 Lease Term으로 구분하여 조회<br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtSmryVO>
	 * @exception EventException
	 */
	public List<InvtSmryVO> searchTotalInvtList(InvtOptionVO invtOptionVO) throws EventException;
	
	/**
	 * Land Inventory with Optimum Stock 화면에서 Location 별로 구분하여 조회<br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtSmryVO>
	 * @exception EventException
	 */
	public List<InvtSmryVO> searchInvtOptmStkList(InvtOptionVO invtOptionVO) throws EventException;	
	
	/**
	 * batch week, this week 조회<br>
	 * 
	 * @return List<InvtOptionVO>
	 * @exception EventException
	 */
	public List<InvtOptionVO> searchYearWk() throws EventException;	
	
	/**
	 * Land의 CNTR 재고를 Lease Term,Movement Status 별로 구분하여 조회<br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtSmryVO>
	 * @exception EventException
	 */
	public List<InvtSmryVO> searchLandInvtListByTerm(InvtOptionVO invtOptionVO) throws EventException;
	
	/**
	 * Land의 CNTR 재고를 Location별로 구분하여 조회<br> 
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtSmryVO>
	 * @exception EventException
	 */
	public InvtSmryVO[] searchLandInvtListByLoc(InvtOptionVO invtOptionVO) throws EventException;

	/**
	 * 조회시점 기준, 해상에 VVD별로 소재하고 있는 컨테이너의 Lease Term 별,Style(FL/MTY) 수량 조회<br> 
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtSmryVO>
	 * @exception EventException
	 */
	public List<InvtSmryVO> searchSeaInvtListInvt(InvtOptionVO invtOptionVO) throws EventException;

	/**
	 * 조회시점 기준, 해상에 VVD별로 소재하고 있는 컨테이너의 POL/POD 별 수량 조회<br> 
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtSmryVO>
	 * @exception EventException
	 */
	public List<InvtSmryVO> searchSeaInvtListByPolPod(InvtOptionVO invtOptionVO) throws EventException;

	/**
	 * 조회시점 기준, 해상에 VVD별로 소재하고 있는 컨테이너 번호,관련 Booking 및 장비관리 정보 조회 <br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtCntrListVO>
	 * @exception EventException
	 */
	public List<InvtCntrListVO> searchSeaInvtListByCntr(InvtOptionVO invtOptionVO) throws EventException;

	/**
	 * 조회시점 기준, 지역별로 소재하고 있는 컨테이너 넘버 및 관련 Booking 및 장비관리 정보를 조회<br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<InvtCntrListVO>
	 * @exception EventException
	 */
	public List<InvtCntrListVO> searchCntrListByLoc(InvtOptionVO invtOptionVO) throws EventException;

	/**
	 * 구주지역내 장비수급 계획을 감안하여, 금일 기준의 Available 장비 대수를 조회한다. <br>
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<StockSmryVO>
	 * @exception EventException
	 */
	
	public List<StockSmryVO> searchStockList(InvtOptionVO invtOptionVO) throws EventException;
	/**
	 * 구주지역내 SCC 또는 Yard별 MT 재고를 컨테이너별로 조회한다.(팝업)
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<StockByCntrListVO>
	 * @exception EventException
	 */
	public List<StockByCntrListVO> searchStockCntrList(InvtOptionVO invtOptionVO) throws EventException;

	/**
	 * 구주지역내 MTY 컨테이너의 Release/ Redelivery Order 승인리스트를 확인하여, 해당야드에 반입/ 반출되는 컨테이너 정보를 조회한다.(팝업)
	 * 
	 * @param InvtOptionVO invtOptionVO
	 * @return List<StockByCntrListVO>
	 * @exception EventException
	 */
	public List<StockByCntrListVO> searchStockDueDateList(InvtOptionVO invtOptionVO) throws EventException;

	/**
	 * 구주지역의 특정 LCC/ECC Level 내의 가용 MTY 재고를 Yard별로 생성,수정<br>
	 * 
	 * @param StockSmryVO[] stockSmryVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageStock(StockSmryVO[] stockSmryVOs,SignOnUserAccount account) throws EventException;
	
}