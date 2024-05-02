/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ITCharterIOBunkerRegisterDAO.java
*@FileTitle : BunkerDataManagement
*Open Issues :
*Change history :
*@LastModifyDate : 2009.03.26
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.03.26 정윤태
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esm.fms.fmscommonutil.BizComFmsUtil;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.basic.TCharterIOBunkerRegisterBCImpl;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.ContractByBunkerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.CustomBunkerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchBunkerConditionVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchBunkerListByPaymentSlipVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchBunkerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchIdVslCdByBunkerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchLocCdByBunkerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchVvdByBunkerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamCsulSlpVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS ITCharterIOBunkerRegisterDAO <br>
 * - OPUS-TimeCharterInOutAccounting system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Yoon-Tae, Jung
 * @see TCharterIOBunkerRegisterBCImpl 참조
 * @since J2EE 1.5
 */
public class TCharterIOBunkerRegisterDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Bunker 정보를 가져온다<br>
	 * 
	 * @param searchBunkerVO SearchBunkerVO
	 * @return List<SearchBunkerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 
	public List<SearchBunkerVO> searchBunkerList(SearchBunkerVO searchBunkerVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchBunkerVO> searchBunkerVOList = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(searchBunkerVO != null){
				Map<String, String> mapVO = searchBunkerVO.getColumnValues();
			
				param.putAll(mapVO);
			}
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBunkerRegisterDAOFmsBunkerRSQL(), param, null);
			
			searchBunkerVOList = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBunkerVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("FMS01200",new String[]{}).getUserMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchBunkerVOList;
	}

	/**
	 * Bunker 정보를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param customBunkerVO List<CustomBunkerVO>
	 * @throws DAOException
	 */
	public void addBunkers(List<CustomBunkerVO> customBunkerVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customBunkerVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBunkerRegisterDAOFmsBunkerCSQL(), customBunkerVO, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("FMS01201",new String[]{}).getUserMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Bunker 정보를 변경한다.<br>
	 * 
	 * @param customBunkerVO List<CustomBunkerVO>
	 * @throws DAOException
	 */
	public void modifyBunkers(List<CustomBunkerVO> customBunkerVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customBunkerVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBunkerRegisterDAOFmsBunkerUSQL(), customBunkerVO, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("FMS01201",new String[]{}).getUserMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Bunker 정보를 삭제한다.<br>
	 * 
	 * @param customBunkerVO List<CustomBunkerVO>
	 * @throws DAOException
	 */
	public void removeBunkers(List<CustomBunkerVO> customBunkerVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customBunkerVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBunkerRegisterDAOFmsBunkerDSQL(), customBunkerVO, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("FMS01201",new String[]{}).getUserMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Vessel Code를 가져온다<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchIdVslCdByBunkerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 
	public List<SearchIdVslCdByBunkerVO> searchIdVslCdListByBunker(String fletCtrtNo) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchIdVslCdByBunkerVO> searchIdVslCdByBunkerVO = null;

		try{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBunkerRegisterDAOSearchIdVslCdByBunkerRSQL(), param, null);
			
			searchIdVslCdByBunkerVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchIdVslCdByBunkerVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchIdVslCdByBunkerVO;
	}
	 
    /**
	 * vslCd와 bunkerDt에 해당하는 항차 가져오기<br>
	 * 
	 * @param vslCd String
	 * @param bunkerDt String
	 * @param fletCtrtNo String
	 * @return List<SearchVvdByBunkerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })	 
	public List<SearchVvdByBunkerVO> searchVvdListByBunker(String vslCd, String bunkerDt, String fletCtrtNo) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchVvdByBunkerVO> searchVvdByBunkerVO = null;

		try{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			param.put("vsl_cd", vslCd);
			param.put("bunker_dt", bunkerDt);
			param.put("flet_ctrt_no", fletCtrtNo);
			
			String flet_ctrt_tp_cd = StringUtils.substring(fletCtrtNo, 4, 6);
			param.put("flet_ctrt_tp_cd", flet_ctrt_tp_cd);
			velParam.put("flet_ctrt_tp_cd", flet_ctrt_tp_cd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBunkerRegisterDAOSearchVvdByBunkerRSQL(), param, velParam);
			
			searchVvdByBunkerVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchVvdByBunkerVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("FMS01205",new String[]{}).getUserMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchVvdByBunkerVO;
	}
	 
	/**
	 * Location Code 가져오기<br>
	 * 
	 * @param locCd String
	 * @return String
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 
	 public String searchCheckLocCdByBunker(String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchLocCdByBunkerVO> searchLocCdByBunkerVO = null;
		
		String dbLocCd = "";

		try{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("loc_cd", locCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBunkerRegisterDAOSearchLocCdByBunkerRSQL(), param, null);
			
			searchLocCdByBunkerVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLocCdByBunkerVO.class);

			if(searchLocCdByBunkerVO != null && searchLocCdByBunkerVO.size() != 0) {
				dbLocCd = searchLocCdByBunkerVO.get(0).getLocCd();
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("FMS01206",new String[]{}).getUserMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return dbLocCd;
	}
	 
    /**
	 * 계약정보를 가져온다<br>
	 * 
	 * @param fletCtrtNo String
	 * @param bnkYrmon String
	 * @return List<ContractByBunkerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 
    public List<ContractByBunkerVO> searchContractByBunker(String fletCtrtNo, String bnkYrmon) throws DAOException {
		 DBRowSet dbRowset = null;
		
		 List<ContractByBunkerVO> contractbybunkervo = null;

		 try{
			 //query parameter
			 Map<String, Object> param = new HashMap<String, Object>();
			 param.put("flet_ctrt_no", fletCtrtNo);
			 param.put("bnk_yrmon", bnkYrmon);
			
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBunkerRegisterDAOSearchContractByBunkerRSQL(), param, null);
			
			 contractbybunkervo = (List)RowSetUtil.rowSetToVOs(dbRowset, ContractByBunkerVO.class);
			
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler("FMS01207",new String[]{}).getUserMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		
		 return contractbybunkervo;
	 }
  
    /**
	 * 전표 생성 완료 후 Invoice 테이블을 업데이트한다.<br>
	 * 
	 * @param customPamCsulSlpVO List<CustomPamCsulSlpVO>
	 * @throws DAOException
	 */
	public void modifyPaymentSlipBunkers(List<CustomPamCsulSlpVO> customPamCsulSlpVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customPamCsulSlpVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOBunkerRegisterDAOModifyPaymentSlipBunkersUSQL(), customPamCsulSlpVO, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("FMS01201",new String[]{}).getUserMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 대선 전표가 생성되면 정산 테이블에 변경된다<br>
	 * 
	 * @param customCsulSlpVO List<CustomCsulSlpVO>
	 * @throws DAOException, Exception
	 */
	public void modifySubletRevenueSlips(List<CustomCsulSlpVO> customCsulSlpVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customCsulSlpVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharteriOBunkerDBDAOModifySubletRevenueSlipUSQL(), customCsulSlpVO, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * AR 대선인 경우 전표가 취소되면 Bunker의 전표 정보도 Null 로 업데이트된다<br>
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @throws DAOException
	 */
	public void modifyArSlipApprovalCancelBunker (String csrNo ,String usrId ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
	
			//FMS_BUNKER 저장
			param.put("csr_no", csrNo);
			param.put("upd_usr_id", usrId);
	
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharteriOBunkerDBDAOModifyArSlipApprovalCancelBunkerUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * AP 대선인 경우 전표가 취소되면 Bunker의 전표 정보도 Null 로 업데이트된다<br>
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @throws DAOException
	 */
	public void modifyApSlipApprovalCancelBunker (String csrNo ,String usrId ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
	
			//FMS_BUNKER 저장
			param.put("csr_no", csrNo);
			param.put("upd_usr_id", usrId);
	
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharteriOBunkerDBDAOModifyApSlipApprovalCancelBunkerUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 용선인 경우 전표가 취소되면 Bunker의 전표 정보도 Null 로 업데이트된다<br>
	 * 
	 * @param csrNo String
	 * @param usrId String
	 * @throws DAOException
	 */
	public void modifySlipApprovalCancelBunker (String csrNo ,String usrId ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
	
			//FMS_BUNKER 저장
			param.put("csr_no", csrNo);
			param.put("upd_usr_id", usrId);
	
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharteriOBunkerDBDAOFmsBunkerCancelUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * 기 작성된 BOD / BOR Data / Window 중 지급 전표로 처리할 항목 선정 대상 자료를 조회한다<br>
	 * 
	 * @param searchBunkerConditionVO SearchBunkerConditionVO
	 * @return List<SearchBunkerListByPaymentSlipVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchBunkerListByPaymentSlipVO> searchBunkerListByPaymentSlip(SearchBunkerConditionVO searchBunkerConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<SearchBunkerListByPaymentSlipVO> searchBunkerListByPaymentSlipVO = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
//			param.put("flet_ctrt_no", fletCtrtNo);
//			param.put("csr_curr_cd", csrCurrCd);
//			param.put("ofc_cd", ofcCd);			
//			velParam.put("apro_flg", aproFlg);
			
			//NYK Modify 2014.10.22
			if(searchBunkerConditionVO != null){
				Map<String, String> mapVO = searchBunkerConditionVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				String bnkTpCd = searchBunkerConditionVO.getBnkTpCd();
				
				velParam.put("bnk_tp_cd", (bnkTpCd == null || bnkTpCd.equals("") || bnkTpCd.equals("null")) ? "" : bnkTpCd);
				List<String> bnkTpCdList = new ArrayList<String>();
				
				if(bnkTpCd != null && !bnkTpCd.equals("")) {
					bnkTpCdList = BizComFmsUtil.getSeperationParameter(bnkTpCd, "|");
				}
				
				velParam.put("bnk_tp_cd_list", bnkTpCdList.iterator());
			}
			

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TCharterIOBunkerRegisterDAOSearchBunkerListByPaymentSlipRSQL(), param, velParam);
			searchBunkerListByPaymentSlipVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBunkerListByPaymentSlipVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return searchBunkerListByPaymentSlipVO;
	}
}
