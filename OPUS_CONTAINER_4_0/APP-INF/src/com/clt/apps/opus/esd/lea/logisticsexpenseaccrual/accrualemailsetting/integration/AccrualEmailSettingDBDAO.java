/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualEmailSettingDBDAO.java
*@FileTitle : Accrual Mail Setting
*Open Issues :
*Change history :2007.01 Park Yeon Jin 최초생성
*@LastModifyDate : 2009.09.18
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2009.09.18 전재홍
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.basic.AccrualEmailSettingBC;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.basic.AccrualEmailSettingBCImpl;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.integration.AccrualEmailSettingEAIDAO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo.SearchAccrualEmailSettingVO;
import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo.SearchParameterAccrualEmailSettingVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.LeaEmlSetVO;



/**
 * ALPS AccrualEmailSettingDBDAO <br>
 * - ALPS-LogisticsExpenseAccrual system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jeon Jae Hong
 * @see AccrualEmailSettingBCImpl 참조
 * @since J2EE 1.6
 */
public class AccrualEmailSettingDBDAO extends DBDAOSupport {
	
	/**
	 * Email 송신을 위한  Parameter Setting 항목 조회<br>
	 * 
	 * @param SearchParameterAccrualEmailSettingVO searchParameterAccrualEmailSettingVO
	 * @return List<SearchParameterAccrualEmailSettingVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchParameterAccrualEmailSettingVO> searchParameterAccrualEmailSetting(SearchParameterAccrualEmailSettingVO searchParameterAccrualEmailSettingVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchParameterAccrualEmailSettingVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchParameterAccrualEmailSettingVO != null){
				Map<String, String> mapVO = searchParameterAccrualEmailSettingVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualEmailSettingDBDAOSearchParameterAccrualEmailSettingRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchParameterAccrualEmailSettingVO .class);
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
	 * Email 송신을 위한 Setting 항목조회<br>
	 * 
	 * @param SearchAccrualEmailSettingVO searchAccrualEmailSettingVO
	 * @return List<SearchAccrualEmailSettingVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchAccrualEmailSettingVO> searchAccrualEmailSetting(SearchAccrualEmailSettingVO searchAccrualEmailSettingVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchAccrualEmailSettingVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchAccrualEmailSettingVO != null){
				Map<String, String> mapVO = searchAccrualEmailSettingVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualEmailSettingDBDAOSearchAccrualEmailSettingRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAccrualEmailSettingVO .class);
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
	 * Email 송신을 위한 Setting 항목 변경
	 * 
	 * @param List<LeaEmlSetVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyModifyAccrualEmailSettingS(List<LeaEmlSetVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("LEA_HJSLEA");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AccrualEmailSettingDBDAOModifyAccrualEmailSettingCSQL(), updModels,null);
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
	 * 송신리스트를 참조하여 Email 을 송신한다..<br>
	 * @param SearchParameterAccrualEmailSettingVO searchParameterAccrualEmailSettingVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void sendTestAccrualEmailSetting(SearchParameterAccrualEmailSettingVO searchParameterAccrualEmailSettingVO) throws DAOException {
		if(log.isDebugEnabled())log.debug("[AccrualEmailSettingDBDAO searchParameterAccrualEmailSetting	]");
		
	    AccrualEmailSettingBC command = new AccrualEmailSettingBCImpl();
	     
		// Connection Interface
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체

		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
		String str_fm_eml   = "";
		String str_to_eml   = "";
		String str_cc_eml   = "";
		String subject_nm   = "";
		String contents		= "";
		
		try {
			
			DBRowSet dbRowset = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			if(searchParameterAccrualEmailSettingVO != null){
				Map<String, String> mapVO = searchParameterAccrualEmailSettingVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualEmailSettingDBDAOSearchParameterAccrualEmailSettingRSQL(), param, velParam);
		
			if(log.isDebugEnabled())log.debug("==========AccrualEmailSettingDBDAO    sendTestAccrualEmailSetting() dbRowset.getRowCount()============"+dbRowset.getRowCount()); 
			if(dbRowset.getRowCount()>0){
				while (dbRowset.next()){
					if(log.isDebugEnabled())log.debug("==========AccrualEmailSettingDBDAO    sendTestAccrualEmailSetting() while dbRowset.next()  ========="); 
						str_fm_eml 	= dbRowset.getString("FM_EML");
						str_to_eml 	= dbRowset.getString("TO_EML");
						str_cc_eml 	= dbRowset.getString("CC_EML");
						subject_nm 	= dbRowset.getString("SUBJ_NM");
						contents   	= dbRowset.getString("CTNT");
				}
			}else{ //Setting된 데이터가 없으면 throw Exception처리
				throw new DAOException(new ErrorHandler("LEA00001").getMessage());
			}
			 /* 저장한후 Send mail 하므로 model이 필요없게됨. 
			  * else{
				str_fm_eml 	= (param_map.get("frm_mail_div").toString().equals("B")?model.getBat_fm_eml():model.getIf_fm_eml());
				str_to_eml 	= (param_map.get("frm_mail_div").toString().equals("B")?model.getBat_to_eml():model.getIf_to_eml());
				str_cc_eml 	= (param_map.get("frm_mail_div").toString().equals("B")?model.getBat_cc_eml():model.getIf_cc_eml());
				subject_nm  = (param_map.get("frm_mail_div").toString().equals("B")?model.getBat_subj_nm():model.getIf_subj_nm());
				contents    = (param_map.get("frm_mail_div").toString().equals("B")?model.getBat_ctnt():model.getIf_ctnt());
			 }*/
//	    	 if(log.isDebugEnabled())log.debug("==========AccrualEmailSettingDBDAO    sendTestAccrualEmailSetting() frm_mail_div============"+param_map.get("frm_mail_div").toString()); 
//	    	 if(log.isDebugEnabled())log.debug("==========AccrualEmailSettingDBDAO    sendTestAccrualEmailSetting() subject_nm============"+subject_nm); 
//	    	 if(log.isDebugEnabled())log.debug("==========AccrualEmailSettingDBDAO    sendTestAccrualEmailSetting() contents============"+contents); 
		     StringTokenizer st1 = new StringTokenizer(str_to_eml,";");
		     StringTokenizer st2 = new StringTokenizer(str_cc_eml,";");
	    	 if(log.isDebugEnabled())log.debug("==========AccrualEmailSettingDBDAO    sendTestAccrualEmailSetting() st1.countTokens()============"+st1.countTokens()); 
	    	 if(log.isDebugEnabled())log.debug("==========AccrualEmailSettingDBDAO    sendTestAccrualEmailSetting() st2.countTokens()============"+st2.countTokens()); 
		     String[] to_eml  = new String[st1.countTokens()+st2.countTokens()];
		     int i = 0;
		     while (st1.hasMoreTokens()) {
		    	 to_eml[i++] = st1.nextToken();
		     }
		     while (st2.hasMoreTokens()) {
		    	 to_eml[i++] = st2.nextToken();
		     }
		         
//		     Mail mailer = new Mail();
//		     mailer.setFrom(str_fm_eml);
//		     mailer.setRecipients(to_eml);
//		     mailer.setSubject(subject_nm);
//		     mailer.setTextContent(contents);
//		     mailer.send();

		     command.sendEml(str_fm_eml, to_eml, subject_nm, contents);
		     
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler("LEA00009").getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new DAOException(new ErrorHandler("LEA00009").getMessage());
		
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler("LEA00009").getMessage());
			}
		}
	}	
