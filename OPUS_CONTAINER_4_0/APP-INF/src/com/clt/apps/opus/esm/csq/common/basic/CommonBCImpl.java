/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : CommonBCImpl.java
*@FileTitle      : Common
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.06
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.06 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.common.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.clt.apps.opus.esm.csq.common.integration.CommonDBDAO;
import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.apps.opus.esm.csq.common.vo.SearchCommonCodeVO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Common Business Logic Command Interface<br>
 * - ALPS-Common에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author CSQ USER
 * @see CommonDBDAO 각 DAO 클래스 참조
 * @since J2EE 1.6
 */

public class CommonBCImpl extends BasicCommandSupport implements CommonBC {
	
	// Database Access Object
	private transient CommonDBDAO dbDao=null;
	
	/**
	 * LaneSimulationBCImpl 객체 생성<br>
	 * LaneSimulationDBDAO를 생성한다.<br>
	 */
	public CommonBCImpl(){
		dbDao = new CommonDBDAO();
	}
	
	/**
	 * default combo, ibsheet codelist 를 return <p>
	 * 
     * @param codeItem      업무 구분
     *                      01. Year List                   : Year
     *                      02. Quarter List                : quarter
     *                      03. Office View List            : officeView
     *                      04. Trade List(OverAll)         : trade
     *                      05. Sub Trade List              : subTrade
     *                      06. H/O Teams List              : hoTeams
     *                      07. Ovarall R.Lane List         : rLane
     *                      07. Sector R.Lane List			: rLaneSector
     *                      08. RHQ List(csq view)          : rhq
     *                      09. Office List(csq view)       : office
     *                      10. Create Period               : cPeriod
     *                      11. Next Quarter                : nextQta
     *                      12. RHQ List(CSQ_QTA_OFC)       : rhqForPlan
     *                      13. Office List(CSQ_QTA_OFC)    : officeForPlan
     *                      14. Group Customer              : groupCustomer
     *                      15. VVD COPY List               : vvd
     *                      20. Current Quarter             : currentQta
     *                      22. Trade List (MDM)            : mdmTrade
     *                      23. PF Group List				: pfGroup
     *                      24. Rlane List(MDM)  			: mdmRLane
     *                      25. 노선별 VVD List        		: controlVvdList
	 *                      
	 * @param String codeItem		Where 절에 들어갈 코드그룹
	 * @param String code			Where 절에 들어갈 코드조건값
	 * @return List<SearchCommonCodeVO>
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCommonCodeVO> getCodeSelectList(String codeItem, String code) throws EventException {
		List<SearchCommonCodeVO> list = new ArrayList<SearchCommonCodeVO>();
		DBRowSet dRs = null;
		
		try {
			
			// 공통 코드 정보로 변경
			if(codeItem.equalsIgnoreCase("comCodeBound")){
				codeItem = "CD00593";
			}else if(codeItem.equalsIgnoreCase("comCodeOutNonOutBound")){
				codeItem = "CD03232";
			}else if(codeItem.equalsIgnoreCase("comCodeOfficLevel")){
				codeItem = "CD03222";
			}else if(codeItem.equalsIgnoreCase("comCodeQtaStep")){
				codeItem = "CD03225";
			}else if(codeItem.equalsIgnoreCase("comCodeOfcLvl")){
				codeItem = "CD03241";
			}else if(codeItem.equalsIgnoreCase("comCodeTrdDir")){
				codeItem = "CD03217";
			}else if(codeItem.equalsIgnoreCase("comCodeAccGrp")){
				codeItem = "CD03224";
			}else if(codeItem.equalsIgnoreCase("comCodecngTp")){
				codeItem = "CD03229";
			}else if(codeItem.equalsIgnoreCase("comCodeYn")){
				codeItem = "CD01506";
			}
			
			if(codeItem.equalsIgnoreCase("year")){					// 1. Year List
				dRs = dbDao.searchYearList();
			}else if(codeItem.equalsIgnoreCase("quarter")){			// 2. Quarter List
				dRs = dbDao.searchQuarterList();
			}else if(codeItem.equalsIgnoreCase("officeView")){		// 3. Office View List
				dRs = dbDao.searchOfficeViewList();
			}else if(codeItem.equalsIgnoreCase("trade")){			// 4. Trade List (Over All Trade List : CSQ_QTA_LANE_MGMT Not Sector Sales Trade)
				dRs = dbDao.searchTradeList(code);
			}else if(codeItem.equalsIgnoreCase("mdmSubTrade")){		// 5. Sub Trade List
				dRs = dbDao.searchMdmSubTradeList(code);
			}else if(codeItem.equalsIgnoreCase("subTrade")){		// 5. Sub Trade List
				dRs = dbDao.searchSubTradeList(code);
			}else if(codeItem.equalsIgnoreCase("hoTeams")){			// 6. H/O Teams List
				dRs = dbDao.searchHoTeamsList(code);
			}else if(codeItem.equalsIgnoreCase("rLane")){			// 7. Overall R.Lane List
				dRs = dbDao.searchRLaneList(code);
			}else if(codeItem.equalsIgnoreCase("rLaneSector")){		// 7. Sector R.Lane List
				dRs = dbDao.searchRLaneSectorList(code);
			}else if(codeItem.equalsIgnoreCase("rhq")){				// 8. RHQ List
				dRs = dbDao.searchRhqList();
			}else if(codeItem.equalsIgnoreCase("office")){			// 9. Office List
				dRs = dbDao.searchOfficeList(code);
			}else if(codeItem.equalsIgnoreCase("cPeriod")){			// 10. Create Period
				dRs = dbDao.searchCPeriodList(code);
			}else if(codeItem.equalsIgnoreCase("nextQta")){			// 11. Next Quarter
				dRs = dbDao.searchNextQtaList();
			}else if(codeItem.equalsIgnoreCase("rhqForPlan")){		// 12. RHQ List(CSQ_QTA_OFC)
				dRs = dbDao.searchRhqForPlanList();
			}else if(codeItem.equalsIgnoreCase("officeForPlan")){	// 13. Office List(CSQ_QTA_OFC)
				dRs = dbDao.searchOfcForPlanList(code);
			}else if(codeItem.equalsIgnoreCase("groupCustomer")){	// 14. Group Customer
				dRs = dbDao.searchGroupCustomer(code);
			}else if(codeItem.equalsIgnoreCase("vvd")){				// 15. VVD COPY List
				dRs = dbDao.searchVvdList(code);
			}else if(codeItem.equalsIgnoreCase("currentQta")){		// 20. Current Quarter
				dRs = dbDao.searchCurrentQtaList();
			}else if(codeItem.equalsIgnoreCase("subTradeSector")){	// 21. Sub Trade List
				dRs = dbDao.searchSubTradeSectorList(code);
			}else if(codeItem.equalsIgnoreCase("mdmTrade")){		// 22. Trade List (MDM)
				dRs = dbDao.searchMdmTradeList();
			}else if(codeItem.equalsIgnoreCase("pfGroupPair")||codeItem.equalsIgnoreCase("pfGroupOfc")){	   // 23. PF Group List (CSQ_SCTR_PAIR_MGMT)
				dRs = dbDao.searchPfGroupList(code, codeItem);
			}else if(codeItem.equalsIgnoreCase("mdmRLane")){		// 24. RLane List (MDM)
				dRs = dbDao.searchMdmRLaneList(code);
			}else if(codeItem.equalsIgnoreCase("controlVvdList")){	//  25. 노선별 VVD List
				dRs = dbDao.searchControlRLaneVvdList(code);
				
			}else{
				//공통코드
				Collection codeList2 = null;
				codeList2 = com.clt.framework.component.util.code.CodeUtil.getInstance().getCodeSelect(codeItem,0);
				Iterator iterator = codeList2.iterator();
				
				com.clt.framework.component.util.code.CodeInfo codeModel2 = null;
				
				while (iterator.hasNext()) {
					codeModel2 = (com.clt.framework.component.util.code.CodeInfo) iterator.next();
					
					if (codeModel2 != null){
						SearchCommonCodeVO vo = new SearchCommonCodeVO();
						vo.setCode(codeModel2.getCode());
						vo.setName(codeModel2.getName());
						list.add(vo);
					}
				}
			}
			
			if (dRs != null){
				list = (List) RowSetUtil.rowSetToVOs(dRs, SearchCommonCodeVO.class);
			}
			
		} catch(SQLException se){
			log.error("SQLException : " +se.getMessage());
			throw new EventException("SQLException : " + se.getMessage());
		} catch (DAOException de) {
			log.error("DAOException : " +de.getMessage());
			throw new EventException("DAOException : " + de.getMessage());
		} catch(Exception ex){
			log.error("Exception : " +ex.getMessage());
			throw new EventException("Exception : " + ex.getMessage());
		}
		return list;
	}
	
	/**
	 * default combo, ibsheet codelist를 return <p>
	 * 
	 * <br><b>Example : </b>
	 * <pre>
	 *     String array[][] = {{"trade","",""}};
	 *     eventResponse = CodeUtil.getMakeCodeSelectList(eventResponse,array);
	 * </pre>
	 * 
	 * @param GeneralEventResponse eventResponse
	 * @param String[][] array
	 * @return GeneralEventResponse
	 * @throws EventException
	 */
	public GeneralEventResponse getMakeCodeSelectList(GeneralEventResponse eventResponse, String[][] array) throws EventException {
		List<SearchCommonCodeVO> list = new ArrayList<SearchCommonCodeVO>();
		SearchCommonCodeVO combovo1 = new SearchCommonCodeVO();
		SearchCommonCodeVO combovo2 = new SearchCommonCodeVO();
		
		try {
			for(int i=0 ; i< array.length ; i++) {
				list = getCodeSelectList((array[i][0]).toString(), array[i][1]);
				if (array[i][2].equals("All")){
					combovo1.setName("All");
					combovo1.setCode("All");
					combovo2 = (SearchCommonCodeVO) combovo1.clone();
					list.add(0,combovo2);
				}else if (array[i][2].equals("Blank")){
					combovo1.setName(" ");
					combovo1.setCode(" ");
					combovo2 = (SearchCommonCodeVO) combovo1.clone();
					list.add(0,combovo2);
				}
				eventResponse.setRsVoList(list);
			}
		} catch(Exception ex){
			log.error("Exception : " +ex.getMessage());
			throw new EventException("Exception : " + ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 계정에 따른 combo, ibsheet codelist를 return <p>
	 * 
	 * <br><b>Example : </b>
	 * <pre>
	 *     String array[][] = {{"trade","",""}};
	 *     eventResponse = CodeUtil.getMakeCodeSelectList(eventResponse,array);
	 * </pre>
	 * 
	 * @param ConditionVO conditionVO   
	 * @param SignOnUserAccount account
	 * @param String[][] array
	 * @return GeneralEventResponse
	 * @throws EventException
	 */
	public GeneralEventResponse getMakeCodeSelectListForPlanning(ConditionVO conditionVO, SignOnUserAccount account, String[][] array) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<SearchCommonCodeVO> list = new ArrayList<SearchCommonCodeVO>();
		SearchCommonCodeVO combovo1 = new SearchCommonCodeVO();
		SearchCommonCodeVO combovo2 = new SearchCommonCodeVO();
		
		try {
			for(int i=0 ; i< array.length ; i++) {
				list = getCodeSelectListForPlanning(conditionVO,(array[i][0]).toString(), account.getOfc_cd());
				
				if (array[i][2].equals("All")){
					combovo1.setName("All");
					combovo1.setCode("All");
					combovo2 = (SearchCommonCodeVO) combovo1.clone();
					list.add(0,combovo2);
				}else if (array[i][2].equals("Blank")){
					combovo1.setName(" ");
					combovo1.setCode(" ");
					combovo2 = (SearchCommonCodeVO) combovo1.clone();
					list.add(0,combovo2);
				}
				eventResponse.setRsVoList(list);
			}
		} catch(Exception ex){
			log.error("Exception : " +ex.getMessage());
			throw new EventException("Exception : " + ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 계정에 따른 combo, ibsheet codelist 를 return <p>
	 * 
	 * @param codeItem  	업무 구분
	 *  					01. Trade 권한제어						 		 : tradeControl
	 *  					02. lane 권한제어						 		 : rLaneControl
	 *  					03. Offce 조회						 		 : activeOfc
	 *  					04. Month 조회    						 		 : searchMonth
	 *  					05. Week 조회							 		 : searchWeek
	 *  					06. bound 권한제어						 		 : searchBoundControl
	 *                      08. POL CD 조회           					 		 : searchPolCdSectorList
	 *                      09. POD CD 조회           					    	 : searchPodCdSectorList
	 *                      10. Multi Rlane POL CD 조회  			 		 : searchPolCdSectorMultiList
	 *                      11. Multi Rlane POD CD 조회 			 		 : searchPodCdSectorMultiList
	 *                      13. BSA List                         		 : bsaSector
	 *                      15. Portion Adjustment by HO 시트 내 RHQ 조회     	 : rhqByPortion
	 *                      16. Portion Adjustment by RHQ 시트 내 OFFICE 조회  : ofcByPortion
	 *  
	 * @param ConditionVO conditionVO                     
	 * @param String codeItem		Where 절에 들어갈 코드그룹
	 * @param String code			Where 절에 들어갈 코드조건값
	 * @return List<SearchCommonCodeVO>
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCommonCodeVO> getCodeSelectListForPlanning(ConditionVO conditionVO,String codeItem, String code) throws EventException {
		List<SearchCommonCodeVO> list = new ArrayList<SearchCommonCodeVO>();
		DBRowSet dRs = null;
		
		try {
			
			if(codeItem.equalsIgnoreCase("tradeControl")){	        // 01. Trade 권한제어
				dRs = dbDao.searchTradeControl(conditionVO,code);
			}else if(codeItem.equalsIgnoreCase("rLaneControl")){	// 02. lane 권한제어
				dRs = dbDao.searchRLaneControl(conditionVO,code);
			}else if(codeItem.equalsIgnoreCase("month")){	        // 04. Month 조회
				dRs = dbDao.searchMonth(conditionVO);
			}else if(codeItem.equalsIgnoreCase("week")){	        // 05. Week 조회
				dRs = dbDao.searchWeek(conditionVO);
			}else if(codeItem.equalsIgnoreCase("BoundControl")){	// 06. bound 권한제어
				dRs = dbDao.searchBoundControl(conditionVO,code);
			}else if(codeItem.equalsIgnoreCase("polCdSector")||codeItem.equalsIgnoreCase("polCdSectorOfc")){		// 08. POL CD List
				dRs = dbDao.searchPolCdSectorList(conditionVO,code,codeItem);
			}else if(codeItem.equalsIgnoreCase("podCdSector")||codeItem.equalsIgnoreCase("podCdSectorOfc")){		// 09. POD CD List
				dRs = dbDao.searchPodCdSectorList(conditionVO,code,codeItem);
			}else if(codeItem.equalsIgnoreCase("polCdSectorMulti")){		// 10. POL CD Multi List
				dRs = dbDao.searchPolCdSectorMultiList(conditionVO,codeItem);
			}else if(codeItem.equalsIgnoreCase("podCdSectorMulti")){		// 11. POD CD Multi List
				dRs = dbDao.searchPodCdSectorMultiList(conditionVO,codeItem);
			}else if(codeItem.equalsIgnoreCase("bsaSector")){ 				// 13. 노선에 대한 BSA 정보조회
				dRs = dbDao.searchLaneBSA(conditionVO);
			}else if(codeItem.equalsIgnoreCase("rhqByPortion")){	    	// 15. Portion Adjustment by HO 시트 내 RHQ 조회
				dRs = dbDao.searchRhqListByPortion(conditionVO);
			}else if(codeItem.equalsIgnoreCase("ofcByPortion")){	    	// 16. Portion Adjustment by RHQ 시트 내 OFFICE 조회
				dRs = dbDao.searchOfcListByPortion(conditionVO);
			}else if(codeItem.equalsIgnoreCase("pfGroupPlan")){	   // 23. PF Group List (CSQ_SCTR_PAIR_MGMT)
				dRs = dbDao.searchPfGroupPlanList(conditionVO);
			}
			
			if (dRs != null){
				list = (List) RowSetUtil.rowSetToVOs(dRs, SearchCommonCodeVO.class);
			}
			
		} catch(SQLException se){
			log.error("SQLException : " +se.getMessage());
			throw new EventException("SQLException : " + se.getMessage());
		} catch (DAOException de) {
			log.error("DAOException : " +de.getMessage());
			throw new EventException("DAOException : " + de.getMessage());
		} catch(Exception ex){
			log.error("Exception : " +ex.getMessage());
			throw new EventException("Exception : " + ex.getMessage());
		}
		return list;
	}
	
	   /**
		 * IBSheet의 동적 콤보가 있을경우 Retrieve시 각각의 콤보를 세팅해 주어야 할때 사용한다.
		 * 
 		 * @param codeItem      반환할 업무 대상
		 *                      01. 노선별 VVD List        : controlVvdList(f_bse_tp_cd|f_bse_yr|f_bse_qta_cd|trd_cd|sub_trd_cd)
		 *                      
		 * @param searchCode Where 절의 조건
		 * @return
		 * @throws EventException
		 */
	   @SuppressWarnings("unchecked")
		public HashMap<String, String> getCodeIbCombo(String codeItem, String searchCode) throws EventException {
			HashMap<String, String> h = new HashMap<String, String>();
			StringBuffer sbValue = new StringBuffer();
			List<SearchCommonCodeVO> totalList = new ArrayList();
			
			try{
				totalList = getCodeSelectList(codeItem, searchCode);
				String tmpStr = "";
				SearchCommonCodeVO vo = null;
				for(int i=0 ; i< totalList.size() ; i++) {
					vo = totalList.get(i);
					if (vo.getCode() == null) vo.setCode("");
					
					if (tmpStr.equals(vo.getCode()) || tmpStr.equals("")){
						sbValue.append("|");
						sbValue.append(vo.getName());
						tmpStr = vo.getCode();
					}else{
						h.put(tmpStr, " " +sbValue.toString());
						sbValue = new StringBuffer();
						sbValue.append("|");
						sbValue.append(vo.getName());
						tmpStr = vo.getCode();
					}
					
				}
				
				if(!sbValue.toString().equals("")){
						h.put(tmpStr, " " +sbValue.toString());
				}		
			} catch(Exception ex){
		 		   log.error("Exception : " +ex.getMessage());
		 		   throw new EventException("Exception : " + ex.getMessage());
		       }
			return h;		
			
		}	
}