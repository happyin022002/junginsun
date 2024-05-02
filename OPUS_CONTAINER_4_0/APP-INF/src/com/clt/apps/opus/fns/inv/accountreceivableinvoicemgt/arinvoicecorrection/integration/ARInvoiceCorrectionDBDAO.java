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
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateTargetChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateTargetMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArCntrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.SysClearVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.basic.ARInvoiceCorrectionBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARCorrectionCkReturnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceChargeCorrectionVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCorrectionVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCustomerInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCustomerVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.BLRevenueVVDVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.BillInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.BkgNoCaNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ChangeCustomerInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArIfNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvByVVDVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvoiceCustomerChangeChargeVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvoiceCustomerChangeListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvoiceCustomerChangeVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.MDMCustomerVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ManualInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.RevenueVVDLaneVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceChargeSumVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * ARInvoiceCorrectionDBDAO <br>
 * - AccountReceivableInvoiceMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author saeil kim
 * @see ARInvoiceCorrectionBCImpl 참조
 * @since J2EE 1.4
 */
public class ARInvoiceCorrectionDBDAO extends DBDAOSupport {
	

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
	 * @return List<MDMCustomerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MDMCustomerVO> searchARCustomerList(String ofcCd, String custNm) throws DAOException,Exception {
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
	 * Search split customer info<br>
	 * 
	 * @param String arIfNo
	 * @return List<String>
	 * @exception DAOException
	 */
	public List<String> searchSplitCustInfo ( String arIfNo ) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", arIfNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchSplitCustInfoRSQL(), param, velParam);
			while(dbRowset.next()) {						
				list.add(dbRowset.getString("CUST_CD"));
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
	 * Search cancel target i/f list<br>
	 * 
	 * @param String arIfNo
	 * @return List<String>
	 * @exception DAOException
	 */
	public List<String> searchCancelTargetIFList ( String arIfNo ) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<String> list = new ArrayList<String>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", arIfNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchCancelTargetIFListRSQL(), param, velParam);
			while(dbRowset.next()) {						
				list.add(dbRowset.getString("AR_IF_NO"));
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
	 * Search Sailing date by i/f no<br>
	 * 
	 * @param String arIfNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchSailDateByIfNo( String arIfNo ) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		String sailDt = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", arIfNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchSailDateByIfNoRSQL(), param, velParam);
			if(dbRowset.next()) {						
				sailDt = dbRowset.getString("sail_dt");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return sailDt;
	}
	
	/**
	 * Search Split No Issue Count<br>
	 * 
	 * @param String arIfNo
	 * @return int
	 * @exception DAOException
	 */
	public int searchSplitNoIssueCount( String arIfNo ) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", arIfNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchSplitNoIssueCountRSQL(), param, velParam);
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
	 * Search Not Issued Count<br>
	 * 
	 * @param String arOfcCd
	 * @param String invNo
	 * @return int
	 * @exception DAOException
	 */
	public int searchNotIssuedCount( String arOfcCd, String invNo ) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", arOfcCd);
			mapVO.put("inv_no", invNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchNotIssuedCountRSQL(), param, velParam);
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
	 * Search I/F No list For sys clear<br>
	 * 
	 * @param SysClearVO sysClearVo
	 * @return List<SysClearVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SysClearVO> searchIFNoListForSysClear(SysClearVO sysClearVo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<SysClearVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(sysClearVo != null){
				Map<String, String> mapVO = sysClearVo .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchIFNoListForSysClearRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SysClearVO .class);
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
	 * Modify SysClear Main By IFNo<br>
	 * 
	 * @param String arIfNoA
	 * @param String arIfNoB
	 * @param String updUsrId
	 * @exception DAOException,Exception
	 */
	public void modifySysClearMainByIFNo(String arIfNoA, String arIfNoB, String updUsrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("ar_if_no1", arIfNoA);
			param.put("ar_if_no2", arIfNoB);
			param.put("upd_usr_id", updUsrId);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ARInvoiceCorrectionDBDAOModifySysClearMainByIFNoUSQL(), param, null);
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
	 * Modify SysClear Charge By IFNo<br>
	 * 
	 * @param String arIfNoA
	 * @param String arIfNoB
	 * @param String updUsrId
	 * @exception DAOException,Exception
	 */
	public void modifySysClearChgByIFNo(String arIfNoA, String arIfNoB, String updUsrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("ar_if_no1", arIfNoA);
			param.put("ar_if_no2", arIfNoB);
			param.put("upd_usr_id", updUsrId);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ARInvoiceCorrectionDBDAOModifySysClearChgByIFNoUSQL(), param, null);
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
	 * Search Invoice No by i/f no<br>
	 * 
	 * @param String arIfNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchInvNoByIfNo( String arIfNo ) throws DAOException,Exception {
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchInvNoByIfNoRSQL(), param, velParam);
			if(dbRowset.next()) {						
				invNo = dbRowset.getString("inv_no");
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
	 * Search Max i/f No by i/f no<br>
	 * 
	 * @param String arIfNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchMaxIfNo( String arIfNo ) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		String maxIfNo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", arIfNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchMaxIfNoRSQL(), param, velParam);
			if(dbRowset.next()) {						
				maxIfNo = dbRowset.getString("max_ar_if_no");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return maxIfNo;
	}
	
	/**
	 * Search issue flag by i/f no<br>
	 * 
	 * @param String arIfNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchInvIssFlgByIfNo( String arIfNo ) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		String issFlg = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", arIfNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchInvIssFlgByIfNoRSQL(), param, velParam);
			if(dbRowset.next()) {						
				issFlg = dbRowset.getString("inv_iss_flg");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return issFlg;
	}
	
	/**
	 * Search Split Count<br>
	 * 
	 * @param String arIfNo
	 * @return int
	 * @exception DAOException
	 */
	public int searchSplitCountByIfNo( String arIfNo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", arIfNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceCorrectionDBDAOSearchSplitCountByIfNoRSQL(), param, velParam);
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
}