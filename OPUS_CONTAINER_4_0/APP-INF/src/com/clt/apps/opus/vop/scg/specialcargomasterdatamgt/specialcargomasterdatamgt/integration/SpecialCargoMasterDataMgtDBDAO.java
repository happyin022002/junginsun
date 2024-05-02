/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoMasterDataMgtDBDAO.java
*@FileTitle : SPCL CGO RSO (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.04
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.04 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.basic.SpecialCargoMasterDataMgtBCImpl;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.GetLoadingPortRsoVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.MdmVslSvcLaneListVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgCntcPntVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgPckInstrVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgSpclProvisVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgUnNoOrgRactVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgMailTampletVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgRgnShpOprPortListVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchIrregularTypeCodeListVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchLoadingPortRsoVO;
import com.clt.apps.opus.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchRsoComboListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.MdmCarrierVO;
import com.clt.syscommon.common.table.ScgImdgAbbrVO;
import com.clt.syscommon.common.table.ScgImdgClssCdVO;
import com.clt.syscommon.common.table.ScgImdgCompGrpVO;
import com.clt.syscommon.common.table.ScgImdgExptQtyVO;
import com.clt.syscommon.common.table.ScgImdgMrnPolutVO;
import com.clt.syscommon.common.table.ScgImdgPckCdVO;
import com.clt.syscommon.common.table.ScgImdgPckGrpVO;
import com.clt.syscommon.common.table.ScgImdgSegrGrpDtlVO;
import com.clt.syscommon.common.table.ScgImdgSegrGrpVO;
import com.clt.syscommon.common.table.ScgImdgSegrSymVO;
import com.clt.syscommon.common.table.ScgImdgSpclProviVO;
import com.clt.syscommon.common.table.ScgImdgTnkTpVO;
import com.clt.syscommon.common.table.ScgLodRjctCdVO;
import com.clt.syscommon.common.table.ScgRgnShpOprCdVO;


/**
 * OPUS SpecialCargoMasterDataMgtDBDAO <br>
 * - OPUS-SpecialCargoMasterDataMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Dohyoung Lee
 * @see SpecialCargoMasterDataMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class SpecialCargoMasterDataMgtDBDAO extends DBDAOSupport {

	/**
	 * Load Reject Reason을 조회 합니다. <br>
	 * 
	 * @param scgLodRjctCdVO ScgLodRjctCdVO
	 * @return List<ScgLodRjctCdVO>
	 * @throws DAOException
	 */ 
	public List<ScgLodRjctCdVO> searchLoadRejectReasonCodeList(ScgLodRjctCdVO scgLodRjctCdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgLodRjctCdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgLodRjctCdVO != null){
				Map<String, String> mapVO = scgLodRjctCdVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				if("".equals(mapVO.get("delt_flg"))) {   //if (mapVO.get("delt_flg") == "")
			    	param.put("delt_flg", "N");
			    	velParam.put("delt_flg", "N");
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgLodRjctCdVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgLodRjctCdVO.class);
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
	 * Load Reject Reason을 생성 합니다. <br>
	 * 
	 * @param scgLodRjctCdVOs List<ScgLodRjctCdVO>
	 * @throws DAOException
	 */
	public void addLoadRejectReasonCode(List<ScgLodRjctCdVO> scgLodRjctCdVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgLodRjctCdVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgLodRjctCdVOCSQL(), scgLodRjctCdVOs,null);
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
	 * Load Reject Reason을 수정 합니다. <br>
	 * 
	 * @param scgLodRjctCdVOs List<ScgLodRjctCdVO>
	 * @throws DAOException
	 */
	public void modifyLoadRejectReasonCode(List<ScgLodRjctCdVO> scgLodRjctCdVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgLodRjctCdVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgLodRjctCdVOUSQL(), scgLodRjctCdVOs,null);
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
	 * Load Reject Reason을 삭제 합니다. <br>
	 * 
	 * @param scgLodRjctCdVOs List<ScgLodRjctCdVO>
	 * @throws DAOException
	 */
	public void removeLoadRejectReasonCode(List<ScgLodRjctCdVO> scgLodRjctCdVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgLodRjctCdVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgLodRjctCdVODSQL(), scgLodRjctCdVOs,null);

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
	 * SPCL CGO RSO을 조회 합니다. <br>
	 * 
	 * @param scgRgnShpOprCdVO ScgRgnShpOprCdVO
	 * @return List<ScgRgnShpOprCdVO>
	 * @throws DAOException
	 */
	public List<ScgRgnShpOprCdVO> searchRegionalShipOperatorCodeList(ScgRgnShpOprCdVO scgRgnShpOprCdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgRgnShpOprCdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgRgnShpOprCdVO != null){
				Map<String, String> mapVO = scgRgnShpOprCdVO.getColumnValues();				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				if("".equals(mapVO.get("delt_flg"))) {  //if (mapVO.get("delt_flg") == "")
			    	param.put("delt_flg", "N");
			    	velParam.put("delt_flg", "N");
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgRgnShpOprCdVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgRgnShpOprCdVO.class);
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
	 * SPCL CGO RSO을 생성 합니다. <br>
	 * 
	 * @param scgRgnShpOprCdVOs List<ScgRgnShpOprCdVO>
	 * @throws DAOException
	 */
	public void addRegionalShipOperatorCode(List<ScgRgnShpOprCdVO> scgRgnShpOprCdVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgRgnShpOprCdVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgRgnShpOprCdVOCSQL(), scgRgnShpOprCdVOs,null);
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
	 * SPCL CGO RSO을 수정 합니다. <br>
	 * 
	 * @param scgRgnShpOprCdVOs List<ScgRgnShpOprCdVO>
	 * @throws DAOException
	 */
	public void modifyRegionalShipOperatorCode(List<ScgRgnShpOprCdVO> scgRgnShpOprCdVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgRgnShpOprCdVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgRgnShpOprCdVOUSQL(), scgRgnShpOprCdVOs,null);
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
	 * SPCL CGO RSO을 삭제 합니다. <br>
	 * 
	 * @param scgRgnShpOprCdVOs List<ScgRgnShpOprCdVO>
	 * @throws DAOException
	 */
	public void removeRegionalShipOperatorCode(List<ScgRgnShpOprCdVO> scgRgnShpOprCdVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgRgnShpOprCdVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgRgnShpOprCdVODSQL(), scgRgnShpOprCdVOs,null);

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
	 * Partner's Contact Point for SPCL CGO 을 조회 합니다. <br>
	 * 
	 * @param scgCntcPntVO ScgCntcPntVO
	 * @return List<ScgCntcPntVO>
	 * @throws DAOException
	 */
	public List<ScgCntcPntVO> searchPartnerLineContactPointList(ScgCntcPntVO scgCntcPntVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgCntcPntVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgCntcPntVO != null){
				Map<String, String> mapVO = scgCntcPntVO.getColumnValues();				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				if("".equals(mapVO.get("delt_flg"))) {  //if (mapVO.get("delt_flg") == "")
			    	param.put("delt_flg", "N");
			    	velParam.put("delt_flg", "N");
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgCntcPntVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgCntcPntVO.class);
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
	 * Partner's Contact Point for TDR/RDR, BAPLE 을 조회 합니다. <br>
	 * 
	 * @param scgCntcPntVO ScgCntcPntVO
	 * @return List<ScgCntcPntVO>
	 * @throws DAOException
	 */
	public List<ScgCntcPntVO> searchPartnerLineContactPointAddList(ScgCntcPntVO scgCntcPntVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgCntcPntVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgCntcPntVO != null){
				Map<String, String> mapVO = scgCntcPntVO.getColumnValues();				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				if("".equals(mapVO.get("delt_flg"))) {  //if (mapVO.get("delt_flg") == "")
			    	param.put("delt_flg", "N");
			    	velParam.put("delt_flg", "N");
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgCntcPntAddVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgCntcPntVO.class);
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
	 * RSO을 조회 합니다. <br>
	 * 
	 * @return List<ScgRgnShpOprCdVO>
	 * @throws DAOException
	 */
	public List<ScgRgnShpOprCdVO> searchSpclCgoRsoList() throws DAOException {
		
		DBRowSet 				dbRowset 	= null;
		List<ScgRgnShpOprCdVO> 	list 		= null;
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();

		try{
			
	    	param.put	("delt_flg", "N");
	    	velParam.put("delt_flg", "N");

	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgRgnShpOprCdVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgRgnShpOprCdVO.class);
			
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
	 * RSO을 조회 합니다. <br>
	 * 
	 * @param ScgRgnShpOprCdVO scgRgnShpOprCdVO
	 * @return List<ScgRgnShpOprCdVO>
	 * @throws DAOException
	 */
	public List<ScgRgnShpOprCdVO> searchSpclCgoRsoforEdiUnmapList(ScgRgnShpOprCdVO scgRgnShpOprCdVO) throws DAOException {
		
		DBRowSet 				dbRowset 	= null;
		List<ScgRgnShpOprCdVO> 	list 		= null;
		//query parameter
		Map<String, Object> 	param 		= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 	velParam 	= new HashMap<String, Object>();

		try{
			
	    	param.putAll	(scgRgnShpOprCdVO.getColumnValues());
	    	velParam.putAll	(scgRgnShpOprCdVO.getColumnValues());

	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgRgnShpOprCdforEdiUnmapRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgRgnShpOprCdVO.class);
			
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
	 * Partner's Contact Point for SPCL CGO 을 생성 합니다. <br>
	 * 
	 * @param scgCntcPntVOs List<ScgCntcPntVO>
	 * @throws DAOException
	 */
	public void addPartnerLineContactPoint(List<ScgCntcPntVO> scgCntcPntVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgCntcPntVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgCntcPntVOCSQL(), scgCntcPntVOs,null);
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
	 * Partner's Contact Point for TDR/RDR, BAPLE 을 생성 합니다. <br>
	 * 
	 * @param scgCntcPntVOs List<ScgCntcPntVO>
	 * @throws DAOException
	 */
	public void addPartnerLineContactPointAdd(List<ScgCntcPntVO> scgCntcPntVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgCntcPntVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgCntcPntAddVOCSQL(), scgCntcPntVOs,null);
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
	 * Partner's Contact Point for SPCL CGO 을 수정 합니다. <br>
	 * 
	 * @param scgCntcPntVOs List<ScgCntcPntVO>
	 * @throws DAOException
	 */
	public void modifyPartnerLineContactPoint(List<ScgCntcPntVO> scgCntcPntVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgCntcPntVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgCntcPntVOUSQL(), scgCntcPntVOs,null);
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
	 * Partner's Contact Point for TDR/RDR, BAPLE 을 수정 합니다. <br>
	 * 
	 * @param scgCntcPntVOs List<ScgCntcPntVO>
	 * @throws DAOException
	 */
	public void modifyPartnerLineContactPointAdd(List<ScgCntcPntVO> scgCntcPntVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> param = new HashMap<String, Object>();
			if(scgCntcPntVOs.size() > 0){
				ScgCntcPntVO scgCntcPntVO = new ScgCntcPntVO(); 
				for(int i=0; i<scgCntcPntVOs.size(); i++){
					scgCntcPntVO = scgCntcPntVOs.get(i);
					Map<String, String> mapVO = scgCntcPntVO.getColumnValues();
					param.putAll(mapVO);
					
					int updCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgCntcPntAddVOUSQL(), param,null);
					
					if(updCnt== Statement.EXECUTE_FAILED)
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
	 * Partner's Contact Point for SPCL CGO 을 삭제 합니다. <br>
	 * 
	 * @param scgCntcPntVOs List<ScgCntcPntVO>
	 * @throws DAOException
	 */
	public void removePartnerLineContactPoint(List<ScgCntcPntVO> scgCntcPntVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgCntcPntVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgCntcPntVODSQL(), scgCntcPntVOs,null);

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
	 * Partner's Contact Point for TDR/RDR, BAPLE을 삭제 합니다. <br>
	 * 
	 * @param scgCntcPntVOs List<ScgCntcPntVO>
	 * @throws DAOException
	 */
	public void removePartnerLineContactPointAdd(List<ScgCntcPntVO> scgCntcPntVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgCntcPntVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgCntcPntAddVODSQL(), scgCntcPntVOs,null);

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
	 * SPCL CGO Irregular Type 을 조회 합니다. 중복체크 <br>
	 * 
	 * @param searchIrregularTypeCodeListVO SearchIrregularTypeCodeListVO
	 * @return List<SearchIrregularTypeCodeListVO>
	 * @throws DAOException
	 */
	public List<SearchIrregularTypeCodeListVO> searchIrregularTypeCodeDupChk(SearchIrregularTypeCodeListVO searchIrregularTypeCodeListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchIrregularTypeCodeListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchIrregularTypeCodeListVO != null){
				Map<String, String> mapVO = searchIrregularTypeCodeListVO.getColumnValues();				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgIrrTpCdDupChkVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchIrregularTypeCodeListVO.class);
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
	 * SPCL CGO Irregular Type 을 조회 합니다. <br>
	 * 
	 * @param searchIrregularTypeCodeListVO SearchIrregularTypeCodeListVO
	 * @return List<SearchIrregularTypeCodeListVO>
	 * @throws DAOException
	 */
	public List<SearchIrregularTypeCodeListVO> searchIrregularTypeCodeList(SearchIrregularTypeCodeListVO searchIrregularTypeCodeListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchIrregularTypeCodeListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchIrregularTypeCodeListVO != null){
				Map<String, String> mapVO = searchIrregularTypeCodeListVO.getColumnValues();				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				if("".equals(mapVO.get("delt_flg"))) {  //if (mapVO.get("delt_flg") == "")
			    	param.put("delt_flg", "N");
			    	velParam.put("delt_flg", "N");
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgIrrTpCdVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchIrregularTypeCodeListVO.class);
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
	 * SPCL CGO Irregular Type 을 생성 합니다. <br>
	 * 
	 * @param searchIrregularTypeCodeListVOs List<SearchIrregularTypeCodeListVO>
	 * @throws DAOException
	 */
	public void addIrregularTypeCode(List<SearchIrregularTypeCodeListVO> searchIrregularTypeCodeListVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(searchIrregularTypeCodeListVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgIrrTpCdVOCSQL(), searchIrregularTypeCodeListVOs,null);
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
	 * SPCL CGO Irregular Type 을 수정 합니다. <br>
	 * 
	 * @param searchIrregularTypeCodeListVOs List<SearchIrregularTypeCodeListVO>
	 * @throws DAOException
	 */
	public void modifyIrregularTypeCode(List<SearchIrregularTypeCodeListVO> searchIrregularTypeCodeListVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(searchIrregularTypeCodeListVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgIrrTpCdVOUSQL(), searchIrregularTypeCodeListVOs,null);
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
	 * SPCL CGO Irregular Type 을 삭제 합니다. <br>
	 * 
	 * @param searchIrregularTypeCodeListVOs List<SearchIrregularTypeCodeListVO>
	 * @throws DAOException
	 */
	public void removeIrregularTypeCode(List<SearchIrregularTypeCodeListVO> searchIrregularTypeCodeListVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(searchIrregularTypeCodeListVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgIrrTpCdVODSQL(), searchIrregularTypeCodeListVOs,null);

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
	 * Definition of Class  을 조회 합니다. <br>
	 * 
	 * @param scgImdgClssCdVO ScgImdgClssCdVO
	 * @return List<ScgImdgClssCdVO>
	 * @throws DAOException
	 */
	public List<ScgImdgClssCdVO> searchClassDefinitionList(ScgImdgClssCdVO scgImdgClssCdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgClssCdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgImdgClssCdVO != null){
				Map<String, String> mapVO = scgImdgClssCdVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				if("".equals(mapVO.get("delt_flg"))) {  //if (mapVO.get("delt_flg") == "")
			    	param.put("delt_flg", "N");
			    	velParam.put("delt_flg", "N");
				}				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgClssCdVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgClssCdVO.class);
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
	 * Definition of Class  을 생성 합니다. <br>
	 * 
	 * @param scgImdgClssCdVOs List<ScgImdgClssCdVO>
	 * @throws DAOException
	 */
	public void addClassDefinition(List<ScgImdgClssCdVO> scgImdgClssCdVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgImdgClssCdVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgClssCdVOCSQL(), scgImdgClssCdVOs,null);
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
	 * Definition of Class  을 수정 합니다. <br>
	 * 
	 * @param scgImdgClssCdVOs List<ScgImdgClssCdVO>
	 * @throws DAOException
	 */
	public void modifyClassDefinition(List<ScgImdgClssCdVO> scgImdgClssCdVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgImdgClssCdVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgClssCdVOUSQL(), scgImdgClssCdVOs,null);
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
	 * Definition of Class  을 삭제 합니다. <br>
	 * 
	 * @param scgImdgClssCdVOs List<ScgImdgClssCdVO>
	 * @throws DAOException
	 */
	public void removeClassDefinition(List<ScgImdgClssCdVO> scgImdgClssCdVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgImdgClssCdVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgClssCdVODSQL(), scgImdgClssCdVOs,null);

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
	 * Marine Pollutant 을 조회 합니다. <br>
	 * 
	 * @param scgImdgMrnPolutVO ScgImdgMrnPolutVO
	 * @return List<ScgImdgMrnPolutVO>
	 * @throws DAOException
	 */
	public List<ScgImdgMrnPolutVO> searchMarinePollutantCodeList(ScgImdgMrnPolutVO scgImdgMrnPolutVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgMrnPolutVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgImdgMrnPolutVO != null){
				Map<String, String> mapVO = scgImdgMrnPolutVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				if("".equals(mapVO.get("delt_flg"))) {  //if (mapVO.get("delt_flg") == "")
			    	param.put("delt_flg", "N");
			    	velParam.put("delt_flg", "N");
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgMrnPolutVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgMrnPolutVO.class);
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
	 * Marine Pollutant 을 생성 합니다. <br>
	 * 
	 * @param scgImdgMrnPolutVOs List<ScgImdgMrnPolutVO>
	 * @throws DAOException
	 */
	public void addMarinePollutantCode(List<ScgImdgMrnPolutVO> scgImdgMrnPolutVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgImdgMrnPolutVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgMrnPolutVOCSQL(), scgImdgMrnPolutVOs,null);
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
	 * Marine Pollutant 을 수정 합니다. <br>
	 * 
	 * @param scgImdgMrnPolutVOs List<ScgImdgMrnPolutVO>
	 * @throws DAOException
	 */
	public void modifyMarinePollutantCode(List<ScgImdgMrnPolutVO> scgImdgMrnPolutVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgImdgMrnPolutVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgMrnPolutVOUSQL(), scgImdgMrnPolutVOs,null);
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
	 * Marine Pollutant 을 삭제 합니다. <br>
	 * 
	 * @param scgImdgMrnPolutVOs List<ScgImdgMrnPolutVO>
	 * @throws DAOException
	 */
	public void removeMarinePollutantCode(List<ScgImdgMrnPolutVO> scgImdgMrnPolutVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgImdgMrnPolutVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgMrnPolutVODSQL(), scgImdgMrnPolutVOs,null);

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
	 * Packing Group  을 조회 합니다. <br>
	 * 
	 * @param scgImdgPckGrpVO ScgImdgPckGrpVO
	 * @return List<ScgImdgPckGrpVO>
	 * @throws DAOException
	 */
	public List<ScgImdgPckGrpVO> searchPackingGroupCodeList(ScgImdgPckGrpVO scgImdgPckGrpVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgPckGrpVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgImdgPckGrpVO != null){
				Map<String, String> mapVO = scgImdgPckGrpVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgPckGrpVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgPckGrpVO.class);
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
	 * Packing Group  을 생성 합니다. <br>
	 * 
	 * @param scgImdgPckGrpVOs List<ScgImdgPckGrpVO>
	 * @throws DAOException
	 */
	public void addPackingGroupCode(List<ScgImdgPckGrpVO> scgImdgPckGrpVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgImdgPckGrpVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgPckGrpVOCSQL(), scgImdgPckGrpVOs,null);
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
	 * Packing Group  을 수정 합니다. <br>
	 * 
	 * @param scgImdgPckGrpVOs List<ScgImdgPckGrpVO>
	 * @throws DAOException
	 */
	public void modifyPackingGroupCode(List<ScgImdgPckGrpVO> scgImdgPckGrpVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgImdgPckGrpVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgPckGrpVOUSQL(), scgImdgPckGrpVOs,null);
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
	 * Packing Group  을 삭제 합니다. <br>
	 * 
	 * @param scgImdgPckGrpVOs List<ScgImdgPckGrpVO>
	 * @throws DAOException
	 */
	public void removePackingGroupCode(List<ScgImdgPckGrpVO> scgImdgPckGrpVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgImdgPckGrpVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgPckGrpVODSQL(), scgImdgPckGrpVOs,null);

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
	 * Special Provisions 을 조회 합니다. <br>
	 * 
	 * @param scgImdgSpclProviVO ScgImdgSpclProviVO
	 * @return List<ScgImdgSpclProviVO>
	 * @throws DAOException
	 */
	public List<ScgImdgSpclProviVO> searchSpecialProvisionList(ScgImdgSpclProviVO scgImdgSpclProviVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgSpclProviVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgImdgSpclProviVO != null){
				Map<String, String> mapVO = scgImdgSpclProviVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				if("".equals(mapVO.get("delt_flg"))) {  //if (mapVO.get("delt_flg") == "")
			    	param.put("delt_flg", "N");
			    	velParam.put("delt_flg", "N");
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgSpclProviVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgSpclProviVO.class);
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
	 * Special Provisions 을 생성 합니다. <br>
	 * 
	 * @param scgImdgSpclProviVOs List<ScgImdgSpclProviVO>
	 * @throws DAOException
	 */
	public void addSpecialProvision(List<ScgImdgSpclProviVO> scgImdgSpclProviVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgImdgSpclProviVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgSpclProviVOCSQL(), scgImdgSpclProviVOs,null);
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
	 * Special Provisions 을 수정 합니다. <br>
	 * 
	 * @param scgImdgSpclProviVOs List<ScgImdgSpclProviVO>
	 * @throws DAOException
	 */
	public void modifySpecialProvision(List<ScgImdgSpclProviVO> scgImdgSpclProviVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgImdgSpclProviVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgSpclProviVOUSQL(), scgImdgSpclProviVOs,null);
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
	 * Special Provisions 을 삭제 합니다. <br>
	 * 
	 * @param scgImdgSpclProviVOs List<ScgImdgSpclProviVO>
	 * @throws DAOException
	 */
	public void removeSpecialProvision(List<ScgImdgSpclProviVO> scgImdgSpclProviVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgImdgSpclProviVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgSpclProviVODSQL(), scgImdgSpclProviVOs,null);

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
	 * Packaging Code 을 조회 합니다. <br>
	 * 
	 * @param scgImdgPckCdVO ScgImdgPckCdVO
	 * @return List<ScgImdgPckCdVO>
	 * @throws DAOException
	 */
	public List<ScgImdgPckCdVO> searchPackingCodeList(ScgImdgPckCdVO scgImdgPckCdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgPckCdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgImdgPckCdVO != null){
				Map<String, String> mapVO = scgImdgPckCdVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				if("".equals(mapVO.get("delt_flg"))) {  //if (mapVO.get("delt_flg") == "")
			    	param.put("delt_flg", "N");
			    	velParam.put("delt_flg", "N");
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgPckCdVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgPckCdVO.class);
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
	 * Packaging Code 을 생성 합니다. <br>
	 * 
	 * @param scgImdgPckCdVOs List<ScgImdgPckCdVO>
	 * @throws DAOException
	 */
	public void addPackingCode(List<ScgImdgPckCdVO> scgImdgPckCdVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgImdgPckCdVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgPckCdVOCSQL(), scgImdgPckCdVOs,null);
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
	 * Packaging Code 을 수정 합니다. <br>
	 * 
	 * @param scgImdgPckCdVOs List<ScgImdgPckCdVO>
	 * @throws DAOException
	 */
	public void modifyPackingCode(List<ScgImdgPckCdVO> scgImdgPckCdVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgImdgPckCdVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgPckCdVOUSQL(), scgImdgPckCdVOs,null);
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
	 * Packaging Code 을 삭제 합니다. <br>
	 * 
	 * @param scgImdgPckCdVOs List<ScgImdgPckCdVO>
	 * @throws DAOException
	 */
	public void removePackingCode(List<ScgImdgPckCdVO> scgImdgPckCdVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgImdgPckCdVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgPckCdVODSQL(), scgImdgPckCdVOs,null);

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
	 * IMO Type Portable Tanks을 조회 합니다. <br>
	 * 
	 * @param scgImdgTnkTpVO ScgImdgTnkTpVO
	 * @return List<ScgImdgTnkTpVO>
	 * @throws DAOException
	 */
	public List<ScgImdgTnkTpVO> searchIMOTankTypeCodeList(ScgImdgTnkTpVO scgImdgTnkTpVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgTnkTpVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgImdgTnkTpVO != null){
				Map<String, String> mapVO = scgImdgTnkTpVO.getColumnValues();				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				if("".equals(mapVO.get("delt_flg"))) {  //if (mapVO.get("delt_flg") == "")
			    	param.put("delt_flg", "N");
			    	velParam.put("delt_flg", "N");
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgTnkTpVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgTnkTpVO.class);
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
	 * IMO Type Portable Tanks을 생성 합니다. <br>
	 * 
	 * @param scgImdgTnkTpVOs List<ScgImdgTnkTpVO>
	 * @throws DAOException
	 */
	public void addIMOTankTypeCode(List<ScgImdgTnkTpVO> scgImdgTnkTpVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgImdgTnkTpVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgTnkTpVOCSQL(), scgImdgTnkTpVOs,null);
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
	 * IMO Type Portable Tanks을 수정 합니다. <br>
	 * 
	 * @param  List<ScgImdgTnkTpVO> scgImdgTnkTpVOs
	 * @throws DAOException
	 */
	public void modifyIMOTankTypeCode(List<ScgImdgTnkTpVO> scgImdgTnkTpVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgImdgTnkTpVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgTnkTpVOUSQL(), scgImdgTnkTpVOs,null);
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
	 * IMO Type Portable Tanks을 삭제 합니다. <br>
	 * 
	 * @param scgImdgTnkTpVOs List<ScgImdgTnkTpVO>
	 * @throws DAOException
	 */
	public void removeIMOTankTypeCode(List<ScgImdgTnkTpVO> scgImdgTnkTpVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgImdgTnkTpVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgTnkTpVODSQL(), scgImdgTnkTpVOs,null);

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
	 * DG Abbreviation을 조회 합니다. <br>
	 * 
	 * @param scgImdgAbbrVO ScgImdgAbbrVO
	 * @return List<ScgImdgAbbrVO>
	 * @throws DAOException
	 */
	public List<ScgImdgAbbrVO> searchDGAbbreviationCodeList(ScgImdgAbbrVO scgImdgAbbrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgAbbrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgImdgAbbrVO != null){
				Map<String, String> mapVO = scgImdgAbbrVO .getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				if("".equals(mapVO.get("delt_flg"))) {  //if (mapVO.get("delt_flg") == "")
			    	param.put("delt_flg", "N");
			    	velParam.put("delt_flg", "N");
				}				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgAbbrVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgAbbrVO.class);
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
	 * DG Abbreviation을 생성 합니다. <br>
	 * 
	 * @param scgImdgAbbrVOs List<ScgImdgAbbrVO>
	 * @throws DAOException
	 */
	public void addDGAbbreviationCode(List<ScgImdgAbbrVO> scgImdgAbbrVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgImdgAbbrVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgAbbrVOCSQL(), scgImdgAbbrVOs,null);
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
	 * DG Abbreviation을 수정 합니다. <br>
	 * 
	 * @param scgImdgAbbrVOs List<ScgImdgAbbrVO>
	 * @throws DAOException
	 */
	public void modifyDGAbbreviationCode(List<ScgImdgAbbrVO> scgImdgAbbrVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgImdgAbbrVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgAbbrVOUSQL(), scgImdgAbbrVOs,null);
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
	 * DG Abbreviation을 삭제 합니다. <br>
	 * 
	 * @param scgImdgAbbrVOs List<ScgImdgAbbrVO>
	 * @throws DAOException
	 */
	public void removeDGAbbreviationCode(List<ScgImdgAbbrVO> scgImdgAbbrVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgImdgAbbrVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgAbbrVODSQL(), scgImdgAbbrVOs,null);

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
	 * No. & Symbols in SEG Table/Mixed STWG (Creation)리스트를 조회한다.<br>
	 * 
	 * @param scgImdgSegrSymVO ScgImdgSegrSymVO
	 * @return List<ScgImdgSegrSymVO>
	 * @throws DAOException
	 */
	public List<ScgImdgSegrSymVO> searchNumberNSymbolCodeList(ScgImdgSegrSymVO scgImdgSegrSymVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgSegrSymVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgImdgSegrSymVO != null){
				Map<String, String> mapVO = scgImdgSegrSymVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				if("".equals(mapVO.get("delt_flg"))) {  //if (mapVO.get("delt_flg") == "")
			    	param.put("delt_flg", "N");
			    	velParam.put("delt_flg", "N");
				}				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgSegrSymVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgSegrSymVO.class);
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
	 * No. & Symbols in SEG Table/Mixed STWG 을 생성 합니다. <br>
	 * 
	 * @param scgImdgSegrSymVOs List<ScgImdgSegrSymVO>
	 * @throws DAOException
	 */
	public void addNumberNSymbolCode(List<ScgImdgSegrSymVO> scgImdgSegrSymVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgImdgSegrSymVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgSegrSymVOCSQL(), scgImdgSegrSymVOs,null);
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
	 * No. & Symbols in SEG Table/Mixed STWG 을 수정 합니다. <br>
	 * 
	 * @param scgImdgSegrSymVOs List<ScgImdgSegrSymVO>
	 * @throws DAOException
	 */
	public void modifyNumberNSymbolCode(List<ScgImdgSegrSymVO> scgImdgSegrSymVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgImdgSegrSymVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgSegrSymVOUSQL(), scgImdgSegrSymVOs,null);
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
	 * No. & Symbols in SEG Table/Mixed STWG 을 삭제 합니다. <br>
	 * 
	 * @param scgImdgSegrSymVOs List<ScgImdgSegrSymVO>
	 * @throws DAOException
	 */
	public void removeNumberNSymbolCode(List<ScgImdgSegrSymVO> scgImdgSegrSymVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgImdgSegrSymVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgSegrSymVODSQL(), scgImdgSegrSymVOs,null);

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
	 * Compatibility Groups of Class 1 (Creation)리스트를 조회한다.<br>
	 * 
	 * @param scgImdgCompGrpVO ScgImdgCompGrpVO
	 * @return List<ScgImdgCompGrpVO>
	 * @throws DAOException
	 */
	public List<ScgImdgCompGrpVO> searchCompatibilityGroupCodeList(ScgImdgCompGrpVO scgImdgCompGrpVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgCompGrpVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgImdgCompGrpVO != null){
				Map<String, String> mapVO = scgImdgCompGrpVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				if("".equals(mapVO.get("delt_flg"))) {  //if (mapVO.get("delt_flg") == "")
			    	param.put("delt_flg", "N");
			    	velParam.put("delt_flg", "N");
				}				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgCompGrpVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgCompGrpVO.class);
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
	 * Compatibility Groups of Class 1을 생성 합니다. <br>
	 * 
	 * @param scgImdgCompGrpVOs List<ScgImdgCompGrpVO>
	 * @throws DAOException
	 */
	public void addCompatibilityGroupCode(List<ScgImdgCompGrpVO> scgImdgCompGrpVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgImdgCompGrpVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgCompGrpVOCSQL(), scgImdgCompGrpVOs,null);
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
	 * Compatibility Groups of Class 1을 수정 합니다. <br>
	 * 
	 * @param scgImdgCompGrpVOs List<ScgImdgCompGrpVO>
	 * @throws DAOException
	 */
	public void modifyCompatibilityGroupCode(List<ScgImdgCompGrpVO> scgImdgCompGrpVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgImdgCompGrpVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgCompGrpVOUSQL(), scgImdgCompGrpVOs,null);
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
	 * Compatibility Groups of Class 1을삭제 합니다. <br>
	 * 
	 * @param scgImdgCompGrpVOs List<ScgImdgCompGrpVO>
	 * @throws DAOException
	 */
	public void removeCompatibilityGroupCode(List<ScgImdgCompGrpVO> scgImdgCompGrpVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgImdgCompGrpVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgCompGrpVODSQL(), scgImdgCompGrpVOs,null);

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
	 * Excepted Quantities (Creation)리스트를 조회한다.<br>
	 * 
	 * @param scgImdgExptQtyVO ScgImdgExptQtyVO
	 * @return List<ScgImdgExptQtyVO>
	 * @throws DAOException
	 */
	public List<ScgImdgExptQtyVO> searchExceptedQuantityCodeList(ScgImdgExptQtyVO scgImdgExptQtyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgExptQtyVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgImdgExptQtyVO != null){
				Map<String, String> mapVO = scgImdgExptQtyVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgExptQtyVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgExptQtyVO.class);
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
	 * Excepted Quantities을 생성 합니다. <br>
	 * 
	 * @param scgImdgExptQtyVOs List<ScgImdgExptQtyVO>
	 * @throws DAOException
	 */
	public void addExceptedQuantityCode(List<ScgImdgExptQtyVO> scgImdgExptQtyVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgImdgExptQtyVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgExptQtyVOCSQL(), scgImdgExptQtyVOs,null);
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
	 * Excepted Quantities을 수정 합니다. <br>
	 * 
	 * @param scgImdgExptQtyVOs List<ScgImdgExptQtyVO>
	 * @throws DAOException
	 */
	public void modifyExceptedQuantityCode(List<ScgImdgExptQtyVO> scgImdgExptQtyVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgImdgExptQtyVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgExptQtyVOUSQL(), scgImdgExptQtyVOs,null);
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
	 * Excepted Quantities을 삭제 합니다. <br>
	 * 
	 * @param scgImdgExptQtyVOs List<ScgImdgExptQtyVO>
	 * @throws DAOException
	 */
	public void removeExceptedQuantityCode(List<ScgImdgExptQtyVO> scgImdgExptQtyVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgImdgExptQtyVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgExptQtyVODSQL(), scgImdgExptQtyVOs,null);
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
	 * Segregation Groups (Creation)의 (Segregation Groups)을 조회 합니다. <br>
	 * 
	 * @param scgImdgSegrGrpVO ScgImdgSegrGrpVO
	 * @return List<ScgImdgSegrGrpVO>
	 * @throws DAOException
	 */
	public List<ScgImdgSegrGrpVO> searchSegregationGroupList(ScgImdgSegrGrpVO scgImdgSegrGrpVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgSegrGrpVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgImdgSegrGrpVO != null){
				Map<String, String> mapVO = scgImdgSegrGrpVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgSegrGrpVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgSegrGrpVO.class);
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
	 * Segregation Groups (Creation)의 (Segregation Groups Detail)을 조회 합니다. <br>
	 * 
	 * @param scgImdgSegrGrpVO ScgImdgSegrGrpVO
	 * @return List<ScgImdgSegrGrpDtlVO>
	 * @throws DAOException
	 */
	public List<ScgImdgSegrGrpDtlVO> searchSegregationGroupDtlList(ScgImdgSegrGrpVO scgImdgSegrGrpVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgSegrGrpDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(scgImdgSegrGrpVO != null){
				Map<String, String> mapVO = scgImdgSegrGrpVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgSegrGrpDtlVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgSegrGrpDtlVO.class);
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
	 * Segregation Groups (Creation)의 (United Nations(UN) Number)을 조회 합니다. <br>
	 * 
	 * @param scgImdgSegrGrpDtlVO ScgImdgSegrGrpDtlVO
	 * @return List<ScgImdgSegrGrpDtlVO>
	 * @throws DAOException
	 */
	public List<ScgImdgSegrGrpDtlVO> searchScgImdgUnNo(ScgImdgSegrGrpDtlVO scgImdgSegrGrpDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgSegrGrpDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(scgImdgSegrGrpDtlVO != null){
				Map<String, String> mapVO = scgImdgSegrGrpDtlVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgUnNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgSegrGrpDtlVO.class);
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
	 * Segregation Groups (Creation)의 (Segregation Groups)을 일괄적으로 생성 합니다. <br>
	 * 
	 * @param scgImdgSegrGrpVOs List<ScgImdgSegrGrpVO>
	 * @throws DAOException
	 */
	public void addSegregationGroup(List<ScgImdgSegrGrpVO> scgImdgSegrGrpVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgImdgSegrGrpVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgSegrGrpVOCSQL(), scgImdgSegrGrpVOs,null);
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
	 * Segregation Groups (Creation)의 (Segregation Groups)을 개별 생성 합니다. <br>
	 * 
	 * @param ScgImdgSegrGrpVO scgImdgSegrGrpVO
	 * @throws DAOException
	 */
	public void addSegregationGroup(ScgImdgSegrGrpVO scgImdgSegrGrpVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String , String> paramMap = scgImdgSegrGrpVO.getColumnValues();
			Map<String, Object> velParam = new HashMap<String, Object>();

			//velocity parameter
			int result = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgSegrGrpVOCSQL(), paramMap, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to addSCGApprovalS SQL");			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * Segregation Groups (Creation)의 (Segregation Groups)을 일괄적으로 수정 합니다. <br>
	 * 
	 * @param scgImdgSegrGrpVOs List<ScgImdgSegrGrpVO>
	 * @throws DAOException
	 */
	public void modifySegregationGroup(List<ScgImdgSegrGrpVO> scgImdgSegrGrpVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgImdgSegrGrpVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgSegrGrpVOUSQL(), scgImdgSegrGrpVOs,null);
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
	 * Segregation Groups (Creation)의 (Segregation Groups)을 일괄적으로 삭제 합니다. <br>
	 * 
	 * @param scgImdgSegrGrpVOs List<ScgImdgSegrGrpVO>
	 * @throws DAOException
	 */
	public void removeSegregationGroup(List<ScgImdgSegrGrpVO> scgImdgSegrGrpVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgImdgSegrGrpVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgSegrGrpVODSQL(), scgImdgSegrGrpVOs,null);

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
	 * Segregation Groups (Creation)의 (Segregation Groups Detail)을 일괄적으로 생성 합니다. <br>
	 * 
	 * @param scgImdgSegrGrpDtlVOs List<ScgImdgSegrGrpDtlVO>
	 * @throws DAOException
	 */
	public void addSegregationGroupDtl(List<ScgImdgSegrGrpDtlVO> scgImdgSegrGrpDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgImdgSegrGrpDtlVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgSegrGrpDtlVOCSQL(), scgImdgSegrGrpDtlVOs,null);
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
	 * Segregation Groups (Creation)의 (Segregation Groups Detail)을 일괄적으로 수정 합니다. <br>
	 * 
	 * @param scgImdgSegrGrpDtlVOs List<ScgImdgSegrGrpDtlVO>
	 * @throws DAOException
	 */
	public void modifySegregationGroupDtl(List<ScgImdgSegrGrpDtlVO> scgImdgSegrGrpDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgImdgSegrGrpDtlVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgSegrGrpDtlVOUSQL(), scgImdgSegrGrpDtlVOs,null);
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
	 * Segregation Groups (Creation)의 (Segregation Groups Detail)을 일괄적으로 삭제 합니다. <br>
	 * 
	 * @param scgImdgSegrGrpDtlVOs List<ScgImdgSegrGrpDtlVO>
	 * @throws DAOException
	 */
	public void removeSegregationGroupDtl(List<ScgImdgSegrGrpDtlVO> scgImdgSegrGrpDtlVOs) throws DAOException,Exception {
		try {
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int delCnt[] = null;
			if(scgImdgSegrGrpDtlVOs.size() > 0){
				velParam.put("imdg_un_no", scgImdgSegrGrpDtlVOs.get(0).getImdgUnNo());
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgSegrGrpDtlVODSQL(), scgImdgSegrGrpDtlVOs, velParam);

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
	 * SpecialCargoMasterDataMgtDBDAO의 Loading Port for RSO 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param searchRsoComboListVO
	 * @return List<SearchLoadingPortRsoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchLoadingPortRsoVO> searchLoadingPortRSOList(SearchRsoComboListVO searchRsoComboListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLoadingPortRsoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(searchRsoComboListVO != null){
				Map<String, String> mapVO = searchRsoComboListVO .getColumnValues();
				mapVO.put("rgn_shp_opr_cd"     , mapVO.get("rso") );				
				velParam.putAll(mapVO);
				param.putAll(mapVO);
				//velParam.putAll(param);
			}
			//{rgn_shp_opr_abbr_cd=PUSCOV, rgn_shp_opr_cd=ASR, rgn_shp_opr_desc=ASIA REGION RSO}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchLoadingPortRsoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLoadingPortRsoVO .class);
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
	 * SpecialCargoMasterDataMgtDBDAO의 Loading Port for RSO 조회 콤보 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @return List<SearchRsoComboListVO>
	 * @throws DAOException
	 */
	public List<SearchRsoComboListVO> searchRsoList() throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchRsoComboListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
 			param.put("rso", "");
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchRsoComboListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchRsoComboListVO .class);
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
     * Loading Port for RSO 내용을 등록한다.
     *
     * @param  List<ScgRgnShpOprPortListVO> scgRgnShpOprPortListVO
     * @throws DAOException
     */ 
    public void addLoadingPortRso(List<ScgRgnShpOprPortListVO> scgRgnShpOprPortListVO) throws DAOException,Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int insCnt[] = null;
            if(scgRgnShpOprPortListVO.size() > 0){
                insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgRgnShpOprPortVOCSQL(), scgRgnShpOprPortListVO,null);
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
     * Loading Port for RSO 내용을 수정한다.
     *
     * @param   List<ScgRgnShpOprPortListVO> scgRgnShpOprPortListVOs
     * @throws DAOException
     */
    public void modifyLoadingPortRso(List<ScgRgnShpOprPortListVO> scgRgnShpOprPortListVOs) throws DAOException,Exception {
        try {
            SQLExecuter sqlExe = new SQLExecuter("");
            int updCnt[] = null;
            if(scgRgnShpOprPortListVOs.size() > 0){
                updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgRgnShpOprPortVOUSQL(), scgRgnShpOprPortListVOs,null);
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
     * Loading Port for RSO 내용을 삭제 .
     *
     * @param  List<ScgRgnShpOprPortListVO> scgRgnShpOprPortListVOs
     * @throws DAOException
     */
    public void removeLoadingPortRso(List<ScgRgnShpOprPortListVO> scgRgnShpOprPortListVOs) throws DAOException,Exception {
        modifyLoadingPortRso(scgRgnShpOprPortListVOs);
    }
 	/**
	 * SpecialCargoMasterDataMgtDBDAO의 loc_cd 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param pLocId
	 * @return List<GetLoadingPortRsoVO>
	 * @throws DAOException
	 */
	public List<GetLoadingPortRsoVO> searchLoadingPortRSO(String pLocId ) throws DAOException {
		DBRowSet dbRowset = null;
		List<GetLoadingPortRsoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
 
				Map<String, String> mapVO =  new HashMap<String, String>();
 
				mapVO.put("loc_cd"     , pLocId);				
				velParam.putAll(mapVO);
				param.putAll(mapVO);
				//velParam.putAll(param);
  
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOGetLoadingPortRsoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, GetLoadingPortRsoVO .class);
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
	 * SpecialCargoMasterDataMgtDBDAO의 loc_cd 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param pLocId
	 * @return List<GetLoadingPortRsoVO>
	 * @throws DAOException
	 */
	public List<GetLoadingPortRsoVO> searchLoadingPortRSODupChk(String pLocId ) throws DAOException {
		DBRowSet dbRowset = null;
		List<GetLoadingPortRsoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
  
		try{
 
				Map<String, String> mapVO =  new HashMap<String, String>();
 
				mapVO.put("loc_cd"     , pLocId);				
				velParam.putAll(mapVO);
				param.putAll(mapVO);
				//velParam.putAll(param);
  
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOGetLoadingPortRsoDupChkRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, GetLoadingPortRsoVO .class);
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
	 * SpecialCargoMasterDataMgtDBDAO의 Target Lane for SPCL CGO APVL의 값을 불러온다.<br>
	 *  
	 * @param mdmVslSvcLaneListVO
	 * @return List<MdmVslSvcLaneListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmVslSvcLaneListVO> searchApprovalTargetLaneList(MdmVslSvcLaneListVO mdmVslSvcLaneListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmVslSvcLaneListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
 
			if(mdmVslSvcLaneListVO != null){
				Map<String, String> mapVO = mdmVslSvcLaneListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOMdmVslSvcLaneListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVslSvcLaneListVO .class);
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
     * Target Lane for SPCL CGO APVL 수정한다.
	 *  
	 * @param  List<MdmVslSvcLaneListVO> mdmVslSvcLaneListVO
	 * @throws DAOException
	 */
	public void modifyApprovalTargetLane(List<MdmVslSvcLaneListVO> mdmVslSvcLaneListVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mdmVslSvcLaneListVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOMdmVslSvcLaneListVOUSQL(), mdmVslSvcLaneListVO,null);
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
	 * Packing Instructions/Provisions (Creation) 을 조회 합니다. <br>
	 * 
	 * @param imdgPckInstrCd
	 * @return List<ScgImdgPckInstrVO>
	 * @throws DAOException
	 */
	public List<ScgImdgPckInstrVO> searchPackingInstructionList(String imdgPckInstrCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgPckInstrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
				
			mapVO.put("imdg_pck_instr_cd", imdgPckInstrCd);		
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgPckInstrVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgPckInstrVO.class);
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
	 * Packing Instructions/Provisions (Creation) 을 일괄적으로 생성 합니다. <br>
	 * 
	 * @param  List<ScgImdgPckInstrVO> scgImdgPckInstrVOs
	 * @throws DAOException
	 */
	public void addPackingInstruction(List<ScgImdgPckInstrVO> scgImdgPckInstrVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgImdgPckInstrVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgPckInstrVOCSQL(), scgImdgPckInstrVOs,null);
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
	 * Packing Instructions/Provisions (Creation) 을 일괄적으로 수정 합니다. <br>
	 * 
	 * @param  List<ScgImdgPckInstrVO> scgImdgPckInstrVOs 
	 * @throws DAOException
	 */
	public void modifyPackingInstruction(List<ScgImdgPckInstrVO> scgImdgPckInstrVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgImdgPckInstrVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgPckInstrVOUSQL(), scgImdgPckInstrVOs,null);
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
	 * Packing Instructions/Provisions (Creation) 을 일괄적으로 삭제 합니다. <br>
	 * 
	 * @param    List<ScgImdgPckInstrVO> scgImdgPckInstrVOs
	 * @throws DAOException
	 */
	public void removePackingInstruction(List<ScgImdgPckInstrVO> scgImdgPckInstrVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgImdgPckInstrVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgPckInstrVODSQL(), scgImdgPckInstrVOs,null);

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
	 * SpecialCargoMasterDataMgtDBDAO의 Loading Port for RSO 조회 콤보 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param  String locCd
	 * @param  String rgnShpOprCd
	 * @return List<ScgRgnShpOprCdVO>
	 * @throws DAOException
	 */
	public List<ScgRgnShpOprCdVO> searchScgRgnShpOprCd(String locCd, String rgnShpOprCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgRgnShpOprCdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
 			param.put("loc_cd", locCd);
 			param.put("rgn_shp_opr_cd", rgnShpOprCd);
 			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgRgnShpOprCdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgRgnShpOprCdVO .class);
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
     * SpecialCargoMasterDataMgtDBDAO의 Loading Port for RSO 조회 콤보 데이타 모델에 해당되는 값을 조회합니다.<br>
     * 
     * @param  String sImdgUnNo
     * @return List<ScgImdgUnNoOrgRactVO>
     * @throws DAOException
     */
    public List<ScgImdgUnNoOrgRactVO> searchOrganicPeroxideCodeList(String sImdgUnNo) throws DAOException {
        DBRowSet dbRowset = null;
        List<ScgImdgUnNoOrgRactVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            param.put("imdg_un_no", sImdgUnNo);
            velParam.putAll( param );
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgUnNoOrgRactRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgUnNoOrgRactVO .class);
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
      * [Special Provisions for Segregation (Creation)] 정보를 [조회 ] 합니다.<br>
      * 
      * @param  String imdgSpclProviNo
      * @return List<ScgImdgSpclProvisVO>
      * @throws DAOException
      */
    public List<ScgImdgSpclProvisVO> searchSpecialProvisionSegregationList(String imdgSpclProviNo) throws DAOException {
         DBRowSet dbRowset = null;
         List<ScgImdgSpclProvisVO> list = null;
         //query parameter
         Map<String, Object> param = new HashMap<String, Object>();
         //velocity parameter
         Map<String, Object> velParam = new HashMap<String, Object>();

         try{
 
             Map<String, String> mapVO = new HashMap<String, String>();
             mapVO.put("imdg_tbl_no", imdgSpclProviNo);
             param.putAll(mapVO);
             velParam.putAll(mapVO);
 
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgSpclProvisRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgSpclProvisVO .class);
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
       * [Special Provisions for Segregation (Creation) SubsidiaryRisks ] 정보를 [조회 ] 합니다.<br>
       * 
       * @param  String sImdgUnNo
       * @param  String sImdgUnNoSeq
       * @return List<ScgImdgSpclProvisVO>
       * @throws DAOException
       */
     public List<ScgImdgSpclProvisVO> searchSubsidiaryRisks(String sImdgUnNo, String sImdgUnNoSeq) throws DAOException {
          DBRowSet dbRowset = null;
          List<ScgImdgSpclProvisVO> list = null;
          //query parameter
          Map<String, Object> param = new HashMap<String, Object>();
          //velocity parameter
          Map<String, Object> velParam = new HashMap<String, Object>();

          try{
  
              Map<String, String> mapVO = new HashMap<String, String>();
              mapVO.put("imdg_tbl_no"   , "");
              mapVO.put("imdg_un_no"    , sImdgUnNo);
              mapVO.put("imdg_un_no_seq", sImdgUnNoSeq);              
              param.putAll(mapVO);
              velParam.putAll(mapVO);
  
              dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgImdgSpclProvisRSQL(), param, velParam);
              list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgImdgSpclProvisVO .class);
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
  	 * Setup mail contents for SPCL CGO application 을 조회 합니다. <br>
  	 * 
  	 * @param scgMailTampletVO
  	 * @return List<ScgMailTampletVO>
  	 * @throws DAOException
  	 */
  	public List<ScgMailTampletVO> searchSCGMailTamplet(ScgMailTampletVO scgMailTampletVO) throws DAOException {
  		DBRowSet dbRowset = null;
  		List<ScgMailTampletVO>  list = null;
  		
  		//query parameter
  		Map<String, Object> param = new HashMap<String, Object>();
  		//velocity parameter
  		Map<String, Object> velParam = new HashMap<String, Object>();

  		try{
  			if(scgMailTampletVO != null){
  				Map<String, String> mapVO = scgMailTampletVO .getColumnValues();
  				param.putAll(mapVO);
  				velParam.putAll(mapVO);
  			}
  			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgMailTampletVORSQL(), param, velParam);
  			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgMailTampletVO .class);
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
  	 * Setup mail contents for SPCL CGO application 을 일괄적으로 생성 합니다. <br>
  	 * 
  	 * @param scgMailTampletVOs List<ScgMailTampletVO>
  	 * @throws DAOException
  	 */
  	public void addSCGMailTampletS(List<ScgMailTampletVO> scgMailTampletVOs) throws DAOException,Exception {
  		try {
  			SQLExecuter sqlExe = new SQLExecuter("");
  			int insCnt[] = null;
  			if(scgMailTampletVOs.size() > 0){
  				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgMailTampletVOCSQL(), scgMailTampletVOs, null);
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
  	 * Setup mail contents for SPCL CGO application 을 일괄적으로 수정 합니다. <br>
  	 * 
  	 * @param scgMailTampletVOs List<ScgMailTampletVO>
  	 * @throws DAOException
  	 */
  	public void modifySCGMailTampletS(List<ScgMailTampletVO> scgMailTampletVOs) throws DAOException,Exception {
  		try {
  			SQLExecuter sqlExe = new SQLExecuter("");
  			int updCnt[] = null;
  			if(scgMailTampletVOs.size() > 0){
  				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgMailTampletVOUSQL(), scgMailTampletVOs,null);
  				for(int i = 0; i < updCnt.length; i++){
  					if(updCnt[i]== Statement.EXECUTE_FAILED)
  						throw new DAOException("Fail to update No"+ i + " SQL");
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
     * Carreier Code를 체크한다. <br>
	 * 
	 * @param  String crrCd
	 * @return List<MdmCarrierVO>
	 * @throws DAOException
	 */
	public List<MdmCarrierVO> searchCarrierCode(String crrCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCarrierVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
	    	param.put("crr_cd", crrCd);
	    	velParam.put("crr_cd", crrCd);

	    	dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOsearchCarrierCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCarrierVO .class);
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
