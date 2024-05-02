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
package com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.basic.PartnerLinesDangerousCargoApprovalBCImpl;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.PartnerApprovalRequestVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstCgoVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstFileVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrAproRqstVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.ScgPrnrRequestListOptionVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.SearchPrnrDGListVO;
import com.clt.apps.opus.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.vo.SearchPrnrScgListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS PartnerLinesDangerousCargoApprovalDBDAO <br>
 * - OPUS-CargoLoadingApproval system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author HyunUk Kim
 * @see PartnerLinesDangerousCargoApprovalBCImpl 참조
 * @since J2EE 1.6
 */
public class PartnerLinesDangerousCargoApprovalDBDAO extends DBDAOSupport { 

	/**
	 * SPCL CGO APVL for Partner Lines 를 조회 합니다. <br>
	 * 
	 * @param PartnerApprovalRequestVO partnerApprovalRequestVO
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
				
				List<String> arrSlanCd = new ArrayList(); 
				
				if ( !JSPUtil.getNull(partnerApprovalRequestVO.getSlanCd1()).equals("") ) {
					arrSlanCd.add(partnerApprovalRequestVO.getSlanCd1());
				}
				if ( !JSPUtil.getNull(partnerApprovalRequestVO.getSlanCd2()).equals("") ) {
					arrSlanCd.add(partnerApprovalRequestVO.getSlanCd2());
				}
				if ( !JSPUtil.getNull(partnerApprovalRequestVO.getSlanCd3()).equals("") ) {
					arrSlanCd.add(partnerApprovalRequestVO.getSlanCd3());
				}
				if ( !JSPUtil.getNull(partnerApprovalRequestVO.getSlanCd4()).equals("") ) {
					arrSlanCd.add(partnerApprovalRequestVO.getSlanCd4());
				}
				if ( !JSPUtil.getNull(partnerApprovalRequestVO.getSlanCd5()).equals("") ) {
					arrSlanCd.add(partnerApprovalRequestVO.getSlanCd5());
				}
				if ( !JSPUtil.getNull(partnerApprovalRequestVO.getSlanCd6()).equals("") ) {
					arrSlanCd.add(partnerApprovalRequestVO.getSlanCd6());
				}
				if ( !JSPUtil.getNull(partnerApprovalRequestVO.getSlanCd7()).equals("") ) {
					arrSlanCd.add(partnerApprovalRequestVO.getSlanCd7());
				}
				if ( !JSPUtil.getNull(partnerApprovalRequestVO.getSlanCd8()).equals("") ) {
					arrSlanCd.add(partnerApprovalRequestVO.getSlanCd8());
				}
				if ( !JSPUtil.getNull(partnerApprovalRequestVO.getSlanCd9()).equals("") ) {
					arrSlanCd.add(partnerApprovalRequestVO.getSlanCd9());
				}
				if ( !JSPUtil.getNull(partnerApprovalRequestVO.getSlanCd10()).equals("") ) {
					arrSlanCd.add(partnerApprovalRequestVO.getSlanCd10());
				}
				if ( !JSPUtil.getNull(partnerApprovalRequestVO.getSlanCd11()).equals("") ) {
					arrSlanCd.add(partnerApprovalRequestVO.getSlanCd11());
				}

				param.putAll(mapVO);
				velParam.putAll(mapVO);
		    	param.put("arr_slan_cd"   , arrSlanCd);
		    	velParam.put("arr_slan_cd", arrSlanCd);
		    	param.put("func_flg"   , partnerApprovalRequestVO.getSearchConditon("func_flg"));
		    	velParam.put("func_flg", partnerApprovalRequestVO.getSearchConditon("func_flg"));
		    	param.put("from_req_dt"   , partnerApprovalRequestVO.getSearchConditon("from_req_dt"));
		    	velParam.put("from_req_dt", partnerApprovalRequestVO.getSearchConditon("from_req_dt"));
		    	param.put("to_req_dt"   , partnerApprovalRequestVO.getSearchConditon("to_req_dt"));
		    	velParam.put("to_req_dt", partnerApprovalRequestVO.getSearchConditon("to_req_dt"));
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
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
	 * Dangerous CGO Application Details for Partner Lines 의 Booking Sequence 를 조회 합니다.(EDI) <br>
	 * 
	 * @return int
	 * @throws DAOException
	 */
//	public int searchPatnerSCGMaxSeq() throws DAOException {
//		DBRowSet dbRowset = null;
//		int maxSeq = 0;
//
//		try{
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstMaxSeqRSQL(), null, null);
//			if(dbRowset.next()) maxSeq = dbRowset.getInt(1);
//		}catch(SQLException se){
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return maxSeq;
//	}
	
	/**
	 * Dangerous CGO Application Details for Partner Lines 의 Booking Sequence 를 조회 합니다. <br>
	 * 
	 * @param ScgPrnrAproRqstVO scgPrnrAproRqstVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchPatnerSCGMaxSeq(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws DAOException {
		DBRowSet 	dbRowset 	= null;
		String 		maxSeq 		= null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
				
		try{
			if(scgPrnrAproRqstVO != null){
				Map<String, String> mapVO = scgPrnrAproRqstVO.getColumnValues();
			
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstMaxSeqRSQL(), param, null);
			if(dbRowset.next()) maxSeq = dbRowset.getString(1);
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
	 * Dangerous CGO Application Details for Partner Lines 의 Booking을  조회 합니다. <br>
	 * 
	 * @param ScgPrnrAproRqstVO scgPrnrAproRqstVO
	 * @param ScgPrnrAproRqstCgoVO scgPrnrAproRqstCgoVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchPatnerSCGCGOCount(ScgPrnrAproRqstVO scgPrnrAproRqstVO, ScgPrnrAproRqstCgoVO scgPrnrAproRqstCgoVO) throws DAOException {
		DBRowSet dbRowset = null;
		int maxSeq = 0;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();		
		try{
			if(scgPrnrAproRqstVO != null){
				Map<String, String> mapVO = scgPrnrAproRqstVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.put("cargo", "N");
			}
			if(scgPrnrAproRqstCgoVO != null){
				Map<String, String> mapVO = scgPrnrAproRqstCgoVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.put("cargo", "Y");
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoCntSQLRSQL(), param, velParam);
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
	 * @param ScgPrnrAproRqstVO scgPrnrAproRqstVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchPatnerSCGAttachMaxSeq(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws DAOException {
		DBRowSet dbRowset = null;
		String maxSeq = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(scgPrnrAproRqstVO != null){
				Map<String, String> mapVO = scgPrnrAproRqstVO .getColumnValues();
			
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstFileMaxSeqRSQL(), param, null);
			if(dbRowset.next()) maxSeq = dbRowset.getString(1);
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
	 * @param ScgPrnrAproRqstCgoVO scgPrnrAproRqstCgoVO
	 * @return List<ScgPrnrAproRqstVO>
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
	 * @param List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs
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
	 * @param ScgPrnrAproRqstVO scgPrnrAproRqstVO
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
	 * @param ScgPrnrAproRqstVO scgPrnrAproRqstVO
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
	 * @param ScgPrnrAproRqstVO scgPrnrAproRqstVO
	 * @return List<ScgPrnrAproRqstCgoVO>
	 * @throws DAOException
	 */
	public List<ScgPrnrAproRqstCgoVO> searchPatnerSCGCGO(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws DAOException {
		// 현재 BKG정보를 조회한다.
		return searchPatnerSCGCGO(scgPrnrAproRqstVO, false);
	}
	
	/**
	 * Dangerous CGO Application Details for Partner Lines 의 Cargo 를 조회 합니다. <br>
	 * 
	 * @param ScgPrnrAproRqstVO scgPrnrAproRqstVO
	 * @param boolean isBefore
	 * @return List<ScgPrnrAproRqstCgoVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ScgPrnrAproRqstCgoVO> searchPatnerSCGCGO(ScgPrnrAproRqstVO scgPrnrAproRqstVO, boolean isBefore) throws DAOException {
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
				if(isBefore) {
					velParam.put("before", "Y");
				}
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
	 * @param ScgPrnrAproRqstVO scgPrnrAproRqstVO
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
	 * @param List<ScgPrnrAproRqstVO> scgPrnrAproRqstVOs
	 * @throws DAOException
	 */
	public void addPartnerSCG(List<ScgPrnrAproRqstVO> scgPrnrAproRqstVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			if(scgPrnrAproRqstVOs.size() > 0){
				ScgPrnrAproRqstVO scgPrnrAproRqstVO = new ScgPrnrAproRqstVO();
				for(int i=0; i<scgPrnrAproRqstVOs.size(); i++){
					scgPrnrAproRqstVO = scgPrnrAproRqstVOs.get(i);
					if(!scgPrnrAproRqstVO.getSkip()) {
						Map<String, String> mapVO = scgPrnrAproRqstVO.getColumnValues();
						param.putAll(mapVO);
						int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstVOCSQL(), param, null);
						
						if(insCnt== Statement.EXECUTE_FAILED) {
							throw new DAOException("Fail to insert No"+ i + " SQL");
						}
					}
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
	 * @param List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs
	 * @throws DAOException
	 */
	public void addPartnerSCGCGO(List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			if(scgPrnrAproRqstCgoVOs.size() > 0){
				ScgPrnrAproRqstCgoVO scgPrnrAproRqstCgoVO = new ScgPrnrAproRqstCgoVO();
				for(int i=0; i<scgPrnrAproRqstCgoVOs.size(); i++){
					scgPrnrAproRqstCgoVO = scgPrnrAproRqstCgoVOs.get(i);
					//if(!scgPrnrAproRqstCgoVO.getSkip()) {
						Map<String, String> mapVO = scgPrnrAproRqstCgoVO.getColumnValues();
						param.putAll(mapVO);
						int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoVOCSQL(), param, null);
						if(insCnt== Statement.EXECUTE_FAILED) {
							throw new DAOException("Fail to insert No"+ i + " SQL");
						}
					//}
				}
				
//				insCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoVOCSQL(), scgPrnrAproRqstCgoVOs, null);
//				for(int i = 0; i < insCnt.length; i++){
//					if(insCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
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
	 * @param List<ScgPrnrAproRqstFileVO> scgPrnrAproRqstFileVOs
	 * @throws DAOException
	 */
	public void addPartnerSCGAttach(List<ScgPrnrAproRqstFileVO> scgPrnrAproRqstFileVOs) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(scgPrnrAproRqstFileVOs.size() > 0){
				
				ScgPrnrAproRqstFileVO scgPrnrAproRqstFileVO = new ScgPrnrAproRqstFileVO();
				
				for(int i=0; i<scgPrnrAproRqstFileVOs.size(); i++){
					scgPrnrAproRqstFileVO = scgPrnrAproRqstFileVOs.get(i);
					Map<String, String> mapVO = scgPrnrAproRqstFileVO.getColumnValues();
					
					param.putAll(mapVO);

					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstFileVOCSQL(), param, null);
					
					if(insCnt== Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}	
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
	 * @param List<ScgPrnrAproRqstVO> scgPrnrAproRqstVOs
	 * @throws DAOException
	 */
	public void modifyPartnerSCGLstFlg(List<ScgPrnrAproRqstVO> scgPrnrAproRqstVOs) throws DAOException,Exception {
		
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			ScgPrnrAproRqstVO scgPrnrAproRqstVO = new ScgPrnrAproRqstVO();
			for(int i=0; i<scgPrnrAproRqstVOs.size(); i++){
				scgPrnrAproRqstVO = scgPrnrAproRqstVOs.get(i);
				//if(!scgPrnrAproRqstVO.getSkip()) {
					Map<String, String> mapVO = scgPrnrAproRqstVO.getColumnValues();
					param.putAll(mapVO);
					int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstVOUSQL(), param, velParam);
					if(insCnt== Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to insert No"+ i + " SQL");
					}
				//}
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
	 * @param List<ScgPrnrAproRqstVO> scgPrnrAproRqstVOs
	 * @throws DAOException
	 */
	public void modifyPartnerEdiSCG(List<ScgPrnrAproRqstVO> scgPrnrAproRqstVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgPrnrAproRqstVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrEdiAproRqstVOUSQL(), scgPrnrAproRqstVOs,null);
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
	 * @param List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs
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
	 * SPCL CGO APVL for Partner Lines 의 Cargo 를 일괄적으로 수정 합니다. <br>
	 * 
	 * @param ScgPrnrAproRqstCgoVO scgPrnrAproRqstCgoVO
	 * @throws DAOException
	 */
	public void modifyPartnerSCGCGO(ScgPrnrAproRqstCgoVO scgPrnrAproRqstCgoVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			if(scgPrnrAproRqstCgoVO!=null){
				Map<String, String> mapVO = scgPrnrAproRqstCgoVO.getColumnValues();
				param.putAll(mapVO);
				int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoVOUSQL(), param, velParam);
				if(insCnt== Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to insert" + " SQL");
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
	 * SPCL CGO APVL for Partner Lines 의 Approval Reference No. 을 Booking 단위로 수정 합니다. <br>
	 * 
	 * @param ScgPrnrAproRqstCgoVO scgPrnrAproRqstCgoVOs
	 * @throws DAOException
	 */
	public void modifyPartnerScgPrnrAproRefNo(ScgPrnrAproRqstCgoVO scgPrnrAproRqstCgoVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String , String> paramMap = scgPrnrAproRqstCgoVOs.getColumnValues();
			Map<String, Object> velParam = new HashMap<String, Object>();

			int result = sqlExe.executeUpdate((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOmodifyScgPrnrAproRefNoUSQL(), paramMap, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modifySCGApprovalS SQL");
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
	 * @param List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs
	 * @throws DAOException
	 */
	public void modifyPartnerEdiSCGCGO(List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(scgPrnrAproRqstCgoVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrEdiAproRqstCgoVOUSQL(), scgPrnrAproRqstCgoVOs,null);
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
	 * @param List<ScgPrnrAproRqstFileVO> scgPrnrAproRqstFileVOs
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
	 * @param List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs
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
	 * @param List<ScgPrnrAproRqstVO> scgPrnrAproRqstVOs
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
	 * SPCL CGO APVL for Partner Lines 의 Booking 을 일괄적으로 삭제 합니다. <br>

	 * @param List<ScgPrnrAproRqstVO> scgPrnrAproRqstVOs
	 * @throws DAOException
	 */
	public void removePartnerEdiSCG(List<ScgPrnrAproRqstVO> scgPrnrAproRqstVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgPrnrAproRqstVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOremovePartnerEdiSCGDSQL(), scgPrnrAproRqstVOs,null);
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
	 * Dangerous CGO Application Details for Partner Lines 의 Cargo 를 일괄적으로 삭제 합니다. <br>
	 * 
	 * @param List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs
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
	 * SPCL CGO APVL for Partner Lines 에서 Booking 정보 삭제 시, 속한 Cargo 를 일괄적으로 모두 삭제 합니다. <br>
	 * 
	 * @param List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs
	 * @throws DAOException
	 */
	public void removePartnerSCGCGOAll(List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgPrnrAproRqstCgoVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoAllDSQL(), scgPrnrAproRqstCgoVOs,null);
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
	 * @param List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs
	 * @throws DAOException
	 */
	public void removePartnerEdiSCGCGO(List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgPrnrAproRqstCgoVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrEdiAproRqstCgoVODSQL(), scgPrnrAproRqstCgoVOs,null);
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
	 * SPCL CGO APVL for Partner Lines 의 SCG_PRNR_APRO_RQST LST_RQST_DAT_FLG상태를 'N' 변경한다.  <br>                                                                                     
	 *                                                                                                                                                                                      
	 * @param ScgPrnrAproRqstVO scgPrnrAproRqstVO                                                                                                                                           
	 * @throws DAOException                                                                                                                                                                 
	 */                                                                                                                                                                                     
	public void modifyScgPrnrAproLstRqstDatFlg(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws DAOException {                                                                                   
		                                                                                                                                                                                
		//query parameter                                                                                                                                                               
		Map<String, Object> param = new HashMap<String, Object>();                                                                                                                      
                                                                                                                                                                                                
		try{	                                                                                                                                                                        
			                                                                                                                                                                        
			if(scgPrnrAproRqstVO != null){                                                                                                                                          
                                                                                                                                                                                                
				SQLExecuter sqlExe = new SQLExecuter("");                                                                                                                       
				param.putAll(scgPrnrAproRqstVO.getColumnValues());                                                                                                              
				                                                                                                                                                                
				int result = sqlExe.executeUpdate((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrEdiLstRqstDatFlgVOUSQL(), param, null);                       
				if(result == Statement.EXECUTE_FAILED)                                                                                                                          
						throw new DAOException("Fail to modifyErrTrsmHdr SQL");                                                                                         
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
	 * @param List<ScgPrnrAproRqstFileVO> scgPrnrAproRqstFileVOs
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
	 * SPCL CGO APVL for Partner Lines 의 File 을 일괄적으로 삭제 합니다. <br>
	 * 
	 * @param List<ScgPrnrAproRqstFileVO> scgPrnrAproRqstFileVOs
	 * @throws DAOException
	 */ 
	public void removePartnerSCGAttachAll(List<ScgPrnrAproRqstFileVO> scgPrnrAproRqstFileVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(scgPrnrAproRqstFileVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstFileAllDSQL(), scgPrnrAproRqstFileVOs,null);
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
	 * DG Ref. No. Duplication Check <br>
	 * 
	 * @param ScgPrnrAproRqstVO ScgPrnrAproRqstVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchPatnerDcgoRefNo(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws DAOException {
		DBRowSet dbRowset = null;
		String count = "0";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if(scgPrnrAproRqstVO != null){
				Map<String, String> mapVO = scgPrnrAproRqstVO .getColumnValues();
			
				param.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproDcgoRefNoRSQL(), param, null);
			if(dbRowset.next()) count = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return count;
	}
	
	/**
	 * BKG Ref. No. Duplication Check <br>
	 * @param ScgPrnrAproRqstVO ScgPrnrAproRqstVO
	 * @param PartnerApprovalRequestVO partnerApprovalRequestVO
	 * @return String 
	 * @throws DAOException
	 */
	public String searchPatnerBkgRefNo(ScgPrnrAproRqstVO scgPrnrAproRqstVO, PartnerApprovalRequestVO partnerApprovalRequestVO) throws DAOException {
		DBRowSet dbRowset = null;
		String count = "0";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			if(scgPrnrAproRqstVO != null){
				Map<String, String> mapVO = scgPrnrAproRqstVO.getColumnValues();
				param.putAll(mapVO);
			}
			if(partnerApprovalRequestVO != null){
				Map<String, String> mapVO = partnerApprovalRequestVO.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproBkgRefNoRSQL(), param, null);
			if(dbRowset.next()) count = dbRowset.getString(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return count;
	}
	
	/**
	 * Application Request & Approval Status For Partner Lines의 List를 조회 합니다. <br>
	 * 
	 * @param ScgPrnrRequestListOptionVO scgPrnrRequestListOptionVO
	 * @return SearchPrnrScgListVO
	 * @throws DAOException
	 */
	public SearchPrnrScgListVO searchScgApprovalStatusList(ScgPrnrRequestListOptionVO scgPrnrRequestListOptionVO) throws DAOException {
		DBRowSet dbRowset = null;
		SearchPrnrScgListVO  list = new SearchPrnrScgListVO();
		List<SearchPrnrDGListVO>  list1 = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(scgPrnrRequestListOptionVO != null){
				Map<String, String> mapVO = scgPrnrRequestListOptionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				if (scgPrnrRequestListOptionVO.getScgFlg().equals("DG")) {
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOSearchDGApprovalStatusListRSQL(), param, velParam);
					list1 = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPrnrDGListVO .class);
					list.setSearchPrnrDGListVO(list1);
				}
			}
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
	 * SPCL CGO APVL for Partner BKG의 메일전송 결과를 저장 합니다. <br>
	 * 
	 * @param ScgPrnrAproRqstVO scgPrnrAproRqstVO
	 * @throws DAOException
	 */
	public void modifyPartnerSCGApprovalMail(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			if(scgPrnrAproRqstVO != null){
				Map<String, String> mapVO = scgPrnrAproRqstVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgApprovalMailUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to modifySCGApprovalMail SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}	
	
	/**
	 * Dangerous CGO Application Details for Partner Lines 의 request정보를 조회 합니다. <br>
	 * 
	 * @param ScgPrnrAproRqstVO scgPrnrAproRqstVO
	 * @return int
	 * @throws DAOException
	 */
	public int searchPartnerSCGRequest(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws DAOException {
		DBRowSet dbRowset = null;
		int count = 0;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
				
		try{
			if(scgPrnrAproRqstVO != null){
				Map<String, String> mapVO = scgPrnrAproRqstVO .getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstRSQL(), param, null);
			if(dbRowset.next()) count = dbRowset.getInt(1);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return count;
	}
	
	/**
	 * 시퀀스 SCG_PRNR_CGO_RQST_SEQ.NEXTVAL를 조회 합니다. <br>
	 * @return String
	 * @throws DAOException
	 */
	public String searchMaxScgPrnrCgoRqstSeq() throws DAOException {
		DBRowSet dbRowset = null;
		String maxSeq = null;	
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOMaxScgPrnrCgoRqstSeqRSQL(), null, null);
			if(dbRowset.next()) maxSeq = dbRowset.getString(1);
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
		 * Dangerous CGO Application Details for Partner Lines 의 Cargo Sequence 를 조회 합니다. <br>
		 * 
		 * @param scgPrnrAproRqstVO ScgPrnrAproRqstVO
		 * @return String
		 * @throws DAOException
		 */
		public String makeSpclAproRefNo(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws DAOException {
			DBRowSet dbRowset = null;
			String aproRefNo = "";
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
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrAproRqstCgoAproNoRSQL(), param, velParam);
				if(dbRowset.next()) aproRefNo = dbRowset.getString(1);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return aproRefNo;
		}
		
		
		//2015-12-22
		/**
		 * Dangerous CGO Application Details for Partner Lines 에서 Insert/Update를 구분 합니다. <br>
		 * 
		 * @param ScgPrnrAproRqstVO scgPrnrAproRqstVO
		 * @return PartnerApprovalRequestVO
		 * @throws DAOException
		 */
		public PartnerApprovalRequestVO searchScgAuthStsCd(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws DAOException {
			DBRowSet dbRowset = null;
			PartnerApprovalRequestVO vo = new PartnerApprovalRequestVO();
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			
			//velocity parameter
			//Map<String, Object> velParam = new HashMap<String, Object>();
					
			try{
				if(scgPrnrAproRqstVO != null){
					Map<String, String> mapVO = scgPrnrAproRqstVO .getColumnValues();
					param.putAll(mapVO);
					//velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDAOScgAuthStsCdVORSQL(), param, null);
				if(dbRowset.next()){
					vo.setUpdIndicator	(dbRowset.getString("UPD_INDICATOR"));
					vo.setSpclCgoRqstSeq(dbRowset.getString("SPCL_CGO_RQST_SEQ"));
					vo.setPrnrCgoRqstSeq(dbRowset.getString("PRNR_CGO_RQST_SEQ"));
					vo.setAuthStsCd		(dbRowset.getString("AUTH_STS_CD"));
				}
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return vo;
		}
		

		/**
		 * SPCL CGO APVL for Partner Lines 의 Booking 을 일괄적으로 수정 합니다. <br>
		 * 
		 * @param scgPrnrAproRqstVOs List<ScgPrnrAproRqstVO>
		 * @param boolean skip
		 * @throws DAOException
		 */
		public void modifyPartnerSCGApvl(List<ScgPrnrAproRqstVO> scgPrnrAproRqstVOs, boolean skip) throws DAOException,Exception {
			
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				ScgPrnrAproRqstVO scgPrnrAproRqstVO = new ScgPrnrAproRqstVO();
				for(int i=0; i<scgPrnrAproRqstVOs.size(); i++){
					scgPrnrAproRqstVO = scgPrnrAproRqstVOs.get(i);
						Map<String, String> mapVO = scgPrnrAproRqstVO.getColumnValues();
						param.putAll(mapVO);
						int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOmodifyScgAPVLStatusUSQL(), param, velParam);
						if(insCnt== Statement.EXECUTE_FAILED) {
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
		 * SCG_PRNR_RQST_UNMAP CORR Data Update <br>
		 * 
		 * @param ScgPrnrAproRqstVO scgPrnrAproRqstVO
		 * @exception DAOException
		 */
		public void modifyScgPrnrRqstUnmap(ScgPrnrAproRqstVO scgPrnrAproRqstVO) throws DAOException {
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

			try{	

				if(scgPrnrAproRqstVO != null){

					SQLExecuter sqlExe = new SQLExecuter("");
					param.putAll(scgPrnrAproRqstVO.getColumnValues());
					
					int result = sqlExe.executeUpdate((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrRqstUnmapCorrUSQL(), param, null);
					if(result == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to modifyErrTrsmHdr SQL");
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
		 * SCG_PRNR_RQST_CGO_UNMAP CORR Data Update  <br>
		 * 
		 * @param ScgPrnrAproRqstCgoVO scgPrnrAproRqstCgoVO
		 * @throws DAOException
		 */
		public void modifyScgPrnrRqstCgoUnmap(ScgPrnrAproRqstCgoVO scgPrnrAproRqstCgoVO) throws DAOException {
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();

			try{	

				if(scgPrnrAproRqstCgoVO != null){

					SQLExecuter sqlExe = new SQLExecuter("");
					param.putAll(scgPrnrAproRqstCgoVO.getColumnValues());
					
					int result = sqlExe.executeUpdate((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOScgPrnrRqstCgoUnmapCorrUSQL(), param, null);
					if(result == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to modifyScgPrnrRqstUnmap SQL");
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
		 * Dangerous CGO Application Details for Partner Lines 의 Cargo 전체 승인 여부를  조회 합니다. <br>
		 *    
		 * @param ScgPrnrAproRqstCgoVO scgPrnrAproRqstCgoVOs
		 * @return String
		 * @throws DAOException
		 */
		public String searchAllApprovedCgo(ScgPrnrAproRqstCgoVO scgPrnrAproRqstCgoVOs) throws DAOException {
			DBRowSet dbRowset = null;
			String  allAproStsCd= "";

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			Map<String, Object> velParam = new HashMap<String, Object>();		
			try{
	
				if(scgPrnrAproRqstCgoVOs != null){
					Map<String, String> mapVO = scgPrnrAproRqstCgoVOs .getColumnValues();
					
					param.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOSearchApprovedAllCargoRSQL(), param, velParam);
				if(dbRowset.next()) allAproStsCd = dbRowset.getString(1);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return allAproStsCd;
		}


		/**
		 * SPCL CGO APVL for Partner Lines 에서  Container Number 를 업데이트 합니다. <br>
		 *   
		 * @param List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs
		 * @throws DAOException
		 */
		public void modifyPartnerCntrNm(List<ScgPrnrAproRqstCgoVO> scgPrnrAproRqstCgoVOs) throws DAOException,Exception {
			
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				ScgPrnrAproRqstCgoVO scgPrnrAproRqstCgoVO = new ScgPrnrAproRqstCgoVO();
				for(int i=0; i<scgPrnrAproRqstCgoVOs.size(); i++){
					scgPrnrAproRqstCgoVO = scgPrnrAproRqstCgoVOs.get(i);
						Map<String, String> mapVO = scgPrnrAproRqstCgoVO.getColumnValues();
						param.putAll(mapVO);
						int insCnt = sqlExe.executeUpdate((ISQLTemplate)new PartnerLinesDangerousCargoApprovalDBDAOmodifyPartnerCntrNmUSQL(), param, velParam);
						if(insCnt== Statement.EXECUTE_FAILED) {
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