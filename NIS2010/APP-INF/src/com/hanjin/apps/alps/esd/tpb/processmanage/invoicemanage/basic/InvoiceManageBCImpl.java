/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceManageBCImpl.java
*@FileTitle : InvoiceManage
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.10
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.07.17 최 선
* 1.0 Creation
* 2011.01.10 손은주 [CHM-201108205-01]	[TPB] 소스 품질 검토 결과 적용 (R4J 룰 추가)
* 2015.08.25 김현화 [CHM-201537567]logistics revenue 관련 로직 변경 - 화면에서 입력된 Cost Office가 inv_if_ofc_cd가 되도록 함.
* 2016.05.19 김현화 [CHM-201641620]인도 Tax 추가 요청-KKC
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esd.tpb.common.combo.vo.TpbComboVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.event.EsdTpb0110Event;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.event.EsdTpb0111Event;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.event.EsdTpb0112Event;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration.InvoiceManageDBDAO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.integration.InvoiceManageEAIDAO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.GetIndiaTaxInfoVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.InvoiceCreationVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.InvoiceDetailListForRevisionVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchErpInterfaceCheckDataVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchIndiaTaxInfoVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceDefaultDataVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceSettingVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceStatusVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchOtsGrpInfoVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchOutstandingDetailListForInvoiceCreationVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchTPBHandlingVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SearchThirdPartyInfoVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SendInvoiceEdiItemVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.SendInvoiceEdiVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.TPBEdiSndLogDtlVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.TPBRDFaxMailEAIVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.TpbInvIfDtlVO;
import com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo.TpbInvIfSmryVO;
import com.hanjin.apps.alps.esd.tpb.tpbcommon.tpbutil.basic.TPBUtil;
import com.hanjin.apps.alps.esd.tpb.tpbcommon.tpbutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esd.tpb.tpbcommon.tpbutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-InvoiceManagee Business Logic Basic Command implementation<br>
 * - ALPS-InvoiceManage에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Sun, CHOI
 * @see ESD_TPB_0105EventResponse,InvoiceManageBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */ 
public class InvoiceManageBCImpl extends BasicCommandSupport implements InvoiceManageBC {

	// Database Access Object
	private transient InvoiceManageDBDAO dbDao = null;

	/**
	 * InvoiceManageBCImpl 객체 생성<br>
	 * InvoiceManageDBDAO를 생성한다.<br>
	 */
	public InvoiceManageBCImpl() {
		dbDao = new InvoiceManageDBDAO();
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchTPBHandlingVO searchTPBHandlingVO
	 * @return List<SearchTPBHandlingVO>
	 * @exception EventException
	 */
	public List<SearchTPBHandlingVO> searchTPBHandling(SearchTPBHandlingVO searchTPBHandlingVO) throws EventException {
		try {
			return dbDao.searchTPBHandling(searchTPBHandlingVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchInvoiceSettingVO searchInvoiceSettingVO
	 * @return List<SearchInvoiceSettingVO>
	 * @exception EventException
	 */
	public List<SearchInvoiceSettingVO> searchInvoiceSheetSet(SearchInvoiceSettingVO searchInvoiceSettingVO) throws EventException {
		try { 
			return dbDao.searchInvoiceSheetSet(searchInvoiceSettingVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * ESD_TPB_0110 조회 이벤트 처리<br>
	 *  SearchInvoiceCreation 화면 대한 조회 이벤트 처리<br>
	 *
	 * @param EsdTpb0110Event event
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchInvoiceCreation(EsdTpb0110Event event, GeneralEventResponse eventResponse) throws EventException {
		try {
			SignOnUserAccount sa = event.getSignOnUserAccount();
			
			// ETC-DATA(HTML)
			InvoiceCreationVO vo1 = event.getInvoiceCreationVO();
			
			// 유저 사무소를 입력한다.
			vo1.setUserOfcCd(sa.getOfc_cd());
			vo1.setSSheetSetCount("0");
			//------------------------------------------------------------------
			//invoice sheet set을 먼저 구한다.
			//------------------------------------------------------------------
 			
 			SearchInvoiceSettingVO vo1_1 =  event.getSearchInvoiceSettingVO();

 			vo1_1.setSInvIssOfcCd(sa.getOfc_cd());
 			
 			List<SearchInvoiceSettingVO> rsVO1_1=dbDao.searchInvoiceSheetSet(vo1_1);
 			
			if(rsVO1_1.size()>0){
//				log.debug("rsVO1_1.size()===>"+rsVO1_1.size());
				vo1.setBilToLocDivCd(rsVO1_1.get(0).getBilToLocDivCd());
				vo1.setVatXchRt(rsVO1_1.get(0).getVatXchRt());
				vo1.setSSheetSetCount("1");
			}
			
			String s_dao_n3pty_no = vo1.getSDaoN3ptyNo();
			if(s_dao_n3pty_no != null && !s_dao_n3pty_no.equals("")){			
				s_dao_n3pty_no = JSPUtil.getTypeString(s_dao_n3pty_no);
				vo1.setSDaoN3ptyNo(s_dao_n3pty_no);
			}
//			log.debug("s_dao_n3pty_no========>"+s_dao_n3pty_no);
//			log.debug("vo1.getSHVndrCustDivCd()========>"+vo1.getSHVndrCustDivCd());

			List<SearchThirdPartyInfoVO> rsVO1 = dbDao.searchThirdPartyInfo(vo1);
			
//			log.debug("rsVO1.size()===>"+rsVO1.size());

			// rsVO1를 ETC-DATA로 setting
			if (rsVO1.size() > 0) {
				eventResponse.setETCData("s_curr_cd",rsVO1.get(0).getCurrCd());
				eventResponse.setETCData("s_prcs_cnt",rsVO1.get(0).getPrcsCnt());
				eventResponse.setETCData("s_addr",rsVO1.get(0).getEngAddr());
				eventResponse.setETCData("s_fax_no",rsVO1.get(0).getFaxNo());
				eventResponse.setETCData("s_vndr_cnt_cd",rsVO1.get(0).getVndrCntCd());
				eventResponse.setETCData("s_vndr_seq",rsVO1.get(0).getVndrSeq());
				eventResponse.setETCData("s_cust_cnt_cd",rsVO1.get(0).getCustCntCd());
				eventResponse.setETCData("s_cust_seq",rsVO1.get(0).getCustSeq());
				eventResponse.setETCData("s_trd_party_code_detail",rsVO1.get(0).getTrdPartyCode());
				eventResponse.setETCData("s_phn_no",rsVO1.get(0).getPhnNo());
				eventResponse.setETCData("s_vndr_cust_addr",rsVO1.get(0).getVndrCustAddr());
				/* 2009-04-27 O Wan-Ki 1.1 N200904160080, Invoice Creation 주소변경 및 주소선택 기능추가. */
				eventResponse.setETCData("s_vndr_cust_addr2",rsVO1.get(0).getVndrCustAddr2());
				eventResponse.setETCData("s_cty_nm",rsVO1.get(0).getCtyNm());
				eventResponse.setETCData("s_zip_cd",rsVO1.get(0).getZipCd());
				eventResponse.setETCData("s_vndr_cust_nm",rsVO1.get(0).getVndrCustNm());
				eventResponse.setETCData("s_rhq_cd",rsVO1.get(0).getRhqCd());
				eventResponse.setETCData("s_sheet_set_count",rsVO1.get(0).getSheetSetCount());
				eventResponse.setETCData("s_bil_loc",rsVO1.get(0).getBilToLocDivCd());
//				log.debug("rsVO1.get(0).getBilToLocDivCd()==============>"+rsVO1.get(0).getBilToLocDivCd());
				eventResponse.setETCData("s_vndr_cust_eml",rsVO1.get(0).getVndrCustEml());
				eventResponse.setETCData("s_vat_xch_rt",rsVO1.get(0).getVatXchRt());
				eventResponse.setETCData("s_rgst_no",rsVO1.get(0).getRgstNo());
				eventResponse.setETCData("s_ste_cd",rsVO1.get(0).getSteCd());
				
				eventResponse.setETCData("ida_tax_seq",rsVO1.get(0).getIdaTaxSeq());
//				eventResponse.setETCData("ida_ste_cd",rsVO1.get(0).getIdaSteCd());
				eventResponse.setETCData("ida_ste_nm",rsVO1.get(0).getIdaSteNm());
				eventResponse.setETCData("ida_cgst_rto",rsVO1.get(0).getIdaCgstRto());
				eventResponse.setETCData("ida_sgst_rto",rsVO1.get(0).getIdaSgstRto());
				eventResponse.setETCData("ida_igst_rto",rsVO1.get(0).getIdaIgstRto());
				eventResponse.setETCData("ida_ugst_rto",rsVO1.get(0).getIdaUgstRto());
				eventResponse.setETCData("ida_tot_gst_rto",rsVO1.get(0).getIdaTotGstRto());
				eventResponse.setETCData("ida_gst_rgst_no_flg",rsVO1.get(0).getIdaGstRgstNoFlg());
				eventResponse.setETCData("ida_spcl_ecn_zn_ut_flg",rsVO1.get(0).getIdaSpclEcnZnUtFlg());
				eventResponse.setETCData("ida_gst_rgst_no",rsVO1.get(0).getIdaGstRgstNo());
				eventResponse.setETCData("ida_ofc_gst_rgst_no",rsVO1.get(0).getIdaOfcGstRgstNo());
				eventResponse.setETCData("ida_pan_no",rsVO1.get(0).getIdaPanNo());
				eventResponse.setETCData("ida_bank_acct_no",rsVO1.get(0).getIdaBankAcctNo());
				eventResponse.setETCData("ida_ifsc_cd",rsVO1.get(0).getIdaIfscCd());
			}
			
			// 그리드 데이타
			InvoiceCreationVO vo2 = event.getInvoiceCreationVO();
			
			// 유저 사무소를 입력한다.
			vo2.setUserOfcCd(sa.getOfc_cd());
			vo2.setSDaoN3ptyNo(s_dao_n3pty_no);
			
			List<SearchOutstandingDetailListForInvoiceCreationVO> rsVO2 = dbDao.searchOutstandingDetailListForInvoiceCreation(vo2);

			eventResponse.setRsVoList(rsVO2);
			
			InvoiceCreationVO vo3 = event.getInvoiceCreationVO();
			
			// 유저 사무소를 입력한다.
			vo3.setUserOfcCd(sa.getOfc_cd());

			if(vo3.getSDetailN3ptyNo().length()<14){
				vo3.setSDetailN3ptyNo(JSPUtil.removeCharacter(vo3.getSDaoN3ptyNo(),"'"));
			}
			
			List<SearchOtsGrpInfoVO> rsVO3 = dbDao.searchOtsGrpInfo(vo3);
			
			// rsVO3를 ETC-DATA로 setting
			if (rsVO3.size() > 0) {
				eventResponse.setETCData("length_n3pty_bil_tp_cd",rsVO3.get(0).getLengthN3ptyBilTpCd());
			}else{
				eventResponse.setETCData("length_n3pty_bil_tp_cd","");
			}
			
			List<GetIndiaTaxInfoVO> rsVO4 = null;
			rsVO4 = dbDao.getIndiaTaxInfo(sa.getOfc_cd());
//			eventResponse.setETCData("ida_tax_seq",rsVO4.get(0).getIdaTaxSeq());
			eventResponse.setETCData("expn_tax",rsVO4.get(0).getExpnTax());
			eventResponse.setETCData("edu_tax",rsVO4.get(0).getEduTax());
			eventResponse.setETCData("high_edu_tax",rsVO4.get(0).getHighEduTax());
			eventResponse.setETCData("tax_rgst_no",rsVO4.get(0).getTaxRgstNo());
			eventResponse.setETCData("svc_cate_rmk",rsVO4.get(0).getSvcCateRmk());
			eventResponse.setETCData("pmnt_acct_no",rsVO4.get(0).getPmntAcctNo());
			eventResponse.setETCData("locl_tax_rt",rsVO4.get(0).getLoclTaxRt());
			eventResponse.setETCData("n2nd_locl_tax_rt",rsVO4.get(0).getN2ndLoclTaxRt());
			/*
			if( sa.getCnt_cd().equals("IN")){//2009-05-18 O Wan-Ki 1.2 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발] Invoice for India
				rsVO4 = dbDao.getIndiaTaxInfo(sa.getOfc_cd());
				// rsVO4를 ETC-DATA로 setting
				eventResponse.setETCData("ida_tax_seq",rsVO4.get(0).getIdaTaxSeq());
				eventResponse.setETCData("expn_tax",rsVO4.get(0).getExpnTax());
				eventResponse.setETCData("edu_tax",rsVO4.get(0).getEduTax());
				eventResponse.setETCData("high_edu_tax",rsVO4.get(0).getHighEduTax());
				eventResponse.setETCData("tax_rgst_no",rsVO4.get(0).getTaxRgstNo());
				eventResponse.setETCData("svc_cate_rmk",rsVO4.get(0).getSvcCateRmk());
				eventResponse.setETCData("pmnt_acct_no",rsVO4.get(0).getPmntAcctNo());
			}
			*/

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return eventResponse;
	}

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @return List<InvoiceCreationVO>
	 * @exception EventException
	 */
	public List<InvoiceCreationVO> searchInvoiceInfo(InvoiceCreationVO invoiceCreationVO) throws EventException {
		try {
			return dbDao.searchInvoiceInfo(invoiceCreationVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param EsdTpb0111Event event
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchInvoiceDetailListForRevision(EsdTpb0111Event event, GeneralEventResponse eventResponse) throws EventException {
		try {
			SignOnUserAccount account = event.getSignOnUserAccount();
			InvoiceDetailListForRevisionVO invoiceDetailListForRevisionVO = event.getInvoiceDetailListForRevisionVO();
			
			invoiceDetailListForRevisionVO.setUserOfcCd(account.getOfc_cd());

			SearchInvoiceSettingVO vo1 = event.getSearchInvoiceSettingVO();
			
			vo1.setSInvIssOfcCd(account.getOfc_cd());
			
			List<SearchInvoiceSettingVO> rsVO1=this.searchInvoiceSheetSet(vo1);
			if(rsVO1.size()>0){
				invoiceDetailListForRevisionVO.setVatXchRtOriginal(rsVO1.get(0).getVatXchRt());
			}

			//n3pty_inv_no 에 해당하는 n3pty_no를 먼저 구한다.
			List<InvoiceDetailListForRevisionVO> rsVO2 = dbDao.searchTrdPartyDataForCorrectionInvOts(invoiceDetailListForRevisionVO);
			
//			String s_detail_n3pty_no = "";
//			String s_detail_ots_sts_cd = "";
			StringBuffer s_detail_n3pty_no = new StringBuffer();
			StringBuffer s_detail_ots_sts_cd = new StringBuffer();
			
			if(rsVO2.size()>0){
				for(int i=0 ; i< rsVO2.size() ; i++){
//					s_detail_n3pty_no = s_detail_n3pty_no + rsVO2.get(i).getN3ptyNo() ;//+ "|";
//					s_detail_ots_sts_cd = s_detail_ots_sts_cd + rsVO2.get(i).getOtsStsCd() ;//+ "|";
					s_detail_n3pty_no.append(rsVO2.get(i).getN3ptyNo());
					s_detail_ots_sts_cd.append(rsVO2.get(i).getOtsStsCd());
				}
			}
			invoiceDetailListForRevisionVO.setSDetailN3ptyNo(s_detail_n3pty_no.toString());
			invoiceDetailListForRevisionVO.setSDetailOtsStsCd(s_detail_ots_sts_cd.toString());
			//France 국가의 Office 여부 체크, Issue 못하도록 하기위함.
			String isFrance = "N";
			List<InvoiceDetailListForRevisionVO> rsVO3 = dbDao.searchTrdPartyDataForCorrectionInvOrg(invoiceDetailListForRevisionVO);
			if(rsVO3.size() > 0){
				if( Integer.parseInt(rsVO3.get(0).getCnt()) > 0){
					isFrance = "Y";
				}
			}
			invoiceDetailListForRevisionVO.setIsFrance(isFrance);
			// ETC-DATA(HTML)
//			List<InvoiceDetailListForRevisionVO> rsVO4 = null;
			List<InvoiceDetailListForRevisionVO> rsVO4 = new ArrayList<InvoiceDetailListForRevisionVO>();
			if (invoiceDetailListForRevisionVO.getSHVndrCustDivCd().equals("V") || invoiceDetailListForRevisionVO.getSHVndrCustDivCd().equals("C"))
			{
				rsVO4 = dbDao.searchInvoiceRevisionInfo(invoiceDetailListForRevisionVO);
			}
			
			if(rsVO4.size() > 0){
				//eventResponse.setETCData(rsVO4.get(0).getColumnValues());				
				eventResponse.setETCData("s_curr_cd",rsVO4.get(0).getCurrCd());
				eventResponse.setETCData("s_prcs_cnt",rsVO4.get(0).getPrcsCnt());
				eventResponse.setETCData("s_addr",rsVO4.get(0).getEngAddr());
				eventResponse.setETCData("s_vndr_cnt_cd",rsVO4.get(0).getVndrCntCd());
				eventResponse.setETCData("s_vndr_seq",rsVO4.get(0).getVndrSeq());
				eventResponse.setETCData("s_cust_cnt_cd",rsVO4.get(0).getCustCntCd());
				eventResponse.setETCData("s_cust_seq",rsVO4.get(0).getCustSeq());
				eventResponse.setETCData("s_trd_party_val",rsVO4.get(0).getTrdPartyCode());
				eventResponse.setETCData("s_fax_no",rsVO4.get(0).getFaxNo());
				eventResponse.setETCData("s_phn_no",rsVO4.get(0).getPhnNo());
				eventResponse.setETCData("s_vndr_cust_addr",rsVO4.get(0).getVndrCustAddr());
				eventResponse.setETCData("s_vndr_cust_nm",rsVO4.get(0).getVndrCustNm());
				eventResponse.setETCData("s_rgst_no",rsVO4.get(0).getRgstNo());
				eventResponse.setETCData("s_vndr_cust_ref_rmk",rsVO4.get(0).getVndrCustRefRmk());
				eventResponse.setETCData("s_bil_loc",rsVO4.get(0).getBilToLocDivCd());
				eventResponse.setETCData("s_clt_agn_rmk",rsVO4.get(0).getCltAgnRmk());
				eventResponse.setETCData("s_n3pty_inv_sts_cd",rsVO4.get(0).getSN3ptyInvStsCd());
				eventResponse.setETCData("s_clt_agn_flg",rsVO4.get(0).getCltAgnFlg());
				eventResponse.setETCData("s_n3pty_inv_rmd_nm",rsVO4.get(0).getN3ptyInvRmdNm());
				eventResponse.setETCData("s_n3pty_inv_rmd_yn",rsVO4.get(0).getN3ptyInvRmdYn());
				eventResponse.setETCData("s_rcv_due_dt",rsVO4.get(0).getRcvDueDt());
				eventResponse.setETCData("s_his_seq",""); //Inquiry detail에서는 사용하지만, Correction detail은 null로 처리함
				eventResponse.setETCData("s_inv_desc",rsVO4.get(0).getInvDesc());
				eventResponse.setETCData("s_final_flg",rsVO4.get(0).getFinalFlg());
				eventResponse.setETCData("s_detail_n3pty_no",rsVO4.get(0).getDetailN3ptyNo());
				eventResponse.setETCData("s_detail_ots_sts_cd",rsVO4.get(0).getDetailOtsStsCd());
				eventResponse.setETCData("s_vndr_cust_eml",rsVO4.get(0).getVndrCustEml());
				eventResponse.setETCData("s_vat_xch_rt_original",rsVO4.get(0).getVatXchRtOriginal());
				eventResponse.setETCData("s_net_amt",rsVO4.get(0).getNetAmt());
				//2009-06-29 O Wan-Ki 1.3 S1V-09P-001, tax 전송부분 보완
				String cnt_cd = account.getCnt_cd();
				if (cnt_cd != null && cnt_cd.equals("IN")){
					eventResponse.setETCData("s_total_amt",rsVO4.get(0).getExpnTotalAmt());
				}else{
					eventResponse.setETCData("s_vat_amt",rsVO4.get(0).getVatAmt());
					eventResponse.setETCData("s_total_amt",rsVO4.get(0).getTotalAmt());
				}

				eventResponse.setETCData("s_france",rsVO4.get(0).getFrance());
				eventResponse.setETCData("s_lnk_n3pty_inv_no",rsVO4.get(0).getLnkN3ptyInvNo());
				eventResponse.setETCData("s_cty_nm",rsVO4.get(0).getCtyNm());
				eventResponse.setETCData("s_ste_cd",rsVO4.get(0).getSteCd());
				eventResponse.setETCData("s_zip_cd",rsVO4.get(0).getZipCd());
				eventResponse.setETCData("s_usr_inp_ctnt1",rsVO4.get(0).getUsrInpCtnt1());
				eventResponse.setETCData("s_usr_inp_ctnt2",rsVO4.get(0).getUsrInpCtnt2());
				eventResponse.setETCData("s_rgst_no",rsVO4.get(0).getRgstNo());
				eventResponse.setETCData("s_same_version_yn",rsVO4.get(0).getSameVersionYn());
				eventResponse.setETCData("s_inv_iss_rhq_cd",rsVO4.get(0).getInvIssRhqCd());
				eventResponse.setETCData("erpif_yn",rsVO4.get(0).getErpifYn());
				
				// * 2009-03-13 O Wan-Ki 1.1 N200903090210, Invoice Revision 가능여부 판단기능 구현.
				eventResponse.setETCData("org_due_date",rsVO4.get(0).getRcvDueDt());
				eventResponse.setETCData("org_adm_chrg",rsVO4.get(0).getAddAmt());
				eventResponse.setETCData("org_ddct_amt",rsVO4.get(0).getDdctAmt());
				eventResponse.setETCData("org_tot_amt",rsVO4.get(0).getTotalAmt());
				eventResponse.setETCData("org_inv_desc",rsVO4.get(0).getInvDesc());

				//* 2009-04-27 O Wan-Ki 1.2 N200904160080, 주소영역 save 가능여부 판단기능 추가.
				eventResponse.setETCData("org_usr_inp_ctnt1",rsVO4.get(0).getUsrInpCtnt1());
				eventResponse.setETCData("org_vndr_cust_addr",rsVO4.get(0).getVndrCustAddr());
				eventResponse.setETCData("org_cty_nm",rsVO4.get(0).getCtyNm());
				eventResponse.setETCData("org_ste_cd",rsVO4.get(0).getSteCd());
				eventResponse.setETCData("org_zip_cd",rsVO4.get(0).getZipCd());
				eventResponse.setETCData("org_usr_inp_ctnt2",rsVO4.get(0).getUsrInpCtnt2());
				eventResponse.setETCData("org_vndr_cust_ref_rmk",rsVO4.get(0).getVndrCustRefRmk());

				//* 2009-05-27 O Wan-Ki 1.3 TPB Restructuring 2단계 (Invoice 부분) 보완/개발
				eventResponse.setETCData("s_ida_tax_seq",rsVO4.get(0).getIdaTaxSeq());
				eventResponse.setETCData("expn_tax",rsVO4.get(0).getExpnTax());
				eventResponse.setETCData("edu_tax",rsVO4.get(0).getEduTax());
				eventResponse.setETCData("high_edu_tax",rsVO4.get(0).getHighEduTax());
				eventResponse.setETCData("tax_rgst_no",rsVO4.get(0).getTaxRgstNo());
				eventResponse.setETCData("svc_cate_rmk",rsVO4.get(0).getSvcCateRmk());
				eventResponse.setETCData("pmnt_acct_no",rsVO4.get(0).getPmntAcctNo());
				eventResponse.setETCData("tot_expn_tax",rsVO4.get(0).getTotExpnTax());
				eventResponse.setETCData("tot_edu_tax",rsVO4.get(0).getTotEduTax());
				eventResponse.setETCData("tot_high_edu_tax",rsVO4.get(0).getTotHighEduTax());
				eventResponse.setETCData("tot_svc_tax",rsVO4.get(0).getTotSvcTax());
				eventResponse.setETCData("lst_expense",rsVO4.get(0).getExpnTotalAmt());
				eventResponse.setETCData("lst_tax",rsVO4.get(0).getTotSvcTax());
				eventResponse.setETCData("lst_invoice_total",rsVO4.get(0).getTotalAmt());
				eventResponse.setETCData("locl_tax_rt",rsVO4.get(0).getLoclTaxRt());
				eventResponse.setETCData("tot_locl_tax",rsVO4.get(0).getLoclTaxAmt());
				eventResponse.setETCData("n2nd_locl_tax_rt",rsVO4.get(0).getN2ndLoclTaxRt());
				eventResponse.setETCData("n2nd_locl_tax",rsVO4.get(0).getN2ndLoclTaxAmt());
				
				eventResponse.setETCData("ste_nm",rsVO4.get(0).getSteNm());
				eventResponse.setETCData("loc_cd",rsVO4.get(0).getLocCd());
				eventResponse.setETCData("loc_nm",rsVO4.get(0).getLocNm());
				eventResponse.setETCData("ida_gst_rgst_no",rsVO4.get(0).getIdaGstRgstNo());
				eventResponse.setETCData("ida_gst_rgst_no_flg",rsVO4.get(0).getIdaGstRgstNoFlg());
				eventResponse.setETCData("ida_spcl_ecn_zn_ut_flg",rsVO4.get(0).getIdaSpclEcnZnUtFlg());
				eventResponse.setETCData("ida_tax_flg",rsVO4.get(0).getIdaTaxFlg());
				eventResponse.setETCData("ida_cgst_rto",rsVO4.get(0).getIdaCgstRto());
				eventResponse.setETCData("ida_sgst_rto",rsVO4.get(0).getIdaSgstRto());
				eventResponse.setETCData("ida_igst_rto",rsVO4.get(0).getIdaIgstRto());
				eventResponse.setETCData("ida_ugst_rto",rsVO4.get(0).getIdaUgstRto());
				eventResponse.setETCData("ida_tot_gst_rto",rsVO4.get(0).getIdaTotGstRto());
				eventResponse.setETCData("ida_cgst_amt",rsVO4.get(0).getIdaCgstAmt());
				eventResponse.setETCData("ida_sgst_amt",rsVO4.get(0).getIdaSgstAmt());
				eventResponse.setETCData("ida_igst_amt",rsVO4.get(0).getIdaIgstAmt());
				eventResponse.setETCData("ida_ugst_amt",rsVO4.get(0).getIdaUgstAmt());
				eventResponse.setETCData("ida_tot_gst_amt",rsVO4.get(0).getIdaTotGstAmt());
				eventResponse.setETCData("ida_ofc_gst_rgst_no",rsVO4.get(0).getIdaOfcGstRgstNo());
				eventResponse.setETCData("ida_pan_no",rsVO4.get(0).getIdaPanNo());
				eventResponse.setETCData("ida_bank_acct_no",rsVO4.get(0).getIdaBankAcctNo());
				eventResponse.setETCData("ida_ifsc_cd",rsVO4.get(0).getIdaIfscCd());
			}
			
			List<InvoiceDetailListForRevisionVO> rsVO5 = dbDao.searchInvoiceRevisionDetailList(invoiceDetailListForRevisionVO);
			eventResponse.setETCData("s_add_amt",rsVO5.get(0).getAddAmt());
			eventResponse.setETCData("s_ddct_amt",rsVO5.get(0).getDdctAmt());

			eventResponse.setRsVoList(rsVO5);
			
			InvoiceCreationVO inVo = event.getInvoiceCreationVO();
			inVo.setSDetailN3ptyNo(invoiceDetailListForRevisionVO.getSDetailN3ptyNo());
			// ETC-DATA(HTML)
			List<SearchOtsGrpInfoVO> rsVO6 = dbDao.searchOtsGrpInfo(inVo);
			if(rsVO6.size()>0){
				eventResponse.setETCData("length_n3pty_bil_tp_cd",rsVO6.get(0).getLengthN3ptyBilTpCd());
			}else{
				eventResponse.setETCData("length_n3pty_bil_tp_cd","1");
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return eventResponse;
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchInvoiceDefaultDataVO searchInvoiceDefaultDataVO
	 * @param GeneralEventResponse eventResponse
	 * @param account SignOnUserAccount
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchInvoiceDefaultData(SearchInvoiceDefaultDataVO searchInvoiceDefaultDataVO, GeneralEventResponse eventResponse, SignOnUserAccount account) throws EventException {
		try {
			searchInvoiceDefaultDataVO.setUserOfcCd(account.getOfc_cd());
			List<SearchInvoiceDefaultDataVO> list= dbDao.searchInvoiceDefaultData(searchInvoiceDefaultDataVO);
			
			if(list.size()>0){
				
				SearchInvoiceDefaultDataVO reValue = list.get(0);
				
				eventResponse.setRsVoList(list);
				
				eventResponse.setETCData("s_detail_n3pty_no",reValue.getN3ptyNo());
				eventResponse.setETCData("s_n3pty_no",reValue.getN3ptyNo());
				eventResponse.setETCData("s_n3pty_inv_no",reValue.getN3ptyInvNo());
				eventResponse.setETCData("s_n3pty_inv_rmd_cd",reValue.getN3ptyInvRvisCd());
				eventResponse.setETCData("s_n3pty_inv_his_seq",reValue.getN3ptyInvRvisSeq());
				eventResponse.setETCData("s_h_vndr_cust_div_cd",reValue.getVndrCustDivCd());
				eventResponse.setETCData("s_trd_party_code",reValue.getN3ptyCd());
				eventResponse.setETCData("s_revise_able",reValue.getReviseAble());
				eventResponse.setETCData("s_length_n3pty_bil_tp_cd",reValue.getLengthN3ptyBilTpCd());
				eventResponse.setETCData("s_ida_tax_seq",reValue.getIdaTaxSeq());
				
				return eventResponse;
			}
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return null;
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param EsdTpb0112Event event
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchInvoiceStatus(EsdTpb0112Event event, GeneralEventResponse eventResponse) throws EventException {
		try {
			// list0에 사용 될 VO를 가져옴
			SearchInvoiceStatusVO vo1 = event.getSearchInvoiceStatusVO();
			
			SignOnUserAccount sa = event.getSignOnUserAccount();
			vo1.setUserOfcCd(sa.getOfc_cd());
			vo1.setSN3ptyInvRvisSeq(vo1.getSN3ptyInvHisSeq());
			vo1.setSN3ptyInvRvisCd(vo1.getSN3ptyInvRmdCd());
			
			// vo1을 이용하여 list1 조회(HTML INPUT용 데이터 )
			List<SearchInvoiceStatusVO> list1 = dbDao.searchIssueInfo(vo1);
			// list1을 ETC-DATA로 setting
			//eventResponse.setETCData(list1.get(0).getColumnValues());
			for (int i=0 ; i<list1.size(); i++) {
				//eventResponse.setETCData(list1.get(i).getColumnValues());
				eventResponse.setETCData("s_clt_agn_flg",list1.get(i).getCltAgnFlg());
				eventResponse.setETCData("s_n3pty_inv_sts_cd",list1.get(i).getN3ptyInvStsCd());
				eventResponse.setETCData("s_issue_yn",list1.get(i).getIssueYn());
				eventResponse.setETCData("s_erpif_yn",list1.get(i).getErpifYn());
				eventResponse.setETCData("s_bil_loc",list1.get(i).getBilToLocDivCd());
//				log.debug("list1.get(i).getBilToLocDivCd()============>"+list1.get(i).getBilToLocDivCd());
//				log.debug("list1.get(i).getSBilLoc()============>"+list1.get(i).getSBilLoc());
			}
			//<ETC KEY="s_result"><%=successFlag%></ETC>

			
			//eventResponse.setETCData("postVvd_comboCode", postPolCd);
			
			// list0에 사용 될 VO를 가져옴
			SearchInvoiceStatusVO vo2 = event.getSearchInvoiceStatusVO();
			vo2.setUserOfcCd(sa.getOfc_cd());
			//vo2.setSN3ptyInvRvisSeq(vo2.getSN3ptyInvHisSeq());
			//vo2.setSN3ptyInvRvisCd(vo2.getSN3ptyInvRmdCd());
			
			vo2.setSInfo("E");
			List<SearchInvoiceStatusVO> list2 = dbDao.searchContactInfo(vo2);
			
			vo2.setSInfo("F");
			List<SearchInvoiceStatusVO> list3 = dbDao.searchContactInfo(vo2);
			
			list2.addAll(list3);
			eventResponse.setRsVoList(list2);

			//eventResponse.setRsVoList(list3);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchInvoiceStatusVO searchInvoiceStatusVO
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String updateInvoiceIssue(SearchInvoiceStatusVO searchInvoiceStatusVO, SignOnUserAccount account) throws EventException{
//		log.debug("updateInvoiceIssueBCImpl Start");
		// Fax, E-Mail Key Value 
		String s_n3pty_inv_if_tp_cd = searchInvoiceStatusVO.getSN3ptyInvIfTpCd();
//		log.debug("s_n3pty_inv_if_tp_cd ===>"+searchInvoiceStatusVO.getSN3ptyInvIfTpCd());
//		log.debug("s_n3pty_inv_if_tp_cd ===>"+s_n3pty_inv_if_tp_cd);
		String fax_eml_snd_no = null;

		try { 
			searchInvoiceStatusVO.setUserId(account.getUsr_id());
			searchInvoiceStatusVO.setUserOfcCd(account.getOfc_cd());
			searchInvoiceStatusVO.setUserName(account.getUsr_nm());
			searchInvoiceStatusVO.setUserEmail(account.getUsr_eml());
			searchInvoiceStatusVO.setSN3ptyInvHisSeq(searchInvoiceStatusVO.getSHisSeq());
			searchInvoiceStatusVO.setSN3ptyInvRvisCd(searchInvoiceStatusVO.getSN3ptyInvRmdCd());
			
			//---------------------------------------------------------------------------
			// tpb_inv_hdr 테이블에 update 직전 Email & Fax 처리
			//---------------------------------------------------------------------------
			
			if(s_n3pty_inv_if_tp_cd.equals("E")){  //Email
//				log.debug("----- Email -----");
				fax_eml_snd_no = this.rdMailSend(searchInvoiceStatusVO);
//				log.debug("Email Send_Cd : " + fax_eml_snd_no); /// tpb_inv_hdr에 update예정 
				searchInvoiceStatusVO.setVndrCustEml(searchInvoiceStatusVO.getSContactInfo());

			}else if(s_n3pty_inv_if_tp_cd.equals("F")){ //Fax
//				log.debug("----- Fax -----");
				fax_eml_snd_no = this.rdFaxSend(searchInvoiceStatusVO);
//				log.debug("Fax Send_Cd : " + fax_eml_snd_no); /// tpb_inv_hdr에 update예정 
				searchInvoiceStatusVO.setFaxNo(searchInvoiceStatusVO.getSContactInfo());
			}
			searchInvoiceStatusVO.setFaxEmlSndNo(fax_eml_snd_no);
			dbDao.updateInvoiceIssue(searchInvoiceStatusVO);
			// 전송 History 2015.04.23 추가
			dbDao.addInvoiceSendHistory(searchInvoiceStatusVO);
				
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		return fax_eml_snd_no;
	}

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param String s_n3pty_inv_no
	 * @return SearchInvoiceStatusVO
	 * @exception EventException
	 */
	public SearchInvoiceStatusVO getSendTargetInfo(SearchInvoiceStatusVO searchInvoiceStatusVO) throws EventException {
		try {
			return dbDao.getSendTargetInfo(searchInvoiceStatusVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchIndiaTaxInfoVO searchIndiaTaxInfoVO
	 * @param account SignOnUserAccount
	 * @return List<SearchIndiaTaxInfoVO>
	 * @exception EventException
	 */
	public List<SearchIndiaTaxInfoVO> searchIndiaTaxInfo(SearchIndiaTaxInfoVO searchIndiaTaxInfoVO, SignOnUserAccount account) throws EventException {
		try {
			searchIndiaTaxInfoVO.setSOfcCd("");
			searchIndiaTaxInfoVO.setUserOfcCd(account.getOfc_cd());
			return dbDao.searchIndiaTaxInfo(searchIndiaTaxInfoVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchIndiaTaxInfoVO searchIndiaTaxInfoVO
	 * @param account SignOnUserAccount
	 * @return List<SearchIndiaTaxInfoVO>
	 * @exception EventException
	 */
	public List<SearchIndiaTaxInfoVO> searchIndiaTaxInfoByEffDate(SearchIndiaTaxInfoVO searchIndiaTaxInfoVO, SignOnUserAccount account) throws EventException {
		try {
			searchIndiaTaxInfoVO.setUserOfcCd(account.getOfc_cd());
			searchIndiaTaxInfoVO.setSOfcCd("");
			searchIndiaTaxInfoVO.setSEffDt(searchIndiaTaxInfoVO.getSCalendarDate1());
			return dbDao.searchIndiaTaxInfoByEffDate(searchIndiaTaxInfoVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param invoiceVo
	 * @param account
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse createERPInterface(InvoiceCreationVO invoiceVo, SignOnUserAccount account) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			/// Invoice 유효성 체크 
			String validYnInvoiceSeq = dbDao.searchInvoiceRvisSeq(invoiceVo);
			if ( !"Y".equals(validYnInvoiceSeq) ) {
				log.info(" Object Invoice Seq Check / validYn : " + validYnInvoiceSeq );
				throw new EventException(new ErrorHandler("TPB00075").getMessage());
			}

			invoiceVo.setUserId(account.getUsr_id());
			invoiceVo.setUserOfcCd(account.getOfc_cd());
			invoiceVo.setOfcCd(account.getOfc_cd());
			invoiceVo.setUserName(account.getUsr_nm());
			invoiceVo.setUserEmail(account.getUsr_eml());
			
			///===== check status ===== 
			this.checkInvoiceStatus(invoiceVo);
			
			///===== update invoice status ===== 
			String[] erpifKeyArr = null;
			
			erpifKeyArr = dbDao.updateInvoiceRevisionErpInterface(invoiceVo);
//			log.debug("erpifKeyArr[0]==========>"+erpifKeyArr[0]);
//			log.debug("erpifKeyArr[1]==========>"+erpifKeyArr[1]);
//			log.debug("erpifKeyArr[2]==========>"+erpifKeyArr[2]);
//			log.debug("erpifKeyArr[3]==========>"+erpifKeyArr[3]);
			
			invoiceVo.setOutErpifRvisSeq(erpifKeyArr[0]);
			invoiceVo.setOutErpifRvisCd(erpifKeyArr[1]);
			invoiceVo.setOutErpifCreditnoteSeq(erpifKeyArr[2]);
			invoiceVo.setOutErpifCreditnoteCd(erpifKeyArr[3]);

			
			///===== Retrieve Get Channel(n3pty_expn_tp_cd) =====
			String n3pty_expn_tp_cd = null; /// Channel Indicator 
			n3pty_expn_tp_cd = this.getN3ptyExpnTpCd(invoiceVo);
			invoiceVo.setN3ptyExpnTpCd(n3pty_expn_tp_cd);
			
			///===== Customer Information Check For AR ===== 
			
			if( dbDao.checkCustomerInfo(invoiceVo) == false ){
				log.error("err - Invalid Customer Information For AR!!!");
				throw new EventException(new ErrorHandler("TPB00026").getMessage());
			}
			//===== A/R Office, Period Check =====
			String[] checkArOfcApPeriodResult = dbDao.checkArOfficeCode(invoiceVo);
			if ( checkArOfcApPeriodResult==null || checkArOfcApPeriodResult[0].equals("Y") == false ){
				log.error("err - Invalid AR Office Code For AR!!!");
				throw new EventException(new ErrorHandler("TPB00061").getMessage());
			}
			if ( checkArOfcApPeriodResult==null || checkArOfcApPeriodResult[1].equals("Y") == false ){
				log.error("err - Invalid AP Period For AR!!!");
				throw new EventException(new ErrorHandler("TPB00076").getMessage());
			}

			///===== AP/AR Process By Each Case =====
			List<ARInterfaceCreationVO> genIfVOs = this.createErpData(invoiceVo);
			eventResponse.setRsVoList(genIfVOs);
			eventResponse.setETCData("SucessYN","Y");

			} catch (DAOException ex) {
				throw new EventException(ex.getMessage(),ex);
			} catch (Exception ex) {
				throw new EventException(ex.getMessage(),ex);
			}
		
		return eventResponse;
	}
	
	/**
	 * 해당 TPB Invoice No.의 n3pty_inv_sts_cd를 체크한다. (2007-11-19) <br>
	 * 'N'일 경우는 정상적이나 'A'일 경우는 이미 ERP I/F처리된 건이므로 상태체크로 중단되어야 한다. 
	 * @param InvoiceCreationVO invoiceCreationVO
	 * @throws EventException 
	 */
	public void checkInvoiceStatus(InvoiceCreationVO invoiceCreationVO) throws EventException {
		String n3pty_inv_sts_cd = null;
		try {
			
			n3pty_inv_sts_cd = dbDao.searchInvoiceStatus(invoiceCreationVO);
	
//			log.debug(" n3pty_inv_sts_cd : " + n3pty_inv_sts_cd); 
			
			if ( n3pty_inv_sts_cd==null || n3pty_inv_sts_cd.equals("N")==false ){
				log.error("Error - Invoice Status is not effective ");
				throw new EventException(new ErrorHandler("TPB00074").getMessage());
			}

		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return;
	}
	/**
	 * 해당 TPB Invoice No.의 n3pty_expn_tp_cd을 구한다.<br>
	 * 추가적으로 데이터의 유효성을 체크한다. (2007-08-13) <br>
	 * - NON J/O  : Source, Billing Case, 3rd Party, Revenue VVD, Currency 다른 값이 있는지 체크
	 * - J/O Case - Source, Billing Case, 3rd Party, Revenue VVD, Actual VVD, Currency, Csr No., Month of GL Date 다른 값이 있는지 체크 
	 * @param params 
	 * @return n3pty_expn_tp_cd
	 * @throws EventException 
	 */
	private String getN3ptyExpnTpCd(InvoiceCreationVO invoiceCreationVO) throws EventException {

		String n3pty_expn_tp_cd = null;
		//DBRowSet dRs = null;
		try {
			
			SearchErpInterfaceCheckDataVO vo = dbDao.searchErpInterfaceCheckData(invoiceCreationVO);
			
			int channelCnt = 0;  // n3pty_expn_tp_cd_cnt
			n3pty_expn_tp_cd = null; // n3pty_expn_tp_cd_max

			String n3pty_bil_tp_cd_max = null;

			int trd_party_code_cnt = 0;
			String trd_party_code_max = null;
			int revenue_vvd_cnt = 0;

			int curr_cd_cnt = 0;
			String curr_cd_max = null;
			
			int vvd_cd_cnt = 0;
			String vvd_cd_max = null;
			int csr_no_cnt = 0;
			String csr_no_max = null;
			int gl_month_cnt = 0;
			String gl_month_max = null;
			
			
			if ( vo!=null){

				channelCnt = Integer.parseInt(vo.getN3ptyExpnTpCdCnt());
				n3pty_expn_tp_cd = vo.getN3ptyExpnTpCdMax(); /// Channel value

//				n3pty_bil_tp_cd_cnt = dRs.getInt(3);
				n3pty_bil_tp_cd_max = vo.getN3ptyBilTpCdMax();
				

				trd_party_code_cnt = Integer.parseInt(vo.getTrdPartyCodeCnt());
				trd_party_code_max = vo.getTrdPartyCodeMax();
				revenue_vvd_cnt = Integer.parseInt(vo.getRevenueVvdCnt());
//				revenue_vvd_max = dRs.getString(8);
				
				curr_cd_cnt = Integer.parseInt(vo.getCurrCdCnt());
				curr_cd_max = vo.getCurrCdMax();
				
				vvd_cd_cnt = Integer.parseInt(vo.getVvdCdCnt());
				vvd_cd_max = vo.getVvdCdMax();

				csr_no_cnt = Integer.parseInt(vo.getCsrNoCnt());
				csr_no_max = vo.getCsrNoMax();
				gl_month_cnt = Integer.parseInt(vo.getGlMonthCnt());
				gl_month_max = vo.getGlMonthMax();
			}

//			log.debug(" channelCnt : " + channelCnt); 
//			log.debug(" n3pty_expn_tp_cd : " + n3pty_expn_tp_cd); 
			
			if ( channelCnt != 1 || n3pty_expn_tp_cd == null ){
				log.error("Error - Expense Type is not effective ");
				throw new EventException(new ErrorHandler("TPB00028").getMessage());
			}
			
			if ( trd_party_code_cnt != 1 || trd_party_code_max == null ){
				log.error("Error - Third Party is not effective ");
				throw new EventException(new ErrorHandler("TPB00068").getMessage());
			}

			if ( revenue_vvd_cnt != 1 ){ // || revenue_vvd_max == null 
				log.error("Error - Revenue VVD is not effective ");
				throw new EventException(new ErrorHandler("TPB00069").getMessage());
			}

			if ( curr_cd_cnt != 1 || curr_cd_max == null ){
				log.error("Error - Currency is not effective ");
				throw new EventException(new ErrorHandler("TPB00070").getMessage());
			}

			if ( n3pty_bil_tp_cd_max.equals("JO") == true ) { // JO Case인 경우 
				if ( vvd_cd_cnt != 1 || vvd_cd_max == null ){
					log.error("Error - Actual VVD is not effective ");
					throw new EventException(new ErrorHandler("TPB00071").getMessage());
				}
				
				if ( csr_no_cnt != 1 || csr_no_max == null ){
					log.error("Error - CSR No. is not effective ");
					throw new EventException(new ErrorHandler("TPB00072").getMessage());
				}
				
				if ( gl_month_cnt != 1 || gl_month_max == null ){
					log.error("Error - the Month of GL Date is not effective ");
					throw new EventException(new ErrorHandler("TPB00073").getMessage());
				}
			} 

		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (EventException ee) {
			log.error("err "+ee.toString(),ee);
			throw new EventException(ee.getMessage());
		}
		
		//log.debug("n3pty_expn_tp_cd : " + n3pty_expn_tp_cd);
		
		return n3pty_expn_tp_cd;
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchInvoiceSettingVO searchInvoiceSettingVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createInvoiceSheetSet(SearchInvoiceSettingVO searchInvoiceSettingVO, SignOnUserAccount account) throws EventException{
		try {
			List<SearchInvoiceSettingVO> insertVoList = new ArrayList<SearchInvoiceSettingVO>();
			List<SearchInvoiceSettingVO> updateVoList = new ArrayList<SearchInvoiceSettingVO>();
			
			searchInvoiceSettingVO.setCreUsrId(account.getUsr_id());
			searchInvoiceSettingVO.setUpdUsrId(account.getUsr_id());
			if ( searchInvoiceSettingVO.getIbflag().equals("I")){
				insertVoList.add(searchInvoiceSettingVO);
			} else if ( searchInvoiceSettingVO.getIbflag().equals("U")){
				updateVoList.add(searchInvoiceSettingVO);
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addInvoiceSheetSet(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyInvoiceSheetSet(updateVoList);
			}
		
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param InvoiceCreationVO[] multiInvoiceManageListVO
	 * @param GeneralEventResponse eventResponse
	 * @param account SignOnUserAccount
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse createInvoice(InvoiceCreationVO[] multiInvoiceManageListVO, GeneralEventResponse eventResponse, SignOnUserAccount account) throws EventException{
		//abcd
		InvoiceCreationVO invoiceVo = new InvoiceCreationVO();
		List<InvoiceCreationVO> updateVoList = new ArrayList<InvoiceCreationVO>();
		String[] rtnValue = {"",""};
		
		try {
			
			// Invoice Creation 폼 변경 (주소선택기능추가)
			if(multiInvoiceManageListVO[0].getSRch().equalsIgnoreCase("addr2")){
				multiInvoiceManageListVO[0].setSVndrCustAddr(multiInvoiceManageListVO[0].getSVndrCustAddr2());
			}
			multiInvoiceManageListVO[0].setUserId(account.getUsr_id());
			multiInvoiceManageListVO[0].setUserOfcCd(account.getOfc_cd());
			multiInvoiceManageListVO[0].setOfcCd(account.getOfc_cd());
			multiInvoiceManageListVO[0].setSN3ptyInvRvisCd("ORG");
			multiInvoiceManageListVO[0].setSDaoN3ptyNo(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getSDaoN3ptyNo(),"'"));
			multiInvoiceManageListVO[0].setVndrCustRefRmk(JSPUtil.getNull(multiInvoiceManageListVO[0].getVndrCustRefRmk()));
			multiInvoiceManageListVO[0].setSNetAmt(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getSNetAmt(),","));
			multiInvoiceManageListVO[0].setSVatAmt(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getSVatAmt(),","));
			multiInvoiceManageListVO[0].setSSumInvAmt(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getSSumInvAmt(),","));
			multiInvoiceManageListVO[0].setSAddAmt(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getSAddAmt(),","));
			multiInvoiceManageListVO[0].setSDdctAmt(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getSDdctAmt(),","));
			multiInvoiceManageListVO[0].setBilTpCd(multiInvoiceManageListVO[0].getSDaoN3ptyBilTpCd());
			multiInvoiceManageListVO[0].setSLoclTaxAmt(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getSLoclTaxAmt(),","));
			multiInvoiceManageListVO[0].setSN2ndLoclTaxAmt(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getSN2ndLoclTaxAmt(),","));
			multiInvoiceManageListVO[0].setIdaCgstAmt(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getIdaCgstAmt(),","));
			multiInvoiceManageListVO[0].setIdaSgstAmt(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getIdaSgstAmt(),","));
			multiInvoiceManageListVO[0].setIdaIgstAmt(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getIdaIgstAmt(),","));
			multiInvoiceManageListVO[0].setIdaUgstAmt(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getIdaUgstAmt(),","));
			
			if(multiInvoiceManageListVO.length > 1)
			{
				String blTpCd = multiInvoiceManageListVO[0].getSDaoN3ptyBilTpCd();

				if(blTpCd.indexOf(",") > 0)
				{
					multiInvoiceManageListVO[0].setBilTpCd("MX");  //서로 다른 Billing case 다수일 때
				}
			}

			invoiceVo = multiInvoiceManageListVO[0];
			
			/// TPB 유효성 체크 
			String orgN3ptyNo = invoiceVo.getSDaoN3ptyNo();
			if(orgN3ptyNo != null && !"".equals(orgN3ptyNo)){			
				invoiceVo.setSDaoN3ptyNo(JSPUtil.getTypeString(orgN3ptyNo));
			}
			String validYn = dbDao.searchOutstandingDetailCheckForInvoiceCreation(invoiceVo);
			if ( validYn==null || !validYn.equals("Y") ) { // Including invalid TPB Outstanding 
				log.info(" Object TPB Status Check On Invoice Creation / validYn : " + validYn );
				throw new EventException(new ErrorHandler("TPB00064").getMessage());
			}
			
			// Invoice Header 생성
			invoiceVo.setSDaoN3ptyNo(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getSDaoN3ptyNo(),"'"));
			rtnValue = dbDao.createInvoiceRvis(invoiceVo);
			multiInvoiceManageListVO[0].setN3ptyInvNo(rtnValue[0]);
			multiInvoiceManageListVO[0].setN3ptyInvRvisSeq(rtnValue[1]);
			multiInvoiceManageListVO[0].setSN3ptyInvNo(rtnValue[0]);
			multiInvoiceManageListVO[0].setSN3ptyInvHisSeq(rtnValue[1]);
			
			invoiceVo = multiInvoiceManageListVO[0];
			
			for ( int idx=0; idx<multiInvoiceManageListVO .length; idx++ ) {
				if ( multiInvoiceManageListVO[idx].getIbflag().equals("I") || multiInvoiceManageListVO[idx].getIbflag().equals("U")){
					multiInvoiceManageListVO[idx].setN3ptyInvNo(multiInvoiceManageListVO[0].getN3ptyInvNo());
					multiInvoiceManageListVO[idx].setN3ptyInvRvisSeq(multiInvoiceManageListVO[0].getN3ptyInvRvisSeq());
					multiInvoiceManageListVO[idx].setSCurrCd(multiInvoiceManageListVO[0].getSCurrCd());
					multiInvoiceManageListVO[idx].setUserId(account.getUsr_id());
					multiInvoiceManageListVO[idx].setOfcCd(account.getOfc_cd());
					updateVoList.add(multiInvoiceManageListVO[idx]);
				} 
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCreateInvoiceRvisDtl(updateVoList);
			}
			
			eventResponse = createERPInterface(invoiceVo, account);
			
			eventResponse.setETCData("s_n3pty_inv_no",multiInvoiceManageListVO[0].getN3ptyInvNo());
			eventResponse.setETCData("s_his_seq",multiInvoiceManageListVO[0].getN3ptyInvRvisSeq());
			eventResponse.setETCData("s_n3pty_inv_his_seq",multiInvoiceManageListVO[0].getN3ptyInvRvisSeq());
			eventResponse.setETCData("s_n3pty_inv_rmd_cd",multiInvoiceManageListVO[0].getSN3ptyInvRvisCd());

		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		return eventResponse;
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param InvoiceCreationVO[] multiInvoiceManageListVO
	 * @param account SignOnUserAccount
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse modifyInvoice(InvoiceCreationVO[] multiInvoiceManageListVO, SignOnUserAccount account, GeneralEventResponse eventResponse) throws EventException{
		//abcd
		InvoiceCreationVO invoiceVo = new InvoiceCreationVO();
		List<InvoiceCreationVO> insertVoList = new ArrayList<InvoiceCreationVO>();
		
		String successFlag = "";
		String new_n3pty_inv_rvis_cd = ""; 			// 새 Revision 버전 
		String new_n3pty_inv_creditnote_cd = "";   	// 새 Credit Note 버전
		try {
			
			invoiceVo = multiInvoiceManageListVO[0];
			
			invoiceVo.setUserId(account.getUsr_id());
			invoiceVo.setUserOfcCd(account.getOfc_cd());
			invoiceVo.setOfcCd(account.getOfc_cd());
			
			/// Invoice 유효성 체크 
			String validYnInvoiceSeq = dbDao.searchInvoiceRvisSeq(invoiceVo);
			if ( !"Y".equals(validYnInvoiceSeq) ) {
				log.info(" Object Invoice Seq Check / validYn : " + validYnInvoiceSeq );
				throw new EventException(new ErrorHandler("TPB00075").getMessage());
			}
			
			/// Invoice 유효성 체크 
			String validYnRevision = dbDao.searchInvoiceStatusCheckForRevision(invoiceVo);
			if ( validYnRevision==null || !"Y".equals(validYnRevision) ) { // Including invalid TPB Outstanding				
				log.info(" Object Invoice Status Check On Invoice Modification / validYn : " + validYnRevision );
				throw new EventException(new ErrorHandler("TPB00065").getMessage());
			}

			/// Invoice 유효성 체크 
			String validYnCorrection = dbDao.searchInvoiceStatusCheckForCorrection(invoiceVo); // A,C,N
			if ( validYnCorrection == null ) validYnCorrection = "";
			invoiceVo.setValidYnCorrection(validYnCorrection);
			
			eventResponse.setETCData("validYnCorrection", validYnCorrection);		
			
			invoiceVo.setSN3ptyInvRvisSeq(invoiceVo.getSN3ptyInvHisSeq());
			
			String s_clt_agn_flg = invoiceVo.getSCltAgnFlg();
			if ( s_clt_agn_flg == null || !"Y".equals(s_clt_agn_flg) ){
				invoiceVo.setSCltAgnFlg("N");
			}
			String s_inv_iss_rhq_cd = invoiceVo.getSInvIssRhqCd();
			if ( s_inv_iss_rhq_cd == null ){
				invoiceVo.setSInvIssRhqCd("");
			}
			int hdr_del_result = 0; //Detail이 모두 delete 되면 Header 테이블도 delete 반영여부

			invoiceVo.setVndrCustRefRmk(JSPUtil.getNull(invoiceVo.getVndrCustRefRmk()));
			invoiceVo.setSAddAmt(JSPUtil.removeCharacter(invoiceVo.getSAddAmt(),","));
			invoiceVo.setSDdctAmt(JSPUtil.removeCharacter(invoiceVo.getSDdctAmt(),","));
			invoiceVo.setSNetAmt(JSPUtil.removeCharacter(invoiceVo.getSNetAmt(),","));
			invoiceVo.setSVatAmt(JSPUtil.removeCharacter(invoiceVo.getSVatAmt(),","));
			invoiceVo.setSTotalAmt(JSPUtil.removeCharacter(invoiceVo.getSTotalAmt(),","));
			invoiceVo.setSLoclTaxAmt(JSPUtil.removeCharacter(invoiceVo.getSLoclTaxAmt(),","));
			invoiceVo.setSN2ndLoclTaxAmt(JSPUtil.removeCharacter(invoiceVo.getSN2ndLoclTaxAmt(),","));
			
			String[] rtnValue= dbDao.modifyInvoiceRvis(invoiceVo);
			
			invoiceVo.setNewRvisSeq(rtnValue[1]);
			invoiceVo.setNewRvisCd(rtnValue[2]);
			invoiceVo.setNewCreditnoteSeq(rtnValue[3]);
			invoiceVo.setNewCreditnoteCd(rtnValue[4]);
			
			for ( int idx=0; idx<multiInvoiceManageListVO .length; idx++ ) {
				if ( "I".equals(multiInvoiceManageListVO[idx].getIbflag()) || "U".equals(multiInvoiceManageListVO[idx].getIbflag()) ){
					multiInvoiceManageListVO[idx].setUserId(account.getUsr_id());
					multiInvoiceManageListVO[idx].setOfcCd(account.getOfc_cd());					
					multiInvoiceManageListVO[idx].setSN3ptyInvNo(invoiceVo.getSN3ptyInvNo());
					multiInvoiceManageListVO[idx].setSN3ptyInvRvisSeq(invoiceVo.getSN3ptyInvRvisSeq());
					
					multiInvoiceManageListVO[idx].setNewRvisSeq(invoiceVo.getNewRvisSeq());
					multiInvoiceManageListVO[idx].setNewRvisCd(invoiceVo.getNewRvisCd());
					multiInvoiceManageListVO[idx].setNewCreditnoteSeq(invoiceVo.getNewCreditnoteSeq());
					multiInvoiceManageListVO[idx].setNewCreditnoteCd(invoiceVo.getNewCreditnoteCd());
					multiInvoiceManageListVO[idx].setSCurrCd(invoiceVo.getSCurrCd());
					multiInvoiceManageListVO[idx].setSCltAgnFlg(invoiceVo.getSCltAgnFlg());
					multiInvoiceManageListVO[idx].setLgsCostCd(invoiceVo.getLgsCostCd());
					multiInvoiceManageListVO[idx].setVndrCustRefRmk(invoiceVo.getVndrCustRefRmk());
					multiInvoiceManageListVO[0].setSAddAmt(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getSAddAmt(),","));
					multiInvoiceManageListVO[0].setSDdctAmt(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getSDdctAmt(),","));
					
					insertVoList.add(multiInvoiceManageListVO[idx]);
				} 
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.modifyInvoiceDtl(insertVoList);
				dbDao.modifyInvoiceOtsDtlInfo(insertVoList);
			}
			
			invoiceVo = multiInvoiceManageListVO[0];
			invoiceVo.setSN3ptyInvHisSeq(rtnValue[1]);
			
			eventResponse = createERPInterface(invoiceVo, account);
			
			
			String deleteYn = ""; // Delete 여부 
			
			if ( rtnValue != null && rtnValue.length >= 5){
				deleteYn = ( hdr_del_result>0?"Y":"N" );
				new_n3pty_inv_rvis_cd = invoiceVo.getNewRvisCd();
				new_n3pty_inv_creditnote_cd = invoiceVo.getNewCreditnoteCd();
			}
			
			if( "Y".equals(deleteYn) ){
				successFlag = "HDR_DELETE";
			} else if(new_n3pty_inv_rvis_cd.length()>0){
				successFlag = new_n3pty_inv_rvis_cd;
			} else {
				successFlag = "SUCCESS";
			}
			
			eventResponse.setETCData("hdr_del_result", successFlag);
			eventResponse.setETCData("new_n3pty_inv_rmd_cd", new_n3pty_inv_rvis_cd);
			eventResponse.setETCData("new_creditnote_cd", new_n3pty_inv_creditnote_cd);
			
			
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		return eventResponse;
	}
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param InvoiceCreationVO multiInvoiceManageListVO
	 * @param account SignOnUserAccount
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse removeInvoice(InvoiceCreationVO multiInvoiceManageListVO, SignOnUserAccount account, GeneralEventResponse eventResponse) throws EventException{
		
		InvoiceCreationVO inVO = multiInvoiceManageListVO;
		List<ARInterfaceCreationVO> genIfVOs = null;
		
		inVO.setUserId(account.getUsr_id());
		inVO.setUserOfcCd(account.getOfc_cd());
		inVO.setOfcCd(account.getOfc_cd());

		String successFlag = "";
		String out_erpif_creditnote_seq = "";   // 새 Credit Note seq
		String out_erpif_creditnote_cd = "";   // 새 Credit Note 버전
		try {
			/// Invoice 유효성 체크 
			String validYnInvoiceSeq = dbDao.searchInvoiceRvisSeq(inVO);
			if ( !validYnInvoiceSeq.equals("Y") ) {
				log.info(" Object Invoice Seq Check / validYn : " + validYnInvoiceSeq );
				throw new EventException(new ErrorHandler("TPB00075").getMessage());
			}
			
			/// Invoice 유효성 체크 
			String validYnRevision = dbDao.searchInvoiceStatusCheckForRevision(inVO);
//			log.debug( " validYnRevision : " + validYnRevision );
			if ( validYnRevision==null || validYnRevision.equals("") || !validYnRevision.equals("Y") ) { // Including invalid TPB Outstanding				
				log.info(" Object Invoice Status Check On Invoice Modification / validYn : " + validYnRevision );
				throw new EventException(new ErrorHandler("TPB00065").getMessage());
			}
	
			/// Invoice 유효성 체크 
			String validYnCorrection = dbDao.searchInvoiceStatusCheckForCorrection(inVO); // A,C,N
			if ( validYnCorrection==null) validYnCorrection = "";
			inVO.setValidYnCorrection(validYnCorrection);
			
			eventResponse.setETCData("validYnCorrection", validYnCorrection);		
			
//			log.debug( "validYnCorrection : " + validYnCorrection );
			
			inVO.setSN3ptyInvRvisSeq(inVO.getSN3ptyInvHisSeq());
			
			
			String s_clt_agn_flg = inVO.getSCltAgnFlg();
			if ( s_clt_agn_flg==null || !s_clt_agn_flg.equals("Y") ){
				inVO.setSCltAgnFlg("N");
			}
			String s_inv_iss_rhq_cd = inVO.getSInvIssRhqCd();
			if ( s_inv_iss_rhq_cd.trim().length()==0 ){
				inVO.setSInvIssRhqCd(JSPUtil.getNull(inVO.getSRhqCdForRhq()));
			}
			
			String[] rtnValue= dbDao.removeInvoice(inVO);
			inVO.setDelSucess(rtnValue[0]);
			inVO.setN3ptyInvNoTmp(rtnValue[1]);
			inVO.setNewCreditnoteSeq(rtnValue[2]);
			inVO.setNewCreditnoteCd(rtnValue[3]);
			
			if ( rtnValue!=null && rtnValue.length>=4 && rtnValue[0].equals("Y") ){
				successFlag = "DEL_SUCCESS";
				out_erpif_creditnote_seq = rtnValue[2];
				out_erpif_creditnote_cd = rtnValue[3];
			}
			eventResponse.setETCData("successFlag", successFlag);
			eventResponse.setETCData("out_erpif_rvis_seq", null);
			eventResponse.setETCData("out_erpif_rvis_cd", null);
			eventResponse.setETCData("out_erpif_creditnote_seq", out_erpif_creditnote_seq);			
			eventResponse.setETCData("out_erpif_creditnote_cd", out_erpif_creditnote_cd);
			
			inVO.setOutErpifRvisSeq(null);
			inVO.setOutErpifRvisCd(null);
			inVO.setOutErpifCreditnoteSeq(out_erpif_creditnote_seq);
			inVO.setOutErpifCreditnoteCd(out_erpif_creditnote_cd);

			/// erp ar credit note 
			if ( validYnCorrection.equals("A") ) { // credit note  ... erp ar i/f
				//테스트를 위해 임시로 막음
				log.debug("createErpData==cancel");	
				genIfVOs = this.createErpData(inVO);
			} else if ( validYnCorrection.equals("C") ) { // new version  ... erp ar i/f
				log.debug(" validYnCorrection : C ==> will be Execute in SC . ");
			}
			eventResponse.setRsVoList(genIfVOs);
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param SearchIndiaTaxInfoVO[] multiInvoiceManageListVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void multiIndiaTaxInfo(SearchIndiaTaxInfoVO[] multiInvoiceManageListVO, SignOnUserAccount account) throws EventException{
		try {
			List<SearchIndiaTaxInfoVO> insertVoList = new ArrayList<SearchIndiaTaxInfoVO>();
			List<SearchIndiaTaxInfoVO> updateVoList = new ArrayList<SearchIndiaTaxInfoVO>();
			List<SearchIndiaTaxInfoVO> deleteVoList = new ArrayList<SearchIndiaTaxInfoVO>();
			for ( int i=0; i<multiInvoiceManageListVO .length; i++ ) {
				if ( multiInvoiceManageListVO[i].getIbflag().equals("I")){
					multiInvoiceManageListVO[i].setCreUsrId(account.getUsr_id());
					multiInvoiceManageListVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(multiInvoiceManageListVO[i]);
				} else if ( multiInvoiceManageListVO[i].getIbflag().equals("U")){
					multiInvoiceManageListVO[i].setCreUsrId(account.getUsr_id());
					multiInvoiceManageListVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(multiInvoiceManageListVO[i]);
				} else if ( multiInvoiceManageListVO[i].getIbflag().equals("D")){
					multiInvoiceManageListVO[i].setUpdUsrId(account.getUsr_id());
					deleteVoList.add(multiInvoiceManageListVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.modifyMultiIndiaTaxInfo(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyMultiIndiaTaxInfo(updateVoList);
			}
			
			if ( deleteVoList.size() > 0 ) {
				dbDao.removeMmultiIndiaTaxInfo(deleteVoList);
			}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * DBRowSet을 <<AR Model>> Collection으로 변환
	 * @param dRsArr 
	 * @return Collection
	 * @exception EventException
	 */
	private List<InvArIfMnVO> changeErpInterfaceData(List<TpbInvIfSmryVO> smry) throws EventException {
		List<InvArIfMnVO> list = new ArrayList<InvArIfMnVO>();
//		log.debug("smry.size()=========>"+smry.size());
		//InvArIfMnVO addArIfMn = new InvArIfMnVO();
		try { 
			for (int i = 0 ; i < smry.size() ; i++ ){ // just 1 loop
				InvArIfMnVO inArMn = new InvArIfMnVO();
				inArMn.setApArOffstNo(smry.get(i).getCsrNo());
				inArMn.setBlSrcNo(smry.get(i).getBlNo()); // if_bl_no
				inArMn.setInvSrcNo(smry.get(i).getN3ptyInvNo());
				inArMn.setCustCntCd(smry.get(i).getInvCustCntCd());
				inArMn.setCustSeq(smry.get(i).getInvCustSeq());
				inArMn.setOfcCd(smry.get(i).getInvIfOfcCd());
				inArMn.setIfSrcCd("TPB");
				inArMn.setVslCd(smry.get(i).getVslCd());
				inArMn.setSkdVoyNo(smry.get(i).getSkdVoyNo());
				inArMn.setSkdDirCd((smry.get(i).getFincDirCd()).substring(0, 1));
				inArMn.setSailArrDt(smry.get(i).getSailArrDt());
				inArMn.setDueDt(smry.get(i).getRcvDueDt());
				inArMn.setGlEffDt(smry.get(i).getGlDt());
				inArMn.setPolCd(smry.get(i).getPolCd());
				inArMn.setPodCd(smry.get(i).getPodCd());
				//inArMn.setSvcScpCd(smry.get(i));
				inArMn.setSlanCd(smry.get(i).getLaneCd());
				//inArMn.setTrnkVslCd(smry.get(i));
				//inArMn.setTrnkSkdVoyNo(smry.get(i));
				//inArMn.setTrnkSkdDirCd(smry.get(i));
				inArMn.setPorCd(smry.get(i).getPorCd());
				inArMn.setDelCd(smry.get(i).getDelCd());
				inArMn.setSailDt(smry.get(i).getSailArrDt());
				inArMn.setIoBndCd("O");
				inArMn.setInvRmk(smry.get(i).getInvIfDesc());
				inArMn.setCreUsrId(JSPUtil.getNull(smry.get(i).getUserId()));
				inArMn.setCreDt(JSPUtil.getNull(smry.get(i).getCreDt()));
				inArMn.setUpdUsrId(JSPUtil.getNull(smry.get(i).getUserId()));
				inArMn.setUpdDt(JSPUtil.getNull(smry.get(i).getUpdDt()));
				//inArMn.setSrcIfDt("");
				//inArMn.setSrcIfSeq("");
				inArMn.setVvdTrnsFlg("");
				inArMn.setCgoWgt("");
				inArMn.setCgoMeasQty("");
				inArMn.setBkgTeuQty("");
				inArMn.setBkgFeuQty("");
				inArMn.setInvRefNo(JSPUtil.cutStringByLimit(JSPUtil.getNull(smry.get(i).getVndrCustRefRmk()),50));
				inArMn.setBlInvIfFlg("");
				inArMn.setTrspRqstOrdFlg("");
				
				list.add(inArMn);
			}
			
		}catch (Exception ex) {
			//ex.printStackTrace();
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} //finally {
		//	list = null;
		//}
//		log.debug("changeErpInterfaceData==>inend");
		return list;
	}
	/**
	 * DBRowSet을 <<AR Model>> Collection으로 변환
	 * @param dRsArr 
	 * @return Collection
	 * @exception EventException
	 */
	private List<InvArIfChgVO> changeErpInterfaceDataDtl(List<TpbInvIfDtlVO> dtl, String addAmt) throws EventException {
		List<InvArIfChgVO> list = new ArrayList<InvArIfChgVO>();
//		log.debug("changeErpInterfaceDataDtl==>inStart");
		////=== ADDED AMOUNT, DEDUCTED AMOUNT 처리 ===/////////////////////
//		log.debug("changeErpInterfaceDataDtl_addAmt==>>>>>>>>>>>>>>"+addAmt);
//		BigDecimal addDdtAmt = null; 
//		BigDecimal tempRemainAmt = null;
		BigDecimal tempAmt = null;
		
//		if ( addAmt != null && addAmt != "" ){ /// for Revision
//			addDdtAmt = new BigDecimal(addAmt); 
//			tempRemainAmt = addDdtAmt;
//		}
		////////////////////////////////////////////////////////////////////
		try {
			for (int i = 0 ; i < dtl.size() ; i++ ){ // just 1 loop 
				InvArIfChgVO inArChg = new InvArIfChgVO();
				inArChg.setChgSeq(JSPUtil.getNull(dtl.get(i).getChgSeq()));
//				log.debug("getChgCurrCd>>>>>>>>>>>>>>>>>>>>>>>>>"+dtl.get(i).getChgCurrCd());
				inArChg.setCurrCd(dtl.get(i).getChgCurrCd());
				inArChg.setChgCd(JSPUtil.getNull(dtl.get(i).getN3ptyInvChgTpCd()));
				inArChg.setPerTpCd("BL");
				inArChg.setTrfRtAmt(JSPUtil.getNull(dtl.get(i).getChgAmt()));
//				log.debug("inArChg.getTrfRtAmt()==>"+inArChg.getTrfRtAmt());
				//inArChg.setTrfRtAmt("");
				inArChg.setRatAsCntrQty("1");
//				log.debug("JSPUtil.getNull(dtl.get(0).getChgAmt())=======>"+JSPUtil.getNull(dtl.get(0).getChgAmt()));
				inArChg.setChgAmt(JSPUtil.getNull(dtl.get(i).getChgAmt()));
//				log.debug("JSPUtil.getNull(dtl.get(0).getRate())1=======>"+dbDao.getRate(dtl.get(i)));
				inArChg.setInvXchRt(JSPUtil.getNull(dbDao.getRate(dtl.get(i)))); // 환율을 입력
				inArChg.setChgFullNm(dtl.get(i).getChgFullNm());
				if(inArChg.getChgCd().equals("TPC")){
					inArChg.setRepChgCd("ERP");
				}else{
					inArChg.setRepChgCd("XXX");
				}
				if(inArChg.getChgCd().equals("")){
					inArChg.setChgCd("TTT");
				}
				inArChg.setChgRmk(dtl.get(i).getAcctCd());
//				log.debug("inArChg.getInvXchRt()==>"+inArChg.getInvXchRt());
				inArChg.setCreUsrId(JSPUtil.getNull(dtl.get(i).getUserId()));
				inArChg.setCreDt(JSPUtil.getNull(dtl.get(i).getCreDt()));
				inArChg.setUpdUsrId(JSPUtil.getNull(dtl.get(i).getUserId()));
				inArChg.setUpdDt(JSPUtil.getNull(dtl.get(i).getUpdDt()));
				//inArChg.setSrcIfDt("");
				//inArChg.setSrcIfSeq("");
				if (dtl.get(dtl.size()-1).getN3ptyInvChgTpCd().equals("TVA") 
						|| dtl.get(dtl.size()-1).getN3ptyInvChgTpCd().equals("SBC")
						|| dtl.get(dtl.size()-1).getN3ptyInvChgTpCd().equals("KKC")) {
					if (!inArChg.getChgCd().equals("TVA") && !inArChg.getChgCd().equals("SBC") && !inArChg.getChgCd().equals("KKC")){
						inArChg.setTvaFlg("Y");
					}else{
						inArChg.setTvaFlg(""); // N
					}					
				}else{
					inArChg.setTvaFlg(""); // N
				}

				
				////////////////////////////////////////////////////////////////////////////
				if ( addAmt.length() > 0 ){ /// for Revision
					tempAmt = new BigDecimal(dtl.get(i).getChgAmt());
//					log.debug("abc_tempAmt==>>>>>>>>>>>>>"+tempAmt.toString());
//					
//					if ( tempRemainAmt.compareTo(new BigDecimal(0)) != 0 ){
//						if ( tempAmt.add(tempRemainAmt).compareTo(new BigDecimal(0)) < 0 ){
//							tempRemainAmt = tempRemainAmt.add(tempAmt);
//							tempAmt = new BigDecimal(0);
//						} else if ( tempAmt.add(tempRemainAmt).compareTo(new BigDecimal(0)) >= 0 ){
//							tempAmt = tempAmt.add(tempRemainAmt);
//							tempRemainAmt = new BigDecimal(0);
//						}
//					}
//					log.debug("changeErpInterfaceDataDtl_tempAmt.toString()==>>>>>>>>>>>>>"+tempAmt.toString());
					inArChg.setChgAmt(tempAmt.toString());
				}
				
				list.add(inArChg);
			}
			
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} //finally {
		//	list = null;
		//}
//		log.debug("changeErpInterfaceDataDtl==>inEnd");
		return list;
	}

	/**
	 * [비즈니스대상]을 [행위] 합니다.<br>
	 * 
	 * @param InvoiceCreationVO vo
	 * @return List<ARInterfaceCreationVO>
	 * @exception EventException
	 */
	public List<ARInterfaceCreationVO> createErpData(InvoiceCreationVO vo) throws EventException{
		List<ARInterfaceCreationVO> genIfVOs = new ArrayList<ARInterfaceCreationVO>();

		try {
			String out_erpif_rvis_seq = vo.getOutErpifRvisSeq();
			String out_erpif_creditnote_seq = vo.getOutErpifCreditnoteSeq();
			String new_credit_note_cd = vo.getNewCreditnoteCd();
			String addAmt = "";
			///===== AR I/F Execute=====
//			log.debug("vo.getOutErpifRvisSeq()==>"+out_erpif_rvis_seq);
//			log.debug("vo.getOutErpifCreditnoteSeq()==>"+out_erpif_creditnote_seq);
//			log.debug("vo.getNewCreditnoteCd()==>"+vo.getNewCreditnoteCd());
//			log.debug("vo.getNewCreditnoteSeq()==>"+vo.getNewCreditnoteSeq());
//			log.debug("vo.getOutErpifCreditnoteCd()==>"+vo.getOutErpifCreditnoteCd());
//			log.debug("vo.getSCurrCd()==>"+vo.getSCurrCd());
//			log.debug("vo.getAddAmt()==>"+vo.getAddAmt());
//			log.debug("vo.getInvAmt()==>"+vo.getInvAmt());
//			log.debug("vo.getInvDtlAmt()==>"+vo.getInvDtlAmt());
//			log.debug("vo.getSTotalAmt()==>"+vo.getSTotalAmt());
			if ( new_credit_note_cd == null || new_credit_note_cd.length() != 3 ){
				new_credit_note_cd = vo.getOutErpifCreditnoteCd();
			}
			vo.setNewCreditnoteCd(new_credit_note_cd);
//			log.debug("new_credit_note_cd==>"+new_credit_note_cd);
			// step 1 : create i/f data to local db
			// Credit Note // Revision 

			if (out_erpif_creditnote_seq !=null && out_erpif_creditnote_seq.length() > 0) {
//				log.debug("out_erpif_creditnote_seq start===>"+out_erpif_creditnote_seq);
				List<TpbInvIfSmryVO> smry = dbDao.searchErpInterfaceDataForCreditNote(vo);
				vo.setArIfNo(smry.get(0).getArIfNo());
				//==================================================
//				addAmt = dbDao.searchErpInterfaceDataAddDdt(vo);
				//==================================================
				List<TpbInvIfDtlVO> dtl = dbDao.searchErpInterfaceDataForCreditNoteDtl(vo);
				ARInterfaceCreationVO genIfVo = new ARInterfaceCreationVO();
				//==============================================
//				log.debug("vo.getCurrCd()111>>>>>>>>>>>>>"+smry.get(0).getCurrCd());
//				log.debug("vo.getCurrCd()111>>>>>>>>>>>>>"+vo.getCurrCd());
//				log.debug("vo.getSCurrCd()111>>>>>>>>>>>>>"+vo.getSCurrCd());
//				dtl.get(0).setChgCurrCd(vo.getSCurrCd());
//				if (vo.getSCurrCd() == null || vo.getSCurrCd() == "") {
//					dtl.get(0).setChgCurrCd(vo.getCurrCd());
//				}else{
//					dtl.get(0).setChgCurrCd(vo.getSCurrCd());
//				}
				//dtl.get(0).setChgAmt(JSPUtil.removeCharacter(vo.getSTotalAmt(),","));
				//==============================================
//				BigDecimal addDdtAmt = new BigDecimal(0);
//				BigDecimal addDdtAmt = null;
//				BigDecimal tempRemainAmt = null;
//				BigDecimal tempAmt = null;
//				
//				if ( addAmt != null && addAmt != "" ){ /// for Revision
//					addDdtAmt = new BigDecimal(addAmt); 
//					tempRemainAmt = addDdtAmt;
//				}
//				
//				if ( addAmt.length() > 0 ){ /// for Revision
//					tempAmt = new BigDecimal(dtl.get(0).getChgAmt());
////					log.debug("dtl.get(0).getChgAmt()==============>"+dtl.get(0).getChgAmt());
////					log.debug("tempAmt==============>"+tempAmt);
//					if ( tempRemainAmt.compareTo(new BigDecimal(0)) != 0 ){
//						if ( tempAmt.add(tempRemainAmt).compareTo(new BigDecimal(0)) < 0 ){
//							tempRemainAmt = tempRemainAmt.add(tempAmt);
//							tempAmt = new BigDecimal(0);
//						} else if ( tempAmt.add(tempRemainAmt).compareTo(new BigDecimal(0)) >= 0 ){
//							tempAmt = tempAmt.add(tempRemainAmt);
//							tempRemainAmt = new BigDecimal(0);
//						}
//					}
////					log.debug("tempAmt.toString()==============>"+tempAmt.toString());
//					dtl.get(0).setChgAmt(tempAmt.toString());
//				}
				
				dbDao.createErpDataToTPBSmry(smry);
				dbDao.createErpDataToTPBDtl(dtl);
				
				//ARInterfaceCreationVO,InvArIfMnVO,InvArIfChgVO,InvArIfCntrVO
				List<InvArIfMnVO> resultSmry= changeErpInterfaceData(smry);
				List<InvArIfChgVO> resultDtl= changeErpInterfaceDataDtl(dtl,addAmt);
				
				//genIfVo.setInvArIfMnVOs(resultSmry);
				genIfVo.setInvArIfMnVO(resultSmry.get(0));
				genIfVo.setInvArIfChgVOs(resultDtl);
				
				genIfVOs.add(genIfVo);
			}
			if(out_erpif_rvis_seq !=null && out_erpif_rvis_seq.length() > 0){
//				log.debug("out_erpif_rvis_seq start===>"+out_erpif_rvis_seq);
				List<TpbInvIfSmryVO> smry = dbDao.searchErpInterfaceData(vo);
				vo.setArIfNo(smry.get(0).getArIfNo());
				addAmt = dbDao.searchErpInterfaceDataAddDdt(vo);
				List<TpbInvIfDtlVO> dtl = dbDao.searchErpInterfaceDataDtl(vo);
				ARInterfaceCreationVO genIfVo = new ARInterfaceCreationVO();
				//==============================================
//				log.debug("vo.getCurrCd()222>>>>>>>>>>>>>"+vo.getCurrCd());
//				log.debug("vo.getSCurrCd()222>>>>>>>>>>>>>"+vo.getSCurrCd());
//				dtl.get(0).setChgCurrCd(smry.get(0).getCurrCd());
//				dtl.get(0).setChgCurrCd(vo.getSCurrCd());
//				if (vo.getSCurrCd() == null || vo.getSCurrCd() == "") {
//					dtl.get(0).setChgCurrCd(vo.getCurrCd());
//				}else{
//					dtl.get(0).setChgCurrCd(vo.getSCurrCd());
//				}
//				log.debug("dtl.get(0).getChgCurrCd()>>>>>>>>>>>"+dtl.get(0).getChgCurrCd());
//				log.debug("dtl.get(1).getChgCurrCd()>>>>>>>>>>>"+dtl.get(1).getChgCurrCd());
				//dtl.get(0).setChgAmt(JSPUtil.removeCharacter(vo.getSTotalAmt(),","));
				//==============================================
//				BigDecimal addDdtAmt = new BigDecimal(0);
				BigDecimal addDdtAmt = null;
				BigDecimal tempRemainAmt = null;
				BigDecimal tempAmt = null;
				
				if ( addAmt != null && !addAmt.equals("") ){ /// for Revision				
					addDdtAmt = new BigDecimal(addAmt); 
					tempRemainAmt = addDdtAmt;
				}
				
				String n3ptyInvChgTpCd = "";
				n3ptyInvChgTpCd = dtl.get(0).getN3ptyInvChgTpCd();
 
				if ( addAmt != null 
						&& !"VGA".equals(n3ptyInvChgTpCd) && !"VGO".equals(n3ptyInvChgTpCd) // VGM Cost Code 는 개별 Add Amt 적용으로 제외
						&& !"VGP".equals(n3ptyInvChgTpCd) && !"VGW".equals(n3ptyInvChgTpCd)) {
					if ( addAmt.length() > 0 ){ /// for Revision
						tempAmt = new BigDecimal(dtl.get(0).getChgAmt());
	//					log.debug("dtl.get(0).getChgAmt()==============>"+dtl.get(0).getChgAmt());
	//					log.debug("dtl.get(1).getChgAmt()==============>"+dtl.get(1).getChgAmt());
	//					log.debug("dtl.get(2).getChgAmt()==============>"+dtl.get(2).getChgAmt());
	//					log.debug("dtl.get(3).getChgAmt()==============>"+dtl.get(3).getChgAmt());
	//					log.debug("tempAmt==============>"+tempAmt);
						
						//BigDecimal 사칙연산 
						//(+) : A.add(B)
						//(-) : A.subtract(B)
						//(*) : A.multiply(B)
						//(/) : A.divide(B)
						//비교 : A.compareTo(B)
						//절대값 : A.abs()
						
						//Administration Charge - Deducted Amount > 0
						if ( tempRemainAmt.compareTo(new BigDecimal(0)) > 0 ){
							tempAmt = tempAmt.add(tempRemainAmt);
							tempRemainAmt = new BigDecimal(0);
							dtl.get(0).setChgAmt(tempAmt.toString());
						}
						//Administration Charge - Deducted Amount < 0
						else if ( tempRemainAmt.compareTo(new BigDecimal(0)) < 0 ){
							int idx = 0;
							BigDecimal ddtAmt = null;
							ddtAmt = tempRemainAmt;
	
							for(idx=0;ddtAmt.compareTo(new BigDecimal(0))<0;idx++)
							{
								if(idx >= dtl.size()) break;
								
								tempAmt = new BigDecimal(dtl.get(idx).getChgAmt());
								
								if(tempAmt.compareTo(ddtAmt.abs()) >= 0)
								{
									tempAmt = tempAmt.add(ddtAmt);
									dtl.get(idx).setChgAmt(tempAmt.toString());
									ddtAmt = new BigDecimal(0);
								}
								else
								{
									dtl.get(idx).setChgAmt("0");
									ddtAmt = ddtAmt.add(tempAmt);
								}
							}
						}
					}
				 }
				dbDao.createErpDataToTPBSmry(smry);
				dbDao.createErpDataToTPBDtl(dtl);
				
//				log.debug("createErpData changeErpInterfaceData==> start");
				//ARInterfaceCreationVO,InvArIfMnVO,InvArIfChgVO,InvArIfCntrVO
				List<InvArIfMnVO> resultSmry= changeErpInterfaceData(smry);
				List<InvArIfChgVO> resultDtl= changeErpInterfaceDataDtl(dtl,addAmt);
//				log.debug("createErpData changeErpInterfaceData==> end");
				
				//genIfVo.setInvArIfMnVOs(resultSmry);
				genIfVo.setInvArIfMnVO(resultSmry.get(0));
				genIfVo.setInvArIfChgVOs(resultDtl);
				
				genIfVOs.add(genIfVo);
				
			}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		return genIfVOs;
	}
    /**
	 * RD Fax Send
	 * 
	 * @param SearchInvoiceStatusVO searchInvoiceStatusVO
	 * @return String
	 * @exception EventException
	 */
	public String rdFaxSend(SearchInvoiceStatusVO searchInvoiceStatusVO) throws EventException {
		InvoiceManageEAIDAO eaiDao = new InvoiceManageEAIDAO();
		TPBRDFaxMailEAIVO rdFaxMailEAIVO = new TPBRDFaxMailEAIVO();
//		String sendCd = null; // return; mail key
		try {
			///----- Receive Info 1 -----
			String s_n3pty_inv_no        = JSPUtil.getNull(searchInvoiceStatusVO.getSN3ptyInvNo());
			String s_dao_n3pty_bil_tp_cd = JSPUtil.getNull(searchInvoiceStatusVO.getSDaoN3ptyBilTpCd());
			String s_bil_loc             = JSPUtil.getNull(searchInvoiceStatusVO.getSBilLoc());
			if (s_bil_loc.equals("")) { 
				s_bil_loc = "L";
			}
			String s_his_seq             = JSPUtil.getNull(searchInvoiceStatusVO.getSHisSeq());
	
			String s_n3pty_inv_if_tp_cd  = JSPUtil.getNull(searchInvoiceStatusVO.getSN3ptyInvIfTpCd());
			// String s_clt_agn_flg         = JSPUtil.getNull( (String)params.get("s_clt_agn_flg") );
			String user_id               = JSPUtil.getNull(searchInvoiceStatusVO.getUserId()); //user id
			String ofc_cd                = JSPUtil.getNull(searchInvoiceStatusVO.getUserOfcCd());  
			String n3pty_inv_rmd_cd      = JSPUtil.getNull(searchInvoiceStatusVO.getSN3ptyInvRmdCd());
			String s_final_flg           = JSPUtil.getNull(searchInvoiceStatusVO.getSFinalFlg());			
			
			String s_contact_info           = JSPUtil.getNull(searchInvoiceStatusVO.getSContactInfo()); // email or fax no
								
			if ( s_n3pty_inv_if_tp_cd.equals("F") ) { // || s_n3pty_inv_if_tp_cd.equals("E") ) {
				///----- Receive Info 2 -----
				SearchInvoiceStatusVO reToName = this.getSendTargetInfo(searchInvoiceStatusVO);
	
				///----- Send Fax -----///
				
				// 1. FaxMetaInfo를 생성한다.
				//    <Parameter>
				//    1) sys_cd : 시스템 코드 (TPB, TRS 등)
				//    2) app_cd : 업무 코드 (임시적으로 템플릿 파일명으로 정의한다.)
				//    3) batch_ind : Batch 업무 유무 (Y/N)
				//    4) title : FAX 제목
				//    5) param : Report 생성시 필요한 Parameter
				//    6) rcv_info : 수신자 정보
				//    7) office : 사용자의 Office 코드
				
				String sys_cd = "TPB"; /// 향후 common table로 부터 
				String app_cd = "REP_ESD_TPB_0112.mrd"; /// 향후 common table로 부터 property
//				if ( s_his_seq==null || s_his_seq.trim().length()==0){
//					app_cd = "REP_ESD_TPB_010Correction.mrd";
//				} 
				String title = "SM Line Corporation 3rd Party Billing Invoice ("+s_n3pty_inv_no + "-"+ n3pty_inv_rmd_cd+")"; // INV Nol. + Remind Ver.
				String param = "["+s_n3pty_inv_no+"]["+s_dao_n3pty_bil_tp_cd+"]["+s_bil_loc+"]["+s_his_seq+"]["+s_final_flg+"]"; // rd parameter
					// /WEB_MAIN/apps/enis/esd/tpb/outstandingmanage/invoicemanage/script/ESD_TPB_010.js - function rdOpen 
				String rcv_info = null; // for test "Eric;0222873414,Endy;0222873414"; /// 수신자 이름; fax No. <= from TPB_INV_HDR
				
				String faxReceiver = JSPUtil.getNull( reToName.getVndrCustNm());
				// String faxNo = tpb_inv_hdr.getFax_no(); // Removed 
				String faxNo = s_contact_info; // Changed By Kim Jin-seung in 2007-05-04
				log.debug(" param : " + param); 
				log.debug(" title : " + title); 
				log.debug(" faxReceiver : " + faxReceiver + " / faxNo : " + faxNo);
				
				// faxNo = "0222873414"; // 임시 테스트용 
				
				if ( faxNo!=null && faxNo.trim().length() > 0 ) {
					rcv_info =  faxReceiver+";"+faxNo.trim();
					// rcv_info = "Eric;0222873414"; // 임시 테스트용
					
					// 1. FaxMetaInfo를 생성한다.
					// FaxMetaInfo info = new FaxMetaInfo("TPB", "REP_ESD_TPB_010.mrd", "N", "Fax 전송 테스트", "[][54][7][CHIBB][system1]", "Eric;0222873414,Endy;0222873414", "SELHO");
					rdFaxMailEAIVO.setSubSysCd(sys_cd);
					rdFaxMailEAIVO.setTmplMrd(app_cd);
					rdFaxMailEAIVO.setTitle(title);
					rdFaxMailEAIVO.setTmplParam(param);
					rdFaxMailEAIVO.setReceiverFax(rcv_info);	
					rdFaxMailEAIVO.setSenderUsrOfc(ofc_cd);	
					rdFaxMailEAIVO.setSenderUsrId(user_id);
					// 2. Fax의 send()메소드를 호출한다.
//					sendCd = eaiDao.rdFaxSend(rdFaxMailEAIVO); /// fax 테스트 후 처리 예정
//					log.info("RD-Fax sendCd : " + sendCd );
//					
//					if ( sendCd==null || sendCd.trim().length()==0 ){
//						throw new DAOException(new ErrorHandler("TPB00044").getMessage());
//					}
				}
			}
			return eaiDao.rdFaxSend(rdFaxMailEAIVO);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("TPB00045", new String[]{""}).getMessage(), ex);
		}
	}

	/**
	 * RD Mail Send
	 * 
	 * @param SearchInvoiceStatusVO searchInvoiceStatusVO
	 * @return String
	 * @exception EventException
	 */
	public String rdMailSend(SearchInvoiceStatusVO searchInvoiceStatusVO) throws EventException {
		InvoiceManageEAIDAO eaiDao = new InvoiceManageEAIDAO();
		TPBRDFaxMailEAIVO rdFaxMailEAIVO = new TPBRDFaxMailEAIVO();
		String snd_no = null;
//		String sendCd = null; // return; mail key
		try {
			
			///----- Receive Info 1 -----
			String s_n3pty_inv_no        = JSPUtil.getNull(searchInvoiceStatusVO.getSN3ptyInvNo());
			String s_dao_n3pty_bil_tp_cd = JSPUtil.getNull(searchInvoiceStatusVO.getSDaoN3ptyBilTpCd());
			String s_bil_loc             = JSPUtil.getNull(searchInvoiceStatusVO.getSBilLoc());
			if (s_bil_loc.equals("")) { 
				s_bil_loc = "L";
			}
			String s_his_seq             = JSPUtil.getNull(searchInvoiceStatusVO.getSHisSeq());
			String s_n3pty_inv_if_tp_cd  = JSPUtil.getNull(searchInvoiceStatusVO.getSN3ptyInvIfTpCd());
			String user_id               = JSPUtil.getNull(searchInvoiceStatusVO.getUserId()); //user id
			String n3pty_inv_rmd_cd      = JSPUtil.getNull(searchInvoiceStatusVO.getSN3ptyInvRmdCd());
			String s_final_flg           = JSPUtil.getNull(searchInvoiceStatusVO.getSFinalFlg());			

			String user_name             = JSPUtil.getNull(searchInvoiceStatusVO.getUserName()); //user name 
			String user_email            = JSPUtil.getNull(searchInvoiceStatusVO.getUserEmail()); //user email

			String s_contact_info           = JSPUtil.getNull(searchInvoiceStatusVO.getSContactInfo()); // email or fax no
			
			if ( s_n3pty_inv_if_tp_cd.equals("F") || s_n3pty_inv_if_tp_cd.equals("E") ) {
				///----- Receive Info 2 -----
				SearchInvoiceStatusVO reToName = this.getSendTargetInfo(searchInvoiceStatusVO);
	
				///----- Send Fax -----///
				
				// 1. FaxMetaInfo를 생성한다.
				//    <Parameter>
				//    1) sys_cd : 시스템 코드 (TPB, TRS 등)
				//    2) app_cd : 업무 코드 (임시적으로 템플릿 파일명으로 정의한다.)
				//    3) batch_ind : Batch 업무 유무 (Y/N)
				//    4) title : FAX 제목
				//    5) param : Report 생성시 필요한 Parameter
				//    6) rcv_info : 수신자 정보
				//    7) office : 사용자의 Office 코드
				
				String sys_cd = "TPB"; /// 향후 common table로 부터 
				String app_cd = "REP_ESD_TPB_0112.mrd"; /// 향후 common table로 부터 property
				String title = "SM Line Corporation 3rd Party Billing Invoice ("+s_n3pty_inv_no + "-"+ n3pty_inv_rmd_cd+")"; // INV Nol. + Remind Ver.
				String param = "["+s_n3pty_inv_no+"]["+s_dao_n3pty_bil_tp_cd+"]["+s_bil_loc+"]["+s_his_seq+"]["+s_final_flg+"]"; // rd parameter				
				//String param = JSPUtil.getNull(searchInvoiceStatusVO.getTmplParam()); // rd parameter
				// /WEB_MAIN/apps/enis/esd/tpb/outstandingmanage/invoicemanage/script/ESD_TPB_0110.js - function rdOpen 
				
				String senderName = user_name;
				String senderMail = user_email;
				String receiveToName = JSPUtil.getNull( reToName.getVndrCustNm());
				// String receiveToMail = JSPUtil.getNull( tpb_inv_hdr.getVndr_cust_eml() ); 
				String receiveToMail = s_contact_info; // Changed By Kim Jin-seung in 2007-05-04				
				String mailTitle = title; // now mail title is invoice no
				String mailBody = ""
						+ "Dear Sir and Madam, \n"
						+ " \n"
						+ "Please refer the attachment for 3rd Party Billing Inovice. \n"
						+ " \n"
						+ "Best regards \n"
						+ "SM Line Corporation  \n"
				;
				log.debug(" param : " + param); 
				log.debug(" title : " + title); 
				log.debug(" senderName : " + senderName + " / senderMail : " + senderMail);
				log.debug(" receiveToName : " + receiveToName + " / receiveToMail : " + receiveToMail);
				
				//receiveToMail = "sunnyday40@cyberlogitec.com"; // 임시 테스트용
				if ( receiveToMail!=null && receiveToMail.trim().length() > 0 ) {
					
					// 1. RDMailMetaInfo를 생성한다.
		    		// RDMailMetaInfo mailInfo = new RDMailMetaInfo("TPB", "aaa.mar", "N", "제목", "메일내용", "[param1][param2]","보낸사람이름", "보낸사람 Email", "받는사람 Email", "system1(사용자ID)");										
					rdFaxMailEAIVO.setSubSysCd(sys_cd);
					rdFaxMailEAIVO.setTmplMrd(app_cd);
					rdFaxMailEAIVO.setTitle(mailTitle);
					rdFaxMailEAIVO.setContent(mailBody);
					rdFaxMailEAIVO.setTmplParam(param);
					rdFaxMailEAIVO.setSenderUsrNm(senderName);	
					rdFaxMailEAIVO.setSenderUsrEml(senderMail);
					rdFaxMailEAIVO.setReceiverEml(receiveToMail);	
					rdFaxMailEAIVO.setSenderUsrId(user_id);									
//					String[] tmpArr = new String[]{sys_cd, app_cd, batch_ind, mailTitle, mailBody, param, senderName, senderMail, receiveToMail, user_id};

					// 2. RDMailUtility의 send()메소드를 호출한다.
					//sendCd = eaiDao.rdMailSend(rdFaxMailEAIVO);/// getting send_cd
					snd_no = eaiDao.rdMailSend(rdFaxMailEAIVO);/// getting send_cd
//					log.debug("RD-EMail sendCd : " + sendCd );
					
//					if ( sendCd==null || sendCd.trim().length()==0 ){
//						throw new DAOException(new ErrorHandler("TPB00045").getMessage());
//					}
				}
			}
			
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("TPB00045", new String[]{""}).getMessage(), ex);
		}
//		return sendCd;
		return snd_no;
	}
	
	/**
	 * Account Code, Name<br>
	 * 
	 * @return
	 * @throws EventException
	 */
	public List<TpbComboVO> searchAcctCd() throws EventException {
		try { 
			return dbDao.searchAcctCd();
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * Terminal Name, ATD 조회<br>
	 * 
	 * @param inputVO
	 * @return
	 * @throws EventException
	 */
	public List<SearchOutstandingDetailListForInvoiceCreationVO> searchYdNmAtd(InvoiceCreationVO inputVO) throws EventException {
		try { 
			return dbDao.searchYdNmAtd(inputVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	
	
	
	


	/**
	 * TPB EDI 전송 위해 FlatFile을 생성한다.
	 * @param SearchInvoiceStatusVO searchInvoiceStatusVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitTPBEDI(SearchInvoiceStatusVO searchInvoiceStatusVO, SignOnUserAccount account) throws EventException {
		TPBUtil		tpbUtil		= new TPBUtil();
		
		// FLATFILE
		String 			senderId 		= "";
		String 			receiverId 		= "";
		String 			headerType 		= "";
		String 		 	flatFileHeader	= null;
		String 		 	flatFileRefNo	= null;
		StringBuffer 	flatFile 		= new StringBuffer();
		
		// -- Input 정보 -- //
		// Invoice Info : searchInvoiceStatusVOs
		
		// -- Output 정보 -- //
		// TPB Invoice 정보
		SendInvoiceEdiVO 				sendInvoiceEdiInfo 			= null;
		// Container Count 정보
		List<SendInvoiceEdiItemVO> 		sendInvoiceEdiItemList 		= null;
		
		// -- For문 Index -- //
		int blIdx 	= 0;
		int ItemIdx = 0;

		
		try
		{
			// Body 생성
			if( searchInvoiceStatusVO != null ){
					
				//TPB start  for( blIdx = 0; blIdx < malaysiaBlInputList.size(); blIdx++ ){
					// Header 생성
					//$$$MSGSTART:HANJIN              MRCSHJSC            TPBINV    TPI130219538395
//					senderId = "HANJIN";
					senderId = "SMLINE";
					//receiverId = "MCRSHJSC";     //  "MCRSHJSC","AMAZON"
					receiverId = searchInvoiceStatusVO.getReceiverId();
					headerType = "TPBINV";
					flatFileHeader = tpbUtil.searchTPBEdiHeader(senderId, receiverId, headerType);
					flatFile.append(flatFileHeader).append("\n");
					
					if( blIdx == 0 ){
						flatFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("TPI"));
					}
					// (1) TPB Invoice 정보  searchInvoiceStatusVO
					sendInvoiceEdiInfo = dbDao.searchIssueEdiInfo(searchInvoiceStatusVO);
					if( sendInvoiceEdiInfo != null ){
						flatFile.append("SYSDATE:")			.append(sendInvoiceEdiInfo.getSysDate()).append("\n");
						flatFile.append("PURPOSE:")			.append(sendInvoiceEdiInfo.getPurpose()).append("\n");
						
						flatFile.append("TPBNO:")			.append(sendInvoiceEdiInfo.getTpbno()).append("\n");
						flatFile.append("INVNO:")			.append(sendInvoiceEdiInfo.getInvno()).append("\n");
						flatFile.append("COMPANY:")			.append(sendInvoiceEdiInfo.getCompany()).append("\n");
						flatFile.append("ADDRESS:")			.append(sendInvoiceEdiInfo.getAddress()).append("\n");
						flatFile.append("TEL:")				.append(sendInvoiceEdiInfo.getTel()).append("\n");
						flatFile.append("FAX:")				.append(sendInvoiceEdiInfo.getFax()).append("\n");
						flatFile.append("BT_USR1:")			.append(sendInvoiceEdiInfo.getBtUsr1()).append("\n");
						flatFile.append("BT_NAME:")			.append(sendInvoiceEdiInfo.getBtName()).append("\n");
						
						flatFile.append("BT_ADDRESS:")		.append(sendInvoiceEdiInfo.getBtAddress()).append("\n");
						flatFile.append("BT_CITY:")			.append(sendInvoiceEdiInfo.getBtCity()).append("\n");
						flatFile.append("BT_STATE:")		.append(sendInvoiceEdiInfo.getBtState()).append("\n");
						flatFile.append("BT_ZIP:")			.append(sendInvoiceEdiInfo.getBtZip()).append("\n");
						flatFile.append("BT_USR2:")			.append(sendInvoiceEdiInfo.getBtUsr2()).append("\n");
						flatFile.append("ISSUE_DATE:")		.append(sendInvoiceEdiInfo.getIssueDate()).append("\n");
						flatFile.append("ISSUE_OFFICE:")	.append(sendInvoiceEdiInfo.getIssueOffice()).append("\n");
						flatFile.append("DUE_DATE:")		.append(sendInvoiceEdiInfo.getDueDate()).append("\n");
						flatFile.append("CUST_CODE:")		.append(sendInvoiceEdiInfo.getCustCode()).append("\n");
						flatFile.append("REF_REMARK:")		.append(sendInvoiceEdiInfo.getRefRemark()).append("\n");
						// (1) TPB Invoice 정보  searchInvoiceStatusVO
						sendInvoiceEdiItemList = dbDao.searchIssueEdiItemInfo(searchInvoiceStatusVO);
						for( ItemIdx = 0; ItemIdx < sendInvoiceEdiItemList.size(); ItemIdx++)
						{

							flatFile.append("{ITEM").append("\n");
							flatFile.append("TYPE_CODE:")		.append(sendInvoiceEdiItemList.get(ItemIdx).getTypeCode()).append("\n");
							flatFile.append("TYPE_DESC:")		.append(sendInvoiceEdiItemList.get(ItemIdx).getN3ptyBilTpNm()).append("\n");
							flatFile.append("SEQNO:")			.append(sendInvoiceEdiItemList.get(ItemIdx).getSeqno()).append("\n");
							flatFile.append("EQKIND:")			.append(sendInvoiceEdiItemList.get(ItemIdx).getEqkind()).append("\n");
							flatFile.append("EQNO:")			.append(sendInvoiceEdiItemList.get(ItemIdx).getEqNo()).append("\n");							
							flatFile.append("EQTYPE:")			.append(sendInvoiceEdiItemList.get(ItemIdx).getEqtype()).append("\n");
							flatFile.append("BKGNO:")			.append(sendInvoiceEdiItemList.get(ItemIdx).getBkgno()).append("\n");
							flatFile.append("BLNO:")			.append(sendInvoiceEdiItemList.get(ItemIdx).getBlno()).append("\n");
							flatFile.append("VVD:")				.append(sendInvoiceEdiItemList.get(ItemIdx).getVvd()).append("\n");
							flatFile.append("YARD:")			.append(sendInvoiceEdiItemList.get(ItemIdx).getYard()).append("\n");
							
							flatFile.append("ROUTE:")			.append(sendInvoiceEdiItemList.get(ItemIdx).getRoute()).append("\n");
						  if(receiverId.equals("MCRSHJSC")){
						    flatFile.append("LOAD_ID:")			.append(sendInvoiceEdiItemList.get(ItemIdx).getLoadId()).append("\n");
						  }
						    flatFile.append("NEW_EQNO:")		.append(sendInvoiceEdiItemList.get(ItemIdx).getNewEqno()).append("\n");
							flatFile.append("NEW_SEAL:")		.append(sendInvoiceEdiItemList.get(ItemIdx).getNewSeal()).append("\n");
							flatFile.append("LASTFREE_DATE:")	.append(sendInvoiceEdiItemList.get(ItemIdx).getLastfreeDate()).append("\n");
							flatFile.append("AMT_ITEM:")		.append(sendInvoiceEdiItemList.get(ItemIdx).getAmtItem()).append("\n");
							
							flatFile.append("AMT_ITEM_VAT:")	.append(sendInvoiceEdiItemList.get(ItemIdx).getAmtItemVat()).append("\n");
							flatFile.append("PICKUP_DATE:")		.append(sendInvoiceEdiItemList.get(ItemIdx).getPickupDate()).append("\n");
							flatFile.append("FREETIME_OVER:")	.append(sendInvoiceEdiItemList.get(ItemIdx).getFreetimeOver()).append("\n");
							flatFile.append("CITATION:")		.append(sendInvoiceEdiItemList.get(ItemIdx).getCitation()).append("\n");
							flatFile.append("CNTR_WGT:")		.append(sendInvoiceEdiItemList.get(ItemIdx).getCntrWgt()).append("\n");
							
							flatFile.append("CNTR_WUNIT:")		.append(sendInvoiceEdiItemList.get(ItemIdx).getCntrWunit()).append("\n");
							flatFile.append("WAIT_HRS:")		.append(sendInvoiceEdiItemList.get(ItemIdx).getWaitHrs()).append("\n");
							flatFile.append("OCCUR_DATE:")		.append(sendInvoiceEdiItemList.get(ItemIdx).getOccurDate()).append("\n");
							flatFile.append("NEW_VVD:")			.append(sendInvoiceEdiItemList.get(ItemIdx).getNewVvd()).append("\n");
							flatFile.append("NEW_BKGNO:")		.append(sendInvoiceEdiItemList.get(ItemIdx).getBkgno()).append("\n");
							
							flatFile.append("ACCT:")			.append(sendInvoiceEdiItemList.get(ItemIdx).getAcct()).append("\n");
							flatFile.append("LOG_COST:")		.append(sendInvoiceEdiItemList.get(ItemIdx).getLogCost()).append("\n");
							flatFile.append("SONO:")			.append(sendInvoiceEdiItemList.get(ItemIdx).getSono()).append("\n");
							flatFile.append("CSRNO:")			.append(sendInvoiceEdiItemList.get(ItemIdx).getCsrno()).append("\n");
							flatFile.append("GL_DATE:")			.append(sendInvoiceEdiItemList.get(ItemIdx).getGlDate()).append("\n");
							
							flatFile.append("VVD_CD:")			.append(sendInvoiceEdiItemList.get(ItemIdx).getVvdCd()).append("\n");
							flatFile.append("ATD_INPUT_DATE:")	.append(sendInvoiceEdiItemList.get(ItemIdx).getAtdInputDate()).append("\n");
							flatFile.append("TERMINAL:")		.append(sendInvoiceEdiItemList.get(ItemIdx).getTerminal()).append("\n");
							flatFile.append("ACCOUNT_CD:")		.append(sendInvoiceEdiItemList.get(ItemIdx).getAccountCd()).append("\n");
							
							flatFile.append("}ITEM").append("\n");
						}						
						
						// (1) TPB Invoice 정보  searchInvoiceStatusVO
						flatFile.append("CUR:")				.append(sendInvoiceEdiInfo.getCur()).append("\n");
						flatFile.append("AMT_NET:")			.append(sendInvoiceEdiInfo.getAmtNet()).append("\n");
						flatFile.append("AMT_ADMIN:")		.append(sendInvoiceEdiInfo.getAmtAdmin()).append("\n");
						flatFile.append("AMT_DEDUCT:")		.append(sendInvoiceEdiInfo.getAmtDeduct()).append("\n");
						flatFile.append("AMT_VAT:")			.append(sendInvoiceEdiInfo.getAmtVat()).append("\n");
						flatFile.append("AMT_TOTAL:")		.append(sendInvoiceEdiInfo.getAmtTotal()).append("\n");
						flatFile.append("DESCRIPTION:")		.append(sendInvoiceEdiInfo.getDescription()).append("\n");
						flatFile.append("REMARK1:")			.append(sendInvoiceEdiInfo.getRemark1()).append("\n");
						flatFile.append("REMARK2:")			.append(sendInvoiceEdiInfo.getRemark2()).append("\n");

						
					}


				//} // end for (TPB)
			//}

			log.debug("abc_FlatFile = "+flatFile.toString());

			
			// send Flat File log VO 셋팅
			TPBEdiSndLogDtlVO tpbEdiSndLogDtlVO = new TPBEdiSndLogDtlVO(); // send
			//List<TPBEdiSndLogDtlVO> tpbEdiSndLogDtlList = new ArrayList<TPBEdiSndLogDtlVO>();
			
			
			// 전송로그를 저장한다. 	
			//FlatFile을 4000Byte씩 나눈다 - start (100Byte의 여유를 주기 위해 3900Byte로 나눔)
			int divisor = 3900;
			int totLength = flatFile.length();
			int quotient = totLength / divisor;
			int remainder = totLength % divisor;
				
			int loopCnt = 0;
			int start = 0;
			int end = 0;
			
			if(remainder > 0) {
				loopCnt = quotient + 1;
			} else {
				loopCnt = quotient;
			}
			
			String[] fFiles = new String[loopCnt];
			
			for(int i = 0; i < loopCnt; i++) {
				if(i == loopCnt-1) {
					end = remainder;
				} else {
					end = divisor;
				}
				
				start = i * divisor;
				
				fFiles[i] = flatFile.substring(start, start+end);

				
				tpbEdiSndLogDtlVO.setN3ptyEdiSndIndCd(sendInvoiceEdiInfo.getPurpose());
				tpbEdiSndLogDtlVO.setSndDt(sendInvoiceEdiInfo.getSysDate());
				tpbEdiSndLogDtlVO.setFltFileRefNo(flatFileRefNo);
				tpbEdiSndLogDtlVO.setLogDtlSeq(Integer.toString(i+1));
				tpbEdiSndLogDtlVO.setN3ptyNo(sendInvoiceEdiInfo.getTpbno());
				tpbEdiSndLogDtlVO.setN3ptyInvNo(sendInvoiceEdiInfo.getInvno());
				tpbEdiSndLogDtlVO.setEdiSndMsg(fFiles[i]);
				tpbEdiSndLogDtlVO.setCreUsrId(account.getUsr_id());
				tpbEdiSndLogDtlVO.setUpdUsrId(account.getUsr_id());

				// 전송로그를 저장한다. (DETAIL)
				if( tpbEdiSndLogDtlVO != null ){
					dbDao.addTPBEdiSndLogDtl(tpbEdiSndLogDtlVO);
				}								
				
			}


			
			// flatFile MQ로 전송
			ediSendMessage(flatFile.toString(), "TPB.ALPSTPB_UBIZHJS_CUSTINV.IBMMQ.QUEUE"); 
			
		}
		}catch (DAOException ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("TPB00080", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("TPB00080", new String[] {}).getMessage(), ex);
		}
		return flatFile.toString();
	}

	/**
	 * EDI 전송 처리부
	 * @param String flatFile
	 * @param String queueName
	 * @exception EventException
	 */
	private void ediSendMessage(String flatFile, String queueName) throws EventException
	{
		try {					
		  // FlatFile 이 빈 경우 SKIP 처리
			if (flatFile!=null && flatFile.trim().length() > 1) {
			  SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			  sendFlatFileVO.setFlatFile(flatFile);
			  sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get(queueName));
			  TPBUtil utilCommand = new TPBUtil();
			  FlatFileAckVO flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
			  if (flatFileAckVO.getAckStsCd().equals("E"))
			  	throw new EventException(new ErrorHandler("TPB00080", new String[] {}).getMessage());
			}
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("TPB00080", new String[] {}).getMessage(), ex);
		}
	}
	
	

	/**
	 * 
	 * BackEndJob을 실행.(CTA)
	 * @param SignOnUserAccount account
	 * @param SearchInvoiceStatusVO searchInvoiceStatusVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, SearchInvoiceStatusVO searchInvoiceStatusVO, String pgmNo)  throws EventException{

		InvoiceManageEdiBackEndJob backEndJob = new InvoiceManageEdiBackEndJob ();
		backEndJob.setPgmNo(pgmNo);
		String resultStr = "";

		if(pgmNo.equals("ESD_TPB_0112")) {

			backEndJob.setTPBEdiTransmitVO(searchInvoiceStatusVO);
			backEndJob.setAccount(account);
			BackEndJobManager backEndJobManager = new BackEndJobManager();

			resultStr = backEndJobManager.execute(backEndJob , account.getUsr_id(), "TPB EDI Transmit");
		}
		
		return resultStr;
	}
	

	/**
	 * ROC Rollback 작업 수행
	 * Create New Uncollected Cargo Case Number <br>
	 * 
	 * @param String ofcCd
	 * @param String userId
	 * @param String n3ptyNo
	 * @return String
	 * @exception EventException
	 */	
	public String checkRocRollback(String ofcCd, String userId, String n3ptyNo) throws EventException {
		
		try {
			return dbDao.checkRocRollback(ofcCd, userId, n3ptyNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("TPB00080").getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("TPB00080").getMessage(),ex);
		}
	}
	
	
}