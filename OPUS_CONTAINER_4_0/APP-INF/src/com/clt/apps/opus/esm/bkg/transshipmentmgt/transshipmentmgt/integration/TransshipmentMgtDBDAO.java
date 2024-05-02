/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransshipmentMgtDBDAO.java
*@FileTitle : VVD Discharging Yard
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.05.18 최영희
* 1.0 Creation
* --------------------------------------------------------
* HISTORY
* 2011.01.11 이일민 [] 1월 6일자 R4J 관련 수정
=========================================================*/
package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.basic.TransshipmentMgtBCImpl;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgListForPortAssignInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgListForPortAssignVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgRouteForPortAssignVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgVslDchgYdInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.CntrSumByPodVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.FormerVvdSkdVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.FormerVvdVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.NextVvdAssignInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.NextVvdVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.RlyVslGrpAssignInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.RlyVslGrpAssignVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.SearchCondForPortAssignVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.SendTsListVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSListBy1st2ndVVDListInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSListBy1st2ndVVDListVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSRemainListInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSRemainSumVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSRemianListVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TSSummaryVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TsVvdFor1st2ndInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VslDchgYdListVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VslOopInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VslOopInqVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VvdAssignTargetBkgVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VvdAssignTargetVvdVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VvdDetailForPortAssignVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgTsRmkVO;
import com.clt.syscommon.common.table.BkgVslDchgYdVO;
import com.clt.syscommon.common.table.BkgVslOopVO;
import com.clt.syscommon.common.table.BkgVslOpCrrCdVO;
import com.clt.syscommon.common.table.BkgVvdVO;
import com.clt.syscommon.common.table.MdmYardVO;


/**
 * OPUS TransshipmentMgtDBDAO <br>
 * - OPUS-TransshipmentMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Choi Yeoung Hee
 * @see TransshipmentMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class TransshipmentMgtDBDAO extends DBDAOSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -669116469171733905L;

	/**
	 * bkg_vsl_op_crr_cd 테이블에 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param List<BkgVslOpCrrCdVO> insModels
	 * @exception DAOException
	 */
	public void addBkgVslOpCrrCdS(List<BkgVslOpCrrCdVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TransshipmentMgtDBDAOaddBkgVslOpCrrCdCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("TES00091",new String[]{String.valueOf(i)}).getMessage());
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * bkg_vsl_op_crr_cd 테이블에 다건의 데이터를 일괄적으로 갱신한다.<br> 
	 * 
	 * @param List<BkgVslOpCrrCdVO> updModels
	 * @exception DAOException
	 */
	public void modifyBkgVslOpCrrCdS(List<BkgVslOpCrrCdVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TransshipmentMgtDBDAOmodifyBkgVslOpCrrCdUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("TES00091",new String[]{String.valueOf(i)}).getMessage());
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * bkg_vsl_op_crr_cd 테이블에 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param  List<BkgVslOpCrrCdVO> delModels
	 * @exception DAOException
	 */
	public void removeBkgVslOpCrrCdS(List<BkgVslOpCrrCdVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TransshipmentMgtDBDAOremoveBkgVslOpCrrCdDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("TES00091",new String[]{String.valueOf(i)}).getMessage());
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
//	/**
//	 * bkg_vsl_op_crr_cd 테이블에 단건의 데이터를 삭제한다.<br>
//	 * 
//	 * @param  BkgVslOpCrrCdVO vo
//	 * @return int
//	 * @exception DAOException
//	 */
//	public int removeBkgVslOpCrrCd(BkgVslOpCrrCdVO vo) throws DAOException,Exception {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		int result = 0;
//		try {
//			Map<String, String> mapVO = vo.getColumnValues();
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate)new TransshipmentMgtDBDAOremoveBkgVslOpCrrCdDSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException(new ErrorHandler("BKG01153").getMessage());
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(),se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
//		}
//		return result;
//	}
	
//	/**
//	 * bkg_vsl_op_crr_cd 테이블에 단건의 데이터를 갱신한다.<br>
//	 * 
//	 * @param BkgVslOpCrrCdVO vo
//	 * @return int
//	 * @exception DAOException
//	 */
//	public int modifyBkgVslOpCrrCd(BkgVslOpCrrCdVO vo) throws DAOException,Exception {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		int result = 0;
//		try {
//			Map<String, String> mapVO = vo.getColumnValues();
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate)new TransshipmentMgtDBDAOmodifyBkgVslOpCrrCdUSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException(new ErrorHandler("BKG01153").getMessage());
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(),se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
//		}
//		return result;
//	}
	
//	/**
//	 * bkg_vsl_op_crr_cd 테이블에 단건의 데이터를 생성한다.<br>
//	 * 
//	 * @param BkgVslOpCrrCdVO vo
//	 * @exception DAOException
//	 */
//	public void addBkgVslOpCrrCd(BkgVslOpCrrCdVO vo) throws DAOException,Exception {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		try {
//			Map<String, String> mapVO = vo.getColumnValues();
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int result = sqlExe.executeUpdate((ISQLTemplate)new TransshipmentMgtDBDAOaddBkgVslOpCrrCdCSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException(new ErrorHandler("BKG01153").getMessage());
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(),se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
//		}
//	}	
	
//	/**
//	 * bkg_vsl_oop 테이블에 다건의 데이터를 일괄적으로 생성한다.<br>
//	 * 
//	 * @param  List<BkgVslOopVO> insModels 
//	 * @exception DAOException
//	 */
//	public void addBkgVslOopS(List<BkgVslOopVO> insModels) throws DAOException,Exception {
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int insCnt[] = null;
//			if(insModels.size() > 0){
//				insCnt = sqlExe.executeBatch((ISQLTemplate)new TransshipmentMgtDBDAOaddBkgVslOopCSQL(), insModels,null);
//				for(int i = 0; i < insCnt.length; i++){
//					if(insCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException(new ErrorHandler("TES00091",new String[]{String.valueOf(i)}).getMessage());
//				}
//			}
//		} catch (SQLExceptio se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(),se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
//		}
//	}
//	/**
//	 * bkg_vsl_oop테이블에 다건의 데이터를 일괄적으로 갱신한다.<br>
//	 * 
//	 * @param List<BkgVslOopVO> updModels
//	 * @exception DAOException
//	 */
//	public void modifyBkgVslOopS(List<BkgVslOopVO> updModels) throws DAOException,Exception {
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int updCnt[] = null;
//			if(updModels.size() > 0){
//				updCnt = sqlExe.executeBatch((ISQLTemplate)new TransshipmentMgtDBDAOmodifyBkgVslOopUSQL(), updModels,null);
//				for(int i = 0; i < updCnt.length; i++){
//					if(updCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException(new ErrorHandler("TES00091",new String[]{String.valueOf(i)}).getMessage());
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(),se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
//		}
//	}
	
	/**
	 * bkg_vsl_oop테이블에 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param  BkgVslOopVO bkgVslOopVO
	 * @exception DAOException
	 */
	public void removeBkgVslOop(BkgVslOopVO bkgVslOopVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgVslOopVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TransshipmentMgtDBDAOremoveBkgVslOopDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("BKG01153").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
//	/**
//	 * bkg_vsl_oop테이블에 다건의 데이터를 일괄적으로 삭제한다.<br>
//	 * 
//	 * @param  List<BkgVslOopVO> delModels
//	 * @exception DAOException
//	 */
//	public void removeBkgVslOopS(List<BkgVslOopVO> delModels) throws DAOException,Exception {
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int delCnt[] = null;
//			if(delModels.size() > 0){
//				delCnt = sqlExe.executeBatch((ISQLTemplate)new TransshipmentMgtDBDAOremoveBkgVslOopDSQL(), delModels,null);
//				for(int i = 0; i < delCnt.length; i++){
//					if(delCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException(new ErrorHandler("TES00091",new String[]{String.valueOf(i)}).getMessage());
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(),se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
//		}
//	}
  
	
//	/**
//	 * bkg_vsl_oop테이블에 단건의 데이터를 삭제한다. <br>
//	 * 
//	 * @param BkgVslOopVO vo
//	 * @return int
//	 * @exception DAOException
//	 */
//	public int removeBkgVslOop(BkgVslOopVO vo) throws DAOException,Exception {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		int result = 0;
//		try {
//			Map<String, String> mapVO = vo.getColumnValues();
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate)new TransshipmentMgtDBDAOremoveBkgVslOopDSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException(new ErrorHandler("BKG01153").getMessage());
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(),se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
//		}
//		return result;
//	}
	
	/**
	 * bkg_vsl_oop 테이블에 단건의 데이터를 갱신한다. <br>
	 * 
	 * @param BkgVslOopVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyBkgVslOop(BkgVslOopVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			 
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransshipmentMgtDBDAOmodifyBkgVslOopUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException(new ErrorHandler("BKG01153").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}
	
	/**
	 * bkg_vsl_oop 테이블에 단건의 데이터를 생성한다.<br>
	 * 
	 * @param  BkgVslOopVO vo
	 * @exception DAOException
	 */
	public void addBkgVslOop(BkgVslOopVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TransshipmentMgtDBDAOaddBkgVslOopCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException(new ErrorHandler("BKG01153").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * bkg_vsl_oop를 조회한다.<br>
	 * 
	 * @param InputVO inputVO
	 * @return List<VslOopInqVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VslOopInqVO> searchVslOopMatch(VslOopInputVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VslOopInqVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(inputVO != null){
				Map<String, String> mapVO = inputVO.getColumnValues();
			    
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransshipmentMgtDBDAOsearchVslOopMatchRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VslOopInqVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * bkg_vsl_op_crr_cd를 조회한다.<br>
	 * 
	 * @return List<BkgVslOpCrrCdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgVslOpCrrCdVO> searchOopCode() throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgVslOpCrrCdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransshipmentMgtDBDAOsearchOopCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgVslOpCrrCdVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	
	/**
	 * 조회 조건에 맞는 yard list를 조회한다.<br>
	 * 
	 * @param  BkgVslDchgYdInputVO bkgVslDchgYdInputVO
	 * @return List<MdmYardVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmYardVO> searchVslDischargingYard(BkgVslDchgYdInputVO bkgVslDchgYdInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmYardVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgVslDchgYdInputVO != null){
				Map<String, String> mapVO = bkgVslDchgYdInputVO .getColumnValues();
			    
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransshipmentMgtDBDAOsearchDischargingYardRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmYardVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * 조회 조건에 맞는 vessel schedule과 지정되어 있는 crn, uvi no를 조회한다.<br>
	 * 
	 * @param  BkgVslDchgYdInputVO bkgVslDchgYdInputVO
	 * @return List<VslDchgYdListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<VslDchgYdListVO> searchVslDischarging(BkgVslDchgYdInputVO bkgVslDchgYdInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VslDchgYdListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgVslDchgYdInputVO != null){
				Map<String, String> mapVO = bkgVslDchgYdInputVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
//				if (!bkgVslDchgYdInputVO.getVpsPortCds().equals("")){
//					velParam.put("vps_port_cd_list",setparam_In(bkgVslDchgYdInputVO.getVpsPortCds(),"|"));
//				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransshipmentMgtDBDAOsearchVslDischargingRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VslDchgYdListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
   /**
	 * bkg_vsl_dchg_yd 테이블에 단건의 데이터를 생성한다.<br> 
	 * 
	 * @param  BkgVslDchgYdVO vo
	 * @exception DAOException
	 */
	public void addVslDchgYd(BkgVslDchgYdVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TransshipmentMgtDBDAOaddBkgVslDchgYdCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException(new ErrorHandler("BKG01153").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * bkg_vsl_dchg_yd 테이블에 단건의 데이터를 갱신한다.<br>
	 * 
	 * @param BkgVslDchgYdVO vo
	 * @return int
	 * @exception DAOException
	 */
	public int modifyVslDchgYd(BkgVslDchgYdVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransshipmentMgtDBDAOmodifyBkgVslDchgYdUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException(new ErrorHandler("BKG01153").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}
	
//	/**
//	 * BKG_VSL_DCHG_YD 테이블에 단건의 데이터를 삭제한다.<br>
//	 * 
//	 * @param  BkgVslDchgYdVO vo
//	 * @return int
//	 * @exception DAOException
//	 */
//	public int removeVslDchgYd(BkgVslDchgYdVO vo) throws DAOException,Exception {
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//		
//		int result = 0;
//		try {
//			Map<String, String> mapVO = vo.getColumnValues();
//			
//			param.putAll(mapVO);
//			velParam.putAll(mapVO);
//			
//			SQLExecuter sqlExe = new SQLExecuter("");
//			result = sqlExe.executeUpdate((ISQLTemplate)new TransshipmentMgtDBDAOremoveBkgVslDchgYdDSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED)
//					throw new DAOException(new ErrorHandler("BKG01153").getMessage());
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(),se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
//		}
//		return result;
//	}

	/**
	 * bkg_vsl_dchg_yd 테이블에 다건의 데이터를 일괄적으로 생성한다.<br>
	 * 
	 * @param  List<BkgVslDchgYdVO> insModels
	 * @exception DAOException
	 */
	public void addVslDchgYdS(List<BkgVslDchgYdVO> insModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TransshipmentMgtDBDAOaddBkgVslDchgYdCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("TES00091",new String[]{String.valueOf(i)}).getMessage());
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
//	/**
//	 * bkg_vsl_dchg_yd 테이블에 다건의 데이터를 일괄적으로 갱신한다.<br>
//	 * 
//	 * @param  List<BkgVslDchgYdVO> updModels
//	 * @exception DAOException
//	 */
//	public void modifyVslDchgYdS(List<BkgVslDchgYdVO> updModels) throws DAOException,Exception {
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int updCnt[] = null;
//			if(updModels.size() > 0){
//				updCnt = sqlExe.executeBatch((ISQLTemplate)new TransshipmentMgtDBDAOmodifyBkgVslDchgYdUSQL(), updModels,null);
//				for(int i = 0; i < updCnt.length; i++){  
//					if(updCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException(new ErrorHandler("TES00091",new String[]{String.valueOf(i)}).getMessage());
//				}
//			}
//		} catch (SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage(),se);
//		}catch(Exception ex){
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
//		}
//	}
	
	/**
	 * BKG_VSL_DCHG_YD 테이블에 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @param  List<BkgVslDchgYdVO> delModels
	 * @exception DAOException
	 */
	public void removeVslDchgYdS(List<BkgVslDchgYdVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TransshipmentMgtDBDAOremoveBkgVslDchgYdDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("TES00091",new String[]{String.valueOf(i)}).getMessage());
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
  
	/**
	 * IN Query 사용시 조합<br>
	 * 
	 * @param String strParam
	 * @param String strIterator
	 * @return ArrayList<String>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	private ArrayList<String> setparam_In(String strParam, String strIterator) throws EventException {
		try {
			 //ArrayList list = new ArrayList();
			 
			 ArrayList<String> arrString = new ArrayList();
			 StringTokenizer st = new StringTokenizer(strParam, strIterator);
			 
			 while (st.hasMoreTokens()) {
				 arrString.add(st.nextToken());
			 }
		 
			return arrString;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * t/s port에서 next vessel이 재지정 되지 않고 port에 머물러 있는 booking들을 조회한다.<br>
     * 신규화면이며 long staying을 막기 위해 사용한다.<br>
	 * 
	 * @param  TSRemainListInputVO tSRemainListInputVO
	 * @return List<TSRemianListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TSRemianListVO> searchTSRemainList(TSRemainListInputVO tSRemainListInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TSRemianListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(tSRemainListInputVO != null){
				Map<String, String> mapVO = tSRemainListInputVO.getColumnValues();
			    
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				if (!tSRemainListInputVO.getCnmvStsCds().equals("")){
					velParam.put("cnmv_sts_cd_list",setparam_In(tSRemainListInputVO.getCnmvStsCds(),"|"));
				}
				if (!tSRemainListInputVO.getCntrTpszCds().equals("")){
					velParam.put("cntr_tpsz_cd_list",setparam_In(tSRemainListInputVO.getCntrTpszCds(),"|"));
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransshipmentMgtDBDAOsearchTSRemainListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TSRemianListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * 전달받은 location에 전달받은 날짜를 기준으로 cnmv_sts_cd가 'TS', 'TN'인 container들을<br>
     * type/size, cargo type별로 합계를 내서 조회한다.<br>
	 * 
	 * @param  TSRemainListInputVO tSRemainListInputVO
	 * @return List<TSRemainSumVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TSRemainSumVO> searchTSRemainSumByLoc(TSRemainListInputVO tSRemainListInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TSRemainSumVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = tSRemainListInputVO.getColumnValues();
		    
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			if (!tSRemainListInputVO.getCnmvStsCds().equals("")){
				velParam.put("cnmv_sts_cd_list",setparam_In(tSRemainListInputVO.getCnmvStsCds(),"|"));
			}
			if (!tSRemainListInputVO.getCntrTpszCds().equals("")){
				velParam.put("cntr_tpsz_cd_list",setparam_In(tSRemainListInputVO.getCntrTpszCds(),"|"));
			}
			 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransshipmentMgtDBDAOBkgBookingVsearchTSRemainSumByLocRSQL(), param, velParam);
		   
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TSRemainSumVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * t/s port를 기준으로 booking들의 입항 vessel과 출항 vessel을 조회한다.<br>
	 *  
	 * @param  TSListBy1st2ndVVDListInputVO tSListBy1st2ndVVDListInputVO
	 * @return List<TSListBy1st2ndVVDListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TSListBy1st2ndVVDListVO> searchTSListBy1st2ndVVDList(TSListBy1st2ndVVDListInputVO tSListBy1st2ndVVDListInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TSListBy1st2ndVVDListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(tSListBy1st2ndVVDListInputVO != null){
				Map<String, String> mapVO = tSListBy1st2ndVVDListInputVO.getColumnValues();
			    
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				 
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransshipmentMgtDBDAOsearchTSListBy1st2ndVVDListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TSListBy1st2ndVVDListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	} 
	
	/**
	 * vvd를 drop down으로 조회한다.<br>
	 * 
	 * @param  TsVvdFor1st2ndInputVO tsVvdFor1st2ndInputVO
	 * @return List<BkgComboVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgComboVO> searchTSVvdFor1st2nd(TsVvdFor1st2ndInputVO tsVvdFor1st2ndInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgComboVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(tsVvdFor1st2ndInputVO != null){
				Map<String, String> mapVO = tsVvdFor1st2ndInputVO.getColumnValues();
			    
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				 
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransshipmentMgtDBDAOsearchTSVvdFor1st2ndRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgComboVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	} 
	
	/**
	 * 메일 내용에 들어가는 POD별 컨테이너 VOLUMN 표시<br>
     * 
	 * @param  SendTsListVO sendTsListVO
	 * @return List<CntrSumByPodVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CntrSumByPodVO> searchCntrSumByPod (SendTsListVO sendTsListVO)throws DAOException {
		DBRowSet dbRowset = null;
		List<CntrSumByPodVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 
		try{
			if(sendTsListVO != null){
				Map<String, String> mapVO = sendTsListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				if (!sendTsListVO.getArrblno().equals("")){
					velParam.put("bl_no_list",setparam_In(sendTsListVO.getArrblno(),"|"));
				} 
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransshipmentMgtDBDAOsearchCntrSumByPodRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrSumByPodVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
		
	}
	
	/**
	 * T/S port에 입항한 1st VVD를 기준으로 연결되는 선명 별로 물량을 조회한다.<br>
	 * 
     * @param  TSListBy1st2ndVVDListInputVO tSListBy1st2ndVVDListInputVO
	 * @return List<TSSummaryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TSSummaryVO> searchTSSummary(TSListBy1st2ndVVDListInputVO tSListBy1st2ndVVDListInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TSSummaryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(tSListBy1st2ndVVDListInputVO != null){
				Map<String, String> mapVO = tSListBy1st2ndVVDListInputVO.getColumnValues();
			    
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				 
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransshipmentMgtDBDAOsearchTSSummaryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TSSummaryVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	} 
	/**
	 * Relay Vessel Group Assign by Relay Port 화면에서 assing을 위해 list를 조회한다.<br>
     * 
	 * @param  RlyVslGrpAssignInputVO rlyVslGrpAssignInputVO
	 * @return List<RlyVslGrpAssignVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RlyVslGrpAssignVO> searchRlyVslGrpAssign(RlyVslGrpAssignInputVO rlyVslGrpAssignInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RlyVslGrpAssignVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(rlyVslGrpAssignInputVO != null){
				Map<String, String> mapVO = rlyVslGrpAssignInputVO.getColumnValues();
			    
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				 
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransshipmentMgtDBDAOsearchRlyVslGrpAssignRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RlyVslGrpAssignVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	} 
	
	/**
	 * bkg_ts_rmk table을 조회한다.<br>
     * 
	 * @param  BkgTsRmkVO bkgTsRmkVO
	 * @return BkgTsRmkVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgTsRmkVO searchTSRemark(BkgTsRmkVO bkgTsRmkVO ) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgTsRmkVO>list=null;
		BkgTsRmkVO  bkgTsRmkVORs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgTsRmkVO != null){
				Map<String, String> mapVO = bkgTsRmkVO.getColumnValues();
			    
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				 
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransshipmentMgtDBDAOsearchTSRemarkRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgTsRmkVO .class);
			if (list != null && list.size() > 0) {
				bkgTsRmkVORs = (BkgTsRmkVO)list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bkgTsRmkVORs;
	} 
	
	/**
	 * bkg_ts_rmk 테이블에 데이터를 저장한다.<br>
     * 
	 * @param  BkgTsRmkVO bkgTsRmkVO
	 * @param  SignOnUserAccount account
	 * @exception DAOException
	 */
	public void addTSRemark (BkgTsRmkVO bkgTsRmkVO , SignOnUserAccount account) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgTsRmkVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			param.put("usr_id", account.getUsr_id());
			velParam.put("usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TransshipmentMgtDBDAOaddTSRemarkCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException(new ErrorHandler("BKG01153").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * bkg_ts_rmk에 update한다.<br>
	 * 
	 * @param  BkgTsRmkVO bkgTsRmkVO
	 * @param  SignOnUserAccount account
	 * @return int
	 * @exception DAOException
	 */
	public int modifyTSRemark(BkgTsRmkVO bkgTsRmkVO, SignOnUserAccount account ) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result=0;
		try {
			Map<String, String> mapVO = bkgTsRmkVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("usr_id", account.getUsr_id());
			velParam.put("usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new TransshipmentMgtDBDAOmodifyTSRemarkUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException(new ErrorHandler("BKG01154").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}
	/**
	 * bkg_ts_rmk에 삭제 처리한다. ts_rmk_delt_flg = 'Y' <br>
     * 
	 * @param  BkgTsRmkVO bkgTsRmkVO
	 * @param  SignOnUserAccount account
	 * @exception DAOException 
	 */
	public void removeTSRemark(BkgTsRmkVO bkgTsRmkVO, SignOnUserAccount account ) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgTsRmkVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			param.put("usr_id", account.getUsr_id());
			velParam.put("usr_id", account.getUsr_id());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new TransshipmentMgtDBDAOremoveTSRemarkUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException(new ErrorHandler("BKG01155").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * 조회 조건에 맞는 입항 vvd들을 조회한다.<br>
     * 
	 * @param  NextVvdAssignInputVO nextVvdAssignInputVO
	 * @return List<FormerVvdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<FormerVvdVO> searchFormerVvdForAssign (NextVvdAssignInputVO nextVvdAssignInputVO)throws DAOException {
		DBRowSet dbRowset = null;
		List<FormerVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 
		try{
			if(nextVvdAssignInputVO != null){
				Map<String, String> mapVO = nextVvdAssignInputVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO); 
				 
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransshipmentMgtDBDAOsearchFormerVvdForAssignRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FormerVvdVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
		return list;
	}
	
	/**
	 * 조회 조건에 맞는 출발 vvd들을 조회한다.<br>
     * 
	 * @param  NextVvdAssignInputVO nextVvdAssignInputVO
	 * @return FormerVvdSkdVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public FormerVvdSkdVO searchFormerVvdSkd (NextVvdAssignInputVO nextVvdAssignInputVO)throws DAOException {
		DBRowSet dbRowset = null;
		List<FormerVvdSkdVO> list = null;
		FormerVvdSkdVO formerVvdSkdVO = new FormerVvdSkdVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 
		try{
			if(nextVvdAssignInputVO != null){
				Map<String, String> mapVO = nextVvdAssignInputVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO); 
				 
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransshipmentMgtDBDAOsearchFormerVvdSkdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FormerVvdSkdVO.class);
			if (list != null && list.size() > 0) {
				formerVvdSkdVO = (FormerVvdSkdVO)list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
		return formerVvdSkdVO;
	}
	
	/**
	 * 조회 조건에 맞는 Booking들을 조회<br>
     * 
	 * @param  NextVvdAssignInputVO nextVvdAssignInputVO
	 * @return List<VvdAssignTargetBkgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VvdAssignTargetBkgVO> searchTargerBkgForAssign (NextVvdAssignInputVO nextVvdAssignInputVO)throws DAOException {
		DBRowSet dbRowset = null;
		List<VvdAssignTargetBkgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 
		try{
			if(nextVvdAssignInputVO != null){
				Map<String, String> mapVO = nextVvdAssignInputVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO); 
				 
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransshipmentMgtDBDAOsearchTargerBkgForAssignRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdAssignTargetBkgVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
		return list;
	}
	
	/**
	 * 조회 조건에 맞는 Booking들을 vvd, next port별로 group하여 조회한다.<br>
     * 
	 * @param  NextVvdAssignInputVO nextVvdAssignInputVO
	 * @return List<VvdAssignTargetVvdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VvdAssignTargetVvdVO> searchTargetVvdForAssign (NextVvdAssignInputVO nextVvdAssignInputVO)throws DAOException {
		DBRowSet dbRowset = null;
		List<VvdAssignTargetVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 
		try{
			if(nextVvdAssignInputVO != null){
				Map<String, String> mapVO = nextVvdAssignInputVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO); 
				 
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransshipmentMgtDBDAOsearchTargetVvdForAssignRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdAssignTargetVvdVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
		return list;
	}
	
	/**
	 * 조회 조건에 맞는 출항 vvd들을 조회한다.<br>
     * 
	 * @param  NextVvdAssignInputVO nextVvdAssignInputVO
	 * @return List<NextVvdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<NextVvdVO> searchNextVvdForAssign (NextVvdAssignInputVO nextVvdAssignInputVO)throws DAOException {
		DBRowSet dbRowset = null;
		List<NextVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 
		try{
			if(nextVvdAssignInputVO != null){
				Map<String, String> mapVO = nextVvdAssignInputVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO); 
				 
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransshipmentMgtDBDAOsearchNextVvdForAssignRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, NextVvdVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
		return list;
	}
	
	/**
    * 조건에 맞는 Booking을 route 별로 group으로 조회한다.<br>
    * 
    * @param SearchCondForPortAssignVO searchCondForPortAssignVO
    * @return List<BkgRouteForPortAssignVO>
    * @exception DAOException
    */
	@SuppressWarnings("unchecked")
//	public List<BkgRouteForPortAssignVO>searchBkgRouteForPortAssign(String vvd,String portCd,String pol, String pod, String bkgOfcCd, String bkgNos)throws DAOException {
	public List<BkgRouteForPortAssignVO>searchBkgRouteForPortAssign(SearchCondForPortAssignVO searchCondForPortAssignVO)throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgRouteForPortAssignVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 
		try{
			if(searchCondForPortAssignVO != null){
				Map<String, String> mapVO = searchCondForPortAssignVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO); 					
//			param.put("vvd",vvd);
//			velParam.put("vvd",vvd); 
//			param.put("portCd",portCd);
//			velParam.put("portCd",portCd);
//			param.put("bkgOfcCd",bkgOfcCd);
//			velParam.put("bkgOfcCd",bkgOfcCd);
//			param.put("pol",pol);
//			velParam.put("pol",pol);
//			param.put("pod",pod);
//			velParam.put("pod",pod);

	            if(searchCondForPortAssignVO.getBkgNos() != null){
					ArrayList<String> bkgNoList = new ArrayList();
					
	            	StringTokenizer multiBkgNoToken = new StringTokenizer(searchCondForPortAssignVO.getBkgNos().toUpperCase(), "\n");
	            	 while(multiBkgNoToken.hasMoreTokens()){
	                	String bkgNo = multiBkgNoToken.nextToken();
	                	bkgNoList.add(bkgNo);
	                }
		            if(bkgNoList != null && bkgNoList.size() > 0) {
						param.put("bkgNos",bkgNoList);
		                velParam.put("bkgNos", bkgNoList);
		            }			 
	            }
			}
            
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransshipmentMgtDBDAOsearchBkgRouteForPortAssignRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgRouteForPortAssignVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * route 별로 group으로 조회한 것을 기준으로 상세 Booking들을 조회한다.<br>
     * 
     * @param  BkgListForPortAssignInputVO bkgListForPortAssignInputVO
     * @return List<BkgListForPortAssignVO>
     * @exception DAOException
     */
	@SuppressWarnings("unchecked")
	public List<BkgListForPortAssignVO>searchBkgListForPortAssign(BkgListForPortAssignInputVO bkgListForPortAssignInputVO)throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgListForPortAssignVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 
		try{
			if(bkgListForPortAssignInputVO != null){
				Map<String, String> mapVO = bkgListForPortAssignInputVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO); 
				 
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransshipmentMgtDBDAOsearchBkgListForPortAssignRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgListForPortAssignVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * bkg vvd port를 조회한다.<br>
	 
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @return List<BkgVvdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgVvdVO>searchBkgVvdForVvdPortAssign(BkgBlNoVO bkgBlNoVO)throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		 
		try{
			if(bkgBlNoVO != null){
				Map<String, String> mapVO = bkgBlNoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO); 
				 
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransshipmentMgtDBDAOsearchBkgVvdForVvdPortAssignRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgVvdVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
	          throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
	          throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
		}
		return list;
	}
	
	/**
	 * vvd에 대한 vessel name를 가져온다.<br>
	 * 
	 * @param String vvd
	 * @return String
	 * @exception DAOException
	 */
	public String searchTsListTitleVvd(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnString = "N";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("vvd", vvd);
			velParam.put("vvd", vvd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransshipmentMgtDBDAOsearchTsListTitleVvdRSQL(), param, velParam);
			if(dbRowset.next()){
				rtnString = dbRowset.getString("vsl_nm");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnString;
	}
	
	/**
	    * Search VVD detail for Group VVD/Port Assign.<br>
	    * 
	    * @param SearchCondForPortAssignVO searchCondForPortAssignVO
	    * @return List<VvdDetailForPortAssignVO>
	    * @exception DAOException
	    */
		@SuppressWarnings("unchecked")
		public List<VvdDetailForPortAssignVO>searchVvdDetailForPortAssign(SearchCondForPortAssignVO searchCondForPortAssignVO)throws DAOException {
			DBRowSet dbRowset = null;
			List<VvdDetailForPortAssignVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			 
			try{
				if(searchCondForPortAssignVO != null){
					Map<String, String> mapVO = searchCondForPortAssignVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO); 					

	                if(searchCondForPortAssignVO.getBkgNos() != null){
		                ArrayList<String> bkgNoList = new ArrayList();

		                StringTokenizer multiBkgNoToken = new StringTokenizer(searchCondForPortAssignVO.getBkgNos().toUpperCase(), "\n");
	                	 while(multiBkgNoToken.hasMoreTokens()){
		                	String bkgNo = multiBkgNoToken.nextToken();
		                	bkgNoList.add(bkgNo);
		                }
	                	 
		                if(bkgNoList != null && bkgNoList.size() > 0) {
		    				param.put("bkgNos",bkgNoList);
		                    velParam.put("bkgNos", bkgNoList);
		                }
	                }
				}
				 
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TransshipmentMgtDBDAOsearchVvdDetailForPortAssignRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdDetailForPortAssignVO.class);
			}catch(SQLException se){
				log.error(se.getMessage(),se);
		          throw new DAOException(new ErrorHandler(se).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
		          throw new DAOException(new ErrorHandler(ex).getMessage() + "\n" + getClass().getSimpleName() + "." + Thread.currentThread().getStackTrace()[1].getMethodName() + "\n" + new Date().toString(), ex);
			}
			return list;
		}
}
