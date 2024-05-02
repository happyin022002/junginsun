/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AgreementRegistrationDBDAO.java
*@FileTitle : Lease Agreement Creation & Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.05.22 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementFileUploadVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementGeneralRateVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementListVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementRatesVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementRegistrationVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.InInterrstServiceVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.InterrstServiceVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.basic.AgreementRegistrationBCImpl;
import com.hanjin.bizcommon.comm.Constants;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.LseAgmtRtVO;
import com.hanjin.syscommon.common.table.LseDrpOffDescVO;


/**
 * NIS2010 AgreementRegistrationDBDAO <br>
 * - NIS2010-ContainerLeaseAgreementRegistration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Nho Jung Yong
 * @see AgreementRegistrationBCImpl 참조
 * @since J2EE 1.6
 */
public class AgreementRegistrationDBDAO extends DBDAOSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Lease Agreement List 조회<br>
	 * 
	 * @param AgreementVO searchAgreementVO
	 * @return List<AgreementVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgreementVO> searchAgreementListBrieflyData(AgreementVO searchAgreementVO) throws DAOException {
		int currentPage = searchAgreementVO.getIPage();
		int startNo     = Constants.PAGE_SIZE_100 * (currentPage - 1) + 1;
		int endNo       = Constants.PAGE_SIZE_100 * currentPage;  
		 
		DBRowSet dbRowset = null;
		List<AgreementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchAgreementVO != null){
				Map<String, String> mapVO = searchAgreementVO .getColumnValues();
			
				param.putAll(mapVO);
				param.put("startno", startNo);
				param.put("endno", endNo);

				velParam.putAll(mapVO);
				velParam.put("startno", startNo);
				velParam.put("endno", endNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementRegistrationDBDAOAgreementListBrieflyRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgreementVO .class);
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
	 * Lease Agreement List 전체 건수 조회<br>
	 * 
	 * @param AgreementVO searchAgreementVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchAgreementListBrieflyCountData(AgreementVO searchAgreementVO) throws DAOException {
		int cnt  =0;
        DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
			if(searchAgreementVO != null){
				Map<String, String> mapVO = searchAgreementVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementRegistrationDBDAOAgreementListBrieflyCountRSQL(), param, velParam);	
	    	if(dbRowset.next()) {
	    		cnt = dbRowset.getInt("CNT");
	    	}
	    } catch (SQLException se) {
	    	log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
			
		return cnt;
	}

	/**
	 * Lease Agreement Master Data[LSE_AGREEMENT] 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public AgreementRegistrationVO searchAgreementData(AgreementRegistrationVO agreementRegistrationVO) throws DAOException {
	 
		AgreementVO agreementVO = agreementRegistrationVO.getAgreementVO();
		DBRowSet dbRowset = null;
		List<AgreementVO> list = null;
		AgreementRegistrationVO returnVO = new AgreementRegistrationVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if ( agreementVO != null ) {
				Map<String, String> mapVO = agreementVO.getColumnValues();
				
				param.putAll(mapVO);
			}
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementRegistrationDBDAOAgreementRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgreementVO.class);

			returnVO.setAgreementVOs(list);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return returnVO;
	}

	/**
	 * Lease Agreement General Data[LSE_AGMT_RT] 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public AgreementRegistrationVO searchAgreementGeneralData(AgreementRegistrationVO agreementRegistrationVO) throws DAOException {
		AgreementVO agreementVO = agreementRegistrationVO.getAgreementVO();
		DBRowSet dbRowset = null;
		List<AgreementGeneralRateVO> list = null;
		AgreementRegistrationVO returnVO = new AgreementRegistrationVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if ( agreementVO != null ) {
				Map<String, String> mapVO = agreementVO.getColumnValues();

				param.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementRegistrationDBDAOAgreementRateGeneralRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgreementGeneralRateVO.class);
			
			returnVO.setAgreementGeneralListVOs(list);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return returnVO;
	}

	/**
	 * Lease Agreement Per-diem Data[LSE_AGMT_RT] 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public AgreementRegistrationVO searchAgreementPerDiemData(AgreementRegistrationVO agreementRegistrationVO) throws DAOException {
		AgreementVO agreementVO = agreementRegistrationVO.getAgreementVO();
		DBRowSet dbRowset = null;
		List<AgreementRatesVO> list = null;
		AgreementRegistrationVO returnVO = new AgreementRegistrationVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if ( agreementVO != null ) {
				Map<String, String> mapVO = agreementVO.getColumnValues();
				param.putAll(mapVO);
				List<String> arrCntrTpszCd = null;
				if ( !JSPUtil.getNull(agreementVO.getOrgCntrTpszCd()).equals("") ) {
					arrCntrTpszCd = JSPUtil.convertStringToArrayList(agreementVO.getOrgCntrTpszCd());
					param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementRegistrationDBDAOAgreementRatePerDiemRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgreementRatesVO.class);
			returnVO.setAgreementRatesVOs(list);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return returnVO;
	}

	/**
	 * Lease Agreement Lifting Charge Data[LSE_AGMT_RT] 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public AgreementRegistrationVO searchAgreementLiftChargeData(AgreementRegistrationVO agreementRegistrationVO) throws DAOException {
		AgreementVO agreementVO = agreementRegistrationVO.getAgreementVO();
		DBRowSet dbRowset = null;
		List<AgreementRatesVO> list = null;
		AgreementRegistrationVO returnVO = new AgreementRegistrationVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if ( agreementVO != null ) {
				Map<String, String> mapVO = agreementVO.getColumnValues();
					
				param.putAll(mapVO);
				List<String> arrCntrTpszCd = null;
				if ( !JSPUtil.getNull(agreementVO.getOrgCntrTpszCd()).equals("") ) {
					arrCntrTpszCd = JSPUtil.convertStringToArrayList(agreementVO.getOrgCntrTpszCd());
					param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementRegistrationDBDAOAgreementRateLiftChargeRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgreementRatesVO.class);
			
			returnVO.setAgreementRatesVOs(list);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return returnVO;
	}

	/**
	 * Lease Agreement DOL/DOC Data[LSE_AGMT_RT] 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public AgreementRegistrationVO searchAgreementDolDocData(AgreementRegistrationVO agreementRegistrationVO) throws DAOException {
		AgreementVO agreementVO = agreementRegistrationVO.getAgreementVO();
		DBRowSet dbRowset = null;
		List<AgreementRatesVO> list = null;
		AgreementRegistrationVO returnVO = new AgreementRegistrationVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if ( agreementVO != null ) {
				Map<String, String> mapVO = agreementVO.getColumnValues();
					
				param.putAll(mapVO);
				List<String> arrCntrTpszCd = null;
				if ( !JSPUtil.getNull(agreementVO.getOrgCntrTpszCd()).equals("") ) {
					arrCntrTpszCd = JSPUtil.convertStringToArrayList(agreementVO.getOrgCntrTpszCd());
					param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementRegistrationDBDAOAgreementRateDolDocRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgreementRatesVO.class);
			
			returnVO.setAgreementRatesVOs(list);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}

	/**
	 * Lease Agreement Drop Office Data[LSE_DRP_OFF_DESC] 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public AgreementRegistrationVO searchAgreementDropOfficeDescData(AgreementRegistrationVO agreementRegistrationVO) throws DAOException {
		AgreementVO agreementVO = agreementRegistrationVO.getAgreementVO();
		DBRowSet dbRowset = null;
		List<LseDrpOffDescVO> list = null;
		AgreementRegistrationVO returnVO = new AgreementRegistrationVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if ( agreementVO != null ) {
				Map<String, String> mapVO = agreementVO.getColumnValues();
					
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementRegistrationDBDAOAgreementDropOfficeDescRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LseDrpOffDescVO.class);
			
			returnVO.setAgreementDropOfficeDescVOs(list);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}

	/**
	 * Lease Agreement Penalty Data[LSE_AGMT_RT] 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public AgreementRegistrationVO searchAgreementPenaltyData(AgreementRegistrationVO agreementRegistrationVO) throws DAOException {
		AgreementVO agreementVO = agreementRegistrationVO.getAgreementVO();
		DBRowSet dbRowset = null;
		List<AgreementRatesVO> list = null;
		AgreementRegistrationVO returnVO = new AgreementRegistrationVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if ( agreementVO != null ) {
				Map<String, String> mapVO = agreementVO.getColumnValues();

				param.putAll(mapVO);
				List<String> arrCntrTpszCd = null;
				if ( !JSPUtil.getNull(agreementVO.getOrgCntrTpszCd()).equals("") ) {
					arrCntrTpszCd = JSPUtil.convertStringToArrayList(agreementVO.getOrgCntrTpszCd());
					param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementRegistrationDBDAOAgreementRatePenaltyRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgreementRatesVO.class);
			
			returnVO.setAgreementRatesVOs(list);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}

	/**
	 * Lease Agreement DPP Data[LSE_AGMT_RT] 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public AgreementRegistrationVO searchAgreementDppData(AgreementRegistrationVO agreementRegistrationVO) throws DAOException {
		AgreementVO agreementVO = agreementRegistrationVO.getAgreementVO();
		DBRowSet dbRowset = null;
		List<LseAgmtRtVO> list = null;
		AgreementRegistrationVO returnVO = new AgreementRegistrationVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if ( agreementVO != null ) {
				Map<String, String> mapVO = agreementVO.getColumnValues();

				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementRegistrationDBDAOAgreementRateDppRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LseAgmtRtVO.class);
			
			returnVO.setAgreementDppRateVOs(list);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}

	/**
	 * Lease Agreement의 새로운 Agreement Sequence[LSE_AGREEMENT] 조회<br>
	 * 
	 * @param String agmtCtyCd
	 * @return String
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String searchAgreementNewSequenceData(String agmtCtyCd) throws DAOException {
	 
		DBRowSet dbRowset = null;
		List<AgreementVO> list = null;
		String strNewAgmtSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("agmt_cty_cd",	agmtCtyCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementRegistrationDBDAOAgreementNewSequenceRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgreementVO.class);

			strNewAgmtSeq = list.get(0).getAgmtSeq();
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strNewAgmtSeq;
	}

	/**
	 *  Lease Agreement의 새로운 Agreement Version Sequence[LSE_AGREEMENT] 조회<br>
	 * 
	 * @param String agmtCtyCd
	 * @param String agmtSeq
	 * @return String
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public String searchAgreementNewVersionSequenceData(String agmtCtyCd, String agmtSeq) throws DAOException {
	 
		DBRowSet dbRowset = null;
		List<AgreementVO> list = null;
		String strNewAgmtVerSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			param.put("agmt_cty_cd",	agmtCtyCd);
			param.put("agmt_seq",		agmtSeq);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementRegistrationDBDAOAgreementNewVersionSequenceRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgreementVO.class);
			strNewAgmtVerSeq = list.get(0).getAgmtVerSeq();
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strNewAgmtVerSeq;
	}

	 /**
	 * Lease Agreement[LSE_AGREEMENT] 데이터 생성<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @throws DAOException
	 */
	public void addLeaseAgreementData(AgreementRegistrationVO agreementRegistrationVO) throws DAOException,Exception {
		AgreementVO aggrementVO = agreementRegistrationVO.getAgreementVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = aggrementVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new AgreementRegistrationDBDAOAgreementCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Lease Agreement Version[LSE_AGMT_VER] 데이터 생성<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return int
	 * @throws DAOException
	 */
	public int addLeaseAgreementVersionData(AgreementRegistrationVO agreementRegistrationVO) throws DAOException,Exception {
		AgreementVO aggrementVO = agreementRegistrationVO.getAgreementVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = aggrementVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AgreementRegistrationDBDAOAgreementVersionCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
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
	 * Lease Agreement Rate[LSE_AGMT_RT] 데이터 생성<br>
	 * 
	 * @param List<LseAgmtRtVO> lseAgmtRtVOs
	 * @throws DAOException
	 */
	public void addLeaseAgreementRatesData(List<LseAgmtRtVO> lseAgmtRtVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(lseAgmtRtVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AgreementRegistrationDBDAOAgreementRatesCSQL(), lseAgmtRtVOs, null);
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
	 * Lease Agreement Drop Office[LSE_DRP_OFF_DESC] 데이터 생성<br>
	 * 
	 * @param List<LseDrpOffDescVO> lseDrpOffDescVOs
	 * @throws DAOException
	 */
	public void addAgmtDrpOffDescData(List<LseDrpOffDescVO> lseDrpOffDescVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(lseDrpOffDescVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AgreementRegistrationDBDAOAgreementDropOfficeDescCSQL(), lseDrpOffDescVOs, null);
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
	 * Lease Agreement Rate History [LSE_AGMT_RT_HIS] 데이터 생성<br>
	 * 
	 * @param String agmtCtyCd
	 * @param String agmtSeq
	 * @param int agmtVerSeq
	 * @param String userId
	 * @throws DAOException
	 */
	public void addLeaseAgreementRateHistoryData(String agmtCtyCd, String agmtSeq, int agmtVerSeq, String userId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("agmt_cty_cd",	agmtCtyCd);
			param.put("agmt_seq",		agmtSeq);
			param.put("agmt_ver_seq",	agmtVerSeq);
			param.put("usr_id",			userId);
				
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new AgreementRegistrationDBDAOAgreementRateHistoryCSQL(), param, param);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * Lease Agreement[LSE_AGREEMENT] 데이터 수정<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @throws DAOException
	 */
	public void modifyLeaseAgreementData(AgreementRegistrationVO agreementRegistrationVO) throws DAOException,Exception {
		AgreementVO aggrementVO = agreementRegistrationVO.getAgreementVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = aggrementVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new AgreementRegistrationDBDAOAgreementUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
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
	 * Lease Agreement Version[LSE_AGMT_VER] 데이터 수정<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyLeaseAgreementVersionData(AgreementRegistrationVO agreementRegistrationVO) throws DAOException,Exception {
		AgreementVO aggrementVO = agreementRegistrationVO.getAgreementVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = aggrementVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new AgreementRegistrationDBDAOAgreementVersionUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
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
	 * Lease Agreement Drop Office[LSE_DRP_OFF_DESC] 데이터 생성/수정<br>
	 * 
	 * @param List<LseDrpOffDescVO> lseDrpOffDescVOs
	 * @throws DAOException
	 */
	public void modifyAgmtDrpOffDescData(List<LseDrpOffDescVO> lseDrpOffDescVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(lseDrpOffDescVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AgreementRegistrationDBDAOAgreementDropOfficeDescUSQL(), lseDrpOffDescVOs, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * Lease Agreement Rate[LSE_AGMT_RT] 데이터 삭제<br>
	 * 
	 * @param List<LseAgmtRtVO> lseAgmtRtVOs
	 * @throws DAOException
	 */
	public void removeLeaseAgreementRatesData(List<LseAgmtRtVO> lseAgmtRtVOs) throws DAOException,Exception {
		try {
			for ( int i = 0; i < lseAgmtRtVOs.size() ; i++ ) {
				int result = 0;

				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();

				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				Map<String, String> mapVO = ((LseAgmtRtVO)lseAgmtRtVOs.get(i)).getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new AgreementRegistrationDBDAOAgreementRatesDSQL(), param, velParam);
				
				if(result == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to delete SQL");
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
	 * Lease Agreement Drop Office[LSE_DRP_OFF_DESC] 데이터 삭제<br>
	 * 
	 * @param List<LseDrpOffDescVO> lseDrpOffDescVOs
	 * @throws DAOException
	 */
	public void removeAgmtDrpOffDescData(List<LseDrpOffDescVO> lseDrpOffDescVOs) throws DAOException,Exception {
		try {
			for ( int i = 0; i < lseDrpOffDescVOs.size() ; i++ ) {
				int result = 0;

				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();

				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				Map<String, String> mapVO = ((LseDrpOffDescVO)lseDrpOffDescVOs.get(i)).getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new AgreementRegistrationDBDAOAgreementDropOfficeDescDSQL(), param, velParam);
				
				if(result == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to delete SQL");
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
	 * Lease Agreement Version List[LSE_AGMT_VER] 조회<br>
	 * 
	 * @param AgreementVO searchAgreementVO
	 * @return List<AgreementVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgreementVO> searchAgreementVersionListData(AgreementVO searchAgreementVO) throws DAOException {
		int currentPage = searchAgreementVO.getIPage();
		int startNo     = Constants.PAGE_SIZE_100 * (currentPage - 1) + 1;
		int endNo       = Constants.PAGE_SIZE_100 * currentPage;  
		 
		DBRowSet dbRowset = null;
		List<AgreementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchAgreementVO != null){
				Map<String, String> mapVO = searchAgreementVO .getColumnValues();
			
				param.putAll(mapVO);
				param.put("startno", startNo);
				param.put("endno", endNo);

				velParam.putAll(mapVO);
				velParam.put("startno", startNo);
				velParam.put("endno", endNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementRegistrationDBDAOAgreementVersionListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgreementVO.class);
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
	 * Lease Agreement Version List[LSE_AGMT_VER] 전체 건수 조회<br>
	 * 
	 * @param AgreementVO searchAgreementVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchAgreementVersionListCountData(AgreementVO searchAgreementVO) throws DAOException {
		int cnt  =0;
        DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
			if(searchAgreementVO != null){
				Map<String, String> mapVO = searchAgreementVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementRegistrationDBDAOAgreementVersionListCountRSQL(), param, velParam);	
	    	if(dbRowset.next()) {
	    		cnt = dbRowset.getInt("CNT");
	    	}
	    } catch (SQLException se) {
	    	log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
			
		return cnt;
	}

	/**
	 * Lease Agreement Term & Condition Lists 조회<br>
	 * 
	 * @param String expFromDt
	 * @param String expToDt
	 * @param String vndrSeq
	 * @param String lstmCd
	 * @param String orgCntrTpszCd
	 * @param String ofcCd
	 * @return List<AgreementListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgreementListVO> searchAgreementListData(String expFromDt, String expToDt, String vndrSeq, String lstmCd, String orgCntrTpszCd, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgreementListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("exp_from_dt",	expFromDt);
			param.put("exp_to_dt",		expToDt);
			param.put("vndr_seq",		vndrSeq);
			param.put("lstm_cd",		lstmCd);
			param.put("ofc_cd",		    ofcCd);
			
			List<String> arrLstmCd    = null;
			List<String> arrCntrTpszCd = null;

			if ( !JSPUtil.getNull(lstmCd).equals("") ) {
				arrLstmCd = JSPUtil.convertStringToArrayList(JSPUtil.replace(lstmCd,",","|"));
				param.put("lstm_cd_seq", arrLstmCd);
			}
			
			if ( !JSPUtil.getNull(orgCntrTpszCd).equals("") ) {
				arrCntrTpszCd = JSPUtil.convertStringToArrayList(orgCntrTpszCd);
				param.put("cntr_tpsz_cd_seq", arrCntrTpszCd);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementRegistrationDBDAOAgreementListRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgreementListVO.class);
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
	 * EES_LSE_0102 : caculation Click <br>
	 * Interest calculation 조회 <br>
	 * @param  InInterrstServiceVO inInterrstServiceVO
	 * @return List<InterrstServiceVO>
	 * @throws DAOException
	 */	
	 @SuppressWarnings("unchecked")
	public List<InterrstServiceVO> calculationInterrstData(InInterrstServiceVO inInterrstServiceVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<InterrstServiceVO> interrstServiceVOS  = null;
        
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
        try {			
			if(inInterrstServiceVO != null){
				Map<String, String> mapVO = inInterrstServiceVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementRegistrationDBDAOcalculationInterrstDataRSQL(), param, velParam);	
			interrstServiceVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, InterrstServiceVO.class);
			
	    } catch (SQLException se) {
	    	log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
			
		return interrstServiceVOS;
	} 

	/**
	 * Lease Agreement Pic Data[LSE_AGMT_RT] 조회<br>
	 * 
	 * @param AgreementRegistrationVO agreementRegistrationVO
	 * @return AgreementRegistrationVO
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public AgreementRegistrationVO searchAgreementPicData(AgreementRegistrationVO agreementRegistrationVO) throws DAOException {
		AgreementVO agreementVO = agreementRegistrationVO.getAgreementVO();
		DBRowSet dbRowset = null;
		List<AgreementFileUploadVO> list = null;
		AgreementRegistrationVO returnVO = new AgreementRegistrationVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if ( agreementVO != null ) {
				Map<String, String> mapVO = agreementVO.getColumnValues();
				param.putAll(mapVO);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgreementRegistrationDBDAOAgreementFileUploadRSQL(), param, param);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgreementFileUploadVO.class);
			returnVO.setAgreementFileUploadVOs(list);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return returnVO;
	}	 
		
	 /**
	 * Lease Agreement File Upload 데이터 생성<br>
	 * 
	 * @param List<AgreementFileUploadVO> agreementFileUploadVO
	 * @throws DAOException
	 */
	public void addLeaseAgreementFileUpData(List<AgreementFileUploadVO> agreementFileUploadVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(agreementFileUploadVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AgreementRegistrationDBDAOAgreementFileUploadCSQL(), agreementFileUploadVO, null);
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
	 * Lease Agreement File Upload 데이터 정보를 삭제한다.
	 * @param List<AgreementFileUploadVO> agreementFileUploadVO
	 * @throws DAOException
	 * @throws Exception 
	 */
	public void removeLeaseAgreementFileUpData(List<AgreementFileUploadVO> agreementFileUploadVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(agreementFileUploadVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AgreementRegistrationDBDAOAgreementFileUploadDSQL(), agreementFileUploadVO,null);
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
}