/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceManageBCImpl.java
*@FileTitle : InvoiceManage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.basic;
 
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.event.EsdTpb0106Event;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.event.EsdTpb0110Event;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.event.EsdTpb0111Event;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.event.EsdTpb0112Event;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration.InvoiceManageDBDAO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.integration.InvoiceManageEAIDAO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.GetIndiaTaxInfoVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.InvoiceCreationVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.InvoiceDetailListForRevisionVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchErpInterfaceCheckDataVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchIndiaTaxInfoVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceDefaultDataVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceSettingVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchInvoiceStatusVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchOtsGrpInfoVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchOutstandingDetailListForInvoiceCreationVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchTPBHandlingVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.SearchThirdPartyInfoVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.TPBRDFaxMailEAIVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.TpbInvIfDtlVO;
import com.clt.apps.opus.esd.tpb.processmanage.invoicemanage.vo.TpbInvIfSmryVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.InvArIfMnVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * -InvoiceManagee Business Logic Basic Command implementation<br>
 * - -InvoiceManage business logic interface<br>
 *
 * @author 
 * @see ESD_TPB_0105EventResponse,InvoiceManageBC DAO class reference
 * @since J2EE 1.6
 */ 
public class InvoiceManageBCImpl extends BasicCommandSupport implements InvoiceManageBC {

	// Database Access Object
	private transient InvoiceManageDBDAO dbDao = null;

	/**
	 * InvoiceManageBCImpl object creation<br>
	 * InvoiceManageDBDAO creation<br>
	 */
	public InvoiceManageBCImpl() {
		dbDao = new InvoiceManageDBDAO();
	}
	/**
	 * <br>
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
	 * <br>
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
	 * ESD_TPB_0110 retrieve event<br>
	 *  SearchInvoiceCreation retrieve event<br>
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
			
			//inputting user office
			vo1.setUserOfcCd(sa.getOfc_cd());
			vo1.setSSheetSetCount("0");
			//------------------------------------------------------------------
			//getting invoice sheet set
			//------------------------------------------------------------------
 			
 			SearchInvoiceSettingVO vo1_1 =  event.getSearchInvoiceSettingVO();

 			vo1_1.setSInvIssOfcCd(sa.getOfc_cd());
 			
 			List<SearchInvoiceSettingVO> rsVO1_1=dbDao.searchInvoiceSheetSet(vo1_1);
 			
			if(rsVO1_1.size()>0){
//				log.debug("rsVO1_1.size()===>"+rsVO1_1.size());
//	 			log.debug("rsVO1_1.size()===>"+rsVO1_1.size());
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

			//setting rsVO1 by ETC-DATA
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
				eventResponse.setETCData("s_vndr_cust_addr2",rsVO1.get(0).getVndrCustAddr2());
				eventResponse.setETCData("s_vndr_cust_nm",rsVO1.get(0).getVndrCustNm());
				eventResponse.setETCData("s_rhq_cd",rsVO1.get(0).getRhqCd());
				eventResponse.setETCData("s_sheet_set_count",rsVO1.get(0).getSheetSetCount());
				eventResponse.setETCData("s_bil_loc",rsVO1.get(0).getBilToLocDivCd());
//				log.debug("rsVO1.get(0).getBilToLocDivCd()==============>"+rsVO1.get(0).getBilToLocDivCd());
				eventResponse.setETCData("s_vndr_cust_eml",rsVO1.get(0).getVndrCustEml());
				eventResponse.setETCData("s_vat_xch_rt",rsVO1.get(0).getVatXchRt());
				eventResponse.setETCData("s_rgst_no",rsVO1.get(0).getRgstNo());
			}
			
			//grid data
			InvoiceCreationVO vo2 = event.getInvoiceCreationVO();
			
			//inputting user office
			vo2.setUserOfcCd(sa.getOfc_cd());
			vo2.setSDaoN3ptyNo(s_dao_n3pty_no);
			
			List<SearchOutstandingDetailListForInvoiceCreationVO> rsVO2 = dbDao.searchOutstandingDetailListForInvoiceCreation(vo2);

			eventResponse.setRsVoList(rsVO2);
			
			InvoiceCreationVO vo3 = event.getInvoiceCreationVO();
			
			//inputting user office
			vo3.setUserOfcCd(sa.getOfc_cd());

			if(vo3.getSDetailN3ptyNo().length()<14){
				vo3.setSDetailN3ptyNo(JSPUtil.removeCharacter(vo3.getSDaoN3ptyNo(),"'"));
			}
			
			List<SearchOtsGrpInfoVO> rsVO3 = dbDao.searchOtsGrpInfo(vo3);
			
			//setting rsVO3 by ETC-DATA
			if (rsVO3.size() > 0) {
				eventResponse.setETCData("length_n3pty_bil_tp_cd",rsVO3.get(0).getLengthN3ptyBilTpCd());
			}else{
				eventResponse.setETCData("length_n3pty_bil_tp_cd","");
			}
			
			List<GetIndiaTaxInfoVO> rsVO4 = null;
			rsVO4 = dbDao.getIndiaTaxInfo(sa.getOfc_cd());
			eventResponse.setETCData("ida_tax_seq",rsVO4.get(0).getIdaTaxSeq());
			eventResponse.setETCData("expn_tax",rsVO4.get(0).getExpnTax());
			eventResponse.setETCData("edu_tax",rsVO4.get(0).getEduTax());
			eventResponse.setETCData("high_edu_tax",rsVO4.get(0).getHighEduTax());
			eventResponse.setETCData("tax_rgst_no",rsVO4.get(0).getTaxRgstNo());
			eventResponse.setETCData("svc_cate_rmk",rsVO4.get(0).getSvcCateRmk());
			eventResponse.setETCData("pmnt_acct_no",rsVO4.get(0).getPmntAcctNo());

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return eventResponse;
	}

	/**
	 * <br>
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
	 * <br>
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

			//getting n3pty_no of n3pty_inv_no
			List<InvoiceDetailListForRevisionVO> rsVO2 = dbDao.searchTrdPartyDataForCorrectionInvOts(invoiceDetailListForRevisionVO);
			
			String s_detail_n3pty_no = "";
			String s_detail_ots_sts_cd = "";
			StringBuffer s_detail_n3pty_no_sb = new StringBuffer() ;
			StringBuffer s_detail_ots_sts_cd_sb = new StringBuffer();
			
			if(rsVO2.size()>0){
				for(int i=0 ; i< rsVO2.size() ; i++){
					s_detail_n3pty_no_sb.append(rsVO2.get(i).getN3ptyNo());
					s_detail_ots_sts_cd_sb.append(rsVO2.get(i).getOtsStsCd());
				}
			}
			
			s_detail_n3pty_no = s_detail_n3pty_no_sb.toString();
			s_detail_ots_sts_cd = s_detail_ots_sts_cd_sb.toString();
					
			invoiceDetailListForRevisionVO.setSDetailN3ptyNo(s_detail_n3pty_no);
			invoiceDetailListForRevisionVO.setSDetailOtsStsCd(s_detail_ots_sts_cd);
			//checking France Office
			String isFrance = "N";
			List<InvoiceDetailListForRevisionVO> rsVO3 = dbDao.searchTrdPartyDataForCorrectionInvOrg(invoiceDetailListForRevisionVO);
			if(rsVO3.size() > 0){
				if( Integer.parseInt(rsVO3.get(0).getCnt()) > 0){
					isFrance = "Y";
				}
			}
			invoiceDetailListForRevisionVO.setIsFrance(isFrance);
			// ETC-DATA(HTML)
			List<InvoiceDetailListForRevisionVO> rsVO4 = null;
			if (invoiceDetailListForRevisionVO.getSHVndrCustDivCd().equals("V") || invoiceDetailListForRevisionVO.getSHVndrCustDivCd().equals("C"))
			{
				rsVO4 = dbDao.searchInvoiceRevisionInfo(invoiceDetailListForRevisionVO);
			}
			
			if(rsVO4!=null && rsVO4.get(0)!=null && rsVO4.size() > 0){
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
				
				eventResponse.setETCData("org_due_date",rsVO4.get(0).getRcvDueDt());
				eventResponse.setETCData("org_adm_chrg",rsVO4.get(0).getAddAmt());
				eventResponse.setETCData("org_ddct_amt",rsVO4.get(0).getDdctAmt());
				eventResponse.setETCData("org_tot_amt",rsVO4.get(0).getTotalAmt());
				eventResponse.setETCData("org_inv_desc",rsVO4.get(0).getInvDesc());

				eventResponse.setETCData("org_usr_inp_ctnt1",rsVO4.get(0).getUsrInpCtnt1());
				eventResponse.setETCData("org_vndr_cust_addr",rsVO4.get(0).getVndrCustAddr());
				eventResponse.setETCData("org_cty_nm",rsVO4.get(0).getCtyNm());
				eventResponse.setETCData("org_ste_cd",rsVO4.get(0).getSteCd());
				eventResponse.setETCData("org_zip_cd",rsVO4.get(0).getZipCd());
				eventResponse.setETCData("org_usr_inp_ctnt2",rsVO4.get(0).getUsrInpCtnt2());
				eventResponse.setETCData("org_vndr_cust_ref_rmk",rsVO4.get(0).getVndrCustRefRmk());

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
	 * <br>
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
	 * <br>
	 * 
	 * @param EsdTpb0112Event event
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchInvoiceStatus(EsdTpb0112Event event, GeneralEventResponse eventResponse) throws EventException {
		try {
			//using VO in list0
			SearchInvoiceStatusVO vo1 = event.getSearchInvoiceStatusVO();
			
			SignOnUserAccount sa = event.getSignOnUserAccount();
			vo1.setUserOfcCd(sa.getOfc_cd());
			vo1.setSN3ptyInvRvisSeq(vo1.getSN3ptyInvHisSeq());
			vo1.setSN3ptyInvRvisCd(vo1.getSN3ptyInvRmdCd());
			
			List<SearchInvoiceStatusVO> list1 = dbDao.searchIssueInfo(vo1);
			//eventResponse.setETCData(list1.get(0).getColumnValues());
			for (int i=0 ; i<list1.size(); i++) {
				//eventResponse.setETCData(list1.get(i).getColumnValues());
				eventResponse.setETCData("s_clt_agn_flg",list1.get(i).getCltAgnFlg());
				eventResponse.setETCData("s_n3pty_inv_sts_cd",list1.get(i).getN3ptyInvStsCd());
				eventResponse.setETCData("s_issue_yn",list1.get(i).getIssueYn());
				eventResponse.setETCData("s_erpif_yn",list1.get(i).getErpifYn());
				eventResponse.setETCData("s_bil_loc",list1.get(i).getBilToLocDivCd());
				eventResponse.setETCData("s_is_au",list1.get(i).getIsAu());
//				log.debug("list1.get(i).getBilToLocDivCd()============>"+list1.get(i).getBilToLocDivCd());
//				log.debug("list1.get(i).getSBilLoc()============>"+list1.get(i).getSBilLoc());
			}
			//<ETC KEY="s_result"><%=successFlag%></ETC>

			
			//eventResponse.setETCData("postVvd_comboCode", postPolCd);
			
			//getting VO
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
	 * <br>
	 * 
	 * @param EsdTpb0112Event event
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchCntCdbyOfcCd(EsdTpb0112Event event, GeneralEventResponse eventResponse) throws EventException {
		try {		
			Map<String, String> etcData = new HashMap<String, String>();
			
			String strOfcCd = event.getSignOnUserAccount().getOfc_cd();
			
			String strCntCd = dbDao.searchCountryCodeByOfcCd(strOfcCd);			
	
			etcData.put("CNT_CD", strCntCd);

			eventResponse.setETCData(etcData);
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * <br>
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
			//processing Email & Fax before tpb_inv_hdr table updating
			//---------------------------------------------------------------------------
			
			if(s_n3pty_inv_if_tp_cd.equals("E")){  //Email
//				log.debug("----- Email -----");
				fax_eml_snd_no = this.rdMailSend(searchInvoiceStatusVO, account);

			}else if(s_n3pty_inv_if_tp_cd.equals("F")){ //Fax
//				log.debug("----- Fax -----");
				fax_eml_snd_no = this.rdFaxSend(searchInvoiceStatusVO);
			}
			
			searchInvoiceStatusVO.setFaxEmlSndNo(fax_eml_snd_no);
			
			dbDao.updateInvoiceIssue(searchInvoiceStatusVO);
				
//		} catch (DAOException ex) {
//			//log.error("err " + ex.toString(), ex);
//			throw new EventException(ex.getMessage(),ex);
		} 
		catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
		return fax_eml_snd_no;
	}

	/**
	 * <br>
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
	 * <br>
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
	 * <br>
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
	 * <br>
	 * 
	 * @param Event e
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse createERPInterface(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		if( e.getEventName().equalsIgnoreCase("EsdTpb0110Event")){
			try {
			EsdTpb0110Event event = (EsdTpb0110Event)e;
			SignOnUserAccount account = event.getSignOnUserAccount();

			//InvoiceCreationVO[] invoiceCreationVO = event.getInvoiceCreationVOs();
			InvoiceCreationVO vo = event.getInvoiceCreationVO();
			
			/// Invoice 유효성 체크 
			String validYnInvoiceSeq = dbDao.searchInvoiceRvisSeq(vo);
			if ( !validYnInvoiceSeq.equals("Y") ) {
				log.info(" Object Invoice Seq Check / validYn : " + validYnInvoiceSeq );
				throw new EventException(new ErrorHandler("TPB00075").getMessage());
			}

			vo.setUserId(account.getUsr_id());
			vo.setUserOfcCd(account.getOfc_cd());
			vo.setOfcCd(account.getOfc_cd());
			vo.setUserName(account.getUsr_nm());
			vo.setUserEmail(account.getUsr_eml());
			
			///===== check status ===== 
			this.checkInvoiceStatus(vo);
			
			///===== update invoice status ===== 
			String[] erpifKeyArr = null;
			
			//s_n3pty_inv_no
			//s_n3pty_inv_his_seq
//			log.debug("vo.getSN3ptyInvHisSeq()==>"+vo.getSN3ptyInvHisSeq());
			
			erpifKeyArr = dbDao.updateInvoiceRevisionErpInterface(vo);
//			log.debug("erpifKeyArr[0]==========>"+erpifKeyArr[0]);
//			log.debug("erpifKeyArr[1]==========>"+erpifKeyArr[1]);
//			log.debug("erpifKeyArr[2]==========>"+erpifKeyArr[2]);
//			log.debug("erpifKeyArr[3]==========>"+erpifKeyArr[3]);
			
			vo.setOutErpifRvisSeq(erpifKeyArr[0]);
			vo.setOutErpifRvisCd(erpifKeyArr[1]);
			vo.setOutErpifCreditnoteSeq(erpifKeyArr[2]);
			vo.setOutErpifCreditnoteCd(erpifKeyArr[3]);

			//out_erpif_creditnote_seq			
			
			///===== Retrieve Get Channel(n3pty_expn_tp_cd) =====
			String n3pty_expn_tp_cd = null; /// Channel Indicator 
			n3pty_expn_tp_cd = this.getN3ptyExpnTpCd(vo);
			vo.setN3ptyExpnTpCd(n3pty_expn_tp_cd);
			
			///===== Customer Information Check For AR ===== 
			
			if( dbDao.checkCustomerInfo(vo) == false ){
				log.error("err - Invalid Customer Information For AR!!!");
				throw new EventException(new ErrorHandler("TPB00026").getMessage());
			}
			//===== A/R Office, Period Check =====
			String[] checkArOfcApPeriodResult = dbDao.checkArOfficeCode(vo);
			if ( checkArOfcApPeriodResult==null || checkArOfcApPeriodResult[0].equals("Y") == false ){
				log.error("err - Invalid AR Office Code For AR!!!");
				throw new EventException(new ErrorHandler("TPB00061").getMessage());
			}
			if ( checkArOfcApPeriodResult==null || checkArOfcApPeriodResult[1].equals("Y") == false ){
				log.error("err - Invalid AP Period For AR!!!");
				throw new EventException(new ErrorHandler("TPB00076").getMessage());
			}

			///===== AP/AR Process By Each Case =====
			List<ARInterfaceCreationVO> genIfVOs = this.createErpData(vo);
			eventResponse.setRsVoList(genIfVOs);
			eventResponse.setETCData("SucessYN","Y");

//			log.debug("eventResponse.setRsVo(genIfVOs)==========>end");
			} catch (DAOException ex) {
				//log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage(),ex);
			} catch (Exception ex) {
				//log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage(),ex);
			}
		}else if( e.getEventName().equalsIgnoreCase("EsdTpb0106Event")){
			try {
				EsdTpb0106Event event = (EsdTpb0106Event)e;
				SignOnUserAccount account = event.getSignOnUserAccount();

				InvoiceCreationVO vo = event.getInvoiceCreationVO();
				
				///checking Invoice validation 
				String validYnInvoiceSeq = dbDao.searchInvoiceRvisSeq(vo);
				if ( !validYnInvoiceSeq.equals("Y") ) {
					log.info(" Object Invoice Seq Check / validYn : " + validYnInvoiceSeq );
					throw new EventException(new ErrorHandler("TPB00075").getMessage());
				}
//				
//				vo.setN3ptyInvNo(vo.getSN3ptyInvNo());
//				vo.setSN3ptyInvHisSeq(vo.getSN3ptyInvHisSeq());
//				vo.setN3ptyInvNo(vo.getSN3ptyInvNo());
//				vo.setSN3ptyInvRmdCd(vo.getSN3ptyInvRmdCd());
				
				vo.setUserId(account.getUsr_id());
				vo.setUserOfcCd(account.getOfc_cd());
				vo.setOfcCd(account.getOfc_cd());
				vo.setUserName(account.getUsr_nm());
				vo.setUserEmail(account.getUsr_eml());
				
				///===== check status ===== 
				this.checkInvoiceStatus(vo);
				
				///===== update invoice status ===== 
				String[] erpifKeyArr = null;
				
				//s_n3pty_inv_no
				
				erpifKeyArr = dbDao.updateInvoiceRevisionErpInterface(vo);
//				log.debug("erpifKeyArr[0]==========>"+erpifKeyArr[0]);
//				log.debug("erpifKeyArr[1]==========>"+erpifKeyArr[1]);
//				log.debug("erpifKeyArr[2]==========>"+erpifKeyArr[2]);
//				log.debug("erpifKeyArr[3]==========>"+erpifKeyArr[3]);
				
				vo.setOutErpifRvisSeq(erpifKeyArr[0]);
				vo.setOutErpifRvisCd(erpifKeyArr[1]);
				vo.setOutErpifCreditnoteSeq(erpifKeyArr[2]);
				vo.setOutErpifCreditnoteCd(erpifKeyArr[3]);
				
				//out_erpif_creditnote_seq
				///===== Retrieve Get Channel(n3pty_expn_tp_cd) =====
				String n3pty_expn_tp_cd = null; /// Channel Indicator 
				n3pty_expn_tp_cd = this.getN3ptyExpnTpCd(vo);
				vo.setN3ptyExpnTpCd(n3pty_expn_tp_cd);
				
				///===== Customer Information Check For AR ===== 
				
				if( dbDao.checkCustomerInfo(vo) == false ){
					log.error("err - Invalid Customer Information For AR!!!");
					throw new EventException(new ErrorHandler("TPB00026").getMessage());
				}
				//===== A/R Office, Period Check =====
				String[] checkArOfcApPeriodResult = dbDao.checkArOfficeCode(vo);
				if ( checkArOfcApPeriodResult==null || checkArOfcApPeriodResult[0].equals("Y") == false ){
					log.error("err - Invalid AR Office Code For AR!!!");
					throw new EventException(new ErrorHandler("TPB00061").getMessage());
				}
				if ( checkArOfcApPeriodResult==null || checkArOfcApPeriodResult[1].equals("Y") == false ){
					log.error("err - Invalid AP Period For AR!!!");
					throw new EventException(new ErrorHandler("TPB00076").getMessage());
				}

				///===== AP/AR Process By Each Case =====
				List<ARInterfaceCreationVO> genIfVOs = this.createErpData(vo);
				eventResponse.setRsVoList(genIfVOs);
				eventResponse.setETCData("SucessYN","Y");
//				log.debug("eventResponse.setRsVo(genIfVOs)==========>end");
				} catch (DAOException ex) {
					//log.error("err " + ex.toString(), ex);
					throw new EventException(ex.getMessage(),ex);
				} catch (Exception ex) {
					//log.error("err " + ex.toString(), ex);
					throw new EventException(ex.getMessage(),ex);
				}
			
		}else if( e.getEventName().equalsIgnoreCase("EsdTpb0111Event")){
			try {
				EsdTpb0111Event event = (EsdTpb0111Event)e;
				SignOnUserAccount account = event.getSignOnUserAccount();

				//InvoiceCreationVO[] invoiceCreationVO = event.getInvoiceCreationVOs();
				InvoiceCreationVO vo = event.getInvoiceCreationVO();
				
				///checking Invoice validation 
				String validYnInvoiceSeq = dbDao.searchInvoiceRvisSeq(vo);
				if ( !validYnInvoiceSeq.equals("Y") ) {
					log.info(" Object Invoice Seq Check / validYn : " + validYnInvoiceSeq );
					throw new EventException(new ErrorHandler("TPB00075").getMessage());
				}

				vo.setUserId(account.getUsr_id());
				vo.setUserOfcCd(account.getOfc_cd());
				vo.setOfcCd(account.getOfc_cd());
				vo.setUserName(account.getUsr_nm());
				vo.setUserEmail(account.getUsr_eml());

				///===== check status ===== 
				this.checkInvoiceStatus(vo);

				///===== update invoice status ===== 
				String[] erpifKeyArr = null;
				
				//s_n3pty_inv_no
				
				erpifKeyArr = dbDao.updateInvoiceRevisionErpInterface(vo);

				vo.setOutErpifRvisSeq(erpifKeyArr[0]);
				vo.setOutErpifRvisCd(erpifKeyArr[1]);
				vo.setOutErpifCreditnoteSeq(erpifKeyArr[2]);
				vo.setOutErpifCreditnoteCd(erpifKeyArr[3]);

				//out_erpif_creditnote_seq
				
				///===== Retrieve Get Channel(n3pty_expn_tp_cd) =====
				String n3pty_expn_tp_cd = null; /// Channel Indicator 
				n3pty_expn_tp_cd = this.getN3ptyExpnTpCd(vo);
				vo.setN3ptyExpnTpCd(n3pty_expn_tp_cd);
				
				///===== Customer Information Check For AR ===== 
				
				if( dbDao.checkCustomerInfo(vo) == false ){
					log.debug("err - Invalid Customer Information For AR!!!");
					throw new EventException(new ErrorHandler("TPB00026").getMessage());
				}
				//===== A/R Office, Period Check =====
				String[] checkArOfcApPeriodResult = dbDao.checkArOfficeCode(vo);
				if ( checkArOfcApPeriodResult==null || checkArOfcApPeriodResult[0].equals("Y") == false ){
					log.debug("err - Invalid AR Office Code For AR!!!");
					throw new EventException(new ErrorHandler("TPB00061").getMessage());
				}
				if ( checkArOfcApPeriodResult==null || checkArOfcApPeriodResult[1].equals("Y") == false ){
					log.debug("err - Invalid AP Period For AR!!!");
					throw new EventException(new ErrorHandler("TPB00076").getMessage());
				}

				///===== AP/AR Process By Each Case =====
				List<ARInterfaceCreationVO> genIfVOs = this.createErpData(vo);
				eventResponse.setRsVoList(genIfVOs);
				eventResponse.setETCData("SucessYN","Y");
//				log.debug("eventResponse.setRsVo(genIfVOs)==========>end");
				} catch (DAOException ex) {
					//log.error("err " + ex.toString(), ex);
					throw new EventException(ex.getMessage(),ex);
				} catch (Exception ex) {
					//log.error("err " + ex.toString(), ex);
					throw new EventException(ex.getMessage(),ex);
				}
		}
		
		return eventResponse;
	}
	/**
	 * checking n3pty_inv_sts_cd of TPB Invoice No.<br>
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
	 * getting n3pty_expn_tp_cd of TPB Invoice No.<br>
	 * checking data validation<br>
	 * - NON J/O  : Source, Billing Case, 3rd Party, Revenue VVD, Currency - checking other value
	 * - J/O Case - Source, Billing Case, 3rd Party, Revenue VVD, Actual VVD, Currency, Csr No., Month of GL Date - checking other value 
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
			
//			if ( channelCnt != 1 || n3pty_expn_tp_cd == null ){
//				log.error("Error - Expense Type is not effective ");
//				throw new EventException(new ErrorHandler("TPB00028").getMessage());
//			}
			
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

			if ( n3pty_bil_tp_cd_max.equals("JO") == true ) { // JO Case
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
		
//		log.debug("n3pty_expn_tp_cd : " + n3pty_expn_tp_cd);
		
		return n3pty_expn_tp_cd;
	}
	
	/**
	 * <br>
	 * 
	 * @param SearchInvoiceSettingVO[] searchInvoiceSettingVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createInvoiceSheetSet(SearchInvoiceSettingVO[] searchInvoiceSettingVO, SignOnUserAccount account) throws EventException{
		try {
			List<SearchInvoiceSettingVO> insertVoList = new ArrayList<SearchInvoiceSettingVO>();
			List<SearchInvoiceSettingVO> updateVoList = new ArrayList<SearchInvoiceSettingVO>();
			List<SearchInvoiceSettingVO> deleteVoList = new ArrayList<SearchInvoiceSettingVO>();
			
			for ( int i=0; i<searchInvoiceSettingVO .length; i++ ) {
				if ( searchInvoiceSettingVO[i].getIbflag().equals("I")){
					searchInvoiceSettingVO[i].setCreUsrId(account.getUsr_id());
					searchInvoiceSettingVO[i].setUpdUsrId(account.getUsr_id());
					insertVoList.add(searchInvoiceSettingVO[i]);
				} else if ( searchInvoiceSettingVO[i].getIbflag().equals("U")){
					searchInvoiceSettingVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(searchInvoiceSettingVO[i]);
				} else if ( searchInvoiceSettingVO[i].getIbflag().equals("D")){
					deleteVoList.add(searchInvoiceSettingVO[i]);
				}
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.addInvoiceSheetSet(insertVoList);
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyInvoiceSheetSet(updateVoList);
			}
			
//			if ( deleteVoList.size() > 0 ) {
//				dbDao.removeInvoiceSheetSet(deleteVoList);
//			}
		} catch (DAOException ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			//log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(),ex);
		}
	}
	/**
	 * <br>
	 * 
	 * @param InvoiceCreationVO[] multiInvoiceManageListVO
	 * @param GeneralEventResponse eventResponse
	 * @param account SignOnUserAccount
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse createInvoice(InvoiceCreationVO[] multiInvoiceManageListVO, GeneralEventResponse eventResponse, SignOnUserAccount account) throws EventException{
		try {
			List<InvoiceCreationVO> updateVoList = new ArrayList<InvoiceCreationVO>();
			multiInvoiceManageListVO[0].setUserId(account.getUsr_id());
			multiInvoiceManageListVO[0].setUserOfcCd(account.getOfc_cd());
			multiInvoiceManageListVO[0].setOfcCd(account.getOfc_cd());
			multiInvoiceManageListVO[0].setSN3ptyInvRvisCd("ORG");

			if(multiInvoiceManageListVO[0].getSRch().equalsIgnoreCase("addr2")){
				multiInvoiceManageListVO[0].setSVndrCustAddr(multiInvoiceManageListVO[0].getSVndrCustAddr2());
			}
			multiInvoiceManageListVO[0].setVndrCustRefRmk(JSPUtil.getNull(multiInvoiceManageListVO[0].getVndrCustRefRmk()));
			multiInvoiceManageListVO[0].setSNetAmt(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getSNetAmt(),","));
			multiInvoiceManageListVO[0].setSVatAmt(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getSVatAmt(),","));
			multiInvoiceManageListVO[0].setSSumInvAmt(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getSSumInvAmt(),","));
			multiInvoiceManageListVO[0].setSAddAmt(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getSAddAmt(),","));
			multiInvoiceManageListVO[0].setSDdctAmt(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getSDdctAmt(),","));
			multiInvoiceManageListVO[0].setBilTpCd(multiInvoiceManageListVO[0].getSDaoN3ptyBilTpCd());
			
			
			if(multiInvoiceManageListVO.length > 1)
			{
				String blTpCd = multiInvoiceManageListVO[0].getSDaoN3ptyBilTpCd();

				if(blTpCd.indexOf(",") > 0)
				{
					multiInvoiceManageListVO[0].setBilTpCd("MX");  //each other Billing case
				}
			}

			InvoiceCreationVO invo1 = multiInvoiceManageListVO[0];
			String[] rtnValue = {"",""};
			
			///checking TPB validation 
			String s_dao_n3pty_no = invo1.getSDaoN3ptyNo();
			if(s_dao_n3pty_no != null && !s_dao_n3pty_no.equals("")){
				s_dao_n3pty_no = JSPUtil.getTypeString(s_dao_n3pty_no);
				invo1.setSDaoN3ptyNo(s_dao_n3pty_no);
			}

			String validYn = dbDao.searchOutstandingDetailCheckForInvoiceCreation(invo1);
			if ( validYn==null || !validYn.equals("Y") ) { // Including invalid TPB Outstanding 
				log.info(" Object TPB Status Check On Invoice Creation / validYn : " + validYn );
				throw new EventException(new ErrorHandler("TPB00064").getMessage());
			}
			multiInvoiceManageListVO[0].setSDaoN3ptyNo(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getSDaoN3ptyNo(),"'"));

			InvoiceCreationVO invo2 = multiInvoiceManageListVO[0];
			rtnValue = dbDao.createInvoiceRvis(invo2);
			
			multiInvoiceManageListVO[0].setN3ptyInvNo(rtnValue[0]);
			multiInvoiceManageListVO[0].setN3ptyInvRvisSeq(rtnValue[1]);

			eventResponse.setETCData("s_n3pty_inv_no",multiInvoiceManageListVO[0].getN3ptyInvNo());
			eventResponse.setETCData("s_his_seq",multiInvoiceManageListVO[0].getN3ptyInvRvisSeq());
			eventResponse.setETCData("s_n3pty_inv_his_seq",multiInvoiceManageListVO[0].getN3ptyInvRvisSeq());
			eventResponse.setETCData("s_n3pty_inv_rmd_cd",multiInvoiceManageListVO[0].getSN3ptyInvRvisCd());
			
			for ( int i=0; i<multiInvoiceManageListVO .length; i++ ) {
				if ( multiInvoiceManageListVO[i].getIbflag().equals("I") || multiInvoiceManageListVO[i].getIbflag().equals("U")){
					multiInvoiceManageListVO[i].setN3ptyInvNo(multiInvoiceManageListVO[0].getN3ptyInvNo());
					multiInvoiceManageListVO[i].setN3ptyInvRvisSeq(multiInvoiceManageListVO[0].getN3ptyInvRvisSeq());
					multiInvoiceManageListVO[i].setSCurrCd(multiInvoiceManageListVO[0].getSCurrCd());
					multiInvoiceManageListVO[i].setUserId(account.getUsr_id());
					multiInvoiceManageListVO[i].setOfcCd(account.getOfc_cd());
					updateVoList.add(multiInvoiceManageListVO[i]);
				} 
			}
			
			if ( updateVoList.size() > 0 ) {
				dbDao.modifyCreateInvoiceRvisDtl(updateVoList);
			}

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
	 * <br>
	 * 
	 * @param InvoiceCreationVO[] multiInvoiceManageListVO
	 * @param account SignOnUserAccount
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse modifyInvoice(InvoiceCreationVO[] multiInvoiceManageListVO, SignOnUserAccount account, GeneralEventResponse eventResponse) throws EventException{
		
			InvoiceCreationVO inVO = multiInvoiceManageListVO[0];
			List<InvoiceCreationVO> insertVoList = new ArrayList<InvoiceCreationVO>();
			
			inVO.setUserId(account.getUsr_id());
			inVO.setUserOfcCd(account.getOfc_cd());
			inVO.setOfcCd(account.getOfc_cd());
			
			String successFlag = "";
			String new_n3pty_inv_rvis_cd = ""; 			// new Revision version 
			String new_n3pty_inv_creditnote_cd = "";   	// new Credit Note version
		try {
			///checking Invoice validation 
			String validYnInvoiceSeq = dbDao.searchInvoiceRvisSeq(inVO);
			if ( !validYnInvoiceSeq.equals("Y") ) {
				log.info(" Object Invoice Seq Check / validYn : " + validYnInvoiceSeq );
				throw new EventException(new ErrorHandler("TPB00075").getMessage());
			}
			
			///checking Invoice validation 
			String validYnRevision = dbDao.searchInvoiceStatusCheckForRevision(inVO);
			if ( validYnRevision==null || validYnRevision.equals("") || !validYnRevision.equals("Y") ) { // Including invalid TPB Outstanding 
				log.info(" Object Invoice Status Check On Invoice Modification / validYn : " + validYnRevision );
				throw new EventException(new ErrorHandler("TPB00065").getMessage());
			}

			///checking Invoice validation 
			String validYnCorrection = dbDao.searchInvoiceStatusCheckForCorrection(inVO); // A,C,N
			if ( validYnCorrection==null) validYnCorrection = "";
			inVO.setValidYnCorrection(validYnCorrection);
			
			eventResponse.setETCData("validYnCorrection", validYnCorrection);		
			
			inVO.setSN3ptyInvRvisSeq(inVO.getSN3ptyInvHisSeq());
			
			String s_clt_agn_flg = inVO.getSCltAgnFlg();
			if ( s_clt_agn_flg==null || !s_clt_agn_flg.equals("Y") ){
				inVO.setSCltAgnFlg("N");
			}
			String s_inv_iss_rhq_cd = inVO.getSInvIssRhqCd();
			if ( s_inv_iss_rhq_cd==null ){
				inVO.setSInvIssRhqCd("");
			}
			int hdr_del_result = 0; //deleting header table in case of detail all data deleting

			inVO.setVndrCustRefRmk(JSPUtil.getNull(inVO.getVndrCustRefRmk()));
			inVO.setSAddAmt(JSPUtil.removeCharacter(inVO.getSAddAmt(),","));
			inVO.setSDdctAmt(JSPUtil.removeCharacter(inVO.getSDdctAmt(),","));
			inVO.setSVatAmt(JSPUtil.removeCharacter(inVO.getSVatAmt(),","));
			inVO.setSTotalAmt(JSPUtil.removeCharacter(inVO.getSTotalAmt(),","));
			
			String[] rtnValue= dbDao.modifyInvoiceRvis(inVO);
			
			inVO.setNewRvisSeq(rtnValue[1]);
			inVO.setNewRvisCd(rtnValue[2]);
			inVO.setNewCreditnoteSeq(rtnValue[3]);
			inVO.setNewCreditnoteCd(rtnValue[4]);
			
			String deleteYn = ""; // Delete
			
			if ( rtnValue!=null && rtnValue.length>=5){
				deleteYn = (hdr_del_result>0?"Y":"N");
				new_n3pty_inv_rvis_cd = inVO.getNewRvisCd();
				new_n3pty_inv_creditnote_cd = inVO.getNewCreditnoteCd();
			}
			
			if(deleteYn.equals("Y")){
				successFlag = "HDR_DELETE";
			} else if(new_n3pty_inv_rvis_cd.length()>0){
				successFlag = new_n3pty_inv_rvis_cd;
			} else {
				successFlag = "SUCCESS";
			}
			
			eventResponse.setETCData("hdr_del_result", successFlag);
			eventResponse.setETCData("new_n3pty_inv_rmd_cd", new_n3pty_inv_rvis_cd);
			eventResponse.setETCData("new_creditnote_cd", new_n3pty_inv_creditnote_cd);
			
			for ( int i=0; i<multiInvoiceManageListVO .length; i++ ) {
				if ( multiInvoiceManageListVO[i].getIbflag().equals("I") || multiInvoiceManageListVO[i].getIbflag().equals("U")){
					multiInvoiceManageListVO[i].setUserId(account.getUsr_id());
					multiInvoiceManageListVO[i].setOfcCd(account.getOfc_cd());					
					multiInvoiceManageListVO[i].setSN3ptyInvNo(inVO.getSN3ptyInvNo());
					multiInvoiceManageListVO[i].setSN3ptyInvRvisSeq(inVO.getSN3ptyInvRvisSeq());
					
					multiInvoiceManageListVO[i].setNewRvisSeq(inVO.getNewRvisSeq());
					multiInvoiceManageListVO[i].setNewRvisCd(inVO.getNewRvisCd());
					multiInvoiceManageListVO[i].setNewCreditnoteSeq(inVO.getNewCreditnoteSeq());
					multiInvoiceManageListVO[i].setNewCreditnoteCd(inVO.getNewCreditnoteCd());
					multiInvoiceManageListVO[i].setSCurrCd(inVO.getSCurrCd());
					multiInvoiceManageListVO[i].setSCltAgnFlg(inVO.getSCltAgnFlg());
					multiInvoiceManageListVO[i].setAcctCd(inVO.getAcctCd());
					multiInvoiceManageListVO[i].setLgsCostCd(inVO.getLgsCostCd());
					multiInvoiceManageListVO[i].setVndrCustRefRmk(inVO.getVndrCustRefRmk());
					multiInvoiceManageListVO[0].setSAddAmt(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getSAddAmt(),","));
					multiInvoiceManageListVO[0].setSDdctAmt(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getSDdctAmt(),","));
					
					insertVoList.add(multiInvoiceManageListVO[i]);
				} 
			}
			
			if ( insertVoList.size() > 0 ) {
				dbDao.modifyInvoiceDtl(insertVoList);
				dbDao.modifyInvoiceOtsDtlInfo(insertVoList);
			}
			
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
	 * <br>
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
		String out_erpif_creditnote_seq = "";   // new Credit Note seq
		String out_erpif_creditnote_cd = "";   // new Credit Note version
		try {
			///checking Invoice validation 
			String validYnInvoiceSeq = dbDao.searchInvoiceRvisSeq(inVO);
			if ( !validYnInvoiceSeq.equals("Y") ) {
				log.info(" Object Invoice Seq Check / validYn : " + validYnInvoiceSeq );
				throw new EventException(new ErrorHandler("TPB00075").getMessage());
			}
			
			///checking Invoice validation 
			String validYnRevision = dbDao.searchInvoiceStatusCheckForRevision(inVO);
//			log.debug( " validYnRevision : " + validYnRevision );
			if ( validYnRevision==null || validYnRevision.equals("") || !validYnRevision.equals("Y") ) { // Including invalid TPB Outstanding 
				log.info(" Object Invoice Status Check On Invoice Modification / validYn : " + validYnRevision );
				throw new EventException(new ErrorHandler("TPB00065").getMessage());
			}
	
			///checking Invoice validation 
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
	 * <br>
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
	 * DBRowSet <<AR Model>> Collection converting
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
				inArMn.setBkgNo(smry.get(i).getBkgNo());
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
				//inArMn.setInvRefNo(JSPUtil.cutStringByLimit(JSPUtil.getNull(smry.get(i).getVndrCustRefRmk()),50));
				inArMn.setInvRefNo(this.cutStringWithByteLimit(JSPUtil.getNull(smry.get(i).getVndrCustRefRmk()),50));
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
	 * 2016.12.28 Add 
	 * String to Byte Limit
	 * 
	 * @param source
	 * @param limit
	 * @return
	 */
	private String cutStringWithByteLimit(String source, int limit) {
	    if (StringUtils.isEmpty(source)) {
	        return "";
	    }

	    int sourceLength = source.getBytes().length;

	    if (sourceLength <= limit) {
	        return source;
	    }

	    int limitByte = 0;

	    for (int i = 0; i < source.length(); i++) {
	        String character = source.substring(i, i + 1);
	        int characterByteLength = character.getBytes().length;
	        if (limitByte + characterByteLength < limit) {
	            limitByte += characterByteLength;
	        } else {
	            return source.substring(0, i);
	        }
	    }
	    return source;
	}
	/**
	 * DBRowSet <<AR Model>> Collection converting
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
				
				inArChg.setTrfNo(JSPUtil.getNull(dtl.get(i).getTrfNo()));
				
//				log.debug("inArChg.getTrfRtAmt()==>"+inArChg.getTrfRtAmt());
				//inArChg.setTrfRtAmt("");
				inArChg.setRatAsCntrQty("1");
//				log.debug("JSPUtil.getNull(dtl.get(0).getChgAmt())=======>"+JSPUtil.getNull(dtl.get(0).getChgAmt()));
				inArChg.setChgAmt(JSPUtil.getNull(dtl.get(i).getChgAmt()));
//				log.debug("JSPUtil.getNull(dtl.get(0).getRate())1=======>"+dbDao.getRate(dtl.get(i)));
				inArChg.setInvXchRt(JSPUtil.getNull(dbDao.getRate(dtl.get(i)))); // inputting rate
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
				if (dtl.get(dtl.size()-1).getN3ptyInvChgTpCd().equals("TVA")) {
					if (!inArChg.getChgCd().equals("TVA")){
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
	 * <br>
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
				
				if ( addAmt != null && addAmt.length() > 0 ){ /// for Revision
					tempAmt = new BigDecimal(dtl.get(0).getChgAmt());
//					log.debug("dtl.get(0).getChgAmt()==============>"+dtl.get(0).getChgAmt());
//					log.debug("dtl.get(1).getChgAmt()==============>"+dtl.get(1).getChgAmt());
//					log.debug("dtl.get(2).getChgAmt()==============>"+dtl.get(2).getChgAmt());
//					log.debug("dtl.get(3).getChgAmt()==============>"+dtl.get(3).getChgAmt());
//					log.debug("tempAmt==============>"+tempAmt);
					
					//BigDecimal arithmetic
					//(+) : A.add(B)
					//(-) : A.subtract(B)
					//(*) : A.multiply(B)
					//(/) : A.divide(B)
					//compare : A.compareTo(B)
					//absolute value : A.abs()
					
					//Administration Charge - Deducted Amount > 0
					if ( tempRemainAmt != null && tempRemainAmt.compareTo(new BigDecimal(0)) > 0 ){
						tempAmt = tempAmt.add(tempRemainAmt);
						tempRemainAmt = new BigDecimal(0);
						dtl.get(0).setChgAmt(tempAmt.toString());
					}
					//Administration Charge - Deducted Amount < 0
					else if (tempRemainAmt != null && tempRemainAmt.compareTo(new BigDecimal(0)) < 0 ){
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
//			String n3pty_inv_rmd_cd      = JSPUtil.getNull(searchInvoiceStatusVO.getSN3ptyInvRmdCd());
			String s_final_flg           = JSPUtil.getNull(searchInvoiceStatusVO.getSFinalFlg());			
			
			String s_contact_info           = JSPUtil.getNull(searchInvoiceStatusVO.getSContactInfo()); // email or fax no
								
			if ( s_n3pty_inv_if_tp_cd.equals("F") ) { // || s_n3pty_inv_if_tp_cd.equals("E") ) {
				///----- Receive Info 2 -----
				SearchInvoiceStatusVO reToName = this.getSendTargetInfo(searchInvoiceStatusVO);
	
				///----- Send Fax -----///
				
				// 1. FaxMetaInfo creation
				//    <Parameter>
				//    1) sys_cd : system code (TPB, TRS 등)
				//    2) app_cd : business code
				//    3) batch_ind : Batch business indicator (Y/N)
				//    4) title : FAX title
				//    5) param : Report Parameter
				//    6) rcv_info : recipient information
				//    7) office : user Office code
				
				String sys_cd = "TPB"; /// from common table
				String app_cd = "REP_ESD_TPB_0112.mrd"; /// from common table
//				if ( s_his_seq==null || s_his_seq.trim().length()==0){
//					app_cd = "REP_ESD_TPB_010Correction.mrd";
//				} 
				log.debug("abc:"+ConstantMgr.getCompanyName());

				String title = "Invoice(INV#: "+s_n3pty_inv_no +")"; // INV Nol. + Remind Ver.
				String param = "["+s_n3pty_inv_no+"]["+s_dao_n3pty_bil_tp_cd+"]["+s_bil_loc+"]["+s_his_seq+"]["+s_final_flg+"]"; // rd parameter
				String rcv_info = null;
				
				String faxReceiver = JSPUtil.getNull( reToName.getVndrCustNm());
				// String faxNo = tpb_inv_hdr.getFax_no(); // Removed 
				String faxNo = s_contact_info;
				log.debug(" param : " + param); 
				log.debug(" title : " + title); 
				log.debug(" faxReceiver : " + faxReceiver + " / faxNo : " + faxNo);
				
				// faxNo = "0222873414"; // for temp test
				
				if ( faxNo!=null && faxNo.trim().length() > 0 ) {
					rcv_info =  faxReceiver+";"+faxNo.trim();
					// rcv_info = "Eric;0222873414"; // for temp test
					
					// 1. FaxMetaInfo creation
					rdFaxMailEAIVO.setSubSysCd(sys_cd);
					rdFaxMailEAIVO.setTmplMrd(app_cd);
					rdFaxMailEAIVO.setTitle(title);
					rdFaxMailEAIVO.setTmplParam(param);
					rdFaxMailEAIVO.setReceiverFax(rcv_info);	
					rdFaxMailEAIVO.setSenderUsrOfc(ofc_cd);	
					rdFaxMailEAIVO.setSenderUsrId(user_id);
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
	 * @param searchInvoiceStatusVO SearchInvoiceStatusVO
	 * @param account SignOnUserAccount
	 * @return String
	 * @exception EventException
	 */
	public String rdMailSend(SearchInvoiceStatusVO searchInvoiceStatusVO, SignOnUserAccount account) throws EventException {
		InvoiceManageEAIDAO eaiDao = new InvoiceManageEAIDAO();
		TPBRDFaxMailEAIVO rdFaxMailEAIVO = new TPBRDFaxMailEAIVO();
		String sendCd = ""; // return; mail key
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
//			String n3pty_inv_rmd_cd      = JSPUtil.getNull(searchInvoiceStatusVO.getSN3ptyInvRmdCd());
			String s_final_flg           = JSPUtil.getNull(searchInvoiceStatusVO.getSFinalFlg());			

			String user_name             = JSPUtil.getNull(searchInvoiceStatusVO.getUserName()); //user name 
//			String user_email            = JSPUtil.getNull(searchInvoiceStatusVO.getUserEmail()); //user email

			String s_contact_info           = JSPUtil.getNull(searchInvoiceStatusVO.getSContactInfo()); // email or fax no
			
//			String strFileName = searchInvoiceStatusVO.getTrdPartyVal() + "_" + searchInvoiceStatusVO.getSN3ptyInvNo() + ".pdf";
			String strFileName = searchInvoiceStatusVO.getTrdPartyVal() + "_" + searchInvoiceStatusVO.getSN3ptyInvNo();
			
			String strCntCd = dbDao.searchCountryCodeByOfcCd(account.getOfc_cd());
			
    		
    		if(StringUtils.isEmpty(strCntCd)){
    			strCntCd = account.getCnt_cd();
    		}
			
			if ( s_n3pty_inv_if_tp_cd.equals("F") || s_n3pty_inv_if_tp_cd.equals("E") ) {
				///----- Receive Info 2 -----
				SearchInvoiceStatusVO reToName = this.getSendTargetInfo(searchInvoiceStatusVO);
	
				///----- Send Fax -----///
				
				// 1. FaxMetaInfo creation
				//    <Parameter>
				//    1) sys_cd : system code (TPB, TRS)
				//    2) app_cd : business code
				//    3) batch_ind : Batch business indicator (Y/N)
				//    4) title : FAX title
				//    5) param : Report Parameter
				//    6) rcv_info : recipient information
				//    7) office : user Office code
				
				String sys_cd = "TPB"; /// from common table 
				String app_cd = "REP_ESD_TPB_0112.mrd"; /// from common table
				String title =  " Invoice Ref # "+s_n3pty_inv_no; // INV Nol. + Remind Ver.
				String param = "["+s_n3pty_inv_no+"]["+s_dao_n3pty_bil_tp_cd+"]["+s_bil_loc+"]["+s_his_seq+"]["+s_final_flg+"]"; // rd parameter				
				//String param = JSPUtil.getNull(searchInvoiceStatusVO.getTmplParam()); // rd parameter
				
				String senderName = user_name;
				String senderMail = "shipment.info@notifications.nykline.com";
				String receiveToName = JSPUtil.getNull( reToName.getVndrCustNm());
				// String receiveToMail = JSPUtil.getNull( tpb_inv_hdr.getVndr_cust_eml() ); 
				String receiveToMail = s_contact_info;				
				String mailTitle = title; // now mail title is invoice no
//				String mailBody = ""
//						+ "Dear Sir and Madam, \n"
//						+ " \n"
//						+ "Please refer the attachment for 3rd Party Billing Inovice. \n"
//						+ " \n"
//						+ "Best regards \n"
//						+ ConstantMgr.getCompanyName() + " Co;Ltd  \n"
//				;
				
				String mailBody = "** Please do not reply to this e-mail, as it will go to an unmonitored mailbox. If you need any assistance, please contact the appropriate NYK contact in your area. ** \n"
									  +"Thank you for shipping with NYK Line. www.nykline.com\n"	;
				log.debug(" param : " + param); 
				log.debug(" title : " + title); 
				log.debug(" senderName : " + senderName + " / senderMail : " + senderMail);
				log.debug(" receiveToName : " + receiveToName + " / receiveToMail : " + receiveToMail);
				
				//receiveToMail = "sunnyday40@cyberlogitec.com"; // for temp test
				if ( (receiveToMail!=null && receiveToMail.trim().length() > 0) || "IN".equals(strCntCd) ) {
					
					// 1. RDMailMetaInfo creation
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

					// 2. calling send() of RDMailUtility
					//sendCd = eaiDao.rdMailSend(rdFaxMailEAIVO);/// getting send_cd
					sendCd = eaiDao.rdMailSend(rdFaxMailEAIVO, account, strFileName, strCntCd);/// getting send_cd
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
		return sendCd;
	}
	
	/**
	 * <br>
	 * 
	 * @param SearchTPBHandlingVO[] searchTPBHandlingVOs
	 * @exception EventException
	 */
	public void cancelTPBHandling(SearchTPBHandlingVO[] searchTPBHandlingVOs, SignOnUserAccount account) throws EventException {
		try {
			List<SearchTPBHandlingVO> updateVoList = new ArrayList<SearchTPBHandlingVO>();
			for(int i = 0; i < searchTPBHandlingVOs.length; i++){
				searchTPBHandlingVOs[i].setUserId(account.getUsr_id());
				updateVoList.add(searchTPBHandlingVOs[i]);
			}
			
			if(updateVoList.size() > 0){
				dbDao.removeTpbOtsDtlStsData(updateVoList);
				dbDao.removeTpbOtsDtlRcvrActData(updateVoList);
				dbDao.removeTpbOtsGrpStsData(updateVoList);
				dbDao.removeTpbOtsGrpRcvrActData(updateVoList);
				dbDao.removeTpbOtsGrpData(updateVoList);
				dbDao.modifyTpbOtsDtlData(updateVoList);
			}
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
}