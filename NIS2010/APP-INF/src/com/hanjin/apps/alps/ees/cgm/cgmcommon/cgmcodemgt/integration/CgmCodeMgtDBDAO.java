/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CgmCodeMgtDBDAO.java
*@FileTitle : CgmCodeMgt
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.05.12 김창식
* 1.0 Creation
* 2014-04-04 by Jonghee HAN CSR Ticket : CHM-201429628, Title : Pricing-S/C Creation and Amendation 시, Amend Button 활성화 요청 
*               Amend 완료후 최종 입력된 Effective Date(Filed Date)에 맞게 이전 Version의 Chassis S/C Exception List 의 Expire Date를 1일 전까지로 변경하는 로직 (신규) 추가 및 Bug Fix
*               dbDao.modifyListSTSData(sCExceptionVersionVO);dbDao.modifyUnderListDelSTSData(sCExceptionVersionVO);
* 2014-06-17 BY JUSTIN HAN NEW CSR ID : CHM-201430737, TITLE ALPS-CHSS-Invoice에서 chassis estimated Expense 로직 수정 요청
*                S/C Exception List 의 Expiry date를 PRI 와 같은 Date로 수정, Accept 상태 Exception에 대해서만 Effective Date를 수정하도록 Proproal no, Sequence별 최종 Status Check
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.basic.CgmCodeMgtBCImpl;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.AgreementINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.AgreementMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CPSCHSSPoolINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CPSCHSSPoolMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CPSScExptListINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CPSScExptListMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ChssScExceptionHisVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ChssScExceptionVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CustomerVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.EqOrzChtINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.EqOrzChtMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.MdmOrganizationINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.MdmOrganizationMGTVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.SCExceptionCommodityVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.SCExceptionCustomerVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.SCExceptionDeleteVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.SCExceptionParmVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CHSSSCExceptionVersionVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.integration.CgmValidationDBDAOSearchCustomerNameDataRSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * NIS2010 CgmCodeMgtDBDAO <br>
 * - NIS2010-CgmCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author KIM CHANG SIK
 * @see CgmCodeMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class CgmCodeMgtDBDAO extends DBDAOSupport {

	/**
	 *  Chassis Pool 로 등록된 Agreement 정보를 조회한다.<br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchAgreementByPoolData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(comboINVO != null){
				Map<String, String> mapVO = comboINVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOSearchAgreementByPoolDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * Chassis Pool 로 등록된 리스트를 조회한다.<br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchPoolListData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(comboINVO != null){
				Map<String, String> mapVO = comboINVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOSearchPoolListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * CGM_EQ_SPEC 테이블에서 Spec No 리스트를 조회한다..<br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchSpecListData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(comboINVO != null){
				Map<String, String> mapVO = comboINVO.getColumnValues();
				log.debug("☆★☆ mapVO ---------->> " + mapVO);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOSearchSpecListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * Chassis 또는 M.G.Set 의 Type Size 목록을 조회한다.<br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchEqTpszListData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(comboINVO != null){
				Map<String, String> mapVO = comboINVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOSearchEqTpszListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * MDM 테이블에서 Manufacture리스트를 조회한다.<br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchManuListData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(comboINVO != null){
				Map<String, String> mapVO = comboINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOSearchManuListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * Neutral Pool 로 등록된 Agreement 리스트를 조회한다.<br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchMgsetNoFindData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(comboINVO != null){
				Map<String, String> mapVO = comboINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOSearchMgsetNoFindDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 *CGM에서 사용하는 공통코드 리스트를 조회한다.<br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchCommonCodeListData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(comboINVO != null){
				Map<String, String> mapVO = comboINVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOSearchCommonCodeListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * MDM_VENDOR 테이블에서 Vendor Code 및 Name 을 조회한다.<br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchVendorCodeListData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(comboINVO != null){
				Map<String, String> mapVO = comboINVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOSearchVendorCodeListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 *  MDM_STATE 테이블에서 미주지역의 State 정보를 조회한다.<br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchStateCodeListData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(comboINVO != null){
				Map<String, String> mapVO = comboINVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOSearchStateCodeListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * CGM_EQ_LOT 에 등록된 Cert No 리스트를 조회한다..<br>
	 * 
	 * @param mdmOrganizationINVO MdmOrganizationINVO
	 * @return List<MdmOrganizationMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmOrganizationMGTVO> searchOrganizationData(MdmOrganizationINVO mdmOrganizationINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmOrganizationMGTVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmOrganizationINVO != null){
				Map<String, String> mapVO = mdmOrganizationINVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOSearchOrganizationDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmOrganizationMGTVO.class);
			
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
	 * MDM_ORGANIZATION 테이블 정보를 조회한다.<br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchCertChassisListData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(comboINVO != null){
				Map<String, String> mapVO = comboINVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOSearchCertChassisListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * MMDM 테이블에서 Financing Company리스트를 조회한다.<br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchFinancingCoData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(comboINVO != null){
				Map<String, String> mapVO = comboINVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOSearchFinancingCoDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * CgmCodeMgtDBDAO의 Agreement No 의 Data 목록을 불러온다.<br>
	 * 
	 * @param agreementINVO AgreementINVO
	 * @return List<AgreementMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	@SuppressWarnings("unchecked")
	public List<AgreementMGTVO> searchAgreementMainData(AgreementINVO agreementINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgreementMGTVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(agreementINVO != null){
				Map<String, String> mapVO = agreementINVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOSearchAgreementMainDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgreementMGTVO.class);
			
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
	 * mdm_mvmt_sts 테이블 정보를 조회한다.<br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchMovementStatusListData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(comboINVO != null){
				Map<String, String> mapVO = comboINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOSearchMovementStatusListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * CGM Agreement 엔터티에서 NP 로 등록된 계약의   Agreement No (agmt_ofc_cty_cd,agmt_seq), Vendor sequence, Vendor Name( From MDM_VENDOR.VNDR_LGL_ENG_NM), Reference No (AGMT_REF_NO)  를 조회한다..<br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchNuPoolListData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(comboINVO != null){
				Map<String, String> mapVO = comboINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOSearchNuPoolListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * DATE에 해당하는 PLN_YR, PLN_WK, PLN_MON, WK_ST_DT, WK_END_DT 를 조회한다.<br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchWeekFmToDateData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(comboINVO != null){
				Map<String, String> mapVO = comboINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOSearchWeekFmToDateDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * WEEK에 해당하는 PLN_YR, PLN_WK, PLN_MON, WK_ST_DT, WK_END_DT 를 조회한다.  <br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchWeekFmToDateByWeekData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(comboINVO != null){
				Map<String, String> mapVO = comboINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOSearchWeekFmToDateByWeekDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * RCC,LCC,SCC 조회 및 Validation 체크. <br>
	 * 
	 * @param eqOrzChtINVO EqOrzChtINVO
	 * @return List<EqOrzChtMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked")
	public List<EqOrzChtMGTVO> searchEqOrzChtData(EqOrzChtINVO eqOrzChtINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EqOrzChtMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eqOrzChtINVO != null){
				Map<String, String> mapVO = eqOrzChtINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOsearchEqOrzChtDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqOrzChtMGTVO.class);
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
	 * COST COFFICE CODE 를 조회한다.  <br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchCostOfficeData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(comboINVO != null){
				Map<String, String> mapVO = comboINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOSearchCostOfficeDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * Invoice Service Provier를 조회한다.  <br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchInvSerProviderData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(comboINVO != null){
				Map<String, String> mapVO = comboINVO.getColumnValues();
						
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOSearchInvSerProviderDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * Office Code 로 Local Time 을 조회한다.  <br>
	 * 
	 * @param comboINVO ComboINVO
	 * @return List<ComboMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked")
	public List<ComboMGTVO> searchLocalTimeByOfficeData(ComboINVO comboINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComboMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(comboINVO != null){
				Map<String, String> mapVO = comboINVO.getColumnValues();
							
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOSearchLocalTimeByOfficeDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	 * S/C Exception으로 등록된 리스트를 조회한다.  <br>
	 * 
	 * @param cpsScExptListINVO CPSScExptListINVO
	 * @return List<CPSScExptListMGTVO>
	 * @exception SQLException
	 * @exception Exception 
	 */
	 @SuppressWarnings("unchecked")
	 public List<CPSScExptListMGTVO> searchCPSScExptListData(CPSScExptListINVO cpsScExptListINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CPSScExptListMGTVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();

		 try{
			 if(cpsScExptListINVO != null){
				 Map<String, String> mapVO = cpsScExptListINVO.getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOSearchCPSScExptListDataRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CPSScExptListMGTVO.class);
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
	  * 입력된 Customer Code로부터 Customer Name을 체크한다.  <br>
	  * 
	  * @param cpsScExptListINVO CPSScExptListINVO
	  * @return String
	  * @exception SQLException
	  * @exception Exception 
	  */
	 public String checkCPSScExptCustNameData(CPSScExptListINVO cpsScExptListINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String custCntCd = "";
		 String custSeq = "";
		 String custNm = "";
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(cpsScExptListINVO != null){
				 if(!"".equals(cpsScExptListINVO.getChkCustCd())){
					 custCntCd = cpsScExptListINVO.getChkCustCd().substring(0, 2);
					 custSeq = cpsScExptListINVO.getChkCustCd().substring(2);
				 } else {
					 custCntCd = "";
					 custCntCd = "";
				 }
				 
				 param.put("cust_cnt_cd", custCntCd);
				 param.put("cust_seq", custSeq);
				 velParam.put("cust_cnt_cd", custCntCd);
				 velParam.put("cust_seq", custSeq);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOCheckCPSScExptCustNameDataRSQL(), param, velParam);
			 if(dbRowset != null && dbRowset.next()){
				 custNm = dbRowset.getString(3);
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return custNm;
	 }
	 
	 /**
	  * 입력된 SCC가 유효한 값인지 체크한다.  <br>
	  * 
	  * @param cpsScExptListINVO CPSScExptListINVO
	  * @return String
	  * @exception SQLException
	  * @exception Exception 
	  */
	 public String checkCPSScExptListSccData(CPSScExptListINVO cpsScExptListINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String chkLocCd = "";
		 String sccCd = "";
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(cpsScExptListINVO != null){
				 chkLocCd = cpsScExptListINVO.getChkLocCd();
				 
				 param.put("scc_cd", chkLocCd);
				 velParam.put("scc_cd", chkLocCd);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOCheckCPSScExptListSccDataRSQL(), param, velParam);
			 if(dbRowset != null && dbRowset.next()){
				 sccCd = dbRowset.getString(1);
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return sccCd;
	 }
	 
	 /**
	  * 입력된 SC NO., E.Month, SCC로부터 중복을 체크한다.  <br>
	  * 
	  * @param cpsScExptListINVO CPSScExptListINVO
	  * @return String
	  * @exception SQLException
	  * @exception Exception 
	  */
	 public String checkCPSScExptListDupData(CPSScExptListINVO cpsScExptListINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String chkDup = "";
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(cpsScExptListINVO != null){
				 Map<String, String> mapVO = cpsScExptListINVO.getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOCheckCPSScExptListDupDataRSQL(), param, velParam);
			 if(dbRowset != null && dbRowset.next()){
				 chkDup = dbRowset.getString(1);
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return chkDup;
	 }
	 
	 /**
	  * S/C Exception List에 대한 유효성을 체크한다.  <br>
	  * 
	  * @param cpsScExptListINVO CPSScExptListINVO
	  * @return CPSScExptListINVO
	  * @exception SQLException
	  * @exception Exception 
	  */
	 @SuppressWarnings("unchecked")
	 public CPSScExptListINVO validationCPSScExptListData(CPSScExptListINVO cpsScExptListINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CPSScExptListINVO> list = null;
		 CPSScExptListINVO resultVO = new CPSScExptListINVO();
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(cpsScExptListINVO != null){
				 Map<String, String> mapVO = cpsScExptListINVO.getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOValidationCPSScExptListDataRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CPSScExptListINVO.class);
			 if(list != null){
				 if(list.size() > 0){
					 resultVO = (CPSScExptListINVO)list.get(0);
				 }
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return resultVO;
	 }
	 
	 /**
	  * 입력된 Group Customer Code로부터 Group Customer Name을 체크한다.  <br>
	  * 
	  * @param cpsScExptListINVO CPSScExptListINVO
	  * @return String
	  * @exception SQLException
	  * @exception Exception 
	  */
	 public String checkCPSScExptGroupCustNameData(CPSScExptListINVO cpsScExptListINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String custGrpId = "";
		 String custGrpNm = "";
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(cpsScExptListINVO != null){
				 custGrpId = cpsScExptListINVO.getCustGrpId();
				 
				 param.put("cust_grp_id", custGrpId);
				 velParam.put("cust_grp_id", custGrpId);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOCheckCPSScExptGroupCustNameDataRSQL(), param, velParam);
			 if(dbRowset != null && dbRowset.next()){
				 custGrpNm = dbRowset.getString(2);
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return custGrpNm;
	 }
	 
	 /**
	  * S/C Exception List를 입력한다. <br>
	  * Insert시 에러 발생 할 경우 exception 처리 안함. 에러 flag 이용 화면에서 메시지 처리 <br>
	  * 
	  * @param cpsScExptListINVO CPSScExptListINVO
	  * @return int
	  * @exception DAOException
	  */
	 public int addCPSScExptListData(CPSScExptListINVO cpsScExptListINVO) throws DAOException {
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 int result = 0;
		 try{
			 if(cpsScExptListINVO != null){
				 Map<String, String> mapVO = cpsScExptListINVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
				 
				 SQLExecuter sqlExe = new SQLExecuter("");
				 result = sqlExe.executeUpdate((ISQLTemplate)new CgmCodeMgtDBDAOAddCPSScExptListDataCSQL(), param, velParam);
			 }
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getUserMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getUserMessage());
		 }
		 return result;
	 }
	 
	 /**
	  * S/C Exception List를 수정한다. <br>
	  * Update시 에러 발생 할 경우 exception 처리 안함. 에러 flag 이용 화면에서 메시지 처리 <br>
	  * 
	  * @param cpsScExptListINVO CPSScExptListINVO 
	  * @return int
	  * @exception DAOException
	  */
	 public int modifyCPSScExptListData(CPSScExptListINVO cpsScExptListINVO) throws DAOException {
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 int result = 0;
		 try{
			 Map<String, String> mapVO = cpsScExptListINVO.getColumnValues();
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 SQLExecuter sqlExe = new SQLExecuter("");
			 result = sqlExe.executeUpdate((ISQLTemplate)new CgmCodeMgtDBDAOModifyCPSScExptListDataUSQL(), param, velParam);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getUserMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getUserMessage());
		 }
		 return result;
	 }
	 
	 /**
	  * S/C Exception List를 삭제한다. <br>
	  * Delete시 에러 발생 할 경우 exception 처리 안함. 에러 flag 이용 화면에서 메시지 처리 <br> 
	  * 
	  * @param cpsScExptListINVO CPSScExptListINVO 
	  * @return int
	  * @exception DAOException
	  */
	 public int removeCPSScExptListData(CPSScExptListINVO cpsScExptListINVO) throws DAOException {
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 int result = 0;
		 try{
			 Map<String, String> mapVO = cpsScExptListINVO.getColumnValues();
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 SQLExecuter sqlExe = new SQLExecuter("");
			 result = sqlExe.executeUpdate((ISQLTemplate)new CgmCodeMgtDBDAORemoveCPSScExptListDataDSQL(), param, velParam);
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getUserMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getUserMessage());
		 }
		 return result;
	 }
	 
	 /**
	  * CPS Neutral Pool로 등록된 업체를 조회한다.  <br>
	  * 
	  * @param cpsCHSSPoolINVO CPSCHSSPoolINVO
	  * @return List<CPSCHSSPoolMGTVO>
	  * @exception SQLException
	  * @exception Exception 
	  */
	 @SuppressWarnings("unchecked")
	 public List<CPSCHSSPoolMGTVO> searchCPSCHSSPoolData(CPSCHSSPoolINVO cpsCHSSPoolINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CPSCHSSPoolMGTVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(cpsCHSSPoolINVO != null){
				 Map<String, String> mapVO = cpsCHSSPoolINVO.getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOSearchCPSCHSSPoolDataRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CPSCHSSPoolMGTVO.class);
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
	  * CPS Chassis Pool List를 조회한다. <br>
	  * 
	  * @param comboINVO ComboINVO
	  * @return List<ComboMGTVO>
	  * @exception SQLException
	  * @exception Exception 
	  */
	 @SuppressWarnings("unchecked")
	 public List<ComboMGTVO> searchCPSCHSSPoolListData(ComboINVO comboINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<ComboMGTVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try{
			 if(comboINVO != null){
				 Map<String, String> mapVO = comboINVO.getColumnValues();
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOSearchCPSCHSSPoolListDataRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComboMGTVO.class);
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
	  * 입력된 Pool Code의 중복을 체크한다.  <br>
	  * 
	  * @param cpsCHSSPoolINVO CPSCHSSPoolINVO
	  * @return String
	  * @exception SQLException
	  * @exception Exception 
	  */
	 public String checkCPSCHSSPoolCodeDupData(CPSCHSSPoolINVO cpsCHSSPoolINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String chkChssPoolCd = "";
		 String poolCd = "";
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(cpsCHSSPoolINVO != null){
				 chkChssPoolCd = cpsCHSSPoolINVO.getChkChssPoolCd();
				 
				 param.put("chss_pool_cd", chkChssPoolCd);
				 velParam.put("chss_pool_cd", chkChssPoolCd);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOCheckCPSCHSSPoolCodeDupDataRSQL(), param, velParam);
			 if(dbRowset != null && dbRowset.next()){
				 poolCd = dbRowset.getString(1);
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return poolCd;
	 }
	 
	 /**
	  * 입력된 Vendor Code로부터 Vendor Name을 체크한다.  <br>
	  * 
	  * @param cpsCHSSPoolINVO CPSCHSSPoolINVO
	  * @return String
	  * @exception SQLException
	  * @exception Exception 
	  */
	 public String checkCPSCHSSPoolVndrNameData(CPSCHSSPoolINVO cpsCHSSPoolINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String vndrSeq = "";
		 String vndrNm = "";
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(cpsCHSSPoolINVO != null){
				 vndrSeq = cpsCHSSPoolINVO.getChkVndrSeq();
				 
				 param.put("vndr_seq", vndrSeq);
				 velParam.put("vndr_seq", vndrSeq);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOCheckCPSCHSSPoolVndrNameDataRSQL(), param, velParam);
			 if(dbRowset != null && dbRowset.next()){
				 vndrNm = dbRowset.getString(2);
			 }
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return vndrNm;
	 }
	 
	 /**
	  * CPS Neutral Pool을 입력한다. <br>
	  * 
	  * @param insertVoList List<CPSCHSSPoolINVO>
	  * @exception EventException
	  */
	 public void addCPSCHSSPoolData(List<CPSCHSSPoolINVO> insertVoList) throws DAOException {
		 int result[] = null;
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 if(insertVoList.size() > 0){
				 result = sqlExe.executeBatch((ISQLTemplate)new CgmCodeMgtDBDAOAddCPSCHSSPoolDataCSQL(), insertVoList, null);
				 for(int i=0; i<result.length;i++){
					 if(result[i] == Statement.EXECUTE_FAILED){
						 throw new DAOException("Fail to insert No"+ i + " SQL");
					 }
				 }
			 }
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getUserMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getUserMessage());
		 }
	 }
	 
	 /**
	  * CPS Neutral Pool을 수정한다. <br>
	  * 
	  * @param updateVoList List<CPSCHSSPoolINVO> 
	  * @exception EventException
	  */
	 public void modifyCPSCHSSPoolData(List<CPSCHSSPoolINVO> updateVoList) throws DAOException {
		 int result[] = null;
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 if(updateVoList.size() > 0){
				 result = sqlExe.executeBatch((ISQLTemplate)new CgmCodeMgtDBDAOModifyCPSCHSSPoolDataUSQL(), updateVoList, null);
				 for(int i=0; i<result.length;i++){
					 if(result[i] == Statement.EXECUTE_FAILED){
						 throw new DAOException("Fail to insert No"+ i + " SQL");
					 }
				 }
			 }
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getUserMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getUserMessage());
		 }
	 }
	 
	 /**
	  * CPS Neutral Pool을 삭제한다. <br>
	  * 
	  * @param deleteVoList List<CPSCHSSPoolINVO> 
	  * @exception EventException
	  */
	 public void removeCPSCHSSPoolData(List<CPSCHSSPoolINVO> deleteVoList) throws DAOException {
		 int result[] = null;
		 try{
			 SQLExecuter sqlExe = new SQLExecuter("");
			 if(deleteVoList.size() > 0){
				 result = sqlExe.executeBatch((ISQLTemplate)new CgmCodeMgtDBDAORemoveCPSCHSSPoolDataDSQL(), deleteVoList, null);
				 for(int i=0; i<result.length;i++){
					 if(result[i] == Statement.EXECUTE_FAILED){
						 throw new DAOException("Fail to insert No"+ i + " SQL");
					 }
				 }
			 }
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getUserMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getUserMessage());
		 }
	 }
	 
	/**
	 * Proposal No. 에 해당하는 Commodity 정보를 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO
	 *            sCExceptionParmVO
	 * @return List<SCExceptionCommodityVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SCExceptionCommodityVO> searchCommodityListBySCData(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SCExceptionCommodityVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchCommodityListBySCDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SCExceptionCommodityVO.class);
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
	 * Proposal No. 에 해당되는 SC No.와 Customer Code, Customer Name을 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCustomerVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SCExceptionCustomerVO> searchSCNoCustomerByProposalNoData(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SCExceptionCustomerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOSearchSCNoCustomerByProposalNoDataRSQL(), param, velParam);				
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCExceptionCustomerVO .class);
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
	 * S/C Exception Tariff 를 Accept, Accept Cancel 할 수 있는 권한이 있는지를 조회한다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean hasAcceptAuthData(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchHasAcceptAuthDataRSQL(), param, velParam);

			if (dbRowset.next()) {
				result = dbRowset.getInt(1) > 0 ? true : false;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * Proposal No 의 S/C Duration 데이터를 조회한다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return SCExceptionParmVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public SCExceptionParmVO searchSCDurationData(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		SCExceptionParmVO resultVO = null;
		List<SCExceptionParmVO> resultVOS = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchSCDurationDataRSQL(), param, velParam);				
			resultVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, SCExceptionParmVO .class);
			
			if (resultVOS != null && resultVOS.size() > 0) {
				resultVO = resultVOS.get(0);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultVO;
	}
	
	/**
	 * Proposal No. 에 해당하는 Version 목록을 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<CHSSSCExceptionVersionVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")	
	public List<CHSSSCExceptionVersionVO> searchSCVersionByProposalNo(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSSSCExceptionVersionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchSCVersionByPropNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CHSSSCExceptionVersionVO .class);
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
	 * S/C Exception Terms Entry를 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO
	 *            sCExceptionParmVO
	 * @return List<ChssScExceptionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ChssScExceptionVO> searchSCExceptionData(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChssScExceptionVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchCHSSCExceptionDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ChssScExceptionVO.class);
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
	 * Proposal No. 에 해당하는 Actual Customer 정보를 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<SCExceptionCustomerVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")	
	public List<SCExceptionCustomerVO> searchCustomerListBySCBasic(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SCExceptionCustomerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchCustomerListBySCDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCExceptionCustomerVO .class);
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
	 * 특정 Version 정보가 존재하는지 조회 합니다. <br>
	 * 
	 * @param CHSSSCExceptionVersionVO sCExceptionVersionVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean existSCExceptionVersionData(CHSSSCExceptionVersionVO sCExceptionVersionVO) throws DAOException {
		boolean result = false;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (sCExceptionVersionVO != null) {
				Map<String, String> mapVO = sCExceptionVersionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAODuplicateSCExceptionVersionDataRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt(1) > 0 ? true : false;

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * S/C Exception Version를 생성 합니다. <br>
	 * 
	 * @param CHSSSCExceptionVersionVO sCExceptionVersionVO
	 * @throws DAOException
	 */
	public void addSCExceptionVersionData(CHSSSCExceptionVersionVO sCExceptionVersionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionVersionVO != null) {
				Map<String, String> mapVO = sCExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			new SQLExecuter("").executeUpdate((ISQLTemplate) new CgmCodeMgtDBDAOAddSCExceptionVersionDataCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * S/C Exception Version 의 상태를 수정 합니다. <br>
	 * 
	 * @param CHSSSCExceptionVersionVO sCExceptionVersionVO
	 * @throws DAOException
	 */
	public void modifyVersionStsData(CHSSSCExceptionVersionVO sCExceptionVersionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionVersionVO != null) {
				Map<String, String> mapVO = sCExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			new SQLExecuter("").executeUpdate((ISQLTemplate) new CgmCodeMgtDBDAOModifySCVersionStsDataUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * S/C 에 생성된 이력중 마지막 이력상태가 'Temp.Saved' 인지를 조회 합니다. <br>
	 * 
	 * @param CHSSSCExceptionVersionVO sCExceptionVersionVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean isTempSavedStatusOfLastVersionProgData(CHSSSCExceptionVersionVO sCExceptionVersionVO) throws DAOException {
		boolean				result		= false;
		DBRowSet			dbRowset	= null;
		//query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();

		try{
			if (sCExceptionVersionVO != null) {
				Map<String, String> mapVO = sCExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchTmpStsVerProgDataRSQL(), param, velParam);

			if (dbRowset.next())
				result = dbRowset.getInt(1) > 0 ? true : false;
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * S/C 의 버전상태가 변경될 경우 그 이력을 생성 합니다. <br>
	 * 
	 * @param CHSSSCExceptionVersionVO sCExceptionVersionVO
	 * @throws DAOException
	 */
	public void modifyLastVersionProgData(CHSSSCExceptionVersionVO sCExceptionVersionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionVersionVO != null) {
				Map<String, String> mapVO = sCExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			new SQLExecuter("").executeUpdate((ISQLTemplate) new CgmCodeMgtDBDAOModifyLastVersionProgDataUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * S/C 의 버전상태가 변경될 경우 그 이력을 생성 합니다. <br>
	 * 
	 * @param CHSSSCExceptionVersionVO sCExceptionVersionVO
	 * @throws DAOException
	 */
	public void addSCExceptionVersionProgData(CHSSSCExceptionVersionVO sCExceptionVersionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionVersionVO != null) {
				Map<String, String> mapVO = sCExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			new SQLExecuter("").executeUpdate((ISQLTemplate) new CgmCodeMgtDBDAOAddSCVersionProgDataCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 선택한 S/C Exception Tariff 의 다음 Group Seq. 정보를 조회 합니다.<br>
	 * 
	 * @param  ChssScExceptionVO chssScExceptionVO
	 * @return String
	 * @throws DAOException
	 */	
	public String searchSCExceptionGroupSeqData(ChssScExceptionVO chssScExceptionVO)  throws DAOException {
		String				result		= null;
		DBRowSet			dbRowset	= null;
		//query parameter
		Map<String, Object> param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam 	= new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (chssScExceptionVO != null) {
				Map<String, String> mapVO = chssScExceptionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchSCExceptionGRPSeqDataRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				result = dbRowset.getInt(1) + "";
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * S/C Exception Tariff 의 정보를 생성 합니다. <br>
	 * 
	 * @param ChssScExceptionVO chssScExceptionVO
	 * @throws DAOException
	 */
	public void addSCExceptionGroupData(ChssScExceptionVO chssScExceptionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (chssScExceptionVO != null) {
				Map<String, String> mapVO = chssScExceptionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			new SQLExecuter("").executeUpdate((ISQLTemplate) new CgmCodeMgtDBDAOAddSCExceptionGroupDataCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * S/C Exception Tariff 의 정보를 수정 합니다. <br>
	 * 
	 * @param ChssScExceptionVO chssScExceptionVO
	 * @throws DAOException
	 */
	public void modifySCExceptionGroupData(ChssScExceptionVO chssScExceptionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if (chssScExceptionVO != null) {
				Map<String, String> mapVO = chssScExceptionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			new SQLExecuter("").executeUpdate((ISQLTemplate) new CgmCodeMgtDBDAOModifySCExceptionGrpDataUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Customer Name 을 조회한다.<br>
	 * 
	 * @param CustomerVO customerVO
	 * @return String
	 * @exception EventException
	 */	 
	public String searchCustomerNameData(CustomerVO customerVO) throws DAOException {
		DBRowSet dbRowset = null;
		String custNm = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (customerVO != null) {
				Map<String, String> mapVO = customerVO .getColumnValues();

				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmValidationDBDAOSearchCustomerNameDataRSQL(), param, null);
			if (dbRowset.next()) {
				custNm = dbRowset.getString("cust_nm");
			} else {
				custNm = "";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return custNm;
	}
	
	/**
	 * PRI_SP_CTRT_PTY에 동일한 Customer가 존재하는지 조회합니다.<br>
	 * 
	 * @param  SCExceptionParmVO sCExceptionParmVO
	 * @return String
	 * @throws DAOException
	 */
	public boolean isCustomerByPriMnData(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//result object
		boolean  				isCustomer	= false;
		DBRowSet				dbRowSet	= null;
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();
		
		try {
			//Set Query Parameter
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchCustomerByPriMnDataRSQL(), param, velParam);
			if (dbRowSet.next()) {
				isCustomer = dbRowSet.getInt("cnt") > 0 ? true : false;
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return isCustomer;
	}
	
	/**
     * comodity 정보를 조회한다.
     * 
     * @param String cmdtCd
     * @return String
     * @throws DAOException
     */
    public String searchCommodityNameData(String cmdtCd) throws DAOException {
        DBRowSet dbRowset = null;
        String commodity = "";
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        try{
            param.put("cmdt_cd", cmdtCd);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CgmCodeMgtDBDAOSearchCommodityInfoDataRSQL(), param, null);
            if(dbRowset.next()){
                commodity = dbRowset.getString("commodity");
            }
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return commodity;
    }
    
    /**
	  * SC Exception 을 지운다 <br>
	  * 
	  * @param ChssScExceptionVO chssScExceptionVO
	  * @exception EventException
	  */
	 public void removeScExceptionData(ChssScExceptionVO chssScExceptionVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (chssScExceptionVO != null) {
				Map<String, String> mapVO = chssScExceptionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate) new CgmCodeMgtDBDAORemoveScExceptionListDSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	 }
	 
	/**
	 * 선택한 S/C Exception Tariff 의 다음 Version Seq. 정보를 조회 합니다.<br>
	 * 
	 * @param String propNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchSCExceptionVersionSeqData(String propNo) throws DAOException {
		String result = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			// Set Query Parameter
			param.put("prop_no", propNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchScExceptionVerSeqDataRSQL(), param, null);

			if (dbRowset.next()) {
				result = dbRowset.getString(1);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * 이전 버전의 모든 S/C Exception 정보를 신규 버전으로 생성 합니다.<br>
	 * 
	 * @param  ChssScExceptionVO chssScExceptionVO
	 * @throws DAOException
	 */
	public void addSCExceptionOfPrevVersionData(ChssScExceptionVO chssScExceptionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (chssScExceptionVO != null) {
				Map<String, String> mapVO = chssScExceptionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate) new CgmCodeMgtDBDAOAddSCExceptionGroupDataCSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Accept 버튼 클릭시 상태가 Live 로 변경될 경우, 이하버전의 Live 상태는 모두 Deleted 상태로 수정 합니다. <br>
	 * 
	 * @param CHSSSCExceptionVersionVO sCExceptionVersionVO
	 * @throws DAOException
	 */
	
	public void modifyUnderListDelSTSData(CHSSSCExceptionVersionVO sCExceptionVersionVO) throws DAOException {
		//query parameter
		//2014-04-04 by Jonghee HAN List 이전 Version의 Expire Date 변경 로직 신규 추가
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionVersionVO != null) {
				Map<String, String> mapVO = sCExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			new SQLExecuter("").executeUpdate((ISQLTemplate) new CgmCodeMgtDBDAOModifyUnderListDelStsDataUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Accept 버튼 클릭시 상태가 Live 로 변경될 경우, 이하버전의 Live 상태는 모두 Deleted 상태로 수정 합니다. <br>
	 * 
	 * @param CHSSSCExceptionVersionVO sCExceptionVersionVO
	 * @throws DAOException
	 */
	public void modifyUnderVersionDelSTSData(CHSSSCExceptionVersionVO sCExceptionVersionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionVersionVO != null) {
				Map<String, String> mapVO = sCExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			new SQLExecuter("").executeUpdate((ISQLTemplate) new CgmCodeMgtDBDAOModifyUnderVersionDelStsDataUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Accept 버튼 클릭시 상태가 Live 로 변경될 경우, 이하버전의 Live 상태는 모두 Deleted 상태로 변경함에 따른 그 이력을 생성 합니다.<br>
	 * 
	 * @param CHSSSCExceptionVersionVO sCExceptionVersionVO
	 * @throws DAOException
	 */
	public void addUnderVersionPROGData(CHSSSCExceptionVersionVO sCExceptionVersionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionVersionVO != null) {
				Map<String, String> mapVO = sCExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			new SQLExecuter("").executeUpdate((ISQLTemplate) new CgmCodeMgtDBDAOAddUnderVersionProgDataCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * S/C Exception Version 의 상태를 수정 합니다. <br>
	 * 
	 * @param CHSSSCExceptionVersionVO sCExceptionVersionVO
	 * @throws DAOException
	 */
	public void modifyVersionSTSData(CHSSSCExceptionVersionVO sCExceptionVersionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionVersionVO != null) {
				Map<String, String> mapVO = sCExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			new SQLExecuter("").executeUpdate((ISQLTemplate) new CgmCodeMgtDBDAOModifySCVersionStsDataUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * S/C Exception List 의 상태를 수정 합니다. <br>
	 * 
	 * @param CHSSSCExceptionVersionVO sCExceptionVersionVO
	 * @throws DAOException 
	 */
	public void modifyListSTSData(CHSSSCExceptionVersionVO sCExceptionVersionVO) throws DAOException {
		//2014-04-04 by Jonghee HAN List 상태 변경로직 신규 추가
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionVersionVO != null) {
				Map<String, String> mapVO = sCExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			new SQLExecuter("").executeUpdate((ISQLTemplate) new CgmCodeMgtDBDAOModifySCListStsDataUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * S/C Exception Version를 삭제 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @throws DAOException
	 */
	public void removeSCExceptionByVerData(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExecuter = new SQLExecuter("");
			
			sqlExecuter.executeUpdate((ISQLTemplate) new CgmCodeMgtDBDAORemoveSCExceptionListByVerDataDSQL(), param, velParam);
			sqlExecuter.executeUpdate((ISQLTemplate) new CgmCodeMgtDBDAORemoveSCExceptionVerProgDataDSQL(), param, velParam);
			sqlExecuter.executeUpdate((ISQLTemplate) new CgmCodeMgtDBDAORemoveSCExceptionVerDataDSQL(), param, velParam);				
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * S/C 가 Filed Status 인지를 조회 합니다.<br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkFiledBySCData(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOCheckFileBySCDataRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt(1) > 0 ? true : false;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * Prop No. 에 해당하는 S/C Exception를 조회 합니다. <br>
	 * 
	 * @param String sCNo
	 * @return List<SCExceptionVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ChssScExceptionHisVO> searchSCExceptionListByPropNoData(String sCNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChssScExceptionHisVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			param.put("prop_no", sCNo);
			velParam.put("prop_no", sCNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOSearchSCExceptionListByPropNoDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChssScExceptionHisVO .class);
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
	 * S/C Exception 의 Version 에 포함된 정보가 존재하는지 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean existSCExceptionData(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		boolean result = false;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOExistSCExceptionListDataRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt(1) > 0 ? true : false;

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * S/C Exception Version를 삭제 합니다. <br>
	 * 
	 * @param SCExceptionDeleteVO sCExceptionDeleteVO
	 * @throws DAOException
	 */
	public void removeSCExceptionListByVerData(SCExceptionDeleteVO sCExceptionDeleteVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionDeleteVO != null) {
				Map<String, String> mapVO = sCExceptionDeleteVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExecuter = new SQLExecuter("");
			
			sqlExecuter.executeUpdate((ISQLTemplate) new CgmCodeMgtDBDAORemoveSCExceptionListByVerDataDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * S/C Exception Tariff History 팝업에서 선택한 버전의 모든 S/C Exception 정보를 현재 버전으로 생성 합니다.<br>
	 * 
	 * @param  SCExceptionParmVO sCExceptionParmVO
	 * @throws DAOException
	 */
	public void addSCExceptionGroupOfHistVersionData(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Set Query Parameter
			if (sCExceptionParmVO != null) {
				Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			new SQLExecuter("").executeUpdate((ISQLTemplate) new CgmCodeMgtDBDAOAddScExceptionListOfHisDataCSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 이전 버전의 S/C Exception를 조회 합니다. <br>
	 * 
	 * @param SCExceptionParmVO sCExceptionParmVO
	 * @return List<ChssScExceptionVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ChssScExceptionVO> searchChssSCExptListData(SCExceptionParmVO sCExceptionParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChssScExceptionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = sCExceptionParmVO .getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOsearchChssScExptListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChssScExceptionVO .class);
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
	 * Proposal No. 에 해당하는 Version 목록을 조회 합니다. <br>
	 * 
	 * @param String propNo
	 * @return List<SCExceptionVersionVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CHSSSCExceptionVersionVO> searchSCVersionByAdmtData(String propNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSSSCExceptionVersionVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			//Set Query Parameter
			param.put("prop_no", propNo);
			velParam.put("prop_no", propNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOsearchSCExptAcptStatusDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSSSCExceptionVersionVO.class);
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
	 * Table CGM_SC_EXPT_VER_PROG에서 PROP_NO와 SC_EXPT_VER_SEQ에 해당하는 <br>
	 * Max(PROG_SEQ)의 CHSS_EXPT_VER_STS_CD를 조회 합니다. <br>
	 * 
	 * @param String propNo
	 * @param String scExptVerSeq
	 * @return String result
	 * @throws DAOException
	 */
	public String searchChssExptVerStsCdOfBeforeSeq(String propNo, String scExptVerSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String result = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			//Set Query Parameter
			param.put("prop_no", propNo);
			param.put("sc_expt_ver_seq", scExptVerSeq);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new CgmCodeMgtDBDAOsearchChssExptVerStsCdOfBeforeSeqRSQL(), param, null);
			
			if (dbRowset.next()) {
				result = dbRowset.getString(1);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * S/C Exception List 의 상태를 수정 합니다. <br>
	 * modifyListSTSData(CHSSSCExceptionVersionVO sCExceptionVersionVO)의 분리 버전
	 * 
	 * @param CHSSSCExceptionVersionVO sCExceptionVersionVO
	 * @throws DAOException
	 */
	public void modifyListSTSDataOnlyExpDt(CHSSSCExceptionVersionVO sCExceptionVersionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionVersionVO != null) {
				Map<String, String> mapVO = sCExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			new SQLExecuter("").executeUpdate((ISQLTemplate) new CgmCodeMgtDBDAOModifySCListStsDataOnlyExpDtUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * S/C Exception Version 의 상태를 수정 합니다. <br>
	 * modifyVersionSTSData(CHSSSCExceptionVersionVO sCExceptionVersionVO)의 분리 버전 <br>
	 * 
	 * @param CHSSSCExceptionVersionVO sCExceptionVersionVO
	 * @throws DAOException
	 */
	public void modifyVersionSTSDataOnlyExpDt(CHSSSCExceptionVersionVO sCExceptionVersionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (sCExceptionVersionVO != null) {
				Map<String, String> mapVO = sCExceptionVersionVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			new SQLExecuter("").executeUpdate((ISQLTemplate) new CgmCodeMgtDBDAOModifySCVersionStsDataOnlyExpDtUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}
