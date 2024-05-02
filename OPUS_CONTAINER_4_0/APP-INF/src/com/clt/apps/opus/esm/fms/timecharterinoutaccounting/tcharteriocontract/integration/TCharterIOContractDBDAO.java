/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TCharterIOContractDAO.java
*@FileTitle : Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.01.19
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.01.19 정윤태
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.ContractByBunkerVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.basic.TCharterIOContractBCImpl;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomChtrPtyCfFileVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomChtrPtyFileVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomContractVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomHireVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomIdVslVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomOtrExpnVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomPayTermVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchCharterPtyFileListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContracNoListByVesselVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractByCharterVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractByInvoiceVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractByPrepaymentVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractListByPrepaymentHireNoVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractTypeCodeVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractTypeListByContractVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchFileCertificationListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchHireListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchHireSysDateVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchIdVslListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchOtrExpnListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchOtrExpnSysDateListVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchOwnerNameVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchPayTermListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS TCharterIOContractDAO <br>
 * - OPUS-TimeCharterInOutAccounting system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Yoon-Tae, Jung
 * @see TCharterIOContractBCImpl 참조
 * @since J2EE 1.5
 */
public class TCharterIOContractDBDAO extends DBDAOSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * vslCd에 해당하은 계약정보를 조회한다(FMS_CONTRACT)<br>
	 * 
	 * @param vslCd String
	 * @param fletCtrtTpCd String
	 * @param ctrtFlag String
	 * @return searchContracNoListByVesselVO List<SearchContracNoListByVesselVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchContracNoListByVesselVO> searchContracNoListByVessel(String vslCd, String fletCtrtTpCd, String ctrtFlag) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<SearchContracNoListByVesselVO> searchContracNoListByVesselVO = new ArrayList<SearchContracNoListByVesselVO>();
		try{
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vsl_cd", vslCd);
			param.put("flet_ctrt_tp_cd", fletCtrtTpCd);
			
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("ctrt_flag", ctrtFlag);

			dbRowset = new SQLExecuter().executeQuery(new TCharteIOContractDAOFmsSearchContractNoRSQL(), param, velParam);
			searchContracNoListByVesselVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchContracNoListByVesselVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("FMS01009",new String[]{}).getUserMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchContracNoListByVesselVO;
	}
	
	
	/**
	 * fletCtrtNo에 해당하는 Contract Type 을 가져온다<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchContractTypeCodeVO>
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchContractTypeCodeVO> searchContractTypeCode(String fletCtrtNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		
		List<SearchContractTypeCodeVO> searchContractTypeCodeVO = null;
		
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			
			dbRowset = new SQLExecuter().executeQuery(new TCharterIOContractDAOSearchContractTypeCodeRSQL(), param, null);
			
			searchContractTypeCodeVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchContractTypeCodeVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchContractTypeCodeVO;
	}
	
	/**
	 * Bunker Data에 해당하는 계약정보를 수정한다<br>
	 * 
	 * @param contractByBunkerVO ContractByBunkerVO
	 * @throws DAOException
	 */
	public void modifyContractByBunker(ContractByBunkerVO contractByBunkerVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		int result = 0;
		
		try {
			Map<String, String> mapVO = contractByBunkerVO.getColumnValues();
			
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOBunkerRegisterDAOFmsContractByBunkerUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("FMS01203",new String[]{}).getUserMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * fletCtrtNo에 해당하는 Contract Type 을 가져온다<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchContractTypeCodeVO>
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchContractByCharterVO> searchContractByCharter(String fletCtrtNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		
		List<SearchContractByCharterVO> searchContractByCharterVO = null;
		
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			
			dbRowset = new SQLExecuter().executeQuery(new TCharteIOContractDAOSearchContractByCharterRSQL(), param, null);
			
			searchContractByCharterVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchContractByCharterVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchContractByCharterVO;
	}
	
	/**
	 * Customer 코드 가져오기<br>
	 * 
	 * @param custCntCd String
	 * @param custSeq String
	 * @return List<SearchOwnerNameVO>
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchOwnerNameVO> searchOwnerByCustomer(String custCntCd, String custSeq) throws DAOException {
		
		DBRowSet dbRowset = null;
		
		List<SearchOwnerNameVO> searchOwnerNameVO = null;
		
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("cust_cnt_cd", custCntCd);
			param.put("cust_seq", custSeq);
			
			dbRowset = new SQLExecuter().executeQuery(new TCharterIOContractDAOSearchOwnerByCustomerRSQL(), param, null);
			
			searchOwnerNameVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnerNameVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchOwnerNameVO;
	}
	
	/**
	 * Vendor 코드 가져오기<br>
	 * 
	 * @param vndrSeq String
	 * @return List<SearchOwnerNameVO>
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchOwnerNameVO> searchOwnerByVendor(String vndrSeq) throws DAOException {
		
		DBRowSet dbRowset = null;
		
		List<SearchOwnerNameVO> searchOwnerNameVO = null;
		
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("vndr_seq", vndrSeq);
			
			dbRowset = new SQLExecuter().executeQuery(new TCharterIOContractDAOSearchOwnerByVendorRSQL(), param, null);
			
			searchOwnerNameVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOwnerNameVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchOwnerNameVO;
	}
	
	/**
	 * 계약정보(사선/용선/대선) 정보를 가져온다(FMS_CONTRACT)<br>
	 * 
	 * @param fletCtrtNo String
	 * @return searchContractVO SearchContractVO
	 * @throws DAOException
	 */
	public SearchContractVO searchContract(String fletCtrtNo) throws DAOException {
		
		SearchContractVO searchContractVO = null;
		
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			
			DBRowSet dbRowset = new SQLExecuter().executeQuery(new TCharterIOContractDAOSearchContractRSQL(), param, null);
			searchContractVO = (SearchContractVO)RowSetUtil.rowSetToVOs(dbRowset, SearchContractVO.class ).get(0);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchContractVO;
	}
	
	/**
	 * Agreement Inquiry 화면에서 사선/용선/대선 정보를 가져온다(FMS_CONTRACT)<br>
	 * 
	 * @param fletCtrtNo String
	 * @return searchContractVO SearchContractVO
	 * @throws DAOException
	 */
	public SearchContractVO searchAgreement(String fletCtrtNo) throws DAOException {
		
		SearchContractVO searchContractVO = null;
		
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			
			DBRowSet dbRowset = new SQLExecuter().executeQuery(new TCharterIOContractDAOSearchAgreementRSQL(), param, null);
			searchContractVO = (SearchContractVO)RowSetUtil.rowSetToVOs(dbRowset, SearchContractVO.class ).get(0);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchContractVO;
	}
	
	/**
	 * 계약정보 - Hire 정보를 가져온다<br>
	 * 
	 * @param fletCtrtNo String
	 * @return searchHIreListVOs List<SearchHIreListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchHireListVO> searchHireList(String fletCtrtNo) throws DAOException {
		
		List<SearchHireListVO> searchHireListVOs = null;
		
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			
			DBRowSet dbRowset = new SQLExecuter().executeQuery(new TCharterIOContractDAOSearchHireListRSQL(), param, null);
			searchHireListVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchHireListVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchHireListVOs;
	}
	
	/**
	 * 계약정보 - OtrExpn 정보를 가져온다(FMS_OTR_EXPN)<br>
	 * 
	 * @param fletCtrtNo String
	 * @return searchOtrExpnListVOs List<SearchOtrExpnListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchOtrExpnListVO> searchOtrExpnList(String fletCtrtNo) throws DAOException {
		
		List<SearchOtrExpnListVO> searchOtrExpnListVOs = null;
		
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			
			DBRowSet dbRowset = new SQLExecuter().executeQuery(new TCharterIOContractDAOSearchOtrExpnListRSQL(), param, null);
			searchOtrExpnListVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchOtrExpnListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchOtrExpnListVOs;
	}
	
	/**
	 * 계약정보 - PayTerm 정보를 가져온다<br>
	 * 
	 * @param fletCtrtNo String
	 * @return searchPayTermListVOs List<SearchPayTermListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchPayTermListVO> searchPayTermList(String fletCtrtNo) throws DAOException {
		
		List<SearchPayTermListVO> searchPayTermListVOs = null;
		
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			
			DBRowSet dbRowset = new SQLExecuter().executeQuery(new TCharterIOContractDAOSearchPayTermListRSQL(), param, null);
			searchPayTermListVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchPayTermListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchPayTermListVOs;
	}
	
	/**
	 * Agreement Inquiry 화면에서 사선/용선/대선 정보를 가져온다(FMS_PAY_TERM)<br>
	 * 
	 * @param fletCtrtNo String
	 * @return searchPayTermListVOs List<SearchPayTermListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchPayTermListVO> searchAgreementPayTermList(String fletCtrtNo) throws DAOException {
		
		List<SearchPayTermListVO> searchPayTermListVOs = null;
		
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			
			DBRowSet dbRowset = new SQLExecuter().executeQuery(new TCharterIOContractDAOSearchAgreementPayTermListRSQL(), param, null);
			searchPayTermListVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchPayTermListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchPayTermListVOs;
	}
	
	/**
	 * 계약정보 - CHTR_PTY_FILE 정보를 가져온다<br>
	 * 
	 * @param fletCtrtNo String
	 * @return searchCharterPtyFileListVOs List<SearchCharterPtyFileListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchCharterPtyFileListVO> searchFileCharterPartyList(String fletCtrtNo) throws DAOException {
		
		List<SearchCharterPtyFileListVO> searchCharterPtyFileListVOs = null;
		
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("flet_file_tp_cd", "CP");
			
			DBRowSet dbRowset = new SQLExecuter().executeQuery(new TCharterIOContractDAOSearchCharterPtyFileListRSQL(), param, null);
			searchCharterPtyFileListVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCharterPtyFileListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchCharterPtyFileListVOs;
	}
	
	/**
	 * 계약정보 - FileCertification 정보를 가져온다<br>
	 * 
	 * @param fletCtrtNo String
	 * @return searchFileCertificationListVOs List<SearchFileCertificationListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchFileCertificationListVO> searchFileCertificationList(String fletCtrtNo) throws DAOException {
		
		List<SearchFileCertificationListVO> searchFileCertificationListVOs = null;
		
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			param.put("flet_file_tp_cd", "CF");
			
			DBRowSet dbRowset = new SQLExecuter().executeQuery(new TCharterIOContractDAOSearchFileCertificationListRSQL(), param, null);
			searchFileCertificationListVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchFileCertificationListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchFileCertificationListVOs;
	}
	
	/**
	 * 계약정보 - IdVsl 정보를 가져온다<br>
	 * 
	 * @param fletCtrtNo String
	 * @return searchIdVslListVOs List<SearchIdVslListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchIdVslListVO> searchIdVslList(String fletCtrtNo) throws DAOException {
		
		List<SearchIdVslListVO> searchIdVslListVOs = null;
		
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			
			DBRowSet dbRowset = new SQLExecuter().executeQuery(new TCharterIOContractDAOSearchIdVslListRSQL(), param, null);
			searchIdVslListVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchIdVslListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchIdVslListVOs;
	}
	
	/**
	 * 계약정보 - Hire 최신 정보를 가져온다<br>
	 * 
	 * @param fletCtrtNo String
	 * @return searchHIreSysDateVO SearchHIreSysDateVO
	 * @throws DAOException
	 */
	public SearchHireSysDateVO searchHireSysDate(String fletCtrtNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		
		SearchHireSysDateVO searchHireSysDateVO = null;
		
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			
			dbRowset = new SQLExecuter().executeQuery(new TCharterIOContractDAOSearchHireSysDateRSQL(), param, null);
			
			if(dbRowset.next()) {
				dbRowset.beforeFirst();
				searchHireSysDateVO = (SearchHireSysDateVO)RowSetUtil.rowSetToVOs(dbRowset, SearchHireSysDateVO.class).get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchHireSysDateVO;
	}
	
	/**
	 * 사선/용선/대선 정보 중 Account Code별 최신 정보를 가져온다<br>
	 * 
	 * @param fletCtrtNo String
	 * @return searchOtrExpnSysDateListVOs List<SearchOtrExpnSysDateListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchOtrExpnSysDateListVO> searchOtrExpnSysDateList(String fletCtrtNo) throws DAOException {
		
		List<SearchOtrExpnSysDateListVO> searchOtrExpnSysDateListVOs = null;
		
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			
			DBRowSet dbRowset = new SQLExecuter().executeQuery(new TCharterIOContractDAOSearchOtrExpnSysDateListRSQL(), param, null);
			searchOtrExpnSysDateListVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchOtrExpnSysDateListVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchOtrExpnSysDateListVOs;
	}
	
	/**
	 * vslCd에 해당하는 lastSeq를 가져온다.<br>
	 * 
	 * @param vslCd String 베셀 코드
	 * @return int	lastSeq
	 * @throws DAOException
	 */
	public int searchLastContractSeq(String vslCd) throws DAOException {
		
		int lastSeq = 0;
		DBRowSet dbRowset = null;
		
		try{

			Map<String,Object> mapParam = new HashMap<String, Object>();
			mapParam.put("vsl_cd", vslCd);
			
			dbRowset = new SQLExecuter().executeQuery(new TCharterIOContractDAOSearchLastContractSeqRSQL(), mapParam, null);
			
			if (dbRowset.next()) {
				lastSeq = dbRowset.getInt(1);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return lastSeq;
	}
	
	/**
	 * 계약정보(사선/용선/대선) 정보를 등록한다(FMS_CONTRACT)<br>
	 * 
	 * @param customContractVO CustomContractVO
	 * @throws DAOException
	 */
	public void addContract(CustomContractVO customContractVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = customContractVO.getColumnValues();
			
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOContractDAOFmsContractCSQL(), param, null);
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
	 * 계약정보(사선/용선/대선) 정보를 변경한다(FMS_CONTRACT)<br>
	 * 
	 * @param customContractVO CustomContractVO
	 * @throws DAOException
	 */
	public void modifyContract(CustomContractVO customContractVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = customContractVO.getColumnValues();

			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TCharterIOContractDAOFmsContractUSQL(), param, null);
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
	 * 계약정보 - Hire 정보를 등록한다(FMS_HIRE)<br>
	 * 
	 * @param customHireVOs List<CustomHireVO>
	 * @throws DAOException
	 */
	public void addHires(List<CustomHireVO> customHireVOs) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			if(customHireVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOContractDAOFmsHireCSQL(), customHireVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * 계약정보 - Hire 정보를 수정한다(FMS_HIRE)<br>
	 * 
	 * @param customHireVOs List<CustomHireVO>
	 * @throws DAOException
	 */
	public void modifyHires(List<CustomHireVO> customHireVOs) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			
			if(customHireVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOContractDAOFmsHireUSQL(), customHireVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * 계약정보 - Hire 정보를 삭제한다(FMS_HIRE)<br>
	 * 
	 * @param customHireVOs List<CustomHireVO>
	 * @throws DAOException
	 */
	public void removeHires(List<CustomHireVO> customHireVOs) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			
			if(customHireVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOContractDAOFmsHireDSQL(), customHireVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * 계약정보 - PayTerm 정보를 등록한다(FMS_PAY_TERM)<br>
	 * 
	 * @param customPayTermVOs List<CustomPayTermVO>
	 * @throws DAOException
	 */
	public void addPayTerms(List<CustomPayTermVO> customPayTermVOs) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			if(customPayTermVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOContractDAOFmsPayTermCSQL(), customPayTermVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * 계약정보 - PayTerm 정보를 수정한다(FMS_PAY_TERM)<br>
	 * 
	 * @param customPayTermVOs List<CustomPayTermVO>
	 * @throws DAOException
	 */
	public void modifyPayTerms(List<CustomPayTermVO> customPayTermVOs) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			
			if(customPayTermVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOContractDAOFmsPayTermUSQL(), customPayTermVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * 계약정보 - PayTerm 정보를 삭제한다(FMS_PAY_TERM)<br>
	 * 
	 * @param customPayTermVOs List<CustomPayTermVO>
	 * @throws DAOException
	 */
	public void removePayTerms(List<CustomPayTermVO> customPayTermVOs) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			
			if(customPayTermVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOContractDAOFmsPayTermDSQL(), customPayTermVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * 계약정보 - OtrExpn 정보를 등록한다(FMS_OTR_EXPN)<br>
	 * 
	 * @param customOtrExpnVOs List<CustomOtrExpnVO>
	 * @throws DAOException
	 */
	public void addOtrExpns(List<CustomOtrExpnVO> customOtrExpnVOs) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			if(customOtrExpnVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOContractDAOFmsOtrExpnCSQL(), customOtrExpnVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * 계약정보 - OtrExpn 정보를 수정한다(FMS_OTR_EXPN)<br>
	 * 
	 * @param customOtrExpnVOs List<CustomOtrExpnVO>
	 * @throws DAOException
	 */
	public void modifyOtrExpns(List<CustomOtrExpnVO> customOtrExpnVOs) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			
			if(customOtrExpnVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOContractDAOFmsOtrExpnUSQL(), customOtrExpnVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * 계약정보 - OtrExpn 정보를 삭제한다(FMS_OTR_EXPN)<br>
	 * 
	 * @param customOtrExpnVOs List<CustomOtrExpnVO>
	 * @throws DAOException
	 */
	public void removeOtrExpns(List<CustomOtrExpnVO> customOtrExpnVOs) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			
			if(customOtrExpnVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOContractDAOFmsOtrExpnDSQL(), customOtrExpnVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * 계약정보 - IdVsl 정보를 등록한다(FMS_ID_VSL)<br>
	 * 
	 * @param customIdVslVOs List<CustomIdVslVO>
	 * @throws DAOException
	 */
	public void addIdVsls(List<CustomIdVslVO> customIdVslVOs) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			if(customIdVslVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOContractDAOFmsIdVslCSQL(), customIdVslVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * 계약정보 - IdVsl 정보를 수정한다(FMS_ID_VSL)<br>
	 * 
	 * @param customIdVslVOs List<CustomIdVslVO>
	 * @throws DAOException
	 */
	public void modifyIdVsls(List<CustomIdVslVO> customIdVslVOs) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			
			if(customIdVslVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOContractDAOFmsIdVslUSQL(), customIdVslVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * 계약정보 - IdVsl 정보를 삭제한다(FMS_ID_VSL)<br>
	 * 
	 * @param customIdVslVOs List<CustomIdVslVO>
	 * @throws DAOException
	 */
	public void removeIdVsls(List<CustomIdVslVO> customIdVslVOs) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			
			if(customIdVslVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOContractDAOFmsIdVslDSQL(), customIdVslVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * 계약정보 - FileCharterParty 정보를 등록한다(FMS_CHTR_PTY_FILE)<br>
	 * 
	 * @param customChtrPtyFileVOs List<CustomChtrPtyFileVO>
	 * @throws DAOException
	 */
	public void addFileCharterPartys(List<CustomChtrPtyFileVO> customChtrPtyFileVOs) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			if(customChtrPtyFileVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOContractDAOFmsChtrPtyFileCSQL(), customChtrPtyFileVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * 계약정보 - FileCharterParty 정보를 수정한다(FMS_CHTR_PTY_FILE)<br>
	 * 
	 * @param customChtrPtyFileVOs List<CustomChtrPtyFileVO>
	 * @throws DAOException
	 */
	public void modifyFileCharterPartys(List<CustomChtrPtyFileVO> customChtrPtyFileVOs) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			
			if(customChtrPtyFileVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOContractDAOFmsChtrPtyFileUSQL(), customChtrPtyFileVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * 계약정보 - FileCharterParty 정보를 삭제한다(FMS_CHTR_PTY_FILE)<br>
	 * 
	 * @param customChtrPtyFileVOs List<CustomChtrPtyFileVO>
	 * @throws DAOException
	 */
	public void removeFileCharterPartys(List<CustomChtrPtyFileVO> customChtrPtyFileVOs) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			
			if(customChtrPtyFileVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOContractDAOFmsChtrPtyFileDSQL(), customChtrPtyFileVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * 계약정보 - FileCertification 정보를 등록한다(FMS_CHTR_PTY_FILE)<br>
	 * 
	 * @param customChtrPtyCfFileVOs List<CustomChtrPtyCfFileVO>
	 * @throws DAOException
	 */
	public void addFileCertifications(List<CustomChtrPtyCfFileVO> customChtrPtyCfFileVOs) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			if(customChtrPtyCfFileVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOContractDAOFmsChtrPtyFileCSQL(), customChtrPtyCfFileVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * 계약정보 - FileCertification 정보를 수정한다(FMS_CHTR_PTY_FILE)<br>
	 * 
	 * @param customChtrPtyCfFileVOs List<CustomChtrPtyCfFileVO>
	 * @throws DAOException
	 */
	public void modifyFileCertifications(List<CustomChtrPtyCfFileVO> customChtrPtyCfFileVOs) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			
			if(customChtrPtyCfFileVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOContractDAOFmsChtrPtyFileUSQL(), customChtrPtyCfFileVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * 계약정보 - FileCertification 정보를 수정한다(FMS_CHTR_PTY_FILE)<br>
	 * 
	 * @param customChtrPtyCfFileVOs List<CustomChtrPtyCfFileVO>
	 * @throws DAOException
	 */
	public void removeFileCertifications(List<CustomChtrPtyCfFileVO> customChtrPtyCfFileVOs) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			
			if(customChtrPtyCfFileVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TCharterIOContractDAOFmsChtrPtyFileDSQL(), customChtrPtyCfFileVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * 계약번호에 해당하는 Contract Fact정보를 가져온다.<br>
	 * 
	 * @param fletCtrtNo String 계약번호
	 * @return String ctrtFactCd
	 * @throws DAOException
	 */
	public String searchContractFact(String fletCtrtNo) throws DAOException {
		String ctrtFactCd = "";
		DBRowSet dbRowset = null;
		
		try{

			Map<String,Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			
			dbRowset = new SQLExecuter().executeQuery(new TCharterIOContractDAOSelectContractFactRSQL(), param, null);
			
			if (dbRowset.next()) {
				ctrtFactCd = dbRowset.getString(1);
			}
			
			return ctrtFactCd;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 계약번호에 해당하는 Delt Flg 정보를 변경한다.<br>
	 * 
	 * @param fletCtrtNo String 계약번호
	 * @throws DAOException
	 */
	public void modifyDeleteFlag(String fletCtrtNo) throws DAOException {
		
		try {
			SQLExecuter sqlExe = new SQLExecuter();
			
			Map<String,Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);

			sqlExe.executeUpdate(new TCharterIOContractDAOUpdateDeleteFlagUSQL(), param, null); 

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 계약정보 - Hire 정보 전체를 삭제한다(FMS_HIRE)<br>
	 * 
	 * @param fletCtrtNo String
	 * @throws DAOException
	 */
	public void removeHireAll(String fletCtrtNo) throws DAOException {
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String,Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			
			sqlExe.executeUpdate(new TCharterIOContractDAOFmsHireAllDSQL(), param, null); 

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 계약정보 - PayTerm 정보 전체를 삭제한다(FMS_PAY_TERM)<br>
	 * 
	 * @param fletCtrtNo String
	 * @throws DAOException
	 */
	public void removePayTermAll(String fletCtrtNo) throws DAOException {
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String,Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			
			sqlExe.executeUpdate(new TCharterIOContractDAOFmsPayTermAllDSQL(), param, null); 

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 계약정보 - OtrExpn 정보 전체를 삭제한다(FMS_OTR_EXPN)<br>
	 * 
	 * @param fletCtrtNo String
	 * @throws DAOException
	 */
	public void removeOtrExpnAll(String fletCtrtNo) throws DAOException {
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String,Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			
			sqlExe.executeUpdate(new TCharterIOContractDAOFmsOtrExpnAllDSQL(), param, null); 

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 계약정보 - IdVsl 정보 전체를 삭제한다(FMS_ID_VSL)<br>
	 * 
	 * @param fletCtrtNo String
	 * @throws DAOException
	 */
	public void removeIdVslAll(String fletCtrtNo) throws DAOException {
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String,Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			
			sqlExe.executeUpdate(new TCharterIOContractDAOFmsIdVslAllDSQL(), param, null); 

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 계약정보 - ChtrPtyFile 정보 전체를 삭제한다(FMS_CHTR_PTY_FILE)<br>
	 * 
	 * @param fletCtrtNo String
	 * @throws DAOException
	 */
	public void removeChtrPtyFileAll(String fletCtrtNo) throws DAOException {
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String,Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			
			sqlExe.executeUpdate(new TCharterIOContractDAOFmsChtrPtyFileAllDSQL(), param, null); 

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 계약정보를 삭제한다(FMS_CONTRACT)<br>
	 * 
	 * @param fletCtrtNo String
	 * @throws DAOException
	 */
	public void removeContract(String fletCtrtNo) throws DAOException {
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String,Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			
			sqlExe.executeUpdate(new TCharterIOContractDAOFmsContractDSQL(), param, null); 

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * fletCtrtNo에 해당하는 Contract Type/Owner Code/Owner Name 을 가져온다<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchContractByInvoiceVO>
	 * @exception EventException
	 */
	public SearchContractByInvoiceVO searchContractByInvoice(String fletCtrtNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		
		SearchContractByInvoiceVO searchContractByInvoiceVO = null;
		
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			
			dbRowset = new SQLExecuter().executeQuery(new TCharteIOContractDAOSearchContractByInvoiceRSQL(), param, null);
			
			searchContractByInvoiceVO = (SearchContractByInvoiceVO)RowSetUtil.rowSetToVOs(dbRowset, SearchContractByInvoiceVO.class).get(0);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchContractByInvoiceVO;
	}
	
	/**
	 * fletCtrtNo에 해당하는 Contract Type/Owner Code/Owner Name/Duration 을 가져온다<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchContractByPrepaymentVO>
	 * @exception EventException
	 */
	public SearchContractByPrepaymentVO searchContractByPrepayment(String fletCtrtNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		
		SearchContractByPrepaymentVO searchContractByPrepaymentVO = null;
		
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			
			dbRowset = new SQLExecuter().executeQuery(new TCharteIOContractDAOSearchContractByPrepaymentRSQL(), param, null);
			
			if(dbRowset.next()) {
				dbRowset.beforeFirst();
				searchContractByPrepaymentVO = (SearchContractByPrepaymentVO)RowSetUtil.rowSetToVOs(dbRowset, SearchContractByPrepaymentVO.class).get(0);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchContractByPrepaymentVO;
	}
	
	/**
	 *  Prepayment 화면에서 CtrtNo에 해당하는 Hire No/Contract Type 가져오기<br>
	 * 
	 * @param fletCtrtNo String
	 * @return List<SearchContractListByPrepaymentHireNoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchContractListByPrepaymentHireNoVO> searchContractListByPrepaymentHireNo(String fletCtrtNo) throws DAOException {
		
		List<SearchContractListByPrepaymentHireNoVO> searchContractListByPrepaymentHireNoVOs = null;
		
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("flet_ctrt_no", fletCtrtNo);
			
			DBRowSet dbRowset = new SQLExecuter().executeQuery(new TCharteIOContractDAOSearchContractListByPrepaymentHireNoRSQL(), param, null);
			searchContractListByPrepaymentHireNoVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchContractListByPrepaymentHireNoVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchContractListByPrepaymentHireNoVOs;
	}
	
	/**
	 * 계약조회 화면 OPEN시 발생하는 이벤트<br>
	 * 각 화면에 맞는 Contract Type 정보를 가져온다<br>
	 * 
	 * @param typeFlag String
	 * @param lstTypeFlag List<String>
	 * @return List<SearchContractTypeListByContractVO>
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchContractTypeListByContractVO> searchContractTypeListByContract(String typeFlag, List<String> lstTypeFlag) throws DAOException {
		
		DBRowSet dbRowset = null;
		
		List<SearchContractTypeListByContractVO> searchContractTypeListByContractVO = null;
		
		try{
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			velParam.put("type_flag", (typeFlag == null || typeFlag.equals("") || typeFlag.equals("null")) ? "" : typeFlag);
			velParam.put("lstTYPE_FLAG", lstTypeFlag.iterator());
			
			dbRowset = new SQLExecuter().executeQuery(new TCharterIOContractDAOSearchContractTypeListByContractRSQL(), null, velParam);
			
			searchContractTypeListByContractVO = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchContractTypeListByContractVO.class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return searchContractTypeListByContractVO;
	}
}
