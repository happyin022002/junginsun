/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : OnhireDomesticNewvanScheduleInputBCImpl.java
*@FileTitle : 연간신조 및 L/T 계획 조회 / 수정
*Open Issues :
*Change history :
* No.	Ver.		Modifier           		modifier date    explanation
* 1      	1.0      	jungran yang		2006-09-20		1.0 최초 생성
* 2      	1.0      	Lee Byoung Hun	2009.07.29		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.07.29
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.07.29 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.ees.eqr.common.Constants;
import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.integration.OnhireDomesticNewvanScheduleInputDBDAO;
import com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.EesEqr0020ConditionVO;
import com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.EesEqr0021ConditionVO;
import com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.EesEqr0090ConditionVO;
import com.clt.apps.opus.ees.eqr.scenariomanage.onhiredomesticnewvanscheduleinput.vo.SearchYearSubleasePlanVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.EqrScnrDmstVO;
import com.clt.syscommon.common.table.EqrScnrNewVanLongTermVO;
import com.clt.syscommon.common.table.EqrScnrSlseVO;

/**
 * ALPS-OnhireDomesticNewvanScheduleInput Business Logic Basic Command implementation<br>
 * - ALPS-OnhireDomesticNewvanScheduleInput에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see EES_EQR_0020EventResponse,OnhireDomesticNewvanScheduleInputBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class OnhireDomesticNewvanScheduleInputBCImpl extends BasicCommandSupport implements OnhireDomesticNewvanScheduleInputBC {

	// Database Access Object
	private transient OnhireDomesticNewvanScheduleInputDBDAO dbDao = null;

	/**
	 * OnhireDomesticNewvanScheduleInputBCImpl 객체 생성<br>
	 * OnhireDomesticNewvanScheduleInputDBDAO를 생성한다.<br>
	 */
	public OnhireDomesticNewvanScheduleInputBCImpl() {
		dbDao = new OnhireDomesticNewvanScheduleInputDBDAO();
	}
	
	/**
	 * 연간신조 및 L/T 계획 조회 / 수정 조회 이벤트 처리 (하단 Sheet 조회)<br>
	 * 
	 * @param conditionVO EesEqr0020ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchYearNewvanPlan(EesEqr0020ConditionVO conditionVO) throws EventException {
		try {
			return dbDao.searchYearNewvanPlan(conditionVO);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 연간신조 및 L/T 계획 조회 / 수정 조회 이벤트 처리 (상단 Sheet 조회)<br>
	 * 
	 * @param conditionVO EesEqr0020ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchWeeklyNewvanPlan(EesEqr0020ConditionVO conditionVO) throws EventException {
		try {
			DBRowSet checkResultRs = dbDao.pikupVolSearchchk(conditionVO).getDbRowset();
			String pikupVolSearchchk = "FALSE";
			
			if (checkResultRs.next()) {
				if (checkResultRs.getInt("chk_count") > 0) {
					pikupVolSearchchk = "TRUE";
				}
			}
			
			return dbDao.searchWeeklyNewvanPlan(conditionVO, pikupVolSearchchk);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 연간신조 및 L/T 계획 조회 / 수정 조회 이벤트 처리 (코드 조회)<br>
	 * 
	 * @param searchword String
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO codeLocsearch(String searchword) throws EventException {
		try {
			return dbDao.codeLocsearch(searchword);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	/**
	 * 연간신조 및 L/T 계획 조회 / 수정 조회 이벤트 처리 (코드 조회)<br>
	 * 
	 * @param searchword String
	 * @param account SignOnUserAccount
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO codeEqrLocsearch(String searchword ,  SignOnUserAccount account) throws EventException {
		try {
			return dbDao.codeEqrLocsearch(searchword,account);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * 연간신조 및 L/T 계획 조회 / 수정 조회 이벤트 처리 (코드 조회)<br>
	 * 
	 * @param searchword String
	 * @param account SignOnUserAccount
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO codeEqrTruckLocsearch(String searchword ,  SignOnUserAccount account) throws EventException {
		try {
			return dbDao.codeEqrTruckLocsearch(searchword,account);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 연간신조 및 L/T 계획 조회 / 수정 멀티 이벤트 처리<br>
	 * 
	 * @param eqrScnrNewVanLongTermVOS EqrScnrNewVanLongTermVO[]
	 * @param scnrId String
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyYearNewvanPlan(EqrScnrNewVanLongTermVO[] eqrScnrNewVanLongTermVOS, String scnrId, SignOnUserAccount account) throws EventException {
		try {
			List<EqrScnrNewVanLongTermVO> updateVoList = new ArrayList<EqrScnrNewVanLongTermVO>();
			List<EqrScnrNewVanLongTermVO> deleteVoList = new ArrayList<EqrScnrNewVanLongTermVO>();
			
			for ( int i=0; i<eqrScnrNewVanLongTermVOS .length; i++ ) {
				if ( eqrScnrNewVanLongTermVOS[i].getIbflag().equals("U") || eqrScnrNewVanLongTermVOS[i].getIbflag().equals("I")){
					eqrScnrNewVanLongTermVOS[i].setScnrId(scnrId);
					eqrScnrNewVanLongTermVOS[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eqrScnrNewVanLongTermVOS[i]);
				} else if (eqrScnrNewVanLongTermVOS[i].getIbflag().equals("D")) {
					eqrScnrNewVanLongTermVOS[i].setScnrId(scnrId);
					deleteVoList.add(eqrScnrNewVanLongTermVOS[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyYearNewvanPlan(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.deleteYearNewvanPlan(deleteVoList);
			}

		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * US Domestic 물량 조회/수정 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0021ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchYearDomesticPlan(EesEqr0021ConditionVO conditionVO) throws EventException {
		try {
			CommonRsVO commonRsVO = new CommonRsVO();
			
			List resultVOList = dbDao.searchYearDomesticPlan(conditionVO);
			DBRowSet dbRowset = dbDao.searchYearDomesticDetailPlan(conditionVO).getDbRowset();
			
			commonRsVO.setResultVOList(resultVOList);
			commonRsVO.setDbRowset(dbRowset);
			
			return commonRsVO;
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * US Domestic 물량 조회/수정 Share 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0021ConditionVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public void searchDomesticPerformance(EesEqr0021ConditionVO conditionVO, SignOnUserAccount account) throws EventException {
		try {
			List<EqrScnrDmstVO> voList = new ArrayList<EqrScnrDmstVO>();
			EqrScnrDmstVO vo = null;
			
	        List month = conditionVO.getMonth();
	        List countWeek = conditionVO.getMonthWeekCnt();
	        List rsWeek = conditionVO.getWeek();
			
			int iWeek = 0;
			
        	/* rsCount 를 셋팅한다. */
        	for( int i = 0 ; i < month.size() ; i++ ) {
        		if(!((String)month.get(i)).equals("E")) {	
        			int monthQty  = Integer.parseInt((String)month.get(i));		// 월당 총수량
    				int monthWeek = Integer.parseInt((String)countWeek.get(i)); // 월당 주개수
    				
    				// 월당 총수량 / 월당 주개수
    				int countPerWeek = monthQty / monthWeek;
    	
    				// 마지막 주 개수 : 총 개수에서 총 주개수-1 의 총수량을 뺀 수량.
    				int countLastWeek = monthQty - countPerWeek * (monthWeek-1);
    				
    				for( int j = 0 ; j < (monthWeek - 1) ; j++ ) {
    					vo = new EqrScnrDmstVO();
    					vo.setScnrId(conditionVO.getScnrId());
    					vo.setPlnYrwk(String.valueOf(rsWeek.get(iWeek)));
    					vo.setRsCount(String.valueOf(countPerWeek));
    					vo.setUpdUsrId(account.getUsr_id());
    					voList.add(vo);
    					iWeek++;
    				}
					vo = new EqrScnrDmstVO();
					vo.setScnrId(conditionVO.getScnrId());
					vo.setPlnYrwk(String.valueOf(rsWeek.get(iWeek)));
					vo.setRsCount(String.valueOf(countLastWeek));
					vo.setUpdUsrId(account.getUsr_id());
					voList.add(vo);
					iWeek++;
        		}
        	}
        	
        	// 2. EQR_SCNR_DMST Table 삭제하고 EQR_DMST_PERF를 조회하여 월별 수량을 등록한다.
            dbDao.deleteDomesticPerformance(conditionVO);
            dbDao.insertDomesticPerformance(voList);
            dbDao.updateDomesticPerformance(voList);
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * US Domestic 물량 조회/수정 Save 이벤트 처리<br>
	 * 
	 * @param eqrScnrDmstVOS EqrScnrDmstVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void modifyYearDomesticPlan(EqrScnrDmstVO[] eqrScnrDmstVOS, SignOnUserAccount account) throws EventException {
		try {
			List<EqrScnrDmstVO> updateVoList = new ArrayList<EqrScnrDmstVO>();
			List<EqrScnrDmstVO> deleteVoList = new ArrayList<EqrScnrDmstVO>();
			
			for ( int i=0; i<eqrScnrDmstVOS .length; i++ ) {
				if ( eqrScnrDmstVOS[i].getIbflag().equals("U") || eqrScnrDmstVOS[i].getIbflag().equals("I")){
					eqrScnrDmstVOS[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(eqrScnrDmstVOS[i]);
				} else if (eqrScnrDmstVOS[i].getIbflag().equals("D")) {
					deleteVoList.add(eqrScnrDmstVOS[i]);
				}
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyYearDomesticPlan(updateVoList);
			}
			if ( deleteVoList.size() > 0 ) {
				dbDao.deleteYearDomesticPlan(deleteVoList);
			}

		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * 조회 이벤트 처리<br>
	 * OnhireDomesticNewvanScheduleInput화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO EesEqr0090ConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchYearSubleasePlan(EesEqr0090ConditionVO conditionVO) throws EventException {
		
        // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		List<SearchYearSubleasePlanVO> list  = null;
		CommonRsVO commonRsVO = null;
        
        try {
        	
        	list  = dbDao.searchYearSubleasePlan(conditionVO);
            
        	commonRsVO = dbDao.searchYearSubleaseDetailPlan(conditionVO);
        	
        	commonRsVO.setResultVOList(list);
            
            return commonRsVO;
        } catch (DAOException de) {
            log.error("err "+de.toString(),de);
            throw new EventException(de.getMessage());
        }
	}

	/**
	 * 수정 이벤트 처리<br>
	 * EES_EQR_090 에 대한 추가 이벤트 처리<br>
	 * 
	 * @param vos EqrScnrSlseVO[]
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public void modifyYearSubleasePlan(EqrScnrSlseVO[] vos , SignOnUserAccount account) throws EventException {
		boolean isInsert = false ;        
        boolean isDelete = false;   
		try {
			List insModels 	= new ArrayList();
			List delModels 	= new ArrayList();
			String user_id  = account.getUsr_id();
        	for(int i = 0 ; i < vos.length ; i++){
        		EqrScnrSlseVO vo = vos[i];
        		if(vo.getIbflag().equals("I") || vo.getIbflag().equals("U")){
					isInsert = true;
        			HashMap<String, String> param = new HashMap<String, String>();
        			param.putAll(vo.getColumnValues());
    	    		param.put("user_id", user_id);
    	    		insModels.add(param);
        		}else if(vo.getIbflag().equals("D")){
        			isDelete = true ;
        			HashMap<String, String> param = new HashMap<String, String>();
        			param.putAll(vo.getColumnValues());
        			delModels.add(param);
        		}
        	}
        	if(isInsert){
        		dbDao.insertYearSubleasePlan(insModels);
			}
			if(isDelete){
        		dbDao.deleteYearSubleasePlan(delModels);
			}
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
     * Share 이벤트 처리<br>
     * EES_EQR_090 화면에 대한 Share 이벤트 처리<br>
     * 
     * @param conditionVO EesEqr0090ConditionVO
	 * @param account SignOnUserAccount
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
	public void searchSubleasePerformance(EesEqr0090ConditionVO conditionVO , SignOnUserAccount account) throws EventException{
    	List<String> month = conditionVO.getMonth();
        List<String> countWeek = conditionVO.getMonthWeekCnt();
        
    	List<String> rsWeek = new ArrayList<String>();	// E를 제외한 주를 담을 리스트
    	List<Object> rsCount = new ArrayList<Object>();	// E를 제외한 해당주의 수량을 담을 리스트        
    	boolean isInsert = false ;
        boolean isUpdate = false;	        
        boolean isDelete = false;   
        String scnr_id = Constants.SCNR_WORD + conditionVO.getYyyyww() + Constants.SCNR_WEEK + conditionVO.getSeq();
		//String year    = conditionVO.getFmplnyr();
		String stYrWk = conditionVO.getFmplnyr() + conditionVO.getFmplnwk();
		String endYrWk = conditionVO.getToplnyr() + conditionVO.getToplnwk();
		
		String yrWk = "";
        try {
        	
        	List insModels 	= new ArrayList();
			List updModels 	= new ArrayList();
			List delModels 	= new ArrayList();
			String user_id  = account.getUsr_id();
			
	        
        	/* rsWeek 를 셋팅한다. */
        	rsWeek = conditionVO.getWeek();
        	
        	/* rsCount 를 셋팅한다. */
        	//log.debug("\n month.size() :::::::::::::: "+month.size());
        	for( int i = 0 ; i < month.size() ; i++ ) {
        		if(!((String)month.get(i)).equals("E")) {	
        			int monthQty  = Integer.parseInt((String)month.get(i));		// 월당 총수량
    				int monthWeek = Integer.parseInt((String)countWeek.get(i)); // 월당 주개수
    				
    	
    				// 월당 총수량 / 월당 주개수
    				int countPerWeek = monthQty / monthWeek;
    				
    				//log.debug("\n  monthQty : "+monthQty+" / monthWeek : "+monthWeek+" / countPerWeek="+countPerWeek);
    	
    				// 마지막 주 개수 : 총 개수에서 총 주개수-1 의 총수량을 뺀 수량.
    				int countLastWeek = monthQty - countPerWeek * (monthWeek-1);
    				
    				for( int j = 0 ; j < (monthWeek - 1) ; j++ ) {
    					rsCount.add(countPerWeek);
    				}
    				rsCount.add(countLastWeek);
        		}
        	}        	
    		
        	//log.debug("rsCount: " + rsCount);
        	//log.debug("rsWeek:  " + rsWeek);
        	
        	// 2. EQR_SCNR_DMST Table 삭제하고 EQR_DMST_PERF를 조회하여 월별 수량을 등록한다.
        	isDelete = true ;
	        HashMap<String, String> delparam = new HashMap<String, String>();
	        delparam.put("stYrWk", stYrWk);
	        delparam.put("endYrWk", endYrWk);
	        delparam.put("scnr_id", scnr_id);
	        delparam.put("rcc_cd", conditionVO.getRccCd());
	        delModels.add(delparam);
	        
        	for( int j = 0 ; j < rsWeek.size() ; j++ ) {
	        	yrWk = String.valueOf(rsWeek.get(j));
	    		isInsert = true;
	    		HashMap<String, Object> param = new HashMap<String, Object>();
	    		param.put("scnr_id", scnr_id);
	    		param.put("yrWk", yrWk);
	    		param.put("rsCount", String.valueOf(rsCount.get(j)));
	    		param.put("User_id", user_id);
	    		param.put("rcc_cd", conditionVO.getRccCd());
	    		insModels.add(param);
	        }
	        
	        for( int k = 0 ; k < rsWeek.size() ; k++ ) {
	        	
	        	yrWk = String.valueOf(rsWeek.get(k));
	    		isUpdate = true;
	    		HashMap<String, Object> param = new HashMap<String, Object>();
	    		param.put("rsCount", String.valueOf(rsCount.get(k)));
	    		param.put("yrWk", yrWk);
	    		param.put("scnr_id", scnr_id);
	    		param.put("rcc_cd", conditionVO.getRccCd());
	    		updModels.add(param); 		
	        }         

			if(isDelete){
				dbDao.deleteSubleasePerformance(delModels);
			}
	        if(isInsert){
	        	dbDao.insertSubleasePerformance(insModels);
			}
			if(isUpdate){
	        	dbDao.modifySubleasePerformance(updModels);
			}    	
            
        } catch (DAOException de) {
            log.error("err "+ de.toString(),de);
            throw new EventException(de.getMessage());
        }
    }        	
    
}