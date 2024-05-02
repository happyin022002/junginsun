/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JOInvoiceManageBCImpl.java
*@FileTitle : JOInvoiceManage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.basic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.event.EsdTpb0124Event;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.event.EsdTpb0126Event;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.event.EsdTpb0127Event;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.integration.JOInvoiceManageDBDAO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.InvoiceCreationVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.InvoiceDetailListForRevisionVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchErpInterfaceCheckDataVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchInvoiceDefaultDataVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchInvoiceSheetSetVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchOtsGrpInfoVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchOutstandingDetailListForInvoiceCreationVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchTPBHandlingListVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.SearchThirdPartyInfoVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.TpbInvIfDtlVO;
import com.clt.apps.opus.esd.tpb.jocasemanage.joinvoicemanage.vo.TpbInvIfSmryVO;
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
 * -JOInvoiceManage Business Logic Basic Command implementation<br>
 * - -JOInvoiceManage business logic interface<br>
 *
 * @author 
 * @see ESD_TPB_0105EventResponse,JOInvoiceManageBC DAO class reference
 * @since J2EE 1.6
 */
public class JOInvoiceManageBCImpl extends BasicCommandSupport implements JOInvoiceManageBC {

	// Database Access Object
	private transient JOInvoiceManageDBDAO dbDao = null;

	/**
	 * JOInvoiceManageBCImpl object creation<br>
	 * JOInvoiceManageDBDAO creation<br>
	 */
	public JOInvoiceManageBCImpl() {
		dbDao = new JOInvoiceManageDBDAO();
	}
	/**
	 * <br>
	 * 
	 * @param SearchTPBHandlingListVO searchTPBHandlingListVO
	 * @param account SignOnUserAccount
	 * @return List<SearchTPBHandlingListVO>
	 * @exception EventException
	 */
	public List<SearchTPBHandlingListVO> searchTPBHandlingList(SearchTPBHandlingListVO searchTPBHandlingListVO, SignOnUserAccount account) throws EventException {
		try {
			searchTPBHandlingListVO.setUserOfcCd(account.getOfc_cd());
			return dbDao.searchTPBHandlingList(searchTPBHandlingListVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
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
	 * @param Event e
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse createERPInterface(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		 
		if( e.getEventName().equalsIgnoreCase("EsdTpb0124Event")){
			try {
			EsdTpb0124Event event = (EsdTpb0124Event)e;
			SignOnUserAccount account = event.getSignOnUserAccount();
			
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
		}else if( e.getEventName().equalsIgnoreCase("EsdTpb0126Event")){
			try {
				EsdTpb0126Event event = (EsdTpb0126Event)e;
				SignOnUserAccount account = event.getSignOnUserAccount();
				
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
		}else if( e.getEventName().equalsIgnoreCase("EsdTpb0127Event")){
			try {
				EsdTpb0127Event event = (EsdTpb0127Event)e;
				SignOnUserAccount account = event.getSignOnUserAccount();
				
				InvoiceCreationVO vo = event.getInvoiceCreationVO();
				
				/// Invoice 유효성 체크 
				String validYnInvoiceSeq = dbDao.searchInvoiceRvisSeq(vo);
				if ( !validYnInvoiceSeq.equals("Y") ) {
					log.info(" Object Invoice Seq Check / validYn : " + validYnInvoiceSeq );
					throw new EventException(new ErrorHandler("TPB00075").getMessage());
				}
				
				//log.debug("invoiceCreationVO.length===>"+vo.);
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
			}
		return eventResponse;
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
			
			// step 1 : create i/f data to local db 
			// Credit Note // Revision 
			if ( new_credit_note_cd == null || new_credit_note_cd.length() != 3 ){
				new_credit_note_cd = vo.getOutErpifCreditnoteCd();
			}
			vo.setNewCreditnoteCd(new_credit_note_cd);
//			log.debug("new_credit_note_cd==>"+new_credit_note_cd);
			
			if (out_erpif_creditnote_seq !=null && out_erpif_creditnote_seq.length() > 0) {
				List<TpbInvIfSmryVO> smry = dbDao.searchErpInterfaceDataForCreditNote(vo);
				vo.setArIfNo(smry.get(0).getArIfNo());
				List<TpbInvIfDtlVO> dtl = dbDao.searchErpInterfaceDataForCreditNoteDtl(vo);
				ARInterfaceCreationVO genIfVo = new ARInterfaceCreationVO();
				
				//==============================================
				//dtl.get(0).setChgCurrCd(smry.get(0).getCurrCd());
				//vo.setCurrCd(smry.get(0).getCurrCd());
				//dtl.get(0).setChgCurrCd(vo.getSCurrCd());
//				if (vo.getSCurrCd() == null || vo.getSCurrCd() == "") {
//					dtl.get(0).setChgCurrCd(vo.getCurrCd());
//				}else{
//					dtl.get(0).setChgCurrCd(vo.getSCurrCd());
//				}
				//dtl.get(0).setChgAmt(JSPUtil.removeCharacter(vo.getSTotalAmt(),","));
				//==============================================
				
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
				List<TpbInvIfSmryVO> smry = dbDao.searchErpInterfaceData(vo);
				vo.setArIfNo(smry.get(0).getArIfNo());
				addAmt = dbDao.searchErpInterfaceDataAddDdt(vo);
				
				List<TpbInvIfDtlVO> dtl = dbDao.searchErpInterfaceDataDtl(vo);
				ARInterfaceCreationVO genIfVo = new ARInterfaceCreationVO();

				//==============================================
				//dtl.get(0).setChgCurrCd(smry.get(0).getCurrCd());
				//vo.setCurrCd(smry.get(0).getCurrCd());
//				dtl.get(0).setChgCurrCd(vo.getCurrCd());
//				if (vo.getSCurrCd() == null || vo.getSCurrCd() == "") {
//					dtl.get(0).setChgCurrCd(vo.getCurrCd());
//				}else{
//					dtl.get(0).setChgCurrCd(vo.getSCurrCd());
//				}
				//dtl.get(0).setChgAmt(JSPUtil.removeCharacter(vo.getSTotalAmt(),","));
				//==============================================
//				BigDecimal addDdtAmt = new BigDecimal(0);
				BigDecimal addDdtAmt = null;
				BigDecimal tempRemainAmt = null;
				BigDecimal tempAmt = null;
				
				if ( addAmt != null && addAmt.equals("")){ /// for Revision
					addDdtAmt = new BigDecimal(addAmt); 
					tempRemainAmt = addDdtAmt;
				}
				
				if (addAmt != null && addAmt.length() > 0 ){ /// for Revision
					tempAmt = new BigDecimal(dtl.get(0).getChgAmt());
//					log.debug("dtl.get(0).getChgAmt()==============>"+dtl.get(0).getChgAmt());
//					log.debug("tempAmt==============>"+tempAmt);
					if (tempRemainAmt != null && tempRemainAmt.compareTo(new BigDecimal(0)) != 0 ){
						if ( tempAmt.add(tempRemainAmt).compareTo(new BigDecimal(0)) < 0 ){
							tempRemainAmt = tempRemainAmt.add(tempAmt);
							tempAmt = new BigDecimal(0);
						} else if ( tempAmt.add(tempRemainAmt).compareTo(new BigDecimal(0)) >= 0 ){
							tempAmt = tempAmt.add(tempRemainAmt);
							tempRemainAmt = new BigDecimal(0);
						}
					}
					dtl.get(0).setChgAmt(tempAmt.toString());
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
		
		BigDecimal addDdtAmt = null; 
		BigDecimal tempRemainAmt = null;
		BigDecimal tempAmt = null;
		
		if ( addAmt != null && !addAmt.equals("") ){ /// for Revision
			addDdtAmt = new BigDecimal(addAmt); 
			tempRemainAmt = addDdtAmt;
		}
		////////////////////////////////////////////////////////////////////
		try {
			for (int i = 0 ; i < dtl.size() ; i++ ){ // just 1 loop 
				InvArIfChgVO inArChg = new InvArIfChgVO();
				inArChg.setChgSeq(JSPUtil.getNull(dtl.get(i).getChgSeq()));
				inArChg.setCurrCd(dtl.get(i).getChgCurrCd());
				inArChg.setChgCd(JSPUtil.getNull(dtl.get(i).getN3ptyInvChgTpCd()));
				inArChg.setPerTpCd("BL");
				inArChg.setTrfRtAmt(JSPUtil.getNull(dtl.get(i).getChgAmt()));
//				log.debug("inArChg.getTrfRtAmt()==>"+inArChg.getTrfRtAmt());
				//inArChg.setTrfRtAmt("");
				inArChg.setRatAsCntrQty("1");
				inArChg.setChgAmt(JSPUtil.getNull(dtl.get(i).getChgAmt()));
				inArChg.setInvXchRt(JSPUtil.getNull(dbDao.getRate(dtl.get(i)))); // 환율을 입력
				inArChg.setChgFullNm(dtl.get(i).getChgFullNm());
				if(inArChg.getChgCd().equals("TPC")){
					inArChg.setRepChgCd("ERP");
				}else{
					inArChg.setRepChgCd("XXX");
				}
				inArChg.setChgRmk(dtl.get(i).getAcctCd());
//				log.debug("inArChg.getRepChgCd()==>"+inArChg.getRepChgCd());
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
				if ( addAmt != null && addAmt.length() > 0 ){ /// for Revision
					tempAmt = new BigDecimal(dtl.get(i).getChgAmt());
					
					if (tempRemainAmt != null && tempRemainAmt.compareTo(new BigDecimal(0)) != 0 ){
						if ( tempAmt.add(tempRemainAmt).compareTo(new BigDecimal(0)) < 0 ){
							tempRemainAmt = tempRemainAmt.add(tempAmt);
							tempAmt = new BigDecimal(0);
						} else if ( tempAmt.add(tempRemainAmt).compareTo(new BigDecimal(0)) >= 0 ){
							tempAmt = tempAmt.add(tempRemainAmt);
							tempRemainAmt = new BigDecimal(0);
						}
					}
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
	 * @param SearchInvoiceSheetSetVO searchInvoiceSheetSetVO
	 * @return List<SearchInvoiceSheetSetVO>
	 * @exception EventException
	 */
	public List<SearchInvoiceSheetSetVO> searchInvoiceSheetSet(SearchInvoiceSheetSetVO searchInvoiceSheetSetVO) throws EventException {
		try { 
			return dbDao.searchInvoiceSheetSet(searchInvoiceSheetSetVO);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}


	/**
	 * <br>
	 * 
	 * @param SearchInvoiceSheetSetVO[] searchInvoiceSheetSetVO
	 * @param account SignOnUserAccount
	 * @exception EventException
	 */
	public void createInvoiceSheetSet(SearchInvoiceSheetSetVO[] searchInvoiceSheetSetVO, SignOnUserAccount account) throws EventException{
//		log.debug("abc : "+searchInvoiceSheetSetVO);
		try {
			List<SearchInvoiceSheetSetVO> insertVoList = new ArrayList<SearchInvoiceSheetSetVO>();
			List<SearchInvoiceSheetSetVO> updateVoList = new ArrayList<SearchInvoiceSheetSetVO>();
//			List<SearchInvoiceSheetSetVO> deleteVoList = new ArrayList<SearchInvoiceSheetSetVO>();
			
			for ( int i=0; i<searchInvoiceSheetSetVO .length; i++ ) {
				if ( searchInvoiceSheetSetVO[i].getIbflag().equals("I")){
					searchInvoiceSheetSetVO[i].setCreUsrId(account.getUsr_id());
					insertVoList.add(searchInvoiceSheetSetVO[i]);
//					log.debug("abc: "+searchInvoiceSheetSetVO[i].getCreUsrId());
				} else if ( searchInvoiceSheetSetVO[i].getIbflag().equals("U")){
					searchInvoiceSheetSetVO[i].setUpdUsrId(account.getUsr_id());
					updateVoList.add(searchInvoiceSheetSetVO[i]);
//					log.debug("getUpdUsrId: "+updateVoList.get(i).getUpdUsrId());
				}
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
	 * <br>
	 * 
	 * @param EsdTpb0126Event event
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	public GeneralEventResponse searchInvoiceCreation(EsdTpb0126Event event, GeneralEventResponse eventResponse) throws EventException{
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
 			
 			//SearchInvoiceSettingVO vo1_1 =  event.getSearchInvoiceSettingVO();
 			SearchInvoiceSheetSetVO vo1_1 = event.getSearchInvoiceSheetSetVO();
 			vo1_1.setSInvIssOfcCd(sa.getOfc_cd());
 			
 			List<SearchInvoiceSheetSetVO> rsVO1_1=dbDao.searchInvoiceSheetSet(vo1_1);
 			
			if(rsVO1_1.size()>0){
//				log.debug("rsVO1_1.size()===>"+rsVO1_1.size());
//	 			log.debug("rsVO1_1.size()===>"+rsVO1_1.size());
				vo1.setBilToLocDivCd(rsVO1_1.get(0).getBilToLocDivCd());
				vo1.setVatXchRt(rsVO1_1.get(0).getVatXchRt());
				vo1.setSSheetSetCount("1");
			}
//			log.debug("vo1.getSDaoN3ptyNo()========>"+vo1.getSDaoN3ptyNo());
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
				eventResponse.setETCData("s_vndr_cust_nm",rsVO1.get(0).getVndrCustNm());
				eventResponse.setETCData("s_rhq_cd",rsVO1.get(0).getRhqCd());
				eventResponse.setETCData("s_sheet_set_count",rsVO1.get(0).getSheetSetCount());
				eventResponse.setETCData("s_bil_loc",rsVO1.get(0).getBilToLocDivCd());
//				log.debug("rsVO1.get(0).getBilToLocDivCd()==============>"+rsVO1.get(0).getBilToLocDivCd());
				eventResponse.setETCData("s_vndr_cust_eml",rsVO1.get(0).getVndrCustEml());
				eventResponse.setETCData("s_vat_xch_rt",rsVO1.get(0).getVatXchRt());
				eventResponse.setETCData("s_rgst_no",rsVO1.get(0).getRgstNo());
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
			/*
			List<GetIndiaTaxInfoVO> rsVO4 = null;
			if( sa.getCnt_cd().equals("IN")){//2009-05-18 O Wan-Ki 1.2 [TPB Restructuring 2단계 (Invoice 부분) 보완/개발] Invoice for India
				rsVO4 = dbDao.getIndiaTaxInfo(sa.getOfc_cd());
				// rsVO4를 ETC-DATA로 setting
				eventResponse.setETCData("ida_tax_seq",rsVO4.get(0).getIdaTaxSeq());
				eventResponse.setETCData("expn_tax",rsVO4.get(0).getExpnTax());
				eventResponse.setETCData("edu_tax",rsVO4.get(0).getEduTax());
				eventResponse.setETCData("high_edu_tax",rsVO4.get(0).getHighEduTax());
				eventResponse.setETCData("tax_rgst_no",rsVO4.get(0).getTaxRgstNo());
				eventResponse.setETCData("svc_cate_rmk",rsVO4.get(0).getSvcCateRmk());
			}else{
				eventResponse.setETCData("ida_tax_seq","");
				eventResponse.setETCData("expn_tax","");
				eventResponse.setETCData("edu_tax","");
				eventResponse.setETCData("high_edu_tax","");
				eventResponse.setETCData("tax_rgst_no","");
				eventResponse.setETCData("svc_cate_rmk","");
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

			multiInvoiceManageListVO[0].setVndrCustRefRmk(JSPUtil.getNull(multiInvoiceManageListVO[0].getVndrCustRefRmk()));
			multiInvoiceManageListVO[0].setSNetAmt(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getSNetAmt(),","));
			multiInvoiceManageListVO[0].setSVatAmt(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getSVatAmt(),","));
			multiInvoiceManageListVO[0].setSSumInvAmt(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getSSumInvAmt(),","));
			multiInvoiceManageListVO[0].setAddAmt(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getAddAmt(),","));
			multiInvoiceManageListVO[0].setSDdctAmt(JSPUtil.removeCharacter(multiInvoiceManageListVO[0].getSDdctAmt(),","));
			multiInvoiceManageListVO[0].setBilTpCd(multiInvoiceManageListVO[0].getSDaoN3ptyBilTpCd());

			InvoiceCreationVO invo1 = multiInvoiceManageListVO[0];
			String[] rtnValue = {"",""};

			/// TPB 유효성 체크 
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
			multiInvoiceManageListVO[0].setIdaTaxSeq("");
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
	 * @param EsdTpb0127Event event
	 * @param GeneralEventResponse eventResponse
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	
	public GeneralEventResponse searchInvoiceDetailListForRevision(EsdTpb0127Event event, GeneralEventResponse eventResponse) throws EventException {
		
		try {
			SignOnUserAccount account = event.getSignOnUserAccount();
			InvoiceDetailListForRevisionVO invoiceDetailListForRevisionVO = event.getInvoiceDetailListForRevisionVO();
			
			invoiceDetailListForRevisionVO.setUserOfcCd(account.getOfc_cd());

			SearchInvoiceSheetSetVO vo1 = event.getSearchInvoiceSheetSetVO();
			
			vo1.setSInvIssOfcCd(account.getOfc_cd());
			
			List<SearchInvoiceSheetSetVO> rsVO1=dbDao.searchInvoiceSheetSet(vo1);
			if(rsVO1.size()>0){
				invoiceDetailListForRevisionVO.setVatXchRtOriginal(rsVO1.get(0).getVatXchRt());
			}

			//n3pty_inv_no 에 해당하는 n3pty_no를 먼저 구한다.
			List<InvoiceDetailListForRevisionVO> rsVO2 = dbDao.searchTrdPartyDataForCorrectionInvOts(invoiceDetailListForRevisionVO);
			
			String s_detail_n3pty_no = "";
			String s_detail_ots_sts_cd = "";
			StringBuffer s_detail_n3pty_no_buf = new StringBuffer();
			StringBuffer s_detail_ots_sts_cd_buf =  new StringBuffer();
			
			if(rsVO2.size()>0){
				for(int i=0 ; i< rsVO2.size() ; i++){
//					s_detail_n3pty_no = s_detail_n3pty_no + rsVO2.get(i).getN3ptyNo() ;//+ "|";
//					s_detail_ots_sts_cd = s_detail_ots_sts_cd + rsVO2.get(i).getOtsStsCd() ;//+ "|";
					s_detail_n3pty_no_buf.append(rsVO2.get(i).getN3ptyNo());
					s_detail_ots_sts_cd_buf.append(rsVO2.get(i).getOtsStsCd());
				}
			}
			
			s_detail_n3pty_no = s_detail_n3pty_no_buf.toString();
			s_detail_ots_sts_cd = s_detail_ots_sts_cd_buf.toString();
			invoiceDetailListForRevisionVO.setSDetailN3ptyNo(s_detail_n3pty_no);
			invoiceDetailListForRevisionVO.setSDetailOtsStsCd(s_detail_ots_sts_cd);
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
			List<InvoiceDetailListForRevisionVO> rsVO4 = dbDao.searchInvoiceRevisionInfo(invoiceDetailListForRevisionVO);
			
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
				eventResponse.setETCData("s_his_seq",""); //Inquiry detail에서는 사용하지만, Correction detail은 null로 처리함
				eventResponse.setETCData("s_inv_desc",rsVO4.get(0).getInvDesc());
				eventResponse.setETCData("s_final_flg",rsVO4.get(0).getFinalFlg());
				eventResponse.setETCData("s_detail_n3pty_no",rsVO4.get(0).getDetailN3ptyNo());
				eventResponse.setETCData("s_detail_ots_sts_cd",rsVO4.get(0).getDetailOtsStsCd());
				eventResponse.setETCData("s_vndr_cust_eml",rsVO4.get(0).getVndrCustEml());
				eventResponse.setETCData("s_vat_xch_rt_original",rsVO4.get(0).getVatXchRtOriginal());
				eventResponse.setETCData("s_net_amt",rsVO4.get(0).getNetAmt());
				//==========================================================================================
				eventResponse.setETCData("s_vat_amt",rsVO4.get(0).getVatAmt()); 
				//==========================================================================================
				eventResponse.setETCData("s_add_amt",rsVO4.get(0).getAddAmt());
				eventResponse.setETCData("s_ddct_amt",rsVO4.get(0).getDdctAmt());
				eventResponse.setETCData("s_total_amt",rsVO4.get(0).getTotalAmt());
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

			}//InvoiceManageDBDAOSearchInvoiceRevisionInfoRSQL
			List<InvoiceDetailListForRevisionVO> rsVO5 = dbDao.searchInvoiceRevisionDetailList(invoiceDetailListForRevisionVO);
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
				//eventResponse.setETCData("s_ida_tax_seq",reValue.getIdaTaxSeq());
				
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
			String new_n3pty_inv_rvis_cd = ""; // 새 Revision 버전 
			String new_n3pty_inv_creditnote_cd = "";   // 새 Credit Note 버전
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

			inVO.setSN3ptyInvRvisSeq(inVO.getSN3ptyInvHisSeq());
			
			String s_clt_agn_flg = inVO.getSCltAgnFlg();
			if ( s_clt_agn_flg==null || !s_clt_agn_flg.equals("Y") ){
				inVO.setSCltAgnFlg("N");
			}
			String s_inv_iss_rhq_cd = inVO.getSInvIssRhqCd();
			if ( s_inv_iss_rhq_cd==null ){
				inVO.setSInvIssRhqCd("");
			}
			int hdr_del_result = 0; //Detail이 모두 delete 되면 Header 테이블도 delete 반영여부

			inVO.setVndrCustRefRmk(JSPUtil.getNull(inVO.getVndrCustRefRmk()));
	        inVO.setSVatAmt(JSPUtil.removeCharacter(inVO.getSVatAmt(),","));
	        inVO.setSNetAmt(JSPUtil.removeCharacter(inVO.getSNetAmt(),","));
	        inVO.setSTotalAmt(JSPUtil.removeCharacter(inVO.getSTotalAmt(),","));
	        inVO.setOtsAmt(String.valueOf(JSPUtil.toDecimalFormat(Float.parseFloat(inVO.getOtsAmt()), "###.00")));
	        inVO.setInvDtlAmt(String.valueOf(JSPUtil.toDecimalFormat(Float.parseFloat(inVO.getInvDtlAmt()), "###.00")));
	        inVO.setRevAmt("0");
			
			String[] rtnValue= dbDao.modifyInvoiceRvis(inVO);
			
			inVO.setNewRvisSeq(rtnValue[1]);
			inVO.setNewRvisCd(rtnValue[2]);
			inVO.setNewCreditnoteSeq(rtnValue[3]);
			inVO.setNewCreditnoteCd(rtnValue[4]);
			
			String deleteYn = ""; // Delete 여부 
			
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
			eventResponse.setETCData("new_credit_note_cd", new_n3pty_inv_creditnote_cd);		
			
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

					multiInvoiceManageListVO[i].setVndrCustRefRmk(inVO.getVndrCustRefRmk());
					multiInvoiceManageListVO[i].setOtsAmt(String.valueOf(JSPUtil.toDecimalFormat(Float.parseFloat(multiInvoiceManageListVO[i].getOtsAmt()), "###.00")));
					multiInvoiceManageListVO[i].setInvDtlAmt(String.valueOf(JSPUtil.toDecimalFormat(Float.parseFloat(multiInvoiceManageListVO[i].getInvDtlAmt()), "###.00")));

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
				//blocking for test
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
	 * getting n3pty_expn_no_cd of TPB Invoice No.<br>
	 * checking data validation<br>
	 * - NON J/O  : Source, Billing Case, 3rd Party, Revenue VVD, Currency checking other value
	 * - J/O Case - Source, Billing Case, 3rd Party, Revenue VVD, Actual VVD, Currency, Csr No., Month of GL Date checking other value
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
}