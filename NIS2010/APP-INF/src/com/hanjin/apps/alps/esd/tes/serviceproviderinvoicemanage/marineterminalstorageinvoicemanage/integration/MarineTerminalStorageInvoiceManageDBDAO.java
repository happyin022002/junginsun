/*****=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MarineTerminalStorageInvoiceManageDBDAO.java
*@FileTitle : Marine Terminal Strorage Invoice관리
*Open Issues :
*Change history :
*@LastModifyDate : 2007-10-09
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-10-27 byungheeyoo
* 1.0 최초 생성
 * 2009-03-12 [R200903110001] : TES_TML_SO_PAY_DYS 테이블 미사용 제거 주석처리 
 * 2009-05-29 [N200905280100]   : TPB I/F 누락 방지 추가
 * 2015-03-24 : 김영신 [CHM-201534788]GW Agmt Link 기준 변경 (SAve->Confirm) 
=========================================================*****/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.basic.MarineTerminalStorageInvoiceManageBCImpl;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.event.EsdTes0009Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.vo.MarineTerminalStorageInvoiceManageVO;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.event.EsdTes0004Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.integration.OffdockCYInvoiceManageDBDAOSearchOffdockCYTableMaxSeqRSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.TesFileImpTmpVO;
import com.hanjin.syscommon.common.table.TesN3rdPtyIfVO;
import com.hanjin.syscommon.common.table.TesTmlSoCntrListVO;
import com.hanjin.syscommon.common.table.TesTmlSoDtlVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;


/**
 * ENIS-ESD에 대한 DB 처리를 담당<br>
 * - ENIS-ESD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author byungheeyoo
 * @see MarineTerminalStorageInvoiceManageBCImpl 참조
 * @since J2EE 1.4
 */
public class MarineTerminalStorageInvoiceManageDBDAO extends DBDAOSupport {

	/**
	 * verify 임시 data 저장
	 * @param List<TesFileImpTmpVO> voList
	 * @throws DAOException
	 */
	public void createTES_FILE_IMP_TMP( List<TesFileImpTmpVO> voList ) throws DAOException {

		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOCreateTES_FILE_IMP_TMPCSQL(), voList, null, null);
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
	 * verify 임시 data를 삭제 (ByDay와 ByPool 공통)
	 * 
	 * @param TesTmlSoHdrVO model
	 * @throws DAOException
	 */
	
	public void removeTES_FILE_IMP_TMP(TesTmlSoHdrVO model) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				//velParam.putAll( mapVO );	 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAORemoveTES_FILE_IMP_TMPDSQL(), param, null);
			
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
	 *  CY Invoice Container List Import File By Pool Insert.
	 * 
	 * @param List<TesFileImpTmpVO> voList
	 * @exception DAOException
	 */
	public void createTES_FILE_IMP_TMPByPool( List<TesFileImpTmpVO> voList ) throws DAOException {

		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOCreateTES_FILE_IMP_TMPByPoolCSQL(), voList, null, null);
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
	
	
	/** 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param TesTmlSoHdrVO model 데이타 모델
	 * @return DBRowSet
	 * @throws DAOException
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOSearchCNTRNumberRSQL(), param, velParam);
			
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
	 * 데이타 모델을 DB에 저장한다.<br>
	 * @param List<TesFileImpTmpVO> voList
	 * @throws DAOException
	 */
	public void updateCNTRNumber(List<TesFileImpTmpVO> voList ) throws DAOException {
		try {						
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOUpdateCNTRNumberUSQL(), voList, null, null);
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
	 * EDI로 받은 CNTR목록 조회 - eBilling
	 * @param TesTmlSoHdrVO model
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchEDIStorageInvoiceContainerList(TesTmlSoHdrVO model) throws DAOException {
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOSearchEDIStorageInvoiceContainerListRSQL(), param, velParam);
			
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
	 * EDI로 받은 FreePool용 CNTR목록 조회 - eBilling
	 * @param TesTmlSoHdrVO model
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchEDIStorageInvoiceContainerListFreePool(TesTmlSoHdrVO model) throws DAOException {
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOSearchEDIStorageInvoiceContainerListFreePoolRSQL(), param, velParam);
			
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
	
	/** 데이타 모델에 해당되는 값을 불러온다.<br>
	 *
	 * @param TesTmlSoHdrVO paramVO
	 * @return DBRowSet
	 * @throws DAOException
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOSearchTES_FILE_IMP_TMPRSQL(), param, null);
			
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
		
	/** verifyStorageInvoiceVolumne
	 * 
	 * @param TesTmlSoHdrVO model
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet verifyStorageInvoiceVolumne(TesTmlSoHdrVO model) throws DAOException {
		DBRowSet dbRowset = null;		
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				param.put("sto_dys_ind_cd", model.getStoDysIndCd());
				velParam.putAll(mapVO);				
				velParam.put("sto_dys_ind_cd", model.getStoDysIndCd());
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOVerifyStorageInvoiceVolumneRSQL(), param, velParam);
		
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
	

	/** verifyStorageInvoiceCostByPool
	 * 
	 * @param TesTmlSoHdrVO model
	 * @param String mode
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet verifyStorageInvoiceCostByPool(TesTmlSoHdrVO model, String mode) throws DAOException {
		DBRowSet dbRowset = null;		
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				param.put("mode", mode);
				velParam.putAll(mapVO);
				velParam.put("mode", mode);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOVerifyStorageInvoiceCostByPoolRSQL(), param, velParam);
		
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
	
	

	/** calStorageInvoiceCost
	 * 
	 * @param TesTmlSoHdrVO model
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet calStorageInvoiceCost(TesTmlSoHdrVO model) throws DAOException {
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOCalStorageInvoiceCostRSQL(), param, velParam);
			
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
	
	/** searchStorageContainerList
	 * 
	 * @param model
	 * @param CODC_type
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchStorageContainerList(TesTmlSoHdrVO model, String CODC_type) throws DAOException {
		DBRowSet dbRowset = null;
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				param.put("codc_type", CODC_type);
				velParam.putAll(mapVO);
				velParam.put("codc_type", CODC_type);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOSearchStorageContainerListRSQL(), param, velParam);
		
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
	 * Storage Container 목록을 가져온다.<br>
	 * 
	 * @param  TesTmlSoHdrVO model
	 * @param  String calc_cost_grp_cd 
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchStorageInvoiceDetail(TesTmlSoHdrVO model, String calc_cost_grp_cd) throws DAOException {
		DBRowSet dbRowset = null;
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				param.put("calc_cost_grp_cd", calc_cost_grp_cd);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOSearchStorageInvoiceDetailRSQL(), param, velParam);
		
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
	 * MarineTerminalStorageInvoiceManage의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param  TesTmlSoHdrVO model 데이타 모델
	 * @return DBRowSet
	 * @throws DAOException
	 */
	
	public DBRowSet searchStorageInvoiceBasicInfo(TesTmlSoHdrVO model) throws DAOException {
		DBRowSet dbRowset = null;		
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOSearchStorageInvoiceBasicInfoRSQL(), param, velParam);
		
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
	


	/** searchStorageInvoiceRejectInfo Reject 정보가져옴
	 * 
	 * @param model TesTmlSoHdrVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchStorageInvoiceRejectInfo(TesTmlSoHdrVO model) throws DAOException {
		DBRowSet dbRowset = null;
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOSearchStorageInvoiceRejectInfoRSQL(), param, velParam);
		
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
	 * MarineTerminalStorageInvoiceManage의 데이타 모델을 DB에 저장한다.<br>
	 * 
	 * @param model TesTmlSoHdrVO 데이타 모델
	 * @throws DAOException
	 */
	
	public void createStorageInvoiceBasicInfo(TesTmlSoHdrVO model) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			
			model.setTmlSoOfcCtyCd( model.getInvOfcCd().substring(0,3) );
			model.setFmPrdDt( JSPUtil.replace(JSPUtil.getNull(model.getFmPrdDt()),"-","") );
			model.setToPrdDt( JSPUtil.replace(JSPUtil.getNull(model.getToPrdDt()),"-","") );
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO ); 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOCreateStorageInvoiceBasicInfoCSQL(), param, null);
			
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
	 * MarineTerminalStorageInvoiceManage의 수정 된 데이타 모델을 DB에 반영한다.<br>
	 * 
	 * @param  TesTmlSoHdrVO model 데이타 모델
	 * @throws DAOException
	 */
	public void modifyStorageInvoice(TesTmlSoHdrVO model) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			model.setFmPrdDt( JSPUtil.replace(JSPUtil.getNull(model.getFmPrdDt()),"-","") );
			model.setToPrdDt( JSPUtil.replace(JSPUtil.getNull(model.getToPrdDt()),"-","") );
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO ); 
			}
			
		    new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOModifyStorageInvoiceUSQL(), param, null);
			
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
	
	/** INV 금액 가져옴
	 * 
	 * @param model TesTmlSoHdrVO
	 * @return
	 * @throws DAOException
	 */
	public String checkSOInvAmt(TesTmlSoHdrVO model) throws DAOException {
		DBRowSet dbRowset = null;
		String retval = "";
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOCheckSOInvAmtRSQL(), param, velParam);
			
			while(dbRowset.next()){
				retval = dbRowset.getString("RETVAL");
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

		return retval;
	}
	
	
	/** Confirm 
	 * 
	 * @param model TesTmlSoHdrVO
	 * @throws DAOException
	 */
	public void modifyStorageInvoiceConfirm(TesTmlSoHdrVO model) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO ); 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOModifyStorageInvoiceConfirmUSQL(), param, null);
			
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
	
	/** cancelStorageInvoiceConfirm  Confirm 취소
	 * 
	 * @param  TesTmlSoHdrVO model
	 * @throws DAOException
	 */
	public void cancelStorageInvoiceConfirm(TesTmlSoHdrVO model) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO ); 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOCancelStorageInvoiceConfirmUSQL(), param, null);
			
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
		
	/** searchStorageAccountCode
	 * 
	 * @param  model TesTmlSoHdrVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchStorageAccountCode(TesTmlSoHdrVO model) throws DAOException {

		DBRowSet dbRowset = null;		
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOSearchStorageAccountCodeRSQL(), param, null);
		
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
	
	/** updateStorageAccountCode 
	 * 
	 * @param  voList List<TesTmlSoDtlVO>
	 * @throws DAOException
	 */
	public void updateStorageAccountCode( List<TesTmlSoDtlVO> voList ) throws DAOException {
		try {						
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOUpdateStorageAccountCodeUSQL(), voList, null, null);
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
	
	/** Reject 
	 * 
	 * @param model
	 * @throws DAOException
	 */
	public void modifyStorageInvoiceReject(TesTmlSoHdrVO model) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO ); 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOModifyStorageInvoiceRejectUSQL(), param, null);
			
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
	
	/** Reject 취소
	 * 
	 * @param model
	 * @throws DAOException
	 */
	public void cancelStorageInvoiceReject(TesTmlSoHdrVO model) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO ); 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOCancelStorageInvoiceRejectUSQL(), param, null);
			
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
	
	/** 컨테이너 삭제
	 * 
	 * @param model
	 * @throws DAOException
	 */
	public void removeStorageInvoiceContainerList(TesTmlSoHdrVO model) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				//velParam.putAll( mapVO );	 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAORemoveStorageInvoiceContainerListDSQL(), param, null);
			
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
	
	/** removeStorageInvoiceDetail
	 * 
	 * @param model
	 * @param CALC_COST_GRP_CD
	 * @throws DAOException
	 */
	public void removeStorageInvoiceDetail(TesTmlSoHdrVO model, String CALC_COST_GRP_CD) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				param.put("calc_cost_grp_cd", CALC_COST_GRP_CD);
				//velParam.putAll( mapVO );	 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAORemoveStorageInvoiceDetailDSQL(), param, null);
			
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
	
	/** removeStorageInvoiceN3rd
	 *  
	 * @param model
	 * @param CALC_COST_GRP_CD
	 * @throws DAOException
	 */
	public void removeStorageInvoiceN3rd(TesTmlSoHdrVO model, String CALC_COST_GRP_CD) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				param.put("calc_cost_grp_cd", CALC_COST_GRP_CD);
				//velParam.putAll( mapVO );	 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAORemoveStorageInvoiceN3rdDSQL(), param, null);
			
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
	
	/** removeStorageInvoiceAutoCalcData
	 * 
	 * @param model
	 * @param CALC_COST_GRP_CD
	 * @throws DAOException
	 */
	public void removeStorageInvoiceAutoCalcData(TesTmlSoHdrVO model, String CALC_COST_GRP_CD) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				param.put("calc_cost_grp_cd", CALC_COST_GRP_CD);
				//velParam.putAll( mapVO );	 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAORemoveStorageInvoiceAutoCalcDataDSQL(), param, null);
			
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
	
	/** removeStorageInvoiceAutoCalcDataN3rd
	 * 
	 * @param model
	 * @param CALC_COST_GRP_CD
	 * @throws DAOException
	 */
	public void removeStorageInvoiceAutoCalcDataN3rd(TesTmlSoHdrVO model, String CALC_COST_GRP_CD) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		//Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO	= model.getColumnValues();
			if ( mapVO != null ) {
				param.putAll( mapVO );
				param.put("calc_cost_grp_cd", CALC_COST_GRP_CD);
				//velParam.putAll( mapVO );	 
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAORemoveStorageInvoiceAutoCalcDataN3rdDSQL(), param, null);
			
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
	
	/** searchStorageTableMaxSeq
	 * 
	 * @param model TesTmlSoHdrVO
	 * @param tableName String
	 * @param columnName String
	 * @return int
	 * @throws DAOException
	 */
	public int searchStorageTableMaxSeq(TesTmlSoHdrVO model, String tableName, String columnName) throws DAOException {
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
		
	/** searchStorageN3rdTableMaxSeq
	 * 
	 * @param  tml_if_ofc_cd String
	 * @return int
	 * @throws DAOException
	 */
	
	public int searchStorageN3rdTableMaxSeq(String tml_if_ofc_cd) throws DAOException {
		int rtnVal = 0;
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.put("tml_if_ofc_cd", tml_if_ofc_cd);
			velParam.put("tml_if_ofc_cd", tml_if_ofc_cd);	
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOSearchStorageN3rdTableMaxSeqRSQL(), param, velParam);
			
			while (dbRowset.next()){
				rtnVal = dbRowset.getInt("max_n3rd_list_seq");		//일단 하나라는 전제에 작업
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
	 * MarineTerminalStorageInvoiceManage의 여러 데이타 모델을 지정된 ibflag 값에 따라 DB에 반영한다.(추가, 수정, 삭제)<br>
	 * 
	 * @param voList List<TesTmlSoCntrListVO> 여러 데이타 모델
	 * @see EsdTes0009Event
	 * @throws DAOException
	 */
		
	public void addStorageInvoiceContainerList(List<TesTmlSoCntrListVO> voList) throws DAOException {		
		try {

			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOAddStorageInvoiceContainerListCSQL(), voList, null, null);
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
	 *  modifyStorageInvoiceContainerList
	 *  
	 * @param voList
	 * @throws DAOException
	 */
	public void modifyStorageInvoiceContainerList(List<TesTmlSoCntrListVO> voList) throws DAOException {		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOModifySStorageInvoiceContainerListUSQL(), voList, null, null);
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
	
///**
// * container 삭제 기능은 존재하지 않는다.	
// * @param model_hdr
// * @param models
// * @param userId
// * @param ofc_cd
// * @throws DAOException
// */
//	public void removeStorageInvoiceContainerList(List<TesTmlSoCntrListVO> voList) throws DAOException {		
//		try {
//			
//			int insCnt[] = null;
//			if(voList.size() > 0){
//				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAORemoveStorageInvoiceContainerListDSQL(), voList, null, null);
//				for(int i = 0; i < insCnt.length; i++){
//					if(insCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to delete No"+ i + " SQL");
//				}
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
//		}			
//	}
	
	/**
	 * 무조건 때려 넣는다 - verify 후에 그 결과를 바로 CNTR_LIST에 넣기 
	 * 일단 ROWSET으로 받지만 나중에 ROWSET을 VO로 변경해서 기존의 createStorageInvoiceContainerList()를 사용도 고려하시길...
	 * 
	 * @param  voList List<TesTmlSoCntrListVO> 여러 데이타 모델
	 * @return int
	 * @see EsdTes0004Event
	 * @throws DAOException
	 */
	public int insertStorageInvoiceContainerList(List<TesTmlSoCntrListVO> voList) throws DAOException {
		
		int insCnt[] = null;
		int rtnVal = 0;
		try {			
			insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOInsertStorageInvoiceContainerListCSQL(), voList, null, null);;
			
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
	
	/** insertStorageInvoiceDetail
	 * 
	 * @param  voList List<TesTmlSoDtlVO> 
	 * @return int
	 * @throws DAOException
	 */
	public int insertStorageInvoiceDetail(List<TesTmlSoDtlVO> voList) throws DAOException {
		
		int insCnt[] = null;
		int rtnVal = 0;
		try {			
			insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOInsertStorageInvoiceDetailCSQL(), voList, null, null);;
			
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
	 * addStorageInvoiceDetail 상세정보
	 * @param voList List<TesTmlSoDtlVO>
	 * @param etcMap Map<String, String>
	 * @throws DAOException
	 */
	public void addStorageInvoiceDetail(List<TesTmlSoDtlVO> voList, Map<String, String> etcMap) throws DAOException {
//	public void addStorageInvoiceDetail(List<TesTmlSoDtlVO> voList) throws DAOException {		
		
		try {
			// TES CSR I/F의 "AGMNT LINK"에 대해 Link되어있는 모든 계약서 load (4347-11-27)
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	

			if ( etcMap != null ) {
				param.putAll( etcMap );
				velParam.putAll( etcMap );		
			}


			int insCnt[] = null;
			if(voList.size() > 0){
//				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOAddStorageInvoiceDetailCSQL(), voList, null, null);
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOAddStorageInvoiceDetailCSQL(), voList, param, velParam);
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
	
	/** modifyStorageInvoiceDetail 상세정보
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void modifyStorageInvoiceDetail(List<TesTmlSoDtlVO> voList) throws DAOException {		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOModifyStorageInvoiceDetailUSQL(), voList, null, null);
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
	
	/** removeStorageInvoiceDetailDeleteN3rd  TPB 삭제
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void removeStorageInvoiceDetailDeleteN3rd(List<TesTmlSoDtlVO> voList) throws DAOException {		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAORemoveStorageInvoiceDetailDeleteN3rdDSQL(), voList, null, null);
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
	
	/** removeStorageInvoiceDetailDeleteRvis
	 *  RVIS 삭제
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void removeStorageInvoiceDetailDeleteRvis(List<TesTmlSoDtlVO> voList) throws DAOException {		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAORemoveStorageInvoiceDetailDeleteRvisDSQL(), voList, null, null);
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
	
	/** removeStorageInvoiceDetailDeleteDtl
	 *  상세정보 삭제
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void removeStorageInvoiceDetailDeleteDtl(List<TesTmlSoDtlVO> voList) throws DAOException {		
		try {
			
			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAORemoveStorageInvoiceDetailDeleteDtlDSQL(), voList, null, null);
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
	
	/** addStorage3rdIFlist
	 * 
	 * @param  voList List<TesN3rdPtyIfVO> 
	 * @throws DAOException
	 */
	public void addStorage3rdIFlist(List<TesN3rdPtyIfVO> voList) throws DAOException {		
		try {

			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOAddStorage3rdIFlistCSQL(), voList, null, null);
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
	
	/** modifyStorage3rdIFlist
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void modifyStorage3rdIFlist(List<TesN3rdPtyIfVO> voList) throws DAOException {		
		try {

			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOModifyStorage3rdIFlistUSQL(), voList, null, null);
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
	
	/** removeStorage3rdIFlist
	 *  TPB 삭제
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void removeStorage3rdIFlist(List<TesN3rdPtyIfVO> voList) throws DAOException {		
		try {

			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAORemoveStorage3rdIFlistDSQL(), voList, null, null);
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
	
	/** modifyStorage3rdIFlistCNTR
	 *  TPB 리스트 가져옴
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void modifyStorage3rdIFlistCNTR(List<TesTmlSoCntrListVO> voList) throws DAOException {		
		try {

			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOModifyStorage3rdIFlistCNTRUSQL(), voList, null, null);
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
	
	/** modifyStorage3rdIFlistDTL
	 *  DTL 정보에 TPB 유무 수정
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void modifyStorage3rdIFlistDTL(List<TesTmlSoDtlVO> voList) throws DAOException {		
		try {

			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOModifyStorage3rdIFlistDTLUSQL(), voList, null, null);
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
	
	/** removeStorage3rdIFlistTPB
	 *  DTL 정보에 TPB 유무 삭제
	 * 
	 * @param voList
	 * @throws DAOException
	 */
	public void removeStorage3rdIFlistTPB(List<TesN3rdPtyIfVO> voList) throws DAOException {		
		try {

			int insCnt[] = null;
			if(voList.size() > 0){
				insCnt = new SQLExecuter("").executeBatch((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAORemoveStorage3rdIFlistTPBDSQL(), voList, null, null);
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
	
	/** searchStorageN3rdFlag
	 *  TPB CNT 가져옴
	 * @param model
	 * @return int
	 * @throws DAOException
	 */
	public int searchStorageN3rdFlag( MarineTerminalStorageInvoiceManageVO model) throws DAOException {
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
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOSearchStorageN3rdFlagRSQL(), param, velParam);
			
			while (dbRowset!=null && dbRowset.next()){
				rtnVal = dbRowset.getInt("cnt");
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
	
	/** modifyStorageN3rdFlag
	 *  DTL 정보에 TPB 유무 수정
	 * @param model
	 * @throws DAOException
	 */
	public void modifyStorageN3rdFlag( MarineTerminalStorageInvoiceManageVO model) throws DAOException {		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {			
			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll( mapVO ); 
				param.put("n3pty_flg", "");
			}
			
			new SQLExecuter("").executeUpdate((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOModifyStorage3rdIFlistDTLUSQL(), param, null);
			
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
	
	/** searchStorage3rdIFlistOnly
	 * 
	 * @param model TesN3rdPtyIfVO
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchStorage3rdIFlistOnly(TesN3rdPtyIfVO model) throws DAOException {

		DBRowSet dbRowset = null;		
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO	= model.getColumnValues();
			
			if ( mapVO != null ) {
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOSearchStorage3rdIFlistOnlyRSQL(), param, velParam);
		
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
	
//	/**
//	 * 
//	 * @param model
//	 * @param param_map
//	 * @return
//	 * @throws DAOException
//	 */
//	public DBRowSet searchStorage3rdIFlist( MarineTerminalStorageInvoiceManageVO model ) throws DAOException {
//		DBRowSet dbRowset = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//	
//		String calc_cost_grp_cd = model.getCalcCostGrpCd();
//		String def_F = null;
//		String def_M = null;
//		if (calc_cost_grp_cd!=null && !"".equals(calc_cost_grp_cd.trim()) && calc_cost_grp_cd.trim().equals("SD") ){
//			def_F = "SRNDFL";
//			def_M = "SRNDMT";
//		}
//		
//		try {
//			Map<String, String> mapVO	= model.getColumnValues();
//			
//			if ( mapVO != null ) {
//				param.putAll(mapVO);
//				param.put("def_F",def_F);
//				param.put("def_M",def_M);
//				velParam.putAll(mapVO);
//				param.put("def_F",def_F);
//				param.put("def_M",def_M);				
//			}
//			
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOSearchStorage3rdIFlistRSQL(), param, velParam);
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
//		return dbRowset;	
//	}
	
//	/**
//	 * 
//	 * @param model
//	 * @param param_map
//	 * @return
//	 * @throws DAOException
//	 */
//	public DBRowSet searchStorage3rdIFlistManual( MarineTerminalStorageInvoiceManageVO model ) throws DAOException {
//		DBRowSet dbRowset = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//	
//		try {
//			Map<String, String> mapVO	= model.getColumnValues();
//			
//			if ( mapVO != null ) {
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);				
//			}
//			
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOSearchStorage3rdIFlistManualRSQL(), param, velParam);
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
//		return dbRowset;	
//	}
	
	/** searchStorage3rdIFlistByDay
	 * 
	 * @param model
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchStorage3rdIFlistByDay( MarineTerminalStorageInvoiceManageVO model ) throws DAOException {
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOSearchStorage3rdIFlistByDayRSQL(), param, velParam);
			
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

//	/**
//	 * 
//	 * @param model
//	 * @param param_map
//	 * @return
//	 * @throws DAOException
//	 */
//	public DBRowSet searchStorage3rdIFlistByPool( MarineTerminalStorageInvoiceManageVO model ) throws DAOException {
//		DBRowSet dbRowset = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//	
//		try {
//			Map<String, String> mapVO	= model.getColumnValues();
//			
//			if ( mapVO != null ) {
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);				
//			}
//			
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOSearchStorage3rdIFlistByPoolRSQL(), param, velParam);
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
//		return dbRowset;	
//	}
	
	/** searchStorage3rdIFlistByPoolManual
	 *  수동 TPB 
	 *  
	 * @param model
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchStorage3rdIFlistByPoolManual( MarineTerminalStorageInvoiceManageVO model ) throws DAOException {
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MarineTerminalStorageInvoiceManageDBDAOSearchStorage3rdIFlistByPoolManualRSQL(), param, velParam);
			
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
	
}