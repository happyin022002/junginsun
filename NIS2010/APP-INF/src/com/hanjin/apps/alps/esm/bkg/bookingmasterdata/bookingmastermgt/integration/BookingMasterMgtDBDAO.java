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
 * 2011.01.20 전성진 [CHM-201007855] EDI Setup 삭제 I/F 추가
 * 2011.10.21 조원주 [CHM-201113594-01] DPCS-SI Turn Time레포트 및 Draft B/L전송후 Amendment S/I PIC변경관련 Doc Center Office Hour 개발
 * 2012.08.08 조정민 [CHM-201218814] Booking Receipt Notice - VVD name change 기능
 * 2013.03.25 김태경 [CHM-20132554] Vessel Schedule  Inquiry 조회 보완 요청 - Multi Lane 클릭시 복수의 Lane 을 선택 할수 있도록 보완
 * 2014.04.01 신규정 [CHM-201429292 ]  Manual BDR 권한 설정 메뉴 신규 개발
 * 2014.06.10 문동선 [CHM-201430335] 미주 bkg handling office 지정을 위한 set up 메뉴 추가
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BdrAccessAuthorityInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgChinaAgentVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCstmsChnAgnCdVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCustTmpltVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgDpcsOfcTmVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEdiGrpCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEdiGrpVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEdiPrnrPortLaneVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEdiSubLnkMsgVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEdiTrdPrnrSubLnkVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgEqlzPortVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgHandlingOfficeSetupVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgHrdCdgDescVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgMapgVvdVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgMdtItmVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVgmClzSetListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVgmClzSetVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgdocClzSetListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgdocClzSetVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ChnMnlBkgNoGenCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.CustSlsRepVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.MandatoryItemSetupListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.RestrictCmdtDupListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.RestrictCmdtFileVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.RestrictCmdtListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRPolVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRTimeTableVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchBDRTimeVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchCmdtCdRepCmdtCdVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchInBoundCustListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.SearchWareHouseVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.VskVslPortSkdConditionVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ZipCdListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.ZipCdSchVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgTsCoffTmVO;
import com.hanjin.bizcommon.comm.Constants;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgChnBkgNoGenVO;
import com.hanjin.syscommon.common.table.BkgCoffTmVO;
import com.hanjin.syscommon.common.table.BkgCstmsChnAgnStupVO;
import com.hanjin.syscommon.common.table.BkgCustCntcPsonVO;
import com.hanjin.syscommon.common.table.BkgDpcsUsrGrpVO;
import com.hanjin.syscommon.common.table.BkgHamoTrfVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgImpImgStoVO;
import com.hanjin.syscommon.common.table.BkgMTPickupCYVO;
import com.hanjin.syscommon.common.table.MdmCountryVO;
import com.hanjin.syscommon.common.table.MdmPckTpVO;

/**
 * NIS2010 BookingMasterMgtDBDAO <br>
 * - NIS2010-BookingMasterData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
	 * @param int iPage
	 * @return List<BkgHamoTrfVO>
	 * @exception DAOException
	 */

	@SuppressWarnings("unchecked")
	public List<BkgHamoTrfVO> searchHTSCode(BkgHamoTrfVO hamTarCodeVO, int iPage) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgHamoTrfVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
    	int currentPage = iPage;
   		int startPart   = Constants.PAGE_SIZE_5000 * (currentPage - 1) + 1;
   		int endPart     = Constants.PAGE_SIZE_5000 * currentPage;
   		
		try {
			Map<String, String> mapVO = hamTarCodeVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
	        velParam.put("ipage", currentPage);
	        param.put("startpart", startPart);
	        param.put("endpart", endPart);
	        
	        dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOBkgHamoTrfCntVORSQLRSQL(), param, velParam);
	        int cnt = 0;
	        if (dbRowset.next()) {
				cnt = dbRowset.getInt(1);
			}
	        
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOBkgHamoTrfVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgHamoTrfVO.class);
			if (cnt > 0)
				list.get(0).setMaxRows(cnt);  

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
			// Multi Combo 를 위해 추가

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
	 * WDPCS - S/R 업무처리 담당자 Group 정보를 Searchg한다.(ESM_BKG_0592)<br>
	 * 
	 * @param String usrId
	 * @param String dpcsWrkGrpCd
	 * @param BkgDpcsUsrGrpVO vo
	 * @return List<BkgDpcsUsrGrpVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgDpcsUsrGrpVO> searchDPCSUserGroup(String usrId,String dpcsWrkGrpCd, BkgDpcsUsrGrpVO vo) throws DAOException {
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
				param.put("dpcs_wrk_grp_cd", dpcsWrkGrpCd);
				
				velParam.put("usr_id", usrId);
				velParam.put("dpcs_wrk_grp_cd", dpcsWrkGrpCd);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOSearchDPSCUserGroupRSQL(), param, velParam);
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
	 * DPCS - S/R 업무처리 담당자 Group 정보 생성함.(ESM_BKG_0592)<br>
	 * 
	 * @param BkgDpcsUsrGrpVO vo
	 * @return int
	 * @throws DAOException
	 */
	public int addDPSCUserGroup(BkgDpcsUsrGrpVO vo) throws DAOException, Exception {
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
			result = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOSearchDPSCUserGroupCSQL(), param, velParam);

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
	 * DPCS - S/R 업무처리 담당자 Group 정보 수정함. (ESM_BKG_0592)<br>
	 * 
	 * @param BkgDpcsUsrGrpVO bkgDpcsUsrGrpVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyDPSCUserGroup(BkgDpcsUsrGrpVO bkgDpcsUsrGrpVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (bkgDpcsUsrGrpVO != null) {
				Map<String, String> mapVO = bkgDpcsUsrGrpVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			result = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOSearchDPSCUserGroupUSQL(), param, velParam);

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
	 * 다건의 CUser Group 데이터를 일괄적으로 삭제한다.(ESM_BKG_0592)<br>
	 * User Group Creation </br>
	 * 
	 * @param BkgDpcsUsrGrpVO bkgDpcsUsrGrpVO
	 * @throws DAOException
	 */
	public void removeDPSCUserGroup(BkgDpcsUsrGrpVO bkgDpcsUsrGrpVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (bkgDpcsUsrGrpVO != null) {
				Map<String, String> mapVO = bkgDpcsUsrGrpVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOSearchDPSCUserGroupDSQL(), param, velParam);

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
	 * Bkg_Coff_Tm 테이블 저장 전 중복 조회<br>
	 * 
	 * @param BkgCoffTmVO bkgCoffTmVO
	 * @return String
	 * @exception DAOException
	 * @exception Exception
	 */
	public String searchBkgCoffTmDup(BkgCoffTmVO bkgCoffTmVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		String dupFlg = "N";
		try {
			if (bkgCoffTmVO != null) {
				Map<String, String> mapVO = bkgCoffTmVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOSearchBkgCoffTmDupRSQL(), param, velParam);
			while (dbRowset.next()) {
				dupFlg = "Y";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return dupFlg;
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
	 * 
	 * @param String ydCd
	 * @param String vslSlanCd
	 * @return List<BkgdocClzSetListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgdocClzSetListVO> searchDocCutOffTimeList(String ydCd, String vslSlanCd) throws DAOException {

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
			mapVO.put("chk_op", "Y");

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
		List<BkgdocClzSetListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
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
			if ( list != null && list.size() > 0) {
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
				
				if (vo.getItmCdInc().equals("1")) {

					vo.setBkgMdtItmCd("MSL");

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
				
				if (vo.getItmCdMsl().equals("1")) {

					vo.setBkgMdtItmCd("MSL");

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
//			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgMdtItmVO.class);
         
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
//				bkgMdtItmVO.setBlIssNote(dbRowset.getString("BL_ISS_NOTE"));
				bkgMdtItmVO.setBlIssNoteCtnt(dbRowset.getString("BL_ISS_NOTE_CTNT"));
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
				bkgMdtItmVO.setItmNmMsl(dbRowset.getString("ITM_NM_MSL"));
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
					} else if (temp[j].equals("MSL")) {

						bkgMdtItmVO.setItmCdMsl("1");
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
	 * BKG_EDI_TRD_PRNR_SUB_LNK TABLE DELETE  <br>
	 * 
	 * @param BkgEdiTrdPrnrSubLnkVO vo
	 * @throws DAOException
	 */
	public void removeBkgEdiTrdPrnrSubLnk(BkgEdiTrdPrnrSubLnkVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (null != vo) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOremoveBkgEdiTrdPrnrSubLnkDSQL(), param, velParam);
			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
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
	 * BKG_EDI_SUB_LNK_MSG TABLE DELETE <br>
	 * 
	 * @param BkgEdiSubLnkMsgVO vo
	 * @throws DAOException
	 */
	public void removeBkgEdiSubLnkMsg(BkgEdiSubLnkMsgVO vo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (null != vo) {
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOremoveBkgEdiSubLnkMsgDSQL(), param, velParam);
			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
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
	 * @param int iPage
	 * @return List<ZipCdListVO>
	 * @throws DAOException
	 */
	public List<ZipCdListVO> searchZipCode(ZipCdSchVO vo, int iPage) throws DAOException {
		DBRowSet dbRowset = null;
		List<ZipCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int currentPage = iPage;
   		int startPart   = Constants.PAGE_SIZE_5000 * (currentPage - 1) + 1;
   		int endPart     = Constants.PAGE_SIZE_5000 * currentPage;

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				    velParam.put("ipage", currentPage);
			        param.put("startpart", startPart);
			        param.put("endpart", endPart);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOBkgZipCdCntVORSQL(), param, velParam);
	        int cnt = 0;
	        if (dbRowset.next()) {
				cnt = dbRowset.getInt(1);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOBkgZipCdVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ZipCdListVO.class);
			if (cnt > 0)
				list.get(0).setMaxRows(cnt);  

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
	 * [ESM_BKG_9456] Chinese Agent Set-up 화면-combo list조회<br>
	 * @param BkgCstmsChnAgnCdVO vo
	 * @return List<BkgCstmsChnAgnCdVO>
	 * @throws DAOException
	 */
	public List<BkgCstmsChnAgnCdVO> searchCstmsChnAgnCdList(BkgCstmsChnAgnCdVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCstmsChnAgnCdVO> list = null;
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
			// 우선은 전체조회되도록 함.
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOSearchChnCstmsAgnListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsChnAgnCdVO.class);

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
	 * [ESM_BKG_9456] Chinese Agent Set-up 화면조회<br>
	 * @param BkgCstmsChnAgnCdVO vo
	 * @return List<BkgCstmsChnAgnStupVO>
	 * @throws DAOException
	 */
	public List<BkgCstmsChnAgnStupVO> searchCstmsChnAgnStup(BkgCstmsChnAgnCdVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCstmsChnAgnStupVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOSearchChnCstmsAgnRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgCstmsChnAgnStupVO.class);

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
	 * [ESM_BKG_9456] Chinese Agent Set-up 입력, 수정<br>
	 * @param BkgCstmsChnAgnStupVO bkgCstmsChnAgnStupVO
	 * @throws DAOException
	 * @author KIM HYUN HWA
	 */
	public void addCstmsChnAgnStup(BkgCstmsChnAgnStupVO bkgCstmsChnAgnStupVO) throws DAOException {
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try 
		{
		Map<String, String> mapVO = bkgCstmsChnAgnStupVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOAddChnCstmsAgnCSQL(), param, velParam);

		} catch (SQLException se) {
			//log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	/**
	 * [ESM_BKG_9456] Chinese Agent Set-up 수정<br>
	 * @param BkgCstmsChnAgnStupVO bkgCstmsChnAgnStupVO
	 * @throws DAOException
	 * @author KIM HYUN HWA
	 */
	public void modifyCstmsChnAgnStup(BkgCstmsChnAgnStupVO bkgCstmsChnAgnStupVO) throws DAOException, Exception {

		Map<String, Object> param = new HashMap<String, Object>();

		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (bkgCstmsChnAgnStupVO != null) {
				Map<String, String> mapVO = bkgCstmsChnAgnStupVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOModifyChnCstmsAgnUSQL(), param, velParam);

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
	 * [ESM_BKG_9456] Chinese Agent Set-up 삭제<br>
	 * @param BkgCstmsChnAgnStupVO bkgCstmsChnAgnStupVO
	 * @throws DAOException
	 * @author KIM HYUN HWA
	 */
	public void removeCstmsChnAgnStup(BkgCstmsChnAgnStupVO bkgCstmsChnAgnStupVO) throws DAOException, Exception {

		Map<String, Object> param = new HashMap<String, Object>();

		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (bkgCstmsChnAgnStupVO != null) {
				Map<String, String> mapVO = bkgCstmsChnAgnStupVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAORemoveChnCstmsAgnDSQL(), param, velParam);

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
	 * DPCS - Office 별 시간을 조회 한다.(ESM_BKG_0441)<br>
	 * 
	 * @param BkgDpcsOfcTmVO vo
	 * @return List<BkgDpcsOfcTmVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgDpcsOfcTmVO> searchDpcsOfcTm(BkgDpcsOfcTmVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgDpcsOfcTmVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOSearchDpcsOfcTmRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgDpcsOfcTmVO.class);

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
	 * DPCS - Office 별 시간을 저장한다..(ESM_BKG_0441)<br>
	 * 
	 * @param BkgDpcsOfcTmVO vo
	 * @throws DAOException
	 */
	public void addDpcsOfcTm(BkgDpcsOfcTmVO vo) throws DAOException, Exception {
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
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOaddDpcsOfcTmCSQL(), param, velParam);

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
	 * DPCS - Office 별 시간을 수정한다.(ESM_BKG_0441)<br>
	 * 
	 * @param BkgDpcsOfcTmVO bkgDpcsOfcTmVO
	 * @throws DAOException
	 */
	public void modifyDpcsOfcTm(BkgDpcsOfcTmVO bkgDpcsOfcTmVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (bkgDpcsOfcTmVO != null) {
				Map<String, String> mapVO = bkgDpcsOfcTmVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOmodifyDpcsOfcTmUSQL(), param, velParam);

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
	 * DPCS - Office 별 시간을 삭제한다.(ESM_BKG_0441)<br>
	 * 
	 * @param BkgDpcsOfcTmVO bkgDpcsOfcTmVO
	 * @throws DAOException
	 */
	public void removeDpcsOfcTm(BkgDpcsOfcTmVO bkgDpcsOfcTmVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (bkgDpcsOfcTmVO != null) {
				Map<String, String> mapVO = bkgDpcsOfcTmVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAORemoveDpcsOfcTmDSQL(), param, velParam);

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
	 * [ESM_BKG_1130] Import Restricted Commodities Set-up 화면조회<br>
	 * @param RestrictCmdtListVO vo
	 * @return List<RestrictCmdtListVO>
	 * @throws DAOException
	 */
	public List<RestrictCmdtListVO> searchRestrictCmdtList(RestrictCmdtListVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RestrictCmdtListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				String tmpCd = vo.getLocCd();
				String cntCd = "";
				String locCd = "";
				
				// 2자리 이면 Country Code로  설정
				if(tmpCd.length() == 2){
					cntCd = tmpCd;
				// 3자리 이상이면 Location Code로 설정
				} else {
					locCd = tmpCd;
				}
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("cnt_cd", cntCd);
				param.put("loc_cd", locCd);
				velParam.put("cnt_cd", cntCd);
				velParam.put("loc_cd", locCd);

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOSearchRestrictCmdtListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RestrictCmdtListVO.class);

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
	 * [ESM_BKG_1130] Import Restricted Commodities Set-up 화면수정<br>
	 * INSERT
	 * 
	 * @param RestrictCmdtListVO restrictCmdtListVO
	 * @throws DAOException
	 * @author Lee InYoung
	 */
	public void addRestrictCmdt(RestrictCmdtListVO restrictCmdtListVO) throws DAOException {
		int result = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try 
		{
		Map<String, String> mapVO = restrictCmdtListVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOAddRestrictCmdtCSQL(), param, velParam);

		} catch (SQLException se) {
			//log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			//log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * [ESM_BKG_1130] Import Restricted Commodities Set-up 화면수정<br>
	 * UPDATE
	 * 
	 * @param RestrictCmdtListVO restrictCmdtListVO
	 * @throws DAOException
	 * @author Lee InYoung
	 */
	public void modifyRestrictCmdt(RestrictCmdtListVO restrictCmdtListVO) throws DAOException, Exception {

		Map<String, Object> param = new HashMap<String, Object>();

		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (restrictCmdtListVO != null) {
				Map<String, String> mapVO = restrictCmdtListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOModifyRestrictCmdtUSQL(), param, velParam);

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
	 * [ESM_BKG_1130] Import Restricted Commodities Set-up 화면수정<br>
	 * DELETE
	 * 
	 * @param RestrictCmdtListVO restrictCmdtListVO
	 * @throws DAOException
	 * @author Lee InYoung
	 */
	public void removeRestrictCmdt(RestrictCmdtListVO restrictCmdtListVO) throws DAOException, Exception {

		Map<String, Object> param = new HashMap<String, Object>();

		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (restrictCmdtListVO != null) {
				Map<String, String> mapVO = restrictCmdtListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAORemoveRestrictCmdtDSQL(), param, velParam);

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
	 * [ESM_BKG_1131] Import Restricted Commodities File Upload 화면<br>
	 * @param RestrictCmdtFileVO vo
	 * @return List<BkgImpImgStoVO>
	 * @throws DAOException
	 */
	public List<BkgImpImgStoVO> searchRestrictCmdtFile(RestrictCmdtFileVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgImpImgStoVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOSearchRestrictCmdtFileRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgImpImgStoVO.class);

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
	 * [ESM_BKG_1131] Import Restricted Commodities File Upload 화면<br>
	 * DELETE
	 * 
	 * @param List<BkgImpImgStoVO> listVO
	 * @return int
	 * @throws DAOException
	 * @author Lee InYoung
	 */
	public int removeRestrictCmdtFile(List<BkgImpImgStoVO>  listVO) throws DAOException,Exception {
		SQLExecuter sqlExe = new SQLExecuter("");
       int size = listVO.size();
		int insCnt = 0;

       try {

	        if(size > 0) {
	    		//query parameter
	    		Map<String, Object> param = new HashMap<String, Object>();
	    		//velocity parameter
	    		Map<String, Object> velParam = new HashMap<String, Object>();
	        	Iterator<BkgImpImgStoVO> list = listVO.iterator();
	        	while(list.hasNext()){
	        		BkgImpImgStoVO bkgImpImgStoVO = (BkgImpImgStoVO)list.next();
					Map<String, String> mapVO = bkgImpImgStoVO .getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
	    			insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAORemoveRestrictCmdtFileDSQL(), param,velParam);
	    			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
	        	}
	        }

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	
	/**
	 * [ESM_BKG_1131] Import Restricted Commodities File Upload 화면<br>
	 * INSERT
	 * 
	 * @param List<BkgImpImgStoVO> listVO
	 * @return int
	 * @throws DAOException
	 * @author Lee InYoung
	 */
	public int addRestrictCmdtFile(List<BkgImpImgStoVO> listVO) throws DAOException,Exception {
		SQLExecuter sqlExe = new SQLExecuter("");
       int size = listVO.size();
		int insCnt = 0;

       try {

	        if(size > 0) {
	    		//query parameter
	    		Map<String, Object> param = new HashMap<String, Object>();
	    		//velocity parameter
	    		Map<String, Object> velParam = new HashMap<String, Object>();
	        	Iterator<BkgImpImgStoVO> list = listVO.iterator();
	        	while(list.hasNext()){
	        		BkgImpImgStoVO bkgImpImgStoVO = (BkgImpImgStoVO)list.next();
					Map<String, String> mapVO = bkgImpImgStoVO .getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
	    			insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOAddRestrictCmdtFileCSQL(), param,velParam);
	    			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
				}
	        }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	
	/**
	 * [ESM_BKG_1131] Import Restricted Commodities File Upload 화면<br>
	 * UPDATE
	 * 
	 * @param List<BkgImpImgStoVO> listVO
	 * @return int
	 * @throws DAOException
	 * @author Lee InYoung
	 */
	public int modifyRestrictCmdtFile(List<BkgImpImgStoVO> listVO) throws DAOException,Exception {
		SQLExecuter sqlExe = new SQLExecuter("");
       int size = listVO.size();
		int insCnt = 0;

       try {

	        if(size > 0) {
	    		//query parameter
	    		Map<String, Object> param = new HashMap<String, Object>();
	    		//velocity parameter
	    		Map<String, Object> velParam = new HashMap<String, Object>();
	        	Iterator<BkgImpImgStoVO> list = listVO.iterator();
	        	while(list.hasNext()){
	        		BkgImpImgStoVO bkgImpImgStoVO = (BkgImpImgStoVO)list.next();
					Map<String, String> mapVO = bkgImpImgStoVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
	    			insCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOModifyRestrictCmdtFileUSQL(), param,velParam);
	    			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
	        	}
	        }

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	

	/**
	 * [ESM_BKG_1130] Import Restricted Commodities Set-Up에서 등록 항목이 중복되는지 체크<br>
	 * @param RestrictCmdtListVO vo
	 * @return List<RestrictCmdtDupListVO>
	 * @throws DAOException
	 */
	public List<RestrictCmdtDupListVO> searchRestrictCmdtDupList(RestrictCmdtListVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<RestrictCmdtDupListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOsearchRestrictCmdtDupListRSQL(), param, velParam);
			
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, RestrictCmdtDupListVO.class);
			
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
	 * Edit VVD 화면 조회.(ESM_BKG_1150)<br>
	 * TABLE - BKG_MAPG_VVD<br>
	 * @param BkgMapgVvdVO bkgMapgVvdVO
	 * @return List<BkgMapgVvdVO>
	 * @throws DAOException
	 */
	public List<BkgMapgVvdVO> searchMapgVvd(BkgMapgVvdVO bkgMapgVvdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgMapgVvdVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bkgMapgVvdVO != null){
				Map<String, String> mapVO = bkgMapgVvdVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingMasterMgtDBDAOsearchMapgVvdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgMapgVvdVO .class);
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
	 * Edit VVD 화면 데이터 생성.(ESM_BKG_1150)<br>
	 * TABLE - BKG_MAPG_VVD<br>
	 * @param BkgMapgVvdVO bkgMapgVvdVO
	 * @throws DAOException
	 */
	public void addMapgVvd(BkgMapgVvdVO bkgMapgVvdVO) throws DAOException 
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgMapgVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOaddMapgVvdCSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	/**
	 * Edit VVD 화면 데이터 수정.(ESM_BKG_1150)<br>
	 * TABLE - BKG_MAPG_VVD<br>
	 * @param BkgMapgVvdVO bkgMapgVvdVO
	 * @throws DAOException
	 */
	public void modifyMapgVvd(BkgMapgVvdVO bkgMapgVvdVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgMapgVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOmodifyMapgVvdUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	/**
	 * Edit VVD 화면 데이터 삭제.(ESM_BKG_1150)<br>
	 * TABLE - BKG_MAPG_VVD<br>
	 * @param BkgMapgVvdVO bkgMapgVvdVO
	 * @throws DAOException
	 */
	public void deleteMapgVvd(BkgMapgVvdVO bkgMapgVvdVO) throws DAOException
	{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try
		{
			Map<String, String> mapVO = bkgMapgVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOdeleteMapgVvdDSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}

	/**
	 * select Hard Coding Setup List
	 * @param bkgHrdCdgDescVO
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
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int creCnt = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOaddHrdCdgDescCSQL(), param, velParam);
			if(creCnt == Statement.EXECUTE_FAILED){
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
				throw new DAOException("Fail to modify No"+ " SQL");
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
	 * Bkg_Ts_Coff_Tm테이블 저장<br>
	 * 
	 * @param BkgTsCoffTmVO bkgTsCoffTmVO
	 * @exception DAOException
	 */
	public void addBkgTsCoffTm(BkgTsCoffTmVO bkgTsCoffTmVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (bkgTsCoffTmVO != null) {
				Map<String, String> mapVO = bkgTsCoffTmVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOaddBkgTsCoffTmCSQL(), param, velParam);

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
	 * Bkg_Ts_Coff_Tm테이블 수정<br>
	 * 
	 * @param BkgTsCoffTmVO bkgTsCoffTmVO
	 * @exception DAOException
	 */
	public void modifyBkgTsCoffTm(BkgTsCoffTmVO bkgTsCoffTmVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (bkgTsCoffTmVO != null) {
				Map<String, String> mapVO = bkgTsCoffTmVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int updCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOmodifyBkgTsCoffTmUSQL(), param, velParam);

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
	 * select BdrAccessAuthority List
	 * @param BdrAccessAuthorityInfoVO bdrAccessAuthorityInfoVO
	 * @return List<BdrAccessAuthorityInfoVO>
	 * @throws DAOException
	 */
	public List<BdrAccessAuthorityInfoVO> searchBdrAccessAuthority(BdrAccessAuthorityInfoVO bdrAccessAuthorityInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BdrAccessAuthorityInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bdrAccessAuthorityInfoVO != null){
				Map<String, String> mapVO = bdrAccessAuthorityInfoVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BookingMasterMgtDBDAOsearchBdrAccessAuthorityRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BdrAccessAuthorityInfoVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**BDR AccessAuthorityInfo List Insert
	 * @param BdrAccessAuthorityInfoVO bdrAccessAuthorityInfoVO
	 * @throws DAOException
	 */
	public void addBdrAccessAuthority(BdrAccessAuthorityInfoVO bdrAccessAuthorityInfoVO) throws DAOException {
		//query parameter
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bdrAccessAuthorityInfoVO != null){
				mapVO = bdrAccessAuthorityInfoVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOaddBdrAccessAuthorityCSQL(), param, velParam);
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
	/** BDR AccessAuthorityInfo List Delete.
	 * @param BdrAccessAuthorityInfoVO bdrAccessAuthorityInfoVO
	 * @throws DAOException
	 */
	public void deleteBdrAccessAuthority(BdrAccessAuthorityInfoVO bdrAccessAuthorityInfoVO) throws DAOException {
		//query parameter
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bdrAccessAuthorityInfoVO != null){
				mapVO = bdrAccessAuthorityInfoVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOdeleteBdrAccessAuthorityUSQL(), param, velParam);
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
	/**BDR AccessAuthorityInfo List Update
	 * @param BdrAccessAuthorityInfoVO bdrAccessAuthorityInfoVO
	 * @throws DAOException
	 */
	public void modifyBdrAccessAuthority(BdrAccessAuthorityInfoVO bdrAccessAuthorityInfoVO) throws DAOException {
		Map<String, String> mapVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(bdrAccessAuthorityInfoVO != null){
				mapVO = bdrAccessAuthorityInfoVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingMasterMgtDBDAOmodifyBdrAccessAuthorityUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED){
				throw new DAOException("Fail to modify No"+ " SQL");
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
     * 
	 * @param List<BkgHandlingOfficeSetupVO> bkgHandlingOfficeSetupVO
	 * @throws DAOException
	 */
	public void addHandlingOffice(List<BkgHandlingOfficeSetupVO> bkgHandlingOfficeSetupVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (bkgHandlingOfficeSetupVO.size() > 0) {

					// query parameter
					Map<String, Object> param = new HashMap<String, Object>();
					// velocity parameter
					Map<String, Object> velParam = new HashMap<String, Object>();

					int result = 0;
					for (int i = 0; i < bkgHandlingOfficeSetupVO.size(); i++) {
						if (bkgHandlingOfficeSetupVO.get(i) != null) {
							Map<String, String> mapVO = bkgHandlingOfficeSetupVO.get(i).getColumnValues();

							param.putAll(mapVO);
							velParam.putAll(mapVO);
						}
						result = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOAddHandlingOfficeCSQL(), param, velParam);
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
	 * E-BKG Handling Office 등록 화면- 수정<br>
	 * 화면 ESM_BKG_1180
     * 
	 * @param List<BkgHandlingOfficeSetupVO> bkgHandlingOfficeSetupVO
	 * @throws DAOException
	 */
	public void modifyHandlingOffice(List<BkgHandlingOfficeSetupVO> bkgHandlingOfficeSetupVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgHandlingOfficeSetupVO.size() > 0) {
					updCnt = sqlExe.executeBatch((ISQLTemplate) new BookingMasterMgtDBDAOModifyHandlingOfficeUSQL(), bkgHandlingOfficeSetupVO, null);
					
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
	 * E-BKG Handling Office 등록 화면- 삭제<br>
	 * 화면 ESM_BKG_1180
     * 
	 * @param List<BkgHandlingOfficeSetupVO> bkgHandlingOfficeSetupVO
	 * @throws DAOException
	 */
	public void removeHandlingOffice(List<BkgHandlingOfficeSetupVO> bkgHandlingOfficeSetupVO) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (bkgHandlingOfficeSetupVO.size() > 0) {
					updCnt = sqlExe.executeBatch((ISQLTemplate) new BookingMasterMgtDBDAORemoveHandlingOfficeDSQL(), bkgHandlingOfficeSetupVO, null);

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
	 * E-BKG Handling Office 등록 화면- 중복체크<br>
	 * 화면 ESM_BKG_1180
     * 
	 * @param List<BkgHandlingOfficeSetupVO> bkgHandlingOfficeSetupVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkHandlingOfficeDup(List<BkgHandlingOfficeSetupVO> bkgHandlingOfficeSetupVO) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		boolean dupChk = false;
		try {
			if (bkgHandlingOfficeSetupVO.size() > 0) {
				// query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				// velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				for (int i = 0; i < bkgHandlingOfficeSetupVO.size(); i++) {
					if (bkgHandlingOfficeSetupVO.get(i) != null) {
						Map<String, String> mapVO = bkgHandlingOfficeSetupVO.get(i).getColumnValues();

						param.putAll(mapVO);
						velParam.putAll(mapVO);
					}

					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOCheckHandlingOfficeDupRSQL(), param, velParam);
					if (dbRowset != null && dbRowset.getRowCount() > 1) {// 2 Row 이상 존재
						dupChk = true;
						return dupChk;
					}
					
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
		return dupChk;
	}
	
	
	/**
	 * Documentation Cut-off Time을 수정합니다. <br>
	 * 
	 * @param BkgdocClzSetVO vo
	 * @throws DAOException
	 */
	public void updateDocCutOffTimeByVvd(BkgdocClzSetVO vo) throws DAOException {

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
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOUpdateDocCutOffTimeByVvdUSQL(), param, velParam);

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * BKG_VRFD_WGT_SET TABLE 조회 <br>
	 * 
	 * @param String locCd
	 * @param String vslSlanCd
	 * @return List<BkgVGMClzSetListVO>
	 * @exception DAOException
	 */
	
	@SuppressWarnings("unchecked")
	public List<BkgVgmClzSetListVO> searchVgmCutOffTimeList(String locCd, String vslSlanCd) throws DAOException {

		DBRowSet dbRowset = null;
		List<BkgVgmClzSetListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap();
			mapVO.put("loc_cd", locCd);
			mapVO.put("vsl_slan_cd", vslSlanCd);
			mapVO.put("chk_op", "Y");

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOBkgVGMClzSetListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgVgmClzSetListVO.class);

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * VGM Cut-off Time을 입력합니다.<br>
	 * 
	 * @param BkgVgmClzSetVO vo
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public void addVgmCutOffTime(BkgVgmClzSetVO vo) throws DAOException {

		DBRowSet dbRowset = null;
		List<BkgVgmClzSetListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (vo != null) {
				Map<String, String> mapVO = vo.getColumnValues();

				mapVO.put("chk_op", "N");

				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new BookingMasterMgtDBDAOBkgVGMClzSetListVORSQL(), param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgVgmClzSetListVO.class);
			}
			SQLExecuter sqlExe = new SQLExecuter("DEFAULT");
			int delCnt = 0;

			// DELT_FLG 가 Y 되어있는 기존 정보가 있을 경우 N으로 변경하고 UPDATE한다.
			if ( list != null && list.size() > 0) {
				delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOBkgVgmClzSetVOUSQL(), param, velParam);
			} else {
				delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOBkgVgmClzSetVOCSQL(), param, velParam);
			}

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * VGM Cut-off Time을 수정합니다. <br>
	 * 
	 * @param BkgVgmClzSetVO vo
	 * @throws DAOException
	 */
	public void modifyVgmCutOffTime(BkgVgmClzSetVO vo) throws DAOException {

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
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOBkgVgmClzSetVOUSQL(), param, velParam);

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	/**
	 * VGM Cut-off Time을 삭제합니다.<br>
	 * 
	 * @param BkgVgmClzSetVO vo
	 * @throws DAOException
	 */
	public void removeVgmCutOffTime(BkgVgmClzSetVO vo) throws DAOException {

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
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOBkgVgmClzSetVODSQL(), param, velParam);

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * VGM Cut-off Time을 수정합니다. <br>
	 * 
	 * @param BkgVgmClzSetVO vo
	 * @throws DAOException
	 */  
	public void updateVgmCutOffTimeByVvd(BkgVgmClzSetVO vo) throws DAOException {

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
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingMasterMgtDBDAOUpdateVgmCutOffTimeByVvdUSQL(), param, velParam);

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());

		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
}