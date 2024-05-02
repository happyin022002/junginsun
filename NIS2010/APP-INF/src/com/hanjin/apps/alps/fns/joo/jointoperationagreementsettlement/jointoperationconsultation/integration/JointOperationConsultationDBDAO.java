/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : JointOperationConsultationDBDAO.java
 *@FileTitle : Tax Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.18
 *@LastModifier : 박희동
 *@LastVersion : 1.0
 * 2009.05.18 박희동
 * 1.0 Creation\
 * 
 *2014.07.25 민정호 CHM-20430993 [Develop-FMS-JOO]비용 전표 상신용 Approval 구축
* 10만불 이상 금액에 대해서 CEO 결재 승인 기능 추가
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ArDisabledVVDVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.basic.JointOperationConsultationBCImpl;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.ApIfErrVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.ArDataInqVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.ArMnChgVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CmbConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CombinedVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CsrSlipVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.CsrVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.ErpIfVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.InvDtrbVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.InvHdrVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.InvIfVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.LostCombinedDataVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipProcessVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.SlipVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.TaxVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.JooCrrMrgVO;
import com.hanjin.syscommon.common.table.JooSettlementVO;
import com.hanjin.syscommon.common.table.JooSlipVO;
import com.hanjin.syscommon.common.table.JooStlCmbDtlVO;
import com.hanjin.syscommon.common.table.JooStlCmbVO;
import com.hanjin.syscommon.common.table.JooTaxDtlVO;
import com.hanjin.syscommon.common.table.JooTaxVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.vo.AgmtDocVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration.JointOperationMasterDataMgtDBDAOJooCrrMrgVOCSQL;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration.JointOperationMasterDataMgtDBDAOJooCrrMrgVODSQL;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.integration.JointOperationMasterDataMgtDBDAOJooCrrMrgVOUSQL;

/**
 * ALPS JointOperationConsultationDBDAO <br>
 * - ALPS-JointOperationAgreementSettlement system Business Logic을 처리하기 위한
 * JDBC 작업수행.<br>
 * 
 * @author Park Hee Dong
 * @see JointOperationConsultationBCImpl 참조
 * @since J2EE 1.4
 */
public class JointOperationConsultationDBDAO extends DBDAOSupport {

	/**
	 * Tax정보를 조회한다. 
	 * @param String taxInvYrmonFr
	 * @param String taxInvYrmonTo
	 * @return List<TaxVO>
	 * @throws DAOException
	 */
	public List<TaxVO> searchTaxList(String taxInvYrmonFr, String taxInvYrmonTo) throws DAOException {
		DBRowSet dbRowset = null;
		List<TaxVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("tax_inv_yrmon_fr", taxInvYrmonFr);
			mapVO.put("tax_inv_yrmon_to", taxInvYrmonTo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new JointOperationConsultationDBDAOTaxVORSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TaxVO.class);
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
	 * AR Data ERP Interface를 조회한다.
	 * @param String erpIfFlg
	 * @param String dtFlg
	 * @param String fmDt
	 * @param String toDt
	 * @return List<ErpIfVO>
	 * @throws DAOException
	 */
	public List<ErpIfVO> searchARERPInterfaceList(String erpIfFlg, String dtFlg, String fmDt, String toDt) throws DAOException {
		DBRowSet dbRowset = null;
		List<ErpIfVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("erp_if_flg", erpIfFlg);
			mapVO.put("dt_flg", dtFlg);
			mapVO.put("iss_dt_fr", fmDt);
			mapVO.put("iss_dt_to", toDt);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationConsultationDBDAOARErpRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ErpIfVO.class);
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
	 * AP Data ERP Interface를 조회한다.
	 * @param String erpIfFlg
	 * @param String dtFlg
	 * @param String fmDt
	 * @param String toDt
	 * @return List<ErpIfVO>
	 * @throws DAOException
	 */
	public List<ErpIfVO> searchAPERPInterfaceList(String erpIfFlg, String dtFlg, String fmDt, String toDt) throws DAOException {
		DBRowSet dbRowset = null;
		List<ErpIfVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("erp_if_flg", erpIfFlg);
			mapVO.put("dt_flg", dtFlg);
			mapVO.put("iss_dt_fr", fmDt);
			mapVO.put("iss_dt_to", toDt);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationConsultationDBDAOAPErpRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ErpIfVO.class);
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
	 * 전표 상세내역을 조회한다.
	 * @param SlipConditionVO slipConditionVO
	 * @return List<SlipVO>
	 * @throws DAOException
	 */
	public List<SlipVO> searchDetailSlipList(SlipConditionVO slipConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SlipVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
/*
 * 한진해운 전표번호 체계 - 20자리
 * 1. 시스템 구분자 - 2자리 ('06' : 공동운항 비용, '18' : 공동운항 수입)
 * 2. 전표 Fuction Code - 1자리 ('T' : 수입은 모두 'T'만 존재, 
 *                             'S' : 비용전표 중 전표 Total 금액이 Plus인 경우,
 *                             'C' : 비용전표 중 전표 Total 금액이 Minus인 경우)
 * 3. Office Code : 6자리
 * 4. Issue Date : 6자리 (년월일)
 * 5. Serial Number : 5자리 
 * 예) 수입전표 : 18TSELFAR09060800003
 *    비용전표 : 06SSELFAR09060100001 
 *    
 * 즉, csrNo 를 파라미터정보로 분할한다 
 */
			String slpOfcCd2 = "";
			String fromSlpIssDt = "";
			String toSlpIssDt = "";
			String fromEffDt = "";
			String toEffDt = "";
				
			if(slipConditionVO.getGubun().equals("slp_iss_dt")){
				fromSlpIssDt = slipConditionVO.getFrDt();
				toSlpIssDt = slipConditionVO.getToDt();
			}else if(slipConditionVO.getGubun().equals("eff_dt")){
				fromEffDt = slipConditionVO.getFrDt();
				toEffDt = slipConditionVO.getToDt(); 
			}
            String slpTpCd   = "";
            String slpFuncCd = "";
            String slpOfcCd  = "";
            String slpIssDt  = "";
            String slpSerNo  = "";
            /* 
             * 2009-12-09
             * 본사와  지역을 구분 (본사발생은 20자리, 지역발생은 19자리 ) 
             * 
             */
            if(slipConditionVO.getCsrNo().length()==20){
		    	slpTpCd	    = slipConditionVO.getCsrNo().substring(0, 2);
			    slpFuncCd   = slipConditionVO.getCsrNo().substring(2, 3);
			    slpOfcCd	 = slipConditionVO.getCsrNo().substring(3, 9);
			    slpIssDt	 = slipConditionVO.getCsrNo().substring(9, 15);
			    slpSerNo	 = slipConditionVO.getCsrNo().substring(15, 20);
            }else if(slipConditionVO.getCsrNo().length()==19){
                slpTpCd     = slipConditionVO.getCsrNo().substring(0, 2);
                slpFuncCd   = slipConditionVO.getCsrNo().substring(2, 3);
                slpOfcCd     = slipConditionVO.getCsrNo().substring(3, 8);
                slpIssDt     = slipConditionVO.getCsrNo().substring(8, 14);
                slpSerNo     = slipConditionVO.getCsrNo().substring(14);
            }
			mapVO.put("slp_tp_cd", 	 slpTpCd);
			mapVO.put("slp_func_cd", slpFuncCd);
			mapVO.put("slp_ofc_cd",  slpOfcCd);
			mapVO.put("slp_ser_no",  slpSerNo); 
			mapVO.put("slp_iss_dt",  slpIssDt);

			String gubun = slipConditionVO.getGubun();
			
			if(gubun==null || gubun.equals("")){
				slpOfcCd2 = slpOfcCd;
				mapVO.put("slp_iss_dt2",  slpIssDt);
				mapVO.put("from_slp_iss_dt",  "");
				mapVO.put("to_slp_iss_dt",  "");
				mapVO.put("from_eff_dt",  "");
				mapVO.put("to_eff_dt",  "");
				mapVO.put("slp_ofc_cd2",  slpOfcCd2);
			}else{
				slpOfcCd2 = slipConditionVO.getSlpOfcCdSel(); 
				mapVO.put("slp_iss_dt2",  "");
				mapVO.put("from_slp_iss_dt",  fromSlpIssDt);
				mapVO.put("to_slp_iss_dt",  toSlpIssDt);
				mapVO.put("from_eff_dt",  fromEffDt);
				mapVO.put("to_eff_dt",  toEffDt);
				mapVO.put("slp_ofc_cd2",  slpOfcCd2);
			}
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationConsultationDBDAOSlipVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SlipVO.class);
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
	 * CSR List를 조회한다. 
	 * @param CsrVO csrVO
	 * @return List<CsrVO>
	 * @throws DAOException
	 */
	public List<CsrVO> searchConsultationList(CsrVO csrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CsrVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new JointOperationConsultationDBDAOCsrListRSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CsrVO.class);
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
	 * CSR No로 CSR 정보를 조회한다.
	 * @param CsrVO csrVO
	 * @return List<CsrVO>
	 * @throws DAOException
	 */
	public List<CsrVO> searchDetailConsultation(CsrVO csrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CsrVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new JointOperationConsultationDBDAOCsrVORSQL(),
							param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CsrVO.class);			
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
	 * CSR을 한건 생성한다.
	 * @param CsrVO csrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCsr(CsrVO csrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOCsrVOCSQL(), param, velParam);
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
	 * CSR 한건 수정한다.
	 * @param CsrVO csrVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int modifyCsr(CsrVO csrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOCsrVOUSQL(), param, velParam);
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
	 * Tax Master정보를 조회한다.
	 * @param String csrNo
	 * @return List<JooTaxVO>
	 * @throws DAOException
	 */
	public List<JooTaxVO> searchTaxMasterList(String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooTaxVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("csr_no", csrNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new JointOperationConsultationDBDAOJooTaxVORSQL(),
							param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, JooTaxVO.class);			
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
	 * Tax Detail정보를 조회한다.
	 * @param JooTaxVO jooTaxVO
	 * @return List<JooTaxDtlVO>
	 * @throws DAOException
	 */
	public List<JooTaxDtlVO> searchTaxDetailList(JooTaxVO jooTaxVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooTaxDtlVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = jooTaxVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new JointOperationConsultationDBDAOJooTaxDtlVORSQL(),
							param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, JooTaxDtlVO.class);			
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
	 * AP CSR Evidence를 입력하기 위해 Vendor 정보를 조회한다.
	 * @param String vndrSeq
	 * @return List<JooTaxVO>
	 * @throws DAOException
	 */
	public List<JooTaxVO> searchVendorInfo(String vndrSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooTaxVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vndr_seq", vndrSeq);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new JointOperationConsultationDBDAOVendorInfoRSQL(),
							param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, JooTaxVO.class);			
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
	 * CSR Approval에서 cancel flag가 Y인 경우 CSR 번호로 Slip 정보를 삭제한다. 
	 * @param CsrVO csrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeSlipByCsr(CsrVO csrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOSlipDelByCsrDSQL(), param, velParam);
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
	 * CSR Approval에서 cancel flag가 Y인 경우 CSR 번호로 Tax정보를 삭제한다. 
	 * @param CsrVO csrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeTaxByCsr(CsrVO csrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOTaxDelByCsrDSQL(), param, velParam);
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
	 * CSR Approval에서 cancel flag가 Y인 경우 CSR 번호로 Tax Detail정보를 삭제한다. 
	 * @param CsrVO csrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeTaxDtlByCsr(CsrVO csrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOTaxDtlDelByCsrDSQL(), param, velParam);
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
	 * CSR 번호로 JOO_STL_CMB를 조회하여 CSR번호를 NULL로 수정한다. 
	 * @param CsrVO csrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyJooStlCmbClearCsrNo(CsrVO csrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOJooStlCmbClearCsrNoUSQL(), param, velParam);
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
	 * Slip정보를 조회한다.
	 * @param SlipConditionVO slipConditionVO
	 * @return List<CsrSlipVO>
	 * @throws DAOException
	 */
	public List<CsrSlipVO> searchSlipList(SlipConditionVO slipConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CsrSlipVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = slipConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new JointOperationConsultationDBDAOCsrSlipVORSQL(),
							param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CsrSlipVO.class);			
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
	 * CSR의 office 코드를 조회한다.
	 * @param SlipConditionVO slipConditionVO
	 * @return List<SlipConditionVO>
	 * @throws DAOException
	 */
	public List<SlipConditionVO> searchCsrOfcList(SlipConditionVO slipConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SlipConditionVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = slipConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new JointOperationConsultationDBDAOCsrOfcRSQL(),
							param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SlipConditionVO.class);			
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
	 * Settlement정보에서 Combined될 대상자료의 Rlane을 Distinct하게 조회한다.
	 * @param CmbConditionVO cmbConditionVO
	 * @return List<JooSettlementVO>
	 * @throws DAOException
	 */
	public List<JooSettlementVO> searchCombinedRlaneList(CmbConditionVO cmbConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooSettlementVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = cmbConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			//Rlane 정보 조회
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationConsultationDBDAOCombinedRlaneRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, JooSettlementVO.class);
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
	 * 다수의 Rlane을 선택하여 해당Rlane의 Combined될 대상자료를 Settlement에서 조회한다. 
	 * @param CmbConditionVO cmbConditionVO
	 * @return List<CombinedVO>
	 * @throws DAOException
	 */
	public List<CombinedVO> searchCombinedMonthlyClearanceByLaneList (CmbConditionVO cmbConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CombinedVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = cmbConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			List<String> rlaneCd = new ArrayList();
			String[] rlaneCds = cmbConditionVO.getRlaneCd().split(",");
			for(int i = 0; i < rlaneCds.length; i++){   
				rlaneCd.add(rlaneCds[i]);   
			}   
			velParam.put("rlane_cd", rlaneCd);   
			
			//Rlane 정보 조회
			//Combined No가 없으면 Create용으로  
			if (cmbConditionVO.getStlCmbSeq() == null || "".equals(cmbConditionVO.getStlCmbSeq())){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationConsultationDBDAOCombinedVORSQL(),param, velParam);
			//Combined No가 있으면 조회용
			}else{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationConsultationDBDAOCombinedDataRSQL(),param, velParam);
			}
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CombinedVO.class);
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
	 * Account Month, Carrier를 조회조건으로 Combined No.를 채번한다. 
	 * @param CmbConditionVO cmbConditionVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int searchNextStlSeq(CmbConditionVO cmbConditionVO) throws DAOException,Exception {
		int nextStlCmbSeq = 1;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cmbConditionVO != null){
				Map<String, String> mapVO = cmbConditionVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationConsultationDBDAONextStlCmbSeqRSQL(), param, velParam);
			List<JooStlCmbVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, JooStlCmbVO.class);
			
			if (!list.isEmpty()){
				JooStlCmbVO rtnVO = (JooStlCmbVO)list.get(0);
				nextStlCmbSeq = Integer.parseInt(rtnVO.getStlCmbSeq());
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return nextStlCmbSeq;
	}

	/**
	 * Combined정보를 생성한다.
	 * @param JooStlCmbVO jooStlCmbVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addJooStlCmb(JooStlCmbVO jooStlCmbVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = jooStlCmbVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOJooStlCmbVOCSQL(), param, velParam);
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
	 * Account Month, Carrier Code, Combined No로 Combined정보를 삭제한다.
	 * @param CmbConditionVO cmbConditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeJooStlCmbS(CmbConditionVO cmbConditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cmbConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOJooStlCmbVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to remove SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * AP CSR 정보를 조회한다.
	 * @param SlipProcessVO slipProcessVO
	 * @return List<SlipProcessVO>
	 * @throws DAOException
	 */
	public List<SlipProcessVO> searchAPConsultation (SlipProcessVO slipProcessVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SlipProcessVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = slipProcessVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationConsultationDBDAOSlipProcessVORSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SlipProcessVO.class);
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
	 * Slip Sequence 번호를 채번한다.
	 * @param SlipProcessVO slipProcessVO
	 * @return List<SlipProcessVO>
	 * @throws DAOException
	 */
	public String searchNextSlpSerNo(SlipProcessVO slipProcessVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SlipProcessVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String slpSerNo = "00001";
		try {
			Map<String, String> mapVO = slipProcessVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationConsultationDBDAONextSlpSerNoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SlipProcessVO.class);
			
			Iterator iterator = list.iterator();
			
			while (iterator.hasNext()){
				slpSerNo = ((SlipProcessVO)iterator.next()).getSlpSerNo(); 
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return slpSerNo;
	}

	/**
	 * JOO_SLP_SEQ에 한 건 입력한다.
	 * @param SlipProcessVO slipProcessVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addJooSlpSeq(SlipProcessVO slipProcessVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = slipProcessVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOSlpProcJooSlpSeqCSQL(), param, velParam);
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
	 * JOO_SLP_SEQ 에 Max Sequence를 UPDATE한다.
	 * @param SlipProcessVO slipProcessVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyJooSlpSeq(SlipProcessVO slipProcessVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = slipProcessVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOSlpProcJooSlpSeqUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * CSR Creation시에 JOO_STL_CMB에 CSR No.를 UPDATE한다.
	 * @param SlipProcessVO slipProcessVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyJooStlCmb(SlipProcessVO slipProcessVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = slipProcessVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOSlpProcJooStlCmbUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * JOO_SETTLEMENT를 인터페이스 에러난 건 Update한다.
	 * @param SlipProcessVO slipProcessVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyJooStlIf(SlipProcessVO slipProcessVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = slipProcessVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOSlpProJooStlIfUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	
	/**
	 * CSR Creation시에 JOO_CSR에 data를 입력한다. 
	 * @param SlipProcessVO slipProcessVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addJooCsr(SlipProcessVO slipProcessVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = slipProcessVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOSlpProcJooCsrCSQL(), param, velParam);
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
	 * CSR Creation시에 JOO_SLIP에 data를 입력한다. 
	 * @param SlipProcessVO slipProcessVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addJooSlp(SlipProcessVO slipProcessVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = slipProcessVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOSlpProcJooSlipCSQL(), param, velParam);
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
	 * Tax Sequence를 채번한다.
	 * @param JooTaxVO jooTaxVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchNextTaxSerNo(JooTaxVO jooTaxVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooTaxVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String taxSerNo = "00001";
		try {
			Map<String, String> mapVO = jooTaxVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationConsultationDBDAOSlpProcNextTaxSerNoRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, JooTaxVO.class);
			
			Iterator iterator = list.iterator();
			
			while (iterator.hasNext()){
				taxSerNo = ((JooTaxVO)iterator.next()).getTaxSerNo(); 
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return taxSerNo;
	}

	/**
	 * Tax정보를 생성한다.
	 * @param JooTaxVO jooTaxVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addJooTax(JooTaxVO jooTaxVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = jooTaxVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOSlpProcJooTaxCSQL(), param, velParam);
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
	 * Tax상세정보를 생성한다.
	 * @param JooTaxDtlVO jooTaxDtlVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addJooTaxDtl(JooTaxDtlVO jooTaxDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = jooTaxDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOSlpProcJooTaxDtlCSQL(), param, velParam);
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
	 * Eff.Date변경시에 해당일자로 마감이 되었는지 여부를 check한다.
	 * O : Open - 마감 전임으로 그대로 Effective Date를 사용한다.
   	 * C : Closing - 마감이 완료되었으면 다음달 첫일로 Effective Date를 넣어준다.
	 * @param SlipProcessVO slipProcessVO
	 * @return SlipProcessVO
	 * @throws DAOException
	 */
	public SlipProcessVO searchCloseYn(SlipProcessVO slipProcessVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SlipProcessVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = slipProcessVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationConsultationDBDAOSlpProcCheckClosRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SlipProcessVO.class);
			
			if (list.isEmpty()){
				slipProcessVO.setVvdCxlFlg("E");
			}else{
				slipProcessVO = list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return slipProcessVO;
	}

	/**
	 * JOO_STL_CMB_DTL테이블에 Combined Detail정보를 입력한다.
	 * @param JooStlCmbDtlVO jooStlCmbDtlVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addJooStlCmbDtl(JooStlCmbDtlVO jooStlCmbDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = jooStlCmbDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOCombinedJooStlCmbDtlCSQL(), param, velParam);
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
	 * JOO_STL_CMB_DTL테이블에 Combined Detail정보를 입력한다. (DUP나는 경우 1을 return한다.
	 * @param JooStlCmbDtlVO jooStlCmbDtlVO
	 * @return int
	 * @throws DAOException
	 * @throws Exception
	 */
	public int addJooStlCmbDtlSkipForDup(JooStlCmbDtlVO jooStlCmbDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int rtnVal = 0;
		try {
			Map<String, String> mapVO = jooStlCmbDtlVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOCombinedJooStlCmbDtlCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			//dup이 나면 1을 return한다.
			if (se.getErrorCode() == 1){
				rtnVal = 1;
			}else{
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return rtnVal;
	}
	
	/**
	 * Combined Detail정보를 삭제한다.
	 * @param CmbConditionVO cmbConditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeJooStlCmbDtlS(CmbConditionVO cmbConditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cmbConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOCombinedJooStlCmbDtlDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Reverse전표생성시 기존 Combined Data의 RVS_CMB_FLG = 'Y'로 UPDATE
	 * @param CsrVO csrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyJooStlCmbByReverse(CsrVO csrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOReverseJooStlCmbUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 * Reverse 전표생성시 JOO_SETTLEMENT의 CMB_CFM_FLG = 'N'으로 UPDATE하기 위해 JOO_STL_CMB_DTL을 조회한다. 
	 * @param CsrVO csrVO
	 * @return List<JooStlCmbDtlVO> list
	 * @throws DAOException
	 */
	public List<JooStlCmbDtlVO> searchJooStlCmbDtlForReverse(CsrVO csrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooStlCmbDtlVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationConsultationDBDAOReverseJooStlCmbDtlRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, JooStlCmbDtlVO.class);
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
	 * Reverse 전표생성시 joo_slip을 copy하기 위해 기존 정보를 조회한다.
	 * @param CsrVO csrVO
	 * @return List<JooSlipVO>
	 * @throws DAOException
	 */
	public List<JooSlipVO> searchJooSlipForReverse(CsrVO csrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<JooSlipVO> list = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationConsultationDBDAOReverseJooSlipRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, JooSlipVO.class);
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
	 * Reverse전표생성시 JOO_SLIP을 copy하여 -금액을 INSERT한다.
	 * @param JooSlipVO jooSlipVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addJooSlpByReverse(JooSlipVO jooSlipVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = jooSlipVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOReverseJooSlipCSQL(), param, velParam);
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
	 * 전표승인시 ERP로 전송할 데이터를 JOO_AR_MN, JOO_AR_CHG테이블에 저장하기 위해 데이터를 조회한다.
	 * @param CsrVO csrVO
	 * @return List<ArMnChgVO>
	 * @throws DAOException
	 */
	public List<ArMnChgVO> searchArInfoForApproval(CsrVO csrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ArMnChgVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationConsultationDBDAOArMnChgVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArMnChgVO.class);			
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
	 * 전표승인시 ERP에 전송할 데이터를 JOO_AR_MN테이블에 저장한다.
	 * @param ArMnChgVO arMnChgVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addJooArMn(ArMnChgVO arMnChgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = arMnChgVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOJooArMnCSQL(), param, velParam);
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
	 * 전표승인시 ERP에 전송할 데이터를 JOO_AR_CHG테이블에 저장한다.
	 * @param ArMnChgVO arMnChgVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addJooArChg(ArMnChgVO arMnChgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = arMnChgVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOJooArChgCSQL(), param, velParam);
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
	 * CSR AP Approval시에 AP_INV_HDR에 INSERT하기 위한 조회
	 * @param CsrVO csrVO
	 * @return List<InvHdrVO>
	 * @throws DAOException
	 */
	public List<InvHdrVO> searchApHeaderInfoForApproval(CsrVO csrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvHdrVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationConsultationDBDAOInvHdrVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvHdrVO.class);			
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
	 * CSR AP Approval시에 AP_INV_DTRB에 INSERT하기 위한 조회
	 * @param CsrVO csrVO
	 * @return List<InvDtrbVO>
	 * @throws DAOException
	 */
	public List<InvDtrbVO> searchApDetailInfoForApproval(CsrVO csrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvDtrbVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationConsultationDBDAOInvDtrbVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvDtrbVO.class);			
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
	 * AP 전표 승인시에 ERP에 전송전 AP_INV_HDR 테이블에 자료를 입력한다.
	 * @param InvHdrVO invHdrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addApInvHdr(InvHdrVO invHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = invHdrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOApInvHdrCSQL(), param, velParam);
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
	 * AP 전표 승인시에 ERP에 전송전 AP_INV_DTRB 테이블에 자료를 입력한다.
	 * @param InvDtrbVO invDtrbVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addApInvDtrb(InvDtrbVO invDtrbVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = invDtrbVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOApInvDtrbCSQL(), param, velParam);
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
	 * 승인된 AP CSR을 ERP에 넘기기전 AP_INV_IF테이블에 INSERT한다.
	 * @param InvIfVO invIfVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addApInvIf(InvIfVO invIfVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = invIfVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOApInvIfCSQL(), param, velParam);
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
     * 
     * AR정보를 조회합니다.<br>
     *
     * @param  ArDataInqVO arDataInqVO
     * @throws EventException
     * @return List<ArDataInqVO>
     * @author jang kang cheol
     */
    public List<ArDataInqVO> searchARDataInquiry(ArDataInqVO arDataInqVO ) throws DAOException{   
        DBRowSet dbRowset = null;
        List<ArDataInqVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = arDataInqVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            if(arDataInqVO.getReDivrCd().equals("E")){//ACCT
                if(arDataInqVO.getSumYn().equals("Y")){
                    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new  JointOperationConsultationDBDAOSearchARDataInquiryRSQL(), param, velParam);
                }else{
                    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new  JointOperationConsultationDBDAOSearchARDataInquiryDetailRSQL(), param, velParam);
                }
            }else if(arDataInqVO.getReDivrCd().equals("R")){//REVENUE
                if(arDataInqVO.getSumYn().equals("Y")){
                    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new  JointOperationConsultationDBDAOSearchRevSumARDataInquiryRSQL(), param, velParam);
                }else{
                    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new  JointOperationConsultationDBDAOSearchRevDetailARDataInquiryRSQL(), param, velParam);
                }
            }
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArDataInqVO.class);         
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
     * 
     * AR_total정보를 조회합니다.<br>
     *
     * @param  ArDataInqVO arDataInqVO
     * @throws EventException
     * @return List<ArDataInqVO>
     * @author jang kang cheol
     */
    public List<ArDataInqVO> searchARDataInquirySum(ArDataInqVO arDataInqVO ) throws DAOException{   
        DBRowSet dbRowset = null;
        List<ArDataInqVO> list = null;
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            Map<String, String> mapVO = arDataInqVO.getColumnValues();
            param.putAll(mapVO);
            velParam.putAll(mapVO);
            if(arDataInqVO.getReDivrCd().equals("E")){//ACCT
                if(arDataInqVO.getSumYn().equals("Y")){
                	///111
                    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new  JointOperationConsultationDBDAOSearchARDataInquirySumRSQL(), param, velParam);
                }else{
                    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new  JointOperationConsultationDBDAOSearchARDataInquiryDetailSumRSQL(), param, velParam);
                }
            }else if(arDataInqVO.getReDivrCd().equals("R")){//REVENUE
                if(arDataInqVO.getSumYn().equals("Y")){
                    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new  JointOperationConsultationDBDAOSearchRevSumARDataInquirySumRSQL(), param, velParam);
                }else{
                    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new  JointOperationConsultationDBDAOSearchRevDetailARDataInquirySumRSQL(), param, velParam);
                }
            }
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArDataInqVO.class);         
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
     * AR정보중 Disabled된 VVD 정보를 조회합니다.<br>
     * @param  ArDisabledVVDVO arDisabledVVDVO
     * @return List<ArDisabledVVDVO>
     * @throws EventException
     */
    public List<ArDisabledVVDVO> searchARDisabledVVD(ArDisabledVVDVO arDisabledVVDVO)  throws DAOException {
        DBRowSet dbRowset = null;
        List<ArDisabledVVDVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(arDisabledVVDVO != null){
                Map<String, String> mapVO = arDisabledVVDVO .getColumnValues();
            
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new  JointOperationConsultationDBDAOSearchARDisabledVVDRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArDisabledVVDVO .class);
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
	 * CSR No로 CSR 정보를 조회한다.
	 * @param CsrVO csrVO
	 * @return List<ApIfErrVO>
	 * @throws DAOException
	 */
	public List<ApIfErrVO> searchApIfErrList(CsrVO csrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ApIfErrVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new JointOperationConsultationDBDAOApIfErrRSQL(),
							param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApIfErrVO.class);			
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
	 * Settlement되었는데 Combined 되지 않거나 Comined되었으나 CSR생성되지 않은 data를 조회한다.
	 * @param SlipConditionVO slipConditionVO
	 * @return List<LostCombinedDataVO>
	 * @throws DAOException
	 */
	public List<LostCombinedDataVO> searchLostCombinedDataList(SlipConditionVO slipConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<LostCombinedDataVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = slipConditionVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new JointOperationConsultationDBDAOLostCombinedDataVORSQL(),
							param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LostCombinedDataVO.class);			
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
	 * Settlement에서 Combined가 되지 않았거나 CSR이 끊기지 않은 것들의 office 코드를 조회한다.
	 * @param SlipConditionVO slipConditionVO
	 * @return List<SlipConditionVO>
	 * @throws DAOException
	 */
	public List<SlipConditionVO> searchStlOfcList(SlipConditionVO slipConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SlipConditionVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = slipConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new JointOperationConsultationDBDAOStlOfcRSQL(),
							param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SlipConditionVO.class);			
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
	 * ERP I/F Error 시 JOO_TAX_DTL 삭제
	 * @param CsrVO csrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeJooTaxDtlForIFE(CsrVO csrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOIFETaxDtlDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ERP I/F Error 시 JOO_TAX 삭제
	 * @param CsrVO csrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeJooTaxForIFE(CsrVO csrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOIFETaxDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ERP I/F Error 시 JOO_SLIP 삭제
	 * @param CsrVO csrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeJooSlipForIFE(CsrVO csrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOIFESlipDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ERP I/F Error 시 JOO_CSR 삭제
	 * @param CsrVO csrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeJooCsrForIFE(CsrVO csrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOIFECsrDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * ERP I/F ERROR DATA를 REJECT 하게되면 JOO_STL_CMB_DTL을 삭제한다. 
	 * @param CsrVO csrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeJooStlCmbDtlForIFE(CsrVO csrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOIFEStlCmbDtlDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ERP I/F ERROR DATA를 REJECT 하게되면 JOO_STL_CMB을 삭제한다. 
	 * @param CsrVO csrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeJooStlCmbForIFE(CsrVO csrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOIFEStlCmbDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * COM_APRO_RQST_HDR에 UPDATE 한다.
	 * @param CsrVO csrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyComAproRqstHdr(CsrVO csrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOAproRqstHdrUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	

	/**
	 * COM_APRO_RQST_ROUT에 UPDATE 한다.
	 * 
	 * @param CsrVO csrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyComAproRqstRout(CsrVO csrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOAproRqstRoutUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * CSR No로 CSR 정보를 조회한다.
	 * @param CsrVO csrVO
	 * @return List<CsrVO>
	 * @throws DAOException
	 */
	public List<CsrVO> searchCsrDetail(CsrVO csrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CsrVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new JointOperationConsultationDBDAOCsrDetailRSQL(),
							param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CsrVO.class);			
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
     * 금액이 10만불 이상, 이하일때 결재라인에 CEO,본부장 있는지 조회한다.
     * 
     * @param csrNo String
     * @param usrId String 
     * @return String
     * @throws EventException
     */	
    public String searchApproveJOOYn (String csrNo, String usrId) throws DAOException {
        DBRowSet dbRowset = null;
        String rtnVal = "";
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {
            param.put("lgn_usr_id", usrId);        	
            param.put("csr_no", csrNo);            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationConsultationDBDAOSearchApproveJOOYnRSQL(), param, velParam);
            if(dbRowset.next()){
                rtnVal = dbRowset.getString("CHK_VAL_YN");            	
            }            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rtnVal;
    }	
	
    
    /**
     * 결재라인 중간단계에 CEO가 있는지 조회한다.
     * 
     * @param String csrNo
     * @return String
     * @throws EventException
     */
    public String searchApproveJOOCeoYn (String csrNo) throws DAOException {
        DBRowSet dbRowset = null;
        String rtnVal = "";
        // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {        	
            param.put("csr_no", csrNo);            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationConsultationDBDAOSearchApproveJOOCeoYnRSQL(), param, velParam);
            if(dbRowset.next()){
                rtnVal = dbRowset.getString("CEO_YN");            	
            }            
        } catch (SQLException se) {
            log.error(se.getMessage(), se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
        return rtnVal;
    }	    
    

	/**
	 * GW문서를 저장한다(수정)<br>
	 * 
	 * @param csrVO CsrVO
	 *  
	 * @throws DAOException
	 * @throws Exception 
	 */
	public void manageGW(CsrVO csrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAOManageGWUSQL(), param, velParam);
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
	 * CSR No.로 GW Contract Link 목록 조회한다.<br>
	 * 
	 * @param String csrNo
	 * @return List<AgmtDocVO>
	 * @throws DAOException
	 */
	public List<AgmtDocVO> searchGWDoc(String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgmtDocVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			 param.put("csr_no", csrNo);           
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationConsultationDBDAOGWDocRSQL(),param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgmtDocVO.class);			
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
	 * GW Contract Link정보를 생성한다.
	 * 
	 * @param List<AgmtDocVO> agmtDocVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addGWDoc(List<AgmtDocVO> agmtDocVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(agmtDocVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationConsultationDBDAOGWDocMrgVOCSQL(), agmtDocVOs,null);
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
	 * GW Contract Link정보를 갱신한다.
	 * 
	 * @param List<AgmtDocVO> agmtDocVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyGWDoc(List<AgmtDocVO> agmtDocVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(agmtDocVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationConsultationDBDAOGWDocMrgVOUSQL(), agmtDocVOs,null);
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
	}
	
	/**
	 * GW Contract Link정보를 삭제한다.
	 * 
	 * @param List<AgmtDocVO> agmtDocVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeGWDoc(List<AgmtDocVO> agmtDocVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(agmtDocVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationConsultationDBDAOGWDocMrgVODSQL(), agmtDocVOs,null);
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
	}

	/**
	 * CSR No.로 Agreement Doc 존재여부를 조회한다. <br>
	 * 
	 * @param String csrNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchAgmtCfmCd(String csrNo) throws DAOException {
        DBRowSet dbRowset = null;
        String rtnVal = "";		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			 param.put("csr_no", csrNo);           
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationConsultationDBDAOAgmtCfmCdRSQL(),param, velParam);
			
             if(dbRowset.next()){
                rtnVal = dbRowset.getString("AGMT_CNT_YN");            	
             }    			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVal;
	}	
	
	/**
	 * 다수의 Rlane을 선택하여 해당Rlane의 Combined될 대상자료를 Settlement에서 조회한다. 
	 * @param CmbConditionVO cmbConditionVO
	 * @return List<CombinedVO>
	 * @throws DAOException
	 */
	public List<CombinedVO> searchCombinedDupList (CmbConditionVO cmbConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CombinedVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = cmbConditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			//DUP에 관련된 CSR NO, BSA_QTY, BSA_SLT_PRC, STL_LOCL_AMT 정보 조회
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationConsultationDBDAOCombinedDupRSQL(),param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CombinedVO.class);
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
	 * CSR No.로 이중결재여부를 조회한다. <br>
	 * 
	 * @param String csrNo
	 * @return String
	 * @throws DAOException
	 */
	public String chkLoclAmt(String csrNo) throws DAOException {
        DBRowSet dbRowset = null;
        String rtnVal = "";		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			 param.put("csr_no", csrNo);           
			 
				//AR인 경우
			 if ("18".equals(csrNo.substring(0,2))){			 
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationConsultationDBDAOChkLoclAmtRSQL(),param, velParam);
			 }else{
				 //AP인 경우
				 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationConsultationDBDAOChkLoclAmtAPRSQL(),param, velParam);				 
			 }
			
             if(dbRowset.next()){
                rtnVal = dbRowset.getString("DOU_PAY_CHK");            	
             }    			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVal;
	}
	
	/**
	 * COM_APRO_RQST_HDR의 DELT_FLG = 'Y' 처리.
	 * @param CsrVO csrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeComAproRqstHdr(CsrVO csrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAORemoveComAproRqstHdrUSQL(), param, velParam);
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
	 * COM_APRO_RQST_ROUT의 DELT_FLG = 'Y' 처리.
	 * @param CsrVO csrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeComAproRqstRout(CsrVO csrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAORemoveComAproRqstRoutUSQL(), param, velParam);
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
	 * COM_APRO_CSR_DTL의 DELT_FLG = 'Y' 처리.
	 * @param CsrVO csrVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeComAproCsrDtl(CsrVO csrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = csrVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationConsultationDBDAORemoveComAproCsrDtlUSQL(), param, velParam);
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
}
