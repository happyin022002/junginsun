/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : IndiaCustomsTransmissionImpl.java
*@FileTitle : IndiaCustomsTransmissionImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.06.11 경종윤
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.basic;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.integration.IndiaCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.vo.IndiaBlListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.vo.IndiaCntrListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.vo.IndiaCntrMtDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.vo.IndiaIgmVslResultVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.vo.IndiaIgmVslVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.vo.IndiaMaxSeqModiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.vo.IndiaTransmitCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.india.vo.IndiaTransmitDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.TransmitDetailVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kyoung Jong Yun
 * @see ESM_BKG_0298EventResponse,IndiaCustomsTransmissionBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class IndiaCustomsTransmissionBCImpl extends BasicCommandSupport implements IndiaCustomsTransmissionBC {

	// Database Access Object
	private transient IndiaCustomsTransmissionDBDAO dbDao = null;


	public IndiaCustomsTransmissionBCImpl() {
		dbDao = new IndiaCustomsTransmissionDBDAO();
	}

	/**
	 * 세관에 적하목록 신고를 EDI를 통해 전송한다. - 프로세스 분기
	 *
	 * @param manifestTransmitVO
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifest(ManifestTransmitVO manifestTransmitVO) throws EventException {

		IndiaTransmitCondVO indiaTransmitCondVO = null;
		String processType = "0";
		String retFlatFile = "";

		if(manifestTransmitVO != null) {
			indiaTransmitCondVO = (IndiaTransmitCondVO)manifestTransmitVO;
			processType = indiaTransmitCondVO.getProcessType();

			try {
				switch(Integer.parseInt(processType)) {
					case 1 : // Contaniner List(EDI)
						retFlatFile = this.transmitContainerListManifest(manifestTransmitVO);
						break;
					case 2 : // India IGM Generation (EDI)
						retFlatFile = this.transmitIGMGenerationManifest(manifestTransmitVO);
						break;
					case 3 : // TP Request (EDI)
						retFlatFile = this.transmitTPRequestManifest(manifestTransmitVO);
						break;
					default :
				} // end switch()

			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler(ex).getMessage(), ex);
			}
		}
		return retFlatFile;
	}

	/**
	 * 세관에 적하목록 신고를 EDI를 통해 전송한다. - Contaniner List(EDI)
	 *
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @return String
	 * @throws EventException
	 */
	private String transmitContainerListManifest(ManifestTransmitVO manifestTransmitVO) throws EventException {
		IndiaTransmitDetailVO indiaTransmitDetailVO = null;
		List<TransmitDetailVO> transmitDetailVOs = null;
		StringBuffer flatFile = new StringBuffer();

		try {
			transmitDetailVOs = (List<TransmitDetailVO>) dbDao.searchContainerList((IndiaTransmitCondVO)manifestTransmitVO);
			if (transmitDetailVOs != null && transmitDetailVOs.size() > 0) {
				for(int i=0; i < transmitDetailVOs.size(); i++ ) {
					indiaTransmitDetailVO = (IndiaTransmitDetailVO) transmitDetailVOs.get(i);
					flatFile.append("\n");
					flatFile.append("CTR").append((char)29);
					flatFile.append(indiaTransmitDetailVO.getIdaStwgNo()).append((char)29);
					flatFile.append(indiaTransmitDetailVO.getCntrNo()).append((char)29);
					flatFile.append(indiaTransmitDetailVO.getCntrWgt()).append((char)29);
					flatFile.append(indiaTransmitDetailVO.getCntrTpszValue()).append((char)29);
					flatFile.append(indiaTransmitDetailVO.getCnmvStsCd()).append((char)29);
					flatFile.append(indiaTransmitDetailVO.getImdgClssCd()).append((char)29).append("  ").append((char)29);
					flatFile.append(indiaTransmitDetailVO.getPolCdLen3()).append((char)29).append("  ").append((char)29);
					flatFile.append(indiaTransmitDetailVO.getIalRgnCd()).append((char)29);
					flatFile.append(indiaTransmitDetailVO.getBlDeclTpCd()).append((char)29);
					flatFile.append(indiaTransmitDetailVO.getIdaTrspCd()).append((char)29);
					flatFile.append(indiaTransmitDetailVO.getLineCd()).append((char)29);
					flatFile.append(indiaTransmitDetailVO.getRcFlg()).append((char)29);
					flatFile.append(indiaTransmitDetailVO.getSpclCgoDesc()).append((char)29);
				} // end for(i)

			} else { // 컨테이너 정보가 없을경우
				// [COM12199] - ($s) doesn\'t exist.
				throw new EventException(new ErrorHandler("COM12199", new String[]{"Container data"}).getMessage());
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}


		return flatFile.toString();
	}

	/**
	 * 세관에 적하목록 신고를 EDI를 통해 전송한다. - India IGM Generation (EDI)
	 *
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @return String
	 * @throws EventException
	 */
	private String transmitIGMGenerationManifest(ManifestTransmitVO manifestTransmitVO) throws EventException {

		IndiaIgmVslResultVO indiaIgmVslResultVO = null; //VVD의 상세 정보
		IndiaBlListDetailVO indiaBlListDetailVO = null; //B/L정보 (cargo)
		IndiaCntrMtDetailVO indiaCntrMtDetailVO = null; //컨테이너 정보

		List<IndiaBlListDetailVO> indiaBlListDetailVOList = null;
		List<IndiaCntrMtDetailVO> indiaCntrMtDetailVOList = null;

		IndiaTransmitCondVO indiaTransmitCondVO = null;

		StringBuffer flatFile = new StringBuffer();
		int indiaBlListDetailVOListSize = 0;
		int indiaCntrMtDetailVOListSize = 0;

		String msgType = "1";

		boolean intoFlag = true;

		try {
			indiaTransmitCondVO = (IndiaTransmitCondVO)manifestTransmitVO;

			msgType = indiaTransmitCondVO.getMsgType();

			/* VVD 정보 */
			indiaIgmVslResultVO = dbDao.searchIgmVslByVvdPod(indiaTransmitCondVO);


			if(indiaIgmVslResultVO != null) {

				if (intoFlag && !"".equals(indiaIgmVslResultVO.getSkdVoyNo())) {

					flatFile.append("<manifest>2.0").append("\n");

					flatFile.append("<vesinfo>").append("\n");

					flatFile.append("V").append((char)29);
					flatFile.append(indiaIgmVslResultVO.getIdaDeclVslNo()).append((char)29);
					flatFile.append(indiaIgmVslResultVO.getVslDeclDt()).append((char)29);
					flatFile.append(indiaIgmVslResultVO.getVslNm()).append((char)29);
					flatFile.append(indiaIgmVslResultVO.getCallSgnNo()).append((char)29);
					flatFile.append(indiaIgmVslResultVO.getSkdVoyNo()).append((char)29);
					flatFile.append(indiaIgmVslResultVO.getIdaLineNo()).append((char)29);
					flatFile.append(indiaIgmVslResultVO.getIdaAgnId()).append((char)29);
					flatFile.append("").append((char)29);
					flatFile.append("").append((char)29);
					flatFile.append(indiaIgmVslResultVO.getPortCd()).append((char)29);
					flatFile.append("").append((char)29);
					flatFile.append("").append((char)29);
					flatFile.append("").append((char)29);
					flatFile.append("").append((char)29);
					flatFile.append("").append((char)29);
					flatFile.append("").append((char)29);
					flatFile.append("").append((char)29);
					flatFile.append("").append((char)29);
					flatFile.append(indiaIgmVslResultVO.getArrDt()).append((char)29);
					flatFile.append("").append((char)29);
					flatFile.append("").append((char)29);
					flatFile.append("").append((char)29);
					flatFile.append("").append((char)29);
					flatFile.append("").append((char)29);
					flatFile.append("").append((char)29);
					flatFile.append("").append((char)29);
					flatFile.append("").append((char)29).append("\n");

					flatFile.append("<END-vesinfo>").append("\n");

					/* B/L정보 (cargo) */
					indiaBlListDetailVOList = dbDao.searchBlListByVvdPolPod(indiaTransmitCondVO);

					if(intoFlag && indiaBlListDetailVOList != null ) {
						indiaBlListDetailVOListSize = indiaBlListDetailVOList.size();

						flatFile.append("<cargo>").append("\n");

						for(int i=0; i < indiaBlListDetailVOListSize; i++) {

							indiaBlListDetailVO = indiaBlListDetailVOList.get(i);

							flatFile.append("V").append((char)29);
							flatFile.append(indiaBlListDetailVO.getCallSgnNo()).append((char)29);
							flatFile.append(indiaBlListDetailVO.getSkdVoyNo()).append((char)29);
							flatFile.append(indiaBlListDetailVO.getIdaDeclVslNo()).append((char)29);
							flatFile.append(indiaBlListDetailVO.getVslDeclDt()).append((char)29);
							flatFile.append(indiaBlListDetailVO.getIdaLineNo()).append((char)29);

							flatFile.append(indiaBlListDetailVO.getTmp0()).append((char)29); // tmp0 -> '0'
							flatFile.append(indiaBlListDetailVO.getNewBlNo()).append((char)29);
							flatFile.append(indiaBlListDetailVO.getBlObrdDt()).append((char)29);
							flatFile.append(indiaBlListDetailVO.getPolCd()).append((char)29);
							flatFile.append(indiaBlListDetailVO.getIdaDestCd()).append((char)29);
							flatFile.append(indiaBlListDetailVO.getTmp1()).append((char)29); // tmp1 -> ''
							flatFile.append(indiaBlListDetailVO.getTmp2()).append((char)29); // tmp2 -> ''

							flatFile.append(indiaBlListDetailVO.getCCustNm()).append((char)29);
							flatFile.append(indiaBlListDetailVO.getCCustAddr()).append((char)29);
							flatFile.append(indiaBlListDetailVO.getNCustNm()).append((char)29);
							flatFile.append(indiaBlListDetailVO.getNCustAddr()).append((char)29);

							flatFile.append(indiaBlListDetailVO.getBkgCgoTpCd()).append((char)29);
							flatFile.append(indiaBlListDetailVO.getIdaCstmsItmTpCd()).append((char)29);
							flatFile.append(indiaBlListDetailVO.getBlDeclTpCd()).append((char)29);
							flatFile.append(indiaBlListDetailVO.getPodCdGubun()).append((char)29);
							flatFile.append(indiaBlListDetailVO.getPckQty()).append((char)29);
							flatFile.append(indiaBlListDetailVO.getPckTpCd()).append((char)29);

							flatFile.append(indiaBlListDetailVO.getWgt()).append((char)29);
							flatFile.append(indiaBlListDetailVO.getWgtUtCd()).append((char)29);
							flatFile.append(indiaBlListDetailVO.getTmp3()).append((char)29); // tmp3 -> ''
							flatFile.append(indiaBlListDetailVO.getTmp4()).append((char)29); // tmp4 -> ''

							flatFile.append(indiaBlListDetailVO.getMkDesc()).append((char)29);
							flatFile.append(indiaBlListDetailVO.getCmdtDesc()).append((char)29);

							flatFile.append(indiaBlListDetailVO.getImdgUnNo()).append((char)29);
							flatFile.append(indiaBlListDetailVO.getImdgClssCd()).append((char)29);

							flatFile.append(indiaBlListDetailVO.getIbdNo()).append((char)29);
							flatFile.append(indiaBlListDetailVO.getCrrAgnCd()).append((char)29);
							flatFile.append(indiaBlListDetailVO.getIdaTrspCd()).append((char)29);
							flatFile.append(indiaBlListDetailVO.getIdaMrnLineOprCd()).append((char)29);

							if(msgType.equals("2")) {
								flatFile.append(indiaBlListDetailVO.getBdAreaCd()).append((char)29);
							}

							flatFile.append("\n");

						} // end for(i)

						flatFile.append("<END-cargo>").append("\n");


						/* 컨테이너 정보 */
						indiaCntrMtDetailVOList = dbDao.searchCntrListByVvdPodMt(indiaTransmitCondVO);
						if(intoFlag && indiaCntrMtDetailVOList != null) {
							indiaCntrMtDetailVOListSize = indiaCntrMtDetailVOList.size();

							flatFile.append("<contain>").append("\n");

							for(int i = 0; i < indiaCntrMtDetailVOListSize; i++)  {
								indiaCntrMtDetailVO = indiaCntrMtDetailVOList.get(i);

								flatFile.append("V").append((char)29);

								flatFile.append(indiaCntrMtDetailVO.getCallSgnNo()).append((char)29);
								flatFile.append(indiaCntrMtDetailVO.getSkdVoyNo()).append((char)29);
								flatFile.append(indiaCntrMtDetailVO.getIdaDeclVslNo()).append((char)29);
								flatFile.append(indiaCntrMtDetailVO.getVslDeclDt()).append((char)29);
								flatFile.append(indiaCntrMtDetailVO.getIdaLineNo()).append((char)29);

								flatFile.append(indiaCntrMtDetailVO.getTmp0()).append((char)29); // tmp0 -> '0'

								flatFile.append(indiaCntrMtDetailVO.getCntrNo()).append((char)29);
								flatFile.append(indiaCntrMtDetailVO.getCntrSealNo()).append((char)29);
								flatFile.append(indiaCntrMtDetailVO.getIdaAgnId()).append((char)29);
								flatFile.append(indiaCntrMtDetailVO.getCnmvStsCd()).append((char)29);

								flatFile.append(indiaCntrMtDetailVO.getPckQty()).append((char)29);
								flatFile.append(indiaCntrMtDetailVO.getCntrWgt()).append((char)29);
								flatFile.append(indiaCntrMtDetailVO.getCntrTpszCd()).append((char)29);
								flatFile.append(indiaCntrMtDetailVO.getSocFlg()).append((char)29);

								flatFile.append("\n");
							}

							flatFile.append("<END-contain>").append("\n");

							flatFile.append("<END-manifest>").append("\n");

						} else { // 컨테이너 정보가 없을경우
							// [COM12199] - ($s) doesn\'t exist.
							throw new EventException(new ErrorHandler("COM12199", new String[]{"Container data"}).getMessage());
						}

					} else { // B/L 정보가 없을때
						// [COM12199] - ($s) doesn\'t exist.
						throw new EventException(new ErrorHandler("COM12199", new String[]{"B/L data"}).getMessage());
					}
				} else { // 배 정보가 없을경우
					// [COM12199] - ($s) doesn\'t exist.
					throw new EventException(new ErrorHandler("COM12199", new String[]{"VVD data"}).getMessage());
				}

			} else { // 배 정보가 없을경우
				// [COM12199] - ($s) doesn\'t exist.
				throw new EventException(new ErrorHandler("COM12199", new String[]{"VVD data"}).getMessage());
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

		return flatFile.toString();
	}

	/**
	 * 세관에 적하목록 신고를 EDI를 통해 전송한다. - TP Request (EDI)
	 *
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @return String
	 * @throws EventException
	 */
	private String transmitTPRequestManifest(ManifestTransmitVO manifestTransmitVO) throws EventException {

		IndiaIgmVslVO indiaIgmVslVO = null;
		String getSeq = "00";

		IndiaCntrListDetailVO indiaCntrListDetailVO = null;
		//List<IndiaCntrListDetailVO> indiaCntrListDetailVOList = null;
		List<TransmitDetailVO> transmitDetailVOs = null;


		StringBuffer flatFile = null;
		int listSize = 0;

		IndiaTransmitCondVO indiaTransmitCondVO = (IndiaTransmitCondVO)manifestTransmitVO;

		IndiaMaxSeqModiVO indiaMaxSeqModiVO = new IndiaMaxSeqModiVO();

		try {

			flatFile = new StringBuffer();

			indiaIgmVslVO = dbDao.searchIgmVsl(indiaTransmitCondVO);

			if(indiaIgmVslVO != null) {

				indiaTransmitCondVO.setIdaAgnId(indiaIgmVslVO.getIdaAgnId());
				indiaTransmitCondVO.setGenDt(indiaIgmVslVO.getGenDt());

				// Max Seq.를 조회해 온다.
				getSeq = dbDao.searchIgmMaxSeq(indiaTransmitCondVO);

				StringBuffer savedFileName = new StringBuffer();


				if(indiaIgmVslVO != null) {

					savedFileName.append("S").append(indiaIgmVslVO.getIdaAgnId()).append(indiaIgmVslVO.getGenDt()).append(getSeq).append(".tpreq");

					flatFile.append(savedFileName.toString()).append("||");

					flatFile.append("HREC**,ZZ,").append(indiaTransmitCondVO.getSender()).append(",ZZ,")
						.append(indiaIgmVslVO.getOtrDchgCd()).append(",5,UN,D,SACHI16,,,01A\nTPREQID/")
						.append(savedFileName.toString());

					flatFile.append("\n");

					// container list대상 조회하는 오퍼레이션
					transmitDetailVOs = (List<TransmitDetailVO>) dbDao.searchContainerList(indiaTransmitCondVO);

					if (transmitDetailVOs != null) {

						listSize = transmitDetailVOs.size();

						flatFile.append("<manifest>").append("\n");
						flatFile.append("<req_trans>").append("\n");

						for(int i=0; i < listSize; i++ ) {
							indiaCntrListDetailVO = (IndiaCntrListDetailVO) transmitDetailVOs.get(i);

							flatFile.append("F").append((char)29).append("S").append((char)29);

							flatFile.append(indiaCntrListDetailVO.getIdaAgnId()).append((char)29);
							flatFile.append(indiaCntrListDetailVO.getIdaDeclVslNo()).append((char)29);
							flatFile.append(indiaCntrListDetailVO.getVslDeclDt()).append((char)29);
							flatFile.append(indiaCntrListDetailVO.getIdaLineNo()).append((char)29);
							flatFile.append(indiaCntrListDetailVO.getTmp0()).append((char)29);

							flatFile.append(indiaCntrListDetailVO.getOtrDchgCd()).append((char)29);
							flatFile.append(indiaCntrListDetailVO.getIdaTrspCd()).append((char)29);
							flatFile.append(indiaCntrListDetailVO.getPckQty()).append((char)29);
							flatFile.append(indiaCntrListDetailVO.getCntrWgt()).append((char)29);
							flatFile.append(indiaCntrListDetailVO.getWgtUtCd()).append((char)29);

							flatFile.append(indiaCntrListDetailVO.getTmp1()).append((char)29);
							flatFile.append(indiaCntrListDetailVO.getTmp2()).append((char)29);
							flatFile.append(indiaCntrListDetailVO.getTmp3()).append((char)29);
							flatFile.append(indiaCntrListDetailVO.getTmp4()).append((char)29);
							flatFile.append(indiaCntrListDetailVO.getTmp5()).append((char)29);

							flatFile.append(indiaCntrListDetailVO.getIbdNo()).append((char)29);
							flatFile.append(indiaCntrListDetailVO.getTpFee()).append((char)29);
							flatFile.append(indiaCntrListDetailVO.getCrrAgnCd()).append((char)29);

							flatFile.append("\n");

						} // end for(i)

						flatFile.append("<END-req_trans>").append('\n');;
						flatFile.append("<END-manifest>");

						// Agent Code별 전송번호 등록 또는 없데이트
						indiaMaxSeqModiVO.setIdaShprCd("S");
						indiaMaxSeqModiVO.setLoclAgnCd(indiaIgmVslVO.getIdaAgnId());
						indiaMaxSeqModiVO.setGenDt(indiaIgmVslVO.getGenDt());
						indiaMaxSeqModiVO.setGenSeq(getSeq);
						indiaMaxSeqModiVO.setCreUsrId(indiaTransmitCondVO.getCreUsrId());
						indiaMaxSeqModiVO.setUpdUsrId(indiaTransmitCondVO.getUpdUsrId());

						int retVal = dbDao.modifyIgmMaxSeq(indiaMaxSeqModiVO);

						if(retVal == 0) {
							dbDao.addIgmMaxSeq(indiaMaxSeqModiVO);
						}

					} else { // 컨테이너 정보가 없을경우
						// [COM12199] - ($s) doesn\'t exist.
						throw new EventException(new ErrorHandler("COM12199", new String[]{"Container data"}).getMessage());
					}
				}

			} else { // 배 정보가 없을경우
				// [COM12199] - ($s) doesn\'t exist.
				throw new EventException(new ErrorHandler("COM12199", new String[]{"VVD data"}).getMessage());
			}

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

		return flatFile.toString();
	}

}
