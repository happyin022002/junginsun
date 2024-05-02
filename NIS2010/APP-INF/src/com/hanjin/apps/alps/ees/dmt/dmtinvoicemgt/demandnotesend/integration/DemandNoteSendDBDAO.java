/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : demandnotesendDBDAO.java
*@FileTitle : Demand Note Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.18
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.09.18 최성환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.PayerNameParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.PayerNameVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.VendorNameVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.basic.DemandNoteSendBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteGroupListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteListParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNotePreviewEtcVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNotePreviewListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNotePreviewMstVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNotePreviewParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteRDListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteRDParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ARActualPayerVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.BookingCustomerVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ChargeBookingInvoiceVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS demandnotesendDBDAO <br>
 * - ALPS-DMTInvoiceMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * DemandNoteSendDBDAOSearchDemandChargeListRSQL.Query
 * @author Choi Sung Hwan
 * @see DemandNoteSendBCImpl 참조
 * @since J2EE 1.6
 */
public class DemandNoteSendDBDAO extends DBDAOSupport {

	/**
	 * [Demand Note Issue]을 [조회] 합니다.<br>
	 * 
	 * @param DemandNoteListParmVO demandNoteListParmVO
	 * @return List<DemandNoteListVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<DemandNoteListVO> searchDemandChargeList(DemandNoteListParmVO demandNoteListParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DemandNoteListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(demandNoteListParmVO != null){
				Map<String, String> mapVO = demandNoteListParmVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				//PAYER CODE의 6자리 8자리를 구분해서 처리.
				int custLen = demandNoteListParmVO.getCustCd().length();				
				velParam.put("cust_len", custLen);
				
				// CHARGE STATUS CODE에 따라 3가지 타입으로 분리해서 LIST에 저장
				String chgStsCd = demandNoteListParmVO.getDmdtChgStsCd();
				List<String> chgStsCdList = new ArrayList<String>();
				List<String> fmChgStsCdList = new ArrayList<String>();
				List<String> toChgStsCdList = new ArrayList<String>();
				StringTokenizer st2 = new StringTokenizer(chgStsCd, ",");
			    while (st2.hasMoreTokens()) {
			    	
			    	String stsCd = st2.nextToken();
			    	if(stsCd.trim().equals("U") || stsCd.trim().equals("L")){
			    		fmChgStsCdList.add(stsCd);
			    	} else if(stsCd.trim().equals("F") || stsCd.trim().equals("C") || stsCd.trim().equals("I")){
			    		toChgStsCdList.add(stsCd);
			    	} 
			    	chgStsCdList.add(stsCd);
			    }
			    
			    log.debug("[fmChgStsCdList]"+fmChgStsCdList);
			    log.debug("[toChgStsCdList]"+toChgStsCdList);
			    
			    velParam.put("fm_chg_size", fmChgStsCdList.size());
			    velParam.put("to_chg_size", toChgStsCdList.size());
			    
				velParam.put("fm_chg_sts_cd_list", fmChgStsCdList);
				velParam.put("to_chg_sts_cd_list", toChgStsCdList);
				velParam.put("chg_sts_cd_list", chgStsCdList);
				
				
				if(demandNoteListParmVO.getCondType().equals("cntr")) {
					if(!demandNoteListParmVO.getBkgNo().equals("")) {
						String bkgNo = demandNoteListParmVO.getBkgNo();
						List<String> bkgNoList = new ArrayList<String>();
						StringTokenizer st3 = new StringTokenizer(bkgNo, ",");
					    while (st3.hasMoreTokens()) {
					    	bkgNoList.add(st3.nextToken());
					    }
						velParam.put("bkg_no_list", bkgNoList);
					}
					
					if(!demandNoteListParmVO.getBlNo().equals("")) {
						String blNo = demandNoteListParmVO.getBlNo();
						List<String> blNoList = new ArrayList<String>();
						StringTokenizer st4 = new StringTokenizer(blNo, ",");
					    while (st4.hasMoreTokens()) {
					    	blNoList.add(st4.nextToken());
					    }
						velParam.put("bl_no_list", blNoList);
					}
					
					if(!demandNoteListParmVO.getCntrNo().equals("")) {
						String cntrNo = demandNoteListParmVO.getCntrNo();
						List<String> cntrNoList = new ArrayList<String>();
						StringTokenizer st5 = new StringTokenizer(cntrNo, ",");
					    while (st5.hasMoreTokens()) {
					    	cntrNoList.add(st5.nextToken());
					    }
						velParam.put("cntr_no_list", cntrNoList);
					}
				}
			}
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DemandNoteSendDBDAOSearchDemandChargeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DemandNoteListVO .class);
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
	* [Demand Note Issue - Group]을 [조회] 합니다.<br>
	* 
	* @param DemandNoteParmVO demandNoteParmVO
	* @return List<DemandNoteGroupListVO>
	* @throws DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<DemandNoteGroupListVO> searchDemandNoteByGroup(DemandNoteParmVO demandNoteParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DemandNoteGroupListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("[Parm:DmdtChgStsCds]"+demandNoteParmVO.getDmdtChgStsCds());
		log.debug("[Parm:SBkgNo]"+demandNoteParmVO.getSBkgNo());
		log.debug("[Parm:SDmdtTrfCd]"+demandNoteParmVO.getSDmdtTrfCd());
		log.debug("[Parm:SOfcCd]"+demandNoteParmVO.getSOfcCd());
		try{
			if(demandNoteParmVO != null){
				Map<String, String> mapVO = demandNoteParmVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//1. dmdtChargeStatusCode list
				String chgStsCd = demandNoteParmVO.getDmdtChgStsCds();
				List<String> chgStsCdList = new ArrayList<String>();
				StringTokenizer st2 = new StringTokenizer(chgStsCd, ",");
			    while (st2.hasMoreTokens()) {
			    	chgStsCdList.add(st2.nextToken());
			    }
				velParam.put("chg_sts_cd_list", chgStsCdList);
				
				//2. bkg no list
				String bkgNo = demandNoteParmVO.getSBkgNo();
				List<String> bkgNoList = new ArrayList<String>();
				StringTokenizer st3 = new StringTokenizer(bkgNo, ",");
			    while (st3.hasMoreTokens()) {
			    	bkgNoList.add(st3.nextToken());
			    }
				velParam.put("bkg_no_list", bkgNoList);
					
			}
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DemandNoteSendDBDAOSearchDemandNoteByGroupRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DemandNoteGroupListVO .class);
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
	* [Demand Note Issue Preview - Master data] 을 [조회] 합니다.<br>
	* 
	* @param DemandNotePreviewParmVO demandNotePreviewParmVO
	* @return DemandNotePreviewMstVO
	* @throws DAOException
	*/
	public DemandNotePreviewMstVO searchDemandNoteIssueMstPreview(DemandNotePreviewParmVO demandNotePreviewParmVO) throws DAOException {		 
		 
		DBRowSet dbRowset = null;
		DemandNotePreviewMstVO demandNotePreviewMstVO = new DemandNotePreviewMstVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(demandNotePreviewParmVO != null){
				Map<String, String> mapVO = demandNotePreviewParmVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
		
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DemandNoteSendDBDAOSearchDemandNoteIssueMstPreviewRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				if(demandNotePreviewParmVO.getCallToRdTp().equals("group")){
					demandNotePreviewMstVO.setCustVat(StringUtils.defaultString(dbRowset.getString("cust_vat")));
					demandNotePreviewMstVO.setOfcAdd01(StringUtils.defaultString(dbRowset.getString("ofc_add01")));
					demandNotePreviewMstVO.setOfcAdd02(StringUtils.defaultString(dbRowset.getString("ofc_add02")));
					demandNotePreviewMstVO.setOfcAdd03(StringUtils.defaultString(dbRowset.getString("ofc_add03")));
					demandNotePreviewMstVO.setAddress01(StringUtils.defaultString(dbRowset.getString("address01")));
					demandNotePreviewMstVO.setHeader01(StringUtils.defaultString(dbRowset.getString("header01")));
					demandNotePreviewMstVO.setHeader02(StringUtils.defaultString(dbRowset.getString("header02")));
					demandNotePreviewMstVO.setHeader03(StringUtils.defaultString(dbRowset.getString("header03")));
					demandNotePreviewMstVO.setHeader04(StringUtils.defaultString(dbRowset.getString("header04")));
					demandNotePreviewMstVO.setHeader05(StringUtils.defaultString(dbRowset.getString("header05")));
					demandNotePreviewMstVO.setHeader06(StringUtils.defaultString(dbRowset.getString("header06")));
					demandNotePreviewMstVO.setHeader07(StringUtils.defaultString(dbRowset.getString("header07")));
					demandNotePreviewMstVO.setHeader08(StringUtils.defaultString(dbRowset.getString("header08")));
					demandNotePreviewMstVO.setHeader09(StringUtils.defaultString(dbRowset.getString("header09")));
					demandNotePreviewMstVO.setHeader10(StringUtils.defaultString(dbRowset.getString("header10")));
					demandNotePreviewMstVO.setShNum(StringUtils.defaultString(dbRowset.getString("sh_num")));
					demandNotePreviewMstVO.setHjsRef(StringUtils.defaultString(dbRowset.getString("hjs_ref")));
					demandNotePreviewMstVO.setPrintDate(StringUtils.defaultString(dbRowset.getString("print_date")));
					demandNotePreviewMstVO.setDmdtTrfNm(StringUtils.defaultString(dbRowset.getString("dmdt_trf_nm")));
					demandNotePreviewMstVO.setTitle(StringUtils.defaultString(dbRowset.getString("title")));
					demandNotePreviewMstVO.setTaxNm(StringUtils.defaultString(dbRowset.getString("tax_nm")));
				} else {
					demandNotePreviewMstVO.setCustVat(StringUtils.defaultString(dbRowset.getString("cust_vat")));
					demandNotePreviewMstVO.setOfcAdd01(StringUtils.defaultString(dbRowset.getString("ofc_add01")));
					demandNotePreviewMstVO.setOfcAdd02(StringUtils.defaultString(dbRowset.getString("ofc_add02")));
					demandNotePreviewMstVO.setOfcAdd03(StringUtils.defaultString(dbRowset.getString("ofc_add03")));
					demandNotePreviewMstVO.setAddress01(StringUtils.defaultString(dbRowset.getString("address01")));
					demandNotePreviewMstVO.setHeader01(StringUtils.defaultString(dbRowset.getString("header01")));
					demandNotePreviewMstVO.setHeader02(StringUtils.defaultString(dbRowset.getString("header02")));
					demandNotePreviewMstVO.setHeader03(StringUtils.defaultString(dbRowset.getString("header03")));
					demandNotePreviewMstVO.setHeader04(StringUtils.defaultString(dbRowset.getString("header04")));
					demandNotePreviewMstVO.setHeader05(StringUtils.defaultString(dbRowset.getString("header05")));
					
					demandNotePreviewMstVO.setSheetRemark01(StringUtils.defaultString(dbRowset.getString("sheet_remark01")));
					demandNotePreviewMstVO.setSheetRemark02(StringUtils.defaultString(dbRowset.getString("sheet_remark02")));
					demandNotePreviewMstVO.setSheetRemark03(StringUtils.defaultString(dbRowset.getString("sheet_remark03")));
					demandNotePreviewMstVO.setSheetRemark04(StringUtils.defaultString(dbRowset.getString("sheet_remark04")));
					demandNotePreviewMstVO.setSheetRemark05(StringUtils.defaultString(dbRowset.getString("sheet_remark05")));
					demandNotePreviewMstVO.setSheetRemark06(StringUtils.defaultString(dbRowset.getString("sheet_remark06")));
					demandNotePreviewMstVO.setSheetRemark07(StringUtils.defaultString(dbRowset.getString("sheet_remark07")));
					demandNotePreviewMstVO.setSheetRemark08(StringUtils.defaultString(dbRowset.getString("sheet_remark08")));
					demandNotePreviewMstVO.setSheetRemark09(StringUtils.defaultString(dbRowset.getString("sheet_remark09")));
					demandNotePreviewMstVO.setSheetRemark10(StringUtils.defaultString(dbRowset.getString("sheet_remark10")));
					demandNotePreviewMstVO.setSheetRemark11(StringUtils.defaultString(dbRowset.getString("sheet_remark11")));
					demandNotePreviewMstVO.setSheetRemark12(StringUtils.defaultString(dbRowset.getString("sheet_remark12")));
					demandNotePreviewMstVO.setSheetRemark13(StringUtils.defaultString(dbRowset.getString("sheet_remark13")));
					demandNotePreviewMstVO.setSheetRemark14(StringUtils.defaultString(dbRowset.getString("sheet_remark14")));
					demandNotePreviewMstVO.setShNum(StringUtils.defaultString(dbRowset.getString("sh_num")));
					demandNotePreviewMstVO.setHjsRef(StringUtils.defaultString(dbRowset.getString("hjs_ref")));
					demandNotePreviewMstVO.setPrintDate(StringUtils.defaultString(dbRowset.getString("print_date")));					
					demandNotePreviewMstVO.setTitle(StringUtils.defaultString(dbRowset.getString("title")));
					demandNotePreviewMstVO.setTaxNm(StringUtils.defaultString(dbRowset.getString("tax_nm")));
				}
			} else {
				log.debug("============================================================================");
				log.debug(" searchDemandNoteIssueMstPreview:::: No Data");
				log.debug("============================================================================");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return demandNotePreviewMstVO;
	} 
	
   /**
	* [Demand Note Issue Preview - Etc data] 을 [조회] 합니다.<br>
	* 
	* @param DemandNotePreviewParmVO demandNotePreviewParmVO
	* @return DemandNotePreviewEtcVO
	* @throws DAOException
	*/
	public DemandNotePreviewEtcVO searchDemandNoteIssueEtcPreview(DemandNotePreviewParmVO demandNotePreviewParmVO) throws DAOException {		 
		 
		DBRowSet dbRowset = null;
		DemandNotePreviewEtcVO demandNotePreviewEtcVO = new DemandNotePreviewEtcVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(demandNotePreviewParmVO != null){
				Map<String, String> mapVO = demandNotePreviewParmVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
		
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DemandNoteSendDBDAOSearchDemandNoteIssueEtcPreviewRSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				demandNotePreviewEtcVO.setVvdCd(StringUtils.defaultString(dbRowset.getString("vvd_cd")));
				demandNotePreviewEtcVO.setVvdNm(StringUtils.defaultString(dbRowset.getString("vvd_nm")));
				demandNotePreviewEtcVO.setArr(StringUtils.defaultString(dbRowset.getString("arr")));
				demandNotePreviewEtcVO.setDep(StringUtils.defaultString(dbRowset.getString("dep")));
				demandNotePreviewEtcVO.setBlNo(StringUtils.defaultString(dbRowset.getString("bl_no")));
				demandNotePreviewEtcVO.setBkgNo(StringUtils.defaultString(dbRowset.getString("bkg_no")));
				demandNotePreviewEtcVO.setCmdtCd(StringUtils.defaultString(dbRowset.getString("cmdt_cd")));
				demandNotePreviewEtcVO.setCmdtNm(StringUtils.defaultString(dbRowset.getString("cmdt_nm")));
				demandNotePreviewEtcVO.setDmdtTrfCd(StringUtils.defaultString(dbRowset.getString("dmdt_trf_cd")));
				demandNotePreviewEtcVO.setDmdtTrfNm(StringUtils.defaultString(dbRowset.getString("dmdt_trf_nm")));
				demandNotePreviewEtcVO.setBkgRcvTermCd(StringUtils.defaultString(dbRowset.getString("bkg_rcv_term_cd")));
				demandNotePreviewEtcVO.setBkgRcvTermNm(StringUtils.defaultString(dbRowset.getString("bkg_rcv_term_nm")));
				demandNotePreviewEtcVO.setBkgDelTermCd(StringUtils.defaultString(dbRowset.getString("bkg_del_term_cd")));
				demandNotePreviewEtcVO.setBkgDelTermNm(StringUtils.defaultString(dbRowset.getString("bkg_del_term_nm")));
				demandNotePreviewEtcVO.setPod(StringUtils.defaultString(dbRowset.getString("pod")));
				demandNotePreviewEtcVO.setPodNm(StringUtils.defaultString(dbRowset.getString("pod_nm")));
				demandNotePreviewEtcVO.setDel(StringUtils.defaultString(dbRowset.getString("del")));
				demandNotePreviewEtcVO.setDelNm(StringUtils.defaultString(dbRowset.getString("del_nm")));
				demandNotePreviewEtcVO.setTrucker(StringUtils.defaultString(dbRowset.getString("trucker")));
				demandNotePreviewEtcVO.setVndrSeq(StringUtils.defaultString(dbRowset.getString("vndr_seq")));

			} else {
				log.debug("============================================================================");
				log.debug(" searchDemandNoteIssueEtcPreview:::: No Data");
				log.debug("============================================================================");
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return demandNotePreviewEtcVO;
	} 	
	 
   /**
	* [Demand Note Issue Preview - Detail List] 을 [조회] 합니다.<br>
	* 
	* @param DemandNotePreviewParmVO demandNotePreviewParmVO
	* @return List<DemandNotePreviewListVO>
	* @throws DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<DemandNotePreviewListVO> searchDemandNoteIssueDtlPreview(DemandNotePreviewParmVO demandNotePreviewParmVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DemandNotePreviewListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(demandNotePreviewParmVO != null){
				Map<String, String> mapVO = demandNotePreviewParmVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//group에서 호출시에만 사용.
				if(demandNotePreviewParmVO.getCallToRdTp().equals("group")){
					String chgStsCd = demandNotePreviewParmVO.getDmdtChgStsCd();
					List<String> chgStsCdList = new ArrayList<String>();
					StringTokenizer st2 = new StringTokenizer(chgStsCd, ",");
				    while (st2.hasMoreTokens()) {
				    	chgStsCdList.add(st2.nextToken());
				    }
					velParam.put("chg_sts_cd_list", chgStsCdList);
					
					
					if(!demandNotePreviewParmVO.getBkgNo().equals("")) {
						String bkgNo = demandNotePreviewParmVO.getBkgNo();
						List<String> bkgNoList = new ArrayList<String>();
						StringTokenizer st3 = new StringTokenizer(bkgNo, ",");
					    while (st3.hasMoreTokens()) {
					    	bkgNoList.add(st3.nextToken());
					    }
						velParam.put("bkg_no_list", bkgNoList);
					}
				} 				
					
			}
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DemandNoteSendDBDAOSearchDemandNoteIssueDtlPreviewRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DemandNotePreviewListVO .class);
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
	* [Demand Note Issue Preview - Etc data] 을 [조회] 합니다.<br>
	* 
	* @param DemandNoteRDParmVO demandNoteRDParmVO
	* @return DemandNoteRDListVO
	* @throws DAOException
	*/
	public DemandNoteRDListVO searchDemandNoteRD( DemandNoteRDParmVO demandNoteRDParmVO) throws DAOException {		 
		 
		DBRowSet dbRowset = null;
		DemandNoteRDListVO demandNoteRDListVO = new DemandNoteRDListVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(demandNoteRDParmVO != null){
				Map<String, String> mapVO = demandNoteRDParmVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
		
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DemandNoteSendDBDAOSearchDemandNoteRDListVORSQL(), param, velParam);
			
			if(dbRowset.next()){ 
				//1.rd리스트에 필요한 조회
				demandNoteRDListVO.setCntrNo(StringUtils.defaultString(dbRowset.getString("cntr_no")));
				demandNoteRDListVO.setCntrTpszCd(StringUtils.defaultString(dbRowset.getString("cntr_tpsz_cd")));
				demandNoteRDListVO.setFmMvmtDt(StringUtils.defaultString(dbRowset.getString("fm_mvmt_dt")));
				demandNoteRDListVO.setToMvmtDt(StringUtils.defaultString(dbRowset.getString("to_mvmt_dt")));
				demandNoteRDListVO.setFtCmncDt(StringUtils.defaultString(dbRowset.getString("ft_cmnc_dt")));
				demandNoteRDListVO.setFtEndDt(StringUtils.defaultString(dbRowset.getString("ft_end_dt")));
				demandNoteRDListVO.setFtDys(StringUtils.defaultString(dbRowset.getString("ft_dys")));
				//2. 다음 조회에 필요한 데이터.
				demandNoteRDListVO.setFxFtOvrDys(StringUtils.defaultString(dbRowset.getString("fx_ft_ovr_dys")));
				demandNoteRDListVO.setBzcTrfCurrCd(StringUtils.defaultString(dbRowset.getString("bzc_trf_curr_cd")));
				demandNoteRDListVO.setSvrId(StringUtils.defaultString(dbRowset.getString("svr_id")));
				demandNoteRDListVO.setCntrCycNo(StringUtils.defaultString(dbRowset.getString("cntr_cyc_no")));
				demandNoteRDListVO.setDmdtTrfCd(StringUtils.defaultString(dbRowset.getString("dmdt_trf_cd")));
				demandNoteRDListVO.setDmdtChgLocDivCd(StringUtils.defaultString(dbRowset.getString("dmdt_chg_loc_div_cd")));
				demandNoteRDListVO.setChgSeq(StringUtils.defaultString(dbRowset.getString("chg_seq")));
				demandNoteRDListVO.setBzcTrfSeq(StringUtils.defaultString(dbRowset.getString("bzc_trf_seq")));
				demandNoteRDListVO.setBzcDmdtDeTermCd(StringUtils.defaultString(dbRowset.getString("bzc_dmdt_de_term_cd")));
				demandNoteRDListVO.setBzcTrfGrpSeq(StringUtils.defaultString(dbRowset.getString("bzc_trf_grp_seq")));
				demandNoteRDListVO.setDmdtChgStsCd(StringUtils.defaultString(dbRowset.getString("dmdt_chg_sts_cd")));
				demandNoteRDListVO.setRfaExptDarNo(StringUtils.defaultString(dbRowset.getString("rfa_expt_dar_no")));
				demandNoteRDListVO.setRfaExptMapgSeq(StringUtils.defaultString(dbRowset.getString("rfa_expt_mapg_seq")));
				demandNoteRDListVO.setRfaExptVerSeq(StringUtils.defaultString(dbRowset.getString("rfa_expt_ver_seq")));
				demandNoteRDListVO.setRfaRqstDtlSeq(StringUtils.defaultString(dbRowset.getString("rfa_rqst_dtl_seq")));
				demandNoteRDListVO.setScNo(StringUtils.defaultString(dbRowset.getString("sc_no")));
				demandNoteRDListVO.setScExptVerSeq(StringUtils.defaultString(dbRowset.getString("sc_expt_ver_seq")));
				demandNoteRDListVO.setScExptGrpSeq(StringUtils.defaultString(dbRowset.getString("sc_expt_grp_seq")));
				demandNoteRDListVO.setDmdtTrfAplyTpCd(StringUtils.defaultString(dbRowset.getString("dmdt_trf_aply_tp_cd")));
				
				demandNoteRDListVO.setFmMvmtYdCd(StringUtils.defaultString(dbRowset.getString("fm_mvmt_yd_cd")));
				demandNoteRDListVO.setBzcTrfAplyDt(StringUtils.defaultString(dbRowset.getString("bzc_trf_aply_dt")));
				demandNoteRDListVO.setScRfaExptAplyDt(StringUtils.defaultString(dbRowset.getString("sc_rfa_expt_aply_dt")));
				demandNoteRDListVO.setScRfaExptAmt(StringUtils.defaultString(dbRowset.getString("sc_rfa_expt_amt")));
				demandNoteRDListVO.setOrgFtOvrDys(StringUtils.defaultString(dbRowset.getString("org_ft_ovr_dys")));
				
			} else {
				log.debug("============================================================================");
				log.debug(" searchDemandNoteRD:::: No Data");
				log.debug("============================================================================");
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return demandNoteRDListVO;
	} 
	
    /**
 	 * OFC_CD별 현재일자를 조회한다.
 	 * 
 	 * @param String ofcCd
 	 * @return String
 	 * @throws DAOException
 	 */
 	public String searchCurrentDateByOffice(String ofcCd) throws DAOException {
 		DBRowSet dbRowset = null;
 		String curr_day = "";
 		//query parameter
 		Map<String, Object> param = new HashMap<String, Object>();
 		
 		try{
 			param.put("ofc_cd", ofcCd);
 			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DemandNoteSendDBDAOSearchCurrentDateByOfficeRSQL(), param, null);
 			if(dbRowset.next()){
 				curr_day = dbRowset.getString("curr_day");
 			}
 			
 		}catch(SQLException se){
 			log.error(se.getMessage(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		}catch(Exception ex){
 			log.error(ex.getMessage(),ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage());
 		}
 		return curr_day;
 	}	
 	
	/**
	 * 해당 Payer에 대한 PayerName 정보를 조회한다.<br>
	 * 
	 * @param PayerNameParamVO payerNameParamVO
	 * @return PayerNameVO
	 * @throws DAOException
	 */
	public PayerNameVO searchPayerInfoName(PayerNameParamVO payerNameParamVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		PayerNameVO rePayerNameVO = new PayerNameVO();
	
		try {
			if(payerNameParamVO != null){
				Map<String, String> mapVO = payerNameParamVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate) new DemandNoteSendDBDAOSearchPayerInfoNameRSQL(), param, velParam);
			
			if(dbRowset.next()) {
				rePayerNameVO.setDeltFlg(dbRowset.getString(1));
				rePayerNameVO.setCustCd(dbRowset.getString(2));
				rePayerNameVO.setCustName(dbRowset.getString(3));
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rePayerNameVO;
	} 		
	
	/**
	 * 해당 Service Provider에 대한 Vendor를 조회한다.<br>
	 * 
	 * @param String serviceProviderCode
	 * @return VendorNameVO
	 * @throws DAOException
	 */
	public VendorNameVO searchServiceProviderName(String serviceProviderCode) throws DAOException {
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		VendorNameVO reVendorNameVO = new VendorNameVO();
		String code = "";
		String name = "";
	
		try {
			if(serviceProviderCode != null){
				param.put("vndr_cd", serviceProviderCode);
				velParam.put("vndr_cd", serviceProviderCode);
			}
			
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate) new DemandNoteSendDBDAOSearchServiceProviderNameRSQL(), param, null);
			
			if(dbRowset.next()) {
				code = StringUtils.defaultString(dbRowset.getString(1));
				name = StringUtils.defaultString(dbRowset.getString(2));
			}
			reVendorNameVO.setVndrCd(code);
			reVendorNameVO.setVndrNm(name);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return reVendorNameVO;
	}		
	
    /**
     * Invoice Creation & Issue 정보를 조회 합니다.<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return ChargeBookingInvoiceVO
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ChargeBookingInvoiceVO> searchChargeBookingInvoice(IssuedInvoiceParamVO issuedInvoiceParamVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<ChargeBookingInvoiceVO> list = null;
//      ChargeBookingInvoiceVO chargeBookingInvoiceVO = new ChargeBookingInvoiceVO();
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
    
        try{
            if(issuedInvoiceParamVO != null){
                Map<String, String> mapVO = issuedInvoiceParamVO .getColumnValues();
                
                //DMDT_CHG_STS_CDS
                String dmdtChgStsCds = (String)issuedInvoiceParamVO.getDmdtChgStsCds();
                
                List<String> aryDmdtChgStsCdList = new ArrayList(); 
                StringTokenizer st = new StringTokenizer(dmdtChgStsCds, ",");
                String tempS = "";
                
                while (st.hasMoreTokens()) {
                    tempS = st.nextToken(); 
                    aryDmdtChgStsCdList.add(tempS);
                    
                    if(tempS.equals("All")) {
                        continue;
                    }
                }
                
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                velParam.put("dmdt_chg_sts_cd_list", aryDmdtChgStsCdList);

            }
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DemandNoteSendDBDAOSearchChargeBookingInvoiceRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeBookingInvoiceVO.class);
            
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
     * Booking Customer 정보를 조회 합니다.<br>
     * 
     * @param BookingCustomerVO bookingCustomerVO
     * @return List<BookingCustomerVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<BookingCustomerVO> searchBookingCustomer(BookingCustomerVO bookingCustomerVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<BookingCustomerVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
    
        try{
            if(bookingCustomerVO != null){
                Map<String, String> mapVO = bookingCustomerVO .getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DemandNoteSendDBDAOSearchBookingCustomerRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BookingCustomerVO .class);
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
     * Sheet Option 정보를 조회 합니다.<br>
     * 
     * @param SheetOptionVO sheetOptionVO
     * @return List<SheetOptionVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<SheetOptionVO> searchSheetOption(SheetOptionVO sheetOptionVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<SheetOptionVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(sheetOptionVO != null){
                Map<String, String> mapVO = sheetOptionVO .getColumnValues();
                param.putAll(mapVO);
                velParam.putAll(mapVO);
            }

            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DemandNoteSendDBDAOSearchSheetOptionRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, SheetOptionVO .class);
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
     * ARActual Payer 정보를 조회 합니다.<br>
     * 
     * @param String bookingNo
     * @param String dmdtTrfCd
     * @return List<ARActualPayerVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ARActualPayerVO> searchARActualPayer(String bookingNo, String dmdtTrfCd) throws DAOException {
        DBRowSet dbRowset = null;
        List<ARActualPayerVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(bookingNo != null){
//              Map<String, String> mapVO = sheetOptionVO .getColumnValues();
//              param.putAll(mapVO);
//              velParam.putAll(mapVO);
                param.put("bkg_no", bookingNo);
                param.put("dmdt_trf_cd", dmdtTrfCd);
                
                velParam.put("bkg_no", bookingNo);
                velParam.put("dmdt_trf_cd", dmdtTrfCd);
            }

            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DemandNoteSendDBDAOSearchARActualPayerRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARActualPayerVO .class);
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
     * Invoice 정보를 조회 합니다.<br>
     * 
     * @param IssuedInvoiceParamVO issuedInvoiceParamVO
     * @return List<InvoiceIssueVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<InvoiceIssueVO> searchChargeBookingInvoiceDetail(IssuedInvoiceParamVO issuedInvoiceParamVO) throws DAOException {
        DBRowSet dbRowset = null;
        List<InvoiceIssueVO> list = null;
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try{
            if(issuedInvoiceParamVO != null){
                Map<String, String> mapVO = issuedInvoiceParamVO .getColumnValues();
                
                //DMDT_CHG_STS_CDS
                String dmdtChgStsCds = (String)issuedInvoiceParamVO.getDmdtChgStsCds();
                
                List<String> aryDmdtChgStsCdList = new ArrayList(); 
                StringTokenizer st = new StringTokenizer(dmdtChgStsCds, ",");
                String tempS = "";
                
                while (st.hasMoreTokens()) {
                    tempS = st.nextToken(); 
                    aryDmdtChgStsCdList.add(tempS);
                    
                    if(tempS.equals("All")) {
                        continue;
                    }
                }
                
                param.putAll(mapVO);
                velParam.putAll(mapVO);
                velParam.put("dmdt_chg_sts_cd_list", aryDmdtChgStsCdList);

            }
            dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new DemandNoteSendDBDAOSearchChargeBookingInvoiceDetailRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceIssueVO .class);
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
        return list;
    }    
};
