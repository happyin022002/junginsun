/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ClaimInvoiceSC.java
 *@FileTitle : Claim Invoice Creation - CSR
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.10.05 박제성 , 진윤오 , 정행룡 , 양정란 , 윤세영
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.cps.cni.claiminvoice;




import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.basic.PaymentInvoiceBC;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.basic.PaymentInvoiceBCImpl;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.event.CpsCni0045Event;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.event.CpsCni0048Event;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo.ArRevenueVVDVO;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo.CsrManagerListCondVO;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo.CsrManagerListVO;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo.PaymentInvoiceInfoVO;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo.PaymentInvoiceVO;
import com.clt.apps.opus.cps.cni.claiminvoice.paymentinvoice.vo.VendorInfoVO;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.basic.CodeMgtBC;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.basic.CodeMgtBCImpl;
import com.clt.apps.opus.cps.cni.codemgt.codemgt.vo.MiscellaneousVO;
import com.clt.apps.opus.cps.cni.common.CniConst;
import com.clt.apps.opus.cps.cni.common.CniUtil;
import com.clt.apps.opus.cps.cni.common.basic.CniCommonBC;
import com.clt.apps.opus.cps.cni.common.basic.CniCommonBCImpl;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.basic.ClaimMainBC;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.basic.ClaimMainBCImpl;
import com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo.CniCgoClmCostVO;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.basic.StatementCommonBC;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.basic.StatementCommonBCImpl;
import com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo.APCostActivityInfoVO;
import com.clt.bizcommon.csr.csrcommon.csrexternalfinder.basic.CSRExternalFinderBC;
import com.clt.bizcommon.csr.csrcommon.csrexternalfinder.basic.CSRExternalFinderBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;


/**
 * ClaimInvoiceSC Logic ServiceCommand
 * 코드및 기준정보 관리
 * 
 * @author 박제성 , 진윤오 , 정행룡 , 양정란 , 윤세영
 * @see 
 * @since J2EE 1.4 
 */

public class ClaimInvoiceSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
	
	
	/**
	 * ClaimInvoiceSC system 선처리 작업<br>
	 * 객체 생성
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
			// 사용자 Role정보 
			String roles = CniUtil.getRoles(account);	
			
			if (StringUtils.isEmpty(roles)) {
				CniCommonBC cmd = new CniCommonBCImpl();				
				CniUtil.setRoles(account, 
						cmd.searchUserRoleList(account.getUsr_id()));
				
			}		
			
			// 사용자 Area정보 취득 
			String area = CniUtil.getAreaInfo(account);	
			
			if (StringUtils.isEmpty(area)) {
				CniCommonBC cmd = new CniCommonBCImpl();				
				CniUtil.setAreaInfo(account, 
						cmd.searchUserArea(account.getOfc_cd()));				
			}		
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
		}
	}

	/**
	 * ClaimInvoiceSC system 후처리 작업<br>
	 */
	public void doEnd() {
		log.debug("ClaimInvoiceSC 종료");
	}

	// ************************************************************************************************
	
	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ClaimInvoiceSC 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {

		// 이벤트 정보
		//2011-12-06 [소스품질 조치사항]사용하지 않는 지역 변수를 점검한다.
		EventResponse eventResponse = null;
		// 이벤트 명 취득
		String eventName = e.getEventName();
		//String eventName = "CpsCni9999Event";
		// Command 명 취득
		FormCommand cmd = e.getFormCommand();
        
		
		// ===========================================================================
		// 진윤오
		// ===========================================================================
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0045] Invoice Creation
		// ---------------------------------------------------------------------------
		if ("CpsCni0045Event".equalsIgnoreCase(eventName)) {							
			// [Retrieve , Open]
			if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				eventResponse = searchPaymentInvoiceList(e);
			// [row double click]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchPaymentInvoiceInfo(e);				
			// [Save]
			} else if (cmd.isCommand(FormCommand.MULTI)) {
				eventResponse = managePaymentInvoice(e);
			} 
 		// ---------------------------------------------------------------------------
		// [CPS_CNI_0048] CSR Manager
		// ---------------------------------------------------------------------------
		} else	if ("CpsCni0048Event".equalsIgnoreCase(eventName)) {							
				// [Retrieve]
				if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
					eventResponse = searchCsrManagerList(e);
				// [default]
				} else if (cmd.isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchCsrManagerOpen(e);
				} 
			}
				
		return eventResponse;
	}
	
	// ===========================================================================
	// 진윤오
	// ===========================================================================
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0048] CSR Manager
	// ---------------------------------------------------------------------------
	/**
	 * CSR Manager Open<br>
	 * @author 진윤오
	 * @category CPS_CNI_0048
	 * @category searchCsrManagerOpen 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCsrManagerOpen(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		try {
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
			
			//Area 09
			List<MiscellaneousVO> list = command.searchMiscellaneousList("09");
			
			// 로컬 현재일 , 이전 한달
			//현재일 설정			
			String gmtDate = command.searchGmtDate(account.getUsr_id());	
			
			if (!StringUtils.isEmpty(gmtDate)) {
				String yyyymmdd = gmtDate.replaceAll("\\-", "");
				Calendar cal = Calendar.getInstance();
				int year = new Integer(yyyymmdd.substring(0,4)).intValue();
				int month = new Integer(yyyymmdd.substring(4,6)).intValue() -1;
				int date = new Integer(yyyymmdd.substring(6,8)).intValue();
				cal.set(year, month, date);
				cal.add(Calendar.MONTH, -1);
				SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
				String fmEffDt = fmt.format(cal.getTime());
				
				eventResponse.setETCData("FM_EFF_DT", fmEffDt);	
				eventResponse.setETCData("TO_EFF_DT", gmtDate);
				
			}
			
			eventResponse.setRsVoList(list);		
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}			
	
	/**
	 * CSR Manager List<br>
	 * @author 진윤오
	 * @category CPS_CNI_0048
	 * @category searchCsrManagerList 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCsrManagerList(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		try {
			// BC 객체 생성
			PaymentInvoiceBC command = new PaymentInvoiceBCImpl();
			CpsCni0048Event event = (CpsCni0048Event)e;
			CsrManagerListCondVO condVo = event.getCsrManagerListCondVO();	
			
			// CSR Manager List 취득
			List<CsrManagerListVO> list = 
				command.searchCsrManagerList(condVo);
			
			eventResponse.setRsVoList(list);		
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}			
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0045] Invoice Creation
	// ---------------------------------------------------------------------------
	/**
	 * 지불전표 리스트 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0045
	 * @category searchPaymentInvoiceList 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPaymentInvoiceList(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		try {
			// BC 객체 생성
			PaymentInvoiceBC command = new PaymentInvoiceBCImpl();
	
			CpsCni0045Event event = (CpsCni0045Event)e;
			String cgoClmNo = event.getCgoClmNo();			
			String hdlrUsrId = account.getUsr_id();
			
			// Party Inquiry  List 취득
			List<PaymentInvoiceVO> list = 
				command.searchPaymentInvoiceList(cgoClmNo, hdlrUsrId);
			//SESSION 에 CLAIM_NO 세팅. 조회결과가 있는 경우만 세팅함.
			if(list.size() > 0){
				CniUtil.setCargoClaimNo(account, cgoClmNo);
			} else {
				CniUtil.setCargoClaimNo(account, "");
			}
			
			eventResponse.setRsVoList(list);		
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}		
	

	/**
	 * 지불전표 정보 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0045
	 * @category searchPaymentInvoiceInfo 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPaymentInvoiceInfo(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		try {
			// BC 객체 생성
			PaymentInvoiceBC command = new PaymentInvoiceBCImpl();
	
			CpsCni0045Event event = (CpsCni0045Event)e;
			String cgoClmPayNo = event.getCgoClmPayNo();			
			
			// Party Inquiry  List 취득
			PaymentInvoiceInfoVO vo = 
				command.searchPaymentInvoiceInfo(cgoClmPayNo);			
			
			eventResponse.setRsVo(vo);
			
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * 지불전표   수정 ,입력<br>
	 * @author 진윤오
	 * @category CPS_CNI_0045
	 * @category managePaymentInvoice 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePaymentInvoice(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		try {
			
			begin();
			// BC 객체 생성
			PaymentInvoiceBC command = new PaymentInvoiceBCImpl();
			
			CpsCni0045Event event = (CpsCni0045Event)e;
			
			// party 컨테이너 VO		
			PaymentInvoiceInfoVO  infoVo = event.getPaymentInvoiceInfoVO();
			// user id
			String usrId = account.getUsr_id();		
			
			String cgoClmPayNo  = infoVo.getCgoClmPayNo();		
			
			// ======================================================
			// 공통 CSR 호출
			//  ======================================================			
			CSRExternalFinderBC csrCmd = new CSRExternalFinderBCImpl();
			
			// -------------------------------------------------------
			// 인보이스 정보 설정
			// -------------------------------------------------------
			ApPayInvVO apPayInvVO = new ApPayInvVO();
			// 모듈명 (CNI) 추가 
			apPayInvVO.setInvSubSysCd(CniConst.INV_SUB_SYS_CD);
			// 접수(Invoice)오피스
			apPayInvVO.setInvOfcCd(infoVo.getInvOfcCd());
			// 비용처리오피스 취득
			String costOfcCd = command.searchCostOfcCd(infoVo.getInvOfcCd());
			if (costOfcCd == null || "".equals(costOfcCd)) {
				// 에러메세지설정
				//"{?msg1} doesn't exist."
				eventResponse.setETCData("ERROR", "1");
				return eventResponse;
			}
			apPayInvVO.setCostOfcCd(costOfcCd);			
			//지급처(청구처)
			String vndrSeq = infoVo.getVndrSeq();
			apPayInvVO.setVndrSeq(vndrSeq);
			// --------------------------------------------
			//Invoice 번호
			// ERP KEY : InvoiceNO , VendorSeq
			// --------------------------------------------
			//Invoice + HHmmss
			String invNo = infoVo.getInvNo();
			
			//SimpleDateFormat df = new SimpleDateFormat("HHmmss");
			//invNo  = invNo + df.format(new Date()); 
			
			apPayInvVO.setInvNo(invNo);			
			// Invoice 발행일
			apPayInvVO.setInvIssDt(CniUtil.getFmtDt(infoVo.getInvDt()));
			// Invoice 접수일
			apPayInvVO.setInvRcvDt(CniUtil.getFmtDt(infoVo.getPayDt()));
			// 비용 지급 만료일
			apPayInvVO.setInvEffDt(CniUtil.getFmtDt(infoVo.getInvEffDt()));			
			// Payment Terms
			
			// Curr Cd
			apPayInvVO.setInvCurrCd(infoVo.getLoclCurrCd());
			// ----------------------------
			// Venddor 정보 취득 
			// ----------------------------
			VendorInfoVO vendorInfo = command.searchVendorInfo(vndrSeq);
			String payCurrCd = apPayInvVO.getInvCurrCd();
			String genPayTermCd = "";
			if (vendorInfo != null) {
				genPayTermCd = vendorInfo.getGenPayTermCd();
				if (StringUtils.isEmpty(payCurrCd)) {
					payCurrCd = vendorInfo.getPayCurrCd();
				}
			}
			
			apPayInvVO.setVndrTermNm(genPayTermCd);
			//TLL_DIV_CD 
			String ttlLssDivCd = "";
			String costTpCd = infoVo.getClmCostTpCd();
			if (costTpCd == null) {
				costTpCd = "";
			}
			
			// Prepayment 의 경우 'CP' 생성
			if (costTpCd.endsWith("P")) {
				ttlLssDivCd = "CP";
			}
			
			apPayInvVO.setTtlLssDivCd(ttlLssDivCd);			
			// 통화코드			
			apPayInvVO.setInvCurrCd(payCurrCd);
			// 청구 총 금액
			apPayInvVO.setInvTtlAmt(CniUtil.removeCommaAmt(infoVo.getInvAmt()));
			// 총 세금액
			apPayInvVO.setInvVatAmt(CniUtil.removeCommaAmt(infoVo.getInvVatAmt()));
			// 세금공제 금액
			BigDecimal invAmt = new BigDecimal(apPayInvVO.getInvTtlAmt());
			BigDecimal invVatAmt  = new BigDecimal(apPayInvVO.getInvVatAmt());
			BigDecimal invNetAmt = invAmt.subtract(invVatAmt);			
			apPayInvVO.setInvNetAmt(invNetAmt.toPlainString());
			// 원천징수 세금액 특정지역에서 발생
			apPayInvVO.setWhldTaxAmt(CniUtil.removeCommaAmt(infoVo.getWhldTaxAmt()));
			// Invoice Status Code 최초생성은 C  comfirmed
			apPayInvVO.setInvStsCd("C"); 
			// 인보이스 특이사항
			apPayInvVO.setInvRmk(infoVo.getCostDesc());
			//CRE_USR_ID
			apPayInvVO.setCreUsrId(account.getUsr_id());
			//UPD_USR_ID
			apPayInvVO.setUpdUsrId(account.getUsr_id());
			// DEL_FLAG
			apPayInvVO.setDeltFlg("N");
			
			// =========================================================
			// 인보이스 상세 정보 설정
			// =========================================================			
			ApPayInvDtlVO apPayInvDtlVO = new ApPayInvDtlVO();
		
			// --------------------------------
			// 재무항차 취득 
			// --------------------------------
			//실제 항차 
			String vvd = infoVo.getTrnkRefVvdNo();	
			// AP 비용 코드
			apPayInvDtlVO.setAcctCd(infoVo.getAcctCd());
			// AP 비용 
			apPayInvDtlVO.setInvAmt(apPayInvVO.getInvNetAmt());		
			
			//재무 항차 취득
			String vslCd = vvd.substring(0,4);
			String skdVoyNo = vvd.substring(4,8);
			String skdDirCd = vvd.substring(8,9);
			String slanCd = infoVo.getSlanCd();
			ArRevenueVVDVO paramVo = new ArRevenueVVDVO();
			paramVo.setVslCd(vslCd);
			paramVo.setSkdVoyNo(skdVoyNo);
			paramVo.setSkdDirCd(skdDirCd);
			paramVo.setSlanCd(slanCd);
			
			ArRevenueVVDVO arVo  = command.searchRevenueVVDInfo(paramVo, 
					apPayInvVO.getInvIssDt(), 
					costOfcCd);
			
			if (arVo == null) {
				// 에러메세지설정
				//"{?msg1} doesn't exist."
				eventResponse.setETCData("ERROR", "2");
				return eventResponse;
			}
			
			// -----------------------------------------------
			// 재무항차 설정
			// -----------------------------------------------
			// 선박의 코드					
			apPayInvDtlVO.setVslCd(arVo.getVslCd());
			// 항차			
			apPayInvDtlVO.setSkdVoyNo(arVo.getSkdVoyNo());
			// Direction			
			apPayInvDtlVO.setSkdDirCd(arVo.getSkdDirCd());
			// Revenue Direction
			apPayInvDtlVO.setRevDirCd(arVo.getRlaneDirCd());
			
			//항로
			apPayInvDtlVO.setSlanCd(infoVo.getSlanCd());
			// 실제 항차
			apPayInvDtlVO.setActVvdCd(vvd);
			
			// CRE_USR_ID
			apPayInvDtlVO.setCreUsrId(account.getUsr_id());
			//UPD_USR_ID
			apPayInvDtlVO.setUpdUsrId(account.getUsr_id());	
			// DEL_FLAG
			apPayInvDtlVO.setDeltFlg("N");			
			//ibflag 설정 인서트
			apPayInvDtlVO.setIbflag("I");
			
			StatementCommonBC actInfoCmd = new StatementCommonBCImpl();
			List<APCostActivityInfoVO> actInfo = actInfoCmd.searchAPCostActivityInfoList("CNI", costTpCd, "N");

		   //2014-10-14 NYK Activate date and place BIZ logic added 
		   //apPayInvVO.setActDt(CniUtil.getFmtDt(infoVo.getInvDt())); // AP_INV_HDR
			if("ISSUE DATE".equals(actInfo.get(0).getActDtNm())){
				apPayInvDtlVO.setActDt(CniUtil.getFmtDt(infoVo.getInvDt()));
			}else{
				apPayInvDtlVO.setActDt("");
			}
			
			if("COST OFFICE".equals(actInfo.get(0).getActPlcNm())){
				apPayInvDtlVO.setActPlc(costOfcCd); // AP_PAY_INV_DTL 
			}else{
				apPayInvDtlVO.setActPlc("");
			}
		   //apPayInvDtlVO.setSlanCd(infoVo.getSlanCd()); -- No changed
			
			// Cni에서는 한개의 Detail 만 존재...
			ApPayInvDtlVO[] apPayInvDtlVOs = new ApPayInvDtlVO[]{apPayInvDtlVO};
			//생성
			String invRgstNo = csrCmd.createApPayInvInfo(apPayInvVO,
					apPayInvDtlVOs, account);			
			
			// ======================================================		
			// INV_RGST_NO Cost 테이블 Update
			// ======================================================
			CniCgoClmCostVO vo = new CniCgoClmCostVO();
			vo.setCgoClmPayNo(cgoClmPayNo);
			vo.setInvRgstNo(invRgstNo);
			vo.setUpdUsrId(usrId);			
			
			ClaimMainBC mainCmd = new ClaimMainBCImpl();			
			mainCmd.manageHandlingCostInvRgstNo(vo);
			
			// 성공 메세지설정
			eventResponse.setUserMessage(new ErrorHandler("CNI00008")
					.getUserMessage());
			eventResponse.setETCData("ERROR", "N");
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	
	
		return eventResponse;
	}	
		


	


}