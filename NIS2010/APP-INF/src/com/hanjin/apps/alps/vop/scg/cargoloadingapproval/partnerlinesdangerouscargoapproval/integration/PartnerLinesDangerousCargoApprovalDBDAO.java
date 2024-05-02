/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PartnerLinesDangerousCargoApprovalDBDAO.java
*@FileTitle : SPCL CGO APVL for Partner Lines (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 김현욱
*@LastVersion : 1.0
* 2009.06.24 김현욱
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.basic.PartnerLinesDangerousCargoApprovalBCImpl;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.PartnerApprovalRequestVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInvalidReasonDetailVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionMtdItemVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionPortVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionRegulatoryVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionSegregationVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionVesselOperatorVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.RestrictionInputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.RestrictionOutputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionSpclProviVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionSppDetailVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstCgoVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstFileVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.common.ScgUtil;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS PartnerLinesDangerousCargoApprovalDBDAO <br>
 * - ALPS-CargoLoadingApproval system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HyunUk Kim
 * @see PartnerLinesDangerousCargoApprovalBCImpl 참조
 * @since J2EE 1.6
 */
public class PartnerLinesDangerousCargoApprovalDBDAO extends DBDAOSupport {

	/**
	 * SPCL CGO APVL for Partner Lines 를 조회 합니다. <br>
	 * 
	 * @param partnerApprovalRequestVO PartnerApprovalRequestVO
	 * @return List<PartnerApprovalRequestVO>
	 * @throws DAOException
	 */
	public List<PartnerApprovalRequestVO> searchPatnerSCGList(PartnerApprovalRequestVO partnerApprovalRequestVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PartnerApprovalRequestVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(partnerApprovalRequestVO != null){
				Map<String, String> mapVO = partnerApprovalRequestVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOPartnerApprovalRequestVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PartnerApprovalRequestVO .class);
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
	 * Dangerous CGO Application Details for Partner Lines 의 Booking Sequence 를 조회 합니다. <br>
	 * 
	 * @return int
	 * @throws DAOException
	 */
	public int searchPatnerSCGMaxSeq(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws DAOException {
		DBRowSet dbRowset = null;
		int maxSeq = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(scgPrnrAproRqstVO != null){
				Map<String, String> mapVO = scgPrnrAproRqstVO.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstMaxSeqRSQL(), param, null);
			if(dbRowset.next()) maxSeq = dbRowset.getInt(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return maxSeq;
	}
	
	/**
	 * Dangerous CGO Application Details for Partner Lines 의 Booking Attach File Sequence 를 조회 합니다. <br>
	 * 
	 * @param scgPrnrAproRqstVO ScgPrnrAproRqstVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchPatnerSCGAttachMaxSeq(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws DAOException {
		DBRowSet dbRowset = null;
		int maxSeq = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(scgPrnrAproRqstVO != null){
				Map<String, String> mapVO = scgPrnrAproRqstVO .getColumnValues();
			
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstFileMaxSeqRSQL(), param, null);
			if(dbRowset.next()) maxSeq = dbRowset.getInt(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return maxSeq;
	}
	
	/**
	 * Dangerous CGO Application Details for Partner Lines 의 중복 BKG Seq 를 조회 합니다. <br>
	 * 
	 * @param scgPrnrAproRqstCgoVO
	 * @return List<ScgPrnrAproRqstCgoVO>
	 * @throws DAOException
	 */
	public List<ScgPrnrAproRqstVO> searchPatnerSCGRqstDup(ScgPrnrAproRqstCgoVO scgPrnrAproRqstCgoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgPrnrAproRqstVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgPrnrAproRqstCgoVO != null){
				//velParam.put("opt_obj",  scgPrnrAproRqstCgoVOs);
				//velParam.put("obj_size", scgPrnrAproRqstCgoVOs.size());
				 
				Map<String, String> mapVO = scgPrnrAproRqstCgoVO.getColumnValues();
				
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstDupSeqRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgPrnrAproRqstCgoVO .class);
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
	 * Dangerous CGO Application Details for Partner Lines 의 Approval Number 를 생성 합니다. <br>
	 * 
	 * @param scgPrnrAproRqstCgoVOs List<ScgPrnrAproRqstCgoVO>
	 * @throws DAOException
	 */
	public void modifyPatnerSCGRqstNo(List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgPrnrAproRqstCgoVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstNoRSQL(), scgPrnrAproRqstCgoVOs,null);
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
	 * Dangerous CGO Application Details for Partner Lines 의 Cargo Sequence 를 조회 합니다. <br>
	 * 
	 * @param scgPrnrAproRqstVO ScgPrnrAproRqstVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchPatnerSCGCGOIsSeq(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws DAOException {
		DBRowSet dbRowset = null;
		int maxSeq = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgPrnrAproRqstVO != null){
				Map<String, String> mapVO = scgPrnrAproRqstVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoIsSeqRSQL(), param, velParam);
			if(dbRowset.next()) maxSeq = dbRowset.getInt(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return maxSeq;
	}
	 
	/**
	 *  Dangerous CGO Application Details for Partner Lines 를 단건 조회 합니다. <br>
	 * 
	 * @param scgPrnrAproRqstVO
	 * @return ScgPrnrAproRqstVO
	 * @throws DAOException
	 */
	public ScgPrnrAproRqstVO searchPatnerSCG(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgPrnrAproRqstVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgPrnrAproRqstVO != null){
				Map<String, String> mapVO = scgPrnrAproRqstVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgPrnrAproRqstVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()==0?new ScgPrnrAproRqstVO():list.get(0);
	}
	 
	/**
	 * Dangerous CGO Application Details for Partner Lines 의 Cargo 를 조회 합니다. <br>
	 * 
	 * @param scgPrnrAproRqstVO
	 * @return List<ScgPrnrAproRqstCgoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ScgPrnrAproRqstCgoVO> searchPatnerSCGCGO(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgPrnrAproRqstCgoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgPrnrAproRqstVO != null){
				Map<String, String> mapVO = scgPrnrAproRqstVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgPrnrAproRqstCgoVO .class);
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
	 * Dangerous CGO Application Details for Partner Lines 의 Attach File 를 조회 합니다. <br>
	 * 
	 * @param scgPrnrAproRqstVO ScgPrnrAproRqstVO
	 * @return List<ScgPrnrAproRqstFileVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ScgPrnrAproRqstFileVO> searchPatnerSCGAttach(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ScgPrnrAproRqstFileVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgPrnrAproRqstVO != null){
				Map<String, String> mapVO = scgPrnrAproRqstVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstFileVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ScgPrnrAproRqstFileVO .class);
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
	 * SPCL CGO APVL for Partner Lines 의 Booking 을 일괄적으로 생성 합니다. <br>
	 * 
	 * @param scgPrnrAproRqstVOs List<ScgPrnrAproRqstVO>
	 * @throws DAOException
	 */
	public void addPartnerSCG(List<ScgPrnrAproRqstVO> scgPrnrAproRqstVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgPrnrAproRqstVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstVOCSQL(), scgPrnrAproRqstVOs, null);
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
	 * SPCL CGO APVL for Partner Lines 의 Cargo 을 일괄적으로 생성 합니다. <br>
	 * 
	 * @param scgPrnrAproRqstCgoVOs List<ScgPrnrAproRqstCgoVO>
	 * @throws DAOException
	 */
	public void addPartnerSCGCGO(List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgPrnrAproRqstCgoVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoVOCSQL(), scgPrnrAproRqstCgoVOs, null);
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
	 * SPCL CGO APVL for Partner Lines 의 File 을 일괄적으로 생성 합니다. <br>
	 * 
	 * @param scgPrnrAproRqstFileVOs List<ScgPrnrAproRqstFileVO>
	 * @throws DAOException
	 */
	public void addPartnerSCGAttach(List<ScgPrnrAproRqstFileVO> scgPrnrAproRqstFileVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(scgPrnrAproRqstFileVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstFileVOCSQL(), scgPrnrAproRqstFileVOs, null);
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
	 * SPCL CGO APVL for Partner Lines 의 Booking 을 일괄적으로 수정 합니다. <br>
	 * 
	 * @param scgPrnrAproRqstVOs List<ScgPrnrAproRqstVO>
	 * @throws DAOException
	 */
	public void modifyPartnerSCG(List<ScgPrnrAproRqstVO> scgPrnrAproRqstVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgPrnrAproRqstVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstVOUSQL(), scgPrnrAproRqstVOs,null);
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
	 * SPCL CGO APVL for Partner Lines 의 Cargo 를 일괄적으로 수정 합니다. <br>
	 * 
	 * @param scgPrnrAproRqstCgoVOs List<ScgPrnrAproRqstCgoVO>
	 * @throws DAOException
	 */
	public void modifyPartnerSCGCGO(List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgPrnrAproRqstCgoVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoVOUSQL(), scgPrnrAproRqstCgoVOs,null);
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
	 * SPCL CGO APVL for Partner Lines 의 File 을 일괄적으로 수정 합니다. <br>
	 * 
	 * @param scgPrnrAproRqstFileVOs List<ScgPrnrAproRqstFileVO>
	 * @throws DAOException
	 */
	public void modifyPartnerSCGAttach(List<ScgPrnrAproRqstFileVO> scgPrnrAproRqstFileVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgPrnrAproRqstFileVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstFileVOUSQL(), scgPrnrAproRqstFileVOs,null);
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
	 * SPCL CGO Approved Details 의 Cargo 승인상태 를 일괄적으로 수정 합니다. <br>
	 * 
	 * @param scgPrnrAproRqstCgoVOs List<ScgPrnrAproRqstCgoVO>
	 * @throws DAOException
	 */
	public void modifyPartnerSCGCGOApproved(List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgPrnrAproRqstCgoVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoApprovedVOUSQL(), scgPrnrAproRqstCgoVOs,null);
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
	 * SPCL CGO APVL for Partner Lines 의 Booking 을 일괄적으로 삭제 합니다. <br>
	 * 
	 * @param scgPrnrAproRqstVOs List<ScgPrnrAproRqstVO>
	 * @throws DAOException
	 */
	public void removePartnerSCG(List<ScgPrnrAproRqstVO> scgPrnrAproRqstVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgPrnrAproRqstVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstVODSQL(), scgPrnrAproRqstVOs,null);
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
	 * SPCL CGO APVL for Partner Lines 의 Cargo 를 일괄적으로 삭제 합니다. <br>
	 * 
	 * @param scgPrnrAproRqstCgoVOs List<ScgPrnrAproRqstCgoVO>
	 * @throws DAOException
	 */
	public void removePartnerSCGCGO(List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgPrnrAproRqstCgoVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoVODSQL(), scgPrnrAproRqstCgoVOs,null);
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
	 * SPCL CGO APVL for Partner Lines 의 File 을 일괄적으로 삭제 합니다. <br>
	 * 
	 * @param scgPrnrAproRqstFileVOs List<ScgPrnrAproRqstFileVO>
	 * @throws DAOException
	 */
	public void removePartnerSCGAttach(List<ScgPrnrAproRqstFileVO> scgPrnrAproRqstFileVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgPrnrAproRqstFileVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstFileVODSQL(), scgPrnrAproRqstFileVOs,null);
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
	 * Dangerous CGO Application Details for Partner Lines 의 MPA1의 NET Weight 합을 조회 합니다. <br>
	 * 
	 * @param ScgPrnrAproRqstVO ScgPrnrAproRqstVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchPatnerSCGMpa1NetSum(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws DAOException {
		DBRowSet dbRowset = null;
		String netSum = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(scgPrnrAproRqstVO != null){
				Map<String, String> mapVO = scgPrnrAproRqstVO .getColumnValues();
			
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproMpa1NetSumRSQL(), param, null);
			if(dbRowset.next()) netSum = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return netSum;
	}
	
	/**
	 * Dangerous CGO Application Details for Partner Lines 의 Booking Sequence 를 조회 합니다. <br>
	 * @param ScgPrnrAproRqstVO scgPrnrAproRqstVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchPatnerSCGExistSeq( ScgPrnrAproRqstVO scgPrnrAproRqstVO ) throws DAOException {
		DBRowSet dbRowset = null;
		int currSeq = 0;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(scgPrnrAproRqstVO != null){
				Map<String, String> mapVO = scgPrnrAproRqstVO .getColumnValues();
			
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstExistSeqRSQL(), param, null);
			if(dbRowset.next()) currSeq = dbRowset.getInt(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return currSeq;
	}
	
	/**
	 * Pre Checking Report 의 Segregation Validation 을 조회 합니다. <br>
	 * 
	 * @param PreRestrictionInputVO preRestrictionInputVO
	 * @return List<PreRestrictionSegregationVO>
	 * @throws DAOException
	 */
	public List<PreRestrictionSegregationVO> checkPreRestrictionSegregation(PreRestrictionInputVO preRestrictionInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PreRestrictionSegregationVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(preRestrictionInputVO != null){
				Map<String, String> mapVO = preRestrictionInputVO.getInnerPreRestrictionInputVO().getColumnValues();
				param.putAll(mapVO); 
				
				PreRestrictionInputVO[] preRestrictionInputVOs = preRestrictionInputVO.getInnerPreRestrictionInputVOS();

				if(preRestrictionInputVOs != null){		
					velParam.put("start_num", Integer.parseInt(preRestrictionInputVO.getInnerPreRestrictionInputVO().getStartNum()));
					velParam.put("end_num", Integer.parseInt(preRestrictionInputVO.getInnerPreRestrictionInputVO().getEndNum()));
					velParam.put("opt_obj",  preRestrictionInputVOs);
					velParam.put("obj_size", preRestrictionInputVOs.length);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionSegregationVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreRestrictionSegregationVO .class);
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
	 * Pre Checking Report 의 Vessel Operator’s Prohibition 을 조회 합니다. <br>
	 * 
	 * @param PreRestrictionInputVO preRestrictionInputVO
	 * @return List<PreRestrictionVesselOperatorVO>
	 * @throws DAOException
	 */
	public List<PreRestrictionVesselOperatorVO> checkPreRestrictionVesselOperator(PreRestrictionInputVO preRestrictionInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PreRestrictionVesselOperatorVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(preRestrictionInputVO != null){
				Map<String, String> mapVO = preRestrictionInputVO.getInnerPreRestrictionInputVO().getColumnValues();
				param.putAll(mapVO);
				
				PreRestrictionInputVO[] preRestrictionInputVOs = preRestrictionInputVO.getInnerPreRestrictionInputVOS();

				if(preRestrictionInputVOs != null){
					velParam.put("opt_clss", preRestrictionInputVO.getInnerPreRestrictionInputVO().getOptClss());
					velParam.put("opt_obj",  preRestrictionInputVOs);
					velParam.put("obj_size", preRestrictionInputVOs.length);
					velParam.put("crr_cd",   preRestrictionInputVO.getInnerPreRestrictionInputVO().getCrrCd());
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOVesselOperatorVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreRestrictionVesselOperatorVO .class);
			if (list.size() > 0 ) {
				velParam.put("dummy_cd", "SML");
			}else {
				velParam.put("dummy_cd", "EXT");				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionVesselOperatorVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreRestrictionVesselOperatorVO .class);
			
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
	 * Pre Checking Report 의 Port Restrictions En-route 을 조회 합니다. <br>
	 * 
	 * @param PreRestrictionInputVO preRestrictionInputVO
	 * @return List<PreRestrictionPortVO>
	 * @throws DAOException
	 */
	public List<PreRestrictionPortVO> checkPreRestrictionPort(PreRestrictionInputVO preRestrictionInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PreRestrictionPortVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(preRestrictionInputVO != null){
				Map<String, String> mapVO = preRestrictionInputVO.getInnerPreRestrictionInputVO().getColumnValues();
				param.putAll(mapVO);
				
				PreRestrictionInputVO[] preRestrictionInputVOs = preRestrictionInputVO.getInnerPreRestrictionInputVOS();

				if(preRestrictionInputVOs != null){	
					velParam.put("opt_obj",  preRestrictionInputVOs);
					velParam.put("obj_size", preRestrictionInputVOs.length);
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionPortVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreRestrictionPortVO .class);
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
	 * Dangerous CGO Application Details for Partner Lines 의 Restrictions 을 조회 합니다. <br>
	 * 
	 * @param RestrictionInputVO restrictionInputVO
	 * @return List<RestrictionOutputVO>
	 * @throws DAOException
	 */
	public List<RestrictionOutputVO> searchRestrictions(RestrictionInputVO restrictionInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RestrictionOutputVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(restrictionInputVO != null){
				Map<String, String> mapVO = restrictionInputVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAORestrictionInputVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RestrictionOutputVO .class);
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
	 * Pre Checking Report 의 LQ 시 Regulatory 을 조회 합니다. <br>
	 * 
	 * @param PreRestrictionInputVO preRestrictionInputVO
	 * @return List<PreRestrictionRegulatoryVO>
	 * @throws DAOException
	 */
	public List<PreRestrictionRegulatoryVO> checkPreRestrictionLQRegulatory(PreRestrictionInputVO preRestrictionInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PreRestrictionRegulatoryVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(preRestrictionInputVO != null){
				Map<String, String> mapVO = preRestrictionInputVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionLQRegulatoryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreRestrictionRegulatoryVO .class);
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
	 * Pre Checking Report 의 LQ 시 InvalidReasonDetail 을 조회 합니다. <br>
	 * 
	 * @param PreRestrictionInputVO preRestrictionInputVO
	 * @return List<PreRestrictionInvalidReasonDetailVO>
	 * @throws DAOException
	 */
	public List<PreRestrictionInvalidReasonDetailVO> checkPreRestrictionLQInvalidReasonDetail(PreRestrictionInputVO preRestrictionInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PreRestrictionInvalidReasonDetailVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(preRestrictionInputVO != null){
				Map<String, String> mapVO = preRestrictionInputVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionLQInvalidReasonDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreRestrictionInvalidReasonDetailVO .class);
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
	 * Pre Checking Report 의 EQ 시 Regulatory 을 조회 합니다. <br>
	 * 
	 * @param PreRestrictionInputVO preRestrictionInputVO
	 * @return List<PreRestrictionRegulatoryVO>
	 * @throws DAOException
	 */
	public List<PreRestrictionRegulatoryVO> checkPreRestrictionEQRegulatory(PreRestrictionInputVO preRestrictionInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PreRestrictionRegulatoryVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(preRestrictionInputVO != null){
				Map<String, String> mapVO = preRestrictionInputVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionEQRegulatoryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreRestrictionRegulatoryVO .class);
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
	 * Pre Checking Report 의 LQ 시 InvalidReasonDetail 을 조회 합니다. <br>
	 * 
	 * @param PreRestrictionInputVO preRestrictionInputVO
	 * @return List<PreRestrictionInvalidReasonDetailVO>
	 * @throws DAOException
	 */
	public List<PreRestrictionInvalidReasonDetailVO> checkPreRestrictionEQInvalidReasonDetail(PreRestrictionInputVO preRestrictionInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PreRestrictionInvalidReasonDetailVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(preRestrictionInputVO != null){
				Map<String, String> mapVO = preRestrictionInputVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionEQInvalidReasonDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreRestrictionInvalidReasonDetailVO .class);
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
	 * Pre Checking Report 의 special provision 을 조회 합니다. <br>
	 * 
	 * @param PreRestrictionInputVO preRestrictionInputVO
	 * @return List<PreRestrictionSpclProviVO>
	 * @throws DAOException
	 */
	public List<PreRestrictionSpclProviVO> searchPreRestrictionSpclProvi(PreRestrictionInputVO preRestrictionInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PreRestrictionSpclProviVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(preRestrictionInputVO != null){
				Map<String, String> mapVO = preRestrictionInputVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionSpclProviRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreRestrictionSpclProviVO .class);
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
	 * Pre Checking Report 의 special provision 을 조회 합니다. <br>
	 * 
	 * @param PreRestrictionSpclProviVO preRestrictionSpclProviVO
	 * @return PreRestrictionSpclProviVO
	 * @throws DAOException
	 */
	public PreRestrictionSpclProviVO searchPreRestrictionSpclProviCond(PreRestrictionSpclProviVO preRestrictionSpclProviVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PreRestrictionSpclProviVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(preRestrictionSpclProviVO != null){
				Map<String, String> mapVO = preRestrictionSpclProviVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionSpclProviCondRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreRestrictionSpclProviVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.size()==0?null:list.get(0);
	}
	
	/**
	 * Subsidiary risk(s)을 조회 합니다. <br>
	 * 
	 * @param PreRestrictionInputVO preRestrictionInputVO
	 * @return String[]
	 * @throws DAOException
	 */
	 public String[] searchPreRestrictionPckPkgInstr(PreRestrictionInputVO preRestrictionInputVO) throws DAOException {
		 DBRowSet dbRowset = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{    
        	if(preRestrictionInputVO != null){
				Map<String, String> mapVO = preRestrictionInputVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionPckPkgInstrRSQL(),param, velParam);
			
			return ScgUtil.getArrayString(dbRowset, 1);
           
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }         
	}
	 
	 /**
	 * Pre Checking Report 의 PI 시 Regulatory 을 조회 합니다. <br>
	 *
	 * @param String[] vldChk 
	 * @param PreRestrictionInputVO preRestrictionInputVO
	 * @return List<PreRestrictionRegulatoryVO>
	 * @throws DAOException
	 */
	public List<PreRestrictionRegulatoryVO> checkPreRestrictionPIRegulatory(String[] vldChk, PreRestrictionInputVO preRestrictionInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PreRestrictionRegulatoryVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(preRestrictionInputVO != null){
				Map<String, String> mapVO = preRestrictionInputVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			List<String> arrVldChk = new ArrayList(); 
			if(vldChk != null && vldChk.length > 0){
				
				for(int i = 0; i < vldChk.length; i++ ){
					if ( !JSPUtil.getNull(vldChk[i]).equals("") ) {
						arrVldChk.add(vldChk[i]);
					}
				}
			}else{
				 arrVldChk.add("V");
			}
			
			param.put("vld_chk", arrVldChk);
			velParam.put("vld_chk", arrVldChk);
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionPIRegulatoryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreRestrictionRegulatoryVO .class);
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
	 * Pre Checking Report 의 LQ 시 InvalidReasonDetail 을 조회 합니다. <br>
	 * 
	 * @param String[] vldChk
	 * @param PreRestrictionInputVO preRestrictionInputVO
	 * @return List<PreRestrictionInvalidReasonDetailVO>
	 * @throws DAOException
	 */
	public List<PreRestrictionInvalidReasonDetailVO> checkPreRestrictionPIInvalidReasonDetail(String[] vldChk, PreRestrictionInputVO preRestrictionInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PreRestrictionInvalidReasonDetailVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			if(preRestrictionInputVO != null){
				Map<String, String> mapVO = preRestrictionInputVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			List<String> arrVldChk = new ArrayList(); 
			if(vldChk != null && vldChk.length > 0){
				for(int i = 0; i < vldChk.length; i++ ){
					if ( !JSPUtil.getNull(vldChk[i]).equals("") ) {
						arrVldChk.add(vldChk[i]);
					}
				}

			} else{
				 arrVldChk.add("V"); // check 내용 없을 경우
			}
			param.put("vld_chk", arrVldChk);
			velParam.put("vld_chk", arrVldChk);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionPIInvalidReasonDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreRestrictionInvalidReasonDetailVO .class);
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
	 * Pre Checking Report 의 PI 시 SppDetail 을 조회 합니다. <br>
	 * 
	 * @param PreRestrictionInputVO preRestrictionInputVO
	 * @return List<PreRestrictionSppDetailVO>
	 * @throws DAOException
	 */
	public List<PreRestrictionSppDetailVO> searchPreRestrictionpiSppDetail(PreRestrictionInputVO preRestrictionInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PreRestrictionSppDetailVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(preRestrictionInputVO != null){
				Map<String, String> mapVO = preRestrictionInputVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionSppDetailRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreRestrictionSppDetailVO .class);
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
	 * Pre Checking Report 의 Mandatory Item 을 조회 합니다. <br>
	 * 
	 * @param ScgPrnrAproRqstCgoVO scgPrnrAproRqstCgoVO
	 * @return List<PreRestrictionMtdItemVO>
	 * @throws DAOException
	 */
	public List<PreRestrictionMtdItemVO> searchPreRestrictionMtdItemList(ScgPrnrAproRqstCgoVO scgPrnrAproRqstCgoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PreRestrictionMtdItemVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgPrnrAproRqstCgoVO != null){
				Map<String, String> mapVO = scgPrnrAproRqstCgoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOPreRestrictionMtdItemListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreRestrictionMtdItemVO .class);
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
	 * Pre Checking Report 의 DG Cargo 정보를 조회 합니다. <br>
	 * 
	 * @param preRestrictionInputVO
	 * @return List<PreRestrictionInputVO>
	 * @throws DAOException
	 */
	public List<PreRestrictionInputVO> searchBkgDgCargoList(PreRestrictionInputVO preRestrictionInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<PreRestrictionInputVO>  list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(preRestrictionInputVO != null){
				Map<String, String> mapVO = preRestrictionInputVO.getInnerPreRestrictionInputVO().getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOSearchBkgDgCargoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PreRestrictionInputVO .class);
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