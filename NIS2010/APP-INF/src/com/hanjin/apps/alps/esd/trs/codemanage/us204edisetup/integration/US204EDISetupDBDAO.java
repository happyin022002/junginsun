/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : US204EDISetupDBDAO.java
*@FileTitle : US 204 EDI Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2012-04-22
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2012-04-22 조인영
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.us204edisetup.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import com.hanjin.apps.alps.esd.trs.codemanage.us204edisetup.event.EsdTrs0085Event;
import com.hanjin.apps.alps.esd.trs.codemanage.us204edisetup.integration.US204EDISetupDBDAOSearchUSEDISetupListRSQL;
import com.hanjin.apps.alps.esd.trs.codemanage.us204edisetup.integration.US204EDISetupDBDAOUpdateUSEDISetupUSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TrsEdiUsaRcvrDtlVO;
/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 조인영
 * @see US204EDISetupBCImpl 참조
 * @since J2EE 1.4
 */
public class US204EDISetupDBDAO extends DBDAOSupport {
	
	/**
	 * US204EDI SetUp 조회<br>
	 * 
	 * @param event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchUS204EDISetupList(EsdTrs0085Event event) throws DAOException {
		
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("vndrSeq", event.getVndrSeq());
			velParam.put("vndrSeq", event.getVndrSeq());
			param.put("deltFlg", event.getDeltFlg());
			velParam.put("deltFlg", event.getDeltFlg());
			
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new US204EDISetupDBDAOSearchUSEDISetupListRSQL(), param, velParam);			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * US204EDI SetUp Vendor 조회
	 * @param event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchUS204EDISetupVndr(EsdTrs0085Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();


		param.put("vndrSeq", event.getVndrSeq());
		
		try {
			dRs = new SQLExecuter("").executeQuery(new US204EDISetupDBDAOSearchUSEDISetupVndrRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}

	/**
	 * US204EDI SetUp 데이터 저장<br>
	 * @param event
	 * @see EsdTrs0085Event
	 * @throws DAOException
	 */
	public void multiUS204EDISetupList(EsdTrs0085Event event) throws DAOException {
		
		log.debug("\n\n :::::::::::::::::::::::: multiUS204EDISetupList ::::::::::::::::::::::: ");
		
		Collection<TrsEdiUsaRcvrDtlVO> models = new ArrayList<TrsEdiUsaRcvrDtlVO>();
		
		// GRID ROWS DATA
		TrsEdiUsaRcvrDtlVO[]  TrsEdiUsaRcvrDtlVOS  = event.getTrsEdiUsaRcvrDtlVOs();
		String login_usr_id = event.getLogin_usr_id();
		String cre_ofc_cd   = event.getLogin_ofc_cd();
		
		try{
			if( TrsEdiUsaRcvrDtlVOS != null ){
				for( int i=0; i<TrsEdiUsaRcvrDtlVOS.length; i++ ){
					models.add(TrsEdiUsaRcvrDtlVOS[i]);
						TrsEdiUsaRcvrDtlVOS[i].setCreUsrId(login_usr_id);
						TrsEdiUsaRcvrDtlVOS[i].setUpdUsrId(login_usr_id);
						TrsEdiUsaRcvrDtlVOS[i].setCreOfcCd(cre_ofc_cd);
				}
			}
				new SQLExecuter("DEFAULT").executeBatch(new US204EDISetupDBDAOUpdateUSEDISetupUSQL(), models, null, null);
				new SQLExecuter("DEFAULT").executeBatch(new US204EDISetupDBDAOCreateUSEDISetupHisCSQL(), models, null, null);
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

}
