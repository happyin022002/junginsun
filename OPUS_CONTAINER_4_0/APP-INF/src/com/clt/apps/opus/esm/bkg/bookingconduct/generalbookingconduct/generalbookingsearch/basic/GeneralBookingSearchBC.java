/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingSearchBC.java
*@FileTitle : Transhipment Route and VVD
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.RefNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgReceiptSendVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgYardCdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ClzTmListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CntrChkDigitVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CntrInfoForEmptyVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CustomsHistVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.DocHistVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.HistMainVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.LocationListInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.LocationListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.MtyBkgTsRouteVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.NodeListInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.NodeListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.NoticeHistVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.PrdConstraintVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.QtyInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgForUpdateVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoCntrVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RfaCmdtListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RfaListInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RfaListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RollOvrInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RouteDtlVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ScCmdtListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ScListInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ScListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SearchActualCustomerVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SendBkgEdiVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SendBkgFaxEmailVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TSRouteVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TaaCmdtListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TaaListInputVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TaaListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.UsaCstmsFileListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Vender301ParamVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.YardAssignVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclReqInVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCreCustInqVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCreCustomerVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgBookingVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.MdmSvcScpVO;
import com.clt.syscommon.common.table.ScgAproRqstVO;

/**
 * OPUS-CreateCustBkgReceiptEdi Business Logic Basic Command implementation<br>
 * - OPUS-CreateCustBkgReceiptEdi에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Byung Kyu
 * @see GeneralBookingSearchBCImpl 클래스 참조
 * @since J2EE 1.6
 */
public interface GeneralBookingSearchBC {

	/**
	 * TS Route information retrieve
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String codRqstSeq
	 * @param 		String opCd
	 * @return 		List<TSRouteVO>
	 * @exception 	EventException
	 */
	public List<TSRouteVO> searchIbTsRoute(BkgBlNoVO bkgBlNoVO, String codRqstSeq, String opCd) throws EventException;

	/**
	 * Retrieve event handling of Customer Inquiry screen
	 * @param 		String custCntCd
	 * @param 		String custSeq
	 * @param 		String custNm
	 * @param 		String locCd
	 * @param 		String ofcCd
	 * @return 		BkgCreCustInqVO
	 * @exception 	EventException
	 */
	public BkgCreCustInqVO searchBkgCreCustCntc(	String custCntCd,
																				String custSeq,
																				String custNm,
																				String locCd,
																				String ofcCd) throws EventException;
	/**
	 * event handling in case of clicking Customer list of Customer Inquiry screen
	 * @param 		String custCntCd
	 * @param 		String custSeq
	 * @return 		BkgCreCustInqVO
	 * @exception 	EventException
	 */
	public BkgCreCustInqVO searchCustContact(String custCntCd ,String custSeq) throws EventException;

	/**
	 *  Service Mode & Route information retrieve<br>
	 * @param 		bkgBlNoVO   BkgBlNoVO
	 * @return 		BkgBookingVO
	 * @exception 	EventException
	 */
	public BkgBookingVO searchSvcRouteMode(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 *  Black Stowage Flag retrieve<br>
	 * @param 		bkgBookingVO   BkgBookingVO
	 * @return 		BkgBookingVO
	 * @exception 	EventException
	 */
	public BkgBookingVO searchBlckStwgFlg(BkgBookingVO bkgBookingVO) throws EventException;

	/**
	 *  Black Stowage Code update<br>
	 * @param 		bkgBookingVO   BkgBookingVO
	 * @param		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void manageBlckStwgCd(BkgBookingVO bkgBookingVO, SignOnUserAccount account) throws EventException;

	/**
	 * Constraint retrieve<br>
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		List<PrdConstraintVO>
	 * @exception 	EventException
	 */
	public List<PrdConstraintVO> searchConstraint(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * Node Search retrieve<br>
	 * @param 		NodeListInputVO nodeListInputVO
	 * @return 		List<NodeListVO>
	 * @exception 	EventException
	 */
	public List<NodeListVO> searchNodeCode(NodeListInputVO nodeListInputVO) throws EventException;

	/**
	 * Location List retrieve<br>
	 * @param 		LocationListInputVO locationListInputVO
	 * @return 		List<LocationListVO>
	 * @exception 	EventException
	 */
	public List<LocationListVO> searchLocationList(LocationListInputVO locationListInputVO) throws EventException;
	
	/**
	 * Reference Number information retrieve<br>
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		List<RefNoVO>
	 * @exception 	EventException
	 */
	public List<RefNoVO> searchBkgReference(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * Reference Number information retrieve<br>
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		List<RefNoVO>
	 * @exception 	EventException
	 */
	public String searchManualYn(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * Direct NVO-AMS File No retrieve<br>
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		UsaCstmsFileListVO
	 * @exception 	EventException
	 */
	public UsaCstmsFileListVO searchNVOFileNumberList(BkgBlNoVO bkgBlNoVO) throws EventException;


	/**
	 * retrieve cct information of the booking
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @return ClzTmListVO
	 * @throws EventException
	 */
	public ClzTmListVO searchCargoClosingTime(BkgBlNoVO bkgBlNoVO,SignOnUserAccount account) throws EventException;

	/**
	 * Customer Code retrieve
	 * @param SearchActualCustomerVO searchActualCustomerVO
	 * @return List<SearchActualCustomerVO>
	 * @exception EventException
	 */
	public List<SearchActualCustomerVO> searchActualCustomer(SearchActualCustomerVO searchActualCustomerVO) throws EventException;

	/**
	 * retrieve Container No List belonging to the Empty Repo Bkg(ESM_BKG_9450)
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		List<CntrInfoForEmptyVO>
	 * @exception EventException
	 */
	public List<CntrInfoForEmptyVO> searchEmptyCntrByBKG(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * retrieve Code and Name of all Service Scope
	 * @return 		List<MdmSvcScpVO>
	 * @exception 	EventException
	 */
	public List<MdmSvcScpVO> searchSvcScp() throws EventException;

	/**
	 * retrieve RFA on shipper's contract(ESM_BKG_0654)
	 * @param 		RfaListInputVO rfaListInputVO
	 * @return 		List<RfaListVO>
	 * @exception 	EventException
	 */
	public List<RfaListVO> searchRfaList(RfaListInputVO rfaListInputVO) throws EventException;
	
	/**
	 * retrieve S/C on shipper's contract(ESM_BKG_0655)
	 * @param 		ScListInputVO scListInputVO
	 * @return 		List<ScListVO>
	 * @exception 	EventException
	 */
	public List<ScListVO> searchScList(ScListInputVO scListInputVO) throws EventException;		
	
	/**
	 * retrieve TAA on shipper's contract(ESM_BKG_1062)
	 * @param 		TaaListInputVO taaListInputVO
	 * @return 		List<TaaListVO>
	 * @exception 	EventException
	 */
	public List<TaaListVO> searchTaaList(TaaListInputVO taaListInputVO) throws EventException;	
	
	/**
	 * retrieve Commodity on RFA's contract(ESM_BKG_0656)
	 * @param rfaListInputVO
	 * @param cmdtNm
	 * @param cmdtCd
	 * @param uiId
	 * @return
	 * @throws EventException
	 */
	public List<RfaCmdtListVO> searchCmdtByRfa(RfaListInputVO rfaListInputVO, String cmdtNm, String cmdtCd, String uiId) throws EventException;		

	/**
	 * retrieve Commodity on S/C's contract(ESM_BKG_0657)
	 * @param scListInputVO
	 * @param cmdtNm
	 * @param cmdtCd
	 * @param svcScpCd
	 * @param uiId
	 * @return
	 * @throws EventException
	 */
	public List<ScCmdtListVO> searchCmdtBySc(ScListInputVO scListInputVO, String cmdtNm, String cmdtCd,String svcScpCd, String uiId) throws EventException ;

	/**
	 * retrieve Commodity on TAA's contract(ESM_BKG_1078)
	 * @param 		TaaListInputVO taaListInputVO
	 * @param 		String cmdtNm
	 * @param 		String cmdtCd
	 * @return 		List<TaaCmdtListVO>
	 * @exception 	EventException
	 */
	public List<TaaCmdtListVO> searchCmdtByTaa(TaaListInputVO taaListInputVO, String cmdtNm, String cmdtCd) throws EventException;
	
	/**
	 * ESM_BKG_0566 : History retrieve<br>
	 * @param  bkgBlNoVO bkgBlNoVO
	 * @return HistMainVO
	 * @exception EventException
	 */
	public HistMainVO searchBlHist(BkgBlNoVO bkgBlNoVO) throws EventException;
		
	/**
	 * ESM_BKG_0566_02 : FAX/EDI History retrieve<br>
	 * @param  bkgBlNoVO bkgBlNoVO
	 * @return List<NoticeHistVO>
	 * @exception EventException
	 */
	public List<NoticeHistVO> searchNoticeHist(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 * ESM_BKG_0566_03 : Customs History retrieve<br>
	 * @param  bkgBlNoVO bkgBlNoVO
	 * @return List<CustomsHistVO>
	 * @exception EventException
	 */
	public List<CustomsHistVO> searchCustomsHist(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 * ESM_BKG_0566_04 : Documnents History retrieve<br>
	 * @param  bkgBlNoVO bkgBlNoVO
	 * @return List<DocHistVO>
	 * @exception EventException
	 */
	public List<DocHistVO> searchDocHist(BkgBlNoVO bkgBlNoVO) throws EventException;
	
	/**
	 * transmit 5005RD from Booking list by FAX(ESM_BKG_0098)
	 * @param BkgReceiptSendVO bkgReceiptSendVO
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendBkgReceiptByFax(BkgReceiptSendVO bkgReceiptSendVO, SignOnUserAccount account) throws EventException;

	/**
	 * transmit 5005RD from Booking list by mail(ESM_BKG_0098)
	 * @param BkgReceiptSendVO bkgReceiptSendVO
	 * @param SignOnUserAccount account
	 * @param String type
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendBkgReceiptByEmail(BkgReceiptSendVO bkgReceiptSendVO, SignOnUserAccount account, String type) throws EventException;

	/**
	 * transmit 5005RD from Booking list by Group mail
	 * @param BkgReceiptSendVO bkgReceiptSendVO
	 * @param SignOnUserAccount account
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendBkgReceiptByGroupEmail(BkgReceiptSendVO bkgReceiptSendVO, SignOnUserAccount account) throws EventException;

	/**
	 * retrieve bkg data, cntr data, VL container List of mty bkg update screen
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String bkgMvmtCd
	 * @return 		RepoBkgForUpdateVO
	 * @exception 	EventException
	 */
	public RepoBkgForUpdateVO searchEmptyBooking(BkgBlNoVO bkgBlNoVO, String bkgMvmtCd) throws EventException;	
	
	/**
	 * Container Digit,TpSz,Status Cd retrieve<br>
	 * @param  		String cntrNo
	 * @return 		CntrChkDigitVO
	 * @exception 	EventException
	 */
	public CntrChkDigitVO searchCntrChkDigit(String cntrNo) throws EventException;

	/**
	 *  create and transmit EDI information that will transmit to terminal, BackEndJob Handling
	 * 
	 * @author Kim Byung Kyu
	 * @param Vender301ParamVO vender301ParamVO
	 * @param SignOnUserAccount account 
	 * @return String
	 * @exception EventException
	 */
	public String createTmlBkgReceiptEdiBackEnd(Vender301ParamVO vender301ParamVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * create and transmit EDI information that will transmit to terminal(ESM_BKG_0702)
	 * @param Vender301ParamVO vender301ParamVO
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> createTmlBkgReceiptEdi(Vender301ParamVO vender301ParamVO, SignOnUserAccount account) throws EventException;

	/**
	 * create and transmit EDI information that will transmit to terminal(ESM_BKG_0616)
	 * @param Vender301ParamVO vender301ParamVO
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */

	public List<BkgNtcHisVO> createTmlBkgReceiptEdiBatch(Vender301ParamVO vender301ParamVO, SignOnUserAccount account) throws EventException;
	/**
	 * CreateCustBkgReceiptEdi BackEndJob handling
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param CustTpIdVO custTpIdVO
	 * @param String autoManualFlg
	 * @param SignOnUserAccount account 
	 * @return String
	 * @exception EventException
	 */
	public String createCustBkgReceiptEdiBackEnd(BkgBlNoVO bkgBlNoVO, CustTpIdVO custTpIdVO, String autoManualFlg, SignOnUserAccount account) throws EventException;
	
	/**
	 * create and transmit EDI information for Customer (ESM_BKG_0702)
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param CustTpIdVO custTpIdVO
	 * @param String autoManualFlg
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> createCustBkgReceiptEdi(BkgBlNoVO bkgBlNoVO, CustTpIdVO custTpIdVO, String autoManualFlg, SignOnUserAccount account) throws EventException;

	/**
	 * Stowage Plan retrieve
	 * @param 		String mvmtOption
	 * @param 		String vvd 
	 * @param 		String ydCd
	 * @return 		List<RepoCntrVO>
	 * @exception 	EventException
	 */
	public List<RepoCntrVO> searchMtyCntrList(String mvmtOption, String vvd, String ydCd) throws EventException;	
	/**
	 * retrieve T/S Route information of Empty Booking
	 * @param  		BkgBlNoVO bkgBlNoVO
	 * @return 		List<MtyBkgTsRouteVO>
	 * @exception 	EventException
	 */
	public List<MtyBkgTsRouteVO> searchEmptyBkgTsRoute(BkgBlNoVO bkgBlNoVO) throws EventException;	

	/**
	 * retrieve Container List of Empty Status in the Yard
	 * @param  		String vvd
	 * @param  		String ydCd
	 * @param  		String cntrTpsz
	 * @return 		List<RepoCntrVO>
	 * @exception 	EventException
	 */
	public List<RepoCntrVO> searchCntrByYard(String vvd, String ydCd, String cntrTpsz) throws EventException;	

	/**
	 * retrieve sent Fax/Email list(ESM_BKG_0095)<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @return List<SendBkgFaxEmailVO>
	 * @exception 	EventException
	 */
	public List<SendBkgFaxEmailVO> searchFaxEmailForNotice(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;

	/**
	 * retrieve sent EDI list(ESM_BKG_0095)<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return List<SendBkgEdiVO>
	 * @exception 	EventException
	 */
	public List<SendBkgEdiVO> searchEdiForNotice(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * Bkg Receipt Type retrieve(ESM_BKG_0095)<br>
	 * @param String usrId
	 * @return String 
	 * @exception 	EventException
	 */
	public String searchBkgReceiptType(String usrId) throws EventException;
	
	/**
	 * retrieve basis information for classification yard by  type / size when EDI transmits<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param QtyInfoVO qtyInfoVO
	 * @return YardAssignVO
	 * @exception EventException
	 */
	public YardAssignVO searchYardAssign( BkgBlNoVO bkgBlNoVO , QtyInfoVO qtyInfoVO ) throws EventException;
 
	/**
	 * Make sure the entered yard is in the mdm_yard.<br>
	 * @param QtyInfoVO[] qtyInfoVOs
	 * @exception EventException
	 */
	public void validateYardAssign(QtyInfoVO[] qtyInfoVOs ) throws EventException;
	
	/**
	 * retrieve event handling<br>
	 *  retrieve event handling about Route Detail screen
	 * @param bkgNo	
	 * @return awkCgoApplVO
	 * @exception EventException
	 */
	public RouteDtlVO searchRouteDetail(String bkgNo) throws EventException;
	
	/**
	 * transmit surrender notice, carrier haulage notice<br>	 
	 * @param String mrdNm
	 * @param String ntcKndCd	 
	 * @param String faxNo	 
	 * @param String param	 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendBkgNoticeByFax(String mrdNm, String ntcKndCd, String faxNo, String param, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException;

	/**
	 * transmit surrender notice, carrier haulage notice<br>	 
	 * @param String mrdNm	 
	 * @param String ntcKndCd
	 * @param String eml	 
	 * @param String param
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param BkgEmlEdtVO bkgEmlEdtVO
	 * @param SignOnUserAccount account 
	 * @return List<BkgNtcHisVO>
	 * @exception EventException
	 */
	public List<BkgNtcHisVO> sendBkgNoticeByEmail(String mrdNm, String ntcKndCd, String eml, String param, BkgBlNoVO bkgBlNoVO, BkgEmlEdtVO bkgEmlEdtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * retrieve which Tab will show among Booking Creation tab
	 * @param     SignOnUserAccount account
	 * @return    String 
	 * @exception EventException
	 */
	public String searchBkgCreTabByUser(SignOnUserAccount account) throws EventException;

	/**
	 * retrieve name and additional information when customer code changes at booking creation
	 * @param 		String custCntCd
	 * @param 		String custSeq
	 * @return 		BkgCreCustomerVO
	 * @exception 	EventException
	 */
	public BkgCreCustomerVO searchCustNm(	String custCntCd, String custSeq) throws EventException;

	/**
	 * retrieve bkg data for special cargo request again
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String rqstType
	 * @param		SignOnUserAccount account
	 * @return 		ScgAproRqstVO[]
	 * @exception 	EventException
	 */
	public ScgAproRqstVO[] searchBkgForSpclRqst(BkgBlNoVO bkgBlNoVO, String rqstType, SignOnUserAccount account) throws EventException;

	/**
	 * retrieve spcl cgo seq for special cargo request again
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		SpclReqInVO[]
	 * @exception 	EventException
	 */
	public SpclReqInVO[] searchSpclReqInVO(BkgBlNoVO bkgBlNoVO) throws EventException;


	/**
	 * if status is Upload when eBooking Doc Type is B, that is automatically transmission
	 * @param BkgBlNoVO[] bkgBlNoVO
	 * @param String[] emlAddr
	 * @param String[] remark
	 * @param String mrdNm
	 * @param String[] cct
	 * @param SignOnUserAccount account
	 * @param String title
	 * @param String Contents
	 * @param String vslNm
	 * @return List<BkgNtcHisVO>
	 * @throws EventException
	 */
	public List<BkgNtcHisVO> sendXterReceiptByEmail(BkgBlNoVO[] bkgBlNoVO, String[] emlAddr, String[] remark,String mrdNm, String[] cct, SignOnUserAccount account, String title, String Contents, String vslNm) throws EventException;
	
	/**
	 * 해당 booking의 roll over 정보를 조회<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return RollOvrInfoVO
	 * @exception EventException
	 */
	public RollOvrInfoVO searchRollOvr(BkgBlNoVO bkgBlNoVO) throws EventException;

	/**
	 * retrieve transmit EDI information that will transmit to terminal(ESM_BKG_0616)
	 * @param ediRefCd
	 * @param vvd
	 * @return
	 * @throws EventException
	 */
	public BkgBlNoVO[] searchBkgTmlEdiBatch(String ediRefCd, String vvd) throws EventException;
	
	/**
	 * retrieve transmit EDI information that will transmit to terminal(ESM_BKG_0616)
	 * @param String ediRefCd
	 * @return BkgBlNoVO[]
	 * @throws EventException
	 */
	public BkgBlNoVO[] searchBkgTmlEdiBatch(String ediRefCd) throws EventException;
	
	/**
	 * retrieve transmit EDI information that will transmit to terminal(ESM_BKG_0616)
	 * @return List<BkgYardCdVO>
	 * @throws EventException 
	 */
	public List<BkgYardCdVO> searchBkgTmlEdiBatchYardCd() throws EventException;
	
	/**
	 * 
	 * @param ydCd
	 * @return
	 * @throws EventException
	 */
	public String searchBatchEdiVvdList(String ydCd) throws EventException;
	
	/**
	 * 
	 * @param bkgNo
	 * @param HisUiNm
	 * @param rcvId
	 * @param sndrId
	 * @param refCode
	 * @param ediKind
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public BkgNtcHisVO createTmlBkgReceiptEdi(String bkgNo, String HisUiNm, String rcvId, String sndrId, String refCode, String ediKind, SignOnUserAccount account) throws EventException;
	
	/**
	 * 
	 * @param bkgNo
	 * @param rcvId
	 * @param sndrId
	 * @param refCode
	 * @param ediKind
	 * @param cntrNo
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public BkgNtcHisVO createVermasBkgReceiptEdi(String bkgNo, String rcvId, String sndrId, String refCode, String ediKind,	String cntrNo, SignOnUserAccount account) throws EventException;
}