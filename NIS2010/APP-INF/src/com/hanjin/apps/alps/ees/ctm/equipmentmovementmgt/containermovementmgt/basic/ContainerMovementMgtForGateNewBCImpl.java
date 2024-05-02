/**
 * Copyright(c) 2009 CyberLogitec
 * @FileName : ContainerMovementMgtForGateNewBCImpl.java
 * @FileTitle : GATENEW Business Logic Basic Command implementation
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2009.07.06
 * @LastModifier : 김상수
 * @LastVersion : 1.0
 * 2009.07.06 김상수 1.0 Creation
 * 2010.09.30 이석준 [CHM-201006067-01] Split 01-[MDM]Location 평택(KRPYT->KRPTK) 정제 관련 작업 요청
 *                   (ID Code 생성시에 신규 코드인 KRPTK 역시 생성될수 있도록 조건 추가)
 * 2010.10.18 김상수 [CHM-201006479-01] B.Bulk화물 Movement를 Logic 변경(MT->Full)
 *                   - 현재 B.Bulk화물의 컨테이너는 MT로 VL 처리되기 때문에 FULL VL이 아니라
 *                     EMPTY VL without bkg으로 VL 생성되고 있는 건을 Mt->Full로 변경해서
 *                     자동생성 로직이 탈수있도록 소스수정
 *                   - 현재 자동생성시 이전 상태가 MT이고 현재는 full VL이므로 업무상 error로
 *                     분류되는 로직을 MT이고 Full VL이면 OP,OC가 자동생성되게 변경.
 *                     그러나 BreakBulk도 아니면서 OP,OC없이 생성된 full VL도 있을 수 있으므로
 *                     이를 막기위해 bkg cntr테이블의 BB column을 다시 check하는 로직추가
 * 2011-02-25 박희동 
 *            1. Booking Split 이 되면 B1 => B2 + B3 이 되고 B1은 Cancel상태가 됨
 *            2. Booking 담당자가 Booking Container 테이블에 연결을 못한 경우가 있음    
 *            3. 위의 경우 OP 인데 Booking split no를 찾을 수 없어 Error처리 되었으나 TN으로 바꿔서 정상 진행하도록 함      
 * 2013-06-19 강환 [CHM-201325165] EUR 지역 ID/EN 생성 logic  변경 (AT/CH/DK추가)   
 * 2014-01-22 강 환  [CHM-201428329] Time gap between event and receiving date 변경(5 days-10days). EDI error msg Batch시행 횟수(2회-5회)           
 * 2014-01-27 강 환  [CHM-201328274] EUR지역 SO를 통한 ID,ENTN 판정 logic(추가) 
 * 2014-02-07 강 환 [CHM-201428467] Asis지역 IB 화물 ID_EN(TN)에 대한 SO 확인 logic 추가
 * 2015.11.19 김상현 [CHM-201538845] CP의 Domestic Bkg을 Next mvmt에 Copy
 *                   - 이전 단계가 CP이고 현재 값에 booking no.가 invalid이면 이전 단계 booking no.를 복사해서 Domestic booking logic 처리하도록 수정.
 * 2016.02.12 Sang-Hyun Kim [CHM-201639830] CTM: Domestic MVMT CM 자동생성 logic 변경
 * 2016.06.02 김상현 [CHM-201641731] VGM 항목 추가
 * 2016.07.29 김상현 [CHM-201642322] Insert/Delete 처리시, 화면에 보이는 데이터가 최신 데이터인지 체크하는 로직 추가
 */
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.basic;

import java.text.ParseException;
import java.util.ArrayList;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration.ContainerMovementMgtDBDAO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration.ContainerMovementMgtForGateNewDBDAO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CtmVrfdGrsMassEdiMsgVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.FlatFileForGateNewVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIMovementListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.syscommon.common.table.CtmMvmtEdiBkgVO;

/**
 * ALPS-EquipmentMovementMgt Business Logic Basic Command implementation<br>
 * - ALPS-EquipmentMovementMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author KIM, Sang Soo
 * @see    Ees_ctm_0000EventResponse(테스트 화면), ContainerMovementMgtForGateNewBC 각 DAO 클래스 참조
 * @see    UbizhjsAlpsCtmEqmvmt EventResponse(MQ메세지 INBOUND), ContainerMovementMgtForGateNewBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ContainerMovementMgtForGateNewBCImpl extends BasicCommandSupport implements ContainerMovementMgtForGateNewBC {

	// Database Access Object
	private transient ContainerMovementMgtForGateNewDBDAO dbDao = null;

	/**
	 * ContainerMovementMgtForGateNewBCImpl 객체 생성<br>
	 * ContainerMovementValidationBC를 생성한다.<br>
	 * ContainerMovementMgtForGateNewDBDAO를 생성한다.<br>
	 */
	public ContainerMovementMgtForGateNewBCImpl() {
		dbDao = new ContainerMovementMgtForGateNewDBDAO();
	}

	/**
	 * GATE NEW <br>
	 *  Container Movement EDI Batch<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @return FlatFileForGateNewVO
	 * @exception EventException
	 */
	public FlatFileForGateNewVO gateNew( FlatFileForGateNewVO flatFileForGateNewVO ) throws EventException {
		try {
			/* MQ에서 Data를 읽어 Tag 값을 Parsing 한후에 flatFileVo에 Data를 저장한후 BKG Count 를 Retrun 한다. */

			// Null방지 처리
			flatFileForGateNewVO.setBkgCount(flatFileForGateNewVO.getBkgCount() == null ? "" : flatFileForGateNewVO.getBkgCount().toString().trim());
			flatFileForGateNewVO.setBkgNumber0(flatFileForGateNewVO.getBkgNumber0() == null ? "" : flatFileForGateNewVO.getBkgNumber0().toString().trim());

			// bkgNumber[]가 없을때
			if ( flatFileForGateNewVO.getBkgNumber() == null ) {
				String[] bkgNumber = new String[1];
				bkgNumber[0] = flatFileForGateNewVO.getBkgNumber0();
				flatFileForGateNewVO.setBkgNumber(bkgNumber);
				if (flatFileForGateNewVO.getBkgNumber0().equals("")) {
					flatFileForGateNewVO.setBkgCount("0");
				} else {
					flatFileForGateNewVO.setBkgCount("1");
				}
			} else if ( !"".equals(flatFileForGateNewVO.getBkgNumber()[0]) ) {
				flatFileForGateNewVO.setBkgNumber0(flatFileForGateNewVO.getBkgNumber()[0].toString().trim());
			}
			flatFileForGateNewVO.setBlNo(flatFileForGateNewVO.getBlNo() == null ? "" : flatFileForGateNewVO.getBlNo().toString().trim());
			flatFileForGateNewVO.setCallSignNo(flatFileForGateNewVO.getCallSignNo() == null ? "" : flatFileForGateNewVO.getCallSignNo().toString().trim());
			flatFileForGateNewVO.setCarrierCode(flatFileForGateNewVO.getCarrierCode() == null ? "" : flatFileForGateNewVO.getCarrierCode().toString().trim());
			flatFileForGateNewVO.setCarrierCountry(flatFileForGateNewVO.getCarrierCountry() == null ? "" : flatFileForGateNewVO.getCarrierCountry().toString().trim());
			flatFileForGateNewVO.setChssCase(flatFileForGateNewVO.getChssCase() == null ? "" : flatFileForGateNewVO.getChssCase().toString().trim());
			flatFileForGateNewVO.setChssCode(flatFileForGateNewVO.getChssCode() == null ? "" : flatFileForGateNewVO.getChssCode().toString().trim());
			flatFileForGateNewVO.setCntCd(flatFileForGateNewVO.getCntCd() == null ? "" : flatFileForGateNewVO.getCntCd().toString().trim());
			flatFileForGateNewVO.setCntrNumber(flatFileForGateNewVO.getCntrNumber() == null ? "" : flatFileForGateNewVO.getCntrNumber().toString().trim());
			flatFileForGateNewVO.setCntrTpszCd(flatFileForGateNewVO.getCntrTpszCd() == null ? "" : flatFileForGateNewVO.getCntrTpszCd().toString().trim());
			flatFileForGateNewVO.setContStat(flatFileForGateNewVO.getContStat() == null ? "" : flatFileForGateNewVO.getContStat().toString().trim());
			flatFileForGateNewVO.setDelTag(flatFileForGateNewVO.getDelTag() == null ? "" : flatFileForGateNewVO.getDelTag().toString().trim());
			flatFileForGateNewVO.setDestLoc(flatFileForGateNewVO.getDestLoc() == null ? "" : flatFileForGateNewVO.getDestLoc().toString().trim());
			flatFileForGateNewVO.setDir(flatFileForGateNewVO.getDir() == null ? "" : flatFileForGateNewVO.getDir().toString().trim());
			flatFileForGateNewVO.setDmgFlag(flatFileForGateNewVO.getDmgFlag() == null ? "" : flatFileForGateNewVO.getDmgFlag().toString().trim());
			flatFileForGateNewVO.setEdiBkgNo(flatFileForGateNewVO.getEdiBkgNo() == null ? "" : flatFileForGateNewVO.getEdiBkgNo().toString().trim());
			flatFileForGateNewVO.setEdiId(flatFileForGateNewVO.getEdiId() == null ? "" : flatFileForGateNewVO.getEdiId().toString().trim());
			flatFileForGateNewVO.setEventDate(flatFileForGateNewVO.getEventDate() == null ? "" : flatFileForGateNewVO.getEventDate().toString().trim());
			flatFileForGateNewVO.setEventYard(flatFileForGateNewVO.getEventYard() == null ? "" : flatFileForGateNewVO.getEventYard().toString().trim());
			flatFileForGateNewVO.setFfileRrefNo(flatFileForGateNewVO.getFfileRrefNo() == null ? "" : flatFileForGateNewVO.getFfileRrefNo().toString().trim());
			flatFileForGateNewVO.setFlatCarNbr(flatFileForGateNewVO.getFlatCarNbr() == null ? "" : flatFileForGateNewVO.getFlatCarNbr().toString().trim());
			flatFileForGateNewVO.setGateIo(flatFileForGateNewVO.getGateIo() == null ? "" : flatFileForGateNewVO.getGateIo().toString().trim());
			flatFileForGateNewVO.setHangerTag(flatFileForGateNewVO.getHangerTag() == null ? "" : flatFileForGateNewVO.getHangerTag().toString().trim());
			flatFileForGateNewVO.setLloydNo(flatFileForGateNewVO.getLloydNo() == null ? "" : flatFileForGateNewVO.getLloydNo().toString().trim());
			flatFileForGateNewVO.setLstmCd(flatFileForGateNewVO.getLstmCd() == null ? "" : flatFileForGateNewVO.getLstmCd().toString().trim());
			flatFileForGateNewVO.setMgSet(flatFileForGateNewVO.getMgSet() == null ? "" : flatFileForGateNewVO.getMgSet().toString().trim());
			flatFileForGateNewVO.setMsgId(flatFileForGateNewVO.getMsgId() == null ? "" : flatFileForGateNewVO.getMsgId().toString().trim());
			flatFileForGateNewVO.setMuidArea(flatFileForGateNewVO.getMuidArea() == null ? "" : flatFileForGateNewVO.getMuidArea().toString().trim());
			flatFileForGateNewVO.setMuidDt(flatFileForGateNewVO.getMuidDt() == null ? "" : flatFileForGateNewVO.getMuidDt().toString().trim());
			flatFileForGateNewVO.setMuidSeq(flatFileForGateNewVO.getMuidSeq() == null ? "" : flatFileForGateNewVO.getMuidSeq().toString().trim());
			flatFileForGateNewVO.setMvmtEdiStsTpFlg(flatFileForGateNewVO.getMvmtEdiStsTpFlg() == null ? "" : flatFileForGateNewVO.getMvmtEdiStsTpFlg().toString().trim());
			flatFileForGateNewVO.setMvmtStatus(flatFileForGateNewVO.getMvmtStatus() == null ? "" : flatFileForGateNewVO.getMvmtStatus().toString().trim());
			flatFileForGateNewVO.setOfficeYard(flatFileForGateNewVO.getOfficeYard() == null ? "" : flatFileForGateNewVO.getOfficeYard().toString().trim());
			flatFileForGateNewVO.setPickupNo(flatFileForGateNewVO.getPickupNo() == null ? "" : flatFileForGateNewVO.getPickupNo().toString().trim());
			flatFileForGateNewVO.setPod(flatFileForGateNewVO.getPod() == null ? "" : flatFileForGateNewVO.getPod().toString().trim());
			flatFileForGateNewVO.setPol(flatFileForGateNewVO.getPol() == null ? "" : flatFileForGateNewVO.getPol().toString().trim());
			flatFileForGateNewVO.setResultIndicator(flatFileForGateNewVO.getResultIndicator() == null ? "" : flatFileForGateNewVO.getResultIndicator().toString().trim());
			flatFileForGateNewVO.setResultMessage(flatFileForGateNewVO.getResultMessage() == null ? "" : flatFileForGateNewVO.getResultMessage().toString().trim());
			flatFileForGateNewVO.setSealNo(flatFileForGateNewVO.getSealNo() == null ? "" : flatFileForGateNewVO.getSealNo().toString().trim());
			flatFileForGateNewVO.setSightCd(flatFileForGateNewVO.getSightCd() == null ? "" : flatFileForGateNewVO.getSightCd().toString().trim());
			flatFileForGateNewVO.setSubstitution(flatFileForGateNewVO.getSubstitution() == null ? "" : flatFileForGateNewVO.getSubstitution().toString().trim());
			flatFileForGateNewVO.setTermId(flatFileForGateNewVO.getTermId() == null ? "" : flatFileForGateNewVO.getTermId().toString().trim());
			flatFileForGateNewVO.setTransMode(flatFileForGateNewVO.getTransMode() == null ? "" : flatFileForGateNewVO.getTransMode().toString().trim());
			flatFileForGateNewVO.setVessel(flatFileForGateNewVO.getVessel() == null ? "" : flatFileForGateNewVO.getVessel().toString().trim());
			flatFileForGateNewVO.setVndrSeq(flatFileForGateNewVO.getVndrSeq() == null ? "" : flatFileForGateNewVO.getVndrSeq().toString().trim());
			flatFileForGateNewVO.setVoyage(flatFileForGateNewVO.getVoyage() == null ? "" : flatFileForGateNewVO.getVoyage().toString().trim());
			flatFileForGateNewVO.setWayBillNo(flatFileForGateNewVO.getWayBillNo() == null ? "" : flatFileForGateNewVO.getWayBillNo().toString().trim());
			flatFileForGateNewVO.setStowage(flatFileForGateNewVO.getStowage() == null ? "" : flatFileForGateNewVO.getStowage().toString().trim());
			flatFileForGateNewVO.setCheckNassignData("");
			flatFileForGateNewVO.setNBkgNoFlg("N");
			flatFileForGateNewVO.setUserId(flatFileForGateNewVO.getUserId() == null ? "" : flatFileForGateNewVO.getUserId().toString().trim());
			flatFileForGateNewVO.setUserNm(flatFileForGateNewVO.getUserNm() == null ? "" : flatFileForGateNewVO.getUserNm().toString().trim());
			// 2016.06.02 김상현 [CHM-201641731] VGM 항목 추가
			flatFileForGateNewVO.setVgmMzdTpCd(flatFileForGateNewVO.getVgmMzdTpCd() == null ? "" : flatFileForGateNewVO.getVgmMzdTpCd().trim());
			flatFileForGateNewVO.setVgmWgtUtCd(flatFileForGateNewVO.getVgmWgtUtCd() == null ? "" : flatFileForGateNewVO.getVgmWgtUtCd().trim());
			flatFileForGateNewVO.setVgmWgtQty(flatFileForGateNewVO.getVgmWgtQty() == null ? "" : flatFileForGateNewVO.getVgmWgtQty().trim());
			flatFileForGateNewVO.setVgmVrfyDt(flatFileForGateNewVO.getVgmVrfyDt() == null ? "" : flatFileForGateNewVO.getVgmVrfyDt().trim());
			flatFileForGateNewVO.setVgmSigCtnt(flatFileForGateNewVO.getVgmSigCtnt() == null ? "" : flatFileForGateNewVO.getVgmSigCtnt().trim());
			flatFileForGateNewVO.setVgmRefNo(flatFileForGateNewVO.getVgmRefNo() == null ? "" : flatFileForGateNewVO.getVgmRefNo());
			flatFileForGateNewVO.setVgmWgtPtyCtnt(flatFileForGateNewVO.getVgmWgtPtyCtnt() == null ? "" : flatFileForGateNewVO.getVgmWgtPtyCtnt().trim());
			flatFileForGateNewVO.setVgmVrfyOrdCtnt(flatFileForGateNewVO.getVgmVrfyOrdCtnt() == null ? "" : flatFileForGateNewVO.getVgmVrfyOrdCtnt().trim());

			// msgId 에 따라 아래 logic 을 수행한다.
			if ( flatFileForGateNewVO.getMsgId().equals("322") || flatFileForGateNewVO.getMsgId().equals("COD") || flatFileForGateNewVO.getMsgId().equals("PRV") || flatFileForGateNewVO.getMsgId().equals("WEB") ) {

				if ( flatFileForGateNewVO.getMvmtStatus().equals("ER") || flatFileForGateNewVO.getMvmtStatus().equals("ZZ") || flatFileForGateNewVO.getMvmtStatus().equals("") ) {
					//EdiMsgVO.mvmt_edi_sts_tp_flg = "Y" ;	/* NIS에서 Movement Status판별수행 */
					flatFileForGateNewVO.setMvmtEdiStsTpFlg("Y");	 /* NIS에서 Movement Status판별수행 */
				} else {
					//EdiMsgVO.mvmt_edi_sts_tp_flg = "N" ;	/* EDI로부터 Movement Status를 수신 */
					flatFileForGateNewVO.setMvmtEdiStsTpFlg("N");	 /* EDI로부터 Movement Status를 수신 */
				}

				// mvmtStatus Not IN ("ER","","ZZ","AE","UV")
				if ( !flatFileForGateNewVO.getMvmtStatus().equals("ER") && (!flatFileForGateNewVO.getMvmtStatus().equals("")) && !flatFileForGateNewVO.getMvmtStatus().equals("ZZ") && !flatFileForGateNewVO.getMvmtStatus().equals("AE") && !flatFileForGateNewVO.getMvmtStatus().equals("UV")) {

					/* KOR지역(COD,PRV)에 대해서 Movement Status 재판별을 위해 Movement Status 무시함 (2009.12.04 - SWA지역(COD,PRV)에 대해서 Movement Status 재판별 추가) */
					if ( (flatFileForGateNewVO.getMsgId().equals("COD") || flatFileForGateNewVO.getMsgId().equals("PRV"))
					  && (flatFileForGateNewVO.getMuidArea().equals("KOR") || flatFileForGateNewVO.getMuidArea().equals("SWA")) ) {
						flatFileForGateNewVO.setMvmtStatus("ER");
					}

					/* EUR지역(COD)에 대해서 Movement Status 재판별을 위해 Movement Status 무시함 */
					if ( flatFileForGateNewVO.getMsgId().equals("COD") && flatFileForGateNewVO.getMuidArea().equals("EUR") ) {
						flatFileForGateNewVO.setMvmtStatus("ER");
					}

					/* USA지역(322)에 대해서 Movement Status 재판별을 위해 Movement Status 무시함 */
					if ( flatFileForGateNewVO.getMsgId().equals("322")  && flatFileForGateNewVO.getMuidArea().equals("USA") ) {
						flatFileForGateNewVO.setMvmtStatus("ER");
					}

					/* CHN지역(COD)에 대해서 Movement Status 재판별을 위해 Movement Status 무시함 */
//					if ( flatFileForGateNewVO.getMsgId().equals("COD") && flatFileForGateNewVO.getMuidArea().equals("CHN") ) {
//						flatFileForGateNewVO.setMvmtStatus("ER");
//					}
					if ( flatFileForGateNewVO.getMsgId().equals("COD") && flatFileForGateNewVO.getMuidArea().equals("CHN") && (!flatFileForGateNewVO.getMvmtStatus().equals("TN")) && (!flatFileForGateNewVO.getEventYard().equals("CNSHA")) ) { 
						flatFileForGateNewVO.setMvmtStatus("ER"); 
					}

				}

				/***** 2009.12.04 - Yard : SGSINAO 의 경우 Full/Empty 정보를 'M'으로 변경 *****/
				if( subStr(flatFileForGateNewVO.getEventYard(), 0, 7).equals("SGSINAO") ) {
					flatFileForGateNewVO.setContStat("M");
				}

				/* 미주 "322" 메시지이고 cntrNumber 자리에 chassis no가 들어온 경우 chassis logic을 수행한다. */
				/* if ( flatFileVo.getMsgId().equals("322") && (subStr(flatFileVo.getCntrNumber(), 9, 11).equals("") || (subStr(flatFileVo.getCntrNumber(), 3, 4).equals("Z") || subStr(flatFileVo.getCntrNumber(), 3, 4).equals("C"))) ) { */
				if ( flatFileForGateNewVO.getMsgId().equals("322")
				 && ((subStr(flatFileForGateNewVO.getCntrNumber(), 3, 4).equals("Z") || subStr(flatFileForGateNewVO.getCntrNumber(), 3, 4).equals("C") || subStr(flatFileForGateNewVO.getCntrNumber(), 3, 4).equals("P"))) ) {

					flatFileForGateNewVO.setChssCase("Y");
					log.debug("\n\n===============================================================" +
							  "\n @decideChassisStatus(GateIo)" +
							  "\n===============================================================\n");
					flatFileForGateNewVO.setMvmtStatus(decideChassisStatus(flatFileForGateNewVO.getGateIo()));    /* Chassis Status */

					if ( flatFileForGateNewVO.getMvmtStatus().equals("BI") ) {
						flatFileForGateNewVO.setGateIo("I");

					} else if ( flatFileForGateNewVO.getMvmtStatus().equals("BO") ) {
						flatFileForGateNewVO.setGateIo("O");

					}
					log.debug("\n\n===============================================================" +
							  "\n @checkNassignData(322 & Z,C,P )" +
							  "\n===============================================================\n");
					if ( checkNassignData(flatFileForGateNewVO) ) {
						flatFileForGateNewVO.setCheckNassignData("Y");
					} else {
						flatFileForGateNewVO.setCheckNassignData("N");
					}

					if ( !"Y".equals(flatFileForGateNewVO.getEdiUiYn()) ) {
						/* EDI Message 저장 수행 */
						log.debug("\n\n===============================================================" +
								  "\n @insertEDIMessage" +
								  "\n===============================================================\n");
						flatFileForGateNewVO = insertEDIMessage( flatFileForGateNewVO );
					}

					return flatFileForGateNewVO;
				}

				/* 미주 "322" 메시지이고  gate status가 AR(Rail Arrival At Destination Intermodal Ramp)인 경우 skip 한다. */
				if ( flatFileForGateNewVO.getMsgId().equals("322") && flatFileForGateNewVO.getGateIo().equals("AR") ) {
					log.debug("\n\n=============================================================== [MsgId : 322 & GateIo : AR] Case = > Skip\n");
					return flatFileForGateNewVO;
				}

				/* 메시지가 "322", "COD", "PRV" 이면 Booking no 찾는 logic을 수행한다. */
				if ( flatFileForGateNewVO.getMsgId().equals("322") || flatFileForGateNewVO.getMsgId().equals("COD") || flatFileForGateNewVO.getMsgId().equals("PRV") ) {
					log.debug("\n\n===============================================================" +
							  "\n @adjustBkgNumber" +
							  "\n===============================================================\n");
					boolean bkgCheck = adjustBkgNumber( flatFileForGateNewVO );
					log.debug("\n\n===============================================================" +
							  "\n bkgCheck = " + bkgCheck +
							  "\n===============================================================\n");

					/* 메시지가 "322", "COD", "PRV" 이고 Normal BKG 이면  Sight Code를 찾는 logic을 수행한다. */
					log.debug("\n\n===============================================================" +
							  "\n @adjustSightCode" +
							  "\n===============================================================\n");
					flatFileForGateNewVO = adjustSightCode( flatFileForGateNewVO, bkgCheck );
				}

				/**
				 * 2015.11.19 Logic 추가.
				 * 이전 단계가 CP이고 현재 값에 booking no.가 invalid이면 이전 단계 booking no.를 복사해서 Domestic booking logic 처리하도록 수정.
				 * By Sang-Hyun Kim
				 */
				if ("322".equals(flatFileForGateNewVO.getMsgId()) && "USA".equals(flatFileForGateNewVO.getMuidArea())) {
					if (flatFileForGateNewVO.getBkgNumber()[0] == null || "".equals(flatFileForGateNewVO.getBkgNumber()[0])) {
						String bkgNo = checkDomesticBooking(flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getEventDate(), flatFileForGateNewVO.getBkgNumber()[0]);
						if (bkgNo != null && !bkgNo.equals("NotChange") && !bkgNo.equals(flatFileForGateNewVO.getBkgNumber()[0])) {
							String bkgNumbers[] = flatFileForGateNewVO.getBkgNumber();
							bkgNumbers[0] = bkgNo;
							flatFileForGateNewVO.setBkgNumber(bkgNumbers);
						}
					}
				}

				/* Movement Status를 판단하는 Logic을 수행한다 */
				if ( (flatFileForGateNewVO.getMvmtStatus().equals("ER") || flatFileForGateNewVO.getMvmtStatus().equals("")) && (!flatFileForGateNewVO.getGateIo().equals("AE") && !flatFileForGateNewVO.getGateIo().equals("UV")) ) {
					if ( flatFileForGateNewVO.getMsgId().equals("322") ) {
						/* FlatFileVO.bkgNumber[0]가 Domestic Booking 이면 skip 한다. */
						String domesticCheck = subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 4);
						/*
						 * 2015.12.24 추가 by Sang-Hyun Kim
						 * "TMAT", "TIND", "TESI", "THYI" Domestic booking으로 판별하도록 추가.
						 *  - HJL이 아닌 타 업체 booking no.
						 */
						if ((domesticCheck.equals("DLAX") || domesticCheck.equals("DCHI") || domesticCheck.equals("DHOU") || domesticCheck.equals("DMEM")
								|| domesticCheck.equals("DNYC") || domesticCheck.equals("DSEA") || domesticCheck.equals("TCHI")
								|| domesticCheck.equals("DHJI") || domesticCheck.equals("THJI") || domesticCheck.equals("TMAT")
								|| domesticCheck.equals("TIND") || domesticCheck.equals("TESI") || domesticCheck.equals("THYI"))
								&& flatFileForGateNewVO.getMuidArea().equals("USA")) {
							log.debug("\n\n===============================================================" +
									  "\n @decideDomesticStatus" +
									  "\n===============================================================\n");
							String domesticStatus = decideDomesticStatus( flatFileForGateNewVO );    /* Domestic_Decision */
							if (domesticStatus.equals("ER")) {
								flatFileForGateNewVO.setResultMessage("Domestic Status Check Error Return");
							}
							flatFileForGateNewVO.setMvmtStatus( domesticStatus );

						} else {
							log.debug("\n\n===============================================================" +
									  "\n @decide322Status" +
									  "\n===============================================================\n");
							flatFileForGateNewVO.setMvmtStatus( decide322Status(flatFileForGateNewVO) );    /* N322_Decision */

						}
					} else {
						log.debug("\n\n===============================================================" +
								  "\n @decideOtherStatus" +
								  "\n===============================================================\n");
						flatFileForGateNewVO.setMvmtStatus( decideOtherStatus(flatFileForGateNewVO) );    /* ALL_Decision */

					}

				} else if ( flatFileForGateNewVO.getMsgId().equals("322") && flatFileForGateNewVO.getGateIo().equals("UV") ) {
					flatFileForGateNewVO.setMvmtStatus("VD");

				} else if ( flatFileForGateNewVO.getMsgId().equals("322") && flatFileForGateNewVO.getGateIo().equals("AE") ) {
					flatFileForGateNewVO.setMvmtStatus("VL");

				} else if( flatFileForGateNewVO.getMsgId().equals("COD") && flatFileForGateNewVO.getGateIo().equals("UV") && flatFileForGateNewVO.getMvmtStatus().equals("ZZ") ) {
					/* 2010 : eventYard Filter 제거 할것 */
					flatFileForGateNewVO.setMvmtStatus("VD");

				} else if( flatFileForGateNewVO.getMsgId().equals("COD") && flatFileForGateNewVO.getGateIo().equals("AE") && flatFileForGateNewVO.getMvmtStatus().equals("ZZ") ) {
					/* 2010 : eventYard Filter 제거 할것 */
					flatFileForGateNewVO.setMvmtStatus("VL");
				}

			/* Data 처리 Logic 수행 */
			/* ALL_Data_Update()  */
			/* if ( msgId in ("322", "COD", "PRV", "WEB")  ) */
			} else if ( flatFileForGateNewVO.getMsgId().equals("222") ) {
				/* Movement Status 판별수행의 주체 구분 Flag를 Setting한다 (222은 Movement Status 판정하지 않음)*/
				flatFileForGateNewVO.setMvmtEdiStsTpFlg("N");
			}

			/* Data Check Logic 수행 */
			log.debug("\n\n===============================================================" +
					  "\n @checkNassignData(Other)" +
					  "\n===============================================================\n");
			if ( checkNassignData(flatFileForGateNewVO) ) {
				flatFileForGateNewVO.setCheckNassignData("Y");
			} else {
				flatFileForGateNewVO.setCheckNassignData("N");
			}

			if ( !"Y".equals(flatFileForGateNewVO.getEdiUiYn()) ) {
				/* EDI Message 저장 수행 */
				log.debug("\n\n===============================================================" +
						  "\n @insertEDIMessage" +
						  "\n===============================================================\n");
				flatFileForGateNewVO = insertEDIMessage( flatFileForGateNewVO );
			}
			return flatFileForGateNewVO;

		} catch (EventException ex) {
			log.error("\n\n[BCImpl - gateNew] EventException :\n" + ex.getMessage(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("\n\n[BCImpl - gateNew] Exception :\n" + ex.getMessage(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * Container Movement Status 판정<br>
	 *  decideOtherStatus for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @return String
	 * @exception EventException
	 *
	 *  ALL_Decision (sub_sts.pc) + Get_MoveId_All(sub_sts1.pc) + Get_MoveIdTbl_All(sub_sts2.c)
	 **/
	private String decideOtherStatus( FlatFileForGateNewVO flatFileForGateNewVO ) throws EventException {

		if ( flatFileForGateNewVO.getContStat().equals("E") )   {
			flatFileForGateNewVO.setContStat("M");

		} else if ( flatFileForGateNewVO.getContStat().equals("L") ) {
			flatFileForGateNewVO.setContStat("F");

		}

//		EXEC SQL
//		SELECT	NVL(MVMT_STS_CD,"ER")
//		INTO	:set_mvmtStatus
//		FROM	CTM_MVMT_STS_DCSN
//		WHERE	MVMT_EDI_MSG_TP_ID = "OTH"	/* 2010 Not 322 */
//		AND		MVMT_EDI_IO_BND_CD = DECODE(:FlatFileVO.cont_stat,	"M",	"I", :FlatFileVO.cont_stat)
//		AND		MVMT_EDI_CNTR_STS_CD = :FlatFileVO.cont_stat
//		AND		MVMT_EDI_GATE_IO_CD = :FlatFileVO.gateIo

		String returnValue = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.decideStatus(OTH)" +
					  "\n===============================================================\n");
			returnValue = dbDao.decideStatus(flatFileForGateNewVO.getContStat(), flatFileForGateNewVO.getGateIo(), "OTH", flatFileForGateNewVO.getSightCd());
			log.debug("\n====================== dbDao.decideStatus(OTH) returnValue : " + returnValue + "\n");
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.decideStatus(OTH)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.decideStatus(OTH)] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if ( returnValue == null || returnValue.equals("") ) {
			return "ER";
		}

		// switch문 사용을 위한 returnValue의 숫자형 체크
		int returnValueNum = 0;
		for(int k=0; k<10; k++) {
			if((k + "").equals(returnValue.trim() + "")) {
				returnValueNum = k;
				break;
			}
		}


		switch (returnValueNum) {
		case 1:
			if ( (flatFileForGateNewVO.getBkgNumber()[0] == null || flatFileForGateNewVO.getBkgNumber()[0].equals("")) || subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1).equals("#") ) {
				returnValue = "TN";

			} else if ( subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 3).equals("REP") ) {
				log.debug("\n\n===============================================================" +
						  "\n @setEnTn" +
						  "\n===============================================================\n");
				returnValue = setEnTn( flatFileForGateNewVO.getEventYard(), subStr(flatFileForGateNewVO.getBkgNumber()[0], 4, 8) ) ;

			} else {
				log.debug("\n\n===============================================================" +
						  "\n @checkBkgNo" +
						  "\n===============================================================\n");
				if ( checkBkgNo( flatFileForGateNewVO.getBkgNumber()[0] ) ) {
					returnValue = "OP";

				} else {
					returnValue = "TN";
				}
			}
			break;


		case 2:
			/***** 미주이외의 지역은 EDI로 전송된 Dest Location을 사용하지 않음 - 2009.03.18 *****/
			String delCode[] = new String[2];
			if ( (flatFileForGateNewVO.getBkgNumber()[0] != null && !flatFileForGateNewVO.getBkgNumber()[0].equals("")) && !subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1).equals("#") ) {

//				EXEC SQL
//				SELECT	DEL_CD,		DE_TERM_CD					/* 2010 함수화 할것 */
//				INTO	:destLoc,	:dlvTerm
//				FROM	BKG_BOOKING
//				WHERE	BKG_NO			= :flatFileVo.bkgNumber[0];

				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.searchDelCode(BkgNumber)" +
							  "\n===============================================================\n");
					delCode = dbDao.searchDelCode( flatFileForGateNewVO.getBkgNumber()[0], "" );
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.searchDelCode(BkgNumber)] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.searchDelCode(BkgNumber)] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}

				if ( delCode[0] == null || delCode[0].equals("") ) {
					/* returnValue = "ER"; */
					returnValue = "TN"	;	/* Full, GateOut, Invalid BKG의 경우, TN으로 판별 - 2009.09.16 */
					break;
				}

			} else if ( (flatFileForGateNewVO.getBlNo() != null && !flatFileForGateNewVO.getBlNo().equals("")) && !subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1).equals("#") ) {

//				EXEC SQL
//				SELECT	DEL_CD,		DE_TERM_CD					/* 2010 함수화 할것 */
//				INTO	:destLoc,	:dlvTerm
//				FROM	BKG_BOOKING
//				WHERE	BL_NO		=	:flatFileVo.blNo[0];

				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.searchDelCode(BlNo)" +
							  "\n===============================================================\n");
					delCode = dbDao.searchDelCode( "", flatFileForGateNewVO.getBlNo() );
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.searchDelCode(BlNo)] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.searchDelCode(BlNo)] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}

				if ( delCode[0] == null || delCode[0].equals("") ) {
					/* returnValue = "ER"; */
					returnValue = "TN"	;	/* Full, GateOut, Invalid BKG의 경우, TN으로 판별 - 2009.09.16 */
					break;
				}

			} else {
				/* returnValue = "ER"; */
				returnValue = "TN"	;	/* BKG정보 없는 Full, GateOut(Inbound or Outbound)의 경우, TN으로 판별 - 2009.09.03 */
				break;

			}

			log.debug("\n\n===============================================================" +
					  "\n @setIdEnTnOther" +
					  "\n===============================================================\n");
			returnValue = setIdEnTnOther( flatFileForGateNewVO, delCode[0], delCode[1] );

			break;


		case 3:
			String destLoc = "";
			if ( (flatFileForGateNewVO.getBkgNumber()[0] != null && !flatFileForGateNewVO.getBkgNumber()[0].equals("")) && !subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1).equals("#") ) {

//					EXEC SQL
//					SELECT	POL_CD
//					INTO	:destLoc
//					FROM	BKG_BOOKING
//					WHERE	BKG_NO	=	:flatFileVo.bkgNumber[0];

				log.debug("\n\n===============================================================" +
						  "\n @getPolCodeOf" +
						  "\n===============================================================\n");
				destLoc = getPolCodeOf("BKG_NO", flatFileForGateNewVO.getBkgNumber()[0]);

				if ( destLoc == null || destLoc.equals("") ) {
					/* returnValue = "ER"; */
					returnValue = "TN"	;	/* Full, GateOut, Invalid BKG의 경우, TN으로 판별 - 2009.09.16 */
					break;
				}

			} else if ( (flatFileForGateNewVO.getBlNo() != null && !flatFileForGateNewVO.getBlNo().equals("")) && !subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1).equals("#") ) {

//					EXEC SQL
//					SELECT	POL_CD
//					INTO	:destLoc
//					FROM	BKG_BOOKING
//					WHERE	BL_NO	=	:flatFileVo.blNo[0];

				log.debug("\n\n===============================================================" +
						  "\n @getPolCodeOf" +
						  "\n===============================================================\n");
				destLoc = getPolCodeOf("BL_NO", flatFileForGateNewVO.getBlNo());

				if ( destLoc == null || destLoc.equals("") ) {
					/* returnValue = "ER"; */
					returnValue = "TN"	;	/* Full, GateOut, Invalid BKG의 경우, TN으로 판별 - 2009.09.16 */
					break;
				}

			} else {
				//returnValue = "ER";
				returnValue = "TN"	;	/* BKG정보 없는 Full, GateOut(Inbound or Outbound)의 경우, TN으로 판별 - 2009.09.03 */
				break;

			}

			log.debug("\n\n===============================================================" +
					  "\n @setEnTn" +
					  "\n===============================================================\n");
			returnValue = setEnTn(flatFileForGateNewVO.getEventYard(), destLoc);

			break;

		}    /* switch( set_mvmtStatus ) */

		if ( returnValue.equals("") ) returnValue = "ER";

		return returnValue;

	}

	/**
	 * Container Movement Status 판정<br>
	 *  decide322Status for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @return String
	 * @exception EventException
	 *
	 * N322_Decision (322.pc) + Get_MoveId (sub_322.pc) + Get_MoveIdTbl (move_id.c)
	 **/
	private String decide322Status( FlatFileForGateNewVO flatFileForGateNewVO ) throws EventException {
		if ( flatFileForGateNewVO.getContStat().equals("AL") || flatFileForGateNewVO.getContStat().equals("AA") || flatFileForGateNewVO.getContStat().equals("W") ) {	/* MT Status   */
			flatFileForGateNewVO.setContStat("M");

		} else if ( flatFileForGateNewVO.getContStat().equals("AC") ) {	/* Full Status */
			flatFileForGateNewVO.setContStat("F");

		}

		String returnValue = "";
		if ( flatFileForGateNewVO.getSightCd().equals("N") ) {	/* Import / Export */
			if ( flatFileForGateNewVO.getGateIo().equals("A") ||  flatFileForGateNewVO.getGateIo().equals("I") ) {
				returnValue = "TS";

			} else if ( flatFileForGateNewVO.getGateIo().equals("AO") || flatFileForGateNewVO.getGateIo().equals("P") || flatFileForGateNewVO.getGateIo().equals("D") || flatFileForGateNewVO.getGateIo().equals("OA") ) {
				returnValue = "TN";

			} else {
				returnValue = "ER";

			}
			return	returnValue;
		}

//		EXEC SQL
//		SELECT	NVL(MVMT_STS_CD,"ER")
//		INTO	:set_mvmtStatus
//		FROM	CTM_MVMT_STS_DCSN
//		WHERE	MVMT_EDI_MSG_TP_ID		=	"322"
//		AND		MVMT_EDI_IO_BND_CD		=	DECODE( :flatFileVo.cont_stat,	"F ",	:flatFileVo.sightCd , "AH",	:flatFileVo.sightCd ,	"I" ) /* MTY 는 Inbound 기준 */
//		AND		MVMT_EDI_CNTR_STS_CD	=	:flatFileVo.cont_stat
//		AND		MVMT_EDI_GATE_IO_CD		=	:flatFileVo.gateIo;

		try {
			log.debug("\n dbDao.decideStatus(322)\n");
			returnValue = dbDao.decideStatus(flatFileForGateNewVO.getContStat(), flatFileForGateNewVO.getGateIo(), "322", flatFileForGateNewVO.getSightCd());
			log.debug("\n returnValue : " + returnValue + "\n");
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.decideStatus(322)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.decideStatus(322)] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if ( returnValue == null || returnValue.equals("") ) {
			return "ER";

		}

		// switch문 사용을 위한 returnValue의 숫자형 체크
		int returnValueNum = 0;
		for(int k=0; k<10; k++) {
			if((k + "").equals(returnValue.trim() + "")) {
				returnValueNum = k;
				break;
			}
		}


		String[] delCode = new String[2];
		switch (returnValueNum) {
		case 1 :
			// 2016.03.21 김상현 [CHM-201640425] Full/Empty 값이 "AJ"이고 Gate I/O 값이 "OA"일 경우, Booking No.가 유효할 때 "OP" 생성
			//  - 'AJ'(Empty Positioning)이라도 Booking No가 유효할 경우, 'OP' 처리
			if ((flatFileForGateNewVO.getBkgNumber()[0] == null || flatFileForGateNewVO.getBkgNumber()[0].equals("")) || subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1).equals("#")) {
				if (flatFileForGateNewVO.getContStat().equals("AB") || flatFileForGateNewVO.getContStat().equals("AJ")) {
					returnValue = "TN";
				} else if (flatFileForGateNewVO.getDestLoc() != null && !flatFileForGateNewVO.getDestLoc().equals("")) {
					log.debug("\n @setEnTn\n");
					returnValue = setEnTn(flatFileForGateNewVO.getEventYard(), flatFileForGateNewVO.getDestLoc());
				} else {
					if (flatFileForGateNewVO.getGateIo().equals("AL")) {
						returnValue = "EN";
					} else {
						returnValue = "TN";
					}
				}
			} else if (subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 3).equals("REP")) {
				if (flatFileForGateNewVO.getContStat().equals("AB") || flatFileForGateNewVO.getContStat().equals("AJ")) {
					returnValue = "TN";
				} else {
					log.debug("\n @setEnTn(REP)\n");
					returnValue = setEnTn(flatFileForGateNewVO.getEventYard(), "US" + subStr(flatFileForGateNewVO.getBkgNumber()[0], 4, 6));
				}
			} else {
				if (flatFileForGateNewVO.getGateIo().equals("AL")) {
					returnValue = "EN";
				} else {
					log.debug("\n @checkBkgNo\n");
					if (checkBkgNo(flatFileForGateNewVO.getBkgNumber()[0])) {
						returnValue = "OP";
					} else {
						returnValue = "TN";
					}
				}
			}
			break;
		case 2:
			if ( subStr(flatFileForGateNewVO.getTermId(), 0, 5).equals("RESNJ") ) {
				returnValue = "ID";
				break;
			}

			/*--------------------------------------------------------------------(S) 2010.02.01 By DSLee */
			if ( flatFileForGateNewVO.getMuidArea().equals("USA") && (!flatFileForGateNewVO.getGateIo().equals("AL") && !flatFileForGateNewVO.getGateIo().equals("RL")) ) {

				// Empty Release/Redelivery Order
//				EXEC SQL
//				SELECT	'A'
//				FROM	TRS_TRSP_SVC_ORD
//				WHERE	LOCL_CRE_DT		BETWEEN		TO_DATE(:FlatFileVO.eventDate,'YYYYMMDDHH24MI') - 20
//										AND			TO_DATE(:FlatFileVO.eventDate,'YYYYMMDDHH24MI') + 7
//				AND		TRSP_SO_TP_CD			=	'Y'
//				AND		TRSP_COST_DTL_MOD_CD	=	'DR'
//				AND		FM_NOD_CD				=	:FlatFileVO.eventYard
//				AND		TRSP_BND_CD				=	'I'
//				AND		BKG_NO					=	:FlatFileVO.bkgNumber[0]
//				AND		EQ_NO					=	:FlatFileVO.cntrNumber
//				AND		DELT_FLG				=	'N'
//				AND		ROWNUM	=	1

				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.searchTrspOrderExist" +
							  "\n===============================================================\n");
					returnValue = dbDao.searchTrspOrderExist(flatFileForGateNewVO.getEventDate(), flatFileForGateNewVO.getEventYard(), flatFileForGateNewVO.getBkgNumber()[0], flatFileForGateNewVO.getCntrNumber());
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.searchTrspOrderExist] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.searchTrspOrderExist] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}

				if ( returnValue != null && !returnValue.equals("") ) {
					returnValue = "ID";
					break;
				}
			}
			/*--------------------------------------------------------------------(E) 2010.02.01 By DSLee */


			log.debug("\n\n===============================================================" +
					  "\n @checkLocCd" +
					  "\n===============================================================\n");
			if ( checkLocCd( flatFileForGateNewVO.getDestLoc() ) ) {
				delCode[0] = flatFileForGateNewVO.getDestLoc();
				delCode[1] = "";

			} else if ( (flatFileForGateNewVO.getBkgNumber()[0] != null && !flatFileForGateNewVO.getBkgNumber()[0].equals("")) && !subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1).equals("#") ) {

//				EXEC SQL
//				SELECT	DEL_CD,		DE_TERM_CD
//				INTO	:destLoc,	:dlvTerm
//				FROM	BKG_BOOKING
//				WHERE	BKG_NO			= :flatFileVo.bkgNumber[0];

				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.searchDelCode(BkgNumber)" +
							  "\n===============================================================\n");
					delCode = dbDao.searchDelCode( flatFileForGateNewVO.getBkgNumber()[0], "" );
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.searchDelCode(BkgNumber)] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.searchDelCode(BkgNumber)] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}

				if ( delCode[0] == null || delCode[0].equals("") ) {
					/* returnValue = "ER"; */
					returnValue = "TN"	;	/* Full, GateOut, Invalid BKG의 경우, TN으로 판별 - 2009.09.16 */
					break;
				}

			} else if ( (flatFileForGateNewVO.getBlNo() != null && !flatFileForGateNewVO.getBlNo().equals("")) && !subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1).equals("#") ) {

//				EXEC SQL
//				SELECT	DEL_CD,		DE_TERM_CD
//				INTO	:destLoc,	:dlvTerm
//				FROM	BKG_BOOKING
//				WHERE	BL_NO		=  :flatFileVo.blNo[0];

				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.searchDelCode(BlNo)" +
							  "\n===============================================================\n");
					delCode = dbDao.searchDelCode( "", flatFileForGateNewVO.getBlNo() );
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.searchDelCode(BlNo)] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.searchDelCode(BlNo)] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}

				if ( delCode[0] == null || delCode[0].equals("") ) {
					/* returnValue = "ER"; */
					returnValue = "TN"	;	/* Full, GateOut, Invalid BKG의 경우, TN으로 판별 - 2009.09.16 */
					break;
				}

			} else {
				//returnValue = "ER";
				returnValue = "TN";    /* BKG정보 없는 Full, GateOut(Inbound or Outbound)의 경우, TN으로 판별 - 2009.09.03 */
				break;
			}

			log.debug("\n\n===============================================================" +
					  "\n @setIdEnTn322" +
					  "\n===============================================================\n");
			returnValue = setIdEnTn322( flatFileForGateNewVO, delCode[0], delCode[1] ) ;
			break;


		case 3:
			log.debug("\n\n===============================================================" +
					  "\n @checkLocCd" +
					  "\n===============================================================\n");
			if ( checkLocCd( flatFileForGateNewVO.getDestLoc() ) ) {
				delCode[0] = flatFileForGateNewVO.getDestLoc();

			} else if ( (flatFileForGateNewVO.getBkgNumber()[0] != null && !"".equals(flatFileForGateNewVO.getBkgNumber()[0])) && !"#".equals(subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1)) ) {

//				EXEC SQL
//				SELECT	POL_CD
//				INTO	:destLoc
//				FROM	BKG_BOOKING
//				WHERE	BKG_NO			= :flatFileVo.bkgNumber[0];

				log.debug("\n\n===============================================================" +
						  "\n @getPolCodeOf" +
						  "\n===============================================================\n");
				delCode[0] = getPolCodeOf("BKG_NO", flatFileForGateNewVO.getBkgNumber()[0]);

				if ( delCode[0] == null || delCode[0].equals("") ) {
					/* returnValue = "ER"; */
					returnValue = "TN"	;	/* Full, GateOut, Invalid BKG의 경우, TN으로 판별 - 2009.09.16 */
					break;
				}

			} else if ( (flatFileForGateNewVO.getBlNo() != null && !"".equals(flatFileForGateNewVO.getBlNo())) && !"#".equals(subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1)) ) {

//				EXEC SQL
//				SELECT	POL_CD
//				INTO	:destLoc
//				FROM	BKG_BOOKING
//				WHERE	BL_NO		= :flatFileVo.blNo[0];

				log.debug("\n\n===============================================================" +
						  "\n @getPolCodeOf" +
						  "\n===============================================================\n");
				delCode[0] = getPolCodeOf("BL_NO", flatFileForGateNewVO.getBlNo());

				if ( delCode[0] == null || "".equals(delCode[0]) ) {
					/* returnValue = "ER"; */
					returnValue = "TN"	;	/* Full, GateOut, Invalid BKG의 경우, TN으로 판별 - 2009.09.16 */
					break;
				}

			} else {
				//returnValue = "ER";
				returnValue = "TN";    /* BKG정보 없는 Full, GateOut(Inbound or Outbound)의 경우, TN으로 판별 - 2009.09.03 */
				break;

			}

			log.debug("\n\n===============================================================" +
					  "\n @setEnTn" +
					  "\n===============================================================\n");
			returnValue = setEnTn( flatFileForGateNewVO.getEventYard(), delCode[0] ) ;

			break;


		case 4:
			/* RL의 경우, Empty이면서 BKG No, destLoc정보가 없으면 EN으로 판별 - 20080925 */
			boolean checkLocCdYN = false;

			log.debug("\n\n===============================================================" +
					  "\n @checkLocCd" +
					  "\n===============================================================\n");
			checkLocCdYN = checkLocCd( flatFileForGateNewVO.getDestLoc() );

			if ( flatFileForGateNewVO.getContStat().equals("M") &&  !checkLocCdYN && (flatFileForGateNewVO.getBkgNumber()[0].equals("") && subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1).equals("#")) ) {
				returnValue = "EN";
				break;

			} else if ( checkLocCdYN ) {
				delCode[0] = flatFileForGateNewVO.getDestLoc();
				delCode[1] = "";

			} else if ( !flatFileForGateNewVO.getBkgNumber()[0].equals("") &&  !subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1).equals("#") ) {

//				EXEC SQL
//				SELECT	DEL_CD,		DE_TERM_CD
//				INTO	:destLoc,	:dlvTerm
//				FROM	BKG_BOOKING
//				WHERE	BKG_NO			= :flatFileVo.bkgNumber[0];

				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.searchDelCode(BkgNumber)" +
							  "\n===============================================================\n");
					delCode = dbDao.searchDelCode( flatFileForGateNewVO.getBkgNumber()[0], "");
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.searchDelCode(BkgNumber)] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.searchDelCode(BkgNumber)] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}

				if ( delCode[0] == null || delCode[0].equals("") ) {
					returnValue = "ER";
					break;
				}

			} else if ( (flatFileForGateNewVO.getBlNo() != null && !flatFileForGateNewVO.getBlNo().equals("")) && !subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1).equals("#") ) {

//				EXEC SQL
//				SELECT	DEL_CD,		DE_TERM_CD
//				INTO	:destLoc,	:dlvTerm
//				FROM	BKG_BOOKING
//				WHERE	BL_NO		=	:flatFileVo.blNo[0];

				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.searchDelCode(BlNo)" +
							  "\n===============================================================\n");
					delCode = dbDao.searchDelCode( "", flatFileForGateNewVO.getBlNo() );
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.searchDelCode(BlNo)] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.searchDelCode(BlNo)] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}

				if ( delCode[0] == null || delCode[0].equals("") ) {
					returnValue = "ER";
					break;
				}

			} else {

				if ( flatFileForGateNewVO.getContStat().equals("M") ) {
					/* RL의 경우, Empty이면서 BKG No, destLoc정보가 없으면 EN으로 판별 - 20080925 */
					returnValue = "EN"	;

				} else {
					returnValue = "ER"	;

				}
				break;
			}

			log.debug("\n\n===============================================================" +
					  "\n @setEnTn" +
					  "\n===============================================================\n");
			returnValue = setEnTn( flatFileForGateNewVO.getEventYard(), delCode[0] ) ;

			break;

		}    /* switch( temp_mvmtStatus ) */

		if ( returnValue.equals("") ) returnValue = "ER";

		/* 2001.05.21 By SBKIM : AL -> EN Fix */
		if ( returnValue.equals("ER") && flatFileForGateNewVO.getGateIo().equals("AL") ) returnValue = "EN";

		return returnValue;

	}

	/**
	 * Domestic booking container movement status 판정
	 * @param flatFileForGateNewVO
	 * @return String
	 * @throws EventException
	 */
	private String decideDomesticStatus(FlatFileForGateNewVO flatFileForGateNewVO) throws EventException {
		String returnValue =  "";
		String dom_mvmt = "";
		String dom_bkg = "";
		String dom_in_Scc = "";
		String dest_scc = "";
		String[] rtn = new String[6];

		try {
			rtn = dbDao.domesticManualProcces(flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getEventYard(), flatFileForGateNewVO.getDestLoc());
			dom_mvmt = rtn[0];
			dom_bkg = rtn[3];
			dom_in_Scc = rtn[5];
			dest_scc = rtn[7];
    	} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.domesticManualProcces] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.domesticManualProcces] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if (!flatFileForGateNewVO.getLstmCd().equals("SH")
				&& (subStr(flatFileForGateNewVO.getContStat(), 0, 1).equals("M") || subStr(flatFileForGateNewVO.getContStat(), 0, 1).equals("W"))) {
			if (flatFileForGateNewVO.getGateIo().equals("RL") || flatFileForGateNewVO.getGateIo().equals("D")
					|| flatFileForGateNewVO.getGateIo().equals("AO") || flatFileForGateNewVO.getGateIo().equals("O")
					|| flatFileForGateNewVO.getGateIo().equals("P") || flatFileForGateNewVO.getGateIo().equals("OA")
					|| flatFileForGateNewVO.getGateIo().equals("AL")) {
				returnValue = "CP";
			} else {
				// 2016.02.12 Sang-Hyun Kim [CHM-201639830] CTM: Domestic MVMT CM 자동생성 logic 변경 
				// 이전 status가 'CI'이고 In일 경우, 'MT' status로 판단하도록 logic 추가.
				//  - 'CD', 'CM' 2개 단계 자동 생성하도록 보완.
				// 2016.03.20 김상현 [CHM-201640355] Last Bkg 생성/Update logic 변경2
				//  - 'CD'에서 'CM' 자동 생성하도록 추가 
				if ("CI".equals(dom_mvmt) || "CD".equals(dom_mvmt)) {
					returnValue = "MT";
				} else {
					returnValue = "ER";
				}
			}
		} else if (flatFileForGateNewVO.getLstmCd().equals("SH") || (!flatFileForGateNewVO.getContStat().equals("M") && !flatFileForGateNewVO.getContStat().equals("W"))) {
			String[] returnValues = new String[4];
			String delScc = "";
			String delLcc = "";
			String eventScc = "";
			String eventLcc = "";

			try {
				returnValues = dbDao.getLccSccForGateNew(flatFileForGateNewVO.getBkgNumber()[0], subStr(flatFileForGateNewVO.getEventYard(), 0, 5));
				delScc = returnValues[0];
				delLcc = returnValues[1];
				eventScc = returnValues[2];
				eventLcc = returnValues[3];
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getLccSccForGateNew] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getLccSccForGateNew] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			if ((delScc == null || delScc.equals("")) && (delLcc == null || delLcc.equals(""))
					&& (eventScc == null || eventScc.equals("")) && (eventLcc == null || eventLcc.equals(""))) {
//				returnValue = "ER";
				if (flatFileForGateNewVO.getGateIo().equals("RL") || flatFileForGateNewVO.getGateIo().equals("D")
						|| flatFileForGateNewVO.getGateIo().equals("AO") || flatFileForGateNewVO.getGateIo().equals("O")
						|| flatFileForGateNewVO.getGateIo().equals("P") || flatFileForGateNewVO.getGateIo().equals("OA")
						|| flatFileForGateNewVO.getGateIo().equals("AL")) {
					returnValue = "CT";
				} else if (!flatFileForGateNewVO.getGateIo().equals("")) {
					returnValue = "CO";
				}
			} else {
				if (flatFileForGateNewVO.getGateIo().equals("RL") || flatFileForGateNewVO.getGateIo().equals("D")
						|| flatFileForGateNewVO.getGateIo().equals("AO") || flatFileForGateNewVO.getGateIo().equals("O")
						|| flatFileForGateNewVO.getGateIo().equals("P") || flatFileForGateNewVO.getGateIo().equals("OA")
						|| flatFileForGateNewVO.getGateIo().equals("AL")) {
					if (eventScc.equals(delScc)) {
						returnValue = "CD";
					} else if (eventLcc.equals(delLcc)) {
						returnValue = "CT";
					} else {
						returnValue = "CE";
					}
				} else if (!flatFileForGateNewVO.getGateIo().equals("")) {
					if (eventScc.equals(delScc)) {
						returnValue = "CI";
					} else {
						returnValue = "CO";
					}
				}
			}
		}
		if (dom_mvmt.equals("CO") && dom_bkg.equals("TCHIDUMMYBKG")) {
			if (flatFileForGateNewVO.getDestLoc().length() > 0) { 
				if (dom_in_Scc.equals(dest_scc)) {
					returnValue = "CT";
					flatFileForGateNewVO.setBkgNumber0("");
					flatFileForGateNewVO.setEdiBkgNo("");
				} else {
					returnValue = "CE";
					flatFileForGateNewVO.setBkgNumber0("");
					flatFileForGateNewVO.setEdiBkgNo("");
				}
			} else {
				returnValue = "CT";
				flatFileForGateNewVO.setBkgNumber0("");
				flatFileForGateNewVO.setEdiBkgNo("");
			}
		}
		return returnValue;
	}

	/**
	 * Container Movement Status 판정<br>
	 *  decideChassisStatus for GateNew<br>
	 *
	 * @param String gateIo
	 * @return String
	 *
	 * chs_dbup.pc
	 **/
	private String decideChassisStatus( String gateIo ) {
		String mvmtStatus = "";
		if ( gateIo.equals("A") || gateIo.equals("I") || gateIo.equals("AR") || gateIo.equals("N") || gateIo.equals("UR") ) {
			mvmtStatus = "BI";

		} else if ( gateIo.equals("AL") || gateIo.equals("AO") || gateIo.equals("D") || gateIo.equals("OA")
				 || gateIo.equals("P") || gateIo.equals("RL") || gateIo.equals("O") ) {

			mvmtStatus = "BO";

		}
		return mvmtStatus;
	}

	/**
	 * setEnTn for GateNew<br>
	 *
	 * @param String eventLoc
	 * @param String destLoc
	 * @return String
	 * @exception EventException
	 **/
	private String setEnTn( String eventLoc, String destLoc ) throws EventException {
		String eventLccCode = getLccSccOf( "LCC_CD", eventLoc );
		String destLccCode = getLccSccOf( "LCC_CD", destLoc );
		String returnValue = "";

		if ( (eventLccCode == null || eventLccCode.equals("")) || (destLccCode == null || destLccCode.equals("")) ) {
			returnValue = "ER";

		} else if ( !eventLccCode.equals(destLccCode) ) {
			returnValue = "EN";

		} else {
			returnValue = "TN";
		}
		return returnValue;
	}

	/**
	 * getLccSccOf for GateNew<br>
	 *
	 * @param String lccScc
	 * @param String locCode
	 * @return String
	 * @exception EventException
	 **/
	private String getLccSccOf( String lccScc, String locCode ) throws EventException {
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.searchLccScc(" + lccScc + ")" +
					  "\n===============================================================\n");
			return dbDao.searchLccScc(lccScc, subStr(locCode, 0, 5));
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.searchLccScc(lccScc)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.searchLccScc(lccScc)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * checkLocCd for GateNew<br>
	 *
	 * @param String locCode
	 * @return Boolean
	 * @exception EventException
	 **/
	private Boolean checkLocCd( String locCode ) throws EventException {

		String returnValue = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.searchCodeExist(LOC_CD)" +
					  "\n===============================================================\n");
			returnValue = dbDao.searchCodeExistForGateNew("MDM_LOCATION", "LOC_CD", locCode);
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.searchCodeExist(LOC_CD)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.searchCodeExist(LOC_CD)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if ( returnValue == null || returnValue.equals("") ) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * getPolCodeOf for GateNew<br>
	 *
	 * @param String columnNm
	 * @param String codeValue
	 * @return String
	 * @exception EventException
	 **/
	private String getPolCodeOf( String columnNm, String codeValue ) throws EventException {

		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.getCodeValue(POL_CD)" +
					  "\n===============================================================\n");
			return dbDao.getCodeValueForGateNew("BKG_BOOKING", columnNm, "POL_CD", codeValue);
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.getCodeValue(POL_CD)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.getCodeValue(POL_CD)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

	}

    /*=========================================================
     * 2010.09.30 이석준 [CHM-201006067-01] Split 01-[MDM]Location 평택(KRPYT->KRPTK) 정제 관련 작업 요청
     *                   (ID Code 생성시에 신규 코드인 KRPTK 역시 생성될수 있도록 조건 추가)
     * 2013-06-19 강환 [CHM-201325165] EUR 지역 ID/EN 생성 logic  변경 (AT/CH/DK추가)
     *=========================================================*/
	/**
	 * setIdEnTnOther for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @param String destLoc
	 * @param String dlvTerm
	 * @return String
	 * @exception EventException
	 **/
	private String setIdEnTnOther( FlatFileForGateNewVO flatFileForGateNewVO, String destLoc, String dlvTerm ) throws EventException {

		log.info("\n\n===============================================================" +
				  "\n destSccCode(destSccCode)[EnTnOth]" +
				  "\n===============================================================\n");
		String destSccCode = getLccSccOf( "SCC_CD", destLoc );
		log.info("\n\n===============================================================" +
				  "\n eventSccCode(eventSccCode)[EnTnOth]" +
				  "\n===============================================================\n");
		String eventSccCode = getLccSccOf( "SCC_CD", flatFileForGateNewVO.getEventYard() );

		// [CHM-201326799] 2013.11.25 (S)
		String tmpRcc = "";
		tmpRcc = getLccSccOf( "RCC_CD", flatFileForGateNewVO.getEventYard() ); 
		String tmpCh = "";
		try { // Carrier`s Haulage 조회 
			log.debug("\n\n===============================================================" +
					  "\n dbDao.searchBkgTroInbound(BkgNumber,CntrNo)" +
					  "\n===============================================================\n");
			tmpCh = dbDao.searchBkgTroInbound( flatFileForGateNewVO.getBkgNumber()[0], flatFileForGateNewVO.getCntrNumber());
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.searchBkgTroInbound(BkgNumber,CntrNo)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.searchBkgTroInbound(BkgNumber,CntrNo)] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		
		if((tmpRcc != null && tmpRcc.equals("DEHAM")) && (tmpCh != null && tmpCh.equals("C"))
				&& (flatFileForGateNewVO.getSightCd() != null && flatFileForGateNewVO.getSightCd().equals("I"))) {
			
			try { // FM_NOD_CD 와 TO_NOD_CD or VIA_NOD_CD 를 조회
				//1. From Nod 비교하여 같고 VIA_NOD_CD가 NULL이면 ID,
				//2. From Nod 비교하여 다르고 VIA_NOD_CD가 같으면 ID, 
				//3. From Nod 비교하여 같고 VIA_NOD_CD가 다르면 EN/TN, 
				//4. TRSP_COST_DTL_MOD_CD가 TS/LS 면 EN/TN 생성 하기 
				log.debug("\n\n===============================================================" +
						  "\n dbDao.searchTrspOrderInbound(BkgNumber,CntrNo,EventYard,EventDate,Gubun)" +
						  "\n===============================================================\n");
				String[] rtn = new String[2];
				//1. From Nod 비교하여 같고 VIA_NOD_CD가 NULL이면 ID
				rtn = dbDao.searchTrspOrderInbound(flatFileForGateNewVO.getBkgNumber()[0], flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getEventYard(), flatFileForGateNewVO.getEventDate(), "1");
				if(rtn != null){ // 결과가 있으면 조건에 걸린 거임
					return "ID";
				}else{
					//2. From Nod 비교하여 다르고 VIA_NOD_CD가 같으면 ID, 
					rtn = dbDao.searchTrspOrderInbound(flatFileForGateNewVO.getBkgNumber()[0], flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getEventYard(), flatFileForGateNewVO.getEventDate(), "2");
					if(rtn != null){
						return "ID";
					}else{
						//3. From Nod 비교하여 같고 VIA_NOD_CD가 다르면 EN/TN, 
						rtn = dbDao.searchTrspOrderInbound(flatFileForGateNewVO.getBkgNumber()[0], flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getEventYard(), flatFileForGateNewVO.getEventDate(), "3");
						if(rtn != null){
							return setEnTn( flatFileForGateNewVO.getEventYard(), rtn[1]); // EN/TN 판정, rtn[1] 은 VIA_NOD_CD 임
						}else{
							//4. TRSP_COST_DTL_MOD_CD가 TS/LS 면 EN/TN 생성 하기
							rtn = dbDao.searchTrspOrderInbound(flatFileForGateNewVO.getBkgNumber()[0], flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getEventYard(), flatFileForGateNewVO.getEventDate(), "4");
							if(rtn != null){
								return setEnTn( flatFileForGateNewVO.getEventYard(), rtn[0]); // EN/TN 판정, rtn[0] 은 TO_NOD_CD 임
							}
							else
							{
								// 2014-01-27 강 환  [CHM-201328274] EUR지역 SO를 통한 ID,ENTN 판정 logic(추가)
								rtn = dbDao.searchTrspOrderInboundFromTo(flatFileForGateNewVO.getBkgNumber()[0], flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getEventYard(), flatFileForGateNewVO.getEventDate());
								if(rtn != null){
									return setEnTn( flatFileForGateNewVO.getEventYard(), rtn[0]); // EN/TN 판정, rtn[0] 은 TO_NOD_CD 임
								}
							}
						}
					}
				}
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.searchBkgTroInbound(BkgNumber,CntrNo)] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.searchBkgTroInbound(BkgNumber,CntrNo)] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}
		}
		// [CHM-201326799] 2013.11.25 (E)

		// 2014-02-07 강 환 [CHM-201428467] Asis지역 IB 화물 ID_EN(TN)에 대한 SO 확인 logic 추가
		else if((tmpRcc != null && !tmpRcc.equals("DEHAM") && !tmpRcc.equals("NYCNA"))
				&& (flatFileForGateNewVO.getSightCd() != null && flatFileForGateNewVO.getSightCd().equals("I"))) {
			
			try { // FM_NOD_CD 와 TO_NOD_CD or VIA_NOD_CD 를 조회
				//1. From Nod 비교하여 같고 VIA_NOD_CD가 NULL이면 ID,
				//2. From Nod 비교하여 다르고 VIA_NOD_CD가 같으면 ID, 
				//3. From Nod 비교하여 같고 VIA_NOD_CD가 다르면 EN/TN, 
				//4. TRSP_COST_DTL_MOD_CD가 TS/LS 면 EN/TN 생성 하기 
				log.debug("\n\n===============================================================" +
						  "\n dbDao.searchTrspOrderInbound(BkgNumber,CntrNo,EventYard,EventDate,Gubun)" +
						  "\n===============================================================\n");
				String[] rtn = new String[2];
				//1. From Nod 비교하여 같고 VIA_NOD_CD가 NULL이면 ID
				rtn = dbDao.searchTrspOrderInbound(flatFileForGateNewVO.getBkgNumber()[0], flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getEventYard(), flatFileForGateNewVO.getEventDate(), "1");
				if(rtn != null){ // 결과가 있으면 조건에 걸린 거임
					return "ID";
				}else{
					//2. From Nod 비교하여 다르고 VIA_NOD_CD가 같으면 ID, 
					rtn = dbDao.searchTrspOrderInbound(flatFileForGateNewVO.getBkgNumber()[0], flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getEventYard(), flatFileForGateNewVO.getEventDate(), "2");
					if(rtn != null){
						return "ID";
					}else{
						//3. From Nod 비교하여 같고 VIA_NOD_CD가 다르면 EN/TN, 
						rtn = dbDao.searchTrspOrderInbound(flatFileForGateNewVO.getBkgNumber()[0], flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getEventYard(), flatFileForGateNewVO.getEventDate(), "3");
						if(rtn != null){
							return setEnTn( flatFileForGateNewVO.getEventYard(), rtn[1]); // EN/TN 판정, rtn[1] 은 VIA_NOD_CD 임
						}else{
							//4. TRSP_COST_DTL_MOD_CD가 TS/LS 면 EN/TN 생성 하기
							rtn = dbDao.searchTrspOrderInbound(flatFileForGateNewVO.getBkgNumber()[0], flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getEventYard(), flatFileForGateNewVO.getEventDate(), "4");
							if(rtn != null){
								return setEnTn( flatFileForGateNewVO.getEventYard(), rtn[0]); // EN/TN 판정, rtn[0] 은 TO_NOD_CD 임
							}
							else
							{
								// 2014-01-27 강 환  [CHM-201328274] EUR지역 SO를 통한 ID,ENTN 판정 logic(추가)
								rtn = dbDao.searchTrspOrderInboundFromTo(flatFileForGateNewVO.getBkgNumber()[0], flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getEventYard(), flatFileForGateNewVO.getEventDate());
								if(rtn != null){
									return setEnTn( flatFileForGateNewVO.getEventYard(), rtn[0]); // EN/TN 판정, rtn[0] 은 TO_NOD_CD 임
								}
							}
						}
					}
				}
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.searchBkgTroInbound(BkgNumber,CntrNo)] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.searchBkgTroInbound(BkgNumber,CntrNo)] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}
		}

		// [CHM-201428467] 2014.02.07 (E)
		
		if ( (eventSccCode == null || eventSccCode.equals("")) || (destSccCode == null || destSccCode.equals("")) ) {
			return "ER";

		} else if ( destSccCode.equals(eventSccCode) || "KRPYT".equals(eventSccCode) || "KRPTK".equals(eventSccCode) ) {
			return "ID";
		}

		log.info("\n\n===============================================================" +
				  "\n destLccCode(eventYard)[EnTnOth]" +
				  "\n===============================================================\n");
		String destLccCode = getLccSccOf( "LCC_CD", destLoc );
		log.info("\n\n===============================================================" +
				  "\n eventLccCode(destLoc)[EnTnOth]" +
				  "\n===============================================================\n");
		String eventLccCode = getLccSccOf( "LCC_CD", flatFileForGateNewVO.getEventYard() );

		if ( eventLccCode.equals(destLccCode) ) {
			if ( ("DEHAM".equals(subStr(flatFileForGateNewVO.getEventYard(), 0, 5)) || "DEBRV".equals(subStr(flatFileForGateNewVO.getEventYard(), 0, 5))) && "D".equals(dlvTerm) && "F".equals(flatFileForGateNewVO.getContStat()) ) {
				return "ID";

			} else {
				return	"TN";
			}

		} else {
			if ( "EUR".equals(flatFileForGateNewVO.getMuidArea()) && "D".equals(dlvTerm) && "F".equals(flatFileForGateNewVO.getContStat()) ) {

				// 2013-06-19 강환 [CHM-201325165] EUR 지역 ID/EN 생성 logic  변경 (AT/CH/DK추가)
				if ( ("DEHAM".equals(subStr(flatFileForGateNewVO.getEventYard(), 0, 5)) || "DEBRV".equals(subStr(flatFileForGateNewVO.getEventYard(), 0, 5)))
//				  && ("HU".equals(subStr(destLoc, 0, 2)) || "PL".equals(subStr(destLoc, 0, 2)) || "CZ".equals(subStr(destLoc, 0, 2)) || "SK".equals(subStr(destLoc, 0, 2))) ) {
				  && ("HU".equals(subStr(destLoc, 0, 2)) || "PL".equals(subStr(destLoc, 0, 2)) || "CZ".equals(subStr(destLoc, 0, 2)) || "SK".equals(subStr(destLoc, 0, 2)) 
				  	  || "AT".equals(subStr(destLoc, 0, 2)) || "CH".equals(subStr(destLoc, 0, 2)) || "DK".equals(subStr(destLoc, 0, 2))) ) {
					return "EN";

				} else {
					return "ID";

				}
			} else {
				return "EN";
			}
		}
	}

	/**
	 * setIdEnTn322 for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @param String destLoc
	 * @param String dlvTerm
	 * @return String
	 * @exception EventException
	 **/
	private String setIdEnTn322( FlatFileForGateNewVO flatFileForGateNewVO, String destLoc, String dlvTerm ) throws EventException {

		log.info("\n\n===============================================================" +
				  "\n destSccCode(eventYard)[EnTn322]" +
				  "\n===============================================================\n");
		String destSccCode = getLccSccOf( "SCC_CD", destLoc );
		log.info("\n\n===============================================================" +
				  "\n eventSccCode(destLoc)[EnTn322]" +
				  "\n===============================================================\n");
		String eventSccCode = getLccSccOf( "SCC_CD", flatFileForGateNewVO.getEventYard() );

		if ( (eventSccCode == null || eventSccCode.equals("")) || (destSccCode == null || destSccCode.equals("")) ) {
			return "ER";

		} else if ( !"AL".equals(flatFileForGateNewVO.getGateIo())
			   && ( destSccCode.equals(eventSccCode) || ( "USLGB".equals(eventSccCode) && "USLAX".equals(destSccCode))
			   || ( "USORF".equals(eventSccCode) && "USGSA".equals(destSccCode) && "D".equals(dlvTerm))) ) {

			return "ID";

		}

		log.info("\n\n===============================================================" +
				  "\n destLccCode(eventYard)[EnTn322]" +
				  "\n===============================================================\n");
		String destLccCode = getLccSccOf( "LCC_CD", destLoc );
		log.info("\n\n===============================================================" +
				  "\n eventLccCode(destLoc)[EnTn322]" +
				  "\n===============================================================\n");
		String eventLccCode = getLccSccOf( "LCC_CD", flatFileForGateNewVO.getEventYard() );

		if ( (eventLccCode == null || eventLccCode.equals("")) || (destLccCode == null || destLccCode.equals("")) ) {
			return "ER";

		} else if ( eventLccCode.equals(destLccCode) ) {
			if ( !"AL".equals(flatFileForGateNewVO.getGateIo()) && "D".equals(dlvTerm) && ( "F".equals(flatFileForGateNewVO.getContStat()) || "AH".equals(flatFileForGateNewVO.getContStat())) ) {
				if ( "US".equals(subStr(flatFileForGateNewVO.getEventYard(), 0, 2)) ) {
					log.info("\n\n===============================================================" +
							  "\n @getIRGsts" +
							  "\n===============================================================\n");
					if ( getIRGsts(flatFileForGateNewVO) ) {		/* 2010 Get_IRGsts !!!!!! 처리 ?? */
						return "TN";

					} else {
						return "ID";

					}
				} else {
					return "ID";

				}
			} else {
				return "TN";

			}
		} else {
			if ( !"AL".equals(flatFileForGateNewVO.getGateIo()) && "D".equals(dlvTerm) && ( "F".equals(flatFileForGateNewVO.getContStat()) || "AH".equals(flatFileForGateNewVO.getContStat())) ) {
				if ( "US".equals(subStr(flatFileForGateNewVO.getEventYard(), 0, 2)) ) {
					log.debug("\n\n===============================================================" +
							  "\n @getIRGsts" +
							  "\n===============================================================\n");
					if ( getIRGsts(flatFileForGateNewVO) ) {		/* 2010 Get_IRGsts !!!!!! 처리 ?? */
						return "EN";

					} else {
						return "ID";

					}
				} else {
					return "EN";

				}
			} else {
				return "EN";

			}
		}
	}

	/**
	 * getIRGsts for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @return Boolean
	 * @exception EventException
	 **/
	private Boolean getIRGsts( FlatFileForGateNewVO flatFileForGateNewVO ) throws EventException {

		String returnValue = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.searchTrspModCode(getIRGsts)" +
					  "\n===============================================================\n");
			returnValue = dbDao.searchTrspModCode( flatFileForGateNewVO.getBkgNumber()[0], flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getEventYard() );
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.searchTrspModCode(getIRGsts)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.searchTrspModCode(getIRGsts)] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if ( returnValue == null || returnValue.equals("") ) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * checkBkgNo for GateNew<br>
	 *
	 * @param String bkgNumber
	 * @return Boolean
	 * @exception EventException
	 **/
	private Boolean checkBkgNo( String bkgNumber ) throws EventException {

		String returnValue = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.checkBkgNoForGateNew(checkBkgNo)" +
					  "\n===============================================================\n");
			returnValue = dbDao.checkBkgNoForGateNew( bkgNumber );
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.checkBkgNoForGateNew(checkBkgNo)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.checkBkgNoForGateNew(checkBkgNo)] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if ( returnValue == null || returnValue.equals("") ) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * 해당 DateTime(영문월표시)를 반환<BR>
	 *
	 * @param String eventDate
	 * @return String
	 */
/*
	private String convertDatetime( String eventDate ) {
		String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		String returnValue = "";
		if ( eventDate == null || eventDate.equals("") ) {
			returnValue = DateTime.getFormatDate(new Date(), "ddMMyy HH:mm");
		} else  {
			if ( DateTime.isValid(eventDate, "yyyyMMddHHmmss") ) {
				returnValue = DateTime.getFormatDate(eventDate, "yyyyMMddHHmmss", "ddMMyy HH:mm");
			} else {
				returnValue = DateTime.getFormatDate(new Date(), "ddMMyy HH:mm");
			}
		}
		String strMonth = monthNames[Integer.parseInt(returnValue, 2, 4))-1];
		return returnValue, 0, 2) + strMonth + returnValue, 4);
	}
*/

	/**
	 * 지정한 subString수보다 전체글자수가 작으면 전체글자수만큼 subString 반환<BR>
	 *
	 * @param String str
	 * @param int beginIndex
	 * @param int endIndex
	 * @return String
	 */
	private String subStr( String str, int beginIndex, int endIndex ) {
		str = ( (str == null || str.trim().equals("")) ? "" : str.trim() + "" );
		int firstIndex = str.length() < beginIndex ? str.length() : beginIndex;
		int lastIndex = str.length() < endIndex ? str.length() : endIndex;
		return str.substring(firstIndex, lastIndex);
	}

	/**
	 * 영문자여부 체크 (1글자)<BR>
	 *
	 * @param String str
	 * @return Boolean
	 */
	public Boolean isAlpha( String str ) {
		if ( str == null || str.equals("") ) return false;
		char ch = str.charAt(0);
		if ( (ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122) ) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 숫자여부 체크 (단어)<BR>
	 *
	 * @param String str
	 * @return Boolean
	 */
	private Boolean isNumeric( String str ) {
		boolean returnValue = true;
		if ( str == null || str.equals("") ) {
			returnValue = false;
		}else {
			for ( int i=0; i<str.length() ; i++ ) {
				char ch = str.charAt(i);
				if ( ch < 48 || ch > 59 ) {
					returnValue = false;
					break;
				}
			}
		}
		return returnValue;
	}

	/**
	 * ACIAC_DIV_CD 체크
	 * GateNew의 checkNassignData / EES_CTM_0404의 manageEDIMovement에서 공통사용<br>
	 *
	 * @param String cntrNumber
	 * @param String bkgNumber
	 * @return String[]
	 * @throws DAOException,Exception
	 */
	public String[] checkAciacDivCd(String cntrNumber, String bkgNumber) throws DAOException,Exception {
		String[] returnValues = new String[4];
		returnValues[0] = "";    // ResultMessage
		returnValues[1] = "";    // ResultIndicator
		returnValues[2] = "";    // checkAciacDivCdYN(Y/N)
		returnValues[3] = "";    // cntrTpszCd

//		EXEC SQL
//		SELECT  ACIAC_DIV_CD,	LSTM_CD,		CNTR_STS_CD,	CNTR_TPSZ_CD /*2010.02.17 By IHChang*/, HJS_CRE_FLG /*2010.05.17 신조장비로직추가*/
//		FROM	MST_CONTAINER
//		INTO	:actStatus,		:leaseTerm,		:cntrStsCd,		:FlatFileVO.cntrTpszCd,		:hjsCreFlg
//		WHERE	CNTR_NO		=	FlatFileVO.cntrNumber

		String[] daoReturns = new String[5];
		String actStatus = "";
		String leaseTerm = "";
		String cntrStsCd = "";
		String cntrTpszCd = "";
		String hjsCreFlg = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.getAciacDivCd" +
					  "\n===============================================================\n");
			daoReturns = dbDao.getAciacDivCd(cntrNumber);
			actStatus = daoReturns[0];
			leaseTerm = daoReturns[1];
			cntrStsCd = daoReturns[2];
			cntrTpszCd = daoReturns[3];
			hjsCreFlg = daoReturns[4];
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.getAciacDivCd] DAOerr : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.getAciacDivCd] err : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}

		if ( (actStatus == null || "".equals(actStatus)) &&
			 (leaseTerm == null || "".equals(leaseTerm)) &&
			 (cntrStsCd == null || "".equals(cntrStsCd)) &&
			 (cntrTpszCd == null || "".equals(cntrTpszCd)) &&
			 (hjsCreFlg == null || "".equals(hjsCreFlg)) ) {

			if ( "SMCU".equals(subStr(cntrNumber, 0, 4)) || "SENU".equals(subStr(cntrNumber, 0, 4)) ) {
				returnValues[0] = "Wrong container no";
				returnValues[1] = "N";

			} else {
				String daoReturn = "";
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.searchCodeExist(SUBSTR(OFC_CD,1,3))" +
							  "\n===============================================================\n");
					daoReturn = dbDao.searchCodeExistForGateNew("MDM_ORGANIZATION", "SUBSTR(OFC_CD, 1, 3)", subStr(bkgNumber, 0, 3));
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.searchCodeExist(SUBSTR(OFC_CD,1,3))] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.searchCodeExist(SUBSTR(OFC_CD,1,3))] err : " + ex.toString(), ex);
					throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
				}

				if (daoReturn != null && !"".equals(daoReturn)) {
					returnValues[0] = "Mis use in or SOC container";
					returnValues[1] = "N";

				} else {
					returnValues[0] = "Other company's container";
					returnValues[1] = "X";

				}
			}
			returnValues[2] = "N";

		} else {
			returnValues[3] = cntrTpszCd;
			if ( "I".equals(actStatus) && "N".equals(hjsCreFlg) ) {    // 2010.15.17 신조장비 로직추가
				if ( "SH".equals(leaseTerm) || "MU".equals(leaseTerm) ) {
					returnValues[0] = "Inactive container (Ignored)";
					returnValues[1] = "I";

				} else if ( "DON".equals(cntrStsCd) || "SCR".equals(cntrStsCd) || "SLD".equals(cntrStsCd) || "TTL".equals(cntrStsCd) ) {
					returnValues[0] = "Inactive container (Ignored)";
					returnValues[1] = "I";

				} else {
					returnValues[0] = "Inactive container";
					returnValues[1] = "N";

				}
				returnValues[2] = "N";

			}
		}

		// returnValues[0] : ResultMessage
		// returnValues[1] : ResultIndicator
		// returnValues[2] : checkAciacDivCdYN(Y/N)
		// returnValues[3] : cntrTpszCd
		return returnValues;
	}

	/**
	 * getAmsLoc for GateNew<br>
	 *
	 * @param String locCd
	 * @return String
	 * @exception EventException
	 **/
	private String getAmsLoc( String locCd ) throws EventException {

		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.getCodeValue(CTM_AMS_LOC)" +
					  "\n===============================================================\n");
			return dbDao.getCodeValueForGateNew("CTM_AMS_LOC", "LOC_AMS_PORT_CD", "LOC_CD", locCd);
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.getCodeValue(CTM_AMS_LOC)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.getCodeValue(CTM_AMS_LOC)] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

	}

	/**
	 * checkNassignData for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @return Boolean
	 * @exception EventException
	 *
	 * F_DB_CHECK
	 * @throws ParseException
	 **/
	private Boolean checkNassignData( FlatFileForGateNewVO flatFileForGateNewVO ) throws EventException {

		String returnValue = "";
		if ( flatFileForGateNewVO.getMsgId().equals("322") || flatFileForGateNewVO.getMuidArea().equals("USA") ) {

			// POL
			if ( (flatFileForGateNewVO.getPol() != null && !flatFileForGateNewVO.getPol().equals("")) && isNumeric(flatFileForGateNewVO.getPol()) ) {

//				EXEC SQL
//				SELECT	LOC_CD
//				INTO	:FlatFileVO.pol
//				FROM	CTM_AMS_LOC
//				WHERE	LOC_AMS_PORT_CD = :FlatFileVO.pol
//				AND		ROWNUM	=	1

				log.debug("\n\n===============================================================" +
						  "\n @getAmsLoc(CTM_AMS_LOC by POL)" +
						  "\n===============================================================\n");
				returnValue = getAmsLoc(flatFileForGateNewVO.getPol());

// CTM_AMS_LOC 테이블에 DATA가 완전 하지 않은 관계로 임시처리
				if ( returnValue != null && !returnValue.equals("") ) {
					flatFileForGateNewVO.setPol(returnValue);
				}
			}

			// POD
			if ( (flatFileForGateNewVO.getPod() != null && !flatFileForGateNewVO.getPod().equals("")) && isNumeric(flatFileForGateNewVO.getPod()) ) {

//				EXEC SQL
//				SELECT	LOC_CD
//				INTO	:FlatFileVO.pod
//				FROM	CTM_AMS_LOC
//				WHERE	LOC_AMS_PORT_CD = :FlatFileVO.pod
//				AND		ROWNUM	=	1

				log.debug("\n\n===============================================================" +
						  "\n @getAmsLoc(CTM_AMS_LOC by POD)" +
						  "\n===============================================================\n");
				returnValue = getAmsLoc(flatFileForGateNewVO.getPod());

// CTM_AMS_LOC 테이블에 DATA가 완전 하지 않은 관계로 임시처리
				if ( returnValue != null && !returnValue.equals("") ) {
					flatFileForGateNewVO.setPod(returnValue);
				}
			}

			// DESTLOC
			if ( (flatFileForGateNewVO.getDestLoc() != null && !flatFileForGateNewVO.getDestLoc().equals("")) && isNumeric(flatFileForGateNewVO.getDestLoc()) ) {

//				EXEC SQL
//				SELECT	LOC_CD
//				INTO	:FlatFileVO.destLoc
//				FROM	CTM_AMS_LOC
//				WHERE	LOC_AMS_PORT_CD = :FlatFileVO.destLoc
//				AND		ROWNUM	=	1

				log.debug("\n\n===============================================================" +
						  "\n @getAmsLoc(CTM_AMS_LOC by DESTLOC)" +
						  "\n===============================================================\n");
				returnValue = getAmsLoc(flatFileForGateNewVO.getDestLoc());

// CTM_AMS_LOC 테이블에 DATA가 완전 하지 않은 관계로 임시처리
				if ( returnValue != null && !returnValue.equals("") ) {
					flatFileForGateNewVO.setDestLoc(returnValue);
				}
			}

		}

/* 2010 ___________________________________________________________> Logic From @ALL_Data_Update */

//		EXEC SQL
//		SELECT	TO_CHAR(TO_DATE(:FlatFileVO.eventDate,"YYYYMMDDHH24MI"),"DDMonrr HH24:MI")
//		INTO	:FlatFileVO.eventDate
//		FROM	DUAL;

		if ( !DateTime.isValid(flatFileForGateNewVO.getEventDate(), "yyyyMMddHHmm") ) {

			/* 20100316 By DSLee (S) */
			flatFileForGateNewVO.setResultMessage("Invalid Event date [" + flatFileForGateNewVO.getEventDate() + "]");
			flatFileForGateNewVO.setResultIndicator("N");
			return false;
			/* 20100316 By DSLee (E) */

/*
// 임시주석 (S) ==========================================
//			EXEC SQL
//			SELECT  GLOBALDATE_PKG.TIME_CONV_FNC ('KRPUS', sysdate, SUBSTR (:FlatFileVO.eventYard, 0, 5))
//			INTO	:FlatFileVO.eventDate
//			FROM    DUAL

			returnValue = "";
			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getLocalTime" +
						  "\n===============================================================\n");
				returnValue = dbDao.getLocalTime( flatFileForGateNewVO.getEventYard() );
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getLocalTime] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getLocalTime] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			if (returnValue != null && !returnValue.equals("")) {
				flatFileForGateNewVO.setEventDate(returnValue);
			}
// 임시주석 (E) ==========================================
*/
		}

		if ( !flatFileForGateNewVO.getCarrierCode().equals("") &&  (flatFileForGateNewVO.getMsgId().equals("322") || flatFileForGateNewVO.getMsgId().equals("COD")) ) {

//			EXEC SQL
//			SELECT   VNDR_SEQ
//			INTO	 :FlatFileVO.vndr_seq
//			FROM	 MMD_VENDOR
//			WHERE	USA_EDI_CD = SUBSTR(:FlatFileVO.carrierCode,1,4)
//			AND	  DELT_FLG <> "Y";

			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getVendorSeq" +
						  "\n===============================================================\n");
				flatFileForGateNewVO.setVndrSeq(dbDao.getVendorSeq(flatFileForGateNewVO.getCarrierCode()));
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getVendorSeq] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getVendorSeq] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}
		}

//		EXEC SQL
//		SELECT	NVL(TRIM(:FlatFileVO.cntrNumber)," ")
//		INTO	:FlatFileVO.cntrNumber
//		FROM	DUAL;

		if ( flatFileForGateNewVO.getCntrNumber() == null ) flatFileForGateNewVO.setCntrNumber("");

		if ( flatFileForGateNewVO.getChssCase().equals("Y") && (isAlpha(subStr(flatFileForGateNewVO.getCntrNumber(), 0, 1))) ) {    /* Bare Chassis Number Adjustment */

//			EXEC SQL
//			SELECT	SUBSTR(:FlatFileVO.cntrNumber,1,4) || LPAD( SUBSTR(:FlatFileVO.cntrNumber,5,10),6,'0')
//			INTO	:FlatFileVO.cntrNumber
//			FROM	DUAL

			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.defineChssCode(flatFileVo.getCntrNumber)" +
						  "\n===============================================================\n");
				flatFileForGateNewVO.setCntrNumber(dbDao.defineChssCode(flatFileForGateNewVO.getCntrNumber()));
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.defineChssCode] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.defineChssCode] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}
		}

		if( isAlpha(subStr(flatFileForGateNewVO.getChssCode(), 0, 1)) ) {    /* Chassis Number Adjustment */

//			EXEC SQL
//			SELECT	SUBSTR(:FlatFileVO.chssCode,1,4) || LPAD( SUBSTR(:FlatFileVO.chssCode,5,10),6,"0")
//			INTO	:FlatFileVO.chssCode);
//			FROM	DUAL;

			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.defineChssCode(flatFileVo.getChssCode)" +
						  "\n===============================================================\n");
				flatFileForGateNewVO.setChssCode(dbDao.defineChssCode(flatFileForGateNewVO.getChssCode()));
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.defineChssCode] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.defineChssCode] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

//			EXEC SQL
//			SELECT	EQ_NO
//			FROM	CGM_EQUIPMENT
//			WHERE	EQ_NO = rtrim(:FlatFileVO.chssCode);

			returnValue = "";
			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getCodeValue(EQ_NO)" +
						  "\n===============================================================\n");
				returnValue = dbDao.getCodeValueForGateNew("CGM_EQUIPMENT", "EQ_NO", "EQ_NO", flatFileForGateNewVO.getChssCode());
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getCodeValue(EQ_NO)] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getCodeValue(EQ_NO)] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			if ( returnValue == null || returnValue.equals("") ) {

//				EXEC SQL
//				SELECT	EQ_NO
//				INTO	:FlatFileVO.chssCode
//				FROM	CGM_EQUIPMENT
//				WHERE	(
//							CHSS_ALS_NO = rtrim(:FlatFileVO.chssCode)
//							OR
//							N2ND_CHSS_ALS_NO = rtrim(:FlatFileVO.chssCode)

				returnValue = "";
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.getEqNo" +
							  "\n===============================================================\n");
					returnValue = dbDao.getEqNo(flatFileForGateNewVO.getChssCode());
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.getEqNo] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.getEqNo] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}
			}
		}

		/* 2010 <_________________________________________________________Logic From @ALL_Data_Update */

		// if ( FlatFileVO.chssCase = FALSE )
		if ( flatFileForGateNewVO.getChssCase() == null || flatFileForGateNewVO.getChssCase().equals("") || flatFileForGateNewVO.getChssCase().equals("N") ) {

			String[] checkAciacDivCdYN = new String[4];
			try {
				log.debug("\n\n===============================================================" +
						  "\n @checkAciacDivCd" +
						  "\n===============================================================\n");
				checkAciacDivCdYN = checkAciacDivCd(flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getBkgNumber()[0]);
				// checkAciacDivCdYN[0] : ResultMessage
				// checkAciacDivCdYN[1] : ResultIndicator
				// checkAciacDivCdYN[2] : checkAciacDivCdYN(Y/N)
				// checkAciacDivCdYN[3] : cntrTpszCd
			} catch (Exception ex) {
				log.error("[GATENEW : @checkAciacDivCd err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			flatFileForGateNewVO.setCntrTpszCd(checkAciacDivCdYN[3] == null ? "" : String.valueOf(checkAciacDivCdYN[3]).trim());

			if ( checkAciacDivCdYN[2].equals("N") ) {
				flatFileForGateNewVO.setResultMessage(checkAciacDivCdYN[0]);
				flatFileForGateNewVO.setResultIndicator(checkAciacDivCdYN[1]);
				return false;
			}

			if ( flatFileForGateNewVO.getEventYard().equals("USSLCR2") || flatFileForGateNewVO.getEventYard().equals("USTYSR3") || flatFileForGateNewVO.getEventYard().equals("USJANKC") ) {
				flatFileForGateNewVO.setResultMessage("Ignored Yard(USSLCR2, USTYSR3, USJANKC)");
				flatFileForGateNewVO.setResultIndicator("X");
				return false;
			}

			if ( flatFileForGateNewVO.getSightCd().equals("X") ) {
				flatFileForGateNewVO.setResultMessage("Rehandling (X)");
				flatFileForGateNewVO.setResultIndicator("X");
				return false;
			}

			if ( flatFileForGateNewVO.getTermId().equals("UP") && flatFileForGateNewVO.getGateIo().equals("A") ) {
				flatFileForGateNewVO.setResultMessage("UP, Arrival other than final dest");
				flatFileForGateNewVO.setResultIndicator("X");
				return false;
			}

			if ( flatFileForGateNewVO.getGateIo().equals("OB") ) {
				flatFileForGateNewVO.setResultMessage("Received of 404 bill of lading and created a shipment for the container");
				flatFileForGateNewVO.setResultIndicator("X");
				return false;
			}

			if ( subStr(flatFileForGateNewVO.getEventYard(), 0, 5).equals("CNHKG") && subStr(flatFileForGateNewVO.getCallSignNo(), 0, 5).equals("MIXED") &&  flatFileForGateNewVO.getMvmtStatus().equals("VL") ) {
				flatFileForGateNewVO.setResultMessage("Mixed barge");
				flatFileForGateNewVO.setResultIndicator("X");
				return false;
			}

			/* 2010.05.26 -  TRANS_MODE : X 이고, GateIO : O 에 대해서 Ignored 처리 - Rqst by DSLee */
			if ( flatFileForGateNewVO.getTransMode().equals("X") && flatFileForGateNewVO.getGateIo().equals("O") ) {
				flatFileForGateNewVO.setResultMessage("Mixed barge");
				flatFileForGateNewVO.setResultIndicator("X");
				return false;
			}

			if ( flatFileForGateNewVO.getGateIo().equals("9") ) {
				flatFileForGateNewVO.setResultMessage("EQ STATUS CHANGE");
				flatFileForGateNewVO.setResultIndicator("X");
				return false;
			}

			/* 2010.03.15 By DSLee */
			if ( (flatFileForGateNewVO.getMuidArea().equals("USA") && flatFileForGateNewVO.getMsgId().equals("322"))
			  && (flatFileForGateNewVO.getGateIo().equals("CB") || flatFileForGateNewVO.getGateIo().equals("CC") || flatFileForGateNewVO.getGateIo().equals("SA") || flatFileForGateNewVO.getGateIo().equals("SC")) ) {
				flatFileForGateNewVO.setResultMessage("Not for movement(CB,CC,SA,SC)");
				flatFileForGateNewVO.setResultIndicator("X");
				return false;
			}
			
			/* 2011.12.12
			 * Yard가 KREIWY1이고, Inbound B/L의 POD와 DEL이 각각 KRPUS/KRPUS 혹은 KRKAN/KRKAN 혹은 KRPTK/KRPTK 혹은 KRINC/KRINC이고, 
			 * 수신한 msg가 I/B Full 이면 (IC,ID,EN,TN) 수신한 msg는 ignored(혹은 오류) 처리 한다
			 */
			if(flatFileForGateNewVO.getMuidArea().equals("KOR")){
				String temp_pod = ""; 
				String temp_del = ""; 
				
				String temp_pod_del[] = new String[2];
				try {
					String bkgNo = "";
					
					if(flatFileForGateNewVO.getBkgNumber()[0] != null){
						bkgNo = flatFileForGateNewVO.getBkgNumber()[0];
					}else if(flatFileForGateNewVO.getBlNo() != null){
						bkgNo = flatFileForGateNewVO.getBlNo();
					}
					log.debug("\n\n===============================================================" +
							  "\n @getPodDel" +
							  "\n===============================================================\n");
					if(bkgNo != null && !"".equals(bkgNo)){
						temp_pod_del = dbDao.getPodDel(bkgNo);
						// temp_pod_del[0] : POD CD
						// temp_pod_del[1] : DELIVERY CD
					}
				} catch (Exception ex) {
					log.error("[GATENEW : @getPodDel err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}
				if(temp_pod_del[0] != null && temp_pod_del[1] != null){
					temp_pod = temp_pod_del[0];
					temp_del = temp_pod_del[1];
				}
				
				if ( flatFileForGateNewVO.getMsgId().equals("COD") && 
						( (flatFileForGateNewVO.getMvmtStatus().equals("TN")) || (flatFileForGateNewVO.getMvmtStatus().equals("EN")) || (flatFileForGateNewVO.getMvmtStatus().equals("IC")) || (flatFileForGateNewVO.getMvmtStatus().equals("ID")) ) &&( flatFileForGateNewVO.getEventYard().equals("KREIWY1")) && 
						( ( (temp_pod.equals("KRPTK")) && (temp_del.equals("KRPTK")) ) || ( (temp_pod.equals("KRPUS")) && (temp_del.equals("KRPUS")) ) || ( (temp_pod.equals("KRKAN")) && (temp_del.equals("KRKAN")) ) || ( (temp_pod.equals("KRINC")) && (temp_del.equals("KRINC")) ) ) && flatFileForGateNewVO.getContStat().equals("F") ) { 
					flatFileForGateNewVO.setResultMessage("Ignored Yard(KREIWY1)"); 
					flatFileForGateNewVO.setResultIndicator("X"); 
					return false; 
				}
			}

			// 2014.02.24 
			if(flatFileForGateNewVO.getContStat().equals("M") && (!flatFileForGateNewVO.getEventYard().equals("") && flatFileForGateNewVO.getEventYard().substring(0, 2).equals("GB") ) 
//				&& flatFileForGateNewVO.getSightCd() == "E" 
				&& (flatFileForGateNewVO.getMvmtStatus().equals("MT") || flatFileForGateNewVO.getMvmtStatus().equals("EN") || flatFileForGateNewVO.getMvmtStatus().equals("TN")))
			{
				
				String[] rtn = new String[2];
				try
				{
					rtn = dbDao.searchTrspOrderOutboundbyGB(flatFileForGateNewVO.getBkgNumber()[0], flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getEventYard(), flatFileForGateNewVO.getEventDate());
				}
				catch (DAOException ex) {
					log.error("[GATENEW : dbDao.searchTrspOrderOutboundbyGB(BkgNumber,CntrNo,Yardcd,EventDate)] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.searchTrspOrderOutboundbyGB(BkgNumber,CntrNo,Yardcd,EventDate)] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}
				if(rtn != null){
					flatFileForGateNewVO.setResultMessage("Unnecessary OP/MT due to S/O via yard"); 
					flatFileForGateNewVO.setResultIndicator("N");
					return false;
				}

			}

			/* 2009.08.13 - Local Time대비 Event DT가 5일 전/후 일 경우, Ignored 처리. */
			if ( !"Y".equals(flatFileForGateNewVO.getEdiUiYn()) ) {
				Double eventTimeGap = null;

//				EXEC SQL
//				SELECT
//						TO_NUMBER
//						(
//							GLOBALDATE_PKG.TIME_CONV_FNC ('KRPUS', SYSDATE, DECODE (@[event_yard], '',
//								DECODE (@[muid_area], 'USA', 'USNYC', 'KOR', 'KRSEL', 'CHN', 'CHSHA', 'SWA', 'SGSIN', 'EUR', 'DEHAM', ''),
//									  SUBSTR(@[event_yard], 1, 5)) )
//							-
//							TO_DATE (@[event_date], 'YYYYMMDDHH24MISS')
//						)
//				INTO    :eventTimeGap
//				FROM    DUAL

				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.getEventTimeGap(muidArea, eventYard, eventDate)" +
							  "\n===============================================================\n");
					eventTimeGap = dbDao.getEventTimeGap(flatFileForGateNewVO.getMuidArea(), flatFileForGateNewVO.getEventYard(), flatFileForGateNewVO.getEventDate());
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.getEventTimeGap] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.getEventTimeGap err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}

//				2014-01-22 강 환  [CHM-201428329] Time gap between event and receiving date 변경(5 days-10days). EDI error msg Batch시행 횟수(2회-5회)
//				if ( eventTimeGap != null && (eventTimeGap < -5 || eventTimeGap > 5) ) {
				if ( eventTimeGap != null && (eventTimeGap < -10 || eventTimeGap > 10) ) {
					flatFileForGateNewVO.setResultMessage("Time gap between event and receiving date is over 10 days");
					flatFileForGateNewVO.setResultIndicator("X");
			        // flatFileForGateNewVO.setSightCd("X");  2010-05-26 Retry가능토록 - Rqst by DSLee
					return false;
				}
			}
		}	/* if ( chassisCase = FALSE) */


//		EXEC SQL
//		SELECT	MVMT_STS_CD
//		FROM	MDM_MVMT_STS
//		WHERE	MVMT_STS_CD = :FlatFileVO.mvmtStatus;

		returnValue = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.searchCodeExist(MVMT_STS_CD)" +
					  "\n===============================================================\n");
			returnValue = dbDao.searchCodeExistForGateNew("MDM_MVMT_STS", "MVMT_STS_CD", flatFileForGateNewVO.getMvmtStatus());
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.searchCodeExist(MVMT_STS_CD)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.searchCodeExist(MVMT_STS_CD)] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if ( returnValue == null || returnValue.equals("") ) {
			if (flatFileForGateNewVO.getGateIo().equals("L") || flatFileForGateNewVO.getGateIo().equals("T") || flatFileForGateNewVO.getGateIo().equals("CA") || flatFileForGateNewVO.getGateIo().equals("RE") ) {
				flatFileForGateNewVO.setResultMessage("PASS GATE IO STS 1(" + flatFileForGateNewVO.getGateIo() + ")");
				flatFileForGateNewVO.setResultIndicator("X");

			} else {
				flatFileForGateNewVO.setResultMessage("STS CHECK ERROR");
				flatFileForGateNewVO.setResultIndicator("N");

			}
			flatFileForGateNewVO.setMvmtStatus("ER");
			return false;
		}


//		EXEC SQL
//		SELECT	NVL(OFC_CD, '')
//		INTO	:FlatFileVO.yardOffice
//		FROM	MDM_YARD
//		WHERE	YD_CD = :FlatFileVO.eventYard
//		AND		DELT_FLG = "N";

		String officeYard = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.getOfcCd(eventYard)" +
					  "\n===============================================================\n");
			officeYard = dbDao.getOfcCd(flatFileForGateNewVO.getEventYard());
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.getOfcCd(eventYard)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.getOfcCd(eventYard)] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if ( officeYard == null || officeYard.equals("") ) {
			flatFileForGateNewVO.setResultMessage("ORIGIN YARD CHECK ERROR");
			flatFileForGateNewVO.setResultIndicator("N");
			return false;

		} else {
			flatFileForGateNewVO.setOfficeYard(officeYard);

		}

		if ( subStr(flatFileForGateNewVO.getEventYard(), 5, 6).equals("R") && flatFileForGateNewVO.getGateIo().equals("A") ) {
			if ( flatFileForGateNewVO.getMvmtStatus().equals("MT") ) {
				flatFileForGateNewVO.setResultMessage("PASS GATE IO STS 2(" + flatFileForGateNewVO.getGateIo() + ", " + flatFileForGateNewVO.getMvmtStatus() + ")");
				flatFileForGateNewVO.setResultIndicator("X");
				return false;

			}

			if ( flatFileForGateNewVO.getContStat().equals("F") && flatFileForGateNewVO.getTermId().equals("NS") ) {
				flatFileForGateNewVO.setResultMessage("PASS GATE IO STS 3(" + flatFileForGateNewVO.getGateIo() + ", " + flatFileForGateNewVO.getMvmtStatus() + ")");
				flatFileForGateNewVO.setResultIndicator("X");
				return false;

			}
		}

		if ( flatFileForGateNewVO.getMvmtStatus().equals("OP") || flatFileForGateNewVO.getMvmtStatus().equals("OC") ) {
			if ( (flatFileForGateNewVO.getBkgNumber()[0] == null || flatFileForGateNewVO.getBkgNumber()[0].equals("")) || subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 1).equals("#") ) {
				if ( flatFileForGateNewVO.getSightCd().equals("N") ) {
					flatFileForGateNewVO.setResultMessage("THIS CONTAINER IS TS CONTAINER");
					flatFileForGateNewVO.setResultIndicator("Y");
					flatFileForGateNewVO.setMvmtStatus("TS");

				} else {
					flatFileForGateNewVO.setResultMessage("AFTER INPUT BKG NBR,RECOVERY THIS DATA");
					flatFileForGateNewVO.setResultIndicator("N");

				}
				return	false;
			}

			String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();    // flatFileForGateNewVO의 BkgNumber를 배열변수에 setting
			int combineCnt = 0;
			String[] bkgInforRetVal = null;
			for ( int p=0; p<bkgNumber.length ; p++ ) {
				if ( !bkgNumber[p].equals("") && bkgNumber[p] != null && !subStr(bkgNumber[p], 0, 1).equals("#") ) {

//					EXEC SQL														/* 2010.04.22 BKG_CRE_TP_CD Check By DSLee */
//					SELECT	BKG_STS_CD,		SPLIT_FLG,			TO_BKG_NO,		LENGTH(FlatFileVO.bkgNumber[p]),	BKG_CRE_TP_CD
//					INTO	:bkg_sts,		:bkg_split_ind,		:bkg_com_no,	:bkg_length,						:bkg_cre_tp_cd
//					FROM	BKG_BOOKING
//					WHERE	BKG_NO			=	TRIM( FlatFileVO.bkgNumber[p] )

					bkgInforRetVal = new String[4];
					String bkgStsCd = "";
					String bkgSplitInd = "";
					String bkgComNo = "";
					String bkgCreTpCd = "";
					try {
						log.debug("\n\n===============================================================" +
								  "\n dbDao.getBookingInfo" +
								  "\n===============================================================\n");
						bkgInforRetVal = dbDao.getBookingInfo(bkgNumber[p]);
						bkgStsCd = (bkgInforRetVal[0] == null ? "" : bkgInforRetVal[0].trim());
						bkgSplitInd = (bkgInforRetVal[1] == null ? "" : bkgInforRetVal[1].trim());
						bkgComNo = (bkgInforRetVal[2] == null ? "" : bkgInforRetVal[2].trim());
						bkgCreTpCd = (bkgInforRetVal[3] == null ? "" : bkgInforRetVal[3].trim());;
					} catch (DAOException ex) {
						log.error("[GATENEW : dbDao.getBookingInfo] DAOerr : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					} catch (Exception ex) {
						log.error("[GATENEW : dbDao.getBookingInfo] err : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					}

					if ( bkgStsCd == null || bkgStsCd.equals("") ) {
					    /* 20100222 By DSLEE */
						if ( flatFileForGateNewVO.getMsgId().equals("222") && flatFileForGateNewVO.getMvmtStatus().equals("OP") ) {
							flatFileForGateNewVO.setMvmtStatus("TN");
							bkgNumber = new String[1]; /* BKG No Clear */
							bkgNumber[0] = "";
							flatFileForGateNewVO.setBkgNumber(bkgNumber);
							flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
							break;

						} else {
							flatFileForGateNewVO.setResultMessage("BKG NBR NOT EXIST");
							flatFileForGateNewVO.setResultIndicator("N");
							return false;
						}

/* System error시 위에서 별도 throw 처리를 하므로 주석처리
					} else if ( sqlca.sqlcode != 0 && sqlca.sqlcode != SQLNULL ) {
	                    FlatFileVO.resultMessage = "BKG NBR CANCEL, SPLIT CHECK ERROR";
	                    FlatFileVO.resultIndicator = "N";
	                    return    false;
*/
					}

					/* 2010.01.28 By SBKIM */
					if ( subStr(bkgStsCd, 0 , 1).equals("X") && subStr(bkgSplitInd, 0 , 1).equals("N") && bkgComNo.length() == 0 ) {
						flatFileForGateNewVO.setResultMessage("BKG NBR ALREADY CANCEL");
						flatFileForGateNewVO.setResultIndicator("N");
						return false;

					}

					if ( bkgComNo.length() > 1 ) {
						bkgNumber[p] = bkgComNo;
						combineCnt++;

						if ( combineCnt > 15 ) {
							flatFileForGateNewVO.setResultMessage("COMBINE BKG SELECT ERROR");
							flatFileForGateNewVO.setResultIndicator("N");
							return false;
						}

						p--;
						continue;
					}

					/* 2010.04.22 BKG_CRE_TP_CD Check By DSLee */
					if ( subStr(bkgStsCd, 0 , 1).equals("S") || (subStr(bkgSplitInd, 0 , 1).equals("Y") && !subStr(bkgCreTpCd, 0 , 1).equals("S")) ) {

						/* Split BKG 인 경우는 Current의 Split BKG을 찾아 BKG No 치환 - 로직수정 2010.04.08 BY SBKIM */
//						EXEC SQL
//						SELECT	BC.BKG_NO
//						INTO	:temp_bkgNumber
//						FROM	BKG_CONTAINER BC, BKG_BOOKING BO
//						WHERE	BC.CNTR_NO	     =   :FlatFileVO.cntrNumber
//						AND     BC.BKG_NO        =	  BO.BKG_NO
//						AND		(
//									BO.FM_BKG_NO  =   :FlatFileVO.bkgNumber[0]
//									OR
//									BO.BKG_NO     =   :FlatFileVO.bkgNumber[0]
//								)
//						AND		NVL(BO.BKG_STS_CD,' ') <> 'S'
//						AND		NVL(BO.BKG_STS_CD,' ') <> 'X'
//						AND		NVL(BO.BKG_STS_CD,' ') <> 'A'
//						AND     ROWNUM = 1

						String tempBkgNumber = "";
						try {
							log.debug("\n\n===============================================================" +
									  "\n dbDao.getBkgNo" +
									  "\n===============================================================\n");
							tempBkgNumber = dbDao.getBkgNo(flatFileForGateNewVO.getCntrNumber(), bkgNumber[p]);
						} catch (DAOException ex) {
							log.error("[GATENEW : dbDao.getBkgNo] DAOerr : " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						} catch (Exception ex) {
							log.error("[GATENEW : dbDao.getBkgNo] err : " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						}

						if ( tempBkgNumber == null || tempBkgNumber.equals("") ) {
							//2011-02-25 OP, booking no 없으면 TN으로
							if ( "OP".equals(flatFileForGateNewVO.getMvmtStatus())) {
								flatFileForGateNewVO.setMvmtStatus("TN");
								bkgNumber = new String[1]; /* BKG No Clear */
								bkgNumber[0] = "";
								break;
							}else{
								flatFileForGateNewVO.setResultMessage("Could not find split booking since container is not attached on split booking.");
								flatFileForGateNewVO.setResultIndicator("N");
								return false;
							}
						}
						bkgNumber[p] =  tempBkgNumber ;
					}
				} /* if ( FlatFileVO.getBkgNumber()[p][1] NOT IN ( " ", NULL, "#" ) */
			}	/* for ( ii = 0; ii < BkgCount : ii++ ) */

			flatFileForGateNewVO.setBkgNumber(bkgNumber);        // 배열변수를 flatFileForGateNewVO의 BkgNumber에 배열로 setting
			flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);    // flatFileForGateNewVO의 BkgNumber0에 배열의 첫번째 value setting

		}	/* if ( FlatFileVO.cont_stat[1-2] IN ( "OP", "OC" ) ) */

		/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			메세지가 "COD" 이고 지역이 "EUR", "SWA","CHN","KOR" 이거나
			메세지가 "322" 이고  지역이 "USA" 이고, gate IO가 "AE"거나"UV" 이면
			CallSign 과 loydCode로 VVD를 찾는 로직을 수행한다. 2010 : @Get_NIS_VVD_With_Callsign 로직을
			여기서 대체 시킴
		 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/

		if ( ((flatFileForGateNewVO.getMsgId().equals("COD") && (flatFileForGateNewVO.getMuidArea().equals("EUR") || flatFileForGateNewVO.getMuidArea().equals("SWA") || flatFileForGateNewVO.getMuidArea().equals("CHN") || flatFileForGateNewVO.getMuidArea().equals("") || flatFileForGateNewVO.getMuidArea().equals("KOR")) )
		   || (flatFileForGateNewVO.getMsgId().equals("322") && flatFileForGateNewVO.getMuidArea().equals("USA")))
		   && (flatFileForGateNewVO.getGateIo().equals("AE") || flatFileForGateNewVO.getGateIo().equals("UV")) ) {

			/* ________________________________________________________________________ Variables Initialize */
			boolean bkgExist = false;
			boolean callSignExist = false;
			boolean callSignVSLFound = false;
			boolean vvdFound = false;

			/* ____________________________________________________________________________ BKG No Checking */
//			EXEC SQL
//			SELECT	 "A"
//			FROM	BKG_BOOKING BK
//			WHERE	BK.BKG_NO =	 :FlatFileVO.bkgNumber[0];

			returnValue = "";
			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.searchCodeExist(BKG_NO:BKG_BOOKING)" +
						  "\n===============================================================\n");
				returnValue = dbDao.searchCodeExistForGateNew("BKG_BOOKING", "BKG_NO", flatFileForGateNewVO.getBkgNumber()[0]);
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.searchCodeExist(BKG_NO)] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.searchCodeExist(BKG_NO)] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			if ( returnValue != null && !returnValue.equals("") ) bkgExist = true;

			/* __________________________________________________________________________ Callsign Checking */

			Integer callsignLength = 0;
			if( !flatFileForGateNewVO.getMuidArea().equals("USA") ) {
				callsignLength = flatFileForGateNewVO.getCallSignNo().length();

			} else {
				callsignLength = flatFileForGateNewVO.getLloydNo().length();
			}

			/* __________________________________________________________________ Callsign VVD Checking */

			String[] csnVslCd = new String[3];	 /* Vessel Code값 초기화 */
			if ( callsignLength > 0 ) {
				callSignExist = true;

				if( !flatFileForGateNewVO.getMuidArea().equals("USA") ) {

//					EXEC SQL
//					SELECT  VSL_CD
//					INTO	:csn_vsl_cd[]
//					FROM
//					(
//						SELECT	V1.VSL_CD
//						FROM	MDM_VSL_CNTR V1
//						WHERE	V1.CALL_SGN_NO = TRIM(:FlatFileVO.callSignNo)
//						AND     NVL(V1.DELT_FLG,' ') <> 'Y'
//						ORDER BY
//								V1.CRE_DT DESC
//					)
//					WHERE   ROWNUM <= 3

					try {
						log.debug("\n\n===============================================================" +
								  "\n dbDao.getVslCd(CallSignNo)" +
								  "\n===============================================================\n");
						csnVslCd = dbDao.getVslCd(flatFileForGateNewVO.getCallSignNo(), "");
					} catch (DAOException ex) {
						log.error("[GATENEW : dbDao.getVslCd(CallSignNo)] DAOerr : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					} catch (Exception ex) {
						log.error("[GATENEW : dbDao.getVslCd(CallSignNo)] err : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					}

				} else {

//					EXEC SQL
//					SELECT  VSL_CD
//					INTO	:csn_vsl_cd	[]
//					FROM
//					(
//						SELECT	V1.VSL_CD
//						FROM	MDM_VSL_CNTR V1,
//								(
//									SELECT  DISTINCT V.VSL_CD
//									FROM	MDM_VSL_CNTR V, VSK_VSL_SKD VS
//									WHERE	V.LLOYD_NO IS NOT NULL
//									AND		V.LLOYD_NO			=	TRIM(:FlatFileVO.lloydNo)
//									AND		V.VSL_CD			=	VS.VSL_CD
//									AND     NVL(V.DELT_FLG,' ')		<> 'Y'
//									AND		VS.SKD_STS_CD		=	'ACT'
//									AND		VS.N1ST_PORT_BRTH_DT >= SYSDATE - 120
//									AND		VS.N1ST_PORT_BRTH_DT <  SYSDATE
//								)			V2
//						WHERE	V1.VSL_CD	=	V2.VSL_CD
//						ORDER BY
//								V1.CRE_DT DESC
//					)
//					WHERE  ROWNUM  <=  3

					try {
						log.debug("\n\n===============================================================" +
								  "\n dbDao.getVslCd(LloydNo)" +
								  "\n===============================================================\n");
						csnVslCd = dbDao.getVslCd("", flatFileForGateNewVO.getLloydNo());
					} catch (DAOException ex) {
						log.error("[GATENEW : dbDao.getVslCd(LloydNo)] DAOerr : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					} catch (Exception ex) {
						log.error("[GATENEW : dbDao.getVslCd(LloydNo)] err : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					}
				}

				if ( (csnVslCd[0] != null && !csnVslCd[0].equals(""))
				  || (csnVslCd[1] != null && !csnVslCd[1].equals(""))
				  || (csnVslCd[2] != null && !csnVslCd[2].equals("")) ) {

					callSignVSLFound = true;

				}
			}

			String[] vvdCode = null;

			if ( !bkgExist ) {

				if ( !callSignExist ) {
					flatFileForGateNewVO.setResultMessage("CallSign is Missing. Request Terminal to send CallSign");

				} else {	/* ( callsignExist == TRUE ) */

					if ( !callSignVSLFound ) {
						flatFileForGateNewVO.setResultMessage("No Matched VSL Code against CallSign/Lloyd Code. Update CallSign/Lloyd Code on VSL Info");

					} else {	/* ( callSignVVDFound == TRUE ) */

						flatFileForGateNewVO.setResultMessage("Could not find correct BKG No");    /* 20091221 SBKIM */

						vvdCode = new String[3];
						for ( int ii=0; ii<3 && csnVslCd[ii] != null; ii++ ) {

							try {
								if( flatFileForGateNewVO.getGateIo().equals("AE") ) {    /* -------------------------------------------- (VL) Case */

//									/* Use Event Location instead of POL/POD, wheh Searching VVD in Vessel Port Schedule. - 2009.09.29 */
//									EXEC SQL
//									SELECT  S.VSL_CD,			S.SKD_VOY_NO,		S.SKD_DIR_CD
//									INTO	:vps_vsl_cd,		:vps_voyage_no,		:vps_dir_cd
//									FROM	(
//												SELECT	/*+ ORDERED
//																INDEX_DESC( VPS1 XAK2VSL_PORT_SKD_ETD   )
//																INDEX     ( SKD  XPKVSL_SKD             ) 2010 : Index 재설정 */
//														ROUND(ABS(VPS1.VPS_ETD_DT-TO_DATE(:FlatFileVO.eventDate, 'YYYYMMDD')),5) DIF,		/* 2008.12.04 */
//														SKD.VSL_CD,			SKD.SKD_VOY_NO,		SKD.SKD_DIR_CD
//												FROM	VSK_VSL_PORT_SKD VPS1,  VSK_VSL_SKD SKD
//												WHERE	VPS1.VPS_ETD_DT BETWEEN TO_DATE(:FlatFileVO.eventDate, 'YYYYMMDD')	- :fm_margin
//												AND								TO_DATE(:FlatFileVO.eventDate, 'YYYYMMDD')	+ :to_margin + .99999
//												AND		VPS1.VPS_PORT_CD         =	:FlatFileVO.eventYard
//												AND		NVL(VPS1.SKD_CNG_STS_CD,' ')	<> 'S'
//												AND		SKD.VSL_CD			LIKE	TRIM(:csn_vsl_cd[ii])||'%'
//												AND		SKD.SKD_STS_CD	        =	'ACT'
//												AND		SKD.VSL_CD              =	VPS1.VSL_CD
//												AND		SKD.SKD_VOY_NO			=	VPS1.SKD_VOY_NO
//												AND		SKD.SKD_DIR_CD          =	VPS1.SKD_DIR_CD
//												ORDER BY DIF ASC SKD.SKD_VOY_NO DESC  /* VL : using bigger Voyage No - 2009.09.03 */
//											) S
//									WHERE	ROWNUM  = 1;

									log.debug("\n\n===============================================================" +
											  "\n dbDao.getVvdCdByVL" +
											  "\n===============================================================\n");
									vvdCode = dbDao.getVvdCdByVL(flatFileForGateNewVO.getEventDate(), flatFileForGateNewVO.getEventYard(), csnVslCd[ii]);

								} else {									     /* ------------------------------------------- (VD) Case */

//									/* Use Event Location instead of POL/POD, wheh Searching VVD in Vessel Port Schedule. - 2009.09.29 *
//									EXEC SQL
//									SELECT  S.VSL_CD,			S.SKD_VOY_NO,		S.SKD_DIR_CD
//									INTO	:vps_vsl_cd,		:vps_voyage_no,		:vps_dir_cd
//									FROM	(
//												SELECT /*+ ORDERED
//																INDEX_DESC( VPS1 XAK1VSL_PORT_SKD_ETB   )
//																INDEX     ( SKD  XPKVSL_SKD             ) 2010 : Index 재설정 */
//														ROUND(ABS(VPS1.VPS_ETB_DT-TO_DATE(:eventDate, 'YYYYMMDD')),5) DIF,		/* 2008.12.04 */
//														SKD.VSL_CD,			SKD.SKD_VOY_NO,		SKD.SKD_DIR_CD
//												FROM	VSK_VSL_PORT_SKD VPS1, VSK_VSL_SKD SKD
//												WHERE	VPS1.VPS_ETB_DT BETWEEN TO_DATE(:FlatFileVO.eventDate, 'YYYYMMDD')	- :fm_margin
//												AND								TO_DATE(:FlatFileVO.eventDate, 'YYYYMMDD')	+ :to_margin + .99999
//												AND		VPS1.VPS_PORT_CD		=	:FlatFileVO.eventYard
//												AND		NVL(VPS1.SKD_CNG_STS_CD,' ')	<> 'S'
//												AND		SKD.VSL_CD			LIKE	TRIM(:csn_vsl_cd[ii])||'%'
//												AND		SKD.SKD_STS_CD			=	'ACT'
//												AND		SKD.VSL_CD				=	VPS1.VSL_CD
//												AND		SKD.SKD_VOY_NO			=	VPS1.SKD_VOY_NO
//												AND		SKD.SKD_DIR_CD			=	VPS1.SKD_DIR_CD
//												ORDER BY DIF ASC SKD.SKD_VOY_NO ASC	/* VD : using smaller Voyage No - 2009.09.03 */
//											) S
//									WHERE	ROWNUM  = 1;

									log.debug("\n\n===============================================================" +
											  "\n dbDao.getVvdCdByVD" +
											  "\n===============================================================\n");
									vvdCode = dbDao.getVvdCdByVD(flatFileForGateNewVO.getEventDate(), flatFileForGateNewVO.getEventYard(), csnVslCd[ii]);
								}
							} catch (DAOException ex) {
								log.error("[GATENEW : dbDao.getVvdCd] DAOerr : " + ex.toString(), ex);
								throw new EventException(ex.getMessage(), ex);
							} catch (Exception ex) {
								log.error("[GATENEW : dbDao.getVvdCd] err : " + ex.toString(), ex);
								throw new EventException(ex.getMessage(), ex);
							}

							if ( (vvdCode[0] != null && !vvdCode[0].equals("")) || (vvdCode[1] != null && !vvdCode[1].equals("")) || (vvdCode[2] != null && !vvdCode[2].equals("")) ) {
								flatFileForGateNewVO.setVessel(vvdCode[0]);
								flatFileForGateNewVO.setVoyage(vvdCode[1]);
								flatFileForGateNewVO.setDir(vvdCode[2]);
								vvdFound = true ;
								break;
							}
						}    /* for ( ii = 0; ii < 3 && csn_vsl_cd[ii] ! = ""; ii++ ) */
					}
				}

			} else {	/* if ( bkgExist = = TRUE ) */

				/* ____________________________________________________________________________ BKG VVD Checking */

//				EXEC SQL
//				SELECT	 "A"
//				FROM	BKG_CONTAINER BC
//				WHERE	BC.BKG_NO =	 :FlatFileVO.bkgNumber[0]
//				AND		BC.CNTR_NO = TRIM(:FlatFileVO.cntrNumber)
//				AND		ROWNUM = 1;

				returnValue = "";
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.searchCodeExist(BkgCntr)" +
							  "\n===============================================================\n");
					returnValue = dbDao.searchCodeExistForGateNew("BKG_CONTAINER", "BKG_NO", flatFileForGateNewVO.getBkgNumber()[0] + "' AND CNTR_NO = '" + flatFileForGateNewVO.getCntrNumber());
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.searchCodeExist(BkgCntr)] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.searchCodeExist(BkgCntr)] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}

				if ( returnValue == null || returnValue.equals("") ) {	/* bkgCNTRFound = FALSE */
					if( !flatFileForGateNewVO.getContStat().equals("E") && !flatFileForGateNewVO.getContStat().equals("M") ) {
						flatFileForGateNewVO.setResultMessage("BKG & BKG CNTR unmatch error");
						flatFileForGateNewVO.setResultIndicator("N");
					}

				} else {

//					EXEC SQL
//					SELECT	 NVL(BV.VSL_CD,"X"),		NVL(BV.SKD_VOY_NO,"X"),		NVL(BV.SKD_DIR_CD,"X")
//					INTO	:bkg_vsl_cd,			:bkg_voyage_no,				:bkg_dir_cd
//					FROM	BKG_VVD BV
//					WHERE	BV.BKG_NO =	 :FlatFileVO.bkgNumber[0]
//					AND	 DECODE(:FlatFileVO.gateIo,"AE",BV.POL_CD, BV.POD_CD) = :FlatFileVO.eventYard
//					AND		ROWNUM = 1;

					vvdCode = new String[3];
					try {
						log.debug("\n\n===============================================================" +
								  "\n dbDao.getVvdCd" +
								  "\n===============================================================\n");
						vvdCode = dbDao.getVvdCd(flatFileForGateNewVO.getBkgNumber()[0], flatFileForGateNewVO.getGateIo(), flatFileForGateNewVO.getEventYard());
					} catch (DAOException ex) {
						log.error("[GATENEW : dbDao.getVvdCd1] DAOerr : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					} catch (Exception ex) {
						log.error("[GATENEW : dbDao.getVvdCd1] err : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					}

					if ( (vvdCode[0] == null || vvdCode[0].equals("")) || (vvdCode[1] == null || vvdCode[1].equals("")) || (vvdCode[2] == null && vvdCode[2].equals(""))) {
						/* bkgVVDFound = FALSE */

						/*	20091221 SBKIM (S)-------------------------------------- */
						if ( flatFileForGateNewVO.getGateIo().equals("AE") ) {
							flatFileForGateNewVO.setResultMessage("POL is different");

						} else {
							flatFileForGateNewVO.setResultMessage("POD is different");

						}

						flatFileForGateNewVO.setResultIndicator("N");
						flatFileForGateNewVO.setVessel(csnVslCd[0]);    /* First Callsign Vessel Code Setting */
						/*	20091221 SBKIM (E)-------------------------------------- */

					} else if ( vvdCode[0].equals("X") ) {
						flatFileForGateNewVO.setResultMessage("BKG VVD is not updated yet");
						flatFileForGateNewVO.setResultIndicator("N");
						/*	20091221 SBKIM (S)-------------------------------------- */
						flatFileForGateNewVO.setVessel(csnVslCd[0]);    /* First Callsign Vessel Code Setting */
						/*	20091221 SBKIM (E)-------------------------------------- */

					} else {
						if ( !callSignExist || !callSignVSLFound ) {
							flatFileForGateNewVO.setVessel(vvdCode[0]);
							flatFileForGateNewVO.setVoyage(vvdCode[1]);
							flatFileForGateNewVO.setDir(vvdCode[2]);
							vvdFound = true;

						} else {    /* RETURN TRUE */

							for ( int ii=0; ii<3 && csnVslCd[ii] != null; ii++ ) {
								if ( csnVslCd[ii].equals(vvdCode[0]) ) {	// bkg_vsl_cd
									flatFileForGateNewVO.setVessel(vvdCode[0]);
									flatFileForGateNewVO.setVoyage(vvdCode[1]);
									flatFileForGateNewVO.setDir(vvdCode[2]);
									vvdFound = true;
								}
							}

							if ( !vvdFound ) {
								if ( flatFileForGateNewVO.getEventYard() != null && (flatFileForGateNewVO.getEventYard().equals("SGSINKA") || flatFileForGateNewVO.getEventYard().equals("LKCMBY2"))) {
									flatFileForGateNewVO.setVessel(vvdCode[0]);
									flatFileForGateNewVO.setVoyage(vvdCode[1]);
									flatFileForGateNewVO.setDir(vvdCode[2]);
									vvdFound = true;
								}else{
									flatFileForGateNewVO.setResultMessage("BKG VVD is different");
									flatFileForGateNewVO.setResultIndicator("N");
									/*	20091221 SBKIM (S)-------------------------------------- */
									flatFileForGateNewVO.setVessel(csnVslCd[0]);    /* First Callsign Vessel Code Setting */
									/*	20091221 SBKIM (E)-------------------------------------- */
								}
							}
						}
					}
				}
			}

			if ( !vvdFound ) {
				if( (flatFileForGateNewVO.getContStat().equals("E") || flatFileForGateNewVO.getContStat().equals("M")) && flatFileForGateNewVO.getGateIo().equals("AE") ) {
					flatFileForGateNewVO.setVessel("XXXX");
					flatFileForGateNewVO.setVoyage("0000");
					flatFileForGateNewVO.setDir("");

				} else {
					flatFileForGateNewVO.setResultIndicator("N");
					return false;
				}
			} else if ( bkgExist == false ) {    /* 2010.02.17 BY DSLEE */
				if( (flatFileForGateNewVO.getContStat().equals("E") || flatFileForGateNewVO.getContStat().equals("M")) && flatFileForGateNewVO.getGateIo().equals("AE") ) {
					log.debug("\n\n============================== bkgExist=false & ContStat in (E,M) & GateIo=AE  >>>  skip");
				} else {
					flatFileForGateNewVO.setResultIndicator("N");
					return false;
				}
			}
		}
		return true;

	}

    /*=========================================================
	 * 2010.10.18 김상수 [CHM-201006479-01] B.Bulk화물 Movement를 Logic 변경(MT->Full)
	 *                   - 현재 B.Bulk화물의 컨테이너는 MT로 VL 처리되기 때문에 FULL VL이 아니라
	 *                     EMPTY VL without bkg으로 VL 생성되고 있는 건을 Mt->Full로 변경해서
	 *                     자동생성 로직이 탈수있도록 소스수정
	 *                   - 현재 자동생성시 이전 상태가 MT이고 현재는 full VL이므로 업무상 error로
	 *                     분류되는 로직을 MT이고 Full VL이면 OP,OC가 자동생성되게 변경.
	 *                     그러나 BreakBulk도 아니면서 OP,OC없이 생성된 full VL도 있을 수 있으므로
	 *                     이를 막기위해 bkg cntr테이블의 BB column을 다시 check하는 로직추가
     *=========================================================*/
	/**
	 * adjustBkgNumber for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @return Boolean
	 * @exception EventException
	 *
	 * - Retrun TRUE if normal bkg of Found -
	 *   (adjust.pc)
	 **/
	private Boolean adjustBkgNumber( FlatFileForGateNewVO flatFileForGateNewVO ) throws EventException {
		String[] returnValues = null;

/* FlatFileVO.bkgNumber[0] 를 조정한다. (Booking No 13자리를 대문자로 변환하고 RPAD Space 처리를 한다) */
//		EXEC SQL
//		SELECT	UPPER(TRIM(NVL(:FlatFileVO.bkgNumber[0],"")))
//		INTO	:FlatFileVO.bkgNumber[0]
//		FROM	DUAL;

/* FlatFileVO.cntrNumber의 앞뒤 Space를 제거한다. */ /* 2010 위로 뺄것 */
//		EXEC SQL
//		SELECT	NVL(TRIM(:FlatFileVO.cntrNumber),"")
//		INTO	:FlatFileVO.cntrNumber
//		FROM	DUAL;

		/***** 2009.05.08 : Container No Check Using CONTAINER Table *****/			 /* 2010 위로 뺄것 */
		if ( flatFileForGateNewVO.getCntrNumber().length() >= 10 ) {

//			EXEC SQL
//			SELECT	CNTR_NO
//			INTO	:FlatFileVO.cntrNumber
//			FROM	(
//						SELECT	CNTR_NO
//						FROM	MST_CONTAINER
//						/* WHERE	CNTR_NO LIKE SUBSTR( TRIM(:FlatFileVO.cntrNumber) ,1,10 ) || '%'  ---20100316 By DSLee */
//						WHERE	CNTR_NO LIKE SUBSTR( TRIM(REPLACE(:FlatFileVO.cntrNumber,'XXXX','')) ,1,10 ) || '%'
//						ORDER BY
//								CNMV_DT DESC
//					)
//			WHERE	ROWNUM  = 1

			String cntrNumber = "";
			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getCntrNo(cntrNo)" +
						  "\n===============================================================\n");
				cntrNumber = dbDao.getCntrNo(flatFileForGateNewVO.getCntrNumber());
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getCntrNo(cntrNo)] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getCntrNo(cntrNo)] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			if ( cntrNumber != null && !cntrNumber.equals("") ) {
				flatFileForGateNewVO.setCntrNumber(cntrNumber);

			} else {
				return false;

			}
		}

		if ( (flatFileForGateNewVO.getBkgNumber()[0] == null || flatFileForGateNewVO.getBkgNumber()[0].equals(""))
		  && (flatFileForGateNewVO.getBlNo() != null && !flatFileForGateNewVO.getBlNo().equals("")) ) {

			/* FlatFileVO.blNo가 Domestic Booking 이면 BKG No로 치환 */
			String domesticCheck = subStr(flatFileForGateNewVO.getBlNo(), 0, 4);
			/*
			 * 2015.12.24 추가 by Sang-Hyun Kim
			 * "TMAT", "TIND", "TESI", "THYI" Domestic booking으로 판별하도록 추가.
			 *  - HJL이 아닌 타 업체 booking no.
			 */
			if (domesticCheck.equals("DLAX") || domesticCheck.equals("DCHI") || domesticCheck.equals("DHOU") || domesticCheck.equals("DMEM")
					|| domesticCheck.equals("DNYC") || domesticCheck.equals("DSEA") || domesticCheck.equals("TCHI") || domesticCheck.equals("DHJI")
					|| domesticCheck.equals("THJI") || domesticCheck.equals("TMAT") || domesticCheck.equals("TIND") || domesticCheck.equals("TESI")
					|| domesticCheck.equals("THYI")) {

				String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
				bkgNumber[0] = flatFileForGateNewVO.getBlNo();
				flatFileForGateNewVO.setBkgNumber(bkgNumber);
				flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
				flatFileForGateNewVO.setBlNo("");

			}
		}

		/* FlatFileVO.bkgNumber[0]가 Domestic Booking 이면 skip */
		String domesticCheck = subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, 4);
		if (domesticCheck.equals("DLAX") || domesticCheck.equals("DCHI") || domesticCheck.equals("DHOU") || domesticCheck.equals("DMEM")
				|| domesticCheck.equals("DNYC") || domesticCheck.equals("DSEA") || domesticCheck.equals("TCHI") || domesticCheck.equals("DHJI")
				|| domesticCheck.equals("THJI") || domesticCheck.equals("TMAT") || domesticCheck.equals("TIND") || domesticCheck.equals("TESI")
				|| domesticCheck.equals("THYI")) {
			return false;
		}

		/* BKG No의 마지막 Character가 Alpabet이면, 마지막 Character를 제거한다 : 20100210 By DSLee */
		if ( flatFileForGateNewVO.getBkgNumber()[0] != null && !flatFileForGateNewVO.getBkgNumber()[0].equals("") ) {
			if ( isAlpha(subStr(flatFileForGateNewVO.getBkgNumber()[0], flatFileForGateNewVO.getBkgNumber()[0].length()-1, flatFileForGateNewVO.getBkgNumber()[0].length())) ) {

				String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
				bkgNumber[0] = subStr(flatFileForGateNewVO.getBkgNumber()[0], 0, flatFileForGateNewVO.getBkgNumber()[0].length()-1);
				flatFileForGateNewVO.setBkgNumber(bkgNumber);
				flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);

			}
		}

		/* BL No의 마지막 Character가 Alpabet이면, 이마지막 Character를 제거한다 : 20100325 By SBKIM */
		if ( flatFileForGateNewVO.getBlNo() != null && !flatFileForGateNewVO.getBlNo().equals("") ) {
			if ( isAlpha(subStr(flatFileForGateNewVO.getBlNo(), flatFileForGateNewVO.getBlNo().length()-1, flatFileForGateNewVO.getBlNo().length())) ) {

				flatFileForGateNewVO.setBlNo(subStr(flatFileForGateNewVO.getBlNo(), 0, flatFileForGateNewVO.getBlNo().length()-1));

			}
		}

		/* Empty VL, VD를 위한 Empty Container BKG을 찾는다 */
		if ( (flatFileForGateNewVO.getContStat().equals("E") || flatFileForGateNewVO.getContStat().equals("M")) && (flatFileForGateNewVO.getGateIo().equals("AE") || flatFileForGateNewVO.getGateIo().equals("UV")) ) {

//			EXEC SQL
//			SELECT /*+ ordered index_desc(A XAKBKG_CNTR) index(B XPKBOOKING) 2010 : Index 재설정할것 */
//					B.BKG_NO
//			INTO	:mty_bkgNumber
//			FROM	BKG_CONTAINER A, BKG_BOOKING B
//			WHERE	A.CNTR_NO = :FlatFileVO.cntrNumber
//			AND		A.CNMV_CYC_NO = (
//										SELECT	/*+ ordered index_desc(bc XAKBKG_CNTR)
//												index(bo XPKBOOKING) 2010 : Index 재설정할것 */
//												MAX(CNMV_CYC_NO)
//										FROM	BKG_CONTAINER BC, BKG_BOOKING BO
//										WHERE	BC.CNTR_NO = :FlatFileVO.cntrNumber
//										AND		BC.BKG_NO = BO.BKG_NO
//										AND		NVL(BO.BKG_STS_CD," ") <> "X"
//										AND		NVL(BO.BKG_STS_CD," ") <> "S"
//										AND		NVL(BO.BKG_STS_CD," ") <> "A"
//										AND		BC.CNMV_CYC_NO	  <>	DECODE(:FlatFileVO.gateIo,"UV",9999,0)
//										AND		BC.CNMV_CYC_NO = DECODE(:FlatFileVO.gateIo,"AE",9999,BC.CNMV_CYC_NO)
//									)
//			AND		A.BKG_NO = B.BKG_NO
//			AND		NVL(B.BKG_STS_CD," ")  <> "X"
//			AND		NVL(B.BKG_STS_CD," ")  <> "S"아래 Logic을 수행한다.
//			AND		NVL(B.BKG_STS_CD," ")  <> "A"
//			AND		B.BKG_CGO_TP_CD = "P"
//			AND		DECODE(:FlatFileVO.gateIo,"AE",B.POL_CD,B.POD_CD) = SUBSTR(:FlatFileVO.eventYard,1,5)
//			AND		ROWNUM = 1;

			String mtyBkgNumber = "";
			// 2010-07-05 : BKG_CGO_TP_CD='P'전에 BKG_CGO_TP_CD='R'로 조회하여 데이터가 있으면 return true - Rqsty by IHJang
			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getMtCntrBkgNo(R)" +
						  "\n===============================================================\n");
				mtyBkgNumber = dbDao.getMtCntrBkgNo(flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getGateIo(), flatFileForGateNewVO.getEventYard(), "R");
				/***** For Log (S) *****/
				log.info("\n\n===============================================================" +
						  "\n 1. Search MT Repo BKG(R)" +
						  "\n===============================================================" +
						  "\n MT_BKG = " + mtyBkgNumber +
						  "\n===============================================================\n");
				/***** For Log (E) *****/
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getMtCntrBkgNo(R)] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getMtCntrBkgNo(R)] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			if ( mtyBkgNumber != null && !mtyBkgNumber.equals("") ) {
				String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
				bkgNumber[0] = mtyBkgNumber.trim();
				flatFileForGateNewVO.setBkgNumber(bkgNumber);
				flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
				return true;
			}

			// 2010-10-18 : B.Bulk BKG NO 조회 logic 추가 - Rqsty by IHJang
			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getMtCntrBkgNo(B.Bulk)" +
						  "\n===============================================================\n");
				mtyBkgNumber = dbDao.getMtCntrBkgNo(flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getGateIo(), flatFileForGateNewVO.getEventYard(), "F");
				/***** For Log (S) *****/
				log.info("\n\n===============================================================" +
						  "\n 1-1. Search MT Repo BKG(B.Bulk)" +
						  "\n===============================================================" +
						  "\n MT_BKG = " + mtyBkgNumber +
						  "\n===============================================================\n");
				/***** For Log (E) *****/
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getMtCntrBkgNo(B.Bulk)] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getMtCntrBkgNo(B.Bulk)] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			if ( mtyBkgNumber != null && !mtyBkgNumber.equals("") ) {
				String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
				bkgNumber[0] = mtyBkgNumber.trim();
				flatFileForGateNewVO.setBkgNumber(bkgNumber);
				flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
				flatFileForGateNewVO.setContStat("F");    // 2010-10-18 : Break Bulk 일 경우 Full/Empty를 F로 setting
				return true;
			}

			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getMtCntrBkgNo(P)" +
						  "\n===============================================================\n");
				mtyBkgNumber = dbDao.getMtCntrBkgNo(flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getGateIo(), flatFileForGateNewVO.getEventYard(), "P");
				/***** For Log (S) *****/
				log.info("\n\n===============================================================" +
						  "\n 1-1. Search MT Repo BKG(P)" +
						  "\n===============================================================" +
						  "\n MT_BKG = " + mtyBkgNumber +
						  "\n===============================================================\n");
				/***** For Log (E) *****/
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getMtCntrBkgNo(P)] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getMtCntrBkgNo(P)] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			if ( mtyBkgNumber == null || mtyBkgNumber.equals("") ) {
				String[] bkgNumber = new String[1];
				bkgNumber[0] = "";
				flatFileForGateNewVO.setBkgNumber(bkgNumber);
				flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
				// 2010-05-26 : Empty Repo BKG찾지 못한 UV에 대해서는 아래의 Full BKG 찾기 Logic수행(For BreakBulk VD Case) - Rqsty by DSLee
				if (!"UV".equals(flatFileForGateNewVO.getGateIo())) {
					flatFileForGateNewVO.setNBkgNoFlg("Y");    // "VL"이면서 Empty BkgNo일때의 COMMON용 판정flag추가 : 2009-10-21 김상수
					return false;
				}

			} else {
				String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
				bkgNumber[0] = mtyBkgNumber.trim();
				flatFileForGateNewVO.setBkgNumber(bkgNumber);
				flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
				return true;
			}
		}

		/* FlatFileVO.bkgNumber[0] 를 가지고 Booking TBL에서 BKG Status(:bkg_sts)를 조회하고 아래 Logic을 수행한다. */
//		EXEC SQL
//		SELECT	BKG_STS_CD,		BKG_CGO_TP_CD
//		INTO	:bkg_sts_cd,	:bkg_cgo_tp_cd		/* Except Empty Repo BKG - 2009.12.08 (SBK1218)*/
//		FROM	BKG_BOOKING
//		WHERE	BKG_NO			=	:FlatFileVO.bkgNumber[0]

		boolean validBooking = false;

		returnValues = new String[2];
		String bkgStsCd = "";
		String bkgCgoTpCd = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.getBkgStsCd" +
					  "\n===============================================================\n");
			returnValues = dbDao.getBkgStsCd(flatFileForGateNewVO.getBkgNumber()[0]);
			bkgStsCd = returnValues[0];
			bkgCgoTpCd = returnValues[1];
			/***** For Log (S) *****/
			log.info("\n\n===============================================================" +
					  "\n 2. Search BKG" +
					  "\n===============================================================" +
					  "\n BKG_STS = " + bkgStsCd +
					  "\n BKG_CGO_TP = " + bkgCgoTpCd +
					  "\n===============================================================\n");
			/***** For Log (E) *****/
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.getBkgStsCd] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.getBkgStsCd] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if ( (bkgStsCd != null && !bkgStsCd.equals(""))
		  && (!bkgStsCd.equals("X") && !bkgStsCd.equals("S"))
		  && !bkgCgoTpCd.equals("P")    /* Except Empty Repo BKG - 2009.12.08 (SBK1218)*/
	  	  /* (Empty/GateOUT or OP) with Advance BKG -> Normal BKG - 2009.06.15 */
		  && (!bkgStsCd.equals("A") || (bkgStsCd.equals("A") && ((flatFileForGateNewVO.getGateIo().equals("O")
															   || flatFileForGateNewVO.getGateIo().equals("D")
															   || flatFileForGateNewVO.getGateIo().equals("OA")
															   || flatFileForGateNewVO.getGateIo().equals("P"))
															  && (flatFileForGateNewVO.getContStat().equals("E")
															   || flatFileForGateNewVO.getContStat().equals("M")
															   || flatFileForGateNewVO.getContStat().equals("AB"))
															 || flatFileForGateNewVO.getMvmtStatus().equals("OP")))
									/* (Full/GateIN or OC) with Advance BKG -> Normal BKG - 2009.09.29 */
									|| (bkgStsCd.equals("A") && ((flatFileForGateNewVO.getGateIo().equals("I")
															   || flatFileForGateNewVO.getGateIo().equals("A")
															   || flatFileForGateNewVO.getGateIo().equals("AR")
															   || flatFileForGateNewVO.getGateIo().equals("UR")
															   || flatFileForGateNewVO.getGateIo().equals("N")
															   || flatFileForGateNewVO.getGateIo().equals("R"))
															  && (flatFileForGateNewVO.getContStat().equals("F")
															   || flatFileForGateNewVO.getContStat().equals("AH")))
															 || flatFileForGateNewVO.getMvmtStatus().equals("OC")))) {

			/* BKG Status가 조회되고 BKG Status가 "X","S","A" 가 아닌 정상 BKG일 경우, (*정상BKG Check Logic) 수행 */
			validBooking = true;

		// else if ( sqlca.sqlcode == 1403 || :bkg_sts_cd  In ( "X","S","A" ) )
		} else if ( bkgStsCd.equals("") || (bkgStsCd.equals("X") || bkgStsCd.equals("S") || bkgStsCd.equals("A")) || bkgCgoTpCd.equals("P") ) {

			/* BKG Status가 조회되지 않거나 BKG Status가 "X","S","A"  중에 하나일 경우
			   FlatFileVO.blNo 를 가지고 Booking TBL에서 BKG Status(:bkg_sts)와 BKG No(:bkgNumber_by_blNo)를 조회 */
//				EXEC SQL
//				SELECT	BKG_NO, BKG_STS_CD
//				INTO	:bkgNumber_by_blNo, :bkg_sts_cd
//				FROM	BKG_BOOKING
//				WHERE	BL_NO = :FlatFileVO.blNo;

			returnValues = new String[2];
			String bkgNumberByBlNo = "";
			bkgStsCd = "";
			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getBkgNoByBlNo" +
						  "\n===============================================================\n");
				returnValues = dbDao.getBkgNoByBlNo(flatFileForGateNewVO.getBlNo());
				bkgNumberByBlNo = returnValues[0];
				bkgStsCd = returnValues[1];
				/***** For Log (S) *****/
				log.info("\n\n===============================================================" +
						  "\n 3. Search BKG by BL_NO" +
						  "\n===============================================================" +
						  "\n FLT_BL_NO = " + flatFileForGateNewVO.getBlNo() +
						  "\n BKG_NO = " + bkgNumberByBlNo +
						  "\n BKG_STS = " + bkgStsCd +
						  "\n===============================================================\n");
				/***** For Log (E) *****/
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getBkgNoByBlNo] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getBkgNoByBlNo] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			if ( (bkgNumberByBlNo != null && !bkgNumberByBlNo.equals("")) && (bkgStsCd != null && !bkgStsCd.equals(""))
			  && (!bkgStsCd.equals("X") && !bkgStsCd.equals("S"))
			  && !bkgCgoTpCd.equals("P")    /* Except Empty Repo BKG - 2009.12.08 (SBK1218)*/
			  && (!bkgStsCd.equals("A")
			  || (bkgStsCd.equals("A") && ((flatFileForGateNewVO.getGateIo().equals("O")
										 || flatFileForGateNewVO.getGateIo().equals("D")
										 || flatFileForGateNewVO.getGateIo().equals("OA")
										 || flatFileForGateNewVO.getGateIo().equals("P")
										   )
										&& (flatFileForGateNewVO.getContStat().equals("E")
										 || flatFileForGateNewVO.getContStat().equals("M")
										 || flatFileForGateNewVO.getContStat().equals("AB")
										   )
			  							  ) || flatFileForGateNewVO.getMvmtStatus().equals("OP")))) {

				/* BKG Status가 조회되고 BKG Status가 "X","S","A" 가 아닌 정상 BKG일 경우 BKG No를 치환 */
				String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
				bkgNumber[0] = (bkgNumberByBlNo == null ? "" : bkgNumberByBlNo.trim() + "");
				flatFileForGateNewVO.setBkgNumber(bkgNumber);
				flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
				validBooking = true;

			} else {

				/* BKG Status가 조회되지 않거나 BKG Status가 "X","S","A" 인 정상 BKG일 경우 Cross Checking */
//						EXEC SQL
//						SELECT	BKG_NO, NVL(BKG_STS," ")
//						INTO	:temp_bkgNumber, :bkg_sts_cd
//						FROM	BKG_BOOKING
//						WHERE	(   BKG_NO = :FlatFileVO.blNo
//									OR
//									BL_NO = :FlatFileVO.bkgNumber[0] )
//						AND		ROWNUM = 1;

				returnValues = new String[2];
				String tempBkgNumber = "";
				bkgStsCd = "";
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.getBkgNoForCrossCheck" +
							  "\n===============================================================\n");
					returnValues = dbDao.getBkgNoForCrossCheck(flatFileForGateNewVO.getBlNo(), flatFileForGateNewVO.getBkgNumber()[0]);
					tempBkgNumber = returnValues[0];
					bkgStsCd = returnValues[1];
					/***** For Log (S) *****/
					log.info("\n\n===============================================================" +
							  "\n 4. Search BKG by Cross Check" +
							  "\n===============================================================" +
							  "\n FLT_BL_NO = " + flatFileForGateNewVO.getBlNo() +
							  "\n FLT_BKG_NO = " + flatFileForGateNewVO.getBkgNumber()[0] +
							  "\n BKG_NO = " + tempBkgNumber +
							  "\n BKG_STS = " + bkgStsCd +
							  "\n===============================================================\n");
					/***** For Log (E) *****/
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.getBkgNoForCrossCheck] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.getBkgNoForCrossCheck] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}

				if	( tempBkgNumber != null && !tempBkgNumber.equals("") ) {
					/* Cross Checking BKG Status가 조회되면 BKG No를 치환 */
					String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
					bkgNumber[0] = (tempBkgNumber == null ? "" : tempBkgNumber.trim() + "");
					flatFileForGateNewVO.setBkgNumber(bkgNumber);
					flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);

					if ( (bkgStsCd != null && !bkgStsCd.equals(""))
					  && (!bkgStsCd.equals("X") && !bkgStsCd.equals("S"))
					  && !bkgCgoTpCd.equals("P")    /* Except Empty Repo BKG - 2009.12.08 (SBK1218)*/
					  && (!bkgStsCd.equals("A")
					  || (bkgStsCd.equals("A") && (    (flatFileForGateNewVO.getGateIo().equals("O")
													|| flatFileForGateNewVO.getGateIo().equals("D")
													|| flatFileForGateNewVO.getGateIo().equals("OA")
													|| flatFileForGateNewVO.getGateIo().equals("P")
													)
													&& (flatFileForGateNewVO.getContStat().equals("E")
													|| flatFileForGateNewVO.getContStat().equals("M")
													|| flatFileForGateNewVO.getContStat().equals("AB")
													)
												  ) || flatFileForGateNewVO.getMvmtStatus().equals("OP")))) {

						validBooking = true;

					}
				}

				if ( !validBooking ) {

					/* Normal BKG 아닌 경우 Combine/ Split Booking 검색 */
//							EXEC SQL
//							SELECT	NVL(TO_BKG_NO," "),
//									NVL(BKG_STS_CD," "),
//									NVL(SPLIT_FLG," "),
//									LENGTH(:FlatFileVO.bkgNumber[0])
//							INTO	:bkg_combine_no,
//									:bkg_sts_cd,
//									:bkg_split_flag,
//									:bkg_length
//							FROM	BKG_BOOKING
//							WHERE   BKG_NO = :FlatFileVO.bkgNumber[0]       /* __ 2010.01.28 BY SBKIM */

					String[] bkgInforRetVal = new String[4];
					String bkgCombineNo = "";
					String bkgSplitFlag = "";
					String bkgLength = "";
					try {
						log.debug("\n\n===============================================================" +
								  "\n dbDao.getBookingInfo (Combine/SplitBkg)" +
								  "\n===============================================================\n");
						bkgInforRetVal = dbDao.getBookingInfo(flatFileForGateNewVO.getBkgNumber()[0]);
						bkgStsCd = (bkgInforRetVal[0] == null ? "" : bkgInforRetVal[0].trim() + "");
						bkgSplitFlag = (bkgInforRetVal[1] == null ? "" : bkgInforRetVal[1].trim() + "");
						bkgCombineNo = (bkgInforRetVal[2] == null ? "" : bkgInforRetVal[2].trim() + "");
						bkgLength = (bkgInforRetVal[3] == null ? "" : bkgInforRetVal[3].trim() + "");
						/***** For Log (S) *****/
						log.info("\n\n===============================================================" +
								  "\n 5. Search BKG by Combine/Split" +
								  "\n===============================================================" +
								  "\n FlatFileVO.bkgNumber[0] = " + flatFileForGateNewVO.getBkgNumber()[0] +
								  "\n BKG_NO = " + bkgCombineNo +
								  "\n BKG_STS = " + bkgStsCd +
								  "\n SPLIT_FLG = " + bkgSplitFlag +
								  "\n BKG_LEN = " + bkgLength +
								  "\n===============================================================\n");
						/***** For Log (E) *****/
					} catch (DAOException ex) {
						log.error("[GATENEW : dbDao.getBookingInfo] DAOerr : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					} catch (Exception ex) {
						log.error("[GATENEW : dbDao.getBookingInfo] err : " + ex.toString(), ex);
						throw new EventException(ex.getMessage(), ex);
					}

					if ( !bkgCombineNo.equals("") || !bkgStsCd.equals("") ) {
						if ( !bkgCombineNo.equals("") ) {

//									EXEC SQL
//									SELECT	"A"
//									FROM	BKG_BOOKING		BO,
//											BKG_CONTAINER	BC
//									WHERE	BO.BKG_NO = :bkg_combine_no
//									AND		NVL(BO.BKG_STS," ") <> "X"
//									AND		BC.BKG_NO = BO.BKG_NO
//									AND		BC.CNTR_NO = :FlatFileVO.cntrNumber;

							try {
								log.debug("\n\n===============================================================" +
										  "\n dbDao.checkCombienBkgNo" +
										  "\n===============================================================\n");
								if ( dbDao.checkCombienBkgNo(bkgCombineNo, flatFileForGateNewVO.getCntrNumber()) ) {
									/* Combine BKG인 경우는 Combine BKG으로 BKG No 치환 */
									String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
									bkgNumber[0] = (bkgCombineNo == null ? "" : bkgCombineNo.trim() + "");
									flatFileForGateNewVO.setBkgNumber(bkgNumber);
									flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
									validBooking = true;
								}
								/***** For Log (S) *****/
								log.info("\n\n===============================================================" +
										  "\n 6.Search BKG by Combine Check" +
										  "\n===============================================================" +
										  "\n BKG_COM_NO = " + bkgCombineNo +
										  "\n===============================================================\n");
								/***** For Log (E) *****/
							} catch (DAOException ex) {
								log.error("[GATENEW : dbDao.checkCombienBkgNo] DAOerr : " + ex.toString(), ex);
								throw new EventException(ex.getMessage(), ex);
							} catch (Exception ex) {
								log.error("[GATENEW : dbDao.checkCombienBkgNo] err : " + ex.toString(), ex);
								throw new EventException(ex.getMessage(), ex);
							}

						} else if ( bkgStsCd.equals("S") || bkgSplitFlag.equals("Y") ) {

							/* Split BKG 인 경우는 Current의 Split BKG을 찾아 BKG No 치환 - 로직수정 2010.04.08 BY SBKIM */
//							EXEC SQL
//							SELECT	BC.BKG_NO
//							INTO	:temp_bkgNumber
//							FROM	BKG_CONTAINER BC, BKG_BOOKING BO
//							WHERE	BC.CNTR_NO	     =   :FlatFileVO.cntrNumber
//							AND     BC.BKG_NO        =	  BO.BKG_NO
//							AND		(
//										BO.FM_BKG_NO  =   :FlatFileVO.bkgNumber[0]
//										OR
//										BO.BKG_NO     =   :FlatFileVO.bkgNumber[0]
//									)
//							AND		NVL(BO.BKG_STS_CD,' ') <> 'S'
//							AND		NVL(BO.BKG_STS_CD,' ') <> 'X'
//							AND		NVL(BO.BKG_STS_CD,' ') <> 'A'
//							AND     ROWNUM = 1

							tempBkgNumber = "";
							try {
								log.debug("\n\n===============================================================" +
										  "\n dbDao.getBkgNo" +
										  "\n===============================================================\n");
								tempBkgNumber = dbDao.getBkgNo(flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getBkgNumber()[0]);
								/***** For Log (S) *****/
								log.info("\n\n===============================================================" +
										  "\n 7. Search BKG by Split Check" +
										  "\n===============================================================" +
										  "\n FLT_BKG_NO = " + flatFileForGateNewVO.getBkgNumber()[0] +
										  "\n BKG_NO = " + tempBkgNumber +
										  "\n===============================================================\n");
								/***** For Log (E) *****/
							} catch (DAOException ex) {
								log.error("[GATENEW : dbDao.getBkgNo] DAOerr : " + ex.toString(), ex);
								throw new EventException(ex.getMessage(), ex);
							} catch (Exception ex) {
								log.error("[GATENEW : dbDao.getBkgNo] err : " + ex.toString(), ex);
								throw new EventException(ex.getMessage(), ex);
							}

							if ( tempBkgNumber != null && !tempBkgNumber.equals("") ) {
								String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
								bkgNumber[0] = (tempBkgNumber == null ? "" : tempBkgNumber.trim() + "");
								flatFileForGateNewVO.setBkgNumber(bkgNumber);
								flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
								validBooking = true;

							}
						}
					}
				}  /* if( normal_booking ! = TRUE ) */
			}

		} else {
			return false;

		}

		/* Normal BKG No 일때는 Old BKG인지를 Check 한다 */
		if( validBooking ) {

//			SELECT	B.BKG_NO
//			INTO	:temp_bkgNumber
//			FROM	BKG_CONTAINER BC, BKG_BOOKING BO
//			WHERE	BC.CNTR_NO			= :FlatFileVO.cntrNumber
//			AND		BC.CNMV_CYC_NO		=	9999
//			AND		SYSDATE - BC.CRE_DT < 60		/* 30 -> 60 (SBK1218) */
//			AND     BC.BKG_NO           = BO.BKG_NO
//			AND		NVL(BO.BKG_STS_CD,' ') <> 'S'
//			AND		NVL(BO.BKG_STS_CD,' ') <> 'X'
//			AND		NVL(BO.BKG_STS_CD,' ') <> DECODE(:FlatFileVO.gateIo,'AE','A','UV','A','X')
//			AND     ROWNUM = 1

			String tempBkgNumber = "";
			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getOldBkgNo" +
						  "\n===============================================================\n");
				tempBkgNumber = dbDao.getOldBkgNo( flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getGateIo() );
				/***** For Log (S) *****/
				log.info("\n\n===============================================================" +
						  "\n 8. Search BKG by 9999" +
						  "\n===============================================================" +
						  "\n BKG_NO = " + tempBkgNumber +
						  "\n===============================================================\n");
				/***** For Log (E) *****/
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getOldBkgNo] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getOldBkgNo] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			if ( tempBkgNumber != null && !tempBkgNumber.equals("") ) {
				String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
				bkgNumber[0] = (tempBkgNumber == null ? "" : tempBkgNumber.trim() + "");
				flatFileForGateNewVO.setBkgNumber(bkgNumber);
				flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
				return true ;

			} else {

				/* 현재 Container의 마지막 Cycle을 구한다.*/
//				EXEC SQL
//				SELECT  MAX(BC.CNMV_CYC_NO)
//				INTO	:max_bkg_cycle
//				FROM	BKG_CONTAINER BC, BKG_BOOKING BO
//				WHERE	BC.CNTR_NO = :FlatFileVO.cntrNumber
//				AND		BC.BKG_NO = BO.BKG_NO
//				AND		NVL(BO.BKG_STS_CD," ") <> "X"
//				AND		NVL(BO.BKG_STS_Cd," ") <> "S";

				String maxBkgCycle = "";
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.getMaxCnmvCycNo" +
							  "\n===============================================================\n");
					maxBkgCycle = dbDao.getMaxCnmvCycNo( flatFileForGateNewVO.getCntrNumber() );
					/***** For Log (S) *****/
					log.info("\n\n===============================================================" +
							  "\n 9. Search BKG by Last Cycle" +
							  "\n===============================================================" +
							  "\n LAST_CYCLE = " + maxBkgCycle +
							  "\n===============================================================\n");
					/***** For Log (E) *****/
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.getMaxCnmvCycNo] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.getMaxCnmvCycNo] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}

				if ( maxBkgCycle == null || maxBkgCycle.equals("") ) {
					return false;

				}

				/* 현재 BKG Container의 Cycle을 구한다.*/
//				EXEC SQL
//				SELECT	CNMV_CYC_NO
//				INTO	:nm_bkg_cycle
//				FROM	BKG_CONTAINER
//				WHERE	BKG_NO = :FlatFileVO.bkgNumber[0]
//				AND		CNTR_NO = :FlatFileVO.cntrNumber;

				String nmBkgCycle = "";
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.getCurrCnmvCycNo" +
							  "\n===============================================================\n");
					nmBkgCycle = dbDao.getCurrCnmvCycNo( flatFileForGateNewVO.getBkgNumber()[0], flatFileForGateNewVO.getCntrNumber() );
					/***** For Log (S) *****/
					log.info("\n\n===============================================================" +
							  "\n 10. Search BKG by BKG Cycle" +
							  "\n===============================================================" +
							  "\n BKG_CYCLE = " + nmBkgCycle +
							  "\n===============================================================\n");
					/***** For Log (E) *****/
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.getCurrCnmvCycNo] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.getCurrCnmvCycNo] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}

				if ( "".equals(nmBkgCycle) ) { 		/* sqlca.sqlcode == 1403 */
					if (	(	(flatFileForGateNewVO.getGateIo().equals("O")
								|| flatFileForGateNewVO.getGateIo().equals("D")
								|| flatFileForGateNewVO.getGateIo().equals("OA")
								|| flatFileForGateNewVO.getGateIo().equals("P"))
							&&	(flatFileForGateNewVO.getContStat().equals("E")
								|| flatFileForGateNewVO.getContStat().equals("M")
								|| flatFileForGateNewVO.getContStat().equals("AB")))
							|| flatFileForGateNewVO.getMvmtStatus().equals("OP")
							/* (SBK1218) --> */
							|| ((flatFileForGateNewVO.getGateIo().equals("I")
								|| flatFileForGateNewVO.getGateIo().equals("A")
								|| flatFileForGateNewVO.getGateIo().equals("AR")
								|| flatFileForGateNewVO.getGateIo().equals("UR")
								|| flatFileForGateNewVO.getGateIo().equals("N")
								|| flatFileForGateNewVO.getGateIo().equals("R"))
							&& (flatFileForGateNewVO.getContStat().equals("F")
								|| flatFileForGateNewVO.getContStat().equals("AH")
								|| flatFileForGateNewVO.getContStat().equals("AC")))
							|| flatFileForGateNewVO.getMvmtStatus().equals("OC")
							/* <-- (SBK1218) */ ) {

						return true;
						/* Normal BKG Check [OK] (Empty/GateOut or OP & BKG CNTR Cycle doesn't exist)!" */

					} else {
						/* return false;    <----------------- 20100316 By SBKIM Just Do Nothing */
					}

				} else {
					/* 현재 Container의 마지막 Cycle 과 BKG Container의 Cycle이 같은경우 */
					if ( !nmBkgCycle.equals("9999") && nmBkgCycle.equals(maxBkgCycle) ) {

						/* 현재 Cycle에 MT 가 발생했는지를 Check하여 MT가 발생했으면 Old BKG으로 간주하여 BKG No를 지움 */
//						EXEC SQL
//						SELECT  MVMT_STS_CD
//						FROM    CTM_MOVEMENT
//						WHERE   CNTR_NO			= :FlatFileVO.cntrNumber
//						AND     CNMV_CYC_NO		= :nm_bkg_cycle   /* 2010.03.17 SBKIM Just Check Again */
//						AND		MVMT_STS_CD		= 'MT'
//						AND		SYS_AREA_GRP_ID	=	(	/* :current_svr_id	 */
//														SELECT	SYS_AREA_GRP_ID
//														FROM	COM_SYS_AREA_GRP_ID
//														WHERE	CO_IND_CD	= 'H'
//														AND		CNT_CD		= SUBSTR(:FlatFileVO.eventYard,1,2)
//													)   /* Modified By 2010.03.17 By SBKIM */
//						AND		ROWNUM			= 1;

						String cnmsCd = "";
						try {
							log.debug("\n\n===============================================================" +
									  "\n dbDao.getCnmsCd(currBkgCycle)" +
									  "\n===============================================================\n");
							cnmsCd = dbDao.getCnmsCd( flatFileForGateNewVO.getCntrNumber(), nmBkgCycle, flatFileForGateNewVO.getEventYard() );
							/***** For Log (S) *****/
							log.info("\n\n===============================================================" +
									  "\n 11. Search BKG by MT Check" +
									  "\n===============================================================" +
									  "\n MVMT_STS_CD = " + cnmsCd +
									  "\n===============================================================\n");
							/***** For Log (E) *****/
						} catch (DAOException ex) {
							log.error("[GATENEW : dbDao.getCnmsCd] DAOerr : " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						} catch (Exception ex) {
							log.error("[GATENEW : dbDao.getCnmsCd] err : " + ex.toString(), ex);
							throw new EventException(ex.getMessage(), ex);
						}

						if( cnmsCd != null && !cnmsCd.equals("") ) {    // if(sqlca.sqlcode == 0)
							String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
							bkgNumber[0] = "";    /* Empty String */
							flatFileForGateNewVO.setBkgNumber(bkgNumber);
							flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
							int bkgCount = Integer.parseInt(0 + flatFileForGateNewVO.getBkgCount()) < 1 ? 0 : (Integer.parseInt(0 + flatFileForGateNewVO.getBkgCount()) - 1);
							flatFileForGateNewVO.setBkgCount(bkgCount + "");

						} else if ( cnmsCd.equals("") ) {    // else if (sqlca.sqlcode == 1403)
							/* 정상 BKG No로 최종 확인됨 */
							return true;

						}
					} else if ( 0 + Integer.parseInt(nmBkgCycle) < 0 + Integer.parseInt(maxBkgCycle) ) {
						String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
						bkgNumber[0] = "";    /* Empty String */
						flatFileForGateNewVO.setBkgNumber(bkgNumber);
						flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
						int bkgCount = Integer.parseInt(0 + flatFileForGateNewVO.getBkgCount()) < 1 ? 0 : (Integer.parseInt(0 + flatFileForGateNewVO.getBkgCount()) - 1);
						flatFileForGateNewVO.setBkgCount(bkgCount + "");

					}
				}
			}
		} else {
			String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
			bkgNumber[0] = "";    /* Empty String */
			flatFileForGateNewVO.setBkgNumber(bkgNumber);
			flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
			int bkgCount = Integer.parseInt(0 + flatFileForGateNewVO.getBkgCount()) < 1 ? 0 : (Integer.parseInt(0 + flatFileForGateNewVO.getBkgCount()) - 1);
			flatFileForGateNewVO.setBkgCount(bkgCount + "");

		}

		/* Container status 가 Full 이 아니면 Skip 한다. */
		if ((flatFileForGateNewVO.getContStat() != null && !flatFileForGateNewVO.getContStat().equals("")) && (bkgStsCd != null && !bkgStsCd.equals(""))) {

			if (  (!flatFileForGateNewVO.getContStat().equals("F") && !flatFileForGateNewVO.getContStat().equals("AH") && !flatFileForGateNewVO.getContStat().equals("AC") && !flatFileForGateNewVO.getContStat().equals("L"))
					&&(!bkgStsCd.equals("X") && !bkgStsCd.equals("S") && !bkgStsCd.equals("A")) ) {

				return false;
			}
		}


		/* Movement status 가 "VD" 가 아니면서, container server 와 현재 movement server 가 다르면 skip 한다.  */
		/* Container Master의 SVR ID 를 구한다 */
//		EXEC SQL
//		SELECT	SVR_ID
//		INTO	:master_svr_id
//		FROM	MST_CONTAINER	M
//		WHERE	CNTR_NO = :FlatFileVO.cntrNumber;

		String masterSvrId = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.getCodeValue(get masterSvrId)" +
					  "\n===============================================================\n");
			masterSvrId = dbDao.getCodeValueForGateNew("MST_CONTAINER", "CNTR_NO", "SYS_AREA_GRP_ID", flatFileForGateNewVO.getCntrNumber());
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.getCodeValue(get masterSvrId)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.searchCodeValue(get masterSvrId)] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if	( masterSvrId == null || masterSvrId.equals("") ) {
			return false;

		}

		/* Movement Event Location의 Server ID를 구한다 */
//		EXEC SQL
//		SELECT  SVR_ID
//		INTO	:current_svr_id
//		FROM	COM_NIS_SVR_ID
//		WHERE   CNT_CD = SUBSTR(:FlatFileVO.eventYard,1,2)
//		AND	 CO_IND_CD = "H";

		String currSvrId = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.getCodeValue(get currentSvrId)" +
					  "\n===============================================================\n");
			currSvrId = dbDao.getCodeValueForGateNew("COM_SYS_AREA_GRP_ID", "CO_IND_CD = 'H' AND CNT_CD", "SYS_AREA_GRP_ID", subStr(flatFileForGateNewVO.getEventYard(), 0, 2));
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.getCodeValue(get currentSvrId)] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.searchCodeValue(get currentSvrId)] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if	( currSvrId == null || currSvrId.equals("") ) {
			return false;

		}

		if ( !masterSvrId.equals(currSvrId)
		  && !(flatFileForGateNewVO.getGateIo().equals("UV")
			&& (flatFileForGateNewVO.getMvmtStatus().equals("ZZ") || flatFileForGateNewVO.getMvmtStatus().equals("VD") || flatFileForGateNewVO.getMvmtStatus().equals(""))) ) {

			return false;

		}

		/* conainer의 마지막 Cycle에 해당하는 bkg 정보를 구한다. */
		/* 2010 해당 Column Name 재확인 할것 */
//		EXEC SQL
//		SELECT	/*+ ordered index_desc(A XAKBKG_CNTR) index(B XPKBOOKING) 2010 : Index 재조정할것 */
//				B.BKG_NO,
//				A.CNMV_CYC_NO
//		INTO
//				:pre_bkg_number,
//				:pre_cycle_no
//		FROM	BKG_CONTAINER A, BKG_BOOKING B
//		WHERE	A.CNTR_NO = :FlatFileVO.cntrNumber
//		AND		A.CNMV_CYC_NO = (
//										SELECT /*+ ordered index_desc(bc XAKBKG_CNTR)
//										index(bo XPKBOOKING) 2010 : Index 재조정할것 */
//												MAX(CNMV_CYC_NO)
//										FROM	BKG_CONTAINER BC, BKG_BOOKING BO
//										WHERE	BC.CNTR_NO = :FlatFileVO.cntrNumber
//										AND		BC.BKG_NO = BO.BKG_NO
//										AND		NVL(BO.BKG_STS_CD," ") <> "X"
//										AND		NVL(BO.BKG_STS_CD," ") <> "S"
//										AND		NVL(BO.BKG_STS_CD," ") <> DECODE(:FlatFileVO.gateIo,"AE","A","UV","A","X") /* 2008.12.16 */
//										AND		(
//													BC.CNMV_CYC_NO <> 9999
//													OR
//													(	BC.CNMV_CYC_NO = 9999
//														AND
//														SYSDATE - BC.CRE_DT < 30
//													)
//												)
//									)
//		AND		A.BKG_NO = B.BKG_NO
//		AND		NVL(B.BKG_STS_CD," ")  <> "X"
//		AND		NVL(B.BKG_STS_CD," ")  <> "S"
//		AND		NVL(B.BKG_STS_CD," ")  <> DECODE(:FlatFileVO.gateIo,"AE","A","UV","A","X") /* 2008.12.16 */
//		AND		ROWNUM = 1;

		returnValues = new String[2];
		String preBkgNumber = "";
		String preBkgCycle = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.getPreCnmvCycNo" +
					  "\n===============================================================\n");
			returnValues = dbDao.getPreCnmvCycNo( flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getGateIo() );
			preBkgNumber = returnValues[0];
			preBkgCycle = returnValues[1];
			/***** For Log (S) *****/
			log.info("\n\n===============================================================" +
					  "\n 12. Search BKG by Pre Max Cycle" +
					  "\n===============================================================" +
					  "\n PRE_BKG = " + preBkgNumber +
					  "\n PRE_CYC = " + preBkgCycle +
					  "\n===============================================================\n");
			/***** For Log (E) *****/
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.getPreCnmvCycNo] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.getPreCnmvCycNo] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if ( (preBkgNumber == null || preBkgNumber.equals("")) || (preBkgCycle == null || preBkgCycle.equals("")) ) {
			return false;

		}

		/* 마지막 clcye에서 이미 "MT" 가 발생했으면 이전 bkgNumber는 종료된것으로 판단하고 skip 한다. */
		if ( !preBkgCycle.equals("9999") ) {

//			EXEC SQL
//			SELECT	"A"
//			FROM	MST_CONTAINER
//			WHERE	CNTR_NO = :FlatFileVO.cntrNumber
//			AND		CNMV_CYC_NO = :pre_cycle_no;

			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.checkCnmvCycNo" +
						  "\n===============================================================\n");
				if ( !dbDao.checkCnmvCycNo(flatFileForGateNewVO.getCntrNumber(), preBkgCycle) ) {
					return false;
				}
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.checkCnmvCycNo] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.checkCnmvCycNo] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			/* MT History Check Logic For All Bound - 2009.03.30 */
			/* ID인 경우에 대하여 삭제 2006.03.14 By IHJANG - RQST By M.P.Ryu  */
//			SELECT MVMT_STS_CD
//			  FROM CTM_MOVEMENT
//			 WHERE CNTR_NO = :FlatFileVO.cntrNumber
//			   AND CNMV_CYC_NO = :pre_cycle_no
//			   AND MVMT_STS_CD = 'MT'
//			   AND SYS_AREA_GRP_ID = ( /* :current_svr_id */
//			                          SELECT SYS_AREA_GRP_ID
//			                            FROM COM_SYS_AREA_GRP_ID
//			                           WHERE CO_IND_CD = 'H'
//			                             AND CNT_CD = SUBSTR (:FlatFileVO.eventYard, 1, 2)
//			                         ) /* Modified By 2010.03.17 By SBKIM */
//			   AND ROWNUM = 1

			String cnmsCd = "";
			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.getCnmsCd(preBkgCycle)" +
						  "\n===============================================================\n");
                cnmsCd = dbDao.getCnmsCd( flatFileForGateNewVO.getCntrNumber(), preBkgCycle, flatFileForGateNewVO.getEventYard() );
				/***** For Log (S) *****/
				log.info("\n\n===============================================================" +
						  "\n 13. Search BKG by Pre BKG MT Check" +
						  "\n===============================================================" +
						  "\n PRE_CYC = " + preBkgCycle +
						  "\n===============================================================\n");
				/***** For Log (E) *****/
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.getCnmsCd] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.getCnmsCd] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			if (cnmsCd != null && !cnmsCd.equals("")) {
				return false;

			}
		}

		/* bkgNumber를 pre_bkgNumber로 치환한다. */
		String[] bkgNumber = flatFileForGateNewVO.getBkgNumber();
		bkgNumber[0] = (preBkgNumber == null ? "" : preBkgNumber.trim() + "");
		flatFileForGateNewVO.setBkgNumber(bkgNumber);
		flatFileForGateNewVO.setBkgNumber0(bkgNumber[0]);
		return true;

	}


	/**
	 * Container Movement Status 판정<br>
	 *  adjustSightCode for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @param boolean bkgCheck
	 * @return FlatFileForGateNewVO
	 * @exception EventException
	 **/
	private FlatFileForGateNewVO adjustSightCode( FlatFileForGateNewVO flatFileForGateNewVO, boolean bkgCheck ) throws EventException {

		if ( bkgCheck && (flatFileForGateNewVO.getContStat().equals("F") || flatFileForGateNewVO.getContStat().equals("AH") || flatFileForGateNewVO.getContStat().equals("AC") )
					  && (!flatFileForGateNewVO.getGateIo().equals("AE") && !flatFileForGateNewVO.getGateIo().equals("UV")) && !flatFileForGateNewVO.getSightCd().equals("X") ) {

//	        EXEC SQL
//	        SELECT "A"
//	        FROM   CTM_MVEMENT CM, BKG_CONTAINER BC
//	        WHERE  CM.CNTR_NO = :FlatFileVO.cntrNumber
//	        AND    BC.BKG_NO = :FlatFileVO.bkgNumber[0]
//	        AND    BC.CNTR_NO = CM.CNTR_NO
//	        AND    CM.CNMV_CYC_NO = BC.CNMV_CYC_NO
//	        AND    CM.MVMT_STS_CD = "VL";

			boolean checkVdCnmvCycNoYN = false;
			try {
				log.debug("\n\n===============================================================" +
						  "\n dbDao.checkVdCnmvCycNo" +
						  "\n===============================================================\n");
				checkVdCnmvCycNoYN = dbDao.checkVdCnmvCycNo(flatFileForGateNewVO.getCntrNumber(), flatFileForGateNewVO.getBkgNumber()[0]);
			} catch (DAOException ex) {
				log.error("[GATENEW : dbDao.checkVdCnmvCycNo] DAOerr : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			} catch (Exception ex) {
				log.error("[GATENEW : dbDao.checkVdCnmvCycNo] err : " + ex.toString(), ex);
				throw new EventException(ex.getMessage(), ex);
			}

			String newSightCd = "";
			if ( !checkVdCnmvCycNoYN ) {
				if( flatFileForGateNewVO.getMsgId().equals("322") ) {
					newSightCd = "O";

	            } else if ( flatFileForGateNewVO.getMsgId().equals("COD") || flatFileForGateNewVO.getMsgId().equals("PRV") ) {
					newSightCd = "E";

	            }

	    	} else {

//	        	EXEC SQL
//	            SELECT "A"
//	            FROM   BKG_VVD BV, BKG_BOOKING B
//	            WHERE  BV.BKG_NO = :FlatFileVO.bkgNumber[0]
//	            AND    B.BKG_NO = BV.BKG_NO
//	            AND    BV.POD_CD        <>    B.POD_CD
//	            AND    BV.POD_CD = SUBSTR(:FlatFileVO.eventYard,1,5);

				boolean checkPodCdYN = false;
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.checkPodCd" +
							  "\n===============================================================\n");
					checkPodCdYN = dbDao.checkPodCd( flatFileForGateNewVO.getBkgNumber()[0], subStr(flatFileForGateNewVO.getEventYard(), 0, 5) );
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.checkPodCd] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.checkPodCd] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}

				if ( !checkPodCdYN ) {
	            	newSightCd = "I";

				} else {
	            	newSightCd = "N";

				}
	    	}
	        flatFileForGateNewVO.setSightCd(newSightCd);


		}    /*---------------->  2010 By SBKIM : MTY CNTR 일때 Inbound 로 Setting */
		else if ( (flatFileForGateNewVO.getContStat().equals("E") || flatFileForGateNewVO.getContStat().equals("M"))
				 && (!flatFileForGateNewVO.getGateIo().equals("AE") && !flatFileForGateNewVO.getGateIo().equals("UV")) ) {

	        flatFileForGateNewVO.setSightCd("I");

		}    /* 2010.01.25 By SBKIM */
		else if ( flatFileForGateNewVO.getGateIo().equals("AL") && flatFileForGateNewVO.getContStat().equals("F")
			   && (flatFileForGateNewVO.getSightCd() == null || flatFileForGateNewVO.getSightCd().equals("")) ) {

	        flatFileForGateNewVO.setSightCd("I");

		}

		return flatFileForGateNewVO;
	}

	/**
	 * insertEDIMessage for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @return FlatFileForGateNewVO
	 * @exception EventException
	 *
	 * edi_sts.pc
	 **/
	private FlatFileForGateNewVO insertEDIMessage( FlatFileForGateNewVO flatFileForGateNewVO ) throws EventException {

		String[] returnValues = null;
		String returnValue = "";

//	    EXEC SQL
//	    SELECT  DECODE(:FlatFileVO.msgId, "322", "A1", "COD", "A3", "PRV", "A3", "222", "B1", "XX"),
//	            TO_CHAR(SYSDATE,"RRMMDD")
//	    INTO    :FlatFileVO.ediId,
//	            :FlatFileVO.muidDt
//	    FROM    DUAL;

		returnValues = new String[2];
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.getEdiIdfromDual" +
					  "\n===============================================================\n");
			returnValues = dbDao.getEdiIdfromDual( flatFileForGateNewVO.getMsgId() );
			flatFileForGateNewVO.setEdiId(returnValues[0]);
			flatFileForGateNewVO.setMuidDt(returnValues[1]);
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.getEdiIdfromDual] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.getEdiIdfromDual] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		// 최종 bkgNumber, bkgCount setting
		String bkgNumber = "";
		int bkgCount = 0;
		for ( int i=0; i<flatFileForGateNewVO.getBkgNumber().length ; i++ ) {
			if (flatFileForGateNewVO.getBkgNumber()[i] != null && !flatFileForGateNewVO.getBkgNumber()[i].trim().equals("") ) {
				bkgCount++;
				if (bkgCount == 1) {
					bkgNumber = flatFileForGateNewVO.getBkgNumber()[i];
				} else {
					bkgNumber = bkgNumber + "," + flatFileForGateNewVO.getBkgNumber()[i];
				}
			}
		}
		flatFileForGateNewVO.setBkgCount(bkgCount + "");
		flatFileForGateNewVO.setBkgNumber(bkgNumber.split(","));
		// BkgNumber[0](배열0번째)를 BkgNumber0 에 setting
		flatFileForGateNewVO.setBkgNumber0(flatFileForGateNewVO.getBkgNumber()[0] == null ? "" : flatFileForGateNewVO.getBkgNumber()[0] + "");
		// Single Queto처리
		flatFileForGateNewVO.setResultMessage((flatFileForGateNewVO.getResultMessage() == null || flatFileForGateNewVO.getResultMessage().equals(""))? "": flatFileForGateNewVO.getResultMessage().replaceAll("'", "^#^"));

//	    EXEC SQL
//	    SELECT    MAX(MVMT_EDI_MSG_SEQ) + 1
//	    INTO    :FlatFileVO.muidSeq
//	    FROM    CTM_MVMT_EDI_MSG
//	    WHERE    MVMT_EDI_TP_CD = :FlatFileVO.ediId
//	    AND        MVMT_EDI_MSG_TP_ID, = :FlatFileVO.msgId
//	    AND        MVMT_EDI_MSG_AREA_CD = :FlatFileVO.muidArea
//	    AND        MVMT_EDI_MSG_YRMONDY = :FlatFileVO.muidDt
//	    FOR        UPDATE;

		returnValue = "";
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.getMaxMuidSeq" +
					  "\n===============================================================\n");
			/* 원본쿼리 - 현재 임시 시퀀스 적용중
			SELECT MAX (MVMT_EDI_MSG_SEQ) + 1 AS MVMT_EDI_MSG_SEQ
			  FROM CTM_MVMT_EDI_MSG
			 WHERE MVMT_EDI_TP_CD = @[mvmt_edi_tp_cd]
			   AND MVMT_EDI_MSG_TP_ID = @[mvmt_edi_msg_tp_id]
			   AND MVMT_EDI_MSG_AREA_CD = @[mvmt_edi_msg_area_cd]
			   AND MVMT_EDI_MSG_YRMONDY = @[mvmt_edi_msg_yrmondy]
			*/
			returnValue = dbDao.getMaxMuidSeq( flatFileForGateNewVO.getEdiId(), flatFileForGateNewVO.getMsgId(), flatFileForGateNewVO.getMuidArea(), flatFileForGateNewVO.getMuidDt() );
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.getMaxMuidSeq] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.getMaxMuidSeq] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

		if ( returnValue == null || returnValue.equals("") ) {
			flatFileForGateNewVO.setMuidSeq("1");

		} else {
			flatFileForGateNewVO.setMuidSeq(returnValue);

		}

//	    EXEC SQL
//	    INSERT INTO    CTM_MVMT_EDI_MSG
//	        (
//	            MVMT_EDI_TP_CD,
//	            MVMT_EDI_MSG_TP_ID,                MVMT_EDI_MSG_AREA_CD,
//	            MVMT_EDI_MSG_YRMONDY,            MVMT_EDI_MSG_SEQ,
//	            TML_NM,                            CNTR_NO,
//	            EVNT_YD_CD,                        EVNT_DT,
//	            EDI_GATE_IO_CD,                    CNTR_FULL_STS_CD,
//	            CHSS_NO,
//	            CRNT_VSL_CD,                    CRNT_SKD_VOY_NO,                CRNT_SKD_DIR_CD,
//	            BL_NO,                            BL_NO_TP,                        BL_NO_CHK
//	            BKG_KNT,                        BKG_NO,
//	            BKG_POL_CD,                        BKG_POD_CD
//	            DEST_YD_CD,                        CNTR_SEAL_NO,
//	        /*    MGST_NO        */
//	            VNDR_SEQ
//	            MVMT_TRSP_MOD_CD,                FCAR_NO,                        EDI_MVMT_STS_CD
//	            CNTR_HNGR_RCK_FLG,                WBL_NO,                            PKUP_NO
//	            MVMT_EDI_RSLT_CD,                MVMT_EDI_RMK,
//	            RTY_KNT,
//	            MVMT_EDI_SGHT_CD,                CNTR_DMG_FLG,
//	            CALL_SGN_NO,                    LLOYD_NO,
//	            MVMT_EDI_STS_TP_FLG,            OFC_CD,                            CNMV_CO_CD,
//	            CRE_USR_ID,                        UPD_USR_ID,                        CRE_DT
//	            CRE_LOCL_DT,                    UPD_DT,                            UPD_LOCL_DT,
//	            CNTR_TPSZ_CD,					EDI_BKG_NO			/* <---- 2010.02.17 By IHChang */
//	        )
//	    VALUES
//	        (
//	            FlatFileVO.ediId,
//	            FlatFileVO.msgId,                FlatFileVO.muidArea,
//	            FlatFileVO.muidDt,                FlatFileVO.muidSeq,
//	            FlatFileVO.termId,                FlatFileVO.cntrNumber,
//	            FlatFileVO.eventYard,            TO_DATE(:eventDate, "ddMonrr hh24:mi"),
//	            FlatFileVO.gateIo,                FlatFileVO.cont_stat,
//	            FlatFileVO.chssCode,
//	            FlatFileVO.vessel,                FlatFileVO.voyage,                        FlatFileVO.dir,
//	            SUBSTR(FlatFileVO.blNo,1,10),    SUBSTR(FlatFileVO.blNo,11,1),            SUBSTR(FlatFileVO.blNo,12,1),
//	            FlatFileVO.bkgCount,            FlatFileVO.bkgNumber,
//	            FlatFileVO.pol,                    FlatFileVO.pod,
//	            FlatFileVO.destLoc,                FlatFileVO.sealNo,
//	        /*    #####    */
//	            FlatFileVO.vndr_seq,
//	            FlatFileVO.transMode,            FlatFileVO.flatCarNbr,                    FlatFileVO.mvmtStatus,
//	            FlatFileVO.hangerTag,            FlatFileVO.wayBillNo,                    FlatFileVO.pickupNo,
//	            FlatFileVO.resultMessage_ind,    FlatFileVO.resultMessage,        /* 2010 @F_DB_CHECK 의 Return 값을 직접 입력 */
//	            0,
//	            FlatFileVO.sightCd,                FlatFileVO.dmgFlag,
//	            FlatFileVO.callSignNo,            FlatFileVO.lloydNo,
//	            FlatFileVO.mvmt_edi_sts_tp_flg,    FlatFileVO.eventYard,            "HJS",
//	            "GATENEW",                        "GATENEW"                        SYSDATE,
//	            #####(sysdate의 Local time),    SYSDATE,                        #####(sysdate의 Local time)
//				FlatFileVO.cntrTpszCd,			FlatFileVO.ediBkgNo				/* <---- 2010.02.17 By IHChang */
//	        );

		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDao.insertEDIMessage" +
					  "\n===============================================================\n");
			dbDao.insertEDIMessage(flatFileForGateNewVO);
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.insertEDIMessage] DAOerr : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.insertEDIMessage] err : " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}

//      EXEC SQL
//      INSERT INTO CTM_MVMT_EDI_BKG
//          (
//              MVMT_EDI_TP_CD,
//              MVMT_EDI_MSG_TP_ID,            MVMT_EDI_MSG_AREA_CD,
//              MVMT_EDI_MSG_YRMONDY,        MVMT_EDI_MSG_SEQ,
//              BKG_NO,
//              CRE_USR_ID,                    CRE_DT
//              UPD_USR_ID,                    UPD_DT
//          ) VALUES (
//              FlatFileVO.ediId,
//              FlatFileVO.msgId,            FlatFileVO.muidArea,
//              TO_CHAR(SYSDATE,"RRMMDD"),    FlatFileVO.muidSeq,
//              FlatFileVO.bkgNumber[p],
//              "GATENEW",                    SYSDATE,
//              "GATENEW",                    SYSDATE
//          );

		// insertEDIBooking
		CtmMvmtEdiBkgVO ctmMvmtEdiBkgVo = null;
		for ( int p=1; p<flatFileForGateNewVO.getBkgNumber().length ; p++ ) {
			if (flatFileForGateNewVO.getBkgNumber()[p] != null && !flatFileForGateNewVO.getBkgNumber()[p].equals("") ) {
				ctmMvmtEdiBkgVo = new CtmMvmtEdiBkgVO();
				ctmMvmtEdiBkgVo.setMvmtEdiTpCd(flatFileForGateNewVO.getEdiId());
				ctmMvmtEdiBkgVo.setMvmtEdiMsgTpId(flatFileForGateNewVO.getMsgId());
				ctmMvmtEdiBkgVo.setMvmtEdiMsgAreaCd(flatFileForGateNewVO.getMuidArea());
				ctmMvmtEdiBkgVo.setMvmtEdiMsgSeq(flatFileForGateNewVO.getMuidSeq());
				ctmMvmtEdiBkgVo.setCreUsrId(flatFileForGateNewVO.getUserId());
			    // BkgNumber[](배열) setting
				ctmMvmtEdiBkgVo.setBkgNo(flatFileForGateNewVO.getBkgNumber()[p]);
				try {
					log.debug("\n\n===============================================================" +
							  "\n dbDao.insertEDIBooking(ctmMvmtEdiBkgVo)[" + p + "]" +
							  "\n===============================================================\n");
					dbDao.insertEDIBooking(ctmMvmtEdiBkgVo);
				} catch (DAOException ex) {
					log.error("[GATENEW : dbDao.insertEDIBooking] DAOerr : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				} catch (Exception ex) {
					log.error("[GATENEW : dbDao.insertEDIBooking] err : " + ex.toString(), ex);
					throw new EventException(ex.getMessage(), ex);
				}
			}
		}

		return flatFileForGateNewVO;
	}


	/**
	 * resultUpdb for GateNew / EES_CTM_0404 멀티 이벤트<br>
	 * EDI Movement에 대한 멀티이벤트를 처리 <br>
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return SearchEDIMovementListVO
	 * @exception EventException
	 **/
	public SearchEDIMovementListVO resultUpdb( SearchEDIMovementListVO searchEDIMovementListVO ) throws EventException {
		log.debug("\n\n============================== resultIndicator : " + searchEDIMovementListVO.getMvmtEdiRsltCd() +
				  "\n================================ resultMessage : " + searchEDIMovementListVO.getMvmtEdiRmk() + "\n");
		com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration.ContainerMovementMgtDBDAO dbDaoMgt =
			new com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration.ContainerMovementMgtDBDAO();
		
		boolean bUpdateMovement = false;

		if ( "ALEADY ACCEPT".equals(subStr(searchEDIMovementListVO.getMvmtEdiRmk(), 0, 13).toUpperCase())
		  || "NOT ACCEPT CONTAINER!".equals(subStr(searchEDIMovementListVO.getMvmtEdiRmk(), 0, 21).toUpperCase())
		  || "NOT ACCEPT CONTAINER(3)".equals(subStr(searchEDIMovementListVO.getMvmtEdiRmk(), 0, 23).toUpperCase())
		  || "915, ALEADY ACCEPT CNTR".equals(subStr(searchEDIMovementListVO.getMvmtEdiRmk(), 0, 23).toUpperCase())
		  || (!"Y".equals(searchEDIMovementListVO.getEdiUiYn())
			  && "PREVIOUS EVENT DATE IS LATER THAN CURRENT".equals(subStr(searchEDIMovementListVO.getMvmtEdiRmk(), 0, 41).toUpperCase())) )  {

			// 2011.03.31 
			// 이전에 자동생성되었으나 본 EDI가 수신된 data의 경우 event date 를 update 한다.
			if (!"Y".equals(searchEDIMovementListVO.getEdiUiYn())
			  && "PREVIOUS EVENT DATE IS LATER THAN CURRENT EVENT DATE.".equals(subStr(searchEDIMovementListVO.getMvmtEdiRmk(), 0, 53).toUpperCase())){
				bUpdateMovement = true;
			}
	    	searchEDIMovementListVO.setMvmtEdiRmk("OK.PROCESSED (" + searchEDIMovementListVO.getMvmtEdiRmk() + ")");
	    	searchEDIMovementListVO.setMvmtEdiRsltCd("Y");

	    } else if ( "THE SAME DATA".equals(subStr(searchEDIMovementListVO.getMvmtEdiRmk(), 0, 13).toUpperCase()) ) {    /* Same Data Check추가 - 2009.05.12 */
	    	searchEDIMovementListVO.setMvmtEdiRsltCd("I");

//	    } else {
//		    if ( (searchEDIMovementListVO.getMvmtEdiRmk() == null || "".equals(searchEDIMovementListVO.getMvmtEdiRmk().trim())) && !"N".equals(searchEDIMovementListVO.getMvmtEdiRsltCd().trim()) ) {
//				searchEDIMovementListVO.setMvmtEdiRsltCd("Y");
//				if ( searchEDIMovementListVO.getMvmtEdiRmk() == null || "".equals(searchEDIMovementListVO.getMvmtEdiRmk()) ) {
//					searchEDIMovementListVO.setMvmtEdiRmk("OK.PROCESSED");
//				}
//			}
//	    }
	    } else {
	        if ( (searchEDIMovementListVO.getMvmtEdiRmk() == null || "".equals(searchEDIMovementListVO.getMvmtEdiRmk().trim())) && !"N".equals(searchEDIMovementListVO.getMvmtEdiRsltCd().trim()) ) {
	        	searchEDIMovementListVO.setMvmtEdiRsltCd("Y");
	        	
	        	if ( searchEDIMovementListVO.getMvmtEdiRmk() == null || "".equals(searchEDIMovementListVO.getMvmtEdiRmk()) ) {
	        		if ( ( searchEDIMovementListVO.getBatchFlg() != null || !"".equals(searchEDIMovementListVO.getBatchFlg()) ) && searchEDIMovementListVO.getBatchFlg() == "Y" ) {
	        			searchEDIMovementListVO.setMvmtEdiRmk("OK Processed (System Batch)");
	        		} else {
	        			searchEDIMovementListVO.setMvmtEdiRmk("OK.PROCESSED");
	        		}
	        	}
	        }
	    }

		// Single Queto처리
		searchEDIMovementListVO.setMvmtEdiRmk((searchEDIMovementListVO.getMvmtEdiRmk() == null || searchEDIMovementListVO.getMvmtEdiRmk().equals(""))? "":searchEDIMovementListVO.getMvmtEdiRmk().replaceAll("'", "^#^"));
		searchEDIMovementListVO.setCnmvRmk((searchEDIMovementListVO.getCnmvRmk() == null || searchEDIMovementListVO.getCnmvRmk().equals(""))? "":searchEDIMovementListVO.getCnmvRmk().replaceAll("'", "^#^"));

		// CTM_EDI_RSLT_RMK테이블 insert
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDaoMgt.addManageEDIResult - CTM_EDI_RSLT_RMK테이블 insert" +
					  "\n===============================================================\n");
			dbDaoMgt.addManageEDIResult(searchEDIMovementListVO);
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.addManageEDIResult] DAOerr : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.addManageEDIResult] DAOerr : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}

//	    EXEC SQL
//	    UPDATE CTM_MVMT_EDI_MSG
//	    SET    MVMT_EDI_RSLT_CD = :FlatFileVO.resultIndicator
//	           MVMT_EDI_RMK = :FlatFileVO.resultMessage
//	    WHERE  MVMT_EDI_TP_CD = :FlatFileVO.ediId
//	    AND    MVMT_EDI_MSG_TP_ID = :FlatFileVO.msgid
//	    AND    MVMT_EDI_MSG_AREA_CD = :FlatFileVO.muidArea
//	    AND    MVMT_EDI_MSG_YRMONDY = :FlatFileVO.muidDt
//	    AND    MVMT_EDI_MSG_SEQ = :FlatFileVO.muidSeq;

		// updateEDIMessage
		try {
			log.debug("\n\n===============================================================" +
					  "\n dbDaoMgt.modifyManageEDIMovement" +
					  "\n===============================================================\n");			
			dbDaoMgt.modifyManageEDIMovement(searchEDIMovementListVO);
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.updateEDIMessage] DAOerr : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.updateEDIMessage] err : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
//UPDATE  /*+INDEX_DESC(A XAK2CTM_MOVEMENT)*/
//      CTM_MOVEMENT A
//  SET A.CNMV_EVNT_DT = TO_DATE(@[evnt_dt],'YYYYMMDDHH24MISS'),
//      A.CNMV_RMK = 'event date updated by system',
//      A.UPD_USR_ID = @[usr_id],
//      A.UPD_LOCL_DT = GLOBALDATE_PKG.TIME_CONV_FNC ('KRPUS', SYSDATE, SUBSTR (@[evnt_yd_cd], 0, 5 )),
//      A.UPD_DT = SYSDATE
//WHERE A.CNTR_NO   = @[cntr_no]
//  AND A.ORG_YD_CD = @[evnt_yd_cd]
//  AND A.MVMT_CRE_TP_CD = 'A'
//  AND A.MVMT_STS_CD = @[edi_mvmt_sts_cd]
//  -- 새로 들어온 EVENT DATE는 기존 EDI RECEIVING DATE 보다 72H 내의  이전이어야 한다.
//  AND A.CRE_LOCL_DT <= TO_DATE(@[evnt_dt],'YYYYMMDDHH24MISS') + 72/24
//  -- 새로 들어온 EVENT DATE가 이전과 이후의 EVENT DATE 사이여야 한다. (즉, CNMV_SEQ는 변하지 않아아 한다.
//  AND TO_DATE(@[evnt_dt],'YYYYMMDDHH24MISS') BETWEEN
//      (
//        SELECT /*+INDEX_DESC(X XUK1CTM_MOVEMENT)*/
//               X.CNMV_EVNT_DT
//          FROM CTM_MOVEMENT X
//         WHERE X.CNTR_NO = A.CNTR_NO
//           AND X.CNMV_YR||LPAD(X.CNMV_SEQ,5,'0') < A.CNMV_YR||LPAD(A.CNMV_SEQ,5,'0')
//           AND ROWNUM    = 1
//      )
//      AND
//      (
//        SELECT /*+INDEX(X XUK1CTM_MOVEMENT)*/
//               X.CNMV_EVNT_DT
//          FROM CTM_MOVEMENT X
//         WHERE X.CNTR_NO = A.CNTR_NO
//           AND X.CNMV_YR||LPAD(X.CNMV_SEQ,5,'0') > A.CNMV_YR||LPAD(A.CNMV_SEQ,5,'0')
//           AND ROWNUM    = 1
//      )
//  AND ROWNUM = 1		

		try {
			if (bUpdateMovement){
				log.debug("\n\n===============================================================" +
						  "\n dbDaoMgt.modifyCtmMovementEvntDtAfterAutoCre" +
						  "\n===============================================================\n");			
				dbDaoMgt.modifyCtmMovementEvntDtAfterAutoCre(searchEDIMovementListVO);
			}
		} catch (DAOException ex) {
			log.error("[GATENEW : dbDao.modifyCtmMovementEvntDtAfterAutoCre] DAOerr : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("[GATENEW : dbDao.modifyCtmMovementEvntDtAfterAutoCre] err : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
		
		return searchEDIMovementListVO;
	}


	/**
	 * assignCommonVO for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @param int bkgKnt
	 * @return CusCtmMovementVO[]
	 * @exception EventException
	 **/
	public CusCtmMovementVO[] assignCommonVO( FlatFileForGateNewVO flatFileForGateNewVO, int bkgKnt ) throws EventException {
		/* bkg_no배열갯수만큼 VO생성 */
		CusCtmMovementVO[] cusCtmMovementVOs = new CusCtmMovementVO[bkgKnt];

		try {
			for (int i = 0; i < bkgKnt; i++) {
				cusCtmMovementVOs[i] = new CusCtmMovementVO();

				cusCtmMovementVOs[i].setBkgNo((flatFileForGateNewVO.getBkgNumber()[i] == null ? "" : flatFileForGateNewVO.getBkgNumber()[i]));
			    cusCtmMovementVOs[i].setBlNo(subStr(flatFileForGateNewVO.getBlNo(), 0, 12));    // MQ EDI로 12자리 이상이 넘어오므로 짤라서 넘김
			    cusCtmMovementVOs[i].setCallSgnNo(flatFileForGateNewVO.getCallSignNo());
			    cusCtmMovementVOs[i].setChssNo(flatFileForGateNewVO.getChssCode());
				cusCtmMovementVOs[i].setCnmvEvntDt(flatFileForGateNewVO.getEventDate());    // yyyyMMddHHmm형식 (초까지 넘어가지 않게)
				cusCtmMovementVOs[i].setCnmvYr(DateTime.getFormatDate(new java.util.Date(), "yyyy"));
				cusCtmMovementVOs[i].setCntrDmgFlg(flatFileForGateNewVO.getDmgFlag());
				cusCtmMovementVOs[i].setCntrHngrRckFlg(flatFileForGateNewVO.getHangerTag());
				cusCtmMovementVOs[i].setCntrNo(flatFileForGateNewVO.getCntrNumber());
				cusCtmMovementVOs[i].setCntrSealNo(flatFileForGateNewVO.getSealNo());
				cusCtmMovementVOs[i].setCreUsrId(flatFileForGateNewVO.getUserId());
				cusCtmMovementVOs[i].setCrntSkdDirCd(flatFileForGateNewVO.getDir());
				cusCtmMovementVOs[i].setCrntSkdVoyNo(flatFileForGateNewVO.getVoyage());
				cusCtmMovementVOs[i].setCrntVslCd(flatFileForGateNewVO.getVessel());

			    String fullEmptyFlag = (flatFileForGateNewVO.getContStat() == null ? "" : String.valueOf(flatFileForGateNewVO.getContStat()));

				if ("F".equals(fullEmptyFlag) || "L".equals(fullEmptyFlag) || "AH".equals(fullEmptyFlag)) {
					cusCtmMovementVOs[i].setFcntrFlg("F");
				} else if ("M".equals(fullEmptyFlag) || "E".equals(fullEmptyFlag) || "AB".equals(fullEmptyFlag) || "AJ".equals(fullEmptyFlag)) {
					cusCtmMovementVOs[i].setFcntrFlg("M");
			    } else {
			    	cusCtmMovementVOs[i].setFcntrFlg("F");
				}

				cusCtmMovementVOs[i].setLloydNo(flatFileForGateNewVO.getLloydNo());
			    cusCtmMovementVOs[i].setMgstNo(flatFileForGateNewVO.getMgSet());
				cusCtmMovementVOs[i].setMvmtEdiMsgAreaCd(flatFileForGateNewVO.getMuidArea());
				cusCtmMovementVOs[i].setMvmtEdiMsgSeq(flatFileForGateNewVO.getMuidSeq());
				cusCtmMovementVOs[i].setMvmtEdiMsgTpId(flatFileForGateNewVO.getMsgId());
				cusCtmMovementVOs[i].setMvmtEdiMsgYrmondy(flatFileForGateNewVO.getMuidDt());
				cusCtmMovementVOs[i].setMvmtEdiTpCd(flatFileForGateNewVO.getEdiId());
				cusCtmMovementVOs[i].setMvmtStsCd(flatFileForGateNewVO.getMvmtStatus());
			    cusCtmMovementVOs[i].setMvmtTrspModCd(flatFileForGateNewVO.getTransMode());
				cusCtmMovementVOs[i].setOfcCd("");
				cusCtmMovementVOs[i].setOrgYdCd(flatFileForGateNewVO.getEventYard());
				cusCtmMovementVOs[i].setPkupNo(flatFileForGateNewVO.getPickupNo());
				if (flatFileForGateNewVO.getMvmtStatus().equals("VD")) {
				    cusCtmMovementVOs[i].setPodCd(subStr(flatFileForGateNewVO.getEventYard(), 0, 5));
				} else if (flatFileForGateNewVO.getMvmtStatus().equals("VL")) {
					cusCtmMovementVOs[i].setPolCd(subStr(flatFileForGateNewVO.getEventYard(), 0, 5));
				}
				cusCtmMovementVOs[i].setUpdUsrId(flatFileForGateNewVO.getUserId());
				cusCtmMovementVOs[i].setUsrNm(flatFileForGateNewVO.getUserNm());
			    cusCtmMovementVOs[i].setVndrSeq(flatFileForGateNewVO.getVndrSeq());
				cusCtmMovementVOs[i].setWblNo(flatFileForGateNewVO.getWayBillNo());

				// 2016.06.02 김상현 [CHM-201641731] VGM 항목 추가
				cusCtmMovementVOs[i].setVgmMzdTpCd(flatFileForGateNewVO.getVgmMzdTpCd());
				cusCtmMovementVOs[i].setVgmWgtUtCd(flatFileForGateNewVO.getVgmWgtUtCd());
				cusCtmMovementVOs[i].setVgmWgtQty(flatFileForGateNewVO.getVgmWgtQty());
				cusCtmMovementVOs[i].setVgmVrfyDt(flatFileForGateNewVO.getVgmVrfyDt());
				cusCtmMovementVOs[i].setVgmSigCtnt(flatFileForGateNewVO.getVgmSigCtnt());
				cusCtmMovementVOs[i].setVgmRefNo(flatFileForGateNewVO.getVgmRefNo());
				cusCtmMovementVOs[i].setVgmWgtPtyCtnt(flatFileForGateNewVO.getVgmWgtPtyCtnt());
				cusCtmMovementVOs[i].setVgmVrfyOrdCtnt(flatFileForGateNewVO.getVgmVrfyOrdCtnt());
			}
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return cusCtmMovementVOs;
	}

	/**
	 * assignFlatFileVO from MQ Messege<br>
	 *
	 * @param String flatFile
	 * @return FlatFileForGateNewVO[]
	 * @exception EventException
	 **/
	@SuppressWarnings("null")
	public FlatFileForGateNewVO[] assignFlatFileVO( String flatFile ) throws EventException {
		FlatFileForGateNewVO[] flatFileVOs = null;
		String headerKey = "";
		String[] rtn = new String[4];
		String dom_bkg ="";
		String dom_mvmt ="";
		try {
			// [\\{CNTR_MAIN]을 기준으로 split
			//  - allStringArray[0] : MQ Message 헤더
			//  - allStringArray[1] : MQ Message 본문[1] ~
			//  - allStringArray[x] : MQ Message 헤더[x]
			String[] allStringArray = flatFile.toUpperCase().trim().split("\\{CNTR_MAIN");

			// MQ Message 헤더 (S) ================================================================
			//  - 헤더가 빈값이 아니라면 headerKey 추출
			if ( allStringArray[0] != null && !allStringArray[0].trim().equals("") ) {
				String tmpeHeader = "";
				// "UBIZ:~"나 "UDEV:~"로 시작하는 구문검색
				if ( allStringArray[0].indexOf("UBIZ") > -1 ) {
					tmpeHeader = allStringArray[0].substring(allStringArray[0].indexOf("UBIZ"));
				} else if (allStringArray[0].indexOf("UDEV") > -1) {
					tmpeHeader = allStringArray[0].substring(allStringArray[0].indexOf("UDEV"));
				}
				// ":" 기준으로 split해서 뒷부분 추출
				if ( tmpeHeader.indexOf(":") > -1 ) {
					headerKey = tmpeHeader.trim().split(":", 2)[1];
				}
			}
			// MQ Message 헤더 (E) ================================================================

			// MQ Message 본문 (S) ================================================================
			if ( allStringArray[1] != null && !allStringArray[1].trim().equals("") ) {
				flatFileVOs = new FlatFileForGateNewVO[allStringArray.length -1];
				FlatFileForGateNewVO flatFileVo = null;
				String[] oneCaseArray = null;
				String[] columneArray = null;
				StringBuilder strBkgNo = null;
				String[] bkgNoArray = null;
				int bkgKnt = 0;
				// MQ Message 본문갯수만큼 Loop ("{CNTR_MAIN"으로 시작하는 String배열 갯수)
				for ( int i=0; i<allStringArray.length -1; i++ ) {
					// MQ Message 본문낱개를 "\n"을 기준으로 split
					oneCaseArray = allStringArray[i +1].split("\n");
					flatFileVo = new FlatFileForGateNewVO();
					flatFileVo.setFfileRrefNo(headerKey);
					strBkgNo = new StringBuilder();
					// "\n"을 기준으로 split된 갯수만큼 Loop
					for ( int k=0; k<oneCaseArray.length; k++ ) {
						if ( oneCaseArray[k].indexOf(":") > -1 ) {
							columneArray = new String[2];
							columneArray = oneCaseArray[k].split(":", 2);
							// null 처리
							columneArray[0] = (columneArray[0] == null ? "" : columneArray[0].trim() + "");
							columneArray[1] = (columneArray[1] == null ? "" : columneArray[1].trim() + "");
							if ( "AREA".equals(columneArray[0]) ) {
								flatFileVo.setMuidArea(columneArray[1]);
							} else if ( "MSG_ID".equals(columneArray[0]) ) {
								flatFileVo.setMsgId(columneArray[1]);
							} else if ( "CNTR_NO".equals(columneArray[0]) ) {
								flatFileVo.setCntrNumber(columneArray[1]);
							} else if ( "TMNL_ID".equals(columneArray[0]) ) {
								flatFileVo.setTermId(columneArray[1]);
								flatFileVo.setUserNm(subStr(columneArray[1], 0, 20));    // EDI일경우 User Name에 Terminal ID 20자리 셋팅
							} else if ( "EVENT_YARD".equals(columneArray[0]) ) {
								flatFileVo.setEventYard(columneArray[1]);
							} else if ( "EVENT_DT".equals(columneArray[0]) ) {
								flatFileVo.setEventDate(subStr(columneArray[1], 0, 12));
							} else if ( "MVMT_STS".equals(columneArray[0]) ) {
								flatFileVo.setMvmtStatus(columneArray[1]);
							} else if ( "GATE_IO".equals(columneArray[0]) ) {
								flatFileVo.setGateIo(columneArray[1]);
							} else if ( "FL_MT_IND".equals(columneArray[0]) ) {
								flatFileVo.setContStat(columneArray[1]);
							} else if ( "SIGHT_CD".equals(columneArray[0]) ) {
								flatFileVo.setSightCd(columneArray[1]);
							} else if ( "CHSS_CODE".equals(columneArray[0]) ) {
								flatFileVo.setChssCode(columneArray[1]);
							} else if ( "CALLSIGN".equals(columneArray[0]) ) {
								flatFileVo.setCallSignNo(columneArray[1]);
							} else if ( "LLOYD_NO".equals(columneArray[0]) ) {
								flatFileVo.setLloydNo(columneArray[1]);
							} else if ( "BL_NO".equals(columneArray[0]) ) {
								flatFileVo.setBlNo(columneArray[1]);
							} else if ( "POL".equals(columneArray[0]) ) {
								flatFileVo.setPol(columneArray[1]);
							} else if ( "POD".equals(columneArray[0]) ) {
								flatFileVo.setPod(columneArray[1]);
							} else if ( "DEST_LOC".equals(columneArray[0]) ) {
								flatFileVo.setDestLoc(columneArray[1]);
							} else if ( "DMG_FLAG".equals(columneArray[0]) ) {
								flatFileVo.setDmgFlag(columneArray[1]);
							} else if ( "PICKUP_NO".equals(columneArray[0]) ) {
								flatFileVo.setPickupNo(columneArray[1]);
							} else if ( "MG_SET".equals(columneArray[0]) ) {
								flatFileVo.setMgSet(columneArray[1]);
							} else if ( "SUBSTITUTION".equals(columneArray[0]) ) {
								flatFileVo.setSubstitution(columneArray[1]);
							} else if ( "CARRIER_COUNTRY".equals(columneArray[0]) ) {
								flatFileVo.setCarrierCountry(columneArray[1]);
							} else if ( "CARRIER_CD".equals(columneArray[0]) ) {
								flatFileVo.setCarrierCode(columneArray[1]);
							} else if ( "TRANS_MODE".equals(columneArray[0]) ) {
								flatFileVo.setTransMode(columneArray[1]);
							} else if ( "FLAT_CAR_NO".equals(columneArray[0]) ) {
								flatFileVo.setFlatCarNbr(columneArray[1]);
							} else if ( "HANGER_TAG".equals(columneArray[0]) ) {
								flatFileVo.setHangerTag(columneArray[1]);
							} else if ( "WAY_BILL_NO".equals(columneArray[0]) ) {
								flatFileVo.setWayBillNo(columneArray[1]);
							} else if ( "DEL_TAG".equals(columneArray[0]) ) {
								flatFileVo.setDelTag(columneArray[1]);
							} else if ( "SEAL_NO".equals(columneArray[0]) ) {
								flatFileVo.setSealNo(subStr(columneArray[1], 0, 10));
							} else if ( "STOWAGE".equals(columneArray[0]) ) {
								flatFileVo.setStowage(subStr(columneArray[1], 0, 7));
							} else if ("VGM_METHOD".equals(columneArray[0])) { // 2016.06.02 김상현 [CHM-201641731] VGM 항목 추가
								if (!"".equals(columneArray[1])) {
									flatFileVo.setVgmMzdTpCd(subStr(columneArray[1], 0, 3));
								}
							} else if ("VGM_WGTCD".equals(columneArray[0])) {
								if (!"".equals(columneArray[1])) {
									flatFileVo.setVgmWgtUtCd(subStr(columneArray[1], 0, 3));
								}
							} else if ("VGM_WGTQTY".equals(columneArray[0])) {
								flatFileVo.setVgmWgtQty(columneArray[1]);
							} else if ("VGM_VERIDT".equals(columneArray[0])) {
								if (!"".equals(columneArray[1])) {
									flatFileVo.setVgmVrfyDt(subStr(columneArray[1], 0, 12));
								}
							} else if ("VGM_SIGNATURE".equals(columneArray[0])) {
								flatFileVo.setVgmSigCtnt(columneArray[1]);
							} else if ("VGM_REF_NO".equals(columneArray[0])) {
								flatFileVo.setVgmRefNo(columneArray[1]);
							} else if ("VGM_WPA".equals(columneArray[0])) {
								flatFileVo.setVgmWgtPtyCtnt(columneArray[1]);
							} else if ("VGM_VOR".equals(columneArray[0])) {
								flatFileVo.setVgmVrfyOrdCtnt(columneArray[1]);
							} else if ( "BKG_NO".equals(columneArray[0]) ) {
								if (bkgKnt < 31 && !columneArray[1].equals("")) {    // bkgKnt의 최대값이 30개를 넘지 않도록 함
									bkgKnt++;
									if (bkgKnt == 1) {
										strBkgNo.append(columneArray[1]);
									} else {
										strBkgNo.append("," + columneArray[1]);
									}
								}
							}
							columneArray = null;
						}
					}
					flatFileVo.setBkgCount(bkgKnt + "");
					if (bkgKnt > 0) {
						bkgNoArray = strBkgNo.toString().split(",");
					} else {
						bkgNoArray = new String[1];
//						bkgNoArray[0] = "";
						rtn = dbDao.domesticManualProcces(flatFileVo.getCntrNumber() , flatFileVo.getEventYard() ,flatFileVo.getDestLoc());
						dom_mvmt = rtn[0];
						dom_bkg = rtn[3];
						log.debug("===dom_bkg====" + dom_bkg);
						if(dom_mvmt.equals("CO") && dom_bkg.equals("TCHIDUMMYBKG")){
							bkgNoArray[0] = dom_bkg;
							log.debug("===dom_bkg====" + dom_bkg);
						}else {
							bkgNoArray[0] = "";
						}
					}
					flatFileVo.setBkgNumber(bkgNoArray);
					flatFileVo.setBkgNumber0(bkgNoArray[0]);
					flatFileVo.setEdiBkgNo(bkgNoArray[0]);
					flatFileVo.setUserId("EDIUSER");

					flatFileVOs[i] = flatFileVo;
					strBkgNo = null;
					bkgNoArray = null;
					bkgKnt = 0;
					oneCaseArray = null;
					flatFileVo = null;
				}
			}
			// MQ Message 본문 (E) ================================================================
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return flatFileVOs;
	}

	/**
	 * assignEdiUiVO2FlatFileVO for GateNew<br>
	 *
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return FlatFileForGateNewVO
	 * @exception EventException
	 **/
	public FlatFileForGateNewVO assignEdiUiVO2FlatFileVO( SearchEDIMovementListVO searchEDIMovementListVO ) throws EventException {
		FlatFileForGateNewVO flatFileForGateNewVO = new FlatFileForGateNewVO();
		try {
			// 최초 FlatFile로 들어온 것처럼 EdiBkgNo를 BkgNumber에 setting하여 GateNew를 실행
			flatFileForGateNewVO.setBkgNumber0(searchEDIMovementListVO.getEdiBkgNo());
			flatFileForGateNewVO.setBlNo(searchEDIMovementListVO.getBlNo());
			flatFileForGateNewVO.setCallSignNo(searchEDIMovementListVO.getCallSgnNo());
			flatFileForGateNewVO.setLloydNo(searchEDIMovementListVO.getLloydNo());
			flatFileForGateNewVO.setChssCode(searchEDIMovementListVO.getChssNo());
			flatFileForGateNewVO.setContStat(searchEDIMovementListVO.getCntrFullStsCd());
			flatFileForGateNewVO.setCntrNumber(searchEDIMovementListVO.getCntrNo());
			flatFileForGateNewVO.setCntrTpszCd(searchEDIMovementListVO.getCntrTpszCd());
			flatFileForGateNewVO.setSealNo(searchEDIMovementListVO.getCntrSealNo());
			flatFileForGateNewVO.setDir(searchEDIMovementListVO.getCrntSkdDirCd());
			flatFileForGateNewVO.setVoyage(searchEDIMovementListVO.getCrntSkdVoyNo());
			flatFileForGateNewVO.setVessel(searchEDIMovementListVO.getCrntVslCd());
			flatFileForGateNewVO.setDestLoc(searchEDIMovementListVO.getDestYdCd());
			flatFileForGateNewVO.setEdiBkgNo(searchEDIMovementListVO.getEdiBkgNo());
			flatFileForGateNewVO.setGateIo(searchEDIMovementListVO.getEdiGateIoCd());
			flatFileForGateNewVO.setMvmtStatus(searchEDIMovementListVO.getEdiMvmtStsCd());
			flatFileForGateNewVO.setEdiUiYn(searchEDIMovementListVO.getEdiUiYn());
			flatFileForGateNewVO.setEventDate(searchEDIMovementListVO.getEvntDt());
			flatFileForGateNewVO.setEventYard(searchEDIMovementListVO.getEvntYdCd());
			flatFileForGateNewVO.setMgSet(searchEDIMovementListVO.getMgstNo());
			flatFileForGateNewVO.setMuidArea(searchEDIMovementListVO.getMvmtEdiMsgAreaCd());
			flatFileForGateNewVO.setMuidSeq(searchEDIMovementListVO.getMvmtEdiMsgSeq());
			flatFileForGateNewVO.setMsgId(searchEDIMovementListVO.getMvmtEdiMsgTpId());
			flatFileForGateNewVO.setMuidDt(searchEDIMovementListVO.getMvmtEdiMsgYrmondy());
			flatFileForGateNewVO.setResultMessage(searchEDIMovementListVO.getMvmtEdiRmk());
			flatFileForGateNewVO.setResultIndicator(searchEDIMovementListVO.getMvmtEdiRsltCd());
			flatFileForGateNewVO.setSightCd(searchEDIMovementListVO.getMvmtEdiSghtCd());
			flatFileForGateNewVO.setEdiId(searchEDIMovementListVO.getMvmtEdiTpCd());
			flatFileForGateNewVO.setTransMode(searchEDIMovementListVO.getMvmtTrspModCd());
			flatFileForGateNewVO.setPickupNo(searchEDIMovementListVO.getPkupNo());
			flatFileForGateNewVO.setPod(searchEDIMovementListVO.getPodCd());
			flatFileForGateNewVO.setPol(searchEDIMovementListVO.getPolCd());
			flatFileForGateNewVO.setTermId(searchEDIMovementListVO.getTmlNm());
			flatFileForGateNewVO.setUserId(searchEDIMovementListVO.getUserId());
			flatFileForGateNewVO.setUserNm(searchEDIMovementListVO.getUserNm());
			flatFileForGateNewVO.setVndrSeq(searchEDIMovementListVO.getVndrSeq());
			flatFileForGateNewVO.setWayBillNo(searchEDIMovementListVO.getWblNo());
			flatFileForGateNewVO.setStowage(searchEDIMovementListVO.getCntrStwgNo());

			// 2016.06.02 김상현 [CHM-201641731] VGM 항목 추가
			//  - 화면 입력시 DB 처리 오류 방지(값 초기화)
			flatFileForGateNewVO.setVgmMzdTpCd(searchEDIMovementListVO.getVgmMzdTpCd() == null ? "" : searchEDIMovementListVO.getVgmMzdTpCd());
			flatFileForGateNewVO.setVgmWgtUtCd(searchEDIMovementListVO.getVgmWgtUtCd() == null ? "" : searchEDIMovementListVO.getVgmWgtUtCd());
			flatFileForGateNewVO.setVgmWgtQty(searchEDIMovementListVO.getVgmWgtQty() == null ? "" : searchEDIMovementListVO.getVgmWgtQty());
			flatFileForGateNewVO.setVgmVrfyDt(searchEDIMovementListVO.getVgmVrfyDt() == null ? "" : searchEDIMovementListVO.getVgmVrfyDt());
			flatFileForGateNewVO.setVgmSigCtnt(searchEDIMovementListVO.getVgmSigCtnt() == null ? "" : searchEDIMovementListVO.getVgmSigCtnt());
			flatFileForGateNewVO.setVgmRefNo(searchEDIMovementListVO.getVgmRefNo() == null ? "" : searchEDIMovementListVO.getVgmRefNo());
			flatFileForGateNewVO.setVgmWgtPtyCtnt(searchEDIMovementListVO.getVgmWgtPtyCtnt() == null ? "" : searchEDIMovementListVO.getVgmWgtPtyCtnt());
			flatFileForGateNewVO.setVgmVrfyOrdCtnt(searchEDIMovementListVO.getVgmVrfyOrdCtnt() == null ? "" : searchEDIMovementListVO.getVgmVrfyOrdCtnt());

		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return flatFileForGateNewVO;
	}

	/**
	 * assignFlatFileVO2EdiUiVO for GateNew<br>
	 *
	 * @param FlatFileForGateNewVO flatFileForGateNewVO
	 * @param SearchEDIMovementListVO searchEDIMovementListVO
	 * @return SearchEDIMovementListVO
	 * @exception EventException
	 **/
	public SearchEDIMovementListVO assignFlatFileVO2EdiUiVO( FlatFileForGateNewVO flatFileForGateNewVO, SearchEDIMovementListVO searchEDIMovementListVO ) throws EventException {
		try {
			searchEDIMovementListVO.setBkgNo(flatFileForGateNewVO.getBkgNumber0());
			searchEDIMovementListVO.setBlNo(flatFileForGateNewVO.getBlNo());
			searchEDIMovementListVO.setCallSgnLloyd(flatFileForGateNewVO.getCallSignNo().equals("")? flatFileForGateNewVO.getLloydNo(): flatFileForGateNewVO.getCallSignNo());
			searchEDIMovementListVO.setCallSgnNo(flatFileForGateNewVO.getCallSignNo());
			searchEDIMovementListVO.setLloydNo(flatFileForGateNewVO.getLloydNo());
			searchEDIMovementListVO.setChssNo(flatFileForGateNewVO.getChssCode());
			searchEDIMovementListVO.setCntrFullStsCd(flatFileForGateNewVO.getContStat());
			searchEDIMovementListVO.setCntrNo(flatFileForGateNewVO.getCntrNumber());
			searchEDIMovementListVO.setCntrSealNo(flatFileForGateNewVO.getSealNo());
			searchEDIMovementListVO.setCntrStwgNo(flatFileForGateNewVO.getStowage());
			searchEDIMovementListVO.setCrntSkdDirCd(flatFileForGateNewVO.getDir());
			searchEDIMovementListVO.setCrntSkdVoyNo(flatFileForGateNewVO.getVoyage());
			searchEDIMovementListVO.setCntrTpszCd(flatFileForGateNewVO.getCntrTpszCd());
			searchEDIMovementListVO.setCrntVslCd(flatFileForGateNewVO.getVessel());
			searchEDIMovementListVO.setDestYdCd(flatFileForGateNewVO.getDestLoc());
			searchEDIMovementListVO.setEdiBkgNo(flatFileForGateNewVO.getEdiBkgNo());
			searchEDIMovementListVO.setEdiGateIoCd(flatFileForGateNewVO.getGateIo());
			searchEDIMovementListVO.setEdiMvmtStsCd(flatFileForGateNewVO.getMvmtStatus());
			searchEDIMovementListVO.setEdiUiYn(flatFileForGateNewVO.getEdiUiYn());
			searchEDIMovementListVO.setEvntDt(flatFileForGateNewVO.getEventDate());
			searchEDIMovementListVO.setEvntYdCd(flatFileForGateNewVO.getEventYard());
			searchEDIMovementListVO.setMgstNo(flatFileForGateNewVO.getMgSet());
			searchEDIMovementListVO.setMvmtEdiMsgAreaCd(flatFileForGateNewVO.getMuidArea());
			searchEDIMovementListVO.setMvmtEdiMsgSeq(flatFileForGateNewVO.getMuidSeq());
			searchEDIMovementListVO.setMvmtEdiMsgTpId(flatFileForGateNewVO.getMsgId());
			searchEDIMovementListVO.setMvmtEdiMsgYrmondy(flatFileForGateNewVO.getMuidDt());
			searchEDIMovementListVO.setMvmtEdiRmk(flatFileForGateNewVO.getResultMessage());
			searchEDIMovementListVO.setMvmtEdiRsltCd(flatFileForGateNewVO.getResultIndicator());
			searchEDIMovementListVO.setMvmtEdiSghtCd(flatFileForGateNewVO.getSightCd());
			searchEDIMovementListVO.setMvmtEdiTpCd(flatFileForGateNewVO.getEdiId());
			searchEDIMovementListVO.setMvmtTrspModCd(flatFileForGateNewVO.getTransMode());
			searchEDIMovementListVO.setPkupNo(flatFileForGateNewVO.getPickupNo());
			searchEDIMovementListVO.setPodCd(flatFileForGateNewVO.getPod());
			searchEDIMovementListVO.setPolCd(flatFileForGateNewVO.getPol());
			searchEDIMovementListVO.setTmlNm(flatFileForGateNewVO.getTermId());
			searchEDIMovementListVO.setUserId(flatFileForGateNewVO.getUserId());
			searchEDIMovementListVO.setUserNm(flatFileForGateNewVO.getUserNm());
			searchEDIMovementListVO.setVndrSeq(flatFileForGateNewVO.getVndrSeq());
			searchEDIMovementListVO.setWblNo(flatFileForGateNewVO.getWayBillNo());

			searchEDIMovementListVO.setVgmMzdTpCd(flatFileForGateNewVO.getVgmMzdTpCd());
			searchEDIMovementListVO.setVgmRefNo(flatFileForGateNewVO.getVgmRefNo());
			searchEDIMovementListVO.setVgmSigCtnt(flatFileForGateNewVO.getVgmSigCtnt());
			searchEDIMovementListVO.setVgmVrfyDt(flatFileForGateNewVO.getVgmVrfyDt());
			searchEDIMovementListVO.setVgmVrfyOrdCtnt(flatFileForGateNewVO.getVgmVrfyOrdCtnt());
			searchEDIMovementListVO.setVgmWgtPtyCtnt(flatFileForGateNewVO.getVgmWgtPtyCtnt());
			searchEDIMovementListVO.setVgmWgtQty(flatFileForGateNewVO.getVgmWgtQty());
			searchEDIMovementListVO.setVgmWgtUtCd(flatFileForGateNewVO.getVgmWgtUtCd());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return searchEDIMovementListVO;
	}

	/**
	 * 이전 상태 값이 'CP'일 경우이고 현재 booking no.가 invalid할 경우, Domestic booking으로 판단하는 처리
	 * @param cntrNo
	 * @param eventDt
	 * @param bkgNo
	 * @return String
	 * @throws EventException
	 */
	public String checkDomesticBooking(String cntrNo, String eventDt, String bkgNo) throws EventException {
		String preBkgNo = null;

		try {
			cntrNo = dbDao.getCntrNo(cntrNo);
			if (cntrNo != null && !cntrNo.equals("")) {
				CusCtmMovementVO preMovementVo = (new ContainerMovementMgtDBDAO()).searchMovementStatusMst(cntrNo, eventDt);
				// 2016.03.20 김상현 [CHM-201640355] Last Bkg 생성/Update logic 변경2
				//  - "CD"일 때도 Domestic booking No. 복사하도록 보완.
				if (preMovementVo != null && "C".equals(preMovementVo.getMvmtStsCd().substring(0, 1)) && !"CM".equals(preMovementVo.getMvmtStsCd())) {
					preBkgNo = dbDao.checkBkgExist(bkgNo);
					if (preBkgNo == null) {
						preBkgNo = preMovementVo.getBkgNo();
					}
				} else {
					preBkgNo = "NotChange";
				}
			}
		} catch (Exception e) {
			log.error("\n\nException : " + e.getMessage() + "\n", e);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), e);
		}

		return preBkgNo;
	}

	/**
	 * VERMAS EDI data parsing 처리.
	 * @param flatFile
	 * @return CtmVrfdGrsMassEdiMsgVO[]
	 * @throws EventException
	 */
	public CtmVrfdGrsMassEdiMsgVO[] assignVermasFlatFileVO(String flatFile) throws EventException {
		CtmVrfdGrsMassEdiMsgVO ctmVrfdGrsMassEdiMsgVOs[] = null;
		ArrayList<CtmVrfdGrsMassEdiMsgVO> list = new ArrayList<CtmVrfdGrsMassEdiMsgVO>();
		String headerKey = "";

		try {
			// '{VERMAS'를 기준으로 split.
			// fileFiles[0] : Header
			// fileFiles[1] : Body
			String vermases[] = flatFile.toUpperCase().trim().split("\\{VERMAS");

			// Header가 빈 값이 아니라면 headerKey 추출
			if (vermases[0] != null && !vermases[0].trim().equals("")) {
				String tempStr = "";

				// "UBIZ:~"나 "UDEV:~"로 시작하는 구문검색
				if (vermases[0].indexOf("UBIZ") > -1) {
					tempStr = vermases[0].substring(vermases[0].indexOf("UBIZ"));
				} else if (vermases[0].indexOf("UDEV") > -1) {
					tempStr = vermases[0].substring(vermases[0].indexOf("UDEV"));
				}

				// ":" 기준으로 split해서 뒷부분 추출
				if (tempStr.indexOf(":") > -1) {
					headerKey = tempStr.trim().split(":", 2)[1];
				}
			}
			log.debug("Header Key : " + headerKey);

			// 본문 처리
			if (vermases[1] != null && !vermases[1].trim().equals("")) {
				String oneVermas[] = null;
				String fields[] = null;

				for (int i=0; i<(vermases.length - 1); i++) {
					CtmVrfdGrsMassEdiMsgVO ctmVrfdGrsMassEdiMsgVO = new CtmVrfdGrsMassEdiMsgVO();
					CtmVrfdGrsMassEdiMsgVO vermasVO = null;
					CtmVrfdGrsMassEdiMsgVO cntrVO = new CtmVrfdGrsMassEdiMsgVO();
					StringBuffer sealNo = new StringBuffer();

					oneVermas = vermases[i+1].split("\n");

					vermasVO = new CtmVrfdGrsMassEdiMsgVO();
					for (int l=0; l<oneVermas.length; l++) {
						if (oneVermas[l].indexOf(":") > -1) {
							fields = oneVermas[l].split(":", 2);
							fields[0] = fields[0] == null ? "" : fields[0].trim();
							fields[1] = fields[1] == null ? "" : fields[1].trim();

							if ("REF_NO".equals(fields[0])) {
								vermasVO.setRefNo(fields[1]);
							} else if ("FUNC_CD".equals(fields[0])) {
								vermasVO.setFuncCd(fields[1]);
							} else if ("ISSUE_DATE".equals(fields[0])) {
								vermasVO.setIssDt(fields[1]);
							} else if ("CUT_OFF_TIME".equals(fields[0])) {
								vermasVO.setCutOffDt(fields[1]);
							} else if ("POR_NAME".equals(fields[0])) {
								vermasVO.setPorNm(fields[1]);
							} else if ("POR_UNLC".equals(fields[0])) {
								vermasVO.setPorCd(fields[1]);
							} else if ("POR_YDCD".equals(fields[0])) {
								vermasVO.setPorYdCd(fields[1]);
							} else if ("POL_NAME".equals(fields[0])) {
								vermasVO.setPolNm(fields[1]);
							} else if ("POL_UNLC".equals(fields[0])) {
								vermasVO.setPolCd(fields[1]);
							} else if ("POL_YDCD".equals(fields[0])) {
								vermasVO.setPolYdCd(fields[1]);
							} else if ("SUBMIT_NAME".equals(fields[0])) {
								vermasVO.setSmtNm(fields[1]);
							} else if ("SUBMIT_ADDR".equals(fields[0])) {
								vermasVO.setSmtAddr(fields[1]);
							} else if ("SUBMITTER_CITY".equals(fields[0])) {
								vermasVO.setSmtCtyCtnt(fields[1]);
							} else if ("SUBMITTER_STATE".equals(fields[0])) {
								vermasVO.setSmtSteCtnt(fields[1]);
							} else if ("SUBMITTER_ZIP".equals(fields[0])) {
								vermasVO.setSmtZipCtnt(fields[1]);
							} else if ("SUBMITTER_CNTRYCD".equals(fields[0])) {
								vermasVO.setSmtCntCd(fields[1]);
							} else if ("SUBMIT_DETAIL".equals(fields[0])) {
								vermasVO.setSmtCntcDtlCtnt(fields[1]);
							} else if ("SUBMIT_EMAIL".equals(fields[0])) {
								vermasVO.setSmtCntcEml(fields[1]);
							} else if ("SUBMIT_TEL".equals(fields[0])) {
								vermasVO.setSmtCntcPhnCtnt(fields[1]);
							} else if ("VSL_CD:".equals(fields[0])) {
								cntrVO.setVslCd(fields[1]);
							} else if ("VSL_VOY:".equals(fields[0])) {
								cntrVO.setSkdVoyNo(fields[1]);
							} else if ("VSL_DIR:".equals(fields[0])) {
								cntrVO.setSkdDirCd(fields[1]);
							} else if ("VSL_NAME:".equals(fields[0])) {
								cntrVO.setVslNm(fields[1]);
							} else if ("CNTR_NO".equals(fields[0])) {
								cntrVO.setCntrNo(fields[1]);
							} else if ("CNTR_TP".equals(fields[0])) {
								cntrVO.setCntrTpszCd(fields[1]);
							} else if ("VGM_ID".equals(fields[0])) {
								cntrVO.setVgmId(fields[1]);
							} else if ("BKG_REF_NO".equals(fields[0])) {
								cntrVO.setBkgRefNo(fields[1]);
							} else if ("SI_REF_NO".equals(fields[0])) {
								cntrVO.setSiRefNo(fields[1]);
							} else if ("BKG_NO".equals(fields[0])) {
								cntrVO.setBkgNo(fields[1]);
							} else if ("TRANS_CNTR_NO".equals(fields[0])) {
								cntrVO.setTrspCtrlNoCtnt(fields[1]);
							} else if ("VGM_WGTQTY".equals(fields[0])) {
								cntrVO.setVgmWgtQty(fields[1]);
							} else if ("VGM_WGTCD".equals(fields[0])) {
								cntrVO.setVrfdWgtCd(fields[1]);
							} else if ("VGM_METHOD".equals(fields[0])) {
								cntrVO.setVgmMzdTpCd(fields[1]);
							} else if ("DOC_ID".equals(fields[0])) {
								cntrVO.setDocId(fields[1]);
							} else if ("VGM_DMT_DT".equals(fields[0])) {
								cntrVO.setVgmDtmnDt(fields[1]);
							} else if ("VGM_VERI_DT".equals(fields[0])) {
								cntrVO.setVgmVrfyDt(fields[1]);
							} else if ("SEAL_NO".equals(fields[0])) {
								sealNo.append(fields[1].trim());
							} else if ("PARTY_FUNC_CD".equals(fields[0])) {
								ctmVrfdGrsMassEdiMsgVO.setPtyFuncCd(fields[1]);
							} else if ("PARTY_NM".equals(fields[0])) {
								ctmVrfdGrsMassEdiMsgVO.setPtyNm(fields[1]);
							} else if ("PARTY_ADDR".equals(fields[0])) {
								ctmVrfdGrsMassEdiMsgVO.setPtyAddr(fields[1]);
							} else if ("PARTY_CITY".equals(fields[0])) {
								ctmVrfdGrsMassEdiMsgVO.setPtyCtyCtnt(fields[1]);
							} else if ("PARTY_STATE".equals(fields[0])) {
								ctmVrfdGrsMassEdiMsgVO.setPtySteCtnt(fields[1]);
							} else if ("PARTY_ZIP".equals(fields[0])) {
								ctmVrfdGrsMassEdiMsgVO.setPtyZipCtnt(fields[1]);
							} else if ("PARTY_CNTRYCD".equals(fields[0])) {
								ctmVrfdGrsMassEdiMsgVO.setPtyCntCd(fields[1]);
							} else if ("PARTY_PERSON".equals(fields[0])) {
								ctmVrfdGrsMassEdiMsgVO.setPtyPsonNm(fields[1]);
							} else if ("PARTY_TEL".equals(fields[0])) {
								ctmVrfdGrsMassEdiMsgVO.setCmmcCntcPhnCtnt(fields[1]);
							} else if ("PARTY_EMAIL".equals(fields[0])) {
								ctmVrfdGrsMassEdiMsgVO.setCmmcCntcEml(fields[1]);
							} else if ("PARTY_FAX".equals(fields[0])) {
								ctmVrfdGrsMassEdiMsgVO.setCmmcCntcFaxCtnt(fields[1]);
							}
						} else if (oneVermas[l].indexOf("{") > -1 || oneVermas[l].indexOf("}") > -1) {
							if ("{CNTR".equals(oneVermas[l].trim())) {
								cntrVO = new CtmVrfdGrsMassEdiMsgVO();
								sealNo = new StringBuffer();
							} else if ("{CNTR_PARTY".equals(oneVermas[l].trim())) {
								ctmVrfdGrsMassEdiMsgVO = new CtmVrfdGrsMassEdiMsgVO();
							} else if ("}CNTR_PARTY".equals(oneVermas[l].trim())) {
								ctmVrfdGrsMassEdiMsgVO.setRefNo(vermasVO.getRefNo() == null ? "" : vermasVO.getRefNo().trim());
								ctmVrfdGrsMassEdiMsgVO.setFuncCd(vermasVO.getFuncCd() == null ? "" : vermasVO.getFuncCd().trim());
								ctmVrfdGrsMassEdiMsgVO.setIssDt(vermasVO.getIssDt() == null ? "" : vermasVO.getIssDt().trim());
								ctmVrfdGrsMassEdiMsgVO.setCutOffDt(vermasVO.getCutOffDt() == null ? "" : vermasVO.getCutOffDt().trim());
								ctmVrfdGrsMassEdiMsgVO.setPorNm(vermasVO.getPorNm() == null ? "" : vermasVO.getPorNm().trim());
								ctmVrfdGrsMassEdiMsgVO.setPorCd(vermasVO.getPorCd() == null ? "" : vermasVO.getPorCd().trim());
								ctmVrfdGrsMassEdiMsgVO.setPorYdCd(vermasVO.getPorYdCd() == null ? "" : vermasVO.getPorYdCd().trim());
								ctmVrfdGrsMassEdiMsgVO.setPolNm(vermasVO.getPolNm() == null ? "" : vermasVO.getPolNm().trim());
								ctmVrfdGrsMassEdiMsgVO.setPolCd(vermasVO.getPolCd() == null ? "" : vermasVO.getPolCd().trim());
								ctmVrfdGrsMassEdiMsgVO.setPolYdCd(vermasVO.getPolYdCd() == null ? "" : vermasVO.getPolYdCd().trim());
								ctmVrfdGrsMassEdiMsgVO.setSmtNm(vermasVO.getSmtNm() == null ? "" : vermasVO.getSmtNm().trim());
								ctmVrfdGrsMassEdiMsgVO.setSmtAddr(vermasVO.getSmtAddr() == null ? "" : vermasVO.getSmtAddr().trim());
								ctmVrfdGrsMassEdiMsgVO.setSmtCtyCtnt(vermasVO.getSmtCtyCtnt() == null ? "" : vermasVO.getSmtCtyCtnt().trim());
								ctmVrfdGrsMassEdiMsgVO.setSmtSteCtnt(vermasVO.getSmtSteCtnt() == null ? "" : vermasVO.getSmtSteCtnt().trim());
								ctmVrfdGrsMassEdiMsgVO.setSmtZipCtnt(vermasVO.getSmtZipCtnt() == null ? "" : vermasVO.getSmtZipCtnt().trim());
								ctmVrfdGrsMassEdiMsgVO.setSmtCntCd(vermasVO.getSmtCntCd() == null ? "" : vermasVO.getSmtCntCd().trim());
								ctmVrfdGrsMassEdiMsgVO.setSmtCntcDtlCtnt(vermasVO.getSmtCntcDtlCtnt() == null ? "" : vermasVO.getSmtCntcDtlCtnt().trim());
								ctmVrfdGrsMassEdiMsgVO.setSmtCntcEml(vermasVO.getSmtCntcEml() == null ? "" : vermasVO.getSmtCntcEml().trim());
								ctmVrfdGrsMassEdiMsgVO.setSmtCntcPhnCtnt(vermasVO.getSmtCntcPhnCtnt() == null ? "" : vermasVO.getSmtCntcPhnCtnt().trim());
								ctmVrfdGrsMassEdiMsgVO.setVslCd(cntrVO.getVslCd() == null ? "" : cntrVO.getVslCd().trim());
								ctmVrfdGrsMassEdiMsgVO.setSkdVoyNo(cntrVO.getSkdVoyNo() == null ? "" : cntrVO.getSkdVoyNo().trim());
								ctmVrfdGrsMassEdiMsgVO.setSkdDirCd(cntrVO.getSkdDirCd() == null ? "" : cntrVO.getSkdDirCd().trim());
								ctmVrfdGrsMassEdiMsgVO.setVslNm(cntrVO.getVslNm() == null ? "" : cntrVO.getVslNm().trim());
								ctmVrfdGrsMassEdiMsgVO.setCntrNo(cntrVO.getCntrNo() == null ? "" : cntrVO.getCntrNo().trim());
								ctmVrfdGrsMassEdiMsgVO.setCntrTpszCd(cntrVO.getCntrTpszCd() == null ? "" : cntrVO.getCntrTpszCd().trim());
								ctmVrfdGrsMassEdiMsgVO.setVgmId(cntrVO.getVgmId() == null ? "" : cntrVO.getVgmId().trim());
								ctmVrfdGrsMassEdiMsgVO.setBkgRefNo(cntrVO.getBkgRefNo() == null ? "" : cntrVO.getBkgRefNo().trim());
								ctmVrfdGrsMassEdiMsgVO.setSiRefNo(cntrVO.getSiRefNo() == null ? "" : cntrVO.getSiRefNo().trim());
								ctmVrfdGrsMassEdiMsgVO.setBkgNo(cntrVO.getBkgNo() == null ? "" : cntrVO.getBkgNo().trim());
								ctmVrfdGrsMassEdiMsgVO.setTrspCtrlNoCtnt(cntrVO.getTrspCtrlNoCtnt() == null ? "" : cntrVO.getTrspCtrlNoCtnt().trim());
								ctmVrfdGrsMassEdiMsgVO.setVgmWgtQty(cntrVO.getVgmWgtQty() == null ? "" : cntrVO.getVgmWgtQty().trim());
								ctmVrfdGrsMassEdiMsgVO.setVrfdWgtCd(cntrVO.getVrfdWgtCd() == null ? "" : cntrVO.getVrfdWgtCd().trim());
								ctmVrfdGrsMassEdiMsgVO.setVgmMzdTpCd(cntrVO.getVgmMzdTpCd() == null ? "" : cntrVO.getVgmMzdTpCd().trim());
								ctmVrfdGrsMassEdiMsgVO.setDocId(cntrVO.getDocId() == null ? "" : cntrVO.getDocId().trim());
								ctmVrfdGrsMassEdiMsgVO.setVgmDtmnDt(cntrVO.getVgmDtmnDt() == null ? "" : cntrVO.getVgmDtmnDt().trim());
								ctmVrfdGrsMassEdiMsgVO.setVgmVrfyDt(cntrVO.getVgmVrfyDt() == null ? "" : cntrVO.getVgmVrfyDt().trim());
								ctmVrfdGrsMassEdiMsgVO.setSealNoCtnt(sealNo.toString());
								ctmVrfdGrsMassEdiMsgVO.setPtyFuncCd(ctmVrfdGrsMassEdiMsgVO.getPtyFuncCd() == null ? "" : ctmVrfdGrsMassEdiMsgVO.getPtyFuncCd().trim());
								ctmVrfdGrsMassEdiMsgVO.setPtyNm(ctmVrfdGrsMassEdiMsgVO.getPtyNm() == null ? "" : ctmVrfdGrsMassEdiMsgVO.getPtyNm().trim());
								ctmVrfdGrsMassEdiMsgVO.setPtyAddr(ctmVrfdGrsMassEdiMsgVO.getPtyAddr() == null ? "" : ctmVrfdGrsMassEdiMsgVO.getPtyAddr().trim());
								ctmVrfdGrsMassEdiMsgVO.setPtyCtyCtnt(ctmVrfdGrsMassEdiMsgVO.getPtyCtyCtnt() == null ? "" : ctmVrfdGrsMassEdiMsgVO.getPtyCtyCtnt().trim());
								ctmVrfdGrsMassEdiMsgVO.setPtySteCtnt(ctmVrfdGrsMassEdiMsgVO.getPtySteCtnt() == null ? "" : ctmVrfdGrsMassEdiMsgVO.getPtySteCtnt().trim());
								ctmVrfdGrsMassEdiMsgVO.setPtyZipCtnt(ctmVrfdGrsMassEdiMsgVO.getPtyZipCtnt() == null ? "" : ctmVrfdGrsMassEdiMsgVO.getPtyZipCtnt().trim());
								ctmVrfdGrsMassEdiMsgVO.setPtyCntCd(ctmVrfdGrsMassEdiMsgVO.getPtyCntCd() == null ? "" : ctmVrfdGrsMassEdiMsgVO.getPtyCntCd().trim());
								ctmVrfdGrsMassEdiMsgVO.setPtyPsonNm(ctmVrfdGrsMassEdiMsgVO.getPtyPsonNm() == null ? "" : ctmVrfdGrsMassEdiMsgVO.getPtyPsonNm().trim());
								ctmVrfdGrsMassEdiMsgVO.setCmmcCntcPhnCtnt(ctmVrfdGrsMassEdiMsgVO.getCmmcCntcPhnCtnt() == null ? "" : ctmVrfdGrsMassEdiMsgVO.getCmmcCntcPhnCtnt().trim());
								ctmVrfdGrsMassEdiMsgVO.setCmmcCntcEml(ctmVrfdGrsMassEdiMsgVO.getCmmcCntcEml() == null ? "" : ctmVrfdGrsMassEdiMsgVO.getCmmcCntcEml().trim());
								ctmVrfdGrsMassEdiMsgVO.setCmmcCntcFaxCtnt(ctmVrfdGrsMassEdiMsgVO.getCmmcCntcFaxCtnt() == null ? "" : ctmVrfdGrsMassEdiMsgVO.getCmmcCntcFaxCtnt().trim());
								ctmVrfdGrsMassEdiMsgVO.setCreUsrId("EDIUSER");
								ctmVrfdGrsMassEdiMsgVO.setUpdUsrId("EDIUSER");

								if (!"".equals(ctmVrfdGrsMassEdiMsgVO.getCntrNo())) {
									if ("".equals(ctmVrfdGrsMassEdiMsgVO.getBkgNo())) {
										ctmVrfdGrsMassEdiMsgVO.setBkgNo("NONE");
									}
									list.add(ctmVrfdGrsMassEdiMsgVO);
								}
							}
						}
					}
				}
			}

			ctmVrfdGrsMassEdiMsgVOs = new CtmVrfdGrsMassEdiMsgVO[list.size()];
			list.toArray(ctmVrfdGrsMassEdiMsgVOs);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}

		return ctmVrfdGrsMassEdiMsgVOs;
	}

	/**
	 * VERMAS EDI data 저장.
	 * @param ctmVrfdGrsMassEdiMsgVOs
	 * @throws EventException
	 */
	public void addCtmVrfdGrsMassEdiMsg(CtmVrfdGrsMassEdiMsgVO ctmVrfdGrsMassEdiMsgVOs[]) throws EventException {
		com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration.ContainerMovementMgtDBDAO dbDaoMgt =
				new com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.integration.ContainerMovementMgtDBDAO();

		try {
			if (ctmVrfdGrsMassEdiMsgVOs.length > 0) {
				for (int i=0; i<ctmVrfdGrsMassEdiMsgVOs.length; i++) {
					dbDaoMgt.addCtmVrfdGrsMassEdiMsg(ctmVrfdGrsMassEdiMsgVOs[i]);
				}

				// Booking 쪽으로 VERMAS data I/F
				String cntrNo = "";
				String bkgNo = "";
				BLDocumentationCMBC blDocumentationCMBC = new BLDocumentationCMBCImpl();
				CrossItemVO item = null;
				CusCtmMovementVO cusCtmMovementVO = null;
				for (int i=0; i<ctmVrfdGrsMassEdiMsgVOs.length; i++) {
					if (!cntrNo.equals(ctmVrfdGrsMassEdiMsgVOs[i].getCntrNo()) && !bkgNo.equals(ctmVrfdGrsMassEdiMsgVOs[i].getBkgNo())) {
						cntrNo = ctmVrfdGrsMassEdiMsgVOs[i].getCntrNo();
						bkgNo = ctmVrfdGrsMassEdiMsgVOs[i].getBkgNo();

						CtmVrfdGrsMassEdiMsgVO ctmVrfdGrsMassEdiMsgVO = dbDaoMgt.searchVermasDataByCntrNo(cntrNo, bkgNo);
						if (ctmVrfdGrsMassEdiMsgVO != null) {
							cusCtmMovementVO = new CusCtmMovementVO();
							cusCtmMovementVO.setCntrNo(cntrNo);
							cusCtmMovementVO.setBkgNo(bkgNo);
							cusCtmMovementVO.setVgmMzdTpCd(ctmVrfdGrsMassEdiMsgVO.getVgmMzdTpCd());
							cusCtmMovementVO.setVgmRefNo(ctmVrfdGrsMassEdiMsgVO.getRefNo());
							cusCtmMovementVO.setVgmSigCtnt(ctmVrfdGrsMassEdiMsgVO.getPtyPsonNm());
							cusCtmMovementVO.setVgmVrfyDt(ctmVrfdGrsMassEdiMsgVO.getVgmVrfyDt());
							cusCtmMovementVO.setVgmWgtQty(ctmVrfdGrsMassEdiMsgVO.getVgmWgtQty());
							cusCtmMovementVO.setVgmWgtUtCd(ctmVrfdGrsMassEdiMsgVO.getVrfdWgtCd());
							cusCtmMovementVO.setUpdUsrId("EDIUSER");

							item = new CrossItemVO();
							item.setCusCtmMovementVO(cusCtmMovementVO);
							blDocumentationCMBC.updateVGMForOnlyMVMT(item);
						}
					}
				}
			}
		} catch (DAOException ex) {
			log.error("[dbDaoMgt.addCtmVrfdGrsMassEdiMsg] DAOerr : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("[dbDaoMgt.addCtmVrfdGrsMassEdiMsg] err : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CTM10024", new String[]{""}).getMessage(), ex);
		}
	}
}
