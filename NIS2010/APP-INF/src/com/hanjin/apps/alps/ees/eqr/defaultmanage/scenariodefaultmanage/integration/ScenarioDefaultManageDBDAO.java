/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAO.java
*@FileTitle : ScenarioDefaultManage 
*Open Issues :
* No.   Ver.    Modifier         modifier date    explanation
* 1      1.0    jungran yang     2006-09-05       1.0 최초 생성
* 2      1.108  Jeonghwa Kwon    2008-02-25       CSR No : N200801250015 - Direction 방식이 FM -> TO pair 개념으로 변경
* 3      1.109  chae chang ho    2008-03-24       CSR No : N200802260006 - Lane/POD별 Discharging Bound 관리 기능 개발 건
* 4      1.110  Jeonghwa Kwon    2008-03-26       CSR No : N200803040009 - Constraint 화면 HJS Rule 관련 Fm/To/Mode에 'All' 조건 추가
* 5      1.111  chae chang ho    2008-05-16       project_name : 신규 장비(F5-40ft H/C Flat rack) 발주에 따른 NIS 상에 F5 등록
* 6      1.115  chae chang ho    2008-10-22       CSR No : N200810210009 - ECC 관련 Table자동 Delete 시 화면 로직 변경 요청
* 7      1.118  Haeng-ji, Lee    2009-04-03       CSR No : R200903240002 - Cntr Tpsz 자동화
* 8      1.119  Haeng-ji, Lee    2009-05-18       CSR No : R200905150001 - - Sheet에서 S/L변경했을 때의 에러사항 수정 - 쿼리 수정 
* 9      1.0    Lee Byoung Hun	 2009.06.30		  New Framework 적용 Renewal

*@LastModifyDate : 2009.06.30
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.06.30 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event.EesEqr0116Event;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event.EesEqr0121Event;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0042ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0043ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0116ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0117ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0121ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0122ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0123ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0137ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.ScenarioDefaultManageRsVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchAutoRunParameterVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchEccMasterVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchEccTsTmlVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchEqrHolidayEffectVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchSafetyStockVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchYearSubleaseDetailPlanMonthlyVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchYearSubleaseDetailPlanWeeklyVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchYearSubleasePlanVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.EqrAutoRunFcastParaVO;
import com.hanjin.syscommon.common.table.EqrDmstPlnVO;
import com.hanjin.syscommon.common.table.EqrEccLnkVO;
import com.hanjin.syscommon.common.table.EqrEccMstVO;
import com.hanjin.syscommon.common.table.EqrEccSftStkVO;
import com.hanjin.syscommon.common.table.EqrEccTurnTmVO;
import com.hanjin.syscommon.common.table.EqrLongTermOffhCondVO;
import com.hanjin.syscommon.common.table.EqrPortDchgCnstVO;
import com.hanjin.syscommon.common.table.EqrRepoCnstVO;
import com.hanjin.syscommon.common.table.EqrShrtTermOffhCondVO;
import com.hanjin.syscommon.common.table.EqrShrtTermOnhCondVO;
import com.hanjin.syscommon.common.table.EqrSubleaseVO;
import com.hanjin.syscommon.common.table.EqrTsTmlVO;
import com.hanjin.syscommon.common.table.EqrWkPrdVO;



/**
 * NIS2010 ScenarioDefaultManageDBDAO <br>
 * - NIS2010-DefaultManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Chae Change Ho
 * @see scenariodefaultmanageBCImpl 참조
 * @since J2EE 1.6
 */
public class ScenarioDefaultManageDBDAO extends DBDAOSupport {

	/**
	 * ScenarioDefaultManage의 데이타 모델에 해당되는 값을 불러온다.
	 * 
	 * EES_EQR_042 : Grid1
	 * @param EesEqr0042ConditionVO condiVo
	 * @return List<SearchEqrHolidayEffectVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchEqrHolidayEffectVO> searchDefaultHolidayEffectInfo(EesEqr0042ConditionVO condiVo) throws DAOException {
		
        DBRowSet dRs = null;
        List<SearchEqrHolidayEffectVO> list = null;        
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        if(!condiVo.getCountry().equals("")){
        	param.put("country",condiVo.getCountry());
        	velParam.put("country",condiVo.getCountry());
        }
        param.put("stpln",condiVo.getStPlnYr()+condiVo.getStPlnWk());
        param.put("endpln",condiVo.getEndPlnYr()+condiVo.getEndPlnWk());


        if(!condiVo.getHolidays().equals("")){
        	param.put("holidays",condiVo.getHolidays());
        	velParam.put("holidays",condiVo.getHolidays());
        }       	
        
        try {
        	dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchEqrHolidayEffectRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dRs, SearchEqrHolidayEffectVO .class);
            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        return list;
	}
	
	/**
	 * EES_EQR_042 EQR_HOL_PERF 에 data 존재 여부 체크.
	 * 
	 * @param condiVo EesEqr0042ConditionVO
	 * @param gubun String
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean searchDefaultHolidayEffectDetailIsExist(EesEqr0042ConditionVO condiVo, String gubun) throws DAOException {
		
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("gubun", gubun);
		param.put("rcc_div_flg", condiVo.getRcc_div_flg());
		param.put("cntcd", condiVo.getCntCd());
		param.put("holyr", condiVo.getStHolYr());
		param.put("stdt", condiVo.getStDt());
		DBRowSet dRs = null;
		
		try {
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchEqrHolidayEffectExistRSQL(), param, null);
			if (dRs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}	
	
    /**
	 * ScenarioDefaultManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * EES_EQR_042
	 * Grid 2 번째 select
     * @param condiVo  EesEqr0042ConditionVO
	 * @param gubun String : I / O
	 * @return ScenarioDefaultManageRsVO
	 * @exception DAOException
	 */	
    public ScenarioDefaultManageRsVO searchDefaultHolidayEffectDetailInfo(EesEqr0042ConditionVO condiVo, String gubun) throws DAOException {
    	ScenarioDefaultManageRsVO retVO = new ScenarioDefaultManageRsVO();	
        DBRowSet dRs = null;
        
        
        String[] wkArr = condiVo.getWkInfo(); 
        //query parameter 
        Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		
		velParam.put("wkarr",wkArr);
		
		param.put("gubun", gubun);
		param.put("rcc_div_flg", condiVo.getRcc_div_flg());
		param.put("cntcd", condiVo.getCntCd());
		param.put("stdt", condiVo.getStDt());
        
    
        try {
        	dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchEqrHolidayEffectDetailRSQL(), param, velParam);
        	retVO.setDBRowSet(dRs);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        return retVO;
   	}

    /**
     * ScenarioDefaultManage의 데이타 모델에 해당되는 값을 불러온다.<br>
     * EES_EQR_042
     * Grid 2 번째 select
     * @param condiVo  EesEqr0042ConditionVO
     * @param gubun String : I / O
     * @return ScenarioDefaultManageRsVO
     * @exception DAOException
     */	
    public ScenarioDefaultManageRsVO searchDefaultHolidayEffectDetailInfoRTO(EesEqr0042ConditionVO condiVo, String gubun) throws DAOException {
    	ScenarioDefaultManageRsVO retVO = new ScenarioDefaultManageRsVO();
        DBRowSet dRs = null;
        
        String[] wkArr = condiVo.getWkInfo(); 
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		// velocity parameter 셋팅
		velParam.put("wkarr",wkArr);
		
		// 조건 parameter 셋팅
		param.put("gubun", gubun);
		param.put("rcc_div_flg", condiVo.getRcc_div_flg());
		param.put("cntcd", condiVo.getCntCd());
		param.put("stdt", condiVo.getStDt());
		param.put("stholyr", condiVo.getStHolYr());
        
        try {
        	dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchEqrHolidayEffectDetailRTORSQL(), param, velParam);
        	retVO.setDBRowSet(dRs);
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(), de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        return retVO;
    }
	
	/**
	 * EesEqr042Event ScenarioDefaultManage의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * 
	 * @param List insModels
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void multiDefaultHolidayEffectInfo(List insModels) throws DAOException {
           
        int insCnt[] = null;
        
        try {
        	SQLExecuter sqlExe = new SQLExecuter("");
			
			insCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOMergeEqrHolidayEffectCSQL(), insModels,null);
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No"+ i + " SQL");
			}

        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(),de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
	}
	
	/**
	 * EES_EQR_042Event ScenarioDefaultManage의 수정 된 데이타 모델을 DB에 반영한다.
	 * Grid 2
	 * @param List insModels
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void multiDefaultHolidayEffectDetailInfo(List insModels) throws DAOException {
          
        int insCnt[] = null;
        
        try {
        	SQLExecuter sqlExe = new SQLExecuter("");
			
			insCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOMergeEqrHolidayEffectDetailCSQL(), insModels,null);
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No"+ i + " SQL");
			}

        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(),de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
	}	
	
    /**
     * DefaultManage의 연간 신조 계획 조회/수정(EES_EQR_121) 정보 조회
     * 
     * @param condiVO EesEqr121ConditionVO
     * @return ScenarioDefaultManageRsVO
     * @see EesEqr0121Event
     * @exception DAOException
    */

	public ScenarioDefaultManageRsVO searchDefaultYearNewvanPlan(EesEqr0121ConditionVO condiVO) throws DAOException {
		
		ScenarioDefaultManageRsVO retVo = new ScenarioDefaultManageRsVO();
		DBRowSet dRs 		= null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
    	String status   = condiVO.getStatus();
 		String tpsztype = condiVO.getTpsztype();
 		//String company  = condiVO.getCompany();
 		String leaseterm= condiVO.getLeaseterm();
 		String year     = condiVO.getYear();

 		param.put("status", status);
 		param.put("tpsztype", tpsztype);
 		//param.put("company", company);
 		param.put("leaseterm", leaseterm);
 		param.put("year", year);
 		velParam.put("status", status);
 		velParam.put("tpsztype", tpsztype);
 		//velParam.put("company", company);
 		velParam.put("leaseterm", leaseterm);
 		velParam.put("year", year);
 		
 		String[] monthArr = condiVO.getMonthInfo().split(","); 		
 		List<String> monthArrList = new ArrayList<String>();
 		for(int i = 0 ; i < monthArr.length ; i++){
 			if(monthArr[i] != null && !monthArr[i].equals("")){
 				monthArrList.add(monthArr[i]);
 			}
 		}
 		
 		velParam.put("monthArr", monthArrList);
 		
                           
    	// ecc 검색조건
    	if(!status.equals("")) {
    		List<String> eccArr  = condiVO.getEccArr(); 
    		velParam.put("eccArr", eccArr);
    	}
    	
        // TP/SZ 에 따른 조건값을 넣어 준다.
        if(!tpsztype.equals("")) {
        	String[] perfixS1 = tpsztype.split(",");
        	List<String> perfix1 = new ArrayList<String>();        	
        	for(int i=0; i<perfixS1.length; i++) {
        		perfix1.add(perfixS1[i]);
        	}
        	velParam.put("perfix1", perfix1);
    	}
        
		try {
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchYearNewVanPlanRSQL(), param, velParam);
			
			retVo.setDBRowSet(dRs);
			return retVo;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
	}	
		
    /**
     * DefaultManage의 연간 Week 신조 계획 조회/수정(EES_EQR_121) 정보 조회
     * 
     * @param condiVO EesEqr0121ConditionVO
     * @return ScenarioDefaultManageRsVO
     * @exception DAOException
    */
	@SuppressWarnings("unchecked")
	public ScenarioDefaultManageRsVO searchDefaultWeekNewvanPlan(EesEqr0121ConditionVO condiVO) throws DAOException {
		
		ScenarioDefaultManageRsVO retVo = new ScenarioDefaultManageRsVO(); // DBRowSet 개체를 담을 VO
		DBRowSet dRs 		= null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
    	String status   = condiVO.getStatus();
 		String tpsztype = condiVO.getTpsztype();
 		//String company  = condiVO.getCompany();
 		String leaseterm= condiVO.getLeaseterm();
 		String year     = condiVO.getYear();

 		param.put("status", status);
 		param.put("tpsztype", tpsztype);
 		//param.put("company", company);
 		param.put("leaseterm", leaseterm);
 		param.put("year", year);
 		velParam.put("status", status);
 		velParam.put("tpsztype", tpsztype);
 		//velParam.put("company", company);
 		velParam.put("leaseterm", leaseterm);
 		velParam.put("year", year);
 		
 		String[] weekArr = condiVO.getWeekInfo().split(",");
 		velParam.put("weekArr", weekArr);
                           
    	// ecc 검색조건
    	if(!status.equals("")) {
    		List<String> eccArr  = condiVO.getEccArr();
    		velParam.put("eccArr", eccArr);
    	}
    	
        // TP/SZ 에 따른 조건값을 넣어 준다.
        if(!tpsztype.equals("")) {
        	String[] perfixS1 = tpsztype.split(",");
        	List<String> perfix1 = new ArrayList();        	
        	for(int i=0; i<perfixS1.length; i++) {
        		perfix1.add(perfixS1[i]);
        	}
        	velParam.put("perfix1", perfix1);
    	}
        			
		try {
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchWeekNewVanPlanRSQL(), param, velParam);
  			retVo.setDBRowSet(dRs);
			return retVo;

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
	}	

	/**
     * DefaultManage의 New VAN L/T 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
     * 
     * @param insModels List
     * @exception DAOException
    */
	@SuppressWarnings("unchecked")
	public void mergeYearNewVanPlan(List insModels) throws DAOException {
		int insCnt[] = null;
		try{
			insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOMergeYearNewVanPlanCSQL(), insModels,null);
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No"+ i + " SQL");
			}
		} catch (Exception e) {
	        log.error(e.getMessage(),e);
	        throw new DAOException(e.getMessage());
	    }
	}

	/**
     * DefaultManage의 New VAN L/T 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
     * 
     * @param delModels List
     * @exception DAOException
    */
	@SuppressWarnings("unchecked")
	public void deleteYearNewVanPlan(List delModels) throws DAOException {
		int delCnt[] = null;
		try{
			delCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAODeleteYearNewVanPlanDSQL(), delModels,null);
			for(int i = 0; i < delCnt.length; i++){
				if(delCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete No"+ i + " SQL");
			}
		} catch (Exception e) {
	        log.error(e.getMessage(),e);
	        throw new DAOException(e.getMessage());
	    }
	}
    
	/**
     * DefaultManage의 New VAN L/T Sheet2수정내용을 DB에 반영한다.(수정)<br>
     * 
     * @param List updtModels
     * @see EesEqr0121Event
     * @exception DAOException
    */
    @SuppressWarnings("unchecked")
	public void modifyDefaultWeekNewvanPlan(List updtModels) throws DAOException {
        int updtCnt[] = null;
        try {
        	SQLExecuter sqlExe = new SQLExecuter("");
			
			updtCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOMergeWeekNewVanPlanCSQL(), updtModels,null);
			for(int i = 0; i < updtCnt.length; i++){
				if(updtCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No"+ i + " SQL");
			}

        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
    }    

    /**
     * 수정시 insert를 해야 할 값에 대한 중복체크를 실시한다.
     * 결과값이 true 이면 insert를 하고 false 이면 입력작업 하지 않는다.       
     * 
     * @param monthWeek
     * @param co_cd
     * @param ecc_cd
     * @param cntr_lstm_cd
     * @param cntr_tpsz_cd
     * @param vndr_cnt_cd
     * @param vndr_seq_cd
     * @param cntr_de_sts_cd
     * @return boolean
     * @exception DAOException
     */
    public boolean newVanLongTermInsertCheck(String monthWeek, String co_cd, String ecc_cd, String cntr_lstm_cd, String cntr_tpsz_cd, String vndr_cnt_cd, String vndr_seq_cd, String cntr_de_sts_cd) throws DAOException {
    	//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        DBRowSet dRs 		= null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
	    boolean key = false;
	    param.put("pln_yrmon", monthWeek);
	    param.put("co_cd", co_cd);
	    param.put("ecc_cd", ecc_cd);
	    param.put("cntr_lstm_cd", cntr_lstm_cd);
	    param.put("cntr_tpsz_cd", cntr_tpsz_cd);
	    param.put("vndr_cnt_cd", vndr_cnt_cd);
	    param.put("vndr_seq", vndr_seq_cd);
	    param.put("cntr_de_sts_cd", cntr_de_sts_cd);
	    int k;
	    try {
	    	
	    	dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOCheckNewVanLongTermRSQL(), param, null);
	        if(dRs.next()){
	        	k = dRs.getInt("coun");
	        	if(k == 0) {
	        		key = true;
	        	}
	        }
	
	    }catch (SQLException se) {
	        log.error(se.getMessage(), se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    }catch (DAOException de) {
	        log.error(de.getMessage(), de);
	        throw de;
	    }catch (Exception e) {
	        log.error(e.getMessage(), e);
	        throw new DAOException(e.getMessage());
	    }
	    return key;
	}
    
    /**
     * DefaultManage의 Link Info 조회(EES_EQR_116) 정보 조회
     * 
     * @param condiVo EesEqr0116ConditionVO : 조건 VO
     * @param fromEccAL ArrayList :  fromLocation 배열
     * @param toEccAL  ArrayList :  toLocation 배열
     * @return  List<EqrEccLnkVO>
     * @see EesEqr0116Event
     * @exception DAOException
    */
	@SuppressWarnings("unchecked")
	public List<EqrEccLnkVO> searchDefaultECCLinkInfo(EesEqr0116ConditionVO condiVo, ArrayList fromEccAL , ArrayList toEccAL) throws DAOException {
		
		List<EqrEccLnkVO> list = null;		
		// 조건값 셋팅 
		String fromStatus   = condiVo.getFromStatus();
    	String toStatus     = condiVo.getToStatus();
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		velParam.put("fromStatus",condiVo.getFromStatus());
		velParam.put("toStatus",condiVo.getToStatus());
		param.put("transitTime",condiVo.getTransitTime()); 
		param.put("mode",condiVo.getMode());  
		velParam.put("transitTime",condiVo.getTransitTime()); 
		velParam.put("mode",condiVo.getMode());             
		
    	// from loc 검색조건
    	if(!fromStatus.equals("")) {
    		
    		velParam.put("fromEccArr",fromEccAL);
    	}
    	   
    	// to loc 검색조건
    	if(!toStatus.equals("")) {
    		velParam.put("toEccArr",toEccAL);
    	}
    	DBRowSet dRs 		= null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchEccLinkInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dRs, EqrEccLnkVO .class);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return list;
	}	    

	/**
     * DefaultManage의Link Info  Sheet1 수정내용을 DB에 반영한다.(수정)<br>
     * 
     * @param List insModels
     * @see EesEqr0116Event
     * @exception DAOException
    */
	@SuppressWarnings("unchecked")
	public void manageDefaultECCLinkInfo(List insModels) throws DAOException {
	   	
		int insCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
		
			insCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOModifyEccLinkInfoUSQL(), insModels,null);
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No"+ i + " SQL");
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
    }  

	/**
     * DefaultManage의Link Info  Sheet1 수정내용을 DB에 반영한다.(수정)<br>
     * 
     * @param List delModels
     * @see EesEqr0116Event
     * @exception DAOException
    */
	@SuppressWarnings("unchecked")
	public void deleteDefaultECCLinkInfo(List delModels) throws DAOException {
	   	
		int delCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//DELETE 시 ROW delete 하지 않고 필드만 update 하여 이력관리함 - 2007.08.30 (by.JH Kwon)
	        //modified : R200711074347 : 이미 기 삭제된 ECC_LINK를 새로 저장 할 경우 DELT_FLG값을 다시 원복하게 변경
			delCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOModifyEccLinkInfoDSQL(), delModels,null);
			for(int i = 0; i < delCnt.length; i++){
				if(delCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete No"+ i + " SQL");
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
    }  
	/**
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param status String
	 * @param location String
	 * @return DBRowSet
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchEccMasterVO> searchDefaultECCInfo(String status, String location) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEccMasterVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			ArrayList arrLocation = (ArrayList) Utils.replaceStrToList(location);
		
			velParam.put("status", status);
			velParam.put("arrlocation", arrLocation);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchEccMasterRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEccMasterVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param eccCd String
	 * @return List<SearchEccTsTmlVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchEccTsTmlVO> searchDefaultTSTMLInfo(String eccCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEccTsTmlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("eccCd", eccCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchEccTsTmlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEccTsTmlVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
		 
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param updModels List<EqrEccMstVO>
	 * @exception DAOException
	 */
	public void modifyDefaultECCInfo(List<EqrEccMstVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOModifyEccMasterUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param updModels List<EqrTsTmlVO>
	 * @exception DAOException
	 */
	public void modifyDefaultTSTMLInfo(List<EqrTsTmlVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOModifyEccTsTmlUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param eccWhereCondition String
	 * @param tpsztype String
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public CommonRsVO searchDefaultSTOnHireInfo(String eccWhereCondition, String tpsztype) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			ArrayList arrLocation = (ArrayList) Utils.replaceStrToList(eccWhereCondition);
			ArrayList arrTpszcd = (ArrayList) Utils.replaceStrToList(tpsztype);
		
			velParam.put("arrlocation", arrLocation);
			velParam.put("arrtpszcd", arrTpszcd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchShortTermOnHireInfoRSQL(), param, velParam);
			rsVO.setDbRowset(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	 
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param updModels List<EqrShrtTermOnhCondVO>
	 * @exception DAOException
	 */
	public void modifyDefaultSTOnHireInfo(List<EqrShrtTermOnhCondVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOMergeShortTermOnHireInfoCSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param delModels List<EqrShrtTermOnhCondVO>
	 * @exception DAOException
	 */
	public void deleteDefaultSTOnHireInfo(List<EqrShrtTermOnhCondVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(delModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAODeleteShortTermOnHireInfoDSQL(), delModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		
	/**
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param eccWhereCondition String
	 * @param tpsztype String 
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public CommonRsVO searchDefaultLTOffHireInfo(String eccWhereCondition, String tpsztype) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			ArrayList arrLocation = (ArrayList) Utils.replaceStrToList(eccWhereCondition);
			ArrayList arrTpszcd = (ArrayList) Utils.replaceStrToList(tpsztype);
		
			velParam.put("arrlocation", arrLocation);
			velParam.put("arrtpszcd", arrTpszcd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchLongTermOffHireInfoRSQL(), param, velParam);
			rsVO.setDbRowset(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return rsVO;
	}
		 
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param updModels List<EqrLongTermOffhCondVO>
	 * @exception DAOException
	 */
	public void modifyDefaultLTOffHireInfo(List<EqrLongTermOffhCondVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOMergeLongTermOffHireInfoCSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param delModels List<EqrLongTermOffhCondVO> 
	 * @exception DAOException
	 */
	public void deleteDefaultLTOffHireInfo(List<EqrLongTermOffhCondVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(delModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAODeleteLongTermOffHireInfoDSQL(), delModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param conditionVO EesEqr0123ConditionVO 
	 * @return List<SearchYearSubleasePlanVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<SearchYearSubleasePlanVO> searchDefaultYearSubleasePlan(EesEqr0123ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchYearSubleasePlanVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			String plnYr = "";
			
			if ("1".equals(conditionVO.getFmToAt())) {
				plnYr = conditionVO.getFmPlnYr();
			} else {
				plnYr = conditionVO.getAtPlnYr();
			}
			param.put("plnyr", plnYr);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchYearSubleasePlanRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchYearSubleasePlanVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list;
	}
	 
	/**
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param conditionVO EesEqr0123ConditionVO 
	 * @return List<SearchYearSubleaseDetailPlanMonthlyVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<SearchYearSubleaseDetailPlanMonthlyVO> searchDefaultYearSubleaseDetailPlanMonthly(EesEqr0123ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchYearSubleaseDetailPlanMonthlyVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			String plnYr = "";
			if ("1".equals(conditionVO.getFmToAt())) {
				plnYr = conditionVO.getFmPlnYr();
			} else {
				plnYr = conditionVO.getAtPlnYr();
			}
			
			Map<String, String> mapVO = conditionVO .getColumnValues();
			ArrayList arrFmEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getFmEccCd());
			ArrayList arrToEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getToEccCd());
			ArrayList arrAtEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getAtEccCd());
			ArrayList arrTpszcd = (ArrayList) Utils.replaceStrToList(conditionVO.getCntrTpszCd());
			
			param.put("plnyr", plnYr);
			
			velParam.putAll(mapVO);
			velParam.put("arrFmEccCd", arrFmEccCd);
			velParam.put("arrToEccCd", arrToEccCd);
			velParam.put("arrAtEccCd", arrAtEccCd);
			velParam.put("arrTpszcd", arrTpszcd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchYearSubleaseDetailPlanMonthlyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchYearSubleaseDetailPlanMonthlyVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list;
	}
		 
	/**
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param conditionVO EesEqr0123ConditionVO 
	 * @return List<SearchYearSubleaseDetailPlanWeeklyVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<SearchYearSubleaseDetailPlanWeeklyVO> searchDefaultYearSubleaseDetailPlanWeekly(EesEqr0123ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchYearSubleaseDetailPlanWeeklyVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			String plnYr = "";
			if ("1".equals(conditionVO.getFmToAt())) {
				plnYr = conditionVO.getFmPlnYr();
			} else {
				plnYr = conditionVO.getAtPlnYr();
			}
			
			Map<String, String> mapVO = conditionVO .getColumnValues();
			ArrayList arrFmEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getFmEccCd());
			ArrayList arrToEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getToEccCd());
			ArrayList arrAtEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getAtEccCd());
			ArrayList arrTpszcd = (ArrayList) Utils.replaceStrToList(conditionVO.getCntrTpszCd());
			
			param.put("plnyr", plnYr);
			
			velParam.putAll(mapVO);
			velParam.put("arrFmEccCd", arrFmEccCd);
			velParam.put("arrToEccCd", arrToEccCd);
			velParam.put("arrAtEccCd", arrAtEccCd);
			velParam.put("arrTpszcd", arrTpszcd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchYearSubleaseDetailPlanWeeklyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchYearSubleaseDetailPlanWeeklyVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return list;
	}
	 
	/**
	 * 단건의 데이터를 삭제한다.<br>
	 * 
	 * @param conditionVO EesEqr0123ConditionVO
	 * @return int
	 * @exception DAOException
	 */
	public int deleteYearSubleasePlanRCC(EesEqr0123ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ScenarioDefaultManageDBDAODeleteYearSubleasePlanRCCDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param voList List<EqrSubleaseVO>
	 * @exception DAOException
	 */
	public void insertYearSubleasePlan(List<EqrSubleaseVO> voList) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOInsertYearSubleasePlanCSQL(), voList,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param voList List<EqrSubleaseVO>
	 * @exception DAOException
	 */
	public void updateYearSubleasePlan(List<EqrSubleaseVO> voList) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(voList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOUpdateYearSubleasePlanUSQL(), voList,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param updModels List<EqrSubleaseVO>
	 * @exception DAOException
	 */
	public void modifyDefaultYearSubleasePlan(List<EqrSubleaseVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOMergeYearSubleasePlanCSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param delModels List<EqrSubleaseVO>
	 * @exception DAOException
	 */
	public void deleteDefaultYearSubleasePlan(List<EqrSubleaseVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(delModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAODeleteYearSubleasePlanDSQL(), delModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * [EES_EQR_0043 : Turn Time 조회]<br>
	 * 
	 * @param EesEqr0043ConditionVO eesEqr0043ConditionVO - 검색조건
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchDefaultCntrTurnTimeInfo(EesEqr0043ConditionVO eesEqr0043ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		CommonRsVO commonRsVO = new CommonRsVO();

		try{
			if(eesEqr0043ConditionVO != null){
				Map<String, String> mapVO = eesEqr0043ConditionVO .getColumnValues();
				
				String oddtpsz = eesEqr0043ConditionVO.getOddtpsz();
				ArrayList arrtpsz = (ArrayList) Utils.replaceStrToList(oddtpsz);
				String locationStr = eesEqr0043ConditionVO.getLoctype();
				ArrayList arrlocation = (ArrayList) Utils.replaceStrToList(locationStr);
				
				velParam.putAll(mapVO);
				velParam.put("arrtpsz", arrtpsz);
				velParam.put("arrlocation", arrlocation);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchEccTurnTimeRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	
	/**
	 * [EES_EQR_0043 : Turn Time 수정]<br>
	 * 
	 * @param updModels List<EqrEccTurnTmVO> 
	 * @exception DAOException
	 */
	public void modifyDefaultCntrTurnTimeInfo(List<EqrEccTurnTmVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOMergeEccTurnTimeCSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_EQR_0043 : Turn Time 삭제]<br>
	 * 
	 * @param delModels List<EqrEccTurnTmVO>
	 * @exception DAOException
	 */
	public void deleteDefaultCntrTurnTimeInfo(List<EqrEccTurnTmVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAODeleteEccTurnTimeDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_EQR_0119 : S/T Off Hire 조회]<br>
	 * 
	 * @param status String
	 * @param location String
	 * @param tpsztype String
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchDefaultSTOffHireInfo(String status, String location, String tpsztype) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		CommonRsVO commonRsVO = new CommonRsVO();
		try{		
			String tpszStr = tpsztype;
			ArrayList arrtpsz = (ArrayList) Utils.replaceStrToList(tpszStr);
			String locationStr = location;
			ArrayList arrlocation = (ArrayList) Utils.replaceStrToList(locationStr);
			
			velParam.put("status", status);
			velParam.put("arrtpsz", arrtpsz);
			velParam.put("arrlocation", arrlocation);
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchShortTermOffHireInfoRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	
	/**
	 * [EES_EQR_0119 : S/T Off Hire 수정]<br>
	 * 
	 * @param updModels List<EqrShrtTermOffhCondVO>
	 * @exception DAOException
	 */
	public void modifyDefaultSTOffHireInfo(List<EqrShrtTermOffhCondVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOMergeShortTermOffHireInfoCSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_EQR_0119 : S/T Off Hire 삭제]<br>
	 * 
	 * @param delModels List<EqrShrtTermOffhCondVO> 
	 * @exception DAOException
	 */
	public void deleteDefaultSTOffHireInfo(List<EqrShrtTermOffhCondVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAODeleteShortTermOffHireInfoDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_EQR_0124 : Cabotage & HJS Rule 조회]<br>
	 * 
	 * @param cnsttype String
	 * @param tpsztype String
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchDefaultEmptyRepoConstraintInfo(String cnsttype, String tpsztype) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		CommonRsVO commonRsVO = new CommonRsVO();
		try{
			ArrayList arrtpsz = (ArrayList) Utils.replaceStrToList(tpsztype);
				
			velParam.put("cnsttype", cnsttype);
			velParam.put("arrtpsz", arrtpsz);
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchEmptyRepoConstraintInfoRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	
	/**
	 * [EES_EQR_0124 : Cabotage & HJS Rule - Insert시 필요한 Cnst Rule Id 구하기.]<br>
	 * 
	 * @param nationCode String
	 * @param cnstTypeCode String
	 * @return int
	 * @exception DAOException
	 */
	public int createCnstRuleId(String nationCode, String cnstTypeCode) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int cnstRuleId = 0;

		try{
			param.put("nationcode", nationCode);
			param.put("cnsttypecode", cnstTypeCode);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOCreateCnstRuleIDRSQL(), param, velParam);
			if( dbRowset != null){
				while ( dbRowset.next())
					cnstRuleId = dbRowset.getInt("cnst_rule_id");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnstRuleId;
	}
	
	/**
	 * [EES_EQR_0124 : Cabotage & HJS Rule - Insert시 필요한 Cnst Sequence 구하기.]<br>
	 * 
	 * @return int
	 * @exception DAOException
	 */
	public int createCnstSeq() throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int cnst_seq = 0;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOCreateCnstSeqRSQL(), param, velParam);
			if( dbRowset != null){
				while ( dbRowset.next())
					cnst_seq = dbRowset.getInt("repo_cnst_seq");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnst_seq;
	}
	
	/**
	 * [EES_EQR_0124 : Cabotage & HJS Rule 수정]<br>
	 * 
	 * @param updModels List<EqrRepoCnstVO> 
	 * @exception DAOException
	 */
	public void modifyDefaultEmptyRepoConstraintInfo(List<EqrRepoCnstVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOInsertEmptyRepoConstraintCSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_EQR_0124 : Cabotage & HJS Rule 삭제]<br>
	 * 
	 * @param delModels List<EqrRepoCnstVO>
	 * @exception DAOException
	 */
	public void deleteDefaultEmptyRepoConstraintInfo(List<EqrRepoCnstVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAODeleteEmptyRepoConstraintDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_EQR_0137 : Constraint by Lane/POD 조회.]<br>
	 * 
	 * @param eesEqr0137ConditionVO EesEqr0137ConditionVO 
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchDefaultConstraintLandPod(EesEqr0137ConditionVO eesEqr0137ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		CommonRsVO commonRsVO = new CommonRsVO();
		try{
			if(eesEqr0137ConditionVO != null){
				//Map<String, String> mapVO = eesEqr0137ConditionVO .getColumnValues();
				
				String status			= eesEqr0137ConditionVO.getStatus();
				String location			= eesEqr0137ConditionVO.getLocation();
				String lane				= eesEqr0137ConditionVO.getLane();
				String tpsztype			= eesEqr0137ConditionVO.getTpsz();

				ArrayList arrlocation	= (ArrayList) Utils.replaceStrToList(location);
				ArrayList arrlane		= (ArrayList) Utils.replaceStrToList(lane);
				ArrayList arrtpsz		= (ArrayList) Utils.replaceStrToList(tpsztype);
				
				velParam.put("status", status);
				velParam.put("arrlocation", arrlocation);
				velParam.put("arrlane", arrlane);
				velParam.put("arrtpsz", arrtpsz);
			}
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchConstLandPodRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	
	/**
	 * [EES_EQR_0137 : Constraint by Lane/POD 수정.]<br>
	 * 
	 * @param updModels List<EqrPortDchgCnstVO>
	 * @exception DAOException
	 */
	public void modifyDefaultConstraintLandPod(List<EqrPortDchgCnstVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOMergeConstLandPodCSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_EQR_0137 : Constraint by Lane/POD 삭제.]<br>
	 * 
	 * @param delModels List<EqrPortDchgCnstVO>
	 * @exception DAOException
	 */
	public void deleteDefaultConstraintLandPod(List<EqrPortDchgCnstVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAODeleteConstLandPodDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param searchAutoRunParameter SearchAutoRunParameterVO
	 * @return List<SearchAutoRunParameterVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchAutoRunParameterVO> searchAutoRunParameter(SearchAutoRunParameterVO searchAutoRunParameter) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchAutoRunParameterVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchAutoRunParameter != null){
				Map<String, String> mapVO = searchAutoRunParameter .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchAutoRunParameterRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAutoRunParameterVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
	/**
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String  selectEffStYrwk() throws DAOException {
		DBRowSet dbRowset = null;
		List<EqrWkPrdVO> list = null;
		EqrWkPrdVO eqrWkPrdVO = null;
		
		String curDate = DateTime.getShortDateString();
		int curYear = DateTime.getYear();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
		
			Map<String, String> mapVO = new HashMap();
		
			mapVO.put("wk_st_dt", curDate);
			mapVO.put("wk_end_dt", curDate);
			
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSelectEffStYrwkRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqrWkPrdVO .class);
			
			if (list.size() == 1) {
				eqrWkPrdVO = list.get(0);
				return curYear + eqrWkPrdVO.getPlnWk();
			}else {
				return null;
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 데이터를 insert를 한다.<br>
	 * 
	 * @param model 데이타 모델
	 * @return DBRowSet
	 * @exception DAOException
	 */
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param updModels List<EqrAutoRunFcastParaVO>
	 * @param effCurYrwk String
	 * @param effNextYrwk String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void multiAutoRunParameterInsert(List<EqrAutoRunFcastParaVO> updModels ,String effCurYrwk , String effNextYrwk) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO = new HashMap();
			
			mapVO.put("effNextYrwk", effNextYrwk);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOMultiAutoRunParameterCSQL(), updModels, param, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("insert to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 데이터를 insert를 한다.<br>
	 * 
	 * @param model 데이타 모델
	 * @return DBRowSet
	 * @exception DAOException
	 */
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<EqrAutoRunFcastParaVO> updModels
	 * @param String effCurYrwk
	 * @param String effNextYrwk
	 * @param boolean flag
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void multiAutoRunParameterUpdate(List<EqrAutoRunFcastParaVO> updModels, String effCurYrwk, String effNextYrwk, boolean flag) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			String updateState = null;
			
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = new HashMap();
			
			if(flag){
			  updateState = "1";	
			}else{
			  updateState = "2";
			}
			
			mapVO.put("effCurYrwk", effCurYrwk);
			mapVO.put("flag", updateState);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOMultiAutoRunParameterUSQL(), updModels, param, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param SearchSafetyStockVO searchSafetyStock
	 * @param String loc
	 * @param String loctype
	 * @param String tpze
	 * @param String tpsztype
	 * @param String tpsztypes
	 * @param String lvlcd
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CommonRsVO searchDefaultCntrSafetyStock(SearchSafetyStockVO searchSafetyStock ,String loc ,String loctype , String tpze ,String tpsztype ,String tpsztypes ,String lvlcd) throws DAOException {
		DBRowSet dbRowset = null;
		//List<SearchSafetyStockVO> list = null;
		//EesEqr0117Event event =  new EesEqr0117Event();
		CommonRsVO returnVO = new CommonRsVO();
		String arrtpszcd = Utils.convertStr(tpsztype);
		String arrloccd = Utils.convertStr(loctype);
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
  
 		try{
			if(searchSafetyStock != null){
				Map<String, String> mapVO = searchSafetyStock .getColumnValues();
			    
				velParam.put("loc", loc);
				velParam.put("loctype", arrloccd);
				velParam.put("tpsztype", tpsztype);
				velParam.put("tpszcd", arrtpszcd);
				velParam.put("lvlcd",lvlcd);
				velParam.put("perfix", (ArrayList)Utils.replaceStrToList(tpsztype));
				param.put("lvlcd", lvlcd);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchSafetyStockRSQL(), param, velParam);
			returnVO.setDbRowset(dbRowset);
		//	list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSafetyStockVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	 
	/**
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.(0117화면에서 불륨을 가져온다)<br>
	 * 
	 * @param EesEqr0117ConditionVo EesEqr0117ConditionVO
	 * @return List<EesEqr0117ConditionVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<EesEqr0117ConditionVO> searchDefaultCntrSafetyStockQty(EesEqr0117ConditionVO EesEqr0117ConditionVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<EesEqr0117ConditionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
 		try{
 			
		  if(EesEqr0117ConditionVo != null){
				Map<String, String> mapVO = EesEqr0117ConditionVo.getColumnValues();
			    //log.debug("==값:" + EesEqr0117ConditionVo.getEcc_cd());
			    
			    param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchSafetyStockQtyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EesEqr0117ConditionVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
		 
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 0117화면의 insert 문 
	 * @param insModels List<EqrEccSftStkVO> 
	 * @param lvl_cd String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void multiDefaultCntrSafetyStockInsert(List<EqrEccSftStkVO> insModels ,String lvl_cd) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			//String insertState = null;
			
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = new HashMap();
			
			
			//param.put("lvl_cd", lvl_cd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOInsertSafetyStockCSQL(), insModels, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 0117화면의 Update 문 
	 * @param upsModels List<EqrEccSftStkVO>
	 * @param lvl_cd String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void multiDefaultCntrSafetyStockUpdate(List<EqrEccSftStkVO> upsModels ,String lvl_cd) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int upsCnt[] = null;
			//String updateState = null;
			
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = new HashMap();
			
			
			param.put("lvl_cd", lvl_cd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(upsModels.size() > 0){
				upsCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOUpdateSafetyStockUSQL(), upsModels, param, velParam);
				for(int i = 0; i < upsCnt.length; i++){
					if(upsCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 0117화면의 delete 문 
	 * @param delModels List<EqrEccSftStkVO>
	 * @param lvl_cd String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void multiDefaultCntrSafetyStockDelete(List<EqrEccSftStkVO> delModels ,String lvl_cd) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			//String deleteState = null;
			
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = new HashMap();
			
			
			param.put("lvl_cd", lvl_cd);
		    velParam.put("lvl_cd" , lvl_cd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAODeleteSafetyStockDSQL(), delModels, param, velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
 		
	}
	
	/**
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param ecc_cd String
	 * @param cntp_sz_cd String
	 * @return boolean
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public boolean  searchCntrSafetyStockIsExist(String ecc_cd ,String cntp_sz_cd) throws DAOException {
		DBRowSet dbRowset = null;
		List<EqrEccSftStkVO> list = null;
	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
		
			Map<String, String> mapVO = new HashMap();
		
			mapVO.put("ecc_cd", ecc_cd);
			mapVO.put("cntr_tpsz_cd", cntp_sz_cd);
			
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchSafetyStockExistRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqrEccSftStkVO .class);
			
			if (list.size() == 1) {
				return true;
			}else {
				return false;
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}	
	
	/**
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param eesEqr0122ConditionVO EesEqr0122ConditionVO
	 * @return ScenarioDefaultManageRsVO
	 * @exception DAOException
	 */
	public ScenarioDefaultManageRsVO searchDefaultYearDomesticPlan(EesEqr0122ConditionVO eesEqr0122ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		ScenarioDefaultManageRsVO rsVO = new ScenarioDefaultManageRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        
		String plnYr = "";
		if(eesEqr0122ConditionVO.getFmToAt().equals("1")) {
	    	plnYr = eesEqr0122ConditionVO.getFmPlnYr();
	    } else {
	    	plnYr = eesEqr0122ConditionVO.getFmPlnYr();
	    }
		
		try{
		    param.put("pln_yr", plnYr);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchDefaultYearDomesticPlanRSQL(), param, velParam);
			rsVO.setDBRowSet(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
			 
			 
	/**
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param eesEqr0122ConditionVO EesEqr0122ConditionVO
	 * @return ScenarioDefaultManageRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ScenarioDefaultManageRsVO  searchDefaultYearDomesticDetailPlan(EesEqr0122ConditionVO eesEqr0122ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		ScenarioDefaultManageRsVO rsVO = new ScenarioDefaultManageRsVO();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        
		String plnYr ="";
		StringBuffer whereStr = new StringBuffer();
		
		for(int k=1;k<=53;k++) {
			whereStr.append(((k == 0) ? "" : ",") + k );
		}
		ArrayList arrfmecccd 	= (ArrayList) Utils.replaceStrToList(eesEqr0122ConditionVO.getFmEccCd());
		ArrayList arratecccd 	= (ArrayList) Utils.replaceStrToList(eesEqr0122ConditionVO.getAtEccCd());
		ArrayList arrtoecccd 	= (ArrayList) Utils.replaceStrToList(eesEqr0122ConditionVO.getToEccCd());
		ArrayList arrcntrtpszcd = (ArrayList) Utils.replaceStrToList(eesEqr0122ConditionVO.getCntrTpszCd());
		ArrayList week 			= (ArrayList) Utils.replaceStrToList(whereStr.toString());
		
		if(eesEqr0122ConditionVO.getFmToAt().equals("1")) {
	    	plnYr = eesEqr0122ConditionVO.getFmPlnYr();
	    } else {
	    	plnYr = eesEqr0122ConditionVO.getFmPlnYr();
	    }
		try{
			//Map<String, String> mapVO = new HashMap();
			
			velParam.put("monthweek"	, eesEqr0122ConditionVO.getMonthWeek());
			velParam.put("fmtoat"   	, eesEqr0122ConditionVO.getFmToAt());
			velParam.put("fmtypeby" 	, eesEqr0122ConditionVO.getFmTypeBy());
			velParam.put("attypeby" 	, eesEqr0122ConditionVO.getAtTypeBy());
			velParam.put("fmtoat"   	, eesEqr0122ConditionVO.getFmToAt());
			velParam.put("totypeby" 	, eesEqr0122ConditionVO.getToTypeBy());
			velParam.put("toecccd"		, eesEqr0122ConditionVO.getToEccCd());
			velParam.put("fmecccd"  	, eesEqr0122ConditionVO.getFmEccCd());
			velParam.put("fmtype"   	, eesEqr0122ConditionVO.getFmType());
			velParam.put("totype"		, eesEqr0122ConditionVO.getToType());
			velParam.put("arrfmecccd"	, arrfmecccd);
			velParam.put("attype"     	, eesEqr0122ConditionVO.getAtType());
			velParam.put("arratecccd"	, arratecccd);
			velParam.put("arrtoecccd"   , arrtoecccd);
			velParam.put("cntrtpszcd"   , eesEqr0122ConditionVO.getCntrTpszCd());
			velParam.put("arrcntrtpszcd", arrcntrtpszcd);
			velParam.put("week"         , week);
			param.put("pln_yrwk", plnYr);
//						param.putAll(mapVO);
//						velParam.putAll(mapVO);
			
			//log.debug("====totype" + EesEqr0122ConditionVO.getToType());
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultmanageDBDAOSearchYearDomesticPlanDetailRSQL(), param, velParam);
			rsVO.setDBRowSet(dbRowset);
			
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
		return rsVO;
	}
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 0122화면의 delete 문 
	 * @param year String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void createDefaultYearDomesticPlanDelete(String year ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt = 0;
			//String deleteState = null;
			
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = new HashMap();
			
		    param.put("pln_yrwk",year);
		    velParam.put("pln_yrwk",year);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			delCnt = sqlExe.executeUpdate((ISQLTemplate)new ScenarioDefaultManageDBDAODeleteAllYearDomesticPlanDSQL(), param, velParam);
			
			if(delCnt== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update No SQL");
		
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
 		
	}	
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 0122화면의 insert 문 
	 * @param yrWk String
	 * @param rscount String
	 * @param user_id String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void createDefaultYearDomesticPlanInsert(String yrWk , Object rscount ,String user_id) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt = 0;
			//String insertState = null;
			
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = new HashMap();
			
			
			param.put("pln_yrwk",yrWk);
			//log.debug("=======createDefaultYearDomesticPlanInsert=====");
            velParam.put("rscount" ,rscount);
            param.put("cre_usr_id", user_id);
            param.put("upd_usr_id", user_id);
            
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			insCnt = sqlExe.executeUpdate((ISQLTemplate)new ScenarioDefaultManageDBDAOInsertYearDomesticPlanRSQL(), param, velParam);
			if(insCnt== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update No SQL");
	
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 0122화면 Update
	 * @param yrWk String
	 * @param rscount String
	 * @param user_id String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void createDefaultYearDomesticPlanUpdate(String yrWk , Object rscount ,String user_id) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = 0;
			//String updateState = null;
			
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = new HashMap();
			
			param.put("yrwk",yrWk);
			//log.debug("=======createDefaultYearDomesticPlanInsert=====");
            velParam.put("rscount" ,rscount);
            
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			updCnt = sqlExe.executeUpdate((ISQLTemplate)new ScenarioDefaultManageDBDAOUpdateYearDomesticPlanUSQL(), param, velParam);	
			if(updCnt== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update No SQL");
		
		
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 0122화면 Update
	 * @param updModels List<EqrDmstPlnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void modifyDefaultYearDomesticPlanUpdate(List<EqrDmstPlnVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			//String updateState = null;
			
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = new HashMap();
			
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOMergeYearDomesticPlanCSQL(), updModels, param, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 0122화면의 delete 문 
	 * @param delModels List<EqrDmstPlnVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void modifyDefaultYearDomesticPlanDelete(List<EqrDmstPlnVO> delModels ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			//String deleteState = null;
			
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = new HashMap();
		   
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		
			delCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAODeleteYearDomesticPlanDSQL(), delModels, param, velParam);
			for(int i = 0; i < delCnt.length; i++){
				if(delCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No"+ i + " SQL");
			}
		
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
 		
	}	
}
