/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CustRefPartyManageDBDAO.java
*@FileTitle : crm referency party 정보
*Open Issues :
*Change history :
*@LastModifyDate : 2010-05-20
*@LastModifier : 김종호
*@LastVersion : 1.6
* 2006-12-20 Lee Sang-Woo
* 1.0 최초 생성
* 2010-05-17 김종호 : ALPS New F/W 전환 작업
* 2010-05-20 김종호 : data setting 부분 수정
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.custrefparty.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TrsTrspActCustAddrVO;

/**
 * eNIS-BIZCOMMON에 대한 DB 처리를 담당<br>
 * - eNIS-BIZCOMMON Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Lee Sang-Woo
 * @see CustRefPartyManageBCImpl 참조
 * @since J2EE 1.4
 */
public class CustRefPartyManageDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * JMS ReceiveInterface(Receive) 처리한다.<br>
	 * 
	 * @param model TrsTrspActCustAddrVO
	 * @return boolean
	 * @see Esd078Hu01Event
	 * @throws DAOException
	 */
	public boolean addCustRefPartyManage(TrsTrspActCustAddrVO model) throws DAOException {

        String  act_cust_cnt_cd   = "";
		String  act_cust_seq      = "";
		String  crm_row_id        = "";	
		String  eai_event_dt        = "";	
		act_cust_cnt_cd = model.getActCustCntCd(); //고객의 국가 코드
		act_cust_seq = model.getActCustSeq(); // 고객 시퀀스
		crm_row_id = model.getCrmRowId(); // CRM ROW ID ROW ID 를 SYNC PK 로 사용
		eai_event_dt = model.getEaiEvntDt(); //EAI EVENT 발생일시
		
		boolean isSuccessful = false; 
		
		DBRowSet rs = null; 
		
		try {
		
			if(act_cust_cnt_cd == null || act_cust_cnt_cd.equals("") ){ throw new Exception("ACT_CUST_CNT_CD is mandatory."); }			
			if(act_cust_seq == null || act_cust_seq.equals("") ){ throw new Exception("ACT_CUST_SEQ is mandatory."); }			
			if(crm_row_id == null || crm_row_id.equals("") ){ throw new Exception("CRM_ROW_ID is mandatory."); }
			if(eai_event_dt == null || eai_event_dt.equals("") ){ throw new Exception("EAI_EVNT_DT is mandatory."); }
			if ( act_cust_cnt_cd !=null && act_cust_cnt_cd.trim().length() > 0 
				&&	act_cust_seq !=null && act_cust_seq.trim().length() > 0
				&&	crm_row_id !=null && crm_row_id.trim().length() > 0 ) {	
				
				if (!searchCustRefPartyManageList(crm_row_id)){	
					
					//query parameter
					Map<String, Object> param = new HashMap<String, Object>();
					param.put("act_cust_cnt_cd", act_cust_cnt_cd);
					param.put("act_cust_seq", act_cust_seq);
					
					if(model != null){
												
						// selectCustRefPartyManageRSQL
						rs = new SQLExecuter("").executeQuery((ISQLTemplate)new CustRefPartyManageDBDAOselectCustRefPartyManageRSQL(), param, null);

						
						// 조회 결과값이 있을 경우 addCustRefPartyManageCSQL
						if (rs != null && rs.next()){
							
							Map<String, String> mapVO = model.getColumnValues();
							param.putAll(mapVO);
							param.put("act_cust_addr_seq", rs.getString("ACT_CUST_ADDR_SEQ"));
							new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new CustRefPartyManageDBDAOaddCustRefPartyManageCSQL(), param, null);

						}	
						
					}					

				} else {						
					Collection<TrsTrspActCustAddrVO> updateVoList = new ArrayList<TrsTrspActCustAddrVO>();
					updateVoList.add(model);
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
					CustRefPartyManageDBDAOmodifyCustRefPartyManageUSQL template = new CustRefPartyManageDBDAOmodifyCustRefPartyManageUSQL();			
					sqlExe.executeBatch(template, updateVoList,null, null);                                              			 									
				}
			}
			
			isSuccessful = true;
			
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
	 * @param pk1
	 * @return
	 * @throws DAOException
	 */
	public boolean searchCustRefPartyManageList(String pk1) throws DAOException{
		
		boolean isSuccessful = false; 

		DBRowSet rs = null;
		
		try {
			
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("crm_row_id", pk1);
			
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
			CustRefPartyManageDBDAOsearchCustRefPartyManageListRSQL template = new CustRefPartyManageDBDAOsearchCustRefPartyManageListRSQL();	        
			rs = sqlExe.executeQuery(template, param, null);

			if ( rs!= null && rs.next()){
				log.debug("rs.getString(1) : "+rs.getString(1));
				if( !rs.getString(1).equals("0") ){isSuccessful = true; }
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
		return isSuccessful;	
	}
	
	/**
	 * @param model
	 * @return
	 * @throws DAOException
	 */
	public boolean deleteCustRefPartyManage(TrsTrspActCustAddrVO model) throws DAOException{
 
		boolean isDelete = true;
		
		String  crm_row_id        = "";	
		String  eai_event_dt        = "";	
		crm_row_id = model.getCrmRowId();
		eai_event_dt = model.getEaiEvntDt();		
		log.debug("crm_row_id : " + crm_row_id);
		
		try {
			
			if(crm_row_id == null || crm_row_id.equals("") ){ throw new Exception("CRM_ROW_ID is mandatory."); }
			if(eai_event_dt == null || eai_event_dt.equals("") ){ throw new Exception("EAI_EVNT_DT is mandatory."); }			
			if (crm_row_id !=null && crm_row_id.trim().length() > 0 ) {					
				if (searchCustRefPartyManageList(crm_row_id)){	
					Collection<TrsTrspActCustAddrVO> deleteVoList = new ArrayList<TrsTrspActCustAddrVO>();
					deleteVoList.add(model);
					SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
					CustRefPartyManageDBDAOdeleteCustRefPartyManageDSQL template = new CustRefPartyManageDBDAOdeleteCustRefPartyManageDSQL();			
					sqlExe.executeBatch(template, deleteVoList,null, null);
				}
				isDelete = true;
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
		return isDelete; 	
	}
			
}