/*=========================================================
 * Copyright(c) 2009 CyberLogitec
 * @FileName : AccountReceivableEDISendBCImpl.java
 * @FileTitle : (China) Pantos Inquiry/Re-send
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2009.05.09
 * @LastModifier : 김상현
 * @LastVersion : 1.0
 * 2009.05.04 김세일
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.09.10 최도순 [CHM-201005801] AR Inovice module내 EDI Submission기능 추가 개발(2차)
 * 2011.12.01 이석준 [CHM-201006884] AR Inovice module내 EDI Submission기능 추가 개발(2차) to Glovis 
 * 2011.12.13 최도순 [] HP EDI FLAT FILE 변경
 * 2010.12.22 최도순 [CHM-201006644] 최도순 NIKE, Invoice EDI 신규 개발 요청
 * 2011.03.03 최도순 [CHM-201109000][ALPS INV] NIKE EDI기능 수정 요청
 * 2012.03.06 김상현 [CHM-201216560-01] [요청] 삼성 EDI 수신자(거래상대방) 코드 변경
 * 2012.03.23 권 민 [CHM-201216902] [INV] 삼성 Display 분사에 따른 EDI 신규요청
 * 2012.05.09 김상현 [CHM-201216976] DHL EDI 개발 요청
 * 2012.05.21 김상현 [CHM-201216580] Honey Well EDI 작업
 * 2012.06.20 김상현 [CHM-201218417] 삼성전자 EDI TIME OUT 방지 logic 보완 요청
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.basic;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration.AccountReceivableEDISendDBDAO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration.AccountReceivableEDISendEAIDAO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.APCInvoiceGRPVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.APCInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.BLIssueInfoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.CmdtInfoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ContainerInfoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.CustomerInfoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DblEdiCntrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.EDI310InputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.EDI310InvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.InvEDIChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.InvEDICntrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.InvEDIHdrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.LocationInfoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.PorDelDateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SealInfoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.VesselInfoVO;
import com.clt.bizcommon.edi.broker.ReferenceNumberGeneratorBroker;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;


/**
 * ALPS-AccountReceivableInvoiceMgt Business Logic Basic Command implementation<br>
 * - ALPS-AccountReceivableInvoiceMgt에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author saeil kim
 * @see FNS_INV_0003EventResponse,AccountReceivableEDISendBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class AccountReceivableEDISendBCImpl extends BasicCommandSupport implements AccountReceivableEDISendBC {

	// Database Access Object
	private transient AccountReceivableEDISendDBDAO dbDao = null;
	private transient AccountReceivableEDISendEAIDAO eaiDao = null;

	/** 
	 * AccountReceivableEDISendBCImpl 객체 생성<br>
	 * AccountReceivableEDISendDBDAO를 생성한다.<br>
	 */
	public AccountReceivableEDISendBCImpl() {
		dbDao = new AccountReceivableEDISendDBDAO();
		eaiDao = new AccountReceivableEDISendEAIDAO();
	}
	
	
	/**
	 * Search EDI 310 Invoice<br>
	 * 
	 * @param EDI310InputVO edi310InputVO
	 * @return List<EDI310InvoiceVO>
	 * @exception EventException
	 */
	public List<EDI310InvoiceVO> searchEDI310Invoice( EDI310InputVO edi310InputVO ) throws EventException {
		try {			
			
			List<EDI310InvoiceVO> list = null;
			
			String custCd = "";
			String scRfaNo = "";
			String ediLvl = "";
			
			if(!("").equals(edi310InputVO.getCustCd())){
				if(edi310InputVO.getCustCd().indexOf(",") == -1){
					custCd = edi310InputVO.getCustCd();
				} else {
					custCd = edi310InputVO.getCustCd().substring(0, edi310InputVO.getCustCd().indexOf(","));
				}
			}
		
			String cntcTpCd = edi310InputVO.getCntcTpCd();
			
			if(!("").equals(edi310InputVO.getScRfaNo())){
				if(edi310InputVO.getScRfaNo().indexOf(",") == -1){
					scRfaNo = edi310InputVO.getScRfaNo();
				} else {
					scRfaNo = edi310InputVO.getScRfaNo().substring(0, edi310InputVO.getScRfaNo().indexOf(","));
				}
			}
					
			if(!("").equals(custCd)){
				String[] custInfo = dbDao.searchEDICustInfo(custCd.substring(0, 2), custCd.substring(2));
				if(custInfo != null) ediLvl = custInfo[3];
			} else {
				ediLvl = dbDao.searchInvoiceEDILevel(cntcTpCd, scRfaNo);
			}
			
			if(("B").equals(ediLvl)) {
				list =  dbDao.searchEDI310Invoice(edi310InputVO);
			} else if(("C").equals(ediLvl)) {
				list =  dbDao.searchContainerInvoice(edi310InputVO);
			}
			
			return list;
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}
	
	/**
	 * Search Invoice EDI Level<br>
	 * 
	 * @param String cntcTpCd
	 * @param String scRfaNo
	 * @return String
	 * @exception EventException
	 */
	public String searchInvoiceEDILevel( String cntcTpCd, String scRfaNo) throws EventException {
		try {			
			return dbDao.searchInvoiceEDILevel(cntcTpCd, scRfaNo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}
	
	/**
	 * Send EDI 310 Invoice<br>
	 * 
	 * @param List<EDI310InvoiceVO> edi310InvoiceVOs
	 * @param String usrId
	 * @return List<String>
	 * @exception EventException
	 */		
	public List<String> sendEDI310Invoice (List<EDI310InvoiceVO> edi310InvoiceVOs, String usrId) throws EventException{
		
		
		List<String> listInvHdrExclude = new ArrayList<String>(); 
		
		try {
			
			String invHdrKey = "";
			String ediHdrSeq = "";
			String ediHdrSeqList = "";
			
			List<InvEDIHdrVO> invEDIHdrVOs = new ArrayList<InvEDIHdrVO>();
			List<InvEDIChgVO> invEDIChgVOs = new ArrayList<InvEDIChgVO>();
			List<InvEDICntrVO> invEDICntrVOs = new ArrayList<InvEDICntrVO>();
			List<String> listInvHdrUnique = new ArrayList<String>(); 
			
			
			for (int i = 0; i < edi310InvoiceVOs.size(); i++) {
				EDI310InvoiceVO edi310InvoiceVO = edi310InvoiceVOs.get(i);
			
				String[] custInfo = dbDao.searchEDICustInfo(edi310InvoiceVO.getActCustCntCd(),edi310InvoiceVO.getActCustSeq());
				/*if(custInfo != null && !custInfo[0].equals("")) {
				} else {
					if (!listInvHdrExclude.contains(edi310InvoiceVO.getBlNo())) {
						listInvHdrExclude.add(edi310InvoiceVO.getBlNo());
					}					
					continue;
				}*/
				
				if(custInfo == null || "".equals(custInfo[0])){
					if (!listInvHdrExclude.contains(edi310InvoiceVO.getBlNo())) {
						listInvHdrExclude.add(edi310InvoiceVO.getBlNo());
					}					
					continue;
				}
				
				invHdrKey  = edi310InvoiceVO.getMergeChk() + edi310InvoiceVO.getBlNo() + edi310InvoiceVO.getCntrNo() + edi310InvoiceVO.getArIfNo();		
				
				
				//invHdrKey = edi310InvoiceVO.getMergeChk();
				
				if (!listInvHdrUnique.contains(String.valueOf(invHdrKey)) && !invHdrKey.equals("")) {
					
					InvEDIHdrVO invEDIHdrVO = new InvEDIHdrVO();
					listInvHdrUnique.add(invHdrKey);
					
					invEDIHdrVO.setEdiGrpCd(custInfo[0]);
					invEDIHdrVO.setEdiReceiverId(custInfo[1]);
					invEDIHdrVO.setEdiSenderId(custInfo[2]);				
					
					invEDIHdrVO.setArIfNo(edi310InvoiceVO.getArIfNo());
					invEDIHdrVO.setBlNo(edi310InvoiceVO.getBlNo());
					invEDIHdrVO.setBlSeq(edi310InvoiceVO.getBlSeq());
					invEDIHdrVO.setBkgNo(edi310InvoiceVO.getBkgNo());
					invEDIHdrVO.setInvNo(edi310InvoiceVO.getInvNo());
					
					//if(("INV_BL").equals(edi310InvoiceVO.getEdiTpCd())){
					//	invEDIHdrVO.setCntrNo("");						
					//} else {
					//	invEDIHdrVO.setCntrNo(edi310InvoiceVO.getCntrNo());
					//}
					invEDIHdrVO.setCntrNo(edi310InvoiceVO.getCntrNo());
					invEDIHdrVO.setCnmvCycNo(edi310InvoiceVO.getCnmvCycNo());
					
					invEDIHdrVO.setArOfcCd(edi310InvoiceVO.getArOfcCd());
					invEDIHdrVO.setRevTpSrcCd(edi310InvoiceVO.getRevTpSrcCd());
					invEDIHdrVO.setActCustCntCd(edi310InvoiceVO.getActCustCntCd());
					invEDIHdrVO.setActCustSeq(edi310InvoiceVO.getActCustSeq());
					invEDIHdrVO.setVslCd(edi310InvoiceVO.getVslCd());
					invEDIHdrVO.setSkdVoyNo(edi310InvoiceVO.getSkdVoyNo());
					invEDIHdrVO.setSkdDirCd(edi310InvoiceVO.getSkdDirCd());
					invEDIHdrVO.setTrnkVvdCd(edi310InvoiceVO.getTrnkVvdCd());
					invEDIHdrVO.setSvcScpCd(edi310InvoiceVO.getSvcScpCd());
					invEDIHdrVO.setSlanCd(edi310InvoiceVO.getSlanCd());
					invEDIHdrVO.setSailArrDt(edi310InvoiceVO.getSailArrDt());
					invEDIHdrVO.setIoBndCd(edi310InvoiceVO.getIoBndCd());
					invEDIHdrVO.setPorCd(edi310InvoiceVO.getPorCd());
					invEDIHdrVO.setPolCd(edi310InvoiceVO.getPolCd());
					invEDIHdrVO.setPodCd(edi310InvoiceVO.getPodCd());
					invEDIHdrVO.setDelCd(edi310InvoiceVO.getDelCd());
					invEDIHdrVO.setScNo(edi310InvoiceVO.getScNo());
					invEDIHdrVO.setRfaNo(edi310InvoiceVO.getRfaNo());
					invEDIHdrVO.setBdrIndFlg(edi310InvoiceVO.getBdrIndFlg());
					invEDIHdrVO.setInvDt(edi310InvoiceVO.getInvDt());
					invEDIHdrVO.setLoclCurrCd(edi310InvoiceVO.getLoclCurrCd());
					invEDIHdrVO.setInvTtlLoclAmt(edi310InvoiceVO.getInvTtlLoclAmt());
					invEDIHdrVO.setEdiSndFlg(edi310InvoiceVO.getEdiSndFlg());
					invEDIHdrVO.setEdiSndDt(edi310InvoiceVO.getEdiSndDt());
					invEDIHdrVO.setEdiTpCd(edi310InvoiceVO.getEdiTpCd());
					invEDIHdrVO.setCreUsrId(usrId);
					invEDIHdrVO.setUpdUsrId(usrId);
					
					if("".equals(edi310InvoiceVO.getEdiHdrSeq())){
						ediHdrSeq = dbDao.searchEDIHeaderSequence();
						invEDIHdrVO.setEdiHdrSeq(ediHdrSeq);
						dbDao.addInvoiceEDIHeader(invEDIHdrVO);
					} else {
						ediHdrSeq = edi310InvoiceVO.getEdiHdrSeq();
						invEDIHdrVO.setEdiHdrSeq(ediHdrSeq);
					}
					
					if(("1").equals(edi310InvoiceVO.getSelChk())) {
						ediHdrSeqList +=  "" + ediHdrSeq + ",";
					}
					
					invEDIHdrVOs.add(invEDIHdrVO);
					//listInvHdrUnique.add(invHdrKey);
					
					if(!"".equals(edi310InvoiceVO.getCntrNo())) {
						String[] cntrList = edi310InvoiceVO.getCntrNo().split(",");
						
						for(int j = 0; j < cntrList.length; j++){
							InvEDICntrVO invEDICntrVO = new InvEDICntrVO();
							
							invEDICntrVO.setEdiHdrSeq(ediHdrSeq);
							invEDICntrVO.setCntrSeq(String.valueOf(j + 1));
							invEDICntrVO.setCntrNo(cntrList[j]);
							invEDICntrVO.setCntrTpszCd("");
							invEDICntrVO.setCreUsrId(usrId);
							invEDICntrVO.setUpdUsrId(usrId);
							
							if("".equals(edi310InvoiceVO.getEdiHdrSeq())){
								dbDao.addInvoiceEDIContainer(invEDICntrVO);
							}
							
							invEDICntrVOs.add(invEDICntrVO);
						}
					}
				}
				
				InvEDIChgVO invEDIChgVO = new InvEDIChgVO();
				
				invEDIChgVO.setEdiHdrSeq(ediHdrSeq);
				invEDIChgVO.setChgSeq(edi310InvoiceVO.getChgSeq());
				invEDIChgVO.setChgCd(edi310InvoiceVO.getChgCd());
				invEDIChgVO.setCurrCd(edi310InvoiceVO.getCurrCd());
				invEDIChgVO.setPerTpCd(edi310InvoiceVO.getPerTpCd());
				invEDIChgVO.setChgAmt(edi310InvoiceVO.getChgAmt());
				invEDIChgVO.setPerTpCd(edi310InvoiceVO.getPerTpCd());  //ADD  per_tp_cd
				invEDIChgVO.setTrfRtAmt(edi310InvoiceVO.getTrfRtAmt());  //ADD  trf_rt_amt
				invEDIChgVO.setRatAsCntrQty(edi310InvoiceVO.getRatAsCntrQty());  //ADD  rat_as_cntr_qty 
				 
				invEDIChgVO.setCreUsrId(usrId);
				invEDIChgVO.setUpdUsrId(usrId);
				
				if("".equals(edi310InvoiceVO.getEdiHdrSeq())){
					dbDao.addInvoiceEDICharge(invEDIChgVO);
				}
				
				invEDIChgVOs.add(invEDIChgVO);
				
			}
			
			ediHdrSeqList = ediHdrSeqList.substring(0, ediHdrSeqList.length()-1);
			List<InvEDIHdrVO> targetVOs = dbDao.searchEdiSendTarget(ediHdrSeqList);
			
			for (int i = 0; i < targetVOs.size(); i++) {
				if (targetVOs.get(i).getEdiTpCd().equals("INV_BL")) { 
					log.debug("createInvoiceBlEdi============================================");
					createInvoiceBlEdi(targetVOs.get(i), usrId);	
				} else {					
					log.debug("makeEDI310FlatFile============================================");
					makeEDI310FlatFile(targetVOs.get(i), invEDICntrVOs, usrId);
				}
			}
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
		
		return listInvHdrExclude;
	}
	
	
	
	/**
	 * Make EDI 310 flat file.
	 * 
	 * @param InvEDIHdrVO invEDIHdrVO
	 * @param List<InvEDIChgVO> invEDIChgVOs
	 * @param List<InvEDICntrVO> invEDICntrVOs
	 * @return boolean
	 * @throws Exception
	 */
	private boolean makeEDI310FlatFile(InvEDIHdrVO targetVO, List<InvEDICntrVO> invEDICntrVOs, String usrId) throws Exception {
		String mqName = SubSystemConfigFactory.get("INV.OPUSINV_UBIZCOM_INVOICE.IBMMQ.QUEUE");
		String reString = "";

		// Creating flat file.
		StringBuffer flatBuffer = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm"); 
		Date dt = new Date();
		
		
		// Start Header.
		/*flatBuffer.append("$$$MSGSTART:");
		flatBuffer.append("NYKS                14147844480         INVOIC    ");
		
		String refNo = ReferenceNumberGeneratorBroker.getKey("INV","INV_EDI_SEQ");

		flatBuffer.append(refNo);
		flatBuffer.append("\n");*/
		// End Header.
		
		List<InvEDIHdrVO> invEDIHdrVOs = dbDao.searchEdiSendHeader(targetVO.getEdiHdrSeq());
        InvEDIHdrVO invEDIHdrVO = new InvEDIHdrVO();
        
        invEDIHdrVO = invEDIHdrVOs.get(0);
        
        log.debug("invEDIHdrVO===============================\n" + invEDIHdrVO.toString());
        
        String[] custInfo = dbDao.searchEDICustInfo(invEDIHdrVO.getActCustCntCd(),invEDIHdrVO.getActCustSeq());
        
        String strRcvId = custInfo[1];
        String strSndrId = custInfo[2];
        
        
        // Start Header
        String strEdiHeader = dbDao.searchEdiHeader(strSndrId, strRcvId, "INVOIC");
        log.debug("\n******************** edi_header ********************\n" + strEdiHeader);
        flatBuffer.append(strEdiHeader + "\n");
        // End Header
       
        

		flatBuffer.append("{INVOICE\n");
		
		flatBuffer.append("INV_DATE:" + invEDIHdrVO.getInvDt() + "\n");
		flatBuffer.append("INV_NUM:" + invEDIHdrVO.getInvNo() + "\n");
		flatBuffer.append("INV_SPLIT_FILENBR:" + Integer.parseInt(invEDIHdrVO.getInvNo().substring(invEDIHdrVO.getInvNo().indexOf("-") + 1)) + "\n");
		flatBuffer.append("INV_AMT:" + invEDIHdrVO.getInvTtlLoclAmt() + "\n");
		
		String invTp = "";   //dbDao.searchInvoiceTypeCode(invEDIHdrVO.getArIfNo());
		
		if(("M").equals(invEDIHdrVO.getRevTpSrcCd().substring(0, 1))){
			invTp = "02";
		} else {
			if(invEDIHdrVO.getInvTtlLoclAmt().indexOf("-") == -1){
				invTp = "01";
			} else {
				invTp = "03";
			}
		}
		
		flatBuffer.append("INV_TP:" + invTp + "\n");
		
		flatBuffer.append("CURRENCY_CODE:" + invEDIHdrVO.getLoclCurrCd() + "\n");
		flatBuffer.append("MODE_CODE:VE" + "\n");
		flatBuffer.append("CARRIER_CODE:NYKS" + "\n");
		
		String ofcNm = dbDao.searchOfficeName(invEDIHdrVO.getArOfcCd());
		
		flatBuffer.append("PAY_OFFICE_NAME:" + ofcNm + "\n");
		flatBuffer.append("APP_DT:" + sdf.format(dt) + "\n");
		flatBuffer.append("{DETAIL_INFO\n");
		
		LocationInfoVO porInfoVO = dbDao.searchLocationInfo(invEDIHdrVO.getPorCd());
		
		flatBuffer.append("POR_UNLC:" + invEDIHdrVO.getPorCd() + "\n");
		flatBuffer.append("POR_NAME:" + porInfoVO.getLocNm() + "\n");
		flatBuffer.append("POR_QUAL:" + porInfoVO.getQualifier() + "\n");
		flatBuffer.append("POR_PORT:" + porInfoVO.getLocAmsPortCd() + "\n");
		flatBuffer.append("POR_STATE_CD:" + porInfoVO.getSteCd() + "\n");
		
		String porEtd = "";
		String porAtd = "";
		PorDelDateVO porDateVO = dbDao.searchPorDelDate(invEDIHdrVO.getBkgNo(), invEDIHdrVO.getCntrNo(), "R");
		
		if(porDateVO != null){
			porEtd = porDateVO.getEstmDt();
			porAtd = porDateVO.getActDt();
		}
		
		flatBuffer.append("POR_ETD:" + porEtd + "\n");
		flatBuffer.append("POR_ATD:" + porAtd + "\n");
		
		LocationInfoVO polInfoVO = dbDao.searchLocationInfo(invEDIHdrVO.getPolCd());
		
		flatBuffer.append("POL_UNLC:" + invEDIHdrVO.getPolCd() + "\n");
		flatBuffer.append("POL_NAME:" + polInfoVO.getLocNm() + "\n");
		flatBuffer.append("POL_QUAL:" + polInfoVO.getQualifier() + "\n");
		flatBuffer.append("POL_PORT:" + polInfoVO.getLocAmsPortCd() + "\n");
		flatBuffer.append("POL_STATE_CD:" + polInfoVO.getSteCd() + "\n");
		
		String polEtd = dbDao.searchPolPodEstimateDate(invEDIHdrVO.getBkgNo(), "O", invEDIHdrVO.getPolCd());
		String polAtd = dbDao.searchPolPodActualDate(invEDIHdrVO.getBkgNo(), "O", invEDIHdrVO.getPolCd());
		
		flatBuffer.append("POL_ETD:" + polEtd + "\n");
		flatBuffer.append("POL_ATD:" + polAtd + "\n");
		
		LocationInfoVO podInfoVO = dbDao.searchLocationInfo(invEDIHdrVO.getPodCd());
		
		flatBuffer.append("POD_UNLC:" + invEDIHdrVO.getPodCd() + "\n");
		flatBuffer.append("POD_NAME:" + podInfoVO.getLocNm() + "\n");
		flatBuffer.append("POD_QUAL:" + podInfoVO.getQualifier() + "\n");
		flatBuffer.append("POD_PORT:" + podInfoVO.getLocAmsPortCd() + "\n");
		flatBuffer.append("POD_STATE_CD:" + podInfoVO.getSteCd() + "\n");
		
		String podEta = dbDao.searchPolPodEstimateDate(invEDIHdrVO.getBkgNo(), "I", invEDIHdrVO.getPodCd());
		String podAta = dbDao.searchPolPodActualDate(invEDIHdrVO.getBkgNo(), "I", invEDIHdrVO.getPodCd());
		
		flatBuffer.append("POD_ETA:" + podEta + "\n");
		flatBuffer.append("POD_ATA:" + podAta + "\n");
		
		LocationInfoVO delInfoVO = dbDao.searchLocationInfo(invEDIHdrVO.getDelCd());
		
		flatBuffer.append("DEL_UNLC:" + invEDIHdrVO.getDelCd() + "\n");
		flatBuffer.append("DEL_NAME:" + delInfoVO.getLocNm() + "\n");
		flatBuffer.append("DEL_QUAL:" + delInfoVO.getQualifier() + "\n");
		flatBuffer.append("DEL_PORT:" + delInfoVO.getLocAmsPortCd() + "\n");
		flatBuffer.append("DEL_STATE_CD:" + delInfoVO.getSteCd() + "\n");
		
		String delEta = "";
		String delAta = "";
		PorDelDateVO delDateVO = dbDao.searchPorDelDate(invEDIHdrVO.getBkgNo(), invEDIHdrVO.getCntrNo(), "E");
		
		if(delDateVO != null){
			delEta = delDateVO.getEstmDt();
			delAta = delDateVO.getActDt();
		}
		
		flatBuffer.append("DEL_ETA:" + delEta + "\n");
		flatBuffer.append("DEL_ATA:" + delAta + "\n");
		
		String porHaulTp = dbDao.searchPorHaulageType(invEDIHdrVO.getBkgNo());
		String podHaulTp = dbDao.searchPodHaulageType(invEDIHdrVO.getBkgNo());
		
		List<SealInfoVO>  sSealInfoVOs = null;
		StringBuffer cmdtBuffer = new StringBuffer();
		
		for(int i = 0; i < invEDICntrVOs.size(); i++){
			if(invEDICntrVOs.get(i).getEdiHdrSeq().equals(invEDIHdrVO.getEdiHdrSeq())){
				ContainerInfoVO containerInfoVO = dbDao.searchContainerInfo(invEDIHdrVO.getBkgNo(), invEDICntrVOs.get(i).getCntrNo());
					
				flatBuffer.append("{CNTR_INFO\n");
				flatBuffer.append("CNTRNBR:" + invEDICntrVOs.get(i).getCntrNo() + "\n");
				flatBuffer.append("CNTRTYPE:" + containerInfoVO.getCntrTpszCd() + "\n");
				flatBuffer.append("MEA_QTY:" + containerInfoVO.getMeasQty() + "\n");
				flatBuffer.append("MEA_TP:" + containerInfoVO.getMeasUtCd() + "\n");
				flatBuffer.append("WGT_QTY:" + containerInfoVO.getCntrWgt() + "\n");
				flatBuffer.append("WGT_TP:" + containerInfoVO.getWgtUtCd() + "\n");
				flatBuffer.append("POR_HAUL_TP:" + porHaulTp + "\n");
				flatBuffer.append("POD_HAUL_TP:" + podHaulTp + "\n");
				
				//SealInfo Start
				sSealInfoVOs =dbDao.searchSealInfo(invEDIHdrVO.getBkgNo(), invEDICntrVOs.get(i).getCntrNo());
				for(int j = 0; j < sSealInfoVOs.size(); j++){
					flatBuffer.append("{SEAL_INFO\n");
					flatBuffer.append("SEAL_TP:" + sSealInfoVOs.get(j).getSealPtyTpCd() + "\n");
					flatBuffer.append("SEAL_NO:" + sSealInfoVOs.get(j).getCntrSealNo() + "\n");
					flatBuffer.append("}SEAL_INFO\n");
				}
				//SealInfo End
				
				//CMDTInfo Start				
				List<CmdtInfoVO>  cmdtInfoVOs = null;
				cmdtInfoVOs =dbDao.searchCmdtInfo(invEDIHdrVO.getBkgNo(), invEDICntrVOs.get(i).getCntrNo());
				for(int j = 0; j < cmdtInfoVOs.size(); j++){
					cmdtBuffer.append("{CMDT_INFO\n");
					cmdtBuffer.append("CMDT_SEQ:" + cmdtInfoVOs.get(j).getCntrMfSeq() + "\n");
					cmdtBuffer.append("CMDT_DESC:" + cmdtInfoVOs.get(j).getCntrMfGdsDesc() + "\n");
					cmdtBuffer.append("CMDT_PKG_QTY:" + cmdtInfoVOs.get(j).getPckQty() + "\n");
					cmdtBuffer.append("CMDT_PKG_TP:" + cmdtInfoVOs.get(j).getPckTpCd() + "\n");
					cmdtBuffer.append("CMDT_WGT_QTY:" + cmdtInfoVOs.get(j).getCntrMfWgt() + "\n");  
					cmdtBuffer.append("CMDT_WGT_TP:" + cmdtInfoVOs.get(j).getWgtUtCd() + "\n");
					cmdtBuffer.append("CMDT_MEA_QTY:" + cmdtInfoVOs.get(j).getMeasQty() + "\n");
					cmdtBuffer.append("CMDT_MEA_TP:" + cmdtInfoVOs.get(j).getMeasUtCd() + "\n");
					cmdtBuffer.append("}CMDT_INFO\n");
				}
				//CMDTInfo End
				
				
				flatBuffer.append("}CNTR_INFO\n");
			}
		}
		
		
		for(int i = 0; i < invEDIHdrVOs.size(); i++){
			flatBuffer.append("{BL_INFO\n");
			flatBuffer.append("BL_NUM:" + invEDIHdrVOs.get(i).getBlNo() + "\n");
			flatBuffer.append("}BL_INFO\n");
		}
		
		VesselInfoVO vesselInfoVO = dbDao.searchVesselInfo(invEDIHdrVO.getVslCd() + invEDIHdrVO.getSkdVoyNo() + invEDIHdrVO.getSkdDirCd(), invEDIHdrVO.getIoBndCd(), invEDIHdrVO.getPolCd(), invEDIHdrVO.getPodCd());
		
		flatBuffer.append("{VSL_INFO\n");
		flatBuffer.append("VSL_NM:" + vesselInfoVO.getVslEngNm() + "\n");
		flatBuffer.append("VSL_CD:" + vesselInfoVO.getVslCd() + "\n");
		flatBuffer.append("VSL_VOY_NO:" + vesselInfoVO.getSkdVoyNo() + "\n");
		flatBuffer.append("VSL_CONSORTIUM_VOY_NO:" + vesselInfoVO.getCssmVoyNo() + "\n");
		flatBuffer.append("VSL_LOYD_CD:" + vesselInfoVO.getLloydNo() + "\n");
		flatBuffer.append("}VSL_INFO\n");
		
		//CMDTInfo 		
		flatBuffer.append(cmdtBuffer.toString());
		
		List<CustomerInfoVO> customerInfoVOs = dbDao.searchCustomerInfoForInvoic( targetVO.getEdiHdrSeq());
		for(int i = 0; i < customerInfoVOs.size(); i++){
			flatBuffer.append("{CUST_INFO\n");
			flatBuffer.append("IBCS_TP:" + customerInfoVOs.get(i).getIbcsTp() + "\n");
			flatBuffer.append("CNT_CD:" + customerInfoVOs.get(i).getCustCntCd() + "\n");
			flatBuffer.append("CUST_CD:" + customerInfoVOs.get(i).getCustSeq() + "\n");
			flatBuffer.append("IBCS_NM:" + customerInfoVOs.get(i).getCustLglEngNm() + "\n");
			flatBuffer.append("IBCS_NM1:" + customerInfoVOs.get(i).getCustLoclLangNm() + "\n");
			flatBuffer.append("IBCS_ADDR1:" + customerInfoVOs.get(i).getLoclAddr1() + "\n");
			flatBuffer.append("IBCS_ADDR2:" + customerInfoVOs.get(i).getLoclAddr2() + "\n");
			flatBuffer.append("IBCS_ADDR3:" + customerInfoVOs.get(i).getLoclAddr3() + "\n");
			flatBuffer.append("IBCS_CITY_NAME:" + customerInfoVOs.get(i).getCtyNm() + "\n");
			flatBuffer.append("IBCS_STATE:" + customerInfoVOs.get(i).getSteCd() + "\n");
			flatBuffer.append("IBCS_ZIP_CD:" + customerInfoVOs.get(i).getZipCd() + "\n");
			flatBuffer.append("IBCS_C_NM:" + customerInfoVOs.get(i).getCntcPsonNm() + "\n");
			flatBuffer.append("IBCS_C_TEL:" + customerInfoVOs.get(i).getPhnNo() + "\n");
			flatBuffer.append("IBCS_C_FAX:" + customerInfoVOs.get(i).getFaxNo() + "\n");
			flatBuffer.append("IBCS_C_EMAIL:" + customerInfoVOs.get(i).getCustEml() + "\n");
			flatBuffer.append("}CUST_INFO\n");			
		}
		flatBuffer.append("}DETAIL_INFO\n");
		
		List<InvEDIChgVO> invEDIChgVOs = dbDao.searchEdiChgInfo(targetVO.getEdiHdrSeq());
		
		for(int i = 0; i < invEDIChgVOs.size(); i++){
			flatBuffer.append("{CHARGE_INFO\n");
			flatBuffer.append("CH_FCTYPE:" + invEDIChgVOs.get(i).getChgCd() + "\n");
			flatBuffer.append("CH_CURR_AMT:" + invEDIChgVOs.get(i).getChgAmt() + "\n");
			flatBuffer.append("CH_CURR_CODE:" + invEDIChgVOs.get(i).getCurrCd() + "\n");
			String frtTermCd = ("I").equals(invEDIChgVOs.get(i).getIoBndCd())?"C":"P";
			flatBuffer.append("CH_FRT_IND:" + frtTermCd + "\n");
			flatBuffer.append("CH_PERTYPE:" + invEDIChgVOs.get(i).getPerTpCd() + "\n");
			flatBuffer.append("CH_BL_NUM:" + invEDIChgVOs.get(i).getBlNo() + "\n");
			flatBuffer.append("CH_CNTRNBR:" + invEDIChgVOs.get(i).getCntrNo() + "\n");
			flatBuffer.append("}CHARGE_INFO\n");			
		}
		
		flatBuffer.append("}INVOICE\n");
		log.debug("### Flat File\n" + flatBuffer.toString());
		
		reString = eaiDao.sendToEDI(mqName, flatBuffer.toString());
		log.debug("### reString=="+reString);

		dbDao.modifyInvoiceEDISendFlag(targetVO.getEdiHdrSeq(), reString, usrId, targetVO.getEdiHdrSeq());
		
		if (!reString.equals("E")) {
			
			return true;
		}

		return false;
	}
	
	/**
	 * APC Invoice 를 조회한다.<br>
	 * @author Myoungsin park
	 * @param APCInvoiceVO aPCInvoiceVO
	 * @return List<APCInvoiceVO>
	 * @exception EventException
	 */	
	public List<APCInvoiceVO> searchAPCInvoice(APCInvoiceVO aPCInvoiceVO) throws EventException {
		List<APCInvoiceVO> list = null;
		try { 
			list = dbDao.searchAPCInvoice(aPCInvoiceVO);	
			return list;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		}			
	}
	
	
	/**
	 * Send APC Invoice<br>
	 * 
	 * @param List<APCInvoiceVO> aPCInvoiceVOs
	 * @param String usrId
	 * @exception EventException
	 */		
	public void sendAPCInvoice (List<APCInvoiceVO> aPCInvoiceVOs, String usrId) throws EventException{
		try { 
			String invHdrKey = "";
			String ediHdrSeq = ""; 
			
			APCInvoiceGRPVO aPCInvoiceGRPVO;
			List<InvEDICntrVO> invEDICntrVOs;
			List<String> listInvHdrUnique = new ArrayList<String>(); 
			//List<InvEDIChgVO> invEDIChgVOs = new ArrayList<InvEDIChgVO>();
			List<APCInvoiceGRPVO> aPCInvoiceGRPVOs = new ArrayList<APCInvoiceGRPVO>();
			
			for (int i = 0; i < aPCInvoiceVOs.size(); i++) {
				APCInvoiceVO aPCInvoiceVO = aPCInvoiceVOs.get(i);
			
				invHdrKey = aPCInvoiceVO.getMergeChk();
				
				if (!listInvHdrUnique.contains(String.valueOf(invHdrKey)) && !invHdrKey.equals("")) {
					aPCInvoiceGRPVO = new APCInvoiceGRPVO();
					InvEDIHdrVO invEDIHdrVO = new InvEDIHdrVO();
					
					invEDIHdrVO.setArIfNo(aPCInvoiceVO.getArIfNo());
					invEDIHdrVO.setBlNo(aPCInvoiceVO.getBlNo());
					invEDIHdrVO.setBlSeq("");    
					invEDIHdrVO.setBkgNo(aPCInvoiceVO.getBkgNo());
					invEDIHdrVO.setInvNo(aPCInvoiceVO.getInvNo());
					invEDIHdrVO.setCntrNo("");
					invEDIHdrVO.setArOfcCd(aPCInvoiceVO.getArOfcCd());
					invEDIHdrVO.setRevTpSrcCd(aPCInvoiceVO.getRevTpSrcCd());
					invEDIHdrVO.setRevTpCd(aPCInvoiceVO.getRevTpSrcCd().substring(0,1));
					invEDIHdrVO.setActCustCntCd(aPCInvoiceVO.getActCustCntCd());
					invEDIHdrVO.setActCustSeq(aPCInvoiceVO.getActCustSeq());
					invEDIHdrVO.setVslCd(aPCInvoiceVO.getVslCd());
					invEDIHdrVO.setSkdVoyNo(aPCInvoiceVO.getSkdVoyNo());
					invEDIHdrVO.setSkdDirCd(aPCInvoiceVO.getSkdDirCd());
					invEDIHdrVO.setTrnkVvdCd(aPCInvoiceVO.getVvd());
					invEDIHdrVO.setSvcScpCd(aPCInvoiceVO.getSvcScpCd());
					invEDIHdrVO.setSlanCd(aPCInvoiceVO.getSlanCd());
					invEDIHdrVO.setSailArrDt(aPCInvoiceVO.getSailArrDt());
					invEDIHdrVO.setIoBndCd(aPCInvoiceVO.getIoBndCd());
					invEDIHdrVO.setPorCd(aPCInvoiceVO.getPorCd());
					invEDIHdrVO.setPolCd(aPCInvoiceVO.getPolCd());
					invEDIHdrVO.setPodCd(aPCInvoiceVO.getPodCd());
					invEDIHdrVO.setDelCd(aPCInvoiceVO.getDelCd());
					invEDIHdrVO.setScNo(aPCInvoiceVO.getScNo());
					invEDIHdrVO.setRfaNo(aPCInvoiceVO.getRfaNo());
					//invEDIHdrVO.setBdrIndFlg(aPCInvoiceVO.getBdrIndFlg());
					invEDIHdrVO.setInvDt(aPCInvoiceVO.getInvDt());
					invEDIHdrVO.setLoclCurrCd(aPCInvoiceVO.getLoclCurrCd());
					invEDIHdrVO.setInvTtlLoclAmt(aPCInvoiceVO.getInvTtlLoclAmt());
					invEDIHdrVO.setEdiSndFlg(aPCInvoiceVO.getEdiSndFlg());
					invEDIHdrVO.setEdiSndDt(aPCInvoiceVO.getEdiSndDt());
					invEDIHdrVO.setEdiTpCd(aPCInvoiceVO.getEdiTpCd());
					invEDIHdrVO.setCreUsrId(usrId);
					invEDIHdrVO.setUpdUsrId(usrId);
					invEDIHdrVO.setInvDeltDivCd(aPCInvoiceVO.getInvDeltDivCd());
					invEDIHdrVO.setCustCrFlg(aPCInvoiceVO.getCustCrFlg());
					invEDIHdrVO.setPayCond(aPCInvoiceVO.getPayCond());
					
					
					if("".equals(aPCInvoiceVO.getEdiHdrSeq())){
						ediHdrSeq = dbDao.searchEDIHeaderSequence();
						invEDIHdrVO.setEdiHdrSeq(ediHdrSeq);
						dbDao.addInvoiceEDIHeader(invEDIHdrVO);
					} else {
						ediHdrSeq = aPCInvoiceVO.getEdiHdrSeq();
						invEDIHdrVO.setEdiHdrSeq(ediHdrSeq);
					}
					 
					listInvHdrUnique.add(invHdrKey);
					aPCInvoiceGRPVO.setInvEDIHdrVO(invEDIHdrVO);
					
					invEDICntrVOs = dbDao.searchCntrListByIfNo(invHdrKey);
					if(invEDICntrVOs.size() > 0){
						for(int j = 0; j < invEDICntrVOs.size(); j++){
							invEDICntrVOs.get(j).setEdiHdrSeq(ediHdrSeq);
							invEDICntrVOs.get(j).setCreUsrId(usrId);
							invEDICntrVOs.get(j).setUpdUsrId(usrId);
							
							if("".equals(aPCInvoiceVO.getEdiHdrSeq())){
								dbDao.addInvoiceEDIContainer(invEDICntrVOs.get(j));
							}
						}
					} 
					
					aPCInvoiceGRPVO.setInvEDICntrVOs(invEDICntrVOs);
					
					//Add search charge info by container 2016.05.10
					List<InvEDIChgVO> invEDIChgVOs = dbDao.searchChargeInfoByContainer(invEDIHdrVO);
					
					if(invEDIChgVOs.size() > 0){
						for (int k = 0; k < invEDIChgVOs.size(); k++) {
							if(invEDIChgVOs.get(k).getChgRefNo().equals("") || invEDIChgVOs.get(k).getChgRefNo() == null){
								String chgRefNo = dbDao.searchChargeRefNo();
								invEDIChgVOs.get(k).setChgRefNo(chgRefNo);
							}
							
							if("".equals(aPCInvoiceVO.getEdiHdrSeq())){  
								dbDao.addInvoiceEDICharge(invEDIChgVOs.get(k)); 
							}
						}	
					}
					
					aPCInvoiceGRPVO.setInvEDIChgVOs(invEDIChgVOs);
					aPCInvoiceGRPVOs.add(aPCInvoiceGRPVO);
				}
				
			}
			
			makeAPCFlatFile(aPCInvoiceGRPVOs);
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}
	
	/**
	 * Make APC flat file.
	 * 
	 * @param List<APCInvoiceGRPVO> aPCInvoiceGRPVOs
	 * @return boolean
	 * @throws Exception
	 */
	private boolean makeAPCFlatFile(List<APCInvoiceGRPVO> aPCInvoiceGRPVOs) throws Exception {
		String mqName = SubSystemConfigFactory.get("INV.OPUSINV_UBIZCOM_INVOICE.IBMMQ.QUEUE");
		String reString = "";
		
		// Creating flat file.
		StringBuffer flatBuffer = new StringBuffer();
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm"); 
		//Date dt = new Date();

		// Start Header.
		flatBuffer.append("$$$MSGSTART:");
		flatBuffer.append("NYK                 ARGCUS              APC       "); 
		String refNo = ReferenceNumberGeneratorBroker.getKey("INV","INV_EDI_SEQ");

		flatBuffer.append(refNo);
		flatBuffer.append("\n");
		// End Header.
		
		for (int i = 0; i < aPCInvoiceGRPVOs.size(); i++) {
			InvEDIHdrVO invEDIHdrVO = aPCInvoiceGRPVOs.get(i).getInvEDIHdrVO();
			
			String vvdCd = "";
			
			if(("CFDR").equals(invEDIHdrVO.getVslCd())){
				vvdCd = invEDIHdrVO.getTrnkVvdCd();
			} else {
				vvdCd = invEDIHdrVO.getVslCd().concat(invEDIHdrVO.getSkdVoyNo()).concat(invEDIHdrVO.getSkdDirCd());
			}
			
			VesselInfoVO vesselInfoVO = dbDao.searchVesselInfo(vvdCd, invEDIHdrVO.getIoBndCd(), invEDIHdrVO.getPolCd(), invEDIHdrVO.getPodCd());
			String vslCode = "";
			String voyage = "";
			String conVoyage = "";
			String vslName = "";
			String voyageYear = "";
			String finalEta = ""; 
			String skdDir = "";
			if(vesselInfoVO != null){
				vslCode = vesselInfoVO.getVslCd();   
				voyage = vesselInfoVO.getSkdVoyNo();    
				conVoyage = vesselInfoVO.getCssmVoyNo(); 
				vslName = vesselInfoVO.getVslEngNm();   
				voyageYear = vesselInfoVO.getVoyYr();
				finalEta = vesselInfoVO.getFnlEtaDt();  
				skdDir = vesselInfoVO.getSkdDirCd();
			}
			
			LocationInfoVO polLocationInfoVO = dbDao.searchLocationInfo(invEDIHdrVO.getPolCd());
			String polNm = "";
			if(polLocationInfoVO != null){
				polNm = polLocationInfoVO.getLocNm();
			}
			
			LocationInfoVO podLocationInfoVO = dbDao.searchLocationInfo(invEDIHdrVO.getPodCd());
			String podNm = "";
			if(podLocationInfoVO != null){
				podNm = podLocationInfoVO.getLocNm();
			}
			
			CustomerInfoVO customerInfoVO = null;
			List<CustomerInfoVO> customerInfoVOs = dbDao.searchCustomerInfo(invEDIHdrVO.getActCustCntCd(), invEDIHdrVO.getActCustSeq(), invEDIHdrVO.getBkgNo(), "");
			if(customerInfoVOs != null && customerInfoVOs.size() > 0 ) {
				customerInfoVO = customerInfoVOs.get(0);
			}
			String exptPayerNm = "";
			String custRgstNo = "";
			String exptPayerAddr = "";
			String exptPayerCity = "";
			String exptPayerZipcode = "";
			if(customerInfoVO != null){
				exptPayerNm = customerInfoVO.getCustLglEngNm();
				custRgstNo = customerInfoVO.getCustRgstNo();
				exptPayerAddr = customerInfoVO.getAddr();
				exptPayerCity = customerInfoVO.getCtyNm();
				exptPayerZipcode = customerInfoVO.getZipCd();
			}
			
			BLIssueInfoVO bLIssueInfoVO = dbDao.searchBLIssueInfo(invEDIHdrVO.getArOfcCd(), invEDIHdrVO.getBkgNo());
			String consolidateInd = "";
			String blplace = ""; 
			String blissuer = "";
			if(bLIssueInfoVO != null){
				consolidateInd = bLIssueInfoVO.getConInd();
				blplace = bLIssueInfoVO.getBlPlace();
				blissuer = bLIssueInfoVO.getBlIssuer();
			} else {
				consolidateInd = "N";
				blplace = "BA";
				blissuer = "APC";
			}
			
			List<InvEDIChgVO> invEDIChgVOs = aPCInvoiceGRPVOs.get(i).getInvEDIChgVOs();
			
			for (int j = 0; j < invEDIChgVOs.size(); j++) {
				InvEDIChgVO invEDIChgVO = invEDIChgVOs.get(j);
					
				flatBuffer.append("{CHARGE\n");
				
				String status = "";
				
				if(("M").equals(invEDIHdrVO.getRevTpCd())){
					status = invEDIChgVO.getChgAmt().indexOf("-") == -1?"9":"3";
				} else {
					status = ("N").equals(invEDIHdrVO.getInvDeltDivCd())?"9":"3";
				}
				
				flatBuffer.append("STATUS:" + status + "\n");
				flatBuffer.append("LINE_REF_NO:" + invEDIChgVO.getChgRefNo() + "\n");
				String exInd = ("O").equals(invEDIHdrVO.getIoBndCd())?"E":"I";
				flatBuffer.append("EX_IND:" + exInd + "\n");
				String invoicType = "";
				if(invEDIHdrVO.getRevTpSrcCd().startsWith("M")){
					invoicType = "Y";
				} else {
					invoicType = "N";
				}
				flatBuffer.append("INVOIC_TYPE:" + invoicType + "\n");
				flatBuffer.append("VSL_CODE:" + vslCode + "\n");
				flatBuffer.append("VOYAGE:" + voyage + skdDir + "\n");
				flatBuffer.append("CON_VOYAGE:" + conVoyage + "\n");
				flatBuffer.append("VSL_NAME:" + vslName + "\n");
				flatBuffer.append("VOYAGE_YEAR:" + voyageYear + "\n");
				flatBuffer.append("FINAL_ETA:" + finalEta + "\n");
				flatBuffer.append("POL:" + invEDIHdrVO.getPolCd() + "\n");	
				flatBuffer.append("POL_NM:" + polNm + "\n");	
				flatBuffer.append("POD:" + invEDIHdrVO.getPodCd() + "\n");	
				flatBuffer.append("POD_NM:" + podNm + "\n");	
				flatBuffer.append("EXPT_PAYER_ID:" + invEDIHdrVO.getActCustCntCd().concat(JSPUtil.getLPAD(invEDIHdrVO.getActCustSeq(), 6, "0")) + "\n");
				flatBuffer.append("EXPT_PAYER_NM:" + exptPayerNm + "\n");
				
				String exptPayerDocType = "";
				String exptPayerDocNo = "";
				
				if(custRgstNo.contains("CUIT") && custRgstNo.length() > 4){
					exptPayerDocType = "CUIT";
					exptPayerDocNo = custRgstNo.substring(4);
				}else if(custRgstNo.contains("CUIL") && custRgstNo.length() > 4){
					exptPayerDocType = "CUIL";
					exptPayerDocNo = custRgstNo.substring(4);
				}else if(custRgstNo.contains("DNI") && custRgstNo.length() > 3){
					exptPayerDocType = "DNI";
					exptPayerDocNo = custRgstNo.substring(3);
				}else if(custRgstNo.contains("CI") && custRgstNo.length() > 2){
					exptPayerDocType = "CI";
					exptPayerDocNo = custRgstNo.substring(2);
				}else if(custRgstNo.contains("LC") && custRgstNo.length() > 2){
					exptPayerDocType = "LC";
					exptPayerDocNo = custRgstNo.substring(2);
				}else if(custRgstNo.contains("LE") && custRgstNo.length() > 2){
					exptPayerDocType = "LE";
					exptPayerDocNo = custRgstNo.substring(2);
				}else if(custRgstNo.contains("PAS") && custRgstNo.length() > 3){
					exptPayerDocType = "PAS";
					exptPayerDocNo = custRgstNo.substring(3);
				}else if(custRgstNo.contains("OTHER") && custRgstNo.length() > 5){
					exptPayerDocType = "OTHER";
					exptPayerDocNo = custRgstNo.substring(5);
				}
					
				flatBuffer.append("EXPT_PAYER_DOC_TYPE:" + exptPayerDocType + "\n");
				flatBuffer.append("EXPT_PAYER_DOC_NO:" + exptPayerDocNo + "\n");
				flatBuffer.append("EXPT_PAYER_ADDR:" + exptPayerAddr + "\n");
				flatBuffer.append("EXPT_PAYER_CITY:" + exptPayerCity + "\n");
				flatBuffer.append("EXPT_PAYER_ZIPCODE:" + exptPayerZipcode + "\n");
				String cashFlg = ("N").equals(invEDIHdrVO.getCustCrFlg())?"Y":"N";
				flatBuffer.append("CASH_FLAG:" + cashFlg + "\n"); 
				flatBuffer.append("PAY_COND:" + invEDIHdrVO.getPayCond() + "\n");
				flatBuffer.append("CHARGE_CD:" + invEDIChgVO.getChgCd() + "\n");
				
				flatBuffer.append("CHARGE_QTY:" + "1" + "\n");
				flatBuffer.append("CHARGE_UNIT_AMT:" + invEDIChgVO.getChgAmt().replace("-", "") + "\n");
				
				flatBuffer.append("CHARGE_CURR_CD:" + invEDIChgVO.getCurrCd() + "\n");
				flatBuffer.append("CHARGE_DESC:" + "" + "\n");
				flatBuffer.append("VAT_INCLUDE_IND:" + invEDIChgVO.getTvaFlg() + "\n");
				flatBuffer.append("VAT_RATE:" + "21" + "\n");
				String payType = ("N").equals(invEDIHdrVO.getCustCrFlg())?"CON":"CTA";
				flatBuffer.append("PAY_TYPE:" + payType + "\n"); 
				flatBuffer.append("BLNBR:" + invEDIHdrVO.getBlNo() + "\n"); 
				flatBuffer.append("CONSOLIDATE_IND:" + consolidateInd + "\n"); 
				flatBuffer.append("BLPLACE:" + blplace + "\n"); 
				flatBuffer.append("BLISSUER:" + blissuer + "\n"); 
				
				String cntrNo = "";
				String cntrTp = "";
				String cntrFmInd = "";
				
				cntrNo = invEDIChgVO.getCntrNo();
				cntrTp = invEDIChgVO.getCntrTpszCd();
				cntrFmInd = dbDao.searchContainerFMInd(invEDIHdrVO.getIoBndCd(), invEDIHdrVO.getBkgNo(), invEDIChgVO.getCntrNo());
				
				flatBuffer.append("CNTRNBR:" + cntrNo + "\n"); 
				flatBuffer.append("CNTR_TS:" + cntrTp + "\n"); 
				flatBuffer.append("CNTR_FM_IND:" + cntrFmInd + "\n");
				
				String toDate = dbDao.searchContainerToDate(invEDIHdrVO.getRevTpSrcCd(), invEDIHdrVO.getInvNo(), invEDIChgVO.getCntrNo());
				
				flatBuffer.append("CNTR_TODATE:" + toDate + "\n");
				flatBuffer.append("}CHARGE\n");
			
			}
		}
	
		log.debug("### Flat File\n" + flatBuffer.toString());
		
		reString = eaiDao.sendToEDI(mqName, flatBuffer.toString());
		log.debug("### reString=="+reString);
		
		for (int i = 0; i < aPCInvoiceGRPVOs.size(); i++) {
			InvEDIHdrVO invEDIHdrVO = aPCInvoiceGRPVOs.get(i).getInvEDIHdrVO();
			dbDao.modifyInvoiceEDISendFlag(invEDIHdrVO.getEdiHdrSeq(), reString, invEDIHdrVO.getUpdUsrId(), "");
		}	
		
		if (!reString.equals("E")) {
			
			return true;
		}

		return false;
	}
	
    /**
     * INVOICEBL EDI SEND
     * 
     * @param InvEDIHdrVO invEDIHdrVO  
     * @param String usrId  
     * @return boolean
     * @exception EventException
     */
    public boolean createInvoiceBlEdi(InvEDIHdrVO invEDIHdrVO, String usrId) throws EventException {
    	String mqName = SubSystemConfigFactory.get("INV.OPUSINV_UBIZCOM_INVOICE.IBMMQ.QUEUE");
    	String reString = "";
        try {
    		log.debug("#####################################################");
            log.debug(" Flat File start ");
            log.debug("#####################################################");
            StringBuffer sbuff = null;
            sbuff = new StringBuffer();
            
            String[] custInfo = dbDao.searchEDICustInfo(invEDIHdrVO.getActCustCntCd(),invEDIHdrVO.getActCustSeq());
            
            String strRcvId = custInfo[1];
            String strSndrId = custInfo[2];
            
            // Header
            String strEdiHeader = dbDao.searchEdiHeader(strSndrId, strRcvId, "INVOICEBL");
            log.debug("\n******************** edi_header ********************\n" + strEdiHeader);
            sbuff.append(strEdiHeader + "\n");
            sbuff.append("{INVOICEBL\n");
            
            sbuff.append("INV_NO:" + invEDIHdrVO.getInvNo() + "\n");
            sbuff.append("ORG_INV_NO:" + dbDao.searchORGInvNo(invEDIHdrVO) + "\n");
            sbuff.append("INV_DT:" + invEDIHdrVO.getInvDt() + "\n");

            String strInvInfo = null;
            
            strInvInfo = dbDao.searchInvInfo(invEDIHdrVO);
            log.debug("\n******************** strInvInfo ********************\n" + strInvInfo);
            sbuff.append(strInvInfo);
            
            
            
            String strRefInfo = null;
            
            strRefInfo = dbDao.searchInvRefInfo(invEDIHdrVO);
            log.debug("\n******************** strRefInfo ********************\n" + strRefInfo);
            sbuff.append(strRefInfo);
            
            String tmpCntrDesc = "{CNTR_INFO\n"
                    + "CNTRNBR:\n"
                    + "CNTRTYPE:\n"
                    + "POR_HAUL_CD:\n"
                    + "POD_HAUL_CD:\n";
 
            List<DblEdiCntrVO> cntrList = dbDao.searchInvoiceEdiCntr(invEDIHdrVO);
            int cntrCnt = cntrList == null ? 0 : cntrList.size();
            if(cntrCnt > 0){
            	for(int m=0;m<cntrCnt;m++){
            		DblEdiCntrVO ediCntrVO = cntrList.get(m);

			         log.debug("\n******************** cntr ********************\n" + ediCntrVO.getBkgCntr());
			         sbuff.append((ediCntrVO.getBkgCntr()==null || ediCntrVO.getBkgCntr().equals(""))?tmpCntrDesc:ediCntrVO.getBkgCntr());
			         
			         String strCntrSeal = dbDao.searchInvoiceEdiCntrSeal(invEDIHdrVO, ediCntrVO.getCntrNo());
			         log.debug("\n******************** cntr_seal ********************\n" + strCntrSeal);
			         sbuff.append(strCntrSeal);
			         
			         String strCntrChgInfo = dbDao.searchInvoiceEdiCntrChgInfo(invEDIHdrVO, ediCntrVO.getCntrNo());
			         log.debug("\n******************** searchInvoiceEdiCntrChgInfo ********************\n" + strCntrChgInfo);
			         sbuff.append(strCntrChgInfo);
			         
			         String strCntrMf = dbDao.searchInvoiceEdiCntrMf(invEDIHdrVO, ediCntrVO.getCntrNo());
			         log.debug("\n******************** cntr_mf ********************\n" + strCntrMf);
			         sbuff.append(strCntrMf);
			         
			         sbuff.append("}CNTR_INFO\n");

            	}
            }else{
			     sbuff.append(tmpCntrDesc);
			     sbuff.append("{PKG_INFO\n"
			             + "PKG_LVL:\n"
			             + "PKG_QTY:\n"
			             + "PKG_UNIT:\n"
			             + "PKG_UNIT_DESC:\n"
			             + "}PKG_INFO\n"
			             + "{MEA_INFO\n"
			             + "MEA_UNIT:\n"
			             + "MEA_QTY:\n"
			             + "}MEA_INFO\n"
			             + "{SEAL_INFO\n"
			             + "SEAL_NO:\n"
			             + "}SEAL_INFO:\n"
			             + "{CNTR_CHARGE_INFO\n"
			             + "CHARGE_CD:\n"
			             + "CHARGE_DESC:\n"
			             + "CHARGE_TP_NM:\n"
			             + "CHARGE_CURR:\n"
			             + "CHARGE_AMT:\n"
			             + "CHARGE_AMT_USD:\n"
			             + "INV_CURR:\n"
			             + "INV_CURR_AMT:\n"
			             + "INV_TAX:\n"
			             + "INV_CURR_TTL_AMT:\n"
			             + "LOCAL_CURR:\n"
			             + "LOCAL_CURR_AMT:\n"
			             + "LOCAL_TAX:\n"
			             + "LOCAL_CURR_TTL_AMT:\n"
			             + "FRT_IND:\n"
			             + "RATED_AS:\n"
			             + "RATE:\n"
			             + "INV_EX_RATE:\n"
			             + "TAX_RATE:\n"
			             + "PERTYPE:\n"
			             + "TARIFF:\n"
			             + "}CNTR_CHARGE_INFO\n"
			             + "{CM_INFO\n"
			             + "CMD_CD:\n"
			             + "CMD_DESC:\n"
			             + "{PKG_INFO\n"
			             + "CM_PKG_LVL:\n"
			             + "CM_PKG_UNIT:\n"
			             + "CM_PKG_UNIT_DESC:\n"
			             + "}PKG_INFO\n"
			             + "{MEA_INFO\n"
			             + "CM_MEA_TP_CD:\n"
			             + "CM_MEA_UNIT:\n"
			             + "CM_MEA_QTY:\n"
			             + "}MEA_INFO\n"
			             + "}CNTR_INFO\n");
            	}
           
            String strInvVslInfo = null;
            
            strInvVslInfo = dbDao.searchInvoiceVslInfo(invEDIHdrVO);
            log.debug("\n******************** strInvVslInfo ********************\n" + strInvVslInfo);
            sbuff.append(strInvVslInfo);
            
            String strInvLocInfo = null;
            
            strInvLocInfo = dbDao.searchInvoiceLocInfo(invEDIHdrVO);
            log.debug("\n******************** strInvLocInfo ********************\n" + strInvLocInfo);
            sbuff.append(strInvLocInfo);
            
            String strInvCustInfo = null;
            
            strInvCustInfo = dbDao.searchInvoiceCustInfo(invEDIHdrVO);
            log.debug("\n******************** strInvCustInfo ********************\n" + strInvCustInfo);
            sbuff.append(strInvCustInfo);
            
            String strInvChgInfo = null;
            
            strInvChgInfo = dbDao.searchInvoiceChgInfo(invEDIHdrVO);
            log.debug("\n******************** strInvChgInfo ********************\n" + strInvChgInfo);
            sbuff.append(strInvChgInfo);
            
            sbuff.append("}INVOICEBL\n");
            
            
            log.debug("### Flat File\n" + sbuff.toString());
    		
    		reString = eaiDao.sendToEDI(mqName, sbuff.toString());
    	    log.debug("### reString=="+reString);

    		dbDao.modifyInvoiceEDISendFlag(invEDIHdrVO.getEdiHdrSeq(), reString, usrId, invEDIHdrVO.getEdiHdrSeq());
    		
    		if (!reString.equals("E")) {
    			
    			return true;
    		}

    		return false;

        } catch(EventException ex) {
        	throw ex;	
        } catch(DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

    }
	
}
