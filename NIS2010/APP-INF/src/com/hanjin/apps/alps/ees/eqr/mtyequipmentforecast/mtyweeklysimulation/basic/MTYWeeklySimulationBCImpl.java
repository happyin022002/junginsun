/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MTYEquipmentForecastBCImpl.java
*@FileTitle : MTY Weekly Simulation Report
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.27
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2009.07.23 나상보
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyweeklysimulation.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyequipmentforecast.vo.MtyBalanceListVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyweeklysimulation.integration.MTYWeeklySimulationDBDAO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyweeklysimulation.vo.MtyWeeklySimulationOptionVO;
import com.hanjin.apps.alps.ees.eqr.mtyequipmentforecast.mtyweeklysimulation.vo.MtyWeeklySimulationVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-MTYWeeklySimulation Business Logic Basic Command implementation<br>
 * - ALPS-MTYWeeklySimulation 대한 비지니스 로직을 처리한다.<br>
 *
 * @author la sang bo
 * @see EES_CIM_5010EventResponse,MTYWeeklySimulationBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class MTYWeeklySimulationBCImpl extends BasicCommandSupport implements MTYWeeklySimulationBC {

	// Database Access Object
	private transient MTYWeeklySimulationDBDAO dbDao = null;

	/**
	 * MTYEquipmentForecastBCImpl 객체 생성<br>
	 * MTYEquipmentForecastDBDAO를 생성한다.<br>
	 */
	public MTYWeeklySimulationBCImpl() {
		dbDao = new MTYWeeklySimulationDBDAO();
	}

	/**
	 *  지점별로 향후 -1~+4 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO
	 * @return List<MtyWeeklySimulationVO>
	 * @throws EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<MtyWeeklySimulationVO> searchMtyWeeklySimulation(MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO) throws EventException {
		try {
			String locCd         = mtyWeeklySimulationOptionVO.getLocCd();          // RCC select box
			String divFlag 		 = mtyWeeklySimulationOptionVO.getDivFlag();        // 라디오 버튼 (1,2)
			String locTypeCode 	 = mtyWeeklySimulationOptionVO.getLocTypeCode();    // Location By 의 select box
			String subLocCd      = mtyWeeklySimulationOptionVO.getSubLocCd();       // Location By 의 입력값			
			String locTpCdSecond = mtyWeeklySimulationOptionVO.getLocTpCdSecond();  // Location 의 select box			
			String locCdSecond   = mtyWeeklySimulationOptionVO.getLocCdSecond();    // Location 의 입력값
			String locGrpCd      = mtyWeeklySimulationOptionVO.getLocGrpCd();       // Location Group Code 의 입력값
			
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
			
			// 로직정리 (신용찬)
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
			
			mtyWeeklySimulationOptionVO.setPresentFlag(presentFlag);
			mtyWeeklySimulationOptionVO.setConditionFlag(conditionFlag);
			mtyWeeklySimulationOptionVO.setConditionValue(conditionValue);
			
			log.debug(">>>>>>>>>>>>> present_flag 	    : " +presentFlag);
			log.debug(">>>>>>>>>>>>> condition_flag 	: " +conditionFlag);
			log.debug(">>>>>>>>>>>>> condition_value 	: " +conditionValue);
			
			/*
			if(divFlag.equals("1")) { // 라디오 버튼 첫번째 선택
				if(mtyWeeklySimulationOptionVO.getSubLocCd() != null && !"".equals(mtyWeeklySimulationOptionVO.getSubLocCd())){ // 첫번째 라디오의 Location 입력값이 있을때
					if(locTypeCode.equals("RE")){  // location by : RCC (by ECC)
						mtyWeeklySimulationOptionVO.setLocGrpCd("E");
					}else{
						mtyWeeklySimulationOptionVO.setLocCd(mtyWeeklySimulationOptionVO.getSubLocCd()); // sub_loc_cd --> loc_cd 에 넣기
						if(locTypeCode.equals("LS") || locTypeCode.equals("ES")){
							mtyWeeklySimulationOptionVO.setLocGrpCd("S");
						}else if(locTypeCode.equals("LE")){
							mtyWeeklySimulationOptionVO.setLocGrpCd("E");
						}
					}
				}else{ // 첫번째 라디오의 Location 입력값이 없을때
					mtyWeeklySimulationOptionVO.setLocTypeCode("");
					mtyWeeklySimulationOptionVO.setDivFlag("");  // 라디오 버튼 선택없는것으로 변경
				}
			
			}else if(divFlag.equals("2")) {
				if(locCdSecond != null && !"".equals(locCdSecond)){ // 두번째 라디오의 Location 입력값이 있을때
					if(locTpCdSecond.equals("L")) mtyWeeklySimulationOptionVO.setLocGrpCd("L");
					if(locTpCdSecond.equals("E")) mtyWeeklySimulationOptionVO.setLocGrpCd("E");
					if(locTpCdSecond.equals("S")) mtyWeeklySimulationOptionVO.setLocGrpCd("S");
				}else { // 두번째 라디오의 Location 입력값이 없을때
					mtyWeeklySimulationOptionVO.setDivFlag("");  // 라디오 버튼 선택없는것으로 변경
				}
			}
			*/
			
			
			return dbDao.searchMtyWeeklySimulation(mtyWeeklySimulationOptionVO);
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
	 @SuppressWarnings("unchecked")
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
	 * @param MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO
	 * @return String
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public String searchMtyWeeklySimulationOrigin(MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO) throws EventException{
		 try {
				return dbDao.searchMtyWeeklySimulationOrigin(mtyWeeklySimulationOptionVO);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Weekly Simulation Retrieve"}).getMessage(),ex);
			}
	 }
	 
	/**
	 * mty weekly data를 신규 입력/수정<br>
	 * 
	 * @param MtyWeeklySimulationOptionVO[] mtyWeeklySimulationOptionVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public void manageMtyWeeklySimulation(MtyWeeklySimulationOptionVO[] mtyWeeklySimulationOptionVOs, SignOnUserAccount account) throws EventException{
		 try {
			 List<MtyWeeklySimulationOptionVO> insertVoList = new ArrayList<MtyWeeklySimulationOptionVO>();
			 List<MtyWeeklySimulationOptionVO> updateVoList = new ArrayList<MtyWeeklySimulationOptionVO>();
			 List<MtyWeeklySimulationOptionVO> deleteVoList = new ArrayList<MtyWeeklySimulationOptionVO>();

			for ( int i=0; i<mtyWeeklySimulationOptionVOs.length; i++ ) {

				if(mtyWeeklySimulationOptionVOs[i].getCntrQty().equals("D")){
					deleteVoList.add(mtyWeeklySimulationOptionVOs[i]);
				}else{
					int checkAddModifyMtyCnt = dbDao.checkMtyWeeklySimulation(mtyWeeklySimulationOptionVOs[i]);
					
					mtyWeeklySimulationOptionVOs[i].setUsrId(account.getUsr_id());
					if ( checkAddModifyMtyCnt == 0) {
						insertVoList.add(mtyWeeklySimulationOptionVOs[i]);
					} else {
						updateVoList.add(mtyWeeklySimulationOptionVOs[i]);
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
	 * @param MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO
	 * @return String
	 * @throws EventException
	 */
	 @SuppressWarnings("unchecked")
	public String searchMtyWeeklySimulationReportTitle(MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO) throws EventException {
		try {
			return dbDao.searchMtyWeeklySimulationReportTitle(mtyWeeklySimulationOptionVO);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Weekly Simulation Retrieve"}).getMessage(),ex);
		}
	}
	 
	/**
	 *  지점별로 이전 수 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO
	 * @param String rptTtl
	 * @return CommonRsVO
	 * @throws EventException
	 */
	 @SuppressWarnings("unchecked")
	public CommonRsVO searchMtyWeeklySimulationReport(MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO, String rptTtl) throws EventException {
		try {
			String locCd         = mtyWeeklySimulationOptionVO.getLocCd();          // RCC select box
			String divFlag 		 = mtyWeeklySimulationOptionVO.getDivFlag();        // 라디오 버튼 (1,2)
			String locTypeCode 	 = mtyWeeklySimulationOptionVO.getLocTypeCode();    // Location By 의 select box
			String subLocCd      = mtyWeeklySimulationOptionVO.getSubLocCd();       // Location By 의 입력값			
			String locTpCdSecond = mtyWeeklySimulationOptionVO.getLocTpCdSecond();  // Location 의 select box			
			String locCdSecond   = mtyWeeklySimulationOptionVO.getLocCdSecond();    // Location 의 입력값
			String locGrpCd      = mtyWeeklySimulationOptionVO.getLocGrpCd();       // Location Group Code 의 입력값
			
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
			
			// 로직정리 (신용찬)
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
			
			mtyWeeklySimulationOptionVO.setPresentFlag(presentFlag);
			mtyWeeklySimulationOptionVO.setConditionFlag(conditionFlag);
			mtyWeeklySimulationOptionVO.setConditionValue(conditionValue);
			
			log.debug(">>>>>>>>>>>>> present_flag 	    : " +presentFlag);
			log.debug(">>>>>>>>>>>>> condition_flag 	: " +conditionFlag);
			log.debug(">>>>>>>>>>>>> condition_value 	: " +conditionValue);
			
			/*
			if(divFlag.equals("1")) { // 라디오 버튼 첫번째 선택
				if(mtyWeeklySimulationOptionVO.getSubLocCd() != null && !"".equals(mtyWeeklySimulationOptionVO.getSubLocCd())){ // 첫번째 라디오의 Location 입력값이 있을때
					if(locTypeCode.equals("RE")){  // location by : RCC (by ECC)
						mtyWeeklySimulationOptionVO.setLocGrpCd("E");
					}else{
						mtyWeeklySimulationOptionVO.setLocCd(mtyWeeklySimulationOptionVO.getSubLocCd()); // sub_loc_cd --> loc_cd 에 넣기
						if(locTypeCode.equals("LS") || locTypeCode.equals("ES")){
							mtyWeeklySimulationOptionVO.setLocGrpCd("S");
						}else if(locTypeCode.equals("LE")){
							mtyWeeklySimulationOptionVO.setLocGrpCd("E");
						}
					}
				}else{ // 첫번째 라디오의 Location 입력값이 없을때
					mtyWeeklySimulationOptionVO.setLocTypeCode("");
					mtyWeeklySimulationOptionVO.setDivFlag("");  // 라디오 버튼 선택없는것으로 변경
				}
			
			}else if(divFlag.equals("2")) {
				if(locCdSecond != null && !"".equals(locCdSecond)){ // 두번째 라디오의 Location 입력값이 있을때
					if(locTpCdSecond.equals("L")) mtyWeeklySimulationOptionVO.setLocGrpCd("L");
					if(locTpCdSecond.equals("E")) mtyWeeklySimulationOptionVO.setLocGrpCd("E");
					if(locTpCdSecond.equals("S")) mtyWeeklySimulationOptionVO.setLocGrpCd("S");
				}else { // 두번째 라디오의 Location 입력값이 없을때
					mtyWeeklySimulationOptionVO.setDivFlag("");  // 라디오 버튼 선택없는것으로 변경
				}
			}
			
			log.debug(">>>>>>>>>>>>> loc_grp_cd       : " +mtyWeeklySimulationOptionVO.getLocGrpCd());
			log.debug(">>>>>>>>>>>>> loc_type_code    : " +mtyWeeklySimulationOptionVO.getLocTypeCode());
			log.debug(">>>>>>>>>>>>> div_flag         : " +mtyWeeklySimulationOptionVO.getDivFlag());	
			log.debug(">>>>>>>>>>>>> loc_cd           : " +mtyWeeklySimulationOptionVO.getLocCd());	
			*/
			
			return dbDao.searchMtyWeeklySimulationReport(mtyWeeklySimulationOptionVO, rptTtl);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Weekly Simulation Retrieve"}).getMessage(),ex);
		}
	}
	 
	/**
	 * 입력 받은 rcc/lcc/ecc가 해당 rcc에 속하는지 체크
	 * 
	 * @param MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO
	 * @return String
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public String checkSubLocCd(MtyWeeklySimulationOptionVO mtyWeeklySimulationOptionVO) throws EventException {
		try{
			return dbDao.checkSubLocCd(mtyWeeklySimulationOptionVO);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("EQR10028", new String[]{"MTY Weekly Simulation Retrieve"}).getMessage(),ex);
		}
    }
}