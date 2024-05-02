/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UncollectedCargoDBDAO.java
*@FileTitle : UncollectedCargo
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.07
*@LastModifier : 김현주
*@LastVersion : 1.0
* 2014.07.07 김현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.basic.LongstayingUnclaimEQFlaggingBCImpl;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event.EesCim0064Event;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event.EesCim0065Event;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event.EesCim0071Event;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.CodeVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.CreateUploadFileInfoVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.MstCntrVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.SearchUncollectedCargoFileVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.SearchUncollectedGlMonXchRtListVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.SearchUncollectedVolDtlListVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.UncollectedCargoAuthorizerVO;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.UncollectedCargoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS UncollectedCargoDBDAO <br>
 * - ALPS-LongstayingUnclaimEQMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author kim jong jun
 * @see LongstayingUnclaimEQFlaggingBCImpl 참조
 * @since J2EE 1.6
 */
public class UncollectedCargoDBDAO extends DBDAOSupport {


	/** 
	 * EES_CIM_0063 <br>
	 * Uncollected Cargo Creation Retrieve<br>
	 *
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @return List<UncollectedCargoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UncollectedCargoVO> searchUncollectedCargoCreation(UncollectedCargoVO uncollectedCargoVO) throws DAOException {
					
		DBRowSet dbRowset = null;
		List<UncollectedCargoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(uncollectedCargoVO != null){
				Map<String, String> mapVO = uncollectedCargoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UncollectedCargoDBDAOSearchUncollectedCreationRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UncollectedCargoVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * UC Inquiry 리스트 조회 [EES_CIM_0064]
	 * 
	 * @param String strBl
	 * @return UncollectedCargoVO
	 * @throws DAOException
	 */
	public UncollectedCargoVO searchUncollectedCargoCreationBlInfo(String strBl) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		List<UncollectedCargoVO> list = null;
		UncollectedCargoVO uncollectedCargoVO = new UncollectedCargoVO();
		
		param.put("bl_no",strBl);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery(new UncollectedCargoDBDAOSearchUncollectedCreationBlInfoRSQL(), param,null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UncollectedCargoVO.class);

			if (list != null && list.size() > 0) {
				uncollectedCargoVO = (UncollectedCargoVO)list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return uncollectedCargoVO;
	}
	
	/** 
	 * EES_CIM_0063 <br>
	 * searh combo code list<br>
	 *
	 * @param String intgCdId
	 * @return List<CodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CodeVO> searchComboCodeList(String intgCdId) throws DAOException {
					
		DBRowSet dbRowset = null;
		List<CodeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(intgCdId != null){
				param.put("code",intgCdId);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UncollectedCargoDBDAOSearchCommonCodeRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CodeVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/**
	 * EES_CIM_0063 <br>
	 * Create New Uncollected Cargo Case Number <br>
	 * 
	 * @param String ucCDHd
	 * @return String
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String checkNewUCCaseNo(String ucCDHd) throws DAOException {
					
		DBRowSet dbRowset = null;
		String strReturn = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(ucCDHd != null){
				param.put("uc_cd_hd",ucCDHd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UncollectedCargoDBDAOCheckUCCaseNoRSQL(), param, null);
	    	if(dbRowset.next()) {
	    		strReturn = ucCDHd + dbRowset.getString("uc_cs_no").trim();
	    	}
	    	if (strReturn == null){
	    		strReturn = ucCDHd + "001";	// 최초 Sequence
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strReturn;
	}
	
	
	/**
	 * EES_CIM_0063 <br>
	 * BL 중복 체크 <br>
	 * 
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @return String
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String checkBLNo3(UncollectedCargoVO uncollectedCargoVO) throws DAOException {
					
		DBRowSet dbRowset = null;
		String strReturn = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = uncollectedCargoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UncollectedCargoDBDAOCheckBLNo3RSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		strReturn = dbRowset.getString("flag").trim();
	    	}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strReturn;
	}
	

	/**
	 * EES_CIM_0063 <br>
	 * Check BL No <br>
	 * 
	 * @param String strBLNo
	 * @return String
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String checkBLNo(String strBLNo) throws DAOException {
					
		DBRowSet dbRowset = null;
		String strReturn = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(strBLNo != null){
				param.put("bl_no",strBLNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UncollectedCargoDBDAOCheckBLNoRSQL(), param, null);
	    	if(dbRowset.next()) {
	    		strReturn = dbRowset.getString("bl_no").trim();
	    	} else{
	    		strReturn = "FALSE";
	    	}
	    		
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strReturn;
	}	
	
	/**
	 * EES_CIM_0063 <br>
	 * CIM_UC_CGO_DTL 에 해당 B/L NO 존재 여부 조회<br>
	 * 
	 * @param String strBLNo
	 * @return String
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String checkBLNo2(String strBLNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		String strReturn = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(strBLNo != null){
				param.put("bl_no",strBLNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UncollectedCargoDBDAOCheckBLNo2RSQL(), param, null);
			if(dbRowset.next()) {
				strReturn = dbRowset.getString("uc_cs_no").trim();
			} else{
				strReturn = "FALSE";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strReturn;
	}	

	/**
	 * EES_CIM_0063 <br>
	 * Check Branch/Agent <br>
	 * 
	 * @param String strAgnt
	 * @return String
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String checkAgent(String strAgnt) throws DAOException {
		
		DBRowSet dbRowset = null;
		String strReturn = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(strAgnt != null){
				param.put("agent",strAgnt);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UncollectedCargoDBDAOCheckAgentRSQL(), param, null);
			if(dbRowset.next()) {
				strReturn = dbRowset.getString("agent").trim();
			} else{
				strReturn = "FALSE";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strReturn;
	}	

	/**
	 * EES_CIM_0063 <br>
	 * Check RHQ <br>
	 * 
	 * @param String strRhq
	 * @return String
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String checkRHQ(String strRhq) throws DAOException {
		
		DBRowSet dbRowset = null;
		String strReturn = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(strRhq != null){
				param.put("rhq",strRhq);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UncollectedCargoDBDAOCheckRHQRSQL(), param, null);
			if(dbRowset.next()) {
				strReturn = dbRowset.getString("rhq").trim();
			} else{
				strReturn = "FALSE";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strReturn;
	}	

	/**
	 * EES_CIM_0063 <br>
	 * Check HANDLER <br>
	 * 
	 * @param String strHndlr
	 * @param String strOpt
	 * @return String
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String checkHandlerOfcCd(String strHndlr, String strOpt) throws DAOException {
		
		DBRowSet dbRowset = null;
		String strReturn = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(strHndlr != null){
				param.put("handler",strHndlr);
				velParam.put("handler",strHndlr);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UncollectedCargoDBDAOCheckHandlerRSQL(), param, velParam);
			if(dbRowset.next()) {
				if (strOpt.equals("HNDLR"))	strReturn = dbRowset.getString("handler").trim();
				if (strOpt.equals("OFC"))	strReturn = dbRowset.getString("ofc").trim();
			} else{
				strReturn = "FALSE";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strReturn;
	}	
	
	/**
	 * EES_CIM_0063 <br>
	 * Check HANDLER <br>
	 * 
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @param String strOpt
	 * @return String
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String checkOfcHandlerMatch(UncollectedCargoVO uncollectedCargoVO, String strOpt) throws DAOException {
		
		DBRowSet dbRowset = null;
		String strReturn = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			// Handling
			if(strOpt.equals("H")){
				param.put("office",uncollectedCargoVO.getHndlBrncCd());
				param.put("handler",uncollectedCargoVO.getHndlHdlrUsrId());
				velParam.put("office",uncollectedCargoVO.getHndlBrncCd());
				velParam.put("handler",uncollectedCargoVO.getHndlHdlrUsrId());
			}
			//Counter 
			if(strOpt.equals("C")){
				param.put("office",uncollectedCargoVO.getKntrBrncCd());
				param.put("handler",uncollectedCargoVO.getKntrHdlrUsrId());
				velParam.put("office",uncollectedCargoVO.getKntrBrncCd());
				velParam.put("handler",uncollectedCargoVO.getKntrHdlrUsrId());
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UncollectedCargoDBDAOCheckHandlerRSQL(), param, velParam);
			if(dbRowset.next()) {
				strReturn = dbRowset.getString("handler").trim();
			} else{
				strReturn = "FALSE";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strReturn;
	}	
	
	/**
	 * UC Creation Data : Master 정보를 생성한다.
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void manageUncollectedCargoCreationAddMaster(UncollectedCargoVO uncollectedCargoVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = uncollectedCargoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new UncollectedCargoDBDAOAddUncollectedCreationMstrInfoCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert Master SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * UC Creation Data : Detail 정보를 생성한다.
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void manageUncollectedCargoCreationAddDetail(UncollectedCargoVO uncollectedCargoVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();                                                      
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = uncollectedCargoVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new UncollectedCargoDBDAOAddUncollectedCreationDtlInfoCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert Detail SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * UC Creation Data : Master 정보를 변경한다.
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void manageUncollectedCargoCreationModifyMaster(UncollectedCargoVO uncollectedCargoVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = uncollectedCargoVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new UncollectedCargoDBDAOModifyUncollectedCreationMstrInfoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update Master SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * UC Creation Data : Detail 정보를 변경한다.
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void manageUncollectedCargoCreationModifyDetail(UncollectedCargoVO uncollectedCargoVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();                                                      
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = uncollectedCargoVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new UncollectedCargoDBDAOModifyUncollectedCreationDtlInfoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update Detail SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * UC Creation Data : Master 정보를 변경한다.
	 * Counter Office 의 Branch/Agent 의 경우 변경할 수 있는 내용이 제한 되어 있음. (Counter Office의 Branch/Agent, Handler, Counter Office Opinion)
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void manageUncollectedCargoCreationModifyMaster2(UncollectedCargoVO uncollectedCargoVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = uncollectedCargoVO.getColumnValues();
			param.putAll(mapVO);
			
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new UncollectedCargoDBDAOModifyUncollectedCreationMstrInfo2USQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update Master SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * UC Creation Data : Master 정보를 변경한다.
	 * Handling RHQ 소속 User는 Reopen 권한만 있으며 Reopen의 경우 status code 값만 변경함.
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void manageUncollectedCargoCreationModifyMaster3(UncollectedCargoVO uncollectedCargoVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = uncollectedCargoVO.getColumnValues();
			param.putAll(mapVO);
			
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new UncollectedCargoDBDAOModifyUncollectedCreationMstrInfo3USQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update Master SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * UC Creation Data : 관리자의 메모를 저장한다..
	 * @param String managerMemo
	 * @param String isAuthority
	 * @param String ucCsNo
	 * @param String blNo
	 * @param String usr_id
	 * @throws DAOException
	 * @throws Exception
	 */
	public void manageUncollectedCargoCreationModifyMaster5(String managerMemo,String isAuthority,String ucCsNo,String blNo, String usr_id) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			    velParam.put("isAuthority",isAuthority);
				param.put("managerMemo",managerMemo);
				param.put("ucCsNo",ucCsNo);
				param.put("blNo",blNo);
				param.put("usr_id",usr_id);
			
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new UncollectedCargoDBDAOModifyManageUncollectedCargoMemoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update Master SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * UC Creation Data : Detail 정보를 변경한다.
	 * * Counter Office 의 Branch/Agent 의 경우 변경할 수 있는 내용이 제한 되어 있음. (Counter Office의 Branch/Agent, Handler, Counter Office Opinion)
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void manageUncollectedCargoCreationModifyDetail2(UncollectedCargoVO uncollectedCargoVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();                                                      

		try {
			Map<String, String> mapVO = uncollectedCargoVO.getColumnValues();			
			param.putAll(mapVO);
			
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new UncollectedCargoDBDAOModifyUncollectedCreationDtlInfo2USQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update Detail SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * UC cargo No 의 B/L 별 Container를 생성
	 * @param  List<SearchUncollectedVolDtlListVO> SearchUncollectedVolDtlListVOs
	 * @return int[] 
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] manageUncollectedCargoCreationAddContainer(List<SearchUncollectedVolDtlListVO> SearchUncollectedVolDtlListVOs) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(SearchUncollectedVolDtlListVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new UncollectedCargoDBDAOAddUncollectedCreationContainerCSQL(), SearchUncollectedVolDtlListVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert container No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}


	/**
	 *  UC cargo No 의 B/L 별 Container를 삭제
	 *   
	 * @param String ucCsNo  
	 * @param String blNo
	 * @throws DAOException 
	 */
	@SuppressWarnings("unchecked")
	public void manageUncollectedCargoCreationDeleteContainer(String ucCsNo, String blNo) throws DAOException {
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(!"".equals(ucCsNo) && !"".equals(blNo)){
				param.put("uc_cs_no", ucCsNo);
				param.put("bl_no", blNo);
				
				result = new SQLExecuter("").executeUpdate((ISQLTemplate)new UncollectedCargoDBDAODeleteUncollectedCreationContainerDSQL(), param, null);
				
				if(result == Statement.EXECUTE_FAILED)    
					throw new DAOException("Fail to Delete Conatiner");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
	}	

	/**
	 *  update master conatiner data concerned with Uncollected Cargo
	 * 
	 * @param MstCntrVO newMstCntrVO
	 * @throws DAOException 
	 */
	@SuppressWarnings("unchecked")
	public void manageOldMstCntrWthUncollectedCargoBLCntr(MstCntrVO newMstCntrVO) throws DAOException {
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = newMstCntrVO.getColumnValues();			
			param.putAll(mapVO);
			velParam.put("type", "OLD");
					
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new UncollectedCargoDBDAOModifyMasterContainerUSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)    
				throw new DAOException("Fail to update master conatiner data concerned with Uncollected Cargo by B/L");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
	}	
	
	/**
	 * update new master conatiner data concerned with Uncollected Cargo
	 * @param  List<MstCntrVO> newMstCntrVOs
	 * @return int[] 
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] manageNewMstCntrWthUncollectedCargoBLCntr(List<MstCntrVO> newMstCntrVOs) throws DAOException,Exception {
		int insCnt[] = null;
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			velParam.put("type", "NEW");
			
			SQLExecuter sqlExe = new SQLExecuter("");
			if(newMstCntrVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new UncollectedCargoDBDAOModifyMasterContainerUSQL(), newMstCntrVOs,velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Fail to update new master conatiner data concerned with Uncollected Cargo by B/L"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	
	/**
	 *  update master conatiner data concerned with Uncollected Cargo
	 * 
	 * @param MstCntrVO newMstCntrVO
	 * @throws DAOException 
	 */
	@SuppressWarnings("unchecked")
	public void manageMstCntrWthUncollectedCargoUcCntr(MstCntrVO newMstCntrVO) throws DAOException {
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = newMstCntrVO.getColumnValues();			
			param.putAll(mapVO);
			if (newMstCntrVO.getUcRsnCd() == "REOPEN"){
				velParam.put("type", "REOPEN");
			} else {
				velParam.put("type", "ALL");
			}
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new UncollectedCargoDBDAOModifyMasterContainerUSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)    
				throw new DAOException("Fail to update master conatiner data concerned with Uncollected Cargo");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
	}
	
	/**
	 * update master conatiner data concerned with Uncollected Cargo (UC Date Only)
	 * @param  MstCntrVO mstCntrVO
	 * @param  String strLgnUsr
	 * @throws DAOException
	 * @throws Exception
	 */
	public void manageMstCntrWthUncollectedCargoUcCntrUcDtOnly(MstCntrVO mstCntrVO, String strLgnUsr) throws DAOException,Exception {
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = mstCntrVO.getColumnValues();			
			param.putAll(mapVO);
			param.put("upd_usr_id", strLgnUsr);
			
					
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new UncollectedCargoDBDAOModifyMasterContainerUcDateUSQL(), param, null);
				
			if(result == Statement.EXECUTE_FAILED)    
				throw new DAOException("Fail to update master conatiner data concerned with Uncollected Cargo (UC Date)");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}	
	}

	/**
	 * UC Inquiry 리스트 조회 [EES_CIM_0064]
	 * 
	 * @param EesCim0064Event event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchUncollectedInquiryList(EesCim0064Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		
//		HashMap params = event.getEventParams();		
		
		param.put("s_retrieve_gb"	, event.getsRetrieveGb() );
		param.put("s_uc_cs_no"		, event.getsUcCsNo()     );
		param.put("s_bl_no"			, event.getsBlNo()       );
		param.put("s_cntr_no"		, event.getsCntrNo()     );
		param.put("s_cnee_uc_dt_gb"	, event.getsCneeUcDtGb() );
		param.put("s_cnee_uc_dt_fr"	, event.getsCneeUcDtFr().replace("-", ""));
		param.put("s_cnee_uc_dt_to"	, event.getsCneeUcDtTo().replace("-", ""));
		param.put("s_uc_dys_gb"		, event.getsUcDysGb()    );
		param.put("s_uc_dys_fr"		, event.getsUcDysFr()    );
		param.put("s_uc_dys_to"		, event.getsUcDysTo()    );
		param.put("s_uc_sts_cd"		, event.getsUcStsCd()    );
		param.put("s_uc_rsn_cd"		, event.getsUcRsnCd()    );
		param.put("s_hndl_rhq_cd"	, event.getsHndlRhqCd()  );
		param.put("s_kntr_rhq_cd"	, event.getsKntrRhqCd()  );
		param.put("s_uc_disp_opt_cd", event.getsUcDispOptCd());
		param.put("s_pol_cd"		, event.getsPolCd()      );
		param.put("s_hndl_brnc_cd"	, event.getsHndlBrncCd() );
		param.put("s_kntr_brnc_cd"	, event.getsKntrBrncCd() );
		param.put("s_pod_cd"		, event.getsPodCd()      );
		param.put("s_By_Case"		, event.getsByCase()     );
		
		try {
			if(event.getsByCase().equals("A")){
				dRs = new SQLExecuter("").executeQuery(new UncollectedCargoDBDAOSearchUncollectedInquiryListRSQL(), param,param);
			}else{
				dRs = new SQLExecuter("").executeQuery(new UncollectedCargoDBDAOSearchUncollectedInquiryByCaseListRSQL(), param,param);
			}
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
	 * UC Activity 리스트 조회 [EES_CIM_0066]<br>
	 *
	 * @param searchUncollectedCargoFileVO SearchUncollectedCargoFileVO 
	 * @return List<SearchUncollectedCargoFileVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchUncollectedCargoFileVO> searchUncollectedCargoFileListValue(SearchUncollectedCargoFileVO searchUncollectedCargoFileVO) throws DAOException {

		DBRowSet dbRowset = null;
		List<SearchUncollectedCargoFileVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchUncollectedCargoFileVO != null){
				Map<String, String> mapVO = searchUncollectedCargoFileVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UncollectedCargoDBDAOSearchUncollectedCargoFileRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchUncollectedCargoFileVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * UC Activity 저장 처리 [EES_CIM_0066]<br>
	 *
	 * @param insModels List<SearchUncollectedCargoFileVO> 
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addManageUncollectedCargoFileVOS(List<SearchUncollectedCargoFileVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new UncollectedCargoDBDAOCreateManageUncollectedCargoFileCSQL(), insModels,null);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * UC Activity 수정 처리 [EES_CIM_0066]<br>
	 *
	 * @param updModels List<SearchUncollectedCargoFileVO> 
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyManageUncollectedCargoFileVOS(List<SearchUncollectedCargoFileVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new UncollectedCargoDBDAOModifyManageUncollectedCargoFileUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * UC Activity 삭제 처리 [EES_CIM_0066]<br>
	 *
	 * @param delModels List<SearchUncollectedCargoFileVO> 
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeManageUncollectedCargoFileVOS(List<SearchUncollectedCargoFileVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new UncollectedCargoDBDAORemoveManageUncollectedCargoFileDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
	/**
	 * UC-VOL_DTL 리스트 조회 [EES_CIM_0070]<br>
	 *
	 * @param searchUncollectedVolDtlListVO SearchUncollectedVolDtlListVO 
	 * @return List<SearchUncollectedVolDtlListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchUncollectedVolDtlListVO> searchUncollectedVolDtlList(SearchUncollectedVolDtlListVO searchUncollectedVolDtlListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchUncollectedVolDtlListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchUncollectedVolDtlListVO != null){
				Map<String, String> mapVO = searchUncollectedVolDtlListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			if("UC".equals(param.get("vol_dtl_gb")))
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UncollectedCargoDBDAOSearchUncollectedVolDtlListRSQL(), param, velParam);
			else
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UncollectedCargoDBDAOSearchUncollectedVolDtlBlNoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchUncollectedVolDtlListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
		
	/**
	 * Help Exchange 리스트 조회 - 년월/통화코드별 환율조회 [EES_CIM_0071]<br>
	 *
	 * @param searchUncollectedGlMonXchRtListVO SearchUncollectedGlMonXchRtListVO 
	 * @return List<SearchUncollectedGlMonXchRtListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchUncollectedGlMonXchRtListVO> searchUncollectedGlMonXchRtList(SearchUncollectedGlMonXchRtListVO searchUncollectedGlMonXchRtListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchUncollectedGlMonXchRtListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchUncollectedGlMonXchRtListVO != null){
				Map<String, String> mapVO = searchUncollectedGlMonXchRtListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UncollectedCargoDBDAOSearchUncollectedGlMonXchRtListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchUncollectedGlMonXchRtListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
		 
	/**
	 * Help Exchange - 통화코드Combo리스트 [EES_CIM_0071]<br>
	 * 
	 * @param event EesCim0071Event 
	 * @return dbRowset
	 * @throws DAOException
	 */
	public DBRowSet searchCurrCdCombo(EesCim0071Event event) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			UncollectedCargoDBDAOSearchUncollectedCurrCdComboRSQL template = new UncollectedCargoDBDAOSearchUncollectedCurrCdComboRSQL();
			dbRowset = sqlExe.executeQuery(template, param, param);
	
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}	
		 
	/**
	 * UC File Attach 업로드된 파일정보(목록) 조회 이벤트 처리 [EES_CIM_0065]<br>
	 * 
	 * @param event EesCim0065Event  
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchUploadFileInfo(EesCim0065Event event) throws DAOException {
		 DBRowSet dbRowset = null;
		 
		 HashMap params = event.getEventParams();
		 String ucCsNo      = JSPUtil.getNull((String)params.get("ucCsNo")); 
		 String ucCgoFileId	= JSPUtil.getNull((String)params.get("ucCgoFileId")); 
		 String fileSavId	= JSPUtil.getNull((String)params.get("fileSavId"));

		 Map<String, Object> param = new HashMap<String, Object>();
		
		 try{
			 if(ucCsNo != null & ucCgoFileId != null){				 
				 param.put("s_uc_cs_no", ucCsNo);
				 param.put("s_uc_cgo_file_id", ucCgoFileId);
				 param.put("s_file_sav_id", fileSavId);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UncollectedCargoDBDAOSearchUploadFileInfoRSQL(), param, param);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return dbRowset;				
	}
	
	/**
	 * UC File Attach FileUpload정보 저장(생성) 이벤트 처리 [EES_CIM_0067]<br>
	 * 
	 * @param models Collection  
	 * @param event EesCim0065Event  
	 * @return String[] {ucCgoFileId, fileNoSeq} 
	 * @exception EventException
	 * @throws DAOException 
	 */
	@SuppressWarnings("unchecked")
	public String[] createUploadFileInfo(Collection models, EesCim0065Event event) throws DAOException {
		HashMap params = event.getEventParams();
		
		String ucCsNo      	= JSPUtil.getNull((String)params.get("ucCsNo"));
		String ucCgoFileId  = (String)params.get("ucCgoFileId");
		String fileDesc     = (String)params.get("fileDesc");
		String fileNoSeq   	= getFileNoSeq(ucCsNo, ucCgoFileId);
		String fileLgcNm  	= "";
		String filePhysNm  	= "";
		String filePathNm  	= "";
		String user_id     	= JSPUtil.getNull((String)params.get("user_id"));
		String user_ofc_cd 	= JSPUtil.getNull((String)params.get("user_ofc_cd")); 

		Map<String, Object> param = new HashMap<String, Object>();
		Iterator itr = models.iterator();
		CreateUploadFileInfoVO model = null;
		model = (CreateUploadFileInfoVO)itr.next();

		try{
			if(ucCgoFileId != null & user_ofc_cd != null & user_id != null){				 
				param.put("s_uc_cs_no", ucCsNo);
				param.put("s_uc_cgo_file_id", ucCgoFileId);
				param.put("s_file_no_seq", fileNoSeq);
				param.put("s_file_sav_id", model.getFile_phys_nm());
				param.put("s_file_nm", model.getFile_lgc_nm());
				param.put("s_file_desc", fileDesc);
				param.put("s_cre_usr_id", user_id);
				param.put("s_upd_usr_id", user_id);
				
				fileLgcNm  = model.getFile_lgc_nm();
				filePhysNm = model.getFile_phys_nm();
				filePathNm = model.getFile_path_nm();
				
			}
			new SQLExecuter("").executeUpdate((ISQLTemplate)new UncollectedCargoDBDAOCreateUploadFileInfoCSQL(), param, null);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		if(ucCgoFileId != null){
			return new String[]{ucCgoFileId, fileNoSeq, filePhysNm, fileLgcNm, filePathNm}; // 순서 주의	
		}
		else {
			return new String[]{null, fileNoSeq, filePhysNm, fileLgcNm, filePathNm}; // 순서 주의	
		}
	}
	
	/**
	 * UC File Attach FileUpload정보-공통테이블 저장(생성) 이벤트 처리 [EES_CIM_0067]<br>
	 * 
	 * @param models Collection  
	 * @param event EesCim0065Event  
	 * @return String[] {ucCgoFileId, fileNoSeq} 
	 * @exception EventException
	 * @throws DAOException 
	 */
	@SuppressWarnings("unchecked")
	public String[] createUploadFileInfoCOM(Collection models, EesCim0065Event event) throws DAOException {
		HashMap params = event.getEventParams();
		
//		String ucCsNo      	= JSPUtil.getNull((String)params.get("ucCsNo"));
		String ucCgoFileId  = (String)params.get("ucCgoFileId");
		String fileNoSeq   	= "";
		String fileLgcNm  	= "";
		String filePhysNm  	= "";
		String filePathNm  	= "";
		String user_id     	= JSPUtil.getNull((String)params.get("user_id"));
		String user_ofc_cd 	= JSPUtil.getNull((String)params.get("user_ofc_cd")); 

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Iterator itr = models.iterator();
		CreateUploadFileInfoVO model = null;
		model = (CreateUploadFileInfoVO)itr.next();

		try{
			if(ucCgoFileId != null & user_ofc_cd != null & user_id != null){				 
				param.put("s_file_sav_id", model.getFile_phys_nm());
				param.put("s_file_upld_nm", model.getFile_lgc_nm());
				param.put("s_file_path_url", model.getFile_path_nm());
				param.put("s_cre_usr_id", user_id);
				param.put("s_upd_usr_id", user_id);
				
				fileLgcNm  = model.getFile_lgc_nm();
				filePhysNm = model.getFile_phys_nm();
				filePathNm = model.getFile_path_nm();
				
			}
			// clooney - db가 틀리기 때문에 한번에 commit을 못한다
			new SQLExecuter("").executeUpdate((ISQLTemplate)new UncollectedCargoDBDAOCreateUploadFileInfoCOMCSQL(), param, null);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		if(ucCgoFileId != null){
			return new String[]{ucCgoFileId, fileNoSeq, filePhysNm, fileLgcNm, filePathNm}; // 순서 주의	
		}
		else {
			return new String[]{null, fileNoSeq, filePhysNm, fileLgcNm, filePathNm}; // 순서 주의	
		}
	}

	/**
	 * UC File Attach FileUpload정보 저장(생성)전 file_no_seq 조회 이벤트 처리[EES_CIM_0067]<br>
	 *  
	 * @param ucCsNo 
	 * @param ucCgoFileId 
	 * @return String 
	 * @throws DAOException
	 */
	public String getFileNoSeq(String ucCsNo, String ucCgoFileId) throws DAOException {
		 DBRowSet dbRowset = null;
		 String nextFileNoSeq = null;
		 Map<String, Object> param = new HashMap<String, Object>();
		
		 try{
			 if(ucCgoFileId != null){				 
				 param.put("s_uc_cs_no", ucCsNo);
				 param.put("s_uc_cgo_file_id", ucCgoFileId);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UncollectedCargoDBDAOSearchGetFileNoSeqRSQL(), param, null);
				
			 if ( dbRowset!=null && dbRowset.next() ){
				 nextFileNoSeq = dbRowset.getString(1);
			 }
			 dbRowset = null;
		 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return nextFileNoSeq;				
	}
	
	/**
	 * UC File Attach FileUpload정보 삭제 이벤트 처리 [EES_CIM_0067]<br>
	 * 
	 * @param event EesCim0065Event  
	 * @return boolean 
	 * @exception EventException
	 * @throws DAOException 
	 */
	@SuppressWarnings("unchecked")
	public boolean removeUploadFiles(EesCim0065Event event) throws DAOException {
		boolean isSuccessFlag = false; // 성공여부
		 
		HashMap params = event.getEventParams();
		String ucCsNo      = JSPUtil.getNull((String)params.get("ucCsNo"));
		String ucCgoFileId      = (String)params.get("ucCgoFileId");
		String delFileNoSeqs	= (String)params.get("delFileNoSeqs");

		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(!"".equals(ucCgoFileId) && !"".equals(delFileNoSeqs)){
				param.put("s_uc_cs_no", ucCsNo);
				param.put("s_uc_cgo_file_id", ucCgoFileId);
				List<String> arr_DelFileNoSeqs = new ArrayList();
				arr_DelFileNoSeqs = this.seperationParameter(delFileNoSeqs, "|");
				param.put("s_temp_file_no_seq", arr_DelFileNoSeqs);
				
				if(arr_DelFileNoSeqs.size() > 0){
					new SQLExecuter("").executeUpdate((ISQLTemplate)new UncollectedCargoDBDAODeleteUploadFilesDSQL(), param, param);
				}
			}

			isSuccessFlag = true;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isSuccessFlag;			
	}	
	
	
	/**
	 * UC File Attach FileUpload정보-공통 삭제 이벤트 처리 [EES_CIM_0067]<br>
	 * 
	 * @param event EesCim0065Event  
	 * @return boolean 
	 * @exception EventException
	 * @throws DAOException 
	 */
	@SuppressWarnings("unchecked")
	public boolean removeUploadFilesCOM(EesCim0065Event event) throws DAOException {
		boolean isSuccessFlag = false; // 성공여부
		 
		HashMap params = event.getEventParams();
	   	String fileSavId = JSPUtil.getNull((String)params.get("fileSavId"));

		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(!"".equals(fileSavId)){
				List<String> arr_FileSavId = new ArrayList();
				arr_FileSavId = this.seperationParameter(fileSavId, "|");
				param.put("s_file_sav_id", arr_FileSavId);
				
				
				if(arr_FileSavId.size() > 0){
					new SQLExecuter("").executeUpdate((ISQLTemplate)new UncollectedCargoDBDAODeleteUploadFilesCOMUSQL(), param, param);
				}
			}
			isSuccessFlag = true;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isSuccessFlag;			
	}	
	
	/**
	 * 여러개의 parameter를 나누어주는 메소드
	 * 
	 * Detail Inquity Popup<br>
	 * @param sparameter String 
	 * @param sSeperate String 
	 * @return ArrayList<String>
	 * @throws 
	 */
	public ArrayList seperationParameter(String sparameter, String sSeperate) {
		ArrayList arrlist = null;
		StringTokenizer st  = null;
		int j = 0;
		if( !sparameter.equals("") ) {
			arrlist = new ArrayList();
			st = new StringTokenizer(sparameter, sSeperate);
			while( st.hasMoreTokens() ) {
				arrlist.add(j++, st.nextToken());
			}
		}
		return arrlist;
	}	
	
	/** 
	 * EES_CIM_0072 <br>
	 * Uncollected UC Authorizer Retrieve<br>
	 *
	 * @param UncollectedCargoAuthorizerVO uncollectedCargoAuthorizerVO
	 * @return List<UncollectedCargoAuthorizerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UncollectedCargoAuthorizerVO> searchUncollectedCargoAuthorizer(UncollectedCargoAuthorizerVO uncollectedCargoAuthorizerVO) throws DAOException {
					
		DBRowSet dbRowset = null;
		List<UncollectedCargoAuthorizerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(uncollectedCargoAuthorizerVO != null){
				Map<String, String> mapVO = uncollectedCargoAuthorizerVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UncollectedCargoDBDAOSearchUncollectedCargoAuthorizerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UncollectedCargoAuthorizerVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	/** 
	 * EES_CIM_0072 <br>
	 * Uncollected UC Authorizer Check<br>
	 *
	 * @param UncollectedCargoAuthorizerVO uncollectedCargoAuthorizerVO
	 * @return List<UncollectedCargoAuthorizerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UncollectedCargoAuthorizerVO> checkAuthorizerInputId(UncollectedCargoAuthorizerVO uncollectedCargoAuthorizerVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<UncollectedCargoAuthorizerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(uncollectedCargoAuthorizerVO != null){
				Map<String, String> mapVO = uncollectedCargoAuthorizerVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UncollectedCargoDBDAOCheckUncollectedCargoAuthorizerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UncollectedCargoAuthorizerVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	
	/**
	 * Uncollected UC Authorizer Retrieve SAVE<br>
	 * 
	 * @param  uncollectedCargoAuthorizerVO List<UncollectedCargoAuthorizerVO>
	 * @throws DAOException
	 */
	public void manageUncollectedCargoAuthorizer(List<UncollectedCargoAuthorizerVO> uncollectedCargoAuthorizerVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(uncollectedCargoAuthorizerVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new UncollectedCargoDBDAOManageUncollectedCargoAuthorizerRSQL(), uncollectedCargoAuthorizerVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * Uncollected UC Authorizer Retrieve DEL<br>
	 * 
	 * @param  String usrid
	 * @throws DAOException
	 */
	public void manageUncollectedCargoAuthorizerDel(String usrid) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			if(!"".equals(usrid) ){
				param.put("usrid", usrid);
				
			}
//				insCnt = sqlExe.exec executeBatch((ISQLTemplate)new UncollectedCargoDBDAODelUncollectedCargoAuthorizerRSQL(), null,null);
				int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new UncollectedCargoDBDAODelUncollectedCargoAuthorizerDSQL(), null, null);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update Master SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/**
	 * EES_CIM_0063 <br>
	 * Check Authority <br>
	 * 
	 * @param UncollectedCargoVO uncollectedCargoVO
	 * @param String usrid
	 * @return String
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public String checkOfAuthority(UncollectedCargoVO uncollectedCargoVO, String usrid) throws DAOException {
		
		DBRowSet dbRowset = null;
		String strReturn = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
				param.put("usr_id",usrid);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UncollectedCargoDBDAOSearchUncollectedAuthorityRSQL(), param, null);
			if(dbRowset.next()) {
				strReturn = dbRowset.getString("isauthority");
				strReturn = strReturn+","+dbRowset.getString("uc_auth_ofc_cd");
			} 
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strReturn;
	}	
	
	/**
	 * CGO CNNTR 조회 <br>
	 *
	 * @param String strUcCsNo
	 * @param String strBlNo
	 * @param String strChk
	 * @return List<SearchUncollectedVolDtlListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<SearchUncollectedVolDtlListVO> searchUncollectedCargoContainerList(String strUcCsNo, String strBlNo, String strChk) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchUncollectedVolDtlListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				param.put("uc_cs_no", strUcCsNo);
				param.put("bl_no", strBlNo);
				velParam.put("flag", strChk);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new UncollectedCargoDBDAOSearchUncollectedCargoContainerRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchUncollectedVolDtlListVO.class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
	}	
}