/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UsaCustomsTransmissionBCImpl.java
 *@FileTitle : UsaCustomsTransmissionBCImpl
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.25
 *@LastModifier : 김도완
 *@LastVersion : 1.0
 * 2009.05.25 김도완
 * 1.0 Creation 
 * --------------------------------------------------------
 * History
 * 2010.09.09 최도순 [CHM-201005692] AI 전송시 ISF-5 자동 전송 요청
 * 2010.10.01 최도순 [CHM-201004946] C-flag update 로직 보완 요청
 * 2010.10.13 최도순 [CHM-201004946] C-flag update 로직 보완 요청(반영지연으로 주석처리)
 * 2011.04.27 김경섭 [CHM-201109869-01] RC메시지, R06항목 4~6 문자,  ‘INC’,’ACC’ 이면 BAPLIE RC 로 인식
 * 									  C01 항목으로 리스팅 된 Cntr 에 대해 R03 의 Remark 를 표기 
 *                                    C01 항목으로 리스팅 되지 않은 CNTR 에 대해 해당 VVD의 BAPLIE 전송이력이 있는 CNTR 는 모두 ACK 로 표기
 * 2011.06.07 민정호 [CHM-201111167] US AMS Receiving History 화면 보완요청
 * 2011.06.21 민정호 [CHM-201111545] ACE 전환 관련 CSR - Cntr status
 * 2011.10.12 윤태승 [CHM-201113684-01][ESM_BKG] US AMS 의 MI 중복전송 기능 요청 - IDhjsedlee
 * 2011.10.13 김봉균 [CHM-201112452-01] 미세관 RECEIVE 데이터 중 CUSRES 반영 요청
 * 2012.01.10 민정호 [CHM-201113812] ACE 전환관련 Requirement 변경 부분 1차 요청 (M01,P01,B01,C01,D01,I01
 * 2012.01.31 민정호 [CHM-201215726-01] AMS 전송시 Customs 로직 추가 요청
 * 2012.03.27 민정호 [] GAP EDI 전송 누락 관련 협의 필요 사항 확인 요청
 * 2012.07.17 이영헌 [CHM-201218974-01] US ACE M1 관련 - Customs location 인지 로직 변경
 * 2013.04.02 김보배 [CHM-201323809] [BKG] [US AMS] MI 전송 화면 & Transmission & receiving history 화면 보완
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.basic;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import m2soft.rdsystem.server.core.rddbagent.util.serverexport.ExportInfo;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.BaplieAlarmSetupVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.FlatFileAckVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SendFlatFileVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration.UsaACECustomsTransmissionDBDAOsearhCstmsNtcSndInfoRSQL;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration.UsaCustomsTransmissionDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration.UsaCustomsTransmissionDBDAOaddResultCntrCSQL;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration.UsaCustomsTransmissionDBDAOsearchCntrLineRSQL;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.AmsInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.BayPlanCntrDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.BayPlanCntrListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.BlLineInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.CmdMarkVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.CstmsHoldNtcSendVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.CstmsNtcSndInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.CstmsRejNtcSndVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.DgUnnoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.EtaCondAtAdvancedVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.EtaDetailAtAdvancedVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.HoldInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.Isf5InfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.OFMBlLineInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.OFMCntrLineVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.SendDetailLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.SendLogDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.StiCondListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.StiDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaCMVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaContainerInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaCstmsManifestAmendmentCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaCustomerInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaEDADetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaIsf5CondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaIsf5ResultVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaLocationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaManifestListCondForEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaMiCountVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaMiHiHeadFootCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaMiHiHeaderFooterVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaPartialBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaRcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaResultCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaTiTrsmContentVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaTransmitInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaTrsmFirstHeadVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.VesselEtaCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.VesselEtaInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.VslNameVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.CstmsManifestAmendmentVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListCondForEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestListForEdiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.ManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.RcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.SendingLogVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.StowageManifestCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.basic.UsaManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration.UsaManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsCustomsStatusNoticeVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestSearchDetailVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CstmsClrVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration.InboundNoticeEAIDAO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CstmsHldVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.RDMailSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.TmpMailSendVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.MailerAppException;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.table.ComRptDsgnXptInfoVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvBlVO;
import com.hanjin.syscommon.common.table.BkgCstmsAdvIbdVO;
import com.hanjin.syscommon.common.table.BkgCstmsIbdHisVO;
import com.hanjin.syscommon.common.table.BkgDocProcSkdVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.MdmVslCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.integration.UsaACECustomsTransmissionDBDAO; // 추가ACE

/**
 * ALPS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - ALPS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kyoung Jong Yun
 * @see ESM_BKG_0127EventResponse,BrcsCustomsTransmissionBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class UsaCustomsTransmissionBCImpl extends CustomsTransmissionBCImpl {
	// Database Access Object
	private transient UsaCustomsTransmissionDBDAO dbDao = null;
	private transient UsaACECustomsTransmissionDBDAO dbAceDao = null;	// 추가ACE
	
	private UsaManifestListDownloadBCImpl downLoadBC = null;
	private BookingHistoryMgtBC bkgHisBC = null;
	
//	private boolean baseDateFlag = false;
//	private final static String OLD_IRS_NO = "95-328691000"; // 2010년 5월 6일 13시 이전까지만 사용
//	private final static String NEW_IRS_NO = "90-053066900"; // 2010년 5월 6일 13시 이후부터 사용
//	private final static String NEW_IRS_NO = "81-521404200"; // 2017년 3월 17일 SM Line 적용
//	private final static String IRS_NO = "23-303882900"; // 2017년 3월 17일 SM Line 적용 - DEV 개발적용시 수정
	private final static String IRS_NO = "81-521404200"; // 2017년 3월 17일 SM Line 적용 -LIVE
//	private String irsNo = "";

	/**
	 * CndCustomsTransmissionBCImpl 객체 생성<br>
	 * CndCustomsTransmissionDBDAO 생성한다.<br>
	 */
	public UsaCustomsTransmissionBCImpl() throws EventException {
		dbDao = new UsaCustomsTransmissionDBDAO();
		dbAceDao = new UsaACECustomsTransmissionDBDAO();	// 추가ACE		
		downLoadBC = new UsaManifestListDownloadBCImpl();
		bkgHisBC = new BookingHistoryMgtBCImpl();
		
		// IRS No.를 변경할 기준 시간을 체크한다.(2010년 5월 16일 13시 이후면 적용한다.)
//		baseDateFlag = this.isBeforeDate(2010, 5, 6, 13, 0);
		
//		if(baseDateFlag) {
//			irsNo = OLD_IRS_NO;
//		} else { 
//			irsNo = NEW_IRS_NO;
//		}
	}

	/**
	 * US 세관신고 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVO
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifest(ManifestTransmitVO[] manifestTransmitVO) throws EventException {
		// sTrsmMsgTpCd : MI/AI..
		String sTrsmMsgTpCd = "";
		BookingUtil command2 = new BookingUtil();
		FlatFileAckVO flatFileAckVO = null;
		SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
		sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZ2HJS_AMS.IBMMQ.QUEUE"));
		UsaManifestSearchDetailVO usaManifestTransmitVO = null;
		UsaManifestSearchDetailVO[] usaManifestTransmitVOs = null;
		ManifestTransmitVO manifestTransmitVO2 = null;
		int len = manifestTransmitVO.length;
		if (len > 0)
		{
			manifestTransmitVO2 = manifestTransmitVO[0];
		}
		else
		{
			throw new EventException(new ErrorHandler("BKG01051").getMessage());
		}
		String keySetStr = manifestTransmitVO2.getColumnValues().keySet().toString();
		if (keySetStr.indexOf("pod_cd") >= 0)
		{
			sTrsmMsgTpCd = "HI"; // 0543 화면에서 전송하는 루틴.
		}
		else
		{
			sTrsmMsgTpCd = "MI"; // 0613 화면에서 전송하는 루틴.
		}
		List<AmsInfoVO> amsInfoVos = null;
		AmsInfoVO amsInfoVo = null;
		BlLineInfoVO blLineInfoVO = null;
		List<BlLineInfoVO> blLineInfoVOs = null;
		UsaCustomerInfoVO custLineInfoVO = null;
		List<UsaCustomerInfoVO> custLineInfoVOs = null;
		List<UsaContainerInfoVO> cntrLineInfoVOs = null;
		UsaContainerInfoVO cntrLineInfoVO = null;
		List<UsaCMVO> cntrMfLineInfoVOs = null;
		List<UsaCMVO> usaCmVOsForIsf = null;
		CmdMarkVO cmdMarkVO = null;
		List<DgUnnoVO> dgUnnoVOs = null;
		StringBuffer flatFile = new StringBuffer();
		StringBuffer hiFile02 = null;
		StringBuffer tmpBuf = null;
		int maxCnt = 0;
		int realSentBlCnt = 0;
		int blCntExceptHouse = 0;
		int lineCount = 0;
		int resultQuery = 0;
		String alreadySentBl = "";
		String currBlNo = "";
		String vvd = "";
		String actFileVvd = "";
		String actFileSkdDirCd = "";
		String crrBatNo = "";
		String pod = "";
		String pol = "";
		String cgoTpCd = "";
		String b01 = "";
		String buf6 = "";
		String buf7 = "";
		String buf8 = "";
		String locCd = "";
		String digit2blank = "";
		String digit4blank = "";
		String digit5blank = "";
		String digit10blank = "";
		String digit20blank = "";
		String dgUnno = "";
		String polLastLoc = "";
		String itIpiLocal = "";
		String itItno = "";
		String itItType = "";
		String itHub = "";
		String itLstUsa = "";
		String amsPort = "";
		String delAms = "";
		String fdaInd = "";
		String wgtVal = "";
		String cmdtCd = "";
		String cmdtDesc = "";
		String itPkgQty = "";
		String itPkgAms = "";
		String itDel = "";
		String preMfCnt = "";
		String buf22 = "";
		String buf24 = "";
		String buf26 = "";
		String buf27 = "";
		String cntrNo = "";
		String icmHtCd = "";
		String icmWgtQty = "";
		String icmWgtVal = "";
		String icmWgtTp = "";
		String icmPkgQty = "";
		String icmDesc = "";
		String cmdSeq = "";
		String cmdMarkAll = "";
		String cmdMarkLen = "";
		String cmdMarkNew = "";
		String cmdMark = "";
		String mbl = "";
		String vslFlag = "";
		String vslEngNm = "";
		String vslLloyd = "";
		String vpsEtaDt = "";
		String lsDate = "";
		String usrId = "";
		String ofcCd = "";
		String locAmsport = "";
		String amsCode = "";
		String mfNo = ""; // 'X'이면 마스터, 아니면 하우스.
		String isf5 = "";
		String fPod = "";
		int blseVoy = 0;
		int miSndCount = 0;
		SendingLogVO sndLogVo = new SendingLogVO();
		UsaTiTrsmContentVO tiContVo = null;
		String tFirmsCode = "";
		String tBondCarrier = "";
		int lineCnt = 0;
		int kk = 0;
		int j = 0;
		int idx = 0;
		int cntrCountPerBl = 0;
		
		String cstmsPortCd = "";
		String bookingPodCd = "";
		
		String cstmsLocCd = "";
		UsaMiCountVO checkMiCondVO = new UsaMiCountVO();
		
		BkgDocProcSkdVO bkgDocProcSkdVO = null;
		
		try
		{
			
			digit2blank = "  ";
			digit4blank = "    ";
			digit5blank = "     ";
			digit10blank = "          ";
			digit20blank = "                    ";
			
			//여기서 sTrsmMsgTpCd는 MI/HI 로 세팅 된다.
			//아래 AI/TI 체크는 의미 없다. 업무적으로 MI/AI/TI를 같이 처리 한다는 의미이다. **********************************************
			if ("MI".equals(sTrsmMsgTpCd) || "AI".equals(sTrsmMsgTpCd) || "TI".equals(sTrsmMsgTpCd))
			{
				usaManifestTransmitVOs = (UsaManifestSearchDetailVO[]) manifestTransmitVO;
				flatFile = null;
				flatFile = new StringBuffer();
				maxCnt = usaManifestTransmitVOs.length;
				// bl_param
				String blParams = "";
				StringBuffer blParams1 = new StringBuffer();

				// BL정보를 조회하기 위해 BL No.를 IN절 처리 하기 위한 LOOP
				for (int i = 0; i < maxCnt; i++)
				{
					// to_clob
					if(i == 0){
						blParams1.append("to_clob('");
					}else if(i % 270 == 1 && i != 1){
						blParams1.append("||to_clob('");
					}
					blParams1.append(usaManifestTransmitVOs[i].getBlNo());
					
					if (i != maxCnt - 1){
						blParams1.append(",");
					}
					if((i != 0 && i % 270 == 0) || i == len - 1){
						blParams1.append("')");
					}
					// END to_clob
				}
				blParams = blParams1.toString();

				/**************************************************************
				// blCntExceptHouse
				// MI는 VVD,POL,POD별로 전송됨 
				// AI는 BL 단위로 전송됨 - 화면에서 1건씩 전송 LOOP 전송
				// TI는 BL 단위로 전송됨 - 화면에서 단건 전송
				// 위의 전송 단위로 볼 때 첫번째 행의 BL로 POL/POD정보를 조회해도 문제가 되지 않는다.
				 **************************************************************/
				if (maxCnt > 0)
				{
					usaManifestTransmitVO = usaManifestTransmitVOs[0];
					currBlNo = usaManifestTransmitVO.getBlNo();
					
					//@ 실제 Msg Type Code(MI,AI,TI)를 설정한다. ********************************************************************************
					sTrsmMsgTpCd = usaManifestTransmitVO.getTransmitCd();
					//@ MI,TI의 경우 VVD가 최종 VVD로 가져오며, AI의 경우 SC에서 T-VVD가 세팅되어 넘어오므로 재 조회하여 다시 세팅한다. *******************
					vvd = usaManifestTransmitVO.getVvd();
					usrId = usaManifestTransmitVO.getUsrId();
					ofcCd = usaManifestTransmitVO.getOfcCd();
					pod = usaManifestTransmitVO.getPod();
					pol = usaManifestTransmitVO.getPol();
					cgoTpCd = usaManifestTransmitVO.getCgoTpCd();
					
					BkgCstmsAdvBlVO bkgCstmsAdvBlVO = dbDao.searchAdvBl(usaManifestTransmitVO.getBlNo(), "US");
					cstmsPortCd = bkgCstmsAdvBlVO.getCstmsPortCd(); // locAmsport값 구할때 인자값으로 사용
					actFileSkdDirCd = bkgCstmsAdvBlVO.getActFileSkdDirCd();
					
					if ("AI".equals(sTrsmMsgTpCd))
					{
						//BkgCstmsAdvBlVO bkgCstmsAdvBlVO = dbDao.searchAdvBl(usaManifestTransmitVO.getBlNo(), "US");
						
						//@ AI 의 경우 BKG의 T-VVD가 SC단에서 세팅되어 넘어 온다. 따라서 VVD를 조회한 bkgCstmsAdvBlVO 것으로 다시 세팅한다. **************
						vvd = bkgCstmsAdvBlVO.getVslCd()+bkgCstmsAdvBlVO.getSkdVoyNo()+bkgCstmsAdvBlVO.getSkdDirCd();
						pod = bkgCstmsAdvBlVO.getCstmsPodCd();
						pol = bkgCstmsAdvBlVO.getCstmsPolCd();
						cgoTpCd = bkgCstmsAdvBlVO.getFullMtyCd();
					}
					
					// 090813.
					// actFileSkdDirCd Logic.
					// POL이 CA%이고, SKD_DIR_CD가 'E' 라면 'W'로 전송한다.
					// 10/07 pod 체크 로직을 삭제한다.
					/*
					String skdDirCd = vvd.substring(8, 9);
					if (pol.startsWith("CA") && ("E".equals(skdDirCd) || "W".equals(skdDirCd)) ){
						
						if("E".equals(skdDirCd)) {
							actFileVvd = vvd.substring(0, 8) + "W";
							actFileSkdDirCd = "W";
						} else if("W".equals(skdDirCd)) {
							actFileVvd = vvd.substring(0, 8) + "E";
							actFileSkdDirCd = "E";
						}
					} else {
						actFileVvd = vvd;
						actFileSkdDirCd = vvd.substring(8, 9);
					}
					*/
					
					/*
					 * 대상 BL중 첫번째 BL이  가지고 있는 act_file_skd_dir_cd글 대상으로 Actual File VVD를 판단한다.
					 */
					if("E".equals(actFileSkdDirCd)) {
						actFileVvd = vvd.substring(0, 8) + actFileSkdDirCd;
					} else {
						actFileVvd = vvd;
						actFileSkdDirCd = vvd.substring(8, 9);
					}
					
					lsDate = dbDao.searchSysdate("ddmmrrhh24miss");
					// [USACUSKEWB0029EUSTIWNGOBS AUTO_HI 1018020090419040121HI
					UsaTrsmFirstHeadVO firstHeadVO = new UsaTrsmFirstHeadVO();
					// 기존에는 setVvd에 vvd를 넘겼으나, actFileSkdDirCd로직 이후, actFileVvd를 넘기도록 수정한다.
					firstHeadVO.setVvd(actFileVvd);
					firstHeadVO.setPodCd(pod);
					firstHeadVO.setOfcCd(ofcCd);
					firstHeadVO.setUsrId(usrId);
					firstHeadVO.setLsDate(lsDate);
					firstHeadVO.setFormat("ddmmrrhh24miss");
					firstHeadVO.setTrspMsgTpCd(sTrsmMsgTpCd);
					
					// CBP에는 ACR부터 전송됨, 
					// USACU... 로 시작 되는 첫 라인을 생성하나, CBP에는 전송하지 않고  ALPS에서도 사용하고 있지 않음.
					// 예:USACUSHNPH0109EUSOAKPHXSA 21702002  ######20170412022237AI
					// 생성 이유가 불명확 함.
					buf6 = dbDao.searchTrsmFirstHeader(firstHeadVO);
					//locAmsport = dbDao.searchPodAmsCode(pod);
											
					
					//@ BKG_CSTMS_CD_CONV_CTNT 테이블에 US AMS_TML_CD_MAP으로 등록된 데이타가 USNYCM5 1개 이므로 아래 MDM_LOCATION 조회 로직을 탄다. 
					if(bkgCstmsAdvBlVO.getAmsTmlCd() == null || bkgCstmsAdvBlVO.getAmsTmlCd().length() == 0){
						locAmsport = dbDao.searchPodAmsCode(cstmsPortCd);
					}else{
						locAmsport = bkgCstmsAdvBlVO.getAmsTmlCd();
					}
															
					if (locAmsport == null || locAmsport.length() == 0)
						locAmsport = digit4blank;
					// Vsl_cd가 등록된 국가코드,영문이름 정보를 조회한다. 
					MdmVslCntrVO mdmVslCntrVO = dbDao.searchVslInfo(vvd);
					if (mdmVslCntrVO == null || mdmVslCntrVO.getVslCd() == null)
					{
						throw new EventException(new ErrorHandler("BKG01052").getMessage());
					}
					vslFlag = mdmVslCntrVO.getVslRgstCntCd();
					vslEngNm = mdmVslCntrVO.getVslEngNm();
					vslLloyd = mdmVslCntrVO.getLloydNo();
					
					// 구 한진해운 코드
					if (vslLloyd == null || vslLloyd.equals("9124524") || vslLloyd.equals("8918945")
							|| vslLloyd.equals("9183489"))
					{
						vslLloyd = "       ";
					}
					// 구 한진해운 코드
					if (vvd.indexOf("BLSE") >= 0)
					{
						blseVoy = Integer.parseInt(vvd.substring(4, 8));
						if (blseVoy > 839)
						{
							vslFlag = "PA";
						}
						else
						{
							vslFlag = "LR";
						}
					}
					
					//@ ETA 정보 조회 *****************************************************************
					vpsEtaDt = dbDao.searchVslEta(vvd, cstmsPortCd, "MAX_MMDDRR");
					if (vpsEtaDt == null || vpsEtaDt.length() == 0)
						vpsEtaDt = dbDao.searchEtaWhenSkdIsNotExist(vvd, pod);
					if (vpsEtaDt == null || vpsEtaDt.length() != 6)
					{
						// Please update vessel schedule first before you send MI & AI.
						throw new EventException(new ErrorHandler("BKG01053").getMessage());
					}
					
					//@ 전송 체크 로직 ******************************************** 
					if ("MI".equals(sTrsmMsgTpCd))
					{
						/*
						 * 2010년 7월 16일 경종윤
						 *  MI가 전송된 적이 있는지 확인 작업 
						 */
						
						checkMiCondVO.setVvd(vvd);
						checkMiCondVO.setPod(pod);
						checkMiCondVO.setPol(pol);
						checkMiCondVO.setTrsmTp("MI");
						checkMiCondVO.setCgoTpCd(cgoTpCd);	// cgo_tp_cd 컬럼 추가
						miSndCount = dbDao.checkMiTransCount(checkMiCondVO);
						
						String user_auth_mi_multi = dbDao.searchUserAuthMiMultiYn(usaManifestTransmitVO.getUsrId());
						
						String gubun = SubSystemConfigFactory.get("BKG.MFT.SERVICE.MODE");
						if(gubun == null){
							gubun = "N";
						}
						log.debug("gubun = "+gubun);
						log.debug("user_auth_mi_multi = "+user_auth_mi_multi);
					    if( !( "TEST".equals(gubun) || "Y".equals(user_auth_mi_multi)) ){
					    	
					    	//@ MI 중복 전송 허용 안됨. 단 개발서버 이거나 권한 있는 유저는 중복 전송 가능 **************************
							if (miSndCount > 0)
							{
								// MI File Already transmitted.
								throw new EventException(new ErrorHandler("BKG01054").getMessage());
							}
					    }
					}
					else if ("AI".equals(sTrsmMsgTpCd)) 
					{
						checkMiCondVO.setVvd(vvd);
						checkMiCondVO.setPod(pod);
						checkMiCondVO.setPol(pol);
						checkMiCondVO.setTrsmTp("MI"); 
						checkMiCondVO.setCgoTpCd(cgoTpCd);	// cgo_tp_cd 컬럼 추가
						miSndCount = dbDao.checkMiTransCount(checkMiCondVO);
						//@ MI 전송 이력이 없으면 에러 처리 *****************************************************************
						if (miSndCount == 0)
						{
							// You must transmit MI file first.
							throw new EventException(new ErrorHandler("BKG01055").getMessage());
						}
					}
					//@ US 도착 전 마지막 POL정보 조회 *****************************************************************
					amsInfoVos = dbDao.searchAmsCode(vvd);
					amsInfoVo = null;
					polLastLoc = "";
					if (amsInfoVos != null && amsInfoVos.size() > 0)
					{
						amsInfoVo = amsInfoVos.get(0);
						polLastLoc = amsInfoVo.getPolLastAms();
					}
					else
					{
						polLastLoc = digit5blank;
					}
					
					//@ B01 BL 정보 조회 *****************************************************************
					blLineInfoVOs = dbDao.searchItType(sTrsmMsgTpCd, blParams, polLastLoc);
					//@ S01,U01,N01 고객 정보 조회 *****************************************************************
					custLineInfoVOs = dbDao.searchCustomer(blParams);
					String gubun = SubSystemConfigFactory.get("BKG.MFT.SERVICE.MODE");
					//@ C01 컨테이너 정보 조회 *****************************************************************
					cntrLineInfoVOs = dbAceDao.searchContainerInfo(blParams, gubun);			// 추가ACE C01
				}
				
				String aiCurrBlNo = "";
				if ( blLineInfoVOs != null ) {
					
					//@ BL 단위로 처리 시작 *****************************************************************
					for (int i = 0; i < blLineInfoVOs.size(); i++)
					{
						blLineInfoVO = blLineInfoVOs.get(i);
						currBlNo = blLineInfoVO.getBlNo();
						
						/*
						 * BL_NO가 12자리가 아닐 겨우에 AI전송시 공백을 채운 12자를 사용
						 * 그 이외에는 trim을한 BL_NO를 사용
						 */
						aiCurrBlNo = currBlNo;
						currBlNo = currBlNo.trim();
						
						bookingPodCd = "";
						fPod = "";

						//@ AI 이면 삭제가 아니면 삭제 후 ADD처리 한다.
						if ("AI".equals(sTrsmMsgTpCd))
						{
							bookingPodCd = blLineInfoVO.getBookingPodCd();
							fPod = blLineInfoVO.getFpodCd();
							
							//@ AI인 경우, flatFile추가. 삭제 처리 D *********************************************************************
							//@ 삭제 A01 D 데이타 생성 *********************************************************************
							flatFile.append("A01SMLM").append(locAmsport).append("D").append(aiCurrBlNo).append("          ")
									.append("03").append("                                            \n");
							lineCount++;
							
							//@ 삭제가 아니면 ADD 처리 A *********************************************************************
							//@ ADD A01 A 데이타 생성 *********************************************************************
							if(!"D".equals(blLineInfoVO.getMfStsCd())) {
								flatFile.append("A01SMLM").append(locAmsport).append("A").append(aiCurrBlNo).append("          ")
										.append("03").append("                                            \n");
								lineCount++;
							}
						}
						
						
						// B01 SetUp.*****************************************************************************************
						// BL별 처리를 위해 같은 BL 체크
						if (currBlNo != null && alreadySentBl.indexOf(currBlNo) < 0)
						{
							alreadySentBl = alreadySentBl + "," + currBlNo;
							itIpiLocal = "";
							itItno = "";
							itItType = "";
							itHub = "";
							cstmsLocCd = "";
							itLstUsa = "";
							amsPort = "";
							delAms = "";
							fdaInd = "";
							wgtVal = "";
							cmdtCd = "";
							cmdtDesc = "";
							itPkgQty = "";
							itPkgAms = "";
							itDel = "";
							amsCode = "";
							mfNo = "";
							
							//@ 삭제 가 아니면 MI,AI 처리 항목 생성
							if (!"D".equals(blLineInfoVO.getMfStsCd()) && ("MI".equals(sTrsmMsgTpCd) || "AI".equals(sTrsmMsgTpCd)))
							{
								if (dbDao.searchIsf5(currBlNo) > 0)
								{
									isf5 = "Y";
								}
								else
								{
									isf5 = "N";
								}
								if (blLineInfoVO != null)
								{
									itItno = blLineInfoVO.getItItno();
									itItType = blLineInfoVO.getItIttype();
									mfNo = blLineInfoVO.getMfNo();
									amsCode = blLineInfoVO.getAmsCode();
									
									// 마스터 BL의 갯수를 확인하기 위함.
									if ("X".equals(mfNo)) {
										blCntExceptHouse++;
									}
									
									if (amsCode == null || amsCode.length() < 4)
									{
										amsCode = digit4blank;
									}
									b01 = blLineInfoVO.getB01();
									blLineInfoVO.getB01isf5();
									
									/* 20100226 경종윤
									 * MI, AI FLATFILE에서 ISF5관련 B01 라인에  b01Isf5값 셋팅을 제거한다. 
									if (isf5.equals("Y"))
									{
										b01 = b01Isf5;
									}
									*/
									
									if (sTrsmMsgTpCd.equals("AI"))
									{
										//@ Master In-bond Indicator 셋업
										//Master In‑bond Indicator
										//0 or space =  not MIB
										//1 = MIB
										b01 = b01.substring(0, 48);
										
										//@ Master BL
										if (itItno.indexOf("V5N") >= 0 && mfNo.equals("X"))
										{
											b01 = new StringBuffer(b01).append("1            ").append(digit2blank)
													.append(digit4blank).append("             \n").toString();
										
										//@ House BL In-bond
										}else if (itItno.indexOf("V5N") >= 0 && !mfNo.equals("X"))
										{
											b01 = new StringBuffer(b01).append("                                \n")
													.toString();
										
										//@ Itno생성 안됐거나 보세운송이 아닌경우
										}else{ 
											itItType = "  "; // 2자리
											amsCode  = "    "; // 4자리
											b01 = new StringBuffer(b01).append("0            ").append(itItType).append(
													amsCode).append("             \n").toString();
										}
									}
									flatFile.append(b01);
									lineCount++;
									flatFile.append(blLineInfoVO.getB02());
									lineCount++;
									//@  HOUSE B/L
									if (!"X".equals(mfNo)) {
										flatFile.append(blLineInfoVO.getB04());
										lineCount++;
									} 
									
									/*
									 * SPLIT 된 BL을 FLATFILE에 추가한다.
									 * 조건 : PRE_MF_NO값이 존재하고, 전송 후 ACK를 받은 적이 있는 경우
									 * => "B04OL SMLM" || PRE_MF_NO
									 */
									preMfCnt = dbDao.searchPreMF(currBlNo);
									if (!"0".equals(preMfCnt))
									{
										flatFile.append(blLineInfoVO.getB042());
										lineCount++;
									}
									/* 20100226 경종윤
									 * MI, AI FLATFILE에서 ISF5관련 B04 라인을 제거한다.
									if (isf5.equals("Y"))
									{
										flatFile.append(blLineInfoVO.getB04isf5());
										lineCount++;
										lineCount++;
									}
									*/
									downLoadBC.modifyTransStage(currBlNo, sTrsmMsgTpCd);
									
									log.debug("sTrsmMsgTpCd ============================================");
									/*********************************************
									 * // AI 전송 후 AI 전송 대상  FLAT UPDATE
									 *********************************************/
									if ("AI".equals(sTrsmMsgTpCd)) {
										// HOSTORY BCImpl - mbl, hbl ai flag update
										bkgDocProcSkdVO = new BkgDocProcSkdVO();
										bkgDocProcSkdVO.setBkgDocProcTpCd("AI_SND");
										bkgDocProcSkdVO.setBkgNo(currBlNo);
										
										if(!"X".equals(mfNo)) {
											bkgDocProcSkdVO.setDiffRmk(mfNo);
										} else {
											bkgDocProcSkdVO.setDiffRmk("");
										}
										bkgDocProcSkdVO.setUpdUsrId(usrId);
										bkgHisBC.manageDocProcAIFlag(mfNo, bkgDocProcSkdVO);
									}
										
									log.debug("sTrsmMsgTpCd ============================================ end");
	
									itIpiLocal = blLineInfoVO.getItIpiLocal();
									itHub = blLineInfoVO.getItHub();
									cstmsLocCd = blLineInfoVO.getCstmsLocCd();
									itLstUsa = blLineInfoVO.getItLstUsa();
									wgtVal = blLineInfoVO.getWgtVal();
									cmdtCd = blLineInfoVO.getCmdtCd();
									cmdtDesc = dbDao.searchCmdtDesc(cmdtCd);
									if (cmdtDesc == null || cmdtDesc.equals(""))
										cmdtDesc = " ";
									tmpBuf = new StringBuffer(cmdtDesc);
									for (idx = cmdtDesc.length(); idx < 45; idx++)
									{
										tmpBuf.append(" ");
									}
									cmdtDesc = tmpBuf.toString();
									itPkgQty = blLineInfoVO.getItPkgQty();
									itPkgAms = blLineInfoVO.getItPkgAms();
									itDel = blLineInfoVO.getItDel();
								}
								// CustLine 정보는 루프를 돌기전에 이미 구해놓았다.
								// custLineInfoVO 초기화.
								custLineInfoVO = null;
								
								//@ 같은 BL번호에 대한 custLineInfoVO 를 구함.
								//@ 매 BL 별 custLineInfoVOs 전체를 반복해서 검색하므로 BL별 검색하는 로직으로 수정 필요해 보임. 
								for (int k = 0; k < custLineInfoVOs.size(); k++)
								{
									if (currBlNo.equals(custLineInfoVOs.get(k).getBlNo()))
									{
										custLineInfoVO = custLineInfoVOs.get(k);
									}
								}

								if (custLineInfoVO != null)
								{
									flatFile.append(String.format("%-80s",custLineInfoVO.getBuf21()).substring(0, 80)).append("\n");
									lineCount++;
									flatFile.append(String.format("%-80s",custLineInfoVO.getBuf211()).substring(0, 80)).append("\n");
									lineCount++;
									buf22 = custLineInfoVO.getBuf22();
									if (buf22 != null && buf22.length() > 3)
									{
										flatFile.append(String.format("%-80s",buf22).substring(0, 80)).append("\n");
										lineCount++;
									}
									flatFile.append(String.format("%-80s",custLineInfoVO.getBuf23()).substring(0, 80)).append("\n");
									lineCount++;
									flatFile.append(String.format("%-80s",custLineInfoVO.getBuf231()).substring(0, 80)).append("\n");
									lineCount++;
									buf24 = custLineInfoVO.getBuf24();
									if (buf24 != null && buf24.length() > 3)
									{
										flatFile.append(String.format("%-80s",buf24).substring(0, 80)).append("\n");
										lineCount++;
									}
									flatFile.append(String.format("%-80s",custLineInfoVO.getBuf25()).substring(0, 80)).append("\n");
									lineCount++;
									flatFile.append(String.format("%-80s",custLineInfoVO.getBuf251()).substring(0, 80)).append("\n");
									lineCount++;
									buf26 = custLineInfoVO.getBuf26();
									if (buf26 != null && buf26.length() > 3)
									{
										flatFile.append(String.format("%-80s",buf26).substring(0, 80)).append("\n");
										lineCount++;
									}
									buf27 = custLineInfoVO.getBuf27();								
									if (buf27 != null)
									{					
										List<UsaCustomerInfoVO> custLineInfoVO27s = dbDao.searchCstmsPartyInfo(currBlNo);
										for (int m = 0; m < custLineInfoVO27s.size(); m++)
										{											
											flatFile.append(String.format("%-80s",custLineInfoVO27s.get(m).getBuf27()).substring(0, 80)).append("\n"); 
											lineCount++;										
										}																																
									}									
									/* 20100226 경종윤
									 * MI, AI FLATFILE에서 ISF5관련  라인을 제거한다.
									if (isf5.equals("Y"))
									{
										flatFile.append(custLineInfoVO.getBkpIsf5());
										lineCount = lineCount + 3;
										flatFile.append(custLineInfoVO.getStpIsf5());
										lineCount = lineCount + 3;
									}
									*/
									//@ I01 Setup. In-bond 운송 셋업 
									if (sTrsmMsgTpCd.equals("AI") && "I".equals(itIpiLocal) && itItno.indexOf("V5N") >= 0
											&& "X".equals(mfNo))
									{
										locCd = "";
										if ("61".equals(itItType))
										{
	//										locCd = itHub;
											locCd = cstmsLocCd;
										}
										else if ("62".equals(itItType))
										{
											locCd = itLstUsa;
										}
										else if ("63".equals(itItType))
										{
											locCd = pod;
											//locCd = fPod;
										}
										else
										{
											itItType = "  ";
										}
										amsPort = dbDao.searchPodAmsCode(locCd);
	
										/*
										 * delAms는 62,63일 경우 I01항목의 Foreign Destination가 됨
										 * 61일 경우 공백. 
										 * 20100303 경종윤 수정
										 * booking.pod와 fPod가 틀리면 fPod값으로 코드값 조회
										 * 아니면 기존 로직 수행
										 */
										delAms = digit5blank;
										//@ 세관 POD와 BKG POD가 다를 경우 세관쪽 정보 우선 
										if(!bookingPodCd.equals(fPod)) {
											if("62".equals(itItType) || "63".equals(itItType)) {
												delAms = dbDao.searchPodAmsCode(fPod);
											} 
										} else {
											if("62".equals(itItType)) {
												delAms = dbDao.searchPodAmsCode(itHub);//HUB_LOC_CD
											} else if("63".equals(itItType)) {
												//@ POD.LOC_AMS_PORT_CD > POD.SCC.LOC_AMS_PORT_CD >> DECODE(SUBSTR(B.DEL_CD, 1, 2), 'MX', '20195', 'CA', '13400') 
												delAms = dbDao.searchDelAms(itItType, currBlNo, itHub);
											}
										}
										
										fdaInd = dbDao.searchFdaInfo(currBlNo);
										tmpBuf = new StringBuffer(itItno);
										for (idx = itItno.length(); idx < 11; idx++)
										{
											tmpBuf.append(" ");
										}
										itItno = tmpBuf.toString();
										flatFile.append("I01").append(itItType).append(fdaInd).append(digit10blank).append(
												"SMLM").append(amsPort == null || "".equals(amsPort) ? digit4blank : amsPort).append(
												delAms == null || "".equals(delAms) ? digit5blank : delAms).append(wgtVal)
												.append(IRS_NO).append(itItno).append(digit20blank).append("\n");
										lineCount++;
									}
								}
								// Container Info..
								usaCmVOsForIsf = new ArrayList<UsaCMVO>();
								cntrCountPerBl = 0;
								if (cntrLineInfoVOs != null && cntrLineInfoVOs.size() > 0)
								{
									for (int c = 0; c < cntrLineInfoVOs.size(); c++)
									{
										cntrLineInfoVO = null;
										if (currBlNo.equals(cntrLineInfoVOs.get(c).getBlNo()))
										{
											cntrLineInfoVO = cntrLineInfoVOs.get(c);
										}
										if (cntrLineInfoVO != null)
										{
											flatFile.append(cntrLineInfoVO.getBuf3());
											cntrCountPerBl++;
											lineCount++;
											cntrNo = cntrLineInfoVO.getCntrNo();
											cntrMfLineInfoVOs = dbDao.searchCMInfo(currBlNo, cntrNo, cmdtDesc);
											if (cntrMfLineInfoVOs == null || cntrMfLineInfoVOs.size() == 0)
											{
												if (itPkgQty == null || itPkgQty.equals(""))
													itPkgQty = "0";
												
												itPkgQty = String.format("%010d", Integer.parseInt(itPkgQty));
												
												if (itPkgAms == null || itPkgAms.equals(""))
													itPkgAms = " ";
												
												itPkgAms = String.format("%-5s", itPkgAms);
												
												flatFile.append("D01").append(itPkgQty).append(itPkgAms).append(String.format("%-62s", " ")).append("\n");
												
												lineCount++;
	
												flatFile.append(String.format("%-80s","D02NO MARKS")).append("\n");
												lineCount++;
											}
											else
											{
												for (int k = 0; k < cntrMfLineInfoVOs.size(); k++)
												{
													usaCmVOsForIsf.add(cntrMfLineInfoVOs.get(k));
													icmHtCd = cntrMfLineInfoVOs.get(k).getIcmHtCd();
													icmWgtQty = cntrMfLineInfoVOs.get(k).getIcmWgtQty();
													icmWgtVal = cntrMfLineInfoVOs.get(k).getIcmWgtVal();
													icmWgtTp = cntrMfLineInfoVOs.get(k).getIcmWgtTp();
													icmPkgQty = cntrMfLineInfoVOs.get(k).getIcmPkgQty();
													icmDesc = cntrMfLineInfoVOs.get(k).getIcmDesc();
													cmdSeq = cntrMfLineInfoVOs.get(k).getCmdSeq();
	
													if (icmWgtTp == null || icmWgtTp.equals("")) icmWgtTp = " ";
													icmWgtTp = String.format("%-2s", icmWgtTp);
	
													if (icmHtCd != null && icmHtCd.length() > 1 && icmWgtQty != null
															&& icmWgtQty.length() > 0)
													{
														icmHtCd = String.format("%-10s", icmHtCd)+" ";			// 추가ACE 10자리+space
														
														if(icmWgtVal == null || icmWgtVal.equals("")) icmWgtVal = "0";
														icmWgtVal = String.format("%08d", Integer.parseInt(icmWgtVal));
														
														if(icmWgtQty == null || icmWgtQty.equals("")) icmWgtQty = "0";
														icmWgtQty = String.format("%010d", Integer.parseInt(icmWgtQty));
														
														flatFile.append("D00").append(icmHtCd).append(icmWgtVal).append(
																icmWgtQty).append(icmWgtTp).append(String.format("%-46s", " ")).append("\n");	// 추가ACE
														
														lineCount++;
													}
													if (icmPkgQty == null || icmPkgQty.equals(""))
														icmPkgQty = "0";
													icmPkgQty = String.format("%010d", Integer.parseInt(icmPkgQty));
	
													if (icmDesc == null || icmDesc.equals(""))
														icmDesc = " ";
													icmDesc = String.format("%-45s", icmDesc);
	
													flatFile.append("D01").append(icmPkgQty).append(icmDesc).append(String.format("%-22s", " ")).append("\n");
													lineCount++;
													// proC의 if (strncmp(cmdSeq[i].arr,"00",2) != 0)라인구현
													if (cmdSeq != null && cmdSeq.indexOf("00") != 0)
													{
														cmdMarkVO = dbDao.searchCmMark(currBlNo, cntrNo, cmdSeq);
														cmdMarkAll = cmdMarkVO.getCmdMarkAll();
														cmdMarkLen = cmdMarkVO.getCmdMarkLen();
														// proC의 if(strncmp(itDel.arr,"MX",2) == 0) { 라인구현
														if (itDel != null && itDel.indexOf("MX") == 0)
														{
															cmdMarkAll = "IN TRANSIT TO MEXICO";
															cmdMarkLen = Integer
																	.toString((Integer.parseInt(cmdMarkLen) + 20));
														}
														// cmdMarkAll = "1234567890123456789012345\nABCDEFGHIJKLMNOPQRSTUVWXYZ\n12345";
														//@ 첫번째 행의 개행문자 위치를 가져온다.
														//@ cmdMark 처리를 개행문자로 SPLIT하면 아래 소스 코드들이 좀 더 직관적일 수 있을 듯하다.
														//@ cmdMarkAll.split("\n") 해서 for문 처리를 하면 직관적인일 수 있다. 
														int nrIdx = cmdMarkAll.indexOf("\n");
														cmdMarkNew = "";
														String tmp2 = "";
														String tmp3 = cmdMarkAll;
														for (; nrIdx >= 0;)
														{
															if (nrIdx < 23)
															{
																//@ 진행 중인 행에서 23보다 작으면, 그다음 행 처리를 위한 작업을 한다.
																//@ 진행 중인 행의 개행문자를 공백 처리하여 개행문자를 없앤다.
																tmp3 = tmp3.replaceFirst("\n", " ");
																//@ 진행 중인 행의 나머지 문자열을 가져온다.
																tmp2 = tmp3.substring(0, nrIdx);
																//@ 23개 문자열을 만들기 위해 부족한 부분을 공백으로 채운다.
																tmp2 = String.format("%-23s", tmp2);
																
																//@ 처리해야할 문자열을 임시 변수에 할당한다.    
																tmp3 = tmp3.substring(nrIdx + 1);
																//@ 처리한 문자열을 합친다.
																cmdMarkNew = cmdMarkNew + tmp2;
																//@ 다음 행의 문자열 수를 할당한다.
																nrIdx = tmp3.indexOf("\n");
															}
															else
															{
																//@ 23개씩 D02 기초 데이타 만듬.
																tmp2 = tmp3.substring(0, 23);
																//@ 그다음 처리할 문자열-23번째 문자 이후 문자열
																tmp3 = tmp3.substring(23);
																//@ 처리한 문자열을 합친다. 
																cmdMarkNew = cmdMarkNew + tmp2;
																//@ 행전체 문자개수에서 처리 단위인 23을 뺀다.
																nrIdx = nrIdx - 23;
															}
														}
														
														//@ 마지막 라인의 경우 개행문자가 없으므로 처리되지 않는다. 마지막 행을 처리한다.
														//@ 마지막 행이 23개가 넘어도 23개가 넘어도 23씩  처리 안하는 것은 아래에서 23씩 다시 처리를 한다.
														//@ 23개가 안되면 공백으로 채운다.
														if (tmp3.length() > 0)
														{
															tmp3 = String.format("%-23s", tmp3);
															cmdMarkNew = cmdMarkNew + tmp3;
														}
														//@ 여기까지 처리 결과
														// "1234567890123456789012345                     ABCDEFGHIJKLMNOPQRSTUVWXYZ                    12345                  "
														// log.info(cmdMarkNew);
														lineCnt = 0;
														lineCnt = (int) Math.floor((cmdMarkNew.length() + 22) / 23);
														kk = 0;
														if (lineCnt == 0)
														{
															flatFile.append(String.format("%-80s", "D02NO MARKS")).append("\n");
															lineCount++;
														}
														cmdMark = "";
														for (j = 0; j < lineCnt; j++)
														{
															cmdMark = "";
															cmdMark = cmdMarkNew.substring(kk, kk + 23);
															kk = kk + 23;
															tmpBuf = new StringBuffer(cmdMarkNew);
															if (kk + 23 > cmdMarkNew.length())
															{
																for (idx = cmdMarkNew.length(); idx < kk + 23; idx++)
																{
																	tmpBuf.append(" ");
																}
																cmdMarkNew = tmpBuf.toString();
															}
															
															/*
															 * 2010년 2월 19일 경종윤
															 * 
															 * CMDT_GDS_SEQ가 1번부터가 아닐 수 있으므로 (!cmdSeq.equals("1")) => (k!= 0)로 변경함 
															 */
															//@ 라인전체가 공백이면 D02 항목을 생성하지 않는다.
															if (  //(cmdMark.indexOf("NO MARKS") == 0 && k!=0)
																(cmdMark.equals(String.format("%-23s", " "))))
															{
																continue;
															}
															//@ 마지막 행이 26라인이라면 마지막 3개 문자는 나머지를 공백으로 채운다.
															//@ ABCDEFGHIJKLMNOPQRSTUVWXYZ 이 문자열이 마지막 행이라면 XYZ와 공백20로 마지막행이 구성된다.
															cmdMark = String.format("%-23s", cmdMark);
															
															flatFile.append("D02").append(cmdMark).append(String.format("%-54s", " ")).append("\n");
															lineCount++;
														} // for
														
														/* 결과 코드
														 * D0212345678901234567890123
														 * D0245
														 * D02ABCDEFGHIJKLMNOPQRSTUVW
														 * D02XYZ
														 * D0212345                                                                        
														 * */
													}
													else
													{
														flatFile.append(String.format("%-80s", "D02NO MARKS")).append("\n");
														lineCount++;
													}
												}// for mf.
												mbl = "";
												if (!mfNo.equals("X"))
												{
													mbl = mfNo;
												}
												else
												{
													mbl = currBlNo;
												}
												dgUnnoVOs = dbDao.searchDgUnNo(mbl, cntrNo);
												if (dgUnnoVOs != null && dgUnnoVOs.size() > 0)
												{
													for (int g = 0; g < dgUnnoVOs.size(); g++)
													{
														dgUnno = dgUnnoVOs.get(g).getDgUnno();
														if (dgUnno == null || dgUnno.equals(""))
															dgUnno = " ";
														dgUnno = String.format("%-10s", dgUnno);
														flatFile.append("V01");
														flatFile.append(dgUnno);
														flatFile.append(String.format("%-4s", " "));
														// Hazardous Material Code Qualifier
														flatFile.append("U");
														flatFile.append(String.format("%-62s", " "));
														flatFile.append("\n");
														lineCount++;
													}
												}
											}
										}
									}// for - cntrLine
								}// if
							}
							else if ("TI".equals(sTrsmMsgTpCd))
							{
								/*
								 * 마스터 BL의 갯수를 확인하기 위함. (P01 KEY에 마스터 BL 갯수가 안나와서 추가함)
								 * 2010-02-04 경종윤
								 */
								if ("X".equals(blLineInfoVO.getMfNo())) {
									blCntExceptHouse++;
								}
	
								tiContVo = dbDao.searchTiTrsmContentVO(currBlNo, IRS_NO);
								tFirmsCode = tiContVo.getTFirmsCode();
								tBondCarrier = tiContVo.getTBondCarrier();
								flatFile.append("T01").append(currBlNo).append("              ").append(tFirmsCode).append(
										tBondCarrier).append("                                   \n");
								lineCount++;
								downLoadBC.modifyTiInfo(currBlNo, usrId, ofcCd);
							}
							realSentBlCnt++;
							/**********************************************************************
							 * 2009/10/22 김도완. as-is 의 하기 사항 컨버젼.(ams_isf5)
							 * ----------------------------------------------------- 20090915 JHPARK 미세관 10+2 ISF-5 신고 전송 기능
							 * 개발 Importer Security Filing 미세관이 현재 신고항목이외에 추가 정보 전송을 요구함. 수입업자에 대한 10가지 정보를 요구하지만 (ISF-10),
							 * 수입업자가 미주안에 존재하지 않는 FROB, 62(T&E), 63(IE) 에 대해서는 선사가 신고해야 한다.
							 * ----------------------------------------------------- isf5 - B/L단위로 isf5인 경우, amsIsf5()를
							 * 구동시킨다. 따라서, bl loop의 가장 하단에 해당 내용을 적용시킨다. - MI는 항상. - AI는 버튼을 따로 만들어서 판단.(이 부분은 아직 미정) - AI는
							 * isf 판단여부가 파라미터로 받음. -> MI처럼 내부 판단로직을 적용하는지 여부. 만약, 적용대상이 아니면, 리턴. -> 리턴 값을 어떤식으로 던져야 하는지...
							 * com_err_msg에 err_code를 등록?
							 **********************************************************************/
							if ("MI".equals(sTrsmMsgTpCd) && isf5.equals("Y"))
							{
								// usaManifestTransmitVO 파라미터로 넘어온 배열값중 첫번째 값. vvd, pod등을 쓰기 위함.
								// blLineInfoVO bl조회한 결과.
								// usaCmVOsForIsf 컨테이너 CM정보리스트.
								// bl별 컨테이너 갯수.
	//							amsIsf5(usaManifestTransmitVO, blLineInfoVO, usaCmVOsForIsf, cntrCountPerBl);
								usaManifestTransmitVO.setBlNo(currBlNo);
								this.amsIsf5(usaManifestTransmitVO);
							}
							
	//						2010.09.09 최도순 [CHM-201005692] AI 전송시 ISF-5 자동 전송 요청
							if ("AI".equals(sTrsmMsgTpCd) && isf5.equals("Y") && dbDao.searchIsf5SndLog(currBlNo) == 0)
							{
								usaManifestTransmitVO.setBlNo(currBlNo);
								this.amsIsf5(usaManifestTransmitVO);
							}
							 
						}// currBlNo is not null.
					} // end for(int i = 0; i < blLineInfoVOs.size(); i++)
				} // end for blLineInfoVOs is not null
				
				UsaMiHiHeadFootCondVO htCndVo = new UsaMiHiHeadFootCondVO();
				htCndVo.setBlCnt(Integer.toString(realSentBlCnt));
				htCndVo.setLineCount(Integer.toString(lineCount));
				htCndVo.setLocAmsport(locAmsport);
				htCndVo.setTrspMsgTpCd(sTrsmMsgTpCd);
				htCndVo.setVpsEtaDt(vpsEtaDt);
				htCndVo.setVslEngNm(vslEngNm);
				htCndVo.setVslFlag(vslFlag);
				htCndVo.setVslLloyd(vslLloyd);
				htCndVo.setVvd(actFileVvd);
				htCndVo.setMasterBlCnt(Integer.toString(blCntExceptHouse));
				htCndVo.setSndDt(lsDate);
				crrBatNo = "SMLM" + vvd + pod + dbDao.searchCarrierBatchNo();
				htCndVo.setCrrBatNo(crrBatNo);
				UsaMiHiHeaderFooterVO htVo = null;
				htVo = dbAceDao.searchMiHiHeaderFooter(htCndVo);			// 추가ACE P01 M01
				buf7 = htVo.getHeader();
				buf8 = htVo.getFooter();
				hiFile02 = new StringBuffer();
				hiFile02.append(buf7).append(flatFile.toString()).append(buf8);
				flatFile = new StringBuffer(buf6).append(hiFile02.toString());
				/*********************************************
				 * // Flat File Gen End.
				 *********************************************/
				/*******************************************************/
				/* MI 인경우만 MI ETA INSERT 2001.1.29 */
				/*******************************************************/
				sndLogVo.setCntCd("US");
				sndLogVo.setIoBndCd("I");
				sndLogVo.setSndDt(lsDate);
				sndLogVo.setHisSeq(dbDao.searchSndLogNextHisSeq("US", "I", lsDate, sTrsmMsgTpCd));
				sndLogVo.setTrsmMsgTpId(sTrsmMsgTpCd);
				sndLogVo.setVvd(vvd);
				sndLogVo.setPolCd(pol);
				sndLogVo.setPodCd(pod);
				sndLogVo.setVslDepRptFlg("N");
				sndLogVo.setAutoVslDepRptFlg("N");
				sndLogVo.setSndUsrId(usrId);
				sndLogVo.setSndUsrOfcCd(ofcCd);
				sndLogVo.setAckTpNo("");
				sndLogVo.setCreUsrId(usrId);
				sndLogVo.setUpdUsrId(usrId);
				sndLogVo.setEtaDt(vpsEtaDt);
				sndLogVo.setEtaDtFormat("MMDDRR");
				if (sTrsmMsgTpCd.equals("MI") && miSndCount < 1)
				{
					dbDao.addVslEta(sndLogVo);
				}
				/*********************************************
				 * // Log Add Start.
				 *********************************************/
				sndLogVo.setActFileSkdDirCd(actFileSkdDirCd);
				sndLogVo.setCrrBatNo(crrBatNo);				
				sndLogVo.setCstmsPortCd(cstmsPortCd);		//  CSTMS_PORT_CD 칼럼 추가
				sndLogVo.setCgoTpCd(cgoTpCd);				//  CGO_TP_CD 칼럼 추가
				
				// INBOND_SLOGP table에 전송 결과 입력
				dbDao.addSendLog(sndLogVo);
				// INBOND_SLOG_DETAIL table에 전송 결과 입력
				// 이전 소스는 전송내용을 한번에 로그테이블에 입력했으나, 라인단위로 입력하는 것으로 수정.
				// sndLogVo.setEdiSndLogCtnt(hiFile02.toString());
				// dbDao.addSendLogDetail(sndLogVo);
				// 2000byte씩 잘라서 넣는 로직에서 한 라인씩 넣는 것으로 수정.
				StringTokenizer token = new StringTokenizer(hiFile02.toString(), "\n");
				int i = 1;
				String tmpStr = "";
				while (token.hasMoreTokens())
				{
					tmpStr = token.nextToken();
					sndLogVo.setDtlSeq(i + "");
					sndLogVo.setEdiSndLogCtnt(tmpStr);
					dbDao.addSendLogDetail(sndLogVo);
					i++;
				}
				/*********************************************
				 * // Log Add End.
				 *********************************************/
				/*********************************************
				 * BKG_CSTMS_ADV_EDI_BL_RSPN
				 *  다수 B/L들이 하나의 CRR_BAT_NO를 통해 전송 되는데,
				 *  B/L별 전송이력 및 수신 결과 체크를 위해  BKG_CSTMS_ADV_EDI_BL_RSPN 테이블에 저장한다.
				 *********************************************/
				sndLogVo.setBlParams(blParams);
				dbDao.addCarrierBatchNo(sndLogVo);
				// 0543(Departure), 0514(Arrival)화면에서 사용.
				
				/*********************************************
				 * // Message Send Start
				 *********************************************/
				sendFlatFileVO.setFlatFile(flatFile.toString());
				flatFileAckVO = command2.sendFlatFile(sendFlatFileVO);
				if (flatFileAckVO.getAckStsCd().equals("E"))
					throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
				/*********************************************
				 * // Message Send End.
				 *********************************************/
				
			}
			else if ("HI".equals(sTrsmMsgTpCd))
			{
				flatFile = new StringBuffer();
				StringBuffer hiFile01 = new StringBuffer();
				hiFile02 = new StringBuffer();
				UsaManifestListCondForEdiVO[] usaManifestListCondForEdiVOs = (UsaManifestListCondForEdiVO[]) manifestTransmitVO;
				UsaManifestListCondForEdiVO vo = null;
				String tmpstr1 = "";
				String tmpstr6 = "";
				String tmpstr7 = "";
				String tmpstr8 = "";
				String edaOnMi = "";
				String polLoc = "";
				String podLoc = "";
				String blCount = "";
				String tmpstr2 = "";
				String podAmsPortcd = "";		// tmpstr2값
				String vpsEtaDtA = "";
				String vpsEtdDt = "";
				String tmpStr = "";
				
				
				boolean edaYn = false;
				// VALIDATION CHECK.
				for (int mainIdx = 0; mainIdx < usaManifestListCondForEdiVOs.length; mainIdx++)
				{
					vo = usaManifestListCondForEdiVOs[mainIdx];
					polLoc = vo.getPolCd();
					vvd = vo.getVvd();
					usrId = vo.getUsrId();
					ofcCd = vo.getOfcCd();
					podLoc = vo.getPodCd();
					blCount = vo.getBlCount();
					// EDA 전송일 경우, 0233화면으로 부터 EDA_On_MI 데이터가 전달된다.
					// 이 로직은 기존, HI Arrival 전송과 조금 다르다.
					edaYn = false;
					if ("ESM_BKG_0233".equals(vo.getPageNo()))
					{
						edaYn = true;
					}
					edaOnMi = vo.getEtaTime();
					lsDate = "";
					tmpstr1 = "";
					tmpstr6 = "";
					tmpstr7 = "";
					tmpstr8 = "";
					vslFlag = "";
					vslEngNm = "";
					vslLloyd = "";
					tmpstr2 = ""; // ams port
					podAmsPortcd = "";		// tmpstr2 값
					vpsEtaDt = vo.getEta();
					miSndCount = 0;
//					if (polLoc == null || polLoc.length() < 5)
//					{
//						checkMiCondVO.setVvd(vvd);
//						checkMiCondVO.setPod(podLoc);
//						checkMiCondVO.setPol(null);
//						checkMiCondVO.setTrsmTp("MI");
//						miSndCount = dbDao.checkMiTransCount(checkMiCondVO);
//						if (miSndCount == 0)
//						{
//							// You must transmit MI file first.
//							throw new EventException(new ErrorHandler("BKG01055").getMessage());
//						}
//					}
					// EDA 전송건일 경우, Server Date < EDA on MI - 5 체크.
					if (edaYn)
					{
						if (dbDao.searchMiDiff(edaOnMi) == 0)
						{
							// [$s][$s] can not pass following condition:\n i. Current U.S. Server Date < EDA on MI - 5
							// Days
							throw new EventException(new ErrorHandler("BKG06001", new String[] { vvd, podLoc })
									.getMessage());
						}
						// EDA의 경우, vpsEtaDt는 yyyy-mm-dd hh24:mi:ss 형식으로 들어온다.
						if (dbDao.searchEtaDiff(vpsEtaDt) == 0)
						{
							// [$s][$s] can not pass following condition:\n i. Current U.S. Server Date < EDA on MI - 5
							// Days
							throw new EventException(new ErrorHandler("BKG06002", new String[] { vvd, podLoc })
									.getMessage());
						}
					}
				}
				for (int mainIdx = 0; mainIdx < usaManifestListCondForEdiVOs.length; mainIdx++)
				{
					
					
					flatFile = new StringBuffer();
					hiFile01 = new StringBuffer();
					hiFile02 = new StringBuffer();
					sndLogVo = new SendingLogVO();
					vo = usaManifestListCondForEdiVOs[mainIdx];
					polLoc = vo.getPolCd();
					vvd = vo.getVvd();
					usrId = vo.getUsrId();
					ofcCd = vo.getOfcCd();
					podLoc = vo.getPodCd();
					blCount = vo.getBlCount();

					actFileSkdDirCd = dbDao.searchActDirCd(vvd, polLoc, podLoc, "MI");
					
					/*
					 * mi전송로그에 있는 act_file_skd_dir_cd글 대상으로 Actual File VVD를 판단한다.
					 */
					if("E".equals(actFileSkdDirCd)) {
						actFileVvd = vvd.substring(0, 8) + actFileSkdDirCd;
					} else {
						actFileVvd = vvd;
						actFileSkdDirCd = vvd.substring(8, 9);
					}
					
					
					// EDA 전송일 경우, 0233화면으로 부터 EDA_On_MI 데이터가 전달된다.
					// 이 로직은 기존, HI Arrival 전송과 조금 다르다.
					edaYn = false;
					if ("ESM_BKG_0233".equals(vo.getPageNo()))
					{
						edaYn = true;
					}
					edaOnMi = vo.getEtaTime();
					lsDate = "";
					tmpstr1 = "";
					tmpstr6 = "";
					tmpstr7 = "";
					tmpstr8 = "";
					vslFlag = "";
					vslEngNm = "";
					vslLloyd = "";
					tmpstr2 = ""; 		// ams port
					podAmsPortcd = ""; 	// podAmsPortcd 값
					vpsEtaDt = vo.getEta();
					if (vpsEtaDt != null && vpsEtaDt.length() >= 8)
					{
						// 만약, - 구분자가 있다면 제거한다.
						// yyyy-mm-dd hh24:mi:ss 이런식으로 들어왔을 경우.
						// yyyymmdd hh24:mi:ss 이런식으로 나오게 된다.
						if (vpsEtaDt.indexOf("-") >= 0)
						{
							StringTokenizer tk = new StringTokenizer(vpsEtaDt, "-");
							StringBuffer sb = new StringBuffer();
							while (tk.hasMoreTokens())
							{
								sb.append(tk.nextToken());
							}
							vpsEtaDt = sb.toString();
						}
						// yyyymmdd 에서 mmddrr로 format변경.
						vpsEtaDt = new StringBuffer(vpsEtaDt.substring(4, 8)).append(vpsEtaDt.substring(2, 4))
								.toString();
					}
					if (edaYn && edaOnMi != null)
					{
						// 만약, - 구분자가 있다면 제거한다.
						if (edaOnMi.indexOf("-") >= 0)
						{
							StringTokenizer tk = new StringTokenizer(edaOnMi, "-");
							StringBuffer sb = new StringBuffer();
							while (tk.hasMoreTokens())
							{
								sb.append(tk.nextToken());
							}
							edaOnMi = sb.toString();
							// yyyymmdd 에서 mmddrr로 format변경.
							edaOnMi = new StringBuffer(edaOnMi.substring(4, 8)).append(edaOnMi.substring(2, 4))
									.toString();
						}
					}
					vpsEtaDtA = "";
					// String vps_call_ind = "";
					vpsEtdDt = "";
					lsDate = dbDao.searchSysdate("ddmmrrhh24miss");
					/*********************************************
					 * // Flat File Gen Start.
					 *********************************************/
					// [USACUSKEWB0029EUSTIWNGOBS AUTO_HI 1018020090419040121HI
					UsaTrsmFirstHeadVO firstHeadVO = new UsaTrsmFirstHeadVO();
					firstHeadVO.setVvd(actFileVvd);
					firstHeadVO.setPodCd(podLoc);
					firstHeadVO.setOfcCd(ofcCd);
					firstHeadVO.setUsrId(usrId);
					firstHeadVO.setLsDate(lsDate);
					firstHeadVO.setFormat("ddmmrrhh24miss");
					firstHeadVO.setTrspMsgTpCd(sTrsmMsgTpCd);
					
					//@ 헤더 >> EDI 에서 전송시 사용하지는 않는 듯 함. 
					tmpstr1 = dbDao.searchTrsmFirstHeader(firstHeadVO);
					// Vsl_cd가 등록된 국가코드,영문이름 정보를 조회한다.
					MdmVslCntrVO mdmVslCntrVO = dbDao.searchVslInfo(vvd);
					if (mdmVslCntrVO == null || mdmVslCntrVO.getVslCd() == null)
					{
						if(!usrId.equals("AUTO_HI") && !usrId.equals("AUTO_IBD_HI")) {
							// Vessel Info. Data Not Found
							throw new EventException(new ErrorHandler("BKG01052").getMessage());
						} else {
							log.error(new ErrorHandler("BKG01052").getMessage());
							continue;
						}
					}
					vslFlag = mdmVslCntrVO.getVslRgstCntCd();
					vslEngNm = mdmVslCntrVO.getVslEngNm();
					vslLloyd = mdmVslCntrVO.getLloydNo();
					if (vslLloyd == null)
					{
						//vslLloyd = "       ";
						vslLloyd = String.format("%-7s", " ");
						// EDA가 아닌 경우, 추가 로직이 있음.
					}
					else if (!edaYn
							&& (vslLloyd.equals("9124524") || vslLloyd.equals("8918945") || vslLloyd.equals("9183489")))
					{
						//vslLloyd = "       ";
						vslLloyd = String.format("%-7s", " ");
					}
					if (!edaYn && tmpstr1.indexOf("BLSE") == 0)
					{
						if (Integer.parseInt(tmpstr1.substring(4, 8)) > 839)
						{
							vslFlag = "PA";
						}
						else
						{
							vslFlag = "LR";
						}
					}
					
					/*
					 * 20100422 경종윤
					 * podLoc이 "US"가 아니면 CSTMS_PORT_CD로 ams code를  조회한다.
					 * 아니면 원래 podLoc으로 ams Code를 조회한다. 
					 */
					if(!podLoc.startsWith("US")) {
						tmpstr2 = dbDao.searchPodAmsCode(dbDao.searchCstmsPortCd(vvd, polLoc, podLoc));
						cstmsPortCd = dbDao.searchCstmsPortCd(vvd, polLoc, podLoc);
					} else {
						tmpstr2 = dbDao.searchPodAmsCode(podLoc);
						cstmsPortCd = podLoc;
					}
															
					String amsTmlCd = dbDao.searchCstmsPortTmlCd(vvd, polLoc, podLoc);
					if(amsTmlCd != null && !amsTmlCd.equals("")){						
						tmpstr2 = amsTmlCd;						
					}												
									
					podAmsPortcd = tmpstr2;					
					
					if (tmpstr2 == null || tmpstr2.equals(""))
					{
						if(!usrId.equals("AUTO_HI") && !usrId.equals("AUTO_IBD_HI")) {
							// Location AMS code Data Not Found.
							throw new EventException(new ErrorHandler("BKG01056").getMessage());
						} else {
							log.error(new ErrorHandler("BKG01056").getMessage());
							continue;
						}
						
					}
					if (vpsEtaDt == null || vpsEtaDt.equals(""))
					{
						EtaCondAtAdvancedVO etaCondAtAdvancedVO = new EtaCondAtAdvancedVO();
						etaCondAtAdvancedVO.setVvd(vvd);
						etaCondAtAdvancedVO.setPod(podLoc);
						EtaDetailAtAdvancedVO etaDetailAtAdvancedVO = dbDao.searchEtaFromAdvanced(etaCondAtAdvancedVO);
						vpsEtaDt = etaDetailAtAdvancedVO.getEta();
					}
					if (vpsEtaDt != null && !vpsEtaDt.equals(""))
					{
						if (vvd.equals("HNCH0036W"))
						{
							vpsEtaDtA = dbDao.searchVslEta(vvd, podLoc, "MAX_RRMMDDH");
						}
						else
						{
							vpsEtaDtA = dbDao.searchVslEta(vvd, podLoc, "MIN_RRMMDDH");
						}
					}
					if (vpsEtaDtA == null || vpsEtaDtA.equals(""))
					{
						// AUTO_HI 배치에서 전송 , AUTO_IBD_HI는 확인 되지 않음.
						if(!usrId.equals("AUTO_HI") && !usrId.equals("AUTO_IBD_HI")) {
							// Vessel SKD Data Not Found.
							throw new EventException(new ErrorHandler("BKG01057").getMessage());
						} else {
							log.error(new ErrorHandler("BKG01057").getMessage());
							continue;
						}
						
					}
					if (polLoc != null && polLoc.length() == 5)
					{
						// vps_call_ind = dbDao.searchSkdMax(vvd, polLoc);
						vpsEtdDt = dbDao.searchVslEta(vvd, polLoc, "MAX_ETD_RMDHM");
					}
					// Arrival or Desparture 's H01 generated.
					// EDA의 경우, H01을 구한 후, H014를 H01Y로 치환시킨다. 또한, vpsEtaDt는 전달받은 파라미터의 DDMMRR 변환값으로 입력한다.
					if (edaYn)
					{
						/*
						 * 20100309 경
						 * EDA일 경우vpsEtaDt mmddrr에서 yymmdd로 format변경.
						 */
						vpsEtaDt = new StringBuffer(vpsEtaDt.substring(4, 6)).append(vpsEtaDt.substring(0, 4)).toString();

						tmpstr7 = dbAceDao.searchH01(vpsEtdDt, polLoc, podAmsPortcd, vpsEtaDt, "H01");			//  추가ACE 0000 --> 00001
						tmpstr7 = tmpstr7.replaceAll("H014", "H01Y");
					}
					else
					{
						tmpstr7 = dbAceDao.searchH01(vpsEtdDt, polLoc, podAmsPortcd, vpsEtaDtA, "H01");			//  추가ACE 0000 --> 00001
					}
					// H01
					hiFile01.append(tmpstr7);
					lineCount++;
					if (polLoc != null && polLoc.length() == 5)
					{
						// H02
						hiFile01.append(dbAceDao.searchH01(vpsEtdDt, polLoc, podAmsPortcd, vpsEtaDtA, "H02"));			// 추가ACE 0000 --> 00001
						
						lineCount++;
					}
					UsaMiHiHeadFootCondVO htCndVo = new UsaMiHiHeadFootCondVO();
					htCndVo.setBlCnt(blCount);
					if (edaYn)
					{
						htCndVo.setVpsEtaDt(edaOnMi);
						// EDA의 경우, 라인 수 하드 코딩, 파일명 : 전송.ams_edaadjst_t 328 line.
						// dbDao.searchMiHiHeaderFooter 에서 라인 수 + 3을 하므로 5로 고정하기 위해서는 2를 전달해야 함.
						htCndVo.setLineCount("2");
					}
					else
					{
						htCndVo.setVpsEtaDt(vpsEtaDt);
						htCndVo.setLineCount(Integer.toString(lineCount));
					}
					htCndVo.setLocAmsport(tmpstr2);
					htCndVo.setTrspMsgTpCd(sTrsmMsgTpCd);
					htCndVo.setVslEngNm(vslEngNm);
					htCndVo.setVslFlag(vslFlag);
					htCndVo.setVslLloyd(vslLloyd);
					htCndVo.setVvd(actFileVvd);
					htCndVo.setMasterBlCnt(blCount);
					crrBatNo = "SMLM" + vvd + podLoc + dbDao.searchCarrierBatchNo();
					htCndVo.setCrrBatNo(crrBatNo);
					UsaMiHiHeaderFooterVO htVo = null;
					htVo = dbAceDao.searchMiHiHeaderFooter(htCndVo);			// 추가ACE P01 M01, //추가ACE - J01SMLM 삭제
					tmpstr6 = htVo.getHeader();
					tmpstr8 = htVo.getFooter();
					hiFile02.append(tmpstr6);									
					hiFile02.append(hiFile01.toString());					
					hiFile02.append(tmpstr8);
					flatFile.append(tmpstr1);
					flatFile.append(hiFile02.toString());
					/*********************************************
					 * // Flat File Gen End.
					 *********************************************/
					/*********************************************
					 * // Message Send Start
					 *********************************************/
					sendFlatFileVO.setFlatFile(flatFile.toString());
					flatFileAckVO = command2.sendFlatFile(sendFlatFileVO);
					if (flatFileAckVO.getAckStsCd().equals("E")) {
						if(!usrId.equals("AUTO_HI") && !usrId.equals("AUTO_IBD_HI")) {
							throw new EventException(new ErrorHandler("BKG00205").getMessage());
						} else {
							log.error(new ErrorHandler("BKG00205").getMessage());
							continue;
						}
						
					}
					/*********************************************
					 * // Message Send End.
					 *********************************************/
					/*********************************************
					 * // Log Add Start.
					 *********************************************/
					sndLogVo.setCntCd("US");
					sndLogVo.setIoBndCd("I");
					sndLogVo.setSndDt(lsDate);
					sndLogVo.setHisSeq(dbDao.searchSndLogNextHisSeq("US", "I", lsDate, sTrsmMsgTpCd));
					sndLogVo.setTrsmMsgTpId("HI");
					sndLogVo.setVvd(vvd);
					sndLogVo.setCrrBatNo(crrBatNo);
					/*
					 0514화면에서는 pol이 없으므로 로그테이블에 넣을때는 그대로 null값을 넣는다. 때문에 주석처리
					if(polLoc == null || polLoc.equals("") || polLoc.length() != 5){
						polLoc = podLoc;
					}
					*/
					sndLogVo.setPolCd(polLoc);
					sndLogVo.setPodCd(podLoc);
					sndLogVo.setVslDepRptFlg("N");
					
					if(!usrId.equals("AUTO_HI") && !usrId.equals("AUTO_IBD_HI")) {
						sndLogVo.setAutoVslDepRptFlg("N");
					} else {
						sndLogVo.setAutoVslDepRptFlg("Y");
					}
					
					sndLogVo.setSndUsrId(usrId);
					sndLogVo.setSndUsrOfcCd(ofcCd);
					sndLogVo.setAckTpNo("");
					sndLogVo.setCreUsrId(usrId);
					sndLogVo.setUpdUsrId(usrId);
					sndLogVo.setActFileSkdDirCd(actFileSkdDirCd);
					/*
					 * 20100309 AUTO HI이면 FLAG = "Y" POL에 상관없어야 하므로 주석처리함
					if (polLoc != null && polLoc.length() == 5)
					{
						if (!usrId.equals("AUTO_HI"))
						{
							sndLogVo.setVslDepRptFlg("N");
						}
						else
						{
							sndLogVo.setAutoVslDepRptFlg("Y");
						}
					}
					*/
					
					sndLogVo.setCstmsPortCd(cstmsPortCd);  //CSTMS_PORT_CD 칼럼 추가
					// INBOND_SLOGP table에 전송 결과 입력
					dbDao.addSendLog(sndLogVo);
					// INBOND_SLOG_DETAIL table에 전송 결과 입력
					sndLogVo.setDtlSeq("1");
					// 이전 소스는 전송내용을 한번에 로그테이블에 입력했으나, 라인단위로 입력하는 것으로 수정.
					StringTokenizer token = new StringTokenizer(hiFile02.toString(), "\n");
					int i = 1;
					tmpStr = "";
					while (token.hasMoreTokens())
					{
						tmpStr = token.nextToken();
						sndLogVo.setDtlSeq(i + "");
						sndLogVo.setEdiSndLogCtnt(tmpStr);
						dbDao.addSendLogDetail(sndLogVo);
						i++;
					}
					/*********************************************
					 * // Log Add End.
					 *********************************************/
					if (edaYn)
					{
						sndLogVo.setEtaDt(vo.getEta());
						sndLogVo.setEtaDtFormat("YYYY-MM-DD HH24:MI");
						// INSERT result in inbond_trans_vvd (BKG_CSTMS_ADV_VVD_ARR)
						resultQuery = dbDao.modifyVvdEta(sndLogVo);
						if (resultQuery == 0)
						{
							sndLogVo.setIoBndCd("EDA");
							dbDao.addVslEta(sndLogVo);
						}
					}
					else
					{
						// AUTO HI전송인지 여부에 따라서 해당 MI전송 LOG도 Auto Check Update한다.
						dbDao.modifyHiInfo(sndLogVo);
					}
				}
			}
			
			return flatFile.toString();
		}
		catch (EventException ex)
		{
			log.error("err " + ex.toString(), ex);
			throw ex;
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
	}

	/**
	 * Export US 세관신고 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVO
	 * @return String
	 * @throws EventException
	 */

	public String transmitManifestOB(ManifestTransmitVO[] manifestTransmitVO) throws EventException {
		String sTrsmMsgTpCd = "XI";
		BookingUtil command2 = new BookingUtil();
		FlatFileAckVO flatFileAckVO = null;
		SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
		sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZ2HJS_AMS.IBMMQ.QUEUE"));
		UsaManifestSearchDetailVO usaManifestTransmitVO = null;
		UsaManifestSearchDetailVO[] usaManifestTransmitVOs = null;
		ManifestTransmitVO manifestTransmitVO2 = null;
		int len = manifestTransmitVO.length;
		if (len > 0)
		{
			manifestTransmitVO2 = manifestTransmitVO[0];
		}
		else
		{
			throw new EventException(new ErrorHandler("BKG01051").getMessage());
		}

		List<AmsInfoVO> amsInfoVos = null;
		AmsInfoVO amsInfoVo = null;
		BlLineInfoVO blLineInfoVO = null;
		List<BlLineInfoVO> blLineInfoVOs = null;
		UsaCustomerInfoVO custLineInfoVO = null;
		List<UsaCustomerInfoVO> custLineInfoVOs = null;
		List<UsaContainerInfoVO> cntrLineInfoVOs = null;
		UsaContainerInfoVO cntrLineInfoVO = null;
		List<UsaCMVO> cntrMfLineInfoVOs = null;
		List<UsaCMVO> usaCmVOsForIsf = null;
		CmdMarkVO cmdMarkVO = null;
		List<DgUnnoVO> dgUnnoVOs = null;
		StringBuffer flatFile = new StringBuffer();
		StringBuffer hiFile02 = null;
		StringBuffer tmpBuf = null;
		int maxCnt = 0;
		int realSentBlCnt = 0;
		int blCntExceptHouse = 0;
		int lineCount = 0;
		String alreadySentBl = "";
		String currBlNo = "";
		String vvd = "";
		String actFileSkdDirCd = "";
		String crrBatNo = "";
		String pod = "";
		String pol = "";
		String cgoTpCd = "";
		String b01 = "";
		String buf6 = "";
		String buf7 = "";
		String buf8 = "";
		String digit2blank = "";
		String digit4blank = "";
		String digit5blank = "";
		String digit10blank = "";
		String digit20blank = "";
		String dgUnno = "";
		String polFirstLoc = "";
		String itIpiLocal = "";
		String itItno = "";
		String itItType = "";
		String itHub = "";
		String itLstUsa = "";
		String amsPort = "";
		String delAms = "";
		String fdaInd = "";
		String wgtVal = "";
		String cmdtCd = "";
		String cmdtDesc = "";
		String itPkgQty = "";
		String itPkgAms = "";
		String itDel = "";
		String buf22 = "";
		String buf24 = "";
		String buf26 = "";
		String buf27 = "";
		String cntrNo = "";
		String icmHtCd = "";
		String icmWgtQty = "";
		String icmWgtVal = "";
		String icmWgtTp = "";
		String icmPkgQty = "";
		String icmDesc = "";
		String cmdSeq = "";
		String cmdMarkAll = "";
		String cmdMarkLen = "";
		String cmdMarkNew = "";
		String cmdMark = "";
		String mbl = "";
		String vslFlag = "";
		String vslEngNm = "";
		String vslLloyd = "";
		String vpsEtaDt = "";
		String lsDate = "";
		String usrId = "";
		String ofcCd = "";
		String locAmsport = "";
		String amsCode = "";
		String mfNo = ""; // 'X'이면 마스터, 아니면 하우스.
		//String isf5 = "";
		String fPod = "";
		int blseVoy = 0;
		int miSndCount = 0;
		SendingLogVO sndLogVo = new SendingLogVO();
		int lineCnt = 0;
		int kk = 0;
		int j = 0;
		int idx = 0;
		int cntrCountPerBl = 0;
		
		String cstmsPortCd = "";
		String bookingPodCd = "";
		
		String cstmsLocCd = "";

		try
		{
			
			digit2blank = "  ";
			digit4blank = "    ";
			digit5blank = "     ";
			digit10blank = "          ";
			digit20blank = "                    ";
			
			usaManifestTransmitVOs = (UsaManifestSearchDetailVO[]) manifestTransmitVO;
			flatFile = null;
			flatFile = new StringBuffer();
			maxCnt = usaManifestTransmitVOs.length;
			// bl_param
			String blParams = "";
			StringBuffer blParams1 = new StringBuffer();

			for (int i = 0; i < maxCnt; i++)
			{
				// to_clob
				if(i == 0){
					blParams1.append("to_clob('");
				}else if(i % 270 == 1 && i != 1){
					blParams1.append("||to_clob('");
				}
				blParams1.append(usaManifestTransmitVOs[i].getBlNo());
				
				if (i != maxCnt - 1){
					blParams1.append(",");
				}
				if((i != 0 && i % 270 == 0) || i == len - 1){
					blParams1.append("')");
				}
				// END to_clob
			}
			blParams = blParams1.toString();

			// blCntExceptHouse
			if (maxCnt > 0)
			{
				usaManifestTransmitVO = usaManifestTransmitVOs[0];
				currBlNo = usaManifestTransmitVO.getBlNo();
				vvd = usaManifestTransmitVO.getVvd();
				usrId = usaManifestTransmitVO.getUsrId();
				ofcCd = usaManifestTransmitVO.getOfcCd();
				pod = usaManifestTransmitVO.getPod();
				pol = usaManifestTransmitVO.getPol();
				cgoTpCd = usaManifestTransmitVO.getCgoTpCd();
				
				BkgCstmsAdvBlVO bkgCstmsAdvBlVO = dbDao.searchAdvBlOB(currBlNo, vvd);
				cstmsPortCd = bkgCstmsAdvBlVO.getCstmsPortCd(); // locAmsport媛?援ы븷???몄옄媛믪쑝濡??ъ슜
				actFileSkdDirCd = bkgCstmsAdvBlVO.getActFileSkdDirCd();
				
//					if("E".equals(actFileSkdDirCd)) {
//						actFileVvd = vvd.substring(0, 8) + actFileSkdDirCd;
//					} else {
//						actFileVvd = vvd;
//						actFileSkdDirCd = vvd.substring(8, 9);
//					}
//					
//					if(bkgCstmsAdvBlVO.getAmsTmlCd() == null || bkgCstmsAdvBlVO.getAmsTmlCd().length() == 0){
//						locAmsport = dbDao.searchPodAmsCode(cstmsPortCd);  //searchPodAmsCode 洹몃?濡??ъ슜
//					}else{
//						locAmsport = bkgCstmsAdvBlVO.getAmsTmlCd();
//					}
//															
//					if (locAmsport == null || locAmsport.length() == 0)	locAmsport = digit4blank;
				
				// Vsl_cd가 등록된 국가코드,영문이름 정보를 조회한다.
				MdmVslCntrVO mdmVslCntrVO = dbDao.searchVslInfo(vvd);
				if (mdmVslCntrVO == null || mdmVslCntrVO.getVslCd() == null)
				{
					throw new EventException(new ErrorHandler("BKG01052").getMessage());
				}
				vslFlag = mdmVslCntrVO.getVslRgstCntCd();
				vslEngNm = mdmVslCntrVO.getVslEngNm();
				vslLloyd = mdmVslCntrVO.getLloydNo();
				if (vslLloyd == null || vslLloyd.equals("9124524") || vslLloyd.equals("8918945") || vslLloyd.equals("9183489"))
				{
					vslLloyd = "       ";
				}
				if (vvd.indexOf("BLSE") >= 0)
				{
					blseVoy = Integer.parseInt(vvd.substring(4, 8));
					if (blseVoy > 839)
					{
						vslFlag = "PA";
					}
					else
					{
						vslFlag = "LR";
					}
				}
				vpsEtaDt = dbDao.searchVslEta(vvd, cstmsPortCd, "MAX_MMDDRR");
				if (vpsEtaDt == null || vpsEtaDt.length() == 0)
					vpsEtaDt = dbDao.searchEtaWhenSkdIsNotExist(vvd, pod);
				if (vpsEtaDt == null || vpsEtaDt.length() != 6)
				{
					// Please update vessel schedule first before you send MI & AI.
					throw new EventException(new ErrorHandler("BKG01053").getMessage());
				}
				
				
				/*
				 * 2010년 7월 16일 경종윤
				 *  MI가 전송된 적이 있는지 확인 작업 
				 */
//					checkMiCondVO.setVvd(vvd);
//					checkMiCondVO.setPod(pod);
//					checkMiCondVO.setPol(pol);
//					checkMiCondVO.setTrsmTp("XI");
//					checkMiCondVO.setCgoTpCd(cgoTpCd);// cgo_tp_cd 컬럼 추가
//					miSndCount = dbDao.checkMiTransCount(checkMiCondVO);
//					
//					String user_auth_mi_multi = dbDao.searchUserAuthMiMultiYn(usaManifestTransmitVO.getUsrId());
//					
//					String gubunT = SubSystemConfigFactory.get("BKG.MFT.SERVICE.MODE");
//					if(gubunT == null){
//						gubunT = "N";
//					}
//				    if( !( "TEST".equals(gubunT) || "Y".equals(user_auth_mi_multi)) ){
//						if (miSndCount > 0)
//						{
//							// MI File Already transmitted.
//							throw new EventException(new ErrorHandler("BKG01054").getMessage());
//						}
//				    }

				amsInfoVos = dbDao.searchAmsCodeOB(vvd);
				amsInfoVo = null;
				polFirstLoc = "";
				if (amsInfoVos != null && amsInfoVos.size() > 0)
				{
					amsInfoVo = amsInfoVos.get(0);
					polFirstLoc = amsInfoVo.getPolFirstAms(); //First Foreign Port
				}
				else
				{
					polFirstLoc = digit5blank;
				}

				String gubun = SubSystemConfigFactory.get("BKG.MFT.SERVICE.MODE");
				
				//B01,B02,B04
				blLineInfoVOs = dbDao.searchItTypeOB(sTrsmMsgTpCd, blParams, polFirstLoc, vvd);
				//N00,N02
				custLineInfoVOs = dbDao.searchCustomerOB(blParams);
				//C01,C02,C03
				cntrLineInfoVOs = dbAceDao.searchContainerInfoOB(blParams, gubun, vvd);
			}
			
			String aiCurrBlNo = "";
			if ( blLineInfoVOs != null) {
				for (int i = 0; i < blLineInfoVOs.size(); i++)
				{
					blLineInfoVO = blLineInfoVOs.get(i);
					currBlNo = blLineInfoVO.getBlNo();
					
					/*
					 * BL_NO가 12자리가 아닐 겨우에 AI전송시 공백을 채운 12자를 사용
					 * 그 이외에는 trim을한 BL_NO를 사용
					 */
					aiCurrBlNo = currBlNo;
					currBlNo = currBlNo.trim();
					
					bookingPodCd = "";
					fPod = "";
					
					// B01 SetUp.
					if (currBlNo != null && alreadySentBl.indexOf(currBlNo) < 0)
					{
						alreadySentBl = alreadySentBl + "," + currBlNo;
						itIpiLocal = "";
						itItno = "";
						itItType = "";
						itHub = "";
						cstmsLocCd = "";
						itLstUsa = "";
						amsPort = "";
						delAms = "";
						fdaInd = "";
						wgtVal = "";
						cmdtCd = "";
						cmdtDesc = "";
						itPkgQty = "";
						itPkgAms = "";
						itDel = "";
						amsCode = "";
						mfNo = "";
						
						if (!"D".equals(blLineInfoVO.getMfStsCd()) )
						{
	//						if (dbDao.searchIsf5(currBlNo) > 0)
	//						{
	//							isf5 = "Y";
	//						}
	//						else
	//						{
	//							isf5 = "N";
	//						}
							if (blLineInfoVO != null)
							{
								itItno = blLineInfoVO.getItItno();
								itItType = blLineInfoVO.getItIttype();
								mfNo = blLineInfoVO.getMfNo();
								amsCode = blLineInfoVO.getAmsCode();
								
								// 마스터 BL의 갯수를 확인하기 위함.
								if ("X".equals(mfNo)) {
									blCntExceptHouse++;
								}
								
								if (amsCode == null || amsCode.length() < 4)
								{
									amsCode = digit4blank;
								}
								b01 = blLineInfoVO.getB01();
								blLineInfoVO.getB01isf5();
								
								flatFile.append(b01);
								lineCount++;
								flatFile.append(blLineInfoVO.getB02());
								lineCount++;
								// HOUSE B/L
								if (!"X".equals(mfNo)) {
									flatFile.append(blLineInfoVO.getB04());
									lineCount++;
								} 
								
								/*
								 * SPLIT 된 BL을 FLATFILE에 추가한다.
								 * 조건 : PRE_MF_NO값이 존재하고, 전송 후 ACK를 받은 적이 있는 경우
								 * => "B04OL SMLM" || PRE_MF_NO
								 */						
	//							preMfCnt = dbDao.searchPreMF(currBlNo);
	//							if (!"0".equals(preMfCnt))
	//							{
	//								flatFile.append(blLineInfoVO.getB042());
	//								lineCount++;
	//							}
	//							downLoadBC.modifyTransStage(currBlNo, sTrsmMsgTpCd);
								
								itIpiLocal = blLineInfoVO.getItIpiLocal();
								itHub = blLineInfoVO.getItHub();
								cstmsLocCd = blLineInfoVO.getCstmsLocCd();
								itLstUsa = blLineInfoVO.getItLstUsa();
								wgtVal = blLineInfoVO.getWgtVal();
								cmdtCd = blLineInfoVO.getCmdtCd();
								cmdtDesc = dbDao.searchCmdtDesc(cmdtCd);
								if (cmdtDesc == null || cmdtDesc.equals(""))
									cmdtDesc = " ";
								tmpBuf = new StringBuffer(cmdtDesc);
								for (idx = cmdtDesc.length(); idx < 45; idx++)
								{
									tmpBuf.append(" ");
								}
								cmdtDesc = tmpBuf.toString();
								itPkgQty = blLineInfoVO.getItPkgQty();
								itPkgAms = blLineInfoVO.getItPkgAms();
								itDel = blLineInfoVO.getItDel();
							}
							// CustLine 정보는 루프를 돌기전에 이미 구해놓았다.
							// custLineInfoVO 초기화.
							custLineInfoVO = null;
							// 같은 BL번호에 대한 custLineInfoVO 를 구함.
	
							for (int k = 0; k < custLineInfoVOs.size(); k++)
							{
								if (currBlNo.equals(custLineInfoVOs.get(k).getBlNo()))
								{
									custLineInfoVO = custLineInfoVOs.get(k);
								}
							}
							// 컨테이너 정보는 루프를 돌기전에 이미 구해놓았다.
							if (custLineInfoVO != null)
							{
								flatFile.append(String.format("%-80s",custLineInfoVO.getBuf21()).substring(0, 80)).append("\n");
								lineCount++;
								flatFile.append(String.format("%-80s",custLineInfoVO.getBuf211()).substring(0, 80)).append("\n");
								lineCount++;
								buf22 = custLineInfoVO.getBuf22();
								if (buf22 != null && buf22.length() > 3)
								{
									flatFile.append(String.format("%-80s",buf22).substring(0, 80)).append("\n");
									lineCount++;
								}
								flatFile.append(String.format("%-80s",custLineInfoVO.getBuf23()).substring(0, 80)).append("\n");
								lineCount++;
								flatFile.append(String.format("%-80s",custLineInfoVO.getBuf231()).substring(0, 80)).append("\n");
								lineCount++;
								buf24 = custLineInfoVO.getBuf24();
								if (buf24 != null && buf24.length() > 3)
								{
									flatFile.append(String.format("%-80s",buf24).substring(0, 80)).append("\n");
									lineCount++;
								}
								flatFile.append(String.format("%-80s",custLineInfoVO.getBuf25()).substring(0, 80)).append("\n");
								lineCount++;
								flatFile.append(String.format("%-80s",custLineInfoVO.getBuf251()).substring(0, 80)).append("\n");
								lineCount++;
								buf26 = custLineInfoVO.getBuf26();
								if (buf26 != null && buf26.length() > 3)
								{
									flatFile.append(String.format("%-80s",buf26).substring(0, 80)).append("\n");
									lineCount++;
								}
								buf27 = custLineInfoVO.getBuf27();								
								if (buf27 != null)
								{	
									//N00
									List<UsaCustomerInfoVO> custLineInfoVO27s = dbDao.searchCstmsPartyInfoOB(currBlNo,vvd);
									for (int m = 0; m < custLineInfoVO27s.size(); m++)
									{											
										flatFile.append(String.format("%-80s",custLineInfoVO27s.get(m).getBuf27()).substring(0, 80)).append("\n"); 
										lineCount++;										
									}																																
								}									
	
							}
							
							// Container Info..
							usaCmVOsForIsf = new ArrayList<UsaCMVO>();
							cntrCountPerBl = 0;
							if (cntrLineInfoVOs != null && cntrLineInfoVOs.size() > 0)
							{
								for (int c = 0; c < cntrLineInfoVOs.size(); c++)
								{
									cntrLineInfoVO = null;
									if (currBlNo.equals(cntrLineInfoVOs.get(c).getBlNo()))
									{
										cntrLineInfoVO = cntrLineInfoVOs.get(c);
									}
									if (cntrLineInfoVO != null)
									{
										flatFile.append(cntrLineInfoVO.getBuf3());
	
										if ( cntrLineInfoVO.getBuf32().trim().length() > 3) {
											flatFile.append(cntrLineInfoVO.getBuf32());
										}
										
										if ( cntrLineInfoVO.getBuf33().trim().length() > 3) {
											flatFile.append(cntrLineInfoVO.getBuf33());
										}
										cntrCountPerBl++;
										lineCount++;
										cntrNo = cntrLineInfoVO.getCntrNo();
										cntrMfLineInfoVOs = dbDao.searchCMInfoOB(currBlNo, cntrNo, cmdtDesc);
										if (cntrMfLineInfoVOs == null || cntrMfLineInfoVOs.size() == 0)
										{
											if (itPkgQty == null || itPkgQty.equals(""))
												itPkgQty = "0";
											
											itPkgQty = String.format("%010d", Integer.parseInt(itPkgQty));
											
											if (itPkgAms == null || itPkgAms.equals(""))
												itPkgAms = " ";
											
											itPkgAms = String.format("%-5s", itPkgAms);
											
											flatFile.append("D01").append(itPkgQty).append(itPkgAms).append(String.format("%-62s", " ")).append("\n");
											
											lineCount++;
	
											flatFile.append(String.format("%-80s","D02NO MARKS")).append("\n");
											lineCount++;
										}
										else
										{
											for (int k = 0; k < cntrMfLineInfoVOs.size(); k++)
											{
												usaCmVOsForIsf.add(cntrMfLineInfoVOs.get(k));
												icmHtCd = cntrMfLineInfoVOs.get(k).getIcmHtCd();
												icmWgtQty = cntrMfLineInfoVOs.get(k).getIcmWgtQty();
												icmWgtVal = cntrMfLineInfoVOs.get(k).getIcmWgtVal();
												icmWgtTp = cntrMfLineInfoVOs.get(k).getIcmWgtTp();
												icmPkgQty = cntrMfLineInfoVOs.get(k).getIcmPkgQty();
												icmDesc = cntrMfLineInfoVOs.get(k).getIcmDesc();
												cmdSeq = cntrMfLineInfoVOs.get(k).getCmdSeq();
	
												if (icmWgtTp == null || icmWgtTp.equals("")) icmWgtTp = " ";
												icmWgtTp = String.format("%-2s", icmWgtTp);
	
												if (icmHtCd != null && icmHtCd.length() > 1 && icmWgtQty != null
														&& icmWgtQty.length() > 0)
												{
													icmHtCd = String.format("%-10s", icmHtCd)+" ";			// 추가ACE 10자리+space
													
													if(icmWgtVal == null || icmWgtVal.equals("")) icmWgtVal = "0";
													icmWgtVal = String.format("%08d", Integer.parseInt(icmWgtVal));
													
													if(icmWgtQty == null || icmWgtQty.equals("")) icmWgtQty = "0";
													icmWgtQty = String.format("%010d", Integer.parseInt(icmWgtQty));
													
													flatFile.append("D00").append(icmHtCd).append(icmWgtVal).append(
															icmWgtQty).append(icmWgtTp).append(String.format("%-46s", " ")).append("\n");	// 異붽?ACE
													
													lineCount++;
												}
												if (icmPkgQty == null || icmPkgQty.equals(""))
													icmPkgQty = "0";
												icmPkgQty = String.format("%010d", Integer.parseInt(icmPkgQty));
	
												if (icmDesc == null || icmDesc.equals(""))
													icmDesc = " ";
												icmDesc = String.format("%-45s", icmDesc);
	
												flatFile.append("D01").append(icmPkgQty).append(icmDesc).append(String.format("%-22s", " ")).append("\n");
												lineCount++;
												// proC의 if (strncmp(cmdSeq[i].arr,"00",2) != 0)라인구현
												if (cmdSeq != null && cmdSeq.indexOf("00") != 0)
												{
													cmdMarkVO = dbDao.searchCmMarkOB(currBlNo, cntrNo, cmdSeq);
													cmdMarkAll = cmdMarkVO.getCmdMarkAll();
													cmdMarkLen = cmdMarkVO.getCmdMarkLen();
													// proC의 if(strncmp(itDel.arr,"MX",2) == 0) { 라인구현
													if (itDel != null && itDel.indexOf("MX") == 0)
													{
														cmdMarkAll = "IN TRANSIT TO MEXICO";
														cmdMarkLen = Integer
																.toString((Integer.parseInt(cmdMarkLen) + 20));
													}
													// cmdMarkAll = "1234\n6789";
													int nrIdx = cmdMarkAll.indexOf("\n");
													cmdMarkNew = "";
													String tmp2 = "";
													String tmp3 = cmdMarkAll;
													for (; nrIdx >= 0;)
													{
														if (nrIdx < 23)
														{
															tmp3 = tmp3.replaceFirst("\n", " ");
															tmp2 = tmp3.substring(0, nrIdx);
															tmp2 = String.format("%-23s", tmp2);
															
															tmp3 = tmp3.substring(nrIdx + 1);
															cmdMarkNew = cmdMarkNew + tmp2;
															nrIdx = tmp3.indexOf("\n");
														}
														else
														{
															tmp2 = tmp3.substring(0, 23);
															tmp3 = tmp3.substring(23);
															cmdMarkNew = cmdMarkNew + tmp2;
															nrIdx = nrIdx - 23;
														}
													}
													if (tmp3.length() > 0)
													{
														tmp3 = String.format("%-23s", tmp3);
														cmdMarkNew = cmdMarkNew + tmp3;
													}
													// log.info(cmdMarkNew);
													lineCnt = 0;
													lineCnt = (int) Math.floor((cmdMarkNew.length() + 22) / 23);
													kk = 0;
													if (lineCnt == 0)
													{
														flatFile.append(String.format("%-80s", "D02NO MARKS")).append("\n");
														lineCount++;
													}
													cmdMark = "";
													for (j = 0; j < lineCnt; j++)
													{
														cmdMark = "";
														cmdMark = cmdMarkNew.substring(kk, kk + 23);
														kk = kk + 23;
														tmpBuf = new StringBuffer(cmdMarkNew);
														if (kk + 23 > cmdMarkNew.length())
														{
															for (idx = cmdMarkNew.length(); idx < kk + 23; idx++)
															{
																tmpBuf.append(" ");
															}
															cmdMarkNew = tmpBuf.toString();
														}
														
														/*
														 * 2010년 2월 19일 경종윤
														 * 
														 * CMDT_GDS_SEQ가 1번부터가 아닐 수 있으므로 (!cmdSeq.equals("1")) => (k!= 0)로 변경함 
														 */
														if (  //(cmdMark.indexOf("NO MARKS") == 0 && k!=0)
															(cmdMark.equals(String.format("%-23s", " "))))
														{
															continue;
														}
														cmdMark = String.format("%-23s", cmdMark);
														
														flatFile.append("D02").append(cmdMark).append(String.format("%-54s", " ")).append("\n");
														lineCount++;
													} // for
												}
												else
												{
													flatFile.append(String.format("%-80s", "D02NO MARKS")).append("\n");
													lineCount++;
												}
											}// for mf.
											mbl = "";
											if (!mfNo.equals("X"))
											{
												mbl = mfNo;
											}
											else
											{
												mbl = currBlNo;
											}
											dgUnnoVOs = dbDao.searchDgUnNo(mbl, cntrNo);
											if (dgUnnoVOs != null && dgUnnoVOs.size() > 0)
											{
												for (int g = 0; g < dgUnnoVOs.size(); g++)
												{
													dgUnno = dgUnnoVOs.get(g).getDgUnno();
													if (dgUnno == null || dgUnno.equals(""))
														dgUnno = " ";
													dgUnno = String.format("%-10s", dgUnno);
													flatFile.append("V01");
													flatFile.append(dgUnno);
													flatFile.append(String.format("%-4s", " "));
													// Hazardous Material Code Qualifier
													flatFile.append("U");
													flatFile.append(String.format("%-62s", " "));
													flatFile.append("\n");
													lineCount++;
												}
											}
										}
									}
								}// for - cntrLine
							}// if
						}
						realSentBlCnt++;
						
	//					if (isf5.equals("Y"))
	//					{
	//						usaManifestTransmitVO.setBlNo(currBlNo);
	//						this.amsIsf5(usaManifestTransmitVO);
	//					}
						
					}// currBlNo is not null.
					 
				} // end for(int i = 0; i < blLineInfoVOs.size(); i++)
			} // end for blLineInfoVOs != null	
		
			lsDate = dbDao.searchSysdate("ddmmrrhh24miss");
			UsaTrsmFirstHeadVO firstHeadVO = new UsaTrsmFirstHeadVO();
			firstHeadVO.setVvd(vvd);
			firstHeadVO.setPodCd(pod);
			firstHeadVO.setOfcCd(ofcCd);
			firstHeadVO.setUsrId(usrId);
			firstHeadVO.setLsDate(lsDate);
			firstHeadVO.setFormat("ddmmrrhh24miss");
			firstHeadVO.setTrspMsgTpCd(sTrsmMsgTpCd);
			buf6 = dbDao.searchTrsmFirstHeader(firstHeadVO);
			
			//ACRSMLMHJS911 M01, M02, P01, ZCRSMLM
			UsaMiHiHeadFootCondVO htCndVo = new UsaMiHiHeadFootCondVO();
			UsaMiHiHeaderFooterVO htVo = null;			
			htCndVo.setBlCnt(Integer.toString(realSentBlCnt));
			htCndVo.setLineCount(Integer.toString(lineCount));
			htCndVo.setLocAmsport(locAmsport);
			htCndVo.setTrspMsgTpCd(sTrsmMsgTpCd);
			htCndVo.setVpsEtaDt(vpsEtaDt);
			htCndVo.setVslEngNm(vslEngNm);
			htCndVo.setVslFlag(vslFlag);
			htCndVo.setVslLloyd(vslLloyd);
			htCndVo.setVvd(vvd);
			htCndVo.setMasterBlCnt(Integer.toString(blCntExceptHouse));
			crrBatNo = "SMLM" + vvd + pod + dbDao.searchCarrierBatchNo();
			htCndVo.setCrrBatNo(crrBatNo);
			htCndVo.setSndDt(lsDate);		
			htVo = dbAceDao.searchMiHiHeaderFooterOB(htCndVo);
			
			buf7 = htVo.getHeader(); //PACMFHJS
			buf8 = htVo.getFooter(); //ZCRSMLM
			hiFile02 = new StringBuffer();
			hiFile02.append(buf7).append(flatFile.toString()).append(buf8);
			flatFile = new StringBuffer(buf6).append(hiFile02.toString());

			/*********************************************
			 * // Flat File Gen End.
			 *********************************************/
			sndLogVo.setCntCd("US");
			sndLogVo.setIoBndCd("O");
			sndLogVo.setSndDt(lsDate);
			sndLogVo.setHisSeq(dbDao.searchSndLogNextHisSeq("US", "O", lsDate, sTrsmMsgTpCd));
			sndLogVo.setTrsmMsgTpId(sTrsmMsgTpCd);
			sndLogVo.setVvd(vvd);
			sndLogVo.setPolCd(pol);
			sndLogVo.setPodCd(pod);
			sndLogVo.setVslDepRptFlg("N");
			sndLogVo.setAutoVslDepRptFlg("N");
			sndLogVo.setSndUsrId(usrId);
			sndLogVo.setSndUsrOfcCd(ofcCd);
			sndLogVo.setAckTpNo("");
			sndLogVo.setCreUsrId(usrId);
			sndLogVo.setUpdUsrId(usrId);
			sndLogVo.setEtaDt(vpsEtaDt);
			sndLogVo.setEtaDtFormat("MMDDRR");
			if (sTrsmMsgTpCd.equals("XI") && miSndCount < 1)
			{
				dbDao.addVslEta(sndLogVo);
			}
			/*********************************************
			 * // Log Add Start.
			 *********************************************/
			sndLogVo.setActFileSkdDirCd(actFileSkdDirCd);
			sndLogVo.setCrrBatNo(crrBatNo);				
			sndLogVo.setCstmsPortCd(cstmsPortCd);		
			sndLogVo.setCgoTpCd(cgoTpCd);				
			
			dbDao.addSendLog(sndLogVo);
			StringTokenizer token = new StringTokenizer(hiFile02.toString(), "\n");
			int i = 1;
			String tmpStr = "";
			while (token.hasMoreTokens())
			{
				tmpStr = token.nextToken();
				sndLogVo.setDtlSeq(i + "");
				sndLogVo.setEdiSndLogCtnt(tmpStr);
				dbDao.addSendLogDetail(sndLogVo);
				i++;
			}
			/*********************************************
			 * // Log Add End.
			 *********************************************/
			/*********************************************
			 * BKG_CSTMS_ADV_EDI_BL_RSPN
			 *********************************************/
			sndLogVo.setBlParams(blParams);
			dbDao.addCarrierBatchNoOB(sndLogVo);
			
			/*********************************************
			 * // Message Send Start
			 *********************************************/
			sendFlatFileVO.setFlatFile(flatFile.toString());
			flatFileAckVO = command2.sendFlatFile(sendFlatFileVO);
			if (flatFileAckVO.getAckStsCd().equals("E"))
				throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
			/*********************************************
			 * // Message Send End.
			 *********************************************/

			return flatFile.toString();
		}
		catch (EventException ex)
		{
			log.error("err " + ex.toString(), ex);
			throw ex;
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
	}
		
	/**
	 * 0543, 0514 화면의 Arrival, Departure 전송을 위한 조회를 실행한다.
	 * 
	 * @param ManifestListCondForEdiVO manifestListCondForEdiVO
	 * @return ManifestListForEdiVO
	 * @throws EventException
	 */
	public ManifestListForEdiVO searchManifestListForEdi(ManifestListCondForEdiVO manifestListCondForEdiVO)
			throws EventException {
		UsaManifestListCondForEdiVO condVO = (UsaManifestListCondForEdiVO) manifestListCondForEdiVO;
		UsaManifestListCondForEdiVO retVO = new UsaManifestListCondForEdiVO();
		ManifestListForEdiVO vo = new ManifestListForEdiVO();
		try
		{
			// 0223화면에 오지 않은 경우, 즉, 0543, 0514 인 경우의 실행.
			if (!"ESM_BKG_0233".equals(condVO.getPageNo()))
			{
				String pol = condVO.getPolCd();
				MdmVslCntrVO mdmVslCntrVO = dbDao.searchVslInfo(condVO.getVvd());
				if (mdmVslCntrVO == null || mdmVslCntrVO.getVslCd() == null)
				{
					throw new EventException(new ErrorHandler("BKG01059").getMessage());
				}
				String vpsEtaDt = dbDao.searchVslEta(condVO.getVvd(), condVO.getPodCd(), "YMD_VPS_ETA_DT");
				String vpsEtdDt = "";
				UsaTransmitInfoVO miTrans = new UsaTransmitInfoVO();
				if (pol.length() == 5)
				{
					vpsEtdDt = dbDao.searchVslEtd(condVO.getVvd(), pol);
					miTrans = dbDao.searchMiTransmitDt(condVO.getVvd(), condVO.getPolCd(), condVO.getPodCd(), "MI");
					if (miTrans == null)
					{
						throw new EventException(new ErrorHandler("BKG01062").getMessage());
					}
				}
				else
				{
					miTrans.setSndDt("");
				}
				UsaMiCountVO checkMiCondVO = new UsaMiCountVO();
				checkMiCondVO.setVvd(condVO.getVvd());
				checkMiCondVO.setPod(condVO.getPodCd());
				checkMiCondVO.setPol(condVO.getPolCd());
				checkMiCondVO.setTrsmTp("HI");
				int hiSndCount = dbDao.checkMiTransCount(checkMiCondVO);
				String hiSndYn = "N";
				if (hiSndCount > 0)
					hiSndYn = "Y";
				UsaTransmitInfoVO hiTrans = dbDao.searchMiTransmitDt(condVO.getVvd(), condVO.getPolCd(), condVO
						.getPodCd(), "HI");
				retVO = condVO;
				retVO.setBlCount(Integer.toString(dbDao.searchBlCount(condVO.getVvd(), condVO.getPolCd(), condVO
						.getPodCd())));
				retVO.setName(mdmVslCntrVO.getVslEngNm());
				retVO.setEta(vpsEtaDt);
				retVO.setAtd(vpsEtdDt);
				retVO.setMiTransmit(miTrans.getSndDt());
				retVO.setHiSndYn(hiSndYn);
				if (hiTrans != null)
				{
					retVO.setHiTransmit(hiTrans.getSndDt());
					retVO.setSndUsrId(hiTrans.getSndUsrId());
				}
				vo.setUsaManifestListCondForEdiVOs(retVO);
			}
			else
			{
				// 0233 화면에서 온 경우의 실행.
				List<UsaEDADetailVO> list = dbDao.searchEDAEta(condVO);
				vo.setUsaEDADetailVOs(list);
			}
		}
		catch (EventException ex)
		{
			log.error("err " + ex.toString(), ex);
			throw ex;
		}
		catch (DAOException ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return vo;
	}

	/**
	 * US 세관신고 위해 FlatFile을 생성한다.
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVO
	 * @return String
	 * @throws EventException
	 */
	public String transmitOfm(ManifestTransmitVO[] manifestTransmitVO) throws EventException {
		// sTrsmMsgTpCd : MI/AI..
		String sTrsmMsgTpCd = "";
		SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
		sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZ2HJS_AMS.IBMMQ.QUEUE"));
		UsaManifestSearchDetailVO usaManifestTransmitVO = null;
		UsaManifestSearchDetailVO[] usaManifestTransmitVOs = null;
		ManifestTransmitVO manifestTransmitVO2 = null;
		int len = manifestTransmitVO.length;
		if (len > 0)
		{
			manifestTransmitVO2 = manifestTransmitVO[0];
		}
		else
		{
			// There is no trans data
			throw new EventException(new ErrorHandler("BKG01051").getMessage());
		}
		String keySetStr = manifestTransmitVO2.getColumnValues().keySet().toString();
		if (keySetStr.indexOf("pod_cd") >= 0)
		{
			sTrsmMsgTpCd = "HI"; // 0543 화면에서 전송하는 루틴.
		}
		else
		{
			sTrsmMsgTpCd = "MI"; // 0613 화면에서 전송하는 루틴.
		}
		OFMBlLineInfoVO blLineInfoVO = null;
		List<OFMCntrLineVO> cntrLineInfoVOs = null;
		OFMCntrLineVO cntrLineInfoVO = null;
		List<UsaCMVO> cntrMfLineInfoVOs = null;
		CmdMarkVO cmdMarkVO = null;
		UsaMiCountVO checkMiCondVO = new UsaMiCountVO();
		StringBuffer flatFile = new StringBuffer();
		StringBuffer hiFile02 = null;
		StringBuffer tmpBuf = null;
		StringBuffer retriveFailedBlNo = new StringBuffer();
		int maxCnt = 0;
		int realSentBlCnt = 0;
		int lineCount = 0;
		String currBlNo = "";
		String vvd = "";
		String pod = "";
		String pol = "";
		String buf1 = "";
		String buf6 = "";
		String buf7 = "";
		String digit4blank = "";
		String cmdtDesc = "";
		String itDel = "";
		String buf21 = "";
		String cntrNo = "";
		String icmWgtTp = "";
		String icmPkgQty = "";
		String icmDesc = "";
		String cmdSeq = "";
		String cmdMarkAll = "";
		String cmdMarkLen = "";
		String cmdMarkNew = "";
		String cmdMark = "";
		String vslFlag = "";
		String vslEngNm = "";
		String vslLloyd = "";
		String vpsEtaDt = "";
		String vpsEtdDt = "";
		String lsDate = "";
		String usrId = "";
		String ofcCd = "";
		String locAmsport = "";
		String amsCode = "";
		int cm_count = 0;
		int idx = 0;
		SendingLogVO sndLogVo = new SendingLogVO();
		String alreadySentBl = "";
		int lineCnt = 0;
		int kk = 0;
		int j = 0;
		try
		{
			digit4blank = "    ";
			if ("MI".equals(sTrsmMsgTpCd) || "AI".equals(sTrsmMsgTpCd))
			{
				usaManifestTransmitVOs = (UsaManifestSearchDetailVO[]) manifestTransmitVO;
				flatFile = null;
				flatFile = new StringBuffer();
				maxCnt = usaManifestTransmitVOs.length;
				// blCntExceptHouse
				for (int i = 0; i < maxCnt; i++)
				{
					usaManifestTransmitVO = usaManifestTransmitVOs[i];
					currBlNo = usaManifestTransmitVO.getBlNo();
					if (i == 0)
					{
						sTrsmMsgTpCd = usaManifestTransmitVO.getTransmitCd();
						vvd = usaManifestTransmitVO.getVvd();
						usrId = usaManifestTransmitVO.getUsrId();
						ofcCd = usaManifestTransmitVO.getOfcCd();
						lsDate = dbDao.searchSysdate("ddmmrrhh24miss");
						// [USACUSKEWB0029EUSTIWNGOBS AUTO_HI 1018020090419040121HI
						UsaTrsmFirstHeadVO firstHeadVO = new UsaTrsmFirstHeadVO();
						firstHeadVO.setVvd(vvd);
						firstHeadVO.setPodCd(pod);
						firstHeadVO.setOfcCd(ofcCd);
						firstHeadVO.setUsrId(usrId);
						firstHeadVO.setLsDate(lsDate);
						firstHeadVO.setFormat("ddmmrrhh24miss");
						firstHeadVO.setTrspMsgTpCd(sTrsmMsgTpCd);
						buf6 = dbDao.searchTrsmFirstHeader(firstHeadVO);
						pod = usaManifestTransmitVO.getPod();
						if (pod != null && pod.equals("CAVAN"))
						{
							pod = dbDao.searchBkgLane(vvd, pod, null);
						}
						pol = usaManifestTransmitVO.getPol();
						locAmsport = dbDao.searchPodAmsCode(pod);
						if (locAmsport == null || locAmsport.length() == 0)
							locAmsport = digit4blank;
						// Vsl_cd가 등록된 국가코드,영문이름 정보를 조회한다.
						MdmVslCntrVO mdmVslCntrVO = dbDao.searchVslInfo(vvd);
						if (mdmVslCntrVO == null || mdmVslCntrVO.getVslCd() == null)
						{
							// Vessel Info. Data Not Found
							throw new EventException(new ErrorHandler("BKG01052").getMessage());
						}
						vslFlag = mdmVslCntrVO.getVslRgstCntCd();
						vslEngNm = mdmVslCntrVO.getVslEngNm();
						vslLloyd = mdmVslCntrVO.getLloydNo();
						if (vslLloyd == null || vslLloyd.equals("9124524") || vslLloyd.equals("8918945")
								|| vslLloyd.equals("9183489"))
						{
							vslLloyd = "       ";
						}
						vpsEtaDt = dbDao.searchVslEta(vvd, pod, "MAX_MMDDRR");
						vpsEtdDt = dbDao.searchVslEta(vvd, pol, "MAX_ETD_DDMONRR");
						if (vpsEtaDt == null || vpsEtaDt.length() == 0)
							vpsEtaDt = dbDao.searchEtaWhenSkdIsNotExist(vvd, pod);
						if (vpsEtaDt == null || vpsEtaDt.length() != 6)
						{
							// Please update vessel schedule first before you send MI & AI.
							throw new EventException(new ErrorHandler("BKG01053").getMessage());
						}
						checkMiCondVO.setVvd(vvd);
						checkMiCondVO.setPod(pod);
						checkMiCondVO.setPol(pol);
						checkMiCondVO.setTrsmTp("MI");
					}
					// B01 SetUp.
					if (currBlNo != null && alreadySentBl.indexOf(currBlNo) < 0)
					{
						alreadySentBl = alreadySentBl + "," + currBlNo;
						cmdtDesc = "";
						itDel = "";
						amsCode = "";
						blLineInfoVO = dbDao.searchOfmItType(currBlNo);
						if (blLineInfoVO != null)
						{
							if (amsCode == null || amsCode.length() < 4)
							{
								amsCode = digit4blank;
							}
							buf1 = blLineInfoVO.getBuf1();
							flatFile.append(buf1);
							lineCount++;
							if (cmdtDesc == null || cmdtDesc.equals(""))
								cmdtDesc = " ";
							tmpBuf = new StringBuffer(cmdtDesc);
							for (idx = cmdtDesc.length(); idx < 45; idx++)
							{
								tmpBuf.append(" ");
							}
							cmdtDesc = tmpBuf.toString();
							itDel = blLineInfoVO.getItDel();
						}
						buf21 = dbDao.searchOfmCustomer(currBlNo);
						flatFile.append(buf21);
						lineCount = lineCount + 6;
						// Container Info..
						cntrLineInfoVOs = dbDao.searchOfmContainerInfo(currBlNo);
						if (cntrLineInfoVOs != null && cntrLineInfoVOs.size() > 0)
						{
							for (int c = 0; c < cntrLineInfoVOs.size(); c++)
							{
								cntrLineInfoVO = cntrLineInfoVOs.get(c);
								flatFile.append(cntrLineInfoVO.getBuf3());
								lineCount++;
								cntrNo = cntrLineInfoVO.getCntrNo();
								cntrMfLineInfoVOs = dbDao.searchOfmCMInfo(currBlNo, cntrNo, cmdtDesc);
								if (cntrMfLineInfoVOs == null || cntrMfLineInfoVOs.size() == 0)
								{
									cm_count = 0;
								}
								else
								{
									cm_count = cntrMfLineInfoVOs.size();
								}
								for (int k = 0; k < cm_count; k++)
								{
									icmWgtTp = cntrMfLineInfoVOs.get(k).getIcmWgtTp();
									icmPkgQty = cntrMfLineInfoVOs.get(k).getIcmPkgQty();
									icmDesc = cntrMfLineInfoVOs.get(k).getIcmDesc();
									cmdSeq = cntrMfLineInfoVOs.get(k).getCmdSeq();
									if (icmWgtTp == null || icmWgtTp.equals(""))
										icmWgtTp = " ";
									tmpBuf = new StringBuffer(icmWgtTp);
									for (idx = icmWgtTp.length(); idx < 2; idx++)
									{
										tmpBuf.append(" ");
									}
									icmWgtTp = tmpBuf.toString();
									if (icmPkgQty == null || icmPkgQty.equals(""))
										icmPkgQty = "";
									if (icmDesc == null || icmDesc.equals(""))
										icmDesc = "";
									flatFile.append("CM_DESC{\n").append("CM_PKG_QTY | ").append(icmPkgQty)
											.append("\n").append("CM_DESC | ").append(icmDesc).append("\n");
									lineCount++;
									// proC의 if (strncmp(cmdSeq[i].arr,"00",2) != 0) 라인 구현
									if (cmdSeq != null && cmdSeq.indexOf("00") != 0)
									{
										cmdMarkVO = dbDao.searchCmMark(currBlNo, cntrNo, cmdSeq);
										cmdMarkAll = cmdMarkVO.getCmdMarkAll();
										cmdMarkLen = cmdMarkVO.getCmdMarkLen();
										// proC의 if(strncmp(itDel.arr,"MX",2) == 0) { 라인 구현
										if (itDel != null && itDel.indexOf("MX") == 0)
										{
											cmdMarkAll = "IN TRANSIT TO MEXICO";
											cmdMarkLen = Integer.toString((Integer.parseInt(cmdMarkLen) + 20));
										}
										int nrIdx = cmdMarkAll.indexOf("\n");
										cmdMarkNew = "";
										String tmp2 = "";
										String tmp3 = cmdMarkAll;
										for (; nrIdx >= 0;)
										{
											if (nrIdx < 23)
											{
												tmp3 = tmp3.replaceFirst("\n", " ");
												tmp2 = tmp3.substring(0, nrIdx);
												tmpBuf = new StringBuffer(tmp2);
												for (idx = tmpBuf.length(); idx < 23; idx++)
												{
													tmpBuf.append(" ");
												}
												tmp2 = tmpBuf.toString();
												tmp3 = tmp3.substring(nrIdx + 1);
												cmdMarkNew = cmdMarkNew + tmp2;
												nrIdx = tmp3.indexOf("\n");
											}
											else
											{
												tmp2 = tmp3.substring(0, 23);
												tmp3 = tmp3.substring(23);
												cmdMarkNew = cmdMarkNew + tmp2;
												nrIdx = nrIdx - 23;
											}
										}
										if (tmp3.length() > 0)
										{
											tmpBuf = new StringBuffer(tmp3);
											for (idx = tmp3.length(); idx < 23; idx++)
											{
												tmpBuf.append(" ");
											}
											tmp3 = tmpBuf.toString();
											cmdMarkNew = cmdMarkNew + tmp3;
										}
										lineCnt = 0;
										lineCnt = (int) Math.floor((cmdMarkNew.length() + 22) / 23);
										flatFile.append("MARK{\n");
										kk = 0;
										if (lineCnt == 0)
										{
											tmpBuf = new StringBuffer("NO MARKS");
											for (idx = tmpBuf.length(); idx < 23; idx++)
											{
												tmpBuf.append(" ");
											}
											flatFile.append("MARKNO | ").append(tmpBuf.toString()).append("\n");
											lineCount++;
										}
										cmdMark = "";
										for (j = 0; j < lineCnt; j++)
										{
											cmdMark = "";
											cmdMark = cmdMarkNew.substring(kk, kk + 22);
											kk = kk + 23;
											tmpBuf = new StringBuffer(cmdMarkNew);
											if (kk + 22 > cmdMarkNew.length())
											{
												for (idx = cmdMarkNew.length(); idx < kk + 22; idx++)
												{
													tmpBuf.append(" ");
												}
												cmdMarkNew = tmpBuf.toString();
											}
											if ((cmdMark.indexOf("NO MARKS") == 0 && !cmdSeq.equals("1"))
													|| (cmdMark.indexOf("                       ") == 0))
											{
												continue;
											}
											tmpBuf = new StringBuffer(cmdMark);
											for (idx = tmpBuf.length(); idx < 23; idx++)
											{
												tmpBuf.append(" ");
											}
											cmdMark = tmpBuf.toString();
											flatFile.append("MARKNO | ").append(cmdMark).append("\n");
											lineCount++;
										} // for
										flatFile.append("}MARK\n");
									}
								}// for mf.
								flatFile.append("}CNTR_INFO\n");
							}// for - cntrLine
						}// if
						if (blLineInfoVO != null)
						{
							flatFile.append("}BL_INFO\n");
							realSentBlCnt++;
						}
						else
						{
							retriveFailedBlNo.append(currBlNo).append("\n");
						}
					}// currBlNo is not null.
				} // end for(i)
				String pol_name = dbDao.searchLocNm(pol);
				String pod_name = dbDao.searchLocNm(pod);
				UsaMiHiHeadFootCondVO htCndVo = new UsaMiHiHeadFootCondVO();
				htCndVo.setBlCnt(Integer.toString(realSentBlCnt));
				htCndVo.setLocAmsport(locAmsport);
				htCndVo.setTrspMsgTpCd(sTrsmMsgTpCd);
				htCndVo.setVpsEtaDt(vpsEtaDt);
				htCndVo.setVslEngNm(vslEngNm);
				htCndVo.setVslFlag(vslFlag);
				htCndVo.setVslLloyd(vslLloyd);
				htCndVo.setVvd(vvd);
				htCndVo.setPodName(pod_name);
				htCndVo.setPolName(pol_name);
				htCndVo.setVpsEtdDt(vpsEtdDt);
				UsaMiHiHeaderFooterVO htVo = dbDao.searchOfmHeaderFooter(htCndVo);
				buf7 = htVo.getHeader();
				hiFile02 = new StringBuffer();
				hiFile02.append(buf7).append(flatFile.toString());
				flatFile = new StringBuffer(buf6).append(hiFile02.toString());
				/*********************************************
				 * // Flat File Gen End.
				 *********************************************/
				/*******************************************************/
				/* MI 인경우만 MI ETA INSERT 2001.1.29 */
				/*******************************************************/
				sndLogVo.setCntCd("US");
				sndLogVo.setIoBndCd("O");
				sndLogVo.setSndDt(lsDate);
				sndLogVo.setHisSeq(dbDao.searchSndLogNextHisSeq("US", "O", lsDate, sTrsmMsgTpCd));
				sndLogVo.setTrsmMsgTpId(sTrsmMsgTpCd);
				sndLogVo.setVvd(vvd);
				sndLogVo.setPolCd(pol);
				sndLogVo.setPodCd(pod);
				sndLogVo.setVslDepRptFlg("N");
				sndLogVo.setAutoVslDepRptFlg("N");
				sndLogVo.setSndUsrId(usrId);
				sndLogVo.setSndUsrOfcCd(ofcCd);
				sndLogVo.setAckTpNo("");
				sndLogVo.setCreUsrId(usrId);
				sndLogVo.setUpdUsrId(usrId);
				sndLogVo.setEtaDt(vpsEtaDt);
				sndLogVo.setEtaDtFormat("MMDDRR");
				/*********************************************
				 * // Log Add Start.
				 *********************************************/
				// INBOND_SLOGP table에 전송 결과 입력
				dbDao.addSendLog(sndLogVo);
				// INBOND_SLOG_DETAIL table에 전송 결과 입력
				// 이전 소스는 전송내용을 한번에 로그테이블에 입력했으나, 라인단위로 입력하는 것으로 수정.
				StringTokenizer token = new StringTokenizer(hiFile02.toString(), "\n");
				int i = 1;
				String tmpStr = "";
				String logContReal = "";
				StringBuffer logContBuf = new StringBuffer();
				while (token.hasMoreTokens())
				{
					tmpStr = token.nextToken();
					logContBuf.append(tmpStr).append("\n");
					if (logContBuf.length() > 2000)
					{
						sndLogVo.setDtlSeq(i + "");
						sndLogVo.setEdiSndLogCtnt(logContReal);
						logContBuf = new StringBuffer(tmpStr);
						logContReal = "";
						dbDao.addSendLogDetail(sndLogVo);
						i++;
					}
					logContReal = logContBuf.toString();
				}
				if (!logContReal.equals(""))
				{
					sndLogVo.setDtlSeq(i + "");
					sndLogVo.setEdiSndLogCtnt(logContReal);
					dbDao.addSendLogDetail(sndLogVo);
				}
				log.info("##################################################");
				log.info("retriveFailedBlNo : " + retriveFailedBlNo.toString());
				/*********************************************
				 * // Log Add End.
				 *********************************************/
			}
			return flatFile.toString();
		}
		catch (EventException ex)
		{
			log.error("err " + ex.toString(), ex);
			throw ex;
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
	}

	/**
	 * 세관 적하 목록 정정 신고를 위한 적하 정정 목록 조회
	 * 
	 * @param CstmsManifestAmendmentCondVO cstmsManifestAmendmentCondVO
	 * @return List<CstmsManifestAmendmentVO>
	 * @throws EventException
	 */
	public List<CstmsManifestAmendmentVO> searchCstmsManifestAmendment(
			CstmsManifestAmendmentCondVO cstmsManifestAmendmentCondVO) throws EventException {
		try
		{
			return dbDao
					.searchUsaCstmsManifestAmendment((UsaCstmsManifestAmendmentCondVO) cstmsManifestAmendmentCondVO);
		}
		catch (DAOException ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Vessel Stowage Plan Transmit 화면을 조회.
	 * 
	 * @param StowageManifestCondVO stowageManifestCondVO
	 * @return List<ManifestTransmitVO>
	 * @throws EventException
	 */
	public List<ManifestTransmitVO> searchStowageManifestList(StowageManifestCondVO stowageManifestCondVO)
			throws EventException {
		StiCondListVO condVO = (StiCondListVO) stowageManifestCondVO;
		List<ManifestTransmitVO> rtnList = new ArrayList<ManifestTransmitVO>();
		List<StiDetailVO> list = null;
		String paramVvd = ""; 	// 파라메터로 넘오는 vvd
		String tmpVvd = "";		// 가공한 값을 담을 vvd
		String sLane = "";
		try
		{
			// 조회조건이 유효한 조건일때 로직 실행.
			if (condVO != null)
			{
				paramVvd = tmpVvd = condVO.getVvd();
				sLane = dbDao.searchSvcLane(paramVvd); // service lane값을 조회한다.
				
				/* 20090602 JHPARK Lane 이 PNS 이거나 CEN 이면 temp_vvd 를 바꿔준다. (입력된 E/B 를 W/B 로) */
				if("PNS".equals(sLane) || "CEN".equals(sLane)) {
					
					tmpVvd = paramVvd.subSequence(0, 8) + "W";
				}
				
				/****************************************************************************/
				/* 20090602 JHPARK 아시아 -> 캐나다 -> 미국인 경우에 캐나다에서는 West Bound*/
				/* 로 Upload 한다. (아시아 선적분 포함) PNS, CEN Lane 의 경우에는 User 가 	*/
				/* E/B 로 조회하더라도 W/B 로 Upload 된 데이터를 조회할 수 있어야 한다. 	*/
				/****************************************************************************/
				if("EXCLUDECA".equals(condVO.getExcludeca())) {
					condVO.setVvd(tmpVvd);
				} else {
					// 화면에서 가져온 vvd를 그대로 사용한다.
					condVO.setVvd(paramVvd);
				}
				
				list = dbDao.searchStiListAtUsa(condVO);
				if (list != null)
				{
					// Vessel Info.를 조회한다.
					MdmVslCntrVO vo = dbDao.searchVslInfo(paramVvd);
					// vos의 결과 수 만큼 루프를 돌며, list를 채워준다.
					StiDetailVO itemVO = null;
					for (int i = 0; i < list.size(); i++)
					{
						itemVO = list.get(i);
						itemVO.setVslEngNm(vo.getVslEngNm());
						itemVO.setVslVoy(paramVvd.substring(4));
						itemVO.setCrrCd(vo.getCrrCd());
						rtnList.add(itemVO);
					}
				}
			}
			return rtnList;
		}
		catch (DAOException ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		catch (Exception ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * Vessel Stowage Plan Transmit을 실행.
	 * 
	 * @param ManifestTransmitVO[] manifestTransmitVOs
	 * @return String
	 * @throws EventException
	 */
	public String transmitStowageManifest(ManifestTransmitVO[] manifestTransmitVOs) throws EventException {
		
		String condVvd = ""; // 조회조건 vvd값
		String searchVvdCd = ""; // 조회시 조회된 vvd 값
		String pod = "";
		String lastpol = "";
		String usrId = "";
		String ofcCd = "";
		String usPortCd = "";
		try
		{
			StringBuffer flatFile = new StringBuffer();
			if (manifestTransmitVOs != null)
			{
				// searchVesselEta 를 위한 파라미터 변수VO
				VesselEtaCondVO vslCondVo = null;
				// StowageManifestDetailVO[] cvos 를 할당받아 형변환된 vo변수.
				StiDetailVO vo = null;
				// searchVesselEta 의 결과를 담을 변수VO
				VesselEtaInfoVO vslVo = null;
				// 컨테이너 번호별로 BayPlan데이터를 조회하기 위한 조회조건 VO.
				BayPlanCntrListCondVO bayCondVo = null;
				// 컨테이너 번호별로 BayPlan데이터를 조회하기 위한 조회결과 VO.
				BayPlanCntrDetailVO bayDetailVo = null;
				// 컨테이너 번호별로 BayPlan데이터를 조회하기 위한 조회결과 VO들의 배열.
				// 두번째 루프에서 다시 컨테이너별 BayPlan을 조회하지 않고, 이 결과배열로 루프를 돌린다.
				BayPlanCntrDetailVO[] bayDetailVos = new BayPlanCntrDetailVO[manifestTransmitVOs.length];
				condVvd = ((StiDetailVO) manifestTransmitVOs[0]).getVvd();
				/*
				 * 조회시 skd_dir_cd가 "E" -> "W"바뀌는 경우가 있습니다.
				 * 로직은 조회 로직 참고 하세요
				 */
				searchVvdCd = ((StiDetailVO) manifestTransmitVOs[0]).getSearchVvdCd(); 
				pod = ((StiDetailVO) manifestTransmitVOs[0]).getPod();
				lastpol = ((StiDetailVO) manifestTransmitVOs[0]).getLPol();
				usrId = ((StiDetailVO) manifestTransmitVOs[0]).getTmp1();
				ofcCd = ((StiDetailVO) manifestTransmitVOs[0]).getTmp2();
				
				for (int i = 0; i < manifestTransmitVOs.length; i++)
				{
					if (i == 0)
					{
						vslCondVo = new VesselEtaCondVO();
						vo = (StiDetailVO) manifestTransmitVOs[i];
						vslCondVo.setVvd(condVvd);
						vslCondVo.setLastpol(vo.getLPol());
						// DBDAO 조회 호출.
						vslVo = dbDao.searchVesselEta(vslCondVo);
						
						if(vslVo == null) throw new EventException(new ErrorHandler("BKG00841", new String[] {}).getMessage());
						usPortCd = vslVo.getUsPortCd();
						flatFile.append("MSG_FUNC:").append("O").append("\n");
						flatFile.append("MSG_DATE:").append(vslVo.getCurrdate()).append("\n");
						flatFile.append("VSL_CD:").append(vslVo.getVslCd()).append("\n");
						flatFile.append("VOY:").append(vslVo.getSkdVoyNo()).append("\n");
						flatFile.append("DIR:").append(vslVo.getSkdDirCd()).append("\n");
						flatFile.append("CALLSIGN:").append(vslVo.getCallSgnNo()).append("\n");
						flatFile.append("LLOYD_CD:").append(vslVo.getLloydNo()).append("\n");
						flatFile.append("VSL_NM:").append(vslVo.getVslEngNm()).append("\n");
						flatFile.append("POL:").append(vslVo.getVpsPortCd()).append("\n");
						flatFile.append("PPORT_ATA:").append(vslVo.getVpsEtaDt()).append("\n");
						flatFile.append("PPORT_ETD:").append(vslVo.getVpsEtdDt()).append("\n");
						// ATD정보가 없어서 ETD 값으로 넣음.
						flatFile.append("PPORT_ATD:").append(vslVo.getVpsEtdDt()).append("\n");
						flatFile.append("NPORT:").append(vslVo.getUsPortCd()).append("\n");
						flatFile.append("NPORT_ETA:").append(vslVo.getUsEtaDt()).append("\n");
						flatFile.append("LOAD_VOY:").append("\n");
					}
					vo = (StiDetailVO) manifestTransmitVOs[i];
					bayCondVo = new BayPlanCntrListCondVO();
					bayCondVo.setVvd(searchVvdCd);
					bayCondVo.setLastpol(vo.getLPol());
					bayCondVo.setCntrNo(vo.getCntrNo());
					// 컨테이너별로 BayPlan을 조회하는 DBDAO 호출.
					bayDetailVo = dbDao.searchBayPlanCntrList(bayCondVo);
					if (bayDetailVo != null)
					{
						flatFile.append("{CNTR_INFO").append("\n");
						flatFile.append("CNTRNBR:").append(bayDetailVo.getCntrNo()).append("\n");
						flatFile.append("CNTRTYPE:").append(bayDetailVo.getCntrtype()).append("\n");
						flatFile.append("FM_IND:").append(bayDetailVo.getFmInd()).append("\n");
						flatFile.append("CNTR_STATUS:").append("\n");
						flatFile.append("EQA_UNIT:").append("\n");
						flatFile.append("EQA_VAL:").append("\n");
						flatFile.append("STW_POS:").append(bayDetailVo.getPos()).append("\n");
						flatFile.append("WGT_UNIT:").append("KGM").append("\n");
						flatFile.append("WGT_VAL:").append(bayDetailVo.getWgt()).append("\n");
						flatFile.append("OVF_IND:").append("\n");
						flatFile.append("OVF_VAL:").append("\n");
						flatFile.append("OVR_IND:").append("\n");
						flatFile.append("OVR_VAL:").append("\n");
						flatFile.append("OVLW_IND:").append("\n");
						flatFile.append("OVLW_VAL:").append("\n");
						flatFile.append("OVRW_IND:").append("\n");
						flatFile.append("OVRW_VAL:").append("\n");
						flatFile.append("OVH_IND:").append("\n");
						flatFile.append("OVH_VAL:").append("\n");
						flatFile.append("TUNIT:").append("\n");
						flatFile.append("TEMP:").append("\n");
						flatFile.append("TEMP_MIN:").append("\n");
						flatFile.append("TEMP_MAX:").append("\n");
						flatFile.append("POR:").append(bayDetailVo.getPor()).append("\n");
						flatFile.append("POL:").append(bayDetailVo.getPol()).append("\n");
						flatFile.append("POD:").append(bayDetailVo.getPod()).append("\n");
						flatFile.append("DEL:").append(bayDetailVo.getDel()).append("\n");
						flatFile.append("REF_NO:").append("\n");
						flatFile.append("IMDG_CD:").append(bayDetailVo.getImdg()).append("\n");
						flatFile.append("PAGE:").append("\n");
						flatFile.append("UNNBR:").append(bayDetailVo.getUnno()).append("\n");
						flatFile.append("FLSH_UNIT:").append("\n");
						flatFile.append("FLSH_TEMP:").append("\n");
						flatFile.append("CLASS:").append("\n");
						flatFile.append("EMS:").append("\n");
						flatFile.append("MFAG:").append("\n");
						flatFile.append("SCAC:").append(bayDetailVo.getScac()).append("\n");
						flatFile.append("}CNTR_INFO").append("\n");
					}
					// 조회결과를 배열에 Set up.
					bayDetailVos[i] = bayDetailVo;
				}
				// BKG_CSTMS_ADV_STWG_SND_LOG 입력을 위한 VO.
				String seq = dbDao.searchDateSeq();
				// Message Header를 위한 seq 변형.
				// -> DB에는 yyyymmddhh24miss#####(시퀀스5자리)로 들어가지면 헤더에 출력할때는 yymmdd#####의 형태로 되어야 한다.
				String seqForHeader = seq.substring(2, 8) + seq.substring(14);
				flatFile.insert(0, "$$$MSGSTART:SMLM                USCBP               BAPLIE    BKC" + seqForHeader
						+ "\n");
				String lsDate = dbDao.searchSysdate("yyyymmddhh24miss");
				SendDetailLogVO sendDetailLogVO = new SendDetailLogVO();
				sendDetailLogVO.setSndProcId("STW");
				sendDetailLogVO.setSeq(seq);
				sendDetailLogVO.setVvd(condVvd);
				sendDetailLogVO.setPol(lastpol);
				sendDetailLogVO.setUsrId(usrId);
				sendDetailLogVO.setOfcCd(ofcCd);
				sendDetailLogVO.setCntrCount(Integer.toString(manifestTransmitVOs.length));
				sendDetailLogVO.setSndDt(lsDate);
				// POD는 Row중 첫번째 POD로 지정한다. 이 방법은 추후 확인을 받아야 한다.
				// 조회조건상의 POD를 입력한다. 없으면 안 넣는다.
				sendDetailLogVO.setPod(pod);				
				sendDetailLogVO.setCstmsPortCd(usPortCd);	// CSTMS_PORT_CD 칼럼 추가
				
				// BKG_CSTMS_ADV_STWG_SND_LOG 입력 실행.
				int result = dbDao.addStowageSendLog(sendDetailLogVO);
				if (result > 0)
				{
					StringTokenizer token = new StringTokenizer(flatFile.toString(), "\n");
					int i = 1;
					int j = 0; // 개행문자를 j 가 0보다 큰경우, 구문 앞에 추가한다.
					String tmpStr = "";
					String lineStr = "";
					StringBuffer lineBuf = new StringBuffer();
					while (token.hasMoreTokens())
					{
						tmpStr = token.nextToken();
						if (j > 0)
							tmpStr = "\n" + tmpStr;
						lineStr = lineBuf.toString();
						lineBuf.append(tmpStr);
						// 4000Byte 까지 채운다.
						// tmpStr까지 합친 값이 3900바이트를 넘는다면, 이전까지 취합되었던 lineStr만을
						// 로그에 넣고, 다시 초기화 한다.
						if (lineBuf.length() > 3900)
						{
							sendDetailLogVO.setDtlSeq(i + "");
							sendDetailLogVO.setMsg(lineStr);
							dbDao.addSendDetailLog(sendDetailLogVO);
							i++;
							lineBuf = new StringBuffer(tmpStr);
						}
						j++;
					}
					if (lineBuf.length() > 0)
					{
						sendDetailLogVO.setDtlSeq(i + "");
						sendDetailLogVO.setMsg(lineBuf.toString());
						dbDao.addSendDetailLog(sendDetailLogVO);
					}
				}
				result = 0;
				SendLogDetailVO sendLogDetailVO = new SendLogDetailVO();
				;
				// ams_stowplan Proc파일에서는 전달받은 컨테이너 번호를 다시 한번 루프돌려 조회하는 로직.
				// 그러나, 조회내용이 위에서 조회한 searchBayPlanCntrList 와 동일하므로 이를 생략하고,
				// 위에서 구한 bayDetailVos로 루프를 돌려 이후 로직을 구현한다.
				for (int i = 0; i < bayDetailVos.length; i++)
				{
					bayDetailVo = new BayPlanCntrDetailVO(); // 초기화.
					bayDetailVo = bayDetailVos[i];
					// BKG_CSTMS_ADV_STWG_CNTR 갱신및 입력을 위한 VO.
					sendLogDetailVO.setCntrNo(bayDetailVo.getCntrNo());
					sendLogDetailVO.setDel(bayDetailVo.getDel());
					sendLogDetailVO.setLastpol(lastpol);
					sendLogDetailVO.setOfcCd(ofcCd);
					sendLogDetailVO.setPod(bayDetailVo.getPod());
					sendLogDetailVO.setPol(bayDetailVo.getPol());
					sendLogDetailVO.setPos(bayDetailVo.getPos());
					sendLogDetailVO.setSeq(seq);
					sendLogDetailVO.setUsrId(usrId);
					sendLogDetailVO.setVvd(searchVvdCd);
					// BKG_CSTMS_ADV_STWG_CNTR 갱신 실행.
					result = dbDao.modifySendLogByCntr(sendLogDetailVO);
					if (result == 0)
					{
						result = dbDao.addSendLogByCntr(sendLogDetailVO);
					}
				}
			}
			/*********************************************
			 * // Message Send Start
			 *********************************************/
			BookingUtil command2 = new BookingUtil();
			FlatFileAckVO flatFileAckVO = null;
			SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
			sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CUSTOMS.IBMMQ.QUEUE"));
			sendFlatFileVO.setFlatFile(flatFile.toString());
			flatFileAckVO = command2.sendFlatFile(sendFlatFileVO);
			if (flatFileAckVO.getAckStsCd().equals("E"))
				throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
			/*********************************************
			 * // Message Send End.
			 *********************************************/
			log.info(flatFile.toString());
			return flatFile.toString();
		}
		catch (EventException ex)
		{
			log.error("err " + ex.toString(), ex);
			throw ex;
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
	}

	/**
	 * BackEndJob을 실행.
	 * 
	 * @param account SignOnUserAccount
	 * @param ManifestTransmitVO[] manifestTransmitVO
	 * @param String pgmNo
	 * @return String
	 * @throws EventException
	 */
	public String startBackEndJob(SignOnUserAccount account, ManifestTransmitVO[] manifestTransmitVO, String pgmNo)
			throws EventException {
		try
		{
			UsaCustomsTransmissionBackEndJob backEndJob = new UsaCustomsTransmissionBackEndJob();
			backEndJob.setPgmNo(pgmNo);
			String resultStr = "";
			if (pgmNo.equals("ESM_BKG_1023"))
			{
				backEndJob.setStiDetailVO((StiDetailVO[]) manifestTransmitVO);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				resultStr = backEndJobManager.execute(backEndJob, account.getUsr_id(), "Vessel Stowage Plan Transmit.");
			}
			else if (pgmNo.equals("ESM_BKG_0613"))
			{
				backEndJob.setUsaManifestSearchDetailVO((UsaManifestSearchDetailVO[]) manifestTransmitVO);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				resultStr = backEndJobManager.execute(backEndJob, account.getUsr_id(), "MI Transmit.");
			}
			else if (pgmNo.equals("ESM_BKG_0615")) 
			{
				backEndJob.setUsaManifestSearchDetailVO((UsaManifestSearchDetailVO[]) manifestTransmitVO);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				resultStr = backEndJobManager.execute(backEndJob, account.getUsr_id(), "XI Transmit.");
			}
			else if (pgmNo.equals("ESM_BKG_0408"))
			{
				backEndJob.setUsaManifestSearchDetailVO((UsaManifestSearchDetailVO[]) manifestTransmitVO);
				backEndJob.setAccount(account);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				resultStr = backEndJobManager.execute(backEndJob, account.getUsr_id(), "P/MIB Generate(AI) Transmit.");
			}
			else if (pgmNo.equals("ESM_BKG_0034")) 
			{
				backEndJob.setUsaManifestSearchDetailVO((UsaManifestSearchDetailVO[]) manifestTransmitVO);
				backEndJob.setAccount(account);
				BackEndJobManager backEndJobManager = new BackEndJobManager();
				resultStr = backEndJobManager.execute(backEndJob, account.getUsr_id(), "US AMS: B/L Inquiry");
			}
			return resultStr;
			// DAO 호출이 없으므로 DAOException을 catch하는 부분은 생략한다.
		}
		catch (Exception ex)
		{
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * EDI 수신으로 받은 문자열을 Parsing 하여 msg_tp값에 따라서 서로 다른 DAO 메소드를 호출한다.
	 * 
	 * @param RcvMsgVO rcvMsgVO
	 * @return RcvMsgVO
	 * @throws EventException
	 */
	public RcvMsgVO loadCstmsRcvMsg(RcvMsgVO rcvMsgVO) {

		UsaRcvMsgVO usaRcvMsgVO = (UsaRcvMsgVO) rcvMsgVO;
		String rcvMsg = usaRcvMsgVO.getRcvMsg();
		// * 으로 나뉘어진 구문은 \n 으로 바꿔준다.
		if (rcvMsg.indexOf("*") >= 0)
		{
			StringTokenizer token = new StringTokenizer(rcvMsg, "*");
			rcvMsg = "";
			int i = 0;
			while (token.hasMoreTokens())
			{
				if (i > 0)
					rcvMsg = rcvMsg + "\n" + token.nextToken();
				else
					rcvMsg = rcvMsg + token.nextToken();
				i++;
			}
		}
		//2015.02.13 [ ~ instead of # ]
		// ~ 으로 나뉘어진 구문은 \n 으로 바꿔준다.
		if (rcvMsg.indexOf("~") >= 0)
		{
			StringTokenizer token = new StringTokenizer(rcvMsg, "~");
			rcvMsg = "";
			int i = 0;
			while (token.hasMoreTokens())
			{
				if (i > 0)
					rcvMsg = rcvMsg + "\n" + token.nextToken();
				else
					rcvMsg = rcvMsg + token.nextToken();
				i++;
			}
		}
		//2015.02.13 [삭제예정]		
		// # 으로 나뉘어진 구문은 \n 으로 바꿔준다.
		if (rcvMsg.indexOf("#") >= 0)
		{
			StringTokenizer token = new StringTokenizer(rcvMsg, "#");
			rcvMsg = "";
			int i = 0;
			while (token.hasMoreTokens())
			{
				if (i > 0)
					rcvMsg = rcvMsg + "\n" + token.nextToken();
				else
					rcvMsg = rcvMsg + token.nextToken();
				i++;
			}
		}
		
		try
		{
			//@ Baplie 응답 수신 BR 처리
			// AMS Customs 수신 메시지 $$$MSGSTART로 시작할 경우 순서에 따라 처리 2011.10.10
			if (rcvMsg.startsWith("$$$MSGSTART")) {
				this.getAmsCusResMsg(rcvMsg, usaRcvMsgVO);
				return rcvMsgVO;
			}
			
			// ACRSMLM로 시작하는지 여부를 체크.
			if (!rcvMsg.startsWith("ACRSMLM"))
			{
				return rcvMsgVO;
			}
			
			//@ MR/AR/HR/TR/SN(ISF응답)/RC/RB(Baplie Notification - RC로 수신됨 R06항목(ACC,INC)으로 RB 구분) 처리
			// getAmsRcvMsg 구, Get_Ams_Rcv_Msg() 실행.
			this.getAmsRcvMsg(rcvMsg, usaRcvMsgVO);
			// POL 수정
			if ("".equals(JSPUtil.getNull(usaRcvMsgVO.getPolCd())))
			{
				if (!"".equals(JSPUtil.getNull(usaRcvMsgVO.getCrrBatNo())))
					 dbDao.modifyBkgCstmsAdvRcvLog(usaRcvMsgVO, "crr_bat_no");
				else if(!"".equals(JSPUtil.getNull(usaRcvMsgVO.getBlNo())))
					 dbDao.modifyBkgCstmsAdvRcvLog(usaRcvMsgVO, "bl_no");
			}
						
			// BL_NO 수정
			if(!"".equals(JSPUtil.getNull(usaRcvMsgVO.getBlNo()))){
				dbDao.modifyBkgCstmsAdvRcvLogBl(usaRcvMsgVO);
			}

			/******************************************************************************/
			/* 20091103, ISF5로 구동한 메시지는 이후 로직을 태우지 않는다. */
			/******************************************************************************/
			if ("".equals(usaRcvMsgVO.getIsfInBl()))
			{
				BkgCstmsAdvBlVO bkgCstmsAdvBlVO = dbDao.searchAdvBl(usaRcvMsgVO.getBlNo(), "US");
				if (bkgCstmsAdvBlVO != null)
				{
					if ("".equals(bkgCstmsAdvBlVO.getMfNo()))
					{
						usaRcvMsgVO.setMasterOrHouse("M");
						usaRcvMsgVO.setMblNo(usaRcvMsgVO.getBlNo());
					}
					else
					{
						usaRcvMsgVO.setMasterOrHouse("H");
						usaRcvMsgVO.setMblNo(bkgCstmsAdvBlVO.getMfNo());
						usaRcvMsgVO.setHblNo(usaRcvMsgVO.getBlNo());
						usaRcvMsgVO.setBlNo(bkgCstmsAdvBlVO.getMfNo());
					}
					if ("SMLM".equals(usaRcvMsgVO.getInSnp()))
					{
						if ("H".equals(usaRcvMsgVO.getMasterOrHouse()))
						{
							this.getAmsRcvMsgM(rcvMsg, usaRcvMsgVO);
						}
					}
					else if ("CNRU".equals(usaRcvMsgVO.getInSnp()))
					{
						/* cnru_it가 Y이면 INBOND_TRANS에 CNRU B/L있는것이고, N이면 없는것이다... */
						/* 그래서 Y이면 위의 1ST 스테이지 Get_ams_rcv_msg를 제대로 다 수행했을테니 여기서 마치고 */
						/* N이면 Get_ams_rcv_msg_N을 수행한다. */
						if ("N".equals(usaRcvMsgVO.getCnruIt()))
						{
							this.getAmsRcvMsgN(rcvMsg, usaRcvMsgVO);
						}
					}
					else
					{
						// 추가 김민정
						this.getAmsRcvMsgN(rcvMsg, usaRcvMsgVO);
					}
				}
			}
			
		}catch (Exception ex){
			log.error(new ErrorHandler("BKG00707", new String[] { "US Recieve " + "MSG["+rcvMsg+"]" }).getMessage());
			log.info(new ErrorHandler("BKG00707", new String[] { "US Recieve " + "MSG["+rcvMsg+"]" }).getMessage());
		}
		return usaRcvMsgVO;
	}

	/**
	 * AMS Customs 메시지를 순서에 따라 처리한다<br>
	 * Baplie 응답 처리 BR
	 * @param String msg
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @throws DAOException
	 */
	private void getAmsCusResMsg(String msg, UsaRcvMsgVO usaRcvMsgVO) throws DAOException{
		if(msg == null || msg.equals("")) return;

		/**
		 * msg 파싱해서 VO에 담기
		 */
		// 수신 msg 의 ORG_FF_REF_NO로 관련 데이터 구하기
		String orgRefNo = getReceiveSingleItem(msg, "ORG_FF_REF_NO:", "\n");
		UsaRcvMsgVO orgRefVO = dbDao.searchCusResDataBySndId(orgRefNo);
		
		usaRcvMsgVO.setIsBaplieRC("N");
		usaRcvMsgVO.setIrType("BR");
		if(orgRefVO != null){
			usaRcvMsgVO.setVslCd(orgRefVO.getVslCd());
			usaRcvMsgVO.setSkdVoyNo(orgRefVO.getSkdVoyNo());
			usaRcvMsgVO.setSkdDirCd(orgRefVO.getSkdDirCd());
			usaRcvMsgVO.setPolCd(orgRefVO.getPolCd());
			usaRcvMsgVO.setPodLoc(orgRefVO.getPodCd());
		}else{ //해당하는 값이 존재하지 않을 때 수신한 msg로부터 Data를 획득해서 입력한다.
			String msgVvd = "";
			msgVvd = getReceiveSingleItem(msg, "VVD:", "\n");
			usaRcvMsgVO.setSkdVoyNo(msgVvd.substring(0,4)); //수신 msg의 VVD형식 : ex>0106E
			usaRcvMsgVO.setSkdDirCd(msgVvd.substring(4,5));
			usaRcvMsgVO.setPolCd(getReceiveSingleItem(msg, "POL_PORT:", "\n"));
			usaRcvMsgVO.setPodLoc(getReceiveSingleItem(msg, "NEXT_PORT:", "\n"));
		}
		
		usaRcvMsgVO.setCrrBatNo(orgRefNo);
		usaRcvMsgVO.setAckResult(getReceiveSingleItem(msg, "ACK_RESULT:", "\n"));
		usaRcvMsgVO.setAckCode(getReceiveSingleItem(msg, "ACK_CODE:", "\n"));
		usaRcvMsgVO.setAckDesc(getReceiveSingleItem(msg, "ACK_DESCRIPTION:", "\n"));
		usaRcvMsgVO.setIrDate(getReceiveSingleItem(msg, "FILE_RCV_DATE:", "\n"));
		usaRcvMsgVO.setIrBatchNo(getReceiveSingleItem(msg, "CONTROL_NO:", "\n"));
		usaRcvMsgVO.setIrSeq(dbDao.searchMaxIrSeq(usaRcvMsgVO));
		
		// BKG_CSTMS_ADV_RCV_LOG insert
		dbDao.addRcvLogMst(usaRcvMsgVO);
		// BKG_CSTMS_ADV_RCV_LOG_DTL insert
		usaRcvMsgVO.setIrBatchNo(""); //BKG_CSTMS_ADV_RCV_LOG_DTL에는 해당 값을 Insert 하지 않는다.
		StringTokenizer token = new StringTokenizer(msg, "\n");
		token = new StringTokenizer(msg, "\n");
		int k = 0;
		while (token.hasMoreTokens())
		{
			String str = token.nextToken();
			k++;
			usaRcvMsgVO.setRcvMsgDtlSeq(Integer.toString(k));
			usaRcvMsgVO.setMsgDesc(str);
			dbDao.addRcvLogDetail(usaRcvMsgVO);
		}
		//STOWAGE SEND LOG 테이블 업데이트
		dbDao.modifyBaplieCusResSndLog(usaRcvMsgVO);
		
		List<String> errList = getReceiveMultiItem(msg, "\\{ERROR_DETAIL","}ERROR_DETAIL");
		if(errList != null && errList.size()> 0){
			//cntr_no별 error result 업데이트
	        for (int i = 0; i < errList.size(); i++) {
	        	usaRcvMsgVO.setCntrNo(getReceiveSingleItem		(errList.get(i), "CNTR_NO:",	 	"\n"));
				usaRcvMsgVO.setErrResult(getReceiveSingleItem	(errList.get(i), "ERROR_RESULT:", 	"\n"));
				usaRcvMsgVO.setErrCode(getReceiveSingleItem		(errList.get(i), "ERROR_CODE:", 	"\n"));
				usaRcvMsgVO.setErrDesc(getReceiveSingleItem		(errList.get(i), "ERROR_DESC:", 	"\n"));
				
				dbDao.modifyBaplieCusResByCntr(usaRcvMsgVO);
	  		}
        }
    	//ERROR_DETAIL 없을 시 나머지 항목 모두 ACK로 업데이트
    	dbDao.modifyBaplieCusResByVvd(usaRcvMsgVO);
	}

	String cstmsLocDiffFlg = "";
	/**
	 * 메시지를 순서에 따라 처리한다<br>
	 * MR /AR /HR /TR /SN(ISF응답) /RC  /RB(Baplie Notification - RC로 수신됨 R06항목(ACC,INC)으로 RB 구분) 처리
	 * @param String msg
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 * @throws EventException
	 */
	private int getAmsRcvMsg(String msg, UsaRcvMsgVO usaRcvMsgVO) {
		int r = 0;
		usaRcvMsgVO.setIsfInBl("");
		List<String> isfInRemark = new ArrayList<String>();
		StringTokenizer token = new StringTokenizer(msg, "\n");
		String prefix3 = "";
		String prefix4 = "";
		
		cstmsLocDiffFlg = "N";
		
		while (token.hasMoreTokens())
		{
			String str = token.nextToken();
			if (str != null && str.length() >= 80)
			{
				prefix3 = str.substring(0, 3);
				prefix4 = str.substring(0, 4);
				if ("ACR".equals(prefix3))
				{
					usaRcvMsgVO.setIrType(str.substring(13, 15));   // MR/AR/HR/TR/SN(ISF응답)/RC
					usaRcvMsgVO.setIrDate(str.substring(15, 27));   // YYMMDDHHMMSS-170115015959
					usaRcvMsgVO.setIrBatchNo(str.substring(27, 32));// CBP Batch Number
				}
				else if ("M01".equals(prefix3))
				{
					usaRcvMsgVO.setInSnp(str.substring(3, 7));
					usaRcvMsgVO.setVslEngNm(str.substring(11, 34));
					// 사용안하게 될것임. M02를 사용
					usaRcvMsgVO.setSkdVoyNo(str.substring(34, 38));
					usaRcvMsgVO.setSkdVoyNoM(str.substring(34, 39));
					usaRcvMsgVO.setSkdDirCd(str.substring(38, 39));
				}
				else if ("M02".equals(prefix3))
				{
					/******************************************************
					 * 2009/11/10 하동일 수석 : MO2 이후 30자리에 대해 파싱처리한 후<BR>
					 * bkg_cstms_adv_rcv_log.crr_bat_no 에 넣을 수 있도록 추가 요청함.<BR>
					 * as-is 에는 없는 부분임.<BR>
                     * 참고로, 실제 운영되는 메시지 중에는 W02 도 있으나,<BR>
                     * as-is 에도 처리내역이 없기에 하수석과 확인한 후 넘어감.
					 ******************************************************/
					usaRcvMsgVO.setCrrBatNo(str.substring(3, 33));
					usaRcvMsgVO.setVslCd(str.substring(7, 11));
					usaRcvMsgVO.setSkdVoyNo(str.substring(11, 15));
					usaRcvMsgVO.setSkdDirCd(str.substring(15, 16));
					usaRcvMsgVO.setSkdVoyNoM(str.substring(11, 16));
				}
				else if ("P01".equals(prefix3))
				{
					usaRcvMsgVO.setPodAmsport(str.substring(3, 7));
					usaRcvMsgVO.setPodAmsportM(str.substring(3, 7));
					usaRcvMsgVO.setLocAmsPortCd(str.substring(3, 7));
				}
				else if ("R01".equals(prefix3))
				{
					usaRcvMsgVO.setPodAmsport(str.substring(7, 11));
					usaRcvMsgVO.setPodAmsportM(str.substring(7, 11));
					usaRcvMsgVO.setLocAmsPortCd(str.substring(7, 11));
				}
				else if ("R02".equals(prefix3))
				{
					r++;
					//@ R02 Continuation
					if (r % 2 == 0) 
					{
						if (str.substring(11, 12).equals(" ") || str.substring(11, 15).equals("0000"))
						{
							usaRcvMsgVO.setCusAmsport(str.substring(3, 7)); // POD
						}
						else
						{
							usaRcvMsgVO.setDestLocCd(str.substring(3, 7)); // POD
							usaRcvMsgVO.setCusAmsport(str.substring(11, 15));// INBOND TRANSPORTATION(IT) PORT CODE(DEL)
						}
					}
				}
				/*********************************************/
				/* 2011.04.27  'C01 항목으로 리스팅 된 Cntr 에 대해 R03 의 Remark 를 표기' 처리를 위해 추가함. */
				/*********************************************/				
				else if ("R03".equals(prefix3))
				{
					usaRcvMsgVO.setCstmsRmk1(str.substring(3,53));
				}
				/*********************************************/
				/* 2011.04.27  'C01 항목으로 리스팅 되지 않은 CNTR 에 대해 해당 VVD의 BAPLIE 전송이력이 있는 CNTR 는 모두 ACK 로 표기' 처리를 위해 추가함. */
				/*********************************************/				
				else if ("R06".equals(prefix3))
				{
					if ("INC".equals(str.substring(3, 6)) || "ACC".equals(str.substring(3, 6))){
						usaRcvMsgVO.setIsBaplieRC("Y");
					} 
				}				
				/*********************************************/
				/* 20091028 JHPARK ISF-5 처리를 위해 추가함. */
				/*********************************************/
				else if ("SF10".equals(prefix4))
				{
					usaRcvMsgVO.setIsfTranNo(str.substring(38, 53));
				}
				else if ("SF15".equals(prefix4))
				{
					usaRcvMsgVO.setIsfInBl(str.substring(10, 22));
				}
				else if ("SF90".equals(prefix4))
				{
					usaRcvMsgVO.setIsfRcvCd(str.substring(4, 6));
					isfInRemark.add(str.substring(9, 49));
				}
			
			} // if str valid
		}// while msg tokenized
		if (isfInRemark != null && isfInRemark.size() > 0)
		{
			usaRcvMsgVO.setIsfInRemark1(isfInRemark.get(0));
			if (isfInRemark.size() > 1)
			{
				usaRcvMsgVO.setIsfInRemark2(isfInRemark.get(1));
			}
		}
		if ("".equals(usaRcvMsgVO.getIrDate()))
		{
			usaRcvMsgVO.setIrDate(dbDao.searchSysdate("RRMMDDHH24MISS"));
		}		
		usaRcvMsgVO.setVslEngNmM(usaRcvMsgVO.getVslEngNm());
		/***************************************************************************/
		/* 20091029 JHPARK ISF-5 ACK 를 수신하면 inbond_rlog 의 VVD 에 'UNKNOWN00' */
		/* 을 삽입한다. View Received File 을 하기 위해서.. */
		/***************************************************************************/
		if (!"".equals(usaRcvMsgVO.getIsfInBl()) && isfInRemark != null && isfInRemark.size() > 0 && !"".equals(isfInRemark.get(0)))
		{
			usaRcvMsgVO.setVslCd("UNKN");
			usaRcvMsgVO.setSkdVoyNo("OWN0");
			usaRcvMsgVO.setSkdDirCd("0");
		}
		else
		{
			if ("".equals(JSPUtil.getNull(usaRcvMsgVO.getVslCd())))
			{
				VslNameVO vslNameVO = dbDao.searchVslCdByVslNm(usaRcvMsgVO);
				if (vslNameVO == null || "".equals(vslNameVO.getVslCd()))
				{
					vslNameVO = dbDao.searchVslCdByVslNm2(usaRcvMsgVO);
					if (vslNameVO == null || "".equals(vslNameVO.getVslCd()))
					{
						// CAMIR에서 사용하는 VESSEL NAME 최대는 23 BYTE
						// KEWB가 23 BYTE를 넘는 이름을 가지고 있음
						// KEWB를 찾기 위해 23 BYTE만 끊어서 비교토록 함
						vslNameVO = dbDao.searchVslCdByVslNm3(usaRcvMsgVO);
					}
				}
				if (vslNameVO == null || "".equals(vslNameVO.getVslCd()))
				{
					usaRcvMsgVO.setVslCd(usaRcvMsgVO.getVslEngNm().substring(0, 4));
				}
				else
				{
					usaRcvMsgVO.setVslCd(vslNameVO.getVslCd());
				}
			}
		}
		usaRcvMsgVO.setVslCdM(usaRcvMsgVO.getVslCd());
		String podLoc = "";
		String podLocM = "";
		// podAmsport에 의해 mdm_location에서 pod_cd를 구하는 로직이나,
		// ISF-5등에서는 podAmsport가 ""이므로 실행해도 의미가 없다.
		if (!"".equals(usaRcvMsgVO.getLocAmsPortCd()))
		{
			UsaLocationVO usaLocationVO = dbDao.searchLocCdByAmsPort(usaRcvMsgVO);
			if (usaLocationVO != null)
			{
				podLoc = usaLocationVO.getLocCd();
				podLocM = usaLocationVO.getLocCd();
			}
		}
		usaRcvMsgVO.setPodLoc(podLoc);
		usaRcvMsgVO.setPodLocM(podLocM);
		if (!"".equals(usaRcvMsgVO.getCusAmsport()))
		{
			UsaLocationVO usaLocationVO = dbDao.searchLocCdForCustomsLoc(usaRcvMsgVO);
			if (usaLocationVO != null)
			{
				usaRcvMsgVO.setCusLoc(usaLocationVO.getLocCd());
			}
		}
		usaRcvMsgVO.setIrDateM(usaRcvMsgVO.getIrDate());
		usaRcvMsgVO.setIrSeq(dbDao.searchMaxIrSeq(usaRcvMsgVO));
		// BKG_CSTMS_ADV_RCV_LOG insert
		dbDao.addRcvLogMst(usaRcvMsgVO);
		// BKG_CSTMS_ADV_RCV_LOG_DTL insert
		token = new StringTokenizer(msg, "\n");
		int k = 0;
		
		//W01 에서 메일 보내기 위한 변수
		StringBuffer tRejMessage = new StringBuffer();		
		String reBlNo    = "";
		String inCodeTemp = "";
		String inCodeTemp2 = "";
		BkgCstmsAdvBlVO bkgCstmsAdvBlTempVO = null;
		String str2Q2ZYn = "N";
		String holdMessage = "";
		
		while (token.hasMoreTokens())
		{
			String str = token.nextToken();
			k++;
			usaRcvMsgVO.setRcvMsgDtlSeq(Integer.toString(k));
			usaRcvMsgVO.setMsgDesc(str);
			dbDao.addRcvLogDetail(usaRcvMsgVO);
			
			//W01 에서 메일 보내기			
			if ("W01".equals(str.substring(0, 3))) {
				reBlNo    = str.substring(3, 15);
				if ( !"".equals(reBlNo) && !"".equals(str.substring(39, 80))) {
					tRejMessage.append(str.substring(39, 80)+"<br>");
				}
			}
			//R02 2Q,2Z중에 US FILER가 02인 경우 화주에 메일 보내기	
			if ("R02".equals(str.substring(0, 3))) {
				inCodeTemp = str.substring(15, 17);
				if ( str.substring(3, 15).trim().length() > 10 ) {
					reBlNo = str.substring(3, 15);
					bkgCstmsAdvBlTempVO = dbDao.searchAdvBl(reBlNo, "US");
					if ( bkgCstmsAdvBlTempVO != null) {
						if ( "2".equals(bkgCstmsAdvBlTempVO.getCstmsFileTpCd())) {
							if ( "2Q".equals(inCodeTemp) || "2Z".equals(inCodeTemp)) {
								str2Q2ZYn = "Y";
								inCodeTemp2 = inCodeTemp;
							}
						}
					}
				}
			}
			//R02 2Q,2Z중에 US FILER가 02인 경우 화주에 메일 보내기	
			if ("R03".equals(str.substring(0, 3)) && str2Q2ZYn.equals("Y")) {
				holdMessage = str.substring(3, 53);
			}	
			
			//03 FILER의 경우 NVOCC에 의한 H/BL 전송으로 69 code를 수신할 경우 Manifest 전송자와 BKG Staff에게 발송.
			if ("W01".equals(str.substring(0, 3)) && ("MR".equals(usaRcvMsgVO.getIrType()) || "AR".equals(usaRcvMsgVO.getIrType()) )) {
				reBlNo    = str.substring(3, 15);
				if ( !"".equals(reBlNo) && "325".equals(str.substring(39, 42))) { //MASTER BILL TYPE EXPECTED
					String sendYn = dbDao.searchAutoHouseCheck(reBlNo, usaRcvMsgVO.getIrDate());
					if ( "Y".equals(sendYn)) {
						sendAmsNtcToObStaffHouseBl(usaRcvMsgVO,reBlNo);
					}
				}
			}			
			
		}
		
		//W01 에서 메일 보내기		
		if ( !"".equals(tRejMessage.toString())) {
			sendAmsNtcToObStaff(usaRcvMsgVO,reBlNo,tRejMessage.toString());
		}
		//R02 2Q,2Z중에 US FILER가 02인 경우 화주에 메일 보내기	
		if ( "Y".equals(str2Q2ZYn) && !"".equals(holdMessage)) {
			sendAmsHoldNtcSend(usaRcvMsgVO,reBlNo,holdMessage,inCodeTemp2);
		}
		
		/******************************************************************************/
		/* PARSE DETAIL RECORD */
		/******************************************************************************/
		/******************************************************************************/
		/* 02 Filer의 NVOCC H B/L 인 경우를 대비하여, */
		/* 첫번째 R02의 B/L을 NVOCC house B/L로 가지고, */
		/* 두번째 R02의 B/L을 SML master B/L로 가지고 있는다. */
		/******************************************************************************/
		/******************************************************************************/
		/* R05의 CNTR 정보를 가져 온다. (as-is 소스의 R02, R05 를 구하는 로직을 to-be에서는 통합함. */
		/******************************************************************************/
		token = new StringTokenizer(msg, "\n");
		r = 0;
		String inNvobl = "";
		String inHjbl = "";
		String inCntr = "";
		while (token.hasMoreTokens())
		{
			String str = token.nextToken();
			if (str != null && str.length() >= 80)
			{
				prefix3 = str.substring(0, 3);
				if ("R02".equals(prefix3) && r == 0)
				{
					//@ NVOCC(Filer 02 House B/L copy 수신) 또는  캐나다에서 들어오는 컨테이너의 경우 Nvobl No. SCAC 코드가 SMLM이면 ALPS B/L No.이다. 
					inNvobl = str.substring(3, 15); // eg.) R02AEV600106A017I0000001100                 1603111640             1            
					r++;
				}
				else if ("R02".equals(prefix3) && r == 1)
				{
					//@ NVOCC(Filer 02 House B/L copy 수신) 또는  캐나다에서 들어오는 컨테이너의 경우 R02 두번째 레코드가 alps B/L No.로 사용하게된다.
					//일반적으로 Carrier code(한진 9525,SML 918P) + B/L No.
					inHjbl = str.substring(40, 57); // eg.) R022811                              OB HJSCAEV600106400
					r++;
				}
				else if ("R05".equals(prefix3))
				{
					// R02 B/L의 컨테이너 목록-반복
					inCntr = str.substring(3, 14);
					inCntr = dbDao.searchCntrNo(inCntr);
				}
			} // if str valid
		}// while msg tokenized
		usaRcvMsgVO.setInNvobl(inNvobl);
		usaRcvMsgVO.setInHjbl(inHjbl);
		usaRcvMsgVO.setInCntr(inCntr);
		/******************************************************************************/
		/* 20091028 JHPARK ISF-5 별도로 inbond_customs_r table 에 저장한다. */
		/******************************************************************************/
		if (!"".equals(usaRcvMsgVO.getIsfInBl()) && isfInRemark != null && isfInRemark.size() > 0 && !"".equals(isfInRemark.get(0)))
		{
			this.putCustomsRIsf(usaRcvMsgVO);
		}
		/******************************************************************************/
		/* 레코드 ID별로 실제적으로 메시지 처리 하는 부분 시작 */
		/******************************************************************************/
		String zone = "";
		String inCode = "";
		String inCodeb = "";
		String icrResendInd = "";
		String cntrNo = "";
		String chkStrForBlNo = "";
		BkgCstmsAdvBlVO bkgCstmsAdvBlVO = null;
		token = new StringTokenizer(msg, "\n");
		
		String cloneToken[] = msg.split("\n");
		int cloneTokenIdx = 0;
		
		r = 0;
		int iR03 = 0;
		
		cstmsLocDiffFlg = "N";
		//@ MR/AR/HR/TR/RC/RB 해당 됨
		while (token.hasMoreTokens())
		{
			String str = token.nextToken();
					
			if (str != null && str.length() >= 80)
			{
				prefix3 = str.substring(0, 3);
				// W01 레코드 처리 - MR/AR/HR/TR
				if ("W01".equals(prefix3))
				{
					this.putNakMsg(str, usaRcvMsgVO);
					
				/******************************************************************************/
				/* R02 레코드 처리 - RC only */
				/******************************************************************************/
				}else if ("R02".equals(prefix3)){
					zone = str.substring(6, 7);// CNRU 용 코드
					inCode = str.substring(15, 17);
					inCodeb = str.substring(7, 8);
					icrResendInd = str.substring(68, 69);
					chkStrForBlNo = str.substring(3, 15);
					r++;
					usaRcvMsgVO.setZone(zone);
					usaRcvMsgVO.setInCode(inCode);
					usaRcvMsgVO.setInCodeb(inCodeb);
					usaRcvMsgVO.setIcrResendInd(icrResendInd);
					
					if ("SMLM".equals(usaRcvMsgVO.getInSnp()))
					{
						bkgCstmsAdvBlVO = dbDao.searchAdvBl(chkStrForBlNo, "US");
						/*****************************************************************************
						 * BL번호체계가 변경되므로, 아래 체크 로직을 BL테이블에 조회하여 결과가 있을경우로 수정함.<BR>
						 * by 김도완. 민수석 확인결과 'H'는 빠지는 것이 맞다고 함. <BR>
						 * 따라서, 하우스 BL인 경우는 제외함. <BR>
						 * => HOUSE B/L이더라도 putCustomsR을 태우고, 
						 * putCustomsR에서 Cargo Release부분 만 태우지 않는 것으로 수정하기로 함.<BR>
						 * HOUSE B/L일때, 태우지 않으면, bl_no 변수 값을 가져올수가 없는 사유.
						 *****************************************************************************/
						if (bkgCstmsAdvBlVO != null)
						{
							//@ R02 Continuation 부분은 처리 되지 않음.
							/*
							 * icrCode = '1C', '12' 일 경우 destLocCd 셋팅
							 * 12 ARRIVAL OF INBOND  BILL OF LADING
							 * 1C ENTERED AND RELEASED:  GENERAL EXAMINATION
							 * R02 Continueation(R02두번째 항목) CBP Port Code(Pod 관련)를  DestLocCd에 셋업
							 */
							if("1C".equals(inCode) || "12".equals(inCode)) {
								String r02_2 = cloneToken[cloneTokenIdx+1];
								if("R02".equals(r02_2.substring(0, 3))) {
									usaRcvMsgVO.setDestLocCd(r02_2.substring(3, 7));//@ 위에서 세팅한것을 중복 처리하고 있음.  R02 Continuation 참조
								}
								
							}
							
							this.putCustomsR(str, usaRcvMsgVO);
							iR03 = 0;
						}
						else
						{
							// R02 Continueation(R02두번째 항목) 결과코드 13,15이면 Cntr No. 셋팅  - 사용은 안하는 듯 함.
							// 13 ARRIVAL OF INBOND  CONTAINER
							// 52 EXPORT OF INBOND  CONTAINER
							if (usaRcvMsgVO.getIcrCode() != null && "13,52".indexOf(usaRcvMsgVO.getIcrCode()) >= 0)
							{
								cntrNo = str.substring(23, 34);
								usaRcvMsgVO.setCntrNo(cntrNo);// 셋팅해서 사용하지를 않는 듯 함
							}
						}
					}
					else if ("CNRU".equals(usaRcvMsgVO.getInSnp()))
					{
						if ("0".indexOf(zone) >= 0)
						{//@ 첫번째 R02만 처리
							this.putCustomsR(str, usaRcvMsgVO);
							iR03 = 0;
						}
					}
					else
					{
						//@ Filer 02에 대한 House B/L 수신 처리
						if (!"  ".equals(inCode) && !"00".equals(inCode) && !" ".equals(inCodeb))
						{
							this.putCustomsR(str, usaRcvMsgVO);
							iR03 = 0;
						} else {
							//R02 Continuation 처리
							cntrNo = str.substring(23, 34);
							usaRcvMsgVO.setCntrNo(cntrNo);
						}
					}
				}// R02
				/******************************************************************************/
				/* R03 레코드 처리 */
				/******************************************************************************/
				else if ("R03".equals(prefix3))
				{
					if ("SMLM".equals(usaRcvMsgVO.getInSnp()))
					{
						/******************************************************************************/
						/* 첫번째 R03 레코드 처리 */
						/******************************************************************************/
						if (iR03 == 0)
						{
							iR03 = 1;
							usaRcvMsgVO.setIcrRemark1(str.substring(3, 53));
							
							//@ R02 처리 시 이미 처리한것으로 중복 처리 하고있음.2018.03.21
							if ("4501".equals(usaRcvMsgVO.getCusAmsport()))
							{
								usaRcvMsgVO.setCusLoc(dbDao.searchItHubByBl1J(usaRcvMsgVO));
							}
							dbDao.modifyCustomsResult(usaRcvMsgVO);
						}// iR03 == 0
						/******************************************************************************/
						/* 두번째 R03 레코드 처리 */
						/******************************************************************************/
						else if (iR03 == 1)
						{
							iR03 = 2;
							this.putCustomsRemark(str, usaRcvMsgVO);
						}
						/******************************************************************************/
						/* 세번째 R03 레코드 처리 */
						/******************************************************************************/
						else if (iR03 == 2)
						{
							usaRcvMsgVO.setRemark3(str.substring(3, 53));
							if ("4501".equals(usaRcvMsgVO.getCusAmsport()))
							{
								usaRcvMsgVO.setCusLoc(dbDao.searchItHubByBl1J(usaRcvMsgVO));
							}
							/********************************************/
							/* icr_remark1으로 업데이트하게 되어 있어 */
							/* icr_remark3로 업데이트 하도록 수정 */
							/* 2006/3/21 민동진 수정 */
							/********************************************/
							dbDao.modifyCustomsResultForRemark3(usaRcvMsgVO);
						}
					}
					else if ("CNRU".equals(usaRcvMsgVO.getInSnp()))
					{
						/******************************************************************************/
						/* 첫번째 R03 레코드 처리 */
						/******************************************************************************/
						if (iR03 == 0)
						{
							iR03 = 1;
							usaRcvMsgVO.setIcrRemark1(str.substring(3, 53));
							if ("4501".equals(usaRcvMsgVO.getCusAmsport()))
							{
								usaRcvMsgVO.setCusLoc(dbDao.searchItHubByBl1J(usaRcvMsgVO));
							}
							dbDao.modifyCustomsResult(usaRcvMsgVO);
						}// iR03 == 0
						/******************************************************************************/
						/* 두번째 R03 레코드 처리 */
						/******************************************************************************/
						else if (iR03 == 1)
						{
							iR03 = 2;
							this.putCustomsRemarkM(str, usaRcvMsgVO);
						}
						/******************************************************************************/
						/* 세번째 R03 레코드 처리 */
						/******************************************************************************/
						else if (iR03 == 2)
						{
							usaRcvMsgVO.setRemark3(str.substring(3, 53));
							if ("4501".equals(usaRcvMsgVO.getCusAmsport()))
							{
								usaRcvMsgVO.setCusLoc(dbDao.searchItHubByBl1J(usaRcvMsgVO));
							}
							/********************************************/
							/* icr_remark1으로 업데이트하게 되어 있어 */
							/* icr_remark3로 업데이트 하도록 수정 */
							/* 2006/3/21 민동진 수정 */
							/********************************************/
							dbDao.modifyCustomsResultForRemark3(usaRcvMsgVO);
						}
					}// inSnp.equals("CNRU")
				}// prefix.equals("R03")
				/*********************************************/
				/* 2011.04.27  C01 항목으로 리스팅 된 Cntr 에 대해 R03 의 Remark 를 표기 상태'R'-Reject */
				/*********************************************/
				else if( JSPUtil.getNull(usaRcvMsgVO.getIsBaplieRC()).equals("Y") && "C01".equals(prefix3))
				{
					usaRcvMsgVO.setCntrNo(str.substring(3, 14));//cntr_no
					dbDao.modifyBaplieRcvByCntr(usaRcvMsgVO);
				}
			} // if str valid
			
			cloneTokenIdx++;
		}// while msg tokenized
		
		/*********************************************/
		/* 2011.04.27  'C01 항목으로 리스팅 되지 않은 CNTR 에 대해 해당 VVD의 BAPLIE 전송이력이 있는 CNTR 는 모두 ACK 로 표기' 처리. */
		/*********************************************/
		if( JSPUtil.getNull(usaRcvMsgVO.getIsBaplieRC()).equals("Y"))
		{
			dbDao.modifyBaplieRcvByVvd(usaRcvMsgVO);
		}
		// 레코드 ID별로 실제적으로 메시지 처리 하는 부분 종료(for문)
		return 0;
	}
	

	/**
	 * Nak Msg를 처리한다.<br>
	 * 
	 * @param String str
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 */
	private int putNakMsg(String str, UsaRcvMsgVO usaRcvMsgVO) {
		String blNo = str.substring(3, 15);
		usaRcvMsgVO.setBlNo(blNo);
		usaRcvMsgVO.setIbdRstUpdateFlg("BL");
		try
		{
			downLoadBC.modifyResultCdByBl(usaRcvMsgVO);
			
			// W01레코드는 CNRU는 해당되지 않는다. CNRU관련 항목은 RC 밖에 없다.
			if ("CNRU".equals(usaRcvMsgVO.getInSnp()))
			{
				usaRcvMsgVO.setIbdRstUpdateFlg("HJBL");
				downLoadBC.modifyResultCdByBl(usaRcvMsgVO);
			}
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage());	
		}
		return 0;
	}

	/**
	 * Reject 발생시 메일 반송
	 * @param UsaRcvMsgVO usaRcvMsgVO 
	 * @param String reBlNo
	 * @param String rejMessage
	 */
	public void sendAmsNtcToObStaff ( UsaRcvMsgVO usaRcvMsgVO , String reBlNo , String rejMessage) {

		List<CstmsRejNtcSndVO> obUsr = null;
		
		TmpMailSendVO tmpMailInfo = null;
		Map<String, String> arguments = null;
		InboundNoticeEAIDAO eaiDao = new InboundNoticeEAIDAO();

		String sndrNm = "Rejection Notification"; // 메일 발신자명
		String sndrEml = "noreply@smlines.com"; // 메일 발신자 이메일
		String sendId = "";
			
		try {

			if (usaRcvMsgVO == null) {
				throw new Exception("Rejection Information is NULL!!");
			}
				
			String rejDesc   = rejMessage;			
			String irDt   = usaRcvMsgVO.getIrDate();
			String vvd     = usaRcvMsgVO.getVslCd()+usaRcvMsgVO.getSkdVoyNo()+usaRcvMsgVO.getSkdDirCd();
			String crrBatNo   = usaRcvMsgVO.getCrrBatNo();

			if ("".equals(reBlNo) || "".equals(rejDesc) || "null".equals(rejDesc) || "".equals(irDt) || "null".equals(irDt)) {
				throw new Exception("Rejection Information is Empty!!");
			}			

			String content    = "Customs Reject B/L No[" + reBlNo + "] ";

			/*
			 * BL 확정자 메일 및 메시지 전송하기
			 */
			obUsr = dbDao.searchRejNtcObStaffInfo (reBlNo, crrBatNo , irDt);

			if ( obUsr.size() > 0) {

				//세관 EDI 전송자
				/* 그룹웨어 메일 전송 */
				if (obUsr.get(0).getSndEml().trim().length() > 0  || obUsr.get(0).getStaffSndEml().trim().length() > 0 ) 
				{
					/* 메시지 전송 */
					sendId = eaiDao.sendAlert("Rej Alert", "Rej Alert", obUsr.get(0).getSndUsrNm(), obUsr.get(0).getSndUsrId(), content);

					log.info("== Booking Hold Event Alert ====================================\n" +
							 "	USR_NM  : " + obUsr.get(0).getSndUsrNm() + "\n" +
							 "	USR_ID  : " + obUsr.get(0).getSndEml() + "\n" +
							 "	USR_NM  : " + obUsr.get(0).getStaffUsrNm() + "\n" +
							 "	USR_ID  : " +obUsr.get(0).getStaffSndEml() + "\n" +							 
							 "	IR_DATE  : " +obUsr.get(0).getIrDate() + "\n" +							 
							 "	msgTpId  : " +obUsr.get(0).getTrsmMsgTpId() + "\n" +							 
							 "	CONTENT : " + content + "\n" +
							 "	SEND ID : " + sendId + "\n" +
							 "==========================================================================\n");
					
					String strEml = "";
					if ( obUsr.get(0).getSndEml().trim().length() > 0 ) strEml +=  obUsr.get(0).getSndEml().trim()+";";
					if ( obUsr.get(0).getStaffSndEml().trim().length() > 0 ) strEml +=  obUsr.get(0).getStaffSndEml().trim();
					
					tmpMailInfo = new TmpMailSendVO();
					
					tmpMailInfo.setTemplate("ESM_BKG_0428_GW_REJ.html");
					String obEmlTitNm = "Rejection Notification [" + vvd + "] [" + reBlNo + "]";

					tmpMailInfo.setEmlTitNm(obEmlTitNm);
					arguments = new HashMap<String, String>();
					arguments.put("vvd", vvd);
					arguments.put("blNo", reBlNo);
					arguments.put("rejDesc", rejDesc);
					arguments.put("irDt", obUsr.get(0).getIrDate());
					arguments.put("msgTpId", obUsr.get(0).getTrsmMsgTpId());					
					
					tmpMailInfo.setArguments(arguments);
					
					tmpMailInfo.setSndrNm(sndrNm);
					tmpMailInfo.setSndrEml(sndrEml);
					tmpMailInfo.setRcvrEml(strEml); 				
					tmpMailInfo.setRcvrNm("");
					
					sendId = eaiDao.sendGwEmail(tmpMailInfo);
				}
				
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);			
        } catch(Exception ex) {			
			log.error("err " + ex.toString(), ex);			
        }
		
	}
	

	/**
	 * Reject 발생시 메일 반송
	 * @param UsaRcvMsgVO usaRcvMsgVO 
	 * @param String reBlNo
	 * @param String rejMessage
	 */
	public void sendAmsNtcToObStaffHouseBl ( UsaRcvMsgVO usaRcvMsgVO , String reBlNo) {
		
		List<CstmsRejNtcSndVO> obUsr = null;
		
		TmpMailSendVO tmpMailInfo = null;
		Map<String, String> arguments = null;
		InboundNoticeEAIDAO eaiDao = new InboundNoticeEAIDAO();

		String sndrNm = "Auto Notification"; // 메일 발신자명
		String sndrEml = "noreply@smlines.com"; // 메일 발신자 이메일
		String sendId = "";
			
		try {

			if (usaRcvMsgVO == null) {
				throw new Exception("Information is NULL!!");
			}
				
			String irDt   = usaRcvMsgVO.getIrDate();
			String vvd     = usaRcvMsgVO.getVslCd()+usaRcvMsgVO.getSkdVoyNo()+usaRcvMsgVO.getSkdDirCd();
			String crrBatNo   = usaRcvMsgVO.getCrrBatNo();

			if ("".equals(reBlNo) || "".equals(irDt) || "null".equals(irDt)) {
				throw new Exception("Information is Empty!!");
			}			

			String content    = "H/BL transmission Notice";

			/*
			 * BL 확정자 메일 스탭에게 전송하기 
			 */
			obUsr = dbDao.searchRejNtcObStaffInfo (reBlNo, crrBatNo , irDt);

			if ( obUsr.size() > 0) {

				/* 그룹웨어 메일 전송 */
				if (obUsr.get(0).getSndEml().trim().length() > 0  )
				{
					/* 메시지 전송 */
					sendId = eaiDao.sendAlert("H/BL transmission Notice", "H/BL transmission Notice", obUsr.get(0).getSndUsrNm(), obUsr.get(0).getSndUsrId(), content);

					String strEml = "";
					if ( obUsr.get(0).getSndEml().trim().length() > 0 ) strEml +=  obUsr.get(0).getSndEml().trim()+";";
					if ( obUsr.get(0).getStaffSndEml().trim().length() > 0 ) strEml +=  obUsr.get(0).getStaffSndEml().trim();
					
					tmpMailInfo = new TmpMailSendVO();
					
					tmpMailInfo.setTemplate("ESM_BKG_0428_GW_HOUSE.html");
					String obEmlTitNm = "H/BL transmission Notice [B/L : " + reBlNo + "]";

					tmpMailInfo.setEmlTitNm(obEmlTitNm);
					arguments = new HashMap<String, String>();
					arguments.put("vvd", vvd);
					arguments.put("blNo", reBlNo);
					arguments.put("irDt", obUsr.get(0).getIrDate());
					arguments.put("pol_nm", obUsr.get(0).getPolLocName());
					arguments.put("pod_nm", obUsr.get(0).getPodLocName());					
					arguments.put("shipper_nm", obUsr.get(0).getShipperNm());
					arguments.put("consignee_nm", obUsr.get(0).getConsigneeNm());
					
					tmpMailInfo.setArguments(arguments);
					
					tmpMailInfo.setSndrNm(sndrNm);
					tmpMailInfo.setSndrEml(sndrEml);
					tmpMailInfo.setRcvrEml(strEml); 				
					tmpMailInfo.setRcvrNm("");
					
					sendId = eaiDao.sendGwEmail(tmpMailInfo);
				}
				
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);			
        } catch(Exception ex) {			
			log.error("err " + ex.toString(), ex);			
        }
		
	}
	
	/**
	 * Hold발생시 메일 반송 (2Z, 2Q 일경우)
	 * @param UsaRcvMsgVO usaRcvMsgVO 
	 * @param String reBlNo
	 * @param String holdMessage
	 * @param String inCode
	 *  
	 */
	public void sendAmsHoldNtcSend( UsaRcvMsgVO usaRcvMsgVO , String reBlNo , String holdMessage, String inCode) {

		List<CstmsHoldNtcSendVO> obUsr = null;
		
		TmpMailSendVO tmpMailInfo = null;
		Map<String, String> arguments = null;
		InboundNoticeEAIDAO eaiDao = new InboundNoticeEAIDAO();

		String sndrNm = "Auto Notification"; // 메일 발신자명
		String sndrEml = "noreply@smlines.com"; // 메일 발신자 이메일
		String sendId = "";
			
		try {

			if (usaRcvMsgVO == null) {
				throw new Exception("Hold Information is NULL!!");
			}
				
			String rejDesc   = holdMessage;			
			String irDt   = usaRcvMsgVO.getIrDate();
			String vvd     = usaRcvMsgVO.getVslCd()+usaRcvMsgVO.getSkdVoyNo()+usaRcvMsgVO.getSkdDirCd();

			if ("".equals(reBlNo) || "".equals(rejDesc) || "null".equals(rejDesc) || "".equals(irDt) || "null".equals(irDt)) {
				throw new Exception("Hold Information is Empty!!");
			}			

			String content    = "Customs Hold B/L No[" + reBlNo + "] ";

			/*
			 * BL 확정자 메일 화주에게 전송하기 
			 */
			obUsr = dbDao.searchHoldNtcSender(reBlNo,irDt);

			if ( obUsr.size() > 0) {

				/* 그룹웨어 메일 전송 */
				if (obUsr.get(0).getSndEml().trim().length() > 0  )
				{
					/* 메시지 전송 */
					sendId = eaiDao.sendAlert("Hold Alert", "Hold Alert", obUsr.get(0).getSndUsrNm(), obUsr.get(0).getSndUsrId(), content);

					String strEml = "";
					if ( obUsr.get(0).getSndEml().trim().length() > 0 ) strEml +=  obUsr.get(0).getSndEml().trim();
					
					tmpMailInfo = new TmpMailSendVO();
					
					tmpMailInfo.setTemplate("ESM_BKG_0428_GW_HOLD.html");
					String obEmlTitNm = "US Customs Response Notice [" + vvd + "] [" + reBlNo + "]";

					tmpMailInfo.setEmlTitNm(obEmlTitNm);
					arguments = new HashMap<String, String>();
					arguments.put("vvd", vvd);
					arguments.put("blNo", reBlNo);
					arguments.put("rejDesc", rejDesc);
					arguments.put("irDt", obUsr.get(0).getIrDate());
					arguments.put("pol_nm", obUsr.get(0).getPolLocName());
					arguments.put("pod_nm", obUsr.get(0).getPodLocName());
					arguments.put("shipper_nm", obUsr.get(0).getShipperNm());
					arguments.put("consignee_nm", obUsr.get(0).getConsigneeNm());
					if ( "2Z".equals(inCode)) {
						arguments.put("message", "Please urgently transmit House B/L to US customs.");
					} else if ( "2Q".equals(inCode)) {
						arguments.put("message", "Please urgently request your consignee to transmit ISF 10 filing. ");
					}
					
					
					tmpMailInfo.setArguments(arguments);
					
					tmpMailInfo.setSndrNm(sndrNm);
					tmpMailInfo.setSndrEml(sndrEml);
					tmpMailInfo.setRcvrEml(strEml); 				
					tmpMailInfo.setRcvrNm("");
					
					sendId = eaiDao.sendGwEmail(tmpMailInfo);
				}
				
			}
			
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);			
        } catch(Exception ex) {			
			log.error("err " + ex.toString(), ex);			
        }
		
	}

	/**
	 * Nak Msg M를 처리한다.<br>
	 * 
	 * @param String str
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 */
	private int putNakMsgM(String str, UsaRcvMsgVO usaRcvMsgVO) {
		usaRcvMsgVO.setIbdRstUpdateFlg("BL");
		try
		{
			downLoadBC.modifyResultCdByBl(usaRcvMsgVO);
		}
		catch(Exception ex)
		{
			log.error(ex.getMessage());
		}
		return 0;
	}

	/**
	 * Nak Msg N를 처리한다.<br>
	 * 
	 * @param String str
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 */
	private int putNakMsgN(String str, UsaRcvMsgVO usaRcvMsgVO) {
		BkgCstmsAdvBlVO bkgCstmsAdvBlVO2 = dbDao.searchAdvBl(usaRcvMsgVO.getInBl(), "US");
		if (bkgCstmsAdvBlVO2 != null)
		{
			try
			{
				usaRcvMsgVO.setBlNo(bkgCstmsAdvBlVO2.getBlNo());
				usaRcvMsgVO.setIbdRstUpdateFlg("BL");
				downLoadBC.modifyResultCdByBl(usaRcvMsgVO);
			}
			catch(Exception ex)
			{
				log.error(ex.getMessage());
			}
		}
		return 0;
	}

	/**
	 * AS-IS의 Put_Customs_R 를 처리한다.<br>
	 * 
	 * @param String str
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 */
	private int putCustomsR(String str, UsaRcvMsgVO usaRcvMsgVO) {
		usaRcvMsgVO.setBlNo(str.substring(3, 15)); // 일반적인 R02 B/L번호 추출 
		BkgCstmsAdvBlVO bkgCstmsAdvBlVO = dbDao.searchAdvBl(usaRcvMsgVO.getBlNo(), "US"); 

		// R02 SMLM의 경우 먼저 세관 정보 조회하고 존재하면 호출하게 되어있어 NULL이 아님.
		// NULL부분은 CNRU이거나 NVOCC에서 수신되는 HOUSE B/L정보 처리 부분.
		if (bkgCstmsAdvBlVO == null)
		{
			// NVOCC(Filer 02 House B/L copy 수신) 또는 CNRU의 경우 BL_NO 파싱에 차이가 있어 SMLM 이후 또는 918P 이후 값으로 세팅시킴
			// 일반적으로 Carrier code(한진 9525,SML 918P) + B/L No.
			// eg.)HJSCAEV600106400
			usaRcvMsgVO.setBlNo(usaRcvMsgVO.getInHjbl().substring(4, 16)); // R02 Continuation - Original B/L
			bkgCstmsAdvBlVO = dbDao.searchAdvBl(usaRcvMsgVO.getBlNo(), "US");
			if (bkgCstmsAdvBlVO == null)
			{
				usaRcvMsgVO.setBlNo(usaRcvMsgVO.getInHjbl().substring(0, 12)); // R02 Continuation - Original B/L
				bkgCstmsAdvBlVO = dbDao.searchAdvBl(usaRcvMsgVO.getBlNo(), "US");
			}
		}
		usaRcvMsgVO.setIcrCode(str.substring(15, 17));
		usaRcvMsgVO.setIcrQty(str.substring(17, 27));
		usaRcvMsgVO.setIcrEtTp(str.substring(27, 29));//Entry Type
		usaRcvMsgVO.setIcrEtNo(str.substring(29, 44));//Entry No.
		usaRcvMsgVO.setIcrDate(str.substring(44, 54));
		int rtn = dbDao.searchCNRUBlAtCanada(usaRcvMsgVO);//캐나다 CNRU로 부터 카피 수신 처리 부분
		if (rtn > 0)
		{
			try
			{
				rtn = downLoadBC.modifyCNRUInfoAtCanada(usaRcvMsgVO);
				// 2010.04.13
				// CANADA 전송시 없는 CONTAINER가 있어 전송 오류발생
			}
			catch(Exception ex)
			{
				log.error(ex.getMessage());
			}
		}
		String inBl = "";
		String inVvd = "";
		String inPod = "";
		UsaResultCntrVO usaResultCntrVO = new UsaResultCntrVO();
		// SMLM아닐경우
		if (!"SMLM".equals(usaRcvMsgVO.getInSnp()))
		{
			rtn = dbDao.modifyDnvlFile(usaRcvMsgVO);
			if (rtn == 0)
			{
				rtn = dbDao.addDnvoFile(usaRcvMsgVO);
			}
			usaResultCntrVO = dbDao.searchMasterBl(usaRcvMsgVO);
			// Master BL을 찾을 경우.
			if (usaResultCntrVO != null && !"".equals(usaResultCntrVO.getInBl()))
			{
				inBl = usaResultCntrVO.getInBl();
				usaRcvMsgVO.setInBl(inBl);
				// Master BL에 대한 vvd, pod를 찾는다.
				usaResultCntrVO = dbDao.searchVVDPodByBl(usaRcvMsgVO);
				inVvd = usaResultCntrVO.getInVvd();
				inPod = usaResultCntrVO.getInPod();
				usaRcvMsgVO.setInVvd(inVvd);
				usaRcvMsgVO.setInPod(inPod);
				// BKG_CSTMS_ADV_NVOCC_FILE 갱신.
				rtn = dbDao.modifyVvdPodByBlAtDnvoFile(usaRcvMsgVO);
			}
			else
			{
				usaResultCntrVO = dbDao.searchMBlByVvdCntrNo(usaRcvMsgVO);
				// Master BL을 찾을 경우.
				if (usaResultCntrVO != null && !"".equals(usaResultCntrVO.getInBl()))
				{
					inBl = usaResultCntrVO.getInBl();
					usaRcvMsgVO.setInBl(inBl);
					// Master BL에 대한 vvd, pod를 찾는다.
					usaResultCntrVO = dbDao.searchVVDPodByBl(usaRcvMsgVO);
					inVvd = usaResultCntrVO.getInVvd();
					inPod = usaResultCntrVO.getInPod();
					usaRcvMsgVO.setInVvd(inVvd);
					usaRcvMsgVO.setInPod(inPod);
					// BKG_CSTMS_ADV_NVOCC_FILE 갱신.
					rtn = dbDao.modifyVvdPodByBlAtDnvoFile(usaRcvMsgVO);
				}
			}
			// [SNP=CNRU] CNRU처리
			if ("CNRU".equals(usaRcvMsgVO.getInSnp()))
			{
				// [] CNRU Flag세팅
				if (dbDao.validateCNRUBl(usaRcvMsgVO) != null)
				{
					usaRcvMsgVO.setCnruIt("Y");
				}
				else
				{
					usaRcvMsgVO.setCnruIt("N");
					return 0;
				}
			}
			else
			{
				return 0;
			}
		}// SMLM아닐경우
		// [cus_amsport="4501"] UsaCustomsTransmissionDBDAO::searchItHubByBl1J ( usaRcvMsgVO )
		// AMS port가 KANSAS CITY 이면 1J에 의해 HUB를 찾는다.
		if ("4501".equals(usaRcvMsgVO.getCusAmsport()))
		{
			usaRcvMsgVO.setCusLoc(dbDao.searchItHubByBl1J(usaRcvMsgVO));
		}
		usaResultCntrVO = dbDao.searchMaxSeqAtResult(usaRcvMsgVO);
		usaRcvMsgVO.setIcrSeq(usaResultCntrVO.getIcrSeq());
		if ("".equals(JSPUtil.getNull(usaRcvMsgVO.getCusLoc())))
		{
			usaRcvMsgVO.setCusLoc(dbDao.searchAmsCusLoc(usaRcvMsgVO.getCusAmsport()));
		}
		if(usaRcvMsgVO.getDestLocCd() != null && !"".equals(usaRcvMsgVO.getDestLocCd())){
			/*
			 * 내륙 운송의 경우에 해당
			 HP	Hold (POD), HM	Hold (Dest), RL	Release 에 속하거나
			 처리 코드가 
			 1C ENTERED AND RELEASED:  GENERAL EXAMINATION
			 12 ARRIVAL OF INBOND  BILL OF LADING
			*/
			int rslt = dbDao.searchCstmsLocByDspoCd(usaRcvMsgVO);
			if (rslt != 0)
			{
				usaRcvMsgVO.setCusAmsport(usaRcvMsgVO.getDestLocCd());
				UsaLocationVO usaLocationVO = dbDao.searchLocCdForCustomsLoc(usaRcvMsgVO);
				if (usaLocationVO != null)
				{
					usaRcvMsgVO.setCusLoc(usaLocationVO.getLocCd());
				}else{
					usaRcvMsgVO.setCusLoc("");
				}
			}
		}
		//BKG_CSTMS_ADV_RSLT
		rtn = dbDao.addCustomsResult(usaRcvMsgVO);
		if (rtn == 1)
		{

			List<CstmsClrVO> cstmsClrs2 = new ArrayList<CstmsClrVO>();
			
			/*****************************************************************************
			* 캐나다 Port 를 경유하는 미주 내륙으로 운송되는 화물은 
			* 선사 신고대상이 아니라 캐나다에서 미주로 화물을 운송하는 Rail Carrier
			* 신고건인데, 이 Rail Company 가 SML 를 (Second Notify Party , SNP) 로
			* 지정해서 미세관에 신고하면 SM 상선도 데이터를 동시에 수신한다. 
			* 문제는 Rail Company 가 BL 단위로 신고하는게 아니라 CNTR 단위로 신고하기
			* 때문에 수신한 데이터를 CNTR 별로 저장해 둔다.
			* B/L Inquiry, Pick-up Notice에서 POD가 CA이고 미국으로 수송되는 물량의 경우 CSTMS_CLR_FLG 표기를 위해 사용된다.
			******************************************************************************/			
			
			if ("CNRU".equals(usaRcvMsgVO.getInSnp()) || "CPRS".equals(usaRcvMsgVO.getInSnp()))
			{
				// Container Result CFlag Setting
				String[] newHoldRemark = this.setCntrRsltCFlag(usaRcvMsgVO);
				usaRcvMsgVO.setNewCntrCFlag(newHoldRemark[0]);
				usaRcvMsgVO.setCntrHoldRemark(newHoldRemark[1]);
				// newHoldRemark[1]	// old C Flag
				rtn = dbDao.addResultCntr(usaRcvMsgVO);
				
				//2010-10-01 최도순 [CHM-201004946] C-flag update 로직 보완 요청 ======>Start
				//Rail AMS에서 partial shipment의 경우 한개의 B/L에 C값이 들어오면
				//C값의 QTY와 B/L C/M에 PKG의 SUM이 일치할 경우 나머지 B/L에 C값을 Y로 upate한다.
				
				// 2010-10-26 반영보류로 일단 주석처리			
								
				if(usaRcvMsgVO.getNewCntrCFlag().equals("Y") || ("Y".equals(newHoldRemark[2]) && !"Y".equals(newHoldRemark[0])))				
				{
					List<UsaPartialBlVO> usaPartialBlVOs = dbDao.searchPartialBl(usaRcvMsgVO);
					
					for (int i = 0; i < usaPartialBlVOs.size(); i++)
					{
						UsaRcvMsgVO usaRcvMsgPartialVO = new UsaRcvMsgVO();					
						
						usaRcvMsgPartialVO.setBlNo(usaPartialBlVOs.get(i).getLclBlNbrA());
						
						UsaResultCntrVO usaRsltCntrVO =  dbDao.searchMaxSeqAtResult(usaRcvMsgPartialVO);
						usaRcvMsgPartialVO.setIcrSeq(usaRsltCntrVO.getIcrSeq());				
						
						usaRcvMsgPartialVO.setCntrHoldRemark("updated with Partial BL C-flag ("+usaRcvMsgVO.getBlNo()+")");
						usaRcvMsgPartialVO.setInCntr(usaRcvMsgVO.getInCntr());
						usaRcvMsgPartialVO.setIrType(usaRcvMsgVO.getIrType());
						usaRcvMsgPartialVO.setIcrCode(usaRcvMsgVO.getIcrCode());
						usaRcvMsgPartialVO.setIcrQty(usaRcvMsgVO.getIcrQty());
						usaRcvMsgPartialVO.setIcrEtTp(usaRcvMsgVO.getIcrEtTp());
						usaRcvMsgPartialVO.setIcrEtNo(usaRcvMsgVO.getIcrEtNo());
						usaRcvMsgPartialVO.setIrDate(usaRcvMsgVO.getIrDate());
						usaRcvMsgPartialVO.setNewCntrCFlag(usaRcvMsgVO.getNewCntrCFlag());
						usaRcvMsgPartialVO.setInSnp(usaRcvMsgVO.getInSnp());
						usaRcvMsgPartialVO.setInNvobl(usaRcvMsgVO.getInNvobl());
						usaRcvMsgPartialVO.setIrBatchNo(usaRcvMsgVO.getIrBatchNo());										
						dbDao.addResultCntr(usaRcvMsgPartialVO);
						
						usaRcvMsgPartialVO.setIrType(usaRcvMsgVO.getIrType());
						usaRcvMsgPartialVO.setIcrCode(usaRcvMsgVO.getIcrCode());
						usaRcvMsgPartialVO.setIsfInBl(usaRcvMsgVO.getIsfInBl());
						usaRcvMsgPartialVO.setIcrQty(usaRcvMsgVO.getIcrQty());
						usaRcvMsgPartialVO.setIcrEtTp(usaRcvMsgVO.getIcrEtTp());
						usaRcvMsgPartialVO.setIcrEtNo(usaRcvMsgVO.getIcrEtNo());
						usaRcvMsgPartialVO.setIrDate(usaRcvMsgVO.getIrDate());
						usaRcvMsgPartialVO.setCusAmsport(usaRcvMsgVO.getCusAmsport());
						usaRcvMsgPartialVO.setCusLoc(usaRcvMsgVO.getCusLoc());
						usaRcvMsgPartialVO.setInSnp(usaRcvMsgVO.getInSnp());
						usaRcvMsgPartialVO.setVslCdM(usaRcvMsgVO.getVslCdM());
						usaRcvMsgPartialVO.setSkdVoyNo(usaRcvMsgVO.getSkdVoyNo());
						usaRcvMsgPartialVO.setSkdDirCd(usaRcvMsgVO.getSkdDirCd());
						usaRcvMsgPartialVO.setIrBatchNo(usaRcvMsgVO.getIrBatchNo());
						usaRcvMsgPartialVO.setIcrDate(usaRcvMsgVO.getIcrDate());
						usaRcvMsgPartialVO.setIcrResendInd(usaRcvMsgVO.getIcrResendInd());
						usaRcvMsgPartialVO.setIsfInRemark1("updated with Partial BL C-flag ("+usaRcvMsgVO.getBlNo()+")");
						usaRcvMsgPartialVO.setIsfInRemark2(usaRcvMsgVO.getIsfInRemark2());
						usaRcvMsgPartialVO.setIsfTranNo(usaRcvMsgVO.getIsfTranNo());
						usaRcvMsgPartialVO.setCrrBatNo(usaRcvMsgVO.getCrrBatNo());
						usaRcvMsgPartialVO.setCstmsClrCd(usaRcvMsgVO.getCstmsClrCd());						
						dbDao.addCustomsResult(usaRcvMsgPartialVO);
						
						
						log.debug("LYTbl:"+usaPartialBlVOs.get(i).getLclBlNbrA()+ "  , Cflag:+"+usaRcvMsgVO.getNewCntrCFlag()
								+ "  dspo_cd:"+usaRcvMsgVO.getIcrCode()  );
						
						CstmsClrVO cstmsClr2 = new CstmsClrVO();			
						cstmsClr2.setBlNo(usaPartialBlVOs.get(i).getLclBlNbrA());
						cstmsClr2.setCstmsClrCd( usaRcvMsgVO.getNewCntrCFlag() );
						cstmsClr2.setCstmsDsPoCd(usaRcvMsgVO.getIcrCode());
						cstmsClr2.setEvntOfcCd("USABB");
						cstmsClr2.setEvntUsrId("AMS");
						if (Integer.parseInt(usaRcvMsgVO.getIrDate().substring(0, 2)) > 70)
							cstmsClr2.setEvntDt("19" + usaRcvMsgVO.getIrDate());
						else
							cstmsClr2.setEvntDt("20" + usaRcvMsgVO.getIrDate());
						cstmsClr2.setCgorTeamCd("A");
						cstmsClr2.setCgoEvntNm("AMS_RCV");
						cstmsClr2.setCstmsLocCd(usaRcvMsgVO.getCusLoc());
						cstmsClrs2.add(cstmsClr2);					
						
					}					
					
				}
				
				
				CstmsClrVO cstmsClr = new CstmsClrVO();
				cstmsClr.setBlNo(usaRcvMsgVO.getBlNo());
				cstmsClr.setCstmsClrCd(usaRcvMsgVO.getNewCntrCFlag() );
				cstmsClr.setCstmsDsPoCd(usaRcvMsgVO.getIcrCode());
				cstmsClr.setEvntOfcCd("USABB");
				cstmsClr.setEvntUsrId("AMS");
				if (Integer.parseInt(usaRcvMsgVO.getIrDate().substring(0, 2)) > 70)
					cstmsClr.setEvntDt("19" + usaRcvMsgVO.getIrDate());
				else
					cstmsClr.setEvntDt("20" + usaRcvMsgVO.getIrDate());
				cstmsClr.setCgorTeamCd("A");
				cstmsClr.setCgoEvntNm("AMS_RCV");
				cstmsClr.setCstmsLocCd(usaRcvMsgVO.getCusLoc());
				cstmsClrs2.add(cstmsClr);

				
				/**********************************************
				 * Cargo Release Set
				 **********************************************/
				if (cstmsClrs2.size() > 0)
				{
					usaRcvMsgVO.setCstmsClrVOs(cstmsClrs2);
				}
			
				
			
			return 0 ;
				
			}
		}
		
		
		if ("".equals(bkgCstmsAdvBlVO.getMfNo()))
		{
			usaRcvMsgVO.setMasterOrHouse("M");
		}
		else
		{
			usaRcvMsgVO.setMasterOrHouse("H");
		}
		// 2010.04.16 KMJ ADD
		// 1J : P/MIB Accepted Date 
		// 11,13 : Arrival Date 
		this.setArrDate(usaRcvMsgVO);
		
		// Return vo list
		List<CstmsHldVO> cstmsHlds = new ArrayList<CstmsHldVO>();
		List<CstmsClrVO> cstmsClrs = new ArrayList<CstmsClrVO>();
		List<CstmsHldVO> cstmsHldSends = new ArrayList<CstmsHldVO>();

		//*****************************************************************************************************************
		//@ ******************************************************************************************* C-flag 판단 로직 시작
		//*****************************************************************************************************************
		List<BkgCstmsAdvIbdVO> bkgCstmsAdvIbdVOs = new ArrayList<BkgCstmsAdvIbdVO>();
		if ("M".equals(usaRcvMsgVO.getMasterOrHouse()))
		{
			log.info("####################################################");
			log.info("본격적인 C-Flag 로직 시작");
			log.info("bl_no: " + usaRcvMsgVO.getBlNo());
			log.info("####################################################");
			// 현재 C-Flag, OB_NTC_FLG
			UsaPartialBlVO usaPartialBlVO = dbDao.searchOldCstmsClrCd(usaRcvMsgVO);
			String oldCFlag = usaPartialBlVO.getLclCustcIndA();
			String newCFlag = "N";
//			String cstmsLocDiffFlg = "N";
			
			/**********************************************
			 * 수신받은 destLocCd(rcv_loc_cd) 와 BL Customs Loc 이 다르면 무조건 "N"<br>
			 * 하나의 수신 파일에 여러건이 수신 내용이 있으면 이전 수신시 판단 했던 값을 따라간다 = "Y".equals(cstmsLocDiffFlg) <br>
			 * 2014.04.21
			 **********************************************/
//			String destLocCd = "";
//			UsaRcvMsgVO usaDestRcvMsgVO = new UsaRcvMsgVO();
//			usaDestRcvMsgVO.setCusAmsport(usaRcvMsgVO.getDestLocCd());
//			UsaLocationVO usaDestLocationVO = dbDao.searchLocCdForCustomsLoc(usaDestRcvMsgVO);
//			if (usaDestLocationVO != null) {
//				destLocCd= usaDestLocationVO.getLocCd();
//			}
//
//			
//			if(destLocCd != null && !"".equals(destLocCd)
//					&& ("Y".equals(cstmsLocDiffFlg) || !destLocCd.equals( bkgCstmsAdvBlVO.getCstmsLocCd())) 
//					&& "1C".equals(usaRcvMsgVO.getIcrCode())
//					&& !("USLGB".equals(bkgCstmsAdvBlVO.getCstmsLocCd()) &&  "USLAX".equals(destLocCd))
//					&& !("USLAX".equals(bkgCstmsAdvBlVO.getCstmsLocCd()) &&  "USLGB".equals(destLocCd))
//					&& !("USOAK".equals(bkgCstmsAdvBlVO.getCstmsLocCd()) &&  "USSFO".equals(destLocCd))
//					&& !("USSFO".equals(bkgCstmsAdvBlVO.getCstmsLocCd()) &&  "USOAK".equals(destLocCd))
//					) {
//				
//					cstmsLocDiffFlg = "Y";
//			}
//			if("Y".equals(cstmsLocDiffFlg) ||!usaRcvMsgVO.getCusLoc().equals( bkgCstmsAdvBlVO.getCstmsLocCd() ) 
//					&& ("1C".equals(usaRcvMsgVO.getIcrCode()) || "12".equals(usaRcvMsgVO.getIcrCode()) )
//					&& !("USLGB".equals(bkgCstmsAdvBlVO.getCstmsLocCd()) &&  "USLAX".equals(usaRcvMsgVO.getCusLoc()))
//					&& !("USLAX".equals(bkgCstmsAdvBlVO.getCstmsLocCd()) &&  "USLGB".equals(usaRcvMsgVO.getCusLoc()))
//					&& !("USOAK".equals(bkgCstmsAdvBlVO.getCstmsLocCd()) &&  "USSFO".equals(usaRcvMsgVO.getCusLoc()))
//					&& !("USSFO".equals(bkgCstmsAdvBlVO.getCstmsLocCd()) &&  "USOAK".equals(usaRcvMsgVO.getCusLoc()))
//					
//					) {
			
			if (!"H".equals(oldCFlag) && "54".equals(usaRcvMsgVO.getIcrCode())){
				/**********************************************
				 * 54코드가 들어오면 무조건 N으로<br>
				 * 2010.06.23
				 **********************************************/
				newCFlag = "N";
			}
			/**********************************************
			 * 종전 CFlag가 J이고 54, 55 코드가 들어오고 local인 경우 N으로<br>
			 * 2010.04.08
			 * "J".usaPartialBlVO.getOldCstmsClrCdJcd() 이 부분은 Dead Code이다. 입력시 null을 입력하고 이를 조회하고 있다. 2018.03.07
			 **********************************************/
			else if ("54,55".indexOf(usaRcvMsgVO.getIcrCode()) >= 0 
					&& ("J".equals(oldCFlag) || "J".equals(usaPartialBlVO.getOldCstmsClrCdJcd()))
					&& "L".equals(usaPartialBlVO.getCstmsClrTpCd()))
			{
				newCFlag = "N";
			}
			else
			{
				newCFlag = this.getCFlag(usaRcvMsgVO, oldCFlag);
			}
			// Y or J의 경우 Partial 체크
			if ("Y,J".indexOf(newCFlag) >= 0)
			{
				newCFlag = this.getPartialCFlag(usaRcvMsgVO, newCFlag, cstmsClrs);
			}
			
			/**********************************************
			 * 2014.06.30
			 * 수신 파일에 1C 최종 C-FLAG 가 "Y"일 경우만 Customs Loc 과 result 탭 Customs 비교하여 
			 * 다르면 C-FLAG를 "N"로 변경
			 * 예외사항으로  Customs Loc 과 result 탭 Customs이 다르더라도 적용하지 않는다. 
			 *     USLGB == USLAX , USOAK == USSFO , USTIW == USSEA (2015.01.13 추가) 
			 *     USMKC == USKCK (2015.05.13 추가)     
			 **********************************************/
            if(!usaRcvMsgVO.getCusLoc().equals( bkgCstmsAdvBlVO.getCstmsLocCd() ) 
                    && ("1C".equals(usaRcvMsgVO.getIcrCode()) &&  "Y".equals(newCFlag))
                    && !("USLGB".equals(bkgCstmsAdvBlVO.getCstmsLocCd()) &&  "USLAX".equals(usaRcvMsgVO.getCusLoc()))
                    && !("USLAX".equals(bkgCstmsAdvBlVO.getCstmsLocCd()) &&  "USLGB".equals(usaRcvMsgVO.getCusLoc()))
                    && !("USOAK".equals(bkgCstmsAdvBlVO.getCstmsLocCd()) &&  "USSFO".equals(usaRcvMsgVO.getCusLoc()))
                    && !("USSFO".equals(bkgCstmsAdvBlVO.getCstmsLocCd()) &&  "USOAK".equals(usaRcvMsgVO.getCusLoc()))
                    && !("USSEA".equals(bkgCstmsAdvBlVO.getCstmsLocCd()) &&  "USTIW".equals(usaRcvMsgVO.getCusLoc()))
                    && !("USTIW".equals(bkgCstmsAdvBlVO.getCstmsLocCd()) &&  "USSEA".equals(usaRcvMsgVO.getCusLoc()))
                    && !("USMKC".equals(bkgCstmsAdvBlVO.getCstmsLocCd()) &&  "USKCK".equals(usaRcvMsgVO.getCusLoc()))
                    && !("USKCK".equals(bkgCstmsAdvBlVO.getCstmsLocCd()) &&  "USMKC".equals(usaRcvMsgVO.getCusLoc()))
                    ) {
                    cstmsLocDiffFlg = "Y";
                    newCFlag = "N";
	         } else if("Y".equals(cstmsLocDiffFlg) && "12".equals(usaRcvMsgVO.getIcrCode()) ){
	               /**********************************************
	                * 1C + cstmsLocDiffFlg = Y 이고 12가 들어오면 무조건 N<br>
	                * 1C와 12같이 들어올 경우 1C + cstmsLocDiffFlg = Y 결과 값을 따름<br>
	                * 2014.06.20
	                **********************************************/
	               newCFlag = "N";
	               // cstmsLoc 비교는 안한다.
	               cstmsLocDiffFlg = "N";
	         }
			
			/**********************************************
			 * Cargo Release Set
			 **********************************************/
			CstmsClrVO cstmsClr = new CstmsClrVO();
			cstmsClr.setBlNo(usaRcvMsgVO.getBlNo());
			cstmsClr.setCstmsClrCd(newCFlag);
			cstmsClr.setCstmsDsPoCd(usaRcvMsgVO.getIcrCode());
			cstmsClr.setEvntOfcCd("USABB");
			cstmsClr.setEvntUsrId("AMS");
			if (Integer.parseInt(usaRcvMsgVO.getIrDate().substring(0, 2)) > 70)
				cstmsClr.setEvntDt("19" + usaRcvMsgVO.getIrDate());
			else
				cstmsClr.setEvntDt("20" + usaRcvMsgVO.getIrDate());
			cstmsClr.setCgorTeamCd("A");
			cstmsClr.setCgoEvntNm("AMS_RCV");
			cstmsClr.setCstmsLocCd(usaRcvMsgVO.getCusLoc());
			cstmsClrs.add(cstmsClr);
			
			/**********************************************
			 * Hold Notice Set(PH)
			 **********************************************/
			if ("H".equals(newCFlag))
			{
				CstmsHldVO cstmsHldVO = this.setCstmsHld(usaRcvMsgVO.getBlNo(), usaRcvMsgVO, "PH");
				if (cstmsHldVO != null)
				{
					cstmsHlds.add(cstmsHldVO);
				}
			}
			/**********************************************
			 * Realease Notice Set(CF)
			 **********************************************/
			else if ("H".equals(oldCFlag))
			{
				// InBound 테이블(BKG_HLD_NTC)의 Hold Type이 "CF"중에서 없는 데이타만 Insert한다.
				// Hold 중 Confirm Hold데이타가 생성 되지 않은 것 조회
				List<HoldInfoVO> holdInfoVOs = dbDao.searchHoldInfo(usaRcvMsgVO);
				for (int j = 0; j < holdInfoVOs.size(); j++)
				{
					//@ Removal 정보 조회
					HoldInfoVO remvInfoVO = dbDao.searchRemvInfo(usaRcvMsgVO.getBlNo(), holdInfoVOs.get(j));
					usaRcvMsgVO.setHldCd(holdInfoVOs.get(j).getHldCd());
					usaRcvMsgVO.setHldDt(holdInfoVOs.get(j).getHldDt());
					usaRcvMsgVO.setRlseHldCd(remvInfoVO.getHldCd()); // Removal Code 셋업
					usaRcvMsgVO.setRlseHldDt(remvInfoVO.getHldDt());
					//@ Hold/ Removal 매핑 되면 Confirm Hold 처리.
					CstmsHldVO cstmsHldVO = this.setCstmsHld(usaRcvMsgVO.getBlNo(), usaRcvMsgVO, "CF");
					if (cstmsHldVO != null)
					{
						cstmsHlds.add(cstmsHldVO);
					}
				}
			}
			/**********************************************
			 * CFlag가 Y -> N으로 변경시<br>
			 * BKG_CSTMS_ADV_IBD 의 CSTMS_CLR_CNG_FLG = 'Y' 변경
			 **********************************************/
			if ("Y".equals(oldCFlag) && "N".equals(newCFlag))
			{
				BkgCstmsAdvIbdVO ibdVO = new BkgCstmsAdvIbdVO();
				ibdVO.setCntCd("US");
				ibdVO.setBlNo(usaRcvMsgVO.getBlNo());
				ibdVO.setCstmsClrCngFlg("Y");
				bkgCstmsAdvIbdVOs.add(ibdVO);
			}
			/**********************************************
			 * Waring 이벤트 Send
			 **********************************************/
			if ("Y".equals(usaPartialBlVO.getObNtcFlg()))
			{
				CstmsHldVO cstmsHldVO = this.setCstmsHld(usaRcvMsgVO.getBlNo(), usaRcvMsgVO, "");
				if (cstmsHldVO != null)
				{
					cstmsHldSends.add(cstmsHldVO);
				}
			}

			/**********************************************
			 * Customs Status Notice 의 Send Mail
			 **********************************************/
			if ("1R,1S".indexOf(usaRcvMsgVO.getIcrCode()) >= 0)
			{
				ComRptDsgnXptInfoVO rdVO = new ComRptDsgnXptInfoVO();
				InboundNoticeEAIDAO eaiDao = new InboundNoticeEAIDAO();
				List<ComRptDsgnXptInfoVO> rdVOs = new ArrayList<ComRptDsgnXptInfoVO>();
				
				CstmsNtcSndInfoVO inCstmsNtcSndInfoVO = new CstmsNtcSndInfoVO();
				UsaManifestListDownloadDBDAO usaManifestListDownloadDBDAO = new UsaManifestListDownloadDBDAO();
				ArrayList<CstmsNtcSndInfoVO> outCstmsNtcSndInfoVO = null;
				UsCustomsStatusNoticeVO usCustomsVO = null;
				
				//Mail Setting
				String rcvrEml = null;
				String rcvrNm = null;
				String sndEml = null;
				String sendId = null;
				String usr_id = "BAT_BKG_020";
				Map<String, String> arguments = null;				
				RDMailSendVO mailInfo = new RDMailSendVO();
				
				//Search Mail Recevier (화주)			
				try {
					inCstmsNtcSndInfoVO.setBkgNo(usaRcvMsgVO.getBlNo());//BL 세팅		
					
					outCstmsNtcSndInfoVO = (ArrayList<CstmsNtcSndInfoVO>) this.searhCstmsNtcSndInfo(inCstmsNtcSndInfoVO);
					
					int rcvMailCnt = outCstmsNtcSndInfoVO.size();
					for(int j=0; j<rcvMailCnt; j++) {
						
						//Search Mail Sender				
						usCustomsVO = usaManifestListDownloadDBDAO.searchUsCustomsStatusNoticeInfo("PHXSA");
						
						//Found Sender
						if ( usCustomsVO != null ) {
							
							rcvrEml = outCstmsNtcSndInfoVO.get(j).getNtcEml();
							rcvrNm = outCstmsNtcSndInfoVO.get(j).getCustNm();
							if(rcvrEml == null || "".equals(rcvrEml)) continue;
							
							if("N".equals(usCustomsVO.getAutoSndFlgRadio())) continue;
							//sndEml = usCustomsVO.getHndlOfcEml();
							sndEml = "noreply@smlines.com";
							
							//Send Mail
							mailInfo.setRcvrEml(rcvrEml);
							mailInfo.setRcvrNm(rcvrNm);
							mailInfo.setSndrEml(sndEml);
							mailInfo.setSndrNm("SM Line");
							
							if ( "1R".equals(usaRcvMsgVO.getIcrCode())) {
								mailInfo.setEmlTitNm("[SM Line America] Pending eligible General Order");
								mailInfo.setTemplate("ESM_BKG_1179_CSTMS_1R.html");
							} else {
								mailInfo.setEmlTitNm("[SM Line America] Ordered to General Order by USCBP");
								mailInfo.setTemplate("ESM_BKG_1179_CSTMS_1S.html");
							}
							
							arguments = new HashMap<String, String>();
							mailInfo.setArguments(arguments);
							
							/*Attach RD : RD Setting*/ 
							rdVOs = new ArrayList<ComRptDsgnXptInfoVO>();	
							rdVO = new ComRptDsgnXptInfoVO();
							rdVO.setCreUsrId(usr_id);		
							rdVO.setUpdUsrId(usr_id);
							rdVO.setRdTmpltNm("ESM_BKG_1179.mrd");
							rdVO.setRdParaCtnt("/rv bl_no['" + usaRcvMsgVO.getBlNo() + "'] " +
								    " hndl_ofc_cd['PHXSA'] " +
									" ntc_msg_tp_cd['" + usaRcvMsgVO.getIcrCode() + "'] " +
									" rcvr_nm['" + rcvrNm + "'] " +
								 "/rp [] /riprnmargin");
									
							rdVO.setXptFileTpCd(ExportInfo.FTYPE_PDF);
							rdVO.setXptFileNm("CUSTOMS_STATUS_" + usaRcvMsgVO.getBlNo()+ ".pdf");
							rdVOs.add(rdVO);
											
							mailInfo.setComRptDsgnXptInfoVOs(rdVOs); /* Send Mail */
							sendId = eaiDao.sendEmail(mailInfo);
							
							log.error("1R,1S sendId=>"+sendId);
							
						} // end of if

					} // end of for loop
					
				} catch (EventException e1) {
					log.error("err " + e1.toString(), e1);

				} catch (Exception e) {
					log.error("err " + e.toString(), e);
				}
			}

			/**********************************************
			 * BKG_CSTMS_ADV_RSLT 의 CSTMS_CLR_CD 변경
			 **********************************************/
			usaRcvMsgVO.setCstmsClrCd(newCFlag);
			usaRcvMsgVO.setCstmsLocDiffFlg(cstmsLocDiffFlg);
			dbDao.modifyCustomsResultForCstmsClrCd(usaRcvMsgVO);
			
			/**********************************************
			 * BKG_CSTMS_ADV_RSLT 의 RCV_LOC_CD 와 CUSTOMS LOC 이 다르면
			 * CUSTOMS LOC = RCV_LOC_CD 으로 갱신
			 **********************************************/
//			if("Y".equals(cstmsLocDiffFlg)) {
//				downLoadBC.modifyAdvancedBl(usaRcvMsgVO);
//				
//        		BkgCstmsIbdHisVO hisInfo = null;
//				try {
//					hisInfo = downLoadBC.addBlHistory( "US" + usaRcvMsgVO.getBlNo(), "SYSTEM", "RCV" );
//					if( hisInfo != null) downLoadBC.addBlDetailHistory( hisInfo, "CLO", bkgCstmsAdvBlVO.getCstmsLocCd(), usaRcvMsgVO.getCusLoc() );
//				} catch (EventException e) {
//					log.error("err " + e.toString(), e);
//				}
//				
//			}

		} // if master bl
		/**********************************************
		 * Cargo Release Set
		 **********************************************/
		if (cstmsClrs.size() > 0)
		{
			usaRcvMsgVO.setCstmsClrVOs(cstmsClrs);
		}
		/**********************************************
		 * Hold Notice Set
		 **********************************************/
		if (cstmsHlds.size() > 0)
		{
			usaRcvMsgVO.setCstmsHldVOs(cstmsHlds);
		}
		/**********************************************
		 * Waring 이벤트 Send
		 **********************************************/
		if (cstmsHldSends.size() > 0)
		{
			usaRcvMsgVO.setCstmsHldSendVOs(cstmsHldSends);
		}
		/**********************************************
		 * BKG_CSTMS_ADV_IBD 의 CSTMS_CLR_CNG_FLG = 'Y' 변경
		 **********************************************/
		if (bkgCstmsAdvIbdVOs.size() > 0)
		{
			usaRcvMsgVO.setBkgCstmsAdvIbdVOs(bkgCstmsAdvIbdVOs);
		}
		return 0;
	}

	/**
	 * AS-IS의 Put_Customs_R 를 처리한다.<br>
	 * 
	 * @param String str
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 */
	private int putCustomsRM(String str, UsaRcvMsgVO usaRcvMsgVO) {
		usaRcvMsgVO.setBlNo(str.substring(3, 15));
		usaRcvMsgVO.setIcrCode(str.substring(15, 17));
		usaRcvMsgVO.setIcrQty(str.substring(17, 27));
		usaRcvMsgVO.setIcrEtTp(str.substring(27, 29));
		usaRcvMsgVO.setIcrEtNo(str.substring(29, 44));
		usaRcvMsgVO.setIcrDate(str.substring(44, 54));
		// PutCustomsR과 다른 부분이 아래 hbl_no 부분과 bl_no 구하는 부분이다.
		usaRcvMsgVO.setHblNo(str.substring(3, 15));
		BkgCstmsAdvBlVO bkgCstmsAdvBlVO = dbDao.searchAdvBl(usaRcvMsgVO.getHblNo(), "US");
		if (bkgCstmsAdvBlVO != null)
		{
			usaRcvMsgVO.setBlNo(bkgCstmsAdvBlVO.getMfNo());
		}
		else
		{
			BkgCstmsAdvBlVO bkgCstmsAdvBlVO2 = dbDao.searchAdvBl(usaRcvMsgVO.getInBl(), "US");
			if (bkgCstmsAdvBlVO2 != null)
			{
				usaRcvMsgVO.setBlNo(bkgCstmsAdvBlVO2.getBlNo());
			}
		}
		if (bkgCstmsAdvBlVO == null || bkgCstmsAdvBlVO.getMfNo().trim().equals("")
				|| !"SMLM".equals(usaRcvMsgVO.getInSnp()))
		{
			return 0;
		}
		// [cus_amsport="4501"] UsaCustomsTransmissionDBDAO::searchItHubByBl1J ( usaRcvMsgVO )
		// inbond_customs_r에 cus_loc는 ICR_LOC(as-is):RCV_LOC_CD(to-be)에 입력되는데,
		// 현 위치에서는 하드코딩으로 'HOUSE'가 입력되므로, usaRcvMsgVO.getCusAmsport().equals("4501") 로직은 삭제한다.
		UsaResultCntrVO usaResultCntrVO = dbDao.searchMaxSeqAtResult(usaRcvMsgVO);
		usaRcvMsgVO.setIcrSeq(usaResultCntrVO.getIcrSeq());
		String tmpCusLoc = usaRcvMsgVO.getCusLoc();
		usaRcvMsgVO.setCusLoc("HOUSE");
		dbDao.addCustomsResult(usaRcvMsgVO);
		// 작업이 끝났으므로, cusLoc를 'HOUSE'로 하드코팅한 것에서 원복함.
		usaRcvMsgVO.setCusLoc(tmpCusLoc);
		return 0;
	}

	/**
	 * AS-IS의 Put_Customs_R_N 를 처리한다.<br>
	 * 
	 * @param String str
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 */
	private int putCustomsRN(String str, UsaRcvMsgVO usaRcvMsgVO) {
		// putNakMsgN 에서 in_bl에 의한 bl_no를 이미 구했으므로 아래 구문은 주석처리한다.
		// usaRcvMsgVO.setBlNo(str.substring(3, 15));
		usaRcvMsgVO.setIcrCode(str.substring(15, 17));
		usaRcvMsgVO.setIcrQty(str.substring(17, 27));
		usaRcvMsgVO.setIcrEtTp(str.substring(27, 29));
		usaRcvMsgVO.setIcrEtNo(str.substring(29, 44));
		usaRcvMsgVO.setIcrDate(str.substring(44, 54));
		// AS-IS 로직상의 in_bl에 의해 bl_no를 구하는 로직은 이미 putNakMsgN 에서 수행하였으므로 아래 로직 부분은 생략.
		// EXEC SQL SELECT BL_NO||BL_NO_TP||BL_NO_CHK
		// INTO :bl_no
		// WHERE BL_NO = SUBSTR(:in_bl,1,10)....
		// [cus_amsport="4501"] UsaCustomsTransmissionDBDAO::searchItHubByBl1J ( usaRcvMsgVO )
		if ("4501".equals(usaRcvMsgVO.getCusAmsport()))
		{
			usaRcvMsgVO.setCusLoc(dbDao.searchItHubByBl1J(usaRcvMsgVO));
		}
		UsaResultCntrVO usaResultCntrVO = dbDao.searchMaxSeqAtResult(usaRcvMsgVO);
		usaRcvMsgVO.setIcrSeq(usaResultCntrVO.getIcrSeq());
		usaRcvMsgVO.setCstmsClrCd(usaResultCntrVO.getOldCntrCflag());
		int rtn = dbDao.addCustomsResult(usaRcvMsgVO);
		if (rtn == 1)
		{
			// Rail Company( AMS File File No.의 SCAC Code) - Secondary Notify Party Code
			// CNRU:Canadian National Railway 
			// CPRS:Canadian Pacific(CP)
			if ("CNRU".equals(usaRcvMsgVO.getInSnp()) || "CPRS".equals(usaRcvMsgVO.getInSnp()))
			{
				// Container Result CFlag Setting
				String[] newHoldRemark = this.setCntrRsltCFlag(usaRcvMsgVO);
				usaRcvMsgVO.setNewCntrCFlag(newHoldRemark[0]);
				usaRcvMsgVO.setCntrHoldRemark(newHoldRemark[1]);
				rtn = dbDao.addResultCntr(usaRcvMsgVO);
				
				//2010-10-01 최도순 [CHM-201004946] C-flag update 로직 보완 요청 ======>Start
				//Rail AMS에서 partial shipment의 경우 한개의 B/L에 C값이 들어오면
				//C값의 QTY와 B/L C/M에 PKG의 SUM이 일치할 경우 나머지 B/L에 C값을 Y로 upate한다.
				
				// 2010-10-26 반영보류로 일단 주석처리
				/*
				if(usaRcvMsgVO.getNewCntrCFlag().equals("Y"))					
				{
					List<UsaPartialBlVO> usaPartialBlVOs = dbDao.searchPartialBl(usaRcvMsgVO);
					
					for (int i = 0; i < usaPartialBlVOs.size(); i++)
					{
						UsaRcvMsgVO usaRcvMsgPartialVO = new UsaRcvMsgVO();					
						
						usaRcvMsgPartialVO.setBlNo(usaPartialBlVOs.get(i).getLclBlNbrA());
						
						UsaResultCntrVO usaRsltCntrVO =  dbDao.searchMaxSeqAtResult(usaRcvMsgPartialVO);
						usaRcvMsgPartialVO.setIcrSeq(usaRsltCntrVO.getIcrSeq());				
						
						usaRcvMsgPartialVO.setCntrHoldRemark("updated with Partial BL C-flag ("+usaRcvMsgVO.getBlNo()+")");
						usaRcvMsgPartialVO.setInCntr(usaRcvMsgVO.getInCntr());
						usaRcvMsgPartialVO.setIrType(usaRcvMsgVO.getIrType());
						usaRcvMsgPartialVO.setIcrCode(usaRcvMsgVO.getIcrCode());
						usaRcvMsgPartialVO.setIcrQty(usaRcvMsgVO.getIcrQty());
						usaRcvMsgPartialVO.setIcrEtTp(usaRcvMsgVO.getIcrEtTp());
						usaRcvMsgPartialVO.setIcrEtNo(usaRcvMsgVO.getIcrEtNo());
						usaRcvMsgPartialVO.setIrDate(usaRcvMsgVO.getIrDate());
						usaRcvMsgPartialVO.setNewCntrCFlag(usaRcvMsgVO.getNewCntrCFlag());
						usaRcvMsgPartialVO.setInSnp(usaRcvMsgVO.getInSnp());
						usaRcvMsgPartialVO.setInNvobl(usaRcvMsgVO.getInNvobl());
						usaRcvMsgPartialVO.setIrBatchNo(usaRcvMsgVO.getIrBatchNo());				
						
						dbDao.addResultCntr(usaRcvMsgPartialVO);
						
						usaRcvMsgPartialVO.setIrType("");
						usaRcvMsgPartialVO.setIcrCode("");
						usaRcvMsgPartialVO.setIrType("");
						usaRcvMsgPartialVO.setIsfInBl("");
						usaRcvMsgPartialVO.setIcrQty("");
						usaRcvMsgPartialVO.setIcrEtTp("");
						usaRcvMsgPartialVO.setIcrEtNo("");
						usaRcvMsgPartialVO.setIrDate("");
						usaRcvMsgPartialVO.setCusAmsport("");
						usaRcvMsgPartialVO.setCusLoc("");
						usaRcvMsgPartialVO.setInSnp("");
						usaRcvMsgPartialVO.setVslCdM("");
						usaRcvMsgPartialVO.setSkdVoyNo("");
						usaRcvMsgPartialVO.setSkdDirCd("");
						usaRcvMsgPartialVO.setIrBatchNo("");
						usaRcvMsgPartialVO.setIcrDate(usaRcvMsgVO.getIcrDate());
						usaRcvMsgPartialVO.setIcrResendInd("");
						usaRcvMsgPartialVO.setIsfInRemark1("updated with Partial BL C-flag ("+usaRcvMsgVO.getBlNo()+")");
						usaRcvMsgPartialVO.setIsfInRemark2("");
						usaRcvMsgPartialVO.setIsfTranNo("");
						usaRcvMsgPartialVO.setCrrBatNo("");
						usaRcvMsgPartialVO.setCstmsClrCd("");
						
						 dbDao.addCustomsResult(usaRcvMsgPartialVO);
					}	
				}
				*/
				//2010-10-01 최도순 [CHM-201004946] C-flag update 로직 보완 요청 ======>End
			}
		}
		return 0;
	}

	/**
	 * As-is의 Put_Customs_Remark를 구현한다. <br>
	 * 
	 * @param String str
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 */
	private int putCustomsRemark(String str, UsaRcvMsgVO usaRcvMsgVO) {
		usaRcvMsgVO.setAcpDate(str.substring(3, 9)); //@ R03 두번째 반복구에서 날짜 항목을 추출하려는 목적인데, 데이타가 정확하지 않아 대부분 에러 처리 된다.
		usaRcvMsgVO.setRemark2(str.substring(3, 53));
		int rtn = dbDao.modifyCustomsResultForRemark(usaRcvMsgVO);
		if (rtn < 0)
		{
			return -1;
		}
		
		//@ R03 날짜가 정확하지 않아 대부분 예외 발생 - 이부분 처리 되지 않음.
		try
		{
			//@ 50	EXPORT OF INBOND  COMPLETE MOVEMENT,51 EXPORT OF INBOND  BILL OF LADING
			if (usaRcvMsgVO.getIcrCode() != null && "50,51".indexOf(usaRcvMsgVO.getIcrCode()) >= 0)
			{
				downLoadBC.modifyExpAccpDtAtBl(usaRcvMsgVO);
				downLoadBC.modifyExpAccpDtAtCntr(usaRcvMsgVO);
			}
			//@ 52	EXPORT OF INBOND  CONTAINER
			else if (usaRcvMsgVO.getIcrCode() != null && "52".indexOf(usaRcvMsgVO.getIcrCode()) >= 0)
			{
				downLoadBC.modifyExpAccpDtAtCntr(usaRcvMsgVO);
			}
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
		}
		return 0;
	}

	/**
	 * As-is의 Put_Customs_Remark_M를 구현한다. <br>
	 * 
	 * @param String str
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 */
	private int putCustomsRemarkM(String str, UsaRcvMsgVO usaRcvMsgVO) {
		usaRcvMsgVO.setAcpDate(str.substring(3, 9));
		usaRcvMsgVO.setRemark2(str.substring(3, 53));
		int rtn = dbDao.modifyCustomsResultForRemarkSnpHJSC(usaRcvMsgVO);
		if (rtn < 0)
		{
			return -1;
		}
		try
		{
			if (usaRcvMsgVO.getIcrCode() != null && "50,51".indexOf(usaRcvMsgVO.getIcrCode()) >= 0)
			{
				downLoadBC.modifyExpAccpDtAtBl(usaRcvMsgVO);
				downLoadBC.modifyExpAccpDtAtCntr(usaRcvMsgVO);
			}
			else if (usaRcvMsgVO.getIcrCode() != null && "52".indexOf(usaRcvMsgVO.getIcrCode()) >= 0)
			{
				downLoadBC.modifyExpAccpDtAtCntr(usaRcvMsgVO);
			}
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
		}
		return 0;
	}

	/**
	 * 세관에서 받은 메시지의 SCAC code가 SMLM이면서 House B/L 인 경우, Get_ams_rcv_msg 에서 House B/L을 처리한 후<br>
	 * Get_ams_rcv_msg_M에서 House B/L에 대한 Master B/L을 찾아 Master B/L을 가지고 다시 처리한다<br>
	 * 
	 * @param String str
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 */
	private int getAmsRcvMsgM(String msg, UsaRcvMsgVO usaRcvMsgVO) {
		int rtn = 0;
		String prefix = "";
		/**************************************************************************
		 * 호출 전에 bl_no, mbl_no, hbl_no가 이미 설정되어 들어온다.
		 **************************************************************************/
		// String tmpCusLoc = usaRcvMsgVO.getCusLoc();\
		// cusLoc가 모두 HOUSE로 하드코딩됨.
		usaRcvMsgVO.setCusLoc("HOUSE");
		StringTokenizer token = new StringTokenizer(msg, "\n");
		/******************************************************************************/
		/* 레코드 ID별로 실제적으로 메시지 처리 하는 부분 시작 */
		/******************************************************************************/
		String zone = "";
		String icrResendInd = "";
		BkgCstmsAdvBlVO bkgCstmsAdvBlVO = null;
		int r = 0;
		int iR03 = 0;
		while (token.hasMoreTokens())
		{
			String str = token.nextToken();
			if (str != null && str.length() >= 80)
			{
				prefix = str.substring(0, 3);
				// W01 레코드 처리
				if ("W01".equals(prefix))
				{
					// BKG_CSTMS_ADV_IBD : CSTMS_CLR_RSLT_CD = 'R'로 변경
					rtn = putNakMsgM(str, usaRcvMsgVO);
				}
				/******************************************************************************/
				/* R02 레코드 처리 */
				/******************************************************************************/
				else if ("R02".equals(prefix))
				{
					zone = str.substring(6, 7);
					icrResendInd = str.substring(68, 69);
					r++;
					usaRcvMsgVO.setZone(zone);
					usaRcvMsgVO.setIcrResendInd(icrResendInd);
					// 아래 H 체크 로직삭제, getAmsRcvMsgM은 하우스 BL만 구동시키는 메서드이므로 중복 체크임.
					// BL조회후 조회결과가 있는 경우에만 putCustomsRM 을 구동, R02 두번째 라인도 구동되는 것을 방지.
					// 아울러 else 로직에 있었던, icd_code 13, 52 부분도 삭제함. 원본소스 52라인 부분.
					// if("H".indexOf(zone) >= 0 ){
					bkgCstmsAdvBlVO = dbDao.searchAdvBl(str.substring(3, 15), "US");
					if (bkgCstmsAdvBlVO != null)
					{
						rtn = putCustomsRM(str, usaRcvMsgVO);
						if (rtn < 0)
						{
							return -1;
						}
						iR03 = 0;
					}
				}// R02
				/******************************************************************************/
				/* R03 레코드 처리 */
				/******************************************************************************/
				else if ("R03".equals(prefix))
				{
					/******************************************************************************/
					/* 첫번째 R03 레코드 처리 */
					/******************************************************************************/
					if (iR03 == 0)
					{
						iR03 = 1;
						usaRcvMsgVO.setIcrRemark1(str.substring(3, 53));
						rtn = dbDao.modifyCustomsResult(usaRcvMsgVO);
						if (rtn < 0)
						{
							return -1;
						}
					}// iR03 == 0
					/******************************************************************************/
					/* 두번째 R03 레코드 처리 */
					/******************************************************************************/
					else if (iR03 == 1)
					{
						iR03 = 2;
						rtn = putCustomsRemarkM(str, usaRcvMsgVO);
						if (rtn < 0)
						{
							return -1;
						}
					}
					/******************************************************************************/
					/* 세번째 R03 레코드 처리 */
					/******************************************************************************/
					else if (iR03 == 2)
					{
						usaRcvMsgVO.setRemark3(str.substring(3, 53));
						// inbond_customs_r에 cus_loc는 ICR_LOC(as-is):RCV_LOC_CD(to-be)에 입력되는데,
						// 현 위치에서는 하드코딩으로 'HOUSE'가 입력
						/********************************************/
						/* icr_remark1으로 업데이트하게 되어 있어 */
						/* icr_remark3로 업데이트 하도록 수정 */
						/* 2006/3/21 민동진 수정 */
						/********************************************/
						rtn = dbDao.modifyCustomsResultForRemark3(usaRcvMsgVO);
						if (rtn < 0)
						{
							return -1;
						}
					}
				}
			}
		}
		// 레코드 ID별로 실제적으로 메시지 처리 하는 부분 종료(for문)
		return 0;
	}

	/**
	 * 세관에서 받은 메시지의 SCAC code가 SMLM아니면. 즉 NVOCC의 House B/L을 SNP로서 받았을 때 <br>
	 * Get_ams_rcv_msg에서 NVOCC의 House B/L에 대한 처리를 하고 NVOCC의 House B/L에 대한 SML의 Master B/L을 찾아 <br>
	 * Get_ams_rcv_msg_N에서 다시 처리한다
	 * 
	 * @param String str
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 */
	private int getAmsRcvMsgN(String msg, UsaRcvMsgVO usaRcvMsgVO) {
		int rtn = 0;
		String prefix = "";
		/**************************************************************************
		 * 호출 전에 bl_no, mbl_no, hbl_no가 이미 설정되어 들어온다.
		 **************************************************************************/
		StringTokenizer token = new StringTokenizer(msg, "\n");
		/******************************************************************************/
		/* 레코드 ID별로 실제적으로 메시지 처리 하는 부분 시작 */
		/******************************************************************************/
		String zone = "";
		String inCode = "";
		String inCodeb = "";
		String icrResendInd = "";
		String cntrNo = "";
		int r = 0;
		int iR03 = 0;
		while (token.hasMoreTokens())
		{
			String str = token.nextToken();
			if (str != null && str.length() >= 80)
			{
				prefix = str.substring(0, 3);
				// W01 레코드 처리
				if ("W01".equals(prefix))
				{
					rtn = putNakMsgN(str, usaRcvMsgVO);
					if (rtn < 0)
					{
						return rtn;
					}
				}
				/******************************************************************************/
				/* R02 레코드 처리 */
				/******************************************************************************/
				else if ("R02".equals(prefix))
				{
					inCode = str.substring(15, 17);
					inCodeb = str.substring(7, 8);
					r++;
					usaRcvMsgVO.setZone(zone);
					usaRcvMsgVO.setIcrResendInd(icrResendInd);
					if (!"  ".equals(inCode) && !"00".equals(inCode) && !" ".equals(inCodeb))
					{
						rtn = putCustomsRN(str, usaRcvMsgVO);
						if (rtn < 0)
						{
							return -1;
						}
						iR03 = 0;
					}
					else
					{
						if (usaRcvMsgVO.getIcrCode() != null && "13,52".indexOf(usaRcvMsgVO.getIcrCode()) >= 0)
						{
							cntrNo = str.substring(23, 34);
							usaRcvMsgVO.setCntrNo(cntrNo);
						}
					}
				}// R02
				/******************************************************************************/
				/* R03 레코드 처리 */
				/******************************************************************************/
				else if ("R03".equals(prefix))
				{
					/******************************************************************************/
					/* 첫번째 R03 레코드 처리 */
					/******************************************************************************/
					if (iR03 == 0)
					{
						iR03 = 1;
						usaRcvMsgVO.setIcrRemark1(str.substring(3, 53));
						rtn = dbDao.modifyCustomsResult(usaRcvMsgVO);
						if (rtn < 0)
						{
							return -1;
						}
					}// iR03 == 0
					/******************************************************************************/
					/* 두번째 R03 레코드 처리 */
					/******************************************************************************/
					else if (iR03 == 1)
					{
						iR03 = 2;
						rtn = putCustomsRemarkM(str, usaRcvMsgVO);
						if (rtn < 0)
						{
							return -1;
						}
					}
					/******************************************************************************/
					/* 세번째 R03 레코드 처리 */
					/******************************************************************************/
					else if (iR03 == 2)
					{
						usaRcvMsgVO.setRemark3(str.substring(3, 53));
						/********************************************/
						/* icr_remark1으로 업데이트하게 되어 있어 */
						/* icr_remark3로 업데이트 하도록 수정 */
						/* 2006/3/21 민동진 수정 */
						/********************************************/
						rtn = dbDao.modifyCustomsResultForRemark3(usaRcvMsgVO);
						if (rtn < 0)
						{
							return -1;
						}
					}
				}
			}
		}
		// 레코드 ID별로 실제적으로 메시지 처리 하는 부분 종료(for문)
		return 0;
	}

	/**
	 * As-is의 Put_Customs_R_ISF를 구현한다. <br>
	 * 
	 * @param String str
	 * @param UsaRcvMsgVO usaRcvMsgVO
	 * @return int
	 */
	private int putCustomsRIsf(UsaRcvMsgVO usaRcvMsgVO) {
		/******************************************************/
		/* 20091028 JHPARK inbond_customs_r 에 저장해야 한다. */
		/* 단 File View 를 위해서 VVD 에 UNKNOWN00 을 삽입함. */
		/* ISF ACCEPT 시에는 ICR_REMARK3 에 ISF_TRAC_NO 삽입 */
		/******************************************************/
		usaRcvMsgVO.setBlNo(usaRcvMsgVO.getIsfInBl());
		usaRcvMsgVO.setVslCdM("UNKN");
		// 2009/11/04 IBD_TP_CD가 DSPO_CD 위치에 들어감. 아래는 하동일 수석과 메신져 확인 내용.
		// Dowan Kim [오후 3:02]: 수신 샘플 보면, irType값이 SN으로 들어가게 되는데요... 위에 로직대로면 IBD_TP_CD는 값이 없고, DSPO_CD에 'SN'이 들어가게
		// 됩니다. 맞는건지 확인 부탁합니다.
		// Dong-Il HA [오후 3:07]: 네 맞는 것 같습니다. IBD_TP_CD 는 널이고 DSPO_CD은 'SN'이 들어 가네요
		usaRcvMsgVO.setIcrCode(usaRcvMsgVO.getIrType());
		// DSPO_CRE_DT는 NOT NULL항목이고, icr_date를 이용하여 입력된다.
		// ISF-5에서는 icr_date를 구하는 로직이 없으므로, icr_date에 ir_date를 넣는다.
		usaRcvMsgVO.setIcrDate(usaRcvMsgVO.getIrDate());
		UsaResultCntrVO usaResultCntrVO = dbDao.searchMaxSeqAtResult(usaRcvMsgVO);
		usaRcvMsgVO.setIcrSeq(usaResultCntrVO.getIcrSeq());
		dbDao.addCustomsResult(usaRcvMsgVO);
		// Update BKG_CSTMS_ADV_STWG_SND_LOG
		dbDao.modifyBkgCstmsAdvStwgSndLog(usaRcvMsgVO);
		return 0;
	}

	/**
	 * Log 정보를 생성한다.<br>
	 * 
	 * @param SendingLogVO sendingLogVO
	 * @throws Exception
	 */
	public void addSendLog(SendingLogVO sendingLogVO) throws EventException {
		try
		{
			dbDao.addSendLog(sendingLogVO);
		}
		catch (DAOException de)
		{
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
		}
		catch (Exception e)
		{
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
		}
	}

	/**
	 * Log Detail 정보를 생성한다.<br>
	 * 
	 * @param SendingLogVO sendingLogVO
	 * @throws Exception
	 */
	public void addSendLogDetail(SendingLogVO sendingLogVO) throws EventException {
		try
		{
			dbDao.addSendLogDetail(sendingLogVO);
		}
		catch (DAOException de)
		{
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		}
		catch (Exception e)
		{
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
		}
	}

	/**
	 * BKG_CSTMS_ADV_EDI_BL_RSPN 테이블에 CRR_BAT_NO 등을 삽입한다.<br>
	 * 
	 * @param SendingLogVO sendingLogVO
	 * @throws Exception
	 */
	public void addCarrierBatchNo(SendingLogVO sendingLogVO) throws EventException {
		try
		{
			dbDao.addCarrierBatchNo(sendingLogVO);
		}
		catch (DAOException de)
		{
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), de);
		}
		catch (Exception e)
		{
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), e);
		}
	}

	/**
	 * ISF US 세관신고 위해 FlatFile을 생성한다.
	 * 
	 * @param manifestTransmitVOs manifestTransmitVO
	 * @param account 세션정보
	 * @return String
	 * @throws EventException
	 */
	public String transmitManifestIsf(ManifestTransmitVO[] manifestTransmitVOs, SignOnUserAccount account) throws EventException {
		try
		{
			UsaManifestSearchDetailVO usaManifestTransmitVO = (UsaManifestSearchDetailVO) manifestTransmitVOs[0];
			usaManifestTransmitVO.setUsrId(account.getUsr_id());
			usaManifestTransmitVO.setOfcCd(account.getOfc_cd());
			// 삭제전송의 경우 전송한 이력이 있는지 조회
			if ("D".equals(usaManifestTransmitVO.getSelIsfActCd()))
			{
				if (dbDao.searchIsf5SndLog(usaManifestTransmitVO.getBlNo()) <= 0)
				{
					// There is no data to delete.
					throw new EventException(new ErrorHandler("BKG03054").getMessage());
				}
			}
			else
			{
				// ISF5 대상여부 체크
				if (dbDao.searchIsf5(usaManifestTransmitVO.getBlNo()) <= 0)
				{
					// Data is invalid. ({?msg1} )
					throw new EventException(new ErrorHandler("BKG00388", new String[]{"Invalid ISF5"}).getMessage());
				}
			}
			// MI 전송여부 체크
			UsaMiCountVO checkMiCondVO = new UsaMiCountVO();
			checkMiCondVO.setVvd(usaManifestTransmitVO.getVvd());
			checkMiCondVO.setPod(usaManifestTransmitVO.getPod());
			checkMiCondVO.setPol(usaManifestTransmitVO.getPol());
			checkMiCondVO.setTrsmTp("MI");
//			if (dbDao.checkMiTransCount(checkMiCondVO) == 0)
//			{
//				// You must transmit MI file first.
//				throw new EventException(new ErrorHandler("BKG01055").getMessage());
//			}
			// ISF5전송
			this.amsIsf5(usaManifestTransmitVO);
		}
		catch (DAOException de)
		{
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), de);
		}
		catch (EventException ex)
		{
			throw ex;
		}
		catch (Exception e)
		{
			throw new EventException(new ErrorHandler("BKG06088", new String[] {}).getMessage(), e);
		}
		return null;
	}

	/**
	 * B/L별로 ISF5에 대해 메시지를 만들고 전송한다.
	 * 
	 * @param UsaManifestSearchDetailVO usaManifestTransmitVO
	 */
	private void amsIsf5(UsaManifestSearchDetailVO usaManifestTransmitVO) throws DAOException, EventException {
		
		log.info("amsIsf5 Start");
		/*****************************************************************
		 * Size가 0이 나올수 없음(일단 오류를 피하기 위해 리턴)<br>
		 * List<Isf5InfoVO>는 BKG_CSTMS_ADV_CNTR_MF개수임.<BR>
		 * BL정보는 모두 같아서 LIST의 0번째로 가져오면 되고<BR>
		 * SF40_ISF5의 HTS CODE(HAMO_CMDT_CD)를 가져오는거때문에 LIST로 함
		 *****************************************************************/
		List<Isf5InfoVO> isf5InfoVOs = dbDao.searchIsf5Info(usaManifestTransmitVO.getBlNo(), usaManifestTransmitVO
				.getSelIsfActCd());
		if (isf5InfoVOs.size() <= 0)
		{
			return;
		}
		StringBuffer flatFile = new StringBuffer();
		BookingUtil command = new BookingUtil();
		// FlatFile Header를 생성한다.
		flatFile.append(command.searchCstmsEdiHeader("SMLM", "USCBP", "ISF")).append("\n");
		// F/F Body 만들기
		// SF10.
		flatFile.append("{ST").append("\n");
		flatFile.append("{SF10_HEADER").append("\n");
		flatFile.append("ISF_TP:2").append("\n");
		flatFile.append("ISF_SHIP_TP:01").append("\n");
		flatFile.append("ISF_ACT_CD:").append(isf5InfoVOs.get(0).getIsfActCd()).append("\n");
		flatFile.append("ISF_ACT_REASON:CT").append("\n");
		flatFile.append("ISF_IMP_QUAL:EI").append("\n");
		//flatFile.append("ISF_IMP_NO:95-328691000").append("\n");
		flatFile.append("ISF_IMP_NO:").append(IRS_NO).append("\n");
		flatFile.append("ISF_IMP_DOB:").append("\n");
		flatFile.append("ISF_TRANS_MODE:11").append("\n");
		flatFile.append("ISF_TRAC_NO:").append(isf5InfoVOs.get(0).getCstmsRmk3()).append("\n");
		flatFile.append("ISF_SCAC:SMLM").append("\n");
		//flatFile.append("ISF_BOND_HOLDER:95-328691000").append("\n");
		flatFile.append("ISF_BOND_HOLDER:").append(IRS_NO).append("\n");
		flatFile.append("ISF_BOND_ACT_CD:02").append("\n");
		flatFile.append("ISF_BOND_TP:8").append("\n");
		flatFile.append("ISF_CNTRY_CD:").append("\n");
		flatFile.append("}SF10_HEADER").append("\n");
		// SF15.
		String blTp = "OB";
		// House B/L case.
		if ("H".equals(isf5InfoVOs.get(0).getMh()))
		{
			blTp = "BM";
		}
		flatFile.append("{SF15_SHIP_REF").append("\n");
		flatFile.append("BL_TP:").append(blTp).append("\n");
		flatFile.append("BL_NO:").append("SMLM").append(isf5InfoVOs.get(0).getBlNo()).append("\n");
		flatFile.append("}SF15_SHIP_REF").append("\n");
		// SF20.
		flatFile.append("{SF20_SUB_REF").append("\n");
		flatFile.append("REF_CD:FC").append("\n");
		flatFile.append("REF_NO:SMLM").append("\n");
		flatFile.append("}SF20_SUB_REF").append("\n");
		if ("H".equals(isf5InfoVOs.get(0).getMh()))
		{
			flatFile.append("{SF20_SUB_REF").append("\n");
			flatFile.append("REF_CD:MB").append("\n");
			flatFile.append("REF_NO:").append(isf5InfoVOs.get(0).getMblNo()).append("\n");
			flatFile.append("}SF20_SUB_REF").append("\n");
		}
		// SF30-SF35-SF36 Loop, Booking Party, Ship To Party, Mandatory Data
		// Booking Party
		UsaIsf5CondVO usaIsf5CondVO = new UsaIsf5CondVO();
		usaIsf5CondVO.setBlNo(isf5InfoVOs.get(0).getBlNo());
		UsaIsf5ResultVO pvo = dbDao.searchIsf5BkgParty(usaIsf5CondVO);
		if (pvo != null)
		{
			flatFile.append("{SF30_PARTY").append("\n");
			flatFile.append("ENTT_CD:").append("BKP").append("\n");
			flatFile.append("ENTT_NAME:").append(pvo.getEnttName()).append("\n");
			flatFile.append("ENTT_ID_QUAL:").append("\n");
			flatFile.append("ENTT_ID:").append("\n");
			flatFile.append("CNTRY_N_DOB:").append("\n");
			flatFile.append("{SF35_ADD").append("\n");
			flatFile.append("ADD_QUAL:").append("15").append("\n");
			flatFile.append("ADD_INFO:").append(pvo.getAddInfo()).append("\n");
			flatFile.append("ADD_QUAL_2:").append("15").append("\n");
			flatFile.append("ADD_INFO_2:").append(pvo.getAddInfo2()).append("\n");
			flatFile.append("}SF35_ADD").append("\n");
			flatFile.append("{SF36_ADD2").append("\n");
			flatFile.append("ADD_CT:").append(pvo.getAddCt()).append("\n");
			flatFile.append("ADD_CNTRY_SUB:").append("\n");
			flatFile.append("ADD_ZIP_CD:").append("\n");
			flatFile.append("ADD_CNTRY:").append(pvo.getAddCntry()).append("\n");
			flatFile.append("}SF36_ADD2").append("\n");
			flatFile.append("}SF30_PARTY").append("\n");
		}
		// Ship To Party
		// To Order BL 이면 Notify 정보, 아니면 Consignee 정보
		pvo = dbDao.searchIsf5SF30Party(usaIsf5CondVO);
		if (pvo != null)
		{
			flatFile.append("{SF30_PARTY").append("\n");
			flatFile.append("ENTT_CD:").append("ST").append("\n");
			flatFile.append("ENTT_NAME:").append(pvo.getEnttName()).append("\n");
			flatFile.append("ENTT_ID_QUAL:").append("\n");
			flatFile.append("ENTT_ID:").append("\n");
			flatFile.append("CNTRY_N_DOB:").append("\n");
			flatFile.append("{SF35_ADD").append("\n");
			flatFile.append("ADD_QUAL:").append("15").append("\n");
			flatFile.append("ADD_INFO:").append(pvo.getAddInfo()).append("\n");
			flatFile.append("ADD_QUAL_2:").append("15").append("\n");
			flatFile.append("ADD_INFO_2:").append(pvo.getAddInfo2()).append("\n");
			flatFile.append("}SF35_ADD").append("\n");
			flatFile.append("{SF36_ADD2").append("\n");
			flatFile.append("ADD_CT:").append(pvo.getAddCt()).append("\n");
			flatFile.append("ADD_CNTRY_SUB:").append("\n");
			flatFile.append("ADD_ZIP_CD:").append("\n");
			flatFile.append("ADD_CNTRY:").append(pvo.getAddCntry()).append("\n");
			flatFile.append("}SF36_ADD2").append("\n");
			flatFile.append("}SF30_PARTY").append("\n");
		}
		// 컨테이너 번호별로 CNTR_MD의 hamo_cmdt_cd를 출력한다.
		for (int i = 0; i < isf5InfoVOs.size(); i++)
		{
			flatFile.append("{SF40_ISF5").append("\n");
			flatFile.append("HTS_CD_ISF5:").append(isf5InfoVOs.get(i).getHamoCmdtCd()).append("\n");
			flatFile.append("CNTRY_ORG_ISF5:").append("\n");
			flatFile.append("}SF40_ISF5").append("\n");
		}
		pvo = dbDao.searchIsf5SF50(usaIsf5CondVO);
		if (pvo != null)
		{
			flatFile.append("{SF50_ISF5").append("\n");
			flatFile.append("FPOD_QUAL:").append("K").append("\n");
			flatFile.append("FPOD:").append(pvo.getFpod()).append("\n");
			flatFile.append("DEL_QUAL:").append("UN").append("\n");
			flatFile.append("DEL:").append(pvo.getDel()).append("\n");
			flatFile.append("}SF50_ISF5").append("\n");
		}
		flatFile.append("}SE");
		/**********************************************
		 * FlatFile 전송
		 **********************************************/
		SendFlatFileVO sendFlatFileVO = new SendFlatFileVO();
		sendFlatFileVO.setQueueNm(SubSystemConfigFactory.get("BKG.ALPSBKG_UBIZHJS_CUSTOMS.IBMMQ.QUEUE"));
		sendFlatFileVO.setFlatFile(flatFile.toString());
		FlatFileAckVO flatFileAckVO = command.sendFlatFile(sendFlatFileVO);
 		if (flatFileAckVO.getAckStsCd().equals("E"))
			throw new EventException(new ErrorHandler("BKG00205", new String[] {}).getMessage());
 		/**********************************************
		 * BKG_CSTMS_ADV_STWG_SND_LOG
		 **********************************************/
		String seq = dbDao.searchDateSeq();
		String lsDate = dbDao.searchSysdate("yyyymmddhh24miss");
		SendDetailLogVO sendDetailLogVO = new SendDetailLogVO();
		sendDetailLogVO.setSndProcId("ISF");
		sendDetailLogVO.setSeq(seq);
		sendDetailLogVO.setVvd(usaManifestTransmitVO.getVvd());
		sendDetailLogVO.setPol(usaManifestTransmitVO.getPol());
		sendDetailLogVO.setPod(usaManifestTransmitVO.getPod());
		sendDetailLogVO.setUsrId(usaManifestTransmitVO.getUsrId());
		sendDetailLogVO.setOfcCd(usaManifestTransmitVO.getOfcCd());
		sendDetailLogVO.setCntrCount(isf5InfoVOs.get(0).getCntrCnt());
		sendDetailLogVO.setSndDt(lsDate);
		sendDetailLogVO.setBlNo(isf5InfoVOs.get(0).getBlNo());
		sendDetailLogVO.setIsfActCd(isf5InfoVOs.get(0).getIsfActCd());
		sendDetailLogVO.setCstmsPortCd(isf5InfoVOs.get(0).getCstmsPortCd());
		
		int result = dbDao.addStowageSendLog(sendDetailLogVO);
		if (result > 0)
		{
			StringTokenizer token = new StringTokenizer(flatFile.toString(), "\n");
			int i = 1;
			String tmpStr = "";
			while (token.hasMoreTokens())
			{
				tmpStr = token.nextToken();
				sendDetailLogVO.setDtlSeq(i + "");
				sendDetailLogVO.setMsg(tmpStr);
				dbDao.addSendDetailLog(sendDetailLogVO);
				i++;
			}
		}
	}
	
	/**
	 * HOLD INFO SET
	 * @param blNo blNo
	 * @param usaRcvMsgVO usaRcvMsgVO
	 * @param hldType hldType
	 * @return CstmsHldVO
	 */
	private CstmsHldVO setCstmsHld(String blNo, UsaRcvMsgVO usaRcvMsgVO, String hldType) {
		log.info("Start setCstmsHld");
		CstmsHldVO cstmsHld = new CstmsHldVO();
		cstmsHld.setBlNo(blNo);
		// 'PH' : Hold , 'CF' : Release
		cstmsHld.setHldType(hldType);
		//@ 날자 yyyy-mm-dd
		String hldDt = usaRcvMsgVO.getIrDate().substring(0, 2) + "-" + usaRcvMsgVO.getIrDate().substring(2, 4) + "-" + usaRcvMsgVO.getIrDate().substring(4, 6);
		if (Integer.parseInt(hldDt.substring(0, 2)) > 70)
			hldDt = "19" + hldDt;
		else
			hldDt = "20" + hldDt;
		
		//@ 시간 hh24:mi:ss
		hldDt = hldDt + " " + usaRcvMsgVO.getIrDate().substring(6, 8) + ":" + usaRcvMsgVO.getIrDate().substring(8, 10) + ":" + usaRcvMsgVO.getIrDate().substring(10, 12);
		
		cstmsHld.setCstmsLocCd(JSPUtil.getNull(usaRcvMsgVO.getCusLoc()));
		
		if ("CF".equals(hldType))
		{
			cstmsHld.setRlseHldCd(usaRcvMsgVO.getRlseHldCd());
			cstmsHld.setRlseHldDt(usaRcvMsgVO.getRlseHldDt());
			cstmsHld.setHldCd(usaRcvMsgVO.getHldCd());
			cstmsHld.setHldDt(usaRcvMsgVO.getHldDt());
		}
		else
		{
			// PH or ""의 경우
			cstmsHld.setHldCd(usaRcvMsgVO.getIcrCode());
			cstmsHld.setHldDt(hldDt);
		}
		if ("".equals(cstmsHld.getBlNo()) || "".equals(cstmsHld.getCstmsLocCd())
				|| "".equals(cstmsHld.getHldCd()) || "".equals(cstmsHld.getHldDt())
				|| ("CF".equals(cstmsHld.getHldType()) && "".equals(cstmsHld.getRlseHldCd()))
				|| ("CF".equals(cstmsHld.getHldType()) && "".equals(cstmsHld.getHldCd())))
		{
			return null;
		}
		// Hold Code : Inbound에서 필요한 코드인지 체크
		if (!"".equals(hldType) && !dbDao.searchHldNtcFlg(cstmsHld.getHldType(), cstmsHld.getHldCd(), cstmsHld.getRlseHldCd()))
		{
			return null;
		}
		String strLogDesc = "[B/L No:" + blNo
				+ "] [LocCd:" + cstmsHld.getCstmsLocCd()
				+ "] [HldCd:" + cstmsHld.getHldCd()
				+ "] [HldDt:" + cstmsHld.getHldDt()
				+ "] [RlseHldCd:" + cstmsHld.getRlseHldCd()
				+ "] [RlseHldDt:" + cstmsHld.getRlseHldDt() + "]";
		dbDao.addEnisLog("BKG_USA_RCV_HOLD", hldType, strLogDesc);
		return cstmsHld;
	}

	/**
	 * 컨테이너 C-Flag
	 * 
	 * @param usaRcvMsgVO
	 * @return String
	 * @throws DAOException
	 */
	private String[] setCntrRsltCFlag(UsaRcvMsgVO usaRcvMsgVO) {
		/****************************************************************************/
		/* 20090519 JHPARK 캐나다 Port 를 경유하는 미주 내륙으로 운송되는 화물은 */
		/* 선사 신고대상이 아니라 캐나다에서 미주로 화물을 운송하는 Rail Carrier */
		/* 신고건인데, 이 Rail Company 가 SML 를 (Second Notify Party , SNP) 로 */
		/* 지정해서 미세관에 신고하면 SM 상선도 데이터를 동시에 수신한다. */
		/* 문제는 Rail Company 가 BL 단위로 신고하는게 아니라 CNTR 단위로 신고하기 */
		/* 때문에 수신한 데이터를 CNTR 별로 저장해 둔다. */
		/****************************************************************************/
		/* INBOND_CUSTOMS_R 에 데이터를 저장한 뒤에 INBOND_RLOG_CNTR 에 필요 데이터 */
		/* 를 저장한다. CNTR 별 C-Flag 를 저장하기 위해서 최종 C-Flag 를 확인한다. */
		/****************************************************************************/
		String oldCntrCFlag = "N";
		String oldHoldRemark = "";
		// CNTR 별 새로운 C-Flag (new_cntr_c_flag)를 결정하기 위한 로직이 들어간다.
		String newCntrCFlag = "";
		String newHoldRemark = "";
		String[] newCFlagHoldRmk = new String[3];		// 3개 생성
		UsaResultCntrVO usaResultCntrVO = dbDao.searchCFlagAtResultCntr(usaRcvMsgVO);
		if (usaResultCntrVO != null)
		{
			oldCntrCFlag = usaResultCntrVO.getOldCntrCflag();
			oldHoldRemark = usaResultCntrVO.getOldHoldRemark();
		}
		
		// 5H, 1A는 2개로 등록되어 있는데, Hold를 우선시 해야 함, 2010.04.20, hadi
		if ("5H".equals(usaRcvMsgVO.getIcrCode()) || "1A".equals(usaRcvMsgVO.getIcrCode()))
		{
			// Hold Code의 경우 'H'
			newCntrCFlag = "H";
			newHoldRemark = "HOLD:" + usaRcvMsgVO.getIcrCode();
		}

		if ( usaResultCntrVO != null && "H".equals(usaResultCntrVO.getHold()))
		{
			// Hold Code의 경우 'H'
			newCntrCFlag = "H";
			newHoldRemark = "HOLD:" + usaRcvMsgVO.getIcrCode();
		}
		else if ( usaResultCntrVO != null && "R".equals(usaResultCntrVO.getRemv()))
		{
			// Release Code
			// 이전 Dspo Cd 별 Enter/Release Qty 합산하여 Cntr_Pck_Qty 와 동일할 경우, C-flag =Y or J. 아니면 N
			if(!dbDao.checkRailHoldPairDspo(usaRcvMsgVO)){
				newCntrCFlag = "H";
			}else{
				newCntrCFlag = dbDao.searchRailCflagHYJ(usaRcvMsgVO);
			}
			if("H".equals(newCntrCFlag)){
				newHoldRemark = oldHoldRemark;
			}
		}
		// 69 를 받았을 때 (Rail Company 에서 Manifest 전송이후 최초로 받는 메시지)
		else if ("69".equals(usaRcvMsgVO.getIcrCode()))
		{
			newCntrCFlag = "N";
		}
		// 1J 를 받았을 때 (보세운송 허가)
		else if ("1J".equals(usaRcvMsgVO.getIcrCode()))
		{
			// 2010.04.28 이전 Hold체크 추가
			if ("H".equals(oldCntrCFlag))
			{
				// Hold 가 있으면
				newCntrCFlag = oldCntrCFlag;
				newHoldRemark = oldHoldRemark;
			}
			else
			{
				newCntrCFlag = "J";
			}
			// 1J Qty 는 항상 CNTR Qty 와 동일하다.
			// newCntrCFlag = "J";
		}
		// 1C 를 받았을 때 (Customs Clear)
		//else if ("1C".equals(usaRcvMsgVO.getIcrCode()) || "1W".equals(usaRcvMsgVO.getIcrCode()))
		else if ("1C".equals(usaRcvMsgVO.getIcrCode()))
		{
			// 69의 CNTR QTY -> BKG_CSTMS_ADV_CNTR_MF 의 PCK_QTY로 변경
			int qty69 = dbDao.search69QtyByBl(usaRcvMsgVO);
			// 1C 의 QTY - 4E의 QTY
			int ircQty = dbDao.searchSumQtyByBl(usaRcvMsgVO);
			// 1C 의 QTY - 4E의 QTY + 지금 받은 IC의 Qty
			ircQty = ircQty + Integer.parseInt(usaRcvMsgVO.getIcrQty());
			// 1C Total Qty (irc_qty) 가 CNTR Qty (qty_69) 와 같으면
			if (ircQty == qty69)
			{
				if ("H".equals(oldCntrCFlag))
				{
					// Hold 가 있으면
					newCntrCFlag = oldCntrCFlag;
					newHoldRemark = oldHoldRemark;
				}
				else
				{
					newCntrCFlag = "Y";
				}
			}
			else
			{
				// 1C Total Qty (irc_qty) 가 CNTR Qty (qty_69) 와 다르면
				newCntrCFlag = oldCntrCFlag;
			}
		}
		else if ("4E".equals(usaRcvMsgVO.getIcrCode()))
		{
			// 이전 Dspo Cd 별 Enter/Release Qty 합산하여 Cntr_Pck_Qty 와 동일할 경우, C-flag =Y or J. 아니면 N
			if(!dbDao.checkRailHoldPairDspo(usaRcvMsgVO)){
				newCntrCFlag = "H";
			}else{
				newCntrCFlag = dbDao.searchRailCflagHYJ(usaRcvMsgVO);
			}
			if("H".equals(newCntrCFlag)){
				newHoldRemark = oldHoldRemark;
			}
		}
		else
		{
			newCntrCFlag = oldCntrCFlag;
			newHoldRemark = oldHoldRemark;
		}
		newCFlagHoldRmk[0] = newCntrCFlag;			// 새로운 Flag
		newCFlagHoldRmk[1] = newHoldRemark;
		newCFlagHoldRmk[2] = oldCntrCFlag;			// 이전 Flag
		return newCFlagHoldRmk;
	}

	/**
	 * C-Flag 판단로직
	 * 
	 * @param usaRcvMsgVO
	 * @param oldCFlag
	 * @return
	 * @throws DAOException
	 */
	private String getCFlag(UsaRcvMsgVO usaRcvMsgVO, String oldCFlag) {
		String newCFlag = "N";
		/*********************************************************
		 * 2010-03-22 : DSPO CODE '4A'의 경우<br>
		 * 그전에 1C가 들어온 경우 N<br>
		 * 그전에 1A, 1B가 들어와서 hold가 풀린경우 4A가 다시 들어오면 'H'<BR>
		 * 4A 후 1B OR 4C가 들어오면 HOLD를 풀어준다('Y')
		 *********************************************************/
		if ("4A".equals(usaRcvMsgVO.getIcrCode()))
		{
			newCFlag = dbDao.searchCFlag4A(usaRcvMsgVO.getBlNo());
			if (!"".equals(newCFlag))
			{
				if ("H".equals(oldCFlag)) return "H";
				return newCFlag;
			}
		}
		else if ("1B,4C".indexOf(usaRcvMsgVO.getIcrCode()) >= 0)
		{
			newCFlag = dbDao.searchCFlag1B4C(usaRcvMsgVO.getBlNo());
			if (!"".equals(newCFlag))
			{
				return newCFlag;
			}
		}
		else
		{
			/*****************************************************************
			 * 2010.08.17 KMJ<BR>
			 * 4A가 들어와서 HOLD가 된 경우<BR>
			 * 1B, 4C가 들어와서 REMOVAL 시키지 못했으면 항상 HOLD가 된다.<BR>
			 * 만일, 1C가 들어와 아래 Y로직을 타서 결과가 'Y'가 되면 문제가 되므로<BR>
			 * 현재 상태가 'H'이고 그 'H'가 '4A'에 의한 HOLD인가를 판단해서<BR>
			 * '4A'에 의한 HOLD인 경우 다음 로직을 타지 않게 한다.
			 *****************************************************************/
			if ("H".equals(oldCFlag) && dbDao.check4AHold(usaRcvMsgVO)) {
				return "H";
			}
		}
		// C-Flag 시작
		newCFlag = "N";

		// Hold가 Pair Removal코드로 Qty가 맞는지 조회
		if (!dbDao.checkHoldRemvQty(usaRcvMsgVO))
		{
			newCFlag = "H";
		}
		/*********************************************************
		 * C-Flag 체크순서 : H -> W -> Y -> J,I,V,T,E -> N<br>
		 * H -> W -> Y(P:Partial BL의 경우 Y대신 P로 세팅) 그외 N<br>
		 *********************************************************/
		if ("N".equals(newCFlag))
		{
			newCFlag = dbDao.searchCFlagHWY(usaRcvMsgVO);
		}
		/*********************************************************
		 * I -> J(D) -> V -> T -> E 그외 N<br>
		 * D:Partial BL의 경우 J대신 D로 세팅)<br>
		 * 이해 안가서 완전 재수정했음.2009-12-15<br>
		 * 김도완수석 C-Flag 로직 version 1.85 참고<br>
		 *********************************************************/
		if ("N".equals(newCFlag))
		{
			newCFlag = dbDao.searchCFlagIJVTE(usaRcvMsgVO, oldCFlag);
		}
		/*********************************************************
		 * 2010.01.26추가<br>
		 * 51, 52의 경우 T, E 로직 추가
		 *********************************************************/
		if ("51,52".indexOf(usaRcvMsgVO.getIcrCode()) >= 0)
		{
			String tmp5152 = dbDao.searchCFlagTE(usaRcvMsgVO);
			if (!"N".equals(tmp5152))
			{
				newCFlag = tmp5152;
			}
		}
		// 그전 flag가 Hold 인데 N으로 풀리면 반영하지 않고
		// 그전 flag가 Hold가 아니고 J,P,Y,W,T,E의 경우 새로운 flag가 N이 되면 그전 flag유지
		if (   !"H".equals(oldCFlag) 
			&& "N".equals(newCFlag) 
			&& !"4E".equals(usaRcvMsgVO.getIcrCode())
			&& !"J".equals(oldCFlag  )
			)
			newCFlag = oldCFlag;
		return newCFlag;
	}

	/**
	 * Partial BL 체크
	 * 
	 * @param usaRcvMsgVO
	 * @param newCFlag
	 * @param cstmsClrs
	 * @return
	 */
	private String getPartialCFlag(UsaRcvMsgVO usaRcvMsgVO, String newCFlag, List<CstmsClrVO> cstmsClrs) {
		/**********************************************
		 * Partial B/L 조회<br>
		 * Partial BL의 경우 Y->P, J->D로 세팅
		 *********************************************/
		usaRcvMsgVO.setIbflag("");
		List<UsaPartialBlVO> usaPartialBlVOs = dbDao.searchPartialBl(usaRcvMsgVO);
		int yjCount = 0;
		String oldCFlag = "";
		for (int i = 0; i < usaPartialBlVOs.size(); i++)
		{
			/**********************************************
			 * Partial은 J(D), Y(P) 이면 증가
			 **********************************************/
			oldCFlag = usaPartialBlVOs.get(i).getLclCustcIndA();
			if ("Y".equals(newCFlag))
			{
				if ( "Y".equals(oldCFlag) || "P".equals(oldCFlag))
				{
					yjCount++;
				}
			}
			else if ("J".equals(newCFlag))
			{
				if ( "J".equals(oldCFlag) || "D".equals(oldCFlag))
				{
					yjCount++;
				}
			}
		}
		/**********************************************
		 * Partial 갯수와 같으면 CGO_RLSE를 Y or J로 update<br>
		 * 다르면 현재 BL을 Y -> P, J -> D로 변경한다.
		 **********************************************/

		if (usaPartialBlVOs.size() == yjCount  )  
		{
			// 59 code 가 Split B/L 별로 모두 들어오면서 퍼포먼스 저하 방지 목적.
			if (!usaRcvMsgVO.getIcrCode().equals("59") ) {
				for (int i = 0; i < usaPartialBlVOs.size(); i++)
				{
					/**********************************************
					 * Cargo Release Set
					 **********************************************/
					CstmsClrVO cstmsClr = new CstmsClrVO();
					cstmsClr.setBlNo(usaPartialBlVOs.get(i).getLclBlNbrA());
					// ognCFlag...
					cstmsClr.setCstmsClrCd(newCFlag);
					cstmsClr.setCstmsDsPoCd(usaRcvMsgVO.getIcrCode());
					cstmsClr.setEvntOfcCd("USABB");
					cstmsClr.setEvntUsrId("AMS");
					if (Integer.parseInt(usaRcvMsgVO.getIrDate().substring(0, 2)) > 70)
						cstmsClr.setEvntDt("19" + usaRcvMsgVO.getIrDate());
					else
						cstmsClr.setEvntDt("20" + usaRcvMsgVO.getIrDate());
					cstmsClr.setCgorTeamCd("A");
					cstmsClr.setCgoEvntNm("AMS_RCV");
					cstmsClr.setCstmsLocCd(usaRcvMsgVO.getCusLoc());
					cstmsClrs.add(cstmsClr);
	
					// Log
					String strLogDesc = "[Partial B/L No:" + usaPartialBlVOs.get(i).getLclBlNbrA() + "] [OLD C-Flag:"
							+ usaPartialBlVOs.get(i).getLclCustcIndA() + "] [NEW C-Flag:" + newCFlag + "] [DT:"
							+ usaRcvMsgVO.getIrDate() + "] [BAT NO:" + usaRcvMsgVO.getCrrBatNo() + "]";
					dbDao.addEnisLog("BKG_USA_RCV_PARTIAL", usaRcvMsgVO.getBlNo(), strLogDesc);
				}
			}	
		}
		else
		{
			if ("Y".equals(newCFlag))
				newCFlag = "P";
			if ("J".equals(newCFlag))
				newCFlag = "D";
		}
		return newCFlag;
	}
	
	/**
	 * 1J : IBD.IBD_TRSP_ACPT_DT
	 * 11,13 : IBD.IBD_TRSP_ARR_DT
	 * @param usaRcvMsgVO
	 */
	private void setArrDate(UsaRcvMsgVO usaRcvMsgVO) {
		try
		{
			if ("1J".equals(usaRcvMsgVO.getIcrCode()))
			{
				usaRcvMsgVO.setIbflag("ACPT");
				downLoadBC.modifyExpAccpDtAtBl(usaRcvMsgVO);
			}
			else if ("11,13".indexOf(usaRcvMsgVO.getIcrCode()) >= 0)
			{
				usaRcvMsgVO.setIbflag("ARR");
				downLoadBC.modifyExpAccpDtAtBl(usaRcvMsgVO);
			}
		}
		catch(Exception e)
		{
			log.error(e.getMessage());
		}
	}

	/**
	 * Transmit 하기 위한 세관 테이블의 Customer, Container 등의 Terminal BL 정보를 조회한다
	 * 
	 * @param BlInfoCondVO blInfoCondVO
	 * @return List<BlInfoVO>
	 * @exception EventException
	 */
	public List<BlInfoVO> searchTmlBlByVvd(BlInfoCondVO blInfoCondVO) throws EventException {
		try
		{
			return dbDao.searchUsaTmlBlByVvd(blInfoCondVO);
		}
		catch (DAOException ex)
		{
			throw new EventException(new ErrorHandler("BKG40110", new String[] { "Terminal" }).getMessage(), ex);
		}
		catch (Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG40110", new String[] { "Terminal" }).getMessage(), ex);
		}
	}

	/**
	 * Baplie Alarm List를 조회한다.
	 * 
	 * @param BaplieAlarmSetupVO baplieAlarmSetupVO
	 * @return List<BaplieAlarmSetupVO>
	 * @exception EventException
	 */
	public List<BaplieAlarmSetupVO> searchBaplieAlarmSetup(BaplieAlarmSetupVO baplieAlarmSetupVO) throws EventException {
		try{
			return dbDao.searchBaplieAlarmSetup(baplieAlarmSetupVO);
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG40110", new String[] { "Terminal" }).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG40110", new String[] { "Terminal" }).getMessage(), ex);
		}
	}	

	/**
	 * Baplie Alarm List를 관리한다.
	 * 
	 * @param baplieAlarmSetupVOs BaplieAlarmSetupVO[]
	 * @param user_id String
	 * @exception EventException
	 */
	public void manageBaplieAlarmSetup(BaplieAlarmSetupVO[] baplieAlarmSetupVOs, String user_id) throws EventException {
		try {
			List<BaplieAlarmSetupVO> addList = new ArrayList<BaplieAlarmSetupVO>();
			List<BaplieAlarmSetupVO> modList = new ArrayList<BaplieAlarmSetupVO>();
			List<BaplieAlarmSetupVO> delList = new ArrayList<BaplieAlarmSetupVO>();
			BaplieAlarmSetupVO baplieAlarmSetupVO = new BaplieAlarmSetupVO();
			
			for (int i = 0; i < baplieAlarmSetupVOs.length; i++) {
				baplieAlarmSetupVO.setSlanCd(baplieAlarmSetupVOs[i].getSlanCd());
				baplieAlarmSetupVO.setLstPortCd(baplieAlarmSetupVOs[i].getLstPortCd());
				baplieAlarmSetupVO.setRcvrEml(baplieAlarmSetupVOs[i].getRcvrEml());
				baplieAlarmSetupVO.setCntCd(baplieAlarmSetupVOs[i].getCntCd());
				if (baplieAlarmSetupVOs[i].getIbflag().equals("I")) {
					// 중복체크
					if (dbDao.searchBaplieAlarmSetup(baplieAlarmSetupVO).size() > 0) {
						throw new EventException(new ErrorHandler("BKG01126").getMessage());
					}
					addList.add(baplieAlarmSetupVOs[i]);
				} else if (baplieAlarmSetupVOs[i].getIbflag().equals("U")) {
					// 입력한 값과 그전 입력된 값이 다를 경우 중복체크
					if (!baplieAlarmSetupVOs[i].getHiddenLstPortCd().equals(baplieAlarmSetupVOs[i].getLstPortCd())
							|| !baplieAlarmSetupVOs[i].getHiddenRcvrEml().equals(baplieAlarmSetupVOs[i].getRcvrEml())
							|| !baplieAlarmSetupVOs[i].getHiddenSlanCd().equals(baplieAlarmSetupVOs[i].getSlanCd())
					)
					if (dbDao.searchBaplieAlarmSetup(baplieAlarmSetupVO).size() > 0) {
						throw new EventException(new ErrorHandler("BKG01126").getMessage());
					}
					modList.add(baplieAlarmSetupVOs[i]);
				} else if (baplieAlarmSetupVOs[i].getIbflag().equals("D")) {
					delList.add(baplieAlarmSetupVOs[i]);
				}
				// 로그인 아이디
				baplieAlarmSetupVOs[i].setUserId(user_id);
			}
			if (addList.size() > 0) 
				dbDao.addBaplieAlarmSetup(addList);
			if (modList.size() > 0) 
				dbDao.modifyBaplieAlarmSetup(modList);
			if (delList.size() > 0) 
				dbDao.removeBaplieAlarmSetup(delList);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06087", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * 현재 시간을 기준으로 이전 시간인지 비교 <br>
	 * 이전 시간이면 true, 아니면 false를 리턴 
	 * @param year
	 * @param month
	 * @param date
	 * @param hourOfDay
	 * @param minute
	 * @return boolean
	 */
	private boolean isBeforeDate(int year, int month, int date, int hourOfDay, int minute) throws EventException {
		Calendar currentCalendar = Calendar.getInstance();
		currentCalendar.set(Calendar.MONTH, currentCalendar.get(Calendar.MONTH) + 1);
		Calendar baseCalendar = Calendar.getInstance();
		baseCalendar.set(year, month, date, hourOfDay, minute);
		
		log.info("*******************************************************************");
		log.info("current YEAR : " + currentCalendar.get(Calendar.YEAR));
		log.info("current MONTH : " + currentCalendar.get(Calendar.MONTH));
		log.info("current DATE : " + currentCalendar.get(Calendar.DATE));
		log.info("current HOUR_OF_DAY : " + currentCalendar.get(Calendar.HOUR_OF_DAY));
		log.info("current MINUTE : " + currentCalendar.get(Calendar.MINUTE));
		log.info("base YEAR : " + baseCalendar.get(Calendar.YEAR));
		log.info("base MONTH : " + baseCalendar.get(Calendar.MONTH));
		log.info("base DATE : " + baseCalendar.get(Calendar.DATE));
		log.info("base HOUR_OF_DAY : " + baseCalendar.get(Calendar.HOUR_OF_DAY));
		log.info("base MINUTE : " + baseCalendar.get(Calendar.MINUTE));
		log.info("*******************************************************************");
		
		return currentCalendar.before(baseCalendar);
	}

	/**
	 * loadCstmsRcvMsg에서 사용하는 내부 메소드<br>
	 * 수신메시지에서 각항목별 정보를 추출한다.<br>
	 *  
	 * @param String src
	 * @param String prefix
	 * @param String endDelimeter
	 * @return String
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
	
	/**
	 * cstms notice 대상 e-mail 정보 조회
	 * 
	 * @param CstmsNtcSndInfoVO cstmsNtcSndInfoVO
	 * @return List<CstmsNtcSndInfoVO>
	 * @throws EventException
	 */
	public List<CstmsNtcSndInfoVO> searhCstmsNtcSndInfo(CstmsNtcSndInfoVO cstmsNtcSndInfoVO) throws EventException {
		List<CstmsNtcSndInfoVO> list = null;
		try{
			list =  dbAceDao.searhCstmsNtcSndInfo(cstmsNtcSndInfoVO);
		} catch (DAOException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
		return list;
	}	
}