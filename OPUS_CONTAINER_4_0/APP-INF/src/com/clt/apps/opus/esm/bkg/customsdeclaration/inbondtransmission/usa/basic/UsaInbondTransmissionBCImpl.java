/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaInbondTransmissionBCImpl.java
*@FileTitle : Generate Arrival Manifest by Container
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.22
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.04.22 김도완
* 1.0 Creation
* ------------------------------------------------------
* History
* 2012.02.03 민정호 [CHM-201215726] AMS 전송시 Customs 로직 추가 요청
* 2012.04.24 민정호 [] Port code assignment for NY/NJ
* 2012.04.24 민정호 [CHM-201216602] Rail AMS 수신시 hold / hold release 관련 보완 (ACE 관련)
* 2012.05.10 김보배 [CHM-201217461] [BKG] [ACE M1] US AMS 전송후 1J 이후 Diversion 요청 기능 추가
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.basic.UsaCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.EtaCondAtAdvancedVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.EtaDetailAtAdvancedVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaMiCountVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaTrsmFirstHeadVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.SendingLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.integration.UsaACEInbondTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.integration.UsaInbondTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.ClearanceTypeCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.ClearanceTypeDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.LclMibCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaArrHeaderCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaContainerVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondManifestDetailListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaInbondManifestListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaMibTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondManifestDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.vo.InbondMibListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.vo.MibTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.basic.UsaManifestListDownloadBCImpl;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCstmsCdConvCtntVO;
import com.clt.syscommon.common.table.MdmVslCntrVO;


/**
 * ALPS-InbondTransmission Business Logic Basic Command implementation<br>
 * - ALPS-InbondTransmission에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim DoWan
 * @see ESM_BKG_0533EventResponse,UsaInbondTransmissionBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class UsaInbondTransmissionBCImpl extends BasicCommandSupport implements UsaInbondTransmissionBC {

	// Database Access Object
	private transient UsaInbondTransmissionDBDAO dbDao = null;
	private transient UsaACEInbondTransmissionDBDAO dbAceInbondDao = null;	// 추가ACE-Inbond

	/**
	 * UsaInbondTransmissionBCImpl 객체 생성<br>
	 * UsaInbondTransmissionDBDAO를 생성한다.<br>
	 */
	public UsaInbondTransmissionBCImpl() {
		dbDao = new UsaInbondTransmissionDBDAO();
//		dbAceDao = new UsaACECustomsTransmissionDBDAO();		// 추가ACE
		dbAceInbondDao = new UsaACEInbondTransmissionDBDAO();	// 추가ACE-Inbond
	}

	/**
	 * 0408, PMIB Manifest List의 상단, 하단 그리드 조회실행<br>
	 *
	 * @param InbondListCondVO inbondListCondVO
	 * @return List<InbondMibListDetailVO>
	 * @exception EventException
	 */
	public List<InbondMibListDetailVO> searchInbondManifestList(InbondListCondVO inbondListCondVO ) throws EventException{

		UsaInbondManifestListCondVO usaInbondManifestListCondVO = (UsaInbondManifestListCondVO) inbondListCondVO;
		List<UsaInbondManifestListVO> usaInbondManifestDetailVOs = null;

		UsaContainerVO usaContainerVO = new UsaContainerVO();
		List<UsaInbondManifestDetailListVO> inbondVos = null;
		LclMibCondVO lclMibCondVO = new LclMibCondVO();

		List<InbondMibListDetailVO> inbondMibListDetailVOs = new ArrayList<InbondMibListDetailVO>();
		try {
			String pageNo = usaInbondManifestListCondVO.getPageNo();
			// 0533 화면등에서 호출.
			if( ! pageNo.equals("ESM_BKG_0408")){
				usaInbondManifestDetailVOs = dbDao.searchInbondArrivalManifestList(usaInbondManifestListCondVO);
				usaContainerVO.setUsaInbondManifestListVOs(usaInbondManifestDetailVOs);
				inbondMibListDetailVOs.add((InbondMibListDetailVO)usaContainerVO);
			// 0408 화면에서 호출.( Paperless MIB Generate 화면 최상위 시트 조회)
			}else{

				// 상단화면의 로우 데이터 vo 를 찾아보고 있다면, 하단 화면 조회, 없다면 상단화면 조회.
				UsaInbondManifestListVO vo = usaInbondManifestListCondVO.getUsaInbondManifestListVO();
				// 상단화면 조회 수행.
				if (vo == null) {
					// List 조회.
					usaInbondManifestDetailVOs = dbDao.searchMibManifestList(usaInbondManifestListCondVO);

					// 조회결과에 대해 각각 Partial 여부 검사 및 셋업.

					String lclMibFlag = "N";
					for (int i = 0; i < usaInbondManifestDetailVOs.size(); i++) {

						// Partial 여부 검사 를 위한 조건 셋업.
						lclMibCondVO.setDel(usaInbondManifestDetailVOs.get(i).getDelCd());
						lclMibCondVO.setVvd(usaInbondManifestDetailVOs.get(i).getVvd());
						lclMibCondVO.setHub(usaInbondManifestDetailVOs.get(i).getHubLocCd());
						lclMibCondVO.setPmib(usaInbondManifestDetailVOs.get(i).getIbdTrspNo());
						lclMibCondVO.setPod(usaInbondManifestDetailVOs.get(i).getPodCd());

						// BL_NO조건을 ""으로 넘기면 전체 bl_no으로 조회함.
						lclMibCondVO.setBlNo("");

						// Partial 여부 검사
						lclMibFlag = dbDao.searchLclMibFlag(lclMibCondVO);

						// 결과 셋업.
						usaInbondManifestDetailVOs.get(i).setLclFlg(lclMibFlag);
					}
					usaContainerVO.setUsaInbondManifestListVOs(usaInbondManifestDetailVOs);

				} else {
					// 하단 시트 상세 리스트 중, In-Bond B/L 리스트 조회.
					vo.setInbondLocal("I");
					inbondVos = dbDao.searchInbondManifestDeatilList(vo);
					String lclMibFlag = "N";

					// getTrspAuthDt 에 "to query bl list for AI transmit" 값이 들어
					// 있는 경우는 transmit 할 때,
					// 상단 그리드에 대한 bl 리스트를 조회 하기 위한 BC 호출에서 일어난다.
					// 이때에는 LCL 체크 조회 및 Local BL 조회를 실행하지 않는다.
					if (!"to query bl list for AI transmit".equals(vo.getTrspAuthDt())) {
						// 하단 시트 상세 리스트 중, In-Bond B/L 리스트의 partial 여부 셋업.
						lclMibFlag = "N";
						for (int j = 0; j < inbondVos.size(); j++) {

							// Partial 여부 검사 를 위한 조건 셋업.
							lclMibCondVO.setDel(vo.getDelCd());
							lclMibCondVO.setVvd(vo.getVvd());
							lclMibCondVO.setHub(vo.getHubLocCd());
							lclMibCondVO.setPmib(inbondVos.get(j).getIbdTrspNo());
							lclMibCondVO.setPod(vo.getPodCd());
							lclMibCondVO.setBlNo(inbondVos.get(j).getBlNo());

							// Partial 여부 검사
							lclMibFlag = dbDao.searchLclMibFlag(lclMibCondVO);
							inbondVos.get(j).setLclFlg(lclMibFlag);
						}

						// 하단 시트 상세 리스트 중, Local B/L 리스트 조회.
						vo.setInbondLocal("L");

						List<UsaInbondManifestDetailListVO> localVos = dbDao.searchInbondManifestDeatilList(vo);

						// 하단 시트 상세 리스트 중, Local B/L 리스트의 partial 여부 셋업.
						lclMibFlag = "N";
						for (int j = 0; j < inbondVos.size(); j++) {

							// Partial 여부 검사 를 위한 조건 셋업.
							lclMibCondVO.setDel(vo.getDelCd());
							lclMibCondVO.setVvd(vo.getVvd());
							lclMibCondVO.setHub(vo.getHubLocCd());
							lclMibCondVO.setPmib(inbondVos.get(j).getIbdTrspNo());
							lclMibCondVO.setPod(vo.getPodCd());
							lclMibCondVO.setBlNo(inbondVos.get(j).getBlNo());

							// Partial 여부 검사
							lclMibFlag = dbDao.searchLclMibFlag(lclMibCondVO);
							inbondVos.get(j).setLclFlg(lclMibFlag);
						}
						usaContainerVO.setLocalBlDetailListVOs(localVos);
					}
					usaContainerVO.setInbondBlDetailListVOs(inbondVos);
				}
				inbondMibListDetailVOs.add((InbondMibListDetailVO) usaContainerVO);
			}
			return  inbondMibListDetailVOs;
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}

	}


	/**
	 * USA HI(Arrival, Export) FLAT FILE 생성 및 전송<br>
	 *
	 * @param MibTransmitVO[] mibTransmitVO
	 * @return String
	 * @exception EventException
	 */
	public String transmitMIB(MibTransmitVO[] mibTransmitVO) throws EventException{
		try {

			StringBuffer flatFile = new StringBuffer();
			BookingUtil command2 = new BookingUtil();

			// ManifestListDownloadBC 책임테이블 사용을 위해
			UsaManifestListDownloadBCImpl mfDownloadBC = new UsaManifestListDownloadBCImpl();

			// CustomsTransmissionBC 책임테이블 사용을 위해
			UsaCustomsTransmissionBCImpl mfTransmissionBC = new UsaCustomsTransmissionBCImpl();

			FlatFileAckVO flatFileAckVO = null;
			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZ2COM_AMS.IBMMQ.QUEUE"));

			int len = mibTransmitVO.length;
			UsaMibTransmitVO vo = null;
			if(len > 0) {
				vo = (UsaMibTransmitVO)mibTransmitVO[0];
			}else{
				//throw new EventException(new ErrorHandler("BKG00099", new String[] {"There is no trans data"}).getMessage());
				throw new EventException(new ErrorHandler("BKG01051").getUserMessage());
			}
			String usrId = vo.getUsrId();
			String ofcCd = vo.getOfcCd();
			String vvd = vo.getVvd();
			String divInd = vo.getDivInd();
			String podLoc = "";
			if("DIV".equals(divInd)) {
				podLoc = vo.getPodCd();
			} else {
				podLoc = vo.getCstmsPodCd();
			}
			String transGubun = vo.getTransGubun();
			UsaMiCountVO checkMiCondVO = new UsaMiCountVO();
			checkMiCondVO.setVvd(vvd);
			checkMiCondVO.setPod(podLoc);
			checkMiCondVO.setPol(null);
			checkMiCondVO.setTrsmTp("MI");
			int miSndCount = dbDao.checkMiTransCount(checkMiCondVO);

			if(miSndCount == 0){
				//throw new EventException(new ErrorHandler("BKG00099", new String[] {"You must transmit MI file first."}).getMessage());
				log.error(new ErrorHandler("BKG01055").getUserMessage());
				throw new EventException(new ErrorHandler("BKG01055").getUserMessage());
			}
			String lsDate = dbDao.searchSysdate("ddmmrrhh24miss");

			//[USACUSKEWB0029EUSTIWNGOBS AUTO_HI   1018020090419040121HI
			UsaTrsmFirstHeadVO firstHeadVO = new UsaTrsmFirstHeadVO();
			firstHeadVO.setVvd(vvd);
			firstHeadVO.setPodCd(podLoc);
			firstHeadVO.setOfcCd(ofcCd);
			firstHeadVO.setUsrId(usrId);
			firstHeadVO.setLsDate(lsDate);
			firstHeadVO.setFormat("ddmmrrhh24miss");
			firstHeadVO.setTrspMsgTpCd("HI");
//			String tmpstr1 = dbDao.searchTrsmFirstHeader(firstHeadVO);

			//Vsl_cd가 등록된 국가코드,영문이름 정보를 조회한다.
			MdmVslCntrVO mdmVslCntrVO = dbDao.searchVslInfo(vvd);
			if(mdmVslCntrVO == null || mdmVslCntrVO.getVslCd() == null){
				//Vessel Info. Data Not Found
				log.error(new ErrorHandler("BKG01052").getUserMessage());
				throw new EventException(new ErrorHandler("BKG01052").getUserMessage());
			}

			String vslFlag = mdmVslCntrVO.getVslRgstCntCd();
			String vslEngNm = mdmVslCntrVO.getVslEngNm();
			String vslLloyd = mdmVslCntrVO.getLloydNo();
			if(vslLloyd == null
					|| vslLloyd.equals("9124524")
					|| vslLloyd.equals("8918945")
					|| vslLloyd.equals("9183489"))
			{
				vslLloyd = "       ";
			}

			/*
			 * 20100422 경종윤
			 * podLoc이 "US"가 아니면 CSTMS_PORT_CD로 ams code를  조회한다.
			 * 아니면 원래 podLoc으로 ams Code를 조회한다.
			 */
			String tmpstr4 = "";
			String cstmsPortCd = "";
			if(!podLoc.startsWith("US")) {
				tmpstr4 = dbDao.searchPodAmsCode(dbDao.searchCstmsPortCd(vvd, "", podLoc));
				cstmsPortCd = dbDao.searchCstmsPortCd(vvd, "", podLoc);
			} else {
				tmpstr4 = dbDao.searchPodAmsCode(podLoc);
				cstmsPortCd = podLoc;
			}

			String sCstmsPortCd = dbDao.searchCstmsPortCd2(vvd, "", podLoc);
			if(!(sCstmsPortCd == null || sCstmsPortCd.length() == 0)){
				tmpstr4 = sCstmsPortCd;
			}

			if(tmpstr4 == null || tmpstr4.equals("")){
				//Location AMS code Data Not Found.
				log.error(new ErrorHandler("BKG01056").getUserMessage());
				throw new EventException(new ErrorHandler("BKG01056").getUserMessage());
			}

			EtaCondAtAdvancedVO etaCondAtAdvancedVO = new EtaCondAtAdvancedVO();
			etaCondAtAdvancedVO.setVvd(vvd);
			etaCondAtAdvancedVO.setPod(podLoc);

			EtaDetailAtAdvancedVO etaDetailAtAdvancedVO = dbDao.searchEtaFromAdvanced(etaCondAtAdvancedVO);
			String vpsEtaDt = etaDetailAtAdvancedVO.getEta();

			String blCntrFlag = vo.getBlCntrFlag();
			String blNo = "";
			String cntrNo = "";
			int blCnt = 0;
//			int lineCnt = 0;
//			int usBlChk = 0;
			String tmpstr6 = "";				// 추가ACE
			String tmpstr7 = "";
			String arrOrExpDate = "";
			String arrOrExpTime = "";
			String itType = "";
			String hub = "";
			String lastUsa = "";
			StringBuffer hiFile01 = new StringBuffer();
			String flag1 = "";
			String flag2 = "";


			if(transGubun.equals("Arr")){
				// Transmit Arrival
				flag1 = "2";
				flag2 = "3";
			}else{
				// Transmit Export
				flag1 = "6";
				flag2 = "7";
			}

			StringBuffer sbBlParams = new StringBuffer();
//			String blParams = "";

			// crr_bat_no를 구한다.
			String crrBatNo = ConstantMgr.getScacCode() + vvd + podLoc + dbDao.searchCarrierBatchNo();

			for(int i = 0; i < len ; i++){
				vo = (UsaMibTransmitVO)mibTransmitVO[i];
				blNo = vo.getBlNo();

				// to_clob
				if(i == 0){
					sbBlParams.append("to_clob('");
				}else if(i % 270 == 1 && i != 1){
					sbBlParams.append("||to_clob('");
				}

				sbBlParams.append(vo.getBlNo());

				if (i != len - 1){
					sbBlParams.append(",");
				}
				if((i != 0 && i % 270 == 0)|| i == len - 1){
					sbBlParams.append("')");
				}
				// END to_clob

				// 533-01.B/L Arrival전송(Flag:'B')
				if(blCntrFlag.equals("B")){
					cntrNo = "";
				// 533.Cntr Arrival전송(Flag:'C')
				}else{
					cntrNo = vo.getCntrNo();
				}
				//US인지 확인
//				if(dbDao.searchUsBlCnt(blNo) > 0){
//					usBlChk++;
//				}
				tmpstr7 = "";

				if(transGubun.equals("Exp")){
					arrOrExpDate = vo.getXptDt();
					arrOrExpTime = vo.getXptTime();
				} else {
					arrOrExpDate = vo.getArrDt();
					arrOrExpTime = vo.getArrTime();
				}
				itType = vo.getIbdTpCd();
				hub = vo.getHubLocCd();
				lastUsa = vo.getUsaLstLocCd();
				// 533-01.B/L Arrival/Export전송(Flag:'B')
				//DECODE(@[ibd_tp_cd],'61',@[hub],@[lst_usa])
				String pLocCd = "";
				if("61".equals(itType)){
					pLocCd = hub;
				}else{
					pLocCd = lastUsa;
				}
				if(blCntrFlag.equals("B")){
					tmpstr7 = dbAceInbondDao.searchH01ForBl(blNo, arrOrExpDate, pLocCd, flag1, arrOrExpTime);
				// 533.Cntr Arrival/Export전송(Flag:'C')
				}else{
					tmpstr7 = dbAceInbondDao.searchH01ForCntr(blNo, arrOrExpDate, pLocCd, cntrNo, flag2, arrOrExpTime, vo.getIbdTrspNo());
				}
				// ESM_BKG_0034 DVI버튼 클릭시
				if("DIV".equals(divInd)) {
					BkgCstmsCdConvCtntVO cstmsCdConvvo = new BkgCstmsCdConvCtntVO();
					cstmsCdConvvo.setCntCd("US");
					cstmsCdConvvo.setCstmsDivId("AMS_IRS_NO");
					cstmsCdConvvo.setCstmsDivIdSeq("1");
					List<BkgCstmsCdConvCtntVO> irslist = command2.searchCstmsCdConv(cstmsCdConvvo);
					String irsNo = irslist.size() > 0 ? irslist.get(0).getAttrCtnt1() : "";
					tmpstr7 = dbDao.searchH01ForDiversion(blNo, irsNo);
				}

				blCnt++ ;
//				lineCnt++;
				hiFile01.append(tmpstr7);
				// 533-01.B/L Arrival전송(Flag:'B')
				if(blCntrFlag.equals("B")){
					mfDownloadBC.modifyInbondArrFlagByBl(blNo, transGubun);
				}
				mfDownloadBC.updateCntrArrExpByBlCntr(blNo, cntrNo, transGubun, arrOrExpDate, arrOrExpTime);
			}
			UsaArrHeaderCondVO usaArrHeaderCondVO = new UsaArrHeaderCondVO();
			usaArrHeaderCondVO.setVvd(vvd);
			usaArrHeaderCondVO.setVslFlag(vslFlag);
			usaArrHeaderCondVO.setVslEngNm(vslEngNm);
			usaArrHeaderCondVO.setBlCnt(Integer.toString(blCnt));
			usaArrHeaderCondVO.setVslLloyd(vslLloyd);
			usaArrHeaderCondVO.setTmpstr4(tmpstr4);
			usaArrHeaderCondVO.setVpsEtaDt(vpsEtaDt);
			usaArrHeaderCondVO.setCrrBatNo(crrBatNo);

			tmpstr6 = "";
			tmpstr6 = dbAceInbondDao.searchArrHeader(usaArrHeaderCondVO);

			/*
			 * 20100402 경종윤
			 * "ZCRHJSC" 뒤 라인갯수 5자리 제거
			tmpBuf = new StringBuffer(Integer.toString(lineCnt + 3));
			for(idx = tmpBuf.length(); idx < 5; idx++){
				tmpBuf.insert(0, "0");
			}
			String tmpstr8 = new StringBuffer("ZCRHJSC").append(tmpBuf.toString()).toString();
			*/
			StringTokenizer tokenCnt = new StringTokenizer(tmpstr6 + hiFile01.toString(), "\n");
			int msgCnt = tokenCnt.countTokens() + 1;
			String tmpstr8 = "ZCR"+ ConstantMgr.getScacCode()
					+ getDigitBlank("", 6, " ", "R")
					+ "HI"
					+ getDigitBlank("", 19, " ", "R")
					+ getDigitBlank("" + msgCnt, 5, "0", "L")
					+ getDigitBlank("", 41, " ", "R");
			/*
			 * 20100402 경종윤
			 * 불필요한 공백 자리수 채우기 로직 제거
			tmpBuf = new StringBuffer(tmpstr8);
			for(idx = tmpBuf.length(); idx < 80; idx++){
				tmpBuf.append(" ");
			}
			tmpstr8 = tmpBuf.toString();

			tmpBuf = new StringBuffer("/*");
			for(idx = tmpBuf.length(); idx < 80; idx++){
				tmpBuf.append(" ");
			}

			tmpstr8 = new StringBuffer(tmpstr8)
						.append("\n")
						.append(tmpBuf.toString()).toString();
			*/
//            flatFile.append(tmpstr1)
			if (transGubun.equals("Exp")) {
				flatFile.append(command2.searchCstmsEdiHeaderNew("US_CTRREEXP")).append("\n");
			} else {
				flatFile.append(command2.searchCstmsEdiHeaderNew("US_CNTRLIST")).append("\n");
			}
			flatFile.append(tmpstr6);
			flatFile.append(hiFile01.toString());
			flatFile.append(tmpstr8);

			sendFlatFileVO.setFlatFile(flatFile.toString().toUpperCase());

			flatFileAckVO = command2.sendFlatFile(sendFlatFileVO);

			if ( flatFileAckVO.getAckStsCd().equals("E") ) {
				log.error(new ErrorHandler("BKG00205",new String[]{}).getMessage());
				throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
			}

			/*********************************************
			// Log Add Start.
			*********************************************/
			//String crrBatNo = "HJSC" + vvd + podLoc + dbDao.searchCarrierBatchNo();

			SendingLogVO sndLogVo = new SendingLogVO();
			sndLogVo.setCntCd("US");
			sndLogVo.setIoBndCd("I");
			sndLogVo.setSndDt(lsDate);
			sndLogVo.setHisSeq(dbDao.searchSndLogNextHisSeq("US", "I", lsDate, "HI"));
			sndLogVo.setTrsmMsgTpId("HI");
			sndLogVo.setVvd(vvd);
			sndLogVo.setPolCd("");
			sndLogVo.setPodCd(podLoc);
			sndLogVo.setVslDepRptFlg("N");
			sndLogVo.setAutoVslDepRptFlg("N");
			sndLogVo.setSndUsrId(usrId);
			sndLogVo.setSndUsrOfcCd(ofcCd);
			sndLogVo.setAckTpNo("");
			sndLogVo.setCreUsrId(usrId);
			sndLogVo.setUpdUsrId(usrId);
			sndLogVo.setCrrBatNo(crrBatNo);
			sndLogVo.setCstmsPortCd(cstmsPortCd);

			//INBOND_SLOGP table에 전송 결과 입력
			//dbDao.addSendLog(sndLogVo);
			mfTransmissionBC.addSendLog(sndLogVo);

			//INBOND_SLOG_DETAIL table에 전송 결과 입력
			sndLogVo.setDtlSeq("1");
			//이전 소스는 전송내용을 한번에 로그테이블에 입력했으나, 라인단위로 입력하는 것으로 수정.
			//sndLogVo.setEdiSndLogCtnt(hiFile02.toString());
			//dbDao.addSendLogDetail(sndLogVo);
			StringTokenizer token = new StringTokenizer(flatFile.toString().toUpperCase(), "\n");
			int i = 1;
			String tmpStr = "";
			while (token.hasMoreTokens()) {
				tmpStr = token.nextToken();
				sndLogVo.setDtlSeq(i + "");
				sndLogVo.setEdiSndLogCtnt(tmpStr);

				//dbDao.addSendLogDetail(sndLogVo);
				mfTransmissionBC.addSendLogDetail(sndLogVo);
				i++;
			}
			sndLogVo.setBlParams(sbBlParams.toString());
			mfTransmissionBC.addCarrierBatchNo(sndLogVo);

			/*********************************************
			// Log Add End.
			*********************************************/
			return flatFile.toString();

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * USA Inbound화주의 Customs Clearance Type을 조회 <br>
	 *
	 * @param InbondManifestListCondVO inbondManifestListCondVO
	 * @return List<InbondManifestDetailVO>
	 * @exception EventException
	 */
	public List<InbondManifestDetailVO> searchInbondClearanceList( InbondManifestListCondVO inbondManifestListCondVO ) throws EventException{
		try {
			return dbDao.searchClearanceTypebySc ( (ClearanceTypeCondVO)inbondManifestListCondVO );
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage());
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage());
		}
	}

	/**
	 * USA Inbound화주의 Customs Clearance Type을 등록 및 수정<br>
	 *
	 * @param InbondManifestDetailVO[] inbondManifestDetailVO
	 * @param SignOnUserAccount account
	 * @return int
	 * @exception EventException
	 */
	public int modifyManifestList(InbondManifestDetailVO[] inbondManifestDetailVO, SignOnUserAccount account) throws EventException{
		ClearanceTypeDetailVO detailVO = null;
		int result = 0;

		try {
			for(int i=0; i<inbondManifestDetailVO.length; i++){
				detailVO = (ClearanceTypeDetailVO)inbondManifestDetailVO[i];
				detailVO.setCreUsrId(account.getUsr_id());
				detailVO.setUpdUsrId(account.getUsr_id());

				if("".equals(detailVO.getClrTpSeq()) && "Y".equals(detailVO.getDeltFlg())) continue;

				if (!"".equals(detailVO.getHubLocCd()))
				{
					BookingUtil util = new BookingUtil();
					if ("".equals(util.searchMdmLocName(detailVO.getHubLocCd())))
					{
						throw new EventException(new ErrorHandler("BKG00651", new String[] { "HUB ["
								+ detailVO.getHubLocCd() + "]" }).getMessage());
					}
				}
				result = result + dbDao.modifyClearanceTypebySc( detailVO );
			}
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087",new String[]{}).getMessage(), ex);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06087",new String[]{}).getMessage(), ex);
		}
		return result;
	}

	/**
	 * Mdm Commodity Name 조회<br>
	 *
	 * @param String cmdtCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCommodity(String cmdtCd) throws EventException{
		String result = null;
		try {
			result = dbDao.searchCommodity(cmdtCd);
			if(result == null){
				throw new EventException(new ErrorHandler("BKG06031", new String[]{}).getMessage());
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
		return result;
	}

	/**
	 * BackEndJob을 실행.
	 *
	 * @param String usrId
	 * @param MibTransmitVO[] mibTransmitVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 *
	 */
	public String startBackEndJob(String usrId,
			MibTransmitVO[] mibTransmitVO, String pgmNo)  throws EventException{
		String resultStr = null;
		try{
			UsaInbondTransmissionBackEndJob backEndJob = new UsaInbondTransmissionBackEndJob ();
			backEndJob.setPgmNo(pgmNo);
			resultStr = "";
			if(pgmNo.equals("ESM_BKG_0533")){
				backEndJob.setMibTransmitVO(mibTransmitVO);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				resultStr = backEndJobManager.execute(backEndJob , usrId, "USA Inbond Arrival Manifest");
			}
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler(e).getMessage());
		}
		return resultStr;
	}

	/**
	 * hub수정권한을 조회한다.<br>
	 *
	 * @param String usrId
	 * @return String
	 * @exception EventException
	 */
	public String[] searchUserAuthInfoForHub(String usrId) throws EventException{
		String[] result = new String[2];
		try {
			result = dbDao.searchUserAuthInfoForHub(usrId);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
		return result;
	}

	/**
	 *
	 * @param value
	 * @param digitCnt
	 * @param digit
	 * @param leftRight
	 * @return
	 */
	private String getDigitBlank(String value, int digitCnt, String digit, String leftRight) {
		StringBuffer sbBlank = new StringBuffer();
		if (value.length() >= digitCnt) return value;
		if ("R".equals(leftRight)) sbBlank.append(value);

		for (int i=0; i<digitCnt - value.length(); i++) sbBlank.append(digit);

		if ("L".equals(leftRight)) sbBlank.append(value);

		return sbBlank.toString();
	}

	/**
	 * SC No. 조회<br>
	 *
	 * @param String inScNo
	 * @return String
	 * @exception EventException
	 */
	public String searchScNo(String inScNo) throws EventException {
		try {
			 return dbDao.searchScNo(inScNo);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
	}

}
