/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : PanamaCustomsTransmissionBCImpl.java
 *@FileTitle : CustomsTransmissionBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.21
 *@LastModifier : 김승민
 *@LastVersion : 1.0
 * 2009.04.21 김승민
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.vo.CstmsCdConvVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.integration.PanamaCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo.BkgCstmsPnmRcvErrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo.BkgCstmsPnmRcvLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo.BkgCstmsPnmSndLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaCstmsRcvLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestListEmptyCargoDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestListGeneralCargoDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestListHamoTrpCdVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestListHazardousCargoDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestListMctForBasicInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.vo.PanamaManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.bizcommon.edi.broker.ReferenceNumberGeneratorBroker;
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
 * ALPS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - ALPS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kim Seung Min
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class PanamaCustomsTransmissionBCImpl extends BasicCommandSupport implements PanamaCustomsTransmissionBC {

	// Database Access Object
	private transient PanamaCustomsTransmissionDBDAO dbDao = null;

	/**
	 * CustomsTransmissionBCImpl 객체 생성<br>
	 * CustomsTransmissionDBDAO를 생성한다.<br>
	 */
	public PanamaCustomsTransmissionBCImpl() {
		dbDao = new PanamaCustomsTransmissionDBDAO();
	}


	/**
	 * Panama를 통과하는 화물에 대한 Manifest를 ACP(Authority of Canal of Panama)에 신고하기 위해 FlatFile을 생성한다.<br>
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifest(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account) throws EventException {
		StringBuffer flatFile = new StringBuffer();
		String callSeq = "";
		PanamaManifestTransmitVO transmitVO = (PanamaManifestTransmitVO) manifestTransmitVO;
		List<PanamaManifestListMctForBasicInfoVO> basicInfoVOs = null;
		List<PanamaManifestListGeneralCargoDetailVO> gCargoDetailVOs = null;
		List<PanamaManifestListEmptyCargoDetailVO> eCargoDetailVOs = null;
		List<PanamaManifestListHazardousCargoDetailVO> hCargoDetailVOs = null;
		BookingUtil command = new BookingUtil();

		try {
			if (!transmitVO.getVstNo().equals("") && !transmitVO.getMvmtSeq().equals("") && !transmitVO.getPnmVslOprCd().equals(""))
			{
				callSeq = dbDao.searchCallSeq(transmitVO);
				transmitVO.setClptSeq(callSeq);

				if (!callSeq.equals("") && callSeq != null)
				{
					// ACP(Authority of Canal of Panama)로 전송할 Manifest General Cargo 정보를 조회한다.
					gCargoDetailVOs = dbDao.searchGeneralCargoDetail(transmitVO);
					// ACP(Authority of Canal of Panama)로 전송할 Manifest Empty Cargo 정보를 조회한다.
					eCargoDetailVOs = dbDao.searchEmptyCargoDetail(transmitVO);
					// ACP(Authority of Canal of Panama)로 전송할 Manifest Hazardous Cargo 정보를 조회한다.
					hCargoDetailVOs = dbDao.searchHazardousCargoDetail(transmitVO);

					if (hCargoDetailVOs.size() > 0)
					{
						transmitVO.setDgpackage("Y");
					}
					else
					{
						transmitVO.setDgpackage("N");
					}

					// ACP(Authority of Canal of Panama)로 전송할 Manifest Basic Info를 조회한다.
					basicInfoVOs = dbDao.searchMctForBasicInfo(transmitVO);
					if (basicInfoVOs.size() < 1)
						return null;
					
					PanamaManifestListMctForBasicInfoVO basicInfoVO = basicInfoVOs.get(0);

					String sHeader = command.searchCstmsEdiHeaderNew("PA_CGODEC");
					flatFile.append(sHeader).append("\n");

					// ACP(Authority of Canal of Panama)로 전송할 Manifest Basic Info를 세팅한다.
//					if (basicInfoVO != null)
//					{
						flatFile.append("VISITNO:").append(basicInfoVO.getVstNo()).append("\n");
						// 아래 MOVESEQ: 값과 동일하여서 MSN: 은 삭제
//						flatFile.append("MSN:").append(basicInfoVO.getMvmtSeq()).append("\n");
						flatFile.append("VVD:").append(basicInfoVO.getVvdCd()).append("\n");
						flatFile.append("CON_VVD:").append("").append("\n");
						flatFile.append("ORIGROUTE:").append(basicInfoVO.getPnmOrgCd()).append("\n");
						flatFile.append("DESTROUTE:").append(basicInfoVO.getPnmDestCd()).append("\n");

						List<PanamaManifestListHamoTrpCdVO> hsCdVOs = dbDao.searchHamoTrpCd(transmitVO);
						if (hsCdVOs.size() == 0)
						{
							flatFile.append("MCARGO:").append("470620").append("\n");
						}
						else
						{
							String hamoTrpCd = "";
							String attrCtnt = "";
							for (int i = 0; i < hsCdVOs.size(); i++)
							{
								hamoTrpCd = hsCdVOs.get(i).getHamoTrfCd();

								attrCtnt = dbDao.searchAttrCtnt(hamoTrpCd);
								if (attrCtnt != null && !attrCtnt.equals(""))
								{
									flatFile.append("MCARGO:").append(attrCtnt).append("\n");
									break;
								}
							}
							if (attrCtnt == null || attrCtnt.equals(""))
							{
								flatFile.append("MCARGO:").append("470620").append("\n");
							}
						}
						flatFile.append("CUSTCODE:").append(basicInfoVO.getPnmVslOprCd()).append("\n");
						flatFile.append("CARGO:").append(basicInfoVO.getCargo()).append("\n");
						flatFile.append("MTTANKS:").append(basicInfoVO.getMttanks()).append("\n");
						flatFile.append("DGBULK:").append(basicInfoVO.getDgbulk()).append("\n");
						flatFile.append("DGPACKAGE:").append(basicInfoVO.getDgpackage()).append("\n");
						flatFile.append("MOVESEQ:").append(basicInfoVO.getMvmtSeq()).append("\n");
						flatFile.append("SERVICE_CD:").append(basicInfoVO.getVslSlanCd()).append("\n");
						flatFile.append("SERVICE_NAME:").append(basicInfoVO.getVslSlanNm()).append("\n");
//					}
					// ACP(Authority of Canal of Panama)로 전송할 Manifest General Cargo 정보를 세팅한다.
					for (int i = 0; i < gCargoDetailVOs.size(); i++)
					{
						PanamaManifestListGeneralCargoDetailVO gCargoDetailVO = gCargoDetailVOs.get(i);
						// 전체
						if (transmitVO.getErrorType().equals("All"))
						{
							flatFile.append("{CNTR").append("\n");
							flatFile.append("CNTR_DESC:").append(gCargoDetailVO.getValue1()).append("\n");
							flatFile.append("CNTR_CNTRNO:").append(gCargoDetailVO.getCntrNo()).append("\n");
							flatFile.append("CNTR_POL:").append(gCargoDetailVO.getPolCd()).append("\n");
							flatFile.append("CNTR_POD:").append(gCargoDetailVO.getPodCd()).append("\n");
							flatFile.append("CNTR_QTY:").append(gCargoDetailVO.getValue2()).append("\n");
							flatFile.append("CNTR_TS:").append(gCargoDetailVO.getCntrTpszCd()).append("\n");
							flatFile.append("}CNTR").append("\n");
						}
						else
						{
							if ((gCargoDetailVO.getValue1() != null
									&& !gCargoDetailVO.getValue1().equals("")
									&& !gCargoDetailVO.getValue2().equals("0.000")))
							{
								flatFile.append("{CNTR").append("\n");
								flatFile.append("CNTR_DESC:").append(gCargoDetailVO.getValue1()).append("\n");
								flatFile.append("CNTR_CNTRNO:").append(gCargoDetailVO.getCntrNo()).append("\n");
								flatFile.append("CNTR_POL:").append(gCargoDetailVO.getPolCd()).append("\n");
								flatFile.append("CNTR_POD:").append(gCargoDetailVO.getPodCd()).append("\n");
								flatFile.append("CNTR_QTY:").append(gCargoDetailVO.getValue2()).append("\n");
								flatFile.append("CNTR_TS:").append(gCargoDetailVO.getCntrTpszCd()).append("\n");
								flatFile.append("}CNTR").append("\n");
							}
						}
					}
					// ACP(Authority of Canal of Panama)로 전송할 Manifest Empty Cargo 정보를 세팅한다.
					for (int i = 0; i < eCargoDetailVOs.size(); i++)
					{
						PanamaManifestListEmptyCargoDetailVO eCargoDetailVO = eCargoDetailVOs.get(i);
						// 전체
						if (transmitVO.getErrorType().equals("All"))
						{
							flatFile.append("{MT").append("\n");
							flatFile.append("MT_TOTAL:").append(eCargoDetailVO.getXMtTotal()).append("\n");
							flatFile.append("MT_LOC:").append(eCargoDetailVO.getXMtLoc()).append("\n");
							flatFile.append("MT_TS:").append(eCargoDetailVO.getXMtTs()).append("\n");
							flatFile.append("}MT").append("\n");
						}
						else
						{
							if (!eCargoDetailVO.getXMtLoc().equals("C"))
							{
								flatFile.append("{MT").append("\n");
								flatFile.append("MT_TOTAL:").append(eCargoDetailVO.getXMtTotal()).append("\n");
								flatFile.append("MT_LOC:").append(eCargoDetailVO.getXMtLoc()).append("\n");
								flatFile.append("MT_TS:").append(eCargoDetailVO.getXMtTs()).append("\n");
								flatFile.append("}MT").append("\n");
							}
						}
					}
					// ACP(Authority of Canal of Panama)로 전송할 Manifest Hazardous Cargo 정보를 세팅한다.
					for (int i = 0; i < hCargoDetailVOs.size(); i++)
					{
						PanamaManifestListHazardousCargoDetailVO hCargoDetailVO = hCargoDetailVOs.get(i);
						// 전체
						if (transmitVO.getErrorType().equals("All"))
						{
							flatFile.append("{DG").append("\n");
							flatFile.append("DG_UN:").append(hCargoDetailVO.getImdgUnNo()).append("\n");
							flatFile.append("DG_IMO:").append(hCargoDetailVO.getImdgClssCd()).append("\n");
							flatFile.append("DG_CMPGRP:").append(hCargoDetailVO.getImdgCoGrpCd()).append("\n");
							flatFile.append("DG_CNTRNO:").append(hCargoDetailVO.getCntrNo()).append("\n");
							flatFile.append("DG_FLASH:").append(hCargoDetailVO.getValue1()).append("\n");
							flatFile.append("DG_QTY:").append(hCargoDetailVO.getValue2()).append("\n");
							flatFile.append("DG_KEPTIN:").append(hCargoDetailVO.getDgKeptin()).append("\n");
							flatFile.append("DG_TS:").append(hCargoDetailVO.getCntrTpszCd()).append("\n");
							flatFile.append("DG_POL:").append(hCargoDetailVO.getPolCd()).append("\n");
							flatFile.append("DG_POD:").append(hCargoDetailVO.getPodCd()).append("\n");
							flatFile.append("}DG").append("\n");
						}
						else
						{
							if (!hCargoDetailVO.getCntrNo().equals("")
									&& !(hCargoDetailVO.getImdgClssCd().equals("1") && (hCargoDetailVO.getImdgCoGrpCd().equals("")))
									&& !(hCargoDetailVO.getImdgClssCd().equals("3") && (hCargoDetailVO.getValue1().equals(""))))
							{
								flatFile.append("{DG").append("\n");
								flatFile.append("DG_UN:").append(hCargoDetailVO.getImdgUnNo()).append("\n");
								flatFile.append("DG_IMO:").append(hCargoDetailVO.getImdgClssCd()).append("\n");
								flatFile.append("DG_CMPGRP:").append(hCargoDetailVO.getImdgCoGrpCd()).append("\n");
								flatFile.append("DG_CNTRNO:").append(hCargoDetailVO.getCntrNo()).append("\n");
								flatFile.append("DG_FLASH:").append(hCargoDetailVO.getValue1()).append("\n");
								flatFile.append("DG_QTY:").append(hCargoDetailVO.getValue2()).append("\n");
								flatFile.append("DG_KEPTIN:").append(hCargoDetailVO.getDgKeptin()).append("\n");
								flatFile.append("DG_TS:").append(hCargoDetailVO.getCntrTpszCd()).append("\n");
								flatFile.append("DG_POL:").append(hCargoDetailVO.getPolCd()).append("\n");
								flatFile.append("DG_POD:").append(hCargoDetailVO.getPodCd()).append("\n");
								flatFile.append("}DG").append("\n");
							}
						}
					}
					if (account != null) {
						String sndDt = command.searchLocalTime(account.getCnt_cd()+account.getOfc_cd().substring(0,3));
						transmitVO.setEdiSndDt(sndDt);
						transmitVO.setUpdUsrId(account.getUsr_id());
					}
					else {
						transmitVO.setEdiSndDt(command.searchLocalTime("USSAV"));
						transmitVO.setUpdUsrId("AUTO SEND");
					}

					
					BkgCstmsPnmSndLogVO bkgCstmsPnmSndLogVO = new BkgCstmsPnmSndLogVO();
					bkgCstmsPnmSndLogVO.setVstNo(basicInfoVO.getVstNo());
					bkgCstmsPnmSndLogVO.setVslCd(basicInfoVO.getVvdCd().substring(0, 4));
					bkgCstmsPnmSndLogVO.setSkdVoyNo(basicInfoVO.getVvdCd().substring(4, 8));
					bkgCstmsPnmSndLogVO.setSkdDirCd(basicInfoVO.getVvdCd().substring(8, 9));
					bkgCstmsPnmSndLogVO.setPolCd(basicInfoVO.getPolCd());
					bkgCstmsPnmSndLogVO.setPodCd(basicInfoVO.getPodCd());
					bkgCstmsPnmSndLogVO.setEdiSndMsgCtnt(flatFile.toString());
					bkgCstmsPnmSndLogVO.setCreUsrId(transmitVO.getUpdUsrId());
					bkgCstmsPnmSndLogVO.setSndDt(transmitVO.getEdiSndDt());
					bkgCstmsPnmSndLogVO.setCrrBatNo(sHeader.substring(sHeader.indexOf(ReferenceNumberGeneratorBroker.getChangedModule("BKC")) + 3));
					dbDao.addBkgCstmsPnmSndLogVO(bkgCstmsPnmSndLogVO);

					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile(flatFile.toString());
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_NOTICE.IBMMQ.QUEUE"));

					log.debug(flatFile.toString());
					FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

					if (flatFileAckVO.getAckStsCd().equals("E"))
						throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
				}
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return flatFile.toString();
	}
	
	/**
	 * BackEndJob을 실행.
	 * 
	 * @param SignOnUserAccount account
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, ManifestTransmitVO manifestTransmitVO, String pgmNo) throws EventException {
		PanamaCustomsTransmissionBackEndJob backEndJob = new PanamaCustomsTransmissionBackEndJob();
		backEndJob.setPgmNo(pgmNo);
		String resultStr = "";
		try {
			log.info("##########");
			log.info("pgmNo:"+pgmNo);
			log.info("##########");
			if (pgmNo.equals("ESM_BKG_0017")) {
				backEndJob.setManifestTransmitVO(manifestTransmitVO);
				backEndJob.setSignOnUserAccount(account);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				resultStr = backEndJobManager.execute(backEndJob, account.getUsr_id(), "Panama Transmit.");
			}

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return resultStr;
	}

	/**
	 * EDI Inbound 처리 메서드
	 * 
	 * @param rcvMsg
	 * @throws EventException
	 */
	public void loadCstmsRcvMsg(String rcvMsg) {
		try {
			String sDiv = "";
			if (rcvMsg.indexOf("\r\n") != -1)	sDiv = "\r\n";
			else							    sDiv = "\n";
			rcvMsg = rcvMsg + sDiv;
			
			String crrBatNo   = getReceiveSingleItem(rcvMsg,"ORG_MSG_KEY:",   sDiv);
			String cstmsAckCd = getReceiveSingleItem(rcvMsg,"MSG_ACK_RSLT:",  sDiv);
			String rcvDt      = getReceiveSingleItem(rcvMsg,"MSG_ACK_DT:",    sDiv);
			String err        = getReceiveSingleItem(rcvMsg,"ERR_CODE:",      sDiv);
			BkgCstmsPnmSndLogVO sndLog = dbDao.searchVstNo(crrBatNo);
			String vstNo      = sndLog.getVstNo();
			String vvdCd      = sndLog.getVvdCd();
			String rcvLogSeq  = dbDao.searchCstmsRcvNextSeq(vstNo, vvdCd);

			BkgCstmsPnmRcvLogVO bkgCstmsPnmRcvLogVO = new BkgCstmsPnmRcvLogVO();
			bkgCstmsPnmRcvLogVO.setRcvDt(rcvDt);
			bkgCstmsPnmRcvLogVO.setRcvLogSeq(rcvLogSeq);
			bkgCstmsPnmRcvLogVO.setVstNo(vstNo);
			bkgCstmsPnmRcvLogVO.setCstmsAckCd(cstmsAckCd);
			bkgCstmsPnmRcvLogVO.setCrrBatNo(crrBatNo);
			bkgCstmsPnmRcvLogVO.setEdiRcvMsgCtnt(rcvMsg.replaceAll("\r\n", "\n"));
			dbDao.addBkgCstmsPnmRcvLogVO(bkgCstmsPnmRcvLogVO);

			if (!StringUtils.isEmpty(err))
			{
				List<String> errCd = new ArrayList<String>();
				List<String> errMsg = new ArrayList<String>();
				StringBuffer sbErr = new StringBuffer();
				
				String[] arrRcvMsg = rcvMsg.split(sDiv);
				for (int i = 0; i < arrRcvMsg.length; i++)
				{
					if (arrRcvMsg[i].startsWith("ERR_CODE:"))
					{
						errCd.add(arrRcvMsg[i].substring(9));
					}
					else if (arrRcvMsg[i].startsWith("ERR_MSG:"))
					{
						errMsg.add(arrRcvMsg[i].substring(8));
					}
				}

				List<BkgCstmsPnmRcvErrVO> listErr = new ArrayList<BkgCstmsPnmRcvErrVO>();
				for (int i = 0; i < errCd.size(); i++)
				{
					BkgCstmsPnmRcvErrVO errVO = new BkgCstmsPnmRcvErrVO();
					errVO.setRcvDt(rcvDt);
					errVO.setRcvLogSeq(rcvLogSeq);
					errVO.setVstNo(vstNo);
					errVO.setRcvLogErrSeq(i+1+"");
					errVO.setCstmsErrId(errCd.get(i));
					errVO.setCstmsErrMsg(errMsg.get(i));
					listErr.add(errVO);
					sbErr.append(errMsg.get(i) + "\n");
				}
				dbDao.addBkgCstmsPnmRcvErrVO(listErr);

				if ("R".equals(cstmsAckCd))
				{
					// 메일전송
					this.sendMail(vvdCd, sbErr.toString());
				}
			}
			
		} catch (Exception ex) {
			log.error("loadCstmsRcvMsg ERROR===" + ex.getMessage());
		}
	}
	
	/**
	 * View RCV Log File 
	 * 
	 * @param BkgCstmsPnmRcvLogVO bkgCstmsPnmRcvLogVO
	 * @return List<BkgCstmsPnmRcvLogVO>
	 * @throws EventException
	 */
	public List<PanamaCstmsRcvLogVO> searchCstmsRcvLogList(BkgCstmsPnmRcvLogVO bkgCstmsPnmRcvLogVO) throws EventException {
		List<PanamaCstmsRcvLogVO> rcvVos = null;
		try {
		
			rcvVos = dbDao.searchCstmsRcvLogList(bkgCstmsPnmRcvLogVO);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return rcvVos;
	}

	/**
	 * View RCV Log File 
	 * 
	 * @param BkgCstmsPnmRcvLogVO bkgCstmsPnmRcvLogVO
	 * @return List<BkgCstmsPnmRcvLogVO>
	 * @throws EventException
	 */
	public List<BkgCstmsPnmRcvLogVO> searchCstmsRcvLogDetail(BkgCstmsPnmRcvLogVO bkgCstmsPnmRcvLogVO) throws EventException {

		List<BkgCstmsPnmRcvLogVO> list = new ArrayList<BkgCstmsPnmRcvLogVO>();
		
		try {
			BkgCstmsPnmRcvLogVO rcvVo = dbDao.searchCstmsRcvLogDetail(bkgCstmsPnmRcvLogVO);
			if (rcvVo != null)
			{
				StringTokenizer token = new StringTokenizer(rcvVo.getEdiRcvMsgCtnt(), "\n");
				while (token.hasMoreTokens())
				{
					BkgCstmsPnmRcvLogVO vo = new BkgCstmsPnmRcvLogVO();
					vo.setEdiRcvMsgCtnt(token.nextToken());
					list.add(vo);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 수신 파일
	 * @param src
	 * @param prefix
	 * @param endDelimeter
	 * @return
	 */
	private String getReceiveSingleItem(String src, String prefix, String endDelimeter){
		if(src == null) return "";
		String tmp ="";
	
		int index   = src.indexOf(prefix);
			
		if( index >= 0){
			tmp = src.substring(index+prefix.length());
			String rtn = tmp.substring(0,tmp.indexOf(endDelimeter));
			return JSPUtil.getNull(rtn.replace("\r",""));
		}
		return "";
	}
	
	/**
	 * Reject의 경우 메일전송
	 * @param vvdCd
	 * @param errMsg
	 */
	private void sendMail(String vvdCd, String errMsg)
	{
		try {
			// Reject EMail send
			StringBuffer emlAddr = new StringBuffer();
			CustomsCommonMgtBCImpl com = new CustomsCommonMgtBCImpl();
			CstmsCdConvVO vo = new CstmsCdConvVO();
			vo.setChkCntCd("PA");
			vo.setChkCstmsDivId("RCV_FAIL_EMAIL");
			List<CstmsCdConvVO> list = com.searchCstmsCdConvCtntList(vo);
			for (int i = 0; i < list.size(); i++) {
				emlAddr.append(list.get(i).getAttrCtnt1());
				emlAddr.append(";");
			}

			TemplateMail template = new TemplateMail();

			template.setHtmlTemplate("ESM_BKG_PnmRcv.html");
			template.setSubject("Panama Canal Authority Manifest REJECTION - VVD : " + vvdCd);
			template.setArg("vvd", vvdCd);
			template.setArg("reason", errMsg);

			template.setBatFlg("N");
			template.setFrom("noreply@cyberlogitec.com", "CTM EDI Monitor");
			template.setRecipient(emlAddr.toString());
			template.send();
		} catch (Exception ex) {
			log.error("loadCstmsRcvMsg sendMail ERROR===" + ex.getMessage());
		}
	}
}