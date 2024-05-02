/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : MalaysiaCustomsTransmissionBCImpl.java
 *@FileTitle : UI_BKG-1141
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.02.07
 *@LastModifier : 변종건
 *@LastVersion : 1.0
 * 2012.02.07 변종건
 * 1.0 Creation
 * 2012.02.02 변종건 [CHM-201215473-01] Malaysis (MYTPP) Customs Manifest 전송 기능 추가 요청
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.basic;

import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.integration.MalaysiaCustomsTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.BkgCstmsMySndLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.BkgCstmsMySndLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestCmDescVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestCmInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestCntrSealNoInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestCustomerInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestDgGoodsInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestLocInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestMarkInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestRfGoodsInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.malaysia.vo.MalaysiaManifestVslInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.malaysia.vo.MalaysiaManifestListCntrInfoVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author LIM JAE TAEK
 * @see EventResponse,MalaysiaCustomsTransmissionBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class MalaysiaCustomsTransmissionBCImpl extends CustomsTransmissionBCImpl {
	// Database Access Object
	private transient MalaysiaCustomsTransmissionDBDAO dbDao = null;

	/**  
	 * MalaysiaCustomsTransmissionBCImpl 객체 생성<br>
	 * MalaysiaCustomsTransmissionBCImpl 생성한다.<br>
	 */
	public MalaysiaCustomsTransmissionBCImpl() {
		dbDao = new MalaysiaCustomsTransmissionDBDAO();
	}


	/**
	 * Malaysia 세관신고 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException {
		       //@ BL별 FlatFile을 생성/전송 한다.2017.08.21
		return transmitManifestByBl(manifestTransmitVOs, account);
	}
	/**
	 * Malaysia 세관신고 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifestAll(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException {

		BookingUtil		bookingUtil		= new BookingUtil();
		
		// FLATFILE
		String 			senderId 		= "";
		String 			receiverId 		= "";
		String 			headerType 		= "";
		String 		 	flatFileHeader	= null;
		String 		 	flatFileRefNo	= null;
		String          bkgCgoTpCd      = "";
		String          indFclLcl      = "";
		StringBuffer 	flatFile 		= new StringBuffer();
		
		// -- Input 정보 -- //
		// 전송할 BL LIST
		MalaysiaManifestTransmitVO[] 			malaysiaManifestTransmitVOs = (MalaysiaManifestTransmitVO[]) manifestTransmitVOs;
		//B/L Input 정보
		List<MalaysiaManifestListBlInfoVO> 		malaysiaBlInputList 		= malaysiaManifestTransmitVOs[0].getMalaysiaManifestListBlInfoVOs();
		//Container Input 정보
		List<MalaysiaManifestListCntrInfoVO> 	malaysiaCntrInputList 		= malaysiaManifestTransmitVOs[0].getMalaysiaManifestListCntrInfoVOs();
		
		// -- Output 정보 -- //
		// VSL 정보
		MalaysiaManifestVslInfoVO 				malaysiaVslInfoVO 			= null;
		// Container Count 정보
		String 									malaysiaCntrCnt				= null;
		// Location 정보
		List<MalaysiaManifestLocInfoVO> 		malaysiaLocInfoList 		= null;
		// Customer 정보
		List<MalaysiaManifestCustomerInfoVO> 	malaysiaCustomerInfoList 	= null;
		// CM Info 정보
		List<MalaysiaManifestCmInfoVO> 			malaysiaCmInfoList 			= null;
		// Danger Goods 정보
		List<MalaysiaManifestDgGoodsInfoVO> 	malaysiaDgGoodsInfoList 	= null;
		// CM Desc 정보
		List<MalaysiaManifestCmDescVO> 			malaysiaCmDescList 			= null;
		// Mark 정보
		List<MalaysiaManifestMarkInfoVO> 		malaysiaMarkInfoList 		= null;
		// Container Seal 정보
		List<MalaysiaManifestCntrSealNoInfoVO> 	malaysiaCntrSealNoInfoList 	= null;
		
		// -- For문 Index -- //
		int blIdx 	= 0;
		int locIdx 	= 0;
		int custIdx = 0;
		int dgIdx 	= 0;
		int markIdx = 0;
		int cntrIdx = 0;
		int sealIdx = 0;
		int cmIdx   = 0;
		int cmdIdx  = 0;
		
		try
		{

			// Body 생성
			if( malaysiaBlInputList != null ){
					
				for( blIdx = 0; blIdx < malaysiaBlInputList.size(); blIdx++ ){
					// Header 생성
					senderId = "SML";
					receiverId = "PTP";
					headerType = "CUSCAR";
					flatFileHeader = bookingUtil.searchCstmsEdiHeader(senderId, receiverId, headerType);
					flatFile.append(flatFileHeader).append("\n");
					
					if( blIdx == 0 ){
						flatFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("BKC"));
					}
					
					// (1) VSL 정보
					malaysiaVslInfoVO = dbDao.searchVslInfo(malaysiaBlInputList.get(blIdx));
					if( malaysiaVslInfoVO != null ){
						if("T".equals(malaysiaVslInfoVO.getTsTpCd())){
						flatFile.append("E_I_IND:")			.append("T").append("\n");
						}else {
							flatFile.append("E_I_IND:")			.append(malaysiaVslInfoVO.getEIInd()).append("\n");
						}
						flatFile.append("STATUS:")			.append(malaysiaVslInfoVO.getStatus()).append("\n");
						flatFile.append("VVD:")				.append(malaysiaVslInfoVO.getVvd()).append("\n");
						flatFile.append("VSL_FULLNAME:")	.append(malaysiaVslInfoVO.getVslFullname()).append("\n");
						flatFile.append("VSL_AUTH_NO:")		.append(malaysiaVslInfoVO.getVslAuthNo()).append("\n");
						flatFile.append("VSL_NATION_CD:")	.append(malaysiaVslInfoVO.getVslNationCd()).append("\n");
						if( malaysiaVslInfoVO.getVslCallNo().length() > 0 && malaysiaVslInfoVO.getVslCallNo() != null ){
							flatFile.append("VSL_SCN:")			.append(malaysiaVslInfoVO.getVslCallNo()).append("\n");
						}else{
							flatFile.append("VSL_SCN:")			.append("\n");
						}
						flatFile.append("PORT:")			.append(malaysiaVslInfoVO.getPort()).append("\n");
						flatFile.append("PORT_NM:")			.append(malaysiaVslInfoVO.getPortNm()).append("\n");
						flatFile.append("ETA:")				.append(malaysiaVslInfoVO.getEta()).append("\n");
						flatFile.append("ETD:")				.append(malaysiaVslInfoVO.getEtd()).append("\n");
					}
					
					// (2) B/L 정보
					flatFile.append("{BL_INFO").append("\n");
					flatFile.append("BLNBR:")			.append(malaysiaBlInputList.get(blIdx).getBlNo()).append("\n");
					flatFile.append("BKGNBR:")			.append(malaysiaBlInputList.get(blIdx).getBkgNo()).append("\n");
					flatFile.append("BLPKG:")			.append(malaysiaBlInputList.get(blIdx).getPckQty()).append("\n");
					flatFile.append("BLPKGU:")			.append(malaysiaBlInputList.get(blIdx).getPckTpCd()).append("\n");
					flatFile.append("BLWGT:")			.append(malaysiaBlInputList.get(blIdx).getActWgt()).append("\n");
					flatFile.append("BLWGT_UNIT:")		.append(malaysiaBlInputList.get(blIdx).getWgtUtCd()).append("\n");
					flatFile.append("BLMEA:")			.append(malaysiaBlInputList.get(blIdx).getMeasQty()).append("\n");
					flatFile.append("BLMEA_UNIT:")		.append(malaysiaBlInputList.get(blIdx).getMeasUtCd()).append("\n");
					
					// (3) Container Count 정보
					malaysiaCntrCnt = dbDao.searchCntrCnt(malaysiaBlInputList.get(blIdx).getBkgNo());
					flatFile.append("CNTR_CNT:").append(malaysiaCntrCnt).append("\n");
					
					// (4) Location 정보
					malaysiaLocInfoList = dbDao.searchLocInfo(malaysiaBlInputList.get(blIdx));
					for( locIdx = 0; locIdx < malaysiaLocInfoList.size(); locIdx++)
					{
						flatFile.append("{LOC_INFO").append("\n");
						flatFile.append("LOC_TYPE:")		.append(malaysiaLocInfoList.get(locIdx).getLocType()).append("\n");
						flatFile.append("LOC_CD:")			.append(malaysiaLocInfoList.get(locIdx).getLocCd()).append("\n");
						flatFile.append("LOC_NM:")			.append(malaysiaLocInfoList.get(locIdx).getLocNm()).append("\n");
						flatFile.append("LOC_ETA:")			.append(malaysiaLocInfoList.get(locIdx).getLocEta()).append("\n");
						flatFile.append("LOC_ETD:")			.append(malaysiaLocInfoList.get(locIdx).getLocEtd()).append("\n");
						flatFile.append("}LOC_INFO").append("\n");
					}

					// (5) Customer 정보
					malaysiaBlInputList.get(blIdx).setUsrId(account.getUsr_id());
					malaysiaCustomerInfoList = dbDao.searchCustomerInfo(malaysiaBlInputList.get(blIdx));
					for( custIdx = 0; custIdx < malaysiaCustomerInfoList.size(); custIdx++)
					{   
						flatFile.append("{CUSTOMER_INFO").append("\n");
						flatFile.append("CUSTOMER_TYPE:")	.append(malaysiaCustomerInfoList.get(custIdx).getCustomerType()).append("\n");
						flatFile.append("CUSTOMER_CD:")		.append(malaysiaCustomerInfoList.get(custIdx).getCustomerCd()).append("\n");
						flatFile.append("CUSTOMER_NM1:")	.append(malaysiaCustomerInfoList.get(custIdx).getCustomerNm1()).append("\n");
						flatFile.append("CUSTOMER_NM2:")	.append(malaysiaCustomerInfoList.get(custIdx).getCustomerNm2()).append("\n");
						flatFile.append("CUSTOMER_ADDR1:")	.append(malaysiaCustomerInfoList.get(custIdx).getCustomerAddr1()).append("\n");
						flatFile.append("CUSTOMER_ADDR2:")	.append(malaysiaCustomerInfoList.get(custIdx).getCustomerAddr2()).append("\n");
						flatFile.append("CUSTOMER_ADDR3:")	.append(malaysiaCustomerInfoList.get(custIdx).getCustomerAddr3()).append("\n");
						flatFile.append("CONTACT_NM:")		.append(malaysiaCustomerInfoList.get(custIdx).getContactNm()).append("\n");
						flatFile.append("CONTACT_TEL:")		.append(malaysiaCustomerInfoList.get(custIdx).getContactTel()).append("\n");
						flatFile.append("CONTACT_FAX:")		.append(malaysiaCustomerInfoList.get(custIdx).getContactFax()).append("\n");
						flatFile.append("CONTACT_EMAIL:")	.append(malaysiaCustomerInfoList.get(custIdx).getContactEmail()).append("\n");
						flatFile.append("}CUSTOMER_INFO").append("\n");
					}
					
					
					// (6-0) CM Info 정보
					malaysiaCmInfoList = dbDao.searchCmInfo(malaysiaBlInputList.get(blIdx));
					for( cmIdx = 0; cmIdx < malaysiaCmInfoList.size(); cmIdx++)
					{
						flatFile.append("{CM_INFO").append("\n");
						flatFile.append("CM_SEQ:")			.append(malaysiaCmInfoList.get(cmIdx).getCmSeq()).append("\n");
						flatFile.append("CM_PKG:")			.append(malaysiaCmInfoList.get(cmIdx).getCmPkg()).append("\n");
						flatFile.append("CM_PKG_UNIT:")		.append(malaysiaCmInfoList.get(cmIdx).getCmPkgUnit()).append("\n");
						flatFile.append("CM_WGT:")			.append(malaysiaCmInfoList.get(cmIdx).getCmWgt()).append("\n");
						flatFile.append("CM_WGT_UNIT:")		.append(malaysiaCmInfoList.get(cmIdx).getCmWgtUnit()).append("\n");
						flatFile.append("CM_MEA:")			.append(malaysiaCmInfoList.get(cmIdx).getCmMea()).append("\n");
						flatFile.append("CM_MEA_UNIT:")		.append(malaysiaCmInfoList.get(cmIdx).getCmMeaUnit()).append("\n");
						flatFile.append("HS_CODE:")		.append(malaysiaCmInfoList.get(cmIdx).getHsCode()).append("\n");

					
							// (6-1) Danger Goods 정보
							malaysiaDgGoodsInfoList = dbDao.searchDgGoodsInfo(malaysiaBlInputList.get(blIdx));//,malaysiaCustomerInfoList.get(custIdx).getcnytno()
							for( dgIdx = 0; dgIdx < malaysiaDgGoodsInfoList.size(); dgIdx++)
							{
								flatFile.append("{DANGER_GOODS").append("\n");
								flatFile.append("HAZARD_CD:")		.append(malaysiaDgGoodsInfoList.get(dgIdx).getHazardCd()).append("\n");
								flatFile.append("UNDG_NO:")			.append(malaysiaDgGoodsInfoList.get(dgIdx).getUndgNo()).append("\n");
								flatFile.append("FLASH_POINT:")		.append(malaysiaDgGoodsInfoList.get(dgIdx).getFlashPoint()).append("\n");
								flatFile.append("}DANGER_GOODS").append("\n");
							}
							
							// (6-2) CM Description 정보
							malaysiaCmDescList = dbDao.searchCmDesc(malaysiaBlInputList.get(blIdx));//,malaysiaCustomerInfoList.get(custIdx).getcnytno()
							for( cmdIdx = 0; cmdIdx < malaysiaCmDescList.size(); cmdIdx++)
							{
								flatFile.append("{CM_DESC").append("\n");
								flatFile.append("CM_DESC1:")		.append(malaysiaCmDescList.get(cmdIdx).getCmDesc1()).append("\n");
								flatFile.append("CM_DESC2:")		.append(malaysiaCmDescList.get(cmdIdx).getCmDesc2()).append("\n");
								flatFile.append("CM_DESC3:")		.append(malaysiaCmDescList.get(cmdIdx).getCmDesc3()).append("\n");
								flatFile.append("CM_DESC4:")		.append(malaysiaCmDescList.get(cmdIdx).getCmDesc4()).append("\n");
								flatFile.append("CM_DESC5:")		.append(malaysiaCmDescList.get(cmdIdx).getCmDesc5()).append("\n");
								flatFile.append("}CM_DESC").append("\n");
							}
							

						flatFile.append("}CM_INFO").append("\n");
					}							
					
					// (7) Description 정보
					flatFile.append("{DESC").append("\n");
					flatFile.append("DESC:")			.append(malaysiaBlInputList.get(blIdx).getDescription2()).append("\n");
					flatFile.append("}DESC").append("\n");
					
					// (8) Mark 정보
					malaysiaMarkInfoList = dbDao.searchMarkInfo(malaysiaBlInputList.get(blIdx));
					for( markIdx = 0; markIdx < malaysiaMarkInfoList.size(); markIdx++)
					{
						flatFile.append("{MARK").append("\n");
						flatFile.append("MARKNO1:")			.append(malaysiaMarkInfoList.get(markIdx).getMark1()).append("\n");
						flatFile.append("MARKNO2:")			.append(malaysiaMarkInfoList.get(markIdx).getMark2()).append("\n");
						flatFile.append("MARKNO3:")			.append(malaysiaMarkInfoList.get(markIdx).getMark3()).append("\n");
						flatFile.append("MARKNO4:")			.append(malaysiaMarkInfoList.get(markIdx).getMark4()).append("\n");
						flatFile.append("MARKNO5:")			.append(malaysiaMarkInfoList.get(markIdx).getMark5()).append("\n");
						flatFile.append("MARKNO6:")			.append(malaysiaMarkInfoList.get(markIdx).getMark6()).append("\n");
						flatFile.append("MARKNO7:")			.append(malaysiaMarkInfoList.get(markIdx).getMark7()).append("\n");
						flatFile.append("MARKNO8:")			.append(malaysiaMarkInfoList.get(markIdx).getMark8()).append("\n");
						flatFile.append("MARKNO9:")			.append(malaysiaMarkInfoList.get(markIdx).getMark9()).append("\n");
						flatFile.append("MARKNO10:")		.append(malaysiaMarkInfoList.get(markIdx).getMark10()).append("\n");
						flatFile.append("}MARK").append("\n");
					}
					
					
					for( cntrIdx = 0; cntrIdx < malaysiaCntrInputList.size(); cntrIdx++)
					{
						
						if( malaysiaCntrInputList.get(cntrIdx).getBlNo().equals(malaysiaBlInputList.get(blIdx).getBlNo()) ){
							// (9) Container 정보
							flatFile.append("{CNTR_INFO").append("\n");
							flatFile.append("CNTRNBR:")			.append(malaysiaCntrInputList.get(cntrIdx).getCntrNo()).append("\n");
							flatFile.append("CNTRTYPE:")		.append(malaysiaCntrInputList.get(cntrIdx).getCntrTpszCd()).append("\n");
							
							
							flatFile.append("CNTR_ISO_TP:")		.append(dbDao.searchCntrIsoTp(malaysiaBlInputList.get(blIdx).getBlNo(), malaysiaCntrInputList.get(cntrIdx).getCntrNo())).append("\n");
							
							bkgCgoTpCd =dbDao.searchBkgCgoTpCd(malaysiaBlInputList.get(blIdx).getBkgNo());
							indFclLcl =dbDao.searchIndFclLcl(malaysiaBlInputList.get(blIdx).getBkgNo(),malaysiaCntrInputList.get(cntrIdx).getCntrNo());
							
							if("P".equals(bkgCgoTpCd)||"R".equals(bkgCgoTpCd)){
							flatFile.append("CNTR_FM_IND:")		.append("5").append("\n");
							}else{
								if("FCL".equals(indFclLcl)){
								flatFile.append("CNTR_FM_IND:")		.append("1").append("\n");
								}else {
									flatFile.append("CNTR_FM_IND:")		.append("3").append("\n");
								}
							}
							
							flatFile.append("CNTRWGT:")			.append(malaysiaCntrInputList.get(cntrIdx).getCntrWgt()).append("\n");
							flatFile.append("CNTRWGT_UNIT:")	.append(malaysiaCntrInputList.get(cntrIdx).getWgtUtCd()).append("\n");
							flatFile.append("CNTRMEA:")			.append(malaysiaCntrInputList.get(cntrIdx).getMeasQty()).append("\n");
							flatFile.append("CNTRMEA_UNIT:")	.append(malaysiaCntrInputList.get(cntrIdx).getMeasUtCd()).append("\n");
							
							// (10) Container Seal 정보
							malaysiaBlInputList.get(blIdx).setCntrNo(malaysiaCntrInputList.get(cntrIdx).getCntrNo());
							malaysiaCntrSealNoInfoList = dbDao.searchCntrSealNoInfo(malaysiaBlInputList.get(blIdx));
							for( sealIdx = 0; sealIdx < malaysiaCntrSealNoInfoList.size(); sealIdx++)
							{
								flatFile.append("{CNTR_SEAL_NO").append("\n");
								flatFile.append("SEALNBR:")	.append(malaysiaCntrSealNoInfoList.get(sealIdx).getSealnbr()).append("\n");
								flatFile.append("}CNTR_SEAL_NO").append("\n");
							}
							
							flatFile.append("}CNTR_INFO").append("\n");
						}
					} // end for (Container)
					
					flatFile.append("}BL_INFO").append("\n");
				} // end for (BL)
			}

//			log.debug("abc_FlatFile = "+flatFile.toString());
			
			
			// send Flat File log VO 셋팅
			BkgCstmsMySndLogVO bkgCstmsMySndLogVO = new BkgCstmsMySndLogVO(); // send
			BkgCstmsMySndLogDtlVO bkgCstmsMySndLogDtlVO = new BkgCstmsMySndLogDtlVO(); // send
//			List<BkgCstmsMySndLogDtlVO> bkgCstmsMySndLogDtlList = new ArrayList<BkgCstmsMySndLogDtlVO>();
			
			if(bkgCstmsMySndLogVO != null && malaysiaVslInfoVO != null && malaysiaBlInputList != null) {
				// 전송로그를 저장한다. (MASTER)
				bkgCstmsMySndLogVO.setMyMfSndIndCd(malaysiaVslInfoVO.getStatus());
				bkgCstmsMySndLogVO.setFltFileRefNo(flatFileRefNo);
				bkgCstmsMySndLogVO.setVvd(malaysiaVslInfoVO.getVvd());
				bkgCstmsMySndLogVO.setPolCd(malaysiaBlInputList.get(0).getInputPolCd());
				bkgCstmsMySndLogVO.setPodCd(malaysiaBlInputList.get(0).getInputPodCd());
				bkgCstmsMySndLogVO.setMyCstmsBndCd(malaysiaVslInfoVO.getEIInd());
				bkgCstmsMySndLogVO.setOfcCd(account.getOfc_cd());
				bkgCstmsMySndLogVO.setBlKnt(malaysiaBlInputList.get(0).getBlKnt());
				bkgCstmsMySndLogVO.setTtlCntrKnt(malaysiaBlInputList.get(0).getTtlCntrKnt());
				bkgCstmsMySndLogVO.setUsrId(account.getUsr_id());
			
			
				dbDao.addCUSCARSndLog(bkgCstmsMySndLogVO);
			}
			
			
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
				
				if( bkgCstmsMySndLogDtlVO != null ){
					bkgCstmsMySndLogDtlVO.setMyMfSndIndCd(malaysiaVslInfoVO.getStatus());
					bkgCstmsMySndLogDtlVO.setFltFileRefNo(flatFileRefNo);
					bkgCstmsMySndLogDtlVO.setLogDtlSeq(Integer.toString(i+1));
					bkgCstmsMySndLogDtlVO.setEdiSndMsg(fFiles[i]);
					bkgCstmsMySndLogDtlVO.setUsrId(account.getUsr_id());
					
					// 전송로그를 저장한다. (DETAIL)
				
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
			ediSendMessage(flatFile.toString(), "BKG.ALPSBKG_UBIZHJS_SLKMFT.IBMMQ.QUEUE"); 
			
		}
		catch (DAOException ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
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
	private void ediSendMessage(String flatFile, String queueName) throws EventException
	{
		try {					
		  // FlatFile 이 빈 경우 SKIP 처리
			if (flatFile!=null && flatFile.trim().length() > 1) {
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

		MalaysiaCustomsTransmissionBackEndJob backEndJob = new MalaysiaCustomsTransmissionBackEndJob ();
		backEndJob.setPgmNo(pgmNo);
		String resultStr = "";
		
		if(pgmNo.equals("ESM_BKG_1141")) {
			backEndJob.setManifestTransmitVOs(manifestTransmitVOs);
			backEndJob.setAccount(account);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			resultStr = backEndJobManager.execute(backEndJob , account.getUsr_id(), "Malaysia EDI Transmit");
		}
		
		return resultStr;
	}


	/**
		 * Malaysia 세관신고 위해 BL별 FlatFile을 생성/전송 한다.
		 * 
		 * @param ManifestTransmitVO[] manifestTransmitVOs
		 * @param SignOnUserAccount account
		 * @return String
		 * @throws EventException
		 */
		public String transmitManifestByBl(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException {
	
			BookingUtil		bookingUtil		= new BookingUtil();
			
			// FLATFILE
			String 			senderId 		= "";
			String 			receiverId 		= "";
			String 			headerType 		= "";
			String 		 	flatFileHeader	= null;
			String 		 	flatFileRefNo	= "";
			String          bkgCgoTpCd      = "";
			String          indFclLcl      = "";
			StringBuffer 	flatFile;
			StringBuffer 	returnFlatFile  = new StringBuffer();
			
			// -- Input 정보 -- //
			// 전송할 BL LIST
			MalaysiaManifestTransmitVO[] 			malaysiaManifestTransmitVOs = (MalaysiaManifestTransmitVO[]) manifestTransmitVOs;
			//B/L Input 정보
			List<MalaysiaManifestListBlInfoVO> 		malaysiaBlInputList 		= malaysiaManifestTransmitVOs[0].getMalaysiaManifestListBlInfoVOs();
			//Container Input 정보
			List<MalaysiaManifestListCntrInfoVO> 	malaysiaCntrInputList 		= malaysiaManifestTransmitVOs[0].getMalaysiaManifestListCntrInfoVOs();
			
			// -- Output 정보 -- //
			// VSL 정보
			MalaysiaManifestVslInfoVO 				malaysiaVslInfoVO 			= null;
			MalaysiaManifestVslInfoVO 				ts2ndVslInfoVO 		        = null;
			//@ T/S시 PRE/NEXT VVD정보
			MalaysiaManifestVslInfoVO 				ts2ndVvdMalaysiaVslInfoVO 	= null;
			//@ TS시 2nd Vessel 정보 조회용 Input VO 
			MalaysiaManifestListBlInfoVO            ts2ndVslInfoInputBlVO;
			// Container Count 정보
			String 									malaysiaCntrCnt				= null;
			// Location 정보
			List<MalaysiaManifestLocInfoVO> 		malaysiaLocInfoList 		= null;
			// Customer 정보
			List<MalaysiaManifestCustomerInfoVO> 	malaysiaCustomerInfoList 	= null;
			// CM Info 정보
			List<MalaysiaManifestCmInfoVO> 			malaysiaCmInfoList 			= null;
			// Danger Goods 정보
			List<MalaysiaManifestDgGoodsInfoVO> 	malaysiaDgGoodsInfoList 	= null;
			// Reefer Goods 정보
			List<MalaysiaManifestRfGoodsInfoVO> 	malaysiaRfGoodsInfoList 	= null;
			// CM Desc 정보
			List<MalaysiaManifestCmDescVO> 			malaysiaCmDescList 			= null;
			// Mark 정보
			List<MalaysiaManifestMarkInfoVO> 		malaysiaMarkInfoList 		= null;
			// Container Seal 정보
			List<MalaysiaManifestCntrSealNoInfoVO> 	malaysiaCntrSealNoInfoList 	= null;
			// 하드코딩 테이블 조회 (SA,PSA등조회)
			List<BkgHrdCdgCtntVO> bkgHrdCdgCtntVOs                              = null;
			
			// -- For문 Index -- //
			int blIdx 	= 0;
			int locIdx 	= 0;
			int custIdx = 0;
			int dgIdx 	= 0;
			int markIdx = 0;
			int cntrIdx = 0;
			int sealIdx = 0;
			int cmIdx   = 0;
			int cmdIdx  = 0;
			
			//@ EDI 전송한 Container 개수
			int totalSendCntrCnt = 0;
			
			try
			{
	
				if( malaysiaBlInputList == null || malaysiaBlInputList.size() == 0){
					return "";
				}
				// Body 생성
						
				//@ VSL 정보 확인 - 한번만 조회
				malaysiaVslInfoVO = dbDao.searchVslInfo(malaysiaBlInputList.get(0));
				if(malaysiaVslInfoVO == null){
					return "";
				}

				//@ (Principal)Shipping Agent 생성
				BkgHrdCdgCtntListCondVO hrdVO = new BkgHrdCdgCtntListCondVO();
		        hrdVO.setHrdCdgId("MY_MF_SA_CD");
				hrdVO.setAttrCtnt1(malaysiaVslInfoVO.getPort());
				bkgHrdCdgCtntVOs = bookingUtil.searchHardCoding(hrdVO);
		
				String custName = "";
				String custAddr = "";
				StringBuffer saPsaFlatFile = new StringBuffer();
				saPsaFlatFile.append("{CUSTOMER_INFO").append("\n");
				saPsaFlatFile.append("CUSTOMER_TYPE:")	.append("SA").append("\n");
				if(bkgHrdCdgCtntVOs.size() > 0){
					custName = String.format("%-70s",bkgHrdCdgCtntVOs.get(0).getAttrCtnt3());
					custAddr = String.format("%-105s",bkgHrdCdgCtntVOs.get(0).getAttrCtnt4());
					saPsaFlatFile.append("CUSTOMER_CD:")	.append(bkgHrdCdgCtntVOs.get(0).getAttrCtnt2()).append("\n");
					saPsaFlatFile.append("CUSTOMER_NM1:")	.append(custName.substring(0,35))              .append("\n");
					saPsaFlatFile.append("CUSTOMER_NM2:")	.append(custName.substring(35,70))             .append("\n");
					saPsaFlatFile.append("CUSTOMER_ADDR1:")	.append(custAddr.substring(0,35))              .append("\n");
					saPsaFlatFile.append("CUSTOMER_ADDR2:")	.append(custAddr.substring(35,70))             .append("\n");
					saPsaFlatFile.append("CUSTOMER_ADDR3:")	.append(custAddr.substring(70,105))            .append("\n");
					saPsaFlatFile.append("CONTACT_NM:")		.append(bkgHrdCdgCtntVOs.get(0).getAttrCtnt5()).append("\n");
					saPsaFlatFile.append("CONTACT_TEL:")	.append(bkgHrdCdgCtntVOs.get(0).getAttrCtnt6()).append("\n");
					saPsaFlatFile.append("CONTACT_FAX:")	.append(bkgHrdCdgCtntVOs.get(0).getAttrCtnt7()).append("\n");
					saPsaFlatFile.append("CONTACT_EMAIL:")	.append(bkgHrdCdgCtntVOs.get(0).getAttrCtnt8()).append("\n");
				}else{
					saPsaFlatFile.append("CUSTOMER_CD:")	.append("\n");
					saPsaFlatFile.append("CUSTOMER_NM1:")	.append("\n");
					saPsaFlatFile.append("CUSTOMER_NM2:")	.append("\n");
					saPsaFlatFile.append("CUSTOMER_ADDR1:")	.append("\n");
					saPsaFlatFile.append("CUSTOMER_ADDR2:")	.append("\n");
					saPsaFlatFile.append("CUSTOMER_ADDR3:")	.append("\n");
					saPsaFlatFile.append("CONTACT_NM:")		.append("\n");
					saPsaFlatFile.append("CONTACT_TEL:")	.append("\n");
					saPsaFlatFile.append("CONTACT_FAX:")	.append("\n");
					saPsaFlatFile.append("CONTACT_EMAIL:")	.append("\n");
				}
				saPsaFlatFile.append("}CUSTOMER_INFO").append("\n");
				
				//@ Principal Shipping Agent 생성
				hrdVO = new BkgHrdCdgCtntListCondVO();
		        hrdVO.setHrdCdgId("MY_MF_PSA_CD");
				hrdVO.setAttrCtnt1(malaysiaVslInfoVO.getVvd().substring(0, 4));
				bkgHrdCdgCtntVOs = bookingUtil.searchHardCoding(hrdVO);
				
				saPsaFlatFile.append("{CUSTOMER_INFO").append("\n");
				saPsaFlatFile.append("CUSTOMER_TYPE:")	.append("PSA").append("\n");
				if(bkgHrdCdgCtntVOs.size() > 0){
					custName = String.format("%-70s", bkgHrdCdgCtntVOs.get(0).getAttrCtnt3());
					custAddr = String.format("%-105s",bkgHrdCdgCtntVOs.get(0).getAttrCtnt4());
					saPsaFlatFile.append("CUSTOMER_CD:")	.append(bkgHrdCdgCtntVOs.get(0).getAttrCtnt2()).append("\n");
					saPsaFlatFile.append("CUSTOMER_NM1:")	.append(custName.substring(0,35))              .append("\n");
					saPsaFlatFile.append("CUSTOMER_NM2:")	.append(custName.substring(35,70))             .append("\n");
					saPsaFlatFile.append("CUSTOMER_ADDR1:")	.append(custAddr.substring(0,35))              .append("\n");
					saPsaFlatFile.append("CUSTOMER_ADDR2:")	.append(custAddr.substring(35,70))             .append("\n");
					saPsaFlatFile.append("CUSTOMER_ADDR3:")	.append(custAddr.substring(70,105))            .append("\n");
					saPsaFlatFile.append("CONTACT_NM:")		.append(bkgHrdCdgCtntVOs.get(0).getAttrCtnt5()).append("\n");
					saPsaFlatFile.append("CONTACT_TEL:")	.append(bkgHrdCdgCtntVOs.get(0).getAttrCtnt6()).append("\n");
					saPsaFlatFile.append("CONTACT_FAX:")	.append(bkgHrdCdgCtntVOs.get(0).getAttrCtnt7()).append("\n");
					saPsaFlatFile.append("CONTACT_EMAIL:")	.append(bkgHrdCdgCtntVOs.get(0).getAttrCtnt8()).append("\n");
				}else{
					saPsaFlatFile.append("CUSTOMER_CD:")	.append("\n");
					saPsaFlatFile.append("CUSTOMER_NM1:")	.append("\n");
					saPsaFlatFile.append("CUSTOMER_NM2:")	.append("\n");
					saPsaFlatFile.append("CUSTOMER_ADDR1:")	.append("\n");
					saPsaFlatFile.append("CUSTOMER_ADDR2:")	.append("\n");
					saPsaFlatFile.append("CUSTOMER_ADDR3:")	.append("\n");
					saPsaFlatFile.append("CONTACT_NM:")		.append("\n");
					saPsaFlatFile.append("CONTACT_TEL:")	.append("\n");
					saPsaFlatFile.append("CONTACT_FAX:")	.append("\n");
					saPsaFlatFile.append("CONTACT_EMAIL:")	.append("\n");
				}
				saPsaFlatFile.append("}CUSTOMER_INFO").append("\n");
								
				
				// Header 생성
				senderId = "SML";
				receiverId = "MYCUSTOMS";/*  TODO 변경 예정 */ 
				headerType = "MANIFEST";
				
				for( blIdx = 0; blIdx < malaysiaBlInputList.size(); blIdx++ ){
					

					flatFile = new StringBuffer();
					
					//@ B/L 별 헤더 생성
					flatFileHeader = bookingUtil.searchCstmsEdiHeader(senderId, receiverId, headerType);
					flatFile.append(flatFileHeader).append("\n");
					if( blIdx == 0 ){
						flatFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("BKC"));
					}

					// (1) VSL F/F 생성
					if("T".equals(malaysiaVslInfoVO.getTsTpCd())){
						flatFile.append("E_I_IND:")			.append("T").append("\n");
					}else {
						flatFile.append("E_I_IND:")			.append(malaysiaVslInfoVO.getEIInd()).append("\n");
					}
					flatFile.append("STATUS:")			  .append(malaysiaVslInfoVO.getStatus())          .append("\n");
					flatFile.append("VVD:")				  .append(malaysiaVslInfoVO.getVvd())             .append("\n");
					flatFile.append("VSL_FULLNAME:")	  .append(malaysiaVslInfoVO.getVslFullname())     .append("\n");
					flatFile.append("VSL_AUTH_NO:")		  .append(malaysiaVslInfoVO.getVslAuthNo())       .append("\n");
					flatFile.append("VSL_NATION_CD:")	  .append(malaysiaVslInfoVO.getVslNationCd())     .append("\n");
					flatFile.append("VSL_SCN:")			  .append(malaysiaVslInfoVO.getVslCallNo())       .append("\n");
					flatFile.append("VSL_ID:")			  .append(malaysiaVslInfoVO.getVslId())           .append("\n"); //Ship Call Number
					flatFile.append("PORT:")			  .append(malaysiaVslInfoVO.getPort())            .append("\n"); //Vessel ID
					flatFile.append("PORT_NM:")			  .append(malaysiaVslInfoVO.getPortNm())          .append("\n");
					flatFile.append("ETA:")				  .append(malaysiaVslInfoVO.getEta())             .append("\n");
					flatFile.append("ETD:")				  .append(malaysiaVslInfoVO.getEtd())             .append("\n");
					flatFile.append("CUSTOMS_STATION_CD:").append(malaysiaVslInfoVO.getCustomsStationCd()).append("\n");
					flatFile.append("TERMINAL_OP_CD:")	  .append(malaysiaVslInfoVO.getTerminalOpCd())    .append("\n");
					
					//@ T/S - 2ND_VVD 정보 조회 
					if("T".equals(malaysiaVslInfoVO.getTsTpCd())){
						//@ T/S시 PRE/NEXT VVD정보 조회 
						ts2ndVvdMalaysiaVslInfoVO = dbDao.searchPreNextVslInfo(malaysiaBlInputList.get(blIdx));
						
						ts2ndVslInfoInputBlVO = new MalaysiaManifestListBlInfoVO();
						ObjectCloner.build(malaysiaBlInputList.get(blIdx), ts2ndVslInfoInputBlVO);
						if("E".equals(malaysiaBlInputList.get(blIdx).getEIInd()) ){
							//@ Outbound 신고시 Inbound를 조회한다.
							ts2ndVslInfoInputBlVO.setEIInd("I");
							ts2ndVslInfoInputBlVO.setVvd(       ts2ndVvdMalaysiaVslInfoVO.getPreVvd());
							ts2ndVslInfoInputBlVO.setInputPodCd(ts2ndVvdMalaysiaVslInfoVO.getPrePodCd());
						}else{
							//@ Inbound 신고시 Outbound를 조회한다.
							ts2ndVslInfoInputBlVO.setEIInd("E");
							ts2ndVslInfoInputBlVO.setVvd(       ts2ndVvdMalaysiaVslInfoVO.getNextVvd());
							ts2ndVslInfoInputBlVO.setInputPolCd(ts2ndVvdMalaysiaVslInfoVO.getNextPolCd());
						}
						
						ts2ndVslInfoVO = dbDao.searchVslInfo(ts2ndVslInfoInputBlVO);
						if(ts2ndVslInfoVO != null){
							flatFile.append("2ND_VVD:")				  .append(ts2ndVslInfoVO.getVvd())             .append("\n");
							flatFile.append("2ND_VSL_FULLNAME:")	  .append(ts2ndVslInfoVO.getVslFullname())     .append("\n");
							flatFile.append("2ND_VSL_NATION_CD:")	  .append(ts2ndVslInfoVO.getVslNationCd())     .append("\n");
							flatFile.append("2ND_VSL_SCN:")			  .append(ts2ndVslInfoVO.getVslCallNo())       .append("\n");
							flatFile.append("2ND_VSL_ID:")			  .append(ts2ndVslInfoVO.getVslId())           .append("\n"); //Ship Call Number
							flatFile.append("2ND_PORT:")			  .append(ts2ndVslInfoVO.getPort())            .append("\n"); //Vessel ID
							flatFile.append("2ND_PORT_NM:")			  .append(ts2ndVslInfoVO.getPortNm())          .append("\n");
							flatFile.append("2ND_ETA:")				  .append(ts2ndVslInfoVO.getEta())             .append("\n");
							flatFile.append("2ND_ETD:")				  .append(ts2ndVslInfoVO.getEtd())             .append("\n");
							flatFile.append("2ND_CUSTOMS_STATION_CD:").append(ts2ndVslInfoVO.getCustomsStationCd()).append("\n");
							flatFile.append("2ND_TERMINAL_OP_CD:")	  .append(ts2ndVslInfoVO.getTerminalOpCd())    .append("\n");
						}else{
							flatFile.append("2ND_VVD:")				  .append("\n");
							flatFile.append("2ND_VSL_FULLNAME:")	  .append("\n");
							flatFile.append("2ND_VSL_NATION_CD:")	  .append("\n");
							flatFile.append("2ND_VSL_SCN:")			  .append("\n");
							flatFile.append("2ND_VSL_ID:")			  .append("\n");
							flatFile.append("2ND_PORT:")			  .append("\n");
							flatFile.append("2ND_PORT_NM:")			  .append("\n");
							flatFile.append("2ND_ETA:")				  .append("\n");
							flatFile.append("2ND_ETD:")				  .append("\n");
							flatFile.append("2ND_CUSTOMS_STATION_CD:").append("\n");
							flatFile.append("2ND_TERMINAL_OP_CD:")	  .append("\n");
						}
					}
					
					// (2) B/L 정보
					flatFile.append("{BL_INFO").append("\n");
					flatFile.append("BLNBR:")			.append(malaysiaBlInputList.get(blIdx).getBlNo())    .append("\n");
					flatFile.append("BKGNBR:")			.append(malaysiaBlInputList.get(blIdx).getBkgNo())   .append("\n");
					flatFile.append("BLPKG:")			.append(malaysiaBlInputList.get(blIdx).getPckQty())  .append("\n");
					flatFile.append("BLPKGU:")			.append(malaysiaBlInputList.get(blIdx).getPckTpCd()) .append("\n");
					flatFile.append("BLWGT:")			.append(malaysiaBlInputList.get(blIdx).getActWgt())  .append("\n");
					flatFile.append("BLWGT_UNIT:")		.append(malaysiaBlInputList.get(blIdx).getWgtUtCd()) .append("\n");
					flatFile.append("BLMEA:")			.append(malaysiaBlInputList.get(blIdx).getMeasQty()) .append("\n");
					flatFile.append("BLMEA_UNIT:")		.append(malaysiaBlInputList.get(blIdx).getMeasUtCd()).append("\n");
					
					// (3) Container Count 정보
					malaysiaCntrCnt = dbDao.searchCntrCnt(malaysiaBlInputList.get(blIdx).getBkgNo());
					flatFile.append("CNTR_CNT:").append(malaysiaCntrCnt).append("\n");
					
					// (4) Location 정보
					malaysiaLocInfoList = dbDao.searchLocInfo(malaysiaBlInputList.get(blIdx));
					for( locIdx = 0; locIdx < malaysiaLocInfoList.size(); locIdx++)
					{
						flatFile.append("{LOC_INFO").append("\n");
						flatFile.append("LOC_TYPE:")		.append(malaysiaLocInfoList.get(locIdx).getLocType()).append("\n");
						flatFile.append("LOC_CD:")			.append(malaysiaLocInfoList.get(locIdx).getLocCd())  .append("\n");
						flatFile.append("LOC_NM:")			.append(malaysiaLocInfoList.get(locIdx).getLocNm())  .append("\n");
						flatFile.append("LOC_ETA:")			.append(malaysiaLocInfoList.get(locIdx).getLocEta()) .append("\n");
						flatFile.append("LOC_ETD:")			.append(malaysiaLocInfoList.get(locIdx).getLocEtd()) .append("\n");
						flatFile.append("}LOC_INFO").append("\n");
					}

					// (5) Customer 정보
					//@ SA,PSA 삽입
					flatFile.append(saPsaFlatFile.toString());
//					log.debug("user name:"+account.getUsr_nm());
//					log.debug("user eml:"+account.getUsr_eml());
//					log.debug("user phone:"+account.getMphn_no());
//					log.debug("user fax:"+account.getFax_no());
					malaysiaBlInputList.get(blIdx).setUsrId(account.getUsr_id());
					malaysiaCustomerInfoList = dbDao.searchCustomerInfo(malaysiaBlInputList.get(blIdx));
					for( custIdx = 0; custIdx < malaysiaCustomerInfoList.size(); custIdx++)
					{   
						flatFile.append("{CUSTOMER_INFO").append("\n");
						flatFile.append("CUSTOMER_TYPE:")	.append(malaysiaCustomerInfoList.get(custIdx).getCustomerType()) .append("\n");
						flatFile.append("CUSTOMER_CD:")		.append(malaysiaCustomerInfoList.get(custIdx).getCustomerCd())   .append("\n");
						flatFile.append("CUSTOMER_NM1:")	.append(malaysiaCustomerInfoList.get(custIdx).getCustomerNm1())  .append("\n");
						flatFile.append("CUSTOMER_NM2:")	.append(malaysiaCustomerInfoList.get(custIdx).getCustomerNm2())  .append("\n");
						flatFile.append("CUSTOMER_ADDR1:")	.append(malaysiaCustomerInfoList.get(custIdx).getCustomerAddr1()).append("\n");
						flatFile.append("CUSTOMER_ADDR2:")	.append(malaysiaCustomerInfoList.get(custIdx).getCustomerAddr2()).append("\n");
						flatFile.append("CUSTOMER_ADDR3:")	.append(malaysiaCustomerInfoList.get(custIdx).getCustomerAddr3()).append("\n");
						flatFile.append("CONTACT_NM:")		.append(malaysiaCustomerInfoList.get(custIdx).getContactNm())    .append("\n");
						flatFile.append("CONTACT_TEL:")		.append(malaysiaCustomerInfoList.get(custIdx).getContactTel())   .append("\n");
						flatFile.append("CONTACT_FAX:")		.append(malaysiaCustomerInfoList.get(custIdx).getContactFax())   .append("\n");
						flatFile.append("CONTACT_EMAIL:")	.append(malaysiaCustomerInfoList.get(custIdx).getContactEmail()) .append("\n");
						flatFile.append("}CUSTOMER_INFO").append("\n");
					}
					
					//@ T/S이면 PSA2 삽입
					if("T".equals(malaysiaVslInfoVO.getTsTpCd())){
						//@ Principal Shipping Agent2 생성
						hrdVO = new BkgHrdCdgCtntListCondVO();
				        hrdVO.setHrdCdgId("MY_MF_PSA_CD");
						hrdVO.setAttrCtnt1(ts2ndVslInfoVO.getVvd().substring(0, 4));
						bkgHrdCdgCtntVOs = bookingUtil.searchHardCoding(hrdVO);
						
						flatFile.append("{CUSTOMER_INFO").append("\n");
						flatFile.append("CUSTOMER_TYPE:")	.append("PSA2").append("\n");
						if(bkgHrdCdgCtntVOs.size() > 0){
							custName = String.format("%-70s", bkgHrdCdgCtntVOs.get(0).getAttrCtnt3());
							custAddr = String.format("%-105s",bkgHrdCdgCtntVOs.get(0).getAttrCtnt4());
							flatFile.append("CUSTOMER_CD:")	  .append(bkgHrdCdgCtntVOs.get(0).getAttrCtnt2()).append("\n");
							flatFile.append("CUSTOMER_NM1:")  .append(custName.substring(0,35))              .append("\n");
							flatFile.append("CUSTOMER_NM2:")  .append(custName.substring(35,70))             .append("\n");
							flatFile.append("CUSTOMER_ADDR1:").append(custAddr.substring(0,35))              .append("\n");
							flatFile.append("CUSTOMER_ADDR2:").append(custAddr.substring(35,70))             .append("\n");
							flatFile.append("CUSTOMER_ADDR3:").append(custAddr.substring(70,105))            .append("\n");
							flatFile.append("CONTACT_NM:")	  .append(bkgHrdCdgCtntVOs.get(0).getAttrCtnt5()).append("\n");
							flatFile.append("CONTACT_TEL:")	  .append(bkgHrdCdgCtntVOs.get(0).getAttrCtnt6()).append("\n");
							flatFile.append("CONTACT_FAX:")	  .append(bkgHrdCdgCtntVOs.get(0).getAttrCtnt7()).append("\n");
							flatFile.append("CONTACT_EMAIL:") .append(bkgHrdCdgCtntVOs.get(0).getAttrCtnt8()).append("\n");
						}else{
							flatFile.append("CUSTOMER_CD:")	  .append("\n");
							flatFile.append("CUSTOMER_NM1:")  .append("\n");
							flatFile.append("CUSTOMER_NM2:")  .append("\n");
							flatFile.append("CUSTOMER_ADDR1:").append("\n");
							flatFile.append("CUSTOMER_ADDR2:").append("\n");
							flatFile.append("CUSTOMER_ADDR3:").append("\n");
							flatFile.append("CONTACT_NM:")	  .append("\n");
							flatFile.append("CONTACT_TEL:")	  .append("\n");
							flatFile.append("CONTACT_FAX:")	  .append("\n");
							flatFile.append("CONTACT_EMAIL:") .append("\n");
						}
						flatFile.append("}CUSTOMER_INFO").append("\n");
					}//@ PSA2 END
					
					// (6-0) CM Info 정보 BL단위 정보 전송으로 변경 2017.08.25
//					malaysiaCmInfoList = dbDao.searchCmInfo(malaysiaBlInputList.get(blIdx));
//					for( cmIdx = 0; cmIdx < malaysiaCmInfoList.size(); cmIdx++)
//					{
						flatFile.append("{CGO_INFO").append("\n");
						flatFile.append("CGO_SEQ:")		.append("1").append("\n"); //CGO_INFO 1회 반복
						flatFile.append("CGO_DESC:")	.append(malaysiaBlInputList.get(blIdx).getDescription2()).append("\n");
						flatFile.append("CGO_PKG:")		.append(malaysiaBlInputList.get(blIdx).getPckQty())      .append("\n");
						flatFile.append("CGO_PKG_UNIT:").append(malaysiaBlInputList.get(blIdx).getPckTpCd())     .append("\n");
						flatFile.append("CGO_WGT:")		.append(malaysiaBlInputList.get(blIdx).getActWgt())      .append("\n");
						flatFile.append("CGO_WGT_UNIT:").append(malaysiaBlInputList.get(blIdx).getWgtUtCd())     .append("\n");
						flatFile.append("CGO_MEA:")		.append(malaysiaBlInputList.get(blIdx).getMeasQty())     .append("\n");
						flatFile.append("CGO_MEA_UNIT:").append(malaysiaBlInputList.get(blIdx).getMeasUtCd())    .append("\n");						
						flatFile.append("HS_CODE:")		.append("").append("\n");// BL 단위이므로 빈값으로 전송
						flatFile.append("}CGO_INFO").append("\n");
//					}							
					// (7) Danger Goods 정보
					malaysiaDgGoodsInfoList = dbDao.searchDgGoodsInfo(malaysiaBlInputList.get(blIdx));//,malaysiaCustomerInfoList.get(custIdx).getcnytno()
					for( dgIdx = 0; dgIdx < malaysiaDgGoodsInfoList.size(); dgIdx++)
					{
						flatFile.append("{DANGER_GOODS").append("\n");
						flatFile.append("IMO_CLASS_NO:")	.append(malaysiaDgGoodsInfoList.get(dgIdx).getImoClassNo())    .append("\n");
						flatFile.append("UNDG_NO:")			.append(malaysiaDgGoodsInfoList.get(dgIdx).getUndgNo())        .append("\n");
						flatFile.append("FLASH_POINT:")		.append(malaysiaDgGoodsInfoList.get(dgIdx).getFlashPoint())    .append("\n");
						flatFile.append("FLASH_POINT_UNIT:").append(malaysiaDgGoodsInfoList.get(dgIdx).getFlashPointUnit()).append("\n");
						flatFile.append("PACKING_GROUP:")   .append(malaysiaDgGoodsInfoList.get(dgIdx).getPackingGroup())  .append("\n");
						flatFile.append("}DANGER_GOODS").append("\n");
					}
					
					// (7) Mark 정보
					malaysiaMarkInfoList = dbDao.searchMarkInfo(malaysiaBlInputList.get(blIdx));
					if(malaysiaMarkInfoList != null && malaysiaMarkInfoList.size()>0){
						for( markIdx = 0; markIdx < malaysiaMarkInfoList.size(); markIdx++)
						{
							flatFile.append("{MARK").append("\n");
							flatFile.append("MARKNO1:")			.append(malaysiaMarkInfoList.get(markIdx).getMark1()) .append("\n");
							flatFile.append("MARKNO2:")			.append(malaysiaMarkInfoList.get(markIdx).getMark2()) .append("\n");
							flatFile.append("MARKNO3:")			.append(malaysiaMarkInfoList.get(markIdx).getMark3()) .append("\n");
							flatFile.append("MARKNO4:")			.append(malaysiaMarkInfoList.get(markIdx).getMark4()) .append("\n");
							flatFile.append("MARKNO5:")			.append(malaysiaMarkInfoList.get(markIdx).getMark5()) .append("\n");
							flatFile.append("MARKNO6:")			.append(malaysiaMarkInfoList.get(markIdx).getMark6()) .append("\n");
							flatFile.append("MARKNO7:")			.append(malaysiaMarkInfoList.get(markIdx).getMark7()) .append("\n");
							flatFile.append("MARKNO8:")			.append(malaysiaMarkInfoList.get(markIdx).getMark8()) .append("\n");
							flatFile.append("MARKNO9:")			.append(malaysiaMarkInfoList.get(markIdx).getMark9()) .append("\n");
							flatFile.append("MARKNO10:")		.append(malaysiaMarkInfoList.get(markIdx).getMark10()).append("\n");
							flatFile.append("}MARK").append("\n");
						}
					}else{
						flatFile.append("{MARK").append("\n");
						flatFile.append("MARKNO1:") .append("NIL").append("\n");
						flatFile.append("MARKNO2:") .append("\n");
						flatFile.append("MARKNO3:") .append("\n");
						flatFile.append("MARKNO4:") .append("\n");
						flatFile.append("MARKNO5:") .append("\n");
						flatFile.append("MARKNO6:") .append("\n");
						flatFile.append("MARKNO7:") .append("\n");
						flatFile.append("MARKNO8:") .append("\n");
						flatFile.append("MARKNO9:") .append("\n");
						flatFile.append("MARKNO10:").append("\n");
						flatFile.append("}MARK").append("\n");
					}
					
					// (8) Description 정보
					flatFile.append("{DESC").append("\n");
					flatFile.append("DESC:")			.append(malaysiaBlInputList.get(blIdx).getDescription2()).append("\n");
					flatFile.append("}DESC").append("\n");
					
					totalSendCntrCnt += malaysiaCntrInputList.size();
					for( cntrIdx = 0; cntrIdx < malaysiaCntrInputList.size(); cntrIdx++)
					{
						
						if( malaysiaCntrInputList.get(cntrIdx).getBlNo().equals(malaysiaBlInputList.get(blIdx).getBlNo()) ){
							// (9) Container 정보
							flatFile.append("{CNTR_INFO").append("\n");
							flatFile.append("CNTRNBR:")	   .append(malaysiaCntrInputList.get(cntrIdx).getCntrNo())    .append("\n");
							flatFile.append("CNTRTYPE:")   .append(malaysiaCntrInputList.get(cntrIdx).getCntrTpszCd()).append("\n");
							
							
							flatFile.append("CNTR_ISO_TP:").append(dbDao.searchCntrIsoTp(malaysiaBlInputList.get(blIdx).getBlNo(), malaysiaCntrInputList.get(cntrIdx).getCntrNo())).append("\n");
							
							bkgCgoTpCd = dbDao.searchBkgCgoTpCd(malaysiaBlInputList.get(blIdx).getBkgNo());
							indFclLcl  = dbDao.searchIndFclLcl(malaysiaBlInputList.get(blIdx).getBkgNo(),malaysiaCntrInputList.get(cntrIdx).getCntrNo());
							
							if("P".equals(bkgCgoTpCd)||"R".equals(bkgCgoTpCd)){
							flatFile.append("CNTR_FM_IND:")		  .append("5").append("\n");
							}else{
								if("FCL".equals(indFclLcl)){
								  flatFile.append("CNTR_FM_IND:").append("1").append("\n");
								}else {
								  flatFile.append("CNTR_FM_IND:").append("3").append("\n");
								}
							}
							
							flatFile.append("CNTRWGT:")			.append(malaysiaCntrInputList.get(cntrIdx).getCntrWgt()) .append("\n");
							flatFile.append("CNTRWGT_UNIT:")	.append(malaysiaCntrInputList.get(cntrIdx).getWgtUtCd()) .append("\n");
							flatFile.append("CNTRMEA:")			.append(malaysiaCntrInputList.get(cntrIdx).getMeasQty()) .append("\n");
							flatFile.append("CNTRMEA_UNIT:")	.append(malaysiaCntrInputList.get(cntrIdx).getMeasUtCd()).append("\n");

							//@ Reefer Cargo 온도 조회
							if("R".equals(malaysiaCntrInputList.get(cntrIdx).getCntrTpszCd().substring(0,1))){
								malaysiaRfGoodsInfoList = dbDao.searchRfGoodsInfo(malaysiaCntrInputList.get(cntrIdx));
								if(malaysiaRfGoodsInfoList != null && malaysiaRfGoodsInfoList.size() > 0){
									flatFile.append("CNTR_TMP:")	 .append(malaysiaRfGoodsInfoList.get(0).getCntrTmp())    .append("\n");
									flatFile.append("CNTR_TMP_UNIT:").append(malaysiaRfGoodsInfoList.get(0).getCntrTmpUnit()).append("\n");
								}else{
									flatFile.append("CNTR_TMP:")	 .append("\n");
									flatFile.append("CNTR_TMP_UNIT:").append("\n");
								}
							}else{
								flatFile.append("CNTR_TMP:")	 .append("\n");
								flatFile.append("CNTR_TMP_UNIT:").append("\n");
							}
							
							// (10) Container Seal 정보
							malaysiaBlInputList.get(blIdx).setCntrNo(malaysiaCntrInputList.get(cntrIdx).getCntrNo());
							malaysiaCntrSealNoInfoList = dbDao.searchCntrSealNoInfo(malaysiaBlInputList.get(blIdx));
							for( sealIdx = 0; sealIdx < malaysiaCntrSealNoInfoList.size(); sealIdx++)
							{
								flatFile.append("{CNTR_SEAL_NO").append("\n");
								flatFile.append("SEALNBR:")	.append(malaysiaCntrSealNoInfoList.get(sealIdx).getSealnbr())    .append("\n");
								flatFile.append("SEALTYPE:").append(malaysiaCntrSealNoInfoList.get(sealIdx).getSealPtyTpCd()).append("\n");
								flatFile.append("}CNTR_SEAL_NO").append("\n");
							}
							
							flatFile.append("}CNTR_INFO").append("\n");
						}
					} // end for (Container)
					
					flatFile.append("}BL_INFO").append("\n");

					// flatFile MQ로 전송
					ediSendMessage(flatFile.toString(), "BKG.ALPSBKG_UBIZHJS_SLKMFT.IBMMQ.QUEUE");
					
					returnFlatFile.append(flatFile.toString());
				} // end for (BL)
	
				// send Flat File log VO 셋팅
				BkgCstmsMySndLogVO bkgCstmsMySndLogVO = new BkgCstmsMySndLogVO(); // send
				
				// 전송로그를 저장한다. (MASTER)
				bkgCstmsMySndLogVO.setMyMfSndIndCd(malaysiaVslInfoVO.getStatus());
				bkgCstmsMySndLogVO.setFltFileRefNo(flatFileRefNo);
				bkgCstmsMySndLogVO.setVvd(malaysiaVslInfoVO.getVvd());
				bkgCstmsMySndLogVO.setPolCd(malaysiaBlInputList.get(0).getInputPolCd());
				bkgCstmsMySndLogVO.setPodCd(malaysiaBlInputList.get(0).getInputPodCd());
				bkgCstmsMySndLogVO.setMyCstmsBndCd(malaysiaVslInfoVO.getEIInd());
				bkgCstmsMySndLogVO.setOfcCd(account.getOfc_cd());
				
				//@ EDI전송 B/L건수를 VVD별 전체 건수에서 전송한 B/L 및 Container 수를 로깅한다. 2017.08.22
//				bkgCstmsMySndLogVO.setBlKnt(malaysiaBlInputList.get(0).getBlKnt());
//				bkgCstmsMySndLogVO.setTtlCntrKnt(malaysiaBlInputList.get(0).getTtlCntrKnt());
				bkgCstmsMySndLogVO.setBlKnt(malaysiaBlInputList.size()+"");
				bkgCstmsMySndLogVO.setTtlCntrKnt(totalSendCntrCnt+"");
				bkgCstmsMySndLogVO.setUsrId(account.getUsr_id());
				dbDao.addCUSCARSndLog(bkgCstmsMySndLogVO);
				
				//FlatFile을 4000Byte씩 나눈다 - start (100Byte의 여유를 주기 위해 3900Byte로 나눔)
				int divisor   = 3900;
				int totLength = returnFlatFile.length();
				int quotient  = totLength / divisor;
				int remainder = totLength % divisor;
					
				int loopCnt = 0;
				int start = 0;
				int end = 0;
				
				if(remainder > 0) {
					loopCnt = quotient + 1;
				} else {
					loopCnt = quotient;
				}
				
				BkgCstmsMySndLogDtlVO bkgCstmsMySndLogDtlVO = null; // send
				for(int i = 0; i < loopCnt; i++) {
					if(i == loopCnt-1) {
						end = remainder;
					} else {
						end = divisor;
					}
					
					start = i * divisor;
					
					bkgCstmsMySndLogDtlVO = new BkgCstmsMySndLogDtlVO(); // send
					bkgCstmsMySndLogDtlVO.setMyMfSndIndCd(malaysiaVslInfoVO.getStatus());
					bkgCstmsMySndLogDtlVO.setFltFileRefNo(flatFileRefNo);
					bkgCstmsMySndLogDtlVO.setLogDtlSeq(Integer.toString(i+1));
					bkgCstmsMySndLogDtlVO.setEdiSndMsg(returnFlatFile.substring(start, start+end));//3900Byte씩 저장
					bkgCstmsMySndLogDtlVO.setUsrId(account.getUsr_id());
					
					// 전송로그를 저장한다. (DETAIL)
				
					dbDao.addCUSCARSndDtlLog(bkgCstmsMySndLogDtlVO);
					
				}	
				
			}
			catch (DAOException ex)
			{
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
			}
			catch (Exception ex)
			{
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
			}
			return returnFlatFile.toString();
		}

}
