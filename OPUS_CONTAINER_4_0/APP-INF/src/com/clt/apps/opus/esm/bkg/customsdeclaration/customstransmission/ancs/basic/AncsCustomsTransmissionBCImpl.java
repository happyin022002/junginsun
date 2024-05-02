/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AncsCustomsTransmissionBCImpl.java
 *@FileTitle : CustomsTransmissionBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.10
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.06.10 정재엽
 * 1.0 Creation
 *------------------------------------------------------
 * History
 * 1. 2011.01.11 이수진 [CHM-201007774] EUR 24HR 관련 구주 세관 시스템 MRN 정보 추가 요청
 *    => Ancs FlatFile에 MRN 정보 추가
 * 2011.12.22 김경섭 [CHM-201115203]] [ESM-BKG] Manifest Transmit (CUSCAR) : B/L Inquiry(ESM_BKG_0045) 화면   전송 Flat File 생성시 C/M 정보 매핑 수정 - CM_PKG_CD: PKG_TP_CD >> CM_PKG_TP_CD로 수정
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.interation.AncsCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsFltFileCusrepVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsLogDtlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsLogDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsManifestVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsSndHisListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsTransBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsTransCmVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsCstmsTransCntrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsRcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.vo.AncsVesselArrivalTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsLogDtlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndHisListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.CstmsSndHisVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.RcvMsgVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsManifestTransmitVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAO;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCstmsAnrBlLogVO;
import com.clt.syscommon.common.table.BkgCstmsAnrCntrLogVO;
import com.clt.syscommon.common.table.BkgCstmsAnrEdiHisVO;
import com.clt.syscommon.common.table.BkgCstmsAnrEdiMsgVO;

/**
 * OPUS-TerminalDocumentation Business Logic Basic Command implementation<br>
 * - OPUS-TerminalDocumentation handling business logic<br>
 * 
 * @author 
 * @see  DAO Reference
 * @since J2EE 1.4
 */ 
public class AncsCustomsTransmissionBCImpl extends BasicCommandSupport implements AncsCustomsTransmissionBC {

	// Database Access Object
	private transient AncsCustomsTransmissionDBDAO dbDao = null;

	/**
	 * AncsCustomsTransmissionBCImpl 객체 생성<br>
	 * AncsCustomsTransmissionDBDAO 생성한다.<br>
	 */
	public AncsCustomsTransmissionBCImpl() {
		dbDao = new AncsCustomsTransmissionDBDAO();
	}
	
	/**
	 * SendLog History
	 * 
	 * @param cstmsSndHisListCondVO
	 * @return List<CstmsSndHisVO>
	 * @throws EventException
	 */
	public List<CstmsSndHisVO> searchCstmsSndHisList(CstmsSndHisListCondVO cstmsSndHisListCondVO) throws EventException {
		try {
			return dbDao.searchAncsCstmsSndHisList((AncsCstmsSndHisListCondVO) cstmsSndHisListCondVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 세관으로 송수신한 메시지 상세 내역 조회
	 * 
	 * @param cstmsLogDtlCondVO
	 * @return
	 * @throws EventException
	 */
	public List<AncsCstmsLogDtlVO> searchCstmsLogDtl(CstmsLogDtlCondVO cstmsLogDtlCondVO) throws EventException {
		try {
			return dbDao.searchAncsCstmsLogDtl((AncsCstmsLogDtlCondVO) cstmsLogDtlCondVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 세관에 VVD 도착 통지 신고를 EDI를 통해 전송한다.
	 * 
	 * @param VesselArrivalTransmitVO vesselArrivalTransmitVO
	 * @param SignOnUserAccount account
	 * @return String 
	 * @exception EventException
	 */
	public String transmitVesselArrival(VesselArrivalTransmitVO vesselArrivalTransmitVO, SignOnUserAccount account) throws EventException {
		try {
			AncsVesselArrivalTransmitVO ancsVsArTranVO = (AncsVesselArrivalTransmitVO) vesselArrivalTransmitVO;

			/*
			 * Cancel 전송인 경우 CUSCAR 를 먼저 삭제해야 하므로 메시지를 보내야 하는 로직 Replace 전송인 경우는 변경된 데이터가 있는 지 검색한다.
			 */
			boolean bRtn = false;
			if ("C".equals(ancsVsArTranVO.getTransflag())) {
				bRtn = dbDao.checkIfAcptCuscarExist(ancsVsArTranVO.getVvd().substring(0,4)
						                           ,ancsVsArTranVO.getVvd().substring(4,8)
						                           ,ancsVsArTranVO.getVvd().substring(8,9) );

				if (bRtn == true)
					throw new EventException(new ErrorHandler("BKG06043").getMessage());
			}

			String sFlatFile = makeCstmsFlatFileCusrep( ancsVsArTranVO.getVvd().substring(0,4)
					                                  , ancsVsArTranVO.getVvd().substring(4,8)
					                                  , ancsVsArTranVO.getVvd().substring(8,9) 
					                                  , ancsVsArTranVO.getTransflag()
					                                  , ancsVsArTranVO.getPod()
					                                  , account);
		
			return sFlatFile;
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 세관 입항 관련 플랫 파일 만들기
	 * 
	 * @param String vslCd
	 * @param String skdVoyNo
	 * @param String skdDirCd
	 * @param String transFlag
	 * @param SignOnUserAccount account 
	 * @return String
	 * @exception EventException
	 */
	private String makeCstmsFlatFileCusrep(String vslCd, String skdVoyNo, String skdDirCd, String transFlag, String pod,SignOnUserAccount account) throws EventException {
		try
		{
			StringBuffer flatFile = new StringBuffer();
			HashMap<String, String> chgListMap = new HashMap<String, String>();
			boolean bBEGIN_PORT = false; 
			boolean bDISCHARGE_IND = false; 
			boolean bBERTH = false; 
			boolean bVESSELNAME = false; 
			boolean bBEGINVESSELFLAG = false; 
			boolean bETA = false; 
			
			//transFlag 를 코드로 변환시켜서 조회 해온다.
			String sTransFlag = "";
			if( "O".equals(transFlag) )
				sTransFlag = "9";
			else if( "R".equals(transFlag) )
				sTransFlag = "5";
			else if( "C".equals(transFlag) )
				sTransFlag = "1";
				
			List<AncsCstmsFltFileCusrepVO> rtnVOs = dbDao.searchAncsCstmsFltFileCusrep(vslCd, skdVoyNo, skdDirCd, sTransFlag);  
			
			/*
			 * Transmission Flag 가 Replace 일때 [시작]
			 * 1. 변환된 데이터가 없을때는 업데이트 하지 않고 예외 처리를 한다.
			 * 2. 변환된 데이터가 있을때는 바뀐 데이터 만 추출하여 전송을 한다.
			 */
			if (rtnVOs.size() > 0) {
				AncsCstmsFltFileCusrepVO rtnVO = rtnVOs.get(0);
				if ("R".equals(transFlag)) {
					List<AncsCstmsManifestVO> list = dbDao.searchAncsCusrepCngList(vslCd, skdVoyNo, skdDirCd, rtnVO.getGdNumber() + rtnVO.getLloydCode());
					for (Iterator<AncsCstmsManifestVO> iterator = list.iterator(); iterator.hasNext();) {
						AncsCstmsManifestVO ancsCstmsManifestVO = iterator.next();
						String sItemDesc = ancsCstmsManifestVO.getItemDesc();
						String sCngFlg = ancsCstmsManifestVO.getCngFlg();
						if ("Y".equals(sCngFlg)) {
							chgListMap.put(sItemDesc, sCngFlg);

							if ("BEGIN_PORT:".equals(sItemDesc))
								bBEGIN_PORT = true;
							if ("DISCHARGE_IND:".equals(sItemDesc))
								bDISCHARGE_IND = true;
							if ("BERTH:".equals(sItemDesc))
								bBERTH = true;
							if ("VESSELNAME:".equals(sItemDesc))
								bVESSELNAME = true;
							if ("VESSELFLAG:".equals(sItemDesc))
								bBEGINVESSELFLAG = true;
							if ("ETA:".equals(sItemDesc))
								bETA = true;
						}
					}
					if (chgListMap.size() == 0) {
						throw new EventException(new ErrorHandler("BKG06044").getMessage());
					}
				} else {
					bBEGIN_PORT = true;
					bDISCHARGE_IND = true;
					bBERTH = true;
					bVESSELNAME = true;
					bBEGINVESSELFLAG = true;
					bETA = true;
				}

				BookingUtil command = new BookingUtil();
//				String receiverId = "DOUANE";
//				if ("BEZEE".equalsIgnoreCase(pod)) {
//					receiverId = "DOUZEE";
//				}
//				String sEdiHeader = command.searchCstmsEdiHeader("HANSHI", receiverId, "CUSREP");
				String sEdiHeader = command.searchCstmsEdiHeaderNew("BE_CUSREP");
				
				CustomsCommonMgtBC comBc = new CustomsCommonMgtBCImpl(); 
				String con_vvd = comBc.searchConVvd(rtnVO.getVvd(), pod, "I");
				
				flatFile.append(sEdiHeader).append("\n");
				flatFile.append("GD_NUMBER:").append(rtnVO.getGdNumber()).append("\n");
				flatFile.append("LLOYDCODE:").append(rtnVO.getLloydCode()).append("\n");
				flatFile.append("SEQUENCE:").append(rtnVO.getSeq()).append("\n");
				flatFile.append("UPDATE_IND:").append(rtnVO.getUpdateInd()).append("\n");
				flatFile.append("PREV_DOCNO:").append(switchNum(String.valueOf(rtnVO.getPrevDocno()), "6")).append("\n");
						
				if (bBEGIN_PORT == true) {
					flatFile.append("{LOC005").append("\n");
					flatFile.append("BEGIN_PORT:").append(rtnVO.getBeginPort()).append("\n");
					flatFile.append("}LOC005").append("\n");
				}
						
				if (bDISCHARGE_IND == true || bBERTH == true) {
					flatFile.append("{LOC060").append("\n");
					if( bDISCHARGE_IND == true )
						flatFile.append("DISCHARGE_IND:").append( rtnVO.getDischargeInd() ).append("\n");

					if (bBERTH == true)
						flatFile.append("BERTH:").append(rtnVO.getBerth()).append("\n");

					flatFile.append("}LOC060").append("\n");
				}

				flatFile.append("{TDT").append("\n");
				flatFile.append("VVD:").append(rtnVO.getVvd()).append("\n");
				flatFile.append("CON_VVD:").append(con_vvd).append("\n");
				if (bVESSELNAME == true)
					flatFile.append("VESSELNAME:").append(rtnVO.getVesselname()).append("\n");
				if (bBEGINVESSELFLAG == true)
					flatFile.append("VESSELFLAG:").append(rtnVO.getVesselflag()).append("\n");

				if (bETA == true) {
					flatFile.append("{DTM132").append("\n");
					flatFile.append("ETA:").append(rtnVO.getEta()).append("\n");
					flatFile.append("}DTM132").append("\n");
				}
				flatFile.append("}TDT");

				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(flatFile.toString());
				sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_ANRCSRP.IBMMQ.QUEUE"));

				FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
				flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

				if (flatFileAckVO.getAckStsCd().equals("E"))
					throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
				
				/*
				 * EDI 이력 테이블에 저장 [ start ]
				 */
				List<BkgCstmsAnrEdiHisVO> bkgCstmsAnrEdiHisVOs = new ArrayList<BkgCstmsAnrEdiHisVO>();
				BkgCstmsAnrEdiHisVO   bkgCstmsAnrEdiHisVO  = new BkgCstmsAnrEdiHisVO();
				List<BkgCstmsAnrEdiMsgVO> bkgCstmsAnrEdiMsgVOs = new ArrayList<BkgCstmsAnrEdiMsgVO>();
				
				bkgCstmsAnrEdiHisVO.setMsgTpCd( "R" ); //CUSREP : R
				bkgCstmsAnrEdiHisVO.setAnrDeclNo( rtnVO.getGdNumber() + rtnVO.getLloydCode() );
				bkgCstmsAnrEdiHisVO.setRefSeq( rtnVO.getSeq() );
				bkgCstmsAnrEdiHisVO.setVslCd(vslCd);
				bkgCstmsAnrEdiHisVO.setSkdVoyNo(skdVoyNo);
				bkgCstmsAnrEdiHisVO.setSkdDirCd(skdDirCd);
				bkgCstmsAnrEdiHisVO.setEdiSndStsCd( transFlag ); 
				bkgCstmsAnrEdiHisVO.setEdiSndUsrId( account.getUsr_id() ); 
				bkgCstmsAnrEdiHisVO.setSndOfcCd(account.getOfc_cd());
				bkgCstmsAnrEdiHisVO.setCreUsrId(account.getUsr_id());
				bkgCstmsAnrEdiHisVO.setUpdUsrId(account.getUsr_id());
				
				bkgCstmsAnrEdiHisVOs.add( bkgCstmsAnrEdiHisVO );
				
				String[] sFlatLineArry = flatFile.toString().split("\n");
				String sMsgSeq = rtnVO.getMsgSeq();
				int iMsgSeq = Integer.parseInt(sMsgSeq);
				for (int i = 0; i < sFlatLineArry.length; i++) {

					BkgCstmsAnrEdiMsgVO bkgCstmsAnrEdiMsgVO = new BkgCstmsAnrEdiMsgVO();
					bkgCstmsAnrEdiMsgVO.setMsgTpCd("R");
					bkgCstmsAnrEdiMsgVO.setRcvSndDivCd("S");
					bkgCstmsAnrEdiMsgVO.setAnrDeclNo(rtnVO.getGdNumber() + rtnVO.getLloydCode());
					bkgCstmsAnrEdiMsgVO.setRefSeq(rtnVO.getSeq());
					bkgCstmsAnrEdiMsgVO.setMsgSeq(String.valueOf(iMsgSeq));
					bkgCstmsAnrEdiMsgVO.setEdiMsg(sFlatLineArry[i]);
					bkgCstmsAnrEdiMsgVO.setCreUsrId(account.getUsr_id());
					bkgCstmsAnrEdiMsgVO.setUpdUsrId(account.getUsr_id());
					bkgCstmsAnrEdiMsgVOs.add(bkgCstmsAnrEdiMsgVO);
					iMsgSeq++;
				}

				dbDao.addBkgCstmsAnrEdiHis(bkgCstmsAnrEdiHisVOs);
				dbDao.addBkgCstmsAnrEdiMsg(bkgCstmsAnrEdiMsgVOs);
				
			} else {
				throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage());
			}
			return flatFile.toString();
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 입력된 숫자를 원하는 크기만큼 앞자리에 "0" 을 채워서 반환하는 메서드.
	 * 
	 * @param String sSource
	 * @param String sLength
	 * @return String
	 * @throws EventException
	 */
	private String switchNum( String sSource, String sLength ) throws EventException {

		int iSrcLth = sSource.length();
		int iLth = Integer.parseInt(sLength);

		int iDefict = iLth - iSrcLth;
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < iDefict; i++) {
			buffer.append("0");
		}
		buffer.append(sSource);

		return buffer.toString();
	}
	
	/**
	 * ANCS 세관에 적하목록 신고를 EDI를 통해 전송한다.
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException {

		try {
			List<AncsCstmsTransCntrVO> cntrList = new ArrayList<AncsCstmsTransCntrVO>();
			AncsCstmsTransBlVO bl = null;
			List<String> arrCntrNo = new ArrayList<String>();
			List<AncsCstmsTransCmVO> cmList = null;
			AncsManifestTransmitVO ancsCstmsManifestVO = null;
			String sPreBlNo = "";
			String dupSsrNo = "";
			
			for (int i = 0; i < manifestTransmitVOs.length; i++) {
				ancsCstmsManifestVO = (AncsManifestTransmitVO) manifestTransmitVOs[i];
				dupSsrNo = dbDao.searchDuplicatedSsrNo(ancsCstmsManifestVO.getVvd()); // 같은 SSR No.를 사용하는 다른 Vessel 있는지 검색
				// 0063에서는 BL이 여러건이므로 여러번 전송
				if ("0063".equals(ancsCstmsManifestVO.getFlatType())) {

					if (i > 0)
						sPreBlNo =  ((AncsManifestTransmitVO)manifestTransmitVOs[i-1]).getBlNo();
					
					if (sPreBlNo.equals(ancsCstmsManifestVO.getBlNo()))
					{
						continue;
					}
					dbDao.modifyBkgCstmsAnrBlVvdSeq(ancsCstmsManifestVO.getVvd(), ancsCstmsManifestVO.getBkgNo(), dupSsrNo); // B/L 테이블의 VVD_SEQ의 값을 insert
					bl = dbDao.searchTransBl(ancsCstmsManifestVO.getBlNo(), ancsCstmsManifestVO.getVvd());
					cmList = dbDao.searchTransCm(ancsCstmsManifestVO.getBlNo(), ancsCstmsManifestVO.getVvd());
					cntrList = dbDao.searchTransCntr(ancsCstmsManifestVO.getBlNo(), arrCntrNo, ancsCstmsManifestVO.getVvd());
					dbDao.modifyBkgCstmsAnrBlAnrMsgStsCd(ancsCstmsManifestVO.getBlNo(), ancsCstmsManifestVO.getVvd()); // B/L 테이블의 Anr_Msg_Sts_Cd 값 지우기
					dbDao.modifyBkgCstmsAnrCntrAnrMsgStsCd(ancsCstmsManifestVO.getBlNo(), arrCntrNo, ancsCstmsManifestVO.getVvd()); // CNTR 테이블의 Anr_Msg_Sts_Cd 값 지우기
					bl.setKind(ancsCstmsManifestVO.getKind());
					bl.setIbflag(ancsCstmsManifestVO.getFlatType());
					this.transmitCuscar(bl, cmList, cntrList, account, ancsCstmsManifestVO);
					
				} else {
					// 0045 (B/L Inquiry에서는 체크한 CNTR만 전송하므로 한번만 전송
					if("1".equals(ancsCstmsManifestVO.getS3())){ // B/L 체크박스에 체크
						dbDao.modifyBkgCstmsAnrBlVvdSeq(ancsCstmsManifestVO.getVvd(), ancsCstmsManifestVO.getBkgNo(), dupSsrNo); // B/L 테이블의 VVD_SEQ의 값을 insert
					}
					if (i == 0) {
						bl = dbDao.searchTransBl(ancsCstmsManifestVO.getBlNo(), ancsCstmsManifestVO.getVvd());
						bl.setKind(ancsCstmsManifestVO.getKind());
						bl.setIbflag(ancsCstmsManifestVO.getFlatType());
						cmList = dbDao.searchTransCm(ancsCstmsManifestVO.getBlNo(), ancsCstmsManifestVO.getVvd()); //CM List도 전송이 가능하게 수정
					}
					if ("1".equals(ancsCstmsManifestVO.getS2()) || "1".equals(ancsCstmsManifestVO.getS3())) // Amend 전송은 컨테이너만 전송해도 됨 그래도 B/L 정보쪽 체크박스 체크하면 모든 컨테이너 정보가 다 나가야 함
					{
						arrCntrNo.add(ancsCstmsManifestVO.getCntrNo());
					}
					if (i == manifestTransmitVOs.length - 1) {
						if("1".equals(ancsCstmsManifestVO.getS3())){ // B/L 체크박스에 체크
							dbDao.modifyBkgCstmsAnrBlAnrMsgStsCd(ancsCstmsManifestVO.getBlNo(), ancsCstmsManifestVO.getVvd()); // B/L 테이블의 Anr_Msg_Sts_Cd 값 지우기
							dbDao.modifyBkgCstmsAnrCntrAnrMsgStsCd(ancsCstmsManifestVO.getBlNo(), arrCntrNo, ancsCstmsManifestVO.getVvd()); // CNTR 테이블의 Anr_Msg_Sts_Cd 값 지우기
						}else{
							dbDao.modifyBkgCstmsAnrCntrAnrMsgStsCd(ancsCstmsManifestVO.getBlNo(), arrCntrNo, ancsCstmsManifestVO.getVvd()); // CNTR 테이블의 Anr_Msg_Sts_Cd 값 지우기
						}
						cntrList = dbDao.searchTransCntr(ancsCstmsManifestVO.getBlNo(), arrCntrNo, ancsCstmsManifestVO.getVvd());
						this.transmitCuscar(bl, cmList, cntrList, account, ancsCstmsManifestVO);
					}
				}
			}
			return "";

		} catch (EventException ex) {
			log.error(ex);
			throw ex;
		} catch (Exception ex) {
			log.error(ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * Cuscar(BL, CNTR)정보를 전송한다.
	 * @param bl
	 * @param cmList
	 * @param cntrList
	 * @param sFlatType
	 * @throws EventException
	 */
	private void transmitCuscar(AncsCstmsTransBlVO bl, List<AncsCstmsTransCmVO> cmList,List<AncsCstmsTransCntrVO> cntrList, SignOnUserAccount account,AncsManifestTransmitVO ancsCstmsManifestVO) throws EventException {
		
		try{
			StringBuffer sbFlatFile = new StringBuffer();
	
			BookingUtil command = new BookingUtil();
			CustomsCommonMgtBC comBc = new CustomsCommonMgtBCImpl();
	
			String sEdiHeader = command.searchCstmsEdiHeaderNew("BE_CUSCAR");
			String con_vvd = comBc.searchConVvd(bl.getVvd(), bl.getPod(), "I");
	
			// STATUS:
			String sKind = bl.getKind();
			if ("O".equals(sKind))
				bl.setStatus("9");
			else if ("T".equals(sKind))
				bl.setStatus("5");
			else if ("C".equals(sKind))
				bl.setStatus("3");
	
			// VVD정보
			sbFlatFile.append(sEdiHeader).append("\n");
			sbFlatFile.append("VVD:").append(bl.getVvd()).append("\n");
			sbFlatFile.append("CON_VVD:").append(con_vvd).append("\n");
			sbFlatFile.append("STATUS:").append(bl.getStatus()).append("\n");
			sbFlatFile.append("LLOYD_CD:").append(bl.getLloydCd()).append("\n");
			sbFlatFile.append("SS_REF_NO:").append(bl.getSsRefNo()).append("\n");
			sbFlatFile.append("SEQUENCE:").append(bl.getSequence()).append("\n");
			sbFlatFile.append("PREV_DOCNO:").append(bl.getPrevDocno()).append("\n");
			
			// BL정보 Manifest Details by B/L에서는 CNTR 정보만 따로 전송이 가능하다. 그래서 CNTR 정보만을 선택하는 경우에는 이 플랫파일을 통과하게 만듦
			if ("0063".equals(bl.getIbflag()) || ("0045".equals(bl.getIbflag()) && "0".equals(ancsCstmsManifestVO.getS1())) || 
					("0045".equals(bl.getIbflag()) && "1".equals(ancsCstmsManifestVO.getS1()) && "1".equals(ancsCstmsManifestVO.getS3()))) {
				sbFlatFile.append("{BL_INFO").append("\n");
				sbFlatFile.append("WGT:").append(bl.getWgt()).append("\n");
				sbFlatFile.append("WGT_U:").append(bl.getWgtU()).append("\n");
				sbFlatFile.append("ART_NO:").append(bl.getArtNo()).append("\n");
				sbFlatFile.append("BL_NO:").append(bl.getBlNo()).append("\n");
				sbFlatFile.append("MRN:").append(bl.getMrn()).append("\n");
				sbFlatFile.append("PKG:").append(bl.getPkg()).append("\n");
				sbFlatFile.append("POD:").append(bl.getPod()).append("\n");
				sbFlatFile.append("BERTH_CD:").append(bl.getBerthCd()).append("\n");
				sbFlatFile.append("POL:").append(bl.getPol()).append("\n");
				sbFlatFile.append("PRE:").append(bl.getPre()).append("\n");
				sbFlatFile.append("POST:").append(bl.getPost()).append("\n");
				sbFlatFile.append("POR:").append(bl.getPor()).append("\n");
				sbFlatFile.append("DEL:").append(bl.getDel()).append("\n");
				sbFlatFile.append("SHPR_NAME:").append(bl.getShprName()).append("\n");
				sbFlatFile.append("SHPR_ADDR:").append(bl.getShprAddr()).append("\n");
				sbFlatFile.append("CNEE_NAME:").append(bl.getCneeName()).append("\n");
				sbFlatFile.append("CNEE_ADDR:").append(bl.getCneeAddr()).append("\n");
				sbFlatFile.append("NTFY_NAME:").append(bl.getNtfyName()).append("\n");
				sbFlatFile.append("NTFY_ADDR:").append(bl.getNtfyAddr()).append("\n");
				sbFlatFile.append("}BL_INFO").append("\n");
				// CM 정보
				for (int j = 0; j < cmList.size(); j++) {
					AncsCstmsTransCmVO cm = cmList.get(j);
					sbFlatFile.append("{CM_INFO").append("\n");
					sbFlatFile.append("CM_SEQ:").append(cm.getCmSeq()).append("\n");
					sbFlatFile.append("CM_PKG_NO:").append(cm.getCmPkgNo()).append("\n");
					sbFlatFile.append("CM_PKG_CD:").append(cm.getCmPkgCd()).append("\n");
					sbFlatFile.append("CM_DESC:").append(cm.getCmDesc()).append("\n");
					sbFlatFile.append("CM_WGT:").append(cm.getCmWgt()).append("\n");
					sbFlatFile.append("CM_WGT_U:").append(cm.getCmWgtU()).append("\n");
					sbFlatFile.append("CM_CNTR_NO:").append(cm.getCmCntrNo()).append("\n");
					sbFlatFile.append("T1_IND:").append(cm.getT1Ind()).append("\n");
					sbFlatFile.append("}CM_INFO").append("\n");
				}
			}
			// CNTR 정보
			for (int j = 0; j < cntrList.size(); j++) {
				AncsCstmsTransCntrVO cntr = cntrList.get(j);
				sbFlatFile.append("{CNTR_INFO").append("\n");
				sbFlatFile.append("CNTR_NO:").append(cntr.getCntrNo()).append("\n");
				sbFlatFile.append("CNTR_TS:").append(cntr.getCntrTs()).append("\n");
				sbFlatFile.append("CNTR_FM:").append(cntr.getCntrFm()).append("\n");
				sbFlatFile.append("CNTR_WGT:").append(cntr.getCntrWgt()).append("\n");
				sbFlatFile.append("RD_TERM:").append(cntr.getRdTerm()).append("\n");
				sbFlatFile.append("}CNTR_INFO").append("\n");
			}
	
			this.writeCstmsManifestSendLog(bl, cntrList, sbFlatFile.toString(), account, ancsCstmsManifestVO);
			
			// 전송
			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(sbFlatFile.toString());
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_ANRCSCR.IBMMQ.QUEUE"));
			FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
			flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
			log.debug("%%%%%%%%%%%%"+sbFlatFile.toString());
			if (flatFileAckVO.getAckStsCd().equals("E"))
				throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
			
			
		} catch (EventException ex) {
			log.error(ex);
			throw ex;
		} catch (Exception ex) {
			log.error(ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}
	/**
	 * 세관에 EDI 메시지 송신 후 기록을 남김
	 * 
	 * @param cstmsManifestVO
	 * @param account
	 * @param sMsgTpCd
	 * @throws EventException
	 */
	private void writeCstmsManifestSendLog(AncsCstmsTransBlVO bl, List<AncsCstmsTransCntrVO> cntrList, String strFlatFile, SignOnUserAccount account,AncsManifestTransmitVO ancsCstmsManifestVO) throws EventException {

		try {
			// 로그
			List<BkgCstmsAnrEdiMsgVO>  bkgCstmsAnrEdiMsgVOs  = new ArrayList<BkgCstmsAnrEdiMsgVO>();
			List<BkgCstmsAnrEdiHisVO>  bkgCstmsAnrEdiHisVOs  = new ArrayList<BkgCstmsAnrEdiHisVO>();
			List<BkgCstmsAnrBlLogVO>   bkgCstmsAnrBlLogVOs   = new ArrayList<BkgCstmsAnrBlLogVO>();
			List<BkgCstmsAnrCntrLogVO> bkgCstmsAnrCntrLogVOs = new ArrayList<BkgCstmsAnrCntrLogVO>();

			// FlatFile
			String[] sFlatLineArry = strFlatFile.split("\n");
			for (int i = 0; i < sFlatLineArry.length; i++) {
				BkgCstmsAnrEdiMsgVO bkgCstmsAnrEdiMsgVO = new BkgCstmsAnrEdiMsgVO();
				bkgCstmsAnrEdiMsgVO.setMsgTpCd("C");
				bkgCstmsAnrEdiMsgVO.setRcvSndDivCd("S");
				bkgCstmsAnrEdiMsgVO.setAnrDeclNo(bl.getSsRefNo() + bl.getLloydCd());
				bkgCstmsAnrEdiMsgVO.setRefSeq(bl.getSequence());
				bkgCstmsAnrEdiMsgVO.setMsgSeq(String.valueOf(i + 1));
				bkgCstmsAnrEdiMsgVO.setEdiMsg(sFlatLineArry[i]);
				bkgCstmsAnrEdiMsgVO.setCreUsrId(account.getUsr_id());
				bkgCstmsAnrEdiMsgVO.setUpdUsrId(account.getUsr_id());
				bkgCstmsAnrEdiMsgVOs.add(bkgCstmsAnrEdiMsgVO);
			}
			dbDao.addBkgCstmsAnrEdiMsg(bkgCstmsAnrEdiMsgVOs);
			
			BkgCstmsAnrEdiHisVO bkgCstmsAnrEdiHisVO = new BkgCstmsAnrEdiHisVO();
			bkgCstmsAnrEdiHisVO.setMsgTpCd("C");
			bkgCstmsAnrEdiHisVO.setAnrDeclNo(bl.getSsRefNo() + bl.getLloydCd());
			bkgCstmsAnrEdiHisVO.setRefSeq(bl.getSequence());
			bkgCstmsAnrEdiHisVO.setVslCd(bl.getVslCd());
			bkgCstmsAnrEdiHisVO.setSkdVoyNo(bl.getSkdVoyNo());
			bkgCstmsAnrEdiHisVO.setSkdDirCd(bl.getSkdDirCd());
			bkgCstmsAnrEdiHisVO.setEdiSndStsCd(bl.getKind());
			bkgCstmsAnrEdiHisVO.setEdiSndUsrId( account.getUsr_id() );
			bkgCstmsAnrEdiHisVO.setSndOfcCd(account.getOfc_cd());
			bkgCstmsAnrEdiHisVO.setCreUsrId(account.getUsr_id());
			bkgCstmsAnrEdiHisVO.setUpdUsrId(account.getUsr_id());
			bkgCstmsAnrEdiHisVOs.add(bkgCstmsAnrEdiHisVO);
			dbDao.addBkgCstmsAnrEdiHis(bkgCstmsAnrEdiHisVOs);

			if ("0063".equals(bl.getIbflag()) || ("0045".equals(bl.getIbflag()) && "0".equals(ancsCstmsManifestVO.getS1())) || 
					("0045".equals(bl.getIbflag()) && "1".equals(ancsCstmsManifestVO.getS1()) && "1".equals(ancsCstmsManifestVO.getS3()))) {
				BkgCstmsAnrBlLogVO bkgCstmsAnrBlLogVO = new BkgCstmsAnrBlLogVO();
				bkgCstmsAnrBlLogVO.setAnrDeclNo(bl.getSsRefNo() + bl.getLloydCd());
				bkgCstmsAnrBlLogVO.setRefSeq(bl.getSequence());
				bkgCstmsAnrBlLogVO.setBlNo(bl.getBlNo());
				bkgCstmsAnrBlLogVO.setVslCd(bl.getVslCd());
				bkgCstmsAnrBlLogVO.setSkdVoyNo(bl.getSkdVoyNo());
				bkgCstmsAnrBlLogVO.setSkdDirCd(bl.getSkdDirCd());
				bkgCstmsAnrBlLogVO.setBkgNo(bl.getBkgNo());
				bkgCstmsAnrBlLogVO.setEdiRcvStsCd(bl.getAnrMsgStsCd());
				bkgCstmsAnrBlLogVO.setCreUsrId(account.getUsr_id());
				bkgCstmsAnrBlLogVO.setUpdUsrId(account.getUsr_id());
				bkgCstmsAnrBlLogVOs.add(bkgCstmsAnrBlLogVO);
				dbDao.addBkgCstmsAnrBlLog(bkgCstmsAnrBlLogVOs);
			}
			
			for (int i = 0; i < cntrList.size(); i++) {
				AncsCstmsTransCntrVO cntr = cntrList.get(i);
				BkgCstmsAnrCntrLogVO bkgCstmsAnrCntrLogVO = new BkgCstmsAnrCntrLogVO();
				bkgCstmsAnrCntrLogVO.setAnrDeclNo(bl.getSsRefNo() + bl.getLloydCd());
				bkgCstmsAnrCntrLogVO.setRefSeq(bl.getSequence());
				bkgCstmsAnrCntrLogVO.setCntrNo(cntr.getCntrNo());
				bkgCstmsAnrCntrLogVO.setVslCd(bl.getVslCd());
				bkgCstmsAnrCntrLogVO.setSkdVoyNo(bl.getSkdVoyNo());
				bkgCstmsAnrCntrLogVO.setSkdDirCd(bl.getSkdDirCd());
				bkgCstmsAnrCntrLogVO.setBkgNo(bl.getBkgNo());
				bkgCstmsAnrCntrLogVO.setCreUsrId(account.getUsr_id());
				bkgCstmsAnrCntrLogVO.setUpdUsrId(account.getUsr_id());
				bkgCstmsAnrCntrLogVOs.add(bkgCstmsAnrCntrLogVO);
			}
			dbDao.addBkgCstmsAnrCntrLog(bkgCstmsAnrCntrLogVOs);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * EDI Inbound 처리 메서드 
	 * 
	 * @param String rcvMsg
	 * @param SignOnUserAccount account
	 * @return RcvMsgVO
	 * @exception EventException
	 */
	public RcvMsgVO loadCstmsRcvMsg(String rcvMsg, SignOnUserAccount account) throws EventException {

		try {
			AncsRcvMsgVO ancsRcvMsgVO = new AncsRcvMsgVO();

			String sTemp = rcvMsg.replaceAll("\r\n", "\n");
			String[] sFlatLineArry = sTemp.split("\n");
			HashMap<String, String> hmAncsRcvMsg = new HashMap<String, String>();

			for (int i = 0; i < sFlatLineArry.length; i++) {
				String[] sTempArry = sFlatLineArry[i].split(":");
				if (sTempArry.length == 2) {
					hmAncsRcvMsg.put(sTempArry[0].trim(), sTempArry[1]);
				} else if (sTempArry.length == 3) {
					hmAncsRcvMsg.put(sTempArry[0].trim(), sTempArry[1] + sTempArry[2]);
				}
			}
			ancsRcvMsgVO.setMsgstart(hmAncsRcvMsg.get("$$$MSGSTART"));
			ancsRcvMsgVO.setDclrNo(hmAncsRcvMsg.get("DCLR_NO"));
			ancsRcvMsgVO.setMsgId(hmAncsRcvMsg.get("MSG_ID"));
			ancsRcvMsgVO.setRefSeq(hmAncsRcvMsg.get("REF_SEQ"));
			ancsRcvMsgVO.setRcvSts(hmAncsRcvMsg.get("RCV_STS"));

			if ("48".equals(hmAncsRcvMsg.get("RCV_STS")) || "45".equals(hmAncsRcvMsg.get("RCV_STS"))) {
				ancsRcvMsgVO.setErrDiv(hmAncsRcvMsg.get("ERR_DIV"));
				ancsRcvMsgVO.setNumber(hmAncsRcvMsg.get("NUMBER"));
				ancsRcvMsgVO.setErrLoc(hmAncsRcvMsg.get("ERR_LOC"));
				ancsRcvMsgVO.setErrCd(hmAncsRcvMsg.get("ERR_CD"));
				ancsRcvMsgVO.setErrDesc(hmAncsRcvMsg.get("ERR_DESC"));
				ancsRcvMsgVO.setErrDtl(hmAncsRcvMsg.get("ERR_DTL"));
			}
			ancsRcvMsgVO.setSFlatFileArry(sFlatLineArry);

			List<BkgCstmsAnrEdiHisVO> bkgCstmsAnrEdiHisVOs = new ArrayList<BkgCstmsAnrEdiHisVO>();
			List<BkgCstmsAnrEdiMsgVO> bkgCstmsAnrEdiMsgVOs = new ArrayList<BkgCstmsAnrEdiMsgVO>();

			String[] sFlatFileArry = ancsRcvMsgVO.getSFlatFileArry();
			String sMsgTpCd = "R";
			if ("CUSREP".equals(ancsRcvMsgVO.getMsgId()))
				sMsgTpCd = "R";
			else
				sMsgTpCd = "C";
			String sUsr_Id = "ESM_BKG_0494";// account.getUsr_id();
			String sRcvStsCd = "A";
			if ("44".equals(ancsRcvMsgVO.getRcvSts()))
				sRcvStsCd = "A";
			else
				sRcvStsCd = "E";

			/*
			 * 1.수신된 메시지의 LINE 수 만큼 LOOP 돌며 한 LINE 씩 BKG_CSTMS_ANR_EDI_MSG에 넣기
			 * INSERT INTO BKG_CSTMS_ANR_EDI_MSG
      		 * (MSG_TP_CD, RCV_SND_DIV_CD, ANR_DECL_NO, REF_SEQ, MSG_SEQ, EDI_MSG)
    		 * VALUES
      		 * ('C', 'R', $(DCLR_NO:), $(REF_SEQ:), $(LINE NO), $(LINE TEXT));
			 */
			for (int j = 0; j < sFlatFileArry.length; j++) {
				BkgCstmsAnrEdiMsgVO bkgCstmsAnrEdiMsgVO = new BkgCstmsAnrEdiMsgVO();
				bkgCstmsAnrEdiMsgVO.setMsgTpCd(sMsgTpCd);
				bkgCstmsAnrEdiMsgVO.setRcvSndDivCd("R");
				bkgCstmsAnrEdiMsgVO.setAnrDeclNo(ancsRcvMsgVO.getDclrNo());
				bkgCstmsAnrEdiMsgVO.setRefSeq(ancsRcvMsgVO.getRefSeq());
				bkgCstmsAnrEdiMsgVO.setMsgSeq(String.valueOf(j));
				bkgCstmsAnrEdiMsgVO.setEdiMsg(sFlatFileArry[j]);
				bkgCstmsAnrEdiMsgVO.setCreUsrId(sUsr_Id);
				bkgCstmsAnrEdiMsgVO.setUpdUsrId(sUsr_Id);

				bkgCstmsAnrEdiMsgVOs.add(bkgCstmsAnrEdiMsgVO);
			}
			dbDao.addBkgCstmsAnrEdiMsg(bkgCstmsAnrEdiMsgVOs);
		
			/*
			 * 3. 수신한 $(DCLR_NO:)와 $(REF_SEQ:)로  BKG_CSTMS_ANR_EDI_HIS의 수신 결과 초기화
			 *    UPDATE BKG_CSTMS_ANR_EDI_HIS
			 *       SET EDI_RCV_STS_CD = NULL,
			 *           RCV_DT = SYSDATE,
			 *           ANR_EDI_RTN_ID = $(RCV_STS:),
			 *           MSG_LOC_CD = NULL,
			 *           EDI_MSG_ERR_ID = NULL,
			 *           ERR_DESC = NULL,
			 *           ERR_CTNT = NULL
			 *     WHERE MSG_TP_CD = 'C'
		 	 *       AND ANR_DECL_NO = $(DCLR_NO:)
		 	 *       AND REF_SEQ = $(REF_SEQ:)
			 * 
			 */
			BkgCstmsAnrEdiHisVO bkgCstmsAnrEdiHisVO = new BkgCstmsAnrEdiHisVO();
			bkgCstmsAnrEdiHisVO.setEdiRcvStsCd(sRcvStsCd);
			bkgCstmsAnrEdiHisVO.setAnrEdiRtnId(ancsRcvMsgVO.getRcvSts());
			bkgCstmsAnrEdiHisVO.setUpdUsrId(sUsr_Id);
			bkgCstmsAnrEdiHisVO.setMsgTpCd(sMsgTpCd);
			bkgCstmsAnrEdiHisVO.setAnrDeclNo(ancsRcvMsgVO.getDclrNo());
			bkgCstmsAnrEdiHisVO.setRefSeq(ancsRcvMsgVO.getRefSeq());

			bkgCstmsAnrEdiHisVOs.add(bkgCstmsAnrEdiHisVO);
			dbDao.modifyBkgCstmsAnrEdiHis(bkgCstmsAnrEdiHisVOs);

			/*
			 * 4. 수신 메시지의 $(ERR_DIV:) = "M"인 ERROR 루프가 존재하면, 한번만,
			 *       BKG_CSTMS_ANR_EDI_HIS 업데이트
			 *     UPDATE BKG_CSTMS_ANR_EDI_HIS
			 *        SET MSG_LOC_CD = $(ERR_LOC:),
			 *            EDI_MSG_ERR_ID = $(ERR_CD:),
			 *            ERR_DESC = $(ERR_DESC:),
			 *            ERR_CTNT = $(ERR_DTL:)
			 *      WHERE MSG_TP_CD = 'C'
			 *        AND ANR_DECL_NO = $(DCLR_NO:)
			 *        AND REF_SEQ = $(REF_SEQ:)
			 */
			if ("M".equals(ancsRcvMsgVO.getErrDiv())) {

				BkgCstmsAnrEdiHisVO bkgCstmsAnrEdiHisVO2 = new BkgCstmsAnrEdiHisVO();
				bkgCstmsAnrEdiHisVO2.setEdiRcvStsCd(sRcvStsCd);
				bkgCstmsAnrEdiHisVO2.setAnrEdiRtnId(ancsRcvMsgVO.getRcvSts());
				bkgCstmsAnrEdiHisVO2.setMsgLocCd(ancsRcvMsgVO.getErrLoc());
				bkgCstmsAnrEdiHisVO2.setEdiMsgErrId(ancsRcvMsgVO.getErrCd());
				bkgCstmsAnrEdiHisVO2.setErrDesc(ancsRcvMsgVO.getErrDesc());
				bkgCstmsAnrEdiHisVO2.setErrCtnt(ancsRcvMsgVO.getErrDtl());
				bkgCstmsAnrEdiHisVO2.setUpdUsrId(sUsr_Id);
				bkgCstmsAnrEdiHisVO2.setMsgTpCd(sMsgTpCd);
				bkgCstmsAnrEdiHisVO2.setAnrDeclNo(ancsRcvMsgVO.getDclrNo());
				bkgCstmsAnrEdiHisVO2.setRefSeq(ancsRcvMsgVO.getRefSeq());

				bkgCstmsAnrEdiHisVOs.add(bkgCstmsAnrEdiHisVO2);
				dbDao.modifyBkgCstmsAnrEdiHis(bkgCstmsAnrEdiHisVOs);
			}
			//sRcvStsCd는 RCV_STS가 44가 아니면E 44이면 A
			//BKG_CSTMS_ANR_BL_LOG
			if( "C".equals(sMsgTpCd) ){
				
				/*
				 * 5. 수신한 $(DCLR_NO:)와 $(REF_SEQ:)로 BKG_CSTMS_ANR_BL_LOG의 수신 결과 초기화
				 *     UPDATE BKG_CSTMS_ANR_BL_LOG
				 *        SET EDI_RCV_STS_CD = 'N',
				 *            MSG_LOC_CD = NULL,
				 *            EDI_MSG_ERR_ID = NULL,
				 *            ERR_DESC = NULL,
				 *            ERR_CTNT = NULL
				 *      WHERE MSG_TP_CD = 'C'
				 *        AND ANR_DECL_NO = $(DCLR_NO:)
				 *        AND REF_SEQ = $(REF_SEQ:)
				 */
				List<BkgCstmsAnrBlLogVO> bkgCstmsAnrBlLogVOs = new ArrayList<BkgCstmsAnrBlLogVO>();
				BkgCstmsAnrBlLogVO bkgCstmsAnrBlLogVO = new BkgCstmsAnrBlLogVO();
				bkgCstmsAnrBlLogVO.setEdiRcvStsCd("N");
				sRcvStsCd = "N";
				bkgCstmsAnrBlLogVO.setUpdUsrId(sUsr_Id);
				bkgCstmsAnrBlLogVO.setMsgTpCd(sMsgTpCd);
				bkgCstmsAnrBlLogVO.setAnrDeclNo(ancsRcvMsgVO.getDclrNo());
				bkgCstmsAnrBlLogVO.setRefSeq(ancsRcvMsgVO.getRefSeq());

				bkgCstmsAnrBlLogVOs.add(bkgCstmsAnrBlLogVO);
				dbDao.modifyBkgCstmsAnrBlLog(bkgCstmsAnrBlLogVOs);

				/*
				 * 6. 수신 메시지의 $(ERR_DIV:) = "B"인 ERROR 루프가 존재하면, 한번만,
				 *       BKG_CSTMS_ANR_BL_LOG 업데이트
				 *     UPDATE BKG_CSTMS_ANR_BL_LOG
				 *        SET EDI_RCV_STS_CD = 'E',
				 *            MSG_LOC_CD = $(ERR_LOC:),
				 *            EDI_MSG_ERR_ID = $(ERR_CD:),
				 *            ERR_DESC = $(ERR_DESC:),
				 *            ERR_CTNT = $(ERR_DTL:)
				 *      WHERE MSG_TP_CD = 'C'
				 *        AND ANR_DECL_NO = $(DCLR_NO:)
				 *        AND REF_SEQ = $(REF_SEQ:)
				 *        AND BL_NO = $(NUMBER:)
				 */
				if ("B".equals(ancsRcvMsgVO.getErrDiv())) {
					List<BkgCstmsAnrBlLogVO> bkgCstmsAnrBlLogVOs2 = new ArrayList<BkgCstmsAnrBlLogVO>();
					BkgCstmsAnrBlLogVO bkgCstmsAnrBlLogVO2 = new BkgCstmsAnrBlLogVO();
					bkgCstmsAnrBlLogVO2.setEdiRcvStsCd("E");
					sRcvStsCd = "E";
					bkgCstmsAnrBlLogVO2.setMsgLocCd(ancsRcvMsgVO.getErrLoc());
					bkgCstmsAnrBlLogVO2.setEdiMsgErrId(ancsRcvMsgVO.getErrCd());
					bkgCstmsAnrBlLogVO2.setErrDesc(ancsRcvMsgVO.getErrDesc());
					bkgCstmsAnrBlLogVO2.setErrCtnt(ancsRcvMsgVO.getErrDtl());
					bkgCstmsAnrBlLogVO2.setUpdUsrId(sUsr_Id);
					bkgCstmsAnrBlLogVO2.setMsgTpCd(sMsgTpCd);
					bkgCstmsAnrBlLogVO2.setAnrDeclNo(ancsRcvMsgVO.getDclrNo());
					bkgCstmsAnrBlLogVO2.setRefSeq(ancsRcvMsgVO.getRefSeq());

					bkgCstmsAnrBlLogVOs2.add(bkgCstmsAnrBlLogVO2);
					dbDao.modifyBkgCstmsAnrBlLog(bkgCstmsAnrBlLogVOs2);
				}

				/*
				 * 7. 수신한 $(RCV_STS:) 및 기존 EDI_RCV_STS_CD에 따라 BKG_CSTMS_ANR_BL_LOG 업데이트
				 *     UPDATE BKG_CSTMS_ANR_BL_LOG
				 *        SET EDI_RCV_STS_CD = CASE WHEN $(RCV_STS:) =  '48' THEN 'E'
				 *                                  WHEN $(RCV_STS:) <> '48'
				 *                                       AND EDI_RCV_STS_CD = 'N' THEN 'A'
				 *                                  ELSE EDI_RCV_STS_CD
				 *                             END
				 *      WHERE MSG_TP_CD = 'C'
				 *        AND ANR_DECL_NO = $(DCLR_NO:)
				 *        AND REF_SEQ = $(REF_SEQ:)
				 */
				List<BkgCstmsAnrBlLogVO> bkgCstmsAnrBlLogVOs3 = new ArrayList<BkgCstmsAnrBlLogVO>();
				BkgCstmsAnrBlLogVO bkgCstmsAnrBlLogVO3 = new BkgCstmsAnrBlLogVO();
				if ("48".equals(ancsRcvMsgVO.getRcvSts())) {
					bkgCstmsAnrBlLogVO3.setEdiRcvStsCd("E");
				} else if (!"48".equals(ancsRcvMsgVO.getRcvSts()) && "N".equals(sRcvStsCd)) {
					bkgCstmsAnrBlLogVO3.setEdiRcvStsCd("A");
				} else {
					bkgCstmsAnrBlLogVO3.setEdiRcvStsCd(sRcvStsCd);
				}
				bkgCstmsAnrBlLogVO3.setMsgLocCd(ancsRcvMsgVO.getErrLoc());
				bkgCstmsAnrBlLogVO3.setEdiMsgErrId(ancsRcvMsgVO.getErrCd());
				bkgCstmsAnrBlLogVO3.setErrDesc(ancsRcvMsgVO.getErrDesc());
				bkgCstmsAnrBlLogVO3.setErrCtnt(ancsRcvMsgVO.getErrDtl());
				bkgCstmsAnrBlLogVO3.setUpdUsrId(sUsr_Id);
				bkgCstmsAnrBlLogVO3.setMsgTpCd(sMsgTpCd);
				bkgCstmsAnrBlLogVO3.setAnrDeclNo(ancsRcvMsgVO.getDclrNo());
				bkgCstmsAnrBlLogVO3.setRefSeq(ancsRcvMsgVO.getRefSeq());
				bkgCstmsAnrBlLogVOs3.add(bkgCstmsAnrBlLogVO3);
				dbDao.modifyBkgCstmsAnrBlLog(bkgCstmsAnrBlLogVOs3);

				/*
				 * 10. 수신한 $(DCLR_NO:)와 $(REF_SEQ:)로 BKG_CSTMS_ANR_CNTR_LOG의 수신 결과 초기화
				 *     UPDATE BKG_CSTMS_ANR_CNTR_LOG
				 *        SET EDI_RCV_STS_CD = 'N',
				 *            MSG_LOC_CD = NULL,
				 *            EDI_MSG_ERR_ID = NULL,
				 *            ERR_DESC = NULL,
				 *            ERR_CTNT = NULL
				 *      WHERE MSG_TP_CD = 'C'
				 *        AND ANR_DECL_NO = $(DCLR_NO:)
				 *        AND REF_SEQ = $(REF_SEQ:)
				 */
				List<BkgCstmsAnrCntrLogVO> bkgCstmsAnrCntrLogVOs = new ArrayList<BkgCstmsAnrCntrLogVO>();
				BkgCstmsAnrCntrLogVO bkgCstmsAnrCntrLogVO = new BkgCstmsAnrCntrLogVO();
				bkgCstmsAnrCntrLogVO.setEdiRcvStsCd("N");
				sRcvStsCd = "N";
				bkgCstmsAnrCntrLogVO.setUpdUsrId(sUsr_Id);
				bkgCstmsAnrCntrLogVO.setMsgTpCd(sMsgTpCd);
				bkgCstmsAnrCntrLogVO.setAnrDeclNo(ancsRcvMsgVO.getDclrNo());
				bkgCstmsAnrCntrLogVO.setRefSeq(ancsRcvMsgVO.getRefSeq());
				bkgCstmsAnrCntrLogVOs.add(bkgCstmsAnrCntrLogVO);
				dbDao.modifyBkgCstmsAnrCntrLog(bkgCstmsAnrCntrLogVOs);
				
				/*
				 * 11. 수신 메시지의 $(ERR_DIV:) = "C"인 ERROR 루프가 존재하면, 존재하는 개수 만큼 LOOP
				 *     UPDATE BKG_CSTMS_ANR_CNTR_LOG
				 *        SET EDI_RCV_STS_CD = 'E',
				 *            MSG_LOC_CD = $(ERR_LOC:),
				 *            EDI_MSG_ERR_ID = $(ERR_CD:),
				 *            ERR_DESC = $(ERR_DESC:),
				 *            ERR_CTNT = $(ERR_DTL:)
				 *      WHERE MSG_TP_CD = 'C'
				 *        AND ANR_DECL_NO = $(DCLR_NO:)
				 *        AND REF_SEQ = $(REF_SEQ:)
				 *        AND CNTR_NO = $(NUMBER:)
				 */
				if ("C".equals(ancsRcvMsgVO.getErrDiv())) {
					List<BkgCstmsAnrCntrLogVO> bkgCstmsAnrCntrLogVOs2 = new ArrayList<BkgCstmsAnrCntrLogVO>();
					BkgCstmsAnrCntrLogVO bkgCstmsAnrCntrLogVO2 = new BkgCstmsAnrCntrLogVO();
					bkgCstmsAnrCntrLogVO2.setEdiRcvStsCd("E");
					sRcvStsCd = "E";
					bkgCstmsAnrCntrLogVO2.setMsgLocCd(ancsRcvMsgVO.getErrLoc());
					bkgCstmsAnrCntrLogVO2.setEdiMsgErrId(ancsRcvMsgVO.getErrCd());
					bkgCstmsAnrCntrLogVO2.setErrDesc(ancsRcvMsgVO.getErrDesc());
					bkgCstmsAnrCntrLogVO2.setErrCtnt(ancsRcvMsgVO.getErrDtl());
					bkgCstmsAnrCntrLogVO2.setUpdUsrId(sUsr_Id);
					bkgCstmsAnrCntrLogVO2.setMsgTpCd(sMsgTpCd);
					bkgCstmsAnrCntrLogVO2.setAnrDeclNo(ancsRcvMsgVO.getDclrNo());
					bkgCstmsAnrCntrLogVO2.setRefSeq(ancsRcvMsgVO.getRefSeq());
					bkgCstmsAnrCntrLogVOs2.add(bkgCstmsAnrCntrLogVO2);
					dbDao.modifyBkgCstmsAnrCntrLog(bkgCstmsAnrCntrLogVOs2);
				}
				/*
				 * 12.  수신한 $(RCV_STS:) 및 기존 EDI_RCV_STS_CD에 따라 BKG_CSTMS_ANR_BL_LOG 업데이트
				 *     UPDATE BKG_CSTMS_ANR_BL_CNTR
				 *        SET EDI_RCV_STS_CD = CASE WHEN $(RCV_STS:) =  '48' THEN 'E'
				 *                                  WHEN $(RCV_STS:) <> '48'
				 *                                       AND EDI_RCV_STS_CD = 'N' THEN 'A'
				 *                                  ELSE EDI_RCV_STS_CD
				 *                             END
				 *      WHERE MSG_TP_CD = 'C'
				 *        AND ANR_DECL_NO = $(DCLR_NO:)
				 *        AND REF_SEQ = $(REF_SEQ:)
				 */
				List<BkgCstmsAnrCntrLogVO> bkgCstmsAnrCntrLogVOs3 = new ArrayList<BkgCstmsAnrCntrLogVO>();
				BkgCstmsAnrCntrLogVO bkgCstmsAnrCntrLogVO3 = new BkgCstmsAnrCntrLogVO();
				if ("48".equals(ancsRcvMsgVO.getRcvSts())) {
					bkgCstmsAnrCntrLogVO3.setEdiRcvStsCd("E");
				} else if (!"48".equals(ancsRcvMsgVO.getRcvSts()) && "N".equals(sRcvStsCd)) {
					bkgCstmsAnrCntrLogVO3.setEdiRcvStsCd("A");
				} else {
					bkgCstmsAnrCntrLogVO3.setEdiRcvStsCd(sRcvStsCd);
				}
				bkgCstmsAnrCntrLogVO3.setMsgLocCd(ancsRcvMsgVO.getErrLoc());
				bkgCstmsAnrCntrLogVO3.setEdiMsgErrId(ancsRcvMsgVO.getErrCd());
				bkgCstmsAnrCntrLogVO3.setErrDesc(ancsRcvMsgVO.getErrDesc());
				bkgCstmsAnrCntrLogVO3.setErrCtnt(ancsRcvMsgVO.getErrDtl());
				bkgCstmsAnrCntrLogVO3.setUpdUsrId(sUsr_Id);
				bkgCstmsAnrCntrLogVO3.setMsgTpCd(sMsgTpCd);
				bkgCstmsAnrCntrLogVO3.setAnrDeclNo(ancsRcvMsgVO.getDclrNo());
				bkgCstmsAnrCntrLogVO3.setRefSeq(ancsRcvMsgVO.getRefSeq());
				bkgCstmsAnrCntrLogVOs3.add(bkgCstmsAnrCntrLogVO3);
				dbDao.modifyBkgCstmsAnrCntrLog(bkgCstmsAnrCntrLogVOs3);
			}

			return ancsRcvMsgVO;

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00628", new String[] {}).getUserMessage());

		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
}