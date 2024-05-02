/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : AgreementApprovalDBDAO.java
*@FileTitle : Agreement Approval 권한 등록
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.28
*@LastModifier : 최종혁
*@LastVersion : 1.1
* 2014.05.28 최종혁
* 1.0 최초 생성
-----------------------------------------------------------
* History
=========================================================*/

package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event.EsdTrs0237Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.vo.SearchApprovalMgmtVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * @author jong hyek choi
 * @see DBDAOSupport
 * @since J2EE 1.6
 */
public class AgreementApprovalDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Agreement 결재자 리스트 조회
	 * 
	 * @param event EsdTrs0237Event
	 * @param account SignOnUserAccount
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchApprovalList(EsdTrs0237Event event, SignOnUserAccount account) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("fm_cfm_usr_id", event.getFmCfmUsrId());

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new AgreementApprovalDBDAOSearchApprovalMgmtRSQL(), param,param);
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
	 * TrsAgmtAplyVndrVO의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 *
	 * @param event EsdTrs0237Event
	 * @param account SignOnUserAccount
	 * @throws DAOException
	 */
	public void saveApprovalList(EsdTrs0237Event event, SignOnUserAccount account) throws DAOException {
		try {
			int insCnt = 0;
			SearchApprovalMgmtVO[] models = event.getSearchApprovalMgmtVOs();
			Map<String,Object> param = new HashMap<String,Object>();
			DBRowSet dbRowset=null;
			
			param.put("account_ofc_cd", 	account.getOfc_cd());
			param.put("account_usr_id", 	account.getUsr_id());
			
    		for(int f=0; models != null && f < models.length; f++) {
    			if (models[f].getIbflag().length() > 0) {
    				if (models[f].getIbflag().equals("I")) {    
    					param.put("cfm_usr_id", models[f].getCfmUsrId()); 
    					param.put("cfm_ofc_cd", models[f].getCfmOfcCd()); 
    					dbRowset=new SQLExecuter("DEFAULT").executeQuery(new AgreementApprovalDBDAOSaveApprovalDupChkRSQL(), param, param);
    					while (dbRowset.next()) {
    						int verifyCnt = dbRowset.getInt("cnt");
    						if(verifyCnt > 0) {
    						throw new DAOException((new ErrorHandler("TRS00099",new String[]{"Duplicated data has exists."})).getMessage());
    						}
    					}                   
  
						insCnt =	new SQLExecuter().executeUpdate(new AgreementApprovalDBDAOSaveApprovalListCSQL(), param, param);
						if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete " + " SQL");						
				    	}
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
	 * TrsAgmtAplyVndrVO의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(삭제)<br>
	 *
	 * @param event EsdTrs0237Event
	 * @param account SignOnUserAccount
	 * @throws DAOException
	 */
	public void delApprovalList(EsdTrs0237Event event, SignOnUserAccount account) throws DAOException {
		try {	
			int insCnt = 0;
			SearchApprovalMgmtVO[] models = event.getSearchApprovalMgmtVOs();
			Map<String,Object> param = new HashMap<String,Object>();

    		for(int f=0; models != null && f < models.length; f++) {
    			if (models[f].getSel().length() > 0) {
    				if (models[f].getSel().equals("1")) {  
    					param.put("cfm_usr_id", models[f].getCfmUsrId()); 
    					param.put("cfm_ofc_cd", models[f].getCfmOfcCd()); 
						insCnt =	new SQLExecuter().executeUpdate(new AgreementApprovalDBDAODelApprovalListDSQL(), param, param);
						if(insCnt == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete " + " SQL");						
				    	}
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
	    * User Id로 등록 유저 여부를 확인하고 Name을 조회한다. <br>
	    * @param event
	    * @return String
	    * @throws DAOException
	    */
	public SearchApprovalMgmtVO searchUsrId(EsdTrs0237Event event) throws DAOException {	
		        DBRowSet dbRowset = null;
		        SearchApprovalMgmtVO vo = new SearchApprovalMgmtVO();
			    Map<String, Object> param = new HashMap<String, Object>();
			    Map<String, Object> velParam = new HashMap<String, Object>();
			    try {
			    	Map<String, String> mapVO = new HashMap<String, String>();
			    	mapVO.put("cfm_usr_id", event.getCfmUsrId());
			    	param.putAll(mapVO);
			    	velParam.putAll(mapVO);
			    	dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new AgreementApprovalDBDAOSearchUsrIdRSQL(), param, velParam);
			    	if (dbRowset.next()) {
			    		vo.setCreUsrNm(dbRowset.getString("CFM_USR_NM"));
			    		vo.setCfmOfcCd(dbRowset.getString("CFM_OFC_CD"));
			    	}
			    } catch (SQLException se){
			    	log.error(se.getMessage(), se);
			    	throw new DAOException(new ErrorHandler(se).getMessage());
			    } catch (Exception ee){
			    	log.error(ee.getMessage(), ee);
			    	throw new DAOException(ee.getMessage());
			    }
			return vo;
	    }
}
