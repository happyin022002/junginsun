/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LeaseInfoManageDBDAO.java
*@FileTitle : ST On-Hire
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.07.27 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.basic.LeaseInfoManageBCImpl;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.vo.EesEqr0017ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.vo.EesEqr0085ConditionVO;
import com.hanjin.apps.alps.ees.eqr.scenariomanage.leaseinfomanage.vo.EesEqr0086ConditionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.EqrScnrLongTermOffhCondVO;
import com.hanjin.syscommon.common.table.EqrScnrShrtTermOnhCondVO;



/**
 * ALPS LeaseInfoManageDBDAO <br>
 * - ALPS-ScenarioManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Haeng-ji,Lee
 * @see LeaseInfoManageBCImpl 참조
 * @since J2EE 1.6
 */
public class LeaseInfoManageDBDAO extends DBDAOSupport {

	/**
	 * [EES_EQR_0017 : S/T On Hire 조회]<br>
	 * 
	 * @param eesEqr0017ConditionVO EesEqr0017ConditionVO 
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CommonRsVO searchSTOnHireInfo(EesEqr0017ConditionVO eesEqr0017ConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO commonRsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eesEqr0017ConditionVO != null){
				ArrayList arrlocation	= (ArrayList) Utils.replaceStrToList(eesEqr0017ConditionVO.getLocation());
				ArrayList arrtpsz		= (ArrayList) Utils.replaceStrToList(eesEqr0017ConditionVO.getTpsztype());
				
				param.put("scnr_id",eesEqr0017ConditionVO.getScnrId());
				velParam.put("arrlocation",arrlocation);
				velParam.put("arrtpsz",arrtpsz);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LeaseInfoManageDBDAOSearchSTOnHireInfoRSQL(), param, velParam);
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
	 * [EES_EQR_0017 : S/T On Hire 삽입]<br>
	 * 
	 * @param insModels List<EqrScnrShrtTermOnhCondVO> 
	 * @return int[]
	 * @exception DAOException,Exception
	 */
	public int[] addSTOnHireInfo(List<EqrScnrShrtTermOnhCondVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LeaseInfoManageDBDAOInsertSTOnHireInfoCSQL(), insModels,null);
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
		return insCnt;
	}
	/**
	 * [EES_EQR_0017 : S/T On Hire 수정]<br>
	 * 
	 * @param updModels List<EqrScnrShrtTermOnhCondVO> 
	 * @return int[]
	 * @exception DAOException,Exception
	 */
	public int[] modifySTOnHireInfo(List<EqrScnrShrtTermOnhCondVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new LeaseInfoManageDBDAOUpdateSTOnHireInfoUSQL(), updModels,null);
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
		return updCnt;
	}
	
	/**
	 * [EES_EQR_0017 : S/T On Hire 삭제]<br>
	 * 
	 * @param delModels List<EqrScnrShrtTermOnhCondVO> 
	 * @return int[]
	 * @exception DAOException,Exception
	 */
	public int[] removeSTOnHireInfo(List<EqrScnrShrtTermOnhCondVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new LeaseInfoManageDBDAODeleteSTOnHireInfoDSQL(), delModels,null);
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
		return delCnt;
	}
	/**
	 * [EES_EQR_0017, 0085, 0086 : EQR_ECC_MST 존재여부 체크]<br>
	 * 
	 * @param ecc_cd String 
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean insertUpdateHireECCChk(String ecc_cd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int cnt = 0;

		try{
			if(ecc_cd != null){
				param.put("ecc_cd", ecc_cd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LeaseInfoManageDBDAOCheckHireECCRSQL(), param, velParam);
			if( dbRowset != null){
				while ( dbRowset.next())
					cnt = dbRowset.getInt("cnt");
				
				if ( cnt > 0 ){
					return true;		// EQR_ECC_MST 존재하면 true
				} else {
					return false;
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return false;
	}
	/**
	 * [EES_EQR_0017 : EQR_SCNR_SHRT_TERM_ONH_COND 존재여부 체크]<br>
	 * 
	 * @param scnr_id String
	 * @param ecc_cd String
	 * @param cntr_tpsz_cd String
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean insertUpdateChkOnHire(String scnr_id, String ecc_cd, String cntr_tpsz_cd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int cnt = 0;

		try{
			if(ecc_cd != null){
				param.put("scnr_id",		scnr_id);
				param.put("ecc_cd",			ecc_cd);
				param.put("cntr_tpsz_cd",	cntr_tpsz_cd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LeaseInfoManageDBDAOCheckSTOnHireRSQL(), param, velParam);
			if( dbRowset != null){
				while ( dbRowset.next())
					cnt = dbRowset.getInt("CNT");
				
				if ( cnt == 0 ){
					return true;	// EQR_SCNR_SHRT_TERM_ONH_COND 존재하지 않으면 insert하기 위해 true 반환
				} else {
					return false;
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return false;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param conditionVO EesEqr0086ConditionVO
	 * @param ecc_info String
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CommonRsVO searchLTOffHireInfo(EesEqr0086ConditionVO conditionVO ,String ecc_info) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		
		 String scnr_id  = Constants.SCNR_WORD + conditionVO.getYyyyww() + Constants.SCNR_WEEK + conditionVO.getSeq();
		try{
			ArrayList prefix = (ArrayList) Utils.replaceStrToList(conditionVO.getTpsztype());
			ArrayList ecc_perfix =  (ArrayList) Utils.replaceStrToList(ecc_info);
	
			param.put   ("scnr_id"		, scnr_id);  //시나리오 아이디
			velParam.put("loc"          , conditionVO.getLoc());
			velParam.put("ecc_perfix"	, ecc_perfix); // loc type
			velParam.put("prefix"		, prefix); // cntr_tpsz_cd
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LeaseInfoManageDBDAOsearchLTOffHireInfoRSQL(), param, velParam);
			rsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param insModels List<EqrScnrLongTermOffhCondVO> 
	 * @return int[]
	 * @exception DAOException,Exception
	 */
	public int[] insertLTOffHireInfo(List<EqrScnrLongTermOffhCondVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new LeaseInfoManageDBDAOInsertLTOffHireInfoCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param updModels List<EqrScnrLongTermOffhCondVO> 
	 * @return int[]
	 * @exception DAOException,Exception
	 */
	public int[] updateLTOffHireInfo(List<EqrScnrLongTermOffhCondVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new LeaseInfoManageDBDAOUpdateLTOffHireInfoUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param delModels List<EqrScnrLongTermOffhCondVO> 
	 * @return int[]
	 * @exception DAOException,Exception
	 */
	public int[] deleteLTOffHireInfo(List<EqrScnrLongTermOffhCondVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
			 	delCnt = sqlExe.executeBatch((ISQLTemplate)new LeaseInfoManageDBDAODeleteLTOffHireInfoDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * [EES_EQR_0086 : EQR_SCNR_LONG_TERM_OFFH_COND 존재여부 체크]<br>
	 * 
	 * @param scnr_id String 
	 * @param ecc_cd String 
	 * @param ctrt_ofc_cty_cd String
	 * @param ctrt_seq String
	 * @param cntr_tpsz_cd String 
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean checkUpdateLTOffHire(String scnr_id, String ecc_cd ,String ctrt_ofc_cty_cd,String ctrt_seq, String cntr_tpsz_cd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int cnt = 0;

		try{
			if(ecc_cd != null){
				param.put("scnr_id"			, scnr_id);
				param.put("ecc_cd"			, ecc_cd);
				param.put("ctrt_ofc_cty_cd"	, ctrt_ofc_cty_cd);
				param.put("ctrt_seq" 		, ctrt_seq);
				param.put("cntr_tpsz_cd"	, cntr_tpsz_cd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LeaseInfoManageDBDAOCheckUpdateLTOffHireRSQL(), param, velParam);
			if( dbRowset != null){
				while ( dbRowset.next())
					cnt = dbRowset.getInt("cnt");
				
				if ( cnt == 0 ){
					return true;	// EQR_SCNR_LONG_TERM_OFFH_COND 존재하지 않으면 insert하기 위해 true 반환
				} else {
					return false;
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return false;
	}
	 /**
     * S/T off-Hire 정보 조회 /수정 - EES_EQR_085<br>
     * 
     * @param conditionVO	EesEqr0085ConditionVO
     * @param ecc_info		String
     * @return CommonRsVO
     * @exception DAOException
     */   
    public CommonRsVO searchSTOffHireInfo(EesEqr0085ConditionVO conditionVO , String ecc_info) throws DAOException {
    	
    	DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        String scnr_id  = Constants.SCNR_WORD + conditionVO.getYyyyww() + Constants.SCNR_WEEK + conditionVO.getSeq();
        String loc      = conditionVO.getLoc();
        //String tpSz     = ConditionVO.getTpsz();
        String tpSzType = conditionVO.getTpsztype();
        
        
        // 동적으로 쿼리문을 만들기 위한 변수 선언
     //   String[] perfix = {"D2","D4","D5","D7","R2","R5","O2","O4","F2","F4"};
        List<String> perfixArr = Utils.replaceStrToList(tpSzType);
        List<String> eccPerfixArr = Utils.replaceStrToList(ecc_info);
        
		             		                     
        try {
        	param.put("scnr_id", scnr_id);
        	velParam.put("perfixArr", perfixArr);
        	velParam.put("EccperfixArr", eccPerfixArr);
        	velParam.put("loc", loc);
        	velParam.put("tpSzType", tpSzType);        	

            // 결과를 DBRowset에 담는다.
        	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LeaseInfoManageDBDAOSearchSTOffHireInfoRSQL(), param, velParam);
			rsVO.setDbRowset(dbRowset);
			
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
        return rsVO;
    }

    /**
     * LeaseInfoManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
     * 화면 : S/T off-Hire 정보조회 /수정 <br>
     * 
     * @param insModels List
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public void insertSTOffHireInfo(List insModels) throws DAOException {
    	int insCnt[] = null;
    	try{
    		insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new LeaseInfoManageDBDAOInsertSTOffHireInfoCSQL(), insModels,null);
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
     * LeaseInfoManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
     * 화면 : S/T off-Hire 정보조회 /수정 <br>
     * 
     * @param updModels List
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public void updateSTOffHireInfo(List updModels) throws DAOException {
    	int updCnt[] = null;
    	try{
    		updCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new LeaseInfoManageDBDAOUpdateSTOffHireInfoUSQL(), updModels,null);
			for(int i = 0; i < updCnt.length; i++){
				if(updCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No"+ i + " SQL");
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
     * LeaseInfoManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
     * 화면 : S/T off-Hire 정보조회 /수정 <br>
     * 
     * @param delModels List
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
	public void deleteSTOffHireInfo(List delModels) throws DAOException {
    	int delCnt[] = null;
    	try{
    		delCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new LeaseInfoManageDBDAODeleteSTOffHireInfoDSQL(), delModels,null);
			for(int i = 0; i < delCnt.length; i++){
				if(delCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete No"+ i + " SQL");
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
     * S/T on-hire, S/T off-hire, L/T off-hire 검색시 update 시 기존 데이터가 있는지 없는지
     * 확인을 위한 메소드 이다. <br>
     * S/T on-hire는 OnHire로  구분하여 InsertUpdateChkOnHire 분기 
     * S/T off-hire는 offHire로 구분하여 InsertUpdateChkOffHire 분기 
     * L/T off-hire는 LtOffHire로 구분하여 InsertUpdateChkLTOffHire 분기  
     * 결과값이 true 이면 insert를 하고 false 이면 update를 수행을 한다. 
     * @param scnr_id		String
     * @param ecc_cd		String
     * @param cntr_tpsz_cd	String
     * @param gubun			String
     * @param ctrt_ofc_cty_cd	String
     * @param ctrt_seq		String
     * @return boolean 
     * @exception DAOException
    */    

	public boolean insertUpdateHireECCChk(String scnr_id , String ecc_cd , String cntr_tpsz_cd ,String gubun ,String ctrt_ofc_cty_cd , String ctrt_seq) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	    int ecc_count = 0;
	    
	    boolean key = false;  //  체크를 하고 return할 값 초기값 설정 
	                 
	    try {
	    	param.put("ecc_cd", ecc_cd);
	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LeaseInfoManageDBDAOCheckUpdateHireECCRSQL(), param, null);
	       
	        
	        if (dbRowset.next())
	        {
	        	ecc_count = dbRowset.getInt("coun");
	        	if (ecc_count > 0){ //EQR_RCC_MST에 해당되는 ECC가 있을때
	        		
	        		if (gubun.equals("OnHire")){ //  S/T OnHire로 체크할때 
	        			key = insertUpdateChkOnHire(scnr_id,ecc_cd,cntr_tpsz_cd);
	        		 }
	        		if (gubun.equals("OffHire")){//  S/T offHire로 체크 이동 
	        			key = insertUpdateChkOffHire(scnr_id,ecc_cd,cntr_tpsz_cd ,ctrt_ofc_cty_cd, ctrt_seq);
	        		 }
	        		if (gubun.equals("LtOffHire")){ // L/T offHire로 체크 이동 
	        			key = insertUpdateChkLTOffHire(scnr_id,ecc_cd,cntr_tpsz_cd ,ctrt_ofc_cty_cd, ctrt_seq);
	        		}
	        	
	         	}
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
	    return key;
	}

	/**
     * InsertUpdateHireECCChk메소드에서 체크를 하여 S/T off-hire 인경우 분기하여 <br>
     * S/T off-Hire의 테이블을 검색해서 데이터가 있는지 없는지 확인을 한다.  
     * 데이터가  없으면   true 로  데이터가 없으면  false 이면 return 수행을 한다. 
     * @param scnr_id		String
     * @param ecc_cd		String
     * @param cntr_tpsz_cd	String
     * @param ctrt_ofc_cty_cd	String
     * @param ctrt_seq		String
     * @return boolean 
     * @exception DAOException
     */	
	public boolean insertUpdateChkOffHire(String scnr_id , String ecc_cd , String cntr_tpsz_cd , String ctrt_ofc_cty_cd , String ctrt_seq) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
	    // PreparedStatement에 bind 변수를 넣을시 증가되는 변수
	    int k = 0;
	    boolean key = false;  // EQR_SCNR_SHRT_TERM_ONH_COND 체크를 하고 return할 값 초기값 설정 
	    
	    try {
	    	param.put("scnr_id", scnr_id);
	    	param.put("ecc_cd", ecc_cd);
	    	param.put("ctrt_ofc_cty_cd", ctrt_ofc_cty_cd);
	    	param.put("ctrt_seq", ctrt_seq);
	    	param.put("cntr_tpsz_cd", cntr_tpsz_cd);
	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LeaseInfoManageDBDAOCheckUpdateSTOffHireRSQL(), param, null);
	        if (dbRowset.next())
	        {
	        	k = dbRowset.getInt("coun");
	        	if (k == 0){ //EQR_SCNR_SHRT_TERM_OFFH_COND에 해당되는 ECC가 있을때 
	        		key = true;
	        	}
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
	    return key;
	}

	/**
     * InsertUpdateHireECCChk메소드에서 체크를 하여 L/T off-hire 인경우 분기하여 <br>
     * L/T off-Hire의 테이블을 검색해서 데이터가 있는지 없는지 확인을 한다.  
     * 데이터가  없으면   true 로  데이터가 없으면  false 이면 return 수행을 한다. 
     * @param scnr_id		String
     * @param ecc_cd		String
     * @param cntr_tpsz_cd	String
     * @param ctrt_ofc_cty_cd	String
     * @param ctrt_seq		String
     * @return boolean
     * @exception DAOException
     */
	public boolean insertUpdateChkLTOffHire(String scnr_id , String ecc_cd , String cntr_tpsz_cd , String ctrt_ofc_cty_cd , String ctrt_seq) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	    int k = 0;
	    boolean key = false;  // EQR_SCNR_LONG_TERM_OFFH_COND 체크를 하고 return할 값 초기값 설정 
	                 
	    try {

	    	param.put("scnr_id", scnr_id);
	    	param.put("ecc_cd", ecc_cd);
	    	param.put("ctrt_ofc_cty_cd", ctrt_ofc_cty_cd);
	    	param.put("ctrt_seq", ctrt_seq);
	    	param.put("cntr_tpsz_cd", cntr_tpsz_cd);
	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new LeaseInfoManageDBDAOCheckUpdateLTOffHireRSQL(), param, null);
	        if (dbRowset.next())
	        {
	        	k = dbRowset.getInt("cnt");
	        	if (k == 0){ //EQR_SCNR_LONG_TERM_OFFH_COND에 해당되는 ECC가 있을때 
	        		key = true;
	        	}
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
	    return key;
	}
	/**
     * LeaseInfoManage의 모든 목록을 가져온다.<br>
     * @param  seq String
     * @return int str
     */   
	public int ctrt_seq_SubString (String seq) {
		int str = 0;
		str = seq.length()-seq.substring(0,3).length() + seq.substring(0,3).length();
		log.info("길이 값==>" + str);
		return str; 
	}
}