/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingARCreationDBDAO.java
*@FileTitle : Invoice Update by User ID
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.01
*@LastModifier : 한동훈
*@LastVersion : 1.0
* 2009.06.01 한동훈
* 1.0 Creation
* -------------------------------------------------------- 
* History
* 2010.11.24 최도순 [CHM-201006704] 한국지역 WHF DEC CANCEL 정보 유관 시스템 I/F 기능 추가
* 2011.02.08 최도순 [CHM-201108232] DEM/DET 에서 INV로 INTERFACE 시 I/F NO 누락 방지를 위한 로직 변경
* 2011.04.06 최도순 [CHM-201109030-01] Intra - Europe Business 관련 VAT 기능 개발
* 2011.04.06 최도순 [CHM-201109882-01] ALPS INVOICE 내 Other Revenue Invoice Creation 로직 변경 요청
* 2011.08.04 오요한 [CHM-201111930] Invoice Issue 프로그램 개선
* 2011.10.17 오요한 [CHM-201113333] APLS INV내 INTERFACE로직 보완 요청
* 2011.10.17 오요한 [CHM-201113332] 허수데이터 정리 로직 보완 요청
* 2011.10.17 오요한 [CHM-201113779] BKG&DOC to AR INV 인터페이스 로직 보완 요청
* 2011.10.26 오요한 [] BKG INV I/F 누락 건 해결방안을 위한 로그 삽입
* 2011.10.26 권   민 [CHM-201114097] (Spain) Invoice Download for EDI
* 2012.09.11 오요한 [CHM-201219996] BKG I/F시 PAYMENT DATE 적용 - DUE DATE  (BL 단위 관리 지역)
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARCreditVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARCustPayDayVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARInvoiceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ActInvCustVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ArMainRecoveryDataVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ArOfcAgtMkVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ArOfcApplDtVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ArOfcAttributeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.BKGMainDocVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.BLNoBKGStatusVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.BkgOfcPayIndVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.CntrTypeSizeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.CoaVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ERPIfReturnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExRateCountVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ExrateMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.Fns0120001VO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.INDGstTypeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArAmtVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvBkgIfChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvBkgIfCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvSubAgnCustInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.MRIRevenueVVDLaneVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.MaxIFChgeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.MaxIFMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.RevVVDLaneVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.SysClearVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.VvdPortVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.VvdSaDtVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration.GeneralARInvoiceCreationDBDAOsearchAccountCdConversionRSQL;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration.GeneralARInvoiceCreationDBDAOsearchAccountDivisionRSQL;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration.GeneralARInvoiceCreationDBDAOsearchDueDtForMaxINVInterfaceRSQL;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration.GeneralARInvoiceCreationDBDAOsearchErpIFOfcCdRSQL;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration.GeneralARInvoiceCreationDBDAOsearchGlEffDtKorRSQL;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration.GeneralARInvoiceCreationDBDAOsearchGlEffDtOtherRSQL;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration.GeneralARInvoiceCreationDBDAOsearchLocalTimeRSQL;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration.GeneralARInvoiceCreationDBDAOsearchMriMaxYymmRSQL;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.integration.GeneralARInvoiceCreationDBDAOsearchOfficeAttributeRSQL;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.DueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARCorrectionCkReturnVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DueDateInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.InvArIfNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.InvIssVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.VVDExrateInputVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.MdmOrganizationVO;


/**
 * ALPS BookingARCreationDBDAO <br>
 * - ALPS-AccountReceivableInvoiceCreation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Han Dong Hoon
 * @see BookingARCreationBCImpl 참조
 * @since J2EE 1.6
 */ 
public class BookingARCreationDBDAO extends DBDAOSupport {	

	private static final long serialVersionUID = 1L;
	
	private String dataSource = "";
	/**
	 * BookingARCreationDBDAO 객체 생성<br>
	 * BookingARCreationDBDAO 를 생성한다.<br>
	 */
	public BookingARCreationDBDAO() { }
	
	/**
	 * BookingARCreationDBDAO 객체 생성<br>
	 * BookingARCreationDBDAO 를 생성한다.<br>
	 * @param String dataSource
	 */
	public BookingARCreationDBDAO(String dataSource) {
		this.dataSource = dataSource;
	}
	
	/**
	 * MDM_CR_CUST, MDM_ORGANIZATION 테이블에서 select<br>
	 * 
	 * @param ARInvoiceCreationVO invCreVo
	 * @return ARCreditVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ARCreditVO searchCreditCustomerForCredit(ARInvoiceCreationVO invCreVo) throws DAOException {
		DBRowSet dbRowset = null;
		ARCreditVO arCrdtVo = new ARCreditVO();
		List<ARCreditVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invCreVo != null){
				Map<String, String> mapVO = invCreVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchCreditCustomerForCreditRSQL(), param, velParam);
//			while(dbRowset.next()){
//            //port = dbRowset.getString("port");
//				arCrdtVo.setCrFlg(dbRowset.getString("cr_flg"));
//				arCrdtVo.setDueDt(dbRowset.getString("due_dt"));
//				arCrdtVo.setCrTerm(dbRowset.getString("cr_term"));
//            }
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARCreditVO .class);
			
			if (list != null && list.size() > 0) {
				arCrdtVo = (ARCreditVO) list.get(0);
			} 

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return arCrdtVo;
	}	
	
	/**
	 * MDM_ORGANIZATION 테이블에서 select<br>
	 * 
	 * @param ARInvoiceCreationVO invCreVo
	 * @return ARCreditVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ARCreditVO searchOfficeForCredit(ARInvoiceCreationVO invCreVo) throws DAOException {
		DBRowSet dbRowset = null;
		ARCreditVO arCrdtVo = new ARCreditVO();
		List<ARCreditVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(invCreVo != null){
				Map<String, String> mapVO = invCreVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchOfficeForCreditRSQL(), param, velParam);
//			while(dbRowset.next()){
//            	port = dbRowset.getString("port");
//				arCrdtVo.setCrFlg(dbRowset.getString("cr_flg"));
//				arCrdtVo.setDueDt(dbRowset.getString("due_dt"));
//				arCrdtVo.setCrTerm(dbRowset.getString("cr_term"));
//          }
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARCreditVO .class);
			
			if (list != null && list.size() > 0) {
				arCrdtVo = (ARCreditVO) list.get(0);
			} else {
				arCrdtVo = new ARCreditVO();
				
				arCrdtVo.setCrFlg("");
				arCrdtVo.setDueDt("");
				arCrdtVo.setCrTerm("");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return arCrdtVo;
	}	
	 
	/**
	 * VSK_VSL_SKD 테이블에서 select<br>
	 * 
	 * @param vvd
	 * @return String
	 * @exception DAOException
	 */
	public String searchLaneCode(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String laneCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vvd", vvd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchLaneCodeRSQL(), param, velParam);
			while(dbRowset.next()){
				laneCd = dbRowset.getString("lane_cd");

            }
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenueAcctVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return laneCd;
	}			 
		 
	/**
	 * MDM_LOCATION 테이블에서 Select<br>
	 * 
	 * @param String pol
	 * @param String pod
	 * @return String
	 * @exception DAOException
	 */
	public String searchZoneIOC(String pol, String pod) throws DAOException {
		DBRowSet dbRowset = null;
		String zoneIOC = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("pol", pol);
			mapVO.put("pod", pod);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchZoneIOCRSQL(), param, velParam);
			while(dbRowset.next()){
            	zoneIOC = dbRowset.getString("zone_ioc");

            }
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenueAcctVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return zoneIOC;
	}			 
		 
	/**
	 * MDM_LOCATION, AR_FINC_DIR_CONV, AR_ROUT_RNK, AR_MST_REV_VVD 테이블에서 select<br>
	 * 
	 * @param String vvd
	 * @param String pol
	 * @param String laneCd
	 * @param String zoneIoc
	 * @param String pod
	 * @return MRIRevenueVVDLaneVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MRIRevenueVVDLaneVO searchMRIRevenueVVDLane(String vvd, String pol, String laneCd, String zoneIoc,String pod) throws DAOException {
		DBRowSet dbRowset = null;
		MRIRevenueVVDLaneVO mriRevenueVVDLane = null;
		List<MRIRevenueVVDLaneVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vvd", vvd);
			mapVO.put("pol", pol);
			mapVO.put("pod", pod);
			mapVO.put("lane_cd", laneCd);
			mapVO.put("zone_ioc", zoneIoc);
			mapVO.put("vsl", vvd.substring(0, 4));
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchMRIRevenueVVDLaneRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MRIRevenueVVDLaneVO .class);
			
			if (list != null && list.size() > 0) {
				mriRevenueVVDLane = (MRIRevenueVVDLaneVO) list.get(0);
			} else {
				mriRevenueVVDLane = new MRIRevenueVVDLaneVO();
				
				mriRevenueVVDLane.setRevLane("");
				mriRevenueVVDLane.setRevVvd("");
				mriRevenueVVDLane.setSlaneCd("");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return mriRevenueVVDLane;
	}		 
		 
	/**
	 * MDM_ORGANIZATION 테이블에서 Select<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchCityCd(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String cityCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchCityCdRSQL(), param, velParam);
			while(dbRowset.next()){
				cityCd = dbRowset.getString("city_cd");

            }
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenueAcctVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return cityCd;
	}			 
		 
	/**
	 * BKG_BOOKING, BKG_BL_DOC 테이블에서 select<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchBLOnDate(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String blObrdDt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchBLOnDateRSQL(), param, velParam);
			while(dbRowset.next()){
				blObrdDt = dbRowset.getString("bl_obrd_dt");

            }
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenueAcctVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return blObrdDt;
	}	
	 
	/**
	 * BKG_VVD, VSK_VSL_PORT_SKD 테이블에서 select<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchSailingDate(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String vpsEtdDt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchSailingDateRSQL(), param, velParam);
			while(dbRowset.next()){
				vpsEtdDt = dbRowset.getString("vps_etd_dt");

            }
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenueAcctVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return vpsEtdDt;
	}	
	 
	/**
	 * AP_PERIOD 테이블에서  select<br>
	 * 
	 * @param String ofcCd
	 * @param String sailDt
	 * @param String revTpCd
	 * @param String revSrcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchEffectiveDate(String ofcCd, String sailDt, String revTpCd, String revSrcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String effDt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("sail_dt", sailDt);
			mapVO.put("rev_tp_cd", revTpCd);
			mapVO.put("rev_src_cd", revSrcCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchEffectiveDateRSQL(), param, velParam);
			while(dbRowset.next()){
				effDt = dbRowset.getString("eff_dt");

            }
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenueAcctVO .class);
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
	 * MDM_CUSTOMER 테이블에서 select<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return String
	 * @exception DAOException
	 */
	public String searchInterCompany(String custCntCd, String custSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String subsCoCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cust_cnt_cd", custCntCd);
			mapVO.put("cust_seq", custSeq);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchInterCompanyRSQL(), param, velParam);
			while(dbRowset.next()){
				subsCoCd = dbRowset.getString("subs_co_cd");

            }
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenueAcctVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return subsCoCd;
	}	
			 
	/**
	 * INV_REV_ACCT_CD 테이블에서 select<br>
	 * 
	 * @param String revType
	 * @return String
	 * @exception DAOException
	 */
	public String searchAccountDivision(String revType) throws DAOException {
		DBRowSet dbRowset = null;
		String acctDivCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("rev_type", revType);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchAccountDivisionRSQL(), param, velParam);
			while(dbRowset.next()){
				acctDivCd = dbRowset.getString("acct_div_cd");

            }
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenueAcctVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return acctDivCd;
	}		
	 
	/**
	 * MDM_CHARGE 테이블에서 Select<br>
	 * 
	 * @param String chgCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchAccountCdFromCharge(String chgCd) throws DAOException {
		DBRowSet dbRowset = null;
		String acctCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("chg_cd", chgCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchAccountCdFromChargeRSQL(), param, velParam);
			while(dbRowset.next()){
				acctCd = dbRowset.getString("acct_cd");

            }
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenueAcctVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return acctCd;
	}	 
	 
	/**
	 * INV_REV_ACCT_CD 테이블에서 select<br>
	 * 
	 * @param String chgCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchAccountCdFromRevAcct(String chgCd) throws DAOException {
		DBRowSet dbRowset = null;
		String acctCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("chg_cd", chgCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchAccountCdFromRevAcctRSQL(), param, velParam);
			while(dbRowset.next()){
				acctCd = dbRowset.getString("acct_cd");

            }
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenueAcctVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return acctCd;
	}		 
	 
	
	
	/**
	 * INV_AR_MN table 저장<br>
	 * 
	 * @param InvArMnVO invMain
	 * @exception DAOException
	 */
	  public void addInvMain(InvArMnVO invMain) throws DAOException {
		
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = invMain.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new BookingARCreationDBDAOaddInvMainCSQL(), paramMap, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	
	}	 	
	 
	/**
	 * INV_AR_AMT table 저장<br>
	 * 
	 * @param List<InvArAmtVO> invAmts
	 * @exception DAOException
	 */                  
    public void addInvAmount(List<InvArAmtVO> invAmts ) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int insCnt[] = null;
			if (invAmts.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new BookingARCreationDBDAOaddInvAmountCSQL(), invAmts, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    
    }	 
	 
	/**
	 * INV_AR_CHG table 저장<br>
	 * 
	 * @param List<InvArChgVO> invChges
	 * @exception DAOException
	 */
    public void addInvCharge(List<InvArChgVO> invChges ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int insCnt[] = null;
			if (invChges.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new BookingARCreationDBDAOaddInvChargeCSQL(), invChges, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    }	
    
    /**
     * Container 정보를 생성한다. <br>
     * 
     * @param List<InvArCntrVO> invCntrs
     * @param String userId
     * @exception DAOException
     */
    public void addInvContainer(List<InvArCntrVO> invCntrs ,String userId) throws DAOException {
		try {
			for (int j = 0; j < invCntrs.size(); j++) {
				invCntrs.get(j).setCreUsrId(userId);
			}	
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int insCnt[] = null;
			if (invCntrs.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new BookingARCreationDBDAOaddInvContainerCSQL(), invCntrs, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    
    }		 
	 
	 
    /**
	 * IINV_AR_MN 테이블에 Update<br>
	 * 
	 * @param String ifNo
	 * @param String userID
	 * @exception DAOException
	 */
    public void modifyInvoiceUserID(String ifNo , String userID) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", ifNo);
			mapVO.put("upd_usr_id", userID);								
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOInvoiceUserIdUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * INV_AR_MN 테이블에 Update<br>
	 * 
	 * @author JungJin Park
	 * @param List<SysClearVO> sysClearVos
	 * @return int
	 * @exception DAOException, Exception
	 */
	public int modifyMainSysClearList(List<SysClearVO> sysClearVos) throws DAOException,Exception {
		int result = 0;
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			int insCnt[] = null;
			
			if(sysClearVos != null && sysClearVos.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BookingARCreationDBDAOModifyMainSysClearListUSQL(), sysClearVos,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
				
				result = sysClearVos.size();
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}
    
	/**
	 * INV_AR_CHG 테이블에 Update<br>
	 * 
	 * @author JungJin Park
	 * @param List<SysClearVO> sysClearVos
	 * @exception DAOException, Exception
	 */
	public void modifyChgSysClearList(List<SysClearVO> sysClearVos) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			int insCnt[] = null;
			
			if(sysClearVos != null && sysClearVos.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BookingARCreationDBDAOModifyChgSysClearListUSQL(), sysClearVos,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
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
	 * INV_AR_MN 테이블에 update<br>
	 * @param InvArMnVO invMain
	 * @param String userId 
	 * @exception DAOException
	 */	 
	public void modifyARInvoiceMain (InvArMnVO invMain,String userId ) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			invMain.setUpdUsrId(userId);				
			Map<String, String> mapVO = invMain.getColumnValues();		
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifyARInvoiceMainVOUSQL(), param, velParam);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	 
	 
	 
	/**
	 * INV_AR_CHG 테이블에 update<br>
	 * @param List<InvArChgVO> invChges
	 * @param String userId
	 * @exception DAOException
	 */	 
	 
	public void modifyARInvoiceCharge (List<InvArChgVO> invChges ,String userId) throws DAOException,Exception {
		try {
			
			for (int j = 0; j < invChges.size(); j++) {
				invChges.get(j).setUpdUsrId(userId);
			}	
			
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int updCnt[] = null;
			if(invChges.size() > 0){
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new BookingARCreationDBDAOModifyARInvoiceChargeVOUSQL(), invChges, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	 
	
	/**
	 * INV_AR_AMT 테이블에 update<br>
	 * @param List<InvArAmtVO> invAmts
	 * @exception DAOException
	 */	 
	 
	public void modifyARInvoiceAmount (List<InvArAmtVO> invAmts) throws DAOException,Exception {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int updCnt[] = null;
			if(invAmts.size() > 0){
				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new BookingARCreationDBDAOModifyARInvoiceAmountUSQL(), invAmts, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	 
    /**
     * INV_AR_CNTR 테이블에서 DELETE. <br>
     * 
     * @param String ifNo
     * @exception DAOException
     */
	public void removeARInvoiceContainer(String ifNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", ifNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAORemoveARInvoiceContainerVODSQL(), param, velParam);
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
     * INV_AR_CHG 테이블에서 DELETE. <br>
     * 
     * @param String ifNo
     * @exception DAOException
     */
	public void removeARInvoiceCharge(String ifNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", ifNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAORemoveARInvoiceChargeDSQL(), param, velParam);
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
     * INV_AR_AMT 테이블에서 DELETE. <br>
     * 
     * @param String ifNo
     * @exception DAOException
     */
	public void removeARInvoiceAmount(String ifNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", ifNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAORemoveARInvoiceAmountDSQL(), param, velParam);
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
  	* Account Rate 테이블에서 Select<br>
  	* 
  	* @param  String effDt
	* @return int
	* @exception DAOException
	*/
	public int checkAccountRateExist ( String effDt )throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("eff_dt", effDt);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOCheckAccountRateExistRSQL(), param, velParam);
			if(dbRowset.next()) {						
				cnt = dbRowset.getInt("cnt");
	    	}
			log.info("cnt==>"+cnt);

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
  	* INV_AR_MN 테이블에서 Select<br>
  	* 
	* @param String ifNo
	* @return List<InvArMnVO>
	* @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<InvArMnVO> searchARInvoice ( String ifNo ) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArMnVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("if_no", ifNo);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchARInvoiceRSQL(), param, velParam);
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
  	* INV_AR_CHG에서 AR_IF_NO로 조회함.<br>
  	* 
	* @param String ifNo
	* @return  List<InvArChgVO>
	* @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<InvArChgVO> searchARInvoiceCharge ( String ifNo ) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArChgVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("if_no", ifNo);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchARInvoiceChargeVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArChgVO .class);
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
  	* INV_AR_CNTR에서 AR_IF_NO로 조회함.<br>
  	* 
	* @param String ifNo
	* @return List<InvArCntrVO>
	* @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<InvArCntrVO> searchARInvoiceContainer ( String ifNo ) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArCntrVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("if_no", ifNo);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchARInvoiceContainerVORSQL(), param, velParam);
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
  	* INV_AR_AMT에서 AR_IF_NO로 조회함.<br>
  	* 
	* @param String ifNo
	* @return List<InvArAmtVO>
	* @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<InvArAmtVO> searchARInvoiceAmount ( String ifNo ) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArAmtVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("if_no", ifNo);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchARInvoiceAmountVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArAmtVO .class);
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
  	* Interface Number 테이블에서 Select<br>
  	* 
	* @param  String ofcCd
	* @return String
	* @exception DAOException
	*/
	public String searchNewInterfaceNo ( String ofcCd )throws DAOException {
		DBRowSet dbRowset = null;
		String maxSeq = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchNewInterfaceNoVORSQL(), param, velParam);
			if(dbRowset.next()) {						
				maxSeq = dbRowset.getString("maxSeq");
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
	 * INV_AR_BKG_IF_NO 테이블에 insert<br>
	 * 
	 * @param String ofcCd
	 * @param String userId
	 * @exception DAOException
	 */
	public void addNewInterfaceNo(String ofcCd,String userId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("cre_usr_id", userId);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOAddNewInterfaceNoVOCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}

	
	/**
	 * INV_AR_BKG_IF_NO 테이블에 update<br>
	 * 
	 * @param String ofcCd
	 * @param String maxSeq
	 * @param String userId
	 * @exception DAOException
	 */
	public void modifyNewInterfaceNo(String ofcCd,String maxSeq,String userId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		log.info("user:"+userId);
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("upd_usr_id", userId);
			mapVO.put("max_seq", maxSeq);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifyNewInterfaceNoVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * flag='good' 인 경우   INV_AR_MN 의 BL_INV_CFM_DT 에 Local time의 YYYYMMDD 를 Update <br>
	 * [경리환율에따라 ] INV_AR_MN.BL_INV_CFM_DT 컬럼을 Update 하고 종료<br>
	 * 
	 * @param String ifNo
	 * @param String flag
	 * @param String arOfcCd
	 * @param String blSrcNo
	 * @exception DAOException
	 */
	public void modifyCFMDate(String ifNo,String flag,String arOfcCd, String blSrcNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("if_no", ifNo);
			mapVO.put("flag", flag);
			mapVO.put("ar_ofc_cd", arOfcCd);
			mapVO.put("bl_src_no", blSrcNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifyCFMDateVOUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * FNS_INV_0017  Customer정보를 수정한다.<br>
	 * 
	 * @param InvArMnVO invArMnVO
	 * @exception DAOException
	 */	 
	 
	public void modifyCustomerCode(InvArMnVO invArMnVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {			
			
			Map<String, String> mapVO = invArMnVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifyCustomerCodeUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * FNS_INV_0017  Customer정보를 수정한다. INV_AR_CHG 환율저장<br>
	 * 
	 * @param List<InvArChgVO> invChges
	 * @exception DAOException
	 */
    public void modifyInvCharge(List<InvArChgVO> invChges ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int insCnt[] = null;
			if (invChges.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				
				insCnt = sqlExe.executeBatch((ISQLTemplate) new BookingARCreationDBDAOModifyInvChargeUSQL(), invChges, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    
    }	
    /**
	 *  VLCSC의 EDI 다운로드 받은 해당 데이터에 대해서 INV_AR_MN의 EDI_SND_DT = SYSDATE를 update 한다.<br>
	 * 
	 * @param String ofcCd
	 * @param String issDate
	 * @exception DAOException
	 */
    public void modifyEDISendDate (String ofcCd, String issDate) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", ofcCd);
			mapVO.put("iss_dt", issDate.replaceAll("-", ""));
			mapVO.put("update_dt", issDate.replaceAll("-", ""));
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifyEDISendDateUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
    
    /**
	 *  VLCSC의 EDI 다운로드 했던 데이터에 대해서 INV_AR_MN의 EDI_SND_DT 값을 Null 를 update 한다.<br>
	 * 
	 * @param String fmInvNo
	 * @param String toInvNo
	 * @exception DAOException
	 */
    public void modifyEDISendDataRelease (String fmInvNo, String toInvNo) throws DAOException,Exception {
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("fm_inv_no", fmInvNo);
			mapVO.put("to_inv_no", toInvNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOmodifyEDISendDataReleaseUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
    
    /**
     * Issue Flag 정보를 수정합니다. <br>
     * 
     * @param String invNo
     * @param String issFlg
     * @param String userId
     * @exception DAOException
     */
	public void modifyIssueFlag(String invNo, String issFlg, String userId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {			
			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("inv_no", invNo);
			mapVO.put("iss_flg", issFlg);
			mapVO.put("user_id", userId);
			param.putAll(mapVO);
			velParam.putAll(mapVO);				
			
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOmodifyIssueFlagUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}	
	
	/**
     * Main의 Issue Flag 정보를 수정합니다. <br>
     * 
     * @param String invNo
     * @param String issFlg
     * @param String userId
     * @exception DAOException
     */
	public void modifyIssueFlagMain(String invNo, String issFlg, String userId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {			
			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("inv_no", invNo);
			mapVO.put("iss_flg", issFlg);
			mapVO.put("user_id", userId);
			param.putAll(mapVO);
			velParam.putAll(mapVO);				
			
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOmodifyIssueFlagMainUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}	
	
    /**
     * Due Date 정보를 수정합니다. <br>
     * 
     * @param String ifNo
     * @param String dueDt
     * @param String userId
     * @exception DAOException
     */
	public void modifyDueDate(String ifNo, String dueDt, String userId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {			
			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("if_no", ifNo);
			mapVO.put("due_dt", dueDt);
			mapVO.put("user_id", userId);
			param.putAll(mapVO);
			velParam.putAll(mapVO);				
			
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOmodifyDueDateUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
    /**
     * BKG NO로 BKG_QUANTITY 에서 TEU, FEU를 구함. <br>
     * 
     * @param String bkgNo
     * @return InvArMnVO
     * @exception DAOException
     */
	public InvArMnVO searchTeuFeu(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		InvArMnVO invArMnVO = new InvArMnVO();
		String bkgTeuQty = "";
		String bkgFeuQty = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
	
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);					

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchTeuFeuRSQL(), param, velParam);
            if(dbRowset.next()) {						
            	bkgTeuQty = dbRowset.getString("teu");
            	bkgFeuQty = dbRowset.getString("feu");
            	invArMnVO.setBkgTeuQty(bkgTeuQty);
            	invArMnVO.setBkgFeuQty(bkgFeuQty);
	    	}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return invArMnVO;
	}	
	
    /**
     * BKG NO로 BKG_REFERENCE 에서 REF NUMBER를 구함. <br>
     * 
     * @param String bkgNo
     * @return String
     * @exception DAOException
     */
	public String searchInvRefNumber(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String invRefNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
	
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);					

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchInvRefNumberRSQL(), param, velParam);
            if(dbRowset.next()) {						
            	invRefNo = dbRowset.getString("cust_ref_no_ctnt");
	    	}
            
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return invRefNo;
	}	
	
	/**
     * BKG NO로 BKG_REFERENCE 에서 REF NUMBER를 구함. <br>
     * 
     * @param String bkgNo
     * @param String invNo
     * @param String arOfcCd
     * @return String
     * @exception DAOException
     */
	public String searchInvRefNumberRe(String bkgNo, String invNo, String arOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String invRefNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
	
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("inv_no", invNo);
			mapVO.put("ar_ofc_cd", arOfcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);					

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchInvRefNumberReRSQL(), param, velParam);
            if(dbRowset.next()) {						
            	invRefNo = dbRowset.getString("cust_ref_no_ctnt");
	    	}
            
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return invRefNo;
	}	
	
    /**
     * INV_AR_MN 테이블의 TEU, FEU, INV REF NO를 UPDATE. <br>
     * 
     * @param InvArMnVO invArMnVO
     * @param String userId
     * @exception DAOException
     */
	public void modifyTeuFeuInvRefNumber(InvArMnVO invArMnVO, String userId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {			
			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("if_no", invArMnVO.getArIfNo());
			mapVO.put("bkg_teu_qty", invArMnVO.getBkgTeuQty());
			mapVO.put("bkg_feu_qty", invArMnVO.getBkgFeuQty());
			mapVO.put("inv_ref_no", invArMnVO.getInvRefNo());
			mapVO.put("user_id", userId);
			param.putAll(mapVO);
			velParam.putAll(mapVO);				
			
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOmodifyTeuFeuInvRefNumberUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
    /**
     * INV_AR_MN 테이블에  INV_RMK를  UPDATE. <br>
     * 
     * @param String ifNo
     * @param String invRmk
     * @param String userId
     * @exception DAOException
     */
	public void modifyInvoiceRemark(String ifNo, String invRmk, String userId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {			
			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("if_no", ifNo);
			mapVO.put("inv_rmk", invRmk);
			mapVO.put("user_id", userId);
			param.putAll(mapVO);
			velParam.putAll(mapVO);				
			
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOmodifyInvoiceRemarkUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
	
    /**
     * BKG_CONTAINER 테이블에서 CNTR_NO, CNTR_TPSZ_CD 을 구한다. <br>
     * 
     * @param String bkgNo
     * @return List<InvArCntrVO>
     * @exception DAOException
     */
	@SuppressWarnings("unchecked")
	public List<InvArCntrVO> searchBKGContainerList(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArCntrVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchBKGContainerListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArCntrVO .class);
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
     * INVOICE NUMBER로 MAX(IF_NO), BKG_NO를 구한다. <br>
     * 
     * @param String invNo
     * @return List<InvArMnVO>
     * @exception DAOException
     */
	@SuppressWarnings("unchecked")
	public List<InvArMnVO> searchMaxIFNoBKGNoByINVNo(String invNo) throws DAOException {
		DBRowSet dbRowset = null;
//		InvArMnVO invArMnVO = new InvArMnVO();
		List<InvArMnVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("inv_no", invNo);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchMaxIFNoBKGNoByINVNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArMnVO .class);
			
//			if (list != null && list.size() > 0) {
//				invArMnVO = (InvArMnVO) list.get(0);
//			} else {
//				invArMnVO.setBkgNo("");
//			}
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
     * INVOICE NUMBER로 MAX(IF_NO), BKG_NO를 구한다. <br>
     * 
     * @param String invNo
     * @return InvArMnVO
     * @exception DAOException
     */
	@SuppressWarnings("unchecked")
	public InvArMnVO searchMaxIFNoBKGNoTypeMByINVNo(String invNo) throws DAOException {
		DBRowSet dbRowset = null;
		InvArMnVO invArMnVO = new InvArMnVO();
		List<InvArMnVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("inv_no", invNo);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchMaxIFNoBKGNoTypeMByINVNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArMnVO .class);
			
			if (list != null && list.size() > 0) {
				invArMnVO = (InvArMnVO) list.get(0);
			} else {
				invArMnVO.setBkgNo("");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return invArMnVO;
	}
	
	/**
	 * center, customer 테이블에서 select<br>
	 * @author Jung Jin Park
	 * @param String ofcCd
	 * @return CoaVO
	 * @exception DAOException
	 */	
	public CoaVO searchCOA(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		CoaVO returnCoaVO = new CoaVO();
		
		String invCoaCtrCd = null;
		String invCoaRgnCd = null;
		String invCoaCoCd = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("ar_ofc_cd", ofcCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);					

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchCOARSQL(), param, velParam);
            if(dbRowset.next()) {						
            	invCoaCtrCd = dbRowset.getString("inv_coa_ctr_cd");
            	invCoaRgnCd = dbRowset.getString("inv_coa_rgn_cd");
            	invCoaCoCd = dbRowset.getString("inv_coa_co_cd");
            	
            	returnCoaVO.setInvCoaCtrCd(invCoaCtrCd);
            	returnCoaVO.setInvCoaRgnCd(invCoaRgnCd);
            	returnCoaVO.setInvCoaCoCd(invCoaCoCd);
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return returnCoaVO;
	}
	
	
	/**
	 * Ex Rate Update by Date or VVD의 환율적용대상 data 를 Chg 테이블 업데이트<br>
	 * 
	 * @param ExrateChgVO exrateChgVO
	 * @exception DAOException
	 */	
	public void modifyInvoiceExrateChg(ExrateChgVO exrateChgVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {			
			
			Map<String, String> mapVO = exrateChgVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);				
			
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifyInvoiceExrateChgUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * Ex Rate Update by Date or VVD의 환율적용대상 data 를 Main 테이블 업데이트<br>
	 * 
	 * @param ExrateMainVO exrateMainVO
	 * @exception DAOException
	 */	
	public void modifyInvoiceExrateMain(ExrateMainVO exrateMainVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {			
			
			Map<String, String> mapVO = exrateMainVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);				
			
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifyInvoiceExrateMainUSQL(), param,velParam);
			
			if(result == Statement.EXECUTE_FAILED) throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Split, Item Correction, Customer 변경시 in_ar_mn 테이블 split_cd 변경 <br>
	 * 
	 * @param String ifNo
	 * @param String splitCd
	 * @param String usrId
	 * @exception DAOException
	 */
	
	public void modifySplitCode(String ifNo, String splitCd, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", ifNo);
			mapVO.put("inv_split_cd", splitCd);
			mapVO.put("upd_usr_id", usrId);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifySplitCodeUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Split, Item Correction, Customer 변경시 inv_ar_chg , inv_ar_mn 테이블 inv_iss_flg,inv_clr_flg 변경 <br>
	 * 
	 * @param String ifNo
	 * @param String usrId
	 * @exception DAOException
	 */
	
	public void modifySysClear(String ifNo, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", ifNo);
			mapVO.put("upd_usr_id", usrId);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifySysClearUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update INV_AR_CHG SQL");
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifySysClearMainUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update INV_AR_MN SQL");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ERP에 전송할 Invoice 정보를 조회합니다. <br>
	 * 
	 * @param String ifNo 
	 * @param String flag
	 * @return List<Fns0120001VO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<Fns0120001VO> searchARInvoiceForERP(String ifNo, String flag) throws DAOException {
		DBRowSet dbRowset = null;
		List<Fns0120001VO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("if_no", ifNo);
			mapVO.put("flag", flag);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			// 2010.01.06 정휘택
			// GeneralARInvoiceCreationDBDAOsearchARInvoiceForERPRSQL 과 동일한 SQL 입니다
			// 수정시 GeneralARInvoiceCreationDBDAOsearchARInvoiceForERPRSQL 도 같이 수정해 주십시요
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchARInvoiceForERPRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, Fns0120001VO .class);
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
	 * ERP에 전송할 Container Type 정보를 조회합니다. <br>
	 * 
	 * @param String ifNo
	 * @return List<CntrTypeSizeVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CntrTypeSizeVO> searchCntrTpSzForERP(String ifNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CntrTypeSizeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("if_no", ifNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO); 
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchCntrTpSzForERPRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrTypeSizeVO .class);
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
	 * FNS012-R001에서 Return받는 정보(Return Flag 및 Error message)를 INV_AR_AMT에 update 함. <br>
	 * 
	 * @param List<ERPIfReturnVO> erpIfReturnVOs
	 * @exception DAOException
	 */
    public void modifyARInvoiceERPReturn(List<ERPIfReturnVO> erpIfReturnVOs) throws DAOException, Exception {
    	log.debug("########## modifyARInvoiceERPReturn:DAO");	
    	try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int updCnt[] = null;
			if (erpIfReturnVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new BookingARCreationDBDAOmodifyARInvoiceERPReturnUSQL(), erpIfReturnVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
    
	/**
	 * Terminal MQ에 전송할 정보를 조회합니다. <br>
	 * 
	 * @param String ifNo
	 * @return InvArMnVO
	 * @exception DAOException
	 */
    @SuppressWarnings("unchecked")
	public InvArMnVO searchTerminalInvoice(String ifNo) throws DAOException {
		DBRowSet dbRowset = null;
		InvArMnVO invArMnVO = new InvArMnVO();
		List<InvArMnVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", ifNo);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchTerminalInvoiceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArMnVO .class);
			
			if (list != null && list.size() > 0) {
				invArMnVO = (InvArMnVO) list.get(0);
			} else {
				invArMnVO.setBkgNo("");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return invArMnVO;
	}
	
	/**
	 * SYS CLEAR 대상 INTERFACE NUMBER를 구한다.<br>
	 * 
	 * @author JungJin Park
	 * @param SysClearVO sysClearVo
	 * @return SysClearVO
	 * @exception EventException
	 */		
	@SuppressWarnings("unchecked")
	public List<SysClearVO> searchInterfaceNumberListForSysClear (SysClearVO sysClearVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SysClearVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("ar_ofc_cd", sysClearVo.getOfcCd());
			mapVO.put("bl_src_no", sysClearVo.getBlNo());
			
			if (!"".equals(sysClearVo.getVvdCd())) {
				mapVO.put("vsl_cd", sysClearVo.getVvdCd().substring(0, 4));
				mapVO.put("skd_voy_no", sysClearVo.getVvdCd().substring(4, 8));
				mapVO.put("skd_dir_cd", sysClearVo.getVvdCd().substring(8, 9));
			}
			if (!"".equals(sysClearVo.getCustCd())) {
				mapVO.put("act_cust_cnt_cd", sysClearVo.getCustCd().substring(0, 2));
				mapVO.put("act_cust_seq", sysClearVo.getCustCd().substring(2));
			}
			mapVO.put("upd_usr_id", sysClearVo.getUserId());

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchInterfaceNoListForSysClearRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SysClearVO .class);
//			if (list != null && list.size() > 0) {
//				sysClearVo.setSysClearIfNoVO(list);
//			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		//return sysClearVo;
		return list;
		
	}
	
	
	/**
	 * INV_BKG_IF_MN 테이블에서 BKG Status 조회<br>
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @return BLNoBKGStatusVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BLNoBKGStatusVO searchBLNoByBKGNo(String bkgNo, String bkgSeq) throws DAOException {
		DBRowSet dbRowset = null;
		BLNoBKGStatusVO bLNoBKGStatusVO = null;
		List<BLNoBKGStatusVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchBLNoByBKGNoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BLNoBKGStatusVO .class);
			
			if (list != null && list.size() > 0) {
				bLNoBKGStatusVO = (BLNoBKGStatusVO) list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bLNoBKGStatusVO;
	}
	
	/**
	 * INV_AR_MN 테이블에서 select<br>
	 * 
	 * @param String blNo
	 * @return List<MaxIFMainVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MaxIFMainVO> searchMaxInterfaceList (String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<MaxIFMainVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bl_no", blNo);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchMaxInterfaceListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MaxIFMainVO .class);
			
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
	 * INV_AR_CHG 테이블에서 Select<br>
	 * 
	 * @param String blSrcNo
	 * @param String ofcCd
	 * @param String whfChk
	 * @return List<MaxIFChgeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MaxIFChgeVO> searchChargeListForMaxInterface (String blSrcNo, String ofcCd, String whfChk) throws DAOException {
		DBRowSet dbRowset = null;
		List<MaxIFChgeVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bl_no", blSrcNo);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("whf_chk", whfChk);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchChargeListForMaxInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MaxIFChgeVO .class);
			
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
     * INV_AR_MN 에 WHF Dec 여부와 INV_AR_CHG 에 WHF charge 존재여부 체크<br>
     * 
     * @param String maxIfNo
     * @return int
     * @exception DAOException
     */
	public int checkDecWHF(String maxIfNo) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
	
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("ar_if_no", maxIfNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);					

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOCheckDecWHFRSQL(), param, velParam);
            if(dbRowset.next()) {						
            	cnt = dbRowset.getInt("cnt");
	    	}
            
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}	
	
	/**
  	* Interface Number 테이블에서 Select<br>
  	* 
	* @param  String ofcCd
	* @return String
	* @exception DAOException
	*/
	public String searchBKGInterfaceNo ( String ofcCd )throws DAOException {
		DBRowSet dbRowset = null;
		String maxSeq = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchBKGInterfaceNoRSQL(), param, velParam);
			if(dbRowset.next()) {						
				maxSeq = dbRowset.getString("maxSeq");
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
	 * INV_AR_CHG, INV_AR_MN 테이블에 Update ( 이전 IF NO와 canceData IF NO간의  SYS CLEAR) <br>
	 * 
	 * @param String maxIfNo
	 * @param String cancelIfNo
	 * @param String usrId
	 * @return int
	 * @exception DAOException
	 */	
	public int modifySysClearFlag(String maxIfNo, String cancelIfNo, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		DBRowSet dbRowset = null;	
		int result = 0;
		String otsSmryCd = "";
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("max_if_no", maxIfNo);
			mapVO.put("cancel_if_no", cancelIfNo);
			mapVO.put("upd_usr_id", usrId);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifySysClearFlagUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update INV_AR_CHG SQL");
			
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifySysClearFlagMainUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update INV_AR_MN SQL");
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchOTSSummaryRSQL(), param, velParam);
			if(dbRowset.next()) {						
				otsSmryCd = dbRowset.getString("ots_smry_cd");
	    	}
			
			if(result==2&&otsSmryCd.equals("INV")){
				result=2;
			}else{
				result=0;
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return result;
	}
	
	/**
	 * INV_AR_MN 테이블에 INV_DELT_DIV_CD Update <br>
	 * 
	 * @param String maxIfNo
	 * @param String usrId
	 * @exception DAOException
	 */	
	public void modifyDelCode(String maxIfNo, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", maxIfNo);
			mapVO.put("upd_usr_id", usrId);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifyDelCodeUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * INV_BKG_IF_MN table 저장<br>
	 * 
	 * @param String bkgNo
	 * @param String bkgCorrNo
	 * @param String userId
	 * @return String
	 * @exception DAOException
	 */
	  @SuppressWarnings("unchecked")
	public String addInvBkgIf( String bkgNo, String bkgCorrNo, String userId )  throws DAOException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		DBRowSet dbRowset = null;
		String maxBkgSeq = null;
		//int cnt = 0 ;
		try {			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bkg_no", bkgNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter(dataSource);		
			
			dbRowset = sqlExe.executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchMaxBkgSeqRSQL(), param, velParam);
			if(dbRowset.next()) {						
				maxBkgSeq = dbRowset.getString("max_bkg_seq");
	    	}			
			
			mapVO.put("bkg_seq", maxBkgSeq);
			mapVO.put("user_id", userId);
			mapVO.put("bkg_corr_no", bkgCorrNo);
			mapVO.put("whf_decl_cxl_flg", "");
			mapVO.put("o_result", "");
			mapVO.put("o_err_msg", "");
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			rtnMap = new SQLExecuter(dataSource).executeSP((ISQLTemplate)new BookingARCreationDBDAOAddInvBkgIfTblCSQL(), param, velParam);
			
			log.debug("---------------------------------------------------------");
			log.debug("rtnMap:" + rtnMap);
			
			String result = rtnMap.get("o_result")==null?"":(String)rtnMap.get("o_result");
			String errMsg = rtnMap.get("o_err_msg")==null?"":(String)rtnMap.get("o_err_msg");
            
			log.debug("---------------------------------------------------------");
			
			//dbRowset = sqlExe.executeQuery((ISQLTemplate)new BookingARCreationDBDAOCheckInvBkgIfTblRSQL(), param, velParam);
			//if(dbRowset.next()) {						
			//	cnt = Integer.parseInt(dbRowset.getString("cnt"));
	    	//}	
			
			//cnt = sqlExe.executeUpdate((ISQLTemplate) new BookingARCreationDBDAOAddInvBkgIfMnCSQL(), param, velParam);			
			//sqlExe.executeUpdate((ISQLTemplate) new BookingARCreationDBDAOAddInvBkgIfChgCSQL(), param, velParam);			
			//sqlExe.executeUpdate((ISQLTemplate) new BookingARCreationDBDAOAddInvBkgIfCntrCSQL(), param, velParam);
			
			if(!result.equals("S")){
				maxBkgSeq =null;
			}
			//if(cnt==0){
			//	maxBkgSeq =null;
			//}
			log.debug("bkg_corr_no="+bkgCorrNo);
			log.debug("result="+result);
			log.debug("errMsg="+errMsg);			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		
		return maxBkgSeq;	
	}	
	
    
    /**
  	* INV_BKG_IF_MN 테이블에서 MAx BKG_SEQ Select<br>
  	* 
	* @param  String bkgNo
	* @return String
	* @exception DAOException
	*/
	public String searchMaxBkgSeq ( String bkgNo )throws DAOException {
		DBRowSet dbRowset = null;
		String maxBkgSeq = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchMaxBkgSeqRSQL(), param, velParam);
			if(dbRowset.next()) {						
				maxBkgSeq = dbRowset.getString("max_bkg_seq");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return maxBkgSeq;
	}
	
	/**
	 * INV_BKG_IF_OFC_CUST 테이블에서 해당 BKG_NO의 OFC List select<br>
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @return List<BkgOfcPayIndVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgOfcPayIndVO> searchBKGOfficeList (String bkgNo, String bkgSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgOfcPayIndVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchBKGOfficeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgOfcPayIndVO .class);
			
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
	 * INV_BKG_IF_OFC_CUST 테이블에서 해당 BKG_NO의 OFC List select<br>
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @return List<BkgOfcPayIndVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgOfcPayIndVO> searchBKGOfficeAsCutOffList (String bkgNo, String bkgSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgOfcPayIndVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
		
		try{
			
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchBKGOfficeAsCutOffListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgOfcPayIndVO .class);
			
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
  	* INV_BKG_IF_MN 테이블에서 PORT 조회<br>
  	* 
	* @param  String bkgNo
	* @param  String bkgSeq
	* @param  String ioBndCd
	* @return VvdPortVO
	* @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public VvdPortVO searchPort ( String bkgNo, String bkgSeq, String ioBndCd )throws DAOException {
		DBRowSet dbRowset = null;
		VvdPortVO vvdPortVO = new VvdPortVO();
		List<VvdPortVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			mapVO.put("io_bnd_cd", ioBndCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchPortRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdPortVO .class);
			
			if (list != null && list.size() > 0) {
				vvdPortVO = (VvdPortVO) list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return vvdPortVO;
	}
	
	/**
	 * INV_BKG_IF_MN 테이블에서 VVD,SaDt 조회<br>
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @param String portCd
	 * @param String ioBndCd
	 * @return VvdSaDtVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public VvdSaDtVO searchVVDSaDt(String bkgNo, String bkgSeq, String portCd, String ioBndCd) throws DAOException {
		DBRowSet dbRowset = null;
		VvdSaDtVO vvdSaDtVO = new VvdSaDtVO();
		List<VvdSaDtVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			mapVO.put("port_cd", portCd);
			mapVO.put("io_bnd_cd", ioBndCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchVVDSaDtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdSaDtVO .class);
			
			if (list != null && list.size() > 0) {
				vvdSaDtVO = (VvdSaDtVO) list.get(0);
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vvdSaDtVO;
	}
	
	/**
	 * INV_BKG_IF_MN 테이블에서 TVVD, Port 조회<br>
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @param String ioBndCd
	 * @return VvdSaDtVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public VvdPortVO searchTvvdPort(String bkgNo, String bkgSeq, String ioBndCd) throws DAOException {
		DBRowSet dbRowset = null;
		VvdPortVO vvdPortVO = new VvdPortVO();
		List<VvdPortVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			mapVO.put("io_bnd_cd", ioBndCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchTvvdPortRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VvdPortVO .class);
			
			if (list != null && list.size() > 0) {
				vvdPortVO = (VvdPortVO) list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return vvdPortVO;
	}
	
	/**
  	* INV_BKG_IF_MN 테이블에서 SaDt 조회<br>
  	* 
	* @param  String vvd
	* @param  String portCd
	* @param  String ioBndCd
	* @return String
	* @exception DAOException
	*/
	public String searchTrunkSaDt( String vvd, String portCd, String ioBndCd )throws DAOException {
		DBRowSet dbRowset = null;
		String sailArrDt = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vvd", vvd);
			mapVO.put("port_cd", portCd);
			mapVO.put("io_bnd_cd", ioBndCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchTrunkSaDtRSQL(), param, velParam);
			if(dbRowset.next()) {						
				sailArrDt = dbRowset.getString("sail_arr_dt");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return sailArrDt;
	}
	
	/**
  	* INV_BKG_IF_MN 테이블에서 slanCd 조회<br>
  	* 
	* @param  String bkgNo
	* @param  String bkgSeq
	* @return String
	* @exception DAOException
	*/
	public String searchLane( String bkgNo, String bkgSeq )throws DAOException {
		DBRowSet dbRowset = null;
		String slanCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchLaneRSQL(), param, velParam);
			if(dbRowset.next()) {						
				slanCd = dbRowset.getString("slan_cd");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return slanCd;
	}
	
	/**
  	* INV_BKG_IF_MN 테이블에서 svcScpCd 조회<br>
  	* 
	* @param  String bkgNo
	* @param  String bkgSeq
	* @return String
	* @exception DAOException
	*/
	public String searchServiceScope( String bkgNo, String bkgSeq )throws DAOException {
		DBRowSet dbRowset = null;
		String svcScpCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchServiceScopeRSQL(), param, velParam);
			if(dbRowset.next()) {						
				svcScpCd = dbRowset.getString("svc_scp_cd");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return svcScpCd;
	}
	
	/**
	 * AR_MST_REV_VVD, AR_FINC_DIR_CONV 테이블에서 revVvd, rlaneCd 조회<br>
	 * 
	 * @param String bkgNo
	 * @return RevVVDLaneVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public RevVVDLaneVO searchRevenueVVDLane(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		RevVVDLaneVO revVVDLaneVO = new RevVVDLaneVO();
		List<RevVVDLaneVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchRevenueVVDLaneRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevVVDLaneVO .class);
			
			if (list != null && list.size() > 0) {
				revVVDLaneVO = (RevVVDLaneVO) list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return revVVDLaneVO;
	}
		
	/**
	 * AR_MST_REV_VVD, AR_FINC_DIR_CONV 테이블에서 revVvd, rlaneCd 조회<br>
	 * 
	 * @param String vvd
	 * @return RevVVDLaneVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public RevVVDLaneVO searchRevenueVVDLaneRd(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		RevVVDLaneVO revVVDLaneVO = new RevVVDLaneVO();
		List<RevVVDLaneVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vvd", vvd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchRevenueVVDLaneRdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevVVDLaneVO .class);
			
			if (list != null && list.size() > 0) {
				revVVDLaneVO = (RevVVDLaneVO) list.get(0);
			}else{
				revVVDLaneVO.setRevVvd("X");
				revVVDLaneVO.setRlaneCd("X");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return revVVDLaneVO;
	}
	
	
	/**
	 * MDM_ORGANIZATION 테이블에서 AR_OFC_CD,SUB_AGN_FLG 조회<br>
	 * 
	 * @param String ofcCd
	 * @return ArOfcAgtMkVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ArOfcAgtMkVO searchAROfficeAgtMk(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		ArOfcAgtMkVO arOfcAgtMkVO = new ArOfcAgtMkVO();
		List<ArOfcAgtMkVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchAROfficeAgtMkRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArOfcAgtMkVO .class);
			
			if (list != null && list.size() > 0) {
				arOfcAgtMkVO = (ArOfcAgtMkVO) list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return arOfcAgtMkVO;
	}
	
	/**
	 * INV_CUT_OFF_LANE 테이블에서 cut_off_aply_dt_tp_cd, aply_dt, new_ar_ofc_cd 조회<br>
	 * 
	 * @param String arOfcCd
	 * @param String vvd
	 * @param String ioBndCd
	 * @param String portCd
	 * @param String sailArrDt
	 * @return ArOfcApplDtVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ArOfcApplDtVO searchCutOffLaneOffice(String arOfcCd, String vvd, String ioBndCd, String portCd, String sailArrDt) throws DAOException {
		DBRowSet dbRowset = null;
		ArOfcApplDtVO arOfcApplDtVO = new ArOfcApplDtVO();
		List<ArOfcApplDtVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("tp_cd", "N");
			mapVO.put("ar_ofc_cd", arOfcCd);
			mapVO.put("vvd", vvd);
			mapVO.put("io_bnd_cd", ioBndCd);
			mapVO.put("port_cd", portCd);
			mapVO.put("sail_arr_dt", sailArrDt);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchCutOffLaneOfficeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArOfcApplDtVO .class);
			
			if (list != null && list.size() > 0) {
				arOfcApplDtVO = (ArOfcApplDtVO) list.get(0);
			}else{
				mapVO.put("tp_cd", "Y");
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchCutOffLaneOfficeRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArOfcApplDtVO .class);
				if (list != null && list.size() > 0) {
					arOfcApplDtVO = (ArOfcApplDtVO) list.get(0);
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return arOfcApplDtVO;
	}
	
	/**
	 * MDM_ORGANIZATION 테이블에서 AR_OFC_CD 정보 조회<br>
	 * 
	 * @param String arOfcCd
	 * @return ArOfcAttributeVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ArOfcAttributeVO searchOfficeAttribute(String arOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		ArOfcAttributeVO arOfcAttributeVO = new ArOfcAttributeVO();
		List<ArOfcAttributeVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", arOfcCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchOfficeAttributeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArOfcAttributeVO .class);
			
			if (list != null && list.size() > 0) {
				arOfcAttributeVO = (ArOfcAttributeVO) list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return arOfcAttributeVO;
	}
	
	/**
	 * INV_AR_MN 테이블에서 ACT/INV CUST 조회<br>
	 * 
	 * @param String arOfcCd
	 * @param String blSrcNo
	 * @return ActInvCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ActInvCustVO searchMaxInterfaceCustomerCode(String arOfcCd, String blSrcNo) throws DAOException {
		DBRowSet dbRowset = null;
		ActInvCustVO actInvCustVO = new ActInvCustVO();
		List<ActInvCustVO> list = null;

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

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchMaxInterfaceCustomerCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActInvCustVO .class);
			
			if (list != null && list.size() > 0) {
				actInvCustVO = (ActInvCustVO) list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return actInvCustVO;
	}
	
	/**
	 * INV_VSL_AGN_CUST_CD 테이블에서 CUST 조회<br>
	 * 
	 * @param String vslCd
	 * @param String arOfcCd
	 * @return ActInvCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ActInvCustVO searchChinaCustomerCodeByVessel(String vslCd, String arOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		ActInvCustVO actInvCustVO = new ActInvCustVO();
		List<ActInvCustVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vsl_cd", vslCd);
			mapVO.put("ar_ofc_cd", arOfcCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchChinaCustomerCodeByVesselRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActInvCustVO .class);
			
			if (list != null && list.size() > 0) {
				actInvCustVO = (ActInvCustVO) list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return actInvCustVO;
	}
	
	/**
	 * INV_FDR_POD_AGN_CUST_CD 테이블에서 CUST 조회<br>
	 * 
	 * @param String vvd
	 * @param String portCd
	 * @return ActInvCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ActInvCustVO searchChinaCustomerCodeByPort(String vvd,String portCd) throws DAOException {
		DBRowSet dbRowset = null;
		ActInvCustVO actInvCustVO = new ActInvCustVO();
		List<ActInvCustVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vvd", vvd);
			mapVO.put("port_cd", portCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchChinaCustomerCodeByPortRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActInvCustVO .class);
			
			if (list != null && list.size() > 0) {
				actInvCustVO = (ActInvCustVO) list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return actInvCustVO;
	}
	
	/**
	 * MDR_CR_CUST 테이블에서 ACT_CUST 조회<br>
	 * 
	 * @param String invCustCntCd
	 * @param String invCustSeq
	 * @return ActInvCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ActInvCustVO searchActualCustomerCode(String invCustCntCd,String invCustSeq) throws DAOException {
		DBRowSet dbRowset = null;
		ActInvCustVO actInvCustVO = new ActInvCustVO();
		List<ActInvCustVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("inv_cust_cnt_cd", invCustCntCd);
			mapVO.put("inv_cust_seq", invCustSeq);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchActualCustomerCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActInvCustVO .class);
			
			if (list != null && list.size() > 0) {
				actInvCustVO = (ActInvCustVO) list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return actInvCustVO;
	}
	
	/**
  	* COM_SYS_AREA_GRP_ID 테이블에서 svrId 조회<br>
  	* 
	* @param  String ofcCd
	* @return String
	* @exception DAOException
	*/
	public String searchServerID( String ofcCd )throws DAOException {
		DBRowSet dbRowset = null;
		String svrId = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchServerIDRSQL(), param, velParam);
			if(dbRowset.next()) {						
				svrId = dbRowset.getString("svr_id");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return svrId;
	}
	
	/**
	 * INV_BKG_IF_CHG 테이블에서 해당 CHG 정보 select<br>
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @param String ofcCd
	 * @param String ioBndCd
	 * @param String n3rdFlg
	 * @return List<InvBkgIfChgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvBkgIfChgVO> searchInvoiceChargeList(String bkgNo, String bkgSeq,String ofcCd, String ioBndCd, String n3rdFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvBkgIfChgVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			
			String svrId = searchServerID(ofcCd);
			
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("io_bnd_cd", ioBndCd);
			mapVO.put("n3rd_flg", n3rdFlg);
			mapVO.put("svr_id", svrId);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchInvoiceChargeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvBkgIfChgVO .class);
			
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
	 * INV_BKG_IF_MN 테이블에서 Booking 기본 정보 조회<br>
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @param String ofcCd
	 * @return BKGMainDocVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BKGMainDocVO searchBKGInterface(String bkgNo,String bkgSeq,String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		BKGMainDocVO bKGMainDocVO = new BKGMainDocVO();
		List<BKGMainDocVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			mapVO.put("ofc_cd", ofcCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchBKGInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BKGMainDocVO .class);
			
			if (list != null && list.size() > 0) {
				bKGMainDocVO = (BKGMainDocVO) list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bKGMainDocVO;
	}
	
	/**
     * INV_AR_MN 의 해당 BLNO 로 WHF Dec 여부와 INV_AR_CHG 에 WHF charge 존재여부 체크<br>
     * 
     * @param String blNo
     * @param String ofcCd
     * @return int
     * @exception DAOException
     */
	public int checkDecWHFByBL(String blNo, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
	
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bl_src_no", blNo);
			mapVO.put("ofc_cd", ofcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);					

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOCheckDecWHFByBLRSQL(), param, velParam);
            if(dbRowset.next()) {						
            	cnt = dbRowset.getInt("cnt");
	    	}
            
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}	
	
	
	/**
     * INV_AR_MN 의 해당 BLNO 로 BKG IF된 WHF DECL NO와 같은 NO가 있는지 체크<br>
     * 
     * @param String blNo
     * @param String ofcCd
     * @param String whfDeclNo
     * @return int
     * @exception DAOException
     */
	public int checkExistsDecWHFByBL(String blNo, String ofcCd, String whfDeclNo) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
	
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bl_src_no", blNo);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("whf_decl_no", whfDeclNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);					

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOCheckExistsDecWHFByBLRSQL(), param, velParam);
            if(dbRowset.next()) {						
            	cnt = dbRowset.getInt("cnt");
	    	}
            
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}	
	
	/**
  	*  MDM_CHARGE 테이블에서 대포 CHG_CD 조회<br>
  	* 
	* @param  String chgCd
	* @return String
	* @exception DAOException
	*/
	public String searchRepCharge( String chgCd )throws DAOException {
		DBRowSet dbRowset = null;
		String repChgCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("chg_cd", chgCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchRepChargeRSQL(), param, velParam);
			if(dbRowset.next()) {						
				repChgCd = dbRowset.getString("rep_chg_cd");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return repChgCd;
	}
	
	/**
  	*  MDM_CHARGE 테이블에서 CHG NAME 조회<br>
  	* 
	* @param  String chgCd
	* @param  String arOfcCd
	* @return String
	* @exception DAOException
	*/
	public String searchChargeName( String chgCd, String arOfcCd )throws DAOException {
		DBRowSet dbRowset = null;
		String chgFullNm = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("chg_cd", chgCd);
			mapVO.put("ar_ofc_cd", arOfcCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchChargeNameRSQL(), param, velParam);
			if(dbRowset.next()) {						
				chgFullNm = dbRowset.getString("chg_nm");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return chgFullNm;
	}
	
	/**
     * BKG_CONTAINER 테이블에서 CNTR_NO, CNTR_TPSZ_CD 을 구한다. <br>
     * 
     * @param String bkgNo
     * @param String bkgSeq
     * @return List<InvBkgIfCntrVO>
     * @exception DAOException
     */
	@SuppressWarnings("unchecked")
	public List<InvBkgIfCntrVO> searchBkgIfContainerList(String bkgNo,String bkgSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvBkgIfCntrVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchBkgIfContainerListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvBkgIfCntrVO .class);
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
  	*  INV_BKG_IF_MN 테이블에서 TRO_FLG 조회<br>
  	* 
	* @param  String bkgNo
	* @param  String bkgSeq
	* @return String
	* @exception DAOException
	*/
	public String searchTroFlag( String bkgNo, String bkgSeq )throws DAOException {
		DBRowSet dbRowset = null;
		String troFlg = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchTroFlagRSQL(), param, velParam);
			if(dbRowset.next()) {						
				troFlg = dbRowset.getString("tro_flg");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return troFlg;
	}
	
	/**
  	*  Rev Type으로 TJSRCNM 조회<br>
  	* 
	* @param String ofcCd
	* @param  String chgCd
	* @param  String revTpSrcCd
	* @param  String svrId
	* @return String
	* @exception DAOException
	*/
	public String searchTjSrcNm( String ofcCd, String chgCd, String revTpSrcCd , String svrId) throws DAOException {
		DBRowSet dbRowset = null;
		String tjSrcNm = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);			
			mapVO.put("chg_cd", chgCd);
			mapVO.put("rev_tp_src_cd", revTpSrcCd);
			mapVO.put("svr_id", svrId);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchTjSrcNmRSQL(), param, velParam);
			if(dbRowset.next()) {						
				tjSrcNm = dbRowset.getString("tj_src_nm");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return tjSrcNm;
	}
	
	/**
	 * INV_AR_AMT table 저장 BKG Interface 용<br>
	 * 
	 * @param String arIfNo
	 * @param String userId
	 * @exception DAOException
	 */                  
    public void addInvArAmt(String arIfNo, String userId ) throws DAOException {
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
    	int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", arIfNo);
			mapVO.put("user_id", userId);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOaddInvArAmtCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    
    }	 
    
    /**
	 * INV_AR_AMT table 저장 BKG Interface 요<br>
	 * 
	 * @param String arIfNo
	 * @exception DAOException
	 */                  
    public void modifyInvArChg(String arIfNo) throws DAOException {
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
    	int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", arIfNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifyInvArChgUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}    
    }	 
    
    /**
	 * INV_BKG_IF_CHG 테이블에서 해당 CHG 정보 select<br>
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @param String ofcCd
	 * @param String whfChk
	 * @return List<InvBkgIfChgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvBkgIfChgVO> searchInvoiceIfChargeList(String bkgNo, String bkgSeq, String ofcCd, String whfChk) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvBkgIfChgVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("whf_chk", whfChk);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchInvoiceIfChargeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvBkgIfChgVO .class);
			
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
  	*  Rev Type, Chg Cd 로 rev_coa_acct_cd 조회<br>
  	* 
	* @param  String ofcCd
	* @param  String chgCd
	* @param  String revTpCd
	* @param  String revSrcCd
	* @param  String svrId
	* @param  String acctCd
	* @return String
	* @exception DAOException
	*/
	public String searchRevCoaAcctCd( String ofcCd, String chgCd, String revTpCd , String revSrcCd, String svrId,  String acctCd) throws DAOException {
		DBRowSet dbRowset = null;
		String revCoaAccdCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("chg_cd", chgCd);
			mapVO.put("rev_tp_cd", revTpCd);
			mapVO.put("rev_src_cd", revSrcCd);
			mapVO.put("svr_id", svrId);
			mapVO.put("acct_cd", acctCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchRevCoaAcctCdRSQL(), param, velParam);
			if(dbRowset.next()) {						
				revCoaAccdCd = dbRowset.getString("rev_coa_acct_cd");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return revCoaAccdCd;
	}
	
	
	  
	 /**
	 * BKG_CHN_AGN 테이블에서 CUST 조회<br>
	 * 
	 * @param String chnAgnCd
	 * @param String ofcCd
	 * @return ActInvCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ActInvCustVO searchBKGAgentCustomer(String chnAgnCd,String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		ActInvCustVO actInvCustVO = new ActInvCustVO();
		List<ActInvCustVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("chn_agn_cd", chnAgnCd);
			mapVO.put("ofc_cd", ofcCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchBKGAgentCustomerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActInvCustVO .class);
			
			if (list != null && list.size() > 0) {
				actInvCustVO = (ActInvCustVO) list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return actInvCustVO;
	}
	
	/**
	 * Booking IF 상태, 에러코드를 업데이트 한다.
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @param String invArIfCd
	 * @param String arIfErrRsn
	 * @param String userId
	 * @exception DAOException
	 */
	public void modifyInvArIfStatus(String bkgNo,String bkgSeq,String invArIfCd,String arIfErrRsn, String userId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			mapVO.put("inv_ar_if_cd", invArIfCd);
			mapVO.put("ar_if_err_rsn", arIfErrRsn);
			mapVO.put("upd_usr_id", userId);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifyInvArIfStatusUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
  	*  CHG 로 AR_TAX_IND_CD조회<br>
  	* 
	* @param  String bkgNo
	* @param  String bkgSeq
	* @param  String ofcCd
	* @return String
	* @exception DAOException
	*/
	public String searchArTaxInd( String bkgNo, String bkgSeq, String ofcCd ) throws DAOException {
		DBRowSet dbRowset = null;
		String arTaxIndCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			mapVO.put("ofc_cd", ofcCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchArTaxIndRSQL(), param, velParam);
			if(dbRowset.next()) {						
				arTaxIndCd = dbRowset.getString("ar_tax_ind");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return arTaxIndCd;
	}
	
	/**
  	*  MDM_CR_CUST에서 CR_CLT_OFC 조회<br>
  	* 
	* @param  String actCustCntCd
	* @param  String actCustSeq
	* @return String
	* @exception DAOException
	*/
	public String searchCrCltOffice( String actCustCntCd, String actCustSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String crCltOfcCd = null;
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
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchCrCltOfficeRSQL(), param, velParam);
			if(dbRowset.next()) {						
				crCltOfcCd = dbRowset.getString("cr_clt_ofc_cd");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return crCltOfcCd;
	}
	
	/**
  	*  MDM_CR_CUST에서 KR_IB_OFC 조회<br>
  	* 
	* @param  String actCustCntCd
	* @param  String actCustSeq
	* @return String
	* @exception DAOException
	*/
	public String searchKrIbOffice( String actCustCntCd, String actCustSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String krIbOfcCd = null;
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
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchKrIbOfficeRSQL(), param, velParam);
			if(dbRowset.next()) {						
				krIbOfcCd = dbRowset.getString("kr_ib_ofc_cd");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return krIbOfcCd;
	}
	
	/**
  	*  INV_COA_ACCT_CD SELECT<br>
  	* 
	* @param  String tjSrcNm
	* @param  String svrId
	* @param  String revTpCd
	* @param  String revSrcCd
	* @param  String acctCd
	* @return String
	* @exception DAOException
	*/
	public String searchInvCoaAccount( String tjSrcNm, String svrId , String revTpCd, String revSrcCd, String acctCd) throws DAOException {
		DBRowSet dbRowset = null;
		String invCoaAcctCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("tj_src_nm", tjSrcNm);
			mapVO.put("svr_id", svrId);
			mapVO.put("rev_tp_cd", revTpCd);
			mapVO.put("rev_src_cd", revSrcCd);
			mapVO.put("acct_cd", acctCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchInvCoaAccountRSQL(), param, velParam);
			if(dbRowset.next()) {						
				invCoaAcctCd = dbRowset.getString("inv_coa_acct_cd");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return invCoaAcctCd;
	}
	
	 /**
  	* INV_AR_AMT에서 CHG 테이블 내용으로 조회<br>
  	* 
	* @param String arIfNo
	* @return List<InvArAmtVO>
	* @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<InvArAmtVO> searchInvArAmount ( String arIfNo ) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArAmtVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", arIfNo);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchInvArAmountRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArAmtVO .class);
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
	 * INV_AR_AMT table 저장 <br>
	 * 
	 * @param String svrId
	 * @param InvArMnVO invArMnVo
	 * @param InvArAmtVO invArAmtVo
	 * @exception DAOException
	 */
	public void addInvAmount(String svrId, InvArMnVO invArMnVo, InvArAmtVO invArAmtVo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			if(invArMnVo != null && invArAmtVo != null){
	
				Map<String, String> mapVO = new HashMap<String, String>();
				
				mapVO.put("ar_if_no", invArAmtVo.getArIfNo());            
				mapVO.put("ar_inv_src_cd", invArAmtVo.getArInvSrcCd());            
				mapVO.put("inv_coa_co_cd", invArAmtVo.getInvCoaCoCd());            
				mapVO.put("inv_coa_rgn_cd", invArAmtVo.getInvCoaRgnCd());            
				mapVO.put("inv_coa_ctr_cd", invArAmtVo.getInvCoaCtrCd());            
				mapVO.put("svr_id", svrId);            
				mapVO.put("rev_tp_cd", invArMnVo.getRevTpCd());            
				mapVO.put("rev_src_cd", invArMnVo.getRevSrcCd());            
				mapVO.put("acct_cd", invArMnVo.getAcctCd());            
				mapVO.put("inv_coa_inter_co_cd", invArAmtVo.getInvCoaInterCoCd());           
				mapVO.put("inv_coa_vsl_cd", invArAmtVo.getInvCoaVslCd());            
				mapVO.put("inv_coa_voy_no", invArAmtVo.getInvCoaVoyNo());            
				mapVO.put("inv_coa_skd_dir_cd", invArAmtVo.getInvCoaSkdDirCd());            
				mapVO.put("inv_coa_rev_dir_cd", invArAmtVo.getInvCoaRevDirCd());            
				mapVO.put("erp_if_gl_dt", invArAmtVo.getErpIfGlDt());            
				mapVO.put("erp_if_ofc_cd", invArAmtVo.getErpIfOfcCd()); 
				mapVO.put("cre_usr_id", invArMnVo.getCreUsrId());            
				mapVO.put("upd_usr_id", invArMnVo.getUpdUsrId());		
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
				
			}
			sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOaddInvAmountOtherCSQL(), param, velParam);
	    } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	 
	
	/**
	 * FNS_INV_0036<br>
	 * Ex.Rate Update by Date or VVD의 환율적용대상 data 를 Main 테이블 Update<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param ExrateMainVO exrateMainVO
	 * @throws DAOException, Exception
	 */
	public void modifyVIEInvoiceExrateMain(ExrateMainVO exrateMainVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			if(exrateMainVO != null){
				Map<String, String> mapVO = exrateMainVO.getColumnValues();
				param.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationBackEndDBDAOVIEInvoiceExrateMainUSQL(), param, null);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * office 별 Local Time 조회<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchLocalTime(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String localTime = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ofcCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("ofc_cd", ofcCd);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchLocalTimeRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		localTime = dbRowset.getString(1);
	    	}
	    	//log.info("\n########## localTime : "+localTime);
	    	
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return localTime;
	}
	
	/**
	 * MDM_ORGANIZATION table 에서 office 정보 조회<br>
	 * 
	 * @param String ofcCd
	 * @return MdmOrganizationVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MdmOrganizationVO searchOfficeAttributeMri(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmOrganizationVO> list = null;
		MdmOrganizationVO mdmOrgVo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ofcCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("ofc_cd", ofcCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchOfficeAttributeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmOrganizationVO .class);
			
			if (list != null && list.size() > 0) {
				mdmOrgVo = (MdmOrganizationVO) list.get(0);
			}
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return mdmOrgVo;
	}	
	
	/**
	 * AP_PERIOD table 에서 MRI_MAX_YYMM 조회 <br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchMriMaxYymm(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String mriMaxYymm = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			Map<String, String> mapVO = new HashMap<String, String>();			
			
			mapVO.put("ofc_cd", ofcCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchMriMaxYymmRSQL(), param, velParam);						
	    	if(dbRowset.next()) {
	    		mriMaxYymm = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return mriMaxYymm;
	}	
	
	/**
	 * 한국지역 gl_eff_dt 조회 <br>
	 * 
	 * @param String mriMaxYymm
	 * @param String localTime
	 * @return String
	 * @exception DAOException
	 */
	public String searchGlEffDtKor(String mriMaxYymm, String localTime) throws DAOException {
		DBRowSet dbRowset = null;
		String glEffDt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			Map<String, String> mapVO = new HashMap<String, String>();			
			
			mapVO.put("mri_max_yymm", mriMaxYymm);
			mapVO.put("local_time", localTime);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchGlEffDtKorRSQL(), param, velParam);						
	    	if(dbRowset.next()) {
	    		glEffDt = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return glEffDt;
	}	
	
	/**
	 * 기타지역 gl_eff_dt 조회 <br>
	 * 
	 * @param String sailDt
	 * @param String mriMaxYymm
	 * @param String localTime
	 * @return String
	 * @exception DAOException
	 */
	public String searchGlEffDtOther(String sailDt, String mriMaxYymm, String localTime) throws DAOException {
		DBRowSet dbRowset = null;
		String glEffDt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			Map<String, String> mapVO = new HashMap<String, String>();			
			
			mapVO.put("sail_dt", sailDt);
			mapVO.put("mri_max_yymm", mriMaxYymm);
			mapVO.put("local_time", localTime);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchGlEffDtOtherRSQL(), param, velParam);						
	    	if(dbRowset.next()) {
	    		glEffDt = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return glEffDt;
	}		
	
	/**
	 * INV_AR_MN table 에서 DUE_DT 조회<br>
	 * 
	 * @param String blSrcNo
	 * @param String ofcCd
	 * @return DueDateVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public DueDateVO searchDueDtForMaxINVInterface(String blSrcNo, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<DueDateVO> list = null;
		DueDateVO dueDateVo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(blSrcNo != null && ofcCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			     
				mapVO.put("bl_src_no", blSrcNo);
				mapVO.put("ofc_cd", ofcCd);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchDueDtForMaxINVInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DueDateVO .class);
			
			if (list != null && list.size() > 0) {
				dueDateVo = (DueDateVO) list.get(0);
			}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return dueDateVo;
	}	
	
	/**
	 * MDM_CR_CUST table 에서 CR_CLT_OFC_CD 조회 <br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return String
	 * @exception DAOException
	 */
	public String searchErpIFOfcCd(String custCntCd, String custSeq) throws DAOException {
		DBRowSet dbRowset = null;
		String erpIfOfcCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			Map<String, String> mapVO = new HashMap<String, String>();			
			
			mapVO.put("cust_cnt_cd", custCntCd);
			mapVO.put("cust_seq", custSeq);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchErpIFOfcCdRSQL(), param, velParam);						
	    	if(dbRowset.next()) {
	    		erpIfOfcCd = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return erpIfOfcCd;
	}	
	
	/**
	 * INV_REV_ACCT_CD table 에서 INV_ACCT_DIV_CD 조회<br>
	 * 
	 * @param String revTpCd
	 * @param String revSrcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchAccountDivision(String revTpCd, String revSrcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String invAcctDivCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(revTpCd != null && revSrcCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    				
				mapVO.put("rev_tp_cd", revTpCd);
				mapVO.put("rev_src_cd", revSrcCd);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchAccountDivisionRSQL(), param, velParam);
	    	if(dbRowset.next()) {
	    		invAcctDivCd = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return invAcctDivCd;
	}	
	
	/**
	 * ACCT_CD 조회 <br>
	 * 
	 * @param String revTpSrcCd
	 * @param String chgCd
	 * @param String acctCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchAccountCdConversion(String revTpSrcCd, String chgCd, String acctCd) throws DAOException {
		DBRowSet dbRowset = null;
		String erpIfOfcCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			Map<String, String> mapVO = new HashMap<String, String>();			
			
			mapVO.put("rev_tp_src_cd", revTpSrcCd);
			mapVO.put("chg_cd", chgCd);
			mapVO.put("acct_cd", acctCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new GeneralARInvoiceCreationDBDAOsearchAccountCdConversionRSQL(), param, velParam);						
	    	if(dbRowset.next()) {
	    		erpIfOfcCd = dbRowset.getString(1);
	    	}
			
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return erpIfOfcCd;
	}
	
	
	/**
  	* INV_AR_CHG에서 INV NO 로 조회함.<br>
  	* 
	* @param String invNo
	* @param String ofcCd
	* @return  List<InvArChgVO>
	* @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<InvArChgVO> searchIssueInvoiceCharge ( String invNo, String ofcCd ) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArChgVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("inv_no", invNo);
			mapVO.put("ofc_cd", ofcCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchIssueInvoiceChargeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArChgVO .class);
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
  	* INV_AR_AMT에서 INV NO 로 조회함.<br>
  	* 
	* @param String invNo
	* @param String ofcCd
	* @return  List<InvArAmtVO>
	* @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<InvArAmtVO> searchIssueInvoiceAmount ( String invNo, String ofcCd ) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvArAmtVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("inv_no", invNo);
			mapVO.put("ofc_cd", ofcCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchIssueInvoiceAmountRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArAmtVO .class);
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
	 * LOCAL AMOUNT 조회 <br>
	 * 
	 * @param String invNo
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchARInvoiceLocalAmountByInvoiceNo( String invNo, String ofcCd ) throws DAOException {
		DBRowSet dbRowset = null;
		String invTtlLoclAmt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			Map<String, String> mapVO = new HashMap<String, String>();			
			
			mapVO.put("inv_no", invNo);
			mapVO.put("ofc_cd", ofcCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchARInvoiceLocalAmountByInvoiceNoRSQL(), param, velParam);						
			log.info("dbRowset = "+dbRowset.getRowCount());
			if(dbRowset.next()) {
	    		invTtlLoclAmt = Float.toString(dbRowset.getFloat(1));
	    		log.info("DBDAO next invTtlLoclAmt = "+dbRowset.getFloat(1));
	    	}
	    	
	    	log.info("DBDAO invTtlLoclAmt = "+invTtlLoclAmt);
	    	
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return invTtlLoclAmt;
	}
	
	/**
	 * VSK_VSL_PORT_SKD 에서 SailArrDt를 구한다.<br>
	 * 
	 * @param String cngIndivCd
	 * @param String bkgNo
	 * @param String portCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchSailingArrivalDate(String cngIndivCd, String bkgNo, String portCd) throws DAOException {
		DBRowSet dbRowset = null;
		String exRateDate = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cng_indiv_cd", cngIndivCd);
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("port_cd", portCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchSailingArrivalDateRSQL(),  param, velParam);
			 while (dbRowset.next()) {
				 exRateDate = dbRowset.getString("ex_rate_date");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return exRateDate;
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
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchDueDateVORSQL(), param, velParam);
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
	 * invNo 로 ifNo 를 찾아서 in_ar_mn 테이블 split_cd 변경 <br>
	 * 
	 * @param String invNo
	 * @param String ofcCd
	 * @param String splitCd
	 * @param String usrId
	 * @exception DAOException
	 */
	
	public void modifySplitCodeByInvNo(String invNo,String ofcCd, String splitCd, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("inv_no", invNo);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("inv_split_cd", splitCd);
			mapVO.put("upd_usr_id", usrId);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifySplitCodeByInvNoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
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
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchRevTypSrcRSQL(), param, velParam);
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
	 * INV_VVD_XCH_RT table VVD 환율저장<br>
	 * 
	 * @param VVDExrateInputVO vvdExrateVo
	 * @param String userId
	 * @exception DAOException
	 */
	  public void addVVDExRate(VVDExrateInputVO vvdExrateVo, String userId) throws DAOException {
		
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			Map<String, Object> velParam = new HashMap<String, Object>();			
			Map<String , String> paramMap = vvdExrateVo.getColumnValues();
			
			paramMap.put("user_id", userId);
			
			sqlExe.executeUpdate((ISQLTemplate) new BookingARCreationDBDAOAddVVDExRateCSQL(), paramMap, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	
	}	 
	  
	/**
	 * BL 별 amount 의 합 조회<br>
	 * 
	 * @param String ofcCd
	 * @param String blSrcNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchBLSumAmount(String ofcCd, String blSrcNo) throws DAOException {
		DBRowSet dbRowset = null;
		String bLSumAmount = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("bl_src_no", blSrcNo);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchBLSumAmountRSQL(), param, velParam);
			while(dbRowset.next()){
				bLSumAmount = dbRowset.getString("bl_sum_amount");
            }
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenueAcctVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bLSumAmount;
	}		
	
	/**
	 * USD_LOCAL_XCH_RT 조회<br>
	 * 
	 * @param String currCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchAcctRate(String currCd) throws DAOException {
		DBRowSet dbRowset = null;
		String usdLoclXchRt = "0";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("curr_cd", currCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchAcctRateRSQL(), param, velParam);
			while(dbRowset.next()){
				usdLoclXchRt = dbRowset.getString("usd_locl_xch_rt");

            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return usdLoclXchRt;
	}
	
	/**
     * INV_AR_MN 에 blNo와 ofcCd에 해당하는 ifNO 가 있는지 체크<br>
     * 
     * @param String blNo
     * @param String ofcCd
     * @return int
     * @exception DAOException
     */
	public int checkFirstInterface(String blNo, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
	
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bl_no", blNo);
			mapVO.put("ofc_cd", ofcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);					

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOCheckFirsrInterfaceRSQL(), param, velParam);
            if(dbRowset.next()) {						
            	cnt = dbRowset.getInt("cnt");
	    	}
            
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}	
	
	
	/**
     * BKG NO로 INV_BKG_IF_MN 에서 TEU, FEU를 구함. <br>
     * 
     * @param String bkgNo
     * @param String bkgSeq
     * @return InvArMnVO
     * @exception DAOException
     */
	@SuppressWarnings("unchecked")
	public InvArMnVO searchBkgIfTeuFeu(String bkgNo, String bkgSeq) throws DAOException {
		DBRowSet dbRowset = null;
		InvArMnVO invArMnVO = new InvArMnVO();
		List<InvArMnVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
	
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			param.putAll(mapVO);
			velParam.putAll(mapVO);					

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchBkgIfTeuFeuRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArMnVO .class);
			if (list != null && list.size() > 0) {
				invArMnVO = (InvArMnVO) list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return invArMnVO;
	}	
	
	/**
  	*  Rev Type, Chg Cd 로 acct_cd 조회<br>
  	* 
	* @param  String ofcCd
	* @param  String chgCd
	* @param  String revTpCd
	* @param  String revSrcCd
	* @param  String svrId
	* @param  String acctCd
	* @return String
	* @exception DAOException
	*/
	public String searchAccountCd( String ofcCd, String chgCd, String revTpCd , String revSrcCd, String svrId,  String acctCd) throws DAOException {
		DBRowSet dbRowset = null;
		String accdCd = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("chg_cd", chgCd);
			mapVO.put("rev_tp_cd", revTpCd);
			mapVO.put("rev_src_cd", revSrcCd);
			mapVO.put("svr_id", svrId);
			mapVO.put("acct_cd", acctCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchAccountCdRSQL(), param, velParam);
			if(dbRowset.next()) {						
				accdCd = dbRowset.getString("acct_cd");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return accdCd;
	}
	
	/**
	 * INV_AR_MN 의 WHF 허가번호 업데이트 <br>
	 * 
	 * @param String blSrcNo
	 * @param String ofcCd
	 * @param String whfNtcNo
	 * @param String whfDeclNo
	 * @exception DAOException
	 */
	
	public void modifyWhfNtcNo(String blSrcNo,String ofcCd, String whfNtcNo, String whfDeclNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bl_src_no", blSrcNo);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("whf_ntc_no", whfNtcNo);
			mapVO.put("whf_decl_no", whfDeclNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifyWhfNtcNoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * INV_AR_CHG table 저장<br>
	 * 
	 * @param List<InvArChgVO> invChges
	 * @exception DAOException
	 */
    public void addOtherInvCharge(List<com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArChgVO> invChges ) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int insCnt[] = null;
			if (invChges.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
			
				insCnt = sqlExe.executeBatch((ISQLTemplate) new BookingARCreationDBDAOaddOtherInvChargeCSQL(), invChges, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    
    }	
    
	/**
	 * INV_AR_MN table 에 저장 <br>
	 * 
	 * @param InvArMnVO invMain
	 * @exception DAOException
	 */
	public void addOtherInvMain(com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArMnVO invMain) throws DAOException {
		
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			Map<String, String> velParam = invMain.getColumnValues();				
			Map<String, String> paramMap = invMain.getColumnValues();			
			sqlExe.executeUpdate((ISQLTemplate) new BookingARCreationDBDAOaddOtherInvMainCSQL(), paramMap, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	
	}	 
	
	/**
	 * INV_AR_AMT table 저장 <br>
	 * 
	 * @param String arIfNo
	 * @param String svrId
	 * @param InvArMnVO invArMnVo
	 * @param InvArAmtVO invArAmtVo
	 * @exception DAOException
	 */
	public void addOtherInvAmount(String arIfNo, String svrId, com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArMnVO invArMnVo, com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArAmtVO invArAmtVo) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			if(arIfNo != null && invArMnVo != null && invArAmtVo != null){
	
				Map<String, String> mapVO = new HashMap<String, String>();
				
				mapVO.put("ar_if_no", arIfNo);            
				mapVO.put("ar_inv_src_cd", invArAmtVo.getArInvSrcCd());            
				mapVO.put("inv_coa_co_cd", invArAmtVo.getInvCoaCoCd());            
				mapVO.put("inv_coa_rgn_cd", invArAmtVo.getInvCoaRgnCd());            
				mapVO.put("inv_coa_ctr_cd", invArAmtVo.getInvCoaCtrCd());            
				mapVO.put("svr_id", svrId);            
				mapVO.put("rev_tp_cd", invArMnVo.getRevTpCd());            
				mapVO.put("rev_src_cd", invArMnVo.getRevSrcCd());            
				mapVO.put("acct_cd", invArMnVo.getAcctCd());            
				mapVO.put("inv_coa_inter_co_cd", invArAmtVo.getInvCoaInterCoCd());           
				mapVO.put("inv_coa_vsl_cd", invArAmtVo.getInvCoaVslCd());            
				mapVO.put("inv_coa_voy_no", invArAmtVo.getInvCoaVoyNo());            
				mapVO.put("inv_coa_skd_dir_cd", invArAmtVo.getInvCoaSkdDirCd());            
				mapVO.put("inv_coa_rev_dir_cd", invArAmtVo.getInvCoaRevDirCd());            
				mapVO.put("erp_if_gl_dt", invArAmtVo.getErpIfGlDt());            
				mapVO.put("erp_if_ofc_cd", invArAmtVo.getErpIfOfcCd());            
				mapVO.put("cre_usr_id", invArMnVo.getCreUsrId());            
				mapVO.put("upd_usr_id", invArMnVo.getUpdUsrId());				
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);				
				
			}
			sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOaddOtherInvAmountCSQL(), param, velParam);
	    } catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	 	
	
    /**
     * INV_AR_CNTR table 에 저장 <br>
     * 
     * @param List<InvArCntrVO> invCntrs
     * @exception DAOException
     */
    public void addOtherInvContainer(List<com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArCntrVO> invCntrs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int insCnt[] = null;
			if (invCntrs.size() > 0) {
				Map<String, Object> velParam = new HashMap<String, Object>();
				insCnt = sqlExe.executeBatch((ISQLTemplate) new BookingARCreationDBDAOaddOtherInvContainerCSQL(), invCntrs, velParam);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
    
    }	
    
	/**
	 * BKG_VVD, VSK_VSL_PORT_SKD 테이블에서 select<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchSailingDateByBkgNo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String vpsEtdDt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchSailingDateByBkgNoRSQL(), param, velParam);
			while(dbRowset.next()){
				vpsEtdDt = dbRowset.getString("vps_etd_dt");

            }
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenueAcctVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return vpsEtdDt;
	}	
    
	
	/**
	 * BKG_VVD, VSK_VSL_PORT_SKD 테이블에서 select<br>
	 * 
	 * @param String blNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchSailingDateByBlNo(String blNo) throws DAOException {
		DBRowSet dbRowset = null;
		String vpsEtdDt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bl_no", blNo);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchSailingDateByBlNoRSQL(), param, velParam);
			while(dbRowset.next()){
				vpsEtdDt = dbRowset.getString("vps_etd_dt");

            }
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenueAcctVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return vpsEtdDt;
	}	
	
	/**
	 * VSK_VSL_PORT_SKD 테이블에서 select<br>
	 * 
	 * @param String vslCd
	 * @param String voyNo
	 * @param String dirCd
	 * @param String port
	 * @return String
	 * @exception DAOException
	 */
	public String searchSailingDateByVvd(String vslCd, String voyNo, String dirCd, String port) throws DAOException {
		DBRowSet dbRowset = null;
		String vpsEtdDt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vsl_cd", vslCd);
			mapVO.put("voy_no", voyNo);
			mapVO.put("dir_cd", dirCd);
			mapVO.put("port", port);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchSailingDateByVvdRSQL(), param, velParam);
			while(dbRowset.next()){
				vpsEtdDt = dbRowset.getString("vps_etd_dt");

            }
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenueAcctVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return vpsEtdDt;
	}	
	
	/**
  	*  Rev Type, Chg Cd 로 REV_COA_ACCT_CD 조회<br>
  	* 
	* @param  String chgCd
	* @param  ARInvoiceCreationVO invCreVo
	* @param  String svrId
	* @param  String acctCd
	* @return InvArChgVO
	* @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public InvArChgVO searchInvRevTpSrcCd(String chgCd, ARInvoiceCreationVO invCreVo, String svrId, String acctCd) throws DAOException {
	
		DBRowSet dbRowset = null;
		InvArChgVO invChgeVo = new InvArChgVO();
		List<InvArChgVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("chg_cd", chgCd);
			mapVO.put("rev_tp_cd", invCreVo.getRevTpCd());
			mapVO.put("rev_src_cd", invCreVo.getRevSrcCd());
			mapVO.put("svr_id", svrId);
			mapVO.put("acct_cd", acctCd);
			mapVO.put("ofc_cd", invCreVo.getOfcCd());
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchInvRevTpSrcCdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvArChgVO .class);
			if (list != null && list.size() > 0) {
				invChgeVo = (InvArChgVO) list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return invChgeVo;
	}
	
	/**
	 * MDM_CURRENCY 테이블에서 소숫점 자리수 select<br>
	 * 
	 * @param String currCd
	 * @return int
	 * @exception DAOException
	 */
	public int searchCurrencyPoint(String currCd) throws DAOException {
		DBRowSet dbRowset = null;
		int currPoint = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("curr_cd", currCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchCurrencyPointRSQL(), param, velParam);
			while(dbRowset.next()){
				currPoint = Integer.parseInt(dbRowset.getString("dp_prcs_knt"));

            }
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenueAcctVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return currPoint;
	}	

	/**
	 * blSrcNo, ofcCd로 MAX Interface 의 INV_CUST_CNT_CD, INV_CUST_SEQ  조회<br>
	 * 
	 * @param String blSrcNo
	 * @param String ofcCd
	 * @return ActInvCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ActInvCustVO searchInvCustomer(String blSrcNo, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		ActInvCustVO actInvCustVo = null;
		List<ActInvCustVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(ofcCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    
				mapVO.put("bl_src_no", blSrcNo);
				mapVO.put("ofc_cd", ofcCd);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchInvCustomerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActInvCustVO .class);
			if (list != null && list.size() > 0) {
				actInvCustVo = (ActInvCustVO) list.get(0);
			}
	    	
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return actInvCustVo;
	}
	
	/**
	 * INV_AR_LOCL_CHG 테이블에서 ACCT CODE 조회 <br>
	 * 
	 * @param String ofcCd
	 * @param String chgCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchLocalChgFlg(String ofcCd, String chgCd) throws DAOException {
		DBRowSet dbRowset = null;
		String loclChgAcctCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("chg_cd", chgCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchLocalChgFlgRSQL(), param, velParam);
			while(dbRowset.next()){
				loclChgAcctCd = dbRowset.getString("acct_cd");
            }
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return loclChgAcctCd;
	}	
	
    /**
	 * IINV_AR_MN 테이블에 AP_AR_OFFST_NO Update<br>
	 * 
	 * @param String arIfNo
	 * @param String apArOffstNo
	 * @exception DAOException
	 */
    public void modifyArOffstNo(String arIfNo, String apArOffstNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", arIfNo);
			mapVO.put("ap_ar_offst_no", apArOffstNo);								
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOmodifyArOffstNoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
    
	/**
	 * VSK_VSL_PORT_SKD 테이블에서 VVD 유무 조회 <br>
	 * 
	 * @param String vvd
	 * @param String port
	 * @return Boolean
	 * @exception DAOException
	 */
	public Boolean checkVskVslPortSkd(String vvd, String port) throws DAOException {
		DBRowSet dbRowset = null;
		Boolean flag = false;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vvd", vvd);
			mapVO.put("port", port);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOcheckVskVslPortSkdRSQL(), param, velParam);
			
			while(dbRowset.next()){
			    if (dbRowset.getInt("cnt") > 0) {
					flag = true;
				}				
            }
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return flag;
	}	
	
	/**
	 * AR_MST_REV_VVD 테이블에서 TRUNK VVD 조회 <br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	public String searchTrunkVvd() throws DAOException {
		DBRowSet dbRowset = null;
		String trunkVvd = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchTrunkVvdRSQL(), param, velParam);
			
			while(dbRowset.next()){
				trunkVvd = dbRowset.getString("trunk_vvd");			
            }
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return trunkVvd;
	}	
	
	/**
	 * INV_AR_MRI_IF_NO table 에서 MRI_MAX_SEQ 조회. <br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchMRIInterfaceNo(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String mriMaxSeq = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new BookingARCreationDBDAOsearchMRIInterfaceNoRSQL(), param, velParam);
			while (dbRowset.next()) {
				mriMaxSeq = dbRowset.getString("mri_max_seq");
			}
			// list = (List)RowSetUtil.rowSetToVOs(dbRowset, BKGContainerVO .class);
			// log.info("########## mri_max_seq : "+mri_max_seq);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return mriMaxSeq;
	}

	/**
	 * INV_AR_MRI_IF_NO table 에 MRI_MAX_SEQ insert <br>
	 * 
	 * @param String ofcCd
	 * @param String userId
	 * @exception DAOException
	 */
	public void addMRIInterfaceNo(String ofcCd, String userId) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int insCnt = 0;

			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("user_id", userId);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			// insCnt = sqlExe.executeBatch((ISQLTemplate)new ManualARCreationDBDAOaddMRIInterfaceNoCSQL(), insertVoList,null);
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingARCreationDBDAOaddMRIInterfaceNoCSQL(), param, velParam);

			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * INV_AR_MRI_IF_NO table 에 MRI_MAX_SEQ update <br>
	 * 
	 * @param String ofcCd
	 * @param String mriMaxSeq
	 * @param String userId
	 * @exception DAOException
	 */
	public void modifyMRIInterfaceNo(String ofcCd, String mriMaxSeq, String userId) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int insCnt = 0;

			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("mri_max_seq", mriMaxSeq);
			mapVO.put("user_id", userId);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			// insCnt = sqlExe.executeBatch((ISQLTemplate)new ManualARCreationDBDAOaddMRIInterfaceNoCSQL(), insertVoList,null);
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new BookingARCreationDBDAOmodifyMRIInterfaceNoUSQL(), param, velParam);

			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * INV_AR_MN 테이블에서 select<br>
	 * 
	 * @param String blNo
	 * @exception DAOException
	 */
	public void searchMaxInterfaceForUpdate (String blNo) throws DAOException {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bl_no", blNo);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchMaxInterfaceForUpdateRSQL(), param, velParam, true);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * REV_LANE, REV_VVD 조회<br>
	 * 
	 * @param String vvd
	 * @param String polCd
	 * @param String laneCd
	 * @param String podCd
	 * @return MRIRevenueVVDLaneVO mriRevVvdLaneVo
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MRIRevenueVVDLaneVO searchMRIRevenueVVDLaneRowNum(String vvd, String polCd, String laneCd, String podCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MRIRevenueVVDLaneVO> list = null;
		MRIRevenueVVDLaneVO mriRevVvdLaneVo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			Map<String, String> mapVO = new HashMap<String, String>();
		    				
			mapVO.put("lane", laneCd);
			mapVO.put("vsl", vvd.substring(0, 4));
			mapVO.put("voy", vvd.substring(4, 8));
			mapVO.put("dep", vvd.substring(8, 9));
			mapVO.put("pol", polCd);
			mapVO.put("pod", podCd);
							
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchMRIRevenueVVDLaneRowNumRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MRIRevenueVVDLaneVO .class);
			
			if (list != null && list.size() > 0) {
				mriRevVvdLaneVo = (MRIRevenueVVDLaneVO) list.get(0);
			}
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return mriRevVvdLaneVo;
	}	
	
	/**
	 * REV_LANE, REV_VVD 조회<br>
	 * 
	 * @param String vslCd
	 * @return MRIRevenueVVDLaneVO mriRevVvdLaneVo
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public MRIRevenueVVDLaneVO searchMRIRevenueVVDLaneRd(String vslCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MRIRevenueVVDLaneVO> list = null;
		MRIRevenueVVDLaneVO mriRevVvdLaneVo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vslCd != null){
				Map<String, String> mapVO = new HashMap<String, String>();
			    				
				mapVO.put("vsl", vslCd);
								
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchMRIRevenueVVDLaneRdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MRIRevenueVVDLaneVO .class);
			
			if (list != null && list.size() > 0) {
				mriRevVvdLaneVo = (MRIRevenueVVDLaneVO) list.get(0);
			}
        } catch(SQLException se) {
        	log.error(se.getMessage(),se);
        	throw new DAOException(new ErrorHandler(se).getMessage(), se);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
        }
		return mriRevVvdLaneVo;
	}	
	
	/**
	 * INV_AR_CHG 테이블 UPDATE 한다. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvIssVO invIssVO
	 * @exception DAOException
	 */
	public void modifyInvoiceCharge(InvIssVO invIssVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			
			if(invIssVO != null){
				Map<String, String> mapVO = invIssVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOInvIssChgUSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
	/**
	 * INV_AR_MN 테이블 UPDATE (ISSUE FLAG, CLEAR FLAG, INV REF NO, TEU, FEU) 한다. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvIssVO invIssVO
	 * @exception DAOException
	 */
	public void modifyInvoiceMainByBkgNo(InvIssVO invIssVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);			
			
			if(invIssVO != null){
				Map<String, String> mapVO = invIssVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOInvIssByBkgNoUSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
	/**
	 * INV_AR_MN 테이블 UPDATE(DUE DATE 재계산) 한다. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvIssVO invIssVO
	 * @exception DAOException
	 */
	public void modifyDuedateInvoiceMainByIfNo(InvIssVO invIssVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);			
			
			if(invIssVO != null){
				Map<String, String> mapVO = invIssVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOInvIssIfNoUSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
	/**
	 * INV_AR_MN 테이블 UPDATE(DUE DATE 재계산) 한다. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvIssVO invIssVO
	 * @exception DAOException
	 */
	public void modifyDuedateInvoiceMainByIfNoDueDt(InvIssVO invIssVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);			
			
			if(invIssVO != null){
				Map<String, String> mapVO = invIssVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOInvIssDueDtUSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
	/**
	 * INV_AR_CNTR 테이블 DELETE 한다. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvIssVO invIssVO
	 * @exception DAOException
	 */
	public void removeInvoiceContainer(InvIssVO invIssVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);			
			
			if(invIssVO != null){
				Map<String, String> mapVO = invIssVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOInvIssContainerDSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
	/**
	 * INV_AR_CNTR 테이블 INSERT 한다. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvIssVO invIssVO
	 * @exception DAOException
	 */
	public void addInvoiceContainer(InvIssVO invIssVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);			
			
			if(invIssVO != null){
				Map<String, String> mapVO = invIssVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOInvIssContainerCSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
	/**
	 * INV_AR_AMT 테이블 UPDATE(ERP_IF_GL_DT) 한다. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param InvIssVO invIssVO
	 * @exception DAOException
	 */
	public void modifyEffDate(InvIssVO invIssVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter(dataSource);			
			
			if(invIssVO != null){
				Map<String, String> mapVO = invIssVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOInvIssEffDateUSQL(), param, velParam);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}	
	}
	
	/**
	 * MDR_ORGANIZATION 테이블에서 대표 Customer 조회<br>
	 * 
	 * @param String ofcCd
	 * @return ActInvCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ActInvCustVO searchRepCustomerCode(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		ActInvCustVO actInvCustVO = new ActInvCustVO();
		List<ActInvCustVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchRepCustomerCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActInvCustVO .class);
			
			if (list != null && list.size() > 0) {
				actInvCustVO = (ActInvCustVO) list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return actInvCustVO;
	}	
	
	/**
	 * OTS_SMRY_CD 조회<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchOtsSmryCd(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String otsSmryCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchOtsSmryCdRSQL(), param, velParam);
			while(dbRowset.next()){
				otsSmryCd = dbRowset.getString("ots_smry_cd");
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return otsSmryCd;
	}	
	
	/**
	 * REP_CUST_CNT_CD, REP_CUST_SEQ 조회<br>
	 * 
	 * @param String arOfcCd
	 * @return List<ArOfcAttributeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ArOfcAttributeVO> searchRepCustCdByArOfcCd(String arOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		//ArOfcAttributeVO arOfcAttributeVO = new ArOfcAttributeVO();
		List<ArOfcAttributeVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", arOfcCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchRepCustCdByArOfcCdRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArOfcAttributeVO .class);
			
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
	 * MDR_ORGANIZATION 테이블에서 대표 Customer 조회<br>
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @param String ofcCd
	 * @param String ioBndCd
	 * @return ActInvCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ActInvCustVO searchTroCustomerCode(String bkgNo, String bkgSeq, String ofcCd, String ioBndCd) throws DAOException {
		DBRowSet dbRowset = null;
		ActInvCustVO actInvCustVO = new ActInvCustVO();
		List<ActInvCustVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("io_bnd_cd", ioBndCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchTroCustomerCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActInvCustVO .class);
			
			if (list != null && list.size() > 0) {
				actInvCustVO = (ActInvCustVO) list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return actInvCustVO;
	}	

    /**
	 * IINV_AR_MN 테이블에 InvRefNo Update<br>
	 * 
	 * @param String blSrcNo
	 * @param String ofcCd
	 * @param String invRefNo
	 * @exception DAOException
	 */
    public void modifyInvRefNo(String blSrcNo, String ofcCd, String invRefNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bl_src_no", blSrcNo);
			mapVO.put("ofc_cd", ofcCd);		
			mapVO.put("inv_ref_no", invRefNo);
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOmodifyInvRefNoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
    
    /**
	 * INV_AR_MN 테이블에서 select<br>
	 * 
	 * @param String blNo
	 * @param String ofcCd
	 * @return List<MaxIFMainVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MaxIFMainVO> searchMigInterfaceList (String blNo,String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MaxIFMainVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bl_no", blNo);
			mapVO.put("ofc_cd", ofcCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchMigInterfaceListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MaxIFMainVO .class);
			
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
	 * INV_AR_CHG 테이블에서 Select<br>
	 * 
	 * @param String blSrcNo
	 * @param String ofcCd
	 * @param String whfChk
	 * @return List<MaxIFChgeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MaxIFChgeVO> searchChargeListForMigInterface (String blSrcNo, String ofcCd, String whfChk) throws DAOException {
		DBRowSet dbRowset = null;
		List<MaxIFChgeVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bl_no", blSrcNo);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("whf_chk", whfChk);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchChargeListForMigInterfaceRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MaxIFChgeVO .class);
			
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
	 * INV_BKG_IF_CHG 테이블에서 해당 CHG 정보 select<br>
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @param String ofcCd
	 * @param String whfChk
	 * @return List<InvBkgIfChgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvBkgIfChgVO> searchInvoiceIfMigChargeList(String bkgNo, String bkgSeq, String ofcCd, String whfChk) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvBkgIfChgVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("whf_chk", whfChk);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchInvoiceIfMigChargeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvBkgIfChgVO .class);
			
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
	 * ifNo 로 Local Amount Update <br>
	 * 
	 * @param String arIfNo
	 * @exception DAOException
	 */
	
	public void modifyInvTotalLocalAmount(String arIfNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", arIfNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifyInvTotalLocalAmountUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * INV_BKG_IF_CHG 테이블에서 해당 CHG 정보 select<br>
	 * 
	 * @param List<InvArIfNoVO> ifNos
	 * @return List<ExRateCountVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ExRateCountVO> searchInvoiceExrateMain(List<InvArIfNoVO> ifNos) throws DAOException {
		DBRowSet dbRowset = null;
		List<ExRateCountVO> list = new ArrayList<ExRateCountVO>();  
		List<ExRateCountVO> exRateCountVOs = new ArrayList<ExRateCountVO>();  
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			
			for(int i = 0 ; i < ifNos.size() ; i ++ ){				
				mapVO.put("ar_if_no", ifNos.get(i).getIfNo());
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchInvoiceExrateMainRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ExRateCountVO .class);	
				
				if (list != null && list.size() > 0) {
					exRateCountVOs.add(list.get(0));
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return exRateCountVOs;
	}
	
	/**
	 * INV_AR_AMT 테이블에 INV_COA_INTER_CO_CD update<br>
	 * @param String arIfNo
	 * @param String invCoaInterCoCd
	 * @param String effDt
	 * @param String erpIfOfcCd
	 * @param String userId
	 * @exception DAOException
	 */	 	 
    public void modifyInvCoaInterCoCd(String arIfNo, String invCoaInterCoCd, String effDt, String erpIfOfcCd, String userID) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", arIfNo);
			mapVO.put("inv_coa_inter_co_cd", invCoaInterCoCd);
			mapVO.put("erp_if_gl_dt", effDt);
			mapVO.put("erp_if_ofc_cd", erpIfOfcCd);
			mapVO.put("usr_id", userID);								
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			int result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOmodifyInvCoaInterCoCdUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * Closing Status 테이블을 select<br>
	 * 
	 * @param String ofc
	 * @param String effDt
	 * @param String pgmGubn
	 * @return String
	 * @exception DAOException
	 */
	public String searchClosingStatus(String ofc, String effDt, String pgmGubn) throws DAOException {
		DBRowSet dbRowset = null;
		String clzStsCd = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("eff_dt", effDt);
			mapVO.put("ofc", ofc);
			mapVO.put("pgm_gubn", pgmGubn);			

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate) new BookingARCreationDBDAOSearchClosingStatusRSQL(), param, velParam);
			while (dbRowset.next()) {
				clzStsCd = dbRowset.getString("clz_sts_cd");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return clzStsCd;
	}
	
	/**
	 * INV_SUB_AGN_CUST_CD 테이블에서 CUST 조회<br>
	 * 
	 * @param InvSubAgnCustInputVO invSubAgnCustInputVO
	 * @return ActInvCustVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ActInvCustVO searchInvSubAgnCustomer(InvSubAgnCustInputVO invSubAgnCustInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		ActInvCustVO actInvCustVO = new ActInvCustVO();
		List<ActInvCustVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = invSubAgnCustInputVO.getColumnValues();
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchInvSubAgnCustomerRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ActInvCustVO .class);
			
			if (list != null && list.size() > 0) {
				actInvCustVO = (ActInvCustVO) list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return actInvCustVO;
	}
	
	 /**
  	* BKG_RATE 테이블에서 Select<br>
  	* 
  	* @param  String bkgNo
	* @return int
	* @exception DAOException
	*/
	public int checkEurPpdOfc ( String bkgNo )throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOCheckEurPpdOfcRSQL(), param, velParam);
			if(dbRowset.next()) {						
				cnt = dbRowset.getInt("cnt");
	    	}
			log.info("cnt==>"+cnt);

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
	 * INV_BKG_IF_MN table 저장<br>
	 * 
	 * @param String ofcCd
	 * @param String userId
	 * @return String
	 * @exception DAOException
	 */
	  @SuppressWarnings("unchecked")
	public String addInvArBkgIfNoTbl( String ofcCd, String userId )  throws DAOException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		String maxSeq = "";
		//int cnt = 0 ;
		try {			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("user_id", userId);
			mapVO.put("o_max_seq", "");
			mapVO.put("o_result", "");
			mapVO.put("o_err_msg", "");
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			rtnMap = new SQLExecuter(dataSource).executeSP((ISQLTemplate)new BookingARCreationDBDAOAddInvArBkgIfNoTblCSQL(), param, velParam);
			
			log.debug("---------------------------------------------------------");
			log.debug("rtnMap:" + rtnMap);
			
			maxSeq = rtnMap.get("o_max_seq")==null?"":(String)rtnMap.get("o_max_seq");
			String result = rtnMap.get("o_result")==null?"":(String)rtnMap.get("o_result");
			String errMsg = rtnMap.get("o_err_msg")==null?"":(String)rtnMap.get("o_err_msg");
            
			log.debug("---------------------------------------------------------");			
			
			if(!result.equals("S")){
				maxSeq = "";
			}
			log.debug("o_max_seq="+maxSeq);
			log.debug("result="+result);
			log.debug("errMsg="+errMsg);			
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
	 * VSK_VSL_SKD 테이블에서 select<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchBkgDocUsrId(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String docUsrId = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchBkgDocUsrIdRSQL(), param, velParam);
			while(dbRowset.next()){
				docUsrId = dbRowset.getString("doc_usr_id");

            }
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenueAcctVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return docUsrId;
	}	
	
	
	/**
     * MDM_CUSTOMER 에서 삭제된 CUSTOMER 인지 체크<br>
     * 
     * @param String custCntCd
     * @param String custSeq
     * @return int
     * @exception DAOException
     */
	public int checkCustomer(String custCntCd , String custSeq) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
	
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("cust_cnt_cd", custCntCd);
			mapVO.put("cust_seq", custSeq);
			param.putAll(mapVO);
			velParam.putAll(mapVO);					

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOCheckCustomerRSQL(), param, velParam);
            if(dbRowset.next()) {						
            	cnt = dbRowset.getInt("cnt");
	    	}
            
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}	
	
	/**
	 * ifNo 로 Local Amount Update <br>
	 * 
	 * @param String updUsrId
	 * @param String arOfcCd
	 * @param String blSrcNo
	 * @exception DAOException
	 */
	
	public void modifyMainUpdUserId(String updUsrId, String arOfcCd, String blSrcNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("upd_usr_id", updUsrId);
			mapVO.put("ar_ofc_cd", arOfcCd);
			mapVO.put("bl_src_no", blSrcNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifyMainUpdUserIdUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
     * SYS CLEAR 대상 인지 체크<br>
     * 
     * @param SysClearVO sysClearVo
     * @return int
     * @exception DAOException
     */
	public int checkInterfaceNoForSysClear(SysClearVO sysClearVo) throws DAOException {
		DBRowSet dbRowset = null;
		int sumChgAmt = 9999;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
	
			Map<String, String> mapVO = sysClearVo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);			

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOCheckInterfaceNoForSysClearRSQL(), param, velParam);
            if(dbRowset.next()) {						
            	sumChgAmt = dbRowset.getInt("sum_chg_amt");
	    	}
            
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return sumChgAmt;
	}
	
	/**
	 * BKG CHG 와 INV CHG 비교 <br>
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @param String ofcCd
	 * @param String whfChk
	 * @param String arOfcCd
	 * @return List<MaxIFChgeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MaxIFChgeVO> compareBkgIFChargeList(String bkgNo, String bkgSeq, String ofcCd, String whfChk, String arOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MaxIFChgeVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("ar_ofc_cd", arOfcCd);
			mapVO.put("whf_chk", whfChk);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOCompareBkgIFChargeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MaxIFChgeVO .class);
			
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
	 * BKG CHG 와 이행된 INV CHG 비교 <br>
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @param String ofcCd
	 * @param String whfChk
	 * @param String arOfcCd
	 * @return List<MaxIFChgeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<MaxIFChgeVO> compareBkgIFMigChargeList(String bkgNo, String bkgSeq, String ofcCd, String whfChk, String arOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<MaxIFChgeVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("ar_ofc_cd", arOfcCd);
			mapVO.put("whf_chk", whfChk);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOCompareBkgIFMigChargeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MaxIFChgeVO .class);
			
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
  	*  INV_REV_TP_SRC_CD 조회<br>
  	* 
  	* @param  String ofcCd
	* @param  String chgCd
	* @param  String revTpCd
	* @param  String revSrcCd
	* @param  String svrId
	* @return String
	* @exception DAOException
	*/
	public String searchArInvRevTpSrcCd(String ofcCd, String chgCd, String revTpCd, String revSrcCd, String svrId ) throws DAOException {
	
		DBRowSet dbRowset = null;
		String invRevTpSrcCd = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("chg_cd", chgCd);
			mapVO.put("rev_tp_cd", revTpCd);
			mapVO.put("rev_src_cd", revSrcCd);
			mapVO.put("svr_id", svrId);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchArInvRevTpSrcCdRSQL(), param, velParam);
			while(dbRowset.next()){
				invRevTpSrcCd = dbRowset.getString("inv_rev_tp_src_cd");

            }
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return invRevTpSrcCd;
	}
	
	/**
	 * INV_BKG_IF_MN table 저장<br>
	 * 
	 * @param String vvdCd
	 * @param String whfBndCd
	 * @param String portCd
	 * @param String userId
	 * @param String whfDeclCxlFlg
	 * @return String
	 * @exception DAOException
	 */
	  @SuppressWarnings("unchecked")
	public String addInvBkgWhfIf( String vvdCd, String whfBndCd, String portCd, String userId ,String whfDeclCxlFlg)  throws DAOException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, Object> rtnMap = new HashMap<String, Object>();
		String result = "";
		try {			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("vvd_cd", vvdCd);		
			mapVO.put("whf_bnd_cd", whfBndCd);
			mapVO.put("port_cd", portCd);
			mapVO.put("user_id", userId);
			mapVO.put("whf_decl_cxl_flg", whfDeclCxlFlg);
			mapVO.put("o_result", "");
			mapVO.put("o_err_msg", "");
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			rtnMap = new SQLExecuter(dataSource).executeSP((ISQLTemplate)new BookingARCreationDBDAOAddInvBkgWhfIfTblCSQL(), param, velParam);
			
			log.debug("---------------------------------------------------------");
			log.debug("rtnMap:" + rtnMap);
			
			result = rtnMap.get("o_result")==null?"":(String)rtnMap.get("o_result");
			String errMsg = rtnMap.get("o_err_msg")==null?"":(String)rtnMap.get("o_err_msg");
            
			log.debug("---------------------------------------------------------");		
			
			log.debug("result="+result);
			log.debug("errMsg="+errMsg);	
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		
		return result;	
	}
	  
	 /**
	 * BKG_RATE 테이블에서 해당 BKG_NO의 PPD OFC select<br>
	 * 
	 * @param String bkgNo
	 * @return BkgOfcPayIndVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgOfcPayIndVO searchEurPpdOfc (String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		BkgOfcPayIndVO bkgOfcPayIndVO = new BkgOfcPayIndVO();
		List<BkgOfcPayIndVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchEurPpdOfcRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgOfcPayIndVO .class);
			
			if (list != null && list.size() > 0) {
				bkgOfcPayIndVO = (BkgOfcPayIndVO) list.get(0);
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgOfcPayIndVO;
	}
	
	/**
	 * INV_AR_AMT table 저장 BKG Interface 용<br>
	 * 
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @param String ofcCd
	 * @param String custCntCd
	 * @param String custSeq
	 * @exception DAOException
	 */                  
    public void addInvBkgIfFacChg(String bkgNo, String bkgSeq, String ofcCd, String custCntCd, String custSeq ) throws DAOException {
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
    	int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("cust_cnt_cd", custCntCd);
			mapVO.put("cust_seq", custSeq);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOAddInvBkgIfFacChgCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
    
    }	
    
    
    /**
     * BLNo 내에 M Type 외의 IFNo 가 존재하는지 체크한다<br>
     * 
     * @param String blSrcNo
     * @param String ofcCd
     * @return int
     * @exception DAOException
     */
	public int checkMRIBlNoForDueDt(String blSrcNo, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
	
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bl_src_no", blSrcNo);
			mapVO.put("ofc_cd", ofcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);					

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOCheckMRIBlNoForDueDtRSQL(), param, velParam);
            if(dbRowset.next()) {						
            	cnt = dbRowset.getInt("cnt");
	    	}
            
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}	
	
	
	/**
	 * INV_AR_MN 의 WHF CANCEL시 WHF_DECL_NO 삭제 <br>
	 * 
	 * @param String blSrcNo
	 * @param String ofcCd
	 * @param String whfDeclNo
	 * @param String usrId
	 * @exception DAOException
	 */
	
	public void modifyWhfDeclNo(String blSrcNo,String ofcCd, String whfDeclNo, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bl_src_no", blSrcNo);
			mapVO.put("ar_ofc_cd", ofcCd);
			mapVO.put("whf_decl_no", whfDeclNo);
			mapVO.put("usr_id", usrId);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifyWHFDeclNoUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
     * MDM_COUNTRY 에서 EU 국가 여부 체크<br>
     * 
     * @param String cntCd
     * @return int
     * @exception DAOException
     */
	public int checkEurCountry(String cntCd) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
	
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("cnt_cd", cntCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);					

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOCheckEurCountryRSQL(), param, velParam);
            if(dbRowset.next()) {						
            	cnt = dbRowset.getInt("cnt");
	    	}
            
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cnt;
	}	
	
	/**
     * MDM_COUNTRY 에서 OFFICE 로 EU 국가 여부 체크<br>
     * 
     * @param String ofcCd
     * @param String sailArrDt
     * @return String
     * @exception DAOException
     */
	public String checkEurOffice(String ofcCd, String sailArrDt) throws DAOException {
		DBRowSet dbRowset = null;
		String cntCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
	
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("sail_arr_dt", sailArrDt);
			param.putAll(mapVO);
			velParam.putAll(mapVO);					

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOCheckEurOfficeRSQL(), param, velParam);
            if(dbRowset.next()) {						
            	cntCd = dbRowset.getString("cnt_cd");
	    	}
            
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return cntCd;
	}	
	
	
	/**
	 * ifNo 로 Euro Charge 금액 계산 <br>
	 * 
	 * @param String arIfNo
	 * @param String cntCd
	 * @param String sailArrDt
	 * @exception DAOException
	 */
	
	public void modifyEuroCharge(String arIfNo, String cntCd, String sailArrDt) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", arIfNo);
			mapVO.put("cnt_cd", cntCd);
			mapVO.put("sail_arr_dt", sailArrDt);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifyEuroChargeUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
  	*  Office 로 INV_VAT_CHG_CD조회<br>
  	* 
	* @param  String ofcCd
	* @return String
	* @exception DAOException
	*/
	public String searchInvVatChgCd( String ofcCd ) throws DAOException {
		DBRowSet dbRowset = null;
		String invVatChgCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{							
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchInvVatChgCdRSQL(), param, velParam);
			if(dbRowset.next()) {						
				invVatChgCd = dbRowset.getString("inv_vat_chg_cd");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return invVatChgCd;
	}
	
	
	/**
	 * INV_AR_MN 테이블 RVS_CHG_FLG 업데이트 <br>
	 * 
	 * @param String rvsChgFlg
	 * @param String arIfNo
	 * @param String usrId
	 * @exception DAOException
	 */
	
	public void modifyReverseChargeFlag(String rvsChgFlg, String arIfNo, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("usr_id", usrId);
			mapVO.put("ar_if_no", arIfNo);
			mapVO.put("rvs_chg_flg", rvsChgFlg);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifyReverseChargeFlagUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
     * INV_AR_CHG 테이블에서 IEV CHARGE DELETE. <br>
     * 
     * @param String ifNo
     * @exception DAOException
     */
	public void removeEuroCharge(String ifNo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_if_no", ifNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAORemoveEuroChargeDSQL(), param, velParam);
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
	 * @param InvIssVO invIssVO
	 * @return List<ArMainRecoveryDataVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ArMainRecoveryDataVO> searchRecoveryDataForSysClear(InvIssVO invIssVO)throws DAOException,Exception {

		DBRowSet dbRowset = null;
		List<ArMainRecoveryDataVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
						
		try{
			
			Map<String, String> mapVO = invIssVO.getColumnValues();
						
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchRecoveryDataForSysClearRSQL(), param, velParam);
			if(dbRowset != null) {						
	           	list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArMainRecoveryDataVO .class);
		    }
			
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
	 * @param InvIssVO invIssVO
	 * @return List<ArMainRecoveryDataVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<ArMainRecoveryDataVO> searchChangedDataForSysClear(InvIssVO invIssVO)throws DAOException,Exception {
		
		DBRowSet dbRowset = null;
		List<ArMainRecoveryDataVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 
		
		try{
			
			Map<String, String> mapVO = invIssVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchChangedDataForSysClearRSQL(), param, velParam);
			if(dbRowset != null) {						
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ArMainRecoveryDataVO .class);
			}
			
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
	 * @param InvIssVO invIssVO
	 * @param List<ArMainRecoveryDataVO> arMainRecoveryDataVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyRecoveryAmountForSysClear (InvIssVO invIssVO, List<ArMainRecoveryDataVO> arMainRecoveryDataVOs) throws DAOException,Exception {

		try {
			for (ArMainRecoveryDataVO vo : arMainRecoveryDataVOs ) {
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();
				int result = 0;

				param.put("wrk_no", invIssVO.getWrkNo());
				Map<String, String> mapVO = vo.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
					
				SQLExecuter sqlExe = new SQLExecuter(dataSource);
				result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOmodifyRecoveryAmountForSysClearUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED) {
						throw new DAOException("Fail to update SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * @param InvIssVO invIssVO
	 * @param List<ArMainRecoveryDataVO> arMainRecoveryDataVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyRecoveryMainForSysClear (InvIssVO invIssVO, List<ArMainRecoveryDataVO> arMainRecoveryDataVOs) throws DAOException,Exception {
		
		try {
			for (ArMainRecoveryDataVO vo : arMainRecoveryDataVOs ) {
				int result = 0;
				//query parameter
				Map<String, Object> param = new HashMap<String, Object>();
				//velocity parameter
				Map<String, Object> velParam = new HashMap<String, Object>();

				param.put("wrk_no", invIssVO.getWrkNo());
				Map<String, String> mapVO = vo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
					
				SQLExecuter sqlExe = new SQLExecuter(dataSource);
				result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOmodifyRecoveryMainForSysClearUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to update SQL");
				}
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * INV_AR_CHG, INV_AR_MN 테이블에 Update ( OTS_SMRY_CD = 'BL' 인 OFC 에 한해서 기존 MAX(I/F NO) 의 INV_AR_MN 의 환율이 0 인데 CANCEL 되는거라면 무조건 SYS CLEAR) <br>
	 * 
	 * @param String maxIfNo
	 * @param String cancelIfNo
	 * @param String usrId
 	 * @exception DAOException
	 */	
	public void modifySysClearFlagForBLType(String maxIfNo, String cancelIfNo, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("max_if_no", maxIfNo);
			mapVO.put("cancel_if_no", cancelIfNo);
			mapVO.put("upd_usr_id", usrId);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifySysClearFlagForBLTypeUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update INV_AR_CHG SQL");
			//log.debug(">>update INV_AR_CHG cnt ="+result);
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifySysClearFlagMainForBLTypeUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update INV_AR_MN SQL");
			//log.debug(">>update INV_AR_MN cnt ="+result);
			
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * INV_BKG_IF_CHG 테이블에 Update (Cut Off Lane로직을 거친 Ofc CD를 INV_BKG_IF_CHG의 AR_OFC_CD칼럼에 업데이트한다.) <br>
	 * 
	 * @param String arOfcCd
	 * @param String bkgNo
	 * @param String bkgSeq
	 * @param String chgSeq
	 * @exception DAOException
	 */	
	public void modifyBKGChgOffice(String arOfcCd, String bkgNo, String bkgSeq, String chgSeq) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", arOfcCd);
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("bkg_seq", bkgSeq);
			mapVO.put("chg_seq", chgSeq);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter(dataSource);
			result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifyBKGChgOfficeUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update INV_BKG_IF_CHG SQL");
						
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
	
	/**
	 * BKG-INV간 데이타 누락건 보안을 위한 로그삽입을 위해 BKG_FUNC_PROC_LOG_PRC 호출<br>
	 * 
	 * @param String bkgNo
	 * @param String seq
	 * @exception DAOException
	 */
	public void addBkgInvHis( String bkgNo, String seq)  throws DAOException{
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {			
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("seq", seq);
			mapVO.put("error_code", "");
			mapVO.put("bkg_no", bkgNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			new SQLExecuter(dataSource).executeSP((ISQLTemplate)new BookingARCreationDBDAOAddBkgInvHistoryCSQL(), param, velParam);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}	
		


	/**
	 * Credit Customer에 Payment Day가 존재할 경우 이전에 구한 Due_dt에 신용화주별 Payment Day를 적용하여 새로 Due_dt를 구함.<br>
     * Paymet Day가 존재하지 않거나 신용화주가 아닐경우 입력받은 Due_dt를 유지함.<br>
	 * @param due_dt
	 * @param cust_cnt_cd
	 * @param cust_seq
	 * @return
	 * @throws DAOException
	 */
	public String searchDueDateByCustPayDay(String due_dt, String cust_cnt_cd, String cust_seq)  throws DAOException{
	
		DBRowSet dbRowset = null;
		String retValue = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {			
			Map<String, String> mapVO = new HashMap<String, String>();
			if (due_dt != null && due_dt.contains("-")) {   
				due_dt = due_dt.replace("-", "");
			}
			mapVO.put("due_dt", due_dt);
			mapVO.put("cust_cnt_cd", cust_cnt_cd);
			mapVO.put("cust_seq", cust_seq);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchDueDateByCustPayDayRSQL(), param, velParam);
			if(dbRowset.next()) {						
				retValue = dbRowset.getString("due_dt");
	    	}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		
		return retValue;
	}
	
	
	/**
     * DXBSC의 경우 최근 I/F 된 AR Office가 DXBSC 인지 DOHBA 인지 Check<br>
     * 가장 최근 I/F 된 AR Office가 DXBSC 인지 DOHBA 인지 Check 하는 Query임<br>
     * @param String blSrcNo
     * @return String 
     * @exception DAOException
     */
	public String searchOldCutOffLaneOffice(String blSrcNo) throws DAOException {
		DBRowSet dbRowset = null;
		String oldCutOffArOfc = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
	
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("bl_src_no", blSrcNo);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchOldCutOffLaneOfficeRSQL(), param, velParam);
            if(dbRowset.next()) {						
            	oldCutOffArOfc = dbRowset.getString("ar_ofc_cd");
	    	}
            
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return oldCutOffArOfc;
	}
	
	/**
     * MDM에서 삭제된 Office 경우 CutOffLane에 변경된 AR Office가 등록되어있는지 Check<br>
     * MDM 삭제된 Office의 AR Office를 CutOffLane에서 새로 구하는 Query임<br>
     * @param String arOfcCode
     * @param String ioBndCode
     * @return String 
     * @exception DAOException
     */
	public String searchCheckCutOffLaneOffice(String arOfcCode, String ioBndCode) throws DAOException {
		DBRowSet dbRowset = null;
		String checkedCutOffArOfcCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
	
			Map<String, String> mapVO = new HashMap<String, String>();
			
			mapVO.put("ar_ofc_cd", arOfcCode);
			mapVO.put("io_bnd_cd", ioBndCode);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchCheckCutOffLaneOfficeRSQL(), param, velParam);
            if(dbRowset.next()) {						
            	checkedCutOffArOfcCd = dbRowset.getString("new_ar_ofc_cd");
	    	}
            
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return checkedCutOffArOfcCd;
	}
	
	/**
	 * AP_PERIOD 테이블에서 MRI Eff Date select<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchMRIEffectiveDate(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String effMonth = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchMRIEffectiveDateRSQL(), param, velParam);
			while(dbRowset.next()){
				effMonth = dbRowset.getString("eff_yrmon");

            }
			//list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenueAcctVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return effMonth;
	}	
	
	/**
  	*  BKG_BOOKING에서 Contract Sales rep code 조회<br>
  	* 
	* @param  String arOfcCd
	* @param  String blSrcNo
	* @return String
	* @exception DAOException
	*/
	public String searchContracSrepCd( String arOfcCd, String blSrcNo) throws DAOException {
		DBRowSet dbRowset = null;
		String ctrtSrepCd = null;
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
							
			dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchContracSrepCdRSQL(), param, velParam);
			if(dbRowset.next()) {						
				ctrtSrepCd = dbRowset.getString("ctrt_srep_cd");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return ctrtSrepCd;
	}
	
	
	/**
  	*  AR Center Code INV_AR_CHG Update<br>
  	* 
	* @param  String arIfNo
	* @exception DAOException
	*/                  
	    public void modifyInvCoaCtrCd(String arIfNo) throws DAOException {
	    	//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	 
	    	int result = 0;
			try {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("ar_if_no", arIfNo);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
					
				SQLExecuter sqlExe = new SQLExecuter(dataSource);
				result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifyInvCoaCtrCdUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}    
	    }	
	    
		/**
	  	*  AR Center Code INV_AR_AMT Update<br>
	  	* 
		* @param  String arIfNo
		* @exception DAOException
		*/                  
	    public void modifyInvCoaCtrCdToAmt(String arIfNo) throws DAOException {
	    	//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	 
	    	int result = 0;
			try {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("ar_if_no", arIfNo);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
					
				SQLExecuter sqlExe = new SQLExecuter(dataSource);
				result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifyInvCoaCtrCdToAmtUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}    
	    }
	    
	    /**
		 * INV_AR_MN 테이블에서 해당 BL이 INV내에서 수정된 이력이 있는지 조회<br>
		 * 
		 * @param String arOfcCd
		 * @param String blSrcNo
		 * @return String
		 * @exception DAOException
		 */
		@SuppressWarnings("unchecked")
		public String searchCheckCorrectionInvoice(String arOfcCd, String blSrcNo) throws DAOException {
			DBRowSet dbRowset = null;
			String chkCorrectFlg = "";
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

				dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchCheckCorrectionInvoiceRSQL(), param, velParam);
				if(dbRowset.next()) {						
					chkCorrectFlg = dbRowset.getString("chk_correct_flg");
		    	}
			} catch(SQLException se) {
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(), se);
			} catch(Exception ex) {
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
			}
			return chkCorrectFlg;
		}
		
		
		/**
	  	*  WHF 금액 INV와 BKG 비교<br>
	  	* 
		* @param  String bkgNo
		* @return String
		* @exception DAOException
		*/
		public String searchWhfDiffCheck( String bkgNo) throws DAOException {
			DBRowSet dbRowset = null;
			String whfDiffChk = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	 
							
			try{							
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("bkg_no", bkgNo);
							
				param.putAll(mapVO);
				velParam.putAll(mapVO);
								
				dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchWhfDiffCheckRSQL(), param, velParam);
				if(dbRowset.next()) {						
					whfDiffChk = dbRowset.getString("whf_diff_chk");
		    	}
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return whfDiffChk;
		}

		/**
		 * Credit Customer에 Payment Day 구하는 구분자를 가져온다.<br> W: 주, M: 기존대로
		 * @param cust_cnt_cd
		 * @param cust_seq
		 * @return String
		 * @throws DAOException
		 */
		public String searchPayTpCd(String cust_cnt_cd, String cust_seq)  throws DAOException{
		
			DBRowSet dbRowset = null;
			String retValue = "";
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try {			
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("cust_cnt_cd", cust_cnt_cd);
				mapVO.put("cust_seq", cust_seq);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchPayTpCdRSQL(), param, velParam);
				if(dbRowset.next()) {						
					retValue = dbRowset.getString("pay_tp_cd");
		    	}

			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			
			return retValue;
		}
		
		/**
		 * Credit Customer에 Payment Day 구하는 구분자를 가져온다.<br> 요일에 해당되는 그달의 날짜 
		 * @param String dueDt
		 * @param String cust_cnt_cd
		 * @param String cust_seq
		 * @return ARCustPayDayVO
		 * @throws DAOException
		 */
		public ARCustPayDayVO searchCustPayDay(String dueDt, String cust_cnt_cd, String cust_seq)  throws DAOException{
		
			DBRowSet dbRowset = null;
			ARCustPayDayVO aRCustPayDayVO = new ARCustPayDayVO();
			List<ARCustPayDayVO> list = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try {			
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("due_dt", dueDt);
				mapVO.put("cust_cnt_cd", cust_cnt_cd);
				mapVO.put("cust_seq", cust_seq);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchCustPayDayRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARCustPayDayVO .class);
 
				if (list != null && list.size() > 0) {
					aRCustPayDayVO = (ARCustPayDayVO) list.get(0);
				}
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			
			return aRCustPayDayVO;
		}
		
		
		/**
		 * Credit Customer에 Payment Day가 존재할 경우 이전에 구한 Due_dt에 신용화주별 Payment Day를 적용하여 새로 Due_dt를 구함.<br>
	     * Paymet Day가 존재하지 않거나 신용화주가 아닐경우 입력받은 Due_dt를 유지함.<br>
	     * @param String dueDt
		 * @param String colPay1
		 * @param String colPay2
		 * @param String colPay3 
		 * @param String colPay4
		 * @param String colPay5
		 * @param String payWkDyCd
		 * @param String cust_cnt_cd
		 * @param String cust_seq
		 * @return String
		 * @throws DAOException
		 */
		public String searchDueDateByWeekCustPayDay(String dueDt, String colPay1, String colPay2,String colPay3,String colPay4,String colPay5,String payWkDyCd, String cust_cnt_cd, String cust_seq)  throws DAOException{
		
			DBRowSet dbRowset = null;
			String retValue = "";
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try {			
				Map<String, String> mapVO = new HashMap<String, String>();

				mapVO.put("due_dt", dueDt);
				mapVO.put("col_pay_1", colPay1);
				mapVO.put("col_pay_2", colPay2);
				mapVO.put("col_pay_3", colPay3);
				mapVO.put("col_pay_4", colPay4);
				mapVO.put("col_pay_5", colPay5);
				mapVO.put("pay_wk_dy_cd", payWkDyCd);
				mapVO.put("cust_cnt_cd", cust_cnt_cd);
				mapVO.put("cust_seq", cust_seq);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchDueDateByWeekCustPayDayRSQL(), param, velParam);
				if(dbRowset.next()) {						
					retValue = dbRowset.getString("due_dt");
		    	}

			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			
			return retValue;
		}

		/**
		 * Office charge Taxable 조회<br>
		 * 
		 * @param String ofcCd
		 * @param String ioBnd
		 * @param String chgCd
		 * @return String
		 * @exception DAOException
		 */
		public String searchTvaFlg(String ofcCd, String ioBnd, String chgCd) throws DAOException {
			DBRowSet dbRowset = null;
			String tvaFlg = "N";
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("ofc_cd", ofcCd);
				mapVO.put("io_bnd_cd", ioBnd);
				mapVO.put("chg_cd", chgCd);
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchTvaFlgByChargeRSQL(), param, velParam);
				while(dbRowset.next()){
					tvaFlg = dbRowset.getString("tva_flg");
	            }
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return tvaFlg;
		}			
		
		/**
		 * old Booking 조회<br>
		 * 
		 * @param String bkgNo
		 * @return String
		 * @exception DAOException
		 */
		public String searchOldBkgCnt(String bkgNo) throws DAOException {
			DBRowSet dbRowset = null;
			String oldBkgCnt = "";
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("bkg_no", bkgNo);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOsearchOldBkgCntRSQL(), param, velParam);
				while(dbRowset.next()){
					oldBkgCnt = dbRowset.getString("old_bkg_cnt");
	            }
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return oldBkgCnt;
		}	
		
		/**
		 * INDIA GST type Select<br>
		 * 
		 * @param String loginOfcCd
		 * @param String wrkNo
		 * @return List<INDGstTypeVO>
		 * @exception DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<INDGstTypeVO> searchINDGstTpCd (String loginOfcCd, String wrkNo) throws DAOException {
			DBRowSet dbRowset = null;
			List<INDGstTypeVO> list = null;

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	 
							
			try{
								
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("login_ofc_cd", loginOfcCd);
				mapVO.put("wrk_no", wrkNo);
							
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchINDGstTpCdRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, INDGstTypeVO .class);
				
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
		 * GST Rate Update<br>
		 * 
		 * @param String indGstTpCd
		 * @param String userId
		 * @param String arIfNo
		 * @exception DAOException
		 */
	    public void modifyINDGstRto(String indGstTpCd, String userId, String arIfNo) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				Map<String, String> mapVO = new HashMap<String, String>();
				
				mapVO.put("ind_gst_tp_cd", indGstTpCd);		
				mapVO.put("user_id", userId);
				mapVO.put("ar_if_no", arIfNo);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter(dataSource);
				int result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifyINDGstRtoUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
		}
	    
	    /**
		 * GST Amount Update<br>
		 * 
		 * @param String dpPrcsKnt
		 * @param String userId
		 * @param String arIfNo
		 * @exception DAOException
		 */
	    public void modifyINDGstAmt(String dpPrcsKnt, String userId, String arIfNo) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				Map<String, String> mapVO = new HashMap<String, String>();
				
				mapVO.put("dp_prcs_knt", dpPrcsKnt);	
				mapVO.put("user_id", userId);
				mapVO.put("ar_if_no", arIfNo);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter(dataSource);
				int result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifyINDGstAmtUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
		}
	    
	    /**
		 * GST Type Code Update<br>
		 * 
		 * @param String indGstTpCd
		 * @param String indIssTpCd
		 * @param String loginOfcCd
		 * @param String userId
		 * @param String arIfNo
		 * @exception DAOException
		 */
	    public void modifyINDGstTpCd(String indGstTpCd, String indIssTpCd, String loginOfcCd, String userId, String arIfNo) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				Map<String, String> mapVO = new HashMap<String, String>();
				
				mapVO.put("ind_gst_tp_cd", indGstTpCd);
				mapVO.put("ind_iss_tp_cd", indIssTpCd);
				mapVO.put("login_ofc_cd", loginOfcCd);
				mapVO.put("user_id", userId);
				mapVO.put("ar_if_no", arIfNo);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter(dataSource);
				int result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifyINDGstTpCdUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
		}
	    
	    /**
		 * No INDIA Taxable Charge Select<br>
		 * 
		 * @param String invNo
		 * @return List<INDGstTypeVO>
		 * @exception DAOException
		 */
		@SuppressWarnings("unchecked")
		public List<INDGstTypeVO> searchNoINDTaxableChg (String invNo) throws DAOException {
			DBRowSet dbRowset = null;
			List<INDGstTypeVO> list = null;

			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();	 
							
			try{
								
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("inv_no", invNo);
							
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter(dataSource).executeQuery((ISQLTemplate)new BookingARCreationDBDAOSearchNoINDTaxableChgRSQL(), param, velParam);
				list = (List)RowSetUtil.rowSetToVOs(dbRowset, INDGstTypeVO .class);
				
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
		 * No INDIA SAC Code Update<br>
		 * 
		 * @param String userId
		 * @param String arIfNo
		 * @exception DAOException
		 */
	    public void modifyNoINDSacCd(String userId, String arIfNo) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				Map<String, String> mapVO = new HashMap<String, String>();
					
				mapVO.put("user_id", userId);
				mapVO.put("ar_if_no", arIfNo);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter(dataSource);
				int result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifyNoINDSacCdUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
		}
	    
	    /**
		 * No INDIA GST Amount Update<br>
		 * 
		 * @param String dpPrcsKnt
		 * @param String userId
		 * @param String arIfNo
		 * @param String usdXchRt
		 * @exception DAOException
		 */
	    public void modifyNoINDGstAmt(String dpPrcsKnt, String userId, String arIfNo, String usdXchRt) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				Map<String, String> mapVO = new HashMap<String, String>();
				
				mapVO.put("dp_prcs_knt", dpPrcsKnt);	
				mapVO.put("user_id", userId);
				mapVO.put("ar_if_no", arIfNo);
				mapVO.put("usd_xch_rt", usdXchRt);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter(dataSource);
				int result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifyNoINDGstAmtUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
		}
	    
	    /**
		 * No INDIA Invoice No Update<br>
		 * 
		 * @param String invNo
		 * @param String userId
		 * @param String arIfNo
		 * @exception DAOException
		 */
	    public void modifyNoINDInvNo(String invNo, String userId, String arIfNo) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			try {
				Map<String, String> mapVO = new HashMap<String, String>();
				
				mapVO.put("inv_no", invNo);	
				mapVO.put("user_id", userId);
				mapVO.put("ar_if_no", arIfNo);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				SQLExecuter sqlExe = new SQLExecuter(dataSource);
				int result = sqlExe.executeUpdate((ISQLTemplate)new BookingARCreationDBDAOModifyNoINDInvNoUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update SQL");
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
		}
}