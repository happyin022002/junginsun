/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StevedoreDamageMgtDBDAO.java
*@FileTitle : Damage Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 이선영
*@LastVersion : 1.0
* 2009.05.18 이선영
* 1.0 Creation
* * 2010.10.12 이석준 [CHM-201006428-01] VVD,VSL,Lane,Port 유효성 검사 로직 추가
*              Delete시 유효성 check logic 추가
* 2010.10.15 이상민 [CHM-201007482-01] 1053 event에 COMMAND01 - checkTabSavable() Tab이동시 save 가능 여부 확인 로직 추가*    
* 2011.01.12 진마리아 [CHM-201108239-01] SDMS내 demage date및 삭제 권한 변경 요청 건          
=========================================================*/
package com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomInvDtlVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomSdmsSettlementVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.basic.StevedoreDamageMgtBCImpl;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.OpfStvDmgCmpnVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.OpfStvDmgCreateVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsCompensationReportVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsDamageReportVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsOptionVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsRepairReportVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsReportVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsSettlementReportVO;
import com.clt.apps.opus.vop.opf.stevedoredamagemgt.stevedoredamagemgt.vo.SdmsStepHistoryVO;
import com.clt.bizcommon.currency.vo.MdmCurrencyVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.ComIntgCdDtlVO;
import com.clt.syscommon.common.table.ComUserVO;
import com.clt.syscommon.common.table.MdmOrganizationVO;
import com.clt.syscommon.common.table.OpfStvDmgAtchFileVO;
import com.clt.syscommon.common.table.OpfStvDmgDtlVO;
import com.clt.syscommon.common.table.OpfStvDmgRprVO;
import com.clt.syscommon.common.table.OpfStvDmgStepHisVO;
import com.clt.syscommon.common.table.OpfStvDmgStlVO;
import com.clt.syscommon.common.table.OpfStvDmgVO;
import com.clt.syscommon.common.table.VskVslPortSkdVO;
import com.clt.syscommon.common.table.VskVslSkdVO;


/**
 * OPUS StevedoreDamageMgtDBDAO <br>
 * - OPUS-StevedoreDamageMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Sunyoung
 * @see StevedoreDamageMgtBCImpl 참조
 * @since J2EE 1.4
 */ 
public class StevedoreDamageMgtDBDAO extends DBDAOSupport {
	
	// VOP_OPF_0052 Start ============================================================//
	/**
	 * Stevedore Damage 정보를 조회 합니다. <br>
	 * 
	 * @param OpfStvDmgCreateVO opfStvDmgCreateVO
	 * @return List<OpfStvDmgCreateVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfStvDmgCreateVO> searchDamage(OpfStvDmgCreateVO opfStvDmgCreateVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfStvDmgCreateVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(opfStvDmgCreateVO != null){
				Map<String, String> mapVO = opfStvDmgCreateVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgCreateVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfStvDmgCreateVO .class);
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
	 *Stevedore Damage의 File Upload Data 정보를 조회 합니다.
	 * 
	 * @param OpfStvDmgAtchFileVO opfStvDmgAtchFileVO
	 * @return List<OpfStvDmgAtchFileVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfStvDmgAtchFileVO> searchDamageAttachFile(OpfStvDmgAtchFileVO opfStvDmgAtchFileVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfStvDmgAtchFileVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(opfStvDmgAtchFileVO != null){
				Map<String, String> mapVO = opfStvDmgAtchFileVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgAtchFileVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfStvDmgAtchFileVO .class);
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
	 * Stevedore Damage 화면의 VVD 정보가 중복되는지 여부를 조회 합니다. <br>
	 * 
	 * @param OpfStvDmgCreateVO opfStvDmgCreateVO
	 * @return List<OpfStvDmgVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfStvDmgVO> checkVVDInfo(OpfStvDmgCreateVO opfStvDmgCreateVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfStvDmgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(opfStvDmgCreateVO != null){
				Map<String, String> mapVO = opfStvDmgCreateVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOCheckStvDmgDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfStvDmgVO .class);
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
	 * Stevedore Damage 의 해당 Vessel의 Seqence 정보를 조회 합니다.<br>
	 * 
	 * @param String vslCd
	 * @return String
	 * @throws DAOException
	 */
	public String getStvDmgNo(String vslCd) throws DAOException {
		DBRowSet dbRowset = null;
		String stvDmgSeq = null;
//		List<OpfStvDmgCreateVO> list = null;
//		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslCd != null){
				HashMap<String, String> hmap = new HashMap<String, String>();
				hmap.put("vsl_cd", vslCd);
			
				param.putAll(hmap);
				velParam.putAll(hmap);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOStvDmgNoRSQL(), param, velParam);
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfStvDmgCreateVO .class);
			if(dbRowset.next()){
				stvDmgSeq = dbRowset.getString("stv_dmg_seq");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return stvDmgSeq;
	}
	
	/**
	 * Stevedore Damage 정보를 삭제 합니다. <br>
	 * 
	 * @param String delStvDmgNo
	 * @param String delFlag
	 * @return int
	 * @throws DAOException
	 */
	public int removeDamageData(String delStvDmgNo, String delFlag) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("stv_dmg_no", delStvDmgNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
//			if(delFlag.equals("All")){
//				// OPF_STV_DMG Data Delete.
//				result  = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgVODSQL(), param, velParam);
//				// OPF_STV_DMG_DTL Data Delete.
//				result += sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgDtlsDSQL(), param, velParam);
//			}
//			else{
//				result = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgDtlVODSQL(), param, velParam);
//			}
			// 1. OPF_STV_DMG 정보 삭제.
			result = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
			// 2. OPF_STV_DMG_DTL 정보 삭제.
//			result = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgDtlVODSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to delete SQL");
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
	 * Stevedore Damage Detail 정보를 삭제 합니다. <br>
	 * 
	 * @param String delStvDmgNo
	 * @param String delFlag
	 * @return int
	 * @throws DAOException
	 */
	public int removeDamageDetailData(String delStvDmgNo, String delFlag) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("stv_dmg_no", delStvDmgNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
//			if(delFlag.equals("All")){
//				// OPF_STV_DMG Data Delete.
//				result  = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgVODSQL(), param, velParam);
//				// OPF_STV_DMG_DTL Data Delete.
//				result += sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgDtlsDSQL(), param, velParam);
//			}
//			else{
//				result = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgDtlVODSQL(), param, velParam);
//			}
			// 1. OPF_STV_DMG 정보 삭제.
//			result = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgVODSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException("Fail to delete SQL");
			// 2. OPF_STV_DMG_DTL 정보 삭제.
			result = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgDtlVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
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
	 * Stevedore Damage 정보를 생성 합니다. <br>
	 * 
	 * @param List<OpfStvDmgVO> opfStvDmgVOs
	 * @throws DAOException
	 */
	public void addDamage(List<OpfStvDmgVO> opfStvDmgVOs) throws DAOException,Exception {
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			for(int i=0; i<opfStvDmgVOs.size(); i++){
				OpfStvDmgVO vo = opfStvDmgVOs.get(i);
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgVOCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			}
			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int insCnt[] = null;
//			if(insModels.size() > 0){
//				insCnt = sqlExe.executeBatch((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgVOCSQL(), insModels,null);
//				for(int i = 0; i < insCnt.length; i++){
//					if(insCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * Stevedore Damage Detail 정보를 생성 합니다. <br>
	 * 
	 * @param List<OpfStvDmgDtlVO> opfStvDmgDtlVOs
	 * @throws DAOException
	 */
	public void addDamageDetail(List<OpfStvDmgDtlVO> opfStvDmgDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(opfStvDmgDtlVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgDtlVOCSQL(), opfStvDmgDtlVOs,null);
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
	 * Stevedore Damage 정보를 갱신 합니다. <br>
	 * 
	 * @param List<OpfStvDmgVO> opfStvDmgVOs
	 * @throws DAOException
	 */
	public void modifyDamage(List<OpfStvDmgVO> opfStvDmgVOs) throws DAOException,Exception {
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			for(int i=0; i<opfStvDmgVOs.size(); i++){
				OpfStvDmgVO vo = opfStvDmgVOs.get(i);
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgVOUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int updCnt[] = null;
//			if(updModels.size() > 0){
//				updCnt = sqlExe.executeBatch((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgVOUSQL(), updModels,null);
//				for(int i = 0; i < updCnt.length; i++){
//					if(updCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**
	 * Stevedore Damage Detail 정보를 갱신 합니다. <br>
	 * 
	 * @param List<OpfStvDmgDtlVO> opfStvDmgDtlVOs
	 * @throws DAOException
	 */
	public void modifyDamageDetail(List<OpfStvDmgDtlVO> opfStvDmgDtlVOs) throws DAOException,Exception {
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			for(int i=0; i<opfStvDmgDtlVOs.size(); i++){
				OpfStvDmgDtlVO vo = opfStvDmgDtlVOs.get(i);
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgDtlVOUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int updCnt[] = null;
//			if(updModels.size() > 0){
//				updCnt = sqlExe.executeBatch((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgDtlVOUSQL(), updModels,null);
//				for(int i = 0; i < updCnt.length; i++){
//					if(updCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Stevedore Damage 정보를 삭제 합니다. <br>
	 * 
	 * @param List<OpfStvDmgVO> opfStvDmgVOs
	 * @throws DAOException
	 */
	public void removeDamage(List<OpfStvDmgVO> opfStvDmgVOs) throws DAOException,Exception {
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			for(int i=0; i<opfStvDmgVOs.size(); i++){
				OpfStvDmgVO vo = opfStvDmgVOs.get(i);
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgVODSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete SQL");
			}
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int delCnt[] = null;
//			if(delModels.size() > 0){
//				delCnt = sqlExe.executeBatch((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgVODSQL(), delModels,null);
//				for(int i = 0; i < delCnt.length; i++){
//					if(delCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Stevedore Damage Detail 정보를 삭제 합니다. <br>
	 * 
	 * @param List<OpfStvDmgDtlVO> opfStvDmgDtlVOs
	 * @throws DAOException
	 */
	public void removeDamageDetail(List<OpfStvDmgDtlVO> opfStvDmgDtlVOs) throws DAOException,Exception {
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			for(int i=0; i<opfStvDmgDtlVOs.size(); i++){
				OpfStvDmgDtlVO vo = opfStvDmgDtlVOs.get(i);
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgDtlVODSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete SQL");
			}
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int delCnt[] = null;
//			if(delModels.size() > 0){
//				delCnt = sqlExe.executeBatch((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgDtlVODSQL(), delModels,null);
//				for(int i = 0; i < delCnt.length; i++){
//					if(delCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * StevedoreDamageMgt화면에 대한 VVD Port Code 및 ETA/ETD Date 조회 이벤트 처리<br>
	 * 
	 * @param OpfStvDmgCreateVO opfStvDmgCreateVO
	 * @return List<VskVslPortSkdVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskVslPortSkdVO> searchVskVslPortSkdVO(OpfStvDmgCreateVO opfStvDmgCreateVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskVslPortSkdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(opfStvDmgCreateVO != null){
				Map<String, String> mapVO = opfStvDmgCreateVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOVskVslPortSkdVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslPortSkdVO.class);
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
	 * Stevedore Damage 화면에 대한 Lane Code 조회 이벤트 처리<br>
	 * 
	 * @param OpfStvDmgCreateVO opfStvDmgCreateVO
	 * @return List<VskVslSkdVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VskVslSkdVO> searchLaneCode(OpfStvDmgCreateVO opfStvDmgCreateVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VskVslSkdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(opfStvDmgCreateVO != null){
				Map<String, String> mapVO = opfStvDmgCreateVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			//dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOVskVslPortSkdVORSQL(), param, velParam);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOVskVslSkdVORSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslSkdVO.class);
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
	 * StevedoreDamageMgt화면에 대한 Common Code 조회 이벤트 처리<br>
	 * 
	 * @param String codeID
	 * @return List<ComIntgCdDtlVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ComIntgCdDtlVO> searchComCodeList(String codeID) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComIntgCdDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(codeID != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("intg_cd_id", codeID);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOComIntgCdDtlVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComIntgCdDtlVO.class);
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
	 * StevedoreDamageMgt화면에 대한 Approval Permission 조회 이벤트 처리<br>
	 * 
	 * @param String userID
	 * @return int
	 * @throws DAOException
	 */
	public int searchApprovalPermissionCheck(String userID) throws DAOException {
		DBRowSet dbRowset = null;
		int returnCnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(userID != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("usr_id", userID);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOApprovalCheckRSQL(), param, velParam);
			if(dbRowset.next()){
				returnCnt = dbRowset.getInt("cnt");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnCnt;
	}
	
	/**
	 * Stevedore Damage Approval 정보를 저장 합니다. <br>
	 * 
	 * @param OpfStvDmgCreateVO opfStvDmgCreateVO
	 * @return int
	 * @throws DAOException
	 */
	public int updateApproval(OpfStvDmgCreateVO opfStvDmgCreateVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = opfStvDmgCreateVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOApprovalUSQL(), param, velParam);
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
	 * Stevedore Damage Creation 화면의 File 정보를 생성 합니다.<br>
	 * 
	 * @param List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileVOs
	 * @throws DAOException
	 */
	public void addDamageAttachFile(List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(opfStvDmgAtchFileVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgAtchFileVOCSQL(), opfStvDmgAtchFileVOs,null);
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
	 * Stevedore Damage Creation 화면의 File 정보를 갱신 합니다.<br>
	 * 
	 * @param List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileVOs
	 * @throws DAOException
	 */
	public void modifyDamageAttachFile(List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(opfStvDmgAtchFileVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgAtchFileVOUSQL(), opfStvDmgAtchFileVOs,null);
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
	 * Stevedore Damage Creation 화면의 File 정보를 SDMS No 같은것 삭제 합니다.<br>
	 * 
	 * @param List<OpfStvDmgVO> opfStvDmgVOs
	 * @throws DAOException
	 */
	public void removeDamageAllAttachFile(List<OpfStvDmgVO> opfStvDmgVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(opfStvDmgVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgAllAtchFileVODSQL(), opfStvDmgVOs,null);
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
	 * Stevedore Damage Creation 화면의 File 정보를 삭제 합니다.<br>
	 * 
	 * @param List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileVOs
	 * @throws DAOException
	 */
	public void removeDamageAttachFile(List<OpfStvDmgAtchFileVO> opfStvDmgAtchFileVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(opfStvDmgAtchFileVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgAtchFileVODSQL(), opfStvDmgAtchFileVOs,null);
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
	 * Stevedore Damage 화면에 대한 Office Code 조회 이벤트 처리<br>
	 * 
	 * @param String ofcCd
	 * @return List<MdmOrganizationVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmOrganizationVO> searchOfficeCode(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmOrganizationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ofcCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("ofc_cd", ofcCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOMdmOrganizationVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmOrganizationVO .class);
//			if(dbRowset.next()){
//				returnStr = dbRowset.getString("ofc_cd");
//			}
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
	 * Stevedore Damage 화면에 대한 E-mail [PIC of Claim Handling Office] 조회 이벤트 처리<br>
	 * 
	 * @param String ofcCd
	 * @return List<ComUserVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ComUserVO> searchMailContentPic(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComUserVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ofcCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("ofc_cd", ofcCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOMailContentPicRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComUserVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	
	// VOP_OPF_0052 End ============================================================//
	
	// VOP_OPF_0053 Start ============================================================//
	/**
	 * Stevedore Damage Inquiry 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param SdmsOptionVO sdmsOptionVO
	 * @return List<SdmsOptionVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SdmsOptionVO> searchSDList(SdmsOptionVO sdmsOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SdmsOptionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sdmsOptionVO != null){
				Map<String, String> mapVO = sdmsOptionVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOSdmsOptionVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SdmsOptionVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	// VOP_OPF_0053 End ============================================================//
	 
	// VOP_OPF_1053 Start ============================================================//
	/**
	 * Stevedore Damage Details 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param String stvDmgNo
	 * @return SdmsDetailsGRPVO
	 * @throws DAOException
	 */
//	 @SuppressWarnings("unchecked")
//	public SdmsDetailsGRPVO searchSdmsDetails(String stvDmgNo) throws DAOException {
//		//DBRowSet dbRowset = null;
//		SdmsDetailsGRPVO grpVO = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			if(stvDmgNo != null){
//				Map<String, String> mapVO = new HashMap<String, String>();
//				mapVO.put("stv_dmg_no", stvDmgNo);
//				
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
//			}
//			DBRowSet dbRowset01 = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgVORSQL(), param, velParam);
//			if(dbRowset01.getRowCount()>0){
//				grpVO = new SdmsDetailsGRPVO();
//				grpVO.setOpfStvDmgVOs((List)RowSetUtil.rowSetToVOs(dbRowset01, OpfStvDmgVO.class));
//				DBRowSet dbRowset02 = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgDtlVORSQL(), param, velParam);
//				grpVO.setOpfStvDmgDtlVOs((List)RowSetUtil.rowSetToVOs(dbRowset02, OpfStvDmgDtlVO.class));
//				DBRowSet dbRowset03 = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgRprVORSQL(), param, velParam);
//				grpVO.setOpfStvDmgRprVOs((List)RowSetUtil.rowSetToVOs(dbRowset03, OpfStvDmgRprVO.class));
//				DBRowSet dbRowset04 = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgCmpnVORSQL(), param, velParam);
//				grpVO.setOpfStvDmgCmpnVOs((List)RowSetUtil.rowSetToVOs(dbRowset04, OpfStvDmgCmpnVO.class));
//				DBRowSet dbRowset05 = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgStlVORSQL(), param, velParam);
//				grpVO.setOpfStvDmgStlVOs((List)RowSetUtil.rowSetToVOs(dbRowset05, OpfStvDmgStlVO.class));
//			}
//			
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return grpVO;
//	}
	 
	/**
	 * Stevedore Damage Update 화면의 Damage 정보를 조회 합니다.<br>
	 * 
	 * @param String stvDmgNo
	 * @return List<OpfStvDmgVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfStvDmgVO> searchSdmsDamage(String stvDmgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfStvDmgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(stvDmgNo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("stv_dmg_no", stvDmgNo);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfStvDmgVO .class);
			
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
	 * Stevedore Damage Update 화면의 Damage Detail 정보를 조회 합니다.<br>
	 * 
	 * @param String stvDmgNo
	 * @return List<OpfStvDmgDtlVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfStvDmgDtlVO> searchSdmsDamageDtl(String stvDmgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfStvDmgDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(stvDmgNo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("stv_dmg_no", stvDmgNo);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgDtlVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfStvDmgDtlVO .class);
			
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
	 * Stevedore Damage Update 화면의 Damage Repair 정보를 조회 합니다.<br>
	 * 
	 * @param String stvDmgNo
	 * @return List<OpfStvDmgRprVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfStvDmgRprVO> searchSdmsDamageRpr(String stvDmgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfStvDmgRprVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(stvDmgNo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("stv_dmg_no", stvDmgNo);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgRprVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfStvDmgRprVO .class);
			
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
	 * Stevedore Damage Update 화면의 Damage Compensation 정보를 조회 합니다.<br>
	 * 
	 * @param String stvDmgNo
	 * @return List<OpfStvDmgCmpnVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfStvDmgCmpnVO> searchSdmsDamageCmpn(String stvDmgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfStvDmgCmpnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(stvDmgNo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("stv_dmg_no", stvDmgNo);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgCmpnVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfStvDmgCmpnVO .class);
			
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
	 * Stevedore Damage Update 화면의 Damage Compensation 정보를 조회 합니다.<br>
	 * 
	 * @param String stvDmgNo
	 * @return List<OpfStvDmgStlVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfStvDmgStlVO> searchSdmsDamageStl(String stvDmgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfStvDmgStlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(stvDmgNo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("stv_dmg_no", stvDmgNo);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgStlVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfStvDmgStlVO .class);
			
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
	 * Stevedore Damage Update 화면의 File 정보를 조회 합니다.<br>
	 * 
	 * @param String stvDmgNo
	 * @param String stvDmgAtchFileTpCd
	 * @param String stvDmgProcCd
	 * @return List<OpfStvDmgAtchFileVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfStvDmgAtchFileVO> searchSdmsDamageAtchFile(String stvDmgNo, String stvDmgAtchFileTpCd, String stvDmgProcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfStvDmgAtchFileVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(stvDmgNo != null){
				
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("stv_dmg_no", stvDmgNo);
				mapVO.put("stv_dmg_atch_file_tp_cd", stvDmgAtchFileTpCd);
				mapVO.put("stv_dmg_proc_cd", stvDmgProcCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgAtchFileVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfStvDmgAtchFileVO .class);
			
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
	 * Stevedore Damage Update 화면의 Repair 정보를 생성 합니다.<br>
	 * 
	 * @param List<OpfStvDmgRprVO> opfStvDmgRprVOs
	 * @throws DAOException
	 */
	public void addDamageRepair(List<OpfStvDmgRprVO> opfStvDmgRprVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(opfStvDmgRprVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgRprVOCSQL(), opfStvDmgRprVOs,null);
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
	 * Stevedore Damage Update 화면의 Compensation 정보를 생성 합니다.<br>
	 * 
	 * @param List<OpfStvDmgCmpnVO> opfStvDmgCmpnVOs
	 * @throws DAOException
	 */
	public void addDamageCompensation(List<OpfStvDmgCmpnVO> opfStvDmgCmpnVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(opfStvDmgCmpnVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgCmpnVOCSQL(), opfStvDmgCmpnVOs,null);
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
	 * Stevedore Damage Update 화면의 Settlement 정보를 생성 합니다.<br>
	 * 
	 * @param List<OpfStvDmgStlVO> opfStvDmgStlVOs
	 * @throws DAOException
	 */
	public void addDamageSettlement(List<OpfStvDmgStlVO> opfStvDmgStlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(opfStvDmgStlVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgStlVOCSQL(), opfStvDmgStlVOs,null);
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
	 * Stevedore Damage Update 화면의 Repair 정보를 갱신 합니다.<br>
	 * 
	 * @param List<OpfStvDmgRprVO> opfStvDmgRprVOs
	 * @throws DAOException
	 */
	public void modifyDamageRepair(List<OpfStvDmgRprVO> opfStvDmgRprVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(opfStvDmgRprVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgRprVOUSQL(), opfStvDmgRprVOs,null);
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
	 * Stevedore Damage Update 화면의 Compensation 정보를 갱신 합니다.<br>
	 * 
	 * @param List<OpfStvDmgCmpnVO> opfStvDmgCmpnVOs
	 * @throws DAOException
	 */
	public void modifyDamageCompensation(List<OpfStvDmgCmpnVO> opfStvDmgCmpnVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(opfStvDmgCmpnVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgCmpnVOUSQL(), opfStvDmgCmpnVOs,null);
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
	 * Stevedore Damage Update 화면의 Settlement 정보를 갱신 합니다.<br>
	 * 
	 * @param List<OpfStvDmgStlVO> opfStvDmgStlVOs
	 * @throws DAOException
	 */
	public void modifyDamageSettlement(List<OpfStvDmgStlVO> opfStvDmgStlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(opfStvDmgStlVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgStlVOUSQL(), opfStvDmgStlVOs,null);
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
	 * Stevedore Damage Update 화면에 대한 User Name 조회 이벤트 처리<br>
	 * 
	 * @param String usrId
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchUserName(String usrId, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String userName = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(usrId != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("usr_id", usrId);
				mapVO.put("ofc_cd", ofcCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOComUserVORSQL(), param, velParam);
			if(dbRowset.next()){
				userName = dbRowset.getString("usr_nm");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return userName;
	}

	/**
	 * Stevedore Damage Update 화면에 대한 USD_AMT 조회 이벤트 처리<br>
	 * 
	 * @param String loclAmt
	 * @param String currCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchLocalPayUsd(String loclAmt, String currCd) throws DAOException {
		DBRowSet dbRowset = null;
		String usd_amt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(loclAmt != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("locl_amt", loclAmt);
				mapVO.put("curr_cd", currCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOLocalPayUsdRSQL(), param, velParam);
			if(dbRowset.next()){
				usd_amt = dbRowset.getString("usd_amt");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return usd_amt;
	}
	
	/**
	 * Stevedore Damage 화면에 대한 Currency Code 조회 이벤트 처리<br>
	 * 
	 * @return List<MdmCurrencyVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmCurrencyVO> searchCurrencyCode() throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCurrencyVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOMdmCurrencyVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCurrencyVO .class);
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
	 * Stevedore Damage Update 화면에 대한 Default Currency 조회 이벤트 처리<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchDefaultCurrency(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String currCode = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ofcCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("ofc_cd", ofcCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAODefaultCurrencyCodeRSQL(), param, velParam);
			if(dbRowset.next()){
				currCode = dbRowset.getString("curr_cd");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return currCode;
	}
	
	/**
	 * Stevedore Damage Update 화면에 대한 Damage 정보 조회 이벤트 처리<br>
	 * 
	 * @param OpfStvDmgVO opfStvDmgVO
	 * @return List<OpfStvDmgVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfStvDmgVO> searchStvDamage(OpfStvDmgVO opfStvDmgVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfStvDmgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(opfStvDmgVO != null){
				Map<String, String> mapVO = opfStvDmgVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfStvDmgVO .class);
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
	 *Stevedore Damage Update 화면에 대한 Damage Detail 정보 조회 이벤트 처리<br>
	 * 
	 * @param OpfStvDmgDtlVO opfStvDmgDtlVO
	 * @return List<OpfStvDmgDtlVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfStvDmgDtlVO> searchDamageDetail(OpfStvDmgDtlVO opfStvDmgDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfStvDmgDtlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(opfStvDmgDtlVO != null){
				Map<String, String> mapVO = opfStvDmgDtlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgDtlVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfStvDmgDtlVO .class);
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
	 * Stevedore Damage Update 화면에 대한 Damage Repair 정보 조회 이벤트 처리<br>
	 * 
	 * @param OpfStvDmgRprVO opfStvDmgRprVO
	 * @return List<OpfStvDmgRprVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfStvDmgRprVO> searchDamageRepair(OpfStvDmgRprVO opfStvDmgRprVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfStvDmgRprVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(opfStvDmgRprVO != null){
				Map<String, String> mapVO = opfStvDmgRprVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgRprVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfStvDmgRprVO .class);
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
	 * Stevedore Damage Update 화면에 대한 Damage Compensation 정보 조회 이벤트 처리<br>
	 * 
	 * @param OpfStvDmgCmpnVO opfStvDmgCmpnVO
	 * @return List<OpfStvDmgCmpnVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfStvDmgCmpnVO> searchDamageCompensation(OpfStvDmgCmpnVO opfStvDmgCmpnVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfStvDmgCmpnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(opfStvDmgCmpnVO != null){
				Map<String, String> mapVO = opfStvDmgCmpnVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgCmpnVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfStvDmgCmpnVO .class);
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
	 * Stevedore Damage Update 화면에 대한 Damage Settlement 정보 조회 이벤트 처리<br>
	 * 
	 * @param OpfStvDmgStlVO opfStvDmgStlVO
	 * @return List<OpfStvDmgStlVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<OpfStvDmgStlVO> searchDamageSettlement(OpfStvDmgStlVO opfStvDmgStlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfStvDmgStlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(opfStvDmgStlVO != null){
				Map<String, String> mapVO = opfStvDmgStlVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgStlVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OpfStvDmgStlVO .class);
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
	 * FMS에서 Payment Data Insert에 이용하는 메서드<br>
	 * 
	 * @param List<CustomSdmsSettlementVO> customSdmsSettlementVOs
	 * @throws DAOException
	 */
	public void addSettlementFMS(List<CustomSdmsSettlementVO> customSdmsSettlementVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customSdmsSettlementVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new StevedoreDamageMgtDBDAOCustomSdmsSettlementVOCSQL(), customSdmsSettlementVOs,null);
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
	 * FMS에서 Payment Data Delete에 이용하는 메서드<br>
	 * 
	 * @param List<CustomInvDtlVO> customInvDtlVOs
	 * @throws DAOException
	 */
	public void removeSettlementFMS(List<CustomInvDtlVO> customInvDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customInvDtlVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new StevedoreDamageMgtDBDAOCustomInvDtlVODSQL(), customInvDtlVOs,null);
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
	// VOP_OPF_1053 End ============================================================//
	 
	// VOP_OPF_0054 Start ============================================================//
	/**
	 * Stevedore Damage History 화면에 대한 정보를 조회 합니다.<br>
	 * 
	 * @param String stvDmgNo
	 * @return List<SdmsStepHistoryVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SdmsStepHistoryVO> searchSDHistoryList(String stvDmgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SdmsStepHistoryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(stvDmgNo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("stv_dmg_no", stvDmgNo);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOSdmsStepHistoryVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SdmsStepHistoryVO .class);
			
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
	 * Stevedore Damage History 데이터의 Max Sequence 를 조회 합니다.<br>
	 * 
	 * @param String stvDmgNo
	 * @param String dmgProcCd
	 * @return OpfStvDmgStepHisVO
	 * @throws DAOException
	 */
	public OpfStvDmgStepHisVO searchHistoryMaxSeq(String stvDmgNo, String dmgProcCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		//Map<String, String> returnMapVO = new HashMap<String, String>();
		OpfStvDmgStepHisVO returnVO = null;

		try{
			if(stvDmgNo != null){
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("stv_dmg_no", stvDmgNo);
				mapVO.put("stv_dmg_proc_cd", dmgProcCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOSdmsStepHistoryMaxSeqRSQL(), param, velParam);
			if(dbRowset.next()){
				//returnMapVO.put("seq", dbRowset.getString("stv_dmg_step_his_seq"));
				//returnMapVO.put("beforeStsCd", dbRowset.getString("stv_dmg_crnt_proc_sts_cd"));
				returnVO = new OpfStvDmgStepHisVO();
				returnVO.setStvDmgStepHisSeq(dbRowset.getString("stv_dmg_step_his_seq"));
				returnVO.setStvDmgProcCd(dbRowset.getString("stv_dmg_crnt_proc_sts_cd"));
			}
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
	 * Stevedore Damage History 정보를 생성 합니다.<br>
	 * 
	 * @param List<OpfStvDmgStepHisVO> opfStvDmgStepHisVOs
	 * @throws DAOException
	 */
	public void addDamageHistory(List<OpfStvDmgStepHisVO> opfStvDmgStepHisVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(opfStvDmgStepHisVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgStepHisVOCSQL(), opfStvDmgStepHisVOs,null);
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
	 * Stevedore Damage History 정보를 삭제 합니다.<br>
	 * 
	 * @param List<OpfStvDmgStepHisVO> opfStvDmgStepHisVOs
	 * @throws DAOException
	 */
	public void removeDamageHistory(List<OpfStvDmgStepHisVO> opfStvDmgStepHisVOs) throws DAOException,Exception {
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			for(int i=0; i<opfStvDmgStepHisVOs.size(); i++){
				OpfStvDmgStepHisVO vo = opfStvDmgStepHisVOs.get(i);
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgStepHisVODSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	// VOP_OPF_0054 End ============================================================//
	
	// VOP_OPF_0056 Start ============================================================//
	/**
	 * Stevedore Damage Performance Report 정보를 조회 합니다.<br>
	 * 
	 * @param SdmsReportVO sdmsReportVO
	 * @return List<SdmsReportVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SdmsReportVO> searchSdmsReportList(SdmsReportVO sdmsReportVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SdmsReportVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sdmsReportVO != null){
				Map<String, String> mapVO = sdmsReportVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOSdmsReportVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SdmsReportVO .class);
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
	 * Stevedore Damage Report 정보를 조회 합니다.<br>
	 * 
	 * @param SdmsReportVO sdmsReportVO
	 * @return List<SdmsDamageReportVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SdmsDamageReportVO> searchDamageReportList(SdmsReportVO sdmsReportVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SdmsDamageReportVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sdmsReportVO != null){
				Map<String, String> mapVO = sdmsReportVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOSdmsDamageReportVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SdmsDamageReportVO .class);
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
	 * Stevedore Damage Repair Report 정보를 조회 합니다.<br>
	 * 
	 * @param SdmsReportVO sdmsReportVO
	 * @return List<SdmsRepairReportVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SdmsRepairReportVO> searchRepairReportList(SdmsReportVO sdmsReportVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SdmsRepairReportVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sdmsReportVO != null){
				Map<String, String> mapVO = sdmsReportVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOSdmsRepairReportVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SdmsRepairReportVO .class);
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
	 * Stevedore Damage Compensation Report 정보를 조회 합니다.<br>
	 * 
	 * @param SdmsReportVO sdmsReportVO
	 * @return List<SdmsCompensationReportVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SdmsCompensationReportVO> searchCompensationReportList(SdmsReportVO sdmsReportVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SdmsCompensationReportVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sdmsReportVO != null){
				Map<String, String> mapVO = sdmsReportVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOSdmsCompensationReportVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SdmsCompensationReportVO .class);
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
	 * Stevedore Damage Settlement Report 정보를 조회 합니다.<br>
	 * 
	 * @param SdmsReportVO sdmsReportVO
	 * @return List<SdmsSettlementReportVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SdmsSettlementReportVO> searchSettlementReportList(SdmsReportVO sdmsReportVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SdmsSettlementReportVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sdmsReportVO != null){
				Map<String, String> mapVO = sdmsReportVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOSdmsSettlementReportVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SdmsSettlementReportVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	// VOP_OPF_0056 End ============================================================//
	/**
	 * VSL,VVD,Lane,Port Code Validation 을 검사합니다..<br>
	 * 
	 * @param VskVslPortSkdVO vskVslPortSkdVO
	 * @return String
	 * @exception EventException
	 */	  
	 public String checkMainCode(VskVslPortSkdVO vskVslPortSkdVO) throws DAOException{
		 DBRowSet dbRowset = null;
		 String result = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(vskVslPortSkdVO != null){
				Map<String, String> mapVO = vskVslPortSkdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOcheckMainCodeRSQL(), param, velParam);
			
			if(dbRowset != null){
				if(dbRowset.next()){
					result = dbRowset.getString("CODE");
				}
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
		 * VOP_OPF_0052 : Delete시에 delete 가능 여부 확인 로직 추가
		 * 
		 * @param String stvDmgNo
		 * @return String
		 * @exception EventException
		 */		
		public String checkDeleteFlag(String stvDmgNo) throws DAOException {	 	
			 DBRowSet dbRowset = null;
			 String result = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(stvDmgNo != null){
					param.put("stv_dmg_no", stvDmgNo);
					velParam.put("stv_dmg_no", stvDmgNo);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOCheckSdmsDeletePossRSQL(), param, velParam);
				
				if(dbRowset != null){
					if(dbRowset.next()){
						result = dbRowset.getString("KNT");
					}
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
		 * Stevedore Repair 정보를 삭제 합니다. <br>
		 * 
		 * @param List<OpfStvDmgVO> opfStvDmgVOs
		 * @throws DAOException
		 */
		public void removeDamageRepair(List<OpfStvDmgVO> opfStvDmgVOs) throws DAOException,Exception {
			try {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				
				int result = 0;
				for(int i=0; i<opfStvDmgVOs.size(); i++){
					OpfStvDmgVO vo = opfStvDmgVOs.get(i);
					Map<String, String> mapVO = vo.getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					SQLExecuter sqlExe = new SQLExecuter("");
					result = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOremoveDamageRepairDSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete SQL");
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
		 * Stevedore Compensation 정보를 삭제 합니다. <br>
		 * 
		 * @param List<OpfStvDmgVO> opfStvDmgVOs
		 * @throws DAOException
		 */
		public void removeDamageCompensation(List<OpfStvDmgVO> opfStvDmgVOs) throws DAOException,Exception {
			try {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				
				int result = 0;
				for(int i=0; i<opfStvDmgVOs.size(); i++){
					OpfStvDmgVO vo = opfStvDmgVOs.get(i);
					Map<String, String> mapVO = vo.getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					SQLExecuter sqlExe = new SQLExecuter("");
					result = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOremoveDamageCompensationDSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete SQL");
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
		 * Stevedore Settlement 정보를 삭제 합니다. <br>
		 * 
		 * @param List<OpfStvDmgVO> opfStvDmgVOs
		 * @throws DAOException
		 */
		public void removeDamageSettlement(List<OpfStvDmgVO> opfStvDmgVOs) throws DAOException,Exception {
			try {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				
				int result = 0;
				for(int i=0; i<opfStvDmgVOs.size(); i++){
					OpfStvDmgVO vo = opfStvDmgVOs.get(i);
					Map<String, String> mapVO = vo.getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					
					SQLExecuter sqlExe = new SQLExecuter("");
					result = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOremoveDamageSettlementDSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to delete SQL");
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
		 * Stevedore Damage Detail 정보를 삭제 합니다. <br>
		 * 
		 * @param String stvDmgNo
		 * @throws DAOException
		 */
		public void deleteDamageDetail(String stvDmgNo) throws DAOException,Exception {

			int result = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(stvDmgNo != null){
					param.put("stv_dmg_no", stvDmgNo);
					velParam.put("stv_dmg_no", stvDmgNo);
				}
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgDtlVODSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete SQL");
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			
		}
		/**
		 * Stevedore Damage Creation 화면의 File 정보를 SDMS No 같은것 삭제 합니다.<br>
		 * 
		 * @param String stvDmgNo
		 * @throws DAOException
		 */
		public void deleteDamageAllAttachFile(String stvDmgNo) throws DAOException,Exception {

			int result = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(stvDmgNo != null){
					param.put("stv_dmg_no", stvDmgNo);
					velParam.put("stv_dmg_no", stvDmgNo);
				}
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgAllAtchFileVODSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete SQL");
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			
		}
		/**
		 * Stevedore Damage Creation 화면의 File 정보를 삭제 합니다.<br>
		 * 
		 * @param String stvDmgNo
		 * @throws DAOException
		 */
		public void deleteDamageAttachFile(String stvDmgNo) throws DAOException,Exception {

			int result = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(stvDmgNo != null){
					param.put("stv_dmg_no", stvDmgNo);
					velParam.put("stv_dmg_no", stvDmgNo);
				}
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgAllAtchFileVODSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete SQL");
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			
		}
		
		/**
		 * Stevedore Damage History 정보를 삭제 합니다.<br>
		 * 
		 * @param String stvDmgNo
		 * @throws DAOException
		 */
		public void deleteDamageHistory(String stvDmgNo) throws DAOException,Exception {

			int result = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(stvDmgNo != null){
					param.put("stv_dmg_no", stvDmgNo);
					velParam.put("stv_dmg_no", stvDmgNo);
				}
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgStepHisVODSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete SQL");
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			
		}

			
		/**
		 * Stevedore Damage 정보를 삭제 합니다. <br>
		 * 
		 * @param String stvDmgNo
		 * @throws DAOException
		 */
		public void deleteDamage(String stvDmgNo) throws DAOException,Exception {

			int result = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(stvDmgNo != null){
					param.put("stv_dmg_no", stvDmgNo);
					velParam.put("stv_dmg_no", stvDmgNo);
				}
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgVODSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete SQL");
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			
		}
		/**
		 * Stevedore Repair 정보를 삭제 합니다. <br>
		 * 
		 * @param String stvDmgNo
		 * @throws DAOException
		 */
		public void deleteDamageRepair(String stvDmgNo) throws DAOException,Exception {

			int result = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(stvDmgNo != null){
					param.put("stv_dmg_no", stvDmgNo);
					velParam.put("stv_dmg_no", stvDmgNo);
				}
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOremoveDamageRepairDSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete SQL");
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			
		}
		/**
		 * Stevedore Compensation 정보를 삭제 합니다. <br>
		 * 
		 * @param String stvDmgNo
		 * @throws DAOException
		 */
		public void deleteDamageCompensation(String stvDmgNo) throws DAOException,Exception {

			int result = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(stvDmgNo != null){
					param.put("stv_dmg_no", stvDmgNo);
					velParam.put("stv_dmg_no", stvDmgNo);
				}
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOremoveDamageCompensationDSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete SQL");
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			
		}
		/**
		 * Stevedore Settlement 정보를 삭제 합니다. <br>
		 * 
		 * @param String stvDmgNo
		 * @throws DAOException
		 */
		public void deleteDamageSettlement(String stvDmgNo) throws DAOException,Exception {

			int result = 0;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(stvDmgNo != null){
					param.put("stv_dmg_no", stvDmgNo);
					velParam.put("stv_dmg_no", stvDmgNo);
				}
				
				SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOremoveDamageSettlementDSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete SQL");
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			
		}
		
		/**
		 * VOP_OPF_1053 : tab의 Save 가능 여부 확인 로직 추가
		 * 2010.12.14일 이상민 추가
		 * 
		 * @param String tabName
		 * @param String stvDmgNo
		 * @return String
		 * @exception EventException
		 */		
		public String checkTabSavable(String tabName, String stvDmgNo) throws DAOException {	 	
			 DBRowSet dbRowset = null;
			 String result = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try{
				if(stvDmgNo != null && tabName != null){
					param.put("stv_dmg_no", stvDmgNo);
					velParam.put("stv_dmg_no", stvDmgNo);
					
					param.put("tab_name", tabName);
					velParam.put("tab_name", tabName);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StevedoreDamageMgtDBDAOCheckSdmsSavePossRSQL(), param, velParam);
				
				if(dbRowset != null){
					if(dbRowset.next()){
						result = dbRowset.getString("SAVE_FLAG");
					}
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
		 * VVD, Port로 ETB, ETD 일자를 가져온다.
		 * @param VskVslPortSkdVO vskVslPortSkdVO
		 * @return List<VskVslPortSkdVO>
		 * @throws DAOException
		 */
	public List<VskVslPortSkdVO> searchVpsEtbEtdDtList(VskVslPortSkdVO vskVslPortSkdVO)	throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		List<VskVslPortSkdVO> list = null;
		try {
			if (vskVslPortSkdVO != null) {
				Map<String, String> mapVO = vskVslPortSkdVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new StevedoreDamageMgtDBDAOSearchEtbDtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VskVslPortSkdVO .class);
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
	 * Stevedore Damage History 정보를 tab에 따라 삭제 합니다.<br>
	 * 
	 * @param String stvDmgNo
	 * @param String tabNo
	 * @throws DAOException
	 */
	public void deleteDamageStepHistory(String stvDmgNo, String tabNo) throws DAOException,Exception {

		int result = 0;
		String tabNm = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(stvDmgNo != null){
				param.put("stv_dmg_no", stvDmgNo);
				velParam.put("stv_dmg_no", stvDmgNo);
			}
			if("1".equals(tabNo)){
				tabNm = "R";
			}else if("2".equals(tabNo)){
				tabNm = "C";
			}else if("3".equals(tabNo)){
				tabNm = "S";
			}
			param.put("tab_nm", tabNm);
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new StevedoreDamageMgtDBDAOOpfStvDmgStepHisVO2DSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}
}
