/*=========================================================
 *Copyright(c) 2017 Hi-Plus Card
 *@FileName : JapanCustomsTransmissionBCImpl.java
 *@FileTitle : CustomsTransmissionBCImpl
 *Open Issues :
 *Change history :
 * 	2010.12.14 이수진 [CHM-201007514] Sea-NACCS MFR, CMF01, CMF02 의 Mark 데이터 사이즈 변경 및 제한 요청
 * 	2011.01.12 안정선 [CHM-201008075] DOR User ID 조회 및 MFR CY 코드 반영 수정 사항 라이브 반영 요청
 * 	2017.09.07 하대성 2017 Renewal Version Transmit 반영
 *@LastModifyDate : 2017.09.07
 *@LastModifier : 하대성
 *@LastVersion : 1.0
 * 2009.04.29 김승민
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.integration.JapanCustomsReportDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.japan.vo.JapanReceiveLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.ReceiveLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.integration.JapanCustomsTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListBlCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListBlCustInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListBlGeneralInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListBlMarkDescInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListEmptyBlCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListEmptyBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListSendHeaderInfoForDmfVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListSendHeaderInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListTransmitDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestListVesselArrivalDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestTransmitCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestTransmitContainerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestTransmitForReVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanTransmitBlKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japan.vo.JapanVesselArrivalTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.VesselArrivalTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.integration.JapanManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListJpcusEtaInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestModificationVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgCstmsJpRcvLogDtlVO;
import com.hanjin.syscommon.common.table.BkgCstmsJpRcvLogVO;
import com.hanjin.syscommon.common.table.BkgCstmsJpSndLogDtlVO;
import com.hanjin.syscommon.common.table.BkgCstmsJpSndLogVO;

/**
 * ALPS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - ALPS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kim Seung Min
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class JapanCustomsTransmissionBCImpl extends CustomsTransmissionBCImpl {

	// Database Access Object
	private transient JapanCustomsTransmissionDBDAO dbDao = null;
	private transient JapanCustomsReportDBDAO dbDao2 = null;
	private transient JapanManifestListDownloadDBDAO dbDao3 = null;

	/**
	 * JapanCustomsTransmissionBCImpl 객체 생성<br>
	 * JapanCustomsTransmissionDAO를 생성한다.<br>
	 */
	public JapanCustomsTransmissionBCImpl() {
		dbDao = new JapanCustomsTransmissionDBDAO();
		dbDao2 = new JapanCustomsReportDBDAO();
		dbDao3 = new JapanManifestListDownloadDBDAO();
	}

	/**
	 * 전송 이벤트 처리<br>
	 * 세관에 적하목록 신고를 EDI를 통해 전송한다.<br>
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return ManifestTransmitDetailVO
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public ManifestTransmitDetailVO transmitManifestList(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account)
			throws EventException {
		// 2017 Renewal Version.
		if(manifestTransmitVO.getPgmNo() != null && (manifestTransmitVO.getPgmNo().equals("ESM_BKG_0730_Renewal2017") || manifestTransmitVO.getPgmNo().equals("ESM_BKG_0991_Renewal2017"))) {
			StringBuffer realFlatFile2 = new StringBuffer();
			JapanManifestTransmitContainerVO japanManifestTransmitContainerVO = (JapanManifestTransmitContainerVO) manifestTransmitVO;
			JapanManifestTransmitVO[] japanManifestTransmitVOs = japanManifestTransmitContainerVO
					.getJapanManifestTransmitVOs();
			JapanManifestTransmitCondVO japanManifestTransmitCondVO = japanManifestTransmitContainerVO
					.getJapanManifestTransmitCondVO();
			List<JapanTransmitBlKeyVO> japanBlKeyVOs = new ArrayList<JapanTransmitBlKeyVO>();
			String blNumber = "";
			int realCount = 0;
			
			try {
			
				for (int i = 0; i < japanManifestTransmitVOs.length; i++) {
					JapanManifestTransmitVO japanManifestTransmitVO = japanManifestTransmitVOs[i];
					if (!japanManifestTransmitVO.getBlNumber().equals(blNumber)) {
						StringBuffer realFlatFile = new StringBuffer();
						int logSeq = 0;
						String inProcessGb = null;
						String etaDt = "";
						String inJapanPod = "";
		
						List<JapanManifestListJpcusEtaInfoVO> japanManifestListJpcusEtaInfoVOs = null;
						List<JapanManifestListEmptyBlInfoVO> japanManifestListEmptyBlInfoVOs = null;
						List<JapanManifestListBlGeneralInfoVO> japanManifestListBlGeneralInfoVOs = null;
						List<JapanManifestListEmptyBlCntrInfoVO> japanManifestListEmptyBlCntrInfoVOs = null;
						List<JapanManifestListBlCustInfoVO> japanManifestListBlCustInfoVOs = null;
						List<JapanManifestListBlCntrInfoVO> japanManifestListBlCntrInfoVOs = null;
						List<JapanManifestListBlMarkDescInfoVO> japanManifestListBlMarkDescInfoVOs = null;
						List<JapanManifestListSendHeaderInfoVO> japanManifestListSendHeaderInfoVOs = null;
						
		
							String vvdCd = japanManifestTransmitCondVO.getInVvdCd();
							String vslCd = japanManifestTransmitCondVO.getInVvdCd().substring(0, 4);
							String skdVoyNo = japanManifestTransmitCondVO.getInVvdCd().substring(4, 8);
							String skdDirCd = japanManifestTransmitCondVO.getInVvdCd().substring(8);
							String inPodCd = japanManifestTransmitCondVO.getInPodCd();
							String inPodSplitCd = japanManifestTransmitCondVO.getInPodSplitCd();
							String inPolCd = japanManifestTransmitCondVO.getInPolCd();
							String inCallSgnNo = japanManifestTransmitCondVO.getInCallSgnNo();
							String inCyOprCd = japanManifestTransmitCondVO.getInCyOprCd();
							String inVpsEtaDt = japanManifestTransmitCondVO.getInVpsEtaDt();
							String inMsgTp = japanManifestTransmitCondVO.getInMsgTp();
							String inMsgFlag = japanManifestTransmitCondVO.getInMsgFlag();
							String inMfrGubun = japanManifestTransmitCondVO.getInMfrGubun();
							String inVoyageNo = japanManifestTransmitCondVO.getInVoyageNo();
							String cmfCd = japanManifestTransmitCondVO.getCmfCd();
							String cmfReason = japanManifestTransmitCondVO.getCmfReason();
							String podCd = japanManifestTransmitCondVO.getInPodCd();
							
		
							japanManifestTransmitVO.setInVslCd(vslCd);
							japanManifestTransmitVO.setInSkdVoyNo(skdVoyNo);
							japanManifestTransmitVO.setInSkdDirCd(skdDirCd);
							japanManifestTransmitVO.setInPodCd(inPodCd);
							japanManifestTransmitVO.setInPolCd(inPolCd);
							japanManifestTransmitVO.setInCallSgnNo(inCallSgnNo);
							japanManifestTransmitVO.setInCyOprCd(inCyOprCd);
							japanManifestTransmitVO.setInVpsEtaDt(inVpsEtaDt);
							japanManifestTransmitVO.setInVoyageNo(inVoyageNo);
							
							//세관 전송시 pod를 일본세관에서 사용하는 pod로 보내기 위해 사용 2014.03.05
							inJapanPod = dbDao.searchJapanPODInfo(inPodCd);
							
							if(inJapanPod.equals("")||inJapanPod == null) inJapanPod = inPodCd;
		
							japanManifestListJpcusEtaInfoVOs = dbDao.searchJpcusEta(japanManifestTransmitVO);
							if (inCallSgnNo == null || inCallSgnNo.equals("")) {
		
								if (japanManifestListJpcusEtaInfoVOs.get(0).getCallSgnNo() == null) {
									inCallSgnNo = dbDao.searchVslCallsign(vslCd);
								} else {
									inCallSgnNo = japanManifestListJpcusEtaInfoVOs.get(0).getCallSgnNo();
								}
							}
							if (inVpsEtaDt == null || inVpsEtaDt.equals("")) {
								if (japanManifestListJpcusEtaInfoVOs.get(0).getEtaDt() == null) {
									etaDt = dbDao.searchEta(japanManifestTransmitVO);
									inVpsEtaDt = etaDt;
								} else {
									inVpsEtaDt = japanManifestListJpcusEtaInfoVOs.get(0).getEtaDt();
								}
							}
		
							if (inMsgTp.equals("MFR")) {
								inProcessGb = "9";
							} else 
							{
								inProcessGb = inMsgFlag;
							}
		
							StringBuffer flatFile = new StringBuffer();
							StringBuffer flatFile2 = new StringBuffer();
							String mtyBkgFlg = null;
							JapanTransmitBlKeyVO blKeyVO = new JapanTransmitBlKeyVO();
							blKeyVO.setBlNo(japanManifestTransmitVO.getBlNumber().substring(0, 12));
							
							if (japanManifestTransmitVO.getBlNumber().length() > 12)
								blKeyVO.setBlSplitNo(japanManifestTransmitVO.getBlNumber().substring(12));
							blKeyVO.setInMsgTp(inMsgTp);
							blKeyVO.setInMsgFlag(inMsgFlag);
							blKeyVO.setInCallSgnNo(inCallSgnNo);
							blKeyVO.setInVvdCd(vvdCd);
							blKeyVO.setCmfCd(cmfCd);
							blKeyVO.setCmfReason(cmfReason);
							blKeyVO.setPodCd(podCd);
							
							japanBlKeyVOs.add(realCount, blKeyVO);
		
							mtyBkgFlg = dbDao.searchEmptyInd(blKeyVO);
		
							inVpsEtaDt = inVpsEtaDt.replace("-", "");
							if (inVpsEtaDt.equals("") || inVpsEtaDt == null)
								inVpsEtaDt = "        ";
		
							if (inPodSplitCd.equals("") || inPodSplitCd == null || inPodSplitCd.length() == 0)
								inPodSplitCd = " ";
		
							JapanManifestModificationVO japanManifestModificationVO = new JapanManifestModificationVO();
							
							japanManifestModificationVO.setInVslCd(vslCd);
							japanManifestModificationVO.setInSkdVoyNo(skdVoyNo);
							japanManifestModificationVO.setInSkdDirCd(skdDirCd);
							japanManifestModificationVO.setInPodCd(inPodCd);
							japanManifestModificationVO.setInCallSgnNo(inCallSgnNo);
							japanManifestModificationVO.setInCyOprCd(inCyOprCd);
							japanManifestModificationVO.setInVpsEtaDt(inVpsEtaDt);
							japanManifestModificationVO.setUpdUsrId(account.getUsr_id());
							japanManifestModificationVO.setInVoyageNo(inVoyageNo);
		
							if (inMsgTp.equals("MFR")&&!inMfrGubun.equals("N")) 
								dbDao3.modifyJpcusBl(japanManifestModificationVO);					
							
							if (!mtyBkgFlg.equals("F")) {
								japanManifestListEmptyBlInfoVOs = dbDao.searchEmptyBlRenewal2017(blKeyVO);
								JapanManifestListEmptyBlInfoVO japanManifestListEmptyBlInfoVO = japanManifestListEmptyBlInfoVOs
										.get(0);
		
								japanManifestListEmptyBlCntrInfoVOs = dbDao.searchEmptyBlCntr(blKeyVO);
		
								flatFile.append(inProcessGb).append("\r\n"); //2.Function Type Code
								flatFile.append(japanManifestListEmptyBlInfoVO.getCorCd()).append("\r\n"); //3.Correction reason code
								flatFile.append(japanManifestListEmptyBlInfoVO.getCorReason()).append("\r\n"); //4.Correction reason
								flatFile.append(japanManifestListEmptyBlInfoVO.getDelCd()).append("\r\n"); //5.Reason for Deletion Code
								flatFile.append(japanManifestListEmptyBlInfoVO.getDelReason()).append("\r\n"); //6.Deletion reason
								flatFile.append(japanManifestListEmptyBlInfoVO.getInCallSgnNo()).append("\r\n"); //7.Vessel Code 
								flatFile.append(japanManifestListEmptyBlInfoVO.getOpVvdCd()).append("\r\n"); //8.Operating Carrier Voyage Number		
								flatFile.append(japanManifestListEmptyBlInfoVO.getInVvdCd()).append("\r\n"); //9.Voyage number
								flatFile.append("SMLM").append("\r\n"); //10.Carrier Code 
								flatFile.append(inJapanPod).append("\r\n"); //11.Port of Discharge Code 
								flatFile.append(inPodSplitCd).append("\r\n"); //12.Port of Discharge Suffix 
								flatFile.append(inVpsEtaDt).append("\r\n");  //13.Estimated Date of Arrival
								flatFile.append(japanManifestListEmptyBlInfoVO.getCyOprCd()).append("\r\n"); //14.Container Operator Code
								flatFile.append(japanManifestListEmptyBlInfoVO.getData2()).append("\r\n"); //15.B/L No.
								flatFile.append(japanManifestListEmptyBlInfoVO.getData3()).append("\r\n"); //16.Port of Loading Code
								flatFile.append(japanManifestListEmptyBlInfoVO.getData4()).append("\r\n"); //17.Final destination code
								flatFile.append(japanManifestListEmptyBlInfoVO.getData5()).append("\r\n"); //18.Final Destination Name
								flatFile.append(japanManifestListEmptyBlInfoVO.getData6()).append("\r\n"); //19.Place of Delivery Code
								flatFile.append(japanManifestListEmptyBlInfoVO.getData7()).append("\r\n"); //20.Place of Delivery Name
								flatFile.append(japanManifestListEmptyBlInfoVO.getData8()).append("\r\n"); //21.Shipper Code
								flatFile.append(japanManifestListEmptyBlInfoVO.getData9()).append("\r\n"); //22.Shipper Name
								flatFile.append(japanManifestListEmptyBlInfoVO.getData10()).append("\r\n"); //23.Shipper Address (block entry)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData11()).append("\r\n"); //24.Shipper Address 1/4 (Street and number/P.O. Box)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData12()).append("\r\n"); //25.Shipper Address 2/4 (Street and number/P.O. Box)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData13()).append("\r\n"); //26.Shipper Address 3/4 (City name)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData14()).append("\r\n"); //27.Shipper Address 4/4 (Country sub-entity, name)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData15()).append("\r\n"); //28.Shipper Postal Code (Postcode identification)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData16()).append("\r\n"); //29.Shipper Country Code (Country, coded)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData17()).append("\r\n"); //30.Shipper Telephone Number
								flatFile.append(japanManifestListEmptyBlInfoVO.getData18()).append("\r\n"); //31.Consignee Code
								flatFile.append(japanManifestListEmptyBlInfoVO.getData19()).append("\r\n"); //32.Consignee Name
								flatFile.append(japanManifestListEmptyBlInfoVO.getData20()).append("\r\n"); //33.Consignee Address (block entry)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData21()).append("\r\n"); //34.Consignee Address 1/4 (Street and number/P.O. Box)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData22()).append("\r\n"); //35.Consignee Address 2/4 (Street and number/P.O. Box)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData23()).append("\r\n"); //36.Consignee Address 3/4 (City name)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData24()).append("\r\n"); //37.Consignee Address 4/4 (Country sub-entity, name)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData25()).append("\r\n"); //38.Consignee Postal Code (Postcode identification)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData26()).append("\r\n"); //39.Consignee Country Code (Country, coded)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData27()).append("\r\n"); //40.Consignee Telephone Number
								flatFile.append(japanManifestListEmptyBlInfoVO.getData28()).append("\r\n"); //41.Notify Party Code
								flatFile.append(japanManifestListEmptyBlInfoVO.getData29()).append("\r\n"); //42.Notify Party Name
								flatFile.append(japanManifestListEmptyBlInfoVO.getData30()).append("\r\n"); //43.Notify Party Address (block entry)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData31()).append("\r\n"); //44.Notify Party Address 1/4(Street and number/P.O.Box)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData32()).append("\r\n"); //45.Notify Party Address 2/4(Street and number/P.O.Box)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData33()).append("\r\n"); //46.Notify Party Address 3/4(City name)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData34()).append("\r\n"); //47.Notify Party Address 4/4(Country sub- entity, name)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData35()).append("\r\n"); //48.Notify Party Postal Code (Postcode identification)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData36()).append("\r\n"); //49.Notify Party Country Code (Country, coded)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData37()).append("\r\n"); //50.Notify Party Telephone Number
								flatFile.append(japanManifestListEmptyBlInfoVO.getData38()).append("\r\n"); //51.Notify Party Code(반복2)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData39()).append("\r\n"); //52.Notify Party Name(반복2)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData40()).append("\r\n"); //53.Notify Party Address (block entry)(반복2)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData41()).append("\r\n"); //54.Notify Party Address 1/4（Street and number/P.O.Box）(반복2)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData42()).append("\r\n"); //55.Notify Party Address 2/4（Street and number/P.O.Box）(반복2)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData43()).append("\r\n"); //56.Notify Party Address 3/4（City name）(반복2)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData44()).append("\r\n"); //57.Notify Party Address 4/4（Country sub- entity, name）(반복2)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData45()).append("\r\n"); //58.Notify Party Postal Code (Postcode identification)(반복2)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData46()).append("\r\n"); //59.Notify Party Country Code (Country, coded)(반복2)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData47()).append("\r\n"); //60.Notify Party Telephone Number(반복2)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData48()).append("\r\n"); //61.Goods Description
								flatFile.append(japanManifestListEmptyBlInfoVO.getData49()).append("\r\n"); //62.HS Code
								flatFile.append(japanManifestListEmptyBlInfoVO.getData50()).append("\r\n"); //63.Marks and Numbers
								flatFile.append(japanManifestListEmptyBlInfoVO.getData51()).append("\r\n"); //64.Number of Packages
								flatFile.append(japanManifestListEmptyBlInfoVO.getData52()).append("\r\n"); //65.Number of Packages Unit Code
								flatFile.append(japanManifestListEmptyBlInfoVO.getData53()).append("\r\n"); //66.Gross Weight
								flatFile.append(japanManifestListEmptyBlInfoVO.getData54()).append("\r\n"); //67.Weight Unit Code
								flatFile.append(japanManifestListEmptyBlInfoVO.getData55()).append("\r\n"); //68.Net Weight
								flatFile.append(japanManifestListEmptyBlInfoVO.getData56()).append("\r\n"); //69.Weight Unit Code
								flatFile.append(japanManifestListEmptyBlInfoVO.getData57()).append("\r\n"); //70.Measurement
								flatFile.append(japanManifestListEmptyBlInfoVO.getData58()).append("\r\n"); //71.Measurement Unit Code
								flatFile.append(japanManifestListEmptyBlInfoVO.getData59()).append("\r\n"); //72.Country of Origin Code
								flatFile.append(japanManifestListEmptyBlInfoVO.getData60()).append("\r\n"); //73.Special Cargo Code
								flatFile.append(japanManifestListEmptyBlInfoVO.getData61()).append("\r\n"); //74.Freight
								flatFile.append(japanManifestListEmptyBlInfoVO.getData62()).append("\r\n"); //75.Freight Currency Code
								flatFile.append(japanManifestListEmptyBlInfoVO.getData63()).append("\r\n"); //76.Value
								flatFile.append(japanManifestListEmptyBlInfoVO.getData64()).append("\r\n"); //77.Value Currency Code
								flatFile.append(japanManifestListEmptyBlInfoVO.getData65()).append("\r\n"); //78.General Customs Transit Approval Number
								flatFile.append(japanManifestListEmptyBlInfoVO.getData66()).append("\r\n"); //79.Temporary Landing Identifier
								flatFile.append(japanManifestListEmptyBlInfoVO.getData67()).append("\r\n"); //80.Reason for Temporary Landing Code
								flatFile.append(japanManifestListEmptyBlInfoVO.getData68()).append("\r\n"); //81.Duration of Temporary Landing
								flatFile.append(japanManifestListEmptyBlInfoVO.getData69()).append("\r\n"); //82.Estimated Start Date of Transportation
								flatFile.append(japanManifestListEmptyBlInfoVO.getData70()).append("\r\n"); //83.Estimated Finish Date of Transportation
								flatFile.append(japanManifestListEmptyBlInfoVO.getData71()).append("\r\n"); //84.Code of Transportation Mode of Separate Transit/Customs Transit of Temporary Landing Cargo
								flatFile.append(japanManifestListEmptyBlInfoVO.getData72()).append("\r\n"); //85.Arrival Place Code
								flatFile.append(japanManifestListEmptyBlInfoVO.getData73()).append("\r\n"); //86.Arrival Place Name
								flatFile.append(japanManifestListEmptyBlInfoVO.getData74()).append("\r\n"); //87.Code of Other Relevant Laws and Ordinances(반복1)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData75()).append("\r\n"); //88.Code of Other Relevant Laws and Ordinances(반복2)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData76()).append("\r\n"); //89.Code of Other Relevant Laws and Ordinances(반복3)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData77()).append("\r\n"); //90.Code of Other Relevant Laws and Ordinances(반복4)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData78()).append("\r\n"); //91.Code of Other Relevant Laws and Ordinances(반복5)
								flatFile.append(japanManifestListEmptyBlInfoVO.getData79()).append("\r\n"); //92.Remarks
								
								if (japanManifestListEmptyBlCntrInfoVOs.size() != 0) {
									for (int k = 0; k < japanManifestListEmptyBlCntrInfoVOs.size(); k++) {
										JapanManifestListEmptyBlCntrInfoVO japanManifestListEmptyBlCntrInfoVO = japanManifestListEmptyBlCntrInfoVOs
												.get(k);
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getCntrNo()).append("\r\n"); //93.Container Number
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getCntrSealNo()).append("\r\n"); //94.Seal Number(1중복)
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData1()).append("\r\n"); //95.Seal Number(2중복)
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData2()).append("\r\n"); //96.Seal Number(3중복)
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData3()).append("\r\n"); //97.Seal Number(4중복)
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData4()).append("\r\n"); //98.Seal Number(5중복)
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData5()).append("\r\n"); //99.Seal Number(6중복)
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData6()).append("\r\n"); //100.Empty/Full Container Identification
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData7()).append("\r\n"); //101.Container Size Code
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData8()).append("\r\n"); //102.Container Type Code
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData9()).append("\r\n"); //103.Service Type on Delivery Code
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData10()).append("\r\n"); //104.Container Ownership Code
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData11()).append("\r\n"); //105.Vanning Type Code
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData12()).append("\r\n"); //106.Customs Convention on Containers (CCC) Application Identifier
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData13()).append("\r\n"); //107.Automatic Search for Discharged Container Exclusion Identifier
									}
								} else {
									flatFile.append("            ").append("\r\n"); //93.Container Number
									flatFile.append("               ").append("\r\n"); //94.Seal Number(1중복)
									flatFile.append("               ").append("\r\n"); //95.Seal Number(2중복)
									flatFile.append("               ").append("\r\n"); //96.Seal Number(3중복)
									flatFile.append("               ").append("\r\n"); //97.Seal Number(4중복)
									flatFile.append("               ").append("\r\n"); //98.Seal Number(5중복)
									flatFile.append("               ").append("\r\n"); //99.Seal Number(6중복)
									flatFile.append("   ").append("\r\n"); //100.Empty/Full Container Identification
									flatFile.append("  ").append("\r\n"); //101.Container Size Code
									flatFile.append("  ").append("\r\n"); //102.Container Type Code
									flatFile.append("  ").append("\r\n"); //103.Service Type on Delivery Code
									flatFile.append("   ").append("\r\n"); //104.Container Ownership Code
									flatFile.append("   ").append("\r\n"); //105.Vanning Type Code
									flatFile.append(" ").append("\r\n"); //106.Customs Convention on Containers (CCC) Application Identifier
									flatFile.append(" ").append("\r\n"); //107.Automatic Search for Discharged Container Exclusion Identifier
								}
							} else {
								japanManifestListBlGeneralInfoVOs = dbDao.searchBlGeneralRenewal2017(blKeyVO);
								JapanManifestListBlGeneralInfoVO japanManifestListBlGeneralInfoVO = japanManifestListBlGeneralInfoVOs
										.get(0);
		
								japanManifestListBlCustInfoVOs = dbDao.searchBlCustRenewal2017(blKeyVO);
								JapanManifestListBlCustInfoVO japanManifestListBlCustInfoVO = new JapanManifestListBlCustInfoVO();
								if (japanManifestListBlCustInfoVOs.size() > 0)
									japanManifestListBlCustInfoVO = japanManifestListBlCustInfoVOs.get(0);
		
								japanManifestListBlCntrInfoVOs = dbDao.searchBlCntrRenewal2017(blKeyVO);
		
								japanManifestListBlMarkDescInfoVOs = dbDao.searchBlMarkDescRenewal2017(blKeyVO);
		
								StringBuffer mark = new StringBuffer();
								StringBuffer desc = new StringBuffer();
								
								if (japanManifestListBlMarkDescInfoVOs.size() > 0){
									mark.append(japanManifestListBlMarkDescInfoVOs.get(0).getDiffRmk());
									desc.append(japanManifestListBlMarkDescInfoVOs.get(0).getBlDesc());
								}
									
								if ( mark.toString().length() == 0 )
									mark.append("N/M");
								if ( desc.toString().length() == 0 )
									desc.append("N/M");
								flatFile.append(inProcessGb).append("\r\n"); //2.Function Type Code
								flatFile.append(japanManifestListBlGeneralInfoVO.getCorCd()).append("\r\n"); //3.Correction reason code
								flatFile.append(japanManifestListBlGeneralInfoVO.getCorReason()).append("\r\n"); //4.Correction reason
								flatFile.append(japanManifestListBlGeneralInfoVO.getDelCd()).append("\r\n"); //5.Reason for Deletion Code
								flatFile.append(japanManifestListBlGeneralInfoVO.getDelReason()).append("\r\n"); //6.Deletion reason
								flatFile.append(japanManifestListBlGeneralInfoVO.getInCallSgnNo()).append("\r\n"); //7.Vessel Code
								flatFile.append(japanManifestListBlGeneralInfoVO.getOpVvdCd()).append("\r\n"); //8.Operating Carrier Voyage Number
								flatFile.append(japanManifestListBlGeneralInfoVO.getInVvdCd()).append("\r\n"); //9.Voyage number
								flatFile.append("SMLM").append("\r\n"); //10.Carrier Code
								flatFile.append(inJapanPod).append("\r\n"); //11.Port of Discharge Code
								flatFile.append(inPodSplitCd).append("\r\n"); //12.Port of Discharge Suffix
								flatFile.append(inVpsEtaDt).append("\r\n"); //13.Estimated Date of Arrival
								flatFile.append(japanManifestListBlGeneralInfoVO.getCyOprCd()).append("\r\n"); //14.Container Operator Code
								flatFile.append(japanManifestListBlGeneralInfoVO.getData2()).append("\r\n"); //15.B/L No.
								flatFile.append(japanManifestListBlGeneralInfoVO.getUnLocId1()).append("\r\n"); //16.Port of Loading Code
								flatFile.append(japanManifestListBlGeneralInfoVO.getData3()).append("\r\n"); //17.Final destination code
								flatFile.append(japanManifestListBlGeneralInfoVO.getData4()).append("\r\n"); //18.Final Destination Name
								flatFile.append(japanManifestListBlGeneralInfoVO.getUnLocId2()).append("\r\n"); //19.Place of Delivery Code
								flatFile.append(japanManifestListBlGeneralInfoVO.getLocNm()).append("\r\n"); //20.Place of Delivery Name
		
								flatFile.append(japanManifestListBlCustInfoVO.getData1()).append("\r\n"); //21.Shipper Code
								flatFile.append(japanManifestListBlCustInfoVO.getCustNm1()).append("\r\n"); //22.Shipper Name
								flatFile.append(japanManifestListBlCustInfoVO.getCustAddr1()).append("\r\n"); //23.Shipper Address (block entry)
								flatFile.append(japanManifestListBlCustInfoVO.getData2()).append("\r\n"); //24.Shipper Address 1/4 (Street and number/P.O. Box)
								flatFile.append(japanManifestListBlCustInfoVO.getData3()).append("\r\n"); //25.Shipper Address 2/4 (Street and number/P.O. Box)
								flatFile.append(japanManifestListBlCustInfoVO.getData4()).append("\r\n"); //26.Shipper Address 3/4 (City name)
								flatFile.append(japanManifestListBlCustInfoVO.getData5()).append("\r\n"); //27.Shipper Address 4/4 (Country sub-entity, name)
								flatFile.append(japanManifestListBlCustInfoVO.getData6()).append("\r\n"); //28.Shipper Postal Code (Postcode identification)
								flatFile.append(japanManifestListBlCustInfoVO.getCustCntCd1()).append("\r\n"); //29.Shipper Country Code (Country, coded)
								flatFile.append(japanManifestListBlCustInfoVO.getPhnNo1()).append("\r\n"); //30.Shipper Telephone Number
								flatFile.append(japanManifestListBlCustInfoVO.getData7()).append("\r\n"); //31.Consignee Code
								flatFile.append(japanManifestListBlCustInfoVO.getCustNm2()).append("\r\n"); //32.Consignee Name
								flatFile.append(japanManifestListBlCustInfoVO.getCustAddr2()).append("\r\n"); //33.Consignee Address (block entry)
								flatFile.append(japanManifestListBlCustInfoVO.getData8()).append("\r\n"); //34.Consignee Address 1/4 (Street and number/P.O. Box)
								flatFile.append(japanManifestListBlCustInfoVO.getData9()).append("\r\n"); //35.Consignee Address 2/4 (Street and number/P.O. Box)
								flatFile.append(japanManifestListBlCustInfoVO.getData10()).append("\r\n"); //36.Consignee Address 3/4 (City name)
								flatFile.append(japanManifestListBlCustInfoVO.getData11()).append("\r\n"); //37.Consignee Address 4/4 (Country sub-entity, name)
								flatFile.append(japanManifestListBlCustInfoVO.getData12()).append("\r\n"); //38.Consignee Postal Code (Postcode identification)
								flatFile.append(japanManifestListBlCustInfoVO.getCustCntCd2()).append("\r\n"); //39.Consignee Country Code (Country, coded)
								flatFile.append(japanManifestListBlCustInfoVO.getPhnNo2()).append("\r\n"); //40.Consignee Telephone Number
								flatFile.append(japanManifestListBlCustInfoVO.getData13()).append("\r\n"); //41.Notify Party Code
								flatFile.append(japanManifestListBlCustInfoVO.getCustNm3()).append("\r\n"); //42.Notify Party Name
								flatFile.append(japanManifestListBlCustInfoVO.getCustAddr3()).append("\r\n"); //43.Notify Party Address (block entry)
								flatFile.append(japanManifestListBlCustInfoVO.getData14()).append("\r\n"); //44.Notify Party Address 1/4(Street and number/P.O.Box)
								flatFile.append(japanManifestListBlCustInfoVO.getData15()).append("\r\n"); //45.Notify Party Address 2/4(Street and number/P.O.Box)
								flatFile.append(japanManifestListBlCustInfoVO.getData16()).append("\r\n"); //46.Notify Party Address 3/4(City name)
								flatFile.append(japanManifestListBlCustInfoVO.getData17()).append("\r\n"); //47.Notify Party Address 4/4(Country sub- entity, name)
								flatFile.append(japanManifestListBlCustInfoVO.getData18()).append("\r\n"); //48.Notify Party Postal Code (Postcode identification)
								flatFile.append(japanManifestListBlCustInfoVO.getCustCntCd3()).append("\r\n"); //49.Notify Party Country Code (Country, coded)
								flatFile.append(japanManifestListBlCustInfoVO.getPhnNo3()).append("\r\n"); //50.Notify Party Telephone Number
								flatFile.append(japanManifestListBlCustInfoVO.getData19()).append("\r\n"); //51.Notify Party Code(반복2)
								flatFile.append(japanManifestListBlCustInfoVO.getData20()).append("\r\n"); //52.Notify Party Name(반복2)
								flatFile.append(japanManifestListBlCustInfoVO.getData21()).append("\r\n"); //53.Notify Party Address (block entry)(반복2)
								flatFile.append(japanManifestListBlCustInfoVO.getData22()).append("\r\n"); //54.Notify Party Address 1/4（Street and number/P.O.Box）(반복2)
								flatFile.append(japanManifestListBlCustInfoVO.getData23()).append("\r\n"); //55.Notify Party Address 2/4（Street and number/P.O.Box）(반복2)
								flatFile.append(japanManifestListBlCustInfoVO.getData24()).append("\r\n"); //56.Notify Party Address 3/4（City name）(반복2)
								flatFile.append(japanManifestListBlCustInfoVO.getData25()).append("\r\n"); //57.Notify Party Address 4/4（Country sub- entity, name）(반복2)
								flatFile.append(japanManifestListBlCustInfoVO.getData26()).append("\r\n"); //58.Notify Party Postal Code (Postcode identification)(반복2)
								flatFile.append(japanManifestListBlCustInfoVO.getData27()).append("\r\n"); //59.Notify Party Country Code (Country, coded)(반복2)
								flatFile.append(japanManifestListBlCustInfoVO.getData28()).append("\r\n"); //60.Notify Party Telephone Number(반복2)
		
								flatFile.append(String.format("%-350s",desc.toString())).append("\r\n"); //61.Goods Description
								flatFile.append(japanManifestListBlGeneralInfoVO.getData5()).append("\r\n"); //62.HS Code
								flatFile.append(String.format("%-140s",mark.toString())).append("\r\n"); //63.Marks and Numbers
								flatFile.append(japanManifestListBlGeneralInfoVO.getPckQty()).append("\r\n"); //64.Number of Packages
								flatFile.append(japanManifestListBlGeneralInfoVO.getPckCstmsCd()).append("\r\n"); //65.Number of Packages Unit Code
								flatFile.append(japanManifestListBlGeneralInfoVO.getGrsWgt()).append("\r\n"); //66.Gross Weight
								flatFile.append(japanManifestListBlGeneralInfoVO.getWgtUtCd()).append("\r\n"); //67.Weight Unit Code
								flatFile.append(japanManifestListBlGeneralInfoVO.getData6()).append("\r\n"); //68.Net Weight
								flatFile.append(japanManifestListBlGeneralInfoVO.getData7()).append("\r\n"); //69.Weight Unit Code
								flatFile.append(japanManifestListBlGeneralInfoVO.getMeasQty()).append("\r\n"); //70.Measurement
								flatFile.append(japanManifestListBlGeneralInfoVO.getMeasUtCd()).append("\r\n"); //71.Measurement Unit Code
								flatFile.append(japanManifestListBlGeneralInfoVO.getData8()).append("\r\n"); //72.Country of Origin Code
								flatFile.append(japanManifestListBlGeneralInfoVO.getData9()).append("\r\n"); //73.Special Cargo Code
								flatFile.append(japanManifestListBlGeneralInfoVO.getData10()).append("\r\n"); //74.Freight
								flatFile.append(japanManifestListBlGeneralInfoVO.getData11()).append("\r\n"); //75.Freight Currency Code
								flatFile.append(japanManifestListBlGeneralInfoVO.getData12()).append("\r\n"); //76.Value
								flatFile.append(japanManifestListBlGeneralInfoVO.getData13()).append("\r\n"); //77.Value Currency Code
								flatFile.append(japanManifestListBlGeneralInfoVO.getData14()).append("\r\n"); //78.General Customs Transit Approval Number
								flatFile.append(japanManifestListBlGeneralInfoVO.getLoclTsFlg1()).append("\r\n"); //79.Temporary Landing Identifier
								flatFile.append(japanManifestListBlGeneralInfoVO.getLoclTsFlg2()).append("\r\n"); //80.Reason for Temporary Landing Code
								flatFile.append(japanManifestListBlGeneralInfoVO.getLoclTsFlg3()).append("\r\n"); //81.Duration of Temporary Landing
								flatFile.append(japanManifestListBlGeneralInfoVO.getData15()).append("\r\n"); //82.Estimated Start Date of Transportation
								flatFile.append(japanManifestListBlGeneralInfoVO.getData16()).append("\r\n"); //83.Estimated Finish Date of Transportation
								flatFile.append(japanManifestListBlGeneralInfoVO.getData17()).append("\r\n"); //84.Code of Transportation Mode of Separate Transit/Customs Transit of Temporary Landing Cargo
								flatFile.append(japanManifestListBlGeneralInfoVO.getData18()).append("\r\n"); //85.Arrival Place Code
								flatFile.append(japanManifestListBlGeneralInfoVO.getData19()).append("\r\n"); //86.Arrival Place Name
								flatFile.append(japanManifestListBlGeneralInfoVO.getData20()).append("\r\n"); //87.Code of Other Relevant Laws and Ordinances(반복1)
								flatFile.append(japanManifestListBlGeneralInfoVO.getData21()).append("\r\n"); //88.Code of Other Relevant Laws and Ordinances(반복2)
								flatFile.append(japanManifestListBlGeneralInfoVO.getData22()).append("\r\n"); //89.Code of Other Relevant Laws and Ordinances(반복3)
								flatFile.append(japanManifestListBlGeneralInfoVO.getData23()).append("\r\n"); //90.Code of Other Relevant Laws and Ordinances(반복4)
								flatFile.append(japanManifestListBlGeneralInfoVO.getData24()).append("\r\n"); //91.Code of Other Relevant Laws and Ordinances(반복5)
								flatFile.append(japanManifestListBlGeneralInfoVO.getData25()).append("\r\n"); //92.Remarks
								
								if (japanManifestListBlCntrInfoVOs.size() != 0) {
									for (int k = 0; k < japanManifestListBlCntrInfoVOs.size(); k++) {
										JapanManifestListBlCntrInfoVO japanManifestListBlCntrInfoVO = japanManifestListBlCntrInfoVOs
												.get(k);
										flatFile.append(japanManifestListBlCntrInfoVO.getCntrNo()).append("\r\n"); //93.Container Number
										flatFile.append(japanManifestListBlCntrInfoVO.getCntrSealNo()).append("\r\n"); //94.Seal Number(1중복)
										flatFile.append(japanManifestListBlCntrInfoVO.getData2()).append("\r\n"); //95.Seal Number(2중복)
										flatFile.append(japanManifestListBlCntrInfoVO.getData3()).append("\r\n"); //96.Seal Number(3중복)
										flatFile.append(japanManifestListBlCntrInfoVO.getData4()).append("\r\n"); //97.Seal Number(4중복)
										flatFile.append(japanManifestListBlCntrInfoVO.getData5()).append("\r\n"); //98.Seal Number(5중복)
										flatFile.append(japanManifestListBlCntrInfoVO.getData6()).append("\r\n"); //99.Seal Number(6중복)
										flatFile.append(japanManifestListBlCntrInfoVO.getFullMtyCd()).append("\r\n"); //100.Empty/Full Container Identification
										flatFile.append(japanManifestListBlCntrInfoVO.getCntrTpszCd()).append("\r\n"); //101.Container Size Code
										flatFile.append(japanManifestListBlCntrInfoVO.getCntrTpszCd2()).append("\r\n"); //102.Container Type Code
										flatFile.append(japanManifestListBlCntrInfoVO.getDeTermCd()).append("\r\n"); //103.Service Type on Delivery Code
										flatFile.append(japanManifestListBlCntrInfoVO.getJpCntrOwnrCd()).append("\r\n"); //104.Container Ownership Code
										flatFile.append(japanManifestListBlCntrInfoVO.getRcvTermCd()).append("\r\n"); //105.Vanning Type Code
										flatFile.append(japanManifestListBlCntrInfoVO.getData7()).append("\r\n"); //106.Customs Convention on Containers (CCC) Application Identifier
										flatFile.append(japanManifestListBlCntrInfoVO.getData8()).append("\r\n"); //107.Automatic Search for Discharged Container Exclusion Identifier
									}
								} else {
									flatFile.append("            ").append("\r\n"); //93.Container Number
									flatFile.append("               ").append("\r\n"); //94.Seal Number(1중복)
									flatFile.append("               ").append("\r\n"); //95.Seal Number(2중복)
									flatFile.append("               ").append("\r\n"); //96.Seal Number(3중복)
									flatFile.append("               ").append("\r\n"); //97.Seal Number(4중복)
									flatFile.append("               ").append("\r\n"); //98.Seal Number(5중복)
									flatFile.append("               ").append("\r\n"); //99.Seal Number(6중복)
									flatFile.append("   ").append("\r\n"); //100.Empty/Full Container Identification
									flatFile.append("  ").append("\r\n"); //101.Container Size Code
									flatFile.append("  ").append("\r\n"); //102.Container Type Code
									flatFile.append("  ").append("\r\n"); //103.Service Type on Delivery Code
									flatFile.append("   ").append("\r\n"); //104.Container Ownership Code
									flatFile.append("   ").append("\r\n"); //105.Vanning Type Code
									flatFile.append(" ").append("\r\n"); //106.Customs Convention on Containers (CCC) Application Identifier
									flatFile.append(" ").append("\r\n"); //107.Automatic Search for Discharged Container Exclusion Identifier
								}
		
							}
							//flatFile = flatFile.toString().replace('’',' ');
							BookingUtil command = new BookingUtil();
							String sndDt = command.searchLocalTime(account.getCnt_cd()+account.getOfc_cd().substring(0,3));//japanManifestListSendHeaderInfoVOs.get(0).getHeader().substring(41, 55);
							japanManifestListSendHeaderInfoVOs = dbDao.searchSendHeaderRenewal2017(vvdCd, inPodCd, account.getOfc_cd(),
									account.getUsr_id(), inMsgTp, sndDt, flatFile.toString().replace("’","'").length()+"", ""); 
							flatFile2.append(japanManifestListSendHeaderInfoVOs.get(0).getHeader()).append("\n");
							flatFile2.append(japanManifestListSendHeaderInfoVOs.get(0).getHeader2()).append("\r\n");
		
							realFlatFile.append(flatFile2).append(flatFile.toString().replace("’","'"));
							
							SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
							sendFlatFileVO.setFlatFile(realFlatFile.toString());
							sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_NACCS.IBMMQ.QUEUE"));
							
							FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
		
							if (flatFileAckVO.getAckStsCd().equals("E"))
								throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
		
							
							logSeq = dbDao.searchSendLogSeq(sndDt);
		
							BkgCstmsJpSndLogVO bkgCstmsJpSndLogVO = new BkgCstmsJpSndLogVO();
							bkgCstmsJpSndLogVO.setJpSndLogId(inMsgTp);
							bkgCstmsJpSndLogVO.setSndDt(sndDt);
							bkgCstmsJpSndLogVO.setOfcCd(account.getOfc_cd());
							bkgCstmsJpSndLogVO.setVslCd(vslCd);
							bkgCstmsJpSndLogVO.setSkdVoyNo(skdVoyNo);
							bkgCstmsJpSndLogVO.setSkdDirCd(skdDirCd);
							bkgCstmsJpSndLogVO.setPodCd(inPodCd);
							bkgCstmsJpSndLogVO.setLogFlg("N");
							bkgCstmsJpSndLogVO.setBlNo(japanManifestTransmitVO.getBlNumber().substring(0, 12));
							
							bkgCstmsJpSndLogVO.setCreUsrId(account.getUsr_id());
							if (logSeq == 0) {
								bkgCstmsJpSndLogVO.setLogSeq("1");
								logSeq = 1;
							} else {
								if (logSeq + 1 > 999) { 
									throw new EventException(new ErrorHandler("BKG01003", new String[] {}).getMessage());
								} else {
									bkgCstmsJpSndLogVO.setLogSeq(++logSeq + "");
								}
							}
							dbDao.addSendLog(bkgCstmsJpSndLogVO);
							
							
							
							ArrayList tmpArray = new ArrayList();
							StringTokenizer token = new StringTokenizer(realFlatFile.toString().replace("\r\n","\n"), "\n");
							int j = 0;
							BkgCstmsJpSndLogDtlVO bkgCstmsJpSndLogDtlVO = new BkgCstmsJpSndLogDtlVO();
							bkgCstmsJpSndLogDtlVO.setJpSndLogId(inMsgTp);
							bkgCstmsJpSndLogDtlVO.setMsgSndDt(sndDt);
							bkgCstmsJpSndLogDtlVO.setOfcCd(account.getOfc_cd());
							bkgCstmsJpSndLogDtlVO.setLogSeq(logSeq + "");
							bkgCstmsJpSndLogDtlVO.setCreUsrId(account.getUsr_id());
							while (token.hasMoreTokens()) {
								tmpArray.add(token.nextToken());
								if (j > 1) {
									bkgCstmsJpSndLogDtlVO.setSubSeq(j - 1 + "");
									bkgCstmsJpSndLogDtlVO.setEdiSndMsg(tmpArray.get(j++).toString().replace("'", "''"));
		
									dbDao.addSendLogDetail(bkgCstmsJpSndLogDtlVO);
								} else {
									j++;
								}
							}
							
							if (i < japanManifestTransmitVOs.length)
								realFlatFile2 = realFlatFile2.append(realFlatFile).append("\r\n");
		
							
		
		
						blNumber = japanManifestTransmitVO.getBlNumber();
						realCount++;
					}
				}
			} catch (EventException ex) {
				throw ex;
			} catch (DAOException ex) {
				throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
			}
			JapanManifestListTransmitDetailVO japanManifestListTransmitDetailVO = new JapanManifestListTransmitDetailVO();
			japanManifestListTransmitDetailVO.setFliatFile(realFlatFile2.toString());

			japanManifestListTransmitDetailVO.setJapanBlKeyVOs(japanBlKeyVOs);
			return (ManifestTransmitDetailVO)japanManifestListTransmitDetailVO;
		
		// 기존 버전	
		} else {
			StringBuffer realFlatFile2 = new StringBuffer();
			JapanManifestTransmitContainerVO japanManifestTransmitContainerVO = (JapanManifestTransmitContainerVO) manifestTransmitVO;
			JapanManifestTransmitVO[] japanManifestTransmitVOs = japanManifestTransmitContainerVO
					.getJapanManifestTransmitVOs();
			JapanManifestTransmitCondVO japanManifestTransmitCondVO = japanManifestTransmitContainerVO
					.getJapanManifestTransmitCondVO();
			List<JapanTransmitBlKeyVO> japanBlKeyVOs = new ArrayList<JapanTransmitBlKeyVO>();
			String blNumber = "";
			int realCount = 0;
			
			try {
				for (int i = 0; i < japanManifestTransmitVOs.length; i++) {
					JapanManifestTransmitVO japanManifestTransmitVO = japanManifestTransmitVOs[i];
					if (!japanManifestTransmitVO.getBlNumber().equals(blNumber)) {
						StringBuffer realFlatFile = new StringBuffer();
//						int logCount = 0;
						int logSeq = 0;
						String inProcessGb = null;
						String etaDt = "";
						String inJapanPod = "";
		
						List<JapanManifestListJpcusEtaInfoVO> japanManifestListJpcusEtaInfoVOs = null;
						List<JapanManifestListEmptyBlInfoVO> japanManifestListEmptyBlInfoVOs = null;
						List<JapanManifestListBlGeneralInfoVO> japanManifestListBlGeneralInfoVOs = null;
						List<JapanManifestListEmptyBlCntrInfoVO> japanManifestListEmptyBlCntrInfoVOs = null;
						List<JapanManifestListBlCustInfoVO> japanManifestListBlCustInfoVOs = null;
						List<JapanManifestListBlCntrInfoVO> japanManifestListBlCntrInfoVOs = null;
						List<JapanManifestListBlMarkDescInfoVO> japanManifestListBlMarkDescInfoVOs = null;
						List<JapanManifestListSendHeaderInfoVO> japanManifestListSendHeaderInfoVOs = null;
						
		
							String vvdCd = japanManifestTransmitCondVO.getInVvdCd();
							String vslCd = japanManifestTransmitCondVO.getInVvdCd().substring(0, 4);
							String skdVoyNo = japanManifestTransmitCondVO.getInVvdCd().substring(4, 8);
							String skdDirCd = japanManifestTransmitCondVO.getInVvdCd().substring(8);
							String inPodCd = japanManifestTransmitCondVO.getInPodCd();
							String inPodSplitCd = japanManifestTransmitCondVO.getInPodSplitCd();
							String inPolCd = japanManifestTransmitCondVO.getInPolCd();
							String inCallSgnNo = japanManifestTransmitCondVO.getInCallSgnNo();
							String inCyOprCd = japanManifestTransmitCondVO.getInCyOprCd();
							String inVpsEtaDt = japanManifestTransmitCondVO.getInVpsEtaDt();
							String inMsgTp = japanManifestTransmitCondVO.getInMsgTp();
							String inMsgFlag = japanManifestTransmitCondVO.getInMsgFlag();
							String inMfrGubun = japanManifestTransmitCondVO.getInMfrGubun();
							String inVoyageNo = japanManifestTransmitCondVO.getInVoyageNo();
							
		
							japanManifestTransmitVO.setInVslCd(vslCd);
							japanManifestTransmitVO.setInSkdVoyNo(skdVoyNo);
							japanManifestTransmitVO.setInSkdDirCd(skdDirCd);
							japanManifestTransmitVO.setInPodCd(inPodCd);
							japanManifestTransmitVO.setInPolCd(inPolCd);
							japanManifestTransmitVO.setInCallSgnNo(inCallSgnNo);
							japanManifestTransmitVO.setInCyOprCd(inCyOprCd);
							japanManifestTransmitVO.setInVpsEtaDt(inVpsEtaDt);
							japanManifestTransmitVO.setInVoyageNo(inVoyageNo);
							
							//세관 전송시 pod를 일본세관에서 사용하는 pod로 보내기 위해 사용 2014.03.05
							inJapanPod = dbDao.searchJapanPODInfo(inPodCd);
						
							if(inJapanPod.equals("")||inJapanPod == null) inJapanPod = inPodCd;
		
							japanManifestListJpcusEtaInfoVOs = dbDao.searchJpcusEta(japanManifestTransmitVO);

							if (inCallSgnNo == null || inCallSgnNo.equals("")) {
								if (japanManifestListJpcusEtaInfoVOs.get(0).getCallSgnNo() == null || japanManifestListJpcusEtaInfoVOs.get(0).getCallSgnNo().equals("")) {
									inCallSgnNo = dbDao.searchVslCallsign(vslCd);
								} else {									
									inCallSgnNo = japanManifestListJpcusEtaInfoVOs.get(0).getCallSgnNo();
								}
							}

							if (inVpsEtaDt == null || inVpsEtaDt.equals("")) {

								if (japanManifestListJpcusEtaInfoVOs.get(0).getEtaDt() == null) {
									etaDt = dbDao.searchEta(japanManifestTransmitVO);
									inVpsEtaDt = etaDt;
								} else {
									inVpsEtaDt = japanManifestListJpcusEtaInfoVOs.get(0).getEtaDt();
								}
							}
									
//							logCount = dbDao.searchDmfSendLog(japanManifestTransmitVO);
		
							//if (logCount < 1) {
							if (inMsgTp.equals("MFR")) {
								inProcessGb = "9";
							} else 
							{
								inProcessGb = inMsgFlag;
							}
							/*}
							if (inMsgTp.equals("CMF01")) {
									}
									if (inMsgFlag.equals("1")) {
										inProcessGb = "1";
									} else {
										inProcessGb = "5";
									}
								} else {
									inProcessGb = "5";
								}
							} else {
								if (inMsgTp.equals("CMF02")) {
									if (inMsgFlag.equals("2")) {
										inProcessGb = "2";
									} else if (inMsgFlag.equals("1")) {
										inProcessGb = "1";
									} else {
										inProcessGb = "5";
									}
								} else {
									if (inMsgFlag.equals("1")) {
										inProcessGb = "1";
									} else {
										inProcessGb = "5";
									}
								}
							}*/
		
							StringBuffer flatFile = new StringBuffer();
							StringBuffer flatFile2 = new StringBuffer();
							String mtyBkgFlg = null;
							JapanTransmitBlKeyVO blKeyVO = new JapanTransmitBlKeyVO();
							blKeyVO.setBlNo(japanManifestTransmitVO.getBlNumber().substring(0, 12));
							
							if (japanManifestTransmitVO.getBlNumber().length() > 12)
								blKeyVO.setBlSplitNo(japanManifestTransmitVO.getBlNumber().substring(12));
							blKeyVO.setInMsgTp(inMsgTp);
							blKeyVO.setInMsgFlag(inMsgFlag);
							blKeyVO.setInCallSgnNo(inCallSgnNo);
							blKeyVO.setInVvdCd(vvdCd);
							
							japanBlKeyVOs.add(realCount, blKeyVO);
		
							mtyBkgFlg = dbDao.searchEmptyInd(blKeyVO);
		
							inVpsEtaDt = inVpsEtaDt.replace("-", "");
							if (inVpsEtaDt.equals("") || inVpsEtaDt == null)
								inVpsEtaDt = "        ";
		
							if (inPodSplitCd.equals("") || inPodSplitCd == null || inPodSplitCd.length() == 0)
								inPodSplitCd = " ";
		
							JapanManifestModificationVO japanManifestModificationVO = new JapanManifestModificationVO();
							
							japanManifestModificationVO.setInVslCd(vslCd);
							japanManifestModificationVO.setInSkdVoyNo(skdVoyNo);
							japanManifestModificationVO.setInSkdDirCd(skdDirCd);
							japanManifestModificationVO.setInPodCd(inPodCd);
							japanManifestModificationVO.setInCallSgnNo(inCallSgnNo);
							japanManifestModificationVO.setInCyOprCd(inCyOprCd);
							japanManifestModificationVO.setInVpsEtaDt(inVpsEtaDt);
							japanManifestModificationVO.setUpdUsrId(account.getUsr_id());
							japanManifestModificationVO.setInVoyageNo(inVoyageNo);
							
							if (inMsgTp.equals("MFR")&&!inMfrGubun.equals("N")) 
								dbDao3.modifyJpcusBl(japanManifestModificationVO);					
							
							if (!mtyBkgFlg.equals("F")) {
								japanManifestListEmptyBlInfoVOs = dbDao.searchEmptyBl(blKeyVO);
								JapanManifestListEmptyBlInfoVO japanManifestListEmptyBlInfoVO = japanManifestListEmptyBlInfoVOs
										.get(0);
		
								japanManifestListEmptyBlCntrInfoVOs = dbDao.searchEmptyBlCntr(blKeyVO);
		
								flatFile.append(inProcessGb).append("\r\n");
		
								flatFile.append(japanManifestListEmptyBlInfoVO.getInCallSgnNo()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getInVvdCd()).append("\r\n");
								flatFile.append("SMLM").append("\r\n");
								flatFile.append(inJapanPod).append("\r\n");
								flatFile.append(inPodSplitCd).append("\r\n");
								flatFile.append(inVpsEtaDt).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getCyOprCd()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData2()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData3()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData4()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData5()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData6()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData7()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData8()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData9()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData10()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData11()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData12()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData13()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData14()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData15()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData16()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData17()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData18()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData19()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData20()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData21()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData22()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData23()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData24()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData25()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData26()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData27()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData28()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData29()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData30()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData31()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData32()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData33()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData34()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData35()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData36()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData37()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData38()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData39()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData40()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData41()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData42()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData43()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData44()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData45()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData46()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData47()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData48()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData49()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData50()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData51()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData52()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData53()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData54()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData55()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData56()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData57()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData58()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData59()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData60()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData61()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData62()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData63()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData64()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData65()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData66()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData67()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData68()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData69()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData70()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData71()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData72()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData73()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData74()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData75()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData76()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData77()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData78()).append("\r\n");
								flatFile.append(japanManifestListEmptyBlInfoVO.getData79()).append("\r\n");
								
								if (japanManifestListEmptyBlCntrInfoVOs.size() != 0) {
									for (int k = 0; k < japanManifestListEmptyBlCntrInfoVOs.size(); k++) {
										JapanManifestListEmptyBlCntrInfoVO japanManifestListEmptyBlCntrInfoVO = japanManifestListEmptyBlCntrInfoVOs
												.get(k);
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getCntrNo()).append("\r\n");
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getCntrSealNo()).append("\r\n");
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData1()).append("\r\n");
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData2()).append("\r\n");
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData3()).append("\r\n");
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData4()).append("\r\n");
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData5()).append("\r\n");
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData6()).append("\r\n");
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData7()).append("\r\n");
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData8()).append("\r\n");
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData9()).append("\r\n");
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData10()).append("\r\n");
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData11()).append("\r\n");
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData12()).append("\r\n");
										flatFile.append(japanManifestListEmptyBlCntrInfoVO.getData13()).append("\r\n");
									}
								} else {
									flatFile.append("            ").append("\r\n");
									flatFile.append("               ").append("\r\n");
									flatFile.append("               ").append("\r\n");
									flatFile.append("               ").append("\r\n");
									flatFile.append("               ").append("\r\n");
									flatFile.append("               ").append("\r\n");
									flatFile.append("               ").append("\r\n");
									flatFile.append("   ").append("\r\n");
									flatFile.append("  ").append("\r\n");
									flatFile.append("  ").append("\r\n");
									flatFile.append("  ").append("\r\n");
									flatFile.append("   ").append("\r\n");
									flatFile.append("   ").append("\r\n");
									flatFile.append(" ").append("\r\n");
									flatFile.append(" ").append("\r\n");
								}
							} else {
								japanManifestListBlGeneralInfoVOs = dbDao.searchBlGeneral(blKeyVO);
								JapanManifestListBlGeneralInfoVO japanManifestListBlGeneralInfoVO = japanManifestListBlGeneralInfoVOs
										.get(0);
		
								japanManifestListBlCustInfoVOs = dbDao.searchBlCust(blKeyVO);
								JapanManifestListBlCustInfoVO japanManifestListBlCustInfoVO = new JapanManifestListBlCustInfoVO();
								if (japanManifestListBlCustInfoVOs.size() > 0)
									japanManifestListBlCustInfoVO = japanManifestListBlCustInfoVOs.get(0);
		
								japanManifestListBlCntrInfoVOs = dbDao.searchBlCntr(blKeyVO);
		
								japanManifestListBlMarkDescInfoVOs = dbDao.searchBlMarkDesc(blKeyVO);
		
								StringBuffer mark = new StringBuffer();
								StringBuffer desc = new StringBuffer();
								
								if (japanManifestListBlMarkDescInfoVOs.size() > 0){
									mark.append(japanManifestListBlMarkDescInfoVOs.get(0).getDiffRmk());
									desc.append(japanManifestListBlMarkDescInfoVOs.get(0).getBlDesc());
								}
									
								
//								for (int j = 0; j < japanManifestListBlMarkDescInfoVOs.size(); j++) {
//									if (j == 0) {
//										mark.append(japanManifestListBlMarkDescInfoVOs.get(j).getDiffRmk());
//										desc.append(japanManifestListBlMarkDescInfoVOs.get(j).getBlDesc());
//									} else {
//										for (int k = j; k > 0; k--) {
//											if (!japanManifestListBlMarkDescInfoVOs.get(j).getDiffRmk().equals(
//													japanManifestListBlMarkDescInfoVOs.get(j - 1).getDiffRmk())) {
//												mark.append(japanManifestListBlMarkDescInfoVOs.get(j).getDiffRmk());
//											}
//										}
//										for (int k = j; k > 0; k--) {
//											if (!japanManifestListBlMarkDescInfoVOs.get(j).getBlDesc().equals(
//													japanManifestListBlMarkDescInfoVOs.get(j - 1).getBlDesc())) {
//												desc.append(japanManifestListBlMarkDescInfoVOs.get(j).getDiffRmk());
//											}
//										}
//									}
//								}
								if ( mark.toString().length() == 0 )
									mark.append("N/M");
								if ( desc.toString().length() == 0 )
									desc.append("N/M");
								//japanManifestListBlMarkDescInfoVOs = dbDao.searchBlMarkDesc(mark.toString(), desc.toString());
		
								flatFile.append(inProcessGb).append("\r\n");
		
								flatFile.append(japanManifestListBlGeneralInfoVO.getInCallSgnNo()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getInVvdCd()).append("\r\n");
								flatFile.append("SMLM").append("\r\n");
								flatFile.append(inJapanPod).append("\r\n");
								flatFile.append(inPodSplitCd).append("\r\n");
								flatFile.append(inVpsEtaDt).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getCyOprCd()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getData2()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getUnLocId1()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getData3()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getData4()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getUnLocId2()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getLocNm()).append("\r\n");
		
								flatFile.append(japanManifestListBlCustInfoVO.getData1()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getCustNm1()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getCustAddr1()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData2()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData3()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData4()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData5()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData6()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getCustCntCd1()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getPhnNo1()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData7()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getCustNm2()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getCustAddr2()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData8()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData9()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData10()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData11()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData12()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getCustCntCd2()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getPhnNo2()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData13()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getCustNm3()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getCustAddr3()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData14()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData15()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData16()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData17()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData18()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getCustCntCd3()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getPhnNo3()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData19()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData20()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData21()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData22()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData23()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData24()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData25()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData26()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData27()).append("\r\n");
								flatFile.append(japanManifestListBlCustInfoVO.getData28()).append("\r\n");
		
								flatFile.append(String.format("%-70s",desc.toString())).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getData5()).append("\r\n");
								flatFile.append(String.format("%-140s",mark.toString())).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getPckQty()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getPckCstmsCd()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getGrsWgt()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getWgtUtCd()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getData6()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getData7()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getMeasQty()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getMeasUtCd()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getData8()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getData9()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getData10()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getData11()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getData12()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getData13()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getData14()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getLoclTsFlg1()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getLoclTsFlg2()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getLoclTsFlg3()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getData15()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getData16()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getData17()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getData18()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getData19()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getData20()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getData21()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getData22()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getData23()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getData24()).append("\r\n");
								flatFile.append(japanManifestListBlGeneralInfoVO.getData25()).append("\r\n");
								
								if (japanManifestListBlCntrInfoVOs.size() != 0) {
									for (int k = 0; k < japanManifestListBlCntrInfoVOs.size(); k++) {
										JapanManifestListBlCntrInfoVO japanManifestListBlCntrInfoVO = japanManifestListBlCntrInfoVOs
												.get(k);
										flatFile.append(japanManifestListBlCntrInfoVO.getCntrNo()).append("\r\n");
										flatFile.append(japanManifestListBlCntrInfoVO.getCntrSealNo()).append("\r\n");
										flatFile.append(japanManifestListBlCntrInfoVO.getData2()).append("\r\n");
										flatFile.append(japanManifestListBlCntrInfoVO.getData3()).append("\r\n");
										flatFile.append(japanManifestListBlCntrInfoVO.getData4()).append("\r\n");
										flatFile.append(japanManifestListBlCntrInfoVO.getData5()).append("\r\n");
										flatFile.append(japanManifestListBlCntrInfoVO.getData6()).append("\r\n");
										flatFile.append(japanManifestListBlCntrInfoVO.getFullMtyCd()).append("\r\n");
										flatFile.append(japanManifestListBlCntrInfoVO.getCntrTpszCd()).append("\r\n");
										flatFile.append(japanManifestListBlCntrInfoVO.getCntrTpszCd2()).append("\r\n");
										flatFile.append(japanManifestListBlCntrInfoVO.getDeTermCd()).append("\r\n");
										flatFile.append(japanManifestListBlCntrInfoVO.getJpCntrOwnrCd()).append("\r\n");
										flatFile.append(japanManifestListBlCntrInfoVO.getRcvTermCd()).append("\r\n");
										flatFile.append(japanManifestListBlCntrInfoVO.getData7()).append("\r\n");
										flatFile.append(japanManifestListBlCntrInfoVO.getData8()).append("\r\n");
									}
								} else {
									flatFile.append("            ").append("\r\n");
									flatFile.append("               ").append("\r\n");
									flatFile.append("               ").append("\r\n");
									flatFile.append("               ").append("\r\n");
									flatFile.append("               ").append("\r\n");
									flatFile.append("               ").append("\r\n");
									flatFile.append("               ").append("\r\n");
									flatFile.append("   ").append("\r\n");
									flatFile.append("  ").append("\r\n");
									flatFile.append("  ").append("\r\n");
									flatFile.append("  ").append("\r\n");
									flatFile.append("   ").append("\r\n");
									flatFile.append("   ").append("\r\n");
									flatFile.append(" ").append("\r\n");
									flatFile.append(" ").append("\r\n");
								}
		
							}
							//flatFile = flatFile.toString().replace('’',' ');
							BookingUtil command = new BookingUtil();
							String sndDt = command.searchLocalTime(account.getCnt_cd()+account.getOfc_cd().substring(0,3));//japanManifestListSendHeaderInfoVOs.get(0).getHeader().substring(41, 55);
							japanManifestListSendHeaderInfoVOs = dbDao.searchSendHeader(vvdCd, inPodCd, account.getOfc_cd(),
									account.getUsr_id(), inMsgTp, sndDt, flatFile.toString().replace("’","'").length()+"", ""); 
							flatFile2.append(japanManifestListSendHeaderInfoVOs.get(0).getHeader()).append("\n");
							flatFile2.append(japanManifestListSendHeaderInfoVOs.get(0).getHeader2()).append("\r\n");
		
							realFlatFile.append(flatFile2).append(flatFile.toString().replace("’","'"));
							
							SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
							sendFlatFileVO.setFlatFile(realFlatFile.toString());
							sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_NACCS.IBMMQ.QUEUE"));
							
							FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
		
							if (flatFileAckVO.getAckStsCd().equals("E"))
								throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
		
							
							logSeq = dbDao.searchSendLogSeq(sndDt);
		
							BkgCstmsJpSndLogVO bkgCstmsJpSndLogVO = new BkgCstmsJpSndLogVO();
							bkgCstmsJpSndLogVO.setJpSndLogId(inMsgTp);
							bkgCstmsJpSndLogVO.setSndDt(sndDt);
							bkgCstmsJpSndLogVO.setOfcCd(account.getOfc_cd());
							bkgCstmsJpSndLogVO.setVslCd(vslCd);
							bkgCstmsJpSndLogVO.setSkdVoyNo(skdVoyNo);
							bkgCstmsJpSndLogVO.setSkdDirCd(skdDirCd);
							bkgCstmsJpSndLogVO.setPodCd(inPodCd);
							bkgCstmsJpSndLogVO.setLogFlg("N");
							bkgCstmsJpSndLogVO.setBlNo(japanManifestTransmitVO.getBlNumber().substring(0, 12));
							
							bkgCstmsJpSndLogVO.setCreUsrId(account.getUsr_id());
							if (logSeq == 0) {
								bkgCstmsJpSndLogVO.setLogSeq("1");
								logSeq = 1;
							} else {
								if (logSeq + 1 > 999) { 
									throw new EventException(new ErrorHandler("BKG01003", new String[] {}).getMessage());
								} else {
									bkgCstmsJpSndLogVO.setLogSeq(++logSeq + "");
								}
							}
							dbDao.addSendLog(bkgCstmsJpSndLogVO);
							
							
							
							ArrayList tmpArray = new ArrayList();
							StringTokenizer token = new StringTokenizer(realFlatFile.toString().replace("\r\n","\n"), "\n");
							int j = 0;
							BkgCstmsJpSndLogDtlVO bkgCstmsJpSndLogDtlVO = new BkgCstmsJpSndLogDtlVO();
							bkgCstmsJpSndLogDtlVO.setJpSndLogId(inMsgTp);
							bkgCstmsJpSndLogDtlVO.setMsgSndDt(sndDt);
							bkgCstmsJpSndLogDtlVO.setOfcCd(account.getOfc_cd());
							bkgCstmsJpSndLogDtlVO.setLogSeq(logSeq + "");
							bkgCstmsJpSndLogDtlVO.setCreUsrId(account.getUsr_id());
							while (token.hasMoreTokens()) {
								tmpArray.add(token.nextToken());
								if (j > 1) {
									bkgCstmsJpSndLogDtlVO.setSubSeq(j - 1 + "");
									bkgCstmsJpSndLogDtlVO.setEdiSndMsg(tmpArray.get(j++).toString().replace("'", "''"));
		
									dbDao.addSendLogDetail(bkgCstmsJpSndLogDtlVO);
								} else {
									j++;
								}
							}
							
							if (i < japanManifestTransmitVOs.length)
								realFlatFile2 = realFlatFile2.append(realFlatFile).append("\r\n");
		
							
		
		
						blNumber = japanManifestTransmitVO.getBlNumber();
						realCount++;
					}
				}
			} catch (EventException ex) {
				throw ex;
			} catch (DAOException ex) {
				throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
			} catch (Exception ex) {
				throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
			}
			JapanManifestListTransmitDetailVO japanManifestListTransmitDetailVO = new JapanManifestListTransmitDetailVO();
			japanManifestListTransmitDetailVO.setFliatFile(realFlatFile2.toString());

			japanManifestListTransmitDetailVO.setJapanBlKeyVOs(japanBlKeyVOs);
			return (ManifestTransmitDetailVO)japanManifestListTransmitDetailVO;
		}

	}
	
	/**
	 * 전송 이벤트 처리<br>
	 * 세관에 적하목록 신고를 EDI를 통해 재전송한다.<br>
	 * 
	 * @param ManifestTransmitVO manifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifestForResend(ManifestTransmitVO manifestTransmitVO, SignOnUserAccount account)
			throws EventException {
		StringBuffer realFlatFile = new StringBuffer();
		JapanManifestTransmitForReVO japanManifestTransmitForReVO = (JapanManifestTransmitForReVO) manifestTransmitVO;
		List<JapanManifestListSendHeaderInfoVO> japanManifestListSendHeaderInfoVOs = null;
		String sendString = "";
		try {
			sendString = dbDao.searchDetailInfo(japanManifestTransmitForReVO.getJpSndLogId(),
					japanManifestTransmitForReVO.getSndDt() + " " + japanManifestTransmitForReVO.getSndDt2(),
					japanManifestTransmitForReVO.getOfcCd(), japanManifestTransmitForReVO.getLogSeq(), 
					japanManifestTransmitForReVO.getBlNo());

			String toDate = japanManifestTransmitForReVO.getSndDt() + japanManifestTransmitForReVO.getSndDt2();
			toDate = toDate.replace("-", "");
			toDate = toDate.replace(":", ""); 

			japanManifestListSendHeaderInfoVOs = dbDao.searchSendHeader(japanManifestTransmitForReVO.getVvdCd(),
					japanManifestTransmitForReVO.getPodCd(), japanManifestTransmitForReVO.getOfcCd(),
					japanManifestTransmitForReVO.getUpdUsrId(), japanManifestTransmitForReVO.getJpSndLogId(), toDate,
					sendString.length() + "", japanManifestTransmitForReVO.getBlNo());

			realFlatFile.append(japanManifestListSendHeaderInfoVOs.get(0).getHeader()).append("\n");
			realFlatFile.append(japanManifestListSendHeaderInfoVOs.get(0).getHeader2()).append("\r\n");
			realFlatFile.append(sendString);

			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setFlatFile(realFlatFile.toString());
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_NACCS.IBMMQ.QUEUE"));

			BookingUtil command = new BookingUtil();
			FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO); 

			if (flatFileAckVO.getAckStsCd().equals("E"))
				throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());

			BkgCstmsJpSndLogVO bkgCstmsJpSndLogVO = new BkgCstmsJpSndLogVO();
			bkgCstmsJpSndLogVO.setJpSndLogId(japanManifestTransmitForReVO.getJpSndLogId());
			bkgCstmsJpSndLogVO.setSndDt(toDate);
			bkgCstmsJpSndLogVO.setLogDt(command.searchLocalTime(account.getCnt_cd()+account.getOfc_cd().substring(0,3)));
			bkgCstmsJpSndLogVO.setOfcCd(japanManifestTransmitForReVO.getOfcCd());
			bkgCstmsJpSndLogVO.setLogSeq(japanManifestTransmitForReVO.getLogSeq());
			bkgCstmsJpSndLogVO.setUpdUsrId(japanManifestTransmitForReVO.getUpdUsrId());

			dbDao.modifySendLog(bkgCstmsJpSndLogVO);
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return realFlatFile.toString();
	}

	/**
	 * 전송 이벤트 처리<br>
	 * 세관에 VVD 도착 통지 신고를 EDI를 통해 전송한다.<br>
	 * 
	 * @param VesselArrivalTransmitVO vesselArrivalTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	public String transmitVesselArrival(VesselArrivalTransmitVO vesselArrivalTransmitVO, SignOnUserAccount account)
			throws EventException {

		StringBuffer realFlatFile = new StringBuffer();
		StringBuffer realFlatFile2 = new StringBuffer();
		int logCount = 0;
		String etaDt = "";
		String etaDt2 = "";
		JapanVesselArrivalTransmitVO japanVesselArrivalTransmitVO = (JapanVesselArrivalTransmitVO) vesselArrivalTransmitVO;
		JapanManifestTransmitVO japanManifestTransmitVO = new JapanManifestTransmitVO();
		List<JapanManifestListJpcusEtaInfoVO> japanManifestListJpcusEtaInfoVOs = null;
		List<JapanManifestListVesselArrivalDetailVO> japanManifestListVesselArrivalDetailVOs = null;
		List<JapanManifestListSendHeaderInfoForDmfVO> japanManifestListSendHeaderInfoForDmfVOs = null;
		try {
			japanManifestTransmitVO.setInVslCd(japanVesselArrivalTransmitVO.getInVvdCd().substring(0, 4));
			japanManifestTransmitVO.setInSkdVoyNo(japanVesselArrivalTransmitVO.getInVvdCd().substring(4, 8));
			japanManifestTransmitVO.setInSkdDirCd(japanVesselArrivalTransmitVO.getInVvdCd().substring(8));
			japanManifestTransmitVO.setInPodCd(japanVesselArrivalTransmitVO.getInPodCd());

			logCount = dbDao.searchDmfSendLog(japanManifestTransmitVO);

			if (logCount >= 1) {
				throw new EventException(new ErrorHandler("BKG00456", new String[] {}).getMessage());
			} else {
				japanManifestListJpcusEtaInfoVOs = dbDao.searchJpcusEta(japanManifestTransmitVO);

				if (japanManifestListJpcusEtaInfoVOs.size() == 0) {
					etaDt2 = dbDao.searchEta(japanManifestTransmitVO);
					if (etaDt2 != null && !etaDt2.equals(""))
						etaDt = etaDt2;
				} else {
					etaDt = japanManifestListJpcusEtaInfoVOs.get(0).getEtaDt();
				}

				japanManifestListVesselArrivalDetailVOs = dbDao.searchVesselArrival(japanVesselArrivalTransmitVO
						.getInVvdCd(), japanVesselArrivalTransmitVO.getInPodCd(), japanVesselArrivalTransmitVO
						.getInPodCdSplit(), etaDt.replace("-", ""));
				if (japanManifestListVesselArrivalDetailVOs.size() != 0) {
					JapanManifestListVesselArrivalDetailVO japanManifestListVesselArrivalDetailVO = japanManifestListVesselArrivalDetailVOs
							.get(0);
					realFlatFile2.append(japanManifestListVesselArrivalDetailVO.getCallSignNo()).append("\r\n");
					realFlatFile2.append(japanManifestListVesselArrivalDetailVO.getPodCd()).append("\r\n");
					realFlatFile2.append(japanManifestListVesselArrivalDetailVO.getPodSplit()).append("\r\n");
					realFlatFile2.append(japanManifestListVesselArrivalDetailVO.getData1()).append("\r\n");
					realFlatFile2.append(japanManifestListVesselArrivalDetailVO.getData2()).append("\r\n");
					realFlatFile2.append(japanManifestListVesselArrivalDetailVO.getEtaDt()).append("\r\n");
					realFlatFile2.append(japanManifestListVesselArrivalDetailVO.getCstmsMfCd()).append("\r\n");
					realFlatFile2.append(japanManifestListVesselArrivalDetailVO.getMfRmk()).append("\r\n");
				}
				BookingUtil command = new BookingUtil();
				String sndDt = command.searchLocalTime(account.getCnt_cd()+account.getOfc_cd().substring(0,3));//japanManifestListSendHeaderInfoForDmfVOs.get(0).getHeader().substring(41, 55);
				japanManifestListSendHeaderInfoForDmfVOs = dbDao.searchSendHeaderForDmf(japanVesselArrivalTransmitVO
						.getInVvdCd(), japanVesselArrivalTransmitVO.getInPodCd(), account.getOfc_cd(), account
						.getUsr_id(), realFlatFile2.toString(), sndDt);

				realFlatFile.append(japanManifestListSendHeaderInfoForDmfVOs.get(0).getHeader()).append("\n");
				realFlatFile.append(japanManifestListSendHeaderInfoForDmfVOs.get(0).getHeader2()).append("\r\n");
				realFlatFile.append(realFlatFile2.toString());

				SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
				sendFlatFileVO.setFlatFile(realFlatFile.toString());
				sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_NACCS.IBMMQ.QUEUE"));

				
				FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);

				if (flatFileAckVO.getAckStsCd().equals("E"))
					throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());

				
				BkgCstmsJpSndLogVO bkgCstmsJpSndLogVO = new BkgCstmsJpSndLogVO();
				bkgCstmsJpSndLogVO.setJpSndLogId("DMF");
				bkgCstmsJpSndLogVO.setSndDt(sndDt); 
				bkgCstmsJpSndLogVO.setOfcCd(account.getOfc_cd());
				bkgCstmsJpSndLogVO.setVslCd(japanVesselArrivalTransmitVO.getInVvdCd().substring(0, 4));
				bkgCstmsJpSndLogVO.setSkdVoyNo(japanVesselArrivalTransmitVO.getInVvdCd().substring(4, 8));
				bkgCstmsJpSndLogVO.setSkdDirCd(japanVesselArrivalTransmitVO.getInVvdCd().substring(8));
				bkgCstmsJpSndLogVO.setPodCd(japanVesselArrivalTransmitVO.getInPodCd());
				bkgCstmsJpSndLogVO.setLogFlg("N");
				// bkgCstmsJpSndLogVO.setBlNo("");
				// bkgCstmsJpSndLogVO.setBlNoTp(japanManifestTransmitVO.getBlNumber().substring(10,11));
				// bkgCstmsJpSndLogVO.setBlNoChk(japanManifestTransmitVO.getBlNumber().substring(11,12));
				bkgCstmsJpSndLogVO.setCreUsrId(account.getUsr_id());
				bkgCstmsJpSndLogVO.setLogSeq("1");

				dbDao.addSendLog(bkgCstmsJpSndLogVO);

				ArrayList tmpArray = new ArrayList();
				StringTokenizer token = new StringTokenizer(realFlatFile.toString().replace("\r\n","\n"), "\n");
				int i = 0;
				BkgCstmsJpSndLogDtlVO bkgCstmsJpSndLogDtlVO = new BkgCstmsJpSndLogDtlVO();
				bkgCstmsJpSndLogDtlVO.setJpSndLogId("DMF");
				bkgCstmsJpSndLogDtlVO.setMsgSndDt(sndDt);
				bkgCstmsJpSndLogDtlVO.setOfcCd(account.getOfc_cd());
				bkgCstmsJpSndLogDtlVO.setLogSeq("1");
				bkgCstmsJpSndLogDtlVO.setCreUsrId(account.getUsr_id());
				while (token.hasMoreTokens()) {
					tmpArray.add(token.nextToken());
					if (i > 1) {
						bkgCstmsJpSndLogDtlVO.setSubSeq(i - 1 + "");
						bkgCstmsJpSndLogDtlVO.setEdiSndMsg(tmpArray.get(i++).toString().replace("'", "''"));

						dbDao.addSendLogDetail(bkgCstmsJpSndLogDtlVO);
					} else {
						i++;
					}
				}
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
		return realFlatFile.toString();
	}

	/**
	 * 전송 이벤트 처리<br>
	 * 일본세관 수신 처리.<br>
	 * 
	 * @param String flatFile
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void receiveUbizhjsAlpsbkgNaccs(String flatFile, SignOnUserAccount account) throws EventException {

		BkgCstmsJpRcvLogVO bkgCstmsJpRcvLogVO = new BkgCstmsJpRcvLogVO();
		BkgCstmsJpRcvLogDtlVO bkgCstmsJpRcvLogDtlVO = new BkgCstmsJpRcvLogDtlVO();
		try {
			String[] tmpArray = flatFile.split("\n");

			String msgTpCd = tmpArray[0].substring(3, 8).trim();
			//2012.04.27 김종옥 [CHM-201217431] JP_MSG_TP_ID이 'BKC', 'BKR' 아닐때만 저장 - SEA-NACCS 관련 때문
			if (msgTpCd.indexOf("BKR") > -1 || msgTpCd.indexOf("BKC") > -1) return;

			// 2013.12.04 김상수 [CHM-201326941] 아래에 해당하는 MSG가 아닐때만 저장 - JP24HR관련
			String filterMsgDiv = tmpArray[0].substring(8, 15).trim();
			if (filterMsgDiv.indexOf("SAS108") > -1
			 || filterMsgDiv.indexOf("SAS111") > -1
			 || filterMsgDiv.indexOf("SAS112") > -1
			 || filterMsgDiv.indexOf("*SAMR") > -1
			 || filterMsgDiv.indexOf("*SCMR") > -1
			 || filterMsgDiv.indexOf("*SATD") > -1) {

				return;
			}

			String rcvDt = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			int k = 0;
			int seqNumber = 0;

			bkgCstmsJpRcvLogVO.setJpMsgTpCd(msgTpCd);
			bkgCstmsJpRcvLogVO.setRcvDt(rcvDt);
			bkgCstmsJpRcvLogVO.setJpSvcCd(tmpArray[0].substring(8, 15).trim());
			bkgCstmsJpRcvLogVO.setRcvKeyDatCtnt(tmpArray[0].substring(115, 160));
			bkgCstmsJpRcvLogVO.setJpBatNo(tmpArray[0].substring(209, 219).trim());

			String creUserId = tmpArray[0].substring(253, 263).trim();
			if (creUserId == null || "".equals(creUserId)) creUserId = "NACCS";

			bkgCstmsJpRcvLogVO.setCreUsrId(creUserId);
			seqNumber = dbDao.searchReceiveLogSeq(bkgCstmsJpRcvLogVO.getJpMsgTpCd(), rcvDt);
			bkgCstmsJpRcvLogVO.setRcvSeq(seqNumber + "");
			dbDao.addReceiveLog(bkgCstmsJpRcvLogVO);

			for (int j=1; j<tmpArray.length; j++) {
				if (!tmpArray[j].toString().equals("###")) {
					bkgCstmsJpRcvLogDtlVO.setJpMsgTpCd(msgTpCd);
					bkgCstmsJpRcvLogDtlVO.setRcvDt(rcvDt);
					bkgCstmsJpRcvLogDtlVO.setRcvSeq(seqNumber + "");
					bkgCstmsJpRcvLogDtlVO.setRcvDtlSeq(++k + "");
					if(msgTpCd.equals("ACL01") && j == 80 ){
						bkgCstmsJpRcvLogDtlVO.setEdiRcvMsg(tmpArray[j]);
					}else{
						bkgCstmsJpRcvLogDtlVO.setEdiRcvMsg(tmpArray[j].trim());
					}
					bkgCstmsJpRcvLogDtlVO.setCreUsrId(creUserId);
					dbDao.addReceiveLogDetail(bkgCstmsJpRcvLogDtlVO);
				}
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 일본세관 수신 EDI 수신으로 받은 문자열을 Parsing 하여 msg_tp값에 따라서 서로 다른 DAO 메소드를 호출한다.
	 * 
	 * @param String rcvMsg
	 * @throws EventException
	 * @author Son Yun Seuk
	 */
	public void loadCstmsRcvMsg(String rcvMsg) throws EventException {
		// String tp_id = "";
		String vslCd = "";
		// String pod_cd = "";
		String ofcCd = "";
		String updUsrId = "";
		String updDt = "";
		String msgTp = "";
		String logSeq = "";

		if (rcvMsg.length() > 15)
			vslCd = rcvMsg.substring(6, 15);
		else if (rcvMsg.length() > 6)
			vslCd = rcvMsg.substring(6);
		if (rcvMsg.length() > 26)
			ofcCd = rcvMsg.substring(20, 26);
		else if (rcvMsg.length() > 20)
			ofcCd = rcvMsg.substring(20);
		if (rcvMsg.length() > 36)
			updUsrId = rcvMsg.substring(26, 36);
		else if (rcvMsg.length() > 26)
			updUsrId = rcvMsg.substring(26);
		if (rcvMsg.length() > 55)
			updDt = rcvMsg.substring(41, 55);
		else if (rcvMsg.length() > 41)
			updDt = rcvMsg.substring(41);
		if (rcvMsg.length() > 60)
			msgTp = rcvMsg.substring(55, 60);
		else if (rcvMsg.length() > 55)
			msgTp = rcvMsg.substring(55);
		if (rcvMsg.length() > 80)
			logSeq = rcvMsg.substring(77, 80).trim();
		else if (rcvMsg.length() > 77)
			logSeq = rcvMsg.substring(77).trim();

		try {
			if (msgTp.length() >= 3) {
				String msgtype = msgTp.substring(0, 3);
				if ("VCA".equals(msgtype) || "DOR".equals(msgtype) || "ICN".equals(msgtype)) {
					dbDao.modifySysAckSts(msgTp, updDt, ofcCd, updUsrId);
				} else if (!"DOR".equals(msgtype) && logSeq.length() > 0) {
					dbDao.modifySysAckStsForSeq(msgTp, logSeq, updDt, ofcCd, updUsrId, vslCd);
				} else if ("AMR".equals(msgTp) || "CMR".equals(msgTp)) {
					new com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.jp24.integration.Jp24ManifestListDownloadDBDAO().modifySysAckStsForJP24EDI(msgTp, rcvMsg.substring(36, 55));
				} else {
					dbDao.modifySysAckStsForVDI(msgTp, updDt, ofcCd, updUsrId, vslCd);
				}
			} else if (msgTp.length() > 60) {
				dbDao.modifySysAckStsForVDI(msgTp, updDt, ofcCd, updUsrId, vslCd);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}

	}
	
	/**
	 * 일본세관 Manifest 수신 로그를 수정한다.<br>
	 * 
	 * @param ReceiveLogVO recieveLogVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyReceiveLog(ReceiveLogVO recieveLogVO, SignOnUserAccount account) throws EventException {
		JapanReceiveLogVO japanReceiveLogVO = (JapanReceiveLogVO) recieveLogVO;
		int rcvLogCount = 0;
		try {
			rcvLogCount = dbDao2.searchRcvLogCnt();

			if (rcvLogCount > 0) {
				japanReceiveLogVO.setUpdUsrId(account.getUsr_id());
				dbDao.modifyReceiveLog(japanReceiveLogVO);
			}

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * BackEndJob을 실행.
	 * 
	 * @param SignOnUserAccount account
	 * @param ManifestTransmitVO detailVO
	 * @param String pgmNo
	 * @return String BackEndJob Key
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, ManifestTransmitVO detailVO, String pgmNo)
			throws EventException {
		JapanCustomsTransmissionBackEndJob backEndJob = new JapanCustomsTransmissionBackEndJob();
		backEndJob.setPgmNo(pgmNo);
		String resultStr = "";
		try {
			if (pgmNo.equals("ESM_BKG_0730") || pgmNo.equals("ESM_BKG_0730_Renewal2017")) {
				backEndJob.setManifestTransmitVO(detailVO);
				backEndJob.setSignOnUserAccount(account);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				resultStr = backEndJobManager.execute(backEndJob, account.getUsr_id(), "NACCS Transmit.");
			}

		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}

		return resultStr;
	}	

}
