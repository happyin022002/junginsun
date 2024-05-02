/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ForecastReportBCImpl.java
*@FileTitle : Forecast Report
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.integration.ForecastReportDBDAO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.vo.EesEqr1048ConditionVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.vo.ForecastReportCommonListVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.vo.ForecastReportListVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.vo.ForecastReportOptionVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.vo.ForecastReportVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.forecastreport.vo.PlannedRepoInVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.EqrCtrlPlnRepoInQtyVO;
import com.clt.syscommon.common.table.EqrCtrlPlnRepoInVO;

/**
 * OPUS-MTYWeeklySimulation Business Logic Basic Command implementation<br>
 * - OPUS-MTYWeeklySimulation 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see EES_CIM_1003EventResponse,MTYWeeklySimulationBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ForecastReportBCImpl extends BasicCommandSupport implements ForecastReportBC {

	// Database Access Object
	private transient ForecastReportDBDAO dbDao = null;

	/**
	 * MTYEquipmentForecastBCImpl 객체 생성<br>
	 * MTYEquipmentForecastDBDAO를 생성한다.<br>
	 */
	public ForecastReportBCImpl() {
		dbDao = new ForecastReportDBDAO();
	}
	
	/**
	 *  지점별로 향후 -2~+7 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param ForecastReportOptionVO forecastReportOptionVO
	 * @param SignOnUserAccount account
	 * @return CommonRsVO
	 * @throws EventException
	 */
	public CommonRsVO searchForecastReportBasic(ForecastReportOptionVO forecastReportOptionVO, SignOnUserAccount account) throws EventException {
		try{
			String locCd         = forecastReportOptionVO.getLocCd();          // RCC select box
			String divFlag 		 = forecastReportOptionVO.getDivFlag();        // 라디오 버튼 (1,2)
			String locTypeCode 	 = forecastReportOptionVO.getLocTypeCode();    // Location By 의 select box
			String subLocCd      = forecastReportOptionVO.getSubLocCd();       // Location By 의 입력값			
			String locTpCdSecond = forecastReportOptionVO.getLocTpCdSecond();  // Location 의 select box			
			String locCdSecond   = forecastReportOptionVO.getLocCdSecond();    // Location 의 입력값
			String locGrpCd      = forecastReportOptionVO.getLocGrpCd();       // Location Group Code 의 입력값
			
			//String loc_grp_cd     = "";
			String presentFlag   = ""; // SELECT 절의 LCC,ECC,SCC 결정
			String conditionFlag = ""; // WHERE 조건의 LCC,ECC,SCC 결정
			String conditionValue = ""; // 검색값
			
			log.debug(">>>>>>>>>>>>> loc_cd       	: " +locCd);
			log.debug(">>>>>>>>>>>>> divFlag       	: " +divFlag);
			log.debug(">>>>>>>>>>>>> locTypeCode 	: " +locTypeCode);
			log.debug(">>>>>>>>>>>>> subLocCd 		: " +subLocCd);
			log.debug(">>>>>>>>>>>>> locTpCdSecond 	: " +locTpCdSecond);
			log.debug(">>>>>>>>>>>>> locCdSecond 	: " +locCdSecond);
			log.debug(">>>>>>>>>>>>> locGrpCd 	    : " +locGrpCd);
			
			// 로직정리 ()
			// RCC 가 ALL 선택
			// RCC 선택되고 Location By, Location 입력값이 없을때
			// RCC 선택되고 라디오 버튼 1 선택, Location By 입력값 있음
			// RCC 서택되고 라디오버튼 2 선택, Location 입력값 있음
			// sheet의 왼쪽 + 버튼 클릭
			
			if(divFlag.equals("0")) { // sheet의 왼쪽 + 버튼 클릭
				if(locGrpCd.equals("L")) {  		// RCC 클릭
					presentFlag   = "L";
					conditionFlag = "R"; 			// 실제 조건은 적용되지 않음.
					conditionValue = locCd; 		// 조회값							
				}else if(locGrpCd.equals("E")) {  	// LCC 클릭
					presentFlag   = "E";
					conditionFlag = "L"; 			// 실제 조건은 적용되지 않음.
					conditionValue = locCd; 		// 조회값									
				}else {                           	// ECC 클릭
					presentFlag   = "S";
					conditionFlag = "E"; 			// 실제 조건은 적용되지 않음.
					conditionValue = locCd; 		// 조회값									
				}
		
			}else if(locCd.equals("") || locCd == null) { // RCC 가 ALL 선택
				presentFlag   = "L";
				conditionFlag = "R"; 	// 실제 조건은 적용되지 않음.
				conditionValue = "";
				
			}else { // RCC ALL 아님
				// RCC 선택되고 Location By, Location 입력값이 없을때
				if((subLocCd.equals("") || subLocCd == null) && (locCdSecond.equals("") || locCdSecond == null)) {
					presentFlag    = "L";
					conditionFlag  = "R";
					conditionValue = locCd; // 조회값
					
				// RCC 선택되고 라디오 버튼 1 선택, Location By 입력값 있음
				}else if(divFlag.equals("1") && subLocCd != null) {
					conditionValue = subLocCd;  // 조회값
					
					if(locTypeCode.equals("RE")) {       // RCC (by ECC)
						presentFlag   = "E";
						conditionFlag = "R";	
						
					}else if(locTypeCode.equals("LE")) { // LCC (by ECC)
						presentFlag   = "E";
						conditionFlag = "L";								
					}else if(locTypeCode.equals("LS")) { // LCC (by SCC)
						presentFlag   = "S";
						conditionFlag = "L";	
					}else {                              // ECC (by SCC)
						presentFlag   = "S";
						conditionFlag = "E";							
					}
				// RCC 서택되고 라디오버튼 2 선택, Location 입력값 있음	
				}else if(divFlag.equals("2") && locCdSecond != null) {
					conditionValue = locCdSecond;  // 조회값
					
					if(locTpCdSecond.equals("L")) {        // LCC
						presentFlag   = "L";
						conditionFlag = "L";							
					}else if(locTpCdSecond.equals("E")) {  // ECC
						presentFlag   = "E";
						conditionFlag = "E";							
					}else {  // SCC
						presentFlag   = "S";
						conditionFlag = "S";							
					}
				}
			}
			forecastReportOptionVO.setUsrId(account.getUsr_id());
			forecastReportOptionVO.setPresentFlag(presentFlag);
			forecastReportOptionVO.setConditionFlag(conditionFlag);
			forecastReportOptionVO.setConditionValue(conditionValue);
			
			log.debug(">>>>>>>>>>>>> present_flag 	    : " +presentFlag);
			log.debug(">>>>>>>>>>>>> condition_flag 	: " +conditionFlag);
			log.debug(">>>>>>>>>>>>> condition_value 	: " +conditionValue);
			log.debug(">>>>>>>>>>>>> condition_value 	: ");
			/*
			if(divFlag.equals("1")) { // 라디오 버튼 첫번째 선택
				if(forecastReportOptionVO.getSubLocCd() != null && !"".equals(forecastReportOptionVO.getSubLocCd())){ // 첫번째 라디오의 Location 입력값이 있을때
					if(locTypeCode.equals("RE")){  // location by : RCC (by ECC)
						forecastReportOptionVO.setLocGrpCd("E");
					}else{
						forecastReportOptionVO.setLocCd(forecastReportOptionVO.getSubLocCd()); // sub_loc_cd --> loc_cd 에 넣기
						if(locTypeCode.equals("LS") || locTypeCode.equals("ES")){
							forecastReportOptionVO.setLocGrpCd("S");
						}else if(locTypeCode.equals("LE")){
							forecastReportOptionVO.setLocGrpCd("E");
						}
					}
				}else{ // 첫번째 라디오의 Location 입력값이 없을때
					forecastReportOptionVO.setLocTypeCode("");
					forecastReportOptionVO.setDivFlag("");  // 라디오 버튼 선택없는것으로 변경
				}
			
			}else if(divFlag.equals("2")) {
				if(locCdSecond != null && !"".equals(locCdSecond)){ // 두번째 라디오의 Location 입력값이 있을때
					if(locTpCdSecond.equals("L")) forecastReportOptionVO.setLocGrpCd("L");
					if(locTpCdSecond.equals("E")) forecastReportOptionVO.setLocGrpCd("E");
					if(locTpCdSecond.equals("S")) forecastReportOptionVO.setLocGrpCd("S");
				}else { // 두번째 라디오의 Location 입력값이 없을때
					forecastReportOptionVO.setDivFlag("");  // 라디오 버튼 선택없는것으로 변경
				}
			}
			*/
			
//			return dbDao.searchMtyWeeklySimulation(forecastReportOptionVO);
			
			return dbDao.searchForecastReportData(forecastReportOptionVO);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"how ever error"}).getMessage(),ex);
		}
	}
	
	/**
	 *  지점별로 향후 -1~+4 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param ForecastReportOptionVO forecastReportOptionVO
	 * @return List<MtyWeeklySimulationVO>
	 * @throws EventException
	 */
	 public List<ForecastReportVO> searchMtyWeeklySimulation(ForecastReportOptionVO forecastReportOptionVO) throws EventException {
		try {
			String locCd         = forecastReportOptionVO.getLocCd();          // RCC select box
			String divFlag 		 = forecastReportOptionVO.getDivFlag();        // 라디오 버튼 (1,2)
			String locTypeCode 	 = forecastReportOptionVO.getLocTypeCode();    // Location By 의 select box
			String subLocCd      = forecastReportOptionVO.getSubLocCd();       // Location By 의 입력값			
			String locTpCdSecond = forecastReportOptionVO.getLocTpCdSecond();  // Location 의 select box			
			String locCdSecond   = forecastReportOptionVO.getLocCdSecond();    // Location 의 입력값
			String locGrpCd      = forecastReportOptionVO.getLocGrpCd();       // Location Group Code 의 입력값
			
			//String loc_grp_cd     = "";
			String presentFlag   = ""; // SELECT 절의 LCC,ECC,SCC 결정
			String conditionFlag = ""; // WHERE 조건의 LCC,ECC,SCC 결정
			String conditionValue = ""; // 검색값
			
			log.debug(">>>>>>>>>>>>> loc_cd       	: " +locCd);
			log.debug(">>>>>>>>>>>>> divFlag       	: " +divFlag);
			log.debug(">>>>>>>>>>>>> locTypeCode 	: " +locTypeCode);
			log.debug(">>>>>>>>>>>>> subLocCd 		: " +subLocCd);
			log.debug(">>>>>>>>>>>>> locTpCdSecond 	: " +locTpCdSecond);
			log.debug(">>>>>>>>>>>>> locCdSecond 	: " +locCdSecond);
			log.debug(">>>>>>>>>>>>> locGrpCd 	    : " +locGrpCd);
			
			// 로직정리 ()
			// RCC 가 ALL 선택
			// RCC 선택되고 Location By, Location 입력값이 없을때
			// RCC 선택되고 라디오 버튼 1 선택, Location By 입력값 있음
			// RCC 서택되고 라디오버튼 2 선택, Location 입력값 있음
			// sheet의 왼쪽 + 버튼 클릭
			
			if(divFlag.equals("0")) { // sheet의 왼쪽 + 버튼 클릭
				if(locGrpCd.equals("L")) {  		// RCC 클릭
					presentFlag   = "L";
					conditionFlag = "R"; 			// 실제 조건은 적용되지 않음.
					conditionValue = locCd; 		// 조회값							
				}else if(locGrpCd.equals("E")) {  	// LCC 클릭
					presentFlag   = "E";
					conditionFlag = "L"; 			// 실제 조건은 적용되지 않음.
					conditionValue = locCd; 		// 조회값									
				}else {                           	// ECC 클릭
					presentFlag   = "S";
					conditionFlag = "E"; 			// 실제 조건은 적용되지 않음.
					conditionValue = locCd; 		// 조회값									
				}
		
			}else if(locCd.equals("") || locCd == null) { // RCC 가 ALL 선택
				presentFlag   = "L";
				conditionFlag = "R"; 	// 실제 조건은 적용되지 않음.
				conditionValue = "";
				
			}else { // RCC ALL 아님
				// RCC 선택되고 Location By, Location 입력값이 없을때
				if((subLocCd.equals("") || subLocCd == null) && (locCdSecond.equals("") || locCdSecond == null)) {
					presentFlag    = "L";
					conditionFlag  = "R";
					conditionValue = locCd; // 조회값
					
				// RCC 선택되고 라디오 버튼 1 선택, Location By 입력값 있음
				}else if(divFlag.equals("1") && subLocCd != null) {
					conditionValue = subLocCd;  // 조회값
					
					if(locTypeCode.equals("RE")) {       // RCC (by ECC)
						presentFlag   = "E";
						conditionFlag = "R";	
						
					}else if(locTypeCode.equals("LE")) { // LCC (by ECC)
						presentFlag   = "E";
						conditionFlag = "L";								
					}else if(locTypeCode.equals("LS")) { // LCC (by SCC)
						presentFlag   = "S";
						conditionFlag = "L";	
					}else {                              // ECC (by SCC)
						presentFlag   = "S";
						conditionFlag = "E";							
					}
				// RCC 서택되고 라디오버튼 2 선택, Location 입력값 있음	
				}else if(divFlag.equals("2") && locCdSecond != null) {
					conditionValue = locCdSecond;  // 조회값
					
					if(locTpCdSecond.equals("L")) {        // LCC
						presentFlag   = "L";
						conditionFlag = "L";							
					}else if(locTpCdSecond.equals("E")) {  // ECC
						presentFlag   = "E";
						conditionFlag = "E";							
					}else {  // SCC
						presentFlag   = "S";
						conditionFlag = "S";							
					}
				}
			}
			
			forecastReportOptionVO.setPresentFlag(presentFlag);
			forecastReportOptionVO.setConditionFlag(conditionFlag);
			forecastReportOptionVO.setConditionValue(conditionValue);
			
			log.debug(">>>>>>>>>>>>> present_flag 	    : " +presentFlag);
			log.debug(">>>>>>>>>>>>> condition_flag 	: " +conditionFlag);
			log.debug(">>>>>>>>>>>>> condition_value 	: " +conditionValue);
			log.debug(">>>>>>>>>>>>> condition_value 	: ");
			/*
			if(divFlag.equals("1")) { // 라디오 버튼 첫번째 선택
				if(forecastReportOptionVO.getSubLocCd() != null && !"".equals(forecastReportOptionVO.getSubLocCd())){ // 첫번째 라디오의 Location 입력값이 있을때
					if(locTypeCode.equals("RE")){  // location by : RCC (by ECC)
						forecastReportOptionVO.setLocGrpCd("E");
					}else{
						forecastReportOptionVO.setLocCd(forecastReportOptionVO.getSubLocCd()); // sub_loc_cd --> loc_cd 에 넣기
						if(locTypeCode.equals("LS") || locTypeCode.equals("ES")){
							forecastReportOptionVO.setLocGrpCd("S");
						}else if(locTypeCode.equals("LE")){
							forecastReportOptionVO.setLocGrpCd("E");
						}
					}
				}else{ // 첫번째 라디오의 Location 입력값이 없을때
					forecastReportOptionVO.setLocTypeCode("");
					forecastReportOptionVO.setDivFlag("");  // 라디오 버튼 선택없는것으로 변경
				}
			
			}else if(divFlag.equals("2")) {
				if(locCdSecond != null && !"".equals(locCdSecond)){ // 두번째 라디오의 Location 입력값이 있을때
					if(locTpCdSecond.equals("L")) forecastReportOptionVO.setLocGrpCd("L");
					if(locTpCdSecond.equals("E")) forecastReportOptionVO.setLocGrpCd("E");
					if(locTpCdSecond.equals("S")) forecastReportOptionVO.setLocGrpCd("S");
				}else { // 두번째 라디오의 Location 입력값이 없을때
					forecastReportOptionVO.setDivFlag("");  // 라디오 버튼 선택없는것으로 변경
				}
			}
			*/
			
			
			return dbDao.searchMtyWeeklySimulation(forecastReportOptionVO);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Weekly Simulation Retrieve"}).getMessage(),ex);
		}
	}
	 
	/**
	 * User의 Office level을 체크
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception EventException
	 */
	 public String checkMtyBalanceRepoOutYard(String ofcCd) throws EventException {
		 try {
				return dbDao.checkMtyBalanceRepoOutYard(ofcCd);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Weekly Simulation Retrieve"}).getMessage(),ex);
			}
	 }
	 
	/**
	 * 해당 셀의 원래 값을 조회<br>
	 * 
	 * @param ForecastReportOptionVO forecastReportOptionVO
	 * @return String
	 * @exception EventException
	 */
	 public String searchMtyWeeklySimulationOrigin(ForecastReportOptionVO forecastReportOptionVO) throws EventException{
		 try {
				return dbDao.searchMtyWeeklySimulationOrigin(forecastReportOptionVO);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Weekly Simulation Retrieve"}).getMessage(),ex);
			}
	 }
	 
	/**
	 * mty weekly data를 신규 입력/수정<br>
	 * 
	 * @param ForecastReportOptionVO[] forecastReportOptionVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	 public void manageMtyWeeklySimulation(ForecastReportOptionVO[] forecastReportOptionVOs, SignOnUserAccount account) throws EventException{
		 try { 
			 List<ForecastReportOptionVO> insertVoList = new ArrayList<ForecastReportOptionVO>();
			 List<ForecastReportOptionVO> updateVoList = new ArrayList<ForecastReportOptionVO>();
			 List<ForecastReportOptionVO> deleteVoList = new ArrayList<ForecastReportOptionVO>();

			for ( int i=0; i<forecastReportOptionVOs.length; i++ ) {

				if(forecastReportOptionVOs[i].getCntrQty().equals("D")){
					deleteVoList.add(forecastReportOptionVOs[i]);
				}else{
					int checkAddModifyMtyCnt = dbDao.checkMtyWeeklySimulation(forecastReportOptionVOs[i]);
					
					forecastReportOptionVOs[i].setUsrId(account.getUsr_id());
					if ( checkAddModifyMtyCnt == 0) {
						insertVoList.add(forecastReportOptionVOs[i]);
					} else {
						updateVoList.add(forecastReportOptionVOs[i]);
					}
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addMtyWeeklySimulation(insertVoList);
			}
			if ( updateVoList.size() > 0 ) { 
				dbDao.modifyMtyWeeklySimulation(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) { 
				dbDao.removeMtyWeeklySimulation(deleteVoList);
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Weekly Simulation Retrieve"}).getMessage(),ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(ex.getMessage(),ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Weekly Simulation Retrieve"}).getMessage(),ex);
		}
	 }

	/**
	 *  지점별로 이전 수 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param ForecastReportOptionVO forecastReportOptionVO
	 * @return String
	 * @throws EventException
	 */
	 public String searchMtyWeeklySimulationReportTitle(ForecastReportOptionVO forecastReportOptionVO) throws EventException {
		try {
			return dbDao.searchMtyWeeklySimulationReportTitle(forecastReportOptionVO);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Weekly Simulation Retrieve"}).getMessage(),ex);
		}
	}
	 
	/**
	 *  지점별로 이전 수 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param ForecastReportOptionVO forecastReportOptionVO
	 * @param String rptTtl
	 * @return CommonRsVO
	 * @throws EventException
	 */
	 public CommonRsVO searchMtyWeeklySimulationReport(ForecastReportOptionVO forecastReportOptionVO, String rptTtl) throws EventException {
		try {
			String locCd         = forecastReportOptionVO.getLocCd();          // RCC select box
			String divFlag 		 = forecastReportOptionVO.getDivFlag();        // 라디오 버튼 (1,2)
			String locTypeCode 	 = forecastReportOptionVO.getLocTypeCode();    // Location By 의 select box
			String subLocCd      = forecastReportOptionVO.getSubLocCd();       // Location By 의 입력값			
			String locTpCdSecond = forecastReportOptionVO.getLocTpCdSecond();  // Location 의 select box			
			String locCdSecond   = forecastReportOptionVO.getLocCdSecond();    // Location 의 입력값
			String locGrpCd      = forecastReportOptionVO.getLocGrpCd();       // Location Group Code 의 입력값
			
			//String loc_grp_cd     = "";
			String presentFlag   = ""; // SELECT 절의 LCC,ECC,SCC 결정
			String conditionFlag = ""; // WHERE 조건의 LCC,ECC,SCC 결정
			String conditionValue = ""; // 검색값
			
			log.debug(">>>>>>>>>>>>> loc_cd       	: " +locCd);
			log.debug(">>>>>>>>>>>>> divFlag       	: " +divFlag);
			log.debug(">>>>>>>>>>>>> locTypeCode 	: " +locTypeCode);
			log.debug(">>>>>>>>>>>>> subLocCd 		: " +subLocCd);
			log.debug(">>>>>>>>>>>>> locTpCdSecond 	: " +locTpCdSecond);
			log.debug(">>>>>>>>>>>>> locCdSecond 	: " +locCdSecond);
			log.debug(">>>>>>>>>>>>> locGrpCd 	    : " +locGrpCd);
			
			// 로직정리 ()
			// RCC 가 ALL 선택
			// RCC 선택되고 Location By, Location 입력값이 없을때
			// RCC 선택되고 라디오 버튼 1 선택, Location By 입력값 있음
			// RCC 서택되고 라디오버튼 2 선택, Location 입력값 있음
			// sheet의 왼쪽 + 버튼 클릭
			
			if(divFlag.equals("0")) { // sheet의 왼쪽 + 버튼 클릭
				if(locGrpCd.equals("L")) {  		// RCC 클릭
					presentFlag   = "L";
					conditionFlag = "R"; 			// 실제 조건은 적용되지 않음.
					conditionValue = locCd; 		// 조회값							
				}else if(locGrpCd.equals("E")) {  	// LCC 클릭
					presentFlag   = "E";
					conditionFlag = "L"; 			// 실제 조건은 적용되지 않음.
					conditionValue = locCd; 		// 조회값									
				}else {                           	// ECC 클릭
					presentFlag   = "S";
					conditionFlag = "E"; 			// 실제 조건은 적용되지 않음.
					conditionValue = locCd; 		// 조회값									
				}
		
			}else if(locCd.equals("") || locCd == null) { // RCC 가 ALL 선택
				presentFlag   = "L";
				conditionFlag = "R"; 	// 실제 조건은 적용되지 않음.
				conditionValue = "";
				
			}else { // RCC ALL 아님
				// RCC 선택되고 Location By, Location 입력값이 없을때
				if((subLocCd.equals("") || subLocCd == null) && (locCdSecond.equals("") || locCdSecond == null)) {
					presentFlag    = "L"; 
					conditionFlag  = "R";
					conditionValue = locCd; // 조회값
					
				// RCC 선택되고 라디오 버튼 1 선택, Location By 입력값 있음
				}else if(divFlag.equals("1") && subLocCd != null) {
					conditionValue = subLocCd;  // 조회값
					
					if(locTypeCode.equals("RE")) {       // RCC (by ECC)
						presentFlag   = "E";
						conditionFlag = "R";	
						
					}else if(locTypeCode.equals("LE")) { // LCC (by ECC)
						presentFlag   = "E";
						conditionFlag = "L";								
					}else if(locTypeCode.equals("LS")) { // LCC (by SCC)
						presentFlag   = "S";
						conditionFlag = "L";	
					}else {                              // ECC (by SCC)
						presentFlag   = "S";
						conditionFlag = "E";							
					}
				// RCC 서택되고 라디오버튼 2 선택, Location 입력값 있음	
				}else if(divFlag.equals("2") && locCdSecond != null) {
					conditionValue = locCdSecond;  // 조회값
					
					if(locTpCdSecond.equals("L")) {        // LCC
						presentFlag   = "L";
						conditionFlag = "L";							
					}else if(locTpCdSecond.equals("E")) {  // ECC
						presentFlag   = "E";
						conditionFlag = "E";							
					}else {  // SCC
						presentFlag   = "S";
						conditionFlag = "S";							
					}
				}
			}
			
			forecastReportOptionVO.setPresentFlag(presentFlag);
			forecastReportOptionVO.setConditionFlag(conditionFlag);
			forecastReportOptionVO.setConditionValue(conditionValue);
			
			log.debug(">>>>>>>>>>>>> present_flag 	    : " +presentFlag);
			log.debug(">>>>>>>>>>>>> condition_flag 	: " +conditionFlag);
			log.debug(">>>>>>>>>>>>> condition_value 	: " +conditionValue);
			
			/*
			if(divFlag.equals("1")) { // 라디오 버튼 첫번째 선택
				if(forecastReportOptionVO.getSubLocCd() != null && !"".equals(forecastReportOptionVO.getSubLocCd())){ // 첫번째 라디오의 Location 입력값이 있을때
					if(locTypeCode.equals("RE")){  // location by : RCC (by ECC)
						forecastReportOptionVO.setLocGrpCd("E");
					}else{
						forecastReportOptionVO.setLocCd(forecastReportOptionVO.getSubLocCd()); // sub_loc_cd --> loc_cd 에 넣기
						if(locTypeCode.equals("LS") || locTypeCode.equals("ES")){
							forecastReportOptionVO.setLocGrpCd("S");
						}else if(locTypeCode.equals("LE")){
							forecastReportOptionVO.setLocGrpCd("E");
						}
					}
				}else{ // 첫번째 라디오의 Location 입력값이 없을때
					forecastReportOptionVO.setLocTypeCode("");
					forecastReportOptionVO.setDivFlag("");  // 라디오 버튼 선택없는것으로 변경
				}
			
			}else if(divFlag.equals("2")) {
				if(locCdSecond != null && !"".equals(locCdSecond)){ // 두번째 라디오의 Location 입력값이 있을때
					if(locTpCdSecond.equals("L")) forecastReportOptionVO.setLocGrpCd("L");
					if(locTpCdSecond.equals("E")) forecastReportOptionVO.setLocGrpCd("E");
					if(locTpCdSecond.equals("S")) forecastReportOptionVO.setLocGrpCd("S");
				}else { // 두번째 라디오의 Location 입력값이 없을때
					forecastReportOptionVO.setDivFlag("");  // 라디오 버튼 선택없는것으로 변경
				}
			}
			
			log.debug(">>>>>>>>>>>>> loc_grp_cd       : " +forecastReportOptionVO.getLocGrpCd());
			log.debug(">>>>>>>>>>>>> loc_type_code    : " +forecastReportOptionVO.getLocTypeCode());
			log.debug(">>>>>>>>>>>>> div_flag         : " +forecastReportOptionVO.getDivFlag());	
			log.debug(">>>>>>>>>>>>> loc_cd           : " +forecastReportOptionVO.getLocCd());	
			*/
			
			return dbDao.searchMtyWeeklySimulationReport(forecastReportOptionVO, rptTtl);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Weekly Simulation Retrieve"}).getMessage(),ex);
		}
	}
	 
	/**
	 * 입력 받은 rcc/lcc/ecc가 해당 rcc에 속하는지 체크
	 * 
	 * @param ForecastReportOptionVO forecastReportOptionVO
	 * @return String
	 * @exception EventException
	 */
	 public String checkSubLocCd(ForecastReportOptionVO forecastReportOptionVO) throws EventException {
		try{
			return dbDao.checkSubLocCd(forecastReportOptionVO);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Weekly Simulation Retrieve"}).getMessage(),ex);
		}
    }
	 
// 여기부터는 1048 용 메서드임, 원래 다른 페키지에 있던거라 dao 중복 선언에 대한 검토 필요 	 
	 /**
	 *  EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 조회한다<br>
	 * 
	 * @param EesEqr1048ConditionVO eesEqr1048ConditionVO
	 * @return List<ForecastReportListVO>
	 * @exception EventException
	 */
	public List<ForecastReportListVO> searchMtyRepoInDetailList(EesEqr1048ConditionVO eesEqr1048ConditionVO) throws EventException {
		try {
			String[] weekStEndDt = dbDao.searchWeekStEndDt(eesEqr1048ConditionVO);
			eesEqr1048ConditionVO.setWkStDt(weekStEndDt[0]);
			eesEqr1048ConditionVO.setWkEndDt(weekStEndDt[1]);

			String currFlag    = "";
			String repoPlnYrwk = eesEqr1048ConditionVO.getRepoPlnYrwk(); // Balance Report ID 의  week
			String fcastYrwk   = eesEqr1048ConditionVO.getFcastYrwk();   // 왼쪽 돋보기 week
			
			// Balance Report ID와 왼쪽 week 가 같으면 왼쪽 week 가 현재주차인지 확인
			if( repoPlnYrwk.equals(fcastYrwk) ) {
				currFlag = dbDao.checkCurrWeek(eesEqr1048ConditionVO);						
			}else { // Balance Report ID와 왼쪽week 가 다를때는 'F' 처리	
				currFlag = "F";
			}
			
			eesEqr1048ConditionVO.setCurrFlag(currFlag);						
			
			//return dbDao.searchMtyBalanceRepoList(mtyBalanceOptionVO);
			return dbDao.searchMtyRepoInDeatilList(eesEqr1048ConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Reposition In Detail Retrieve"}).getMessage(),ex);
		}
	}	

	/**
	 *  EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 조회한다<br>
	 * 
	 * @param EesEqr1048ConditionVO eesEqr1048ConditionVO
	 * @return List<ForecastReportListVO>
	 * @exception EventException
	 */
	public List<ForecastReportListVO> searchMtyBalanceDischargedList(EesEqr1048ConditionVO eesEqr1048ConditionVO) throws EventException {
		try {
			return dbDao.searchMtyBalanceDischargedList(eesEqr1048ConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Reposition In / Out Plan Retrieve"}).getMessage(),ex);
		}
	}

	/**
	 *  VVD를 이용해 slan cd를 조회한다.<br>
	 * 
	 * @param ForecastReportListVO forecastReportListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchMtyBalanceRepoOutSlanCd(ForecastReportListVO forecastReportListVO) throws EventException {
		try {
			return dbDao.searchMtyBalanceRepoOutSlanCd(forecastReportListVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Reposition Out VVD Retrieve"}).getMessage(),ex);
		}
	}

	/**
	 * 특정 주차내의 일자 목록을 조회한다.<br>
	 * 
	 * @param String wk_st_dt
	 * @return List<ForecastReportCommonListVO>
	 * @exception EventException
	 */
	public List<ForecastReportCommonListVO> searchLocationDateList(String wk_st_dt) throws EventException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		List<ForecastReportCommonListVO> list = null;
		try {
			list = dbDao.searchLocationDateList(wk_st_dt);
			return list;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 * LCC/ECC/SCC 에 속한 LOCATION<br>
	 * 
	 * @param String locGrpCd
	 * @param String locCd
	 * @return List<ForecastReportCommonListVO>
	 * @exception EventException
	 */
	public List<ForecastReportCommonListVO> searchLocationList(String locGrpCd, String locCd) throws EventException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		List<ForecastReportCommonListVO> list = null;
		try {
			list = dbDao.searchLocationList(locGrpCd, locCd);
			return list;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"ECC Yard  Retrieve"}).getMessage(),ex);
		}
	}			 
	
	/**
	 * REPO IN 데이터를 수기로 관리하는 기능 처리<br>
	 * 
	 * @param ForecastReportListVO[] forecastReportListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMtyRepoInDetailList(ForecastReportListVO[] forecastReportListVOs, SignOnUserAccount account) throws EventException
	{
		try {
			List<ForecastReportListVO> insertVoList = new ArrayList<ForecastReportListVO>();
			List<ForecastReportListVO> updateVoList = new ArrayList<ForecastReportListVO>();
			List<ForecastReportListVO> updateCodRmkVoList = new ArrayList<ForecastReportListVO>();
			List<ForecastReportListVO> deleteVoList = new ArrayList<ForecastReportListVO>();
			
			if(forecastReportListVOs != null) { 
				for ( int i=0; i<forecastReportListVOs.length; i++ ) {					
					if ( forecastReportListVOs[i].getIbflag().equals("I")){
						forecastReportListVOs[i].setCreUsrId(account.getUsr_id());
						forecastReportListVOs[i].setUpdUsrId(account.getUsr_id());
						
						insertVoList.add(forecastReportListVOs[i]);
						
					} else if ( forecastReportListVOs[i].getIbflag().equals("U")){
						forecastReportListVOs[i].setUpdUsrId(account.getUsr_id());
						log.debug(">>>>>>>>>>>> UPDATE "+i+" : "+forecastReportListVOs[i].getLvl()+", "+forecastReportListVOs[i].getVvd()+", "+forecastReportListVOs[i].getDiv());

						if(forecastReportListVOs[i].getCreSeq().equals("1")) { // lvl =1 은 manual 입력을 의미함.(EQR_MTY_BAL_RPT_DCHG_MNL 수정)
							updateVoList.add(forecastReportListVOs[i]);
						}else {  // lvl=0 은 EQR_MTY_COD_RMK 의 remark 만 수정
							forecastReportListVOs[i].setOfcCd(account.getOfc_cd());
							forecastReportListVOs[i].setCreUsrId(account.getUsr_id());
							updateCodRmkVoList.add(forecastReportListVOs[i]);
						}
						
					} else if ( forecastReportListVOs[i].getIbflag().equals("D")){
						deleteVoList.add(forecastReportListVOs[i]);
					}
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addMtyRepoInDetailList(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMtyRepoInDetailList(updateVoList);
			}
			
			if ( updateCodRmkVoList.size() > 0 ) {  // EQR_MTY_COD_RMK 의 remark 만 수정
				dbDao.modifyMtyCodRemark(updateCodRmkVoList);
			}			
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeMtyRepoInDetailList(deleteVoList);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"Failed to save due to time/ auth restriction"}).getMessage(),de);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			//throw new EventException(de.getMessage());
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"Failed to save due to time/ auth restriction"}).getMessage(),de);
		}
	}		
	
// 여기까지는 1048 용 메서드임, 원래 다른 페키지에 있던거라 dao 중복 선언에 대한 검토 필요 	
	
// 1040 (S)
	
	/**
	 *  PLANNED REPO IN 데이터를 조회한다<br>
	 * 
	 * @param EesEqr1048ConditionVO eesEqr1048ConditionVO
	 * @return List<PlannedRepoInVO>
	 * @exception EventException
	 */
	public List<PlannedRepoInVO> searchPlannedRepoInBasic(EesEqr1048ConditionVO eesEqr1048ConditionVO) throws EventException {
		try {
			String[] weekStEndDt = dbDao.searchWeekStEndDt(eesEqr1048ConditionVO);
			eesEqr1048ConditionVO.setWkStDt(weekStEndDt[0]);
			eesEqr1048ConditionVO.setWkEndDt(weekStEndDt[1]);

//			currFlag 찾는 부분 .. 삭제예정 MDS
//			String currFlag    = "";
//			String repoPlnYrwk = eesEqr1048ConditionVO.getRepoPlnYrwk(); // Balance Report ID 의  week
//			String fcastYrwk   = eesEqr1048ConditionVO.getFcastYrwk();   // 왼쪽 돋보기 week
//			// Balance Report ID와 왼쪽 week 가 같으면 왼쪽 week 가 현재주차인지 확인 // 이런건 필요 없을 것 같은데
//			if( repoPlnYrwk.equals(fcastYrwk) ) {
//				currFlag = dbDao.checkCurrWeek(eesEqr1048ConditionVO);						
//			}else { // Balance Report ID와 왼쪽week 가 다를때는 'F' 처리	
//				currFlag = "F";
//			}
//			eesEqr1048ConditionVO.setCurrFlag(currFlag);						
			
			return dbDao.searchPlannedRepoInData(eesEqr1048ConditionVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			//throw new EventException(new ErrorHandler(ex).getMessage());
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Reposition In Detail Retrieve"}).getMessage(),ex);
		}
	}		
	
	/**
	 * PLANNED REPO IN 데이터를 수기로 관리하는 기능 처리<br>
	 * 
	 * @param PlannedRepoInVO[] plannedRepoInVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePlannedRepoInBasic(PlannedRepoInVO[] plannedRepoInVOs, SignOnUserAccount account) throws EventException
	{
		try {
			List<EqrCtrlPlnRepoInVO>    updateVoList    = new ArrayList<EqrCtrlPlnRepoInVO>();
			List<EqrCtrlPlnRepoInQtyVO> updateQtyVoList = new ArrayList<EqrCtrlPlnRepoInQtyVO>();
			List<EqrCtrlPlnRepoInVO>    deleteVoList    = new ArrayList<EqrCtrlPlnRepoInVO>();
			List<EqrCtrlPlnRepoInQtyVO> deleteQtyVoList = new ArrayList<EqrCtrlPlnRepoInQtyVO>();
			
			EqrCtrlPlnRepoInVO eqrCtrlPlnRepoInVO = null;
			EqrCtrlPlnRepoInQtyVO eqrCtrlPlnRepoInQtyVO =  null;
			
			
			if(plannedRepoInVOs != null) { 
				// EqrCtrlPlnRepoInVO 추출
				for ( int i=0; i<plannedRepoInVOs.length; i++ ) {					
					eqrCtrlPlnRepoInVO = new EqrCtrlPlnRepoInVO();
					
					eqrCtrlPlnRepoInVO.setCreUsrId(account.getUsr_id());
					eqrCtrlPlnRepoInVO.setUpdUsrId(account.getUsr_id());
					eqrCtrlPlnRepoInVO.setFcastYrwk(plannedRepoInVOs[i].getWeek());
					eqrCtrlPlnRepoInVO.setVslCd(plannedRepoInVOs[i].getVslCd());
					eqrCtrlPlnRepoInVO.setSkdVoyNo(plannedRepoInVOs[i].getSkdVoyNo());
					eqrCtrlPlnRepoInVO.setSkdDirCd(plannedRepoInVOs[i].getSkdDirCd());
					eqrCtrlPlnRepoInVO.setPlnRepoStsCd(plannedRepoInVOs[i].getSts());
					eqrCtrlPlnRepoInVO.setPodYdCd(plannedRepoInVOs[i].getYard());
					eqrCtrlPlnRepoInVO.setToEtbDt(plannedRepoInVOs[i].getEtb());
					eqrCtrlPlnRepoInVO.setVslLaneCd(plannedRepoInVOs[i].getLane());
					eqrCtrlPlnRepoInVO.setLocCd(plannedRepoInVOs[i].getLocCd());
					
					if ( plannedRepoInVOs[i].getIbflag().equals("I") || plannedRepoInVOs[i].getIbflag().equals("U")){
						updateVoList.add(eqrCtrlPlnRepoInVO); // 
						
						eqrCtrlPlnRepoInQtyVO = new EqrCtrlPlnRepoInQtyVO() ;
						eqrCtrlPlnRepoInQtyVO.setCreUsrId(account.getUsr_id());
						eqrCtrlPlnRepoInQtyVO.setUpdUsrId(account.getUsr_id());
						eqrCtrlPlnRepoInQtyVO.setFcastYrwk(plannedRepoInVOs[i].getWeek());
						eqrCtrlPlnRepoInQtyVO.setVslCd(plannedRepoInVOs[i].getVslCd());
						eqrCtrlPlnRepoInQtyVO.setSkdVoyNo(plannedRepoInVOs[i].getSkdVoyNo());
						eqrCtrlPlnRepoInQtyVO.setSkdDirCd(plannedRepoInVOs[i].getSkdDirCd());
						eqrCtrlPlnRepoInQtyVO.setPlnRepoStsCd(plannedRepoInVOs[i].getSts());
						eqrCtrlPlnRepoInQtyVO.setPodYdCd(plannedRepoInVOs[i].getYard());
						eqrCtrlPlnRepoInQtyVO.setToEtbDt(plannedRepoInVOs[i].getEtb());
						
						// cntr tpsz 별, update/delete 별로 VO 분기	
						if(plannedRepoInVOs[i].getD2Ef().equals("U")){       // insert or update 
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("D2");
							eqrCtrlPlnRepoInQtyVO.setCntrQty(plannedRepoInVOs[i].getD2Qty());
							updateQtyVoList.add(eqrCtrlPlnRepoInQtyVO);   
						}else if(plannedRepoInVOs[i].getD2Ef().equals("D")){ // delete (row delete or return)
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("D2");
							eqrCtrlPlnRepoInQtyVO.setCntrQty("");
							deleteQtyVoList.add(eqrCtrlPlnRepoInQtyVO);	
						}
						
						if(plannedRepoInVOs[i].getD4Ef().equals("U")){       // insert or update 
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("D4");
							eqrCtrlPlnRepoInQtyVO.setCntrQty(plannedRepoInVOs[i].getD4Qty());
							updateQtyVoList.add(eqrCtrlPlnRepoInQtyVO);   
						}else if(plannedRepoInVOs[i].getD4Ef().equals("D")){ // delete (row delete or return)
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("D4");
							eqrCtrlPlnRepoInQtyVO.setCntrQty("");
							deleteQtyVoList.add(eqrCtrlPlnRepoInQtyVO);	
						}
						
						if(plannedRepoInVOs[i].getD5Ef().equals("U")){       // insert or update 
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("D5");
							eqrCtrlPlnRepoInQtyVO.setCntrQty(plannedRepoInVOs[i].getD5Qty());
							updateQtyVoList.add(eqrCtrlPlnRepoInQtyVO);   
						}else if(plannedRepoInVOs[i].getD5Ef().equals("D")){ // delete (row delete or return)
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("D5");
							eqrCtrlPlnRepoInQtyVO.setCntrQty("");
							deleteQtyVoList.add(eqrCtrlPlnRepoInQtyVO);	
						}
						
						if(plannedRepoInVOs[i].getD7Ef().equals("U")){       // insert or update 
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("D7");
							eqrCtrlPlnRepoInQtyVO.setCntrQty(plannedRepoInVOs[i].getD7Qty());
							updateQtyVoList.add(eqrCtrlPlnRepoInQtyVO);   
						}else if(plannedRepoInVOs[i].getD7Ef().equals("D")){ // delete (row delete or return)
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("D7");
							eqrCtrlPlnRepoInQtyVO.setCntrQty("");
							deleteQtyVoList.add(eqrCtrlPlnRepoInQtyVO);	
						}
						
						if(plannedRepoInVOs[i].getR2Ef().equals("U")){       // insert or update 
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("R2");
							eqrCtrlPlnRepoInQtyVO.setCntrQty(plannedRepoInVOs[i].getR2Qty());
							updateQtyVoList.add(eqrCtrlPlnRepoInQtyVO);   
						}else if(plannedRepoInVOs[i].getR2Ef().equals("D")){ // delete (row delete or return)
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("R2");
							eqrCtrlPlnRepoInQtyVO.setCntrQty("");
							deleteQtyVoList.add(eqrCtrlPlnRepoInQtyVO);	
						}
						
						if(plannedRepoInVOs[i].getR5Ef().equals("U")){       // insert or update 
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("R5");
							eqrCtrlPlnRepoInQtyVO.setCntrQty(plannedRepoInVOs[i].getR5Qty());
							updateQtyVoList.add(eqrCtrlPlnRepoInQtyVO);   
						}else if(plannedRepoInVOs[i].getR5Ef().equals("D")){ // delete (row delete or return)
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("R5");
							eqrCtrlPlnRepoInQtyVO.setCntrQty("");
							deleteQtyVoList.add(eqrCtrlPlnRepoInQtyVO);	
						}
						
						if(plannedRepoInVOs[i].getR9Ef().equals("U")){       // insert or update 
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("R9");
							eqrCtrlPlnRepoInQtyVO.setCntrQty(plannedRepoInVOs[i].getR9Qty());
							updateQtyVoList.add(eqrCtrlPlnRepoInQtyVO);   
						}else if(plannedRepoInVOs[i].getR9Ef().equals("D")){ // delete (row delete or return)
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("R9");
							eqrCtrlPlnRepoInQtyVO.setCntrQty("");
							deleteQtyVoList.add(eqrCtrlPlnRepoInQtyVO);	
						}

						if(plannedRepoInVOs[i].getO2Ef().equals("U")){       // insert or update 
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("O2");
							eqrCtrlPlnRepoInQtyVO.setCntrQty(plannedRepoInVOs[i].getO2Qty());
							updateQtyVoList.add(eqrCtrlPlnRepoInQtyVO);   
						}else if(plannedRepoInVOs[i].getO2Ef().equals("D")){ // delete (row delete or return)
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("O2");
							eqrCtrlPlnRepoInQtyVO.setCntrQty("");
							deleteQtyVoList.add(eqrCtrlPlnRepoInQtyVO);	
						}
						
						if(plannedRepoInVOs[i].getO4Ef().equals("U")){       // insert or update 
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("O4");
							eqrCtrlPlnRepoInQtyVO.setCntrQty(plannedRepoInVOs[i].getO4Qty());
							updateQtyVoList.add(eqrCtrlPlnRepoInQtyVO);   
						}else if(plannedRepoInVOs[i].getO4Ef().equals("D")){ // delete (row delete or return)
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("O4");
							eqrCtrlPlnRepoInQtyVO.setCntrQty("");
							deleteQtyVoList.add(eqrCtrlPlnRepoInQtyVO);	
						}
						
						if(plannedRepoInVOs[i].getS2Ef().equals("U")){       // insert or update 
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("S2");
							eqrCtrlPlnRepoInQtyVO.setCntrQty(plannedRepoInVOs[i].getS2Qty());
							updateQtyVoList.add(eqrCtrlPlnRepoInQtyVO);   
						}else if(plannedRepoInVOs[i].getS2Ef().equals("D")){ // delete (row delete or return)
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("S2");
							eqrCtrlPlnRepoInQtyVO.setCntrQty("");
							deleteQtyVoList.add(eqrCtrlPlnRepoInQtyVO);	
						}
						
						if(plannedRepoInVOs[i].getS4Ef().equals("U")){       // insert or update 
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("S4");
							eqrCtrlPlnRepoInQtyVO.setCntrQty(plannedRepoInVOs[i].getS4Qty());
							updateQtyVoList.add(eqrCtrlPlnRepoInQtyVO);   
						}else if(plannedRepoInVOs[i].getS4Ef().equals("D")){ // delete (row delete or return)
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("S4");
							eqrCtrlPlnRepoInQtyVO.setCntrQty("");
							deleteQtyVoList.add(eqrCtrlPlnRepoInQtyVO);	
						}
						
						if(plannedRepoInVOs[i].getA2Ef().equals("U")){       // insert or update 
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("A2");
							eqrCtrlPlnRepoInQtyVO.setCntrQty(plannedRepoInVOs[i].getA2Qty());
							updateQtyVoList.add(eqrCtrlPlnRepoInQtyVO);   
						}else if(plannedRepoInVOs[i].getA2Ef().equals("D")){ // delete (row delete or return)
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("A2");
							eqrCtrlPlnRepoInQtyVO.setCntrQty("");
							deleteQtyVoList.add(eqrCtrlPlnRepoInQtyVO);	
						}
						
						if(plannedRepoInVOs[i].getA4Ef().equals("U")){       // insert or update 
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("A4");
							eqrCtrlPlnRepoInQtyVO.setCntrQty(plannedRepoInVOs[i].getA4Qty());
							updateQtyVoList.add(eqrCtrlPlnRepoInQtyVO);   
						}else if(plannedRepoInVOs[i].getA4Ef().equals("D")){ // delete (row delete or return)
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("A4");
							eqrCtrlPlnRepoInQtyVO.setCntrQty("");
							deleteQtyVoList.add(eqrCtrlPlnRepoInQtyVO);	
						}
						
						if(plannedRepoInVOs[i].getF2Ef().equals("U")){       // insert or update 
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("F2");
							eqrCtrlPlnRepoInQtyVO.setCntrQty(plannedRepoInVOs[i].getF2Qty());
							updateQtyVoList.add(eqrCtrlPlnRepoInQtyVO);   
						}else if(plannedRepoInVOs[i].getF2Ef().equals("D")){ // delete (row delete or return)
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("F2");
							eqrCtrlPlnRepoInQtyVO.setCntrQty("");
							deleteQtyVoList.add(eqrCtrlPlnRepoInQtyVO);	
						}
						
						if(plannedRepoInVOs[i].getF4Ef().equals("U")){       // insert or update 
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("F4");
							eqrCtrlPlnRepoInQtyVO.setCntrQty(plannedRepoInVOs[i].getF4Qty());
							updateQtyVoList.add(eqrCtrlPlnRepoInQtyVO);   
						}else if(plannedRepoInVOs[i].getF4Ef().equals("D")){ // delete (row delete or return)
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("F4");
							eqrCtrlPlnRepoInQtyVO.setCntrQty("");
							deleteQtyVoList.add(eqrCtrlPlnRepoInQtyVO);	
						}
						
						if(plannedRepoInVOs[i].getF5Ef().equals("U")){       // insert or update 
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("F5");
							eqrCtrlPlnRepoInQtyVO.setCntrQty(plannedRepoInVOs[i].getF5Qty());
							updateQtyVoList.add(eqrCtrlPlnRepoInQtyVO);   
						}else if(plannedRepoInVOs[i].getF5Ef().equals("D")){ // delete (row delete or return)
							eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("F5");
							eqrCtrlPlnRepoInQtyVO.setCntrQty("");
							deleteQtyVoList.add(eqrCtrlPlnRepoInQtyVO);	
						}
						
					}else if ( plannedRepoInVOs[i].getIbflag().equals("D")){
						deleteVoList.add(eqrCtrlPlnRepoInVO);
						
						// EqrCtrlPlnRepoInVO 추출, tpsz 없으면 전체 tpsz 지움
						eqrCtrlPlnRepoInQtyVO = new EqrCtrlPlnRepoInQtyVO() ;
						eqrCtrlPlnRepoInQtyVO.setFcastYrwk(plannedRepoInVOs[i].getWeek());
						eqrCtrlPlnRepoInQtyVO.setVslCd(plannedRepoInVOs[i].getVslCd());
						eqrCtrlPlnRepoInQtyVO.setSkdVoyNo(plannedRepoInVOs[i].getSkdVoyNo());
						eqrCtrlPlnRepoInQtyVO.setSkdDirCd(plannedRepoInVOs[i].getSkdDirCd());
						eqrCtrlPlnRepoInQtyVO.setPlnRepoStsCd(plannedRepoInVOs[i].getSts());
						eqrCtrlPlnRepoInQtyVO.setPodYdCd(plannedRepoInVOs[i].getYard());
						eqrCtrlPlnRepoInQtyVO.setToEtbDt(plannedRepoInVOs[i].getEtb());
						eqrCtrlPlnRepoInQtyVO.setCntrTpszCd("");
						deleteQtyVoList.add(eqrCtrlPlnRepoInQtyVO);
					}
				}	
				
			}
			
			if ( updateVoList.size() > 0 ) {    // EQR_CTRL_PLN_REPO_IN update/insert (merge)
				dbDao.modifyPlannedRepoInManualData(updateVoList);
			}
			if ( updateQtyVoList.size() > 0 ) { // EQR_CTRL_PLN_REPO_IN_QTY update/insert (merge)
				dbDao.modifyPlannedRepoInManualQtyData(updateQtyVoList);
			}
			if ( deleteQtyVoList.size() > 0 ) { // EQR_CTRL_PLN_REPO_IN_QTY delete
				dbDao.removePlannedRepoInManualQtyData(deleteQtyVoList); 
			}
			if ( deleteVoList.size() > 0 ) {    // EQR_CTRL_PLN_REPO_IN delete
				dbDao.removePlannedRepoInManualData(deleteVoList);
			}
			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"Failed to save due to time/ auth restriction"}).getMessage(),de);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			//throw new EventException(de.getMessage());
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"Failed to save due to time/ auth restriction"}).getMessage(),de);
		}
	}	

	/**
	 * EES_EQR_1040 해당 셀의 원래 값을 조회<br>
	 * 
	 * @param PlannedRepoInVO plannedRepoInVO
	 * @return String
	 * @exception EventException
	 */
	 public String searchPlannedRepoInOriginBasic(PlannedRepoInVO plannedRepoInVO) throws EventException{
		 try {
			 return dbDao.searchPlannedRepoInOriginData(plannedRepoInVO);
	     } catch (Exception ex) {
			 log.error("err " + ex.toString(), ex);
			 throw new EventException(new ErrorHandler("EQR10028", new String[]{"Retrieve"}).getMessage(),ex);
		 }
	 }

	/**
	 * EES_EQR_1040 화면 Yard 유효성 조회<br>
	 * 
	 * @param EesEqr1048ConditionVO eesEqr1048ConditionVO
	 * @return String
	 * @exception EventException
	 */
	 public String checkPlannedRepoInYardBasic(EesEqr1048ConditionVO eesEqr1048ConditionVO) throws EventException{
		 try {
			 return dbDao.checkPlannedRepoInYardData(eesEqr1048ConditionVO);
		 } catch (Exception ex) {
			 log.error("err " + ex.toString(), ex);
			 throw new EventException(new ErrorHandler("EQR10028", new String[]{"Retrieve"}).getMessage(),ex);
		 }
	 }	 
	 
// 1040 (E)	
}