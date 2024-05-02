/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ContractAttachDAO.java
*@FileTitle : Contract Attach
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.23
*@LastModifier : CHOI JONG HYEK
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.contractattach.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.trs.agreementmanage.contractattach.basic.ContractAttachBCImpl;
import com.hanjin.apps.alps.esd.trs.agreementmanage.contractattach.event.EsdTrs0243Event;
import com.hanjin.apps.alps.esd.trs.agreementmanage.contractattach.vo.SearchContractVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * CNT(Customer Nominated Trucker) Registration 에 대한 DB 처리를 담당<br>
 * - CNT(Customer Nominated Trucker) Registration Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CHOI JONG HYEK
 * @see ContractAttachBCImpl 참조
 * @since J2EE 1.6
 */


public class ContractAttachDAO extends DBDAOSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * CNT(Customer Nominated Trucker) Registration 에 Grid 를 조회 합니다.<br>
	 * 
	 * @param event EsdTrs0243Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	
	public DBRowSet searchContract(EsdTrs0243Event event) throws DAOException {
		DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("agmt_no", event.getAgmtNo());
			param.put("f_ctrt_mn_flg", event.getfCtrtMnFlg());
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            ContractAttachDAOSearchContractRSQL template = new ContractAttachDAOSearchContractRSQL();
            dbRowset = sqlExe.executeQuery(template, param, param);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * 여러개의 parameter를 나누어주는 메소드
	 * Detail Inquity Popup<br>
	 * 
	 * @param sparameter String
	 * @param sSeperate String
	 * @return ArrayList<String> 
	 */
	public ArrayList<String> seperationParameter(String sparameter, String sSeperate) {
		ArrayList<String> arrlist = new ArrayList<String>();
		StringTokenizer st  = null;
		int j = 0;
		if( !sparameter.equals("") ) {
			st = new StringTokenizer(sparameter, sSeperate);
			while( st.hasMoreTokens() ) {
				arrlist.add(j++, st.nextToken());
			}
		}
		return arrlist;
	}
	 
	/**
	 * CNT(Customer Nominated Trucker) Registration 데이타 모델을 DB에서 저장한다<br>
	 * 
	 * @param event EsdTrs0243Event
	 * @param account SignOnUserAccount
	 * @throws DAOException
	 */
	 public void multiContractRgst(EsdTrs0243Event event, SignOnUserAccount account) throws DAOException {
			try {
				SearchContractVO[] models = (SearchContractVO[])event.getSearchContractVOs();
				Map<String,Object> param = new HashMap<String,Object>();
				int insCnt = 0;
				param.put("cre_usr_id", account.getUsr_id());

				for ( int i=0; i<models.length; i++ ) {
					Map<String, String> paramVo = models[i].getColumnValues();
					param.putAll(paramVo);
					insCnt = new SQLExecuter("DEFAULT").executeUpdate(new ContractAttachDAOMultiContractCSQL(), param, param);

					if(insCnt == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert ContractAttachDAOMultiContractCSQL ");						
					}
				}
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
	 }
	 
	/**
	 * Contract Attach 데이타 모델을 DB에서 삭제한다<br>
	 * 
	 * @param event EsdTrs0243Event
	 * @param account SignOnUserAccount
	 * @throws DAOException
	 */
	 public void deleteContract(EsdTrs0243Event event, SignOnUserAccount account) throws DAOException {
    		try {
				int insCnt = 0;
				SearchContractVO[] models = (SearchContractVO[])event.getSearchContractVOs();
				Map<String,Object> param = new HashMap<String,Object>();
				for(int i=0; models != null && i < models.length; i++) {
					if (models[i].getIbflag().length() > 0) {
						Map<String, String> paramVo = models[i].getColumnValues();
						param.putAll(paramVo);
						insCnt = new SQLExecuter("DEFAULT").executeUpdate(new ContractAttachDAODeleteContractDSQL(),param, param);
						if (insCnt == Statement.EXECUTE_FAILED) {
							throw new DAOException("Fail to delete ContractAttachDAODeleteContractDSQL ");
						}
					}
    			}
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
	 }
}
