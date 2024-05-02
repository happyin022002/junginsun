/*=========================================================
 *Copyright(c) 2008 CyberLogitec
 *@FileName : ScheduleUtil.java
 *@FileTitle : ScheduleUtil
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.30
 *@LastModifier : 정인선
 *@LastVersion : 1.0
 * 2009.06.30 정인선
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.common.ibsheet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.eas.common.popup.integration.CommonPopUpManageDBDAOSearchServiceOfficeCodeManageRSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * 
 * @author 정인선
 * @see IbSheetDBDAO
 * @since J2EE 1.4
 */
public class IbSheetDBDAO extends DBDAOSupport {
	
	/**
	 * IB시트 세팅 정보를 조회<br>
	 * @param usr_id
	 * @param scrn_id
	 * @param sh_id
	 * @return String
	 * @throws DAOException
	 */
	public String searchIbSetting(String usr_id, String scrn_id, String sh_id) throws DAOException {
		 
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		String sRtn="";
      
       
		
        try {                                                                    
           
            
            param.put("usr_id", usr_id);
            param.put("scrn_id", scrn_id);
            param.put("sh_id", sh_id);
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new IbSheetDBDAOsearchIbSettingRSQL(), param, param);
			
  			
  			if(dbRowset.next()) {
  				sRtn = dbRowset.getString("hdr_desc");
  				sRtn = sRtn + "||" + dbRowset.getString("hdr_len_ctnt");
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
        return sRtn;
	}
	
	/**
	 * IB시트 세팅 정보를 조회<br>
	 * @param usr_id
	 * @param scrn_id
	 * @param sh_id
	 * @return boolean DB 처리 결과
	 * @throws DAOException
	 */
	public boolean chkExist(String usr_id, String scrn_id, String sh_id) throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
        
        boolean bRtn = false;
        
     
		
        try {                                                                    
          
        	 param.put("usr_id", usr_id);
             param.put("scrn_id", scrn_id);
             param.put("sh_id", sh_id);
             
             dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new IbSheetDBDAOchkExistRSQL(), param, param);
           
   			
   			if(dbRowset.next()) {
   				
   				bRtn = true;
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
        return bRtn;
	}
	
	/**
	 * IB시트 세팅 정보 저장<br>
	 * @param usr_id
	 * @param scrn_id
	 * @param sh_id
	 * @param hdr_desc
	 * @param hdr_len_ctnt
	 * @throws DAOException
	 */
	public void saveIbSetting(String usr_id, String scrn_id, String sh_id, String hdr_desc,String  hdr_len_ctnt) throws DAOException {
		
		int insCnt = 0;
		
		Map<String, Object> param = new HashMap<String, Object>();
		
        try {
          
        	 param.put("usr_id", usr_id);
             param.put("scrn_id", scrn_id);
             param.put("sh_id", sh_id);
             param.put("hdr_desc", hdr_desc);
     		//log.debug("hdr_desc======="+ hdr_desc);
     		log.debug("hdr_len_ctnt======="+ hdr_len_ctnt);
     		param.put("hdr_len_ctnt", hdr_len_ctnt);

            insCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new IBSheetDBDAOsaveIbSettingCSQL(), param, param);
            
    		
    	} catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        } 
    	
	}
	
	/**
	 * IB시트 세팅 정보 Update<br>
	 * @param usr_id
	 * @param scrn_id
	 * @param sh_id
	 * @param hdr_desc
	 * @param hdr_len_ctnt
	 * @throws DAOException
	 */
	public void updIbSetting(String usr_id, String scrn_id, String sh_id, String hdr_desc, String  hdr_len_ctnt) throws DAOException {
	
		int inuCnt = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		
       
       

        try {
        	 param.put("usr_id", usr_id);
             param.put("scrn_id", scrn_id);
             param.put("sh_id", sh_id);
             param.put("hdr_desc", hdr_desc);
             param.put("hdr_len_ctnt", hdr_len_ctnt);
            
             inuCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new IbSheetDBDAOupdIbSettingUSQL(), param, param);
    		
    	} catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        } 
    	
	}
	
	/**
	 * IB시트 세팅 정보 삭제<br>
	 * @param usr_id
	 * @param scrn_id
	 * @param sh_id
	 * @throws DAOException
	 */
	public void delIbSetting(String usr_id, String scrn_id, String sh_id) throws DAOException {
		
		int inuCnt = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		
       

        try {
          
        	 param.put("usr_id", usr_id);
             param.put("scrn_id", scrn_id);
             param.put("sh_id", sh_id);
           
             
             inuCnt = new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new IbSheetDBDAOdelIbSettingDSQL(), param, param);
    		
    	} catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        
        }
	}
}
