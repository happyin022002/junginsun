/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EacMgtDBDAO.java
*@FileTitle : Expense Audit case Registration
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.29
*@LastModifier : 백형인
*@LastVersion : 1.0
* 2014.10.29 백형인
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.eac.eacmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.hanjin.apps.alps.esd.eas.eac.eacmgt.basic.EacMgtBCImpl;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.AutoAuditFileVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACCdVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACCfmVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACEditVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACInqEacVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACInqVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACNtcHisVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACNtcVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACOfcCfgVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACPsonCfgVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACRgstVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACSpCtrtVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EACTpbDtlVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EacFileInVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EacFileOutVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.EacSearchVO;
import com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo.SearchMonthExchangeVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.candidateconfirm.vo.SearchCandidateListVO;
import com.hanjin.apps.alps.esd.tpb.common.combo.integration.CommonCodeDBDAOSearchCheckTrdPartyRSQL;
import com.hanjin.framework.component.fax.FaxMetaInfo;
import com.hanjin.framework.component.fax.FaxUtility;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.CheckUtils;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;

/**
 * ALPS EacMgtDBDAO <br>
 * - ALPS-Eac system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HI
 * @see EacMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class EacMgtDBDAO extends DBDAOSupport {

	 
	 /**
	  * 공통 테이블에 담긴 값을 조회한다.<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EacSearchVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EacSearchVO> searchCommonCombo(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EacSearchVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOExpenseTypeRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EacSearchVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
	 /**
	  * EAC Type 명을 조회한다.<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EacSearchVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EacSearchVO> searchBilTpCd(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EacSearchVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOEACType2RSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EacSearchVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
	 /**
	  * 로그한 유저의 ofc 레벨을 조회한다.<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EacSearchVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EacSearchVO> searchOfcLvl(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EacSearchVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOOffceLvlRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EacSearchVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
	 /**
	  * 로그한 유저의 ofc 레벨과 초기필요값을 조회한다..<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EacSearchVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EacSearchVO> searchOfcLvlPls(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EacSearchVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchOfcLvlPlsRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EacSearchVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
	 /**
	  * S/P Code 의 명칭을 조회한다.<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EacSearchVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EacSearchVO> searchVendor(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EacSearchVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchVendorRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EacSearchVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }

	 /**
	  * Responsible Office 에 값이 존재하는지 체크 한다.<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EacSearchVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EacSearchVO> chkResponsibleOffice(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EacSearchVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOChkResponsibleOfficeRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EacSearchVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
	 /**
	  * Location 에 값이 존재하는지 체크 한다.<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EacSearchVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EacSearchVO> validLoc(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EacSearchVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOChkLocationRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EacSearchVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
	 
	 /**
	  * Location 에 값이 존재하는지 체크 한다.<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EacSearchVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EacSearchVO> validYard(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EacSearchVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOChkYardCodeRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EacSearchVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
	 /**
	  * Currency 콤보데이터를 조회한다.<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EacSearchVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EacSearchVO> searchCurrency(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EacSearchVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchCurrencyRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EacSearchVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }

	 /**
	  * Currency 콤보데이터를 조회한다(본부).<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EacSearchVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EacSearchVO> searchCurrencyH(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EacSearchVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchCurrencyHRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EacSearchVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
	 /**
	  * Exchange Rate를 조회한다.<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EacSearchVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EacSearchVO> searchUsdXch(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EacSearchVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOExchangeRateRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EacSearchVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	 
	 
	 /**
	  * EAC Registration 데이터를 저장한다.<br>
	  * 
	  * @param EACRgstVO eacRegistrationVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void multiEacReg(EACRgstVO eacRegistrationVO) throws DAOException {
		 
		 try{
				SQLExecuter sqlExe = new SQLExecuter("");
				
				if(eacRegistrationVO != null){
					//query parameter
					Map<String, String> param = eacRegistrationVO.getColumnValues();
			        int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOInsertEACRegistrationCSQL() , param, null);
					
					if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
					
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
	  * EAS_EXPN_AUD_CS_MGMT 수정.<br>
	  * 
	  * @param EACRgstVO eacRegistrationVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void updateEacReg(EACRgstVO eacRegistrationVO) throws DAOException {
		 
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(eacRegistrationVO != null){
				 //query parameter
				 Map<String, String> param = eacRegistrationVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOUpdateEACRegistrationUSQL() , param, null);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
				 
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
	  * TPB I/F 정보를 저장한다. <br>
	  * 
	  * @param EACRgstVO eacRegistrationVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void multiN3rdPtyEacReg(EACRgstVO eacRegistrationVO) throws DAOException {
		 
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(eacRegistrationVO != null){
				 //query parameter
				 Map<String, String> param = eacRegistrationVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOInsertEACRegistrationN3rdPtyCSQL() , param, null);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
				 
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
	  * TPB I/F 정보를 수정. <br>
	  * 
	  * @param EACRgstVO eacRegistrationVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void updateN3rdPtyEacReg(EACRgstVO eacRegistrationVO) throws DAOException {
		 
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(eacRegistrationVO != null){
				 //query parameter
				 Map<String, String> param = eacRegistrationVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOUpdateEACRegistrationN3rdPtyUSQL() , param, null);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
				 
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
	  * TPB I/F 상세정보를 저장한다. <br>
	  * 
	  * @param EACTpbDtlVO eacTpbDtlVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void multiN3rdPtyDtlEacReg(EACTpbDtlVO eacTpbDtlVO) throws DAOException {
		 
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(eacTpbDtlVO != null){
				 //query parameter
				 Map<String, String> param = eacTpbDtlVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOInsertEACRegistrationN3rdPtyDtlCSQL() , param, null);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
				 
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
	  * TPB I/F 상세정보를 수정한다. <br>
	  * 
	  * @param EACTpbDtlVO eacTpbDtlVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void updateN3rdPtyDtlEacReg(EACTpbDtlVO eacTpbDtlVO) throws DAOException {
		 
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(eacTpbDtlVO != null){
				 //query parameter
				 Map<String, String> param = eacTpbDtlVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOUpdateEACRegistrationN3rdPtyDtlUSQL() , param, null);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
				 
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
	  * TPB I/F 상세정보를 삭제한다. <br>
	  * 
	  * @param EACTpbDtlVO eacTpbDtlVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void delN3rdPtyDtlEacReg(EACTpbDtlVO eacTpbDtlVO) throws DAOException {
		 
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(eacTpbDtlVO != null){
				 //query parameter
				 Map<String, String> param = eacTpbDtlVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAODelN3rdPtyDtlEacRegDSQL() , param, null);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
				 
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
	  * EAS_EXPN_AUD_CS_MGMT 키값을 생성한다.<br>
	  * @param SignOnUserAccount account
	  * @return String 
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public String makeEasExpnAudMgmtKey(SignOnUserAccount account) throws DAOException {
		 DBRowSet dbRowset = null;
		 String eacNo = "";
		 
		 
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 
			 
			 
		 try{
			 param.put("ofc_cd", account.getOfc_cd());
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOMakeEasExpnAudMgmtKeyRSQL(), param, null);
			 if(dbRowset.next()){
				 eacNo = dbRowset.getString("eac_no");
			 }
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return eacNo;
	 }	 
	 
	 
	 /**
	  * EAC Registration 을 조회한다.<br>
	  * 
	  * @param EACRgstVO eacRegistrationVO
	  * @return List<EACRgstVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EACRgstVO> searchEacReg(EACRgstVO eacRegistrationVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EACRgstVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacRegistrationVO != null){
				 Map<String, String> mapVO = eacRegistrationVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchEacRegistrationRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EACRgstVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	 
	 
	 
	 /**
	  * EAC Tpb DTL Grid 를 조회한다.<br>
	  * 
	  * @param EACRgstVO eacRegistrationVO
	  * @return List<EACTpbDtlVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EACTpbDtlVO> searchTrpDtlGrid(EACRgstVO eacRegistrationVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EACTpbDtlVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacRegistrationVO != null){
				 Map<String, String> mapVO = eacRegistrationVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchTpbDtlRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EACTpbDtlVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	 
	 
	 /**
	  * TPB I/F 후 TPB 정보를 조회한다.<br>
	  * 
	  * @param String n3ptyno
	  * @return List<EACRgstVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EACRgstVO> searchTPB(String n3ptyno) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EACRgstVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(n3ptyno != null){
				 param.put("n3pty_no", n3ptyno);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchTPBRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EACRgstVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	 

	 /**
	  * Rejection Notice Tab 을 조회한다.<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EACRgstVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EACRgstVO> searchEacRjctNtc(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EACRgstVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO.getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchRejectionNoticeTabRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EACRgstVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	 
	 
	 /**
	  * Contact Point 콤보값을 조회한다.<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EacSearchVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EacSearchVO> searchCntcPnt(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EacSearchVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO.getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOComboContactPointRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EacSearchVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	 
	 
	 
	 /**
	  * RHQ OFFCE 콤보값을 조회한다.<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EacSearchVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EacSearchVO> searchRhqList(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EacSearchVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchRhqListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EacSearchVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	 
	 
	 /**
	  * TPB I/F 내역 조회.<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return DBRowSet
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public DBRowSet searchTpbIfInfo(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchTpbIfInfoRSQL(), param, velParam);
			 
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
	  * I/F 후 N3PTY_NO update 한다.<br>
	  * 
	  * @param String n3pty_no
	  * @param String eac_no
	  * @param String upd_usr_id
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void updateN3rdPty(String  n3pty_no,String  eac_no,String  upd_usr_id) throws DAOException {
		 SQLExecuter sqlExe = new SQLExecuter("");
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 
		 try{
			 param.put("n3pty_no", n3pty_no);
			 param.put("eac_no", eac_no);
			 param.put("upd_usr_id", upd_usr_id);
			 int result = sqlExe.executeUpdate((ISQLTemplate)new EacMgtDBDAOUpdateN3rdPtyN3ptyNoUSQL(), param, null);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }	 
	 
	 /**
	  * TPB I/F 내역 조회.<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<CreateTPBCandidateVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchCandidateListVO> searchTpbIfInfo2(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchCandidateListVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchTpbIfInfoRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCandidateListVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	 
	 
	 /**
	  * OFFCE 콤보값을 조회한다.<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EacSearchVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EacSearchVO> searchOfcList(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EacSearchVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchOfcListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EacSearchVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	 
	 
	 /**
	  * Expense Audit case Registration 저장전 중복된 데이터 인지 확인한다.<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EacSearchVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EacSearchVO> verifyEacReg(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EacSearchVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchVerifyEacRegRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EacSearchVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	 
	 
	 /**
	  * Booking No 가 존재하는지 확인한다. <br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EacSearchVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EacSearchVO> verifyBkgNO(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EacSearchVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchVerifyBkgNORSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EacSearchVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	 
	 
	 /**
	  * I/F 전에 중복 여부를 체크한다. <br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EacSearchVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EacSearchVO> verifyTpbIf(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EacSearchVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchVerifyTpbIfRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EacSearchVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	 
	 
	 /**
	  * Responsible Office 가 TPB 에 등록된 office 인지 확인한다. <br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EacSearchVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EacSearchVO> verifyTpbOfc(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EacSearchVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchVerifyTpbOfcRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EacSearchVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	 
	 
	 /**
	  * Personnel Config, Office Config 가 등록되어 있는지 확인하고 발송자 메일 정보를 조회한다.<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @param SignOnUserAccount account
	  * @return List<EacSearchVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EacSearchVO> searchPsonCfg(EacSearchVO eacSearchVO,SignOnUserAccount account) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EacSearchVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 eacSearchVO.setUsrId(account.getUsr_id());
		 eacSearchVO.setOfcCd(account.getOfc_cd());
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchPsonCfgRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EacSearchVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	 
	 
	 /**
	  * 입력한 3rdParty Value 값이 유효한지 체크한다. <br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EacSearchVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EacSearchVO> verify3rdVale(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EacSearchVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 String s_trd_party_val = eacSearchVO.getSTrdPartyVal();
		 String s_vndr_cust_div_cd = eacSearchVO.getSVndrCustDivCd();
		 String tmpNumberStr = "";

		   // 숫자형이 되어야할 값이 아닐 경우 s_vndr_cust_div_cd를 ""으로 바꾸어 무효화 시킨다.  
			if ( s_vndr_cust_div_cd.equals("V")) {
				tmpNumberStr = s_trd_party_val;
			}else if(s_vndr_cust_div_cd.equals("C")) {
			 	if ( s_trd_party_val.length() >= 2 ){
					tmpNumberStr = s_trd_party_val.substring(2);
				} else {
					s_vndr_cust_div_cd = "";
				}
			}
			
			if ( tmpNumberStr.length() > 0 ){
				//2010.09.14 변종건 [CHM-201005591-01]	 [TPB] 소스품질 결함 사항 정리
			    if(!CheckUtils.isInOnlyNumber(tmpNumberStr)){
			        s_vndr_cust_div_cd = "";
			        s_trd_party_val = "";     
			    }
			}			
		 
		 try{
			 if(eacSearchVO != null){
				param.put("s_trd_party_val", s_trd_party_val);
				velParam.put("s_vndr_cust_div_cd", s_vndr_cust_div_cd);
				
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CommonCodeDBDAOSearchCheckTrdPartyRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EacSearchVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	 
	 
	 /**
	  * S/P Contact point 의 Contact point 을 조회한다.<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EACSpCtrtVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EACSpCtrtVO> searchVndrList(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EACSpCtrtVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOMDMSPInformationRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EACSpCtrtVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	 
	 
	 /**
	  * S/P Contact point 의  MDM S/P Information 을 조회한다.<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EACSpCtrtVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EACSpCtrtVO> searchVndrCntc(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EACSpCtrtVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchContactPointRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EACSpCtrtVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	 
	 
	 /**
	  * SP Contact point 를 저장한다.<br>
	  * 
	  * @param EACSpCtrtVO eacSpContactPointVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void multiVndrCntc(EACSpCtrtVO eacSpContactPointVO)  throws DAOException {
			//query parameter
		 try{
			 
				SQLExecuter sqlExe = new SQLExecuter("");
				if(eacSpContactPointVO != null){
					//query parameter
					Map<String, String> param = eacSpContactPointVO.getColumnValues();
			        int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOInsertSPContactPointCSQL() , param, null);
					
					if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
					
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
	  * SP Contact point 를 수정한다.<br>
	  * 
	  * @param EACSpCtrtVO eacSpContactPointVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void updateVndrCntc(EACSpCtrtVO eacSpContactPointVO) throws DAOException {
		 
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(eacSpContactPointVO != null){
				 //query parameter
				 Map<String, String> param = eacSpContactPointVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOUpdateVndrCntcUSQL() , param, null);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
				 
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
	  * Office Config 를 저장전 이미 등록된 offce 인지 확인한다.<br>
	  * 
	  * @param EACOfcCfgVO eacOfficeConfigVO
	  * @return String
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public String searchEacOfcSubsist(EACOfcCfgVO eacOfficeConfigVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 String cntFlag ="0";
		 try{
			 if(eacOfficeConfigVO != null){
				 Map<String, String> mapVO = eacOfficeConfigVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchEacOfcSubsistRSQL(), param, velParam);
			 if(dbRowset.next()){
				 cntFlag = dbRowset.getString("cnt");
			 }
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return cntFlag;
	 }	 
	 
	 /**
	  * Office Config 를 저장한다.<br>
	  * 
	  * @param EACOfcCfgVO eacOfficeConfigVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void multiEacOfc(EACOfcCfgVO eacOfficeConfigVO) throws DAOException {
		 
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(eacOfficeConfigVO != null){
				 //query parameter
				 Map<String, String> param = eacOfficeConfigVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOInsertEacOfcCSQL() , param, null);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
				 
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
	  * Office Config 를 수정한다.<br>
	  * 
	  * @param EACOfcCfgVO eacOfficeConfigVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void updateEacOfc(EACOfcCfgVO eacOfficeConfigVO) throws DAOException {
		 
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(eacOfficeConfigVO != null){
				 //query parameter
				 Map<String, String> param = eacOfficeConfigVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOUpdateEacOfcUSQL() , param, null);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
				 
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
	  * Office Config 를 조회한다.<br>
	  * 
	  * @param EACOfcCfgVO eacOfficeConfigVO
	  * @return List<EACOfficeConfigVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EACOfcCfgVO> searchEacOfc(EACOfcCfgVO eacOfficeConfigVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EACOfcCfgVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacOfficeConfigVO != null){
				 Map<String, String> mapVO = eacOfficeConfigVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchEacOfcRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EACOfcCfgVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	 	 
	 
	 /**
	  * Personnel Config 를 저장전 이미 등록된 Personnel 인지 확인한다.<br>
	  * 
	  * @param EACPsonCfgVO eacPersonnelConfigVO
	  * @return String
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public String searchEacPsnSubsist(EACPsonCfgVO eacPersonnelConfigVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 String cntFlag ="0";
		 try{
			 if(eacPersonnelConfigVO != null){
				 Map<String, String> mapVO = eacPersonnelConfigVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchEacPsnSubsistRSQL(), param, velParam);
			 if(dbRowset.next()){
				 cntFlag = dbRowset.getString("cnt");
			 }
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return cntFlag;
	 }	 
	 
	 /**
	  * Personnel Config 를 저장한다.<br>
	  * 
	  * @param EACPsonCfgVO eacPersonnelConfigVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void multiEacPsn(EACPsonCfgVO eacPersonnelConfigVO) throws DAOException {
		 
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(eacPersonnelConfigVO != null){
				 //query parameter
				 Map<String, String> param = eacPersonnelConfigVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOInsertEacPsnCSQL() , param, null);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
				 
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
	  * Personnel Config 를 수정한다.<br>
	  * 
	  * @param EACPsonCfgVO eacPersonnelConfigVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void updateEacPsn(EACPsonCfgVO eacPersonnelConfigVO) throws DAOException {
		 
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(eacPersonnelConfigVO != null){
				 //query parameter
				 Map<String, String> param = eacPersonnelConfigVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOUpdateEacPsnUSQL() , param, null);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
				 
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
	  * Personnel Config 를 삭제한다.<br>
	  * 
	  * @param EACPsonCfgVO eacPersonnelConfigVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void deleteEacPsn(EACPsonCfgVO eacPersonnelConfigVO) throws DAOException {
		 
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(eacPersonnelConfigVO != null){
				 //query parameter
				 Map<String, String> param = eacPersonnelConfigVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAODeleteEacPsnDSQL() , param, null);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
				 
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
	  * Personnel Config 를 조회한다.<br>
	  * 
	  * @param EACPsonCfgVO eacPersonnelConfigVO
	  * @return List<EACPersonnelConfigVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EACPsonCfgVO> searchEacPsn(EACPsonCfgVO eacPersonnelConfigVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EACPsonCfgVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacPersonnelConfigVO != null){
				 Map<String, String> mapVO = eacPersonnelConfigVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchEacPsnRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EACPsonCfgVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	 	 
	 
	 /**
	  * Personnel Config Inquiry 를 삭제한다.<br>
	  * 
	  * @param EACPsonCfgVO eacPersonnelConfigVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void deleteEacPsnList(EACPsonCfgVO eacPersonnelConfigVO) throws DAOException {
		 
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(eacPersonnelConfigVO != null){
				 //query parameter
				 Map<String, String> param = eacPersonnelConfigVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAODeleteEacPsnDSQL() , param, null);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
				 
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
	  * Personnel Config Inquiry 를 조회한다.<br>
	  * 
	  * @param EACPsonCfgVO eacPersonnelConfigVO
	  * @return List<EACPersonnelConfigVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EACPsonCfgVO> searchEacPsnList(EACPsonCfgVO eacPersonnelConfigVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EACPsonCfgVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacPersonnelConfigVO != null){
				 Map<String, String> mapVO = eacPersonnelConfigVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchEacPsnListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EACPsonCfgVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
	 
	 /**
	  * EAC 등록 자료를 리스트로 조회한다. (Edit)<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EACEditVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EACEditVO> searchEacEditList(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EACEditVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchEacEditListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EACEditVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
	 }
	 
	 
	 /**
	  * EAC 등록 자료를 리스트로 조회한다. (Edit)<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EACEditVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EACEditVO> searchEacAuditorList(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EACEditVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchEacAuditorListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EACEditVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
	 }
	 
	 
	 
	 /**
	  * EAC 등록 자료를 리스트로 조회한다(Confirm)<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EACEditVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EACCfmVO> searchEacCfmList(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EACCfmVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchEacCfmListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EACCfmVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
	 }
	 
	 
	 /**
	  * Expense Audit Case에서 사용하는 코드 조회<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EACEditVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EACCdVO> searchEacCode(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EACCdVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchEacCodeRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EACCdVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
	 }
	 
	 /**
	  * 등록된 EAC 자료의 상태를 변경한다.<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void modifyEacSts(EacSearchVO eacSearchVO) throws DAOException {
		 
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(eacSearchVO != null){
				 //query parameter
				 Map<String, String> param = eacSearchVO.getColumnValues();
				 
				 Map<String, String> velParam = eacSearchVO.getColumnValues();
				 
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOModifyEacStsUSQL() , param, velParam);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
				 
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
	  * 상태 테이블에 이력을 등록한다.<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void addAproHis(EacSearchVO eacSearchVO) throws DAOException {
		 
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(eacSearchVO != null){
				 //query parameter
				 Map<String, String> param = eacSearchVO.getColumnValues();
				 
				 Map<String, String> velParam = eacSearchVO.getColumnValues();
				 
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOAddAproHisCSQL() , param, velParam);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
				 
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
	  * Expense Audit case 조회 <br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EACInqVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EACInqVO> searchEacReadList(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EACInqVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchEacReadListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EACInqVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return list;
	 }
	 
	 
	 /**
	  * EAC Rejection Notice 메일 발송 <br>
	  * 
	  * @param EACNtcVO eacNtcVO
	  * @exception DAOException
	 * @throws SQLException 
	  */
	 public void sendMail(EACNtcVO eacNtcVO)throws Exception{
		 String emailNo ="";
		 String emailchk ="";
		 String faxNo ="";
		 String faxChk ="";
		 
	        // 1. FaxMetaInfo를 생성한다.
	        //    <Parameter>
	        //    1) sysCd : 시스템 코드 (TPB, TRS 등)
	        //    2) appCd : 업무 코드 (임시적으로 템플릿 파일명으로 정의한다.)
	        //    3) batchInd : Batch 업무 유무 (Y/N)
	        //    4) emailTitle : E-mail 제목
	        //    5) EmailContents : E-mail 내용
			//    6) param : Report 생성시 필요한 Parameter
	        //    7) sendName : sender name
	        //    8) sendEmail : sender email
			//    9) recvEmail : receiver email
			//    10) crtUser : creater
		 
		 String seml_send_no="";
		 try{
			 Map<String, Object> param = new HashMap<String, Object>();
			 param.put("eac_no", eacNtcVO.getEacNo());
			 
			 param.put("ofc_cd", eacNtcVO.getEacOfcCd());
			 param.put("usr_id", eacNtcVO.getCreUsrId());
			 
			 String usr_exist_flag = "";
			 String usr_eml        = "";
//			 String ntc_cc_rcv_eml = "";
			 String ofc_exist_flag = "";
			 
			 DBRowSet dbRowsetChk = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchPsonCfgRSQL(), param,null);
			 if(dbRowsetChk.next()){
				 usr_exist_flag = dbRowsetChk.getString("usr_exist_flag");
				 usr_eml        = dbRowsetChk.getString("usr_eml");
				 ofc_exist_flag = dbRowsetChk.getString("ofc_exist_flag");
			 }
			 
			 
			 //query parameter
			 // 메일정보를 조회한다.
			 DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchSendMailRSQL(), param,null);
			 if(dbRowset.next()){
				 eacNtcVO.setEmlSubjCtnt(dbRowset.getString("eml_subj_ctnt"));
				 eacNtcVO.setEmlCtnt(dbRowset.getString("eml_ctnt"));
				 eacNtcVO.setRcvrFaxNo(dbRowset.getString("fax_no"));
				 eacNtcVO.setRcvrEml(dbRowset.getString("vndr_eml"));
				 eacNtcVO.setRcvrPhnNo(dbRowset.getString("phn_no"));
			 }
			 Mail mail = new Mail();
			 emailNo = eacNtcVO.getRcvrEml();
			 emailchk = eacNtcVO.getEacEmlUseFlg();
			 faxNo = eacNtcVO.getRcvrFaxNo();
			 faxChk = eacNtcVO.getEacFaxUseFlg();
			 
			 
			 
			 
			 
		    	List<ComRptDsgnXptInfoVO> comRptDsgnXptInfoVOs = new ArrayList<ComRptDsgnXptInfoVO>();
	    		
	    		ComRptDsgnXptInfoVO comRptDsgnXptInfoVO = new ComRptDsgnXptInfoVO();
	    		comRptDsgnXptInfoVO.setUpdUsrId(eacNtcVO.getUpdUsrId());
	    		comRptDsgnXptInfoVO.setCreUsrId(eacNtcVO.getCreUsrId());
	    		comRptDsgnXptInfoVO.setRdTmpltNm(eacNtcVO.getRdName());// rd 명칭
	    		comRptDsgnXptInfoVO.setRdParaCtnt(eacNtcVO.getRdParam()); // rd 파라메터
//	    		comRptDsgnXptInfoVO.setRdApplCd(eacNtcVO.getRdName());
	    		comRptDsgnXptInfoVO.setXptFileNm("Rejection Notice("+eacNtcVO.getEacNo()+").pdf");
	    		comRptDsgnXptInfoVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
	    		comRptDsgnXptInfoVOs.add(comRptDsgnXptInfoVO);
	    		if(emailNo!=null && !emailNo.equals("")&&emailchk!=null && emailchk.equals("on")){
	    			mail.setComRptDsgnXptInfoVOs(comRptDsgnXptInfoVOs);
	    			
	    			mail.setBatFlg("N");
	    			mail.setRdSubSysCd("EAS");		
	    			mail.setFrom(usr_eml, eacNtcVO.getRcvrName());  //보내는 사람 메일주소
	    			mail.setSubject(eacNtcVO.getEmlSubjCtnt());  //메일제목
	    			mail.setHtmlContent(eacNtcVO.getEmlCtnt());   //text 로 된 본문 내용
	    			mail.setRecipient(eacNtcVO.getRcvrEml());  //받는 사람 메일주소
	    			mail.setCcRcvrEml(eacNtcVO.getNtcCcRcvEml()); // 참조자
		    		seml_send_no = mail.send();
		    		eacNtcVO.setEmlSndNo(seml_send_no);
		    	} 
	    		
	        	// Fax Utility를 이용하는 것은 SC, BC, DAO 어디에서든 가능하지만...
	        	// DB Transaction이 발생하므로, begin(), commit(), rollback() 처리를 반드시 해주어야 함
	          
	            // 1. FaxMetaInfo를 생성한다.
	            //    <Parameter>
	            //    1) sys_cd : 시스템 코드 (TPB, TRS 등)
	            //    2) app_cd : 업무 코드 (임시적으로 템플릿 파일명으로 정의한다.)
	            //    3) batch_ind : Batch 업무 유무 (Y/N)
	            //    4) title : FAX 제목
	            //    5) param : Report 생성시 필요한 Parameter
	            //    6) rcv_info : 수신자 정보
	            //    7) office : 사용자의 Office 코드
	    		
	    		if(faxNo!=null && !faxNo.equals("") && faxChk!=null && faxChk.equals("on")){
	    			String sysCd = "EAS";
	    			String appCd = eacNtcVO.getRdName();
	    			String batchInd = "N";
	    			String title = eacNtcVO.getEmlSubjCtnt();
	    			String faxParam = eacNtcVO.getRdParam();
	    			String rcvInfo = eacNtcVO.getRcvrFaxNo();
	    			String officeCd = eacNtcVO.getEacOfcCd();
	    			String userId = eacNtcVO.getCreUsrId();
	    			

	    			int faxNo01 = 1;
	    			FaxMetaInfo info = new FaxMetaInfo(sysCd, appCd, batchInd, title, faxParam, faxNo01+";"+rcvInfo, officeCd, userId);
	        		FaxUtility.registerDB(info);
	        		eacNtcVO.setFaxSndNo(info.getSndNo());
	    		}

				 if(eacNtcVO != null){
					 //query parameter
					 int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new EacMgtDBDAOInsertEacNoticeCSQL() , eacNtcVO.getColumnValues(), null);
					 
					 if(result == Statement.EXECUTE_FAILED)
						 throw new DAOException("Fail to update SQL");
					 
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
	  * EAC Rejection Notice 메일 발송 횟수 UPDATE<br>
	  * 
	  * @param EACNtcVO eacNtcVO
	  * @exception DAOException
	 * @throws SQLException 
	  */
	 public void updateNoticeCnt(EACNtcVO eacNtcVO)throws Exception{
		 try{
			 if(eacNtcVO != null){
				 SQLExecuter sqlExe = new SQLExecuter("");				 
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOUpdateEacNoticeCntUSQL() , eacNtcVO.getColumnValues(), null);					 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL"); 
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
	  * EAC 첨부 파일 내역 조회<br>
	  * 
	  * @param EacFileInVO eacFileInVO
	  * @return List<EacFileOutVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EacFileOutVO> searchEacFile(EacFileInVO eacFileInVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EacFileOutVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacFileInVO != null){
				 Map<String, String> mapVO = eacFileInVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchEacFileRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EacFileOutVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
	 /**
	 * EAC의 EAS_EXPN_AUD_CS_ATCH_FILE 추가 데이터를 생성한다.<br>
	 * @author 최종혁
	 * @param List<EacFileOutVO> listVO 데이터객체
	 * @return int
	 * @throws DAOException
	 */
	public int addEacFile(List<EacFileOutVO> listVO) throws DAOException,Exception {
		SQLExecuter sqlExe = new SQLExecuter("");
        int size = listVO.size();
		int insCnt = 0;

        try {
	        if(size > 0) {
	    		//query parameter
	    		Map<String, Object> param = new HashMap<String, Object>();
	    		//velocity parameter
	    		Map<String, Object> velParam = new HashMap<String, Object>();
	        	Iterator<EacFileOutVO> list = listVO.iterator();
	        	while(list.hasNext()){
	        		EacFileOutVO eacFileOutVO = (EacFileOutVO)list.next();
					Map<String, String> mapVO = eacFileOutVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
	    			insCnt = sqlExe.executeUpdate((ISQLTemplate)new EacMgtDBDAOAddEacFileCSQL(), param,velParam);
	    			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
	        	}
	        }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}

	/**
	 *  EAC의 EAS_EXPN_AUD_CS_ATCH_FILE 데이터를 삭제한다.<br>
	 * @author 최종혁
	 * @param List<EacFileOutVO> listVO 데이터객체
	 * @return int
	 * @throws DAOException
	 */
	public int removeEacFile(List<EacFileOutVO> listVO) throws DAOException,Exception {
		SQLExecuter sqlExe = new SQLExecuter("");
        int size = listVO.size();
		int insCnt = 0;

        try {

	        if(size > 0) {
	    		//query parameter
	    		Map<String, Object> param = new HashMap<String, Object>();
	    		//velocity parameter
	    		Map<String, Object> velParam = new HashMap<String, Object>();
	        	Iterator<EacFileOutVO> list = listVO.iterator();
	        	while(list.hasNext()){
	        		EacFileOutVO eacFileOutVO = (EacFileOutVO)list.next();
					Map<String, String> mapVO = eacFileOutVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
	    			insCnt = sqlExe.executeUpdate((ISQLTemplate)new EacMgtDBDAORemoveEacFileDSQL(), param,velParam);
	    			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
	        	}
	        }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	
	 
	 /**
	  * PSO 사전심사에서 EAC로 I/F 후 PSO 테이블에 데이테 입력 <br>
	  * 
	  * @param EACRgstVO eacRegistrationVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void multiEacPSO(EACRgstVO eacRegistrationVO) throws DAOException {
		 
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(eacRegistrationVO != null){
				 //query parameter
				 Map<String, String> param = eacRegistrationVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOUpdatePSOInvUSQL() , param, null);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
				 
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
	  * EAC Rejection Notice History 시퀀스 조회<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EacSearchVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EacSearchVO> searchRjctNtcHis(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EacSearchVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchRjctNtcHisRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EacSearchVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
	 
	 /**
	  * Rejection Notice Send History 내역 조회<br>
	  * 
	  * @param EACNtcHisVO eacNtcHisVO
	  * @return List<EACNtcHisVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EACNtcHisVO> searchRjctNtcSendHis(EACNtcHisVO eacNtcHisVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EACNtcHisVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacNtcHisVO != null){
				 Map<String, String> mapVO = eacNtcHisVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchRjctNtcSendHisRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EACNtcHisVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
	 
	 /**
	  * 메일 발송 정보를 조회한다.<br>
	  * 
	  * @param EACNtcVO eacNtcVO
	  * @return List<EACNtcVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EACNtcVO> searchEacNotice(EACNtcVO eacNtcVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EACNtcVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacNtcVO != null){
				 Map<String, String> mapVO = eacNtcVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchEacNoticeRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EACNtcVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	 
	 
	 
	 /**
	  * 메일 발송 정보를 조회한다.<br>
	  * 
	  * @param EACInqEacVO eacInqEacVO
	  * @return List<EACInqEacVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EACInqEacVO> searchTpbIfDetail(EACInqEacVO eacInqEacVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EACInqEacVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacInqEacVO != null){
				 Map<String, String> mapVO = eacInqEacVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchTpbIfDetailRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EACInqEacVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }	 
	 
	 /**
	  *  Special S/O, Surcharge, Unmatch에서 EAC로 I/F 후 I/F 테이블에 데이터 입력 <br>
	  * 
	  * @param EACRgstVO eacRegistrationVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void multiEacTRS(EACRgstVO eacRegistrationVO) throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 if(eacRegistrationVO != null){
				 //query parameter
				 Map<String, String> param = eacRegistrationVO.getColumnValues();
				 String soNo = eacRegistrationVO.getPIfSoNo();
				 String costCode = eacRegistrationVO.getPIfCostCd();
				 String eacSysIfCd = eacRegistrationVO.getEacSysIfCd();
				 String eacNo = eacRegistrationVO.getEacNo();
				 String usrId = eacRegistrationVO.getAudrUsrId();
				 String subRailSeq = eacRegistrationVO.getPIfSubRailSeq();

				 String arrSoNo[] = soNo.split(",");
				 String arrCostCode[] = costCode.split(",");
				 String arrSubRailSeq[] = subRailSeq.split(",");
				 
				 for(int i=0;i<arrSoNo.length;i++){
					 param.put("trsp_so_ofc_cty_cd",arrSoNo[i].substring(0, 3));	
					 param.put("trsp_so_seq",arrSoNo[i].substring(3));
					 param.put("lgs_cost_cd",arrCostCode[i]);
					 param.put("sub_rail_seq",arrSubRailSeq[i]);
					 param.put("eac_sys_if_cd",eacSysIfCd);
					 param.put("eac_no",eacNo);
					 param.put("usr_id",usrId);
					 
					 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOmultiEacTrsCSQL() , param, null);
					 if(result == Statement.EXECUTE_FAILED)
						 throw new DAOException("Fail to update SQL");
				 }
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
	  *  Rehandling Expense에서 EAC로 I/F 후 I/F 테이블에 데이터 입력 <br>
	  * 
	  * @param EACRgstVO eacRegistrationVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void multiEacRhndChg(EACRgstVO eacRegistrationVO) throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 if(eacRegistrationVO != null){
				 //query parameter
				 Map<String, String> param = eacRegistrationVO.getColumnValues();
				 String vvd         = eacRegistrationVO.getPIfVvd();
				 String vslCd       = "";
				 String skdVoyNo = "";
				 String skdDirCd  = "";
				 
				 if (vvd.length() == 9 ) {
					 vslCd = vvd.substring(0, 4);
					 skdVoyNo = vvd.substring(4, 8);
					 skdDirCd = vvd.substring(8, 9);
				 }
				 
				 String portCd = eacRegistrationVO.getPIfPortCd();
				 String clptIndSeq = eacRegistrationVO.getPIfClptIndSeq();
				 String cntrNo = eacRegistrationVO.getPIfCntrNo();
				 String rhndExpnSeq = eacRegistrationVO.getPIfRhndExpnSeq();
				 String eacNo = eacRegistrationVO.getEacNo();
				 String rhndOfcCd = eacRegistrationVO.getPIfRhndOfcCd();
				 String usrId = eacRegistrationVO.getAudrUsrId();
				 
				 param.put("vsl_cd",vslCd);	
				 param.put("skd_voy_no",skdVoyNo);
				 param.put("skd_dir_cd",skdDirCd);
				 param.put("port_cd",portCd);
				 param.put("clpt_ind_seq",clptIndSeq);
				 param.put("cntr_no",cntrNo);
				 param.put("rhnd_expn_seq",rhndExpnSeq);
				 param.put("rhnd_ofc_cd",rhndOfcCd);
				 param.put("eac_no",eacNo);
				 
				 param.put("usr_id",usrId);

				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOmultiEacRhndChgCSQL() , param, null);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
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
	  *  Drop Off Charge에서 EAC로 I/F 후 I/F 테이블에 데이터 입력 <br>
	  * 
	  * @param EACRgstVO eacRegistrationVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void multiEacDropOff(EACRgstVO eacRegistrationVO) throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 if(eacRegistrationVO != null){
				 //query parameter
				 Map<String, String> param = eacRegistrationVO.getColumnValues();

				 String bkgNo = eacRegistrationVO.getPIfBkgNo();
				 String cntrNo = eacRegistrationVO.getPIfCntrNo();
				 String mtyRtnYdCd = eacRegistrationVO.getPIfMtyRtnYd();
				 String eacNo = eacRegistrationVO.getEacNo();
				 String usrId = eacRegistrationVO.getAudrUsrId();
				 
				 param.put("bkg_no",bkgNo);	
				 param.put("cntr_no",cntrNo);
				 param.put("mty_rtn_yd_cd",mtyRtnYdCd);
				 param.put("eac_no",eacNo);
				 param.put("usr_id",usrId);

				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOmultiEacDropOffCSQL() , param, null);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
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
	  *  Rehandling(BKG COD)에서 EAC로 I/F 후 I/F 테이블에 데이터 입력 <br>
	  * 
	  * @param EACRgstVO eacRegistrationVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void multiEacBkgCod(EACRgstVO eacRegistrationVO) throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 if(eacRegistrationVO != null){
				 //query parameter
				 Map<String, String> param = eacRegistrationVO.getColumnValues();

				 String bkgNo = eacRegistrationVO.getPIfBkgNo();
				 String corrNo = eacRegistrationVO.getPIfCorrNo();
				 String eacNo = eacRegistrationVO.getEacNo();
				 String usrId = eacRegistrationVO.getAudrUsrId();
				 
				 param.put("bkg_no",bkgNo);	
				 param.put("corr_no",corrNo);
				 param.put("eac_no",eacNo);
				 param.put("usr_id",usrId);

				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOMultiEacBkgCodCSQL() , param, null);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
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
	  *  H/Bar Inquiry by History에서 EAC로 I/F 후 I/F 테이블에 데이터 입력 <br>
	  * 
	  * @param EACRgstVO eacRegistrationVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void multiEacBkgCntrScg(EACRgstVO eacRegistrationVO) throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 if(eacRegistrationVO != null){
				 //query parameter
				 Map<String, String> param = eacRegistrationVO.getColumnValues();

				 String bkgNo = eacRegistrationVO.getPIfBkgNo();
				 String cntrNo = eacRegistrationVO.getPIfCntrNo();
				 String eacSysIfCd = eacRegistrationVO.getEacSysIfCd();
				 String eacNo = eacRegistrationVO.getEacNo();
				 String usrId = eacRegistrationVO.getAudrUsrId();
				 
				 param.put("bkg_no",bkgNo);	
				 param.put("cntr_no",cntrNo);
				 param.put("eac_sys_if_cd",eacSysIfCd);
				 param.put("eac_no",eacNo);
				 param.put("usr_id",usrId);

				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOMultiEacBkgCntrScgCSQL() , param, null);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
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
	  * Personnel Config의 KPI Office를 Update한다.<br>
	  * 
	  * @param EACPsonCfgVO eacPersonnelConfigVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void multiEacPsnList(EACPsonCfgVO eacPersonnelConfigVO) throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 
			 if(eacPersonnelConfigVO != null){
				 //query parameter
				 Map<String, String> param = eacPersonnelConfigVO.getColumnValues();
				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOMultiEacPsnUSQL() , param, null);
				 
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
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
	  * TRS Auto Audit에서 EAC I/F 내역 입력 <br>
	  * 
	  * @param EACRgstVO eacRegistrationVO
	  * @exception DAOException
	  */ 
	 @SuppressWarnings("unchecked")
	 public void multiEacTRSAutoAudit(EACRgstVO eacRegistrationVO) throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 if(eacRegistrationVO != null){
				 //query parameter
				 Map<String, String> param = eacRegistrationVO.getColumnValues();
				 String invNo = eacRegistrationVO.getPIfInvNo();
				 String invVndrSeq = eacRegistrationVO.getPIfInvVndrSeq();
				 String trspSoTpCd = eacRegistrationVO.getPIfTrspSoTpCd();
				 String soNo = eacRegistrationVO.getPIfSoNo();
				 String eacNo = eacRegistrationVO.getEacNo();
				 String usrId = eacRegistrationVO.getAudrUsrId();
				 String arrSoNo[] = soNo.split(",");

				 for(int i=0;i<arrSoNo.length;i++){
					 param.put("inv_no",invNo);
					 param.put("inv_vndr_seq",invVndrSeq);
					 param.put("trsp_so_tp_cd",trspSoTpCd);
					 param.put("trsp_so_ofc_cty_cd",arrSoNo[i].substring(0, 3));	
					 param.put("trsp_so_seq",arrSoNo[i].substring(3));
					 param.put("eac_no",eacNo);
					 param.put("usr_id",usrId);
					 
					 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOMultiEacTRSAutoAuditCSQL() , param, null);
					 if(result == Statement.EXECUTE_FAILED)
						 throw new DAOException("Fail to update SQL");
				 }
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
	  * MNR Auto Audit에서 EAC I/F 내역 입력 <br>
	  * 
	  * @param EACRgstVO eacRegistrationVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void multiEacMNRAutoAudit(EACRgstVO eacRegistrationVO) throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 if(eacRegistrationVO != null){
				 //query parameter
				 Map<String, String> param = eacRegistrationVO.getColumnValues();

				 String invNo = eacRegistrationVO.getPIfInvNo();
				 String invVndrSeq = eacRegistrationVO.getPIfInvVndrSeq();				 
				 String eqKndCd = eacRegistrationVO.getPIfEqKndCd();
				 String mnrOrdOfcCtyCd = eacRegistrationVO.getPIfWoNo().substring(0, 3);
				 String mnrOrdSeq = eacRegistrationVO.getPIfWoNo().substring(3);
				 String eqNo = eacRegistrationVO.getPIfCntrNo();
				 String costCd = eacRegistrationVO.getPIfCostCd();
				 String eacNo = eacRegistrationVO.getEacNo();
				 String usrId = eacRegistrationVO.getAudrUsrId();
				 
				 param.put("inv_no", invNo);	
				 param.put("vndr_seq", invVndrSeq);
				 param.put("eq_knd_cd", eqKndCd);
				 param.put("mnr_ord_ofc_cty_cd", mnrOrdOfcCtyCd);
				 param.put("mnr_ord_seq", mnrOrdSeq);
				 param.put("eq_no", eqNo);
				 param.put("cost_cd", costCd);
				 param.put("eac_no",eacNo);
				 param.put("usr_id", usrId);

				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOMultiEacMNRAutoAuditCSQL() , param, null);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
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
	  * TES Auto Audit에서 EAC I/F 내역 입력 <br>
	  * 
	  * @param EACRgstVO eacRegistrationVO
	  * @return void 
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void multiEacTESAutoAudit(EACRgstVO eacRegistrationVO) throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 if(eacRegistrationVO != null){
				 //query parameter
				 Map<String, String> param = eacRegistrationVO.getColumnValues();

				 String invNo = eacRegistrationVO.getPIfInvNo();
				 String invVndrSeq = eacRegistrationVO.getPIfInvVndrSeq();	
				 String invCfmDt = eacRegistrationVO.getPIfInvCfmDt();
				 String expnAudSeq = eacRegistrationVO.getPIfExpnAudSeq();
				 String calcTpCd = eacRegistrationVO.getPIfCalcTpCd();
				 String costCd = eacRegistrationVO.getPIfCostCd();
				 String cntrTpszCd = eacRegistrationVO.getPIfCntrTpszCd();
				 String stoCntrSzNm = eacRegistrationVO.getPIfStoCntrSzNm();
				 String ioBndCd = eacRegistrationVO.getPIfIoBndCd();
				 String dcgoFlg = eacRegistrationVO.getPIfDcgoFlg();
				 String rcFlg = eacRegistrationVO.getPIfRcFlg();
				 String tmlWrkDyCd = eacRegistrationVO.getPIfTmlWrkDyCd();
				 String fpCalcPrdCd = eacRegistrationVO.getPIfFpCalcPrdCd();
				 String calcCostGrpCd = eacRegistrationVO.getPIfCalcCostGrpCd();
				 String eacNo = eacRegistrationVO.getEacNo();
				 String usrId = eacRegistrationVO.getAudrUsrId();
				 
				 param.put("inv_no", invNo);	
				 param.put("vndr_seq", invVndrSeq);
				 param.put("inv_cfm_dt", invCfmDt);
				 param.put("expn_aud_seq", expnAudSeq);
				 param.put("calc_tp_cd", calcTpCd);
				 param.put("lgs_cost_cd", costCd);
				 param.put("cntr_tpsz_cd", cntrTpszCd);
				 param.put("sto_cntr_sz_nm", stoCntrSzNm);
				 param.put("ib_bnd_cd", ioBndCd);
				 param.put("dcgo_flg", dcgoFlg);
				 param.put("rc_flg", rcFlg);
				 param.put("tml_wrk_dy_cd", tmlWrkDyCd);
				 param.put("fp_calc_prd_cd", fpCalcPrdCd);
				 param.put("calc_cost_grp_cd", calcCostGrpCd);
				 param.put("eac_no", eacNo);
				 param.put("usr_id", usrId);

				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOMultiEacTESAutoAuditCSQL() , param, null);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
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
	  * EAS_EXPN_AUD_CS_MGMT 키값을 생성한다.<br>
	  * @param AutoAuditFileVO autoAuditFileVO
	  * @return String 
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public String makeAutoAuditFileNo(AutoAuditFileVO autoAuditFileVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String atchFileLnkId = "";

		 Map<String, Object> param = new HashMap<String, Object>();

		 try{
			 param.put("mdl_tp_cd", autoAuditFileVO.getMdlTpCd());
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOAddAutoAuditFileNoRSQL(), param, param);
			 if(dbRowset.next()){
				 atchFileLnkId = dbRowset.getString("atch_file_lnk_id");
			 }
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return atchFileLnkId;
	 }	 
	 
	 /**
	  * Auto Audit 첨부파일 저장 <br>
	  * @param AutoAuditFileVO autoAuditFileVO
	  * @return void 
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void addAutoAudFile(AutoAuditFileVO autoAuditFileVO) throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 if(autoAuditFileVO != null){
				 //query parameter
				 Map<String, String> param = autoAuditFileVO.getColumnValues();

				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAOAddAutoAuditFileCSQL() , param, null);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
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
	  * Auto Audit 첨부파일 삭제 <br>
	  * 
	  * @param AutoAuditFileVO autoAuditFileVO
	  * @return void 
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public void removeAutoAudFile(AutoAuditFileVO autoAuditFileVO) throws DAOException {
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 if(autoAuditFileVO != null){
				 //query parameter
				 Map<String, String> param = autoAuditFileVO.getColumnValues();

				 int result = sqlExe.executeUpdate((ISQLTemplate) new EacMgtDBDAORemoveAutoAudFileDSQL() , param, null);
				 if(result == Statement.EXECUTE_FAILED)
					 throw new DAOException("Fail to update SQL");
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
	  * Auto Audit 첨부 파일 내역 조회<br>
	  * 
	  * @param AutoAuditFileVO autoAuditFileVO
	  * @return List<AutoAuditFileVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<AutoAuditFileVO> searchAutoAudFile(AutoAuditFileVO autoAuditFileVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<AutoAuditFileVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(autoAuditFileVO != null){
				 Map<String, String> mapVO = autoAuditFileVO.getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOsearchAutoAudFileRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, AutoAuditFileVO.class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
	 /**
	  * Auto Audit 첨부 파일 내역 조회 (삭제대상 조회)<br>
	  * 
	  * @param AutoAuditFileVO autoAuditFileVO
	  * @return List<AutoAuditFileVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<AutoAuditFileVO> searchAutoAudFileAll(AutoAuditFileVO autoAuditFileVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<AutoAuditFileVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 if(autoAuditFileVO != null){
				 Map<String, String> mapVO = autoAuditFileVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchAutoAudFileAllRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, AutoAuditFileVO.class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	 
	 /**
	  * 동일한 결재 상태가 존재하는지 체크한다.<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EacSearchVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public boolean searchVerifyEacSts(EacSearchVO eacSearchVO) throws DAOException {
		 boolean bEacSts = false;
		 DBRowSet dbRowset = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOVerifyEasStsRSQL(), param, velParam);
			 if (dbRowset.getRowCount() > 0) {
				 bEacSts = true;
			 }
			 
			 return bEacSts;
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }

	 }
	 
	 /**
	  * EAC 결재 경로를 조회한다.<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EacSearchVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EacSearchVO> SearchEacStatus(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EacSearchVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchEacStatusRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, EacSearchVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }

	 /**
	  * EAC 결재 경로를 조회한다.<br>
	  * 
	  * @param EacSearchVO eacSearchVO
	  * @return List<EacSearchVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<EacSearchVO> searchMonthExchange(EacSearchVO eacSearchVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<EacSearchVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(eacSearchVO != null){
				 Map<String, String> mapVO = eacSearchVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new EacMgtDBDAOSearchMonthExchangeRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchMonthExchangeVO .class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
 
}
