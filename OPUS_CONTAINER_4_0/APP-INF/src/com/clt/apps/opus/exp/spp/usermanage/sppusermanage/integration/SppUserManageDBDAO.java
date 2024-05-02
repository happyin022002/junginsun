/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SppUserManageDBDAO.java
*@FileTitle : SppUserManage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier : 안준상
*@LastVersion : 1.0
* 2009.07.30 안준상
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.exp.spp.usermanage.sppusermanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.exp.spp.usermanage.sppusermanage.basic.SppUserManageBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.MdmVendorVO;
import com.clt.syscommon.common.table.MnrPartnerVO;
import com.clt.syscommon.common.table.MnrPrnrCntcPntVO;


/**
 * ALPS SppUserManageDBDAO <br>
 * - ALPS-usermanage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author jsahn
 * @see SppUserManageBCImpl 참조
 * @since J2EE 1.6
 */
public class SppUserManageDBDAO extends DBDAOSupport {

	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param sp_ptal_id sp_ptal_id
	 * @return List<MnrPartnerVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MnrPartnerVO> searchSppUserBidInfoData(String sp_ptal_id) throws DAOException {
		DBRowSet dbRowset = null;
		List<MnrPartnerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			
			param.put("sp_ptal_id",sp_ptal_id);
			velParam.put("sp_ptal_id",sp_ptal_id);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SppUserManageDBDAOMnrPartnerVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MnrPartnerVO .class);
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
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param sp_ptal_id sp_ptal_id
	 * @return List<MnrPrnrCntcPntVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MnrPrnrCntcPntVO> searchSppUserBidInfosData(String sp_ptal_id) throws DAOException {
		DBRowSet dbRowset = null;
		List<MnrPrnrCntcPntVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			
			param.put("sp_ptal_id",sp_ptal_id);
			velParam.put("sp_ptal_id",sp_ptal_id);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SppUserManageDBDAOMnrPartnerVOSRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MnrPrnrCntcPntVO .class);
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
	 * Vendor에 대한 데이타 모델목록을 조회합니다.<br>
	 * 
	 * @param String vndrSeq
	 * @return List<MdmVendorVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmVendorVO> searchMdmVendorInfoData(String vndrSeq) throws DAOException {
	
		DBRowSet dbRowset = null;
		List<MdmVendorVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if ( !JSPUtil.getNull(vndrSeq).equals("") ) {
				param.put("vndr_seq", vndrSeq);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SppUserManageDBDAOMdmVendorVORSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVendorVO.class);
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
	 * Bid user 정보를 등록합니다.<br>
	 * 
	 * @param mnrPartnerVO   MnrPartnerVO
	 * @exception DAOException
	 */
	public void insertSppUserBidInfoData(MnrPartnerVO mnrPartnerVO) throws DAOException,Exception {
		
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = mnrPartnerVO.getColumnValues();
			
			param.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SppUserManageDBDAOMnrPartnerVOCSQL(), param, param);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to indert SQL");
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
	 * MnrPartner contact info 데이터를 생성한다.<br>
	 * 
	 * @param List<MnrPrnrCntcPntVO> insModels
	 * @exception DAOException
	 */
	public void insertSppUserBidInfosData(List<MnrPrnrCntcPntVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SppUserManageDBDAOMnrPartnerVOSCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insertSppUserBidInfosData ins No"+ i + " SQL");
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
	 * Bid user 정보를 수정합니다.<br>
	 * 
	 * @param mnrPartnerVO   MnrPartnerVO
	 * @exception DAOException
	 */
	public void modifySppUserBidInfoData(MnrPartnerVO mnrPartnerVO) throws DAOException,Exception {
		
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = mnrPartnerVO.getColumnValues();
			
			param.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SppUserManageDBDAOMnrPartnerVOUSQL(), param, param);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to indert SQL");
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
	 * MnrPartner contact info 데이터를 수정한다.<br>
	 * 
	 * @param List<MnrPrnrCntcPntVO> updModels
	 * @exception DAOException
	 */
	public void modifySppUserBidInfosData(List<MnrPrnrCntcPntVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){ 
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SppUserManageDBDAOMnrPartnerVOSUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifySppUserBidInfosData upd No"+ i + " SQL");
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
	 * Bid contact user 정보를 삭제합니다.<br>
	 * 
	 * @param mnrPartnerVO   MnrPartnerVO
	 * @exception DAOException
	 */
	public void deleteSppUserBidInfosData(MnrPartnerVO mnrPartnerVO) throws DAOException,Exception {
		
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = mnrPartnerVO.getColumnValues();
			
			param.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SppUserManageDBDAOMnrPartnerVOSDSQL(), param, param);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to indert SQL");
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
	 * Bid user 정보를 수정합니다.<br>
	 * 
	 * @param MdmVendorVO mdmVendorVO
	 * @exception DAOException
	 */
	public void modifySppUserPsoInfoData(MdmVendorVO mdmVendorVO) throws DAOException,Exception {
		
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = mdmVendorVO.getColumnValues();
			
			param.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new SppUserManageDBDAOPsoPartnerUSQL(), param, param);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to indert SQL");
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
	  * 시퀀스를 조회 생성한다.<br>
	  *  
	  * @return String returnVal
	  * @exception DAOException  
	  */   
	 public String addMnrPartnerSeqData() throws DAOException{
	 	DBRowSet dbRowset = null;    
	 	String returnVal = "";
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	//velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();
	 	
	 	try{
	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SppUserManageDBDAOMnrPartnerSeqRSQL(), param, velParam);
	 		if(dbRowset.next()){ 
	 			returnVal = dbRowset.getString("SEQ");
	 		}
	 	}catch(SQLException se){
	 		log.error(se.getMessage(),se); 
	 		throw new DAOException(new ErrorHandler(se).getMessage());
	 	}catch(Exception ex){
	 		log.error(ex.getMessage(),ex);  	
	 		throw new DAOException(new ErrorHandler(ex).getMessage());
	 	}    
	 	return returnVal;
	 }
}