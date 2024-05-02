/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RestuffingContainerRegistrationDAO.java
 *@FileTitle : Restuffing Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.27
 *@LastModifier : 우경민
 *@LastVersion : 1.0
 * 2009.04.27 우경민
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.12.28 김상수 [CHM-201007850-01] [CTM] 업무 고도화 관련 소스 보완
 *                    Log 확인용 표준 출력 로그 제거
 *                    관련 대상 : 16개 file
 *                    변경 사항 : System.out.println => log.info 또는 제거
=========================================================*/
package com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.ctm.ctmcommon.containermovementvalidation.vo.CntrMvmtSeqInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CtmCntrMovInfoVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.MstContainerInfoVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.basic.RestuffingContainerRegistrationBCImpl;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CTMRestuffingVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CtmMovementHistoryVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.CtmMvmtXchDtlVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.InsCtmMvmtXchVO;
import com.clt.apps.opus.ees.ctm.restuffingmgt.restuffingcontainerregistration.vo.RetuffingListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS RestuffingContainerRegistrationDAO <br>
 * - OPUS-RestuffingMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KyungMin Woo
 * @see RestuffingContainerRegistrationBCImpl 참조
 * @since J2EE 1.4
 */
public class RestuffingContainerRegistrationDBDAO extends DBDAOSupport {

	/**
	 * EES_CTM_0417
	 * Restuffing처리 된 내역을 불러온다.<br>
	 *
	 * @param RetuffingListVO retuffingListVO
	 * @return List<RetuffingListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<RetuffingListVO> searchRestuffingList(RetuffingListVO retuffingListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RetuffingListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(retuffingListVO != null){
				Map<String, String> mapVO = retuffingListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RestuffingContainerRegistrationDBDAOCtmMvmtXchVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RetuffingListVO.class);
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
	  * EES_CTM_0445
	  * 0445 POPUP화면을 위한 조회이벤트 처리. <br>
	  *
	  * @param  CtmMovementHistoryVO ctmMovementHistoryVO
	  * @param  String flg
	  * @return List<CTMRestuffingVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	public List<CTMRestuffingVO> searchOBJMVMT(CtmMovementHistoryVO ctmMovementHistoryVO, String flg) throws DAOException {
		DBRowSet dbRowset = null;
		List<CTMRestuffingVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(ctmMovementHistoryVO != null){
				Map<String, String> mapVO = ctmMovementHistoryVO.getColumnValues();

				param.putAll(mapVO);
				param.put("flg", flg);
				velParam.putAll(mapVO);
				velParam.put("flg", flg);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RestuffingContainerRegistrationDBDAOGetCtmMovementHistoryRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CTMRestuffingVO.class);
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
     * EES_CTM_0422
	 * CNTR XCH의 시퀀스 구하기.<br>
	 *
	 * @param String cntrNo
	 * @param String cnmvIdNo
	 * @param String cnmvYr
	 * @throws Exception
	 * @return String
	 * @exception Exception
	 */
	public String searchRSFSEQ(String cntrNo, String cnmvIdNo, String cnmvYr) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String seq = null;
		try {

			param.put("cntr_no", cntrNo);
			param.put("cnmv_yr", cnmvYr);
			param.put("cnmv_id_no", cnmvIdNo);
			velParam.putAll(param);

			SQLExecuter sqlExe = new SQLExecuter("");
			dbRowset = sqlExe.executeQuery((ISQLTemplate)new RestuffingContainerRegistrationDBDAOgetRestuffingSeqRSQL(), param, velParam);
			if(dbRowset != null)
			{
				if (dbRowset.next()) {
					seq = dbRowset.getString("MAX_SEQ");
				} else {
					seq = "1";
				}
			}
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return seq;
	}

	/**
     * EES_CTM_0422
	 * CNTR XCH의 LOC/RCC?LCC 구하기.<br>
	 *
	 * @param String yardCd
	 * @return String[]
	 * @exception Exception
	 * @throws DAOException, Exception
	 */
	public String[] getLocationInfo(String yardCd) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] rtnStr = new String[3];
		try {

			param.put("loc_cd", yardCd);
			velParam.putAll(param);

			SQLExecuter sqlExe = new SQLExecuter("");
			dbRowset = sqlExe.executeQuery((ISQLTemplate)new RestuffingContainerRegistrationDBDAOGetLccRccCodeRSQL(), param, velParam);
			if(dbRowset != null)
			{
				if (dbRowset.next()) {
					rtnStr[0] = dbRowset.getString("LOC_CD");
					rtnStr[1] = dbRowset.getString("LCC_CD");
					rtnStr[2] = dbRowset.getString("RCC_CD");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}

	/**
     * EES_CTM_0422
	 * 입력된 Yard코드로 해당 OFC_CD를 얻어온다.<br>
	 *
	 * @param String yardCd
	 * @return String
	 * @exception DAOException, Exception
	 * @throws DAOException
	 */
	public String getOfcCdByYard(String yardCd) throws DAOException {
		DBRowSet dbRowset = null;
		String officeCd = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("yard_cd", yardCd);
			velParam.put("yard_cd", yardCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RestuffingContainerRegistrationDBDAOGetOfficeByYardRSQL(), param, velParam);
			if (dbRowset.next()) {
				officeCd = dbRowset.getString("OFC_CD");
			} else {
				officeCd = "E";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return officeCd;
	}

	/**
     * EES_CTM_0422
	 * MST Container의 정보를 얻어온다.<br>
	 *
	 * @param String cntrNo
	 * @return MstContainerInfoVO
	 * @exception DAOException, Exception
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public MstContainerInfoVO getCntrInfo(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		MstContainerInfoVO cntrInfo = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<MstContainerInfoVO> list = null;
		try{
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RestuffingContainerRegistrationDBDAOGetContainerInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MstContainerInfoVO.class);

			if (dbRowset == null || list.size() < 1)
				return null;
			else
				cntrInfo =(MstContainerInfoVO) (list.get(0));

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cntrInfo;
	}

	/**
     * EES_CTM_0422
	 * Container의 마지막 상태 정보를 얻어온다.<br>
	 *
	 * @param String cntrNo
	 * @param String evnt_dt
	 * @return CtmCntrMovInfoVO
	 * @exception DAOException, Exception
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public CtmCntrMovInfoVO searchMovementStatusVD(String cntrNo, String evnt_dt) throws DAOException {
		DBRowSet dbRowset = null;
		CtmCntrMovInfoVO cntrInfo = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);
			param.put("evnt_dt", evnt_dt);
			velParam.put("evnt_dt", evnt_dt);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RestuffingContainerRegistrationDBDAOGetCntrMovInfoRSQL(), param, velParam);
			List<CtmCntrMovInfoVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, CtmCntrMovInfoVO.class);
			log.info ("LIST SIZE : "  + list.size());
			if (list.size() < 1) {
				return null;
			} else {
				cntrInfo =(CtmCntrMovInfoVO) (list).get(0);
				log.info ("LIST SIZE : "  + cntrInfo.getMvmtStsCd());
				return cntrInfo;
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
     * EES_CTM_0422
	 * Container의 마지막 상태 정보를 얻어온다.<br>
	 *
	 * @param String cntrNo
	 * @param String cnmvIdNo
	 * @param String cnmvYr
	 * @return CusCtmMovementVO
	 * @exception DAOException, Exception
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public CusCtmMovementVO getMovementInfo(String cntrNo, String cnmvIdNo, String cnmvYr) throws DAOException {
		DBRowSet dbRowset = null;
		CusCtmMovementVO cntrInfo = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("cntr_no", cntrNo);
			param.put("cnmv_id_no", cnmvIdNo);
			param.put("cnmv_yr", cnmvYr);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RestuffingContainerRegistrationDBDAOGetMovementInfoRSQL(), param, velParam);
			List<CusCtmMovementVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, CusCtmMovementVO.class);
			log.info ("LIST SIZE : "  + list.size());
			if (list.size() < 1) {
				return null;
			} else {
				cntrInfo =(CusCtmMovementVO) (list).get(0);
				log.info ("LIST SIZE : "  + cntrInfo.getMvmtStsCd());
				return cntrInfo;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
     * EES_CTM_0422
	 * Comtainer Movement Seq Table 정보 가져오는 쿼리 일반.
	 * 모든 Container Movement SEQ는 하나로 처리한다<br>
	 *
	 * @param String cgo_type
	 * @param String mvmtStsCd
	 * @return CntrMvmtSeqInfoVO
	 * @exception DAOException, Exception
	 * @throws DAOException
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
		try{
			param.put("cgo_type", cgoType);
			velParam.put("cgo_type", cgoType);
			param.put("mvmt_sts_cd", mvmtStsCd);
			velParam.put("mvmt_sts_cd", mvmtStsCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RestuffingContainerRegistrationDBDAOGetCNTRMovSeqRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrMvmtSeqInfoVO.class);
			if (list.size() < 1) {
				rtnVO = new CntrMvmtSeqInfoVO();
				rtnVO.setCnmvLvlNo("0");
				return rtnVO;
			} else
				rtnVO = list.get(0);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
     * EES_CTM_0422
	 * 컨테이너 이동정보를 변경 등록한다.<br>
	 *
	 * @param InsCtmMvmtXchVO insCtmMvmtXchVO
	 * @exception DAOException, Exception
	 * @throws DAOException
	 */
	public void addCtmMvmtXch(InsCtmMvmtXchVO insCtmMvmtXchVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = insCtmMvmtXchVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new RestuffingContainerRegistrationDBDAOInsertCtmMvmtXchCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
     * EES_CTM_0422
	 * 컨테이너 이동정보 상세내역 변경 등록한다.<br>
	 *
	 * @param CtmMvmtXchDtlVO ctmMvmtXchDtlVO
	 * @exception DAOException, Exception
	 * @throws DAOException
	 */
	public void addCtmMvmtXchDtl(CtmMvmtXchDtlVO ctmMvmtXchDtlVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = ctmMvmtXchDtlVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new RestuffingContainerRegistrationDBDAOaddCtmMvmtXchDtlCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
     * EES_CTM_0422
	 * CNTR_XCH_SEQ의 최대값을 구해온다.<br>
	 *
	 * @param String cntrNo
	 * @return  String
	 * @exception DAOException, Exception
	 * @throws DAOException
	 */
	public String getMaxCntrXchSeq(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		String officeCd = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RestuffingContainerRegistrationDBDAOgetMaxCntrXchSeqRSQL(), param, velParam);
			if (dbRowset.next()) {
				officeCd = dbRowset.getString("MX");
			} else {
				officeCd = "E";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return officeCd;
	}

	/**
     * EES_CTM_0422
	 * CNTR_XCH_SEQ의 최대값을 구해온다.<br>
	 *
	 * @param String cntrNo
	 * @return  String
	 * @exception DAOException, Exception
	 * @throws DAOException
	 */
	public String getMaxCntrCycNo(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		String officeCd = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RestuffingContainerRegistrationDBDAOgetMaxCntrCycNoRSQL(), param, velParam);
			if (dbRowset.next()) {
				officeCd = dbRowset.getString("MX");
			} else {
				officeCd = "E";
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return officeCd;
	}

	/**
     * EES_CTM_0422
	 * BKG_CONTAINER 에서 SPLIT된 부킹을 찾아온다.<br>
	 *
	 * @param String cntrNo
	 * @return  String
	 * @exception DAOException, Exception
	 * @throws DAOException
	 */
	public String getBkgSplitRSQL(String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		StringBuffer strRtn = new StringBuffer();

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RestuffingContainerRegistrationDBDAOGetBkgSplitRSQL(), param, velParam);
			while (dbRowset.next()) {
				strRtn.append(dbRowset.getString("BKG_NO")).append("|").append(dbRowset.getString("BL_NO")).append("^^");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return strRtn.toString();
	}



	/**
	 * Container의 최종 ID_NO번호를 조회한다.<br>
	 *
	 * @param String cntrNo
	 * @param String cnmvYr
	 * @return String
	 * @throws DAOException
	 */
	public String getContainerMaxSeq(String cntrNo, String cnmvYr) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("cntr_no", cntrNo);
			param.put("cnmv_yr", cnmvYr);
			velParam.putAll(param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RestuffingContainerRegistrationDBDAOGetContainerMovementMaxSeqRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnStr = dbRowset.getString("ID_SEQ");
			} else return "0";
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
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
	 */
	public String getContainerMaxId(String cntrNo, String cnmvYr) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			param.put("cntr_no", cntrNo);
			param.put("cnmv_yr", cnmvYr);
			velParam.putAll(param);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RestuffingContainerRegistrationDBDAOGetBkgContainerCycNoRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtnStr = dbRowset.getString("ID_NO");
			} else return "0";
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnStr;
	}
}