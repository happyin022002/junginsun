/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTOfficeInfoDBDAO.java
*@FileTitle : 중국 Outbound 대리점 정보 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.28
*@LastModifier : 이호진
*@LastVersion : 1.0
* 2009.07.28 이호진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtmaster.agtofficeinfo.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.agt.agtmaster.agtofficeinfo.basic.AGTOfficeInfoBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.AgtChnLaneAgnVO;
import com.clt.syscommon.common.table.AgtChnVslAgnVO;
import com.clt.syscommon.common.table.BkgChnAgnVO;


/**
 * OPUS AGTOfficeInfoDBDAO <br>
 * - OPUS-AGTMaster system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Lee Ho Jin
 * @see AGTOfficeInfoBCImpl 참조
 * @since J2EE 1.6
 */
public class AGTOfficeInfoDBDAO extends DBDAOSupport {

	/**
	 * (ESM_AGT_022) 중국 Outbound 대리점 정보 관리의 모든 목록을 가져온다<br>
	 * 
	 * @param BkgChnAgnVO bkgChnAgnVO
	 * @return List<BkgChnAgnVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgChnAgnVO> searchChinaBKGAgentList(BkgChnAgnVO bkgChnAgnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgChnAgnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgChnAgnVO != null){
				Map<String, String> mapVO = bkgChnAgnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTOfficeInfoDBDAOBkgChnAgnVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgChnAgnVO .class);
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
		 * (ESM_AGT_022) 중국 Outbound 대리점 정보 등록 화면-추가저장<br>
		 * @param BkgChnAgnVO bkgChnAgnVO
		 * @return int result
		 * @throws DAOException
		 */
		public int addChinaAgentCode (BkgChnAgnVO bkgChnAgnVO) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			try {
				if(bkgChnAgnVO != null){
					Map<String, String> mapVO = bkgChnAgnVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}							
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				result = sqlExe.executeUpdate((ISQLTemplate)new AGTOfficeInfoDBDAOBkgChnAgnVOCSQL(), param,velParam);
				
				if(result == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			 return result;
		}
		 /**
		 * (ESM_AGT_022) 중국 Outbound 대리점 정보 등록 화면-추가저장<br>
		 * @param List<BkgChnAgnVO> bkgChnAgnVOS
		 * @return int[]
		 * @throws DAOException
		 * @throws Exception
		 */
		public int[] addChinaAgentCodeS (List<BkgChnAgnVO> bkgChnAgnVOS) throws DAOException,Exception {
			int insCnt[] = null;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				if(bkgChnAgnVOS .size() > 0){
					insCnt = sqlExe.executeBatch((ISQLTemplate)new AGTOfficeInfoDBDAOBkgChnAgnVOCSQL(), bkgChnAgnVOS, null);
//					insCnt = sqlExe.executeBatch((ISQLTemplate)new BookingMasterMgtDAOSearchChinaAgentCodeCSQL(), bkgChnAgnVOS, null);
					for(int i = 0; i < insCnt.length; i++){
						if(insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return insCnt;
		}

		/**
		 * (ESM_AGT_022) 중국 Outbound 대리점 정보 등록 화면-수정<br>
		 * @param BkgChnAgnVO bkgChnAgnVO
		 * @return int result
		 * @throws DAOException
		 * @throws Exception
		 */
		public int modifyChinaAgentCode (BkgChnAgnVO bkgChnAgnVO) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
			try {
				if(bkgChnAgnVO != null){
					Map<String, String> mapVO = bkgChnAgnVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}							
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				result = sqlExe.executeUpdate((ISQLTemplate)new AGTOfficeInfoDBDAOBkgChnAgnVOUSQL(), param,velParam);
				
				if(result == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to update SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return result;
		}

		 /**
		 * (ESM_AGT_022) 중국 Outbound 대리점 정보 등록 화면-수정<br>
		 * @param List<BkgChnAgnVO> bkgChnAgnVOS
		 * @return int[]
		 * @throws DAOException
		 * @throws Exception
		 */
		public int[] modifyChinaAgentCodeS (List<BkgChnAgnVO> bkgChnAgnVOS) throws DAOException,Exception {
			int insCnt[] = null;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				if(bkgChnAgnVOS .size() > 0){
					insCnt = sqlExe.executeBatch((ISQLTemplate)new AGTOfficeInfoDBDAOBkgChnAgnVOUSQL(), bkgChnAgnVOS, null);
//					insCnt = sqlExe.executeBatch((ISQLTemplate)new BookingMasterMgtDAOSearchChinaAgentCodeUSQL(), bkgChnAgnVOS, null);
					for(int i = 0; i < insCnt.length; i++){
						if(insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to update No"+ i + " SQL");
					}
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return insCnt;
		}


		/**
		 * (ESM_AGT_022) 중국 Outbound 대리점 정보 등록 화면- 삭제<br>
		 * @param BkgChnAgnVO bkgChnAgnVO
		 * @throws DAOException
		 * @throws Exception
		 */
		public void removeChinaAgentCode (BkgChnAgnVO bkgChnAgnVO) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();						
			try {
				if(bkgChnAgnVO != null){
					Map<String, String> mapVO = bkgChnAgnVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}	
				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				int delCnt = sqlExe.executeUpdate((ISQLTemplate)new AGTOfficeInfoDBDAOBkgChnAgnVODSQL(), param,velParam);
				
				if(delCnt == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete SQL");
			} catch (SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}	


		 /**
		 * (ESM_AGT_022) 중국 Outbound 대리점 정보 등록 화면-수정<br>
		 * @param List<BkgChnAgnVO> bkgChnAgnVOS
		 * @return int[]
		 * @throws DAOException
		 * @throws Exception
		 */
		public int[] removeChinaAgentCodeS (List<BkgChnAgnVO> bkgChnAgnVOS) throws DAOException,Exception {
			int insCnt[] = null;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				if(bkgChnAgnVOS .size() > 0){
					insCnt = sqlExe.executeBatch((ISQLTemplate)new AGTOfficeInfoDBDAOBkgChnAgnVODSQL(), bkgChnAgnVOS, null);
					for(int i = 0; i < insCnt.length; i++){
						if(insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete No"+ i + " SQL");
					}
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return insCnt;
		}


	 /**
	 *  (ESM_AGT_023) 중국 Inbound 대리점 정보 관리의 모든 목록을 가져온다<br>
	 * @param agtChnLaneAgnVO
	 * @return List<AgtChnLaneAgnVO>
	 * @throws DAOException
	 */
	public List<AgtChnLaneAgnVO> searchLaneInboundAgentList(AgtChnLaneAgnVO agtChnLaneAgnVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<AgtChnLaneAgnVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
 
			try{
				if(agtChnLaneAgnVO != null){
					Map<String, String> mapVO = agtChnLaneAgnVO .getColumnValues();
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTOfficeInfoDBDAOAgtChnLaneAgnVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtChnLaneAgnVO .class);
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
	 * (ESM_AGT_023) 중국 Inbound 대리점 정보 저장 한다.<br>
	 * @param insModels
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiLaneInboundAgentList(List<AgtChnLaneAgnVO> insModels) throws DAOException,Exception{
		int insCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGTOfficeInfoDBDAOAgtChnLaneAgnVOCSQL(), insModels,null);
				for(int i=0; i<insCnt.length;i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return insCnt;
	}
	
	/**
	 * (ESM_AGT_023) 중국 Inbound 대리점 정보 수정 한다.<br>
	 * 
	 * @param List<AgtChnLaneAgnVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiLaneInboundAgentList(List<AgtChnLaneAgnVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AGTOfficeInfoDBDAOAgtChnLaneAgnVOUSQL(), updModels,null);
				for(int i=0; i<updCnt.length;i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	/**
	 * (ESM_AGT_023) 중국 Inbound 대리점 정보 수정 한다.<br>
	 * 
	 * @param List<AgtChnLaneAgnVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws EventException
	 */
	public int[] deletemultiLaneInboundAgentList(
			List<AgtChnLaneAgnVO> delModels) throws DAOException, EventException{
		int delCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AGTOfficeInfoDBDAOAgtChnLaneAgnVODSQL(), delModels,null);
				for(int i=0; i<delCnt.length;i++){
					if(delCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
		
	}
	/**
	 * (ESM_AGT_024) Inbound China Agent Office Info for Vessel 의 정보를 가져온다.<br>
	 * @param AgtChnVslAgnVO agtChnVslAgnVO
	 * @return List<AgtChnVslAgnVO>
	 * @throws DAOException
	 */
	public List<AgtChnVslAgnVO> searchInboundChinaOfficeInfoForVessel(
			AgtChnVslAgnVO agtChnVslAgnVO) throws DAOException{
		DBRowSet dbRowset = null;
		List<AgtChnVslAgnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agtChnVslAgnVO != null){
				Map<String, String> mapVO = agtChnVslAgnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
//			log.info("\n    param  =="+param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTOfficeInfoDBDAOAgtChnVslAgnVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgtChnVslAgnVO .class);
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
	 * (ESM_AGT_024) Inbound China Agent Office Info for Vessel 의 정보 저장 한다.<br>
	 * @param List<AgtChnVslAgnVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addmultiInboundChinaOfficeInfoForVessel(List<AgtChnVslAgnVO> insModels) throws DAOException,Exception{
		int insCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGTOfficeInfoDBDAOAgtChnVslAgnVOCSQL(), insModels,null);
				for(int i=0; i<insCnt.length;i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
			//throw new DAOException(new ErrorHandler("AGT00027", new String[]{"Vessel"}).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return insCnt;
	}
	/**
	 * (ESM_AGT_024) Inbound China Agent Office Info for Vessel 의 정보 저장 한다.<br>
	 * @param List<AgtChnVslAgnVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] deletemultiInboundChinaOfficeInfoForVessel(List<AgtChnVslAgnVO> insModels) throws DAOException,Exception{
		int insCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGTOfficeInfoDBDAOAgtChnVslAgnVODSQL(), insModels,null);
				for(int i=0; i<insCnt.length;i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to delete No"+ i + " SQL");
					}
				}
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
			//throw new DAOException(new ErrorHandler("AGT00027", new String[]{"Vessel"}).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return insCnt;
	}

	/**
	 * (ESM_AGT_024) Inbound China Agent Office Info for Vessel 의 정보 수정 한다.<br>
	 * @param List<AgtChnVslAgnVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifymultiInboundChinaOfficeInfoForVessel(
			List<AgtChnVslAgnVO> updModels) throws DAOException,Exception{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		int updCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AGTOfficeInfoDBDAOAgtChnVslAgnVOUSQL(), updModels,null);
				for(int i=0; i<updCnt.length;i++){
					if(updCnt[i] == Statement.EXECUTE_FAILED){
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	/**
     * (ESM_AGT_0022) 입력한 A/R Office가 상계/분리대리점 구분 정보를 가져온다.<br>
     * 
     * @param  String vndr_seq
     * @param  String chn_agn_cd
     * @return String VNDERCOUNT
     * @throws DAOException
     */
    public String searchAgentVendor(String vndr_seq, String chn_agn_cd) throws DAOException {
    	log.debug("\n AGT Common searchAgentVendor \n");

		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("vndr_seq", vndr_seq );
			param.put("chn_agn_cd", chn_agn_cd );
			velParam.put("vndr_seq", vndr_seq );
			velParam.put("chn_agn_cd", chn_agn_cd );
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTOfficeInfoDBDAOSearchAgentVendorRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("VNDERCOUNT");
			} else {
				rtnValue = "";
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

		return rtnValue.toString();
    }
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 *
	 * @param String vndr_seq
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchMdmVendor(String vndr_seq) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] rtnValue = new String[5];
		try{
			param.put("vndr_seq", vndr_seq );
			velParam.put("vndr_seq", vndr_seq );
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGTOfficeInfoDBDAOSearchMdmVendorRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue[0] = dbRowset.getString(1);
				rtnValue[1] = dbRowset.getString(2);
				rtnValue[2] = dbRowset.getString(3);
				rtnValue[3] = dbRowset.getString(4);
				rtnValue[4] = dbRowset.getString(5);
				
				log.debug("rtnValue[0]===============>"+rtnValue[0]);
				log.debug("rtnValue[1]===============>"+rtnValue[1]);
				log.debug("rtnValue[2]===============>"+rtnValue[2]);
				log.debug("rtnValue[3]===============>"+rtnValue[3]);
				log.debug("rtnValue[4]===============>"+rtnValue[4]);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}
	
}