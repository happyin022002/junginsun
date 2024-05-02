/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : BizCommonSC.java
*@FileTitle : Vessel조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-02
*@LastModifier : sangyool pak
*@LastVersion : 1.0
* 2006-08-02 sangyool pak
* 1.0 최초 생성
* 2009-03-11: [R200903110001] log 생성 기능 제거 처리
* 2009-03-16: [R200903110001] log 생성 기능 복원 처리
* 2009-08-27: [PJM-200900072] EDI 접수 TRANSACTION별 TRY~CATCH문 분리
* 2011-10-13: [CHM-201113119] [TES] HIT의 TES invoice eBilling 2단계(invoice PDF 수신) 개발 진행 요청 * 
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tesinterface;

import java.util.HashMap;

import com.hanjin.apps.alps.esd.tes.common.tescommon.basic.TESCommonBCImpl;
//import com.hanjin.apps.alps.esd.tes.common.tescommon.event.TESCommonEvent;
import com.hanjin.apps.alps.esd.tes.common.tesinterface.basic.TESInterfaceManageBC;
import com.hanjin.apps.alps.esd.tes.common.tesinterface.basic.TESInterfaceManageBCImpl;
import com.hanjin.apps.alps.esd.tes.common.tesinterface.event.IfEsdTes0200Event;
import com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBC;
import com.hanjin.apps.alps.esd.tes.common.tesinvoicecommon.basic.TESInvoiceCommonBCImpl;
//import com.hanjin.framework.component.attachment.file.support.UpdateFileMetaInfo;
//import com.hanjin.framework.component.attachment.file.upload.FileUpload;
//import com.hanjin.framework.component.attachment.file.upload.FileUploadException;
//import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
//import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
//import com.hanjin.syscommon.common.table.TesEdiSoFileVO;
import com.hanjin.syscommon.common.table.TesEdiSoHdrVO;

/**
 * ENIS-BIZCOMMON Business Logic ServiceCommand<br>
 * - ENIS-BIZCOMMON에 대한 비지니스 트랜잭션을 처리한다.<br>
 *
 * @author kimjinjoo
 * @see COM_ENS_0A1EventResponse,VesselDBDAO 참조
 * @since J2EE 1.4
 */
public class TESInterfaceRSC extends ServiceCommandSupport {


	// Login User Information
    private SignOnUserAccount account = null;

    /**
     * BIZCOMMON 업무 시나리오 선행작업<br>
     * Vessel업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            // 일단 comment --> 로그인 체크 부분
            account=getSignOnUserAccount();
        } catch (Exception e) {
            log.error("BizCommonSC 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * BIZCOMMON 업무 시나리오 마감작업<br>
     * Vessel업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("TESInterfaceManageSC 종료");
    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * TES-INTERFACE 업무에서 발생하는 모든 이벤트의 분기처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        if(log.isDebugEnabled()) log.debug("\n RSC.TESInterfaceRSC perform -> ====================================");

        EventResponse eventResponse = null;
//        IfEsdTes0006Event ie = (IfEsdTes0006Event)e;

        /*
         * BizCommonSC에 사용법
         * 1. 각각의 업무에 를 통합하는 SC로써 각 업무에 대한 로직은 아래와 같이 작성한다.
         * 2. BC에 대한 각 업무단 BC를 참조하여야 한다.
         * */

        if(e.getEventName().equalsIgnoreCase("IfEsdTes0200Event")){
        	log.debug("\n RSC.TESInterfaceRSC ::::::: IfEsdTes0200Event");
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
        		eventResponse = createEDIinvoice(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
        		eventResponse = saveEDIPDFfile(e);
        	}
        }
        
        return eventResponse;
    }

	/**
	 * 2009-08-27 : [PJM-200900072] EDI 접수 TRANSACTION별 TRY~CATCH문 분리
	 * createEDIinvoice
	 * @param e
	 * @return
	 * @exception EventException
	 */
	public EventResponse createEDIinvoice(Event e) throws EventException {
		log.debug("\n\n RSC.createEDIinvoice --- \n\n");
		log.error("\n\n RSC.createEDIinvoice --- \n\n");
		EventResponse eventResponse = null;
		TESInterfaceManageBC if_command = null;
		TESInvoiceCommonBC inv_com_command = null;
		String str = null;
		
		try {
			/**
			 * EDI 전문을 위한 임시 기본 ENTITY에 맞게 분해하여 입력.
			 */
			if_command = new TESInterfaceManageBCImpl();
			inv_com_command = new TESInvoiceCommonBCImpl();
			
			str = ((IfEsdTes0200Event)e).getStr();
			
			log.error("\n\n log.error-str : ~~~~~~~~~\n"+str+"~~~~~~~~~ \n\n");
			
			/*  넘어온 전문을 TES의 HDR/CNTR_LIST/DTL에 맞게 분해한다.  */
			eventResponse = if_command.getEDIinvoiceInTESformat(str);
			
			/**
			 * 2010.0930 HDR/CNTR_LIST/DTL 트랜잭션 따로 가지고 간다.
			 */
			// max seq 가지고 온다 + 빡숵 -> vndr 검사를 여기에 넣어버렸다. 빡 이넘씨끼
			if_command.createEDIinvoiceTmpData(eventResponse);
			
			begin();
			/*  임시로 HDR만 확실하게 저장하도록 한다. */
			if_command.createEDInvoiceHDRTmpData(eventResponse);
			commit();
			
			begin();
			/*  분해된 HDR/CNTR_LIST/DTL로 임시 TABLE에 넣는다.  */
			if_command.createEDInvoiceCNTRTmpData(eventResponse);
			/*  분해된 HDR/CNTR_LIST/DTL로 임시 TABLE에 넣는다.  */
			if_command.createEDInvoiceDTLTmpData(eventResponse);
			/*  분해된 HDR/CNTR_LIST/DTL로 임시 TABLE에 넣는다.  */
			if_command.createEDInvoiceAUTOFPTmpData(eventResponse);
			commit();
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		try {
			/**
			 * EDI 전문을 위한 임시 기타 ENTITY 입력 및 수정.
			 */
			begin();
			/*  임시 DATA에 기타 추가 작업을 한다. 기본 DATA에 영향이 없도록 transaction을 분리한다.  */
			if_command.createEDIinvoiceTmpData2(eventResponse);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		try {
			/**
			 * EDI에서 임시로 저장된 invoice의 유효성 검사.
			 */
			HashMap<String, String> hdr = (HashMap<String, String>)((GeneralEventResponse)eventResponse).getCustomData("HDR");
//			String vndr_seq = hdr!=null&&hdr.containsKey("VNDR_SEQ")?JSPUtil.getNull((String)hdr.get("VNDR_SEQ")):"";
			
			TesEdiSoHdrVO tesEdiSoHdrVO = new TesEdiSoHdrVO();
			tesEdiSoHdrVO.setTmlEdiSoOfcCtyCd((String)JSPUtil.getNull(hdr.get("TML_EDI_SO_OFC_CTY_CD")) );
			tesEdiSoHdrVO.setTmlEdiSoSeq((String)JSPUtil.getNull(hdr.get("TML_EDI_SO_SEQ")) );
			
			IfEsdTes0200Event event = (IfEsdTes0200Event)e;
			event.setTesEdiSoHdrVO(tesEdiSoHdrVO);
			
			begin();
			inv_com_command.validateEDIInvoice( event );
			commit();
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		try {
			log.debug("\n\n bbb SC.mapEDIOriginInvoice \n");
			/**
			 * EDI에서 접수된 PDF invoice 원본 file을 조회하여 있을 경우 저장된 invoice와 관계를 부여
			 */
			HashMap<String, String> hdr = (HashMap<String, String>)((GeneralEventResponse)eventResponse).getCustomData("HDR");
			
			TesEdiSoHdrVO tesEdiSoHdrVO = new TesEdiSoHdrVO();
			tesEdiSoHdrVO.setTmlEdiSoOfcCtyCd((String)JSPUtil.getNull(hdr.get("TML_EDI_SO_OFC_CTY_CD")) );
			tesEdiSoHdrVO.setTmlEdiSoSeq((String)JSPUtil.getNull(hdr.get("TML_EDI_SO_SEQ")) );
			
			IfEsdTes0200Event event = (IfEsdTes0200Event)e;
			event.setTesEdiSoHdrVO(tesEdiSoHdrVO);
			
			
			begin();
			new TESCommonBCImpl().mapEDIOriginInvoice(event);
			commit();
			
			log.debug("\n\n eee SC.mapEDIOriginInvoice \n");
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage());
			throw new EventException(ex.getMessage());
		}
		
//		try {
//			/**
//			 * EDI 증빙용 원본 INVIOCE PDF FILE 펌. (EDI FTP -> ENIS WAS로)
//			 */
//			log.debug("\n\n RSC.getFTPPDFfile ~~~~~~~ ");
//			TESFTPCommonBC tescom = new TESFTPCommonBCImpl();
//			java.util.HashMap ftphm = new java.util.HashMap();
//			ftphm.put("VNDR_SEQ", ((IF_ESD_TES_200EventResponse)eventResponse).getHDR().get("VNDR_SEQ"));
//			ftphm.put("INV_NO", ((IF_ESD_TES_200EventResponse)eventResponse).getHDR().get("INV_NO"));
//			ftphm.put("TML_EDI_SO_OFC_CTY_CD", ((IF_ESD_TES_200EventResponse)eventResponse).getHDR().get("TML_EDI_SO_OFC_CTY_CD"));
//			ftphm.put("TML_EDI_SO_SEQ", ((IF_ESD_TES_200EventResponse)eventResponse).getHDR().get("TML_EDI_SO_SEQ"));
//			ftphm.put("FILE_TYPE", "PDF");
//			log.debug("\n\n @@@@ ftphm:"+ftphm+"\n\n");
//			begin();
//			tescom.getFTPfile(ftphm);
//			commit();
//		} catch (EventException de) {
//			rollback();
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		} catch (Exception de) {
//			rollback();
//			log.error("err " + de.toString(), de);
//			throw new EventException(de.getMessage());
//		}
		
		return eventResponse;
	}

	
	/**
	 * EDI test용
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse saveEDIPDFfile(Event e) throws EventException {
		EventResponse eventResponse = null;
		
		begin();
		eventResponse = new TESCommonBCImpl().saveEDIPDFfile(e);
		commit();

		return eventResponse;
	}
	
}
