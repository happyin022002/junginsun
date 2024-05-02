/*=========================================================
*Copyright(c) 2006~2008 CyberLogitec
*@FileName : CommboCodeDBDAO.java
*@FileTitle : 3자구상 유형등록
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-19
*@LastModifier : Sun, CHOI
*@LastVersion : 2.1
* 2006-10-09 Youngchang_Kim 1.0 최초 생성
* 2008-05-22 Kim Jin-seung  1.1 수정 : checkTrdParty method의 SQL에서 double quote 변환처리;
* 2008-06-17 Kim Jin-seung  1.2 수정 : searchLevel Method, SINWA 추가에 따른 SQL변경; => cvs commit in 2008-07-01
* 2008-07-01 Kim Jin-seung  1.3 수정 : searchOfficeLevel, searchOfficeList, checkTPBOffice Method, SINWA 추가에 따른 SQLQ수정;
* 2008-09-10 O Wan-Ki       1.4 메서드 추가 : searchOfficeTopLevel
* 2009-01-08 O Wan-Ki       1.5 searchHandleOfficeLevel()의 인자추가(priv_cd), searchControlOfficeList() & searchTPBOfficeList() 메서드추가.
* 2009-01-09 O Wan-Ki       1.5 searchHandleOfficeLevel()의 Control Office 검색 쿼리변경.
* 2009-01-12 O Wan-Ki       1.6 searchCtrlOffice() 추가
* 2009-04-30 O Wan-Ki       1.7 N200904160080, VVD Check Method 추가.
* 2009-06-01 O Wan-Ki       1.8 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]
* 2009-06-11 O Wan-Ki       1.9 N200905110239, Named BIZ Customer flag 반영.
* 2009-09-07 O Wan-Ki       2.0 ITM-200900076, getThirdPartyBillingCaseHorizontally 에 의한 보완
* 2009-11-19 Sun, CHOI      2.1 ALPS Migration
* 2010.09.14 변종건 [CHM-201005591-01]	 [TPB] 소스품질 결함 사항 정리
* 2011.03.31 변종건 [CHM-201109756-01] [TPB] Billing Type 특정case 조회 이상 현상 수정
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.combo.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.tpb.common.combo.event.CommonCodeEvent;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.CheckUtils;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.jf.transfer.wtc.tdo.ValueObject;

/**
 * alps-ESD에 대한 DB 처리를 담당<br>
 * - alps-ESD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Sun, Choi
 * @see CommboCodeBCImpl 참조
 * @since J2EE 1.4
 */
public class CommonCodeDBDAO extends DBDAOSupport {

	
	/**
	 * <b><font color=blue>[SQL]</font></b> SELECT tpb_n3rd_pty_bil_tp <br>
	 * @param String mainCode
	 * @param String sDefaultSelectCode
	 * @param String[][] addOptionInfo
	 * @param String[] codeConditionPositiveArr
	 * @param String[] codeConditionNegativeArr
	 * @param int sortKey
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCodeComboData(String mainCode, String sDefaultSelectCode, 
			String[][] addOptionInfo, String[] codeConditionPositiveArr, String[] codeConditionNegativeArr, int sortKey) throws DAOException{
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet dbRowset = null;

	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			ArrayList<String> tempPositiveArr = new ArrayList<String>();
		    ArrayList<String> tempNegativeArr = new ArrayList<String>();
		    
		    if ( sortKey < 1 || sortKey > 4) { 
				sortKey = 1; 
			} 

		    param.put("main_code", mainCode);
		    param.put("s_default_select_code", sDefaultSelectCode);
		    
		    if(codeConditionPositiveArr != null){
			    for(int idx=0;idx<codeConditionPositiveArr.length;idx++){
			    	tempPositiveArr.add(codeConditionPositiveArr[idx].toString());
			    }
			    
			    if(tempPositiveArr.size()>0){
					velParam.put("code_condition_positive_arr", tempPositiveArr);						
				}
		    }

		    if(codeConditionNegativeArr != null){
			    for(int idx=0;idx<codeConditionNegativeArr.length;idx++){
			    	tempNegativeArr.add(codeConditionNegativeArr[idx].toString());
			    }
			    
			    if(tempNegativeArr.size()>0){
					velParam.put("code_condition_negative_arr", tempNegativeArr);						
				}
		    }
		    
	    	/// Added Option 
			if ( addOptionInfo!=null ){
		    	List<ValueObject> addOptArr = new ArrayList<ValueObject>(); 
		    	
				for (int idx=0; idx<addOptionInfo.length; idx++){
					ValueObject vo = new ValueObject();
					
					vo.set("name0", addOptionInfo[idx][0]);
					vo.set("name1", addOptionInfo[idx][1]);
					vo.set("name2", addOptionInfo[idx][2]);
					
					addOptArr.add(vo);
				}
				param.put("addOptArr", addOptArr);
				velParam.put("addOptArr", addOptArr);
			}

			
		    velParam.put("sortKey", sortKey);
  		    
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchCodeComboDataRSQL(), param, velParam);
	    }catch(SQLException se){
			log.error(se.getMessage(),se);
		 	throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return dbRowset;
	}
	
	/**
	 * Billing Type Code를 조회한다. <br>
	 * <b><font color=blue>[SQL]</font></b> SELECT tpb_n3rd_pty_bil_tp <br>
	 * @param CommonCodeEvent event 
	 * @return DBRowSet searchBillingCaseCode
	 * @throws DAOException
	 */
	public DBRowSet searchBillingCaseCode(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;
		 
		 try{
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchBillingCaseCodeRSQL(), null, null);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;
	}

	/**
	  * Billing Type Code를 조회한다. TES에서 사용<br>
	  * 
	  * @return DBRowSet searchBillingCaseCodeByTES
	  * @throws DAOException
	  */
	public DBRowSet searchBillingCaseCodeByTES() throws DAOException {
		 DBRowSet dbRowset = null;
		
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchGetTesBillingCaseRSQL(), param, velParam);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;		
	}
	/**
	 * Billing Type Code를 조회한다. TES에서 사용<br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet searchBillingCaseByExpenseType
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchBillingCaseByExpenseType(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;
		 
		 HashMap params = event.getEventParams();

		 String s_n3pty_expn_tp_cd = JSPUtil.getNull((String)params.get("s_n3pty_expn_tp_cd"));
		 String s_n3pty_src_sub_sys_cd = JSPUtil.getNull((String)params.get("s_n3pty_src_sub_sys_cd"));
		 
		 String cd = JSPUtil.getNull((String)params.get("s_n3pty_expn_tp_cd"));
		 if(cd.equals("")){
			 cd = JSPUtil.getNull((String)params.get("s_n3pty_src_sub_sys_cd"));
		 }
		
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(event != null){			
				 param.put("s_n3pty_expn_tp_cd", s_n3pty_expn_tp_cd);
				 param.put("s_n3pty_src_sub_sys_cd", s_n3pty_src_sub_sys_cd);
				 velParam.put("s_n3pty_expn_tp_cd", s_n3pty_expn_tp_cd);
//				 log.debug("s_n3pty_expn_tp_cd==========>"+s_n3pty_expn_tp_cd);
//				 log.debug("s_n3pty_src_sub_sys_cd==========>"+s_n3pty_src_sub_sys_cd);
//				 log.debug("param==========>"+param);
//				 log.debug("velParam==========>"+velParam);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchBillingCaseByExpenseTypeRSQL(), param, velParam);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;
	}
	/**
	 * Billing Type Code를 조회한다.<br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet searchBillingCaseName
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchBillingCaseName(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;
		 
		 HashMap params = event.getEventParams();
		 
		 String s_bil_tp_cd = JSPUtil.getNull((String)params.get("s_bil_tp_cd"));
		 String s_n3pty_if_tp_cd = JSPUtil.getNull((String)params.get("s_n3pty_if_tp_cd"));
		 // cannot be registerd in case of JO; Added By Kim Jin-seung In 2007-08-21
		 String s_jo_display = JSPUtil.getNull((String)params.get("s_jo_display"));
		 String s_n3pty_expn_tp_cd = JSPUtil.getNull((String)params.get("s_n3pty_expn_tp_cd"));
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(event != null){				 
				 param.put("s_bil_tp_cd", s_bil_tp_cd);
				 param.put("s_n3pty_if_tp_cd", s_n3pty_if_tp_cd);
				 param.put("s_n3pty_expn_tp_cd", s_n3pty_expn_tp_cd);
				 velParam.put("s_bil_tp_cd", s_bil_tp_cd);
				 velParam.put("s_n3pty_if_tp_cd", s_n3pty_if_tp_cd);
				 velParam.put("s_jo_display", s_jo_display);
				 
//				 log.debug("param==========>"+param);
//				 log.debug("velParam==========>"+velParam);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchBillingCaseNameRSQL(), param, velParam);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;
	}
	
	/**
	 * 공통코드, Head Office 목록을 가져온다.<br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet searchHOList
	 * @throws DAOException
	 */
	public DBRowSet searchHOList(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;
			
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchHOListRSQL(), param, velParam);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;				
	}
	/**
	 * 공통코드, RHQ Office 목록을 가져온다.<br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet searchRHQList
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchRHQList(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;

		 HashMap params = event.getEventParams();
		 String s_office_level = (String)params.get("s_office_level");
		 String s_ofc_cd_for_rhq = JSPUtil.getNull((String)params.get("s_ofc_cd_for_rhq"));
//		 log.debug("s_office_level==========>"+s_office_level);
//		 log.debug("s_ofc_cd_for_rhq==========>"+s_ofc_cd_for_rhq);	
			
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(event != null){				 
				 param.put("s_ofc_cd_for_rhq", s_ofc_cd_for_rhq);
				 velParam.put("s_office_level", s_office_level);
				 
//				 log.debug("param==========>"+param);
//				 log.debug("velParam==========>"+velParam);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchRHQListRSQL(), param, velParam);

		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;		
	}

	/**
	 * 공통코드, RHQ Office 목록을 가져온다.<br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet searchHandleRHQList
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchHandleRHQList(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;

		 HashMap params = event.getEventParams();
		 String s_office_level = JSPUtil.getNull((String)params.get("s_office_level"));
		 String s_ofc_cd_for_rhq = JSPUtil.getNull((String)params.get("s_ofc_cd_for_rhq"));
		 String s_if_rhq_cd = JSPUtil.getNull((String)params.get("s_if_rhq_cd"));
//		 log.debug("s_office_level==========>"+s_office_level);
//		 log.debug("s_ofc_cd_for_rhq==========>"+s_ofc_cd_for_rhq);	
//		 log.debug("s_if_rhq_cd==========>"+s_if_rhq_cd);	
		 if ( s_ofc_cd_for_rhq.length() == 0){
			 s_ofc_cd_for_rhq = s_if_rhq_cd; 
		 }
			
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(event != null){				 
				 param.put("s_ofc_cd_for_rhq", s_ofc_cd_for_rhq);
				 velParam.put("s_office_level", s_office_level);
				 
//				 log.debug("param==========>"+param);
//				 log.debug("velParam==========>"+velParam);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchHandleRHQListRSQL(), param, velParam);

		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;
	}
	
	/**
	 * 공통코드, RHQ Office 목록을 가져온다.<br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet searchOfficeList
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchOfficeList(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;
		 
		 HashMap params = event.getEventParams();
		 String s_if_rhq_cd = (String)params.get("s_if_rhq_cd");
//		 log.debug("s_if_rhq_cd==========>"+s_if_rhq_cd);	
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(event != null){				 
				 param.put("s_if_rhq_cd", s_if_rhq_cd);
				 
//				 log.debug("param==========>"+param);
//				 log.debug("velParam==========>"+velParam);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchOfficeListRSQL(), param, velParam);

		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;		
	}
	/**
	 * 공통코드, 특정 RHQ/Ctrl Office 하위 Jo Office 목록을 가져온다.<br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet searchHandleOfficeList
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchJoHandleOfficeList(CommonCodeEvent event) throws DAOException{
		 DBRowSet dbRowset = null;
		 
		 HashMap params = event.getEventParams();
		 String s_if_rhq_cd = JSPUtil.getNull((String)params.get("s_if_rhq_cd"));
		 String s_if_ctrl_cd = JSPUtil.getNull((String)params.get("s_if_ctrl_cd"));
//		 log.debug("s_if_rhq_cd==========>"+s_if_rhq_cd);	
//		 log.debug("s_if_ctrl_cd==========>"+s_if_ctrl_cd);	
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(event != null){				 
				 param.put("s_if_rhq_cd", s_if_rhq_cd);
				 param.put("s_if_ctrl_cd", s_if_ctrl_cd);
				 velParam.put("s_if_rhq_cd", s_if_rhq_cd);
				 velParam.put("s_if_ctrl_cd", s_if_ctrl_cd);
				 
//				 log.debug("param==========>"+param);
//				 log.debug("velParam==========>"+velParam);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchJoHandleOfficeListRSQL(), param, velParam);

		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;
	}
	
	
	/**
	 * 공통코드, 특정 RHQ/Ctrl Office 하위 Office 목록을 가져온다.<br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet searchHandleOfficeList
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchHandleOfficeList(CommonCodeEvent event) throws DAOException{
		 DBRowSet dbRowset = null;
		 
		 HashMap params = event.getEventParams();
		 String s_if_rhq_cd = JSPUtil.getNull((String)params.get("s_if_rhq_cd"));
		 String s_if_ctrl_cd = JSPUtil.getNull((String)params.get("s_if_ctrl_cd"));
//		 log.debug("s_if_rhq_cd==========>"+s_if_rhq_cd);	
//		 log.debug("s_if_ctrl_cd==========>"+s_if_ctrl_cd);	
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(event != null){				 
				 param.put("s_if_rhq_cd", s_if_rhq_cd);
				 param.put("s_if_ctrl_cd", s_if_ctrl_cd);
				 velParam.put("s_if_rhq_cd", s_if_rhq_cd);
				 velParam.put("s_if_ctrl_cd", s_if_ctrl_cd);
				 
//				 log.debug("param==========>"+param);
//				 log.debug("velParam==========>"+velParam);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchHandleOfficeListRSQL(), param, velParam);

		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;
	}
	
	/**
	 * Outstanding Confirm 이나 Manual 등록시 입력한 Office의 validation check<br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet checkOffice
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet checkOffice(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;
		 
		 HashMap params = event.getEventParams();
		 String if_ofc_cd = JSPUtil.getNull((String)params.get("if_ofc_cd"));
		 if(if_ofc_cd.equals("")){
			 if_ofc_cd = JSPUtil.getNull((String)params.get("s_if_ofc_cd"));
		 }
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(event != null){				 
				 param.put("s_if_ofc_cd", if_ofc_cd);
				 
//				 log.debug("param==========>"+param);
//				 log.debug("velParam==========>"+velParam);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchCheckOfficeRSQL(), param, velParam);

		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;		
	}
	/**
	 * EAC 등록, Adjustment ROC Request시 입력한 Office의 validation check <br>
	 * <b><font color=blue>[SQL]</font></b> SELECT mdm_organization <br>
	 * @param event 데이타 모델
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet checkTPBOffice(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;
		 
		 HashMap params = event.getEventParams();
		 String usr_ofc_cd = JSPUtil.getNull((String)params.get("ofc_cd")); // login user office code
		 log.debug("usr_ofc_cd==========>"+usr_ofc_cd);
		 // EAC 의 경우
		 String if_ofc_cd = JSPUtil.getNull((String)params.get("if_ofc_cd"));
		 if(if_ofc_cd.equals("")){
			 if_ofc_cd = JSPUtil.getNull((String)params.get("s_if_ofc_cd"));
		 }
		 
//		 boolean isCheckTPBOfficeRhqSub = false;
//       String checkTPBOfficeRhqSub = JSPUtil.getNull((String)params.get("checkTPBOfficeRhqSub"));
//		 String[] officeLevelInfo = null;
		 
		 // Adjustment ROC의 경우 
		 String stl_to_clt_cng_ofc_cd = JSPUtil.getNull((String)params.get("stl_to_clt_cng_ofc_cd"));
		 if ( !stl_to_clt_cng_ofc_cd.equals("")){
			 if_ofc_cd = stl_to_clt_cng_ofc_cd; // 값이 있으면 값을 덮어씀
		 }
			
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(event != null){				 
				 param.put("s_if_ofc_cd", if_ofc_cd);
//				 param.put("s_if_ofc_cd", if_ofc_cd);
//				 velParam.put("s_check_tpb_office_rhq_sub", checkTPBOfficeRhqSub);
				 
//				 log.debug("param==========>"+param);
//				 log.debug("velParam==========>"+velParam);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchCheckTPBOfficeRSQL(), param, velParam);

		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;		
	}
	/**
	 * Manual 등록시 입력한 BKG NO. validation check <br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet checkBKGNo
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")	
	public DBRowSet checkBKGNo(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;
		 
		 HashMap params = event.getEventParams();
			
		 String bkg_no = JSPUtil.getNull((String)params.get("bkg_no"));
		 if(bkg_no.equals("")){
			 bkg_no = JSPUtil.getNull((String)params.get("s_bkg_no"));
		 }
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
//		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(event != null){				 
				 param.put("s_bkg_no", bkg_no);
				 
//				 log.debug("param==========>"+param);
//				 log.debug("velParam==========>"+velParam);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchCheckBKGNoRSQL(), param, null);

		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;			
	}
	/**
	 * Manual 등록시 입력한 BL No.를 이용하여 BKG NO가져오기<br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet checkBKGNoWithBLNo
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")	
	public DBRowSet checkBKGNoWithBLNo(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;
		 
		 HashMap params = event.getEventParams();
		 String s_bl_no_all = JSPUtil.getNull((String)params.get("s_bl_no_all"));
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
//		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(event != null){				 
				 param.put("s_bl_no_all", s_bl_no_all);
				 
//				 log.debug("param==========>"+param);
//				 log.debug("velParam==========>"+velParam);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchCheckBKGNoWithBLNoRSQL(), param, null);

		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;			
	}	
	/**
	 * Manual 등록시 입력한 BL NO. validation check <br>
	 * <b><font color=blue>[SQL]</font></b> SELECT bkg_booking <br>
	 * @param event 데이타 모델
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet checkBLNo(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;
		 
		 HashMap params = event.getEventParams();
//		 String bkg_no_split = JSPUtil.getNull((String)params.get("s_bkg_no_split"));
		 String bkg_no = JSPUtil.getNull((String)params.get("s_bkg_no"));
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
//		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(event != null){				 
				 param.put("s_bkg_no", bkg_no);
				 
//				 log.debug("param==========>"+param);
//				 log.debug("velParam==========>"+velParam);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchCheckBLNoRSQL(), param, null);

		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;			
	}
	/**
	 * TPB Seq를 가지고 온다.<br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet getTPBSeq
	 * @throws DAOException
	 */
	public DBRowSet getTPBSeq(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{		 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchGetTPBSeqRSQL(), param, velParam);	 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;			
	}
	/**
	 * Vessel 을 제외한 Expense Type code.<br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet searchExpenseType
	 * @throws DAOException
	 */	
	@SuppressWarnings("unchecked")
	public DBRowSet searchExpenseType(CommonCodeEvent event) throws DAOException {		 
		 DBRowSet dbRowset = null;
		 
		 HashMap params = event.getEventParams();
		 String s_n3pty_if_tp_cd = JSPUtil.getNull((String)params.get("s_n3pty_if_tp_cd"));
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
//		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(param != null){				 
				 param.put("s_ofc_cd", "CD00904");
				 param.put("s_n3pty_if_tp_cd", s_n3pty_if_tp_cd);
				 
//				 log.debug("param==========>"+param);
//				 log.debug("velParam==========>"+velParam);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchExpenseTypeRSQL(), param, null);
		 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;	
	}
	
	/**
	 * 사용자의 조직코드로 레벨정보를 구한다.<br>
	 * 레벨 : H(HO) / R(RHQ) / G(General Office) <br>
	 * @param String officeCode
	 * @return String[] searchOfficeLevel
	 * @throws DAOException
	 */
	public String[] searchOfficeLevel(String officeCode) throws DAOException {
		 String[] officeInfo = new String[4];
		 
		 DBRowSet dbRowset = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
//		 Map<String, Object> velParam = new HashMap<String, Object>();
		
		 try{
			 if(officeCode != null){				 
				 param.put("s_ofc_cd", officeCode);
				 
//				 log.debug("param==========>"+param);
//				 log.debug("velParam==========>"+velParam);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchOfficeLevelRSQL(), param, null);
				
			 // to Get Office-Level Fromt DBRowSet
			 if ( dbRowset!=null && dbRowset.next() ){
				 officeInfo[0] = dbRowset.getString(1);
				 officeInfo[1] = dbRowset.getString(2);
				 officeInfo[2] = dbRowset.getString(3);
				 officeInfo[3] = dbRowset.getString(4);
			 }
		 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return officeInfo;		
	}
	/**
	 * 사용자의 조직코드로 레벨정보를 구한다.<br>
	 * 레벨 : H(HO) / R(RHQ) / G(General Office) <br>
	 * @param String officeCode
	 * @param boolean isIncludeControlOffice
	 * @return String[] searchHandleOfficeLevel
	 * @throws DAOException
	 */
	public String[] searchHandleOfficeLevel(String officeCode, boolean isIncludeControlOffice) throws DAOException {
		 String[] officeInfo = new String[5];
		 
		 DBRowSet dbRowset = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		
		 try{
			 if(officeCode != null){				 
				 param.put("s_ofc_cd", officeCode);
				 velParam.put("is_include_control_office", isIncludeControlOffice);
				 
//				 log.debug("param==========>"+param);
//				 log.debug("velParam==========>"+velParam);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchHandleOfficeLevelRSQL(), param, velParam);
//			 log.debug( " officeCode : " + officeCode + " / officeLevel : " + officeInfo[0] + 
//					    " / officeCode : " + officeInfo[1] + " / RHQ Code: " + officeInfo[2] + 
//					    " / Head Office Code : " + officeInfo[3] ); 
				
			 // to Get Office-Level Fromt DBRowSet
			 if ( dbRowset!=null && dbRowset.next() ){
				 officeInfo[0] = dbRowset.getString(1);
				 officeInfo[1] = dbRowset.getString(2);
				 officeInfo[2] = dbRowset.getString(3);
				 officeInfo[3] = dbRowset.getString(4);
				 officeInfo[4] = dbRowset.getString(5); //2009-01-08 O Wan-Ki      1.5 searchHandleOfficeLevel()의 인자추가(priv_cd)
			 }
		 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return officeInfo;
	}
	
	/**
	 * 사용자의 조직코드로 레벨정보를 구한다.<br>
	 * 레벨 : H(HO) / R(RHQ) / C (Control) / G(General Office) <br>* 레벨 : H(HO) / R(RHQ) / C (Control) / G(General Office) <br>
	 * @param String officeCode
	 * @return String[] searchHandleOfficeLevelWithControl
	 * @throws DAOException
	 */
	public String[] searchHandleOfficeLevelWithControl(String officeCode) throws DAOException {
		 String[] officeInfo = new String[4];
		 
		 DBRowSet dbRowset = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
//		 Map<String, Object> velParam = new HashMap<String, Object>();
		
		 try{
			 if(officeCode != null){				 
				 param.put("s_ofc_cd", officeCode);
				 
//				 log.debug("param==========>"+param);
//				 log.debug("velParam==========>"+velParam);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchHandleOfficeLevelWithControlRSQL(), param, null);
				
			 // to Get Office-Level Fromt DBRowSet
			 if ( dbRowset!=null && dbRowset.next() ){
				 officeInfo[0] = dbRowset.getString(1);
				 officeInfo[1] = dbRowset.getString(2);
				 officeInfo[2] = dbRowset.getString(3);
				 officeInfo[3] = dbRowset.getString(4);
			 }
		 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return officeInfo;				
	}

	/**
	 * Office가 TPB Office인지 여부 Y/N 조회 <br>
	 * 
	 * @param String officeCode
	 * @return String searchIsTPBOffice
	 * @throws DAOException
	 */
	public String searchIsTPBOffice(String officeCode) throws DAOException {
		 DBRowSet dbRowset = null;
		 
		 String isTPBOffice = "N";
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
//		 Map<String, Object> velParam = new HashMap<String, Object>();
		
		 try{
			 if(officeCode != null){				 
				 param.put("s_ofc_cd", officeCode);
				 
//				 log.debug("param==========>"+param);
//				 log.debug("velParam==========>"+velParam);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchIsTPBOfficeRSQL(), param, null);
				
			 // to Get Office-Level From DBRowSet
			 if ( dbRowset!=null && dbRowset.next() ){
				 isTPBOffice = dbRowset.getString(1);
			 }
			 dbRowset = null;
		 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return isTPBOffice;				
	}

	/**
	 * 사용자의 조직코드로 레벨정보를 구한다.<br>
	 * 레벨 : H > R >= S > C > T > G <br>
	 * @param String officeCode
	 * @return String searchOfficeTopLevel
	 * @throws DAOException
	 */
	public String searchOfficeTopLevel(String officeCode) throws DAOException {
		 DBRowSet dbRowset = null;
		 // 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		 DBRowSet dRs = null;
		 String officeInfo = "";
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(param != null && velParam != null){				 
				 param.put("s_ofc_cd", officeCode);				 
//				 log.debug("param==========>"+param);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchOfficeTopLevelRSQL(), param, null);

			 // 결과를 DBRowset에 담는다.
//			 dRs = new DBRowSet();
			 // H > R >= S > C > T > G 판별
			 int officeNo = 0;
			 if ( dbRowset!= null ){
				
				 // 권한크기비교
				 int officeNo_tmp = 0;
				 while (dbRowset.next()) {
					 officeInfo = dbRowset.getString(1);
					 if( officeInfo.equals("H")){
						 officeNo_tmp = 6;
						 if( officeNo_tmp > officeNo ){ officeNo = officeNo_tmp; }
					 }else if(officeInfo.equals("R")){
						 officeNo_tmp = 5;
						 if( officeNo_tmp > officeNo ){ officeNo = officeNo_tmp; }
					 }else if(officeInfo.equals("S")){
						 officeNo_tmp = 4;
						 if( officeNo_tmp > officeNo ){ officeNo = officeNo_tmp; }
					 }else if(officeInfo.equals("C")){
						 officeNo_tmp = 3;
						 if( officeNo_tmp > officeNo ){ officeNo = officeNo_tmp; }
					 }else if(officeInfo.equals("T")){
						 officeNo_tmp = 2;
						 if( officeNo_tmp > officeNo ){ officeNo = officeNo_tmp; }
					 }else if(officeInfo.equals("G")){
						 officeNo_tmp = 1;
						 if( officeNo_tmp > officeNo ){ officeNo = officeNo_tmp; }
					 }
				 }
				
				 // 권한의 코드값 돌려줌
				 switch( officeNo ){
				 case 6 : officeInfo = "H"; break;
				 case 5 : officeInfo = "R"; break;
				 case 4 : officeInfo = "S"; break;
				 case 3 : officeInfo = "C"; break;
				 case 2 : officeInfo = "T"; break;
				 case 1 : officeInfo = "G"; break;
				 }
			}
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return officeInfo;
	}
	
	/**
	 * Manual Input & EAC 등록시 입력한 EQ NO. validation check & getting type size <br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet checkEqNo
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet checkEqNo(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;
		 
		 HashMap params = event.getEventParams();
		 String s_eq_no = JSPUtil.getNull((String)params.get("s_eq_no"));
		 String s_eq_knd_cd = JSPUtil.getNull((String)params.get("s_eq_knd_cd"));
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(event != null){
				 param.put("s_eq_no", s_eq_no);
				 param.put("s_eq_knd_cd", s_eq_knd_cd);
				 velParam.put("s_eq_knd_cd", s_eq_knd_cd);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchCheckEqNoRSQL(), param, velParam);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;			
	}
	
	
	/**
	 * Manual Input 등록시 입력한 Currency Code <br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet searchCurrency
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchCurrency(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;

		 HashMap params = event.getEventParams();
		 String s_ofc_cd = JSPUtil.getNull((String)params.get("s_ofc_cd"));
		 String s_rhq_cd = JSPUtil.getNull((String)params.get("s_rhq_cd"));
		 String s_cnt_cd = JSPUtil.getNull((String)params.get("s_cnt_cd"));
		 

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(event != null){
				 param.put("s_ofc_cd", s_ofc_cd);
				 param.put("s_rhq_cd", s_rhq_cd);
				 param.put("s_cnt_cd", s_cnt_cd);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchCurrencyRSQL(), param, velParam);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;			
	}
	
	
	/**
	 * Manual Input 등록시 입력한 Currency Code <br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet searchCurrency
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchInvoiceCurrency(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;

		 HashMap params = event.getEventParams();
		 String s_ofc_cd = JSPUtil.getNull((String)params.get("s_ofc_cd"));
		 String s_rhq_cd = JSPUtil.getNull((String)params.get("s_rhq_cd"));
		 String s_cnt_cd = JSPUtil.getNull((String)params.get("s_cnt_cd"));
		 

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(event != null){
				 param.put("s_ofc_cd", s_ofc_cd);
				 param.put("s_rhq_cd", s_rhq_cd);
				 param.put("s_cnt_cd", s_cnt_cd);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchInvoiceCurrencyRSQL(), param, velParam);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;			
	}
	
	
	/**
	 * Manual Input 등록시 입력한 Currency Code <br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet searchCurrency
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchEACCurrency(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;

		 HashMap params = event.getEventParams();
		 String s_ofc_cd = JSPUtil.getNull((String)params.get("s_ofc_cd"));
		 String s_rhq_cd = JSPUtil.getNull((String)params.get("s_rhq_cd"));
		 String s_cnt_cd = JSPUtil.getNull((String)params.get("s_cnt_cd"));
		 

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(event != null){
				 param.put("s_ofc_cd", s_ofc_cd);
				 param.put("s_rhq_cd", s_rhq_cd);
				 param.put("s_cnt_cd", s_cnt_cd);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchEACCurrencyRSQL(), param, velParam);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;			
	}
	
	
	/**
	 * Manual Input & EAC 등록시 입력한 EQ NO. validation check & getting type size <br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet checkTrdParty
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet checkTrdParty(CommonCodeEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		
		HashMap params = event.getEventParams();
		String s_trd_party_val = JSPUtil.getNull((String)params.get("s_trd_party_val"));
		String s_vndr_cust_div_cd = JSPUtil.getNull((String)params.get("s_vndr_cust_div_cd"));
//		String s_n3pty_bil_tp_cd = JSPUtil.getNull((String)params.get("s_n3pty_bil_tp_cd"));

		// 숫자형이 되어야할 값이 아닐 경우 s_vndr_cust_div_cd를 ""으로 바꾸어 무효화 시킨다.  
		String tmpNumberStr = "";
		if ( s_vndr_cust_div_cd.equals("V") ) {
			tmpNumberStr = s_trd_party_val;
		} else if ( s_vndr_cust_div_cd.equals("C") ) {
			if ( s_trd_party_val.length() >= 2 ){
				tmpNumberStr = s_trd_party_val.substring(2);
			} else {
				s_vndr_cust_div_cd = "";
			}
		}
		if ( tmpNumberStr.length() > 0 ){
			//2010.09.14 변종건 [CHM-201005591-01]	 [TPB] 소스품질 결함 사항 정리
		    if(!CheckUtils.isInOnlyNumber(tmpNumberStr)){
		        s_vndr_cust_div_cd = "";
		        s_trd_party_val = "";     
		    }
		}
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 
		try{
			if(param != null){				 
				param.put("s_trd_party_val", s_trd_party_val);
				velParam.put("s_vndr_cust_div_cd", s_vndr_cust_div_cd);
				 
//				log.debug("param==========>"+param);
//				log.debug("velParam==========>"+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchCheckTrdPartyRSQL(), param, velParam);
		 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * Manual Input & EAC 등록시 입력한 EQ NO. validation check & getting type size <br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet checkEqDigit
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet checkEqDigit(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;
		 
		 HashMap params = event.getEventParams();
		 String s_eq_no = JSPUtil.getNull((String)params.get("s_eq_no"));
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
//		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(event != null){
				 param.put("s_eq_no", s_eq_no);
				 
//				 log.debug("param==========>"+param);
//				 log.debug("velParam==========>"+velParam);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchCheckEqDigitRSQL(), param, null);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;	
	}
	
	
	/**
	 * Office Code 변경시 Country Code Get <br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String getMDMCntCd(String ofcCd) throws DAOException {
		 DBRowSet dbRowset = null;
		 
		 Map<String, Object> param = new HashMap<String, Object>();
//		 Map<String, Object> velparam = new HashMap<String, Object>();

		 String cntCd = null;
		 
		 try{
			 if ( ofcCd != null && !"".equals(ofcCd) ) {
				 param.put("ofc_cd", ofcCd);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchGetMDMCntCdRSQL(), param, null);
			 
			 if ( dbRowset.next() ){
				 cntCd = dbRowset.getString("cnt_cd");
			 }
			 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return cntCd;
	}
	
	
	/**
	 * TPB Billing Case Code 등록시 입력한 Code validation check <br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet checkEqDigit
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet checkBillingCaseCode(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;
		 
		 HashMap params = event.getEventParams();
		 String s_n3pty_bil_tp_cd = JSPUtil.getNull((String)params.get("s_n3pty_bil_tp_cd"));
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
//		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(event != null){
				 param.put("s_n3pty_bil_tp_cd", s_n3pty_bil_tp_cd);
				 
//				 log.debug("param==========>"+param);
//				 log.debug("velParam==========>"+velParam);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchCheckBillingCaseCodeRSQL(), param, null);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;	
	}
	
	
	/**
	 * S/P Vedor Code validation check <br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet checkEqDigit
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet checkVendorCode(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;
		 
		 HashMap params = event.getEventParams();
		 String s_src_vndr_no = JSPUtil.getNull((String)params.get("s_src_vndr_no"));
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
//		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(event != null){
				 param.put("s_src_vndr_no", s_src_vndr_no);
				 
//				 log.debug("param==========>"+param);
//				 log.debug("velParam==========>"+velParam);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchCheckVendorRSQL(), param, null);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;	
	}
	
	
	/**
	 * S/P Vedor Code validation check <br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet checkEqDigit
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet checkRegOffice(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;
		 
		 HashMap params = event.getEventParams();
		 String s_ofc_cd_reg = JSPUtil.getNull((String)params.get("s_ofc_cd_reg"));
		 String s_n3pty_ofc_tp_cd = JSPUtil.getNull((String)params.get("s_n3pty_ofc_tp_cd"));
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
//		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(event != null){
				 param.put("s_ofc_cd_reg", s_ofc_cd_reg);
				 param.put("s_n3pty_ofc_tp_cd", s_n3pty_ofc_tp_cd);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchCheckRegOfficeRSQL(), param, null);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;	
	}
	
	
	/**
	 * 특정 RHQ Office 하위 Control Office 목록을 가져온다. <br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet searchControlOfficeList
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchControlOfficeList(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;
		 
		 HashMap params = event.getEventParams();
		 String s_if_rhq_cd = JSPUtil.getNull((String)params.get("s_if_rhq_cd"));
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
//		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(event != null){
				 param.put("s_if_rhq_cd", s_if_rhq_cd);
				 
//				 log.debug("param==========>"+param);
//				 log.debug("velParam==========>"+velParam);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchControlOfficeListRSQL(), param, null);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;	
	}
	/**
	 * 특정 RHQ Office 하위 Control Office 목록을 가져온다. <br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet searchTPBOfficeList
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchTPBOfficeList(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;
		 
		 HashMap params = event.getEventParams();
		 //String s_if_rhq_cd = JSPUtil.getNull((String)params.get("s_if_rhq_cd"));
		 String s_if_ctrl_cd = JSPUtil.getNull((String)params.get("s_if_ctrl_cd"));
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
//		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(event != null){
				 param.put("s_if_ctrl_cd", s_if_ctrl_cd);
				 
//				 log.debug("param==========>"+param);
//				 log.debug("velParam==========>"+velParam);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchTPBOfficeListRSQL(), param, null);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;	
	}
	
	
	/**
	 * 특정 RHQ Office 하위 Jo Control Office 목록을 가져온다. <br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet searchTPBOfficeList
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchJoTPBOfficeList(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;
		 
		 HashMap params = event.getEventParams();
		 //String s_if_rhq_cd = JSPUtil.getNull((String)params.get("s_if_rhq_cd"));
		 String s_if_ctrl_cd = JSPUtil.getNull((String)params.get("s_if_ctrl_cd"));
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
//		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(event != null){
				 param.put("s_if_ctrl_cd", s_if_ctrl_cd);
				 
//				 log.debug("param==========>"+param);
//				 log.debug("velParam==========>"+velParam);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchJoTPBOfficeListRSQL(), param, null);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;	
	}
	/**
	 * 로그인한 TPB Office Control Office 를 가져온다.  <br>
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet searchCtrlOffice
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchCtrlOffice(CommonCodeEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		
		HashMap params = event.getEventParams();
		String s_office_level = JSPUtil.getNull((String)params.get("s_office_level"));
		String s_ofc_cd_for_rhq = JSPUtil.getNull((String)params.get("s_ofc_cd_for_rhq"));
		String s_if_rhq_cd = JSPUtil.getNull((String)params.get("s_if_rhq_cd"));
		
		if ( s_ofc_cd_for_rhq.length() == 0){
			s_ofc_cd_for_rhq = s_if_rhq_cd; 
		}
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(event != null){
				param.put("s_ofc_cd_for_rhq", s_ofc_cd_for_rhq);
				param.put("s_if_rhq_cd", s_if_rhq_cd);
				
				velParam.put("s_office_level", s_office_level);
				 
//				log.debug("param==========>"+param);
//				log.debug("velParam==========>"+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchCtrlOfficeRSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;		
	}
	/**
	 * 입력받은 VVD가 유효한지 체크한다.
	 * 0 : invalid, 1이상 : valid 
	 * 2009-04-30 O Wan-Ki       1.7 N200904160080, VVD Check Method 추가.
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet searchCheckVVD
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchCheckVVD(CommonCodeEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		
		HashMap params = event.getEventParams();
		String s_vvd = JSPUtil.getNull((String)params.get("s_vvd"));
		String s_if_ofc_cd = JSPUtil.getNull((String)params.get("otherObjs"));
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(event != null && s_vvd.length() == 9){
				param.put("s_vsl_cd", s_vvd.substring(0, 4));
				param.put("s_skd_voy_no", s_vvd.substring(4, 8));
				param.put("s_skd_dir_cd", s_vvd.substring(8, 9));
				param.put("s_if_ofc_cd", s_if_ofc_cd);
			}
			else
			{
				param.put("s_vsl_cd", "");
				param.put("s_skd_voy_no", "");
				param.put("s_skd_dir_cd", "");
				param.put("s_if_ofc_cd", s_if_ofc_cd);
			}
//			log.debug("param==========>"+param);
//			log.debug("velParam==========>"+velParam);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchCheckVVDRSQL(), param, null);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;		
	}
		
	/**
	 * 국가별/등급별 점소를 반환한다.
	 * IN : India, KR : korea / R : RHQ Office, C : Control Office, T : TPB Office
	 * 2009-06-01 O Wan-Ki       1.8 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발]  
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet searchHierarchyOfficeByCountry
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchHierarchyOfficeByCountry(CommonCodeEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		
		HashMap params = event.getEventParams();
		String s_ofc_grd = JSPUtil.getNull((String)params.get("s_ofc_grd"));
		String s_cnt_cd = JSPUtil.getNull((String)params.get("s_cnt_cd"));
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(event != null){
				param.put("s_ofc_grd", s_ofc_grd);
				param.put("s_cnt_cd", s_cnt_cd);
				 
//				log.debug("param==========>"+param);
//				log.debug("velParam==========>"+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchHierarchyOfficeByCountryRSQL(), param, null);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;		
	}
	/**
	 * TPB Seq를 구한다. 
	 * 
	 * @return String searchTPBSeq()
	 * @throws DAOException
	 */
	public String searchTPBSeq() throws DAOException {
		String tpbSeq = "";
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet dbRowset = null;
		
	    Map<String, Object> param = new HashMap<String, Object>();
	    //velocity parameter
	    Map<String, Object> velParam = new HashMap<String, Object>();
	 
	    try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchTPBSeqRSQL(), param, velParam);
			// to Get Office-Level From DBRowSet
			if ( dbRowset!=null && dbRowset.next() ){
				tpbSeq = dbRowset.getString(1);
			}
//			log.debug("tpbSeq=======>"+tpbSeq);
			dbRowset = null;
	    }catch(SQLException se){
			log.error(se.getMessage(),se);
		 	throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return tpbSeq;
	}
	/**
	 * TPB Billing Case 의 횡적제공을 위한 함수
	 * param1 : div(string) - 구분문자
	 * param2 : ord(1 or 0) - 정렬제공여부
	 * param3 : method(string) - getAllBillingCase : 모든 Billing Case 검색
	 * param4 : rec_obj(string) - the object, will be received 
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet getAllBillingCase
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet getAllBillingCase(CommonCodeEvent event) throws DAOException {
		DBRowSet dbRowset = null;
		
		HashMap params = event.getEventParams();
		String ord = JSPUtil.getNull((String)params.get("ord"));
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(ord != null){
				velParam.put("ord", ord);
				 
//				log.debug("param==========>"+param);
//				log.debug("velParam==========>"+velParam);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchGetAllBillingCaseRSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;		
	}
	/**
	 * TPB Billing Case 의 횡적제공을 위한 함수 (TES)
	 * 
	 * @param CommonCodeEvent event
	 * @return DBRowSet getTesBillingCase
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet getTesBillingCase(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;
		 
		 HashMap params = event.getEventParams();
		 String ord = JSPUtil.getNull((String)params.get("ord"));

		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(ord != null){
				 velParam.put("ord", ord);
				 
//				 log.debug("param==========>"+param);
//				 log.debug("velParam==========>"+velParam);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchGetTesBillingCaseRSQL(), param, velParam);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;
	}
	
	/**
	 * ROC Office Code 조회.<br>
	 * @param String n3ptyCd
	 * @return DBRowSet
	 * @throws EventException
	 */
	public DBRowSet searchCheckTPBROCOffice(String n3ptyCd) throws DAOException {
		DBRowSet dbRowset = null; 
		Map<String, Object> param = new HashMap<String, Object>();//parameter	
			try {
				if(n3ptyCd != null){
					param.put("n3pty_no"    ,n3ptyCd);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchCheckTPBROCOfficeRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dbRowset;
	}
		 
	/**
	 * Office Code 조회.<br>
	 * @param CommonCodeEvent event
	 * @return DBRowSet
	 * @throws EventException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchTPBOfficeListTypeT(CommonCodeEvent event) throws DAOException {
		 DBRowSet dbRowset = null;
		 
		 HashMap params = event.getEventParams();
		 //String s_if_rhq_cd = JSPUtil.getNull((String)params.get("s_if_rhq_cd"));
		 String s_if_ctrl_cd = JSPUtil.getNull((String)params.get("s_if_ctrl_cd"));
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
//		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(event != null){
				 param.put("s_if_ctrl_cd", s_if_ctrl_cd);
				 
//				 log.debug("param==========>"+param);
//				 log.debug("velParam==========>"+velParam);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchTPBOfficeListTypeTRSQL(), param, null);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;	
	}

}
