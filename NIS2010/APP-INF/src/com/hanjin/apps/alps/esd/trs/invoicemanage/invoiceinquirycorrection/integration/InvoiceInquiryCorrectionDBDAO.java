/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceInquiryCorrectionDBDAO.java
*@FileTitle : Service Provider로부터 W/O실행 이후 비용 지불을 위한 Invoice를 일괄 Confirm하거나, Confirmed or Interfaced Invoice를 취소하는 화면
*Open Issues :
*2007-01-26 poong_yeon
*1.0 최초 생성
*Change history :
*@LastModifyDate : 2009-03-04
*@LastModifier : ah_young 
*@LastVersion : 1.63 
* N200902260160 WIS Invoice의 TRS Process User ID 표시건 요청 (2009-03-04)
* 2013.10.14 조인영 [CHM-201327030] [TRS] Inv Inquiry 화면 개선
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.apps.alps.esd.trs.common.util.CommonUtil;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.event.EsdTrs0030Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.vo.SearchInvoiceInquirySecondExcelFormVO;
import com.hanjin.apps.alps.esd.trs.invoicemanage.invoiceinquirycorrection.vo.SearchInvoiceInquiryVO;
import com.hanjin.syscommon.common.table.TrsTrspInvWrkVO;


/**
 * ESD-invoicemanage에 대한 DB 처리를 담당<br>
 * - ESD-invoicemanage Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author poong_yeon
 * @see InvoiceInquiryCorrectionBCImpl 참조
 * @since J2EE 1.4
 */
public class InvoiceInquiryCorrectionDBDAO extends DBDAOSupport {
	
	/**
	 * InvoiceInquiryCorrection의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchInvoiceInquiryCorrectionList(EsdTrs0030Event event) throws DAOException{
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		SearchInvoiceInquiryVO siiVo = event.getSearchInvoiceInquiryVO();
		try{
			
			String no_cd = siiVo.getNoCd();
			if( !no_cd.equals("") && !no_cd.equals("null") && no_cd != null) {
				ArrayList<String> noCdArr = new ArrayList<String>();
				StringTokenizer st  = null;
				int j = 0;
				
				noCdArr.clear();
				st = new StringTokenizer(no_cd, ",");
				while( st.hasMoreTokens() ) {
					String tmpStr = "";
					tmpStr = st.nextToken();
					tmpStr = tmpStr.replaceAll("\\'", "\\'\\'");
					noCdArr.add(j++, tmpStr);
				}
				param.put("noCdArr", noCdArr);
			}
			String inv_cre_ofc = siiVo.getInvCreOfc();
			if( !inv_cre_ofc.equals("") && !inv_cre_ofc.equals("null") && inv_cre_ofc != null) {
				ArrayList<String> ofcCdArr = new ArrayList<String>();
				StringTokenizer str  = null;
				int j = 0;
				
				ofcCdArr.clear();
				str = new StringTokenizer(inv_cre_ofc, ",");
				while( str.hasMoreTokens() ) {
					String tmpStr = "";
					tmpStr = str.nextToken();
					tmpStr = tmpStr.replaceAll("\\'", "\\'\\'");
					ofcCdArr.add(j++, tmpStr);
				}
				param.put("ofcCdArr", ofcCdArr);
			}

			param.put("no_tp", JSPUtil.getNull(siiVo.getNoTp()));
			param.put("fmdate", JSPUtil.getNull(siiVo.getFmdate()));
			param.put("date_cd", JSPUtil.getNull(siiVo.getDateCd()));
			param.put("fmdate", JSPUtil.getNull(siiVo.getFmdate()));
			param.put("todate", JSPUtil.getNull(siiVo.getTodate()));
			param.put("FORM_USR_OFC_CD", JSPUtil.getNull(siiVo.getFormUsrOfcCd()));
			param.put("status_cd", JSPUtil.getNull(siiVo.getStatusCd()));
			param.put("recieved_cd", JSPUtil.getNull(siiVo.getRecievedCd()));
			param.put("hold_cd", JSPUtil.getNull(siiVo.getHoldCd()));
			param.put("combo_svc_provider", JSPUtil.getNull(siiVo.getComboSvcProvider()));
			param.put("sp_tp", JSPUtil.getNull(siiVo.getSpTp()));
//			param.put("inv_cre_ofc", JSPUtil.getNull(siiVo.getInvCreOfc()));
			param.put("ivc_upd_usr_id", JSPUtil.getNull(siiVo.getIvcUpdUsrId()));
			param.put("amount_verify_cd", JSPUtil.getNull(siiVo.getAmountVerifyCd()));

			
			//Map<String, String> param_vo = siiVo.getColumnValues();
			//param.putAll(param_vo);
			dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceInquiryCorrectionDBDAOSearchInvoiceInquiryCorrectionListRSQL(), param,param);
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}

	
	/**
	 * InvoiceInquiryCorrection의 Invoice EDI PDF 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchInvoiceEdiPdfFile(EsdTrs0030Event event) throws DAOException{
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		SearchInvoiceInquiryVO searchVo = event.getSearchInvoiceInquiryVO();
		try{
			

			param.put("inv_no", searchVo.getFormInvNo());
			param.put("inv_vndr_seq", searchVo.getFormInvVndrSeq());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceInquiryCorrectionDBDAOSearchInvoiceEdiPdfFileRSQL(), param,param);
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}

	
	/**
	 * Invoice를 Confirm 상태로 변경.<br>
	 * N200902260160 WIS Invoice의 TRS Process User ID 표시건 요청 (2009-03-04)
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void confirmInvoice(EsdTrs0030Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		SearchInvoiceInquiryVO siiVo = event.getSearchInvoiceInquiryVO();
		TrsTrspInvWrkVO[] invWrkVOs = event.getTrsTrspInvWrkVOs();
		String if_sys_knd_cd = ""; 
		try{
			for(int i=0;i<invWrkVOs.length;i++){
				
				if( invWrkVOs[i] != null ){
					
					 if_sys_knd_cd = invWrkVOs[i].getIfSysKndCd();
				     
					 if (if_sys_knd_cd == null || if_sys_knd_cd.equals(""))
						if_sys_knd_cd = "E";
					 
					 
					 if(if_sys_knd_cd.equals("W") || if_sys_knd_cd.equals("I")){ //WIS, EDI 인 경우에는 CRE_USR_ID(SPP_IF)를  현재의 로그인USER ID로 변경해준다.
						param.put("cre_usr_id", siiVo.getFormCreUsrId());
						
					 }else{
						param.put("cre_usr_id", invWrkVOs[i].getCreUsrId());
					 }
					 param.put("FORM_CRE_USR_ID", siiVo.getFormCreUsrId());
					 param.put("FORM_USR_OFC_CD", siiVo.getFormUsrOfcCd());
					 param.put("inv_no", invWrkVOs[i].getInvNo());
					 param.put("inv_vndr_seq", invWrkVOs[i].getInvVndrSeq());
					 new SQLExecuter("DEFAULT").executeUpdate(new InvoiceInquiryCorrectionDBDAOConfirmInvoiceUSQL(), param,param);	
			
					param.clear();
					
					param.put("inv_no", invWrkVOs[i].getInvNo());
					param.put("inv_vndr_seq", invWrkVOs[i].getInvVndrSeq());
					dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceInquiryCorrectionDBDAOConfirmInvoiceSoRSQL(), param,param);
					
					while(dRs.next()){
						Map<String, Object> param_so = new HashMap<String, Object>();
						param_so.put("trsp_so_ofc_cty_cd", dRs.getString("TRSP_SO_OFC_CTY_CD"));
						param_so.put("trsp_so_seq", dRs.getString("TRSP_SO_SEQ"));
						param_so.put("FORM_CRE_USR_ID", siiVo.getFormCreUsrId());
						param_so.put("FORM_USR_OFC_CD", siiVo.getFormUsrOfcCd());
						new SQLExecuter("DEFAULT").executeUpdate(new InvoiceInquiryCorrectionDBDAOConfirmInvoiceSoUSQL(), param_so,param_so);	
						
					}
									
				}			
				
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
	}
	
	/**
	 * Confirm Cancle (Invoice의 상태를 Save 상태로 변경).<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void confirmCancelInvoice(EsdTrs0030Event event) throws DAOException {
		
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		SearchInvoiceInquiryVO siiVo = event.getSearchInvoiceInquiryVO();
		TrsTrspInvWrkVO[] invWrkVOs = event.getTrsTrspInvWrkVOs();
		
		try{
			
			for(int i=0;i<invWrkVOs.length;i++){
				
				if( invWrkVOs[i] != null ){
				
					param.put("inv_no", invWrkVOs[i].getInvNo());
					param.put("inv_vndr_seq", invWrkVOs[i].getInvVndrSeq());
					dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceInquiryCorrectionDBDAOConfirmCancelInvoiceConfirmYnRSQL(), param,param);
					
					while(dRs.next()){
						throw new DAOException(new ErrorHandler("TRS50106").getMessage());
					}
					
					param.clear();
					param.put("FORM_CRE_USR_ID", siiVo.getFormCreUsrId());
					param.put("FORM_USR_OFC_CD", siiVo.getFormUsrOfcCd());
					param.put("inv_no", invWrkVOs[i].getInvNo());
					param.put("inv_vndr_seq", invWrkVOs[i].getInvVndrSeq());
					new SQLExecuter("DEFAULT").executeUpdate(new InvoiceInquiryCorrectionDBDAOConfirmCancelInvoiceUSQL(), param,param);	
					new SQLExecuter("DEFAULT").executeUpdate(new InvoiceInquiryCorrectionDBDAOConfirmCancelInvoiceSoUSQL(), param,param);	
										
				}			
				
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 

	}
	
	/**
	 * saveHold Flag 변경 (CSR 발행 되지 않는다).<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void saveHold(EsdTrs0030Event event) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		SearchInvoiceInquiryVO siiVo = event.getSearchInvoiceInquiryVO();
		TrsTrspInvWrkVO[] invWrkVOs = event.getTrsTrspInvWrkVOs();
		
		try{
			
			for(int i=0;i<invWrkVOs.length;i++){
				
				if( invWrkVOs[i] != null ){
				
					
					param.put("FORM_CRE_USR_ID", JSPUtil.getNull(siiVo.getFormCreUsrId()));
					param.put("FORM_USR_OFC_CD", JSPUtil.getNull(siiVo.getFormUsrOfcCd()));
					param.put("inv_no", invWrkVOs[i].getInvNo());
					param.put("inv_vndr_seq", invWrkVOs[i].getInvVndrSeq());
					param.put("inv_hld_flg", invWrkVOs[i].getInvHldFlg());
					new SQLExecuter("DEFAULT").executeUpdate(new InvoiceInquiryCorrectionDBDAOSaveHoldUSQL(), param,param);	
										
				}			
				
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 

	}
	
	/**
	 * saveUpdUsrId<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void saveUpdUsrId(EsdTrs0030Event event) throws DAOException {

		Map<String, Object> param = new HashMap<String, Object>();
		SearchInvoiceInquiryVO siiVo = event.getSearchInvoiceInquiryVO();
		TrsTrspInvWrkVO[] invWrkVOs = event.getTrsTrspInvWrkVOs();
		
		try{
			
			for(int i=0;i<invWrkVOs.length;i++){
				
				if( invWrkVOs[i] != null ){
				
					
					param.put("FORM_CRE_USR_ID", JSPUtil.getNull(siiVo.getFormCreUsrId()));
					param.put("FORM_USR_OFC_CD", JSPUtil.getNull(siiVo.getFormUsrOfcCd()));
					param.put("inv_no", invWrkVOs[i].getInvNo());
					param.put("inv_vndr_seq", invWrkVOs[i].getInvVndrSeq());
					new SQLExecuter("DEFAULT").executeUpdate(new InvoiceInquiryCorrectionDBDAOSaveUpdUsrIdUSQL(), param,param);	
										
				}			
				
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 

	}
	
	/**
	 * InvoiceInquiryCorrection의 데이타 모델을 DB에서 삭제한다.<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void deleteInvoice(EsdTrs0030Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		SearchInvoiceInquiryVO siiVo = event.getSearchInvoiceInquiryVO();
		TrsTrspInvWrkVO[] invWrkVOs = event.getTrsTrspInvWrkVOs();
		
		try{
			
			for(int i=0;i<invWrkVOs.length;i++){
				
				if( invWrkVOs[i] != null ){
				
					param.put("inv_no", invWrkVOs[i].getInvNo());
					param.put("inv_vndr_seq", invWrkVOs[i].getInvVndrSeq());
					dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceInquiryCorrectionDBDAODeleteInvoiceStsRSQL(), param,param);
					
					while(dRs.next()){
						throw new DAOException(new ErrorHandler("TRS50107").getMessage());
					}
					
					param.clear();
					param.put("FORM_CRE_USR_ID", siiVo.getFormCreUsrId());
					param.put("FORM_USR_OFC_CD", siiVo.getFormUsrOfcCd());
					param.put("inv_no", invWrkVOs[i].getInvNo());
					param.put("inv_vndr_seq", invWrkVOs[i].getInvVndrSeq());
					new SQLExecuter("DEFAULT").executeUpdate(new InvoiceInquiryCorrectionDBDAODeleteInvoiceScgUSQL(), param,param);	
					new SQLExecuter("DEFAULT").executeUpdate(new InvoiceInquiryCorrectionDBDAODeleteInvoiceScgDSQL(), param,param);	
					new SQLExecuter("DEFAULT").executeUpdate(new InvoiceInquiryCorrectionDBDAODeleteInvoiceSoDelUSQL(), param,param);	
					new SQLExecuter("DEFAULT").executeUpdate(new InvoiceInquiryCorrectionDBDAODeleteInvoiceSoRfndDelDSQL(), param,param);	
					new SQLExecuter("DEFAULT").executeUpdate(new InvoiceInquiryCorrectionDBDAODeleteInvoiceDelDSQL(), param,param);	
								
				}			
				
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		

	}
	
	/**
	 * InvoiceInquiryCorrection의 데이타 모델을 DB에서 삭제한다.<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void modifyInvOfcCdForSPP(EsdTrs0030Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		SearchInvoiceInquiryVO siiVo = event.getSearchInvoiceInquiryVO();
		TrsTrspInvWrkVO[] invWrkVOs = event.getTrsTrspInvWrkVOs();
		
		try{
			
			for(int i=0;i<invWrkVOs.length;i++){
				
				if( invWrkVOs[i] != null ){
				
					param.put("FORM_USR_OFC_CD", JSPUtil.getNull(siiVo.getFormUsrOfcCd()));
					param.put("FORM_CRE_USR_ID", JSPUtil.getNull(siiVo.getFormCreUsrId()));
					param.put("inv_no", invWrkVOs[i].getInvNo());
					param.put("inv_vndr_seq", invWrkVOs[i].getInvVndrSeq());
					new SQLExecuter("DEFAULT").executeUpdate(new InvoiceInquiryCorrectionDBDAOModifyInvOfcCdForSPPUSQL(), param,param);	
								
				}			
				
			}
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
	}
	
	/**
	 * SO의 Invoice Total Amt를 가져온다.<br>
	 * 
	 * @param event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchInvoiceConfrimAmt(EsdTrs0030Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		SearchInvoiceInquiryVO siiVo = event.getSearchInvoiceInquiryVO();

		
		try{
			
			param.put("FORM_INV_NO", JSPUtil.getNull(siiVo.getFormInvNo()));
			param.put("FORM_INV_VNDR_SEQ", JSPUtil.getNull(siiVo.getFormInvVndrSeq()));
			dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceInquiryCorrectionDBDAOSearchInvoiceConfrimAmtRSQL(), param,param);
					
				
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	}
	
	/**
	 * Invoice DownExcel 항목 조회.<br>
	 * 
	 * @param event
	 * @return List
	 * @throws DAOException
	 */
	public List searchInvoiceInquirySecondExcelForm(EsdTrs0030Event event) throws DAOException {

		DBRowSet dbRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		TrsTrspInvWrkVO[] invWrkVOs = event.getTrsTrspInvWrkVOs();
		List<SearchInvoiceInquirySecondExcelFormVO> rsList = null;
		
		try{
			if( invWrkVOs!= null){
				for(int i=0;i<invWrkVOs.length;i++){

					if( invWrkVOs[i] != null ){			
						
						param.put("inv_no", invWrkVOs[i].getInvNo());
						param.put("inv_vndr_seq", invWrkVOs[i].getInvVndrSeq());
	
						dbRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceInquiryCorrectionDBDAOSearchInvoiceInquirySecondExcelFormRSQL(), param,param);	
						List<SearchInvoiceInquirySecondExcelFormVO> listTemp = (List)RowSetUtil.rowSetToVOs(dbRs, SearchInvoiceInquirySecondExcelFormVO.class);

						if(rsList == null){
							rsList = listTemp;
						}else{
							rsList.addAll(listTemp);
						}
						
					}			
					
				}
			}

			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return rsList;
	}
	
	public DBRowSet searchInvoiceInquiryIdaList(EsdTrs0030Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		SearchInvoiceInquiryVO siiVo = event.getSearchInvoiceInquiryVO();
		
		try {
			String no_cd = siiVo.getNoCd();
			
			if (!no_cd.equals("") && !no_cd.equals("null") && no_cd != null) {
				ArrayList<String> noCdArr = new ArrayList<String>();
				StringTokenizer st  = null;
				int j = 0;
				noCdArr.clear();
				st = new StringTokenizer(no_cd, ",");
				while(st.hasMoreTokens()) {
					String tmpStr = "";
					tmpStr = st.nextToken();
					tmpStr = tmpStr.replaceAll("\\'", "\\'\\'");
					noCdArr.add(j++, tmpStr);
				}
				param.put("noCdArr", noCdArr);
			}
			
			String inv_cre_ofc = siiVo.getInvCreOfc();
			if (!inv_cre_ofc.equals("") && !inv_cre_ofc.equals("null") && inv_cre_ofc != null) {
				ArrayList<String> ofcCdArr = new ArrayList<String>();
				StringTokenizer str  = null;
				int j = 0;
				ofcCdArr.clear();
				str = new StringTokenizer(inv_cre_ofc, ",");
				while( str.hasMoreTokens() ) {
					String tmpStr = "";
					tmpStr = str.nextToken();
					tmpStr = tmpStr.replaceAll("\\'", "\\'\\'");
					ofcCdArr.add(j++, tmpStr);
					
				}
				param.put("ofcCdArr", ofcCdArr);
			}
			
			param.put("no_tp", JSPUtil.getNull(siiVo.getNoTp()));
			param.put("fmdate", JSPUtil.getNull(siiVo.getFmdate()));
			param.put("date_cd", JSPUtil.getNull(siiVo.getDateCd()));
			param.put("fmdate", JSPUtil.getNull(siiVo.getFmdate()));
			param.put("todate", JSPUtil.getNull(siiVo.getTodate()));
			param.put("FORM_USR_OFC_CD", JSPUtil.getNull(siiVo.getFormUsrOfcCd()));
			param.put("status_cd", JSPUtil.getNull(siiVo.getStatusCd()));
			param.put("recieved_cd", JSPUtil.getNull(siiVo.getRecievedCd()));
			param.put("hold_cd", JSPUtil.getNull(siiVo.getHoldCd()));
			param.put("combo_svc_provider", JSPUtil.getNull(siiVo.getComboSvcProvider()));
			param.put("sp_tp", JSPUtil.getNull(siiVo.getSpTp()));
			param.put("ivc_upd_usr_id", JSPUtil.getNull(siiVo.getIvcUpdUsrId()));
			param.put("amount_verify_cd", JSPUtil.getNull(siiVo.getAmountVerifyCd()));
			
			dRs = new SQLExecuter("DEFAULT").executeQuery(new InvoiceInquiryCorrectionDBDAOSearchInvoiceInquiryIdaListRSQL(), param,param);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}
	
}