/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ConsultationSlipRequestMgtDBDAO.java
*@FileTitle : CSR Creation - Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 함대성
*@LastVersion : 1.0
* 2009.07.01 함대성
* 1.0 Creation
* ---------------------------------------------------------
* History
* 2010.08.31 김영철 [CHM-201005571-01] [VOP-PSO] 공통 CSR내 Invoice 조건 칼럼 추가요청건
* 2010.08.31 김영철 [] R4J 에서 메소드 주석 수정부분 수정함.
* 2010.10.12 김영철 [] Invoices인 경우에 RcvDt 값이 저장되도록 수정함.
* 2010.10.18 김영철 [CHM-201006348-01] CSR 전표 Remark 보완 - INV_DESC 추가
* 2010.10.25 김영철 [] 메소드 주석부분 철자가 틀려 수정함.
* 2010.11.05 김영철 [] DBDAO에 SQL문이 있어 작업함. 
* 2011.10.20 민정호 [CHM-201113843] 공통 CSR R4J Rule 품질결함 조치
* 2014.11.19 김영신 [CHM-201432872] 10만불 이상 G/W연동 관련 로직 추가
=========================================================*/
package com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.integration;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hanjin.bizcommon.approval.util.ApprovalUtil;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.basic.ConsultationSlipRequestMgtBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.ApInvDtrbVO;
import com.hanjin.syscommon.common.table.ComAproCsrDtlVO;
import com.hanjin.syscommon.common.table.ComAproRqstHdrVO;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.ApPayInvListVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.AsaNoVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.AutoRevVVDListVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CSRSOhdrVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CSRSOlistVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CheckAsaVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CreateApInvDTRBASANoSelectVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CsrListInputVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CsrParmVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.DtrbListVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.HdrVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.IfCsrListInputVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.SearchDTRBTtlVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.SrchPayGrpLuCdVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.TAXInfoVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.PayInvVO;


/**
 * ALPS ConsultationSlipRequestMgtDBDAO <br>
 * - ALPS-ConsultationSlipRequestMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author HAM DAE SUNG
 * @see ConsultationSlipRequestMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class ConsultationSlipRequestMgtDBDAO extends DBDAOSupport {

	/**
	 * COM_CSR_0004,5 : 조회버튼 <br>
	 * csr_no 생성시 default ofc를 조회한다.
	 * @param String ofc_cd
	 * @return String
	 * @exception DAOException
	 */
	public String getDefOfc(String ofc_cd) throws DAOException {
		String defOfc = "";
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;

		try{
			param.put("ofc_cd",JSPUtil.getNull(ofc_cd));
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOGetDefOfcRSQL(),param,velParam);
			if (dbRowset!=null) {
				if (dbRowset.next()) {
   	         		defOfc = JSPUtil.getNull(dbRowset.getString("def_ofc"));
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return defOfc;
	}
	
	/**
	 * COM_CSR_0001 : 조회버튼 <br>
	 * CSR Creation의 리스트를 조회합니다
	 * @param ApPayInvListVO apPayInvListVO
	 * @return List<ApPayInvListVO>
	 * @exception DAOException
	 */
	public List<ApPayInvListVO> searchCsrList (ApPayInvListVO apPayInvListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ApPayInvListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(apPayInvListVO != null){
				Map<String, String> mapVO = apPayInvListVO .getColumnValues();
				mapVO.put("inv_ofc_cd", 	apPayInvListVO.getInvOfcCd());
				mapVO.put("inv_cfm_dt", 	apPayInvListVO.getInvCfmDt());
				mapVO.put("vndr_seq",   	apPayInvListVO.getVndrSeq());
				mapVO.put("inv_sub_sys_cd", apPayInvListVO.getInvSubSysCd());

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOApPayInvListRSQL(), param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApPayInvListVO.class);
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
	 * CSR_0001 : 화면로드<br>
	 * CSR Creation의  A/P, ASA 체크<br>
	 * @param CheckAsaVO checkAsaVO
	 * @return List<CheckAsaVO>
	 * @exception DAOException
	 */
	 public List<CheckAsaVO> checkAsaOffice(CheckAsaVO checkAsaVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CheckAsaVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			if(checkAsaVO.getAsaGubun().equals("O")){
				mapVO.put("inv_ofc_cd", checkAsaVO.getCostOfcCd());
			}else{
				mapVO.put("inv_ofc_cd", checkAsaVO.getInvOfcCd());
			}
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOCheckAsaRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CheckAsaVO .class);
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
	 * COM_CSR_0002 : 조회버튼 <br>
	 * CSR Creation(Detail)의 리스트를 조회합니다.<br>
	 * @param CsrListInputVO csrListInputVO
	 * @return List<CsrListInputVO>
	 * @exception DAOException
	 */
	public List<CsrListInputVO> searchCSRSummaryDetail (CsrListInputVO csrListInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CsrListInputVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(csrListInputVO != null){
				Map<String, String> mapVO = csrListInputVO .getColumnValues();
				mapVO.put("cost_ofc_cd", csrListInputVO.getCostOfcCd());
				mapVO.put("inv_ofc_cd",  csrListInputVO.getInvOfcCd());
				mapVO.put("vndr_seq", 	 csrListInputVO.getVndrSeq());
				mapVO.put("inv_sub_sys_cd", csrListInputVO.getInvSubSysCd());

				mapVO.put("inv_curr_cd", csrListInputVO.getInvCurrCd());
				mapVO.put("inv_sts_cd",  csrListInputVO.getInvStsCd());
				mapVO.put("inv_rjct_sts_cd", csrListInputVO.getInvRjctStsCd());
				mapVO.put("inv_cfm_dt",  csrListInputVO.getInvCfmDt());
				
				mapVO.put("pso_trns_slp_ctnt",  csrListInputVO.getPsoTrnsSlpCtnt());

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOCsrListInputRSQL(), param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CsrListInputVO.class);
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
	 * COM_CSR_0002 : 인보이스 삭제여부 체크 <br>
	 * CSR Creation(Detail)의 리스트를 조회합니다.<br>
	 * @param invRgstNo
	 * @return String
	 * @exception DAOException
	 */
	public String verifyInvoiceDeltChk (String invRgstNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		String inv_no= "";

		try{

			param.put("inv_rgst_no", invRgstNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOVerifyInvoiceDeltChkRSQL(), param, param);
			while(dbRowset.next()){
				inv_no = dbRowset.getString("INV_NO");
			}

			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return inv_no;
	}
	
	
	/**
	 * COM_CSR_0002 : 결재 유형 변경 가능한 Office인지 확인 (ALPS->GW) <br>
	 * Approval Type 설정용
	 * @param String ofcCd
	 * @param String csrNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchAl2GwOfc (String ofcCd, String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		String retVal= "";

		try{
			param.put("login_ofc_cd", ofcCd);
			param.put("csr_no", csrNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOSearchAl2GwOfcRSQL(), param, param);
			while(dbRowset.next()){
				retVal = dbRowset.getString("CHK_OFC");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;
	}
	
	
	

	/**
	 * COM_CSR_0002 : 조회버튼 <br>
	 * CSR Creation(Detail)의 리스트를 조회합니다.<br>
	 * @param String invOfcCd
	 * @param String apOfcCd
	 * @param String issDt
	 * @return List<AsaNoVO>
	 * @exception DAOException
	 */
	 public List<AsaNoVO> searchAsaNoList(String invOfcCd, String apOfcCd, String issDt) throws DAOException {
	 	DBRowSet dbRowset = null;
	 	List<AsaNoVO> list = null;
	 	// query parameter
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	// velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();

	 	try {
	 		 Map<String, String> mapVO = new HashMap<String, String>();
	 		 mapVO.put("inv_ofc_cd", invOfcCd);
	 		 mapVO.put("ap_ofc_cd", apOfcCd);
	 		 mapVO.put("iss_dt", issDt);

	 		 param.putAll(mapVO);
	 		 velParam.putAll(mapVO);
	 		 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ConsultationSlipRequestMgtDBDAOAsaNoRSQL(),	param, velParam);
	 		 list = (List) RowSetUtil.rowSetToVOs(dbRowset, AsaNoVO.class);
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
	 * COM_CSR_0004 : 화면 로드
	 * EviCode 콤보리스트 조회
	 * @return List<TAXInfoVO>
	 * @throws DAOException
	 */
	 public List<TAXInfoVO> searchEviCodeList() throws DAOException {
	 	DBRowSet dbRowset = null;
	 	List<TAXInfoVO> list = null;
	 	// query parameter
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	// velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();

	 	try {
	 		 Map<String, String> mapVO = new HashMap<String, String>();
	 		 //mapVO.put("vndr_seq", vndrSeq);

	 		 param.putAll(mapVO);
	 		 velParam.putAll(mapVO);
	 		 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ConsultationSlipRequestMgtDBDAOEviCodeListRSQL(),	param, velParam);
	 		 list = (List) RowSetUtil.rowSetToVOs(dbRowset, TAXInfoVO.class);
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
		 * COM_CSR_0004 : 화면로드 또는 사업자등록번호 기입 <br>
		 * 사업자등록번호, Vendor Code, 상호, 업태, 주소, 대표자명 조회
		 * @param String compNo
		 * @return List<TAXInfoVO>
		 * @exception DAOException
		 */
		 public List<TAXInfoVO> searchTAXInfo(String compNo) throws DAOException {
			DBRowSet dbRowset = null;
			List<TAXInfoVO> list = null;

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("comp_no", compNo);

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOTAXInfoRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, TAXInfoVO .class);
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
		 * COM_CSR_0004 evid_no 채번및저장 
		 * @param String taxNo1
		 * @param String taxNo2
		 * @return String
		 * @throws DAOException
		 */
		public String searchApEviNo(String taxNo1, String taxNo2) throws DAOException {
			DBRowSet dbRowset = null;
			String eviNo = "";
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("tax_no1", taxNo1);
				mapVO.put("tax_no2", taxNo2);

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOsearchApEviNoRSQL(), param, velParam);
				while(dbRowset.next()){
					eviNo = dbRowset.getString("tax_no3");
	            }
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return eviNo;
		}
		
		/**
		 * COM_CSR_0004 : 화면로드 <br>
		 * 사업자등록번호 조회 
		 * @param TAXInfoVO tAXInfoVO
		 * @return String
		 * @exception DAOException
		 */
		public String searchCompNo(TAXInfoVO tAXInfoVO) throws DAOException {
			DBRowSet dbRowset = null;
			String compNo = "";
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("vndr_seq", tAXInfoVO.getVndrSeq());

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOSearchCompNoRSQL(), param, velParam);
				while(dbRowset.next()){
					compNo = dbRowset.getString("rgst_no");
	            }
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return compNo;
		}

		/**
		 * COM_CSR_0004, COM_CSR_0005 : addApEviNo<br>
		 * addApEviNo
		 * @param TAXInfoVO tAXInfoVO
		 * @throws DAOException
		 */
		public void addApEviNo (TAXInfoVO tAXInfoVO) throws DAOException {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");

				if(tAXInfoVO != null){
					//query parameter
			        Map<String, String> param = tAXInfoVO.getColumnValues();
			        int result = sqlExe.executeUpdate((ISQLTemplate) new ConsultationSlipRequestMgtDBDAOAddApEviNoRSQL() , param, null);

					if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
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
		 * COM_CSR_0004 : 완료버튼 <br>
		 * 세금계산서 TAXCode 조회 
		 * @param TAXInfoVO tAXInfoVO
		 * @return List<TAXInfoVO>
		 * @exception DAOException
		 */
		 public List<TAXInfoVO> searchTAXCode(TAXInfoVO tAXInfoVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<TAXInfoVO> list = null;

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				Map<String, String> mapVO = new HashMap<String, String>();
				
				if(tAXInfoVO != null){
					mapVO.put("tax_type", tAXInfoVO.getTaxType());
					mapVO.put("fa_flg", tAXInfoVO.getFaFlg());
					mapVO.put("tax_naid_flg", tAXInfoVO.getTaxNaidFlg());
					mapVO.put("tax_nsl_flg", tAXInfoVO.getTaxNslFlg());
				}

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOTAXCodeRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, TAXInfoVO .class);
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
		 * COM_CSR_0008 : 조회버튼 <br>
		 * CSR I/F Inquiry 의 리스트를 조회합니다.<br>
		 * @param IfCsrListInputVO ifCsrListInputVO
		 * @return List<IfCsrListInputVO>
		 * @exception DAOException
		 */
		public List<IfCsrListInputVO> searchCsrIfList (IfCsrListInputVO ifCsrListInputVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<IfCsrListInputVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(ifCsrListInputVO != null){
					Map<String, String> mapVO = ifCsrListInputVO .getColumnValues();
					String searchCsrNo = ifCsrListInputVO.getSearchCsrNo();
					String dtStatus = ifCsrListInputVO.getDtStatus();
					String fmEffDt = ifCsrListInputVO.getFmEffDt();
					String toEffDt = ifCsrListInputVO.getToEffDt();
					String ifStatus = ifCsrListInputVO.getIfStatus();
					String invSubSysCd = ifCsrListInputVO.getInvSubSysCd();
					String ifNo = ifCsrListInputVO.getIfNo();
					String searchTpCd = ifCsrListInputVO.getSearchTpCd();
					
					String srcCtnt = "";
					
					if(searchCsrNo == null) searchCsrNo="";
					if(dtStatus == null) dtStatus="";
					if(fmEffDt == null)	fmEffDt="";
					if(toEffDt == null)	toEffDt="";
					if(ifStatus == null) ifStatus="";
					if(ifNo == null) ifNo="CSR";					
										
					if(invSubSysCd.equals("MNR")){
						srcCtnt	=	"SO_M&R";
					}else if(invSubSysCd.equals("TLL")){
						srcCtnt	=	"EQ";
					}else if(invSubSysCd.equals("LSE")){
						srcCtnt	=	"SO_LEASE";
					}else if(invSubSysCd.equals("PSO")){
						srcCtnt	=	"SO_PORT";
					}else if(invSubSysCd.equals("CHS")){
						srcCtnt	=	"SO_CHASSIS";
					}else if(invSubSysCd.equals("MGS")){
						srcCtnt	=	"SO_MGSET";
					}else if(invSubSysCd.equals("CNI")){
						srcCtnt	=	"SO_CCC";
					}
					mapVO.put("ofc_cd", ifCsrListInputVO.getOfcCd());
					mapVO.put("fm_eff_dt", fmEffDt);
					mapVO.put("to_eff_dt", toEffDt);
					mapVO.put("search_csr_no", searchCsrNo);
					mapVO.put("dt_status", dtStatus);
					mapVO.put("if_status", ifStatus);
					mapVO.put("src_ctnt",  srcCtnt);
					mapVO.put("if_no", ifNo);
					mapVO.put("search_tp_cd", searchTpCd);
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOIfCsrListInputVORSQL(), param, velParam);

				list = (List)RowSetUtil.rowSetToVOs(dbRowset, IfCsrListInputVO.class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}

		 /*************************************************************************************************************************************************************
		  ***************************************************** !! Approval Request Before Step Start !!  *************************************************************
		  *************************************************************************************************************************************************************/
/**
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * 5. R.VVD LEVEL CHECK 2009-09 추가
 * @param String csrNo
 * @exception DAOException
 */
public void searchApInvVVDChacke(String csrNo) throws DAOException {
	DBRowSet dbRowset = null;
	String output_text = null;
	Map<String, Object> mapVO = new HashMap<String, Object>();
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();

	try{

		mapVO.put("csr_no", 		csrNo);

		param.putAll(mapVO);
		velParam.putAll(mapVO);

		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOSearchApInvVVDChackeRSQL(), param, velParam);
		
		if(dbRowset!=null && dbRowset.next()){
			output_text = dbRowset.getString("OUTPUT_TEXT");
			if (output_text !=null && output_text.length()>0){
				log.error("\n\n " + output_text + "\n\n");
				throw new DAOException((new ErrorHandler("CSR00025", new String[]{output_text}).getMessage()));
			}
		}
	}catch(SQLException se){
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
	return;
}

/**
 * ConsultationSlipRequestMgtDBDAOAutoRevVVDListRSQL 쿼리수정 -> 삭제테이블 적용 2009-09-28
 * @param Collection<PayInvVO> payInvVOs
 * @param CsrParmVO csrParmVO
 * @return DBRowSet[]
 * @throws DAOException
 */
public DBRowSet[] getAutoRevVVDList(Collection<PayInvVO> payInvVOs, CsrParmVO csrParmVO) throws DAOException {
	log.debug("\n\n DAO.getAutoRevVVDList -------------------------------\n");

	DBRowSet dRs = null;
	DBRowSet[] dRsArr = null; 
	int dRsCnt = 0;
	//String ap_ofc_cd = param_map!=null?(param_map.get("ap_ofc_cd")!=null?(String)param_map.get("ap_ofc_cd"):""):"";
	//log.debug("\n### ap_ofc_cd:"+ap_ofc_cd + "<<<<<");

	Map<String, Object> mapVO = new HashMap<String, Object>();
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();

	try{
		dRsArr = new DBRowSet[payInvVOs.size()];
		Iterator itr = payInvVOs.iterator();
		PayInvVO model = null;

		while (itr.hasNext()) {
			model = (PayInvVO)itr.next();
    		if(!model.getIbflag().equals("")){
				mapVO.put("ap_ofc_cd", JSPUtil.getNull(csrParmVO.getApOfcCd() ));
				mapVO.put("inv_no",    JSPUtil.getNull(model.getInv_no	   () ));
				mapVO.put("vndr_seq",  JSPUtil.getNull(model.getVndr_seq   () ));
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
    		}

			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOAutoRevVVDListRSQL(), param, velParam);

			dRsArr[dRsCnt] = dRs;
			dRsCnt++;
		}
	}catch(SQLException se){
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
	return dRsArr;
}

/**
 * COM_CSR_0002 : modifyAutoRevVVD<br>
 * modifyAutoRevVVD
 * @param List<AutoRevVVDListVO> autoRevVVDListVO
 * @throws DAOException
 */
public void modifyAutoRevVVD(List<AutoRevVVDListVO> autoRevVVDListVO) throws DAOException {
	log.debug("\n\n DAO.modifyAutoRevVVD -------------------------------\n");
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	try { 
		int updCnt[] = null;
		SQLExecuter sqlExe = new SQLExecuter(""); 
		 
		updCnt = sqlExe.executeBatch((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOModifyAutoRevVVDUSQL(), autoRevVVDListVO, velParam);
		for(int j = 0; j < updCnt.length; j++){
			if(updCnt[j]== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert No1"+ j + " SQL");
		}
		
	} catch (SQLException se) {
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	} catch (DAOException de) {
		log.error(de.getMessage(), de);
		throw de;
	} catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
}

/**
 * COM_CSR_0002 : modifyPSORevVVD<br>
 * modifyPSORevVVD
 * @param List<AutoRevVVDListVO> autoRevVVDListVO
 * @throws DAOException
 */
public void modifyPSORevVVD(List<AutoRevVVDListVO> autoRevVVDListVO) throws DAOException {
	log.debug("\n\n DAO.modifyPSORevVVD -------------------------------\n");
	
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	
	try { 
		int 		updCnt[] 	= null;
		SQLExecuter sqlExe 		= new SQLExecuter(""); 
		 
		updCnt 					= sqlExe.executeBatch((ISQLTemplate)new ConsultationSlipRequestMgtDAOModifyPSORevVVDUSQL(), autoRevVVDListVO, velParam);
		
		for(int j = 0; j < updCnt.length; j++){
			if(updCnt[j] == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert No1"+ j + " SQL");
		}
		
	} catch (SQLException se) {
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	} catch (DAOException de) {
		log.error(de.getMessage(), de);
		throw de;
	} catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
}

/**
 * COM_CSR_0002 : searchApInvDTRBIn<br>
 * 국내 searchApInvDTRBIn
 * @param Collection<PayInvVO> payInvVOs
 * @param CsrParmVO csrParmVO
 * @return DBRowSet[]
 * @throws DAOException
 */
public DBRowSet[] searchApInvDTRBIn(Collection<PayInvVO> payInvVOs, CsrParmVO csrParmVO) throws DAOException {
	log.debug("\n\n DAO.searchApInvDTRBIn -------------------------------\n");

	DBRowSet dRs = null;
	DBRowSet[] dRsArr = null;
	int dRsCnt = 0;
	String vndr_seq			= csrParmVO.getVndrSeq();
	String ofc_cd			= csrParmVO.getInvOfcCd();
	int line_seq = 1;
	log.debug("\n### vndr_seq:"+vndr_seq + ",  ofc_cd :" +ofc_cd+ "<<<<<");

	Map<String, Object> mapVO = new HashMap<String, Object>();
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();

	try{
		dRsArr = new DBRowSet[payInvVOs.size()];
		Iterator itr = payInvVOs.iterator();
		PayInvVO model = null;

		while (itr.hasNext()) {
			model = (PayInvVO)itr.next();
    		if(!model.getIbflag().equals("")){
				//mapVO.put("vndr_seq",  JSPUtil.getNull(vndr_seq ));
				mapVO.put("ofc_cd",    JSPUtil.getNull(ofc_cd ));
				mapVO.put("line_seq",  String.valueOf(line_seq));
				mapVO.put("inv_tax_cd","");

				mapVO.put("inv_no",    JSPUtil.getNull(model.getInv_no	 () ));
				mapVO.put("vndr_seq",  JSPUtil.getNull(model.getVndr_seq () ));
				mapVO.put("cre_usr_id",JSPUtil.getNull(model.getCre_usr_id()));

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//2009-11-23 쿼리 수정
				dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOApInvDTRBInRSQL(), param, velParam);
    			
				dRsArr[dRsCnt] = dRs;
				dRsCnt++;
    		}
    		line_seq++;

		}
	}catch(SQLException se){
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
	return dRsArr;
}
 
/**
 * COM_CSR_0002 : searchApInvDTRBIn<br>
 * 국외 searchApInvDTRBIn
 * @param Collection<PayInvVO> payInvVOs
 * @param CsrParmVO csrParmVO
 * @return DBRowSet[]
 * @throws DAOException
 */
public DBRowSet[] searchApInvDTRBOut(Collection<PayInvVO> payInvVOs, CsrParmVO csrParmVO) throws DAOException {
	log.debug("\n\n DAO.searchApInvDTRBOut -------------------------------\n");

	DBRowSet dRs = null;
	DBRowSet[] dRsArr = null;
	int dRsCnt = 0;
	int line_seq = 1;
	String cnt_cd			= csrParmVO.getCntCd();
	String vndr_seq			= csrParmVO.getVndrSeq();
	String evi_gb			= csrParmVO.getEviGb();
	String ofc_cd			= csrParmVO.getOfcCd();
	String evi_tax_code		= csrParmVO.getEviTaxCode();
	log.debug("\n### vndr_seq:"+vndr_seq + ",  ofc_cd :" +ofc_cd+ ",  cnt_cd :" +cnt_cd+ ",  evi_gb :" +evi_gb+ ",  evi_tax_code :" +evi_tax_code+ "<<<<<");

	Map<String, Object> mapVO = new HashMap<String, Object>();
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();

	try{
		dRsArr = new DBRowSet[payInvVOs.size()];
		Iterator itr = payInvVOs.iterator();
		PayInvVO model = null;

		while (itr.hasNext()) {
			model = (PayInvVO)itr.next();
    		if(!model.getIbflag().equals("")){
				mapVO.put("ofc_cd",    JSPUtil.getNull(ofc_cd ));				//ofc_cd
				mapVO.put("line_seq",  String.valueOf(line_seq));				//line_seq
				mapVO.put("cre_usr_id",JSPUtil.getNull(model.getCre_usr_id()));	//cre_usr_id
				mapVO.put("inv_no",    JSPUtil.getNull(model.getInv_no	 () ));	//inv_no
				mapVO.put("vndr_seq",  JSPUtil.getNull(vndr_seq ));				//vndr_seq

				if (cnt_cd.equals("KR")){
					if (evi_gb.equals("1")){
						mapVO.put("inv_tax_cd",String.valueOf(evi_tax_code));	//inv_tax_cd
					} else if (evi_gb.equals("2")){
						mapVO.put("inv_tax_cd","매입계산서");   					//inv_tax_cd
					} else{
						mapVO.put("inv_tax_cd","");   							//inv_tax_cd
					}
				} else {
					mapVO.put("inv_tax_cd","");   								//inv_tax_cd
				}

				param.putAll(mapVO);
				velParam.putAll(mapVO);
    		}
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOApInvDTRBOutRSQL(), param, velParam);

			dRsArr[dRsCnt] = dRs;
			dRsCnt++;
			
			line_seq++;
		}
	}catch(SQLException se){
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}

	return dRsArr;
}

		 /*************************************************************************************************************************************************************
		  ****************************************************** !! Approval Request Before Step End !!  **************************************************************
		  *************************************************************************************************************************************************************/


		 /*************************************************************************************************************************************************************
		  *********************************************************	!! Approval Request Step Start !!  ****************************************************************
		  *************************************************************************************************************************************************************/

/**
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * 각 데이터 CHECK  후 없는 경우 Exception 발생 시켜  더이상 진행시키지 않음 - mdm_organization
 * @param CsrParmVO csrParmVO
 * @return CSRSOhdrVO
 * @exception DAOException
 */
public CSRSOhdrVO searchApInvCheck1(CsrParmVO csrParmVO) throws DAOException {
	DBRowSet dbRowset = null;
	List<CSRSOhdrVO> list = null;
	CSRSOhdrVO rtnVO = null;

	String ofc_cd 		= csrParmVO.getCostOfcCd();

	Map<String, Object> mapVO = new HashMap<String, Object>();
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();

	try{
		mapVO.put("ofc_cd", 		ofc_cd);

		param.putAll(mapVO);
		velParam.putAll(mapVO);

		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOsearchApInvChacke1RSQL(), param, velParam);

		list = (List)RowSetUtil.rowSetToVOs(dbRowset, CSRSOhdrVO.class);

		if(list.size() > 0){	//csr_no 번호따오기
			rtnVO = (CSRSOhdrVO)list.get(0);
		}
	}catch(SQLException se){
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}

	return rtnVO;
}
 
/**
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * ACCT_CD(비용코드)
 * @param Collection<PayInvVO> payInvVOs
 * @exception DAOException
 */ 
public void searchApInvCheck2(Collection<PayInvVO> payInvVOs) throws DAOException {
	DBRowSet dRs = null;
	List<CSRSOhdrVO> list = null;
	CSRSOhdrVO rtnVO = null;
	int i = 0;
	int acctCdCount = 0;

	Map<String, Object> mapVO = new HashMap<String, Object>();
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();

	try{
		Iterator itr = payInvVOs.iterator();
		PayInvVO model = null;

		while (itr.hasNext()) {
			model = (PayInvVO)itr.next();
    		if(!model.getIbflag().equals("")){
				mapVO.put("inv_no",    JSPUtil.getNull(model.getInv_no	 () ));
				mapVO.put("vndr_seq",  JSPUtil.getNull(model.getVndr_seq () ));

				param.putAll(mapVO);
				velParam.putAll(mapVO);
    		}

			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOsearchApInvChacke2RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dRs, CSRSOhdrVO.class);

			rtnVO = (CSRSOhdrVO)list.get(0);
			acctCdCount = Integer.parseInt(rtnVO.getCount())+acctCdCount;
			i++;
		}

		if( acctCdCount > 0 ){
			throw new DAOException(new ErrorHandler("CSR00024").getMessage());
		}
	}catch(SQLException se){
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}

	return;
}

/**
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * csr_no 생성: csrNo 채번후 ap_csr_no 테이블에 insert / >>>>>>>물류와 장비 두개의 구분으로 CSR_NO 채번 [SM]
 * @param String ofcCd
 * @param String csrTpCd
 * @return String
 * @exception DAOException
 */
public String multiCSRNo(String ofcCd, String csrTpCd) throws DAOException {
	DBRowSet dbRowset = null;
	String csrNo = "";
	Map<String, Object> mapVO = new HashMap<String, Object>();
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();

	try{
		//mapVO.put("bigo",  JSPUtil.getNull(bigo));
		mapVO.put("csr_tp_cd", 		csrTpCd);
		mapVO.put("ofc_cd", 		ofcCd);

		param.putAll(mapVO);
		velParam.putAll(mapVO);

		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOMultiCSRNoRSQL(), param, velParam);
		
		if(dbRowset!=null && dbRowset.next()){
			csrNo = dbRowset.getString("csr_no");
		}
	}catch(SQLException se){
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
	return csrNo;
}

/** multiCSRInsert CSR건들을 다중으로 넣는다.
 * @param ofcCd
 * @param csrNo
 * @param creUsrId
 * @throws DAOException
 */
public void multiCSRInsert(String ofcCd, String csrNo, String creUsrId) throws DAOException {
	log.debug("start multiCSRInsert ============================");
	Map<String, Object> mapVO = new HashMap<String, Object>();
	//query parameter
	Map<String, Object> param 		= new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam 	= new HashMap<String, Object>();
	try {
		mapVO.put("ofc_cd", ofcCd);
		mapVO.put("csr_no", csrNo);
		mapVO.put("cre_usr_id", creUsrId);
		
		param.putAll(mapVO);
		velParam.putAll(mapVO);
		
		new SQLExecuter("").executeUpdate((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOMultiCSRNoCSQL(), param, velParam);

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
 * AP_INV_HDR의 부수적인 사항을 UPDATE한다.
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
		new SQLExecuter("").executeUpdate((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOUpdateApInvHdrPDTApprovalUSQL(), param, velParam);
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
		dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOCheckUSDExchStsRSQL(), param, velParam);

		if (dbRowSet.next()){
			retval = dbRowSet.getString("RETVAL");
		}
		log.debug("\n\n retval : " + retval + "\n\n");
		if (retval==null || !retval.trim().equals("Y")){
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

/**
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * AP HDR 및 DTRB INSERT
 * @param CsrParmVO csrParmVO
 * @param String creUsrId
 * @exception DAOException
 */
public void createApInvHDR(CsrParmVO csrParmVO, String creUsrId) throws DAOException {
	//TLL - PL PO GL GO
	String ttlLssDivCd   	= csrParmVO.getTtlLssDivCd(); 
	String invRgstNo   		= csrParmVO.getInvRgstNo(); 
	
	int result = 0;

	String csr_no			= csrParmVO.getCsrNo(); 
	String coa_acct_cd 		= "210111";		//coa_acct_cd 
	String invSubSysCd   	= csrParmVO.getInvSubSysCd();	//모듈
	if(invSubSysCd.equals("CNI")){
		coa_acct_cd = "210121";
	}
	String csr_amt			= csrParmVO.getCsrAmt();
	if(ttlLssDivCd.equals("PO") || ttlLssDivCd.equals("GO")){	//송장금액(공급액+세액)은 0으로 셋팅
		csr_amt = "0";
	}

	String asanogb			= csrParmVO.getAsanogb();     // A/P이면 국내 ASA or null 이면 해외
	String ofc_cd 			= csrParmVO.getOfcCd();
	String cost_ofc_cd 		= csrParmVO.getCostOfcCd();
	String ap_ofc_cd 		= csrParmVO.getApOfcCd();
	String usr_eml	 		= csrParmVO.getUsrEml();
	String usr_nm	 		= csrParmVO.getUsrNm();
	String vndr_seq			= csrParmVO.getVndrSeq();
	String curr_cd 			= csrParmVO.getCurrCd();
	String cnt_cd 			= csrParmVO.getCntCd();
	String gen_pay_term_cd 	= csrParmVO.getGenPayTermCd();
	String asa_no			= csrParmVO.getAsaNoS();
	String evi_gb			= csrParmVO.getEviGb();
	String csr_tp_cd		= csrParmVO.getCsrTpCd();
	//2009-11-23
	String pso_trns_slp_ctnt= csrParmVO.getPsoTrnsSlpCtnt();
	
	String ppay_aply_flg = "";              		//ppay_aply_flg
	String inv_dt		 = "";
	
	//결제자 성명 
	String  aproSeqKey  	= JSPUtil.getNull(String.valueOf(csrParmVO.getAproseqkey()));
	
	if(csr_tp_cd.equals("S")){
		csr_tp_cd = "STANDARD";
	}else if(csr_tp_cd.equals("C")){
		csr_tp_cd = "CREDIT";
	}else if(csr_tp_cd.equals("P")){
		csr_tp_cd = "PREPAYMENT";
		ppay_aply_flg = "Y";              		   //ppay_aply_flg
	}
	
	String max_iss_dt		= csrParmVO.getMaxIssDt();
	String max_rcv_dt		= csrParmVO.getMaxRcvDt();

	String payment_due_dt	= csrParmVO.getPaymentDueDt();
	log.debug("\n\n ### payment_due_dt:"+payment_due_dt+" ###################################################### \n\n");
	
	if(payment_due_dt.equals("")){	
		payment_due_dt = max_rcv_dt.replace("-", "");
	}

	String cre_usr_id		= creUsrId;
	String evi_inv_dt		= csrParmVO.getEviInvDt();
	if(!evi_inv_dt.equals("")){
		evi_inv_dt = evi_inv_dt.replaceAll("-","/");
	}
	String s_evi_inv_dt		= csrParmVO.getSEviInvDt();
	if(!s_evi_inv_dt.equals("")){
		s_evi_inv_dt = s_evi_inv_dt.replaceAll("-","/");
	}
	 //evi_inv_dt -> gl_dt 세팅
	if(cnt_cd.equals("KR") && evi_gb.equals("1")){ // 한국 - 세금계산서 
		evi_inv_dt = evi_inv_dt.replaceAll("-","/");	//gl_dt
	}else if(cnt_cd.equals("KR") && evi_gb.equals("2")){ // 한국 - 계산서
		evi_inv_dt = s_evi_inv_dt.replaceAll("-","/");	//gl_dt
	}else{
		evi_inv_dt = max_iss_dt.replaceAll("-","/");	//gl_dt  
	}

	String evi_comp_no		= csrParmVO.getEviCompNo();
	String evi_total_net_amt= csrParmVO.getEviTotalNetAmt();
	String evi_tax_no2		= csrParmVO.getEviTaxNo2();
	String evi_total_tax_amt= csrParmVO.getEviTotalTaxAmt();
	String evi_ctnt1		= csrParmVO.getEviCtnt1();
	String evi_ctnt2		= csrParmVO.getEviCtnt2();
	String evi_ctnt3		= csrParmVO.getEviCtnt3();
	String evi_ctnt4		= csrParmVO.getEviCtnt4();
	String evi_ctnt5		= csrParmVO.getEviCtnt5();
	String evi_ctnt6		= csrParmVO.getEviCtnt6();
	String evi_ctnt7		= csrParmVO.getEviCtnt7();
	String evi_ctnt8		= csrParmVO.getEviCtnt8();
	String evi_ctnt9		= csrParmVO.getEviCtnt9();
	String evi_ctnt10		= csrParmVO.getEviCtnt10();
	String evi_ctnt11		= csrParmVO.getEviCtnt11();
	String evi_ctnt12		= csrParmVO.getEviCtnt12();
	String evi_tax_no		= csrParmVO.getEviTaxNo();
	String pay_group_cd		= csrParmVO.getPayGroupCd();
	//전자/종이계산서
	String attr_ctnt8       = csrParmVO.getAttrCtnt8();
	
	String pay_amt = "";
	String pay_dt ="";
	String csr_curr_cd = curr_cd;
	String vndr_term_nm = gen_pay_term_cd;

	String attr_ctnt1 = aproSeqKey;
	String attr_ctnt2 = "";
	String attr_ctnt3 = "";
	
	if(cnt_cd.equals("KR")){
		attr_ctnt2 = evi_comp_no;             	//attr_ctnt2
		if(evi_gb.equals("1") || evi_gb.equals("2")){
			attr_ctnt3 = evi_inv_dt+" 00:00:00";  //attr_ctnt3
		}
	}else{
		if(!asa_no.equals("")){
			asa_no = asa_no.substring(0,3)+asa_no.substring(6,10)+asa_no.substring(3,6);
		}
		attr_ctnt2 = asa_no;               	  	//attr_ctnt2
		//attr_ctnt3 = evi_inv_dt;
	}
	
	String attr_ctnt4 = evi_total_net_amt;
	String attr_ctnt5 = evi_tax_no2;	//WORKPLACE
	String attr_ctnt6 = evi_total_tax_amt;
	String attr_ctnt7 = "";
	//String attr_ctnt8 = "";
	String attr_ctnt9 = "";
	String attr_ctnt10 = usr_nm;
	String attr_ctnt11 = "";
	String attr_ctnt12 = "";
	String attr_ctnt13 = "";
	String attr_ctnt14 = "";
	String attr_ctnt15 = "";

	String attr_cate_nm = "";
	if(cnt_cd.equals("KR")){
		if(evi_gb.equals("1")){
			attr_cate_nm = "세금계산서";  		//attr_cate_nm
		}else if(evi_gb.equals("2")){
			attr_cate_nm = "계산서";				//attr_cate_nm
		}else if(evi_gb.equals("3")){
			attr_cate_nm = "기타";  				//attr_cate_nm
		}else{
			attr_cate_nm = "";  				//attr_cate_nm
		}
	}else{
		attr_cate_nm = "Invoices";              //attr_cate_nm
		attr_ctnt8 = csrParmVO.getRcvDt().replaceAll("-", "")+"000000";
	}

	String evi_ctnt13 = evi_tax_no;
	String evi_ctnt14 = "";
	String evi_ctnt15 = "";
	String evi_ctnt16 = "";
	String evi_ctnt17 = "";
	String evi_ctnt18 = "";
	
	/*
	 *SRC_CTNT
	'MNR' => 'SO_M&R'
	'LSE' => 'SO_LEASE'
	'PSO' => 'SO_PORT'
	'CHS' => 'SO_CHASSIS'
	 */
	String srcCtnt = "";
	if(invSubSysCd.equals("MNR")){
		srcCtnt	=	"SO_M&R";
	}else if(invSubSysCd.equals("TLL")){
		srcCtnt	=	"EQ";
	}else if(invSubSysCd.equals("LSE")){
		srcCtnt	=	"SO_LEASE";
	}else if(invSubSysCd.equals("PSO")){
		srcCtnt	=	"SO_PORT";
	}else if(invSubSysCd.equals("CHS")){
		srcCtnt	=	"SO_CHASSIS";
	}else if(invSubSysCd.equals("MGS")){
		srcCtnt	=	"SO_MGSET";
	}else if(invSubSysCd.equals("CNI")){
		srcCtnt	=	"SO_CCC";
	}
	
	String pay_mzd_lu_cd = "";
	String pay_grp_lu_cd = "";
	
	log.debug("@@@ cnt_cd:"+cnt_cd+" - asa_no:"+asa_no+" - pay_group_cd:"+pay_group_cd+" - csr_amt:"+csr_amt);
	
	//2009-11-26 ap_ctr_cd 에 따라 대내 대외 구분 수정 -> 2010-05-17 1: 대외, 2: 대내 셋팅하여 국내가 아닌경우(즉, 대외가 아닌경우) pay_grp_lu_cd 의 접미사를 붙이지 않는다
	String ap_ctr_cd_io = srchPayGrpLuCd(cost_ofc_cd);
	//pay_grp_lu_cd = ap_ctr_cd_gbn;	//대내지불, 대외지불 유형 셋팅
	if(curr_cd.equals("KRW")){
		pay_grp_lu_cd = "대외지불";
	}else{
		pay_grp_lu_cd = "대내지불";
	}
	
	if(pay_grp_lu_cd.equals("대외지불")){
		//2009-11-24 PSO 투자비보전관련 항비 로직 추가 
		if(pso_trns_slp_ctnt.equals("AR")){
			pay_grp_lu_cd = "대내지불";
		}
	}else{
		if(csr_amt.equals("0") || asanogb.equals("ASA")){
			if(invSubSysCd.equals("PSO") && cnt_cd.equals("KR")){ // PSO 예외처리 
				pay_grp_lu_cd = "ZERO PAYMENT"; 						//pay_grp_lu_cd				
			} else {
				pay_grp_lu_cd = ap_ofc_cd+"_ZERO PAYMENT"; 						//pay_grp_lu_cd
			}
		}else{
			if(!ap_ctr_cd_io.equals("1")){
				//  2009-01-01 이후 : XMNBB 조직변경으로 인해 XMNBB는 더 이상 PAY_GROUP을 선택하지 않고 일반적인 다른 OFFICE와 동일하게 처리한다. 
				if (pay_group_cd!=null && pay_group_cd.trim().equals("RHQ") && ap_ofc_cd!=null && (ap_ofc_cd.trim().equals("SZPBB")||ap_ofc_cd.trim().equals("CANBS")||ap_ofc_cd.trim().equals("XMNBB"))){
					pay_grp_lu_cd = ap_ofc_cd+"_RHQ_PYMT"; 						//pay_grp_lu_cd
				} else {
					pay_grp_lu_cd = ap_ofc_cd+"_O/EXP";                   	    //pay_grp_lu_cd
				}
			}
		}
	}
	
	//2009-12-07 PSO Canal = AA, 전도금 = GO
	if(pso_trns_slp_ctnt.equals("GO")){
		pay_grp_lu_cd = "대내지불";
	}
	
	//TOTAL LOSS 전용 
	if(ttlLssDivCd.equals("PO") || ttlLssDivCd.equals("GO") || ttlLssDivCd.equals("PL") || ttlLssDivCd.equals("GL")){ 
		//pay_mzd_lu_cd = "WIRE";
		pay_grp_lu_cd = "대내지불";
	}
	
	String coa_co_cd = "01";                  		//coa_co_cd
	String coa_rgn_cd = cost_ofc_cd;                //coa_rgn_cd
	String coa_ctr_cd = cost_ofc_cd;                //coa_ctr_cd
	//log.debug("\n cost_ofc_cd:"+cost_ofc_cd+" \n");
	
	//coa_acct_cd = "210111";					//coa_acct_cd 
	/*if(pso_trns_slp_ctnt.equals("GO")){  
		coa_acct_cd = "210121";
	}*/

	String coa_vvd_cd = "0000000000";               //coa_vvd_cd
	String coa_inter_co_cd = vndr_seq;            	//coa_inter_co_cd
	String coa_ftu_n1st_cd = "000000";            	//coa_ftu_n1st_cd
	String coa_ftu_n2nd_cd = "000000";            	//coa_ftu_n2nd_cd
	String ppd_no = "";                     		//ppd_no
	String ppd_dtrb_no = "";                		//ppd_dtrb_no
	String ppd_aply_amt = "";               		//ppd_aply_amt
	String ppd_gl_dt = "";                  		//ppd_gl_dt
	String apro_flg = "N";                   		//apro_flg
	String tax_decl_flg = "";               		//tax_decl_flg
	String err_csr_no = "";                 		//err_csr_no
	String if_flg = "";                     		//if_flg
	String if_dt = "";                      		//if_dt
	String if_err_rsn = "";                 		//if_err_rsn
	String tj_ofc_cd = ap_ofc_cd;                  	//tj_ofc_cd
	String act_xch_rt = "";                 		//act_xch_rt
	String imp_err_flg = "";                		//imp_err_flg
	String rcv_err_flg = "";                		//rcv_err_flg
	String tax_curr_xch_flg = "";           		//tax_curr_xch_flg
	String imp_err_rsn = "";                		//imp_err_rsn
	String rcv_err_rsn = "";                		//rcv_err_rsn
	String ftu_use_ctnt1 = "";              		//ftu_use_ctnt1
	String ftu_use_ctnt2 = "";              		//ftu_use_ctnt2
	String ftu_use_ctnt3 = "";              		//ftu_use_ctnt3
	String ftu_use_ctnt4 = "";              		//ftu_use_ctnt4
	String ftu_use_ctnt5 = "";              		//ftu_use_ctnt5

	if(evi_gb.equals("1") || evi_gb.equals("2")){
		tax_decl_flg = "Y";
	}
	
	if(cnt_cd.equals("KR") && evi_gb.equals("1")){ // 한국 - 세금계산서
		inv_dt = evi_inv_dt.replaceAll("/","");
	}else if(cnt_cd.equals("KR") && evi_gb.equals("2")){ // 한국 - 계산서
		inv_dt = s_evi_inv_dt.replaceAll("/","");
	}else{
		inv_dt = max_iss_dt;
	}
		
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	//mapVO
	Map<String, Object> mapVO = new HashMap<String, Object>();

	try { 
		mapVO.put("csr_no",   		csr_no			 );
		mapVO.put("csr_tp_cd",   	csr_tp_cd        );
		mapVO.put("max_iss_dt",   	max_iss_dt       );
		mapVO.put("max_rcv_dt",   	max_rcv_dt       );
		mapVO.put("evi_inv_dt",   	evi_inv_dt       );
		mapVO.put("inv_dt",   		inv_dt       );
		mapVO.put("ap_ofc_cd",   	ap_ofc_cd        );
		mapVO.put("vndr_seq",   	vndr_seq         );
		mapVO.put("csr_amt",   		csr_amt          );
		mapVO.put("pay_amt",   		pay_amt          );
		mapVO.put("pay_dt",   		pay_dt           );
		mapVO.put("csr_curr_cd",  	csr_curr_cd      );
		mapVO.put("vndr_term_nm", 	vndr_term_nm     );
		mapVO.put("payment_due_dt", payment_due_dt   );
		mapVO.put("attr_cate_nm", 	attr_cate_nm     );
		mapVO.put("attr_ctnt1",   	attr_ctnt1       );
		mapVO.put("attr_ctnt2",   	attr_ctnt2       );
		mapVO.put("attr_ctnt3",   	attr_ctnt3       );
		mapVO.put("attr_ctnt4",   	attr_ctnt4       );
		mapVO.put("attr_ctnt5",   	attr_ctnt5       );
		mapVO.put("attr_ctnt6",   	attr_ctnt6       );
		mapVO.put("attr_ctnt7",   	attr_ctnt7       );
		mapVO.put("attr_ctnt8",   	attr_ctnt8       );
		mapVO.put("attr_ctnt9",   	attr_ctnt9       );
		mapVO.put("attr_ctnt10",  	attr_ctnt10      );
		mapVO.put("attr_ctnt11",  	attr_ctnt11      );
		mapVO.put("attr_ctnt12",  	attr_ctnt12      );
		mapVO.put("attr_ctnt13",  	attr_ctnt13      );
		mapVO.put("attr_ctnt14",  	attr_ctnt14      );
		mapVO.put("attr_ctnt15",  	attr_ctnt15      );
		mapVO.put("evi_ctnt1",   	evi_ctnt1        );
		mapVO.put("evi_ctnt2",   	evi_ctnt2        );
		mapVO.put("evi_ctnt3",   	evi_ctnt3        );
		mapVO.put("evi_ctnt4",   	evi_ctnt4        );
		mapVO.put("evi_ctnt5",   	evi_ctnt5        );
		mapVO.put("evi_ctnt6",   	evi_ctnt6        );
		mapVO.put("evi_ctnt7",   	evi_ctnt7        );
		mapVO.put("evi_ctnt8",   	evi_ctnt8        );
		mapVO.put("evi_ctnt9",   	evi_ctnt9        );
		mapVO.put("evi_ctnt10",   	evi_ctnt10       );
		mapVO.put("evi_ctnt11",   	evi_ctnt11       );
		mapVO.put("evi_ctnt12",   	evi_ctnt12       );
		mapVO.put("evi_ctnt13",   	evi_ctnt13       );
		mapVO.put("evi_ctnt14",   	evi_ctnt14       );
		mapVO.put("evi_ctnt15",   	evi_ctnt15       );
		mapVO.put("evi_ctnt16",   	evi_ctnt16       );
		mapVO.put("evi_ctnt17",   	evi_ctnt17       );
		mapVO.put("evi_ctnt18",   	evi_ctnt18       );
		mapVO.put("src_ctnt",   	srcCtnt         );
		mapVO.put("pay_mzd_lu_cd",  pay_mzd_lu_cd    );
		mapVO.put("pay_grp_lu_cd",  pay_grp_lu_cd    );
		mapVO.put("coa_co_cd",   	coa_co_cd        );
		mapVO.put("cost_ofc_cd",  	cost_ofc_cd      );
		mapVO.put("coa_acct_cd",  	coa_acct_cd      );
		mapVO.put("coa_vvd_cd",   	coa_vvd_cd       );
		mapVO.put("coa_ftu_n1st_cd",coa_ftu_n1st_cd  );
		mapVO.put("coa_ftu_n2nd_cd",coa_ftu_n2nd_cd  );
		mapVO.put("ppd_no",   		ppd_no           );
		mapVO.put("ppd_dtrb_no",  	ppd_dtrb_no      );
		mapVO.put("ppd_aply_amt", 	ppd_aply_amt     );
		mapVO.put("ppd_gl_dt",   	ppd_gl_dt        );
		mapVO.put("apro_flg",   	apro_flg         );
		mapVO.put("tax_decl_flg", 	tax_decl_flg     );
		mapVO.put("err_csr_no",   	err_csr_no       );
		mapVO.put("if_flg",   		if_flg           );
		mapVO.put("if_dt",   		if_dt            );
		mapVO.put("if_err_rsn",   	if_err_rsn       );
		mapVO.put("ppay_aply_flg",	ppay_aply_flg    );
		mapVO.put("act_xch_rt",  	act_xch_rt       );
		mapVO.put("imp_err_flg",  	imp_err_flg      );
		mapVO.put("rcv_err_flg",  	rcv_err_flg      );
		mapVO.put("tax_curr_xch_flg",   tax_curr_xch_flg );
		mapVO.put("usr_eml",   		usr_eml          );
		mapVO.put("imp_err_rsn",  	imp_err_rsn      );
		mapVO.put("rcv_err_rsn",  	rcv_err_rsn      );
		mapVO.put("ftu_use_ctnt1",  ftu_use_ctnt1    );
		mapVO.put("ftu_use_ctnt2",  ftu_use_ctnt2    );
		mapVO.put("ftu_use_ctnt3",  ftu_use_ctnt3    );
		mapVO.put("ftu_use_ctnt4",  ftu_use_ctnt4    );
		mapVO.put("ftu_use_ctnt5",  ftu_use_ctnt5    );
		mapVO.put("ofc_cd",   		ofc_cd           );
		mapVO.put("cre_usr_id",   	cre_usr_id       );

		mapVO.put("coa_rgn_cd", 	coa_rgn_cd);
		mapVO.put("coa_ctr_cd", 	coa_ctr_cd);
		mapVO.put("coa_inter_co_cd",coa_inter_co_cd);
		mapVO.put("tj_ofc_cd", 		tj_ofc_cd);
		
		//추가 09-30
		mapVO.put("ttl_lss_div_cd", ttlLssDivCd);
		mapVO.put("inv_rgst_no", invRgstNo);
		mapVO.put("pso_trns_slp_ctnt", pso_trns_slp_ctnt);

	    param.putAll(mapVO);
		velParam.putAll(mapVO);

		SQLExecuter sqlExe = new SQLExecuter(""); 
		result = sqlExe.executeUpdate((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOCreateApInvHDRCSQL(), param, velParam);
		if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		
	} catch (SQLException se) {
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}

}

/**
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * searchApInvDTRBIn -> or searchApInvDTRBOut -> 로직으로 DBRowSet[] 타입으로 담아온 데이타들을 AP_INV_DTRB에 INSERT, AP_INV_HDR에 UPDATE
 * @param List<SearchDTRBTtlVO> searchDTRBTtlVOList
 * @param CsrParmVO csrParmVO
 * @param String creUsrId
 * @exception DAOException
 */
public void createApInvDTRB(List<SearchDTRBTtlVO> searchDTRBTtlVOList, CsrParmVO csrParmVO, String creUsrId) throws DAOException {
	log.debug("\n DAO.createApInvDTRB --------------------------------------------------");

	String csr_no 	= JSPUtil.getNull(csrParmVO.getCsrNo());
	String ofc_cd	= csrParmVO.getInvOfcCd();
	
	List al = new ArrayList();
	SearchDTRBTtlVO model = new SearchDTRBTtlVO();
	Iterator itr = searchDTRBTtlVOList.iterator();
	
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	
	try {
		int insCnt[] = null;
		SQLExecuter sqlExe = new SQLExecuter(""); 
		
		//for (int j=0; j<searchDTRBTtlVOList.length; j++){
		while(itr.hasNext()){
			model = (SearchDTRBTtlVO) itr.next();
			
			Map<String, Object> mapVO2 = new HashMap<String, Object>();
			mapVO2.put("csr_no", csr_no);
			mapVO2.put("line_seq", model.getLineSeq());
			mapVO2.put("line_no",  model.getLineNo());
			mapVO2.put("line_tp_lu_cd", model.getLineTpLuCd());
			mapVO2.put("csr_amt",  model.getCsrAmt());
			mapVO2.put("inv_desc", model.getInvDesc());
			mapVO2.put("inv_tax_cd", model.getInvTaxCd());
			mapVO2.put("dtrb_coa_co_cd",   model.getDtrbCoaCoCd());
			mapVO2.put("dtrb_coa_rgn_cd",  model.getDtrbCoaRgnCd());
			mapVO2.put("dtrb_coa_ctr_cd",  model.getDtrbCoaCtrCd());
			mapVO2.put("dtrb_coa_acct_cd", model.getDtrbCoaAcctCd());
			mapVO2.put("dtrb_coa_vvd_cd",  model.getDtrbCoaVvdCd());
			mapVO2.put("dtrb_coa_inter_co_cd", model.getDtrbCoaInterCoCd());
			mapVO2.put("dtrb_coa_ftu_n1st_cd", model.getDtrbCoaFtuN1stCd());
			mapVO2.put("dtrb_coa_ftu_n2nd_cd", model.getDtrbCoaFtuN2ndCd());
			mapVO2.put("attr_cate_nm",model.getAttrCateNm());
			mapVO2.put("attr_ctnt1",  model.getAttrCtnt1());
			mapVO2.put("attr_ctnt2",  model.getAttrCtnt2());
			mapVO2.put("attr_ctnt3",  model.getAttrCtnt3());
			mapVO2.put("attr_ctnt4",  model.getAttrCtnt4());
			mapVO2.put("attr_ctnt5",  model.getAttrCtnt5());
			mapVO2.put("attr_ctnt6",  model.getAttrCtnt6());
			mapVO2.put("attr_ctnt7",  model.getAttrCtnt7());
			mapVO2.put("attr_ctnt8",  model.getAttrCtnt8());
			mapVO2.put("attr_ctnt9",  model.getAttrCtnt9());
			mapVO2.put("attr_ctnt10", model.getAttrCtnt10());
			mapVO2.put("attr_ctnt11", model.getAttrCtnt11());
			mapVO2.put("attr_ctnt12", model.getAttrCtnt12());
			mapVO2.put("attr_ctnt13", model.getAttrCtnt13());
			mapVO2.put("attr_ctnt14", model.getAttrCtnt14());
			mapVO2.put("attr_ctnt15", model.getAttrCtnt15());
			//mapVO2.put("bkg_no", rowSetArr[j].getString("bkg_no"));
			mapVO2.put("cntr_tpsz_cd",model.getCntrTpszCd());
			mapVO2.put("act_vvd_cd",  model.getActVvdCd());
			mapVO2.put("pln_sctr_div_cd", model.getPlnSctrDivCd());
			mapVO2.put("so_crr_cd",   model.getSoCrrCd());
			//mapVO2.put("yd_cd", rowSetArr[j].getString("yd_cd"));
			mapVO2.put("ftu_use_ctnt1", model.getFtuUseCtnt1());
			mapVO2.put("ftu_use_ctnt2", model.getFtuUseCtnt2());
			mapVO2.put("ftu_use_ctnt3", model.getFtuUseCtnt3());
			mapVO2.put("ftu_use_ctnt4", model.getFtuUseCtnt4());
			mapVO2.put("ftu_use_cntr5", model.getFtuUseCntr5());
			mapVO2.put("eai_evnt_dt", model.getEaiEvntDt());
			mapVO2.put("ofc_cd",      ofc_cd);
			mapVO2.put("cre_usr_id",  creUsrId);
			
			al.add(mapVO2);
		}
		
		insCnt = sqlExe.executeBatch((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOInsApInvDtrbCSQL(), al, velParam);
		
		for(int j = 0; j < insCnt.length; j++){
			if(insCnt[j]== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert No1"+ j + " SQL");
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
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * AP_INV_HDR DESC UPDATE
 * @param CsrParmVO csrParmVO
 * @exception DAOException
 */
public void createApInvHdrUpdate(CsrParmVO csrParmVO) throws DAOException {
	log.debug("start createApInvHdrUpdate ===============================");
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	//
	Map<String, Object> mapVO = new HashMap<String, Object>();
	
	String csr_no 	= JSPUtil.getNull(csrParmVO.getCsrNo());
	//2009-11-23
	String pso_trns_slp_ctnt  = csrParmVO.getPsoTrnsSlpCtnt(); 
	//TLL - PL PO GL GO
	String invSubSysCd   	  = csrParmVO.getInvSubSysCd();	//모듈
	
	try {
		//update
		mapVO.put("csr_no", csr_no);
		param.putAll(mapVO);
		velParam.putAll(mapVO);
		// 배부후에 INV_DESC에 MAX ACCT명을 넣는다. 
		int result = 0;
		SQLExecuter sqlExe = new SQLExecuter("");

		if(!invSubSysCd.equals("TLL") && !pso_trns_slp_ctnt.equals("AR")){
			result = sqlExe.executeUpdate((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOUdtApInvHdrUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new EventException((new ErrorHandler("CSR00002", new String[]{"INV_DESC"}).getMessage())); 
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
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * AP_INV_DTRB 의 LINE_SEQ, LINE_NO UPDATE
 * @param String csrNo
 * @exception DAOException
 */
public void modifyApInvDTRBLineNo(String csrNo) throws DAOException {
	log.debug("\n DAO.modifyApInvDTRBLineNo --------------------------------------------------");

	Map<String, Object> param 		= new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam 	= new HashMap<String, Object>();
	
	try {
		param.put("csr_no", csrNo);

		new SQLExecuter("").executeUpdate((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOModifyApInvDTRBLineNoUpdate01USQL(), param, velParam);

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
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * AP_INV_DTRB 의 LINE_SEQ, LINE_NO UPDATE
 * @param List<ApInvDtrbVO> voList
 * @exception DAOException
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
			insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOModifyApInvDTRBLineNoUpdate02USQL(), voList, param, velParam);
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
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * AP_INV_DTRB 의 LINE_SEQ, LINE_NO UPDATE
 * @param String csrNo
 * @return DBRowSet
 * @exception DAOException
 */
public DBRowSet modifyApInvDTRBLineNo03(String csrNo) throws DAOException {
	if(log.isDebugEnabled())log.debug("\n==========CARIssueTransferSlipManageDBDAO    modifyApInvDTRBLineNo03() ============");

	DBRowSet 			dbRowSet	= null;
	Map<String, Object> param 		= new HashMap<String, Object>();
	Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
	
	try {
		param.put("csr_no", csrNo);
		
		dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOModifyApInvDTRBLineNoUpdate03RSQL(), param, velParam);

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
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * AP_INV_DTRB GAP(청구받은 Invoice의 금액 - 공급액) UPDATE를 위한 조회 
 * @param String csrNo
 * @param String invNo
 * @param String vndrSeq
 * @return DBRowSet
 * @exception DAOException
 */
public DBRowSet createApInvDTRB_sum(String csrNo, String invNo, String vndrSeq) throws DAOException {
	log.debug("start createApInvDTRB_sum ========================");

	DBRowSet 			dbRowSet	= null;
	Map<String, Object> mapVO = new HashMap<String, Object>();
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();

	try{
		mapVO.put("csr_no", 		csrNo);
		mapVO.put("inv_no", 		invNo);
		mapVO.put("vndr_seq", 		vndrSeq);

		param.putAll(mapVO);
		velParam.putAll(mapVO);
		
		dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOCreateApInvDTRBSumRSQL(), param, velParam);
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
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * AP_INV_DTRB GAP(청구받은 Invoice의 금액 - 공급액) UPDATE
 * @param CsrParmVO csrParmVO
 * @param String gap
 * @param String invNo2
 * @param costCd
 * @param cntrTpszCd
 * @exception EventException
 */
public void createApInvDTRB_sumUpdateDiff(CsrParmVO csrParmVO, String gap, String invNo2, String costCd, String cntrTpszCd) throws DAOException {
	
	Map<String, Object> mapVO = new HashMap<String, Object>();
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();

	try{
		mapVO.put("csr_no", 		csrParmVO.getCsrNo());
		mapVO.put("curr_cd", 		csrParmVO.getCurrCd());
		mapVO.put("gap", 			gap);
		mapVO.put("inv_no2", 		invNo2);
		mapVO.put("cost_cd", 		costCd);
		mapVO.put("cntr_tpsz_cd", 	cntrTpszCd);
		
		param.putAll(mapVO);
		velParam.putAll(mapVO);

		new SQLExecuter("").executeUpdate((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOCreateApInvDTRBSumUpdateDiffUSQL(), param, velParam);

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
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * asa_no 값이 있는경우 AP_INV_DTRB  GAP(청구받은 Invoice의 금액 - 공급액) UPDATE
 * @param String csrNo
 * @return DBRowSet
 * @exception EventException
 */
public DBRowSet createApInvDTRBASANoSelect(String csrNo) throws DAOException {
	log.debug("start createApInvDTRBASANoSelect ========================");

	DBRowSet 			dbRowSet	= null;
	Map<String, Object> param 		= new HashMap<String, Object>();
	Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
	
	try {
		param.put("csr_no", csrNo);

		dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOCreateApInvDTRBASANoSelectRSQL(), param, velParam);

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
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * asa_no 값이 있는경우 AP_INV_DTRB  GAP(청구받은 Invoice의 금액 - 공급액) UPDATE
 * @param CreateApInvDTRBASANoSelectVO createApInvDTRBASANoSelectVO
 * @param String ofcCd 
 * @param String costOfcCd
 * @param String vndrSeq
 * @param String creUsrId
 * @param String csrTpCd
 * @exception DAOException
 */
public void createApInvDTRBASANoInsert(CreateApInvDTRBASANoSelectVO createApInvDTRBASANoSelectVO, String ofcCd, String costOfcCd, String vndrSeq, String creUsrId, String csrTpCd) throws DAOException {
	log.debug("start createApInvDTRBASANoInsert =============================");
	
	Map<String, Object> param 		= new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam 	= new HashMap<String, Object>();
	
	try {
		Map<String, String> mapVO = createApInvDTRBASANoSelectVO.getColumnValues();
		param.putAll(mapVO);
		velParam.putAll(mapVO);
		
		param.put("ofc_cd", ofcCd);
		param.put("cost_ofc_cd", costOfcCd);
		param.put("vndr_seq",  vndrSeq);
		param.put("cre_usr_id",  creUsrId);
		param.put("cre_tp_cd",  csrTpCd);
		
		new SQLExecuter("").executeUpdate((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOCreateApInvDTRBASANoCSQL(), param, velParam);
	
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
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * ap_inv_hdr csr_amr update
 * @param String csrNo
 * @exception EventException
 */
public void createApInvDTRBASANoUpdate(String csrNo) throws DAOException {
	log.debug("start createApInvDTRBASANoUpdate =============================");

	Map<String, Object> param 		= new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam 	= new HashMap<String, Object>();
	
	try {
		param.put("csr_no", csrNo);
		
		new SQLExecuter("").executeUpdate((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOCreateApInvDTRBASANoUSQL(), param, velParam);

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
 * CSR생성시 AP I/F를 위해 AP_INV_IF에 DATA를 넣는다. -> 현재 사용되지 않는 메소드 2010-08-04
 * @param String csrNo
 * @param String ofcCd
 * @return String
 * @exception DAOException
 */
public String createApInvIF(String csrNo, String ofcCd) throws DAOException {
	log.debug("\n DAO.createApInvIF --------------------------------------------------");
	String pgm_no = "ESDCSRXXX"+JSPUtil.getKST("yyyyMMdd");
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();

	int result = 0;
	try {
        Map<String, Object> mapVO = new HashMap<String, Object>();
        mapVO.put("pgm_no", pgm_no);
        mapVO.put("csr_no", csrNo);
        mapVO.put("ofc_cd", ofcCd);

        param.putAll(mapVO);
		velParam.putAll(mapVO);

		SQLExecuter sqlExe = new SQLExecuter("");
		result = sqlExe.executeUpdate((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOApInvIFCSQL(), param, velParam);
		if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
	} catch (SQLException se) {
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
	return pgm_no;
}

/**
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * 7.HDR CSR NO UPDATE 처리 -> AP_PAY_INV 의 CSR_NO 업데이트
 * @param Collection<PayInvVO> payInvVOs
 * @param String csrNo
 * @param String batchFlag
 * @return String
 * @exception DAOException
 * @exception EventException 
 */
public String upateInvCSRNo(Collection<PayInvVO> payInvVOs, String csrNo, String batchFlag ) throws DAOException, EventException {
	log.debug("\n DAO.upateInvCSRNo --------------------------------------------------");

	List al = new ArrayList();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	try {
		Iterator itr = payInvVOs.iterator();
		PayInvVO model = null;
		int updCnt[] = null;

		while (itr.hasNext()) {
			model = (PayInvVO)itr.next();
    		if(!model.getIbflag().equals("")){
				Map<String, Object> mapVO2 = new HashMap<String, Object>();
				mapVO2.put("batch_flag", 	JSPUtil.getNull(batchFlag ));
				mapVO2.put("csr_no", 	JSPUtil.getNull(csrNo ));
				mapVO2.put("inv_rgst_no", 	JSPUtil.getNull(model.getInv_rgst_no() ));
				al.add(mapVO2);
				velParam.putAll(mapVO2);
    		}
		}
		
		SQLExecuter sqlExe = new SQLExecuter("");
		updCnt = sqlExe.executeBatch((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOUdtInvCSRNoUSQL(), al, velParam);

		for(int j = 0; j < updCnt.length; j++){
			if(updCnt[j]== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update No1"+ j + " SQL");
		}
	}catch(SQLException se){
		log.error(se.getMessage(),se);
		throw new EventException((new ErrorHandler("CSR00088").getMessage())); 
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
	return csrNo;
}

/**
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * 8.EP 결제하기 - 결제등록 (COM_APRO_RQST_HDR, ComAproRqstRoutVO)
 * @param CsrParmVO csrParmVO
 * @exception DAOException
 */
public void createCSREPApproval(CsrParmVO csrParmVO) throws DAOException
{
	log.debug("\n DAO.createCSREPApproval --------------------------------------------------");

	String  sCsr_no 			= csrParmVO.getCsrNo();
	String  sTotal_amt  		= csrParmVO.getTotalAmt();
	String  sCost_ofc_cd  		= csrParmVO.getCostOfcCd();
	String  sUsr_nm  			= csrParmVO.getUsrNm();
	String  sCre_usr_id  		= csrParmVO.getCreUsrId();
	String  sApro_step  		= csrParmVO.getAproStep();
	String  sOfc_nm  			= "";
	String  sVndr_seq  			= csrParmVO.getVndrSeq();
	String  sCurr_cd  			= csrParmVO.getCurrCd();
	String  sCnt_cd  			= csrParmVO.getInvKnt();
	String  sPayment_due_dt		= csrParmVO.getPaymentDueDt();
	String  sInv_sub_sys_cd		= csrParmVO.getInvSubSysCd();

	if(sInv_sub_sys_cd.equals("TLL")){
		sInv_sub_sys_cd = "MNR";
	}
	
	if(!sPayment_due_dt.equals("")){
		sPayment_due_dt = sPayment_due_dt.replaceAll("-","");
	}

	try {
		ApprovalUtil util = new ApprovalUtil();

		// COM_APRO_RQST_HDR
		ComAproRqstHdrVO header = new ComAproRqstHdrVO();
		header.setSubSysCd(sInv_sub_sys_cd);
		header.setAproKndCd("CSR");
		header.setRqstOfcCd(sCost_ofc_cd);
		header.setRqstOfcNm(sOfc_nm);
		header.setRqstUsrJbTitNm(""); // 직책
		header.setRqstUsrId(sCre_usr_id);
		header.setRqstUsrNm(sUsr_nm);
		header.setCreUsrId(sCre_usr_id); 

		//결재요청디테일에 저장할 apro_step 정보를 저장하기위한 셋팅을 한다.
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
		csr.setAproTtlAmt(sTotal_amt.replace(",", ""));
		csr.setCreUsrId(sCre_usr_id);
		csr.setUpdUsrId(sCre_usr_id);

		// CSR 결재요청 정보 생성
		util.saveCsrApro(header, route, csr);

	}catch(SQLException se){
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	} catch(Exception e) {
		log.error(e.getMessage(),e);
		throw new DAOException(new ErrorHandler(e).getMessage());
	}
}

/**
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * 9. inv_sts_cd 'A' 결제하기
 * @param Collection<PayInvVO> payInvVOs
 * @param String invStsCd
 * @return Collection
 * @exception DAOException
 */
public Collection modifyStsCdSOHDR(Collection<PayInvVO> payInvVOs, String invStsCd) throws DAOException {
	log.debug("\n DAO.modifyStsCdSOHDR --------------------------------------------------");

//	Collection models1 = payInvVOs;

	Collection models1 = new ArrayList();
	models1.add(invStsCd);
	
	
	List al = new ArrayList();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();

	try {
		Iterator itr = payInvVOs.iterator();
		PayInvVO model = null;
		int updCnt[] = null;
		
		while (itr.hasNext()) {
			model = (PayInvVO)itr.next();
    		if(!model.getIbflag().equals("")){
				Map<String, Object> mapVO2 = new HashMap<String, Object>();
				mapVO2.put("inv_sts_cd", 	JSPUtil.getNull(invStsCd ));
				mapVO2.put("inv_rgst_no", 	JSPUtil.getNull(model.getInv_rgst_no() ));
				al.add(mapVO2);
    		}
		}
		
		SQLExecuter sqlExe = new SQLExecuter("");
		updCnt = sqlExe.executeBatch((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOModifyStsSOHDRUSQL(), al, velParam);

		for(int j = 0; j < updCnt.length; j++){
			if(updCnt[j]== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update No1"+ j + " SQL");
		}
	}catch(SQLException se){
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
	return models1;
}

/**
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * 10. CSR AMT VAILD CHECK 
 * @param String csrNo
 * @return String
 * @exception DAOException
 */
public String checkCSRAmtVsInvAmt(String csrNo) throws DAOException {
	DBRowSet dbRowset = null;
	String retval = "";
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();

	try{
		Map<String, String> mapVO = new HashMap<String, String>();
		mapVO.put("csr_no", csrNo);

		param.putAll(mapVO);
		velParam.putAll(mapVO);

		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOcheckCSRAmtVsInvAmtRSQL(), param, velParam);
		while(dbRowset.next()){
			retval = dbRowset.getString("retval");
        }
	}catch(SQLException se){
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
	return retval;
}

/**
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * RevVVD가 AR_MST_REV_VVD에 존재/삭제 되었는지 조회 / ERR MSG에 inv_no도 출력 / Rev.VVD로 Rev.VVD master에 존재/삭제 여부를 조회.
 * @param String csrNo
 * @return DBRowSet
 * @exception DAOException
 */ 
public DBRowSet checkMstRevVVD01(String csrNo) throws DAOException {
	log.debug("\n\n DAO.checkMstRevVVD01 - csr_no:"+csrNo+" ---------------------------------------   \n");
	DBRowSet 			dbRowSet	= null;
	Map<String, Object> param 		= new HashMap<String, Object>();
	Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
	
	try {
		param.put("csr_no", csrNo);
		
		dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOCheckMstRevVVD01RSQL(), param, velParam);

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
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * DTRB_COA_ACCT_CD 조회.
 * @param String csrNo
 * @return DBRowSet
 * @exception DAOException
 */ 
public DBRowSet checkAcctCd(String csrNo) throws DAOException {
	log.debug("\n\n DAO.checkAcctCd - csr_no:"+csrNo+" ---------------------------------------   \n");
	DBRowSet 			dbRowSet	= null;
	Map<String, Object> param 		= new HashMap<String, Object>();
	Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
	
	try {
		param.put("csr_no", csrNo);
		
		dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOCheckAcctCdRSQL(), param, velParam);

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
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * RevVVD가 AR_MST_REV_VVD에 존재/삭제 되었는지 조회 / ERR MSG에 inv_no도 출력 / Rev.VVD로 Rev.VVD master에 존재/삭제 여부를 조회.
 * @param String vvdCd
 * @return DBRowSet
 * @exception DAOException
 */
public DBRowSet checkMstRevVVD02(String vvdCd) throws DAOException {
	log.debug("\n\n DAO.checkMstRevVVD02 - vvd_cd:"+vvdCd+" ---------------------------------------   \n");
	DBRowSet 			dbRowSet	= null;
	Map<String, Object> param 		= new HashMap<String, Object>();
	Map<String, Object> velParam 	= new HashMap<String, Object>(); //velocity parameter
	
	try {
		param.put("vvd_cd", vvdCd);
		
		dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOCheckMstRevVVD02RSQL(), param, velParam);

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
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * AP_INV_DTRB INSERT [증빙]
 * @param Collection<PayInvVO> payInvVOs
 * @param CsrParmVO csrParmVO
 * @exception DAOException
 */
public void createApInvDTRBEvi(Collection<PayInvVO> payInvVOs, CsrParmVO csrParmVO) throws DAOException {
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();

	List<String> invNo = new ArrayList();
	int result = 0;
	try {
        Map<String, Object> mapVO = new HashMap<String, Object>();
        mapVO.put("csr_no", csrParmVO.getCsrNo());

		if(csrParmVO.getCntCd().equals("KR")){
			if(csrParmVO.getEviGb().equals("1")){
				mapVO.put("inv_tax_cd", csrParmVO.getEviTaxCode());   				//inv_tax_cd
			}else if(csrParmVO.getEviGb().equals("2")){
				mapVO.put("inv_tax_cd", "매입계산서"); 							//inv_tax_cd
			}else{
				mapVO.put("inv_tax_cd", "");   									//inv_tax_cd
			}
			String arrInvNo[] = setParams(payInvVOs.iterator()).split(",");
			for(int i=0;i<arrInvNo.length;i++){   
				invNo.add(arrInvNo[i]);   
			}
		}else{
			mapVO.put("inv_tax_cd", ""); 										//inv_tax_cd
		}        
        mapVO.put("ofc_cd", csrParmVO.getInvOfcCd());
        mapVO.put("user_id", csrParmVO.getCreUsrId());
//        mapVO.put("inv_no", setParams(payInvVOs.iterator()));
        mapVO.put("inv_no", invNo);
        mapVO.put("vndr_seq", csrParmVO.getVndrSeq());

        param.putAll(mapVO);
		velParam.putAll(mapVO);

		SQLExecuter sqlExe = new SQLExecuter("");
		result = sqlExe.executeUpdate((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOCreateApInvDTRBEviCSQL(), param, velParam);
		if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
	} catch (SQLException se) {
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
}

/**
 * COM_CSR_0002 : private안에 반복문사용시 r4j통과함. 통과하지 못할경우 아키팀에 재문의 <br>
 * AP_INV_DTRB
 * @param int i
 * @param Iterator itr
 * @param PreparedStatement insertPs
 * @param PayInvVO payInvVO
 * @return String
 * @exception SQLException
 */
private String setParams(Iterator itr) throws DAOException { 
	String payInvNo = "";
	StringBuffer sbPayInvNo = new StringBuffer();
	PayInvVO payInvVO = null;
	try{
		while (itr.hasNext()) {
			payInvVO = (PayInvVO)itr.next();
//			payInvNo = payInvNo + payInvVO.getInv_no() + ",";
			sbPayInvNo.append(payInvVO.getInv_no());
			sbPayInvNo.append(",");
//			insertPs.setString(i++, payInvVO.getInv_no());	
			//inv_no
		}
		payInvNo = sbPayInvNo.toString();
		payInvNo = payInvNo.substring(0, payInvNo.length()-1);
	} catch (Exception e) {
		log.error(e.getMessage(), e);
		throw new DAOException(e.getMessage());
	}

	return payInvNo;
}

/**
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * AP_INV_DTRB INSERT [TLL]
 * @param Collection<PayInvVO> payInvVOs
 * @param CsrParmVO csrParmVO
 * @exception DAOException
 */
public void createApInvDTRBEviTll(Collection<PayInvVO> payInvVOs, CsrParmVO csrParmVO) throws DAOException {
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();

	List<String> invNo = new ArrayList();
	int result = 0;
	try {
        Map<String, Object> mapVO = new HashMap<String, Object>();
        
        String arrInvNo[] = setParams(payInvVOs.iterator()).split(",");
		for(int i=0;i<arrInvNo.length;i++){   
			invNo.add(arrInvNo[i]);   
		}
        mapVO.put("csr_no", csrParmVO.getCsrNo());
        mapVO.put("ofc_cd", csrParmVO.getInvOfcCd());
        mapVO.put("user_id", csrParmVO.getCreUsrId());
//      mapVO.put("inv_no", setParams(payInvVOs.iterator()));
        mapVO.put("inv_no", invNo);
        mapVO.put("vndr_seq", csrParmVO.getVndrSeq());

        param.putAll(mapVO);
		velParam.putAll(mapVO);

		SQLExecuter sqlExe = new SQLExecuter("");
		result = sqlExe.executeUpdate((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOcreateApInvDTRBEviTllCSQL(), param, velParam);
		if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
	} catch (SQLException se) {
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
}

/*************************************************************************************************************************************************************
 **********************************************************	!! Approval Request Step End !!  *****************************************************************
 *************************************************************************************************************************************************************/


/*************************************************************************************************************************************************************
 *************************************************************!! Preview Step Add Start !!  ******************************************************************
 *************************************************************************************************************************************************************/

/**
 * COM_CSR_0008 : CSR Format 버튼 <br>
 * CSR Format 버튼 구현로직 - 플릿폼
 * @param String csrNo
 * @return HdrVO 
 * @exception DAOException
 */
public HdrVO searchPreviewHDR(String csrNo) throws DAOException {
	DBRowSet dbRowset = null;
	List<HdrVO> list = null;
	HdrVO rtnVO = null;

	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	try{
		Map<String, String> mapVO = new HashMap<String, String>();
		mapVO.put("csr_no", csrNo);

		param.putAll(mapVO);
		velParam.putAll(mapVO);

		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOHdrRSQL(), param, velParam);
		list = (List)RowSetUtil.rowSetToVOs(dbRowset, HdrVO .class);

		if(list.size() > 0){
			rtnVO = (HdrVO)list.get(0);
		}
	}catch(SQLException se){
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
	return rtnVO;
}

/**
 * COM_CSR_0008 : CSR Format 버튼 <br>
 * CSR Format 버튼 구현로직 - 리스트
 * @param String csrNo
 * @return List<DtrbListVO>
 * @exception DAOException
 */
public List<DtrbListVO> searchPreviewDTRBList(String csrNo) throws DAOException {
	DBRowSet dbRowset = null;
	List<DtrbListVO> list = null;
	// query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	// velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();

	try {
		Map<String, String> mapVO = new HashMap<String, String>();
		mapVO.put("csr_no", csrNo);

		param.putAll(mapVO);
		velParam.putAll(mapVO);
		dbRowset = new SQLExecuter("").executeQuery( (ISQLTemplate) new ConsultationSlipRequestMgtDBDAODtrbListRSQL(), param, velParam);
		list = (List)RowSetUtil.rowSetToVOs(dbRowset, DtrbListVO.class);
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
 * deleteApInvHDRDTRB : deleteApInvHDRDTRB<br>
 * deleteApInvHDRDTRB
 * @param String csrNo
 * @throws DAOException
 */
public void deleteApInvHDRDTRB(String csrNo) throws DAOException {
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	Map<String, Object> mapVO = new HashMap<String, Object>();

	int result = 0;
	try {
        mapVO.put("csr_no", csrNo);

        param.putAll(mapVO);
		velParam.putAll(mapVO);
		SQLExecuter sqlExe = new SQLExecuter("");
		
		result = sqlExe.executeUpdate((ISQLTemplate)new ConsultationSlipRequestMgtDBDAODelApInvHdrDSQL(), param, velParam);
		if(result == Statement.EXECUTE_FAILED)
			throw new DAOException("Fail to insert SQL"); 
	} catch (SQLException se) {
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
}

/**
 * deleteApInvHDRDTRB : deleteApInvHDRDTRB<br>
 * deleteApInvHDRDTRB
 * @param String csrNo
 * @throws DAOException
 */
public void deleteApInvHDRDTRB02(String csrNo) throws DAOException {
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	Map<String, Object> mapVO = new HashMap<String, Object>();

	int result = 0;
	try {
        mapVO.put("csr_no", csrNo);

        param.putAll(mapVO);
		velParam.putAll(mapVO);
		SQLExecuter sqlExe = new SQLExecuter("");
		 
		result = sqlExe.executeUpdate((ISQLTemplate)new ConsultationSlipRequestMgtDBDAODelApInvDtrbDSQL(), param, velParam);
		if(result == Statement.EXECUTE_FAILED)
			throw new DAOException("Fail to insert SQL");
	} catch (SQLException se) {
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
}

/*************************************************************************************************************************************************************
 *************************************************************	!! Preview Step Add End !!  ******************************************************************
 *************************************************************************************************************************************************************/


/**
 * COM_CSR_0011 : 화면로드 <br>
 * Invoice List Inquiry 의 리스트폼조회 
 * @param CSRSOlistVO cSRSOlistVO
 * @return List<CSRSOlistVO>
 * @exception DAOException
 */
public List<CSRSOlistVO> searchCSRSOlist (CSRSOlistVO cSRSOlistVO) throws DAOException {
	DBRowSet dbRowset = null;
	List<CSRSOlistVO> list = null;
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();

	try{
		if(cSRSOlistVO != null){
			Map<String, String> mapVO = cSRSOlistVO .getColumnValues();
			mapVO.put("csr_no", cSRSOlistVO.getCsrNo());

			param.putAll(mapVO);
			velParam.putAll(mapVO);
		}
		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOCSRSOlistRSQL(), param, velParam);

		list = (List)RowSetUtil.rowSetToVOs(dbRowset, CSRSOlistVO.class);
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
 * COM_CSR_0011 : 화면로드 <br>
 * Invoice List Inquiry 의 플릿폼조회  : 대체전표로 검색된 해당 SO목록
 * @param CSRSOhdrVO cSRSOhdrVO
 * @return CSRSOhdrVO
 * @exception DAOException
 */
public CSRSOhdrVO searchCSRSOhdr (CSRSOhdrVO cSRSOhdrVO) throws DAOException {
	DBRowSet dbRowset = null;
	List<CSRSOhdrVO> list = null;
	CSRSOhdrVO rtnVO = null;
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();

	try{
		if(cSRSOhdrVO != null){
			Map<String, String> mapVO = cSRSOhdrVO .getColumnValues();
			
			
			String invSubSysCd = cSRSOhdrVO.getInvSubSysCd();
			
			String srcCtnt = "";
 
			if(invSubSysCd.equals("MNR")){
				srcCtnt	=	"SO_M&R";
			}else if(invSubSysCd.equals("TLL")){
				srcCtnt	=	"EQ";
			}else if(invSubSysCd.equals("LSE")){
				srcCtnt	=	"SO_LEASE";
			}else if(invSubSysCd.equals("PSO")){
				srcCtnt	=	"SO_PORT";
			}else if(invSubSysCd.equals("CHS")){
				srcCtnt	=	"SO_CHASSIS";
			}else if(invSubSysCd.equals("MGS")){
				srcCtnt	=	"SO_MGSET";
			}else if(invSubSysCd.equals("CNI")){
				srcCtnt	=	"SO_CCC";
			}
			
			mapVO.put("src_ctnt",  srcCtnt);
			mapVO.put("csr_no",    cSRSOhdrVO.getCsrNo());
			mapVO.put("ofc_cd",    cSRSOhdrVO.getOfcCd());
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		}
		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOCSRSOhdrRSQL(), param, velParam);

		list = (List)RowSetUtil.rowSetToVOs(dbRowset, CSRSOhdrVO.class);

		if(list.size() > 0){
			rtnVO = (CSRSOhdrVO)list.get(0);
		}
	}catch(SQLException se){
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
	return rtnVO;
}

/**
 * COM_CSR_0008 : CSR Cancel버튼<br>
 * Cancel 저장
 * @param IfCsrListInputVO ifCsrListInputVO
 * @throws DAOException
 */
public void multiConfirmCSR(IfCsrListInputVO ifCsrListInputVO) throws DAOException,Exception {
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();

	int result = 0;
	try {
        Map<String, Object> mapVO = new HashMap<String, Object>();
        mapVO.put("csr_no", ifCsrListInputVO.getCsrNo());
        mapVO.put("upd_usr_id", ifCsrListInputVO.getUpdUsrId());
        mapVO.put("ofc_cd", ifCsrListInputVO.getOfcCd());
        mapVO.put("inv_sts_cd", ifCsrListInputVO.getInvStsCd());

        param.putAll(mapVO);
		velParam.putAll(mapVO);

		SQLExecuter sqlExe = new SQLExecuter("");
		result = sqlExe.executeUpdate((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOCancelCSR01USQL(), param, velParam);
		if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
	} catch (SQLException se) {
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
}

/**
 * COM_CSR_0008 : CSR Cancel버튼<br>
 * Cancel 저장
 * @param IfCsrListInputVO ifCsrListInputVO
 * @throws DAOException
 */
public void cancelCSR(IfCsrListInputVO ifCsrListInputVO) throws DAOException,Exception {
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();

	int result = 0;
	try {
        Map<String, Object> mapVO = new HashMap<String, Object>();
        mapVO.put("csr_no", ifCsrListInputVO.getCsrNo());
        //mapVO.put("upd_usr_id", ifCsrListInputVO.getUpdUsrId());
       // mapVO.put("ofc_cd", ifCsrListInputVO.getOfcCd());
        mapVO.put("aft_act_flg", ifCsrListInputVO.getAftActFlg());

		param.putAll(mapVO);
		velParam.putAll(mapVO);

		SQLExecuter sqlExe = new SQLExecuter("");
		result = sqlExe.executeUpdate((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOCancelCSR02USQL(), param, velParam);
		if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
	} catch (SQLException se) {
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
}

/**
 * COM_CSR_0008 : CSR Cancel버튼<br>
 * CSR Cancel시 COM_APRO_RQST_HDR 업데이트
 * @param IfCsrListInputVO ifCsrListInputVO
 * @throws DAOException
 */
public void cancelCSRApro1(IfCsrListInputVO ifCsrListInputVO) throws DAOException,Exception {
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();

	int result = 0;
	try {
        Map<String, Object> mapVO = new HashMap<String, Object>();
        mapVO.put("csr_no", ifCsrListInputVO.getCsrNo());

		param.putAll(mapVO);
		velParam.putAll(mapVO);

		SQLExecuter sqlExe = new SQLExecuter("");
		result = sqlExe.executeUpdate((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOCSRCancellation3USQL(), param, velParam);
		if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
	} catch (SQLException se) {
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
}


/**
 * COM_CSR_0008 : CSR Cancel버튼<br>
 * CSR Cancel시 COM_APRO_CSR_DTL 업데이트
 * @param IfCsrListInputVO ifCsrListInputVO
 * @throws DAOException
 */
public void cancelCSRApro2(IfCsrListInputVO ifCsrListInputVO) throws DAOException,Exception {
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
 
	int result = 0;
	try {
        Map<String, Object> mapVO = new HashMap<String, Object>();
        mapVO.put("csr_no", ifCsrListInputVO.getCsrNo());

		param.putAll(mapVO);
		velParam.putAll(mapVO);

		SQLExecuter sqlExe = new SQLExecuter("");
		result = sqlExe.executeUpdate((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOCSRCancellation4USQL(), param, velParam);
		if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
	} catch (SQLException se) {
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
}

/**
 * COM_CSR_0014 : CSR Cancel버튼시 화면로드<br>
 * A/P Rejected & Disapproved 의 인보이스별 Cancel 저장 - 다건의 데이터를 일괄적으로 갱신한다.
 * @param Collection<PayInvVO> payInvVOs
 * @throws DAOException
 */
public void multiRejectedCSRCancellation01(Collection<PayInvVO> payInvVOs) throws DAOException {
	log.debug("start multiRejectedCSRCancellation01 ==================");
	try {
		int updCnt1[] = null;
		if(payInvVOs.size() > 0){
			updCnt1 = new SQLExecuter("").executeBatch((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOCSRCancellation1USQL(), payInvVOs, null);
			for(int j = 0; j < updCnt1.length; j++){
				if(updCnt1[j]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No1"+ j + " SQL");
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
 * COM_CSR_0014 : CSR Cancel버튼시 화면로드<br>
 * A/P Rejected & Disapproved 의 인보이스별 Cancel 저장 - 다건의 데이터를 일괄적으로 갱신한다.
 * @param Collection<PayInvVO> payInvVOs
 * @throws DAOException
 */
public void multiRejectedCSRCancellation02(Collection<PayInvVO> payInvVOs) throws DAOException {
	log.debug("start multiRejectedCSRCancellation01 ==================");
	try {
		int updCnt2[] = null;
		if(payInvVOs.size() > 0){
			updCnt2 = new SQLExecuter("").executeBatch((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOCSRCancellation2USQL(), payInvVOs, null);
			for(int j = 0; j < updCnt2.length; j++){
				if(updCnt2[j]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No2"+ j + " SQL");
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
 * COM_CSR_0014 : CSR Cancel버튼시 화면로드<br>
 * A/P Rejected & Disapproved 의 인보이스별 Cancel 저장 - 다건의 데이터를 일괄적으로 갱신한다.
 * @param Collection<PayInvVO> payInvVOs
 * @throws DAOException
 */
public void multiRejectedCSRCancellation03(Collection<PayInvVO> payInvVOs) throws DAOException {
	log.debug("start multiRejectedCSRCancellation01 ==================");
	try {
		int updCnt3[] = null;
		if(payInvVOs.size() > 0){
			updCnt3 = new SQLExecuter("").executeBatch((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOCSRCancellation3USQL(), payInvVOs, null);	//COM_APRO_RQST_HDR 업데이트
			for(int j = 0; j < updCnt3.length; j++){
				if(updCnt3[j]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No3"+ j + " SQL");
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
 * COM_CSR_0014 : CSR Cancel버튼시 화면로드<br>
 * A/P Rejected & Disapproved 의 인보이스별 Cancel 저장 - 다건의 데이터를 일괄적으로 갱신한다.
 * @param Collection<PayInvVO> payInvVOs
 * @throws DAOException
 */
public void multiRejectedCSRCancellation04(Collection<PayInvVO> payInvVOs) throws DAOException {
	log.debug("start multiRejectedCSRCancellation01 ==================");
	try {
		int updCnt4[] = null;
		if(payInvVOs.size() > 0){
			updCnt4 = new SQLExecuter("").executeBatch((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOCSRCancellation4USQL(), payInvVOs, null);	//COM_APRO_CSR_DTL 업데이트
			for(int j = 0; j < updCnt4.length; j++){
				if(updCnt4[j]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No4"+ j + " SQL");
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
 * AP 로 전송할 CSR 정보를 가져온다
 * @param String csrNo
 * @param String ofcCd
 * @return DBRowSet
 * @exception DAOException
 */
public DBRowSet searchApInvInfForEAIInterface(String csrNo, String ofcCd) throws DAOException {
	log.debug("start searchINFtoAP =======================");
	
	DBRowSet dbRowset = null;
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
    /**
     *        <LIFID>FNS008-0003</LIFID>
     *
     **/
    String pgmNo = "ESDCSRXXX"+JSPUtil.getKST("yyyyMMdd");
	try {
		param.put("pgm_no", pgmNo);
		param.put("csr_no", csrNo);
		param.put("ofc_cd", ofcCd);
		
		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOSearchINFtoAPRSQLRSQL(), param, velParam);
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
 * EP - > CSR 호출
 * AP_INV_HDR 업데이트 
 * @param String csrNo
 * @param String titleName
 * @exception DAOException
 */
public void approvalRequestAccount(String csrNo, String titleName) throws DAOException
{
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
 
	int result = 0;
	try {
        Map<String, Object> mapVO = new HashMap<String, Object>();
        mapVO.put("csr_no", csrNo);
        mapVO.put("title_name", titleName);

		param.putAll(mapVO);
		velParam.putAll(mapVO);

		SQLExecuter sqlExe = new SQLExecuter("");
		result = sqlExe.executeUpdate((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOapprovalRequestAccountUSQL(), param, velParam);
		if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Update SQL");
	} catch (SQLException se) {
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
	

}
 
/**
 * EP - > CSR 호출
 * HPC용 AP_PAY_INV data update하기
 * @param String csrNo
 * @param String mode
 * @exception DAOException
 */
public void updateHPC(String csrNo, String mode) throws DAOException {
	log.debug("\n\n DAO.updateHPC - ########################################### ");
	if (mode==null || mode.trim().equals("")){
		throw new DAOException("unknown mode !!!!!!!");
	}
	
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
 
	int result = 0;
	try {
        Map<String, Object> mapVO = new HashMap<String, Object>();
        mapVO.put("csr_no", csrNo);
        mapVO.put("mode", mode);

		param.putAll(mapVO);
		velParam.putAll(mapVO);

		SQLExecuter sqlExe = new SQLExecuter("");
		result = sqlExe.executeUpdate((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOupdateHPCUSQL(), param, velParam);
		if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Update SQL");
	} catch (SQLException se) {
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
}	

/**
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * csr_no 생성: csr_no 채번후 ap_csr_no 테이블에 insert / >>>>>>>물류와 장비 두개의 구분으로 CSR_NO 채번 [SM]
 * @param String costOfcCd
 * @return String
 * @exception DAOException
 */
public String srchPayGrpLuCd(String costOfcCd) throws DAOException {
	DBRowSet dbRowset = null;
	List<SrchPayGrpLuCdVO> list = null;
	SrchPayGrpLuCdVO rtnVO = null;
	//String ap_ctr_cd_gbn = "";
	String ap_ctr_cd_io = "";
	Map<String, Object> mapVO = new HashMap<String, Object>();
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();

	try{
		mapVO.put("ofc_cd", 		costOfcCd);

		param.putAll(mapVO);
		velParam.putAll(mapVO);

		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOSrchPayGrpLuCdRSQL(), param, velParam);

		list = (List)RowSetUtil.rowSetToVOs(dbRowset, SrchPayGrpLuCdVO.class);

		if(list.size() > 0){	//csr_no 번호따오기
			rtnVO = (SrchPayGrpLuCdVO)list.get(0);
			//ap_ctr_cd_gbn = rtnVO.getApCtrCdGbn();
			ap_ctr_cd_io = rtnVO.getApCtrCdIo();
		}
        
	}catch(SQLException se){
		log.error(se.getMessage(),se);
		throw new DAOException(new ErrorHandler(se).getMessage());
	}catch(Exception ex){
		log.error(ex.getMessage(),ex);
		throw new DAOException(new ErrorHandler(ex).getMessage());
	}
	return ap_ctr_cd_io;
}

/**
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * AP_INV_DTRB 의 INV_DESC 업데이트
 * @param String csrNo
 * @param String dtrbCoaAcctCd
 * @param String lineSeq
 * @param String lineNo
 * @exception DAOException
 */
public void modifyDesc(String csrNo, String dtrbCoaAcctCd, String lineSeq, String lineNo) throws DAOException {
	log.debug("\n DAO.modifyDesc --------------------------------------------------");
	
	Map<String, Object> mapVO 		= new HashMap<String, Object>();
	Map<String, Object> param 		= new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam 	= new HashMap<String, Object>();
	
	try {
		mapVO.put("csr_no", 	csrNo);
		mapVO.put("dtrb_coa_acct_cd", 	dtrbCoaAcctCd);
		mapVO.put("line_seq", 	lineSeq);
		mapVO.put("line_no", 	lineNo);
		
		
		param.putAll(mapVO);
		velParam.putAll(mapVO);

		new SQLExecuter("").executeUpdate((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOModifyDescUSQL(), param, velParam);

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
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * AP_INV_HDR 의 INV_DESC 업데이트
 * @param String csrNo
 * @exception DAOException
 */
public void modifyHdrDesc(String csrNo) throws DAOException {
	log.debug("\n DAO.modifyHdrDesc --------------------------------------------------");
	
	Map<String, Object> mapVO 		= new HashMap<String, Object>();
	Map<String, Object> param 		= new HashMap<String, Object>();
	//velocity parameter
	Map<String, Object> velParam 	= new HashMap<String, Object>();
	
	try {
		mapVO.put("csr_no", 	csrNo);
		
		param.putAll(mapVO);
		velParam.putAll(mapVO);

		new SQLExecuter("").executeUpdate((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOModifyHdrDescUSQL(), param, velParam);

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
 * COM_CSR_0002 : Approval Request 버튼 <br>
 * AP_PAY_INV 의 CSR_NO 업데이트 한 것을 Null로 함.
 * @param Collection<PayInvVO> payInvVOs
 * @exception DAOException
 * @exception EventException 
 */
public void upateInvCSRNoNull(Collection<PayInvVO> payInvVOs) throws DAOException, EventException {
	log.debug("\n DAO.upateInvCSRNoNull --------------------------------------------------");

	List al = new ArrayList();
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	try {
		Iterator itr = payInvVOs.iterator();
		PayInvVO model = null;
		int updCnt[] = null;
		
		while (itr.hasNext()) {
			model = (PayInvVO)itr.next();
    		if(!model.getIbflag().equals("")){
				Map<String, Object> mapVO2 = new HashMap<String, Object>();
				mapVO2.put("inv_rgst_no", 	JSPUtil.getNull(model.getInv_rgst_no() ));
				al.add(mapVO2);
    		}
		}
		
		SQLExecuter sqlExe = new SQLExecuter("");
		updCnt = sqlExe.executeBatch((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOUdtInvCSRNoNullUSQL(), al, velParam);

		for(int j = 0; j < updCnt.length; j++){
			if(updCnt[j]== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update No1"+ j + " SQL");
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
	 * COM_CSR_0015 : 조회버튼 <br>
	 * ERP Transfer 대상 CSR의 리스트를 조회합니다.<br>
	 * @param IfCsrListInputVO ifCsrListInputVO
	 * @return List<IfCsrListInputVO>
	 * @exception DAOException 
	 */
	public List<IfCsrListInputVO> searchErpInterfaceList(IfCsrListInputVO ifCsrListInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IfCsrListInputVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(ifCsrListInputVO != null){
				Map<String, String> mapVO = ifCsrListInputVO .getColumnValues();
				String searchCsrNo = ifCsrListInputVO.getSearchCsrNo();
				
				mapVO.put("search_csr_no", searchCsrNo);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ConsultationSlipRequestMgtDBDAOSearchErpInterfaceListRSQL(), param, velParam);
	
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, IfCsrListInputVO.class);
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