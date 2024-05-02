/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : JapanTerminalTransmissionBCImpl.java
 *@FileTitle : JapanTerminalTransmissionBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration.JapanTerminalTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgJapanTerminalEdiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgTerminalEdiDgCgoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgTerminalEdiJapanAwkCgoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgTerminalEdiJapanBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgTerminalEdiJapanCntrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgTerminalEdiJapanDgCgoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgTerminalEdiJapanRfCgoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.JapanTerminalEdiCheckRsltVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.JapanTerminalEdiCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.JapanTerminalEdiGroupVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.VvdJapanTerminalEdiVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCstmsJpRcvLogVO;
import com.clt.syscommon.common.table.BkgCstmsJpSndLogVO;


/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim Seung Min
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class JapanTerminalTransmissionBCImpl extends BasicCommandSupport implements JapanTerminalTransmissionBC {

	// Database Access Object
	private transient JapanTerminalTransmissionDBDAO dbDao = null;

	/**
	 * JapanTerminalTransmissionBCImpl 객체 생성<br>
	 * JapanCustomsTransmissionDAO를 생성한다.<br>
	 */
	public JapanTerminalTransmissionBCImpl() {
		dbDao = new JapanTerminalTransmissionDBDAO();

	}

	/**
	 * 전송 이벤트 처리<br>
	 * 일본세관 수신 처리.<br>
	 *
	 * @param String flatFile
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	@SuppressWarnings( { "unchecked", "rawtypes" })
	public void receiveJapanTerminalOpusBkgNaccs(String flatFile, SignOnUserAccount account) throws EventException {
		BkgCstmsJpRcvLogVO bkgCstmsJpRcvLogVO = new BkgCstmsJpRcvLogVO();

//BKC-REPLY
		try {
			log.error("====== EDI 수신(SEANACCS) start==");
			log.error(flatFile);
			log.error("====== EDI 수신(SEANACCS) end====");

			StringTokenizer token = new StringTokenizer(flatFile, "\n");
			ArrayList tmpArray = new ArrayList();
			while(token.hasMoreTokens()) tmpArray.add(token.nextToken());

			String rcvDt = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String rcvKeyDatCtnt = "";
			String rcvKeyDatCtnt2 = "";
			String rcvKeyDatCtnt3 = "";
			String rcvKeyDatCtnt4 = "";

			int seqNumber = 0;
			for (int j=0; j<tmpArray.size(); j++) {
				if (j == 0) {
					String data = tmpArray.get(j).toString();
					//bkgCstmsJpRcvLogVO.setCreUsrId(data.substring(12, 32).trim());
					bkgCstmsJpRcvLogVO.setRcvDt(rcvDt);
					bkgCstmsJpRcvLogVO.setJpSvcId(data.substring(52, 62).trim());

					log.debug("== EDI 수신 ="+data.substring(62, 82).trim());

					String[] jpBatNo = data.substring(62, 82).trim().split(":");
					for (int x=1; x<jpBatNo.length; x++) bkgCstmsJpRcvLogVO.setJpBatNo(jpBatNo[x].trim());
					//bkgCstmsJpRcvLogVO.setJpBatNo(data.substring(67, 82).trim());
					log.debug("== EDI 수신(SEANACCS) ===="+data);

				} else if (j == 2) {
					String data = tmpArray.get(j).toString();
					String[] rcvMsgS1 = data.split(":");
					for(int x=1; x<rcvMsgS1.length; x++) {
						bkgCstmsJpRcvLogVO.setJpMsgTpId(rcvMsgS1[x].trim());
						seqNumber = dbDao.searchReceiveLogSeq(bkgCstmsJpRcvLogVO.getJpMsgTpId(), rcvDt);
						bkgCstmsJpRcvLogVO.setRcvSeq(seqNumber + "");
					}

				} else if (j == 3) { //User ID
					String data = tmpArray.get(j).toString();
					String[] rcvMsgS5 = data.split(":");
					for(int x=1; x<rcvMsgS5.length; x++) bkgCstmsJpRcvLogVO.setCreUsrId(rcvMsgS5[x].trim());

				} else if (j == 4) {
					String data = tmpArray.get(j).toString();
					String[] rcvMsgS2 = data.split(":");
					for(int x=1; x<rcvMsgS2.length; x++) rcvKeyDatCtnt2 = rcvMsgS2[x].trim();

				} else if (j == 5) {
					String data = tmpArray.get(j).toString();
					String[] rcvMsgS3 = data.split(":");
					for(int y=1; y<rcvMsgS3.length; y++) rcvKeyDatCtnt3 = rcvMsgS3[y].trim();

				} else if (j == 6) {
					String data = tmpArray.get(j).toString();
					String[] rcvMsgS4 = data.split(":");
					for(int z=1; z<rcvMsgS4.length; z++) rcvKeyDatCtnt4 = rcvMsgS4[z].trim();
					bkgCstmsJpRcvLogVO.setBkgNo(rcvKeyDatCtnt4);
					rcvKeyDatCtnt = (rcvKeyDatCtnt2 + " " + rcvKeyDatCtnt3 + rcvKeyDatCtnt4);
					bkgCstmsJpRcvLogVO.setRcvKeyDatCtnt(rcvKeyDatCtnt);
					bkgCstmsJpRcvLogVO.setEdiRcvMsgCtnt(rcvKeyDatCtnt);
				}
			}

			//JP_SVC_CD 이 BKGACK 또는 SAT076 일때만 저장
			if ("BKR210".equals(bkgCstmsJpRcvLogVO.getJpSvcId()) || "SAT076".equals(bkgCstmsJpRcvLogVO.getJpSvcId())) {
				dbDao.addReceiveLog(bkgCstmsJpRcvLogVO);
			}

		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Japan Terminal EDI 세관신고 위해 FlatFile을 생성한다.
	 *
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @param JapanTerminalEdiGroupVO japanTerminalEdiGroupVO
	 * @param SignOnUserAccount account
	 * @param int logSeq
	 * @return String
	 * @throws EventException
	 */
	public String sendTerminalEdi(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO, JapanTerminalEdiGroupVO japanTerminalEdiGroupVO, SignOnUserAccount account, int logSeq) throws EventException {

		BookingUtil bookingUtil = new BookingUtil();
		// FLATFILE
		String flatFileHeader = "";
		StringBuffer flatFile = new StringBuffer();
		StringBuffer realFlatFile = new StringBuffer(); //전송 이력 Detail

		// Container 정보
		BkgTerminalEdiJapanCntrVO cntrVO = null;
		BkgTerminalEdiJapanBlVO blVO = new BkgTerminalEdiJapanBlVO();
		//Unused Local Variable
		BkgTerminalEdiJapanRfCgoVO rfVO = new BkgTerminalEdiJapanRfCgoVO();
		BkgTerminalEdiJapanAwkCgoVO awkVO = new BkgTerminalEdiJapanAwkCgoVO();
		BkgTerminalEdiJapanDgCgoVO dgVO = new BkgTerminalEdiJapanDgCgoVO();
		List<BkgTerminalEdiDgCgoVO> dgMainList = new ArrayList<BkgTerminalEdiDgCgoVO>();;
		List<BkgTerminalEdiDgCgoVO> dgDetailList = new ArrayList<BkgTerminalEdiDgCgoVO>();;
		List<BkgTerminalEdiJapanCntrVO> bkgTerminalEdiJapanCntrList = new ArrayList<BkgTerminalEdiJapanCntrVO>();
		//VvdJapanTerminalEdiVO vvdJpTmlEdiVO = new VvdJapanTerminalEdiVO();

		String cgoFlg = "";
		String rdCgoFlg = "";
		String dCgoFlg = "";
		String awkCgoFlg = "";

		// -- For문 Index -- //
		int cntrIdx = 0;

		try {
			// 2=Reefer, 3=Dangerous, 0=Awkward / 1=General
			rdCgoFlg = bkgTerminalEdiJapanBlVO.getRdCgoFlg();	// 2
			dCgoFlg = bkgTerminalEdiJapanBlVO.getDcgoFlg();		// 3
			awkCgoFlg = bkgTerminalEdiJapanBlVO.getAwkCgoFlg();	// 0
			if ("Y".equals(rdCgoFlg)) {				// 2
				if ("Y".equals(dCgoFlg)) {			// 2 || 3
					cgoFlg = "23";
				} else {
					if ("Y".equals(awkCgoFlg)) {	// 2 || 0
						cgoFlg = "20";
					} else {
						cgoFlg = "2";
					}
				}
			} else {
				if ("Y".equals(dCgoFlg)) {			// 3
					if ("Y".equals(awkCgoFlg)) {	// 3 || 0
						cgoFlg = "30";
						} else {
						cgoFlg = "3";
					}
				} else {
					if ("Y".equals(awkCgoFlg)) {	// 0
						cgoFlg = "0";
					} else {
						cgoFlg = "1";
					}
				}
			}

			// Body 생성
			log.debug("========================= flat file");

			// Header 생성
			flatFileHeader = bookingUtil.searchCstmsEdiHeaderNew("JP_IFTMBC");
			flatFile.append(flatFileHeader).append("\n");

			flatFile.append("{HEADER").append("\n");
			flatFile.append("CTRL_CD:").append("   ").append("\n");
			if ("R".equals(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCd())) {
				flatFile.append("MSG_CD:").append("BKR  ").append("\n");
			} else {
				flatFile.append("MSG_CD:").append("BKC  ").append("\n");
			}
			flatFile.append("USER_CD:").append("     ").append("\n"); //공백 확인
			flatFile.append("USER_NB:").append("Z26").append("\n");
			flatFile.append("USER_PW:").append("3LQ2NZYK").append("\n");
			flatFile.append("DATA_INFO:").append("                          ").append("\n");
			flatFile.append("USER_ID:").append(account.getUsr_id().replace("_", "").toUpperCase()).append("\n");
			flatFile.append("SRCH_KEY:").append("                                                                                                   ").append("\n");
			flatFile.append("NACCS_CD:").append("2").append("\n");
			flatFile.append("}HEADER").append("\n");

			flatFile.append("{MAIN").append("\n");//추가 넣음
			//BkgJapanTerminalEdiVO
//			if ("Y".equals(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCngFlg())) {//SnaccsTmlEdiStsCngFlg가 Y 인 경우는 JP_BL 의 STS 우선으로 전송 전송이후에는 N으로 resolve 2012.04.17   [CHM-201216534-01]  조원주
				flatFile.append("BRAC:").append(dbDao.searchEdiStsCode(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCd())).append("\n");
//			} else {
//				flatFile.append("BRAC:").append(dbDao.searchEdiStsCode(bkgJpTmlEdiVO.getSnaccsTmlEdiStsCngFlg())).append("\n");
//			}
			flatFile.append("SCAC_CD:").append(ConstantMgr.getScacCode()).append("\n");

			flatFile.append("BKGNBR:").append(bkgTerminalEdiJapanBlVO.getBkgNo()).append("\n");

			flatFile.append("VSL_CALL_SIGN:").append(bkgTerminalEdiJapanBlVO.getCallSgnNo().length() > 0?bkgTerminalEdiJapanBlVO.getCallSgnNo().substring(0, bkgTerminalEdiJapanBlVO.getCallSgnNo().length()).toUpperCase() :"").append("\n");

			if (bkgTerminalEdiJapanBlVO.getCallSgnNo().length() > 0) { //MIG 5번 적재예정선박코드CallSign 이 있을 경우 6번은 공란으로 전송
				flatFile.append("VSLNAME:").append("").append("\n");

			} else {
				flatFile.append("VSLNAME:").append(bkgTerminalEdiJapanBlVO.getVslEngNm().length() > 0?bkgTerminalEdiJapanBlVO.getVslEngNm().substring(0, bkgTerminalEdiJapanBlVO.getVslEngNm().length()).toUpperCase() :"").append("\n");

			}
			flatFile.append("VVD:").append(bkgTerminalEdiJapanBlVO.getJpTmlVslNo()).append("\n");//.append(bkgTerminalEdiJapanBlVO.getVslCd() +bkgTerminalEdiJapanBlVO.getSkdVoyNo() +bkgTerminalEdiJapanBlVO.getSkdDirCd()).append("\n");//확인
			flatFile.append("CONSORT_VOY:").append(bkgTerminalEdiJapanBlVO.getJpTmlVslNo()).append("\n");

			flatFile.append("BKG_DT:").append(bkgTerminalEdiJapanBlVO.getBkgCreDt().length() > 0 ? bkgTerminalEdiJapanBlVO.getBkgCreDtYmd() : "").append("\n");
			flatFile.append("POL_UNLC:").append(dbDao.getUnLocCd(bkgTerminalEdiJapanBlVO.getPolCd())).append("\n");

			flatFile.append("POL_YDCD:").append(dbDao.searchCYCode(bkgTerminalEdiJapanBlVO.getPolYdCd())).append("\n");//SELECT INTG_CD_VAL_DP_DESC ?
			flatFile.append("POR_UNLC:").append(dbDao.getUnLocCd(bkgTerminalEdiJapanBlVO.getPorCd())).append("\n");
			flatFile.append("POR_YDCD:").append(dbDao.searchCYCode(bkgTerminalEdiJapanBlVO.getPorYdCd())).append("\n");//SELECT INTG_CD_VAL_DP_DESC ?

			flatFile.append("OTHR_NTFY:").append(dbDao.searchCYCode(JSPUtil.getNull(bkgTerminalEdiJapanBlVO.getOtrNtfyYdCd()))).append("\n"); //SELECT INTG_CD_VAL_DP_DESC ?

			flatFile.append("POL_ETD:").append(JSPUtil.getNull(bkgTerminalEdiJapanBlVO.getEtdDt()).length() > 0?bkgTerminalEdiJapanBlVO.getEtdDtYmd() : " ").append("\n");//TO_CHAR(ETD_DT, 'YYYYMMDD')
			flatFile.append("POD_UNLC:").append(dbDao.getUnLocCd(dbDao.searchPrePod(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanBlVO.getVslCd(), bkgTerminalEdiJapanBlVO.getSkdVoyNo(), bkgTerminalEdiJapanBlVO.getSkdDirCd()))).append("\n");//고쳐야함
			flatFile.append("POD_YDCD:").append(dbDao.searchCYCode(bkgTerminalEdiJapanBlVO.getPodYdCd())).append("\n");//SELECT INTG_CD_VAL_DP_DESC ?
			flatFile.append("POD_UNLC2:").append("").append("\n");
			flatFile.append("POD_YDCD2:").append("").append("\n");
			flatFile.append("DEL_UNLC:").append(dbDao.getUnLocCd(bkgTerminalEdiJapanBlVO.getFnlDestCd())).append("\n");//DEL_CD or LOCATION.LOC_DESC?
			flatFile.append("DEL_NAME:").append(bkgTerminalEdiJapanBlVO.getFnlDestNm().length() > 0?bkgTerminalEdiJapanBlVO.getFnlDestNm().substring(0, bkgTerminalEdiJapanBlVO.getFnlDestNm().length()).toUpperCase() :"").append("\n");//????

//			flatFile.append("EQREL_YDCD:").append(bkgTerminalEdiJapanBlVO.getMtyPYd().length() > 0?bkgTerminalEdiJapanBlVO.getMtyPYd().substring(0, bkgTerminalEdiJapanBlVO.getMtyPYd().length()).toUpperCase() :"").append("\n");    // MT PICK UP LOACTION CODE
//			flatFile.append("EQREL_YDCD_NAME:").append(bkgTerminalEdiJapanBlVO.getMtyPYdNm().length() > 0?bkgTerminalEdiJapanBlVO.getMtyPYdNm().substring(0, bkgTerminalEdiJapanBlVO.getMtyPYdNm().length()).toUpperCase() :"").append("\n");    // MT PICK UP LOACTION NAME
			flatFile.append("EQREL_YDCD:").append(bkgTerminalEdiJapanBlVO.getMtyPYd()).append("\n");    // MT PICK UP LOACTION CODE
			flatFile.append("EQREL_YDCD_NAME:").append(bkgTerminalEdiJapanBlVO.getMtyPYdNm()).append("\n");    // MT PICK UP LOACTION NAME

			flatFile.append("RCVTYP:").append(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiRcvTermCd()).append("\n");
			flatFile.append("DELTYP:").append(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiDeTermCd()).append("\n");
			flatFile.append("DEST_UNLC:").append(dbDao.getUnLocCd(bkgTerminalEdiJapanBlVO.getFnlDestCd())).append("\n");
			flatFile.append("DEST_UNLC_NAME:").append(bkgTerminalEdiJapanBlVO.getFnlDestNm().length() > 0 ? bkgTerminalEdiJapanBlVO.getFnlDestNm().toUpperCase() : "").append("\n");
			flatFile.append("TRSH_UNCD:").append(dbDao.getUnLocCd(dbDao.searchTrshUncd(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanBlVO.getPolCd(), bkgTerminalEdiJapanBlVO.getVslCd(), bkgTerminalEdiJapanBlVO.getSkdVoyNo(), bkgTerminalEdiJapanBlVO.getSkdDirCd()))).append("\n");    //고쳐야함

			flatFile.append("SH_CD1:").append(JSPUtil.getNull(bkgTerminalEdiJapanBlVO.getShprCustNm()).length() > 0 ? "" : bkgTerminalEdiJapanBlVO.getShprCntCd() + bkgTerminalEdiJapanBlVO.getShprCustSeq()).append("\n");

			flatFile.append("SHN1:").append(bkgTerminalEdiJapanBlVO.getShprCustNm().length() > 0 ? bkgTerminalEdiJapanBlVO.getShprCustNm().toUpperCase() : "").append("\n");
			flatFile.append("FF_CD1:").append(bkgTerminalEdiJapanBlVO.getFrtFwrdCntCd() + bkgTerminalEdiJapanBlVO.getFrtFwrdCustSeq()).append("\n");
			flatFile.append("FFN1:").append(bkgTerminalEdiJapanBlVO.getFrtFwrdCustNm().length() > 0?bkgTerminalEdiJapanBlVO.getFrtFwrdCustNm().toUpperCase() :"").append("\n");
			flatFile.append("CARGOTYPE:").append(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiCgoTpCd()).append("\n");
			//flatFile.append("CARGO_IND:").append(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiCgoKndCd()).append("\n");
			flatFile.append("CARGO_IND:").append(cgoFlg).append("\n");

			flatFile.append("PKG_CD:").append(bkgTerminalEdiJapanBlVO.getPckTpCd()).append("\n");
			flatFile.append("CMDD:").append(bkgTerminalEdiJapanBlVO.getCmdtNm().length() > 0 ? bkgTerminalEdiJapanBlVO.getCmdtNm().substring(0, bkgTerminalEdiJapanBlVO.getCmdtNm().length()).toUpperCase() : "").append("\n");
			flatFile.append("REMARK:").append(bkgTerminalEdiJapanBlVO.getXterRmk().length() > 0 ? bkgTerminalEdiJapanBlVO.getXterRmk().substring(0, bkgTerminalEdiJapanBlVO.getXterRmk().length()).toUpperCase() : "").append("\n");

			cntrVO =  dbDao.searchJapanCntrPKGInfo(bkgTerminalEdiJapanBlVO.getBkgNo());

			flatFile.append("PKG:").append(cntrVO.getPckQty()).append("\n");
			flatFile.append("PUNIT:").append(cntrVO.getPckTpCd()).append("\n");
			flatFile.append("WGT:").append(cntrVO.getCntrWgt()).append("\n");
			flatFile.append("WUNIT:").append(cntrVO.getWgtUtCd()).append("\n");
			flatFile.append("MEAS:").append(cntrVO.getMeasQty()).append("\n");
			flatFile.append("MUNIT:").append(cntrVO.getMeasUtCd()).append("\n");

			bkgTerminalEdiJapanCntrList =  dbDao.searchJapanCntrInfo(bkgTerminalEdiJapanBlVO.getBkgNo());
			for (cntrIdx = 0; cntrIdx < bkgTerminalEdiJapanCntrList.size(); cntrIdx++) {
				//(1) Container 정보
				flatFile.append("{CNTR_INFO").append("\n");
				flatFile.append("CNTR_SIZE:").append(bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().length() > 0 ? bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().substring(0, 2) : "").append("\n"); //
				//group tp code로 가져오기
				if (bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().length() > 0) {
					flatFile.append("CNTR_TYPE:").append(dbDao.searchIsoGroupTpCd(bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().substring(2, bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().length()))).append("\n");//.append(bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().length() > 0 ? bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().substring(2, bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().length()) : "").append("\n");
				} else {
					flatFile.append("CNTR_TYPE:").append("\n");
				}
				if ((cntrIdx) == 0) {
					flatFile.append("CNT:").append(bkgTerminalEdiJapanBlVO.getCntrVolQty1()).append("\n");
				} else if ((cntrIdx) == 1) {
					flatFile.append("CNT:").append(bkgTerminalEdiJapanBlVO.getCntrVolQty2()).append("\n");
				} else if ((cntrIdx) == 2) {
					flatFile.append("CNT:").append(bkgTerminalEdiJapanBlVO.getCntrVolQty3()).append("\n");
				} else if ((cntrIdx) == 3) {
					flatFile.append("CNT:").append(bkgTerminalEdiJapanBlVO.getCntrVolQty4()).append("\n");
				} else if ((cntrIdx) == 4) {
					flatFile.append("CNT:").append(bkgTerminalEdiJapanBlVO.getCntrVolQty5()).append("\n");
				}

				//flatFile.append("CNT:").append(JSPUtil.getNull(bkgTerminalEdiJapanCntrList.get(cntrIdx).getCount())).append("\n");// 확인

				//JapanTerminalTransmissionDBDAOsearchJapanStowageInfoRSQL
				blVO = dbDao.searchJapanCntrStowageInfo(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszCd());
				flatFile.append("PKUP_NAME:").append("").append("\n");
				flatFile.append("STWG_REQ:").append(JSPUtil.getNull(blVO.getSnaccsTmlEdiStwgCd())).append("\n");
				flatFile.append("STWG_REQ2:").append("").append("\n");
				flatFile.append("STWG_REMARK:").append(JSPUtil.getNull((blVO.getXterRmk()))).append("\n");
				flatFile.append("BLKSTWG:").append(JSPUtil.getNull(blVO.getBlckStwgCd())).append("\n");
				flatFile.append("RD_IND:").append(JSPUtil.getNull(blVO.getDryCgoFlg())).append("\n");
				flatFile.append("MT_IND:").append(JSPUtil.getNull("N".equals(blVO.getMcntrFlg()) ? "" : "1")).append("\n");
				flatFile.append("SOC_IND:").append(JSPUtil.getNull("N".equals(blVO.getSocFlg()) ? "" : "1")).append("\n");
				flatFile.append("RF_RRE:").append(blVO.getEqSubstFlg()).append("\n");
				flatFile.append("RF_REMARK:").append(JSPUtil.getNull(blVO.getRfRemark())).append("\n");

				//JapanTerminalTransmissionDBDAOsearchJapanRFCgoInfoRSQL
				rfVO = dbDao.searchJapanRFCgoInfo(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszCd());
				flatFile.append("TEMP_MAX:").append(JSPUtil.getNull(rfVO.getCdoTemp())).append("\n");
				flatFile.append("TEMP:").append(JSPUtil.getNull(rfVO.getCdoTemp())).append("\n");
				flatFile.append("TEMP_MIN:").append(JSPUtil.getNull(rfVO.getCdoTemp())).append("\n");
				flatFile.append("TEMP_UNIT:").append(JSPUtil.getNull(rfVO.getClngTpCd())).append("\n");
				flatFile.append("HUMID:").append(JSPUtil.getNull(rfVO.getHumidNo())).append("\n");
				flatFile.append("VENT:").append(JSPUtil.getNull(rfVO.getVentRto())).append("\n");
				flatFile.append("VENT_UNIT:").append(JSPUtil.getNull(rfVO.getVentUnit())).append("\n");

				//JapanTerminalTransmissionDBDAOsearchJapanAWKCgoInfoRSQL
				awkVO = dbDao.searchJapanAWKCgoInfo(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszCd());
				flatFile.append("OVH:").append(JSPUtil.getNull(awkVO.getOvrHgt())).append("\n");
				flatFile.append("OVLW:").append(JSPUtil.getNull(awkVO.getOvrLfLen())).append("\n");
				flatFile.append("OVRW:").append(JSPUtil.getNull(awkVO.getOvrRtLen())).append("\n");
				flatFile.append("OVFR:").append(JSPUtil.getNull(awkVO.getOvfr())).append("\n");//awkVO.getOvrFwrdLen() +awkVO.getOvrBkwdLen()
				flatFile.append("VOID_SLOT:").append(JSPUtil.getNull(awkVO.getOvrVoidSltQty())).append("\n");

				//JapanTerminalTransmissionDBDAOsearchJapanDGInfoRSQL.Query
				dgVO = dbDao.searchJapanDGCgoInfo(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszCd()); //cntr_tpsz_cd
				flatFile.append("MAR_POLL:").append(JSPUtil.getNull(dgVO.getMrnPolutFlg())).append("\n");
				flatFile.append("IMO_LIMIT:").append(JSPUtil.getNull(dgVO.getImdgLmtQtyFlg())).append("\n");

				//(2) Container Danger Main 정보
				dgMainList =  dbDao.searchJapanDangerMainInfo(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszCd());//cntr_tpsz_cd
				if (dgMainList.size() > 0) {
					for (BkgTerminalEdiDgCgoVO dgMainVO : dgMainList) {
						flatFile.append("{CNTR_DANGER_MAIN").append("\n");
						flatFile.append("CLAS:").append(dgMainVO.getImdgClssCd()).append("\n");
						//(3) Container Danger Detail 정보
						dgDetailList =  dbDao.searchJapanDangerDetailInfo(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszCd(), dgMainVO.getImdgClssCd()); //cntr_tpsz_cd, imdg_clss_cd
						if (dgDetailList.size() > 0) {
							for (BkgTerminalEdiDgCgoVO dgDetailVO : dgDetailList) {
									flatFile.append("{CNTR_DANGER_DETAIL").append("\n");
									flatFile.append("UNBR:").append(dgDetailVO.getImdgUnNo()).append("\n");
									flatFile.append("PKGGRP:").append(dgDetailVO.getImdgPckGrpCd()).append("\n");
									flatFile.append("}CNTR_DANGER_DETAIL").append("\n");
							}
						}
						flatFile.append("}CNTR_DANGER_MAIN").append("\n");
					}//for(cntr danger main end)
				}

				flatFile.append("}CNTR_INFO").append("\n");
			}//for(cntr info end)

			flatFile.append("}MAIN").append("\n");

			/*Detail log를 쌓기 위한 flat file log 용 start 2012.04.23 */

			realFlatFile.append(" ").append("\n");//추가 넣음 {MAIN
			realFlatFile.append(" ").append("\n");
			realFlatFile.append(" ").append("\n");
			//BkgJapanTerminalEdiVO
//			if ("Y".equals(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCngFlg())) {//SnaccsTmlEdiStsCngFlg가 Y 인 경우는 JP_BL 의 STS 우선으로 전송 전송이후에는 N으로 resolve 2012.04.17   [CHM-201216534-01]  조원주
				realFlatFile.append(" ").append(dbDao.searchEdiStsCode(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCd())).append("\n");//BRAC:
//			} else {
//				flatFile.append("BRAC:").append(dbDao.searchEdiStsCode(bkgJpTmlEdiVO.getSnaccsTmlEdiStsCngFlg())).append("\n");
//			}
			realFlatFile.append(" ").append("COMC").append("\n"); //SCAC_CD:
			realFlatFile.append(" ").append(bkgTerminalEdiJapanBlVO.getBkgNo()).append("\n");//BKGNBR:
			realFlatFile.append(" ").append(bkgTerminalEdiJapanBlVO.getCallSgnNo().length() > 0?bkgTerminalEdiJapanBlVO.getCallSgnNo().substring(0, bkgTerminalEdiJapanBlVO.getCallSgnNo().length()).toUpperCase() :"").append("\n");//VSL_CALL_SIGN:

			if (bkgTerminalEdiJapanBlVO.getCallSgnNo().length() > 0) { //MIG 5번 적재예정선박코드CallSign 이 있을 경우 6번은 공란으로 전송
				realFlatFile.append(" ").append("").append("\n");//VSLNAME:
			} else {
				realFlatFile.append(" ").append(bkgTerminalEdiJapanBlVO.getVslEngNm().length() > 0?bkgTerminalEdiJapanBlVO.getVslEngNm().substring(0, bkgTerminalEdiJapanBlVO.getVslEngNm().length()).toUpperCase() :"").append("\n");//VSLNAME:
			}
			realFlatFile.append(" ").append(bkgTerminalEdiJapanBlVO.getJpTmlVslNo()).append("\n");//확인VVD:
			realFlatFile.append(" ").append("").append("\n");// bkgTerminalEdiJapanBlVO.getBkgCreDt().length() > 0?bkgTerminalEdiJapanBlVO.getBkgCreDtYmd() :"" 2012.04.25 손영주과장님 공란요청 TO_CHAR(BKG_CRE_DT, 'YYYYMMDD') BKG_DT:
			realFlatFile.append(" ").append(dbDao.getUnLocCd(bkgTerminalEdiJapanBlVO.getPolCd())).append("\n");//POL_UNLC:

			realFlatFile.append(" ").append( dbDao.searchCYCode(bkgTerminalEdiJapanBlVO.getPolYdCd())).append("\n");//SELECT INTG_CD_VAL_DP_DESC ?  POL_YDCD:
			realFlatFile.append(" ").append(dbDao.getUnLocCd(bkgTerminalEdiJapanBlVO.getPorCd())).append("\n");	//POR_UNLC:
			realFlatFile.append(" ").append(dbDao.searchCYCode(bkgTerminalEdiJapanBlVO.getPorYdCd())).append("\n");//SELECT INTG_CD_VAL_DP_DESC ?POR_YDCD:

			realFlatFile.append(" ").append(dbDao.searchCYCode(JSPUtil.getNull(bkgTerminalEdiJapanBlVO.getOtrNtfyYdCd()))).append("\n"); //SELECT INTG_CD_VAL_DP_DESC ? OTHR_NTFY:

			realFlatFile.append(" ").append(JSPUtil.getNull(bkgTerminalEdiJapanBlVO.getEtdDt()).length() > 0?bkgTerminalEdiJapanBlVO.getEtdDtYmd() :" ").append("\n");//TO_CHAR(ETD_DT, 'YYYYMMDD') POL_ETD:
			realFlatFile.append(" ").append(dbDao.getUnLocCd(dbDao.searchPrePod(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanBlVO.getVslCd(), bkgTerminalEdiJapanBlVO.getSkdVoyNo(), bkgTerminalEdiJapanBlVO.getSkdDirCd()))).append("\n");//POD_UNLC:
			//realflatFile.append(" ").append("").append("\n");//POD_UNLC2:
			realFlatFile.append(" ").append(dbDao.getUnLocCd(bkgTerminalEdiJapanBlVO.getFnlDestCd())).append("\n");//DEL_CD or LOCATION.LOC_DESC? DEL_UNLC:
			realFlatFile.append(" ").append(bkgTerminalEdiJapanBlVO.getFnlDestNm().length() > 0?bkgTerminalEdiJapanBlVO.getFnlDestNm().substring(0, bkgTerminalEdiJapanBlVO.getFnlDestNm().length()).toUpperCase() :"").append("\n");//???? DEL_NAME:
			realFlatFile.append(" ").append(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiRcvTermCd()).append("\n");//RCVTYP:
			realFlatFile.append(" ").append(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiDeTermCd()).append("\n");//DELTYP:
			realFlatFile.append(" ").append("").append("\n");//DEST_UNLC: dbDao.getUnLocCd(bkgTerminalEdiJapanBlVO.getFnlDestCd())
			realFlatFile.append(" ").append("").append("\n");//DEST_UNLC_NAME: bkgTerminalEdiJapanBlVO.getFnlDestNm().length() > 0?bkgTerminalEdiJapanBlVO.getFnlDestNm().toUpperCase() :""
			realFlatFile.append(" ").append(dbDao.getUnLocCd(dbDao.searchTrshUncd(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanBlVO.getPolCd(), bkgTerminalEdiJapanBlVO.getVslCd(), bkgTerminalEdiJapanBlVO.getSkdVoyNo(), bkgTerminalEdiJapanBlVO.getSkdDirCd()))).append("\n");//TRSH_UNCD:

			realFlatFile.append(" ").append(JSPUtil.getNull(bkgTerminalEdiJapanBlVO.getShprCustNm()).length() > 0?"":bkgTerminalEdiJapanBlVO.getShprCntCd() +bkgTerminalEdiJapanBlVO.getShprCustSeq()).append("\n");//SH_CD1:

			realFlatFile.append(" ").append(bkgTerminalEdiJapanBlVO.getShprCustNm().length() > 0?bkgTerminalEdiJapanBlVO.getShprCustNm().toUpperCase() :"").append("\n");//SHN1:
			realFlatFile.append(" ").append("").append("\n");//.append(bkgTerminalEdiJapanBlVO.getFrtFwrdCntCd() +bkgTerminalEdiJapanBlVO.getFrtFwrdCustSeq()).append("\n");//FF_CD1:
			realFlatFile.append(" ").append("").append("\n");//.append(bkgTerminalEdiJapanBlVO.getFrtFwrdCustNm().length() > 0?bkgTerminalEdiJapanBlVO.getFrtFwrdCustNm().toUpperCase() :"").append("\n");
			realFlatFile.append(" ").append(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiCgoTpCd()).append("\n");    //CARGOTYPE:
			//realFlatFile.append(" ").append("").append("\n");//.append(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiCgoKndCd()).append("\n");    //CARGO_IND:
			realFlatFile.append(" ").append(cgoFlg).append("\n");    //CARGO_IND:
			realFlatFile.append(" ").append("").append("\n");//.append(bkgTerminalEdiJapanBlVO.getPckTpCd()).append("\n");PKG_CD:
			realFlatFile.append(" ").append(bkgTerminalEdiJapanBlVO.getCmdtNm().length() > 0?bkgTerminalEdiJapanBlVO.getCmdtNm().substring(0, bkgTerminalEdiJapanBlVO.getCmdtNm().length()).toUpperCase() :"").append("\n");//CMDD:
			realFlatFile.append(" ").append(bkgTerminalEdiJapanBlVO.getXterRmk().length() > 0?bkgTerminalEdiJapanBlVO.getXterRmk().substring(0, bkgTerminalEdiJapanBlVO.getXterRmk().length()).toUpperCase() :"").append("\n");//REMARK:

			cntrVO =  dbDao.searchJapanCntrPKGInfo(bkgTerminalEdiJapanBlVO.getBkgNo());
			realFlatFile.append(" ").append("").append("\n");//.append(cntrVO.getPckQty()).append("\n");PKG:
			realFlatFile.append(" ").append("").append("\n");//.append(cntrVO.getPckTpCd()).append("\n");PUNIT:
			realFlatFile.append(" ").append("").append("\n");//.append(cntrVO.getCntrWgt()).append("\n");WGT:
			realFlatFile.append(" ").append("").append("\n");//.append(cntrVO.getWgtUtCd()).append("\n");WUNIT:
			realFlatFile.append(" ").append("").append("\n");//.append(cntrVO.getMeasQty()).append("\n");MEAS:
			realFlatFile.append(" ").append("").append("\n");//.append(cntrVO.getMeasUtCd()).append("\n");MUNIT:
			bkgTerminalEdiJapanCntrList =  dbDao.searchJapanCntrInfo(bkgTerminalEdiJapanBlVO.getBkgNo());

			for( cntrIdx = 0; cntrIdx < bkgTerminalEdiJapanCntrList.size(); cntrIdx++) {
				//(1) Container 정보
				realFlatFile.append(" ").append("\n");// {CNTR_INFO
				realFlatFile.append(" ").append(bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().length() > 0?bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().substring(0, 2) :"").append("\n"); //CNTR_SIZE:
				//group tp code로 가져오기
				if (bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().length() > 0) {
					realFlatFile.append(" ").append(dbDao.searchIsoGroupTpCd(bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().substring(2, bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().length()))).append("\n");//.append(bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().length() > 0?bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().substring(2, bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszIsoCd().length()) :"").append("\n");CNTR_TYPE:
				} else {
					realFlatFile.append(" ").append("\n");
				}

				if ((cntrIdx) == 0) {
					realFlatFile.append(" ").append(bkgTerminalEdiJapanBlVO.getCntrVolQty1()).append("\n");// 확인CNT:
				} else if ((cntrIdx) ==1) {
					realFlatFile.append(" ").append(bkgTerminalEdiJapanBlVO.getCntrVolQty2()).append("\n");// 확인CNT:
				} else if ((cntrIdx) ==2) {
					realFlatFile.append(" ").append(bkgTerminalEdiJapanBlVO.getCntrVolQty3()).append("\n");// 확인CNT:
				} else if ((cntrIdx) ==3) {
					realFlatFile.append(" ").append(bkgTerminalEdiJapanBlVO.getCntrVolQty4()).append("\n");// 확인CNT:
				} else if ((cntrIdx) ==4) {
					realFlatFile.append(" ").append(bkgTerminalEdiJapanBlVO.getCntrVolQty5()).append("\n");// 확인CNT:
				}

				//flatFile.append("CNT:").append(JSPUtil.getNull(bkgTerminalEdiJapanCntrList.get(cntrIdx).getCount())).append("\n");// 확인

				//JapanTerminalTransmissionDBDAOsearchJapanStowageInfoRSQL
				blVO = dbDao.searchJapanCntrStowageInfo(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszCd());
				realFlatFile.append(" ").append("").append("\n");//PKUP_NAME:
				realFlatFile.append(" ").append(JSPUtil.getNull(blVO.getSnaccsTmlEdiStwgCd())).append("\n");//STWG_REQ:
				realFlatFile.append(" ").append("").append("\n");//STWG_REQ2:
				realFlatFile.append(" ").append(JSPUtil.getNull((blVO.getXterRmk()))).append("\n");//STWG_REMARK:
				realFlatFile.append(" ").append(blVO.getBlckStwgCd()).append("\n");//BLKSTWG:
				realFlatFile.append(" ").append(JSPUtil.getNull("N".equals(blVO.getDryCgoFlg()) ?"":"1")).append("\n");//RD_IND:
				realFlatFile.append(" ").append(JSPUtil.getNull("N".equals(blVO.getMcntrFlg()) ?"":"1")).append("\n");//MT_IND:
				realFlatFile.append(" ").append(JSPUtil.getNull("N".equals(blVO.getSocFlg()) ?"":"1")).append("\n");//SOC_IND:
				realFlatFile.append(" ").append("").append("\n"); //blVO.getEqSubstFlg() //RF_RRE: 2012.04.25 손영주과장님 공란요청
				realFlatFile.append(" ").append("").append("\n"); //blVO.getEqSubstFlg() //RF_REMARK:

				//JapanTerminalTransmissionDBDAOsearchJapanRFCgoInfoRSQL
				//Unused Local Variable
				//rfVO =dbDao.searchJapanRFCgoInfo(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszCd());
				realFlatFile.append(" ").append("").append("\n");//TEMP_MAX: 2012.04.25 손영주과장님 공란요청
				realFlatFile.append(" ").append("").append("\n");//TEMP: 2012.04.25 손영주과장님 공란요청
				realFlatFile.append(" ").append("").append("\n");//TEMP_MIN: 2012.04.25 손영주과장님 공란요청
				realFlatFile.append(" ").append("").append("\n");//TEMP_UNIT: 2012.04.25 손영주과장님 공란요청
				realFlatFile.append(" ").append("").append("\n");//HUMID: 2012.04.25 손영주과장님 공란요청
				//flatFile.append("VENT:").append(rfVO.getCntrVentTpCd()).append("\n"); 2012.04.25 손영주과장님 공란요청
				realFlatFile.append(" ").append("").append("\n");//VENT: 2012.04.25 손영주과장님 공란요청

				//JapanTerminalTransmissionDBDAOsearchJapanAWKCgoInfoRSQL

				awkVO= dbDao.searchJapanAWKCgoInfo(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszCd());
				realFlatFile.append(" ").append(awkVO.getOvrHgt()).append("\n");//OVH:
				realFlatFile.append(" ").append(awkVO.getOvrLfLen()).append("\n");//OVLW:
				realFlatFile.append(" ").append(awkVO.getOvrRtLen()).append("\n");//OVRW:
				realFlatFile.append(" ").append(JSPUtil.getNull(awkVO.getOvfr())).append("\n");//awkVO.getOvrFwrdLen() +awkVO.getOvrBkwdLen() //OVFR:
				realFlatFile.append(" ").append(awkVO.getOvrVoidSltQty()).append("\n");//VOID_SLOT:

				//JapanTerminalTransmissionDBDAOsearchJapanDGInfoRSQL.Query
				dgVO= dbDao.searchJapanDGCgoInfo(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszCd()); //cntr_tpsz_cd
				realFlatFile.append(" ").append(dgVO.getMrnPolutFlg()).append("\n"); //MAR_POLL:
				realFlatFile.append(" ").append(dgVO.getImdgLmtQtyFlg()).append("\n");//IMO_LIMIT:

				//(2) Container Danger Main 정보
				dgMainList =  dbDao.searchJapanDangerMainInfo(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszCd());//cntr_tpsz_cd
				if (dgMainList.size() > 0) {
					for (BkgTerminalEdiDgCgoVO dgMainVO : dgMainList) {
						realFlatFile.append(" ").append("\n");    // {CNTR_DANGER_MAIN
						realFlatFile.append(" ").append(dgMainVO.getImdgClssCd()).append("\n");    // CLAS:
						//(3) Container Danger Detail 정보
						dgDetailList =  dbDao.searchJapanDangerDetailInfo(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanCntrList.get(cntrIdx).getCntrTpszCd(), dgMainVO.getImdgClssCd()); //cntr_tpsz_cd, imdg_clss_cd
						if (dgDetailList.size() > 0) {
							for (BkgTerminalEdiDgCgoVO dgDetailVO : dgDetailList) {
									realFlatFile.append(" ").append("\n");    // {CNTR_DANGER_DETAIL
									realFlatFile.append(" ").append(dgDetailVO.getImdgUnNo()).append("\n");    // UNBR:
									realFlatFile.append(" ").append(dgDetailVO.getImdgPckGrpCd()).append("\n");    // PKGGRP:
									realFlatFile.append(" ").append("\n");    //}CNTR_DANGER_DETAIL
							}
						}
						flatFile.append(" ").append("\n");    // }CNTR_DANGER_MAIN
					}//for(cntr danger main end)
				}

				realFlatFile.append(" ").append("\n");
			}//for(cntr info end)

			realFlatFile.append(" ").append("\n");

			/* Detail log를 쌓기 위한 flat file log 용 end  2012.04.23 */

			log.debug(flatFile);

			// flatFile MQ로 전송
			ediSendMessage(flatFile.toString(), "BKG.OPUSBKG_UBIZCOM_VENDOR.IBMMQ.QUEUE");//EDI 전송

			// send Flat File log VO 셋팅
			BkgCstmsJpSndLogVO bkgCstmsJpSndLogVO = new BkgCstmsJpSndLogVO(); // send
			BookingUtil command = new BookingUtil();

			String sndDt = command.searchLocalTime(account.getCnt_cd() +account.getOfc_cd().substring(0, 3));
			//String logSeq = dbDao.searchLogSeq(sndDt);
			//JapanTerminalTransmissionDBDAOsearchSendLogSeqRSQL
			String msgTp="";
			if ("R".equals(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCd())) {
				msgTp = "BKR";
			} else {
				msgTp = "BKC";
			}
			// 전송로그를 저장
			bkgCstmsJpSndLogVO.setBlNo(bkgTerminalEdiJapanBlVO.getBkgNo());
			bkgCstmsJpSndLogVO.setSndDt(sndDt);
			bkgCstmsJpSndLogVO.setJpSndLogId(msgTp);
			bkgCstmsJpSndLogVO.setOfcCd(account.getOfc_cd());
			bkgCstmsJpSndLogVO.setLogSeq(""+logSeq);
			bkgCstmsJpSndLogVO.setVslCd(bkgTerminalEdiJapanBlVO.getVslCd());
			bkgCstmsJpSndLogVO.setSkdVoyNo(bkgTerminalEdiJapanBlVO.getSkdVoyNo());
			bkgCstmsJpSndLogVO.setSkdDirCd(bkgTerminalEdiJapanBlVO.getSkdDirCd());
			bkgCstmsJpSndLogVO.setPodCd(bkgTerminalEdiJapanBlVO.getPodCd());
			bkgCstmsJpSndLogVO.setLogFlg("N");
			bkgCstmsJpSndLogVO.setLogDt(command.searchLocalTime(account.getCnt_cd() +account.getOfc_cd().substring(0, 3)));
			bkgCstmsJpSndLogVO.setSndFlg("Y");
			bkgCstmsJpSndLogVO.setCreUsrId(account.getUsr_id());
			bkgCstmsJpSndLogVO.setUpdUsrId(account.getUsr_id());
			bkgCstmsJpSndLogVO.setPolCd(bkgTerminalEdiJapanBlVO.getPolCd());
			bkgCstmsJpSndLogVO.setPorCd(bkgTerminalEdiJapanBlVO.getPorCd());
			bkgCstmsJpSndLogVO.setPolYdCd(bkgTerminalEdiJapanBlVO.getPolYdCd());
			bkgCstmsJpSndLogVO.setPorYdCd(bkgTerminalEdiJapanBlVO.getPorYdCd());
			bkgCstmsJpSndLogVO.setEdiSndMsgCtnt(realFlatFile.toString().replace("\n", "\n"));
			dbDao.addJapanTerminalSendLog(bkgCstmsJpSndLogVO);
			dbDao.modifyBkgTmlEdiJpBl(bkgCstmsJpSndLogVO, bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanBlVO.getBkgSkdSeq(), bkgTerminalEdiJapanBlVO.getPodYdCd());

			//SnaccsTmlEdiStsCngFlg가 Y 인 경우는 JP_BL 의 STS 우선으로 전송 전송이후에는 N으로 resolve 2012.04.17 [CHM-201216534-01]  조원주
			if ("Y".equals(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCngFlg())) {
				dbDao.modifySnaccsTmlEdiStsCngFlg(bkgTerminalEdiJapanBlVO.getBkgNo(), bkgTerminalEdiJapanBlVO.getBkgSkdSeq());
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return flatFile.toString();
	}

	/**
	 * EDI 전송 처리부
	 * @param String flatFile
	 * @param String queueName
	 * @exception EventException
	 */
	private void ediSendMessage(String flatFile, String queueName) throws EventException {
		try {
			// FlatFile 이 빈 경우 SKIP 처리
			if (flatFile!=null && flatFile.trim().length() > 1) {
				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(flatFile);
				sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get(queueName));
				BookingUtil utilCommand = new BookingUtil();
				FlatFileAckVO flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
				if (flatFileAckVO.getAckStsCd().equals("E")) throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
			}
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 *  Japan batch schedule 조회
	 *
	 * @param JapanTerminalEdiCondVO japanTerminalEdiCondVO
	 * @param SignOnUserAccount account
	 * @return List<VvdJapanTerminalEdiVO>
	 * @throws EventException
	 */
	public List<VvdJapanTerminalEdiVO> searchVesselListForSchedule(JapanTerminalEdiCondVO japanTerminalEdiCondVO, SignOnUserAccount account) throws EventException {

		try {
			return dbDao.searchVesselListForSchedule(japanTerminalEdiCondVO, account);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 *  Japan batch schedule 조회
	 *
	 * @param JapanTerminalEdiCondVO japanTerminalEdiCondVO
	 * @return List<VvdJapanTerminalEdiVO>
	 * @throws EventException
	 */
	public List<VvdJapanTerminalEdiVO> searchVesselListForBKGRoute(JapanTerminalEdiCondVO japanTerminalEdiCondVO) throws EventException {

		try {
			return dbDao.searchVesselListForBKGRoute(japanTerminalEdiCondVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Sea-NACCS 프로젝트스케줄 Retrieve 후 수정 SAVE<br>
	 * @param VvdJapanTerminalEdiVO[] vvdJapanTerminalEdiVOs
	 * @param SignOnUserAccount account
	 * @return JapanTerminalEdiCheckRsltVO
	 * @exception EventException
	 */
	public JapanTerminalEdiCheckRsltVO manageTerminalEdi(VvdJapanTerminalEdiVO[] vvdJapanTerminalEdiVOs, SignOnUserAccount account) throws EventException {
		JapanTerminalEdiCheckRsltVO japanTerminalEdiCheckRsltVO = new JapanTerminalEdiCheckRsltVO();
		//String resultStr = "";

		try {
			//삭제 후 신규, 수정 작업을 한다.

			for (VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO : vvdJapanTerminalEdiVOs) {
				vvdJapanTerminalEdiVO.setUpdUsrId(account.getUsr_id());
				vvdJapanTerminalEdiVO.setCreUsrId(account.getUsr_id());

				//배치 스케줄 Update, Insert 시에 BKG Route check하여 Route가 존재하면 저장
				if (vvdJapanTerminalEdiVO.getIbflag().equals("U")) {
					String chkFlg = dbDao.searchCheckRoute(vvdJapanTerminalEdiVO);

					if ("Y".equals(chkFlg)) {//Bkg Route가 유효함

						//VVD_SKD 수정 - CY 코드 변경시에 키값이 변경 되는 것이므로 이미 있던 스케줄은 지우고 업데이트 된 스케줄이등록됨
						if ( !(vvdJapanTerminalEdiVO.getPolYdCd().equals(vvdJapanTerminalEdiVO.getBePolYdCd()))
						  || !(vvdJapanTerminalEdiVO.getPorYdCd().equals(vvdJapanTerminalEdiVO.getBePorYdCd()))) {
							dbDao.removeVesselListBe(vvdJapanTerminalEdiVO);
							dbDao.removeVesselListJpBlBe(vvdJapanTerminalEdiVO);

							dbDao.addVesselListByBKGRoute(vvdJapanTerminalEdiVO, account);

						} else {
							dbDao.modifyVesselList(vvdJapanTerminalEdiVO, account);
							if ("Y".equals(vvdJapanTerminalEdiVO.getSkdDeltFlg())) {
								dbDao.removeVesselListJpBl(vvdJapanTerminalEdiVO);
								// dbDao.removeTransmitHistory(vvdJapanTerminalEdiVO);
							} else {
								dbDao.modifyVesselListJpBl(vvdJapanTerminalEdiVO);//delete flg를 N으로 바꾸었을 시에 JP_BL 테이블에도 적용 시켜준다
							}
							//dbDao.modifyVesselListJpBl(vvdJapanTerminalEdiVO, account);//한번 전송된 후 JP_BL 테이블에 voyage no 수정
							dbDao.addVslSkdHis(vvdJapanTerminalEdiVO);
							japanTerminalEdiCheckRsltVO.setResultStr("Y");
						}

					} else {
						japanTerminalEdiCheckRsltVO.setResultStr("N");//Bkg Route가 유효하지 않음
					}

				} else if (vvdJapanTerminalEdiVO.getIbflag().equals("D")) {
					dbDao.removeVesselList(vvdJapanTerminalEdiVO);
					dbDao.removeVesselListBkgTmlEdiJpCntr(vvdJapanTerminalEdiVO);
					dbDao.removeVesselListBkgTmlEdiJpDgCgo(vvdJapanTerminalEdiVO);
					dbDao.removeVesselListBkgTmlEdiJpRfCgo(vvdJapanTerminalEdiVO);
					dbDao.removeVesselListBkgTmlEdiJpAwkCgo(vvdJapanTerminalEdiVO);
					dbDao.removeVesselListJpBl(vvdJapanTerminalEdiVO);
					//dbDao.removeTransmitHistory(vvdJapanTerminalEdiVO);// 전송이력에서도 숨김

				} else if (vvdJapanTerminalEdiVO.getIbflag().equals("I")) {
					String chkFlg = dbDao.searchCheckRoute(vvdJapanTerminalEdiVO);
					String flg = dbDao.searchCheckTableData(vvdJapanTerminalEdiVO);
					if ("Y".equals(chkFlg)) {
						if ("Y".equals(flg)) {
							//무결성제약조건 메시지 뿌리기
							japanTerminalEdiCheckRsltVO.setFlg("Y");
						} else {
							dbDao.addVesselListByBKGRoute(vvdJapanTerminalEdiVO, account);
							japanTerminalEdiCheckRsltVO.setResultStr("Y");
						}
					} else {
						japanTerminalEdiCheckRsltVO.setResultStr("N");
					}
				}
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return japanTerminalEdiCheckRsltVO;
	}


	/**
	 *  Japan batch schedule 조회
	 *
	 * @param JapanTerminalEdiCondVO japanTerminalEdiCondVO
	 * @param SignOnUserAccount account
	 * @return List<BkgJapanTerminalEdiVO>
	 * @throws EventException
	 */
	public List<BkgJapanTerminalEdiVO> searchBkgInfoForSchedule(JapanTerminalEdiCondVO japanTerminalEdiCondVO, SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchBkgInfoForSchedule(japanTerminalEdiCondVO, account);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 *  김종옥_Sea-NACCS 프로젝트(20120312)
	 *  Japan batch schedule 조회
	 *
	 * @param JapanTerminalEdiCondVO japanTerminalEdiCondVO
	 * @return List<BkgJapanTerminalEdiVO>
	 * @throws EventException
	 */
	public List<BkgJapanTerminalEdiVO> searchPartialBkgInfoForSchedule(JapanTerminalEdiCondVO japanTerminalEdiCondVO) throws EventException {

		try {
			return dbDao.searchPartialBkgInfoForSchedule(japanTerminalEdiCondVO);
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 판별로직 확인
	 * J<br>
	 *
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckColumns(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO) throws EventException {
		try {
			String chk_flg = dbDao.searchCheckColumns(bkgTerminalEdiJapanBlVO);
			return chk_flg;
		} catch(DAOException ex) {
		throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * searchNewBkgInfo<br>
	 *
	 * @param VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO
	 * @return List<BkgTerminalEdiJapanBlVO>
	 * @exception EventException
	 */
	public List<BkgTerminalEdiJapanBlVO> searchNewBkgInfo(VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO) throws EventException {
		try {
			return dbDao.searchNewBkgInfo(vvdJapanTerminalEdiVO);
		} catch(DAOException ex) {
		throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * searchNewBkgDetailInfo<br>
	 *
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @return JapanTerminalEdiGroupVO
	 * @exception EventException
	 */
	public JapanTerminalEdiGroupVO searchNewBkgDetailInfo(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO) throws EventException {
		try {
			JapanTerminalEdiGroupVO groupVO = new JapanTerminalEdiGroupVO();

			groupVO.setBkgTerminalEdiJapanCntrVOs(dbDao.searchCntrforNewBkgInfo(bkgTerminalEdiJapanBlVO));
			groupVO.setBkgTerminalEdiJapanDgCgoVOs(dbDao.searchDgCgoforNewBkgInfo(bkgTerminalEdiJapanBlVO));
			groupVO.setBkgTerminalEdiJapanAwkCgoVOs(dbDao.searchAwkCgoforNewBkgInfo(bkgTerminalEdiJapanBlVO));
			groupVO.setBkgTerminalEdiJapanRfCgoVOs(dbDao.searchRfCgoforNewBkgInfo(bkgTerminalEdiJapanBlVO));

			return groupVO;
		} catch(DAOException ex) {
		throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * addNewBkgInfo<br>
	 *
	 * @param BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO
	 * @param JapanTerminalEdiGroupVO japanTerminalEdiGroupVO
	 * @param SignOnUserAccount account
	 * @param String vvdChk
	 * @return String
	 * @exception EventException
	 */
	public String addNewBkgInfo(BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO, JapanTerminalEdiGroupVO japanTerminalEdiGroupVO, SignOnUserAccount account, String vvdChk) throws EventException {

		try {
			String chk_flg = "Y";
			String max_seq = "";
			String chk_seq = "";
			String del_flg = "";

			List<BkgTerminalEdiJapanCntrVO> cntrVoList = new ArrayList<BkgTerminalEdiJapanCntrVO>();
			List<BkgTerminalEdiJapanDgCgoVO> dgVoList = new ArrayList<BkgTerminalEdiJapanDgCgoVO>();
			List<BkgTerminalEdiJapanAwkCgoVO> awkVoList = new ArrayList<BkgTerminalEdiJapanAwkCgoVO>();
			List<BkgTerminalEdiJapanRfCgoVO> rfVoList = new ArrayList<BkgTerminalEdiJapanRfCgoVO>();

			if (bkgTerminalEdiJapanBlVO != null && japanTerminalEdiGroupVO != null) {
				//Max 값 체크
				max_seq = dbDao.searchNewBkgSeq(bkgTerminalEdiJapanBlVO);
				del_flg = dbDao.searchCntrforNewBkgDelFlg(bkgTerminalEdiJapanBlVO);

				if (max_seq.equals("")) {
					dbDao.addNewBkgInfo(bkgTerminalEdiJapanBlVO, account);
				} else {
					if ("vvdChk".equals(vvdChk)) bkgTerminalEdiJapanBlVO.setSnaccsTmlEdiStsCd("D");
					dbDao.addNewBkgInfoMax(bkgTerminalEdiJapanBlVO);
					if ("vvdChk".equals(vvdChk))  {
						dbDao.updateNewBkgInfoVvdChk(bkgTerminalEdiJapanBlVO, account);
					} else {
						dbDao.updateNewBkgInfo(bkgTerminalEdiJapanBlVO, account);
					}
				}

				cntrVoList = japanTerminalEdiGroupVO.getBkgTerminalEdiJapanCntrVOs();
				dgVoList = japanTerminalEdiGroupVO.getBkgTerminalEdiJapanDgCgoVOs();
				awkVoList = japanTerminalEdiGroupVO.getBkgTerminalEdiJapanAwkCgoVOs();
				rfVoList = japanTerminalEdiGroupVO.getBkgTerminalEdiJapanRfCgoVOs();

				if (cntrVoList.size() > 0) {
					chk_seq = dbDao.searchCntrforNewBkgSeq(bkgTerminalEdiJapanBlVO);
					if (chk_seq.equals("")) {
						dbDao.addCntrforNewBkgInfo(cntrVoList, account);
					} else {
						dbDao.addCntrforNewBkgInfoMax(cntrVoList, chk_seq);
						dbDao.deleteCntrforNewBkgInfo(cntrVoList);
						dbDao.addCntrforNewBkgInfo(cntrVoList, account);
					}
				}

				if (dgVoList.size() > 0) {
					if ("Y".equals(bkgTerminalEdiJapanBlVO.getDcgoFlg())) {
						chk_seq = dbDao.searchDgCgoforNewBkgSeq(bkgTerminalEdiJapanBlVO);
						if (chk_seq.equals("")) {
							dbDao.addDgCgoforNewBkgInfo(dgVoList, account);
						} else {
							dbDao.addDgCgoforNewBkgInfoMax(dgVoList, chk_seq);
							dbDao.deleteDgCgoforNewBkgInfo(dgVoList);
							dbDao.addDgCgoforNewBkgInfo(dgVoList, account);
						}
					}
				}

				if (awkVoList.size() > 0) {
					if ("Y".equals(bkgTerminalEdiJapanBlVO.getAwkCgoFlg())) {
						chk_seq = dbDao.searchAwkCgoforNewBkgSeq(bkgTerminalEdiJapanBlVO);
						if (chk_seq.equals("")) {
							dbDao.addAwkCgoforNewBkgInfo(awkVoList, account);
						} else {
							dbDao.addAwkCgoforNewBkgInfoMax(awkVoList, chk_seq);
							dbDao.deleteAwkCgoforNewBkgInfo(awkVoList);
							dbDao.addAwkCgoforNewBkgInfo(awkVoList, account);
						}
					}
				}

				if (rfVoList.size() > 0) {
					if ("Y".equals(bkgTerminalEdiJapanBlVO.getRdCgoFlg())) {
						chk_seq = dbDao.searchRfCgoforNewBkgSeq(bkgTerminalEdiJapanBlVO);
						if (chk_seq.equals("")) {
							dbDao.addRfCgoforNewBkgInfo(rfVoList, account);
						} else {
							dbDao.addRfCgoforNewBkgInfoMax(rfVoList, chk_seq);
							dbDao.deleteRfCgoforNewBkgInfo(rfVoList);
							dbDao.addRfCgoforNewBkgInfo(rfVoList, account);
						}
					}
				}


String tmpDiv = "00";
				//변경여부 체크 Y, N
				if ("R".equals(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCd())) {
tmpDiv = "AA";
					chk_flg="Y";
				} else if (!"D".equals(del_flg) && !"V".equals(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCd())) {
tmpDiv = "BB";
					chk_flg="Y";
					//삭제 전송 시에 한번만 나가고 다음 부터는 비교로직을 타지 않게 한다.
				} else if (( bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCd().equals("D") && bkgTerminalEdiJapanBlVO.getRStsCnt().equals("1"))) {
tmpDiv = "CC";
					chk_flg="Y";
				} else {
					if ("D".equals(del_flg)) {
tmpDiv = "D1";
						chk_flg="N";
					} else {
tmpDiv = "P-CALL";
						chk_flg = dbDao.searchCheckColumns(bkgTerminalEdiJapanBlVO);
					}
				}
log.debug("\n\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% [JPTML-Debug] bkg_no : " + bkgTerminalEdiJapanBlVO.getBkgNo() + " / if-div : " + tmpDiv + " / chk_flg : " + chk_flg +"\n");
			}

			return chk_flg;

		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * managePartialBkgInfoForSchedule SAVE<br>
	 * @param BkgJapanTerminalEdiVO[] bkgJapanTerminalEdiVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePartialBkgInfoForSchedule(BkgJapanTerminalEdiVO[] bkgJapanTerminalEdiVOs, SignOnUserAccount account) throws EventException {
		List<BkgJapanTerminalEdiVO> updateVoList = new ArrayList<BkgJapanTerminalEdiVO>();

		try {
			for(BkgJapanTerminalEdiVO bkgJapanTerminalEdiVO : bkgJapanTerminalEdiVOs) {
				if (bkgJapanTerminalEdiVO.getIbflag().equals("U")) {
					bkgJapanTerminalEdiVO.setUpdUsrId(account.getUsr_id());
					bkgJapanTerminalEdiVO.setEdiSndOfcCd(account.getOfc_cd());
					updateVoList.add(bkgJapanTerminalEdiVO);
				}
			}

			if ( updateVoList.size() > 0) {
				dbDao.updatePartialBkgInfoForSchedule(updateVoList);
			}

		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * searchNewBkgInfo<br>
	 *
	 * @param String bkgNo
	 * @return BkgTerminalEdiJapanBlVO
	 * @exception EventException
	 */
	public BkgTerminalEdiJapanBlVO searchNewBkgInfoForVvdChk(String bkgNo) throws EventException {

		try {
			return dbDao.searchNewBkgInfoForVvdChk(bkgNo);
		} catch(DAOException ex) {
		throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

}
