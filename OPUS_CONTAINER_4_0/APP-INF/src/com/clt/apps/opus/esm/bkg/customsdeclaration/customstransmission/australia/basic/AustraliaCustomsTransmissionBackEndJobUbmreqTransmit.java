/*=========================================================
*Copyright(c) CyberLogitec
*@FileName : AustraliaCustomsTransmissionBackEndJobUbmreqTransmit
*@FileTitle : AustraliaCustomsTransmissionBackEndJobUbmreqTransmit
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion :
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.integration.AusCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusCuscarCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.australia.vo.AusSearchVslPortSkdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusResultCuscarVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.australia.vo.AusSearchCuscarVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCstmsAusSndLogVO;
import com.clt.syscommon.common.table.MdmLocationVO;
import com.clt.syscommon.common.table.MdmVslCntrVO;


/**
 * @author KIM Sang-Soo
 * @see ESM_BKG_1501 EventResponse, AustraliaCustomsTransmissionBackEndJobUbmreqTransmit 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class AustraliaCustomsTransmissionBackEndJobUbmreqTransmit extends BackEndCommandSupport {
	private AusSearchCuscarVO inputSearchCuscarVO;
	private AusResultCuscarVO[] inputResultCuscarVOs;
	private SignOnUserAccount account;
	// Database Access Object
	private AusCustomsTransmissionDBDAO dbDao = new AusCustomsTransmissionDBDAO();

	/**
	 * 데이터 세팅
	 *
	 * @param AusSearchCuscarVO ausSearchCuscarVO
	 */
	public void setAusSearchCuscarVO(AusSearchCuscarVO ausSearchCuscarVO) {
		this.inputSearchCuscarVO = ausSearchCuscarVO;
	}

	/**
	 * 데이터 세팅
	 *
	 * @param AusResultCuscarVO[] ausResultCuscarVOs
	 */
	public void setAusResultCuscarVOs(AusResultCuscarVO[] ausResultCuscarVOs) {
		if (ausResultCuscarVOs != null) {
			AusResultCuscarVO[] tmpVOs = Arrays.copyOf(ausResultCuscarVOs, ausResultCuscarVOs.length);
			this.inputResultCuscarVOs = tmpVOs;
		}
	}

	/**
	 * 데이터 세팅
	 *
	 * @param SignOnUserAccount signOnUserAccount
	 */
	public void setAccount(SignOnUserAccount signOnUserAccount) {
		this.account = signOnUserAccount;
	}

	/**
	 * Back End Job Result
	 * @return String
	 * @throws Exception
	 */
	public String doStart() throws Exception {
		BookingUtil bookingUtil = new BookingUtil();

		// FLATFILE
		String flatFileHeader = null;
		String flatFileRefNo = null;
		StringBuilder flatFile = new StringBuilder();

		// -- Input 정보 -- //////////////////////////////////////////////
		AusSearchCuscarVO ausSearchCuscarVO = this.inputSearchCuscarVO; // 조회조건
		AusResultCuscarVO[] ausResultCuscarVOs = this.inputResultCuscarVOs; // Sheet내용
		SignOnUserAccount signOnUserAccount = this.account;

		// -- Output 정보 -- //////////////////////////////////////////////
		String vvd = ausSearchCuscarVO.getVvd();
		String vvdPodCd = ausSearchCuscarVO.getPodCd();
		String blNo = "";
		String bkgNo = "";
		String cntrNo = "";
		List<AusSearchVslPortSkdVO> ausSearchVslPortSkdVOList = new ArrayList<AusSearchVslPortSkdVO>();
		String cssmVoyNo = "";
		String vpsEtaDt = "";
		List<MdmVslCntrVO> mdmVslCntrVOList = new ArrayList<MdmVslCntrVO>();
		String vslNm = "";
		String lloydNo = "";
		List<MdmLocationVO> mdmLocationVOList = new ArrayList<MdmLocationVO>();
		String locNm = "";
		//Container 정보
		List<AusCuscarCntrInfoVO> ausCuscarCntrInfoVOList = new ArrayList<AusCuscarCntrInfoVO>();


		try {
			// Header 생성
			flatFileHeader = bookingUtil.searchCstmsEdiHeaderNew("AU_UBMREQ");
			flatFile.append(flatFileHeader).append("\n");
			flatFileRefNo = flatFileHeader.substring(62).trim();


			// Body 생성
			flatFile.append("MSG_TYPE:").append("31").append("\n");
			flatFile.append("SRN:").append(flatFileRefNo).append("\n");
			flatFile.append("SRN_VER:").append("1").append("\n");
			flatFile.append("STATUS:").append(ausSearchCuscarVO.getEdiInd()).append("\n");
			flatFile.append("VSL_CODE:").append(vvd.substring(0, 4)).append("\n");
			flatFile.append("VOYAGE:").append(vvd.substring(4)).append("\n");


			ausSearchVslPortSkdVOList = dbDao.searchVskVslPortSkd(vvd, vvdPodCd);
			cssmVoyNo = "";
			vpsEtaDt = "";
			if (ausSearchVslPortSkdVOList.size() > 0) {
				cssmVoyNo = ausSearchVslPortSkdVOList.get(0).getIbCssmVoyNo();
				vpsEtaDt = ausSearchVslPortSkdVOList.get(0).getVpsEtaDt();
			}
			flatFile.append("CON_VOYAGE:").append(cssmVoyNo).append("\n");


			mdmVslCntrVOList = dbDao.searchMdmVslCntrByVslCd(vvd.substring(0, 4));
			vslNm = "";
			lloydNo = "";
			if (mdmVslCntrVOList.size() > 0) {
				vslNm = mdmVslCntrVOList.get(0).getVslEngNm();
				lloydNo = mdmVslCntrVOList.get(0).getLloydNo();
			}
			flatFile.append("VSL_NAME:").append(vslNm).append("\n");
			flatFile.append("VSL_LLOYD_NO:").append(lloydNo).append("\n");


			flatFile.append("PORT:").append(vvdPodCd).append("\n");


			mdmLocationVOList = dbDao.searchMdmLocationByPortCd(vvdPodCd);
			locNm = "";
			if (mdmLocationVOList.size() > 0) locNm = mdmLocationVOList.get(0).getLocNm();
			flatFile.append("PORT_NM:").append(locNm).append("\n");


			flatFile.append("EX_IND:").append("I").append("\n");
			flatFile.append("CARGO_PARTY_CD:").append("85009721751").append("\n");


			flatFile.append("ETA:").append(vpsEtaDt).append("\n");


			flatFile.append("REQ_REASON:").append(ausSearchCuscarVO.getReqReason()).append("\n");
			flatFile.append("IT_MODE:").append(ausSearchCuscarVO.getItMode()).append("\n");
			flatFile.append("IT_VOYAGE:").append(ausSearchCuscarVO.getOnCrrg()).append("\n");
			flatFile.append("IT_LLOYD_NO:").append(ausSearchCuscarVO.getLloydNo()).append("\n");


			flatFile.append("ORG_PREMISES:").append(ausSearchCuscarVO.getOrgPrms()).append("\n");
			flatFile.append("DES_PREMISES:").append(ausSearchCuscarVO.getDstPrms()).append("\n");


			for (AusResultCuscarVO ausResultCuscarVO : ausResultCuscarVOs) {
				blNo = ausResultCuscarVO.getBlNo();
				bkgNo = ausResultCuscarVO.getBkgNo();
				cntrNo = ausResultCuscarVO.getCntrNo();


				// {CNTR_INFO (S)
				ausCuscarCntrInfoVOList = dbDao.searchCntrInfo(bkgNo, cntrNo);
				for (AusCuscarCntrInfoVO ausCuscarCntrInfoVO : ausCuscarCntrInfoVOList) {
					cntrNo = ausCuscarCntrInfoVO.getCntrNo();
					flatFile.append("{CNTR_INFO").append("\n");
					flatFile.append("CNTRNBR:").append(cntrNo).append("\n");
					flatFile.append("CNTR_FM_IND:").append(ausCuscarCntrInfoVO.getCntrFmInd()).append("\n");
					flatFile.append("CNTR_PKG_QTY:").append(ausCuscarCntrInfoVO.getPckQty()).append("\n");
					flatFile.append("CNTR_PKG_UNIT:").append(ausCuscarCntrInfoVO.getPckTpCd()).append("\n");


					flatFile.append("}CNTR_INFO").append("\n");
				}
				// }CNTR_INFO (E)


				// 전송결과 저장
				BkgCstmsAusSndLogVO bkgCstmsAusSndLogVO = new BkgCstmsAusSndLogVO();
				bkgCstmsAusSndLogVO.setAusSndLogId("UBMREQ");
				bkgCstmsAusSndLogVO.setSndDt(bookingUtil.searchLocalTime(signOnUserAccount.getCnt_cd() + signOnUserAccount.getOfc_cd().substring(0, 3)));
				bkgCstmsAusSndLogVO.setLogSeq(ausSearchCuscarVO.getEdiInd());
				bkgCstmsAusSndLogVO.setOfcCd(signOnUserAccount.getOfc_cd());
				bkgCstmsAusSndLogVO.setVslCd(vvd.substring(0, 4));
				bkgCstmsAusSndLogVO.setSkdVoyNo(vvd.substring(4, 8));
				bkgCstmsAusSndLogVO.setSkdDirCd(vvd.substring(8, 9));
				bkgCstmsAusSndLogVO.setPodCd(vvdPodCd);
				bkgCstmsAusSndLogVO.setBlNo(blNo);
				bkgCstmsAusSndLogVO.setEdiSndMsgCtnt(flatFile.toString());
				bkgCstmsAusSndLogVO.setEdiRefId(flatFileRefNo);
				bkgCstmsAusSndLogVO.setCntrNo(cntrNo);
				bkgCstmsAusSndLogVO.setCreUsrId(signOnUserAccount.getUsr_id());
				bkgCstmsAusSndLogVO.setUpdUsrId(signOnUserAccount.getUsr_id());
				dbDao.addCstmsAusSndLog(bkgCstmsAusSndLogVO);
			}


			// FlatFile 전송
			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(flatFile.toString());
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_AUSMF.IBMMQ.QUEUE"));
			FlatFileAckVO flatFileAckVO = bookingUtil.sendFlatFile(sendFlatFileVO);
			if ("E".equals(flatFileAckVO.getAckStsCd())) throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {} ).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {} ).getMessage(), ex);
		}
		return flatFile.toString();
	}

}
