/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BookingMasterMgtDBDAO.java
 *@FileTitle : Booking Creation 1_MT P/UP CY inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.12.20
 *@LastModifier : 최 선
 *@LastVersion : 1.2
 * 2009.05.04 김기종
 * 1.0 Creation
 *----------------------------------------------------------
 * History
 * 2010.12.17 김영철    1.1 [] R4J 메소드 주석 기술 수정 ( Line 3325 )
 * 2010.12.20 최 선     1.2 [CHM-201007417] Mandatory Item(s) Setup for Customized Service Incoterms Column Add
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgChinaAgentVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCtrlBlGrpCustVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCtrlBlGrpVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCtrlPtyBlGrpVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCtrlPtyVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCustTmpltVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEdiGrpCustVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEdiGrpVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEdiPrnrPortLaneVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEdiSubLnkMsgVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEdiTrdPrnrSubLnkVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEqlzPortVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgHandlingOfficeSetupVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgHrdCdgDescVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgInetBlCtrlPtyVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgMdtItmVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgSalesRepVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgdocClzSetListVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgdocClzSetVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ChnMnlBkgNoGenCondVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.CustSlsRepVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.HrdCdgCtnt2VO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.MandatoryItemSetupListVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRPolVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRTimeTableVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRTimeVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchCmdtCdRepCmdtCdVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchInBoundCustListVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchWareHouseVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.VskVslPortSkdConditionVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ZipCdListVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ZipCdSchVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.HrdCdgDesc2VO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgChnBkgNoGenVO;
import com.clt.syscommon.common.table.BkgCoffTmVO;
import com.clt.syscommon.common.table.BkgCustCntcPsonVO;
import com.clt.syscommon.common.table.BkgDpcsUsrGrpVO;
import com.clt.syscommon.common.table.BkgHamoTrfVO;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;
import com.clt.syscommon.common.table.BkgMTPickupCYVO;
import com.clt.syscommon.common.table.MdmCountryVO;
import com.clt.syscommon.common.table.MdmPckTpVO;


/**
 * BookingMasterMgtDBDAO <br>
 * - BookingMasterData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Ki Jong
 * @see BookingMasterMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class BookingMasterMgtDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 5901438409121373556L;

	/**
	 * MT Pick Up CY Inquiry 정보를 조회(ESM_BKG_0082) <br>
	 * MT Pick Up CY 조회 화면(booking creation(UI_BKG-0079) pop up 화면)
	 * 
	 * @param String YardCode
	 * @param String Today
	 * @return List<BkgMTPickupCYVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgMTPickupCYVO> searchMTPickUpCY(String YardCode, String Today) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgMTPickupCYVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap();
			mapVO.put("yd_cd", YardCode);
			// mapVO.put("today", Today);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter executer = new SQLExecuter("DEFAULT");
			BookingMasterMgtDBDAOBkgMTPickupCYVORSQL template = new BookingMasterMgtDBDAOBkgMTPickupCYVORSQL();

			dbRowset = executer.executeQuery(template, param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgMTPickupCYVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;

	}

	/**
	 * 미주 신고를 위한 화물의 Code(Commodity code와 유사) 조회 (ESM_BKG_0604) <br>
	 * 
	 * @param BkgHamoTrfVO hamTarCodeVO
	 * @return List<BkgHamoTrfVO>
	 * @exception DAOException
	 */

	@SuppressWarnings("unchecked")
	public List<BkgHamoTrfVO> searchHTSCode(BkgHamoTrfVO hamTarCodeVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgHamoTrfVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = hamTarCodeVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOBkgHamoTrfVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgHamoTrfVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	
	/**
	 * 미주 신고를 위한 화물의 Code(Commodity code와 유사) 조회 (ESM_BKG_0604) <br>
	 * 
	 * @param String hsCd
	 * @param String hsAplyDt
	 * @param String hamoTpCd
	 * @return String hsCdRslt
	 * @exception DAOException
	 */

	@SuppressWarnings("unchecked")
	public String validateHsCd(String hsCd, String hsAplyDt, String hamoTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		String hsCdRslt = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("hamo_tp_cd", hamoTpCd);
			param.put("hs_cd", hsCd);	
			param.put("hs_aply_dt", hsAplyDt);	
			velParam.put("hamo_tp_cd", hamoTpCd);
			velParam.put("hs_cd", hsCd);	
			velParam.put("hs_aply_dt", hsAplyDt);	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOvalidateHsCdWithHsAplyDtRSQL(), param, velParam);
			if (dbRowset.next()) {
				hsCdRslt = dbRowset.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return hsCdRslt;
	}

	/**
	 * Customer Person 데이터를 일괄적으로 생성한다.(ESM_BKG_0652)<br>
	 * 
	 * @param BkgCustCntcPsonVO bkgCustCntcPsonVO
	 * @exception DAOException
	 */

	public void addCustContact(BkgCustCntcPsonVO bkgCustCntcPsonVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (bkgCustCntcPsonVO != null) {
				Map<String, String> mapVO = bkgCustCntcPsonVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOBkgCustCntcPsonVOCSQL(), param, velParam);

			if (insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Customer Person 데이터를 일괄적으로 갱신한다.(ESM_BKG_0652)<br>
	 * 
	 * @param BkgCustCntcPsonVO bkgCustCntcPsonVO
	 * @throws DAOException
	 */
	public void modifyCustContact(BkgCustCntcPsonVO bkgCustCntcPsonVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (bkgCustCntcPsonVO != null) {
				Map<String, String> mapVO = bkgCustCntcPsonVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOBkgCustCntcPsonVOUSQL(), param, velParam);

			if (updCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * 다건의 Customer Person 데이터를 일괄적으로 삭제한다.(ESM_BKG_0652)<br>
	 * 
	 * @param BkgCustCntcPsonVO bkgCustCntcPsonVO
	 * @throws DAOException
	 */
	public void removeCustContact(BkgCustCntcPsonVO bkgCustCntcPsonVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (bkgCustCntcPsonVO != null) {
				Map<String, String> mapVO = bkgCustCntcPsonVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOBkgCustCntcPsonVODSQL(), param, velParam);

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Vessel code 및 SKD 조회 <br>
	 * 
	 * @param VskVslPortSkdConditionVO vo
	 * @return List<VskVslPortSkdConditionVO>
	 * @throws DAOException
	 */

	@SuppressWarnings("unchecked")
	public List<VskVslPortSkdConditionVO> searchEtbEtdEta(VskVslPortSkdConditionVO vo) throws DAOException {
		//BookingUtil 항목인데 왜 여기 있지..
		DBRowSet dbRowset = null;
		List<VskVslPortSkdConditionVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if(!JSPUtil.getNull(vo.getSlanCd()).equals("")){
				vo.setSlanCd("'" + vo.getSlanCd().replaceAll("," ,"','") +"'");
			}
			
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOVskVslPortSkdConditionRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VskVslPortSkdConditionVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Package Code 및 Description을 검색 및 조회(ESM_BKG_0755,ESM_BKG_0696) <br>
	 * 
	 * @param MdmPckTpVO vo
	 * @return List<MdmPckTpVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmPckTpVO> searchPackageCode(MdmPckTpVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmPckTpVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOMdmPckTpVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmPckTpVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Commodity Code를 입력하기 위해 Code를 검색 (ESM_BKG_0653)<br>
	 * 
	 * @param SearchCmdtCdRepCmdtCdVO vo
	 * @return List<SearchCmdtCdRepCmdtCdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCmdtCdRepCmdtCdVO> searchCmdtCdRepCmdtCd(SearchCmdtCdRepCmdtCdVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCmdtCdRepCmdtCdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOSearchCmdtCdRepCmdtCdVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCmdtCdRepCmdtCdVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Warehouse (Bonded Area) Creation 조회 (ESM_BKG_0554)<br>
	 * 
	 * @param String cuntryCd
	 * @param String wareHouse
	 * @return List<SearchWareHouseVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchWareHouseVO> searchWareHouse(String cuntryCd, String wareHouse) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchWareHouseVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap();
			mapVO.put("cnt_cd", cuntryCd);
			mapVO.put("wh_cd", wareHouse);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOSearchWareHouseVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchWareHouseVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Warehouse (Bonded Area) Creation (ESM_BKG_0554)<br>
	 * 
	 * @param SearchWareHouseVO bkgWarehouseVO
	 * @return int
	 * @throws DAOException
	 */
	public int addWareHouse(SearchWareHouseVO bkgWarehouseVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if (bkgWarehouseVO != null) {
				Map<String, String> mapVO = bkgWarehouseVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOSearchWareHouseVOCSQL(), param, velParam);

			if (result == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}

	/**
	 * Warehouse (Bonded Area) Creation (ESM_BKG_0554) <br>
	 * 
	 * @param SearchWareHouseVO searchWareHouseVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyWareHouse(SearchWareHouseVO searchWareHouseVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (searchWareHouseVO != null) {
				Map<String, String> mapVO = searchWareHouseVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOSearchWareHouseVOUSQL(), param, velParam);

			if (result == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}

	/**
	 * Customer Person 데이터를 삭제한다. (ESM_BKG_0554)<br>
	 * Warehouse (Bonded Area) Creation </br>
	 * 
	 * @param SearchWareHouseVO searchWareHouseVO
	 * @throws DAOException
	 */
	public void removeWareHouse(SearchWareHouseVO searchWareHouseVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (searchWareHouseVO != null) {
				Map<String, String> mapVO = searchWareHouseVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOSearchWareHouseVODSQL(), param, velParam);

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Manual로 BDR을 처리건 조회 (ESM_BKG_0596)<br>
	 * BDR의 기준이 되는 BDR Time을 등록하는 화면에서..<br>
	 * Lane/Bound/From Location/To Location 기준으로 등록된 BDR Time을 조회한다.<br>
	 * 
	 * @param SearchBDRTimeVO vo 
	 * @return List<SearchBDRTimeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchBDRTimeVO> searchBDRTime(SearchBDRTimeVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchBDRTimeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOSearchBDRTimeVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchBDRTimeVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * vvd check (ESM_BKG_0596)<br>
	 * 
	 * @param SearchBDRTimeVO vo
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkBDRVVDPOL(SearchBDRTimeVO vo) throws DAOException {
		boolean rtnChk = false;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOCheckBDRVVDPOLRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0) {
				rtnChk = true;
			} else {
				rtnChk = false;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnChk;
	}

	/**
	 * BKG_VVD_BDR_LOG 데이터를 일괄적으로 갱신한다. (ESM_BKG_0596)<br>
	 * Vessesl Schedule B/L Data Release Log를 관리한다.<br>
	 * 
	 * @param SearchBDRTimeVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int modifyBDRLog(SearchBDRTimeVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOModifyBDRLogUSQL(), param, velParam);

			if (result == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}

	/**
	 * BDR Time Table 데이타 조회. (ESM_BKG_0073)<br>
	 * TABLE - BKG_BDR_TM<br>
	 * 
	 * @param SearchBDRPolVO vo
	 * @return List<SearchBDRPolVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchBDRPolVO> searchBDRPol(SearchBDRPolVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchBDRPolVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				log.debug("mapVO:" + mapVO);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOSearchBDRPolVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchBDRPolVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * BDR Time Table 조회.(ESM_BKG_0073)<br>
	 * TABLE - BKG_VVD_BDR_LOG<br>
	 * 
	 * @param SearchBDRTimeTableVO vo
	 * @return List<SearchBDRTimeTableVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchBDRTimeTableVO> searchLaneBDRTime(SearchBDRTimeTableVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchBDRTimeTableVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				log.debug("mapVO:" + mapVO);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOSearchLaneBDRTimeVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchBDRTimeTableVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * BDR Time Table조회 (ESM_BKG_0073)<br>
	 * TABLE - BKG_VVD_BDR_LOG<br>
	 * 
	 * @param SearchBDRTimeTableVO vo
	 * @return List<SearchBDRTimeTableVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchBDRTimeTableVO> searchVVDBDRTime(SearchBDRTimeTableVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchBDRTimeTableVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				log.debug("mapVO:" + mapVO);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOSearchVvdBDRTimeVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchBDRTimeTableVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * BDR Time Table 데이터를 추가 생성한다. (ESM_BKG_0073)<br>
	 * 
	 * @param SearchBDRPolVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int addBDRTime(SearchBDRPolVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOSearchBDRPolVOCSQL(), param, velParam);

			if (result == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}

	/**
	 * BDR Time Table 데이터를 갱신한다. (ESM_BKG_0073)<br>
	 * 
	 * @param SearchBDRPolVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int modifyBDRTime(SearchBDRPolVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOSearchBDRPolVOUSQL(), param, velParam);

			if (result == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}

	/**
	 * 다건의 BDR Time Table 데이터를 일괄적으로 삭제한다. (ESM_BKG_0073)<br>
	 * 
	 * @param SearchBDRPolVO vo
	 * @throws DAOException
	 */
	public void removeBDRTime(SearchBDRPolVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOSearchBDRPolVODSQL(), param, velParam);

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * BDR Time Table 데이터를 갱신한다. (ESM_BKG_0073)<br>
	 * 
	 * @param SearchBDRTimeTableVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int modifyVVDBDRLog(SearchBDRTimeTableVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOSearchBDRTimeTableVOUSQL(), param, velParam);

			if (result == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}

	/**
	 * Bkg_Coff_Tm테이블 저장<br>
	 * 
	 * @param BkgCoffTmVO bkgCoffTmVO
	 * @exception DAOException
	 */
	public void addBkgCoffTm(BkgCoffTmVO bkgCoffTmVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (bkgCoffTmVO != null) {
				Map<String, String> mapVO = bkgCoffTmVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOaddBkgCoffTmCSQL(), param, velParam);

			if (insCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Bkg_Coff_Tm테이블 수정<br>
	 * 
	 * @param BkgCoffTmVO bkgCoffTmVO
	 * @exception DAOException
	 */
	public void modifyBkgCoffTm(BkgCoffTmVO bkgCoffTmVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (bkgCoffTmVO != null) {
				Map<String, String> mapVO = bkgCoffTmVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOmodifyBkgCoffTmUSQL(), param, velParam);

			if (updCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Equalization Port 등록 화면-조회 (ESM_BKG_0253)<br>
	 * 
	 * @param BkgEqlzPortVO vo
	 * @return List<BkgEqlzPortVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgEqlzPortVO> searchEqualizetionPortCD(BkgEqlzPortVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgEqlzPortVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOBkgEqlzPortVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgEqlzPortVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Equalization Port 등록 화면-추가저장<br>
	 * 화면 -UI_BKG-0253
	 * 
	 * @param BkgEqlzPortVO vo
	 * @return int 
	 * @throws DAOException
	 */
	public int addEqualizationPort(BkgEqlzPortVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOBkgEqlzPortVOCSQL(), param, velParam);

			if (result == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}

	/**
	 * Equalization Port 등록 화면-수정<br>
	 * 화면 -UI_BKG-0253
	 * 
	 * @param BkgEqlzPortVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int modifyEqualizationPort(BkgEqlzPortVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOBkgEqlzPortVOUSQL(), param, velParam);

			if (result == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}

	/**
	 * Equalization Port 등록 화면- 삭제<br>
	 * 화면 -UI_BKG-0253
	 * 
	 * @param BkgEqlzPortVO vo
	 * @throws DAOException
	 */
	public void removeEqualizationPort(BkgEqlzPortVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOBkgEqlzPortVODSQL(), param, velParam);

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * 중국 Booking Agent 정보 등록 화면-조회<br>
	 * 화면 -UI_BKG-0153
	 * 
	 * @param BkgChinaAgentVO vo
	 * @return List<BkgChinaAgentVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgChinaAgentVO> searchChinaAgentCodeList(BkgChinaAgentVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgChinaAgentVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDAOSearchChinaAgentCodeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgChinaAgentVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * 중국 Booking Agent 정보 등록 화면-추가저장<br>
	 * 화면 -UI_BKG-0253
	 * 
	 * @param BkgChinaAgentVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int addChinaAgentCode(BkgChinaAgentVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDAOSearchChinaAgentCodeCSQL(), param, velParam);
 
			if (result == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se); 
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}

	/**
	 * 중국 Booking Agent 정보 등록 화면-수정<br>
	 * 화면 -UI_BKG-0153
	 * 
	 * @param BkgChinaAgentVO vo
	 * @return int 
	 * @throws DAOException
	 */
	public int modifyChinaAgentCode(BkgChinaAgentVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDAOSearchChinaAgentCodeUSQL(), param, velParam);

			if (result == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}

	/**
	 * 중국 Booking Agent 정보 등록 화면- 삭제<br>
	 * 화면 -UI_BKG-0253
	 * 
	 * @param BkgChinaAgentVO vo
	 * @throws DAOException
	 */
	public void removeChinaAgentCode(BkgChinaAgentVO vo) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDAOSearchChinaAgentCodeDSQL(), param, velParam);

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * 0192 B/L Customer Information in CRM 조회
	 * 
	 * @param SearchInBoundCustListVO searchInBoundCustListVO
	 * @return List<SearchInBoundCustListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchInBoundCustListVO> searchInBoundCustList(SearchInBoundCustListVO searchInBoundCustListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchInBoundCustListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = searchInBoundCustListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOSearchInBoundCustListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchInBoundCustListVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * 0192 B/L Customer Information in CRM Template 조회
	 * 
	 * @param BkgCustTmpltVO bkgCustTmpltVO
	 * @return List<BkgCustTmpltVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgCustTmpltVO> searchInBoundCustTmpltList(BkgCustTmpltVO bkgCustTmpltVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCustTmpltVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = bkgCustTmpltVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOSearchInBoundCustTmpltListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCustTmpltVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * 0192 B/L Customer Information in CRM Template 생성 <br>
	 * 
	 * @param List<BkgCustTmpltVO> bkgCustTmpltVO
	 * @throws DAOException
	 */
	public void addInBoundCustList(List<BkgCustTmpltVO> bkgCustTmpltVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (bkgCustTmpltVO.size() > 0) {

					// query parameter
					Map<String, Object> param = new HashMap<String, Object>();
					// velocity parameter
					Map<String, Object> velParam = new HashMap<String, Object>();

					int result = 0;
					for (int i = 0; i < bkgCustTmpltVO.size(); i++) {
						if (bkgCustTmpltVO.get(i) != null) {
							Map<String, String> mapVO = bkgCustTmpltVO.get(i).getColumnValues();

							param.putAll(mapVO);
							velParam.putAll(mapVO);
						}
						result = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOAddInBoundCustListCSQL(), param, velParam);

						if (result == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

						param.clear();
						velParam.clear();
					}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}

	/**
	 * 0192 B/L Customer Information in CRM Template 수정
	 * 
	 * @param BkgCustTmpltVO 데이터객체 배열
	 * @throws DAOException
	 */
	public void modifyInBoundCustList(List<BkgCustTmpltVO> bkgCustTmpltVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCustTmpltVO.size() > 0) {
					updCnt = sqlExe.executeBatch((ISQLTemplate) new BookingMasterMgtDBDAOModifyInBoundCustListUSQL(), bkgCustTmpltVO, null);
					
				for (int i = 0; updCnt != null && i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * 0192 B/L Customer Information in CRM Template 수정 <br>
	 * 
	 * @param List<BkgCustTmpltVO> bkgCustTmpltVO
	 * @throws DAOException
	 */
	public void removeInBoundCustList(List<BkgCustTmpltVO> bkgCustTmpltVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgCustTmpltVO.size() > 0) {
					updCnt = sqlExe.executeBatch((ISQLTemplate) new BookingMasterMgtDBDAORemoveInBoundCustListDSQL(), bkgCustTmpltVO, null);

				for (int i = 0; updCnt != null && i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}


	/**
	 * VVD에 해당하는 vsl_slan_cd, skd_sts_cd 값 조회 <br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return List<BkgVvdBdrLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgVvdBdrLogVO> searchVVDStatus(String vslCd, String skdVoyNo, String skdDirCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgVvdBdrLogVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap();
			mapVO.put("vsl_cd", vslCd);
			mapVO.put("skd_voy_no", skdVoyNo);
			mapVO.put("skd_dir_cd", skdDirCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOSearchVVDStatusRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgVvdBdrLogVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * VVD LANE CODE 에 해당하는 SERVICE LANE TYPE CODE(slan_tp_cd) 값 조회 <br>
	 * 
	 * @param String slanCd
	 * @return String slanTpCd
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchSvcTpCd(String slanCd) throws DAOException {
		DBRowSet dbRowset = null;
		String slanTpCd = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap();
			mapVO.put("vsl_cd", slanCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOsearchSvcTpCdRSQL(), param, velParam);

			if (dbRowset.first()) {

				slanTpCd = dbRowset.getString(1);
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return slanTpCd;
	}

	/**
	 * VVD에 해당하는 VSK_VSL_PORT_SKD TABLE 조회 <br>
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @return List<BkgVvdBdrLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgVvdBdrLogVO> searchVslPortSkd(String vslCd, String skdVoyNo, String skdDirCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgVvdBdrLogVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap();
			mapVO.put("vsl_cd", vslCd);
			mapVO.put("skd_voy_no", skdVoyNo);
			mapVO.put("skd_dir_cd", skdDirCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOsearchVslPortSkdRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgVvdBdrLogVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * BDR TIME 정보 조회 <br>
	 * 
	 * @param String vpsEtdDt
	 * @param String slanCd
	 * @param String skdDirCd
	 * @param String polCd
	 * @param String podCd
	 * @return List<BkgVvdBdrLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgVvdBdrLogVO> searchBdrTime(String vpsEtdDt, String slanCd, String skdDirCd, String polCd, String podCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgVvdBdrLogVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap();
			mapVO.put("vps_etd_dt", vpsEtdDt);
			mapVO.put("slan_cd", slanCd);
			mapVO.put("skd_dir_cd", skdDirCd);
			mapVO.put("pol_cd", polCd);
			mapVO.put("pod_cd", podCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOsearchBdrTimeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgVvdBdrLogVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * BDR TIME 이 없는 경우 >>> Feeder(P) 정보 조회 <br>
	 * 
	 * @param String vpsEtdDt
	 * @return BkgVvdBdrLogVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgVvdBdrLogVO searchBdrTimeP(String vpsEtdDt) throws DAOException {
		DBRowSet dbRowset = null;
		BkgVvdBdrLogVO vo = new BkgVvdBdrLogVO();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap();
			mapVO.put("vps_etd_dt", vpsEtdDt);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOSearchBdrTime2RSQL(), param, velParam);

			if (dbRowset.first()) {

				vo.setUpdDt(dbRowset.getString(1));
				vo.setCreDt(dbRowset.getString(2));
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return vo;
	}

	/**
	 * BDR TIME 이 없는 경우 >>> TRUNK(M) 정보 조회 <br>
	 * 
	 * @param String vpsEtdDt
	 * @return BkgVvdBdrLogVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgVvdBdrLogVO searchBdrTimeM(String vpsEtdDt) throws DAOException {
		DBRowSet dbRowset = null;
		BkgVvdBdrLogVO vo = new BkgVvdBdrLogVO();
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap();
			mapVO.put("vps_etd_dt", vpsEtdDt);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOSearchBdrTime3RSQL(), param, velParam);

			if (dbRowset.first()) {

				vo.setUpdDt(dbRowset.getString(1));
				vo.setCreDt(dbRowset.getString(2));
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return vo;
	}

	/**
	 * BKG_VVD_BDR_LOG TABLE에 FLG 정보 조회 <br>
	 * 
	 * @param BkgVvdBdrLogVO vo
	 * @return List<BkgVvdBdrLogVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgVvdBdrLogVO> searchBkgVVDBdrLogFlg(BkgVvdBdrLogVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgVvdBdrLogVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOSearchBkgVVDBdrLogFlgRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgVvdBdrLogVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * VVD 에 해당하는 VSK_ACT_PORT_SKD TABLE 값 조회 <br>
	 * 
	 * @param BkgVvdBdrLogVO vo
	 * @return String 
	 * @throws DAOException
	 */
	public String searchVskActPortSkd(BkgVvdBdrLogVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		String actDepDt = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOSearchVskActPortSkdRSQL(), param, velParam);

			if (dbRowset.first()) {

				actDepDt = dbRowset.getString(1);
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return actDepDt;
	}

	/**
	 * BKG_VVD_BDR_LOG TABLE INSERT <br>
	 * 
	 * @param BkgVvdBdrLogVO vo
	 * @throws DAOException
	 */
	public void addBkgVVDBdrLog(BkgVvdBdrLogVO vo) throws DAOException {

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOBkgVvdBdrLogVOCSQL(), param, velParam);

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * BKG_VVD_BDR_LOG TABLE UPDATE
	 * 
	 * @param BkgVvdBdrLogVO vo
	 * @throws DAOException
	 */
	public void modifyBkgVVDBdrLog(BkgVvdBdrLogVO vo) throws DAOException {

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOBkgVvdBdrLogVOUSQL(), param, velParam);

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * BKG_VVD_BDR_LOG TABLE BDR_VSL_CHK_FLG UPDATE <br>
	 * 
	 * @param BkgVvdBdrLogVO vo
	 * @throws DAOException
	 */
	public void modifyBdrVslChkFlg(BkgVvdBdrLogVO vo) throws DAOException {

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOmodifyBdrVslChkFlgUSQL(), param, velParam);

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * BKG_VVD_BDR_LOG TABLE DELETE <br>
	 * 
	 * @param BkgVvdBdrLogVO vo
	 * @throws DAOException
	 */
	public void removeBkgVVDBdrLog(BkgVvdBdrLogVO vo) throws DAOException {

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOBkgVvdBdrLogVODSQL(), param, velParam);

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * BKG_CUST_SLS_REP TABLE CREATE <br>
	 * 
	 * @param CustSlsRepVO vo
	 * @throws DAOException
	 */
	public void addBkgCustSlsRep(CustSlsRepVO vo) throws DAOException {

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOaddBkgCustSlsRepCSQL(), param, velParam);

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * BKG_CUST_SLS_REP TABLE UPDATE <br>
	 * 
	 * @param CustSlsRepVO vo
	 * @throws DAOException
	 */
	public void modifyBkgCustSlsRep(CustSlsRepVO vo) throws DAOException {

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOmodifyBkgCustSlsRepUSQL(), param, velParam);

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * BKG_CUST_SLS_REP TABLE SELECT <br>
	 * 
	 * @param CustSlsRepVO vo
	 * @return void
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustSlsRepVO> searchBkgCustSlsRep(CustSlsRepVO vo) throws DAOException {

		DBRowSet dbRowset = null;
		List<CustSlsRepVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOsearchBkgCustSlsRepRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustSlsRepVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * BKG_DOC_CLZ_SET TABLE(Documentation Cut-off Time) 조회 <br>
	 * @param ydCd
	 * @param vslSlanCd
	 * @param deltFlg
	 * @return
	 * @throws DAOException
	 */
	public List<BkgdocClzSetListVO> searchDocCutOffTimeList(String ydCd, String vslSlanCd, String deltFlg) throws DAOException {

		DBRowSet dbRowset = null;
		List<BkgdocClzSetListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap();
			mapVO.put("yd_cd", ydCd);
			mapVO.put("vsl_slan_cd", vslSlanCd);
			mapVO.put("delt_flg", deltFlg);
//			mapVO.put("chk_op", "Y");

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOBkgdocClzSetListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgdocClzSetListVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * COUNTRY CODE,NAME 조회 <br>
	 * 
	 * @return List<MdmCountryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MdmCountryVO> searchCntCdNm() throws DAOException {

		DBRowSet dbRowset = null;
		List<MdmCountryVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOsearchCntCdNmRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmCountryVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * Documentation Cut-off Time을 입력합니다.<br>
	 * 
	 * @param BkgdocClzSetVO vo
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public void addDocCutOffTime(BkgdocClzSetVO vo) throws DAOException {

		DBRowSet dbRowset = null;
		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			List<BkgdocClzSetListVO> list = new ArrayList<BkgdocClzSetListVO>();
			
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				mapVO.put("chk_op", "N");

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOBkgdocClzSetListVORSQL(), param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgdocClzSetListVO.class);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = 0;

			// DELT_FLG 가 Y 되어있는 기존 정보가 있을 경우 N으로 변경하고 UPDATE한다.
			if (list.size() > 0) {
				delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOBkgdocClzSetVOUSQL(), param, velParam);
			} else {
				delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOBkgdocClzSetVOCSQL(), param, velParam);
			}

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Documentation Cut-off Time을 수정합니다. <br>
	 * 
	 * @param BkgdocClzSetVO vo
	 * @throws DAOException
	 */
	public void modifyDocCutOffTime(BkgdocClzSetVO vo) throws DAOException {

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOBkgdocClzSetVOUSQL(), param, velParam);

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Documentation Cut-off Time을 삭제합니다.<br>
	 * 
	 * @param BkgdocClzSetVO vo
	 * @throws DAOException
	 */
	public void removeDocCutOffTime(BkgdocClzSetVO vo) throws DAOException {

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOBkgdocClzSetVODSQL(), param, velParam);

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Mandatory Item(s) Setup for Customized Service 을 입력합니다.<br>
	 * 
	 * @param MandatoryItemSetupListVO vo
	 * @throws DAOException
	 */
	public void addMandatoryItemSetupList(MandatoryItemSetupListVO vo) throws DAOException {

		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int delCnt = 0;

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOMandatoryItemSetupList2VORSQL(), param, velParam);

				if (dbRowset.first()) {

					vo.setMdtItmSeq(dbRowset.getString(1));
				}

				mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOMandatoryItemSetupListVOCSQL(), param, velParam);

				// UI상에 선택된 Item 을 BKG_MDT_ITM_DTL TABLE 에 MULTI 로 입력한다.
				if (vo.getItmCdPob().equals("1")) {

					vo.setBkgMdtItmCd("POB");

					mapVO = vo.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOMandatoryItemSetupList2VOCSQL(), param, velParam);
				}

				if (vo.getItmCdPoc().equals("1")) {

					vo.setBkgMdtItmCd("POC");

					mapVO = vo.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOMandatoryItemSetupList2VOCSQL(), param, velParam);
				}

				if (vo.getItmCdPom().equals("1")) {

					vo.setBkgMdtItmCd("POM");

					mapVO = vo.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOMandatoryItemSetupList2VOCSQL(), param, velParam);
				}

				if (vo.getItmCdInv().equals("1")) {

					vo.setBkgMdtItmCd("INV");

					mapVO = vo.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOMandatoryItemSetupList2VOCSQL(), param, velParam);
				}

				if (vo.getItmCdDep().equals("1")) {

					vo.setBkgMdtItmCd("DPT");

					mapVO = vo.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOMandatoryItemSetupList2VOCSQL(), param, velParam);
				}

				if (vo.getItmCdLc().equals("1")) {

					vo.setBkgMdtItmCd("LCN");

					mapVO = vo.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOMandatoryItemSetupList2VOCSQL(), param, velParam);
				}

				if (vo.getItmCdShp().equals("1")) {

					vo.setBkgMdtItmCd("SHP");

					mapVO = vo.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOMandatoryItemSetupList2VOCSQL(), param, velParam);
				}

				if (vo.getItmCdPat().equals("1")) {

					vo.setBkgMdtItmCd("PRT");

					mapVO = vo.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOMandatoryItemSetupList2VOCSQL(), param, velParam);
				}

				if (vo.getItmCdInc().equals("1")) {

					vo.setBkgMdtItmCd("INC");

					mapVO = vo.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOMandatoryItemSetupList2VOCSQL(), param, velParam);
				}
			}

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Mandatory Item(s) Setup for Customized Service 을 수정합니다.<br>
	 * 
	 * @param MandatoryItemSetupListVO vo
	 * @throws DAOException
	 */
	public void modifyMandatoryItemSetupList(MandatoryItemSetupListVO vo) throws DAOException {

		int delCnt = 0;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
				delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOMandatoryItemSetupListVOUSQL(), param, velParam);

				// UPDATE 일 경우 기존 BKG_MDT_ITM_DTL 에 정보를 삭제하고 다시 입력한다.
				delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOMandatoryItemSetupList2VODSQL(), param, velParam);
				// UI상에 선택된 Item 을 BKG_MDT_ITM_DTL TABLE 에 MULTI 로 입력한다.
				if (vo.getItmCdPob().equals("1")) {

					vo.setBkgMdtItmCd("POB");

					mapVO = vo.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOMandatoryItemSetupList2VOCSQL(), param, velParam);
				}

				if (vo.getItmCdPoc().equals("1")) {

					vo.setBkgMdtItmCd("POC");

					mapVO = vo.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOMandatoryItemSetupList2VOCSQL(), param, velParam);
				}

				if (vo.getItmCdPom().equals("1")) {

					vo.setBkgMdtItmCd("POM");

					mapVO = vo.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOMandatoryItemSetupList2VOCSQL(), param, velParam);
				}

				if (vo.getItmCdInv().equals("1")) {

					vo.setBkgMdtItmCd("INV");

					mapVO = vo.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOMandatoryItemSetupList2VOCSQL(), param, velParam);
				}

				if (vo.getItmCdDep().equals("1")) {

					vo.setBkgMdtItmCd("DPT");

					mapVO = vo.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOMandatoryItemSetupList2VOCSQL(), param, velParam);
				}

				if (vo.getItmCdLc().equals("1")) {

					vo.setBkgMdtItmCd("LCN");

					mapVO = vo.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOMandatoryItemSetupList2VOCSQL(), param, velParam);
				}

				if (vo.getItmCdShp().equals("1")) {

					vo.setBkgMdtItmCd("SHP");

					mapVO = vo.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOMandatoryItemSetupList2VOCSQL(), param, velParam);
				}

				if (vo.getItmCdPat().equals("1")) {

					vo.setBkgMdtItmCd("PRT");

					mapVO = vo.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOMandatoryItemSetupList2VOCSQL(), param, velParam);
				}

				if (vo.getItmCdInc().equals("1")) {

					vo.setBkgMdtItmCd("INC");

					mapVO = vo.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOMandatoryItemSetupList2VOCSQL(), param, velParam);
				}
			}

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Mandatory Item(s) Setup for Customized Service 을 삭제합니다.<br>
	 * 
	 * @param MandatoryItemSetupListVO vo
	 * @throws DAOException
	 */
	public void removeMandatoryItemSetupList(MandatoryItemSetupListVO vo) throws DAOException {

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOMandatoryItemSetupList2VODSQL(), param, velParam);

			delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOMandatoryItemSetupListVODSQL(), param, velParam);	

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * Mandatory Item(s) Setup for Customized Service 를 조회 합니다.<br>
	 * 
	 * @param BkgMdtItmVO vo
	 * @return List<BkgMdtItmVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgMdtItmVO> searchMandatoryItemSetupList(BkgMdtItmVO vo) throws DAOException {

		DBRowSet dbRowset = null;
		List<BkgMdtItmVO> list = new ArrayList();

		String[] temp = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOBkgMdtItmVORSQL(), param, velParam);
			// list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgMdtItmVO
			// .class);

			while (dbRowset.next()) {

				BkgMdtItmVO bkgMdtItmVO = new BkgMdtItmVO();

				bkgMdtItmVO.setMdtItmSeq(dbRowset.getString(1));

				bkgMdtItmVO.setBkgMdtCateCd(dbRowset.getString("BKG_MDT_CATE_CD"));
				bkgMdtItmVO.setMdtCustTpCd(dbRowset.getString("MDT_CUST_TP_CD"));
				bkgMdtItmVO.setCustGrpId(dbRowset.getString("CUST_GRP_ID"));
				bkgMdtItmVO.setCustCntCd(dbRowset.getString("CUST_CNT_CD"));
				bkgMdtItmVO.setCustSeq(dbRowset.getString("CUST_SEQ"));
				bkgMdtItmVO.setScNo(dbRowset.getString("SC_NO"));
				bkgMdtItmVO.setRfaNo(dbRowset.getString("RFA_NO"));
				bkgMdtItmVO.setSvcScpCd(dbRowset.getString("SVC_SCP_CD"));
				bkgMdtItmVO.setPorCd(dbRowset.getString("POR_CD"));
				bkgMdtItmVO.setPolCd(dbRowset.getString("POL_CD"));
				bkgMdtItmVO.setPodCd(dbRowset.getString("POD_CD"));
				bkgMdtItmVO.setDelCd(dbRowset.getString("DEL_CD"));
				bkgMdtItmVO.setMdtItmRmk(dbRowset.getString("MDT_ITM_RMK"));
				bkgMdtItmVO.setUpdUsrId(dbRowset.getString("UPD_USR_ID"));
				bkgMdtItmVO.setUpdDt(dbRowset.getString("UPD_DT"));

				bkgMdtItmVO.setItmNmPob(dbRowset.getString("ITM_NM_POB"));
				bkgMdtItmVO.setItmNmPoc(dbRowset.getString("ITM_NM_POC"));
				bkgMdtItmVO.setItmNmPom(dbRowset.getString("ITM_NM_POM"));
				bkgMdtItmVO.setItmNmInv(dbRowset.getString("ITM_NM_INV"));
				bkgMdtItmVO.setItmNmDep(dbRowset.getString("ITM_NM_DEP"));
				bkgMdtItmVO.setItmNmLc(dbRowset.getString("ITM_NM_LC"));
				bkgMdtItmVO.setItmNmShp(dbRowset.getString("ITM_NM_SHP"));
				bkgMdtItmVO.setItmNmPat(dbRowset.getString("ITM_NM_PAT"));
				bkgMdtItmVO.setItmNmInc(dbRowset.getString("ITM_NM_INC"));
				bkgMdtItmVO.setFcust(dbRowset.getString("FCUST"));
				bkgMdtItmVO.setScExpDt(dbRowset.getString("SC_EXP_DT"));
				bkgMdtItmVO.setRfaExpDt(dbRowset.getString("RFA_EXP_DT"));

				temp = dbRowset.getString("BKG_MDT_ITM_CD").split(",");

				for (int j = 0; j < temp.length; j++) {

					if (temp[j].equals("POB")) {

						bkgMdtItmVO.setItmCdPob("1");
					} else if (temp[j].equals("POC")) {

						bkgMdtItmVO.setItmCdPoc("1");
					} else if (temp[j].equals("POM")) {

						bkgMdtItmVO.setItmCdPom("1");
					} else if (temp[j].equals("INV")) {

						bkgMdtItmVO.setItmCdInv("1");
					} else if (temp[j].equals("DPT")) {

						bkgMdtItmVO.setItmCdDep("1");
					} else if (temp[j].equals("LCN")) {

						bkgMdtItmVO.setItmCdLc("1");
					} else if (temp[j].equals("SHP")) {

						bkgMdtItmVO.setItmCdShp("1");
					} else if (temp[j].equals("PRT")) {

						bkgMdtItmVO.setItmCdPat("1");
					} else if (temp[j].equals("INC")) {

						bkgMdtItmVO.setItmCdInc("1");
					}
				}

				list.add(bkgMdtItmVO);
			}

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * BKG_EDI_TRD_PRNR_SUB_LNK TABLE SELECT
	 * 
	 * @param BkgEdiTrdPrnrSubLnkVO vo
	 * @return List<BkgEdiTrdPrnrSubLnkVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgEdiTrdPrnrSubLnkVO> searchBkgEdiTrdPrnrSubLnk(BkgEdiTrdPrnrSubLnkVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgEdiTrdPrnrSubLnkVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOsearchBkgEdiTrdPrnrSubLnkRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgEdiTrdPrnrSubLnkVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * BKG_EDI_TRD_PRNR_SUB_LNK TABLE UPDATE <br>
	 * 
	 * @param BkgEdiTrdPrnrSubLnkVO vo
	 * @throws DAOException
	 */
	public void modifyBkgEdiTrdPrnrSubLnk(BkgEdiTrdPrnrSubLnkVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (null != vo) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOmodifyBkgEdiTrdPrnrSubLnkUSQL(), param, velParam);
			if (updCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * BKG_EDI_TRD_PRNR_SUB_LNK TABLE CREATE <br>
	 * 
	 * @param BkgEdiTrdPrnrSubLnkVO vo
	 * @throws DAOException
	 */
	public void addBkgEdiTrdPrnrSubLnk(BkgEdiTrdPrnrSubLnkVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (null != vo) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int creCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOaddBkgEdiTrdPrnrSubLnkCSQL(), param, velParam);
			if (creCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * BKG_EDI_SUB_LNK_MSG TABLE SELECT <br>
	 * 
	 * @param BkgEdiSubLnkMsgVO vo
	 * @return List<BkgEdiSubLnkMsgVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgEdiSubLnkMsgVO> searchBkgEdiSubLnkMsg(BkgEdiSubLnkMsgVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgEdiSubLnkMsgVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOsearchBkgEdiSubLnkMsgRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgEdiSubLnkMsgVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * BKG_EDI_SUB_LNK_MSG TABLE UPDATE <br>
	 * 
	 * @param BkgEdiSubLnkMsgVO vo
	 * @throws DAOException
	 */
	public void modifyBkgEdiSubLnkMsg(BkgEdiSubLnkMsgVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (null != vo) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOmodifyBkgEdiSubLnkMsgUSQL(), param, velParam);
			if (updCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * BKG_EDI_SUB_LNK_MSG TABLE CREATE <br>
	 * 
	 * @param BkgEdiSubLnkMsgVO vo
	 * @throws DAOException
	 */
	public void addBkgEdiSubLnkMsg(BkgEdiSubLnkMsgVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (null != vo) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int creCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOaddBkgEdiSubLnkMsgCSQL(), param, velParam);
			if (creCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * BKG_EDI_PRNR_PORT_LANE TABLE SELECT
	 * 
	 * @param BkgEdiPrnrPortLaneVO vo
	 * @return List<BkgEdiPrnrPortLaneVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgEdiPrnrPortLaneVO> searchBkgEdiPrnrPortLane(BkgEdiPrnrPortLaneVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgEdiPrnrPortLaneVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOsearchBkgEdiPrnrPortLaneRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgEdiPrnrPortLaneVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * BKG_EDI_PRNR_PORT_LANE TABLE UPDATE
	 * 
	 * @param BkgEdiPrnrPortLaneVO vo
	 * @throws DAOException
	 */
	public void modifyBkgEdiPrnrPortLane(BkgEdiPrnrPortLaneVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (null != vo) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOmodifyBkgEdiPrnrPortLaneUSQL(), param, velParam);
			if (updCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * BKG_EDI_PRNR_PORT_LANE TABLE CREATE
	 * 
	 * @param BkgEdiPrnrPortLaneVO vo
	 * @throws DAOException
	 */
	public void addBkgEdiPrnrPortLane(BkgEdiPrnrPortLaneVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (null != vo) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int creCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOaddBkgEdiPrnrPortLaneCSQL(), param, velParam);
			if (creCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * 북중국 Manual BKG No 선 생성 현황 조회<br>
	 * 
	 * @param ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO
	 * @return List<BkgChnBkgNoGenVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgChnBkgNoGenVO> searchChnMnlBkgNoGenList(ChnMnlBkgNoGenCondVO chnMnlBkgNoGenCondVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = chnMnlBkgNoGenCondVO.getColumnValues();
			List<BkgChnBkgNoGenVO> list = null;

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOSearchChnMnlBkgNoGenListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgChnBkgNoGenVO.class);

			return list;
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * 북중국 Manual BKG No 선 생성 현황 생성 <br>
	 * 
	 * @param List<BkgChnBkgNoGenVO> bkgChnBkgNoGenVOs
	 * @exception DAOException
	 */
	public void addBkgChnBkgNoGenList(List<BkgChnBkgNoGenVO> bkgChnBkgNoGenVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgChnBkgNoGenVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new BookingMasterMgtDBDAOAddBkgChnBkgNoGenListCSQL(), bkgChnBkgNoGenVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
					// Failed to add new North Chinese Booking Number[%s] to List [%s]
					throw new EventException(new ErrorHandler("BKG08059", new String[] { bkgChnBkgNoGenVOs.get(i).getBkgNo(), String.valueOf(i) }).getUserMessage());
				}
			}
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 북중국 Manual BKG No 선 생성 현황 생성 하기전 생성가능한 인지 B.Office 체크
	 * @param ofcCd
	 * @return
	 * @throws DAOException
	 */
	public String searchOfcCheck(String ofcCd) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOsearchBkgChnBkgNoGenOffCdCheckRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString("MNL_BKG_NO_OPT_CD");
			}
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return null;
	}
	
	/**
	 * 해당 지점에 북중국 대리점이 존재 여부 조회 <br>
	 * 
	 * @param String ofcCd
	 * @param String chnAgnCd
	 * @return String existFlg
	 * @exception DAOException
	 */
	public String searchChnOfcAgn(String ofcCd, String chnAgnCd) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("chn_agn_cd", chnAgnCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOSearchChnOfcAgnRSQL(), param, velParam);
			if (dbRowset.next()) {
				return dbRowset.getString("exist_flg");
			}
			else {
				return "N";
			}

		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 북중국 Manual BKG No 사용 했음을 표시 <br>
	 * 
	 * @param List<BkgChnBkgNoGenVO> bkgChnBkgNoGenVOs
	 * @param String bkgPorCd 
	 * @exception DAOException
	 */
	public void modifyChnBkgNoUseFlgOnList(List<BkgChnBkgNoGenVO> bkgChnBkgNoGenVOs, String bkgPorCd) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();			

			if (bkgChnBkgNoGenVOs.size() > 0) {
				for(int i = 0 ; i < bkgChnBkgNoGenVOs.size() ; i++){
					if(bkgChnBkgNoGenVOs.get(i) != null){
						Map<String, String> mapVO = bkgChnBkgNoGenVOs.get(i).getColumnValues();

						param.putAll(mapVO);
						param.put("bkg_por_cd", bkgPorCd);
						velParam.putAll(mapVO);				
						
						int updCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOModifyChnBkgNoUseFlgOnListUSQL(), param,velParam);
						if(updCnt == Statement.EXECUTE_FAILED)
							throw new EventException(new ErrorHandler("BKG08059", new String[] { bkgChnBkgNoGenVOs.get(i).getBkgNo(), String.valueOf(i) }).getUserMessage());						
					}	
				}
			}
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	/**
	 * WDPCS - S/R 업무처리 담당자 Group 정보를 Searchg한다.(ESM_BKG_0592)<br>
	 * 
	 * @param String usrId
	 * @param String dpcsWrkGrpCd
	 * @param BkgDpcsUsrGrpVO vo
	 * @return List<BkgDpcsUsrGrpVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgDpcsUsrGrpVO> searchDPSCPicUserGroup(String usrId,String dpcsWrkGrpCd, BkgDpcsUsrGrpVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgDpcsUsrGrpVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();
				
				
				param.put("usr_id", usrId);
				
				velParam.put("usr_id", usrId);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOSearchDPCSPicUserGroupRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgDpcsUsrGrpVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * BKG_EDI_GRP 데이터를 갱신한다.<br>
	 * 
	 * @param List<BkgEdiGrpVO> list
	 * @throws DAOException
	 */
	public void manageBkgEdiGrp(List<BkgEdiGrpVO> list) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = null;
		SQLExecuter sqlExe = null;
		try {
			if (null != list) {
				sqlExe = new SQLExecuter("DEFAULT");
				for (BkgEdiGrpVO bkgEdiGrpVO : list) {
					if (null != bkgEdiGrpVO) {
						mapVO = bkgEdiGrpVO.getColumnValues();
						param.putAll(mapVO);
						velParam.putAll(mapVO);
						if ("D".equals(bkgEdiGrpVO.getEaiSts())) {
							sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOBkgEdiGrpDSQL(), param, velParam);
						} else {
							sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOBkgEdiGrpUSQL(), param, velParam);
						}
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * BKG_EDI_GRP_CUST 데이터를 갱신한다.<br>
	 * 
	 * @param List<BkgEdiGrpCustVO> list
	 * @throws DAOException
	 */
	public void manageBkgEdiGrpCust(List<BkgEdiGrpCustVO> list) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = null;
		SQLExecuter sqlExe = null;
		try {
			if (null != list) {
				sqlExe = new SQLExecuter("DEFAULT");
				for (BkgEdiGrpCustVO bkgEdiGrpCustVO : list) {
					if (null != bkgEdiGrpCustVO) {
						mapVO = bkgEdiGrpCustVO.getColumnValues();
						param.putAll(mapVO);
						velParam.putAll(mapVO);
						if ("D".equals(bkgEdiGrpCustVO.getEaiSts())) {
							sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOBkgEdiGrpCustDSQL(), param, velParam);
						} else {
							sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOBkgEdiGrpCustUSQL(), param, velParam);
						}
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * BKG의 VVD의 BDR LOG FLAG를  조회한다. <br>
	 * 
	 * @param String vvdCd
	 * @param String polCd
	 * @param String podCd
	 * @param String rdoTrunkFeeder
	 * @return String
	 * @throws DAOException
	 */
	public String checkVvdBdrLog(String vvdCd,String polCd,String podCd,String rdoTrunkFeeder) throws DAOException {
		String bdrLogFlag = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap<String,String>();
		try {
			mapVO.put("vvd_cd", vvdCd);
			mapVO.put("pol_cd", polCd);
			mapVO.put("pod_cd", podCd);
			mapVO.put("rdo_trunk_feeder", rdoTrunkFeeder);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOCheckVvdBdrLogRSQL(), param, velParam);
			if (dbRowset.next()) {
				bdrLogFlag = dbRowset.getString("BDR_FLAG");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bdrLogFlag;
	}
	
	/**
	 * bkgNo가 china agent bkg no인지 조회한다.<br>
	 * 
	 * @param 	String bkgNo
	 * @return 	String 
	 * @exception EventException
	 */	
	@SuppressWarnings("unchecked")
	public String searchIsChnMnlBkgNo(String bkgNo) throws DAOException {
		String bdrLogFlag = null;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = new HashMap();
		try {
			
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOSearchIsChnMnlBkgNoRSQL(), param, velParam);
			if (dbRowset.next()) {
				bdrLogFlag = dbRowset.getString("MNL_BKG_FLG");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bdrLogFlag;
	}
	
	
	/**
	 * HamoTrf Code 생성한다.(ESM_BKG_0607_C)<br>
	 * 
	 * @param BkgHamoTrfVO bkgHamoTrfVO
	 * @param String usrId
	 * @exception DAOException
	 */

	public void addHtsCode(BkgHamoTrfVO bkgHamoTrfVO,String usrId) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		Map<String, String> mapVO = null;

		try {
				mapVO = bkgHamoTrfVO .getColumnValues();
				mapVO.put("usrId", usrId);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				new SQLExecuter("").executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOBkgHamoTrfVOCSQL(),param, velParam);

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	
	/**
	 * HamoTrf Code 수정한다.(ESM_BKG_0607_C)<br>
	 * 
	 * @param BkgHamoTrfVO bkgHamoTrfVO
	 * @param String usrId
	 * @exception DAOException
	 */
	

	public void modifyHtsCode(BkgHamoTrfVO bkgHamoTrfVO,String usrId) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		Map<String, String> mapVO = null;

		try {
                mapVO = bkgHamoTrfVO.getColumnValues();
				mapVO.put("usrId", usrId);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				
				new SQLExecuter("").executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOBkgHamoTrfVOUSQL(),param, velParam);

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		
	}
	/**
	 * HamoTrf Code 삭제한다.(ESM_BKG_0607_C)<br>
	 * 
	 * @param BkgHamoTrfVO bkgHamoTrfVO
	 * @param String usrId
	 * @exception DAOException
	 */
	


	public void removeHtsCode(BkgHamoTrfVO bkgHamoTrfVO,String usrId) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		Map<String, String> mapVO = null;

		try {

				mapVO = bkgHamoTrfVO.getColumnValues();
				mapVO.put("usrId", usrId);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				
				new SQLExecuter("").executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOBkgHtsCodeUSQL(),param, velParam);

		}catch(SQLException se) 
		{
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} 
		catch(Exception ex) 
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * [ESM_BKG_1114] Zip Code 등록 화면-조회<br>
	 * @param ZipCdSchVO vo
	 * @return List<ZipCdListVO>
	 * @throws DAOException
	 */
	public List<ZipCdListVO> searchZipCode(ZipCdSchVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ZipCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOBkgZipCdVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ZipCdListVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}
	/**
	 * [ESM_BKG_1114] Zip code 입력, 수정<br>
	 * @param ZipCdListVO zipCdListVO
	 * @throws DAOException
	 * @author KIM HYUN HWA
	 */
	public void mergeZipCode(ZipCdListVO zipCdListVO) throws DAOException {
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try 
		{
		Map<String, String> mapVO = zipCdListVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOBkgZipCdVOUSQL(), param, velParam);

		} catch (SQLException se) {
			//log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	/**
	 * [ESM_BKG_1114] Zip code 삭제<br>
	 * @param ZipCdListVO zipCdListVO
	 * @throws DAOException
	 * @author KIM HYUN HWA
	 */
	public void removeZipCode(ZipCdListVO zipCdListVO) throws DAOException, Exception {

		Map<String, Object> param = new HashMap<String, Object>();

		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (zipCdListVO != null) {
				Map<String, String> mapVO = zipCdListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOBkgZipCdVODSQL(), param, velParam);

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
		//	log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
		//	log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	

	/**
	 * Booking SalesRep Code를 입력합니다.<br>
	 * 
	 * @param BkgSalesRepVO bkgSalesRepVO
	 * @throws DAOException
	 */
	public void addSalesRepCode(BkgSalesRepVO bkgSalesRepVO) throws DAOException {

		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try 
		{
		Map<String, String> mapVO = bkgSalesRepVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOAddSalesRepCodeCSQL(), param, velParam);

		
		
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	/**
	 * Booking SalesRep Code를 입력합니다.<br>
	 * 
	 * @param BkgSalesRepVO bkgSalesRepVO
	 * @throws DAOException
	 */
	public void modifySalesRepCode(BkgSalesRepVO bkgSalesRepVO) throws DAOException {
	
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (bkgSalesRepVO != null) {
				Map<String, String> mapVO = bkgSalesRepVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOmodifySalesRepCodeUSQL(), param, velParam);
	
			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
	
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * select Hard Coding Setup List
	 * @param BkgHrdCdgDescVO bkgHrdCdgDescVO
	 * @return List<BkgHrdCdgDescVO>
	 * @throws DAOException
	 */
	public List<BkgHrdCdgDescVO> searchHrdCdgDesc(BkgHrdCdgDescVO bkgHrdCdgDescVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgHrdCdgDescVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgHrdCdgDescVO != null){
				Map<String, String> mapVO = bkgHrdCdgDescVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingMasterMgtDBDAOsearchHrdCdgDescRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgHrdCdgDescVO .class);
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
	 * Hard Coding Setup List Insert
	 * @param BkgHrdCdgDescVO bkgHrdCdgDescVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void addHrdCdgDesc(BkgHrdCdgDescVO bkgHrdCdgDescVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgHrdCdgDescVO != null){
				mapVO = bkgHrdCdgDescVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("usr_id", account.getUsr_id());
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOaddHrdCdgDescCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert No"+ " SQL");
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
	 * Hard Coding Setup List Delete.
	 * @param BkgHrdCdgDescVO bkgHrdCdgDescVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void removeHrdCdgDesc(BkgHrdCdgDescVO bkgHrdCdgDescVO, SignOnUserAccount account) throws DAOException {
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgHrdCdgDescVO != null){
				mapVO = bkgHrdCdgDescVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
//				param.put("usr_id", account.getUsr_id());
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOremoveHrdCdgDescDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert No"+ " SQL");
			}
					
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**Hard Coding Contents List Delete incase Hard Coding Setup List have to be deleted
	 * @param BkgHrdCdgDescVO bkgHrdCdgDescVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
//	public void removeHrdCdgChild(BkgHrdCdgDescVO bkgHrdCdgDescVO, SignOnUserAccount account) throws DAOException {
//		Map<String, String> mapVO = null;
//		//query parameter
//		Map<String, Object> param = new HashMap<String, Object>();
//		//velocity parameter
//		Map<String, Object> velParam = new HashMap<String, Object>();
//
//		try{
//			if(bkgHrdCdgDescVO != null){
//				mapVO = bkgHrdCdgDescVO .getColumnValues();
//				param.putAll(mapVO);
//				velParam.putAll(mapVO);
////				param.put("usr_id", account.getUsr_id());
//			}
//			SQLExecuter sqlExe = new SQLExecuter("");
//			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOremoveHrdCdgChildDSQL(), param, velParam);
//			if(result == Statement.EXECUTE_FAILED){
//				throw new DAOException("Fail to delete No"+ " SQL");
//			}
//					
//		} catch(SQLException se) {
//			log.error(se.getMessage(),se);
//			throw new DAOException(new ErrorHandler(se).getMessage());
//		} catch(Exception ex) {
//			log.error(ex.getMessage(),ex);
//			throw new DAOException(new ErrorHandler(ex).getMessage());
//		}
//	}
	/**
	 * Hard Coding Setup List Update
	 * @param BkgHrdCdgDescVO bkgHrdCdgDescVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void modifyHrdCdgDesc(BkgHrdCdgDescVO bkgHrdCdgDescVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgHrdCdgDescVO != null){
				mapVO = bkgHrdCdgDescVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("usr_id", account.getUsr_id());
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOmodifyHrdCdgDescUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert No"+ " SQL");
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
	 * select Hard Coding Contents List
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @return List<BkgHrdCdgCtntVO>
	 * @throws DAOException
	 */
	public List<BkgHrdCdgCtntVO> searchHrdCdgCtnt(BkgHrdCdgCtntVO bkgHrdCdgCtntVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgHrdCdgCtntVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgHrdCdgCtntVO != null){
				Map<String, String> mapVO = bkgHrdCdgCtntVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingMasterMgtDBDAOsearchHrdCdgCtntRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgHrdCdgCtntVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**Hard Coding Contents List Insert
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void addHrdCdgCtnt(BkgHrdCdgCtntVO bkgHrdCdgCtntVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgHrdCdgCtntVO != null){
				mapVO = bkgHrdCdgCtntVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				param.put("cre_usr_id", account.getUsr_id());
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOaddHrdCdgCtntCSQL(), param, velParam);
			log.debug("result "+result);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert No"+ " SQL");
			}
					
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**Hard Coding Contents List Delete.
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void removeHrdCdgCtnt(BkgHrdCdgCtntVO bkgHrdCdgCtntVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgHrdCdgCtntVO != null){
				mapVO = bkgHrdCdgCtntVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOremoveHrdCdgCtntDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert No"+ " SQL");
			}
					
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**Hard Coding Contents List Update
	 * @param BkgHrdCdgCtntVO bkgHrdCdgCtntVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void modifyHrdCdgCtnt(BkgHrdCdgCtntVO bkgHrdCdgCtntVO, SignOnUserAccount account) throws DAOException {
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgHrdCdgCtntVO != null){
				mapVO = bkgHrdCdgCtntVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOmodifyHrdCdgCtntUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert No"+ " SQL");
			}
					
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**check if there is the same Hardcoding Id in DB
	 * @param String hrdCdgId
	 * @return DBRowSet 
	 * @throws DAOException
	 */
	public DBRowSet checkHrdCdgId(String hrdCdgId) throws DAOException {
		DBRowSet dbRowset = null; 
		Map<String, Object> param = new HashMap<String, Object>();//parameter	
			try {
				
				if(hrdCdgId != null){
					param.put("frm_hrd_cdg_id",hrdCdgId);			
				}
							
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingMasterMgtDBDAOcheckHrdCdgIdRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dbRowset;
	}	
	/**check if there is data on Hard coding contents
	 * @param hrdCdgId
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet checkChildCnt(String hrdCdgId) throws DAOException {
		DBRowSet dbRowset = null; 
		Map<String, Object> param = new HashMap<String, Object>();//parameter	
			try {
				
				if(hrdCdgId != null){
					param.put("hrd_cdg_id",hrdCdgId);			
				}
							
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingMasterMgtDBDAOcheckChildCntRSQL(), param, null);
			} catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage());			
			} catch(Exception ex){
				log.error(ex.getMessage(),ex);			
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}

			return dbRowset;
	}
	
	/**
	 * select Controlling Party List
	 * @param BkgCtrlPtyVO bkgCtrlPtyVO
	 * @return List<BkgCtrlPtyVO>
	 * @throws DAOException
	 */
	public List<BkgCtrlPtyVO> searchControllingPartyList(BkgCtrlPtyVO bkgCtrlPtyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCtrlPtyVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgCtrlPtyVO != null){
				Map<String, String> mapVO = bkgCtrlPtyVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingMasterMgtDBDAOSearchControllingPartyListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCtrlPtyVO .class);
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
	 * select Internet B/L Control List
	 * @param BkgCtrlPtyVO bkgCtrlPtyVO
	 * @return List<BkgInetBlCtrlPtyVO>
	 * @throws DAOException
	 */
	public List<BkgInetBlCtrlPtyVO> searchInernettBlControlPartyList(BkgCtrlPtyVO bkgCtrlPtyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgInetBlCtrlPtyVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgCtrlPtyVO != null){
				Map<String, String> mapVO = bkgCtrlPtyVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingMasterMgtDBDAOSearchInernettBlControlPartyListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgInetBlCtrlPtyVO .class);
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
	 * select BL Group List
	 * @param BkgCtrlPtyVO bkgCtrlPtyVO
	 * @return List<BkgCtrlPtyBlGrpVO>
	 * @throws DAOException
	 */
	public List<BkgCtrlPtyBlGrpVO> searchBlGroupList(BkgCtrlPtyVO bkgCtrlPtyVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCtrlPtyBlGrpVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgCtrlPtyVO != null){
				Map<String, String> mapVO = bkgCtrlPtyVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingMasterMgtDBDAOSearchBlGroupListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCtrlPtyBlGrpVO .class);
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
	 * selectMaxCntrPtySeq
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet selectMaxCntrPtySeq() throws DAOException {
		DBRowSet dbRowset = null; 
		Map<String, Object> param = new HashMap<String, Object>();//parameter	
		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingMasterMgtDBDAOSelectMaxCntrPtySeqRSQL(), param, null);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dbRowset;
	}	
	
	/**
	 * addControllingParty
	 * @param BkgCtrlPtyVO bkgCtrlPtyVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void addControllingParty(BkgCtrlPtyVO bkgCtrlPtyVO, SignOnUserAccount account) throws DAOException {
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgCtrlPtyVO != null){
				mapVO = bkgCtrlPtyVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cre_usr_id", account.getUsr_id());
				param.put("upd_usr_id", account.getUsr_id());
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOAddControllingPartyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert No"+ " SQL");
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
	 * modifyControllingParty
	 * @param BkgCtrlPtyVO bkgCtrlPtyVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void modifyControllingParty(BkgCtrlPtyVO bkgCtrlPtyVO, SignOnUserAccount account) throws DAOException {
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgCtrlPtyVO != null){
				mapVO = bkgCtrlPtyVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOModifyControllingPartyUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to update "+ " SQL");
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
	 * removeControllingParty
	 * @param BkgCtrlPtyVO bkgCtrlPtyVO
	 * @throws DAOException
	 */
	public void removeControllingParty(BkgCtrlPtyVO bkgCtrlPtyVO) throws DAOException {
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgCtrlPtyVO != null){
				mapVO = bkgCtrlPtyVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAORemoveControllingPartyDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to remove "+ " SQL");
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
	 * addInernettBlControlParty
	 * @param BkgInetBlCtrlPtyVO bkgInetBlCtrlPtyVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void addInernettBlControlParty(BkgInetBlCtrlPtyVO bkgInetBlCtrlPtyVO, SignOnUserAccount account) throws DAOException {
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgInetBlCtrlPtyVO != null){
				mapVO = bkgInetBlCtrlPtyVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cre_usr_id", account.getUsr_id());
				param.put("upd_usr_id", account.getUsr_id());
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOAddInernettBlControlPartyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert "+ " SQL");
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
	 * modifyInernettBlControlParty
	 * @param BkgInetBlCtrlPtyVO bkgInetBlCtrlPtyVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void modifyInernettBlControlParty(BkgInetBlCtrlPtyVO bkgInetBlCtrlPtyVO, SignOnUserAccount account) throws DAOException {
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgInetBlCtrlPtyVO != null){
				mapVO = bkgInetBlCtrlPtyVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOModifyInernettBlControlPartyUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to update "+ " SQL");
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
	 * removeInernettBlControlParty
	 * @param BkgInetBlCtrlPtyVO bkgInetBlCtrlPtyVO
	 * @throws DAOException
	 */
	public void removeInernettBlControlParty(BkgInetBlCtrlPtyVO bkgInetBlCtrlPtyVO) throws DAOException {
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgInetBlCtrlPtyVO != null){
				mapVO = bkgInetBlCtrlPtyVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAORemoveInernettBlControlPartyDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to remove "+ " SQL");
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
	 * removeInernettBlControlPartyByCtrlPtySeq
	 * @param BkgInetBlCtrlPtyVO bkgInetBlCtrlPtyVO
	 * @throws DAOException
	 */
	public void removeInernettBlControlPartyByCtrlPtySeq(BkgInetBlCtrlPtyVO bkgInetBlCtrlPtyVO) throws DAOException {
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgInetBlCtrlPtyVO != null){
				mapVO = bkgInetBlCtrlPtyVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAORemoveInernettBlControlPartyByCtrlPtySeqDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to remove "+ " SQL");
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
	 * checkInernettBlControlParty
	 * @param BkgInetBlCtrlPtyVO bkgInetBlCtrlPtyVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkInernettBlControlParty(BkgInetBlCtrlPtyVO bkgInetBlCtrlPtyVO) throws DAOException {
		boolean rtnChk = false;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkgInetBlCtrlPtyVO != null) {
				Map<String, String> mapVO = bkgInetBlCtrlPtyVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOCheckInernettBlControlPartyRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0) {
				rtnChk = true;
			} else {
				rtnChk = false;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnChk;
	}	
	
	/**
	 * addBlGroup
	 * @param BkgCtrlPtyBlGrpVO bkgCtrlPtyBlGrpVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void addBlGroup(BkgCtrlPtyBlGrpVO bkgCtrlPtyBlGrpVO, SignOnUserAccount account) throws DAOException {
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgCtrlPtyBlGrpVO != null){
				mapVO = bkgCtrlPtyBlGrpVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cre_usr_id", account.getUsr_id());
				param.put("upd_usr_id", account.getUsr_id());
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOAddBlGroupCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert "+ " SQL");
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
	 * modifyBlGroup
	 * @param BkgCtrlPtyBlGrpVO bkgCtrlPtyBlGrpVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void modifyBlGroup(BkgCtrlPtyBlGrpVO bkgCtrlPtyBlGrpVO, SignOnUserAccount account) throws DAOException {
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgCtrlPtyBlGrpVO != null){
				mapVO = bkgCtrlPtyBlGrpVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOModifyBlGroupUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to update "+ " SQL");
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
	 * removeBlGroup
	 * @param BkgCtrlPtyBlGrpVO bkgCtrlPtyBlGrpVO
	 * @throws DAOException
	 */
	public void removeBlGroup(BkgCtrlPtyBlGrpVO bkgCtrlPtyBlGrpVO) throws DAOException {
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgCtrlPtyBlGrpVO != null){
				mapVO = bkgCtrlPtyBlGrpVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAORemoveBlGroupDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to remove "+ " SQL");
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
	 * checkBlGroup
	 * @param BkgCtrlPtyVO bkgCtrlPtyVO
	 * @throws DAOException
	 */
	public void checkBlGroup(BkgCtrlPtyVO bkgCtrlPtyVO) throws DAOException {
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgCtrlPtyVO != null){
				mapVO = bkgCtrlPtyVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAORemoveBlGroupDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to remove "+ " SQL");
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
	 * checkBlGroupName
	 * @param BkgCtrlBlGrpVO bkgCtrlBlGrpVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkBlGroupName(BkgCtrlBlGrpVO bkgCtrlBlGrpVO) throws DAOException {
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		boolean rtnChk = false;

		try{
			if(bkgCtrlBlGrpVO != null){
				mapVO = bkgCtrlBlGrpVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOCheckBlGroupNameRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0) {
				rtnChk = true;
			} else {
				rtnChk = false;
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnChk;
	}	
	
	/**
	 * select BKG_CTRL_BL_GRP List
	 * @param BkgCtrlBlGrpVO bkgCtrlBlGrpVO
	 * @return List<BkgCtrlBlGrpVO>
	 * @throws DAOException
	 */
	public List<BkgCtrlBlGrpVO> searchBlGroupMasterList(BkgCtrlBlGrpVO bkgCtrlBlGrpVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCtrlBlGrpVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgCtrlBlGrpVO != null){
				Map<String, String> mapVO = bkgCtrlBlGrpVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingMasterMgtDBDAOSearchBlGroupMasterListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCtrlBlGrpVO .class);
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
	 * select BKG_CTRL_BL_GRP_CUST List
	 * @param BkgCtrlBlGrpVO bkgCtrlBlGrpVO
	 * @return List<BkgCtrlBlGrpCustVO>
	 * @throws DAOException
	 */
	public List<BkgCtrlBlGrpCustVO> searchBlGroupCustomerList(BkgCtrlBlGrpVO bkgCtrlBlGrpVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCtrlBlGrpCustVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgCtrlBlGrpVO != null){
				Map<String, String> mapVO = bkgCtrlBlGrpVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingMasterMgtDBDAOSearchBlGroupCustomerListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCtrlBlGrpCustVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
///////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * selectMaxBlGroupSeq
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet selectMaxBlGroupSeq() throws DAOException {
		DBRowSet dbRowset = null; 
		Map<String, Object> param = new HashMap<String, Object>();//parameter	
		try {
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingMasterMgtDBDAOSelectMaxBlGroupSeqRSQL(), param, null);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());			
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);			
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return dbRowset;
	}	
	
	/**
	 * addBlGroupMaster
	 * @param BkgCtrlBlGrpVO bkgCtrlBlGrpVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void addBlGroupMaster(BkgCtrlBlGrpVO bkgCtrlBlGrpVO, SignOnUserAccount account) throws DAOException {
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgCtrlBlGrpVO != null){
				mapVO = bkgCtrlBlGrpVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cre_usr_id", account.getUsr_id());
				param.put("upd_usr_id", account.getUsr_id());
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOAddBlGroupMasterCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert No"+ " SQL");
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
	 * modifyBlGroupMaster
	 * @param BkgCtrlBlGrpVO bkgCtrlBlGrpVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void modifyBlGroupMaster(BkgCtrlBlGrpVO bkgCtrlBlGrpVO, SignOnUserAccount account) throws DAOException {
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgCtrlBlGrpVO != null){
				mapVO = bkgCtrlBlGrpVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOModifyBlGroupMasterUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to update "+ " SQL");
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
	 * removeBlGroupMaster
	 * @param BkgCtrlBlGrpVO bkgCtrlBlGrpVO
	 * @throws DAOException
	 */
	public void removeBlGroupMaster(BkgCtrlBlGrpVO bkgCtrlBlGrpVO) throws DAOException {
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgCtrlBlGrpVO != null){
				mapVO = bkgCtrlBlGrpVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAORemoveBlGroupMasterDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to remove "+ " SQL");
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
	 * addBlGroupCustomer
	 * @param BkgCtrlBlGrpCustVO bkgCtrlBlGrpCustVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void addBlGroupCustomer(BkgCtrlBlGrpCustVO bkgCtrlBlGrpCustVO, SignOnUserAccount account) throws DAOException {
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgCtrlBlGrpCustVO != null){
				mapVO = bkgCtrlBlGrpCustVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("cre_usr_id", account.getUsr_id());
				param.put("upd_usr_id", account.getUsr_id());
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOAddBlGroupCustomerCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert "+ " SQL");
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
	 * removeBlGroupCustomer
	 * @param BkgCtrlBlGrpCustVO bkgCtrlBlGrpCustVO
	 * @throws DAOException
	 */
	public void removeBlGroupCustomer(BkgCtrlBlGrpCustVO bkgCtrlBlGrpCustVO) throws DAOException {
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgCtrlBlGrpCustVO != null){
				mapVO = bkgCtrlBlGrpCustVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAORemoveBlGroupCustomerDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to remove "+ " SQL");
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
	 * removeBlGroupCustomerByBlGroupSeq
	 * @param BkgCtrlBlGrpVO bkgCtrlBlGrpVO
	 * @throws DAOException
	 */
	public void removeBlGroupCustomerByBlGroupSeq(BkgCtrlBlGrpVO bkgCtrlBlGrpVO) throws DAOException {
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgCtrlBlGrpVO != null){
				mapVO = bkgCtrlBlGrpVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAORemoveBlGroupCustomerByBlGroupSeqDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to remove "+ " SQL");
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
	 * E-BKG Handling Office 등록 화면-조회
	 * 화면 ESM_BKG_1180
	 * 
	 * @param BkgHandlingOfficeSetupVO bkgHandlingOfficeSetupVO
	 * @return List<BkgHandlingOfficeSetupVO>
	 * @throws DAOException
	 */
	public List<BkgHandlingOfficeSetupVO> searchHandlingOffice(BkgHandlingOfficeSetupVO bkgHandlingOfficeSetupVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgHandlingOfficeSetupVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgHandlingOfficeSetupVO != null){
				Map<String, String> mapVO = bkgHandlingOfficeSetupVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingMasterMgtDBDAOSearchHandlingOfficeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgHandlingOfficeSetupVO .class);
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
	 * E-BKG Handling Office 등록 화면- 생성<br>
	 * 화면 ESM_BKG_1180
	 * @param bkgHandlingOfficeSetupVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addHandlingOffice(BkgHandlingOfficeSetupVO bkgHandlingOfficeSetupVO) throws DAOException, Exception {
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = bkgHandlingOfficeSetupVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOAddHandlingOfficeCSQL(), param, velParam);
			if (updCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}

	/**
	 * E-BKG Handling Office 등록 화면- 수정<br>
	 * 화면 ESM_BKG_1180
	 * @param bkgHandlingOfficeSetupVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyHandlingOffice(BkgHandlingOfficeSetupVO bkgHandlingOfficeSetupVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOModifyHandlingOfficeUSQL(), bkgHandlingOfficeSetupVO.getColumnValues(), null);
			if (updCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * E-BKG Handling Office 등록 화면- 삭제<br>
	 * 화면 ESM_BKG_1180
	 * @param bkgHandlingOfficeSetupVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeHandlingOffice(BkgHandlingOfficeSetupVO bkgHandlingOfficeSetupVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAORemoveHandlingOfficeDSQL(), bkgHandlingOfficeSetupVO.getColumnValues(), null);
			if (updCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	

	/**
	  E-BKG Handling Office 등록 화면- 중복체크<br>
	 * 화면 ESM_BKG_1180
	 * @param bkgHandlingOfficeSetupVO
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public boolean checkHandlingOfficeDup(BkgHandlingOfficeSetupVO bkgHandlingOfficeSetupVO) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		boolean dupChk = false;
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO = bkgHandlingOfficeSetupVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOCheckHandlingOfficeDupRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 1) {// 2 Row 이상 존재
				dupChk = true;
				return dupChk;
			}
			
			param.clear();
			velParam.clear();
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return dupChk;
	}
	
	/**
	 * select Hard Coding Setup List
	 * @param HrdCdgDesc2VO hrdCdgDesc2VO
	 * @return List<HrdCdgDesc2VO>
	 * @throws DAOException
	 */
	public List<HrdCdgDesc2VO> searchHrdCdgDesc2(HrdCdgDesc2VO hrdCdgDesc2VO) throws DAOException {
		DBRowSet dbRowset = null;
		List<HrdCdgDesc2VO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(hrdCdgDesc2VO != null){
				Map<String, String> mapVO = hrdCdgDesc2VO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingMasterMgtDBDAOsearchHrdCdgDesc2RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, HrdCdgDesc2VO.class);
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
	 * select Hard Coding Contents List
	 * @param HrdCdgCtnt2VO hrdCdgCtnt2VO
	 * @return List<BkgHrdCdgCtntVO>
	 * @throws DAOException
	 */
	public List<HrdCdgCtnt2VO> searchHrdCdgCtnt2(HrdCdgCtnt2VO hrdCdgCtnt2VO) throws DAOException {
		DBRowSet dbRowset = null;
		List<HrdCdgCtnt2VO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(hrdCdgCtnt2VO != null){
				Map<String, String> mapVO = hrdCdgCtnt2VO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingMasterMgtDBDAOsearchHrdCdgCtnt2RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgHrdCdgCtntVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	/**Hard Coding Contents List Insert
	 * @param HrdCdgCtnt2VO hrdCdgCtnt2VO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void addHrdCdgCtnt2(HrdCdgCtnt2VO hrdCdgCtnt2VO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(hrdCdgCtnt2VO != null){
				mapVO = hrdCdgCtnt2VO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
				param.put("cre_usr_id", account.getUsr_id());
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOaddHrdCdgCtnt2CSQL(), param, velParam);
			log.debug("result "+result);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert No"+ " SQL");
			}
					
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**Hard Coding Contents List Delete.
	 * @param HrdCdgCtnt2VO hrdCdgCtnt2VO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void removeHrdCdgCtnt2(HrdCdgCtnt2VO hrdCdgCtnt2VO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(hrdCdgCtnt2VO != null){
				mapVO = hrdCdgCtnt2VO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOremoveHrdCdgCtnt2DSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert No"+ " SQL");
			}
					
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	/**Hard Coding Contents List Update
	 * @param HrdCdgCtnt2VO hrdCdgCtnt2VO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 */
	public void modifyHrdCdgCtnt2(HrdCdgCtnt2VO hrdCdgCtnt2VO, SignOnUserAccount account) throws DAOException {
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(hrdCdgCtnt2VO != null){
				mapVO = hrdCdgCtnt2VO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("upd_usr_id", account.getUsr_id());
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOmodifyHrdCdgCtnt2USQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to insert No"+ " SQL");
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
	 * checkEcomUsrInfoForBlGrp
	 * @param BkgCtrlBlGrpCustVO bkgCtrlBlGrpCustVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkEcomUsrInfoForBlGrp(BkgCtrlBlGrpCustVO bkgCtrlBlGrpCustVO) throws DAOException {
		boolean rtnChk = false;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkgCtrlBlGrpCustVO != null) {
				Map<String, String> mapVO = bkgCtrlBlGrpCustVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOcheckEcomUsrInfoForBlGrpRSQL(), param, velParam);
			if (dbRowset != null && dbRowset.getRowCount() > 0) {
				rtnChk = true;
			} else {
				rtnChk = false;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnChk;
	}
	
	/**
	 * HamoTrf Code 체크한다.(ESM_BKG_0607_C)<br>
	 * 
	 * @param BkgHamoTrfVO bkgHamoTrfVO
	 * @param String usrId
	 * @return String valFlg 
	 * @exception DAOException
	 */

	public String validateHamoTrfCode(BkgHamoTrfVO bkgHamoTrfVO,String usrId) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		Map<String, String> mapVO = null;
		
		String valFlg ="N";

		try {
				mapVO = bkgHamoTrfVO .getColumnValues();
				mapVO.put("usrId", usrId);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				SQLExecuter exec = new SQLExecuter("DEFAULT");
				BookingMasterMgtDBDAOSearchVaildHamTrfCdRSQL template = new BookingMasterMgtDBDAOSearchVaildHamTrfCdRSQL();
	            dbRowset = exec.executeQuery(template, param, velParam);
	            if(dbRowset.next()){
	            	valFlg = dbRowset.getString(1);
	            }
	        } catch(SQLException ex) {
	            // log.error(se.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        } catch(Exception ex) {
	            // log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return valFlg;
	}
	
	/**
	 * HamoTrf Code 체크한다.(ESM_BKG_0607_C)<br>
	 * 
	 * @param BkgHamoTrfVO bkgHamoTrfVO
	 * @param String usrId
	 * @return String valFlg
	 * @exception DAOException
	 */
	
	public String validateHtsCode(BkgHamoTrfVO bkgHamoTrfVO,String usrId) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		Map<String, String> mapVO = null;
		
		String valFlg ="N";

		try {
				mapVO = bkgHamoTrfVO .getColumnValues();
				mapVO.put("usrId", usrId);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				SQLExecuter exec = new SQLExecuter("DEFAULT");
				BookingMasterMgtDBDAOSearchVaildHsCdRSQL template = new BookingMasterMgtDBDAOSearchVaildHsCdRSQL();
	            dbRowset = exec.executeQuery(template, param, velParam);
	            if(dbRowset.next()){
	            	valFlg = dbRowset.getString(1);
	            }
	        } catch(SQLException ex) {
	            // log.error(se.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        } catch(Exception ex) {
	            // log.error(ex.getMessage(), ex);
	            throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
	        }
	        return valFlg;
	}
}