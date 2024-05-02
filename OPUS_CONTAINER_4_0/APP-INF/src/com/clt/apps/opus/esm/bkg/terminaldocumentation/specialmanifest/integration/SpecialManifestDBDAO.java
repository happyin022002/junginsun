/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialManifestDBDAO.java
*@FileTitle : Forwarder Code, Name Setup(ANRBS)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.11
*@LastModifier :
*@LastVersion : 1.0
* 2009.05.11
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.basic.SpecialManifestBCImpl;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.BayPlanCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.BayPlanListDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.BayPlanListVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.CntrBaseInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.CntrCgoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DeclBaseInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgBayRcvMsgDtlVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgBayRcvMsgVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgCargoCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgCntrInfoListVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgEdiVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgInqModiVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgListCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgListDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgListModiVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgSendDtlHistoryVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgSendHistoryVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgValidationCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.EurDgHisVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.EurDgListVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.EurDgSummaryListVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.EurRcvMsgDtlVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.EurRcvMsgVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.FeederInfoVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.FeederNameVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.FwdrListCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.FwdrListVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.MainMeansVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.MainPartiesVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.SendHistoryCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.SendHistoryDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.SpecialListCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.SpecialListDetailVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.SpecialListVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.UserRefVO;
import com.clt.framework.component.javamail.TemplateMail;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.table.ComRptDsgnXptInfoVO;
import com.clt.syscommon.common.table.BkgCstmsEurDgVO;
import com.clt.syscommon.common.table.ComUserVO;

/**
 * OPUS SpecialManifestDBDAO <br>
 * - OPUS-SpecialManifestBC system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Kyoung Jong Yun
 * @see SpecialManifestBCImpl 참조
 * @since J2EE 1.4
 */
public class SpecialManifestDBDAO extends DBDAOSupport {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * forwarder정보를 조회한다.(코드와 name으로 like검색)<br>
	 *
	 * @param fwdrListCondVO
	 * @return List<FwdrListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<FwdrListVO> searchForwarderListByCdNm(FwdrListCondVO fwdrListCondVO) throws DAOException {

		List<FwdrListVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(fwdrListCondVO != null) {
				Map<String, String> mapVO = fwdrListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialManifestDBDAOsearchForwarderListByCdNmRSQL(), param, velParam, FwdrListVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * forwarder정보를 입력한다.<br>
	 *
	 * @param List<FwdrListVO> insModels
	 * @throws DAOException
	 */
	public void addForwarderList(List<FwdrListVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;

			if(insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialManifestDBDAOmodifyForwarderListCSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						//throw new DAOException("Fail to insert No"+ i + " SQL");
						//throw new DAOException(new ErrorHandler("BKG00102",new String[]{}).getUserMessage());
						throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getUserMessage());

				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * forwarder정보를 삭제한다.
	 *
	 * @param List<FwdrListVO> delModels
	 * @throws DAOException
	 */
	public void removeForwarderList(List<FwdrListVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialManifestDBDAOmodifyForwarderListDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * EDI로 수신한 Bay Plan 정보를 조회한다.
	 *
	 * @return List<BayPlanListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BayPlanListVO> searchBayPlanListByVvdPort() throws DAOException {

		List<BayPlanListVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialManifestDBDAOsearchBayPlanListByVvdPortRSQL(), param, velParam, BayPlanListVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * EDI로 수신한 Bay Plan 상세 정보를 조회한다.
	 *
	 * @param BayPlanCondVO bayPlanCondVO
	 * @return List<BayPlanListDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BayPlanListDetailVO> searchBayPlanDetailListByBaiId(BayPlanCondVO bayPlanCondVO) throws DAOException {

		List<BayPlanListDetailVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if(bayPlanCondVO != null) {
				Map<String, String> mapVO = bayPlanCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialManifestDBDAOsearchBayPlanDetailListByBaiIdRSQL(), param, velParam, BayPlanListDetailVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}


	/**
	 * VVD와 Port를 가지고 Bay Plan에서 Cell position을 자동으로 가져 왔는 지 여부를 조회 한다.<br>
	 *
	 * @param dgListCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchBayPlanInfo(DgListCondVO dgListCondVO) throws DAOException {

		String retVal = "N";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(dgListCondVO != null) {
				Map<String, String> mapVO = dgListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialManifestDBDAOsearchBayPlanInfoRSQL(), param, velParam);


			if(dbRowset.getRowCount() > 0) {
				if (dbRowset.next()) {
					retVal = "Y";
				}
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return retVal;
	}
	
	/**
	 * 구주위험물 테이블들에서 데이타를 가져온다.<br>
	 *
	 * @param dgListCondVO
	 * @return List<DgListDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DgListDetailVO> searchDgInfoAtLocal(DgListCondVO dgListCondVO) throws DAOException {
		List<DgListDetailVO> list = null; 
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(dgListCondVO != null) {
				Map<String, String> mapVO = dgListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = null;
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialManifestDBDAOsearchDgInfoAtLocalRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DgListDetailVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Lloyd, vessel name등 Vessel 정보를 조회해옴-local,<br>
	 * 도착일시/출발일시 정보를 Local 운항스케쥴에서 조회함 <br>
	 *
	 * @param dgListCondVO
	 * @return DgListDetailVO
	 * @throws DAOException
	 */
	public DgListDetailVO searchVslInfo(DgListCondVO dgListCondVO) throws DAOException {

		DgListDetailVO vslInfo = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(dgListCondVO != null) {
				Map<String, String> mapVO = dgListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			List list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialManifestDBDAOsearchVslInfoRSQL(), param, velParam, DgListDetailVO.class);
			if (list.size() > 0) vslInfo = (DgListDetailVO)list.get(0);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return vslInfo;
	}

	/**
	 * Auo-Transmit 자동 전송 여부를 조회한다.<br>
	 *
	 * @param dgListCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchAutoSentInfo(DgListCondVO dgListCondVO) throws DAOException {

		String strAutoSndTpCd = "No";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(dgListCondVO != null) {
				Map<String, String> mapVO = dgListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialManifestDBDAOsearchAutoSentInfoRSQL(), param, velParam);
			if (dbRowset.next()) {
				strAutoSndTpCd = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return strAutoSndTpCd;
	}

	/**
	 * EDI전송 결과를 조회 해 온다.<br>
	 *
	 * @param dgListCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchEdiSentStatus(DgListCondVO dgListCondVO) throws DAOException {

		String strEdiSentStatus = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(dgListCondVO != null) {
				Map<String, String> mapVO = dgListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialManifestDBDAOsearchEdiSentStatusRSQL(), param, velParam);
			if (dbRowset.next()) {
				strEdiSentStatus = dbRowset.getString(1);
			}
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return strEdiSentStatus;
	}

	/**
	 * ANRBS에서 SVC_RQST_NO를 조회함(Declaration : Discharging인 것만 DEP_LOC_CD = Port_cd) <br>
	 *
	 * @param dgListCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchSSRNo(DgListCondVO dgListCondVO) throws DAOException {

		String strSSRNo = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(dgListCondVO != null) {
				Map<String, String> mapVO = dgListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialManifestDBDAOsearchSSRNoRSQL(), param, velParam);
			
			if (dbRowset.next())
				strSSRNo = dbRowset.getString(1);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strSSRNo;
	}


	/**
	 * BKG의 위험물 테이블에서 데이타를 조회해온다.<br>
	 *
	 * @param dgListCondVO
	 * @return List<DgListDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DgListDetailVO> searchDgInfoAtBkgDg(DgListCondVO dgListCondVO) throws DAOException {

		List<DgListDetailVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(dgListCondVO != null) {
				Map<String, String> mapVO = dgListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialManifestDBDAOsearchDgInfoAtBkgDgRSQL(), param, velParam, DgListDetailVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}
	
	/**
	 * BKG의 위험물 테이블에서 데이타를 조회해온다.<br>
	 *
	 * @param dgListCondVO
	 * @param String chkRst
	 * @return List<DgListDetailVO>
	 * @throws DAOException
	 */
	
	@SuppressWarnings("unchecked")
	public List<DgListDetailVO> searchDgInfoAtBkgDgTransit(DgListCondVO dgListCondVO,String chkRst) throws DAOException {

		List<DgListDetailVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(dgListCondVO != null) {
				Map<String, String> mapVO = dgListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("chkRst",chkRst);
				velParam.put("chkRst",chkRst);
			}

			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialManifestDBDAOsearchDgInfoAtBkgDgTransitRSQL(), param, velParam, DgListDetailVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	
	/**
	 * Transit에서 Discharge인지 Load인지 판별한다..<br>
	 *
	 * @param dgListCondVO
	 * @return String
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchDgLoadorDischarge(DgListCondVO dgListCondVO) throws DAOException {

		String retVal = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(dgListCondVO != null) {
				Map<String, String> mapVO = dgListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SpecialManifestDBDAOsearchDgLoadorDischargeRSQL(), param, velParam);
			if(dbRowset.getRowCount() > 0) {
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return retVal;
	}

	
	/**
	 * Lloyd, vessel name등 Vessel 정보를 조회해옴-(Booking 쪽 data),<br>
	 * 도착일시/출발일시 정보를 Local 운항스케쥴에서 조회함- (Booking 쪽 data) <br>
	 *
	 * @param dgListCondVO
	 * @return DgListDetailVO
	 * @throws DAOException
	 */
	public DgListDetailVO serachVslAtCommon(DgListCondVO dgListCondVO) throws DAOException {

		DgListDetailVO vslInfo = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(dgListCondVO != null) {
				Map<String, String> mapVO = dgListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			List list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialManifestDBDAOserachVslAtCommonRSQL(), param, velParam, DgListDetailVO.class);
			
			if (list.size() > 0) vslInfo = (DgListDetailVO)list.get(0);
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return vslInfo;
	}


	/**
	 * special UN number정보를 조회한다.(ANRBS)<br>
	 *
	 * @param SpecialListCondVO specialListCondVO
	 * @return List<SpecialListDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SpecialListDetailVO> searchSpecialListByCdNm(SpecialListCondVO specialListCondVO) throws DAOException {

		List<SpecialListDetailVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(specialListCondVO != null) {
				Map<String, String> mapVO = specialListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialManifestDBDAOsearchSpecialListByCdNmRSQL(), param, velParam, SpecialListDetailVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * special UN No 정보를 저장한다.
	 *
	 * @param List<SpecialListVO> insModels
	 * @throws DAOException
	 */
	public void addSpecialList(List<SpecialListVO> insModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;

			if(insModels.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialManifestDBDAOaddSpecialListCSQL(), insModels, null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						//throw new DAOException("Fail to insert No"+ i + " SQL");
						throw new DAOException(new ErrorHandler("BKG00102",new String[]{}).getMessage());

				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


	}

	/**
	 * special UN No 정보를 삭제한다.
	 *
	 * @param List<SpecialListVO> delModels
	 * @throws DAOException
	 */
	public void removeSpecialList(List<SpecialListVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialManifestDBDAOremoveSpecialListDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						//throw new DAOException("Fail to delete No"+ i + " SQL");
						throw new DAOException(new ErrorHandler("BKG00110",new String[]{}).getMessage());
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


	}

	/**
	 * VSL 정보를 생성한다.(barge에 한해)
	 *
	 * @param DgListModiVO dgListModiVO
	 * @throws DAOException
	 */
	public void addVslInfo(DgListModiVO dgListModiVO) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = dgListModiVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new SpecialManifestDBDAOaddVslInfoCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException(new ErrorHandler("BKG00102",new String[]{}).getMessage());
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


	}

	/**
	 * VSL 정보를 업데이트한다.(barge에 한해)
	 *
	 * @param DgListModiVO dgListModiVO
	 * @throws DAOException
	 */
	public void modifyVslInfo(DgListModiVO dgListModiVO) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = dgListModiVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new SpecialManifestDBDAOmodifyVslInfoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException(new ErrorHandler("BKG00102",new String[]{}).getMessage());
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


	}

	/**
	 * 위험물 정보들을 신규생성한다.
	 *
	 * @param List<DgListModiVO> insModels
	 * @throws DAOException
	 */
	public void addDgList(List<DgListModiVO> insModels) throws DAOException {

		try {
			int result = 0;

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			//Map<String, Object> velParam = new HashMap<String, Object>();

			DgListModiVO dgListModiVO = null;

			if(insModels.size() > 0) {

				for(int i = 0 ; i < insModels.size(); i++) {

					dgListModiVO = insModels.get(i);
					Map<String, String> mapVO = dgListModiVO.getColumnValues();
					param.putAll(mapVO);
					//velParam.putAll(mapVO);


					result = new SQLExecuter("").executeUpdate((ISQLTemplate)new SpecialManifestDBDAOaddDgListCSQL(), param, null);
					if(result == Statement.EXECUTE_FAILED) {
						throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
					}
				}

			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}



	}

	/**
	 * 위험물 정보들을 업데이트한다.
	 *
	 * @param List<DgListModiVO> updModels
	 * @throws DAOException
	 */
	public void modifyDgList(List<DgListModiVO> updModels) throws DAOException {

		int result[] = new int[updModels.size()];

		try {

			if(updModels.size() > 0) {
				for (int i=0; i < updModels.size(); i++) {
					//query parameter
					Map<String, Object> param = new HashMap<String, Object>();
					//velocity parameter
					Map<String, Object> velParam = new HashMap<String, Object>();

					Map<String, String> mapVO = updModels.get(i).getColumnValues();
					
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					if (!"NYK".equals(updModels.get(i).getCgoOprCd())) {
						
						param.put("cntr_no", updModels.get(i).getCntrNoOld());
						velParam.put("cntr_no", updModels.get(i).getCntrNoOld());
						result[i] = new SQLExecuter("").executeUpdate((ISQLTemplate)new SpecialManifestDBDAOremoveDgListDSQL(), param, velParam);
						
						param.put("cntr_no", updModels.get(i).getCntrNo());
						velParam.put("cntr_no", updModels.get(i).getCntrNo());
						result[i] = new SQLExecuter("").executeUpdate((ISQLTemplate)new SpecialManifestDBDAOaddDgListCSQL(), param, velParam);
						
					}else{
						result[i] = new SQLExecuter("").executeUpdate((ISQLTemplate)new SpecialManifestDBDAOmodifyDgListUSQL(), param, velParam);						
					}
				}
				
				for(int i = 0; i < result.length; i++){
					if(result[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");

				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}



	}

	/**
	 * 위험물 정보들을 삭제한다.<br>
	 *
	 * @param List<DgListModiVO> delModels
	 * @throws DAOException
	 */
	public void removeDgList(List<DgListModiVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialManifestDBDAOremoveDgListDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


	}

	/**
	 * 위험물 히스토리 정보들을 삭제한다.<br>
	 *
	 * @param List<DgListModiVO> delModels
	 * @throws DAOException
	 */
	public void removeDgHisList(List<DgListModiVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialManifestDBDAOremoveDgHisListDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 부킹 앞단의 .<br>
	 *
	 * @param List<DgListModiVO> delModels
	 * @throws DAOException
	 */
	public void updateBkgDgCgoList(List<DgListModiVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialManifestDBDAOupdateBkgCgoListUSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 위험물 히스토리 정보들을 삭제한다.<br>
	 *
	 * @param List<DgListModiVO> delModels
	 * @throws DAOException
	 */
	public void updateSpclCgoList(List<DgListModiVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialManifestDBDAOupdateSpclCgoListUSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Danger cargo 컨테이너 목록 조회<br>
	 *
	 * @param DgCargoCondVO dgCargoCondVO
	 * @return List<BkgCstmsEurDgVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCstmsEurDgVO> searchBkgCstmsEurDgList(DgCargoCondVO dgCargoCondVO) throws DAOException {
		List<BkgCstmsEurDgVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (dgCargoCondVO != null)
			{
				Map<String, String> mapVO = dgCargoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			list = (List)new SQLExecuter("").executeQuery(
					(ISQLTemplate)new SpecialManifestDBDAOsearchBkgCstmsEurDgListRSQL(), param, velParam, BkgCstmsEurDgVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Danger cargo 정보를 컨테이너 단위로 조회한다.
	 *
	 * @param dgCargoCondVO
	 * @return DgInqModiVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DgInqModiVO> searchDgInfoinquiry(DgCargoCondVO dgCargoCondVO) throws DAOException {

		//DgInqModiVO dgInqModiVO = new DgInqModiVO();
		List<DgInqModiVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (dgCargoCondVO != null)
			{
				Map<String, String> mapVO = dgCargoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
//			list = (List)new SQLExecuter("").executeQuery(
//					(ISQLTemplate)new SpecialManifestDBDAOsearchDgInfoinquiryRSQL(), param, velParam, DgInqModiVO.class);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SpecialManifestDBDAOsearchDgInfoinquiryRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,DgInqModiVO.class);

//			if (list != null && list.size() > 0) {
//				dgInqModiVO = (DgInqModiVO) list.get(list.size() - 1);
//			}


		} catch (SQLException se) {
			log.error("err " + se.toString(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Vessel Code롤 Name을 조회한다.<br>
	 *
	 * @param DgListCondVO dgListCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchVesselNameByCd(DgListCondVO dgListCondVO) throws DAOException {

		String retVal = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(dgListCondVO != null) {
				Map<String, String> mapVO = dgListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}


			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SpecialManifestDBDAOsearchVesselNameRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {

				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}

			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


		return retVal;
	}

	/**
	 * Berth Code로 YardName을 조회한다.<br>
	 *
	 * @param DgListCondVO dgListCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchYardNameByCd(DgListCondVO dgListCondVO) throws DAOException {

		String retVal = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(dgListCondVO != null) {
				Map<String, String> mapVO = dgListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}


			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SpecialManifestDBDAOsearchYardNameRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {

				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}

			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


		return retVal;
	}

	/**
	 * Forward Code로 Forward Name을 조회한다.<br>
	 *
	 * @param DgListCondVO dgListCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchForwarderNameByCd(DgListCondVO dgListCondVO) throws DAOException {

		String retVal = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(dgListCondVO != null) {
				Map<String, String> mapVO = dgListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}


			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SpecialManifestDBDAOsearchForwarderNameByCdRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {

				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}

			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


		return retVal;
	}

	/**
	 * UN NO로 NAME을 조회한다.<br>
	 *
	 * @param DgListCondVO dgListCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchUnnoNameByCd(DgListCondVO dgListCondVO) throws DAOException {

		String retVal = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(dgListCondVO != null) {
				Map<String, String> mapVO = dgListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}


			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SpecialManifestDBDAOsearchUnnoNameByCdRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {

				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}

			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


		return retVal;
	}


	/**
	 * 해당 Bl에 속한 컨테이너리스트를 조회한다.(콤보 셋팅을 위해)<br>
	 *
	 * @param dgCargoCondVO
	 * @return List<DgCntrInfoListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DgCntrInfoListVO> searchCntrInfoListByBl(DgCargoCondVO dgCargoCondVO) throws DAOException {
		List<DgCntrInfoListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (dgCargoCondVO != null)
			{
				Map<String, String> mapVO = dgCargoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			list = (List)new SQLExecuter("").executeQuery(
					(ISQLTemplate)new SpecialManifestDBDAOsearchCntrInfoListByBlRSQL(), param, velParam, DgCntrInfoListVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 해당 컨테이너에에 속한 Cgo Seq 리스트를 조회한다.(셋팅을 위해)<br>
	 *
	 * @param dgCargoCondVO
	 * @return List<DgCntrInfoListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DgCntrInfoListVO> searchCgoSeqListByCntr(DgCargoCondVO dgCargoCondVO) throws DAOException {
		List<DgCntrInfoListVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (dgCargoCondVO != null)
			{
				Map<String, String> mapVO = dgCargoCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			list = (List)new SQLExecuter("").executeQuery(
					(ISQLTemplate)new SpecialManifestDBDAOsearchCgoSeqListByCntrRSQL(), param, velParam, DgCntrInfoListVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 위험물 상세 정보들을 업데이트한다.
	 *
	 * @param DgInqModiVO dgInqModiVO
	 * @throws DAOException
	 */
	public void modifyDgInqBySeq(DgInqModiVO dgInqModiVO) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = dgInqModiVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			if ("NYK".equals(dgInqModiVO.getCgoOprCd())) {
				result = new SQLExecuter("").executeUpdate((ISQLTemplate)new SpecialManifestDBDAOmodifyDgInqBySeqUSQL(), param, velParam);
			}else{
				param.put("cntr_no", dgInqModiVO.getCntrNoOld());
				velParam.put("cntr_no", dgInqModiVO.getCntrNoOld());
				result = new SQLExecuter("").executeUpdate((ISQLTemplate)new SpecialManifestDBDAOremoveDgListDSQL(), param, velParam);
				
				param.put("cntr_no", dgInqModiVO.getCntrNo());
				velParam.put("cntr_no", dgInqModiVO.getCntrNo());
				result = new SQLExecuter("").executeUpdate((ISQLTemplate)new SpecialManifestDBDAOaddDgListCSQL(), param, velParam);
				
			}
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert");
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


	}

	/**
	 * Sent결과를 조회해 온다.<br>
	 *
	 * @param sendHistoryCondVO
	 * @return List<SendHistoryDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SendHistoryDetailVO> searchSendHistoryByCntrNo(SendHistoryCondVO sendHistoryCondVO) throws DAOException {
		List<SendHistoryDetailVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (sendHistoryCondVO != null)
			{
				Map<String, String> mapVO = sendHistoryCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			list = (List)new SQLExecuter("").executeQuery(
					(ISQLTemplate)new SpecialManifestDBDAOsearchSendHistoryByCntrNoRSQL(), param, velParam, SendHistoryDetailVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 헤더정보를 조회한다.
	 *
	 * @param  String ofcCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchHeader(String ofcCd) throws DAOException {
		String retVal = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, String> mapVO = new HashMap<String, String>();
		try {
			if(ofcCd != null) {
				mapVO.put("ofcCd", ofcCd);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SpecialManifestDBDAOsearchHeaderRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
			}


		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return retVal;
	}

	/**
	 * Flat File - decl 기본정보를 조회한다. <br>
	 *
	 * @param dgEdiVO
	 * @return DeclBaseInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DeclBaseInfoVO searchDeclBaseInfo(DgEdiVO dgEdiVO) throws DAOException {
		DeclBaseInfoVO declBaseInfoVO = new DeclBaseInfoVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (dgEdiVO != null)
			{
				Map<String, String> mapVO = dgEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SpecialManifestDBDAOsearchDeclBaseInfoRSQL(), param, velParam);

			List<DeclBaseInfoVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,DeclBaseInfoVO.class);

			if (list != null && list.size() > 0) {
				declBaseInfoVO = (DeclBaseInfoVO) list.get(list.size() - 1);
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return declBaseInfoVO;
	}

	/**
	 * Flat File - MAIN PARTIES 정보를 조회한다. <br>
	 *
	 * @param DgEdiVO dgEdiVO
	 * @return List<MainPartiesVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MainPartiesVO> searchMainParties(DgEdiVO dgEdiVO) throws DAOException {
		List<MainPartiesVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (dgEdiVO != null)
			{
				Map<String, String> mapVO = dgEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			list = (List)new SQLExecuter("").executeQuery(
					(ISQLTemplate)new SpecialManifestDBDAOsearchMainPartiesRSQL(), param, velParam, MainPartiesVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Flat File - MAIN MEANS 정보를 조회한다.  <br>
	 *
	 * @param dgEdiVO
	 * @return MainMeansVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public MainMeansVO searchMainMeans(DgEdiVO dgEdiVO) throws DAOException {
		MainMeansVO mainMeansVO = new MainMeansVO();

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (dgEdiVO != null)
			{
				Map<String, String> mapVO = dgEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SpecialManifestDBDAOsearchMainMeansRSQL(), param, velParam);

			List<MainMeansVO> list = (List) RowSetUtil.rowSetToVOs(dbRowset,MainMeansVO.class);

			if (list != null && list.size() > 0) {
				mainMeansVO = (MainMeansVO) list.get(list.size() - 1);
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return mainMeansVO;
	}

	/**
	 * Flat File - 컨테이터 기본정보를 조회한다.   <br>
	 *
	 * @param dgEdiVO
	 * @return MainMeansVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CntrBaseInfoVO> searchCntrBaseInfo(DgEdiVO dgEdiVO) throws DAOException {
		List<CntrBaseInfoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (dgEdiVO != null)
			{
				Map<String, String> mapVO = dgEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SpecialManifestDBDAOsearchCntrBaseInfoRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,CntrBaseInfoVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * Flat File - 컨테이터에 해당하는 아이템 정보 조회 <br>
	 *
	 * @param CntrBaseInfoVO cntrBaseInfoVO
	 * @return List<CntrCgoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CntrCgoVO> searchCntrCgoByCntrBase(CntrBaseInfoVO cntrBaseInfoVO) throws DAOException {
		List<CntrCgoVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (cntrBaseInfoVO != null)
			{
				Map<String, String> mapVO = cntrBaseInfoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SpecialManifestDBDAOsearchCntrCgoByCntrBaseRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset,CntrCgoVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * 기전송유무 확인
	 *
	 * @param  DgEdiVO dgEdiVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchSendStatus(DgEdiVO dgEdiVO) throws DAOException {
		String retVal = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (dgEdiVO != null)
			{
				Map<String, String> mapVO = dgEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SpecialManifestDBDAOsearchSendStatusRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
			}


		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return retVal;
	}

	/**
	 * 송신 log 저장 (송신 마스터 테이블)
	 *
	 * @param  DgSendHistoryVO dgSendHistoryVO
	 * @throws DAOException
	 */
	public void addSendLog(DgSendHistoryVO dgSendHistoryVO) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;

		try {
			if(dgSendHistoryVO != null) {
				Map<String, String> mapVO = dgSendHistoryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new SpecialManifestDBDAOaddSendLogCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 *  * 송신 log 저장 (송신 Detail)<Br>
	 * @param List<DgSendDtlHistoryVO> dgSendDtlHistoryVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addSendDtlLog(List<DgSendDtlHistoryVO> dgSendDtlHistoryVOs) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		DgSendDtlHistoryVO dgSendDtlHistoryVO = null;

		int result = 0;

		try {
			for(int i = 0; i < dgSendDtlHistoryVOs.size(); i++) {

				dgSendDtlHistoryVO = dgSendDtlHistoryVOs.get(i);
				if(dgSendDtlHistoryVO != null) {
					Map<String, String> mapVO = dgSendDtlHistoryVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}

				result = new SQLExecuter("").executeUpdate((ISQLTemplate) new SpecialManifestDBDAOaddSendDtlLogCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED) {
					throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
				}
			} // end for(i)

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 *  bkg_cstms_eur_snd_log 테이블에 FlatFile을 통으로 저장한다.<Br>
	 * @param  List<DgSendHistoryVO> dgSendFlatFileHistoryVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addSendFlatFileLog(List<DgSendHistoryVO> dgSendFlatFileHistoryVOs) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		DgSendHistoryVO dgSendFlatFileHistoryVO = null;

		int result = 0;

		try {
			for(int i = 0; i < dgSendFlatFileHistoryVOs.size(); i++) {

				dgSendFlatFileHistoryVO = dgSendFlatFileHistoryVOs.get(i);
				if(dgSendFlatFileHistoryVO != null) {
					Map<String, String> mapVO = dgSendFlatFileHistoryVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}

				result = new SQLExecuter("").executeUpdate((ISQLTemplate) new SpecialManifestDBDAOaddSendFlatFileLogCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED) {
					throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
				}
			} // end for(i)

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


	}


	/**
	 * BayPlanID 조회
	 *
	 * @param callSignNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchDgBayPlnId(String callSignNo) throws DAOException {
		String retVal = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if (callSignNo != null) {
				Map<String, String> mapVO = new HashMap<String, String>();

				mapVO.put("eur_dg_call_sgn_no", callSignNo);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SpecialManifestDBDAOsearchDgBayPlnIdRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {

				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}

			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return retVal;
	}

	/**
	 * BAPLIE 수신데이타 저장 (수신 마스터 테이블)
	 *
	 * @param  DgBayRcvMsgVO dgBayRcvMsgVO
	 * @throws DAOException
	 */
	public void addDgBayAck(DgBayRcvMsgVO dgBayRcvMsgVO) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;

		try {
			if(dgBayRcvMsgVO != null) {
				Map<String, String> mapVO = dgBayRcvMsgVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new SpecialManifestDBDAOaddDgBayAckCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * BAPLIE 수신데이타 저장 (수신 Detail)<Br>
	 * @param  List<DgBayRcvMsgDtlVO> dgBayRcvMsgDtlVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addDgBayAckDtl(List<DgBayRcvMsgDtlVO> dgBayRcvMsgDtlVOs) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		DgBayRcvMsgDtlVO dgBayRcvMsgDtlVO = null;

		int result = 0;

		try {
			for(int i = 0; i < dgBayRcvMsgDtlVOs.size(); i++) {

				dgBayRcvMsgDtlVO = dgBayRcvMsgDtlVOs.get(i);
				if(dgBayRcvMsgDtlVO != null) {
					Map<String, String> mapVO = dgBayRcvMsgDtlVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}

				result = new SQLExecuter("").executeUpdate((ISQLTemplate)new SpecialManifestDBDAOaddDgBayAckDtlCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED) {
					throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
				}
			} // end for(i)

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


	}

	/**
	 * Flat File - USER_REF 정보를 조회한다. <br>
	 *
	 * @param dgEdiVO
	 * @return List<SendHistoryDetailVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<UserRefVO> searchUserRef(DgEdiVO dgEdiVO) throws DAOException {
		List<UserRefVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (dgEdiVO != null) {
				Map<String, String> mapVO = dgEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			list = (List)new SQLExecuter("").executeQuery(
					(ISQLTemplate)new SpecialManifestDBDAOsearchUserRefRSQL(), param, velParam, UserRefVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * bl_no / pol_cd / pod_cd를 입력시 validation<br>
	 *
	 * @param dgValidationCondVO
	 * @return DgListDetailVO
	 * @throws DAOException
	 */
	public DgListDetailVO searchDgValidationByVvdKey(DgValidationCondVO dgValidationCondVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		DgListDetailVO vo = null;
		try {

			if (dgValidationCondVO != null) {
				Map<String, String> mapVO = dgValidationCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			List list = (List) new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SpecialManifestDBDAOsearchDgValidationByVvdKeyRSQL(), param, velParam, DgListDetailVO.class);
			
			if (list.size() > 0) {
				vo = (DgListDetailVO) list.get(0);
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return vo;
	}

	/**
	 * cntr_no를 입력시 validation<br>
	 *
	 * @param dgValidationCondVO
	 * @return String
	 * @throws DAOException
	 */
	public DgListDetailVO searchDgValidationByCntrKey(DgValidationCondVO dgValidationCondVO) throws DAOException {
		DgListDetailVO vo = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if (dgValidationCondVO != null) {
				Map<String, String> mapVO = dgValidationCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			List list = (List) new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SpecialManifestDBDAOsearchDgValidationByCntrKeyRSQL(), param, velParam, DgListDetailVO.class);

			if(list.size() > 0) {
				vo = (DgListDetailVO)list.get(0);
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return vo;
	}
	
	/**
	 * cntr_no를 입력시 validation<br>
	 *
	 * @param dgValidationCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchDgValidationByPort(DgValidationCondVO dgValidationCondVO) throws DAOException {
		String vo = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if (dgValidationCondVO != null) {
				Map<String, String> mapVO = dgValidationCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			List list = (List) new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SpecialManifestDBDAOsearchDgValidationByPortKeyRSQL(), param, velParam, DgListDetailVO.class);
			if(list.size() > 0) {
				vo = "Y";
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return vo;
	}

	
	/**
	 * 수신정보 키값(MSG_SND_NO) 조회<br>
	 *
	 * @param String msgTpId
	 * @param String keyType
	 * @param String vvdCd
	 * @param String portCd
	 * @param String dType
	 * @return String
	 * @throws DAOException
	 */
	public String searchEdiHistoryKey(String msgTpId, String keyType, String vvdCd, String portCd, String dType) throws DAOException {
		String retVal = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if (msgTpId != null) {
				Map<String, String> mapVO = new HashMap<String, String>();

				mapVO.put("msgTpId", msgTpId);
				mapVO.put("keyType", keyType);
				mapVO.put("vvdCd", vvdCd);
				mapVO.put("portCd", portCd);
				mapVO.put("dType", dType);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SpecialManifestDBDAOsearchEdiHistoryKeyRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {

				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}

			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return retVal;
	}

	/**
	 * 수신정보 키값(RCV_LOG_SEQ) 조회<br>
	 *
	 * @param  String msgTpId
	 * @param  String msgRevNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchRcvLogSeq(String msgTpId, String msgRevNo) throws DAOException {
		String retVal = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if (msgRevNo != null) {
				Map<String, String> mapVO = new HashMap<String, String>();

				mapVO.put("msg_tp_id", msgTpId);
				mapVO.put("key_val", msgRevNo);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SpecialManifestDBDAOsearchRcvLogSeqRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {

				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}

			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return retVal;
	}

	/**
	 * 수신데이타 저장 (수신 마스터 테이블)<Br>
	 *
	 * @param  EurRcvMsgVO eurRcvMsgVO
	 * @throws DAOException
	 */
	public void addAck(EurRcvMsgVO eurRcvMsgVO) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;

		try {
			if(eurRcvMsgVO != null) {
				Map<String, String> mapVO = eurRcvMsgVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new SpecialManifestDBDAOaddAckCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 *  수신데이타 저장 (수신 Detail)<Br>
	 *
	 * @param List<EurRcvMsgDtlVO> eurRcvMsgDtlVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addAckDtl(List<EurRcvMsgDtlVO> eurRcvMsgDtlVOs) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		EurRcvMsgDtlVO eurRcvMsgDtlVO = null;

		int result = 0;

		try {
			for(int i = 0; i < eurRcvMsgDtlVOs.size(); i++) {

				eurRcvMsgDtlVO = eurRcvMsgDtlVOs.get(i);
				if(eurRcvMsgDtlVO != null) {
					Map<String, String> mapVO = eurRcvMsgDtlVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}

				result = new SQLExecuter("").executeUpdate((ISQLTemplate)new SpecialManifestDBDAOaddAckDtlCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED) {
					throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
				}
			} // end for(i)

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


	}

	/**
	 * 위험물 조회조건 Declaration Type, VVD, PORT을 기준으로 먼저 세관쪽 DG테이블에 등록되어 있는지를 판단한다.<br>
	 * Loading(L) -> Loading(L)+Pre-carriage(P) 가 등록되었는지를 판다. 있으면 return "Y" 없으면 return "N"<br>
	 * Loading(L)+Pre-carriage(P) -> Loading(L) 이 등록되었는지를 판다. 있으면 return "Y" 없으면 return "N"<br>
	 * Discharging(D) -> Discharging(D)+On-Carriage(O) 가 등록되었는지를 판다. 있으면 return "Y" 없으면 return "N"<br>
	 * Discharging(D)+On-Carriage(O) -> Discharging(D)이 등록되었는지를 판다.있으면 return "Y" 없으면 return "N"<br>
	 * Transit(T) -> return "N"<br>
	 *
	 * @param DgListCondVO dgListCondVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchDgListCopyYn(DgListCondVO dgListCondVO) throws DAOException {

		String retVal = "N";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(dgListCondVO != null) {
				Map<String, String> mapVO = dgListCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}


			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SpecialManifestDBDAOsearchDgListCopyYnRSQL(), param, velParam);
			
			if(dbRowset.getRowCount() > 0) {
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


		return retVal;
	}

	/**
	 * Feeder Name, Lloyd No를 조회한다.<br>
	 *
	 * @return List<FeederNameVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<FeederNameVO> searchDgFeederNameList() throws DAOException {

		List<FeederNameVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialManifestDBDAOsearchDgFeederNameListRSQL(), param, velParam, FeederNameVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}
	
	/**
	 * 중복 컨테이너와 셀 포지션을 조회한다.<br>
	 * 
	 * @param DgListModiVO dgListModiVO 
	 * @param String div
	 * @param String cntr
	 * @return String
	 * @throws DAOException
	 * 
	 */
	public String searchDuplicatedCntr(DgListModiVO dgListModiVO, String div, String cntr) throws DAOException {

		String retVal = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(dgListModiVO != null) {
				Map<String, String> mapVO = dgListModiVO.getColumnValues();
				param.putAll(mapVO);
				param.put("div", div);
				velParam.putAll(mapVO);
				velParam.put("div", div);
				param.put("cntr", cntr);
				velParam.put("cntr", cntr);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SpecialManifestDBDAOsearchDuplicatedCntrRSQL(), param, velParam);
			if(dbRowset.getRowCount() > 0) {
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return retVal;
	}

	/**
	 * 중복 컨테이너 조회용 컨테이너 넘버를 조회한다.<br>
	 * 
	 * @param DgListModiVO dgListModiVO 
	 * @return String
	 * @throws DAOException
	 * 
	 */
	public String searchDuplicatedCntrNo(DgListModiVO dgListModiVO) throws DAOException {

		String retVal = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			if(dgListModiVO != null) {
				Map<String, String> mapVO = dgListModiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SpecialManifestDBDAOsearchDuplicatedCntrNoRSQL(), param, velParam);
			if(dbRowset.getRowCount() > 0) {
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return retVal;
	}
	
	/**
	 * Feeder 정보를 조회한다.(lloyd코드와  vsl name으로 like검색)<br>
	 *
	 * @param FeederInfoVO feederInfoVO
	 * @return List<FeederInfoVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<FeederInfoVO> searchFeederInfoList(FeederInfoVO feederInfoVO) throws DAOException {

		List<FeederInfoVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(feederInfoVO != null) {
				Map<String, String> mapVO = feederInfoVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialManifestDBDAOsearchFeederInfoListRSQL(), param, velParam, FeederInfoVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}

	/**
	 * feeder정보를 입력한다.<br>
	 *
	 * @param List<FeederInfoVO> insModels
	 * @throws DAOException
	 */
	public void addFeederInfoList(List<FeederInfoVO> insModels) throws DAOException {
		try {
			int insCnt = 0;
			FeederInfoVO feederInfoVO = null;

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();


			for(int i = 0; i < insModels.size(); i++) {

				feederInfoVO = insModels.get(i);
				if(feederInfoVO != null) {
					Map<String, String> mapVO = feederInfoVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}

				insCnt = new SQLExecuter("").executeUpdate((ISQLTemplate) new SpecialManifestDBDAOaddFeederInfoListCSQL(), param, velParam);
				if(insCnt == Statement.EXECUTE_FAILED) {
					throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
				}
			} // end for(i)

			/*
			insCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialManifestDBDAOaddFeederInfoListCSQL(), insModels, null);
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED)
					//throw new DAOException("Fail to insert No"+ i + " SQL");
					//throw new DAOException(new ErrorHandler("BKG00102",new String[]{}).getUserMessage());
					throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getUserMessage());

			}
			*/

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * feeder정보를 수정한다.
	 *
	 * @param List<FeederInfoVO> updateModels
	 * @throws DAOException
	 */
	public void updateFeederInfoList(List<FeederInfoVO> updateModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updateCnt[] = null;
			if(updateModels.size() > 0){
				updateCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialManifestDBDAOupdateFeederInfoListUSQL(), updateModels,null);
				for(int i = 0; i < updateCnt.length; i++){
					if(updateCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}


	/**
	 * feeder정보를 삭제한다.
	 *
	 * @param List<FeederInfoVO> delModels
	 * @throws DAOException
	 */
	public void removeFeederInfoList(List<FeederInfoVO> delModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialManifestDBDAOremoveFeederInfoListDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * 위험물 정보중 파트너 부킹정보를 마감한다..<br>
	 *
	 * @param DgListCondVO dgListCondVO
	 * @throws DAOException
	 */
	public void modifyCloseScg(DgListCondVO dgListCondVO) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = dgListCondVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new SpecialManifestDBDAOmodifyCloseScgUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException(new ErrorHandler("BKG00102",new String[]{}).getMessage());
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}


	}
	
	/**
	 * Eur Dg Port 정보를 조회한다.<br>
	 *
	 * @param EurDgListVO EurDgListVO
	 * @return List<EurDgListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EurDgListVO> searchEurDgPortList(EurDgListVO eurDgListVO) throws DAOException {
		List<EurDgListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eurDgListVO != null) {
				Map<String, String> mapVO = eurDgListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialManifestDBDAOSearchEurDgPortListRSQL(), param, velParam, EurDgListVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Eur Dg Port 정보를 수정한다.<br>
	 *
	 * @param List<EurDgListVO> updateVoList
	 * @throws DAOException
	 */
	public void updateEurDgPortList(List<EurDgListVO> updateVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int nCnt[] = null;
			if(updateVoList.size() > 0){
				nCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialManifestDBDAOUpdateEurDgPortListUSQL(), updateVoList,null);
				for(int i = 0; i < nCnt.length; i++){
					if(nCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to manage Eur Dg Port No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Eur Dg Port 정보를 삭제한다.<br>
	 *
	 * @param List<EurDgListVO> deleteVoList
	 * @throws DAOException
	 */
	public void removeEurDgPortList(List<EurDgListVO> deleteVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int nCnt[] = null;
			if(deleteVoList.size() > 0){
				nCnt = sqlExe.executeBatch((ISQLTemplate)new SpecialManifestDBDAODeleteEurDgPortListDSQL(), deleteVoList,null);
				for(int i = 0; i < nCnt.length; i++){
					if(nCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete Eur Dg Port No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Eur Dg Port 정보를 메일로 보낸다.<br>
	 *
	 * @param EurDgListVO eurDgListVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public void sendEurDgEmail(EurDgListVO eurDgListVO, SignOnUserAccount account) throws DAOException {	
		List<ComRptDsgnXptInfoVO> vos = null;
		ComRptDsgnXptInfoVO vo = null;
		TemplateMail template = null;		
		ComUserVO comUserVO = null;
		try {
			// 수정 account.getUsr_Eml() -> getDfltEml()
			BookingUtil util = new BookingUtil();
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null != comUserVO) {
				sUsrEml = (null == comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}

			vo = new ComRptDsgnXptInfoVO();
			
			vo.setRdParaCtnt(eurDgListVO.getMrdArguments());
			
			if("L".equals(eurDgListVO.getListType()) || "D".equals(eurDgListVO.getListType()) || "T".equals(eurDgListVO.getListType()) || "B".equals(eurDgListVO.getListType())){
				vo.setRdTmpltNm(eurDgListVO.getMrdPath()); //ESM_BKG_1604.mrd
				vo.setXptFileTpCd(ExportInfo.FTYPE_PDF);
				vo.setXptFileNm(ConstantMgr.getScacCode() + eurDgListVO.getMrdFileName() + ".pdf");
				
			} else if("BE".equals(eurDgListVO.getListType())){
				vo.setRdTmpltNm("ESM_BKG_1604_01.mrd"); 
				vo.setXptFileTpCd(ExportInfo.FTYPE_XLS); 				
				vo.setXptFileNm(ConstantMgr.getScacCode() + eurDgListVO.getMrdFileName() + ".xls");
			} else if("SE".equals(eurDgListVO.getListType())){
				vo.setRdTmpltNm("ESM_BKG_1604_02.mrd"); 
				vo.setXptFileTpCd(ExportInfo.FTYPE_XLS); 				
				vo.setXptFileNm(ConstantMgr.getScacCode() + eurDgListVO.getMrdFileName() + ".xls");
			}
			List<EurDgListVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			Map<String, String> mapVO = eurDgListVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialManifestDBDAOSearchEurDgEmailSendRSQL(), param, velParam, EurDgListVO.class);
			
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			vos = new ArrayList<ComRptDsgnXptInfoVO>();
			vos.add(vo);
			template = new TemplateMail();
			template.setBatFlg("N");
			template.setComRptDsgnXptInfoVOs(vos);
			// template.setFrom(account.getUsr_eml(),account.getUsr_nm());
			template.setFrom(sUsrEml, account.getUsr_nm());
			template.setRecipient(eurDgListVO.getEmail());	
			
			if(list.size()>0){
				EurDgListVO eurDgVO = list.get(0);
				if(eurDgListVO.getPolCd()=="" && eurDgListVO.getPodCd()==""){
					template.setSubject("DANGEROUS CARGO MANIFEST : " + eurDgListVO.getListNm() + " " +eurDgVO.getVslNm() + " " +eurDgListVO.getVvdCd().substring(4,9));
				}
				if(eurDgListVO.getPolCd()!="" && eurDgListVO.getPodCd()==""){
					template.setSubject("DANGEROUS CARGO MANIFEST : " + eurDgListVO.getListNm() + " "+ eurDgListVO.getPolCd() +" " +eurDgVO.getVslNm()+ " " + eurDgVO.getObCssmVoyNo());
				}
				if(eurDgListVO.getPolCd()=="" && eurDgListVO.getPodCd()!=""){
					template.setSubject("DANGEROUS CARGO MANIFEST : " + eurDgListVO.getListNm() + " " +eurDgVO.getVslNm()+ " " + eurDgListVO.getVvdCd().substring(4,9));
				}
				if(eurDgListVO.getPolCd()!="" && eurDgListVO.getPodCd()!=""){
					template.setSubject("DANGEROUS CARGO MANIFEST : " + eurDgListVO.getListNm() + " "+ eurDgListVO.getPolCd() +" "  +eurDgVO.getVslNm()+  " " +eurDgVO.getObCssmVoyNo());
				}
		    }
			template.setHtmlTemplate("ESM_BKG_1604_01T.html");
			template.setArg("VVD", eurDgListVO.getMrdFileName());			
			template.send();
			
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	    return ;
	}
	
	/**
	 * Eur Dg Port Excel List 조회한다.<br>
	 *
	 * @param EurDgListVO EurDgListVO
	 * @return List<EurDgListVO>
	 * @throws DAOException 
	 */
	@SuppressWarnings("unchecked")
	public List<EurDgListVO> searchEurDgExcelList(EurDgListVO eurDgListVO) throws DAOException {
		List<EurDgListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eurDgListVO != null) {
				Map<String, String> mapVO = eurDgListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialManifestDBDAOSearchEurDgExcelListRSQL(), param, velParam, EurDgListVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Eur Dg Port Summary Excel List 조회한다.<br>
	 *
	 * @param EurDgSummaryListVO eurDgSummaryListVO
	 * @return List<EurDgSummaryListVO>
	 * @throws DAOException 
	 */
	@SuppressWarnings("unchecked")
	public List<EurDgSummaryListVO> searchEurSummaryDgExcelList(EurDgSummaryListVO eurDgSummaryListVO) throws DAOException {
		List<EurDgSummaryListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(eurDgSummaryListVO != null) {
				Map<String, String> mapVO = eurDgSummaryListVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			list = (List)new SQLExecuter("").executeQuery((ISQLTemplate)new SpecialManifestDBDAOSearchEurDgSummaryExcelListRSQL(), param, velParam, EurDgSummaryListVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Create history data at saving in list screen
	 *
	 * @param List<DgListModiVO> insModels
	 * @throws DAOException
	 */
	public void addDgListHis(List<DgListModiVO> insModels) throws DAOException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String updDt = sdf.format(new Date());

		try {
			int result = 0;

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			//Map<String, Object> velParam = new HashMap<String, Object>();

			DgListModiVO dgListModiVO = null;

			if(insModels.size() > 0) {

				for(int i = 0 ; i < insModels.size(); i++) {

					dgListModiVO = insModels.get(i);
					Map<String, String> mapVO = dgListModiVO.getColumnValues();

					param.putAll(mapVO);
					//velParam.putAll(mapVO);
					
					param.put("upd_dt", updDt);

					result = new SQLExecuter("").executeUpdate((ISQLTemplate)new SpecialManifestDBDAOaddDgListHisCSQL(), param, null);
					if(result == Statement.EXECUTE_FAILED) {
						throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
					}
				}

			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Create history data at saving in list screen
	 *
	 * @param DgInqModiVO dgInqModiVO
	 * @throws DAOException
	 */
	public void addDgInquiryHis(DgInqModiVO dgInqModiVO) throws DAOException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String updDt = sdf.format(new Date());

		try {
			int result = 0;

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			//Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO = dgInqModiVO.getColumnValues();
			param.putAll(mapVO);
			
			param.put("upd_dt", updDt);

			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new SpecialManifestDBDAOaddDgListHisCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException(new ErrorHandler("BKG06087",new String[]{}).getMessage());
			}
				
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * Return the data of BKG_CSTMS_EUR_DG_HIS <br>
	 *
	 * @param EurDgHisVO eurDgHisVO
	 * @return List<EurDgHisVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<EurDgHisVO> searchEurDgHis(EurDgHisVO eurDgHisVO) throws DAOException {
		List<EurDgHisVO> list = null;

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try
		{
			if (eurDgHisVO != null)
			{
				Map<String, String> mapVO = eurDgHisVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			list = (List)new SQLExecuter("").executeQuery(
					(ISQLTemplate)new SpecialManifestDBDAOSearchEurDgHisRSQL(), param, velParam, EurDgHisVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return list;
	}
	

	/**
	 * CELL POSITION NO 수정 후 이후 PORT의 CELL POSITION NO를 수정한다.
	 *
	 * @param List<DgListModiVO> updModels
	 * @throws DAOException
	 */
	public void modifyCellPsnNo(List<DgListModiVO> updModels) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (updModels.size() > 0)
			{
				updCnt = sqlExe.executeBatch((ISQLTemplate) new SpecialManifestDBDAOmodifyCellPsnNoUSQL(), updModels, null);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}


	/**
	 * Msg Snd Type을 조회한다. <br>
	 *
	 * @param dgEdiVO
	 * @return String retVal
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchTransType(DgEdiVO dgEdiVO) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		String retVal = "";
		try
		{
			if (dgEdiVO != null)
			{
				Map<String, String> mapVO = dgEdiVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new SpecialManifestDBDAOsearchTransTypeRSQL(), param, velParam);

			if(dbRowset.getRowCount() > 0) {
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return retVal;
	}
}
