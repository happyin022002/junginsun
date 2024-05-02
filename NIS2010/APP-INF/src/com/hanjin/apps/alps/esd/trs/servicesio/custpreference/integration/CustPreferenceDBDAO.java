/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CustPreferenceDBDAO.java
*@FileTitle : jms bc 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-21
*@LastModifier : JeongSeon An
*@LastVersion : 1.0
* 2006-11-21 JeongSeon An
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.custpreference.integration;

import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TrsCustPrfVO;

/**
 * RDTO(Data Transfer Object including DB ResultSet)<br>
 * - InterfaceTest 요청을 처리한 서버 실행 정보(DB ResultSet)를 담은 Data Transfer Object<br>
 * - InterfaceTest 호출시 서버에서 View(JSP) Layer로 Argument 형태로 반환<br>
 *
 * @author Kim Jin-seung
 * @see OutstandingManageSC 참조
 * @since J2EE 1.4
 */
public class CustPreferenceDBDAO extends DBDAOSupport{
	/**
	 * 
	 * @param models
	 * @return
	 * @throws DAOException
	 */
	public boolean manageTRSCUSTPRF(Collection models) throws DAOException{
    	log.debug("\n --------------------------------------------------------- " +
		          "\n           Start manageTRSCUSTPRF                    " +
			      "\n --------------------------------------------------------- ");
		
		Iterator itr = models.iterator();	
		TrsCustPrfVO model = null;
		
		int c=0;
		int u=0;
		int d=0;
		int t=0;
		
		while (itr.hasNext()) {
			model = (TrsCustPrfVO)itr.next();
			t++;
			if ( model.getIbflag() !=null && model.getIbflag().trim().length() > 0 ) {
				if(model.getIbflag().equals("C")){
					if(addTRSCUSTPRF(model)) c++;
				}else if(model.getIbflag().equals("U")){
					if(modifyTRSCUSTPRF(model)) u++;
				}else if(model.getIbflag().equals("D")){
					if(removeTRSCUSTPRF(model)) d++;
				}
			}
		}
		
		//처리건수
		if(c>0) log.debug("\n Creation Record ["+c+"]Items =========================");
		if(u>0) log.debug("\n Update   Record ["+u+"]Items =========================");
		if(d>0) log.debug("\n Deletion Record ["+d+"]Items =========================");
		
		return (t==(c+u+d))? true:false; 
		
	}
	/**
	 * Insertion To TrsCustPrfVO Table
	 * 
	 * @param model
	 * @return
	 * @throws DAOException
	 */
	public boolean addTRSCUSTPRF(TrsCustPrfVO model) throws DAOException {
		boolean isSuccessful = false;
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			
			if ( model.getCrmRowId() != null && model.getCrmRowId().trim().length() > 0 ) {				
				param.put("crm_row_id", model.getCrmRowId());
				param.put("cust_cnt_cd", model.getCustCntCd());
				param.put("cust_seq", model.getCustSeq());
				param.put("trsp_mod_cd", model.getTrspModCd());
				param.put("org_loc_cd", model.getOrgLocCd());
				param.put("dest_loc_cd", model.getDestLocCd());
				param.put("vndr_cnt_cd", model.getVndrCntCd());
				param.put("vndr_seq", model.getVndrSeq());
				param.put("cre_usr_id", model.getCreUsrId());
				param.put("cre_dt", model.getCreDt());
				param.put("upd_usr_id", model.getUpdUsrId());
				param.put("upd_dt", model.getUpdDt());
				
				int insertRet = new SQLExecuter("DEFAULT").executeUpdate(new CustPreferenceDBDAOaddTRSCUSTPRFCSQL(), param, null);
				
				log.debug("\n insertRet :"+insertRet);
				isSuccessful = true;				
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
		return isSuccessful; 
	}
	
	/**
	 * Modify To TrsCustPrfVO Table
	 * 
	 * @param model
	 * @return
	 * @throws DAOException
	 */
	public boolean modifyTRSCUSTPRF(TrsCustPrfVO model) throws DAOException{
		boolean isSuccessful = false;	
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			
			if ( model.getCrmRowId() !=null && model.getCrmRowId().trim().length() > 0 ) {				
				param.put("cust_cnt_cd", model.getCustCntCd());
				param.put("cust_seq", model.getCustSeq());
				param.put("trsp_mod_cd", model.getTrspModCd());
				param.put("org_loc_cd", model.getOrgLocCd());
				param.put("dest_loc_cd", model.getDestLocCd());
				param.put("vndr_cnt_cd", model.getVndrCntCd());
				param.put("vndr_seq", model.getVndrSeq());
				param.put("cre_usr_id", model.getCreUsrId());
				param.put("upd_usr_id", model.getUpdUsrId());
				param.put("upd_dt", model.getUpdDt());
				param.put("crm_row_id", model.getCrmRowId());
				
				int updateRet = new SQLExecuter("DEFAULT").executeUpdate(new CustPreferenceDBDAOmodifyTRSCUSTPRFUSQL(), param, null);
				
				log.debug("\n updateRet :"+updateRet);
				isSuccessful = true;
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
		
		return isSuccessful; 
	}
	
	/**
	 * Remove To TrsCustPrfVO Table
	 * 
	 * @param model
	 * @return
	 * @throws DAOException
	 */
	public boolean removeTRSCUSTPRF(TrsCustPrfVO model) throws DAOException{
		boolean isSuccessful = false;
		
		Map<String, Object> param = new HashMap<String, Object>();
								
		try {
			
			if ( model.getCrmRowId() !=null && model.getCrmRowId().trim().length() > 0 ) {				
				param.put("crm_row_id", model.getCrmRowId());
				
				int deleteRet = new SQLExecuter("DEFAULT").executeUpdate(new CustPreferenceDBDAOremoveTRSCUSTPRFDSQL(), param, null);
				log.debug("\n deleteRet:::::::"+deleteRet);
				isSuccessful = true;
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
		return isSuccessful; 	
	}
}

