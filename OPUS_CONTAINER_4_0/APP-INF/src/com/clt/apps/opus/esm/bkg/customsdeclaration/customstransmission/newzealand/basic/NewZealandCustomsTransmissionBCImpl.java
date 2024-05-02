/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : NewZealandCustomsTransmissionBCImpl.java
*@FileTitle : NewZealandCustomsTransmissionBCImpl
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.integration.NewZealandCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestCntrSealNoInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestCustomerInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestDescInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestDgGoodsInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestErrorReportVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestGoodsInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestListBlEtcInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestListCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestListConVoyInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestListVslInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestLocInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestMarkInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestSndLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsMfDtl2VO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsVvdInfoCondVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-NewZealandCustomsTransmission Business Logic Command implementation<br>
 * - OPUS-NewZealandCustomsTransmission handling business logic<br>
 *
 * @author
 * @see Related DAO class
 * @since J2EE 1.6
 */
public class NewZealandCustomsTransmissionBCImpl extends BasicCommandSupport implements NewZealandCustomsTransmissionBC {

	// Database Access Object
	private transient NewZealandCustomsTransmissionDBDAO dbDao = null;

	private static final int DESC_CNT_LIMIT  =  175;
	private static final int DESC_CNT_LOOP_CNT  =  99;

	/**
	 * NewZealandCustomsTransmissionBCImpl 객체 생성<br>
	 * NewZealandCustomsTransmissionDBDAO 생성한다.<br>
	 */
	public NewZealandCustomsTransmissionBCImpl() {
		dbDao = new NewZealandCustomsTransmissionDBDAO();
	}

	/**
	 * NewZealand 세관에 적하목록 신고를 EDI를 통해 전송
	 *
	 * @param NewZealandManifestVO newZealandManifestVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifest(NewZealandManifestVO newZealandManifestVO, SignOnUserAccount account) throws EventException {

		BookingUtil		bookingUtil		= new BookingUtil();

		// FLATFILE
		String flatFileHeader = null;
		String flatFileRefNo = null;
		StringBuffer flatFile = new StringBuffer();

		//조회 조건
		NewZealandCstmsVvdInfoCondVO	newZealandCondVO 			= newZealandManifestVO.getNewZealandCstmsVvdInfoCondVO();
		//B/L Input 정보
		NewZealandCstmsMfDtl2VO[]		newZealandCstmsMfDtl2VOs	= newZealandManifestVO.getNewZealandCstmsMfDtl2VOs();

		// -- Output 정보 -- //
		//////////////////////////////////////////////////////////////////////////////////////////////////
		//Container 정보
		List<NewZealandManifestListCntrInfoVO> 		newZealandCntrInputList = null;
		// Description 정보
		List<NewZealandManifestDescInfoVO>  		newZealandCmDescInfoList = null;
		// Mark 정보
		List<NewZealandManifestMarkInfoVO> 			newZealandCmMarkInfoList 		= null;
		// Bl  정보
		List<NewZealandManifestBlInfoVO> 			newZealandBlList 		= null;
		// Goods 정보
		List<NewZealandManifestGoodsInfoVO> 		newZealandGoodsInfoList 	= null;

		//내림차순 정렬을 위한 일회성 정보
		NewZealandCstmsMfDtl2VO temp = null;

		// -- For문 Index -- //
		int blIdx 	= 0;
		int cntrIdx = 0;
		int blSeIdx = 0;
		int blThIdx =0;
		int logSeq = 0;
		int totContainer = 0;
		int totCnmtCnt = 0;

		String mark = "";
		int markLoopCnt = 0;

		try {

			// Body 생성
			if( newZealandCstmsMfDtl2VOs != null ){
				// Header 생성
				flatFileHeader = bookingUtil.searchCstmsEdiHeaderNew("NZ_CUSCAR");
				flatFile.append(flatFileHeader).append("\n");

				if (blIdx == 0) {
					flatFileRefNo = flatFileHeader.substring(62).trim();
				}

				// (1) VSL 정보
				//String issueDate = "";
				String vslLloydNo = "";
				String vslCallsign = "";
				String vslNationCd = "";
				String vslName = "";
				NewZealandManifestListVslInfoVO mxEtaInfoVO = dbDao.searchVslInfo(newZealandCondVO.getVvd());
				if(mxEtaInfoVO != null) {
					//issueDate = mxEtaInfoVO.getIssueDate();
					vslLloydNo = mxEtaInfoVO.getVslLloydNo();
					vslCallsign = mxEtaInfoVO.getVslCallsign();
					vslNationCd = mxEtaInfoVO.getVslNationCd();
					vslName = mxEtaInfoVO.getVslName();
				}


				String sKind = newZealandCstmsMfDtl2VOs[blIdx].getKind();
				String eciNo="";
				if (!"9".equals(sKind)) {
					eciNo = newZealandCstmsMfDtl2VOs[0].getMrnNo();
				}

				NewZealandManifestListBlEtcInfoVO blEtcVO = dbDao.searchBlEtcInfo(newZealandCstmsMfDtl2VOs[cntrIdx]);

				if("NZ".equals(newZealandCondVO.getPod())){
					newZealandCondVO.setPod(newZealandCstmsMfDtl2VOs[0].getVvdPodCd());
				}
				NewZealandManifestListConVoyInfoVO conVoyInfoVO = dbDao.getConsVoy(newZealandCondVO);

				flatFile.append("MSG_TYPE:")		.append("785").append("\n");
				flatFile.append("STATUS:")			.append(sKind).append("\n");
				flatFile.append("ECI_NO:")			.append(eciNo).append("\n");
				//flatFile.append("REMARKS:")			.append("").append("\n"); // 확인
				//flatFile.append("ISSUE_DATE:")		.append(issueDate).append("\n");
				flatFile.append("VSL_CODE:")		.append(newZealandCondVO.getVvd().substring(0, 4)).append("\n");
				flatFile.append("VOYAGE:")			.append(newZealandCondVO.getVvd().substring(4, 9)).append("\n");
				flatFile.append("CON_VOYAGE:")		.append(conVoyInfoVO.getConsVoy()).append("\n");
				flatFile.append("VSL_NAME:")		.append(vslName).append("\n");
				flatFile.append("VSL_LLOYD_NO:")	.append(vslLloydNo).append("\n");
				flatFile.append("VSL_CALLSIGN:")	.append(vslCallsign).append("\n");
				flatFile.append("VSL_NATION_CD:")	.append(vslNationCd).append("\n");
				flatFile.append("PORT:")			.append(newZealandCondVO.getPod()).append("\n");
				flatFile.append("PORT_NM:")			.append(dbDao.searchPortNm(newZealandCondVO.getPod())).append("\n");
				//flatFile.append("POD_SFX:")			.append("").append("\n"); //확인
				//flatFile.append("POL_SFX:")			.append("").append("\n"); //확인
				flatFile.append("EX_IND:")			.append("I").append("\n"); //확인
				flatFile.append("FP_IND:")			.append(blEtcVO.getFpInd()).append("\n");
				flatFile.append("ETA:")				.append(conVoyInfoVO.getVpsEtaDt()).append("\n");//확인
				flatFile.append("ETD:")				.append("").append("\n");//확인

				// CNTR 별로 내림차순 정렬
				for(int i=0; i<newZealandCstmsMfDtl2VOs.length; i++) {
					for(int j=0; j<newZealandCstmsMfDtl2VOs.length; j++) {
						if(newZealandCstmsMfDtl2VOs[i].getCntrNo().compareTo(newZealandCstmsMfDtl2VOs[j].getCntrNo()) > 0){
							temp = newZealandCstmsMfDtl2VOs[i];
							newZealandCstmsMfDtl2VOs[i] = newZealandCstmsMfDtl2VOs[j];
							newZealandCstmsMfDtl2VOs[j] = temp;
						}
					}
				}

				for(int totCnmtIdx=0; totCnmtIdx<newZealandCstmsMfDtl2VOs.length; totCnmtIdx++){
					// 동일 container 정보 스킵
					if(totCnmtIdx > 0){
						if(newZealandCstmsMfDtl2VOs[totCnmtIdx].getCntrNo().equals(newZealandCstmsMfDtl2VOs[totCnmtIdx-1].getCntrNo())) continue;
					}
					totContainer++;
				}
				flatFile.append("TOT_CNTR:")		.append(totContainer).append("\n");

				// BL 별로 내림차순 정렬
				for(int i=0; i<newZealandCstmsMfDtl2VOs.length; i++) {
					for(int j=0; j<newZealandCstmsMfDtl2VOs.length; j++) {
						if (newZealandCstmsMfDtl2VOs[i].getBlNo().compareTo(newZealandCstmsMfDtl2VOs[j].getBlNo()) > 0){
							temp = newZealandCstmsMfDtl2VOs[i];
							newZealandCstmsMfDtl2VOs[i] = newZealandCstmsMfDtl2VOs[j];
							newZealandCstmsMfDtl2VOs[j] = temp;
						}
					}
				}

				for(int totCnmtIdx = 0; totCnmtIdx < newZealandCstmsMfDtl2VOs.length; totCnmtIdx++){
					// 동일 BL 스킵 : container 여러 건 화면에서 넘어와 있어서 동일 BL 정보 스킵
					if(totCnmtIdx > 0){
						if(newZealandCstmsMfDtl2VOs[totCnmtIdx].getBlNo().equals(newZealandCstmsMfDtl2VOs[totCnmtIdx-1].getBlNo())) continue;
					}
					totCnmtCnt++;
				}
				flatFile.append("TOT_CNMT:")			.append(totCnmtCnt).append("\n");//확인

				//log.debug("============================POL_GUBUN"+newZealandBlInputList.get(blIdx).getPolGubun());

				// (4) B/L 정보
				for(blThIdx = 0; blThIdx < newZealandCstmsMfDtl2VOs.length; blThIdx++){
					//동일 BL 스킵 : container 여러 건 화면에서 넘어와 있어서 동일 BL 정보 스킵
					if (blThIdx > 0) {
						if(newZealandCstmsMfDtl2VOs[blThIdx].getBlNo().equals(newZealandCstmsMfDtl2VOs[blThIdx-1].getBlNo())) continue;
					}
					newZealandCstmsMfDtl2VOs[blThIdx].setVvd(newZealandCondVO.getVvd());
					newZealandBlList = dbDao.searchBlInfo(newZealandCstmsMfDtl2VOs[blThIdx]);
					blSeIdx++;
					flatFile.append("{BL_INFO").append("\n");
					flatFile.append("LOOP_IND:")		.append(blSeIdx).append("\n"); //확인
					flatFile.append("BLNBR:")			.append(newZealandBlList.get(0).getBlNo()).append("\n");
					flatFile.append("BKGNBR:")			.append(newZealandBlList.get(0).getBkgNo()).append("\n");
					flatFile.append("TR_IND:")			.append(newZealandBlList.get(0).getTrInd()).append("\n");
					//flatFile.append("PRE_CARR_IND:")	.append("").append("\n"); //확인
					//flatFile.append("FREIGHT:")	        .append("").append("\n"); //확인
					//flatFile.append("FREIGHT_CURR_CD:")	.append("").append("\n"); //확인
					//flatFile.append("TRANS_DUR:")	    .append("").append("\n"); //확인

					// (8) Description 정보(최대 350자 70자식 4번 반복)
					for (NewZealandManifestDescInfoVO newZealandManifestDescInfoVO : dbDao.searchDescInfo(newZealandCstmsMfDtl2VOs[blThIdx])) {    //반복 확인하기
						// 전체길이 - (전체길이%70) / 70+1;
						String desc = newZealandManifestDescInfoVO.getDescription();
						int descLen = desc.length();
						if (descLen < 71) {
							flatFile.append("{DESC").append("\n");
							flatFile.append("DESC:").append(desc.substring(0)).append("\n");
							flatFile.append("}DESC").append("\n");
						} else {
							int loopCount = (descLen - (descLen % 70)) / 70;
							for (int k = 0; k < loopCount; k++) {
								flatFile.append("{DESC").append("\n");
								flatFile.append("DESC:").append(desc.substring((k * 70), (k + 1) * 70)).append("\n");
								flatFile.append("}DESC").append("\n");
							}
							flatFile.append("{DESC").append("\n");
							flatFile.append("DESC:").append(desc.substring(loopCount * 70)).append("\n");
							flatFile.append("}DESC").append("\n");
						}
					}

					// (9) Mark 정보
					for (NewZealandManifestMarkInfoVO newZealandManifestMarkInfoVO : dbDao.searchMarkInfo(newZealandCstmsMfDtl2VOs[blThIdx])) {
						mark = newZealandManifestMarkInfoVO.getMark1().replaceAll("\\r\\n|\\n\\r|\\n|\\r", "☜#☞");
						String[] str1 = mark.split("☜#☞");
						for(int idx=0; idx < str1.length; idx++) {
							while(str1[idx].length() > DESC_CNT_LIMIT ){
								flatFile.append("{MARK").append("\n");
								flatFile.append("MARK:").append(str1[idx].substring(0, DESC_CNT_LIMIT)).append("\n");
								flatFile.append("}MARK").append("\n");
								str1[idx] = str1[idx].substring(DESC_CNT_LIMIT);
								markLoopCnt++;
								if(markLoopCnt >= DESC_CNT_LOOP_CNT){
									break;
								}
							}
							if(markLoopCnt >= DESC_CNT_LOOP_CNT){
								break;
							}
							flatFile.append("{MARK").append("\n");
							flatFile.append("MARK:").append(str1[idx]).append("\n");
							flatFile.append("}MARK").append("\n");
							markLoopCnt++;
						}
					}

					// (5) Location 정보
					for (NewZealandManifestLocInfoVO newZealandManifestLocInfoVO : dbDao.searchLocInfo(newZealandCstmsMfDtl2VOs[blThIdx])) {
						flatFile.append("{LOC_INFO").append("\n");
						flatFile.append("LOC_TYPE:")		.append(newZealandManifestLocInfoVO.getLocType()).append("\n");
						flatFile.append("LOC_CD:")			.append(newZealandManifestLocInfoVO.getLocCd()).append("\n");
						flatFile.append("LOC_NM:")			.append(newZealandManifestLocInfoVO.getLocNm()).append("\n");
						flatFile.append("}LOC_INFO").append("\n");
					}

					// (6) Customer 정보
					for(NewZealandManifestCustomerInfoVO newZealandManifestCustomerInfoVO : dbDao.searchCustomerInfo(newZealandCstmsMfDtl2VOs[blThIdx], account)) {    // 반복 확인
						flatFile.append("{CUSTOMER_INFO").append("\n");
						flatFile.append("CUSTOMER_TYPE:")	.append(newZealandManifestCustomerInfoVO.getCustomerType()).append("\n");
						flatFile.append("CUSTOMER_CD:")		.append(newZealandManifestCustomerInfoVO.getCustomerCd()).append("\n");
						flatFile.append("CUSTOMER_NM1:")	.append(newZealandManifestCustomerInfoVO.getCustomerNm1()).append("\n");
						flatFile.append("CUSTOMER_NM2:")	.append(newZealandManifestCustomerInfoVO.getCustomerNm2()).append("\n");
						flatFile.append("CUSTOMER_ADDR1:")	.append(newZealandManifestCustomerInfoVO.getCustomerAddr1()).append("\n");
						flatFile.append("CUSTOMER_ADDR2:")	.append(newZealandManifestCustomerInfoVO.getCustomerAddr2()).append("\n");
						flatFile.append("CUSTOMER_ADDR3:")	.append(newZealandManifestCustomerInfoVO.getCustomerAddr3()).append("\n");
						//flatFile.append("CONTACT_NM:")		.append(newZealandManifestCustomerInfoVO.getContactNm()).append("\n");
						//flatFile.append("CONTACT_TEL:")		.append(newZealandManifestCustomerInfoVO.getContactTel()).append("\n");
						//flatFile.append("CONTACT_FAX:")		.append(newZealandManifestCustomerInfoVO.getContactFax()).append("\n");
						//flatFile.append("CONTACT_EMAIL:")	.append(newZealandManifestCustomerInfoVO.getContactEmail()).append("\n");
						flatFile.append("}CUSTOMER_INFO").append("\n");
					}

					for(int cIdx = 0; cIdx < newZealandCstmsMfDtl2VOs.length; cIdx++) {
						if(newZealandCstmsMfDtl2VOs[cIdx].getBlNo().equals(newZealandCstmsMfDtl2VOs[blThIdx].getBlNo())){

							newZealandCntrInputList = new ArrayList<NewZealandManifestListCntrInfoVO>();
							newZealandCntrInputList = dbDao.searchContainerInfo(newZealandCstmsMfDtl2VOs[cIdx]);

							flatFile.append("{CNTR_INFO").append("\n");
							flatFile.append("CNTRNBR:")			.append(newZealandCntrInputList.get(0).getCntrnbr()).append("\n");
							flatFile.append("CNTRSIZE:")		.append(newZealandCntrInputList.get(0).getCntrsize()).append("\n");
							flatFile.append("CNTRTYPE:")		.append(newZealandCntrInputList.get(0).getCntrtype()).append("\n");
							flatFile.append("CNTR_SUPL_CD:")	.append("").append("\n"); //확인
							flatFile.append("CNTR_FM_IND:")		.append(newZealandCntrInputList.get(0).getCntrFmInd()).append("\n");
							//flatFile.append("CNTR_DEL_TERM:")	.append("").append("\n"); //확인
							//flatFile.append("CNTR_VAN_TP_CD:")	.append("").append("\n"); //확인
							flatFile.append("CNTR_G_WGT:")		.append(newZealandCntrInputList.get(0).getCntrGWgt()).append("\n");
							flatFile.append("CNTR_G_WGT_UNIT:")	.append(newZealandCntrInputList.get(0).getCntrGWgtUnit()).append("\n");
							flatFile.append("CNTR_T_WGT:")		.append(newZealandCntrInputList.get(0).getCntrTWgt()).append("\n");
							flatFile.append("CNTR_T_WGT_UNIT:")	.append(newZealandCntrInputList.get(0).getCntrTWgtUnit()).append("\n");
							flatFile.append("CNTR_TMP:")		.append(newZealandCntrInputList.get(0).getCntrTmp()).append("\n");
							flatFile.append("CNTR_TMP_UNIT:")	.append(newZealandCntrInputList.get(0).getCgoTmpUnit()).append("\n");
							flatFile.append("CNTR_PRHB_IND:")	.append("").append("\n"); //확인
							flatFile.append("CNTR_QRT_IND:")	.append("").append("\n"); //확인
							// (3) Container Seal 정보
							for(NewZealandManifestCntrSealNoInfoVO newZealandManifestCntrSealNoInfoVO : dbDao.searchCntrSealNoInfo(newZealandCstmsMfDtl2VOs[cIdx])) {    //반복 확인하기
								flatFile.append("{CNTR_SEAL_NO").append("\n");
								flatFile.append("SEALNBR:")	    .append(newZealandManifestCntrSealNoInfoVO.getSealnbr()).append("\n");
								flatFile.append("}CNTR_SEAL_NO").append("\n");
							}

							// (7) Goods 정보
							newZealandGoodsInfoList = dbDao.searchGoodsInfo(newZealandCstmsMfDtl2VOs[cIdx]);
							if (newZealandGoodsInfoList.size() > 0) {
								for (NewZealandManifestGoodsInfoVO newZealandManifestGoodsInfoVO : newZealandGoodsInfoList) {
									flatFile.append("{GOODS_INFO").append("\n");
									flatFile.append("CMPKG:")				.append(newZealandManifestGoodsInfoVO.getBlpkg()).append("\n"); 
									flatFile.append("CMPKGU:")				.append(newZealandManifestGoodsInfoVO.getBlpkgu()).append("\n");
									flatFile.append("CMWGT:")				.append(newZealandManifestGoodsInfoVO.getBlwgt()).append("\n");
									flatFile.append("CMWGT_UNIT:")			.append(newZealandManifestGoodsInfoVO.getBlwgtUnit()).append("\n");
									flatFile.append("CMNET_WGT:")			.append("").append("\n"); //확인
									flatFile.append("CMNET_WGT_UNIT:")		.append("").append("\n"); //확인
									//flatFile.append("CMVOL:")				.append("").append("\n"); //확인
									//flatFile.append("CMVOL_UNIT:")			.append("").append("\n"); //확인
									flatFile.append("CMMEA:")				.append(newZealandManifestGoodsInfoVO.getBlmea()).append("\n");
									flatFile.append("CMMEA_UNIT:")			.append(newZealandManifestGoodsInfoVO.getBlmeaUnit()).append("\n");
									//flatFile.append("VALUE:")			    .append("").append("\n"); //확인
									//flatFile.append("VALUE_CURR:")			.append("").append("\n"); //확인
									flatFile.append("COMMODITY_CD:")		.append("").append("\n"); //확인
									flatFile.append("ORG_CNT_CD:")			.append("").append("\n"); //확인
									flatFile.append("ORG_LOC_CD:")			.append("").append("\n"); //확인

									// (8) Description 정보(최대 350자 70자식 5번 반복)
									newZealandCmDescInfoList = dbDao.searchCmDescInfo(newZealandCstmsMfDtl2VOs[cIdx]);//반복 확인하기
									if (newZealandCmDescInfoList.size() > 0) {
										for (NewZealandManifestDescInfoVO newZealandManifestDescInfoVO : newZealandCmDescInfoList) {
											// 전체길이 - (전체길이%70) / 70+1;
											String desc = newZealandManifestDescInfoVO.getDescription();
											int descLen = desc.length();
											if (descLen < 71) {
												flatFile.append("{CM_DESC").append("\n");
												flatFile.append("CM_DESC:").append(desc.substring(0)).append("\n");
												flatFile.append("}CM_DESC").append("\n");
											} else {
												int loopCount = (descLen - (descLen % 70)) / 70;
												for (int k = 0; k < loopCount; k++) {
													flatFile.append("{CM_DESC").append("\n");
													flatFile.append("CM_DESC:").append(desc.substring((k * 70), (k + 1) * 70)).append("\n");
													flatFile.append("}CM_DESC").append("\n");
												}
												flatFile.append("{CM_DESC").append("\n");
												flatFile.append("CM_DESC:").append(desc.substring(loopCount * 70)).append("\n");
												flatFile.append("}CM_DESC").append("\n");
											}
										}
									} else {
										flatFile.append("{CM_DESC").append("\n");
										flatFile.append("CM_DESC:").append("\n");
										flatFile.append("}CM_DESC").append("\n");
									}

									// (9) Mark 정보
									newZealandCmMarkInfoList = dbDao.searchCmMarkInfo(newZealandCstmsMfDtl2VOs[cIdx]);
									if (newZealandCmMarkInfoList.size() > 0) {
										for (NewZealandManifestMarkInfoVO newZealandManifestMarkInfoVO : newZealandCmMarkInfoList) {
											mark = newZealandManifestMarkInfoVO.getMark1().replaceAll("\\r\\n|\\n\\r|\\n|\\r", "☜#☞");
											String[] str1 = mark.split("☜#☞");
											for(int idx=0; idx < str1.length; idx++) {
												while(str1[idx].length() > DESC_CNT_LIMIT ){
													flatFile.append("{CM_MARK").append("\n");
													flatFile.append("CM_MARK:").append(str1[idx].substring(0, DESC_CNT_LIMIT)).append("\n");
													flatFile.append("}CM_MARK").append("\n");
													str1[idx] = str1[idx].substring(DESC_CNT_LIMIT);
													markLoopCnt++;
													if(markLoopCnt >= DESC_CNT_LOOP_CNT){
														break;
													}
												}
												if(markLoopCnt >= DESC_CNT_LOOP_CNT){
													break;
												}
												flatFile.append("{CM_MARK").append("\n");
												flatFile.append("CM_MARK:").append(str1[idx]).append("\n");
												flatFile.append("}CM_MARK").append("\n");
												markLoopCnt++;
											}
										}
										flatFile.append("}GOODS_INFO").append("\n");
									} else {
										flatFile.append("{CM_MARK").append("\n");
										flatFile.append("CM_MARK:").append("\n");
										flatFile.append("}CM_MARK").append("\n");
									}
								}

							// Goods 정보가 없을때
							} else {
								flatFile.append("{GOODS_INFO").append("\n");
								flatFile.append("CMPKG:0").append("\n");    // MT일때 0이 기본값
								flatFile.append("CMPKGU:").append("\n");
								flatFile.append("CMWGT:").append("\n");
								flatFile.append("CMWGT_UNIT:").append("\n");
								flatFile.append("CMNET_WGT:").append("\n");
								flatFile.append("CMNET_WGT_UNIT:").append("\n");
								//flatFile.append("CMVOL:").append("\n");
								//flatFile.append("CMVOL_UNIT:").append("\n");
								flatFile.append("CMMEA:").append("\n");
								flatFile.append("CMMEA_UNIT:").append("\n");
								//flatFile.append("VALUE:").append("\n");
								//flatFile.append("VALUE_CURR:").append("\n");
								flatFile.append("COMMODITY_CD:").append("\n");
								flatFile.append("ORG_CNT_CD:").append("\n");
								flatFile.append("ORG_LOC_CD:").append("\n");
									flatFile.append("{CM_DESC").append("\n");
									flatFile.append("CM_DESC:").append("\n");
									flatFile.append("}CM_DESC").append("\n");
									flatFile.append("{CM_MARK").append("\n");
									flatFile.append("CM_MARK:").append("\n");
									flatFile.append("}CM_MARK").append("\n");
								flatFile.append("}GOODS_INFO").append("\n");
							}

							// (7) Danger Goods 정보
							for (NewZealandManifestDgGoodsInfoVO newZealandManifestDgGoodsInfoVO : dbDao.searchDgGoodsInfo(newZealandCstmsMfDtl2VOs[cIdx])){
								flatFile.append("{DANGER_GOODS").append("\n");
								flatFile.append("IMO_CLASS_NO:")		.append(newZealandManifestDgGoodsInfoVO.getImoClassNo()).append("\n");
								flatFile.append("IMO_PAGE_NO:")			.append(newZealandManifestDgGoodsInfoVO.getImoPageNo()).append("\n");
								flatFile.append("HAZARD_CD:")			.append(newZealandManifestDgGoodsInfoVO.getHazardCd()).append("\n");
								flatFile.append("UNDG_NO:")				.append("").append("\n"); //확인
								flatFile.append("FLASH_POINT:")			.append(newZealandManifestDgGoodsInfoVO.getFlashPoint()).append("\n");
								flatFile.append("FLASH_POINT_UNIT:")	.append(newZealandManifestDgGoodsInfoVO.getFlashPointUnit()).append("\n");
								flatFile.append("PACKING_GROUP:")		.append(newZealandManifestDgGoodsInfoVO.getPackingGroup()).append("\n");
								flatFile.append("}DANGER_GOODS").append("\n");
							}
							flatFile.append("}CNTR_INFO").append("\n");


							NewZealandManifestSndLogVO newZealandManifestSndLogVO = new NewZealandManifestSndLogVO();

							String sendDate = bookingUtil.searchLocalTime(account.getCnt_cd() + account.getOfc_cd().substring(0, 3));
							logSeq = dbDao.searchSendLogSeq(sendDate, "NZL");

							newZealandManifestSndLogVO.setNzlSndLogId("NZL");
							newZealandManifestSndLogVO.setMsgSndNo(flatFileHeader.substring(36, 36)+flatFileRefNo + cIdx);//확인
							newZealandManifestSndLogVO.setSndDt(sendDate);
							newZealandManifestSndLogVO.setOfcCd(account.getOfc_cd());

							if (logSeq == 0) {
								newZealandManifestSndLogVO.setLogSeq("1");
								logSeq = 1;
							} else {
								newZealandManifestSndLogVO.setLogSeq(logSeq +1 + "");
							}
							newZealandManifestSndLogVO.setVslCd(newZealandCondVO.getVvd().substring(0, 4));
							newZealandManifestSndLogVO.setSkdVoyNo(newZealandCondVO.getVvd().substring(4, 8));
							newZealandManifestSndLogVO.setSkdDirCd(newZealandCondVO.getVvd().substring(8, 9));

							newZealandManifestSndLogVO.setBlNo(newZealandCstmsMfDtl2VOs[cIdx].getBlNo());
							newZealandManifestSndLogVO.setCntrNo(newZealandCstmsMfDtl2VOs[cIdx].getCntrNo());
							newZealandManifestSndLogVO.setPodCd(newZealandCstmsMfDtl2VOs[cIdx].getVvdPodCd());
							newZealandManifestSndLogVO.setPolCd(newZealandCstmsMfDtl2VOs[cIdx].getVvdPolCd());
							//newZealandManifestSndLogVO.setPolSplitNo(departureTimeVO.getPolSplitNo());
							newZealandManifestSndLogVO.setEdiSndMsgCtnt(flatFile.toString());
							newZealandManifestSndLogVO.setEdiRefId(flatFileRefNo);
							newZealandManifestSndLogVO.setCreUsrId(account.getUsr_id());
							newZealandManifestSndLogVO.setUpdUsrId(account.getUsr_id());

							dbDao.addCstmsNzlSendLog(newZealandManifestSndLogVO);
						}
					}
					flatFile.append("}BL_INFO").append("\n");

				} // end for (BL)
			} // end Body

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
			if (flatFile!=null && flatFile.trim().length() > 1) {
			  SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			  sendFlatFileVO.setFlatFile(flatFile);
			  sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get(queueName));
			  BookingUtil utilCommand = new BookingUtil();
			  FlatFileAckVO flatFileAckVO = utilCommand.sendFlatFile(sendFlatFileVO);
			  if (flatFileAckVO.getAckStsCd().equals("E")) throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
			}
		}catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * BackEndJob을 실행.
	 *
	 * @param SignOnUserAccount account
	 * @param NewZealandManifestVO newZealandManifestVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, NewZealandManifestVO newZealandManifestVO, String pgmNo) throws EventException {
		NewZealandCustomsTransmissionBackEndJob backEndJob = new NewZealandCustomsTransmissionBackEndJob();

		try {
			backEndJob.setAccount(account);
			backEndJob.setNewZealandManifestVO(newZealandManifestVO);
			backEndJob.setPgmNo(pgmNo);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			return backEndJobManager.execute(backEndJob, account.getUsr_id(), "NewZealand Transmit.");

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 수신 FlatFile 데이터를 로그 테이블에 저장<br>
	 *
	 * @param String rcvMsg
	 * @exception EventException
	 */
	public void loadCstmsRcvMsg(String rcvMsg) throws EventException {

		String msgAckRslt = "";
		String ediRefId = "";
		String mrnNo = "";

		NewZealandManifestSndLogVO newZealandManifestSndLogVO = null;

		try {
			msgAckRslt = getReceiveSingleItem(rcvMsg,"MSG_ACK_RSLT:",  "\n");
			ediRefId = getReceiveSingleItem(rcvMsg,"ORG_MSG_KEY:",  "\n");
			mrnNo = getReceiveSingleItem(rcvMsg,"MSG_ACK_REF:",  "\n");

			if("STATUS".equals(msgAckRslt)) {

				List<String> errList = getReceiveMultiItem(rcvMsg, "\\{STATUS_INFO","}STATUS_INFO");
				if (errList != null && errList.size() > 0) {
					for (int i = 0; i < errList.size(); i++) {

						newZealandManifestSndLogVO = new NewZealandManifestSndLogVO();
						newZealandManifestSndLogVO.setEdiRcvMsgCtnt(rcvMsg);
						newZealandManifestSndLogVO.setEdiRefId(ediRefId);
						newZealandManifestSndLogVO.setMrnNo(mrnNo);
						newZealandManifestSndLogVO.setCstmsRqstFlg("Y");
						newZealandManifestSndLogVO.setBlNo(getReceiveSingleItem(errList.get(i), "BL_NO:",   "\n"));
						newZealandManifestSndLogVO.setRcvKeyDatCtnt(errList.get(i));
						dbDao.modifyCstmsNzlSendLog(newZealandManifestSndLogVO);
					}
				}

			} else if ("REJECTED".equals(msgAckRslt)) {
				newZealandManifestSndLogVO = new NewZealandManifestSndLogVO();
				newZealandManifestSndLogVO.setEdiRefId(ediRefId);
				newZealandManifestSndLogVO.setMrnNo(mrnNo);
				newZealandManifestSndLogVO.setEdiRcvMsgCtnt(rcvMsg);
				newZealandManifestSndLogVO.setCstmsRqstFlg("Y");

				dbDao.modifyCstmsNzlSendLog(newZealandManifestSndLogVO);
			} else if ("OK".equals(msgAckRslt)) {
				newZealandManifestSndLogVO = new NewZealandManifestSndLogVO();
				newZealandManifestSndLogVO.setEdiRefId(ediRefId);
				newZealandManifestSndLogVO.setMrnNo(mrnNo);
				newZealandManifestSndLogVO.setEdiRcvMsgCtnt(rcvMsg);
				newZealandManifestSndLogVO.setCstmsRqstFlg("N");

				dbDao.modifyCstmsNzlSendLog(newZealandManifestSndLogVO);
			}


		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), e);
		}
	}

	/**
	 * [ESM_BKG_1518_01]
	 * Transmit Result Error Report 목록 조회<br>
	 *
	 * @param NewZealandCstmsMfDtl2VO newZealandCstmsMfDtl2VO
	 * @return List<NewZealandManifestErrorReportVO>
	 * @exception EventException
	 */
	public List<NewZealandManifestErrorReportVO> searchErrorReport(NewZealandCstmsMfDtl2VO newZealandCstmsMfDtl2VO) throws EventException {

		String ediRcvMsgCtnt = "";
		String msgAckRslt = "";
		String rcvKeyDatCtnt = "";

		List<NewZealandManifestErrorReportVO> retVOList = new ArrayList<NewZealandManifestErrorReportVO>();
		NewZealandManifestErrorReportVO retVO = null;

		try {
			List<NewZealandManifestErrorReportVO> advJpReceiveLogVOList = dbDao.searchErrorReport(newZealandCstmsMfDtl2VO);
			if (advJpReceiveLogVOList.size() > 0) {
				for (NewZealandManifestErrorReportVO advJpReceiveLogVO : advJpReceiveLogVOList) {

					ediRcvMsgCtnt = advJpReceiveLogVO.getEdiRcvMsgCtnt();

					rcvKeyDatCtnt = advJpReceiveLogVO.getRcvKeyDatCtnt();
					msgAckRslt = getReceiveSingleItem(ediRcvMsgCtnt,"MSG_ACK_RSLT:",  "\n");

					if("STATUS".equals(msgAckRslt)){

						List<String> errList = getReceiveMultiItem(rcvKeyDatCtnt, "\\{ERROR_INFO","}ERROR_INFO");
						if (errList != null && errList.size() > 0) {
							for (int k = 0; k < errList.size(); k++) {
								retVO = new NewZealandManifestErrorReportVO();
								retVO.setErrCode(getReceiveSingleItem(errList.get(k), "ERR_CODE:",   "\n"));
								retVOList.add(retVO);
							}
						}
					}else if("REJECTED".equals(msgAckRslt)){
						List<String> errList = getReceiveMultiItem(ediRcvMsgCtnt, "\\{ERRORS","}ERRORS");

						if (errList != null && errList.size() > 0) {
							for (int k = 0; k < errList.size(); k++) {
								retVO = new NewZealandManifestErrorReportVO();
								retVO.setErrCode(getReceiveSingleItem(errList.get(k), "ERR_CODE:",   "\n"));
								retVOList.add(retVO);
							}
						}
					}
				}
			}
			return retVOList;
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
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
	private String getReceiveSingleItem(String src, String prefix, String endDelimeter){
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
	private List<String> getReceiveMultiItem(String src, String prefix, String surfix){
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

}
