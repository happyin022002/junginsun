/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ContainerMovementMgtDBDAO.java
 *@FileTitle : CNTR History Update
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.08
 *@LastModifier : 우경민
 *@LastVersion : 1.0
 * 2009.05.08 우경민
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.vo.CheckBookingVO;
import com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.vo.CntrMvmtSeqInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBCImpl;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.AutoCreItemVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.AutoCreStsListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BkgBookingInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BkgCNTRListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BkgContainerLastVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BkgVVDInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BookingQTYVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CorrectionVLVDListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CtmCntrMovInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTBookingInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTHistoryListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTListbyDMGEvntDateVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MstContainerInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MultiBkgNoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.NextShipExistsVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchBkgCntrListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchCLMInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIByContainerVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIByResultRemarkVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIMovementListVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchPreVLVDListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.CtmMovementVO;


/**
 * OPUS ContainerMovementMgtDBDAO<br>
 * - OPUS-EquipmentMovementMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KyungMin Woo
 * @see ContainerMovementMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class ContainerMovementMgtDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Container의 마지막 상태값을 불러온다.<br>
	 *
	 * @param String cntrNo
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String getCntrStatus(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		String status = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetCNTRLastStatusRSQL(), param, velParam);
			if (dbRowset.next()) {
				status = dbRowset.getString("mvmt_sts_cd");
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return status;
	}

	/**
	 * ContainerMovement History List를 조회한다.<br>
	 *
	 * @param MVMTHistoryListVO mvmtHistoryListVO
	 * @return List<MVMTHistoryListVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<MVMTHistoryListVO> searchMVMTHistoryList(MVMTHistoryListVO mvmtHistoryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MVMTHistoryListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(mvmtHistoryListVO != null){
				Map<String, String> mapVO = mvmtHistoryListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOMVMTHistoryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MVMTHistoryListVO.class);
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Container Movement Histoy Retrive Button Event. <br>
	 * Container 이동정보의 Booking 정보 조회
	 *
	 * @param MVMTBookingInfoVO mVMTHistoryListVO
	 * @param String cntCd
	 * @return List<MVMTBookingInfoVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<MVMTBookingInfoVO> searchBookingInfoList(MVMTBookingInfoVO mVMTHistoryListVO, String cntCd) throws DAOException {
		 DBRowSet dbRowset = null;
		List<MVMTBookingInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(mVMTHistoryListVO != null){
				if (mVMTHistoryListVO.getPDate1() == null || mVMTHistoryListVO.getPDate1().equals("")) mVMTHistoryListVO.setPDate1("");

				param.put("nls_cnt", cntCd);
				param.put("p_date1", mVMTHistoryListVO.getPDate1());
				param.put("p_date2", mVMTHistoryListVO.getPDate2());
				param.put("p_cntrno", mVMTHistoryListVO.getPCntrno());
//				param.put("check_digit", mVMTHistoryListVO.getCheckDigit());
				velParam.putAll(param);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOMVMTBookingInfoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MVMTBookingInfoVO.class);
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Container Movement history의 Booking Info List를 조회한다.<br>
	 *
	 * @param MVMTHistoryListVO mVMTHistoryListVO
	 * @return List<MVMTHistoryListVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<MVMTHistoryListVO> searchMVMTHistoryInfoList(MVMTHistoryListVO mVMTHistoryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MVMTHistoryListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(mVMTHistoryListVO != null){
				Map<String, String> mapVO = mVMTHistoryListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOMVMTHistoryListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MVMTHistoryListVO.class);
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Container Movement Histoy Save Button Event. <br>
	 * 컨테이너 이동정보수정
	 *
	 * @param MVMTBookingInfoVO mVMTBookingInfoVO
	 * @return int
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public int modifyCtmMovementVO(MVMTBookingInfoVO mVMTBookingInfoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = mVMTBookingInfoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOCtmMovementVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * Container Movement Histoy Save Button Event. <br>
	 * 컨테이너 이동정보 삭제
	 *
	 * @param MVMTBookingInfoVO mvmBookingInfoVO
	 * @return int
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public int removeCtmMovementVO(MVMTBookingInfoVO mvmBookingInfoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = mvmBookingInfoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOCtmMovementVODSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * History Update에서 넘어온 자료를 Movement Table에 Insert 한다.<br>
	 *
	 * @param List<CusCtmMovementVO> cusCtmMovementVOs
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void addCtmMovementVOS(List<CusCtmMovementVO> cusCtmMovementVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cusCtmMovementVOs.size() > 0){
				log.debug("============================================================");
				log.debug("CONTAINER MOVEMENT DATA INSERT " +cusCtmMovementVOs.size()) ;
				log.debug("============================================================");
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementMgtDBDAOCtmMovementVOCSQL(), cusCtmMovementVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * History Update에서 넘어온 자료를 Movement Table에 Update 한다.<br>
	 *
	 * @param List<CusCtmMovementVO> cusCtmMovementVOs
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void modifyCtmMovementVOS(List<CusCtmMovementVO> cusCtmMovementVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
//			for(int id = 0; id < cusCtmMovementVOs.size(); id++){
//				,log.info("AAAAAAAAAAAAAAAAA" + cusCtmMovementVOs.get(id).getCnmvSplitNo() + "A");
//			}
			if(cusCtmMovementVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementMgtDBDAOCtmMovementVOUSQL(), cusCtmMovementVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Container Status Update
	 *
	 * @param List<CusCtmMovementVO> cusCtmMovementVOs
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void modifyCtmStatusVOS(List<CusCtmMovementVO> cusCtmMovementVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(cusCtmMovementVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementMgtDBDAOCtmStatusVOUSQL(), cusCtmMovementVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * History Update에서 삭제된 자료들을 Update 처리한다<br>
	 *
	 * @param List<CusCtmMovementVO> cusCtmMovementVOs
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void modifyCtmMovementBefDelVOS(List<CusCtmMovementVO> cusCtmMovementVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(cusCtmMovementVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementMgtDBDAOCtmMovementBefDelVOUSQLUSQL(), cusCtmMovementVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * History Update에서 삭제된 자료들을 Delete 처리한다.<br>
	 *
	 * @param List<CusCtmMovementVO> cusCtmMovementVOs
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void removeCtmMovementVOS(List<CusCtmMovementVO> cusCtmMovementVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(cusCtmMovementVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementMgtDBDAOCtmMovementVODSQL(), cusCtmMovementVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * History Update에서 삭제된 자료들을 CTM_MVMT_CORR테이블에 insert 처리한다.<br>
	 *
	 * @param List<CusCtmMovementVO> cusCtmMovementVOs
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void insertCtmMovementVOS(List<CusCtmMovementVO> cusCtmMovementVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(cusCtmMovementVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementMgtDBDAOcopyMovementHistoryCSQL(), cusCtmMovementVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * History Update에서 삭제된 자료들을 CTM_MVMT_CORR테이블에 insert 처리한다.(MST에서 호출)<br>
	 *
	 * @param List<CusCtmMovementVO> cusCtmMovementVOs
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void insertCtmMovementFromMst(List<CusCtmMovementVO> cusCtmMovementVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(cusCtmMovementVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementMgtDBDAOcopyMovementHistoryFromMstCSQL(), cusCtmMovementVOs, null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * checkSearchCondition<br>
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	 @SuppressWarnings("unchecked")
	public String checkSearchCondition(SearchEDIMovementListVO searchEDIMovementListVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(searchEDIMovementListVO != null){
				Map<String, String> mapVO = searchEDIMovementListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOCheckSearchConditionRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("RESULT");
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

		/**
		 * EDI Movement의 List를 조회한다<br>
		 *
		 * @param SearchEDIMovementListVO searchEDIMovementListVO
		 * @return List<SearchEDIMovementListVO>
		 * @throws DAOException
		 * @Exception SQLException, Exception
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchEDIMovementListVO> searchEDIMovementListWithIndex(SearchEDIMovementListVO searchEDIMovementListVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchEDIMovementListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if(searchEDIMovementListVO != null){
					Map<String, String> mapVO = searchEDIMovementListVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchEDIMovementListWithIndexRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEDIMovementListVO.class);
			} catch (SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}

		/**
		 * EDI Movement의 List를 조회한다<br>
		 *
		 * @param SearchEDIMovementListVO searchEDIMovementListVO
		 * @return List<SearchEDIMovementListVO>
		 * @throws DAOException
		 * @Exception SQLException, Exception
		 */
		 @SuppressWarnings("unchecked")
		public List<SearchEDIMovementListVO> searchEDIMovementList(SearchEDIMovementListVO searchEDIMovementListVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<SearchEDIMovementListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try {
				if(searchEDIMovementListVO != null){
					Map<String, String> mapVO = searchEDIMovementListVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchEDIMovementListVORSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEDIMovementListVO.class);
			} catch (SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}

	/**
	 * EDI Movement List의 Count를 조회한다.<br>
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String searchEDIMovementCount(SearchEDIMovementListVO searchEDIMovementListVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try {
			Map<String, String> mapVO = searchEDIMovementListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchEDIMovementCountVORSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("EDI_MVMT_KNT");
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue.toString();
	}

	/**
	 * EDI Movement에서 삭제된 데이타를 Update한다.<br>
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void modifyManageEDIMovement(SearchEDIMovementListVO searchEDIMovementListVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = searchEDIMovementListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOManageEDIMovementUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * EDI Movement에서 생성된 데이타를 Insert한다.<br>
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void addManageEDIResult(SearchEDIMovementListVO searchEDIMovementListVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = searchEDIMovementListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOManageEDIResultCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * VL/VD의 List를 조회한다.<br>
	 *
	 * @param SearchCLMInfoVO searchCLMInfoVo
	 * @param String oscaBkgFlg
	 * @return List<SearchCLMInfoVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchCLMInfoVO> searchVLVDList(SearchCLMInfoVO searchCLMInfoVo, String oscaBkgFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCLMInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(searchCLMInfoVo != null){
				Map<String, String> mapVO = searchCLMInfoVo.getColumnValues();
				mapVO.put("osca_bkg_flg", oscaBkgFlg);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchCLMInfoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCLMInfoVO.class);
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * EDI Container Message 리스트를 조회한다.<br>
	 *
	 * @param SearchEDIByContainerVO searchEDIByContainerVO
	 * @return List<SearchEDIByContainerVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchEDIByContainerVO> searchEDIByContainer(SearchEDIByContainerVO searchEDIByContainerVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEDIByContainerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(searchEDIByContainerVO != null){
				Map<String, String> mapVO = searchEDIByContainerVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchEDIByContainerVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEDIByContainerVO.class);
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * EDI Result Remark 리스트를 조회한다.<br>
	 *
	 * @param SearchEDIByResultRemarkVO searchEDIByResultRemarkVO
	 * @return List<SearchEDIByResultRemarkVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<SearchEDIByResultRemarkVO> searchEDIByResultRemark(SearchEDIByResultRemarkVO searchEDIByResultRemarkVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEDIByResultRemarkVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(searchEDIByResultRemarkVO != null){
				Map<String, String> mapVO = searchEDIByResultRemarkVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchEDIByResultRemarkRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEDIByResultRemarkVO.class);
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 컨테이너 번호를 가지고 부킹 리스트를 얻어온다<br>
	 *
	 * @param SearchBkgCntrListVO searchBkgCntrListVO
	 * @return List<SearchBkgCntrListVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchBkgCntrListVO> searchBkgCntrList(SearchBkgCntrListVO searchBkgCntrListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchBkgCntrListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(searchBkgCntrListVO != null){
				Map<String, String> mapVO = searchBkgCntrListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOsearchBkgCntrListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBkgCntrListVO.class);
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

    /*=========================================================
     * 2010.09.03 김상수 [소스품질관리] ContainerMovementMgtBCImpl.java에서
     *                   중첩try문 제거로 인한 연관메소드 수정
     *=========================================================*/
	/**
	 * 입력된 Yard코드로 해당 OFC_CD를 얻어온다.<br>
	 *
	 * @param String yardCd
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String getOfcCdByYard(String yardCd) throws DAOException {
		DBRowSet dbRowset = null;
		String officeCd = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("yard_cd", yardCd);
			velParam.put("yard_cd", yardCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetOfficeByYardRSQL(), param, velParam);
			if (dbRowset.next()) {
				officeCd = dbRowset.getString("OFC_CD");
			} else {
				officeCd = "E";
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("yard select error").getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler("yard select error").getMessage());
		}
		return officeCd;
	}

	/**
	 * MST Container의 정보를 얻어온다.<br>
	 *
	 * @param String cntrNo
	 * @param String evntDt
	 * @param String orgYdCd
	 * @return MstContainerInfoVO
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	@SuppressWarnings("unchecked")
	public MstContainerInfoVO getCntrInfo(String cntrNo, String evntDt, String orgYdCd) throws DAOException {
		DBRowSet dbRowset = null;
		MstContainerInfoVO cntrInfo = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<MstContainerInfoVO> list = null;
		try {
			param.put("cntr_no", cntrNo);
			param.put("evnt_dt", evntDt);
			param.put("org_yd_cd", orgYdCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetContainerInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MstContainerInfoVO.class);

			if (dbRowset == null || list.size() < 1)
				return null;
			else
				cntrInfo =(MstContainerInfoVO) (list.get(0));

		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cntrInfo;
	}

	/**
	 * Container의 마지막 상태 정보를 얻어온다.<br>
	 *
	 * @param String cntrNo
	 * @param int ord
	 * @return CtmCntrMovInfoVO
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	@SuppressWarnings("unchecked")
	public CtmCntrMovInfoVO searchMovementStatusVD(String cntrNo, int ord) throws DAOException {
		DBRowSet dbRowset = null;
		CtmCntrMovInfoVO cntrInfo = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cntr_no", cntrNo);
			param.put("ord", ord);
			velParam.put("cntr_no", cntrNo);
			velParam.put("ord", ord);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchMovementStatusEdiRSQL(), param, velParam);
			List<CtmCntrMovInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, CtmCntrMovInfoVO.class);
			if (list.size() < 1) {
				return null;
			} else {
				cntrInfo =(CtmCntrMovInfoVO) (list).get(0);
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cntrInfo;
	}

	/**
	 * Container의 마지막 상태 정보를 얻어온다.<br>
	 *
	 * @param String cntrNo
	 * @param String evntDt
	 * @return CtmCntrMovInfoVO
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	@SuppressWarnings("unchecked")
	public MVMTBookingInfoVO searchMovementStatus(String cntrNo, String evntDt) throws DAOException {
		DBRowSet dbRowset = null;
		MVMTBookingInfoVO cntrInfo = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cntr_no", cntrNo);
			param.put("evnt_dt", evntDt);
			velParam.put("cntr_no", cntrNo);
			velParam.put("evnt_dt", evntDt);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetCntrMovInfoRSQL(), param, velParam);
			List<MVMTBookingInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, MVMTBookingInfoVO.class);
			if (list.size() < 1)
				return null;
			else
				cntrInfo =(MVMTBookingInfoVO) (list).get(0);

		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cntrInfo;
	}

	/**
	 * Container의 마지막 상태 정보를 얻어온다.<br>
	 *
	 * @param String cntrNo
	 * @param String evntDt
	 * @return CusCtmMovementVO
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	@SuppressWarnings("unchecked")
	public CusCtmMovementVO searchMovementStatusMst(String cntrNo, String evntDt) throws DAOException {
		DBRowSet dbRowset = null;
		CusCtmMovementVO cntrInfo = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);
			param.put("evnt_dt", evntDt);
			velParam.put("evnt_dt", evntDt);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetCntrMovInfoRSQL(), param, velParam);
			List<CusCtmMovementVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, CusCtmMovementVO.class);
			log.info ("LIST SIZE : "  + list.size());
			if (list.size() < 1) {
				return null;
			} else {
				cntrInfo =(CusCtmMovementVO) (list).get(0);
				log.info ("LIST SIZE : "  + cntrInfo.getMvmtStsCd());
				return cntrInfo;
			}

		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

    /*=========================================================
	 * 2010.10.18 김상수 [CHM-201006479-01] B.Bulk화물 Movement를 Logic 변경(MT->Full)
	 *                   - 현재 B.Bulk화물의 컨테이너는 MT로 VL 처리되기 때문에 FULL VL이 아니라
	 *                     EMPTY VL without bkg으로 VL 생성되고 있는 건을 Mt->Full로 변경해서
	 *                     자동생성 로직이 탈수있도록 소스수정
	 *                   - 현재 자동생성시 이전 상태가 MT이고 현재는 full VL이므로 업무상 error로
	 *                     분류되는 로직을 MT이고 Full VL이면 OP,OC가 자동생성되게 변경.
	 *                     그러나 BreakBulk도 아니면서 OP,OC없이 생성된 full VL도 있을 수 있으므로
	 *                     이를 막기위해 bkg cntr테이블의 BB column을 다시 check하는 로직추가
     *=========================================================*/
	/**
	 * 입력된 Yard코드로 해당 OFC_CD를 얻어온다.<br>
	 *
	 * @param String cntrNo
	 * @return String[]
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String[] getBkgNoByCntrNo(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		String[] returnValues = new String[2];
		returnValues[0] = "";
		returnValues[1] = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetBkgNoByCntrNoRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValues[0] = dbRowset.getString("BKG_NO");
				returnValues[1] = dbRowset.getString("BB_CGO_FLG");
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValues;
	}

	public String[] getBkgNoByCntrNoAndCrntVvdCd(String cntrNo, String CrntVvdCd) throws DAOException {
		
		DBRowSet dbRowset = null;
		String[] returnValues = new String[2];
		returnValues[0] = "";
		returnValues[1] = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);
			param.put("crnt_vvd_cd", CrntVvdCd);
			velParam.put("crnt_vvd_cd", CrntVvdCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetBkgNoByCntrNoAndCrntVvdCdRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValues[0] = dbRowset.getString("BKG_NO");
				returnValues[1] = dbRowset.getString("BB_CGO_FLG");
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValues;
	}
	
	
	/**
	 * 넘겨온 Booking 번호가 존재하는지 확인한다.<br>
	 *
	 * @param String bkgNo
	 * @return CheckBookingVO
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	 @SuppressWarnings("unchecked")
	public CheckBookingVO checkBooking(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CheckBookingVO> list = null;
		CheckBookingVO vo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("p_bkg_no", bkgNo);
			velParam.put("p_bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOCheckBookingRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CheckBookingVO.class);
			if (list.size() < 1)
				return null;
			else
				vo = (CheckBookingVO)list.get(0);
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vo;
	}

	/**
	 * 넘겨온 BL No를 체크하고 부킹번호를 리턴한다.<br>
	 *
	 * @param String blNo
	 * @return CheckBookingVO
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	 @SuppressWarnings("unchecked")
	public CheckBookingVO checkBlNo(String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CheckBookingVO> list = null;
		CheckBookingVO vo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOCheckBlNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CheckBookingVO.class);
			if (list.size() < 1)
				return null;
			else
				vo = (CheckBookingVO)list.get(0);
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vo;
	}

	/**
	 * Comtainer Movement Seq Table 정보 가져오는 쿼리 일반.
	 * 모든 Container Movement SEQ는 하나로 처리한다<br>
	 *
	 * @param String cgo_type
	 * @param String mvmtStsCd
	 * @return CntrMvmtSeqInfoVO
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	 @SuppressWarnings("unchecked")
	public CntrMvmtSeqInfoVO getCNTRMovSeqRSQL(String cgoType, String mvmtStsCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<CntrMvmtSeqInfoVO> list = null;
		CntrMvmtSeqInfoVO rtnVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cgo_type", cgoType);
			mapVO.put("mvmt_sts_cd", mvmtStsCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetCNTRMovSeqRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrMvmtSeqInfoVO.class);
			if (list.size() < 1) {
				rtnVO = new CntrMvmtSeqInfoVO();
				//rtnVO.setCnmvLvlNo("0");
				rtnVO = null;
				return rtnVO;
			} else
				rtnVO = list.get(0);
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * 부킹정보를 얻어서 실재 데이타가 존재하는제 판별한다.<br>
	 *
	 * @param String bkgNo
	 * @return Boolean
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public boolean checkBookingbyBkgNo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		boolean exists = false;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOcheckBkgByBkgNoRSQL(), param, velParam);
			if (dbRowset.next()) {
				int exist = dbRowset.getInt("CNT");
				if (exist > 0) exists = true;
			} else {
				exists = false;
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return exists;
	}

	/**
	 * MDM_LOCATION 테이블의 정보를 읽고 해당 정보가 실재 존재하는지 비교한다..<br>
	 *
	 * @param String yardCd
	 * @param String prevYdCd
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String checkLocationCd(String yardCd, String prevYdCd) throws DAOException {
		DBRowSet dbRowset = null;
		String  loc = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("yard_cd", yardCd);
			mapVO.put("prev_yd", prevYdCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOcheckLocationCdRSQL(), param, velParam);
			if (dbRowset.next()) {
				loc = dbRowset.getString("LCC_CD");
			} else {
				loc = "N";
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return loc;
	}

	/**
	 * EN/ TN정보에 대한 MOvement Status를 변경한다.<br>
	 *
	 * @param String descYdCd
	 * @param String stsType
	 * @param String cntrNo
	 * @param String cnmvYr
	 * @param String cnmvSeq
	 * @param String splitNo
	 * @return int
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public int modifyMovementStatusEnTn(String descYdCd, String stsType, String cntrNo, String cnmvYr, String cnmvSeq, String splitNo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("desc_yd_cd", descYdCd);
			mapVO.put("sts_type", stsType);
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("cnmv_yr", cnmvYr);
			mapVO.put("cnmv_seq", cnmvSeq);
			mapVO.put("cnmv_split_no", splitNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOupdateMovementStatusEnTnUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * 자동생성 (인터네셔널)에서 사용되는 자동진행 프로세스리스트를 조회한다.<br>
	 *
	 * @param String stsCd1
	 * @param String stsCd2
	 * @param String stsCd3
	 * @param String orgYd
	 * @param String fmFlg
	 * @param String fmFlg1
	 * @return List<AutoCreItemVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public List<AutoCreItemVO> checkAutoCreItem(String stsCd1, String stsCd2, String stsCd3, String orgYd, String fmFlg, String fmFlg1) throws DAOException {
		DBRowSet dbRowset = null;
		List<AutoCreItemVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("sts_cd", stsCd1);
			param.put("sts_cd1", stsCd2);
			param.put("sts_cd2", stsCd3);
			param.put("org_yd", orgYd);
			param.put("fm_flg", fmFlg);
			param.put("fm_flg1", fmFlg1);
			velParam.putAll(param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOcheckAutoCreItemRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AutoCreItemVO.class);
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 컨테이너의 이동정보를 등록한다.<br>
	 *
	 * @param CtmMovementVO ctmMovementVO
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void addCNTRMVMT(CtmMovementVO ctmMovementVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = ctmMovementVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOCtmMovementVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 컨테이너 이동정보 수정 (자동생성).<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @param String ord
	 * @param String cmUp
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void updateContainer(CusCtmMovementVO cusCtmMovementVO, String ord, String cmUp) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cusCtmMovementVO.getColumnValues();
			param.putAll(mapVO);
			param.put("nos", ord);
			param.put("cm_up", cmUp);
			velParam.putAll(mapVO);
			velParam.put("nos", ord);
			velParam.put("cm_up", cmUp);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOupdateMvmtUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 부킹정보 일반 내역을 읽어온다.<br>
	 *
	 * @param String bkgNo
	 * @param String ydCd
	 * @return List<BkgBookingInfoVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgBookingInfoVO> searchBkgBookingList(String bkgNo, String ydCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBookingInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("yd_cd", ydCd);
			
			velParam.putAll(param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOsearchBookingInfoByBkgNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBookingInfoVO.class);
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 부킹정보 일반 내역을 읽어온다.(Cancel체크 삭제)<br>
	 *
	 * @param String bkgNo
	 * @return List<BkgBookingInfoVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgBookingInfoVO> searchBkgBookingAllList(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBookingInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			param.put("bkg_no", bkgNo);
			velParam.putAll(param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOsearchBookingInfoByBkgNoAllRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgBookingInfoVO.class);
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 부킹컨테이너의 최종 정보를 읽어온다.<br>
	 *
	 * @param String cntrNo
	 * @param String bkgNo
	 * @return List<BkgContainerLastVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgContainerLastVO> getBkgContainerLastInfo(String cntrNo, String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgContainerLastVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			String oscaBkgFlg = "N";
			if(bkgNo != null) {
				oscaBkgFlg = bkgNo.length()==10?"Y":"N";
			}
			if(cntrNo != null) param.put("cntr_no", cntrNo);
			if(bkgNo != null) param.put("bkg_no", bkgNo);
			param.put("osca_bkg_flg", oscaBkgFlg);
			velParam.putAll(param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetBkgContainerLastCycleRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgContainerLastVO.class);
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	 /**
	 * 멀티부킹정보를 읽어온다.<br>
	 *
	 * @param String cntrNo
	 * @param String cycNo
	 * @param String mvmtStsCd
	 * @param String bkgNo
	 * @return List<MultiBkgNoVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<MultiBkgNoVO> searchMultiBkgNo(String cntrNo, String cycNo, String mvmtStsCd, String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<MultiBkgNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cntr_no", cntrNo);
			param.put("osca_bkg_flg", bkgNo.length()==10?"Y":"N");
			param.put("cyc_no", cycNo);
			param.put("mvmt_sts_cd", mvmtStsCd);
			param.put("bkg_no", bkgNo);
			velParam.putAll(param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOsearchMultiBkgNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MultiBkgNoVO.class);
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	 /**
	 * 멀티부킹정보를 읽어온다.<br>
	 *
	 * @param String cntrNo
	 * @param String cycNo
	 * @param String mvmtStsCd
	 * @param String bkgNo
	 * @return List<MultiBkgNoVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<MultiBkgNoVO> searchMultiBkgNoList(String cntrNo, String cycNo, String mvmtStsCd, String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<MultiBkgNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cntr_no", cntrNo);
			param.put("cyc_no", cycNo);
			param.put("mvmt_sts_cd", mvmtStsCd);
			param.put("bkg_no", bkgNo);
			param.put("osca_bkg_flg", bkgNo.length()==10?"Y":"N");
			velParam.putAll(param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetBookingNoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MultiBkgNoVO.class);
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * searchMVMTSEQ(cnms_cd, cnmv_cgo_tp) - mvmt status seq를 구한다.<br>
	 *
	 * @param String mvmtStsCd
	 * @param String bkgCgoTpCd
	 * @return String[]
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String[] getCtmMvmtSeq(String mvmtStsCd, String bkgCgoTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		String[] list = new String[2];
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("sts_cd", mvmtStsCd);
			param.put("cgo_cd", bkgCgoTpCd);
			velParam.putAll(param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetCtmMvmtSeqRSQL(), param, velParam);
			if (dbRowset.next()) {
				list[0] = dbRowset.getString("FCNTR_FLG");
				list[1] = dbRowset.getString("CNMV_LVL_NO");
			} else return null;

		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

    /*=========================================================
     * 2010.09.03 김상수 [소스품질관리] ContainerMovementMgtBCImpl.java에서
     *                   중첩try문 제거로 인한 연관메소드 수정
     *=========================================================*/
	/**
	 * 컨테이너 Movement를 생성한다.<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @return int
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public int addCtmMovement(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cusCtmMovementVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOaddContainerMoveCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			return result;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 부킹정보 일반 내역을 읽어온다.<br>
	 *
	 * @param String bkgNo
	 * @param String cntrNo
	 * @return String[]
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String[] searchBKGCNTR(String bkgNo, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		String[] list = new String[4];
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("cntr_no", cntrNo);
			param.put("osca_bkg_flg", bkgNo.length()==10?"Y":"N");
			velParam.putAll(param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOsearchBKGCNTRRSQL(), param, velParam);
			if (dbRowset.next()) {
				list[0] = "";
				list[1] = dbRowset.getString("CNMV_CYC_NO");
				list[2] = dbRowset.getString("CNTR_CFM_FLG");
				list[3] = dbRowset.getString("CNTR_PRT_FLG");
			} else return null;

		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 부킹정보 일반 내역을 읽어온다.<br>
	 *
	 * @param String cntrNo
	 * @param String cycNo
	 * @param String cnmvYr
	 * @param String cnmvId
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String searchMVMTIrregularr(String cntrNo, String cycNo, String cnmvYr, String cnmvId) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cntr_no", cntrNo);
			param.put("cyc_no", cycNo);
			param.put("cnmv_yr", cnmvYr);
			param.put("cnmv_id", cnmvId);
			velParam.putAll(param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOsearchMVMTIrregularrRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnStr = dbRowset.getString("MVMT_IRR_SEQ");
			} else return null;
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}

	/**
	 * ORG_YD_CD를 근거로 SVR_ID를 찾는다.<br>
	 *
	 * @param String cntCd
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String searchSvrId(String cntCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = null;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cnt_cd", cntCd.substring(0,2));

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchUserLocalCodeRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("SVR_ID");
			} else {
				rtnValue = "E";
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * Container의 최종 ID_NO번호를 조회한다.<br>
	 *
	 * @param String cntrNo
	 * @param String cnmvYr
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String getContainerMaxId(String cntrNo, String cnmvYr) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cntr_no", cntrNo);
			velParam.putAll(param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetBkgContainerCycNoRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnStr = dbRowset.getString("ID_NO");
			} else return "0";
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}

	/**
	 * Container의 최종 ID_NO번호를 조회한다.<br>
	 *
	 * @param String cntrNo
	 * @param String cnmvYr
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String getContainerMaxIdForMVMTHistory(String cntrNo, String cnmvYr) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cntr_no", cntrNo);
			param.put("cnmv_yr", cnmvYr);
			velParam.putAll(param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetContainerMaxIdForMVMTHistoryRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnStr = dbRowset.getString("ID_NO");
			} else return "0";
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}

	/**
	 * Container의 Max Seq를 조회한다.<br>
	 *
	 * @param String cntrNo
	 * @param String cnmvYr
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String getContainerMaxSeq(String cntrNo, String cnmvYr) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cntr_no", cntrNo);
			param.put("cnmv_yr", cnmvYr);
			velParam.putAll(param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetContainerMovementMaxSeqRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnStr = dbRowset.getString("ID_SEQ");
			} else return "0";
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}

	/**
	 * CTM_MVMT_IRR 에 데이타 입력.<br>
	 *
	 * @param String cntrNo
	 * @param String cntrBkgAtchCd
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void mstCtmMvmtIrrInsert(String cntrNo, String cntrBkgAtchCd) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("cntr_bkg_atch_cd", cntrBkgAtchCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOMstCtmMvmtIrrInsertCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 부킹컨테이너에서 스페셜 부킹 Flag를 얻어온다<br>
	 *
	 * @param String cntrNo
	 * @param String cyc1
	 * @param String cyc2
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String searchSpclBkg(String cntrNo, String cyc1, String cyc2) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("cntr_no", cntrNo);
			param.put("cyc1", cyc1);
			param.put("cyc2", cyc2);
			velParam.put("cntr_no", cntrNo);
			velParam.put("cyc1", cyc1);
			velParam.put("cyc2", cyc2);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetSpclBkgRSQL(), param, velParam);
			if (dbRowset.next()) return dbRowset.getString("FND");
			else return "-1";
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 컨테이너의 중복 내역을  얻어온다<br>
	 *
	 * @param String cntrNo
	 * @param String cyc1
	 * @param String cyc2
	 * @return String[]
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String[] getDupBkgCount(String cntrNo, String cyc1, String cyc2) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] result = new String[2];
		try {			
			param.put("cntr_no", cntrNo);
			param.put("cyc1", cyc1);
			param.put("cyc2", cyc2);
			velParam.put("cntr_no", cntrNo);
			velParam.put("cyc1", cyc1);
			velParam.put("cyc2", cyc2);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetDupBkgCountRSQL(), param, velParam);
			if (dbRowset.next()) {
				result[0] = dbRowset.getString("DUP_CNT");
				result[1] = dbRowset.getString("CNT");
				return result;
			}
			else return null;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 부킹 컨테이너 등에서 vvd 체크를 위한 자료 얻기.<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @return List<BkgVVDInfoVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgVVDInfoVO> getVVDInfo(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgVVDInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cusCtmMovementVO.getColumnValues();
			String oscaBkgFlg = cusCtmMovementVO.getBkgNo().length()==10?"Y":"N";

			param.putAll(mapVO);
			param.put("osca_bkg_flg", oscaBkgFlg);
			velParam.putAll(mapVO);
			velParam.put("osca_bkg_flg", oscaBkgFlg);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetBkgVVDRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgVVDInfoVO.class);
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 부킹 VVD의 다음 STATUS를 얻어온다<br>
	 *
	 * @param String bkgNo
	 * @param String vsl
	 * @param String voy
	 * @param String dir
	 * @param String pol
	 * @param String pod
	 * @return List<NextShipExistsVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<NextShipExistsVO> getNextShip(String bkgNo, String vsl, String voy, String dir, String pol, String pod) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<NextShipExistsVO> list = null;

		try {
			param.put("bkg_no", bkgNo);
			param.put("vsl", vsl);
			param.put("voy", voy);
			param.put("dir", dir);
			param.put("pol", pol);
			param.put("pod", pod);
			velParam.putAll(param);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetNextShipExistsRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, NextShipExistsVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 부킹 VVD의 다음 STATUS를 얻어온다<br>
	 *
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String getNextVvdStatus(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			velParam.putAll(param);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetVslPrePstCdRSQL(), param, velParam);
			if (dbRowset.next()) return dbRowset.getString("VSL_PRE_PST_CD");
			else return null;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * VVD 코드에 따른 ETA, ETD Time을 얻어온다<br>
	 *
	 * @param SearchCLMInfoVO searchCLMInfoVO
	 * @return String
	 * @throws DAOException, Exception
	 */
	public String getEtaEtdTime(SearchCLMInfoVO searchCLMInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = searchCLMInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetEtaEtdTimeRSQL(), param, velParam);
			if (dbRowset.next()) return dbRowset.getString("VPS_ETD_DT") + "|" + dbRowset.getString("VPS_ETA_DT");
			else return null;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/** getVvd
	 * 
	 * @param searchCLMInfoVO
	 * @return
	 * @throws DAOException
	 */
	public String getVvd(SearchCLMInfoVO searchCLMInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = searchCLMInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetVvdRSQL(), param, velParam);
			if (dbRowset.next()) return dbRowset.getString("chgd_vvd");
			else return null;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 마지막 컨테이너 이동 정보 (MVMT STS CD)를 2개만 얻어온다<br>
	 *
	 * @param String cntrNo
	 * @return String[]
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String[] getMovementHistoryLast3(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		String[] list = new String[2];
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cntr_no", cntrNo);
			velParam.putAll(param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetMovementHistoryLast3RSQL(), param, velParam);
			int idx = 0;
			while (dbRowset.next()) {
				list[idx++] = dbRowset.getString("MVMT_STS_CD");
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * BOOKING VVD에서 vvd코드를 체크한다.<br>
	 *
	 * @param bkgContainerLastVO bkgContainerLastVO
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String checkBkgVVD(BkgContainerLastVO bkgContainerLastVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgContainerLastVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOcheckBkgVVDRSQL(), param, velParam);

			if (dbRowset.next()) {
				rtnStr = dbRowset.getString("CN");
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}

	/**
	 * 중복 부킹을 체크한다.<br>
	 *
	 * @param String cntrNo
	 * @param String mvmtStsCd
	 * @param String cnmvCycNo
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String getBkgDupCount(String cntrNo, String mvmtStsCd, String cnmvCycNo) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			param.put("cntr_no", cntrNo);
			param.put("cnmv_cyc_no", cnmvCycNo);
			param.put("mvmt_sts_cd", mvmtStsCd);
			velParam.putAll(param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetBkgDupCountRSQL(), param, velParam);

			if (dbRowset.next()) {
				rtnStr = dbRowset.getString("CNT");
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
				log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}

	 /**
	 * 컨테이너에 해당되는 부킹의 갯수를 리턴한다.<br>
	 *
	 * @param BookingQTYVO bookingQTYVO
	 * @return List<BookingQTYVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<BookingQTYVO> searchBookingQTY(BookingQTYVO bookingQTYVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BookingQTYVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bookingQTYVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOsearchBookingQTYRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BookingQTYVO.class);

		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	 /**
	 * 부킹번호에 해당하는 부킹 컨테이너 리스트를 조회한다.<br>
	 *
	 * @param BkgCNTRListVO bkgCNTRListVO
	 * @return List<BkgCNTRListVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgCNTRListVO> searchCNTRList(BkgCNTRListVO bkgCNTRListVO) throws DAOException {

		 DBRowSet dbRowset = null;
		List<BkgCNTRListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = bkgCNTRListVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOsearchCNTRListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCNTRListVO.class);
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 부킹컨테이너의 최종 정보를 읽어온다.<br>
	 *
	 * @param String cntrNo
	 * @param String oscaBkgFlg
	 * @return List<BkgContainerLastVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgContainerLastVO> getPreChkValue(String cntrNo, String oscaBkgFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgContainerLastVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			param.put("cntr_no", cntrNo);
			param.put("bkg_no", "");
			param.put("osca_bkg_flg", oscaBkgFlg);
			
			velParam.putAll(param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetBkgContainerLastCycleRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgContainerLastVO.class);
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * VL/VD 예약테이블에 예약정보를 등록한다.<br>
	 *
	 * @param List<CtmCntrMovInfoVO> ctmCntrMovInfoVOs
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void addCtmMvmtRsv(List<CtmCntrMovInfoVO> ctmCntrMovInfoVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(ctmCntrMovInfoVOs.size() > 0){
				log.debug("============================================================");
				log.debug("CONTAINER MOVEMENT DATA INSERT " +ctmCntrMovInfoVOs.size()) ;
				log.debug("============================================================");
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementMgtDBDAOaddCtmMvmtRsvCSQL(), ctmCntrMovInfoVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * PRE CHECK를 위한 BOOKING VVD.<br>
	 *
	 * @param CtmCntrMovInfoVO ctmCntrMovInfoVO
	 * @param String oscaBkgFlg
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String checkBkgVVD(CtmCntrMovInfoVO ctmCntrMovInfoVO, String oscaBkgFlg) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = ctmCntrMovInfoVO.getColumnValues();
			mapVO.put("osca_bkg_flg", oscaBkgFlg);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOcheckBkgVVDRSQL(), param, velParam);

			if (dbRowset.next()) {
				rtnStr = dbRowset.getString("CN");
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}

	/**
	 * EN/TN/TS에서 부킹VVD관련 정보를 얻어온다.<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @return List<BkgVVDInfoVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<BkgVVDInfoVO> getMstInfo(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgVVDInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cusCtmMovementVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetBkgVVDNotBkgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgVVDInfoVO.class);
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 부킹컨테이너에서 마지막 사이클과 원 사이클에 해당하는 컨테이너의 숫자를 얻어온다<br>
	 *
	 * @param CtmCntrMovInfoVO ctmCntrMovInfoVO
	 * @param String oscaBkgFlg
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String checkVLVDPreChk(CtmCntrMovInfoVO ctmCntrMovInfoVO, String oscaBkgFlg) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = ctmCntrMovInfoVO.getColumnValues();
			mapVO.put("osca_bkg_flg", oscaBkgFlg);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOcheckVLVDCntrExistsRSQL(), param, velParam);
			if (dbRowset.next()) return "1";
			else return "-1";
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 부킹컨테이너에서 마지막 사이클과 원 사이클에 해당하는 컨테이너의 숫자를 얻어온다<br>
	 *
	 * @param SearchCLMInfoVO searchCLMInfoVO
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String checkVVDPreChkOnVslSkd(SearchCLMInfoVO searchCLMInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = searchCLMInfoVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOcheckVVDExistsRSQL(), param, velParam);

			if (dbRowset.next()) {
				return dbRowset.getString("VVD_EXIST");
			} else {
				return "N";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * LCC RCC코드를 찾는다.<br>
	 *
	 * @param String yardCd
	 * @return String[]
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String[] getLccRccCode(String yardCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] rtnValue = new String[4];
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("loc_cd", yardCd.substring(0,5));

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetLccRccCodeRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue[0] = dbRowset.getString("LOC_CD");
				rtnValue[1] = dbRowset.getString("RCC_CD");
				rtnValue[2] = dbRowset.getString("LCC_CD");
				rtnValue[3] = dbRowset.getString("SCC_CD");
			} else {
				rtnValue = null;
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * 컨테이너의 이동정보를 업데이트한다.<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void updateMovementVO(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cusCtmMovementVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOupdateCtmMovementUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 컨테이너의 이동정보를 업데이트한다.<br>
	 *
	 * @param CusCtmMovementVO[] cusCtmMovementVOs
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void updateAddMvmt(CusCtmMovementVO[] cusCtmMovementVOs) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			for (int i = 0; i <= cusCtmMovementVOs.length -1; i++) {
				if (cusCtmMovementVOs[i] == null) return;
				if (cusCtmMovementVOs[i].getCntrNo() == null || cusCtmMovementVOs[i].getCntrNo().equals("")) return;
				Map<String, String> mapVO = cusCtmMovementVOs[i].getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOaddContainerMoveCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 컨테이너 이동정보 조회 (MT/XX생성).<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @return CusCtmMovementVO
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	@SuppressWarnings("unchecked")
	public CusCtmMovementVO getCntrInfoFromMst(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<CusCtmMovementVO> list = null;
		try {
			Map<String, String> mapVO = cusCtmMovementVO.getColumnValues();
			param.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetCntrInfoFromMstRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CusCtmMovementVO.class);
			if (list == null || list.size() == 0) {
				throw new DAOException(new ErrorHandler().getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.get(0);
	}

	/**
	 * SPP 부킹 정보를 조회한다.<br>
	 *
	 * @param String bkgNo
	 * @return String[]
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String[] getBkgInfoFrSpp(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String[] rtn = new String[4];
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetBkgInfoFrSPPRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtn[0] = dbRowset.getString("DEL_CD");
				rtn[1] = dbRowset.getString("RCV_TERM_CD");
				rtn[2] = dbRowset.getString("POD_CD");
				rtn[3] = dbRowset.getString("POL_CD");
				return rtn;
			}
			else return null;
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * POL과 DEL에 해당하는 데이터의 갯수를 리턴한다.<br>
	 *
	 * @param String delCd
	 * @param String podCd
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String getCountOrgDesYd(String delCd, String podCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("del_cd", delCd);
			param.put("pod_cd", podCd);
			velParam.put("del_cd", delCd);
			velParam.put("pod_cd", podCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetCountOrgDesYdRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString("CNT");
			}
		else return null;
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * EES_CTM_0456 : Pre VL/VD List를 Search합니다.<br>
	 *
	 * @param SearchPreVLVDListVO searchPreVLVDListVO
	 * @return List<SearchPreVLVDListVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchPreVLVDListVO> searchPreVLVDList(SearchPreVLVDListVO searchPreVLVDListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchPreVLVDListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(searchPreVLVDListVO != null){
				Map<String, String> mapVO = searchPreVLVDListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchPreVLVDListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPreVLVDListVO.class);
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
	 * EES_CTM_0456 : Pre VL/VD List를 다건 수정합니다.<br>
	 *
	 * @param List<SearchPreVLVDListVO> searchPreVLVDListVOs
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void modifyManagePreVLVDs(List<SearchPreVLVDListVO> searchPreVLVDListVOs) throws DAOException {
		//velocity parameter
		Map<String, Object> velParams = null;
		int updCnt[] = null;
		try {
			if(searchPreVLVDListVOs.size() > 0){
				velParams = new HashMap<String, Object>();
				Map<String, String> mapVO = searchPreVLVDListVOs.get(0).getColumnValues();
				velParams.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("");
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementMgtDBDAOManagePreVLVDVOUSQL(), searchPreVLVDListVOs, velParams);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * EES_CTM_0456 : Pre VL/VD List를 다건 삭제합니다.<br>
	 *
	 * @param List<SearchPreVLVDListVO> searchPreVLVDListVOs
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void removeManagePreVLVDs(List<SearchPreVLVDListVO> searchPreVLVDListVOs) throws DAOException {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(searchPreVLVDListVOs .size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementMgtDBDAOManagePreVLVDVODSQL(), searchPreVLVDListVOs,null);
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
	}

	/**
	 * BKG
	 * CTM_MVMT_IRR의 STL FLG Update.<br>
	 *
	 * @param String cntrNo
	 * @param String bkgNo
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	@SuppressWarnings("unchecked")
	public void updateCtmMvmtIrrFromBkg(String cntrNo, String bkgNo) throws DAOException {
		Map param = new HashMap();

		try {
			param.put("cntr_no", cntrNo);
			param.put("bkg_no", bkgNo);
			SQLExecuter sqlExe = new SQLExecuter("");
			sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOUpdateCtmMvmtIrrFromBkgRSQL(), param, param);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Container No와 EDI키값으로 Bkg list를 가져오기<br>
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return String[]
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String[] getBkgNoByEDICntrInfo(SearchEDIMovementListVO searchEDIMovementListVO) throws DAOException {
		DBRowSet dbRowset = null;
		String[] returnValues = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(searchEDIMovementListVO != null){
				Map<String, String> mapVO = searchEDIMovementListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOGetBkgNoByEDICntrInfoRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0) {
				returnValues = new String[dbRowset.getRowCount()];
				dbRowset.first();
				for (int i=0; i<dbRowset.getRowCount(); i++) {
					returnValues[i] = dbRowset.getString("BKG_NO");
					dbRowset.next();
				}
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValues;
	}

	/**
	 * 부킹이 최종 Confirm되어있는지 체크한다<br>
	 *
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String[] checkFinalConfirm(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] rtnStr = new String[2];
		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOcheckFinalConfirmRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnStr[0] = dbRowset.getString("CFM_FLG");
				rtnStr[1] = dbRowset.getString("CA_FLG");
				return rtnStr;
			} else return rtnStr;
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * VL/VD Correction 정보를 조회한다.<br>
	 *
	 * @param CorrectionVLVDListVO correctionVLVDListVO
	 * @return List<CorrectionVLVDListVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	 @SuppressWarnings("unchecked")
	public List<CorrectionVLVDListVO> searchCorrectionVLVDListByVVD(CorrectionVLVDListVO correctionVLVDListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CorrectionVLVDListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(correctionVLVDListVO != null){
				Map<String, String> mapVO = correctionVLVDListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOCorrectionVLVDListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CorrectionVLVDListVO.class);
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * PRE VL처리를 위한 제공 함수.MVMT Update<br>
	 *
	 * @param CusCtmMovementVO ctmMovementVO
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void modifyMovementFromBkgForPreVLToMvmt(CusCtmMovementVO ctmMovementVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = ctmMovementVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOModifyMovementFromBkgForPreVLUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * PRE VL처리를 위한 제공 함수. Edi Update<br>
	 *
	 * @param CusCtmMovementVO ctmMovementVO
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void modifyMovementFromBkgForPreVLToEdi(CusCtmMovementVO ctmMovementVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = ctmMovementVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOupdateEdiMsgFromBkgUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * searchMVMTSEQ(cnms_cd, cnmv_cgo_tp) - mvmt status seq를 구한다.<br>
	 *
	 * @param String cntrNo
	 * @param String cycNo
	 * @param String cnmvYr
	 * @return String[]
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String[] getBookingListByCycle(String cntrNo, String cycNo, String cnmvYr) throws DAOException {
		DBRowSet dbRowset = null;
		String[] list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cntr_no", cntrNo);
			param.put("cyc_no", cycNo);
			param.put("cnmv_yr", cnmvYr);
			velParam.putAll(param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetBookingListByCntrCycleRSQL(), param, velParam);
			list = new String[dbRowset.getRowCount()];
			int idx = 0;
			while (dbRowset.next()) {
				list[idx] = dbRowset.getString("BKG_NO");
				idx++;
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * XX Create.<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @return int
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public int modifyMovementFromCgmForCreXX(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = cusCtmMovementVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOmodifyMovementFromCgmUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * AUTO CRE STATUS LIST를 저장한다<br>
	 *
	 * @param List<AutoCreStsListVO> autoCreStsListVOs
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifygetAutoCreStsS(List<AutoCreStsListVO> autoCreStsListVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(autoCreStsListVOs.size() > 0){
				log.debug("============================================================");
				log.debug("CONTAINER MOVEMENT DATA INSERT " +autoCreStsListVOs.size()) ;
				log.debug("============================================================");
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementMgtDBDAOManageCtmMovementAutoStsUSQL(), autoCreStsListVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ID 혹은 IC이고 야드가 KREIWY1이거나 KRJCWY1일 경우 체크한다.<br>
	 *
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String checkBkgIDIC(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String status = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			velParam.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOcheckBookingICIDRSQL(), param, velParam);
			if (dbRowset.next()) {
				status = dbRowset.getString("val");
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return status;
	}

	/**
	 * BKG_CONTAINER에 컨테이너가 존재하는지 조회<br>
	 *
	 * @param String cntrNo
	 * @param String bkgNo
	 * @param String cycNo
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String checkBkgCntrExist(String cntrNo, String bkgNo, String cycNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = "";
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("cyc_no", cycNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOCheckBkgCntrExistRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("1");
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * 예를 들어 OP가 없는 상태에서 OC가 먼저 EDI 수신되었다면 auto cre에 의해 OP는 자동생성되고 event date는 OC의 것을 따른다.
	 * 이후에 OP가 EDI 수신되었다면 "OK.PROCESSED (Previous event date is later than current event date.)" 라며 튕겨져 버리지만
	 * 이런 경우 OP의 event date를 정상적으로 update 해준다.
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void modifyCtmMovementEvntDtAfterAutoCre(SearchEDIMovementListVO searchEDIMovementListVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = searchEDIMovementListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOModifyCtmMovementEvntDtAfterAutoCreUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * LocalTime을 가져온다.<br>
	 *
	 * @param String yardCd
	 * @param String evntDt
	 * @param String stsCd
	 * @return String[]
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String[] getLocalTime(String yardCd, String evntDt, String stsCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] rtnValue = new String[3];
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("org_yd_cd", yardCd.substring(0,5));
			mapVO.put("cnmv_evnt_dt", evntDt);
			mapVO.put("mvmt_sts_cd", stsCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetLocalTimeRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue[0] = dbRowset.getString("EVENT_DATE");
				rtnValue[1] = dbRowset.getString("LOCAL_DATE");
				rtnValue[2] = dbRowset.getString("BID");
			} else {
				rtnValue = null;
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
	
	/**
	 * DomBooking을 check한다.<br>
	 *
	 * @param String cntrNo
	 * @param String evntDt
	 * @param String preEvntDt
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String checkDomBooking(String cntrNo, String evntDt, String preEvntDt) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rtnValue = null;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);
			mapVO.put("evnt_dt", evntDt);
			mapVO.put("pre_evnt_dt", preEvntDt);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOcheckDomBookingRSQL(), param, velParam);
			if (dbRowset.next()) {
				if (!dbRowset.getString("ST_TURN_FLG").equals("N"))
					rtnValue = dbRowset.getString("CRE_DT");
				else
					return "N";
			} else {
				rtnValue = "N";
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}	
	
	 /**
	 * 컨테이너 Movement 정보를 얻어온다<br>
	 *
	 * @param String cntrNo
	 * @return CusCtmMovementVO
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	 @SuppressWarnings("unchecked")
	public CusCtmMovementVO getPrevCntrInfo(String cntrNo, String ord) throws DAOException {
		DBRowSet dbRowset = null;
		List<CusCtmMovementVO> list = null;
		CusCtmMovementVO cusVo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cntr_no",cntrNo);
			velParam.put("cntr_no", cntrNo);
			param.put("ord",ord);
			velParam.put("ord",ord);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetPrevCntrInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CusCtmMovementVO.class);
			if (list.size() > 0) {
				cusVo = list.get(list.size()-1);
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cusVo;
	}
	 
	/**
	 * 컨테이너 Movement를 삭제한다.<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void deleteCtmMovement(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cusCtmMovementVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOdeleteContainerMoveDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	 
	 
/**
	 * Container의 evnt_dt가 변경되었는지 체크한다. mvmtStsCd, orgYdCd 변경여부 추가[CHM-201324017-01]<br>
	 *
	 * @param String cnmvEvntDt
	 * @param String cntrNo
	 * @param String cnmvYr
	 * @param String cnmvIdNo
	 * @param String mvmtStsCd
	 * @param String orgYdCd 
	 * @param String tmpVvdCd
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String checkEvntDt(String cnmvEvntDt, String cntrNo, String cnmvYr, String cnmvIdNo, String mvmtStsCd, String orgYdCd, String tmpVvdCd) throws DAOException {
		DBRowSet dbRowset = null;
		String evntDtFlg = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cnmv_evnt_dt", cnmvEvntDt);
			param.put("cntr_no", cntrNo);
			param.put("cnmv_yr", cnmvYr);
			param.put("cnmv_id_no", cnmvIdNo);
			param.put("mvmt_sts_cd", mvmtStsCd);
			param.put("org_yd_cd", orgYdCd);
			param.put("vvd_cd", tmpVvdCd);
			velParam.put("cnmv_evnt_dt", cnmvEvntDt);
			velParam.put("cntr_no", cntrNo);
			velParam.put("cnmv_yr", cnmvYr);
			velParam.put("cnmv_id_no", cnmvIdNo);
			velParam.put("mvmt_sts_cd", mvmtStsCd);
			velParam.put("org_yd_cd", orgYdCd);
			velParam.put("vvd_cd", tmpVvdCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOcheckEvntDtRSQL(), param, velParam);
			if (dbRowset.next()) {
				evntDtFlg = dbRowset.getString("evnt_dt_flg");
				}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return evntDtFlg;
	}

	/**
	 * Save(Deleted) from Update of EDI Message(EES_CTM_0404)<br>
	 * UPDATE CTM_MVMT_EDI_MSG & INSERT CTM_EDI_RSLT_RMK<br>
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void updateResultAsDelForMvmtEdiMsg(SearchEDIMovementListVO searchEDIMovementListVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = searchEDIMovementListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOUpdateResultAsDelForMvmtEdiMsgCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL : ContainerMovementMgtDBDAOUpdateResultAsDelForMvmtEdiMsgCSQL");
			result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOUpdateResultAsDelForMvmtEdiMsgUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL : ContainerMovementMgtDBDAOUpdateResultAsDelForMvmtEdiMsgUSQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	//

	/**
	 * EDI Movement가 존재하는지 확인한다<br>
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return boolean
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public boolean existEDIMovementList(SearchEDIMovementListVO searchEDIMovementListVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(searchEDIMovementListVO != null){
				Map<String, String> mapVO = searchEDIMovementListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOExistEDIMovementListVORSQL(), param, velParam);
			if(dbRowset.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Oscar Bkg No Update.<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void updateOscarContainerMove (CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cusCtmMovementVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOUpdateOscarContainerMoveUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/** String locCd
	 * 
	 * @param locCd
	 * @return
	 * @throws DAOException
	 */
	public String searchContiCode(String locCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
				
				param.put("loc_cd", locCd);
				velParam.put("loc_cd", locCd);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchContiCodeRSQL(), param, velParam);
			
				if (dbRowset.next()) {
					return dbRowset.getString("CONTI_CD");
				} else {
					return "";
				}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	/** String bkgNo
	 * 
	 * @param bkgNo
	 * @return
	 * @throws DAOException
	 */
	public String searchDgCargo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
				
				param.put("bkg_no", bkgNo);
				velParam.put("bkg_no", bkgNo);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchDgCargoRSQL(), param, velParam);
			
				if (dbRowset.next()) {
					return dbRowset.getString("EXIST_CD");
				} else {
					return "N";
				}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * VL/VD의 List를 조회한다.<br>
	 *
	 * @param SearchCLMInfoVO searchCLMInfoVo
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	 @SuppressWarnings("unchecked")
	public String checkCtmBkgVvd(SearchCLMInfoVO searchCLMInfoVo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if(searchCLMInfoVo != null){
				Map<String, String> mapVO = searchCLMInfoVo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchCtmBkgVvdRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString("VVD_YN");
			} else {
				return "N";
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
		
		/**
		 * checkPPreMVMTSts<br>
		 *
		 * @param SearchCLMInfoVO searchCLMInfoVO
		 * @return String
		 * @throws DAOException
		 * @Exception SQLException, Exception
		 */
		 @SuppressWarnings("unchecked")
		public String checkPPreMVMTSts(SearchCLMInfoVO searchCLMInfoVO) throws DAOException {
			DBRowSet dbRowset = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				if(searchCLMInfoVO != null){
					Map<String, String> mapVO = searchCLMInfoVO.getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOCheckPPreMVMTStsRSQL(), param, velParam);
				if (dbRowset.next()) {
					return dbRowset.getString("MVMT_STS_CD");
				} else {
					return "";
				}
			} catch (SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		/**
		 * DMG Flagging/Unflagging Date와 MVMT Event Date 비교하여 CNMV_ID_NO return<br>
		 *
		 * @param String cntrNo
		 * @param String evntDate
		 * @param String evntYard
		 * @param String cntrDmgFlg
		 * @param String lastFlg
		 * @return List<SearchMovementListByContainerVO>
		 * @throws DAOException
		 * @Exception SQLException, Exception
		 */
		 @SuppressWarnings("unchecked")
		public List<MVMTListbyDMGEvntDateVO> checkMVMTListbyDMGEventDate(String cntrNo, String evntDate, String evntYard, String cntrDmgFlg, String lastFlg) throws DAOException {
			DBRowSet dbRowset = null;
			List<MVMTListbyDMGEvntDateVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				param.put("cntr_no", cntrNo);
				param.put("evnt_dt", evntDate);
				param.put("evnt_yard", evntYard);
				param.put("cntr_dmg_flg", cntrDmgFlg);
				param.put("last_flg", lastFlg);
				velParam.put("cntr_no", cntrNo);
				velParam.put("evnt_dt", evntDate);
				velParam.put("evnt_yard", evntYard);
				velParam.put("cntr_dmg_flg", cntrDmgFlg);
				velParam.put("last_flg", lastFlg);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOMVMTListbyDMGEvntDateRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, MVMTListbyDMGEvntDateVO.class);
			} catch (SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch (Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return list;
		}
			
			/**
			 * DMG Flagging/Unflagging History<br>
			 *
			 * @param String cntrNo
			 * @param String evntDt
			 * @param String dmgFlg
			 * @param int seq
			 * @return String[]
			 * @throws DAOException
			 * @Exception SQLException, Exception
			 */
			 @SuppressWarnings("unchecked")
			public String[] checkDMGHistory(String cntrNo, String evntDt, String dmgFlg, int seq) throws DAOException {
				DBRowSet dbRowset = null;
				String[] rtn = new String[7];
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				try {
					param.put("cntr_no", cntrNo);
					param.put("evnt_dt", evntDt);
					param.put("dmg_flg", dmgFlg);
					param.put("seq", seq);
					velParam.put("cntr_no", cntrNo);
					velParam.put("evnt_dt", evntDt);
					velParam.put("dmg_flg", dmgFlg);
					velParam.put("seq", seq);
					
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOcheckDMGHistoryRSQL(), param, velParam);
					if (dbRowset.next()) {
						rtn[0] = dbRowset.getString("EQ_NO");
						rtn[1] = dbRowset.getString("MNR_STS_FLG");
						rtn[2] = dbRowset.getString("MNR_FLG_YD_CD");
						rtn[3] = dbRowset.getString("MNR_FLG_INP_DT");
						rtn[4] = dbRowset.getString("MNR_FLG_RMK");
						rtn[5] = dbRowset.getString("UPD_OFC_CD");
						rtn[6] = dbRowset.getString("UPD_USR_ID");
						
						return rtn;
					} else {
						return null;
					}
				} catch (SQLException se){
					log.error(se.getMessage(),se);
					throw new DAOException(new ErrorHandler(se).getMessage());
				} catch (Exception ex){
					log.error(ex.getMessage(),ex);
					throw new DAOException(new ErrorHandler(ex).getMessage());
				}
			}
			 
	/**
	 * BKG의 스케줄을 비교한다.<br>
	 *
	 * @param String cntrNo
	 * @param String bkgNo
	 * @param String preBkgNo
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public boolean checkBKGRSQL(String cntrNo, String bkgNo, String preBkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		boolean returnValue = false;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cntr_no", cntrNo);
			param.put("bkg_no", bkgNo);
			param.put("pre_bkg_no", preBkgNo);
			velParam.put("cntr_no", cntrNo);
			velParam.put("bkg_no", bkgNo);
			param.put("pre_bkg_no", preBkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOcheckBKGscheduleRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue = false;
			} else {
				returnValue = true;
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}
	 
	/**
	* Check IO Bound<br>
	*
	* @param String cntrNo
	* @param String bkgNo
	* @return boolean
	* @throws DAOException
	* @Exception SQLException, Exception
	*/
	public boolean checkObCntrFlg(String cntrNo, String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		boolean returnValue = false;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cntr_no", cntrNo);
			param.put("bkg_no", bkgNo);
			velParam.put("cntr_no", cntrNo);
			velParam.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOcheckObCntrFlgRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue = true;
			} else {
				returnValue = false;
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}
	 
	/**
	* Check Old Booking<br>
	*
	* @param String cntrNo
	* @param String bkgNo
	* @return boolean
	* @throws DAOException
	* @Exception SQLException, Exception
	*/
	public boolean checkOldBkg(String cntrNo, String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		boolean returnValue = false;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cntr_no", cntrNo);
			param.put("bkg_no", bkgNo);
			velParam.put("cntr_no", cntrNo);
			velParam.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOcheckOldBkgRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue = true;
			} else {
				returnValue = false;
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}
	 
	/**
	* Check Old Full Booking<br>
	*
	* @param String cntrNo
	* @param String bkgNo
	* @return boolean
	* @throws DAOException
	* @Exception SQLException, Exception
	*/
	public boolean checkOldFullBkg(String cntrNo, String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		boolean returnValue = false;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cntr_no", cntrNo);
			param.put("bkg_no", bkgNo);
			velParam.put("cntr_no", cntrNo);
			velParam.put("bkg_no", bkgNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOcheckOldFullBkgRSQL(), param, velParam);
			if (dbRowset.next()) {
				returnValue = true;
			} else {
				returnValue = false;
			}
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnValue;
	}
}