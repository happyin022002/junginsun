/*=========================================================
 *Copyright(c) CyberLogitec
 *@FileName : MyanmarCustomsTransmissionBCImpl.java
 *@FileTitle : MyanmarCustomsTransmissionBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.integration.MyanmarCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.vo.BkgCstmsMySndLogDtlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.vo.BkgCstmsMySndLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.vo.MyanmarManifestBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.vo.MyanmarManifestCntrSealNoInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.vo.MyanmarManifestCustomerInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.vo.MyanmarManifestDescInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.vo.MyanmarManifestListCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.vo.MyanmarManifestLocInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.vo.MyanmarManifestMarkInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.vo.MyanmarManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.myanmar.vo.MyanmarManifestVslInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.vo.MyanmarManifestListBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.myanmar.vo.MyanmarManifestListCondVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-MyanmarCustomsTransmission Business Logic Basic Command implementation<br>
 * - OPUS-MyanmarCustomsTransmission handling business logic<br>
 *
 * @author
 * @see Related DAO class
 * @since J2EE 1.6
 */
public class MyanmarCustomsTransmissionBCImpl extends BasicCommandSupport implements MyanmarCustomsTransmissionBC {
	// Database Access Object
	private transient MyanmarCustomsTransmissionDBDAO dbDao = null;

	/**
	 * MyanmarCustomsTransmissionDBDAO 객체 생성<br>
	 */
	public MyanmarCustomsTransmissionBCImpl() {
		dbDao = new MyanmarCustomsTransmissionDBDAO();
	}


	/**
	 * Myanmar 세관신고 위해 FlatFile을 생성한다.
	 *
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException {
		BookingUtil bookingUtil = new BookingUtil();
		// FLATFILE
		String senderId = "";
		String receiverId = "";
		String headerType = "";
		String flatFileHeader = "";
		String flatFileRefNo = "";
		StringBuffer flatFile = new StringBuffer();

		// -- Input 정보 -- //
		// 전송할 BL LIST
		MyanmarManifestTransmitVO[] myanmarManifestTransmitVOs = (MyanmarManifestTransmitVO[]) manifestTransmitVOs;
		//B/L Input 정보
		List<MyanmarManifestListBlInfoVO> myanmarBlInputList = myanmarManifestTransmitVOs[0].getMyanmarManifestListBlInfoVOs();
		// 전송할 BL LIST
		MyanmarManifestListCondVO myanmarManifestListCondVO = myanmarManifestTransmitVOs[0].getMyanmarManifestListCondVO();

		// -- Output 정보 -- //
		// BL 정보
		MyanmarManifestBlInfoVO myanmarManifestBlInfoVO = new MyanmarManifestBlInfoVO();
		// DESC 정보
		MyanmarManifestDescInfoVO myanmarManifestDescInfoVO = new MyanmarManifestDescInfoVO();
		// VSL 정보
		MyanmarManifestVslInfoVO myanmarVslInfoVO = new MyanmarManifestVslInfoVO();
		// Location 정보
		List<MyanmarManifestLocInfoVO> myanmarLocInfoList = new ArrayList<MyanmarManifestLocInfoVO>();
		// Customer 정보
		List<MyanmarManifestCustomerInfoVO> myanmarCustomerInfoList = new ArrayList<MyanmarManifestCustomerInfoVO>();
		// Mark 정보
		MyanmarManifestMarkInfoVO myanmarManifestMarkInfoVO = new MyanmarManifestMarkInfoVO();
		// Container Seal 정보
		List<MyanmarManifestCntrSealNoInfoVO> myanmarCntrSealNoInfoList = new ArrayList<MyanmarManifestCntrSealNoInfoVO>();
		//Container Input 정보
		MyanmarManifestListCntrInfoVO myanmarCntrInputList = new MyanmarManifestListCntrInfoVO();


		// -- For문 Index -- //
		int blIdx 	= 0;
		int locIdx 	= 0;
		int custIdx = 0;
		int cntrIdx = 0;
		int sealIdx = 0;
		int blSeIdx = 0;
		int blCnt = 0;

		// SEND DATE
		String sndDt = "";
		MyanmarManifestListBlInfoVO temp = new MyanmarManifestListBlInfoVO();

		try {
			// Body 생성
			if (myanmarBlInputList != null) {

				// Header 생성
				senderId = "HJS";
				receiverId = "RGNBA";
				headerType = "SHPLINEMPA";
				flatFileHeader = bookingUtil.searchCstmsEdiHeader(senderId, receiverId, headerType);
				flatFile.append(flatFileHeader).append("\n");

				flatFileRefNo = flatFileHeader.substring(62).trim();
				// Send Data 생성
				sndDt = dbDao.searchSysDate();

				// (1) VSL 정보
				myanmarVslInfoVO = dbDao.searchVslInfo(myanmarBlInputList.get(0));
				if (myanmarVslInfoVO != null) {
					flatFile.append("MSG_TYPE:")		.append("785").append("\n"); // 확인
					flatFile.append("STATUS:")			.append(myanmarVslInfoVO.getStatus()).append("\n");
					flatFile.append("VSL_CODE:")		.append(myanmarVslInfoVO.getVvd().substring(0, 4)).append("\n");
					flatFile.append("VOYAGE:")			.append(myanmarVslInfoVO.getVvd().substring(4, 9)).append("\n");
					flatFile.append("VSL_NAME:")		.append(myanmarVslInfoVO.getVslFullname()).append("\n");
					flatFile.append("PORT:")			.append(myanmarVslInfoVO.getPort()).append("\n");
					flatFile.append("PORT_NM:")			.append(myanmarVslInfoVO.getPortNm()).append("\n");
					flatFile.append("ETA:")				.append(myanmarVslInfoVO.getEta()).append("\n");
					flatFile.append("ETD:")				.append(myanmarVslInfoVO.getEtd()).append("\n");
				}

				// BL 별로 내림차순 정렬
				for (int i=0; i<myanmarBlInputList.size(); i++) {
					for (int j=0; j<myanmarBlInputList.size(); j++) {
						if (myanmarBlInputList.get(i).getBlNo().compareTo(myanmarBlInputList.get(j).getBlNo()) > 0){
							temp = myanmarBlInputList.get(i);
							myanmarBlInputList.set(i,myanmarBlInputList.get(j));
							myanmarBlInputList.set(j,temp);
						}
					}
				}

				for (blSeIdx=0; blSeIdx<myanmarBlInputList.size(); blSeIdx++) {
					// (2) B/L 정보
					flatFile.append("{BL_INFO").append("\n");
					flatFile.append("LOOP_IND:")		.append(++blCnt).append("\n");//1 부터 시작
					flatFile.append("BLNBR:")			.append("HJSC"+myanmarBlInputList.get(blSeIdx).getBlNo()).append("\n");
					flatFile.append("BKGNBR:")			.append(myanmarBlInputList.get(blSeIdx).getBkgNo()).append("\n");

					// (3) Other B/L 정보
					myanmarManifestBlInfoVO = dbDao.searchManifestBlInfo(myanmarBlInputList.get(blSeIdx));

					flatFile.append("BLPKG:")			.append(myanmarManifestBlInfoVO.getPckQty()).append("\n");
					flatFile.append("BLPKGU:")			.append(myanmarManifestBlInfoVO.getPckTpCd()).append("\n");
					flatFile.append("BLWGT:")			.append(myanmarManifestBlInfoVO.getActWgt()).append("\n");
					flatFile.append("BLWGT_UNIT:")		.append(myanmarManifestBlInfoVO.getWgtUtCd()).append("\n");

					flatFile.append("BLVOL:")			.append(myanmarManifestBlInfoVO.getMeasQty()).append("\n");
					flatFile.append("BLVOL_UNIT:")		.append(myanmarManifestBlInfoVO.getMeasUtCd()).append("\n");
					flatFile.append("BL_CNTRNBR:")		.append(myanmarManifestBlInfoVO.getOpCntrQty()).append("\n");
					flatFile.append("BL_ISSUE_DATE:")	.append(myanmarManifestBlInfoVO.getOblIssDt()).append("\n");
					flatFile.append("ONBOARD_DATE:")	.append(myanmarManifestBlInfoVO.getBlObrdDt()).append("\n");

					// (4) Description 정보
					myanmarManifestDescInfoVO = dbDao.searchDescInfo(myanmarBlInputList.get(blSeIdx));

					if(myanmarManifestDescInfoVO != null){
						flatFile.append("{DESC").append("\n");
						flatFile.append("DESC1:")			.append(myanmarManifestDescInfoVO.getDesc1()).append("\n");
						flatFile.append("DESC2:")			.append(myanmarManifestDescInfoVO.getDesc2()).append("\n");	//확인
						flatFile.append("DESC3:")			.append(myanmarManifestDescInfoVO.getDesc3()).append("\n");	//확인
						flatFile.append("DESC4:")			.append(myanmarManifestDescInfoVO.getDesc4()).append("\n");	//확인
						flatFile.append("DESC5:")			.append(myanmarManifestDescInfoVO.getDesc5()).append("\n");	//확인
						flatFile.append("DESC6:")			.append(myanmarManifestDescInfoVO.getDesc6()).append("\n");	//확인
						flatFile.append("DESC7:")			.append(myanmarManifestDescInfoVO.getDesc7()).append("\n");	//확인
						flatFile.append("DESC8:")			.append(myanmarManifestDescInfoVO.getDesc8()).append("\n");	//확인
						flatFile.append("DESC9:")			.append(myanmarManifestDescInfoVO.getDesc9()).append("\n");	//확인
						flatFile.append("DESC10:")			.append(myanmarManifestDescInfoVO.getDesc10()).append("\n");	//확인
						flatFile.append("DESC11:")			.append(myanmarManifestDescInfoVO.getDesc11()).append("\n");	//확인
						flatFile.append("DESC12:")			.append(myanmarManifestDescInfoVO.getDesc12()).append("\n");	//확인
						flatFile.append("DESC13:")			.append(myanmarManifestDescInfoVO.getDesc13()).append("\n");	//확인
						flatFile.append("DESC14:")			.append(myanmarManifestDescInfoVO.getDesc14()).append("\n");	//확인
						flatFile.append("DESC15:")			.append(myanmarManifestDescInfoVO.getDesc15()).append("\n");	//확인
						flatFile.append("DESC16:")			.append(myanmarManifestDescInfoVO.getDesc16()).append("\n");	//확인
						flatFile.append("DESC17:")			.append(myanmarManifestDescInfoVO.getDesc17()).append("\n");	//확인
						flatFile.append("DESC18:")			.append(myanmarManifestDescInfoVO.getDesc18()).append("\n");	//확인
						flatFile.append("DESC19:")			.append(myanmarManifestDescInfoVO.getDesc19()).append("\n");	//확인
						flatFile.append("DESC20:")			.append(myanmarManifestDescInfoVO.getDesc20()).append("\n");	//확인
						flatFile.append("DESC21:")			.append(myanmarManifestDescInfoVO.getDesc21()).append("\n");	//확인
						flatFile.append("DESC22:")			.append(myanmarManifestDescInfoVO.getDesc22()).append("\n");	//확인
						flatFile.append("DESC23:")			.append(myanmarManifestDescInfoVO.getDesc23()).append("\n");	//확인
						flatFile.append("DESC24:")			.append(myanmarManifestDescInfoVO.getDesc24()).append("\n");	//확인
						flatFile.append("DESC25:")			.append(myanmarManifestDescInfoVO.getDesc25()).append("\n");	//확인
						flatFile.append("DESC26:")			.append(myanmarManifestDescInfoVO.getDesc26()).append("\n");	//확인
						flatFile.append("DESC27:")			.append(myanmarManifestDescInfoVO.getDesc27()).append("\n");	//확인
						flatFile.append("DESC28:")			.append(myanmarManifestDescInfoVO.getDesc28()).append("\n");	//확인
						flatFile.append("DESC29:")			.append(myanmarManifestDescInfoVO.getDesc29()).append("\n");	//확인
						flatFile.append("DESC30:")			.append(myanmarManifestDescInfoVO.getDesc30()).append("\n");	//확인
						flatFile.append("}DESC").append("\n");
					}

					// (5) Mark 정보
					myanmarManifestMarkInfoVO = dbDao.searchMarkInfo(myanmarBlInputList.get(blSeIdx));

					if(myanmarManifestMarkInfoVO != null){
						flatFile.append("{MARK").append("\n");
						flatFile.append("MARKNO1:")			.append(myanmarManifestMarkInfoVO.getMark1()).append("\n");
						flatFile.append("MARKNO2:")			.append(myanmarManifestMarkInfoVO.getMark2()).append("\n");
						flatFile.append("MARKNO3:")			.append(myanmarManifestMarkInfoVO.getMark3()).append("\n");
						flatFile.append("MARKNO4:")			.append(myanmarManifestMarkInfoVO.getMark4()).append("\n");
						flatFile.append("MARKNO5:")			.append(myanmarManifestMarkInfoVO.getMark5()).append("\n");
						flatFile.append("MARKNO6:")			.append(myanmarManifestMarkInfoVO.getMark6()).append("\n");
						flatFile.append("MARKNO7:")			.append(myanmarManifestMarkInfoVO.getMark7()).append("\n");
						flatFile.append("MARKNO8:")			.append(myanmarManifestMarkInfoVO.getMark8()).append("\n");
						flatFile.append("MARKNO9:")			.append(myanmarManifestMarkInfoVO.getMark9()).append("\n");
						flatFile.append("MARKNO10:")		.append(myanmarManifestMarkInfoVO.getMark10()).append("\n");
						flatFile.append("}MARK").append("\n");
					}


					// (6) Location 정보

					String vvdCnt = dbDao.searchVVDCnt(myanmarBlInputList.get(blSeIdx).getBkgNo());
					myanmarLocInfoList = dbDao.searchLocInfo(myanmarBlInputList.get(blSeIdx), vvdCnt);

					//[CHM-201221941] 미얀마 세관 EDI 기능 수정 요청
					String spcLoc = "";	// POL이 SGSIN, MYPKG일 케이스에 특별한 정보를 넣기 위한 변수
					for( locIdx = 0; locIdx < myanmarLocInfoList.size(); locIdx++)
					{
						flatFile.append("{LOC_INFO").append("\n");
						flatFile.append("LOC_TYPE:")		.append(myanmarLocInfoList.get(locIdx).getLocType()).append("\n");
						flatFile.append("LOC_CD:")			.append(myanmarLocInfoList.get(locIdx).getLocCd()).append("\n");
						flatFile.append("LOC_NM:")			.append(myanmarLocInfoList.get(locIdx).getLocNm()).append("\n");
						flatFile.append("}LOC_INFO").append("\n");
						if("PL".equals(myanmarLocInfoList.get(locIdx).getLocType())){
							spcLoc = myanmarLocInfoList.get(locIdx).getLocCd();
						}
					}

					// (7) Customer 정보
					myanmarBlInputList.get(0).setUsrId(account.getUsr_id());

//					String spcLoc = myanmarLocInfoList.get(locIdx).getLocCd();
					myanmarCustomerInfoList = dbDao.searchCustomerInfo(myanmarBlInputList.get(blSeIdx), spcLoc, vvdCnt);
					for( custIdx = 0; custIdx < myanmarCustomerInfoList.size(); custIdx++)
					{
						flatFile.append("{CUSTOMER_INFO").append("\n");
						flatFile.append("CUSTOMER_TYPE:")	.append(myanmarCustomerInfoList.get(custIdx).getCustomerType()).append("\n");
						flatFile.append("CUSTOMER_NM:")	.append(myanmarCustomerInfoList.get(custIdx).getCustomerNm1()).append("\n");
						flatFile.append("CUSTOMER_ADDR1:")	.append(myanmarCustomerInfoList.get(custIdx).getCustomerAddr1()).append("\n");
						flatFile.append("CUSTOMER_ADDR2:")	.append(myanmarCustomerInfoList.get(custIdx).getCustomerAddr2()).append("\n");
						flatFile.append("CUSTOMER_ADDR3:")	.append(myanmarCustomerInfoList.get(custIdx).getCustomerAddr3()).append("\n");
						flatFile.append("CUSTOMER_ADDR4:")	.append("").append("\n");
						flatFile.append("}CUSTOMER_INFO").append("\n");
					}

					for( cntrIdx = blSeIdx; cntrIdx < myanmarBlInputList.size(); cntrIdx++) {
						if ( myanmarBlInputList.get(blSeIdx).getBlNo().equals(myanmarBlInputList.get(cntrIdx).getBlNo())){
							// (8) Container 정보
							myanmarCntrInputList = dbDao.searchContainerInfo(myanmarBlInputList.get(cntrIdx));

							flatFile.append("{CNTR_INFO").append("\n");
							flatFile.append("CNTRNBR:")			.append(myanmarCntrInputList.getCntrNbr()).append("\n");
							flatFile.append("CNTRTYPE:")		.append(myanmarCntrInputList.getCntrType()).append("\n");
							flatFile.append("CNTR_MVMT_TYPE:")	.append(myanmarCntrInputList.getCntrMvmtType()).append("\n"); //확인
							flatFile.append("CNTR_FM_IND:")		.append(myanmarCntrInputList.getCntrFmInd()).append("\n");
							flatFile.append("CNTR_PKG:")		.append(myanmarCntrInputList.getPckQty()).append("\n");	//확인
							flatFile.append("CNTR_PKG_CD:")		.append(myanmarCntrInputList.getPckTpCd()).append("\n");	//확인
							flatFile.append("CNTR_G_WGT:")		.append(myanmarCntrInputList.getCntrGWgt()).append("\n");
							flatFile.append("CNTR_G_WGT_UNIT:")	.append(myanmarCntrInputList.getCntrGWgtUnit()).append("\n");
							flatFile.append("CNTR_T_WGT:")		.append(myanmarCntrInputList.getCntrTWgt()).append("\n");
							flatFile.append("CNTR_T_WGT_UNIT:")	.append(myanmarCntrInputList.getCntrTWgtUnit()).append("\n");
							flatFile.append("CNTR_EQ_SUP_CD:")	.append(myanmarCntrInputList.getCntrEqSupCd()).append("\n");	//확인
							// (10) Container Seal 정보
							myanmarCntrSealNoInfoList = dbDao.searchCntrSealNoInfo(myanmarBlInputList.get(cntrIdx));
							if(myanmarCntrSealNoInfoList.size()>0){
								flatFile.append("SEALNBR:")			.append(myanmarCntrSealNoInfoList.get(sealIdx).getSealnbr()).append("\n");
							}else{
								flatFile.append("SEALNBR:").append("\n");
							}
							flatFile.append("}CNTR_INFO").append("\n");
							blIdx++;
						}
					}
					blSeIdx = blSeIdx + blIdx - 1;
					blIdx = 0;
					flatFile.append("}BL_INFO").append("\n");
				} // end for (BL)

				// send Flat File log VO 셋팅
				BkgCstmsMySndLogVO bkgCstmsMySndLogVO = new BkgCstmsMySndLogVO(); // send
				// 전송로그를 저장한다. (MASTER)
				for (blSeIdx=0; blSeIdx<myanmarBlInputList.size(); blSeIdx++) {
					bkgCstmsMySndLogVO.setMmMfSndIndCd(myanmarBlInputList.get(0).getTrsmSts());
					bkgCstmsMySndLogVO.setFltFileRefNo(flatFileRefNo);
					bkgCstmsMySndLogVO.setVvd(myanmarBlInputList.get(0).getVvd());
					if ( "1".equals(myanmarManifestListCondVO.getPolGubun())) {
						bkgCstmsMySndLogVO.setPolCd(myanmarManifestListCondVO.getFrmPortCd());
						bkgCstmsMySndLogVO.setCstmsBndCd("O");
					} else {
						bkgCstmsMySndLogVO.setPodCd(myanmarManifestListCondVO.getFrmPortCd());
						bkgCstmsMySndLogVO.setCstmsBndCd("I");
					}
					bkgCstmsMySndLogVO.setOfcCd(account.getOfc_cd());
					bkgCstmsMySndLogVO.setBkgNo(myanmarBlInputList.get(blSeIdx).getBkgNo());
					bkgCstmsMySndLogVO.setCntrNo(myanmarBlInputList.get(blSeIdx).getCntrNo());
					bkgCstmsMySndLogVO.setUsrId(account.getUsr_id());
					bkgCstmsMySndLogVO.setSndDt(sndDt);
	
					if(bkgCstmsMySndLogVO != null) {
						dbDao.addCUSCARSndLog(bkgCstmsMySndLogVO);
					}
				}
			}

			BkgCstmsMySndLogDtlVO bkgCstmsMySndLogDtlVO = new BkgCstmsMySndLogDtlVO(); // send
			//FlatFile을 4000Byte씩 나눈다 - start (100Byte의 여유를 주기 위해 3900Byte로 나눔)
			int divisor = 3900;
			int totLength = flatFile.length();
			int quotient = totLength / divisor;
			int remainder = totLength % divisor;

			int loopCnt = 0;
			int start = 0;
			int end = 0;

			if(remainder > 0) {
				loopCnt = quotient + 1;
			} else {
				loopCnt = quotient;
			}


			String[] fFiles = new String[loopCnt];
			for(int i = 0; i < loopCnt; i++) {
				if(i == loopCnt-1) {
					end = remainder;
				} else {
					end = divisor;
				}

				start = i * divisor;
				fFiles[i] = flatFile.substring(start, start+end);

				bkgCstmsMySndLogDtlVO.setMyMfSndIndCd(myanmarVslInfoVO.getStatus());
				bkgCstmsMySndLogDtlVO.setFltFileRefNo(flatFileRefNo);
				bkgCstmsMySndLogDtlVO.setLogDtlSeq(Integer.toString(i+1));
				bkgCstmsMySndLogDtlVO.setEdiSndMsg(fFiles[i]);
				bkgCstmsMySndLogDtlVO.setUsrId(account.getUsr_id());
				bkgCstmsMySndLogDtlVO.setSndDt(sndDt);

				// 전송로그를 저장한다. (DETAIL)
				if( bkgCstmsMySndLogDtlVO != null ){
					dbDao.addCUSCARSndDtlLog(bkgCstmsMySndLogDtlVO);
				}

//				bkgCstmsMySndLogDtlList.add(bkgCstmsMySndLogDtlVO);
//				log.debug("abc_before["+i+"] ="+bkgCstmsMySndLogDtlList.get(i).getLogDtlSeq());
			}

//			log.debug("abc_after[0] ="+bkgCstmsMySndLogDtlList.get(0).getLogDtlSeq());
//			log.debug("abc_after[1] ="+bkgCstmsMySndLogDtlList.get(1).getLogDtlSeq());
//			log.debug("abc_after[2] ="+bkgCstmsMySndLogDtlList.get(2).getLogDtlSeq());

//			// 전송로그를 저장한다. (DETAIL)
//			if(bkgCstmsMySndLogDtlList != null) {
//				dbDao.addCUSCARSndDrlLog(bkgCstmsMySndLogDtlList);
//			}

			// flatFile MQ로 전송
			// 추후 수정하고 MQ ID 재등록 할 것
			//ediSendMessage(flatFile.toString(), "BKG.OPUSBKG_UBIZCOM_SLKMFT.IBMMQ.QUEUE");
			ediSendMessage(flatFile.toString(), "BKG.OPUSBKG_UBIZHJS_SLKMFT.IBMMQ.QUEUE");

		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
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
			if (flatFile != null && flatFile.trim().length() > 1) {
			  SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			  sendFlatFileVO.setFlatFile(flatFile);
			  sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get(queueName));
			  BookingUtil utilCommand = new BookingUtil();
			  FlatFileAckVO flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
			  if (flatFileAckVO.getAckStsCd().equals("E"))
				throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
			}
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}


	/**
	 * BackEndJob을 실행.(CTA)
	 *
	 * @param account
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, ManifestTransmitVO[] manifestTransmitVOs, String pgmNo)  throws EventException{

		MyanmarCustomsTransmissionBackEndJob backEndJob = new MyanmarCustomsTransmissionBackEndJob ();
		backEndJob.setPgmNo(pgmNo);
		String resultStr = "";

		if(pgmNo.equals("ESM_BKG_1155")) {
			backEndJob.setManifestTransmitVOs(manifestTransmitVOs);
			backEndJob.setAccount(account);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			resultStr = backEndJobManager.execute(backEndJob , account.getUsr_id(), "Myanmar EDI Transmit");
		}

		return resultStr;
	}

}
