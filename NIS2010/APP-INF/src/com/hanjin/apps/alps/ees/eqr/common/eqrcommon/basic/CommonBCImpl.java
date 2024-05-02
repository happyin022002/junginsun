/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : eqrcommonBCImpl.java
*@FileTitle : Max UPD_USR_ID , UPD_DT 조회 
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1      	1.0      	채창호								2009.07.09		1.0 최초 생성
* 2		1.1		Lee Byoung Hun				2010.05.11		CSR No : CHM-201003779 - getUserInfo 메소드 추가
*
*@LastModifyDate : 2009.07.09
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.09 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.common.eqrcommon.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.integration.CommonDBDAO;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.vo.EesCommonConditionVO;
import com.hanjin.apps.alps.ees.eqr.common.eqrcommon.vo.EesCommonVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.EqrEqRepoPlnVO;

/**
 * ALPS-eqrcommon Business Logic Basic Command implementation<br>
 * - ALPS-eqrcommon에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Chae Change Ho
 * @see eqrcommonEventResponse,eqrcommonBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class CommonBCImpl extends BasicCommandSupport implements CommonBC {

	// Database Access Object
	private transient CommonDBDAO dbDao = null;
	private String newHolidayTitle = "";
	/**
	 * eqrcommonBCImpl 객체 생성<br>
	 * eqrcommonDBDAO를 생성한다.<br>
	 */
	public CommonBCImpl() {
		dbDao = new CommonDBDAO();
	}

	/**
	 * ECC Information convertiong 조회 <br>
	 * 
	 * @param loctype
	 * @param location 
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO convertECCInfo(String loctype, String location) throws EventException {
		
		try {				
            return  dbDao.convertECCInfo(loctype, location);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	

	/**
	 * ECC Information convertiong 조회후 ecc string 리턴 <br>
	 * 
	 * @param loctype
	 * @param location 
	 * @return String eccWhereCondition
	 * @exception EventException
	 */
	public CommonVO convertECCInfoString(String loctype, String location) throws EventException {
		
		try {				
	        return dbDao.convertECCInfoString(loctype, location);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * yard code의 해당 ECC를 검색하여 리턴
	 * 
	 * @param yard_code
	 * @param column_name
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO convertYardToECC(String yard_code, String column_name) throws EventException {
			
		try {				
			return dbDao.convertYardToECC(yard_code, column_name);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	

	/**
	 * Scnr_id Remark 조회하고 
	 * SCNR_AUTO_GEN_FLG, REPO_PLN_CRE_FLG, REPO_PLN_DTRB_FLG 조회하여 
	 * 결과값을 같이 retrun 한다. <br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 * scnr_id : 시나리오 full 이름
	 * YYYYWW  : 년주차
	 * MonthGap : 조회개월 수 차이 
	 * WeeklyGap : 조회 할 주차 
	 * 
	 */	
	public EesCommonVO scnridReMarkSearch (EesCommonConditionVO conditionVO) throws EventException {
        DBRowSet rowSet 		 = null; 	//데이터 전송을 위해 DB ResultSet을 구현한 객체  
        EesCommonVO eesCommonVO = new EesCommonVO();
        String[] result = null;
        String[] result1 = null;
        String[] result2 = null;
        String   result3 = null;
        String[] result4 = null;
        String   result5 = null;
			
		String scnr_id = "SCEN"+ conditionVO.getYyyyww() +"W" + conditionVO.getSeq();
		try {				
			rowSet  = dbDao.scnridReMarkSearch(scnr_id).getDbRowset();
			result  = dbDao.weewklyConvertMonth(conditionVO.getYyyyww() ,16).getResultStrArray();
			result1 = dbDao.titleMaxMonth(result).getResultStrArray();
			result2 = dbDao.titleMaxWeek(result).getResultStrArray();
			result3 = dbDao.monthCount(result).getResultString();
			result4 = dbDao.weewklyConvertMonth(conditionVO.getYyyyww() ,16).getResultStrArray();//max 16주 
			result5 = dbDao.todayWeekly().getResultString();
			eesCommonVO.setRowSet(rowSet);
			eesCommonVO.setResultset(result);
			eesCommonVO.setResultset1(result1);
			eesCommonVO.setResultset2(result2);
			eesCommonVO.setResultset3(result3);
			eesCommonVO.setResultset4(result4);
			eesCommonVO.setResultset5(result5);
			
			return  eesCommonVO;
			
		} catch (DAOException de) { 
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * repo_plan_id Remark 조회하고 SCNR_AUTO_GEN_FLG, REPO_PLN_CRE_FLG, REPO_PLN_DTRB_FLG 조회하여  <br>
	 * 결과값을 같이 retrun 한다.
	 * 
	 * @param conditionVO EesCommonConditionVO 
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO repoidReMarkSearch (EesCommonConditionVO conditionVO) throws EventException {
		List<EqrEqRepoPlnVO> list 		 = null; 	//데이터 전송을 위해 DB ResultSet을 구현한 객체  
        EesCommonVO eesCommonVO = new EesCommonVO();
        String[] result  = null;
        String[] result1 = null;
        String[] result2 = null;
        String   result3 = null;
        String[] result4 = null;
        String   result5 = null;
        String[] result6 = null;
        String   result7 = null;
        String   result8 = null;  // user client pc current week가 repoplan week보다 같거나 커야 수정가능 
        String[] result9 = null;
        String   result10= null;   // repo plan id 주차의 다음주 정보 
        String   result11= null;   // user client pc current week가 repoplan week보다 한주 작거나 같거나 커야 split 수정가능 
        
		String repo_id = Constants.REPO_WORD + conditionVO.getYyyyww() + Constants.REPO_WEEK + conditionVO.getSeq();
		try {				
			list = dbDao.repoidReMarkSearch(repo_id);
			result = dbDao.weewklyConvertMonth(conditionVO.getYyyyww() ,4).getResultStrArray();
			result1 = dbDao.titleMaxMonth(result).getResultStrArray();
			result2 = dbDao.titleMaxWeek(result).getResultStrArray();
			result3 = dbDao.monthCount(result).getResultString();
			result4 = dbDao.weewklyConvertMonth(conditionVO.getYyyyww() ,9).getResultStrArray();//max 9주 
			result5 = dbDao.fromToRepoPlnId(repo_id).getResultString();//전후 8개 id
			result6 = dbDao.scnrIdList(repo_id).getResultStrArray();//SCNR_ID LIST
			result7 = dbDao.todayWeekly().getResultString();
			result8 = dbDao.exePlnEditFlg(conditionVO.getYyyyww(), conditionVO.getLocaldate()).getResultString();
			result9 = dbDao.weewklyMaxWkStr(conditionVO.getYyyyww() ,9).getResultStrArray();//max 9주 , 구분.
			result10= dbDao.getNextPrevWeek(conditionVO.getYyyyww(), 1, "NEXT").getResultString();  // repoPlnWeek의 1주 미래주 정보
			result11 = dbDao.exePlnEditFlgPrevOneWeek(conditionVO.getYyyyww(), conditionVO.getLocaldate()).getResultString();
			
//			log.debug("\n result8 ==========>" + result8);
			eesCommonVO.setList(list);
			eesCommonVO.setResultset(result);
			eesCommonVO.setResultset1(result1);
			eesCommonVO.setResultset2(result2);
			eesCommonVO.setResultset3(result3);
			eesCommonVO.setResultset4(result4);
			eesCommonVO.setResultset5(result5);
			eesCommonVO.setResultset6(result6);
			eesCommonVO.setResultset7(result7);
			eesCommonVO.setResultset8(result8);
			eesCommonVO.setResultset9(result9);
			eesCommonVO.setResultset10(result10);
			eesCommonVO.setResultset11(result11);
			
			return  eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * weeklyConditionSearch <br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO weeklyConditionSearch(EesCommonConditionVO conditionVO) throws EventException {
		EesCommonVO eesCommonVO = new EesCommonVO();
        String[] result = null;
            
	    try {				
	        result = dbDao.weewklyConvertMonth(conditionVO.getYyyyww() ,16).getResultStrArray();
	        eesCommonVO.setResultset(result);    
			return  eesCommonVO;				
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}

	}
	
	/**
	 * CheckFlg  조회 <br>
	 * 
	 * @param scnr_id String
	 * @return CommonVO getResultString()
	 * @exception EventException
	*/
	public CommonVO searchADRflg(String scnr_id) throws EventException {
		try {				
			return dbDao.searchADRflg(scnr_id);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * MAX UPD_USR_ID, UPD_DT  조회 <br>
	 * 
	 * @param table
	 * @param condition 
	 * @return CommonVO getResultStrArray()
	 * @exception EventException
	 */
	public CommonVO searchMaxInfo(String table, String condition) throws EventException {
		CommonVO maxInfo ;  

		try {				
			maxInfo = dbDao.searchMaxInfo(table, condition);
            
			return maxInfo;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * Year별 Week 조회 <br>
	 * 
	 * @param year String
	 * @return CommonVO getList()
	 * @exception EventException
	 */
	public CommonVO searchWeek(String year) throws EventException {
		CommonVO countWeek = null;

		try {				
			countWeek = dbDao.searchWeek(year);
            
			return countWeek;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Year별 Week 조회 <br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO getResultString()
	 * @exception EventException
	 */
	public EesCommonVO checkEccCode(EesCommonConditionVO conditionVO) throws EventException {
		EesCommonVO eesCommonVO = new EesCommonVO();
		String check;
		try {				
			check = dbDao.checkEccCode(conditionVO).getResultString();
			eesCommonVO.setResultECC(check);
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Year별 Week 조회 <br>
	 * 
	 * @param ecc_cd String
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO checkEccCode(String ecc_cd) throws EventException{
		EesCommonConditionVO conditionVO = new EesCommonConditionVO();
		conditionVO.setEcccd(ecc_cd);
		return checkEccCode(conditionVO);
	}

	/**
	 * checkLocCode <br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public EesCommonVO checkLocCode(EesCommonConditionVO conditionVO) throws EventException {
		EesCommonVO eesCommonVO = new EesCommonVO();
		String loccd_result = null;

		try {				
			loccd_result = dbDao.checkLocCode(conditionVO).getResultString();
			eesCommonVO.setLoccdResult(loccd_result);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * checkLocCodeWithMaster <br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public EesCommonVO checkLocCodeWithMaster(EesCommonConditionVO conditionVO) throws EventException {
		EesCommonVO eesCommonVO = new EesCommonVO();
		String loccd_result;
		try {				
			loccd_result = dbDao.checkLocCodeWithMaster(conditionVO).getResultString();
			eesCommonVO.setLoccdResult(loccd_result);
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * SCNR_RMK 수정 <br>
	 * 
	 * @param scnrId
	 * @param scnrRmk
	 * @param usrId
	 * @return CommonVO isResultBoolean()
	 * @exception EventException
	 */
	public CommonVO modifyScnrRmk(String scnrId, String scnrRmk, String usrId) throws EventException { 
		CommonVO check;

		try {				
			check = dbDao.modifyScnrRmk(scnrId, scnrRmk, usrId);
			return check;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * REPO_RMK 수정 <br>
	 * 
	 * @param repoId
	 * @param repoRmk
	 * @param usrId 
	 * @return CommonVO isResultBoolean()
	 * @exception EventException
	 */
	public CommonVO modifyRepoRmk(String repoId, String repoRmk, String usrId) throws EventException { 
		CommonVO check ;

		try {				
			check = dbDao.modifyRepoRmk(repoId, repoRmk, usrId);
			return check;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	

	/**
	 * 01주차일 경우 현년도의 min, 전년도 max 조회 <br>
	 * 
	 * @param curYear
	 * @return CommonVO getResultStrArray()
	 * @exception EventException
	 */
	public CommonVO minMax01(String curYear) throws EventException {
		CommonVO info ;  

		try {				
			info = dbDao.minMax01(curYear);
            
			return info;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 52주차일 경우 현년도의 max, 내년도 min 조회 <br>
	 * 
	 * @param curYear
	 * @return CommonVO getResultStrArray()
	 * @exception EventException
	 */
	public CommonVO maxMin52(String curYear) throws EventException {
		CommonVO info ;  

		try {				
			info = dbDao.maxMin52(curYear);
            
			return info;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 특정년도의 최대,최소 week 01, 53형태로 리턴 <br>
	 * 
	 * @param curYear
	 * @return CommonVO getResultStrArray()
	 * @exception EventException
	 */
	public CommonVO getMinMaxWeek(String curYear) throws EventException {
		CommonVO info ;  

		try {				
			info = dbDao.getMinMaxWeek(curYear);           
			return info;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * holiday select
	 * 
	 * @param stHolYr
	 * @param endHolYr 
	 * @param stHolWk  
	 * @param endHolWk 
	 * @return CommonVO getResultStrArray()
	 * @exception EventException
	 */
	public CommonVO newHolidaySelect(String stHolYr, String endHolYr, String stHolWk, String endHolWk) throws EventException {
		String[] wkArr = null; 
		CommonVO retVO = new CommonVO();
		String newTitle = "";
		StringBuffer newTitleBuf = new StringBuffer();
		String wkInfo_0 = "";
		String wkInfo_1 = "";

		try {				
			String[] wkInfo = {"",""};

			if(stHolWk.equals("00") || stHolWk.equals("01")){
				wkInfo = minMax01(stHolYr).getResultStrArray(); 
			}else{
				if(endHolWk.equals("00") || endHolWk.equals("01")){
					wkInfo = minMax01(endHolYr).getResultStrArray(); 
				}
				if(endHolWk.equals("52") || endHolWk.equals("53")){
					wkInfo = maxMin52(endHolYr).getResultStrArray(); 
				}
			}
			if(stHolWk.equals("52") || stHolWk.equals("53")){
				wkInfo = maxMin52(stHolYr).getResultStrArray(); 
			}else{
				if(endHolWk.equals("00") || endHolWk.equals("01")){
					wkInfo = minMax01(endHolYr).getResultStrArray(); 
				}
				if(endHolWk.equals("52") || endHolWk.equals("53")){
					wkInfo = maxMin52(endHolYr).getResultStrArray(); 
				}
			}

			
		    if(stHolWk.equals(endHolWk)){
		    	wkArr = new String[3];
		    }else{
		    	wkArr = new String[4];
		    }
		    
		    if(wkInfo[0].length()>0){//200552
		    	wkInfo_0 = wkInfo[0].substring(4,6);//52
		    	wkInfo_1 = wkInfo[1].substring(4,6);
		    }
		    
		    if(wkInfo != null){
			    if((stHolWk.equals("00") || stHolWk.equals("01"))){
			    	if(stHolWk.equals(wkInfo_0)){
			    		//log.debug("\n >>>>당해년도 시작주차가 조건과 동일한 경우"+wkInfo[0]+" / "+wkInfo[1]);
				    	wkArr[0] = wkInfo[1];
				    	wkArr[1] = stHolYr + stHolWk;//self
				    	
				    	if(stHolWk.equals(endHolWk)){//3개주
				    		wkArr[2] = endHolYr + Utils.fill((String.valueOf(Integer.parseInt(endHolWk) + 1)), 2, "0", "left");
				    		//log.debug("\n 3개주=="+endHolWk+ " :"+wkArr[2]);
				    	}else{//4개주.
				    		//log.debug("\n 4개주==");
				    		wkArr[2] = endHolYr + endHolWk;
				    		wkArr[3] = endHolYr + Utils.fill((String.valueOf(Integer.parseInt(endHolWk) + 1)), 2, "0", "left");
				    	}
				    }else{
				    	//log.debug("\n >>>>조건이 01인데, 00주차가 있는 경우"+wkInfo[0]+" / "+wkInfo[1]);
				    	wkArr[0] = wkInfo[0];
				    	wkArr[1] = stHolYr + stHolWk;//self
				    	if(stHolWk.equals(endHolWk)){//3개주
				    		wkArr[2] = endHolYr + Utils.fill((String.valueOf(Integer.parseInt(endHolWk) + 1)), 2, "0", "left");
				    	}else{//4개주.
				    		wkArr[2] = endHolYr + endHolWk;
				    		wkArr[3] = endHolYr + Utils.fill((String.valueOf(Integer.parseInt(endHolWk) + 1)), 2, "0", "left");
				    	}
				    }
			    }
			    
			    else if((stHolWk.equals("52") || stHolWk.equals("53"))){
			    	
			    	if(stHolWk.equals(wkInfo_0)){
			    		//log.debug("\n >>>>당해년도 시작주차가 조건과 동일한 경우[52]"+wkInfo[0]+" / "+wkInfo[1]);
				    	wkArr[0] = stHolYr + Utils.fill((String.valueOf(Integer.parseInt(stHolWk) - 1)), 2, "0", "left");
				    	wkArr[1] = stHolYr + stHolWk;//self
			    	
				    	if(stHolWk.equals(endHolWk)){//3개주.
				    		wkArr[2] = wkInfo[1];
				    	}else{//4개주.
				    		wkArr[2] = endHolYr + endHolWk;
				    		//----
				    		if(endHolWk.equals(wkInfo_1)){
				    			wkArr[3] = endHolYr + Utils.fill((String.valueOf(Integer.parseInt(endHolWk) + 1)), 2, "0", "left");
				    		}else{
				    			wkArr[3] = wkInfo[1];
				    		}
				    		
				    	}
				    }else{
				    	//log.debug("\n >>>>조건이 52인데, 53주차가 있는 경우[52]"+wkInfo[0]+" / "+wkInfo[1]);
				    	wkArr[0] = stHolYr + Utils.fill((String.valueOf(Integer.parseInt(stHolWk) - 1)), 2, "0", "left");
				    	wkArr[1] = stHolYr + stHolWk;//self
				    	
				    	if(stHolWk.equals(endHolWk)){//3개주.
				    		wkArr[2] = wkInfo[0];
				    	}else{//4개주.
				    		wkArr[2] = endHolYr + endHolWk;
				    		wkArr[3] = wkInfo[1];
				    	}
				    }
			    }
			    else{//일반적인 경우.
			    	wkArr[0] = stHolYr + Utils.fill((String.valueOf(Integer.parseInt(stHolWk) - 1)), 2, "0", "left");
			    	wkArr[1] = stHolYr + stHolWk;//self
			    	if(stHolWk.equals(endHolWk)){//3개주.
			    		wkArr[2] = stHolYr + Utils.fill((String.valueOf(Integer.parseInt(stHolWk) + 1)), 2, "0", "left");
			    	}else{
			    		wkArr[2] = endHolYr + endHolWk;
			    		//----
			    		if(endHolWk.equals(wkInfo_0)){
			    			wkArr[3] = wkInfo[1];
			    		}else{
			    			wkArr[3] = endHolYr + Utils.fill((String.valueOf(Integer.parseInt(endHolWk) + 1)), 2, "0", "left");
			    		}
			    	}
			    }
			    
			    
			    for(int k = 0; k < wkArr.length; k++){
			    	newTitleBuf.append("wk"+wkArr[k]+"|");
			    	//log.debug("\n" + wkArr[k]);
			    }
			    
			    newTitle = newTitleBuf.toString().substring(0,newTitleBuf.toString().length()-1);
			    setNewHolidayTitle(newTitle);//wk200603|wk200604|wk200605|wk200606  형식.
			    //log.debug("\n newTitle : "+newTitle);
		    }		    
		    retVO.setResultStrArray(wkArr);
			return retVO;
			
		} catch (EventException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	

	/**
	 * New Holiday Title 변수값 불러오
	 * 
	 * @param 
	 * @return getNewHolidayTitle
	 * @exception 
	 */
	public String getNewHolidayTitle() {
		return newHolidayTitle;
	}

	/**
	 * New Holiday Title 변수값 저장
	 * 
	 * @param newHolidayTitle
	 * @return 
	 * @exception 
	 */
	public void setNewHolidayTitle(String newHolidayTitle) {
		this.newHolidayTitle = newHolidayTitle;
	}

	/**
	 * month info 조회 <br>
	 * 
	 * @param conStr String[]
	 * @return  CommonVO getResultStrArray()
	 * @exception EventException
	 */
	public CommonVO tiltelMakMonth(String[] conStr) throws EventException {
		CommonVO monthInfo ;        
			
		try {				
			monthInfo = dbDao.titleMaxMonth(conStr);
            
			return monthInfo;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 * week info 조회 <br>
	 * 
	 * @param conStr String[]
	 * @return CommonVO getResultStrArray()
	 * @exception EventException
	 */
	public CommonVO tiltelMakWeek(String[] conStr) throws EventException {
		CommonVO weekInfo = null;        
			
		try {				
			weekInfo = dbDao.titleMaxWeek(conStr);
            
			return weekInfo;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}			
	
	/**
	 * month에 포함된 주차갯수 조회 <br>
	 * 
	 * @param conStr String[]
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO monthCount(String[] conStr) throws EventException {
		CommonVO monthInCount ;        
			
		try {				
			monthInCount = dbDao.monthCount(conStr);
            
			return monthInCount;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}					

	/**
	 * LOC YARD Exist 이벤트 처리<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 * @화면 기능 : Vendor 코드 조회 
	 */
	public EesCommonVO searchLocYardExist(EesCommonConditionVO conditionVO) throws EventException {		
		EesCommonVO eesCommonVO = new EesCommonVO();
        String result = null;
        String ecc    = conditionVO.getLocyardexistEcc();
        String locyard= conditionVO.getLocyardexistLocyard();
       
		try {
			result = dbDao.searchLocYardExist(locyard, ecc).getResultString();
			eesCommonVO.setLocyardExistResult(result);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * LOC YARD Company Exist 이벤트 처리<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 * @화면 기능 : Vendor 코드 조회 
	 */
	public EesCommonVO searchLocYardCompanyExist(EesCommonConditionVO conditionVO) throws EventException {		
		EesCommonVO eesCommonVO = new EesCommonVO();
        String result = null;
        //String ecc    = event.getLocyardExistCompany_ecc();
        String locyard= conditionVO.getLocyardexistcompanyLocyard();
       
		try {
			result = dbDao.searchLocYardCompanyExist(locyard).getResultString();
			eesCommonVO.setLocyardExistCompanyResult(result);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * LOC YARD 검색 이벤트 처리<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 * @화면 기능 : Vendor 코드 조회 
	 */
	public EesCommonVO searchLocYardInfo(EesCommonConditionVO conditionVO) throws EventException {		
		
        String[] result = null;
       
		try {
			result = dbDao.searchLocYardInfo(conditionVO.getLocyardSearchword()).getResultStrArray();
			EesCommonVO eesCommonVO = new EesCommonVO();
			
			eesCommonVO.setLocyardResult(result);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * LOC YARD 검색 이벤트 처리<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return eesCommonVO
	 * @exception EventException
	 * @화면 기능 : Vendor 코드 조회 
	 */
	public EesCommonVO searchLocYardCompanyInfo(EesCommonConditionVO conditionVO) throws EventException {		
        String[] result = null;
       
		try {
			result = dbDao.searchLocYardCompanyInfo(conditionVO.getLocyardSearchword()).getResultStrArray();
			EesCommonVO eesCommonVO = new EesCommonVO();
			
			eesCommonVO.setLocyardCompanyResult(result);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * LOC YARD(vessel) 검색 이벤트 처리<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 * @화면 기능 : Vendor 코드 조회 
	 */
	public EesCommonVO searchLocYardVesselInfo(EesCommonConditionVO conditionVO) throws EventException {	
        String[] result = null;
       
		try {
			result = dbDao.searchLocYardVesselInfo(conditionVO.getLocyardSearchword()).getResultStrArray();
			EesCommonVO eesCommonVO = new EesCommonVO();
			
			eesCommonVO.setLocyardResult(result);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * LOC YARD INITIAL 검색 이벤트 처리<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 * @화면 기능 : Vendor 코드 조회 
	 */
	public EesCommonVO searchLocYardInitialInfo(EesCommonConditionVO conditionVO) throws EventException {
        String[] result = null;
        String ecc    = conditionVO.getLocyardinitialEcc();  // FROM LOCATION, TO LOCATION
        String vsl    = conditionVO.getLocyardinitialVsl();  // VVD 정보 (WATER 모드의 경우 VVD 가 없을수도 있음)
        String item   = conditionVO.getLocyardinitialItem(); // 운송모드 (V, W)

    	String vslCd    = "";
    	String skdVoyNo = "";
    	String skdDirCd = "";    	        	    	
		
        String resultFlag = "";  // 검색결과 표현(중요)  1 : 1개 yard검색, 2 : 복수개 vessel yard 검색, 3 : mdm_yard 검색 
		try {
			/* ITEM (V, W) + VSL 정보로 1차 판단
			 * 1. Vessel OR Water(VVD 있는  경우) 
			 * - 1 STEP 
			 *     VSK_VSL_PORT_SKD 에서 YARD 검색 (VVD + LOCATION)  
			 * - 2 STEP 
			 *     1STEP 검색결과 NULL : MDM YARD 검색 (CODE, NAME)
			 *     1STEP 검색결과 존재   : 검색값을 화면에 표현 (1개 이거나 1개 이상)  
			 * 
			 * 2. Water(VVD 없는 경우)
			 * - 1 STEP 
			 *     PRD_PORT_TML_MTX 에서 YARD 검색 (FDR 검색)   
			 * - 2 STEP 
			 *     1STEP 검색결과 NULL : MDM YARD 검색 (CODE, NAME)
			 *     1STEP 검색결과 존재   : 검색값을 화면에 표현 (1개)   
			 */
			
			if(item.equals("W") && (vsl.equals("") || vsl==null)) { // Water(VVD 없는 경우)

				// 1 STEP : PRD_PORT_TML_MTX 에서 YARD 검색 (FDR 검색)
				result = dbDao.searchLocYardInitialInfo(ecc).getResultStrArray();
				resultFlag = "1";
				
				// 1STEP 검색결과 NULL : MDM VESSEL YARD 검색 (CODE|NAME, CODE)
				if((result[1]==null || result[1].equals("") )) {  
					result = dbDao.searchLocYardVesselInfo(ecc).getResultStrArray();		
					resultFlag = "3";
				}
							
			}else { // Vessel OR Water(VVD 있는  경우) 

				//1 STEP : VSK_VSL_PORT_SKD 에서 YARD 검색 (VVD + LOCATION)
				if(vsl.length() == 9) {
					vslCd    = vsl.substring(0,4);
		    		skdVoyNo = vsl.substring(4,8);
		    		skdDirCd = vsl.substring(8,9);    	        	    	
				}
				
				result = dbDao.searchLocVesselYardInitialInfo(ecc, vslCd, skdVoyNo, skdDirCd).getResultStrArray();
				
				if((result[0]==null || result[0].equals("")) && (result[1]==null || result[1].equals(""))) resultFlag = "3"; // 1STEP 검색결과 NULL 
				else if(result[1]==null || result[1].equals("")) resultFlag = "1"; // 1개의   vessel schedule yard 검색됨.
				else				  			                 resultFlag = "2"; // 2개 이상의 vessel schedule yard 검색됨.
				
				//1STEP 검색결과 NULL : MDM VESSEL YARD 검색 (CODE, NAME)
				if(resultFlag.equals("3")) {  			
					result = dbDao.searchLocYardVesselInfo(ecc).getResultStrArray();		
					resultFlag = "3";		
				}				
				
			}				
			
			EesCommonVO eesCommonVO = new EesCommonVO();

			eesCommonVO.setResultset7(resultFlag);	 // resultFlag 3가지(1,2,3)중에 하나를 view 에서 봐야함.		
			eesCommonVO.setLocyardInitialResult(result);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 * 임대사 YARD 검색 이벤트 처리<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchLseCoYardInfo(EesCommonConditionVO conditionVO) throws EventException {	
        String[] result = null;
       
		try {
			
			//F, O에 따라서 DAO 를 분기한다.
			//ON-HIRE : FROM LOC 조회시 임대사정보를 조회.(TO LOC 는 searchLocYardInfo)
			//OFF-HIRE : TO LOC 조회시 임대사 정보를 조회.(FROM LOC 는 searchLocYardInfo)
			if(
			   (conditionVO.getLocyardDivCd().equals("O") && conditionVO.getLocyardColname().equals("t3_fm_yd_cd")) ||
			   (conditionVO.getLocyardDivCd().equals("F") && conditionVO.getLocyardColname().equals("t3_to_yd_cd"))
			){
				result = dbDao.searchLseCoYardInfo(conditionVO).getResultStrArray();
			}else{
				result = dbDao.searchLocYardInfo(conditionVO.getLocyardSearchword()).getResultStrArray();	
			}
			
			EesCommonVO eesCommonVO = new EesCommonVO();		
			eesCommonVO.setLocyardResult(result);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * LOC YARD-ECC 검색 이벤트 처리<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 * @화면 기능 : Vendor 코드 조회 
	 */
	public EesCommonVO searchLocYardEccInfo(EesCommonConditionVO conditionVO) throws EventException {		
		String[] result = null;
      
		try {
			result = dbDao.searchLocYardEccInfo(conditionVO.getLocyardSearchword(), conditionVO.getLocyardEcc()).getResultStrArray();
			EesCommonVO eesCommonVO = new EesCommonVO();
			
			eesCommonVO.setLocyardeccResult(result);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * VENDOR 검색 이벤트 처리<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 * @화면 기능 : Vendor 코드 조회 
	 */
	public EesCommonVO searchVendorInfo(EesCommonConditionVO conditionVO) throws EventException {	
        String[] result = null;
       
		try {
			result = dbDao.searchVendorInfo(conditionVO.getVendorSearchword()).getResultStrArray();
			EesCommonVO eesCommonVO = new EesCommonVO();
			
			eesCommonVO.setVendorResult(result);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	
	/**
	 * VENDOR 검색 이벤트 처리<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchVendorInfoBySeq(EesCommonConditionVO conditionVO) throws EventException {	
        String[] result = null;
       
		try {
			EesCommonVO eesCommonVO = new EesCommonVO();
			
			result = dbDao.searchVendorInfoBySeq(conditionVO.getSeqSearchword()).getResultStrArray();			
			eesCommonVO.setSeqResult(result);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 * VVD 검색 이벤트 처리<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchVvdInfo(EesCommonConditionVO conditionVO) throws EventException {		
        String[] result = null;
       
		try {
			result = dbDao.searchVvdInfo(conditionVO).getResultStrArray();
			EesCommonVO eesCommonVO = new EesCommonVO();
			
			eesCommonVO.setVvdResult(result);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 * vvd combo box 정보를 검색
	 * Execute Plan Inland에서 Fixed Plan에서 Row Add 버튼 클릭시 To LOC(ECC), ETA Week 에 해당하는 정보를 검색
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchVvdInlandInfo(EesCommonConditionVO conditionVO) throws EventException {	
        String[] result = null;
       
		try {
			result = dbDao.searchVvdInlandInfo(conditionVO.getVvdinlandFmecc(), conditionVO.getVvdinlandToecc(), conditionVO.getVvdinlandEtaweek()).getResultStrArray();
			EesCommonVO eesCommonVO = new EesCommonVO();
			
			eesCommonVO.setVvdInlandResult(result);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * VVD 검색 이벤트 처리<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchVvdExist(EesCommonConditionVO conditionVO) throws EventException {		
		
        String[] result = null;
        String vvd_check = "";
               
		try {
			
	        String division 	= conditionVO.getVvdexistDivision();
//	        String repo_pln_id 	= event.getVvdExist_repoplnid();
	        String searchword 	= conditionVO.getVvdexistSearchword();
	        String ecc_cd 		= conditionVO.getVvdexistEcccd();
	        String pln_yrwk 	= conditionVO.getVvdexistPlnyrwk();
	        String scnr_id      = conditionVO.getVvdexistScnrid();
			
//			result = dbDao.searchVvdExist(division, repo_pln_id, searchword, ecc_cd, pln_yrwk);
	        if(division.equals("etd"))  vvd_check = dbDao.checkVvdWater(scnr_id, searchword).getResultString();
			result = dbDao.searchVvdExist(division, searchword, ecc_cd, pln_yrwk).getResultStrArray();
	        
			EesCommonVO eesCommonVO = new EesCommonVO();	
			eesCommonVO.setVvdExistResult(result);
			eesCommonVO.setVvdExistVvdcheck(vvd_check);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 * Week에 대한 Scnr_id 검색 이벤트 처리<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 * @화면 기능 :  
	 */
	public EesCommonVO searchWeekScnrId(EesCommonConditionVO conditionVO) throws EventException {		
        String  result = null;
       
		try {
			result = dbDao.searchWeekScnrId(conditionVO).getResultString();
			EesCommonVO eesCommonVO = new EesCommonVO();
			
			eesCommonVO.setScnrId(result);			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	 
	/**
	 * Country 조회 <br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchCountryInfo(EesCommonConditionVO conditionVO) throws EventException {
		String[] country = null;  

		try {				
			country = dbDao.searchCountryInfo(conditionVO).getResultStrArray();
			
			EesCommonVO eesCommonVO = new EesCommonVO();
			eesCommonVO.setCountryinfo(country);
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * Period Valid Check 검색 이벤트 처리<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 * @화면 기능 :  
	 */
	public EesCommonVO searchCheckPeriod(EesCommonConditionVO conditionVO) throws EventException {	
		//DBRowSet rowSet 		 = null; 	//데이터 전송을 위해 DB ResultSet을 구현한 객체   
		String result = null;
		String[] weekInfo = null;
       
		try {
			
			if(conditionVO.getGubun().equals("Load")){
				weekInfo = dbDao.searchCheckPeriod(conditionVO).getResultStrArray();//default Period, edit Period
				result = dbDao.searchWeekScnrId(conditionVO).getResultString();
			}else{
				weekInfo = dbDao.searchCheckPeriod(conditionVO, conditionVO.getGubun()).getResultStrArray();//edit Period
				result = dbDao.searchWeekScnrId(conditionVO).getResultString();
			}
			EesCommonVO eesCommonVO = new EesCommonVO();
			//eesCommonVO.setRowSet(rowSet);
			eesCommonVO.setResultset(weekInfo);
			eesCommonVO.setResultset5(result);
			return  eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * Period Valid Check 검색 이벤트 처리(FM, To)<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 * @화면 기능 :  
	 */
	public EesCommonVO searchCheckPeriodOpt(EesCommonConditionVO conditionVO) throws EventException {		
		//DBRowSet rowSet 		 = null; 	//데이터 전송을 위해 DB ResultSet을 구현한 객체   
		String result = "";
		String[] weekInfo = null;
       
		try {
			
			if(conditionVO.getGubun().equals("Load")){
				weekInfo = dbDao.searchCheckPeriod(conditionVO).getResultStrArray();//default Period, edit Period
			}else{
				weekInfo = dbDao.searchCheckPeriodOpt(conditionVO ).getResultStrArray();//edit Period
			}
			EesCommonVO eesCommonVO = new EesCommonVO();
			//eesCommonVO.setRowSet(rowSet);
			eesCommonVO.setResultset(weekInfo);
			eesCommonVO.setResultset5(result);
			return  eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	
	/**
	 * week를 start Day 조회 <br>
	 * 
	 * @param yyyyww
	 * @return CommonVO getResultString()
	 * @exception EventException
	 * 
	 */
	public CommonVO searchWeekToDate(String yyyyww ) throws EventException {
		CommonVO stdt;        
			
		try {				
			stdt = dbDao.searchWeekToDate(yyyyww);
            
			return stdt;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * week를 endDay 조회 <br>
	 * 
	 * @param yyyyww	String
	 * @param strDs		String
	 * @return CommonVO getResultString()
	 * @exception EventException
	 * CSR NO :R200904090006
	 * 인수 strDs null이면 jdbc/HJSENIS으로 
	 *            null이 아니면  jdbc/xa/HJSENIS으로 DB Connect가 일어남 
	 */
	public CommonVO searchWeekEndDate(String yyyyww ,String strDs) throws EventException {
		CommonVO stdt ;        
			
		try {
			CommonDBDAO comDbDao = new  CommonDBDAO(strDs);
			stdt = comDbDao.searchWeekEndDate(yyyyww);
            
			return stdt;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * week를 start+gapmonth 조회 <br>
	 * 
	 * @param yyyyww	String
	 * @param gapmonth	String
	 * @param strDs		String
	 * @return CommonVO getResultString()
	 * @exception EventException
	 * CSR NO :R200904090006
	 * 인수 strDs null이면 jdbc/HJSENIS으로 
	 *            null이 아니면  jdbc/xa/HJSENIS으로 DB Connect가 일어남 
	 */
	public CommonVO searchWeekStartDate(String yyyyww, String gapmonth ,String strDs) throws EventException {
		CommonVO stdt ;        
			
		try {	
//			log.info("error ====>" + strDs);
			CommonDBDAO comDbDao = new  CommonDBDAO(strDs);
			stdt = comDbDao.searchWeekStartDate(yyyyww, gapmonth);
            
			return stdt;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * year week를 이용해서 일주일치 날짜를 가져오는  조회 <br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchBetweenWeek(EesCommonConditionVO conditionVO) throws EventException {
		String stdt = null;        
			
		try {				
			stdt = dbDao.searchBetweenWeek(conditionVO).getResultString();
			EesCommonVO eesCommonVO = new EesCommonVO();
			eesCommonVO.setWeekDaily(stdt);
			return eesCommonVO;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * REPO_ID를 이용해서 기존의 REPO_PLAN의 특성을 가져온다. <br>
	 * 
	 * @param repo_plan_id
	 * @return CommonVO getResultStrArray()
	 * @exception EventException
	 * 
	 * incl_onh_flg          = oldRepoPlantype[0];
	 * incl_offh_flg         = oldRepoPlantype[1];
	 * incl_cntr_tpsz_ctntg  = oldRepoPlantype[2];
	 * duration              = oldRepoPlantype[3];
	 */
	public CommonVO searchOldRepoPlantype(String repo_plan_id) throws EventException {
		CommonVO oldRepoPlantype = null;        
		
		try {				
			oldRepoPlantype = dbDao.searchOldRepoPlantype(repo_plan_id);
			return oldRepoPlantype;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * 새로운 시나리오 ID를 생성을 한다. . <br>
	 * 
	 * @param scnario_id String	: (기존 시나리오 ID)
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO createNewScnarioId(String scnario_id) throws EventException {
		CommonVO newScnario_id = null;        
		
		try {				
			newScnario_id = dbDao.createNewScnarioId(scnario_id);
			return newScnario_id;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * 새로운 REPO_PLAN_ID를 생성을 한다. <br>
	 * 
	 * @param repoPlanid String : ( 기존 REPO_PLAN_ID)
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO createNewRepoPlanId(String repoPlanId) throws EventException {
		CommonVO resultVO = new CommonVO();
		boolean resultBoolean = false;
		String resultRepoPlanId = null;
		
		try {	
			// REPO PLAN ID를 생성하려는 주차(201025) 에 이미 생성된 REPO PLAN ID 가 있는지 여부 확인
			// 존재하지 않으면 true, 존재한다면 false
			resultBoolean = dbDao.checkRepoPlanIdRow(repoPlanId).isResultBoolean();
			
			// 존재하지 않으면 SEQ = 999 로 하드코딩함.
			if (resultBoolean) {
				resultRepoPlanId = repoPlanId.substring(0, 11) + "999";
				resultVO.setResultString(resultRepoPlanId);
				
			// 생성하려는 주차(201025) 에 이미 생성된 REPO PLAN ID 가 존재하는 경우
			} else {
				resultVO = dbDao.createNewRepoPlanId(repoPlanId); // SEQ '999'를 제외한 상태에서 SEQ 가 증가됨. 000-->001-->002
			}
			
			return resultVO;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * 주차를 기준으로 해서 gap 기간의 주차 년,월을 시작 주차 부터 종료주차까지 가져온다. <br>
	 * 
	 * @param yyyyww String
	 * @param gap int
	 * @return CommonVO getResultStrArray()
	 * @exception EventException
	 */
	
	public CommonVO weewklyConvertMonth(String yyyyww , int gap) throws EventException{
		CommonVO yearwk = null;
		try {				
			yearwk = dbDao.weewklyConvertMonth(yyyyww , gap);
			return yearwk;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Week Date Period 검색 이벤트 처리<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 * @화면 기능 : Vendor 코드 조회 
	 */
	public EesCommonVO searchWeekDatePeriod(EesCommonConditionVO conditionVO) throws EventException {		
		EesCommonVO eesCommonVO = new EesCommonVO();

        String[] fromtoDate = null;
       
		try {
			fromtoDate = dbDao.searchWeekDatePeriod(conditionVO.getWeekperiodSearchword(), conditionVO.getWeekperiodDivision()).getResultStrArray();
			
			eesCommonVO.setWeekPeriodFromdate(fromtoDate[0]);
			eesCommonVO.setWeekPeriodTodate(fromtoDate[1]);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * search eta date 검색 이벤트 처리<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 * @화면 기능 : Vendor 코드 조회 
	 */
	public EesCommonVO searchEtaDate(EesCommonConditionVO conditionVO) throws EventException {		
		EesCommonVO eesCommonVO = new EesCommonVO();
		
        String etadate = null;
        
		try {
			etadate = dbDao.searchEtaDate(conditionVO).getResultString();			
			eesCommonVO.setEtadate(etadate);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * search eta date 검색 이벤트 처리<br>
	 * 
	 * @param etd
	 * @param fryard
	 * @param toyard
	 * @param item
	 * 
	 * @return CommonVO getResultString()
	 * @exception EventException
	 * @화면 기능 : Vendor 코드 조회 
	 */
	public CommonVO searchEtaDate(String etd, String fryard, String toyard, String item) throws EventException {		
	
		CommonVO etadate = null;
        
		try {
		
			etadate = dbDao.searchEtaDate(etd, fryard, toyard, item);
			
			return etadate;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 * 기준 week의 다음주(nextNum) 정보를 가져옵니다.
	 * ex) nextNum = 1 --> 기준주의 1주 다음
	 *     nextNum = 2 --> 기준주의 2주 다음
	 * ex) direction --> NEXT : 미래주차
	 *     direction --> PREV : 과거주차
	 *     
	 * @param yyyyww
	 * @param nextNum 
	 * @param direction 
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO getNextPrevWeek(String yyyyww, int nextNum, String direction) throws EventException {
		CommonVO nextWeek = null;  

		try {				
			nextWeek = dbDao.getNextPrevWeek(yyyyww, nextNum, direction);           
			return nextWeek;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * location code 검색
	 * level : R --> RCC_CD
	 *         L --> LCC_CD
	 *         
	 * @param ofc_cd
	 * @param level
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO getUserLocInfo(String ofc_cd, String level) throws EventException {
		CommonVO location_code = null;  

		try {				
			location_code = dbDao.getUserLocInfo(ofc_cd, level);           
			return location_code;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}		

	/**
	 * 현재주차 정보를 조회 
	 *     
	 * @param yyyyww
	 * @param nextNum 
	 * @param direction 
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO getCurrentWeek() throws EventException {
		CommonVO nextWeek = null;  

		try {				
			nextWeek = dbDao.todayWeekly();           
			return nextWeek;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}		
	
	/**
	 * location code 검색
	 * 
	 * @return CommonVO getResultStrArray()
	 * @exception EventException
	 */
	public CommonVO searchMaxRepoPlanId() throws EventException {
		CommonVO maxRepoPlanId = null;  

		try {				
			maxRepoPlanId = dbDao.searchMaxRepoPlanId();           
			return maxRepoPlanId;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}			

	/**
	 * ECC Information convertiong 조회후 ecc string 리턴 <br>
	 * 
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO getTpszInitial() throws EventException {
		CommonVO tpszInitial;
			
		try {				
			tpszInitial = dbDao.getTpszInitial();
            
			return tpszInitial;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * Yard Code의 Country code 를 검색해 옵니다.  <br>
	 * 
	 * @param  yard_code
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO getYardCNTCode(String yard_code) throws EventException {
		CommonVO cnt_code ;
			
		try {				
			cnt_code = dbDao.getYardCNTCode(yard_code);
            
			return cnt_code;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
		
	/**
	 * 날짜정보를 주차정보로 변경
	 *     
	 * @param date
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO convertDayWeekly(String date) throws EventException {
		CommonVO week = null;  

		try {				
			week = dbDao.convertDayWeekly(date);           
			return week;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}		
	
	
	/**
	 * VVD 중복을 체크를 하여 결과 리턴 
	 *     
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchDuplicatCheckPod(EesCommonConditionVO conditionVO) throws EventException {
		
		EesCommonVO eesCommonVO = new EesCommonVO();
		String searchDupicatCheck = null;

		try {				
			searchDupicatCheck = dbDao.searchDuplicatCheckPod(conditionVO).getResultString(); 
			eesCommonVO.setDuplicateCheck(searchDupicatCheck);
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/** CSRNO : N200806030017
	 * Period Valid Check 검색 이벤트 처리<br>
	 *  -8주차 체크를 하기 위해서 사용 화면 072에서 사용 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 * @화면 기능 :  
	 */
	public EesCommonVO searchBeforeCheckPeriod(EesCommonConditionVO conditionVO) throws EventException {		
		EesCommonVO eesCommonVO = new EesCommonVO();
		//DBRowSet rowSet 		 = null; 	//데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet rowSet = new DBRowSet();
		String result = null;
		String[] weekInfo = null;
       
		try {
			
			if(conditionVO.getGubun().equals("Match")) {
				weekInfo = dbDao.searchBeforeCheckPeriod(conditionVO).getResultStrArray();//default Period, edit Period
				result = dbDao.searchWeekScnrId(conditionVO).getResultString();
			}else{
				weekInfo = dbDao.searchBeforeCheckPeriod(conditionVO, conditionVO.getGubun() ).getResultStrArray();//edit Period
				result = dbDao.searchWeekScnrId(conditionVO).getResultString();
			}
			eesCommonVO.setRowSet(rowSet);
			eesCommonVO.setResultset(weekInfo);
			eesCommonVO.setResultset5(result);
			return  eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	
	/** CSRNO : N200806030017
	 * vessel  검색 이벤트 처리<br>
	 *  011에서 사용 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 * @화면 기능 :  
	 */
	public EesCommonVO searchVesselScheduleCheck(EesCommonConditionVO conditionVO) throws EventException {		
		EesCommonVO eesCommonVO = new EesCommonVO();
		String[] schedule = null;
       
		try {
			schedule =  dbDao.searchVesselScheduleCheck(conditionVO).getResultStrArray();
			eesCommonVO.setEtaEtdEtb(schedule);
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	/**
	 * EQR 업무 시나리오 마감작업<br>
	 * ScenarioDefaultManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
	
	/**
	 * 신규프로젝트 No: S2Q-09P-004
	 * 해당 VVD에 대한 BayPort List
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 *  EventException
	 */
	public EesCommonVO searchBayPort(EesCommonConditionVO conditionVO) throws EventException {
		EesCommonVO eesCommonVO = new EesCommonVO();
		//DBRowSet rowSet 		 = null; 	//데이터 전송을 위해 DB ResultSet을 구현한 객체   
		String[] bayport = null;
       
		try {

			bayport = dbDao.searchBayPort(conditionVO).getResultStrArray();
			eesCommonVO.setResultset(bayport);
			return  eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * CSR No - N200904200110 : VVD Add 추가기능으로 인한 메소드 추가
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 *  EventException
	 */
	public EesCommonVO searchLane(EesCommonConditionVO conditionVO) throws EventException {
		EesCommonVO eesCommonVO = new EesCommonVO();
		String check = null;
		String[] result = null;
       
		try {
			check = dbDao.searchCheckEqrScnrVsl(conditionVO).getResultString();
			if ( !check.equals("Y")){
				result =  dbDao.searchLane(conditionVO).getResultStrArray();
				if(result  != null){
					eesCommonVO.setCompany(result[0]);
					eesCommonVO.setSlaneCd(result[1]);
				}
			} else {
				eesCommonVO.setCompany("");
				eesCommonVO.setSlaneCd("Y");
			}
			return  eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * REPO_PLN_ID, PLN_YRWK 를 기준으로 대상 테이블의 Next PLN_SEQ 를 취득한다.
	 * 
	 * @param tableName
	 * @param repoPlnId
	 * @param plnYrwk
	 * @return CommonVO
	 *  EventException
	 */
	public CommonVO getNextPlnSeq(String tableName, String repoPlnId, String plnYrwk) throws EventException {
		try {
			return dbDao.getNextPlnSeq(tableName, repoPlnId, plnYrwk);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * user access 검색
	 * 특정 user가 059,080,081,083 에서 전주차 접근권한을 가진유저인지 확인
	 * 전주차 접근가능한 유저인지 확인 (TRUE - 전주차 접근가능, FALSE - 전주차 접근불가)
	 *         
	 * @param userid
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO checkFullAccessUser(String userid) throws EventException {
		CommonVO user_access = null;  

		try {				
			user_access = dbDao.checkFullAccessUser(userid);           
			return user_access;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}			
	
	/**
	 * USR_ID를 기준으로 COM_USER 테이블에서 USR_NM, OFC_CD를 취득한다.
	 * 
	 * @param usrId String
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO getUserInfo(String usrId) throws EventException {
		try {				
			return dbDao.getUserInfo(usrId);
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
}
