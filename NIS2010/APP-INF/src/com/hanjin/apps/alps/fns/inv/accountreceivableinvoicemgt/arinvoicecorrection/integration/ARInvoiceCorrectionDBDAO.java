/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ARInvoiceCorrectionDBDAO.java
 *@FileTitle : Invoice Split Before Invoice Issue
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 김세일
 *@LastVersion : 1.0
 * 2009.05.04 김세일
 * 1.0 Creation
* --------------------------------------------------------
* History
* 2011.05.27 최도순 [CHM-201109030-01] Intra - Europe Business 관련 VAT 기능 개발
* 2011.10.26 권   민 [CHM-201114096] Service Management > A/R Invoice > Exchange Rate > Ex. Rate Update by Date or VVD Office Multi Check 기능 개발
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateTargetChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateTargetMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.basic.ARInvoiceCorrectionBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARCorrectionCkReturnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceChargeCorrectionVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCorrectionVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCustomerInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCustomerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceListByVesselVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.BLRevenueVVDVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.BillInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.BkgNoCaNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ChangeCustomerInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DirectBillingInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArEuCntVatVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArIfNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvByVVDVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvIssAtchVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvoiceCustomerChangeChargeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvoiceCustomerChangeListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvoiceCustomerChangeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.MDMCustomerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ManualInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.MarkingReverseChargeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.RevenueVVDLaneVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.UnmatchRevenueVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.UnmatchRevenueVesselVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceChargeSumVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS ARInvoiceCorrectionDBDAO <br>
 * - ALPS-AccountReceivableInvoiceMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author saeil kim
 * @see ARInvoiceCorrectionBCImpl 참조
 * @since J2EE 1.4
 */
public class ARInvoiceCorrectionDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;


	/**
	 * INV_AR_MN, BKG_BOOKING 테이블에서 select 조회한다.<br>
	 * @author DongHoon Han
	 * @param InvByVVDVO invByVVDVO
	 * @return List<ARInvoiceListByVesselVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARInvoiceListByVesselVO> searchARInvoiceListByVVD(InvByVVDVO invByVVDVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<ARInvoiceListByVesselVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invByVVDVO != null){
				Map<String, String> mapVO = invByVVDVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOARInvoiceListByVesselVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceListByVesselVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * VSK_VSL_PORT_SKD 테이블에서 select 조회한다.<br>
	 * @author DongHoon Han
	 * @param InvByVVDVO invByVVDVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchSADate(InvByVVDVO invByVVDVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String sa_date = "";
		try{
			if(invByVVDVO != null){
				Map<String, String> mapVO = invByVVDVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOVskVslPortSkdRSQL(), param, velParam);
			if(dbRowset.next()) {
				sa_date = dbRowset.getString("sa_date").toString();
				log.info("sa_date======================"+sa_date);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		}
		return sa_date;
	}

	/**
	 * INV_VVD_XCH_RT 테이블에서 select 조회한다.<br>
	 * @author DongHoon Han
	 * @param InvByVVDVO invByVVDVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchVVDExrate(InvByVVDVO invByVVDVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String inv_xch_rt = "";
		try{
			if(invByVVDVO != null){
				Map<String, String> mapVO = invByVVDVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOInvVvdXchRtRSQL(), param, velParam);
			if(dbRowset.next()) {						
				inv_xch_rt = dbRowset.getString("inv_xch_rt");
				log.info("inv_xch_rt======================"+inv_xch_rt);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		}
		return inv_xch_rt;
	}

	/**
	 * INV_AR_STUP_OFC 테이블에서 Select<br>
	 * FNS_INV_0016,FNS_INV_0017,FNS_INV_0018,FNS_INV_0033,FNS_INV_0094<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchOTSSummary ( String ofcCd ) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		String ots_smry_cd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchOTSSummaryRSQL(), param, velParam);
			if(dbRowset.next()) {						
				ots_smry_cd = dbRowset.getString("ots_smry_cd");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return ots_smry_cd;
	}


	/**
	 * INV_AR_MN 테이블에서 select 기본 조건 REV_TP_CD<> 'M' AND  INV_DELT_DIV_CD <> 'Y'  <br>
	 * 
	 * @param String ofcCd
	 * @param String blNo
	 * @param String invNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxInterfaceNoByBL ( String ofcCd , String blNo , String invNo)throws DAOException,Exception {
		DBRowSet dbRowset = null;
		String arIfNo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", ofcCd);
			mapVO.put("bl_no", blNo);
			mapVO.put("inv_no", invNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchMaxInterfaceNoByBLVORSQL(), param, velParam);
			if(dbRowset.next()) {						
				arIfNo = dbRowset.getString("ar_if_no");
			}


		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return arIfNo;
	}




	/**
	 * INV_AR_MN 테이블에서 select Max interface 정보를 구함. INV_AR_MN.INV_DELT_DIV_CD<>'Y'  이어야 함.<br>
	 * 
	 * @param String ifNo
	 * @return ARInvoiceCorrectionVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ARInvoiceCorrectionVO searchARInvoiceMainByIFNo (String ifNo ) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<ARInvoiceCorrectionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", ifNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchARInvoiceMainByIFNoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceCorrectionVO .class);

			log.info("list==>"+list.get(0).getArIfNo());
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list.get(0);
	}


	/**
	 * INV_AR_CHG 테이블에서 Select<br>
	 * 
	 * @param String ifNo
	 * @return List<ARInvoiceChargeCorrectionVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARInvoiceChargeCorrectionVO> searchARInvoiceChargeByIFNo (String ifNo ) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<ARInvoiceChargeCorrectionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", ifNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchARInvoiceChargeByIFNoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceChargeCorrectionVO .class);
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
	 * INV_AR_CHG에서 Currency별 합계금액 및 Local Amount( chg_amt * INV_XCH_RT) 를 Summary 해온다.<br>
	 *(LCL Currency는 INV_AR_MN에 있음)<br>
	 * 금액 소수자리는 MDM_CURRENCY의 DP_PRCS_KNT에 따라 Local Amount 를 보여줌.<br>
	 * 
	 * @param String ifNo
	 * @return List<ARInvoiceChargeSumVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARInvoiceChargeSumVO> searchARInvoiceChargeSumByIFNo  (String ifNo ) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<ARInvoiceChargeSumVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", ifNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchARInvoiceChargeSumByIFNoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceChargeSumVO .class);
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
	 * INV_AR_CNTR 테이블에서 Select<br>
	 * 
	 * @param String ifNo
	 * @return List<InvArCntrVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvArCntrVO> searchARInvoiceContainerByIFNo (String ifNo ) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<InvArCntrVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", ifNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchARInvoiceContainerByIFNoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArCntrVO .class);
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
	 * Vessel SKD 테이블에서 select<br>
	 * 
	 * @param String vvdCd
	 * @param String ioBndCd
	 * @param String pol
	 * @param String pod
	 * @return int
	 * @exception DAOException
	 */
	public int checkVesselSKD ( String vvdCd , String ioBndCd, String pol, String pod )throws DAOException,Exception {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vvd", vvdCd);
			mapVO.put("io_bnd_cd", ioBndCd);
			mapVO.put("pol", pol);
			mapVO.put("pod", pod);
			

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOCheckVesselSKDVORSQL(), param, velParam);
			if(dbRowset.next()) {						
				cnt = dbRowset.getInt("cnt");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return cnt;
	}



	/**
	 * Location 테이블에서 select<br>
	 * 
	 * @param String port
	 * @return int
	 * @exception DAOException
	 */
	public int checkPort ( String port )throws DAOException,Exception {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("loc_cd", port);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOCheckPortVORSQL(), param, velParam);
			if(dbRowset.next()) {						
				cnt = dbRowset.getInt("cnt");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return cnt;
	}



	/**
	 * Location, INV_AR_MN 테이블에서 select<br>
	 * 
	 * @param String pol
	 * @param String pod
	 * @return String
	 * @exception DAOException
	 */
	public String searchZoneIOC ( String pol , String pod )throws DAOException,Exception {
		DBRowSet dbRowset = null;
		String zoneIoc = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("pol_cd", pol);
			mapVO.put("pod_cd", pod);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchZoneIOCVORSQL(), param, velParam);
			if(dbRowset.next()) {						
				zoneIoc = dbRowset.getString("zone_ioc");
			}

			log.info("zon==>"+zoneIoc);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return zoneIoc;
	}


	/**
	 * Closing Status 테이블을 select <br>
	 * 해당 office 로  Closing Status 정보가 없을시 AR_HD_QTR_OFC_CD의 Closing Status 및 EffDt 를 적용한다.<br>
	 * 
	 * @param String ofcCd
	 * @param String sailingDt
	 * @return String
	 * @exception DAOException
	 */
	public String searchEffectiveDate ( String ofcCd , String sailingDt )throws DAOException,Exception {
		DBRowSet dbRowset = null;
		String effDt = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc", ofcCd);
			mapVO.put("sail_dt", sailingDt);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchEffectiveDateVORSQL(), param, velParam);
			if(dbRowset.next()) {						
				effDt = dbRowset.getString("eff_dt");
			}
			log.info("ADF==>"+effDt);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return effDt;
	}




	/**
	 * Duedate MDM_CR_CUST, MDM_ORGANIZATION 테이블에서 조회<br>
	 * 
	 * @param DueDateInputVO dueDateInputVO
	 * @return List<DueDateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DueDateVO> searchDueDate ( DueDateInputVO dueDateInputVO ) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<DueDateVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 

		try{

			if(dueDateInputVO != null){
				Map<String, String> mapVO = dueDateInputVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchDueDateVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DueDateVO .class);
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
	 * AR Invoice issue 테이블에서 office code, Invoice no에 조회하여 AR Invoice main 테이블에서 조회하여 가져온다.<br>
	 * 
	 * @author JungJin Park
	 * @param String ofcCd
	 * @param String vvdCd
	 * @param String portCd
	 * @return InvIssAtchVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public InvIssAtchVO searchInvoiceWordingByVVD (String ofcCd, String vvdCd, String portCd) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List< InvIssAtchVO> list = null;
		InvIssAtchVO invIssAtchVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if( ofcCd != null && vvdCd != null && portCd != null){
				String vslCd = "";
				String skdVoyNo = "";
				String skdDirCd = "";

				Map<String, String> mapVO = new HashMap<String, String>();

				vslCd = vvdCd.substring(0, 4);
				skdVoyNo = vvdCd.substring(4, 8);
				skdDirCd = vvdCd.substring(8, 9);

				mapVO.put("ar_ofc_cd", ofcCd);
				mapVO.put("vsl_cd", vslCd);
				mapVO.put("skd_voy_no", skdVoyNo);
				mapVO.put("skd_dir_cd", skdDirCd);
				mapVO.put("port_cd", portCd);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchInvoiceWordingByVVDRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,  InvIssAtchVO .class);

			if (list != null && list.size() > 0) {
				invIssAtchVO = (InvIssAtchVO) list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		}
		return invIssAtchVO;
	}
	
	/**
	 * AR Invoice issue 테이블에서 office code, Invoice no에 조회하여 AR Invoice main 테이블에서 조회하여 가져온다.<br>
	 * 
	 * @author JungJin Park
	 * @param String ofcCd
	 * @param String custCntCd
	 * @param String custSeq
	 * @return InvIssAtchVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public InvIssAtchVO searchInvoiceWordingByCustomer (String ofcCd, String custCntCd, String custSeq) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List< InvIssAtchVO> list = null;
		InvIssAtchVO invIssAtchVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if( ofcCd != null && custCntCd != null && custSeq != null){
				Map<String, String> mapVO = new HashMap<String, String>();

				mapVO.put("ar_ofc_cd", ofcCd);
				mapVO.put("cust_cnt_cd", custCntCd);
				mapVO.put("cust_seq", custSeq);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchInvoiceWordingByCustomerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset,  InvIssAtchVO .class);

			if (list != null && list.size() > 0) {
				invIssAtchVO = (InvIssAtchVO) list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		}
		return invIssAtchVO;
	}

	/**
	 * INV_ISS_ATCH 테이블 데이터를 생성한다.<br>
	 * 
	 * @param List<InvIssAtchVO> invWordVos
	 * @exception DAOException
	 */                  
    public void addInvoiceWordingByVVD(List<InvIssAtchVO> invWordVos ) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invWordVos.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceCorrectionDBDAOInvIssAtchVOCSQL(), invWordVos, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12115", new String[]{"Letter Wording"}).getMessage());
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }
    
	/**
	 * INV_ISS_ATCH 테이블 데이터를 생성한다.<br>
	 * 
	 * @param List<InvIssAtchVO> invWordVos
	 * @exception DAOException
	 */                  
    public void addInvoiceWordingByCustomer(List<InvIssAtchVO> invWordVos ) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invWordVos.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceCorrectionDBDAOAddnInvoiceWordingByCustomerCSQL(), invWordVos, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException(new ErrorHandler("COM12115", new String[]{"Letter Wording"}).getMessage());
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }
	
	/**
	 * INV_ISS_ATCH 테이블 데이터를 갱신한다.<br>
	 * 
	 * @param List<InvIssAtchVO> invWordVos
	 * @exception DAOException
	 */                  
    public void modifyInvoiceWordingByVVD(List<InvIssAtchVO> invWordVos ) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invWordVos.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceCorrectionDBDAOInvIssAtchVOUSQL(), invWordVos, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }
    
	/**
	 * INV_ISS_ATCH 테이블 데이터를 갱신한다.<br>
	 * 
	 * @param List<InvIssAtchVO> invWordVos
	 * @exception DAOException
	 */                  
    public void modifyInvoiceWordingByCustomer(List<InvIssAtchVO> invWordVos ) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invWordVos.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceCorrectionDBDAOModifyInvoiceWordingByCustomerUSQL(), invWordVos, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }
    
	/**
	 * INV_ISS_ATCH 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @author JungJin Park
	 * @param InvIssAtchVO invWordVo
	 * @exception DAOException
	 */
	public void removeInvoiceWordingByVVD(InvIssAtchVO invWordVo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String vslCd = "";
		String skdVoyNo = "";
		String skdDirCd = "";

		int result = 0;
		try {
			Map<String, String> mapVO = invWordVo.getColumnValues();

			vslCd = invWordVo.getVvd().substring(0, 4);
			skdVoyNo = invWordVo.getVvd().substring(4, 8);
			skdDirCd = invWordVo.getVvd().substring(8, 9);

			mapVO.put("vsl_cd", vslCd);
			mapVO.put("skd_voy_no", skdVoyNo);
			mapVO.put("skd_dir_cd", skdDirCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ARInvoiceCorrectionDBDAORemoveInvoiceWordingByVVDDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
    
	/**
	 * INV_ISS_ATCH 다건의 데이터를 일괄적으로 삭제한다.<br>
	 * 
	 * @author JungJin Park
	 * @param InvIssAtchVO invWordVo
	 * @exception DAOException
	 */
	public void removeInvoiceWordingByCustomer(InvIssAtchVO invWordVo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = invWordVo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ARInvoiceCorrectionDBDAORemoveInvoiceWordingByCustomerDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * MST_CONTAINER 에서 CNTR_NO로 CNTR_TPSZ_CD를 구해 온다. <br>
	 * 
	 * @param String cntrNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchContainerNo (String cntrNo) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String cntrTpszCd = "";	
		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cntr_no", cntrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOsearchContainerNoRSQL(), param, velParam);
			if(dbRowset.next()) {						
				cntrTpszCd = dbRowset.getString("cntr_tpsz_cd");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cntrTpszCd;
	}

	/**
	 * FNS_INV_0017 Invoice Customer Correction by Date 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param ARInvoiceCustomerInputVO aRInvoiceCustomerInputVO
	 * @return List<ARInvoiceCustomerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARInvoiceCustomerVO> searchARInvoiceListByDate(ARInvoiceCustomerInputVO aRInvoiceCustomerInputVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<ARInvoiceCustomerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = aRInvoiceCustomerInputVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOARInvoiceCustomerVORSQL(), param, velParam,true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceCustomerVO .class);
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
	 * FNS_INV_0017 Invoice Customer Correction by Date 화면 Customer 조회 이벤트 처리<br>
	 * 
	 * @param String ofcCd
	 * @param String custNm
	 * @param String shprCustCntCd
	 * @param String shprCustSeq
	 * @param String fwdrCustCntCd
	 * @param String fwdrCustSeq
	 * @return List<MDMCustomerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MDMCustomerVO> searchARCustomerList(String ofcCd, String custNm, String shprCustCntCd, String shprCustSeq, String fwdrCustCntCd, String fwdrCustSeq) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<MDMCustomerVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("cust_nm", custNm);
			mapVO.put("shpr_cust_cnt_cd", shprCustCntCd);
			mapVO.put("shpr_cust_seq", shprCustSeq);
			mapVO.put("fwdr_cust_cnt_cd", fwdrCustCntCd);
			mapVO.put("fwdr_cust_seq", fwdrCustSeq);

			param.putAll(mapVO);

			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOARCustomerListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MDMCustomerVO .class);
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
	 * FNS_INV_0094_01 Invoice 발행 후 Customer 변경하는 화면 조회 이벤트 처리<br>
	 * 
	 * @param  String ofcCd
	 * @param String invNo
	 * @return InvoiceCustomerChangeVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public InvoiceCustomerChangeVO searchChangeCustomerInvoiceMain(String ofcCd, String invNo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<InvoiceCustomerChangeVO> list = null;
		InvoiceCustomerChangeVO invoiceCustomerChangeVO = new InvoiceCustomerChangeVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", ofcCd);
			mapVO.put("inv_no", invNo);

			param.putAll(mapVO);

			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchChangeCustomerInvoiceMainRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceCustomerChangeVO .class);
			
			if (list != null && list.size() > 0) {
				invoiceCustomerChangeVO = (InvoiceCustomerChangeVO) list.get(0);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return invoiceCustomerChangeVO;
	}
	
	/**
	 * FNS_INV_0094_01 Invoice 발행 후 Customer 변경하는 화면 CHG 조회 이벤트 처리<br>
	 * 
	 * @param String ofcCd
	 * @param String invNo
	 * @return List<InvoiceCustomerChangeChargeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvoiceCustomerChangeChargeVO> searchChangeCustomerInvoiceCharge(String ofcCd, String invNo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<InvoiceCustomerChangeChargeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", ofcCd);
			mapVO.put("inv_no", invNo);

			param.putAll(mapVO);

			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchChangeCustomerInvoiceChargeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceCustomerChangeChargeVO .class);
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
	 * FNS_INV_0094_01 Invoice 발행 후 Customer 변경하는 화면 변경할 AR_IF_NO 조회 이벤트 처리<br>
	 * 
	 * @param String ofcCd
	 * @param String invNo
	 * @return List<DueDateInputVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DueDateInputVO> searchIfNoList(String ofcCd, String invNo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<DueDateInputVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", ofcCd);
			mapVO.put("inv_no", invNo);

			param.putAll(mapVO);

			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchIfNoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DueDateInputVO .class);
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
	 * FNS_INV_0094_01 Invoice 발행 후 Customer 변경하는 화면 RepCustomer 체크 처리<br>
	 * 
	 * @param String actCustCntCd
	 * @param String actCustSeq
	 * @return int
	 * @exception DAOException
	 */
	public int checkRepCustomer ( String actCustCntCd, String actCustSeq )throws DAOException,Exception {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("act_cust_cnt_cd", actCustCntCd);
			mapVO.put("act_cust_seq", actCustSeq);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOCheckRepCustomerRSQL(), param, velParam);
			if(dbRowset.next()) {						
				cnt = dbRowset.getInt("cnt");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return cnt;
	}
	
	/**
	 * FNS_INV_0094_02 Invoice 발행 후 Customer 일괄 변경하는 화면 조회 이벤트 처리<br>
	 * 
	 * @param ChangeCustomerInputVO changeCustomerinputVO
	 * @return List<InvoiceCustomerChangeListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvoiceCustomerChangeListVO> searchChangeCustomerInvoiceList(ChangeCustomerInputVO changeCustomerinputVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<InvoiceCustomerChangeListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(changeCustomerinputVO != null){
				Map<String, String> mapVO = changeCustomerinputVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchChangeCustomerInvoiceListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceCustomerChangeListVO .class);
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
	 * FNS_INV_0094_02 Invoice 발행 후 Customer 일괄 변경하는 화면 if_no 조회 이벤트 처리<br>
	 * 
	 * @param ChangeCustomerInputVO changeCustomerinputVO
	 * @return List<DueDateInputVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DueDateInputVO> searchChangeCustomerIfNoList(ChangeCustomerInputVO changeCustomerinputVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<DueDateInputVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(changeCustomerinputVO != null){
				Map<String, String> mapVO = changeCustomerinputVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchChangeCustomerIfNoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DueDateInputVO .class);
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
	 * FNS_INV_0043 Multi Direct Billing 정보 조회 이벤트 처리<br>
	 * 
	 * @param BillInputVO billInputVO 
	 * @return List<DirectBillingInvoiceVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<DirectBillingInvoiceVO> searchDirectBilling(BillInputVO billInputVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<DirectBillingInvoiceVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(billInputVO != null){
				Map<String, String> mapVO = billInputVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchDirectBillingInvoiceVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DirectBillingInvoiceVO .class);
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
	 * Item Correction, Customer Change 하는 화면의 RevType,RevSrc 조회<br>
	 * 
	 * @param String bkgNo
	 * @param String invCustFlg
	 * @return ARCorrectionCkReturnVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ARCorrectionCkReturnVO searchRevTypeSrc(String bkgNo, String invCustFlg) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<ARCorrectionCkReturnVO> list = null;
		ARCorrectionCkReturnVO aRCorrectionCkReturnVO = new ARCorrectionCkReturnVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("inv_cust_flg", invCustFlg);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchRevTypSrcRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARCorrectionCkReturnVO .class);
			
			if (list != null && list.size() > 0) {
				aRCorrectionCkReturnVO = (ARCorrectionCkReturnVO) list.get(0);
			}else{
				aRCorrectionCkReturnVO.setRevTpCd("");
				aRCorrectionCkReturnVO.setRevSrcCd("");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return aRCorrectionCkReturnVO;
	}
	
	/**
	 * Invoice Split 가능 대상인지의 여부를 check함.<br>
	 * 
	 * @param String ifNo
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchSplitARInvoiceByIFNo (String ifNo, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String chkSplitIfNo = "";	
		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", ifNo);
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchSplitARInvoiceByIfNoRSQL(), param, velParam);
			if(dbRowset.next()) {						
				chkSplitIfNo = dbRowset.getString("chk_split_if_no");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return chkSplitIfNo;
	}
	
	 /**
  	* Interface Number 테이블에서 MaxSeq +SplitCnt+1 을 조회한다<br>
  	* 
	* @param  String ofcCd 
	* @param String splitCnt
	* @return String
	* @exception DAOException
	*/
	public String searchInterfaceNo ( String ofcCd , String splitCnt )throws DAOException {
		DBRowSet dbRowset = null;
		String maxSeq = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("split_cnt", splitCnt);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchInterfaceNoRSQL(), param, velParam);
			if(dbRowset.next()) {						
				maxSeq = dbRowset.getString("maxseq");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return maxSeq;
	}
	
	/**
	 * Bkg Customer 정보 조회 이벤트 처리<br>
	 * 
	 * @param String bkgNo
	 * @param String bnd
	 * @return ARInvoiceCustomerVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ARInvoiceCustomerVO searchBKGCustomerList(String bkgNo, String bnd) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<ARInvoiceCustomerVO> list = null;
		ARInvoiceCustomerVO aRInvoiceCustomerVO = new ARInvoiceCustomerVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bnd", bnd);

			param.putAll(mapVO);

			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchBKGCustomerListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceCustomerVO .class);
			
			if (list != null && list.size() > 0) {
				aRInvoiceCustomerVO = (ARInvoiceCustomerVO) list.get(0);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return aRInvoiceCustomerVO;
	}
	
	/**
	 * Invoice No 로 Split할 대상 IfNo List 조회<br>
	 * 
	 * @param String ofcCd
	 * @param String invNo
	 * @return List<InvArIfNoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvArIfNoVO> searchInterfaceListByInvoiceNo(String ofcCd, String invNo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<InvArIfNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("inv_no", invNo);

			param.putAll(mapVO);

			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchInterfaceListByInvoiceNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArIfNoVO .class);			
			
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
	 * Invoice No 로 Split할 대상 Chg Sum 조회<br>
	 * 
	 * @param String ofcCd
	 * @param String invNo
	 * @return List<ARInvoiceChargeCorrectionVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARInvoiceChargeCorrectionVO> searchARInvoiceChargeByInvoiceNo(String ofcCd, String invNo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<ARInvoiceChargeCorrectionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("inv_no", invNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchARInvoiceChargeByInvoiceNoVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceChargeCorrectionVO .class);
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
	 * FNS_INV_0028 Invoice 의 Manual Interface 대상 Bkg No, C/A No 를 조회한다.<br>
	 * 
	 * @param ManualInputVO manualInputVO
	 * @return List<BkgNoCaNoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgNoCaNoVO> searchManualInterfaceList(ManualInputVO manualInputVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<BkgNoCaNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(manualInputVO != null){
				Map<String, String> mapVO = manualInputVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchManualInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgNoCaNoVO .class);
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
	 * FNS_INV_0079<br>
	 * INV_AR_MN, INV_AR_CHG, INV_REV_VVD_UMCH 테이블에서 select<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String fromDt
	 * @param String toDt
	 * @param String bkgIfFlg 
	 * @return List<UnmatchRevenueVesselVO>
	 * @exception DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<UnmatchRevenueVesselVO> searchUnmatchRevenueVVDListByDate(String fromDt, String toDt, String bkgIfFlg) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<UnmatchRevenueVesselVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("from_dt", fromDt);
			param.put("to_dt", toDt);
			param.put("bkg_if_flg", bkgIfFlg);
			
			velParam.put("bkg_if_flg", bkgIfFlg);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOUnmatchRevenueVVDListByDateRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnmatchRevenueVesselVO .class);
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
	 * FNS_INV_0079<br>
	 * INV_REV_VVD_UMCH 테이블 전체 Delete<br>
	 * @exception DAOException, Exception
	 */
	public void removeUnmatchRevenueVVD() throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ARInvoiceCorrectionDBDAOUnmatchRevenueVVDDSQL(), null, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0079<br>
	 * INV_AR_MN 테이블에서 select<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String fromDt
	 * @param String toDt
	 * @return List<UnmatchRevenueVesselVO>
	 * @exception DAOException, Exception
	 */
	@SuppressWarnings("unchecked")
	public List<BLRevenueVVDVO> searchRevenueVVDTargetBL(String fromDt, String toDt) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<BLRevenueVVDVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("from_dt", fromDt);
			param.put("to_dt", toDt);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAORevenueVVDTargetBLRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BLRevenueVVDVO .class);
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
	 * FNS_INV_0079<br>
	 * INV_AR_MN, MDM_LOCATION, AR_FINC_DIR_CONV, AR_ROUT_RNK, AR_MST_REV_VVD 테이블에서 select<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String bkgNo
	 * @return RevenueVVDLaneVO
	 * @exception DAOException, Exception
	 */
	public RevenueVVDLaneVO searchNewRevenueVVDLane(String bkgNo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		RevenueVVDLaneVO revenueVVDLaneVO = new RevenueVVDLaneVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter().executeQuery(new ARInvoiceCorrectionDBDAONewRevenueVVDLaneRSQL(), param, null);
			revenueVVDLaneVO = (RevenueVVDLaneVO)RowSetUtil.rowSetToVOs(dbRowset, RevenueVVDLaneVO.class ).get(0);

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return revenueVVDLaneVO;
	}
	
	/**
	 * INV_REV_VVD_UMCH 테이블에 Insert<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param UnmatchRevenueVO unmatchRevenueVO
	 * @exception DAOException,Exception
	 */
	public void createUnmatchRevenueVVDListByDate(UnmatchRevenueVO unmatchRevenueVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = unmatchRevenueVO.getColumnValues();
			param.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ARInvoiceCorrectionDBDAOUnmatchRevenueVVDListByDateCSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}				
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * INV_AR_MN 테이블에서 공통항차DLS 'CFDR' 존재여부를 체크한다.<br>
	 * @author Choi Woo-Seok
	 * @param String blNo
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException,Exception
	 */
	public String searchCommonVVD(String blNo, String ofcCd) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		String bit = "";
		
		try{
			param.put("bl_no", blNo);
			param.put("ofc_cd", ofcCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOCommonVVDRSQL(), param, null);
			if(dbRowset.next()) {
				bit = dbRowset.getString("bit").toString();
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		}
		return bit;
	}
	
	/**
	 * INVOICE MAIN 테이블에서 LOCAL TOTAL AMT의 총합을 구한다.<br>
	 * @author Choi Woo-Seok
	 * @param String blNo
	 * @param String revVvd
	 * @param String ofcCd
	 * @return double
	 * @exception DAOException,Exception
	 */
	public double searchLocalTotalAmt(String blNo, String revVvd, String ofcCd) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		double amtTot = 0;
		
		try{
			param.put("bl_no", blNo);
			param.put("old_vvd", revVvd);
			param.put("ofc_cd", ofcCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOLocalTotalAmtRSQL(), param, null);
			if(dbRowset.next()) {
				amtTot = dbRowset.getDouble("AMT_TOT");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new Exception(new ErrorHandler(ex).getMessage(), ex);
		}
		return amtTot;
	}
	
	/**
	 * Ex Rate Update by Date or VVD의 환율적용대상 data 를 chg 테이블 조회<br>
	 * 
	 * @param String ifNo
	 * @return List<ExrateTargetChgVO>
	 * @exception DAOException
	 */		
	@SuppressWarnings("unchecked")
	public List<ExrateTargetChgVO> searchInvoiceChgForExrateList(String ifNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ExrateTargetChgVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("ar_if_no", ifNo);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchInvoiceChgForExrateListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ExrateTargetChgVO .class);
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
	 * Ex Rate Update by Date or VVD의 환율적용대상 data 를 Main 테이블조회<br>
	 * 
	 * 2011.10.26 권   민 [CHM-201114096] Service Management > A/R Invoice > Exchange Rate > Ex. Rate Update by Date or VVD Office Multi Check 기능 개발
	 * @param ExrateInputVO exrateInputVO
	 * @return List<ExrateTargetMainVO>
	 * @exception DAOException
	 */		
	@SuppressWarnings("unchecked")
	public List<ExrateTargetMainVO> searchInvoiceMainForExrateList(ExrateInputVO exrateInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ExrateTargetMainVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
		
		// multi select box 에서 들어온 ofcCd 나눠서 param으로 넘기기
		String ofcCd = exrateInputVO.getOfcCd();
		List<String> ofcCdList = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(ofcCd, ",");
	    while (st.hasMoreTokens()) {
	    	ofcCdList.add(st.nextToken());
	    }
		velParam.put("ofc_cd_list", ofcCdList);
		
		try{							
			Map<String, String> mapVO = exrateInputVO.getColumnValues();
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchInvoiceMainForExrateListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ExrateTargetMainVO .class);
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
  	* INV_AR_MN 테이블에서 Select<br>
  	* 
	* @param String ofcCd
	* @param String blNo
	* @param String ifNo
	* @return List<InvArMnVO>
	* @exception DAOException
	*/	
	@SuppressWarnings("unchecked")
	public List<InvArMnVO> searchARInvoiceMainList ( String ofcCd, String blNo , String ifNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArMnVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", ofcCd);
			mapVO.put("bl_src_no", blNo);
			mapVO.put("ar_if_no", ifNo);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchARInvoiceMainListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArMnVO .class);
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
	 * INV_AR_MN 테이블에서 Bl 별 Max IfNo 조회 기본 조건 REV_TP_CD<> 'M' AND  INV_DELT_DIV_CD <> 'Y'  <br>
	 * 
	 * @param String ofcCd
	 * @param String blNo
	 * @param String invNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxInterfaceForExrate ( String ofcCd , String blNo , String invNo)throws DAOException {
		DBRowSet dbRowset = null;
		String arIfNo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", ofcCd);
			mapVO.put("bl_no", blNo);
			mapVO.put("inv_no", invNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchMaxInterfaceForExrateRSQL(), param, velParam);
			if(dbRowset.next()) {						
				arIfNo = dbRowset.getString("ar_if_no");
			} 
			if (arIfNo == null) {
				arIfNo = "";
			}


		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return arIfNo;
	}
	
	/**
	 * FNS_INV_0079<br>
	 * Unmatch Revenue VVD 정보에 BKG Interface 처리여부를 update 한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String bkgNo
	 * @exception DAOException,Exception
	 */
	public void modifyBKGInterfaceFlag(String bkgNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ARInvoiceCorrectionDBDAOBKGInterfaceFlagRSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}				
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * INV_AR_ISS_DTL 테이블에서 ifNo로 InvoiceNo 를 조회한다.  <br>
	 * 
	 * @param String arIfNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchInvoiceNoByIfNo ( String arIfNo ) throws DAOException {
		DBRowSet dbRowset = null;
		String invNo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", arIfNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchInvoiceNoByIfNoRSQL(), param, velParam);
			if(dbRowset.next()) {						
				invNo = dbRowset.getString("inv_no");
			} 
			if (arIfNo == null) {
				invNo = "";
			}


		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return invNo;
	}
	
	/**
	 * run 실행한다.  <br>
	 * 
	 * @param String fromDt
	 * @param String toDt
	 * @param String usrId
	 * @exception DAOException
	 */
	public void createUnmatchRevenueVVDListByDate (String fromDt, String toDt, String usrId) throws DAOException {
		//DBRowSet dbRowset = null;
		//String jobID = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("from_dt", fromDt);
			mapVO.put("to_dt", toDt);
			mapVO.put("user_id", usrId);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ARInvoiceCorrectionDBDAOUnmatchRevenueVvdPrcCSQL(), param, null);
			log.info("result========================"+result);
			//if(result == Statement.EXECUTE_FAILED) {
			//	throw new DAOException("Fail to insert SQL");
			//}			
			
		} catch(SQLException se){
			log.error("SQLException==============="+se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch(Exception ex){
			log.error("Exception==============="+ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	
	 /**
  	* BKG_BOOKING 에서 VVD로 BKGNO 구해옴<br>
  	* 
	* @param String vvd
	* @param String pol
	* @param String pod
	* @return List<ARBkgInterfaceCreationVO>
	* @exception DAOException
	*/	
	@SuppressWarnings("unchecked")
	public List<ARBkgInterfaceCreationVO> searchBkgNoByVvd ( String vvd, String pol, String pod ) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARBkgInterfaceCreationVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vvd", vvd);
			mapVO.put("pol", pol);
			mapVO.put("pod", pod);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchBkgNoByVvdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARBkgInterfaceCreationVO .class);
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
	 * EU 국가 VAT 요율 관리 테이블 INV_AR_EU_CNT_VAT 조회<br>
	 * 
	 * @return List<InvArEuCntVatVO>
	 * @exception DAOException
	 */		
	@SuppressWarnings("unchecked")
	public List<InvArEuCntVatVO> searchVatRatioEntryList() throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArEuCntVatVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchVatRatioEntryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArEuCntVatVO .class);
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
	 * INV_AR_EU_CNT_VAT 테이블 데이터를 생성한다.<br>
	 * 
	 * @param List<InvArEuCntVatVO> invArEuCntVatVOs
	 * @exception DAOException
	 */                  
    public void addVatRatioEntry( List<InvArEuCntVatVO> invArEuCntVatVOs ) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invArEuCntVatVOs.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();				
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceCorrectionDBDAOAddVatRatioEntryCSQL(), invArEuCntVatVOs, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Insert No" + i + " SQL");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }
    
    /**
	 * INV_AR_EU_CNT_VAT 테이블 데이터를 갱신한다.<br>
	 * 
	 * @param List<InvArEuCntVatVO> invArEuCntVatVOs
	 * @exception DAOException
	 */                  
    public void modifyVatRatioEntry( List<InvArEuCntVatVO> invArEuCntVatVOs ) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invArEuCntVatVOs.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceCorrectionDBDAOModifyVatRatioEntryUSQL(), invArEuCntVatVOs, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }
    
    /**
	 * MDM_COUNTRY에서 EURO Country List를 가져온다.<br>
	 * 
	 * @return List<String>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<String> searchEuroCountryList() throws DAOException {
		DBRowSet dbRowset = null;
		List list = new ArrayList();
		String cntCd = "";

		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchMdmCountryRSQL(),  param, velParam);
			while (dbRowset.next()) {
				cntCd = dbRowset.getString("cnt_cd");
				
				list.add(cntCd);
			}
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
	 * B/L No. 와 Ofc CD로 Reverse Charge 조회<br>
	 * 
	 * @param String blSrcNo
	 * @param String arOfcCd
	 * @return List<MarkingReverseChargeVO>
	 * @exception DAOException
	 */		
	@SuppressWarnings("unchecked")
	public List<MarkingReverseChargeVO> searchMarkingReverseChargeByIfNo(String blSrcNo, String arOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MarkingReverseChargeVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{		
			
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bl_src_no", blSrcNo);
			mapVO.put("ar_ofc_cd", arOfcCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchMarkingReverseChargeByIfNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MarkingReverseChargeVO .class);
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
	 * INV_AR_MN 테이블에서 해당 BL NO로 Max IF NO인지 체크 <br>
	 * 
	 * @param String arOfcCd
	 * @param String blSrcNo
	 * @param String arIfNo
	 * @return int
	 * @exception DAOException
	 */
	public int checkMaxIfNo ( String arOfcCd, String blSrcNo, String arIfNo ) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", arOfcCd);
			mapVO.put("bl_src_no", blSrcNo);
			mapVO.put("ar_if_no", arIfNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOCheckMaxIfNoRSQL(), param, velParam);
			if(dbRowset.next()) {						
				cnt = dbRowset.getInt("CNT");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return cnt;
	}
	
	
	/**
	 * Invoice Item Correction시 CHG의 금액의 합의 체크 이벤트 처리<br>
	 * 
	 * @param String blNo
	 * @param String ofcCd
	 * @return boolean
	 * @exception DAOException
	 */	
	public boolean checkChgAmount(String blNo, String ofcCd) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		int totalAmount = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", ofcCd);
			mapVO.put("bl_src_no", blNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOCheckChgAmtRSQL(), param, velParam);
			if(dbRowset.next()) {						
				totalAmount = dbRowset.getInt("AMOUNT");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return (totalAmount == 0)?true:false ;	
	}
	
	
	/**
	 * @param ofcCd
	 * @param blSrcNo
	 * @param bkgNo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ARInvoiceChargeCorrectionVO> searchARInvoiceChargeByBL(String ofcCd, String blSrcNo, String bkgNo)throws DAOException, Exception{
		
		DBRowSet dbRowset = null;
		List<ARInvoiceChargeCorrectionVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
		try
		{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", ofcCd);
			mapVO.put("bl_src_no", blSrcNo);
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = (new SQLExecuter("")).executeQuery(new ARInvoiceCorrectionDBDAOsearchARInvoiceChargeByBLRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceChargeCorrectionVO. class);
		}
		catch(SQLException se)
		{
			log.error(se.getMessage(), se);
			throw new DAOException((new ErrorHandler(se)).getMessage(), se);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage(), ex);
			throw new DAOException((new ErrorHandler(ex)).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * @param ofcCd
	 * @param blSrcNo
	 * @param bkgNo
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchSplitARInvoiceByBL(String ofcCd, String blSrcNo, String bkgNo)throws DAOException, Exception{
		DBRowSet dbRowset = null;
		String ifNo = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
		
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", ofcCd);
			mapVO.put("bl_src_no", blSrcNo);
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = (new SQLExecuter("")).executeQuery(new ARInvoiceCorrectionDBDAOsearchSplitARInvoiceByBLRSQL(), param, velParam);
			if(dbRowset.next()){
				ifNo = dbRowset.getString("AR_IF_NO");
			}
		}
		catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException((new ErrorHandler(se)).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException((new ErrorHandler(ex)).getMessage(), ex);
		}
		return ifNo;
	}
	
	/**
	 * @param ofcCd
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public String[] searchOTSSummaryInvDup(String ofcCd) throws DAOException, Exception{
		DBRowSet dbRowset = null;
		String ret[] = new String[2];
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
	
		try{
			Map<String, String> mapVO = new HashMap<String, String>();;
			mapVO.put("ar_ofc_cd", ofcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = (new SQLExecuter("")).executeQuery(new ARInvoiceCorrectionDBDAOsearchOTSSummaryInvDupRSQL(), param, velParam);
			if(dbRowset.next()){
				ret[0] = dbRowset.getString("ots_smry_cd");
				ret[1] = dbRowset.getString("inv_dup_flg");
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException((new ErrorHandler(se)).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException((new ErrorHandler(ex)).getMessage(), ex);
		}
		return ret;
	}
	

	/**
	 * @param aRInvoiceCorrectionVO
	 * @return
	 * @throws DAOException
	 * @throws Exception
	 */
	public String searchActalSailingArrivalDate(ARInvoiceCorrectionVO aRInvoiceCorrectionVO) throws DAOException, Exception{
		DBRowSet dbRowset = null;
		String saDt = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
		
		try{
			Map<String, String> mapVO = aRInvoiceCorrectionVO.getColumnValues();
			String ioBndCd = aRInvoiceCorrectionVO.getIoBndCd();
			String polCd = aRInvoiceCorrectionVO.getPolCd();
			String podCd = aRInvoiceCorrectionVO.getPodCd(); 
			String portCd = "O/B".equals(ioBndCd)?polCd:podCd;
			mapVO.put("port_cd", portCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = (new SQLExecuter("")).executeQuery(new ARInvoiceCorrectionDBDAOsearchActalSailingArrivalDateRSQL(), param, velParam);
			if(dbRowset.next()){
				saDt = dbRowset.getString("act_sa_date");
			}
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException((new ErrorHandler(se)).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException((new ErrorHandler(ex)).getMessage(), ex);
		}
		return saDt;
	}

	/**
	 * Max interface number를 조회.
	 * 
	 * @param blSrcNo
	 * @param arOfcCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchMaxInterfaceNoByBL(String blSrcNo, String arOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String maxInterfaceNo = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", arOfcCd);
			mapVO.put("bl_src_no", blSrcNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchMaxInterfaceNoByBLRSQL(), param, velParam);
			if (dbRowset.next()) {
				maxInterfaceNo = dbRowset.getString("AR_IF_NO");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}

		return maxInterfaceNo;
	}
	
	/**
	 * DOD 건수 값을 리턴.
	 * 
	 * @param ofcCd
	 * @param invNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchDODCount(String ofcCd, String invNo) throws DAOException {
		DBRowSet dbRowset = null;
		String revType = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", ofcCd);
			mapVO.put("inv_no", invNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchDODCountRSQL(), param, velParam);
			if (dbRowset.next()) {
				revType = dbRowset.getString("REV_TYPE");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}

		return revType;
	}
	
	/**
	 * INV_AR_MN 테이블에서 인도지역 Tax Invoice 발행여부 체크 <br>
	 * 
	 * @param String arOfcCd
	 * @param String blSrcNo
	 * @return int
	 * @exception DAOException
	 */
	public int checkTaxInvoice ( String arOfcCd, String blSrcNo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", arOfcCd);
			mapVO.put("bl_src_no", blSrcNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOCheckTaxInvoiceRSQL(), param, velParam);
			if(dbRowset.next()) {						
				cnt = dbRowset.getInt("CNT");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return cnt;
	}
}