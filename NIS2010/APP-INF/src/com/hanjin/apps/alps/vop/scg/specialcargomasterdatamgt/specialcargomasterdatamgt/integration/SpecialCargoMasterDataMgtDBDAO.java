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
* -------------------------------------------------------- 
* History
* 2012.01.17 서석진 [CHM-201115272] RSO 설정및 지역 본부 hard coding 로직 수정 요청
* 처리내역 :RHQ1,RHQ2 GRID 클릭시 콤보박스형태로 조회후 선택하여 저장,수정 할수있게 UI,로직 수정
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration;
 
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.integration.CarrierRestrictionDBDAOFileVOCSQL;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.integration.CarrierRestrictionDBDAOFileVODSQL;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.integration.CarrierRestrictionDBDAOFileVORSQL;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.carrierrestriction.vo.FileVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.basic.SpecialCargoMasterDataMgtBCImpl;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.GetLoadingPortRsoVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.MdmVslSvcLaneListVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgGuidanceFileVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgGuidanceVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgPckInstrVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgSpclProvisVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgImdgUnNoOrgRactVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgMailTampletVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgRgnShpOprPortListVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchIrregularTypeCodeListVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchLoadingPortRsoVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchRsoComboListVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.RsltCdListVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgPckCreationVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgPckReguImgVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgPckReguPkgCdVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgPckReguPkgIbcCdVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgNonDgCgoKwVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgChemicalHistoryVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgChemHistoryFileVO;
import com.hanjin.syscommon.common.table.ScgCdVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration.SpecialCargoMasterDataMgtDBDAOScgCdVOCSQL;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration.SpecialCargoMasterDataMgtDBDAOScgCdVODSQL;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration.SpecialCargoMasterDataMgtDBDAOScgCdVORSQL;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.integration.SpecialCargoMasterDataMgtDBDAOScgCdVOUSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.ScgCntcPntPolVO;
import com.hanjin.syscommon.common.table.ScgCntcPntVO;
import com.hanjin.syscommon.common.table.ScgImdgAbbrVO;
import com.hanjin.syscommon.common.table.ScgImdgClssCdVO;
import com.hanjin.syscommon.common.table.ScgImdgCompGrpVO;
import com.hanjin.syscommon.common.table.ScgImdgExptQtyVO;
import com.hanjin.syscommon.common.table.ScgImdgMrnPolutVO;
import com.hanjin.syscommon.common.table.ScgImdgPckCdVO;
import com.hanjin.syscommon.common.table.ScgImdgPckGrpVO;
import com.hanjin.syscommon.common.table.ScgImdgSegrGrpDtlVO;
import com.hanjin.syscommon.common.table.ScgImdgSegrGrpVO;
import com.hanjin.syscommon.common.table.ScgImdgSegrSymVO;
import com.hanjin.syscommon.common.table.ScgImdgSpclProviVO;
import com.hanjin.syscommon.common.table.ScgImdgTnkTpVO;
import com.hanjin.syscommon.common.table.ScgLodRjctCdVO;
import com.hanjin.syscommon.common.table.ScgRgnShpOprCdVO;
import com.hanjin.syscommon.common.table.ScgPckInstrVO;
import com.hanjin.syscommon.common.table.ScgPckGasReguVO;
import com.hanjin.syscommon.common.table.ScgPckPkgVO;
import com.hanjin.syscommon.common.table.ScgPckPtbTnkVO;
import com.hanjin.syscommon.common.table.ScgPckRefVO;
import com.hanjin.syscommon.common.table.ScgPckReguPkgOrgPrxVO;
import com.hanjin.syscommon.common.table.ScgPckReguVO;
import com.hanjin.syscommon.common.table.ScgSpclPckProviVO;


/**
 * ALPS SpecialCargoMasterDataMgtDBDAO <br>
 * - ALPS-SpecialCargoMasterDataMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
				if (mapVO.get("delt_flg").equals("")) {
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
				if (mapVO.get("delt_flg").equals("")) {
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
				if (mapVO.get("delt_flg").equals("")) {
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
	 * RSO을 조회 합니다. <br>
	 * 
	 * @return List<ScgRgnShpOprCdVO>
	 * @throws DAOException
	 */
	public List<ScgRgnShpOprCdVO> searchSpclCgoRsoList() throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgRgnShpOprCdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
	    	param.put("delt_flg", "N");
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
				if (mapVO.get("delt_flg").equals("")) {
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
				if (mapVO.get("delt_flg").equals("")) {
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
				if (mapVO.get("delt_flg").equals("")) {
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
				if (mapVO.get("delt_flg").equals("")) {
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
				if (mapVO.get("delt_flg").equals("")) {
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
				if (mapVO.get("delt_flg").equals("")) {
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
				if (mapVO.get("delt_flg").equals("")) {
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
				if (mapVO.get("delt_flg").equals("")) {
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
				if (mapVO.get("delt_flg").equals("")) {
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
	 * @return List<ScgImdgSegrGrpVO>
	 * @throws DAOException
	 */
	public List<ScgImdgSegrGrpVO> searchSegregationGroupList() throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgSegrGrpVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
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
	 * @param String imdgPckInstrCd
	 * @param String imdgPckInstrSeq
	 * @return List<ScgImdgPckInstrVO>
	 * @throws DAOException
	 */
	public List<ScgImdgPckInstrVO> searchPackingInstructionList(String imdgPckInstrCd, String imdgPckInstrSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgImdgPckInstrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
				
			mapVO.put("imdg_pck_instr_cd", imdgPckInstrCd);	
			mapVO.put("imdg_pck_instr_seq", imdgPckInstrSeq);	
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
	 * SPCL CGO RSO - CREATION 에서 RgnShpOprRhqCode 를 구한다. <br>
	 * 
	 * @return List<String>
	 * @exception DAOException
	 */
	public List<String> searchRHQOfficeList() throws DAOException {
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		try{
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new SpecialCargoMasterDataMgtDBDAORgnShpOprRhqCodeRSQL(), param, velParam);
			while(dbRowset.next()){
				list.add(dbRowset.getString(1));
			}
			return list;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
      

    /**
	 * VOP_SCG_0080  : Retrieve <br>
	 * Special Cargo Guidance 화면의 최 상단 내용을 조회 합니다. <br>
     * 
     * @param  scgGuidanceVO
     * @return List<ScgGuidanceVO>
     * @throws DAOException
     */
   public List<ScgGuidanceVO> searchScgGuidMsg(ScgGuidanceVO scgGuidanceVO) throws DAOException {
	   DBRowSet dbRowset = null;
 		List<ScgGuidanceVO>  list = null;
 		
 		//query parameter
 		Map<String, Object> param = new HashMap<String, Object>();
 		//velocity parameter
 		Map<String, Object> velParam = new HashMap<String, Object>();

 		try{
 			if(scgGuidanceVO != null){
 				Map<String, String> mapVO = scgGuidanceVO .getColumnValues();
 				param.putAll(mapVO);
 				velParam.putAll(mapVO);
 			}
 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchScgGuidMsgRSQL(), param, velParam);
 			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgGuidanceVO .class);
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
	 * VOP_SCG_0080  : Retrieve <br>
	 * Special Cargo Guidance 화면의 최 상단 내용을 등록 합니다. <br>
 	 * 
 	 * @param scgGuidanceVOs List<ScgGuidanceVO>
 	 * @throws DAOException
 	 */
 	public void addScgGuidMsg(List<ScgGuidanceVO> scgGuidanceVOs) throws DAOException,Exception {
 		try {
 			SQLExecuter sqlExe = new SQLExecuter("");
 			int updCnt[] = null;
 			if(scgGuidanceVOs.size() > 0){
 				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOAddScgGuidMsgCSQL(), scgGuidanceVOs,null);
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
	 * VOP_SCG_0080  : Retrieve <br>
	 * Special Cargo Guidance 화면의 최 상단 내용을 수정 합니다. <br>
 	 * 
 	 * @param scgGuidanceVOs List<ScgGuidanceVO>
 	 * @throws DAOException
 	 */
 	public void modifyScgGuidMsg(List<ScgGuidanceVO> scgGuidanceVOs) throws DAOException,Exception {
 		try {
 			SQLExecuter sqlExe = new SQLExecuter("");
 			int updCnt[] = null;
 			if(scgGuidanceVOs.size() > 0){
 				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOModifyScgGuidMsgUSQL(), scgGuidanceVOs,null);
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
	 * VOP_SCG_0080  : Retrieve <br>
	 * Special Cargo Guidance 화면의 중앙 상세 화면정보를 등록 합니다. <br>
 	 * 
 	 * @param scgGuidanceVOs List<ScgGuidanceVO>
 	 * @throws DAOException
 	 */
 	public void addScgGuidDtl(List<ScgGuidanceVO> scgGuidanceVOs) throws DAOException,Exception {
 		try {
 			SQLExecuter sqlExe = new SQLExecuter("");
 			int updCnt[] = null;
 			if(scgGuidanceVOs.size() > 0){
 				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOAddScgGuidDtlCSQL(), scgGuidanceVOs,null);
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
	 * VOP_SCG_0080  : Retrieve <br>
	 * Special Cargo Guidance 화면의 중앙 상세 화면정보를 수정 합니다. <br>
 	 * 
 	 * @param scgGuidanceVOs List<ScgGuidanceVO>
 	 * @throws DAOException
 	 */
 	public void modifyScgGuidDtl(List<ScgGuidanceVO> scgGuidanceVOs) throws DAOException,Exception {
 		try {
 			SQLExecuter sqlExe = new SQLExecuter("");
 			int updCnt[] = null;
 			if(scgGuidanceVOs.size() > 0){
 				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOModifyScgGuidDtlUSQL(), scgGuidanceVOs,null);
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
	 * VOP_SCG_0080  : Retrieve <br>
	 * Special Cargo Guidance 화면의 중앙 상세 화면정보를 삭제 합니다. <br>
 	 * 
 	 * @param scgGuidanceVOs List<ScgGuidanceVO>
 	 * @throws DAOException
 	 */
 	public void removeScgGuidDtl(List<ScgGuidanceVO> scgGuidanceVOs) throws DAOException,Exception {
 		try {
 			SQLExecuter sqlExe = new SQLExecuter("");
 			int updCnt[] = null;
 			if(scgGuidanceVOs.size() > 0){
 				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAORemoveScgGuidDtlDSQL(), scgGuidanceVOs,null);
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
	 * VOP_SCG_0080  : Retrieve <br>
	 * Special Cargo Guidance 화면 SCG_GUID_DTL 테이블에 Insert 할 Max ( SPCL_CGO_GUID_SEQ ) 를 채번 한다. <br>
     * 
     * @return String scgSpclCgoGuidSeq
     * @throws DAOException
     */
   public String searchScgGuidMaxSeq() throws DAOException {
	   DBRowSet dbRowset = null;
 		String scgSpclCgoGuidSeq =null;
 		
 		//query parameter
 		Map<String, Object> param = new HashMap<String, Object>();
 		//velocity parameter
 		Map<String, Object> velParam = new HashMap<String, Object>();

 		try{

 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchScgGuidMaxSeqRSQL(), param, velParam);
 			if (dbRowset.next()) {
 				scgSpclCgoGuidSeq = dbRowset.getString("SCG_SPCL_CGO_GUID_SEQ");
			}
 		}catch(SQLException se){
 			log.error(se.getMessage(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		}catch(Exception ex){
 			log.error(ex.getMessage(),ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage());
 		}
 		return scgSpclCgoGuidSeq;
 	}
   

   /**
	 * VOP_SCG_0080  : Retrieve <br>
	 * Special Cargo Guidance 화면의 중앙 상세 화면정보를 조회 합니다. <br>
    * 
    * @param  scgGuidanceVO
    * @return List<ScgGuidanceVO>
    * @throws DAOException
    */
  public List<ScgGuidanceVO> searchScgGuidDtl(ScgGuidanceVO scgGuidanceVO) throws DAOException {
	   DBRowSet dbRowset = null;
		List<ScgGuidanceVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgGuidanceVO != null){
				Map<String, String> mapVO = scgGuidanceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchScgGuidDtlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgGuidanceVO .class);
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
   * VOP_SCG_0080  : Retrieve <br>
	 * Special Cargo Guidance 화면의 첨부파일 정보를 조회 합니다. <br>
   * 
   * @param  scgGuidanceVO
   * @return List<ScgGuidanceVO>
   * @throws DAOException
   */
 public List<ScgGuidanceVO> searchScgGuidDtlFile(ScgGuidanceVO scgGuidanceVO) throws DAOException {
	   DBRowSet dbRowset = null;
		List<ScgGuidanceVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgGuidanceVO != null){
				Map<String, String> mapVO = scgGuidanceVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchScgGuidDtlFileRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgGuidanceVO .class);
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
	 * VOP_SCG_0080  : file save <br>
	 * Special Cargo Guidance 화면의 중앙 첨부파일 정보를 등록 합니다. <br>
	 * 
	 * @param scgGuidanceFileVOs List<ScgGuidanceFileVO>
	 * @throws DAOException
	 */
	public void addScgGuidDtlFile(List<ScgGuidanceFileVO> scgGuidanceFileVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgGuidanceFileVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOAddScgGuidDtlFileCSQL(), scgGuidanceFileVOs,null);
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
	 * VOP_SCG_0080  : file save <br>
	 * Special Cargo Guidance 화면의 중앙 첨부파일 정보를 수정 합니다. <br>
	 * 
	 * @param scgGuidanceFileVOs List<ScgGuidanceFileVO>
	 * @throws DAOException
	 */
	public void modifyScgGuidDtlFile(List<ScgGuidanceFileVO> scgGuidanceFileVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgGuidanceFileVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOModifyScgGuidDtlFileUSQL(), scgGuidanceFileVOs,null);
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
	 * VOP_SCG_0080  : file save <br>
	 * Special Cargo Guidance 화면의 중앙 첨부파일 정보를 삭제 합니다. <br>
	 * 
	 * @param scgGuidanceFileVOs List<ScgGuidanceFileVO>
	 * @throws DAOException
	 */
	public void removeScgGuidDtlFile(List<ScgGuidanceFileVO> scgGuidanceFileVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgGuidanceFileVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAORemoveScgGuidDtlFileDSQL(), scgGuidanceFileVOs,null);
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
	 * Special Provisions 을 조회 합니다. <br>
	 * 
	 * @param ScgPckReguPkgOrgPrxVO scgPckReguPkgOrgPrxVO
	 * @return List<ScgPckReguPkgOrgPrxVO>
	 * @throws DAOException
	 */
	public List<ScgPckReguPkgOrgPrxVO> searchPackingInstructionRegulationOrganicPeroxideList(ScgPckReguPkgOrgPrxVO scgPckReguPkgOrgPrxVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgPckReguPkgOrgPrxVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgPckReguPkgOrgPrxVO != null){
				Map<String, String> mapVO = scgPckReguPkgOrgPrxVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgPckReguPkgOrgPrxVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgPckReguPkgOrgPrxVO.class);
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
	 * 중복이 있는지 확인을 합니다(SCG_PCK_REGU_ORG_PRX)<br>
	 * 
	 * @param ScgPckReguPkgOrgPrxVO scgPckReguPkgOrgPrxVO
	 * @return int
	 * @exception DAOException
	 * @exception Exception
	 */
	public int searchIbcCodeDuplicateCheck(ScgPckReguPkgOrgPrxVO scgPckReguPkgOrgPrxVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		int result = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgPckReguPkgOrgPrxVO != null){
				Map<String, String> mapVO = scgPckReguPkgOrgPrxVO.getColumnValues();				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchIbcCodeDuplicateCheckRSQL(), param, velParam);
			if (dbRowset.next()){
			    result = dbRowset.getInt("result");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * IBC Code for Organic peroxide  을 생성 합니다. <br>
	 * 
	 * @param List<ScgPckReguPkgOrgPrxVO> scgPckReguPkgOrgPrxVOs
	 * @throws DAOException
	 */
	public void addIbcCode(List<ScgPckReguPkgOrgPrxVO> scgPckReguPkgOrgPrxVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgPckReguPkgOrgPrxVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgPckReguPkgOrgPrxVOCSQL(), scgPckReguPkgOrgPrxVOs,null);
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
	 * IBC Code for Organic peroxide  을 수정 합니다. <br>
	 * 
	 * @param List<ScgPckReguPkgOrgPrxVO> scgPckReguPkgOrgPrxVOs
	 * @throws DAOException
	 */
	public void modifyIbcCode(List<ScgPckReguPkgOrgPrxVO> scgPckReguPkgOrgPrxVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgPckReguPkgOrgPrxVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgPckReguPkgOrgPrxVOUSQL(), scgPckReguPkgOrgPrxVOs,null);
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
	 * IBC Code for Organic peroxide  을 삭제 합니다. <br>
	 * 
	 * @param List<ScgPckReguPkgOrgPrxVO> scgPckReguPkgOrgPrxVOs
	 * @throws DAOException
	 */
	public void removeIbcCode(List<ScgPckReguPkgOrgPrxVO> scgPckReguPkgOrgPrxVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgPckReguPkgOrgPrxVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgPckReguPkgOrgPrxVODSQL(), scgPckReguPkgOrgPrxVOs,null);

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
	 * VOP_SCG_0108 : Retrieve <br>
	 * Image File Registration
	 * 
	 * @param String pkgCd
	 * @param String pkgCdSeq
	 * @param String dispNo
	 * @return List<ScgPckReguImgVO>
	 * @exception DAOException
	 * @exception Exception
	 */
	public List<ScgPckReguImgVO> searchPackingInstructionRegulationImgList(String pkgCd, String pkgCdSeq, String dispNo) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<ScgPckReguImgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		param.put("pck_cd", pkgCd);
    	velParam.put("pck_cd", pkgCd);

    	param.put("pck_cd_seq", pkgCdSeq);
    	velParam.put("pck_cd_seq", pkgCdSeq);
    	
	    param.put("disp_no", dispNo);
    	velParam.put("disp_no", dispNo);
    	
		try{
			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionRegulationImgListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgPckReguImgVO.class);
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
	 * VOP_SCG_0108 : Create <br>
	 * Image File Registration
	 * 
	 * @param List<ScgPckReguImgVO> scgPckReguImgVOs
	 * @throws DAOException
	 */
	public void addPackingInstructionRegulationImgList(List<ScgPckReguImgVO> scgPckReguImgVOs) throws DAOException {
		try {
		
			
			SQLExecuter sqlExe = new SQLExecuter("");
			//SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			
			log.info("\n scgPckReguImgVOs.size()" + scgPckReguImgVOs.size());
			
			log.info(scgPckReguImgVOs.get(0));
			//for ( int i=0; i<scgPckReguImgVOs.size(); i++ ) {
			//	log.info("scgPckReguImgVO" + scgPckReguImgVO[i]);
			//}
			if(scgPckReguImgVOs.size() > 0){				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOAddPackingInstructionRegulationImgListCSQL(), scgPckReguImgVOs, null);
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
	 * VOP_SCG_0108 : Update <br>
	 * Image File Registration
	 * 
	 * @param List<ScgPckReguImgVO> scgPckReguImgVOs
	 * @throws DAOException
	 */
	public void modifyPackingInstructionRegulationImgList(List<ScgPckReguImgVO> scgPckReguImgVOs) throws DAOException {
		try {
		
			
			SQLExecuter sqlExe = new SQLExecuter("");
			//SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;

			log.debug("\n scgPckReguImgVOs.get(0).getPckCd()" + scgPckReguImgVOs.get(0).getImdgPckInstrCd());
			log.debug("\n scgPckReguImgVOs.get(0).getDispNo()" + scgPckReguImgVOs.get(0).getReguDpNo());
			log.debug("\n scgPckReguImgVOs.get(0).getDeltFlg()" + scgPckReguImgVOs.get(0).getDeltFlg());
			log.debug("\n scgPckReguImgVOs.get(0).getPckCdSeq()" + scgPckReguImgVOs.get(0).getImdgPckInstrSeq());
			log.debug("\n scgPckReguImgVOs.get(0).getSeq()" + scgPckReguImgVOs.get(0).getSubSeq());
			log.debug("\n scgPckReguImgVOs.get(0).getFileNm()" + scgPckReguImgVOs.get(0).getFileNm());
			
			if(scgPckReguImgVOs.size() > 0){		
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOModifyPackingInstructionRegulationImgListUSQL(), scgPckReguImgVOs,null);
				
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * VOP_SCG_0105 : Retrieve <br>
	 * Proper IBC code
	 * 
	 * @param String pkgCd
	 * @param String pkgCdSeq
	 * @param String dispNo
	 * @return List<ScgPckReguPkgIbcCdVO>
	 * @exception EventException
	 */
	public List<ScgPckReguPkgIbcCdVO> searchPackingInstructionRegulationPackagingIbcCodeList(String pkgCd, String pkgCdSeq, String dispNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgPckReguPkgIbcCdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
 			param.put("pck_cd", pkgCd);
 			param.put("pck_cd_seq", pkgCdSeq);
 			param.put("disp_no", dispNo);
 			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionRegulationPackagingIbcCodeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgPckReguPkgIbcCdVO .class);
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
	 * VOP_SCG_0105 : Create <br>
	 * Proper IBC code
	 * 
	 * @param List<ScgPckReguPkgIbcCdVO> insertVoList
	 * @throws DAOException
	 */
	public void addPackingInstructionRegulationPackagingIbcCode(List<ScgPckReguPkgIbcCdVO> insertVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(insertVoList.size() > 0){				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOAddPackingInstructionRegulationPackagingIbcCodeListCSQL(), insertVoList, null);
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
	 * VOP_SCG_0107 : Create <br>
	 * Packing Instruction
	 * 
	 * @param List<ScgPckCreationVO> insertVoList
	 * @throws DAOException
	 */
	public void addPackingInstructionRegulationPKGMethodList(List<ScgPckCreationVO> insertVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(insertVoList.size() > 0){				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOAddPackingInstructionRegulationPKGMethodListCSQL(), insertVoList, null);
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
	 * VOP_SCG_0107 : Create <br>
	 * Packing Instruction Ref
	 * 
	 * @param List<ScgPckCreationVO> insertVoList
	 * @throws DAOException
	 */
	public void addPackingInstructionRegulationPKGMethodRefList(List<ScgPckCreationVO> insertVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(insertVoList.size() > 0){				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOAddPackingInstructionRegulationPKGMethodListCSQL(), insertVoList, null);
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
	 * VOP_SCG_0107 : Update <br>
	 * Packing Instruction Update
	 * 
	 * @param List<ScgPckCreationVO> updateVoList
	 * @throws DAOException
	 */
	public void modifyPackingInstructionRegulationPKGMethodList(List<ScgPckCreationVO> updateVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOModifyPackingInstructionRegulationPKGMethodListUSQL(), updateVoList,null);
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
	 * VOP_SCG_0107 : Update <br>
	 * Packing Instruction Ref Update
	 * 
	 * @param List<ScgPckCreationVO> updateVoList
	 * @throws DAOException
	 */
	public void modifyPackingInstructionRegulationPKGMethodRefList(List<ScgPckCreationVO> updateVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOModifyPackingInstructionRegulationPKGMethodRefListUSQL(), updateVoList,null);
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
	 * VOP_SCG_0105 : Update <br>
	 * Proper IBC code
	 * 
	 * @param List<ScgPckReguPkgIbcCdVO> updateVoList
	 * @throws DAOException
	 */
	public void modifyPackingInstructionRegulationPackagingIbcCode(List<ScgPckReguPkgIbcCdVO> updateVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOModifyPackingInstructionRegulationPackagingIbcCodeListUSQL(), updateVoList,null);
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
	 * VOP_SCG_0105 : OPEN <br>
	 * Proper IBC code
	 * 
	 * @param RsltCdListVO rsltCdListVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchComCodeDescList(RsltCdListVO rsltCdListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rsltCdListVO != null){
				Map<String, String> mapVO = rsltCdListVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchComCodeDescListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}


	
	/**
	 * VOP_SCG_0103 <br>
	 * Proper IBC code
	 * 
	 * @param String pckTpCd
	 * @param String pckMtrlTpCd
	 * @param String pckStyCd
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchPkgMtrlTpCdComboData(String pckTpCd, String pckMtrlTpCd, String pckStyCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(pckTpCd != null && pckMtrlTpCd != null){
			
				param.put("pck_tp_cd", pckTpCd);
				param.put("pck_mtrl_tp_cd", pckMtrlTpCd);
				param.put("pck_sty_cd", pckStyCd);
				velParam.put("pck_tp_cd", pckTpCd);
				velParam.put("pck_mtrl_tp_cd", pckMtrlTpCd);
				velParam.put("pck_sty_cd", pckStyCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchPkgMtrlTpCdComboDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * VOP_SCG_0105 : IBC CODE ONCHANGE <br>
	 * 
	 * @param ScgPckReguPkgIbcCdVO scgPckReguPkgIbcCdVO
	 * @return List<ScgPckReguPkgIbcCdVO>
	 * @exception EventException
	 */
	public List<ScgPckReguPkgIbcCdVO> searchPackingIbcCodeList(ScgPckReguPkgIbcCdVO scgPckReguPkgIbcCdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgPckReguPkgIbcCdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(scgPckReguPkgIbcCdVO != null){
				Map<String, String> mapVO = scgPckReguPkgIbcCdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchPackingIbcCodeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgPckReguPkgIbcCdVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

/**
	 * VOP_SCG_0107 : Retrieve <br>
	 * PackingInstruction Creation
	 * 
	 * @param ScgPckCreationVO scgPckCreationVO
	 * @return List<ScgPckCreationVO>
	 * @exception EventException
	 */
	public List<ScgPckCreationVO> searchPackingInstructionRegulationPKGMethodList(ScgPckCreationVO scgPckCreationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgPckCreationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgPckCreationVO != null){
				Map<String, String> mapVO = scgPckCreationVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionPKGMethodListRSQLRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgPckCreationVO .class);
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
	 * VOP_SCG_0107 : Retrieve <br>
	 * PackingInstruction Creation
	 * 
	 * @param ScgPckCreationVO scgPckCreationVO
	 * @return List<ScgPckCreationVO>
	 * @exception EventException
	 */
	public List<ScgPckCreationVO> searchPackingInstructionPKGMethodRefList(ScgPckCreationVO scgPckCreationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgPckCreationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgPckCreationVO != null){
				Map<String, String> mapVO = scgPckCreationVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionPKGMethodRefListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgPckCreationVO .class);
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
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckReguVO scgPckReguVO
	 * @return List<ScgPckReguVO>
	 * @exception EventException
	 */
	public List<ScgPckReguVO> searchPackingInstructionRegulation(ScgPckReguVO scgPckReguVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgPckReguVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgPckReguVO != null){
				Map<String, String> mapVO = scgPckReguVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
 			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionRegulationRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgPckReguVO .class);
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
	 * VOP_SCG_0103 : Create <br>
	 * Pack.Instruct.Code
	 * 
	 * @param List<ScgPckReguVO> insertVoList
	 * @throws DAOException
	 */
	public void addPackingInstructionRegulation(List<ScgPckReguVO> insertVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(insertVoList.size() > 0){				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOAddPackingInstructionRegulationCSQL(), insertVoList, null);
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
	 * VOP_SCG_0103 : Update <br>
	 * Pack.Instruct.Code
	 * 
	 * @param List<ScgPckReguVO> updateVoList
	 * @throws DAOException
	 */
	public void modifyPackingInstructionRegulation(List<ScgPckReguVO> updateVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOModifyPackingInstructionRegulationUSQL(), updateVoList,null);
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
	 * VOP_SCG_0103 : Update <br>
	 * Pack.Instruct.Code
	 * 
	 * @param List<ScgPckReguVO> updateVoList
	 * @throws DAOException
	 */
	public void removePackingInstructionRegulation(List<ScgPckReguVO> updateVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAORemovePackingInstructionRegulationDSQL(), updateVoList,null);
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
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckPkgVO scgPckPkgVO
	 * @param String pckStyCd
	 * @return List<ScgPckPkgVO>
	 * @exception EventException
	 */
	public List<ScgPckPkgVO> searchPackingInstructionPackaging(ScgPckPkgVO scgPckPkgVO, String pckStyCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgPckPkgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgPckPkgVO != null){
				Map<String, String> mapVO = scgPckPkgVO .getColumnValues();
			
				param.putAll(mapVO);
				param.put("pck_sty_cd", pckStyCd);
				velParam.putAll(mapVO);
				velParam.put("pck_sty_cd", pckStyCd);
			}
 			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionPackagingRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgPckPkgVO .class);
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
	 * VOP_SCG_0103 : Create <br>
	 * Pack.Instruct.Code
	 * 
	 * @param List<ScgPckPkgVO> insertVoList
	 * @throws DAOException
	 */
	public void addPackingInstructionPackaging(List<ScgPckPkgVO> insertVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(insertVoList.size() > 0){				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOAddPackingInstructionPackagingCSQL(), insertVoList, null);
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
	 * VOP_SCG_0103 : Update <br>
	 * Pack.Instruct.Code
	 * 
	 * @param List<ScgPckPkgVO> updateVoList
	 * @throws DAOException
	 */
	public void modifyPackingInstructionPackaging(List<ScgPckPkgVO> updateVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOModifyPackingInstructionPackagingUSQL(), updateVoList,null);
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
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckRefVO scgPckRefVO
	 * @param String pckStyCd
	 * @return List<ScgPckRefVO>
	 * @exception EventException
	 */
	public List<ScgPckRefVO> searchPackingInstructionPackagingReference(ScgPckRefVO scgPckRefVO, String pckStyCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgPckRefVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgPckRefVO != null){
				Map<String, String> mapVO = scgPckRefVO .getColumnValues();
			
				param.putAll(mapVO);
				param.put("pck_sty_cd", pckStyCd);
				velParam.putAll(mapVO);
				velParam.put("pck_sty_cd", pckStyCd);
			}
 			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionPackagingReferenceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgPckRefVO .class);
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
	 * VOP_SCG_0103 : Create <br>
	 * Pack.Instruct.Code
	 * 
	 * @param List<ScgPckRefVO> insertVoList
	 * @throws DAOException
	 */
	public void addPackingInstructionReference(List<ScgPckRefVO> insertVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(insertVoList.size() > 0){				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOAddPackingInstructionReferenceCSQL(), insertVoList, null);
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
	 * VOP_SCG_0103 : Update <br>
	 * Pack.Instruct.Code
	 * 
	 * @param List<ScgPckRefVO> updateVoList
	 * @throws DAOException
	 */
	public void modifyPackingInstructionReference(List<ScgPckRefVO> updateVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOModifyPackingInstructionReferenceUSQL(), updateVoList,null);
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
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgSpclPckProviVO scgSpclPckProviVO
	 * @return List<ScgSpclPckProviVO>
	 * @exception EventException
	 */
	public List<ScgSpclPckProviVO> searchPackingInstructionSpclProvi(ScgSpclPckProviVO scgSpclPckProviVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgSpclPckProviVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgSpclPckProviVO != null){
				Map<String, String> mapVO = scgSpclPckProviVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
 			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionSpclProviRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgSpclPckProviVO .class);
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
	 * VOP_SCG_0103 : Create <br>
	 * Pack.Instruct.Code
	 * 
	 * @param List<ScgSpclPckProviVO> insertVoList
	 * @throws DAOException
	 */
	public void addPackingInstructionSpclProvi(List<ScgSpclPckProviVO> insertVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(insertVoList.size() > 0){				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOAddPackingInstructionSpclProviCSQL(), insertVoList, null);
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
	 * VOP_SCG_0103 : Update <br>
	 * Pack.Instruct.Code
	 * 
	 * @param List<ScgSpclPckProviVO> updateVoList
	 * @throws DAOException
	 */
	public void modifyPackingInstructionSpclProvi(List<ScgSpclPckProviVO> updateVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOModifyPackingInstructionSpclProviUSQL(), updateVoList,null);
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
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckGasReguVO scgPckGasReguVO
	 * @return List<ScgPckGasReguVO>
	 * @exception EventException
	 */
	public List<ScgPckGasReguVO> searchPackingInstructionGasRegulation(ScgPckGasReguVO scgPckGasReguVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgPckGasReguVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgPckGasReguVO != null){
				Map<String, String> mapVO = scgPckGasReguVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
 			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionGasRegulationRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgPckGasReguVO .class);
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
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckRefVO scgPckRefVO
	 * @return List<ScgPckRefVO>
	 * @exception EventException
	 */
	public List<ScgPckRefVO> searchPackingInstructionGasRegulationReference(ScgPckRefVO scgPckRefVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgPckRefVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgPckRefVO != null){
				Map<String, String> mapVO = scgPckRefVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
 			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionGasRegulationReferenceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgPckRefVO .class);
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
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckRefVO scgPckRefVO
	 * @return List<ScgPckRefVO>
	 * @exception EventException
	 */
	public List<ScgPckRefVO> searchPackingInstructionGasSpclProviReference(ScgPckRefVO scgPckRefVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgPckRefVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgPckRefVO != null){
				Map<String, String> mapVO = scgPckRefVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
 			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionGasSpclProviReferenceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgPckRefVO .class);
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
	 * VOP_SCG_0103 : Create <br>
	 * Pack.Instruct.Code
	 * 
	 * @param List<ScgPckGasReguVO> insertVoList
	 * @throws DAOException
	 */
	public void addPackingInstructionGasRegulation(List<ScgPckGasReguVO> insertVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(insertVoList.size() > 0){				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOAddPackingInstructionGasRegulationCSQL(), insertVoList, null);
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
	 * VOP_SCG_0103 : Update <br>
	 * Pack.Instruct.Code
	 * 
	 * @param List<ScgPckGasReguVO> updateVoList
	 * @throws DAOException
	 */
	public void modifyPackingInstructionGasRegulation(List<ScgPckGasReguVO> updateVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOModifyPackingInstructionGasRegulationUSQL(), updateVoList,null);
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
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckPtbTnkVO scgPckPtbTnkVO
	 * @param String ptbTnkInstrCd
	 * @return List<ScgPckPtbTnkVO>
	 * @exception EventException
	 */
	public List<ScgPckPtbTnkVO> searchPackingInstructionPortableTank(ScgPckPtbTnkVO scgPckPtbTnkVO, String ptbTnkInstrCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgPckPtbTnkVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgPckPtbTnkVO != null){
				Map<String, String> mapVO = scgPckPtbTnkVO .getColumnValues();
			
				param.putAll(mapVO);
				param.put("ptb_tnk_instr_cd", ptbTnkInstrCd);
				velParam.putAll(mapVO);
				velParam.put("ptb_tnk_instr_cd", ptbTnkInstrCd);
			}
 			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionPortableTankRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgPckPtbTnkVO .class);
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
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckRefVO scgPckRefVO
	 * @return List<ScgPckRefVO>
	 * @exception EventException
	 */
	public List<ScgPckRefVO> searchPackingInstructionPortableTankReference(ScgPckRefVO scgPckRefVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgPckRefVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgPckRefVO != null){
				Map<String, String> mapVO = scgPckRefVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
 			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionPortableTankReferenceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgPckRefVO .class);
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
	 * VOP_SCG_0103 : Create <br>
	 * Pack.Instruct.Code
	 * 
	 * @param List<ScgPckPtbTnkVO> insertVoList
	 * @throws DAOException
	 */
	public void addPackingInstructionPortableTank(List<ScgPckPtbTnkVO> insertVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(insertVoList.size() > 0){				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOAddPackingInstructionPortableTankCSQL(), insertVoList, null);
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
	 * VOP_SCG_0103 : Update <br>
	 * Pack.Instruct.Code
	 * 
	 * @param List<ScgPckPtbTnkVO> updateVoList
	 * @throws DAOException
	 */
	public void modifyPackingInstructionPortableTank(List<ScgPckPtbTnkVO> updateVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOModifyPackingInstructionPortableTankUSQL(), updateVoList,null);
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
	 * VOP_SCG_0103 : Retrieve <br>
	 * Pack.Instruct.Code
	 * 
	 * @param ScgPckInstrVO scgPckInstrVO
	 * @return List<ScgPckInstrVO>
	 * @exception EventException
	 */
	public List<ScgPckInstrVO> searchPackingInstructionCode(ScgPckInstrVO scgPckInstrVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgPckInstrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgPckInstrVO != null){
				Map<String, String> mapVO = scgPckInstrVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
 			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgPckInstrVO .class);
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
	 * VOP_SCG_0103 : Create <br>
	 * Pack.Instruct.Code
	 * 
	 * @param List<ScgPckInstrVO> insertVoList
	 * @throws DAOException
	 */
	public void addPackingInstructionCode(List<ScgPckInstrVO> insertVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(insertVoList.size() > 0){				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOAddPackingInstructionCodeCSQL(), insertVoList, null);
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
	 * VOP_SCG_0103 : Update <br>
	 * Pack.Instruct.Code
	 * 
	 * @param List<ScgPckInstrVO> updateVoList
	 * @throws DAOException
	 */
	public void modifyPackingInstructionCode(List<ScgPckInstrVO> updateVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOModifyPackingInstructionCodeUSQL(), updateVoList,null);
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
	 * VOP_SCG_0103 : Update <br>
	 * Pack.Instruct.Code
	 * 
	 * @param String pkgCd
	 * @param String pkgCdSeq
	 * @param String dispNo
	 * @param String updUsrId
	 * @throws DAOException
	 */
	public void modifyPackingInstructionRegulationFlg(String pkgCd, String pkgCdSeq, String dispNo, String updUsrId) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = 0;
			if(pkgCd != null && pkgCdSeq != null && dispNo != null){
				Map<String, Object> param = new HashMap<String, Object>();

	 			param.put("pck_cd", pkgCd);
	 			param.put("pck_cd_seq", pkgCdSeq);
	 			param.put("disp_no", dispNo);
	 			param.put("upd_usr_id", updUsrId);
				
				updCnt = sqlExe.executeUpdate((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOModifyPackingInstructionRegulationFlgUSQL(), param,null);
				if(updCnt== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update No"+ " SQL");
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
	 * Packaging Code General 을 조회 합니다. <br>
	 * 
	 * @param ScgPckReguPkgCdVO scgPckReguPkgCdVO
	 * @return List<ScgPckReguPkgCdVO>
	 * @throws DAOException
	 */
	public List<ScgPckReguPkgCdVO> searchPackingInstructionRegulationPackagingCodeList(ScgPckReguPkgCdVO scgPckReguPkgCdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgPckReguPkgCdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgPckReguPkgCdVO != null){
				Map<String, String> mapVO = scgPckReguPkgCdVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchPackingInstructionRegulationPackagingCodeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgPckReguPkgCdVO.class);
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
	 * Packaging Code General  을 생성 합니다. <br>
	 * 
	 * @param insertVoList List<ScgPckReguPkgCdVO>
	 * @throws DAOException
	 */
	public void addPackingInstructionRegulationPackagingCodeList(List<ScgPckReguPkgCdVO> insertVoList) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insertVoList.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOAddPackingInstructionRegulationPackagingCodeListCSQL(), insertVoList,null);
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
	 * Packaging Code General  을 수정 합니다. <br>
	 * 
	 * @param List<ScgPckReguPkgCdVO> updateVoList
	 * @throws DAOException
	 */
	public void modifyPackingInstructionRegulationPackagingCodeList(List<ScgPckReguPkgCdVO> updateVoList) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOModifyPackingInstructionRegulationPackagingCodeListUSQL(), updateVoList,null);
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
	 * Packaging Code General  을 삭제 합니다. <br>
	 * 
	 * @param List<ScgPckReguPkgCdVO> deleteVoList
	 * @throws DAOException
	 */
	public void removePackingInstructionRegulationPackagingCodeList(List<ScgPckReguPkgCdVO> deleteVoList) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(deleteVoList.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAORemovePackingInstructionRegulationPackagingCodeListUSQL(), deleteVoList,null);

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
	 * VOP_SCG_0104 : IBC CODE ONCHANGE <br>
	 * 
	 * @param String pkgCd
	 * @return List<ScgPckReguPkgCdVO>
	 * @exception EventException
	 */
	public List<ScgPckReguPkgCdVO> checkPkgCd(String pkgCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgPckReguPkgCdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try{
			if(pkgCd != null){
			
				param.put("pkg_cd", pkgCd);
				velParam.put("pkg_cd", pkgCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOCheckPkgCdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgPckReguPkgCdVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * SCG CODE 정보를 조회합니다.<br>
	 * 
	 * @param ScgCdVO scgCdVO
	 * @return List<ScgCdVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ScgCdVO> searchScgCodeList(ScgCdVO scgCdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgCdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgCdVO != null){
				Map<String, String> mapVO = scgCdVO.getColumnValues();			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgCdVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgCdVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 /**
		 * VOP_SCG_0083 SCG NON D/G CARGO KEYWORD 정보를 조회합니다<br>
		 * 
		 * @param ScgNonDgCgoKwVO scgNonDgCgoKwVO
		 * @return List<ScgNonDgCgoKwVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<ScgNonDgCgoKwVO> searchScgNonDgCgoList(ScgNonDgCgoKwVO scgNonDgCgoKwVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<ScgNonDgCgoKwVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(scgNonDgCgoKwVO != null){
					Map<String, String> mapVO = scgNonDgCgoKwVO.getColumnValues();			
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchNonDgCgoKwRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgNonDgCgoKwVO .class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
	
	   /**
	    * VOP_SCG_0083 SCG NON D/G CARGO KEYWORD 중복 체크<br>
	    * 
	    * @param String nonDcgokwnm
	    * @return String strRet
	    * @exception DAOException
	    */
	    public String checkScgNonDgCgoKw(String nonDcgokwnm ) throws DAOException {
	    	DBRowSet dbRowset = null;
	    	String strRet = "";
	    	//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(nonDcgokwnm != null){
					param.put("non_dcgo_kw_nm", nonDcgokwnm);
					velParam.put("non_dcgo_kw_nm", nonDcgokwnm);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOCheckScgNonDgCgoKwRSQL(), param, velParam);
				if(dbRowset.next()){
					strRet = dbRowset.getString(1);
				}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return strRet;
		}
		 
	  /**
	   * VOP_SCG_0083 SCG NON D/G CARGO KEYWORD 정보를 생성합니다<br>
	   * 
	   * @param insertVoList
	   * @exception DAOException
	   */
	 public void addScgNonDgCgoKwCodeList(List<ScgNonDgCgoKwVO> insertVoList) throws DAOException {
		 try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int updCnt[] = null;
				if(insertVoList.size() > 0){				
					updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOAddScgNonDgCgoKwCSQL(), insertVoList, null);
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
	   * VOP_SCG_0083 SCG NON D/G CARGO KEYWORD 정보를 수정합니다<br>
	   * 
	   * @param updateVoList
	   * @exception DAOException
	   */
	 public void updateScgNonDgCgoKwCodeList(List<ScgNonDgCgoKwVO> updateVoList) throws DAOException {
		 try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int updCnt[] = null;
				if(updateVoList.size() > 0){				
					updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOUpdateScgNonDgCgoKwUSQL(), updateVoList, null);
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
	   * VOP_SCG_0083 SCG NON D/G CARGO KEYWORD 정보를 삭제합니다<br>
	   * 
	   * @param deletetVoList
	   * @exception DAOException
	   */
	 public void modifyScgNonDgCgoKwCodeList(List<ScgNonDgCgoKwVO> deletetVoList) throws DAOException {
		 try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int delCnt[] = null;
				if(deletetVoList.size() > 0){				
					delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOModifyScgNonDgCgoKwUSQL(), deletetVoList, null);
					for(int i = 0; i < delCnt.length; i++){
						if(delCnt[i]== Statement.EXECUTE_FAILED)
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
		 * VOP_SCG_0084 SCG Chemical History 정보를 조회합니다<br>
		 * 
		 * @param ScgChemicalHistoryVO ScgChemicalHistoryVO
		 * @return List<ScgChemicalHistoryVO>
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		public List<ScgChemicalHistoryVO> searchScgChemicalHistory(ScgChemicalHistoryVO scgChemicalHistoryVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<ScgChemicalHistoryVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if(scgChemicalHistoryVO != null){
					Map<String, String> mapVO = scgChemicalHistoryVO.getColumnValues();			
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgChemicalHistoryRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgChemicalHistoryVO .class);
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		} 
		 
	
		 /**
			 * VOP_SCG_0084 SCG Chemical History 정보를 조회합니다(ANSWER)<br>
			 * 
			 * @param ScgChemicalHistoryVO ScgChemicalHistoryVO
			 * @return List<ScgChemicalHistoryVO>
			 * @exception DAOException
			 */
			 @SuppressWarnings("unchecked")
			public List<ScgChemicalHistoryVO> searchScgChemHistoryAnswer(ScgChemicalHistoryVO scgChemicalHistoryVO) throws DAOException {
				DBRowSet dbRowset = null;
				List<ScgChemicalHistoryVO> list = null;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				try{
					if(scgChemicalHistoryVO != null){
						Map<String, String> mapVO = scgChemicalHistoryVO.getColumnValues();			
						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgChemicalHistoryAnswerRSQL(), param, velParam);
					list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgChemicalHistoryVO .class);
				} catch(SQLException se) {
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				} catch(Exception ex) {
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
				return list;
			} 
	 
		 /**
		   * VOP_SCG_0084 SCG Chemical History 정보를 생성합니다<br>
		   * 
		   * @param insertVoList
		   * @exception DAOException
		   */
		 public void addScgChemicalHistory(List<ScgChemicalHistoryVO> insertVoList) throws DAOException {
			 try {
					SQLExecuter sqlExe = new SQLExecuter("");
					int updCnt[] = null;
					if(insertVoList.size() > 0){				
						updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOaddScgChemicalHistoryCSQL(), insertVoList, null);
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
		   * VOP_SCG_0084 SCG Chemical History 정보를 수정합니다<br>
		   * 
		   * @param updateVoList
		   * @exception DAOException
		   */
		 public void updateScgChemicalHistory(List<ScgChemicalHistoryVO> updateVoList) throws DAOException {
			 try {
					SQLExecuter sqlExe = new SQLExecuter("");
					int updCnt[] = null;
					if(updateVoList.size() > 0){				
						updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOupdateScgChemicalHistoryUSQL(), updateVoList, null);
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
		   * VOP_SCG_0084 SCG Chemical History 정보를 삭제합니다<br>
		   * 
		   * @param deleteVoList
		   * @exception DAOException
		   */
		 public void deleteScgChemicalHistory(List<ScgChemicalHistoryVO> deleteVoList) throws DAOException {
			 try {
					SQLExecuter sqlExe = new SQLExecuter("");
					int delCnt[] = null;
					if(deleteVoList.size() > 0){				
						delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOdeleteScgChemicalHistoryDSQL(), deleteVoList, null);
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
		   * VOP_SCG_0084 SCG Chemical History(file) 정보를 삭제합니다<br>
		   * 
		   * @param deleteVoList
		   * @exception DAOException
		   */
		 public void deleteScgChemicalHistoryFile(List<ScgChemicalHistoryVO> deleteVoList) throws DAOException {
			 try {
					SQLExecuter sqlExe = new SQLExecuter("");
					int delCnt[] = null;
					if(deleteVoList.size() > 0){				
						delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOdeleteScgChemicalHistoryFileDSQL(), deleteVoList, null);
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
		   * VOP_SCG_0109 SCG Chemical History 정보를 수정합니다<br>
		   * 
		   * @param updateVoList
		   * @exception DAOException
		   */
		 public void updateScgChemicalHistoryAnswer(List<ScgChemicalHistoryVO> updateVoList) throws DAOException {
			 try {
					SQLExecuter sqlExe = new SQLExecuter("");
					int updCnt[] = null;
					if(updateVoList.size() > 0){				
						updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOupdateScgChemHistoryAnswerUSQL(), updateVoList, null);
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
	 * SCG CODE 정보를 생성합니다.<br>
	 * 
	 * @param List<ScgCdVO> scgCdVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] addScgCodeS(List<ScgCdVO> scgCdVO) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(scgCdVO.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgCdVOCSQL(), scgCdVO,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
	}
	/**
	 * SCG CODE 정보를 수정합니다.<br>
	 * 
	 * @param List<ScgCdVO> scgCdVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] modifyScgCodeS(List<ScgCdVO> scgCdVO) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(scgCdVO.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgCdVOUSQL(), scgCdVO,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return updCnt;
	}
	
	/**
	 * SCG Chemical History file 을 조회 합니다. <br>
	 * 
	 * @param  ScgChemHistoryFileVO scgChemHistoryFileVO
	 * @return List<ScgChemHistoryFileVO>
	 * @throws DAOException
	 */
	public List<ScgChemHistoryFileVO> searchChemFileList(ScgChemHistoryFileVO scgChemHistoryFileVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgChemHistoryFileVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
				
			Map<String, String> mapVO = scgChemHistoryFileVO.getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchScgChemHistoryFileRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgChemHistoryFileVO.class);
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
	 * SCG Chemical History file 을 일괄적으로 생성 합니다. <br>
	 * 
	 * @param  List<ScgChemHistoryFileVO> ScgChemHistoryFileVOs
	 * @throws DAOException
	 */
	public void addFile(List<ScgChemHistoryFileVO> scgChemHistoryFileVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgChemHistoryFileVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOAddScgChemicalHistoryFileCSQL(), scgChemHistoryFileVOs,null);
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
	 * SCG Chemical History file의 seqeunce key값 조회. <br>
	 * 
	 * @param  String fileseq
	 * @param  String div
     * @return String
	 * @throws DAOException
	 */
	public String searchAtchFileSeq(String fileseq, String div) throws DAOException,Exception {
		
		    DBRowSet dbRowset = null;
	 		String scgChemHistorySeq =null;
	 		
	 		//query parameter
	 		Map<String, Object> param = new HashMap<String, Object>();
	 		//velocity parameter
	 //		Map<String, Object> velParam = new HashMap<String, Object>();

	 		try{
                
	 		    param.put("chem_seq", fileseq);
	 		    param.put("atch_file_div_cd", div);
	         	
	 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOSearchScgChemHistoryFileSeqRSQL(), param, null);
	 			if (dbRowset.next()) {
	 				scgChemHistorySeq = dbRowset.getString("atch_file_seq");
				}
	 		}catch(SQLException se){
	 			log.error(se.getMessage(),se);
	 			throw new DAOException(new ErrorHandler(se).getMessage());
	 		}catch(Exception ex){
	 			log.error(ex.getMessage(),ex);
	 			throw new DAOException(new ErrorHandler(ex).getMessage());
	 		}
	 		return scgChemHistorySeq;
	}
	
	/**
	 * SCG Chemical History file 을 일괄적으로 삭제 합니다. <br>
	 * 
	 * @param  List<ScgChemHistoryFileVO> scgChemHistoryFileVOs
	 * @throws DAOException
	 */
	public void removeFile(List<ScgChemHistoryFileVO> scgChemHistoryFileVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgChemHistoryFileVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOremoveScgChemHistoryFileDSQL(), scgChemHistoryFileVOs,null);

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
	 * SCG CODE 정보를 삭제합니다.<br>
	 * 
	 * @param List<ScgCdVO> scgCdVO
	 * @return int[]
	 * @exception DAOException
	 * @exception Exception
	 */
	public int[] removeScgCodeS(List<ScgCdVO> scgCdVO) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(scgCdVO.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgCdVODSQL(), scgCdVO,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return delCnt;
	}	
	
	/**
	 * Partner's Contact Point for SPCL CGO by POL 을 조회 합니다. <br>
	 * 
	 * @param scgCntcPntPolVO ScgCntcPntPolVO
	 * @return List<ScgCntcPntPolVO>
	 * @throws DAOException
	 */
	public List<ScgCntcPntPolVO> searchPartnerContactPointPolList(ScgCntcPntPolVO scgCntcPntPolVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgCntcPntPolVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgCntcPntPolVO != null){
				Map<String, String> mapVO = scgCntcPntPolVO.getColumnValues();				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgCntcPntPolVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgCntcPntPolVO.class);
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
	 * Partner's Contact Point for SPCL CGO by Pol 을 생성 합니다. <br>
	 * 
	 * @param scgCntcPntPolVOs List<ScgCntcPntVO>
	 * @throws DAOException
	 */
	public void addPartnerContactPointPol(List<ScgCntcPntPolVO> scgCntcPntPolVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgCntcPntPolVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgCntcPntPolVOCSQL(), scgCntcPntPolVOs, null);
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
	 * Partner's Contact Point for SPCL CGO by Pol 을 수정 합니다. <br>
	 * 
	 * @param scgCntcPntPolVOs List<ScgCntcPntPolVO>
	 * @throws DAOException
	 */
	public void modifyPartnerContactPointPol(List<ScgCntcPntPolVO> scgCntcPntPolVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgCntcPntPolVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgCntcPntPolVOUSQL(), scgCntcPntPolVOs,null);
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
	 * Partner's Contact Point for SPCL CGO 을 삭제 합니다. <br>
	 * 
	 * @param scgCntcPntPolVOs List<ScgCntcPntPolVO>
	 * @throws DAOException
	 */
	public void removePartnerContactPointPol(List<ScgCntcPntPolVO> scgCntcPntPolVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgCntcPntPolVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialCargoMasterDataMgtDBDAOScgCntcPntPolVODSQL(), scgCntcPntPolVOs,null);

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
