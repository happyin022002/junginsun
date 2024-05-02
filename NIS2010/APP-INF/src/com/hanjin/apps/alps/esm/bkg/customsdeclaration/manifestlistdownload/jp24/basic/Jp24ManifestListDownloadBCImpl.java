/*=========================================================
Copyright(c) 2017 Hi-Plus Card
*@FileName : Jp24ManifestListDownloadBCImpl.java
*@FileTitle : Jp24ManifestListDownloadBCImpl
*Open Issues :
*Change history :
*	2017.09.07 하대성 2017 Renewal Version Transmit 반영
*@LastModifyDate : 2017.09.07
*@LastModifier : 하대성
*@LastVersion : 1.0
* 2013.06.28 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.basic;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration.Jp24ManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration.Jp24ManifestListDownloadEAIDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpCustomerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpMarkDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpReceiveLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.AdvJpSendLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.CargoInfoHeaderVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.DepartureTimeVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.EdiAdvJpCommonVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.ErrorReportVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.FlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.GetMdmCustomerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.JmsReportVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.MailContentsParamVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.vo.SendMailVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-Jp24ManifestListDownload Business Logic Command Interface<br>
 * - ALPS-Jp24ManifestListDownload 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author KIM, Sang-Soo
 * @param <utilCommand> 
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class Jp24ManifestListDownloadBCImpl<utilCommand> extends BasicCommandSupport implements Jp24ManifestListDownloadBC {
	// Database Access Object
	private transient Jp24ManifestListDownloadDBDAO dbDao = null;
	private transient Jp24ManifestListDownloadEAIDAO eaiDao = null;

	/**
	 * Jp24ManifestListDownloadBCImpl 객체 생성
	 * Jp24ManifestListDownloadDBDAO를 생성한다.<br>
	 */ 
	public Jp24ManifestListDownloadBCImpl() {
		dbDao = new Jp24ManifestListDownloadDBDAO();
		eaiDao = new Jp24ManifestListDownloadEAIDAO();
	}

	/**
	 * JP24 : [ESM_BKG_1501]
	 * Advance Cargo Information Download & Transmit - Header 목록 조회<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @return List<CargoInfoHeaderVO>
	 * @exception EventException
	 */
	public List<CargoInfoHeaderVO> searchCargoInfoHeader(CargoInfoHeaderVO cargoInfoHeaderVO) throws EventException {
		try {
			return dbDao.searchCargoInfoHeader(cargoInfoHeaderVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * JP24 : BackEndJob공통 - Back End Job Status 조회
	 *  (동일 BCImpl에 Back End Job이 여러개일때 공통으로 사용)<br>
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String getBackEndJobStatus(String backEndJobKey) throws EventException {
		try {
			DBRowSet rowSet = new BackEndJobMetaDataSelector(backEndJobKey).getDbRowset();
			rowSet.next();
			Thread.sleep(1000);
			return (String) rowSet.getObject("jb_sts_flg");
		} catch (BackEndJobException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (SQLException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (InterruptedException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * JP24 : [ESM_BKG_1501] Back End Job 시작
	 * Advance Cargo Information Download & Transmit - Detail 목록 조회<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobSearchCargoInfoDetail(CargoInfoHeaderVO cargoInfoHeaderVO, SignOnUserAccount account) {
		Jp24ManifestListDownloadSearchCargoInfoDetailBackEndJob backEndJob = new Jp24ManifestListDownloadSearchCargoInfoDetailBackEndJob();
		backEndJob.setCargoInfoHeaderVO(cargoInfoHeaderVO);

		BackEndJobManager backEndJobManager = new BackEndJobManager();
		return backEndJobManager.execute(backEndJob, account.getUsr_id(), "ESM_BKG_1501 - Retrieve");
	}

	/**
	 * JP24 : [ESM_BKG_1501] Back End Job 결과
	 * Advance Cargo Information Download & Transmit - Detail 목록 조회<br>
	 *
	 * @param String backEndJobKey
	 * @return List<CargoInfoDetailVO>
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public List<CargoInfoDetailVO> resultBackEndJobSearchCargoInfoDetail(String backEndJobKey) throws EventException {
		try {
			return (List<CargoInfoDetailVO>)BackEndJobResult.loadFromFile(backEndJobKey);
		} catch (BackEndJobException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * JP24 : [ESM_BKG_1501]
	 * VSL_CD로 Call Sing No.를 조회<br>
	 *
	 * @param String vslCd
	 * @return String
	 * @exception EventException
	 */
	public String getCallSignByVsl(String vslCd) throws EventException {
		try {
			return dbDao.getCallSignByVsl(vslCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * JP24 : [ESM_BKG_1501] Back End Job 시작
	 * Advance Cargo Information Download & Transmit - Detail 목록 저장<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @param CargoInfoDetailVO[] cargoInfoDetailVOs
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobManageCargoInfoDetail(CargoInfoHeaderVO cargoInfoHeaderVO, CargoInfoDetailVO[] cargoInfoDetailVOs, SignOnUserAccount account) {
		Jp24ManifestListDownloadManageCargoInfoDetailBackEndJob backEndJob = new Jp24ManifestListDownloadManageCargoInfoDetailBackEndJob();
		backEndJob.setCargoInfoHeaderVO(cargoInfoHeaderVO);
		backEndJob.setCargoInfoDetailVOs(cargoInfoDetailVOs);
		backEndJob.setAccount(account);

		BackEndJobManager backEndJobManager = new BackEndJobManager();
		return backEndJobManager.execute(backEndJob, account.getUsr_id(), "ESM_BKG_1501 - Save");
	}

	/**
	 * JP24 : [ESM_BKG_1501] Back End Job 결과
	 * Advance Cargo Information Download & Transmit - Detail 목록 저장<br>
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String resultBackEndJobManageCargoInfoDetail(String backEndJobKey) throws EventException {
		try {
			return (String)BackEndJobResult.loadFromFile(backEndJobKey);
		} catch (BackEndJobException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * JP24 : [ESM_BKG_1501] Back End Job 시작
	 * Advance Cargo Information Download & Transmit - Detail 목록 EDI 전송<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @param CargoInfoDetailVO[] cargoInfoDetailVOs
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobTransmitCargoInfoDetail(CargoInfoHeaderVO cargoInfoHeaderVO, CargoInfoDetailVO[] cargoInfoDetailVOs, SignOnUserAccount account) {
		Jp24ManifestListDownloadTransmitCargoInfoDetailBackEndJob backEndJob = new Jp24ManifestListDownloadTransmitCargoInfoDetailBackEndJob();
		backEndJob.setCargoInfoHeaderVO(cargoInfoHeaderVO);
		backEndJob.setCargoInfoDetailVOs(cargoInfoDetailVOs);
		backEndJob.setAccount(account);

		BackEndJobManager backEndJobManager = new BackEndJobManager();
		return backEndJobManager.execute(backEndJob, account.getUsr_id(), "ESM_BKG_1501 - EDI Transmit");
	}
	
	/**
	 * JP24 : [ESM_BKG_1501] Back End Job 시작
	 * Advance Cargo Information Download & New_Transmit - Detail 목록 EDI 전송<br>
	 *
	 * @param CargoInfoHeaderVO cargoInfoHeaderVO
	 * @param CargoInfoDetailVO[] cargoInfoDetailVOs
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobTransmitCargoInfoDetailRenewal2017(CargoInfoHeaderVO cargoInfoHeaderVO, CargoInfoDetailVO[] cargoInfoDetailVOs, SignOnUserAccount account) {
		Jp24ManifestListDownloadTransmitCargoInfoDetailBackEndJobRenewal2017 backEndJob = new Jp24ManifestListDownloadTransmitCargoInfoDetailBackEndJobRenewal2017();
		backEndJob.setCargoInfoHeaderVO(cargoInfoHeaderVO);
		backEndJob.setCargoInfoDetailVOs(cargoInfoDetailVOs);
		backEndJob.setAccount(account);

		BackEndJobManager backEndJobManager = new BackEndJobManager();
		return backEndJobManager.execute(backEndJob, account.getUsr_id(), "ESM_BKG_1501 - EDI Transmit");
	}

	/**
	 * JP24 : [ESM_BKG_1501] Back End Job 결과
	 * Advance Cargo Information Download & Transmit - Detail 목록 EDI 전송<br>
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String resultBackEndJobTransmitCargoInfoDetail(String backEndJobKey) throws EventException {
		try {
			return (String)BackEndJobResult.loadFromFile(backEndJobKey);
		} catch (BackEndJobException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * JP24 : [ESM_BKG_1501] Mail Send
	 * E-Mail전송과 ADV_JP_BL테이블의 USR_EML컬럼정보 수정<br>
	 *
	 * @param CargoInfoHeaderVO headerVO
	 * @param CargoInfoDetailVO[] detailVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageSendEmailCargoInfoDetail(CargoInfoHeaderVO headerVO, CargoInfoDetailVO[] detailVOs, SignOnUserAccount account) throws EventException {
		try {
			String vvd = headerVO.getVvd();
			String polCd = headerVO.getPolCd();

			String emlAddrString = "";
			String emlSndRsltFlg = "N";
			SendMailVO sendMailVO = new SendMailVO();

			for (int i=0; i<detailVOs.length; i++) {
				if ("".equals(detailVOs[i].getUsrEml().trim())) continue;

				String blNo = detailVOs[i].getBlNo();
				// 직전 bl_no와 같다면 skip
				if (i > 0 &&  blNo.equals(detailVOs[i - 1].getBlNo())) continue;

				MailContentsParamVO mailContentsParamVO = new MailContentsParamVO();
				mailContentsParamVO.setVvd(vvd);
				mailContentsParamVO.setBlNo(blNo);
				mailContentsParamVO.setPolCd(polCd);
				List<MailContentsParamVO> mailContentsVOList = dbDao.searchMailContentsParam(mailContentsParamVO);
				if (mailContentsVOList.size() > 0) {
					// 보내는사람
					String fromEmail = (dbDao.getUsrEmlOfBooking(blNo) + "").replaceAll(" ", "").trim();
					if ("".equals(fromEmail)) fromEmail = account.getUsr_eml();
					sendMailVO.setFromEmail(fromEmail);
					sendMailVO.setFromName("SM Line");
					// 제목
					sendMailVO.setSubject("Japan AFR Notice (AMR) - " + mailContentsVOList.get(0).getVslEngNm() + " + SMLM" + blNo);
					// E메일 전송시 사용될 일부 정보 setting
					String pol4Naccs = "";
					String pod4Naccs = "";
					String etdFullInfo = "";
					List<EdiAdvJpCommonVO> ediAdvJpCommonVOList = dbDao.searchEdiAdvJpBl(vvd, blNo, "" ,"");
					if (ediAdvJpCommonVOList.size() > 0) {
						pol4Naccs = ediAdvJpCommonVOList.get(0).getData06();
						pod4Naccs = ediAdvJpCommonVOList.get(0).getData18();
						etdFullInfo = DateTime.getFormatDate(ediAdvJpCommonVOList.get(0).getData10() + ediAdvJpCommonVOList.get(0).getData11(), "yyyyMMddHHmm", "yyyy-MM-dd HH:mm");
					}
					// 내용
					String rlxDiv = ("1".equals(headerVO.getRlxDiv()) ? "Y" : " "); 
					sendMailVO.setTextContent("\r\n" +
											  "\r\nVessel Information for Japan AFR(Advance Filing Rules)" +
											  "\r\n\nFrom SM Line Corporation" +
											  "\r\n" +
											  "\r\n" +
											  "\r\nWe transferred AMR with the below Vessel Information." +
											  "\r\n" +
											  "\r\n" +
											  "\r\nBooking & B/L# : SMLM" + blNo +
											  "\r\n" +
											  "\r\nCall Sign : " + mailContentsVOList.get(0).getCallSgnNo() +
											  "\r\nVessel Name : " + mailContentsVOList.get(0).getVslEngNm() +
											  "\r\nVoyage Number : " + vvd.substring(4) +
											  "\r\nCarrier Code : SMLM" +
											  "\r\nPOL code : " + pol4Naccs +
											  "\r\nPOL Name : " + mailContentsVOList.get(0).getPolNm() +
											  "\r\nETD of POL : " + etdFullInfo +
											  "\r\nPOD code : " + pod4Naccs +
											  "\r\nPOD Name : " + mailContentsVOList.get(0).getPodNm() +
											  "\r\nRelaxed Application Area Identifier : " + rlxDiv + "\r\n\r\n\r\n");

					emlAddrString = detailVOs[i].getUsrEml().replaceAll(" ", "").trim();
					//@ 테스트 메일계정 삭제 2017.08.16
//					emlAddrString += ";afr24hr@jp.smlines.com";    // User 임시 테스트용
					String[] tempEmlAddrArray = emlAddrString.split(";");
					for (String tempEmlAddr : tempEmlAddrArray) {
						// 받는사람
						sendMailVO.setRecipient(tempEmlAddr);
						// 메일 전송
						String emlSndNo = eaiDao.sendMail(sendMailVO);
						if (emlSndNo != null && !"".equals(emlSndNo)) {
							emlSndRsltFlg = "Y";
						}
					}
					// ADV_JP_BL 테이블에 변경된 E-Mail정보 저장 (E-Mail이 전송 되었을때만)
					if ("Y".equals(emlSndRsltFlg)) {
						detailVOs[i].setUsrEml(emlAddrString);
						detailVOs[i].setUsrId(account.getUsr_id());
						dbDao.modifyUsrEmlOfAdvJpBl(detailVOs[i]);
					}
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * JP24 : [ESM_BKG_1502]
	 * B/L Inquiry(Japan 24HR) 목록 조회<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @return List<AdvJpBlVO>
	 * @exception EventException
	 */
	public List<AdvJpBlVO> searchBLInquiry(AdvJpBlVO advJpBlVO) throws EventException {
		try {
			return dbDao.searchBLInquiry(advJpBlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * JP24 : [ESM_BKG_1502]
	 * B/L Inquiry(Japan 24HR)의 Tab2에 해당하는 Container목록 조회<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @return List<AdvJpContainerVO>
	 * @exception EventException
	 */
	public List<AdvJpContainerVO> searchBLInquiryContainer(AdvJpBlVO advJpBlVO) throws EventException {
		try {
			return dbDao.searchBLInquiryContainer(advJpBlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * JP24 : [ESM_BKG_1502]
	 * B/L Inquiry(Japan 24HR)의 Tab3에 해당하는 Mark & Desc목록 조회<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @return List<AdvJpMarkDescVO>
	 * @exception EventException
	 */
	public List<AdvJpMarkDescVO> searchBLInquiryMarkDesc(AdvJpBlVO advJpBlVO) throws EventException {
		try {
			return dbDao.searchBLInquiryMarkDesc(advJpBlVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * JP24 : [ESM_BKG_1502]
	 * Customer입력창에서 버튼클릭 시 MDM_CUSTOMER 정보 조회<br>
	 *
	 * @param GetMdmCustomerVO getMdmCustomerVO
	 * @return List<GetMdmCustomerVO>
	 * @exception EventException
	 */
	public List<GetMdmCustomerVO> getMdmCustomer(GetMdmCustomerVO getMdmCustomerVO) throws EventException {
		try {
			List<GetMdmCustomerVO> list = dbDao.getMdmCustomer(getMdmCustomerVO);
			if (list.size() > 0) {
				// FINC_STS_LVL_CD = Y
				if("Y".equals(list.get(0).getFincStsLvlCd())){
					throw new EventException((String)new ErrorHandler("BKG00353", new String[]{getMdmCustomerVO.getCustCntCd(), getMdmCustomerVO.getCustLglEngNm()}).getMessage());
				}
				// DELT_FLG = Y
				if("Y".equals(list.get(0).getDeltFlg())){
					throw new EventException((String)new ErrorHandler("BKG00354", new String[]{getMdmCustomerVO.getCustCntCd(), getMdmCustomerVO.getCustLglEngNm()}).getMessage());
				}
			} else {
				throw new EventException(new ErrorHandler("BKG00458").getMessage());
			}
			return list;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * JP24 : [ESM_BKG_1502]
	 * B/L Inquiry(Japan 24HR) 저장<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @param AdvJpContainerVO[] advJpContainerVOs
	 * @param AdvJpMarkDescVO[] advJpMarkDescVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBLInquiry(AdvJpBlVO advJpBlVO, AdvJpContainerVO[] advJpContainerVOs, AdvJpMarkDescVO[] advJpMarkDescVOs, SignOnUserAccount account) throws EventException {
		AdvJpCustomerVO advJpCustomerVO = null;
		List<AdvJpCustomerVO> insertAdvJpCustomerVOList = new ArrayList<AdvJpCustomerVO>();
		List<AdvJpContainerVO> insertAdvJpContainerVOList = new ArrayList<AdvJpContainerVO>();
		List<AdvJpContainerVO> updateAdvJpContainerVOList = new ArrayList<AdvJpContainerVO>();
		List<AdvJpContainerVO> deleteAdvJpContainerVOList = new ArrayList<AdvJpContainerVO>();
		List<AdvJpMarkDescVO> updateAdvJpMarkDescVOList = new ArrayList<AdvJpMarkDescVO>();

		try {
			// B/L Inquiry의 HTML Oblect Value 저장
			if (advJpBlVO != null && "Y".equals(advJpBlVO.getOnchangeFlag())) {
				advJpBlVO.setUsrId(account.getUsr_id());
				dbDao.modifyBLInquiry(advJpBlVO);
				// Shpper 저장
				advJpCustomerVO = new AdvJpCustomerVO();
				advJpCustomerVO.setBlNo(advJpBlVO.getBlNo());
				advJpCustomerVO.setBlSplitNo(advJpBlVO.getBlSplitNo());
				advJpCustomerVO.setBkgCustTpCd("S");
				advJpCustomerVO.setCustCntCd(advJpBlVO.getShprCntCd());
				advJpCustomerVO.setCustSeq(advJpBlVO.getShprSeq());
				advJpCustomerVO.setPhnNo(advJpBlVO.getShprPhnNo());
				advJpCustomerVO.setFaxNo(advJpBlVO.getShprFaxNo());
				advJpCustomerVO.setCustNm(advJpBlVO.getShprNm());
				advJpCustomerVO.setCustAddr(advJpBlVO.getShprAddr());
				advJpCustomerVO.setUsrId(advJpBlVO.getUsrId());
				insertAdvJpCustomerVOList.add(advJpCustomerVO);
				// Cnee 저장
				advJpCustomerVO = new AdvJpCustomerVO();
				advJpCustomerVO.setBlNo(advJpBlVO.getBlNo());
				advJpCustomerVO.setBlSplitNo(advJpBlVO.getBlSplitNo());
				advJpCustomerVO.setBkgCustTpCd("C");
				advJpCustomerVO.setCustCntCd(advJpBlVO.getCneeCntCd());
				advJpCustomerVO.setCustSeq(advJpBlVO.getCneeSeq());
				advJpCustomerVO.setPhnNo(advJpBlVO.getCneePhnNo());
				advJpCustomerVO.setFaxNo(advJpBlVO.getCneeFaxNo());
				advJpCustomerVO.setCustNm(advJpBlVO.getCneeNm());
				advJpCustomerVO.setCustAddr(advJpBlVO.getCneeAddr());
				advJpCustomerVO.setUsrId(advJpBlVO.getUsrId());
				insertAdvJpCustomerVOList.add(advJpCustomerVO);
				// Notofy 저장
				advJpCustomerVO = new AdvJpCustomerVO();
				advJpCustomerVO.setBlNo(advJpBlVO.getBlNo());
				advJpCustomerVO.setBlSplitNo(advJpBlVO.getBlSplitNo());
				advJpCustomerVO.setBkgCustTpCd("N");
				advJpCustomerVO.setCustCntCd(advJpBlVO.getNtfyCntCd());
				advJpCustomerVO.setCustSeq(advJpBlVO.getNtfySeq());
				advJpCustomerVO.setPhnNo(advJpBlVO.getNtfyPhnNo());
				advJpCustomerVO.setFaxNo(advJpBlVO.getNtfyFaxNo());
				advJpCustomerVO.setCustNm(advJpBlVO.getNtfyNm());
				advJpCustomerVO.setCustAddr(advJpBlVO.getNtfyAddr());
				advJpCustomerVO.setUsrId(advJpBlVO.getUsrId());
				insertAdvJpCustomerVOList.add(advJpCustomerVO);

				dbDao.modifyBLInquiryCustomer(insertAdvJpCustomerVOList);
			}

			// B/L Inquiry의 2번째 Tab의 Container 목록 저장
			if (advJpContainerVOs != null) {
				for (AdvJpContainerVO advJpContainerVO : advJpContainerVOs) {
					if ("I".equals(advJpContainerVO.getIbflag())) {
						advJpContainerVO.setUsrId(account.getUsr_id());
						insertAdvJpContainerVOList.add(advJpContainerVO);
					} else if ("U".equals(advJpContainerVO.getIbflag())) {
						advJpContainerVO.setUsrId(account.getUsr_id());
						updateAdvJpContainerVOList.add(advJpContainerVO);
					} else if ("D".equals(advJpContainerVO.getIbflag())) {
						deleteAdvJpContainerVOList.add(advJpContainerVO);
					}
				}
				if (insertAdvJpContainerVOList.size() > 0) dbDao.addAdvJpContainer(insertAdvJpContainerVOList);
				if (updateAdvJpContainerVOList.size() > 0) dbDao.modifyBLInquiryContainer(updateAdvJpContainerVOList);
				if (deleteAdvJpContainerVOList.size() > 0) dbDao.removeBLInquiryContainer(deleteAdvJpContainerVOList);
			}

			// B/L Inquiry의 3번째 Tab의 Mark & Desc 목록
			if (advJpMarkDescVOs != null) {
				for (AdvJpMarkDescVO advJpMarkDescVO : advJpMarkDescVOs) {
					if ("U".equals(advJpMarkDescVO.getIbflag())) {
						advJpMarkDescVO.setUsrId(account.getUsr_id());
						updateAdvJpMarkDescVOList.add(advJpMarkDescVO);
					}
				}
				if (updateAdvJpMarkDescVOList.size() > 0) dbDao.modifyBLInquiryMarkDesc(updateAdvJpMarkDescVOList);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * JP24 : [ESM_BKG_1502] Back End Job 시작
	 * B/L Inquiry(Japan 24HR) EDI 전송<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobTransmitBLInquiry(AdvJpBlVO advJpBlVO, SignOnUserAccount account) {

		CargoInfoHeaderVO cargoInfoHeaderVO = new CargoInfoHeaderVO();
		cargoInfoHeaderVO.setVvd(advJpBlVO.getVvd());
		cargoInfoHeaderVO.setPodSplitNo(advJpBlVO.getPodSplitNo());
		cargoInfoHeaderVO.setPolCd(advJpBlVO.getPolCd());
		cargoInfoHeaderVO.setPolSplitNo(advJpBlVO.getPolSplitNo());
	
		CargoInfoDetailVO cargoInfoDetailVO = new CargoInfoDetailVO();
		cargoInfoDetailVO.setBlNo(advJpBlVO.getBlNo());
		cargoInfoDetailVO.setPodCd(advJpBlVO.getPodCd());

		cargoInfoDetailVO.setTCmrKind(advJpBlVO.getTCmrKind());
		if ("9".equals(advJpBlVO.getTCmrKind())) {
			cargoInfoDetailVO.setTSType("AMR");
		} else{
			cargoInfoDetailVO.setTSType("CMR");
		}

		cargoInfoDetailVO.setBkgDelCd(advJpBlVO.getBkgDelCd());
		cargoInfoDetailVO.setPodDiv(advJpBlVO.getPodDiv());
		cargoInfoDetailVO.setRvisCntrCustTpCd(advJpBlVO.getRvisCntrCustTpCd());
		cargoInfoDetailVO.setUsrEml("");
		cargoInfoDetailVO.setOldUsrEml("");

		CargoInfoDetailVO[] cargoInfoDetailVOs = new CargoInfoDetailVO[1];
		cargoInfoDetailVOs[0] = cargoInfoDetailVO;

		Jp24ManifestListDownloadTransmitCargoInfoDetailBackEndJob backEndJob = new Jp24ManifestListDownloadTransmitCargoInfoDetailBackEndJob();
		backEndJob.setCargoInfoHeaderVO(cargoInfoHeaderVO);
		backEndJob.setCargoInfoDetailVOs(cargoInfoDetailVOs);
		backEndJob.setAccount(account);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		return backEndJobManager.execute(backEndJob, account.getUsr_id(), "ESM_BKG_1502 - EDI Transmit");
	}
	
	/**
	 * JP24 : [ESM_BKG_1502] Back End Job 시작
	 * B/L Inquiry(Japan 24HR) EDI 전송<br>
	 *
	 * @param AdvJpBlVO advJpBlVO
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String startBackEndJobTransmitBLInquiryRenewal2017(AdvJpBlVO advJpBlVO, SignOnUserAccount account) {

		CargoInfoHeaderVO cargoInfoHeaderVO = new CargoInfoHeaderVO();
		cargoInfoHeaderVO.setVvd(advJpBlVO.getVvd());
		cargoInfoHeaderVO.setPodSplitNo(advJpBlVO.getPodSplitNo());
		cargoInfoHeaderVO.setPolCd(advJpBlVO.getPolCd());
		cargoInfoHeaderVO.setPolSplitNo(advJpBlVO.getPolSplitNo());
		cargoInfoHeaderVO.setTCmrKind(advJpBlVO.getTCmrKind());
		
		CargoInfoDetailVO cargoInfoDetailVO = new CargoInfoDetailVO();
		cargoInfoDetailVO.setBlNo(advJpBlVO.getBlNo());
		cargoInfoDetailVO.setPodCd(advJpBlVO.getPodCd());

		cargoInfoDetailVO.setTCmrKind(advJpBlVO.getTCmrKind());
		if ("9".equals(advJpBlVO.getTCmrKind())) {
			cargoInfoDetailVO.setTSType("AMR");
		} else{
			cargoInfoDetailVO.setTSType("CMR");
		}

		cargoInfoDetailVO.setDelCd(advJpBlVO.getDelCd());
		cargoInfoDetailVO.setDelReason(advJpBlVO.getDelReason());
		cargoInfoDetailVO.setBkgDelCd(advJpBlVO.getBkgDelCd());
		cargoInfoDetailVO.setPodDiv(advJpBlVO.getPodDiv());
		cargoInfoDetailVO.setRvisCntrCustTpCd(advJpBlVO.getRvisCntrCustTpCd());
		cargoInfoDetailVO.setUsrEml("");
		cargoInfoDetailVO.setOldUsrEml("");

		CargoInfoDetailVO[] cargoInfoDetailVOs = new CargoInfoDetailVO[1];
		cargoInfoDetailVOs[0] = cargoInfoDetailVO;

		Jp24ManifestListDownloadTransmitCargoInfoDetailBackEndJobRenewal2017 backEndJob = new Jp24ManifestListDownloadTransmitCargoInfoDetailBackEndJobRenewal2017();
		backEndJob.setCargoInfoHeaderVO(cargoInfoHeaderVO);
		backEndJob.setCargoInfoDetailVOs(cargoInfoDetailVOs);
		backEndJob.setAccount(account);
		BackEndJobManager backEndJobManager = new BackEndJobManager();
		return backEndJobManager.execute(backEndJob, account.getUsr_id(), "ESM_BKG_1502 - EDI Transmit");
	}

	/**
	 * JP24 : [ESM_BKG_1502] Back End Job 결과
	 * B/L Inquiry(Japan 24HR) EDI 전송<br>
	 *
	 * @param String backEndJobKey
	 * @return String
	 * @exception EventException
	 */
	public String resultBackEndJobTransmitBLInquiry(String backEndJobKey) throws EventException {
		try {
			return (String)BackEndJobResult.loadFromFile(backEndJobKey);
		} catch (BackEndJobException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * JP24 : [ESM_BKG_1503]
	 * Departure Time Registration 조회<br>
	 *
	 * @param DepartureTimeVO departureTimeVO
	 * @return List<DepartureTimeVO>
	 * @exception EventException
	 */
	public List<DepartureTimeVO> searchDepartureTime(DepartureTimeVO departureTimeVO) throws EventException {
		try {
			return dbDao.searchDepartureTime(departureTimeVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * JP24 : [ESM_BKG_1503], [BATCH]
	 * Departure Time Registration EDI 전송<br>
	 *
	 * @param DepartureTimeVO departureTimeVO
	 * @exception EventException
	 */
	public void transmitDepartureTime(DepartureTimeVO departureTimeVO) throws EventException {
		com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil bookingUtil = new com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil();
		com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.integration.JapanCustomsTransmissionDBDAO japanCustomsTransmissionDBDAO =
				new com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.integration.JapanCustomsTransmissionDBDAO();
		List<com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListSendHeaderInfoForDmfVO> JapanManifestListSendHeaderInfoForDmfVOList =
				new ArrayList<com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListSendHeaderInfoForDmfVO>();
		com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO flatFileAckVO = new com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO();
		com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO sendFlatFileVO = new com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO();

		List<EdiAdvJpCommonVO> ediAdvJpCommonVOList = new ArrayList<EdiAdvJpCommonVO>();
		HashMap<String, String> mapEdiAdvJpCommonVO = new HashMap<String, String>();;
		DecimalFormat formatter = new DecimalFormat("00");
		StringBuilder completeflatFile = null;
		String replacementFlatFile = "";

		try {
			// BKG_CSTMS_ADV_JP_VSL_SKD테이블의 RLX_DIV(JO_CD1) 정보 UPDATE
			CargoInfoHeaderVO cargoInfoHeaderVO = new CargoInfoHeaderVO();
			cargoInfoHeaderVO.setRlxDiv(departureTimeVO.getRlxDiv());
			cargoInfoHeaderVO.setUsrId(departureTimeVO.getUsrId());
			cargoInfoHeaderVO.setVvd(departureTimeVO.getVvd());
			cargoInfoHeaderVO.setPolCd(departureTimeVO.getPolCd());
			dbDao.modifyAdvJpVslSkd(cargoInfoHeaderVO);

			// Flatfile Body (S)
			ediAdvJpCommonVOList = dbDao.searchEdiAdvJpVslSkd(departureTimeVO);
			mapEdiAdvJpCommonVO = ediAdvJpCommonVOList.get(0).getColumnValues();
			StringBuilder flatFileBody = new StringBuilder();
			for (int k=0; k<11 ; k++) {
				flatFileBody.append(mapEdiAdvJpCommonVO.get("data" + formatter.format(k))).append("\r\n");
			}
			// Flatfile Body (E)

			// E메일 전송시 RELAXED AREA ID
			String rlxDiv = ediAdvJpCommonVOList.get(0).getData10();
			// BKG_CSTMS_ADV_JP_SND_LOG에 저장 할 LOG SEQ 추출
			String logSeq = ediAdvJpCommonVOList.get(0).getData00();

			// Flatfile Replacing characters allowed
			replacementFlatFile = flatFileBody.toString().toUpperCase().replaceAll("‘", "'").replaceAll("’", "'").replaceAll("“", "\"").replaceAll("”", "\"").replaceAll("＂", "\"");
			replacementFlatFile = replacementFlatFile.replaceAll("[^A-Z0-9\\!\\\"\\#\\%\\&\\'\\(\\)\\*\\+\\,\\-\\.\\/\\:\\;\\<\\=\\>\\?\\@\\n\\r]", " ");

			/// Flatfile Header Setting
			String sendDate = bookingUtil.searchLocalTime(departureTimeVO.getCntCd() + departureTimeVO.getOfcCd().substring(0, 3));
			String vvd = departureTimeVO.getVvd();
			String polCd = departureTimeVO.getPolCd();
			JapanManifestListSendHeaderInfoForDmfVOList = japanCustomsTransmissionDBDAO.searchSendHeaderForDmf(vvd, polCd, departureTimeVO.getOfcCd(), departureTimeVO.getUsrId().replace("_", ""), replacementFlatFile.toString(), sendDate);

			// Flatfile Complete
			completeflatFile = new StringBuilder();
			completeflatFile.append(JapanManifestListSendHeaderInfoForDmfVOList.get(0).getHeader().replaceAll("DMF", "ATD")).append("\n");
			completeflatFile.append(JapanManifestListSendHeaderInfoForDmfVOList.get(0).getHeader2().replaceAll("DMF", "ATD")).append("\r\n");
			completeflatFile.append(replacementFlatFile);

			// FlatFile 전송
			sendFlatFileVO.setFlatFile(completeflatFile.toString());
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_NACCS.IBMMQ.QUEUE"));
			flatFileAckVO = bookingUtil.sendFlatFile(sendFlatFileVO);
			// (eaiDAO.sendFlatFile에 LIVE에서 TEST용으로 사용하는 임시 송신MQ정보가 하드코딩되어 있음)
			//flatFileAckVO = eaiDao.sendFlatFile(sendFlatFileVO);
			if (flatFileAckVO.getAckStsCd().equals("E")) throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());

			// E-Mail 전송 (S)
			String emlAddrString = "";
			String emlSndRsltFlg = "N";
			MailContentsParamVO mailContentsParamVO = new MailContentsParamVO();
			mailContentsParamVO.setVvd(vvd);
			mailContentsParamVO.setPolCd(polCd);
			List<MailContentsParamVO> mailContentsVOList = dbDao.searchMailContentsParam(mailContentsParamVO);
			if (mailContentsVOList.size() > 0) {
				String blNo = mailContentsVOList.get(0).getBlNo();
				SendMailVO sendMailVO = new SendMailVO();
				// 보내는사람
				String fromEmail = (dbDao.getUsrEmlOfBooking(blNo) + "").replaceAll(" ", "").trim();
				if ("".equals(fromEmail)) fromEmail = departureTimeVO.getUsrEml();
				sendMailVO.setFromEmail(fromEmail);
				sendMailVO.setFromName("SM Line");
				// 제목
				sendMailVO.setSubject("Japan AFR Notice (ATD) - " + mailContentsVOList.get(0).getVslEngNm() + " + SMLM" + blNo);
				// E메일 전송시 사용될 일부 정보 setting
				String pol4Naccs = "";
				String pod4Naccs = "";
				String etdFullInfo = "";
				ediAdvJpCommonVOList = dbDao.searchEdiAdvJpBl(vvd, blNo, "", "");
				if (ediAdvJpCommonVOList.size() > 0) {
					pol4Naccs = ediAdvJpCommonVOList.get(0).getData06();
					pod4Naccs = ediAdvJpCommonVOList.get(0).getData18();
					etdFullInfo = DateTime.getFormatDate(ediAdvJpCommonVOList.get(0).getData10() + ediAdvJpCommonVOList.get(0).getData11(), "yyyyMMddHHmm", "yyyy-MM-dd HH:mm");
				}
				// 내용
				sendMailVO.setTextContent("\r\n" +
										  "\r\nVessel Information for Japan AFR(Advance Filing Rules)" +
										  "\r\n\nFrom SM Line Corporation" +
										  "\r\n" +
										  "\r\n" +
										  "\r\nWe transferred AMR with the below Vessel Information." +
										  "\r\n" +
										  "\r\n" +
										  "\r\nBooking & B/L# : SMLM" + blNo +
										  "\r\n" +
										  "\r\nCall Sign : " + mailContentsVOList.get(0).getCallSgnNo() +
										  "\r\nVessel Name : " + mailContentsVOList.get(0).getVslEngNm() +
										  "\r\nVoyage Number : " + vvd.substring(4) +
										  "\r\nCarrier Code : SMLM" +
										  "\r\nPOL code : " + pol4Naccs +
										  "\r\nPOL Name : " + mailContentsVOList.get(0).getPolNm() +
										  "\r\nETD of POL : " + etdFullInfo +
										  "\r\nPOD code : " + pod4Naccs +
										  "\r\nPOD Name : " + mailContentsVOList.get(0).getPodNm() +
										  "\r\nRelaxed Application Area Identifier : " + rlxDiv + "\r\n\r\n\r\n");

				emlAddrString = (dbDao.getUsrEmlOfAdvJpBl(blNo) + "").replaceAll(" ", "").trim();
				if ("".equals(emlAddrString)) {
					emlAddrString = (dbDao.getCntcPsonEml(blNo) + "").replaceAll(" ", "").trim();
				}
				if (!"".equals(emlAddrString)) {
					
					// 입력된 Mail Address에 끝에 ";" 존재하면 제거
					if ( ";".equals(emlAddrString.substring(emlAddrString.length() - 1 )) ){
						emlAddrString = emlAddrString.substring(0, emlAddrString.length() - 1);
					}
					//@ 테스트 메일계정 삭제 2017.08.16
//					emlAddrString += ";afr24hr@jp.smlines.com";    // User 임시 테스트용
					String[] tempEmlAddrArray = emlAddrString.split(";");
					for (String tempEmlAddr : tempEmlAddrArray) {
						if (!(tempEmlAddr == null || "".equals(tempEmlAddr))){
							// 받는사람
							sendMailVO.setRecipient(tempEmlAddr);
							// 메일 전송
							String emlSndNo = eaiDao.sendMail(sendMailVO);
							if (emlSndNo != null && !"".equals(emlSndNo)) {
								emlSndRsltFlg = "Y";
							}
						}
					}
				}
				// ADV_JP_BL 테이블에 변경된 E-Mail정보 저장 (E-Mail이 전송 되었을때만)
				if ("Y".equals(emlSndRsltFlg)) {
					CargoInfoDetailVO cargoInfoDetailVO = new CargoInfoDetailVO();
					cargoInfoDetailVO.setBlNo(blNo);
					cargoInfoDetailVO.setUsrEml(emlAddrString);
					cargoInfoDetailVO.setUsrId(departureTimeVO.getUsrId());
					dbDao.modifyUsrEmlOfAdvJpBl(cargoInfoDetailVO);
				}
			}
			// E-Mail 전송 (E)

			// 전송결과 저장
			AdvJpSendLogVO advJpSendLogVO = new AdvJpSendLogVO();
			advJpSendLogVO.setTSType("ATD");
			advJpSendLogVO.setMsgSndSeq(JapanManifestListSendHeaderInfoForDmfVOList.get(0).getHeader().substring(36, 41));
			advJpSendLogVO.setMsgSndDiv(vvd);	// VVD
			advJpSendLogVO.setSndDt(sendDate);
			advJpSendLogVO.setOfcCd(departureTimeVO.getOfcCd());
			advJpSendLogVO.setLogSeq(logSeq);
			advJpSendLogVO.setVvd(vvd);
			advJpSendLogVO.setPolCd(polCd);
			advJpSendLogVO.setPolSplitNo(departureTimeVO.getPolSplitNo());
			advJpSendLogVO.setFlatFile(completeflatFile.toString());
			advJpSendLogVO.setCntcPsonEml(emlAddrString);
			advJpSendLogVO.setEmlSndRsltFlg(emlSndRsltFlg);
			advJpSendLogVO.setUsrId(departureTimeVO.getUsrId());
			dbDao.addAdvJpSendLog(advJpSendLogVO);

			// BKG_CSTMS_ADV_JP_VSL_SKD 테이블에 전송Flag Update
			dbDao.modifyTrnsFlagOfAdvJpVslSkd(departureTimeVO);

		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * JP24 : [ESM_BKG_1504]
	 * JMS Report 목록 조회<br>
	 *
	 * @param JmsReportVO jmsReportVO
	 * @return List<JmsReportVO>
	 * @exception EventException
	 */
	public List<JmsReportVO> searchJmsReport(JmsReportVO jmsReportVO) throws EventException {
		try {
			return dbDao.searchJmsReport(jmsReportVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * JP24 : [UDEV_ALPSBKG_T_JPN24]
	 * 일본세관에서 송신한 EDI메세지를 수신 처리<br>
	 *
	 * @param String flatFile
	 * @exception EventException
	 */
	public void receiveEDIForJapan24HR(String flatFile) throws EventException {
		List<AdvJpReceiveLogVO> insertVOList = new ArrayList<AdvJpReceiveLogVO>();
		List<AdvJpReceiveLogVO> updateVOList = new ArrayList<AdvJpReceiveLogVO>();
		List<AdvJpReceiveLogVO> insertVOList2 = new ArrayList<AdvJpReceiveLogVO>(); //MGERGE문 CLOB일 경우 CLOB에 2000byte넘어가면 에러여서 SASXXX 은 INSERT문으로 뺌.
		AdvJpReceiveLogVO advJpReceiveLogVO = null;
		AdvJpReceiveLogVO tempReceiveLogVO = new AdvJpReceiveLogVO();;
		String vslCd = "";
		String skdVoyNo = "";
		String skdDirCd = "";
		String polCd = "";

		try {
			String[] rowArray = flatFile.split("\n");

			if (rowArray[0].length() > 397) {
				String tempTitle = rowArray[0].substring(8, 14);
				String creUserId = rowArray[0].substring(253, 263).trim();
				if ("".equals(creUserId)) creUserId = "EDI";

				if ("SAS108".equals(tempTitle)) {
					tempReceiveLogVO.setCallSgnNo(rowArray[1].trim());
					skdVoyNo = rowArray[2].substring(0, 4).trim();
					tempReceiveLogVO.setSkdVoyNo(skdVoyNo);
					skdDirCd = rowArray[2].substring(4, 5).trim();
					tempReceiveLogVO.setSkdDirCd(skdDirCd);
					List<AdvJpReceiveLogVO> tempReceiveLogVOList = dbDao.getAdvJpVslByCallsign(tempReceiveLogVO);
					String rlxDiv = tempReceiveLogVOList.get(0).getRlxDiv();
					if (tempReceiveLogVOList.size() > 0) {
						vslCd = tempReceiveLogVOList.get(0).getVslCd();
						polCd = tempReceiveLogVOList.get(0).getPolCd();
						rlxDiv = tempReceiveLogVOList.get(0).getRlxDiv();
					}

					String podCd = rowArray[10].trim();
					String blNo = "";
					String line16 = "";
					String line18 = "";
					for (int i=14; i<rowArray.length; i=i+7) {
						if (i+6 > rowArray.length || rowArray[i].trim().length() < 16) break;
						advJpReceiveLogVO = new AdvJpReceiveLogVO();
						advJpReceiveLogVO.setJpMsgTpId(tempTitle);
						advJpReceiveLogVO.setJpSvcId(tempTitle);
						advJpReceiveLogVO.setVslCd(vslCd);
						advJpReceiveLogVO.setSkdVoyNo(skdVoyNo);
						advJpReceiveLogVO.setSkdDirCd(skdDirCd);
						advJpReceiveLogVO.setPolCd(polCd);
						advJpReceiveLogVO.setPodCd(podCd);
						advJpReceiveLogVO.setUsrId(creUserId);
						advJpReceiveLogVO.setEdiRcvMsgCtnt(flatFile);
						advJpReceiveLogVO.setRcvSeq("1");
						// 15라인부터 다건의 B/L일 경우에도 처리
						blNo = rowArray[i].substring(4).trim();
						advJpReceiveLogVO.setBkgNo(blNo);
						line16 = rowArray[i+1].trim();
						line18 = rowArray[i+3].trim();
						advJpReceiveLogVO.setRcvKeyDatCtnt(line16 + "/" + rowArray[i + 2].trim() + "/" + line18 + "/" + rowArray[i+4].trim() + "/" + rowArray[i+5].trim() + "/" + rowArray[i+6].trim());
						insertVOList2.add(advJpReceiveLogVO);

						// line16 또는 line18에 Error 메세지가 있을 경우
						if (!"".equals(line16) || !"".equals(line18)) {
							String vvd = vslCd + skdVoyNo + skdDirCd;
							// E-Mail 전송 (S)
							MailContentsParamVO mailContentsParamVO = new MailContentsParamVO();
							mailContentsParamVO.setVvd(vvd);
							mailContentsParamVO.setBlNo(blNo);
							mailContentsParamVO.setPolCd(polCd);
							List<MailContentsParamVO> mailContentsVOList = dbDao.searchMailContentsParam(mailContentsParamVO);
							if (mailContentsVOList.size() > 0) {

								String emlAddrString = "";
								String emlSndRsltFlg = "N";
								SendMailVO sendMailVO = new SendMailVO();
								// 보내는사람
								String fromEmail = (dbDao.getUsrEmlOfBooking(blNo) + "").replaceAll(" ", "").trim();
								if ("".equals(fromEmail)) fromEmail = "noreply@smlines.com";
								sendMailVO.setFromEmail(fromEmail);
								sendMailVO.setFromName("SM Line");

								// 제목
								sendMailVO.setSubject("Japan AFR Notice (The discrepancy Info) - " + mailContentsVOList.get(0).getVslEngNm() + " + SMLM" + blNo);
								// E메일 전송시 사용될 일부 정보 setting
								String pol4Naccs = "";
								String pod4Naccs = "";
								String etdFullInfo = "";
								List<EdiAdvJpCommonVO> ediAdvJpCommonVOList = dbDao.searchEdiAdvJpBl(vvd, blNo, "" ,"");
								if (ediAdvJpCommonVOList.size() > 0) {
									pol4Naccs = ediAdvJpCommonVOList.get(0).getData06();
									pod4Naccs = ediAdvJpCommonVOList.get(0).getData18();
									etdFullInfo = DateTime.getFormatDate(ediAdvJpCommonVOList.get(0).getData10() + ediAdvJpCommonVOList.get(0).getData11(), "yyyyMMddHHmm", "yyyy-MM-dd HH:mm");
								}
								// 내용
								String textContent = "\r\n" +
													 "\r\nVessel Information for Japan AFR(Advance Filing Rules)" +
													 "\r\n\nFrom SM Line Corporation" +
													 "\r\n" +
													 "\r\n" +
													 "\r\nWe received Discrepancy Information of Advance Filing (non-Government) (SAS108)." +
													 "\r\n\nThe discrepancy notice was issued to this B/L from Japan Sea-Naccs." +
													 "\r\n\nReason for discrepancy is assumed asf." +
													 "\r\n" +
													 "\r\n";

								if ("H".equals(line16)) {
									textContent += "\r\nAMR and CMR have been done. AHR and CHR have not been" +
												   "\r\n\nThe related \"Advance Cargo Information Registration (House B/L)(AHR) has not filed with Japan Customs (Sea-Naccs) yet.";
								} else if ("S".equals(line18)) {
									textContent += "\r\nThere is vessel information discrepancy between master B/L and house B/L." +
												   "\r\n\nThe vessel information in the related \"Advance Cargo Information Registration (House B/L)(AHR) was wrongly filed to Japan Customs (Sea-Naccs).";
								}

								textContent +=  "\r\n" +
												"\r\n" +
												"\r\nBooking & B/L# : SMLM" + blNo +
												"\r\n" +
												"\r\nCall Sign : " + mailContentsVOList.get(0).getCallSgnNo() +
												"\r\nVessel Name : " + mailContentsVOList.get(0).getVslEngNm() +
												"\r\nVoyage Number : " + vvd.substring(4) +
												"\r\nCarrier Code : SMLM" +
												"\r\nPOL code : " + pol4Naccs +
												"\r\nPOL Name : " + mailContentsVOList.get(0).getPolNm() +
												"\r\nETD of POL : " + etdFullInfo +
												"\r\nPOD code : " + pod4Naccs +
												"\r\nPOD Name : " + mailContentsVOList.get(0).getPodNm() +
												"\r\nRelaxed Application Area Identifier : " + rlxDiv + "\r\n\r\n\r\n";

								sendMailVO.setTextContent(textContent);

								emlAddrString = (dbDao.getUsrEmlOfAdvJpBl(blNo) + "").replaceAll(" ", "").trim();
								if ("".equals(emlAddrString)) {
									emlAddrString = (dbDao.getCntcPsonEml(blNo) + "").replaceAll(" ", "").trim();
								}
								if (!"".equals(emlAddrString)) {
									//@ 테스트 메일계정 삭제 2017.08.16
//									emlAddrString += ";afr24hr@jp.smlines.com";    // User 임시 테스트용
									String[] tempEmlAddrArray = emlAddrString.split(";");
									for (String tempEmlAddr : tempEmlAddrArray) {
										// 받는사람
										sendMailVO.setRecipient(tempEmlAddr);
										// 메일 전송
										String emlSndNo = eaiDao.sendMail(sendMailVO);
										if (emlSndNo != null && !"".equals(emlSndNo)) {
											emlSndRsltFlg = "Y";
										}
									}
								}
								// ADV_JP_BL 테이블에 변경된 E-Mail정보 저장 (E-Mail이 전송 되었을때만)
								if ("Y".equals(emlSndRsltFlg)) {
									CargoInfoDetailVO cargoInfoDetailVO = new CargoInfoDetailVO();
									cargoInfoDetailVO.setBlNo(blNo);
									cargoInfoDetailVO.setUsrEml(emlAddrString);
									cargoInfoDetailVO.setUsrId(creUserId);
									dbDao.modifyUsrEmlOfAdvJpBl(cargoInfoDetailVO);
								}
								// E-Mail 전송 (E)
							}
						}
					}

				} else if ("SAS111".equals(tempTitle)) {
					tempReceiveLogVO.setCallSgnNo(rowArray[7].trim());
					skdVoyNo = rowArray[9].substring(0, 4).trim();
					tempReceiveLogVO.setSkdVoyNo(skdVoyNo);
					skdDirCd = rowArray[9].substring(4, 5).trim();
					tempReceiveLogVO.setSkdDirCd(skdDirCd);
					List<AdvJpReceiveLogVO> tempReceiveLogVOList = dbDao.getAdvJpVslByCallsign(tempReceiveLogVO);
					if (tempReceiveLogVOList.size() > 0) {
						vslCd = tempReceiveLogVOList.get(0).getVslCd();
						polCd = tempReceiveLogVOList.get(0).getPolCd();
					}
					advJpReceiveLogVO = new AdvJpReceiveLogVO();
					advJpReceiveLogVO.setJpMsgTpId(tempTitle);
					advJpReceiveLogVO.setJpSvcId(tempTitle);
					advJpReceiveLogVO.setBkgNo(rowArray[1].substring(4).trim());
					advJpReceiveLogVO.setRcvKeyDatCtnt(rowArray[3].trim());
					advJpReceiveLogVO.setVslCd(vslCd);
					advJpReceiveLogVO.setSkdVoyNo(skdVoyNo);
					advJpReceiveLogVO.setSkdDirCd(skdDirCd);
					advJpReceiveLogVO.setPolCd(polCd);
					advJpReceiveLogVO.setUsrId(creUserId);
					advJpReceiveLogVO.setEdiRcvMsgCtnt(flatFile);
					advJpReceiveLogVO.setRcvSeq("1");
					insertVOList2.add(advJpReceiveLogVO);

				} else if ("SAS112".equals(tempTitle)) {    // 기 수신된 SAS111메세지에 대한 성공처리결과 update
					advJpReceiveLogVO = new AdvJpReceiveLogVO();
					advJpReceiveLogVO.setJpMsgTpId("SAS111");
					advJpReceiveLogVO.setJpSvcId("SAS111");
					advJpReceiveLogVO.setBkgNo(rowArray[1].substring(4).trim());
					advJpReceiveLogVO.setRcvKeyDatCtnt(rowArray[3].trim());
					advJpReceiveLogVO.setUsrId(creUserId);
					updateVOList.add(advJpReceiveLogVO);

				// 2016.08.22 SAS122 추가: SAS112와 같이 SAS111 CLEAR 처리
				} else if ("SAS122".equals(tempTitle)) {    // 기 수신된 SAS111메세지에 대한 SPD 성공처리결과 update
										
					for (int j=21; j<rowArray.length; j++) {
						if (!rowArray[j].toString().equals("###")) {
							advJpReceiveLogVO = new AdvJpReceiveLogVO();
							advJpReceiveLogVO.setJpMsgTpId("SAS111");
							advJpReceiveLogVO.setJpSvcId("SAS111");
							advJpReceiveLogVO.setRcvKeyDatCtnt("SPD");
							advJpReceiveLogVO.setUsrId(creUserId);
							
							advJpReceiveLogVO.setBkgNo(rowArray[j].substring(4).trim());
							log.debug(rowArray[j].substring(4).trim());
							updateVOList.add(advJpReceiveLogVO);
						}
					}
				} else if (tempTitle.indexOf("*SAMR") > -1 || tempTitle.indexOf("*SCMR") > -1) {
					int rcvKeyDatCtntKnt = rowArray[1].trim().length() / 15 ;
					for (int k=0; k<rcvKeyDatCtntKnt; k++) {
						advJpReceiveLogVO = new AdvJpReceiveLogVO();
						advJpReceiveLogVO.setJpMsgTpId(tempTitle.substring(1, 5));
						advJpReceiveLogVO.setJpSvcId(tempTitle.substring(1, 5));
						advJpReceiveLogVO.setRcvKeyDatCtnt(rowArray[1].trim().substring(k*15, (k+1)*15));
						advJpReceiveLogVO.setBkgNo(rowArray[2].substring(4).trim());
						advJpReceiveLogVO.setUsrId(creUserId);
						advJpReceiveLogVO.setEdiRcvMsgCtnt(flatFile);
						advJpReceiveLogVO.setRcvSeq("1");
						insertVOList.add(advJpReceiveLogVO);
					}

				} else if (tempTitle.indexOf("*SATD") > -1) {
					tempReceiveLogVO.setCallSgnNo(rowArray[2].trim());
					skdVoyNo = rowArray[3].substring(0, 4).trim();
					tempReceiveLogVO.setSkdVoyNo(skdVoyNo);
					skdDirCd = rowArray[3].substring(4, 5).trim();
					tempReceiveLogVO.setSkdDirCd(skdDirCd);
					List<AdvJpReceiveLogVO> tempReceiveLogVOList = dbDao.getAdvJpVslByCallsign(tempReceiveLogVO);
					if (tempReceiveLogVOList.size() > 0) {
						vslCd = tempReceiveLogVOList.get(0).getVslCd();
						polCd = tempReceiveLogVOList.get(0).getPolCd();
					}

					int rcvKeyDatCtntKnt = rowArray[1].trim().length() / 15 ;
					for (int k=0; k<rcvKeyDatCtntKnt; k++) {
						advJpReceiveLogVO = new AdvJpReceiveLogVO();
						advJpReceiveLogVO.setJpMsgTpId(tempTitle.substring(1, 5));
						advJpReceiveLogVO.setJpSvcId(tempTitle.substring(1, 5));
						advJpReceiveLogVO.setRcvKeyDatCtnt(rowArray[1].trim().substring(k*15, (k+1)*15));
						advJpReceiveLogVO.setVslCd(vslCd);
						advJpReceiveLogVO.setSkdVoyNo(skdVoyNo);
						advJpReceiveLogVO.setSkdDirCd(skdDirCd);
						advJpReceiveLogVO.setPolCd(polCd);
						advJpReceiveLogVO.setUsrId(creUserId);
						advJpReceiveLogVO.setEdiRcvMsgCtnt(flatFile);
						advJpReceiveLogVO.setRcvSeq("1");
						insertVOList.add(advJpReceiveLogVO);
					}
				}

				if (insertVOList.size() > 0) dbDao.addAdvJpReceiveLog(insertVOList);
				if (insertVOList2.size() > 0) dbDao.addAdvJpReceiveLogIns(insertVOList2);
				if (updateVOList.size() > 0) dbDao.modifyJpBatNoOfAdvJpReceiveLog(updateVOList);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * JP24 : [ESM_BKG_1505]
	 * Transmit Result Error Report 목록 조회<br>
	 *
	 * @param ErrorReportVO errorReportVO
	 * @return List<ErrorReportVO>
	 * @exception EventException
	 */
	public List<ErrorReportVO> searchErrorReport(ErrorReportVO errorReportVO) throws EventException {
		List<ErrorReportVO> errorReportVOList = new ArrayList<ErrorReportVO>();
		try {
			String jpMsgTpId = errorReportVO.getJpMsgTpId();

			if ("SAMR".equals(jpMsgTpId) || "SCMR".equals(jpMsgTpId)) {
				errorReportVOList = dbDao.searchErrorReportForAmrCmr(errorReportVO);

			} else if ("SAS111".equals(jpMsgTpId)) {
				List<FlatFileVO> flatFileVOList = dbDao.searchErrorReportForSas111(errorReportVO);
				if (flatFileVOList.size() > 0) {
					String[] flatFileRowArray = flatFileVOList.get(0).getFlatFile().split("\n");
					int flatFileRowLength = (flatFileRowArray.length > 22 ? 23 : flatFileRowArray.length);
					ErrorReportVO tempErrorReportVO = null;
					StringBuilder errorMsg = new StringBuilder();
					for (int i=15; i<flatFileRowLength+1; i++) errorMsg.append(flatFileRowArray[i]);
					tempErrorReportVO = new ErrorReportVO();
					tempErrorReportVO.setAttrCtnt1(errorReportVO.getErrCd());
					tempErrorReportVO.setAttrCtnt4(errorMsg.toString().trim());
					errorReportVOList.add(tempErrorReportVO);
				}

			} else {
				errorReportVOList = dbDao.searchErrorReport(errorReportVO);
			}
			return errorReportVOList;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * JP24 : [ESM_BKG_1506]
	 * Send FlatFile 조회<br>
	 *
	 * @param FlatFileVO flatFileVO
	 * @return List<FlatFileVO>
	 * @exception EventException
	 */
	public List<FlatFileVO> searchSendFlatFile(FlatFileVO flatFileVO) throws EventException {
		List<FlatFileVO> returnflatFileVOList = new ArrayList<FlatFileVO>();
		FlatFileVO returnflatFileVO = null;
		try {
			List<FlatFileVO> tempFlatFileVOList = dbDao.searchSendFlatFile(flatFileVO);
			if (tempFlatFileVOList != null && tempFlatFileVOList.size() > 0) {
				String[] flatFileRowArray = tempFlatFileVOList.get(0).getFlatFile().split("\n");
				for (int i=0; i<flatFileRowArray.length; i++) {
					returnflatFileVO = new FlatFileVO();
					returnflatFileVO.setFlatFile(flatFileRowArray[i].replace("\r", ""));
					returnflatFileVOList.add(returnflatFileVO);
				}
			}
			return returnflatFileVOList;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}
