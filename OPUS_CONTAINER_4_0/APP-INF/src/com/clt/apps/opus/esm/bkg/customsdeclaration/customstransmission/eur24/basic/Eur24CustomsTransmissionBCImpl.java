/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EurCustomsTransmissionBCImpl.java
*@FileTitle : EurCustomsTransmissionBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.10
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.09.10 김경섭
* 1.0 Creation
 * -------------------------------------------------------
 * History
 * 2011.06.29 김경섭 [] 그리스 사태로 임시 수정
 * 2012.06.07 김보배 [CHM-201218012] [BKG] [Spain EXS] Previous Doc Ref#관련 Subplace 항목추가 (MEDCUSRPL F/File, EXS F/File, EXS BL inquiry screen)
 * 2012.07.16 김보배 [CHM-201218619] [BKG] ENS, D/R, A/N 전송시 ENS ETA 고정값 적용 요청
 * 2013.06.25 김보배 [CHM-201324814] [ENS FI] Finland 세관 ENS 개발 요청 (IE344, IE347)
 * 2013.08.21 김보배 [CHM-201325971] 이스라엘 FROB 신고 화면
 * 2013.12.05 신규정 [CHM-201327518] [ENS] ENS ETA 과거 데이터 입력에 대한 validation 설정 요청
 * 2013.12.16 김보배 [CHM-201328032] [GB ENS] ENS address field 상에 "&" 입력시 "AND"로 변경요청
 * 2013.12.23 김보배 [CHM-201328033] [ENS] Arrival notification 상 Flat file 수정요청
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsEmlNtfcVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.basic.EurCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.integration.Eur24CustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eu24ManifestTransmitOBVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eu24ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eu24RcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlCMinfoListOBVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlCMinfoListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlCntrListOBVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlCntrListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlCntrMfListOBVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlCntrMfListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlCntrSealListOBVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlCntrSealListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlCustListOBVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlCustListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlDgCgoListOBVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlDgCgoListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlForEmlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlRouteCntListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlinfoOBVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24BlinfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24DiversionRequestVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24SendHistoryOBVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24SendHistoryVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24VesselArrivalTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eur24VesselArrivalVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.integration.IsraelCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eur24VesselFIArrivalNoticeDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.javamail.TemplateMail;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;



/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kyoung Jong Yun
 * @see EurCustomsTransmissionBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */ 
public class Eur24CustomsTransmissionBCImpl extends BasicCommandSupport implements Eur24CustomsTransmissionBC{
	// Database Access Object
	private transient Eur24CustomsTransmissionDBDAO dbDao = null;
	private transient IsraelCustomsTransmissionDBDAO ilDbDao = null;
	
	/**
	 * EurCustomsTransmissionBCImpl 객체 생성<br>
	 * EurCustomsTransmissionDBDAO 생성한다.<br>
	 */
	public Eur24CustomsTransmissionBCImpl(){
		dbDao = new Eur24CustomsTransmissionDBDAO();
		ilDbDao = new IsraelCustomsTransmissionDBDAO();
	}

	/**
	 * Voyage 별로 UVI (Unique Vessel Identifier) <br>
	 * 
	 * @param  VesselArrivalTransmitVO vesselArrivalTransmitVO
	 * @param  SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	@SuppressWarnings("unused")
	public String transmitVesselArrival(VesselArrivalTransmitVO vesselArrivalTransmitVO, SignOnUserAccount account) throws EventException{
		List<Eur24VesselArrivalVO> eur24VesselArrivalVOList = null;
		String flatFile = "";
		String eurVvd ="";
		String pType = "";
		
		Eur24VesselArrivalTransmitVO anTransmitVO = new Eur24VesselArrivalTransmitVO();
		anTransmitVO = (Eur24VesselArrivalTransmitVO)vesselArrivalTransmitVO;
		pType = anTransmitVO.getPType();
		
		BookingUtil util = null;
		try{
			util = new BookingUtil();
			// body
			eur24VesselArrivalVOList = dbDao.searchVesselArrival((Eur24VesselArrivalTransmitVO)vesselArrivalTransmitVO, account);
			
			// 2010-12-09 수정
			//FlatFile생성
			if(eur24VesselArrivalVOList != null && eur24VesselArrivalVOList.size() > 0){
				for(Eur24VesselArrivalVO  eurVo :  eur24VesselArrivalVOList){

					eurVvd = eurVo.getVslCd()+eurVo.getSkdVoyNo()+eurVo.getSkdDirCd();
					
//					if(eurVvd.equals("CSGP0071W")||eurVvd.equals("CSHI0074W")||eurVvd.equals("COLH0178W")||eurVvd.equals("CHKG0079W")
//							||eurVvd.equals("CHAM0076W")||eurVvd.equals("CRTM0069W")||eurVvd.equals("CQIN0083W")){
//						
//						//log.debug("\n eurVo.getEta()====>"+eurVo.getEta());
//						eurVo.setEta(util.addDate(eurVo.getEta(), -1));
//						eurVo.setEtaEu(util.addDate(eurVo.getEtaEu(), -1));
//						//log.debug("\n eurVo.getEta()====>"+eurVo.getEta());
//					}
					if("FI".equals(pType)){
						flatFile = makeFlatFileForFiArrivalNotice(util, eurVo);
					} else {
						flatFile = makeFlatFileForArrivalNotice(util, eurVo);
					}
				}
			}
			// addSendLog부분을 makeFlatFile전에 수행!
			if(eur24VesselArrivalVOList != null && eur24VesselArrivalVOList.size() > 0){
				for(Eur24VesselArrivalVO  eurVo :  eur24VesselArrivalVOList){
					Eur24SendHistoryVO vo = new Eur24SendHistoryVO();
					vo.setMsgSndNo(eurVo.getTradeRefNo());
					if("FI".equals(pType)){
						vo.setEurEdiMsgTpId("347");
					} else {
						vo.setEurEdiMsgTpId("ARN");
					}
					vo.setSndUsrId(account.getUsr_id());
					vo.setMsgFuncId("O");//A/N은 초기 신고밖에 없고 그 다음의 신고가 Diversion Request이기 때문에 무조건 O다
					vo.setVslCd(eurVo.getVslCd());
					vo.setSkdVoyNo(eurVo.getSkdVoyNo());
					vo.setSkdDirCd(eurVo.getSkdDirCd());
					vo.setBlNo("");
					vo.setCstmsPortCd(eurVo.getCstmsPortCd());
					vo.setEdiSndMsgCtnt(flatFile.toString());
					dbDao.addSendLog(vo, account);
					dbDao.updateMsgNoVesselArrival(vo);
				}
			}
			
			//실제 전송
			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(flatFile);
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_EUR24.IBMMQ.QUEUE"));
			FlatFileAckVO flatFileAckVO = util.sendFlatFile(sendFlatFileVO);
			if(flatFileAckVO.getAckStsCd().equals("E")){
				throw new EventException(new ErrorHandler("BKG06088",new String[]{}).getMessage());
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (DAOException ex){
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		} catch (Exception ex){
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
		return flatFile.toString();
	}
	
	/**
	 * Voyage 별로 UVI (Unique Vessel Identifier) <br>
	 * 
	 * @param  VesselArrivalDetailVO vesselArrivalDetailVO
	 * @param  VesselArrivalTransmitVO vesselArrivalTransmitVO
	 * @param  SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	@SuppressWarnings("unused")
	public String transmitFiBlArrival(VesselArrivalDetailVO vesselArrivalDetailVO,VesselArrivalTransmitVO vesselArrivalTransmitVO, SignOnUserAccount account) throws EventException{
		List<Eur24VesselArrivalVO> eur24VesselArrivalVOList = null;
		String flatFile = "";
		String eurVvd ="";
		String pType = "";
		
		Eur24VesselArrivalTransmitVO anTransmitVO = new Eur24VesselArrivalTransmitVO();
		anTransmitVO = (Eur24VesselArrivalTransmitVO)vesselArrivalTransmitVO;
		pType = anTransmitVO.getPType();
		
		Eur24VesselFIArrivalNoticeDetailVO anFITransmitVO = new Eur24VesselFIArrivalNoticeDetailVO();
		anFITransmitVO = (Eur24VesselFIArrivalNoticeDetailVO)vesselArrivalDetailVO;

		BookingUtil util = null;
		try{
			util = new BookingUtil();
			// body
			//eur24VesselArrivalVOList = dbDao.searchVesselArrival((Eur24VesselArrivalTransmitVO)vesselArrivalTransmitVO, account);
			eur24VesselArrivalVOList = dbDao.searchVesselArrivalFI((Eur24VesselFIArrivalNoticeDetailVO)vesselArrivalDetailVO, account);
			// 2010-12-09 수정
			//FlatFile생성
			
			log.debug("BCIMPL_EUR24________________transmit");
			if(eur24VesselArrivalVOList != null && eur24VesselArrivalVOList.size() > 0){
				for(Eur24VesselArrivalVO  eurVo :  eur24VesselArrivalVOList){

					eurVvd = eurVo.getVslCd()+eurVo.getSkdVoyNo()+eurVo.getSkdDirCd();
					

						flatFile = makeFlatFileArrivalNoticeFi(util, eurVo, anFITransmitVO);
						
				}
			}
			// addSendLog부분을 makeFlatFile전에 수행!
			if(eur24VesselArrivalVOList != null && eur24VesselArrivalVOList.size() > 0){
				for(Eur24VesselArrivalVO  eurVo :  eur24VesselArrivalVOList){
					Eur24SendHistoryVO vo = new Eur24SendHistoryVO();
					vo.setMsgSndNo(eurVo.getTradeRefNo());

						vo.setEurEdiMsgTpId("347");

					vo.setSndUsrId(account.getUsr_id());
					vo.setMsgFuncId("O");//A/N은 초기 신고밖에 없고 그 다음의 신고가 Diversion Request이기 때문에 무조건 O다
					vo.setVslCd(eurVo.getVslCd());
					vo.setSkdVoyNo(eurVo.getSkdVoyNo());
					vo.setSkdDirCd(eurVo.getSkdDirCd());
				
					vo.setBlNo(anFITransmitVO.getBlNo());
					vo.setCstmsPortCd(eurVo.getCstmsPortCd());
					vo.setEdiSndMsgCtnt(flatFile.toString());
					dbDao.addSendLog(vo, account);
					dbDao.updateMsgNoBLArrival(vo);
					//dbDao.updateMsgNoVesselArrival(vo);
				}
			}
			
			//실제 전송
			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(flatFile);
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_EUR24.IBMMQ.QUEUE"));
			FlatFileAckVO flatFileAckVO = util.sendFlatFile(sendFlatFileVO);
			if(flatFileAckVO.getAckStsCd().equals("E")){
				throw new EventException(new ErrorHandler("BKG06088",new String[]{}).getMessage());
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (DAOException ex){
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}catch (Exception ex){
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}
		return flatFile.toString();
	}

	/**
	 * EDI transmission file작성 <br>
	 * @param util
	 * @param eurVo
	 * @return
	 * @throws EventException
	 */
	public String makeFlatFileForArrivalNotice(BookingUtil util, Eur24VesselArrivalVO eurVo) throws EventException{
		String header;
		StringBuilder flatFile = new StringBuilder();
		// FlatFile Header를 생성한다.
//		header = util.searchCstmsEdiHeader(ConstantMgr.getScacCode(), "EUR24" + eurVo.getTransNation(), "ARNENT");
		header = util.searchCstmsEdiHeaderNew("EU24_ARRENT");
		
		CustomsCommonMgtBC comBc = new CustomsCommonMgtBCImpl(); 
		String conCrn = comBc.searchConVvd(eurVo.getVslCd()+eurVo.getSkdVoyNo()+eurVo.getSkdDirCd(),  eurVo.getCstmsPortCd(), "I");
		
		flatFile.append(header).append("\n");
		flatFile.append("DOC_NO:").append(eurVo.getDocNo().replace("\r", "").replace("\n", "")).append("\n");
		flatFile.append("CALL_REF_NO:").append(eurVo.getCallRefNo()).append("\n");
		flatFile.append("TRADE_REF_NO:").append(eurVo.getTradeRefNo()).append("\n");
		flatFile.append("PURPOSE_OF_CALL:").append(eurVo.getPurposeOfCall()).append("\n");
		flatFile.append("CRN:").append(eurVo.getCrn()).append("\n");
		flatFile.append("CON_CRN:").append(conCrn).append("\n");
		flatFile.append("TRANS_MODE:").append(eurVo.getTransMode()).append("\n");
		flatFile.append("TRANS_TYPE_CD:").append(eurVo.getTransTypeCd()).append("\n");
		flatFile.append("LLOYD_NO:").append(eurVo.getLloydNo()).append("\n");
		flatFile.append("VSL_NAME:").append(eurVo.getVslName()).append("\n");
		flatFile.append("TRANS_NATION:").append(eurVo.getTransNation()).append("\n");
		flatFile.append("ETA:").append(eurVo.getEta()).append("\n");
		flatFile.append("ETA_EU:").append(eurVo.getEtaEu()).append("\n");
		flatFile.append("ATA:").append(eurVo.getAta()).append("\n");
		flatFile.append("ETD:").append(eurVo.getEtd()).append("\n");
		flatFile.append("DTM_PRESENTATION:").append(eurVo.getDtmPresentation()).append("\n");
		flatFile.append("FIRST_OFFICE:").append(eurVo.getFirstOffice()).append("\n");
		flatFile.append("FIRST_OFFICE_ENS:").append(eurVo.getFirstOfficeEns()).append("\n");
		flatFile.append("POSITION_OF_SHIP:").append(eurVo.getPositionOfShip()).append("\n");
		flatFile.append("PREV_PORT:").append(eurVo.getPrevPort()).append("\n");
		flatFile.append("ARRIVAL_PORT:").append(eurVo.getArrivalPort()).append("\n");
		flatFile.append("NEXT_PORT:").append(eurVo.getNextPort()).append("\n");
		flatFile.append("CERT_REG_NO:").append(eurVo.getCertRegNo()).append("\n");
		flatFile.append("CERT_REG_DT:").append(eurVo.getCertRegDt()).append("\n");
		flatFile.append("CERT_REG_LOC:").append(eurVo.getCertRegLoc()).append("\n");
		flatFile.append("GROSS_TON:").append(eurVo.getGrossTon()).append("\n");
		flatFile.append("NET_TON:").append(eurVo.getNetTon()).append("\n");
		flatFile.append("NO_OF_CREW:").append(eurVo.getNoOfCrew()).append("\n");
		flatFile.append("NO_OF_PASSENGER:").append(eurVo.getNoOfPassenger()).append("\n");
		flatFile.append("{PARTY_INFO").append("\n");
		flatFile.append("PT_TYPE:CA").append("\n");
		flatFile.append("PT_TIN:").append("\n");
		flatFile.append("PT_EORI:GB577597470000").append("\n");
		flatFile.append("PT_NAME:").append("\n");
		flatFile.append("PT_ADDRESS:").append("\n");
		flatFile.append("PT_STREET:").append("\n");
		flatFile.append("PT_CITY:").append("\n");
		flatFile.append("PT_POSTAL_CD:").append("\n");
		flatFile.append("PT_CNT_CD:").append("\n");
		flatFile.append("{PT_COM_INFO").append("\n");
		flatFile.append("PT_CON_NAME:").append(eurVo.getPtConName()).append("\n");
		flatFile.append("PT_CON_CMPY:").append(eurVo.getPtConCmpy()).append("\n");
		flatFile.append("PT_FAX_NO:").append(eurVo.getPtFaxNo()).append("\n");
		flatFile.append("PT_EM_NO:").append(eurVo.getPtEmNo()).append("\n");
		flatFile.append("PT_TEL_NO:").append(eurVo.getPtTelNo()).append("\n");
		flatFile.append("}PT_COM_INFO").append("\n");
		flatFile.append("}PARTY_INFO").append("\n");
//		flatFile.append("{ROUTE_PORT").append("\n");
//		flatFile.append("ROUTING_PORT:").append("\n");
//		flatFile.append("}ROUTE_PORT").append("\n");
//		flatFile.append("{ROUTE_PORT").append("\n");
//		flatFile.append("ROUTING_PORT:").append("\n");
//		flatFile.append("}ROUTE_PORT").append("\n");
		return flatFile.toString();
	}

	/**
	 * Voyage 별로 UVI (Unique Vessel Identifier) <br>
	 * 
	 * @param  VesselArrivalTransmitVO vesselArrivalTransmitVO
	 * @param  SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitDiversionRequest(VesselArrivalTransmitVO vesselArrivalTransmitVO, SignOnUserAccount account) throws EventException{
		String retFlatFile = "";
		String eurVvd = "";
		List<Eur24DiversionRequestVO> eur24DiversionRequestVOList = null;
		String flatFile = "";
		BookingUtil util = null;
		try{
			util = new BookingUtil();
			// body
			eur24DiversionRequestVOList = dbDao.searchDiversionRequest((Eur24VesselArrivalTransmitVO)vesselArrivalTransmitVO, account);
			// 2010-12-09 수정
			//FlatFile생성
			if(eur24DiversionRequestVOList != null && eur24DiversionRequestVOList.size() > 0){
				for(Eur24DiversionRequestVO  eurVo :  eur24DiversionRequestVOList){
					
					eurVvd = eurVo.getVslCd()+eurVo.getSkdVoyNo()+eurVo.getSkdDirCd();
					
					if(eurVvd.equals("CSGP0071W")||eurVvd.equals("CSHI0074W")||eurVvd.equals("COLH0178W")||eurVvd.equals("CHKG0079W")
							||eurVvd.equals("CHAM0076W")||eurVvd.equals("CRTM0069W")||eurVvd.equals("CQIN0083W")){
						
						//log.debug("\n eurVo.getEta()====>"+eurVo.getEta());
						eurVo.setEta(util.addDate(eurVo.getEta(), -1));
						//log.debug("\n eurVo.getEta()====>"+eurVo.getEta());
					}
					
					flatFile = makeFlatFileForDiversionRequest(util, eurVo);
				}
			}
			// addSendLog부분을 makeFlatFile전에 수행!
			if(eur24DiversionRequestVOList != null && eur24DiversionRequestVOList.size() > 0){
				for(Eur24DiversionRequestVO  eurVo :  eur24DiversionRequestVOList){
					Eur24SendHistoryVO vo = new Eur24SendHistoryVO();
					vo.setMsgSndNo(eurVo.getDivRefNo());
					vo.setEurEdiMsgTpId("DIV");
					vo.setSndUsrId(account.getUsr_id());
					vo.setMsgFuncId("O");//A/N은 초기 신고밖에 없고 그 다음의 신고가 Diversion Request이기 때문에 무조건 O다
					vo.setVslCd(eurVo.getVslCd());
					vo.setSkdVoyNo(eurVo.getSkdVoyNo());
					vo.setSkdDirCd(eurVo.getSkdDirCd());
					vo.setBlNo("");
					vo.setCstmsPortCd(eurVo.getCstmsPortCd());
					vo.setEdiSndMsgCtnt(flatFile);
					dbDao.addSendLog(vo, account);
					dbDao.updateMsgNoVesselArrival(vo);
				}
			}
			
			//실제 전송
			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(flatFile);
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_EUR24.IBMMQ.QUEUE"));
			FlatFileAckVO flatFileAckVO = util.sendFlatFile(sendFlatFileVO);

			if(flatFileAckVO.getAckStsCd().equals("E")){
				throw new EventException(new ErrorHandler("BKG06088",new String[]{}).getMessage());
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (DAOException ex){
	        log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
		}catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return retFlatFile;
	}

	/**
	 * EDI transmission file작성 <br>
	 * 
	 * @param util
	 * @param eurVo
	 * @return
	 * @throws EventException
	 */
	public String makeFlatFileForDiversionRequest(BookingUtil util, Eur24DiversionRequestVO eurVo) throws EventException{
		String header;
		StringBuilder flatFile = new StringBuilder();
		
		CustomsCommonMgtBC comBc = new CustomsCommonMgtBCImpl(); 
		String conCrn = comBc.searchConVvd(eurVo.getVslCd()+eurVo.getSkdVoyNo()+eurVo.getSkdDirCd(),  eurVo.getCstmsPortCd(), "I");
		
		// FlatFile Header를 생성한다.
//		header = util.searchCstmsEdiHeader(ConstantMgr.getScacCode(), "EUR24" + eurVo.getCntCd(), "DIVREQ");
		header = util.searchCstmsEdiHeaderNew("EU24_DIVREQ");
		
		flatFile.append(header).append("\n");
		flatFile.append("DOC_NO:").append(eurVo.getDocNo().replace("\r", "").replace("\n", "")).append("\n");
		flatFile.append("CALL_REF_NO:").append(eurVo.getCallRefNo()).append("\n");
		flatFile.append("ORG_REF_NO:").append(eurVo.getOrgRefNo()).append("\n");
		flatFile.append("CRN:").append(eurVo.getCrn()).append("\n");
		flatFile.append("CON_CRN:").append(conCrn).append("\n");
		String eu1stPort = eurVo.getCstmsPortCd();
		//First Port Code가 Italy인 경우에 FlatFile에 해당 데이터를 추가한다.
		if(eu1stPort!= null && !eu1stPort.equals("") && eu1stPort.substring(0,2).equals("IT")){
			Eur24BlinfoVO eur24Itseq;
			try {
				eur24Itseq = dbDao.searchEur24ItarySeq().get(0);
			}catch (DAOException ex){
		        log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG06086", new String[]{}).getMessage(), ex);
			}
			flatFile.append("IT_SEQ:").append(eur24Itseq.getItSeq()).append("\n");
			flatFile.append("IT_FILE_SEQ:").append(eur24Itseq.getItFileSeq()).append("\n");
		}
		flatFile.append("DIV_REF_NO:").append(eurVo.getDivRefNo()).append("\n");
		flatFile.append("TRANS_MODE:").append(eurVo.getTransMode()).append("\n");
		flatFile.append("LLOYD_CD:").append(eurVo.getLloydCd()).append("\n");
		flatFile.append("VSL_NAME:").append(eurVo.getVslName()).append("\n");
		flatFile.append("ETA:").append(eurVo.getEta()).append("\n");
		flatFile.append("CNT_CD:").append(eurVo.getCntCd()).append("\n");
		flatFile.append("INFO_TYPE:").append(eurVo.getInfoType()).append("\n");
		flatFile.append("ORG_FIRST_OFFICE:").append(eurVo.getOrgFirstOffice()).append("\n");
		flatFile.append("ACT_FIRST_OFFICE:").append(eurVo.getActFirstOffice()).append("\n");
		flatFile.append("PREV_PORT:").append(eurVo.getPrevPort()).append("\n");
		flatFile.append("{ROUTE_PORT").append("\n");
		flatFile.append("ROUTING_PORT:").append(eurVo.getRoutingPort()).append("\n");
		flatFile.append("}ROUTE_PORT").append("\n");
		flatFile.append("{PARTY_INFO").append("\n");
		flatFile.append("PT_TYPE:CA").append("\n");
		flatFile.append("PT_TIN:").append("\n");
		flatFile.append("PT_EORI:GB577597470000").append("\n");
		flatFile.append("PT_NAME:").append("\n");
		flatFile.append("PT_ADDRESS:").append("\n");
		flatFile.append("PT_STREET:").append("\n");
		flatFile.append("PT_CITY:").append("\n");
		flatFile.append("PT_POSTAL_CD:").append("\n");
		flatFile.append("PT_CNT_CD:").append("\n");
		flatFile.append("{PT_COM_INFO").append("\n");
		flatFile.append("PT_CON_NAME:").append(eurVo.getPtConName()).append("\n");
		flatFile.append("PT_CON_CMPY:").append(eurVo.getPtConCmpy()).append("\n");
		flatFile.append("PT_FAX_NO:").append(eurVo.getPtFaxNo()).append("\n");
		flatFile.append("PT_EM_NO:").append(eurVo.getPtEmNo()).append("\n");
		flatFile.append("PT_TEL_NO:").append(eurVo.getPtTelNo()).append("\n");		
		flatFile.append("}PT_COM_INFO").append("\n");
		flatFile.append("}PARTY_INFO").append("\n");
		return flatFile.toString();
	}
	
	/**
	 * BackEndJob을 실행.
	 * 
	 * @param SignOnUserAccount account
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 * 
	 */
	public String startBackEndJob(SignOnUserAccount account, ManifestTransmitVO[] manifestTransmitVOs, String pgmNo )  throws EventException{
		
		String resultStr = "";
		
		if(pgmNo.equals("ESM_BKG_1106")) {
			Eur24CustomsTransmissionBackEndJob backEndJob = new Eur24CustomsTransmissionBackEndJob();
			backEndJob.setPgmNo(pgmNo);
			backEndJob.setManifestTransmitVOs(manifestTransmitVOs);
			backEndJob.setAccount(account);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			resultStr = backEndJobManager.execute(backEndJob , account.getUsr_id(), "EU24 EDI Transmit");
		} 
		else if(pgmNo.equals("ESM_BKG_1121")) {
			Eur24CustomsTransmissionBackEndJob backEndJob = new Eur24CustomsTransmissionBackEndJob();
			backEndJob.setPgmNo(pgmNo);
			backEndJob.setManifestTransmitVOs(manifestTransmitVOs);
			backEndJob.setAccount(account);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			resultStr = backEndJobManager.execute(backEndJob , account.getUsr_id(), "EU24 OB EDI Transmit");
		}
		
		return resultStr;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * EUR를 통과하는 화물에 대한 Manifest를 ACP(Authority of Canal of Panama)에 신고하기 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException {
		
		log.debug("####################################################\n\n\n\n\n transmitManifest START!");
		StringBuffer flatFile = null;
		StringBuffer result = new StringBuffer();
		StringBuffer bfTemp = new StringBuffer();
		
		Eu24ManifestTransmitVO eu24ManifestTransmitVO = new Eu24ManifestTransmitVO();

		Eur24BlinfoVO eur24Itseq = null;
		List<Eur24BlinfoVO> eur24BlinfoVOs = null;
		List<Eur24BlCustListVO> eur24BlCustListVOs = null;
		List<Eur24BlCntrListVO> eur24BlCntrListVOs = null;
		List<Eur24BlDgCgoListVO> eur24BlDgCgoListVOs = null;
		List<Eur24BlCntrMfListVO> eur24BlCntrMfListVOs = null;
		List<Eur24BlCntrSealListVO> eur24BlCntrSealListVOs = null;
		List<Eur24BlCMinfoListVO> eur24BlCMinfoListVOs = null;
		List<Eur24BlRouteCntListVO> eur24BlRouteCntListVOs = null;
		
		String pSendYn = ""; 
		
		Eur24BlinfoVO		blinfoVO    = null;
		Eur24BlCustListVO	custVO      = null;
		Eur24BlCntrListVO	cntrVO      = null;
		Eur24BlDgCgoListVO	dgCgoVO     = null;
		Eur24BlCntrMfListVO	cntrMfVO    = null;
		Eur24BlCntrSealListVO	cntrSealVO  = null;

		Eur24BlCMinfoListVO     cMinfoVO    = null;
		
		BookingUtil command = new BookingUtil();
		
		// 헤더 생성용 객체
		String flatFileHeader = null;
//		String flatFileRefNo = null;
		BookingUtil bookingUtil = new BookingUtil();
		
		// 송수신처 판단
//		String sender 	= ConstantMgr.getScacCode();
//		String receiver = "EUR24";
		
		Eur24SendHistoryVO eur24SendHistoryVO = null; //이력 테이블 VO
		
		String blNo="";
		String vslCd="";
		String skdVoyNo="";
		String skdDirCd="";
		String eu1stPort="";
		String cntrNo="";
		String uploadEtaHis = "";
		String pType = "";
		
		String[] tempStr = null;
		int tempCount = 0;
		
		try {
			if (manifestTransmitVOs.length > 0) {
				pSendYn = ((Eu24ManifestTransmitVO)manifestTransmitVOs[0]).getPSendYn(); 
				String blNumber = ""; // bl_no별 전송하기 때문에 같은 bl_no를 체크하기 위함.
				for (int q = 0; q < manifestTransmitVOs.length; q++) {
					
					flatFile = new StringBuffer();
					bfTemp.setLength(0);
					
					eu24ManifestTransmitVO = (Eu24ManifestTransmitVO) manifestTransmitVOs[q];
					
					blNo     = eu24ManifestTransmitVO.getBlNo();
					vslCd    = eu24ManifestTransmitVO.getVslCd();
					skdVoyNo = eu24ManifestTransmitVO.getSkdVoyNo();
					skdDirCd = eu24ManifestTransmitVO.getSkdDirCd();
					eu1stPort= eu24ManifestTransmitVO.getEu1stPort();
					pType	 =  eu24ManifestTransmitVO.getPType();
					
					log.debug("::::::::::::::::::::::::::::");
					log.debug("::::::::::::::::::::::::::::");
					log.debug("blNo:"+blNo);
					log.debug("vslCd:"+vslCd);
					log.debug("skdVoyNo:"+skdVoyNo);
					log.debug("skdDirCd:"+skdDirCd);
					log.debug("eu1stPort:"+eu1stPort);
					log.debug("pType:"+pType);
					log.debug("::::::::::::::::::::::::::::");
					log.debug("::::::::::::::::::::::::::::");
					
					if (blNumber.equals(blNo)) continue;// 이전 bl과 같으면 건너뛴다.
					
					blNumber = blNo;
					
					//************************* Bl info 조회 ****************************
					eur24BlinfoVOs = dbDao.searchBlGeneral(blNo, vslCd, skdVoyNo, skdDirCd, eu1stPort, pType);
					
					if(eur24BlinfoVOs.size() <= 0 ) continue; //검색된것이 없으면 건너뛴다.//에러 처리
					
					blinfoVO = eur24BlinfoVOs.get(0);
					
//					if("Y".equals(blinfoVO.getTrsmVal())){
//						if(!"ESM_BKG_1108_2".equals(eu24ManifestTransmitVO.getPrtPgmNo())) {
//							throw new EventException(new ErrorHandler("BKG06151",new String[]{}).getMessage());
//						}
//					}

					
					// Header 생성
					//2011.06.29 그리스 문제로 임시 수정
					//2011.07.21 그리스 임시 수정 복구 작업 1
					String mrn = blinfoVO.getMrn();
					if (mrn != null && !"".equals(mrn)) {
						mrn = blinfoVO.getMrn().substring(0, 4);
					} else {
						mrn = "";
					}
					
					// NYK는 모두 "EU24_ENSDAT"
//					if("11IT".equals(mrn) && eu1stPort.substring(0,2).equals("GR")){
//						flatFileHeader = bookingUtil.searchCstmsEdiHeader(sender, receiver+"IT", blinfoVO.getMsgIdCd());
						flatFileHeader = bookingUtil.searchCstmsEdiHeaderNew("EU24_" + blinfoVO.getMsgIdCd());
//					}else{
//						flatFileHeader = bookingUtil.searchCstmsEdiHeader(sender, receiver+eu1stPort.substring(0, 2), blinfoVO.getMsgIdCd());
//					}
			        
//					flatFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf(ReferenceNumberGeneratorBroker.getChangedModule("BKC")));
//					flatFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("BKC"));
						
					// flatFile 에 추가
//					flatFile.append(flatFileHeader).append("\n");
					
					
					CustomsCommonMgtBC comBc = new CustomsCommonMgtBCImpl(); 
					String conCrn = comBc.searchConVvd(vslCd+skdVoyNo+skdDirCd, eu1stPort, "I");
					
					//공통정보 생성
					bfTemp.setLength(0);
					
					bfTemp.append("PRN:").append(blinfoVO.getPrn()).append("\n");
					bfTemp.append("CRN:").append(vslCd).append(skdVoyNo).append(skdDirCd).append("\n");
					bfTemp.append("CON_CRN:").append(conCrn).append("\n");
					bfTemp.append("LRN:").append(blNo).append("\n");
					bfTemp.append("MRN:").append(blinfoVO.getMrn()).append("\n");
					
					//////////////////////////////////////////////////////////////////////
					// Finland (IE344) 전용 ///////////////////////////////////////////////
					if("FI".equals(pType)){
						bfTemp.append("ORIGINAL_DATE:").append(blinfoVO.getOriginalDate()).append("\n");
						bfTemp.append("CUSTOMS_REF:").append(blinfoVO.getCustomsRef()).append("\n");
					}
					//////////////////////////////////////////////////////////////////////
					//////////////////////////////////////////////////////////////////////
					
					//2011.06.29 그리스 문제로 임시 수정
					//2011.07.21 그리스 임시 수정 복구 작업 1
					//if(eu1stPort.substring(0,2).equals("IT")){ // 원래 소스
					if(eu1stPort.substring(0,2).equals("IT") || ("11IT".equals(mrn) && eu1stPort.substring(0,2).equals("GR"))){
						eur24Itseq = dbDao.searchEur24ItarySeq().get(0);
						bfTemp.append("IT_SEQ:").append(eur24Itseq.getItSeq()).append("\n");
						bfTemp.append("IT_FILE_SEQ:").append(eur24Itseq.getItFileSeq()).append("\n");
					}else{
						//bfTemp.append("IT_SEQ:\n");
						//bfTemp.append("IT_FILE_SEQ:\n");
					}
					
					bfTemp.append("TRANS_MODE:").append("1").append("\n");
					bfTemp.append("TRANS_IDENTITY:").append(blinfoVO.getTransIdentity()).append("\n");
					bfTemp.append("TRANS_NATION:").append(blinfoVO.getTransNation()).append("\n");
					bfTemp.append("VSL_NAME:").append(blinfoVO.getVslName()).append("\n");
					bfTemp.append("LOAD_LOC_CD:").append(blinfoVO.getLoadLocCd()).append("\n");
					bfTemp.append("LOAD_LOC_NAME:").append(blinfoVO.getLoadLocName()).append("\n");
					bfTemp.append("LOAD_OFC_CD:").append(blinfoVO.getLoadOfcCd()).append("\n");
					bfTemp.append("LOAD_LOC_ETD:").append(blinfoVO.getLoadLocEtd()).append("\n");
					bfTemp.append("UNLOAD_LOC_CD:").append(blinfoVO.getUnloadLocCd()).append("\n");
					bfTemp.append("UNLOAD_LOC_NAME:").append(blinfoVO.getUnloadLocName()).append("\n");
					uploadEtaHis = blinfoVO.getUnloadLocEtaHis(); // send history 값 셋팅을 위해 사용
					bfTemp.append("UNLOAD_LOC_ETA:").append(blinfoVO.getUnloadLocEta()).append("\n");
					bfTemp.append("UNLOAD_OFC_CD:").append(blinfoVO.getUnloadOfcCd()).append("\n");
					bfTemp.append("PREV_LOC_CD:").append(blinfoVO.getPrevLocCd()).append("\n");
					bfTemp.append("NEXT_LOC_CD:").append(blinfoVO.getNextLocCd()).append("\n");
					bfTemp.append("NEXT_LOC_NAME:").append(blinfoVO.getNextLocName()).append("\n");
					bfTemp.append("NEXT_LOC_ETA:").append(blinfoVO.getNextLocEta()).append("\n");
					bfTemp.append("NEXT_OFC_CD:").append(blinfoVO.getNextOfcCd()).append("\n");
					
					bfTemp.append("{PARTY_INFO").append("\n");
					bfTemp.append("PT_TYPE:").append("CA").append("\n");
					bfTemp.append("PT_TIN:").append("").append("\n");
					bfTemp.append("PT_EORI:").append("GB577597470000").append("\n");
					bfTemp.append("PT_NAME:").append("").append("\n");
					bfTemp.append("PT_ADDRESS:").append("").append("\n");
					bfTemp.append("PT_STREET:").append("").append("\n");
					bfTemp.append("PT_CITY:").append("").append("\n");
					bfTemp.append("PT_POSTAL_CD:").append("").append("\n");
					bfTemp.append("PT_CNT_CD:").append("").append("\n");
					bfTemp.append("{PT_COM_INFO").append("\n");
					bfTemp.append("PT_CON_NAME:").append(blinfoVO.getCtName()).append("\n"); //? 확인
					bfTemp.append("PT_CON_CMPY:").append(blinfoVO.getCtPosition()).append("\n");
					bfTemp.append("PT_FAX_NO:").append(blinfoVO.getCtFax()).append("\n");
					bfTemp.append("PT_EM_NO:").append(blinfoVO.getCtEmail()).append("\n");
					bfTemp.append("PT_TEL_NO:").append(blinfoVO.getCtTel()).append("\n");
					bfTemp.append("}PT_COM_INFO").append("\n");
					bfTemp.append("}PARTY_INFO").append("\n");
					
					bfTemp.append("{BL_INFO").append("\n");
					bfTemp.append("BLNBR:").append(blinfoVO.getBlnbr()).append("\n");
					bfTemp.append("TO_ORDER_IND:").append(blinfoVO.getCustToOrdFlg()).append("\n");
			 		bfTemp.append("BL_TRANS_IDENTITY:").append(blinfoVO.getBlTransIdentity()).append("\n");
					bfTemp.append("BL_TRANS_NATION:").append(blinfoVO.getBlTransNation()).append("\n");
					bfTemp.append("BLPOL:").append(blinfoVO.getBlpol()).append("\n");
					bfTemp.append("POL_FULLNAME:").append(blinfoVO.getPolFullname()).append("\n");
					bfTemp.append("BLPOD:").append(blinfoVO.getBlpod()).append("\n");
					bfTemp.append("POD_FULLNAME:").append(blinfoVO.getPodFullname()).append("\n");
					bfTemp.append("POD_OFC_CD:").append(blinfoVO.getPodOfcCd()).append("\n");
					bfTemp.append("BLDEL:").append(blinfoVO.getBldel()).append("\n");
					bfTemp.append("DEL_FULLNAME:").append(blinfoVO.getDelFullname()).append("\n");
					bfTemp.append("BLPKG:").append(blinfoVO.getBlpkg()).append("\n");
					bfTemp.append("BLPKGU:").append(blinfoVO.getBlpkgu()).append("\n"); 
					bfTemp.append("BLMEA:").append(blinfoVO.getBlmea()).append("\n");
					bfTemp.append("BLMEAU:").append(blinfoVO.getBlmeau()).append("\n");
					bfTemp.append("COMMODITY:").append(blinfoVO.getCommodity()).append("\n");
					bfTemp.append("TRANS_DOC_NO:").append(blinfoVO.getTransDocNo()).append("\n");
					bfTemp.append("TRANS_DOC_NAME:").append(blinfoVO.getTransDocName()).append("\n");
					bfTemp.append("CUSTOMS_STATUS_CD:").append(blinfoVO.getCustomsStatusCd()).append("\n");
					bfTemp.append("PROCESS_INFO:").append(blinfoVO.getProcessInfo()).append("\n");
					bfTemp.append("PROCESS_TYPE:").append(blinfoVO.getProcessType()).append("\n");
					bfTemp.append("AEO_STATUS:").append(blinfoVO.getAeoStatus()).append("\n");
					bfTemp.append("PART_SHIPMENT:").append(blinfoVO.getPartShipment()).append("\n");
					bfTemp.append("CONSIGN_PLACE:").append(blinfoVO.getConsignPlace()).append("\n");
					bfTemp.append("DECLARE_DATE:").append(blinfoVO.getDeclareDate()).append("\n");
					bfTemp.append("DECLARE_LOC:").append(blinfoVO.getDeclareLoc()).append("\n");
					bfTemp.append("DECLARE_LOC_NAME:").append(blinfoVO.getDeclareLocName()).append("\n");
					bfTemp.append("PAYMENT_CD:").append(blinfoVO.getPaymentCd()).append("\n");
					bfTemp.append("LOCAL_CLEAR_NO:").append("").append("\n");
					bfTemp.append("TEMPORARY_STORAGE:").append("").append("\n");
					bfTemp.append("SPECIAL_REMARKS:").append(blinfoVO.getSpecialRemarks()).append("\n");
					
					flatFile.append(bfTemp);
					bfTemp.setLength(0);
					
					//bl cust정보
					eur24BlCustListVOs = dbDao.searchBlCust(blNo, vslCd, skdVoyNo, skdDirCd, eu1stPort);

					for (int i = 0; i < eur24BlCustListVOs.size(); i++) {
						custVO = eur24BlCustListVOs.get(i);
						
						bfTemp.append("{BL_PARTY_INFO").append("\n");
						bfTemp.append("BL_PT_TYPE:").append(custVO.getBlPtType()).append("\n");
						bfTemp.append("BL_PT_TIN:").append(custVO.getBlPtTin()).append("\n");
						bfTemp.append("BL_PT_EORI:").append(custVO.getBlPtEori()).append("\n");
						bfTemp.append("BL_PT_NAME:").append(custVO.getBlPtName()).append("\n");
						bfTemp.append("BL_PT_ADDRESS:").append(custVO.getBlPtAddress()).append("\n");
						bfTemp.append("BL_PT_STREET:").append(custVO.getBlPtStreet()).append("\n");
						bfTemp.append("BL_PT_CITY:").append(custVO.getBlPtCity()).append("\n");
						bfTemp.append("BL_PT_POSTAL_CD:").append(custVO.getBlPtPostalCd()).append("\n");
						bfTemp.append("BL_PT_CNT_CD:").append(custVO.getBlPtCntCd()).append("\n");
						bfTemp.append("}BL_PARTY_INFO").append("\n");

						
					}//end for eur24BlCustListVOs
					
					flatFile.append(bfTemp);
					bfTemp.setLength(0);
					int splitBytesLength = 512;
					tempStr = blinfoVO.getDescs().split("\\$@\\$");
					for (int i = 0; i < tempStr.length; i++) {
						for (int m = 0; m < tempStr[i].length(); m += splitBytesLength) {
							bfTemp.append("{DESC").append("\n");
							bfTemp.append("DESC:").append(tempStr[i].substring(m, m + splitBytesLength > tempStr[i].length() ? tempStr[i].length(): m + splitBytesLength ) ).append("\n");
							bfTemp.append("}DESC").append("\n");
						}
					}
					
					flatFile.append(bfTemp);
					bfTemp.setLength(0);
					
					tempStr = blinfoVO.getMarkno().split("\\$@\\$");
					for (int i = 0; i < tempStr.length; i++) {
						for (int m = 0; m < tempStr[i].length(); m += splitBytesLength) {
							bfTemp.append("{MARK").append("\n");
							bfTemp.append("MARKNO:").append(tempStr[i].substring(m, m + splitBytesLength > tempStr[i].length() ? tempStr[i].length(): m + splitBytesLength ) ).append("\n");
							bfTemp.append("}MARK").append("\n");
						}
					}
					
					flatFile.append(bfTemp);
					bfTemp.setLength(0);
					
					//************** 컨테이너별 반복 ********************
					eur24BlCntrListVOs = dbDao.searchBlCntr(blNo, vslCd, skdVoyNo, skdDirCd, eu1stPort);
					for (int i = 0; i < eur24BlCntrListVOs.size(); i++) {
						cntrVO = eur24BlCntrListVOs.get(i);
						cntrNo = cntrVO.getCntrNo();

						bfTemp.append("{CNTR_INFO").append("\n");
						bfTemp.append("CNTRNBR:").append(cntrVO.getCntrnbr()).append("\n");
						bfTemp.append("FM_IND:").append(cntrVO.getFmInd()).append("\n");
						bfTemp.append("PUNIT:").append(cntrVO.getPunit()).append("\n");
						bfTemp.append("PKG:").append(cntrVO.getPkg()).append("\n");
						bfTemp.append("CNTRWGT:").append(cntrVO.getCntrwgt()).append("\n");
						bfTemp.append("CNTRGWGT:").append(cntrVO.getCntrgwgt()).append("\n");
						bfTemp.append("CNTR_WGT_UNIT:").append(cntrVO.getCntrWgtUnit()).append("\n");
						bfTemp.append("CNTRTYPE:").append(cntrVO.getCntrtype()).append("\n");
						bfTemp.append("CMDT_DESC:").append(cntrVO.getCmdtDesc()).append("\n");
						bfTemp.append("CMDTCD:").append(cntrVO.getCmdtcd()).append("\n");

						
						eur24BlDgCgoListVOs = dbDao.searchBlDgCgo(blNo, vslCd, skdVoyNo, skdDirCd, eu1stPort,cntrNo);
						for (int j = 0; j < eur24BlDgCgoListVOs.size(); j++) {
							dgCgoVO = eur24BlDgCgoListVOs.get(j);
							
							bfTemp.append("{CNTR_DANGER").append("\n");
							bfTemp.append("UNNBR:").append(dgCgoVO.getUnnbr()).append("\n");
							bfTemp.append("CLASS:").append(dgCgoVO.getClassCd()).append("\n");
							bfTemp.append("D_PKG:").append(dgCgoVO.getDPkg()).append("\n");
							bfTemp.append("D_PKGUNIT:").append(dgCgoVO.getDPkgunit()).append("\n");
							bfTemp.append("GWGT:").append(dgCgoVO.getGwgt()).append("\n");
							bfTemp.append("GWGT_UNIT:").append(dgCgoVO.getGwgtUnit()).append("\n");
							bfTemp.append("MEA:").append(dgCgoVO.getMea()).append("\n");
							bfTemp.append("MEA_UNIT:").append(dgCgoVO.getMeaUnit()).append("\n");
							bfTemp.append("}CNTR_DANGER").append("\n");

						}//end for eur24BlDgCgoListVOs
						
						
						eur24BlCntrMfListVOs = dbDao.searchBlCntrMfDesc(blNo, vslCd, skdVoyNo, skdDirCd, eu1stPort,cntrNo);
						for (int j = 0; j < eur24BlCntrMfListVOs.size(); j++) {
							cntrMfVO = eur24BlCntrMfListVOs.get(j);
							bfTemp.append("{CNTR_DESC").append("\n");
							bfTemp.append("D_PUNIT:").append(cntrMfVO.getDPunit()).append("\n");
							bfTemp.append("D_PKG:").append(cntrMfVO.getDPkg()).append("\n");
							bfTemp.append("D_WGT:").append(cntrMfVO.getDWgt()).append("\n");
							bfTemp.append("D_MEAS:").append(cntrMfVO.getDMeas()).append("\n");
							bfTemp.append("D_DESC:").append(cntrMfVO.getDDesc()).append("\n");
							bfTemp.append("{CUS_MARK").append("\n");
							bfTemp.append("D_MARK:").append(cntrMfVO.getDMark()).append("\n");
							bfTemp.append("}CUS_MARK").append("\n");
							bfTemp.append("}CNTR_DESC").append("\n");

							
						}//end for eur24BlCntrMfListVOs
						
						eur24BlCntrSealListVOs = dbDao.searchBlCntrSealNo(blNo, vslCd, skdVoyNo, skdDirCd, eu1stPort,cntrNo);
						for (int j = 0; j < eur24BlCntrSealListVOs.size(); j++) {
							cntrSealVO = eur24BlCntrSealListVOs.get(j);
							bfTemp.append("{MULTI_SEAL").append("\n");
							bfTemp.append("SEAL_TYPE:").append(cntrSealVO.getSealType()).append("\n");
							bfTemp.append("SEAL_NBR:").append(cntrSealVO.getSealNbr()).append("\n");
							bfTemp.append("}MULTI_SEAL").append("\n");
						}//end for eur24BlCntrSealListVOs
						
						bfTemp.append("}CNTR_INFO").append("\n");
						

						
						flatFile.append(bfTemp);
						bfTemp.setLength(0);
						
					}//end for eur24BlCntrListVOs
					
					//************** 컨테이너별 반복 ********************끝

					
					
					//bl CMinfo정보
					eur24BlCMinfoListVOs = dbDao.searchBlCMinfo(blNo, vslCd, skdVoyNo, skdDirCd, eu1stPort,blinfoVO.getMsgIdCd());
					for (int i = 0; i < eur24BlCMinfoListVOs.size(); i++) {
						cMinfoVO = eur24BlCMinfoListVOs.get(i);
						bfTemp.append("{CM_INFO").append("\n");
						
						if(eu1stPort.substring(0,2).equals("NL")){
							bfTemp.append("CM_FLAG:").append(cMinfoVO.getCmFlag()).append("\n");
						}
						
						bfTemp.append("GOODS_ITEM_NO:").append(cMinfoVO.getGoodsItemNo()).append("\n");
						

						bfTemp.append("PIECE_COUNT:").append(cMinfoVO.getPieceCount()).append("\n");
						bfTemp.append("PKG_COUNT:").append(cMinfoVO.getPkgCount()).append("\n");
						bfTemp.append("PKG_TYPE:").append(cMinfoVO.getPkgType()).append("\n");
						bfTemp.append("GOODS_DESC:").append(cMinfoVO.getGoodsDesc()).append("\n");
						bfTemp.append("ITEM_GROSS_WGT:").append(cMinfoVO.getItemGrossWgt()).append("\n");
						bfTemp.append("TARIFF_CD:").append(cMinfoVO.getTariffCd()).append("\n");
						bfTemp.append("UNDG_NO:").append(cMinfoVO.getUndgNo()).append("\n");
						bfTemp.append("HANDLE_CD:").append(cMinfoVO.getHandleCd()).append("\n");
						bfTemp.append("HANDLE_INFO:").append(cMinfoVO.getHandleInfo()).append("\n");
						bfTemp.append("{CM_CNTR").append("\n");
						bfTemp.append("CM_CNTR_NO:").append(cMinfoVO.getCmCntrNo()).append("\n");
						bfTemp.append("CM_CNTR_PKG:").append(cMinfoVO.getCmCntrPkg()).append("\n");
						bfTemp.append("CM_SHIP_MARK:").append(cMinfoVO.getCmShipMark()).append("\n");
						bfTemp.append("}CM_CNTR").append("\n");
						bfTemp.append("}CM_INFO").append("\n");		
						
					}//end for eur24BlCMinfoListVOs
					
					flatFile.append(bfTemp);
					bfTemp.setLength(0);
					
					// ENS 전송이지만 POFE 가 FIKTKT 인 경우에는 IE344 와 동일한 ROUTE COUNTRY 를 구하기 위해 임시로 pType 변경
					if(eu1stPort.equals("FIKTK") && "ENS".equals(pType)){
//						pType = "FI";
						eur24BlRouteCntListVOs = dbDao.searchBlRouteCountry(blNo, vslCd, skdVoyNo, skdDirCd, "FI");
					} else {
						eur24BlRouteCntListVOs = dbDao.searchBlRouteCountry(blNo, vslCd, skdVoyNo, skdDirCd, pType);
					}
					
					//bl Route 정보
//					eur24BlRouteCntListVOs = dbDao.searchBlRouteCountry(blNo, vslCd, skdVoyNo, skdDirCd, pType);
					for (int i = 0; i < eur24BlRouteCntListVOs.size(); i++) {
						bfTemp.append("{ROUTE_COUNTRY").append("\n");
						bfTemp.append("COUNTRY:").append(eur24BlRouteCntListVOs.get(i).getRouteCnt()).append("\n");
						bfTemp.append("}ROUTE_COUNTRY").append("\n");						
					}//end for eur24BlRouteCntListVOs
					
					
					// 임시로 변경한 pType 을 원래대로 복구
//					if(eu1stPort.equals("FIKTK")){
//						if(pType.equals("FI")){
//							pType = "ENS"; 
//						}
//					}
					
					flatFile.append(bfTemp);
					flatFile.append("}BL_INFO");
					
//					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
//					sendFlatFileVO.setFlatFile(flatFile.toString());
//					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_EUR24.IBMMQ.QUEUE"));

					FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
					if(pSendYn.equals("Y")){
						
						eur24SendHistoryVO = new Eur24SendHistoryVO();
						
						eur24SendHistoryVO.setMsgSndNo(blinfoVO.getPrn());
						if("FI".equals(pType)){
							eur24SendHistoryVO.setEurEdiMsgTpId("344");
						} else {
							eur24SendHistoryVO.setEurEdiMsgTpId("ENS");
						}
						eur24SendHistoryVO.setSndUsrId(account.getUsr_id());
						
						if("315".equals(blinfoVO.getMsgId()) || "344".equals(blinfoVO.getMsgId())) {
							eur24SendHistoryVO.setMsgFuncId("O");
						} else {
//							uploadEtaHis = "";
							eur24SendHistoryVO.setMsgFuncId("U");
						}
						
						
						String rxpFlatFile = flatFile.toString().replaceAll("\n", "^^^").replaceAll("\\s+", " ").replaceAll("\\^\\^\\^", "\n"); // "space를 2개이상  전송하는 것을 방지하기 위한 로직
//						String rxpFlatFile = flatFile.toString().replaceAll("  " ," ").replaceAll("  ", " ");
						//  정규식을 사용해서 우선 엔터를 ^^^으로  치환 후 스페이스 1개이상을 1개로 변환 후 ^^^을 엔터로 치환
						StringBuffer sFlatFile = new StringBuffer();
						sFlatFile.append(flatFileHeader).append("\n");
						sFlatFile.append(rxpFlatFile); 

						SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
						sendFlatFileVO.setFlatFile(sFlatFile.toString());
						sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_EUR24.IBMMQ.QUEUE"));
						log.debug(sFlatFile.toString()+"%%%%%%%%%%%%%%%%%%");
						
						eur24SendHistoryVO.setVslCd(vslCd);
						eur24SendHistoryVO.setSkdVoyNo(skdVoyNo);
						eur24SendHistoryVO.setSkdDirCd(skdDirCd);
						eur24SendHistoryVO.setBlNo(blNo);
						eur24SendHistoryVO.setCstmsPortCd(eu1stPort);
						eur24SendHistoryVO.setEdiSndMsgCtnt(flatFile.toString());
						eur24SendHistoryVO.setCreUsrId(account.getUsr_id());
						eur24SendHistoryVO.setSndOfcCd(account.getOfc_cd());
						eur24SendHistoryVO.setUnloadLocEta(uploadEtaHis);
						
						log.error("@@@@@@@@@@@@@@@@@@@@@@@@@@ blNo + uploadEtaHis : " + eur24SendHistoryVO.getBlNo() + "^" + eur24SendHistoryVO.getUnloadLocEta());
						dbDao.addSendLog(eur24SendHistoryVO) ;
						dbDao.addBlCntrMFSndHist(eur24SendHistoryVO) ;
						log.error("@@@@@@@@@@@@@@@@@@@@@@@@@@ blNo + uploadEtaHis : " + eur24SendHistoryVO.getBlNo() + "^" + eur24SendHistoryVO.getUnloadLocEta());
						dbDao.modifyEU24BlMsgSndNo(eur24SendHistoryVO) ;
						log.error("@@@@@@@@@@@@@@@@@@@@@@@@@@ blNo + uploadEtaHis : " + eur24SendHistoryVO.getBlNo() + "^" + eur24SendHistoryVO.getUnloadLocEta());

						flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
						
						if (flatFileAckVO.getAckStsCd().equals("E"))
							throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
						
						log.debug("\n\n\n\n\n\n\n#################################################### file Send Success ##############################"+pSendYn);
					}
					
					log.debug("flatFile:\n\n");
					log.debug(flatFile.toString());
					log.debug("flatFile:\n\n");
					
					tempCount++;
					
					result.append(flatFile.toString()).append("\n\n");
				}//end for param manifestTransmitVOs 
			}
			
			log.debug("####################################################\n\n\n\n\n total cnt :"+ tempCount);
			log.debug("####################################################\n\n\n\n\n FLAT FILE: \n\n"+ result.toString());
		} catch (DAOException ex) {
			log.error("DAOException : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (EventException ex) {
			log.error("Exception : " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		
		log.debug("####################################################\n\n\n\n\n transmitManifest END!");
		return result.toString();
	}	
	

	/**
	 * RECEIVE받은 FLAT FILE을 로그테이블에 생성한다.<br>
	 * 
	 * @param  String rcvMsg
	 * @param  String userId
	 * @throws EventException
	 */
	public void loadCstmsRcvMsg(String rcvMsg,String userId) throws EventException {
	
		log.info("<<<<<<<<<< EUR24 loadCstmsRcvMsg Start >>>>>>>>>>>>>>>>");
		
		if(rcvMsg == null || rcvMsg.equals("")) return;

		List<Eu24RcvMsgVO> keyVo = null;
		Eu24RcvMsgVO eu24RcvMsgVO = null;
		Eu24RcvMsgVO eu24RcvMsgErrVO = null;
		
		String receiveType = "";
		String orgMsgRcv = "";
		
		String strEmlType = "";
		
		try {
			
			orgMsgRcv = getReceiveSingleItem (rcvMsg,"ORG_MSG_RCV:",   "\n");
			log.info("orgMsgRcv >>>> " + orgMsgRcv);
			
			keyVo = dbDao.searchEur24EdiRcvKey();
			if(keyVo == null || keyVo.size() == 0 ) return;

			eu24RcvMsgVO = new Eu24RcvMsgVO();
			
			eu24RcvMsgVO.setEdiRcvDt(keyVo.get(0).getEdiRcvDt());
			eu24RcvMsgVO.setEdiRcvSeq(keyVo.get(0).getEdiRcvSeq());
			
			eu24RcvMsgVO.setEurEdiMsgTpId(getReceiveSingleItem (rcvMsg,"MSG_ACK_TP:",   "\n"));
//			if("FROBIL".equals(orgMsgRcv)){
//				eu24RcvMsgVO.setEurEdiMsgTpId(getReceiveSingleItem (rcvMsg,"MSG_ACK_TP:",   "\n"));
//			}else{
//				eu24RcvMsgVO.setEurEdiMsgTpId(getReceiveSingleItem (rcvMsg,"MSG_ACK_TP:",   "\n"));
//			}
			eu24RcvMsgVO.setEdiSndMsgNm(getReceiveSingleItem   (rcvMsg,"ORG_MSG_NM:",   "\n"));
			eu24RcvMsgVO.setMsgRcvNo(getReceiveSingleItem      (rcvMsg,"ORG_MSG_KEY:",  "\n"));
			//eu24RcvMsgVO.setVslCd(getReceiveSingleItem         (rcvMsg,"MSG_VSL_CD:",   "\n"));
			//eu24RcvMsgVO.setSkdVoyNo(JSPUtil.getRPAD(getReceiveSingleItem(rcvMsg,"MSG_TMNL_VVD:", "\n"),9," ").substring(4,8).replaceAll(" ",""));

			//eu24RcvMsgVO.setSkdDirCd(JSPUtil.getRPAD(getReceiveSingleItem(rcvMsg,"MSG_TMNL_VVD:", "\n"),9," ").substring(8,9).replaceAll(" ",""));
			eu24RcvMsgVO.setCstmsPortCd(getReceiveSingleItem   (rcvMsg,"MSG_TO_PORT:",  "\n"));
			//eu24RcvMsgVO.setBlNo(getReceiveSingleItem          (rcvMsg,"",  "\n"));
			eu24RcvMsgVO.setAckKndId(getReceiveSingleItem      (rcvMsg,"MSG_ACK_TP:",    "\n"));
			eu24RcvMsgVO.setAckRcvStsCd(getReceiveSingleItem   (rcvMsg,"MSG_ACK_RSLT:",  "\n"));

			eu24RcvMsgVO.setEurCstmsAckCd(getReceiveSingleItem (rcvMsg,"MSG_ACK_CODE:",  "\n"));
			eu24RcvMsgVO.setAckDt(getReceiveSingleItem         (rcvMsg,"MSG_ACK_DT:",    "\n"));
			eu24RcvMsgVO.setAproDt(getReceiveSingleItem        (rcvMsg,"MSG_DT:",        "\n"));
			eu24RcvMsgVO.setMsgAcptRefNo(getReceiveSingleItem  (rcvMsg,"MSG_ACK_REF:",   "\n"));
			eu24RcvMsgVO.setMvmtRefNo(getReceiveSingleItem     (rcvMsg,"MRN:",           "\n"));

			eu24RcvMsgVO.setEurCstmsRjctCd(getReceiveSingleItem(rcvMsg,"REJ_CD:",        "\n"));
			eu24RcvMsgVO.setRjctRsnRmk(getReceiveSingleItem    (rcvMsg,"REJ_REASON:",     "\n"));
			eu24RcvMsgVO.setRjctDt(getReceiveSingleItem        (rcvMsg,"REJ_DT:",        "\n"));
			eu24RcvMsgVO.setEdiRcvMsgCtnt(rcvMsg);
			
			eu24RcvMsgVO.setCreUsrId("SYSTEM");
			
			/*
			 * 2011.09.21 경종윤
			 * 구주 24시 ack 관련 수신 type 구분
			 * MSG_RCV_NO 값에 ".315", "313", ".347", ".323" 문자가 있으면 ENS
			 *               ".615", "613" 문자가 있으면 EXS
			 *               NULL 이면 오류로 판단
			 */
			if(eu24RcvMsgVO.getMsgRcvNo().indexOf(".3") != -1) {
				receiveType = "ENS";
			} else if(eu24RcvMsgVO.getMsgRcvNo().indexOf(".6") != -1) {
				receiveType = "EXS";
			} else if(eu24RcvMsgVO.getMsgRcvNo().indexOf(".9") != -1 || "FROBIL".equals(orgMsgRcv)) {
				receiveType = "ILC";
			} else {
				receiveType = "MSG_RCV_NO is null.";
			}
			
			log.error("[EUR24 RECEIVE INFO][" + receiveType + "]" + "[" + eu24RcvMsgVO.getMsgRcvNo() + "]" + "[" + eu24RcvMsgVO.getMvmtRefNo()+ "]");
			
			if("EXS".equals(receiveType)){// EXS Ack 
				dbDao.addRcvLogMstOB(eu24RcvMsgVO);
				
				if(!eu24RcvMsgVO.getMvmtRefNo().equals("")) {		
					dbDao.modifyRcvLogBlMvmtRefNoOB(eu24RcvMsgVO); 
				}
				
				List<String> errList = getReceiveMultiItem(rcvMsg, "\\{ERRORS","}ERRORS");
				if (errList != null && errList.size() > 0) {
					for (int i = 0; i < errList.size(); i++) {
			        	  
						eu24RcvMsgErrVO = new Eu24RcvMsgVO();
						
						eu24RcvMsgErrVO.setEdiRcvDt(eu24RcvMsgVO.getEdiRcvDt());
						eu24RcvMsgErrVO.setEdiRcvSeq(eu24RcvMsgVO.getEdiRcvSeq());
						eu24RcvMsgErrVO.setCstmsErrId(getReceiveSingleItem     (errList.get(i), "ERR_CODE:",   "\n"));
						eu24RcvMsgErrVO.setCstmsErrMsg(getReceiveSingleItem    (errList.get(i), "ERR_MSG:",   "\n"));
						eu24RcvMsgErrVO.setCstmsErrRefNo1(getReceiveSingleItem (errList.get(i), "ERR_RFF_1:", "\n"));
						eu24RcvMsgErrVO.setCstmsErrRefNo2(getReceiveSingleItem (errList.get(i), "ERR_RFF_2:", "\n"));
						eu24RcvMsgErrVO.setCreUsrId(eu24RcvMsgVO.getCreUsrId());
						
						dbDao.addRcvLogErrOB(eu24RcvMsgErrVO);
			  		}
		        }
				
				if ("R".equals(eu24RcvMsgVO.getAckRcvStsCd()))
				{
					// Reject
					strEmlType = "03";
				}
				
			}else if("ENS".equals(receiveType)){// ENS Ack 
				
				dbDao.addRcvLogMst(eu24RcvMsgVO);
				
				log.error("[EUR24 RECEIVE INFO - (logic BEFORE) BL MRN SAVE][" + receiveType + "]" + "[" + eu24RcvMsgVO.getMsgRcvNo() + "]" + "[" + eu24RcvMsgVO.getMvmtRefNo()+ "]");
				if("A".equals(eu24RcvMsgVO.getAckKndId()) && "A".equals(eu24RcvMsgVO.getAckRcvStsCd())) {
					dbDao.modifyRcvLogBlMvmtRefNo(eu24RcvMsgVO);
				}
				log.error("[EUR24 RECEIVE INFO - (logic END) BL MRN SAVE][" + receiveType + "]" + "[" + eu24RcvMsgVO.getMsgRcvNo() + "]" + "[" + eu24RcvMsgVO.getMvmtRefNo()+ "]");
				
				List<String> errList = getReceiveMultiItem(rcvMsg, "\\{ERRORS","}ERRORS");
				
				if (errList != null && errList.size() > 0) {
					for (int i = 0; i < errList.size(); i++) {

						eu24RcvMsgErrVO = new Eu24RcvMsgVO();
						
						eu24RcvMsgErrVO.setEdiRcvDt(eu24RcvMsgVO.getEdiRcvDt());
						eu24RcvMsgErrVO.setEdiRcvSeq(eu24RcvMsgVO.getEdiRcvSeq());
						eu24RcvMsgErrVO.setCstmsErrId(getReceiveSingleItem     (errList.get(i), "ERR_CODE:",   "\n"));
						eu24RcvMsgErrVO.setCstmsErrMsg(getReceiveSingleItem    (errList.get(i), "ERR_MSG:",   "\n"));
						eu24RcvMsgErrVO.setCstmsErrRefNo1(getReceiveSingleItem (errList.get(i), "ERR_RFF_1:", "\n"));
						eu24RcvMsgErrVO.setCstmsErrRefNo2(getReceiveSingleItem (errList.get(i), "ERR_RFF_2:", "\n"));
						eu24RcvMsgErrVO.setCreUsrId(eu24RcvMsgVO.getCreUsrId());
						
						dbDao.addRcvLogErr(eu24RcvMsgErrVO);
						
						if ("351".equals(eu24RcvMsgVO.getEurCstmsAckCd()))
						{
							if ("A001".equals(eu24RcvMsgErrVO.getCstmsErrId()))
							{
								// DNL
								if ("".equals(strEmlType))	strEmlType = "04";
							}
							else if ("P001,D001,S001".indexOf(eu24RcvMsgErrVO.getCstmsErrId()) != -1)
							{
								// Advisory
								if ("".equals(strEmlType))	strEmlType = "05";
							}
						}
			  		 }
		          }

				if ("R".equals(eu24RcvMsgVO.getAckRcvStsCd()) && "".equals(strEmlType))
				{
					// Reject
					strEmlType = "03";
				}
				
				// IN OUT IF END
			}else if("ILC".equals(receiveType)){// Israel Ack 
				
				ilDbDao.addRcvLogMst(eu24RcvMsgVO);
				
				
				List<String> errList = getReceiveMultiItem(rcvMsg, "\\{ERRORS","}ERRORS");
				if(errList != null && errList.size()> 0){
			          for (int i = 0; i < errList.size(); i++) {
			        	  
						eu24RcvMsgErrVO = new Eu24RcvMsgVO();
						
						eu24RcvMsgErrVO.setEdiRcvDt(eu24RcvMsgVO.getEdiRcvDt());
						eu24RcvMsgErrVO.setEdiRcvSeq(eu24RcvMsgVO.getEdiRcvSeq());
						eu24RcvMsgErrVO.setCstmsErrId(getReceiveSingleItem     (errList.get(i), "ERR_CODE:",   "\n"));
						eu24RcvMsgErrVO.setCstmsErrMsg(getReceiveSingleItem    (errList.get(i), "ERR_MSG:",   "\n"));
						eu24RcvMsgErrVO.setCstmsErrRefNo1(getReceiveSingleItem (errList.get(i), "ERR_RFF_1:", "\n"));
						eu24RcvMsgErrVO.setCstmsErrRefNo2(getReceiveSingleItem (errList.get(i), "ERR_RFF_2:", "\n"));
						eu24RcvMsgErrVO.setCreUsrId(eu24RcvMsgVO.getCreUsrId());
						
						ilDbDao.addRcvLogErr(eu24RcvMsgErrVO);
			  		 }
		          }
				// IN OUT IF END
			} else {
				log.error("EUR24 Receive error : " + receiveType);
			}
			
			if (!"".equals(strEmlType)) 
			{
				eu24RcvMsgVO.setIbflag(receiveType);
				this.sendEml(strEmlType, eu24RcvMsgVO, rcvMsg);
			}	
		} catch (DAOException ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		
		log.info("<<<<<<<<<<EUR24 loadCstmsRcvMsg end >>>>>>>>>>>>>>>>");
		

	}	


	/**
	 * 수신결과에 따른 메일전송<br>
	 * 37 :DNL, 21 : HOLD, 44 : REJECT, 01 : RELEASE
	 * 
	 * @param strEmlType
	 * @param bkgCstmsAdvRcvLogVO
	 * @param cndCstmsBlByKeyVO
	 * @throws Exception
	 */
	private void sendEml(String strEmlType, Eu24RcvMsgVO eu24RcvMsgVO, String rcvMsg) 
	{
		try
		{
			Eur24BlForEmlVO blInfo = dbDao.searchBlForEml(eu24RcvMsgVO);
			
			TemplateMail template = new TemplateMail();
		
			String strSubject = "EU24 - ";
			
			CstmsEmlNtfcVO emlParam = new CstmsEmlNtfcVO();
			// ENS|EXS|AN|Diversion
			// "No Response|EDI Technical Failure|Rejection(Error)|DNL/DNL Removals|Hold/Hold Removals|Advisory|Missing Data
			emlParam.setCntCd("EU");
			if ("ARN".equals(blInfo.getEurEdiMsgTpId()))
			{
				emlParam.setEdiMsg("AN");
				strEmlType = "08";
			}
			else if ("DIV".equals(blInfo.getEurEdiMsgTpId()))
			{
				emlParam.setEdiMsg("Diversion");
				strEmlType = "11";
			}
			else
			{
				emlParam.setEdiMsg(blInfo.getEurEdiMsgTpId());
			}
			emlParam.setPolCd(blInfo.getPolCd());
			emlParam.setPodCd(blInfo.getPodCd());
	
			if ("03".equals(strEmlType))
			{
				emlParam.setEdiMsgTpId("Rejection(Error)");
				strSubject = strSubject + emlParam.getEdiMsg() + " Rejection : " + blInfo.getCstmsPortCd() + "(POFE)-" + blInfo.getPolCd() + "(POL)-" + blInfo.getBlNo();
				
				template.setArg("vvd",       blInfo.getVvd());
//				template.setArg("ofcNm",     blInfo.getOfcEngNm());
				template.setArg("pol",       blInfo.getPolCd());
				template.setArg("fstPort",   blInfo.getCstmsPortCd());
				template.setArg("pod",       blInfo.getPodCd());
				template.setArg("blNo",      blInfo.getBlNo());
				template.setArg("reason",    eu24RcvMsgVO.getRjctRsnRmk());
			}
			else if ("04".equals(strEmlType))
			{
				emlParam.setEdiMsgTpId("DNL/DNL Removals");
				strSubject = strSubject + emlParam.getEdiMsg() + " Do Not Load : " + blInfo.getCstmsPortCd() + "(POFE)-" + blInfo.getPolCd() + "(POL)-" + blInfo.getBlNo();
				
				template.setArg("vvd",       blInfo.getVvd());
//				template.setArg("ofcNm",     blInfo.getOfcEngNm());
				template.setArg("pol",       blInfo.getPolCd());
				template.setArg("fstPort",   blInfo.getCstmsPortCd());
				template.setArg("pod",       blInfo.getPodCd());
				template.setArg("blNo",      blInfo.getBlNo());
				template.setArg("container", getReceiveSingleItem (rcvMsg,"CNTR_NO:", "\n"));
				template.setArg("reason",     eu24RcvMsgVO.getRjctRsnRmk());
			}
			else if ("06".equals(strEmlType))
			{
				emlParam.setEdiMsgTpId("Advisory");
				strSubject = strSubject + emlParam.getEdiMsg() + " Advisory : " + blInfo.getCstmsPortCd() + "(POFE)-" + blInfo.getPolCd() + "(POL)-" + blInfo.getBlNo();
				
				template.setArg("vvd",        blInfo.getVvd());
				template.setArg("fstPort",    blInfo.getCstmsPortCd());
			}
			else if ("08".equals(strEmlType))
			{
				emlParam.setEdiMsgTpId("Rejection(Error)");
				strSubject = strSubject + emlParam.getEdiMsg() + " Rejection : " + blInfo.getVvd();
	
				template.setArg("vvd",        blInfo.getVvd());
				template.setArg("fstPort",    blInfo.getCstmsPortCd());
				template.setArg("reason",     eu24RcvMsgVO.getRjctRsnRmk());
			}
			else if ("11".equals(strEmlType))
			{
				emlParam.setEdiMsgTpId("Rejection(Error)");
				strSubject = strSubject + emlParam.getEdiMsg() + " Rejection : " + blInfo.getVvd();
				
				template.setArg("vvd",        blInfo.getVvd());
				template.setArg("oldFstPort", blInfo.getCstmsPortCd());
				template.setArg("newFstPort", blInfo.getRvisN1stClptCd());
				template.setArg("reason",     eu24RcvMsgVO.getRjctRsnRmk());
			}
			/***************************************
			 * 수신처 조회
			 ***************************************/
			CustomsCommonMgtBC comBc = new CustomsCommonMgtBCImpl();
			CstmsEmlNtfcVO eml = comBc.searchCstmsEmlNtfcInfo(emlParam);
			
			/***************************************
			 * Mail Template
			 ***************************************/
			if (eml != null)
			{
				template.setHtmlTemplate("ESM_BKG_RCV_EML_EU" + strEmlType + "T.html");
				template.setBatFlg("N");
				template.setFrom("noreply@cyberlogitec.com", "CTM EDI Monitor");
				template.setRecipient(eml.getToEmlCtnt());
				template.setCcRcvrEml(eml.getCcEmlCtnt());
				template.setSubject(strSubject);
				template.send();
			}
			
		} catch (Exception ex) {
			log.error(new ErrorHandler("BKG00707", new String[] { "EU24 Recieve Mail Send " }).getMessage());
		}
	}
	
	/**
	 * loadCstmsRcvMsg에서 사용하는 내부 메소드<br>
	 * 수신메시지에서 각항목별 정보를 추출한다.<br>
	 *  
	 * @param String src
	 * @param String prefix
	 * @param String endDelimeter
	 * @return String
	 * @throws DAOException
	 */
	public String getReceiveSingleItem(String src, String prefix, String endDelimeter){
		if(src == null) return "";

		String tmp ="";
	
		int index   = src.indexOf(prefix);
			
		if( index >= 0){
			tmp = src.substring(index+prefix.length());
			return JSPUtil.getNull(tmp.substring(0,tmp.indexOf(endDelimeter)).replace("\r",""));
		}
		
		
		
		return "";
	}
	
	/**
	 * loadCstmsRcvMsg에서 사용하는 내부 메소드<br>
	 * 수신메시지에서 각항목별 반복되는 정보를 추출한다.<br>
	 *  
	 * @param String src
	 * @param String prefix
	 * @param String surfix
	 * @return List<String>
	 * @throws DAOException
	 */
	public List<String> getReceiveMultiItem(String src, String prefix, String surfix){
		String[] srcArr = src.split(prefix);
		List<String> rlist = null;
		if(srcArr.length > 1){
			rlist = new ArrayList<String>();
			for (int i = 1; i < srcArr.length; i++) {
				rlist.add(srcArr[i].substring(0,srcArr[i].indexOf(surfix)));
			}
		}
		return rlist;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * EUR EXS Manifest OB를 신고하기 위해 FlatFile을 전송한다.
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifestOB(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException {
		StringBuffer flatFile = null;
		StringBuffer result = new StringBuffer();
		StringBuffer bfTemp = new StringBuffer();
		
		Eu24ManifestTransmitOBVO eu24ManifestTransmitOBVO = new Eu24ManifestTransmitOBVO();
	
		Eur24BlinfoVO eur24Itseq = null;
		List<Eur24BlinfoOBVO>         eur24BlinfoOBVOs         = null;
		List<Eur24BlCustListOBVO>     eur24BlCustListOBVOs     = null;
		List<Eur24BlCntrListOBVO>     eur24BlCntrListOBVOs     = null;
		List<Eur24BlDgCgoListOBVO>    eur24BlDgCgoListOBVOs    = null;
		List<Eur24BlCntrMfListOBVO>   eur24BlCntrMfListOBVOs   = null;
		List<Eur24BlCntrSealListOBVO> eur24BlCntrSealListOBVOs = null;
		List<Eur24BlCMinfoListOBVO>   eur24BlCMinfoListOBVOs   = null;
		List<Eur24BlRouteCntListVO>   eur24BlRouteCntListVOs   = null;
		
		String pSendYn = ""; 
		
		Eur24BlinfoOBVO		    blinfoOBVO    = null;
		Eur24BlCustListOBVO	    custOBVO    = null;
		Eur24BlCntrListOBVO	    cntrOBVO    = null;
		Eur24BlDgCgoListOBVO    dgCgoOBVO     = null;
		Eur24BlCntrMfListOBVO   cntrMfOBVO    = null;
		Eur24BlCntrSealListOBVO cntrSealOBVO  = null;
	
		Eur24BlCMinfoListOBVO   cMinfoOBVO  = null;
		
		BookingUtil command = new BookingUtil();
		
		// 헤더 생성용 객체
		String flatFileHeader = null;
//		String flatFileRefNo = null;
		BookingUtil bookingUtil = new BookingUtil();
		
		// 송수신처 판단
//		String sender 	= ConstantMgr.getScacCode();
//		String receiver = "EUR24";
		
		Eur24SendHistoryOBVO eur24SendHistoryOBVO = null; //이력 테이블 VO
		
		String blNo="";
		String vslCd="";
		String skdVoyNo="";
		String skdDirCd="";
		String polPort="";
		String cntrNo="";
		String updateReason = "";
		
		String[] tempStr = null;
		int tempCount = 0;
		
		try {
			if (manifestTransmitVOs.length > 0) {
				pSendYn = ((Eu24ManifestTransmitOBVO)manifestTransmitVOs[0]).getPSendYn();
				String blNumber = ""; // bl_no별 전송하기 때문에 같은 bl_no를 체크하기 위함.
				for (int q = 0; q < manifestTransmitVOs.length; q++) {
					
					flatFile = new StringBuffer();
					bfTemp.setLength(0);
					
					eu24ManifestTransmitOBVO = (Eu24ManifestTransmitOBVO) manifestTransmitVOs[q];
					
					blNo     = eu24ManifestTransmitOBVO.getBlNo();
					vslCd    = eu24ManifestTransmitOBVO.getVslCd();
					skdVoyNo = eu24ManifestTransmitOBVO.getSkdVoyNo();
					skdDirCd = eu24ManifestTransmitOBVO.getSkdDirCd();
					polPort  = eu24ManifestTransmitOBVO.getPol();
					//System.out.println("##########################updateReason0:"+eu24ManifestTransmitOBVO.getUpdateReason());
					updateReason = eu24ManifestTransmitOBVO.getUpdateReason().replaceAll("[^ a-zA-Z0-9~!\\@#\\$%\\^\\&\\*\\(\\)-_\\+=\\{}\\[\\]\\|\\\\:;,<\\.>\\/\\?]"," ");
					//System.out.println("##########################updateReason1:"+updateReason);
					
					
					log.debug("::::::::::::::::::::::::::::");
					log.debug("::::::::::::::::::::::::::::");
					log.debug("blNo:"+blNo);
					log.debug("vslCd:"+vslCd);
					log.debug("skdVoyNo:"+skdVoyNo);
					log.debug("skdDirCd:"+skdDirCd);
					log.debug("eu1stPort:"+polPort);
					log.debug("::::::::::::::::::::::::::::");
					log.debug("::::::::::::::::::::::::::::");
					
					if (blNumber.equals(blNo)) continue;// 이전 bl과 같으면 건너뛴다.
					
					blNumber = blNo;
					
					
					/************************* Bl info 조회 ***************************
					 * ENS EXS 전송 구분은 MSG_ID_CD로 구분한다.
					 * BL정보 검색 시 생성한다. 
					 * EXSDAT : 615
					 * DECODE(MSG_ID,'615','EXSDAT','EXSAMD') AS MSG_ID_CD 
					 * */
					eur24BlinfoOBVOs = dbDao.searchBlGeneralOB(blNo, vslCd, skdVoyNo, skdDirCd, polPort);
					
					if(eur24BlinfoOBVOs.size() <= 0 ) continue; //검색된것이 없으면 건너뛴다.//에러 처리
					
					blinfoOBVO = eur24BlinfoOBVOs.get(0);
					// Header 생성
					//2011.06.29 그리스 문제로 임시 수정
//					flatFileHeader = bookingUtil.searchCstmsEdiHeader(sender, receiver+polPort.substring(0, 2), blinfoOBVO.getMsgIdCd());
					flatFileHeader = bookingUtil.searchCstmsEdiHeaderNew("EU24_EXSDAT");
//			        flatFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf(ReferenceNumberGeneratorBroker.getChangedModule("BKC")));
//					flatFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("BKC"));
			        
					// flatFile 에 추가
//					flatFile.append(flatFileHeader).append("\n");
					
					CustomsCommonMgtBC comBc = new CustomsCommonMgtBCImpl(); 
					String conCrn = comBc.searchConVvd(vslCd+skdVoyNo+skdDirCd, polPort, "O");
					
					//공통정보 생성
					bfTemp.setLength(0);
					
					bfTemp.append("PRN:").append(blinfoOBVO.getPrn()).append("\n");
					bfTemp.append("CRN:").append(vslCd).append(skdVoyNo).append(skdDirCd).append("\n");
					bfTemp.append("CON_CRN:").append(conCrn).append("\n");
					bfTemp.append("LRN:").append(blNo).append("\n");
					bfTemp.append("MRN:").append(blinfoOBVO.getMrn()).append("\n");
					
					if(polPort.substring(0,2).equals("IT")){
						eur24Itseq = dbDao.searchEur24ItarySeq().get(0);
						bfTemp.append("IT_SEQ:").append(eur24Itseq.getItSeq()).append("\n");
						bfTemp.append("IT_FILE_SEQ:").append(eur24Itseq.getItFileSeq()).append("\n");
					}else{
						//bfTemp.append("IT_SEQ:\n");
						//bfTemp.append("IT_FILE_SEQ:\n");
					}
					
					bfTemp.append("TRANS_MODE:").append("1").append("\n");
					bfTemp.append("TRANS_IDENTITY:").append(blinfoOBVO.getTransIdentity()).append("\n");
					bfTemp.append("TRANS_NATION:").append(blinfoOBVO.getTransNation()).append("\n");
					bfTemp.append("VSL_NAME:").append(blinfoOBVO.getVslName()).append("\n");
					bfTemp.append("LOAD_LOC_CD:").append(blinfoOBVO.getLoadLocCd()).append("\n");
					bfTemp.append("LOAD_LOC_NAME:").append(blinfoOBVO.getLoadLocName()).append("\n");
//					bfTemp.append("LOAD_TMNL_LOC_CD:").append(blinfoOBVO.getLoadTmnlLocCd()).append("\n");                       //EXS ONLY
//					bfTemp.append("LOAD_TMNL_NAME:").append(blinfoOBVO.getLoadTmnlName()).append("\n");;                        //EXS ONLY
					bfTemp.append("LOAD_OFC_CD:").append(blinfoOBVO.getLoadOfcCd()).append("\n");
					bfTemp.append("LOAD_LOC_ETD:").append(blinfoOBVO.getLoadLocEtd()).append("\n");
					bfTemp.append("UNLOAD_LOC_CD:").append(blinfoOBVO.getUnloadLocCd()).append("\n");
					bfTemp.append("UNLOAD_LOC_NAME:").append(blinfoOBVO.getUnloadLocName()).append("\n");
					bfTemp.append("UNLOAD_LOC_ETA:").append(blinfoOBVO.getUnloadLocEta()).append("\n");
					bfTemp.append("UNLOAD_OFC_CD:").append(blinfoOBVO.getUnloadOfcCd()).append("\n");
					bfTemp.append("PREV_LOC_CD:").append(blinfoOBVO.getPrevLocCd()).append("\n");
					bfTemp.append("NEXT_LOC_CD:").append(blinfoOBVO.getNextLocCd()).append("\n");
					bfTemp.append("NEXT_LOC_NAME:").append(blinfoOBVO.getNextLocName()).append("\n");
					bfTemp.append("NEXT_LOC_ETA:").append(blinfoOBVO.getUnloadLocEta()).append("\n");
					bfTemp.append("NEXT_OFC_CD:").append("").append("\n");
					bfTemp.append("LAST_OFC_CD:").append(blinfoOBVO.getEuLstOfcCd()).append("\n"); //123
					
					bfTemp.append("{PARTY_INFO").append("\n");
					bfTemp.append("PT_TYPE:").append("CA").append("\n");
					bfTemp.append("PT_TIN:").append("").append("\n");
					bfTemp.append("PT_EORI:").append("GB577597470000").append("\n");
					bfTemp.append("PT_NAME:").append("").append("\n");
					bfTemp.append("PT_ADDRESS:").append("").append("\n");
					bfTemp.append("PT_STREET:").append("").append("\n");
					bfTemp.append("PT_CITY:").append("").append("\n");
					bfTemp.append("PT_POSTAL_CD:").append("").append("\n");
					bfTemp.append("PT_CNT_CD:").append("").append("\n");
					bfTemp.append("{PT_COM_INFO").append("\n");
					bfTemp.append("PT_CON_NAME:").append(blinfoOBVO.getCtName()).append("\n"); //? 확인
					bfTemp.append("PT_CON_CMPY:").append(blinfoOBVO.getCtPosition()).append("\n");
					bfTemp.append("PT_FAX_NO:").append(blinfoOBVO.getCtFax()).append("\n");
					bfTemp.append("PT_EM_NO:").append(blinfoOBVO.getCtEmail()).append("\n");
					bfTemp.append("PT_TEL_NO:").append(blinfoOBVO.getCtTel()).append("\n");
					bfTemp.append("}PT_COM_INFO").append("\n");
					bfTemp.append("}PARTY_INFO").append("\n");
					
					bfTemp.append("{BL_INFO").append("\n");
					bfTemp.append("BLNBR:").append(blinfoOBVO.getBlnbr()).append("\n");
					bfTemp.append("BL_TRANS_IDENTITY:").append(blinfoOBVO.getBlTransIdentity()).append("\n");
					bfTemp.append("BL_TRANS_NATION:").append(blinfoOBVO.getBlTransNation()).append("\n");
					bfTemp.append("BLPOL:").append(blinfoOBVO.getBlpol()).append("\n");
					bfTemp.append("POL_FULLNAME:").append(blinfoOBVO.getPolFullname()).append("\n");
					bfTemp.append("BLPOD:").append(blinfoOBVO.getBlpod()).append("\n");
					bfTemp.append("POD_FULLNAME:").append(blinfoOBVO.getPodFullname()).append("\n");
					bfTemp.append("POD_OFC_CD:").append(blinfoOBVO.getPodOfcCd()).append("\n");
					bfTemp.append("BLDEL:").append(blinfoOBVO.getBldel()).append("\n");
					bfTemp.append("DEL_FULLNAME:").append(blinfoOBVO.getDelFullname()).append("\n");
					bfTemp.append("BLPKG:").append(blinfoOBVO.getBlpkg()).append("\n");
					bfTemp.append("BLPKGU:").append(blinfoOBVO.getBlpkgu()).append("\n"); 
					bfTemp.append("BLMEA:").append(blinfoOBVO.getBlmea()).append("\n");
					bfTemp.append("BLMEAU:").append(blinfoOBVO.getBlmeau()).append("\n");
					bfTemp.append("BLWGT:").append(blinfoOBVO.getActWgt()).append("\n");;                               //EXS ONLY
					bfTemp.append("BLWGTU:").append(blinfoOBVO.getWgtUtCd()).append("\n");;                             //EXS ONLY
					bfTemp.append("COMMODITY:").append(blinfoOBVO.getCommodity()).append("\n");
					bfTemp.append("TRANS_DOC_NO:").append(blinfoOBVO.getTransDocNo()).append("\n");
					bfTemp.append("TRANS_DOC_NAME:").append(blinfoOBVO.getTransDocName()).append("\n");

					bfTemp.append("TRANS_DOC_LNG:").append("EN").append("\n");                						  //EXS ONLY
					bfTemp.append("CUSTOMS_LODGE_OFC:").append("").append("\n");             						  //EXS ONLY
					
					bfTemp.append("CUSSUBPLACE:").append(blinfoOBVO.getPreVslDchgYdNm()).append("\n");			//EXS ONLY/추가
					bfTemp.append("PREVIOUS_DOC_TYPE:").append(blinfoOBVO.getPreviousDocType()).append("\n");	//EXS ONLY
					bfTemp.append("PREVIOUS_DOC_REF:").append(blinfoOBVO.getPreviousDocRef()).append("\n");  	//EXS ONLY

					bfTemp.append("CUSTOMS_STATUS_CD:").append(blinfoOBVO.getCustomsStatusCd()).append("\n");
					bfTemp.append("PROCESS_INFO:").append(blinfoOBVO.getProcessInfo()).append("\n");
					bfTemp.append("PROCESS_TYPE:").append(blinfoOBVO.getProcessType()).append("\n");
					bfTemp.append("AEO_STATUS:").append(blinfoOBVO.getAeoStatus()).append("\n");
					bfTemp.append("PART_SHIPMENT:").append(blinfoOBVO.getPartShipment()).append("\n");
					bfTemp.append("CONSIGN_PLACE:").append(blinfoOBVO.getConsignPlace()).append("\n");
					bfTemp.append("DECLARE_DATE:").append(blinfoOBVO.getDeclareDate()).append("\n");
					bfTemp.append("DECLARE_LOC:").append(blinfoOBVO.getDeclareLoc()).append("\n");
					bfTemp.append("DECLARE_LOC_NAME:").append(blinfoOBVO.getDeclareLocName()).append("\n");
					bfTemp.append("PAYMENT_CD:").append(blinfoOBVO.getPaymentCd()).append("\n");
					bfTemp.append("LOCAL_CLEAR_NO:").append("").append("\n");
					bfTemp.append("TEMPORARY_STORAGE:").append("").append("\n");
					bfTemp.append("SPECIAL_REMARKS:").append(blinfoOBVO.getSpecialRemarks()).append("\n");

					int splitBytesLength = 512;				
					if(updateReason.length()>0){
						for (int i = 0; i < updateReason.length(); i += splitBytesLength) {
							bfTemp.append("{UPDATE_REASON").append("\n");
							bfTemp.append("REASON:").append(updateReason.substring(i, i + splitBytesLength > updateReason.length() ? updateReason.length(): i + splitBytesLength ) ).append("\n");//EXS ONLY
							bfTemp.append("}UPDATE_REASON").append("\n");
						}
					}else{
						bfTemp.append("{UPDATE_REASON").append("\n");
						bfTemp.append("REASON:").append("").append("\n");//EXS ONLY
						bfTemp.append("}UPDATE_REASON").append("\n");
					}
					
					
					bfTemp.append("AI_STATEMENT:").append("").append("\n");          				//EXS ONLY
					bfTemp.append("AI_STATEMENT_TXT:").append("").append("\n");          			//EXS ONLY
					
					
					flatFile.append(bfTemp);
					bfTemp.setLength(0);
					
					//bl cust정보
					eur24BlCustListOBVOs = dbDao.searchBlCustOB(blNo, vslCd, skdVoyNo, skdDirCd, polPort);
	
					for (int i = 0; i < eur24BlCustListOBVOs.size(); i++) {
						custOBVO = eur24BlCustListOBVOs.get(i);
						
						bfTemp.append("{BL_PARTY_INFO").append("\n");
						bfTemp.append("BL_PT_TYPE:").append(custOBVO.getBlPtType()).append("\n");
						bfTemp.append("BL_PT_TIN:").append(custOBVO.getBlPtTin()).append("\n");
						bfTemp.append("BL_PT_EORI:").append(custOBVO.getBlPtEori()).append("\n");
						bfTemp.append("BL_PT_NAME:").append(custOBVO.getBlPtName()).append("\n");
						bfTemp.append("BL_PT_ADDRESS:").append(custOBVO.getBlPtAddress()).append("\n");
						bfTemp.append("BL_PT_STREET:").append(custOBVO.getBlPtStreet()).append("\n");
						bfTemp.append("BL_PT_CITY:").append(custOBVO.getBlPtCity()).append("\n");
						bfTemp.append("BL_PT_POSTAL_CD:").append(custOBVO.getBlPtPostalCd()).append("\n");
						bfTemp.append("BL_PT_CNT_CD:").append(custOBVO.getBlPtCntCd()).append("\n");
						bfTemp.append("}BL_PARTY_INFO").append("\n");
	
						
					}//end for eur24BlCustListVOs
					
					flatFile.append(bfTemp);
					bfTemp.setLength(0);
					tempStr = blinfoOBVO.getDescs().split("\\$@\\$");
					for (int i = 0; i < tempStr.length; i++) {
						for (int m = 0; m < tempStr[i].length(); m += splitBytesLength) {
							bfTemp.append("{DESC").append("\n");
							bfTemp.append("DESC:").append(tempStr[i].substring(m, m + splitBytesLength > tempStr[i].length() ? tempStr[i].length(): m + splitBytesLength ) ).append("\n");
							bfTemp.append("}DESC").append("\n");
						}
					}
					
					flatFile.append(bfTemp);
					bfTemp.setLength(0);
					
					tempStr = blinfoOBVO.getMarkno().split("\\$@\\$");
					for (int i = 0; i < tempStr.length; i++) {
						for (int m = 0; m < tempStr[i].length(); m += splitBytesLength) {
							bfTemp.append("{MARK").append("\n");
							bfTemp.append("MARKNO:").append(tempStr[i].substring(m, m + splitBytesLength > tempStr[i].length() ? tempStr[i].length(): m + splitBytesLength ) ).append("\n");
							bfTemp.append("}MARK").append("\n");
						}
					}
					
					flatFile.append(bfTemp);
					bfTemp.setLength(0);
					
					//************** 컨테이너별 반복 ********************
					eur24BlCntrListOBVOs = dbDao.searchBlCntrOB(blNo, vslCd, skdVoyNo, skdDirCd, polPort);
					for (int i = 0; i < eur24BlCntrListOBVOs.size(); i++) {
						cntrOBVO = eur24BlCntrListOBVOs.get(i);
						cntrNo = cntrOBVO.getCntrNo();
	
						bfTemp.append("{CNTR_INFO").append("\n");
						bfTemp.append("CNTRNBR:").append(cntrOBVO.getCntrnbr()).append("\n");
						bfTemp.append("FM_IND:").append(cntrOBVO.getFmInd()).append("\n");
						bfTemp.append("PUNIT:").append(cntrOBVO.getPunit()).append("\n");
						bfTemp.append("PKG:").append(cntrOBVO.getPkg()).append("\n");
						bfTemp.append("CNTRWGT:").append(cntrOBVO.getCntrwgt()).append("\n");
						bfTemp.append("CNTRGWGT:").append(cntrOBVO.getCntrgwgt()).append("\n");
						bfTemp.append("CNTR_WGT_UNIT:").append(cntrOBVO.getCntrWgtUnit()).append("\n");
						bfTemp.append("CNTRTYPE:").append(cntrOBVO.getCntrtype()).append("\n");
						bfTemp.append("CMDT_DESC:").append(cntrOBVO.getCmdtDesc()).append("\n");
						bfTemp.append("CMDTCD:").append(cntrOBVO.getCmdtcd()).append("\n");
	
						
						eur24BlDgCgoListOBVOs = dbDao.searchBlDgCgoOB(blNo, vslCd, skdVoyNo, skdDirCd, polPort,cntrNo);
						for (int j = 0; j < eur24BlDgCgoListOBVOs.size(); j++) {
							dgCgoOBVO = eur24BlDgCgoListOBVOs.get(j);
							
							bfTemp.append("{CNTR_DANGER").append("\n");
							bfTemp.append("UNNBR:").append(dgCgoOBVO.getUnnbr()).append("\n");
							bfTemp.append("CLASS:").append(dgCgoOBVO.getClassCd()).append("\n");
							bfTemp.append("D_PKG:").append(dgCgoOBVO.getDPkg()).append("\n");
							bfTemp.append("D_PKGUNIT:").append(dgCgoOBVO.getDPkgunit()).append("\n");
							bfTemp.append("GWGT:").append(dgCgoOBVO.getGwgt()).append("\n");
							bfTemp.append("GWGT_UNIT:").append(dgCgoOBVO.getGwgtUnit()).append("\n");
							bfTemp.append("MEA:").append(dgCgoOBVO.getMea()).append("\n");
							bfTemp.append("MEA_UNIT:").append(dgCgoOBVO.getMeaUnit()).append("\n");
							bfTemp.append("}CNTR_DANGER").append("\n");
	
						}//end for eur24BlDgCgoListVOs
						
						
						eur24BlCntrMfListOBVOs = dbDao.searchBlCntrMfDescOB(blNo, vslCd, skdVoyNo, skdDirCd, polPort,cntrNo);
						for (int j = 0; j < eur24BlCntrMfListOBVOs.size(); j++) {
							cntrMfOBVO = eur24BlCntrMfListOBVOs.get(j);
							bfTemp.append("{CNTR_DESC").append("\n");
							bfTemp.append("D_PUNIT:").append(cntrMfOBVO.getDPunit()).append("\n");
							bfTemp.append("D_PKG:").append(cntrMfOBVO.getDPkg()).append("\n");
							bfTemp.append("D_WGT:").append(cntrMfOBVO.getDWgt()).append("\n");
							bfTemp.append("D_MEAS:").append(cntrMfOBVO.getDMeas()).append("\n");
							bfTemp.append("D_DESC:").append(cntrMfOBVO.getDDesc()).append("\n");
							bfTemp.append("{CUS_MARK").append("\n");
							bfTemp.append("D_MARK:").append(cntrMfOBVO.getDMark()).append("\n");
							bfTemp.append("}CUS_MARK").append("\n");
							bfTemp.append("}CNTR_DESC").append("\n");
	
							
						}//end for eur24BlCntrMfListVOs
						
						eur24BlCntrSealListOBVOs = dbDao.searchBlCntrSealNoOB(blNo, vslCd, skdVoyNo, skdDirCd, polPort,cntrNo);
						for (int j = 0; j < eur24BlCntrSealListOBVOs.size(); j++) {
							cntrSealOBVO = eur24BlCntrSealListOBVOs.get(j);
							bfTemp.append("{MULTI_SEAL").append("\n");
							bfTemp.append("SEAL_TYPE:").append(cntrSealOBVO.getSealType()).append("\n");
							bfTemp.append("SEAL_NBR:").append(cntrSealOBVO.getSealNbr()).append("\n");
							bfTemp.append("}MULTI_SEAL").append("\n");
						}//end for eur24BlCntrSealListVOs
						
						bfTemp.append("}CNTR_INFO").append("\n");
						
	
						
						flatFile.append(bfTemp);
						bfTemp.setLength(0);
						
					}//end for eur24BlCntrListVOs
					
					//************** 컨테이너별 반복 ********************끝
	
					
					
					//bl CMinfo정보
					eur24BlCMinfoListOBVOs = dbDao.searchBlCMinfoOB(blNo, vslCd, skdVoyNo, skdDirCd, polPort,blinfoOBVO.getMsgIdCd());
					for (int i = 0; i < eur24BlCMinfoListOBVOs.size(); i++) {
						cMinfoOBVO = eur24BlCMinfoListOBVOs.get(i);
						bfTemp.append("{CM_INFO").append("\n");
						
						bfTemp.append("CM_FLAG:").append("").append("\n");
						
						bfTemp.append("GOODS_ITEM_NO:").append(cMinfoOBVO.getGoodsItemNo()).append("\n");
						
	
						bfTemp.append("PIECE_COUNT:").append(cMinfoOBVO.getPieceCount()).append("\n");
						bfTemp.append("PKG_COUNT:").append(cMinfoOBVO.getPkgCount()).append("\n");
						bfTemp.append("PKG_TYPE:").append(cMinfoOBVO.getPkgType()).append("\n");
						bfTemp.append("GOODS_DESC:").append(cMinfoOBVO.getGoodsDesc()).append("\n");
						bfTemp.append("ITEM_GROSS_WGT:").append(cMinfoOBVO.getItemGrossWgt()).append("\n");
						bfTemp.append("TARIFF_CD:").append(cMinfoOBVO.getTariffCd()).append("\n");
						bfTemp.append("CUSTOMS_PROC_CD:").append("").append("\n");						// EXS ONLY
						bfTemp.append("UNDG_NO:").append(cMinfoOBVO.getUndgNo()).append("\n");
						bfTemp.append("HANDLE_CD:").append(cMinfoOBVO.getHandleCd()).append("\n");
						bfTemp.append("HANDLE_INFO:").append(cMinfoOBVO.getHandleInfo()).append("\n");
						bfTemp.append("{CM_CNTR").append("\n");
						bfTemp.append("CM_CNTR_NO:").append(cMinfoOBVO.getCmCntrNo()).append("\n");
						bfTemp.append("CM_CNTR_PKG:").append(cMinfoOBVO.getCmCntrPkg()).append("\n");
						bfTemp.append("CM_SHIP_MARK:").append(cMinfoOBVO.getCmShipMark()).append("\n");
						bfTemp.append("}CM_CNTR").append("\n");
						bfTemp.append("}CM_INFO").append("\n");		
						
					}//end for eur24BlCMinfoListVOs
					
					flatFile.append(bfTemp);
					bfTemp.setLength(0);
					
					//bl Route 정보
					eur24BlRouteCntListVOs = dbDao.searchBlRouteCountryOB(blNo, vslCd, skdVoyNo, skdDirCd);
					for (int i = 0; i < eur24BlRouteCntListVOs.size(); i++) {
						bfTemp.append("{ROUTE_COUNTRY").append("\n");
						bfTemp.append("COUNTRY:").append(eur24BlRouteCntListVOs.get(i).getRouteCnt()).append("\n");
						bfTemp.append("}ROUTE_COUNTRY").append("\n");						
					}//end for eur24BlRouteCntListVOs
					
					flatFile.append(bfTemp);
					flatFile.append("}BL_INFO");
				
					FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
					//pSendYn = "N";//개발 중이므로 전송 하지 않는다.
					if(pSendYn.equals("Y")){
						
						eur24SendHistoryOBVO = new Eur24SendHistoryOBVO();
						
						eur24SendHistoryOBVO.setMsgSndNo(blinfoOBVO.getPrn());
						eur24SendHistoryOBVO.setEurEdiMsgTpId("EXS");
						eur24SendHistoryOBVO.setSndUsrId(account.getUsr_id());
						
						if("615".equals(blinfoOBVO.getMsgId()))
							eur24SendHistoryOBVO.setMsgFuncId("O");
						else
							eur24SendHistoryOBVO.setMsgFuncId("U");
						
						eur24SendHistoryOBVO.setVslCd(vslCd);
						eur24SendHistoryOBVO.setSkdVoyNo(skdVoyNo);
						eur24SendHistoryOBVO.setSkdDirCd(skdDirCd);
						eur24SendHistoryOBVO.setBlNo(blNo);
						eur24SendHistoryOBVO.setCstmsPortCd(polPort);
						eur24SendHistoryOBVO.setEdiSndMsgCtnt(flatFile.toString());
						eur24SendHistoryOBVO.setCreUsrId(account.getUsr_id());
						eur24SendHistoryOBVO.setSndOfcCd(account.getOfc_cd());
						
						dbDao.addSendLogOB(eur24SendHistoryOBVO) ;
						//ENS에서 네덜란드를 위해 했으나 EXS에는 할 필요 없음. 일단 만들어 놓고 필요시 쿼리를 수정한다. 2011.07.12
						//dbDao.addBlCntrMFSndHistOB(eur24SendHistoryVO) ;
						dbDao.modifyEU24BlMsgSndNoOB(eur24SendHistoryOBVO) ;

						String rxpFlatFile = flatFile.toString().replaceAll("\n", "^^^").replaceAll("\\s+", " ").replaceAll("\\^\\^\\^", "\n"); // "space를 2개이상  전송하는 것을 방지하기 위한 로직
																																				//  정규식을 사용해서 우선 엔터를 ^^^으로  치환 후 스페이스 1개이상을 1개로 변환 후 ^^^을 엔터로 치환
						StringBuffer sFlatFile = new StringBuffer();
						sFlatFile.append(flatFileHeader).append("\n");
						sFlatFile.append(rxpFlatFile); 

						SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
						sendFlatFileVO.setFlatFile(sFlatFile.toString());
						sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_EUR24.IBMMQ.QUEUE"));
						log.debug(sFlatFile.toString()+"%%%%%%%%%%%%%%%%%%");
						//임시로 주석 처리.
						flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

						if (flatFileAckVO.getAckStsCd().equals("E"))
							throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
						
						log.debug("\n\n\n\n\n\n\n#################################################### file Send Success ##############################"+pSendYn);
					}
					
					log.debug("flatFile:\n\n");
					log.debug(flatFile.toString());
					log.debug("flatFile:\n\n");
					
					tempCount++;
					
					result.append(flatFile.toString()).append("\n\n");
				}//end for param manifestTransmitVOs 
			}
			
			log.debug("####################################################\n\n\n\n\n total cnt :"+ tempCount);
			log.debug("####################################################\n\n\n\n\n FLAT FILE: \n\n"+ result.toString());
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		
		return result.toString(); 
	}
	

	/**
	 * EDI transmission flat file 작성 (Finland IE347) <br>
	 * 
	 * @param util
	 * @param eurVo
	 * @return
	 * @throws EventException
	 */
	public String makeFlatFileForFiArrivalNotice(BookingUtil util, Eur24VesselArrivalVO eurVo) throws EventException{
		String header;
		StringBuilder flatFile = new StringBuilder();
		
		String blNo = "";
		String vslCd = "";
		String skdVoyNo = "";
		String skdDirCd = "";
		String cstmsPortCd = "";
		
		List<Eur24BlinfoVO> eur24BlinfoVOs = null;
		List<Eur24BlCMinfoListVO> eur24BlCMinfoListVOs = null;
		
		Eur24BlinfoVO blinfoVO = null;
		Eur24BlCMinfoListVO cMinfoVO = null;
		
		try {
			
			CustomsCommonMgtBC comBc = new CustomsCommonMgtBCImpl(); 
			String conCrn = comBc.searchConVvd(eurVo.getVslCd()+eurVo.getSkdVoyNo()+eurVo.getSkdDirCd(),  eurVo.getCstmsPortCd(), "I");
			
			// FlatFile Header를 생성한다.
//			header = util.searchCstmsEdiHeader(ConstantMgr.getScacCode(), "EUR24" + eurVo.getTransNation(), "ARNENT");
			header = util.searchCstmsEdiHeaderNew("EU24_ARRENT");
			flatFile.append(header).append("\n");
			flatFile.append("DOC_NO:").append(eurVo.getDocNo().replace("\r", "").replace("\n", "")).append("\n");
			flatFile.append("CUSTOMS_REF:").append(eurVo.getCustomsRef()).append("\n");
			flatFile.append("CALL_REF_NO:").append(eurVo.getCallRefNo()).append("\n");
			flatFile.append("TRADE_REF_NO:").append(eurVo.getTradeRefNo()).append("\n");
			flatFile.append("PURPOSE_OF_CALL:").append(eurVo.getPurposeOfCall()).append("\n");
			flatFile.append("CRN:").append(eurVo.getCrn()).append("\n");
			flatFile.append("CON_CRN:").append(conCrn).append("\n");
			flatFile.append("TRANS_MODE:").append(eurVo.getTransMode()).append("\n");
			flatFile.append("TRANS_TYPE_CD:").append(eurVo.getTransTypeCd()).append("\n");
			flatFile.append("LLOYD_NO:").append(eurVo.getLloydNo()).append("\n");
			flatFile.append("VSL_NAME:").append(eurVo.getVslName()).append("\n");
			flatFile.append("TRANS_NATION:").append(eurVo.getTransNation()).append("\n");
			flatFile.append("ETA:").append(eurVo.getEta()).append("\n");
			flatFile.append("ETA_EU:").append(eurVo.getEtaEu()).append("\n");
			flatFile.append("ATA:").append(eurVo.getAta()).append("\n");
			flatFile.append("ETD:").append(eurVo.getEtd()).append("\n");
			flatFile.append("DTM_PRESENTATION:").append(eurVo.getDtmPresentation()).append("\n");
			flatFile.append("FIRST_OFFICE:").append(eurVo.getFirstOffice()).append("\n");
			flatFile.append("POSITION_OF_SHIP:").append(eurVo.getPositionOfShip()).append("\n");
			flatFile.append("PREV_PORT:").append(eurVo.getPrevPort()).append("\n");
			flatFile.append("ARRIVAL_PORT:").append(eurVo.getArrivalPort()).append("\n");
			flatFile.append("NEXT_PORT:").append(eurVo.getNextPort()).append("\n");
			flatFile.append("CERT_REG_NO:").append(eurVo.getCertRegNo()).append("\n");
			flatFile.append("CERT_REG_DT:").append(eurVo.getCertRegDt()).append("\n");
			flatFile.append("CERT_REG_LOC:").append(eurVo.getCertRegLoc()).append("\n");
			flatFile.append("GROSS_TON:").append(eurVo.getGrossTon()).append("\n");
			flatFile.append("NET_TON:").append(eurVo.getNetTon()).append("\n");
			flatFile.append("NO_OF_CREW:").append(eurVo.getNoOfCrew()).append("\n");
			flatFile.append("NO_OF_PASSENGER:").append(eurVo.getNoOfPassenger()).append("\n");
			flatFile.append("ITEM_COUNT_TOTAL:").append(eurVo.getItemCountTotal()).append("\n");
			flatFile.append("PKG_COUNT_TOTAL:").append(eurVo.getPkgCountTotal()).append("\n");
			flatFile.append("UNLOAD_IND:").append(eurVo.getUnloadInd()).append("\n");
			flatFile.append("UNLOAD_LOC:").append(eurVo.getUnloadLoc()).append("\n");
			flatFile.append("{PARTY_INFO").append("\n");
			flatFile.append("PT_TYPE:").append("\n");
			flatFile.append("PT_EORI:").append("\n");
			flatFile.append("PT_NAME:").append("\n");
			flatFile.append("PT_ADDRESS:").append("\n");
			flatFile.append("PT_STREET:").append("\n");
			flatFile.append("PT_CITY:").append("\n");
			flatFile.append("PT_POSTAL_CD:").append("\n");
			flatFile.append("PT_CNT_CD:").append("\n");
			flatFile.append("{PT_COM_INFO").append("\n");
			flatFile.append("PT_CON_NAME:").append(eurVo.getPtConName()).append("\n");
			flatFile.append("PT_CON_CMPY:").append(eurVo.getPtConCmpy()).append("\n");
			flatFile.append("PT_FAX_NO:").append(eurVo.getPtFaxNo()).append("\n");
			flatFile.append("PT_EM_NO:").append(eurVo.getPtEmNo()).append("\n");
			flatFile.append("PT_TEL_NO:").append(eurVo.getPtTelNo()).append("\n");
			flatFile.append("}PT_COM_INFO").append("\n");
			flatFile.append("}PARTY_INFO").append("\n");
//			flatFile.append("{ROUTE_PORT").append("\n");
//			flatFile.append("ROUTING_PORT:DEHAM").append("\n");
//			flatFile.append("}ROUTE_PORT").append("\n");
//			flatFile.append("{ROUTE_PORT").append("\n");
//			flatFile.append("ROUTING_PORT:NLRTM").append("\n");
//			flatFile.append("}ROUTE_PORT").append("\n");
			
			/*
			 * blVO = VVD 로 BL 리스트를 조회 및 FF 만들기
			 * 
			 */
			vslCd = eurVo.getVslCd();
			skdVoyNo = eurVo.getSkdVoyNo();
			skdDirCd = eurVo.getSkdDirCd();
			cstmsPortCd = eurVo.getCstmsPortCd();
			
			eur24BlinfoVOs = dbDao.searchVesselArrivalBlInfo(vslCd, skdVoyNo, skdDirCd, cstmsPortCd);
			for (int i = 0; i < eur24BlinfoVOs.size(); i++) {
				
				blinfoVO = eur24BlinfoVOs.get(i);
				blNo = blinfoVO.getBlNo();
	
				flatFile.append("{BL_INFO").append("\n");
				flatFile.append("BLNBR:").append(blNo).append("\n");
				flatFile.append("MRN:").append(blinfoVO.getMvmtRefNo()).append("\n");
				flatFile.append("BLPOL:").append("\n");
				flatFile.append("BLPOD:").append("\n");
				flatFile.append("BLDEL:").append("\n");
				flatFile.append("BL_ENTRY_LOC:").append("\n");
		
				/*
				 * blVO 수 만큼 루프를 돌면서 CM 정보 조회 및 FF 만들기
				 */
				eur24BlCMinfoListVOs = dbDao.searchVesselArrivalCMInfo(blNo, vslCd, skdVoyNo, skdDirCd, cstmsPortCd);
				for (int j = 0; j < eur24BlCMinfoListVOs.size(); j++) {
					
					cMinfoVO = eur24BlCMinfoListVOs.get(j);
					
					flatFile.append("{CM_INFO").append("\n");
					flatFile.append("GOODS_ITEM_NO:").append(cMinfoVO.getGoodsItemNo()).append("\n");
					flatFile.append("PIECE_COUNT:").append("\n");
					flatFile.append("PKG_COUNT:").append("\n");
					flatFile.append("PKG_TYPE:").append("\n");
					flatFile.append("GOODS_DESC:").append("\n");
					flatFile.append("ITEM_GROSS_WGT:").append("\n");
					flatFile.append("TARIFF_CD:").append("\n");
					flatFile.append("UNDG_NO:").append("\n");
					flatFile.append("HANDLE_CD:").append("\n");
					flatFile.append("HANDLE_INFO:").append("\n");
					flatFile.append("{CM_CNTR").append("\n");
					flatFile.append("CM_CNTR_NO:").append(cMinfoVO.getCntrNo()).append("\n");
					flatFile.append("CM_CNTR_PKG:").append("\n");
					flatFile.append("CM_SHIP_MARK:").append("\n");
					flatFile.append("}CM_CNTR").append("\n");
					flatFile.append("}CM_INFO").append("\n");
				} // end(j)
				
				flatFile.append("}BL_INFO").append("\n");
			
			} // end (i)
		} catch (DAOException ex) {
			log.error("DAOException : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		log.debug("####################################################\n\n\n\n\n transmitManifest END!");
		return flatFile.toString();
	}	
	
	/**
	 * EDI transmission flat file 작성 (Finland IE347) <br>
	 * 
	 * @param  BookingUtil util
	 * @param  Eur24VesselArrivalVO eurVo
     * @param  Eur24VesselFIArrivalNoticeDetailVO anFITransmitVO
	 * @return String
	 * @throws EventException
	 */
	public String makeFlatFileArrivalNoticeFi(BookingUtil util, Eur24VesselArrivalVO eurVo, Eur24VesselFIArrivalNoticeDetailVO anFITransmitVO) throws EventException{
		log.debug("________________________________________finland_____________________________________");
		String header;
		StringBuilder flatFile = new StringBuilder();
		
		//String blNo = "";
		String vslCd = "";
		String skdVoyNo = "";
		String skdDirCd = "";
		String cstmsPortCd = "";
		
		List<Eur24BlinfoVO> eur24BlinfoVOs = null;
		List<Eur24BlCMinfoListVO> eur24BlCMinfoListVOs = null;
		
		Eur24BlinfoVO blinfoVO = null;
		Eur24BlCMinfoListVO cMinfoVO = null;
		
		try {
			
			// FlatFile Header를 생성한다.
//			header = util.searchCstmsEdiHeader(ConstantMgr.getScacCode(), "EUR24" + eurVo.getTransNation(), "ARNENT");
			header = util.searchCstmsEdiHeaderNew("EU24_ARRENT");
			
			flatFile.append(header).append("\n");
			flatFile.append("DOC_NO:").append(eurVo.getDocNo().replace("\r", "").replace("\n", "")).append("\n");
			flatFile.append("CUSTOMS_REF:").append(eurVo.getCustomsRef()).append("\n");
			flatFile.append("CALL_REF_NO:").append(eurVo.getCallRefNo()).append("\n");
			flatFile.append("TRADE_REF_NO:").append(eurVo.getTradeRefNo()).append("\n");
			flatFile.append("PURPOSE_OF_CALL:").append(eurVo.getPurposeOfCall()).append("\n");
			flatFile.append("CRN:").append(eurVo.getCrn()).append("\n");
			flatFile.append("TRANS_MODE:").append(eurVo.getTransMode()).append("\n");
			flatFile.append("TRANS_TYPE_CD:").append(eurVo.getTransTypeCd()).append("\n");
			flatFile.append("LLOYD_NO:").append(eurVo.getLloydNo()).append("\n");
			flatFile.append("VSL_NAME:").append(eurVo.getVslName()).append("\n");
			flatFile.append("TRANS_NATION:").append(eurVo.getTransNation()).append("\n");
			flatFile.append("ETA:").append(eurVo.getEta()).append("\n");
			flatFile.append("ETA_EU:").append(eurVo.getEtaEu()).append("\n");
			flatFile.append("ATA:").append(eurVo.getAta()).append("\n");
			flatFile.append("ETD:").append(eurVo.getEtd()).append("\n");
			flatFile.append("DTM_PRESENTATION:").append(eurVo.getDtmPresentation()).append("\n");
			flatFile.append("FIRST_OFFICE:").append(eurVo.getFirstOffice()).append("\n");
			flatFile.append("POSITION_OF_SHIP:").append(eurVo.getPositionOfShip()).append("\n");
			flatFile.append("PREV_PORT:").append(eurVo.getPrevPort()).append("\n");
			flatFile.append("ARRIVAL_PORT:").append(eurVo.getArrivalPort()).append("\n");
			flatFile.append("NEXT_PORT:").append(eurVo.getNextPort()).append("\n");
			flatFile.append("CERT_REG_NO:").append(eurVo.getCertRegNo()).append("\n");
			flatFile.append("CERT_REG_DT:").append(eurVo.getCertRegDt()).append("\n");
			flatFile.append("CERT_REG_LOC:").append(eurVo.getCertRegLoc()).append("\n");
			flatFile.append("GROSS_TON:").append(eurVo.getGrossTon()).append("\n");
			flatFile.append("NET_TON:").append(eurVo.getNetTon()).append("\n");
			flatFile.append("NO_OF_CREW:").append(eurVo.getNoOfCrew()).append("\n");
			flatFile.append("NO_OF_PASSENGER:").append(eurVo.getNoOfPassenger()).append("\n");
			flatFile.append("ITEM_COUNT_TOTAL:").append(eurVo.getItemCountTotal()).append("\n");
			flatFile.append("PKG_COUNT_TOTAL:").append(eurVo.getPkgCountTotal()).append("\n");
			flatFile.append("UNLOAD_IND:").append(eurVo.getUnloadInd()).append("\n");
			flatFile.append("UNLOAD_LOC:").append(eurVo.getUnloadLoc()).append("\n");
			flatFile.append("{PARTY_INFO").append("\n");
			flatFile.append("PT_TYPE:").append("\n");
			flatFile.append("PT_EORI:").append("\n");
			flatFile.append("PT_NAME:").append("\n");
			flatFile.append("PT_ADDRESS:").append("\n");
			flatFile.append("PT_STREET:").append("\n");
			flatFile.append("PT_CITY:SEOUL").append("\n");
			flatFile.append("PT_POSTAL_CD:").append("\n");
			flatFile.append("PT_CNT_CD:KR").append("\n");
			flatFile.append("{PT_COM_INFO").append("\n");
			flatFile.append("PT_CON_NAME:").append(eurVo.getPtConName()).append("\n");
			flatFile.append("PT_CON_CMPY:").append(eurVo.getPtConCmpy()).append("\n");
			flatFile.append("PT_FAX_NO:").append(eurVo.getPtFaxNo()).append("\n");
			flatFile.append("PT_EM_NO:").append(eurVo.getPtEmNo()).append("\n");
			flatFile.append("PT_TEL_NO:").append(eurVo.getPtTelNo()).append("\n");
			flatFile.append("}PT_COM_INFO").append("\n");
			flatFile.append("}PARTY_INFO").append("\n");
//			flatFile.append("{ROUTE_PORT").append("\n");
//			flatFile.append("ROUTING_PORT:DEHAM").append("\n");
//			flatFile.append("}ROUTE_PORT").append("\n");
//			flatFile.append("{ROUTE_PORT").append("\n");
//			flatFile.append("ROUTING_PORT:NLRTM").append("\n");
//			flatFile.append("}ROUTE_PORT").append("\n");
			
			/*
			 * blVO = VVD 로 BL 리스트를 조회 및 FF 만들기
			 * 
			 */
			vslCd = eurVo.getVslCd();
			skdVoyNo = eurVo.getSkdVoyNo();
			skdDirCd = eurVo.getSkdDirCd();
			cstmsPortCd = eurVo.getCstmsPortCd();
			//cstmsPortCd = anFITransmitVO.getPod();
			//blNo = anFITransmitVO.getBlNo();
			
			eur24BlinfoVOs = dbDao.searchVesselFIArrivalBlInfo(vslCd, skdVoyNo, skdDirCd, cstmsPortCd, anFITransmitVO.getBlNo());
			//eur24BlinfoVOs = dbDao.searchVesselArrivalBlInfo(vslCd, skdVoyNo, skdDirCd,cstmsPortCd );
			
			for (int i = 0; i < eur24BlinfoVOs.size(); i++) {
				
				blinfoVO = eur24BlinfoVOs.get(i);
				//blNo = blinfoVO.getBlNo();
	
				flatFile.append("{BL_INFO").append("\n");
				flatFile.append("BLNBR:").append(anFITransmitVO.getBlNo()).append("\n");
				flatFile.append("MRN:").append(blinfoVO.getMvmtRefNo()).append("\n");
				flatFile.append("BLPOL:").append("\n");
				flatFile.append("BLPOD:").append("\n");
				flatFile.append("BLDEL:").append("\n");
				flatFile.append("BL_ENTRY_LOC:").append("\n");
		
				/*
				 * blVO 수 만큼 루프를 돌면서 CM 정보 조회 및 FF 만들기
				 */
				eur24BlCMinfoListVOs = dbDao.searchVesselArrivalCMInfo(anFITransmitVO.getBlNo(), vslCd, skdVoyNo, skdDirCd, cstmsPortCd);
				for (int j = 0; j < eur24BlCMinfoListVOs.size(); j++) {
					
					cMinfoVO = eur24BlCMinfoListVOs.get(j);
					
					flatFile.append("{CM_INFO").append("\n");
					flatFile.append("GOODS_ITEM_NO:").append(cMinfoVO.getGoodsItemNo()).append("\n");
					flatFile.append("PIECE_COUNT:").append("\n");
					flatFile.append("PKG_COUNT:").append("\n");
					flatFile.append("PKG_TYPE:").append("\n");
					flatFile.append("GOODS_DESC:").append("\n");
					flatFile.append("ITEM_GROSS_WGT:").append("\n");
					flatFile.append("TARIFF_CD:").append("\n");
					flatFile.append("UNDG_NO:").append("\n");
					flatFile.append("HANDLE_CD:").append("\n");
					flatFile.append("HANDLE_INFO:").append("\n");
					flatFile.append("{CM_CNTR").append("\n");
					flatFile.append("CM_CNTR_NO:").append(cMinfoVO.getCntrNo()).append("\n");
					flatFile.append("CM_CNTR_PKG:").append("\n");
					flatFile.append("CM_SHIP_MARK:").append("\n");
					flatFile.append("}CM_CNTR").append("\n");
					flatFile.append("}CM_INFO").append("\n");
				} // end(j)
				
				flatFile.append("}BL_INFO").append("\n");
			
			} // end (i)
		} catch (DAOException ex) {
			log.error("DAOException : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		log.debug("####################################################\n\n\n\n\n transmitManifest END!");
		return flatFile.toString();
	}
	
	/**
	 * EDI 오류
	 * @param msg
	 * @throws Exception
	 */
	public void loadEdiErr(String msg) throws Exception
	{
		String orgMsgKey = getReceiveSingleItem (msg, "ORG_MSG_KEY:", "\n");
		String errMsg    = getReceiveSingleItem (msg, "MSG:", "\n");
		// BL조회
		Eur24BlForEmlVO bl = dbDao.searchBlForEdiErr(orgMsgKey);
		
		if (bl != null)
		{
			CstmsEmlNtfcVO emlParam = new CstmsEmlNtfcVO();
			emlParam.setCntCd("EU");
			emlParam.setEdiMsg(bl.getEurEdiMsgTpId());
			emlParam.setEdiMsgTpId("EDI Technical Failure");
			emlParam.setPolCd(bl.getPolCd());
			emlParam.setPodCd(bl.getPodCd());
	
			/***************************************
			 * 수신처 조회
			 ***************************************/
			CustomsCommonMgtBC comBc = new CustomsCommonMgtBCImpl();
			CstmsEmlNtfcVO eml = comBc.searchCstmsEmlNtfcInfo(emlParam);

			if (eml != null && eml.getToEmlCtnt() != null)
			{
				TemplateMail template = new TemplateMail();
				if ("AN".equals(bl.getEurEdiMsgTpId()))
				{
					template.setHtmlTemplate("ESM_BKG_RCV_EML_EU07T.html");
					template.setSubject("EU24 - AN Technical Failure : " + bl.getPodCd() + "(POD)-" + bl.getVvd());
		
					template.setArg("vvd",    bl.getVvd());
					template.setArg("pod",    bl.getPodCd());
					template.setArg("reason", errMsg);
				}
				else if ("Diversion".equals(bl.getEurEdiMsgTpId()))
				{
					template.setHtmlTemplate("ESM_BKG_RCV_EML_EU10T.html");
					template.setSubject("EU24 - Diversion Technical Failure VVD : " + bl.getVvd());
		
					template.setArg("vvd",        bl.getVvd());
					template.setArg("oldFstPort", bl.getCstmsPortCd());
					template.setArg("newFstPort", bl.getRvisN1stClptCd());
					template.setArg("reason",     errMsg);
				}
				else
				{
					template.setHtmlTemplate("ESM_BKG_RCV_EML_EU02T.html");
					template.setSubject("EU24 - " + bl.getEurEdiMsgTpId() + " Technical Failure BL Number : " + bl.getBlNo());
					
					template.setArg("blNo",   bl.getBlNo());
					template.setArg("reason", errMsg);
				}
				
				template.setBatFlg("N");
				template.setFrom("noreply@cyberlogitec.com", "CTM EDI Monitor");
				template.setRecipient(eml.getToEmlCtnt());
				template.setCcRcvrEml(eml.getCcEmlCtnt());
				
				template.send();
			}
		}
	}
}//end class=======