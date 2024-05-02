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
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.basic;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration.AccountReceivableEDISendDBDAO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration.AccountReceivableEDISendEAIDAO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASEdiChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASEdiCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASEdiCurrTotalVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASEdiCustInfoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASEdiMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASEdiSeqNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASEdiTotalVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASEdiUserVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.ADIDASInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLEdiChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLEdiCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLEdiCurrTotalVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLEdiMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLEdiSeqNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLEdiTotalVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLEdiUserVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.DHLInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.GlovisEdiMsgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.GlovisInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.GlovisInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HNWLEdiChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HNWLEdiCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HNWLEdiMainVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HNWLInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HNWLEdiBkgCustVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HPEDISendVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HPInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HPInvoiceEDIChargeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HPInvoiceEDIHeaderVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.HPInvoiceEDIVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.InvEdiMGBChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.InvEdiMGBHdrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.InvEdiNikeChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.InvEdiNikeHdrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.MGBInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.MGBInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.NikeInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.NikeInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.PHILSEdiBkgBlDocVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.PHILSEdiBkgCustVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.PHILSEdiBkgCustTpVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.PHILSEdiChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.PHILSEdiCntrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.PHILSEdiVvdVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.PHILSInvoiceEdiVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.PHILSEdiBkgVvdVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungEDIBLChargeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungEDISendBLVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungEDISendChargeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungEDISendVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungInPutVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungInvoiceEDIBLVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungInvoiceEDIChargeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungInvoiceEDIHeaderVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungInvoiceEDIVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo.SamsungMSGVO;
import com.hanjin.framework.component.ftp.Ftp;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.InvEdiGlovisChgVO;
import com.hanjin.syscommon.common.table.InvEdiGlovisHdrVO;

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
	 * 조회 이벤트 처리<br>
	 * 입력한 VVD 및 삼성업체명에 대해 기 EDI 정보로 생성된 문서번호(message no)정보를 조회한다.<br>
	 * 
	 * @param SamsungInPutVO samInPutVo
	 * @return SamsungInvoiceEDIVO
	 * @exception EventException
	 */
	public SamsungInvoiceEDIVO searchSamsungEDIMSGNo(SamsungInPutVO samInPutVo) throws EventException {
		SamsungInvoiceEDIVO samsungInvoiceEDIVO = new SamsungInvoiceEDIVO();

		try {
			List<SamsungMSGVO> list = dbDao.searchSamsungEDIMSGNoList(samInPutVo);
			if (list != null && list.size() > 0) {
				samsungInvoiceEDIVO.setSamsungMSGList(list);
				
				// 'Retrieve for revised amount ' check box를 Check 하고 조회시 문서번호를 조회하지 않고 INV_AR_MN, INV_AR_CHG의 기초데이터를 조회함.
				if (samInPutVo.getRevisedAmount().equals("Y")) {
					samsungInvoiceEDIVO.setSamsungInvoiceEDIHeader(dbDao.searchSamsungARInvoiceMain(samInPutVo));
					samsungInvoiceEDIVO.setSamsungEDIBLChargeList(dbDao.searchSamsungARInvoiceList(samInPutVo));
				}		
			} else {
				samsungInvoiceEDIVO.setSamsungInvoiceEDIHeader(dbDao.searchSamsungARInvoiceMain(samInPutVo));
				samsungInvoiceEDIVO.setSamsungEDIBLChargeList(dbDao.searchSamsungARInvoiceList(samInPutVo));
			}
			
			return samsungInvoiceEDIVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * 삼성전자의 EDI 전송할 Account Receivable 정보를 조회한다.<br>
	 * 
	 * @param String msgId
	 * @param String msgNo
	 * @return SamsungInvoiceEDIVO
	 * @exception EventException
	 */
	public SamsungInvoiceEDIVO searchSamsungAREDIList(String msgId, String msgNo) throws EventException {
		SamsungInvoiceEDIVO samsungInvoiceEDIVO = new SamsungInvoiceEDIVO();

		try {
			samsungInvoiceEDIVO.setSamsungInvoiceEDIHeader(dbDao.searchSamsungAREDIMain(msgId, msgNo));
			samsungInvoiceEDIVO.setSamsungEDIBLChargeList(dbDao.searchSamsungAREDIList(msgId, msgNo));

			return samsungInvoiceEDIVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}

	/**
	 * 새로운 Message No로 삼성전자의 EDI 전송할 Account Receivable 정보를 생성한다.<br>
	 * 
	 * @author JungJin Park
	 * @param SamsungInvoiceEDIVO creSamVo
	 * @return String
	 * @exception EventException
	 */
	public String createSamsungAREDIList(SamsungInvoiceEDIVO creSamVo) throws EventException {
		String msgNo = null;
		String blLineNo = null;
		String creUsrId = null;
		String updUsrId = null;
		String rcvrNm = null;

		int bilKrwAmt = 0;
		float bilUsdAmt = 0;

		List<SamsungEDIBLChargeVO> samBLChargeVo = new ArrayList<SamsungEDIBLChargeVO>();

		SamsungInvoiceEDIHeaderVO samheadVo = new SamsungInvoiceEDIHeaderVO();
		List<SamsungInvoiceEDIBLVO> samBLVos = new ArrayList<SamsungInvoiceEDIBLVO>();
		List<SamsungInvoiceEDIChargeVO> samChgVos = new ArrayList<SamsungInvoiceEDIChargeVO>();
		SamsungInvoiceEDIChargeVO chargeVO = new SamsungInvoiceEDIChargeVO();
		try {
			if (creSamVo != null) {
				creUsrId = creSamVo.getCreUsrId();
				updUsrId = creSamVo.getUpdUsrId();

				// INV_AR_EDI_GERP_HDR 시작
				samheadVo = creSamVo.getSamsungInvoiceEDIHeader();
				msgNo = dbDao.searchSamSungNextMsgNo();

				// [CHM-201216560-01] by Sang-Hyun Kim - 2012.03.06
				// [CHM-201216902] by Min Kwon - 2012.03.27
				// 삼성전자CS센터
				if (samheadVo.getRcvrId().equals("C1T0P")) {			
				    rcvrNm = "삼성디스플레이(주)";			
				} else if(samheadVo.getRcvrId().equals("C1T0X")){
					rcvrNm = "삼성메디슨";
				} else {			
				    rcvrNm = "삼성전자로지텍(주)";			
				}			

				samheadVo.setMsgId("FREINV");
				samheadVo.setMsgNo(msgNo);
				//samheadVo.setSndrId("C1T0WA5G8");
				//samheadVo.setSndrId("C1T0WDZEV");   2018.01.19 Sender ID 변경
				samheadVo.setSndrId("C1T0WE04S");
				samheadVo.setSndrNm("에스엠해운");
				samheadVo.setRcvrNm(rcvrNm);
				samheadVo.setMsgNm("Freight Invoice");
				//samheadVo.setInvMsgFuncCd("9");
				samheadVo.setBilDt(samheadVo.getBilDt().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""));
				samheadVo.setBilKrwCurrCd("KRW");
				samheadVo.setBilUsdCurrCd("USD");
				samheadVo.setBilTaxAmt("0");
				samheadVo.setBilTaxCurrCd("KRW");
				samheadVo.setInvXchRt(samheadVo.getInvXchRt().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""));
				//samheadVo.setInvXchRt(samheadVo.getInvXchRt());
				samheadVo.setInvXchRtDt("");
				samheadVo.setVldChkFlg("N");
				samheadVo.setSndFlg("N");
				samheadVo.setCreUsrId(creUsrId);
				samheadVo.setUpdUsrId(updUsrId);
				samheadVo.setSailArrDt(samheadVo.getSailArrDt().replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", ""));

				String gerpCrrCd = "";
				String gerpCrrNm = "";
				// 삼성전자로지텍(OFS) 인 경우는 GERP_CRR_CD = 'HJSC', GERP_CRR_NM = 'HANJIN SHIPPING'
				if (samheadVo.getRcvrId().equals("FSELC")) {
//					gerpCrrCd = "HJSC";
//					gerpCrrNm = "HANJIN SHIPPING";
					gerpCrrCd = "SMLM";
					gerpCrrNm = "SM LINE CORPORATION";
				}

				samBLChargeVo = creSamVo.getSamsungEDIBLChargeList();

				if (creSamVo.getSamsungInvoiceEDIHeader().getInvMsgFuncCd().equals("7") && !creSamVo.getSamsungInvoiceEDIHeader().getForceToSave().equals("Y")) {
					for (int i=0; i<samBLChargeVo.size(); i++) {
						int rowCount = dbDao.searchSamsungInvNoDuplicate(samBLChargeVo.get(i));
						if (rowCount != 0) {
							return "Duplicated";
						}
					}
				}

				for (int i = 0; i < samBLChargeVo.size(); i++) {
					SamsungEDIBLChargeVO samsungEDIBLChargeVO = samBLChargeVo.get(i);

					if (!samsungEDIBLChargeVO.getBlSrcNo().equals("")) {
						blLineNo = String.valueOf(i + 1);

						// INV_AR_EDI_GERP_BL 시작
						SamsungInvoiceEDIBLVO samsungEDIBLVO = new SamsungInvoiceEDIBLVO();

						samsungEDIBLVO.setMsgId("FREINV");
						samsungEDIBLVO.setMsgNo(msgNo);
						samsungEDIBLVO.setBlLineNo(blLineNo);
						samsungEDIBLVO.setBlSrcNo(samsungEDIBLChargeVO.getBlSrcNo());
						// samsungEDIBLVO.setFctryCtnt(samheadVo.getOwnrNm()); //아래 주석으로 된 항목은 쿼리에서 조회하여 처리
						// samsungEDIBLVO.setFctryNm(samsungEDIBLChargeVO.getBlSrcNo()); //
						// samsungEDIBLVO.setDivCtnt(samsungEDIBLChargeVO.getBlSrcNo()); //
						// samsungEDIBLVO.setDivNm(samsungEDIBLChargeVO.getBlSrcNo()); //
						samsungEDIBLVO.setSrInvNo(samsungEDIBLChargeVO.getSrInvNo());
						String srInvNos[] = samsungEDIBLChargeVO.getSrInvNo().split("-");
						samsungEDIBLVO.setSrInvNoOrg(srInvNos[0]);
						// samsungEDIBLVO.setGerpTrspCd(samsungEDIBLChargeVO.getBlSrcNo()); //
						// samsungEDIBLVO.setGerpTrspNm(samsungEDIBLChargeVO.getBlSrcNo()); //
						// samsungEDIBLVO.setObrdDt(samsungEDIBLChargeVO.getBlSrcNo()); //
						samsungEDIBLVO.setGerpCrrCd(gerpCrrCd);
						samsungEDIBLVO.setGerpCrrNm(gerpCrrNm);
						samsungEDIBLVO.setPorCd(samsungEDIBLChargeVO.getPorCd());
						samsungEDIBLVO.setPolCd(samsungEDIBLChargeVO.getPolCd());
						samsungEDIBLVO.setPodCd(samsungEDIBLChargeVO.getPodCd());
						samsungEDIBLVO.setDelCd(samsungEDIBLChargeVO.getDelCd());
						// samsungEDIBLVO.setIssDt(samsungEDIBLChargeVO.getBlSrcNo()); //
						samsungEDIBLVO.setInvEdiD2Qty(samsungEDIBLChargeVO.getInvEdiD2Qty());
						samsungEDIBLVO.setInvEdiD4Qty(samsungEDIBLChargeVO.getInvEdiD4Qty());
						samsungEDIBLVO.setInvEdiD5Qty(samsungEDIBLChargeVO.getInvEdiD5Qty());
						samsungEDIBLVO.setInvEdiD7Qty(samsungEDIBLChargeVO.getInvEdiD7Qty());
						samsungEDIBLVO.setInvEdiEtcQty(samsungEDIBLChargeVO.getInvEdiEtcQty());
						samsungEDIBLVO.setGrsCntrWgt(samsungEDIBLChargeVO.getGrsCntrWgt());
						samsungEDIBLVO.setGrsCbmCapa(samsungEDIBLChargeVO.getGrsCbmCapa());
						samsungEDIBLVO.setBlCntrGrpCtnt(samsungEDIBLChargeVO.getBlCntrGrpCtnt());
						samsungEDIBLVO.setCreUsrId(creUsrId);
						samsungEDIBLVO.setUpdUsrId(updUsrId);

						//						
						samBLVos.add(samsungEDIBLVO);

						// INV_AR_EDI_GERP_CHG 입력 시작
						if (!samsungEDIBLChargeVO.getOftAmt().equals("") && Float.parseFloat(samsungEDIBLChargeVO.getOftAmt()) > 0) {
							chargeVO = new SamsungInvoiceEDIChargeVO();

							chargeVO.setMsgId("FREINV");
							chargeVO.setMsgNo(msgNo);
							chargeVO.setBlLineNo(blLineNo);
							chargeVO.setBlSrcNo(samsungEDIBLChargeVO.getBlSrcNo());
							chargeVO.setChgCd("OFT");
							chargeVO.setChgAmt(samsungEDIBLChargeVO.getOftAmt());
							chargeVO.setChgCurrCd("USD");
							chargeVO.setVatAmt("");
							chargeVO.setVatCurrCd("");
							chargeVO.setCreUsrId(creUsrId);
							chargeVO.setUpdUsrId(updUsrId);

							bilUsdAmt = bilUsdAmt + Float.parseFloat(samsungEDIBLChargeVO.getOftAmt());

							samChgVos.add(chargeVO);
						}
						if (!samsungEDIBLChargeVO.getThcAmt().equals("") && Integer.parseInt(samsungEDIBLChargeVO.getThcAmt()) > 0) {
							chargeVO = new SamsungInvoiceEDIChargeVO();

							chargeVO.setMsgId("FREINV");
							chargeVO.setMsgNo(msgNo);
							chargeVO.setBlLineNo(blLineNo);
							chargeVO.setBlSrcNo(samsungEDIBLChargeVO.getBlSrcNo());
							chargeVO.setChgCd("THC");
							chargeVO.setChgAmt(samsungEDIBLChargeVO.getThcAmt());
							chargeVO.setChgCurrCd("KRW");
							chargeVO.setVatAmt("");
							chargeVO.setVatCurrCd("");
							chargeVO.setCreUsrId(creUsrId);
							chargeVO.setUpdUsrId(updUsrId);

							bilKrwAmt = bilKrwAmt + Integer.parseInt(samsungEDIBLChargeVO.getThcAmt());

							samChgVos.add(chargeVO);
						}
						if (!samsungEDIBLChargeVO.getWhfAmt().equals("") && Integer.parseInt(samsungEDIBLChargeVO.getWhfAmt()) > 0) {
							chargeVO = new SamsungInvoiceEDIChargeVO();

							chargeVO.setMsgId("FREINV");
							chargeVO.setMsgNo(msgNo);
							chargeVO.setBlLineNo(blLineNo);
							chargeVO.setBlSrcNo(samsungEDIBLChargeVO.getBlSrcNo());
							chargeVO.setChgCd("WHF");
							chargeVO.setChgAmt(samsungEDIBLChargeVO.getWhfAmt());
							chargeVO.setChgCurrCd("KRW");
							chargeVO.setVatAmt("");
							chargeVO.setVatCurrCd("");
							chargeVO.setCreUsrId(creUsrId);
							chargeVO.setUpdUsrId(updUsrId);

							bilKrwAmt = bilKrwAmt + Integer.parseInt(samsungEDIBLChargeVO.getWhfAmt());

							samChgVos.add(chargeVO);
						}
						/* -- CFR 항목에서 삭제
						if (!samsungEDIBLChargeVO.getCfrAmt().equals("") && Integer.parseInt(samsungEDIBLChargeVO.getCfrAmt()) > 0) {
							chargeVO = new SamsungInvoiceEDIChargeVO();

							chargeVO.setMsgId("FREINV");
							chargeVO.setMsgNo(msgNo);
							chargeVO.setBlLineNo(blLineNo);
							chargeVO.setBlSrcNo(samsungEDIBLChargeVO.getBlSrcNo());
							chargeVO.setChgCd("CFR");
							chargeVO.setChgAmt(samsungEDIBLChargeVO.getCfrAmt());
							chargeVO.setChgCurrCd("KRW");
							chargeVO.setVatAmt("");
							chargeVO.setVatCurrCd("");
							chargeVO.setCreUsrId(creUsrId);
							chargeVO.setUpdUsrId(updUsrId);

							bilKrwAmt = bilKrwAmt + Integer.parseInt(samsungEDIBLChargeVO.getCfrAmt());

							samChgVos.add(chargeVO);
						}
						*/
						if (!samsungEDIBLChargeVO.getCmsAmt().equals("") && Float.parseFloat(samsungEDIBLChargeVO.getCmsAmt()) > 0) {
							chargeVO = new SamsungInvoiceEDIChargeVO();

							chargeVO.setMsgId("FREINV");
							chargeVO.setMsgNo(msgNo);
							chargeVO.setBlLineNo(blLineNo);
							chargeVO.setBlSrcNo(samsungEDIBLChargeVO.getBlSrcNo());
							chargeVO.setChgCd("CMS");
							chargeVO.setChgAmt(samsungEDIBLChargeVO.getCmsAmt());
							chargeVO.setChgCurrCd("USD");
							chargeVO.setVatAmt("");
							chargeVO.setVatCurrCd("");
							chargeVO.setCreUsrId(creUsrId);
							chargeVO.setUpdUsrId(updUsrId);

							bilUsdAmt = bilUsdAmt + Float.parseFloat(samsungEDIBLChargeVO.getCmsAmt());

							samChgVos.add(chargeVO);
						}
						if (!samsungEDIBLChargeVO.getDhfAmt().equals("") && Integer.parseInt(samsungEDIBLChargeVO.getDhfAmt()) > 0) {
							chargeVO = new SamsungInvoiceEDIChargeVO();

							chargeVO.setMsgId("FREINV");
							chargeVO.setMsgNo(msgNo);
							chargeVO.setBlLineNo(blLineNo);
							chargeVO.setBlSrcNo(samsungEDIBLChargeVO.getBlSrcNo());
							chargeVO.setChgCd("DHF");
							chargeVO.setChgAmt(samsungEDIBLChargeVO.getDhfAmt());
							chargeVO.setChgCurrCd("KRW");
							chargeVO.setVatAmt("");
							chargeVO.setVatCurrCd("");
							chargeVO.setCreUsrId(creUsrId);
							chargeVO.setUpdUsrId(updUsrId);

							bilKrwAmt = bilKrwAmt + Integer.parseInt(samsungEDIBLChargeVO.getDhfAmt());

							samChgVos.add(chargeVO);
						}
						if (!samsungEDIBLChargeVO.getOtrAmt().equals("") && Float.parseFloat(samsungEDIBLChargeVO.getOtrAmt()) > 0) {
							chargeVO = new SamsungInvoiceEDIChargeVO();

							chargeVO.setMsgId("FREINV");
							chargeVO.setMsgNo(msgNo);
							chargeVO.setBlLineNo(blLineNo);
							chargeVO.setBlSrcNo(samsungEDIBLChargeVO.getBlSrcNo());
							chargeVO.setChgCd("O/F");
							chargeVO.setChgAmt(samsungEDIBLChargeVO.getOtrAmt());
							chargeVO.setChgCurrCd("USD");
							chargeVO.setVatAmt("");
							chargeVO.setVatCurrCd("");
							chargeVO.setCreUsrId(creUsrId);
							chargeVO.setUpdUsrId(updUsrId);

							bilUsdAmt = bilUsdAmt + Float.parseFloat(samsungEDIBLChargeVO.getOtrAmt());

							samChgVos.add(chargeVO);
						}
						/* -- BAF 항목에서 삭제
						if (!samsungEDIBLChargeVO.getBafAmt().equals("") && Integer.parseInt(samsungEDIBLChargeVO.getBafAmt()) > 0) {
							chargeVO = new SamsungInvoiceEDIChargeVO();

							chargeVO.setMsgId("FREINV");
							chargeVO.setMsgNo(msgNo);
							chargeVO.setBlLineNo(blLineNo);
							chargeVO.setBlSrcNo(samsungEDIBLChargeVO.getBlSrcNo());
							chargeVO.setChgCd("BAF");
							chargeVO.setChgAmt(samsungEDIBLChargeVO.getBafAmt());
							chargeVO.setChgCurrCd("KRW");
							chargeVO.setVatAmt("");
							chargeVO.setVatCurrCd("");
							chargeVO.setCreUsrId(creUsrId);
							chargeVO.setUpdUsrId(updUsrId);

							bilKrwAmt = bilKrwAmt + Integer.parseInt(samsungEDIBLChargeVO.getBafAmt());

							samChgVos.add(chargeVO);
						}
						*/
						
						
						if (!samsungEDIBLChargeVO.getSlfAmt().equals("") && Integer.parseInt(samsungEDIBLChargeVO.getSlfAmt()) > 0) {
							chargeVO = new SamsungInvoiceEDIChargeVO();

							chargeVO.setMsgId("FREINV");
							chargeVO.setMsgNo(msgNo);
							chargeVO.setBlLineNo(blLineNo);
							chargeVO.setBlSrcNo(samsungEDIBLChargeVO.getBlSrcNo());
							chargeVO.setChgCd("SLF");
							chargeVO.setChgAmt(samsungEDIBLChargeVO.getSlfAmt());
							chargeVO.setChgCurrCd("KRW");
							chargeVO.setVatAmt("");
							chargeVO.setVatCurrCd("");
							chargeVO.setCreUsrId(creUsrId);
							chargeVO.setUpdUsrId(updUsrId);

							bilKrwAmt = bilKrwAmt + Integer.parseInt(samsungEDIBLChargeVO.getSlfAmt());

							samChgVos.add(chargeVO);
						}
						
						
						if (!samsungEDIBLChargeVO.getOthAmt().equals("") && Integer.parseInt(samsungEDIBLChargeVO.getOthAmt()) > 0) {
							chargeVO = new SamsungInvoiceEDIChargeVO();

							chargeVO.setMsgId("FREINV");
							chargeVO.setMsgNo(msgNo);
							chargeVO.setBlLineNo(blLineNo);
							chargeVO.setBlSrcNo(samsungEDIBLChargeVO.getBlSrcNo());
							chargeVO.setChgCd("XXX");
							chargeVO.setChgAmt(samsungEDIBLChargeVO.getOthAmt());
							chargeVO.setChgCurrCd("KRW");
							chargeVO.setVatAmt("");
							chargeVO.setVatCurrCd("");
							chargeVO.setCreUsrId(creUsrId);
							chargeVO.setUpdUsrId(updUsrId);

							samChgVos.add(chargeVO);
						}
					}
				}
			}

			samheadVo.setBilKrwAmt(String.valueOf(bilKrwAmt));
			samheadVo.setBilUsdAmt(String.valueOf(bilUsdAmt));

			dbDao.addSamsungEDIHeader(samheadVo);
			dbDao.addSamsungEDIBL(samBLVos);
			dbDao.addSamsungEDIChg(samChgVos);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}

		return msgNo;
	}

	/**
	 * 삼성전자의 EDI 전송 매출채권 정보를 삭제한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String msgId
	 * @param String msgNo
	 * @param String userId
	 * @exception EventException
	 */
	public void removeSamsungAREDIList(String msgId, String msgNo, String userId) throws EventException {
		try {
			if (msgId != null && msgNo != null && userId != null) {
				dbDao.modifySamsungDeleteFlag(msgId, msgNo, userId);
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}

	/**
	 * 삼성전자의 Account Receivable 정보를 EDI 로 전송한다.
	 * 
	 * @param sendSamVOs
	 * @param sendStartIdx
	 * @throws EventException
	 */
	public void sendSamsungAREDIList(List<SamsungEDISendVO> sendSamVOs, String sendStartIdx) throws EventException {
		StringBuffer flatFile = new StringBuffer();

		SamsungEDISendBLVO ediSendBL = new SamsungEDISendBLVO();
		List<SamsungEDISendChargeVO> ediSendChargeList = new ArrayList<SamsungEDISendChargeVO>();
		try {
			String mqName = SubSystemConfigFactory.get("INV.ALPSINV_UBIZHJS_INVOICE.IBMMQ.QUEUE");
			String reString = "";			
			float reqAmount = 0;
			float supAmount = 0;
			float taxAmount = 0;
			float ratExRate = 0;
			
			for (int i = 0; i < sendSamVOs.size(); i++) {
				SamsungEDISendVO sendSamVO = sendSamVOs.get(i);
				
				//Flate file작성시 사용할 실제 전송할 데이터 조회
				ediSendBL = dbDao.searchSamsungSendBL(sendSamVO);
				
				flatFile = new StringBuffer();
				int sendNum = (new Integer(sendStartIdx)).intValue() + i;
				
				if (ediSendBL != null) {
					sendSamVO.setSamsungEDISendBL(ediSendBL);

					flatFile.append("$$$MSGSTART:" + ediSendBL.getHeader()+JSPUtil.getLPAD(Integer.toString(sendNum), 3, "0"));

					flatFile.append("\n" + "MSG_NO:" + ediSendBL.getMsgNo());
					flatFile.append("\n" + "MSG_FUNC_CD:" + ediSendBL.getMsgFuncCd());
					flatFile.append("\n" + "DOC_NO:" + ediSendBL.getDocNo());
					flatFile.append("\n" + "DOC_DATE:" + ediSendBL.getDocDate());
					flatFile.append("\n" + "BILLING_DATE:" + ediSendBL.getBillingDate());
					flatFile.append("\n" + "DIV_TY_CD:" + ediSendBL.getDivTyCd());
					flatFile.append("\n" + "DIV_CD_DESC:" + ediSendBL.getDivCdDesc());
					//flatFile.append("\n" + "RLYDOC_MSG_NO:" + ediSendBL.getRlydocMsgNo());
					flatFile.append("\n" + "RLYDOC_MSG_NO:" + (ediSendBL.getRlydocMsgNo().equals("") ? " " : ediSendBL.getRlydocMsgNo()));
					flatFile.append("\n" + "RLYDOC_DOC_NO:" + ediSendBL.getRlydocDocNo());
					flatFile.append("\n" + "RLYDOC_DOC_DATE:" + ediSendBL.getRlydocDocDate());
					flatFile.append("\n" + "RLYDOC_NO1:" + ediSendBL.getRlydocDocNo1());
					flatFile.append("\n" + "RLYDOC_NO2:" + ediSendBL.getRlydocDocNo2());
					flatFile.append("\n" + "ACTUAL_DATE:" + ediSendBL.getActualDate());
					flatFile.append("\n" + "PLANT_CD:" + ediSendBL.getPlantCd());
					flatFile.append("\n" + "PLANT_DESC:" + ediSendBL.getPlantDesc());
					flatFile.append("\n" + "REMARK:" + ediSendBL.getRemark());
					 
					 //CUSTOMER CA
					flatFile.append("\n" + "{CUSTOMER");
					flatFile.append("\n" + "CUSTOMER_TP_CD:" + ediSendBL.getCustomerTpCdCa()); 
					flatFile.append("\n" + "CUST_CD:" + ediSendBL.getCustCdCa());
					flatFile.append("\n" + "CUST_NAME:" + ediSendBL.getCustNameCa());
					flatFile.append("\n" + "}CUSTOMER");
					 
					 //CUSTOMER FW
					flatFile.append("\n" + "{CUSTOMER");
					flatFile.append("\n" + "CUSTOMER_TP_CD:" + ediSendBL.getCustomerTpCdFw()); 
					flatFile.append("\n" + "CUST_CD:" + ediSendBL.getCustCdCa());
					flatFile.append("\n" + "CUST_NAME:" + ediSendBL.getCustNameCa());
					flatFile.append("\n" + "}CUSTOMER");
	
					 //LOCATION POR
					flatFile.append("\n" + "{LOCATION");
					flatFile.append("\n" + "LOC_TP_CD:" + ediSendBL.getLocTpCdPor()); 
					//flatFile.append("\n" + "LOC_CD:" + ediSendBL.getLocCdPor());					
					flatFile.append("\n" + "LOC_CD:" + (!ediSendBL.getLocCdPor().equals("") ? ediSendBL.getLocCdPor().substring(2, 5) : " "));
					flatFile.append("\n" + "LOC_NAME:" + ediSendBL.getLocNamePor());
					flatFile.append("\n" + "LOC_CNT_CD:" + ediSendBL.getLocCntCdPor());
					flatFile.append("\n" + "LOC_CNT_NAME:" + ediSendBL.getLocCntNamePor());
					flatFile.append("\n" + "}LOCATION");
					 //LOCATION POL
					flatFile.append("\n" + "{LOCATION");
					flatFile.append("\n" + "LOC_TP_CD:" + ediSendBL.getLocTpCdPol()); 
					//flatFile.append("\n" + "LOC_CD:" + ediSendBL.getLocCdPol());
					flatFile.append("\n" + "LOC_CD:" + (!ediSendBL.getLocCdPol().equals("") ? ediSendBL.getLocCdPol().substring(2, 5) : " "));
					flatFile.append("\n" + "LOC_NAME:" + ediSendBL.getLocNamePol());
					flatFile.append("\n" + "LOC_CNT_CD:" + ediSendBL.getLocCntCdPol());
					flatFile.append("\n" + "LOC_CNT_NAME:" + ediSendBL.getLocCntNamePol());
					flatFile.append("\n" + "}LOCATION");
					 //LOCATION POD
					flatFile.append("\n" + "{LOCATION");
					flatFile.append("\n" + "LOC_TP_CD:" + ediSendBL.getLocTpCdPod()); 
					//flatFile.append("\n" + "LOC_CD:" + ediSendBL.getLocCdPod());
					flatFile.append("\n" + "LOC_CD:" + (!ediSendBL.getLocCdPod().equals("") ? ediSendBL.getLocCdPod().substring(2, 5) : " "));
					flatFile.append("\n" + "LOC_NAME:" + ediSendBL.getLocNamePod());
					flatFile.append("\n" + "LOC_CNT_CD:" + ediSendBL.getLocCntCdPod());
					flatFile.append("\n" + "LOC_CNT_NAME:" + ediSendBL.getLocCntNamePod());
					flatFile.append("\n" + "}LOCATION");
					 //LOCATION DEL
					flatFile.append("\n" + "{LOCATION");
					flatFile.append("\n" + "LOC_TP_CD:" + ediSendBL.getLocTpCdDel()); 
					//flatFile.append("\n" + "LOC_CD:" + ediSendBL.getLocCdDel());
					flatFile.append("\n" + "LOC_CD:" + (!ediSendBL.getLocCdDel().equals("") ? ediSendBL.getLocCdDel().substring(2, 5) : " "));
					flatFile.append("\n" + "LOC_NAME:" + ediSendBL.getLocNameDel());
					flatFile.append("\n" + "LOC_CNT_CD:" + ediSendBL.getLocCntCdDel());
					flatFile.append("\n" + "LOC_CNT_NAME:" + ediSendBL.getLocCntNameDel());
					flatFile.append("\n" + "}LOCATION");
					 //MSR_LIST
					flatFile.append("\n" + "{MSR_LIST");
					flatFile.append("\n" + "CS_MEA_CD:" + ediSendBL.getCsMeaCd()); 
					flatFile.append("\n" + "MEA_QTY:" + ediSendBL.getMeaQty());
					flatFile.append("\n" + "MEA_CD:" + ediSendBL.getMeaCd());
					flatFile.append("\n" + "}MSR_LIST");
					
					//Flate file작성시 사용할 실제 전송할 데이터 charge 조회
					ediSendChargeList = dbDao.searchSamsungSendChgByBL(sendSamVO);
					
					for (int j = 0; j < ediSendChargeList.size(); j++) {
						SamsungEDISendChargeVO ediSendCharge = ediSendChargeList.get(j);
						
						reqAmount = Float.parseFloat(ediSendCharge.getReqAmount());
						supAmount = Float.parseFloat(ediSendCharge.getSupAmount());
						taxAmount = Float.parseFloat(ediSendCharge.getTaxAmount());
						ratExRate = Float.parseFloat(ediSendCharge.getRatExRate());
						
						 //FRE_LIST
						flatFile.append("\n" + "{FRE_LIST");
						flatFile.append("\n" + "CHARGE_CD:" + ediSendCharge.getChargeCd()); 
						//flatFile.append("\n" + "FRT_ISSUE_DATE:" + ediSendCharge.getFrtIssueDate());
						flatFile.append("\n" + "FRT_ISSUE_DATE:" + (ediSendCharge.getFrtIssueDate().equals("") ? " " : ediSendCharge.getFrtIssueDate()));
						//flatFile.append("\n" + "REQ_AMOUNT:" + ediSendCharge.getReqAmount()); 
						flatFile.append("\n" + "REQ_AMOUNT:" + String.format("%.2f", reqAmount));
						flatFile.append("\n" + "REQ_CUR_CD:" + ediSendCharge.getReqCurCd());
						//flatFile.append("\n" + "SUP_AMOUNT:" + ediSendCharge.getSupAmount());
						flatFile.append("\n" + "SUP_AMOUNT:" + String.format("%.2f", supAmount));
						flatFile.append("\n" + "SUP_CUR_CD:" + ediSendCharge.getSupCurCd());
						//flatFile.append("\n" + "TAX_AMOUNT:" + ediSendCharge.getTaxAmount()); 
						flatFile.append("\n" + "TAX_AMOUNT:" + String.format("%.2f", taxAmount));
						flatFile.append("\n" + "TAX_CUR_CD:" + ediSendCharge.getTaxCurCd());
						//flatFile.append("\n" + "RAT_EX_RATE:" + ediSendCharge.getRatExRate()); 
						flatFile.append("\n" + "RAT_EX_RATE:" + String.format("%.2f", ratExRate)); 
						flatFile.append("\n" + "BASIC_CUR_CD:" + ediSendCharge.getBasicCurCd());
						flatFile.append("\n" + "DEST_CUR_CD:" + ediSendCharge.getDestCurCd());
						//flatFile.append("\n" + "RAT_EX_RATE_DATE:" + ediSendCharge.getRatExRateDate());
						//flatFile.append("\n" + "RAT_EX_RATE_DATE:" + (ediSendCharge.getRatExRateDate().equals("") ? " " : ediSendCharge.getRatExRateDate()));
						flatFile.append("\n" + "RAT_EX_RATE_DATE:" + (ediSendBL.getActualDate().equals("") ? " " : ediSendBL.getActualDate()));
						flatFile.append("\n" + "}FRE_LIST");
						
					}
				}

				reString = eaiDao.sendToEDI(mqName, flatFile.toString());
			}
			
			if (!reString.equals("E")) {
				for (int i = 0; i < sendSamVOs.size(); i++) {
					SamsungEDISendVO sendSamVO = sendSamVOs.get(i);
					
					dbDao.modifySamSungHeader(sendSamVO.getMsgId(), sendSamVO.getMsgNo(), sendSamVO.getUpdUsrId());
					dbDao.modifySamsungBL(sendSamVO);
				}
			}
			else {
				throw new EventException("Data Transmitted Un-successufully!");
			}
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * EDI 전송가능한 대상을 입력된 BL NO로 조회한다.<br>
	 * 삼성전자의 EDI 전송할 Account Receivable 정보에 추가로 입력할 내용으로 입력된 BL NO에 대한 정보를 조회한다.<br>
	 * 
	 * @param SamsungInPutVO samInPutVo
	 * @param String blNo
	 * @return SamsungEDIBLChargeVO
	 * @exception EventException
	 */
	public SamsungEDIBLChargeVO searchSamsungEDIByBL(SamsungInPutVO samInPutVo, String blNo) throws EventException {
		SamsungEDIBLChargeVO samsungEDIBLChargeVO = new SamsungEDIBLChargeVO();
		try {
			samsungEDIBLChargeVO = dbDao.searchSamsungEDIByBL(samInPutVo, blNo);
			return samsungEDIBLChargeVO;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 입력한 ofc_Cd, bl_src_no Customer로 EDI 전송대상을 조회한다.<br>
	 * 
	 * @param HPInputVO hpInputVO
	 * @return List<HPInvoiceEDIVO>
	 * @exception EventException
	 */
	public List<HPInvoiceEDIVO> searchHPInvoiceEDIList(HPInputVO hpInputVO) throws EventException{
		try {			
			return dbDao.searchHPInvoiceEDIList(hpInputVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}
	
	/**
	 * HP EDI 정보를 전송한다.<br>
	 * 
	 * @param List<HPInvoiceEDIVO> hpInvoiceEDIVOs
	 * @param String usrId
	 * @exception EventException
	 */		
	public void sendHPEDIList (List<HPInvoiceEDIVO> hpInvoiceEDIVOs , String usrId) throws EventException{
		
		StringBuffer flatFile = new StringBuffer();
		HPEDISendVO hpEDISendVO = new HPEDISendVO();
		List<HPEDISendVO> hpEDISendCustVOs = new ArrayList<HPEDISendVO>();
		List<HPEDISendVO> hpEDISendLocVOs = new ArrayList<HPEDISendVO>();
		List<HPEDISendVO> hpEDISendCntrInfoVOs = new ArrayList<HPEDISendVO>();
		List<HPEDISendVO> hpEDISendChargeVOs = new ArrayList<HPEDISendVO>();
		List<HPEDISendVO> hpEDISendBkgVvdVOs = new ArrayList<HPEDISendVO>();
		
		try {
			String mqName = SubSystemConfigFactory.get("INV.ALPSINV_UBIZHJS_INVOICE.IBMMQ.QUEUE");
			String reString = "";
			String hpInvNo = "";
			String hpInvTpCd = "";
			
			for (int i = 0; i < hpInvoiceEDIVOs.size(); i++) {
				HPInvoiceEDIVO hpInvoiceEDIVO = hpInvoiceEDIVOs.get(i);
				
				HPInvoiceEDIHeaderVO hpInvoiceEDIHeaderVO = new HPInvoiceEDIHeaderVO();
				HPInvoiceEDIChargeVO hpInvoiceEDIChargeVO = new HPInvoiceEDIChargeVO();
				
				hpInvNo = hpInvoiceEDIVO.getInvNo().equals("")?hpInvoiceEDIVO.getBlSrcNo():hpInvoiceEDIVO.getInvNo();
				hpInvTpCd = "N";
					
				hpInvoiceEDIHeaderVO.setHpInvTpCd(hpInvTpCd);
				hpInvoiceEDIHeaderVO.setHpInvNo(hpInvNo);
				hpInvoiceEDIHeaderVO.setCreUsrId(usrId);
				hpInvoiceEDIHeaderVO.setUpdUsrId(usrId);
				hpInvoiceEDIHeaderVO.setInvNo(hpInvoiceEDIVO.getInvNo());
				hpInvoiceEDIHeaderVO.setBlSrcNo(hpInvoiceEDIVO.getBlSrcNo());
				
				
				String invSeq = dbDao.addHPEDIHeader(hpInvoiceEDIHeaderVO);
				
				hpInvoiceEDIChargeVO.setHpInvTpCd("N");
				hpInvoiceEDIChargeVO.setInvSeq(invSeq);
				hpInvoiceEDIChargeVO.setHpInvNo(hpInvNo);				
				hpInvoiceEDIChargeVO.setCreUsrId(usrId);
				hpInvoiceEDIChargeVO.setUpdUsrId(usrId);
				hpInvoiceEDIChargeVO.setInvNo(hpInvoiceEDIVO.getInvNo());
				hpInvoiceEDIChargeVO.setBlSrcNo(hpInvoiceEDIVO.getBlSrcNo());				
				
				dbDao.addHPEDIChg(hpInvoiceEDIChargeVO);
				
				//Flate file작성시 사용할 실제 전송할 데이터 조회
				hpEDISendVO = dbDao.searchHPEDIMakefile(hpInvoiceEDIVO);
				
				flatFile = new StringBuffer();
				
				if (hpInvoiceEDIVO != null) {
					
					//if (i == 0) {
						flatFile.append("$$$MSGSTART:" + hpEDISendVO.getHeader()+hpInvNo+invSeq);
					//}
					//else {
					//	flatFile.append("$$$MSGSTART:" + hpEDISendVO.getHeader()+JSPUtil.getLPAD(Integer.toString(i+1), 3, "0"));
					//}
					flatFile.append("\n" + "INV_TYPE:" + hpInvTpCd);
					flatFile.append("\n" + "INV_NUM:" + hpInvNo);
					flatFile.append("\n" + "BL_NUM:" + hpEDISendVO.getBlNum());
					flatFile.append("\n" + "INV_PAY:" + hpEDISendVO.getInvPay());
					flatFile.append("\n" + "INV_DATE:" + hpEDISendVO.getInvDate());
					flatFile.append("\n" + "INV_AMT:" + hpEDISendVO.getInvAmt());
					flatFile.append("\n" + "FINAL_ETA:" + hpEDISendVO.getFinalEta());
					flatFile.append("\n" + "INCO_TERM:" + hpEDISendVO.getIncoTerm());
					flatFile.append("\n" + "SCAC_CD:" + hpEDISendVO.getScacCd());
					flatFile.append("\n" + "COR_IND:" + "");
					flatFile.append("\n" + "CGO_RCV_DT:" + hpEDISendVO.getCgoRcvDt());
					flatFile.append("\n" + "TARIFF_SVC_CD:" + hpEDISendVO.getTariffSvcCd());
					flatFile.append("\n" + "VVD:" + hpEDISendVO.getVvd());
					flatFile.append("\n" + "VSL_LLOYDCODE:" + hpEDISendVO.getVslLloydcode());
					flatFile.append("\n" + "CURRENCY_BILL_CD:" + hpEDISendVO.getCurrencyBillCd());
					flatFile.append("\n" + "CURRENCY_LOC_CD:" +"EUR");
					
					//REFERENCE
					flatFile.append("\n" + "{REFERENCE");
					flatFile.append("\n" + "REF_4G:" + hpEDISendVO.getRef4g());
					flatFile.append("\n" + "REF_4L:" + hpEDISendVO.getRef4l());
					flatFile.append("\n" + "REF_4M:" + hpEDISendVO.getRef4m());
					flatFile.append("\n" + "REF_V9_ORI:" + hpEDISendVO.getRefV9Ori());
					flatFile.append("\n" + "REF_V9_DES:" + hpEDISendVO.getRefV9Des());
					flatFile.append("\n" + "REF_8X:" + hpEDISendVO.getRef8x());
					flatFile.append("\n" + "REF_BM:" + hpEDISendVO.getRefBm());
					flatFile.append("\n" + "REF_F2:" + hpEDISendVO.getRefF2());
					flatFile.append("\n" + "REF_FR:" + hpEDISendVO.getRefFr());
					flatFile.append("\n" + "REF_PID:" + hpEDISendVO.getRefPid());
					flatFile.append("\n" + "REF_T2:" + hpEDISendVO.getRefT2());
					flatFile.append("\n" + "REF_VC:" + hpEDISendVO.getRefVc());
					flatFile.append("\n" + "REF_VX:" + hpEDISendVO.getRefVx());
					flatFile.append("\n" + "REF_8V:" + (hpInvTpCd.equals("V")?hpEDISendVO.getRef8v():""));
					flatFile.append("\n" + "REF_ACB:" + hpEDISendVO.getRefAcb());
					flatFile.append("\n" + "}REFERENCE");
					 
					
					//Flat file작성시 사용할 실제 전송할 데이터 Customer 관련 조회
					hpEDISendCustVOs = dbDao.searchHPEDIMakefileCustomer(hpEDISendVO.getBkgNo(), hpEDISendVO.getMaxIfNo());
										
					for (int j = 0; j < hpEDISendCustVOs.size(); j++) {
						flatFile.append("\n" + "{CUSTOMER");						
						flatFile.append("\n" + "CUST_TP_CD:" + hpEDISendCustVOs.get(j).getCustTpCd()); 
						flatFile.append("\n" + "CUST_CD:" + hpEDISendCustVOs.get(j).getCustCd());
						flatFile.append("\n" + "CUST_NAME:" + hpEDISendCustVOs.get(j).getCustName());
						flatFile.append("\n" + "CUST_NAME1:" + hpEDISendCustVOs.get(j).getCustName1());
						flatFile.append("\n" + "CUST_NAME2:" + hpEDISendCustVOs.get(j).getCustName2());
						flatFile.append("\n" + "CUST_ADDR:" + hpEDISendCustVOs.get(j).getCustAddr());
						flatFile.append("\n" + "CUST_ADDR1:" + hpEDISendCustVOs.get(j).getCustAddr1());
						flatFile.append("\n" + "CUST_CITY:" + hpEDISendCustVOs.get(j).getCustCity());
						flatFile.append("\n" + "CUST_STATE:" + hpEDISendCustVOs.get(j).getCustState()); 
						flatFile.append("\n" + "CUST_POSTAL:" + hpEDISendCustVOs.get(j).getCustPostal());
						flatFile.append("\n" + "CUST_CNT_CD:" + hpEDISendCustVOs.get(j).getCustCntCd());
						flatFile.append("\n" + "}CUSTOMER");
					}
					
					//Flat file작성시 사용할 실제 전송할 데이터 Location 관련 조회
					hpEDISendLocVOs = dbDao.searchHPEDIMakefileLocation(hpEDISendVO.getBkgNo());
										
					for (int k = 0; k < hpEDISendLocVOs.size(); k++) {
						flatFile.append("\n" + "{LOCATION");						
						flatFile.append("\n" + "LOC_TP_CD:" + hpEDISendLocVOs.get(k).getLocTpCd()); 
						flatFile.append("\n" + "LOC_CD:" + hpEDISendLocVOs.get(k).getLocCd());
						flatFile.append("\n" + "LOC_NAME:" + hpEDISendLocVOs.get(k).getLocName());
						flatFile.append("\n" + "LOC_CNT_CD:" + hpEDISendLocVOs.get(k).getLocCntCd());
						flatFile.append("\n" + "LOC_CNT_NAME:" + hpEDISendLocVOs.get(k).getLocCntName());
						flatFile.append("\n" + "}LOCATION");
					}
					
					//Flat file작성시 사용할 실제 전송할 데이터 CntrInfo 관련 조회
					hpEDISendCntrInfoVOs = dbDao.searchHPEDIMakefileCntrInfo(hpEDISendVO.getBkgNo());
										
					for (int l = 0; l < hpEDISendCntrInfoVOs.size(); l++) {
						flatFile.append("\n" + "{CNTR_INFO");						
						flatFile.append("\n" + "CNTR_NO:" + hpEDISendCntrInfoVOs.get(l).getCntrNo()); 
						flatFile.append("\n" + "CNTR_TYPE:" + hpEDISendCntrInfoVOs.get(l).getCntrType());
						flatFile.append("\n" + "CNTR_LOAD:" + hpEDISendCntrInfoVOs.get(l).getCntrLoad());
						flatFile.append("\n" + "CNTR_SEAL_NO:" + hpEDISendCntrInfoVOs.get(l).getCntrSealNo());
						flatFile.append("\n" + "{MULTI_SHIP");	
						flatFile.append("\n" + "CNTR_SHIP_ID:" + hpEDISendCntrInfoVOs.get(l).getCntrShipId());
						flatFile.append("\n" + "}MULTI_SHIP");
						flatFile.append("\n" + "{CNTR_REF");	
						flatFile.append("\n" + "CN_REF_PO:" + hpEDISendCntrInfoVOs.get(l).getCnRefPo());
						flatFile.append("\n" + "CN_REF_PT:" + hpEDISendCntrInfoVOs.get(l).getCnRefPt());
						flatFile.append("\n" + "CN_REF_SI:" + hpEDISendCntrInfoVOs.get(l).getCnRefSi());
						flatFile.append("\n" + "}CNTR_REF");
						flatFile.append("\n" + "{CM_INFO");	
						flatFile.append("\n" + "CM_PKG:" + hpEDISendCntrInfoVOs.get(l).getCmPkg());
						flatFile.append("\n" + "CM_PKG_CD:" + hpEDISendCntrInfoVOs.get(l).getCmPkgCd());
						flatFile.append("\n" + "CM_WGT:" + hpEDISendCntrInfoVOs.get(l).getCmWgt());
						flatFile.append("\n" + "CM_WGT_CD:" + hpEDISendCntrInfoVOs.get(l).getCmWgtCd());
						flatFile.append("\n" + "CM_MEA:" + hpEDISendCntrInfoVOs.get(l).getCmMea());
						flatFile.append("\n" + "CM_MEA_CD:" + hpEDISendCntrInfoVOs.get(l).getCmMeaCd());
						flatFile.append("\n" + "CM_DESC:" + hpEDISendCntrInfoVOs.get(l).getCmDesc());
						flatFile.append("\n" + "}CM_INFO");
						flatFile.append("\n" + "}CNTR_INFO");
					}
					
					//Flat file작성시 사용할 실제 전송할 데이터 Charge 관련 조회
					hpEDISendChargeVOs = dbDao.searchHPEDIMakefileCharge(hpInvoiceEDIVO.getInvNo());
										
					for (int m = 0; m < hpEDISendChargeVOs.size(); m++) {
						
						String preChRateString = hpEDISendChargeVOs.get(m).getChRateString(); 
						String chRateString = "";
						
						if(preChRateString.equals("N")){
							chRateString = hpEDISendVO.getTariffSvcCd();
							
						}else {
							if(!preChRateString.equals("")){
								if(hpEDISendChargeVOs.get(m).getChFrtInd().equals("P")){
									chRateString = preChRateString+hpEDISendVO.getTariffSvcCd()+"_"+hpEDISendVO.getRefV9Ori();
								}else{
									chRateString = preChRateString+hpEDISendVO.getTariffSvcCd()+"_"+hpEDISendVO.getRefV9Des();
								}
							}
						}
						
						flatFile.append("\n" + "{CHARGE");						
						flatFile.append("\n" + "CH_FCTYPE:" + hpEDISendChargeVOs.get(m).getChFctype()); 
						flatFile.append("\n" + "CH_RATE:" + hpEDISendChargeVOs.get(m).getChRate());
						flatFile.append("\n" + "CH_RATED_AS:" + hpEDISendChargeVOs.get(m).getChRatedAs());
						flatFile.append("\n" + "CH_RATE_CHARGE:" + hpEDISendChargeVOs.get(m).getChRateCharge());
						flatFile.append("\n" + "CH_BILL_CHARGE:" + hpEDISendChargeVOs.get(m).getChBillCharge());
						flatFile.append("\n" + "CH_RATE_STRING:" + chRateString);
						flatFile.append("\n" + "CH_PERTYPE:" + hpEDISendChargeVOs.get(m).getChPertype());
						flatFile.append("\n" + "CH_CUR_CD:" + hpEDISendChargeVOs.get(m).getChCurCd());
						flatFile.append("\n" + "CH_BL_RATED_QTY:" + hpEDISendChargeVOs.get(m).getChBlRatedQty());
						flatFile.append("\n" + "CH_BL_RATED_QUAL:" + hpEDISendChargeVOs.get(m).getChBlRatedQual());
						flatFile.append("\n" + "CH_PERCENT:" + hpEDISendChargeVOs.get(m).getChPercent());
						flatFile.append("\n" + "CH_FRT_IND:" + hpEDISendChargeVOs.get(m).getChFrtInd());
						flatFile.append("\n" + "CH_BILL_CUR:" + hpEDISendChargeVOs.get(m).getChBillCur());
						flatFile.append("\n" + "CH_EX_RATE:" + hpEDISendChargeVOs.get(m).getChExRate());
						flatFile.append("\n" + "}CHARGE");
					}
					
					//Flat file작성시 사용할 실제 전송할 데이터 BKG VVD 관련 조회
					hpEDISendBkgVvdVOs = dbDao.searchHPEDIMakefileBkgVvd(hpEDISendVO.getBkgNo());
										
					for (int o = 0; o < hpEDISendBkgVvdVOs.size(); o++) {
						flatFile.append("\n" + "{BKGVVD");						
						flatFile.append("\n" + "VSL_BVVD1:" + hpEDISendBkgVvdVOs.get(o).getVslBvvd1()); 
						flatFile.append("\n" + "VSL_LLOYDCODE:" + hpEDISendBkgVvdVOs.get(o).getVslLloydcode());
						flatFile.append("\n" + "VSL_FULLNAME:" + hpEDISendBkgVvdVOs.get(o).getVslFullname());
						flatFile.append("\n" + "VSL_ORIGIN:" + hpEDISendBkgVvdVOs.get(o).getVslOrigin());
						flatFile.append("\n" + "VSL_POR:" + hpEDISendBkgVvdVOs.get(o).getVslPor());
						flatFile.append("\n" + "VSL_POL:" + hpEDISendBkgVvdVOs.get(o).getVslPol());
						flatFile.append("\n" + "VSL_POL_FULLNAME:" + hpEDISendBkgVvdVOs.get(o).getVslPolFullname());
						flatFile.append("\n" + "VSL_POD:" + hpEDISendBkgVvdVOs.get(o).getVslPod());
						flatFile.append("\n" + "VSL_DEL:" + hpEDISendBkgVvdVOs.get(o).getVslDel());
						flatFile.append("\n" + "TS_PRE:" + hpEDISendBkgVvdVOs.get(o).getTsPre());
						flatFile.append("\n" + "TS_POST:" + hpEDISendBkgVvdVOs.get(o).getTsPost());
						flatFile.append("\n" + "VSL_POD_FULLNAME:" + hpEDISendBkgVvdVOs.get(o).getVslPodFullname());
						flatFile.append("\n" + "VSL_POLETD:" + hpEDISendBkgVvdVOs.get(o).getVslPoletd());
						flatFile.append("\n" + "VSL_PODETA:" + hpEDISendBkgVvdVOs.get(o).getVslPodetd());
						flatFile.append("\n" + "}BKGVVD");
					}
										
				}
				
				log.debug("flatFile.toString() =="+flatFile.toString());
				
				reString = eaiDao.sendToEDI(mqName, flatFile.toString());
				
				log.debug("reString=="+reString);
				
				if (!reString.equals("E")) {
					dbDao.modifyHPEDIHeader(hpInvTpCd, hpInvNo, invSeq, usrId);
				}
			}
			
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}
	
	/**
	 * Glovis EDI 전송 대상및 내역 조회
	 * 
	 * @param GlovisInputVO glovisInputVO
	 * @return List<GlovisInvoiceEdiVO>
	 * @exception EventException
	 */
	public List<GlovisInvoiceEdiVO> searchEdiGlovisList(GlovisInputVO glovisInputVO)  throws EventException{
		try {			
			return dbDao.searchEdiGlovisList(glovisInputVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}
	
	/**
	 * Glovis EDI 를 전송한다 
	 * 
	 * @param List<GlovisInvoiceEdiVO> glovisInvoiceEdiVOs
	 * @param String usrId
	 * @param String btnFlag
	 * @exception DAOException
	 */
	public void sendEdiGlovisList (List<GlovisInvoiceEdiVO> glovisInvoiceEdiVOs,String usrId,String btnFlag) throws EventException {
		
		 GlovisInvoiceEdiVO glovisInvoiceEdiVO = null;		 
		 try{
			 String mqName = SubSystemConfigFactory.get("INV.ALPSINV_UBIZHJS_INVOICE.IBMMQ.QUEUE");		 
	 
			 for(int i=0;i<glovisInvoiceEdiVOs.size();i++){
				 int rtn = 0;
				 List<InvEdiGlovisHdrVO> send_vo             = new ArrayList<InvEdiGlovisHdrVO>(); // flat file 담을 VO
				 glovisInvoiceEdiVO                          = glovisInvoiceEdiVOs.get(i);
				 InvEdiGlovisHdrVO invEdiGlovisHdrVO         = new InvEdiGlovisHdrVO();	
				 InvEdiGlovisHdrVO ifSeqVO                   = new InvEdiGlovisHdrVO();
				 
				 GlovisInvoiceEdiVO approvalChgVO            = new GlovisInvoiceEdiVO();
				 InvEdiGlovisHdrVO approvalCheckVO           = new InvEdiGlovisHdrVO();
				 List<InvEdiGlovisHdrVO> approvalCheckVOs    = new ArrayList<InvEdiGlovisHdrVO>();
				 InvEdiGlovisChgVO invEdiGlovisChgVO         = new InvEdiGlovisChgVO();
				 List<GlovisEdiMsgVO> cancel_glovisEdiMsgVOs = new ArrayList<GlovisEdiMsgVO>();
				 List<GlovisEdiMsgVO> new_glovisEdiMsgVOs    = new ArrayList<GlovisEdiMsgVO>();
				 
				 InvEdiGlovisHdrVO       cancel_ffmsg        = new InvEdiGlovisHdrVO();
				 InvEdiGlovisHdrVO       new_ffmsg           = new InvEdiGlovisHdrVO();
				 
				 invEdiGlovisHdrVO.setCxlFlg("Y");	 
				 invEdiGlovisHdrVO.setArIfNo (glovisInvoiceEdiVO.getArIfNo());
				 invEdiGlovisHdrVO.setBlSrcNo(glovisInvoiceEdiVO.getBlSrcNo());
				 invEdiGlovisHdrVO.setInvNo(glovisInvoiceEdiVO.getInvNo());
				 invEdiGlovisHdrVO.setInvSeq("1");
				 invEdiGlovisHdrVO.setCustNm(glovisInvoiceEdiVO.getCustNm());
				 invEdiGlovisHdrVO.setCustEml(glovisInvoiceEdiVO.getCustEml());
				 invEdiGlovisHdrVO.setCustSeq(glovisInvoiceEdiVO.getCustSeq());
				 invEdiGlovisHdrVO.setIoBndCd(glovisInvoiceEdiVO.getIoBndCd());
				 invEdiGlovisHdrVO.setCustCntCd(glovisInvoiceEdiVO.getCustCd());				 				 
				 invEdiGlovisHdrVO.setSailArrDt(glovisInvoiceEdiVO.getSailArrDt());
				 invEdiGlovisHdrVO.setInvRmk(glovisInvoiceEdiVO.getInvRmk());				 
				 invEdiGlovisHdrVO.setCreUsrId(usrId);
				 invEdiGlovisHdrVO.setUpdUsrId(usrId);
				 
                 // 청구 승인 여부 확인
				 approvalCheckVOs = dbDao.searchEdiGlovisLastSendData(glovisInvoiceEdiVO.getBlSrcNo());
				 
				 int cancel_cnt=0;
				 
				 if (approvalCheckVOs.size() >0) {
					 approvalCheckVO = approvalCheckVOs.get(0);
				 }
				 			 
				 if (("A".equals(approvalCheckVO.getReTpCd()) || "R".equals(approvalCheckVO.getReTpCd()) || "F".equals(approvalCheckVO.getReTpCd())) && (Integer.parseInt(approvalCheckVO.getInvSeq()) < 1) ){ 
					 // 1.청구 승인(A)이면 그냥 신규로 간주한다.
					 // 2.청구 반려(R)이면 그냥 신규로 간주한다. 
					 // 3.접수 오류(F)이면 그냥 신규로 간주한다.
					 // 결론은 Cancel 데이터를 생성하지 않는다.
					 cancel_cnt=0;			
				 } else {
					 cancel_cnt = dbDao.addInvEdiGlovisHdrByBlSrcNo(invEdiGlovisHdrVO);
				 }
			 
				 invEdiGlovisHdrVO.setCxlFlg("N");	
				 
				 // cancel message를 저장했는지 유무
				 if (cancel_cnt == 1) { // 재전송 or 취소

					 // cancel message의 if no를 가져온다.
					 ifSeqVO = dbDao.searchEdiGlovisIfSeq(glovisInvoiceEdiVO,"CANCEL");
					 
					 glovisInvoiceEdiVO.setArIfNo(ifSeqVO.getArIfNo());
					 glovisInvoiceEdiVO.setIfSeq(ifSeqVO.getIfSeq());
					 glovisInvoiceEdiVO.setCxlFlg(ifSeqVO.getCxlFlg());
	
					 // 삭제 EDI message 생성
					 cancel_glovisEdiMsgVOs = dbDao.searchEdiGlovisMsg(glovisInvoiceEdiVO);	
						
					 cancel_ffmsg.setReRmk((makeGlovisFlatFile(cancel_glovisEdiMsgVOs,"CANCEL")));// flat file
					 cancel_ffmsg.setArIfNo(ifSeqVO.getArIfNo());
					 cancel_ffmsg.setIfSeq(ifSeqVO.getIfSeq());
					 cancel_ffmsg.setCxlFlg("Y");
					 cancel_ffmsg.setInvRmk(invEdiGlovisHdrVO.getInvRmk());
					 send_vo.add(cancel_ffmsg);					 
					 
					 if ("SEND".equals(btnFlag)){
						 if (glovisInvoiceEdiVO.getInvNo().length()==0 || "".equals(glovisInvoiceEdiVO.getInvNo())){ //화면에서 넘겨받은 VO가 있는지 유무 check						 
							 // Invoice No가 없으므로 BL No를 넣어준다.
							 invEdiGlovisHdrVO.setInvNo(glovisInvoiceEdiVO.getBlSrcNo());
							 rtn = dbDao.addInvEdiGlovisHdr(invEdiGlovisHdrVO);// send flag = 'N'
						 } else if (glovisInvoiceEdiVO.getInvNo().length() > 0){
							 if ("A".equals(approvalCheckVO.getReTpCd())){
								 // 청구 승인 또는 청구 반려이면 완전 신규와는 달리 기존에 INV No가 있다고 가정함.
								 rtn = dbDao.addInvEdiGlovisHdrForApproval(invEdiGlovisHdrVO);//
							 } else {
								// send flag = 'N'
							     rtn = dbDao.addInvEdiGlovisHdrByArIfNo(invEdiGlovisHdrVO);
							 }
						 }
					 }
				 } else if (cancel_cnt ==0){
					 invEdiGlovisHdrVO.setInvNo(glovisInvoiceEdiVO.getBlSrcNo());							 
					 if ("A".equals(approvalCheckVO.getReTpCd())|| "R".equals(approvalCheckVO.getReTpCd()) || "F".equals(approvalCheckVO.getReTpCd())){
						 // 청구 승인(A), 청구 반려(R), 접수 오류 (F)이면 완전 신규와는 달리 기존에 INV No가 있다고 가정함.
						 rtn = dbDao.addInvEdiGlovisHdrForApproval(invEdiGlovisHdrVO);//
					 } else {
						 // send flag = 'N'
						 rtn = dbDao.addInvEdiGlovisHdr(invEdiGlovisHdrVO);
					 }
				 }
				 
				 if (rtn == 1){ // 신규 message
					 // 신규 이므로 IF No는 화면에서 넘어온 것을 사용한다.
					 glovisInvoiceEdiVO.setArIfNo(invEdiGlovisHdrVO.getArIfNo());
					 
					 ifSeqVO = dbDao.searchEdiGlovisIfSeq(glovisInvoiceEdiVO,"NEW");
					 glovisInvoiceEdiVO.setArIfNo(ifSeqVO.getArIfNo());
					 glovisInvoiceEdiVO.setIfSeq(ifSeqVO.getIfSeq());
					 glovisInvoiceEdiVO.setCxlFlg(ifSeqVO.getCxlFlg());	
 
					 if ("Y".equals(approvalCheckVO.getCxlFlg())){
						 // 청구 승인('A')가  이후에는 차액에 대해서 전송한다.
						 approvalChgVO.setArIfNo(ifSeqVO.getArIfNo());
						 approvalChgVO.setIfSeq(ifSeqVO.getIfSeq());
						 approvalChgVO.setInvXchRt(glovisInvoiceEdiVO.getInvXchRt());
						 approvalChgVO.setCreUsrId(usrId);
						 approvalChgVO.setUpdUsrId(usrId);
						 approvalChgVO.setChgRmk(glovisInvoiceEdiVO.getInvRmk());
						 approvalChgVO.setBlSrcNo(invEdiGlovisHdrVO.getBlSrcNo());
						 approvalChgVO.setIoBndCd(glovisInvoiceEdiVO.getIoBndCd());
						 approvalChgVO.setArOfcCd(glovisInvoiceEdiVO.getArOfcCd());
						 approvalChgVO.setBlSrcNo(invEdiGlovisHdrVO.getBlSrcNo());
						 approvalChgVO.setEurGubun(glovisInvoiceEdiVO.getEurGubun());
						 approvalChgVO.setEuroLoclXchRt(glovisInvoiceEdiVO.getEuroLoclXchRt());
						 
						 dbDao.addInvEdiGlovisChgForApproval(approvalChgVO);
					 } else {
						 // charge table에 입력
						 invEdiGlovisChgVO.setArIfNo(ifSeqVO.getArIfNo());
						 invEdiGlovisChgVO.setIfSeq(ifSeqVO.getIfSeq());
						 invEdiGlovisChgVO.setInvXchRt(glovisInvoiceEdiVO.getInvXchRt());
						 invEdiGlovisChgVO.setCreUsrId(usrId);
						 invEdiGlovisChgVO.setUpdUsrId(usrId);
						 invEdiGlovisChgVO.setChgRmk(glovisInvoiceEdiVO.getInvRmk());
						 invEdiGlovisChgVO.setEuroLoclXchRt(glovisInvoiceEdiVO.getEuroLoclXchRt());
						 //invEdiGlovisChgVO.setBlSrcNo(invEdiGlovisHdrVO.getBlSrcNo());
						 
						 dbDao.addInvEdiGlovisChg(invEdiGlovisChgVO,"NEW",glovisInvoiceEdiVO.getEurGubun());					 
					 }
					 
					 // 신규 edi Message 생성
					 new_glovisEdiMsgVOs = dbDao.searchEdiGlovisMsg(glovisInvoiceEdiVO);					 
					 new_ffmsg.setReRmk(makeGlovisFlatFile(new_glovisEdiMsgVOs,"NEW"));						 
					 new_ffmsg.setArIfNo(ifSeqVO.getArIfNo());
					 new_ffmsg.setIfSeq(ifSeqVO.getIfSeq());
					 new_ffmsg.setCxlFlg("N");
					 new_ffmsg.setInvRmk(invEdiGlovisHdrVO.getInvRmk());
					 send_vo.add(new_ffmsg);
			 	}
				 
				 /* message 전송 */
			     for (int j=0;j<send_vo.size();j++){	    	 
			    	 if(send_vo.get(j) !=null){
			    		 String re = eaiDao.sendToEDI("GLOVIS" , mqName ,send_vo.get(j).getReRmk());// flat file 전송
			    		 if ("SUCCESS".equals(re)){
			    			 dbDao.modifyInvEdiGlovisHdr(send_vo.get(j));
			    		 }
			    	 }
			     }				 
			 } // End for main loop		  
			 
			} catch (DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
			}
	}
	/**
	 * Glovis에 전송할 Flat file을 만든다.
	 * 
	 * @param List<GlovisEdiMsgVO> glovisEdiMsgVOs
	 * @param String ind
	 * @return String
	 * @exception EventException
	 */	
	private String makeGlovisFlatFile(List<GlovisEdiMsgVO> glovisEdiMsgVOs,String ind) throws EventException {
		    StringBuffer flatfile = new StringBuffer();
		    try { 
			    if (glovisEdiMsgVOs != null){
			    	flatfile.append(glovisEdiMsgVOs.get(0).getInternalHeader()).append("\n");
			    	flatfile.append("HEADER:").append(glovisEdiMsgVOs.get(0).getHeader()).append("\n");
			    	flatfile.append("MSGVER:").append(glovisEdiMsgVOs.get(0).getMsgver()).append("\n");
			    	flatfile.append("MSGNUM:").append(glovisEdiMsgVOs.get(0).getMsgnum()).append("\n");
			    	flatfile.append("SNDDAT:").append(glovisEdiMsgVOs.get(0).getSnddat()).append("\n");
			    	flatfile.append(glovisEdiMsgVOs.get(0).getHdrMsg()).append("\n");
			    	
			    	if ("NEW".equals(ind)){ // 취소 메세지는 detail tag를 생성하지 않는다.
						for (int i=0;i<glovisEdiMsgVOs.size();i++){
							flatfile.append(glovisEdiMsgVOs.get(i).getDetailMsg()).append("\n");
						}
			    	}
			    }
		    } catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
			}
		    return flatfile.append("ENDDOC").append("\n").toString();
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 입력한 ofc_Cd, bl_src_no Customer로 EDI 전송대상을 조회한다.<br>
	 * 
	 * @param NikeInputVO nikeInputVO
	 * @return List<NikeInvoiceEdiVO>
	 * @exception EventException
	 */
	public List<NikeInvoiceEdiVO> searchEdiNikeList( NikeInputVO nikeInputVO ) throws EventException {
		try {			
			return dbDao.searchEdiNikeList(nikeInputVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}
	
	/**
	 * NIKE EDI 정보를 전송한다.<br>
	 * 
	 * @param List<NikeInvoiceEdiVO> nikeInvoiceEdiVOs
	 * @param String usrId
	 * @exception EventException
	 */		
	public void sendEdiNikeList (List<NikeInvoiceEdiVO> nikeInvoiceEdiVOs, String usrId) throws EventException{
		
		String flatFile = "";
		List<InvEdiNikeHdrVO> invEdiNikeHdrVOs = new ArrayList<InvEdiNikeHdrVO>() ;
		List<InvEdiNikeChgVO> invEdiNikeChgVOs = new ArrayList<InvEdiNikeChgVO>() ;
		
		try {
			String mqName = SubSystemConfigFactory.get("INV.ALPSINV_UBIZHJS_INVOICE.IBMMQ.QUEUE");
			String reString = "";
			
			List<String> listInvNoInvSeqUnique = new ArrayList<String>(); 
			
			for (int i = 0; i < nikeInvoiceEdiVOs.size(); i++) {
				NikeInvoiceEdiVO nikeInvoiceEdiVO = nikeInvoiceEdiVOs.get(i);
				
				String invNoInvSeq = nikeInvoiceEdiVO.getInvNo()+"|"+nikeInvoiceEdiVO.getInvSeq();
				
				if (!listInvNoInvSeqUnique.contains(String.valueOf(invNoInvSeq)) && !invNoInvSeq.equals("")) {
					
					InvEdiNikeHdrVO invEdiNikeHdrVO = new InvEdiNikeHdrVO();
					
					invEdiNikeHdrVO.setInvNo(nikeInvoiceEdiVO.getInvNo());
					invEdiNikeHdrVO.setInvSeq(nikeInvoiceEdiVO.getInvSeq());
					invEdiNikeHdrVO.setIssDt(nikeInvoiceEdiVO.getIssDt());
					invEdiNikeHdrVO.setBlSrcNo(nikeInvoiceEdiVO.getBlSrcNo());
					invEdiNikeHdrVO.setTtlTrfRtAmt(nikeInvoiceEdiVO.getTtlTrfRtAmt());
					invEdiNikeHdrVO.setCurrCd(nikeInvoiceEdiVO.getCurrCd());
					invEdiNikeHdrVO.setNikeFrtModId(nikeInvoiceEdiVO.getNikeFrtModId());
					invEdiNikeHdrVO.setNikeCrrId(nikeInvoiceEdiVO.getNikeCrrId());
					invEdiNikeHdrVO.setCntrNo(nikeInvoiceEdiVO.getCntrNo());
					invEdiNikeHdrVO.setEdiSndFlg("N");
					invEdiNikeHdrVO.setCreUsrId(usrId);
					invEdiNikeHdrVO.setUpdUsrId(usrId);
					
					dbDao.removeInvEdiNikeHdr(invEdiNikeHdrVO);
					dbDao.removeInvEdiNikeChg(invEdiNikeHdrVO);
					
					dbDao.addInvEdiNikeHdr(invEdiNikeHdrVO);
					
					invEdiNikeHdrVOs.add(invEdiNikeHdrVO);
					listInvNoInvSeqUnique.add(invNoInvSeq);
				}
				
				InvEdiNikeChgVO invEdiNikeChgVO = new InvEdiNikeChgVO();
				
				invEdiNikeChgVO.setInvNo(nikeInvoiceEdiVO.getInvNo());
				invEdiNikeChgVO.setInvSeq(nikeInvoiceEdiVO.getInvSeq());
				invEdiNikeChgVO.setChgSeq(nikeInvoiceEdiVO.getChgSeq());
				invEdiNikeChgVO.setNikeChgTpCd(nikeInvoiceEdiVO.getNikeChgTpCd());
				invEdiNikeChgVO.setTrfRtAmt(nikeInvoiceEdiVO.getTrfRtAmt());
				invEdiNikeChgVO.setCreUsrId(usrId);
				invEdiNikeChgVO.setUpdUsrId(usrId);
				
				dbDao.addInvEdiNikeChg(invEdiNikeChgVO);
				
				invEdiNikeChgVOs.add(invEdiNikeChgVO);
			}
			
			for (int i = 0; i < invEdiNikeHdrVOs.size(); i++) {
				
				NikeInvoiceEdiVO nikeInvoiceEdiVO = new NikeInvoiceEdiVO();
				
				nikeInvoiceEdiVO.setBlSrcNo(invEdiNikeHdrVOs.get(i).getBlSrcNo());
				nikeInvoiceEdiVO.setCntrNo(invEdiNikeHdrVOs.get(i).getCntrNo());
				nikeInvoiceEdiVO.setCurrCd(invEdiNikeHdrVOs.get(i).getCurrCd());
				nikeInvoiceEdiVO.setInvNo(invEdiNikeHdrVOs.get(i).getInvNo());
				nikeInvoiceEdiVO.setInvSeq(invEdiNikeHdrVOs.get(i).getInvSeq());
				
			
				flatFile = dbDao.searchEdiNikeMakefile(nikeInvoiceEdiVO);
								
				log.debug("flatFile =="+flatFile);
				
				if(!flatFile.equals("")){
					reString = eaiDao.sendToEDI(mqName, flatFile);
					
					log.debug("reString=="+reString);
					
					if (!reString.equals("E")) {
						dbDao.modifyInvEdiNikeHeader(invEdiNikeHdrVOs.get(i).getInvNo(), invEdiNikeHdrVOs.get(i).getInvSeq(), usrId);
					}
				}
			}
			
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}

	/**
	 * Retrieve DHL EDI list.
	 * 
	 * @param inputVO
	 * @return List<DHLInvoiceEdiVO>
	 * @throws EventException
	 */
	public List<DHLInvoiceEdiVO> searchEdiDHLList(DHLInputVO inputVO) throws EventException {
		List<DHLInvoiceEdiVO> list = null;

		try {
			list = dbDao.searchEdiDHLList(inputVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}

		return list;
	}

	/**
	 * Add DHL EDI.
	 * 
	 * @param dhlInvoiceEdiVOs
	 * @throws EventException
	 */
	public void addEdiDHL(DHLInvoiceEdiVO dhlInvoiceEdiVOs[]) throws EventException {
		try {
			// Insert rows on database.
			for (int i=0; i<dhlInvoiceEdiVOs.length; i++) {
				DHLInvoiceEdiVO dhlInvoiceEdiVO = dhlInvoiceEdiVOs[i];
				dbDao.addEdiDHL(dhlInvoiceEdiVO);
			}
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), e);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), e);
		}
	}

	/**
	 * Sending EDI for DHL.
	 * 
	 * @param dhlInvoiceEdiVOs
	 * @throws EventException
	 */
	public void sendEdiDHL(DHLInvoiceEdiVO dhlInvoiceEdiVOs[]) throws EventException {
		try {
			String mqName = SubSystemConfigFactory.get("INV.ALPSINV_UBIZHJS_INVOICE.IBMMQ.QUEUE");
			String reString = "";

			for (int i=0; i<dhlInvoiceEdiVOs.length; i++) {
				// Creating flat file.
				StringBuffer flatBuffer = new StringBuffer();

				// Get sequence number, date.
				DHLEdiSeqNoVO dhlEdiSeqNoVO = dbDao.searchEdiDHLSeqNo(dhlInvoiceEdiVOs[i]);

				// Set header
				flatBuffer.append("$$$MSGSTART:");
//				flatBuffer.append("HJSC                ");
				flatBuffer.append("SMLM                ");
				flatBuffer.append("OB10                ");
				flatBuffer.append("INVOIC    ");

				StringBuffer flatFileRefNo = new StringBuffer();
				String seqStr = "000000" + dhlEdiSeqNoVO.getRefNo();
				flatFileRefNo.append("INV");
				flatFileRefNo.append(dhlEdiSeqNoVO.getCreationDate().substring(2));
				flatFileRefNo.append(seqStr.substring(seqStr.length() - 6));
				flatBuffer.append(flatFileRefNo.toString());
				dhlInvoiceEdiVOs[i].setFltFileRefNo(flatFileRefNo.toString());
				flatBuffer.append("\n");

				// Set CREATION_DATE
				flatBuffer.append("CREATION_DATE:");
				flatBuffer.append(dhlEdiSeqNoVO.getCreationDate());
				flatBuffer.append("\n");

				// Start INVOICE_HDR
				flatBuffer.append("{INVOICE_HDR");
				flatBuffer.append("\n");

				// Set INV_TYPE
				flatBuffer.append("INV_TYPE:");
				double totalAmount = new Double(dhlInvoiceEdiVOs[i].getTtlAmt()).doubleValue();

				if (totalAmount < 0) {
					flatBuffer.append("C");
				} else {
					flatBuffer.append("D");
				}
				flatBuffer.append("\n");

				DHLEdiMainVO dhlEdiMainVO = dbDao.searchEdiDHLMain(dhlInvoiceEdiVOs[i]);

				// Set INV_NUMBER
				flatBuffer.append("INV_NUMBER:");
				flatBuffer.append(dhlEdiMainVO.getInvNumber());
				flatBuffer.append("\n");

				// Set INV_CREATION_DATE.
				flatBuffer.append("INV_CREATION_DATE:");
				flatBuffer.append(dhlEdiMainVO.getInvCreationDate());
				flatBuffer.append("\n");

				// Set INV_DUE_DATE.
				flatBuffer.append("INV_DUE_DATE:");
				flatBuffer.append(dhlEdiMainVO.getInvDueDate());
				flatBuffer.append("\n");

				// Set INV_REMARKS.
				flatBuffer.append("INV_REMARKS:");
				flatBuffer.append("Merci de bien vouloir nous adresser toute contestation à réception de la facture par fax (02 35 21 28 84 )  ou par e-mail (ar.leh@fr.hanjin.com)");
				flatBuffer.append("\n");

				// Set INV_TVA description.
				flatBuffer.append("INV_TVA description:");
				flatBuffer.append("<<0>> MONTANT <<1>> MONTANT TAXABLE");
				flatBuffer.append("\n");

				// Set INV_TVA Legal mention.
				flatBuffer.append("INV_TVA Legal mention:");
				flatBuffer.append("EN EXONERATION DE TVA SELON ART 262 II DU C.G.I");
				flatBuffer.append("\n");

				// Set INV_LEGALS
				flatBuffer.append("INV_LEGALS:");
				flatBuffer.append("Penalité de Retard : Selon le taux de refinancement BCE majoré  de 10 points");
				flatBuffer.append("\n");

				// Set INV_CURRENCY_CODE.
				flatBuffer.append("INV_CURRENCY_CODE:");
				flatBuffer.append("EUR");
				flatBuffer.append("\n");

				DHLEdiTotalVO dhlEdiTotalVO = dbDao.searchEdiDHLTotal(dhlInvoiceEdiVOs[i]);

				// Set INV_TOTAL_AMT.
				flatBuffer.append("INV_TOTAL_AMT:");
				flatBuffer.append(dhlEdiTotalVO.getInvTotalAmt());
				flatBuffer.append("\n");

				List<DHLEdiCurrTotalVO> dhlEdiCurrTotalVOs = dbDao.searchEdiDHLCurrTotal(dhlInvoiceEdiVOs[i]);

				for (int invPosTtlCount=0; invPosTtlCount<dhlEdiCurrTotalVOs.size(); invPosTtlCount++) {
					// Start INV_POS_TTL.
					flatBuffer.append("{INV_POS_TTL");
					flatBuffer.append("\n");

					DHLEdiCurrTotalVO dhlEdiCurrTotalVO = dhlEdiCurrTotalVOs.get(invPosTtlCount);

					// Set INV_POS_CURRCDE.
					flatBuffer.append("INV_POS_CURRCDE:");
					flatBuffer.append(dhlEdiCurrTotalVO.getInvPosCurrcde());
					flatBuffer.append("\n");
	
					// Set INV_POS_CURRAMT.
					flatBuffer.append("INV_POS_CURRAMT:");
					flatBuffer.append(dhlEdiCurrTotalVO.getInvPosCurramt());
					flatBuffer.append("\n");
	
					// Set INV_POS_EXCHRATE.
					flatBuffer.append("INV_POS_EXCHRATE:");
					flatBuffer.append(dhlEdiCurrTotalVO.getInvPosExchrate());
					flatBuffer.append("\n");

					// End INV_POS_TTL
					flatBuffer.append("}INV_POS_TTL");
					flatBuffer.append("\n");
				}

				// Start INV_VAT
				flatBuffer.append("{INV_VAT");
				flatBuffer.append("\n");

				// Set INV_VAT_BASIS
				flatBuffer.append("INV_VAT_BASIS:");
				flatBuffer.append(dhlEdiTotalVO.getInvVatBasis());
				flatBuffer.append("\n");

				// Set INV_VAT_RATE
				flatBuffer.append("INV_VAT_RATE:");
				flatBuffer.append(dhlEdiTotalVO.getInvVatRate());
				flatBuffer.append("\n");

				// Set INV_VAT_AMT
				flatBuffer.append("INV_VAT_AMT:");
				flatBuffer.append(dhlEdiTotalVO.getInvVatAmt());
				flatBuffer.append("\n");

				// End INV_VAT
				flatBuffer.append("}INV_VAT");
				flatBuffer.append("\n");

				DHLEdiUserVO dhlEdiUserVO = dbDao.searchDHLEdiUser(dhlInvoiceEdiVOs[i]);

				String partyInfos[] = {"ITO", "PTO", "IFR"};

				for (int partyInfoCount=0; partyInfoCount<partyInfos.length; partyInfoCount++) {
					// Start PARTY_INFO
					flatBuffer.append("{PARTY_INFO");
					flatBuffer.append("\n");

					// Set PT_TYPE
					flatBuffer.append("PT_TYPE:");
					flatBuffer.append(partyInfos[partyInfoCount]);
					flatBuffer.append("\n");
	
					// Set PT_CD
					if (!partyInfos[partyInfoCount].equals("PTO")) {
						flatBuffer.append("PT_CD:");
						if (partyInfos[partyInfoCount].equals("ITO")) {
							flatBuffer.append(dhlEdiMainVO.getPtCd());
						} else if (partyInfos[partyInfoCount].equals("IFR")) {
//							flatBuffer.append("HJSC");
							flatBuffer.append("SMLM");
						}
						flatBuffer.append("\n");
					}

	
					// Set PT_NAME
					flatBuffer.append("PT_NAME:");
					if (partyInfos[partyInfoCount].equals("ITO")) {
						flatBuffer.append(dhlEdiMainVO.getPtName());
					} else if (partyInfos[partyInfoCount].equals("PTO")) {
						flatBuffer.append("SM LINE CORPORATION FRANCE");
					} else if (partyInfos[partyInfoCount].equals("IFR")) {
						flatBuffer.append("SM Line Corporation Europe GmbH & Co. KG As agent for carrier SM Line Corporation");
					}
					flatBuffer.append("\n");
	
					// Set PT_ADDRESS1
					flatBuffer.append("PT_ADDRESS1:");
					if (partyInfos[partyInfoCount].equals("ITO")) {
						flatBuffer.append(dhlEdiMainVO.getPtAddress1());
					} else if (partyInfos[partyInfoCount].equals("PTO")) {
						flatBuffer.append("IMMEUBLE \"LE COLBERT\"");
					} else if (partyInfos[partyInfoCount].equals("IFR")) {
						flatBuffer.append(dhlEdiMainVO.getPtIfrAddress1());
					}
					flatBuffer.append("\n");
	
					// Set PT_ADDRESS2
					if (!partyInfos[partyInfoCount].equals("IFR")) {
						flatBuffer.append("PT_ADDRESS2:");
						if (partyInfos[partyInfoCount].equals("ITO")) {
							flatBuffer.append(dhlEdiMainVO.getPtAddress2());
						} else if (partyInfos[partyInfoCount].equals("PTO")) {
							flatBuffer.append("12 COURS DU CDT FRATACCI");
						}
						flatBuffer.append("\n");
		
						// Set PT_ADDRESS3
						flatBuffer.append("PT_ADDRESS3:");
						if (partyInfos[partyInfoCount].equals("ITO")) {
							flatBuffer.append(dhlEdiMainVO.getPtAddress3());
						} else if (partyInfos[partyInfoCount].equals("PTO")) {
							flatBuffer.append("LE HAVRE CEDEX");
						}
						flatBuffer.append("\n");
		
						// Set PT_ADDRESS4
						flatBuffer.append("PT_ADDRESS4:");
						if (partyInfos[partyInfoCount].equals("ITO")) {
							flatBuffer.append(dhlEdiMainVO.getPtAddress4());
						} else if (partyInfos[partyInfoCount].equals("PTO")) {
							flatBuffer.append("76085");
						}
						flatBuffer.append("\n");
					}
	
					// Set PT_VAT_ID
					if (partyInfos[partyInfoCount].equals("ITO")) {
						flatBuffer.append("PT_VAT_ID:");
						flatBuffer.append(dhlEdiMainVO.getPtVatId());
						flatBuffer.append("\n");
					}

					if (!partyInfos[partyInfoCount].equals("ITO")) {
						ArrayList<String> list = new ArrayList<String>();
						if (partyInfos[partyInfoCount].equals("PTO")) {
							list.add("IC");
							list.add("BK");
						} else {
							list.add("IC");
							list.add("CC");
						}
						String ptCtas[] = new String[list.size()];
						list.toArray(ptCtas);

						for (int ptCtaCount=0; ptCtaCount<ptCtas.length; ptCtaCount++) {
							// Start PT_CTA
							flatBuffer.append("{PT_CTA");
							flatBuffer.append("\n");

							// Set PT_CTA_QLF
							flatBuffer.append("PT_CTA_QLF:");
							flatBuffer.append(ptCtas[ptCtaCount]);
							flatBuffer.append("\n");

							if (partyInfos[partyInfoCount].equals("PTO")) {
								if (ptCtas[ptCtaCount].equals("IC")) {
									String ptComs[] = {"FX", "TE"};
									for (int ptComCount=0; ptComCount<ptComs.length; ptComCount++) {
										// Start PT_COM
										flatBuffer.append("{PT_COM");
										flatBuffer.append("\n");

										// Set PT_COM_QLF
										flatBuffer.append("PT_COM_QLF:");
										flatBuffer.append(ptComs[ptComCount]);
										flatBuffer.append("\n");
						
										// Set PT_COM_NBR
										flatBuffer.append("PT_COM_NBR:");
										if (ptComs[ptComCount].equals("FX")) {
											flatBuffer.append("02 35 21 28 84");
										} else if (ptComs[ptComCount].equals("TE")) {
											flatBuffer.append("02 35 19 86 00");
										}
										flatBuffer.append("\n");

										// End PT_COM
										flatBuffer.append("}PT_COM");
										flatBuffer.append("\n");
									}
								} else if (ptCtas[ptCtaCount].equals("BK")) {
									// Set PT_CTA_CONTACT
									flatBuffer.append("PT_CTA_CONTACT:");
									flatBuffer.append("COMPTE BANCAIRE : SOCIETE GENERALE LE HAVRE");
									flatBuffer.append("\n");

									// Start PT_COM
									flatBuffer.append("{PT_COM");
									flatBuffer.append("\n");

									// Set PT_COM_QLF
									flatBuffer.append("PT_COM_QLF:");
									flatBuffer.append("BA");
									flatBuffer.append("\n");
					
									// Set PT_COM_NBR
									flatBuffer.append("PT_COM_NBR:");
									flatBuffer.append("30003 / 01020 / 00020888131 / 07");
									flatBuffer.append("\n");

									// End PT_COM
									flatBuffer.append("}PT_COM");
									flatBuffer.append("\n");
								}
							} else {
								if (ptCtas[ptCtaCount].equals("IC")) {
									// Set PT_CTA_CONTACT
									flatBuffer.append("PT_CTA_CONTACT:");
									flatBuffer.append(dhlEdiUserVO.getPtCtaContact());
									flatBuffer.append("\n");
								} else if (ptCtas[ptCtaCount].equals("CC")) {
									String ptComs[] = {"EM", "FX"};
									for (int ptComCount=0; ptComCount<ptComs.length; ptComCount++) {
										// Start PT_COM
										flatBuffer.append("{PT_COM");
										flatBuffer.append("\n");

										// Set PT_COM_QLF
										flatBuffer.append("PT_COM_QLF:");
										flatBuffer.append(ptComs[ptComCount]);
										flatBuffer.append("\n");
						
										// Set PT_COM_NBR
										flatBuffer.append("PT_COM_NBR:");
										if (ptComs[ptComCount].equals("FX")) {
											flatBuffer.append("02 35 21 28 84");
										} else if (ptComs[ptComCount].equals("EM")) {
											flatBuffer.append("ar.leh@fr.hanjin.com");
										}
										flatBuffer.append("\n");

										// End PT_COM
										flatBuffer.append("}PT_COM");
										flatBuffer.append("\n");
									}
								}
							}

							// End PT_CTA
							flatBuffer.append("}PT_CTA");
							flatBuffer.append("\n");
						}
					}

					// End PARTY_INFO
					flatBuffer.append("}PARTY_INFO");
					flatBuffer.append("\n");
				}

				// Start INVOICE_DETAILS
				flatBuffer.append("{INVOICE_DETAILS");
				flatBuffer.append("\n");

				// Start BKG_DETAILS
				flatBuffer.append("{BKG_DETAILS");
				flatBuffer.append("\n");

				// Set BKG_NO
				flatBuffer.append("BKG_NO:");
				flatBuffer.append(dhlEdiMainVO.getBkgNo());
				flatBuffer.append("\n");

				// Set BL_NO
				flatBuffer.append("BL_NO:");
				flatBuffer.append(dhlEdiMainVO.getBlNo());
				flatBuffer.append("\n");

				// Set BKG_VVD
				flatBuffer.append("BKG_VVD:");
				flatBuffer.append(dhlEdiMainVO.getBkgVvd());
				flatBuffer.append("\n");

				// Set FULL_VSL_NM
				flatBuffer.append("FULL_VSL_NM:");
				flatBuffer.append(dhlEdiMainVO.getFullVslNm());
				flatBuffer.append("\n");

				// Set BL_POR_CD
				flatBuffer.append("BL_POR_CD:");
				flatBuffer.append(dhlEdiMainVO.getBlPorCd());
				flatBuffer.append("\n");

				// Set BL_POR_NM
				flatBuffer.append("BL_POR_NM:");
				flatBuffer.append(dhlEdiMainVO.getBlPorNm());
				flatBuffer.append("\n");

				// Set BL_POL_CD
				flatBuffer.append("BL_POL_CD:");
				flatBuffer.append(dhlEdiMainVO.getBlPolCd());
				flatBuffer.append("\n");

				// Set BL_POL_NM
				flatBuffer.append("BL_POL_NM:");
				flatBuffer.append(dhlEdiMainVO.getBlPolNm());
				flatBuffer.append("\n");

				// Set BL_POD_CD
				flatBuffer.append("BL_POD_CD:");
				flatBuffer.append(dhlEdiMainVO.getBlPodCd());
				flatBuffer.append("\n");

				// Set BL_POD_NM
				flatBuffer.append("BL_POD_NM:");
				flatBuffer.append(dhlEdiMainVO.getBlPodNm());
				flatBuffer.append("\n");

				// Set BL_DEL_CD
				flatBuffer.append("BL_DEL_CD:");
				flatBuffer.append(dhlEdiMainVO.getBlDelCd());
				flatBuffer.append("\n");

				// Set BL_DEL_NM
				flatBuffer.append("BL_DEL_NM:");
				flatBuffer.append(dhlEdiMainVO.getBlDelNm());
				flatBuffer.append("\n");

				// Set POL_DATE
				flatBuffer.append("POL_DATE:");
				flatBuffer.append(dhlEdiMainVO.getPolDate());
				flatBuffer.append("\n");
				
				// Set POD_DATE
				flatBuffer.append("POD_DATE:");
				flatBuffer.append(dhlEdiMainVO.getPodDate());
				flatBuffer.append("\n");

				// Set EXT_CUST_REF
				flatBuffer.append("EXT_CUST_REF:");
				flatBuffer.append(dhlEdiMainVO.getExtCustRef());
				flatBuffer.append("\n");

				// Set BKG_REMARK
				flatBuffer.append("BKG_REMARK:");
				flatBuffer.append(dhlEdiMainVO.getBkgRemark());
				flatBuffer.append("\n");

				List<DHLEdiCntrVO> dhlEdiCntrVOs = dbDao.searchDHLEdiCntr(dhlInvoiceEdiVOs[i]);

				for (int cntrCount=0; cntrCount<dhlEdiCntrVOs.size(); cntrCount++) {
					// Start CNTR_GRP
					flatBuffer.append("{CNTR_GRP");
					flatBuffer.append("\n");

					DHLEdiCntrVO dhlEdiCntrVO = dhlEdiCntrVOs.get(cntrCount);

					// Set CNTR_NBR
					flatBuffer.append("CNTR_NBR:");
					flatBuffer.append(dhlEdiCntrVO.getCntrNbr());
					flatBuffer.append("\n");

					// Set CNTR_TYPE
					flatBuffer.append("CNTR_TYPE:");
					flatBuffer.append(dhlEdiCntrVO.getCntrType());
					flatBuffer.append("\n");

					// Set CNTR_SIZE
					flatBuffer.append("CNTR_SIZE:");
					String cntrType = dhlEdiCntrVO.getCntrType().substring(1);
					if (cntrType.equals("2")) {
						flatBuffer.append("20");
					} else {
						flatBuffer.append("40");
					}
					flatBuffer.append("\n");

					// End CNTR_GRP
					flatBuffer.append("}CNTR_GRP");
					flatBuffer.append("\n");
				}

				List<DHLEdiChgVO> dhlEdiChgVOs = dbDao.searchDHLEdiChg(dhlInvoiceEdiVOs[i]); 

				for (int chgCount=0; chgCount<dhlEdiChgVOs.size(); chgCount++) {
					// Start INV_ITEM
					flatBuffer.append("{INV_ITEM");
					flatBuffer.append("\n");

					DHLEdiChgVO dhlEdiChgVO = dhlEdiChgVOs.get(chgCount);

					// Set FC_TYPE
					flatBuffer.append("FC_TYPE:");
					flatBuffer.append(dhlEdiChgVO.getFcType());
					flatBuffer.append("\n");
	
					// Set FC_TEXT
					flatBuffer.append("FC_TEXT:");
					flatBuffer.append(dhlEdiChgVO.getFcText());
					flatBuffer.append("\n");
	
					// Set FC_PERTYPE
					flatBuffer.append("FC_PERTYPE:");
					flatBuffer.append(dhlEdiChgVO.getFcPertype());
					flatBuffer.append("\n");
	
					// Set FC_REVENUETON
					flatBuffer.append("FC_REVENUETON:");
					flatBuffer.append(dhlEdiChgVO.getFcRevenueton());
					flatBuffer.append("\n");
	
					// Set FC_RATE
					flatBuffer.append("FC_RATE:");
					flatBuffer.append(dhlEdiChgVO.getFcRate());
					flatBuffer.append("\n");
	
					// Set FC_AMOUNT
					flatBuffer.append("FC_AMOUNT:");
					flatBuffer.append(dhlEdiChgVO.getFcAmount());
					flatBuffer.append("\n");
	
					// Set FC_RATE_CURR
					flatBuffer.append("FC_RATE_CURR:");
					flatBuffer.append(dhlEdiChgVO.getFcRateCurr());
					flatBuffer.append("\n");
	
					// Set FC_EXCHRATE
					flatBuffer.append("FC_EXCHRATE:");
					flatBuffer.append(dhlEdiChgVO.getFcExchrate());
					flatBuffer.append("\n");
	
					// Set FC_INV_AMT
					flatBuffer.append("FC_INV_AMT:");
					double amount = new Double(dhlEdiChgVO.getFcAmount()).doubleValue();
					double rate = new Double(dhlEdiChgVO.getFcExchrate()).doubleValue();
					double fcInvAmt = amount * rate;
					DecimalFormat decimalFormat = new DecimalFormat("############.##");
					flatBuffer.append(decimalFormat.format(fcInvAmt));
					flatBuffer.append("\n");
	
					// Set FC_VAT_IND
					flatBuffer.append("FC_VAT_IND:");
					flatBuffer.append(dhlEdiChgVO.getFcVatInd());
					flatBuffer.append("\n");
	
					// Set FC_PAYAT
					flatBuffer.append("FC_PAYAT:");
					flatBuffer.append(dhlEdiMainVO.getFcPayat().equals("I") ? "C" : "P");
					flatBuffer.append("\n");
	
					// Set FC_REMARKS
					flatBuffer.append("FC_REMARKS:");
					flatBuffer.append(dhlEdiChgVO.getFcRemarks());
					flatBuffer.append("\n");

					// End INV_ITEM
					flatBuffer.append("}INV_ITEM");
					flatBuffer.append("\n");
				}

				// End BKG_DETAILS
				flatBuffer.append("}BKG_DETAILS");
				flatBuffer.append("\n");

				// End INVOICE_DETAILS
				flatBuffer.append("}INVOICE_DETAILS");
				flatBuffer.append("\n");

				// End INVOICE_HDR
				flatBuffer.append("}INVOICE_HDR");

				reString = eaiDao.sendToEDI(mqName, flatBuffer.toString());
				log.debug("### reString=="+reString);

				if (!reString.equals("E")) {
					dbDao.addEdiDHL(dhlInvoiceEdiVOs[i]);
				}
			}
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), e);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), e);
		}
	}

	/**
	 * Retrieve Honey Well EDI list.
	 * 
	 * @param inputVO
	 * @return List<HNWLInvoiceEdiVO>
	 * @throws EventException
	 */
	public List<HNWLInvoiceEdiVO> searchEdiHNWLList(DHLInputVO inputVO) throws EventException {
		List<HNWLInvoiceEdiVO> list = null;

		try {
			list = dbDao.searchEdiHNWLList(inputVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}

		return list;
	}

	/**
	 * Add Honey Well EDI.
	 * 
	 * @param invoiceEdiVos
	 * @throws EventException
	 */
	public void addEdiHNWL(HNWLInvoiceEdiVO invoiceEdiVos[]) throws EventException {
		try {
			// Insert rows on database.
			for (int i=0; i<invoiceEdiVos.length; i++) {
				HNWLInvoiceEdiVO invoiceEdiVo = invoiceEdiVos[i];
				dbDao.addEdiHNWL(invoiceEdiVo);
			}
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), e);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), e);
		}
	}

	/**
	 * Sending EDI for Honey Well.
	 * 
	 * @param invoiceEdiVos
	 * @param inputVo
	 * @throws EventException
	 */
	public void sendEdiHNWL(HNWLInvoiceEdiVO invoiceEdiVos[], DHLInputVO inputVo) throws EventException {
		try {
			for (int i=0; i<invoiceEdiVos.length; i++) {
				HNWLEdiMainVO mainVo = dbDao.searchEdiHNWLMain(invoiceEdiVos[i], inputVo.getActCustCntCd(), inputVo.getActCustSeq());
				invoiceEdiVos[i].setBkgNo(mainVo.getBkgNo());
				invoiceEdiVos[i].setIoBndCd(mainVo.getIoBndCd());

				// 전송 결과가 'Reject'일 경우, FUNC_CODE = '00'으로 전송.
				if (invoiceEdiVos[i].getAckRsltCd() != null && invoiceEdiVos[i].getAckRsltCd().trim().equals("Reject")) {
					invoiceEdiVos[i].setFuncCode("00");
					this.makeEdiHNWLFlatfile(invoiceEdiVos[i], inputVo);
				} else {
					// 이미 전송했던 data 있으면 기존 전송 값을 다시 '01'로 전송해서 cancel 하고 재전송 처리. 
					if (mainVo.getIsExist().trim().equals("Y")) {
						HNWLInvoiceEdiVO ediVo = dbDao.searchEdiHNWLInfo(invoiceEdiVos[i]);
						ediVo.setBkgNo(mainVo.getBkgNo());
						ediVo.setIoBndCd(mainVo.getIoBndCd());

						ediVo.setFuncCode("01");
						this.makeEdiHNWLFlatfile(ediVo, inputVo);

						invoiceEdiVos[i].setFuncCode("04");
						this.makeEdiHNWLFlatfile(invoiceEdiVos[i], inputVo);
					} else { // 처음 전송이면 '00' 으로 전송.
						invoiceEdiVos[i].setFuncCode("00");
						this.makeEdiHNWLFlatfile(invoiceEdiVos[i], inputVo);
					}
				}
			}
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), e);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), e);
		}
	}

	/**
	 * Make Honey Well flat file.
	 * 
	 * @param invoiceEdiVo
	 * @param inputVo
	 * @return boolean
	 * @throws Exception
	 */
	private boolean makeEdiHNWLFlatfile(HNWLInvoiceEdiVO invoiceEdiVo, DHLInputVO inputVo) throws Exception {
		String mqName = SubSystemConfigFactory.get("INV.ALPSINV_UBIZHJS_INVOICE.IBMMQ.QUEUE");
		String reString = "";
 
		// Creating flat file.
		StringBuffer flatBuffer = new StringBuffer();

		// Get sequence number, date.
		DHLInvoiceEdiVO dhlInvoiceEdiVo = new DHLInvoiceEdiVO();
		dhlInvoiceEdiVo.setOfcCd(invoiceEdiVo.getOfcCd());
		DHLEdiSeqNoVO dhlEdiSeqNoVO = dbDao.searchEdiDHLSeqNo(dhlInvoiceEdiVo);

		// Start Header.
		flatBuffer.append("$$$MSGSTART:");
		flatBuffer.append("SMLINE              ");
		if(inputVo.getActCustCntCd().equals("US") && inputVo.getActCustSeq().equals("029316")){
			flatBuffer.append("139691877           ");
		}else if(inputVo.getActCustCntCd().equals("US") && inputVo.getActCustSeq().equals("035766")){
			flatBuffer.append("198061848            ");
		}
		flatBuffer.append("310       ");

		StringBuffer flatFileRefNo = new StringBuffer();
		if (invoiceEdiVo.getFuncCode().trim().equals("01")) {
			flatFileRefNo.append(invoiceEdiVo.getFltFileRefNo());
		} else {
			String seqStr = "000000" + dhlEdiSeqNoVO.getRefNo();
			flatFileRefNo.append("INV");
			flatFileRefNo.append(dhlEdiSeqNoVO.getCreationDate().substring(2));
			flatFileRefNo.append(seqStr.substring(seqStr.length() - 6));
		}
		flatBuffer.append(flatFileRefNo.toString());
		invoiceEdiVo.setFltFileRefNo(flatFileRefNo.toString());
		flatBuffer.append("\n");
		// End Header.

		// Set Empty.
		flatBuffer.append("VVD:\n");
		flatBuffer.append("VSL_LANE:\n");
		flatBuffer.append("VSL_CALLSIGN:\n");
		flatBuffer.append("VSL_LLOYDCODE:\n");
		flatBuffer.append("VSL_FULLNAME:\n");
		flatBuffer.append("VSL_FLAG:\n");

		// Set BLNBR.
		flatBuffer.append("BLNBR:");
		flatBuffer.append(invoiceEdiVo.getBlSrcNo());
		flatBuffer.append("\n");

		// Set POL.
		String polFullName = dbDao.searchEdiHNWLLocation(invoiceEdiVo.getPolCd());
		flatBuffer.append("BLPOL:");
		flatBuffer.append(invoiceEdiVo.getPolCd());
		flatBuffer.append("\n");
		flatBuffer.append("POL_AMS:\n");
		flatBuffer.append("POL_FULLNAME:");
		flatBuffer.append(polFullName);
		flatBuffer.append("\n");

		// Set POD.
		String podFullName = dbDao.searchEdiHNWLLocation(invoiceEdiVo.getPodCd());
		flatBuffer.append("BLPOD:");
		flatBuffer.append(invoiceEdiVo.getPodCd());
		flatBuffer.append("\n");
		flatBuffer.append("POD_AMS:\n");
		flatBuffer.append("POD_FULLNAME:");
		flatBuffer.append(podFullName);
		flatBuffer.append("\n");

		// Set POR.
		String porFullName = dbDao.searchEdiHNWLLocation(invoiceEdiVo.getPorCd());
		flatBuffer.append("BLPOR:");
		flatBuffer.append(invoiceEdiVo.getPorCd());
		flatBuffer.append("\n");
		flatBuffer.append("POR_AMS:\n");
		flatBuffer.append("POR_FULLNAME:");
		flatBuffer.append(porFullName);
		flatBuffer.append("\n");

		// Set DEL.
		String delFullName = dbDao.searchEdiHNWLLocation(invoiceEdiVo.getDelCd());
		flatBuffer.append("BLDEL:");
		flatBuffer.append(invoiceEdiVo.getDelCd());
		flatBuffer.append("\n");
		flatBuffer.append("DEL_AMS:\n");
		flatBuffer.append("DEL_FULLNAME:");
		flatBuffer.append(delFullName);
		flatBuffer.append("\n");

		// Shepper 정보, Consignee 정보를 취득 후 매핑
		HNWLEdiBkgCustVO custVo = dbDao.searchEdiHNWLBkgCust(invoiceEdiVo.getBkgNo());
		
		// Set Empty.
		flatBuffer.append("BLRLY:\n");
		flatBuffer.append("RLY_AMS:\n");
		flatBuffer.append("RLY_FULLNAME:\n");
		flatBuffer.append("BLRLY2:\n");
		flatBuffer.append("RLY_AMS2:\n");
		flatBuffer.append("RLY_FULLNAME2:\n");
		flatBuffer.append("BLPLACE:\n");
		flatBuffer.append("BLDATE:\n");
		flatBuffer.append("SHCD1:\n");
		flatBuffer.append("CNCD1:\n");
		
//		if (invoiceEdiVo.getIoBndCd().equals("I")) {
//			flatBuffer.append("NFCD1:\n");
//		} else {	
			flatBuffer.append("NFCD1:");
			flatBuffer.append(custVo.getNtfyCd());
			flatBuffer.append("\n");
//		}
		
		flatBuffer.append("FWCD1:\n");
		flatBuffer.append("SHPR1:\n");
		flatBuffer.append("SHPR2:\n");
		flatBuffer.append("SHPR3:\n");
		flatBuffer.append("SHPR4:\n");
		flatBuffer.append("SHPR5:\n");
		flatBuffer.append("SHPR_CITY_NM:\n");
		flatBuffer.append("SHPR_STAT_CD:\n");
		flatBuffer.append("SHPR_ZIP_CD:\n");
		flatBuffer.append("SHPR_CNT_CD:\n");
		flatBuffer.append("SH_IND:\n");
		flatBuffer.append("CNEE1:\n");
		flatBuffer.append("CNEE2:\n");
		flatBuffer.append("CNEE3:\n");
		flatBuffer.append("CNEE4:\n");
		flatBuffer.append("CNEE5:\n");
		flatBuffer.append("CNEE_CITY_NM:\n");
		flatBuffer.append("CNEE_STAT_CD:\n");
		flatBuffer.append("CNEE_ZIP_CD:\n");
		flatBuffer.append("CNEE_CNT_CD:\n");
		flatBuffer.append("CN_IND:\n");
		 
//		if (invoiceEdiVo.getIoBndCd().equals("I")) {
//			flatBuffer.append("NTFY1:\n");
//			flatBuffer.append("NTFY2:\n");
//			flatBuffer.append("NTFY3:\n");
//			flatBuffer.append("NTFY4:\n");
//			flatBuffer.append("NTFY5:\n");
//			flatBuffer.append("NTFY6:\n");
//			flatBuffer.append("NTFY_CITY_NM:\n");
//			flatBuffer.append("NTFY_STAT_CD:\n");
//			flatBuffer.append("NTFY_ZIP_CD:\n");
//			flatBuffer.append("NTFY_CNT_CD:\n");
//		} else {	
			flatBuffer.append("NTFY1:");
			flatBuffer.append(custVo.getNtfy1());
			flatBuffer.append("\n");
			flatBuffer.append("NTFY2:");
			flatBuffer.append(custVo.getNtfy2());
			flatBuffer.append("\n");
	
			flatBuffer.append("NTFY3:");
			flatBuffer.append(custVo.getNtfy3());
			flatBuffer.append("\n");
	
			flatBuffer.append("NTFY4:");
			flatBuffer.append(custVo.getNtfy4());
			flatBuffer.append("\n");
	
			flatBuffer.append("NTFY5:");
			flatBuffer.append(custVo.getNtfy5());
			flatBuffer.append("\n");
			
			flatBuffer.append("NTFY6:\n");
			
			flatBuffer.append("NTFY_CITY_NM:");
			flatBuffer.append(custVo.getNtfyCityNm());
			flatBuffer.append("\n");
	
			flatBuffer.append("NTFY_STAT_CD:");
			flatBuffer.append(custVo.getNtfyStatCd());
			flatBuffer.append("\n");
	
			flatBuffer.append("NTFY_ZIP_CD:");
			flatBuffer.append(custVo.getNtfyZipCd());
			flatBuffer.append("\n");
	
			flatBuffer.append("NTFY_CNT_CD:");
			flatBuffer.append(custVo.getNtfyCntCd());
			flatBuffer.append("\n");
//		}
		
		flatBuffer.append("NF_IND:\n");
		flatBuffer.append("NTFY21:\n");
		flatBuffer.append("NTFY22:\n");
		flatBuffer.append("NTFY23:\n");
		flatBuffer.append("NTFY24:\n");
		flatBuffer.append("NTFY25:\n");
		flatBuffer.append("AN_IND:\n");

		// Start I_BKG_PO_NO.
		String orderNos[] = invoiceEdiVo.getCustRefNoCtnt().split(",");
		for (int j=0; j<orderNos.length; j++) {
			if (!orderNos[j].trim().equals("")) {
				flatBuffer.append("{I_BKG_PO_NO\n");
				flatBuffer.append("BKG_PO_NO:");
				flatBuffer.append(orderNos[j]);
				flatBuffer.append("\n");
				flatBuffer.append("}I_BKG_PO_NO\n");
			}
		} 
		// End I_BKG_PO_NO.

		// Set Empty.
		flatBuffer.append("BL_SI_NO:\n");
		flatBuffer.append("BL_PPD_LOC_CD:\n");
		flatBuffer.append("BL_CCT_LOC_CD:\n");
		flatBuffer.append("BL_PPD_LOC_NM:\n");
		flatBuffer.append("BL_CCT_LOC_NM:\n");
		flatBuffer.append("DOC_CRDATE_GMT:\n");
		flatBuffer.append("FFWD1:\n");
		flatBuffer.append("FFWD2:\n");
		flatBuffer.append("FFWD3:\n");
		flatBuffer.append("FFWD4:\n");
		flatBuffer.append("FFWD5:\n");
		flatBuffer.append("FF_IND:\n");
		flatBuffer.append("EXPO1:\n");
		flatBuffer.append("EXPO2:\n");
		flatBuffer.append("EXPO3:\n");
		flatBuffer.append("EXPO4:\n");
		flatBuffer.append("EXPO5:\n");
		flatBuffer.append("EX_IND:\n");
		flatBuffer.append("BLCOPY:\n");
		flatBuffer.append("BLORG:1\n");
		flatBuffer.append("BLPKG:\n");
		flatBuffer.append("BLPKGU:\n");
		flatBuffer.append("BLWGT:\n");
		flatBuffer.append("BL_WGT_UNIT:\n");
		flatBuffer.append("BLMEA:\n");
		flatBuffer.append("BL_MEA_UNIT:\n");

		// Set BL_RDTYPE.
		String rdType = dbDao.searchEdiHNWLRDType(invoiceEdiVo);
		if (rdType == null) { rdType = ""; }
		flatBuffer.append("BL_RDTYPE:");
		flatBuffer.append(rdType);
		flatBuffer.append("\n");

		// Set Empty.
		flatBuffer.append("CARGOTYPE:\n");
		flatBuffer.append("COMMODITY:\n");
		flatBuffer.append("REMARK:\n");
		flatBuffer.append("AUS_QUAR:\n");
		flatBuffer.append("SRNBR:\n");

		// Set BKGNBR.
		flatBuffer.append("BKGNBR:");
		flatBuffer.append(invoiceEdiVo.getBkgNo());
		flatBuffer.append("\n");

		// Set Empty.
		flatBuffer.append("WAYBILL_IND:F\n");
		flatBuffer.append("CUSTREF_NUM:\n");
		flatBuffer.append("FINAL_ETA:\n");

		// Set FUNC_CODE.
		flatBuffer.append("FUNC_CODE:");
		flatBuffer.append(invoiceEdiVo.getFuncCode());
		flatBuffer.append("\n");

		// Set ONBOARD.
		flatBuffer.append("ONBOARD:");
		flatBuffer.append(invoiceEdiVo.getSailArrDt().replace("-", ""));
		flatBuffer.append("\n");

		// Set Empty.
		flatBuffer.append("APPLICATION_DT:\n");

		// Set INV_NO.
		flatBuffer.append("INV_NO:");
		flatBuffer.append(invoiceEdiVo.getBlSrcNo());
		flatBuffer.append("\n");

		// Set Empty.
		flatBuffer.append("BLINFO_DOCNO:\n");
		flatBuffer.append("BLINFO_EXPDEC:\n");
		flatBuffer.append("BLINFO_ORGIN:\n");
		flatBuffer.append("BLINFO_POINT:\n");
		flatBuffer.append("BLINFO_POR:\n");
		flatBuffer.append("BLINFO_PREVSL:\n");
		flatBuffer.append("BLINFO_VVD:\n");
		flatBuffer.append("BLINFO_POL:\n");
		flatBuffer.append("BLINFO_MOVE:\n");
		flatBuffer.append("BLINFO_POD:\n");
		flatBuffer.append("BLINFO_DEL:\n");
		flatBuffer.append("BLINFO_FDEST:\n");

		// Set BLINFO_FRTIND.
		flatBuffer.append("BLINFO_FRTIND:");
		if (invoiceEdiVo.getIoBndCd().equals("I")) {
			flatBuffer.append("C");
		} else {
			flatBuffer.append("P");
		}
		flatBuffer.append("\n");

		// Set Empty.
		flatBuffer.append("BLINFO_RCVTERM:\n");
		flatBuffer.append("BLINFO_DLVTERM:\n");
		flatBuffer.append("BLINFO_BKGSTS:\n");
		flatBuffer.append("BLINFO_PKG:\n");
		flatBuffer.append("BLINFO_NOTP:\n");
		flatBuffer.append("BLINFO_ONDATE:\n");
		flatBuffer.append("BLINFO_USER:\n");
		flatBuffer.append("BLINFO_ISSUELOC_CD:\n");
		flatBuffer.append("BLINFO_ISSUELOC:\n");
		flatBuffer.append("BLINFO_COPY:\n");
		flatBuffer.append("BLINFO_ISSUEDATE:\n");
		flatBuffer.append("BKG_STF:\n");
		flatBuffer.append("CONTACT_NAME:\n");
		flatBuffer.append("CONTACT_TEL:\n");
		flatBuffer.append("CONTACT_MOBILE:\n");
		flatBuffer.append("BKG_LC_NO:\n");
		flatBuffer.append("OBLPRT:\n");
		flatBuffer.append("TRAN_TP:\n");
		flatBuffer.append("EQPICKDT:\n");
		flatBuffer.append("BKG_OFC:\n");
		flatBuffer.append("BLKSTWG:\n");
		flatBuffer.append("MS_IBCS_NM1:\n");
		flatBuffer.append("MS_IBCS_NM2:\n");
		flatBuffer.append("MS_IBCS_ADDR1:\n");
		flatBuffer.append("MS_IBCS_ADDR2:\n");
		flatBuffer.append("MS_IBCS_ADDR3:\n");
		flatBuffer.append("MS_CUST_CD:\n");
		flatBuffer.append("SH_IBCS_C_NM1:\n");
		flatBuffer.append("SH_IBCS_C_NM2:\n");
		flatBuffer.append("NF_IBCS_C_NM1:\n");
		flatBuffer.append("NF_IBCS_C_NM2:\n");
		flatBuffer.append("CN_IBCS_C_NM1:\n");
		flatBuffer.append("CN_IBCS_C_NM2:\n");
		flatBuffer.append("FW_IBCS_C_NM1:\n");
		flatBuffer.append("FW_IBCS_C_NM2:\n");
		flatBuffer.append("AN_IBCS_C_NM1:\n");
		flatBuffer.append("AN_IBCS_C_NM2:\n");
		flatBuffer.append("IB_SH_REF_NO:\n");
		flatBuffer.append("IB_SC_NO:\n");
		flatBuffer.append("BL_SEND_CNT:\n");
		flatBuffer.append("MRN_NO:\n");
		flatBuffer.append("POL_ATD:\n");
		flatBuffer.append("POD_ATA:\n");
		flatBuffer.append("GROUP_ID:\n");
		flatBuffer.append("SI_VIA:\n");
		flatBuffer.append("FRT_INCLUDE_IND:\n");
		flatBuffer.append("BKG_CUST_REF_NO:\n");
		flatBuffer.append("BKG_SH_REF_NO:\n");
		flatBuffer.append("BKG_FF_REF_NO:\n");
		flatBuffer.append("SI_CUST_REF_NO:\n");
		flatBuffer.append("SI_SH_REF_NO:\n");
		flatBuffer.append("SI_FF_REF_NO:\n");

		// Start I_BKG_CUST.
		flatBuffer.append("{I_BKG_CUST\n");
		flatBuffer.append("IBCS_TP:\n");
		flatBuffer.append("IBCS_NM1:\n");
		flatBuffer.append("IBCS_NM2:\n");
		flatBuffer.append("IBCS_ADDR1:\n");
		flatBuffer.append("IBCS_ADDR2:\n");
		flatBuffer.append("IBCS_ADDR3:\n");
		flatBuffer.append("IBCS_C_NM1:\n");
		flatBuffer.append("IBCS_C_NM2:\n");
		flatBuffer.append("CUST_CD:\n");
		flatBuffer.append("IBCS_CUST_LOC:\n");
		flatBuffer.append("IBCS_STREET:\n");
		flatBuffer.append("IBCS_LOC_CD:\n");
		flatBuffer.append("IBCS_LOC_NM:\n");
		flatBuffer.append("IBCS_ZIP_CD:\n");
		flatBuffer.append("}I_BKG_CUST\n");
		// End I_BKG_CUST.

		// Start I_BKG_INFO.
		flatBuffer.append("{I_BKG_INFO\n");
		flatBuffer.append("IB_BKG_IND:\n");
		flatBuffer.append("IB_PKG_QTY:\n");
		flatBuffer.append("IB_PKG_CD:\n");
		flatBuffer.append("IBI_POR_CD:\n");
		flatBuffer.append("IBI_POR_NM:\n");
		flatBuffer.append("IBI_POL_CD:\n");
		flatBuffer.append("IBI_POL_NM:\n");
		flatBuffer.append("IBI_POD_CD:\n");
		flatBuffer.append("IBI_POD_NM:\n");
		flatBuffer.append("IBI_DEL_CD:\n");
		flatBuffer.append("IBI_DEL_NM:\n");
		flatBuffer.append("IBI_TRANS_IND:\n");
		flatBuffer.append("IBI_SR_AMT:\n");
		flatBuffer.append("IBI_DOC_ID:\n");
		flatBuffer.append("IBI_DOC_SEQ:\n");
		flatBuffer.append("IBI_CHG_CD:\n");
		flatBuffer.append("}I_BKG_INFO\n");
		// End I_BKG_INFO.

		// Start CHARGE.
		List<HNWLEdiChgVO> chgVos = dbDao.searchEdiHNWLChgList(invoiceEdiVo, inputVo.getActCustCntCd(), inputVo.getActCustSeq());
		for (int j=0; j<chgVos.size(); j++) {
			HNWLEdiChgVO chgVo = chgVos.get(j);

			flatBuffer.append("{CHARGE\n");

			flatBuffer.append("FCTYPE:");
			flatBuffer.append(chgVo.getChgCd());
			flatBuffer.append("\n");

			flatBuffer.append("RATE:");
			flatBuffer.append(chgVo.getTrfRtAmt());
			flatBuffer.append("\n");

			flatBuffer.append("RATED_AS:");
			flatBuffer.append(chgVo.getRatAsCntrQty());
			flatBuffer.append("\n");

			flatBuffer.append("REVENUETON:");
			flatBuffer.append(chgVo.getRatAsCntrQty());
			flatBuffer.append("\n");

			flatBuffer.append("DIF_AMT:");
			flatBuffer.append(chgVo.getChgAmt());
			flatBuffer.append("\n");

			flatBuffer.append("PPD:");
			if (invoiceEdiVo.getIoBndCd().equals("O")) {
				flatBuffer.append(chgVo.getChgAmt());
			}
			flatBuffer.append("\n");

			flatBuffer.append("CCT:");
			if (invoiceEdiVo.getIoBndCd().equals("I")) {
				flatBuffer.append(chgVo.getChgAmt());
			}
			flatBuffer.append("\n");

			flatBuffer.append("CURRENCYCODE:");
			flatBuffer.append(chgVo.getCurrCd());
			flatBuffer.append("\n");

			flatBuffer.append("TARIFF:\n");

			flatBuffer.append("PERTYPE:");
			flatBuffer.append(chgVo.getPerTpCd());
			flatBuffer.append("\n");

			flatBuffer.append("EXRATE:\n");
			flatBuffer.append("FRT_IND:\n");
			flatBuffer.append("}CHARGE\n");
		}
		// End CHARGE.

		// Start CHARGE_TTL.
		List<HNWLEdiChgVO> chgTotalVos = dbDao.searchEdiHNWLChgTotal(invoiceEdiVo, inputVo.getActCustCntCd(), inputVo.getActCustSeq());
		for (int j=0; j<chgTotalVos.size(); j++) {
			HNWLEdiChgVO chgVo = chgTotalVos.get(j);

			flatBuffer.append("{CHARGE_TTL\n");

			flatBuffer.append("PPD_TOTAL:");
			if (invoiceEdiVo.getIoBndCd().equals("O")) {
				flatBuffer.append(chgVo.getChgAmt());
			}
			flatBuffer.append("\n");

			flatBuffer.append("CCT_TOTAL:");
			if (invoiceEdiVo.getIoBndCd().equals("I")) {
				flatBuffer.append(chgVo.getChgAmt());
			}
			flatBuffer.append("\n");

			flatBuffer.append("TOTAL_CUR:");
			flatBuffer.append(chgVo.getCurrCd());
			flatBuffer.append("\n");

			flatBuffer.append("LCL_TOT_AMT:\n");
			flatBuffer.append("CGO_RCV_DT:\n");
			flatBuffer.append("ACT_CUST:\n");
			flatBuffer.append("}CHARGE_TTL\n");					
		}
		// End CHARGE_TTL.

		// Start DESC.
		flatBuffer.append("{DESC\n");
		flatBuffer.append("BL_DESC:\n");
		flatBuffer.append("}DESC\n");
		// End DESC.

		// Start MARK.
		flatBuffer.append("{MARK\n");
		flatBuffer.append("MARKNO:\n");
		flatBuffer.append("}MARK\n");
		// End MARK.

		// Start CNTR_INFO.
		List<HNWLEdiCntrVO> cntrVos = dbDao.searchEdiHNWLCntrList(invoiceEdiVo, inputVo.getActCustCntCd(), inputVo.getActCustSeq());
		for (int j=0; j<cntrVos.size(); j++) {
			HNWLEdiCntrVO cntrVo = cntrVos.get(j);

			flatBuffer.append("{CNTR_INFO\n");

			flatBuffer.append("CNTRNBR:");
			flatBuffer.append(cntrVo.getCntrNo());
			flatBuffer.append("\n");

			flatBuffer.append("PUNIT:\n");
			flatBuffer.append("PKG:\n");
			flatBuffer.append("CNTRWGT:\n");
			flatBuffer.append("CNTR_WGT_UNIT:\n");

			flatBuffer.append("CNTRTYPE:");
			flatBuffer.append(cntrVo.getCntrTpszCd());
			flatBuffer.append("\n");

			flatBuffer.append("SEALNBR:\n");
			flatBuffer.append("SEALNBR2:\n");
			flatBuffer.append("SEALNBR3:\n");
			flatBuffer.append("FM_IND:\n");
			flatBuffer.append("RF_IND:\n");
			flatBuffer.append("DG_IND:\n");
			flatBuffer.append("AK_IND:\n");
			flatBuffer.append("BK_IND:\n");
			flatBuffer.append("SOC_IND:\n");
			flatBuffer.append("TEMP:\n");
			flatBuffer.append("TUNIT:\n");
			flatBuffer.append("VENT:\n");
			flatBuffer.append("HUMID:\n");
			flatBuffer.append("MEASURE:\n");
			flatBuffer.append("MEASURE_UNIT:\n");
			flatBuffer.append("CN_RDTYPE:\n");
			flatBuffer.append("CMDT_DESC:\n");
			flatBuffer.append("CMDTCD:\n");
			flatBuffer.append("RF_REMARK:\n");
			flatBuffer.append("RFDRY_IND:\n");
			flatBuffer.append("OVF:\n");
			flatBuffer.append("OVR:\n");
			flatBuffer.append("OVH:\n");
			flatBuffer.append("OVLW:\n");
			flatBuffer.append("OVRW:\n");
			flatBuffer.append("OVWGT:\n");
			flatBuffer.append("OVWGT_UNIT:\n");
			flatBuffer.append("VOID_SLOT:\n");
			flatBuffer.append("STWG_REQ:\n");
			flatBuffer.append("PARTIAL:\n");
			flatBuffer.append("EXCEPT:\n");
			flatBuffer.append("SHIP_UNNO:\n");
			flatBuffer.append("{CNTR_DANGER\n");
			flatBuffer.append("UNNBR:\n");
			flatBuffer.append("CLASS:\n");
			flatBuffer.append("DG_DESC:\n");
			flatBuffer.append("PHONE:\n");
			flatBuffer.append("PAGE:\n");
			flatBuffer.append("FLSH_TEMP:\n");
			flatBuffer.append("FLSH_UNIT:\n");
			flatBuffer.append("DG_REMARK:\n");
			flatBuffer.append("EMSNO:\n");
			flatBuffer.append("PSACLS:\n");
			flatBuffer.append("PKGGRP:\n");
			flatBuffer.append("MFAG1:\n");
			flatBuffer.append("MFAG2:\n");
			flatBuffer.append("MAR_POLL:\n");
			flatBuffer.append("LABEL_CD:\n");
			flatBuffer.append("LABEL_DESC:\n");
			flatBuffer.append("DG_PKG:\n");
			flatBuffer.append("DG_PKGUNIT:\n");
			flatBuffer.append("NWGT:\n");
			flatBuffer.append("NWGT_UNIT:\n");
			flatBuffer.append("GWGT:\n");
			flatBuffer.append("GWGT_UNIT:\n");
			flatBuffer.append("MEA:\n");
			flatBuffer.append("MEA_UNIT:\n");
			flatBuffer.append("HAZ_CONT:\n");
			flatBuffer.append("STWG:\n");
			flatBuffer.append("PACK_GP:\n");
			flatBuffer.append("}CNTR_DANGER\n");
			flatBuffer.append("{CNTR_DESC\n");
			flatBuffer.append("D_CMDT:\n");
			flatBuffer.append("D_PUNIT:\n");
			flatBuffer.append("D_PKG:\n");
			flatBuffer.append("D_WGT:\n");
			flatBuffer.append("D_MEAS:\n");
			flatBuffer.append("D_DESC:\n");
			flatBuffer.append("{CUS_MARK\n");
			flatBuffer.append("D_MARK:\n");
			flatBuffer.append("}CUS_MARK\n");
			flatBuffer.append("}CNTR_DESC\n");
			flatBuffer.append("{MULTI_PO_NO\n");
			flatBuffer.append("CNTR_PO_NO:\n");
			flatBuffer.append("}MULTI_PO_NO\n");
			flatBuffer.append("{MULTI_SEAL_NO\n");
			flatBuffer.append("CNTR_SEAL_NO:\n");
			flatBuffer.append("}MULTI_SEAL_NO\n");
			flatBuffer.append("}CNTR_INFO\n");
		}
		// End CNTR_INFO.

		// Start QTY.
		flatBuffer.append("{QTY\n");
		flatBuffer.append("HANTYPE:\n");
		flatBuffer.append("COUNT:\n");
		flatBuffer.append("}QTY\n");
		// End QTY.

		// Start BKGVVD.
		flatBuffer.append("{BKGVVD\n");
		flatBuffer.append("BVVD1:\n");
		flatBuffer.append("VSL_CALLSIGN1:\n");
		flatBuffer.append("VSL_LLOYDCODE1:\n");
		flatBuffer.append("VSL_FULLNAME1:\n");
		flatBuffer.append("BLPOL1:\n");
		flatBuffer.append("POL_FULLNAME1:\n");
		flatBuffer.append("BLPOD1:\n");
		flatBuffer.append("POD_FULLNAME1:\n");
		flatBuffer.append("POLETA1:\n");
		flatBuffer.append("POLETD1:\n");
		flatBuffer.append("PODETA1:\n");
		flatBuffer.append("PODETD1:\n");
		flatBuffer.append("VSLFLAG1:\n");
		flatBuffer.append("}BKGVVD\n");
		// End BKGVVD.

		// Start I_BKG_MISC.
		flatBuffer.append("{I_BKG_MISC\n");
		flatBuffer.append("IBM_PLANT_CD:\n");
		flatBuffer.append("IBM_PLANT_NM:\n");
		flatBuffer.append("IBM_DIV_CD:\n");
		flatBuffer.append("IBM_DIV_NM:\n");
		flatBuffer.append("IBM_BIZ_TP:\n");
		flatBuffer.append("IBM_BIZ_NM:\n");
		flatBuffer.append("IBM_TS_TP:\n");
		flatBuffer.append("IBM_TS_NM:\n");
		flatBuffer.append("IBM_POL_ZIP_CD:\n");
		flatBuffer.append("IBM_POL_POST_CD:\n");
		flatBuffer.append("IBM_POD_ZIP_CD:\n");
		flatBuffer.append("IBM_POD_POST_CD:\n");
		flatBuffer.append("IBM_DEL_ZIP_CD:\n");
		flatBuffer.append("IBM_DEL_POST_CD:\n");
		flatBuffer.append("IBM_PAY_MTH:\n");
		flatBuffer.append("IBM_INV_DT:\n");
		flatBuffer.append("IBM_LINE_CHG_WGT:\n");
		flatBuffer.append("IBM_LINE_CHG_WGT_CD:\n");
		flatBuffer.append("IBM_EDN_CHG_QTY:\n");
		flatBuffer.append("IBM_EDN_CHG_QTY_CD:\n");
		flatBuffer.append("IBM_EDN_CHG_WGT:\n");
		flatBuffer.append("IBM_EDN_CHG_WGT_CD:\n");
		flatBuffer.append("IBM_SUMCHG_WGT_QTY:\n");
		flatBuffer.append("IBM_SUMCHG_WGT_CD:\n");
		flatBuffer.append("IBM_MESSAGE_NO:\n");
		flatBuffer.append("}I_BKG_MISC\n");
		// End I_BKG_MISC.

		// Start HPSWA_INFO.
		flatBuffer.append("{HPSWA_INFO\n");
		flatBuffer.append("SHIP_ID:\n");
		flatBuffer.append("PART_NO:\n");
		flatBuffer.append("}HPSWA_INFO\n");
		// End HPSWA_INFO.

		// Start CHARGE_INFO.
		flatBuffer.append("{CHARGE_INFO\n");
		flatBuffer.append("CHG_APPL_DT:\n");
		flatBuffer.append("}CHARGE_INFO\n");
		// End CHARGE_INFO.

		// Start BKG_NOTICE.
		flatBuffer.append("{BKG_NOTICE\n");
		flatBuffer.append("PU_CY:\n");
		flatBuffer.append("PU_CYNAME:\n");
		flatBuffer.append("PU_CYADDR1:\n");
		flatBuffer.append("PU_CYADDR2:\n");
		flatBuffer.append("PU_CYADDR3:\n");
		flatBuffer.append("PU_CYADDR4:\n");
		flatBuffer.append("PU_CYADDR5:\n");
		flatBuffer.append("PU_CYPOST:\n");
		flatBuffer.append("PU_CYTEL:\n");
		flatBuffer.append("PU_CYFAX:\n");
		flatBuffer.append("}BKG_NOTICE\n");
		// End BKG_NOTICE.

		// Start AMS_INFO.
		flatBuffer.append("{AMS_INFO\n");
		flatBuffer.append("HOUSE_BL_NO:\n");
		flatBuffer.append("HOUSE_SR_NO:\n");
		flatBuffer.append("AMS_FILE_NO:\n");
		flatBuffer.append("}AMS_INFO\n");
		// End AMS_INFO.

		reString = eaiDao.sendToEDI(mqName, flatBuffer.toString());
		log.debug("### reString=="+reString);

		if (!reString.equals("E") && !invoiceEdiVo.getFuncCode().trim().equals("01")) {
			dbDao.addEdiHNWL(invoiceEdiVo);
			return true;
		}

		return false;
	}
	
	
	/**
	 * Retrieve PHILIPS EDI list.
	 * 
	 * @param inputVO
	 * @return List<PHILSInvoiceEdiVO>
	 * @throws EventException
	 */
	public List<PHILSInvoiceEdiVO> searchEdiPHILSList(DHLInputVO inputVO) throws EventException {
		List<PHILSInvoiceEdiVO> list = null;

		try {
			list = dbDao.searchEdiPHILSList(inputVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}

		return list;
	}
		
	/**
	 * Sending EDI for PHILIPS.
	 * 
	 * @param invoiceEdiVos
	 * @param inputVo
	 * @throws EventException
	 */
	public void sendEdiPHILS(PHILSInvoiceEdiVO invoiceEdiVos[], DHLInputVO inputVo) throws EventException {
		try {
			for (int i=0; i<invoiceEdiVos.length; i++) {
				PHILSInvoiceEdiVO mainVo = dbDao.searchEdiPHILSMain(invoiceEdiVos[i], inputVo.getActCustCntCd(), inputVo.getActCustSeq());
				invoiceEdiVos[i].setBkgNo(mainVo.getBkgNo());
				invoiceEdiVos[i].setIoBndCd(mainVo.getIoBndCd());

				// 전송 결과가 'Reject'일 경우, FUNC_CODE = '00'으로 전송.
				if (invoiceEdiVos[i].getAckRsltCd() != null && invoiceEdiVos[i].getAckRsltCd().trim().equals("Reject")) {
					invoiceEdiVos[i].setFuncCode("00");
					this.makeEdiPHILSFlatfile(invoiceEdiVos[i], inputVo);
				} else {
					// 이미 전송했던 data 있으면 기존 전송 값을 다시 '01'로 전송해서 cancel 하고 재전송 처리. 
					if (mainVo.getIsExist().trim().equals("Y")) {
						PHILSInvoiceEdiVO ediVo = dbDao.searchEdiPHILSInfo(invoiceEdiVos[i]);
						ediVo.setBkgNo(mainVo.getBkgNo());
						ediVo.setIoBndCd(mainVo.getIoBndCd());

						ediVo.setFuncCode("01");
						this.makeEdiPHILSFlatfile(ediVo, inputVo);

						invoiceEdiVos[i].setFuncCode("04");
						this.makeEdiPHILSFlatfile(invoiceEdiVos[i], inputVo);
					} else { // 처음 전송이면 '00' 으로 전송.
						invoiceEdiVos[i].setFuncCode("00");
						this.makeEdiPHILSFlatfile(invoiceEdiVos[i], inputVo);
					}
				}
			}
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), e);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), e);
		}
	}
	
	
	/**
	 * Make PHILIPS flat file.
	 * 
	 * @param invoiceEdiVo
	 * @param inputVo
	 * @return boolean
	 * @throws Exception
	 */
	private boolean makeEdiPHILSFlatfile(PHILSInvoiceEdiVO invoiceEdiVo, DHLInputVO inputVo) throws Exception {
		String mqName = SubSystemConfigFactory.get("INV.ALPSINV_UBIZHJS_INVOICE.IBMMQ.QUEUE");
		String reString = "";

		// Creating flat file.
		StringBuffer flatBuffer = new StringBuffer();

		// Get sequence number, date.
		PHILSInvoiceEdiVO philsInvoiceEdiVo = new PHILSInvoiceEdiVO();
		philsInvoiceEdiVo.setOfcCd(invoiceEdiVo.getOfcCd());
		PHILSInvoiceEdiVO philsEdiSeqNoVO = dbDao.searchEdiPHILSSeqNo(philsInvoiceEdiVo.getOfcCd());

		// Start Header.
		flatBuffer.append("$$$MSGSTART:");
		flatBuffer.append("SMLINE              ");
		flatBuffer.append("TRN200024LSE        ");
		flatBuffer.append("310       ");

		StringBuffer flatFileRefNo = new StringBuffer();
		if (invoiceEdiVo.getFuncCode().trim().equals("01")) {
			flatFileRefNo.append(invoiceEdiVo.getFltFileRefNo());
		} else {
			String seqStr = "000000" + philsEdiSeqNoVO.getRefNo();
			flatFileRefNo.append("INV");
			flatFileRefNo.append(philsEdiSeqNoVO.getCreationDate().substring(2));
			flatFileRefNo.append(seqStr.substring(seqStr.length() - 6));
		}
		flatBuffer.append(flatFileRefNo.toString());
		invoiceEdiVo.setFltFileRefNo(flatFileRefNo.toString());
		flatBuffer.append("\n");
		// End Header.

		// Set VVD Info.
		PHILSEdiVvdVO vvdVo = dbDao.searchEdiPHILSVvd(invoiceEdiVo);
		
		flatBuffer.append("VVD:"+invoiceEdiVo.getVvd());
		flatBuffer.append("\n");
		flatBuffer.append("VSL_LANE:"+vvdVo.getVslSlanCd());
		flatBuffer.append("\n");
		flatBuffer.append("VSL_CALLSIGN:"+vvdVo.getCallSgnNo());
		flatBuffer.append("\n");
		flatBuffer.append("VSL_LLOYDCODE:"+vvdVo.getLloydNo());
		flatBuffer.append("\n");
		flatBuffer.append("VSL_FULLNAME:"+vvdVo.getVslEngNm());
		flatBuffer.append("\n");
		flatBuffer.append("VSL_FLAG:"+vvdVo.getVslRgstCntCd());
		flatBuffer.append("\n");

		// Set BLNBR.
		flatBuffer.append("BLNBR:");
		flatBuffer.append(invoiceEdiVo.getBlSrcNo());
		flatBuffer.append("\n");

		// Set POL.
		String polFullName = dbDao.searchEdiHNWLLocation(invoiceEdiVo.getPolCd());
		flatBuffer.append("BLPOL:");
		flatBuffer.append(invoiceEdiVo.getPolCd());
		flatBuffer.append("\n");
		flatBuffer.append("POL_AMS:\n");
		flatBuffer.append("POL_FULLNAME:");
		flatBuffer.append(polFullName);
		flatBuffer.append("\n");

		// Set POD.
		String podFullName = dbDao.searchEdiHNWLLocation(invoiceEdiVo.getPodCd());
		flatBuffer.append("BLPOD:");
		flatBuffer.append(invoiceEdiVo.getPodCd());
		flatBuffer.append("\n");
		flatBuffer.append("POD_AMS:\n");
		flatBuffer.append("POD_FULLNAME:");
		flatBuffer.append(podFullName);
		flatBuffer.append("\n");

		// Set POR.
		String porFullName = dbDao.searchEdiHNWLLocation(invoiceEdiVo.getPorCd());
		flatBuffer.append("BLPOR:");
		flatBuffer.append(invoiceEdiVo.getPorCd());
		flatBuffer.append("\n");
		flatBuffer.append("POR_AMS:\n");
		flatBuffer.append("POR_FULLNAME:");
		flatBuffer.append(porFullName);
		flatBuffer.append("\n");

		// Set DEL.
		String delFullName = dbDao.searchEdiHNWLLocation(invoiceEdiVo.getDelCd());
		flatBuffer.append("BLDEL:");
		flatBuffer.append(invoiceEdiVo.getDelCd());
		flatBuffer.append("\n");
		flatBuffer.append("DEL_AMS:\n");
		flatBuffer.append("DEL_FULLNAME:");
		flatBuffer.append(delFullName);
		flatBuffer.append("\n");

		// Set Empty.
		flatBuffer.append("BLRLY:\n");
		flatBuffer.append("RLY_AMS:\n");
		flatBuffer.append("RLY_FULLNAME:\n");
		flatBuffer.append("BLRLY2:\n");
		flatBuffer.append("RLY_AMS2:\n");
		flatBuffer.append("RLY_FULLNAME2:\n");
		flatBuffer.append("BLPLACE:\n");
		flatBuffer.append("BLDATE:\n");

		// Shepper 정보, Consignee 정보를 취득 후 매핑
		PHILSEdiBkgCustVO custVo = dbDao.searchEdiPHILSBkgCust(invoiceEdiVo.getBkgNo());
		
		flatBuffer.append("SHCD1:");
		flatBuffer.append(custVo.getShprCd());
		flatBuffer.append("\n");

		flatBuffer.append("CNCD1:");
		flatBuffer.append(custVo.getCneeCd());
		flatBuffer.append("\n");

		// Set Empty.		
		flatBuffer.append("NFCD1:\n");
		flatBuffer.append("FWCD1:\n");
		
		// Shepper 정보, Consignee 정보매핑		
		flatBuffer.append("SHPR1:");
		flatBuffer.append(custVo.getShpr1());
		flatBuffer.append("\n");
		flatBuffer.append("SHPR2:");
		flatBuffer.append(custVo.getShpr2());
		flatBuffer.append("\n");
		flatBuffer.append("SHPR3:");
		flatBuffer.append(custVo.getShpr3());
		flatBuffer.append("\n");
		flatBuffer.append("SHPR4:");
		flatBuffer.append(custVo.getShpr4());
		flatBuffer.append("\n");
		flatBuffer.append("SHPR5:");
		flatBuffer.append(custVo.getShpr5());
		flatBuffer.append("\n");
		flatBuffer.append("SHPR_CITY_NM:");
		flatBuffer.append(custVo.getShprCityNm());
		flatBuffer.append("\n");
		flatBuffer.append("SHPR_STAT_CD:");
		flatBuffer.append(custVo.getShprStatCd());
		flatBuffer.append("\n");
		flatBuffer.append("SHPR_ZIP_CD:");
		flatBuffer.append(custVo.getShprZipCd());
		flatBuffer.append("\n");
		flatBuffer.append("SHPR_CNT_CD:");
		flatBuffer.append(custVo.getShprCntCd());
		flatBuffer.append("\n");
		
		// Set Empty.
		flatBuffer.append("SH_IND:\n");
		
		// Shepper 정보, Consignee 정보매핑	
		flatBuffer.append("CNEE1:");
		flatBuffer.append(custVo.getCnee1());
		flatBuffer.append("\n");
		flatBuffer.append("CNEE2:");
		flatBuffer.append(custVo.getCnee2());
		flatBuffer.append("\n");
		flatBuffer.append("CNEE3:");
		flatBuffer.append(custVo.getCnee3());
		flatBuffer.append("\n");
		flatBuffer.append("CNEE4:");
		flatBuffer.append(custVo.getCnee4());
		flatBuffer.append("\n");
		flatBuffer.append("CNEE5:");
		flatBuffer.append(custVo.getCnee5());
		flatBuffer.append("\n");
		flatBuffer.append("CNEE_CITY_NM:");
		flatBuffer.append(custVo.getCneeCityNm());
		flatBuffer.append("\n");
		flatBuffer.append("CNEE_STAT_CD:");
		flatBuffer.append(custVo.getCneeStatCd());
		flatBuffer.append("\n");
		flatBuffer.append("CNEE_ZIP_CD:");
		flatBuffer.append(custVo.getCneeZipCd());
		flatBuffer.append("\n");
		flatBuffer.append("CNEE_CNT_CD:");
		flatBuffer.append(custVo.getCneeCntCd());
		flatBuffer.append("\n");
		
		// Set Location Code
		flatBuffer.append("CN_IND:");
		flatBuffer.append(invoiceEdiVo.getPhilsLocCdCtnt());
		flatBuffer.append("\n");
		
		// Set Empty.
		flatBuffer.append("NTFY1:\n");
		flatBuffer.append("NTFY2:\n");
		flatBuffer.append("NTFY3:\n");
		flatBuffer.append("NTFY4:\n");
		flatBuffer.append("NTFY5:\n");
		flatBuffer.append("NTFY6:\n");
		flatBuffer.append("NTFY_CITY_NM:\n");
		flatBuffer.append("NTFY_STAT_CD:\n");
		flatBuffer.append("NTFY_ZIP_CD:\n");
		flatBuffer.append("NTFY_CNT_CD:\n");
		flatBuffer.append("NF_IND:\n");
		flatBuffer.append("NTFY21:\n");
		flatBuffer.append("NTFY22:\n");
		flatBuffer.append("NTFY23:\n");
		flatBuffer.append("NTFY24:\n");
		flatBuffer.append("NTFY25:\n");
		flatBuffer.append("AN_IND:\n");
		
		//---- 2014.06.23 추가 : SHIPMENT DESTINATION CODE (I/O)
		flatBuffer.append("SHP_DIRECT_CD:");
		flatBuffer.append(invoiceEdiVo.getIoBndCd());
		flatBuffer.append("\n");
		
		//---- 2014.06.23 수정
		// Start I_BKG_PO_NO.
		String orderNos[] = invoiceEdiVo.getCustRefNoCtnt().split(",");
		for (int j=0; j<orderNos.length; j++) {
			if (!orderNos[j].trim().equals("")) {
				flatBuffer.append("{I_BKG_PO_NO\n");
				flatBuffer.append("BKG_PO_NO:");
				flatBuffer.append(orderNos[j]);
				flatBuffer.append("\n");
				flatBuffer.append("}I_BKG_PO_NO\n");
			}
		}
		// End I_BKG_PO_NO.
 
		flatBuffer.append("BL_SI_NO:\n");
		flatBuffer.append("BL_PPD_LOC_CD:\n");
		flatBuffer.append("BL_CCT_LOC_CD:\n");
		flatBuffer.append("BL_PPD_LOC_NM:\n");
		flatBuffer.append("BL_CCT_LOC_NM:\n");
		flatBuffer.append("DOC_CRDATE_GMT:\n");
		flatBuffer.append("FFWD1:\n");
		flatBuffer.append("FFWD2:\n");
		flatBuffer.append("FFWD3:\n");
		flatBuffer.append("FFWD4:\n");
		flatBuffer.append("FFWD5:\n");
		flatBuffer.append("FF_IND:\n");
		flatBuffer.append("EXPO1:\n");
		flatBuffer.append("EXPO2:\n");
		flatBuffer.append("EXPO3:\n");
		flatBuffer.append("EXPO4:\n");
		flatBuffer.append("EXPO5:\n");
		flatBuffer.append("EX_IND:\n");
		flatBuffer.append("BLCOPY:\n");
		flatBuffer.append("BLORG:1\n");
		
		// Set BKG_BL_DOC
		PHILSEdiBkgBlDocVO bkgBlDocVo = dbDao.searchEdiPHILSBkgBlDoc(invoiceEdiVo.getBkgNo());
		flatBuffer.append("BLPKG:");
		flatBuffer.append(bkgBlDocVo.getPckQty());
		flatBuffer.append("\n");
		flatBuffer.append("BLPKGU:");
		flatBuffer.append(bkgBlDocVo.getPckTpCd());
		flatBuffer.append("\n");
		flatBuffer.append("BLWGT:");
		flatBuffer.append(bkgBlDocVo.getActWgt());
		flatBuffer.append("\n");
		flatBuffer.append("BL_WGT_UNIT:");
		flatBuffer.append(bkgBlDocVo.getWgtUtCd());
		flatBuffer.append("\n");
		flatBuffer.append("BLMEA:");
		flatBuffer.append(bkgBlDocVo.getMeasQty());
		flatBuffer.append("\n");
		flatBuffer.append("BL_MEA_UNIT:");
		flatBuffer.append(bkgBlDocVo.getMeasUtCd());
		flatBuffer.append("\n");
		
		// Set BL_RDTYPE.
		String rdType = dbDao.searchEdiPHILSRDType(invoiceEdiVo.getBkgNo());
		if (rdType == null) { rdType = ""; }
		flatBuffer.append("BL_RDTYPE:");
		flatBuffer.append(rdType);
		flatBuffer.append("\n");

		// Set Empty.
		flatBuffer.append("CARGOTYPE:\n");
		flatBuffer.append("COMMODITY:\n");
		flatBuffer.append("REMARK:\n");
		flatBuffer.append("AUS_QUAR:\n");
		flatBuffer.append("SRNBR:\n");

		// Set BKGNBR.
		flatBuffer.append("BKGNBR:");
		flatBuffer.append(invoiceEdiVo.getBkgNo());
		flatBuffer.append("\n");

		// Set Empty.
		flatBuffer.append("WAYBILL_IND:F\n");
		flatBuffer.append("CUSTREF_NUM:\n");
		flatBuffer.append("FINAL_ETA:\n");

		// Set FUNC_CODE.
		flatBuffer.append("FUNC_CODE:");
		flatBuffer.append(invoiceEdiVo.getFuncCode());
		flatBuffer.append("\n");

		// Set ONBOARD.
		flatBuffer.append("ONBOARD:");
		flatBuffer.append(invoiceEdiVo.getSailArrDt().replace("-", ""));
		flatBuffer.append("\n");

		// Set Empty.
		flatBuffer.append("APPLICATION_DT:\n");

		// Set INV_NO.
		flatBuffer.append("INV_NO:");
		flatBuffer.append(invoiceEdiVo.getBlSrcNo());
		flatBuffer.append("\n");

		// Set Empty.
		flatBuffer.append("BLINFO_DOCNO:\n");
		flatBuffer.append("BLINFO_EXPDEC:\n");
		flatBuffer.append("BLINFO_ORGIN:\n");
		flatBuffer.append("BLINFO_POINT:\n");
		flatBuffer.append("BLINFO_POR:\n");
		flatBuffer.append("BLINFO_PREVSL:\n");
		flatBuffer.append("BLINFO_VVD:\n");
		flatBuffer.append("BLINFO_POL:\n");
		flatBuffer.append("BLINFO_MOVE:\n");
		flatBuffer.append("BLINFO_POD:\n");
		flatBuffer.append("BLINFO_DEL:\n");
		flatBuffer.append("BLINFO_FDEST:\n");

		// Set BLINFO_FRTIND.
		flatBuffer.append("BLINFO_FRTIND:");
		if (invoiceEdiVo.getIoBndCd().equals("I")) {
			flatBuffer.append("C");
		} else {
			flatBuffer.append("P");
		}
		flatBuffer.append("\n");

		// Set Empty.
		flatBuffer.append("BLINFO_RCVTERM:\n");
		flatBuffer.append("BLINFO_DLVTERM:\n");
		flatBuffer.append("BLINFO_BKGSTS:\n");
		flatBuffer.append("BLINFO_PKG:\n");
		flatBuffer.append("BLINFO_NOTP:\n");
		flatBuffer.append("BLINFO_ONDATE:\n");
		flatBuffer.append("BLINFO_USER:\n");
		flatBuffer.append("BLINFO_ISSUELOC_CD:\n");
		flatBuffer.append("BLINFO_ISSUELOC:\n");
		flatBuffer.append("BLINFO_COPY:\n");
		flatBuffer.append("BLINFO_ISSUEDATE:\n");
		flatBuffer.append("BKG_STF:\n");
		flatBuffer.append("CONTACT_NAME:\n");
		flatBuffer.append("CONTACT_TEL:\n");
		flatBuffer.append("CONTACT_MOBILE:\n");
		flatBuffer.append("BKG_LC_NO:\n");
		flatBuffer.append("OBLPRT:\n");
		flatBuffer.append("TRAN_TP:\n");
		flatBuffer.append("EQPICKDT:\n");
		flatBuffer.append("BKG_OFC:\n");
		flatBuffer.append("BLKSTWG:\n");
		flatBuffer.append("MS_IBCS_NM1:\n");
		flatBuffer.append("MS_IBCS_NM2:\n");
		flatBuffer.append("MS_IBCS_ADDR1:\n");
		flatBuffer.append("MS_IBCS_ADDR2:\n");
		flatBuffer.append("MS_IBCS_ADDR3:\n");
		flatBuffer.append("MS_CUST_CD:\n");
		flatBuffer.append("SH_IBCS_C_NM1:\n");
		flatBuffer.append("SH_IBCS_C_NM2:\n");
		flatBuffer.append("NF_IBCS_C_NM1:\n");
		flatBuffer.append("NF_IBCS_C_NM2:\n");
		flatBuffer.append("CN_IBCS_C_NM1:\n");
		flatBuffer.append("CN_IBCS_C_NM2:\n");
		flatBuffer.append("FW_IBCS_C_NM1:\n");
		flatBuffer.append("FW_IBCS_C_NM2:\n");
		flatBuffer.append("AN_IBCS_C_NM1:\n");
		flatBuffer.append("AN_IBCS_C_NM2:\n");
		flatBuffer.append("IB_SH_REF_NO:\n");
		flatBuffer.append("IB_SC_NO:\n");
		flatBuffer.append("BL_SEND_CNT:\n");
		flatBuffer.append("MRN_NO:\n");
		flatBuffer.append("POL_ATD:\n");
		flatBuffer.append("POD_ATA:\n");
		flatBuffer.append("GROUP_ID:\n");
		flatBuffer.append("SI_VIA:\n");
		flatBuffer.append("FRT_INCLUDE_IND:\n");
		flatBuffer.append("BKG_CUST_REF_NO:\n");
		flatBuffer.append("BKG_SH_REF_NO:\n");
		flatBuffer.append("BKG_FF_REF_NO:\n");
		flatBuffer.append("SI_CUST_REF_NO:\n");
		flatBuffer.append("SI_SH_REF_NO:\n");
		flatBuffer.append("SI_FF_REF_NO:\n");

		// 2014.06.23 수정
		// Start I_BKG_CUST.
		List<PHILSEdiBkgCustTpVO> BkgCustTpVos = dbDao.searchEdiPHILSBkgCustTp(invoiceEdiVo.getBkgNo(), invoiceEdiVo.getInvCustCntCd(), invoiceEdiVo.getInvCustSeq()); 
		for (int j=0; j<BkgCustTpVos.size(); j++) {
			PHILSEdiBkgCustTpVO BkgCustTpVo = BkgCustTpVos.get(j);
				
			flatBuffer.append("{I_BKG_CUST\n");
			flatBuffer.append("IBCS_TP:");
			flatBuffer.append(BkgCustTpVo.getPCustTp());
			flatBuffer.append("\n");
				
			flatBuffer.append("IBCS_NM1:");
			flatBuffer.append(BkgCustTpVo.getCustNm());
			flatBuffer.append("\n");
			flatBuffer.append("IBCS_NM2:\n");
			flatBuffer.append("IBCS_ADDR1:");
			flatBuffer.append(BkgCustTpVo.getCustAddr());
			flatBuffer.append("\n");
			flatBuffer.append("IBCS_ADDR2:\n");
			flatBuffer.append("IBCS_ADDR3:\n");
			flatBuffer.append("IBCS_C_NM1:\n");
			flatBuffer.append("IBCS_C_NM2:\n");
			flatBuffer.append("CUST_CD:\n");
			flatBuffer.append("IBCS_CUST_LOC:\n");
			flatBuffer.append("IBCS_STREET:");
			flatBuffer.append(BkgCustTpVo.getCustCtyNm());
			flatBuffer.append("\n");
			flatBuffer.append("IBCS_LOC_CD:");
			flatBuffer.append(BkgCustTpVo.getLocCd());
			flatBuffer.append("\n");
			flatBuffer.append("IBCS_LOC_NM:\n");
			flatBuffer.append("IBCS_ZIP_CD:\n");
				
			// 2014.06.23 추가
			//1. SF (Ship From) 일때, Port of Departure (UNLOC CODE) 요청
			//2. ST: Ship To 일때, Port of Arrival (UNLOC CODE) 요청
			//EDI에서 BLPOL과 BLPOD를 사용해서 처리함.
			flatBuffer.append("IBCS_UNLOC_CD:");
			flatBuffer.append(BkgCustTpVo.getUnLocCd());
			flatBuffer.append("\n");
							
			flatBuffer.append("}I_BKG_CUST\n");
		}
		// End I_BKG_CUST.

		// Start I_BKG_INFO.
		flatBuffer.append("{I_BKG_INFO\n");
		flatBuffer.append("IB_BKG_IND:\n");
		flatBuffer.append("IB_PKG_QTY:\n");
		flatBuffer.append("IB_PKG_CD:\n");
		flatBuffer.append("IBI_POR_CD:\n");
		flatBuffer.append("IBI_POR_NM:\n");
		flatBuffer.append("IBI_POL_CD:\n");
		flatBuffer.append("IBI_POL_NM:\n");
		flatBuffer.append("IBI_POD_CD:\n");
		flatBuffer.append("IBI_POD_NM:\n");
		flatBuffer.append("IBI_DEL_CD:\n");
		flatBuffer.append("IBI_DEL_NM:\n");
		flatBuffer.append("IBI_TRANS_IND:\n");
		flatBuffer.append("IBI_SR_AMT:\n");
		flatBuffer.append("IBI_DOC_ID:\n");
		flatBuffer.append("IBI_DOC_SEQ:\n");
		flatBuffer.append("IBI_CHG_CD:\n");
		flatBuffer.append("}I_BKG_INFO\n");
		// End I_BKG_INFO.

		// Start CHARGE.
		List<PHILSEdiChgVO> chgVos = dbDao.searchEdiPHILSChgList(invoiceEdiVo, inputVo.getActCustCntCd(), inputVo.getActCustSeq());
		for (int j=0; j<chgVos.size(); j++) {
			PHILSEdiChgVO chgVo = chgVos.get(j);

			flatBuffer.append("{CHARGE\n");

			flatBuffer.append("FCTYPE:");
			flatBuffer.append(chgVo.getChgCd());
			flatBuffer.append("\n");

			flatBuffer.append("RATE:");
			flatBuffer.append(chgVo.getTrfRtAmt());
			flatBuffer.append("\n");

			flatBuffer.append("RATED_AS:");
			flatBuffer.append(chgVo.getRatAsCntrQty());
			flatBuffer.append("\n");

			flatBuffer.append("REVENUETON:");
			flatBuffer.append(chgVo.getRatAsCntrQty());
			flatBuffer.append("\n");

			flatBuffer.append("DIF_AMT:");
			flatBuffer.append(chgVo.getChgAmt());
			flatBuffer.append("\n");

			flatBuffer.append("PPD:");
			if (invoiceEdiVo.getIoBndCd().equals("O")) {
				flatBuffer.append(chgVo.getChgAmt());
			}
			flatBuffer.append("\n");

			flatBuffer.append("CCT:");
			if (invoiceEdiVo.getIoBndCd().equals("I")) {
				flatBuffer.append(chgVo.getChgAmt());
			}
			flatBuffer.append("\n");

			flatBuffer.append("CURRENCYCODE:");
			flatBuffer.append(chgVo.getCurrCd());
			flatBuffer.append("\n");

			flatBuffer.append("TARIFF:\n");

			flatBuffer.append("PERTYPE:");
			flatBuffer.append(chgVo.getPerTpCd());
			flatBuffer.append("\n");

			flatBuffer.append("EXRATE:\n");
			flatBuffer.append("FRT_IND:\n");
			flatBuffer.append("}CHARGE\n");
		}
		// End CHARGE.

		// Start CHARGE_TTL.
		List<PHILSEdiChgVO> chgTotalVos = dbDao.searchEdiPHILSChgTotal(invoiceEdiVo, inputVo.getActCustCntCd(), inputVo.getActCustSeq());
		for (int j=0; j<chgTotalVos.size(); j++) {
			PHILSEdiChgVO chgVo = chgTotalVos.get(j);

			flatBuffer.append("{CHARGE_TTL\n");

			flatBuffer.append("PPD_TOTAL:");
			if (invoiceEdiVo.getIoBndCd().equals("O")) {
				flatBuffer.append(chgVo.getChgAmt());
			}
			flatBuffer.append("\n");

			flatBuffer.append("CCT_TOTAL:");
			if (invoiceEdiVo.getIoBndCd().equals("I")) {
				flatBuffer.append(chgVo.getChgAmt());
			}
			flatBuffer.append("\n");

			flatBuffer.append("TOTAL_CUR:");
			flatBuffer.append(chgVo.getCurrCd());
			flatBuffer.append("\n");

			flatBuffer.append("LCL_TOT_AMT:\n");
			flatBuffer.append("CGO_RCV_DT:\n");
			flatBuffer.append("ACT_CUST:\n");
			flatBuffer.append("}CHARGE_TTL\n");					
		}
		// End CHARGE_TTL.

		// Start DESC.
		flatBuffer.append("{DESC\n");
		
		
		// 2014.06.23 수정 - BL의 Description.
		String blDesc = dbDao.searchEdiPHILSBlDesc(invoiceEdiVo.getBkgNo());
		flatBuffer.append("BL_DESC:");
		flatBuffer.append(blDesc);
		flatBuffer.append("\n");
		
		flatBuffer.append("}DESC\n");
		// End DESC.

		// Start MARK.
		flatBuffer.append("{MARK\n");
		flatBuffer.append("MARKNO:\n");
		flatBuffer.append("}MARK\n");
		// End MARK.

		// Start CNTR_INFO.
		List<PHILSEdiCntrVO> cntrVos = dbDao.searchEdiPHILSCntrList(invoiceEdiVo, inputVo.getActCustCntCd(), inputVo.getActCustSeq());
		for (int j=0; j<cntrVos.size(); j++) {
			PHILSEdiCntrVO cntrVo = cntrVos.get(j);

			flatBuffer.append("{CNTR_INFO\n");

			flatBuffer.append("CNTRNBR:");
			flatBuffer.append(cntrVo.getCntrNo());
			flatBuffer.append("\n");

			flatBuffer.append("PUNIT:");
			flatBuffer.append(cntrVo.getPckTpCd());
			flatBuffer.append("\n");
			flatBuffer.append("PKG:");
			flatBuffer.append(cntrVo.getPckQty());
			flatBuffer.append("\n");
			flatBuffer.append("CNTRWGT:");
			flatBuffer.append(cntrVo.getCntrWgt());
			flatBuffer.append("\n");
			flatBuffer.append("CNTR_WGT_UNIT:");
			flatBuffer.append(cntrVo.getWgtUtCd());
			flatBuffer.append("\n");

			flatBuffer.append("CNTRTYPE:");
			flatBuffer.append(cntrVo.getCntrTpszCd());
			flatBuffer.append("\n");

			flatBuffer.append("SEALNBR:");
			flatBuffer.append(cntrVo.getSealNo1());
			flatBuffer.append("\n");
			flatBuffer.append("SEALNBR2:");
			flatBuffer.append(cntrVo.getSealNo2());
			flatBuffer.append("\n");
			flatBuffer.append("SEALNBR3:");
			flatBuffer.append(cntrVo.getSealNo3());
			flatBuffer.append("\n");
			
			flatBuffer.append("FM_IND:\n");
			flatBuffer.append("RF_IND:\n");
			flatBuffer.append("DG_IND:\n");
			flatBuffer.append("AK_IND:\n");
			flatBuffer.append("BK_IND:\n");
			flatBuffer.append("SOC_IND:\n");
			flatBuffer.append("TEMP:\n");
			flatBuffer.append("TUNIT:\n");
			flatBuffer.append("VENT:\n");
			flatBuffer.append("HUMID:\n");
			flatBuffer.append("MEASURE:\n");
			flatBuffer.append("MEASURE_UNIT:\n");
			flatBuffer.append("CN_RDTYPE:\n");
			flatBuffer.append("CMDT_DESC:\n");
			flatBuffer.append("CMDTCD:\n");
			flatBuffer.append("RF_REMARK:\n");
			flatBuffer.append("RFDRY_IND:\n");
			flatBuffer.append("OVF:\n");
			flatBuffer.append("OVR:\n");
			flatBuffer.append("OVH:\n");
			flatBuffer.append("OVLW:\n");
			flatBuffer.append("OVRW:\n");
			flatBuffer.append("OVWGT:\n");
			flatBuffer.append("OVWGT_UNIT:\n");
			flatBuffer.append("VOID_SLOT:\n");
			flatBuffer.append("STWG_REQ:\n");
			flatBuffer.append("PARTIAL:\n");
			flatBuffer.append("EXCEPT:\n");
			flatBuffer.append("SHIP_UNNO:\n");
			flatBuffer.append("{CNTR_DANGER\n");
			flatBuffer.append("UNNBR:\n");
			flatBuffer.append("CLASS:\n");
			flatBuffer.append("DG_DESC:\n");
			flatBuffer.append("PHONE:\n");
			flatBuffer.append("PAGE:\n");
			flatBuffer.append("FLSH_TEMP:\n");
			flatBuffer.append("FLSH_UNIT:\n");
			flatBuffer.append("DG_REMARK:\n");
			flatBuffer.append("EMSNO:\n");
			flatBuffer.append("PSACLS:\n");
			flatBuffer.append("PKGGRP:\n");
			flatBuffer.append("MFAG1:\n");
			flatBuffer.append("MFAG2:\n");
			flatBuffer.append("MAR_POLL:\n");
			flatBuffer.append("LABEL_CD:\n");
			flatBuffer.append("LABEL_DESC:\n");
			flatBuffer.append("DG_PKG:\n");
			flatBuffer.append("DG_PKGUNIT:\n");
			flatBuffer.append("NWGT:\n");
			flatBuffer.append("NWGT_UNIT:\n");
			flatBuffer.append("GWGT:\n");
			flatBuffer.append("GWGT_UNIT:\n");
			flatBuffer.append("MEA:\n");
			flatBuffer.append("MEA_UNIT:\n");
			flatBuffer.append("HAZ_CONT:\n");
			flatBuffer.append("STWG:\n");
			flatBuffer.append("PACK_GP:\n");
			flatBuffer.append("}CNTR_DANGER\n");
			flatBuffer.append("{CNTR_DESC\n");
			flatBuffer.append("D_CMDT:\n");
			flatBuffer.append("D_PUNIT:\n");
			flatBuffer.append("D_PKG:\n");
			flatBuffer.append("D_WGT:\n");
			flatBuffer.append("D_MEAS:\n");
			flatBuffer.append("D_DESC:\n");
			flatBuffer.append("{CUS_MARK\n");
			flatBuffer.append("D_MARK:\n");
			flatBuffer.append("}CUS_MARK\n");
			flatBuffer.append("}CNTR_DESC\n");
			flatBuffer.append("{MULTI_PO_NO\n");
			flatBuffer.append("CNTR_PO_NO:\n");
			flatBuffer.append("}MULTI_PO_NO\n");
			flatBuffer.append("{MULTI_SEAL_NO\n");
			flatBuffer.append("CNTR_SEAL_NO:\n");
			flatBuffer.append("}MULTI_SEAL_NO\n");
			flatBuffer.append("}CNTR_INFO\n");
		}
		// End CNTR_INFO.

		// Start QTY.
		flatBuffer.append("{QTY\n");
		flatBuffer.append("HANTYPE:\n");
		flatBuffer.append("COUNT:\n");
		flatBuffer.append("}QTY\n");
		// End QTY.

		// 2014.06.23 수정 : 필수값
		// Start BKGVVD.
		List<PHILSEdiBkgVvdVO> bkgVvdVos = dbDao.searchEdiPHILSBkgVvdList(invoiceEdiVo.getBlSrcNo());
		for (int j=0; j<bkgVvdVos.size(); j++) {
			PHILSEdiBkgVvdVO bkgVvdVo = bkgVvdVos.get(j);
		
			flatBuffer.append("{BKGVVD\n");
			flatBuffer.append("BVVD1:");
			flatBuffer.append(bkgVvdVo.getVvd());
			flatBuffer.append("\n");
			flatBuffer.append("VSL_CALLSIGN1:");
			flatBuffer.append(bkgVvdVo.getCallSgnNo());
			flatBuffer.append("\n");
			flatBuffer.append("VSL_LLOYDCODE1:");
			flatBuffer.append(bkgVvdVo.getLloydNo());
			flatBuffer.append("\n");
			flatBuffer.append("VSL_FULLNAME1:");
			flatBuffer.append(bkgVvdVo.getVslNm());
			flatBuffer.append("\n");
			flatBuffer.append("BLPOL1:");
			flatBuffer.append(bkgVvdVo.getPolCd());
			flatBuffer.append("\n");
			flatBuffer.append("POL_FULLNAME1:");
			flatBuffer.append(bkgVvdVo.getPolLocNm());
			flatBuffer.append("\n");
			flatBuffer.append("BLPOD1:");
			flatBuffer.append(bkgVvdVo.getPodCd());
			flatBuffer.append("\n");
			flatBuffer.append("POD_FULLNAME1:");
			flatBuffer.append(bkgVvdVo.getPodLocNm());
			flatBuffer.append("\n");

			flatBuffer.append("POLETA1:\n");
			flatBuffer.append("POLETD1:");
			flatBuffer.append(bkgVvdVo.getVpsEtdDt());
			flatBuffer.append("\n");	
			flatBuffer.append("PODETA1:");
			flatBuffer.append(bkgVvdVo.getVpsEtaDt());
			flatBuffer.append("\n");
			flatBuffer.append("PODETD1:\n");
			flatBuffer.append("VSLFLAG1:\n");
			flatBuffer.append("}BKGVVD\n");
		}
		// End BKGVVD.

		// Start I_BKG_MISC.
		flatBuffer.append("{I_BKG_MISC\n");
		flatBuffer.append("IBM_PLANT_CD:\n");
		flatBuffer.append("IBM_PLANT_NM:\n");
		flatBuffer.append("IBM_DIV_CD:\n");
		flatBuffer.append("IBM_DIV_NM:\n");
		flatBuffer.append("IBM_BIZ_TP:\n");
		flatBuffer.append("IBM_BIZ_NM:\n");
		flatBuffer.append("IBM_TS_TP:\n");
		flatBuffer.append("IBM_TS_NM:\n");
		flatBuffer.append("IBM_POL_ZIP_CD:\n");
		flatBuffer.append("IBM_POL_POST_CD:\n");
		flatBuffer.append("IBM_POD_ZIP_CD:\n");
		flatBuffer.append("IBM_POD_POST_CD:\n");
		flatBuffer.append("IBM_DEL_ZIP_CD:\n");
		flatBuffer.append("IBM_DEL_POST_CD:\n");
		flatBuffer.append("IBM_PAY_MTH:\n");
		flatBuffer.append("IBM_INV_DT:\n");
		flatBuffer.append("IBM_LINE_CHG_WGT:\n");
		flatBuffer.append("IBM_LINE_CHG_WGT_CD:\n");
		flatBuffer.append("IBM_EDN_CHG_QTY:\n");
		flatBuffer.append("IBM_EDN_CHG_QTY_CD:\n");
		flatBuffer.append("IBM_EDN_CHG_WGT:\n");
		flatBuffer.append("IBM_EDN_CHG_WGT_CD:\n");
		flatBuffer.append("IBM_SUMCHG_WGT_QTY:\n");
		flatBuffer.append("IBM_SUMCHG_WGT_CD:\n");
		flatBuffer.append("IBM_MESSAGE_NO:\n");
		flatBuffer.append("}I_BKG_MISC\n");
		// End I_BKG_MISC.

		// Start HPSWA_INFO.
		flatBuffer.append("{HPSWA_INFO\n");
		flatBuffer.append("SHIP_ID:\n");
		flatBuffer.append("PART_NO:\n");
		flatBuffer.append("}HPSWA_INFO\n");
		// End HPSWA_INFO.

		// Start CHARGE_INFO.
		flatBuffer.append("{CHARGE_INFO\n");
		flatBuffer.append("CHG_APPL_DT:\n");
		flatBuffer.append("}CHARGE_INFO\n");
		// End CHARGE_INFO.

		// Start BKG_NOTICE.
		flatBuffer.append("{BKG_NOTICE\n");
		flatBuffer.append("PU_CY:\n");
		flatBuffer.append("PU_CYNAME:\n");
		flatBuffer.append("PU_CYADDR1:\n");
		flatBuffer.append("PU_CYADDR2:\n");
		flatBuffer.append("PU_CYADDR3:\n");
		flatBuffer.append("PU_CYADDR4:\n");
		flatBuffer.append("PU_CYADDR5:\n");
		flatBuffer.append("PU_CYPOST:\n");
		flatBuffer.append("PU_CYTEL:\n");
		flatBuffer.append("PU_CYFAX:\n");
		flatBuffer.append("}BKG_NOTICE\n");
		// End BKG_NOTICE.

		// Start AMS_INFO.
		flatBuffer.append("{AMS_INFO\n");
		flatBuffer.append("HOUSE_BL_NO:\n");
		flatBuffer.append("HOUSE_SR_NO:\n");
		flatBuffer.append("AMS_FILE_NO:\n");
		flatBuffer.append("}AMS_INFO\n");
		// End AMS_INFO.
		
		reString = eaiDao.sendToEDI(mqName, flatBuffer.toString());
		log.debug("### reString=="+reString);

		if (!reString.equals("E") && !invoiceEdiVo.getFuncCode().trim().equals("01")) {
			dbDao.addEdiPHILS(invoiceEdiVo);
			return true;
		}

		return false;
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * 입력한 ofc_Cd, bl_src_no Customer로 EDI 전송대상을 조회한다.<br>
	 * 
	 * @param MGBInputVO mgbInputVO
	 * @return String
	 * @exception EventException
	 */
	public  String searchEdiMGBofficeYN( MGBInputVO mgbInputVO) throws EventException {
		String cnt = "";
		try {			
			cnt = dbDao.searchEdiMGBofficeYN(mgbInputVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
		return cnt;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 입력한 ofc_Cd, bl_src_no Customer로 EDI 전송대상을 조회한다.<br>
	 * 
	 * @param MGBInputVO mgbInputVO
	 * @return List<MGBInvoiceEdiVO> 
	 * @exception EventException
	 */
	public List<MGBInvoiceEdiVO> searchEdiMGBList( MGBInputVO mgbInputVO) throws EventException {
		try {			
			return dbDao.searchEdiMGBList(mgbInputVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}
	
	
	/**
	 * MGB EDI 정보를 전송한다.<br>
	 * 
	 * @param List<MGBInvoiceEdiVO> mgbInvoiceEdiVOs
	 * @param String usrId
	 * @exception EventException
	 */		
	public void sendEdiMGBList (List<MGBInvoiceEdiVO> mgbInvoiceEdiVOs, String usrId) throws EventException{
		
		String flatFile = "";
//		List<InvEdiMGBHdrVO> invEdiMGBHdrVOs = new ArrayList<InvEdiMGBHdrVO>() ;
//		List<InvEdiMGBChgVO> invEdiMGBChgVOs = new ArrayList<InvEdiMGBChgVO>() ;
		
		List<InvEdiNikeHdrVO> invEdiNikeHdrVOs = new ArrayList<InvEdiNikeHdrVO>() ;
		List<InvEdiNikeChgVO> invEdiNikeChgVOs = new ArrayList<InvEdiNikeChgVO>() ;
		try {
			String mqName = SubSystemConfigFactory.get("INV.ALPSINV_UBIZHJS_INVOICE.IBMMQ.QUEUE");
			String reString = "";                           
			
			List<String> listInvNoInvSeqUnique = new ArrayList<String>(); 
			log.debug("mgbInvoiceEdiVOs.size()======>"+mgbInvoiceEdiVOs.size());
			for (int i = 0; i < mgbInvoiceEdiVOs.size(); i++) {
				MGBInvoiceEdiVO mgbInvoiceEdiVO = mgbInvoiceEdiVOs.get(i);
				
				String invNoInvSeq = mgbInvoiceEdiVO.getInvNo()+"|"+mgbInvoiceEdiVO.getInvSeq();
				
				log.debug("invNoInvSeq======>"+invNoInvSeq);
				if (!listInvNoInvSeqUnique.contains(String.valueOf(invNoInvSeq)) && !invNoInvSeq.equals("")) {
					
//					InvEdiMGBHdrVO invEdiMGBHdrVO = new InvEdiMGBHdrVO();
					InvEdiNikeHdrVO invEdiNikeHdrVO = new InvEdiNikeHdrVO();
					
 
					invEdiNikeHdrVO.setInvNo(mgbInvoiceEdiVO.getInvNo());
					invEdiNikeHdrVO.setInvSeq(mgbInvoiceEdiVO.getInvSeq());
					invEdiNikeHdrVO.setIssDt(mgbInvoiceEdiVO.getIssDt());
					invEdiNikeHdrVO.setBlSrcNo(mgbInvoiceEdiVO.getBlSrcNo());
					invEdiNikeHdrVO.setTtlTrfRtAmt(mgbInvoiceEdiVO.getTtlTrfRtAmt());
					invEdiNikeHdrVO.setCurrCd(mgbInvoiceEdiVO.getCurrCd());
					
					invEdiNikeHdrVO.setNikeFrtModId("XX");
//					invEdiNikeHdrVO.setNikeCrrId("HJSC");
					invEdiNikeHdrVO.setNikeCrrId("SMLM");
					invEdiNikeHdrVO.setCntrNo(mgbInvoiceEdiVO.getCntrNo());
					invEdiNikeHdrVO.setEdiSndFlg("N");

					invEdiNikeHdrVO.setCreUsrId(usrId);
					invEdiNikeHdrVO.setUpdUsrId(usrId);
					
					dbDao.removeInvEdiNikeHdr(invEdiNikeHdrVO);
					dbDao.removeInvEdiNikeChg(invEdiNikeHdrVO);
					dbDao.addInvEdiNikeHdr(invEdiNikeHdrVO);
					
					invEdiNikeHdrVOs.add(invEdiNikeHdrVO);
					listInvNoInvSeqUnique.add(invNoInvSeq);
				}
				
//				InvEdiMGBChgVO invEdiMGBChgVO = new InvEdiMGBChgVO();
				InvEdiNikeChgVO invEdiNikeChgVO = new InvEdiNikeChgVO();
				
				
				invEdiNikeChgVO.setInvNo(mgbInvoiceEdiVO.getInvNo());
				invEdiNikeChgVO.setInvSeq(mgbInvoiceEdiVO.getInvSeq());
				invEdiNikeChgVO.setChgSeq(mgbInvoiceEdiVO.getChgSeq());
				invEdiNikeChgVO.setNikeChgTpCd(mgbInvoiceEdiVO.getChgTpCd());
				invEdiNikeChgVO.setTrfRtAmt(mgbInvoiceEdiVO.getTrfRtAmt());
				
//				invEdiNikeChgVO.setChCntrno(mgbInvoiceEdiVO.getCntrNo());
//				invEdiNikeChgVO.setChgTp(mgbInvoiceEdiVO.getChgTpCd());
//				invEdiNikeChgVO.setChAmnt(mgbInvoiceEdiVO.getTrfRtAmt());
				invEdiNikeChgVO.setCreUsrId(usrId);
				invEdiNikeChgVO.setUpdUsrId(usrId);
				
				dbDao.addInvEdiNikeChg(invEdiNikeChgVO);
		
				invEdiNikeChgVOs.add(invEdiNikeChgVO);
			}
			
			for (int i = 0; i < invEdiNikeHdrVOs.size(); i++) {
				
				MGBInvoiceEdiVO mgbInvoiceEdiVO = new MGBInvoiceEdiVO();
				
				mgbInvoiceEdiVO.setBlSrcNo(invEdiNikeHdrVOs.get(i).getBlSrcNo());
				mgbInvoiceEdiVO.setCntrNo(invEdiNikeHdrVOs.get(i).getCntrNo());
				mgbInvoiceEdiVO.setCurrCd(invEdiNikeHdrVOs.get(i).getCurrCd());
				mgbInvoiceEdiVO.setInvNo(invEdiNikeHdrVOs.get(i).getInvNo());
				mgbInvoiceEdiVO.setInvSeq(invEdiNikeHdrVOs.get(i).getInvSeq());
				
			 
				flatFile = dbDao.searchEdiMGBMakefile(mgbInvoiceEdiVO);
								
				log.debug("flatFile =="+flatFile);
				
				if(!flatFile.equals("")){
					reString = eaiDao.sendToEDI(mqName, flatFile);
					
					if (!reString.equals("E")) {
						dbDao.modifyInvEdiNikeHeader(invEdiNikeHdrVOs.get(i).getInvNo(), invEdiNikeHdrVOs.get(i).getInvSeq(), usrId);
					}
				}
			}
			
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}
	}
	
	
	/**
	 * Retrieve ADIDAS EDI list.
	 * 
	 * @param ADIDASInputVO adidasInputVO
	 * @return List<ADIDASInvoiceEdiVO>
	 * @throws EventException
	 */
	public List<ADIDASInvoiceEdiVO> searchEdiADIDASList(ADIDASInputVO adidasInputVO) throws EventException {
		List<ADIDASInvoiceEdiVO> list = null;

		try {
			list = dbDao.searchEdiADIDASList(adidasInputVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), ex);
		}

		return list;
	}
 
	/**
	 * Sending EDI for ADIDAS.
	 * 
	 * @param adidasInvoiceEdiVOs
	 * @param String ofcCd
	 * @param String usrId
	 * @throws EventException
	 */
	public void sendEdiADIDAS(ADIDASInvoiceEdiVO adidasInvoiceEdiVOs[] ,String ofcCd, String usrId) throws EventException {
		try {
			String mqName = SubSystemConfigFactory.get("INV.ALPSINV_UBIZHJS_INVOICE.IBMMQ.QUEUE");
			String reString = ""; 

			for (int i=0; i<adidasInvoiceEdiVOs.length; i++) {
				// Creating flat file.
				StringBuffer flatBuffer = new StringBuffer();

				// Get sequence number, date.
				ADIDASEdiSeqNoVO adidasEdiSeqNoVO = dbDao.searchEdiADIDASSeqNo(adidasInvoiceEdiVOs[i]);

				// Set header
				flatBuffer.append("$$$MSGSTART:");
//				flatBuffer.append("HJSC                ");
				flatBuffer.append("SMLM                ");
				flatBuffer.append("ADIDAS              ");
				flatBuffer.append("INVOIC    ");

				StringBuffer flatFileRefNo = new StringBuffer();
				String seqStr = "000000" + adidasEdiSeqNoVO.getRefNo();
				flatFileRefNo.append("INV");
				flatFileRefNo.append(adidasEdiSeqNoVO.getCreationDate().substring(2));
				flatFileRefNo.append(seqStr.substring(seqStr.length() - 6));
				flatBuffer.append(flatFileRefNo.toString());
				adidasInvoiceEdiVOs[i].setFltFileRefNo(flatFileRefNo.toString());
				flatBuffer.append("\n");

				// Set CREATION_DATE
				flatBuffer.append("CREATION_DATE:");
				flatBuffer.append(adidasEdiSeqNoVO.getCreationDate());
				flatBuffer.append("\n");

				// Start INVOICE_HDR 
				flatBuffer.append("{INVOICE_HDR");
				flatBuffer.append("\n");

				// Set INV_TYPE
				flatBuffer.append("INV_TYPE:");
				double totalAmount = new Double(adidasInvoiceEdiVOs[i].getTtlAmt()).doubleValue();

				if (totalAmount < 0) {
					flatBuffer.append("C");
				} else {
					flatBuffer.append("D");
				}
				flatBuffer.append("\n");

				ADIDASEdiMainVO adidasEdiMainVO = dbDao.searchEdiADIDASMain(adidasInvoiceEdiVOs[i]);

				// Set INV_NUMBER
				flatBuffer.append("INV_NUMBER:");
				flatBuffer.append(adidasEdiMainVO.getInvNumber());
				flatBuffer.append("\n");
				
				// Set INV_REF_NUMBER
				flatBuffer.append("INV_REF_NUMBER:");
				flatBuffer.append(adidasEdiMainVO.getInvNumber());
				flatBuffer.append("\n");
				
				// Set INV_CREATION_DATE.
				flatBuffer.append("INV_CREATION_DATE:");
				flatBuffer.append(adidasEdiMainVO.getInvCreationDate());
				flatBuffer.append("\n");


				// Set INV_REF_CREATION_DATE.
				flatBuffer.append("INV_REF_CREATION_DATE:");
				flatBuffer.append(adidasEdiMainVO.getInvCreationDate());
				flatBuffer.append("\n");
				
				// Set INV_DUE_DATE.
				flatBuffer.append("INV_DUE_DATE:");
				flatBuffer.append(adidasEdiMainVO.getInvDueDate());
				flatBuffer.append("\n");

				// Set INV_REMARKS.
				flatBuffer.append("INV_REMARKS:");
				flatBuffer.append("");
				flatBuffer.append("\n");

				// Set INV_TVA description.
				flatBuffer.append("INV_TVA_DESCRIPTION:");
				flatBuffer.append("");
				flatBuffer.append("\n");

				// Set INV_TVA Legal mention.
				flatBuffer.append("INV_TVA_LEGAL_MENTION:");
				flatBuffer.append("");
				flatBuffer.append("\n");

				// Set INV_LEGALS
				flatBuffer.append("INV_LEGALS:");
				flatBuffer.append("");
				flatBuffer.append("\n");

				// Set INV_CURRENCY_CODE.
				flatBuffer.append("INV_CURRENCY_CODE:");
				flatBuffer.append("EUR");
				flatBuffer.append("\n");

				ADIDASEdiTotalVO adidasEdiTotalVO = dbDao.searchEdiADIDASTotal(adidasInvoiceEdiVOs[i]);

				// Set INV_TOTAL_AMT.
				flatBuffer.append("INV_TOTAL_AMT:");
				flatBuffer.append(adidasEdiTotalVO.getInvTotalAmt());
				flatBuffer.append("\n");

				List<ADIDASEdiCurrTotalVO> adidasEdiCurrTotalVOs = dbDao.searchEdiADIDASCurrTotal(adidasInvoiceEdiVOs[i]);

				for (int invPosTtlCount=0; invPosTtlCount<adidasEdiCurrTotalVOs.size(); invPosTtlCount++) {
					// Start INV_POS_TTL.
					flatBuffer.append("{INV_POS_TTL");
					flatBuffer.append("\n");

					ADIDASEdiCurrTotalVO adidasEdiCurrTotalVO = adidasEdiCurrTotalVOs.get(invPosTtlCount);

					// Set INV_POS_CURRCDE.
					flatBuffer.append("INV_POS_CURRCDE:");
					flatBuffer.append(adidasEdiCurrTotalVO.getInvPosCurrcde());
					flatBuffer.append("\n");
	
					// Set INV_POS_CURRAMT.
					flatBuffer.append("INV_POS_CURRAMT:");
					flatBuffer.append(adidasEdiCurrTotalVO.getInvPosCurramt());
					flatBuffer.append("\n");
	
					// Set INV_POS_EXCHRATE.
					flatBuffer.append("INV_POS_EXCHRATE:");
					flatBuffer.append(adidasEdiCurrTotalVO.getInvPosExchrate());
					flatBuffer.append("\n");

					// End INV_POS_TTL
					flatBuffer.append("}INV_POS_TTL");
					flatBuffer.append("\n");
				}

				// Start INV_VAT
				flatBuffer.append("{INV_VAT");
				flatBuffer.append("\n");

				// Set INV_VAT_BASIS
				flatBuffer.append("INV_VAT_BASIS:");
				flatBuffer.append(adidasEdiTotalVO.getInvVatBasis());
				flatBuffer.append("\n");

				// Set INV_VAT_RATE
				flatBuffer.append("INV_VAT_RATE:");
				flatBuffer.append(adidasEdiTotalVO.getInvVatRate());
				flatBuffer.append("\n");

				// Set INV_VAT_AMT
				flatBuffer.append("INV_VAT_AMT:");
				flatBuffer.append(adidasEdiTotalVO.getInvVatAmt());
				flatBuffer.append("\n");

				// End INV_VAT
				flatBuffer.append("}INV_VAT");
				flatBuffer.append("\n");
				ADIDASEdiUserVO adidasEdiUserVO = null;
				adidasEdiUserVO = dbDao.searchADIDASEdiUser(adidasInvoiceEdiVOs[i]);
				String ptCtaContact ="";
				if(adidasEdiUserVO != null){
					ptCtaContact = adidasEdiUserVO.getPtCtaContact();
				}
				List<ADIDASEdiCustInfoVO> aDIDASEdiCustInfoVOs = dbDao.searchEdiADIDASCustInfo(adidasInvoiceEdiVOs[i]);
//				ADIDASEdiCustInfoVO aDIDASEdiCustInfoVOs = dbDao.searchEdiADIDASCustInfo(adidasInvoiceEdiVOs[i]);
//				List<ADIDASEdiCurrTotalVO> adidasEdiCurrTotalVOs = dbDao.searchEdiADIDASCurrTotal(adidasInvoiceEdiVOs[i]);
				
//				String partyInfos[] = {"ITO", "PTO", "IFR", "CX"};
				for (int k=0; k<aDIDASEdiCustInfoVOs.size(); k++) {
//				for (int partyInfoCount=0; partyInfoCount<partyInfos.length; partyInfoCount++) {
					// Start PARTY_INFO
					flatBuffer.append("{PARTY_INFO");
					flatBuffer.append("\n");

					// Set PT_TYPE
					flatBuffer.append("PT_TYPE:");
					flatBuffer.append(aDIDASEdiCustInfoVOs.get(k).getPtType());
					flatBuffer.append("\n");
	
					// Set PT_CD
//					if (!partyInfos[partyInfoCount].equals("PTO")) {
						flatBuffer.append("PT_CD:");
						flatBuffer.append(aDIDASEdiCustInfoVOs.get(k).getPtCd());
//						if (partyInfos[partyInfoCount].equals("ITO")) {
//							flatBuffer.append(adidasEdiMainVO.getPtCd());
//						} else if (partyInfos[partyInfoCount].equals("IFR")) {
//							flatBuffer.append("HJSC");
//						} else if (partyInfos[partyInfoCount].equals("PTO")) {
//							flatBuffer.append("");
//						}  else if (partyInfos[partyInfoCount].equals("CX")) {
//							flatBuffer.append("");
//						}
						flatBuffer.append("\n");
//					}

	
					// Set PT_NAME
					flatBuffer.append("PT_NAME:");
					flatBuffer.append(aDIDASEdiCustInfoVOs.get(k).getPtName());
//					if (partyInfos[partyInfoCount].equals("ITO")) {
//						flatBuffer.append(adidasEdiMainVO.getPtName());
//					} else if (partyInfos[partyInfoCount].equals("PTO")) {
//						flatBuffer.append("HANJIN SHIPPING FRANCE");
//					} else if (partyInfos[partyInfoCount].equals("IFR")) {
//						flatBuffer.append("Hanjin Shipping Europe GmbH & Co. KG As agent for carrier Hanjin Shipping Co., Ltd.");
//					}
					flatBuffer.append("\n");
	
					// Set PT_ADDRESS1
					flatBuffer.append("PT_ADDRESS1:");
					flatBuffer.append(aDIDASEdiCustInfoVOs.get(k).getPtAddress1());
//					if (partyInfos[partyInfoCount].equals("ITO")) {
//						flatBuffer.append(adidasEdiMainVO.getPtAddress1());
//					} else if (partyInfos[partyInfoCount].equals("PTO")) {
//						flatBuffer.append("IMMEUBLE \"LE COLBERT\"");
//					} else if (partyInfos[partyInfoCount].equals("IFR")) {
//						flatBuffer.append(adidasEdiMainVO.getPtIfrAddress1());
//					}
					flatBuffer.append("\n");
	
					// Set PT_ADDRESS2
					flatBuffer.append("PT_ADDRESS2:");
					flatBuffer.append(aDIDASEdiCustInfoVOs.get(k).getPtAddress2());
					flatBuffer.append("\n");
					
					// Set PT_ADDRESS3
					flatBuffer.append("PT_ADDRESS3:");
					flatBuffer.append(aDIDASEdiCustInfoVOs.get(k).getPtAddress3());
					flatBuffer.append("\n");
					
					// Set PT_ADDRESS4
					flatBuffer.append("PT_ADDRESS4:");
					flatBuffer.append(aDIDASEdiCustInfoVOs.get(k).getPtAddress4());
					flatBuffer.append("\n");
					
					// Set PT_CITY_NAME
					flatBuffer.append("PT_CITY_NAME:");
					flatBuffer.append(aDIDASEdiCustInfoVOs.get(k).getPtCityName());
					flatBuffer.append("\n");
					
					// Set PT_ST_PROV_CD
					flatBuffer.append("PT_ST_PROV_CD:");
					flatBuffer.append(aDIDASEdiCustInfoVOs.get(k).getPtStProvCd());
					flatBuffer.append("\n");
					
					// Set PT_ZIP_CD
					flatBuffer.append("PT_ZIP_CD:");
					flatBuffer.append(aDIDASEdiCustInfoVOs.get(k).getPtZipCd());
					flatBuffer.append("\n");
					
					// Set PT_COUNTRY_CD
					flatBuffer.append("PT_COUNTRY_CD:");
					flatBuffer.append(aDIDASEdiCustInfoVOs.get(k).getPtCountryCd());
					flatBuffer.append("\n");
					// Set PT_ADDRESS2
//					if (!partyInfos[partyInfoCount].equals("IFR")) {
//						flatBuffer.append("PT_ADDRESS2:");
//						if (partyInfos[partyInfoCount].equals("ITO")) {
//							flatBuffer.append(adidasEdiMainVO.getPtAddress2());
//						} else if (partyInfos[partyInfoCount].equals("PTO")) {
//							flatBuffer.append("12 COURS DU CDT FRATACCI");
//						}
//						flatBuffer.append("\n");
//		
//						// Set PT_ADDRESS3
//						flatBuffer.append("PT_ADDRESS3:");
//						if (partyInfos[partyInfoCount].equals("ITO")) {
//							flatBuffer.append(adidasEdiMainVO.getPtAddress3());
//						} else if (partyInfos[partyInfoCount].equals("PTO")) {
//							flatBuffer.append("LE HAVRE CEDEX");
//						}
//						flatBuffer.append("\n");
//		
//						// Set PT_ADDRESS4
//						flatBuffer.append("PT_ADDRESS4:");
//						if (partyInfos[partyInfoCount].equals("ITO")) {
//							flatBuffer.append(adidasEdiMainVO.getPtAddress4());
//						} else if (partyInfos[partyInfoCount].equals("PTO")) {
//							flatBuffer.append("76085");
//						}
//						flatBuffer.append("\n");
//						
//						// Set PT_CITY_NAME
//						flatBuffer.append("PT_CITY_NAME:");
//						if (partyInfos[partyInfoCount].equals("ITO")) {
//							flatBuffer.append(adidasEdiMainVO.getPtCityName());
//							
//						} else if (partyInfos[partyInfoCount].equals("PTO")) {
//							flatBuffer.append("");
//						}
//						flatBuffer.append("\n");
//						
//						// Set PT_ST_PROV_CD
//						flatBuffer.append("PT_ST_PROV_CD:");
//						if (partyInfos[partyInfoCount].equals("ITO")) {
//							flatBuffer.append(adidasEdiMainVO.getPtStProvCd());
//						}else if (partyInfos[partyInfoCount].equals("PTO")) {
//							flatBuffer.append("");
//						}
//						flatBuffer.append("\n");
//
//						
//						// Set PT_ZIP_CD
//						flatBuffer.append("PT_ZIP_CD:");
//						if (partyInfos[partyInfoCount].equals("ITO")) {
//							flatBuffer.append(adidasEdiMainVO.getPtZipCd());
//						}else if (partyInfos[partyInfoCount].equals("PTO")) {
//							flatBuffer.append("");
//						}
//						flatBuffer.append("\n");
//						
//						// Set PT_COUNTRY_CD
//						flatBuffer.append("PT_COUNTRY_CD:");
//						if (partyInfos[partyInfoCount].equals("ITO")) {
//							flatBuffer.append(adidasEdiMainVO.getPtCountryCd());
//						}else if (partyInfos[partyInfoCount].equals("PTO")) {
//								flatBuffer.append("");
//						}
//							flatBuffer.append("\n");
//					}
	
					// Set PT_VAT_ID
					if (aDIDASEdiCustInfoVOs.get(k).getPtType().equals("ITO")) {
						flatBuffer.append("PT_VAT_ID:");
						flatBuffer.append(adidasEdiMainVO.getPtVatId());
						flatBuffer.append("\n");
					}

					if (!aDIDASEdiCustInfoVOs.get(k).getPtType().equals("ITO")) {
						ArrayList<String> list = new ArrayList<String>();
						if (aDIDASEdiCustInfoVOs.get(k).getPtType().equals("PTO")) {
							list.add("IC");
							list.add("BK");
						} else {
							list.add("IC");
							list.add("CC");
						}
						String ptCtas[] = new String[list.size()];
						list.toArray(ptCtas);

						for (int ptCtaCount=0; ptCtaCount<ptCtas.length; ptCtaCount++) {
							// Start PT_CTA
							flatBuffer.append("{PT_CTA");
							flatBuffer.append("\n");

							// Set PT_CTA_QLF
							flatBuffer.append("PT_CTA_QLF:");
							flatBuffer.append(ptCtas[ptCtaCount]);
							flatBuffer.append("\n");

							if (aDIDASEdiCustInfoVOs.get(k).getPtType().equals("PTO")) {
								if (ptCtas[ptCtaCount].equals("IC")) {
									flatBuffer.append("PT_CTA_CONTACT:");
									String ptComs[] = {"EM", "FX","TE","BA"};
									for (int ptComCount=0; ptComCount<ptComs.length; ptComCount++) {
										// Start PT_COM
										flatBuffer.append("{PT_COM");
										flatBuffer.append("\n");

										// Set PT_COM_QLF
										flatBuffer.append("PT_COM_QLF:");
										flatBuffer.append(ptComs[ptComCount]);
										flatBuffer.append("\n");
						
										// Set PT_COM_NBR
										flatBuffer.append("PT_COM_NBR:");
										if (ptComs[ptComCount].equals("FX")) {
											flatBuffer.append(aDIDASEdiCustInfoVOs.get(k).getPtFax());
										} else if (ptComs[ptComCount].equals("EM")) {
											flatBuffer.append(aDIDASEdiCustInfoVOs.get(k).getPtEml());
										} else if (ptComs[ptComCount].equals("TE")) {
											flatBuffer.append(aDIDASEdiCustInfoVOs.get(k).getPtTel());
										} else if (ptComs[ptComCount].equals("BA")) {
											flatBuffer.append(aDIDASEdiCustInfoVOs.get(k).getPtBa());
										}
										flatBuffer.append("\n");

										// End PT_COM
										flatBuffer.append("}PT_COM");
										flatBuffer.append("\n");
									}
								} else if (ptCtas[ptCtaCount].equals("BK")) {
									// Set PT_CTA_CONTACT
									flatBuffer.append("PT_CTA_CONTACT:");
									flatBuffer.append("");
									flatBuffer.append("\n");

									// Start PT_COM
									flatBuffer.append("{PT_COM");
									flatBuffer.append("\n");

									// Set PT_COM_QLF
									flatBuffer.append("PT_COM_QLF:");
									flatBuffer.append("BA");
									flatBuffer.append("\n");
					
									// Set PT_COM_NBR
									flatBuffer.append("PT_COM_NBR:");
									flatBuffer.append("");
									flatBuffer.append("\n");

									// End PT_COM
									flatBuffer.append("}PT_COM");
									flatBuffer.append("\n");
								}
							} else {
								if (ptCtas[ptCtaCount].equals("IC")) {
									// Set PT_CTA_CONTACT
									flatBuffer.append("PT_CTA_CONTACT:");
									flatBuffer.append(ptCtaContact);
									flatBuffer.append("\n");
								} else if (ptCtas[ptCtaCount].equals("CC")) {
									String ptComs[] = {"EM", "FX","TE","BA"};
									for (int ptComCount=0; ptComCount<ptComs.length; ptComCount++) {
										// Start PT_COM
										flatBuffer.append("{PT_COM");
										flatBuffer.append("\n");

										// Set PT_COM_QLF
										flatBuffer.append("PT_COM_QLF:");
										flatBuffer.append(ptComs[ptComCount]);
										flatBuffer.append("\n");
						
										// Set PT_COM_NBR
										flatBuffer.append("PT_COM_NBR:");
										if (ptComs[ptComCount].equals("FX")) {
											flatBuffer.append(aDIDASEdiCustInfoVOs.get(k).getPtFax());
										} else if (ptComs[ptComCount].equals("EM")) {
											flatBuffer.append(aDIDASEdiCustInfoVOs.get(k).getPtEml());
										} else if (ptComs[ptComCount].equals("TE")) {
											flatBuffer.append(aDIDASEdiCustInfoVOs.get(k).getPtTel());
										} else if (ptComs[ptComCount].equals("BA")) {
											flatBuffer.append(aDIDASEdiCustInfoVOs.get(k).getPtBa());
										}
										flatBuffer.append("\n");

										// End PT_COM
										flatBuffer.append("}PT_COM");
										flatBuffer.append("\n");
									}
								}
							}

							// End PT_CTA
							flatBuffer.append("}PT_CTA");
							flatBuffer.append("\n");
						}
					}

					// End PARTY_INFO
					flatBuffer.append("}PARTY_INFO");
					flatBuffer.append("\n");
				}

				// Start INVOICE_DETAILS
				flatBuffer.append("{INVOICE_DETAILS");
				flatBuffer.append("\n");

				// Start BKG_DETAILS
				flatBuffer.append("{BKG_DETAILS");
				flatBuffer.append("\n");

				// Set BKG_NO
				flatBuffer.append("BKG_NO:");
				flatBuffer.append(adidasEdiMainVO.getBkgNo());
				flatBuffer.append("\n");

				// Set BL_NO
				flatBuffer.append("BL_NO:");
				flatBuffer.append(adidasEdiMainVO.getBlNo());
				flatBuffer.append("\n");

				// Set BKG_VVD
				flatBuffer.append("BKG_VVD:");
				flatBuffer.append(adidasEdiMainVO.getBkgVvd());
				flatBuffer.append("\n");

				// Set FULL_VSL_NM
				flatBuffer.append("FULL_VSL_NM:");
				flatBuffer.append(adidasEdiMainVO.getFullVslNm());
				flatBuffer.append("\n");
				
				// Set VSL_FLAG
				flatBuffer.append("VSL_FLAG:");
				flatBuffer.append(adidasEdiMainVO.getVslFlag());
				flatBuffer.append("\n");

				// Set BL_POR_CD
				flatBuffer.append("BL_POR_CD:");
				flatBuffer.append(adidasEdiMainVO.getBlPorCd());
				flatBuffer.append("\n");

				// Set BL_POR_NM
				flatBuffer.append("BL_POR_NM:");
				flatBuffer.append(adidasEdiMainVO.getBlPorNm());
				flatBuffer.append("\n");

				// Set BL_POL_CD
				flatBuffer.append("BL_POL_CD:");
				flatBuffer.append(adidasEdiMainVO.getBlPolCd());
				flatBuffer.append("\n");

				// Set BL_POL_NM
				flatBuffer.append("BL_POL_NM:");
				flatBuffer.append(adidasEdiMainVO.getBlPolNm());
				flatBuffer.append("\n");

				// Set BL_POD_CD
				flatBuffer.append("BL_POD_CD:");
				flatBuffer.append(adidasEdiMainVO.getBlPodCd());
				flatBuffer.append("\n");

				// Set BL_POD_NM
				flatBuffer.append("BL_POD_NM:");
				flatBuffer.append(adidasEdiMainVO.getBlPodNm());
				flatBuffer.append("\n");

				// Set BL_DEL_CD
				flatBuffer.append("BL_DEL_CD:");
				flatBuffer.append(adidasEdiMainVO.getBlDelCd());
				flatBuffer.append("\n");

				// Set BL_DEL_NM
				flatBuffer.append("BL_DEL_NM:");
				flatBuffer.append(adidasEdiMainVO.getBlDelNm());
				flatBuffer.append("\n");

				// Set POL_DATE
				flatBuffer.append("POL_DATE:");
				flatBuffer.append(adidasEdiMainVO.getPolDate());
				flatBuffer.append("\n");
				
				// Set POD_DATE
				flatBuffer.append("POD_DATE:");
				flatBuffer.append(adidasEdiMainVO.getPodDate());
				flatBuffer.append("\n");

				// Set EXT_CUST_REF
				flatBuffer.append("EXT_CUST_REF:");
				flatBuffer.append(adidasEdiMainVO.getExtCustRef());
				flatBuffer.append("\n");

				// Set BKG_REMARK
				flatBuffer.append("BKG_REMARK:");
				flatBuffer.append(adidasEdiMainVO.getBkgRemark());
				flatBuffer.append("\n");
				
				// Set BL_ON_BOARD_DATE
				flatBuffer.append("BL_ON_BOARD_DATE:");
				flatBuffer.append(adidasEdiMainVO.getBlOnBoardDate());
				flatBuffer.append("\n");
				
				// Set RD_TERM_PRECARRIAGE
				flatBuffer.append("RD_TERM_PRECARRIAGE:");
				flatBuffer.append(adidasEdiMainVO.getRdTermPrecarriage());
				flatBuffer.append("\n");
				
				// Set RD_TERM_ONCARRIAGE
				flatBuffer.append("RD_TERM_ONCARRIAGE:");
				flatBuffer.append(adidasEdiMainVO.getRdTermOncarriage());
				flatBuffer.append("\n");
				

				List<ADIDASEdiCntrVO> adidasEdiCntrVOs = dbDao.searchADIDASEdiCntr(adidasInvoiceEdiVOs[i]);

				for (int cntrCount=0; cntrCount<adidasEdiCntrVOs.size(); cntrCount++) {
					// Start CNTR_GRP
					flatBuffer.append("{CNTR_GRP");
					flatBuffer.append("\n");

					ADIDASEdiCntrVO adidasEdiCntrVO = adidasEdiCntrVOs.get(cntrCount);

					// Set CNTR_NBR
					flatBuffer.append("CNTR_NBR:");
					flatBuffer.append(adidasEdiCntrVO.getCntrNbr());
					flatBuffer.append("\n");

					// Set CNTR_TYPE
					flatBuffer.append("CNTR_TYPE:");
					flatBuffer.append(adidasEdiCntrVO.getCntrType());
					flatBuffer.append("\n");

					// Set CNTR_SIZE
					flatBuffer.append("CNTR_SIZE:");
					String cntrType = adidasEdiCntrVO.getCntrType().substring(1);
					if (cntrType.equals("2")) {
						flatBuffer.append("20");
					} else {
						flatBuffer.append("40");
					}
					flatBuffer.append("\n");

					// Set CNTR_BL_WEIGHT
					flatBuffer.append("CNTR_BL_WEIGHT:");
					flatBuffer.append(adidasEdiCntrVO.getCntrBlWeight());
					flatBuffer.append("\n");
					
					// Set CNTR_BL_VOLUME
					flatBuffer.append("CNTR_BL_VOLUME:");
					flatBuffer.append(adidasEdiCntrVO.getCntrBlVolume());
					flatBuffer.append("\n");
					
					// Set CNTR_RATIO
					flatBuffer.append("CNTR_RATIO:");
					flatBuffer.append(adidasEdiCntrVO.getCntrRatio());
					flatBuffer.append("\n");
					
					// Set BL_COUNT_PER_CNTR
					flatBuffer.append("BL_COUNT_PER_CNTR:");
					flatBuffer.append(adidasEdiCntrVO.getBlCountPerCntr());
					flatBuffer.append("\n");
					
					// Set BL_COUNT_PER_CNTR
					flatBuffer.append("CNTR_BASEDATE_DET_DEM:");
					flatBuffer.append(adidasEdiCntrVO.getCntrBasedateDetDem());
					flatBuffer.append("\n");
					
					// Set BL_COUNT_PER_CNTR
					flatBuffer.append("CNTR_STARTDATE_DET_DEM:");
					flatBuffer.append(adidasEdiCntrVO.getCntrStartdateDetDem());
					flatBuffer.append("\n");
					
					// Set BL_COUNT_PER_CNTR
					flatBuffer.append("CNTR_ONCARRIAGE_TRANSPORT_MODE:");
					flatBuffer.append(adidasEdiCntrVO.getCntrOncarriageTransportMode());
					flatBuffer.append("\n");
					// End CNTR_GRP
					flatBuffer.append("}CNTR_GRP");
					flatBuffer.append("\n");
				}

				List<ADIDASEdiChgVO> adidasEdiChgVOs = dbDao.searchADIDASEdiChg(adidasInvoiceEdiVOs[i]); 

				for (int chgCount=0; chgCount<adidasEdiChgVOs.size(); chgCount++) {
					// Start INV_ITEM
					flatBuffer.append("{INV_ITEM");
					flatBuffer.append("\n");

					ADIDASEdiChgVO adidasEdiChgVO = adidasEdiChgVOs.get(chgCount);

					// Set FC_TYPE
					flatBuffer.append("FC_TYPE:");
					flatBuffer.append(adidasEdiChgVO.getFcType());
					flatBuffer.append("\n");
	
					// Set FC_TEXT
					flatBuffer.append("FC_TEXT:");
					flatBuffer.append(adidasEdiChgVO.getFcText());
					flatBuffer.append("\n");
	
					// Set FC_PERTYPE
					flatBuffer.append("FC_PERTYPE:");
					flatBuffer.append(adidasEdiChgVO.getFcPertype());
					flatBuffer.append("\n");
	
					// Set FC_REVENUETON
					flatBuffer.append("FC_REVENUETON:");
					flatBuffer.append(adidasEdiChgVO.getFcRevenueton());
					flatBuffer.append("\n");
	
					// Set FC_RATE
					flatBuffer.append("FC_RATE:");
					flatBuffer.append(adidasEdiChgVO.getFcRate());
					flatBuffer.append("\n");
	
					// Set FC_AMOUNT
					flatBuffer.append("FC_AMOUNT:");
					flatBuffer.append(adidasEdiChgVO.getFcAmount());
					flatBuffer.append("\n");
	
					// Set FC_RATE_CURR
					flatBuffer.append("FC_RATE_CURR:");
					flatBuffer.append(adidasEdiChgVO.getFcRateCurr());
					flatBuffer.append("\n");
	
					// Set FC_EXCHRATE
					flatBuffer.append("FC_EXCHRATE:");
					flatBuffer.append(adidasEdiChgVO.getFcExchrate());
					flatBuffer.append("\n");
	
					// Set FC_INV_AMT
					flatBuffer.append("FC_INV_AMT:");
					double amount = new Double(adidasEdiChgVO.getFcAmount()).doubleValue();
					double rate = new Double(adidasEdiChgVO.getFcExchrate()).doubleValue();
					double fcInvAmt = amount * rate;
					DecimalFormat decimalFormat = new DecimalFormat("############.##");
					flatBuffer.append(decimalFormat.format(fcInvAmt));
					flatBuffer.append("\n");
	
					// Set FC_VAT_IND
					flatBuffer.append("FC_VAT_IND:");
					flatBuffer.append(adidasEdiChgVO.getFcVatInd());
					flatBuffer.append("\n");
	
					// Set FC_PAYAT
					flatBuffer.append("FC_PAYAT:");
					flatBuffer.append(adidasEdiMainVO.getFcPayat().equals("I") ? "C" : "P");
					flatBuffer.append("\n");
	
					// Set FC_REMARKS
					flatBuffer.append("FC_REMARKS:");
					flatBuffer.append(adidasEdiChgVO.getFcRemarks());
					flatBuffer.append("\n");

					// End INV_ITEM
					flatBuffer.append("}INV_ITEM");
					flatBuffer.append("\n");
				}

				// End BKG_DETAILS
				flatBuffer.append("}BKG_DETAILS");
				flatBuffer.append("\n");

				// Set BL_COUNT_PER_INV
				flatBuffer.append("BL_COUNT_PER_INV:");
				flatBuffer.append("1");
				flatBuffer.append("\n");
				
				
				// End INVOICE_DETAILS
				flatBuffer.append("}INVOICE_DETAILS");
				flatBuffer.append("\n");

				// End INVOICE_HDR
				flatBuffer.append("}INVOICE_HDR");

				reString = eaiDao.sendToEDI(mqName, flatBuffer.toString());

				log.debug("#####################################################");
                log.debug(" EDI 전송 끝 : " + ("E".equals(reString) ? "실패!" : "성공!"));
                log.debug("#####################################################");  
                
                /*
                 	ANRSO   -- FNS_INV_0505.mrd  RD_APPL_CD : INV011
					BUDSC   -- FNS_INV_0506.mrd  RD_APPL_CD : INV012
					FXTSC   -- FNS_INV_0521.mrd  RD_APPL_CD : INV028
					GDYSC   -- FNS_INV_0508.mrd  RD_APPL_CD : INV014
					GOASC   -- FNS_INV_0504.mrd  RD_APPL_CD : INV010
					HAMRU   -- FNS_INV_0503.mrd  RD_APPL_CD : INV009
					HAMSC   -- FNS_INV_0503.mrd  RD_APPL_CD : INV009
					LEHSC   -- FNS_INV_0522.mrd  RD_APPL_CD : INV029
					PRGSC   -- FNS_INV_0509.mrd  RD_APPL_CD : INV015
					RTMSC   -- FNS_INV_0507.mrd  RD_APPL_CD : INV013
					VLCSC   -- FNS_INV_0510.mrd  RD_APPL_CD : INV016 
                 */
                
                String rdApplCd ="";
                
                if(ofcCd.equals("ANRSO")){
                	rdApplCd ="INV011";
                }else if(ofcCd.equals("BUDSC")){
                	rdApplCd ="INV012";
                }else if(ofcCd.equals("FXTSC")){
                	rdApplCd ="INV028";
                }else if(ofcCd.equals("GDYSC")){
                	rdApplCd ="INV014";
                }else if(ofcCd.equals("GOASC")){
                	rdApplCd ="INV010";
                }else if(ofcCd.equals("HAMRU")){
                	rdApplCd ="INV009";
                }else if(ofcCd.equals("HAMSC")){
                	rdApplCd ="INV009";
                }else if(ofcCd.equals("LEHSC")){
                	rdApplCd ="INV029";
                }else if(ofcCd.equals("PRGSC")){
                	rdApplCd ="INV015";
                }else if(ofcCd.equals("RTMSC")){
                	rdApplCd ="INV013";
                }else if(ofcCd.equals("VLCSC")){
                	rdApplCd ="INV016";
                }else{
                	rdApplCd ="INV009";
                }
                
                StringBuilder sbParam = new StringBuilder();
                if(!reString.equals("E")){
                	sbParam.append("/rv");
            		sbParam.append(" frm1_inv_no[").append(adidasEdiMainVO.getInvNumber()).append("]");
            		sbParam.append(" frm1_logo[ORIGINAL]");
            		sbParam.append(" frm1_login_nm[").append(usrId).append("]");
            		sbParam.append(" frm1_ofc_cd[").append(rdApplCd).append("]");
            		sbParam.append(" rm1_line_num[18]");
            		sbParam.append(" frm1_vsl_cd[").append(adidasEdiMainVO.getBkgVvd().substring(0,4)).append("]");
            		sbParam.append(" frm1_skd_voy_no[").append(adidasEdiMainVO.getBkgVvd().substring(4,8)).append("]");
            		sbParam.append(" frm1_skd_dir_cd[").append(adidasEdiMainVO.getBkgVvd().substring(8)).append("]");
            		sbParam.append(" frm1_port_cd[").append(adidasEdiMainVO.getBlPolCd()).append("]");
            		sbParam.append(" frm1_att_gb[N]");
            		sbParam.append(" frm1_att_gb2[Y]");
            		sbParam.append(" frm1_cust_cnt_cd[").append(adidasEdiMainVO.getPtCd().substring(0, 2)).append("]");
            		sbParam.append(" frm1_cust_seq[").append(adidasEdiMainVO.getPtCd().substring(2)).append("]");
            		//sbParam.append(" frm1_cust_cnt_cd[DE]"); 
            		//sbParam.append(" frm1_cust_seq[5461]");
            		sbParam.append(" /rp []");
            	 	
             		String ddmmyyyy = (new SimpleDateFormat("ddmmyyyy")).format(new Date());

            		Ftp invFtp = new Ftp();
            		invFtp.setRdApplCd(rdApplCd);
            		invFtp.setRdParaCtnt(sbParam.toString());
            		invFtp.setSubSysCd("INV"); 
            		invFtp.setUserId(usrId);
//            		invFtp.setXptFileNm("HJSC" + "_" + adidasEdiMainVO.getInvNumber() + "_" + ddmmyyyy + ".pdf");
            		invFtp.setXptFileNm("SMLM" + "_" + adidasEdiMainVO.getInvNumber() + "_" + ddmmyyyy + ".pdf");

 					try {
 						invFtp.sendEsvcReportFile("ADIDAS");
 					} catch (Exception e) {
 						log.error(e.getMessage());
 					}

                }
                
				if (!reString.equals("E")) {
					dbDao.addEdiADIDAS(adidasInvoiceEdiVOs[i]);
				}
                
			}
		} catch (DAOException e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), e);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getUserMessage(), e);
		}
	}

	
}
