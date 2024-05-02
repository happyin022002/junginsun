/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MexCustomsTransmissionBCImpl.java
*@FileTitle : MexCustomsTransmissionBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.14
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.09.14 김도완
* 1.0 Creation
=========================================================
* 2011.06.01 김진승 [미정] transmitManifest 메소드 로직 보완 (null 체크)
* 2013.02.26 김보배 [CHM-201323167] [BKG] Mexico customs 전송 변경 - commodity description
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.basic;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.integration.MexCustomsTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxBkgVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxChargeTotalVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxChgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxCmDetailInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxCommodityVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxCustomerVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxDgInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxEtaInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxManifestListByVvdCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxManifestListByVvdDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxMndDescInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxQtyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxUsaCustomsVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxUsaLocVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo.MxVslResultVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.mexico.vo.VslCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CargoManifestCondForEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CargoManifestListResultForEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.TsVvdFor1st2ndInputVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;

/**
 * ALPS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - ALPS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Kim, Do-Wan
 * @see ESM_BKG_0370EventResponse,MexCustomsTransmissionBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class MexCustomsTransmissionBCImpl extends CustomsTransmissionBCImpl {

	// Database Access Object
	private transient MexCustomsTransmissionDBDAO dbDao = null;

	/**
	 * MexCustomsTransmissionBCImpl 객체 생성<br>
	 * MexCustomsTransmissionDBDAO 생성한다.<br>
	 */
	public MexCustomsTransmissionBCImpl() {
		dbDao = new MexCustomsTransmissionDBDAO();
	}
	

	/**
	 * 멕시코 세관 Manifest 전송을 위해 조회한다.
	 * 
	 * @param CargoManifestCondForEdiVO cond
	 * @return CargoManifestListResultForEdiVO
	 * @throws EventException
	 */
	public CargoManifestListResultForEdiVO searchCargoManifestForEdi(CargoManifestCondForEdiVO cond) throws EventException{
		CargoManifestListResultForEdiVO rtnVo = new CargoManifestListResultForEdiVO();
		VslCondVO condvo = (VslCondVO)cond;
		try {
			if(condvo != null){
				MxManifestListByVvdCondVO condvo2 = new MxManifestListByVvdCondVO();
				condvo2.setVvd(condvo.getVvd());
				condvo2.setPodCd(condvo.getPodCd());
				condvo2.setPolCd(condvo.getPolCd());
				condvo2.setSearchFlg(condvo.getSearchFlg());
				condvo2.setSearchCargo(condvo.getSearchCargo());				
				MxVslResultVO vo1 = null;
				String etd = "";
				//POL조건이 있는 경우, pod 는 널로 하고 우선 조회하여, ETD 값을 얻는다.
				if(condvo.getPolCd() != null && ! condvo.getPolCd().equals("") && condvo.getPodCd() != null && ! condvo.getPodCd().equals("")){
					condvo.setPodCd("");
					vo1 = dbDao.searchVslEta(condvo);
					if(vo1 != null){
						etd = vo1.getEtaDt();
					}
					// 조회완료후, pod 를 다시 설정한다.
					condvo.setPodCd(condvo2.getPodCd());
				}
				vo1 = dbDao.searchVslEta(condvo);
				if(etd != null && ! etd.equals("") && vo1 != null){
					vo1.setEtdDt(etd);
				}
				
				/*if(vo1 == null){
					throw new EventException(new ErrorHandler("BKG00095",new String[]{}).getMessage());
				}*/
				List <MxManifestListByVvdDetailVO> vo2 = dbDao.searchManifestByVvdPort(condvo2);
				rtnVo.setMxVslResultVO(vo1);
				rtnVo.setMxManifestListByVvdDetailVOs(vo2);
			}
		
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450",new String[]{}).getMessage(), ex);
		}
		return rtnVo;
	}
	

	/**
	 * 멕시코 세관신고 위해 FlatFile을 전송한다.
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException {
		
		BookingUtil bookingUtilBC = null;
		StringBuffer buff = new StringBuffer();
		
		// send log 저장 VO
		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
		BkgNtcHisVO bkgNtcHisVO = null;
		String localSendTime = "";
		String ioInd = "";

		try {
			if(manifestTransmitVOs == null){
				throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
			}
			MxManifestListByVvdDetailVO vo = (MxManifestListByVvdDetailVO) manifestTransmitVOs[0];
			MxTransmitVO cond1 = new MxTransmitVO();
			String vvd = vo.getVvd();
			String podCd = vo.getCpod(); // 조회조건으로 입력된 POD
			String polCd = vo.getCpol(); // 조회조건으로 입력된 POL
			String searchFlg = vo.getSearchFlg(); // 조회조건으로 입력된 SEARCH_FLG
			cond1.setVvd(vvd);
			cond1.setPolCd(polCd);
			cond1.setPodCd(podCd);
			bookingUtilBC = new BookingUtil();
			String header = bookingUtilBC.searchCstmsEdiHeader("SMLINE", "MEXCUS", "COPRAR");
			buff.append(header).append("\n");
			
			// PORT_SKD에서 Vsl 정보를 찾고 없다면, Vsl 에서 찾는다.
			MxEtaInfoVO mxEtaInfoVO = dbDao.searchVslEtaInfo(cond1);
			if(mxEtaInfoVO == null || mxEtaInfoVO.getPort() == null || mxEtaInfoVO.getPort().length() == 0){ // 2011.06.01
				mxEtaInfoVO = dbDao.searchVslInfoVsl(cond1);
			}
			// Vsl정보가 없을 경우 오류를 발생시킨다.
			if(mxEtaInfoVO == null || mxEtaInfoVO.getPort() == null || mxEtaInfoVO.getPort().length() == 0){ // 2011.06.01
				//Msg : Vessel Info. Data Not Found
				throw new EventException(new ErrorHandler("BKG01052",new String[]{}).getMessage());
			}
			
			/* 
			 * 2010-03-16
			 * IO_IND 판단
			 * searchFlg "O" -> IO_IND : O
			 * searchFlg "I" -> IO_IND : I
			 * searchFlg "T" -> POL이 "MX"시작하면 IO_IND : TO,  POL이 ""이고 POD가 "MX"로 시작하면 IO_IND : TC,
			 */
			if("O".equals(searchFlg) || "I".equals(searchFlg)) {
				ioInd = searchFlg;
			} else if("T".equals(searchFlg)) {

				if(polCd.startsWith("MX")) {
					ioInd = "TO";
				} else {
					if(podCd.startsWith("MX")) {
						ioInd = "TC";
					}
				}
			}
			
			
			buff.append("BRAC:")			.append(mxEtaInfoVO.getBrac())				.append("\n")
				.append("VVD:")				.append(mxEtaInfoVO.getVvd())				.append("\n")
				.append("VSL_CALLSIGN:")	.append(mxEtaInfoVO.getVslCallsign())		.append("\n")
				.append("VSL_LLOYDCODE:")	.append(mxEtaInfoVO.getVslLloydcode())		.append("\n")
				.append("VSL_FULLNAME:")	.append(mxEtaInfoVO.getVslFullname())		.append("\n")
				.append("VSL_FLAG:")		.append(mxEtaInfoVO.getVslFlag())			.append("\n")
				.append("LANE_CD:")			.append(mxEtaInfoVO.getLaneCd())			.append("\n")
				.append("VVD_REF_NO:")		.append(mxEtaInfoVO.getVvdRefNo())			.append("\n")
				.append("VPOL:")			.append(vo.getCpol())						.append("\n")
				.append("VPOD:")			.append(vo.getCpod())						.append("\n")
				.append("PORT:")			.append(mxEtaInfoVO.getPort())				.append("\n")
				.append("PORTNAME:")		.append(mxEtaInfoVO.getPortname())			.append("\n")
				.append("ETA:")				.append(mxEtaInfoVO.getEta())				.append("\n")
				.append("ETD:")				.append(mxEtaInfoVO.getEtd())				.append("\n")
				.append("NEXTPORT:")		.append(mxEtaInfoVO.getNextport())			.append("\n")
				.append("NEXTPORT_ETA:")	.append(mxEtaInfoVO.getNextportEta())		.append("\n")
				.append("PREVPORT:")		.append(mxEtaInfoVO.getPrevport())			.append("\n")
				.append("PREVPORT_ETD:")	.append(mxEtaInfoVO.getPrevportEtd())		.append("\n")
				.append("IO_IND:")			.append(ioInd)								.append("\n")
				.append("COMP_ID:")			.append(mxEtaInfoVO.getCompId())			.append("\n")
				.append("MRN:")				.append(mxEtaInfoVO.getMrn())				.append("\n")
				.append("MRN_NAME:")		.append(mxEtaInfoVO.getMrnName())			.append("\n");
			
			//시트에서 넘어온 데이터 수만큼 루프를 돌며 작업을 진행한다.
			MxCommodityVO mxCommodityVO = null;
			MxUsaLocVO mxUsaLocVO = null;
			String sgc4 = "";
			String sgc5 = "";
			
			String transMode = "";
			String itItno = "";
			StringBuffer tmp  = new StringBuffer();
			String blNo = "";
			String inBkgCgoTpCd = "";
			String inDcgoFlg = ""; 
			String inRcFlg = ""; 
			String inAwkCgoFlg = ""; 
			String inBbCgoFlg = "";
			String inRdCgoFlg = ""; 
			String cmdtCd = ""; 
			String cmdtNm = ""; 
			MxBlInfoVO bvo = null;
			MxCustomerVO cvo = null;
			List<MxChgVO> mxChgVO= null;
			List<MxChargeTotalVO> mxChargeTotalVO = null;
			List<MxCntrVO> mxCntrVOs = null;
			MxCntrVO mxCntrVO = null;
			List<MxDgInfoVO> mxDgInfoVO = null;
			List<MxCmDetailInfoVO> mxCmDetailInfoVO = null;
			List<MxQtyVO> mxQtyVO = null;
			List<MxBkgVvdVO> mxBkgVvdVO = null;
			
			// local send time 구하기
			bookingUtilBC = new BookingUtil();
			localSendTime = bookingUtilBC.searchTimeLocalOfcFnc(account.getOfc_cd());
			localSendTime = localSendTime.replaceAll("-", "");
			localSendTime = localSendTime.replaceAll(":", "");
			
			for(int i = 0; i < manifestTransmitVOs.length; i++){


				
				//log.info("#######################################################");
				//log.info("#######################  "+(i+1)+"  ###########################");
				//log.info("#######################################################");
				vo = (MxManifestListByVvdDetailVO) manifestTransmitVOs[i];
				cond1.setBkgNo(vo.getBkgNo());
				cond1.setBlNo(vo.getOBlNo());
				
				//sgc2, sgc3 조회.
				mxCommodityVO = dbDao.searchCommodity(cond1);
				/************************************************************************************************/
				/* 2002.5.6 SGC LOCAL_IPI: Y/L/I(1) + UNLOCODE(5) + D/K(1) + AMSCODE(4 or 5) + Fullname			*/
				/* 2002.5.8 SGC HUB from INBOND_TRANS															*/
				/************************************************************************************************/
				mxUsaLocVO = dbDao.searchUsaLocInfo(cond1);
				sgc4 = "";
				if(mxUsaLocVO != null){
					sgc4 = new StringBuffer()	.append(mxUsaLocVO.getLocalIpi())
												.append(mxUsaLocVO.getLocCd())
												.append(mxUsaLocVO.getDkn())
												.append(mxUsaLocVO.getLocAmsPortCd())
												.append(mxUsaLocVO.getLocNm())
												.toString();
				}
				
				
				sgc5 = "N";
				// EDI 전송횟수를 조회.
				if(Integer.parseInt(dbDao.searchEdiSendFlag(cond1)) > 0){
					sgc5 = "U";
				}
				
				transMode = " ";
				
				// bkg_no, vvd가 Trunk 유형인 경우, 
				// 해당 BKG번호에 대해 U인 항로가 있으면 Feeder로 간주.
				if((dbDao.searchVvdMode(cond1).getVslPrePstCd()).equals("T")){
					if(dbDao.validatePostVvd(cond1) > 0){
						transMode  = "F";
					}
				}
				
				itItno = "";
				// IT_ITNO를 조회한다.
				MxUsaCustomsVO mxUsaCustomsVO = dbDao.searchUsaCustoms(cond1);
				if(mxUsaCustomsVO != null){
					itItno = mxUsaCustomsVO.getIbdTrspNo();
				}
				
				// BL 정보를 조회한다.
				// BL_INFO for Flat File	
				bvo = dbDao.searchBl(cond1);
				blNo = "";
				inBkgCgoTpCd = "";
				inDcgoFlg = ""; 
				inRcFlg = ""; 
				inAwkCgoFlg = ""; 
				inBbCgoFlg = "";
				inRdCgoFlg = ""; 
				cmdtCd = ""; 
				cmdtNm = "";
				tmp = new StringBuffer();
				if(bvo != null){
					tmp		.append("{BL_INFO")		.append("\n")
							.append("BLNBR:")		.append(bvo.getBlnbr())			.append("\n")
							.append("BLPOL:")		.append(bvo.getBlpol())			.append("\n")
							.append("POL_AMS:")		.append(bvo.getPolAms())		.append("\n")
							.append("POL_FULLNAME:").append(bvo.getPolFullname())	.append("\n")
							.append("BLPOD:")		.append(bvo.getBlpod())			.append("\n")
							.append("POD_AMS:")		.append(bvo.getPodAms())		.append("\n")
							.append("POD_FULLNAME:").append(bvo.getPodFullname())	.append("\n")
							.append("BLPOR:")		.append(bvo.getBlpor())			.append("\n")
							.append("POR_AMS:")		.append(bvo.getPorAms())		.append("\n")
							.append("POR_FULLNAME:").append(bvo.getPorFullname())	.append("\n")
							.append("BLDEL:")		.append(bvo.getBldel())			.append("\n")
							.append("DEL_AMS:")		.append(bvo.getDelAms())		.append("\n")
							.append("DEL_FULLNAME:").append(bvo.getDelFullname())	.append("\n")
							.append("BLRLY:")		.append(bvo.getBlrly())			.append("\n")
							.append("RLY_AMS:")		.append(bvo.getRlyAms())		.append("\n")
							.append("RLY_FULLNAME:").append(bvo.getRlyFullname())	.append("\n")
							.append("BLPLACE:")		.append(bvo.getBlplace())		.append("\n")
							.append("BLDATE:")		.append(bvo.getBldate())		.append("\n")
							.append("SHPRCN:")		.append(bvo.getShprcn())		.append("\n")
							.append("SHPRCD:")		.append(bvo.getShprcd())		.append("\n")
							.append("SHPR1:")		.append(bvo.getShpr1())			.append("\n")
							.append("SHPR2:")		.append(bvo.getShpr2())			.append("\n")
							.append("SHPR3:")		.append(bvo.getShpr3())			.append("\n")
							.append("SHPR4:")		.append(bvo.getShpr4())			.append("\n")
							.append("SHPR5:")		.append(bvo.getShpr5())			.append("\n")
							.append("SHPRTAXID:")	.append(bvo.getShprtaxid())		.append("\n")
							.append("CNEECN:")		.append(bvo.getCneecn())		.append("\n")
							.append("CNEECD:")		.append(bvo.getCneecd())		.append("\n")
							.append("CNEE1:")		.append(bvo.getCnee1())			.append("\n")
							.append("CNEE2:")		.append(bvo.getCnee2())			.append("\n")
							.append("CNEE3:")		.append(bvo.getCnee3())			.append("\n")
							.append("CNEE4:")		.append(bvo.getCnee4())			.append("\n")
							.append("CNEE5:")		.append(bvo.getCnee5())			.append("\n")
							.append("CNEETAXID:")	.append(bvo.getCneetaxid())		.append("\n");
					blNo = bvo.getBlNo();
					inBkgCgoTpCd = bvo.getInBkgCgoTpCd();
					inDcgoFlg = bvo.getInDcgoFlg();
					inRcFlg = bvo.getInRcFlg();
					inAwkCgoFlg = bvo.getInAwkCgoFlg();
					inBbCgoFlg = bvo.getInBbCgoFlg();
					inRdCgoFlg = bvo.getInRdCgoFlg();
					cmdtCd = bvo.getCmdtCd();
					cmdtNm = bvo.getCmdtNm();
					
					buff.append(tmp.toString());
					
					
					cond1.setBlNo(blNo);
					
				}else{
					// Msg : Booking($s) Not Found!
					throw new EventException(new ErrorHandler("BKG01049",new String[]{cond1.getBkgNo()}).getMessage());
				}
				//Customer Info. 및 BL Info. for Flat File	
				cvo = dbDao.searchCustomer(cond1);
				if(cvo != null){
					tmp = new StringBuffer();
					tmp		.append("NTFYCN:")		.append(cvo.getNtfycn())			.append("\n")
							.append("NTFYCD:")		.append(cvo.getNtfycd())			.append("\n")
							.append("NTFY1:")		.append(cvo.getNtfy1())				.append("\n")
							.append("NTFY2:")		.append(cvo.getNtfy2())				.append("\n")
							.append("NTFY3:")		.append(cvo.getNtfy3())				.append("\n")
							.append("NTFY4:")		.append(cvo.getNtfy4())				.append("\n")
							.append("NTFY5:")		.append(cvo.getNtfy5())				.append("\n")
							.append("NTFYTAXID:")	.append(cvo.getNtfytaxid())			.append("\n")
							.append("NTFY2CN:")		.append(cvo.getNtfy2cn())			.append("\n")
							.append("NTFY2CD:")		.append(cvo.getNtfy2nm())			.append("\n")
							.append("NTFY21:")		.append(cvo.getNtfy21())			.append("\n")
							.append("NTFY22:")		.append(cvo.getNtfy22())			.append("\n")
							.append("NTFY23:")		.append(cvo.getNtfy23())			.append("\n")
							.append("NTFY24:")		.append(cvo.getNtfy24())			.append("\n")
							.append("NTFY25:")		.append(cvo.getNtfy25())			.append("\n")
							.append("FFWDCN:")		.append(cvo.getFfwdcn())			.append("\n")
							.append("FFWDCD:")		.append(cvo.getFfwdcd())			.append("\n")
							.append("FFWD1:")		.append(cvo.getFfwd1())				.append("\n")
							.append("FFWD2:")		.append(cvo.getFfwd2())				.append("\n")
							.append("FFWD3:")		.append(cvo.getFfwd3())				.append("\n")
							.append("FFWD4:")		.append(cvo.getFfwd4())				.append("\n")
							.append("FFWD5:")		.append(cvo.getFfwd5())				.append("\n")
							.append("EXPOCN:")		.append(cvo.getExpocn())			.append("\n")
							.append("EXPOCD:")		.append(cvo.getExpocd())			.append("\n")
							.append("EXPO1:")		.append(cvo.getExpo1())				.append("\n")
							.append("EXPO2:")		.append(cvo.getExpo2())				.append("\n")
							.append("EXPO3:")		.append(cvo.getExpo3())				.append("\n")
							.append("EXPO4:")		.append(cvo.getExpo4())				.append("\n")
							.append("EXPO5:")		.append(cvo.getExpo5())				.append("\n")
							.append("BLCOPY:")		.append(cvo.getBlcopy())			.append("\n")
							.append("BLORG:")		.append("1")						.append("\n")
							.append("BLPKG:")		.append(cvo.getBlpkg())				.append("\n")
							.append("BLPKGU:")		.append(cvo.getBlpkgu())			.append("\n")
							.append("BLWGT:")		.append(cvo.getBlwgt())				.append("\n")
							.append("BL_WGT_UNIT:")	.append(cvo.getBlWgtUnit())			.append("\n")
							.append("BLMEA:")		.append(cvo.getBlmea())				.append("\n")
							.append("BL_MEA_UNIT:")	.append(cvo.getBlMeaUnit())			.append("\n")
							.append("RDTYPE:")		.append(cvo.getRdtype())			.append("\n")
							.append("CARGOTYPE:")	.append(cvo.getCargotype())			.append("\n")
//							.append("COMMODITY:")	.append(cvo.getCommodity())			.append("\n")
							.append("COMMODITY:")	.append("")							.append("\n")
//							.append("BLCMD:")		.append(mxCommodityVO.getSgc2())	.append("\n")
							.append("BLCMD:")		.append(cmdtNm)						.append("\n")
							.append("BLREPCMDCD:")	.append(cvo.getBlrepcmdcd())		.append("\n")
							.append("BLREPCMD:")	.append(mxCommodityVO.getSgc3())	.append("\n")
							.append("REMARK:")		.append(cvo.getRemark())			.append("\n")
							.append("AUS_QUAR:")	.append(cvo.getAusQuar())			.append("\n")
							.append("SRNBR:")		.append("")							.append("\n")
							.append("BKGNBR:")		.append(cond1.getBkgNo())			.append("\n")
							.append("RGN_BKGNBR:")	.append(cvo.getRgnBkgnbr())			.append("\n")
							.append("PPDOFC:")		.append(cvo.getPpdofc())			.append("\n")
							.append("CCTOFC:")		.append(cvo.getCctofc())			.append("\n")
							.append("THDOFC:")		.append(cvo.getThdofc())			.append("\n")
							.append("SCNO:")		.append(cvo.getScno())				.append("\n")
							.append("RFANO:")		.append(cvo.getRfano())				.append("\n")
							.append("WAYBILL_IND:")	.append("")							.append("\n")
							.append("CUSTREF_NUM:")	.append(sgc5)						.append("\n")
							.append("FINAL_ETA:")	.append("")							.append("\n")
							.append("FUNC_CODE:")	.append("")							.append("\n")
							.append("ONBOARD:")		.append("")							.append("\n")
							.append("INV_NO:")		.append(itItno)						.append("\n")
							.append("BLTS:")		.append("")							.append("\n")
							.append("BLTP:")		.append("")							.append("\n")
							.append("MSN:")			.append("")							.append("\n")
							.append("MSNCFM:")		.append("")							.append("\n")
							.append("CMDESC:")		.append("")							.append("\n")
							.append("LOCAL_IPI:")	.append(sgc4)						.append("\n")
							.append("EQREL:")		.append(cvo.getEqrel())				.append("\n")
							.append("EQPICKDT:")	.append(cvo.getEqpickdt())			.append("\n")
							.append("EQRTN:")		.append(cvo.getEqrtn())				.append("\n")
							.append("TRANS_MODE:")	.append(transMode)					.append("\n")
							.append("UD_CD:")		.append(cvo.getUdCd())				.append("\n");
					

					buff.append(tmp.toString());
					
					
				}else{
					// Msg : Booking($s) Not Found!
					throw new EventException(new ErrorHandler("BKG01049",new String[]{cond1.getBkgNo()}).getMessage());
				}
				
				//Charge Info. for Flat File	
				mxChgVO = dbDao.searchChargeInfo(cond1);
				if(mxChgVO != null){
					for(int j = 0; j < mxChgVO.size() ; j++){
						tmp = new StringBuffer();
						tmp		.append("{CHARGE")		.append("\n")
								.append("FCTYPE:")		.append(mxChgVO.get(j).getFctype())			.append("\n")
								.append("RATE:")		.append(mxChgVO.get(j).getRate())			.append("\n")
								.append("REVENUETON:")	.append(mxChgVO.get(j).getRevenueton())		.append("\n")
								.append("PPD:")			.append(mxChgVO.get(j).getPpd())			.append("\n")
								.append("CCT:")			.append(mxChgVO.get(j).getCct())			.append("\n")
								.append("CURRENCYCODE:").append(mxChgVO.get(j).getCurrencycode())	.append("\n")
								.append("EXCHRATE:")	.append("")									.append("\n")
								.append("TARIFF:")		.append(mxChgVO.get(j).getTariff())			.append("\n")
								.append("PERTYPE:")		.append(mxChgVO.get(j).getPertype())		.append("\n")
								.append("RATEOFC:")		.append(mxChgVO.get(j).getRateofc())		.append("\n")
								.append("}CHARGE")		.append("\n")
								;
						
						buff.append(tmp.toString());
						
					}
					
					//Total Charge Info. for Flat File	
					mxChargeTotalVO = dbDao.searchChargeTotal(cond1);
					if(mxChargeTotalVO != null){
						for(int j = 0; j < mxChargeTotalVO.size() ; j++){
							tmp = new StringBuffer();
							tmp		.append("{CHARGE_TTL")	.append("\n")
									.append("PPD_TOTAL:")	.append(mxChargeTotalVO.get(j).getPpdTotal())	.append("\n")
									.append("CCT_TOTAL:")	.append(mxChargeTotalVO.get(j).getCctTotal())	.append("\n")
									.append("TOTAL_CUR:")	.append(mxChargeTotalVO.get(j).getTotalCur())	.append("\n")
									.append("}CHARGE_TTL")	.append("\n")
									;
							
							buff.append(tmp.toString());
							
						}
					}
				}//Charge Info. for Flat File
				
				//BKG의 Mark / Desc 정보를 조회한다.
				MxMndDescInfoVO mxMndDescInfoVO = dbDao.searchMarkDescInfo(cond1);
				//DESC(50자리), MARK(25자리)로 잘라서 multi line 생성		
				if(mxMndDescInfoVO != null) {
					String cmdtDesc = mxMndDescInfoVO.getCmdtDesc();
					String[] str1 = cmdtDesc.split("\n");
					String mkMark = mxMndDescInfoVO.getMkMark();
					String[] str2 = mkMark.split("\n");
					
					tmp = new StringBuffer();
					tmp.append("{DESC")				.append("\n");
					for(int idx=0; idx < str1.length; idx++) {
						while(str1[idx].length() > 50 ){
							tmp.append("DESC:").append(str1[idx].substring(0, 50)).append("\n");
							str1[idx] = str1[idx].substring(50);
						}
						tmp.append("DESC:")          	.append(str1[idx]).append("\n");
					}
					tmp.append("}DESC")				.append("\n");
					
					buff.append(tmp.toString());
					
					
					tmp = new StringBuffer();
					tmp.append("{MARK")				.append("\n");
					for(int idx=0; idx < str2.length; idx++) {
						while(str2[idx].length() > 25 ){
							tmp.append("MARKNO:").append(str2[idx].substring(0, 25)).append("\n");
							str2[idx] = str2[idx].substring(25);
						}
						tmp.append("MARKNO:")          	.append(str2[idx]).append("\n");
					}
					tmp.append("}MARK")				.append("\n");
					
					buff.append(tmp.toString());
					
				}//BKG의 Mark / Desc
				
				//Container info.
				mxCntrVOs = dbDao.searchContainerInfo(cond1);
				if(mxCntrVOs != null){
					if( ! "F".equals(inBkgCgoTpCd)){
						inBkgCgoTpCd = "M";
					}
					if( "1".equals(inRcFlg))
						inRcFlg = "Y";
					else
						inRcFlg = "N";
	
					if( "1".equals(inDcgoFlg))
						inDcgoFlg = "Y";
					else
						inDcgoFlg = "N";
	
					if( "1".equals(inAwkCgoFlg))
						inAwkCgoFlg = "Y";
					else
						inAwkCgoFlg = "N";
	
					if( "1".equals(inBbCgoFlg))
						inBbCgoFlg = "Y";
					else
						inBbCgoFlg = "N";
									
					
					String sealnbr = "";
					String multiCntrSealNo = "";
					String[] cntrSealNo = null;
					int mxCntrVOMaxCnt = mxCntrVOs.size();
					for(int j = 0; j < mxCntrVOMaxCnt; j++){
						
						mxCntrVO = mxCntrVOs.get(j);
						
						// 컨테이너 번호 조건 초기화.
						cond1.setCntrNo("");
						
						// 멀티 SealNo 값
						multiCntrSealNo = mxCntrVO.getSealnbr();
						cntrSealNo = multiCntrSealNo.split("@");
						int cntrSealNOMaxCnt = cntrSealNo.length;
						if(cntrSealNOMaxCnt > 0) {
							sealnbr = cntrSealNo[0];
						} else {
							sealnbr = "";
						}
						
						tmp = new StringBuffer();
						tmp.append("{CNTR_INFO")										.append("\n");
						tmp.append("CNTRNBR:")		.append(mxCntrVO.getCntrnbr())		.append("\n");
						tmp.append("PUNIT:")		.append(mxCntrVO.getPunit())		.append("\n");
						tmp.append("PKG:")			.append(mxCntrVO.getPkg())			.append("\n");
						tmp.append("CNTRWGT:")		.append(mxCntrVO.getCntrwgt())		.append("\n");
						tmp.append("CNTRGWGT:")		.append(mxCntrVO.getCntrgwgt())		.append("\n");
						tmp.append("CNTR_WGT_UNIT:").append("KGS")						.append("\n");
						tmp.append("CNTRTRW:")		.append(mxCntrVO.getCntrtrw())		.append("\n");
						tmp.append("CNTRTYPE:")		.append(mxCntrVO.getCntrtype())		.append("\n");
						tmp.append("SEALNBR:")		.append(sealnbr)					.append("\n");
						tmp.append("FM_IND:")		.append(inBkgCgoTpCd)				.append("\n");
						tmp.append("RF_IND:")		.append(inRcFlg)					.append("\n");
						tmp.append("DG_IND:")		.append(inDcgoFlg)					.append("\n");
						tmp.append("AK_IND:")		.append(inAwkCgoFlg)				.append("\n");
						tmp.append("BK_IND:")		.append(inBbCgoFlg)					.append("\n");
						tmp.append("TEMP:")			.append(mxCntrVO.getTemp())			.append("\n");
						tmp.append("TUNIT:")		.append("C")						.append("\n");
						tmp.append("VENT:")			.append(mxCntrVO.getVent())			.append("\n");
						tmp.append("MEASURE:")		.append(mxCntrVO.getMeasure())		.append("\n");
						tmp.append("MEASURE_UNIT:")	.append(mxCntrVO.getMeasureUnit())	.append("\n");
						tmp.append("RDTYPE:")		.append(mxCntrVO.getRdtype())		.append("\n");
						tmp.append("CMDT_DESC:")	.append(cmdtNm)						.append("\n");
//						tmp.append("CMDTCD:")		.append(cmdtCd)						.append("\n");
						tmp.append("CMDTCD:")		.append("")							.append("\n");
						tmp.append("RF_REMARK:")	.append(mxCntrVO.getRfRemark())		.append("\n");
						tmp.append("RFDRY_IND:")	.append(inRdCgoFlg)					.append("\n");
						tmp.append("OVF:")			.append(mxCntrVO.getOvf())			.append("\n");
						tmp.append("OVR:")			.append(mxCntrVO.getOvr())			.append("\n");
						tmp.append("OVH:")			.append(mxCntrVO.getOvh())			.append("\n");
						tmp.append("OVLW:")			.append(mxCntrVO.getOvlw())			.append("\n");
						tmp.append("OVRW:")			.append(mxCntrVO.getOvrw())			.append("\n");
						tmp.append("OVWGT:")		.append(mxCntrVO.getOvwgt())		.append("\n");
						tmp.append("OVWGT_UNIT:")	.append(mxCntrVO.getOvwgtUnit())	.append("\n");
						tmp.append("VOID_SLOT:")	.append(mxCntrVO.getVoidSlot())		.append("\n");
						tmp.append("STWG_REQ:")		.append("")							.append("\n");
						tmp.append("SOCIND:")		.append(mxCntrVO.getSocind())		.append("\n");
						tmp.append("HAULAGE:")		.append("")							.append("\n");
						tmp.append("BKWGT:")		.append(mxCntrVO.getBkwgt())		.append("\n");
						tmp.append("BKWGTU:")		.append(mxCntrVO.getBkwgtu())		.append("\n");
						tmp.append("BKW:")			.append(mxCntrVO.getBkw())			.append("\n");
						tmp.append("BKH:")			.append(mxCntrVO.getBkh())			.append("\n");
						tmp.append("BKL:")			.append(mxCntrVO.getBkl())			.append("\n");
						tmp.append("CNTROWN:")		.append(mxCntrVO.getCntrown())		.append("\n");
						tmp.append("CNTRTRM:")		.append(mxCntrVO.getCntrtrm())		.append("\n");
						
						buff.append(tmp.toString());
						
						// 멀티 Seal NO 항목 생성
						if(cntrSealNOMaxCnt > 0) {
							tmp = new StringBuffer();
							for(int sealIdx = 0; sealIdx < cntrSealNOMaxCnt; sealIdx++) {
								tmp.append("{CNTR_SEAL_NO").append("\n");
								tmp.append("SEAL_NO:").append(cntrSealNo[sealIdx]).append("\n");
								tmp.append("}CNTR_SEAL_NO").append("\n");
							}
							buff.append(tmp.toString());
						}
						
						// 컨테이너 번호 조건 설정.
						cond1.setCntrNo(mxCntrVO.getCntrNo());
						
						// Danger Cgo 조회.
						mxDgInfoVO = dbDao.searchDangerCgo(cond1);
						if(mxDgInfoVO != null)
						{
							tmp = new StringBuffer();
							for(int k = 0; k < mxDgInfoVO.size(); k++)
							{	
								tmp.append("{CNTR_DANGER")													.append("\n");
								tmp.append("UNNBR:")		.append(mxDgInfoVO.get(k).getUnnbr())			.append("\n");
								tmp.append("CLASS:")		.append(mxDgInfoVO.get(k).getClass1())			.append("\n");
								tmp.append("DG_DESC:")		.append(mxDgInfoVO.get(k).getDgDesc())			.append("\n");
								tmp.append("PHONE:")		.append(mxDgInfoVO.get(k).getPhone())			.append("\n");
								tmp.append("PAGE:")			.append(mxDgInfoVO.get(k).getPage())			.append("\n");
								tmp.append("FLSH_TEMP:")	.append(mxDgInfoVO.get(k).getFlshTemp())		.append("\n");
								tmp.append("FLSH_UNIT:")	.append(mxDgInfoVO.get(k).getFlshUnit())		.append("\n");
								tmp.append("DG_REMARK:")	.append(mxDgInfoVO.get(k).getDgRemark())		.append("\n");
								tmp.append("EMSNO:")		.append(mxDgInfoVO.get(k).getEmsno())			.append("\n");
								tmp.append("PSACLS:")		.append(mxDgInfoVO.get(k).getPsacls())			.append("\n");
								tmp.append("PKGGRP:")		.append(mxDgInfoVO.get(k).getPkggrp())			.append("\n");
								tmp.append("MFAG1:")		.append(mxDgInfoVO.get(k).getMfag1())			.append("\n");
								tmp.append("MFAG2:")		.append(mxDgInfoVO.get(k).getMfag2())			.append("\n");
								tmp.append("MAR_POLL:")		.append(mxDgInfoVO.get(k).getMarPoll())			.append("\n");
								tmp.append("LABEL_CD:")		.append(mxDgInfoVO.get(k).getLabelCd())			.append("\n");
								tmp.append("LABEL_DESC:")	.append("")										.append("\n");
								tmp.append("D_PKG:")		.append(mxDgInfoVO.get(k).getDPkg())			.append("\n");
								tmp.append("D_PKGUNIT:")	.append(mxDgInfoVO.get(k).getDPkgunit())		.append("\n");
								tmp.append("NWGT:")			.append(mxDgInfoVO.get(k).getNwgt())			.append("\n");
								tmp.append("NWGT_UNIT:")	.append(mxDgInfoVO.get(k).getNwgtUnit())		.append("\n");
								tmp.append("GWGT:")			.append(mxDgInfoVO.get(k).getGwgt())			.append("\n");
								tmp.append("GWGT_UNIT:")	.append(mxDgInfoVO.get(k).getGwgtUnit())		.append("\n");
								tmp.append("MEA:")			.append(mxDgInfoVO.get(k).getMea())				.append("\n");
								tmp.append("MEA_UNIT:")		.append(mxDgInfoVO.get(k).getMeaUnit())			.append("\n");
								tmp.append("HAZ_CONT:")		.append(mxDgInfoVO.get(k).getHazCont())			.append("\n");
								tmp.append("STWG:")			.append(mxDgInfoVO.get(k).getStwg())			.append("\n");
								tmp.append("LABEL:")		.append(mxDgInfoVO.get(k).getLabel())			.append("\n");
								tmp.append("}CNTR_DANGER")													.append("\n");
							}
							buff.append(tmp.toString());
													
						}// mxDgInfoVO is not null	
						
						//CNTR Desc. Info. for Flat File (INBOND_CNTR_MD에 없다면, CM_MARK_DESC에서 구한다)
						mxCmDetailInfoVO = dbDao.searchCmByCntr(cond1);
						if(mxCmDetailInfoVO == null)
						{
							mxCmDetailInfoVO = dbDao.searchCmByCntrAtOutBound(cond1);
						}
						
						if(mxCmDetailInfoVO != null)
						{
							tmp = new StringBuffer();
							for(int k = 0; k < mxCmDetailInfoVO.size(); k++){
								tmp.append("{CNTR_DESC")													.append("\n");
								tmp.append("D_CMDT:")		.append(mxCmDetailInfoVO.get(k).getDCmdt())		.append("\n");
								tmp.append("D_PUNIT:")		.append(mxCmDetailInfoVO.get(k).getDPunit())	.append("\n");
								tmp.append("D_PKG:")		.append(mxCmDetailInfoVO.get(k).getDPkg())		.append("\n");
								tmp.append("D_WGT:")		.append(mxCmDetailInfoVO.get(k).getDWgt())		.append("\n");
								tmp.append("D_MEAS:")		.append(mxCmDetailInfoVO.get(k).getDMeas())		.append("\n");
								tmp.append("D_HS_CD:")		.append(mxCmDetailInfoVO.get(k).getDHsCd())		.append("\n");
								tmp.append("D_DESC:")		.append(mxCmDetailInfoVO.get(k).getDDesc())		.append("\n");
								
								String custMark = mxCmDetailInfoVO.get(k).getDMark();
								if(custMark != null && !custMark.equals("")) {
									tmp.append("{CUS_MARK")				.append("\n");
									tmp.append("D_MARK:")            	.append(custMark).append("\n");
									tmp.append("}CUS_MARK")				.append("\n");
								}
								tmp.append("}CNTR_DESC")				.append("\n");
							}
							buff.append(tmp.toString());
							
						}
												tmp = new StringBuffer();
						tmp.append("}CNTR_INFO\n");
						buff.append(tmp.toString());
						
					}// for in mxCntrVO
				}// mxCntrVO is not null
				
				// QTY Info. for Flat File
				mxQtyVO = dbDao.searchQty(cond1);
				if(mxQtyVO != null){
					tmp = new StringBuffer();
					for(int k = 0; k < mxQtyVO.size(); k++){
						tmp.append("{QTY")												.append("\n");
						tmp.append("HANTYPE:")		.append(mxQtyVO.get(k).getHantype()).append("\n");
						tmp.append("COUNT:")		.append(mxQtyVO.get(k).getCount())	.append("\n");
						tmp.append("}QTY")												.append("\n");
					}
					buff.append(tmp.toString());
					
				}else{ // mxQtyVO is not null end, else start.
					// Msg : No Data Found!
					throw new EventException(new ErrorHandler("BKG00095",new String[]{cond1.getBkgNo()}).getMessage());
				}
				

				// BKGVVD Info. for Flat File
				mxBkgVvdVO = dbDao.searchBkgVvd(cond1);
				if(mxBkgVvdVO != null){
					tmp = new StringBuffer();
					for(int k = 0; k < mxBkgVvdVO.size(); k++){
						tmp.append("{BKGVVD")															.append("\n");
						tmp.append("BVVD1:")			.append(mxBkgVvdVO.get(k).getBvvd1())			.append("\n");
						tmp.append("BVVD_LANE:")		.append(mxBkgVvdVO.get(k).getBvvdLane())		.append("\n");
						tmp.append("VSL_CALLSIGN1:")	.append(mxBkgVvdVO.get(k).getVslCallsign1())	.append("\n");
						tmp.append("VSL_LLOYDCODE1:")	.append(mxBkgVvdVO.get(k).getVslLloydcode1())	.append("\n");
						tmp.append("VSL_FULLNAME1:")	.append(mxBkgVvdVO.get(k).getVslFullname1())	.append("\n");
						tmp.append("VVD_REF_NO1:")		.append(mxBkgVvdVO.get(k).getVvdRefNo1())		.append("\n");
						tmp.append("BLPOL1:")			.append(mxBkgVvdVO.get(k).getBlpol1())			.append("\n");
						tmp.append("POL_FULLNAME1:")	.append(mxBkgVvdVO.get(k).getPolFullname1())	.append("\n");
						tmp.append("BLPOD1:")			.append(mxBkgVvdVO.get(k).getBlpod1())			.append("\n");
						tmp.append("POD_FULLNAME1:")	.append(mxBkgVvdVO.get(k).getPodFullname1())	.append("\n");
						tmp.append("POLETA1:")			.append(mxBkgVvdVO.get(k).getPoleta1())			.append("\n");
						tmp.append("POLETD1:")			.append(mxBkgVvdVO.get(k).getPoletd1())			.append("\n");
						tmp.append("PODETA1:")			.append(mxBkgVvdVO.get(k).getPodeta1())			.append("\n");
						tmp.append("PODETD1:")			.append(mxBkgVvdVO.get(k).getPodetd1())			.append("\n");
						tmp.append("OP_CODE:")			.append(mxBkgVvdVO.get(k).getOpCode())			.append("\n");
						tmp.append("}BKGVVD")															.append("\n");
					}
					buff.append(tmp.toString());
					
				}else{ // mxBkgVvdVO is not null end, else start.
					// Msg : No Data Found!
					throw new EventException(new ErrorHandler("BKG00095",new String[]{cond1.getBkgNo()}).getMessage());
				}
				
				//BL's END.
				buff.append("}BL_INFO\n");
				
				// 전송로그 데이타 만들기
				bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(cond1.getBkgNo());
				bkgNtcHisVO.setNtcViaCd(""); 
				bkgNtcHisVO.setNtcKndCd("IM"); 
				bkgNtcHisVO.setEdiId("MEXCUS");
				bkgNtcHisVO.setBkgNtcSndRsltCd("A");
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndDt(localSendTime);
				bkgNtcHisVO.setSndGdt(localSendTime);
                bkgNtcHisVO.setSndRqstDt(localSendTime);
                bkgNtcHisVO.setSndRqstGdt(localSendTime);
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				bkgNtcHisVOs.add(bkgNtcHisVO);
				bkgNtcHisVO.setDiffRmk(vvd);
				
			}// for in manifestTransmitVOs
			
			/* 전송로그를 저장한다. */
			BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
			bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, account.getUsr_id());	
			
			/*********************************************
			// Message Send Start
			 *********************************************/
			bookingUtilBC = new BookingUtil();
			FlatFileAckVO flatFileAckVO = null;				
			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CDL.IBMMQ.QUEUE"));
			
			sendFlatFileVO.setFlatFile(buff.toString());				
			flatFileAckVO = bookingUtilBC.sendFlatFile(sendFlatFileVO);				
			if ( flatFileAckVO.getAckStsCd().equals("E") )
				throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
			
			log.info(buff.toString());
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;	
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00099",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00099",new String[]{}).getMessage(), ex);
		}
		
		return buff.toString();
	}
	
	/**
	 * BackEndJob을 실행.
	 * 
	 * @param SignOnUserAccount account
	 * @param ManifestTransmitVO[] manifestTransmitVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 * 
	 */
	public String startBackEndJob(SignOnUserAccount account, 
			ManifestTransmitVO[] manifestTransmitVO, String pgmNo)  throws EventException{
		try{
			MexCustomsTransmissionBackEndJob backEndJob = new MexCustomsTransmissionBackEndJob ();
			backEndJob.setPgmNo(pgmNo);
			String resultStr = "";
			if(pgmNo.equals("ESM_BKG_0370")){
				backEndJob.setManifestTransmitVO((MxManifestListByVvdDetailVO[])manifestTransmitVO);
				backEndJob.setAccount(account);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				resultStr = backEndJobManager.execute(backEndJob , account.getUsr_id(), "Mexico Customs Transmit");
			}
			
			return resultStr;
		//DAO 호출이 없으므로 DAOException을 catch하는 부분은 생략한다.	
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00099",new String[]{}).getMessage(), ex);
		}	
	}
	
	/**
     * pod를 drop down으로 조회한다.<br>
	 * 
     * @param  CargoManifestCondForEdiVO cond
     * @return List<BkgComboVO>
     * @exception EventException
     */
    public List<BkgComboVO> searchManifestPodList (CargoManifestCondForEdiVO cond) throws EventException{
    	try {
    		return dbDao.searchManifestPodList(cond);
    	} catch (DAOException de) {
    		log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),de);
    	} catch (Exception ex) {
    		log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(),ex);
		}
    }
	
}
