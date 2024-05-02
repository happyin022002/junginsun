/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : Invoice210EdiDBDAO.java
*@FileTitle : Invoice 210 EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.07
*@LastModifier : 최 선
*@LastVersion : 1.2
* 2009.05.21 eunju son
* 1.0 최초 생성
* -------------------------------------------------------
* history
* 2011.07.20 김영철 1.1 [CHM-201111871] [TRS] R4J 소스 품질 조치 내역 수정
* 2012.02.07 최 선   1.2 [CHM-201215882] [TRS/SPP] 210 EDI 수신요건 변경 요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoice210edi.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.invoicemanage.invoice210edi.basic.Invoice210EdiBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TrsTrspInvEdiVO;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;


/**
 * ENIS-Invoice210Edi에 대한 DB 처리를 담당<br>
 * - ENIS-Invoice210Edi Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author eunju son
 * @see Invoice210EdiBCImpl 참조
 * @since J2EE 1.4
 */
public class Invoice210EdiDBDAO extends DBDAOSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Invoice210Edi의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param model TrsTrspInvEdiVO
	 * @return int 
	 * @throws DAOException
	 */
	public int searchInvCfmSO(TrsTrspInvEdiVO model) throws DAOException {
		int rowCnt = 0;
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("inv_no", model.getInvNo());
			param.put("trsp_so_ofc_cty_cd", model.getTrspSoOfcCtyCd());
			param.put("trsp_so_seq", model.getTrspSoSeq());

			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new Invoice210EdiDBDAOSearchInvCfmSORSQL(), param, param);
			rowCnt   = dbRowset.getRowCount();
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
		
		return rowCnt;
	}
	
	
	/**
	 * Invoice210Edi의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param model TrsTrspInvEdiVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchNotInvSO(TrsTrspInvEdiVO model) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("trsp_so_ofc_cty_cd", model.getTrspSoOfcCtyCd() );
			param.put("trsp_so_seq"       , model.getTrspSoSeq()      );
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new Invoice210EdiDBDAOSearchNotInvSORSQL(), param, param);
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
		
		return dbRowset;
	}
	
	/**
	 * Invoice210Edi의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param vndr
	 * @return
	 * @throws DAOException
	 */
	public String searchInvoiceVndr(String vndr) throws DAOException {
		String inv_nvdr = "";
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("wo_vndr_seq", vndr );
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new Invoice210EdiDBDAOSearchInvoiceVndrRSQL(), param, param);
			if( dbRowset.next()){
				inv_nvdr = dbRowset.getString("INV_VNDR_SEQ");
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
		
		return inv_nvdr;
	}
//	
//	/**
//	 * Invoice210Edi의 데이타 모델에 해당되는 값을 불러온다.<br>
//	 * 
//	 * @param vndr
//	 * @return
//	 * @throws DAOException
//	 */
//	public boolean searchInvoiceVndrCheck(String vndr) throws DAOException {
//		String inv_nvdr = "";
//		boolean vndr_check = false;
//		// PDTO(Data Transfer Object including Parameters)
//		DBRowSet dbRowset = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		
//		try{
//			param.put("wo_vndr_seq", vndr );
//			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new Invoice210EdiDBDAOSearchInvoiceVndrRSQL(), param, param);
//			if( dbRowset.next()){
//				inv_nvdr = dbRowset.getString("VNDR_SEQ");
//				if( vndr.equals(inv_nvdr) ) vndr_check = true;
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		}
//		return vndr_check;
//	}
//	public boolean searchInvoiceVndrCheck(String vndr) throws DAOException {
//		// Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement ps = null;
//		// DB ResultSet
//		ResultSet rs = null;
//		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
//		DBRowSet dRs = null;
//		// PreparedStatement에 bind 변수를 넣을시 증가되는 변수
//		int i = 1;
//		
//		String inv_nvdr = "";
//		boolean vndr_check = false;
//
//		StringBuffer queryStr = new StringBuffer();
//		
//		queryStr.append("SELECT      			\n");
//		queryStr.append(" F.VNDR_SEQ    		\n");
//		queryStr.append("FROM      			\n");
//		queryStr.append(" MDM_VENDOR F   		\n");
//		queryStr.append("WHERE      			\n");
//		queryStr.append(" F.VNDR_SEQ   = ? 		\n");
//		queryStr.append("UNION      			\n");
//		queryStr.append("SELECT      			\n");
//		queryStr.append(" F.VNDR_SEQ    		\n");
//		queryStr.append("FROM      			\n");
//		queryStr.append(" MDM_VENDOR F   		\n");
//		queryStr.append("WHERE      			\n");
//		queryStr.append(" F.PRNT_VNDR_SEQ  = ?		\n");
//		
//
//		try {
//			con = getConnection();
//			
//			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				ps = new LoggableStatement(con, queryStr.toString());
//			} else {
//				ps = con.prepareStatement(queryStr.toString());
//			}
//			
//			// 쿼리에 변수 세팅. 
//			 ps.setString(i++, vndr);
//			 ps.setString(i++, vndr);
//			
//			// Loggable Statement 사용에 의해 추가 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL :" + ((LoggableStatement)ps).getQueryString());
//			} else {
//				log.info("\n SQL :" + queryStr );
//			}
//			rs = ps.executeQuery();
//			if( rs.next()){
//				inv_nvdr = rs.getString("VNDR_SEQ");
//				if( vndr.equals(inv_nvdr) )
//					vndr_check = true;
//					
//			}
//
//			// 결과를 DBRowset에 담는다.
//			dRs = new DBRowSet();
//			dRs.populate(rs);
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeResultSet(rs);
//			closeStatement(ps);
//			closeConnection(con);
//		}
//		return vndr_check;
//	}
	
	
	/**
	 * Invoice210Edi의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param model TrsTrspInvEdiVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchInvoiceWO(TrsTrspInvEdiVO model) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("trsp_wo_ofc_cty_cd", model.getTrspWoOfcCtyCd() );
			param.put("trsp_wo_seq"       , model.getTrspWoSeq()      );
			param.put("eq_no"             , model.getEqNo()           );
			param.put("eq_tpsz_cd"        , model.getEqTpszCd()       );
			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new Invoice210EdiDBDAOSearchInvoiceWORSQL(), param, param);
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
		
		return dbRowset;
	}

	

	/**
	 * Invoice210Edi의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param model
	 * @param rejectFlag
	 * @param invAmt
	 * @return
	 * @throws DAOException
	 */
	public boolean saveInvoice210Edi(TrsTrspSvcOrdVO model, boolean rejectFlag,String invAmt) throws DAOException {
		boolean isSuccessful = false;
		
		boolean isUpdate     = false;
		boolean isRejUpdate  = false;
		boolean invInsert    = false;
		boolean rejInsert    = false;
		boolean invwUpdate   = false;
		
		int     result0      = 0;
		int     result1      = 0;
		int     result2      = 0;
		int     result3      = 0;
		int     result4      = 0;
		
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet  dbRowset   = null;
		SQLExecuter sqlExe   = null;
		//SELECT query parameter
		Map<String, Object> param_sel = new HashMap<String, Object>();
		//Reject UPDATE query parameter
		Map<String, Object> param_RejUpdate = new HashMap<String, Object>();
		//UPDATE query parameter
		Map<String, Object> param_Update = new HashMap<String, Object>();
		//Invoice UPDATE query parameter
		Map<String, Object> param_InvUpdate = new HashMap<String, Object>();
		//INSERT query parameter
		Map<String, Object> param_RejInsert = new HashMap<String, Object>();
		Map<String, Object> param_InvInsert = new HashMap<String, Object>();
		
		try{
			param_sel.put("inv_no"      , model.getInvNo()     );
			param_sel.put("inv_vndr_seq", model.getInvVndrSeq());
			sqlExe = new SQLExecuter("DEFAULT");
			Invoice210EdiDBDAOSaveInvoice210EdiInvWrkRSQL invWrkRSQL = new Invoice210EdiDBDAOSaveInvoice210EdiInvWrkRSQL();
			dbRowset = sqlExe.executeQuery(invWrkRSQL, param_sel, param_sel);
			int invCnt = 0;
			if( dbRowset.next() )
				invCnt = dbRowset.getInt("ROW_CNT");
			log.debug("saveInvoice210Edi [invCnt   ]>>>>>>>:"+invCnt   );
			if( rejectFlag ){
				if( !"".equals(model.getInvNo()) && model.getInvNo() != null ){
					isRejUpdate = true;
					param_RejUpdate.put("inv_no"            , model.getInvNo());
					param_RejUpdate.put("inv_vndr_seq"      , model.getInvVndrSeq());
					param_RejUpdate.put("inv_curr_cd"       , model.getInvCurrCd());
					param_RejUpdate.put("inv_bzc_amt"       , model.getInvBzcAmt());
					param_RejUpdate.put("inv_rmk"           , model.getInvRmk());
					param_RejUpdate.put("trsp_so_ofc_cty_cd", model.getTrspSoOfcCtyCd());
					param_RejUpdate.put("trsp_so_seq"       , model.getTrspSoSeq());
					
				}
			}
			else
			{
				if( !"".equals(model.getInvNo()) && model.getInvNo() != null ){
					isUpdate    = true;
					param_Update.put("inv_no"            , model.getInvNo());
					param_Update.put("inv_vndr_seq"      , model.getInvVndrSeq());
					param_Update.put("eq_no"             , model.getEqNo());
					param_Update.put("inv_curr_cd"       , model.getInvCurrCd());
					param_Update.put("inv_bzc_amt"       , model.getInvBzcAmt());
					param_Update.put("inv_rmk"           , model.getInvRmk());
					param_Update.put("trsp_so_ofc_cty_cd", model.getTrspSoOfcCtyCd());
					param_Update.put("trsp_so_seq"       , model.getTrspSoSeq());
					
				}
			}
			
			if( invCnt > 0 ){
				if( rejectFlag ){
					invwUpdate  = true;
					param_InvUpdate.put("inv_no"            , model.getInvNo());
					param_InvUpdate.put("inv_vndr_seq"      , model.getInvVndrSeq());
					
				}
			}
			else
			{
				if( rejectFlag ){
					rejInsert = true;
					param_RejInsert.put("inv_no"       , model.getInvNo());
					param_RejInsert.put("inv_vndr_seq" , model.getInvVndrSeq());
					param_RejInsert.put("wo_vndr_seq"  , model.getVndrSeq());
					param_RejInsert.put("inv_curr_cd"  , model.getInvCurrCd());
					param_RejInsert.put("inv_bzc_amt"  , invAmt);
					param_RejInsert.put("inv_ttl_amt"  , invAmt);
					param_RejInsert.put("cre_ofc_cd"   , model.getCreOfcCd());
					param_RejInsert.put("cre_usr_id"   , model.getCreUsrId());
					param_RejInsert.put("upd_usr_id"   , model.getCreUsrId());
					
				}else{
					invInsert = true;
					param_InvInsert.put("inv_no"       , model.getInvNo());
					param_InvInsert.put("inv_vndr_seq" , model.getInvVndrSeq());
					param_InvInsert.put("wo_vndr_seq"  , model.getVndrSeq());
					param_InvInsert.put("inv_curr_cd"  , model.getInvCurrCd());
					param_InvInsert.put("inv_bzc_amt"  , invAmt);
					param_InvInsert.put("inv_ttl_amt"  , invAmt);
					param_InvInsert.put("cre_ofc_cd"   , model.getCreOfcCd());
					param_InvInsert.put("cre_usr_id"   , model.getCreUsrId());
					param_InvInsert.put("upd_usr_id"   , model.getCreUsrId());
					
				}
			}
			
			
			if( invInsert ){
				sqlExe = new SQLExecuter("DEFAULT");
				Invoice210EdiDBDAOSaveInvoice210EdiInvWrkCSQL invWrkCSQL = new Invoice210EdiDBDAOSaveInvoice210EdiInvWrkCSQL();
				result3 = sqlExe.executeUpdate(invWrkCSQL, param_InvInsert, param_InvInsert);
				log.debug("saveInvoice210Edi [result3   ]>>>>>>>:"+result3   );
			}
			if( rejInsert ){
				sqlExe = new SQLExecuter("DEFAULT");
				Invoice210EdiDBDAOSaveInvoice210EdiInvWrkRejCSQL invWrkRejCSQL = new Invoice210EdiDBDAOSaveInvoice210EdiInvWrkRejCSQL();
				result2 = sqlExe.executeUpdate(invWrkRejCSQL, param_RejInsert, param_RejInsert);
				log.debug("saveInvoice210Edi [result2   ]>>>>>>>:"+result2   );
			}
			if( isUpdate ) {
				sqlExe = new SQLExecuter("DEFAULT");
				Invoice210EdiDBDAOSaveInvoice210EdiSvcOrdUSQL svcOrdUSQL = new Invoice210EdiDBDAOSaveInvoice210EdiSvcOrdUSQL();
				result0 = sqlExe.executeUpdate(svcOrdUSQL, param_Update, param_Update);
				log.debug("saveInvoice210Edi [result0   ]>>>>>>>:"+result0   );
			}
			if( isRejUpdate ){
				sqlExe = new SQLExecuter("DEFAULT");
				Invoice210EdiDBDAOSaveInvoice210EdiSvcOrdRejUSQL svcOrdRejUSQL = new Invoice210EdiDBDAOSaveInvoice210EdiSvcOrdRejUSQL();
				result1 = sqlExe.executeUpdate(svcOrdRejUSQL, param_RejUpdate, param_RejUpdate);
				log.debug("saveInvoice210Edi [result1   ]>>>>>>>:"+result1   );	
			}
			if( invwUpdate ){
				sqlExe = new SQLExecuter("DEFAULT");
				Invoice210EdiDBDAOSaveInvoice210EdiInvWrkRejUSQL invWrkRejUSQL = new Invoice210EdiDBDAOSaveInvoice210EdiInvWrkRejUSQL();
				result4 = sqlExe.executeUpdate(invWrkRejUSQL, param_InvUpdate, param_InvUpdate);
				log.debug("saveInvoice210Edi [result4   ]>>>>>>>:"+result4   );
			}
				
	
			
			log.debug("saveInvoice210Edi [isUpdate   ]>>>>>>>:"+isUpdate   );
			log.debug("saveInvoice210Edi [isRejUpdate]>>>>>>>:"+isRejUpdate);
			log.debug("saveInvoice210Edi [invInsert  ]>>>>>>>:"+invInsert  );
			log.debug("saveInvoice210Edi [rejInsert  ]>>>>>>>:"+rejInsert  );
			log.debug("saveInvoice210Edi [invwUpdate ]>>>>>>>:"+invwUpdate );
			
			if( ( result0 > 0 || result1 > 0 ) && ( result2 > 0 || result3 >0 || result4 > 0)){
				isSuccessful = true;
			}
			log.debug("saveInvoice210Edi [isSuccessful ]>>>>>>>:"+isSuccessful );
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
		return  isSuccessful;
	}
	
	
	/**
	 * Invoice210Edi의 invoice verify 결과를 DB에 반영한다.<br>
	 * 
	 * @param model TrsTrspInvEdiVO
	 * @throws DAOException
	 */
	public void modifyTrsTrspInvEdi(TrsTrspInvEdiVO model) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		int result = 0;
		try {
			param.put("inv_rmk"         , model.getInvRmk());
			param.put("inv_edi_rslt_cd" , model.getInvEdiRsltCd());
			param.put("trsp_inv_edi_seq", model.getTrspInvEdiSeq());	
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			Invoice210EdiDBDAOModifyTrsTrspInvEdiUSQL invEdiUSQL = new Invoice210EdiDBDAOModifyTrsTrspInvEdiUSQL();
			result = sqlExe.executeUpdate(invEdiUSQL, param, param);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to UPDATE modifyTrsTrspInvEdi SQL");
			}
		} catch (SQLException ex) {
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * bkg_no로 CNTR 가져오기 <br>
	 * 
	 * @param inputRs
	 * @param EQ_NO
	 * @return
	 * @throws DAOException
	 */
	public String searchInvoiceImportBkgBkgCntr(DBRowSet inputRs, String EQ_NO) throws DAOException {
		String cntrNo      = null;
		String srcCntrTpSz = null;
		String tgtCntrTpSz = null;
		// PDTO(Data Transfer Object including Parameters)
		DBRowSet dbRowsetOne = null;
		DBRowSet dbRowsetTwo = null;
		SQLExecuter sqlExe   = null;
		//one query parameter
		Map<String, Object> param_one = new HashMap<String, Object>();
		//two query parameter
		Map<String, Object> param_two = new HashMap<String, Object>();
		
		try{
			param_one.put("bkg_no"    , inputRs.getString("BKG_NO"));
			param_one.put("org_bkg_no", inputRs.getString("ORG_BKG_NO"));
			param_one.put("eq_no"     , EQ_NO);
			sqlExe = new SQLExecuter("DEFAULT");
			Invoice210EdiDBDAOSearchInvoiceImportBkgBkgCntrOneRSQL cntrOneRSQL = new Invoice210EdiDBDAOSearchInvoiceImportBkgBkgCntrOneRSQL();
			dbRowsetOne = sqlExe.executeQuery(cntrOneRSQL, param_one, param_one);
			if(dbRowsetOne.next()){
				cntrNo      = dbRowsetOne.getString("CNTR_NO");
				tgtCntrTpSz = dbRowsetOne.getString("CNTR_TPSZ_CD");
				srcCntrTpSz = inputRs.getString("EQ_TPSZ_CD");
				if(tgtCntrTpSz != null && !tgtCntrTpSz.equals(srcCntrTpSz)){
					param_two.put("cntr_tpsz_cd"     , srcCntrTpSz);
					param_two.put("prov_cntr_tpsz_cd", tgtCntrTpSz);
					sqlExe = new SQLExecuter("DEFAULT");
					Invoice210EdiDBDAOSearchInvoiceImportBkgBkgCntrTwoRSQL cntrTwoRSQL = new Invoice210EdiDBDAOSearchInvoiceImportBkgBkgCntrTwoRSQL();
					dbRowsetTwo = sqlExe.executeQuery(cntrTwoRSQL, param_two, param_two);
					if(!dbRowsetTwo.next()){
						cntrNo = null;
					}
				}
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
		return cntrNo;
	}
	
//	
//	/**
//	 *  Invoice 안된 EDI data 가져오기 <br>
//	 * 
//	 * @param 
//	 * @return DBRowSet
//	 * @throws DAOException
//	 */
//	/**
//	 * @return
//	 * @throws DAOException
//	 */
//	public ArrayList searchNotInvoicedEdi() throws DAOException {
//
//		// PDTO(Data Transfer Object including Parameters)
//		DBRowSet dbRowset = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		
//		ArrayList returnList = new ArrayList();
//
//		try {
//
//			dbRowset = new SQLExecuter("DEFAULT").executeQuery((ISQLTemplate)new Invoice210EdiDBDAOsearchNotInvoicedEdiRSQL(), param, param);
//			
//			String trspInvEdiSeq = "";
//			String invNo = "";
//			String trspWoOfcCtyCd = "";
//			String trspWoSeq = "";
//			String trspSoOfcCtyCd = "";
//			String trspSoSeq = "";
//			String eqNo = "";
//			String eqTpszCd = "";
//			String bkgNo = "";
//			String invAmt = "";
//			String invCurrCd = "";
//
//			
//		while( dbRowset.next()){
//
//			TrsTrspInvEdiVO model =  new  TrsTrspInvEdiVO();
//			trspInvEdiSeq = dbRowset.getString("TRSP_INV_EDI_SEQ");
//
//			invNo = dbRowset.getString("INV_NO");
//			if( invNo == null ) invNo = "";
//
//			trspWoOfcCtyCd = dbRowset.getString("TRSP_WO_OFC_CTY_CD");
//			if( trspWoOfcCtyCd == null ) trspWoOfcCtyCd = "";
//
//			trspWoSeq = dbRowset.getString("TRSP_WO_SEQ");
//			if( trspWoSeq == null ) trspWoSeq = "";
//
//			trspSoOfcCtyCd = dbRowset.getString("TRSP_SO_OFC_CTY_CD");
//			if( trspSoOfcCtyCd == null ) trspSoOfcCtyCd = "";
//
//			trspSoSeq = dbRowset.getString("TRSP_SO_SEQ");
//			if( trspSoSeq == null ) trspSoSeq = "";
//
//			eqNo = dbRowset.getString("EQ_NO");
//			if( eqNo == null ) eqNo = "";
//
//			eqTpszCd = dbRowset.getString("EQ_TPSZ_CD");
//			if( eqTpszCd == null ) eqTpszCd = "";
//
//			bkgNo =dbRowset.getString("BKG_NO");
//			if( bkgNo == null ) bkgNo = "";
//
//			invAmt=dbRowset.getString("INV_AMT");
//			if( invAmt == null ) invAmt = "";
//
//			invCurrCd=dbRowset.getString("INV_CURR_CD");
//			if( invCurrCd == null ) invCurrCd = "";
//
//			model.setTrspInvEdiSeq(trspInvEdiSeq);
//
//			model.setInvNo(invNo);
//
//			model.setTrspWoOfcCtyCd(trspWoOfcCtyCd);
//
//			model.setTrspWoSeq(trspWoSeq);
//
//			model.setTrspSoOfcCtyCd(trspSoOfcCtyCd);
//
//			model.setTrspSoSeq(trspSoSeq);
//
//			model.setEqNo(eqNo);
//
//			model.setEqTpszCd(eqTpszCd);
//
//			model.setBkgNo(bkgNo);
//
//			//model.setBkg_no_split(rs.getString("BKG_NO_SPLIT"));
//			model.setInvAmt(invAmt);
//
//			model.setInvCurrCd(invCurrCd);
//
//			//model.setInv_rmk((rs.getString("INV_RMK")));
//
//			returnList.add(model);
//		}
//			
//		return returnList;
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		}
//
//
//	}
	


}

