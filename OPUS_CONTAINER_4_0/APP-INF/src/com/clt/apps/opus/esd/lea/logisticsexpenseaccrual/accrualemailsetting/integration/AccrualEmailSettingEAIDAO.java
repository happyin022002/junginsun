/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AccrualEmailSettingEAIDAO.java
*@FileTitle : Accrual Mail Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.19
*@LastModifier : 전재홍
*@LastVersion : 1.0
* 2010.02.19 전재홍
* 1.0 Creation
=========================================================*/
//package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.integration;
//
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.StringTokenizer;
//
//import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.basic.AccrualEmailSettingBCImpl;
//import com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.vo.SearchParameterAccrualEmailSettingVO;
//import com.clt.framework.component.javamail.Mail;
//import com.clt.framework.support.layer.integration.EAIDAOSupport;
//import com.clt.framework.component.javamail.MailerAppException;
//
//
//import com.clt.framework.component.message.ErrorHandler;
//import com.clt.framework.component.rowset.DBRowSet;
//import com.clt.framework.core.layer.integration.DAOException;
//import com.clt.framework.support.db.ISQLTemplate;
//import com.clt.framework.support.db.SQLExecuter;
//
///**
// * ALPS AccrualEmailSettingEAIDAO <br>
// * - ALPS-LogisticsExpenseAccrual system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
// * 
// * @author Jeon Jae Hong
// * @see AccrualEmailSettingBCImpl 참조
// * @since J2EE 1.6
// */
//public class AccrualEmailSettingEAIDAO extends EAIDAOSupport{
//	
//	/**
//	 * Constructor
//	 */
//	public AccrualEmailSettingEAIDAO(){
//		
//	}
//
//    public AccrualEmailSettingEAIDAO(String string) {
//   
//	}
//    
//    /**
//	 * 송신리스트를 참조하여 Email 을 송신한다..<br>
//	 * @param SearchParameterAccrualEmailSettingVO searchParameterAccrualEmailSettingVO
//	 * @return 
//	 * @throws DAOException
//	 */
//	 @SuppressWarnings("unchecked")
//	public void sendTestAccrualEmailSetting(SearchParameterAccrualEmailSettingVO searchParameterAccrualEmailSettingVO) throws DAOException {
//		if(log.isDebugEnabled())log.debug("[AccrualEmailSettingDBDAO searchParameterAccrualEmailSetting	]");
//		// Connection Interface
//		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
//
//		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		String str_fm_eml   = "";
//		String str_to_eml   = "";
//		String str_cc_eml   = "";
//		String subject_nm   = "";
//		String contents		= "";
//		
//		try {
//			
//			DBRowSet dbRowset = null;
//			
//			//query parameter
//			Map<String, Object> param = new HashMap<String, Object>();
//			//velocity parameter
//			Map<String, Object> velParam = new HashMap<String, Object>();
//
//		
//			try{
//				if(searchParameterAccrualEmailSettingVO != null){
//					Map<String, String> mapVO = searchParameterAccrualEmailSettingVO .getColumnValues();
//				
//					param.putAll(mapVO);
//					velParam.putAll(mapVO);
//				}
//				
//				dbRowset = new SQLExecuter("LEA_HJSLEA").executeQuery((ISQLTemplate)new AccrualEmailSettingDBDAOSearchParameterAccrualEmailSettingRSQL(), param, velParam);
////			}catch(SQLException se){
////				log.error(se.getMessage(),se);
////				throw new DAOException(new ErrorHandler(se).getMessage());
//			}catch(Exception ex){
//				log.error(ex.getMessage(),ex);
//				throw new DAOException(new ErrorHandler(ex).getMessage());
//			}
//			
//			if(log.isDebugEnabled())log.debug("==========AccrualEmailSettingDBDAO    sendTestAccrualEmailSetting() dbRowset.getRowCount()============"+dbRowset.getRowCount()); 
//			if(dbRowset.getRowCount()>0){
//				while (dbRowset.next()){
//					if(log.isDebugEnabled())log.debug("==========AccrualEmailSettingDBDAO    sendTestAccrualEmailSetting() while dbRowset.next()  ========="); 
//						str_fm_eml 	= dbRowset.getString("FM_EML");
//						str_to_eml 	= dbRowset.getString("TO_EML");
//						str_cc_eml 	= dbRowset.getString("CC_EML");
//						subject_nm 	= dbRowset.getString("SUBJ_NM");
//						contents   	= dbRowset.getString("CTNT");
//				}
//			}else{ //Setting된 데이터가 없으면 throw Exception처리
//				throw new DAOException(new ErrorHandler("LEA00001").getMessage());
//			}
//			 /* 저장한후 Send mail 하므로 model이 필요없게됨. 
//			  * else{
//				str_fm_eml 	= (param_map.get("frm_mail_div").toString().equals("B")?model.getBat_fm_eml():model.getIf_fm_eml());
//				str_to_eml 	= (param_map.get("frm_mail_div").toString().equals("B")?model.getBat_to_eml():model.getIf_to_eml());
//				str_cc_eml 	= (param_map.get("frm_mail_div").toString().equals("B")?model.getBat_cc_eml():model.getIf_cc_eml());
//				subject_nm  = (param_map.get("frm_mail_div").toString().equals("B")?model.getBat_subj_nm():model.getIf_subj_nm());
//				contents    = (param_map.get("frm_mail_div").toString().equals("B")?model.getBat_ctnt():model.getIf_ctnt());
//			 }*/
////	    	 if(log.isDebugEnabled())log.debug("==========AccrualEmailSettingDBDAO    sendTestAccrualEmailSetting() frm_mail_div============"+param_map.get("frm_mail_div").toString()); 
////	    	 if(log.isDebugEnabled())log.debug("==========AccrualEmailSettingDBDAO    sendTestAccrualEmailSetting() subject_nm============"+subject_nm); 
////	    	 if(log.isDebugEnabled())log.debug("==========AccrualEmailSettingDBDAO    sendTestAccrualEmailSetting() contents============"+contents); 
//		     StringTokenizer st1 = new StringTokenizer(str_to_eml,";");
//		     StringTokenizer st2 = new StringTokenizer(str_cc_eml,";");
//	    	 if(log.isDebugEnabled())log.debug("==========AccrualEmailSettingDBDAO    sendTestAccrualEmailSetting() st1.countTokens()============"+st1.countTokens()); 
//	    	 if(log.isDebugEnabled())log.debug("==========AccrualEmailSettingDBDAO    sendTestAccrualEmailSetting() st2.countTokens()============"+st2.countTokens()); 
//		     String[] to_eml  = new String[st1.countTokens()+st2.countTokens()];
//		     int i = 0;
//		     while (st1.hasMoreTokens()) {
//		    	 to_eml[i++] = st1.nextToken();
//		     }
//		     while (st2.hasMoreTokens()) {
//		    	 to_eml[i++] = st2.nextToken();
//		     }
//		     Mail mailer = new Mail();
//		     mailer.setFrom(str_fm_eml);
//		     mailer.setRecipients(to_eml);
//		     mailer.setSubject(subject_nm);
//		     mailer.setTextContent(contents);
//		     mailer.send();
////		} catch (SQLException se) {
////			log.error(se.getMessage(), se);
////			throw new DAOException(new ErrorHandler("LEA00009").getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw new DAOException(new ErrorHandler("LEA00009").getMessage());
//		} catch (MailerAppException me) {
//			log.error("err "+me.toString(),me);
//			throw new DAOException(new ErrorHandler("LEA00009").getMessage());
//		}catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(new ErrorHandler("LEA00009").getMessage());
//			}
//		}
//	 
//}


package com.clt.apps.opus.esd.lea.logisticsexpenseaccrual.accrualemailsetting.integration;

import java.util.List;

import com.clt.framework.component.javamail.Mail;
import com.clt.framework.support.layer.integration.EAIDAOSupport;

/**
* ALPS AccrualEmailSettingEAIDAO <br>
* - ALPS-LogisticsExpenseAccrual system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
* 
* @author Jeon Jae Hong
* @see AccrualEmailSettingBCImpl 참조
* @since J2EE 1.6
*/
public class AccrualEmailSettingEAIDAO extends EAIDAOSupport{
	

    /** 
     * Mail 전송 기능
     * @param String str_fm_eml
     * @param String[] to_eml
     * @param String subject_nm
     * @param String contents
     * @throws Exception 
     */
    public void sendEml(String str_fm_eml, String[] to_eml, String subject_nm, String contents) throws Exception 
    {
    	Mail mailers = new Mail();
		mailers.setSubject(subject_nm);
		mailers.setFrom(str_fm_eml);
		mailers.setRecipients(to_eml);
	    mailers.setTextContent( contents );
	    log.debug("Mail send start");
	    mailers.send();
	    log.debug("Mail send END");
	 
    }
}

