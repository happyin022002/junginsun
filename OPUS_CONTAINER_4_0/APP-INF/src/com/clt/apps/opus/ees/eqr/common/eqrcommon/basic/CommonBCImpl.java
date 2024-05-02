/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : eqrcommonBCImpl.java
*@FileTitle : retrieving for Max UPD_USR_ID , UPD_DT
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.common.eqrcommon.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.eqr.common.Constants;
import com.clt.apps.opus.ees.eqr.common.Utils;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.integration.CommonDBDAO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.CommonVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonConditionVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EesCommonVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EqrWkPrdVO;
import com.clt.apps.opus.ees.eqr.common.eqrcommon.vo.EqrCommonVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.EqrEqRepoPlnVO;

/**
 * eqrcommon Business Logic Basic Command implementation<br>
 * handling business logic about eqrcommon<br>
 *
 * @author 
 * @see eqrcommonEventResponse,eqrcommonBC, eqrcommonDBDAO
 * @since J2EE 1.6
 */
public class CommonBCImpl extends BasicCommandSupport implements CommonBC {

	// Database Access Object
	private transient CommonDBDAO dbDao = null;
	private String newHolidayTitle = "";
	/**
	 * creating eqrcommonBCImpl<br>
	 * creating eqrcommonDBDAO<br>
	 */
	public CommonBCImpl() {
		dbDao = new CommonDBDAO();
	}

	/**
	 * retiriving for ECC Information convertiong <br>
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
	 * retrieving for ECC Information converting<br>
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
	 * retrieving for yard code
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
	 * retrieving for Scnr_id Remark, SCNR_AUTO_GEN_FLG, REPO_PLN_CRE_FLG, REPO_PLN_DTRB_FLG
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 * 
	 */	
	public EesCommonVO scnridReMarkSearch (EesCommonConditionVO conditionVO) throws EventException {
        DBRowSet rowSet 		 = null; 	  
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
			result4 = dbDao.weewklyConvertMonth(conditionVO.getYyyyww() ,16).getResultStrArray();//max 16 weeks 
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
	 * retrieving for repo_plan_id Remark, SCNR_AUTO_GEN_FLG, REPO_PLN_CRE_FLG, REPO_PLN_DTRB_FLG
	 * 
	 * @param conditionVO EesCommonConditionVO 
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO repoidReMarkSearch (EesCommonConditionVO conditionVO) throws EventException {
		List<EqrEqRepoPlnVO> list 		 = null; 	  
        EesCommonVO eesCommonVO = new EesCommonVO();
        String[] result  = null;
        String[] result1 = null;
        String[] result2 = null;
        String   result3 = null;
        String[] result4 = null;
        String   result5 = null;
        String[] result6 = null;
        String   result7 = null;
        String   result8 = null;  // only in case of user client pc current week >= repoplan week, can be modified
        String[] result9 = null;
        String   result10= null;   // next week repo plan id 
        String   result11= null;   // only in case of user client pc current week <= repoplan week can be split
        
		String repo_id = Constants.REPO_WORD + conditionVO.getYyyyww() + Constants.REPO_WEEK + conditionVO.getSeq();
		try {				
			list = dbDao.repoidReMarkSearch(repo_id);
			result = dbDao.weewklyConvertMonth(conditionVO.getYyyyww() ,4).getResultStrArray();
			result1 = dbDao.titleMaxMonth(result).getResultStrArray();
			result2 = dbDao.titleMaxWeek(result).getResultStrArray();
			result3 = dbDao.monthCount(result).getResultString();
			result4 = dbDao.weewklyConvertMonth(conditionVO.getYyyyww() ,9).getResultStrArray();//max 9주 
			result5 = dbDao.fromToRepoPlnId(repo_id).getResultString();// 8 id
			result6 = dbDao.scnrIdList(repo_id).getResultStrArray();//SCNR_ID LIST
			result7 = dbDao.todayWeekly().getResultString();
			result8 = dbDao.exePlnEditFlg(conditionVO.getYyyyww(), conditionVO.getLocaldate()).getResultString();
			result9 = dbDao.weewklyMaxWkStr(conditionVO.getYyyyww() ,9).getResultStrArray();//max 9 week
			result10= dbDao.getNextPrevWeek(conditionVO.getYyyyww(), 1, "NEXT").getResultString();  // next repoPlnWeek
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
	 * retrieving forweeklyCondition <br>
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
	 * retrieving for CheckFlg  <br>
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
	 * retrieving for MAX UPD_USR_ID, UPD_DT <br>
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
	 * retrieving for Week  <br>
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
	 * checking ecc code <br>
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
	 * checking ecc code<br>
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
	 * checking LocCode <br>
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
	 * checking LocCodeWithMaster <br>
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
	 * modifying SCNR_RMK  <br>
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
	 * modifying REPO_RMK  <br>
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
	 * retrieving for min week of current year, max week of last year when current week is the first week of the year<br>
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
	 * retrieving for max week of current year, min week of last year when current week is the last week of the year <br>
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
	 * retrieving for min week = 01, max week = 53<br>
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
			    		//log.debug("\n >>>> in case of start week of the year = parameter"+wkInfo[0]+" / "+wkInfo[1]);
				    	wkArr[0] = wkInfo[1];
				    	wkArr[1] = stHolYr + stHolWk;//self
				    	
				    	if(stHolWk.equals(endHolWk)){//3 weeks
				    		wkArr[2] = endHolYr + Utils.fill((String.valueOf(Integer.parseInt(endHolWk) + 1)), 2, "0", "left");
				    		//log.debug("\n 3weeks =="+endHolWk+ " :"+wkArr[2]);
				    	}else{//4개주.
				    		//log.debug("\n 4weeks ==");
				    		wkArr[2] = endHolYr + endHolWk;
				    		wkArr[3] = endHolYr + Utils.fill((String.valueOf(Integer.parseInt(endHolWk) + 1)), 2, "0", "left");
				    	}
				    }else{
				    	//log.debug("\n >>>> in case of the week = 01, 00 week exist"+wkInfo[0]+" / "+wkInfo[1]);
				    	wkArr[0] = wkInfo[0];
				    	wkArr[1] = stHolYr + stHolWk;//self
				    	if(stHolWk.equals(endHolWk)){//3weeks
				    		wkArr[2] = endHolYr + Utils.fill((String.valueOf(Integer.parseInt(endHolWk) + 1)), 2, "0", "left");
				    	}else{//4개주.
				    		wkArr[2] = endHolYr + endHolWk;
				    		wkArr[3] = endHolYr + Utils.fill((String.valueOf(Integer.parseInt(endHolWk) + 1)), 2, "0", "left");
				    	}
				    }
			    }
			    
			    else if((stHolWk.equals("52") || stHolWk.equals("53"))){
			    	
			    	if(stHolWk.equals(wkInfo_0)){
			    		//log.debug("\n >>>> in case of start week of the year = parameter[52]"+wkInfo[0]+" / "+wkInfo[1]);
				    	wkArr[0] = stHolYr + Utils.fill((String.valueOf(Integer.parseInt(stHolWk) - 1)), 2, "0", "left");
				    	wkArr[1] = stHolYr + stHolWk;//self
			    	
				    	if(stHolWk.equals(endHolWk)){//3weeks
				    		wkArr[2] = wkInfo[1];
				    	}else{//4weeks
				    		wkArr[2] = endHolYr + endHolWk;
				    		//----
				    		if(endHolWk.equals(wkInfo_1)){
				    			wkArr[3] = endHolYr + Utils.fill((String.valueOf(Integer.parseInt(endHolWk) + 1)), 2, "0", "left");
				    		}else{
				    			wkArr[3] = wkInfo[1];
				    		}
				    		
				    	}
				    }else{
				    	//log.debug("\n >>>>in case of the week = 52, 53 week exist[52]"+wkInfo[0]+" / "+wkInfo[1]);
				    	wkArr[0] = stHolYr + Utils.fill((String.valueOf(Integer.parseInt(stHolWk) - 1)), 2, "0", "left");
				    	wkArr[1] = stHolYr + stHolWk;//self
				    	
				    	if(stHolWk.equals(endHolWk)){//3weeks
				    		wkArr[2] = wkInfo[0];
				    	}else{//4개주.
				    		wkArr[2] = endHolYr + endHolWk;
				    		wkArr[3] = wkInfo[1];
				    	}
				    }
			    }
			    else{//in general case
			    	wkArr[0] = stHolYr + Utils.fill((String.valueOf(Integer.parseInt(stHolWk) - 1)), 2, "0", "left");
			    	wkArr[1] = stHolYr + stHolWk;//self
			    	if(stHolWk.equals(endHolWk)){//3weeks
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
			    setNewHolidayTitle(newTitle);//wk200603|wk200604|wk200605|wk200606  
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
	 * getting New Holiday Title
	 * 
	 * @param 
	 * @return getNewHolidayTitle
	 * @exception 
	 */
	public String getNewHolidayTitle() {
		return newHolidayTitle;
	}

	/**
	 * setting New Holiday Title
	 * 
	 * @param newHolidayTitle
	 * @return 
	 * @exception 
	 */
	public void setNewHolidayTitle(String newHolidayTitle) {
		this.newHolidayTitle = newHolidayTitle;
	}

	/**
	 * retrieving for month info<br>
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
	 * retrieving for week info <br>
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
	 * counting weeks in the month <br>
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
	 * retrieving for LOC YARD Exist <br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
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
	 * retrieving for LOC YARD Company Exist <br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
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
	 * retrieving for LOC YARD <br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
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
	 * retrieving for ECC YARD <br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchEccYardInfo(EesCommonConditionVO conditionVO) throws EventException {		
		
        String[] result = null;
       
		try {
			result = dbDao.searchEccYardInfo(conditionVO.getLocyardSearchword()).getResultStrArray();
			EesCommonVO eesCommonVO = new EesCommonVO();
			
			eesCommonVO.setLocyardResult(result);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	
	/**
	 * retrieving for LOC YARD <br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchLocByYardInfo(EesCommonConditionVO conditionVO) throws EventException {		
		
        String[] result = null;
       
		try {
			result = dbDao.searchLocByYardInfo(conditionVO.getLocyardSearchword()).getResultStrArray();
			EesCommonVO eesCommonVO = new EesCommonVO();
			 
			eesCommonVO.setLocyardResult(result);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * retrieving for LOC YARD<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return eesCommonVO
	 * @exception EventException
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
	 * retrieving for LOC YARD(vessel)<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
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
	 * retrieving for LOC YARD INITIAL<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchLocYardInitialInfo(EesCommonConditionVO conditionVO) throws EventException {
        String[] result = null;
        String ecc    = conditionVO.getLocyardinitialEcc();  // FROM LOCATION, TO LOCATION
        String vsl    = conditionVO.getLocyardinitialVsl();  // VVD info. (in case of WATER mode, VVD doesn't exist)
        String item   = conditionVO.getLocyardinitialItem(); // transit mode (V, W)

    	String vslCd    = "";
    	String skdVoyNo = "";
    	String skdDirCd = "";    	        	    	
		
        String resultFlag = "";  // result format  1 : 1 yard, 2 :  2 or more vessel yard, 3 : mdm_yard 
		try {
			/* ITEM (V, W) + VSL 
			 * 1. Vessel OR Water(VVD exists) 
			 * - 1 STEP 
			 *     retrieving for YARD(VVD + LOCATION) in VSK_VSL_PORT_SKD
			 * - 2 STEP 
			 *     1STEP result = NULL : retrieving for MDM YARD(CODE, NAME)
			 * 
			 * 2. Water(VVD doesn't exist)
			 * - 1 STEP 
			 *     retrieving for YARD(FDR) in PRD_PORT_TML_MTX
			 * - 2 STEP 
			 *     1STEP result = NULL : retrieving MDM YARD(CODE, NAME)
			 */
			
			if(item.equals("W") && (vsl.equals("") || vsl==null)) { // Water(VVD doesn't exist)
				
				// 1 STEP : retrieving for YARD(FDR) in PRD_PORT_TML_MTX
				result = dbDao.searchLocYardInitialInfo(ecc).getResultStrArray();
				resultFlag = "1";
				
				// 1STEP result = NULL : retreiving for MDM VESSEL YARD(CODE|NAME, CODE)
				if((result[1]==null || result[1].equals("") )) {  
					result = dbDao.searchLocYardVesselInfo(ecc).getResultStrArray();		
					resultFlag = "3";
				}
							
			}else { // Vessel OR Water(VVD exists) 

				//1 STEP : retrieving for YARD(VVD + LOCATION) in VSK_VSL_PORT_SKD
				if(vsl.length() == 9) {
					vslCd    = vsl.substring(0,4);
		    		skdVoyNo = vsl.substring(4,8);
		    		skdDirCd = vsl.substring(8,9);    	        	    	
				}
				
				result = dbDao.searchLocVesselYardInitialInfo(ecc, vslCd, skdVoyNo, skdDirCd).getResultStrArray();
				
				if((result[0]==null || result[0].equals("")) && (result[1]==null || result[1].equals(""))) resultFlag = "3"; // 1STEP result = NULL 
				else if(result[1]==null || result[1].equals("")) resultFlag = "1"; // 1 vessel schedule yard retrieved
				else				  			                 resultFlag = "2"; // 2 or more vessel schedule yard retrieved
				
				//1STEP result = NULL : retrieving for MDM VESSEL YARD(CODE, NAME)
				if(resultFlag.equals("3")) {  			
					result = dbDao.searchLocYardVesselInfo(ecc).getResultStrArray();		
					resultFlag = "3";		
				}				
				
			}				
			
			EesCommonVO eesCommonVO = new EesCommonVO();

			eesCommonVO.setResultset7(resultFlag);	 // view one of resultFlag (1,2,3)
			eesCommonVO.setLocyardInitialResult(result);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}		
	
	
	/**
	 * retrieving for LOC YARD INITIAL<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchWaterLocYardInitialInfo(EesCommonConditionVO conditionVO) throws EventException {
        String[] result = null;
        String ecc    = conditionVO.getLocyardinitialEcc();  // FROM LOCATION, TO LOCATION
        String vsl    = conditionVO.getLocyardinitialVsl();  // VVD info. (in case of WATER mode, VVD doesn't exist)

    	String vslCd    = "";
    	String skdVoyNo = ""; 
    	String skdDirCd = "";    	        	    	
		
        String resultFlag = "";  // result format  1 : 1 yard, 2 :  2 or more vessel yard, 3 : mdm_yard 
		try {
			if(vsl.length() == 9) {
				vslCd    = vsl.substring(0,4);
	    		skdVoyNo = vsl.substring(4,8);
	    		skdDirCd = vsl.substring(8,9);    	        	    	
			}
			
			EesCommonVO eesCommonVO = new EesCommonVO();
			
			if("t2_fm_yd_cd".equals(conditionVO.getLocyardinitialColname())) {
				result = dbDao.searchWaterLocVesselYardInitialInfo(ecc, vslCd, skdVoyNo, skdDirCd).getResultStrArray();
				resultFlag = "2";
				if((result[0]==null || result[0].equals("") )) {  	
					result = dbDao.searchLocYardVesselInfo(ecc).getResultStrArray();	
				}else{
					if(result[1].indexOf(ecc) < 0) {
						result = dbDao.searchLocYardVesselInfo(ecc).getResultStrArray();	
					}
				}
			}else{
				String from_ecc = conditionVO.getLocyardColname1();
				String to_ecc   = conditionVO.getLocyardinitialEcc();
				result = dbDao.searchWaterLocVesselYardDischargelInfo(from_ecc, to_ecc, vslCd, skdVoyNo, skdDirCd).getResultStrArray();
				resultFlag = "2"; // 2 or more vessel schedule yard retrieved
				
				if((result[0]==null || result[0].equals("") )) {  
					result = dbDao.searchLocYardVesselInfo(ecc).getResultStrArray();	
				}else{
					if(result[1].indexOf(ecc) < 0) {
						result = dbDao.searchLocYardVesselInfo(ecc).getResultStrArray();	
					}
				}
			}
			
			eesCommonVO.setResultset7(resultFlag);	 // view one of resultFlag (1,2,3)
			eesCommonVO.setLocyardInitialResult(result);
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}		
	
	
	/**
	 * retrieving for LOC YARD INITIAL<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchLocYardDischargeInfo(EesCommonConditionVO conditionVO) throws EventException {
        String[] result = null;
        String ecc    = conditionVO.getLocyardinitialEcc();  // FROM LOCATION, TO LOCATION
        String vsl    = conditionVO.getLocyardinitialVsl();  // VVD info. (in case of WATER mode, VVD doesn't exist)
        String item   = conditionVO.getLocyardinitialItem(); // transit mode (V, W)

    	String vslCd    = "";
    	String skdVoyNo = "";
    	String skdDirCd = "";    	        	    	
		
        String resultFlag = "";  // result format  1 : 1 yard, 2 :  2 or more vessel yard, 3 : mdm_yard 
		try {
			/* ITEM (V, W) + VSL 
			 * 1. Vessel OR Water(VVD exists) 
			 * - 1 STEP 
			 *     retrieving for YARD(VVD + LOCATION) in VSK_VSL_PORT_SKD
			 * - 2 STEP 
			 *     1STEP result = NULL : retrieving for MDM YARD(CODE, NAME)
			 * 
			 * 2. Water(VVD doesn't exist)
			 * - 1 STEP 
			 *     retrieving for YARD(FDR) in PRD_PORT_TML_MTX
			 * - 2 STEP 
			 *     1STEP result = NULL : retrieving MDM YARD(CODE, NAME)
			 */
			
			if(item.equals("W") && (vsl.equals("") || vsl==null)) { // Water(VVD doesn't exist)

				// 1 STEP : retrieving for YARD(FDR) in PRD_PORT_TML_MTX
				result = dbDao.searchLocYardInitialInfo(ecc).getResultStrArray();
				resultFlag = "1";
				
				// 1STEP result = NULL : retreiving for MDM VESSEL YARD(CODE|NAME, CODE)
				if((result[1]==null || result[1].equals("") )) {  
					result = dbDao.searchLocYardVesselInfo(ecc).getResultStrArray();		
					resultFlag = "3";
				}
							
			}else { // Vessel OR Water(VVD exists) 

				//1 STEP : retrieving for YARD(VVD + LOCATION) in VSK_VSL_PORT_SKD
				if(vsl.length() == 9) {
					vslCd    = vsl.substring(0,4);
		    		skdVoyNo = vsl.substring(4,8);
		    		skdDirCd = vsl.substring(8,9);    	        	    	
				}
				
				result = dbDao.searchLocVesselYardDischargelInfo(ecc, vslCd, skdVoyNo, skdDirCd).getResultStrArray();
				
				if((result[0]==null || result[0].equals("")) && (result[1]==null || result[1].equals(""))) resultFlag = "3"; // 1STEP result = NULL 
				else if(result[1]==null || result[1].equals("")) resultFlag = "1"; // 1 vessel schedule yard retrieved
				else				  			                 resultFlag = "2"; // 2 or more vessel schedule yard retrieved
				
				//1STEP result = NULL : retrieving for MDM VESSEL YARD(CODE, NAME)
				if(resultFlag.equals("3")) {  			
					result = dbDao.searchLocYardVesselInfo(ecc).getResultStrArray();		
					resultFlag = "3";		
				}				
				
			}				
			
			EesCommonVO eesCommonVO = new EesCommonVO();

			eesCommonVO.setResultset7(resultFlag);	 // view one of resultFlag (1,2,3)
			eesCommonVO.setLocyardInitialResult(result);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}		
	
	
	/**
	 * retrieving for lessor YARD<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchLseCoYardInfo(EesCommonConditionVO conditionVO) throws EventException {	
        String[] result = null;
       
		try {
			
			//ON-HIRE : retrieving for lessor when retrieve FROM LOC(TO LOC in searchLocYardInfo)
			//OFF-HIRE : retrieving for lessor when retrieve TO LOC(FROM LOC in searchLocYardInfo)
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
	 * retrieving for LOC YARD-ECC<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
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
	 * retrieving for LOC YARD-ECC<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @param account SignOnUserAccount
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchEqrLocYardEccInfo(EesCommonConditionVO conditionVO, SignOnUserAccount account) throws EventException {		
		String[] result = null;
      
		try {
			result = dbDao.searchEqrLocYardEccInfo(conditionVO.getLocyardSearchword(), conditionVO.getLocyardEcc(), conditionVO.getLocCd(), account).getResultStrArray();
			EesCommonVO eesCommonVO = new EesCommonVO();
			
			eesCommonVO.setLocyardeccResult(result);
			
			return eesCommonVO;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	
	
	/**
	 * To Yard <br>
	 * @param conditionVO EesCommonConditionVO
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String searchEqrLocYardLccInfo(EesCommonConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try{
			return dbDao.searchYardInfo(conditionVO.getLocFmyardSearchword(),conditionVO.getLocToyardSearchword(), account);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
    }		
	
	
	/**
	 * retrieving for VENDOR<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
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
	 * retrieving for VENDOR<br>
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
	 * retrieving for VVD<br>
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
	 * retrieving for vvd combo box
	 * in Fixed Plan of Execute Plan Inland, click Row Add, retrieving for To LOC(ECC), ETA Week
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
	 * retrieving for VVD<br>
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
	 * retrieving for Scnr_id on the week<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
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
	 * retrieving for Country<br>
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
	 * retrieving for Period Valid Check<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchCheckPeriod(EesCommonConditionVO conditionVO) throws EventException {	
		//DBRowSet rowSet 		 = null; 	   
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
	 * retrieving for Period Valid Check(FM, To)<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchCheckPeriodOpt(EesCommonConditionVO conditionVO) throws EventException {		
		//DBRowSet rowSet 		 = null; 	   
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
	 * retrieving for start Day on the week<br>
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
	 */
	public CommonVO searchWeekEndDate(String yyyyww ,String strDs) throws EventException {
		CommonVO stdt ;        
			
		try {
			dbDao = new  CommonDBDAO(strDs);
			stdt = dbDao.searchWeekEndDate(yyyyww);
            
			return stdt;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * retrieving for start+gapmonth on the week <br>
	 * 
	 * @param yyyyww	String
	 * @param gapmonth	String
	 * @param strDs		String
	 * @return CommonVO getResultString()
	 * @exception EventException
	 * CSR NO :R200904090006
	 */
	public CommonVO searchWeekStartDate(String yyyyww, String gapmonth ,String strDs) throws EventException {
		CommonVO stdt ;        
			
		try {	
//			log.info("error ====>" + strDs);
			dbDao = new  CommonDBDAO(strDs);
			stdt = dbDao.searchWeekStartDate(yyyyww, gapmonth);
            
			return stdt;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	/**
	 * retrieving for dates with year week<br>
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
	 * retrieving for REPO_PLAN with REPO_ID<br>
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
	 * creating scenario ID <br>
	 * 
	 * @param scnario_id String	: (last scenario ID)
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
	 * creating REPO_PLAN_ID <br>
	 * 
	 * @param repoPlanid String : ( last REPO_PLAN_ID)
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO createNewRepoPlanId(String repoPlanId) throws EventException {
		CommonVO resultVO = new CommonVO();
		boolean resultBoolean = false;
		String resultRepoPlanId = null;
		
		try {	
			// checking REPO PLAN ID duplicate
			// REPO PLAN ID  doesn't exist = true, does = false
			resultBoolean = dbDao.checkRepoPlanIdRow(repoPlanId).isResultBoolean();
			
			// REPO PLAN ID  doesn't exist , SEQ = 999
			if (resultBoolean) {
				resultRepoPlanId = repoPlanId.substring(0, 11) + "999";
				resultVO.setResultString(resultRepoPlanId);
				
			// REPO PLAN ID exists
			} else {
				resultVO = dbDao.createNewRepoPlanId(repoPlanId); // SSEQ + 1
			}
			
			return resultVO;
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * converting wee to month<br>
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
	 * retrieving for Week Date Period <br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
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
	 * retrieving for search eta date<br>
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
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
	 * retrieving for search eta date<br>
	 * 
	 * @param etd
	 * @param fryard
	 * @param toyard
	 * @param item
	 * 
	 * @return CommonVO getResultString()
	 * @exception EventException
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
	 * retrieving for next week
	 * ex) nextNum = 1 --> next week
	 *     nextNum = 2 --> 2 weeks later
	 * ex) direction --> NEXT : next week
	 *     direction --> PREV : previous week
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
	 * retrieving for location code 
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
	 * retrieving for current week
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
	 * Search repo plan id (default : next week)
	 * if not exist repo plan id then create repo plan id
	 * 
	 * @return CommonVO getResultStrArray()
	 * @throws Exception 
	 */
	public CommonVO searchMaxRepoPlanId() throws Exception {
		CommonVO maxRepoPlanId = null;  

		try {				
			maxRepoPlanId = dbDao.searchMaxRepoPlanId();  
			/*	System 자동 생성 제거 -  2014.10.22		
			if(maxRepoPlanId.getResultStrArray()[0].equals("")) { // when next week repo plan id not exist
				dbDao.makeNextWeekRepoPlanId();
				maxRepoPlanId = dbDao.searchMaxRepoPlanId();  
			}
			 */			
			return maxRepoPlanId;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}			

	/**
	 * retrieving for ECC Information convertiong <br>
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
	 * retrieving for ECC Information convertiong <br>
	 * 
	 * @return CommonVO getResultString()
	 * @exception EventException
	 */
	public CommonVO getTpszDefault() throws EventException {
		CommonVO tpszDefault;
			
		try {				
			tpszDefault = dbDao.getTpszDefault();
            
			return tpszDefault;
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}	
	
	
	/**
	 * retrieving for Country code of Yard Code<br>
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
	 * converting day to week
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
	 * checking VVD duplicate
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
	
	/** 
	 * retrieving for Period Valid Check<br>
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO searchBeforeCheckPeriod(EesCommonConditionVO conditionVO) throws EventException {		
		EesCommonVO eesCommonVO = new EesCommonVO();
		DBRowSet rowSet 		 = new DBRowSet(); 	   
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
	
	
	/** 
	 * retrieving for vessel <br>
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 * @exception EventException
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
	 * closing EQR scenario<br>
	 * clearing related objects ScenarioDefaultManage<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
	
	/**
	 * retrieving for BayPort List of the VVD
	 * 
	 * @param conditionVO EesCommonConditionVO
	 * @return EesCommonVO
	 *  EventException
	 */
	public EesCommonVO searchBayPort(EesCommonConditionVO conditionVO) throws EventException {
		EesCommonVO eesCommonVO = new EesCommonVO();
		//DBRowSet rowSet 		 = null; 	   
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
	 * retrieving for Lane
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
	 * retrieving for  Next PLN_SEQ with REPO_PLN_ID, PLN_YRWK
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
	 * checking user access 
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
	 * ritrieving for USR_NM, OFC_CD with USR_ID
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
	
	/**
	 * retrieving for EQR Week with the year
	 * 
	 * @param plnYr String
	 * @return List<EqrWkPrdVO>
	 * @exception EventException
	 */
	public List<EqrWkPrdVO> searchEqrWkPrd(String plnYr) throws EventException{
		try {
			return dbDao.searchEqrWkPrd(plnYr);
		} catch(DAOException ex) {
			//ex.printStackTrace();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			//ex.printStackTrace();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Managing EQR Week
	 * 
	 * @param EqrWkPrdVO[] eqrWkPrdVOs
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void manageEqrWkPrd(EqrWkPrdVO[] eqrWkPrdVOs, SignOnUserAccount account) throws EventException{
		List<EqrWkPrdVO> createList=new ArrayList<EqrWkPrdVO>();
		List<EqrWkPrdVO> modifyList=new ArrayList<EqrWkPrdVO>();
		List<EqrWkPrdVO> removeList=new ArrayList<EqrWkPrdVO>();
		
		try {
			if(eqrWkPrdVOs != null && eqrWkPrdVOs.length>0){
				for(int i=0;i<eqrWkPrdVOs.length;i++){ 
					EqrWkPrdVO eqrWkPrdVO = eqrWkPrdVOs[i];
					
					eqrWkPrdVO.setCreUsrId(account.getUsr_id());
					eqrWkPrdVO.setUpdUsrId(account.getUsr_id());
					
					if(eqrWkPrdVO.getIbflag().equals("D") || (eqrWkPrdVO.getDelChk()!=null && eqrWkPrdVO.getDelChk().equals("1"))){
						removeList.add(eqrWkPrdVO);
					}else if(eqrWkPrdVO.getIbflag().equals("U")){
						modifyList.add(eqrWkPrdVO);
					}else if(eqrWkPrdVO.getIbflag().equals("I")){
						createList.add(eqrWkPrdVO);
					}
				}
				
				if(createList!=null && !createList.isEmpty()){
					dbDao.searchDuplicateCheckEqrWkPrd(createList);
					dbDao.addEqrWkPrd(createList);
				}
				
				if(modifyList!=null && !modifyList.isEmpty()){
					dbDao.modifyEqrWkPrd(modifyList);
				}
				
				if(removeList!=null && !removeList.isEmpty()){
					dbDao.removeEqrWkPrd(removeList);
				}
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	/**
	 *  search  Trade List.
	 * 
	 * @return List<EqrCommonVO>
	 * @exception EventException
	 */	
	public List<EqrCommonVO> searchTradeList() throws EventException {
		try {
			return dbDao.searchTradeList();
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
     * 
     * @param modual 명
     * @param tag 명
     * @param valueField value 필드명
     * @param textField text 필드명
     * @param sSelectedCode명
     * @param mainCode 
     * @param orderByField 정렬 필드명
     * @param options select 옵션
     * @param addOption 추가 옵션
     * @return selectTag 
     */
    public String getTpSzCodeCombo(String modual, String tagName, String sSelectedCode, String mainCode, String orderByField, String delOptions, String addOption) throws EventException{
    	
        StringBuffer selectText  = new StringBuffer() ;
        StringBuffer selectValue  = new StringBuffer() ;
        StringBuffer selectTag  = new StringBuffer() ;   
        
        DBRowSet     rowSet     = new DBRowSet() ; 
        try{
        	if ( "eqr".equals(modual)){
        		rowSet = dbDao.getTpSzCodeCombo(mainCode, orderByField,delOptions) ;
        	}else {
        		//rowSet = dbDaoAlps.getCodeCombo(table, valueField, textField, whereField, orderByField) ;
        	}
        	
//        	System.out.println(">>>>>"+rowSet.getRowCount());
        	if(rowSet.getRowCount() != 0) {
	            for(int i=0; rowSet!=null && rowSet.next(); i++){
	            	//setAddOtptions(selectTag, addOptions, i) ;
	            	
	            	if(i == 0) {
	            		selectValue.append("var ").append(tagName).append("Code").append(" = \"");
	            		selectText.append("var ").append(tagName).append("Text").append(" = \"");
	            	}else{
	            		selectValue.append("|");
	            		selectText.append("|");
	            	}
	            	
	            	if ("".equals(rowSet.getString(1)))
	            		selectText.append(" ");
	                else {
	                	selectText.append(rowSet.getString(1));
	                }
	            	
	            	if ("".equals(rowSet.getString(1)))
	            		selectValue.append(" ");
	                else {
	                	selectValue.append(rowSet.getString(1));
	                }
	                  
	                //selectTag.append("   <option ");
	                //selectTag.append(sSelectedCode.equals(rowSet.getString(1)) ? " selected " : " ");
	                //selectTag.append("value=\"" + rowSet.getString(1) +"\">\n") ;
	                //selectTag.append(rowSet.getString(1) + "</option>\n") ;
	            }
        	}else{
        		selectValue.append("var ").append(tagName).append("Code").append(" = \"");
        		selectText.append("var ").append(tagName).append("Text").append(" = \"");
        	}
            //selectTag.append("</select>") ;
            
            if (selectText.length() > 0) {
            	selectText.append("\";");
            	selectValue.append("\";");
            }
           
            selectTag = selectValue.append("\n").append(selectText);
        } catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}

        return selectTag.toString() ;
    }
    
   // 소스품질 : 사용하지 않는 private 메소드 점검 -> setAddOtptions 주석처리
   // 2015.12.21 Updated by Jiyeon Jeon(2015517)
    /**
	 * 
	 * @param selectTag Select Tag
	 * @param addOptions 추가할 Option
	 * @param idx DB에서 가져온 options값의 sort index
	 */
//	private void setAddOtptions(StringBuffer selectTag, String[] addOptions, int idx){
//		String[] options = null ;
//		
//		if(addOptions!=null){
//			for(int j=0; j<addOptions.length; j++){
//				if(addOptions[j]!=null){
//					options = addOptions[j].split(":") ;
//					
//					if(options!=null && Long.parseLong(options[0])<=idx){
//						selectTag.append("    <option value=\"" + options[1] +"\">") ;
//						selectTag.append(options[2]) ;
//						selectTag.append("</option>\n") ;
//						addOptions[j] = null ;
//					}
//				}
//			}
//		}
//		
//	}
    
    /**
	 * Default Data Setting
	 * 
	 * @param conditionVO EesCommonConditionVO 
	 * @return EesCommonVO
	 * @exception EventException
	 */
	public EesCommonVO repoidDefaultSearch (EesCommonConditionVO conditionVO) throws EventException {
		List<EqrEqRepoPlnVO> list 		 = null; 	  
        EesCommonVO eesCommonVO = new EesCommonVO();
        String[] result  = null;
        String[] result1 = null;
        String[] result2 = null;
        String   result3 = null;
        String[] result4 = null;
        String   result5 = null;
        String[] result6 = null;
        String   result7 = null;
        String   result8 = null;  // only in case of user client pc current week >= repoplan week, can be modified
        String[] result9 = null;
        String   result10= null;   // next week repo plan id 
        String   result11= null;   // only in case of user client pc current week <= repoplan week can be split
        
		String repo_id = Constants.REPO_WORD + conditionVO.getYyyyww() + Constants.REPO_WEEK + conditionVO.getSeq();
		try {				
			list = dbDao.repoidReMarkSearch(repo_id);
			result = dbDao.weewklyConvertMonth(conditionVO.getYyyyww() ,4).getResultStrArray();
			result1 = dbDao.titleMaxMonth(result).getResultStrArray();
			result2 = dbDao.titleMaxWeek(result).getResultStrArray();
			result3 = dbDao.monthCount(result).getResultString();
			result4 = dbDao.weewklyConvertMonth(conditionVO.getYyyyww() ,9).getResultStrArray();//max 9주 
			result5 = dbDao.fromToRepoPlnId(repo_id).getResultString();// 8 id
			result6 = dbDao.scnrIdList(repo_id).getResultStrArray();//SCNR_ID LIST
			result7 = dbDao.todayWeekly().getResultString();
			result8 = dbDao.exePlnEditFlg(conditionVO.getYyyyww(), conditionVO.getLocaldate()).getResultString();
			result9 = dbDao.weewklyMaxWkStr(conditionVO.getYyyyww() ,9).getResultStrArray();//max 9 week
			result10= dbDao.getNextPrevWeek(conditionVO.getYyyyww(), 1, "NEXT").getResultString();  // next repoPlnWeek
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
	 * 
	 * @return
	 * @throws EventException
	 */
	public List<EqrCommonVO> searchEqrSubContinentList() throws EventException {
		try {
			return dbDao.searchEqrSubContinentList(); 
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * To Yard <br>
	 * @param conditionVO EesCommonConditionVO
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String searchEqrLocTrwYardLccInfo(EesCommonConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try{
			return dbDao.searchYardTrwInfo(conditionVO.getLocFmyardSearchword(),conditionVO.getLocToyardSearchword(), account);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
    }	
	
	
	/**
	 * 
	 * @param conditionVO
	 * @return
	 * @throws EventException
	 */
	public EesCommonVO repoidDefaultRepoPlanIdSearch (EesCommonConditionVO conditionVO) throws EventException {
		List<EqrEqRepoPlnVO> list 		 = null; 	  
        EesCommonVO eesCommonVO = new EesCommonVO();
        String[] result  = null;
        String[] result1 = null;
        String[] result2 = null;
        String   result3 = null;
        String[] result4 = null;
        String   result5 = null;
        String[] result6 = null;
        String   result7 = null;
        String   result8 = null;  // only in case of user client pc current week >= repoplan week, can be modified
        String[] result9 = null;
        String   result10= null;   // next week repo plan id 
        String   result11= null;   // only in case of user client pc current week <= repoplan week can be split
        
		String repo_id = conditionVO.getYyyyww() + "_" + conditionVO.getExectype() + "_" + conditionVO.getFmContiCd() + "_" + conditionVO.getToContiCd() + "_" + conditionVO.getSeq();
		try {				
			list = dbDao.repoidReMarkSearch(repo_id);
			result = dbDao.weewklyConvertMonth(conditionVO.getYyyyww() ,4).getResultStrArray();
			result1 = dbDao.titleMaxMonth(result).getResultStrArray();
			result2 = dbDao.titleMaxWeek(result).getResultStrArray();
			result3 = dbDao.monthCount(result).getResultString();
			result4 = dbDao.weewklyConvertMonth(conditionVO.getYyyyww() ,9).getResultStrArray();//max 9주 
			result5 = dbDao.fromToRepoPlnId(repo_id).getResultString();// 8 id
			result6 = dbDao.scnrIdList(repo_id).getResultStrArray();//SCNR_ID LIST
			result7 = dbDao.todayWeekly().getResultString();
			result8 = dbDao.exePlnEditFlg(conditionVO.getYyyyww(), conditionVO.getLocaldate()).getResultString();
			result9 = dbDao.weewklyMaxWkStr(conditionVO.getYyyyww() ,9).getResultStrArray();//max 9 week
			result10= dbDao.getNextPrevWeek(conditionVO.getYyyyww(), 1, "NEXT").getResultString();  // next repoPlnWeek
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
	
}
