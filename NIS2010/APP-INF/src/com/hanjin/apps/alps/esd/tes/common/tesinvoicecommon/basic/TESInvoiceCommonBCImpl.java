/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESInvoiceCommonBCImpl.java
*@FileTitle : TES Invoice Common 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-10-31 byungheeyoo
* 1.0 최초 생성
 * 2009-05-29 [N200905280100] : TPB I/F 누락 방지 추가
 * 2009-08-27 [PJM-200900072] : 부산신항만(180020)용 getAutoFPmode 조회 기능 추가.
							   EDI Invoice 정규 Invoice 전환에 부산신항만(180020) 추가
							        신규로 추가 하려는 Invoice(VNDR_SEQ + INV_NO)가 정상적인 EDI invoice에 존재 여부를 확인한다.
 * 2009-10-26 [ITM-200900174] : 미사용 변수 제거 							        
 * 2010-11-11 박재흥 [CHM-201006940-01] INV AUTO CALC CHECK
 * 2011.08.08 윤태승 [CHM-201111829-1] Split 12-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.basic;

import java.util.ArrayList;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.tes.common.tesinterface.event.IfEsdTes0200Event;
import com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.event.EsdTes9310Event;
import com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.event.TESInvoiceCommonEvent;
import com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.integration.TESInvoiceCommonDBDAO;
import com.hanjin.apps.alps.esd.tes.common.vo.TesCommonVO;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0001Event;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event.EsdTes0013Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;

/**
 * ALPS-ESD Business Logic Basic Command implementation<br>
 * - ALPS-ESD에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author byungheeyoo
 * @see TESInvoiceCommonBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class TESInvoiceCommonBCImpl   extends BasicCommandSupport implements TESInvoiceCommonBC {

	// Database Access Object
	private transient TESInvoiceCommonDBDAO dbDao=null;

	/**
	 * TESInvoiceCommonBCImpl 객체 생성<br>
	 * TESInvoiceCommonDBDAO를 생성한다.<br>
	 */
	public TESInvoiceCommonBCImpl(){
		dbDao = new TESInvoiceCommonDBDAO();
	}
	
	
	/**
	 * ofc_cd에 따라 Withholding tax입력 mode를 가져온다.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getWHTmode(Event e) throws EventException {
		log.debug("\n\n BC.getWHTmode \n");
		
		TESInvoiceCommonEvent	event			= (TESInvoiceCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		try {
			eventResponse.setRs (dbDao.getWHTmode(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * (calc 계산시) agreement의 currency code를 가져온다.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getAgmtCurrCD(Event e) throws EventException {
		log.debug("\n\n BC.getAgmtCurrCD \n");
		TESInvoiceCommonEvent	event			=(TESInvoiceCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		try {
			
			if ( "TM".equals( event.getTesTmlSoHdrVO().getTmlInvTpCd() ) ) {	// Terminal Invoice
				event.getTesCommonVO().setFromDate( event.getTesCommonVO().getAtbDt() );
				event.getTesCommonVO().setToDate( event.getTesCommonVO().getAtbDt() );
			} else if ("ON".equals( event.getTesTmlSoHdrVO().getTmlInvTpCd() ) ) {	// OnDock
				event.getTesCommonVO().setFromDate( event.getTesCommonVO().getMinWrkDt() );
				event.getTesCommonVO().setToDate( event.getTesCommonVO().getMaxWrkDt() );
			} else if ("OF".equals( event.getTesTmlSoHdrVO().getTmlInvTpCd() ) ) {	// Storage, OffDock
				event.getTesCommonVO().setFromDate( event.getTesTmlSoHdrVO().getToPrdDt() );
				event.getTesCommonVO().setToDate( event.getTesTmlSoHdrVO().getToPrdDt() );
			} else if ("ST".equals( event.getTesTmlSoHdrVO().getTmlInvTpCd() ) ) {
				event.getTesCommonVO().setFromDate( event.getTesTmlSoHdrVO().getFmPrdDt() );
				event.getTesCommonVO().setToDate( event.getTesTmlSoHdrVO().getFmPrdDt() );
			}
			
			eventResponse.setRs ( dbDao.getAgmtCurrCD(event) );
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );

			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * (calc 계산시) agreement의 currency code를 가져온다.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getAgmtSts(Event e) throws EventException {
		log.debug("\n\n BC.getAgmtSts \n");
		TESInvoiceCommonEvent	event			= (TESInvoiceCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();
		try {
			
			if ( "TM".equals( event.getTesTmlSoHdrVO().getTmlInvTpCd() ) ) {	// Terminal Invoice
				event.getTesCommonVO().setFromDate( event.getTesCommonVO().getAtbDt() );
				event.getTesCommonVO().setToDate( event.getTesCommonVO().getAtbDt() );
			} else if ("ON".equals( event.getTesTmlSoHdrVO().getTmlInvTpCd() ) ) {	// OnDock
				event.getTesCommonVO().setFromDate( event.getTesCommonVO().getMinWrkDt() );
				event.getTesCommonVO().setToDate( event.getTesCommonVO().getMaxWrkDt() );
			} else if ("OF".equals( event.getTesTmlSoHdrVO().getTmlInvTpCd() ) ) {	// OffDock
				event.getTesCommonVO().setFromDate( event.getTesTmlSoHdrVO().getToPrdDt() );
				event.getTesCommonVO().setToDate( event.getTesTmlSoHdrVO().getToPrdDt() );
			} else if ("ST".equals( event.getTesTmlSoHdrVO().getTmlInvTpCd() ) ) {	// Storage
				event.getTesCommonVO().setFromDate( event.getTesTmlSoHdrVO().getFmPrdDt() );
				event.getTesCommonVO().setToDate( event.getTesTmlSoHdrVO().getFmPrdDt() );
			} 		
			
			eventResponse.setRs ( dbDao.getAgmtSts( event ) );
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}

	/**
	 * (TPB 입력시) COST CODE의 N3PTY_BIL_CS_CD를 가져온다.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getN3ptyBilCSCD(Event e) throws EventException {
		log.debug("\n\n BC.getN3ptyBilCSCD \n");
		TESInvoiceCommonEvent event=(TESInvoiceCommonEvent)e;
		GeneralEventResponse	eventResponse = new GeneralEventResponse();
		Map<String, String>		etcData			= new HashMap<String, String>();
		
		try {
			eventResponse.setRs (dbDao.getN3ptyBilCSCD(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}	

	/**
	 * (주어진 조건에 따라) ERR_INV_NO를 가져온다.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse isValidErrInvNo(Event e) throws EventException {
		log.debug("\n\n BC.isValidErrInvNo \n");
		
		TESInvoiceCommonEvent event=(TESInvoiceCommonEvent)e;
		GeneralEventResponse	eventResponse = new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();
	
		try {
			eventResponse.setRs (dbDao.isValidErrInvNo(event));
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}	
	
	/**
	 * invoice의 상태를 확인
	 * @param TesTmlSoHdrVO model
	 * @param String mode
	 * @exception EventException
	 */
	public void checkInvoiceStatus(TesTmlSoHdrVO model, String mode) throws EventException {
		log.debug("\n\n BC.checkInvoiceStatus \n");
	
		try {
			dbDao.checkInvoiceStatus(model, mode);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * invoice의 상태를 확인
	 * @param TesTmlSoHdrVO[] tesTmlSoHdrVOs
	 * @param String mode
	 * @exception EventException
	 */
	public void checkInvoiceStatus(TesTmlSoHdrVO[] tesTmlSoHdrVOs, String mode) throws EventException {
		log.debug("\n\n BC.checkInvoicesStatus \n");
	
		try {
			dbDao.checkInvoiceStatus(tesTmlSoHdrVOs, mode);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * invoice의 상태를 확인
	 * @param String csrNo
	 * @param String mode
	 * @exception EventException
	 */
	public void checkInvoiceStatus(String csrNo, String mode) throws EventException {
		log.debug("\n\n BC.checkInvoicesStatus \n");
	
		try {
			dbDao.checkInvoiceStatus(csrNo, mode);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * EDI Invoice Validation
	 * @param Event e
	 * @exception EventException
	 */
	public void validateEDIInvoice(Event e) throws EventException {
		
		log.debug("\n\n BC.validateEDIInvoice EVENT NAME : "+e.getEventName());
		
		IfEsdTes0200Event event = (IfEsdTes0200Event)e;
		TesEdiSoHdrVO tesEdiSoHdrVO = event.getTesEdiSoHdrVO();		
		log.debug("\n  -->>> TESCOMBCIMPL.validateEDIInvoice - UpdUsrId : "+JSPUtil.getNull(tesEdiSoHdrVO.getUpdUsrId())+"\n");
//		tesEdiSoHdrVO.setUpdUsrId( "eNIS_TES" );	
//		if (tesEdiSoHdrVO!=null && tesEdiSoHdrVO.getLoclUpdDt()!=null && !tesEdiSoHdrVO.getLoclUpdDt().trim().equals("")){
//			tesEdiSoHdrVO.setLoclUpdDt( JSPUtil.getNull(tesEdiSoHdrVO.getInvOfcCd()) );
//		}
		log.debug("\n COMBCIMP. validateEDIInvoice - InvOfcCd:" + JSPUtil.getNull(tesEdiSoHdrVO.getInvOfcCd()) + "\n");
		
		StringBuilder	sbuRjctRmk	= new StringBuilder();
		String			rjctRmk1	= null;
		String			rjctRmk2	= null;
		
		try {
			rjctRmk1 = dbDao.validateEDIInvoice01(tesEdiSoHdrVO);
			rjctRmk2 = dbDao.validateEDIInvoice02(tesEdiSoHdrVO);
			
			/**
			 * EDI invoice validation 확인 작업 완료 표시하고,
			 * 하나라도 자동 reject 건수가 있으면, REMARK값에 설정이 되고 AUTO REJECT 처리한다.
			 */
			log.debug("\n\n rjctRmk1:"+rjctRmk1+" - rjctRmk2:"+rjctRmk2+"\n");
			if (rjctRmk1!=null && !rjctRmk1.trim().equals("")) {
				sbuRjctRmk.append(rjctRmk1);
			}
			if (rjctRmk2!=null && !rjctRmk2.trim().equals("")) {
				sbuRjctRmk.append( rjctRmk1!=null && !rjctRmk1.trim().equals("") ? ", " : "" ).append( rjctRmk2 );
			}
			dbDao.setEDIInvoiceValidSts(tesEdiSoHdrVO, sbuRjctRmk.toString() );
			
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * EDI 로 접수받은 Invoice 를 실제 Invoice로 전환시킴
	 * 2009-08-27 [PJM-200900072] : EDI Invoice 정규 Invoice 전환에 부산신항만(180020) 추가
	 * EDI 로 접수받은 Invoice 를 실제 Invoice로 전환시킴
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse convertEDIInvoice2TMLInvoice(Event e) throws EventException {
		
		log.debug("\n\n TESInvoiceCommonBC.convertEDIInvoice2TMLInvoice() -------------------   \n\n");
		
		EsdTes0013Event event = (EsdTes0013Event)e;
		
		TesTmlSoHdrVO tesTmlSoHdrVO = event.getTesTmlSoHdrVO();
		tesTmlSoHdrVO.setUpdUsrId(event.getSignOnUserAccount().getUsr_id());
		tesTmlSoHdrVO.setLoclUpdDt(event.getSignOnUserAccount().getOfc_cd());
		
		String tmlSoSeq 	= null;
		String tmlInvTpCd	= JSPUtil.getNull( tesTmlSoHdrVO.getTmlInvTpCd() );
		String vndrSeq 	 	= JSPUtil.getNull( tesTmlSoHdrVO.getVndrSeq() );

		TesEdiSoHdrVO tesEdiSoHdrVO = event.getTesEdiSoHdrVO();
		tesEdiSoHdrVO.setCreUsrId(event.getSignOnUserAccount().getUsr_id());
		tesEdiSoHdrVO.setLoclCreDt(event.getSignOnUserAccount().getOfc_cd());

		try {
			/**
			 * 2009-08-27 [PJM-200900072] : 신규로 추가 하려는 Invoice(VNDR_SEQ + INV_NO)가 정상적인 정규 invoice에 존재 여부를 확인한다.
			 */
			dbDao.checkRegularInvoiceDup( tesEdiSoHdrVO );
			//dbDao.checkEDIInvoiceDup(event.getParams()); //EDI에서는 검사하지 않는다.
						
			tmlSoSeq = dbDao.convertEDIInvoiceGetTMLSoSeq( tesEdiSoHdrVO );
			log.debug("\n\n tml_inv_tp_cd : "+tesTmlSoHdrVO.getTmlInvTpCd()+" \n\n");
			
			tesEdiSoHdrVO.setTmlSoSeq(tmlSoSeq);
			//event.getParam_map().put("tes_tml_so_hdr_seq", tes_tml_so_hdr_seq);
			
			dbDao.convertEDIInvoiceTesTmlSoHdr(tesEdiSoHdrVO);
			dbDao.convertEDIInvoiceUpdateTesEdiSoHdr(tesEdiSoHdrVO);
			/**
			 * Terminal invoice만 VVD를 VVD TABLE에 넣는다. Terminal invoice의 INVOIE TYPE은 'M~'으로 시작한다. 
			 */
			if (tmlInvTpCd!=null && (tmlInvTpCd.startsWith("M") || tmlInvTpCd.equals("TM"))){
				dbDao.convertEDIInvoiceTmlSoVVDList	(tesEdiSoHdrVO);
			}
			/**
			 * 수동 대상인 경우만 DTL에 넣는다.
			 * -> HIT/YICT의 MA/MK/SC/SE/SF는 전부 자동 대상임 (TM에만 수동비용 사용, ST계열은 전부 자동만 사용) 
			 * -> 부산신항만인 경우 TM/ST 두 경우다 수동 대상 존재함(자동/수동 둘다 가능) - 실제론 ST은 미사용중
			 * -> HJGT는 경우 TM은 자동/수동 둘다 대상 존재하며, ST는 자동만 가능하므로 DTL을 받지 않음 (QUERY 내부적으로 분기 처리)
			 * <중> Terminal invoice인 경우는 반드시 바로 전에 VVD를 TABLE에 넣고 DTL을 넣어야한다.
			 * 2009-10-26 [ITM-200900174] : 미사용 변수 제거 
			 */
			if (tmlInvTpCd!=null && (!tmlInvTpCd.trim().equals("MA") && !tmlInvTpCd.trim().equals("MK") && 
				!tmlInvTpCd.trim().equals("SC") && !tmlInvTpCd.trim().equals("SE") &&
				!tmlInvTpCd.trim().equals("SF")))
			{
				tesEdiSoHdrVO.setTmlInvTpCd(tmlInvTpCd);
				dbDao.convertEDIInvoiceTesTmsSoDtl(tesEdiSoHdrVO);
			}
			
			/**
			 * 부산신항만인 경우는 자동으로 PDF전송이 된 경우가 있어서 정규INVOICE를 걸어준다.
			 * 2011-06-02: HIT/YICT가 PDF 자동 접수 구현전 임시로 막아둠
			 */
			log.debug("\n\n  bbbbbb -  convertEDIInvoiceTES_EDI_SO_FILE ------------------------ vndr_seq:"+JSPUtil.getNull(vndrSeq)+" \n\n");
//			if (vndrSeq!=null && vndrSeq.trim().equals("180020")){
//				dbDao.convertEDIInvoiceTesEdiSoFile(tesEdiSoHdrVO);
//			}
			
			EventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData( "successFlag", "SUCCESS" );
			
			return eventResponse;
			
		} catch (DAOException de) {
			log.error("\n\n ##### TESInvCommBCIMPL err :\n"+de.toString(),de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("\n\n ##### TESInvCommBCIMPL err :\n"+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * TBP I/F DATA 존재 여부, SO_DTL의 FLAG 상태를 확인 ( 2009-06-03 )
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @exception EventException
	 */
	public void checkDetailTpb(TesTmlSoHdrVO tesTmlSoHdrVO) throws EventException {
		log.debug("\n\n BC.checkDetailTpb \n");
		
		try {
			dbDao.checkDetailTpb( tesTmlSoHdrVO );
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 2009-08-27 [PJM-200900072] : 신규로 추가 하려는 Invoice(VNDR_SEQ + INV_NO)가 정상적인 정규 invoice에 존재 여부를 확인한다.	 * 
	 * @param hm
	 * @exception EventException
	 */
	public void checkRegularInvoiceDup(HashMap<String, Object> hm) throws EventException {
		log.debug("\n\n BC.checkRegularInvoiceDup \n");
	
		try {
			TesEdiSoHdrVO tesEdiSoHdrVO = new TesEdiSoHdrVO();
			tesEdiSoHdrVO.setVndrSeq((String)hm.get("vndr_seq"));
			tesEdiSoHdrVO.setInvNo((String)hm.get("inv_no"));
			dbDao.checkRegularInvoiceDup(tesEdiSoHdrVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * 2009-08-27 [PJM-200900072] : 신규로 추가 하려는 Invoice(VNDR_SEQ + INV_NO)가 정상적인 EDI invoice에 존재 여부를 확인한다.	 * 
	 * @param hm
	 * @exception EventException
	 */
	public void checkEDIInvoiceDup(HashMap<String, String> hm) throws EventException {
		log.debug("\n\n BC.checkEDIInvoiceDup \n");
	
		try {
			TesEdiSoHdrVO tesEdiSoHdrVO = new TesEdiSoHdrVO();
			tesEdiSoHdrVO.setVndrSeq((String)hm.get("vndr_seq"));
			tesEdiSoHdrVO.setInvNo((String)hm.get("inv_no"));
			dbDao.checkEDIInvoiceDup(tesEdiSoHdrVO);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * ESD 업무 시나리오 마감작업<br>
	 * TESInvoiceCommon업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
	
	
	/**
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getMgstNos(Event e) throws EventException {
		log.debug("\n\n BC.getMgstNos \n");
		TESInvoiceCommonEvent	event			= (TESInvoiceCommonEvent)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		
		Map<String, String>		etcData			= new HashMap<String, String>();
		try {
			eventResponse.setRs ( dbDao.getMgstNos( event ) );
			etcData.put("successFlag", "SUCCESS" );
			etcData.put("ETC_KEY_NAME", event.getTesCommonVO().getCoid() );
			
			eventResponse.setETCData( etcData );
			
			return eventResponse;
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/** 2010-11-11: [CHM-201006940-01] INV AUTO CALC CHECK
	 * Invoice CF시 Cost Code에 따라 auto calc 체크 확인
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse checkInvCalcCostCD(TesTmlSoHdrVO tesTmlSoHdrVO) throws EventException {
		log.debug("\n\n BC.checkInvCalcCostCD \n");
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			DBRowSet 	costCdSet = dbDao.checkInvCalcCostCD( tesTmlSoHdrVO );
			
			String 		chk				= "";
			String 		tmp_wrong_inv	= "";
			String 		tmp_no_dtl_inv	= "";
			int 		knt_wrong_inv 	= 0;
			int 		knt_no_dtl_inv 	= 0;
			
			while (costCdSet.next()){
				chk = costCdSet.getString("CHK");
				log.debug("\n\n  INV_NO:"+costCdSet.getString("INV_NO") + " - LGS_COST_CD:"+costCdSet.getString("LGS_COST_CD")+"  ---------------------  --------------------- ---------------------  \n\n");
				
				if (chk!=null && chk.trim().equals("N")){
					tmp_wrong_inv = tmp_wrong_inv + ((costCdSet.isFirst()?"":(++knt_wrong_inv>0?", ":"")) + (costCdSet.getString("INV_NO")));
				} else if (chk!=null && chk.trim().equals("NF")){
					tmp_no_dtl_inv = tmp_no_dtl_inv + ((costCdSet.isFirst()?"":(++knt_no_dtl_inv>0?", ":"")) + (costCdSet.getString("INV_NO")));
				}
			}

			log.debug("\n\n %%%%% tmp_wrong_inv : "+tmp_wrong_inv + " %%%%% %%%%% %%%%% \n");
			log.debug("\n\n %%%%% tmp_no_dtl_inv : "+tmp_no_dtl_inv + " %%%%% %%%%% %%%%% \n");
			
			if (tmp_wrong_inv!=null && !tmp_wrong_inv.trim().equals("")){
				throw new EventException(new ErrorHandler("TES00085", new String[]{tmp_wrong_inv}).getMessage());		
			}
			if (tmp_no_dtl_inv!=null && !tmp_no_dtl_inv.trim().equals("")){
				throw new EventException(new ErrorHandler("TES00086", new String[]{tmp_no_dtl_inv}).getMessage());					
			}
			
		} catch(EventException ex) {
			throw ex;
		} catch (DAOException de) {
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new EventException(ex.getMessage());
		} 
		
		return eventResponse;
	}	
	
	/**
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public EventResponse searchOldInvCsrData(Event e) throws EventException {

		EsdTes9310Event	event			= (EsdTes9310Event)e;
		GeneralEventResponse	eventResponse	= new GeneralEventResponse();
		ArrayList  				arrList 		= new ArrayList();
		String ofcCd  							= event.getTesTmlSoHdrVO().getInvOfcCd();
		Map<String, String>	etcData				= new HashMap<String, String>();
		
//		[CHM-201111829] Split 12-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
//		DBRowSet   rowSet 		= new DBRowSet();
		DBRowSet[] rowSetArr 	= new DBRowSet[2];
		
		try {
			rowSetArr[0] = dbDao.searchOldInvData(ofcCd);
			rowSetArr[1] = dbDao.searchOldCsrData(ofcCd);

//			[CHM-201111829] Split 12-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
//			arrList.add(rowSet);
			arrList.add(rowSetArr[0]);
			arrList.add(rowSetArr[1]);
			
			etcData.put("successFlag", "SUCCESS");
			eventResponse.setRsList(arrList);
			eventResponse.setETCData(etcData);
					
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * @param String ofcCd
	 * @return EventResponse
	 * @exception EventException
	 */
	
	public String searchOldInvCsrChk(String ofcCd) throws EventException {

		String invChk = null;
		String csrChk = null;
		String rtnValue = null;
		
		try {
  			invChk = dbDao.searchOldInvExistChk(ofcCd);
			csrChk = dbDao.searchOldCsrExistChk(ofcCd);

			if(("N".equals(invChk) || "".equals(invChk)) && ("N".equals(csrChk) || "".equals(csrChk))){
				rtnValue = "N";
			}else{
				rtnValue = "Y";
			}
			
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
		
 		return rtnValue;
	}
	
	/**
	 * 2011-03-23 : session의 ofc_cd를 기준으로 (session이 아닌) MDM의 CONTI_CD를 조회 
	 * @param ofc_cd
	 * @return String
	 * @throws EventException
	 */
	public String searchContiCd(String ofc_cd) throws EventException {
		
		try {
			return dbDao.searchContiCd(ofc_cd);
		} catch (DAOException ex) {
			throw new EventException(ex.getMessage(),ex);
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(),ex);
		}
	}
	
	/**
	 * SVXXJO 존재 여부 확인
	 * @param TesTmlSoHdrVO[] tesTmlSoHdrVOs
	 * @exception EventException
	 */
	public void searchMinusInvAmtSvxxJoExist(TesTmlSoHdrVO[] tesTmlSoHdrVOs) throws EventException {
		log.debug("\n\n BC.searchMinusInvAmtSvxxJoExist \n");
	
		try {
			dbDao.searchMinusInvAmtSvxxJoExist(tesTmlSoHdrVOs);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
	/**
	 * Agreement 정보 update
	 *
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @param String fromDate
	 * @param String toDate
	 * @exception EventException
	 */
	public void updateInvoiceDetailAgmt(TesTmlSoHdrVO tesTmlSoHdrVO, String fromDate, String toDate) throws EventException {

		if(log.isDebugEnabled())log.debug("\n==========  TESInvoiceCommonBCImpl.updateInvoiceDetailAgmt   ============");

		try {			
			dbDao.updateInvoiceDetailAgmt(tesTmlSoHdrVO, fromDate, toDate);
		} catch (DAOException de) {
			log.error("err "+de.toString(),de);
			throw new EventException(de.getMessage());
		}
	}
	
}
