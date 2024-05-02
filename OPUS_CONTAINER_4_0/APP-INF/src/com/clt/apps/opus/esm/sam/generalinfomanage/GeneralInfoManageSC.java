/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GeneralInfoManageSC.java
*@FileTitle : Customer List Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.05.09 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.bcm.ccd.ccdcommon.ccdcommon.basic.CcdCommonBC;
import com.clt.apps.opus.bcm.ccd.ccdcommon.ccdcommon.basic.CcdCommonBCImpl;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.basic.PartnerBC;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.basic.PartnerBCImpl;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.CustomerAddressVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBC;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgSalesRepVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.ArrivalNoticeBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MdmCustomerVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.basic.CustomerInfoManageBC;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.basic.CustomerInfoManageBCImpl;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.event.EsmSam0001Event;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.event.EsmSam0002Event;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.event.EsmSam0004Event;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.event.EsmSam0010Event;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.event.EsmSam0011Event;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.event.EsmSam0903Event;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.integration.CustomerInfoManageDBDAO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.CustCoverTeamVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.CustomerGroupCodeVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.MoreInfoVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SamActivityInfoVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SamCustHistVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SamCustPreInfoVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchCustomerCodeGroupingVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchCustomerVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchKeyManVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.keymaninfomanage.basic.KeyManInfoManageBC;
import com.clt.apps.opus.esm.sam.generalinfomanage.keymaninfomanage.basic.KeyManInfoManageBCImpl;
import com.clt.apps.opus.esm.sam.generalinfomanage.keymaninfomanage.event.EsmSam0003Event;
import com.clt.apps.opus.esm.sam.generalinfomanage.keymaninfomanage.vo.SamKeyManInfoVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.basic.SalesRepInfoManageBC;
import com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.basic.SalesRepInfoManageBCImpl;
import com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.event.EsmSam0005Event;
import com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.event.EsmSam0006Event;
import com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.event.EsmSam0900Event;
import com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.vo.CustomsCustomerVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.salesrepinfomanage.vo.SamCustSRepVO;
import com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.basic.SalesAdminCommonBC;
import com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.basic.SalesAdminCommonBCImpl;
import com.clt.bizcommon.commodity.basic.CommodityBC;
import com.clt.bizcommon.commodity.basic.CommodityBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MdmCustAddrVO;


/**
 * ALPS-GeneralInfoManage Business Logic ServiceCommand - ALPS-GeneralInfoManage 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author LEECHANGWON
 * @see CustomerInfoManageDBDAO
 * @since J2EE 1.6
 */

public class GeneralInfoManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * GeneralInfoManage system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * GeneralInfoManage system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-GeneralInfoManage system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmSam0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustomerList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = checkOfcCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = checkSlsRepCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = checkLocCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSalesRepAdjustment(e);			
			} else {
				eventResponse = searchSalesRepBySalesOffice(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmSam0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustomerInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAddressList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCustomerPreferenceInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCustCoverList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchCustActvityList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchMoreInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchCustHistList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = checkCustCd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = checkCrCustCd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = checkCntcCustCd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = checkSalesRepCd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = checkPermission(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = checkCmdtCd(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {	
				eventResponse = checkLocCode(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {	
				eventResponse = checkVndrCode(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {	
				eventResponse = checkCntCode(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {	
				eventResponse = checkStateCode(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCustomerInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageCustomerAddressInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = manageCustomerPreferenceInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = manageCustCoverInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = manageMoreInfo(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmSam0004Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchCustomerPFMCGroupDetail(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) 
			{
				eventResponse = searchGroupCustomerName(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmSam0005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSRepList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = checkOfcCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = checkCustCode(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmSam0010Event")) // 0209 SHKIM
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchCustomerCodeGrouping(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) 
			{
				eventResponse = searchCustomerCodeGrouping(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) 
			{
				eventResponse = manageCustomerInfo0010(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmSam0011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustomerGroupCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchCustomerGroupCodeDetail(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmSam0902Event")) // 0209 SHKIM
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchCustomerCodeGrouping(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) 
			{
				eventResponse = searchCustomerCodeGrouping(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmSam0903Event")) // 0209 SHKIM
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchCustomerGroupCode(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) 
			{
				eventResponse = searchCustomerGroupCode(e);
			
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmSam0900Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchSRepName(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI))
			{
				eventResponse = manageCustSRep(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmSam0006Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchCustomerBySalesRep(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) 
			{
				eventResponse = searchSRepName(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) 
			{
				eventResponse = searchSRepNameByUser(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmSam0003Event"))
		{
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) 
			{
				eventResponse = searchKeyManInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) 
			{
				eventResponse = searchKeyManDetailInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCustomerName(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) 
			{
				eventResponse = manageKeyManInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) 
			{
				eventResponse = deleteKeyManInfo(e);
			}
		}
		return eventResponse;
	}

	/**
	 * ESM_SAM_0005 : Retrieve<br>
	 * Sales Rep 정보 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchSRepList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0005Event event = (EsmSam0005Event)e;
		SalesRepInfoManageBC command = new SalesRepInfoManageBCImpl();

		try{
			List<SamCustSRepVO> list = command.searchSRepList(event.getSamCustSRepVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/** ESM_SAM_0006 <br>
	 * S.Rep Code 별 데이타를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchSRepNameByUser(Event e) throws EventException
	{

		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SalesRepInfoManageBC command = new SalesRepInfoManageBCImpl();

		try {				
			String repInfo = command.searchSRepNameByUser(account);
			if(repInfo != null){
				String[] repInfoData = repInfo.split("\t");
				eventResponse.setETCData("srep_cd", repInfoData[0]);
				eventResponse.setETCData("ofc_cd", repInfoData[1]);
				eventResponse.setETCData("srep_nm", repInfoData[2]);
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
		
	}
	
	/** ESM_SAM_0006 <br>
	 * S.Rep Code 별 데이타를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerBySalesRep(Event e) throws EventException
	{

		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0006Event event = (EsmSam0006Event)e;
		SalesRepInfoManageBC command = new SalesRepInfoManageBCImpl();

		try {				
			List<SearchCustomerVO> list = command.searchCustomerBySalesRep(event.getSearchCustomerVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	/** ESM_SAM_0006, ESM_SAM_0900 <br>
	 * S.Rep Code 별 데이타를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse  searchSRepName(Event e) throws EventException
	{

		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SalesRepInfoManageBC command = new SalesRepInfoManageBCImpl();
		SearchCustomerVO searchCustomerVO = null;
		
		SearchCustomerVO searchCustomerDetailVO = null;
		
		String custSeq = "";
		String custCntCd = "";
		String flg = "";
		
		
		if(e instanceof EsmSam0006Event){
			EsmSam0006Event event = (EsmSam0006Event)e;
			searchCustomerVO = event.getSearchCustomerVO();
		}else if(e instanceof EsmSam0900Event){
			EsmSam0900Event event = (EsmSam0900Event)e;
			searchCustomerVO = event.getSearchCustomerVO();
		}
		
		if(searchCustomerVO != null) {

			
			try {				
				String repInfo = command.searchSRepName(searchCustomerVO);
				if(repInfo != null){
				String[] repInfoData = repInfo.split("\t");
				eventResponse.setETCData("ofc_cd", repInfoData[0]);
				eventResponse.setETCData("srep_nm", repInfoData[1]);
				}
				if(e instanceof EsmSam0900Event){
					
					searchCustomerDetailVO = command.searchPrmyKey(searchCustomerVO);
					
					if(searchCustomerDetailVO != null) {
						custSeq = searchCustomerDetailVO.getCustSeq();
						custCntCd = searchCustomerDetailVO.getCustCntCd();
						flg = searchCustomerDetailVO.getFlg();
						
						if(flg == null || "".equals(flg)) {
							flg = "NON";
						}
					}
					
					eventResponse.setETCData("cust_seq", custSeq);
					eventResponse.setETCData("cust_cnt_cd", custCntCd);
					eventResponse.setETCData("srep_prmry_flg", flg);
					
				}
				
			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}	
		
		}
		return eventResponse;
	
	}

	/**
	 * ESM_SAM_0900 <br>
	 * 변경된 SrepFlg를 저장
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse manageCustSRep(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0900Event event = (EsmSam0900Event)e;
		SalesRepInfoManageBC command = new SalesRepInfoManageBCImpl();
		PartnerBC ccdCommand = new PartnerBCImpl();
		BookingMasterMgtBC bkgMgtCommand = new BookingMasterMgtBCImpl();
		try{
			begin();
			CustomsCustomerVO customsCustomerVO = event.getCustomsCustomerVO();
			command.manageCustSRep(customsCustomerVO,account,event.getKey());
			if("Y".equals(customsCustomerVO.getSrepPrmryFlg())){
				ccdCommand.manageSrepByCust(event.getCustomsCustomerVO(), account);
			}
			if("".equals(event.getKey())){
				BkgSalesRepVO[] bkgSalesRepVOs = event.getBkgSalesRepVOS();
				bkgSalesRepVOs[0].setOpCd("I");
				bkgSalesRepVOs[0].setDeltFlg("N");
				bkgMgtCommand.manageSalesRep(bkgSalesRepVOs, account);
			}
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0001 : Retrieve<br>
	 * Customer 정보 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0001Event event = (EsmSam0001Event)e;
		CustomerInfoManageBC command = new CustomerInfoManageBCImpl();

		try{
			List<SearchCustomerVO> list = command.searchCustomerList(event.getSearchCustomerVO());
			eventResponse.setRsVoList(list);
			
			if(list.size() > 0){
				eventResponse.setETCData("cust_total",list.get(0).getCustTotal()); 
			}
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	/**
	 * ESM_SAM_0002 :Retrieve<br>
	 * Basic Info, KeyMan을 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchCustomerInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmSam0002Event event = (EsmSam0002Event)e;
			CustomerInfoManageBC command = new CustomerInfoManageBCImpl();
			String customerCode = null;
			
			List<SearchCustomerVO> list = null;
			List<SearchKeyManVO> list2 = null;
			
			try{
				customerCode = event.getSearchCustomerVO().getCustCd();
			
				list = command.searchCustomerInfo(event.getSearchCustomerVO ());
				list2 = command.searchKeyManList(customerCode);
				eventResponse.setRsVoList(list2);

			if(list.size()>0) {	
				eventResponse.setETCData("cust_lgl_eng_nm",list.get(0).getCustLglEngNm());
				eventResponse.setETCData("ofc_cd",list.get(0).getOfcCd());
				eventResponse.setETCData("cust_sts_cd",list.get(0).getCustStsCd());
				eventResponse.setETCData("srep_cd",list.get(0).getSrepCd());
				eventResponse.setETCData("cntr_cust_tp_cd",list.get(0).getCntrCustTpCd());	
				eventResponse.setETCData("indiv_corp_div_cd",list.get(0).getIndivCorpDivCd());
				eventResponse.setETCData("loc_cd",list.get(0).getLocCd());
				eventResponse.setETCData("cust_rgst_no",list.get(0).getCustRgstNo());
				eventResponse.setETCData("key_acct_flg",list.get(0).getKeyAcctFlg());
				eventResponse.setETCData("cust_grp_id",list.get(0).getCustGrpId());
				eventResponse.setETCData("mlt_trd_acct_flg",list.get(0).getMltTrdAcctFlg());
				eventResponse.setETCData("cre_usr_id",list.get(0).getCreUsrId());
				eventResponse.setETCData("ofc_eng_nm",list.get(0).getOfcEngNm());
				eventResponse.setETCData("srep_nm",list.get(0).getSrepNm());
				eventResponse.setETCData("phn_no",list.get(0).getPhnNo());
				eventResponse.setETCData("fax_no",list.get(0).getFaxNo());
				eventResponse.setETCData("cust_eml",list.get(0).getCustEml());
				eventResponse.setETCData("bzet_addr",list.get(0).getBzetAddr());
				eventResponse.setETCData("usr_nm",list.get(0).getUsrNm());
	        	eventResponse.setETCData("cre_ofc_cd",list.get(0).getCreOfcCd());
	        	eventResponse.setETCData("cts_no",list.get(0).getCtsNo());
	        	eventResponse.setETCData("intl_phn_no",list.get(0).getIntlPhnNo());
	        	eventResponse.setETCData("intl_fax_no",list.get(0).getIntlFaxNo());
	        	eventResponse.setETCData("cust_grp_nm",list.get(0).getCustGrpNm());
	        	
			}
			
			
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}	
			return eventResponse;
	}

	/**
	 * ESM_SAM_0002 :Retrieve<br>
	 * Address 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchAddressList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmSam0002Event event = (EsmSam0002Event)e;
			CustomerInfoManageBC command = new CustomerInfoManageBCImpl();
			List<MdmCustAddrVO> list = null;
			

			try{
				list = command.searchAddressList(event.getSearchCustomerVO ());
				eventResponse.setRsVoList(list);
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}	
			return eventResponse;
	}
	
	/**
	 * ESM_SAM_0002 :Retrieve<br>
	 * Preference&Needs 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerPreferenceInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmSam0002Event event = (EsmSam0002Event)e;
			CustomerInfoManageBC command = new CustomerInfoManageBCImpl();
			List<SamCustPreInfoVO> list = null;
			

			try{
				list = command.searchCustomerPreferenceInfo(event.getSearchCustomerVO ());
				eventResponse.setRsVoList(list);
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}	
			return eventResponse;
	}
	
	/**
	 * ESM_SAM_0002 :Retrieve<br>
	 * Coverage Team 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustCoverList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmSam0002Event event = (EsmSam0002Event)e;
			CustomerInfoManageBC command = new CustomerInfoManageBCImpl();
			List<CustCoverTeamVO> list = null;
			

			try{
				list = command.searchCustCoverList(event.getSearchCustomerVO ());
				eventResponse.setRsVoList(list);
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}	
			return eventResponse;
	}
	
	/**
	 * ESM_SAM_0002 :Retrieve<br>
	 * Activity 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustActvityList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmSam0002Event event = (EsmSam0002Event)e;
			CustomerInfoManageBC command = new CustomerInfoManageBCImpl();
			List<SamActivityInfoVO> list = null;
			

			try{
				list = command.searchCustActvityList(event.getSearchCustomerVO ());
				eventResponse.setRsVoList(list);
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}	
			return eventResponse;
	}
	
	/**
	 * ESM_SAM_0002 :Retrieve<br>
	 * MoreInfo 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchMoreInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmSam0002Event event = (EsmSam0002Event)e;
			CustomerInfoManageBC command = new CustomerInfoManageBCImpl();
			List<MoreInfoVO> list = null;
			

			try{
				list = command.searchMoreInfo(event.getSearchCustomerVO ());
				if(list.size()>0){
					eventResponse.setETCData("nvocc_co_scac_cd",list.get(0).getNvoccCoScacCd());
					eventResponse.setETCData("nvocc_lic_no",list.get(0).getNvoccLicNo());
					eventResponse.setETCData("nvocc_bd_no",list.get(0).getNvoccBdNo());
					eventResponse.setETCData("nvocc_bd_amt",list.get(0).getNvoccBdAmt());
					eventResponse.setETCData("nvocc_bd_st_eff_dt",list.get(0).getNvoccBdStEffDt());
					eventResponse.setETCData("nvocc_bd_end_eff_dt",list.get(0).getNvoccBdEndEffDt());
					eventResponse.setETCData("cr_amt",list.get(0).getCrAmt());
					eventResponse.setETCData("cr_clt_ofc_cd",list.get(0).getCrCltOfcCd());
					eventResponse.setETCData("ib_cr_term_dys",list.get(0).getIbCrTermDys());
					eventResponse.setETCData("ob_cr_term_dys",list.get(0).getObCrTermDys());
					eventResponse.setETCData("indus_tp_n1st_desc",list.get(0).getIndusTpN1stDesc());
					eventResponse.setETCData("mjr_n1st_trd_cd",list.get(0).getMjrN1stTrdCd());
					eventResponse.setETCData("mjr_n2nd_trd_cd",list.get(0).getMjrN2ndTrdCd());
					eventResponse.setETCData("indus_tp_n2nd_desc",list.get(0).getIndusTpN2ndDesc());
					eventResponse.setETCData("prf_n1st_rep_cmdt_cd",list.get(0).getPrfN1stRepCmdtCd());
					eventResponse.setETCData("prf_n1st_cmdt_grp_dtl",list.get(0).getPrfN1stCmdtGrpDtl());
					eventResponse.setETCData("cmpt_desc",list.get(0).getCmptDesc());
					eventResponse.setETCData("prf_n2nd_rep_cmdt_cd",list.get(0).getPrfN2ndRepCmdtCd());
					eventResponse.setETCData("prf_n2nd_cmdt_grp_dtl",list.get(0).getPrfN2ndCmdtGrpDtl());
					eventResponse.setETCData("spcl_req_desc",list.get(0).getSpclReqDesc());
					eventResponse.setETCData("cust_rmk",list.get(0).getCustRmk());
					eventResponse.setETCData("prf_cntr_tpsz_cd",list.get(0).getPrfCntrTpszCd());
		        	eventResponse.setETCData("yry_vol_qty",list.get(0).getYryVolQty());
					eventResponse.setETCData("cust_sla_flg",list.get(0).getCustSlaFlg());
					eventResponse.setETCData("bkg_alt_rsn",list.get(0).getBkgAltRsn());
					eventResponse.setETCData("cust_url",list.get(0).getCustUrl());
					eventResponse.setETCData("bkg_alt_msg",list.get(0).getBkgAltMsg());
					eventResponse.setETCData("bkg_alt_fm_dt",list.get(0).getBkgAltFmDt());
		        	eventResponse.setETCData("bkg_alt_to_dt",list.get(0).getBkgAltToDt());
		        	
		        	eventResponse.setRsVoList(list);
		       } 	
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}	
			return eventResponse;
	}
	
	/**
	 * ESM_SAM_0002 :Retrieve<br>
	 * History 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustHistList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmSam0002Event event = (EsmSam0002Event)e;
			CustomerInfoManageBC command = new CustomerInfoManageBCImpl();
			List<SamCustHistVO> list = null;
			

			try{
				list = command.searchCustHistList(event.getSearchCustomerVO ());
				eventResponse.setRsVoList(list);
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}	
			return eventResponse;
	}
	/**
	 * ESM_SAM_0010 :Retrieve<br>
	 * MDM_CUSTOMER 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerCodeGrouping(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmSam0010Event event = (EsmSam0010Event)e;
			CustomerInfoManageBC command = new CustomerInfoManageBCImpl();
			List<SearchCustomerCodeGroupingVO> list = null;
			

			try{
				//list = command.searchCustHistList(event.getSearchCustomerVO ());
				list = command.searchCustomerCodeGrouping(event.getSearchCustomerCodeGroupingVO ());
				eventResponse.setRsVoList(list);
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}	
			return eventResponse;
	}	
	/**
	 * ESM_SAM_0903 :Retrieve<br>
	 * MDM_CUST_PERF_GRP , MDM_CUSTOMER 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerGroupCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CustomerInfoManageBC command = new CustomerInfoManageBCImpl();
			List<CustomerGroupCodeVO> list = null;

			CustomerGroupCodeVO paramVo = new CustomerGroupCodeVO();
	  		if(e instanceof EsmSam0903Event){
				EsmSam0903Event event = (EsmSam0903Event)e;
				paramVo = event.getCustomerGroupCodeVO ();
			}else if(e instanceof EsmSam0011Event){
				EsmSam0011Event event = (EsmSam0011Event)e;
				paramVo = event.getCustomerGroupCodeVO ();
			}			
			
			try{
				list = command.searchCustomerGroupCode(paramVo);
				eventResponse.setRsVoList(list);
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}	
			return eventResponse;
	}
	/**
	 * ESM_SAM_0002 :Retrieve<br>
	 * Basic Info, KeyMan을 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	
	private EventResponse checkCustCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmSam0002Event event = (EsmSam0002Event)e;
			SalesAdminCommonBC command = new SalesAdminCommonBCImpl();
			String custCd = null;
			
			String cust_cd = null;
			
			try{
				custCd = event.getSearchCustomerVO().getCustCd();
				cust_cd = command.checkCustomerCode(custCd);
				eventResponse.setETCData("cust_cd",cust_cd);
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}
			return eventResponse;
	}
	
	/**
	 * ESM_SAM_0002 :Retrieve<br>
	 * More Info 커스토머 코드 존재 유무 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	
	private EventResponse checkCrCustCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmSam0002Event event = (EsmSam0002Event)e;
			SalesAdminCommonBC command = new SalesAdminCommonBCImpl();
			String custCd = null;
			
			String cust_cd = null;
			
			try{
				custCd = event.getSearchCustomerVO().getCustCd();
				cust_cd = command.checkCrCustomerCode(custCd);
				eventResponse.setETCData("cust_cd",cust_cd);
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}
			return eventResponse;
	}
	
	/**
	 * ESM_SAM_0002 :Retrieve<br>
	 * More Info 커스토머 코드 존재 유무 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	
	private EventResponse checkCntcCustCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmSam0002Event event = (EsmSam0002Event)e;
			SalesAdminCommonBC command = new SalesAdminCommonBCImpl();
			String custCd = null;
			
			String cust_cd = null;
			
			try{
				custCd = event.getSearchCustomerVO().getCustCd();
				cust_cd = command.checkCntcCustomerCode(custCd);
				eventResponse.setETCData("cust_cd",cust_cd);
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}
			return eventResponse;
	}

	
	/**
	 * ESM_SAM_0002 :Retrieve<br>
	 * Coverage Team Srep Code 존재 유무 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	
	private EventResponse checkSalesRepCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmSam0002Event event = (EsmSam0002Event)e;
			SalesAdminCommonBC comCommand = new SalesAdminCommonBCImpl();
			CustomerInfoManageBC samCommand = new CustomerInfoManageBCImpl();
			
			String srepCd = null;
			String custCd = null;
			String srep_cd_for_mdm = null;
			String srep_cd_for_sam = null;
			
			
			try{
				srepCd = event.getCustCoverTeamVO().getChkSrepCd();
				custCd = event.getCustCoverTeamVO().getCustCd();
				
				
				srep_cd_for_mdm = comCommand.checkSalesRepCode(srepCd);
				srep_cd_for_sam = samCommand.checkSalesRepCode(custCd, srepCd );
				eventResponse.setETCData("srep_cd_for_mdm",srep_cd_for_mdm);
				eventResponse.setETCData("srep_cd_for_sam",srep_cd_for_sam);
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}
			return eventResponse;
	}

	/**
	 * ESM_SAM_0002 :Retrieve<br>
	 * 사용자 권한 체크, Srep Cd 존재 유무 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	
	private EventResponse checkPermission(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmSam0002Event event = (EsmSam0002Event)e;
			CustomerInfoManageBC Command = new CustomerInfoManageBCImpl();
			
						
			try{
				String srep_cd_for_samPermission = null;
				srep_cd_for_samPermission = Command.checkPermission(event.getSearchCustomerVO (), account);
				eventResponse.setETCData("srep_cd_for_samPermission",srep_cd_for_samPermission);
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}
			return eventResponse;
	}
	
	/**
	 * ESM_SAM_0002 :Retrieve<br>
	 * 사용자 권한 체크, Cmdt Cd 존재 유무 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	
	private EventResponse checkCmdtCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmSam0002Event event = (EsmSam0002Event)e;
			CommodityBC Command = new CommodityBCImpl();
			List<MoreInfoVO> list = null;
						
			try{
				//String srep_cd_for_samPermission = null;
				list = Command.checkCmdtCd(event.getMoreInfoVO ());
				if (list.size()>0){
				eventResponse.setETCData("prf_n1st_rep_cmdt_cd", list.get(0).getPrfN1stRepCmdtCd());
				eventResponse.setETCData("prf_n1st_cmdt_grp_dtl", list.get(0).getPrfN1stCmdtGrpDtl());
				}
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}
			return eventResponse;
	}
	
	/**
	 * ESM_SAM_0002 :Save<br>
	 * Basic Info 저장<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	
	private EventResponse manageCustomerInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0002Event event = (EsmSam0002Event)e;
		CustomerInfoManageBC command = new CustomerInfoManageBCImpl();
		PartnerBC command2 = new PartnerBCImpl();
		
		List<SearchCustomerVO> oldList = null;
		List<SearchCustomerVO> newList = null;
		
		try {
				begin();

				oldList = command.searchCustomerInfo(event.getSearchCustomerVO ());

				command2.manageCustomerInfo(event.getSearchCustomerVOS(), account);
				newList = command.searchCustomerInfo(event.getSearchCustomerVO ());
				if (oldList.size()>0){
				command.manageCustHistList(event.getSamCustHistVO(), account, oldList, newList);
				}
				commit();
			} catch (EventException ex) {
				rollback();
				log.error("err " + ex.toString(), ex);
				throw ex;
			} catch (Exception ex) {
				rollback();
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}
			
			return eventResponse;
		}
	/**
	 * ESM_SAM_0010 :Save<br>
	 * Basic Info 저장<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	
	private EventResponse manageCustomerInfo0010(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0010Event event = (EsmSam0010Event)e;
		//CustomerInfoManageBC command = new CustomerInfoManageBCImpl();
		PartnerBC command2 = new PartnerBCImpl();
		
		//List<SearchCustomerVO> oldList = null;
		//List<SearchCustomerVO> newList = null;
		
		try {
				begin();

				//oldList = command.searchCustomerInfo(event.getSearchCustomerVO ());
				command2.manageCustomerInfo(event.getSearchCustomerVOS(), account);
				//newList = command.searchCustomerInfo(event.getSearchCustomerVO ());
				//if (oldList.size()>0){
				//command.manageCustHistList(event.getSamCustHistVO(), account, oldList, newList);
				//}
				commit();
			} catch (EventException ex) {
				rollback();
				log.error("err " + ex.toString(), ex);
				throw ex;
			} catch (Exception ex) {
				rollback();
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}
			
			return eventResponse;
		}
	
	/**
	 * ESM_SAM_0002 :Save<br>
	 * AddrressInfo 저장<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	
	private EventResponse manageCustomerAddressInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0002Event event = (EsmSam0002Event)e;

		PartnerBC command = new PartnerBCImpl();
		ArrivalNoticeBCImpl bkgcommand = new ArrivalNoticeBCImpl();

		try {
            	List<MdmCustomerVO> mdmCustomerVOs = new ArrayList<MdmCustomerVO>();
				CustomerAddressVO[] custAddrVOs = event.getCustomerAddressVOs();
				MdmCustomerVO[] customerVOs = event.getMdmCustomerVOs();
				
				for(int i = 0; i < custAddrVOs.length; i++){				
					if("1".equals(custAddrVOs[i].getAddrTpCd()) && "Y".equals(custAddrVOs[i].getPrmryChkFlg())){
						customerVOs[i].setCreUsrId(account.getUsr_id());
			        	customerVOs[i].setUpdUsrId(account.getUsr_id());
			        	customerVOs[i].setCustCntCd(custAddrVOs[i].getCustCntCd());
			        	customerVOs[i].setCustSeq(custAddrVOs[i].getCustSeq());
			        	customerVOs[i].setCustLglEngNm(custAddrVOs[i].getBzetNm());
			        	mdmCustomerVOs.add(customerVOs[i]);
					}
				}
			
				begin();			
	            command.manageCustAddrCode(event.getCustomerAddressVOs(), account);    
	            bkgcommand.mergeBkgCustCdVal(mdmCustomerVOs);	 
				commit();
			} catch (EventException ex) {
				rollback();
				log.error("err " + ex.toString(), ex);
				throw ex;
			} catch (Exception ex) {
				rollback();
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}
			
			
		return eventResponse;	
		}
	
	/**
	 * ESM_SAM_0002 :Save<br>
	 * Preference&Needs 저장<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	
	private EventResponse manageCustomerPreferenceInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0002Event event = (EsmSam0002Event)e;
		CustomerInfoManageBC command = new CustomerInfoManageBCImpl();
		//String cd = event.getCustomerCode();
		try {
				begin();
				command.manageCustomerPreferenceInfo(event.getSamCustPreInfoVOS(), account);
				commit();
			} catch (EventException ex) {
				rollback();
				log.error("err " + ex.toString(), ex);
				throw ex;
			} catch (Exception ex) {
				rollback();
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}
			return eventResponse;	
		}

	/**
	 * ESM_SAM_0002 :Save<br>
	 * Coverage Team 저장<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	
	private EventResponse manageCustCoverInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0002Event event = (EsmSam0002Event)e;
		CustomerInfoManageBC samCommand = new CustomerInfoManageBCImpl();
		PartnerBC ccdCommand = new PartnerBCImpl();
		BookingMasterMgtBC bkgCommand = new BookingMasterMgtBCImpl();
		
		try {
				begin();
				CustCoverTeamVO[] CustCoverTeamVOS = event.getCustCoverTeamVOS();
				ccdCommand.manageCustCoverInfo(CustCoverTeamVOS , account);				
				samCommand.manageCustCoverInfo(event.getCustCoverTeamVOS(), account);
				bkgCommand.manageSalesRep(event.getBkgSalesRepVOS(), account);
				commit();
			} catch (EventException ex) {
				rollback();
				log.error("err " + ex.toString(), ex);
				throw ex;
			} catch (Exception ex) {
				rollback();
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}
			return eventResponse;
		}
	
	/**
	 * ESM_SAM_0002 :Save<br>
	 * MoreInfo 저장<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	
	private EventResponse manageMoreInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0002Event event = (EsmSam0002Event)e;
		CustomerInfoManageBC command = new CustomerInfoManageBCImpl();
		PartnerBC command2 = new PartnerBCImpl();
		try {
				begin();
				command.manageMoreInfo(event.getMoreInfoVOS(), account);
				command2.manageMoreInfo(event.getMoreInfoVOS(), account);
				commit();
			} catch (EventException ex) {
				rollback();
				log.error("err " + ex.toString(), ex);
				throw ex;
			} catch (Exception ex) {
				rollback();
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}
		return eventResponse;
	}
	
	/** ESM_SAM_0004<br>
	 * PGroup Customer Name/Description 조회<br>
	 * On_change
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCustomerName(Event e) throws EventException
	{

		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0004Event event = (EsmSam0004Event)e;
		CustomerInfoManageBC command = new CustomerInfoManageBCImpl();
		
		try {				
			String repInfo = command.searchGroupCustomerName(event.getSearchCustomerVO());
			if(repInfo != null){
			String[] repInfoData = repInfo.split("\t");
			eventResponse.setETCData("cust_grp_nm", repInfoData[0]);
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
		}

	/** ESM_SAM_0004 <br>
	 * Customer PFMC Group Detail를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerPFMCGroupDetail(Event e) throws EventException
	{

		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0004Event event = (EsmSam0004Event)e;
		CustomerInfoManageBC command = new CustomerInfoManageBCImpl();

		try {				
			List<SearchCustomerVO> list = command.searchCustomerPFMCGroupDetail(event.getSearchCustomerVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
		}
	
	/** ESM_SAM_0003 <br>
	 * KeyManInfo를 조회합니다.<br>
	 * 시트조회
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchKeyManInfo(Event e) throws EventException
	{

		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0003Event event = (EsmSam0003Event)e;
		KeyManInfoManageBC command = new KeyManInfoManageBCImpl();

		try {		
			List<SearchCustomerVO> list = command.searchKeyManInfo(event.getSearchCustomerVO());
			
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
		}

	/** ESM_SAM_0003 <br>
	 * KeyManDetailInfo 조회합니다.<br>
	 * 폼조회
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchKeyManDetailInfo(Event e) throws EventException
	{

		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0003Event event = (EsmSam0003Event)e;
		KeyManInfoManageBC command = new KeyManInfoManageBCImpl();

		try {				

			List<SamKeyManInfoVO> list = command.searchKeyManDetailInfo(event.getSamKeyManInfoVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
		}

	/**
	 * ESM_SAM_0003 : SAVE <br>
	 * KeyManDetailInfo를 저장합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse manageKeyManInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0003Event event = (EsmSam0003Event)e;
		KeyManInfoManageBC command = new KeyManInfoManageBCImpl();

		try{
			begin();
			SamKeyManInfoVO samKeyManInfoVO = event.getSamKeyManInfoVO();
			samKeyManInfoVO.setUsrId(account.getUsr_id());
			command.manageKeyManInfo(samKeyManInfoVO);
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0003 : DELETE <br>
	 * KeyManDetailInfo를 삭제합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse deleteKeyManInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
				GeneralEventResponse eventResponse = new GeneralEventResponse();
				EsmSam0003Event event = (EsmSam0003Event)e;
				KeyManInfoManageBC command = new KeyManInfoManageBCImpl();

				try{
					begin();
					for(int i=0; i<event.getSamKeyManInfoVOs().length; i++){
				    	event.getSamKeyManInfoVOs()[i].setUsrId(account.getUsr_id());
					}
					command.deleteKeyManInfo(event.getSamKeyManInfoVOs()); 
					commit();
				} catch (EventException ex) {
					rollback();
					throw new EventException(new ErrorHandler(ex).getMessage(), ex);
				} catch (Exception ex) {
					rollback();
					throw new EventException(new ErrorHandler(ex).getMessage(), ex);
				}
				return eventResponse;
			}
	
	/** ESM_SAM_0003 [ADD] ESM_SAM_0902 SHKIM 0215<br>
	 * Customer Name 조회<br>
	 * 시트CUSTOMER정보
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerName(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SalesAdminCommonBC command = new SalesAdminCommonBCImpl();
		String custCdNm = null;
		
		try {
			if(e instanceof EsmSam0003Event){
				EsmSam0003Event event = (EsmSam0003Event)e;

				SamKeyManInfoVO samKeyManInfoVO = event.getSamKeyManInfoVO();
				custCdNm = samKeyManInfoVO.getCustCd();
			}
			
			if(custCdNm != null) {
				String repInfo = command.checkCustCodeName(custCdNm);
				if(!repInfo.equals("")){
					String[] repInfoData = repInfo.split("@@@");
					eventResponse.setETCData("cust_cd", repInfoData[0]);
					eventResponse.setETCData("cust_nm", repInfoData[1]);
				}
			}
		}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}	
			return eventResponse;
		}
	
	
	/**
	 * ESM_SAM_0005 : OFC_CD onChange<br>
	 * OFC_CD를 확인합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse checkOfcCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SalesAdminCommonBC command = new SalesAdminCommonBCImpl();
		String ofcCd = null;
		
		if(e instanceof EsmSam0005Event){
			EsmSam0005Event event = (EsmSam0005Event)e;
			ofcCd = event.getHiddenOfcCd();
		}else if(e instanceof EsmSam0001Event){
			EsmSam0001Event event = (EsmSam0001Event)e;
			ofcCd = event.getCreOfcCd();
		}
	
		if(ofcCd != null) {
			try{
				String result = command.checkOfficeCd(ofcCd);
				eventResponse.setETCData("result", result);
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}	
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0005 : CUST_CD onChange<br>
	 * CUST_CD를 확인합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse checkCustCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SalesAdminCommonBC command = new SalesAdminCommonBCImpl();
		String ofcCd = null;
		
		if(e instanceof EsmSam0005Event){
			EsmSam0005Event event = (EsmSam0005Event)e;
			ofcCd = event.getHiddenOfcCd();
		
		}
		
		if(ofcCd != null) {
			try{
				String result = command.checkCustomerCode(ofcCd);
				eventResponse.setETCData("result", result);
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}
		}
		
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0001 : SREP_CD onChange<br>
	 * SREP_CD를 확인합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse checkSlsRepCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SalesAdminCommonBC command = new SalesAdminCommonBCImpl();
		String sRepCd = null;
		
		if(e instanceof EsmSam0001Event){
			EsmSam0001Event event = (EsmSam0001Event)e;
			sRepCd = event.getCreOfcCd();
		}
		
		if(sRepCd != null) {
			try{
				String result = command.checkSalesRepCode(sRepCd);
				eventResponse.setETCData("result", result);
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}	
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0001 : LOC_CD onChange<br>
	 * LOC_CD를 확인합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse checkLocCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SalesAdminCommonBC command = new SalesAdminCommonBCImpl();
		String locCd = null;
		
		if(e instanceof EsmSam0001Event){
			EsmSam0001Event event = (EsmSam0001Event)e;
			locCd = event.getCreOfcCd();
		}else if(e instanceof EsmSam0002Event){
			EsmSam0002Event event = (EsmSam0002Event)e;
			locCd = event.getCheck_String();	
		}
	
		if(locCd != null) {
			try{
				String result = command.checkLocCode(locCd);
				eventResponse.setETCData("result", result);
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}	
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0002 : Vendor onChange<br>
	 * Vendor Code를 확인합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse checkVndrCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CcdCommonBC command = new CcdCommonBCImpl();
		String vndrCd = null;
		
		if(e instanceof EsmSam0002Event){
			EsmSam0002Event event = (EsmSam0002Event)e;
			vndrCd = event.getCheck_String();	
		}
		if(vndrCd != null) {
			try{
				String result = command.checkVndrCode(vndrCd);
				eventResponse.setETCData("result", result);
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}	
		}
				
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0002 : Country onChange<br>
	 * Country를 확인합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse checkCntCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CcdCommonBC command = new CcdCommonBCImpl();
		String cntCd = null;
		if(e instanceof EsmSam0002Event){
			EsmSam0002Event event = (EsmSam0002Event)e;
			cntCd = event.getCheck_String();	
		}
		if(cntCd != null) {
			try{
				String result = command.checkCntCode(cntCd);
				eventResponse.setETCData("result", result);
			}catch(EventException ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}	
		}
		return eventResponse;
	}
	
	/**
	 * ESM_SAM_0002 : State onChange<br>
	 * State를 확인합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse checkStateCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CcdCommonBC command = new CcdCommonBCImpl();
		String steCd = null;
		if(e instanceof EsmSam0002Event){
			EsmSam0002Event event = (EsmSam0002Event)e;
			steCd = event.getCheck_String();
		}
		if(steCd != null) {
			try{
				String result = command.checkStateCode(steCd);
				eventResponse.setETCData("result", result);
			}catch(Exception ex){
				throw new EventException(new ErrorHandler(ex).getMessage(),ex);
			}	
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_SAM_0011 : Retrieve<br>
	 * Group Code에 해당하는 Customer Detail 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */	
 	private EventResponse searchCustomerGroupCodeDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0011Event event = (EsmSam0011Event)e;
		CustomerInfoManageBC command = new CustomerInfoManageBCImpl();
		
		try {
			List<CustomerGroupCodeVO> list = command.searchCustomerGroupCodeDetail(event.getCustomerGroupCodeVO ());
			eventResponse.setRsVoList(list);          
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
 	
	/**
	 * ESM_SAM_0001 :Save<br>
	 * Basic Info 저장<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	
	private EventResponse manageSalesRepAdjustment(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0001Event event = (EsmSam0001Event)e;
		CustomerInfoManageBC samCommand = new CustomerInfoManageBCImpl();
		PartnerBC ccdCommand = new PartnerBCImpl();
		BookingMasterMgtBC bkgCommand = new BookingMasterMgtBCImpl();
		
		try {
				begin();
				SearchCustomerVO[] searchCustomerVOs = event.getSearchCustomerVOS();
				CustCoverTeamVO[] custCoverTeamVOs = event.getCustCoverTeamVOs();
				int resultCnt = 0;
				String salesRep = "";
				String custCd = "";
	
				for(int i=0; i<searchCustomerVOs.length; i++){
					salesRep = samCommand.checkPrmrySalesRep(searchCustomerVOs[i]);
					if(salesRep.equals(searchCustomerVOs[i].getSrepCd())){
						resultCnt ++;
					}
					if(resultCnt>0){
						custCd = searchCustomerVOs[i].getCustCd();
						break;
					}
				}
				if(resultCnt<1){
					// 2015-03-27 CHLOE : MDM 끊을 예정임				
					// CCD Master Table에 반영 
					ccdCommand.manageCustCoverInfo(custCoverTeamVOs , account); 

					BkgSalesRepVO  iBkgSalesRepVO = null;
					BkgSalesRepVO  dBkgSalesRepVO = null;
					List<BkgSalesRepVO> insertVoList     = new ArrayList<BkgSalesRepVO>();
					List<BkgSalesRepVO> deleteVoList     = new ArrayList<BkgSalesRepVO>();	
					
					// BKG_CUST_SLS_REP
					String srep_cd_for_sam = null;				
					for(int i=0; i<searchCustomerVOs.length; i++){					
						if(searchCustomerVOs[i].getIbflag().equals("U") && !searchCustomerVOs[i].getSalesRep().equals(searchCustomerVOs[i].getPreSrepCd())){
							iBkgSalesRepVO = new BkgSalesRepVO();
							srep_cd_for_sam = samCommand.checkSalesRepCode(searchCustomerVOs[i].getCustCntCd()+ searchCustomerVOs[i].getCustSeq(), searchCustomerVOs[i].getSrepCd() );
							if (srep_cd_for_sam.length() >0) {
								iBkgSalesRepVO.setOpCd("U");
							} else {	
								iBkgSalesRepVO.setOpCd("I");
							}						
							iBkgSalesRepVO.setDeltFlg("N");
							iBkgSalesRepVO.setCustCntCd(searchCustomerVOs[i].getCustCntCd());
							iBkgSalesRepVO.setCustSeq(searchCustomerVOs[i].getCustSeq());
							iBkgSalesRepVO.setSrepCd(searchCustomerVOs[i].getSrepCd());
							insertVoList.add(iBkgSalesRepVO);
							
							dBkgSalesRepVO = new BkgSalesRepVO();
							dBkgSalesRepVO.setOpCd("D");
							dBkgSalesRepVO.setDeltFlg("Y");
							dBkgSalesRepVO.setCustCntCd(searchCustomerVOs[i].getCustCntCd());
							dBkgSalesRepVO.setCustSeq(searchCustomerVOs[i].getCustSeq());
							dBkgSalesRepVO.setSrepCd(searchCustomerVOs[i].getPreSrepCd());
							deleteVoList.add(dBkgSalesRepVO);						
						}
					}

					bkgCommand.manageSalesRep((BkgSalesRepVO[])insertVoList.toArray(new BkgSalesRepVO[insertVoList.size()]),account);
					bkgCommand.manageSalesRep((BkgSalesRepVO[])deleteVoList.toArray(new BkgSalesRepVO[deleteVoList.size()]),account);
					
					// SAM_CUST_SLS_REP_INFO
					samCommand.manageSalesRepAdjustment(searchCustomerVOs, account);
					commit();
				}else{
					eventResponse.setETCData("result", "F");
					eventResponse.setETCData("custCd", custCd);
					eventResponse.setETCData("salesRep", salesRep);
				}
				
			} catch (EventException ex) {
				rollback();
				log.error("err " + ex.toString(), ex);
				throw ex;
			} catch (Exception ex) {
				rollback();
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}
			return eventResponse;
		}	 	
	
	/** ESM_SAM_0006 <br>
	 * S.Rep Code 별 데이타를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchSalesRepBySalesOffice(Event e) throws EventException
	{

		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmSam0001Event event = (EsmSam0001Event)e;
		SalesRepInfoManageBC command = new SalesRepInfoManageBCImpl();

		try {				
			List<SamCustSRepVO> list = command.searchSalesRepBySalesOffice(event.getCreOfcCd());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
}


