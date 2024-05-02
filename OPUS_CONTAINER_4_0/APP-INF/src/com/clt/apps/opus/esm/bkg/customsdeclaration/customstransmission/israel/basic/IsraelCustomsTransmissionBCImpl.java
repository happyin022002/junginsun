/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : IsraelCustomsTransmissionBCImpl.java
 *@FileTitle : IsraelCustomsTransmissionBCImpl
 *Open Issues :
 *Change history :
*@LastModifyDate : 2013.08.11
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.08.11 김보배
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.basic;

import java.util.List;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customscommonmgt.basic.CustomsCommonMgtBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.integration.IsraelCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.vo.IsraelManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.vo.searchBlCMinfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.vo.searchBlCntrMfDescVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.vo.searchBlCntrSealNoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.vo.searchBlCntrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.vo.searchBlCustVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.vo.searchBlDgCgoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.vo.searchBlGeneralVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.vo.searchBlRouteCountryVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.israel.vo.sendHistoryVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.clt.bizcommon.edi.broker.ReferenceNumberGeneratorBroker;
import com.clt.bizcommon.edi.generator.IReferenceNumberGenerator;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.utilitybox.initialization.InterfaceInitializer;

/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author BOBAE KIM
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */ 
public class IsraelCustomsTransmissionBCImpl extends BasicCommandSupport implements IsraelCustomsTransmissionBC {

	// Database Access Object
	private transient IsraelCustomsTransmissionDBDAO dbDao = null;

	/**
	 * CustomsTransmissionBCImpl 객체 생성<br>
	 * CustomsTransmissionDBDAO를 생성한다.<br>
	 */
	public IsraelCustomsTransmissionBCImpl() {
		dbDao = new IsraelCustomsTransmissionDBDAO();
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * EUR를 통과하는 화물에 대한 Manifest를 ACP(Authority of Canal of Panama)에 신고하기 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException {
		
		log.debug("####################################################\n\n\n\n\n transmitManifest START!");
		StringBuffer flatFile = null;
		StringBuffer result = new StringBuffer();
		StringBuffer bfTemp = new StringBuffer();
		
		IsraelManifestTransmitVO israelManifestTransmitVO = new IsraelManifestTransmitVO();

		List<searchBlGeneralVO> searchBlGeneralVOs = null;
		List<searchBlCustVO> searchBlCustVOs = null;
		List<searchBlCntrVO> searchBlCntrVOs = null;
		List<searchBlDgCgoVO> searchBlDgCgoVOs = null;
		List<searchBlCntrMfDescVO> searchBlCntrMfDescVOs = null;
		List<searchBlCntrSealNoVO> searchBlCntrSealNoVOs = null;
		List<searchBlCMinfoVO> searchBlCMinfoVOs = null;
		List<searchBlRouteCountryVO> searchBlRouteCountryVOs = null;
		
//		String pSendYn = ""; 
		
		searchBlGeneralVO blinfoVO = null;
		searchBlCustVO custVO = null;
		searchBlCntrVO cntrVO = null;
		searchBlDgCgoVO dgCgoVO = null;
		searchBlCntrMfDescVO cntrMfVO = null;
		searchBlCntrSealNoVO cntrSealVO = null;
		searchBlCMinfoVO cMinfoVO = null;
		
		BookingUtil command = new BookingUtil();
		
		// 헤더 생성용 객체
		String flatFileHeader = null;
		String flatFileRefNo = null;
		BookingUtil bookingUtil = new BookingUtil();
		
		sendHistoryVO sendHistoryVO = null; //이력 테이블 VO
		
		String blNo = "";
		String vslCd = "";
		String skdVoyNo = "";
		String skdDirCd = "";
		String cstmsPortCd = "";
		String cntrNo = "";
		String uploadEtaHis = "";
		
		String[] tempStr = null;
		int tempCount = 0;
		
		try {
			if (manifestTransmitVOs.length > 0) {
//				pSendYn = ((IsraelManifestTransmitVO)manifestTransmitVOs[0]).getPSendYn(); 
				String blNumber = ""; // bl_no별 전송하기 때문에 같은 bl_no를 체크하기 위함.
				for (int q = 0; q < manifestTransmitVOs.length; q++) {
					
					flatFile = new StringBuffer();
					bfTemp.setLength(0);
					
					israelManifestTransmitVO = (IsraelManifestTransmitVO) manifestTransmitVOs[q];
					
					blNo     = israelManifestTransmitVO.getBlNo();
					vslCd    = israelManifestTransmitVO.getVslCd();
					skdVoyNo = israelManifestTransmitVO.getSkdVoyNo();
					skdDirCd = israelManifestTransmitVO.getSkdDirCd();
					cstmsPortCd = israelManifestTransmitVO.getPolCd();
					
					log.debug("::::::::::::::::::::::::::::");
					log.debug("::::::::::::::::::::::::::::");
					log.debug("blNo:" + blNo);
					log.debug("vslCd:" + vslCd);
					log.debug("skdVoyNo:" + skdVoyNo);
					log.debug("skdDirCd:" + skdDirCd);
					log.debug("cstmsPortCd:" + cstmsPortCd);
					log.debug("::::::::::::::::::::::::::::");
					log.debug("::::::::::::::::::::::::::::");
					
					if (blNumber.equals(blNo)) continue;// 이전 bl과 같으면 건너뛴다.
					
					blNumber = blNo;
					
					//************************* Bl info 조회 ****************************
					searchBlGeneralVOs = dbDao.searchBlGeneral(blNo, vslCd, skdVoyNo, skdDirCd, cstmsPortCd);
					
					if(searchBlGeneralVOs.size() <= 0 ) continue; //검색된것이 없으면 건너뛴다.//에러 처리
					
					blinfoVO = searchBlGeneralVOs.get(0);
					// Header 생성
					String mrn = blinfoVO.getMrn();
					if (mrn != null && !"".equals(mrn)) {
						mrn = blinfoVO.getMrn().substring(0, 4);
					} else {
						mrn = "";
					}
					
					// 원래 있던 플랫파일 헤더 생성 부분
//					flatFileHeader = bookingUtil.searchCstmsEdiHeader(sender, receiver+cstmsPortCd.substring(0, 2), blinfoVO.getMsgIdCd());
//					flatFileHeader = bookingUtil.searchCstmsEdiHeader(sender, receiver, blinfoVO.getMsgIdCd());
					flatFileHeader = bookingUtil.searchCstmsEdiHeaderNew("IL_FROBDAT");
//					flatFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf("BKC"));
					flatFileRefNo = flatFileHeader.substring(flatFileHeader.indexOf(ReferenceNumberGeneratorBroker.getChangedModule("BKC")));
					
					// flatFile 에 추가
					flatFile.append(flatFileHeader).append("\n");
					
					CustomsCommonMgtBC comBc = new CustomsCommonMgtBCImpl(); 
					String conCrn = comBc.searchConVvd(vslCd+skdVoyNo+skdDirCd, cstmsPortCd, "I");
					
					//공통정보 생성
					bfTemp.setLength(0);
					
					bfTemp.append("PRN:").append(blinfoVO.getPrn()).append("\n");
					bfTemp.append("CRN:").append(vslCd).append(skdVoyNo).append(skdDirCd).append("\n");
					bfTemp.append("CON_CRN:").append(conCrn).append("\n");
					bfTemp.append("LRN:").append(blNo).append("\n");
					bfTemp.append("MRN:").append(blinfoVO.getMrn()).append("\n");
										
					bfTemp.append("TRANS_MODE:").append("1").append("\n");
					bfTemp.append("TRANS_IDENTITY:").append(blinfoVO.getTransIdentity()).append("\n");
					bfTemp.append("TRANS_NATION:").append(blinfoVO.getTransNation()).append("\n");
					bfTemp.append("VSL_NAME:").append(blinfoVO.getVslName()).append("\n");
					bfTemp.append("LOAD_LOC_CD:").append(blinfoVO.getLoadLocCd()).append("\n");
					bfTemp.append("LOAD_LOC_NAME:").append(blinfoVO.getLoadLocName()).append("\n");
					bfTemp.append("LOAD_OFC_CD:").append(blinfoVO.getLoadOfcCd()).append("\n");
					bfTemp.append("LOAD_LOC_ETD:").append(blinfoVO.getLoadLocEtd()).append("\n");
					bfTemp.append("UNLOAD_LOC_CD:").append(blinfoVO.getUnloadLocCd()).append("\n");
					bfTemp.append("UNLOAD_LOC_NAME:").append(blinfoVO.getUnloadLocName()).append("\n");
					uploadEtaHis = blinfoVO.getUnloadLocEtaHis(); // send history 값 셋팅을 위해 사용
					bfTemp.append("UNLOAD_LOC_ETA:").append(blinfoVO.getUnloadLocEta()).append("\n");
					bfTemp.append("UNLOAD_OFC_CD:").append(blinfoVO.getUnloadOfcCd()).append("\n");
					bfTemp.append("PREV_LOC_CD:").append(blinfoVO.getPrevLocCd()).append("\n");
					bfTemp.append("NEXT_LOC_CD:").append(blinfoVO.getNextLocCd()).append("\n");
					bfTemp.append("NEXT_LOC_NAME:").append(blinfoVO.getNextLocName()).append("\n");
					bfTemp.append("NEXT_LOC_ETA:").append(blinfoVO.getNextLocEta()).append("\n");
					bfTemp.append("NEXT_OFC_CD:").append(blinfoVO.getNextOfcCd()).append("\n");
					
					// These items are NOT needed for Israel Customs.
//					bfTemp.append("{PARTY_INFO").append("\n");
//					bfTemp.append("PT_TYPE:").append("").append("\n");
//					bfTemp.append("PT_TIN:").append("").append("\n");
//					bfTemp.append("PT_EORI:").append("").append("\n");
//					bfTemp.append("PT_NAME:").append("").append("\n");
//					bfTemp.append("PT_ADDRESS:").append("").append("\n");
//					bfTemp.append("PT_STREET:").append("").append("\n");
//					bfTemp.append("PT_CITY:").append("").append("\n");
//					bfTemp.append("PT_POSTAL_CD:").append("").append("\n");
//					bfTemp.append("PT_CNT_CD:").append("").append("\n");
//					bfTemp.append("{PT_COM_INFO").append("\n");
//					bfTemp.append("PT_CON_NAME:").append(blinfoVO.getCtName()).append("\n"); //? 확인
//					bfTemp.append("PT_CON_CMPY:").append(blinfoVO.getCtPosition()).append("\n");
//					bfTemp.append("PT_FAX_NO:").append(blinfoVO.getCtFax()).append("\n");
//					bfTemp.append("PT_EM_NO:").append(blinfoVO.getCtEmail()).append("\n");
//					bfTemp.append("PT_TEL_NO:").append(blinfoVO.getCtTel()).append("\n");
//					bfTemp.append("}PT_COM_INFO").append("\n");
//					bfTemp.append("}PARTY_INFO").append("\n");
					
					bfTemp.append("{BL_INFO").append("\n");
					bfTemp.append("BLNBR:").append(blinfoVO.getBlnbr()).append("\n");
					bfTemp.append("BL_TRANS_IDENTITY:").append(blinfoVO.getBlTransIdentity()).append("\n");
					bfTemp.append("BL_TRANS_NATION:").append(blinfoVO.getBlTransNation()).append("\n");
					bfTemp.append("BLPOL:").append(blinfoVO.getBlpol()).append("\n");
					bfTemp.append("POL_FULLNAME:").append(blinfoVO.getPolFullname()).append("\n");
					bfTemp.append("BLPOD:").append(blinfoVO.getBlpod()).append("\n");
					bfTemp.append("POD_FULLNAME:").append(blinfoVO.getPodFullname()).append("\n");
					bfTemp.append("POD_OFC_CD:").append(blinfoVO.getPodOfcCd()).append("\n");
					bfTemp.append("BLDEL:").append(blinfoVO.getBldel()).append("\n");
					bfTemp.append("DEL_FULLNAME:").append(blinfoVO.getDelFullname()).append("\n");
					bfTemp.append("BLPKG:").append(blinfoVO.getBlpkg()).append("\n");
					bfTemp.append("BLPKGU:").append(blinfoVO.getBlpkgu()).append("\n"); 
					bfTemp.append("BLMEA:").append(blinfoVO.getBlmea()).append("\n");
					bfTemp.append("BLMEAU:").append(blinfoVO.getBlmeau()).append("\n");
					bfTemp.append("COMMODITY:").append(blinfoVO.getCommodity()).append("\n");
					bfTemp.append("TRANS_DOC_NO:").append(blinfoVO.getTransDocNo()).append("\n");
					bfTemp.append("TRANS_DOC_NAME:").append(blinfoVO.getTransDocName()).append("\n");
					bfTemp.append("CUSTOMS_STATUS_CD:").append(blinfoVO.getCustomsStatusCd()).append("\n");
					bfTemp.append("PROCESS_INFO:").append(blinfoVO.getProcessInfo()).append("\n");
					bfTemp.append("PROCESS_TYPE:").append(blinfoVO.getProcessType()).append("\n");
					bfTemp.append("AEO_STATUS:").append(blinfoVO.getAeoStatus()).append("\n");
					bfTemp.append("PART_SHIPMENT:").append(blinfoVO.getPartShipment()).append("\n");
					bfTemp.append("CONSIGN_PLACE:").append(blinfoVO.getConsignPlace()).append("\n");
					bfTemp.append("DECLARE_DATE:").append(blinfoVO.getDeclareDate()).append("\n");
					bfTemp.append("DECLARE_LOC:").append(blinfoVO.getDeclareLoc()).append("\n");
					bfTemp.append("DECLARE_LOC_NAME:").append(blinfoVO.getDeclareLocName()).append("\n");
					bfTemp.append("PAYMENT_CD:").append(blinfoVO.getPaymentCd()).append("\n");
					bfTemp.append("LOCAL_CLEAR_NO:").append("").append("\n");
					bfTemp.append("TEMPORARY_STORAGE:").append("").append("\n");
					bfTemp.append("SPECIAL_REMARKS:").append(blinfoVO.getSpecialRemarks()).append("\n");
					
					flatFile.append(bfTemp);
					bfTemp.setLength(0);
					
					//bl cust정보
					searchBlCustVOs = dbDao.searchBlCust(blNo, vslCd, skdVoyNo, skdDirCd, cstmsPortCd);

					for (int i = 0; i < searchBlCustVOs.size(); i++) {
						custVO = searchBlCustVOs.get(i);
						
						bfTemp.append("{BL_PARTY_INFO").append("\n");
						bfTemp.append("BL_PT_TYPE:").append(custVO.getBlPtType()).append("\n");
						bfTemp.append("BL_PT_TIN:").append(custVO.getBlPtTin()).append("\n");
						bfTemp.append("BL_PT_EORI:").append(custVO.getBlPtEori()).append("\n");
						bfTemp.append("BL_PT_NAME:").append(custVO.getBlPtName()).append("\n");
						bfTemp.append("BL_PT_ADDRESS:").append(custVO.getBlPtAddress()).append("\n");
						bfTemp.append("BL_PT_STREET:").append(custVO.getBlPtStreet()).append("\n");
						bfTemp.append("BL_PT_CITY:").append(custVO.getBlPtCity()).append("\n");
						bfTemp.append("BL_PT_POSTAL_CD:").append(custVO.getBlPtPostalCd()).append("\n");
						bfTemp.append("BL_PT_CNT_CD:").append(custVO.getBlPtCntCd()).append("\n");
						// These items are NOT needed for Israel Customs.
//						bfTemp.append("{BL_PT_COM_INFO").append("\n");
//						bfTemp.append("BL_PT_CON_NAME:").append(custVO.getBlPtConName()).append("\n");
//						bfTemp.append("BL_PT_FAX_NO:").append(custVO.getBlPtFaxNo()).append("\n");
//						bfTemp.append("BL_PT_EM_NO:").append(custVO.getBlPtEmNo()).append("\n");
//						bfTemp.append("BL_PT_TEL_NO:").append(custVO.getBlPtTelNo()).append("\n");
//						bfTemp.append("}BL_PT_COM_INFO").append("\n");
						bfTemp.append("}BL_PARTY_INFO").append("\n");

						
					}//end for searchBlCustVOs
					
					flatFile.append(bfTemp);
					bfTemp.setLength(0);
					int splitBytesLength = 512;
					tempStr = blinfoVO.getDescs().split("\\$@\\$");
					for (int i = 0; i < tempStr.length; i++) {
						for (int m = 0; m < tempStr[i].length(); m += splitBytesLength) {
							bfTemp.append("{DESC").append("\n");
							bfTemp.append("DESC:").append(tempStr[i].substring(m, m + splitBytesLength > tempStr[i].length() ? tempStr[i].length(): m + splitBytesLength ) ).append("\n");
							bfTemp.append("}DESC").append("\n");
						}
					}
					
					flatFile.append(bfTemp);
					bfTemp.setLength(0);
					
					tempStr = blinfoVO.getMarkno().split("\\$@\\$");
					for (int i = 0; i < tempStr.length; i++) {
						for (int m = 0; m < tempStr[i].length(); m += splitBytesLength) {
							bfTemp.append("{MARK").append("\n");
							bfTemp.append("MARKNO:").append(tempStr[i].substring(m, m + splitBytesLength > tempStr[i].length() ? tempStr[i].length(): m + splitBytesLength ) ).append("\n");
							bfTemp.append("}MARK").append("\n");
						}
					}
					
					flatFile.append(bfTemp);
					bfTemp.setLength(0);
					
					//************** 컨테이너별 반복 ********************
					searchBlCntrVOs = dbDao.searchBlCntr(blNo, vslCd, skdVoyNo, skdDirCd, cstmsPortCd);
					for (int i = 0; i < searchBlCntrVOs.size(); i++) {
						cntrVO = searchBlCntrVOs.get(i);
						cntrNo = cntrVO.getCntrNo();

						bfTemp.append("{CNTR_INFO").append("\n");
						bfTemp.append("CNTRNBR:").append(cntrVO.getCntrnbr()).append("\n");
						bfTemp.append("FM_IND:").append(cntrVO.getFmInd()).append("\n");
						bfTemp.append("PUNIT:").append(cntrVO.getPunit()).append("\n");
						bfTemp.append("PKG:").append(cntrVO.getPkg()).append("\n");
						bfTemp.append("CNTRWGT:").append(cntrVO.getCntrwgt()).append("\n");
						bfTemp.append("CNTRGWGT:").append(cntrVO.getCntrgwgt()).append("\n");
						bfTemp.append("CNTR_WGT_UNIT:").append(cntrVO.getCntrWgtUnit()).append("\n");
						bfTemp.append("CNTRTYPE:").append(cntrVO.getCntrtype()).append("\n");
						bfTemp.append("CMDT_DESC:").append(cntrVO.getCmdtDesc()).append("\n");
						bfTemp.append("CMDTCD:").append(cntrVO.getCmdtcd()).append("\n");

						
						searchBlDgCgoVOs = dbDao.searchBlDgCgo(blNo, vslCd, skdVoyNo, skdDirCd, cstmsPortCd, cntrNo);
						for (int j = 0; j < searchBlDgCgoVOs.size(); j++) {
							dgCgoVO = searchBlDgCgoVOs.get(j);
							
							bfTemp.append("{CNTR_DANGER").append("\n");
							bfTemp.append("UNNBR:").append(dgCgoVO.getUnnbr()).append("\n");
							bfTemp.append("CLASS:").append(dgCgoVO.getClassCd()).append("\n");
							bfTemp.append("D_PKG:").append(dgCgoVO.getDPkg()).append("\n");
							bfTemp.append("D_PKGUNIT:").append(dgCgoVO.getDPkgunit()).append("\n");
							bfTemp.append("GWGT:").append(dgCgoVO.getGwgt()).append("\n");
							bfTemp.append("GWGT_UNIT:").append(dgCgoVO.getGwgtUnit()).append("\n");
							bfTemp.append("MEA:").append(dgCgoVO.getMea()).append("\n");
							bfTemp.append("MEA_UNIT:").append(dgCgoVO.getMeaUnit()).append("\n");
							bfTemp.append("}CNTR_DANGER").append("\n");

						}//end for searchBlCntrVOs
						
						
						searchBlCntrMfDescVOs = dbDao.searchBlCntrMfDesc(blNo, vslCd, skdVoyNo, skdDirCd, cstmsPortCd, cntrNo);
						for (int j = 0; j < searchBlCntrMfDescVOs.size(); j++) {
							cntrMfVO = searchBlCntrMfDescVOs.get(j);
							bfTemp.append("{CNTR_DESC").append("\n");
							bfTemp.append("D_PUNIT:").append(cntrMfVO.getDPunit()).append("\n");
							bfTemp.append("D_PKG:").append(cntrMfVO.getDPkg()).append("\n");
							bfTemp.append("D_WGT:").append(cntrMfVO.getDWgt()).append("\n");
							bfTemp.append("D_MEAS:").append(cntrMfVO.getDMeas()).append("\n");
							bfTemp.append("D_DESC:").append(cntrMfVO.getDDesc()).append("\n");
							bfTemp.append("{CUS_MARK").append("\n");
							bfTemp.append("D_MARK:").append(cntrMfVO.getDMark()).append("\n");
							bfTemp.append("}CUS_MARK").append("\n");
							bfTemp.append("}CNTR_DESC").append("\n");

							
						}//end for searchBlCntrMfDescVOs
						
						searchBlCntrSealNoVOs = dbDao.searchBlCntrSealNo(blNo, vslCd, skdVoyNo, skdDirCd, cstmsPortCd, cntrNo);
						for (int j = 0; j < searchBlCntrSealNoVOs.size(); j++) {
							cntrSealVO = searchBlCntrSealNoVOs.get(j);
							bfTemp.append("{MULTI_SEAL").append("\n");
							bfTemp.append("SEAL_TYPE:").append(cntrSealVO.getSealType()).append("\n");
							bfTemp.append("SEAL_NBR:").append(cntrSealVO.getSealNbr()).append("\n");
							bfTemp.append("}MULTI_SEAL").append("\n");
						}//end for searchBlCntrVOs
						
						bfTemp.append("}CNTR_INFO").append("\n");
						

						
						flatFile.append(bfTemp);
						bfTemp.setLength(0);
						
					}//end for eur24BlCntrListVOs
					
					//************** 컨테이너별 반복 ********************끝

					
					
					//bl CMinfo정보
					searchBlCMinfoVOs = dbDao.searchBlCMinfo(blNo, vslCd, skdVoyNo, skdDirCd, cstmsPortCd,blinfoVO.getMsgIdCd());
					for (int i = 0; i < searchBlCMinfoVOs.size(); i++) {
						cMinfoVO = searchBlCMinfoVOs.get(i);
						bfTemp.append("{CM_INFO").append("\n");
						bfTemp.append("GOODS_ITEM_NO:").append(cMinfoVO.getGoodsItemNo()).append("\n");
						bfTemp.append("PIECE_COUNT:").append(cMinfoVO.getPieceCount()).append("\n");
						bfTemp.append("PKG_COUNT:").append(cMinfoVO.getPkgCount()).append("\n");
						bfTemp.append("PKG_TYPE:").append(cMinfoVO.getPkgType()).append("\n");
						bfTemp.append("GOODS_DESC:").append(cMinfoVO.getGoodsDesc()).append("\n");
						bfTemp.append("ITEM_GROSS_WGT:").append(cMinfoVO.getItemGrossWgt()).append("\n");
						bfTemp.append("TARIFF_CD:").append(cMinfoVO.getTariffCd()).append("\n");
						bfTemp.append("UNDG_NO:").append(cMinfoVO.getUndgNo()).append("\n");
						bfTemp.append("HANDLE_CD:").append(cMinfoVO.getHandleCd()).append("\n");
						bfTemp.append("HANDLE_INFO:").append(cMinfoVO.getHandleInfo()).append("\n");
						bfTemp.append("{CM_CNTR").append("\n");
						bfTemp.append("CM_CNTR_NO:").append(cMinfoVO.getCmCntrNo()).append("\n");
						bfTemp.append("CM_CNTR_PKG:").append(cMinfoVO.getCmCntrPkg()).append("\n");
						bfTemp.append("CM_SHIP_MARK:").append(cMinfoVO.getCmShipMark()).append("\n");
						bfTemp.append("}CM_CNTR").append("\n");
						bfTemp.append("}CM_INFO").append("\n");		
						
					}//end for searchBlCMinfoVOs
					
					flatFile.append(bfTemp);
					bfTemp.setLength(0);
					
					//bl Route 정보
					searchBlRouteCountryVOs = dbDao.searchBlRouteCountry(blNo, vslCd, skdVoyNo, skdDirCd);
					for (int i = 0; i < searchBlRouteCountryVOs.size(); i++) {
						bfTemp.append("{ROUTE_COUNTRY").append("\n");
						bfTemp.append("COUNTRY:").append(searchBlRouteCountryVOs.get(i).getRouteCnt()).append("\n");
						bfTemp.append("}ROUTE_COUNTRY").append("\n");						
					}//end for eur24BlRouteCntListVOs
					
					flatFile.append(bfTemp);
					flatFile.append("}BL_INFO");
					
					SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
					sendFlatFileVO.setFlatFile(flatFile.toString());
					sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.OPUSBKG_UBIZCOM_EUR24.IBMMQ.QUEUE"));

					FlatFileAckVO flatFileAckVO = new FlatFileAckVO();
//					if(pSendYn.equals("Y")){
						
						sendHistoryVO = new sendHistoryVO();
						
						sendHistoryVO.setMsgSndNo(blinfoVO.getPrn());
						sendHistoryVO.setEdiMsgTpId("ILC");
						sendHistoryVO.setSndUsrId(account.getUsr_id());
						
//						if("315".equals(blinfoVO.getMsgId()) || "344".equals(blinfoVO.getMsgId())) {
//							eur24SendHistoryVO.setMsgFuncId("O");
//						} else {
////							uploadEtaHis = "";
//							eur24SendHistoryVO.setMsgFuncId("U");
//						}
						
						sendHistoryVO.setVslCd(vslCd);
						sendHistoryVO.setSkdVoyNo(skdVoyNo);
						sendHistoryVO.setSkdDirCd(skdDirCd);
						sendHistoryVO.setBlNo(blNo);
						sendHistoryVO.setCstmsPortCd(cstmsPortCd);
						sendHistoryVO.setEdiSndMsgCtnt(flatFile.toString());
						sendHistoryVO.setCreUsrId(account.getUsr_id());
						sendHistoryVO.setSndUsrOfcCd(account.getOfc_cd());
						sendHistoryVO.setUnloadLocEta(uploadEtaHis);
						
						dbDao.addSendLog(sendHistoryVO) ;

						flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
						
						if (flatFileAckVO.getAckStsCd().equals("E"))
							throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
						
						log.debug("\n\n\n\n\n\n\n#################################################### file Send Success ##############################");
//					}
					
					log.debug("flatFile:\n\n");
					log.debug(flatFile.toString());
					log.debug("flatFile:\n\n");
					
					tempCount++;
					
					result.append(flatFile.toString()).append("\n\n");
				}//end for param manifestTransmitVOs 
			}
			
			log.debug("####################################################\n\n\n\n\n total cnt :"+ tempCount);
			log.debug("####################################################\n\n\n\n\n FLAT FILE: \n\n"+ result.toString());
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (DAOException ex) {
			log.error("DAOException : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("Exception : " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		
		log.debug("####################################################\n\n\n\n\n transmitManifest END!");
		return result.toString();
	}
	
	
	
	/**
	 * BackEndJob을 실행.
	 * 
	 * @param SignOnUserAccount account
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 * 
	 */
	public String startBackEndJob(SignOnUserAccount account, ManifestTransmitVO[] manifestTransmitVOs, String pgmNo )  throws EventException{
		
		String resultStr = "";
		
		if(pgmNo.equals("ESM_BKG_1168")) {
			IsraelCustomsTransmissionBackEndJob backEndJob = new IsraelCustomsTransmissionBackEndJob();
			backEndJob.setPgmNo(pgmNo);
			backEndJob.setManifestTransmitVOs(manifestTransmitVOs);
			backEndJob.setAccount(account);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			resultStr = backEndJobManager.execute(backEndJob , account.getUsr_id(), "Israel EDI Transmit");
		} 
		return resultStr;
	}
}