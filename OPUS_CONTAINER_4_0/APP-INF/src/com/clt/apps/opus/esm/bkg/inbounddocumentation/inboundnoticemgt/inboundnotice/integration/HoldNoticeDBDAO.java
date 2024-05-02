/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HoldNoticeDAO.java
*@FileTitle : Hold Mail/Alert Set-Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.06 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.common.CountryCode;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.HoldNoticeBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ConfirmHldNtcSendListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.HldNtcBkgStaffSetupInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.HldNtcObStaffSetupInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.HldNtcSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.HldNtcStaffInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PreHldNtcSendListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.TpbInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.BkgBookingVO;
import com.clt.syscommon.common.table.BkgCstmsAdvDspoVO;
import com.clt.syscommon.common.table.BkgHldN3rdPtyBilCntrVO;
import com.clt.syscommon.common.table.BkgHldNtcDtlVO;
import com.clt.syscommon.common.table.BkgHldNtcUsrVO;
import com.clt.syscommon.common.table.BkgHldNtcVO;
import com.clt.syscommon.common.table.BkgHldWdDtlVO;
import com.clt.syscommon.common.table.BkgHldWdVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;


/**
 *   HoldNoticeDAO <br>
 * - InboundBLMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author
 * @see HoldNoticeBCImpl 참조
 * @since J2EE 1.4
 */
public class HoldNoticeDBDAO extends DBDAOSupport {

	
	/**
	 * 로그를 기록한다.<br>
	 * 
	 * @param String modName
	 * @param String applInfo
	 * @param String logDesc
	 * @exception DAOException
	 */
	public void addOpusLog(String modName, String applInfo, String logDesc) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

log.info("HoldNoticeDBDAO.addLog()==>OPUS_LOG_PRC(SYSDATE, " + modName + ", " + logDesc + ", " + applInfo + ")");

			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("mod_name",  modName);
			mapVO.put("appl_info", applInfo);
			mapVO.put("log_desc",  logDesc);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter("").executeSP((ISQLTemplate)new HoldNoticeDBDAOPrcExecLogCSQL(), param, velParam);
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}

	
    /**
	 * HoldNoticeDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String cstmsLocCd Location Code
	 * @param String userId User ID
	 * @return List<BkgHldNtcUsrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgHldNtcUsrVO> searchHldNtcUsr(String cstmsLocCd, String userId) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
						
			Map<String, String> mapVO = new HashMap();
			
			mapVO.put("loc_cd", cstmsLocCd);
			mapVO.put("user_id", userId);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HoldNoticeDBDAOsearchHldNtcUsrRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, BkgHldNtcUsrVO .class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	 
	/**
	 * 특정 국가별로 등록된 Hold Code 정보를 조회한다.<br>
	 *
	 * @param String cntCd 국가코드
	 * @return List<BkgComboVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgComboVO> searchHldNtcCode(String cntCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{				
			
			Map<String, String> mapVO = new HashMap();
			
			mapVO.put("cnt_cd", cntCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HoldNoticeDBDAOsearchHldNtcCodeRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, BkgComboVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	 }
	
	 
	/**
	 * Hold Notice User 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param BkgHldNtcUsrVO hldNtcUsr Hold Notice User Information
	 * @return int
	 * @exception DAOException
	 */
	public int addHldNtcUsr(BkgHldNtcUsrVO hldNtcUsr) throws DAOException {
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (hldNtcUsr != null) {
				Map<String, String> mapVO = hldNtcUsr.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new HoldNoticeDBDAOaddHldNtcUsrCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			
			return result;
		
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Hold Notice User 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param BkgHldNtcUsrVO hldNtcUsr Hold Notice User Information
	 * @return int
	 * @exception DAOException
	 */
	public int modifyHldNtcUsr(BkgHldNtcUsrVO hldNtcUsr) throws DAOException {
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (hldNtcUsr != null) {
				Map<String, String> mapVO = hldNtcUsr.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new HoldNoticeDBDAOmodifyHldNtcUsrUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Update SQL");
			
			return result;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 신규 Hold Notice User 데이터 유효성을 체크한다.
	 * 1. POD 유효성을 체크한다.
	 * 2. 중복데이터 존재 여부를 확인한다.<br>
	 * 
	 * @param BkgHldNtcUsrVO hldNtcUsr Hold Notice User Information
	 * @return boolean true-데이터 유효함, false-데이터 유효하지 않음
	 * @exception DAOException
	 */
	public boolean checkHldNtcUsrDup (BkgHldNtcUsrVO hldNtcUsr) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {
			
			if (hldNtcUsr != null) {
				Map<String, String> mapVO = hldNtcUsr.getColumnValues();
				
				param.putAll(mapVO);
	            velParam.putAll(mapVO);
			}
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HoldNoticeDBDAOCheckHldNtcUsrDupRSQL(), param, velParam);
            if (dbRowset.next()) return true;
            else return false;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

	/**
	 * Hold Notice User 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param List<BkgHldNtcUsrVO> hldNtcUsr Hold Notice User Information
	 * @exception DAOException
	 */
	public void removeHldNtcUsr(List<BkgHldNtcUsrVO> hldNtcUsr) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(hldNtcUsr != null && hldNtcUsr.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new HoldNoticeDBDAOremoveHldNtcUsrDSQL(), hldNtcUsr,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	 
	   
	 /**
	  * 기 등록된 Hold Notice Form화면에 POD 목록 정보를 조회한다.<br>
	  * 
	 * @param String ofcCd
	 * @param String hldNtcTpCd
	 * @return List<BkgHldWdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgHldWdVO> searchHldNtcFormPodList(String ofcCd, String hldNtcTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			Map<String, String> mapVO = new HashMap<String, String>();
		
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("hld_ntc_tp_cd", hldNtcTpCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HoldNoticeDBDAOsearchHldNtcFormPodListRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, BkgHldWdVO .class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Pre Hold Notice 전송방식과 내용에 따른 Setup 선택 및 Original B/L 추가 송부 Setup정보 등을 조회한다.
	 * 
	 * @param String ofcCd
	 * @param String podCd
	 * @param String ntcTpCd
	 * @return BkgHldWdVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgHldWdVO searchHldNtcForm(String ofcCd, String podCd, String ntcTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgHldWdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("ofc_cd",    ofcCd);
			mapVO.put("pod_cd",    podCd);
			mapVO.put("hld_ntc_tp_cd", ntcTpCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HoldNoticeDBDAOsearchHldNtcFormRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgHldWdVO .class);
			
			if (list != null && list.size() > 0) 
				return list.get(0);
			else return null;
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * HOLD NOTICE의 FORM에 출력될 고정 문구(IMPORTANT NOTICE)를 조회한다.
	 * 
	 * @param String ofcCd
	 * @param String podCd
	 * @param String ntcTpCd
	 * @return List<BkgHldWdDtlVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgHldWdDtlVO> searchHldNtcFormDtl(String ofcCd, String podCd, String ntcTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("ofc_cd",    ofcCd);
			mapVO.put("pod_cd",    podCd);
			mapVO.put("hld_ntc_tp_cd", ntcTpCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HoldNoticeDBDAOsearchHldNtcFormDtlRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, BkgHldWdDtlVO .class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	
	/**
	 *  특정 국가별로 등록된 Hold Code정보를 생성한다. <br>
	 *  
	 * @param List<BkgHldWdVO> hldWd
	 * @exception DAOException
	 */
	public void mergeHldNtcForm(List<BkgHldWdVO> hldWd) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(hldWd != null && hldWd.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new HoldNoticeDBDAOmergeHldNtcFormCSQL(), hldWd, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * 특정 국가별로 등록된 Hold Code정보를 생성한다. <br>
	 * 
	 * @param List<BkgHldWdDtlVO> hldWdDtl
	 * @exception DAOException
	 */
	public void mergeHldNtcFormDtl(List<BkgHldWdDtlVO> hldWdDtl) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(hldWdDtl != null && hldWdDtl.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new HoldNoticeDBDAOmergeHldNtcFormDtlCSQL(), hldWdDtl, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	
	/**
	 * 특정 Location별로 등록된 H/N Form Master정보를 삭제한다. <br>
	 * 
	 * @param String ofcCd
	 * @param String podCd
	 * @param String ntcTpCd
	 * @exception DAOException
	 */
	public void removeHldNtcForm(String ofcCd, String podCd, String ntcTpCd) throws DAOException {
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try 
		{
			Map<String, String> mapVO = new HashMap<String,String>();
	
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("pod_cd", podCd);
			mapVO.put("hld_ntc_tp_cd", ntcTpCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new HoldNoticeDBDAOremoveHldNtcFormDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	
	/**
	 * 특정 Location별로 등록된 H/N Form Tab 정보를 삭제한다. <br>
	 * 
	 * @param String ofcCd
	 * @param String podCd
	 * @param String ntcTpCd
	 * @exception DAOException
	 */
	public void removeHldNtcFormDtl(String ofcCd, String podCd, String ntcTpCd) throws DAOException {
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try 
		{
			Map<String, String> mapVO = new HashMap<String,String>();
	
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("pod_cd", podCd);
			mapVO.put("hld_ntc_tp_cd", ntcTpCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new HoldNoticeDBDAOremoveHldNtcFormDtlDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 기 입력된 Pre-Hold Notice Setup 정보를 Check한다.<br>
	 * 
	 * @param String ofcCd
	 * @param String podCd
	 * @param String ntcTpCd
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean checkHldNtcFormExist(String ofcCd, String podCd, String ntcTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("ofc_cd",        ofcCd);
			mapVO.put("pod_cd",        podCd);
			mapVO.put("hld_ntc_tp_cd", ntcTpCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HoldNoticeDBDAOsearchHldNtcFormRSQL(), param, velParam);
			
			if (dbRowset != null && dbRowset.next()) return true;
			else return false;

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	
	/**
	 * 기 입력된 Pre-Hold Notice Setup 정보를 Copy한다.<br>
	 * 
	 * @param String toOfcCd
	 * @param String toPodCd
	 * @param String fmOfcCd
	 * @param String fmPodCd
	 * @param String ntcTpCd
	 * @param String usrId
	 * @exception DAOException
	 */
	public void copyHldNtcPreForm(String toOfcCd, String toPodCd, String fmOfcCd, String fmPodCd, String ntcTpCd, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("ofc_cd",        toOfcCd);
			mapVO.put("pod_cd",        toPodCd);
			mapVO.put("fm_ofc_cd",     fmOfcCd);
			mapVO.put("fm_pod_cd",     fmPodCd);
			mapVO.put("hld_ntc_tp_cd", ntcTpCd);
			mapVO.put("cre_usr_id",    usrId);
			mapVO.put("upd_usr_id",    usrId);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new HoldNoticeDBDAOcopyHldNtcPreFormCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * 기 입력된 Pre-Hold Notice Setup 정보를 Copy한다.<br>
	 * 
	 * @param String toOfcCd
	 * @param String toPodCd
	 * @param String fmOfcCd
	 * @param String fmPodCd
	 * @param String ntcTpCd
	 * @param String usrId
	 * @exception DAOException
	 */
	public void copyHldNtcPreFormDtl(String toOfcCd, String toPodCd, String fmOfcCd, String fmPodCd, String ntcTpCd, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("ofc_cd",        toOfcCd);
			mapVO.put("pod_cd",        toPodCd);
			mapVO.put("fm_ofc_cd",     fmOfcCd);
			mapVO.put("fm_pod_cd",     fmPodCd);
			mapVO.put("hld_ntc_tp_cd", ntcTpCd);
			mapVO.put("cre_usr_id",    usrId);
			mapVO.put("upd_usr_id",    usrId);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new HoldNoticeDBDAOcopyHldNtcPreFormDtlCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * 기 입력된 Pre-Hold Notice Setup 정보를 Check한다.<br>
	 * 
	 * @param String ofcCd
	 * @param String podCd
	 * @param String hldNtcTpCd
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean checkHldNtcFormExistByNtcType(String ofcCd, String podCd, String hldNtcTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("pod_cd", podCd);
			mapVO.put("hld_ntc_tp_cd", hldNtcTpCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HoldNoticeDBDAOcheckHldNtcFormExistByNtcTypeRSQL(), param, velParam);
			
			if (dbRowset != null && dbRowset.next()) return true;
			else return false;

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

		
	/**
	 * 세관 EDI정보에서 Hold정보를 자동  인식해서 발송된 Pre-Hold Notice내역 정보를 조회한다.( 미주지역만 해당)<br>
	 * 
	 * @param HldNtcSearchVO hldNtcSearch
	 * @return List<PreHldNtcSendListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PreHldNtcSendListVO> searchHldNtcSendListByPre(HldNtcSearchVO hldNtcSearch) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(hldNtcSearch != null){
				Map<String, String> mapVO = hldNtcSearch.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HoldNoticeDBDAOsearchHldNtcSendListByPreRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, PreHldNtcSendListVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

	/**
	 * 세관 EDI정보에서 Hold에 대한 Clear(Confirm) Event가 발생한 대상 정보를 조화한다.( 미주지역만 해당)<br>
	 * 
	 * @param HldNtcSearchVO hldNtcSearch
	 * @return List<PreHldNtcSendListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ConfirmHldNtcSendListVO> searchHldNtcSendListByConfirm(HldNtcSearchVO hldNtcSearch) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(hldNtcSearch != null){
				Map<String, String> mapVO = hldNtcSearch.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HoldNoticeDBDAOsearchHldNtcSendListByConfirmRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, ConfirmHldNtcSendListVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	
	/**
	 * Hold Notice Master 정보 수정 한다.<br>
	 * 
	 * @param BkgHldNtcVO hldNtc
	 * @exception DAOException
	 */
	public void modifyHldNtc(BkgHldNtcVO hldNtc) throws DAOException {
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (hldNtc != null) {
				Map<String, String> mapVO = hldNtc.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new HoldNoticeDBDAOmodifyHldNtcUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Update SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
	
	/**
	 * Hold Notice 수화주 정보를 수정 한다.<br>
	 * 
	 * @param BkgHldNtcDtlVO hldNtcDtl
	 * @exception DAOException 
	 */
	public void modifyHldNtcDtlByFax (BkgHldNtcDtlVO hldNtcDtl) throws DAOException {
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (hldNtcDtl != null) {
				Map<String, String> mapVO = hldNtcDtl.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new HoldNoticeDBDAOmodifyHldNtcDtlByFaxUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Update SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
	/**
	 * Fax 전송 후 전송 ID ( Send ID ) 값을 저장한다.<br>
	 * 
	 * @param String bkgNo
	 * @param String ntcSeq
	 * @param String custCntcTpCd
	 * @param String faxNtcSndId
	 * @exception DAOException
	 */
	public void modifyHldNtcSendIdByFax ( String bkgNo, String ntcSeq, String custCntcTpCd, String faxNtcSndId) throws DAOException {
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bkg_no",             bkgNo);
			mapVO.put("ntc_seq",            ntcSeq);
			mapVO.put("cust_cntc_tp_cd",    custCntcTpCd);
			mapVO.put("hld_fax_snd_id",     faxNtcSndId);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new HoldNoticeDBDAOmodifyHldNtcSendIdByFaxUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Update SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
	/**
	 * Hold Notice 수화주 정보를 수정 한다.<br>
	 * 
	 * @param BkgHldNtcDtlVO hldNtcDtl
	 * @exception DAOException
	 */
	public void modifyHldNtcDtlByEmail (BkgHldNtcDtlVO hldNtcDtl) throws DAOException {
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (hldNtcDtl != null) {
				Map<String, String> mapVO = hldNtcDtl.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new HoldNoticeDBDAOmodifyHldNtcDtlByEmailUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Update SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
	
	/**
	 * <br>
	 * 
	 * @param BkgNtcHisVO bkgNtcHisVO
	 * @return BkgNtcHisVO
	 * @exception DAOException
	 */
	public BkgNtcHisVO searchHldNtcHistory(BkgNtcHisVO bkgNtcHisVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgNtcHisVO != null){
				Map<String, String> mapVO = bkgNtcHisVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HoldNoticeDBDAOsearchHldNtcHistoryRSQL(), param, velParam);
			List<BkgNtcHisVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgNtcHisVO.class);
			
			if (list != null && list.size() > 0) 
				return list.get(0);
			else return null;
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * <br>
	 * 
	 * @param String bkgNo
	 * @param String ntcSeq
	 * @return List<BkgHldN3rdPtyBilCntrVO>
	 * @throws DAOException
	 */
	public List<BkgHldN3rdPtyBilCntrVO> searchHldN3rdPtyBilCntr(String bkgNo, String ntcSeq) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("ntc_seq", ntcSeq);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HoldNoticeDBDAOsearchHldN3rdPtyBilCntrRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, BkgHldN3rdPtyBilCntrVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * Email 전송 후 전송 ID ( Send ID ) 값을 저장한다.<br>
	 * 
	 * @param String bkgNo
	 * @param String ntcSeq
	 * @param String custCntcTpCd
	 * @param String emlNtcSndId
	 * @exception DAOException
	 */
	public void modifyHldNtcSendIdByEmail (String bkgNo, String ntcSeq, String custCntcTpCd, String emlNtcSndId ) throws DAOException {
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bkg_no",             bkgNo);
			mapVO.put("ntc_seq",            ntcSeq);
			mapVO.put("cust_cntc_tp_cd",    custCntcTpCd);
			mapVO.put("hld_eml_snd_id",     emlNtcSndId);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new HoldNoticeDBDAOmodifyHldNtcSendIdByEmailUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Update SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
	
	/**
	 * <br>
	 * 
	 * @param List<BkgHldN3rdPtyBilCntrVO> hldNtc Hold Notice Information
	 * @exception DAOException
	 */
	public void modifyTpbInfo(List<BkgHldN3rdPtyBilCntrVO> hldNtc) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(hldNtc != null && hldNtc.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new HoldNoticeDBDAOmodifyTpbInfoUSQL(), hldNtc,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Hold Notice 의 Bkg No.별 다음 시퀀스를 가져온다.<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchHldNtcNextSeq (String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
		try {
			String ntcSeq = "";
			
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
            velParam.putAll(mapVO);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HoldNoticeDBDAOsearchHldNtcNextSeqRSQL(), param, velParam);
            if (dbRowset != null && dbRowset.next()) {
            	ntcSeq = dbRowset.getString("ntc_seq");
            }
            
            return ntcSeq;
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}	
	
	
	/**
	 * <br>
	 * 
	 * @param String hldTpCd
	 * @param String hldCd
	 * @param String rlseHldCd
	 * @return BkgCstmsAdvDspoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCstmsAdvDspoVO searchHldNtcFlg (String hldTpCd, String hldCd, String rlseHldCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			List <BkgCstmsAdvDspoVO> list = null;
			
			Map<String, String> mapVO = new HashMap<String, String>();
		
			mapVO.put("hld_ntc_tp_cd", hldTpCd);
			mapVO.put("cstms_dspo_cd", hldCd);
			mapVO.put("cstms_pair_dspo_cd", rlseHldCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HoldNoticeDBDAOsearchHldNtcFlgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvDspoVO.class);
			
			if (list != null && list.size() > 0) 
				return list.get(0);
			else return null;
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	
	
	/**
	 * <br>
	 * 
	 * @param String hldCd
	 * @return BkgCstmsAdvDspoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCstmsAdvDspoVO searchWnFlg (String hldCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			List <BkgCstmsAdvDspoVO> list = null;
			
			Map<String, String> mapVO = new HashMap<String, String>();
		
			mapVO.put("cstms_dspo_cd", hldCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HoldNoticeDBDAOsearchWnFlgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvDspoVO.class);
			
			if (list != null && list.size() > 0) 
				return list.get(0);
			else return null;
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	
	/**
	 * <br>
	 * 
	 * @param String blNo
	 * @param String cntCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchHldBkgVVD (String blNo, String cntCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String vvd = "";

		try{
			
			Map<String, String> mapVO = new HashMap<String, String>();
		
			mapVO.put("bl_no", blNo);
			mapVO.put("cnt_cd", cntCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HoldNoticeDBDAOsearchHldBkgVVDRSQL(), param, velParam);
			
			if (dbRowset != null && dbRowset.next()) {
				vvd = dbRowset.getString("vvd");
			}

			return vvd;
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
		
	
	/**
	 * @param String blNo
	 * @return List<CustInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustInfoVO> searchBkgCustInfo(String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bl_no", blNo);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HoldNoticeDBDAOsearchBkgCustInfoRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, CustInfoVO .class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}

	
	/**
	 * Pre Hold Notice 전송방식과 내용에 따른 Setup 선택 및 Original B/L 추가 송부 Setup정보 등을 조회한다.<br>
	 * 
	 * @param String locCd
	 * @param String podCd
	 * @param String ntcTpCd
	 * @return BkgHldWdVO
	 * @exception DAOException 
	 */
	@SuppressWarnings("unchecked")
	public BkgHldWdVO searchHldNtcSetupInfo (String locCd, String podCd, String ntcTpCd ) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgHldWdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("loc_cd",    locCd);
			mapVO.put("pod_cd",    podCd);
			mapVO.put("hld_ntc_tp_cd", ntcTpCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HoldNoticeDBDAOsearchHldNtcSetupInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgHldWdVO .class);
			
			if (list != null && list.size() > 0) 
				return list.get(0);
			else return null;
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	

	/**
	 *  특정 국가별로 등록된 Hold Code정보를 생성한다. <br>
	 *  
	 * @param BkgHldNtcVO hldNtc
	 * @exception DAOException
	 */
	public void addHldNtc(BkgHldNtcVO hldNtc) throws DAOException {
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (hldNtc != null) {
				Map<String, String> mapVO = hldNtc.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new HoldNoticeDBDAOaddHldNtcCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
	
	/**
	 * @param BkgHldNtcVO hldNtc
	 * @exception DAOException
	 */
	public void copyHldNtcCntrList(BkgHldNtcVO hldNtc) throws DAOException {
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (hldNtc != null) {
				Map<String, String> mapVO = hldNtc.getColumnValues();
				
				mapVO.put("cnt_cd", "US"); // 향후 파라미터로 넣어야 함!!
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new HoldNoticeDBDAOcopyHldNtcCntrListCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
	/**
	 * @param List<BkgHldNtcDtlVO> hldNtcDtl
	 * @exception DAOException
	 */
	public void addHldNtcDtl (List<BkgHldNtcDtlVO> hldNtcDtl) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(hldNtcDtl != null && hldNtcDtl.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new HoldNoticeDBDAOaddHldNtcDtlCSQL(), hldNtcDtl, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 
	 * @param String bkgNo
	 * @param String ntcSeq
	 * @param String bkgCustTpCd
	 * @return List<BkgNtcHisVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgNtcHisVO> searchArrNtcSndHist(String bkgNo, String ntcSeq, String bkgCustTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("ntc_seq", ntcSeq);
			mapVO.put("bkg_cust_tp_cd", bkgCustTpCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HoldNoticeDBDAOsearchArrNtcSndHistRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, BkgNtcHisVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Hold Mail/Alert Set-Up에서 대화주 Hold Notice 송부와 별도로 내부적으로 
	 * 자동 Mail or/and Alert를 받기를 희망하는 Staff에 의해 Setting된 정보를 조회한다.<br>
	 * 
	 * @param String cstmsLocCd
	 * @param String cstmsHldCD
	 * @return List<BkgHldNtcUsrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<HldNtcStaffInfoVO> searchHldNtcStaffInfo (String cstmsLocCd, String cstmsHldCD) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			Map<String, String> mapVO = new HashMap<String, String>();
		
			mapVO.put("cstms_loc_cd", cstmsLocCd);
			mapVO.put("cstms_hld_cd", cstmsHldCD);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HoldNoticeDBDAOsearchHldNtcStaffInfoRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, HldNtcStaffInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * <br>
	 * 
	 * @param String blNo
	 * @param String cntCd
	 * @return List<HldNtcObStaffSetupInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<HldNtcObStaffSetupInfoVO> searchHldNtcObStaffSetupInfo (String blNo, String cntCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			Map<String, String> mapVO = new HashMap<String, String>();
		
			mapVO.put("bl_no", blNo);
			mapVO.put("cnt_cd", cntCd);
			// CountyCode 가 US이면 MI, CA이면 A6A
			if(CountryCode.US.equals(cntCd)){
				mapVO.put("msg_tp_id", "MI");
			} else {
				mapVO.put("msg_tp_id", "A6A");
			}
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HoldNoticeDBDAOsearchHldNtcObStaffSetupInfoRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, HldNtcObStaffSetupInfoVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param String bkgNo
	 * @param String ntcSeq
	 * @return List<TpbInfoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<TpbInfoVO> searchTpbInfo(String bkgNo, String ntcSeq) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("ntc_seq", ntcSeq);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HoldNoticeDBDAOsearchTpbInfoRSQL(), param, velParam);
			return (List)RowSetUtil.rowSetToVOs(dbRowset, TpbInfoVO .class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	 
	 
	/**
	 * <br>
	 * 
	 * @param String hldCd
	 * @return BkgCstmsAdvDspoVO
	 * @throws DAOException
	 */
	public BkgCstmsAdvDspoVO searchBkgCstmsAdvDspo (String hldCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			List <BkgCstmsAdvDspoVO> list = null;
			
			Map<String, String> mapVO = new HashMap<String, String>();
		
			mapVO.put("cstms_dspo_cd", hldCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HoldNoticeDBDAOsearchBkgCstmsAdvDspoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsAdvDspoVO.class);
			
			if (list != null && list.size() > 0) 
				return list.get(0);
			else return null;
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}	 
	 
	
	/**
	 * <br>
	 * 
	 * @param String blNo
	 * @return BkgBookingVO
	 * @throws DAOException
	 */
	public BkgBookingVO searchBkgBookingByBlNo (String blNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			Map<String, String> mapVO = new HashMap<String, String>();
		
			mapVO.put("bl_no", blNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HoldNoticeDBDAOsearchBkgBookingByBlNoRSQL(), param, velParam);
			List <BkgBookingVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBookingVO.class);
			
			if (list != null && list.size() > 0) 
				return list.get(0);
			else return null;
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * <br>
	 * 
	 * @param String blNo
	 * @return HldNtcBkgStaffSetupInfoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public HldNtcBkgStaffSetupInfoVO searchHldNtcBkgStaffSetupInfo (String blNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			Map<String, String> mapVO = new HashMap<String, String>();
		
			mapVO.put("bl_no", blNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new HoldNoticeDBDAOsearchHldNtcBkgStaffSetupInfoRSQL(), param, velParam);
			List <HldNtcBkgStaffSetupInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, HldNtcBkgStaffSetupInfoVO .class);
			
			if (list != null && list.size() > 0) 
				return list.get(0);
			else return null;
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
}
