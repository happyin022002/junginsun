/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLInformationMgtDBDAO.java
*@FileTitle : C/A Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 강동윤
*@LastVersion : 1.0
* 2010.01.14 강동윤
* 1.0 Creation
* History
* 2012.08.22 김기택 [CHM-201219155-01j] B/L Preview 기능 추가 
=========================================================*/
package com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.basic.BLInformationMgtBCImpl;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.BisBlNoVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.BisManualListVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.BisMonitorListVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.CaBkgInfoVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.CaChargeVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.CaCustVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.CaGeneralVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.CaListByBkgVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.CaSummaryReportInVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.CaSummaryReportOutVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.GrpBlPrtInVO;
import com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.vo.GrpBlPrtVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS BLInformationMgtDBDAO <br>
 * - ALPS-BLInformationMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author kang dong yun
 * @see BLInformationMgtBCImpl 참조
 * @since J2EE 1.6
 */
public class BLInformationMgtDBDAO extends DBDAOSupport {

	
	 /**
	  * C/A Summary Report 결과를 조회한다.<br>
	  * 
	  * @param  CaSummaryReportInVO vo
	  * @return List<CaSummaryReportOutVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CaSummaryReportOutVO> searchCaSummaryReport(CaSummaryReportInVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CaSummaryReportOutVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param    = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 

			 dbRowset = new SQLExecuter("BIS_HJSBAT").executeQuery((ISQLTemplate)new BLInformationMgtDBDAOCaSummaryReportOutVORSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaSummaryReportOutVO.class);
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	 } 
	 
	 /**
	  * C/A Summary Report BL List 결과를 조회한다.<br>
	  * 
	  * @param  CaSummaryReportInVO vo
	  * @return List<CaSummaryReportOutVO>
	  * @exception  DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CaSummaryReportOutVO> searchCaSummaryReportBLList(CaSummaryReportInVO vo) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CaSummaryReportOutVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param    = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 Map<String, String> mapVO = vo.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 

			 dbRowset = new SQLExecuter("BIS_HJSBAT").executeQuery((ISQLTemplate)new BLInformationMgtDBDAOCaSummaryReportOutVO2RSQL(),param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaSummaryReportOutVO.class);
			 
		 } catch(SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage(), se);
		 } catch(Exception ex) {
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		 }
		 
		 return list;
	 } 

	/**
	 *  MultiCombo 조회 이벤트 처리 ESM_BKG_0278
	 *
	 * @param bkgComboVO
	 * @return List<BkgComboVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgComboVO> searchSRouteFromList(BkgComboVO bkgComboVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgComboVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (bkgComboVO != null) {
				Map<String, String> mapVO = bkgComboVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("BIS_HJSBAT").executeQuery((ISQLTemplate) new BLInformationMgtDBDAOsearchSRouteFromListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgComboVO.class);
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 *  ESM_BKG_0280화면에 대한 조회 이벤트 처리
	 *
	 * @param grpBlPrtInVO
	 * @return GrpBlPrtOutVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<GrpBlPrtVO> searchBkgListForGrpBlPr(GrpBlPrtInVO grpBlPrtInVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<GrpBlPrtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		try {
			if (grpBlPrtInVO != null) {
				// 기존에 작성한 쿼리문 ${조회조건변수명} / @[조회조건변수명] 값에 설정
				Map<String, String> mapVO = grpBlPrtInVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
	
				// master_bl_no
				if (!grpBlPrtInVO.getMasterBlNo().equals("")) {
					velParam.put("masterBlnos", setparam_In(grpBlPrtInVO.getMasterBlNo(), "|"));
				}
				
				// master_bkg_no
				if (!grpBlPrtInVO.getMasterBkgNo().equals("")) {
					velParam.put("masterBkgnos", setparam_In(grpBlPrtInVO.getMasterBkgNo(), "|"));
				}
	
				// Customer Type - cust_tp_cd
				if (!grpBlPrtInVO.getCustTpCd().equals("")) {
					velParam.put("custTpCds", setparam_In(grpBlPrtInVO.getCustTpCd(), "|"));
				}
	
				// R/D Term - booking_rcv_term_cd
				if (!grpBlPrtInVO.getBookingRcvTermCd().equals("")) {
					velParam.put("bkgRcvTermCds", setparam_In(grpBlPrtInVO.getBookingRcvTermCd(), "|"));
				}
	
				// R/D Term - booking_de_term_cd
				if (!grpBlPrtInVO.getBookingDeTermCd().equals("")) {
					velParam.put("bkgDeTermCds", setparam_In(grpBlPrtInVO.getBookingDeTermCd(), "|"));
				}
	
				// S.Route - org_sconti_cd
				if (!grpBlPrtInVO.getOrgScontiCd().equals("")) {
					velParam.put("orgScontiCds", setparam_In(grpBlPrtInVO.getOrgScontiCd(), "|"));
				}
	
				// S.Route - desc_sconti_cd
				if (!grpBlPrtInVO.getDescScontiCd().equals("")) {
					velParam.put("descScontiCds", setparam_In(grpBlPrtInVO.getDescScontiCd(), "|"));
				}
	
				// S.Mode - org_svc_mod_cd
				if (!grpBlPrtInVO.getOrgSvcModCd().equals("")) {
					velParam.put("orgSvcModCds", setparam_In(grpBlPrtInVO.getOrgSvcModCd(), "|"));
				}
	
				// S.Mode - desc_inlnd_svc_mod_cd
				if (!grpBlPrtInVO.getDescInlndSvcModCd().equals("")) {
					velParam.put("descInlndSvcModCds", setparam_In(grpBlPrtInVO.getDescInlndSvcModCd(), "|"));
				}
	
				// Cargo Type - bkg_cgo_tp_cd
				if (!grpBlPrtInVO.getBkgCgoTpCd().equals("")) {
					velParam.put("bkgCgoTpCds", setparam_In(grpBlPrtInVO.getBkgCgoTpCd(), "|"));
				}
	
				// Booking Status - bkg_sts_cd
				if (!grpBlPrtInVO.getBkgStsCd().equals("")) {
					velParam.put("bkgStsCds", setparam_In(grpBlPrtInVO.getBkgStsCd(), "|"));
				}
	
				// Memo B/L Type - adv_shtg_cd
				if (!grpBlPrtInVO.getAdvShtgCd().equals("")) {
					velParam.put("advShtgCds", setparam_In(grpBlPrtInVO.getAdvShtgCd(), "|"));
				}
	
				// Revenue - revenue
				if (!grpBlPrtInVO.getRevenue().equals("")) {
					velParam.put("revenueCds", setparam_In(grpBlPrtInVO.getRevenue(), "|"));
				}
	
				// query_sort
				if (!grpBlPrtInVO.getQuerySort().equals("")) {
					velParam.put("querySortCds", setparam_In(grpBlPrtInVO.getQuerySort(), "|"));
				}
	
			}
			dbRowset = new SQLExecuter("BIS_HJSBAT").executeQuery((ISQLTemplate) new BLInformationMgtDBDAOsearchBkgListForGrpBlPrRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, GrpBlPrtVO.class);
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * IN Query 사용시 조합<br>
	 * 
	 * @param String strParam
	 * @param String strIterator
	 * @return List<String>
	 * @exception EventException
	 */
	private List<String> setparam_In(String strParam, String strIterator) throws EventException {
		List<String> arrString = null;
		StringTokenizer st = null;
		try {
			arrString = new ArrayList<String>();
			st = new StringTokenizer(strParam, strIterator);
			while (st.hasMoreTokens()) {
				arrString.add(st.nextToken());
			}
			return arrString;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * bkg별 c/a list를 조회한다.(kind 포함)<br>
	 * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @return CaBkgInfoVO 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CaBkgInfoVO searchCaBkgInfo(BkgBlNoVO vo) throws DAOException {
		DBRowSet         dbRowset = null;
		List<CaBkgInfoVO> list     = null;
		CaBkgInfoVO caBkgInfoVO = new CaBkgInfoVO();

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("BIS_HJSBAT").executeQuery((ISQLTemplate)new BLInformationMgtDBDAOSearchCaBkgInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaBkgInfoVO.class);

			if (list != null && list.size() > 0) {
				caBkgInfoVO = (CaBkgInfoVO)list.get(0);
			}
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return caBkgInfoVO;
	}
	
	/**
	 * bkg별 c/a list를 조회한다.(kind 포함)<br>
	 * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @return List<CaListByBkgVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CaListByBkgVO> searchCaListByBkg(BkgBlNoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CaListByBkgVO> list = null;

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("BIS_HJSBAT").executeQuery((ISQLTemplate)new BLInformationMgtDBDAOSearchCaListByBkgRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaListByBkgVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * c/a 건별 일반 정보 변경 이력을 조회한다.<br>
	 * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @return List<CaGeneralVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CaGeneralVO> searchCaGeneral(BkgBlNoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CaGeneralVO> list = null;

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("BIS_HJSBAT").executeQuery((ISQLTemplate)new BLInformationMgtDBDAOSearchCaGeneralRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaGeneralVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * c/a 건벌 charge 정보 변경 이력을 조회한다.<br>
	 * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @return List<CaChargeVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CaChargeVO> searchCaCharge(BkgBlNoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CaChargeVO> list = null;

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("BIS_HJSBAT").executeQuery((ISQLTemplate)new BLInformationMgtDBDAOSearchCaChargeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaChargeVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * c/a 건벌 customer 정보 변경 이력을 조회한다.<br>
	 * @author Lee NamKyung
     * @param  BkgBlNoVO vo
     * @return List<CaCustVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CaCustVO> searchCaCust(BkgBlNoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CaCustVO> list = null;

		//query parameter
		Map<String, Object> param    = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vo != null){
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll   (mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("BIS_HJSBAT").executeQuery((ISQLTemplate)new BLInformationMgtDBDAOSearchCaCustRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CaCustVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
    /**
     *  BIS MonitorList 를 조회한다.(ESM_BIS_0001)<br>
     * @author KIM TAE KYOUNG 
     * @param  String fromDt
     * @param  String toDt
     * @return List<BisMonitorListVO> 
     * @exception DAOException
     */
	@SuppressWarnings("unchecked")
	public List<BisMonitorListVO> searhMonitorList(String fromDt, String toDt) throws DAOException {
		DBRowSet dbRowset = null;
		List<BisMonitorListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("from_dt", fromDt);
			param.put("to_dt", toDt);
			
			velParam.put("fromDt", fromDt);
			velParam.put("toDt", toDt);
			
			dbRowset = new SQLExecuter("BIS_HJSBAT").executeQuery((ISQLTemplate)new BLInformationMgtDBDAOSearchBisMonitorListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BisMonitorListVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
    /**
     *  BIS searchBisManualList 를 조회한다.(ESM_BIS_0001)<br>
     * @author KIM TAE KYOUNG 
     * @param  String fromDt
     * @param  String toDt
     * @return List<BisMonitorListVO> 
     * @exception DAOException
     */
	@SuppressWarnings("unchecked")
	public List<BisManualListVO> searchBisManualList(String fromDt, String toDt) throws DAOException {
		DBRowSet dbRowset = null;
		List<BisManualListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			param.put("from_dt", fromDt);
			param.put("to_dt", toDt);
			
			velParam.put("fromDt", fromDt);
			velParam.put("toDt", toDt);
			
			dbRowset = new SQLExecuter("BIS_HJSBAT").executeQuery((ISQLTemplate)new BLInformationMgtDBDAOSearchBisManualListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BisManualListVO.class);
		}catch(SQLException se){
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
 	
	/**
	 * bkg별 BDR, C/A 상태 조회.<br>
	 * Table - BIS_BL_DOC<br>
	 * 
	 * @param BisBlNoVO vo
	 * @return BisBlNoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BisBlNoVO searchBisBlNoVO(BisBlNoVO vo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BisBlNoVO> list = null;
		BisBlNoVO bisBlNoVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("BIS_HJSBAT").executeQuery((ISQLTemplate) new BLInformationMgtDBDAOSearchBisBlNoVORSQL(), param, velParam);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BisBlNoVO.class);
			if (list.size() > 0) {
				bisBlNoVO = (BisBlNoVO) list.get(0);
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bisBlNoVO;
	}
	
	 /**
     *  BIS searchBisManualList 를 조회한다.(ESM_BIS_0001)<br>
     * @author KIM TAE KYOUNG 
     * @param  BisManualListVO bisManualListVO
     * @exception DAOException
     */
	public void manageBisBkgManual(BisManualListVO bisManualListVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
	    try {
			Map<String, String> mapVO = bisManualListVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	    	new SQLExecuter("BIS_HJSBAT").executeSP((ISQLTemplate)new BLInformationMgtDBDAOmanageBisBkgManualUSQL(), param, velParam);
	    } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch(Exception ex) {
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage());
	    }
	}
	 /**
     *  BIS searchBisManualList 를 조회한다.(ESM_BIS_0001)<br>
     * @author KIM TAE KYOUNG 
     * @param  BisManualListVO bisManualListVO
     * @exception DAOException
     */
	public void manageBisBkgHisManual(BisManualListVO bisManualListVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
	    try {
			Map<String, String> mapVO = bisManualListVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	    	new SQLExecuter("BIS_HJSBAT").executeSP((ISQLTemplate)new BLInformationMgtDBDAOmanageBisBkgHisManualUSQL(), param, velParam);
	    } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch(Exception ex) {
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage());
	    }
	}	

	 /**
    *  BIS searchBisManualList 를 조회한다.(ESM_BIS_0001)<br>
    * @author KIM TAE KYOUNG 
    * @param  String fromDt
    * @param  String toDt
    * @exception DAOException
    */
	public void manageBisManual(String fromDt, String toDt) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
	    try {
	    	param.put("from_dt", fromDt);
			param.put("to_dt", toDt);
			
			velParam.put("fromDt", fromDt);
			velParam.put("toDt", toDt);
			
	    	new SQLExecuter("BIS_HJSBAT").executeSP((ISQLTemplate)new BLInformationMgtDBDAOmanageBisManualUSQL(), param, velParam);
	    } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch(Exception ex) {
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage());
	    }
	}
	 /**
     *  BIS searchBisManualList 를 조회한다.(ESM_BIS_0001)<br>
     * @author KIM TAE KYOUNG 
     * @param  BisManualListVO bisManualListVO
     * @exception DAOException
     */
	public void manageBkgBisFlg(BisManualListVO bisManualListVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
	    try {
			Map<String, String> mapVO = bisManualListVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	    	new SQLExecuter("").executeSP((ISQLTemplate)new BLInformationMgtDBDAOmanageBkgBisFlgUSQL(), param, velParam);
	    } catch (SQLException se) {
	        log.error(se.getMessage(),se);
	        throw new DAOException(new ErrorHandler(se).getMessage());
	    } catch(Exception ex) {
	        log.error(ex.getMessage(),ex);
	        throw new DAOException(new ErrorHandler(ex).getMessage());
	    }
	}	
	
	/**
	 *  Rider 여부판단 ESM_BIS_0927
	 *
	 * @param String bkg_no
	 * @param String hiddenData
	 * @param String rate
	 * @param String cntr
	 * @param String corr_no
	 * @return String
	 * @exception DAOException
	 */
	public String searchRiderYn(String bkg_no, String hiddenData, String rate, String cntr, String corr_no) throws DAOException {
		DBRowSet dbRowset = null;
		String strResult = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkg_no != null) {
				/*
				log.debug("####################################################");
				log.debug("");
				log.debug("bkg_no : [" + bkg_no + "]");
				log.debug("hiddenData : [" + hiddenData + "]");
				log.debug("rate : [" + rate + "]");
				log.debug("cntr : [" + cntr + "]");
				log.debug("corr_no : [" + corr_no + "]");
				log.debug("");
				log.debug("####################################################");
				*/
				param.put("bkg_no", bkg_no);
				param.put("hiddenData", hiddenData);
				param.put("rate", rate);
				param.put("cntr", cntr);
				param.put("corr_no", corr_no);
				
				velParam.put("bkg_no", bkg_no);
				velParam.put("hiddenData", hiddenData);
				velParam.put("rate", rate);
				velParam.put("cntr", cntr);
				velParam.put("corr_no", corr_no);
			}
			dbRowset = new SQLExecuter("BIS_HJSBAT").executeQuery((ISQLTemplate) new BLInformationMgtDBDAOSearchRiderYnRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		strResult = dbRowset.getString("RIDER_YN");
	    	}
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strResult;
	}	
	
	/**
	 *  HouseB/L 여부판단 ESM_BIS_0927
	 *
	 * @param String bkg_no
	 * @return String
	 * @exception DAOException
	 */
	public String searchHouseBlYn(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		String strResult = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkg_no != null) {

				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("BIS_HJSBAT").executeQuery((ISQLTemplate) new BLInformationMgtDBDAOSearchHouseBlYnRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		strResult = dbRowset.getString("NVO_HBS_YN");
	    	}
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strResult;
	}
	
	/**
	 * OBL_ISS_FLG ESM_BIS_0927
	 * 
	 * @param String bkg_no
	 * @return String
	 * @exception DAOException
	 */
	public String searchOblIssFlg(String bkg_no) throws DAOException {
		DBRowSet dbRowset = null;
		String strResult = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkg_no != null) {

				param.put("bkg_no", bkg_no);
				velParam.put("bkg_no", bkg_no);
			}
			dbRowset = new SQLExecuter("BIS_HJSBAT").executeQuery((ISQLTemplate) new BLInformationMgtDBDAOSearchOblIssFlgRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		strResult = dbRowset.getString("obl_iss_flg");
	    	}
		} catch (SQLException ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return strResult;
	}
}