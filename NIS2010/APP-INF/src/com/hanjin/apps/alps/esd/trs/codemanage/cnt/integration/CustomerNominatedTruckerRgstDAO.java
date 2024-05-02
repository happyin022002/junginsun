/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustomerNominatedTruckerRgstDAO.java
*@FileTitle : CNT(Customer Nominated Trucker) Registration.
*Open Issues :
*Change history :
*@LastModifyDate : 2014.06.11
*@LastModifier : JEON JEE YE
*@LastVersion : 1.0
* 2014.06.11 JEON JEE YE
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.cnt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esd.trs.codemanage.cnt.event.EsdTrs0086Event;
import com.hanjin.apps.alps.esd.trs.codemanage.cnt.vo.SearchCntRgstVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * CNT(Customer Nominated Trucker) Registration 에 대한 DB 처리를 담당<br>
 * - CNT(Customer Nominated Trucker) Registration Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jeon Jee Ye
 * @see CustomerNominatedTruckerRgstBCImpl 참조
 * @since J2EE 1.6
 */
public class CustomerNominatedTruckerRgstDAO extends DBDAOSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * CNT(Customer Nominated Trucker) Registration 에 Grid 를 조회 합니다.<br>
	 * 
	 * @param event EsdTrs0086Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCntRgst(EsdTrs0086Event event) throws DAOException {
		DBRowSet dbRowset = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			List<String> arr_DispStsCd = new ArrayList<String>();
			arr_DispStsCd = this.seperationParameter(event.getsDispStsCd(), ","); 
			
			param.put("s_disp_sts_cd", 	arr_DispStsCd);
			param.put("s_dt_div_cd", event.getsDtDivCd());
			param.put("s_fm_dt", event.getsFmDt().replaceAll("-", "") );
			param.put("s_to_dt", event.getsToDt().replaceAll("-", "") );
			param.put("s_eff_dt", event.getsEffDt().replaceAll("-", "") );
			param.put("s_ctrt_no", event.getsCtrtNo());
			param.put("s_cust_seq", event.getsCustSeq());
			param.put("s_vndr_seq", event.getsVndrSeq());
			param.put("s_dest_nod_cd", event.getsDestNodCd());
			
            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
            CustomerNominatedTruckerRgstDAOSearchCntRgstRSQL template = new CustomerNominatedTruckerRgstDAOSearchCntRgstRSQL();
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
	 * CNT(Customer Nominated Trucker) Registration 화면의 Date 구분 코드를 조회<br>
	 * 
	 * @param event EsdTrs0086Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	 public DBRowSet searchDtDiv(EsdTrs0086Event event) throws DAOException {
			DBRowSet dbRowset = null;
	        Map<String, Object> param = new HashMap<String, Object>();
			
			try {
	            param.put("ctrt_no", event.getsCtrtNo());

	            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
	            CustomerNominatedTruckerRgstDAOSearchDtDivRSQL template = new CustomerNominatedTruckerRgstDAOSearchDtDivRSQL(); 
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
	 * CNT(Customer Nominated Trucker) Registration 화면의 Trucker 조회시 Trucker Name을 조회<br>
	 * 
	 * @param event EsdTrs0086Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	 public DBRowSet searchCust(EsdTrs0086Event event) throws DAOException {
			DBRowSet dbRowset = null;
	        // query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
			
			try {
				param.put("as_cust_seq", event.getsCustSeq());

	            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
	            CustomerNominatedTruckerRgstDAOSearchCustRSQL template = new CustomerNominatedTruckerRgstDAOSearchCustRSQL(); 
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
	 * CNT(Customer Nominated Trucker) Registration 화면의 S/C, RFA  조회시 Custmer Contract 정보를 조회하는 이벤트 처리<br>
	 * 
	 * @param event EsdTrs0086Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	 public DBRowSet searchContractInfo(EsdTrs0086Event event) throws DAOException {
			DBRowSet dbRowset = null;
	        // query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
			
			try {
				param.put("prc_ctrt_tp_cd", event.getPrcCtrtTpCd());
				param.put("prc_ctrt_no", event.getPrcCtrtNo());
				
	            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
	            CustomerNominatedTruckerRgstDAOSearchContractInfoRSQL template = new CustomerNominatedTruckerRgstDAOSearchContractInfoRSQL(); 
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
	 * CNT(Customer Nominated Trucker) Registration 화면의 Custmer 조회시 Custmer Name을 조회<br>
	 * 
	 * @param event EsdTrs0086Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	 public DBRowSet searchTrucker(EsdTrs0086Event event) throws DAOException {
			DBRowSet dbRowset = null;
	        // query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
			
			try {
	            param.put("as_vndr_seq", (event.getsVndrSeq()==null||event.getsVndrSeq().equals(""))?event.getVndrSeq():event.getsVndrSeq());

	            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
	            CustomerNominatedTruckerRgstDAOSearchTruckerRSQL template = new CustomerNominatedTruckerRgstDAOSearchTruckerRSQL(); 
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
	  * SCAC CD로 중복 Vendor 조회하는 이벤트 처리<br>
	 * 
	 * @param event EsdTrs0086Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	 public DBRowSet searchDupChkSpNameByScacCd(EsdTrs0086Event event) throws DAOException {
			DBRowSet dbRowset = null;
	        // query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
			
			try {
	            param.put("usa_edi_cd", (event.getUsaEdiCd()==null||event.getUsaEdiCd().equals(""))?event.getUsaEdiCd():event.getUsaEdiCd());

	            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
	            CustomerNominatedTruckerRgstDAOSearchDupChkSpNameByScacCdRSQL template = new CustomerNominatedTruckerRgstDAOSearchDupChkSpNameByScacCdRSQL(); 
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
		  * SCAC CD로 Vendor 조회하는 이벤트 처리<br>
		 * 
		 * @param event EsdTrs0086Event
		 * @return DBRowSet
		 * @throws DAOException
		 */
		 public DBRowSet searchSpNameByScacCd(EsdTrs0086Event event) throws DAOException {
				DBRowSet dbRowset = null;
		        // query parameter
		        Map<String, Object> param = new HashMap<String, Object>();
				
				try {
		            param.put("usa_edi_cd", (event.getUsaEdiCd()==null||event.getUsaEdiCd().equals(""))?event.getUsaEdiCd():event.getUsaEdiCd());

		            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
		            CustomerNominatedTruckerRgstDAOSearchSpNameByScacCdRSQL template = new CustomerNominatedTruckerRgstDAOSearchSpNameByScacCdRSQL(); 
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
	 * CNT(Customer Nominated Trucker) Registration 화면의 Custmer 조회시 Custmer Name을 조회<br>
	 * 
	 * @param event EsdTrs0086Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	 public DBRowSet searchRepYd(EsdTrs0086Event event) throws DAOException {
			DBRowSet dbRowset = null;
	        // query parameter
	        Map<String, Object> param = new HashMap<String, Object>();
			
			try {
				
				if(event.getMtyPkupRtnYdCd() == null || event.getMtyPkupRtnYdCd().equals("")) {
					param.put("p_bnd", event.getIoBndCd());
					param.put("p_orgin", event.getOrgNodCd());
					param.put("p_dest", event.getDestNodCd());
				} else {
					param.put("mtyPkupRtnYdCd", event.getMtyPkupRtnYdCd());
				}

	            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
	            CustomerNominatedTruckerRgstDAOSearchRepYdRSQL template = new CustomerNominatedTruckerRgstDAOSearchRepYdRSQL(); 
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
	 * CNT(Customer Nominated Trucker) Registration 데이타 모델을 DB에서 저장한다<br>
	 * 
	 * @param event EsdTrs0086Event
	 * @param account SignOnUserAccount
	 * @throws DAOException
	 */
	 public void multiCntRgst(EsdTrs0086Event event, SignOnUserAccount account) throws DAOException {
			try {
				int insCnt = 0;
				SearchCntRgstVO[] models = (SearchCntRgstVO[])event.getSearchCntRgstVOs();
				Map<String,Object> param = new HashMap<String,Object>();
				DBRowSet dbRowset0 = null;
				DBRowSet dbRowset = null;
	            SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
	        	String dupFlg = "N";
				
				param.put("cre_ofc_cd", account.getOfc_cd());
				param.put("rgst_usr_id", account.getUsr_id());
				param.put("rgst_ofc_cd", account.getOfc_cd());
				param.put("cre_usr_id", account.getCre_usr_id());
				param.put("upd_usr_id", account.getCre_usr_id());
				
				for ( int i=0; i<models.length; i++ ) {
					Map<String, String> paramVo = models[i].getColumnValues();
					param.putAll(paramVo);
					if ( models[i].getIbflag().equals("I")){
						
						dbRowset0 = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CustomerNominatedTruckerRgstDAOSearchCntRgstDupChkRSQL(),param,param);
						if (dbRowset0.next()) {
							dupFlg = dbRowset0.getString("DUP_FLG");
						}
						
						if(dupFlg.equals("N")){
				            CustomerNominatedTruckerRgstDAOMultiCntRgstGetSeqRSQL template = new CustomerNominatedTruckerRgstDAOMultiCntRgstGetSeqRSQL(); 
				            dbRowset = sqlExe.executeQuery(template, param, param);
				            if (dbRowset.next()) {
				            	String sAprono = dbRowset.getString("apro_no");
				            	param.put("apro_no", sAprono);
				            }
							
							insCnt = new SQLExecuter("DEFAULT").executeUpdate(new CustomerNominatedTruckerRgstDAOMultiCntRgstCSQL(), param, param);
						}else{
							throw new DAOException((new ErrorHandler("TRS50118",new String[]{""})).getMessage());
						}
					} else if ( models[i].getIbflag().equals("U")){
							insCnt = new SQLExecuter("DEFAULT").executeUpdate(new CustomerNominatedTruckerRgstDAOMultiCntRgstUSQL(), param, param);
					}
					if(insCnt == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert multiCntRgst (Line : " + i + ")");						
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
	 * CNT(Customer Nominated Trucker) Registration 데이타 모델을 DB에서 삭제한다<br>
	 * 
	 * @param event EsdTrs0086Event
	 * @param account SignOnUserAccount
	 * @throws DAOException
	 */
	 public void deleteCntRgst(EsdTrs0086Event event, SignOnUserAccount account) throws DAOException {
    		try {
				int insCnt = 0;
				SearchCntRgstVO[] models = (SearchCntRgstVO[])event.getSearchCntRgstVOs();
				Map<String,Object> param = new HashMap<String,Object>();
    			
				for(int i=0; models != null && i < models.length; i++) {
					if (models[i].getIbflag().length() > 0) {
						param.put("apro_no", models[i].getAproNo());	// apro_no
						
						insCnt = new SQLExecuter("DEFAULT").executeUpdate(new CustomerNominatedTruckerRgstDAODeleteCntDSQL(),param, param);
						if (insCnt == Statement.EXECUTE_FAILED) {
							throw new DAOException("Fail to delete CustomerNominatedTruckerRgstDAODeleteCntDSQL ");
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
	 
	/**
	 * CNT(Customer Nominated Trucker) Registration 데이타 모델을 DB에서 수정한다<br>
	 * 
	 * @param event EsdTrs0086Event
	 * @param account SignOnUserAccount
	 * @throws DAOException
	 */
	 public void updateCntAproRqst(EsdTrs0086Event event, SignOnUserAccount account) throws DAOException {
		try {
			int insCnt = 0;
			SearchCntRgstVO[] models = (SearchCntRgstVO[])event.getSearchCntRgstVOs();
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("cre_ofc_cd", account.getOfc_cd());
			DBRowSet dbRowset0 = null;
			DBRowSet dbRowset = null;
			String dupFlg = "N";
			
			
			for(int i=0; models != null && i < models.length; i++) {
				if (models[i].getIbflag().length() > 0) {
					
					if (models[i].getIbflag().equals("U")) {
						param.put("apro_no", models[i].getAproNo());	// apro_no
						
						insCnt = new SQLExecuter("DEFAULT").executeUpdate(new CustomerNominatedTruckerRgstDAOUpdateCntAproRqstUSQL(),param, param);
						
						if (insCnt == Statement.EXECUTE_FAILED) {
							throw new DAOException("Fail to Update CustomerNominatedTruckerRgstDAOUpdateCntAproRqstUSQL ");
						}
					}else if ( models[i].getIbflag().equals("I")){		
						Map<String, String> paramVo = models[i].getColumnValues();
						param.putAll(paramVo);
	
						dbRowset0 = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CustomerNominatedTruckerRgstDAOSearchCntRgstDupChkRSQL(),param,param);
						if (dbRowset0.next()) {
							dupFlg = dbRowset0.getString("DUP_FLG");
						}
						
						if(dupFlg.equals("N")){
				            dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new CustomerNominatedTruckerRgstDAOMultiCntRgstGetSeqRSQL(),param,param);
				            if (dbRowset.next()) {
				            	String sAprono = dbRowset.getString("apro_no");
				            	param.put("apro_no", sAprono);
				            }
							param.put("cre_ofc_cd", account.getOfc_cd());
							param.put("rgst_usr_id", account.getUsr_id());
							param.put("rgst_ofc_cd", account.getOfc_cd());
							param.put("cre_usr_id", account.getCre_usr_id());
							param.put("upd_usr_id", account.getCre_usr_id());
							insCnt = new SQLExecuter("DEFAULT").executeUpdate(new CustomerNominatedTruckerRgstDAOUpdateCntAproRqstCSQL(), param, param);
							if (insCnt == Statement.EXECUTE_FAILED) {
								throw new DAOException("Fail to Insert CustomerNominatedTruckerRgstDAOUpdateCntAproRqstCSQL ");
							}
						}else{
							throw new DAOException((new ErrorHandler("TRS50118",new String[]{""})).getMessage());
						}
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

