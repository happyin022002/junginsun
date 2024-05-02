/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManualRegisterDBDAO.java
*@FileTitle : ManualRegister
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.17
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2009.07.17 변종건
* 1.0 Creation
* 2011.01.10 손은주 [CHM-201108195-01] [TPB] WAS  로그 모니터링 (일부 Candidate PK구하는 값이 null이거나 이상한 값이 들어가는 현상) 수정
* 2015.04.07 KIM HYUN HWA[CHM-201535074]TPB에서 REV VVD 로직 보완 요청( BKG VVD 및 Finc Dir check 로직 추가)
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.basic.ManualRegisterBCImpl;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.CreateEACRegistrationVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.CreateTPBCandidateVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.SearchContainerInfoVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.SearchEQKindVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.SearchTPBDuplicationListVO;
import com.hanjin.apps.alps.esd.tpb.candidatemanage.manualregister.vo.SearchTPBOfficeListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
 

/**
 * ALPS ManualRegisterDBDAO <br>
 * - ALPS-CandidateManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Jong-Geon Byeon
 * @see ManualRegisterBCImpl 참조
 * @since J2EE 1.6
 */
public class ManualRegisterDBDAO extends DBDAOSupport {
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchTPBDuplicationListVO searchTPBDuplicationListVO
	 * @return List<SearchTPBDuplicationListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchTPBDuplicationListVO> searchTPBDuplicationList(SearchTPBDuplicationListVO searchTPBDuplicationListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTPBDuplicationListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchTPBDuplicationListVO != null){
				Map<String, String> mapVO = searchTPBDuplicationListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualRegisterDBDAOSearchTPBDuplicationListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTPBDuplicationListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 /**
	  * [처리대상] 정보를 [행위] 합니다.<br>
	  * 
	  * @param SearchContainerInfoVO searchContainerInfoVO
	  * @return List<SearchContainerInfoVO>
	  * @throws DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<SearchContainerInfoVO> searchContainerInfo(SearchContainerInfoVO searchContainerInfoVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<SearchContainerInfoVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(searchContainerInfoVO != null){
				 Map<String, String> mapVO = searchContainerInfoVO .getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualRegisterDBDAOSearchContainerInfoRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchContainerInfoVO .class);
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 //throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 //throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<CreateTPBCandidateVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	 public int[] addTPBCandidate(List<CreateTPBCandidateVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {		 
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				
				Map<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("s_n3pty_expn_tp_cd", insModels.get(0).getSN3ptyExpnTpCd());
                
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ManualRegisterDBDAOCreateTPBCandidateCSQL(), insModels,velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
			
			 
			 
//			   //query parameter
//	        Map<String, Object> param = new HashMap<String, Object>();
//
//	        PSACntrBaseInfoVO psaCntrBaseInfoVO = null;
//	        
//			if(insModels.size() > 0) {
//				
//				for(int i = 0 ; i < insModels.size(); i++) {
//					
//					psaCntrBaseInfoVO = insModels.get(i);
//					Map<String, String> mapVO = psaCntrBaseInfoVO.getColumnValues();
//	
//		            param.putAll(mapVO);
//
//					result = new SQLExecuter("").executeUpdate((ISQLTemplate)new PSASpecialManifestDBDAOaddDgListCSQL(), param, null);
//		            if(result == Statement.EXECUTE_FAILED) {
//		           		throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
//		            }
//				}
//				
//			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	 /**
		 * [처리대상] 정보를 [행위] 합니다.<br>
		 * 
		 * @param List<CreateTPBCandidateVO> insModels
		 * @return int[]
		 * @throws DAOException
		 * @throws Exception
		 */
		 public int[] createTPBStatus(List<CreateTPBCandidateVO> insModels) throws DAOException,Exception {
			int insCnt[] = null;
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				if(insModels.size() > 0){
					insCnt = sqlExe.executeBatch((ISQLTemplate)new ManualRegisterDBDAOCreateTPBStatusCSQL(), insModels,null);
					for(int i = 0; i < insCnt.length; i++){
						if(insCnt[i]== Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return insCnt;
		}
	 	/**
		 * [처리대상] 정보를 [행위] 합니다.<br>
		 *
		 * @param CreateTPBCandidateVO createTPBCandidateVO
		 * @return String
		 * @throws DAOException
		 */
		public String searchSVRID(CreateTPBCandidateVO createTPBCandidateVO) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			String rtnValue = null;
			try{
				Map<String, String> mapVO = createTPBCandidateVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualRegisterDBDAOSearchSVRIDRSQL(), param, velParam);
				if (dbRowset.next()) {
					rtnValue = dbRowset.getString("SVR_ID");
				} else {
					rtnValue = "";
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
			return rtnValue.toString();
		}
		
		/**
		 * [처리대상] 정보를 [행위] 합니다.<br>
		 *
		 * @param CreateTPBCandidateVO createTPBCandidateVO
		 * @return String
		 * @throws DAOException
		 */
		public String searchVndrCntCd(CreateTPBCandidateVO createTPBCandidateVO) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			String rtnValue = null;
			try{
				Map<String, String> mapVO = createTPBCandidateVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				String tmpNumStr = "";
				tmpNumStr = createTPBCandidateVO.getSSrcVndrSeq();
				Integer.parseInt(tmpNumStr);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualRegisterDBDAOSearchVndrCntCdRSQL(), param, velParam);
				if (dbRowset.next()) {
					rtnValue = dbRowset.getString("VNDR_CNT_CD");
				} else {
					rtnValue = "";
				}
			}catch(NumberFormatException ne){
				throw new DAOException(new ErrorHandler("TPB00066").getMessage());
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return rtnValue.toString();
		}
	  
		/**
		 * [처리대상] 정보를 [행위] 합니다.<br>
		 *
		 * @param CreateTPBCandidateVO createTPBCandidateVO
		 * @return String[]
		 * @throws DAOException
		 */
		public String[] searchStr(CreateTPBCandidateVO createTPBCandidateVO) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			String[] rtnValue = {"","",""};
			try{
				Map<String, String> mapVO = createTPBCandidateVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualRegisterDBDAOSearchStrRSQL(), param, velParam);
				if (dbRowset.next()) {
					rtnValue[0] = dbRowset.getString(1);
					rtnValue[1] = dbRowset.getString(2);
					rtnValue[2] = dbRowset.getString(3);
					
					log.debug("rtnValue[0]===============>"+rtnValue[0]);
					log.debug("rtnValue[1]===============>"+rtnValue[1]);
					log.debug("rtnValue[2]===============>"+rtnValue[2]);
				} else {
					//rtnValue = "";
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
	 
		/**
		 * [처리대상] 정보를 [행위] 합니다.<br>
		 *
		 * @param CreateTPBCandidateVO createTPBCandidateVO
		 * @return String
		 * @throws DAOException
		 */
		public String searchVVDStr(CreateTPBCandidateVO createTPBCandidateVO) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			String rtnValue = null;
			try{
				Map<String, String> mapVO = createTPBCandidateVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualRegisterDBDAOSearchVVDStrRSQL(), param, velParam);
				if (dbRowset.next()) {
					rtnValue = dbRowset.getString("VVD");
				} else {
					rtnValue = "";
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
			return rtnValue.toString();
		}
		/**
		 * [처리대상] 정보를 [행위] 합니다.<br>
		 *
		 * @param CreateTPBCandidateVO createTPBCandidateVO
		 * @return String
		 * @throws DAOException
		 */
		public String searchTESStr(CreateTPBCandidateVO createTPBCandidateVO) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			String rtnValue = null;
			try{
				Map<String, String> mapVO = createTPBCandidateVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualRegisterDBDAOSearchTESStrRSQL(), param, velParam);
				if (dbRowset.next()) {
					rtnValue = dbRowset.getString("TES");
				} else {
					rtnValue = "";
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
			return rtnValue.toString();
		} 


	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<CreateEACRegistrationVO> insModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] addEACRegistration(List<CreateEACRegistrationVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				Map<String, Object> velParam = new HashMap<String, Object>();
                velParam.put("s_n3pty_expn_tp_cd", insModels.get(0).getSN3ptyExpnTpCd());
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ManualRegisterDBDAOCreateEACRegistrationCSQL(), insModels,velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<CreateEACRegistrationVO> updModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] modifyEACRegistration(List<CreateEACRegistrationVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ManualRegisterDBDAOCreateEACRegistrationCSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param List<CreateEACRegistrationVO> delModels
	 * @return int[]
	 * @throws DAOException
	 * @throws Exception
	 */
	public int[] removeEACRegistration(List<CreateEACRegistrationVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ManualRegisterDBDAOCreateEACRegistrationCSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}
	
 	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 *
	 * @param CreateEACRegistrationVO createEACRegistrationVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchSvrId(CreateEACRegistrationVO createEACRegistrationVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = null;
		try{
			Map<String, String> mapVO = createEACRegistrationVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualRegisterDBDAOSearchSVRIDRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("SVR_ID");
			} else {
				rtnValue = "";
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
		return rtnValue.toString();
	}
	
	/**
	 * [처리대상] 정보를 [행위] 합니다.<br>
	 * 
	 * @param SearchTPBOfficeListVO searchTPBOfficeListVO
	 * @return List<SearchTPBOfficeListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchTPBOfficeListVO> searchTPBOfficeList(SearchTPBOfficeListVO searchTPBOfficeListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTPBOfficeListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchTPBOfficeListVO != null){
				Map<String, String> mapVO = searchTPBOfficeListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualRegisterDBDAOSearchTPBOfficeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTPBOfficeListVO .class);
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
	 * @return String
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String searchOtsDtlSeq() throws DAOException {
		 DBRowSet dbRowset = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 String rtnValue = "";
		 
		 try{
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualRegisterDBDAOSearchGetTPBDtlSeqRSQL(), param, velParam);
			 
			 if (dbRowset.next()) {
				 rtnValue = dbRowset.getString("OTS_DTL_SEQ");
			 } else {
				 rtnValue = "";
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 
		 return rtnValue;
	}

	 /**
	 * OTL_DTL_SEQ 변수가 DB에 존재하는지 체크.<br>
	 * @param String ots_dtl_seq
	 * @return String
	 * @throws DAOException
	 */
	 
	public String searchGetOtsDtlSeq(String ots_dtl_seq) throws DAOException {
		 DBRowSet dbRowset = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 String rtnValue = "";
		 
		 try{
			 param.put("ots_dtl_seq", Integer.parseInt(ots_dtl_seq));
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualRegisterDBDAOSearchGetOtsDtlSeqRSQL(), param, velParam);
			 
			 if (dbRowset.next()) {
				 rtnValue = dbRowset.getString("OTS_DTL_SEQ");
			 } else {
				 rtnValue = "";
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return rtnValue;
	}
	
	/**
	 * VVD_CD 유무를 확인.<br>
	 * 
	 * @param String eqNo
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet checkEqNo(String eqNo) throws DAOException {
		DBRowSet dbRowset = null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		Map<String, Object> param = new HashMap<String, Object>();//parameter
			try {
				if(eqNo != null){
					param.put("vvd_cd",eqNo);
					log.debug(eqNo);
				}			
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualRegisterDBDAOSearchVvdCdRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dbRowset;
	}
	
	/**
	 * EQKind 가져오는 쿼리 <br>
	 * 
	 * @param String n3pty_expn_tp_cd   
	 * @return List<SearchEQKindVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchEQKindVO> searchEQKindCd(String n3pty_expn_tp_cd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEQKindVO> list = null;
		// query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			velParam.put("s_n3pty_expn_tp_cd", n3pty_expn_tp_cd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ManualRegisterDBDAOSearchEQKindRSQL(), null, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchEQKindVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	 /**
		 * [finance direction code  및 BKG VVD check 한다.<br>
		 * @param String vvdCd
		 * @param String ydCd
		 * @param String bkgNo   
		 * @return String
		 * @throws DAOException
		 */
		 @SuppressWarnings("unchecked")
		public String searchBkgVVDFincDirCd(String vvdCd, String ydCd, String bkgNo) throws DAOException {
			 DBRowSet dbRowset = null;
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 //velocity parameter
			 Map<String, Object> velParam = new HashMap<String, Object>();
			 
			 String rtnValue = "";
			 
			 try{
					param.put("vvd_cd",vvdCd);
					param.put("yd_cd",ydCd);
					param.put("bkg_no",bkgNo);
					velParam.put("yd_cd", ydCd);
					velParam.put("bkg_no", bkgNo);
					
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ManualRegisterDBDAOSearchBkgVvdCheckRSQL(), param, velParam);
				 
				 if (dbRowset.next()) {
					 rtnValue = dbRowset.getString("FINC_DIR_CD");
				 } else {
					 rtnValue = "XX";
				 }

			 }catch(SQLException se){
				 log.error(se.getMessage(),se);
				 throw new DAOException(new ErrorHandler(se).getMessage());
			 }catch(Exception ex){
				 log.error(ex.getMessage(),ex);
				 throw new DAOException(new ErrorHandler(ex).getMessage());
			 }
			 
			 return rtnValue;
		}

	
}