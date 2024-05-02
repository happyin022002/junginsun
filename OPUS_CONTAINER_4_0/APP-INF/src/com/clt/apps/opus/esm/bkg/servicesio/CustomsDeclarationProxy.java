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
package com.clt.apps.opus.esm.bkg.servicesio;

import org.apache.log4j.Logger;

import com.clt.apps.opus.esm.bkg.customsdeclaration.CustomsDeclarationAncsSC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.CustomsDeclarationCanadaSC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.CustomsDeclarationChinaSC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.CustomsDeclarationEur24SC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.CustomsDeclarationEurSC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.CustomsDeclarationJapanSC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.CustomsDeclarationKoreaSC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.CustomsDeclarationNewZealandSC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.CustomsDeclarationPanamaSC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.CustomsDeclarationRocsSC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.CustomsDeclarationSrilankaSC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.CustomsDeclarationUsaSC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.event.EsmBkgUbizcomOpusbkgAnrackEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.event.OpusbkgEdiErrCaReceiveEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.event.UbizcomOpusBkgCancusAckEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsRcvLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.event.EdiBkgChinaSysAckEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.event.OpusBkgTCncusAckEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.event.OpusbkgSpainCRNReceiveEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.event.OpusbkgUbizcomEurcusAckEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.basic.OpusbkgUbizcomEur24cusAckEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.event.OpusbkgEdiErrEur24ReceiveEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japan.event.UbizComOpusBkgNaccsReplyEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.event.EsmBkgUdevComOpusBkgEntryEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.korea.event.EsmBkgUdevComOpusBkgKrcusEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.event.OpusBkgNzcusAckEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.event.OpusbkgPanamaReceiveEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.event.OpusbkgEdiErrUsReceiveEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.event.Ubiz2comOpusbkgAmsAckEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.japan.event.EsmBkgUbizComOpusBkgNaccsEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkgOpusbkgUdevcomEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.event.EsmBkgSlkcusAckEvent;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;

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
	 * JMS Receive(UDEVCOM_OPUSBKG_T_NACCS)<br>
	 *
	 * @param eai TransferEAI
	 * @exception EventException, XmlException, Exception
	 */
	public void opusbkgNaccsReceiveMQ(TransferEAI eai) throws EventException {

		String str = eai.getMessage();


		Event event = null;
		CustomsDeclarationJapanSC customsDeclarationJapanSC = new CustomsDeclarationJapanSC();
		try {
			event = new EsmBkgUbizComOpusBkgNaccsEvent();

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);

			((EsmBkgUbizComOpusBkgNaccsEvent) event).setFlatFile(str);
			customsDeclarationJapanSC.perform(event);

		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new EventException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new EventException(new ErrorHandler(e).getMessage());
		}
		eai.close();
	}

	/**
	 * JMS Receive(UDEVCOM_OPUSBKG_T_SLKCUS_ACK)<br>
	 * 스리랑카 세관
	 * @param eai TransferEAI
	 * @exception EventException, XmlException, Exception
	 */
	public void opusbkgSlkCusReceiveMQ(TransferEAI eai) throws EventException {


		String str = eai.getMessage();

		Event event = null;
		CustomsDeclarationSrilankaSC customsDeclarationSrilankaSC = new CustomsDeclarationSrilankaSC();
		try {
			event = new EsmBkgSlkcusAckEvent();

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);

			((EsmBkgSlkcusAckEvent) event).setFlatFile(str);
			customsDeclarationSrilankaSC.perform(event);

		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new EventException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new EventException(new ErrorHandler(e).getMessage());
		}
		eai.close();
	}

	/**
	 * JMS Receive(UDEVCOM_OPUSBKG_T_ROCS_ACK)<br>
	 * @param eai TransferEAI
	 * @exception EventException
	 */
	public void opusbkgRocsReceiveMQ(TransferEAI eai) throws EventException {

		String str = eai.getMessage();
		Event event = null;
		CustomsDeclarationRocsSC customsDeclarationRocsSC = new CustomsDeclarationRocsSC();
		try {
			event = new EsmBkgOpusbkgUdevcomEvent();

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);

			((EsmBkgOpusbkgUdevcomEvent) event).setFlatFile(str);
			customsDeclarationRocsSC.perform(event);

		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new EventException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new EventException(new ErrorHandler(e).getMessage());
		}
		eai.close();
	}

	/**
	 * ANCS EDI 수신 MQProxy 메서드
	 *
	 * @param eai
	 * @exception EventException
	 */
	public void opusbkgAncsReceiveMQ(TransferEAI eai) throws EventException {
		log.info("<<<<<<<<<< alpsbkgAncsReceiveMQ Start >>>>>>>>>>>>>>>>");
		log.info("================================");
		log.info(eai.getMessage());
		log.info("================================");

		String str = eai.getMessage();

		Event event = null;
		CustomsDeclarationAncsSC customsDeclarationAncsSC = new CustomsDeclarationAncsSC();
		try {
			event = new EsmBkgUbizcomOpusbkgAnrackEvent();

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);

			((EsmBkgUbizcomOpusbkgAnrackEvent) event).setFlatFile(str);
			customsDeclarationAncsSC.perform(event) ;

		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new EventException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new EventException(new ErrorHandler(e).getMessage());
		}
		eai.close();
		log.info("<<<<<<<<<< alpsbkgAncsReceiveMQ END >>>>>>>>>>>>>>>>");
	}

	/**
	 * ANCS EDI 수신 MQProxy 메서드
	 *
	 * @param eai
	 * @exception EventException
	 */
	public void opusbkgudevcomAncsReceiveMQ(TransferEAI eai) throws EventException {

		log.info("<<<<<<<<<< alpsbkgudevhjsAncsReceiveMQ Start >>>>>>>>>>>>>>>>");
		log.info("================================");
		log.info(eai.getMessage());
		log.info("================================");

		String str = eai.getMessage();

		Event event = null;
		CustomsDeclarationAncsSC customsDeclarationAncsSC = new CustomsDeclarationAncsSC();
		try {
			event = new EsmBkgUbizcomOpusbkgAnrackEvent();

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);

			((EsmBkgUbizcomOpusbkgAnrackEvent) event).setFlatFile(str);
			customsDeclarationAncsSC.perform(event);

		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new EventException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new EventException(new ErrorHandler(e).getMessage());
		}
		eai.close();
		log.info("<<<<<<<<<< alpsbkgudevhjsAncsReceiveMQ END >>>>>>>>>>>>>>>>");
	}

	/**
	 * Canada A6, A6A, S10, E10 수신
	 *
	 * @param eai
	 * @exception EventException
	 */
	public void ubizcomOpusBkgCancusAckReceiveMQ(TransferEAI eai) throws EventException {
		log.info("<<<<<<<<<< ubizhjsAlpsBkgCancusAckReceiveMQ Start >>>>>>>>>>>>>>>>");
		log.info("================================");
		log.info(eai.getMessage());
		log.info("================================");
		try
		{
			UbizcomOpusBkgCancusAckEvent event = new UbizcomOpusBkgCancusAckEvent();

			CndCstmsRcvLogVO cndCstmsRcvLogVO = new CndCstmsRcvLogVO();
			cndCstmsRcvLogVO.setFlatFile(eai.getMessage());
			event.setCstmsRcvLogVO(cndCstmsRcvLogVO);

			// SC 호출
			CustomsDeclarationCanadaSC customsDeclarationCanadaSC = new CustomsDeclarationCanadaSC();
			customsDeclarationCanadaSC.perform(event);
//
//			String sUsrId = "CANCUS_ACK";
//			// 수신 메시지
//			String sDiv = "";
//			if (eai.getMessage().indexOf("\r\n") != -1)
//			{
//				sDiv = "\r\n";
//			}
//			else
//			{
//				sDiv = "\n";
//			}
//			String[] arrRcvMsg = eai.getMessage().split(sDiv);
//			BkgCstmsAdvRcvLogVO bkgCstmsAdvRcvLogVO = new BkgCstmsAdvRcvLogVO();
//			bkgCstmsAdvRcvLogVO.setCntCd(CountryCode.CA);
//			bkgCstmsAdvRcvLogVO.setIoBndCd("I");
//
//			// 수신로그상세
//			List<BkgCstmsAdvRcvLogDtlVO> bkgCstmsAdvRcvLogDtlVOs = new ArrayList<BkgCstmsAdvRcvLogDtlVO>();
//			// 송신로그
//			BkgCstmsAdvSndLogVO bkgCstmsAdvSndLogVO = new BkgCstmsAdvSndLogVO();
//			for (int i = 0; i < arrRcvMsg.length; i++)
//			{
//				//
//				if (arrRcvMsg[i].startsWith("CANCUSRCV"))
//				{
//					/**
//					 * 첫라인 샘플 : CANCUSRCV82420100301002405
//					 */
//					bkgCstmsAdvRcvLogVO.setRcvDt(arrRcvMsg[i].substring(12));
//					bkgCstmsAdvRcvLogVO.setRcvMsgTpId(arrRcvMsg[i].substring(9, 12));
//					bkgCstmsAdvRcvLogVO.setCreUsrId(sUsrId);
//				}
//				BkgCstmsAdvRcvLogDtlVO bkgCstmsAdvRcvLogDtlVO = new BkgCstmsAdvRcvLogDtlVO();
//				bkgCstmsAdvRcvLogDtlVO.setCntCd(CountryCode.CA);
//				bkgCstmsAdvRcvLogDtlVO.setIoBndCd("I");
//				bkgCstmsAdvRcvLogDtlVO.setRcvDt(bkgCstmsAdvRcvLogVO.getRcvDt());
//				bkgCstmsAdvRcvLogDtlVO.setRcvMsgDtlSeq("" + (i + 1));
//				bkgCstmsAdvRcvLogDtlVO.setMsgDesc(arrRcvMsg[i]);
//				bkgCstmsAdvRcvLogDtlVO.setCreUsrId(sUsrId);
//				bkgCstmsAdvRcvLogDtlVOs.add(bkgCstmsAdvRcvLogDtlVO);
//
//				if (arrRcvMsg[i].startsWith(ReferenceNumberGeneratorBroker.getChangedModule("BKC")))
//				{
//					// 전송 시 BKG_CSTMS_ADV_SND_LOG의  CRR_BAT_NO
//					bkgCstmsAdvRcvLogVO.setCrrBatNo(arrRcvMsg[i]);
//				}
//				// 컬럼[0]:값[1]
//				String[] sValue = arrRcvMsg[i].split(":");
//				if (arrRcvMsg[i].startsWith("CONTROL NO:"))
//				{
//					// BKG_CSTMS_ADV_BL의 CSTMS_ACK_KEY_NO
//					bkgCstmsAdvRcvLogVO.setCstmsBatNo(sValue[1]);
//				}
//				if ("997".equals(bkgCstmsAdvRcvLogVO.getRcvMsgTpId()))
//				{
//					if (arrRcvMsg[i].startsWith("RESPONSE:"))
//					{
//						bkgCstmsAdvRcvLogVO.setCndAckRcvId(sValue[1].split("-")[0]);
//					}
//					if (arrRcvMsg[i].startsWith("GROUP RESPONSE:"))
//					{
//						bkgCstmsAdvSndLogVO.setAckRcvTpId(sValue[1]);
//					}
//					if (arrRcvMsg[i].startsWith("NO OF INCLUDED:"))
//					{
//						bkgCstmsAdvSndLogVO.setAckSndKnt(sValue[1]);
//					}
//					if (arrRcvMsg[i].startsWith("NO OF RECEIVED:"))
//					{
//						bkgCstmsAdvSndLogVO.setAckRcvKnt(sValue[1]);
//					}
//					if (arrRcvMsg[i].startsWith("NO OF ACCEPTED:"))
//					{
//						bkgCstmsAdvSndLogVO.setAckAcptKnt(sValue[1]);
//					}
//				}
//				else if ("824".equals(bkgCstmsAdvRcvLogVO.getRcvMsgTpId()))
//				{
//					if (arrRcvMsg[i].startsWith("PURPOSE CODE:"))
//					{
//						bkgCstmsAdvRcvLogVO.setCndAckSubCd(sValue[1].split("-")[0]);
//					}
//					if (arrRcvMsg[i].startsWith("TECHNICAL ERROR:"))
//					{
//						bkgCstmsAdvRcvLogVO.setCstmsRjctMsg(sValue[1].split("-")[0]);
//					}
//					if (arrRcvMsg[i].startsWith("ERROR NOTES:"))
//					{
//						bkgCstmsAdvRcvLogVO.setCndAckErrNoteDesc(sValue[1]);
//					}
//				}
//			}
//
//			/*****************************************************************************************
//			 * 기존 수신로직에는 첫줄에 receive date가 있어<br>
//			 * BKG_CSTMS_ADV_RCV_LOG 테이블의 RCV_DT를 설정하고 DTL 테이블에서 사용했는데<br>
//			 * NYK는 첫 라인이 헤더 정보가 들어와 RCV_DT가 나중에 설정되기 때문에 처음 설정안된 부분을 다시 설정함
//			 *****************************************************************************************/
//			for (int i = 0; i<bkgCstmsAdvRcvLogDtlVOs.size(); i++)
//			{
//				if (bkgCstmsAdvRcvLogDtlVOs.get(i).getRcvDt() == null)
//					bkgCstmsAdvRcvLogDtlVOs.get(i).setRcvDt(bkgCstmsAdvRcvLogVO.getRcvDt());
//			}
//			// 송신로그 업데이트를 위한 리스트 (원래는 단건인데 모델상으로 파라메터가 List이기 때문에 List로 넘김)
//			List<BkgCstmsAdvSndLogVO> bkgCstmsAdvSndLogVOs = new ArrayList<BkgCstmsAdvSndLogVO>();
//			if (bkgCstmsAdvRcvLogVO.getCrrBatNo() != null && !"".equals(bkgCstmsAdvRcvLogVO.getCrrBatNo()))
//			{
//				bkgCstmsAdvSndLogVO.setCntCd(CountryCode.CA);
//				bkgCstmsAdvSndLogVO.setIoBndCd("I");
//				bkgCstmsAdvSndLogVO.setCrrBatNo(bkgCstmsAdvRcvLogVO.getCrrBatNo());
//				bkgCstmsAdvSndLogVO.setAckRcvDt(bkgCstmsAdvRcvLogVO.getRcvDt());
//				bkgCstmsAdvSndLogVOs.add(bkgCstmsAdvSndLogVO);
//			}
//			// 수신로그 등록을 위한 리스트 (원래는 단건인데 모델상으로 파라메터가 List이기 때문에 List로 넘김)
//			List<BkgCstmsAdvRcvLogVO> bkgCstmsAdvRcvLogVOs = new ArrayList<BkgCstmsAdvRcvLogVO>();
//			bkgCstmsAdvRcvLogVOs.add(bkgCstmsAdvRcvLogVO);
//			// VO Object Set
//			CndCstmsRcvLogVO cndCstmsRcvLogVO = new CndCstmsRcvLogVO();
//			cndCstmsRcvLogVO.setBkgCstmsAdvRcvLogDtlVOs(bkgCstmsAdvRcvLogDtlVOs);
//			cndCstmsRcvLogVO.setBkgCstmsAdvRcvLogVOs(bkgCstmsAdvRcvLogVOs);
//			cndCstmsRcvLogVO.setBkgCstmsAdvSndLogVOs(bkgCstmsAdvSndLogVOs);
//			// Event Object Set
//			UbizcomOpusBkgCancusAckEvent event = new UbizcomOpusBkgCancusAckEvent();
//			event.setCstmsRcvLogVO(cndCstmsRcvLogVO);
//			// SC 호출
//			CustomsDeclarationCanadaSC customsDeclarationCanadaSC = new CustomsDeclarationCanadaSC();
//			customsDeclarationCanadaSC.perform(event);
		}
		catch (EventException ee)
		{
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new EventException(new ErrorHandler(ee).getMessage());
		}
		catch (Exception e)
		{
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new EventException(new ErrorHandler(e).getMessage());
		}
		finally
		{
			eai.close();
			log.info("<<<<<<<<<< ubizhjsAlpsBkgCancusAckReceiveMQ End >>>>>>>>>>>>>>>>");
		}
	}

	/**
	 * JMS Receive(UDEVCOM_OPUSBKG_T_EURCUS_ACK)<br>
	 * EUR(CTA) 수신
	 * @param TransferEAI eai
	 * @exception EventException
	 * @exception Exception
	 */
	public void udevcomOpusBkgTEurcusAckReceiveMQ(TransferEAI eai) throws Exception{

		log.info("<<<<<<<<<< udevhjsAlpsBkgTEurcusAckReceiveMQ Start >>>>>>>>>>>>>>>>");

		String str = eai.getMessage();
		log.info("======================================");
		log.info("xml : " + str);
		log.info("======================================");

		Event event = null;

		CustomsDeclarationEurSC customsDeclarationEurSC = new CustomsDeclarationEurSC();
		try {
			event = new OpusbkgUbizcomEurcusAckEvent();

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);

			((OpusbkgUbizcomEurcusAckEvent) event).setFlatFile(str);
			customsDeclarationEurSC.perform(event);


		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new EventException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new EventException(new ErrorHandler(e).getMessage());
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
	public void udevcomOpusbkgEntryReceiveMQ(TransferEAI eai) throws EventException {

		log.info("<<<<<<<<<< udevcomOpusbkgEntryReceiveJMS Start >>>>>>>>>>>>>>>>");

		String str = eai.getMessage();
		log.info("======================================");
		log.info("xml : " + str);
		log.info("======================================");

		Event event = null;
		CustomsDeclarationKoreaSC customsDeclarationKoreaSC = new CustomsDeclarationKoreaSC();
		try {
			event = new EsmBkgUdevComOpusBkgEntryEvent();

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);

			((EsmBkgUdevComOpusBkgEntryEvent) event).setFlatFile(str);
			customsDeclarationKoreaSC.perform((EsmBkgUdevComOpusBkgEntryEvent)event);

			log.info("<<<<<<<<<< udevcomOpusbkgEntryReceiveJMS End >>>>>>>>>>>>>>>>");

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
	public void udevcomOpusbkgKrcusReceiveMQ(TransferEAI eai) throws EventException {
		log.info("<<<<<<<<<< udevcomOpusbkgKrcusReceiveJMS Start >>>>>>>>>>>>>>>>");

		String str = eai.getMessage();
		log.info("======================================");
		log.info("xml : " + str);
		log.info("======================================");

		Event event = null;
		CustomsDeclarationKoreaSC customsDeclarationKoreaSC = new CustomsDeclarationKoreaSC();
		try {
			event = new EsmBkgUdevComOpusBkgKrcusEvent();

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);

			((EsmBkgUdevComOpusBkgKrcusEvent) event).setFlatFile(str);
			customsDeclarationKoreaSC.perform((EsmBkgUdevComOpusBkgKrcusEvent)event);

			log.info("<<<<<<<<<< udevcomOpusbkgKrcusReceiveJMS End >>>>>>>>>>>>>>>>");

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
	public void opusbkgNaccsReplyMQ(TransferEAI eai) throws Exception{

		String rcvMsg = eai.getMessage();

		CustomsDeclarationJapanSC customsDeclarationJapanSC = new CustomsDeclarationJapanSC();

		try
		{
			UbizComOpusBkgNaccsReplyEvent event = new UbizComOpusBkgNaccsReplyEvent();
			event.setRcvMsg(rcvMsg);
			// SC 호출
			customsDeclarationJapanSC.perform(event);

		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new EventException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new EventException(new ErrorHandler(e).getMessage());
		} finally {
			eai.close();
		}
	}

	/**
	 * JMS Receive(UDEVCOM_OPUSBKG_T_CNCUS_ACK)<br>
	 * CHINA 수신<br>
	 * @param TransferEAI eai
	 * @exception EventException
	 */
	public void opusBkgTCncusAckReplyMQ(TransferEAI eai) throws EventException {

		log.info("<<<<<<<<<< China Reply opusBkgTCncusAckReplyMQ Start >>>>>>>>>>>>>>>>");

		String str = eai.getMessage();
		log.info("======================================");
		log.info("xml : " + str);
		log.info("======================================");

		CustomsDeclarationChinaSC customsDeclarationChinaSC = new CustomsDeclarationChinaSC();
		try {
			OpusBkgTCncusAckEvent event = new OpusBkgTCncusAckEvent();

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);

			event.setFormCommand(f);
			//event.setFlatFile(eai.getMessage());
			event.setFlatFile(str);
			customsDeclarationChinaSC.perform(event);

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

		log.info("<<<<<<<<<< China Reply opusBkgTCncusAckReplyMQ End >>>>>>>>>>>>>>>>");
	}

	/**
	 * JMS Receive(UBIZ2COM_OPUSBKG_AMS_ACK)<br>
	 * 미세관 응답 메세지 수신
	 * @param eai TransferEAI
	 * @exception EventException, XmlException, Exception
	 */
	public void ubiz2comOpusbkgAmsAckReplyMQ(TransferEAI eai) throws EventException {

		log.info("<<<<<<<<<< US Reply ubiz2hjsAlpsbkgAmsAckReplyMQ Start >>>>>>>>>>>>>>>>");

		String str = eai.getMessage();
		log.info("======================================");
		log.info("xml : " + str);
		log.info("======================================");

		Event event = null;
		CustomsDeclarationUsaSC customsDeclarationUsaSC = new CustomsDeclarationUsaSC();
		try {
			event = new Ubiz2comOpusbkgAmsAckEvent();

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);

			((Ubiz2comOpusbkgAmsAckEvent) event).setFlatFile(str);
			customsDeclarationUsaSC.perform(event);

			log.info("<<<<<<<<<< US Reply ubiz2hjsAlpsbkgAmsAckReplyMQ End >>>>>>>>>>>>>>>>");

		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new EventException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new EventException(new ErrorHandler(e).getMessage());
		} finally {
			eai.close();
		}
	}

	/**
	 * JMS Receive(UBIZCOM_OPUSBKG_EUR24_ACK)<br>
	 * EUR24(CTA) 수신
	 * @param TransferEAI eai
	 * @exception EventException
	 * @exception Exception
	 */
	public void opusBkgEur24ReplyMQ(TransferEAI eai) throws Exception{

		log.info("<<<<<<<<<< opusBkgEur24ReplyMQ Start >>>>>>>>>>>>>>>>");

		String str = eai.getMessage();
		log.info("======================================");
		log.info("xml : " + str);
		log.info("======================================");

		OpusbkgUbizcomEur24cusAckEvent event = null;

		CustomsDeclarationEur24SC customsDeclarationEur24SC = new CustomsDeclarationEur24SC();
		try {
			event = new OpusbkgUbizcomEur24cusAckEvent();

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI02);
			event.setFormCommand(f);

			event.setFlatFile(str);
			customsDeclarationEur24SC.perform(event);


		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new EventException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new EventException(new ErrorHandler(e).getMessage());
		} finally {
			eai.close();
		}
		log.info("<<<<<<<<<< opusBkgEur24ReplyMQ End >>>>>>>>>>>>>>>>");
	}

	/**
	 * JMS Receive(UDEVHJS_ALPSBKG_T_MEDCUSRPL)<br>
	 * Customs Reference# I/F from Local System to ALPS (스페인, 포르투갈)
	 * @param TransferEAI eai
	 * @exception EventException
	 * @exception Exception
	 */
	public void opusbkgSpainCRNReceiveMQ(TransferEAI eai) throws Exception{

		log.info("<<<<<<<<<< alpsbkgSpainCRNReceiveMQ Start >>>>>>>>>>>>>>>>");

		String str = eai.getMessage();
		log.info("======================================");
		log.info("xml : " + str);
		log.info("======================================");

		OpusbkgSpainCRNReceiveEvent event = null;

		CustomsDeclarationEurSC customsDeclarationEurSC = new CustomsDeclarationEurSC();
		try {
			event = new OpusbkgSpainCRNReceiveEvent();

			event.setFlatFile(str);
			customsDeclarationEurSC.perform(event);

		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new EventException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new EventException(new ErrorHandler(e).getMessage());
		} finally {
			eai.close();
		}
		log.info("<<<<<<<<<< alpsbkgSpainCRNReceiveMQ End >>>>>>>>>>>>>>>>");
	}

	/**
	 *
	 * @param eai
	 * @throws Exception
	 */
	public void ediErrCaReceiveMQ(TransferEAI eai) throws Exception{

		log.info("<<<<<<<<<< ediErrCaReceiveMQ Start >>>>>>>>>>>>>>>>");

		try {

			OpusbkgEdiErrCaReceiveEvent event = new OpusbkgEdiErrCaReceiveEvent();
			event.setFlatFile(eai.getMessage());

			CustomsDeclarationCanadaSC  sc    = new CustomsDeclarationCanadaSC();

			sc.perform(event);

		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new EventException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new EventException(new ErrorHandler(e).getMessage());
		} finally {
			eai.close();
		}

		log.info("<<<<<<<<<< ediErrCaReceiveMQ End >>>>>>>>>>>>>>>>");
	}

	/**
	 *
	 * @param eai
	 * @throws Exception
	 */
	public void ediErrUsReceiveMQ(TransferEAI eai) throws Exception{

		log.info("<<<<<<<<<< ediErrUsReceiveMQ Start >>>>>>>>>>>>>>>>");

		try {

			OpusbkgEdiErrUsReceiveEvent event = new OpusbkgEdiErrUsReceiveEvent();
			event.setFlatFile(eai.getMessage());

			CustomsDeclarationUsaSC  sc    = new CustomsDeclarationUsaSC();

			sc.perform(event);

		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new EventException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new EventException(new ErrorHandler(e).getMessage());
		} finally {
			eai.close();
		}

		log.info("<<<<<<<<<< ediErrUsReceiveMQ End >>>>>>>>>>>>>>>>");
	}

	/**
	 *
	 * @param eai
	 * @throws Exception
	 */
	public void ediErrEur24ReceiveMQ(TransferEAI eai) throws Exception{

		log.info("<<<<<<<<<< ediErrEuReceiveMQ Start >>>>>>>>>>>>>>>>");

		try {

			OpusbkgEdiErrEur24ReceiveEvent event = new OpusbkgEdiErrEur24ReceiveEvent();
			event.setFlatFile(eai.getMessage());

			CustomsDeclarationEur24SC  sc    = new CustomsDeclarationEur24SC();

			sc.perform(event);

		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new EventException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new EventException(new ErrorHandler(e).getMessage());
		} finally {
			eai.close();
		}

		log.info("<<<<<<<<<< ediErrEuReceiveMQ End >>>>>>>>>>>>>>>>");
	}

	/**
	 * JMS Receive(EDI_T_BKG_T_NZCUS_ACK)<br>
	 * @param eai TransferEAI
	 * @exception EventException
	 */
	public void opusbkgNzcusReceiveMQ(TransferEAI eai) throws EventException {

		String str = eai.getMessage();
		CustomsDeclarationNewZealandSC customsDeclarationNewZealandSC = new CustomsDeclarationNewZealandSC();
		try {
			OpusBkgNzcusAckEvent event = new OpusBkgNzcusAckEvent();

			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);

			event.setFlatFile(str);
			customsDeclarationNewZealandSC.perform(event);

		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new EventException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new EventException(new ErrorHandler(e).getMessage());
		}
		eai.close();
	}

	/**
	 * 파나마 수신
	 * @param eai
	 * @throws Exception
	 */
	public void opusbkgPanamaReceiveMQ(TransferEAI eai) throws Exception{

		log.info("<<<<<<<<<< ediErrEuReceiveMQ Start >>>>>>>>>>>>>>>>");

		try {

			OpusbkgPanamaReceiveEvent event = new OpusbkgPanamaReceiveEvent();
			event.setFlatFile(eai.getMessage());

			CustomsDeclarationPanamaSC  sc    = new CustomsDeclarationPanamaSC();

			sc.perform(event);

		} catch (EventException ee) {
			eai.rollback(ee);
			log.error("EventException ee : " + ee.toString(), ee);
			throw new EventException(new ErrorHandler(ee).getMessage());
		} catch (Exception e){
			eai.rollback(e);
			log.error("Exception e : " + e.toString());
			throw new EventException(new ErrorHandler(e).getMessage());
		} finally {
			eai.close();
		}

		log.info("<<<<<<<<<< ediErrEuReceiveMQ End >>>>>>>>>>>>>>>>");
	}

	/**
	 * [EDI_T_BKG_T_CNCUS_SYS_ACK] China SYS ACK 메세지 수신
	 * EDI Receive <br>
	 *
	 * @param TransferEAI transferEAI
	 * @exception EventException, Exception
	 */
	public void receiveEDIForChinaSysAck(TransferEAI transferEAI) throws EventException {
		String ediMessage = transferEAI.getMessage();

		try {
			FormCommand formCommand = new FormCommand();
			formCommand.setCommand(FormCommand.TRANS);

			EdiBkgChinaSysAckEvent ediBkgChinaSysAckEvent = new EdiBkgChinaSysAckEvent();
			ediBkgChinaSysAckEvent.setFormCommand(formCommand);
			ediBkgChinaSysAckEvent.setFlatFile(ediMessage);

			CustomsDeclarationChinaSC customsDeclarationChinaSC = new CustomsDeclarationChinaSC();
			customsDeclarationChinaSC.perform(ediBkgChinaSysAckEvent);

			// instance id추출하여 완료여부 전달
			transferEAI.commit(ediMessage.substring(0, 10));

		} catch (EventException ex) {
			transferEAI.rollback(ex);
			log.error("EventException ex : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex){
			transferEAI.rollback(ex);
			log.error("Exception ex : " + ex.toString());
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		transferEAI.close();
	}


}
