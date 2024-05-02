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

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.integration.VietnamCustomsTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.vo.BkgCstmsVnSndLogDtlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.vo.BkgCstmsVnSndLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.vo.VietnamManifestBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.vo.VietnamManifestCntrSealNoInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.vo.VietnamManifestCustomerInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.vo.VietnamManifestDescInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.vo.VietnamManifestDgGoodsInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.vo.VietnamManifestListCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.vo.VietnamManifestLocInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.vo.VietnamManifestMarkInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vietnam.vo.VietnamManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.vo.VietnamManifestListBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.vo.VietnamManifestListCondVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - NIS2010-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author LIM JAE TAEK
 * @see EventResponse,MalaysiaCustomsTransmissionBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class VietnamCustomsTransmissionBCImpl extends CustomsTransmissionBCImpl {
	// Database Access Object
	private transient VietnamCustomsTransmissionDBDAO dbDao = null;

	/**  
	 * VietnamCustomsTransmissionBCImpl 객체 생성<br>
	 * VietnamCustomsTransmissionBCImpl 생성한다.<br>
	 */
	public VietnamCustomsTransmissionBCImpl() {
		dbDao = new VietnamCustomsTransmissionDBDAO();
	}


	/**
	 * Vietnam 세관신고 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException {

		BookingUtil		bookingUtil		= new BookingUtil();
		
		// FLATFILE
		String 			senderId 		= "";
		String 			receiverId 		= "";
		String 			headerType 		= "";
		String 		 	flatFileHeader	= null;
		String 		 	flatFileRefNo	= null;
		StringBuffer 	flatFile 		= new StringBuffer();	
		
		// -- Input 정보 -- //
		//전송할 BL LIST
		VietnamManifestTransmitVO[] 			vietnamManifestTransmitVOs = (VietnamManifestTransmitVO[]) manifestTransmitVOs;
		//조회 조건
		VietnamManifestListCondVO				vietnamCondVO 			= vietnamManifestTransmitVOs[0].getVietnamManifestListCondVO();
		//B/L Input 정보
		List<VietnamManifestListBlInfoVO> 		vietnamBlInputList 		= vietnamManifestTransmitVOs[0].getVietnamManifestListBlInfoVOs();
		//Container Input 정보
		//List<MalaysiaManifestListCntrInfoVO> 	malaysiaCntrInputList 		= vietnamManifestTransmitVOs[0].getMalaysiaManifestListCntrInfoVOs();
		
		// -- Output 정보 -- //

		//////////////////////////////////////////////////////////////////////////////////////////////////
		//Container 정보
		List<VietnamManifestListCntrInfoVO> 	vietnamCntrInputList = null;
		// Container Seal 정보
		List<VietnamManifestCntrSealNoInfoVO> 	vietnamCntrSealNoInfoList 	= null;
		// Location 정보
		List<VietnamManifestLocInfoVO> 		    vietnamLocInfoList 		= null;
		// Customer 정보
		List<VietnamManifestCustomerInfoVO> 	vietnamCustomerInfoList 	= null;
		// Description 정보
		List<VietnamManifestDescInfoVO>  		vietnamDescInfoList = null;
		// Mark 정보
		List<VietnamManifestMarkInfoVO> 		vietnamMarkInfoList 		= null;
		
		// Bl  정보
		List<VietnamManifestBlInfoVO> 		vietnamBlList 		= null;
		// Danger Goods 정보
		List<VietnamManifestDgGoodsInfoVO> 	vietnamDgGoodsInfoList 	= null;
		
		//내림차순 정렬을 위한 일회성 정보
		VietnamManifestListBlInfoVO temp = null;
		
		// -- For문 Index -- //
		int blIdx 	= 0;
		int locIdx 	= 0;
		int custIdx = 0;
		int dgIdx 	= 0;
		int markIdx = 0;
		int cntrIdx = 0;
		int sealIdx = 0;
		int descIdx = 0;
		int blCntrIdx =0;
		int blSeIdx = 0;
		int blThIdx =0;
		
	
		
		try
		{

			// Body 생성
			if( vietnamBlInputList != null ){
				// Header 생성
				senderId = "SML";
				receiverId = "VNCUSTOMS";
				headerType = "CUSCAR";
				flatFileHeader = bookingUtil.searchCstmsEdiHeader(senderId, receiverId, headerType);
				flatFile.append(flatFileHeader).append("\n");
				
				if( blIdx == 0 ){
					flatFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("BKC"));
				}					
				// (1) VSL 정보				
						
				flatFile.append("MSG_TYPE:")			.append("85").append("\n");
				flatFile.append("STATUS:")			.append(vietnamBlInputList.get(blIdx).getTrsmSts()).append("\n"); // 확인해보기 
				flatFile.append("ISSUE_DATE:")				.append(dbDao.searchIssueDate(vietnamBlInputList.get(blIdx).getVvd())).append("\n");
				flatFile.append("VSL_CODE:")	.append(vietnamBlInputList.get(blIdx).getVvd().substring(0, 4)).append("\n");
				flatFile.append("VOYAGE:")		.append(vietnamBlInputList.get(blIdx).getVvd().substring(4, 8)).append("\n");
//				flatFile.append("VSL_CODE:")	.append(vietnamCondVO.getToVslCd()).append("\n");
//				flatFile.append("VOYAGE:")		.append(vietnamCondVO.getToSkdVoyNo()).append("\n");
				flatFile.append("VSL_NAME:")	.append(vietnamBlInputList.get(blIdx).getVslNm()).append("\n");
				flatFile.append("VSL_LLOYD_NO:")			.append(dbDao.searchVslLloydNo(vietnamBlInputList.get(blIdx).getVvd())).append("\n");
				flatFile.append("VSL_CALLSIGN:")			.append(vietnamBlInputList.get(blIdx).getVslCallsign()).append("\n");
				flatFile.append("VSL_NATION_CD:")				.append(dbDao.searchVslNationCd(vietnamBlInputList.get(blIdx).getVvd())).append("\n");
				
				if("1".equals(vietnamBlInputList.get(0).getPolGubun())){ //Outbound일 때
				flatFile.append("PORT:")				.append(vietnamBlInputList.get(blIdx).getVPol()).append("\n");
				flatFile.append("PORT_NM:")				.append(dbDao.searchPortNm(vietnamBlInputList.get(blIdx).getVPol())).append("\n");
				}else{
					flatFile.append("PORT:")				.append(vietnamBlInputList.get(blIdx).getVPod()).append("\n");
					flatFile.append("PORT_NM:")				.append(dbDao.searchPortNm(vietnamBlInputList.get(blIdx).getVPod())).append("\n");
				}
				flatFile.append("ETA:")				.append(vietnamBlInputList.get(blIdx).getEta()).append("\n");
				flatFile.append("ETD:")				.append(vietnamBlInputList.get(blIdx).getEtd()).append("\n");
				log.debug("============================POL_GUBUN"+vietnamBlInputList.get(blIdx).getPolGubun());
			//}
					
				//(2)Container 정보
			   //vietnamBlList = dbDao.searchBlInfo(vietnamBlInputList.get(blIdx)); jjang
				
				// CNTR 별로 내림차순 정렬
				for(int i = 0; i < vietnamBlInputList.size(); i++) {
					for(int j = 0; j < vietnamBlInputList.size(); j++) {
						if(vietnamBlInputList.get(i).getCntrNo().compareTo(vietnamBlInputList.get(j).getCntrNo()) > 0){
							temp = vietnamBlInputList.get(i);
							vietnamBlInputList.set(i,vietnamBlInputList.get(j));
							vietnamBlInputList.set(j,temp);
						}
					}
				}
				
			    for( cntrIdx = 0; cntrIdx < vietnamBlInputList.size(); cntrIdx++){
			    	
			    	// 동일한 container에 부킹이 여러개 붙어 있을 수 있기 때문에 필터링을 한다.
			    	if(cntrIdx > 0){
				    	if(vietnamBlInputList.get(cntrIdx).getCntrNo().equals(vietnamBlInputList.get(cntrIdx-1).getCntrNo())){
				    		continue;
				    	}
			    	}
			    	
			    	vietnamCntrInputList = new ArrayList<VietnamManifestListCntrInfoVO>();
			    	vietnamCntrInputList = dbDao.searchContainerInfo(vietnamBlInputList.get(cntrIdx));				
			    	
			    	//for( cntrIdx = 0; cntrIdx < vietnamCntrInputList.size(); cntrIdx++){							
					flatFile.append("{CNTR_INFO").append("\n");
					flatFile.append("CNTRNBR:")			.append(vietnamCntrInputList.get(0).getCntrNbr()).append("\n");
					flatFile.append("CNTRTYPE:")		.append(vietnamCntrInputList.get(0).getCntrType()).append("\n");
					flatFile.append("CNTR_STATUS:")		.append(vietnamCntrInputList.get(0).getCntrStatus()).append("\n");
					flatFile.append("CNTR_FM_IND:")		.append(vietnamCntrInputList.get(0).getCntrFmInd()).append("\n");					
//					flatFile.append("CNTR_G_WGT:")		.append(vietnamCntrInputList.get(0).getCntrGWgt()).append("\n");
					//부킹이 여러개일 경우 sum된 값을 사용 하기 위해서 화면에서 구한 후 반영 한다, 따라서 VO가 상의
					flatFile.append("CNTR_G_WGT:")		.append(vietnamBlInputList.get(cntrIdx).getActWgtSum()).append("\n");
					flatFile.append("CNTR_G_WGT_UNIT:")	.append(vietnamCntrInputList.get(0).getCntrGWgtUnit()).append("\n");
					flatFile.append("CNTR_T_WGT:")		.append(vietnamCntrInputList.get(0).getCntrTWgt()).append("\n");
					flatFile.append("CNTR_T_WGT_UNIT:")	.append(vietnamCntrInputList.get(0).getCntrTWgtUnit()).append("\n");
					flatFile.append("CNTR_V_WGT:")		.append(vietnamCntrInputList.get(0).getMeasQty()).append("\n");
					flatFile.append("CNTR_V_WGT_UNIT:")	.append(vietnamCntrInputList.get(0).getMeasUtCd()).append("\n");
					flatFile.append("CNTR_TMP:")		.append(vietnamCntrInputList.get(0).getCntrTmp()).append("\n");
					flatFile.append("CNTR_TMP_UNIT:")	.append(vietnamCntrInputList.get(0).getCgoTmpUnit()).append("\n");
						
					// (3) Container Seal 정보							
					vietnamCntrSealNoInfoList = dbDao.searchCntrSealNoInfo(vietnamBlInputList.get(cntrIdx));//반복 확인하기
					for( sealIdx = 0; sealIdx < vietnamCntrSealNoInfoList.size(); sealIdx++)
					{
						flatFile.append("{CNTR_SEAL_NO").append("\n");
						flatFile.append("SEALNBR:")	    .append(vietnamCntrSealNoInfoList.get(sealIdx).getSealnbr()).append("\n");
						flatFile.append("}CNTR_SEAL_NO").append("\n");
					}
					flatFile.append("}CNTR_INFO").append("\n");
			    }
					  
			
					
				// BL 별로 내림차순 정렬
				for(int i = 0; i < vietnamBlInputList.size(); i++) {
					for(int j = 0; j < vietnamBlInputList.size(); j++) {
						if(vietnamBlInputList.get(i).getBkgNo().compareTo(vietnamBlInputList.get(j).getBkgNo()) > 0){
							temp = vietnamBlInputList.get(i);
							vietnamBlInputList.set(i,vietnamBlInputList.get(j));
							vietnamBlInputList.set(j,temp);
						}
					}
				}	
					
				// (4) B/L 정보				    
			    for(blThIdx = 0; blThIdx < vietnamBlInputList.size(); blThIdx++){
			    	//동일 BL 스킵 : container 여러 건 화면에서 넘어와 있어서 동일 BL 정보 스킵
			    	if(blThIdx > 0){
				    	if(vietnamBlInputList.get(blThIdx).getBkgNo().equals(vietnamBlInputList.get(blThIdx-1).getBkgNo())){
				    		continue;
				    	}
			    	}
				    	
			    	vietnamBlList = dbDao.searchBlInfo(vietnamBlInputList.get(blThIdx));
			    	//for( blSeIdx = 0; blSeIdx < vietnamBlInputList.size(); blSeIdx++){
			    	blSeIdx++;
					flatFile.append("{BL_INFO").append("\n");
					flatFile.append("LOOP_IND:")		.append(blSeIdx).append("\n");//1 부터 시작
					flatFile.append("BLNBR:")			.append(vietnamBlList.get(0).getBlNo()).append("\n");
					flatFile.append("BKGNBR:")			.append(vietnamBlList.get(0).getBkgNo()).append("\n");
					flatFile.append("BL_IND:")			.append(vietnamBlList.get(0).getBlInd()).append("\n");
					flatFile.append("BLPKG:")			.append(vietnamBlList.get(0).getBlPkg()).append("\n");
					flatFile.append("BLPKGU:")			.append(vietnamBlList.get(0).getBlpkgUnit()).append("\n");
					flatFile.append("BLWGT:")			.append(vietnamBlList.get(0).getBlWgt()).append("\n");
					flatFile.append("BLWGT_UNIT:")		.append(vietnamBlList.get(0).getBlwgtUnit()).append("\n");
					flatFile.append("BLVOL:")			.append(vietnamBlList.get(0).getBlVol()).append("\n");
					flatFile.append("BLVOL_UNIT:")		.append(vietnamBlList.get(0).getBlvolUnit()).append("\n");
					flatFile.append("BLMEA:")			.append(vietnamBlList.get(0).getBlMea()).append("\n");
					flatFile.append("BLMEA_UNIT:")		.append(vietnamBlList.get(0).getBlmeaUnit()).append("\n");
					flatFile.append("COMMODITY_CD:")	.append(vietnamBlList.get(0).getCommodityCd()).append("\n");
						
					
					// (5) Location 정보
					vietnamLocInfoList = dbDao.searchLocInfo(vietnamBlInputList.get(blThIdx));
					for( locIdx = 0; locIdx < vietnamLocInfoList.size(); locIdx++){
						flatFile.append("{LOC_INFO").append("\n");
						flatFile.append("LOC_TYPE:")		.append(vietnamLocInfoList.get(locIdx).getLocType()).append("\n");
						flatFile.append("LOC_CD:")			.append(vietnamLocInfoList.get(locIdx).getLocCd()).append("\n");
						flatFile.append("LOC_NM:")			.append(vietnamLocInfoList.get(locIdx).getLocNm()).append("\n");
						flatFile.append("LOC_ETA:")			.append(vietnamLocInfoList.get(locIdx).getLocEta()).append("\n");
						flatFile.append("LOC_ETD:")			.append(vietnamLocInfoList.get(locIdx).getLocEtd()).append("\n");
						flatFile.append("}LOC_INFO").append("\n");
					}

					// (6) Customer 정보
					vietnamBlInputList.get(blIdx).setUsrId(account.getUsr_id());
					vietnamCustomerInfoList = dbDao.searchCustomerInfo(vietnamBlInputList.get(blThIdx));// 반복 확인 
					for( custIdx = 0; custIdx < vietnamCustomerInfoList.size(); custIdx++){
						flatFile.append("{CUSTOMER_INFO").append("\n");
						flatFile.append("CUSTOMER_TYPE:")	.append(vietnamCustomerInfoList.get(custIdx).getCustomerType()).append("\n");
						flatFile.append("CUSTOMER_CD:")		.append(vietnamCustomerInfoList.get(custIdx).getCustomerCd()).append("\n");
						flatFile.append("CUSTOMER_NM1:")	.append(vietnamCustomerInfoList.get(custIdx).getCustomerNm1()).append("\n");
						flatFile.append("CUSTOMER_NM2:")	.append(vietnamCustomerInfoList.get(custIdx).getCustomerNm2()).append("\n");
						flatFile.append("CUSTOMER_ADDR1:")	.append(vietnamCustomerInfoList.get(custIdx).getCustomerAddr1()).append("\n");
						flatFile.append("CUSTOMER_ADDR2:")	.append(vietnamCustomerInfoList.get(custIdx).getCustomerAddr2()).append("\n");
						flatFile.append("CUSTOMER_ADDR3:")	.append(vietnamCustomerInfoList.get(custIdx).getCustomerAddr3()).append("\n");
						flatFile.append("CONTACT_NM:")		.append(vietnamCustomerInfoList.get(custIdx).getContactNm()).append("\n");
						flatFile.append("CONTACT_TEL:")		.append(vietnamCustomerInfoList.get(custIdx).getContactTel()).append("\n");
						flatFile.append("CONTACT_FAX:")		.append(vietnamCustomerInfoList.get(custIdx).getContactFax()).append("\n");
						flatFile.append("CONTACT_EMAIL:")	.append(vietnamCustomerInfoList.get(custIdx).getContactEmail()).append("\n");
						flatFile.append("}CUSTOMER_INFO").append("\n");
					}						
					
			     	// (7) Danger Goods 정보
					vietnamDgGoodsInfoList = dbDao.searchDgGoodsInfo(vietnamBlInputList.get(blThIdx));//,malaysiaCustomerInfoList.get(custIdx).getcnytno()
					for( dgIdx = 0; dgIdx < vietnamDgGoodsInfoList.size(); dgIdx++){
						flatFile.append("{DANGER_GOODS").append("\n");
						flatFile.append("IMO_CLASS_NO:")		.append(vietnamDgGoodsInfoList.get(dgIdx).getImoClassNo()).append("\n");
						flatFile.append("IMO_PAGE_NO:")		.append(vietnamDgGoodsInfoList.get(dgIdx).getImoPageNo()).append("\n");
														
						flatFile.append("HAZARD_CD:")		.append(vietnamDgGoodsInfoList.get(dgIdx).getHazardCd()).append("\n");
						flatFile.append("UNDG_NO:")			.append(vietnamDgGoodsInfoList.get(dgIdx).getUndgNo()).append("\n");
						flatFile.append("FLASH_POINT:")		.append(vietnamDgGoodsInfoList.get(dgIdx).getFlashPoint()).append("\n");
						flatFile.append("FLASH_POINT_UNIT:")		.append(vietnamDgGoodsInfoList.get(dgIdx).getFlashPointUnit()).append("\n");
						flatFile.append("PACKING_GROUP:")		.append(vietnamDgGoodsInfoList.get(dgIdx).getPackingGroup()).append("\n");
						flatFile.append("EMS_NO:")		.append(vietnamDgGoodsInfoList.get(dgIdx).getEmsNo()).append("\n");
						flatFile.append("MFAG:")		.append(vietnamDgGoodsInfoList.get(dgIdx).getMfag()).append("\n");
						flatFile.append("TREM_CARD_NO:")		.append(vietnamDgGoodsInfoList.get(dgIdx).getTremCardNo()).append("\n");
						
						flatFile.append("}DANGER_GOODS").append("\n");
					}
						
					// (8) Description 정보(최대 350자 70자식 5번 반복)			
					vietnamDescInfoList = dbDao.searchDescInfo(vietnamBlInputList.get(blThIdx));//반복 확인하기
					for( descIdx = 0; descIdx < vietnamDescInfoList.size(); descIdx++){
						// 전체길이 - (전체길이%70) / 70+1;
						String desc = vietnamDescInfoList.get(descIdx).getDescription();
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
					vietnamMarkInfoList = dbDao.searchMarkInfo(vietnamBlInputList.get(blThIdx));
					for( markIdx = 0; markIdx < vietnamMarkInfoList.size(); markIdx++){
						flatFile.append("{MARK").append("\n");
						flatFile.append("MARKNO1:")			.append(vietnamMarkInfoList.get(markIdx).getMark1()).append("\n");
						flatFile.append("MARKNO2:")			.append(vietnamMarkInfoList.get(markIdx).getMark2()).append("\n");
						flatFile.append("MARKNO3:")			.append(vietnamMarkInfoList.get(markIdx).getMark3()).append("\n");
						flatFile.append("MARKNO4:")			.append(vietnamMarkInfoList.get(markIdx).getMark4()).append("\n");
						flatFile.append("MARKNO5:")			.append(vietnamMarkInfoList.get(markIdx).getMark5()).append("\n");
						flatFile.append("MARKNO6:")			.append(vietnamMarkInfoList.get(markIdx).getMark6()).append("\n");
						flatFile.append("MARKNO7:")			.append(vietnamMarkInfoList.get(markIdx).getMark7()).append("\n");
						flatFile.append("MARKNO8:")			.append(vietnamMarkInfoList.get(markIdx).getMark8()).append("\n");
						flatFile.append("MARKNO9:")			.append(vietnamMarkInfoList.get(markIdx).getMark9()).append("\n");
						flatFile.append("MARKNO10:")		.append(vietnamMarkInfoList.get(markIdx).getMark10()).append("\n");
						flatFile.append("}MARK").append("\n");
					}
						
					// (10) BL CNTR 정보
//					vietnamBlCntrInfoList = dbDao.searchBlCntrInfo(vietnamBlInputList.get(blThIdx));
//					for( blCntrIdx = 0; blCntrIdx < vietnamBlCntrInfoList.size(); blCntrIdx++){
//						for(blCntrChkIdx = 0; blCntrChkIdx < vietnamBlInputList.size();blCntrChkIdx++){
//							if(vietnamBlCntrInfoList.get(blCntrIdx).getBlCntrnbr().equals(vietnamBlInputList.get(blCntrChkIdx).getCntrNo())){
//								flatFile.append("{BL_CNTR_INFO").append("\n");
//								flatFile.append("BL_CNTRNBR:")			.append(vietnamBlCntrInfoList.get(blCntrIdx).getBlCntrnbr()).append("\n");
//								flatFile.append("BL_PKG_QTY:")			.append(vietnamBlCntrInfoList.get(blCntrIdx).getBlPkgQty()).append("\n");
//								
//								flatFile.append("}BL_CNTR_INFO").append("\n");
//							}
//						}							
//					}
					
					for( blCntrIdx = 0; blCntrIdx < vietnamBlInputList.size(); blCntrIdx++){
						
						//for(blCntrChkIdx = 0; blCntrChkIdx < vietnamBlInputList.size();blCntrChkIdx++){
						if(vietnamBlInputList.get(blThIdx).getBkgNo().equals(vietnamBlInputList.get(blCntrIdx).getBkgNo())){
							flatFile.append("{BL_CNTR_INFO").append("\n");
							flatFile.append("BL_CNTRNBR:")			.append(vietnamBlInputList.get(blCntrIdx).getCntrNo()).append("\n");
							//flatFile.append("BL_PKG_QTY:")			.append(vietnamBlInputList.get(blCntrIdx).getBlPkgQty()).append("\n");
							flatFile.append("BL_PKG_QTY:")			.append(vietnamBlInputList.get(blCntrIdx).getPckQty()).append("\n");
							
							flatFile.append("}BL_CNTR_INFO").append("\n");
						}
					}							
					//}						
					flatFile.append("}BL_INFO").append("\n");
			    }  // end for (BL)		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       	
			} // end Body
			
			// send Flat File log VO 셋팅
			BkgCstmsVnSndLogVO bkgCstmsVnSndLogVO = new BkgCstmsVnSndLogVO(); // send
			BkgCstmsVnSndLogDtlVO bkgCstmsVnSndLogDtlVO = new BkgCstmsVnSndLogDtlVO(); // send		
			
			if(bkgCstmsVnSndLogVO != null && vietnamBlInputList != null) {
				// 전송로그를 저장한다. (MASTER)
				bkgCstmsVnSndLogVO.setVnMfSndIndCd(vietnamBlInputList.get(blIdx).getTrsmSts());
				bkgCstmsVnSndLogVO.setFltFileRefNo(flatFileRefNo);
				bkgCstmsVnSndLogVO.setVvd(vietnamBlInputList.get(blIdx).getVvd());
				bkgCstmsVnSndLogVO.setPolCd(vietnamBlInputList.get(blIdx).getVPol());
				bkgCstmsVnSndLogVO.setPodCd(vietnamBlInputList.get(blIdx).getVPodCd());
				if ("1".equals(vietnamBlInputList.get(0).getPolGubun())) {
					bkgCstmsVnSndLogVO.setVnCstmsBndCd("E");// Outbound
				} else {
					bkgCstmsVnSndLogVO.setVnCstmsBndCd("I"); // Inbound
				}
				bkgCstmsVnSndLogVO.setOfcCd(account.getOfc_cd());
				bkgCstmsVnSndLogVO.setBkgNo(vietnamBlInputList.get(blIdx).getBkgNo());
				bkgCstmsVnSndLogVO.setCntrNo(vietnamBlInputList.get(blIdx).getCntrNo());
				bkgCstmsVnSndLogVO.setUsrId(account.getUsr_id());
				bkgCstmsVnSndLogVO.setToVslCd(vietnamCondVO.getToVslCd());
				bkgCstmsVnSndLogVO.setToSkdVoyNo(vietnamCondVO.getToSkdVoyNo());
				bkgCstmsVnSndLogVO.setToSkdDirCd(vietnamCondVO.getToSkdDirCd());

			
				dbDao.addCUSCARSndLog(bkgCstmsVnSndLogVO);
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


				bkgCstmsVnSndLogDtlVO.setVnMfSndIndCd(vietnamBlInputList.get(blIdx).getTrsmSts());
				bkgCstmsVnSndLogDtlVO.setFltFileRefNo(flatFileRefNo);
				bkgCstmsVnSndLogDtlVO.setLogDtlSeq(Integer.toString(i+1));
				bkgCstmsVnSndLogDtlVO.setEdiSndMsg(fFiles[i]);
				bkgCstmsVnSndLogDtlVO.setUsrId(account.getUsr_id());
				
				// 전송로그를 저장한다. (DETAIL)
				if( bkgCstmsVnSndLogDtlVO != null ){
					dbDao.addCUSCARSndDtlLog(bkgCstmsVnSndLogDtlVO);
				}				
			}

			
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

		VietnamCustomsTransmissionBackEndJob backEndJob = new VietnamCustomsTransmissionBackEndJob ();
		backEndJob.setPgmNo(pgmNo);
		String resultStr = "";
		
		if(pgmNo.equals("ESM_BKG_1149")) {
			backEndJob.setManifestTransmitVOs(manifestTransmitVOs);
			backEndJob.setAccount(account);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			resultStr = backEndJobManager.execute(backEndJob , account.getUsr_id(), "Vietnam EDI Transmit");
		}
		
		return resultStr;
	}

}
