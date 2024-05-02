/*============================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CreditIncentiveStatusDBDAO.java
*@FileTitle : 
*@LastModifyDate : 2016.04.26.
*@LastModifier : 
*@LastVersion : 
* 2016.04.26. SHIN DONG IL
*============================================*/
package com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.event.EsdEas0501Event;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.TesStatusIncntVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.TrsStatusIncntVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.VslStatusIncntVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.MnrStatusCrIssVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.MnrStatusCrUsdVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.BnfStatusMlgVO;
import com.hanjin.apps.alps.esd.eas.creditincentive.creditincentivestatus.vo.TotStatusMkrVO;

/**
 * Credit & Incentive Status 에 대한 DB 처리를 담당<br>
 * @author SHIN DONG IL
 * @see CreditIncentiveStatusBCImpl 참조
 * @since J2EE 1.6
 */
public class CreditIncentiveStatusDBDAO  extends DBDAOSupport{
	
	/**
	 * Credti & Invcentive Status Terminal 조회한다. <br>
	 * 
	 * @param event
	 * @return List<CreditSmmrRhqVO>
	 * @exception EventException
	 */
	public List<TesStatusIncntVO> searchTesIncentiveList(EsdEas0501Event event)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<TesStatusIncntVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			
			param.put("s_rhq_cd", event.getStrRhqCd());
			param.put("s_inv_ofc_cd", event.getStrInvOfcCd());
			param.put("s_bse_yr", event.getStrBseYr());
			param.put("s_inv_vndr_seq", event.getStrInvVndrSeq());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CreditIncentiveStatusDBDAOSearchTesIncentiveListRSQL(),param, param);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,TesStatusIncntVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	  * Credti & Invcentive Status TES Incentive 저장한다. <br>
	  * @param tesStatusIncntVO
	  * @param event
	  * @exception DAOException
	  */
	 public void multiTesIncentive(TesStatusIncntVO tesStatusIncntVO, EsdEas0501Event event) throws DAOException {

		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 DBRowSet dbRowset = null;

			 if(tesStatusIncntVO != null){
				 //query parameter
				 Map<String, String> mapVO = tesStatusIncntVO.getColumnValues();
				 param.putAll(mapVO);
				 
				 //신규 저장일 경우
				 if(tesStatusIncntVO.getIncntNo().equals("")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CreditIncentiveStatusDBDAOSearchTesIncntNoRSQL(),param, param);;
					while(dbRowset.next()){
						param.put("incnt_no",dbRowset.getString("INCNT_NO"));						
					}
				 }
				 param.put("usr_id", event.getSignOnUserAccount().getUsr_id());
				 int result = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOMultiTesIncentiveCSQL() , param, param);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to CreditIncentiveStatusDBDAOMultiTesIncentiveCSQL SQL");
				 //History save
				 int resultHis = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOMultiTesIncentiveHisCSQL() , param, param);
				 if(resultHis == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to CreditIncentiveStatusDBDAOMultiTesIncentiveHisCSQL SQL");
			 }	
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }
	/**
	  * Credti & Invcentive Status TES Incentive Delete. <br>
	  * @param tesStatusIncntVO
	  * @param event
	  * @exception DAOException
	  */
	 public void removeTesIncentive(TesStatusIncntVO tesStatusIncntVO, EsdEas0501Event event) throws DAOException {

		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");

			 if(tesStatusIncntVO != null){
				 //query parameter
				 Map<String, String> mapVO = tesStatusIncntVO.getColumnValues();
				 param.putAll(mapVO);
				 
				 param.put("usr_id", event.getSignOnUserAccount().getUsr_id());
				 int result = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAORemoveTesIncentiveDSQL() , param, param);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to CreditIncentiveStatusDBDAORemoveTesIncentiveDSQL SQL");
				 //History save
				 int resultHis = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOMultiTesIncentiveHisCSQL() , param, param);
				 if(resultHis == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to CreditIncentiveStatusDBDAOMultiTesIncentiveHisCSQL SQL");
			 }	
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }
	 
	/**
	  * Credti & Invcentive Status TES Incentive File Attach <br>
	  * @param event
	  * @exception DAOException
	  */
	 public void modifyTesFileAttach(EsdEas0501Event event) throws DAOException {

		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");

			 param.put("bse_yr",event.getStrBseYr());
			 param.put("incnt_no",event.getStrIncntNo());
			 param.put("atch_file_lnk_id",event.getStrAtchFileLnkId());			 
			 param.put("usr_id", event.getSignOnUserAccount().getUsr_id());
			 int result = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOModifyTesFileAttachUSQL() , param, param);
			 if(result == Statement.EXECUTE_FAILED)
				 throw new DAOException("Fail to CreditIncentiveStatusDBDAOModifyTesFileAttachUSQL SQL");


		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }
	 
		/**
	  * Credti & Invcentive Status TES Incentive File Attach <br>
	  * @param event
	  * @exception DAOException
	  */
	 public void modifyTesFileAttach2(EsdEas0501Event event) throws DAOException {

		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");

			 param.put("bse_yr",event.getStrBseYr());
			 param.put("incnt_no",event.getStrIncntNo());
			 param.put("atch_file_lnk_id",event.getStrAtchFileLnkId());			 
			 param.put("usr_id", event.getSignOnUserAccount().getUsr_id());
			 int result = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOModifyTesFileAttach2USQL() , param, param);
			 if(result == Statement.EXECUTE_FAILED)
				 throw new DAOException("Fail to CreditIncentiveStatusDBDAOModifyTesFileAttach2USQL SQL");


		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }	 	 
	 
	/**
	 * Credti & Invcentive Status Transportation 조회한다. <br>
	 * 
	 * @param event
	 * @return List<TrsStatusIncntVO>
	 * @exception EventException
	 */
	public List<TrsStatusIncntVO> searchTrsIncentiveList(EsdEas0501Event event)	throws DAOException {
		DBRowSet dbRowset = null;
		List<TrsStatusIncntVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			
			param.put("s_rhq_cd", event.getStrRhqCd());
			param.put("s_inv_ofc_cd", event.getStrInvOfcCd());
			param.put("s_bse_yr", event.getStrBseYr());
			param.put("s_inv_vndr_seq", event.getStrInvVndrSeq());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CreditIncentiveStatusDBDAOSearchTrsIncentiveListRSQL(),param, param);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,TrsStatusIncntVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	  * Credti & Invcentive Status TRS Incentive 저장한다. <br>
	  * @param trsStatusIncntVO
	  * @param event
	  * @exception DAOException
	  */
	 public void multiTrsIncentive(TrsStatusIncntVO trsStatusIncntVO, EsdEas0501Event event) throws DAOException {

		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 DBRowSet dbRowset = null;

			 if(trsStatusIncntVO != null){
				 //query parameter
				 Map<String, String> mapVO = trsStatusIncntVO.getColumnValues();
				 param.putAll(mapVO);
				 
				 //신규 저장일 경우
				 if(trsStatusIncntVO.getIncntNo().equals("")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CreditIncentiveStatusDBDAOSearchTrsIncntNoRSQL(),param, param);;
					while(dbRowset.next()){
						param.put("incnt_no",dbRowset.getString("INCNT_NO"));						
					}
				 }
				 param.put("usr_id", event.getSignOnUserAccount().getUsr_id());
				 int result = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOMultiTrsIncentiveCSQL() , param, param);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to CreditIncentiveStatusDBDAOMultiTrsIncentiveCSQL SQL");
				 //History save
				 int resultHis = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOMultiTrsIncentiveHisCSQL() , param, param);
				 if(resultHis == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to CreditIncentiveStatusDBDAOMultiTrsIncentiveHisCSQL SQL");
			 }	
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }
	 
		/**
	  * Credti & Invcentive Status TRS Incentive Delete. <br>
	  * @param trsStatusIncntVO
	  * @param event
	  * @exception DAOException
	  */
	 public void removeTrsIncentive(TrsStatusIncntVO trsStatusIncntVO, EsdEas0501Event event) throws DAOException {

		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");

			 if(trsStatusIncntVO != null){
				 //query parameter
				 Map<String, String> mapVO = trsStatusIncntVO.getColumnValues();
				 param.putAll(mapVO);
				 
				 param.put("usr_id", event.getSignOnUserAccount().getUsr_id());
				 int result = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAORemoveTrsIncentiveDSQL() , param, param);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to CreditIncentiveStatusDBDAORemoveTrsIncentiveDSQL SQL");
				 //History save
				 int resultHis = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOMultiTrsIncentiveHisCSQL() , param, param);
				 if(resultHis == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to CreditIncentiveStatusDBDAOMultiTrsIncentiveHisCSQL SQL");
			 }	
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }	 

	/**
	  * Credti & Invcentive Status TRS Incentive File Attach <br>
	  * @param event
	  * @exception DAOException
	  */
	 public void modifyTrsFileAttach(EsdEas0501Event event) throws DAOException {

		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");

			 param.put("bse_yr",event.getStrBseYr());
			 param.put("incnt_no",event.getStrIncntNo());
			 param.put("atch_file_lnk_id",event.getStrAtchFileLnkId());			 
			 param.put("usr_id", event.getSignOnUserAccount().getUsr_id());
			 int result = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOModifyTrsFileAttachUSQL() , param, param);
			 if(result == Statement.EXECUTE_FAILED)
				 throw new DAOException("Fail to CreditIncentiveStatusDBDAOModifyTrsFileAttachUSQL SQL");
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }	
		/**
	  * Credti & Invcentive Status TRS Incentive File Attach <br>
	  * @param event
	  * @exception DAOException
	  */
	 public void modifyTrsFileAttach2(EsdEas0501Event event) throws DAOException {

		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");

			 param.put("bse_yr",event.getStrBseYr());
			 param.put("incnt_no",event.getStrIncntNo());
			 param.put("atch_file_lnk_id",event.getStrAtchFileLnkId());			 
			 param.put("usr_id", event.getSignOnUserAccount().getUsr_id());
			 int result = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOModifyTrsFileAttach2USQL() , param, param);
			 if(result == Statement.EXECUTE_FAILED)
				 throw new DAOException("Fail to CreditIncentiveStatusDBDAOModifyTrsFileAttach2USQL SQL");
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }	 	 
	 
	/**
	 * Credti & Invcentive Status Transportation 조회한다. <br>
	 * 
	 * @param event
	 * @return List<VslStatusIncntVO>
	 * @exception EventException
	 */
	public List<VslStatusIncntVO> searchVslIncentiveList(EsdEas0501Event event)	throws DAOException {
		DBRowSet dbRowset = null;
		List<VslStatusIncntVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			
			param.put("s_rhq_cd", event.getStrRhqCd());
			param.put("s_inv_ofc_cd", event.getStrInvOfcCd());
			param.put("s_bse_yr", event.getStrBseYr());
			param.put("s_inv_vndr_seq", event.getStrInvVndrSeq());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CreditIncentiveStatusDBDAOSearchVslIncentiveListRSQL(),param, param);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,VslStatusIncntVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	  * Credti & Invcentive Status VSL Incentive 저장한다. <br>
	  * @param vslStatusIncntVO
	  * @param event
	  * @exception DAOException
	  */
	 public void multiVslIncentive(VslStatusIncntVO vslStatusIncntVO, EsdEas0501Event event) throws DAOException {

		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 DBRowSet dbRowset = null;

			 if(vslStatusIncntVO != null){
				 //query parameter
				 Map<String, String> mapVO = vslStatusIncntVO.getColumnValues();
				 param.putAll(mapVO);
				 
				 //신규 저장일 경우
				 if(vslStatusIncntVO.getIncntNo().equals("")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CreditIncentiveStatusDBDAOSearchVslIncntNoRSQL(),param, param);;
					while(dbRowset.next()){
						param.put("incnt_no",dbRowset.getString("INCNT_NO"));						
					}
				 }
				 param.put("usr_id", event.getSignOnUserAccount().getUsr_id());
				 int result = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOMultiVslIncentiveCSQL() , param, param);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to CreditIncentiveStatusDBDAOMultiVslIncentiveCSQL SQL");
				 //History save
				 int resultHis = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOMultiVslIncentiveHisCSQL() , param, param);
				 if(resultHis == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to CreditIncentiveStatusDBDAOMultiVslIncentiveHisCSQL SQL");
			 }	
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }

		/**
	  * Credti & Invcentive Status VSL Incentive Delete. <br>
	  * @param vslStatusIncntVO
	  * @param event
	  * @exception DAOException
	  */
	 public void removeVslIncentive(VslStatusIncntVO vslStatusIncntVO, EsdEas0501Event event) throws DAOException {

		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");

			 if(vslStatusIncntVO != null){
				 //query parameter
				 Map<String, String> mapVO = vslStatusIncntVO.getColumnValues();
				 param.putAll(mapVO);
				 
				 param.put("usr_id", event.getSignOnUserAccount().getUsr_id());
				 int result = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAORemoveVslIncentiveDSQL() , param, param);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to CreditIncentiveStatusDBDAORemoveVslIncentiveDSQL SQL");
				 //History save
				 int resultHis = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOMultiVslIncentiveHisCSQL() , param, param);
				 if(resultHis == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to CreditIncentiveStatusDBDAOMultiVslIncentiveHisCSQL SQL");
			 }	
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }
	 
	/**
	  * Credti & Invcentive Status TRS Incentive File Attach <br>
	  * @param event
	  * @exception DAOException
	  */
	 public void modifyVslFileAttach(EsdEas0501Event event) throws DAOException {

		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");

			 param.put("bse_yr",event.getStrBseYr());
			 param.put("incnt_no",event.getStrIncntNo());
			 param.put("atch_file_lnk_id",event.getStrAtchFileLnkId());			 
			 param.put("usr_id", event.getSignOnUserAccount().getUsr_id());
			 int result = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOModifyVslFileAttachUSQL() , param, param);
			 if(result == Statement.EXECUTE_FAILED)
				 throw new DAOException("Fail to CreditIncentiveStatusDBDAOModifyVslFileAttachUSQL SQL");
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }	 
	 
		/**
	  * Credti & Invcentive Status TRS Incentive File Attach <br>
	  * @param event
	  * @exception DAOException
	  */
	 public void modifyVslFileAttach2(EsdEas0501Event event) throws DAOException {

		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");

			 param.put("bse_yr",event.getStrBseYr());
			 param.put("incnt_no",event.getStrIncntNo());
			 param.put("atch_file_lnk_id",event.getStrAtchFileLnkId());			 
			 param.put("usr_id", event.getSignOnUserAccount().getUsr_id());
			 int result = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOModifyVslFileAttach2USQL() , param, param);
			 if(result == Statement.EXECUTE_FAILED)
				 throw new DAOException("Fail to CreditIncentiveStatusDBDAOModifyVslFileAttach2USQL SQL");
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }		 
	
	/**
	 * Credti & Invcentive Status M&R Credit Issue 조회한다. <br>
	 * 
	 * @param event
	 * @return List<MnrStatusCrIssVO>
	 * @exception EventException
	 */
	public List<MnrStatusCrIssVO> searchMnrCreditIssueList(EsdEas0501Event event)	throws DAOException {
		DBRowSet dbRowset = null;
		List<MnrStatusCrIssVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("s_fm_dt",event.getStrFmDt());
			param.put("s_to_dt",event.getStrToDt());
			param.put("s_mkr_cd",event.getStrMkrCd());
			param.put("s_cr_usd_ofc_cd",event.getStrCrUsdOfcCd());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CreditIncentiveStatusDBDAOSearchMnrCreditIssueListRSQL(),param, param);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,MnrStatusCrIssVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	  * Credti & Invcentive Status M&R Credit Issue 저장한다. <br>
	  * @param mnrStatusCrIssVO MnrStatusCrIssVO
	  * @param event
	  * @exception DAOException
	  */
	 public void multiMnrCreditIssue(MnrStatusCrIssVO mnrStatusCrIssVO, EsdEas0501Event event) throws DAOException {

		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 DBRowSet dbRowset = null;

			 if(mnrStatusCrIssVO != null){
				 //query parameter
				 Map<String, String> mapVO = mnrStatusCrIssVO.getColumnValues();
				 param.putAll(mapVO);
				 
				 //신규 저장일 경우
				 if(mnrStatusCrIssVO.getCrIssNo().equals("")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CreditIncentiveStatusDBDAOSearchMnrCrIssNoRSQL(),param, param);;
					while(dbRowset.next()){
						param.put("cr_iss_no",dbRowset.getString("CR_ISS_NO"));						
					}
				 }
				 param.put("usr_id", event.getSignOnUserAccount().getUsr_id());
				 int result = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOMultiMnrCreditIssueCSQL() , param, param);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to CreditIncentiveStatusDBDAOMultiMnrCreditIssueCSQL SQL");
				 //History save
				 int resultHis = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOMultiMnrCreditIssueHisCSQL() , param, param);
				 if(resultHis == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to CreditIncentiveStatusDBDAOMultiMnrCreditIssueHisCSQL SQL");
			 }	
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }

	/**
	  * Credti & Invcentive Status M&R Credit Issue Delete. <br>
	  * @param mnrStatusCrIssVO MnrStatusCrIssVO
	  * @param event
	  * @exception DAOException
	  */
	 public void removeMnrCreditIssue(MnrStatusCrIssVO mnrStatusCrIssVO, EsdEas0501Event event) throws DAOException {

		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");

			 if(mnrStatusCrIssVO != null){
				 //query parameter
				 Map<String, String> mapVO = mnrStatusCrIssVO.getColumnValues();
				 param.putAll(mapVO);
				 
				 param.put("usr_id", event.getSignOnUserAccount().getUsr_id());
				 int result = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAORemoveMnrCreditIssueDSQL() , param, param);
				 int resultUsd = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAORemoveMnrCreditUsedDSQL() , param, param);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to CreditIncentiveStatusDBDAORemoveMnrCreditIssueDSQL SQL");
				 if(resultUsd == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to CreditIncentiveStatusDBDAORemoveMnrCreditUsedDSQL SQL");
				 //History save
				 int resultHis = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOMultiMnrCreditIssueHisCSQL() , param, param);
				 if(resultHis == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to CreditIncentiveStatusDBDAOMultiMnrCreditIssueHisCSQL SQL");
			 }	
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }
	 
	/**
	  * Credti & Invcentive Status M&R Incentive File Attach <br>
	  * @param event
	  * @exception DAOException
	  */
	 public void modifyMnrFileAttach(EsdEas0501Event event) throws DAOException {

		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");

			 param.put("bse_yr",event.getStrBseYr());
			 param.put("cr_iss_no",event.getStrCrIssNo());
			 param.put("atch_file_lnk_id",event.getStrAtchFileLnkId());			 
			 param.put("usr_id", event.getSignOnUserAccount().getUsr_id());
			 int result = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOModifyMnrFileAttachUSQL() , param, param);
			 if(result == Statement.EXECUTE_FAILED)
				 throw new DAOException("Fail to CreditIncentiveStatusDBDAOModifyMnrFileAttachUSQL SQL");
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }		
	 
		/**
	  * Credti & Invcentive Status M&R Incentive File Attach <br>
	  * @param event
	  * @exception DAOException
	  */
	 public void modifyMnrFileAttach2(EsdEas0501Event event) throws DAOException {

		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");

			 param.put("bse_yr",event.getStrBseYr());
			 param.put("cr_iss_no",event.getStrCrIssNo());
			 param.put("cr_usd_seq",event.getStrCrUsdSeq());
			 param.put("atch_file_lnk_id",event.getStrAtchFileLnkId());			 
			 param.put("usr_id", event.getSignOnUserAccount().getUsr_id());
			 int result = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOModifyMnrFileAttach2USQL() , param, param);
			 if(result == Statement.EXECUTE_FAILED)
				 throw new DAOException("Fail to CreditIncentiveStatusDBDAOModifyMnrFileAttach2USQL SQL");
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }	 
	 
	/**
	 * Credti & Invcentive Status M&R Credit Used 조회한다. <br>
	 * 
	 * @param event
	 * @return List<MnrStatusCrUsdVO>
	 * @exception EventException
	 */
	public List<MnrStatusCrUsdVO> searchMnrCreditUsedList(EsdEas0501Event event)	throws DAOException {
		DBRowSet dbRowset = null;
		List<MnrStatusCrUsdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("cr_iss_no",event.getStrCrIssNo());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CreditIncentiveStatusDBDAOSearchMnrCreditUsedListRSQL(),param, param);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,MnrStatusCrUsdVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	  * Credti & Invcentive Status M&R Credit Issue 저장한다. <br>
	  * @param mnrStatusCrUsdVO mnrStatusCrUsdVO
	  * @param event
	  * @exception DAOException
	  */
	 public void multiMnrCreditUsed(MnrStatusCrUsdVO mnrStatusCrUsdVO, EsdEas0501Event event) throws DAOException {

		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 DBRowSet dbRowset = null;

			 if(mnrStatusCrUsdVO != null){
				 //query parameter
				 Map<String, String> mapVO = mnrStatusCrUsdVO.getColumnValues();
				 param.putAll(mapVO);
				 
				 //신규 저장일 경우
				 if(mnrStatusCrUsdVO.getCrUsdSeq().equals("")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CreditIncentiveStatusDBDAOSearchMnrCrUsdSeqRSQL(),param, param);;
					while(dbRowset.next()){
						param.put("cr_usd_seq",dbRowset.getString("CR_USD_SEQ"));						
					}
				 }
				 param.put("usr_id", event.getSignOnUserAccount().getUsr_id());
				 int result = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOmultiMnrCreditUsedCSQL() , param, param);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to CreditIncentiveStatusDBDAOmultiMnrCreditUsedCSQL SQL");
				 //History save
				 int resultHis = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOMultiMnrCreditUsedHisCSQL() , param, param);
				 if(resultHis == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to CreditIncentiveStatusDBDAOMultiMnrCreditUsedHisCSQL SQL");
			 }	
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }

		/**
	  * Credti & Invcentive Status M&R Credit Issue Delete. <br>
	  * @param mnrStatusCrUsdVO mnrStatusCrUsdVO
	  * @param event
	  * @exception DAOException
	  */
	 public void removeMnrCreditUsed(MnrStatusCrUsdVO mnrStatusCrUsdVO, EsdEas0501Event event) throws DAOException {

		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");

			 if(mnrStatusCrUsdVO != null){
				 //query parameter
				 Map<String, String> mapVO = mnrStatusCrUsdVO.getColumnValues();
				 param.putAll(mapVO);
				 
				 param.put("usr_id", event.getSignOnUserAccount().getUsr_id());
				 int result = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAORemoveMnrCreditUsedDSQL() , param, param);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to CreditIncentiveStatusDBDAORemoveMnrCreditUsedDSQL SQL");
				 //History save
				 int resultHis = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOMultiMnrCreditUsedHisCSQL() , param, param);
				 if(resultHis == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to CreditIncentiveStatusDBDAOMultiMnrCreditIssueHis SQL");
			 }	
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }	 
	
	/**
	 * Credti & Invcentive Status Mileage Credit 조회한다. <br>
	 * @param event
	 * @return List<BnfStatusMlgVO>
	 * @exception EventException
	 */
	public List<BnfStatusMlgVO> searchMileageList(EsdEas0501Event event)	throws DAOException {
		DBRowSet dbRowset = null;
		List<BnfStatusMlgVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {

			param.put("s_fm_dt",event.getStrFmDt());
			param.put("s_to_dt",event.getStrToDt());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CreditIncentiveStatusDBDAOSearchMileageListRSQL(),param, param);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,BnfStatusMlgVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
 	  * Credti & Invcentive Status Mileage 저장한다. <br>
	  * @param bnfStatusMlgVO BnfStatusMlgVO
	  * @param event
	  * @exception DAOException
	  */
	 public void multiMileage(BnfStatusMlgVO bnfStatusMlgVO,EsdEas0501Event event) throws DAOException {

		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 DBRowSet dbRowset = null;

			 if(bnfStatusMlgVO != null){
				 //query parameter
				 Map<String, String> mapVO = bnfStatusMlgVO.getColumnValues();
				 param.putAll(mapVO);
				 
				 //신규 저장일 경우
				 if(bnfStatusMlgVO.getIncntNo().equals("")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CreditIncentiveStatusDBDAOSearchMileageIncntNoRSQL(),param, param);;
					while(dbRowset.next()){
						param.put("incnt_no",dbRowset.getString("INCNT_NO"));						
					}
				 }
				 param.put("usr_id", event.getSignOnUserAccount().getUsr_id());
				 int result = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOMultiMileageCSQL() , param, param);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to CreditIncentiveStatusDBDAOMultiMileageCSQL SQL");
				 //History save
				 int resultHis = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOMultiMileageHisCSQL() , param, param);
				 if(resultHis == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to CreditIncentiveStatusDBDAOMultiMileageHisCSQL SQL");
			 }	
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }
	 
	/**
 	  * Credti & Invcentive Status Mileage Delete. <br>
	  * @param bnfStatusMlgVO BnfStatusMlgVO
	  * @param event
	  * @exception DAOException
	  */
	 public void removeMileage(BnfStatusMlgVO bnfStatusMlgVO,EsdEas0501Event event) throws DAOException {

		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");

			 if(bnfStatusMlgVO != null){
				 //query parameter
				 Map<String, String> mapVO = bnfStatusMlgVO.getColumnValues();
				 param.putAll(mapVO);
				 
				 param.put("usr_id", event.getSignOnUserAccount().getUsr_id());
				 int result = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAORemoveMileageDSQL() , param, param);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to CreditIncentiveStatusDBDAORemoveMileageDSQL SQL");
				 //History save
				 int resultHis = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOMultiMileageHisCSQL() , param, param);
				 if(resultHis == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to CreditIncentiveStatusDBDAOMultiMileageHisCSQL SQL");
			 }	
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }
	 
	/**
 	  * Credti & Invcentive Status Mileage File Attach. <br>
	  * @param event
	  * @exception DAOException
	  */
	 public void modifyMileageFileAttach(EsdEas0501Event event) throws DAOException {

		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 param.put("bse_yr",event.getStrBseYr());
			 param.put("incnt_no",event.getStrIncntNo());
			 param.put("atch_file_lnk_id",event.getStrAtchFileLnkId());
			 param.put("usr_id", event.getSignOnUserAccount().getUsr_id());
			 int result = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOModifyMileageFileAttachUSQL() , param, param);
			 if(result == Statement.EXECUTE_FAILED)
				 throw new DAOException("Fail to CreditIncentiveStatusDBDAOModifyMileageFileAttachUSQL SQL");
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }
	 
		/**
 	  * Credti & Invcentive Status Mileage File Attach. <br>
	  * @param event
	  * @exception DAOException
	  */
	 public void modifyMileageFileAttach2(EsdEas0501Event event) throws DAOException {

		 Map<String, Object> param = new HashMap<String, Object>();
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 param.put("bse_yr",event.getStrBseYr());
			 param.put("incnt_no",event.getStrIncntNo());
			 param.put("atch_file_lnk_id",event.getStrAtchFileLnkId());
			 param.put("usr_id", event.getSignOnUserAccount().getUsr_id());
			 int result = sqlExe.executeUpdate((ISQLTemplate) new CreditIncentiveStatusDBDAOModifyMileageFileAttach2USQL() , param, param);
			 if(result == Statement.EXECUTE_FAILED)
				 throw new DAOException("Fail to CreditIncentiveStatusDBDAOModifyMileageFileAttach2USQL SQL");
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }
	 
		/**
	     * Part Credit Total by Maker 조회한다. <br>
		 * @param event
		 * @return List<TotStatusMkrVO>
		 * @exception EventException
		 */
		public List<TotStatusMkrVO> searchTotalStatusByMakerList(EsdEas0501Event event)	throws DAOException {
			DBRowSet dbRowset = null;
			List<TotStatusMkrVO> list = null;
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();

			try {
				
				param.put("s_fm_dt",event.getStrFmDt());
				param.put("s_to_dt",event.getStrToDt());
				param.put("s_mkr_cd",event.getStrMkrCd());
				param.put("s_cr_usd_ofc_cd",event.getStrCrUsdOfcCd());
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CreditIncentiveStatusDBDAOSearchTotalStatusByMakerListRSQL(),param, param);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset,TotStatusMkrVO.class);
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
		
		/**
		 * EsdEas0501Event  <br>
		 * 유효한 RHQ CODE 조회한다. <br>
		 * 
		 * @param  event
		 * @return String
		 * @exception EventException
		 */
		public String searchCheckRhqOfficeCode(EsdEas0501Event event) throws DAOException{
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			String rtn_val = "";
			param.put("rhq_ofc_cd",event.getRhqOfcCd());
			
			try{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CreditIncentiveStatusDBDAOSearchCheckRhqOfficeCodeRSQL(),param, param);
				while(dbRowset.next()){
					rtn_val = dbRowset.getString("RHQ_OFC_CD");
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return rtn_val;
		}
		
		/**
		 * EsdEas0501Event  <br>
		 * 유효한 Office CODE 조회한다. <br>
		 * 
		 * @param  event
		 * @return String
		 * @exception EventException
		 */
		public String searchCheckOfficeCode(EsdEas0501Event event) throws DAOException{
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			String rtn_val = "";
			param.put("ofc_cd",event.getOfcCd());
			
			try{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CreditIncentiveStatusDBDAOSearchCheckOfficeCodeRSQL(),param, param);
				while(dbRowset.next()){
					rtn_val = dbRowset.getString("OFC_CD");
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return rtn_val;
		}
		
		/**
		 * EsdEas0501Event  <br>
		 * 유효한 Port CODE 조회한다. <br>
		 * 
		 * @param  event
		 * @return String
		 * @exception EventException
		 */
		public String searchCheckPortCode(EsdEas0501Event event) throws DAOException{
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			String rtn_val = "";
			param.put("port_cd",event.getPortCd());
			
			try{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CreditIncentiveStatusDBDAOSearchCheckPortCodeRSQL(),param, param);
				while(dbRowset.next()){
					rtn_val = dbRowset.getString("PORT_CD");
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return rtn_val;
		}
		
		/**
		 * EsdEas0501Event  <br>
		 * TERMINAL의 유효한 YARD CODE CHECK한다. <br>
		 * 
		 * @param  event
		 * @return String
		 * @exception EventException
		 */
		public String searchCheckTesYardCode(EsdEas0501Event event) throws DAOException{
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			String rtn_val = "";
			param.put("yd_cd",event.getYdCd());
			
			try{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CreditIncentiveStatusDBDAOSearchCheckTesYardCodeRSQL(),param, param);
				while(dbRowset.next()){
					rtn_val = dbRowset.getString("YD_CD");
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return rtn_val;
		}
		
		/**
		 * EsdEas0501Event  <br>
		 * TERMINAL의 유효한 COST CODE CHECK한다. <br>
		 * 
		 * @param  event
		 * @return String
		 * @exception EventException
		 */
		public String searchCheckTesCostCode(EsdEas0501Event event) throws DAOException{
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			String rtn_val = "";
			param.put("lgs_cost_cd",event.getLgsCostCd());
			
			try{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CreditIncentiveStatusDBDAOSearchCheckTesCostCodeRSQL(),param, param);
				while(dbRowset.next()){
					rtn_val = dbRowset.getString("LGS_COST_CD");
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return rtn_val;
		}	
		
		/**
		 * EsdEas0501Event  <br>
		 * TRANSPORTATION의 유효한 COST CODE CHECK한다. <br>
		 * 
		 * @param  event
		 * @return String
		 * @exception EventException
		 */
		public String searchCheckTrsCostCode(EsdEas0501Event event) throws DAOException{
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			String rtn_val = "";
			param.put("lgs_cost_cd",event.getLgsCostCd());
			
			try{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CreditIncentiveStatusDBDAOSearchCheckTrsCostCodeRSQL(),param, param);
				while(dbRowset.next()){
					rtn_val = dbRowset.getString("LGS_COST_CD");
				}
			} catch (SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return rtn_val;
		}
}