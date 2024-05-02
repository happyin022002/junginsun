/*****=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : OffdockCYInvoiceManageDBDAO.java
 *@FileTitle : Off-dock CY Invoice 관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-10-09
 *@LastModifier : byungheeyoo
 *@LastVersion : 1.0
 * 2006-09-14 byungheeyoo
 * 1.0 최초 생성
 * 2009-03-12 [R200903110001] : TES_TML_SO_PAY_DYS 테이블 미사용 제거 주석처리
 * 2009-05-29 [N200905280100] : TPB I/F 누락 방지 추가
 * 2009-11-09 [CHM-200901422] : [TES] Storage 계산시 Movement Gate In&Out 조회 조건 보완 요청
 * 2009-12-23 [CHM-200901951] : Offdock Freepool calculation 월별/ 일별로 받는 부분에 처리되는 로직 수정
 * 2010-01-13 [CHM-201002217] : Storage, Offdock Container Verify 조회조건 수정
 * =========================================================*****/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.tes.common.vo.TesCommonVO;
import com.clt.apps.opus.esd.tes.common.tescommon.integration.TESCommonDBDAOSearchBkgCntrTPCDListRSQL; 
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.basic.OffdockCYInvoiceManageBCImpl;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes0004Event;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.vo.OffdockCYInvoiceManageVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.TesFileImpTmpVO;
import com.clt.syscommon.common.table.TesN3rdPtyIfVO;
import com.clt.syscommon.common.table.TesTmlSoCntrListVO;
import com.clt.syscommon.common.table.TesTmlSoDtlVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;
import com.clt.syscommon.common.table.TesTmlSoRvisListVO;

/**
 * ESD에 대한 DB 처리를 담당<br>
 * ESD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author byungheeyoo
 * @see OffdockCYInvoiceManageBCImpl 참조
 * @since J2EE 1.6
 */
public class OffdockCYInvoiceManageDBDAO extends DBDAOSupport {

	
	/**
	 * Cost Calc. 계산하기
	 * 
	 * @param model
	 * @exception DAOException
	 */
	public void calOffdockCYInvoiceCostTMNLUpdate(TesTmlSoHdrVO model) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				velParam.putAll( mapVO );	 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OffdockCYInvoiceManageDBDAOCalOffdockCYInvoiceCostTMNLUpdateUSQL(), param, velParam);
			
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
	 * Cost Calc. 계산하기
	 * 
	 * @param TesTmlSoHdrVO model
	 * @param OffdockCYInvoiceManageVO paramVO
	 * @param String agmtCostYN
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet calOffdockCYInvoiceCostTMNL(TesTmlSoHdrVO model, OffdockCYInvoiceManageVO paramVO, String agmtCostYN) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			log.debug(">>>>>>>> paramVO.getTmlCalcIndCd(): "+paramVO.getTmlCalcIndCd());
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				param.put("tml_calc_ind_cd", JSPUtil.getNull(paramVO.getTmlCalcIndCd()));	
				param.put("to_prd_dt", JSPUtil.replace(model.getToPrdDt(),"-","") );
				velParam.putAll(mapVO);				
			}
			
			velParam.put("agmt_cost_yn", agmtCostYN);
			
			if("Y".equals(model.getTmlOdckFlg())){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOCalOffdockCYInvoiceCost2TMNLRSQL(), param, velParam);
			}else{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOCalOffdockCYInvoiceCostTMNLRSQL(), param, velParam);
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

		return dbRowset;
	}
	
	/**
	 * Cost Calc. 계산하기
	 * 
	 * @param model
	 * @param paramVO
	 * @param agmtCostYN
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet calOffdockCYInvoiceCostTMNLseparate(TesTmlSoHdrVO model, OffdockCYInvoiceManageVO paramVO, String agmtCostYN) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			log.debug(">>>>>>>> paramVO.getTmlCalcIndCd(): "+paramVO.getTmlCalcIndCd());
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				param.put("tml_calc_ind_cd", JSPUtil.getNull(paramVO.getTmlCalcIndCd()));	
				param.put("fm_prd_dt", JSPUtil.replace(model.getFmPrdDt(),"-","") );
				param.put("to_prd_dt", JSPUtil.replace(model.getToPrdDt(),"-","") );
				velParam.putAll(mapVO);				
			}
			
			velParam.put("agmt_cost_yn", agmtCostYN);
			
			if("Y".equals(model.getTmlOdckFlg())){
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOCalOffdockCYInvoiceCost2TMNLseparateRSQL(), param, velParam);
			}else{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOCalOffdockCYInvoiceCostTMNLseparateRSQL(), param, velParam);
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

		return dbRowset;
	}
	
	/**
	 * Cost Calc. 계산하기
	 * 
	 * @param model TesTmlSoHdrVO
	 * @param paramVO OffdockCYInvoiceManageVO
	 * @param String agmtCostYN
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet calOffdockCYInvoiceCostByDay(TesTmlSoHdrVO model, OffdockCYInvoiceManageVO paramVO, String agmtCostYN) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				param.put("sto_dys_ind_cd", JSPUtil.getNull(model.getStoDysIndCd()));	
				param.put("yd_cd", JSPUtil.getNull(model.getYdCd()));	
				param.put("vndr_seq", JSPUtil.getNull(model.getVndrSeq()));	
				param.put("fm_prd_dt", JSPUtil.replace(model.getFmPrdDt(),"-","") );
				param.put("to_prd_dt", JSPUtil.replace(model.getToPrdDt(),"-","") );
				velParam.putAll(mapVO);				
			}

			velParam.put("agmt_cost_yn", agmtCostYN);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOCalOffdockCYInvoiceCostByDayRSQL(), param, velParam);
			
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

		return dbRowset;
	}
	
	/**
	 * Container Verify 용 임시파일 저장.<br>
	 * @param List<TesFileImpTmpVO> voList
	 * @exception DAOException
	 */
	public void createTES_FILE_IMP_TMP( List<TesFileImpTmpVO> voList ) throws DAOException {

		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OffdockCYInvoiceManageDBDAOCreateTES_FILE_IMP_TMPCSQL(), voList, null, null);
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
	 * OffDock CY Invoice Container List Import File Delete.
	 * verify 임시 data를 삭제 (ByDay와 ByPool 공통)
	 * 
	 * @param model 데이타 모델
	 * @exception DAOException
	 */	
	public void removeTES_FILE_IMP_TMP(TesTmlSoHdrVO model) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				velParam.putAll( mapVO );	 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OffdockCYInvoiceManageDBDAORemoveTES_FILE_IMP_TMPDSQL(), param, velParam);
			
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
	 * OffDock CY Invoice Container Number Select
	 * 
	 * @param model
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCNTRNumber(TesTmlSoHdrVO model) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchCNTRNumberRSQL(), param, velParam);
			
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

		return dbRowset;
	}
	
	/** 
	 * OffDock CY Invoice Container Number Update.<br>
	 *
	 * @param List<TesFileImpTmpVO> voList
	 * @exception DAOException
	 */
	public void updateCNTRNumber(List<TesFileImpTmpVO> voList ) throws DAOException {
		try {						
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OffdockCYInvoiceManageDBDAOUpdateCNTRNumberUSQL(), voList, null, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * OffDock CY Invoice Container List Import File Select
	 * 
	 * @param paramVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchTES_FILE_IMP_TMP(TesTmlSoHdrVO paramVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= paramVO.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				param.put("tmlSoOfcCtyCd", JSPUtil.getNull(paramVO.getTmlSoOfcCtyCd()));
				param.put("tmlSoSeq", JSPUtil.getNull(paramVO.getTmlSoSeq()));	
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchTES_FILE_IMP_TMPRSQL(), param, null);
			
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

		return dbRowset;
	}
	
	/**
	 * insertOffdockCYInvoiceContainerList 에 내용을 포함시켰음
	 * OPUS 에서는 더이상 사용안함
	 * verify하기 - verify하고 그 결과를 바로 cntr_list에 때려 넣는다.
	 * OffDock CY Invoice Container List Verify
	 * 
	 * @param model
	 * @param model2
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet verifyOffdockCYInvoiceVolume(TesTmlSoHdrVO model, TesCommonVO model2) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String tml_calc_ind_cd = model!=null?JSPUtil.getNull((String)model.getTmlCalcIndCd()):"";
		String sto_dys_ind_cd  = model!=null?JSPUtil.getNull((String)model.getStoDysIndCd()):"";
		try {
			Map<String, String> mapVO	= model.getColumnValues();
			Map<String, String> mapVO2	= model2.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				param.put("tml_calc_ind_cd", tml_calc_ind_cd);
				param.put("fm_prd_dt", JSPUtil.replace(model.getFmPrdDt(), "-", ""));
				param.put("to_prd_dt", JSPUtil.replace(model.getToPrdDt(), "-", ""));
				velParam.putAll(mapVO);				
				velParam.put("tml_calc_ind_cd", tml_calc_ind_cd);	
				velParam.put("sto_dys_ind_cd", sto_dys_ind_cd);		
			}
			
			if ( mapVO2 != null ) {
				param.putAll(mapVO2);
				velParam.putAll(mapVO2);				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOVerifyOffdockCYInvoiceVolumeRSQL(), param, velParam);
			
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

		return dbRowset;		
	}
	
	/** verifyOffdockCYInvoiceForGates
	 * 
	 * @param model
	 * @param model2
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet verifyOffdockCYInvoiceForGates(TesTmlSoHdrVO model, TesCommonVO model2) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String tml_calc_ind_cd = model!=null?JSPUtil.getNull((String)model.getTmlCalcIndCd()):"";
		String sto_dys_ind_cd  = model!=null?JSPUtil.getNull((String)model.getStoDysIndCd()):"";
		try {
			Map<String, String> mapVO	= model.getColumnValues();
			Map<String, String> mapVO2	= model2.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				param.put("tml_calc_ind_cd", tml_calc_ind_cd);
				param.put("fm_prd_dt", JSPUtil.replace(model.getFmPrdDt(), "-", ""));
				param.put("to_prd_dt", JSPUtil.replace(model.getToPrdDt(), "-", ""));
				velParam.putAll(mapVO);				
				velParam.put("tml_calc_ind_cd", tml_calc_ind_cd);	
				velParam.put("sto_dys_ind_cd", sto_dys_ind_cd);		
			}
			
			if ( mapVO2 != null ) {
				param.putAll(mapVO2);
				velParam.putAll(mapVO2);				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOVerifyOffdockCYInvoiceForGatesRSQL(), param, velParam);
			
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

		return dbRowset;		
	}	
	/**
	 * OffDock CY Invoice Revised Volume TP Select
	 * 
	 * @param model
	 * @param OffdockCYInvoiceManageVO paramVO
	 * @return DBRowSet
	 * @exception DAOException
	 */	
	public DBRowSet searchRevisedVolume(TesTmlSoHdrVO model, OffdockCYInvoiceManageVO paramVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				param.put("param_cntr_tpsz_cd", JSPUtil.getNull(paramVO.getParamCntrTpszCd()));
				param.put("param_dcgo_clss_cd", JSPUtil.getNull(paramVO.getParamDcgoClssCd()));
				param.put("param_rc_flg", JSPUtil.getNull(paramVO.getParamRcFlg()));
				param.put("param_lgs_cost_cd", JSPUtil.getNull(paramVO.getParamLgsCostCd()));			
				velParam.putAll(mapVO);				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchRevisedVolumeRSQL(), param, velParam);
			
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

		return dbRowset;		
	}	
	
	/**
	 * OffDock CY Invoice Revised Volume TP Select
	 * 
	 * @param model
	 * @param OffdockCYInvoiceManageVO paramVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchRevisedVolumeManual(TesTmlSoHdrVO model, OffdockCYInvoiceManageVO paramVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				param.put("tml_so_dtl_seq", JSPUtil.getNull(paramVO.getTmlSoDtlSeq()));
				param.put("param_lgs_cost_cd", JSPUtil.getNull(paramVO.getParamLgsCostCd()));	
				velParam.putAll(mapVO);				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchRevisedVolumeManualRSQL(), param, velParam);
			
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

		return dbRowset;
	}		
	
	/**
	 * OffDock CY Invoice Revised Volume Separate Select
	 * 
	 * @param model
	 * @param OffdockCYInvoiceManageVO paramVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchRevisedVolumeSeparate(TesTmlSoHdrVO model, OffdockCYInvoiceManageVO paramVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			log.debug(">>>>>>>> paramVO.getFmPrdDt(): "+paramVO.getFmPrdDt());
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				param.put("tml_so_dtl_seq", JSPUtil.getNull(paramVO.getFmPrdDt()).replaceAll("-",""));
				param.put("fm_prd_dt", JSPUtil.getNull(paramVO.getFmPrdDt()));
				param.put("param_cntr_tpsz_cd", JSPUtil.getNull(paramVO.getParamCntrTpszCd()));
				param.put("param_dcgo_clss_cd", JSPUtil.getNull(paramVO.getParamDcgoClssCd()));
				param.put("param_rc_flg", JSPUtil.getNull(paramVO.getParamRcFlg()));
				param.put("param_lgs_cost_cd", JSPUtil.getNull(paramVO.getParamLgsCostCd()));	
				velParam.putAll(mapVO);				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchRevisedVolumeSeparateRSQL(), param, velParam);
			
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

		return dbRowset;

	}	
	
	/**
	 * OffDock CY Invoice Revised Volume Separate Select
	 * 
	 * @param model
	 * @param OffdockCYInvoiceManageVO paramVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchRevisedVolumeSeparateManual(TesTmlSoHdrVO model, OffdockCYInvoiceManageVO paramVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				param.put("tml_so_dtl_seq", JSPUtil.getNull(paramVO.getTmlSoDtlSeq()));
				param.put("param_lgs_cost_cd", JSPUtil.getNull(paramVO.getParamLgsCostCd()));
				velParam.putAll(mapVO);				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchRevisedVolumeSeparateManualRSQL(), param, velParam);
			
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

		return dbRowset;
	}
	
	/**
	 * OffDock CY Invoice 수동시 revise mode TP Select
	 * 
	 * @param OffdockCYInvoiceManageVO paramVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchOffdockCYReviseModeSeparate(OffdockCYInvoiceManageVO paramVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= paramVO.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchOffdockCYReviseModeSeparateRSQL(), param, velParam);
			
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

		return dbRowset;
	}
	
	/**
	 * maybe not use method.
	 * OffDock CY Invoice revise mode(N) container 목록 TP Select
	 * 
	 * @return DBRowSet
	 * @exception DAOException
	 */
//	public DBRowSet searchOffdockCYRvisCntrListCdN() throws DAOException {
//		log.debug("\n\n -- searchOffdockCYRvisCntrListCdN ------------ \n\n");
//		Connection con = null;
//		
//		PreparedStatement ps = null;
//		
//		ResultSet rs = null;
//		
//		DBRowSet dRs = null;
//		
//		
//		StringBuffer queryStr = new StringBuffer(); 
//		queryStr.append(" SELECT A.*								\n");
//		queryStr.append(" FROM (	                                                        \n");
//		queryStr.append(" 	SELECT                                                          \n");      
//		queryStr.append(" 	   DECODE(NVL(L.TML_RVIS_IND_FLG,'N'),'Y','1','0') DEL_CHK,         \n");             
//		queryStr.append(" 	   L.TML_RVIS_IND_FLG,                                              \n");        
//		queryStr.append(" 	   L.TML_SO_OFC_CTY_CD,                                         \n");      
//		queryStr.append(" 	   L.TML_SO_SEQ,                                                \n");
//		queryStr.append(" 	   L.TML_SO_CNTR_LIST_SEQ,                                      \n");         
//		queryStr.append(" 	   L.CNTR_NO,                                                   \n");
//		queryStr.append(" 	   L.CNTR_TPSZ_CD,                                               \n");
//		queryStr.append(" 	   L.CNTR_STY_CD,                                               \n");
//		queryStr.append(" 	   L.IO_BND_CD,                                                 \n");
//		queryStr.append(" 	   DECODE(L.CNTR_STY_CD,'F','TMFDFL','TMFDMT') LGS_COST_CD,     \n");        
//		queryStr.append(" 	   L.BL_NO,                                                     \n");
//		queryStr.append(" 	   TO_CHAR(L.INV_GATE_IN_DT,'YYYY-MM-DD HH24:MI') INV_GATE_IN_DT,    \n");
//		queryStr.append(" 	   TO_CHAR(L.INV_GATE_OUT_DT,'YYYY-MM-DD HH24:MI') INV_GATE_OUT_DT,    \n");	
//		queryStr.append(" 	   DECODE(L.INV_GATE_IN_DT,NULL,0,'',0,DECODE(L.RVIS_GATE_IN_FLG,'Y',0,1)) RVIS_GATE_IN_FLG,    \n"); //꺼꾸로
//		queryStr.append(" 	   DECODE(L.INV_GATE_OUT_DT,NULL,0,'',0,DECODE(L.RVIS_GATE_OUT_FLG,'Y',0,1)) RVIS_GATE_OUT_FLG,  \n"); //꺼꾸로
//		queryStr.append(" 	   L.RVIS_GATE_IN_FLG,                                          \n");
//		queryStr.append(" 	   L.RVIS_GATE_OUT_FLG,                                         \n");
//		queryStr.append(" 	   L.AWK_CGO_FLG,                                               \n");
//		queryStr.append(" 	   L.RC_FLG,                                                    \n");		
//		queryStr.append(" 	   L.CNTR_RMK                                                   \n");
//		queryStr.append(" 	FROM TES_TML_SO_HDR H, TES_TML_SO_CNTR_LIST L                   \n");                          
//		queryStr.append(" 	WHERE 1=1                                                       \n");
//		queryStr.append(" 	AND H.TML_SO_OFC_CTY_CD = L.TML_SO_OFC_CTY_CD                   \n");                                                           
//		queryStr.append(" 	AND H.TML_SO_SEQ        = L.TML_SO_SEQ                          \n");
//		queryStr.append(" 	AND H.TML_SO_OFC_CTY_CD = ?                                     \n");                                                
//		queryStr.append(" 	AND H.TML_SO_SEQ = ?                                            \n");
//		queryStr.append(" 	AND L.VRFY_RSLT_IND_CD = 'CO'                                   \n");
//		queryStr.append(" ) A                                                               \n");
//		queryStr.append(" WHERE 1=1                                                         \n");
//		queryStr.append(" AND A.LGS_COST_CD = SUBSTR(?,1,4)||'MT'                           \n");
//		queryStr.append(" ORDER BY A.CNTR_NO ASC, A.CNTR_TPSZ_CD ASC, A.CNTR_STY_CD ASC, A.IO_BND_CD ASC \n");
		
//		try {
//			con = getConnection();
//			
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				ps = new LoggableStatement(con, queryStr.toString());
//			} else {
//				ps = con.prepareStatement(queryStr.toString());
//			}
//				
//			ps.setString(i++, model.getTml_so_ofc_cty_cd());
//			ps.setString(i++, model.getTml_so_seq());
//			ps.setString(i++, (String)param_map.get("param_lgs_cost_cd"));
			 
//			if (LoggableStateFactory.get(LoggableStateFactory.SQL_DEBUG).equalsIgnoreCase("true")) {
//				log.info("\n SQL :" + ((LoggableStatement)ps).getQueryString());
//			} else {
//				log.info("\n SQL :" + queryStr );
//			}
			
//			rs = ps.executeQuery();
//			
//			dRs = new DBRowSet();
//			dRs.populate(rs);

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
//		return dRs;
//	}			
	
	/**
	 * OffDock CY Invoice revise mode(MT) container 목록 TP Select
	 * 
	 * @param model
	 * @param paramVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchOffdockCYRvisCntrListCdMT(TesTmlSoHdrVO model, OffdockCYInvoiceManageVO paramVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= paramVO.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				param.put("param_lgs_cost_cd", paramVO.getParamLgsCostCd());				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchOffdockCYRvisCntrListCdMTRSQL(), param, null);
			
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

		return dbRowset;
	}
	
	/**
	 * OffDock CY Invoice revise mode(DG) container 목록 TP Select
	 * 
	 * @param model
	 * @param paramVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchOffdockCYRvisCntrListCdDG(TesTmlSoHdrVO model, OffdockCYInvoiceManageVO paramVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= paramVO.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				param.put("param_lgs_cost_cd", paramVO.getParamLgsCostCd());
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchOffdockCYRvisCntrListCdDGRSQL(), param, null);
			
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

		return dbRowset;
	}
	
	/**
	 * OffDock CY Invoice revise mode(RF) container 목록 TP Select
	 * 
	 * @param model
	 * @param paramVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchOffdockCYRvisCntrListCdRF(TesTmlSoHdrVO model, OffdockCYInvoiceManageVO paramVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= paramVO.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				param.put("param_lgs_cost_cd", paramVO.getParamLgsCostCd());
				velParam.putAll(mapVO);				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchOffdockCYRvisCntrListCdRFRSQL(), param, velParam);
			
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

		return dbRowset;
	}
	
	/**
	 * OffDock CY Invoice revise mode(AK) container 목록 TP Select
	 * 
	 * @param model
	 * @param paramVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchOffdockCYRvisCntrListCdAK(TesTmlSoHdrVO model, OffdockCYInvoiceManageVO paramVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= paramVO.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				param.put("param_lgs_cost_cd", paramVO.getParamLgsCostCd());			
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchOffdockCYRvisCntrListCdAKRSQL(), param, null);
			
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

		return dbRowset;
	}
	
	/**
	 * OffDock CY Invoice 3rd party 목록 TMNL Select
	 * 
	 * @param model OffdockCYInvoiceManageVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchOffdock3rdIFlistOnly(OffdockCYInvoiceManageVO model) throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchOffdock3rdIFlistOnlyRSQL(), param, velParam);
			
			log.debug(">>>>>>>>>> row count : " +dbRowset.getRowCount() );
			
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

		return dbRowset;			
	}	
		
	/**
	 * OffDock CY Invoice 3rd party 목록 TMNL Select
	 * 
	 * @param OffdockCYInvoiceManageVO paramVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchOffdock3rdIFlist(OffdockCYInvoiceManageVO paramVO) throws DAOException {
		
		String tmp_calc_cost_grp_cd = paramVO!=null?JSPUtil.getNull(paramVO.getCalcCostGrpCd()):"";
		String def_F = null;
		String def_M = null;
		if (tmp_calc_cost_grp_cd!=null&&!tmp_calc_cost_grp_cd.trim().equals("")){
			if (tmp_calc_cost_grp_cd.trim().equals("TM")){
				def_F = "TMFDFL";
				def_M = "TMFDMT";
			} else if (tmp_calc_cost_grp_cd.trim().equals("SD")){
				def_F = "SRFDFL";
				def_M = "SRFDMT";				
			}
		}
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= paramVO==null?null:paramVO.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				param.put("def_F", def_F);
				param.put("def_M", def_M);
				velParam.putAll(mapVO);
				velParam.put("def_F", def_F);
				velParam.put("def_M", def_M);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchOffdock3rdIFlistRSQL(), param, velParam);
			
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

		return dbRowset;
	}
	
	/**
	 * OffDock CY Invoice 3rd party 목록 TMNL Select
	 * 
	 * @param OffdockCYInvoiceManageVO paramVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchOffdock3rdIFlistManual(OffdockCYInvoiceManageVO paramVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= paramVO.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchOffdock3rdIFlistManualRSQL(), param, velParam);
			
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

		return dbRowset;
	}
	
	/**
	 * OffDock CY Invoice 3rd party 목록 ByDay Select
	 * 
	 * @param OffdockCYInvoiceManageVO model
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchOffdock3rdIFlistByDay(OffdockCYInvoiceManageVO model) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);		
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchOffdock3rdIFlistByDayRSQL(), param, null);
			
			return dbRowset;
			
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
	 * OffDock CY Invoice 3rd party 목록 ByDay Select
	 * 
	 * @param OffdockCYInvoiceManageVO model
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchOffdock3rdIFlistByDayManual(OffdockCYInvoiceManageVO model) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);	
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchOffdock3rdIFlistByDayManualRSQL(), param, null);
			
			return dbRowset;
			
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
	 * OffDock CY Invoice Total Amount Select
	 * 
	 * @param TesTmlSoHdrVO model
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchOffdockCYTotalAmount(TesTmlSoHdrVO model) throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchOffdockCYTotalAmountRSQL(), param, velParam);
			
			log.debug(">>>>>>>>>> row count : " +dbRowset.getRowCount() );
			
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

		return dbRowset;	
	}	
	
	
	/**
	 * OffDock CY Invoice Cost Calculation List Data Select
	 * 
	 * @param TesTmlSoHdrVO model
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCalcCostTMNLList(TesTmlSoHdrVO model) throws DAOException {
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchCalcCostTMNLListRSQL(), param, velParam);
			
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

		return dbRowset;
	}

	/**
	 * OffDock CY Invoice Cost Calculation ByDay List Data Select
	 * 
	 * @param TesTmlSoHdrVO model
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCalcCostByDayList(TesTmlSoHdrVO model) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchCalcCostByDayListRSQL(), param, velParam);
			
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

		return dbRowset;
	}
		
	/**
	 * OffDock CY Invoice Cost Calculation ByPool List Data Select
	 * 
	 * @param TesTmlSoHdrVO model
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCalcCostByPoolList(TesTmlSoHdrVO model) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchCalcCostByPoolListRSQL(), param, velParam);
			
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

		return dbRowset;	
	}
	 
	/** searchCalcCostByEQList
	 * 
	 * @param model
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchCalcCostByEQList(TesTmlSoHdrVO model) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchCalcCostByEQListRSQL(), param, velParam);
			
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

		return dbRowset;	
	}	
	

	/**
	 * OffdockCYInvoice의 coincidence 목록을 가져온다.<br>
	 * 
	 * @param model TesTmlSoHdrVO
	 * @param codcType String
	 * @return DBRowSet DB 처리 결과
	 * @exception DAOException
	 */
	public DBRowSet searchOffdockCYContainerList(TesTmlSoHdrVO model, String codcType) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		log.debug("CODC_type : "+codcType);
		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				param.put("codc_type", codcType);
				velParam.putAll(mapVO);
				velParam.put("codc_type", codcType);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchOffdockCYContainerListRSQL(), param, velParam);
			
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

		return dbRowset;
	}

	/**
	 * OffDock Invoice Header 정보 조회.<br>
	 * 
	 * @param model TesTmlSoHdrVO 데이타 모델
	 * @return DBRowSet
	 * @exception DAOException
	 */	
	public DBRowSet searchOffdockCYInvoiceBasicInfo(TesTmlSoHdrVO model) throws DAOException {
		
		log.debug("at dbDao.searchOffdockCYInvoiceBasicInfo");
		
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchOffdockCYInvoiceBasicInfoRSQL(), param, velParam);
			
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

		return dbRowset;
	}	
	
	/**
	 * OffDock CY Invoice Reject Info Select
	 * 
	 * @param model
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchOffdockCYInvoiceRejectInfo(TesTmlSoHdrVO model) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchOffdockCYInvoiceBasicInfoRSQL(), param, velParam);
			
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

		return dbRowset;		
	}
	
	/**
	 * Off Dock CY Invoice Creation & Correction - insert TES_TML_SO_HDR
	 * 
	 * @param model
	 * @param usrId
	 * @param ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String createOffdockCYInvoiceBasicInfo(TesTmlSoHdrVO model, String usrId, String ofcCd) throws DAOException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				param.put("usr_id", usrId);
				param.put("ofc_cd", ofcCd);

				param.put("tml_so_ofc_cty_cd", model.getInvOfcCd().substring(0,3));
				param.put("inv_ofc_cd", model.getInvOfcCd());				
				
				velParam.putAll( mapVO );	 
			}
			
			int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new OffdockCYInvoiceManageDBDAOCreateOffdockCYInvoiceBasicInfoCSQL(), param, velParam);			
			
			if (insCnt > 0){
				return "Y";
			} else {
				throw new DAOException(new ErrorHandler("COM11001").getMessage());//데이터 반영에 실패하였습니다.
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
	 * Invoice Amount Check.
	 * 
	 * @param model
	 * @return String
	 * @exception DAOException
	 */
	public String checkSOInvAmt(TesTmlSoHdrVO model) throws DAOException {

		DBRowSet dbRowset = null;
		String rtnVal = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOCheckSOInvAmtRSQL(), param, velParam);
			
			while (dbRowset.next()){
				rtnVal = dbRowset.getString("RETVAL");		//일단 하나라는 전제에 작업
			}
				
			return rtnVal;			

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
	 * confirm 정보 수정
	 * 
	 * @param model
	 * @param usrId
	 * @param ofcCd
	 * @exception DAOException
	 */
	public void modifyOffdockCYInvoiceConfirm(TesTmlSoHdrVO model, String usrId, String ofcCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (model==null || model.getTmlSoOfcCtyCd()==null || model.getTmlSoOfcCtyCd().trim().equals("") || 
					model.getTmlSoSeq()==null || model.getTmlSoSeq().trim().equals("")){
					throw new DAOException(new ErrorHandler("COM11001").getMessage());
				}
			
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				param.put("usr_id", usrId);
				param.put("ofc_cd", ofcCd);				
				velParam.putAll( mapVO );	 
			}
			
			int insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new OffdockCYInvoiceManageDBDAOModifyOffdockCYInvoiceConfirmUSQL(), param, velParam);			
			
			if (insCnt < 1) {
				// 데이터 반영에 실패하였습니다.
				throw new DAOException(new ErrorHandler("COM11001").getMessage());
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
	 * confirm 취소
	 * 
	 * @param model
	 * @param usrId
	 * @param ofcCd
	 * @exception DAOException
	 */
	public void cancelOffdockCYInvoiceConfirm(TesTmlSoHdrVO model, String usrId, String ofcCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				param.put("usr_id", usrId);
				param.put("ofc_cd", ofcCd);
				velParam.putAll( mapVO );	 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OffdockCYInvoiceManageDBDAOCancelOffdockCYInvoiceConfirmUSQL(), param, velParam);
			
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
	 * OffDock CY Invoice Reject Cancel.
	 * 
	 * @param model
	 * @param usrId
	 * @param ofcCd
	 * @exception DAOException
	 */
	public void cancelOffdockCYInvoiceReject(TesTmlSoHdrVO model, String usrId, String ofcCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				param.put("usr_id", usrId);
				param.put("ofc_cd", ofcCd);
				velParam.putAll( mapVO );	 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OffdockCYInvoiceManageDBDAOCancelOffdockCYInvoiceRejectUSQL(), param, velParam);
			
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
	 * OffDock CY Invoice Account Code Select.
	 * 
	 * @param model
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchOffdockCYAccountCode(TesTmlSoHdrVO model) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchOffdockCYAccountCodeRSQL(), param, velParam);
			
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

		return dbRowset;			
	}

	/**
	 * OffDock CY Invoice Account Code Update.
	 * 
	 * @param voList
	 * @param etcMap
	 * @exception DAOException
	 */
	public void updateOffdockCYAccountCode(List<TesTmlSoDtlVO> voList, Map<String, String> etcMap) throws DAOException {
		log.debug(">>>>>>>>>>>>>>> updateOffdockCYAccountCode");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.putAll( etcMap );
			velParam.putAll( etcMap );	 
						
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OffdockCYInvoiceManageDBDAOUpdateOffdockCYAccountCodeUSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * OffdockCYInvoiceManage의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * 
	 * @param model 데이타 모델
	 * @param usrId
	 * @param ofcCd
	 * @exception DAOException
	 */	
	public void modifyOffdockCYInvoice(TesTmlSoHdrVO model, String usrId, String ofcCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				param.put("usr_id", usrId);
				param.put("ofc_cd", ofcCd);
				velParam.putAll( mapVO );	 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OffdockCYInvoiceManageDBDAOModifyOffdockCYInvoiceUSQL(), param, velParam);
			
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
	 * Reject Invoice 정보 수정
	 * 
	 * @param model
	 * @param usrId
	 * @param ofcCd
	 * @exception DAOException
	 */
	public void modifyOffdockCYInvoiceReject(TesTmlSoHdrVO model, String usrId, String ofcCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				param.put("usr_id", usrId);
				param.put("ofc_cd", ofcCd);
				velParam.putAll( mapVO );	 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OffdockCYInvoiceManageDBDAOModifyOffdockCYInvoiceRejectUSQL(), param, velParam);
			
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
	 * OffdockCYInvoiceManage의 데이타 모델을 DB에서 삭제한다.<br>
	 * 
	 * @param model 데이타 모델
	 * @exception DAOException
	 */
	public void removeOffdockCYInvoiceContainerList(TesTmlSoHdrVO model) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO ); 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OffdockCYInvoiceManageDBDAORemoveOffdockCYInvoiceContainerListDSQL(), param, null);
			
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
	 * OffDock CY Invoice Detail TMNL List Delete
	 * 
	 * @param model
	 * @param calcCostGrpCd
	 * @exception DAOException
	 */
	public void removeOffdockCYInvoiceDetail(TesTmlSoHdrVO model, String calcCostGrpCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				param.put( "calc_cost_grp_cd", calcCostGrpCd );
				velParam.putAll( mapVO );	 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OffdockCYInvoiceManageDBDAORemoveOffdockCYInvoiceDetailDSQL(), param, velParam);
			
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
	 * OffDock CY Auto Calculation List Delete
	 * 
	 * @param model
	 * @param calcCostGrpCd
	 * @exception DAOException
	 */
	public void removeOffdockCYInvoiceAutoCalcData(TesTmlSoHdrVO model, String calcCostGrpCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				param.put( "calc_cost_grp_cd", calcCostGrpCd );
				velParam.putAll( mapVO );	 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OffdockCYInvoiceManageDBDAORemoveOffdockCYInvoiceAutoCalcDataDSQL(), param, velParam);
			
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
	 * OffDock CY Auto Calculation List Delete
	 * 
	 * @param model
	 * @param calcCostGrpCd
	 * @exception DAOException
	 */
	public void removeOffdockCYInvoiceAutoCalcDataN3rd(TesTmlSoHdrVO model, String calcCostGrpCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				param.put( "calc_cost_grp_cd", calcCostGrpCd );
				velParam.putAll( mapVO );	 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OffdockCYInvoiceManageDBDAORemoveOffdockCYInvoiceAutoCalcDataN3rdDSQL(), param, velParam);
			
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
	 * OffDock CY Invoice Revise List Delete
	 * 
	 * @param TesTmlSoHdrVO model
	 * @exception DAOException
	 */
	public void removeOffdockCYInvoiceRvis(TesTmlSoHdrVO model) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
	
		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO ); 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OffdockCYInvoiceManageDBDAORemoveOffdockCYInvoiceRvisDSQL(), param, null);
			
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
	 * 3rd Party List 삭제
	 * 
	 * @param model
	 * @param calcCostGrpCd
	 * @exception DAOException
	 */
	public void removeOffdockCYInvoiceN3rd(TesTmlSoHdrVO model, String calcCostGrpCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				param.put( "calc_cost_grp_cd", calcCostGrpCd );
				velParam.putAll( mapVO );	 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OffdockCYInvoiceManageDBDAORemoveOffdockCYInvoiceN3rdDSQL(), param, velParam);
			
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
	 * 무조건 때려 넣는다 - verify 후에 그 결과를 바로 CNTR_LIST에 넣기 
	 * 일단 ROWSET으로 받지만 나중에 ROWSET을 VO로 변경해서 기존의 createOffdockCYInvoiceContainerList()를 사용도 고려하시길...
	 * 
	 * @param List<TesTmlSoCntrListVO> voList
	 * @return int
	 * @see EsdTes0004Event
	 * @exception DAOException
	 */
	public int insertOffdockCYInvoiceContainerList(List<TesTmlSoCntrListVO> voList) throws DAOException {
			
		int insCnt[] = null;
		int rtnVal = 0;
		try {			
			insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OffdockCYInvoiceManageDBDAOInsertOffdockCYInvoiceContainerListCSQL(), voList, null, null);;
			
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]!= Statement.EXECUTE_FAILED) rtnVal++;
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
		
		return rtnVal;
	}
	
	/**
	 * OffDock CY Invoice 3rd Party Max Sequence Select.
	 * 
	 * @param String tmlIfOfcCd
	 * @return int
	 * @exception Exception
	 */
	public int searchOffdockCYN3rdTableMaxSeq(String tmlIfOfcCd) throws DAOException {
		int rtnVal = 0;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("tml_if_ofc_cd", tmlIfOfcCd);	
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchOffdockCYN3rdTableMaxSeqRSQL(), param, null);
			
			while (dbRowset.next()){
				rtnVal = dbRowset.getInt("max_seq");		//일단 하나라는 전제에 작업
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
		return rtnVal;
	}

	/**
	 * 3rd Party List Insert.
	 * 
	 * @param List<TesN3rdPtyIfVO> models
	 * @exception DAOException
	 */
	public void multiOffdock3rdIFlistNewInsert(List<TesN3rdPtyIfVO> models) throws DAOException {
		try {
			int insCnt[] = null;
			if(models.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OffdockCYInvoiceManageDBDAOMultiOffdock3rdIFlistNewInsertCSQL(), models, null, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * 3rd Party List Container List Update.
	 * 
	 * @param models
	 * @exception DAOException
	 */
	public void multiOffdock3rdIFlistNewCNTRUpdate(List<OffdockCYInvoiceManageVO> models) throws DAOException {
		try {
			int insCnt[] = null;
			if(models.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OffdockCYInvoiceManageDBDAOMultiOffdock3rdIFlistNewCNTRUpdateUSQL(), models, null, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * 3rd Party List Detail(Cost Calculation) List Update.
	 * 
	 * @param model
	 * @exception DAOException
	 */
	public void multiOffdock3rdIFlistNewDTLUpdate(OffdockCYInvoiceManageVO model) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OffdockCYInvoiceManageDBDAOMultiOffdock3rdIFlistNewDTLUpdateUSQL(), param, null);
			
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
	 * 3rd Party List Update.
	 * 
	 * @param models
	 * @exception DAOException
	 */
	public void multiOffdock3rdIFlistNewUpdate(List<TesN3rdPtyIfVO> models) throws DAOException {
		try {
			int insCnt[] = null;
			if(models.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OffdockCYInvoiceManageDBDAOMultiOffdock3rdIFlistNewUpdateUSQL(), models, null, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * 3rd Party List Delete.
	 * 
	 * @param models
	 * @exception DAOException
	 */
	public void multiOffdock3rdIFlistNewDelete(List<TesN3rdPtyIfVO> models) throws DAOException {

		try {
			int insCnt[] = null;
			if(models.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OffdockCYInvoiceManageDBDAOMultiOffdock3rdIFlistNewDeleteDSQL(), models, null, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * 3rd Party List Delete.
	 * 
	 * @param models
	 * @exception DAOException
	 */
	public void multiOffdock3rdIFlistNewTPBDelete(List<TesN3rdPtyIfVO> models) throws DAOException {
		log.debug("dbdao.multiOffdock3rdIFlistNewTPBDelete()");
		try {
			int insCnt[] = null;
			if(models.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OffdockCYInvoiceManageDBDAOMultiOffdock3rdIFlistNewTPBDeleteDSQL(), models, null, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * Revise Volume Container List Insert.
	 * 
	 * @param voList
	 * @param etcMap
	 * @exception DAOException
	 */
	public void multiRevCalcVolContainerListMInsert(List<TesTmlSoRvisListVO> voList, Map<String, String> etcMap) throws DAOException {		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( etcMap != null ) {
				param.putAll( etcMap );
				velParam.putAll( etcMap );		
			}
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OffdockCYInvoiceManageDBDAOMultiRevCalcVolContainerListMInsertCSQL(), voList, param, velParam);
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
	 * Revise Volume Container List Update.
	 * 
	 * @param voList
	 * @param etcMap
	 * @exception DAOException
	 */
	public void multiRevCalcVolContainerListMUpdate(List<TesTmlSoRvisListVO> voList, Map<String, String> etcMap) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( etcMap != null ) {
				param.putAll( etcMap );
				velParam.putAll( etcMap );		
			}
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OffdockCYInvoiceManageDBDAOMultiRevCalcVolContainerListMUpdateUSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * Revise Volume Container List Delete.
	 * 
	 * @param voList
	 * @param etcMap
	 * @exception DAOException
	 */
	public void multiRevCalcVolContainerListMDelete(List<TesTmlSoRvisListVO> voList, Map<String, String> etcMap) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( etcMap != null ) {
				param.putAll( etcMap );
				velParam.putAll( etcMap );		
			}
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OffdockCYInvoiceManageDBDAOMultiRevCalcVolContainerListMDeleteDSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * Revise Volume Container List Insert.
	 * 
	 * @param voList
	 * @param etcMap
	 * @exception DAOException
	 */
	public void multiRevCalcVolContainerListInsert(List<TesTmlSoCntrListVO> voList, Map<String, String> etcMap) throws DAOException {		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( etcMap != null ) {
				param.putAll( etcMap );
				velParam.putAll( etcMap );		
			}
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OffdockCYInvoiceManageDBDAOMultiRevCalcVolContainerListInsertCSQL(), voList, param, velParam);
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
	 * Revise Volume Container List Update.
	 * 
	 * @param voList
	 * @param etcMap
	 * @exception DAOException
	 */
	public void multiRevCalcVolContainerListUpdate(List<TesTmlSoCntrListVO> voList, Map<String, String> etcMap) throws DAOException {		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( etcMap != null ) {
				param.putAll( etcMap );
				velParam.putAll( etcMap );		
			}
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OffdockCYInvoiceManageDBDAOMultiRevCalcVolContainerListUpdateUSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No"+ i + " SQL");
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
	 * Revise Volume Container List Delete.
	 * 
	 * @param voList
	 * @param etcMap
	 * @exception DAOException
	 */
	public void multiRevCalcVolContainerListDelete(List<TesTmlSoCntrListVO> voList, Map<String, String> etcMap) throws DAOException {		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( etcMap != null ) {
				param.putAll( etcMap );
				velParam.putAll( etcMap );		
			}
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OffdockCYInvoiceManageDBDAOMultiRevCalcVolContainerListDeleteDSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Delete No"+ i + " SQL");
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
	 * Revise Volume Count Recalculation. 
	 * 
	 * @param model
	 * @param paramVO
	 * @exception DAOException
	 */
	public void recalculateRevisedVolumeCount(TesTmlSoCntrListVO model, OffdockCYInvoiceManageVO paramVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				param.put("param_dcgo_clss_cd", paramVO.getParamDcgoClssCd());
				//param.put("param_rc_flg", paramVO.getParamRcFlg());
				param.put("lgs_cost_cd", paramVO.getLgsCostCd());
				velParam.putAll( mapVO );	 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OffdockCYInvoiceManageDBDAORecalculateRevisedVolumeCountUSQL(), param, velParam);
			
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
	 * Revise Volume Count Recalculation. 
	 * 
	 * @param paramVO
	 * @exception DAOException
	 */
	public void recalculateRevisedVolumeCountM(OffdockCYInvoiceManageVO paramVO) throws DAOException {
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {

			if ( paramVO != null ) {
				param.put("tml_so_ofc_cty_cd", paramVO.getTmlSoOfcCtyCd());
				param.put("tml_so_seq", paramVO.getTmlSoSeq());
				param.put("tml_so_dtl_seq", paramVO.getTmlSoDtlSeq());
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OffdockCYInvoiceManageDBDAORecalculateRevisedVolumeCountMUSQL(), param, null);
			
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
	 * Revise Volume Count Separate Recalculation. 
	 * 
	 * @param model
	 * @param paramVO
	 * @exception DAOException
	 */
	public void recalculateRevisedVolumeCountSeparate(TesTmlSoCntrListVO model, OffdockCYInvoiceManageVO paramVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapModel	= model.getColumnValues();
			Map<String, String> mapParam	= paramVO.getColumnValues();
			if ( paramVO != null ) {
				param.putAll(mapModel);
				param.putAll(mapParam);
				param.put("dcgo_clss_cd", JSPUtil.getNull(paramVO.getParamDcgoClssCd()));
				param.put("dcgo_ind_cd", JSPUtil.getNull(paramVO.getParamDcgoClssCd()));
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OffdockCYInvoiceManageDBDAORecalculateRevisedVolumeCountSeparateUSQL(), param, null);
			
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
	 * Revise Volume Count Separate Recalculation. 
	 * 
	 * @param model
	 * @param paramVO
	 * @exception DAOException
	 */
	public void recalculateRevisedVolumeCountSeparateM(TesTmlSoCntrListVO model, OffdockCYInvoiceManageVO paramVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapModel	= model.getColumnValues();
			if ( mapModel != null ) {
				param.putAll( mapModel );
				param.put("fm_prd_dt", JSPUtil.getNull(paramVO.getFmPrdDt()).replaceAll("-",""));
				param.put("tml_so_dtl_seq", paramVO.getTmlSoDtlSeq());
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OffdockCYInvoiceManageDBDAORecalculateRevisedVolumeCountSeparateMUSQL(), param, velParam);
						
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
	 * Recalculated OffDock Invoice Cost Amount
	 * 
	 * @param model
	 * @param paramVO
	 * @exception DAOException
	 */
	public void recalculateOffdocCYInvoiceCostAmount(TesTmlSoCntrListVO model, OffdockCYInvoiceManageVO paramVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				param.put("param_dcgo_clss_cd", paramVO.getParamDcgoClssCd());
				param.put("param_rc_flg", paramVO.getParamRcFlg());//왜 주석되어있었지... -_-;
				param.put("lgs_cost_cd", paramVO.getLgsCostCd());
				velParam.putAll( mapVO );	 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OffdockCYInvoiceManageDBDAORecalculateOffdocCYInvoiceCostAmountUSQL(), param, velParam);
			
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
	 * 3rd Party 데이타 여부 확인후 Detail N3rd flag 값 Update.<br>
	 * @param OffdockCYInvoiceManageVO model
	 * @return int
	 * @exception DAOException
	 */
	public int updateOffdockDetailN3rdFlagSearch(OffdockCYInvoiceManageVO model) throws DAOException {
		log.debug("at dbdao.updateOffdockDetailN3rdFlagSearch");
		int iCnt = 0;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOUpdateOffdockDetailN3rdFlagSearchRSQL(), param, null);
			
			while (dbRowset != null && dbRowset.next()) {
				iCnt = dbRowset.getInt("CNT");
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(),de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new DAOException(e.getMessage());
		}
		return iCnt;
	}
	
	/**
	 * 3rd Party 데이타 여부 확인후 Detail N3rd flag 값 Update.<br>
	 * 
	 * @param model
	 * @exception DAOException
	 */
	public void updateOffdockDetailN3rdFlag(OffdockCYInvoiceManageVO model) throws DAOException {
		log.debug("dbdao.updateOffdockDetailN3rdFlag()");
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new OffdockCYInvoiceManageDBDAOUpdateOffdockDetailN3rdFlagUSQL(), param, null);		
			
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
	 * OffDock CY Invoice Table Max Sequence Select.
	 * 
	 * @param model
	 * @param tableName
	 * @param columnName
	 * @return int
	 * @exception DAOException
	 */
	public int searchOffdockCYTableMaxSeq(TesTmlSoHdrVO model, String tableName, String columnName) throws DAOException {
		int rtnVal = 0;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);	
				velParam.put("columnName", columnName);
				velParam.put("tableName", tableName);				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OffdockCYInvoiceManageDBDAOSearchOffdockCYTableMaxSeqRSQL(), param, velParam);
			
			while (dbRowset.next()){
				rtnVal = dbRowset.getInt("dtl_max_seq");		//일단 하나라는 전제에 작업
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
		
		return rtnVal;
	}
	
	/**
	 * Off Dock CY Invoice detail 생성
	 * @param voList
	 * @param etcMap - ofc_cd, usr_id
	 * @exception DAOException
	 */
	public void createOffdockCYInvoiceDetailInsert(List<TesTmlSoDtlVO> voList, Map<String, String> etcMap) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( etcMap != null ) {
				param.putAll( etcMap );
				velParam.putAll( etcMap );		
			}
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OffdockCYInvoiceManageDBDAOCreateOffdockCYInvoiceDetailInsertCSQL(), voList, param, velParam);
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
	 * Off Dock CY Invoice detail 수정
	 * @param voList
	 * @param etcMap - ofc_cd, usr_id
	 * @exception DAOException
	 */	
	public void createOffdockCYInvoiceDetailUpdate(List<TesTmlSoDtlVO> voList, Map<String, String> etcMap) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( etcMap != null ) {
				param.putAll( etcMap );
				velParam.putAll( etcMap );	 
			}
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OffdockCYInvoiceManageDBDAOCreateOffdockCYInvoiceDetailUpdateUSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * Off Dock CY Invoice detail TES_TML_SO_DTL 삭제
	 * @param voList
	 * @param etcMap - ofc_cd, usr_id
	 * @exception DAOException
	 */		
	public void createOffdockCYInvoiceDetailDeleteDtl(List<TesTmlSoDtlVO> voList, Map<String, String> etcMap) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( etcMap != null ) {
				param.putAll( etcMap );
				velParam.putAll( etcMap );		
			}

			//TES_TML_SO_DTL
			if(voList.size() > 0){
				int insCnt[] = null;
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OffdockCYInvoiceManageDBDAOCreateOffdockCYInvoiceDetailDeleteDtlDSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Delete(TES_TML_SO_DTL) No"+ i + " SQL");
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
	 * Off Dock CY Invoice detail TES_N3RD_PTY_IF 삭제
	 * @param voList
	 * @param etcMap - ofc_cd, usr_id
	 * @exception DAOException
	 */			
	public void createOffdockCYInvoiceDetailDeleteN3rd(List<TesTmlSoDtlVO> voList, Map<String, String> etcMap) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( etcMap != null ) {
				param.putAll( etcMap );
				velParam.putAll( etcMap );		
			}

			//TES_N3RD_PTY_IF
			if(voList.size() > 0){
				int insCnt[] = null;
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OffdockCYInvoiceManageDBDAOCreateOffdockCYInvoiceDetailDeleteN3rdDSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Delete(TES_N3RD_PTY_IF) No"+ i + " SQL");
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
	 * Off Dock CY Invoice detail TES_TML_SO_RVIS_LIST 삭제
	 * @param voList
	 * @param etcMap - ofc_cd, usr_id
	 * @exception DAOException
	 */			
	public void createOffdockCYInvoiceDetailDeleteRvis(List<TesTmlSoDtlVO> voList, Map<String, String> etcMap) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( etcMap != null ) {
				param.putAll( etcMap );
				velParam.putAll( etcMap );		
			}

			//TES_TML_SO_RVIS_LIST
			if(voList.size() > 0){
				int insCnt[] = null;
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OffdockCYInvoiceManageDBDAOCreateOffdockCYInvoiceDetailDeleteRvisDSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Delete(TES_TML_SO_RVIS_LIST) No"+ i + " SQL");
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
	 * Off Dock CY Invoice create container list 생성
	 * @param voList
	 * @param etcMap - ofc_cd, usr_id
	 * @exception DAOException
	 */	
	public void createOffdockCYInvoiceContainerListInsert(List<TesTmlSoCntrListVO> voList, Map<String, String> etcMap) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( etcMap != null ) {
				param.putAll( etcMap );
				velParam.putAll( etcMap );		
			}
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OffdockCYInvoiceManageDBDAOCreateOffdockCYInvoiceContainerListInsertCSQL(), voList, param, velParam);
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
	 * Off Dock CY Invoice update container list 수정
	 * @param voList
	 * @param etcMap - ofc_cd, usr_id
	 * @exception DAOException
	 */
	public void createOffdockCYInvoiceContainerListUpdate(List<TesTmlSoCntrListVO> voList, Map<String, String> etcMap) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if ( etcMap != null ) {
				param.putAll( etcMap );
				velParam.putAll( etcMap );	 
			}
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new OffdockCYInvoiceManageDBDAOCreateOffdockCYInvoiceContainerListUpdateUSQL(), voList, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * OffDock Search CNTR TYPE CD List<br>
	 * 
	 * @param TesFileImpTmpVO tesFileImpTmpVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	
	public String searchBkgCntrTPCDList(TesFileImpTmpVO tesFileImpTmpVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnVal = "";
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			param.put("cntr_no", tesFileImpTmpVO.getCntrNo() );
			velParam.put("cntr_no", tesFileImpTmpVO.getCntrNo() );
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TESCommonDBDAOSearchBkgCntrTPCDListRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				rtnVal = dbRowset.getString("CNTR_TPSZ_CD");
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
		
		return rtnVal;
	}
}
