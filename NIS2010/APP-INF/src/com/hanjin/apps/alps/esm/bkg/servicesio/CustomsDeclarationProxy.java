/* =========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BKGPlanningPerformanceJMSProxy.java
 *@FileTitle : Receive WebLogic JMS Queue Proxy
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-07-01
 *@LastModifier : kimseungmin
 *@LastVersion : 1.0
 * 2009-07-01 
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.servicesio;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.common.CountryCode;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.CustomsDeclarationSC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.ancs.event.EsmBkgUbizhjsAlpsbkgAnrackEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.event.UbizhjsAlpsBkgCancusAckEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsRcvLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.china.event.AlpsBkgTCncusAckEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.event.AlpsbkgSpainCRNReceiveEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.event.AlpsbkgUbizhjsEurcusAckEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.event.UbizhjsAlpsBkgNaccsReplyEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.event.EsmBkgUdevhjsAlpsbkgEntryEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.event.EsmBkgUdevhjsAlpsbkgKrcusEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.event.Ubiz2hjsAlpsbkgAmsAckEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.event.ESM0740001Event;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndCstmsVesselInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkgUbizhjsAlpsbkgNaccsEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkgAlpsbkgUdevhjsEvent;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.event.EsmBkgSlkcusAckEvent;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.irep.enisEsm.ESM0740001Document;
import com.hanjin.irep.enisEsm.ESM0740001Document.ESM0740001;
import com.hanjin.syscommon.common.table.BkgCstmsAdvRcvLogDtlVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvRcvLogVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvSndLogVO;
import com.jf.transfer.TransferEAI;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.basic.AlpsbkgUbizhjsEur24cusAckEvent;

/**
 * It's GEMPlanningPerformanceJMSProxy.java
 * 
 * @author Hyunsu, Ryu
 * @see
 * @since J2EE 1.6 May 25, 2009
 */
public class CustomsDeclarationProxy {

	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * JMS Receive(UDEVHJS_ALPSBKG_T_NACCS)<br>
	 * 
	 * @param eai TransferEAI
	 * @exception EventException, XmlException, Exception
	 */
	public void alpsbkgNaccsReceiveMQ(TransferEAI eai) throws DAOException {

		String str = eai.getMessage();

		
		Event event = null;
		CustomsDeclarationSC customsDeclarationSC = new CustomsDeclarationSC();		
		try {
			event = new EsmBkgUbizhjsAlpsbkgNaccsEvent();
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);
			
			((EsmBkgUbizhjsAlpsbkgNaccsEvent) event).setFlatFile(str);
			customsDeclarationSC.perform(event);
			
		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new DAOException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		eai.close();
	}
	/**
	 * JMS Receive(UDEVHJS_ALPSBKG_T_SLKCUS_ACK)<br>
	 * 스리랑카 세관
	 * @param eai TransferEAI
	 * @exception EventException, XmlException, Exception
	 */
	public void alpsbkgSlkCusReceiveMQ(TransferEAI eai) throws DAOException {

		
		String str = eai.getMessage();
		
		Event event = null;
		CustomsDeclarationSC customsDeclarationSC = new CustomsDeclarationSC();		
		try {
			event = new EsmBkgSlkcusAckEvent();
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);
			
			((EsmBkgSlkcusAckEvent) event).setFlatFile(str);
			customsDeclarationSC.perform(event);
			
		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new DAOException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		eai.close();
	}
	
	/**
	 * JMS Receive(UDEVHJS_ALPSBKG_T_ROCS_ACK)<br>
	 * @param eai TransferEAI
	 * @exception DAOException
	 */
	public void alpsbkgRocsReceiveMQ(TransferEAI eai) throws DAOException {
        
		String str = eai.getMessage();
		Event event = null;
		CustomsDeclarationSC customsDeclarationSC = new CustomsDeclarationSC();		
		try {
			event = new EsmBkgAlpsbkgUdevhjsEvent();
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);
			
			((EsmBkgAlpsbkgUdevhjsEvent) event).setFlatFile(str);
			customsDeclarationSC.perform(event);
			
		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new DAOException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		eai.close();
	}
	
	/**
	 * ANCS EDI 수신 MQProxy 메서드
	 * 
	 * @param eai
	 * @exception DAOException
	 */
	public void alpsbkgAncsReceiveMQ(TransferEAI eai) throws DAOException {
		log.info("<<<<<<<<<< alpsbkgAncsReceiveMQ Start >>>>>>>>>>>>>>>>");
		log.info("================================");
		log.info(eai.getMessage());
		log.info("================================");
		
		String str = eai.getMessage();
		
		Event event = null;
		CustomsDeclarationSC customsDeclarationSC = new CustomsDeclarationSC();		
		try {
			event = new EsmBkgUbizhjsAlpsbkgAnrackEvent();
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
			
			((EsmBkgUbizhjsAlpsbkgAnrackEvent) event).setFlatFile(str);
			customsDeclarationSC.perform(event) ;
			
		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new DAOException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		eai.close();
		log.info("<<<<<<<<<< alpsbkgAncsReceiveMQ END >>>>>>>>>>>>>>>>");
		
	}
	
	/**
	 * ANCS EDI 수신 MQProxy 메서드
	 * 
	 * @param eai
	 * @exception DAOException
	 */
	public void alpsbkgudevhjsAncsReceiveMQ(TransferEAI eai) throws DAOException {
		
		log.info("<<<<<<<<<< alpsbkgudevhjsAncsReceiveMQ Start >>>>>>>>>>>>>>>>");
		log.info("================================");
		log.info(eai.getMessage());
		log.info("================================");

		String str = eai.getMessage();
		
		Event event = null;
		CustomsDeclarationSC customsDeclarationSC = new CustomsDeclarationSC();		
		try {
			event = new EsmBkgUbizhjsAlpsbkgAnrackEvent();
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
			
			((EsmBkgUbizhjsAlpsbkgAnrackEvent) event).setFlatFile(str);
			customsDeclarationSC.perform(event) ;
			
		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new DAOException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		eai.close();
		log.info("<<<<<<<<<< alpsbkgudevhjsAncsReceiveMQ END >>>>>>>>>>>>>>>>");
		
	}
	
	/**
	 * JMS Receive(UBIZHJS_ALPSBKG_CANCUS_ACK) Canada A6, A6A, S10, E10 수신
	 * @param eai
	 * @exception DAOException
	 */
	public void ubizhjsAlpsBkgCancusAckReceiveMQ(TransferEAI eai) throws DAOException {
		
		BookingUtil utilCmd = new BookingUtil();
		
		log.info("<<<<<<<<<< ubizhjsAlpsBkgCancusAckReceiveMQ Start >>>>>>>>>>>>>>>>");
		log.info("================================");
		log.info(eai.getMessage());
		log.info("================================");
		try
		{
			String sUsrId = "CANCUS_ACK";
			// 수신 메시지
			String sDiv = "";
			if (eai.getMessage().indexOf("\r\n") != -1)
			{
				sDiv = "\r\n";
			}
			else
			{
				sDiv = "\n";
			}
			String[] arrRcvMsg = eai.getMessage().split(sDiv);
			BkgCstmsAdvRcvLogVO bkgCstmsAdvRcvLogVO = new BkgCstmsAdvRcvLogVO();
			bkgCstmsAdvRcvLogVO.setCntCd(CountryCode.CA);
			bkgCstmsAdvRcvLogVO.setIoBndCd("I");
			/**
			 * Proxy에서 DAO를 직접 호출할 수 있으면 여기서 사용하면 좋은데...<br>
			 * Proxy는 Action Class로 사용한다고 해서 event에 vo객체를 담는 용도로만 사용함.
			 * 첫라인 샘플 : CANCUSRCV82420100301002405
			 */
			bkgCstmsAdvRcvLogVO.setRcvDt(arrRcvMsg[0].substring(12));
			bkgCstmsAdvRcvLogVO.setRcvMsgTpId(arrRcvMsg[0].substring(9, 12));
			bkgCstmsAdvRcvLogVO.setCreUsrId(sUsrId);
			// 수신로그상세
			List<BkgCstmsAdvRcvLogDtlVO> bkgCstmsAdvRcvLogDtlVOs = new ArrayList<BkgCstmsAdvRcvLogDtlVO>();
			// 송신로그
			BkgCstmsAdvSndLogVO bkgCstmsAdvSndLogVO = new BkgCstmsAdvSndLogVO();
			for (int i = 0; i < arrRcvMsg.length; i++)
			{
				BkgCstmsAdvRcvLogDtlVO bkgCstmsAdvRcvLogDtlVO = new BkgCstmsAdvRcvLogDtlVO();
				bkgCstmsAdvRcvLogDtlVO.setCntCd(CountryCode.CA);
				bkgCstmsAdvRcvLogDtlVO.setIoBndCd("I");
				bkgCstmsAdvRcvLogDtlVO.setRcvDt(bkgCstmsAdvRcvLogVO.getRcvDt());
				bkgCstmsAdvRcvLogDtlVO.setRcvMsgDtlSeq("" + (i + 1));
				bkgCstmsAdvRcvLogDtlVO.setMsgDesc(arrRcvMsg[i]);
				bkgCstmsAdvRcvLogDtlVO.setCreUsrId(sUsrId);
				bkgCstmsAdvRcvLogDtlVOs.add(bkgCstmsAdvRcvLogDtlVO);
				
				//BAPLIE Response
				if (arrRcvMsg[i].startsWith("$$$MSGSTART"))
				{
					utilCmd.addBkgLog("BKG_BAPLIE", "CA_BAPLIE",bkgCstmsAdvRcvLogVO.getRcvDt());
					bkgCstmsAdvRcvLogVO.setRcvMsgTpId("BRC");
					break;
				}
				// 
				if (arrRcvMsg[i].startsWith("BKC"))
				{
					// 전송 시 BKG_CSTMS_ADV_SND_LOG의  CRR_BAT_NO
					bkgCstmsAdvRcvLogVO.setCrrBatNo(arrRcvMsg[i]);
				}
				// 컬럼[0]:값[1]
				String[] sValue = arrRcvMsg[i].split(":");
				if (arrRcvMsg[i].startsWith("CONTROL NO:"))
				{
					// BKG_CSTMS_ADV_BL의 CSTMS_ACK_KEY_NO
					bkgCstmsAdvRcvLogVO.setCstmsBatNo(sValue[1]);
				}
				if ("997".equals(bkgCstmsAdvRcvLogVO.getRcvMsgTpId()))
				{
					if (arrRcvMsg[i].startsWith("RESPONSE:"))
					{
						bkgCstmsAdvRcvLogVO.setCndAckRcvId(sValue[1].split("-")[0]);
					}
					if (arrRcvMsg[i].startsWith("GROUP RESPONSE:"))
					{
						bkgCstmsAdvSndLogVO.setAckRcvTpId(sValue[1]);
					}
					if (arrRcvMsg[i].startsWith("NO OF INCLUDED:"))
					{
						bkgCstmsAdvSndLogVO.setAckSndKnt(sValue[1]);
					}
					if (arrRcvMsg[i].startsWith("NO OF RECEIVED:"))
					{
						bkgCstmsAdvSndLogVO.setAckRcvKnt(sValue[1]);
					}
					if (arrRcvMsg[i].startsWith("NO OF ACCEPTED:"))
					{
						bkgCstmsAdvSndLogVO.setAckAcptKnt(sValue[1]);
					}
				}
				else if ("824".equals(bkgCstmsAdvRcvLogVO.getRcvMsgTpId()))
				{
					if (arrRcvMsg[i].startsWith("PURPOSE CODE:"))
					{
						bkgCstmsAdvRcvLogVO.setCndAckSubCd(sValue[1].split("-")[0]);
					}
					if (arrRcvMsg[i].startsWith("TECHNICAL ERROR:"))
					{
						bkgCstmsAdvRcvLogVO.setCstmsRjctMsg(sValue[1].split("-")[0]);
					}
					if (arrRcvMsg[i].startsWith("ERROR NOTES:"))
					{
						bkgCstmsAdvRcvLogVO.setCndAckErrNoteDesc(sValue[1]);
					}
				}
			}
			// 송신로그 업데이트를 위한 리스트 (원래는 단건인데 모델상으로 파라메터가 List이기 때문에 List로 넘김)
			List<BkgCstmsAdvSndLogVO> bkgCstmsAdvSndLogVOs = new ArrayList<BkgCstmsAdvSndLogVO>();
			if (bkgCstmsAdvRcvLogVO.getCrrBatNo() != null && !"".equals(bkgCstmsAdvRcvLogVO.getCrrBatNo()))
			{
				bkgCstmsAdvSndLogVO.setCntCd(CountryCode.CA);
				bkgCstmsAdvSndLogVO.setIoBndCd("I");
				bkgCstmsAdvSndLogVO.setCrrBatNo(bkgCstmsAdvRcvLogVO.getCrrBatNo());
				bkgCstmsAdvSndLogVOs.add(bkgCstmsAdvSndLogVO);
			}
			// 수신로그 등록을 위한 리스트 (원래는 단건인데 모델상으로 파라메터가 List이기 때문에 List로 넘김)
			List<BkgCstmsAdvRcvLogVO> bkgCstmsAdvRcvLogVOs = new ArrayList<BkgCstmsAdvRcvLogVO>();
			bkgCstmsAdvRcvLogVOs.add(bkgCstmsAdvRcvLogVO);
			// VO Object Set
			CndCstmsRcvLogVO cndCstmsRcvLogVO = new CndCstmsRcvLogVO();
			cndCstmsRcvLogVO.setBkgCstmsAdvRcvLogDtlVOs(bkgCstmsAdvRcvLogDtlVOs);
			cndCstmsRcvLogVO.setBkgCstmsAdvRcvLogVOs(bkgCstmsAdvRcvLogVOs);
			cndCstmsRcvLogVO.setBkgCstmsAdvSndLogVOs(bkgCstmsAdvSndLogVOs);
			
			//BAPLIE Response Set
			cndCstmsRcvLogVO.setRcvMsg(eai.getMessage()); 
			if ( "BRC".equals(bkgCstmsAdvRcvLogVO.getRcvMsgTpId())){
				cndCstmsRcvLogVO.setRcvMsgTpId(bkgCstmsAdvRcvLogVO.getRcvMsgTpId());
			} else {
				cndCstmsRcvLogVO.setRcvMsgTpId("");
			}
			
			// Event Object Set
			UbizhjsAlpsBkgCancusAckEvent event = new UbizhjsAlpsBkgCancusAckEvent();
			event.setCstmsRcvLogVO(cndCstmsRcvLogVO);
			// SC 호출
			CustomsDeclarationSC customsDeclarationSC = new CustomsDeclarationSC();
			customsDeclarationSC.perform(event);
		}
		catch (EventException ee)
		{
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new DAOException(new ErrorHandler(ee).getMessage());
		}
		catch (Exception e)
		{
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
		finally
		{
			eai.close();
			log.info("<<<<<<<<<< ubizhjsAlpsBkgCancusAckReceiveMQ End >>>>>>>>>>>>>>>>");
		}
	}

	/**
	 * 선박별 인증서 만료일 (Certificate Expire Date) 업로드
	 * 
	 * @param eai
	 * @exception DAOException
	 */
	public void loadVslCertiExpDt(TransferEAI eai) throws Exception {
		try
		{
			// XML SCHEMA
			ESM0740001Document doc = ESM0740001Document.Factory.parse(eai.getMessage());
			ESM0740001 eSM0740001 = doc.getESM0740001();
			ESM0740001.DataArea data = eSM0740001.getDataArea();
			ESM0740001.DataArea.CertInfoCollection col = data.getCertInfoCollection();
			// VO Object Set
			CndCstmsVesselInfoVO cndCstmsVesselInfoVO = new CndCstmsVesselInfoVO();
			cndCstmsVesselInfoVO.setCertCd(col.getCERTCD());
			cndCstmsVesselInfoVO.setVslCd(col.getVSLCD());
			cndCstmsVesselInfoVO.setUpdUsrId(col.getEMPID());
			cndCstmsVesselInfoVO.setExpiryDt(col.getEXPIRYDT());
			// Event Object Set
			ESM0740001Event event = new ESM0740001Event();
			event.setCndCstmsVesselInfoVO(cndCstmsVesselInfoVO);
			// SC 호출
			CustomsDeclarationSC customsDeclarationSC = new CustomsDeclarationSC();
			customsDeclarationSC.perform(event);
		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new DAOException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new DAOException(new ErrorHandler(e).getMessage());
		} finally {
			eai.close();
		}
	}
	
	/**
	 * JMS Receive(UDEVHJS_ALPSBKG_T_EURCUS_ACK)<br>
	 * EUR(CTA) 수신
	 * @param TransferEAI eai
	 * @exception EventException
	 * @exception Exception
	 */
	public void udevhjsAlpsBkgTEurcusAckReceiveMQ(TransferEAI eai) throws Exception{

		log.info("<<<<<<<<<< udevhjsAlpsBkgTEurcusAckReceiveMQ Start >>>>>>>>>>>>>>>>");		
		
		String str = eai.getMessage();
		log.info("======================================");
		log.info("xml : " + str);
		log.info("======================================");
		
		Event event = null;
		
		CustomsDeclarationSC customsDeclarationSC = new CustomsDeclarationSC();		
		try {
			event = new AlpsbkgUbizhjsEurcusAckEvent();
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
			
			((AlpsbkgUbizhjsEurcusAckEvent) event).setFlatFile(str);
			customsDeclarationSC.perform(event);
			
			
		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new DAOException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new DAOException(new ErrorHandler(e).getMessage());
		} finally {
			eai.close();
		}
		log.info("<<<<<<<<<< udevhjsAlpsBkgTEurcusAckReceiveMQ End >>>>>>>>>>>>>>>>");
	}
	
	/**
	 * 한국세관 배정정보 수신 처리
	 * @param TransferEAI eai
	 * @exception EventException
	 */
	public void udevhjsAlpsbkgEntryReceiveMQ(TransferEAI eai) throws EventException {

		log.info("<<<<<<<<<< udevhjsAlpsbkgEntryReceiveJMS Start >>>>>>>>>>>>>>>>");		
		
		String str = eai.getMessage();
		log.info("======================================");
		log.info("xml : " + str);
		log.info("======================================");
		
		Event event = null;
		CustomsDeclarationSC customsDeclarationSC = new CustomsDeclarationSC();		
		try {
			event = new EsmBkgUdevhjsAlpsbkgEntryEvent();
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);
			
			((EsmBkgUdevhjsAlpsbkgEntryEvent) event).setFlatFile(str);
			customsDeclarationSC.perform((EsmBkgUdevhjsAlpsbkgEntryEvent)event);
			
			log.info("<<<<<<<<<< udevhjsAlpsbkgEntryReceiveJMS End >>>>>>>>>>>>>>>>");
			
		} catch (EventException ee) {
			log.error("EventException ee : " + ee.toString(), ee);
			eai.rollback(ee);
			throw ee;
		} catch (Exception e){
			log.error("Exception e : " + e.toString());
			eai.rollback(e);
			throw new EventException(new ErrorHandler(e).getMessage(), e);
		}finally {
			eai.close();
		}
	}	
	
	/**
	 * 한국세관 ACK 수신 
	 * @param TransferEAI eai
	 * @exception EventException
	 */
	public void udevhjsAlpsbkgKrcusReceiveMQ(TransferEAI eai) throws EventException {
		log.info("<<<<<<<<<< udevhjsAlpsbkgKrcusReceiveJMS Start >>>>>>>>>>>>>>>>");		
		
		String str = eai.getMessage();
		log.info("======================================");
		log.info("xml : " + str);
		log.info("======================================");
		
		Event event = null;
		CustomsDeclarationSC customsDeclarationSC = new CustomsDeclarationSC();		
		try {
			event = new EsmBkgUdevhjsAlpsbkgKrcusEvent();
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);
			
			((EsmBkgUdevhjsAlpsbkgKrcusEvent) event).setFlatFile(str);
			customsDeclarationSC.perform((EsmBkgUdevhjsAlpsbkgKrcusEvent)event);
			
			log.info("<<<<<<<<<< udevhjsAlpsbkgKrcusReceiveJMS End >>>>>>>>>>>>>>>>");
			
		} catch (EventException ee) {
			log.error("EventException ee : " + ee.toString(), ee);
			eai.rollback(ee);
			throw ee;
		} catch (Exception e){
			log.error("Exception e : " + e.toString());
			eai.rollback(e);
			throw new EventException(new ErrorHandler(e).getMessage(), e);
		}finally {
			eai.close();
		}
	}
	
	/**
	 * BKG/DOC 일본 세관 응답 메시지 수신 (System Ack from TYO Com Server)
	 * @param TransferEAI eai
	 * @author Son Yun Seuk
	 * @exception Exception
	 */
	public void alpsbkgNaccsReplyMQ(TransferEAI eai) throws Exception{
		
		String rcvMsg = eai.getMessage();
		
		CustomsDeclarationSC customsDeclarationSC = new CustomsDeclarationSC();
		
		try
		{
			UbizhjsAlpsBkgNaccsReplyEvent event = new UbizhjsAlpsBkgNaccsReplyEvent();
			event.setRcvMsg(rcvMsg);
			// SC 호출
			customsDeclarationSC.perform(event);
			
		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new DAOException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new DAOException(new ErrorHandler(e).getMessage());
		} finally {
			eai.close();
		}
	}
	
	/**
	 * JMS Receive(UDEVHJS_ALPSBKG_T_CNCUS_ACK)<br>
	 * CHINA 수신<br>
	 * @param TransferEAI eai 
	 * @exception EventException
	 */
	public void alpsBkgTCncusAckReplyMQ(TransferEAI eai) throws EventException {

		log.info("<<<<<<<<<< China Reply alpsBkgTCncusAckReplyMQ Start >>>>>>>>>>>>>>>>");		
		
		String str = eai.getMessage();
		log.info("======================================");
		log.info("xml : " + str);
		log.info("======================================");
		
		CustomsDeclarationSC customsDeclarationSC = new CustomsDeclarationSC();		
		try {
			AlpsBkgTCncusAckEvent event = new AlpsBkgTCncusAckEvent();
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			
			event.setFormCommand(f);			
			//event.setFlatFile(eai.getMessage());
			event.setFlatFile(str);
			customsDeclarationSC.perform(event);
			
		} catch (EventException ee) {
			log.error("EventException ee : " + ee.toString(), ee);
			eai.rollback(ee);
			throw ee;
		} catch (Exception e){
			log.error("Exception e : " + e.toString());
			eai.rollback(e);
			throw new EventException(new ErrorHandler(e).getMessage(), e);
		} finally {
			eai.close();
		}
		
		log.info("<<<<<<<<<< China Reply alpsBkgTCncusAckReplyMQ End >>>>>>>>>>>>>>>>");	
	}
	
	/**
	 * JMS Receive(UBIZ2HJS_ALPSBKG_AMS_ACK)<br>
	 * 미세관 응답 메세지 수신
	 * @param eai TransferEAI
	 * @exception EventException, XmlException, Exception
	 */
	public void ubiz2hjsAlpsbkgAmsAckReplyMQ(TransferEAI eai) throws DAOException {

		log.info("<<<<<<<<<< US Reply ubiz2hjsAlpsbkgAmsAckReplyMQ Start >>>>>>>>>>>>>>>>");		
		
		String str = eai.getMessage();
		log.info("======================================");
		log.info("xml : " + str);
		log.info("======================================");
		
		Event event = null;
		CustomsDeclarationSC customsDeclarationSC = new CustomsDeclarationSC();		
		try {
			event = new Ubiz2hjsAlpsbkgAmsAckEvent();
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
			
			((Ubiz2hjsAlpsbkgAmsAckEvent) event).setFlatFile(str);
			customsDeclarationSC.perform(event);
			
			log.info("<<<<<<<<<< US Reply ubiz2hjsAlpsbkgAmsAckReplyMQ End >>>>>>>>>>>>>>>>");
			
		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new DAOException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new DAOException(new ErrorHandler(e).getMessage());
		} finally {
			eai.close();
		}
	}
	
	
	/**
	 * JMS Receive(UBIZHJS_ALPSBKG_EUR24_ACK)<br>
	 * EUR24(CTA) 수신
	 * @param TransferEAI eai
	 * @exception EventException
	 * @exception Exception
	 */
	public void alpsBkgEur24ReplyMQ(TransferEAI eai) throws Exception{

		log.info("<<<<<<<<<< alpsBkgEur24ReplyMQ Start >>>>>>>>>>>>>>>>");		
		
		String str = eai.getMessage();
		log.info("======================================");
		log.info("xml : " + str);
		log.info("======================================");
		
		AlpsbkgUbizhjsEur24cusAckEvent event = null;
		
		CustomsDeclarationSC customsDeclarationSC = new CustomsDeclarationSC();		
		try {
			event = new AlpsbkgUbizhjsEur24cusAckEvent();
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI02);
			event.setFormCommand(f);
			
			event.setFlatFile(str);
			customsDeclarationSC.perform(event);
			
			
		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new DAOException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new DAOException(new ErrorHandler(e).getMessage());
		} finally {
			eai.close();
		}
		log.info("<<<<<<<<<< alpsBkgEur24ReplyMQ End >>>>>>>>>>>>>>>>");
	}

	/**
	 * JMS Receive(UDEVHJS_ALPSBKG_T_MEDCUSRPL)<br>
	 * Customs Reference# I/F from Local System to ALPS (스페인, 포르투갈)
	 * @param TransferEAI eai
	 * @exception EventException
	 * @exception Exception
	 */
	public void alpsbkgSpainCRNReceiveMQ(TransferEAI eai) throws Exception{

		log.info("<<<<<<<<<< alpsbkgSpainCRNReceiveMQ Start >>>>>>>>>>>>>>>>");		
		
		String str = eai.getMessage();
		log.info("======================================");
		log.info("xml : " + str);
		log.info("======================================");
		
		AlpsbkgSpainCRNReceiveEvent event = null;
		
		CustomsDeclarationSC customsDeclarationSC = new CustomsDeclarationSC();		
		try {
			event = new AlpsbkgSpainCRNReceiveEvent();
			
			event.setFlatFile(str);
			customsDeclarationSC.perform(event);
			
		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new DAOException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new DAOException(new ErrorHandler(e).getMessage());
		} finally {
			eai.close();
		}
		log.info("<<<<<<<<<< alpsbkgSpainCRNReceiveMQ End >>>>>>>>>>>>>>>>");
	}
	
	/**
	 * JMS Receive(UBIZHJS_ALPSBKG_KRCUS_ACK)<br>
	 * 한국세관 응답 메세지 수신
	 * @param eai TransferEAI
	 * @exception EventException, XmlException, Exception
	 */
	public void ubizhjsAlpsbkgKrcusAckMQ(TransferEAI eai) throws DAOException {

		log.info("<<<<<<<<<< Korea Reply ubizhjsAlpsbkgKrcusAckMQ Start >>>>>>>>>>>>>>>>");		
		
		String str = eai.getMessage();
		log.info("==============================	========");
		log.info("xml : " + str);
		log.info("======================================");
		
		Event event = null;
		CustomsDeclarationSC customsDeclarationSC = new CustomsDeclarationSC();		
		try {
			event = new Ubiz2hjsAlpsbkgAmsAckEvent();
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);
			
			((Ubiz2hjsAlpsbkgAmsAckEvent) event).setFlatFile(str);
			customsDeclarationSC.perform(event);
			
			log.info("<<<<<<<<<< Korea Reply ubizhjsAlpsbkgKrcusAckMQ End >>>>>>>>>>>>>>>>");
			
		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new DAOException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new DAOException(new ErrorHandler(e).getMessage());
		} finally {
			eai.close();
		}
	}
}