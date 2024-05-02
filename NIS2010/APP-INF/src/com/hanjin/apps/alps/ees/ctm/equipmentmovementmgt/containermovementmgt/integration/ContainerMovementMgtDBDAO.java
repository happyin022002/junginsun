/**
 * Copyright(c) 2009 CyberLogitec 
 * @FileName : ContainerMovementMgtDBDAO.java
 * @FileTitle : CNTR History Update
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2009.05.08
 * @LastModifier : 우경민
 * @LastVersion : 1.0
 * 2009.05.08 우경민 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.09.03 김상수 [소스품질관리] ContainerMovementMgtBCImpl.java에서
 *                    중첩try문 제거로 인한 연관메소드 수정
 * 2010.10.18 김상수 [CHM-201006479-01] B.Bulk화물 Movement를 Logic 변경(MT->Full)
 *                   - 현재 B.Bulk화물의 컨테이너는 MT로 VL 처리되기 때문에 FULL VL이 아니라
 *                     EMPTY VL without bkg으로 VL 생성되고 있는 건을 Mt->Full로 변경해서
 *                     자동생성 로직이 탈수있도록 소스수정
 *                   - 현재 자동생성시 이전 상태가 MT이고 현재는 full VL이므로 업무상 error로
 *                     분류되는 로직을 MT이고 Full VL이면 OP,OC가 자동생성되게 변경.
 *                     그러나 BreakBulk도 아니면서 OP,OC없이 생성된 full VL도 있을 수 있으므로
 *                     이를 막기위해 bkg cntr테이블의 BB column을 다시 check하는 로직추가
 * 2010.12.28 김상수 [CHM-201007850-01] [CTM] 업무 고도화 관련 소스 보완
 *                    Log 확인용 표준 출력 로그 제거
 *                    관련 대상 : 16개 file
 *                    변경 사항 : System.out.println => log.info 또는 제거
 * 2011.07.21 나상보 [CHM-201111948] [CTM] TS화물 VL/VD 추가 Insert 예외처리
 * 2011.10.28 신자영 [CHM-201114074-01] [CTM] VL/VD시 Origin Yard code 입력오류 확인 기능 추가
 * 2013.04.17 김현화 [CHM-201324017-01] Movement 화면상 Manual 수정대상 I/F 로직 보완 
 *                                     checkEvntDt - Event Date외 Movement Status, Yard Code도 변경시에는 I/F하도록 수정
 * 2014.01.13 최덕우 [CHM-201327924-01] [CTM]  VL/VD Correction by VVD 수정가능 항목 추가
 * 2014.03.12 최덕우 [CHM-201429139-01] CTM: EDI Result type이 error인 경우, 오류 msg을 선택하여 조회
 * 2016.02.17 김상현 [CHM-201640053] 동일 CYC#의 mvmt는 최신 Bkg으로 Update
 * 2015.09.22 김상현 1.1 [CHM-201537939] Latest Bkg 항목 추가 및 Batch 건 data요청(Logic 추가)
 * 2016.07.29 김상현 [CHM-201642322] Insert/Delete 처리시, 화면에 보이는 데이터가 최신 데이터인지 체크하는 로직 추가
 */
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.vo.CheckBookingVO;
import com.hanjin.apps.alps.ees.ctm.ctmcommon.containermovementvalidation.vo.CntrMvmtSeqInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.AutoCreItemVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.AutoCreStsListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BkgBookingInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BkgCNTRListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BkgContainerLastVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BkgVVDInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.BookingQTYVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CorrectionVLVDListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CtmCntrMovInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CtmMovementHisColVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CtmVrfdGrsMassEdiMsgVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTBookingInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MVMTHistoryListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MstContainerInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MultiBkgNoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.NextShipExistsVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchBkgCntrListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchCLMInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIByContainerVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIByResultRemarkVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIMovementListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchPreVLVDListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.EventDateUpdateHistoryParmVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.CtmMovementVO;


/**
 * ALPS ContainerMovementMgtDBDAO<br>
 * - ALPS-EquipmentMovementMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
				param.put("check_digit", mVMTHistoryListVO.getCheckDigit());
				param.put("check_digit", mVMTHistoryListVO.getCheckDigit());
				param.put("check_digit", mVMTHistoryListVO.getCheckDigit());
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * 컨테이너 이동정보등록
	 *
	 * @param MVMTBookingInfoVO mVMTBookingInfoVO
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void addCtmMovementVO(MVMTBookingInfoVO mVMTBookingInfoVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = mVMTBookingInfoVO.getColumnValues();

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
	 * History Update에서 넘어온 자료를 CTM_MVMT_EVNT_DT_HIS Table에 Insert 한다.<br>
	 *
	 * @param List<CusCtmMovementVO> cusCtmMovementVOs
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void addMvmtEventDateHistory(List<CusCtmMovementVO> cusCtmMovementVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(cusCtmMovementVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementMgtDBDAOEventDateUpdateHistoryParmVOCSQL(), cusCtmMovementVOs,null);
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
			log.info("\n\nDELETE : 0000000000000000000000  cusCtmMovementVOs.size() " + cusCtmMovementVOs.size());
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
	 * EDI Movement의 List를 조회한다<br>
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return List<SearchEDIMovementListVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
				
				String errMsg = searchEDIMovementListVO.getErrMsg();
				List<String> errMsgList = new ArrayList<String>();
				StringTokenizer st1 = new StringTokenizer(errMsg, "@");
				if(!("").equals(errMsg)){
				    while (st1.hasMoreTokens()) {
				    	errMsgList.add(st1.nextToken().replaceAll("'", "''"));		//값중 ' 문자가 들어간 부분을 ''으로 변환
				    }
				    velParam.put("err_msg_list", errMsgList);
				}else {
					velParam.put("err_msg_list", "");
				}
				
				if(!searchEDIMovementListVO.getCntrNo().equals("")) {
					String cntrNo = searchEDIMovementListVO.getCntrNo();
					List<String> cntrNoList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(cntrNo, ",");
				    while (st.hasMoreTokens()) {
				    	cntrNoList.add(st.nextToken());
				    }
					velParam.put("cntr_no_list", cntrNoList);
					if (searchEDIMovementListVO.getCntrNo().length() > 11) {
					  velParam.put("check_digit", "");
					  velParam.put("p_cntrno", "");
					  
					}
				}
			
				 
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
		String rtnValue = null;
		try {
			Map<String, String> mapVO = searchEDIMovementListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchEDIMovementCountVORSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnValue = dbRowset.getString("EDI_MVMT_KNT");
			} else return null;

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
	 * @return List<SearchCLMInfoVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchCLMInfoVO> searchVLVDList(SearchCLMInfoVO searchCLMInfoVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCLMInfoVO> list = null;
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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

	/**
	 * 넘겨온 Booking 번호가 존재하는지 확인한다.<br>
	 *
	 * @param String bkgNo
	 * @return CheckBookingVO
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
				rtnVO.setCnmvLvlNo("0");
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
	 * History Update에서 넘어온 자료를 CTM_MVMT_EVNT_DT_HIS Table에 Insert 한다.<br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void addComMvmtEventDateHistory(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		//ContainerMovementMgtDBDAOComEventDateUpdateHistoryParmVOCSQL
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cusCtmMovementVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOComEventDateUpdateHistoryParmVOCSQL(), param, velParam);
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
	 * @return List<BkgBookingInfoVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgBookingInfoVO> searchBkgBookingList(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgBookingInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			param.put("bkg_no", bkgNo);
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgContainerLastVO> getBkgContainerLastInfo(String cntrNo, String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgContainerLastVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cntr_no", cntrNo);
			param.put("bkg_no", bkgNo);
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<MultiBkgNoVO> searchMultiBkgNo(String cntrNo, String cycNo, String mvmtStsCd, String bkgNo) throws DAOException {
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgVVDInfoVO> getVVDInfo(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * 컨테이너 Movement 정보를 얻어온다<br>
	 *
	 * @param String cntrNo
	 * @return CusCtmMovementVO
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * @param String checkDigit
	 * @return List<BkgContainerLastVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<BkgContainerLastVO> getPreChkValue(String cntrNo, String checkDigit) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgContainerLastVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			param.put("cntr_no", cntrNo + checkDigit);
			param.put("bkg_no", "");
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
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String checkBkgVVD(CtmCntrMovInfoVO ctmCntrMovInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = ctmCntrMovInfoVO.getColumnValues();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String checkVLVDPreChk(CtmCntrMovInfoVO ctmCntrMovInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = ctmCntrMovInfoVO.getColumnValues();

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
	 * 해당 하는 VVD의 yard와 입력된 yard code의 일치 여부를 조회한다<br>
	 *
	 * @param CtmCntrMovInfoVO ctmCntrMovInfoVO
	 * @return int
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public int checkVVDYardCd(CtmCntrMovInfoVO ctmCntrMovInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		int rtnValue = 0 ;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = ctmCntrMovInfoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOcheckVVDYardCdRSQL(), param, null);
				if(dbRowset != null){    
					if(dbRowset.next()){
						rtnValue = dbRowset.getInt("CNT");
					}
				}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	public void updateCtmMvmtIrrFromBkg(String cntrNo, String bkgNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	 * searchMVMTSEQ(cnms_cd, cnmv_cgo_tp) - mvmt status seq를 구한다.<br>
	 *
	 * @param String bkgNo
	 * @return String[]
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String[] getLocationInfo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String[] list = new String[4];
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			velParam.putAll(param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOgetLocationInfoRSQL(), param, velParam);
			if (dbRowset.next()) {
				list[0] = dbRowset.getString("POL_CD");
				list[1] = dbRowset.getString("POR_CD");
				list[2] = dbRowset.getString("POD_CD");
				list[3] = dbRowset.getString("DEL_CD");
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
	 * AUTO CRE STATUS LIST에서 넘어온 자료를 CTM_MVMT_EVNT_DT_HIS Table에 Insert 한다.<br>
	 *
	 * @param List<AutoCreStsListVO> autoCreStsListVOs
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void addAutoMvmtEventDateHistory(List<AutoCreStsListVO> autoCreStsListVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(autoCreStsListVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ContainerMovementMgtDBDAOAutoEventDateUpdateHistoryParmVOCSQL(), autoCreStsListVOs,null);
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
	 * VVD의 POL / POD LCC를 조회한다<br>
	 *
	 * @param String bkgNo
	 * @param String cntrId
	 * @return String[]
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String[] searchPolPodLccCd(String bkgNo, String cntrId) throws DAOException {
		DBRowSet dbRowset = null;
		String[] rtn = new String[4];
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("cntr_id", cntrId);
			velParam.put("bkg_no", bkgNo);
			velParam.put("cntr_id", cntrId);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOsearchPolPodLccCdRSQL(), param, velParam);
			if (dbRowset.next()) { 
				rtn[0] = dbRowset.getString("POL_LCC_CD");
				rtn[1] = dbRowset.getString("POD_LCC_CD");
				rtn[2] = dbRowset.getString("POL_CD");
				rtn[3] = dbRowset.getString("POD_CD");
			}else{
				rtn[0] = "";
				rtn[1] = "";
				rtn[2] = "";
				rtn[3] = "";
			}
			return rtn;
		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Modified event date history Inquiry를 조회한다.<br>
	 *
	 * @param EventDateUpdateHistoryParmVO eventDateUpdateHistoryParmVO
	 * @return List<EventDateUpdateHistoryParmVO>
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EventDateUpdateHistoryParmVO> searchEventDateUpdateHistory(EventDateUpdateHistoryParmVO eventDateUpdateHistoryParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EventDateUpdateHistoryParmVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if(eventDateUpdateHistoryParmVO != null){
				Map<String, String> mapVO = eventDateUpdateHistoryParmVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				//멀티 콤보로 넘어온 값 Status
				List<String> statusCds = new ArrayList<String>();
				String[] arrStatusCd =  eventDateUpdateHistoryParmVO.getStatusCd().split(",");
				for(int i = 0; i < arrStatusCd.length; i ++){
					statusCds.add(arrStatusCd[i]);
				}
				velParam.put("statusCds", statusCds);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOsearchEventDateUpdateHistoryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EventDateUpdateHistoryParmVO.class);
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
	 * LSO, SBO, TLL시 "XX" Movement의 이전 Movement가 IC나 ID면 해당 BKG No.가 XX Movement에 입력되록 조회한다.<br>
	 *
	 * @param String cntrNo
	 * @return String
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public String searchXXBkgNo(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("cntr_no", cntrNo);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOsearchXXBkgNoRSQL(), param, velParam);
			
			if (dbRowset.next()) { 
				rtnValue = dbRowset.getString("BKG_NO");			
			}
			else{
				rtnValue = "";
			}
			return rtnValue;
		} catch (SQLException se){
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CorrectionVLVDListVO> searchVLVDYardCode(CorrectionVLVDListVO correctionVLVDListVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOsearchVLVDYardCodeRSQL(), param, velParam);
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
	 * 컨테이너의 이동정보를 업데이트한다. <br>
	 *
	 * @param CusCtmMovementVO cusCtmMovementVO
	 * @throws DAOException
	 * @Exception SQLException, Exception
	 */
	public void updateMovementBkgVO(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = cusCtmMovementVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOupdateCtmMovementBkgUSQL(), param, velParam);
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
	 * 해당 Container가 일반 Booking 있는지 확인하기 위한 조회.
	 * @param cusCtmMovementVO
	 * @return String
	 * @throws DAOException
	 */
	public String checkCntrExist(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>(); //query parameter
		String checkValue = null;

		try {
			if (cusCtmMovementVO != null) {
				param.putAll(cusCtmMovementVO.getColumnValues());
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOCheckCntrExistRSQL(), param, null);
				if (dbRowset.next()) {
					checkValue = dbRowset.getString("1");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return checkValue;
	}

	/**
	 * Domestic BKG의 이전 상태가 OP일 경우, CP로 상태 변경
	 * @param cusCtmMovementVO
	 * @throws DAOException
	 */
	public void updateCtmMovementDomestic(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter

		try {
			if (cusCtmMovementVO != null) {
				param.putAll(cusCtmMovementVO.getColumnValues());
				int result = new SQLExecuter().executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOUpdateCtmMovementDomesticUSQL(), param, null);
				if (result == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to insert SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Last BKG_NO update 처리
	 * @param lastBkgNo
	 * @param lastBlNo
	 * @param cusCtmMovementVO
	 * @throws DAOException
	 */
	public void modifyLastBkgNo(String lastBkgNo, String lastBlNo, CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter 

		try {
			if (cusCtmMovementVO != null) {
				param.putAll(cusCtmMovementVO.getColumnValues());
				param.put("last_bkg_no", lastBkgNo);
				param.put("last_bl_no", lastBlNo);

				int result = new SQLExecuter().executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOModifyLastBkgNoUSQL(), param, null);
				if (result == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to insert SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Movement Row 데이터 조회.
	 * @param cusCtmMovementVO
	 * @return CusCtmMovementVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CusCtmMovementVO searchMovementInfo(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		CusCtmMovementVO movementVO = null;

		try {
			if (cusCtmMovementVO != null) {
				param.putAll(cusCtmMovementVO.getColumnValues());
				dbRowset = new SQLExecuter().executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchMovementInfoRSQL(), param, null);
				List<CusCtmMovementVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, CusCtmMovementVO.class);
				if (list != null && list.size() > 0) {
					movementVO = list.get(0);
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return movementVO;
	}

	/**
	 * Movement history max 값 조회.
	 * @param cusCtmMovementVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchMaxMovementHisSeq(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		String maxSeq = null;

		try {
			if (cusCtmMovementVO != null) {
				param.putAll(cusCtmMovementVO.getColumnValues());
				dbRowset = new SQLExecuter().executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchMaxMovementHisSeqRSQL(), param, null);
				if (dbRowset.next()) {
					maxSeq = dbRowset.getString("maxSeq");
				}
			}
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}

		return maxSeq;
	}

	/**
	 * Movement history column 정보 저장
	 * @param ctmMovementHisColVO
	 * @throws DAOException
	 */
	public void addCtmMvmtMnlHisCol(CtmMovementHisColVO ctmMovementHisColVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter 

		try {
			if (ctmMovementHisColVO != null) {
				param.putAll(ctmMovementHisColVO.getColumnValues());

				int result = new SQLExecuter().executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOAddCtmMvmtMnlHisColCSQL(), param, null);
				if (result == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to insert SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 수정하기 전 이전 값 저장.
	 * @param cusCtmMovementVO
	 * @throws DAOException
	 */
	public void addPrevCtmMvmtMnlHis(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter 

		try {
			if (cusCtmMovementVO != null) {
				param.putAll(cusCtmMovementVO.getColumnValues());

				int result = new SQLExecuter().executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOAddPrevCtmMvmtMnlHisCSQL(), param, null);
				if (result == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to insert SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 수정된 데이터 저장 
	 * @param cusCtmMovementVO
	 * @throws DAOException
	 */
	public void addUpdateCtmMvmtMnlHis(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter 

		try {
			if (cusCtmMovementVO != null) {
				param.putAll(cusCtmMovementVO.getColumnValues());

				int result = new SQLExecuter().executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOAddUpdateCtmMvmtMnlHisCSQL(), param, null);
				if (result == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to insert SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 신규 등록하는 history 저장
	 * @param cusCtmMovementVO
	 * @throws DAOException
	 */
	public void addInsertCtmMvmtMnlHis(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter 

		try {
			if (cusCtmMovementVO != null) {
				param.putAll(cusCtmMovementVO.getColumnValues());

				int result = new SQLExecuter().executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOAddInsertCtmMvmtMnlHisCSQL(), param, null);
				if (result == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to insert SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Auto 생성된 movement data 수정 history 저장.
	 * @param cusCtmMovementVO
	 * @throws DAOException
	 */
	public void addAutoStsUpdateCtmMvmtMnlHis(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter 

		try {
			if (cusCtmMovementVO != null) {
				param.putAll(cusCtmMovementVO.getColumnValues());

				int result = new SQLExecuter().executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOAddAutoStsUpdateCtmMvmtMnlHisCSQL(), param, null);
				if (result == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to insert SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 이전 Movement data에서 VGM 데이터 추출
	 * @param cntrNo
	 * @return CusCtmMovementVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CusCtmMovementVO searchPreVgmData(String cntrNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		CusCtmMovementVO cusCtmMovementVO = null;
		DBRowSet dbRowSet = null;

		try {
			if (cntrNo != null) {
				param.put("cntr_no", cntrNo);
				dbRowSet = (new SQLExecuter("")).executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchPreVgmDataRSQL(), param, null);
				List<CusCtmMovementVO> list = (List)RowSetUtil.rowSetToVOs(dbRowSet, CusCtmMovementVO.class);
				if (list != null && list.size() > 0) {
					cusCtmMovementVO = list.get(0);
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return cusCtmMovementVO;
	}

	/**
	 * 이전 movement data에 VGM 데이터 업데이트
	 * @param cusCtmMovementVO
	 * @throws DAOException
	 */
	public void updatePreVgmData(CusCtmMovementVO cusCtmMovementVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter

		try {
			if (cusCtmMovementVO != null) {
				param.putAll(cusCtmMovementVO.getColumnValues());

				int result = new SQLExecuter().executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOUpdatePreVgmDataUSQL(), param, null);
				if (result == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to insert SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * VERMAS EDI data 저장.
	 * @param ctmVrfdGrsMassEdiMsgVO
	 * @throws DAOException
	 */
	public void addCtmVrfdGrsMassEdiMsg(CtmVrfdGrsMassEdiMsgVO ctmVrfdGrsMassEdiMsgVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter

		try {
			if (ctmVrfdGrsMassEdiMsgVO != null) {
				param.putAll(ctmVrfdGrsMassEdiMsgVO.getColumnValues());

				int result = new SQLExecuter().executeUpdate((ISQLTemplate)new ContainerMovementMgtDBDAOAddCtmVrfdGrsMassEdiMsgCSQL(), param, null);
				if (result == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to insert SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 조회된 마지막 시간을 저장해 놓기 위해 system date 조회.
	 * @return String
	 * @throws DAOException
	 */
	public String searchSystemDate() throws DAOException {
		DBRowSet dbRowSet = null;
		String systemDateStr = null;

		try {
			dbRowSet = (new SQLExecuter("")).executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchSystemDateRSQL(), null, null);
			if (dbRowSet.next()) {
				systemDateStr = dbRowSet.getString("DATE_STR");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return systemDateStr;
	}

	/**
	 * 마지막 retrieve 이후에 수정된 데이터가 있는데 확인
	 * @param cntrNo
	 * @param lastRetrieveDate
	 * @return int
	 * @throws DAOException
	 */
	public int searchModifiedDataCount(String cntrNo, String lastRetrieveDate) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // query vel parameter
		DBRowSet dbRowSet = null;
		int rowCount = 0;

		try {
			if (cntrNo != null) {
				// Multi container list 변경
				if (!cntrNo.equals("")) {
					List<String> cntrNoList = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(cntrNo, ",");
					while (st.hasMoreTokens()) {
						cntrNoList.add(st.nextToken());
					}
					velParam.put("cntr_no_list", cntrNoList);
				}
				param.put("cntr_no", cntrNo);
				velParam.put("cntr_no", cntrNo);
				param.put("last_retrieve_date", lastRetrieveDate);
				velParam.put("last_retrieve_date", lastRetrieveDate);
				dbRowSet = (new SQLExecuter("")).executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchModifiedDataCountRSQL(), param, velParam);
				if (dbRowSet.next()) {
					rowCount = dbRowSet.getInt("CNT");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return rowCount;
	}

	/**
	 * Booking에 I/F 하기 위한 VERMAS data 조회.
	 * @param cntrNo
	 * @param bkgNo
	 * @return CtmVrfdGrsMassEdiMsgVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CtmVrfdGrsMassEdiMsgVO searchVermasDataByCntrNo(String cntrNo, String bkgNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		DBRowSet dbRowSet = null;
		CtmVrfdGrsMassEdiMsgVO ctmVoCtmVrfdGrsMassEdiMsgVO = null;

		try {
			if (cntrNo != null && !"".equals(cntrNo) && bkgNo != null && !"".equals(bkgNo)) {
				param.put("cntr_no", cntrNo);
				param.put("bkg_no", bkgNo);

				dbRowSet = (new SQLExecuter("")).executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchVermasDataByCntrNoRSQL(), param, null);
				List<CtmVrfdGrsMassEdiMsgVO> list = (List)RowSetUtil.rowSetToVOs(dbRowSet, CtmVrfdGrsMassEdiMsgVO.class);				
				if (list.size() > 0) {
					ctmVoCtmVrfdGrsMassEdiMsgVO = list.get(0);
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return ctmVoCtmVrfdGrsMassEdiMsgVO;
	}
	
	/**
	 * OP, VL이 삭제로 booking 정보를 초기화 시 해당 BKG_NO가 정상적으로 입력된 이전 movement가 존재하는지 조회
	 * @param cntrNo
	 * @param bkgNo
	 * @return int
	 * @throws DAOException
	 */
	public int searchSamBkgPriorMvmtKnt(String bkgNo, String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		int rowVal = 999;// Booking 데이터 초기화 방지를 위해 0 보다 큰 임의의 수 입력
		
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("cntr_no", cntrNo);
			
			param.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchSamBkgPriorMvmtCheckRSQL(), param, null);			
			if (dbRowset.next()) {
				rowVal = dbRowset.getInt("KNT");
				log.debug("b : rowVal : " + rowVal);
			}

		} catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rowVal;
	}
	
	/**
	 * MVMT 의 최종 / 최종에서 2번째 상태정보를 조회합니다. <br>
	 * @param String cntrNo
	 * @return CusCtmMovementVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CusCtmMovementVO searchN1stN2ndMvmtStsInfo(String cntrNo) throws DAOException {
		DBRowSet dbRowSet = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);
			
			param.putAll(mapVO);
			
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new ContainerMovementMgtDBDAOSearchN1stN2ndMvmtStsInfoRSQL(), param, null);			
			List<CusCtmMovementVO> list = (List)RowSetUtil.rowSetToVOs(dbRowSet, CusCtmMovementVO.class);
			
			if (list.size() > 0) {
				return list.get(0);
			}
			else {
				return null;
			}
		} 
		catch (SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} 
		catch (Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}
