/*****
 * =========================================================
 * Copyright(c) 2006 CyberLogitec
 * @FileName : CARIssueTransferSlipManageDBDAO.java
 * @FileTitle : Terminal invoice CSR Creation - Detail
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2007-10-05
 * @LastModifier : jongbaemoon
 * @LastVersion : 1.0
 * 2006-12-18 jongbaemoon
 * 1.0 최초 생성
 * 2007-10-16 : 배분 수정
 * 2008-08-23 : AP_PERIOD 변경건 반영
 * 2009-01-29 : manual 재무항차 생성 logic중 rev_yrmon가 빈값인 경우 issue date를 참조하게 수정
 * 2009-02-12 : auto 재무항차 생성 logic에서 issue date를 참조하여 년월 생성하는 부분을 gate in date의 빠른값으로 참조하게 수정(2009-04-27:주석 수정)
 * 2009-02-17 : 재무항차 삭제건 DIR CD 조회 LOGIC 변경
 * 2009-02-20 : 재무항차 자리수 년월(YYMM)만으로 변경
 * 2009-02-24 : CSR 미주 지역 Check Mailing Address 국가 코드 표기 추가 ( 송민정 요청 )
 * 2009-04-28 : (국내용) CSR배부시 LANE CODE가 누락되어 금액 불일치를 유발하는 INVOICE를 추출하기
 * 2009-05-20 : [R200905200001] LANE CODE 불일치로 금액이 맞지 않을 경우  2차 검사를 수행한다.
 * 2009-06-22 : [N200906220001] TES 소급처리용 invoice 기능 추가 및 LEA 처리 로직 추가  
 * 2010-10-06 : 박재흥 [] 국외지역일경우 ATTR_CTNT8에 Received date 입력
 * 2010.10.13 박재흥 [] 소스품질 적용
 * =========================================================
 *****/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.basic.CARIssueTransferSlipManageBCImpl;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0023Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0024Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0100Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event.EsdTes0101Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.vo.CARIssueTransferSlipManageCommonVO;
import com.hanjin.bizcommon.approval.util.ApprovalUtil;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestBodyVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestFileVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestHeaderVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ApInvDtrbVO;
import com.hanjin.syscommon.common.table.ApInvHdrVO;
import com.hanjin.syscommon.common.table.ApTaxVO;
import com.hanjin.syscommon.common.table.ComAproCsrDtlVO;
import com.hanjin.syscommon.common.table.ComAproRqstHdrVO;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;
import com.hanjin.syscommon.common.table.LeaRevVvdCngVO;
import com.hanjin.syscommon.common.table.TesN3rdPtyIfVO;
import com.hanjin.syscommon.common.table.TesTmlSoCntrListVO;
import com.hanjin.syscommon.common.table.TesTmlSoDtlVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;

/**
 *   ENIS-ESD에 대한 DB 처리를 담당<br>
 * - ENIS-ESD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author jongbaemoon 
 * @see CARIssueTransferSlipManageBCImpl 참조
 * @since J2EE 1.4 *
 */
public class CARIssueTransferSlipManageDBDAO extends DBDAOSupport {

	/**
	 * CARIssueTransferSlipManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String csr_no
	 * @return String
	 * @throws DAOException
	 */
	public String searchASANo(String csr_no) throws DAOException {
		log.debug("start searchASANo =============================");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String aSANo = "";
		
		param.put("csr_no", csr_no);
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchASANoRSQL(), param, velParam);

			if (dbRowset!=null){
				while(dbRowset.next()){
					aSANo = dbRowset.getString("ASANo");
				}
			}
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return aSANo;

	}

	/**
	 * searchCSRSummary 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCSRSummary(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {
		log.debug("start searchCSRSummary =============================");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.putAll(tesTmlSoHdrVO.getColumnValues());
		velParam.putAll(tesTmlSoHdrVO.getColumnValues());
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchCSRSummaryRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
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
	 * CARIssueTransferSlipManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 전나영차장 : 왈~ 그냥 기존대로 inv_ofc_Cd로 조회해... 현장에서 그렇게 사용할 리가 없어...라고..
	 * 
	 * @param EsdTes0023Event event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public String searchSoIfCd(EsdTes0023Event event) throws DAOException {
		log.debug("start searchSoIfCd =============================");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String	so_if_cd = "";
		
		try {

			param.put("ofc_cd", event.getSignOnUserAccount().getOfc_cd());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchSoIfCdRSQL(), param, velParam);

            if (dbRowset != null) {
            	while(dbRowset.next()){
            		so_if_cd = dbRowset.getString("so_if_cd");
            	}
            }
            
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return so_if_cd;
		
	}

	/**
	 * searchCSRSummary1 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCSRSummary1(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {
		log.debug("start searchCSRSummary1 =============================");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.putAll(tesTmlSoHdrVO.getColumnValues());
		velParam.putAll(tesTmlSoHdrVO.getColumnValues());
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchCSRSummary1RSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
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
	 * tmpSearchCSRSummary 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param EsdTes0024Event event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet tmpSearchCSRSummary(EsdTes0024Event event) throws DAOException {

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		if(event != null){
			Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		}
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOTmpSearchCSRSummaryRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
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
	 * tmpSearchCSRSummaryList 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param EsdTes0024Event event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet tmpSearchCSRSummaryList(EsdTes0024Event event) throws DAOException {
		log.debug("start tmpSearchCSRSummaryList ================================");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		if(event != null){
			Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		}
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOTmpSearchCSRSummaryListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
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
	 * searchCSRSummaryDetail 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCSRSummaryDetail(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {
		log.debug("start searchCSRSummaryDetail=================================");
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchCSRSummaryDetailRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
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
	 * searchCSRSummaryDetail1 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCSRSummaryDetail1(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {
		log.debug("start searchCSRSummaryDetail1=================================");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchCSRSummaryDetail1RSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
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
	 * searchApOfcCD 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String ofc_cd
	 * @return String
	 * @throws DAOException
	 */
	public String searchApOfcCD(String ofc_cd) throws DAOException {
		log.debug("start searchApOfcCD =================");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String ap_ofc_cd = "";
		
		try {
			if(ofc_cd != null){
				param.put("ofc_cd", ofc_cd);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchApOfcCDRSQL(), param, velParam);

            if (dbRowset != null) {
            	while(dbRowset.next()){
            		ap_ofc_cd = dbRowset.getString("ap_ofc_cd");
            	}
            }
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return ap_ofc_cd;		
		

	}

	/**
	 * searchASANOList 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 전나영차장 : 왈~ 그냥 기존대로 inv_ofc_Cd로 조회해... 현장에서 그렇게 사용할 리가 없어...라고..
	 * 
	 * @param String ofc_cd
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchASANOList(String ofc_cd) throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(ofc_cd != null){
				param.put("ofc_cd", ofc_cd);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchASANOListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
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

	/** multiCSRInsert CSR건들을 다중으로 넣는다.
	 * 
	 * @param ofc_cd
	 * @param csr_no
	 * @throws DAOException
	 */
	public void multiCSRInsert(String ofc_cd, String csr_no) throws DAOException {
		log.debug("start multiCSRInsert ============================");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			
			param.put("ofc_cd", ofc_cd);
			param.put("csr_no", csr_no);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOMultiCSRNoInsertCSQL(), param, velParam);

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
		
	}
	
	
	/**
	 * multiCSRNo 데이타 모델에 해당되는 값을 불러온다.<br>
	 * @param String ofc_cd
	 * @param String csr_no_sub
	 * @param String convRevVVD_YN
	 * @return String csr_no
	 * @throws DAOException
	 */
	public String multiCSRNo(String ofc_cd, String csr_no_sub, String convRevVVD_YN) throws DAOException {
		log.debug("\n\n DAO.multiCSRNo -------------------------------\n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String csr_no = "";
		
		try {
			param.put("ofc_cd", ofc_cd);
			param.put("csr_no_sub", csr_no_sub);
			param.put("convRevVVD_YN", convRevVVD_YN);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOMultiCSRNoCSRNoRSQL(), param, velParam);

			if(dbRowset!=null && dbRowset.next()){
				csr_no = dbRowset.getString("csr_no");
			}
			
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return csr_no;	

	}

	/**
	 * CARIssueTransferSlipManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * -->>  CSR 결재처리 상태('P')는 Disapprove할 수 없게 하기 위해 TML_INV_STS_CD 조건을 추가합니다.
	 * 
	 * @param  voList List<TesTmlSoHdrVO>
	 * @throws DAOException
	 */
	public void rejectInvoice(List<TesTmlSoHdrVO> voList) throws DAOException {
		log.debug("start rejectInvoice ==================");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new CARIssueTransferSlipManageDBDAORejectInvoiceUSQL(), voList, velParam, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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

	}

	/**
	 * CARIssueTransferSlipManage의 approvalrequest 처리시 체크 invoice csr_no update 처리.<br>
	 *
	 * @param voList List<TesTmlSoHdrVO>  
	 * @param String  csr_no
	 * @return String
	 * @throws DAOException
	 */
	public String upateInvCSRNo(List<TesTmlSoHdrVO> voList, String csr_no) throws DAOException {
		log.debug("\n DAO.upateInvCSRNo --------------------------------------------------");

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	

		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new CARIssueTransferSlipManageDBDAOUpateInvCSRNoUSQL(), voList, velParam, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}			
 
		 return csr_no;	
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
		
	}

	/**
	 * CARIssueTransferSlipManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param model 데이타 모델
	 * @return DBRowSet
	 * @throws DAOException
	 */
//	public String searchApInvChacke() throws DAOException {
//		// Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement ps = null;
//		// DB ResultSet
//		ResultSet rs = null;
//
//		String sts_cd = "N";
//
//		StringBuffer queryStr = new StringBuffer();
//
//		queryStr.append(" SELECT DECODE(A.STS,'O',TO_CHAR(SYSDATE,'YYYYMMDD'),'C',B.DT,'N','N') STS					\n");
//		//queryStr.append(" SELECT DECODE(A.STS,'O',TO_CHAR(SYSDATE,'YYYYMMDD'),'C',B.DT,'N',null) STS				\n");
//		queryStr.append("      FROM   ( SELECT PRD_CLZ_STS_CD STS 													\n");
//		queryStr.append("                       FROM   AP_PERIOD 													\n");
//		queryStr.append("                      WHERE  TO_CHAR(PRD_ST_DT,'YYYYMM') = TO_CHAR(SYSDATE,'YYYYMM') ) A, 	\n");
//		queryStr.append("         ( SELECT MAX(TO_CHAR(PRD_ST_DT,'YYYYMM'))||'01' DT 						        \n");
//		queryStr.append("            FROM   AP_PERIOD 													            \n");
//		queryStr.append("             WHERE  PRD_CLZ_STS_CD = 'O' ) B  									            \n");
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
//			// Loggable Statement 사용에 의해 추가
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL :" + ((LoggableStatement)ps).getQueryString());
//			} else {
//				log.info("\n SQL :" + queryStr );
//			}
//			rs = ps.executeQuery();
//
//			if(rs!=null){
//				while(rs.next()){
//					sts_cd = rs.getString("STS");
//				}
//			}
//
//			if(sts_cd.equals("N")){
//				throw new DAOException(new ErrorHandler("TES00064").getMessage());
//			}
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
//		} finally {
//			closeResultSet(rs);
//			closeStatement(ps);
//			closeConnection(con);
//		}
//		return sts_cd;
//	}

	/**
	 * searchApInvChacke1 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param event EsdTes0024Event 
	 * @return String
	 * @throws DAOException
	 */
	public String searchApInvChacke1(EsdTes0024Event event) throws DAOException {
		log.debug("start searchApInvChacke1 =========================== ");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String sts_cd 		= "N";
		String ap_ofc_cd 	= "";
		String finc_rgn_cd 	= "";
		String ap_ctr_cd 	= "";

		try {
			if(event.getTesTmlSoHdrVO()!= null){
				param.putAll(event.getTesTmlSoHdrVO().getColumnValues());
				velParam.putAll(event.getTesTmlSoHdrVO().getColumnValues());
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchApInvChacke1RSQL(), param, velParam);

			if(dbRowset!=null){
				while(dbRowset.next()){
					ap_ofc_cd 	= dbRowset.getString("ap_ofc_cd");
					finc_rgn_cd = dbRowset.getString("finc_rgn_cd");
					ap_ctr_cd 	= dbRowset.getString("ap_ctr_cd");
				}
			}
			
			if(ap_ofc_cd.equals("N") || ap_ofc_cd.equals("")){
				throw new DAOException(new ErrorHandler("TES00065").getMessage());
			}

			if(finc_rgn_cd.equals("N") || ap_ofc_cd.equals("")){
				throw new DAOException(new ErrorHandler("TES00066").getMessage());
			}

			if(ap_ctr_cd.equals("N") || ap_ctr_cd.equals("")){
				throw new DAOException(new ErrorHandler("TES00067").getMessage());
			}
			
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		
		return sts_cd;

	}

	/**
	 * searchApInvChacke2 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchApInvChacke2(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {
		log.debug("start searchApInvChacke2 =============================");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchApInvChacke2RSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
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
	 * CARIssueTransferSlipManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String csr_no
	 * @throws DAOException
	 */
	public void searchApInvVVDChacke(String csr_no) throws DAOException {
		log.debug("\n DAO.searchApInvVVDChacke --------------------------------------------------");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String lvl_chk 	= "";
		String rvvd 	= "";
		String invNo 	= "";
		String bkgNo 	= "";
		
		try {
			param.put("csr_no", csr_no);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchApInvVVDChackeRSQL(), param, velParam);

			if(dbRowset!=null){
				while(dbRowset.next()){
					rvvd		= dbRowset.getString("RVVD");
					invNo		= dbRowset.getString("INV_NO");
					bkgNo	= dbRowset.getString("BKG_NO");
					lvl_chk		= dbRowset.getString("LVL_CHK");
					log.info("\n[][approvalRequest][searchApInvVVDChacke] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> CSR_NO = " + csr_no + " : rvvd = " + rvvd + " : invNo = " + invNo + " : bkgNo = " + bkgNo + " : lvl_chk = " + lvl_chk );
					
				if(lvl_chk.equals("N")){
						log.error("\n\n Wrong VVD --  CSR_NO = " + csr_no + " / DTRB_COA_VVD_CD:" + rvvd +" : invNo = " + invNo + " : bkgNo = " + bkgNo + " / DTRB_COA_ACCT_CD:" + dbRowset.getString("DTRB_COA_ACCT_CD") + " --------------------- \n\n");
//						throw new DAOException(new ErrorHandler("TES00070", new String[]{rvvd}).getMessage());
						// CHM-201538687 재무항차 Error관련 BookingInvalid Rev VVD를 에러창에 기입(2항목) - (2015-11-06 조아영D)
						// [Invalid Revenue VVD error: VVD XXXX/Invoice No : XXXX] Booking has to be updated on BKNG NO(XXXXX) before proceeding further. Please contact the booking office
						throw new DAOException(new ErrorHandler("TES00070", new String[]{rvvd,invNo,bkgNo}).getMessage());
					}
				}
			}
			
		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		

	}
	
	/** getAutoRevVVDList 재무항차를 가져온다.
	 * 
	 * @param 	TesTmlSoHdrVO tesTmlSoHdrVO
	 * @param 	ap_ofc_cd
	 * @return  DBRowSet
	 * @throws 	DAOException
	 */
	public DBRowSet getAutoRevVVDList(TesTmlSoHdrVO tesTmlSoHdrVO, String ap_ofc_cd) throws DAOException {
		log.debug("\n\n DAO.getAutoRevVVDList -------------------------------\n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(tesTmlSoHdrVO != null){
				param.putAll(tesTmlSoHdrVO.getColumnValues());
				velParam.putAll(tesTmlSoHdrVO.getColumnValues());
			}

			param.put("ap_ofc_cd", ap_ofc_cd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOGetAutoRevVVDListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
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


	/** getManualRevVVDList 재무항차가지고 옮
	 *
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @param String ap_ofc_cd
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet getManualRevVVDList(TesTmlSoHdrVO tesTmlSoHdrVO, String ap_ofc_cd) throws DAOException {
		log.debug("\n\n DAO.getManualRevVVDList -------------------------------\n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(tesTmlSoHdrVO != null){
				param.putAll(tesTmlSoHdrVO.getColumnValues());
				velParam.putAll(tesTmlSoHdrVO.getColumnValues());
			}
			
			param.put("ap_ofc_cd", ap_ofc_cd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOGetManualRevVVDListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
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
	 * modifyAutoRevVVD 자동계산된 재무항차를 수정한다.<br>
	 *
	 * @param  voList List<TesTmlSoCntrListVO>
	 * @throws DAOException
	 */
	public void modifyAutoRevVVD(List<TesTmlSoCntrListVO> voList) throws DAOException {
		log.debug("\n\n DAO.modifyAutoRevVVD -------------------------------\n");

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new CARIssueTransferSlipManageDBDAOModifyAutoRevVVDUSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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

	}

	/**
	 * modifyManualRevVVD 수동계산된 재무항차를 수정한다.
	 *
	 * @param List<TesTmlSoDtlVO> voList
	 * @throws DAOException
	 */
	public void modifyManualRevVVD(List<TesTmlSoDtlVO> voList) throws DAOException {
		log.debug("\n\n DAO.modifyAutoRevVVD -------------------------------\n");

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new CARIssueTransferSlipManageDBDAOModifyManualRevVVDUSQL(), voList, velParam, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
		

	}

	/**
	 * createApInvHDR 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param EsdTes0024Event event
	 * @throws DAOException
	 */
	public void createApInvHDR(EsdTes0024Event event) throws DAOException {
		log.debug("start createApInvHDR ======================================");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		String asa_no = "";
		
		try {
			if(event != null){
				Map<String, String> mapVO = event.getCARIssueTransferSlipManageCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getApInvHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				if(event.getCARIssueTransferSlipManageCommonVO().getEviInvDt()!=null && !event.getCARIssueTransferSlipManageCommonVO().getEviInvDt().equals("")){
					event.getCARIssueTransferSlipManageCommonVO().setEviInvDt(event.getCARIssueTransferSlipManageCommonVO().getEviInvDt().replaceAll("-","/"));
				}

				if(event.getCARIssueTransferSlipManageCommonVO().getSEviInvDt()!=null && !event.getCARIssueTransferSlipManageCommonVO().getSEviInvDt().equals("")){
					event.getCARIssueTransferSlipManageCommonVO().setSEviInvDt(event.getCARIssueTransferSlipManageCommonVO().getSEviInvDt().replaceAll("-","/"));
				}
				
				if(event.getCARIssueTransferSlipManageCommonVO().getAttrCtnt8()!= null && !event.getCARIssueTransferSlipManageCommonVO().getAttrCtnt8().equals("")){
					param.put("attr_ctnt8", event.getCARIssueTransferSlipManageCommonVO().getAttrCtnt8());
				}
				
				if("C".equals(event.getApInvHdrVO().getCsrTpCd())){
					param.put("csr_tp_cd", "CREDIT");
				}else{
					param.put("csr_tp_cd", "STANDARD");
				}
				
				if("KR".equals(event.getCARIssueTransferSlipManageCommonVO().getCntCd())){
					if("".equals(event.getCARIssueTransferSlipManageCommonVO().getEviInvDt())){
						param.put("inv_dt", event.getCARIssueTransferSlipManageCommonVO().getMaxIssDt().replaceAll("-", ""));
					}else{
						param.put("inv_dt", event.getCARIssueTransferSlipManageCommonVO().getEviInvDt().replaceAll("/", ""));
					}
					
				}else{
					param.put("inv_dt", event.getCARIssueTransferSlipManageCommonVO().getMaxIssDt().replaceAll("-", ""));
				}
				
				param.put("inv_term_dt", event.getCARIssueTransferSlipManageCommonVO().getMaxRcvDt().replaceAll("-", ""));
				

				if("KR".equals(event.getCARIssueTransferSlipManageCommonVO().getCntCd()) && "1".equals(event.getCARIssueTransferSlipManageCommonVO().getEviGb())){				
					param.put("gl_dt", event.getCARIssueTransferSlipManageCommonVO().getEviInvDt().replaceAll("/", ""));
				}else if("KR".equals(event.getCARIssueTransferSlipManageCommonVO().getCntCd()) && "2".equals(event.getCARIssueTransferSlipManageCommonVO().getEviGb())){
					param.put("gl_dt", event.getCARIssueTransferSlipManageCommonVO().getSEviInvDt().replaceAll("/", ""));
				}else{
					param.put("gl_dt", event.getCARIssueTransferSlipManageCommonVO().getMaxIssDt().replaceAll("-", ""));
				}
				
				if("KR".equals(event.getCARIssueTransferSlipManageCommonVO().getCntCd())){
					if("1".equals(event.getCARIssueTransferSlipManageCommonVO().getEviGb())){
						param.put("attr_cate_nm", "세금계산서");
					}else if("2".equals(event.getCARIssueTransferSlipManageCommonVO().getEviGb())){
						param.put("attr_cate_nm", "계산서");
					}else if("3".equals(event.getCARIssueTransferSlipManageCommonVO().getEviGb())){
						param.put("attr_cate_nm", "기타");
					}else{
						param.put("attr_cate_nm", "");
					}
					
				}else{
					//[CHM-201539538]VVOBA CSR처리시 증빙 타입을 Invoice에서 기타로 Hard Coding전환 (2015-12-23 조아영 D)
					if(event.getCARIssueTransferSlipManageCommonVO().getApOfcCd().trim().equals("VVOBA")){
						param.put("attr_cate_nm", "기타");
					}else{
						param.put("attr_cate_nm", "Invoices");
					}
					//2010.10.06  조경삼 수석 요청
					param.put("attr_ctnt8", event.getCARIssueTransferSlipManageCommonVO().getMaxRcvDt().replaceAll("-", "")+"000000");
				}

				if("KR".equals(event.getCARIssueTransferSlipManageCommonVO().getCntCd())){
					param.put("attr_ctnt2", event.getCARIssueTransferSlipManageCommonVO().getEviCompNo());

				}else{
					if(event.getCARIssueTransferSlipManageCommonVO().getAsaNo()!=null && !event.getCARIssueTransferSlipManageCommonVO().getAsaNo().trim().equals("")){
						asa_no = event.getCARIssueTransferSlipManageCommonVO().getAsaNo();
						/** asa에 대한 ofc별 날짜 유효성 검사 **/
						//String chkAsa = null;
						//chkAsa = checkASAno(asa_no, event.getSignOnUserAccount().getOfc_cd(), "");
						//if (chkAsa==null || (chkAsa!=null && !chkAsa.equals("Y"))){
						//	throw new DAOException("\n\n Invalid ASA No. \n\n");
						//}						
						asa_no = asa_no.substring(0,3)+asa_no.substring(6,10)+asa_no.substring(3,6);
					}
					
					param.put("attr_ctnt2", asa_no);
				}
				
				if(!"".equals(event.getCARIssueTransferSlipManageCommonVO().getEviInvDt())){
					param.put("attr_ctnt3", event.getCARIssueTransferSlipManageCommonVO().getEviInvDt()+" 00:00:00");
				}else{
					param.put("attr_ctnt3", event.getCARIssueTransferSlipManageCommonVO().getEviInvDt());
				}
				
//				if("US".equals(event.getCARIssueTransferSlipManageCommonVO().getCntCd())){
//					//param.put("pay_mzd_lu_cd", "CMS CHECK");    
//					//2013.3.20 US의 경우 Pay method 를 세분화하기 위해 하드코딩 막음 
//
//				}else{
					param.put("pay_mzd_lu_cd", "WIRE");
//				}
				
				if("KR".equals(event.getCARIssueTransferSlipManageCommonVO().getCntCd())){
					param.put("pay_grp_lu_cd", "대외지불");

				}else{
					if("0".equals(event.getApInvHdrVO().getCsrAmt()) || ("".equals(event.getCARIssueTransferSlipManageCommonVO().getAsaNo()) 
																		&& "ASA".equals(event.getCARIssueTransferSlipManageCommonVO().getAsanogb()))){
						param.put("pay_grp_lu_cd", event.getCARIssueTransferSlipManageCommonVO().getApOfcCd()+"_ZERO PAYMENT");
					}else{
						/*  2009-01-01 이후 : XMNBB 조직변경으로 인해 XMNBB는 더 이상 PAY_GROUP을 선택하지 않고 일반적인 다른 OFFICE와 동일하게 처리한다. */
						if(event.getCARIssueTransferSlipManageCommonVO().getPayGroupCd()!=null 
									&& event.getCARIssueTransferSlipManageCommonVO().getPayGroupCd().trim().equals("RHQ")
									&& event.getCARIssueTransferSlipManageCommonVO().getApOfcCd()!=null
									&& (
										event.getCARIssueTransferSlipManageCommonVO().getApOfcCd().trim().equals("SZPSC")	//2015-08-03 그룹사 조직 코드 변경 (SZPBB -> SZPSC)
										|| event.getCARIssueTransferSlipManageCommonVO().getApOfcCd().trim().equals("CANSO")	//2015-08-03 그룹사 조직 코드 변경 (CANBS -> CANSO)
										)){
								param.put("pay_grp_lu_cd", event.getCARIssueTransferSlipManageCommonVO().getApOfcCd()+"_RHQ_PYMT");
											
						}else{
								param.put("pay_grp_lu_cd", event.getCARIssueTransferSlipManageCommonVO().getApOfcCd()+"_O/EXP");
							
						}
					}
				}
				
				param.put("ofc_cd",event.getSignOnUserAccount().getOfc_cd());
				param.put("cre_usr_id",event.getSignOnUserAccount().getUsr_id());
				param.put("usr_nm",event.getSignOnUserAccount().getUsr_nm());
				param.put("cnt_cd",event.getCARIssueTransferSlipManageCommonVO().getCntCd());
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOCreateApInvHDRCSQL(), param, velParam);

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

	}

	/**
	 * LEA 전용 <br>
	 *
	 * @param LeaRevVvdCngVO leaRevVvdCngVO
	 * @param String new_csr_no
	 * @param String usr_eml
	 * @param String usr_id
	 * @throws DAOException
	 */
	public void createApInvHDR2(LeaRevVvdCngVO leaRevVvdCngVO, String new_csr_no, String usr_eml, String usr_id) throws DAOException {
		log.debug("start createApInvHDR2 ===============================");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			param.putAll(leaRevVvdCngVO.getColumnValues());
			velParam.putAll(leaRevVvdCngVO.getColumnValues());
			
			param.put("new_csr_no", new_csr_no);
			param.put("usr_eml", usr_eml);
			param.put("usr_id", usr_id);

			new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOCreateApInvHDR2CSQL(), param, velParam);

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
		
	}
	
	/** createApInvHdrUpdate
	 * 
	 * @param event EsdTes0024Event
	 * @throws DAOException
	 */
	public void createApInvHdrUpdate(EsdTes0024Event event) throws DAOException {
		log.debug("start createApInvHdrUpdate ===============================");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(event!= null){
				Map<String, String> mapVO = event.getApInvHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
						
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOCreateApInvHdrUpdateUSQL(), param, velParam);

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
		
	}

	/**
	 * CARIssueTransferSlipManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 배부치기 + INV_DESC에 max acct명 넣기
	 * @param  voList List<ApInvDtrbVO>
	 * @throws DAOException
	 */
	public void createApInvDTRB(List<ApInvDtrbVO> voList) throws DAOException {
		log.debug("\n DAO.createApInvDTRB --------------------------------------------------");

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new CARIssueTransferSlipManageDBDAOCreateApInvDTRBCSQL(), voList, velParam, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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

	}

	/** checkMissingLaneCode01
	 * 
	 * @param tesTmlSoHdrVO
	 * @param cnt_cd
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet checkMissingLaneCode01(TesTmlSoHdrVO tesTmlSoHdrVO, String cnt_cd) throws DAOException {
		log.debug("start checkMissingLaneCode01 =============================");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(tesTmlSoHdrVO != null){
				param.putAll(tesTmlSoHdrVO.getColumnValues());
				velParam.putAll(tesTmlSoHdrVO.getColumnValues());
			}

			param.put("cnt_cd", cnt_cd);	
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOCheckMissingLaneCode01RSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
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
	
	/** checkMissingLaneCode02
	 * 
	 * @param tesTmlSoHdrVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet checkMissingLaneCode02(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {
		log.debug("start checkMissingLaneCode02 =============================");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(tesTmlSoHdrVO != null){
				param.putAll(tesTmlSoHdrVO.getColumnValues());
				velParam.putAll(tesTmlSoHdrVO.getColumnValues());
			}

//			param.put("cnt_cd", cnt_cd);	
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOCheckMissingLaneCode02RSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
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
	 * searchApInvDTRBIn
	 *
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @param int seq
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchApInvDTRBIn(TesTmlSoHdrVO tesTmlSoHdrVO, int seq) throws DAOException {
		log.debug("\n DAO.searchApInvDTRBIn --------------------------------------------------");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(tesTmlSoHdrVO != null){
				param.putAll(tesTmlSoHdrVO.getColumnValues());
				velParam.putAll(tesTmlSoHdrVO.getColumnValues());
				
				param.put("ofc_cd", tesTmlSoHdrVO.getInvOfcCd());
				param.put("line_seq", seq+"");
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchApInvDTRBInRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
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
	 * createApInvDTRBEvi 
	 *
	 * @param EsdTes0024Event event
	 * @throws DAOException
	 */
	public void createApInvDTRBEvi(EsdTes0024Event event) throws DAOException {
		log.debug("\n DAO.createApInvDTRBEvi --------------------------------------------------");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();		
		
		List velVoList = new ArrayList();
		
		try {
			
			if(event.getTesTmlSoHdrVOs()!=null){
				for(int i=0; i<event.getTesTmlSoHdrVOs().length; i++){
					velVoList.add(event.getTesTmlSoHdrVOs()[i].getInvNo());
				}
			}
			
			velParam.put("vel_inv_no", velVoList);
			
			if(event.getTesTmlSoHdrVO() != null){
				Map<String, String> mapVO = event.getTesTmlSoHdrVO().getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("cre_usr_id", event.getSignOnUserAccount().getUsr_id());
			}

			log.debug("event.getCARIssueTransferSlipManageCommonVO().getEviTaxCode======>"+event.getCARIssueTransferSlipManageCommonVO().getEviTaxCode());
			log.debug("param===========>"+param);
			
			log.debug("event.getCARIssueTransferSlipManageCommonVO().getCntCd().equals(KR)=====>"+event.getCARIssueTransferSlipManageCommonVO().getCntCd().equals("KR"));
			log.debug("event.getCARIssueTransferSlipManageCommonVO().getEviGb().equals(1)========>"+event.getCARIssueTransferSlipManageCommonVO().getEviGb().equals("1"));
			
			if(event.getCARIssueTransferSlipManageCommonVO() != null){
				if(event.getCARIssueTransferSlipManageCommonVO().getCntCd().equals("KR")){
					if(event.getCARIssueTransferSlipManageCommonVO().getEviGb().equals("1")){
						param.put("inv_tax_cd", event.getCARIssueTransferSlipManageCommonVO().getEviTaxCode());
					}else if(event.getCARIssueTransferSlipManageCommonVO().getEviGb().equals("2")){
						param.put("inv_tax_cd", "매입계산서");
					}
				}else{
					param.put("inv_tax_cd", "");
				}
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOCreateApInvDTRBEviCSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################dao.se.getMessage()============>"+se.getMessage());
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

	}

	/**
	 * searchApInvDTRBOut 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @param int seq
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchApInvDTRBOut(TesTmlSoHdrVO tesTmlSoHdrVO, int seq) throws DAOException {
		log.debug("\n DAO.searchApInvDTRBOut --------------------------------------------------");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(tesTmlSoHdrVO != null){
				param.putAll(tesTmlSoHdrVO.getColumnValues());
				velParam.putAll(tesTmlSoHdrVO.getColumnValues());
				
				param.put("ofc_cd", tesTmlSoHdrVO.getInvOfcCd());
				param.put("line_seq", seq+"");
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchApInvDTRBOutRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
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
	 * LEA 전용. <br>
	 *
	 * @param LeaRevVvdCngVO leaRevVvdCngVO
	 * @param String new_csr_no
	 * @param String ofc_cd
	 * @param String usr_id
	 * @throws DAOException
	 */
	public void createApInvDTRB2(LeaRevVvdCngVO leaRevVvdCngVO, String new_csr_no, String ofc_cd, String usr_id) throws DAOException {
		log.debug("\n DAO.createApInvDTRB2 --------------------------------------------------");

		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			param.putAll(leaRevVvdCngVO.getColumnValues());
			velParam.putAll(leaRevVvdCngVO.getColumnValues());
			
			param.put("new_csr_no", new_csr_no);
			param.put("ofc_cd", ofc_cd);
			param.put("usr_id", usr_id);
						
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOCreateApInvDTRB2CSQL(), param, velParam);

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

	}
	
	/** modifyApInvDTRBLineNo03
	 * 
	 * @param ApInvDtrbVO apInvDtrbVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet modifyApInvDTRBLineNo03(ApInvDtrbVO apInvDtrbVO) throws DAOException {
		if(log.isDebugEnabled())log.debug("\n==========CARIssueTransferSlipManageDBDAO    modifyApInvDTRBLineNo03() ============");

		DBRowSet 			dbRowSet	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
		
		try {
			param.putAll(apInvDtrbVO.getColumnValues());
			velParam.putAll(apInvDtrbVO.getColumnValues());
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOModifyApInvDTRBLineNoUpdate03RSQL(), param, velParam);

			return dbRowSet;
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
		
	}
	
	/** modifyApInvDTRBLineNo02
	 * 
	 * @param  voList List<ApInvDtrbVO>
	 * @throws DAOException
	 */
	public void modifyApInvDTRBLineNo02(List<ApInvDtrbVO> voList) throws DAOException {
		log.debug("\n DAO.modifyApInvDTRBLineNo02 --------------------------------------------------");

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new CARIssueTransferSlipManageDBDAOModifyApInvDTRBLineNoUpdate02USQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	}
	
	/**
	 * CARIssueTransferSlipManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String csr_no
	 * @throws DAOException
	 */
	public void modifyApInvDTRBLineNo(String csr_no) throws DAOException {
		log.debug("\n DAO.modifyApInvDTRBLineNo --------------------------------------------------");

		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			param.put("csr_no", csr_no);

			new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOModifyApInvDTRBLineNoUpdate01USQL(), param, velParam);

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
		
		
	}
	
	/** createApInvDTRB_sum
	 * 
	 * @param tesTmlSoHdrVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet createApInvDTRB_sum(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {
		log.debug("start createApInvDTRB_sum ========================");

		DBRowSet 			dbRowSet	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
		
		try {
			if(tesTmlSoHdrVO != null){
				Map<String, String> mapVO = tesTmlSoHdrVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOCreateApInvDTRBsumRetrieveRSQL(), param, velParam);
			return dbRowSet;
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
		
	}

	/** CreateApInvDTRB_sumUpdateDiff
	 * @param cARIssueTransferSlipManageCommonVO
	 * @param tesTmlSoHdrVO
	 * @throws DAOException
	 */
	public void createApInvDTRB_sumUpdateDiff(CARIssueTransferSlipManageCommonVO cARIssueTransferSlipManageCommonVO, TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
		
		try {
			
			Map<String, String> mapVO = cARIssueTransferSlipManageCommonVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			mapVO = tesTmlSoHdrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			

			new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOCreateApInvDTRB_sumUpdateDiffUSQL(), param, velParam);

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
	}


	/**
	 * createApInvDTRBASANoSelect
	 * 
	 * @param csr_no
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet createApInvDTRBASANoSelect(String csr_no) throws DAOException {
		log.debug("start createApInvDTRBASANoSelect ========================");

		DBRowSet 			dbRowSet	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
		
		try {
			param.put("csr_no", csr_no);

			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOCreateApInvDTRBASANoRSQL(), param, velParam);

			return dbRowSet;
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
	}	

	
	/**
	 * createApInvDTRBASANoInsert
	 * 
	 * @param cARIssueTransferSlipManageCommonVO
	 * @param tesTmlSoHdrVO
	 * @param apInvDtrbVO
	 * @param ofc_cd
	 * @param cre_usr_id
	 * @throws DAOException
	 */
	public void createApInvDTRBASANoInsert(CARIssueTransferSlipManageCommonVO cARIssueTransferSlipManageCommonVO, 
											TesTmlSoHdrVO tesTmlSoHdrVO, ApInvDtrbVO apInvDtrbVO, String ofc_cd, String cre_usr_id) throws DAOException {
		log.debug("start createApInvDTRBASANoInsert =============================");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = cARIssueTransferSlipManageCommonVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			mapVO = tesTmlSoHdrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
			
			mapVO = apInvDtrbVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	
			param.put("ofc_cd", ofc_cd);
			param.put("cre_usr_id", cre_usr_id);

			new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOCreateApInvDTRBASANoCSQL(), param, velParam);

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
	}
	
	/**
	 * createApInvDTRBASANoUpdate
	 * 
	 * @param csr_no
	 * @throws DAOException
	 */
	public void createApInvDTRBASANoUpdate(String csr_no) throws DAOException {
		log.debug("start createApInvDTRBASANoUpdate =============================");
	
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			param.put("csr_no", csr_no);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOCreateApInvDTRBASANoUSQL(), param, velParam);

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
	}


//	/**
//	 * CSR생성시 AP I/F를 위해 AP_INV_IF에 DATA를 넣는다.
//	 *
//	 * @param String csr_no
//	 * @return String
//	 * @throws DAOException
//	 */
//	public String createApInvIF(String csr_no) throws DAOException {
//		log.debug("\n DAO.createApInvIF --------------------------------------------------");
//
//		Map<String, Object> param 		= new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam 	= new HashMap<String, Object>();
//		String 				pgm_no 		= "ESDTESXXX"+JSPUtil.getKST("yyyyMMdd");
//		
//		try {
//			param.put("pgm_no", pgm_no);
//			param.put("csr_no", csr_no);
//			
//			new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOCreateApInvIFCSQL(), param, velParam);
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
//		return pgm_no;
//
//	}

	/**
	 * createCSREPApproval 결제 정보를 등록한다.<br>
	 *
	 * @param  event EsdTes0024Event 
	 * @throws DAOException
	 */
	public void createCSREPApproval(EsdTes0024Event event) throws DAOException{
		log.debug("\n DAO.createCSREPApproval --------------------------------------------------");

		try {

			String  sCsr_no 			= JSPUtil.getNull(String.valueOf(event.getApInvHdrVO().getCsrNo()));
			String  sTotal_amt  		= JSPUtil.getNull(String.valueOf(event.getCARIssueTransferSlipManageCommonVO().getTotalAmt()));
			String  sCost_ofc_cd  		= JSPUtil.getNull(String.valueOf(event.getTesTmlSoHdrVO().getCostOfcCd()));
			String  sUsr_nm  			= JSPUtil.getNull(String.valueOf(event.getSignOnUserAccount().getUsr_nm()));
			String  sCre_usr_id  		= JSPUtil.getNull(String.valueOf(event.getSignOnUserAccount().getUsr_id()));
			String  sApro_step  		= JSPUtil.getNull(String.valueOf(event.getCARIssueTransferSlipManageCommonVO().getAproStep()));
			String  sOfc_nm  			= JSPUtil.getNull(String.valueOf(event.getSignOnUserAccount().getOfc_eng_nm()));
			String  sVndr_seq  			= JSPUtil.getNull(String.valueOf(event.getTesTmlSoHdrVO().getVndrSeq()));
			String  sCurr_cd  			= JSPUtil.getNull(String.valueOf(event.getTesTmlSoHdrVO().getCurrCd()));
			String  sCnt_cd  			= JSPUtil.getNull(String.valueOf(event.getCARIssueTransferSlipManageCommonVO().getInvKnt()));
			//String  sGen_pay_term_cd	= JSPUtil.getNull(String.valueOf(hashParam.get("gen_pay_term_cd")));
			String  sPayment_due_dt		= JSPUtil.getNull(String.valueOf(event.getCARIssueTransferSlipManageCommonVO().getPaymentDueDt()));

			if(!sPayment_due_dt.equals("")){
				sPayment_due_dt = sPayment_due_dt.replaceAll("-","");
			}
			
			ApprovalUtil util = new ApprovalUtil();

			// COM_APRO_RQST_HDR
			ComAproRqstHdrVO header = new ComAproRqstHdrVO();
			header.setSubSysCd("TES");
			header.setAproKndCd("CSR");
			header.setRqstOfcCd(sCost_ofc_cd);
			header.setRqstOfcNm(sOfc_nm);
			header.setRqstUsrJbTitNm(""); // 직책
			header.setRqstUsrId(sCre_usr_id);
			header.setRqstUsrNm(sUsr_nm);
			header.setCreUsrId(sCre_usr_id);

			// COM_APRO_RQST_ROUT
//			String apro_step = com.hanjin.bizcommon.approval.util.ApprovalUtil.getApprovalRoute("SELHO", "SCE");
			ComAproRqstRoutVO[] route = util.convertApprovalRoute(sApro_step);

			// COM_APRO_CSR_DTL
			ComAproCsrDtlVO csr = new ComAproCsrDtlVO();
			csr.setCsrNo(sCsr_no);
			csr.setCostOfcCd(sCost_ofc_cd);
			csr.setInvKnt(sCnt_cd);
			csr.setVndrSeq(sVndr_seq);
			//csr.setPay_due_dt(sGen_pay_term_cd);
			csr.setPayDueDt(sPayment_due_dt);
			csr.setCurrCd(sCurr_cd);
			csr.setAproTtlAmt(sTotal_amt);
			csr.setCreUsrId(sCre_usr_id);

			// 결재 등록
			util.saveCsrApro(header, route, csr); 

		} catch(Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}

	/**
	 * searchSO 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param String csr_no
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchSO(String csr_no) throws DAOException {
		log.debug("start searchSO ============================= ");
		
		DBRowSet 			dbRowSet	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
		
		try {
			param.put("csr_no", csr_no);
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchSORSQL(), param, velParam);

			return dbRowSet;
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
		
	}
    
	
	
	/** searchAP_INV_HDR
	 * @param csr_no
	 * @return ApInvHdrVO
	 * @throws DAOException
	 */
	public ApInvHdrVO searchAP_INV_HDR(String csr_no) throws DAOException {
		log.debug("start modifyTes3PtyIFAP ============================= ");		
		
		DBRowSet 			dbRowSet	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
		ApInvHdrVO model = null;

		try {

			param.put("csr_no", csr_no);
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchAP_INV_HDRRSQL(), param, velParam);

        	if (dbRowSet!=null && dbRowSet.next()){
        		model = new ApInvHdrVO();
        		model.setCsrNo(dbRowSet.getString("CSR_NO"));
        		model.setVndrNo(dbRowSet.getString("VNDR_NO"));
        		model.setCsrCurrCd(dbRowSet.getString("CSR_CURR_CD"));
        	}
			
			return model;
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

	}
	
	/**
	 * modifyTes3PtyIFAP
	 * 
	 * @param tesTmlSoHdrVO
	 * @param usr_id
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet modifyTes3PtyIFAP(TesTmlSoHdrVO tesTmlSoHdrVO, String usr_id) throws DAOException {
		log.debug("start modifyTes3PtyIFAP ============================= ");
		
		DBRowSet 			dbRowSet	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
		
		try {

			param.putAll(tesTmlSoHdrVO.getColumnValues());
			velParam.putAll(tesTmlSoHdrVO.getColumnValues());
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOModifyTes3PtyIFAPRSQL(), param, velParam);

			return dbRowSet;
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
	}
	
	/** modifyTes3PtyIFTPB
	 * 
	 * @param  voList List<TesN3rdPtyIfVO>
	 * @throws DAOException
	 */
	public void modifyTes3PtyIFTPB(List<TesN3rdPtyIfVO> voList) throws DAOException {
		log.debug("start modifyTes3PtyIFTPB =============================");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new CARIssueTransferSlipManageDBDAOModifyTes3PtyIFTPBUSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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

	}

	
	/** checkCSRAmtVsInvAmt
	 * 
	 * @param csr_no
	 * @return String
	 * @throws DAOException
	 */
	public String checkCSRAmtVsInvAmt(String csr_no) throws DAOException {
		log.debug("start checkCSRAmtVsInvAmt =======================");
		
		DBRowSet 			dbRowSet	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
		
		String retval = null;
		
		try {
			param.put("csr_no", csr_no);
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOCheckCSRAmtVsInvAmtRSQL(), param, velParam);

			if (dbRowSet.next()){
				retval = dbRowSet.getString("RETVAL");
			}
			
			return retval;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new DAOException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}

	/**
	 * 
	 * @param asa_no
	 * @param ofc_cd
	 * @param gl_dt
	 * @return String
	 * @throws DAOException
	 */
//	public String checkASAno(String asa_no, String ofc_cd, String gl_dt) throws DAOException {
//		
//		DBRowSet 			dbRowSet	= null;
//		Map<String, Object> param 		= new HashMap<String, Object>();
//		Map<String, Object> velParam 	= new HashMap<String, Object>();
//		
//		String retval = null;
//		
//		try {
//			param.put("asa_no", asa_no);
//			param.put("ofc_cd", ofc_cd);
//			param.put("gl_dt", gl_dt);
//			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOcheckASAnoRSQL(), param, velParam);
//			if (dbRowSet.next()){
//				retval = dbRowSet.getString("CHK_ASA");
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage(), se);
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw new DAOException(new ErrorHandler(de).getMessage(), de);
//		} catch (Exception ex) {
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
//		}
//		return retval;
//	}
	

	/**
	 * 2007-07-18 : invoice의 DTL에서 AUTO계산이 하나라도 있는지 혹은 전부 M인지 확인....
	 * @param csr_no
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet checkCalcCostCD(String csr_no) throws DAOException {
		log.debug("\n\n ================== DAO.checkCalcCostCD - csr_no:"+csr_no+" ---------------------------------------   \n");
		
		DBRowSet 			dbRowSet	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
		
		try {
			param.put("csr_no", csr_no);
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOCheckCalcCostCDRSQL(), param, velParam);

			return dbRowSet;
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
		
	}
	
	/** checkMstRevVVD01
	 *  
	 * @param csr_no
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet checkMstRevVVD01(String csr_no) throws DAOException {
		log.debug("\n\n DAO.checkMstRevVVD01 - csr_no:"+csr_no+" ---------------------------------------   \n");
		
		DBRowSet 			dbRowSet	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
		
		try {
			param.put("csr_no", csr_no);
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOCheckMstRevVVD01RSQL(), param, velParam);

			return dbRowSet;
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
		
	}
	
	/** checkMstRevVVD02
	 * 
	 * @param vvd_cd
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet checkMstRevVVD02(String vvd_cd) throws DAOException {
	log.debug("\n\n DAO.checkMstRevVVD02 - vvd_cd:"+vvd_cd+" ---------------------------------------   \n");
		
		DBRowSet 			dbRowSet	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
		
		try {
			param.put("vvd_cd", vvd_cd);
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOCheckMstRevVVD02RSQL(), param, velParam);

			return dbRowSet;
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
		
	}
	
	/** searchTes3PtyIF02
	 * 
	 * @param tesTmlSoHdrVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchTes3PtyIF02(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {
		log.debug("start searchTes3PtyIF02 ============================= ");
		
		DBRowSet 			dbRowSet	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
		
		try {

			param.putAll(tesTmlSoHdrVO.getColumnValues());
			velParam.putAll(tesTmlSoHdrVO.getColumnValues());
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchTes3PtyIF02RSQL(), param, velParam);

			return dbRowSet;
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
		
	}
	
	/**
	 * searchTes3PtyIF 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param voList List<TesTmlSoHdrVO> 
	 * @throws DAOException
	 */
	public void searchTes3PtyIF(List<TesTmlSoHdrVO> voList) throws DAOException {
		log.debug("start searchTes3PtyIF =============================");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchTes3PtyIF01RSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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

	}

//	/**
//	 * CARIssueTransferSlipManage의 데이타 모델에 해당되는 값을 불러온다.<br>
//	 *
//	 * @param model 데이타 모델
//	 * @return DBRowSet
//	 * @throws DAOException
//	 */
//	public void createLEA(String csr_no) throws DAOException {
//		// Connection Interface
//		Connection con = null;
//		// 정적파싱을 지원하는 SQL Statement
//		PreparedStatement ps = null;
//		PreparedStatement insertPs = null;
//		PreparedStatement updatePs = null;
//		// DB ResultSet
//		ResultSet rs = null;
//		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
//
//		StringBuffer queryStr = new StringBuffer();
//		StringBuffer querySeaStr = new StringBuffer();
//		StringBuffer queryUpdStr = new StringBuffer();
//
//		int i = 1;
//
//		queryStr.append(" INSERT INTO LEA_ACT_COST_IF                                                                                                                     \n");
//		queryStr.append("   ( EXE_YRMON, INV_SYS_ID, IF_SEQ, GL_DT, REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD,                                                \n");
//		queryStr.append("	         ACT_VVD_CD, BKG_NO, BKG_NO_SPLIT, CNTR_NO, CNTR_TPSZ_CD, COST_ACT_GRP_CD, COST_ACT_GRP_SEQ, COA_COST_SRC_CD,						  \n");
//		queryStr.append("	         LOCL_CURR_CD, LOCL_COST_AMT, USD_COST_AMT, REP_ACCT_CD, ACCT_CD, OTR_CRR_FLG, N1ST_THRP_INCL_COST_CD,								  \n");
//	    queryStr.append("	         N2ND_THRP_INCL_COST_CD, N3RD_THRP_INCL_COST_CD, CSR_NO, CSR_TP_CD, TTL_INV_KNT, INV_NO, INV_VNDR_SEQ,								  \n");
//	    queryStr.append("	         INV_CXL_FLG, INV_CXL_DT, TML_INV_TP_CD, TML_CALC_IND_CD, COP_NO, COST_ACT_GRP_TP_CD, N1ST_NOD_CD,									  \n");
//	    queryStr.append("	         N2ND_NOD_CD, N3RD_NOD_CD, N4TH_NOD_CD, ERR_VVD_APLY_FLG, ACT_COST_MAPG_CD, CRE_DT )												  \n");
//		queryStr.append(" SELECT EXE_YRMON, INV_SYS_ID, LEA_ACT_COST_IF_SEQ.NEXTVAL IF_SEQ, GL_DT, REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD,                 \n");
//		queryStr.append("        ACT_VVD_CD, BKG_NO, BKG_NO_SPLIT, CNTR_NO, CNTR_TPSZ_CD, COST_ACT_GRP_CD, COST_ACT_GRP_SEQ, LGS_COST_CD,                                 \n");
//		queryStr.append("        LOCL_CURR_CD, LOCL_COST_AMT, USD_COST_AMT, REP_ACCT_CD, ACCT_CD, OTR_CRR_FLG, N1ST_THRP_INCL_COST_CD,                                    \n");
//		queryStr.append("        N2ND_THRP_INCL_COST_CD, N3RD_THRP_INCL_COST_CD, CSR_NO, CSR_TP_CD, TTL_INV_KNT, INV_NO, VNDR_SEQ,                                        \n");
//		queryStr.append("        INV_CXL_FLG, INV_CXL_DT, TML_INV_TP_CD, TML_CALC_IND_CD, COP_NO, COST_ACT_GRP_TP_CD, N1ST_NOD_CD,                                        \n");
//		queryStr.append("        N2ND_NOD_CD, N3RD_NOD_CD, N4TH_NOD_CD, 'N' ERR_VVD_APLY_CD, ACT_COST_MAPG_CD, CRE_DT FROM (                                                    \n");
//		queryStr.append(" SELECT EXE_YRMON, INV_SYS_ID, GL_DT, REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD,                 \n");
//		queryStr.append("        ACT_VVD_CD, BKG_NO, BKG_NO_SPLIT, CNTR_NO, CNTR_TPSZ_CD, COST_ACT_GRP_CD, COST_ACT_GRP_SEQ, LGS_COST_CD,                                 \n");
//		queryStr.append("        LOCL_CURR_CD, LOCL_COST_AMT, USD_COST_AMT, REP_ACCT_CD, ACCT_CD, OTR_CRR_FLG, N1ST_THRP_INCL_COST_CD,                                    \n");
//		queryStr.append("        N2ND_THRP_INCL_COST_CD, N3RD_THRP_INCL_COST_CD, CSR_NO, CSR_TP_CD, TTL_INV_KNT, INV_NO, VNDR_SEQ,                                        \n");
//		queryStr.append("        INV_CXL_FLG, INV_CXL_DT, TML_INV_TP_CD, TML_CALC_IND_CD, COP_NO, COST_ACT_GRP_TP_CD, N1ST_NOD_CD,                                        \n");
//		queryStr.append("        N2ND_NOD_CD, N3RD_NOD_CD, N4TH_NOD_CD, ACT_COST_MAPG_CD, CRE_DT                                                     \n");
//		queryStr.append(" FROM (                                                                                                                                          \n");
//		queryStr.append(" SELECT EXE_YRMON, INV_SYS_ID, GL_DT, REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD,                                                     \n");
//		queryStr.append("        ACT_VVD_CD, BKG_NO, BKG_NO_SPLIT, CNTR_NO, CNTR_TPSZ_CD, COST_ACT_GRP_CD, COST_ACT_GRP_SEQ, LGS_COST_CD,                                 \n");
//		queryStr.append("        LOCL_CURR_CD, DECODE(LOCL_CURR_CD,'KRW',NVL(ROUND(((CSR_AMT/NVL(RATE,1))*SUM(CNTR))),0),'JPY',   --수정(20070523)                                         \n");
//		queryStr.append("        NVL(ROUND(((CSR_AMT/NVL(RATE,1))*SUM(CNTR))),0),'TWD',NVL(ROUND(((CSR_AMT/NVL(RATE,1))*SUM(CNTR))),0),NVL(ROUND(((CSR_AMT/NVL(RATE,1))*SUM(CNTR)),2),0)) LOCL_COST_AMT,   --수정(20070523)                      \n");
//		queryStr.append("        USD_COST_AMT, REP_ACCT_CD, ACCT_CD, OTR_CRR_FLG, N1ST_THRP_INCL_COST_CD, N2ND_THRP_INCL_COST_CD,                                         \n");
//		queryStr.append("        N3RD_THRP_INCL_COST_CD, CSR_NO, CSR_TP_CD, TTL_INV_KNT, INV_NO, VNDR_SEQ, 'N' INV_CXL_FLG, INV_CXL_DT,                                   \n");
//		queryStr.append("        TML_INV_TP_CD, TML_CALC_IND_CD, COP_NO, COST_ACT_GRP_TP_CD, N1ST_NOD_CD, N2ND_NOD_CD, N3RD_NOD_CD,                                       \n");
//		queryStr.append("        N4TH_NOD_CD, ACT_COST_MAPG_CD, CRE_DT                                                                                                    \n");
//		queryStr.append(" FROM (                                                                                                                                          \n");
//		queryStr.append(" SELECT EXE_YRMON, 'TES' INV_SYS_ID, GL_DT, REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD,                                               \n");
//		queryStr.append("        ACT_VVD_CD, BKG_NO, BKG_NO_SPLIT, CNTR_NO, L.CNTR_TPSZ_CD, COST_ACT_GRP_CD, COST_ACT_GRP_SEQ, LGS_COST_CD,   --수정(20070723)             \n");		
//		queryStr.append("        LOCL_CURR_CD, C.CSR_AMT, R.RATE, CNTR,                                                                                                   \n");
//		queryStr.append("        0 USD_COST_AMT, REP_ACCT_CD, ACCT_CD, OTR_CRR_FLG, N1ST_THRP_INCL_COST_CD, N2ND_THRP_INCL_COST_CD,                                       \n");
//		queryStr.append("        N3RD_THRP_INCL_COST_CD, CSR_NO, CSR_TP_CD, TTL_INV_KNT, L.INV_NO, L.VNDR_SEQ, 'N' INV_CXL_FLG, NULL INV_CXL_DT,                          \n");
//		queryStr.append("        TML_INV_TP_CD, TML_CALC_IND_CD, COP_NO, COST_ACT_GRP_TP_CD, N1ST_NOD_CD, N2ND_NOD_CD, N3RD_NOD_CD,                                       \n");
//		queryStr.append("        N4TH_NOD_CD, ACT_COST_MAPG_CD, SYSDATE CRE_DT                                                                                            \n");
//		queryStr.append(" FROM ( SELECT SUBSTR(A.GL_DT,1,6)                                        EXE_YRMON,                                                             \n");
//		queryStr.append("               A.GL_DT                                                    GL_DT,                                                                 \n");
//		queryStr.append("               NULL                                                       REV_YRMON,                                                             \n");
//		queryStr.append("               L.FINC_VSL_CD                                              VSL_CD,                                                                \n");
//		queryStr.append("               L.FINC_SKD_VOY_NO                                          SKD_VOY_NO,                                                            \n");
//		queryStr.append("               SUBSTR(L.FINC_SKD_DIR_CD,1,1)                              SKD_DIR_CD,                                                            \n");
//		queryStr.append("               SUBSTR(L.FINC_SKD_DIR_CD,2,1)                              REV_DIR_CD,                                                            \n");
//		queryStr.append("               L.VSL_CD||L.SKD_VOY_NO||L.SKD_DIR_CD                       ACT_VVD_CD,                                                            \n");
//		queryStr.append("               L.BKG_NO                                                   BKG_NO,                                                                \n");
//		queryStr.append("               L.BKG_NO_SPLIT                                             BKG_NO_SPLIT,                                                          \n");
//		queryStr.append("               L.CNTR_NO                                                  CNTR_NO,                                                               \n");
//		queryStr.append("               L.CNTR_TPSZ_CD                                             CNTR_TPSZ_CD,                                                          \n");
//		queryStr.append("               NULL                                                       COST_ACT_GRP_CD,                                                       \n");
//		queryStr.append("               NULL                                                       COST_ACT_GRP_SEQ,                                                      \n");
//		queryStr.append("               D.LGS_COST_CD                                              LGS_COST_CD,                                                           \n");
//		queryStr.append("               H.CURR_CD                                                  LOCL_CURR_CD,                                                          \n");
//		queryStr.append("               NULL                                                       REP_ACCT_CD,                                                           \n");
//		queryStr.append("               D.ACCT_CD                                                  ACCT_CD,                                                               \n");
//		queryStr.append("               DECODE(REPLACE(TRIM(D.TML_CRR_CD),' ',''),NULL,'N','SML','N','Y')    OTR_CRR_FLG,     -- 수정(20070510)                            \n");
//		queryStr.append("                           ( SELECT DECODE(D.LGS_COST_CD,'TPNDFL',                                                                            \n");
//		queryStr.append("                                      DECODE(T.THRP_LGS_COST_CD,'SVLDFL','SVLDFL'),'TPNDTS',                                                  \n");
//		queryStr.append("                                      DECODE(T.THRP_LGS_COST_CD,'SVLDTS','SVLDTS'))                                                           \n");
//		queryStr.append("                             FROM   TES_TML_AGMT_THRP_COST T                                                                                  \n");
//		queryStr.append("                             WHERE  T.TML_AGMT_OFC_CTY_CD = D.TML_AGMT_OFC_CTY_CD                                                             \n");
//		queryStr.append("                             AND    T.TML_AGMT_SEQ        = D.TML_AGMT_SEQ                                                                    \n");
//		queryStr.append("                             AND    T.TML_AGMT_VER_NO     = D.TML_AGMT_VER_NO                                                                 \n");
//		queryStr.append("                             AND    T.LGS_COST_CD         IN ('TPNDFL','TPNDTS')                                                              \n");
//		queryStr.append("                             AND    T.THRP_LGS_COST_CD    IN ('SVLDFL','SVLDTS')                                                              \n");
//		queryStr.append("                             AND    DECODE(D.LGS_COST_CD,'TPNDFL',                                                                                 \n");
//		queryStr.append("                                      DECODE(T.THRP_LGS_COST_CD,'SVLDFL','SVLDFL'),'TPNDTS',                                                  \n");
//		queryStr.append("                                      DECODE(T.THRP_LGS_COST_CD,'SVLDTS','SVLDTS')) IS NOT NULL                                               \n");
//		queryStr.append("                             AND    ROWNUM = 1 )                                      N1ST_THRP_INCL_COST_CD,                                 \n");
//		queryStr.append("                           ( SELECT DECODE(D.LGS_COST_CD,'TPNDFL',                                                                            \n");
//		queryStr.append("                                      DECODE(T.THRP_LGS_COST_CD,'TMNDFL','TMNDFL'),'TPNDTS',                                                  \n");
//		queryStr.append("                                      DECODE(T.THRP_LGS_COST_CD,'TMNDTS','TMNDTS'))                                                           \n");
//		queryStr.append("                             FROM   TES_TML_AGMT_THRP_COST T                                                                                  \n");
//		queryStr.append("                             WHERE  T.TML_AGMT_OFC_CTY_CD = D.TML_AGMT_OFC_CTY_CD                                                             \n");
//		queryStr.append("                             AND    T.TML_AGMT_SEQ        = D.TML_AGMT_SEQ                                                                    \n");
//		queryStr.append("                             AND    T.TML_AGMT_VER_NO     = D.TML_AGMT_VER_NO                                                                 \n");
//		queryStr.append("                             AND    T.LGS_COST_CD         IN ('TPNDFL','TPNDTS')                                                              \n");
//		queryStr.append("                             AND    T.THRP_LGS_COST_CD    IN ('TMNDFL','TMNDTS')                                                              \n");
//		queryStr.append("                             AND    DECODE(D.LGS_COST_CD,'TPNDFL',                                                                            \n");
//		queryStr.append("                                      DECODE(T.THRP_LGS_COST_CD,'TMNDFL','TMNDFL'),'TPNDTS',                                                  \n");
//		queryStr.append("                                      DECODE(T.THRP_LGS_COST_CD,'TMNDTS','TMNDTS')) IS NOT NULL                                               \n");
//		queryStr.append("                             AND    ROWNUM = 1 )                                      N2ND_THRP_INCL_COST_CD,                                 \n");
//		queryStr.append("                           ( SELECT DECODE(D.LGS_COST_CD,'TPNDFL',                                                                            \n");
//		queryStr.append("                                      DECODE(T.THRP_LGS_COST_CD,'SVSSFL','SVSSFL'),'TPNDTS',                                                  \n");
//		queryStr.append("                                      DECODE(T.THRP_LGS_COST_CD,'SVSSTS','SVSSTS'))                                                           \n");
//		queryStr.append("                             FROM   TES_TML_AGMT_THRP_COST T                                                                                  \n");
//		queryStr.append("                             WHERE  T.TML_AGMT_OFC_CTY_CD = D.TML_AGMT_OFC_CTY_CD                                                             \n");
//		queryStr.append("                             AND    T.TML_AGMT_SEQ        = D.TML_AGMT_SEQ                                                                    \n");
//		queryStr.append("                             AND    T.TML_AGMT_VER_NO     = D.TML_AGMT_VER_NO                                                                 \n");
//		queryStr.append("                             AND    T.LGS_COST_CD         = 'TPNDFL'                                                                          \n");
//		queryStr.append("                             AND    T.THRP_LGS_COST_CD IN ('SVSSFL','SVSSTS')                                                                 \n");
//		queryStr.append("                             AND    DECODE(D.LGS_COST_CD,'TPNDFL',                                                                            \n");
//		queryStr.append("                                      DECODE(T.THRP_LGS_COST_CD,'SVSSFL','SVSSFL'),'TPNDTS',                                                  \n");
//		queryStr.append("                                      DECODE(T.THRP_LGS_COST_CD,'SVSSTS','SVSSTS')) IS NOT NULL                                               \n");
//		queryStr.append("                             AND    ROWNUM =1 )                                       N3RD_THRP_INCL_COST_CD,                                 \n");
//		queryStr.append("               H.CSR_NO                                                   CSR_NO,                                                                \n");
//		queryStr.append("               A.CSR_TP_CD                                                CSR_TP_CD,                                                             \n");
//		queryStr.append("               DECODE(D.LGS_COST_CD,'SVLDTS',2,'TPNDTS',2,'TMNDTS',1,'TMFDFL',                                                                   \n");
//		queryStr.append("                 DECODE(H.TML_CALC_IND_CD,'TP',1,'SP',2),1)               TTL_INV_KNT,                                                           \n");
//		queryStr.append("               H.INV_NO                                                   INV_NO,                                                                \n");
//		queryStr.append("               H.VNDR_SEQ                                                 VNDR_SEQ,                                                              \n");
//		queryStr.append("               H.TML_INV_TP_CD                                            TML_INV_TP_CD,                                                         \n");
//		queryStr.append("               H.TML_CALC_IND_CD                                          TML_CALC_IND_CD,                                                       \n");
//		queryStr.append("               NULL                                                       COP_NO,                                                                \n");
//		queryStr.append("               'N'                                                        COST_ACT_GRP_TP_CD,                                                    \n");
//		queryStr.append("               H.YD_CD                                                    N1ST_NOD_CD,                                                           \n");
//		queryStr.append("               H.YD_CD                                                    N2ND_NOD_CD,                                                           \n");
//		queryStr.append("               H.YD_CD                                                    N3RD_NOD_CD,                                                           \n");
//		queryStr.append("               H.YD_CD                                                    N4TH_NOD_CD,                                                           \n");
//		queryStr.append("               'N'                                                        ACT_COST_MAPG_CD,                                                      \n");
//		queryStr.append("               SYSDATE                       							   CRE_DT,                                                                \n");
//		queryStr.append("               COUNT(L.CNTR_NO)                                           CNTR                                                                   \n");
//		queryStr.append("        FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_TML_SO_CNTR_LIST L, AP_INV_HDR A                                                          \n");
//		queryStr.append("        WHERE  H.CSR_NO = ?                                                                                                  \n");
//		queryStr.append("        AND    H.TML_INV_STS_CD = 'P'                                                                                                            \n");
//		queryStr.append("        AND    NVL(H.DELT_FLG,'N') <> 'Y'                                                                                                        \n");
//		queryStr.append("        AND    H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD                                                                                         \n");
//		queryStr.append("        AND    H.TML_SO_SEQ        = D.TML_SO_SEQ                                                                                                \n");
//		queryStr.append("        AND    H.TML_SO_OFC_CTY_CD = L.TML_SO_OFC_CTY_CD                                                                                         \n");
//		queryStr.append("        AND    H.TML_SO_SEQ        = L.TML_SO_SEQ                                                                                                \n");
//		queryStr.append("        AND    D.CALC_COST_GRP_CD  <> 'SP'                                                                                                       \n");
//		queryStr.append("        AND    D.CALC_TP_CD        = 'A'                                                                                                         \n");
//		queryStr.append("        AND    NVL(D.INV_AMT,0)    <> 0                  --추가(20070523)                                                                          \n");
//		queryStr.append("        AND    L.VRFY_RSLT_IND_CD  = 'CO'                                                                                                        \n");
//		queryStr.append("        AND    NVL(L.CNTR_TPSZ_CD,'N') 	= NVL(D.CNTR_TPSZ_CD,'N')  	                                                                            \n");
//		queryStr.append("        AND    DECODE('TM',NVL(L.IO_BND_CD,'N'),'ON',NVL(L.IO_BND_CD,'N'),'OF','N','ST','N')                                                     \n");
//		queryStr.append("               = DECODE('TM',NVL(D.IO_BND_CD,'N'),'ON',NVL(D.IO_BND_CD,'N'),'OF','N','ST','N')    	                                              \n");
//		queryStr.append("        AND    DECODE('TM',NVL(L.IOC_CD,'N'),'ON',NVL(L.IOC_CD,'N'),'OF','N','ST','N')                                                           \n");
//		queryStr.append("               = DECODE('TM',NVL(D.IOC_CD,'N'),'ON',NVL(D.IOC_CD,'N'),'OF','N','ST','N')   	                                                    \n");
//		queryStr.append("        AND    DECODE('TM',NVL(L.LANE_CD,'N'),'ON',NVL(L.LANE_CD,'N'),'OF','N','ST','N')                                                         \n");
//		queryStr.append("               = DECODE('TM',NVL(D.LANE_CD,'N'),'ON',NVL(D.LANE_CD,'N'),'OF','N','ST','N')                                                       \n");
////		queryStr.append("        AND    NVL(DECODE(TO_CHAR(L.WRK_DT,'DY'),'SAT','SA','SUN','SU','HOL','HO','WD'),'N')                                                     \n");
////		queryStr.append("               = NVL(DECODE(TO_CHAR(TO_DATE(D.WRK_DT,'YYYYMMDD'),'DY'),'SAT','SA','SUN','SU','HOL','HO','WD'),'N')                               \n");
//		queryStr.append("        AND    DECODE(H.TML_INV_TP_CD,'TM',                                                                                                      \n");
//		queryStr.append("                 DECODE(L.BB_CGO_FLG,'Y','BB',DECODE(L.LOCL_TS_IND_CD,'T','TS',DECODE(L.CNTR_STY_CD,'F','FL','MT'))),                            \n");
//		queryStr.append("                 'ON',DECODE(CNTR_STY_CD,'F','F','M'),'OF',DECODE(L.CNTR_STY_CD,'F','FL','MT'),'ST',DECODE(L.LOCL_TS_IND_CD,'T','TS',DECODE(L.CNTR_STY_CD,'F','FL','MT')))         \n");
//		queryStr.append("               = DECODE(H.TML_INV_TP_CD,'TM',SUBSTR(D.LGS_COST_CD,5,2),'ON',SUBSTR('TMNDRF',6,1),'OF',SUBSTR(D.LGS_COST_CD,5,2),                 \n");
//		queryStr.append("                 'ST',SUBSTR(D.LGS_COST_CD,5,2))                                                                                                 \n");
//		queryStr.append("        AND    H.CSR_NO = A.CSR_NO                                                                                                               \n");
//		queryStr.append("        GROUP BY A.GL_DT, L.FINC_VSL_CD, L.FINC_SKD_VOY_NO, L.FINC_SKD_DIR_CD, L.VSL_CD||L.SKD_VOY_NO||L.SKD_DIR_CD,                             \n");
//		queryStr.append("                 L.BKG_NO, L.BKG_NO_SPLIT, L.CNTR_NO, L.CNTR_TPSZ_CD, D.LGS_COST_CD, H.CURR_CD, D.ACCT_CD,                                       \n");
//		queryStr.append("                 DECODE(REPLACE(TRIM(D.TML_CRR_CD),' ',''),NULL,'N','SML','N','Y'), H.CSR_NO, A.CSR_TP_CD, H.INV_NO, H.VNDR_SEQ,  -- 수정(20070510)        \n");
//		queryStr.append("                 H.TML_INV_TP_CD, H.TML_CALC_IND_CD, H.YD_CD, H.VAT_AMT, D.TML_AGMT_OFC_CTY_CD, D.TML_AGMT_SEQ, D.TML_AGMT_VER_NO ) L,           \n");
//		queryStr.append("        ( SELECT  C.INV_NO, C.VNDR_SEQ, D.CNTR_TPSZ_CD, SUM(D.INV_AMT) CSR_AMT    --수정(20070723)                                                \n");
//		queryStr.append("          FROM   TES_TML_SO_HDR C, TES_TML_SO_DTL D                                                                                              \n");
//		queryStr.append("          WHERE  C.CSR_NO = ?                                                                                                \n");
//		queryStr.append("          AND    C.TML_INV_STS_CD = 'P'                                                                                                          \n");
//		queryStr.append("          AND    C.INV_NO            = INV_NO                                                                                                    \n");
//		queryStr.append("          AND    C.VNDR_SEQ          = VNDR_SEQ                                                                                                  \n");
//		queryStr.append("          AND    NVL(C.DELT_FLG,'N') <> 'Y'                                                                                                      \n");
//		queryStr.append("          AND    C.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD                                                                                       \n");
//		queryStr.append("          AND    C.TML_SO_SEQ        = D.TML_SO_SEQ                                                                                              \n");
//		queryStr.append("          AND    D.CALC_COST_GRP_CD  <> 'SP'                                                                                                     \n");
//		queryStr.append("          AND    D.CALC_TP_CD        = 'A'                                                                                                       \n");
//		queryStr.append("          AND    NVL(D.INV_AMT,0)    <> 0              --추가(20070523)                                                                           \n");
//		queryStr.append("          GROUP BY C.INV_NO, C.VNDR_SEQ, D.CNTR_TPSZ_CD ) C,                --수정(20070723)                                                      \n");
//		queryStr.append("        ( SELECT INV_NO, VNDR_SEQ, D.CNTR_TPSZ_CD, COUNT(L.CNTR_NO) RATE    --수정(20070723)                                                      \n");		
//		queryStr.append("          FROM   TES_TML_SO_HDR C, TES_TML_SO_DTL D, TES_TML_SO_CNTR_LIST L                                                                      \n");
//		queryStr.append("          WHERE  C.CSR_NO = ?                                                                                                \n");
//		queryStr.append("          AND    C.TML_INV_STS_CD = 'P'                                                                                                          \n");
//		queryStr.append("          AND    C.INV_NO            = INV_NO                                                                                                    \n");
//		queryStr.append("          AND    C.VNDR_SEQ          = VNDR_SEQ                                                                                                  \n");
//		queryStr.append("          AND    NVL(C.DELT_FLG,'N') <> 'Y'                                                                                                      \n");
//		queryStr.append("          AND    C.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD                                                                                       \n");
//		queryStr.append("          AND    C.TML_SO_SEQ        = D.TML_SO_SEQ                                                                                              \n");
//		queryStr.append("          AND    C.TML_SO_OFC_CTY_CD = L.TML_SO_OFC_CTY_CD                                                                                       \n");
//		queryStr.append("          AND    C.TML_SO_SEQ        = L.TML_SO_SEQ                                                                                              \n");
//		queryStr.append("          AND    D.CALC_COST_GRP_CD  <> 'SP'                                                                                                     \n");
//		queryStr.append("          AND    D.CALC_TP_CD        = 'A'                                                                                                       \n");
//		queryStr.append("          AND    NVL(D.INV_AMT,0)    <> 0            --추가(20070523)                                                                          \n");
//		queryStr.append("          AND    L.VRFY_RSLT_IND_CD  = 'CO'                                                                                                      \n");
//		queryStr.append("          AND    NVL(L.CNTR_TPSZ_CD,'N') 	= NVL(D.CNTR_TPSZ_CD,'N')  	                                                                          \n");
//		queryStr.append("          AND    DECODE('TM',NVL(L.IO_BND_CD,'N'),'ON',NVL(L.IO_BND_CD,'N'),'OF','N','ST','N')                                                   \n");
//		queryStr.append("                 = DECODE('TM',NVL(D.IO_BND_CD,'N'),'ON',NVL(D.IO_BND_CD,'N'),'OF','N','ST','N')    	                                            \n");
//		queryStr.append("          AND    DECODE('TM',NVL(L.IOC_CD,'N'),'ON',NVL(L.IOC_CD,'N'),'OF','N','ST','N')                                                         \n");
//		queryStr.append("                 = DECODE('TM',NVL(D.IOC_CD,'N'),'ON',NVL(D.IOC_CD,'N'),'OF','N','ST','N')   	                                                  \n");
//		queryStr.append("          AND    DECODE('TM',NVL(L.LANE_CD,'N'),'ON',NVL(L.LANE_CD,'N'),'OF','N','ST','N')                                                       \n");
//		queryStr.append("                 = DECODE('TM',NVL(D.LANE_CD,'N'),'ON',NVL(D.LANE_CD,'N'),'OF','N','ST','N')                                                     \n");
////		queryStr.append("          AND    NVL(DECODE(TO_CHAR(L.WRK_DT,'DY'),'SAT','SA','SUN','SU','HOL','HO','WD'),'N')                                                   \n");
////		queryStr.append("                 = NVL(DECODE(TO_CHAR(TO_DATE(D.WRK_DT,'YYYYMMDD'),'DY'),'SAT','SA','SUN','SU','HOL','HO','WD'),'N')                             \n");
//		queryStr.append("          AND    DECODE(C.TML_INV_TP_CD,'TM',                                                                                                    \n");
//		queryStr.append("                   DECODE(L.BB_CGO_FLG,'Y','BB',DECODE(L.LOCL_TS_IND_CD,'T','TS',DECODE(L.CNTR_STY_CD,'F','FL','MT'))),                          \n");
//		queryStr.append("                   'ON',DECODE(CNTR_STY_CD,'F','F','M'),'OF',DECODE(L.CNTR_STY_CD,'F','FL','MT'),'ST',DECODE(L.LOCL_TS_IND_CD,'T','TS',DECODE(L.CNTR_STY_CD,'F','FL','MT')))       \n");
//		queryStr.append("                 = DECODE(C.TML_INV_TP_CD,'TM',SUBSTR(D.LGS_COST_CD,5,2),'ON',SUBSTR('TMNDRF',6,1),'OF',SUBSTR(D.LGS_COST_CD,5,2),               \n");
//		queryStr.append("                     'ST',SUBSTR(D.LGS_COST_CD,5,2))                                                                                             \n");
//		queryStr.append("          GROUP BY INV_NO, VNDR_SEQ, D.CNTR_TPSZ_CD ) R    --수정(20070723)                                                                       \n");		
//		queryStr.append(" WHERE L.INV_NO = C.INV_NO(+)                                                                                                                    \n");
//		queryStr.append(" AND   L.VNDR_SEQ = C.VNDR_SEQ(+)                                                                                                                \n");
//		queryStr.append(" AND   L.CNTR_TPSZ_CD = C.CNTR_TPSZ_CD(+)     --수정(20070723)                                                                                   \n");
//		queryStr.append(" AND   L.INV_NO = R.INV_NO(+)                                                                                                                    \n");
//		queryStr.append(" AND   L.VNDR_SEQ = R.VNDR_SEQ(+)                                                                                                                \n");
//		queryStr.append(" AND   L.CNTR_TPSZ_CD = R.CNTR_TPSZ_CD(+) )   --수정(20070723)                                                                                    \n");
//		queryStr.append(" WHERE EXE_YRMON IS NOT NULL                                                                                                                     \n");
//		queryStr.append(" AND   VSL_CD IS NOT NULL                                                                                                                        \n");
//		queryStr.append(" GROUP BY EXE_YRMON, GL_DT, REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD,                                                               \n");
//		queryStr.append("        ACT_VVD_CD, BKG_NO, BKG_NO_SPLIT, CNTR_NO, CNTR_TPSZ_CD, COST_ACT_GRP_CD, COST_ACT_GRP_SEQ, LGS_COST_CD,                                 \n");
//		queryStr.append("        CSR_AMT, RATE, LOCL_CURR_CD, REP_ACCT_CD, ACCT_CD, OTR_CRR_FLG, N1ST_THRP_INCL_COST_CD, N2ND_THRP_INCL_COST_CD,                          \n");
//		queryStr.append("        N3RD_THRP_INCL_COST_CD, CSR_NO, CSR_TP_CD, TTL_INV_KNT, INV_NO, VNDR_SEQ, TML_INV_TP_CD, TML_CALC_IND_CD,                                \n");
//		queryStr.append("        COP_NO, COST_ACT_GRP_TP_CD, N1ST_NOD_CD, N2ND_NOD_CD, N3RD_NOD_CD, N4TH_NOD_CD, ACT_COST_MAPG_CD                                         \n");
//		queryStr.append(" UNION ALL                                                                                                                                       \n");
//		queryStr.append(" SELECT DISTINCT                                                                                                                                 \n");
//		queryStr.append("        SUBSTR(A.GL_DT,1,6)                                        EXE_YRMON,                                                                    \n");
//		queryStr.append("        'TES'                                                      INV_SYS_ID,                                                                   \n");
//		queryStr.append("        A.GL_DT                                                    GL_DT,                                                                        \n");
//		queryStr.append("        NULL                                                       REV_YRMON,                                                                    \n");
//		queryStr.append("        D.FINC_VSL_CD                                VSL_CD,                                                                                     \n");
//		queryStr.append("        D.FINC_SKD_VOY_NO                                          SKD_VOY_NO,                                                                   \n");
//		queryStr.append("        SUBSTR(D.FINC_SKD_DIR_CD,1,1)                              SKD_DIR_CD,                                                                   \n");
//		queryStr.append("        SUBSTR(D.FINC_SKD_DIR_CD,2,1)                              REV_DIR_CD,                                                                   \n");
//		queryStr.append("        DECODE(H.TML_INV_TP_CD,'TM',                                                                                                             \n");
//		queryStr.append("          NVL(D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD,D.FINC_VSL_CD||D.FINC_SKD_VOY_NO||D.FINC_SKD_DIR_CD),                                         \n");
//		queryStr.append("          D.FINC_VSL_CD||D.FINC_SKD_VOY_NO||D.FINC_SKD_DIR_CD)     ACT_VVD_CD,                                                                   \n");
//		queryStr.append("        NULL                                                       BKG_NO,                                                                       \n");
//		queryStr.append("        NULL                                                       BKG_NO_SPLIT,                                                                 \n");
//		queryStr.append("        D.CNTR_NO                                                  CNTR_NO,                                                                      \n");
//		queryStr.append("        D.CNTR_TPSZ_CD                                             CNTR_TPSZ_CD,                                                                 \n");
//		queryStr.append("        NULL                                                       COST_ACT_GRP_CD,                                                              \n");
//		queryStr.append("        NULL                                                       COST_ACT_GRP_SEQ,                                                             \n");
//		queryStr.append("        D.LGS_COST_CD                                              LGS_COST_CD,                                                                  \n");
//		queryStr.append("        H.CURR_CD                                                  LOCL_CURR_CD,                                                                 \n");
//		queryStr.append("        DECODE(H.CURR_CD,'KRW',NVL(ROUND(SUM(D.INV_AMT)),0),                                                                                     \n");
//		queryStr.append("                         'JPY',NVL(ROUND(SUM(D.INV_AMT)),0),                                                                                     \n");
//		queryStr.append("                         'TWD',NVL(ROUND(SUM(D.INV_AMT)),0),                                                                                     \n");
//		queryStr.append("                               NVL(ROUND(SUM(D.INV_AMT),2),0))     LOCL_COST_AMT,                                                                \n");
//		queryStr.append("        0                                                          USD_COST_AMT,                                                                 \n");
//		queryStr.append("        NULL                                                       REP_ACCT_CD,                                                                  \n");
//		queryStr.append("        D.ACCT_CD                                                  ACCT_CD,                                                                      \n");
//		queryStr.append("        DECODE(REPLACE(TRIM(D.TML_CRR_CD),' ',''),NULL,'N','SML','N','Y')    OTR_CRR_FLG,     -- 수정(20070510)                                  \n");
//		queryStr.append("               ( SELECT DECODE(D.LGS_COST_CD,'TPNDFL',                                                                                   \n");
//		queryStr.append("                          DECODE(T.THRP_LGS_COST_CD,'SVLDFL','SVLDFL'),'TPNDTS',                                                         \n");
//		queryStr.append("                          DECODE(T.THRP_LGS_COST_CD,'SVLDTS','SVLDTS'))                                                                  \n");
//		queryStr.append("                 FROM   TES_TML_AGMT_THRP_COST T                                                                                         \n");
//		queryStr.append("                 WHERE  T.TML_AGMT_OFC_CTY_CD = D.TML_AGMT_OFC_CTY_CD                                                                    \n");
//		queryStr.append("                 AND    T.TML_AGMT_SEQ        = D.TML_AGMT_SEQ                                                                           \n");
//		queryStr.append("                 AND    T.TML_AGMT_VER_NO     = D.TML_AGMT_VER_NO                                                                        \n");
//		queryStr.append("                 AND    T.LGS_COST_CD         IN ('TPNDFL','TPNDTS')                                                                     \n");
//		queryStr.append("                 AND    T.THRP_LGS_COST_CD    IN ('SVLDFL','SVLDTS')                                                                     \n");
//		queryStr.append("                 AND    DECODE(D.LGS_COST_CD,'TPNDFL',                                                                                        \n");
//		queryStr.append("                          DECODE(T.THRP_LGS_COST_CD,'SVLDFL','SVLDFL'),'TPNDTS',                                                         \n");
//		queryStr.append("                          DECODE(T.THRP_LGS_COST_CD,'SVLDTS','SVLDTS')) IS NOT NULL                                                      \n");
//		queryStr.append("                 AND    ROWNUM = 1 )                                      N1ST_THRP_INCL_COST_CD,                                        \n");
//		queryStr.append("               ( SELECT DECODE(D.LGS_COST_CD,'TPNDFL',                                                                                   \n");
//		queryStr.append("                          DECODE(T.THRP_LGS_COST_CD,'TMNDFL','TMNDFL'),'TPNDTS',                                                         \n");
//		queryStr.append("                          DECODE(T.THRP_LGS_COST_CD,'TMNDTS','TMNDTS'))                                                                  \n");
//		queryStr.append("                 FROM   TES_TML_AGMT_THRP_COST T                                                                                         \n");
//		queryStr.append("                 WHERE  T.TML_AGMT_OFC_CTY_CD = D.TML_AGMT_OFC_CTY_CD                                                                    \n");
//		queryStr.append("                 AND    T.TML_AGMT_SEQ        = D.TML_AGMT_SEQ                                                                           \n");
//		queryStr.append("                 AND    T.TML_AGMT_VER_NO     = D.TML_AGMT_VER_NO                                                                        \n");
//		queryStr.append("                 AND    T.LGS_COST_CD         IN ('TPNDFL','TPNDTS')                                                                     \n");
//		queryStr.append("                 AND    T.THRP_LGS_COST_CD    IN ('TMNDFL','TMNDTS')                                                                     \n");
//		queryStr.append("                 AND    DECODE(D.LGS_COST_CD,'TPNDFL',                                                                                   \n");
//		queryStr.append("                          DECODE(T.THRP_LGS_COST_CD,'TMNDFL','TMNDFL'),'TPNDTS',                                                         \n");
//		queryStr.append("                          DECODE(T.THRP_LGS_COST_CD,'TMNDTS','TMNDTS')) IS NOT NULL                                                      \n");
//		queryStr.append("                 AND    ROWNUM = 1 )                                      N2ND_THRP_INCL_COST_CD,                                        \n");
//		queryStr.append("               ( SELECT DECODE(D.LGS_COST_CD,'TPNDFL',                                                                                   \n");
//		queryStr.append("                          DECODE(T.THRP_LGS_COST_CD,'SVSSFL','SVSSFL'),'TPNDTS',                                                         \n");
//		queryStr.append("                          DECODE(T.THRP_LGS_COST_CD,'SVSSTS','SVSSTS'))                                                                  \n");
//		queryStr.append("                 FROM   TES_TML_AGMT_THRP_COST T                                                                                         \n");
//		queryStr.append("                 WHERE  T.TML_AGMT_OFC_CTY_CD = D.TML_AGMT_OFC_CTY_CD                                                                    \n");
//		queryStr.append("                 AND    T.TML_AGMT_SEQ        = D.TML_AGMT_SEQ                                                                           \n");
//		queryStr.append("                 AND    T.TML_AGMT_VER_NO     = D.TML_AGMT_VER_NO                                                                        \n");
//		queryStr.append("                 AND    T.LGS_COST_CD         = 'TPNDFL'                                                                                 \n");
//		queryStr.append("                 AND    T.THRP_LGS_COST_CD IN ('SVSSFL','SVSSTS')                                                                        \n");
//		queryStr.append("                 AND    DECODE(D.LGS_COST_CD,'TPNDFL',                                                                                   \n");
//		queryStr.append("                          DECODE(T.THRP_LGS_COST_CD,'SVSSFL','SVSSFL'),'TPNDTS',                                                         \n");
//		queryStr.append("                          DECODE(T.THRP_LGS_COST_CD,'SVSSTS','SVSSTS')) IS NOT NULL                                                      \n");
//		queryStr.append("                 AND    ROWNUM =1 )                                       N3RD_THRP_INCL_COST_CD,                                        \n");
//		queryStr.append("        H.CSR_NO                                                   CSR_NO,                                                                       \n");
//		queryStr.append("        A.CSR_TP_CD                                                CSR_TP_CD,                                                                    \n");
//		queryStr.append("        DECODE(D.LGS_COST_CD,'SVLDTS',2,'TPNDTS',2,'TMNDTS',1,'TMFDFL',                                                                          \n");
//		queryStr.append("          DECODE(H.TML_CALC_IND_CD,'TP',1,'SP',2),1)               TTL_INV_KNT,                                                                  \n");
//		queryStr.append("        H.INV_NO                                                   INV_NO,                                                                       \n");
//		queryStr.append("        H.VNDR_SEQ                                                 VNDR_SEQ,                                                                     \n");
//		queryStr.append("        'N'                                                        INV_CXL_FLG,                                                                  \n");
//		queryStr.append("        NULL                                                       INV_CXL_DT,                                                                   \n");
//		queryStr.append("        H.TML_INV_TP_CD                                            TML_INV_TP_CD,                                                                \n");
//		queryStr.append("        H.TML_CALC_IND_CD                                          TML_CALC_IND_CD,                                                              \n");
//		queryStr.append("        NULL                                                       COP_NO,                                                                       \n");
//		queryStr.append("        'N'                                                        COST_ACT_GRP_TP_CD,                                                           \n");
//		queryStr.append("        H.YD_CD                                                    N1ST_NOD_CD,                                                                  \n");
//		queryStr.append("        H.YD_CD                                                    N2ND_NOD_CD,                                                                  \n");
//		queryStr.append("        H.YD_CD                                                    N3RD_NOD_CD,                                                                  \n");
//		queryStr.append("        H.YD_CD                                                    N4TH_NOD_CD,                                                                  \n");
//		queryStr.append("        'N'                                                        ACT_COST_MAPG_CD,                                                             \n");
//		queryStr.append("        SYSDATE                       								CRE_DT                                                                        \n");
//		queryStr.append(" FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D, AP_INV_HDR A                                                                                         \n");
//		queryStr.append(" WHERE  H.CSR_NO = ?                                                                                                         					  \n");
//		queryStr.append(" AND    H.TML_INV_STS_CD = 'P'                                                                                                                   \n");
//		queryStr.append(" AND    NVL(H.DELT_FLG,'N')  <> 'Y'                                                                                                              \n");
//		queryStr.append(" AND    H.TML_SO_OFC_CTY_CD  = D.TML_SO_OFC_CTY_CD(+)                                                                                            \n");
//		queryStr.append(" AND    H.TML_SO_SEQ         = D.TML_SO_SEQ(+)                                                                                                   \n");
//		queryStr.append(" AND    ( D.CALC_COST_GRP_CD = 'SP'                                                                                                              \n");
//		queryStr.append(" OR       D.CALC_TP_CD       = 'M' )                                                                                                             \n");
//		queryStr.append(" AND    NVL(D.INV_AMT,0)      <> 0                 --추가(20070523)                                                                               \n");
//		queryStr.append(" AND    H.CSR_NO = A.CSR_NO                                                                                                                      \n");
//		queryStr.append(" GROUP BY A.GL_DT, D.FINC_VSL_CD, D.FINC_SKD_VOY_NO, D.FINC_SKD_DIR_CD, DECODE(H.TML_INV_TP_CD,'TM',                                             \n");
//		queryStr.append("          NVL(D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD,D.FINC_VSL_CD||D.FINC_SKD_VOY_NO||D.FINC_SKD_DIR_CD),                                         \n");
//		queryStr.append("          D.FINC_VSL_CD||D.FINC_SKD_VOY_NO||D.FINC_SKD_DIR_CD),                                                                                  \n");
//		queryStr.append("          NVL(D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD,D.FINC_VSL_CD||D.FINC_SKD_VOY_NO||D.FINC_SKD_DIR_CD),                                         \n");
//		queryStr.append("          D.CNTR_NO, D.CNTR_TPSZ_CD, D.LGS_COST_CD, H.CURR_CD, D.ACCT_CD,                                                                        \n");
//		queryStr.append("          DECODE(REPLACE(TRIM(D.TML_CRR_CD),' ',''),NULL,'N','SML','N','Y'),         -- 수정(20070510)                                           \n");
//		queryStr.append("          H.CSR_NO, A.CSR_TP_CD, H.TML_CALC_IND_CD, H.INV_OFC_CD, H.INV_NO, H.VNDR_SEQ, H.TML_INV_TP_CD, H.YD_CD,                                \n");
//		queryStr.append("          D.TML_AGMT_OFC_CTY_CD, D.TML_AGMT_SEQ, D.TML_AGMT_VER_NO )                                                                             \n");
//		queryStr.append(" ORDER BY CSR_NO, INV_NO, VNDR_SEQ  )                                                                                                            \n");
//
//		// 아래와 같이 완전 변경합니다. 
////		querySeaStr.append(" SELECT INV_NO, VNDR_SEQ, GAP                                                                       \n");
////		querySeaStr.append(" FROM ( SELECT H.INV_NO, H.VNDR_SEQ, H.TTL_INV_AMT - ( SELECT SUM(L.LOCL_COST_AMT)                  \n");
////		querySeaStr.append("                                                       FROM   LEA_ACT_COST_IF L                     \n");
////		querySeaStr.append("                                                       WHERE  H.INV_NO     = L.INV_NO               \n");
////		querySeaStr.append("                                                       AND    H.VNDR_SEQ   = L.INV_VNDR_SEQ ) GAP   \n");
////		querySeaStr.append("        FROM   TES_TML_SO_HDR H                                                                     \n");
////		querySeaStr.append("        WHERE  H.CSR_NO = ? AND NVL(H.DELT_FLG,'N') <> 'Y' )                                                                       \n");
////		querySeaStr.append(" WHERE  GAP <> 0                                                                                    \n");
//
//		querySeaStr.append(" SELECT INV_NO, VNDR_SEQ, LGS_COST_CD, CNTR_TPSZ_CD, GAP											\n");
//		querySeaStr.append(" FROM ( SELECT A.INV_NO, A.VNDR_SEQ, A.LGS_COST_CD, A.CNTR_TPSZ_CD, S.CSR_AMT, A.CSR_AMT, NVL(S.CSR_AMT,0) - NVL(A.CSR_AMT,0) GAP           \n");
//		querySeaStr.append("        FROM   ( SELECT INV_NO, INV_VNDR_SEQ VNDR_SEQ, COA_COST_SRC_CD LGS_COST_CD, CNTR_TPSZ_CD, SUM(LOCL_COST_AMT) CSR_AMT                \n");
//		querySeaStr.append("                 FROM   LEA_ACT_COST_IF                                                                                                     \n");
//		querySeaStr.append("                 WHERE  CSR_NO = ?                                                                                                          \n");
//		querySeaStr.append("                 AND    INV_SYS_ID = 'TES'                                                                                                  \n");
//		querySeaStr.append("                 AND    NVL(LOCL_COST_AMT,0) <> 0                                                                                           \n");
//		querySeaStr.append("                 GROUP BY INV_NO, INV_VNDR_SEQ, COA_COST_SRC_CD, CNTR_TPSZ_CD ) A,                                                          \n");
//		querySeaStr.append("               ( SELECT H.INV_NO, H.VNDR_SEQ, D.LGS_COST_CD, D.CNTR_TPSZ_CD, SUM(D.INV_AMT) CSR_AMT                                         \n");
//		querySeaStr.append("                 FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D                                                                                  \n");
//		querySeaStr.append("                 WHERE  H.CSR_NO = ?                                                                                                        \n");
//		querySeaStr.append("                 AND    NVL(H.DELT_FLG,'N')   <> 'Y'                                                                                        \n");
//		querySeaStr.append("                 AND    H.TML_SO_OFC_CTY_CD   = D.TML_SO_OFC_CTY_CD                                                                         \n");
//		querySeaStr.append("                 AND    H.TML_SO_SEQ          = D.TML_SO_SEQ                                                                                \n");
//		querySeaStr.append("                 AND    NVL(D.INV_AMT,0)      <> 0                                                                                          \n");
//		querySeaStr.append("                 GROUP BY H.INV_NO, H.VNDR_SEQ, D.LGS_COST_CD, D.CNTR_TPSZ_CD ) S                                                           \n");
//		querySeaStr.append("        WHERE A.INV_NO       = S.INV_NO                                                                                                     \n");
//		querySeaStr.append("        AND   A.VNDR_SEQ     = S.VNDR_SEQ                                                                                                   \n");
//		querySeaStr.append("        AND   A.LGS_COST_CD  = S.LGS_COST_CD                                                                                                \n");
//		querySeaStr.append("        AND   A.CNTR_TPSZ_CD = S.CNTR_TPSZ_CD )                                                                                             \n");
//		querySeaStr.append(" WHERE NVL(GAP,0) <> 0                                                                                                                      \n");		
//		
//		queryUpdStr.append(" UPDATE LEA_ACT_COST_IF                                                                                                \n");
//		queryUpdStr.append(" SET    LOCL_COST_AMT = LOCL_COST_AMT + TO_NUMBER(?)                                                                   \n");
//		queryUpdStr.append(" WHERE  INV_NO       = ?                                                                                               \n");
//		queryUpdStr.append(" AND    INV_VNDR_SEQ = ?                                                                                               \n");
//		queryUpdStr.append(" AND    COA_COST_SRC_CD = ?                                                                                            \n");
//		queryUpdStr.append(" AND    NVL(CNTR_TPSZ_CD,'N') = NVL(?,'N')                                                                             \n");
//		queryUpdStr.append(" AND    ( EXE_YRMON, INV_SYS_ID, IF_SEQ, LOCL_COST_AMT ) = ( SELECT EXE_YRMON, INV_SYS_ID, IF_SEQ, MIN(LOCL_COST_AMT)  \n");
//		queryUpdStr.append("                                                             FROM   LEA_ACT_COST_IF                                    \n");
//		queryUpdStr.append("                                                             WHERE  INV_NO       = ?                                   \n");
//		queryUpdStr.append("                                                             AND    INV_VNDR_SEQ = ?                                   \n");
//		queryUpdStr.append("                                                             AND    COA_COST_SRC_CD = ?                                \n");
//		queryUpdStr.append("                                                             AND    NVL(CNTR_TPSZ_CD,'N') = NVL(?,'N')                 \n");
//		queryUpdStr.append("                                                             AND    INV_SYS_ID   = 'TES'                               \n");
//		queryUpdStr.append("                                                             AND    ROWNUM       = 1                                   \n");
//		queryUpdStr.append("                                                             GROUP BY EXE_YRMON, INV_SYS_ID, IF_SEQ )                  \n");
//
//		try {
//			con = getConnection();
//
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				insertPs = new LoggableStatement(con, queryStr.toString());
//				ps = new LoggableStatement(con, querySeaStr.toString());
//				updatePs = new LoggableStatement(con, queryUpdStr.toString());
//			} else {
//				insertPs = con.prepareStatement(queryStr.toString());
//				ps = con.prepareStatement(querySeaStr.toString());
//				updatePs = con.prepareStatement(queryUpdStr.toString());
//			}
//
//			i=1;
//			insertPs.setString(i++, csr_no);
//			insertPs.setString(i++, csr_no);
//			insertPs.setString(i++, csr_no);
//			insertPs.setString(i++, csr_no);
//
//			insertPs.executeUpdate();
//
//			i=1;
//			ps.setString(i++, csr_no);
//			ps.setString(i++, csr_no);
//			
//			rs = ps.executeQuery();
//
//            if (rs != null) {
//            	while(rs.next()){
//            		i=1;
//            		updatePs.setString(i++, rs.getString("GAP"));
//            		updatePs.setString(i++, rs.getString("INV_NO"));
//            		updatePs.setString(i++, rs.getString("VNDR_SEQ"));
//            		updatePs.setString(i++, rs.getString("LGS_COST_CD"));
//            		updatePs.setString(i++, rs.getString("CNTR_TPSZ_CD"));
//            		updatePs.setString(i++, rs.getString("INV_NO"));
//            		updatePs.setString(i++, rs.getString("VNDR_SEQ"));
//            		updatePs.setString(i++, rs.getString("LGS_COST_CD"));
//            		updatePs.setString(i++, rs.getString("CNTR_TPSZ_CD"));
//            		updatePs.addBatch();
//            	}
//            }
//
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				log.info("\n SQL :" + ((LoggableStatement)insertPs).getQueryString());
//				log.info("\n SQL :" + ((LoggableStatement)ps).getQueryString());
//				log.info("\n SQL :" + ((LoggableStatement)updatePs).getQueryString());
//			} else {
//				log.info("\n SQL :" + queryStr );
//				log.info("\n SQL :" + querySeaStr );
//				log.info("\n SQL :" + queryUpdStr );
//			}
//			updatePs.executeBatch();
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
//		} finally {
//			closeResultSet(rs);
//			closeStatement(insertPs);
//			closeStatement(ps);
//			closeStatement(updatePs);
//			closeConnection(con);
//		}
//	}

//	/**
//	 * CARIssueTransferSlipManage의 데이타 모델에 해당되는 값을 불러온다.<br>
//	 *
//	 * @param model 데이타 모델
//	 * @return DBRowSet
//	 * @throws DAOException
//	 */
//	public void createLEA2(String csr_no) throws DAOException {
//
//		Connection con = null;
//		PreparedStatement insertPs = null;
//		PreparedStatement updatePs = null;
//
//		StringBuffer queryStr = new StringBuffer();
//		StringBuffer updateQuery = new StringBuffer();
//
//		int i = 1;
//
//		queryStr.append(" INSERT INTO LEA_ACT_COST_IF (															\n");
//		queryStr.append(" EXE_YRMON,                                                                                                                                    \n");
//		queryStr.append(" INV_SYS_ID,                                                                                                                                   \n");
//		queryStr.append(" IF_SEQ,                                                                                                                                       \n");
//		queryStr.append(" GL_DT,                                                                                                                                        \n");
//		queryStr.append(" REV_YRMON,                                                                                                                                    \n");
//		queryStr.append(" VSL_CD,                                                                                                                                       \n");
//		queryStr.append(" SKD_VOY_NO,                                                                                                                                   \n");
//		queryStr.append(" SKD_DIR_CD,                                                                                                                                   \n");
//		queryStr.append(" REV_DIR_CD,                                                                                                                                   \n");
//		queryStr.append(" ACT_VVD_CD,                                                                                                                                   \n");
//		queryStr.append(" BKG_NO,                                                                                                                                       \n");
//		queryStr.append(" BKG_NO_SPLIT,                                                                                                                                 \n");
//		queryStr.append(" CNTR_NO,                                                                                                                                      \n");
//		queryStr.append(" CNTR_TPSZ_CD,                                                                                                                                 \n");
//		queryStr.append(" COST_ACT_GRP_CD,                                                                                                                              \n");
//		queryStr.append(" COST_ACT_GRP_SEQ,                                                                                                                             \n");
//		queryStr.append(" COA_COST_SRC_CD,                                                                                                                              \n");
//		queryStr.append(" LOCL_CURR_CD,                                                                                                                                 \n");
//		queryStr.append(" LOCL_COST_AMT,                                                                                                                                \n");
//		queryStr.append(" USD_COST_AMT,                                                                                                                                 \n");
//		queryStr.append(" REP_ACCT_CD,                                                                                                                                  \n");
//		queryStr.append(" ACCT_CD,                                                                                                                                      \n");
//		queryStr.append(" OTR_CRR_FLG,                                                                                                                                  \n");
//		queryStr.append(" N1ST_THRP_INCL_COST_CD,                                                                                                                       \n");
//		queryStr.append(" N2ND_THRP_INCL_COST_CD,                                                                                                                       \n");
//		queryStr.append(" N3RD_THRP_INCL_COST_CD,                                                                                                                       \n");
//		queryStr.append(" CSR_NO,                                                                                                                                       \n");
//		queryStr.append(" CSR_TP_CD,                                                                                                                                    \n");
//		queryStr.append(" TTL_INV_KNT,                                                                                                                                  \n");
//		queryStr.append(" INV_NO,                                                                                                                                       \n");
//		queryStr.append(" INV_VNDR_SEQ,                                                                                                                                 \n");
//		queryStr.append(" INV_CXL_FLG,                                                                                                                                  \n");
//		queryStr.append(" INV_CXL_DT,                                                                                                                                   \n");
//		queryStr.append(" TML_INV_TP_CD,                                                                                                                                \n");
//		queryStr.append(" TML_CALC_IND_CD,                                                                                                                              \n");
//		queryStr.append(" COP_NO,                                                                                                                                       \n");
//		queryStr.append(" COST_ACT_GRP_TP_CD,                                                                                                                           \n");
//		queryStr.append(" N1ST_NOD_CD,                                                                                                                                  \n");
//		queryStr.append(" N2ND_NOD_CD,                                                                                                                                  \n");
//		queryStr.append(" N3RD_NOD_CD,                                                                                                                                  \n");
//		queryStr.append(" N4TH_NOD_CD,                                                                                                                                  \n");
//		queryStr.append(" ERR_VVD_APLY_FLG,                                                                                                                             \n");
//		queryStr.append(" ACT_COST_MAPG_CD,                                                                                                                             \n");
//		queryStr.append(" CRE_DT,                                                                                                                                       \n");
//		queryStr.append(" BAT_ST_DT,                                                                                                                                    \n");
//		queryStr.append(" INTER_PRC_APLY_FLG,                                                                                                                           \n");
//		queryStr.append(" BKUP_INTER_COST_CD,                                                                                                                           \n");
//		queryStr.append(" BKUP_INTER_ACCT_CD,                                                                                                                           \n");
//		queryStr.append(" CNTR_MAPG_EXPT_LOG,                                                                                                                           \n");
//		queryStr.append(" UPD_DT,                                                                                                                                       \n");
//		queryStr.append(" REV_VVD_CNG_FLG,                                                                                                                              \n");
//		queryStr.append(" ERR_CSR_NO                                                                                                                                    \n");
//		queryStr.append(" )                                                                                                                                             \n");
//		queryStr.append(" SELECT                                                                                                                                        \n");
//		queryStr.append(" EXE_YRMON,                                                                                                                                    \n");
//		queryStr.append(" INV_SYS_ID,                                                                                                                                   \n");
//		queryStr.append(" LEA_ACT_COST_IF_SEQ.NEXTVAL IF_SEQ,                                                                                                           \n");
//		queryStr.append(" GL_DT,                                                                                                                                        \n");
//		queryStr.append(" REV_YRMON,                                                                                                                                    \n");
//		queryStr.append(" VSL_CD,                                                                                                                                       \n");
//		queryStr.append(" SKD_VOY_NO,                                                                                                                                   \n");
//		queryStr.append(" SKD_DIR_CD,                                                                                                                                   \n");
//		queryStr.append(" REV_DIR_CD,                                                                                                                                   \n");
//		queryStr.append(" ACT_VVD_CD,                                                                                                                                   \n");
//		queryStr.append(" BKG_NO,                                                                                                                                       \n");
//		queryStr.append(" BKG_NO_SPLIT,                                                                                                                                 \n");
//		queryStr.append(" CNTR_NO,                                                                                                                                      \n");
//		queryStr.append(" CNTR_TPSZ_CD,                                                                                                                                 \n");
//		queryStr.append(" COST_ACT_GRP_CD,                                                                                                                              \n");
//		queryStr.append(" COST_ACT_GRP_SEQ,                                                                                                                             \n");
//		queryStr.append(" COA_COST_SRC_CD,                                                                                                                              \n");
//		queryStr.append(" LOCL_CURR_CD,                                                                                                                                 \n");
//		queryStr.append(" LOCL_COST_AMT,                                                                                                                                \n");
//		queryStr.append(" USD_COST_AMT,                                                                                                                                 \n");
//		queryStr.append(" REP_ACCT_CD,                                                                                                                                  \n");
//		queryStr.append(" ACCT_CD,                                                                                                                                      \n");
//		queryStr.append(" OTR_CRR_FLG,                                                                                                                                  \n");
//		queryStr.append(" N1ST_THRP_INCL_COST_CD,                                                                                                                       \n");
//		queryStr.append(" N2ND_THRP_INCL_COST_CD,                                                                                                                       \n");
//		queryStr.append(" N3RD_THRP_INCL_COST_CD,                                                                                                                       \n");
//		queryStr.append(" CSR_NO,                                                                                                                                       \n");
//		queryStr.append(" CSR_TP_CD,                                                                                                                                    \n");
//		queryStr.append(" TTL_INV_KNT,                                                                                                                                  \n");
//		queryStr.append(" INV_NO,                                                                                                                                       \n");
//		queryStr.append(" INV_VNDR_SEQ,                                                                                                                                 \n");
//		queryStr.append(" INV_CXL_FLG,                                                                                                                                  \n");
//		queryStr.append(" INV_CXL_DT,                                                                                                                                   \n");
//		queryStr.append(" TML_INV_TP_CD,                                                                                                                                \n");
//		queryStr.append(" TML_CALC_IND_CD,                                                                                                                              \n");
//		queryStr.append(" COP_NO,                                                                                                                                       \n");
//		queryStr.append(" COST_ACT_GRP_TP_CD,                                                                                                                           \n");
//		queryStr.append(" N1ST_NOD_CD,                                                                                                                                  \n");
//		queryStr.append(" N2ND_NOD_CD,                                                                                                                                  \n");
//		queryStr.append(" N3RD_NOD_CD,                                                                                                                                  \n");
//		queryStr.append(" N4TH_NOD_CD,                                                                                                                                  \n");
//		queryStr.append(" ERR_VVD_APLY_FLG,                                                                                                                             \n");
//		queryStr.append(" ACT_COST_MAPG_CD,                                                                                                                             \n");
//		queryStr.append(" CRE_DT,                                                                                                                                       \n");
//		queryStr.append(" BAT_ST_DT,                                                                                                                                    \n");
//		queryStr.append(" INTER_PRC_APLY_FLG,                                                                                                                           \n");
//		queryStr.append(" BKUP_INTER_COST_CD,                                                                                                                           \n");
//		queryStr.append(" BKUP_INTER_ACCT_CD,                                                                                                                           \n");
//		queryStr.append(" CNTR_MAPG_EXPT_LOG,                                                                                                                           \n");
//		queryStr.append(" UPD_DT,                                                                                                                                       \n");
//		queryStr.append(" REV_VVD_CNG_FLG,                                                                                                                              \n");
//		queryStr.append(" ERR_CSR_NO                                                                                                                                    \n");
//		queryStr.append(" FROM (                                                                                                                                        \n");
//		queryStr.append("     SELECT                                                                                                                                    \n");
//		queryStr.append("     (SELECT SUBSTR(GL_DT,1,6) FROM AP_INV_HDR WHERE CSR_NO = ?) EXE_YRMON,                                                                    \n");
//		queryStr.append("     F.INV_SYS_ID,                                                                                                                             \n");
//		queryStr.append("     '' IF_SEQ,                                                                                                                                \n");
//		queryStr.append("     (SELECT GL_DT FROM AP_INV_HDR WHERE CSR_NO = ?) GL_DT,                                                                                    \n");
//		queryStr.append("     NULL REV_YRMON,                                                                                                                           \n");
//		queryStr.append("     F.VSL_CD,                                                                                                                                 \n");
//		queryStr.append("     F.SKD_VOY_NO,                                                                                                                             \n");
//		queryStr.append("     F.SKD_DIR_CD,                                                                                                                             \n");
//		queryStr.append("     F.REV_DIR_CD,                                                                                                                             \n");
//		queryStr.append("     F.ACT_VVD_CD,                                                                                                                             \n");
//		queryStr.append("     F.BKG_NO,                                                                                                                                 \n");
//		queryStr.append("     F.BKG_NO_SPLIT,                                                                                                                           \n");
//		queryStr.append("     F.CNTR_NO,                                                                                                                                \n");
//		queryStr.append("     F.CNTR_TPSZ_CD,                                                                                                                           \n");
//		queryStr.append("     F.COST_ACT_GRP_CD,                                                                                                                        \n");
//		queryStr.append("     F.COST_ACT_GRP_SEQ,                                                                                                                       \n");
//		queryStr.append("     F.COA_COST_SRC_CD,                                                                                                                        \n");
//		queryStr.append("     F.LOCL_CURR_CD,                                                                                                                           \n");
//		queryStr.append("     F.LOCL_COST_AMT,                                                                                                                          \n");
//		queryStr.append("     0 USD_COST_AMT,                                                                                                                           \n");
//		queryStr.append("     F.REP_ACCT_CD,                                                                                                                            \n");
//		queryStr.append("     F.ACCT_CD,                                                                                                                                \n");
//		queryStr.append("     F.OTR_CRR_FLG,                                                                                                                            \n");
//		queryStr.append("     F.N1ST_THRP_INCL_COST_CD,                                                                                                                 \n");
//		queryStr.append("     F.N2ND_THRP_INCL_COST_CD,                                                                                                                 \n");
//		queryStr.append("     F.N3RD_THRP_INCL_COST_CD,                                                                                                                 \n");
//		queryStr.append("     ? CSR_NO,                                                                                                                                 \n");
//		queryStr.append("     'STANDARD' CSR_TP_CD,                                                                                                                     \n");
//		queryStr.append("     F.TTL_INV_KNT,                                                                                                                            \n");
//		queryStr.append("     F.INV_NO,                                                                                                                                 \n");
//		queryStr.append("     F.INV_VNDR_SEQ,                                                                                                                           \n");
//		queryStr.append("     F.INV_CXL_FLG,                                                                                                                            \n");
//		queryStr.append("     F.INV_CXL_DT,                                                                                                                             \n");
//		queryStr.append("     F.TML_INV_TP_CD,                                                                                                                          \n");
//		queryStr.append("     F.TML_CALC_IND_CD,                                                                                                                        \n");
//		queryStr.append("     F.COP_NO,                                                                                                                                 \n");
//		queryStr.append("     F.COST_ACT_GRP_TP_CD,                                                                                                                     \n");
//		queryStr.append("     F.N1ST_NOD_CD,                                                                                                                            \n");
//		queryStr.append("     F.N2ND_NOD_CD,                                                                                                                            \n");
//		queryStr.append("     F.N3RD_NOD_CD,                                                                                                                            \n");
//		queryStr.append("     F.N4TH_NOD_CD,                                                                                                                            \n");
//		queryStr.append("     F.ERR_VVD_APLY_FLG,                                                                                                                       \n");
//		queryStr.append("     F.ACT_COST_MAPG_CD,                                                                                                                       \n");
//		queryStr.append("     F.CRE_DT,                                                                                                                                 \n");
//		queryStr.append("     F.BAT_ST_DT,                                                                                                                              \n");
//		queryStr.append("     F.INTER_PRC_APLY_FLG,                                                                                                                     \n");
//		queryStr.append("     F.BKUP_INTER_COST_CD,                                                                                                                     \n");
//		queryStr.append("     F.BKUP_INTER_ACCT_CD,                                                                                                                     \n");
//		queryStr.append("     F.CNTR_MAPG_EXPT_LOG,                                                                                                                     \n");
//		queryStr.append("     F.UPD_DT,                                                                                                                                 \n");
//		queryStr.append("     F.REV_VVD_CNG_FLG,                                                                                                                        \n");
//		queryStr.append("     L2.CSR_NO ERR_CSR_NO                                                                                                                      \n");
//		queryStr.append("     FROM LEA_ACT_COST_IF F,                                                                                                                   \n");
//		queryStr.append("     ( SELECT L.CSR_NO, L.BKG_NO, L.BKG_NO_SPLIT, L.OLD_VSL_CD, L.OLD_SKD_VOY_NO, L.OLD_SKD_DIR_CD, L.OLD_REV_DIR_CD                           \n");
//		queryStr.append("       FROM LEA_REV_VVD_CNG L                                                                                                                  \n");
//		queryStr.append("       WHERE L.CSR_NO = (SELECT A.ERR_CSR_NO FROM AP_INV_HDR A WHERE CSR_NO = ?)) L2                                                           \n");
//		queryStr.append("     WHERE  F.CSR_NO = L2.CSR_NO                                                                                                               \n");
//		queryStr.append("     AND    F.BKG_NO = L2.BKG_NO                                                                                                               \n");
//		queryStr.append("     AND    F.BKG_NO_SPLIT = L2.BKG_NO_SPLIT                                                                                                   \n");
//		queryStr.append("     AND    F.VSL_CD||F.SKD_VOY_NO||F.SKD_DIR_CD||F.REV_DIR_CD = L2.OLD_VSL_CD||L2.OLD_SKD_VOY_NO||L2.OLD_SKD_DIR_CD||L2.OLD_REV_DIR_CD        \n");
//		queryStr.append("     UNION ALL                                                                                                                                 \n");
//		queryStr.append("     SELECT                                                                                                                                    \n");
//		queryStr.append("     (SELECT SUBSTR(GL_DT,1,6) FROM AP_INV_HDR WHERE CSR_NO = ?) EXE_YRMON,                                                                    \n");
//		queryStr.append("     F.INV_SYS_ID,                                                                                                                             \n");
//		queryStr.append("     '' IF_SEQ,                                                                                                                                \n");
//		queryStr.append("     (SELECT GL_DT FROM AP_INV_HDR WHERE CSR_NO = ?) GL_DT,                                                                                    \n");
//		queryStr.append("     NULL REV_YRMON,                                                                                                                           \n");
//		queryStr.append("     F.VSL_CD,                                                                                                                                 \n");
//		queryStr.append("     F.SKD_VOY_NO,                                                                                                                             \n");
//		queryStr.append("     F.SKD_DIR_CD,                                                                                                                             \n");
//		queryStr.append("     F.REV_DIR_CD,                                                                                                                             \n");
//		queryStr.append("     F.ACT_VVD_CD,                                                                                                                             \n");
//		queryStr.append("     F.BKG_NO,                                                                                                                                 \n");
//		queryStr.append("     F.BKG_NO_SPLIT,                                                                                                                           \n");
//		queryStr.append("     F.CNTR_NO,                                                                                                                                \n");
//		queryStr.append("     F.CNTR_TPSZ_CD,                                                                                                                           \n");
//		queryStr.append("     F.COST_ACT_GRP_CD,                                                                                                                        \n");
//		queryStr.append("     F.COST_ACT_GRP_SEQ,                                                                                                                       \n");
//		queryStr.append("     F.COA_COST_SRC_CD,                                                                                                                        \n");
//		queryStr.append("     F.LOCL_CURR_CD,                                                                                                                           \n");
//		queryStr.append("     -F.LOCL_COST_AMT,                                                                                                                         \n");
//		queryStr.append("     0 USD_COST_AMT,                                                                                                                           \n");
//		queryStr.append("     F.REP_ACCT_CD,                                                                                                                            \n");
//		queryStr.append("     F.ACCT_CD,                                                                                                                                \n");
//		queryStr.append("     F.OTR_CRR_FLG,                                                                                                                            \n");
//		queryStr.append("     F.N1ST_THRP_INCL_COST_CD,                                                                                                                 \n");
//		queryStr.append("     F.N2ND_THRP_INCL_COST_CD,                                                                                                                 \n");
//		queryStr.append("     F.N3RD_THRP_INCL_COST_CD,                                                                                                                 \n");
//		queryStr.append("     ? CSR_NO,                                                                                                                                 \n");
//		queryStr.append("     'STANDARD' CSR_TP_CD,                                                                                                                     \n");
//		queryStr.append("     F.TTL_INV_KNT,                                                                                                                            \n");
//		queryStr.append("     F.INV_NO,                                                                                                                                 \n");
//		queryStr.append("     F.INV_VNDR_SEQ,                                                                                                                           \n");
//		queryStr.append("     F.INV_CXL_FLG,                                                                                                                            \n");
//		queryStr.append("     F.INV_CXL_DT,                                                                                                                             \n");
//		queryStr.append("     F.TML_INV_TP_CD,                                                                                                                          \n");
//		queryStr.append("     F.TML_CALC_IND_CD,                                                                                                                        \n");
//		queryStr.append("     F.COP_NO,                                                                                                                                 \n");
//		queryStr.append("     F.COST_ACT_GRP_TP_CD,                                                                                                                     \n");
//		queryStr.append("     F.N1ST_NOD_CD,                                                                                                                            \n");
//		queryStr.append("     F.N2ND_NOD_CD,                                                                                                                            \n");
//		queryStr.append("     F.N3RD_NOD_CD,                                                                                                                            \n");
//		queryStr.append("     F.N4TH_NOD_CD,                                                                                                                            \n");
//		queryStr.append("     F.ERR_VVD_APLY_FLG,                                                                                                                       \n");
//		queryStr.append("     F.ACT_COST_MAPG_CD,                                                                                                                       \n");
//		queryStr.append("     F.CRE_DT,                                                                                                                                 \n");
//		queryStr.append("     F.BAT_ST_DT,                                                                                                                              \n");
//		queryStr.append("     F.INTER_PRC_APLY_FLG,                                                                                                                     \n");
//		queryStr.append("     F.BKUP_INTER_COST_CD,                                                                                                                     \n");
//		queryStr.append("     F.BKUP_INTER_ACCT_CD,                                                                                                                     \n");
//		queryStr.append("     F.CNTR_MAPG_EXPT_LOG,                                                                                                                     \n");
//		queryStr.append("     F.UPD_DT,                                                                                                                                 \n");
//		queryStr.append("     F.REV_VVD_CNG_FLG,                                                                                                                        \n");
//		queryStr.append("     L2.CSR_NO ERR_CSR_NO                                                                                                                      \n");
//		queryStr.append("     FROM LEA_ACT_COST_IF F,                                                                                                                   \n");
//		queryStr.append("     ( SELECT L.CSR_NO, L.BKG_NO, L.BKG_NO_SPLIT, L.OLD_VSL_CD, L.OLD_SKD_VOY_NO, L.OLD_SKD_DIR_CD, L.OLD_REV_DIR_CD                           \n");
//		queryStr.append("       FROM LEA_REV_VVD_CNG L                                                                                                                  \n");
//		queryStr.append("       WHERE L.CSR_NO = (SELECT A.ERR_CSR_NO FROM AP_INV_HDR A WHERE CSR_NO = ?)) L2                                                           \n");
//		queryStr.append("     WHERE  F.CSR_NO = L2.CSR_NO                                                                                                               \n");
//		queryStr.append("     AND    F.BKG_NO = L2.BKG_NO                                                                                                               \n");
//		queryStr.append("     AND    F.BKG_NO_SPLIT = L2.BKG_NO_SPLIT                                                                                                   \n");
//		queryStr.append("     AND    F.VSL_CD||F.SKD_VOY_NO||F.SKD_DIR_CD||F.REV_DIR_CD = L2.OLD_VSL_CD||L2.OLD_SKD_VOY_NO||L2.OLD_SKD_DIR_CD||L2.OLD_REV_DIR_CD        \n");
//		queryStr.append(" )                                                                                                                                             \n");
//
//		updateQuery.append(" UPDATE LEA_REV_VVD_CNG C													\n");
//		updateQuery.append(" SET C.ERP_IF_FLG = 'N'                                                                                                     \n");
//		updateQuery.append(" WHERE (C.CSR_NO, C.BKG_NO, C.BKG_NO_SPLIT, C.OLD_VSL_CD, C.OLD_SKD_VOY_NO, C.OLD_SKD_DIR_CD, C.OLD_REV_DIR_CD) = (         \n");
//		updateQuery.append("     SELECT L.CSR_NO, L.BKG_NO, L.BKG_NO_SPLIT, L.OLD_VSL_CD, L.OLD_SKD_VOY_NO, L.OLD_SKD_DIR_CD, L.OLD_REV_DIR_CD          \n");
//		updateQuery.append("     FROM LEA_REV_VVD_CNG L                                                                                                 \n");
//		updateQuery.append("     WHERE L.CSR_NO = (SELECT A.ERR_CSR_NO FROM AP_INV_HDR A WHERE CSR_NO = ?)                                    \n");
//		updateQuery.append(" )                                                                                                                          \n");
//
//		try {
//			con = getConnection();
//
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				insertPs = new LoggableStatement(con, queryStr.toString());
//				updatePs = new LoggableStatement(con, updateQuery.toString());
//			} else {
//				insertPs = con.prepareStatement(queryStr.toString());
//				updatePs = con.prepareStatement(updateQuery.toString());
//			}
//
//			i=1;
//			insertPs.setString(i++, csr_no);
//			insertPs.setString(i++, csr_no);
//			insertPs.setString(i++, csr_no);
//			insertPs.setString(i++, csr_no);
//			insertPs.setString(i++, csr_no);
//			insertPs.setString(i++, csr_no);
//			insertPs.setString(i++, csr_no);
//			insertPs.setString(i++, csr_no);
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				log.info("\n SQL :" + ((LoggableStatement)insertPs).getQueryString());
//			} else {
//				log.info("\n SQL :" + queryStr );
//			}
//			insertPs.executeUpdate();
//
//			i=1;
//    		updatePs.setString(i++, csr_no);
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				log.info("\n SQL :" + ((LoggableStatement)updatePs).getQueryString());
//			} else {
//				log.info("\n SQL :" + updateQuery );
//			}
//			updatePs.executeUpdate();
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
//		} finally {
//			closeStatement(insertPs);
//			closeStatement(updatePs);
//			closeConnection(con);
//		}
//	}

	/**
	 * modifyStsCdSOHDR 수정한다.<br>
	 *
	 * @param  voList List<TesTmlSoHdrVO>
	 * @throws DAOException
	 */
	public void modifyStsCdSOHDR(List<TesTmlSoHdrVO> voList) throws DAOException {
		log.debug("\n DAO.modifyStsCdSOHDR --------------------------------------------------");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new CARIssueTransferSlipManageDBDAOModifyStsCdSOHDRUSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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

	}

	
//	/** 
//	 * modifyStsCdSOHDR 수정한다.<br>
//	 * ApprovalBCImpl에서 호출함.
//	 * 
//	 * @param  voList List<TesTmlSoHdrVO>
//	 * @throws DAOException
//	 */
//	public void modifyStsCdSOHDRBack(String csr_no) throws DAOException {
//		log.debug("\n DAO.modifyStsCdSOHDRBack --------------------------------------------------");
//		
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try {
//				param.put("csr_no", csr_no);
//				new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOModifyStsCdSOHDRBackUSQL(), param, velParam);
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
//	}
	
	
	/** modifyApprovalStep
	 * 
	 * @param title_name String
	 * @param csr_no String
	 * @throws DAOException
	 */
	public void modifyApprovalStep(String title_name, String csr_no) throws DAOException {
		log.debug("start modifyApprovalStep =============================");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			param.put("csr_no", csr_no);
			param.put("title_name", title_name);
//			param.put("hdr_gl_dt", hdr_gl_dt);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOModifyApprovalStepUpdate01USQL(), param, velParam);

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
	}
	
//	/**
//	 * 
//	 * @param title_name
//	 * @param csr_no
//	 * @param hdr_gl_dt
//	 * @throws DAOException
//	 */
//	public void modifyApprovalStepUpdate02(String title_name, String csr_no, String hdr_gl_dt) throws DAOException {
//		log.debug("start modifyApprovalStepUpdate02 =============================");
//		
//		Map<String, Object> param 		= new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam 	= new HashMap<String, Object>();
//		
//		try {
//			param.put("csr_no", csr_no);
//			
//			new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOModifyApprovalStepUpdate02USQL(), param, velParam);
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
//	}


	/**
	 * searchTAXDetail
	 *
	 * @param  compNo String
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchTAXDetail(String compNo) throws DAOException {
		log.debug("start searchTAXDetail ============================= ");
		
		DBRowSet 			dbRowSet	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
		
		try {

			param.put("compNo", compNo);
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchTAXDetailRSQL(), param, velParam);

			return dbRowSet;
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

	}

	/**
	 * searchEviCodeList<br>
	 *
	 * @param vndrSeq
	 * @param account
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchEviCodeList(String vndrSeq, SignOnUserAccount account) throws DAOException {
		log.debug("start searchEviCodeList ============================= ");
		
		DBRowSet 			dbRowSet	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
		
		param.put("vndr_seq", vndrSeq);
		param.put("usr_ofc_cd", account.getOfc_cd());
		
		try {

			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchEviCodeListRSQL(), param, velParam);

			return dbRowSet;
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
		
	}

	/**
	 * searchTAXCode tax code 가져옴
	 *
	 * @param CARIssueTransferSlipManageCommonVO cARIssueTransferSlipManageCommonVO
	 * @param ApTaxVO apTaxVO 
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchTAXCode(CARIssueTransferSlipManageCommonVO cARIssueTransferSlipManageCommonVO, ApTaxVO apTaxVO) throws DAOException {
		log.debug("start searchTAXCode ============================= ");
		
		DBRowSet 			dbRowSet	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
		
		try {
//			param.putAll(cARIssueTransferSlipManageCommonVO.getColumnValues());
//			param.putAll(apTaxVO.getColumnValues());
			
			param.put("tax_type", cARIssueTransferSlipManageCommonVO.getTaxType());
			param.put("tax_naid_fig", apTaxVO.getTaxNaidFlg());
			param.put("fa_flg", apTaxVO.getFaFlg());
			param.put("tax_nsl_flg", apTaxVO.getTaxNslFlg());
			
			log.debug("apTaxVo============>"+apTaxVO.getTaxNaidFlg());
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchTAXCodeRSQL(), param, velParam);

			return dbRowSet;
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

	}
	
	/** searchApEviNoInsert
	 * 
	 * @param tax_no
	 * @param cre_usr_id
	 * @throws DAOException
	 */
	public void searchApEviNoInsert(String tax_no, String cre_usr_id) throws DAOException {
		log.debug("start searchApEviNoInsert =============================");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			param.put("tax_no", tax_no);
			param.put("cre_usr_id", cre_usr_id);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchApEviNoInsertCSQL(), param, velParam);

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
	}
	
	/**
	 * searchApEviNo <br>
	 *
	 * @param String tax_no1
	 * @param String tax_no2
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchApEviNo(String tax_no1, String tax_no2) throws DAOException {
		log.debug("start searchApEviNo ============================= ");
		
		DBRowSet 			dbRowSet	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
		
		try {

			param.put("evid_no", tax_no1+tax_no2);
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchApEviNoRSQL(), param, velParam);

			return dbRowSet;
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

	}

	/**
	 * searchPreviewHDR<br>
	 *
	 * @param String csr_no
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchPreviewHDR(String csr_no) throws DAOException {
		log.debug("start searchPreviewHDR===============================");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("csr_no",csr_no);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchPreviewHDRRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
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
	 * searchPreviewDTRBList<br>
	 *
	 * @param String csr_no
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchPreviewDTRBList(String csr_no) throws DAOException {
		log.debug("start searchPreviewDTRBList =======================");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("csr_no",csr_no);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchPreviewDTRBListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
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

	/** deleteApInvHDRDTRB02
	 * 
	 * @param csr_no
	 * @throws DAOException
	 */
	public void deleteApInvHDRDTRB02(String csr_no) throws DAOException {
		log.debug("start deleteApInvHDRDTRB02 =================");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			param.put("csr_no", csr_no);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAODeleteApInvHDRDTRB02DSQL(), param, velParam);

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
	}
	
	/**
	 * deleteApInvHDRDTRB <br>
	 *
	 * @param csr_no
	 * @throws DAOException
	 */
	public void deleteApInvHDRDTRB(String csr_no) throws DAOException {
		log.debug("start deleteApInvHDRDTRB==========================");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			param.put("csr_no", csr_no);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAODeleteApInvHDRDTRBDSQL(), param, velParam);

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
	
	}
	
//	/** searchINFtoAPCount
//	 * 
//	 * @param csrNo
//	 * @return DBRowSet
//	 * @throws DAOException
//	 */
//	public DBRowSet searchINFtoAPCount(String csrNo) throws DAOException {
//		log.debug("start searchINFtoAPCount =======================");
//		
//		DBRowSet dbRowset = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		try {
//			param.put("csr_no",csrNo);
//			
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchINFtoAPCountRSQL(), param, velParam);
//
//		} catch (SQLException se) {
//			log.debug("#####################se.getMessage()============>"+se.getMessage());
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(), de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(), e);
//			throw new DAOException(e.getMessage());
//		}
//		return dbRowset;	
//	}
//	
	
    /**
     * (ESM_AGT_017) Agent Commission AP Actual Interface의 정보를 수정한다.<br>
     *
     * @param  csrNo String
     * @return DBRowSet
     * @throws DAOException
     */
    public DBRowSet searchINFtoAP(String csrNo) throws DAOException {
		log.debug("start searchINFtoAP =======================");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("csr_no",csrNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchINFtoAPRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
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


//    /**** YOO. 시작 *****/
//    
//    /**
//     * XML 작업을 query로 수행한다.
//     * @param csrNo
//     * @return
//     * @throws DAOException
//     */
//    public String[][] searchINFtoAP2(String csrNo) throws DAOException {
//
//        Connection con = null;				
//        PreparedStatement selectPs1 = null; 
//        PreparedStatement selectPs2 = null; 
//        ResultSet rs1 = null;
//        ResultSet rs2 = null;
////        DBRowSet dRs = null;
//        int i = 1;			
//
//        String[][] retval = null;
//        StringBuffer buf = null;
//        String instanceId = null;
//        int totalRows = 0;
//        
//        int cnt = 0;
//        int idx = 1;
//
//        StringBuffer selectQuery1 = new StringBuffer();
//        StringBuffer selectQuery2 = new StringBuffer();
//
//        selectQuery1.append("\nSELECT count(*) ");
//        selectQuery1.append("\n  FROM ap_inv_if ");
//        selectQuery1.append("\n WHERE csr_no = ? ");
//        selectQuery1.append("\n   AND NVL(snd_flg,'N') = 'Y' ");
//
//        selectQuery2.append(" SELECT 																		\n");												
//        selectQuery2.append(" '<APInvoiceRequest>'||                                                                                                                            \n");
//        selectQuery2.append(" '<LIFID>FNS008-0003</LIFID>'||                                                                                                                    \n");
//        selectQuery2.append(" '<SEQ>'||TO_CHAR(SYSDATE,'YYYYMMDDHH24MISS')||'</SEQ>'||                                                                                          \n");
//        selectQuery2.append(" '<TOTAL_COUNT'||DECODE(TTL_ROW_KNT,NULL,'/>','','/>','>'||TTL_ROW_KNT||'</TOTAL_COUNT>')||                                                        \n");
//        selectQuery2.append(" '<ROW_COUNT'||DECODE(ROW_KNT,NULL,'/>','','/>','>'||ROW_KNT||'</ROW_COUNT>')||                                                                    \n");
//        selectQuery2.append(" '<H_CSR_NUMBER'||DECODE(HDR_CSR_NO,NULL,'/>','','/>','>'||HDR_CSR_NO||'</H_CSR_NUMBER>')||                                                        \n");
//        selectQuery2.append(" '<H_CSR_TYPE'||DECODE(HDR_CSR_TP_CD,NULL,'/>','','/>','>'||HDR_CSR_TP_CD||'</H_CSR_TYPE>')||                                                      \n");
//        selectQuery2.append(" '<H_INVOICE_DATE'||DECODE(HDR_INV_DT,NULL,'/>','','/>','>'||HDR_INV_DT||'</H_INVOICE_DATE>')||                                                    \n");
//        selectQuery2.append(" '<H_TERMS_DATE'||DECODE(HDR_INV_TERM_DT,NULL,'/>','','/>','>'||HDR_INV_TERM_DT||'</H_TERMS_DATE>')||                                              \n");
//        selectQuery2.append(" '<H_GL_DATE'||DECODE(HDR_GL_DT,NULL,'/>','','/>','>'||HDR_GL_DT||'</H_GL_DATE>')||                                                                \n");
//        selectQuery2.append(" '<H_VENDOR_NO'||DECODE(HDR_VNDR_NO,NULL,'/>','','/>','>'||HDR_VNDR_NO||'</H_VENDOR_NO>')||                                                        \n");
//        selectQuery2.append(" '<H_CSR_AMOUNT'||DECODE(HDR_CSR_AMT,NULL,'/>','','/>','>'||HDR_CSR_AMT||'</H_CSR_AMOUNT>')||                                                      \n");
//        selectQuery2.append(" '<H_PAYMENT_AMOUNT'||DECODE(HDR_PAY_AMT,NULL,'/>','','/>','>'||HDR_PAY_AMT||'</H_PAYMENT_AMOUNT>')||                                              \n");
//        selectQuery2.append(" '<H_PAYMENT_DATE'||DECODE(HDR_PAY_DT,NULL,'/>','','/>','>'||HDR_PAY_DT||'</H_PAYMENT_DATE>')||                                                    \n");
//        selectQuery2.append(" '<H_CSR_CURRENCY_CODE'||DECODE(HDR_CSR_CURR_CD,NULL,'/>','','/>','>'||HDR_CSR_CURR_CD||'</H_CSR_CURRENCY_CODE>')||                                \n");
//        selectQuery2.append(" '<H_TERMS_NAME'||DECODE(HDR_VNDR_TERM_NM,NULL,'/>','','/>','>'||HDR_VNDR_TERM_NM||'</H_TERMS_NAME>')||                                            \n");
//        selectQuery2.append(" '<H_DESCRIPTION'||DECODE(HDR_INV_DESC,NULL,'/>','','/>','>'||HDR_INV_DESC||'</H_DESCRIPTION>')||                                                  \n");
//        selectQuery2.append(" '<H_ATTRIBUTE_CATEGORY'||DECODE(HDR_ATTR_CATE_NM,NULL,'/>','','/>','>'||HDR_ATTR_CATE_NM||'</H_ATTRIBUTE_CATEGORY>')||                            \n");
//        selectQuery2.append(" '<H_ATTRIBUTE1'||DECODE('',NULL,'/>','','/>','>'||''||'</H_ATTRIBUTE1>')||                                                                        \n");
//        selectQuery2.append(" '<H_ATTRIBUTE2'||DECODE(HDR_ATTR_CTNT2,NULL,'/>','','/>','>'||HDR_ATTR_CTNT2||'</H_ATTRIBUTE2>')||                                                \n");
//        selectQuery2.append(" '<H_ATTRIBUTE3'||DECODE(HDR_ATTR_CTNT3,NULL,'/>','','/>','>'||HDR_ATTR_CTNT3||'</H_ATTRIBUTE3>')||                                                \n");
//        selectQuery2.append(" '<H_ATTRIBUTE4'||DECODE(HDR_ATTR_CTNT4,NULL,'/>','','/>','>'||HDR_ATTR_CTNT4||'</H_ATTRIBUTE4>')||                                                \n");
//        selectQuery2.append(" '<H_ATTRIBUTE5'||DECODE(HDR_ATTR_CTNT5,NULL,'/>','','/>','>'||HDR_ATTR_CTNT5||'</H_ATTRIBUTE5>')||                                                \n");
//        selectQuery2.append(" '<H_ATTRIBUTE6'||DECODE(HDR_ATTR_CTNT6,NULL,'/>','','/>','>'||HDR_ATTR_CTNT6||'</H_ATTRIBUTE6>')||                                                \n");
//        selectQuery2.append(" '<H_ATTRIBUTE7'||DECODE(HDR_ATTR_CTNT7,NULL,'/>','','/>','>'||HDR_ATTR_CTNT7||'</H_ATTRIBUTE7>')||                                                \n");
//        selectQuery2.append(" '<H_ATTRIBUTE8'||DECODE(HDR_ATTR_CTNT8,NULL,'/>','','/>','>'||HDR_ATTR_CTNT8||'</H_ATTRIBUTE8>')||                                                \n");
//        selectQuery2.append(" '<H_ATTRIBUTE9'||DECODE(HDR_ATTR_CTNT9,NULL,'/>','','/>','>'||HDR_ATTR_CTNT9||'</H_ATTRIBUTE9>')||                                                \n");
//        selectQuery2.append(" '<H_ATTRIBUTE10'||DECODE(HDR_ATTR_CTNT10,NULL,'/>','','/>','>'||HDR_ATTR_CTNT10||'</H_ATTRIBUTE10>')||                                            \n");
//        selectQuery2.append(" '<H_ATTRIBUTE11'||DECODE(HDR_ATTR_CTNT11,NULL,'/>','','/>','>'||HDR_ATTR_CTNT11||'</H_ATTRIBUTE11>')||                                            \n");
//        selectQuery2.append(" '<H_ATTRIBUTE12'||DECODE(HDR_ATTR_CTNT12,NULL,'/>','','/>','>'||HDR_ATTR_CTNT12||'</H_ATTRIBUTE12>')||                                            \n");
//        selectQuery2.append(" '<H_ATTRIBUTE13'||DECODE(HDR_ATTR_CTNT13,NULL,'/>','','/>','>'||HDR_ATTR_CTNT13||'</H_ATTRIBUTE13>')||                                            \n");
//        selectQuery2.append(" '<H_ATTRIBUTE14'||DECODE(HDR_ATTR_CTNT14,NULL,'/>','','/>','>'||HDR_ATTR_CTNT14||'</H_ATTRIBUTE14>')||                                            \n");
//        selectQuery2.append(" '<H_ATTRIBUTE15'||DECODE(HDR_ATTR_CTNT15,NULL,'/>','','/>','>'||HDR_ATTR_CTNT15||'</H_ATTRIBUTE15>')||                                            \n");
//        selectQuery2.append(" '<H_GLOBAL_ATTRIBUTE1'||DECODE(HDR_GLO_ATTR_CTNT1,NULL,'/>','','/>','>'||HDR_GLO_ATTR_CTNT1||'</H_GLOBAL_ATTRIBUTE1>')||                          \n");
//        selectQuery2.append(" '<H_GLOBAL_ATTRIBUTE2'||DECODE(HDR_GLO_ATTR_CTNT2,NULL,'/>','','/>','>'||HDR_GLO_ATTR_CTNT2||'</H_GLOBAL_ATTRIBUTE2>')||                          \n");
//        selectQuery2.append(" '<H_GLOBAL_ATTRIBUTE3'||DECODE(HDR_GLO_ATTR_CTNT3,NULL,'/>','','/>','>'||HDR_GLO_ATTR_CTNT3||'</H_GLOBAL_ATTRIBUTE3>')||                          \n");
//        selectQuery2.append(" '<H_GLOBAL_ATTRIBUTE4'||DECODE(HDR_GLO_ATTR_CTNT4,NULL,'/>','','/>','>'||HDR_GLO_ATTR_CTNT4||'</H_GLOBAL_ATTRIBUTE4>')||                          \n");
//        selectQuery2.append(" '<H_GLOBAL_ATTRIBUTE5'||DECODE(HDR_GLO_ATTR_CTNT5,NULL,'/>','','/>','>'||HDR_GLO_ATTR_CTNT5||'</H_GLOBAL_ATTRIBUTE5>')||                          \n");
//        selectQuery2.append(" '<H_GLOBAL_ATTRIBUTE6'||DECODE(HDR_GLO_ATTR_CTNT6,NULL,'/>','','/>','>'||HDR_GLO_ATTR_CTNT6||'</H_GLOBAL_ATTRIBUTE6>')||                          \n");
//        selectQuery2.append(" '<H_GLOBAL_ATTRIBUTE7'||DECODE(HDR_GLO_ATTR_CTNT7,NULL,'/>','','/>','>'||HDR_GLO_ATTR_CTNT7||'</H_GLOBAL_ATTRIBUTE7>')||                          \n");
//        selectQuery2.append(" '<H_GLOBAL_ATTRIBUTE8'||DECODE(HDR_GLO_ATTR_CTNT8,NULL,'/>','','/>','>'||HDR_GLO_ATTR_CTNT8||'</H_GLOBAL_ATTRIBUTE8>')||                          \n");
//        selectQuery2.append(" '<H_GLOBAL_ATTRIBUTE9'||DECODE(HDR_GLO_ATTR_CTNT9,NULL,'/>','','/>','>'||HDR_GLO_ATTR_CTNT9||'</H_GLOBAL_ATTRIBUTE9>')||                          \n");
//        selectQuery2.append(" '<H_GLOBAL_ATTRIBUTE10'||DECODE(HDR_GLO_ATTR_CTNT10,NULL,'/>','','/>','>'||HDR_GLO_ATTR_CTNT10||'</H_GLOBAL_ATTRIBUTE10>')||                      \n");
//        selectQuery2.append(" '<H_GLOBAL_ATTRIBUTE11'||DECODE(HDR_GLO_ATTR_CTNT11,NULL,'/>','','/>','>'||HDR_GLO_ATTR_CTNT11||'</H_GLOBAL_ATTRIBUTE11>')||                      \n");
//        selectQuery2.append(" '<H_GLOBAL_ATTRIBUTE12'||DECODE(HDR_GLO_ATTR_CTNT12,NULL,'/>','','/>','>'||HDR_GLO_ATTR_CTNT12||'</H_GLOBAL_ATTRIBUTE12>')||                      \n");
//        selectQuery2.append(" '<H_GLOBAL_ATTRIBUTE13'||DECODE(HDR_GLO_ATTR_CTNT13,NULL,'/>','','/>','>'||HDR_GLO_ATTR_CTNT13||'</H_GLOBAL_ATTRIBUTE13>')||                      \n");
//        selectQuery2.append(" '<H_GLOBAL_ATTRIBUTE14'||DECODE(HDR_GLO_ATTR_CTNT14,NULL,'/>','','/>','>'||HDR_GLO_ATTR_CTNT14||'</H_GLOBAL_ATTRIBUTE14>')||                      \n");
//        selectQuery2.append(" '<H_GLOBAL_ATTRIBUTE15'||DECODE(HDR_GLO_ATTR_CTNT15,NULL,'/>','','/>','>'||HDR_GLO_ATTR_CTNT15||'</H_GLOBAL_ATTRIBUTE15>')||                      \n");
//        selectQuery2.append(" '<H_GLOBAL_ATTRIBUTE16'||DECODE(HDR_GLO_ATTR_CTNT16,NULL,'/>','','/>','>'||HDR_GLO_ATTR_CTNT16||'</H_GLOBAL_ATTRIBUTE16>')||                      \n");
//        selectQuery2.append(" '<H_GLOBAL_ATTRIBUTE17'||DECODE(HDR_GLO_ATTR_CTNT17,NULL,'/>','','/>','>'||HDR_GLO_ATTR_CTNT17||'</H_GLOBAL_ATTRIBUTE17>')||                      \n");
//        selectQuery2.append(" '<H_GLOBAL_ATTRIBUTE18'||DECODE(HDR_GLO_ATTR_CTNT18,NULL,'/>','','/>','>'||HDR_GLO_ATTR_CTNT18||'</H_GLOBAL_ATTRIBUTE18>')||                      \n");
//        selectQuery2.append(" '<H_SOURCE'||DECODE(HDR_SRC_CTNT,NULL,'/>','','/>','>'||HDR_SRC_CTNT||'</H_SOURCE>')||                                                            \n");
//        selectQuery2.append(" '<H_PAYMENT_METHOD_LOOKUP_CODE'||DECODE(HDR_PAY_MZD_LU_CD,NULL,'/>','','/>','>'||HDR_PAY_MZD_LU_CD||'</H_PAYMENT_METHOD_LOOKUP_CODE>')||          \n");
//        selectQuery2.append(" '<H_PAY_GROUP_LOOKUP_CODE'||DECODE(HDR_PAY_GRP_LU_CD,NULL,'/>','','/>','>'||HDR_PAY_GRP_LU_CD||'</H_PAY_GROUP_LOOKUP_CODE>')||                    \n");
//        selectQuery2.append(" '<H_ACCTS_COA_COMPANY'||DECODE(HDR_COA_CO_CD,NULL,'/>','','/>','>'||HDR_COA_CO_CD||'</H_ACCTS_COA_COMPANY>')||                                    \n");
//        selectQuery2.append(" '<H_ACCTS_COA_REGION'||DECODE(HDR_COA_RGN_CD,NULL,'/>','','/>','>'||HDR_COA_RGN_CD||'</H_ACCTS_COA_REGION>')||                                    \n");
//        selectQuery2.append(" '<H_ACCTS_COA_CENTER'||DECODE(HDR_COA_CTR_CD,NULL,'/>','','/>','>'||HDR_COA_CTR_CD||'</H_ACCTS_COA_CENTER>')||                                    \n");
//        selectQuery2.append(" '<H_ACCTS_COA_ACCOUNT'||DECODE(HDR_COA_ACCT_CD,NULL,'/>','','/>','>'||HDR_COA_ACCT_CD||'</H_ACCTS_COA_ACCOUNT>')||                                \n");
//        selectQuery2.append(" '<H_ACCTS_COA_VVD'||DECODE(HDR_COA_VVD_CD,NULL,'/>','','/>','>'||HDR_COA_VVD_CD||'</H_ACCTS_COA_VVD>')||                                          \n");
//        selectQuery2.append(" '<H_ACCTS_COA_INTERCOMPANY'||DECODE(HDR_COA_INTER_CO_CD,NULL,'/>','','/>','>'||HDR_COA_INTER_CO_CD||'</H_ACCTS_COA_INTERCOMPANY>')||              \n");
//        selectQuery2.append(" '<H_ACCTS_COA_FUTURE1'||DECODE(HDR_COA_FTU_N1ST_CD,NULL,'/>','','/>','>'||HDR_COA_FTU_N1ST_CD||'</H_ACCTS_COA_FUTURE1>')||                        \n");
//        selectQuery2.append(" '<H_ACCTS_COA_FUTURE2'||DECODE(HDR_COA_FTU_N2ND_CD,NULL,'/>','','/>','>'||HDR_COA_FTU_N2ND_CD||'</H_ACCTS_COA_FUTURE2>')||                        \n");
//        selectQuery2.append(" '<H_PREPAY_NUM'||DECODE(HDR_PPD_NO,NULL,'/>','','/>','>'||HDR_PPD_NO||'</H_PREPAY_NUM>')||                                                        \n");
//        selectQuery2.append(" '<H_PREPAY_DIST_NUM'||DECODE(HDR_PPD_DTRB_NO,NULL,'/>','','/>','>'||HDR_PPD_DTRB_NO||'</H_PREPAY_DIST_NUM>')||                                    \n");
//        selectQuery2.append(" '<H_PREPAY_APPLY_AMOUNT'||DECODE(HDR_PPD_APLY_AMT,NULL,'/>','','/>','>'||HDR_PPD_APLY_AMT||'</H_PREPAY_APPLY_AMOUNT>')||                          \n");
//        selectQuery2.append(" '<H_PREPAY_GL_DATE'||DECODE(HDR_PPD_GL_DT,NULL,'/>','','/>','>'||HDR_PPD_GL_DT||'</H_PREPAY_GL_DATE>')||                                          \n");
//        selectQuery2.append(" '' RETVAL1,                                          \n");
//        selectQuery2.append(" '<H_APPROVE_FLAG'||DECODE(HDR_APRO_FLG,NULL,'/>','','/>','>'||HDR_APRO_FLG||'</H_APPROVE_FLAG>')||                                                \n");
//        selectQuery2.append(" '<H_TAX_FLAG'||DECODE(HDR_TAX_DECL_FLG,NULL,'/>','','/>','>'||HDR_TAX_DECL_FLG||'</H_TAX_FLAG>')||                                                \n");
//        selectQuery2.append(" '<H_ERROR_CSR_NUMBER'||DECODE(HDR_ERR_CSR_NO,NULL,'/>','','/>','>'||HDR_ERR_CSR_NO||'</H_ERROR_CSR_NUMBER>')||                                    \n");
//        selectQuery2.append(" '<H_INTERFACE_FLAG'||DECODE(HDR_IF_FLG,NULL,'/>','','/>','>'||HDR_IF_FLG||'</H_INTERFACE_FLAG>')||                                                \n");
//        selectQuery2.append(" '<H_INTERFACE_DATE'||DECODE(HDR_IF_DT,NULL,'/>','','/>','>'||HDR_IF_DT||'</H_INTERFACE_DATE>')||                                                  \n");
//        selectQuery2.append(" '<H_INTERFACE_ERROR_REASON'||DECODE(HDR_IF_ERR_RSN,NULL,'/>','','/>','>'||HDR_IF_ERR_RSN||'</H_INTERFACE_ERROR_REASON>')||                        \n");
//        selectQuery2.append(" '<H_PREPAYMENT_APPLY_FLAG'||DECODE(HDR_PPAY_APLY_FLG,NULL,'/>','','/>','>'||HDR_PPAY_APLY_FLG||'</H_PREPAYMENT_APPLY_FLAG>')||                    \n");
//        selectQuery2.append(" '<H_TRANSACTION_CODE'||DECODE(HDR_TJ_OFC_CD,NULL,'/>','','/>','>'||HDR_TJ_OFC_CD||'</H_TRANSACTION_CODE>')||                                      \n");
//        selectQuery2.append(" '<H_ACTUAL_RATE'||DECODE(HDR_ACT_XCH_RT,NULL,'/>','','/>','>'||HDR_ACT_XCH_RT||'</H_ACTUAL_RATE>')||                                              \n");
//        selectQuery2.append(" '<H_IMPORT_ERROR_FLAG'||DECODE(HDR_IMP_ERR_FLG,NULL,'/>','','/>','>'||HDR_IMP_ERR_FLG||'</H_IMPORT_ERROR_FLAG>')||                                \n");
//        selectQuery2.append(" '<H_RECEIVE_ERROR_FLAG'||DECODE(HDR_RCV_ERR_FLG,NULL,'/>','','/>','>'||HDR_RCV_ERR_FLG||'</H_RECEIVE_ERROR_FLAG>')||                              \n");
//        selectQuery2.append(" '<H_TAX_CURRENCY_EXCHANGE_FLAG'||DECODE(HDR_TAX_CURR_XCH_FLG,NULL,'/>','','/>','>'||HDR_TAX_CURR_XCH_FLG||'</H_TAX_CURRENCY_EXCHANGE_FLAG>')||    \n");
//        selectQuery2.append(" '<H_USER_EMAIL_ID'||DECODE(HDR_USR_EML,NULL,'/>','','/>','>'||HDR_USR_EML||'</H_USER_EMAIL_ID>')||                                                \n");
//        selectQuery2.append(" '<H_IMPORT_ERROR_REASON'||DECODE(HDR_IMP_ERR_RSN,NULL,'/>','','/>','>'||HDR_IMP_ERR_RSN||'</H_IMPORT_ERROR_REASON>')||                            \n");
//        selectQuery2.append(" '<H_RECEIVE_ERROR_REASON'||DECODE(HDR_RCV_ERR_RSN,NULL,'/>','','/>','>'||HDR_RCV_ERR_RSN||'</H_RECEIVE_ERROR_REASON>')||                          \n");
//        selectQuery2.append(" '<H_FUTURE_USE1'||DECODE(HDR_FTU_USE_CTNT1,NULL,'/>','','/>','>'||HDR_FTU_USE_CTNT1||'</H_FUTURE_USE1>')||                                        \n");
//        selectQuery2.append(" '<H_FUTURE_USE2'||DECODE(HDR_FTU_USE_CTNT2,NULL,'/>','','/>','>'||HDR_FTU_USE_CTNT2||'</H_FUTURE_USE2>')||                                        \n");
//        selectQuery2.append(" '<H_FUTURE_USE3'||DECODE(HDR_FTU_USE_CTNT3,NULL,'/>','','/>','>'||HDR_FTU_USE_CTNT3||'</H_FUTURE_USE3>')||                                        \n");
//        selectQuery2.append(" '<H_FUTURE_USE4'||DECODE(HDR_FTU_USE_CTNT4,NULL,'/>','','/>','>'||HDR_FTU_USE_CTNT4||'</H_FUTURE_USE4>')||                                        \n");
//        selectQuery2.append(" '<H_FUTURE_USE5'||DECODE(HDR_FTU_USE_CTNT5,NULL,'/>','','/>','>'||HDR_FTU_USE_CTNT5||'</H_FUTURE_USE5>')||                                        \n");
//        selectQuery2.append(" '<L_CSR_NUMBER'||DECODE(CSR_NO,NULL,'/>','','/>','>'||CSR_NO||'</L_CSR_NUMBER>')||                                                                \n");
//        selectQuery2.append(" '<L_LINE_SEQUENCE_LEGACY'||DECODE(LINE_SEQ,NULL,'/>','','/>','>'||LINE_SEQ||'</L_LINE_SEQUENCE_LEGACY>')||                                        \n");
//        selectQuery2.append(" '<L_LINE_NUMBER_ERP'||DECODE(LINE_NO,NULL,'/>','','/>','>'||LINE_NO||'</L_LINE_NUMBER_ERP>')||                                                    \n");
//        selectQuery2.append(" '<L_LINE_TYPE_LOOKUP_CODE'||DECODE(LINE_TP_LU_CD,NULL,'/>','','/>','>'||LINE_TP_LU_CD||'</L_LINE_TYPE_LOOKUP_CODE>')||                            \n");
//        selectQuery2.append(" '<L_AMOUNT'||DECODE(INV_AMT,NULL,'/>','','/>','>'||INV_AMT||'</L_AMOUNT>')||                                                                      \n");
//        selectQuery2.append(" '<L_DESCRIPTION'||DECODE(INV_DESC,NULL,'/>','','/>','>'||INV_DESC||'</L_DESCRIPTION>')||                                                          \n");
//        selectQuery2.append(" '<L_TAX_CODE'||DECODE(INV_TAX_CD,NULL,'/>','','/>','>'||INV_TAX_CD||'</L_TAX_CODE>')||                                                            \n");
//        selectQuery2.append(" '<L_DIST_COA_COMPANY'||DECODE(DTRB_COA_CO_CD,NULL,'/>','','/>','>'||DTRB_COA_CO_CD||'</L_DIST_COA_COMPANY>')||                                    \n");
//        selectQuery2.append(" '<L_DIST_COA_REGION'||DECODE(DTRB_COA_RGN_CD,NULL,'/>','','/>','>'||DTRB_COA_RGN_CD||'</L_DIST_COA_REGION>')||                                    \n");
//        selectQuery2.append(" '<L_DIST_COA_CENTER'||DECODE(DTRB_COA_CTR_CD,NULL,'/>','','/>','>'||DTRB_COA_CTR_CD||'</L_DIST_COA_CENTER>')||                                    \n");
//        selectQuery2.append(" '<L_DIST_COA_ACCOUNT'||DECODE(DTRB_COA_ACCT_CD,NULL,'/>','','/>','>'||DTRB_COA_ACCT_CD||'</L_DIST_COA_ACCOUNT>')||                                \n");
//        selectQuery2.append(" '<L_DIST_COA_VVD'||DECODE(DTRB_COA_VVD_CD,NULL,'/>','','/>','>'||DTRB_COA_VVD_CD||'</L_DIST_COA_VVD>')||                                          \n");
//        selectQuery2.append(" '<L_DIST_COA_INTERCOMPANY'||DECODE(DTRB_COA_INTER_CO_CD,NULL,'/>','','/>','>'||DTRB_COA_INTER_CO_CD||'</L_DIST_COA_INTERCOMPANY>')||              \n");
//        selectQuery2.append(" '<L_DIST_COA_FUTURE1'||DECODE(DTRB_COA_FTU_N1ST_CD,NULL,'/>','','/>','>'||DTRB_COA_FTU_N1ST_CD||'</L_DIST_COA_FUTURE1>')||                        \n");
//        selectQuery2.append(" '<L_DIST_COA_FUTURE2'||DECODE(DTRB_COA_FTU_N2ND_CD,NULL,'/>','','/>','>'||DTRB_COA_FTU_N2ND_CD||'</L_DIST_COA_FUTURE2>')||                        \n");
//        selectQuery2.append(" '<L_ATTRIBUTE_CATEGORY'||DECODE(ATTR_CATE_NM,NULL,'/>','','/>','>'||ATTR_CATE_NM||'</L_ATTRIBUTE_CATEGORY>')||                                    \n");
//        selectQuery2.append(" '<L_ATTRIBUTE1'||DECODE(ATTR_CTNT1,NULL,'/>','','/>','>'||ATTR_CTNT1||'</L_ATTRIBUTE1>')||                                                        \n");
//        selectQuery2.append(" '<L_ATTRIBUTE2'||DECODE(ATTR_CTNT2,NULL,'/>','','/>','>'||ATTR_CTNT2||'</L_ATTRIBUTE2>')||                                                        \n");
//        selectQuery2.append(" '<L_ATTRIBUTE3'||DECODE(ATTR_CTNT3,NULL,'/>','','/>','>'||ATTR_CTNT3||'</L_ATTRIBUTE3>')||                                                        \n");
//        selectQuery2.append(" '<L_ATTRIBUTE4'||DECODE(ATTR_CTNT4,NULL,'/>','','/>','>'||ATTR_CTNT4||'</L_ATTRIBUTE4>')||                                                        \n");
//        selectQuery2.append(" '<L_ATTRIBUTE5'||DECODE(ATTR_CTNT5,NULL,'/>','','/>','>'||ATTR_CTNT5||'</L_ATTRIBUTE5>')||                                                        \n");
//        selectQuery2.append(" '<L_ATTRIBUTE6'||DECODE(ATTR_CTNT6,NULL,'/>','','/>','>'||ATTR_CTNT6||'</L_ATTRIBUTE6>')||                                                        \n");
//        selectQuery2.append(" '<L_ATTRIBUTE7'||DECODE(ATTR_CTNT7,NULL,'/>','','/>','>'||ATTR_CTNT7||'</L_ATTRIBUTE7>')||                                                        \n");
//        selectQuery2.append(" '<L_ATTRIBUTE8'||DECODE(ATTR_CTNT8,NULL,'/>','','/>','>'||ATTR_CTNT8||'</L_ATTRIBUTE8>')||                                                        \n");
//        selectQuery2.append(" '<L_ATTRIBUTE9'||DECODE(ATTR_CTNT9,NULL,'/>','','/>','>'||ATTR_CTNT9||'</L_ATTRIBUTE9>')||                                                        \n");
//        selectQuery2.append(" '<L_ATTRIBUTE10'||DECODE(ATTR_CTNT10,NULL,'/>','','/>','>'||ATTR_CTNT10||'</L_ATTRIBUTE10>')||                                                    \n");
//        selectQuery2.append(" '<L_ATTRIBUTE11'||DECODE(ATTR_CTNT11,NULL,'/>','','/>','>'||ATTR_CTNT11||'</L_ATTRIBUTE11>')||                                                    \n");
//        selectQuery2.append(" '<L_ATTRIBUTE12'||DECODE(ATTR_CTNT12,NULL,'/>','','/>','>'||ATTR_CTNT12||'</L_ATTRIBUTE12>')||                                                    \n");
//        selectQuery2.append(" '<L_ATTRIBUTE13'||DECODE(ATTR_CTNT13,NULL,'/>','','/>','>'||ATTR_CTNT13||'</L_ATTRIBUTE13>')||                                                    \n");
//        selectQuery2.append(" '<L_ATTRIBUTE14'||DECODE(ATTR_CTNT14,NULL,'/>','','/>','>'||ATTR_CTNT14||'</L_ATTRIBUTE14>')||                                                    \n");
//        selectQuery2.append(" '<L_ATTRIBUTE15'||DECODE(ATTR_CTNT15,NULL,'/>','','/>','>'||ATTR_CTNT15||'</L_ATTRIBUTE15>')||                                                    \n");
//        selectQuery2.append(" '<L_BKG_NO'||DECODE(BKG_NO,NULL,'/>','','/>','>'||BKG_NO||'</L_BKG_NO>')||                                                                        \n");
//        selectQuery2.append(" '<L_CNTR_TP_SZ'||DECODE(CNTR_TPSZ_CD,NULL,'/>','','/>','>'||CNTR_TPSZ_CD||'</L_CNTR_TP_SZ>')||                                                    \n");
//        selectQuery2.append(" '<L_ACT_VVD'||DECODE(ACT_VVD_CD,NULL,'/>','','/>','>'||ACT_VVD_CD||'</L_ACT_VVD>')||                                                              \n");
//        selectQuery2.append(" '<L_DIV_CD'||DECODE(PLN_SCTR_DIV_CD,NULL,'/>','','/>','>'||PLN_SCTR_DIV_CD||'</L_DIV_CD>')||                                                      \n");
//        selectQuery2.append(" '<L_CARR_CD'||DECODE(SO_CRR_CD,NULL,'/>','','/>','>'||SO_CRR_CD||'</L_CARR_CD>')||                                                                \n");
//        selectQuery2.append(" '<L_YD_CD'||DECODE(YD_CD,NULL,'/>','','/>','>'||YD_CD||'</L_YD_CD>')||                                                                            \n");
//        selectQuery2.append(" '<L_FUTURE_USE1'||DECODE(FTU_USE_CTNT1,NULL,'/>','','/>','>'||FTU_USE_CTNT1||'</L_FUTURE_USE1>')||                                                \n");
//        selectQuery2.append(" '<L_FUTURE_USE2'||DECODE(FTU_USE_CTNT2,NULL,'/>','','/>','>'||FTU_USE_CTNT2||'</L_FUTURE_USE2>')||                                                \n");
//        selectQuery2.append(" '<L_FUTURE_USE3'||DECODE(FTU_USE_CTNT3,NULL,'/>','','/>','>'||FTU_USE_CTNT3||'</L_FUTURE_USE3>')||                                                \n");
//        selectQuery2.append(" '<L_FUTURE_USE4'||DECODE(FTU_USE_CTNT4,NULL,'/>','','/>','>'||FTU_USE_CTNT4||'</L_FUTURE_USE4>')||                                                \n");
//        selectQuery2.append(" '<L_FUTURE_USE5'||DECODE(FTU_USE_CTNT5,NULL,'/>','','/>','>'||FTU_USE_CTNT5||'</L_FUTURE_USE5>')||                                                \n");
//        selectQuery2.append(" '</APInvoiceRequest>'  RETVAL2                                                                                                                            \n");
//        selectQuery2.append(" FROM AP_INV_IF                                                                                                                                    \n");
//        selectQuery2.append(" WHERE CSR_NO = ?                                                                                                                                  \n");
//        selectQuery2.append(" AND NVL(snd_flg,'N') = 'N'                                                                                                                        \n");
//
//        try {
//            con = getConnection();
//
//            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//                selectPs1 = new LoggableStatement(con, selectQuery1.toString());
////                selectPs2 = new LoggableStatement(con, selectQuery2.toString());
//                selectPs2 = con.prepareStatement(selectQuery2.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
//            } else {
//                selectPs1 = con.prepareStatement(selectQuery1.toString());
////                selectPs2 = con.prepareStatement(selectQuery2.toString());
//                selectPs2 = con.prepareStatement(selectQuery2.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
//            }
//
//            i = 1;
//            selectPs1.setString(i++, csrNo);
//
//            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//                log.info("\n [searchINFtoAP]Select SQL1 ::::::::: \n" + ((LoggableStatement)selectPs1).getQueryString());
//            } else {
//                log.info("\n [searchINFtoAP]Select SQL1 : \n" + selectQuery1.toString() );
//            }
//            rs1 = selectPs1.executeQuery();
//
//            if(rs1 != null){
//            	while(rs1.next()) {
//					if((cnt = rs1.getInt(1)) > 0){ //CSR No has already Interfaced! Please check up CSR No[$]
//						throw new DAOException((new ErrorHandler("AGT00029", new String[]{csrNo})).getMessage());
//					}
//				}
//            }
//
//            i = 1;
//            selectPs2.setString(i++, csrNo);
//
////            if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//////                log.info("\n [searchINFtoAP]Select SQL2 ::::::::: \n" + ((LoggableStatement)selectPs2).getQueryString());
////            	log.info("\n [searchINFtoAP]Select SQL2 : \n" + selectQuery2.toString() );
////            } else {
////                log.info("\n [searchINFtoAP]Select SQL2 : \n" + selectQuery2.toString() );
////            }
//            rs2 = selectPs2.executeQuery();
//
//            rs2.last();
//            totalRows = rs2.getRow();
//            rs2.beforeFirst();
//
//            int quot = totalRows/1000;
//			int sur  = totalRows%1000;
//			int arr_leng = (sur>0?(quot+1):quot);
//			retval = new String[arr_leng>0?arr_leng:1][2]; // column은 XML data와 instanceID 두개....
//            
//			log.debug("\n FNS0080003Document[] : CSR_NO:" + JSPUtil.getNull(csrNo) + " - arr_leng:"+retval.length+" (row_cnt:"+totalRows+")   <<<<\n");
//			
//			for (int j=0; j<retval.length; j++){
//				instanceId = "FNS008-0003J"+(new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date())+"TES"+JSPUtil.getNull(csrNo);
//				buf = new StringBuffer();
//				buf.append("<FNS008-0003 xmlns=\"http://irep.hanjin.com/enis\">");
//				buf.append("<EAIHeader xmlns=\"\">");
//				buf.append("<InstanceId>"+instanceId+"</InstanceId>");
//				buf.append("<Parameters>");
//				buf.append("<Parameter>FNS008-0003--Header</Parameter>");
//				buf.append("</Parameters>");
//				buf.append("</EAIHeader>");
//				buf.append("<DataArea xmlns=\"\">");
//				buf.append("<APInvoiceCollection>");
//	            idx = 1;
//				while (idx<=1000 && rs2.next()) {
//					buf.append(rs2.getString("RETVAL1")+rs2.getString("RETVAL2"));
//					idx++;
//				}
//				buf.append("</APInvoiceCollection>");
//				buf.append("</DataArea>");
//				buf.append("</FNS008-0003>");
//				retval[j][0] = buf.toString()!=null?buf.toString():"";
//				retval[j][1] = instanceId!=null?instanceId:"";
//				buf = null;
//			}
//			log.debug("\n =>> retval.length : "+retval.length+"\n");
//            
//        } catch (SQLException se) {
//            log.error(se.getMessage(),se);
//            throw new DAOException(new ErrorHandler(se).getMessage());
//        } catch (DAOException de) {
//            log.error(de.getMessage(),de);
//            throw de;
//        } catch (Exception e) {
//            log.error(e.getMessage(),e);
//            throw new DAOException(e.getMessage());
//        } finally {
//        	closeResultSet(rs1);
//        	closeResultSet(rs2);
//        	closeStatement(selectPs1);
//        	closeStatement(selectPs2);
//            closeConnection(con);
//        }
//
//        return retval;
//    }

	/**
	 * CSR AP I/F 목록 조회
	 * @param event EsdTes0100Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCSRAPiflist(EsdTes0100Event event) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(event != null){
				Map<String, String> mapVO = event.getCARIssueTransferSlipManageCommonVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("ofc_cd",event.getSignOnUserAccount().getOfc_cd());
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchCSRAPiflistRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
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
	 *  CSR cancel 처리
	 *
	 * @param model 데이타 모델
	 * @return DBRowSet
	 * @throws DAOException
	 */
//	public void cancelCSRAPif(AP_INV_HDR model, String user_id, String ofc_cd) throws DAOException {
//
//		log.debug("## DAO.cancelCSRAPif #########################");
//
//		Connection con = null;
//		PreparedStatement updatePs1  = null;
//		PreparedStatement updatePs2  = null;
//
//		int i = 1;
//
//		String csr_no = model!=null?JSPUtil.getNull(model.getCsr_no()):"";
//
//		StringBuffer updateQuery1 = new StringBuffer();
//		updateQuery1.append(" UPDATE TES_TML_SO_HDR    				\n");
//		updateQuery1.append(" SET TML_INV_STS_CD = 'C', TML_INV_RJCT_STS_CD = 'R', UPD_USR_ID = ?, UPD_DT = GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(?)  \n");
//		updateQuery1.append(" WHERE CSR_NO = ?    \n");
//
//		StringBuffer updateQuery2 = new StringBuffer();
//		updateQuery2.append(" UPDATE AP_INV_HDR    				\n");
//		updateQuery2.append(" SET AFT_ACT_FLG = 'Y' \n");
//		updateQuery2.append(" WHERE CSR_NO = ?    \n");
//
//		try {
//			con = getConnection();
//
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				updatePs1 = new LoggableStatement(con, updateQuery1.toString());
//				updatePs2 = new LoggableStatement(con, updateQuery2.toString());
//			} else {
//				updatePs1 = con.prepareStatement(updateQuery1.toString());
//				updatePs2 = con.prepareStatement(updateQuery2.toString());
//			}
//
//
//			// SO_HDR UPDATE하기
//			i = 1;
//			updatePs1.setString(i++, user_id);
//			updatePs1.setString(i++, ofc_cd);
//			updatePs1.setString(i++, csr_no);
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				log.info("\n [UPDATE SO_HDR] SQL :" + ((LoggableStatement)updatePs1).getQueryString());
//			} else {
//				log.info("\n [UPDATE SO_HDR] SQL :" + updateQuery1.toString());
//			}
//			updatePs1.executeUpdate();
//
//
//			// AP_HDR UPDATE하기
//			i = 1;
//			updatePs2.setString(i++, csr_no);
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				log.info("\n [UPDATE AP_HDR] SQL :" + ((LoggableStatement)updatePs2).getQueryString());
//			} else {
//				log.info("\n [UPDATE AP_HDR] SQL :" + updateQuery2.toString());
//			}
//			updatePs2.executeUpdate();
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(),de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(),e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeStatement(updatePs1);
//			closeStatement(updatePs2);
//			closeConnection(con);
//			updatePs1 = null;
//			updatePs2 = null;
//		}
//
//	}

	/**
	 * 대체전표로 검색된 해당 SO HDR 정보
	 * @param  event EsdTes0101Event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCSRSOhdr(EsdTes0101Event event) throws DAOException {

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			if(event.getApInvHdrVO() != null){
				Map<String, String> mapVO = event.getApInvHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchCSRSOhdrRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
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
	 * 대체전표로 검색된 해당 SO목록
	 * @param  ApInvHdrVO apInvHdrVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCSRSOlist(ApInvHdrVO apInvHdrVO) throws DAOException {
		log.debug("start searchCSRSOlist ======================");
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.putAll(apInvHdrVO.getColumnValues());
		velParam.putAll(apInvHdrVO.getColumnValues());
		
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchCSRSOlistRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
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
	
	/** multiRejectedCSRCancellation01
	 * 
	 * @param  voList List<TesTmlSoHdrVO>
	 * @throws DAOException
	 */
	public void multiRejectedCSRCancellation01(List<TesTmlSoHdrVO> voList) throws DAOException {
		log.debug("start multiRejectedCSRCancellation01 ==================");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new CARIssueTransferSlipManageDBDAOMultiRejectedCSRCancellationUpdate01USQL(), voList, velParam, param);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	}
	
	/** multiRejectedCSRCancellation02
	 * 
	 * @param csrNo
	 * @throws DAOException
	 */
	public void multiRejectedCSRCancellation02(String csrNo) throws DAOException {
		log.debug("start multiRejectedCSRCancellation02 ======================== ");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			param.put("csr_no", csrNo);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOMultiRejectedCSRCancellationUpdate02USQL(), param, velParam);

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
	}

	/** multiCSRCancelTPBIF
	 * 
	 * @param csrNo
	 * @param invOfcCd
	 * @throws DAOException
	 */
	public void multiCSRCancelTPBIF(String csrNo, String invOfcCd) throws DAOException {
		log.debug("start multiCSRCancelTPBIF ======================== ");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			param.put("csr_no", csrNo);
			param.put("inv_ofc_cd", invOfcCd);
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOMultiCSRCancelTPBIFUSQL(), param, velParam);

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
	}	
	 
	/** cancelCSR01
	 * 
	 * @param event
	 * @return int
	 * @throws DAOException
	 */
	public int cancelCSR01(EsdTes0100Event event) throws DAOException {
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		int cnt = 0;
		
		try {
			if(event.getApInvHdrVO() != null){
				Map<String, String> mapVO = event.getApInvHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("upd_usr_id", event.getSignOnUserAccount().getUsr_id());
				param.put("ofc_cd", event.getSignOnUserAccount().getOfc_cd());
			}
						
			cnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOCancelCSR01USQL(), param, velParam);

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
		
		return cnt;
	}
	
	/** cancelCSR02
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void cancelCSR02(EsdTes0100Event event) throws DAOException {
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		int cnt = 0;
		
		try {
			if(event.getApInvHdrVO() != null){
				Map<String, String> mapVO = event.getApInvHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
						
			cnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOCancelCSR02USQL(), param, velParam);

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
		
	}

	/** cancelCSR03
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void cancelCSR03(EsdTes0100Event event) throws DAOException {
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		int cnt = 0;
		
		try {
			if(event.getApInvHdrVO() != null){
				Map<String, String> mapVO = event.getApInvHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

			}
						
			cnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOCancelCSR02USQL(), param, velParam);

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
		
	}
	
	/** Invoice HDR정보 CSR 해제
	 * 
	 * @param event
	 * @return int
	 * @throws DAOException
	 */
	public int multiConfirmCSR01(EsdTes0100Event event) throws DAOException {
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		int cnt = 0;
		
		try {
			if(event.getApInvHdrVO() != null){
				Map<String, String> mapVO = event.getApInvHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("upd_usr_id", event.getSignOnUserAccount().getUsr_id());
				param.put("ofc_cd", event.getSignOnUserAccount().getUsr_id());
				
				if(event.getApInvHdrVO().getAttrCtnt1() != ""){
					param.put("inv_no", event.getApInvHdrVO().getAttrCtnt1()+"(2)");
					velParam.put("inv_no", event.getApInvHdrVO().getAttrCtnt1()+"(2)");
				}
			}
						
			cnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOMultiConfirmCSRUpdate01USQL(), param, velParam);

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
		
		return cnt;
	}
	
	/** CSR 취소 기록 처리
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void multiConfirmCSR02(EsdTes0100Event event) throws DAOException {
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			if(event.getApInvHdrVO() != null){
				Map<String, String> mapVO = event.getApInvHdrVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
						
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOMultiConfirmCSRUpdate02USQL(), param, velParam);

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
	}	


//	/** updateLEA 
//	 *
//	 * @param String csr_no
//	 * @throws DAOException
//	 */
//	public void updateLEA(String csr_no) throws DAOException {
//
//		log.debug("\n\n DAO.updateLEA - ########################################### ");
//
//		Connection con = null;
//		PreparedStatement updatePs1 = null;
//		PreparedStatement updatePs2 = null;
//
//		int i = 1;
//		int ins_cnt = 0;
//
//		StringBuffer updateQuery1 = new StringBuffer();
//		StringBuffer updateQuery2 = new StringBuffer();
//
//		updateQuery1.append(" INSERT INTO LEA_ACT_COST_IF                                                                                          		\n");
//		updateQuery1.append("   ( EXE_YRMON, INV_SYS_ID, IF_SEQ, GL_DT, REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD, REV_DIR_CD,							\n");
//		updateQuery1.append("	         ACT_VVD_CD, BKG_NO, BKG_NO_SPLIT, CNTR_NO, CNTR_TPSZ_CD, COST_ACT_GRP_CD, COST_ACT_GRP_SEQ, COA_COST_SRC_CD,	\n");
//		updateQuery1.append("	         LOCL_CURR_CD, LOCL_COST_AMT, USD_COST_AMT, REP_ACCT_CD, ACCT_CD, OTR_CRR_FLG, N1ST_THRP_INCL_COST_CD,			\n");
//		updateQuery1.append("	         N2ND_THRP_INCL_COST_CD, N3RD_THRP_INCL_COST_CD, CSR_NO, CSR_TP_CD, TTL_INV_KNT, INV_NO, INV_VNDR_SEQ,			\n");
//		updateQuery1.append("	         INV_CXL_FLG, INV_CXL_DT, TML_INV_TP_CD, TML_CALC_IND_CD, COP_NO, COST_ACT_GRP_TP_CD, N1ST_NOD_CD,				\n");
//		updateQuery1.append("	         N2ND_NOD_CD, N3RD_NOD_CD, N4TH_NOD_CD, ERR_VVD_APLY_FLG, ACT_COST_MAPG_CD, CRE_DT )							\n");
//		updateQuery1.append(" SELECT EXE_YRMON, INV_SYS_ID, LEA_ACT_COST_IF_SEQ.NEXTVAL IF_SEQ, GL_DT, REV_YRMON, VSL_CD, SKD_VOY_NO, SKD_DIR_CD,  \n");
//		updateQuery1.append("        REV_DIR_CD, ACT_VVD_CD, BKG_NO, BKG_NO_SPLIT, CNTR_NO, CNTR_TPSZ_CD, COST_ACT_GRP_CD, COST_ACT_GRP_SEQ,       \n");
//		updateQuery1.append("        COA_COST_SRC_CD, LOCL_CURR_CD, - LOCL_COST_AMT, 0 USD_COST_AMT, REP_ACCT_CD, ACCT_CD, OTR_CRR_FLG,                \n");
//		updateQuery1.append("        N1ST_THRP_INCL_COST_CD, N2ND_THRP_INCL_COST_CD, N3RD_THRP_INCL_COST_CD, CSR_NO, CSR_TP_CD,                    \n");
//		updateQuery1.append("        - TTL_INV_KNT, INV_NO, INV_VNDR_SEQ, 'Y' INV_CXL_FLG, sysdate INV_CXL_DT,                                     \n");
//		updateQuery1.append("        TML_INV_TP_CD, TML_CALC_IND_CD, COP_NO, COST_ACT_GRP_TP_CD, N1ST_NOD_CD, N2ND_NOD_CD, N3RD_NOD_CD,            \n");
//		updateQuery1.append("        N4TH_NOD_CD, ERR_VVD_APLY_FLG, ACT_COST_MAPG_CD, sysdate CRE_DT                                                \n");
//		updateQuery1.append(" FROM   LEA_ACT_COST_IF                                                                                               \n");
//		updateQuery1.append(" WHERE  CSR_NO        = ?                                                                                             \n");
//
//		updateQuery2.append(" UPDATE TES_TML_SO_HDR H			\n");
//		updateQuery2.append(" SET H.LEA_CXL_FLG = 'Y'                   \n");
//		updateQuery2.append(" WHERE H.CSR_NO = ?                        \n");
//		updateQuery2.append(" AND NVL(H.DELT_FLG,'N') <> 'Y'            \n");
//		
//		try {
//			
//			con = getConnection();
//
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				updatePs1 = new LoggableStatement(con, updateQuery1.toString());
//				updatePs2 = new LoggableStatement(con, updateQuery2.toString());
//			} else {
//				updatePs1 = con.prepareStatement(updateQuery1.toString());
//				updatePs2 = con.prepareStatement(updateQuery2.toString());
//			}
//
//			// LEA CANCEL 처리 (AP Reject?)
//			i = 1;
//			updatePs1.setString(i++, JSPUtil.getNull(csr_no));
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")){
//				log.info("\n SQL :" + ((LoggableStatement)updatePs1).getQueryString());
//			} else {
//				log.info("\n SQL :" + updateQuery1 );
//			}
//			
//			if ((ins_cnt = updatePs1.executeUpdate()) > 0){
//				// INVOICE의 LEA I/F STS를 변경
//				i = 1;
//				updatePs2.setString(i++, JSPUtil.getNull(csr_no));
//				updatePs2.executeUpdate();
//			}
//			log.debug("\n\n APRejct - updateLEA - insert cnt:"+ins_cnt+" ----------------------------- \n");
//
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch (DAOException de) {
//			log.error(de.getMessage(),de);
//			throw de;
//		} catch (Exception e) {
//			log.error(e.getMessage(),e);
//			throw new DAOException(e.getMessage());
//		} finally {
//			closeStatement(updatePs1);
//			closeStatement(updatePs2);
//			closeConnection(con);
//		}
//	}
	
	/** updateAPErrRsn01
	 * 
	 * @param csr_no
	 * @param err_rsn
	 * @throws DAOException
	 */
	public void updateAPErrRsn01(String csr_no, String err_rsn) throws DAOException {
		log.debug("\n\n DAO.updateAPErrRsn01 - ########################################### ");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			param.put("csr_no", csr_no);
			param.put("err_rsn", err_rsn);
						
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOUpdateAPErrRsn01USQL(), param, velParam);

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
	}
	
//	/** updateAPErrRsn02
//	 * 
//	 * @param csr_no
//	 * @param err_rsn
//	 * @throws DAOException
//	 */
//	public void updateAPErrRsn02(String csr_no, String err_rsn) throws DAOException {
//		log.debug("\n\n DAO.updateAPErrRsn02 - ########################################### ");
//		
//		Map<String, Object> param 		= new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam 	= new HashMap<String, Object>();
//		
//		try {
//			param.put("csr_no", csr_no);
//			param.put("err_rsn", err_rsn);
//						
//			new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOUpdateAPErrRsn02USQL(), param, velParam);
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
//	}
	

	/** updateLEA_REV_VVD_CNG
	 *
	 * @param leaRevVvdCngVO
	 * @param new_csr_no
	 * @throws DAOException
	 */
	public void updateLEA_REV_VVD_CNG(LeaRevVvdCngVO leaRevVvdCngVO, String new_csr_no) throws DAOException {
		log.debug("\n\n DAO.updateLEA_REV_VVD_CNG - ########################################### ");

		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			param.putAll(leaRevVvdCngVO.getColumnValues());
			velParam.putAll(leaRevVvdCngVO.getColumnValues());
			
			param.put("new_csr_no", new_csr_no);
						
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOUpdateLEA_REV_VVD_CNGUSQL(), param, velParam);

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
		
	}
	
	/**
	 * HPC용 SO HDR data update하기
	 * 
	 * @param csr_no String
	 * @param mode String
	 * @throws DAOException
	 */
	public void updateHPC(String csr_no, String mode) throws DAOException {
		log.debug("\n\n DAO.updateHPC - ########################################### ");

		if (mode==null || mode.trim().equals("")){
			throw new DAOException("unknown mode !!!!!!!");
		}
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			param.put("csr_no", csr_no);
			velParam.put("mode", mode);
						
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOUpdateHPCUSQL(), param, velParam);

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

	}	
	
	/**
	 * <중> GL_DT가 변경된 것이 확인되면 AP_INV_DTRB,Invoice의 DTL, CNTR_LIST의 재무항차 년월을 GL_DT기준으로 변경한다.
	 * AP_INV_IF는 별도로 수정하지 않고 searchINFtoAP()에서 AP I/F용으로 추출할때만 GL_DT처럼 변경 한다. 
	 * @param csr_no
	 * @throws DAOException
	 */
	public void updateRevVVD(String csr_no) throws DAOException {
		log.debug("\n\n - updateRevVVD "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"-------------------------------------------    \n\n\n");
		log.debug("\n updateRevVVD - csr_no:"+csr_no+"\n");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		Map resultMap = null;
		
		String retval = "";
		try{
			param.put("csr_no", csr_no);
			param.put("retval", retval);
        	log.error("\n TES_CSR_UPDATE_REVVVD_PRC - executed !!!!!!!! "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n");

			resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new CARIssueTransferSlipManageDBDAOUpdateRevVVDUSQL(), param, velParam);
        	log.error("\n TES_CSR_UPDATE_REVVVD_PRC - done !!!!!!!! "+((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date()))+"\n\n");
			
			retval = (String)resultMap.get("retval");			
        	log.error("\n\n\n TES_CSR_UPDATE_REVVVD_PRC - retval:"+(retval!=null?retval:"")+"<<<<<\n\n");
        				
			 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			//throw new DAOException(new ErrorHandler("TPB00037").getMessage());
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	
	/** 
	 * updateApInvHdrPDTApproval : AP_INV_HDR의 부수적인 사항을 UPDATE한다.
	 * 
	 * @param csr_no
	 * @throws DAOException
	 */
	public void updateApInvHdrPDTApproval(String csr_no) throws DAOException {
		log.debug("\n Begin updateApInvHdrPDTApproval ============================\n ");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			param.put("csr_no", csr_no);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOUpdateApInvHdrPDTApprovalUSQL(), param, velParam);
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
	}	
	
	/**
	 * 환율 상태 확인 : AP_INV_HDR에 PDT결재 관련 부수적인 사항 UPDATE후에 USD환율이 NULL이거나 해당기간에 USD 환율변환이 안되는 상태면 띵긴다.
	 * 
	 * @param csr_no
	 * @throws DAOException
	 */
	public void checkUSDExchSts(String csr_no) throws DAOException {
		log.debug("\n Begin checkUSDExchSts ============================\n ");
		
		DBRowSet 			dbRowSet	= null;
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		String retval = null;
		
		try {
			param.put("csr_no", csr_no);
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOCheckUSDExchStsRSQL(), param, velParam);

			if (dbRowSet.next()){
				retval = dbRowSet.getString("RETVAL");
			}

			if (retval==null || !retval.trim().equals("Y")){
				log.debug("\n\n checkUSDExchSts : retval : " + JSPUtil.getNull(retval) + "\n\n");
				throw new DAOException("INVALID EXCHANGE STATUS!!!!");	
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw new DAOException(new ErrorHandler(de).getMessage(), de);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	/**** YOO. 끝 *****/
	
    /**
	 * groupware 전송 xmlData Header info<br>
	 * @author 김영신
	 * @category printComCsrHeaderInfo 
	 * @param String csrNo
     * @return ComCsrRequestHeaderVO 
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public ComCsrRequestHeaderVO printComCsrHeaderInfo(String csrNo) throws DAOException {
    	DBRowSet dbRowset = null;      
        List<ComCsrRequestHeaderVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Cargo Claim No
        	param.put("csr_no", csrNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOPrintComCsrHeaderInfoRSQL(), param, velParam);           
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComCsrRequestHeaderVO.class);
            
            if (list != null && !list.isEmpty()) {
            	return list.get(0);
            }
            
            return null;
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
    }  
    
    /**
	 * groupware 전송 xmlData Body info<br>
	 * @author 김영신
	 * @category printComCsrBodyInfo 
	 * @param String csrNo
     * @return List<ComCsrRequestBodyVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ComCsrRequestBodyVO> printComCsrBodyInfo(String csrNo) throws DAOException {
    	DBRowSet dbRowset = null;     
        List<ComCsrRequestBodyVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Cargo Claim No
        	param.put("csr_no", csrNo);        	
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOPrintComCsrBodyInfoRSQL(), param, velParam);          
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComCsrRequestBodyVO.class);         
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }        
        return list;      
    }  
    
    /**
	 * groupware 전송 xmlData Agreement info<br>
	 * @author 김영신
	 * @category printComCsrAgmtInfo 
	 * @param String csrNo
     * @return List<ComCsrRequestAgmtVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ComCsrRequestAgmtVO> printComCsrAgmtInfo(String csrNo) throws DAOException {
    	DBRowSet dbRowset = null;     
        List<ComCsrRequestAgmtVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  csr No
        	param.put("csr_no", csrNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOPrintComCsrAgmtInfoRSQL(), param, velParam);          
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComCsrRequestAgmtVO.class);         
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }        
        return list;      
    }  
    
    /**
	 *  Agreement info<br>
	 * @author 김영신
	 * @category printComCsrAgmtInfo2 
	 * @param String csrNo
     * @return List<ComCsrRequestAgmtVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ComCsrRequestAgmtVO> printComCsrAgmtInfo2(String csrNo) throws DAOException {
    	DBRowSet dbRowset = null;     
        List<ComCsrRequestAgmtVO> list = null;        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  csr No
        	param.put("csr_no", csrNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOPrintComCsrAgmtInfo2RSQL(), param, velParam);          
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComCsrRequestAgmtVO.class);         
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }        
        return list;      
    }  
    
    /**
	 *  Duplication Info Of Invoice No<br>
	 * @author 
	 * @category 
	 * @param String csrNo
     * @return String
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public String searchDupInvoiceNo(String csrNo) throws DAOException {
    	DBRowSet dbRowset = null;     
    	String invNo = "";        
       
        try{    
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  csr No
        	param.put("csr_no", csrNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOSearchDupInvoiceNoRSQL(), param, velParam);          
            
            if (dbRowset != null) {
            	while(dbRowset.next()){
            		invNo = dbRowset.getString("inv_no");
            	}
            }
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }        
        return invNo;      
    }  
    
	public void updateApInvHdrPDT(String csr_no) throws DAOException {
		log.debug("\n Begin updateApInvHdrPDTApproval ============================\n ");
		
		Map<String, Object> param 		= new HashMap<String, Object>();
		Map<String, Object> velParam 	= new HashMap<String, Object>();
		
		try {
			param.put("csr_no", csr_no);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CARIssueTransferSlipManageDBDAOUpdateApInvHdrPDTApprovalUSQL(), param, velParam);
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
	}
	
	/** getCancelledBkgNoList 를 가져온다.
	 * 
	 * @param 	TesTmlSoHdrVO tesTmlSoHdrVO
	 * @param 	ap_ofc_cd
	 * @return  DBRowSet
	 * @throws 	DAOException
	 */
	public DBRowSet getCancelledBkgNoList(TesTmlSoHdrVO tesTmlSoHdrVO) throws DAOException {
		log.debug("\n\n DAO.getCancelledBkgNoList -------------------------------\n");

		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(tesTmlSoHdrVO != null){
				param.putAll(tesTmlSoHdrVO.getColumnValues());
				velParam.putAll(tesTmlSoHdrVO.getColumnValues());
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CARIssueTransferSlipManageDBDAOGetCancelledBkgNoListRSQL(), param, velParam);

		} catch (SQLException se) {
			log.debug("#####################se.getMessage()============>"+se.getMessage());
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
	 * modifyCancelledBkgNo 수정한다.<br>
	 *
	 * @param  voList List<TesTmlSoCntrListVO>
	 * @throws DAOException
	 */
	public void modifyCancelledBkgNo(List<TesTmlSoCntrListVO> voList) throws DAOException {
		log.debug("\n\n DAO.modifyCancelledBkgNo -------------------------------\n");

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new CARIssueTransferSlipManageDBDAOModifyCancelledBkgNoUSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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

	}

}
