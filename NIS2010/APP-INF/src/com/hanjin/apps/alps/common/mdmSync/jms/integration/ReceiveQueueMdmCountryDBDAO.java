/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueMDM_COUNTRYDBDAO.java
 *@FileTitle : ENIS Interface 연동 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-02-26
 *@LastModifier : Kim Jung-Jae
 *@LastVersion : 1.0
 * 2006-12-21 Kim Jung-Jae
 * 1.0 최초 생성
 =========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmCountryVO;

/**
 * ENIS-MDM JMS Consuming에 따른 JMS Inbound Class<br> -
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Kim Jung-Jae
 * @see 
 * @since J2EE 1.4
 */
public class ReceiveQueueMdmCountryDBDAO extends DBDAOSupport{

	/**
	 * 추가
	 * @param model
	 * @return
	 * @throws DAOException
	 */
	public int addMdmCountryInsert(MdmCountryVO model) throws DAOException {
		int insCnt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				velParam.putAll( mapVO );	 
			}					
			
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueMdmCountryDBDAOAddMdmCountryInsertCSQL(),  param, velParam);		
			
//			insertQuery = "/* " + this.getClass().getName() + " - addMDMACCOUNT() */						" + "\n"	
//			 + " INSERT INTO mdm_country (                                             		   			".trim() + "\n"
//			 + "	cnt_cd		   	   ,cnt_nm             ,sconti_cd          ,curr_cd			   ,	".trim() + "\n"
//			 + "	frgn_vat_flg       ,zn_div_bsel_cd     ,cre_usr_id         ,cre_dt             ,	".trim() + "\n"
//			 + "	upd_usr_id         ,upd_dt             ,delt_flg           ,eai_evnt_dt        		".trim() + "\n"
//			 + " )                                                                             			".trim() + "\n"
//			 + " VALUES  (														                        ".trim() + "\n"
//			 + "	?,?,?,?,?,?,?,to_date(?,'yyyymmddhh24miss'),?,to_date(?,'yyyymmddhh24miss'),		".trim() + "\n"
//			 + "	?,to_date(?,'yyyymmddhh24miss')														".trim() + "\n"
//			 + " )																			   			".trim() + "\n"
//		;
			
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
		
		return insCnt;
	}
	
	/**
	 * 수정
	 * @param model
	 * @return
	 * @throws DAOException
	 */
	public int addMdmCountryUpdate(MdmCountryVO model) throws DAOException {
		
		int insCnt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				velParam.putAll( mapVO );	 
			}					
			
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueMdmCountryDBDAOAddMdmCountryUpdateUSQL(),  param, velParam);		
			
//			updateQuery = "/* " + this.getClass().getName() + " - modifyMDMCOUNTRY() */				" + "\n"	
//			 + " UPDATE mdm_country SET                             							".trim() + "\n"
//			 + "	cnt_nm             = ?,sconti_cd          = ?,curr_cd            = ?,		".trim() + "\n"	
//			 + "	frgn_vat_flg       = ?,zn_div_bsel_cd     = ?,cre_usr_id         = ?,       ".trim() + "\n"	
//			 + "	cre_dt             = to_date(?,'yyyymmddhh24miss'),                         ".trim() + "\n"	
//			 + "	upd_usr_id         = ?,upd_dt             = to_date(?,'yyyymmddhh24miss'),  ".trim() + "\n"	
//			 + "	delt_flg           = ?,eai_evnt_dt        = to_date(?,'yyyymmddhh24miss')   ".trim() + "\n"	
//			 + " WHERE 	cnt_cd = ?                           									".trim() + "\n"
//			 + " AND 	eai_evnt_dt <= to_date(?,'yyyymmddhh24miss')       						".trim() + "\n"
//		;
			
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
		
		return insCnt;
	}
	
	/**
	 * 기존 데이타 존재 유무 검색
	 * @param cnt_cd
	 * @return
	 * @throws DAOException
	 */
	public boolean searchMdmCountry(String cnt_cd) throws DAOException{
		boolean isSuccessful = false; 		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("cnt_cd", cnt_cd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ReceiveQueueMdmCountryDBDAOSearchMdmCountryRSQL(), param, null);
			
//			selectQuery = "/* " + this.getClass().getName() + " - searchMDMCOUNTRYList() */	" + "\n"
//			+ " SELECT cnt_cd FROM mdm_country											".trim() + "\n"
//			+ " WHERE cnt_cd = '"+pk+"'     	               							".trim() + "\n"
//			;
			
			if( dbRowset.getRowCount() <= 0 ) isSuccessful = true;
			
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
		
		return isSuccessful;
	}
	
	/**
	 * 삭제
	 * @param model
	 * @return
	 * @throws DAOException
	 */
	public int removeMdmCountry(MdmCountryVO model) throws DAOException {
		int insCnt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {		
			Map<String, String> mapVO = model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				velParam.putAll( mapVO );	 
			}					
			
			insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueMdmCountryDBDAORemoveMdmCountryUSQL(),  param, velParam);			
			
//			deleteQuery = "/* " + this.getClass().getName() + " - removeMDMCOUNTRY() */	" + "\n"	
//			 + " UPDATE mdm_country 											".trim() + "\n"
//			 + "	SET delt_flg = 'Y',					                         		".trim() + " \n"
//			 + " 		upd_usr_id = ?         ,upd_dt = to_date(?,'yyyymmddhh24miss'),	".trim() + "\n"
//			 + " 		eai_evnt_dt = to_date(?,'yyyymmddhh24miss')							".trim() + "\n"
//			 + " WHERE 	cnt_cd = ?                           						".trim() + " \n"
//			 + " AND 	eai_evnt_dt <= to_date(?,'yyyymmddhh24miss')                 ".trim() + " \n"
//		;	
			
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
		
		return insCnt;
	}
}
