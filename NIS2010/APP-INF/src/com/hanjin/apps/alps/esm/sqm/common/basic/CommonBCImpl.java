/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : CommonBCImpl.java
*@FileTitle      : Common
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.06
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.06 SQM USER
* 1.0 Creation
* 2013.12.10 PEJ [CHM-201328059] IAS Region 추가
* 2014.01.16 PEJ [CHM-201328244] IAS Sector Sales 판매시스템 개발
* 2014.08.16 이혜민 [CHM-201431396] Portion Adjustment 화면의 Office 신규 row add 버튼 생성
* 2015.07.09 김용습 [CHM-201536817] [CSR 전환건] Final QTA Adjustment > Post QTA Adjustment > QTA Edit for IAS Sector 화면 내 Week 조회 로직 수정
* 2016.01.28 최성민 [CHM-201639851] Basic Data Creation for IAS Secotr 화면의 Creation 로직 변경
* 2016.07.15 CHM-201642546 Allocation = QTA Adjustment 화면 Office Add 버튼 추가
* 2016.08.11 Basic CMCB (CM Cost Per Box) 화면 Add Creation 버튼 추가

=========================================================*/
package com.hanjin.apps.alps.esm.sqm.common.basic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.esm.sqm.common.integration.CommonDBDAO;
import com.hanjin.apps.alps.esm.sqm.common.vo.CommonVO;
import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.common.vo.SearchCommonCodeVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-Common Business Logic Command Interface<br>
 * - ALPS-Common에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author SQM USER
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
     *                      07. R.Lane List                 : rLane
     *                      08. RHQ List(sqm view)          : rhq
     *                      09. Office List(sqm view)       : office
     *                      10. Create Period               : cPeriod
     *                      11. Next Quarter                : nextQta
     *                      12. RHQ List(SQM_QTA_OFC)       : rhqForPlan
     *                      13. Office List(SQM_QTA_OFC)    : officeForPlan
     *                      14. Group Customer              : groupCustomer
     *                      15. VVD COPY List               : vvd
     *                      16. Spcl VVD COPY List          : spclVvd
     *                      17. Adjustment Lane List        : adjLane
     *                      18. Spcl Adjustment Lane List   : spclAdjLane
     *                      //19. Lane Master R.Lane List     : laneMaster
     *                      20. Current Quarter             : currentQta
     *                      21. IAS Region                  : iasRegion
     *                      22. Trade List (MDM)            : mdmTrade
     *                      23. PF Group List (SQM_SCTR_PAIR_MGMT)  : pfGroup
     *                      24. Rlane List(MDM)  : mdmRLane
     *                      25. 노선별 VVD List        : controlVvdList(f_bse_tp_cd|f_bse_yr|f_bse_qta_cd|trd_cd|sub_trd_cd)
     *                      26. Lane Office Relation Setting 화면의 RHQ List
     *                      27. Lane Office Relation Setting 화면의 RHQ 별 Office List
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
			}else if(codeItem.equalsIgnoreCase("iasRegion")){	
				codeItem = "CD03218";
			}
			
			if(codeItem.equalsIgnoreCase("year")){					// 1. Year List
				dRs = dbDao.searchYearList();
			}else if(codeItem.equalsIgnoreCase("quarter")){			// 2. Quarter List
				dRs = dbDao.searchQuarterList();
			}else if(codeItem.equalsIgnoreCase("officeView")){		// 3. Office View List
				dRs = dbDao.searchOfficeViewList();
			}else if(codeItem.equalsIgnoreCase("trade")){			// 4. Trade List (Over All Trade List : SQM_QTA_LANE_MGMT Not Sector Sales Trade)
				dRs = dbDao.searchTradeList(code);
			}else if(codeItem.equalsIgnoreCase("subTrade")){		// 5. Sub Trade List
				dRs = dbDao.searchSubTradeList(code);
			}else if(codeItem.equalsIgnoreCase("hoTeams")){			// 6. H/O Teams List
				dRs = dbDao.searchHoTeamsList(code);
			}else if(codeItem.equalsIgnoreCase("rLane")){			// 7. R.Lane List
				dRs = dbDao.searchRLaneList(code);
			}else if(codeItem.equalsIgnoreCase("rhq")){				// 8. RHQ List
				dRs = dbDao.searchRhqList();
			}else if(codeItem.equalsIgnoreCase("office")){			// 9. Office List
				dRs = dbDao.searchOfficeList(code);
			}else if(codeItem.equalsIgnoreCase("cPeriod")){			// 10. Create Period
				dRs = dbDao.searchCPeriodList(code);
			}else if(codeItem.equalsIgnoreCase("nextQta")){			// 11. Next Quarter
				dRs = dbDao.searchNextQtaList();
			}else if(codeItem.equalsIgnoreCase("rhqForPlan")){		// 12. RHQ List(SQM_QTA_OFC)
				dRs = dbDao.searchRhqForPlanList();
			}else if(codeItem.equalsIgnoreCase("officeForPlan")){	// 13. Office List(SQM_QTA_OFC)
				dRs = dbDao.searchOfcForPlanList(code);
			}else if(codeItem.equalsIgnoreCase("groupCustomer")){	// 14. Group Customer
				dRs = dbDao.searchGroupCustomer(code);
			}else if(codeItem.equalsIgnoreCase("vvd")){				// 15. VVD COPY List
				dRs = dbDao.searchVvdList(code);
			}else if(codeItem.equalsIgnoreCase("spclVvd")){			// 16. Spcl VVD COPY List
				dRs = dbDao.searchSpclVvdList(code);
			}else if(codeItem.equalsIgnoreCase("adjLane")){			// 17. Adjustment Lane List
				dRs = dbDao.searchAdjLaneList(code);
			}else if(codeItem.equalsIgnoreCase("spclAdjLane")){		// 18. Spcl Adjustment Lane List
				dRs = dbDao.searchSpclAdjLaneList(code);
			}else if(codeItem.equalsIgnoreCase("currentQta")){		// 20. Current Quarter
				dRs = dbDao.searchCurrentQtaList();
			}else if(codeItem.equalsIgnoreCase("subTradeSector")){	// 21. Sub Trade List
				dRs = dbDao.searchSubTradeSectorList(code);
			}else if(codeItem.equalsIgnoreCase("mdmTrade")){	// 22. Trade List (MDM)
				dRs = dbDao.searchMdmTradeList();
			}else if(codeItem.equalsIgnoreCase("pfGroupPair")||codeItem.equalsIgnoreCase("pfGroupOfc")||codeItem.equalsIgnoreCase("pfGroup")){	   // 23. PF Group List (SQM_SCTR_PAIR_MGMT)
				dRs = dbDao.searchPfGroupList(code, codeItem);
			}else if(codeItem.equalsIgnoreCase("mdmRLane")){	// 24. RLane List (MDM)
				dRs = dbDao.searchMdmRLaneList(code);
			}else if(codeItem.equalsIgnoreCase("controlVvdList")){	    //  13. 노선별 VVD List        : controlVvdList(f_bse_tp_cd|f_bse_yr|f_bse_qta_cd|trd_cd|sub_trd_cd)
				dRs = dbDao.searchControlRLaneVvdList(code);				
			}else if(codeItem.equalsIgnoreCase("LaneRHQ")){	    // 26. Lane Office Relation Setting 화면의 RHQ List
				dRs = dbDao.searchLaneRHQList(code);				
			}else if(codeItem.equalsIgnoreCase("LaneOffice")){	    //  27. Lane Office Relation Setting 화면의 RHQ 별 Office List
				dRs = dbDao.searchLaneOfficeList(code);
				
			}else{
				//공통코드
				Collection codeList2 = null;
				codeList2 = com.hanjin.framework.component.util.code.CodeUtil.getInstance().getCodeSelect(codeItem,0);
				Iterator iterator = codeList2.iterator();
				
				com.hanjin.framework.component.util.code.CodeInfo codeModel2 = null;
				
				while (iterator.hasNext()) {
					codeModel2 = (com.hanjin.framework.component.util.code.CodeInfo) iterator.next();
					
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
	 *  					01. Trade 권한제어			: tradeControl
	 *  					02. lane 권한제어			: rLaneControl
	 *  					03. Offce 조회				: activeOfc
	 *  					04. Month 조회    			: searchMonth
	 *  					05. Week 조회				: searchWeek
	 *  					06. bound 권한제어			: searchBoundControl
	 *  					07. Lane Master의 Lane 정보 : searchRLaneSector
	 *                      08. POL CD 조회           	: searchPolCdSectorList
	 *                      09. POD CD 조회           	: searchPodCdSectorList
	 *                      10. Multi Rlane POL CD 조회  : searchPolCdSectorMultiList
	 *                      11. Multi Rlane POD CD 조회  : searchPodCdSectorMultiList
	 *                      12. SQM_SCTR_PF_GRP 기준의 lane 정보               :rLaneControlSector(f_bse_tp_cd|f_bse_yr|f_bse_qta_cd|f_sub_trd_cd|f_ias_rgn_cd)
	 *                      13. BSA List                                    : bsaSector
	 *                      14. Lane-Office Relation 기준의 Lane 정보         : rLaneOfc
	 *                      15. Portion Adjustment by HO 시트 내 RHQ 조회     : rhqByPortion
	 *                      16. Portion Adjustment by RHQ 시트 내 OFFICE 조회 : ofcByPortion
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
			}else if(codeItem.equalsIgnoreCase("activeOfc")){	    // 03. Office 조회
				dRs = dbDao.searchActiveOfc(conditionVO);
			}else if(codeItem.equalsIgnoreCase("month")){	        // 04. Month 조회
				dRs = dbDao.searchMonth(conditionVO);
			}else if(codeItem.equalsIgnoreCase("week")){	        // 05. Week 조회
				dRs = dbDao.searchWeek(conditionVO);
			}else if(codeItem.equalsIgnoreCase("BoundControl")){	// 06. bound 권한제어
				dRs = dbDao.searchBoundControl(conditionVO,code);
			}else if(codeItem.equalsIgnoreCase("rLaneSector")){	    // 07. lane sector 조회
				dRs = dbDao.searchRLaneSector(conditionVO,code);
			}else if(codeItem.equalsIgnoreCase("polCdSector")||codeItem.equalsIgnoreCase("polCdSectorOfc")){		// 08. POL CD List
				dRs = dbDao.searchPolCdSectorList(conditionVO,code,codeItem);
			}else if(codeItem.equalsIgnoreCase("podCdSector")||codeItem.equalsIgnoreCase("podCdSectorOfc")){		// 09. POD CD List
				dRs = dbDao.searchPodCdSectorList(conditionVO,code,codeItem);
			}else if(codeItem.equalsIgnoreCase("polCdSectorMulti")){		// 10. POL CD Multi List
				dRs = dbDao.searchPolCdSectorMultiList(conditionVO,codeItem);
			}else if(codeItem.equalsIgnoreCase("podCdSectorMulti")){		// 11. POD CD Multi List
				dRs = dbDao.searchPodCdSectorMultiList(conditionVO,codeItem);
			}else if(codeItem.equalsIgnoreCase("rLaneControlSector")){	    // 12. Lane-Office Relation 기준의 lane 정보 조회 [sector]
				dRs = dbDao.searchRLaneControlSector(conditionVO);
			}else if(codeItem.equalsIgnoreCase("bsaSector")){ // 13. 노선에 대한 BSA 정보조회
				dRs = dbDao.searchLaneBSA(conditionVO);
			}else if(codeItem.equalsIgnoreCase("rLaneOfc")){ // 14. Lane-Office Relation 기준의 Lane 정보
				dRs = dbDao.searchLaneOfcList(conditionVO);
			}else if(codeItem.equalsIgnoreCase("rhqByPortion")){	    // 15. Portion Adjustment by HO 시트 내 RHQ 조회
				dRs = dbDao.searchRhqListByPortion(conditionVO);
			}else if(codeItem.equalsIgnoreCase("ofcByPortion")){	    // 16. Portion Adjustment by RHQ 시트 내 OFFICE 조회
				dRs = dbDao.searchOfcListByPortion(conditionVO);
			}else if(codeItem.equalsIgnoreCase("revisedWeekForSector")){	    // 17. QTA Edit for IAS Sector의 Week 콤보 세팅(QTA Adjustment by VVD for IAS Sector 기준으로)
				dRs = dbDao.searchRevisedWeekForSector(conditionVO);
			}else if(codeItem.equalsIgnoreCase("revisedWeekForOverall")){	    // 18. QTA Edit의 Week 콤보 세팅(QTA Adjustment by VVD 기준으로)
				dRs = dbDao.searchRevisedWeekForOverall(conditionVO);
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
	   
		/**
		 * BATCH status 를 생성한다. <br>
		 *
		 * @param CommonVO commonVO
		 * @param SignOnUserAccount account
		 * @throws EventException
		 */
		public void addBatchStatus(CommonVO commonVO, SignOnUserAccount account) throws EventException {
			try {							
				commonVO.setFUsrId(account.getUsr_id());
				dbDao.addBatchStatus( commonVO );				
			} catch (DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage(),ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage(),ex);
			}
		}


		/**
		 * BATCH의 STATUS를 알아본다.
		 * 
		 * @param CommonVO commonVO
		 * @return String
		 * @exception EventException
		 */
		public String searchBatchStatus(CommonVO commonVO) throws EventException {
			try {
				return dbDao.searchBatchStatus(commonVO);
			} catch (DAOException de) {
				 throw new EventException(de.getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new EventException(new ErrorHandler(ex).getMessage());
			}
		}
}