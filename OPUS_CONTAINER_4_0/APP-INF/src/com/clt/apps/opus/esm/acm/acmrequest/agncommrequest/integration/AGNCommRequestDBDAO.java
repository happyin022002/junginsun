/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommRequestDBDAO.java
*@FileTitle : AGNCommRequestDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.26
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.26 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.basic.AGNCommRequestBCImpl;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.AGNCommRequestVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.AgmtInfoVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.AgnReqCalCondVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.AgnReqRevInfoVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.BkgCreDtInfoVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.BkgNumberInfoVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.BkgQtyInfoVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.CalcDtlBkgRevenueVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.ChgAmtInfoVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.ChgAmtRtInfoVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.ChgInfoVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.OfficeCodeInfoVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.SaDtInfoVO;
import com.clt.apps.opus.esm.acm.acmrequest.agncommrequest.vo.VslSvcLaneInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS AGNCommRequestDBDAO <br>
 * - OPUS-ACMRequest system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM, Sang-Soo
 * @see AGNCommRequestBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class AGNCommRequestDBDAO extends DBDAOSupport {

	/**
	 * [ESM_ACM_0006]
	 * Agent Commission Request 목록을 조회<br>
	 *
	 * @param AGNCommRequestVO agnCommRequestVO
	 * @return List<AGNCommRequestVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AGNCommRequestVO> searchAGNCommRequest(AGNCommRequestVO agnCommRequestVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AGNCommRequestVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agnCommRequestVO != null) {
				Map<String, String> mapVO= agnCommRequestVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOSearchAGNCommRequestListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGNCommRequestVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0006] Request<br>
	 * Agent Commission Request 화면의 Request 관련 정보 저장<br>
	 *
	 * @param List<AGNCommRequestVO> agnCommRequestVOList
	 * @throws DAOException
	 */
	public void requestAGNCommRequest(List<AGNCommRequestVO> agnCommRequestVOList) throws DAOException {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (agnCommRequestVOList.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommRequestDBDAORequestAGNCommRequestListUSQL(), agnCommRequestVOList, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006] <br>
	 * calling procedure<br>
	 *
	 * @param AGNCommRequestVO agnCommRequestVO
	 * @throws DAOException
	 */
	public void executeAcmTest3Prc(AGNCommRequestVO agnCommRequestVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (agnCommRequestVO != null) {
				Map<String, String> mapVO= agnCommRequestVO.getColumnValues();
				param.putAll(mapVO);
			}
			new SQLExecuter("").executeSP((ISQLTemplate)new AGNCommRequestDBDAOExecuteAcmTest3PrcUSQL(), param, null);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006] Search for Ex. Rate Input<br>
	 * Ex. Rate Input을 위한 데이터 조회
	 *
	 * @param AGNCommRequestVO agnCommRequestVO
	 * @return List<AGNCommRequestVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AGNCommRequestVO> searchRateInput(AGNCommRequestVO agnCommRequestVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AGNCommRequestVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agnCommRequestVO != null) {
				Map<String, String> mapVO= agnCommRequestVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOSearchRateInputListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGNCommRequestVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0006] Ex. Rate Input<br>
	 *
	 * @param AGNCommRequestVO agnCommRequestVO
	 * @throws DAOException
	 */
	public void executeRateInput(AGNCommRequestVO agnCommRequestVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (agnCommRequestVO != null) {
				Map<String, String> mapVO= agnCommRequestVO.getColumnValues();
				param.putAll(mapVO);
			}
			int updCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAOExecuteRateInputListUSQL(), param, null);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update No" + " SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006] Ex. Rate Input (Detal)<br>
	 *
	 * @param AGNCommRequestVO agnCommRequestVO
	 * @throws DAOException
	 */
	public void executeRateDetalInput(AGNCommRequestVO agnCommRequestVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (agnCommRequestVO != null) {
				Map<String, String> mapVO= agnCommRequestVO.getColumnValues();
				param.putAll(mapVO);
			}
			int updCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAOExecuteRateDetalInputListUSQL(), param, null);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update No" + " SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @return String
	 * @throws DAOException
	 */
	public String getCalcNo() throws DAOException {
		DBRowSet dbRowset = null;
		String calcNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetCalcNoInfoRSQL(), param, null);
			if(dbRowset.next()) {
				calcNo = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return calcNo;
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param String bkgNo
	 * @return BkgNumberInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgNumberInfoVO getBkgNumber(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgNumberInfoVO> list = null;
		BkgNumberInfoVO rtnVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetBkgNumberInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgNumberInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param AgnReqCalCondVO agnCondVO
	 * @throws DAOException
	 */
	public void modifyAcmAgnBkgInfo(AgnReqCalCondVO agnCondVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (agnCondVO != null) {
				Map<String, String> mapVO= agnCondVO.getColumnValues();

				param.putAll(mapVO);
			}

			int updCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAOModifyAcmAgnBkgInfoUSQL(), param, null);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param AgnReqCalCondVO agnCondVO
	 * @throws DAOException
	 */
	public void modifyAcmAgnCommZeroSum(AgnReqCalCondVO agnCondVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (agnCondVO != null) {
				Map<String, String> mapVO= agnCondVO.getColumnValues();

				param.putAll(mapVO);
			}

			int updCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAOModifyAcmAgnCommZeroSumUSQL(), param, null);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String getBkgBdrFlg(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String bkgBdrFlg = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetBkgBdrFlgInfoRSQL(), param, null);
			if(dbRowset.next()) {
				bkgBdrFlg = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return bkgBdrFlg;
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgQtyInfoVO getBkgQty(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgQtyInfoVO> list = null;
		BkgQtyInfoVO rtnVO = new BkgQtyInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetBkgQtyInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgQtyInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param String bkgNo
	 * @param String calcNo
	 * @param String blCvrdTpCd
	 * @exception DAOException
	 */
	public void addAcmAgnBkgInfoHis(String bkgNo, String calcNo, String blCvrdTpCd) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("calc_no", calcNo);
			param.put("bl_cvrd_tp_cd", blCvrdTpCd);
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAOAddAcmAgnBkgInfoHisInfoCSQL(), param, velParam);
			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert No" + " SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param String bkgNo
	 * @return BkgCreDtInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCreDtInfoVO getBkgCreDt(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCreDtInfoVO> list = null;
		BkgCreDtInfoVO rtnVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetBkgCreDtInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCreDtInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String getRevMon(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String revMon = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetRevMonInfoRSQL(), param, null);
			if (dbRowset.next()) {
				revMon = dbRowset.getString("REV_MON");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return revMon;
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param String mstBkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String getRtAplyDt(String mstBkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String rtAplyDt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (mstBkgNo != null) {
				param.put("bkg_no", mstBkgNo);
				velParam.put("bkg_no", mstBkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetRtAplyDtInfoRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtAplyDt = dbRowset.getString("RT_APLY_DT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtAplyDt;
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param String bkgNo
	 * @return SaDtInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public SaDtInfoVO getSaDt(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SaDtInfoVO> list = null;
		SaDtInfoVO rtnVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetSaDtInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SaDtInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param String bkgNo
	 * @param String rtAplyDt
	 * @return ChgAmtInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public ChgAmtInfoVO getChgAmt(String bkgNo, String rtAplyDt) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChgAmtInfoVO> list = null;
		ChgAmtInfoVO rtnVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			param.put("rt_aply_dt", rtAplyDt);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetChgAmtInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChgAmtInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param String bkgNo
	 * @return OfficeCodeInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public OfficeCodeInfoVO getOfficeCode(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<OfficeCodeInfoVO> list = null;
		OfficeCodeInfoVO rtnVO = new OfficeCodeInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetOfficeCodeInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OfficeCodeInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0006]
	 *
	 * @param String bkgNo
	 * @throws DAOException
	 */
	public void removeAcmAgnBkgInfo(String bkgNo) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAORemoveAcmAgnBkgInfoDSQL(), param, null);
			if (delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006]
	 *
	 * @param String bkgNo
	 * @throws DAOException
	 */
	public void removeAcmAgnCommDtl(String bkgNo) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAORemoveAcmAgnCommDtlDSQL(), param, null);
			if (delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006]
	 *
	 * @param String bkgNo
	 * @throws DAOException
	 */
	public void removeAcmAgnComm(String bkgNo) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAORemoveAcmAgnCommDSQL(), param, null);
			if (delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006]
	 *
	 * @param String bkgNo
	 * @throws DAOException
	 */
	public void removeAcmAgnCommChg(String bkgNo) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAORemoveAcmAgnCommChgDSQL(), param, null);
			if (delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006]
	 *
	 * @param String bkgNo
	 * @throws DAOException
	 */
	public void removeAcmAgnCommRev(String bkgNo) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAORemoveAcmAgnCommRevDSQL(), param, null);
			if (delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006]
	 *
	 * @param String bkgNo
	 * @throws DAOException
	 */
	public void removeAcmAgnCommTrsp(String bkgNo) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAORemoveAcmAgnCommTrspDSQL(), param, null);
			if (delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param String bkgNo
	 * @param String usrId
	 * @return List<AgmtInfoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgmtInfoVO> getZeroSumObjList(String bkgNo, String usrId) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgmtInfoVO> list = new ArrayList<AgmtInfoVO>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			param.put("usr_id", usrId);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetZeroSumObjListRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgmtInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0006]
	 *
	 * @param OfficeCodeInfoVO officeCodeInfoVO
	 * @throws DAOException
	 */
	public void addAcmAgnBkgInfo(OfficeCodeInfoVO officeCodeInfoVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (officeCodeInfoVO != null) {
				Map<String, String> mapVO= officeCodeInfoVO.getColumnValues();

				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAOAddAcmAgnBkgInfoCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006]
	 *
	 * @param AgnReqCalCondVO condVO
	 * @throws DAOException
	 */
	public void addAcmAgnBkgInfoHis(AgnReqCalCondVO condVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (condVO != null) {
				Map<String, String> mapVO= condVO.getColumnValues();

				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAOAddAcmAgnBkgInfoHisCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param AgnReqCalCondVO agnReqCalCondVO
	 * @return List<AgmtInfoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgmtInfoVO> getAgmtInfo(AgnReqCalCondVO agnReqCalCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgmtInfoVO> list = new ArrayList<AgmtInfoVO>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agnReqCalCondVO != null) {
				Map<String, String> mapVO= agnReqCalCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetAgmtInfoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgmtInfoVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

//	/**
//	 * [ESM_ACM_0006] Calculate<br>
//	 *
//	 * @param AgmtInfoVO agmtVO
//	 * @return int
//	 * @throws DAOException
//	 */
//	public int getStepCnt(AgmtInfoVO agmtVO) throws DAOException {
//		DBRowSet dbRowset = null;
//		int stepCnt = 0;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//
//		try{
//			if (agmtVO != null) {
//				Map<String, String> mapVO= agmtVO.getColumnValues();
//
//				param.putAll(mapVO);
//			}
//			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetStepCntInfoRSQL(), param, null);
//			if (dbRowset.next()) {
//				stepCnt = Integer.parseInt(dbRowset.getString("STEP_CNT"));
//			}
//		} catch(SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch(Exception ex) {
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//		return stepCnt;
//	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param AgmtInfoVO agmtVO
	 * @return int
	 * @throws DAOException
	 */
	public String getMaxAcSeq(AgmtInfoVO agmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		String maxAcSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetMaxAcSeqInfoRSQL(), param, null);
			if (dbRowset.next()) {
				maxAcSeq = dbRowset.getString("MAX_AC_SEQ");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return maxAcSeq;
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param String ofcCd
	 * @return OfficeCodeInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public OfficeCodeInfoVO getOfcInfo(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<OfficeCodeInfoVO> list = null;
		OfficeCodeInfoVO rtnVO = new OfficeCodeInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (ofcCd != null) {
				param.put("ofc_cd", ofcCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetOfcInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OfficeCodeInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param AgmtInfoVO agmtVO
	 * @return int
	 * @throws DAOException
	 */
	public String getPayXchRt(AgmtInfoVO agmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		String payXchRt = "0";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetPayXchRtInfoRSQL(), param, velParam);
			if (dbRowset.next()) {
				payXchRt = dbRowset.getString("PAY_XCH_RT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return payXchRt;
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param String bkgNo
	 * @param String saDt
	 * @return AgnReqRevInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public AgnReqRevInfoVO getBlRev(String bkgNo, String saDt) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgnReqRevInfoVO> list = null;
		AgnReqRevInfoVO rtnVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
				param.put("sa_dt", saDt);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetBlRevInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgnReqRevInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param AgmtInfoVO agmtVO
	 * @return AgnReqRevInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public AgnReqRevInfoVO getStrcRev(AgmtInfoVO agmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgnReqRevInfoVO> list = null;
		AgnReqRevInfoVO rtnVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetStrcRevInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgnReqRevInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param AgmtInfoVO agmtVO
	 * @return AgnReqRevInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public AgnReqRevInfoVO getCafRev(AgmtInfoVO agmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgnReqRevInfoVO> list = null;
		AgnReqRevInfoVO rtnVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetCafRevInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgnReqRevInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0006]
	 *
	 * @param String bkgNo
	 * @throws DAOException
	 */
	public void removeAcmAgnCommChgRef(String bkgNo) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAORemoveAcmAgnCommChgRefDSQL(), param, null);
			if (delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006]
	 *
	 * @param AgmtInfoVO agmtVO
	 * @throws DAOException
	 */
	public void addAcmAgnCommChgRef(AgmtInfoVO agmtVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAOAddAcmAgnCommChgRefCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006]
	 *
	 * @param AgmtInfoVO agmtVO
	 * @throws DAOException
	 */
	public void addAcmAgnCommChg(AgmtInfoVO agmtVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAOAddAcmAgnCommChgCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param String bkgNo
	 * @return ChgInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public ChgInfoVO getChgInfo1(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChgInfoVO> list = null;
		ChgInfoVO rtnVO = new ChgInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetChgInfo1RSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChgInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}


	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param String bkgNo
	 * @return ChgInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public ChgInfoVO getChgInfo2(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChgInfoVO> list = null;
		ChgInfoVO rtnVO = new ChgInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetChgInfo2RSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChgInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param String bkgNo
	 * @return VslSvcLaneInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public VslSvcLaneInfoVO getVslSvcLaneInfo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<VslSvcLaneInfoVO> list = null;
		VslSvcLaneInfoVO rtnVO = new VslSvcLaneInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetVslSvcLaneInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VslSvcLaneInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0006]
	 *
	 * @param AgmtInfoVO agmtVO
	 * @throws DAOException
	 */
	public void addAcmAgnCommTrsp(AgmtInfoVO agmtVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAOAddAcmAgnCommTrspCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param String angCd
	 * @return String
	 * @throws DAOException
	 */
	public String getSpclAgmtCnt(String agnCd) throws DAOException {
		DBRowSet dbRowset = null;
		String cnt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("agn_cd", agnCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetSpclAgmtCntRSQL(), param, null);
			if(dbRowset.next()) {
				cnt = dbRowset.getString("CNT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}

	/**
	 * [ESM_ACM_0006]
	 *
	 * @param AgmtInfoVO agmtVO
	 * @throws DAOException
	 */
	public void removeAcmSpclCmpn(AgmtInfoVO agmtVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAORemoveAcmSpclCmpnDSQL(), param, null);
			if (delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006]
	 *
	 * @param AgmtInfoVO agmtVO
	 * @throws DAOException
	 */
	public void removeAcmSpclCmpnDtl(AgmtInfoVO agmtVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAORemoveAcmSpclCmpnDtlDSQL(), param, null);
			if (delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param AgmtInfoVO agmtVO
	 * @return String
	 * @throws DAOException
	 */
	public String getMaxSpclCmpnSeq(AgmtInfoVO agmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		String maxSpclCmpnSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetMaxSpclCmpnSeqRSQL(), param, null);
			if(dbRowset.next()) {
				maxSpclCmpnSeq = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return maxSpclCmpnSeq;
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param AgmtInfoVO agmtVO
	 * @return String
	 * @throws DAOException
	 */
	public String getPpdCrntSpclAmt(AgmtInfoVO agmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnVal = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetPpdCrntSpclAmtRSQL(), param, null);
			if(dbRowset.next()) {
				rtnVal = dbRowset.getString("PPD_CRNT_SPCL_AMT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVal;
	}

	/**
	 * [ESM_ACM_0006]
	 *
	 * @param AgmtInfoVO agmtVO
	 * @throws DAOException
	 */
	public void addAcmSpclCmpn(AgmtInfoVO agmtVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAOAddAcmSpclCmpnCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006]
	 *
	 * @param AgmtInfoVO agmtVO
	 * @throws DAOException
	 */
	public void addAcmSpclCmpnDtl(AgmtInfoVO agmtVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAOAddAcmSpclCmpnDtlCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param AgmtInfoVO agmtVO
	 * @return ChgAmtRtInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public ChgAmtRtInfoVO getChgAmtRtInfo(AgmtInfoVO agmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChgAmtRtInfoVO> list = null;
		ChgAmtRtInfoVO rtnVO = new ChgAmtRtInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetChgAmtRtInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChgAmtRtInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0006]
	 *
	 * @param AgmtInfoVO agmtVO
	 * @throws DAOException
	 */
	public void addAcmAgnCommRt(AgmtInfoVO agmtVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAOAddAcmAgnCommRtCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param AgmtInfoVO agmtVO
	 * @return String
	 * @throws DAOException
	 */
	public String getFxRealAmt(AgmtInfoVO agmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		String fxRealAmt = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetFxRealAmtInfoRSQL(), param, velParam);
			if(dbRowset.next()) {
				fxRealAmt = dbRowset.getString("FX_REAL_AMT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return fxRealAmt;
	}

	/**
	 * [ESM_ACM_0006] Calculate<br>
	 *
	 * @param AgmtInfoVO agmtVO
	 * @return AgmtInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public AgmtInfoVO getLoclXchRtComm(AgmtInfoVO agmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgmtInfoVO> list = null;
		AgmtInfoVO rtnVO = new AgmtInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOGetLoclXchRtCommInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgmtInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0006]
	 *
	 * @param AgmtInfoVO agmtVO
	 * @throws DAOException
	 */
	public void addAcmAgnCommFx(AgmtInfoVO agmtVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAOAddAcmAgnCommFxCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ESM_ACM_0006]
	 *
	 * @param AgmtInfoVO agmtVO
	 * @throws DAOException
	 */
	public void addAcmAgnCommDtlFx(AgmtInfoVO agmtVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAOAddAcmAgnCommDtlFxCSQL(), param, velParam);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ESM_ACM_0006]
	 *
	 * @param AgmtInfoVO agmtVO
	 * @throws DAOException
	 */
	public void addAcmAgnCommDtlFxMh(AgmtInfoVO agmtVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	
		
		try {
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAOAddAcmAgnCommDtlFxMhCSQL(), param, velParam);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006]
	 *
	 * @param List<AgmtInfoVO> zeroSumList
	 * @throws DAOException
	 */
	public void modifyAcmAgnCommZeroSum2(List<AgmtInfoVO> zeroSumList) throws DAOException {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (zeroSumList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommRequestDBDAOModifyAcmAgnCommZeroSum2CSQL(), zeroSumList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006]
	 *
	 * @param AgnReqCalCondVO condVO
	 * @throws DAOException
	 */
	public void addAcmAgnCommDtl(AgnReqCalCondVO condVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (condVO != null) {
				Map<String, String> mapVO= condVO.getColumnValues();

				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAOAddAcmAgnCommDtlCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * [ESM_ACM_0006]
	 *
	 * @param AgnReqCalCondVO condVO
	 * @throws DAOException
	 */
	public void addAcmAgnCommChgRefHis(AgnReqCalCondVO condVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (condVO != null) {
				Map<String, String> mapVO= condVO.getColumnValues();

				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAOAddAcmAgnCommChgRefHisCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * [ESM_ACM_0006]
	 *
	 * @param AgnReqCalCondVO condVO
	 * @throws DAOException
	 */
	public void addAcmAgnCommChgHis(AgnReqCalCondVO condVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (condVO != null) {
				Map<String, String> mapVO= condVO.getColumnValues();

				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAOAddAcmAgnCommChgHisCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006]
	 *
	 * @param AgnReqCalCondVO condVO
	 * @throws DAOException
	 */
	public void addAcmAgnCommRevHis(AgnReqCalCondVO condVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (condVO != null) {
				Map<String, String> mapVO= condVO.getColumnValues();

				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAOAddAcmAgnCommRevHisCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006]
	 *
	 * @param AgnReqCalCondVO condVO
	 * @throws DAOException
	 */
	public void addAcmAgnCommTrspHis(AgnReqCalCondVO condVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (condVO != null) {
				Map<String, String> mapVO= condVO.getColumnValues();

				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAOAddAcmAgnCommTrspHisCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006]
	 *
	 * @param AgnReqCalCondVO condVO
	 * @throws DAOException
	 */
	public void addAcmAgnCommDtlHis(AgnReqCalCondVO condVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (condVO != null) {
				Map<String, String> mapVO= condVO.getColumnValues();

				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAOAddAcmAgnCommDtlHisCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006]
	 *
	 * @param AgnReqCalCondVO condVO
	 * @throws DAOException
	 */
	public void addAcmAgnCommHis(AgnReqCalCondVO condVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (condVO != null) {
				Map<String, String> mapVO= condVO.getColumnValues();

				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAOAddAcmAgnCommHisCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0006]
	 *
	 * @param AgnReqCalCondVO condVO
	 * @throws DAOException
	 */
//	public void modifyCoaComCostAmt(AgnReqCalCondVO condVO) throws DAOException {
//		SQLExecuter sqlExe = new SQLExecuter("");
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		try {
//			if (condVO != null) {
//				Map<String, String> mapVO= condVO.getColumnValues();
//
//				param.putAll(mapVO);
//			}
//			int updCnt = sqlExe.executeUpdate((ISQLTemplate) new AGNCommRequestDBDAOModifyCoaComCostAmtUSQL(), param, null);
//			if (updCnt == Statement.EXECUTE_FAILED)
//				throw new DAOException("Fail to insert");
//		} catch (SQLException se) {
//			log.error(se.getMessage(), se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch(Exception ex) {
//			log.error(ex.getMessage(), ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//	}

	/**
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 Booking Revenue 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CalcDtlBkgRevenueVO> searchCalcDtlBkgRevenue(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CalcDtlBkgRevenueVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (calcDtlBkgRevenueVO != null) {
				Map<String, String> mapVO= calcDtlBkgRevenueVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOSearchCalcDtlBkgRevenueListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CalcDtlBkgRevenueVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 Booking Q'ty 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CalcDtlBkgRevenueVO> searchCalcDtlBkgQty(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CalcDtlBkgRevenueVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (calcDtlBkgRevenueVO != null) {
				Map<String, String> mapVO= calcDtlBkgRevenueVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOSearchCalcDtlBkgQtyListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CalcDtlBkgRevenueVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 Booking Route 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CalcDtlBkgRevenueVO> searchCalcDtlBkgRoute(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CalcDtlBkgRevenueVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (calcDtlBkgRevenueVO != null) {
				Map<String, String> mapVO= calcDtlBkgRevenueVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOSearchCalcDtlBkgRouteListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CalcDtlBkgRevenueVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 Charge Deduction 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CalcDtlBkgRevenueVO> searchCalcDtlChgDeduction(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CalcDtlBkgRevenueVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (calcDtlBkgRevenueVO != null) {
				Map<String, String> mapVO= calcDtlBkgRevenueVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOSearchCalcDtlChgDeductionListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CalcDtlBkgRevenueVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 Transportation Cost Deduction 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CalcDtlBkgRevenueVO> searchCalcDtlTrsCstDeduction(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CalcDtlBkgRevenueVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (calcDtlBkgRevenueVO != null) {
				Map<String, String> mapVO= calcDtlBkgRevenueVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOSearchCalcDtlTrsCstDeductionListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CalcDtlBkgRevenueVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 General Commission 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CalcDtlBkgRevenueVO> searchCalcDtlGeneralComm(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CalcDtlBkgRevenueVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (calcDtlBkgRevenueVO != null) {
				Map<String, String> mapVO= calcDtlBkgRevenueVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOSearchCalcDtlGeneralCommListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CalcDtlBkgRevenueVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 Container Handling Fee (CHF) 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CalcDtlBkgRevenueVO> searchCalcDtlCntrHandlingFee(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CalcDtlBkgRevenueVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (calcDtlBkgRevenueVO != null) {
				Map<String, String> mapVO= calcDtlBkgRevenueVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOSearchCalcDtlCntrHandlingFeeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CalcDtlBkgRevenueVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [ESM_ACM_0105] Retrive<br>
	 * Calculation Detail의 T/S Commission 목록을 조회<br>
	 *
	 * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	 * @return List<CalcDtlBkgRevenueVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CalcDtlBkgRevenueVO> searchCalcDtlTSCommission(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CalcDtlBkgRevenueVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (calcDtlBkgRevenueVO != null) {
				Map<String, String> mapVO= calcDtlBkgRevenueVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOSearchCalcDtlTSCommissionListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CalcDtlBkgRevenueVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 /**
	  * [ESM_ACM_0105] Retrive<br>
	  * Calculation Detail의 Commission Detail 목록을 조회<br>
	  *
	  * @param CalcDtlBkgRevenueVO calcDtlBkgRevenueVO
	  * @return List<CalcDtlBkgRevenueVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CalcDtlBkgRevenueVO> searchCalcDtlCommissionDtl(CalcDtlBkgRevenueVO calcDtlBkgRevenueVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CalcDtlBkgRevenueVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if (calcDtlBkgRevenueVO != null) {
				 Map<String, String> mapVO= calcDtlBkgRevenueVO.getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOSearchCalcDtlCommissionDtlListRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CalcDtlBkgRevenueVO.class);
		 } catch(SQLException se) {
			 log.error(se.getMessage(), se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 } catch(Exception ex) {
			 log.error(ex.getMessage(), ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return list;
	 }

	/**
	 * [ESM_ACM_0024]<br>
	 * Request 수행 후 메일을 보낼때 날짜 조회<br>
	 *
	 * @param String bkgNo
	 * @param String oftPayTermCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchBkgChgOftTermMatCnt(String bkgNo, String oftPayTermCd) throws DAOException {
		DBRowSet dbRowSet = null;
		String count = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("oft_pay_term_cd", oftPayTermCd);
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommRequestDBDAOSearchBkgChgOftTermMatCntRSQL(), param, null);
			if(dbRowSet.next()){
				count = dbRowSet.getString("BKG_CHG_RT_COUNT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return count;
	}

}