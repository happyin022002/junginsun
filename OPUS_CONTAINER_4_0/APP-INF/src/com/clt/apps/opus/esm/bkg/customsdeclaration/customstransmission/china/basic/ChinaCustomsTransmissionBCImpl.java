/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChinaCustomsTransmissionBCImpl.java
*@FileTitle : ChinaCustomsTransmissionBCImpl
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.25
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.08.25 이수빈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.basic;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.bcm.sup.valuemanage.util.ConstantMgr;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration.ChinaCustomsTransmissionDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.integration.ChinaCustomsTransmissionEAIDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaAckVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlCntrListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlCustListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlDangerCntrListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlGeneralListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaContainerCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaVvdInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.CstmsEmlListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.InboundTSCntrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.InboundTSCustVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.InboundTSDownExcelVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.InboundTSGRPVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.InboundTSInfoBLVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.InboundTSInfoSKDVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.MailContentsVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.SendMailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.TmlBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.TmlCntrVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.TmlVslInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.TransKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.VvdKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo.ContainerCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.vo.ChinaManifestDetailListVO;
import com.clt.framework.component.backend.core.BackEndJobManager;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.log4j.StringUtils;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCstmsChnSndLogVO;


/**
 * OPUS-CustomsDeclaration Business Logic Basic Command implementation<br>
 * - OPUS-CustomsDeclaration에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Lee Subin
 * @see 각 DAO 클래스 참조
 * @since J2EE 1.4
 */
public class ChinaCustomsTransmissionBCImpl extends BasicCommandSupport implements ChinaCustomsTransmissionBC {

	// Database Access Object
	private transient ChinaCustomsTransmissionDBDAO dbDao = null;
	private transient ChinaCustomsTransmissionEAIDAO eaiDao = null;

	/**
	 * ChinaCustomsTransmissionBCImpl 객체 생성<br>
	 * ChinaCustomsTransmissionDBDAO 생성한다.<br>
	 */
	public ChinaCustomsTransmissionBCImpl() {
		dbDao = new ChinaCustomsTransmissionDBDAO();
		eaiDao = new ChinaCustomsTransmissionEAIDAO();
	}

	/**
	 * 세관 테이블의 Customer, Container, Commodity(CM) 등의 BL 정보를 조회한다
	 *
	 * @param ChinaBlInfoCondVO chinaBlInfoCondVO
	 * @return ChinaBlInfoVO
	 * @exception EventException
	 */
	public ChinaBlInfoVO searchBlInfo(ChinaBlInfoCondVO chinaBlInfoCondVO) throws EventException {
		try{
			// 리턴 VO
			ChinaBlInfoVO blInfoVO = new ChinaBlInfoVO();

			String blNo 	 = chinaBlInfoCondVO.getBlNo();
			String transMode = chinaBlInfoCondVO.getTransMode();

			ChinaBlGeneralListVO 	      chinaBlGeneralListVO     = dbDao.searchBlGeneral(blNo, transMode);
			List<ChinaBlCustListVO>       ChinaBlCustListVOList       = dbDao.searchBlCust(blNo, transMode);
			List<ChinaBlCntrListVO> 	  ChinaBlCntrListVOList 	   = dbDao.searchBlCntr(blNo, transMode);
			List<ChinaBlDangerCntrListVO> ChinaBlDangerCntrListVOList = dbDao.searchBlDangerCntr(blNo, transMode);

			if(chinaBlGeneralListVO != null) blInfoVO.setChinaBlGeneralListVO(chinaBlGeneralListVO);
			if(ChinaBlCustListVOList.size() > 0) blInfoVO.setChinaBlCustListVO(ChinaBlCustListVOList.get(0));
			blInfoVO.setChinaBlCntrListVOs(ChinaBlCntrListVOList);
			blInfoVO.setChinaBlDangerCntrListVOs(ChinaBlDangerCntrListVOList);

			return blInfoVO;

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
		}
	}


	/**
	 * Container No가 추가되었을때 해당 CNTR의 Type을 조회한다
	 *
	 * @param ContainerCondVO containerCondVO
	 * @return String
	 * @exception EventException
	 */
	public String searchContainerType(ContainerCondVO containerCondVO) throws EventException {
		try{
			return dbDao.searchContainerType((ChinaContainerCondVO)containerCondVO);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
		}
	}

	/**
	 * Transmit 하기 위한 중국 세관 테이블의 Customer, Container 등의 BL 정보를 조회한다
	 *
	 * @param VvdKeyVO vvdKeyVO
	 * @return List<ChinaBlInfoListVO>
	 * @exception EventException
	 */
	public List<ChinaBlInfoListVO> searchBlByVvd(VvdKeyVO vvdKeyVO) throws EventException {
		try{
			ChinaBlInfoListVO blInfoVO = new ChinaBlInfoListVO();
			List<ChinaBlInfoListVO> list = null;

			if("csv".equals(vvdKeyVO.getGubun())){
				// CSV 다운로드 시 데이터 총 개수 조회
				list = new ArrayList<ChinaBlInfoListVO>();
				blInfoVO.setTotal(dbDao.searchManifestDetailListCount(vvdKeyVO));
			} else {
				// Vessel Info 조회
				ChinaVvdInfoVO vvdVO = dbDao.searchCncusVvdInfo(vvdKeyVO);
				// B/L list 조회
				list = dbDao.searchManifestList(vvdKeyVO);
				if(vvdVO != null){
					blInfoVO.setVvd(vvdKeyVO.getVvd());
					blInfoVO.setCallSgnNo(vvdVO.getVslCallSgnPortLocCd());
					blInfoVO.setPrePort(vvdVO.getPreClptCd());
					blInfoVO.setNxtPort(vvdVO.getNxtClptCd());
					blInfoVO.setVpsEtaDt(vvdVO.getEtaDt());
					blInfoVO.setVpsEtdDt(vvdVO.getEtdDt());
					blInfoVO.setVpsEtbDt(vvdVO.getEtbDt());
					blInfoVO.setVslEngNm(vvdVO.getVslNm());
					blInfoVO.setVslEngNm(vvdVO.getVslNm());
					blInfoVO.setSndDate(vvdVO.getMfSndDt());
					blInfoVO.setEtaFlg(vvdVO.getEtaFlg());
					blInfoVO.setEtdFlg(vvdVO.getEtdFlg());

				}
			}

			list.add(0, blInfoVO);
			return list;

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
		}
	}

	/**
	 * 세관에 신고할 대상 Manifest 정보(CSV 저장용 데이터)를 조회한 후<br>
	 * 서버에 .CSV  파일생성해서 로컬로 다운로드<br>
	 *
	 * @param VvdKeyVO vvdKeyVO
	 * @return String
	 * @exception EventException
	 */
	public String downloadManifestList(VvdKeyVO vvdKeyVO) throws EventException {
		try {
			List<BlInfoVO> list = dbDao.searchManifestDetailList(vvdKeyVO);
			Map<String, String> fieldNames = new ChinaManifestDetailListVO().getFieldNames();
			Object[] obj = fieldNames.keySet().toArray();
			String[] strArr = new String[obj.length-2];	// ibflag, pagerows 자동 생성 컬럼 제외
			String[] strArrTitle = new String[obj.length-2];

			strArr[0] = "svc_pvd";
			strArr[1] = "bl";
			strArr[2] = "por";
			strArr[3] = "pol";
			strArr[4] = "pod";
			strArr[5] = "del";
			strArr[6] = "wgt";
			strArr[7] = "pck";
			strArr[8] = "meas";
			strArr[9] = "shpr";
			strArr[10] = "cnee";
			strArr[11] = "ntfy";
			strArr[12] = "mk_desc";
			strArr[13] = "cmdt_desc";
			strArr[14] = "cstms_desc";
			strArr[15] = "cn_cmdt";
			strArr[16] = "hs_cd";
			strArr[17] = "cntr_opt";
			strArr[18] = "cntr_no";
			strArr[19] = "cntr_tpsz_cd";
			strArr[20] = "seal_no";
			strArr[21] = "cntr_wgt";
			strArr[22] = "cntr_meas";
			strArr[23] = "cdo_temp";
			strArr[24] = "imdg_clss_cd";
			strArr[25] = "imdg_un_no";
			strArr[26] = "ovr_fwrd_len";
			strArr[27] = "ovr_bkwd_len";
			strArr[28] = "ovr_hgt";
			strArr[29] = "ovr_lf_len";
			strArr[30] = "ovr_rt_len";

			strArrTitle[0] = "SERVICE PROVIDER";
			strArrTitle[1] = "BL NO.";
			strArrTitle[2] = "POR";
			strArrTitle[3] = "POL";
			strArrTitle[4] = "POD";
			strArrTitle[5] = "DEL";
			strArrTitle[6] = "Weight";
			strArrTitle[7] = "PKG QTY";
			strArrTitle[8] = "Measure QTY";
			strArrTitle[9] = "Shipper Address";
			strArrTitle[10] = "Consignee Address";
			strArrTitle[11] = "Notify Address";
			strArrTitle[12] = "Marks Description";
			strArrTitle[13] = "Commodity Description";
			strArrTitle[14] = "Customs Description";
			strArrTitle[15] = "Chiness Commodity";
			strArrTitle[16] = "HS Code";
			strArrTitle[17] = "CNTR Operator";
			strArrTitle[18] = "CNTR NO.";
			strArrTitle[19] = "CNTR Type";
			strArrTitle[20] = "Seal NO.";
			strArrTitle[21] = "CNTR Weight";
			strArrTitle[22] = "CNTR Measure";
			strArrTitle[23] = "Celsius Temperature";
			strArrTitle[24] = "IMDG Class Code";
			strArrTitle[25] = "IMDG UN NO.";
			strArrTitle[26] = "Over Forward Length";
			strArrTitle[27] = "Over Backward Length";
			strArrTitle[28] = "Over Height";
			strArrTitle[29] = "Over Left Length";
			strArrTitle[30] = "Over Right Length";

			if(list.size() > 0){
				return this.generateCsv(list, strArrTitle, strArr);
			}else{
				return "";
			}

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
		}
	}


	/**
	 * 객체를 CSV 파일로 변환하고 파일명을 반환한다.
	 * @param List vos ValueObject 리스트를 담은 객체
	 * @param String[] title 엑셀에서 컬럼의 TITLE 을 정의한 스트링 배열 객체
	 * @param String[] columns 엑셀데이터용 컬럼명 배열
	 * @return String Excel 저장한 파일명
	 */
	@SuppressWarnings("rawtypes")
	private String generateCsv(List vos, String[] title, String[] columns) throws EventException {
		Map valueMap = null;
		StringBuilder header = new StringBuilder();
		StringBuilder body = new StringBuilder();
		StringBuilder sReturn = new StringBuilder();
		String columnValue = null;

		for (int i=0; i<title.length; i++) {
			header.append(title[i]);
			if (i<title.length) {
				header.append(",");
			}
		}
		header.append("\n");
		sReturn.append(header.toString());

		for (int i=0; i<vos.size(); i++) {
			valueMap = ((AbstractValueObject) vos.get(i)).getColumnValues();
			body.append(""); // cell start
			for (int j=0; j<columns.length; j++) {
				columnValue = (String)valueMap.get(columns[j]);
				if ("null".equals(columnValue) || columnValue == null) columnValue = "";
				body.append("\"").append(columnValue).append("\"");
				if (j<columns.length) {
					body.append(",");
				}
			}
			body.append("\n");
			sReturn.append(body.toString());
			body.setLength(0);
		}
		return sReturn.toString();


//		String fileName = "/tmp/" + "China Manifest Transmission_" + System.currentTimeMillis() + ".csv";
//		File f = new File(fileName);
//		BufferedOutputStream bo = null;
//		try{
//			bo = new BufferedOutputStream(new FileOutputStream(f));
//			Map valueMap = null;
//			StringBuffer header = new StringBuffer();
//			StringBuffer body = new StringBuffer();
//			String columnValue = null;
//
//			// TITLE 생성
//			header.append(""); // cell start
//			for ( int i=0; i<title.length; i++){
//				header.append(title[i]);
//				if ( i<title.length) {
//					header.append(",");
//				}
//			}
//			header.append("\n");
//			bo.write(header.toString().getBytes());
//
//			// BODY 생성
//			for ( int i=0; i<vos.size(); i++ ){
//				valueMap = ((AbstractValueObject) vos.get(i)).getColumnValues();
//				body.append(""); // cell start
//				for ( int j=0; j<columns.length; j++){
//					columnValue = (String)valueMap.get(columns[j]);
//					if("null".equals(columnValue) || columnValue == null) columnValue = "";
//					body.append("\"").append(columnValue).append("\"");
//					if ( j<columns.length) {
//						body.append(",");
//					}
//				}
//				body.append("\n");
//				bo.write(body.toString().getBytes());
//				bo.flush();
//				body.setLength(0);
//			}
//		}catch(Exception e){
//            log.error("err " + e.toString(), e);
//			throw new EventException(new ErrorHandler(e).getMessage(), e);
//		}finally{
//			try{
//				bo.close();
//			}catch(Exception e){
//	            log.error("err " + e.toString(), e);
//				throw new EventException(new ErrorHandler(e).getMessage(), e);
//			}
//		}
//		return fileName ;
	}

	/**
	 * 중국 세관 신고를 위해 FlatFile을 생성한다.
	 *
	 * @param ChinaManifestTransmitVO chinamanifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitManifest(ChinaManifestTransmitVO chinamanifestTransmitVO, SignOnUserAccount account) throws EventException {
		try {
			ChinaCustomsTransmissionBackEndJob chinaBackEndJob = new ChinaCustomsTransmissionBackEndJob();
			chinaBackEndJob.setChinaManifestTransmitVO(chinamanifestTransmitVO, account, dbDao);
			BackEndJobManager backEndJobManager = new BackEndJobManager();
			String sFlatFile = backEndJobManager.execute(chinaBackEndJob, account.getUsr_id(), "China Manifest Transmission");
			return sFlatFile;

		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), ex);
		}
	}


	/**
	 * 중국 세관 수신 FlatFile 데이터를 로그 테이블에 저장<br>
	 *
	 * @param String rcvMsg
	 * @exception EventException
	 */
	public void loadCstmsRcvMsg(String rcvMsg) throws EventException {
		try {
			List<ChinaAckVO> returnVOs = new ArrayList<ChinaAckVO>();
			List<ChinaAckVO> chinaAckVOs = new ArrayList<ChinaAckVO>();
			List<ChinaAckVO> chinaBlAckVOs = new ArrayList<ChinaAckVO>();
			List<ChinaAckVO> chinaCntrAckVOs = new ArrayList<ChinaAckVO>();

			StringTokenizer st = new StringTokenizer(rcvMsg, "$$$");
			String[] msgArr = new String[st.countTokens()];
			int h=0;
			while (st.hasMoreTokens()) {
				msgArr[h++] = st.nextToken();
			}

			// BKG_CSTMS_CHN_SND_LOG 저장
			for (int i=0; i<msgArr.length; i++){
				returnVOs = parseRcvMsg(msgArr[i], "");
				if (returnVOs.size() > 0) chinaAckVOs.add(returnVOs.get(0));
			}
			if (chinaAckVOs.size() > 0) dbDao.addAckMsg(chinaAckVOs); // ACK MSG 이력관리 저장 2011.06.27 add.

			// ACK MSG의 순서가 뒤바뀌더라도 최종 ACK MSG가 반영되도록 확인하고 업데이트 함. 2011.06.27 mod. Start
			for (int i=0; i<chinaAckVOs.size(); i++) {
				String[] sndMsg = dbDao.searchAckMsg(chinaAckVOs.get(i).getEdiRefId());
				/*아래 조건을 만족할  경우 BKG_CSTMS_CHN_SND테이블에 대한 Update 대상에서 제외한다.
				 *1> BKG_CSTMS_CHN_SND테이블에 해당 DATA가 존재하고
				 *2> ACK_RCV_DT_MSG가 BKG_CSTMS_CHN_SND테이블의 데이터보다 작거나 같을 경우*/
				if ("CNCRSP".equals(chinaAckVOs.get(i).getMsgKind())) {
					if (sndMsg[1] != null && (new BigInteger(chinaAckVOs.get(i).getAckRcvDt()).compareTo(new BigInteger(sndMsg[1])) <= 0)) {
						chinaAckVOs.remove(i);
					}
				} else {    // RESPON, CMSACK
					if (sndMsg[0] != null && (new BigInteger(chinaAckVOs.get(i).getAckRcvDt()).compareTo(new BigInteger(sndMsg[0])) <= 0)) {
						chinaAckVOs.remove(i);
					}
				}
			}
			// ACK MSG의 순서가 뒤바뀌더라도 최종 ACK MSG가 반영되도록 확인하고 업데이트 함. 2011.06.27 mod. End
			if (chinaAckVOs.size() > 0) {
				// BKG_CSTMS_CHN_SND_LOG 저장
				dbDao.modifyAckMsg(chinaAckVOs);

				// BKG_CSTMS_CHN_SND_LOG_BL 저장
				for (int i=0; i<msgArr.length; i++ ) {
					if (msgArr[i].indexOf("{BL_INFO") < 0) continue;
					returnVOs = parseRcvMsg(msgArr[i], "BL");
					for (int j=0; j<returnVOs.size(); j++) {
						chinaBlAckVOs.add(returnVOs.get(j));
					}
				}
				if (chinaBlAckVOs.size() > 0) {
					if ("CNCRSP".equals(chinaAckVOs.get(0).getMsgKind())) {
						dbDao.modifyBlAckMsgForAgn(chinaBlAckVOs);
					} else {    // RESPON, CMSACK
						dbDao.modifyBlAckMsg(chinaBlAckVOs);
					}
				}

				// BKG_CSTMS_CHN_SND_LOG_CNTR 저장
				for (int i=0; i<msgArr.length; i++ ) {
					if (msgArr[i].indexOf("{CNTR_INFO") < 0) continue;
					returnVOs = parseRcvMsg(msgArr[i], "CNTR");
					for (int j=0; j<returnVOs.size(); j++) {
						chinaCntrAckVOs.add(returnVOs.get(j));
					}
				}
				if (chinaCntrAckVOs.size() > 0) dbDao.modifyCntrAckMsg(chinaCntrAckVOs);
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
	 * 수신 FLAT 파일을 파싱하여 Value Object 에 담아서 리턴.
	 *
	 * @param String rcvMsg
	 * @param String type
	 * @return List<ChinaAckVO>
	 * @exception EventException
	 */
	private List<ChinaAckVO> parseRcvMsg(String rcvMsg, String type) throws EventException {
		ChinaAckVO ackVO = new ChinaAckVO();
		List<ChinaAckVO> ackVOs = new ArrayList<ChinaAckVO>();

		try {
			// 수신 메시지
			String sDiv = "";
			if (rcvMsg.indexOf ("\n") != -1) {
				sDiv = "\n";
			} else {
				sDiv = "\n";
			}
			String[] lineArr = rcvMsg.split(sDiv) ;
			String line = null;
			int idx = -1;

			String msgKind = "";
			String ediRefId = "";
			String blNo = "";

			for (int i=0; i<lineArr.length; i++) {
				line = lineArr[i];
				idx = line.indexOf(":")+1;

				if (line.startsWith("MSGSTART")) msgKind = line.substring(49).trim();
				if (line.startsWith("MSG_REF_NO")) ediRefId = line.substring(idx);

				if (type.equals("BL")) {
					if (line.startsWith("{BL_INFO")) {
						// BL 별 VO 생성
						ackVO = new ChinaAckVO();
						ackVO.setEdiRefId(ediRefId);
					}
					if (line.startsWith("BLNBR")) ackVO.setBlNo (line.substring(idx));
					if (line.startsWith("RESPON_TYPE")) ackVO.setChnCstmsAckTpCd(line.substring(idx));
					if (line.startsWith("RESPON_TEXT")) ackVO.setAckCtnt(line.substring(idx));
					if (line.startsWith("}BL_INFO")) ackVOs.add(ackVO);

				} else if (type.equals("CNTR")) {
					if (line.startsWith("BLNBR")) blNo = line.substring(idx);
					if (line.startsWith("{CNTR_INFO")) {
						// Container 별 VO 생성
						ackVO = new ChinaAckVO();
						ackVO.setEdiRefId(ediRefId);
						ackVO.setBlNo(blNo);
					}
					if (line.startsWith("CNTRNBR")) ackVO.setCntrNo(line.substring(idx));
					if (line.startsWith("TYPE")) ackVO.setChnCstmsAckTpCd(line.substring(idx));
					if (line.startsWith("TEXT")) ackVO.setAckCtnt(line.substring(idx));
					if (line.startsWith("}CNTR_INFO")) ackVOs.add(ackVO);

				} else {
					if (line.startsWith("ACK_TYPE")){
						ackVO = new ChinaAckVO();
						ackVO.setMsgKind(msgKind);
						ackVO.setEdiRefId(ediRefId);
						ackVO.setChnCstmsAckTpCd(line.substring(idx));
					}
					if (line.startsWith("ACK_TEXT")) ackVO.setAckCtnt(line.substring(idx));
					if (line.startsWith("ACK_DT")) {
						ackVO.setAckRcvDt(line.substring(idx));
						ackVOs.add(ackVO);
					}
				}
			}
			return ackVOs;

		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException (new ErrorHandler("BKG00110",new String[]{}).getMessage(), e);
		}
	}

	/**
	 * Transmit 하기 위한 중국 세관 테이블의 Customer, Container 등의 Terminal BL 정보를 조회한다
	 *
	 * @param VvdKeyVO vvdKeyVO
	 * @return List<ChinaBlInfoListVO>
	 * @exception EventException
	 */
	public List<ChinaBlInfoListVO> searchTmlBlByVvd(VvdKeyVO vvdKeyVO) throws EventException {
		try{
			ChinaBlInfoListVO blInfoVO = new ChinaBlInfoListVO();
			List<ChinaBlInfoListVO> list = null;

			// Vessel Info 조회
			ChinaVvdInfoVO vvdVO = dbDao.searchCncusTmlVvdInfo(vvdKeyVO);
			// B/L list 조회
			list = dbDao.searchTmlManifestList(vvdKeyVO);
			if(vvdVO != null){
				blInfoVO.setVvd(vvdKeyVO.getVvd());
				blInfoVO.setCallSgnNo(vvdVO.getVslCallSgnPortLocCd());
				blInfoVO.setPrePort(vvdVO.getPreClptCd());
				blInfoVO.setNxtPort(vvdVO.getNxtClptCd());
				blInfoVO.setVpsEtaDt(vvdVO.getEtaDt());
				blInfoVO.setVpsEtdDt(vvdVO.getEtdDt());
				blInfoVO.setVslEngNm(vvdVO.getVslNm());
				blInfoVO.setVslEngNm(vvdVO.getVslNm());
				blInfoVO.setSndDate(vvdVO.getMfSndDt());
				blInfoVO.setEtaFlg(vvdVO.getEtaFlg());
				blInfoVO.setEtdFlg(vvdVO.getEtdFlg());
			}

			list.add(0, blInfoVO);
			return list;

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
		}
	}

	/**
	 * 중국 Terminal 세관 신고를 위해 FlatFile을 생성한다.
	 *
	 * @param ChinaManifestTransmitVO chinaManifestTransmitVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String transmitTmlManifest(ChinaManifestTransmitVO chinaManifestTransmitVO, SignOnUserAccount account) throws EventException {
		ChinaBlInfoListVO[] chinaBlInfoListVOs = null;
		String transMode = null;
		String blType = null;
		String vvd = null;
		String pol = null;

		// FlatFile 데이터 조회 - 조건 VO
		List<TransKeyVO> transKeyVOs = new ArrayList<TransKeyVO>();
		TransKeyVO transKeyVO = null;

		try {
			chinaBlInfoListVOs 		= chinaManifestTransmitVO.getChinaBlInfoListVOs();
			transKeyVO				= chinaManifestTransmitVO.getTransKeyVO();
			transMode 	= transKeyVO.getTransMode();
			blType 		= transKeyVO.getBlType();
			vvd			= transKeyVO.getVvd();
			pol			= transKeyVO.getLocCd();

			// IN 절에 들어갈 bkg_no 문자열 담은 VO 리스트 생성
			List<String> bkgNoList = generateBkgNoList(chinaBlInfoListVOs);
			for ( int g=0; g < bkgNoList.size(); g++ ) {
				transKeyVO = new TransKeyVO();
				transKeyVO.setVvd(vvd);
				transKeyVO.setTransMode(transMode);
				transKeyVO.setMsgType(blType);
				transKeyVO.setLocCd(pol);
				transKeyVO.setBlNo(bkgNoList.get(g));
				transKeyVO.setOfcCd(account.getOfc_cd());
				transKeyVO.setUsrId(account.getUsr_id());
				transKeyVOs.add(transKeyVO);
			}

			return this.makeChinaManifestTransmitFlatFile(transKeyVOs, pol, blType);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * POL 지역 별 FlatFile을 생성하여 리턴한다.
	 *
	 * @param List<TransKeyVO> transKeyVOs
	 * @param String pol
	 * @param String blType
	 * @return String
	 * @exception EventException
	 */
	private String makeChinaManifestTransmitFlatFile( List<TransKeyVO> transKeyVOs, String pol, String blType ) throws EventException {

		// FlatFile 데이터 조회 - 조건 VO
		TransKeyVO transKeyVO = null;

		// FlatFile 데이터 조회 - 리턴 VO
		TmlVslInfoVO tmlVslInfoVO = null;
		BkgCstmsChnSndLogVO bkgCstmsChnSndLogVO = null;
		//BkgCstmsChnSndLogBlVO bkgCstmsChnSndLogBlVO = null;

		String vvd 			= null;
		String transMode 	= null;
		String msgType 		= null;
		String ediRefId 	= null;
		String ofcCd 		= null;
		String usrId 		= null;
		String blNo			= null;
		String bkgNo		= null;
		String sendDate		= null;

		try {
			transKeyVO  = transKeyVOs.get(0);
			vvd 		= transKeyVO.getVvd();
			transMode 	= "T";
			msgType 	= transKeyVO.getMsgType();
			ofcCd	 	= transKeyVO.getOfcCd();
			usrId	 	= transKeyVO.getUsrId();

			/*============================================================== */
			/* Master Flat Buffer Creation					                 */
			/*============================================================== */
			/* Flat	File Header 및 VVD 정보	구성				             	 */
			/*============================================================== */

			// FlatFile Header를 생성한다.
			BookingUtil command = new BookingUtil();
			String header = command.searchCstmsEdiHeader(ConstantMgr.getScacCode(), pol, "DPBOLM");
			StringBuffer flatFile = new StringBuffer();
			flatFile.append(header).append("\n");

			ediRefId = header.substring(62);

			// 1.VSL/VVD정보 가져오기
			tmlVslInfoVO = dbDao.searchTmlVslInfo ( vvd, blType );
			transKeyVO.setSendDate(tmlVslInfoVO.getSndDt());
			sendDate = tmlVslInfoVO.getSndDt();

			if ( tmlVslInfoVO != null) {
				flatFile.append("MSG_FUNC:")		.append(tmlVslInfoVO.getMsgType())		.append("\n");
				flatFile.append("SENDDATE:")	    .append(tmlVslInfoVO.getSndDt())        .append("\n");
				flatFile.append("REF_NO:")	    	.append(ediRefId)        				.append("\n");
				flatFile.append("VSLCD:")		    .append(tmlVslInfoVO.getVslCd())        .append("\n");
				flatFile.append("VSLVOY:")		    .append(tmlVslInfoVO.getVslVoy())       .append("\n");
				flatFile.append("VSLDIR:")		    .append(tmlVslInfoVO.getVslDir())       .append("\n");
				flatFile.append("CALLSIGN:")		.append(tmlVslInfoVO.getCallSign())     .append("\n");
				flatFile.append("IMO_NO:")		    .append(tmlVslInfoVO.getImoNo())        .append("\n");
				flatFile.append("VSLFULLNAME:")		.append(tmlVslInfoVO.getVslFullNm())	.append("\n");
			}

			/*==============================================================*/
			/* BL 별 flatFile 데이터 생성										*/
			/*==============================================================*/
			List<TmlBlVO> tmlBlVOs = dbDao.searchTmlBlInfo ( transKeyVOs );
			TmlBlVO tmlBlVO = null;

			if(tmlBlVOs.size() > 0){

				for ( int j=0; j < tmlBlVOs.size(); j++ ) {
					tmlBlVO = tmlBlVOs.get(j);
					blNo = tmlBlVO.getBlNo();
					bkgNo = tmlBlVO.getBkgNo();

					/*********************************/
					/** Flat File 생성 - B/L	Body 	**/
					/*********************************/
					flatFile.append("{BL_INFO")			.append("\n");
						flatFile.append("BL_NO:")		.append(tmlBlVO.getBlNo())    	.append("\n");
						flatFile.append("BL_POL:")	    .append(tmlBlVO.getBlPol())    	.append("\n");
						flatFile.append("BL_POL_NAME:") .append(tmlBlVO.getBlPolName()) .append("\n");
						flatFile.append("BL_POD:")	    .append(tmlBlVO.getBlPod())    	.append("\n");
						flatFile.append("BL_POD_NAME:")	.append(tmlBlVO.getBlPodName()) .append("\n");
						flatFile.append("BL_DEL:")  	.append(tmlBlVO.getBlDel())    	.append("\n");
						flatFile.append("BL_DEL_NAME:")	.append(tmlBlVO.getBlDelName()) .append("\n");
						flatFile.append("SHPR:")	    .append(tmlBlVO.getShpr())    	.append("\n");
						flatFile.append("CNEE:")		.append(tmlBlVO.getCnee())    	.append("\n");
						flatFile.append("NTFY:")	    .append(tmlBlVO.getNtfy())    	.append("\n");
						flatFile.append("CGO_DESC:")	.append(tmlBlVO.getCgoDesc())   .append("\n");


						/********************************/
						/** Flat File 생성 - Container **/
						/********************************/
						List<TmlCntrVO> tmlCntrVOs = dbDao.searchTmlCntrInfo ( bkgNo );
						TmlCntrVO tmlCntrVO = null;

						if(tmlCntrVOs.size() > 0) {
							for ( int k=0; k < tmlCntrVOs.size(); k++ ) {
								tmlCntrVO = tmlCntrVOs.get(k);

								flatFile.append("{CNTR_INFO")     .append("\n");
									flatFile.append("CNTR_NO:")   .append(tmlCntrVO.getCntrNo())    .append("\n");
									flatFile.append("CNTRTYPE:")  .append(tmlCntrVO.getCntrType())	.append("\n");
									flatFile.append("NETWGT:")    .append(tmlCntrVO.getNetWgt())    .append("\n");
								flatFile.append("}CNTR_INFO")     .append("\n");
							}
						}

						flatFile.append("}BL_INFO")			.append("\n");

				} // for end : tmlBlVOs
			} // if end

			/*===============================================================*/
			/*                     VVD LOG 저장                                 					 */
			/*===============================================================*/
			bkgCstmsChnSndLogVO = new BkgCstmsChnSndLogVO();
			bkgCstmsChnSndLogVO.setEdiRefId(ediRefId);
			bkgCstmsChnSndLogVO.setChnMfSndIndCd(transMode);
			bkgCstmsChnSndLogVO.setMfSndDt(sendDate);
			bkgCstmsChnSndLogVO.setMfSndOfcCd(ofcCd);
			bkgCstmsChnSndLogVO.setMfSndUsrId(usrId);
			bkgCstmsChnSndLogVO.setTrsmMsgTpId(msgType);
			bkgCstmsChnSndLogVO.setVslCd(vvd);
			bkgCstmsChnSndLogVO.setBkgPolCd(pol);
			bkgCstmsChnSndLogVO.setCreUsrId(usrId);
			bkgCstmsChnSndLogVO.setUpdUsrId(usrId);
			dbDao.addSendLogVvd ( bkgCstmsChnSndLogVO, blNo );

			return flatFile.toString();
		}
		catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06088",new String[]{}).getMessage(), ex);
		}
		catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG06088", new String[]{}).getMessage(), e);
		}
	}

	/**
	 *  IN 절에 들어갈 BKG_NO 문자열로 생성
	 *  IN 절에 데이터가 1000건 이상이면 ORA-1795 오류 발생하므로
	 *  1000건씩 컴마로 연결된 문자열을 생성하여 넘긴다.
	 *
	 * @param ChinaBlInfoListVO[] blInfoVOs
	 * @return List<String>
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<String> generateBkgNoList(ChinaBlInfoListVO[] blInfoVOs) throws EventException {
		try{
			List<String> arrString = new ArrayList();  //BKG_NO
			StringBuffer sb = new StringBuffer();
			int bkgCnt = blInfoVOs.length;
			int quotaCnt = bkgCnt / 1000;
			int restCnt = bkgCnt % 1000;

			for (int i=1; i<=quotaCnt; i++) {
				sb.delete(0, sb.length());
				for (int j=i*1000-1000; j<i*1000; j++) {
					if(j == i*1000-1000){
						sb.append("'").append(blInfoVOs[j].getBkgNo()).append("'");
					}else{
						sb.append(",'").append(blInfoVOs[j].getBkgNo()).append("'");
					}
				}
				arrString.add(sb.toString());
			}

			if(restCnt > 0){
				sb.delete(0, sb.length());
				for (int i=quotaCnt*1000; i<bkgCnt; i++) {
					if(i == quotaCnt*1000){
						sb.append("'").append(blInfoVOs[i].getBkgNo()).append("'");
					}else{
						sb.append(",'").append(blInfoVOs[i].getBkgNo()).append("'");
					}
				}
				arrString.add(sb.toString());
			}

			return arrString;
		}
		catch (Exception e)	{
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), e);
		}
	}

	/**
	 * Inbound Domestic T/S Manifest -
	 * 세관 테이블의 Customer, Container, Commodity(CM) 등의 대상목록 조회
	 *
	 * @param InboundTSInfoBLVO serchCondVO
	 * @return InboundTSInfoGRPVO
	 * @exception EventException
	 */
	public InboundTSGRPVO searchInboundTSManifest(InboundTSInfoBLVO serchCondVO) throws EventException {
		try {
			String bkgNo = serchCondVO.getBkgNo();

			List<InboundTSDownExcelVO> InboundTSDownExcelVOList = new ArrayList<InboundTSDownExcelVO>();
			InboundTSDownExcelVO inboundTSDownExcelVO = null;

			InboundTSInfoBLVO inboundTSInfoBLVO = dbDao.searchInboundTSInfoBL(bkgNo);
			InboundTSInfoSKDVO inboundTSInfoSKDVO = dbDao.searchInboundTSInfoSKD(bkgNo);
			InboundTSCustVO inboundTSCustVO = dbDao.searchInboundTSCust(bkgNo);
			List<InboundTSCntrVO> inboundTSCntrVOList = dbDao.searchInboundTSCntrList(bkgNo);
			InboundTSGRPVO inboundTSGRPVO = new InboundTSGRPVO();
			inboundTSGRPVO.setInboundTSInfoBLVO(inboundTSInfoBLVO);
			inboundTSGRPVO.setInboundTSInfoSKDVO(inboundTSInfoSKDVO);
			inboundTSGRPVO.setInboundTSCustVO(inboundTSCustVO);
			inboundTSGRPVO.setInboundTSCntrVOList(inboundTSCntrVOList);

			List<InboundTSCntrVO> cloneTSCntrVOList = new ArrayList<InboundTSCntrVO>();
			if (inboundTSCntrVOList.size() > 0) {
				ObjectCloner.build(inboundTSCntrVOList, cloneTSCntrVOList);
			} else {
				// 비어있으면 임시vo 1개를 setting
				InboundTSCntrVO tempTSCntrVO = new InboundTSCntrVO();
				cloneTSCntrVOList.add(tempTSCntrVO);
			}

			// DownExcel용 Sheet에 Loading할 Data setting
			for (InboundTSCntrVO inboundTSCntrVO : cloneTSCntrVOList) {
				inboundTSDownExcelVO = new InboundTSDownExcelVO();
				if (inboundTSInfoBLVO != null) {
					inboundTSDownExcelVO.setBkgNo(ConstantMgr.getScacCode() + inboundTSInfoBLVO.getBkgNo().trim());
					inboundTSDownExcelVO.setPorCd(inboundTSInfoBLVO.getPorCd());
					inboundTSDownExcelVO.setPolCd(inboundTSInfoBLVO.getPolCd());
					inboundTSDownExcelVO.setDelCd(inboundTSInfoBLVO.getDelCd().length() > 4 ? inboundTSInfoBLVO.getDelCd().substring(2) : "");
					inboundTSDownExcelVO.setCmdtNm(inboundTSInfoBLVO.getCmdtNm());
					inboundTSDownExcelVO.setPckQty(inboundTSInfoBLVO.getPckQty());
					inboundTSDownExcelVO.setActWgt(inboundTSInfoBLVO.getActWgt());
					inboundTSDownExcelVO.setMkDesc(inboundTSInfoBLVO.getMkDesc());
					inboundTSDownExcelVO.setCmdtDesc(inboundTSInfoBLVO.getCmdtDesc());
					inboundTSDownExcelVO.setMeasQty(inboundTSInfoBLVO.getMeasQty());
				}

				if (inboundTSInfoSKDVO != null) {
					inboundTSDownExcelVO.setVpsEtaDt(inboundTSInfoSKDVO.getVpsEtaDt());
					inboundTSDownExcelVO.setVpsPortCd(inboundTSInfoSKDVO.getVpsPortCd());
					inboundTSDownExcelVO.setYdCd(inboundTSInfoSKDVO.getYdCd());
					inboundTSDownExcelVO.setYdNm(inboundTSInfoSKDVO.getYdNm());
					inboundTSDownExcelVO.setVslEngNm(inboundTSInfoSKDVO.getVslEngNm());
				}

				if (inboundTSCustVO != null) {
					inboundTSDownExcelVO.setShpr(inboundTSCustVO.getShprNm().trim() + " " + inboundTSCustVO.getShprAddr().trim());
					inboundTSDownExcelVO.setCnee(inboundTSCustVO.getCneeNm().trim() + " " + inboundTSCustVO.getCneeAddr().trim());
					inboundTSDownExcelVO.setNtfy(inboundTSCustVO.getNtfyNm().trim() + " " + inboundTSCustVO.getNtfyAddr().trim());
				}

				inboundTSDownExcelVO.setCntrWgt(inboundTSCntrVO.getCntrWgt());
				inboundTSDownExcelVO.setCntrNo(inboundTSCntrVO.getCntrNo());
				inboundTSDownExcelVO.setCntrMeas(inboundTSCntrVO.getCntrMeas());

				String comTpsz = inboundTSCntrVO.getCntrTpszCd();
				String sipglTpsz = "";
				if (comTpsz.length() > 1) {
					if ("D2".equals(comTpsz)) {
						sipglTpsz = "20GP";
					} else if ("D4".equals(comTpsz)) {
						sipglTpsz = "40GP";
					} else if ("D5".equals(comTpsz)) {
						sipglTpsz = "40HC";
					} else if ("D7".equals(comTpsz)) {
						sipglTpsz = "45HC";
					} else if ("R2".equals(comTpsz)) {
						sipglTpsz = "20RF";
					} else if ("R5".equals(comTpsz)) {
						sipglTpsz = "40RH";
					} else if ("F2".equals(comTpsz)) {
						sipglTpsz = "20FR";
					} else if ("A4".equals(comTpsz) || "F4".equals(comTpsz) || "F5".equals(comTpsz)) {
						sipglTpsz = "40FR";
					} else if ("O2".equals(comTpsz) || "S2".equals(comTpsz)) {
						sipglTpsz = "20OT";
					} else if ("O4".equals(comTpsz)|| "O5".equals(comTpsz)) {
						sipglTpsz = "40OT";
					} else if ("T2".equals(comTpsz)) {
						sipglTpsz = "20TK";
					} else {
						sipglTpsz = comTpsz;
					}
				} else {
					sipglTpsz = comTpsz;
				}
				inboundTSDownExcelVO.setSipglCode(sipglTpsz);
				inboundTSDownExcelVO.setCmdtHsCd(inboundTSCntrVO.getCmdtHsCd());
				inboundTSDownExcelVO.setCntrSealNo(inboundTSCntrVO.getCntrSealNo());

				InboundTSDownExcelVOList.add(inboundTSDownExcelVO);
			}
			inboundTSGRPVO.setInboundTSDownExcelVOList(InboundTSDownExcelVOList);

			return inboundTSGRPVO;

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), de);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(new ErrorHandler("BKG00110", new String[] {}).getMessage(), e);
		}
	}

	/**
	 * [EDI_T_BKG_T_CNCUS_SYS_ACK]
	 *  China SYS ACK 메세지 수신
	 *
	 * @param String flatFile
	 * @exception EventException
	 */
	public void receiveEDISysAck(String flatFile) throws EventException {
		try {
			String[] rowArray = flatFile.split("\n");
			String ediRefId = "";
			String[] bodyRowArray = (String[]) org.apache.commons.lang.ArrayUtils.remove(rowArray, 0);

			if ("SYSACK".equals(rowArray[0].substring(52, 62).trim())) {
				for (int i=0; i<5; i++) {
					if (bodyRowArray[i].startsWith("ORG_MSG_KEY")) {
						String[] tmpStrArr = bodyRowArray[i].split(":");
						if (tmpStrArr.length > 1) ediRefId = tmpStrArr[1].trim();
						break;
					}
				}

				// Chiana EDI Technical Failure
				String vvd = "";
				String polCd = "";
				String podCd = "";
				StringBuilder textContent = new StringBuilder();
				List<MailContentsVO> mailContentsVOList = dbDao.searchMailContentsByEdiRefId(ediRefId);
				if (mailContentsVOList.size() > 0) {
					vvd = mailContentsVOList.get(0).getVvd();
					polCd = mailContentsVOList.get(0).getPolCd();
					podCd = mailContentsVOList.get(0).getPodCd();
					textContent.append("\n\nVVD : " + vvd + "\n");
					for (MailContentsVO mailContentsVO : mailContentsVOList) {
						textContent.append("\n\nBL Number : " + mailContentsVO.getBlNo());
						textContent.append("\nLoad Port : " + mailContentsVO.getPolNm());
						textContent.append("\nDischarge Port : " + mailContentsVO.getPodNm());
					}
					textContent.append("\n\n\n");
					textContent.append("\n\n\nDisclaimer : An error has occurred in OPUS EDI. Please contact your Regional Help Desk to resolve this issue.");

					SendMailVO sendMailVO = new SendMailVO();
					// 제목
					sendMailVO.setSubject("CCAM - Technical Failure VVD : " + vvd);
					// 내용
					sendMailVO.setTextContent(textContent.toString());

					// 이메일 주소 목록 조회
					String toEmlAddr = "";
					String ccEmlAddr = "";
					CstmsEmlListVO inCstmsEmlListVO = new CstmsEmlListVO();
					inCstmsEmlListVO.setEdiMsg("CCAM");
					inCstmsEmlListVO.setEdiMsgTpId("EDI Technical Failure");
					inCstmsEmlListVO.setPolCd(polCd);
					inCstmsEmlListVO.setPodCd(podCd);
					List<CstmsEmlListVO> cstmsEmlListVOList = dbDao.searchCstmsEmlList(inCstmsEmlListVO);
					if (cstmsEmlListVOList.size() > 0) {
						StringBuilder tmpToEmlTotal = new StringBuilder();
						StringBuilder tmpCcEmlTotal = new StringBuilder();
						for (CstmsEmlListVO outCstmsEmlListVO : cstmsEmlListVOList) {
							String tmpToEml = outCstmsEmlListVO.getToEmlCtnt().trim().replaceAll(" ", "");
							String tmpCcEml = outCstmsEmlListVO.getCcEmlCtnt().trim().replaceAll(" ", "");
							if (tmpToEml.length() > 0) tmpToEmlTotal.append(tmpToEml + ";");
							if (tmpCcEml.length() > 0) tmpCcEmlTotal.append(tmpCcEml + ";");
						}

						// 중복제거
						if (!"".equals(tmpToEmlTotal.toString())) {
							String[] toEmlAddrArray = StringUtils.removeDuplicateStrings(tmpToEmlTotal.toString().split(";"));
							toEmlAddr = StringUtils.arrayToDelimitedString(toEmlAddrArray, ";");
						}
						if (!"".equals(tmpCcEmlTotal.toString())) {
							String[] ccEmlAddrArray = StringUtils.removeDuplicateStrings(tmpCcEmlTotal.toString().split(";"));
							ccEmlAddr = StringUtils.arrayToDelimitedString(ccEmlAddrArray, ";");
						}

						if (!"".equals(toEmlAddr)) {
							// 받는사람
							sendMailVO.setRecipient(toEmlAddr);
							// 참조
							sendMailVO.setCcRcvrEml(ccEmlAddr);
							// 메일 전송
							eaiDao.sendMail(sendMailVO);
						}
					}
				}
			}
		} catch(DAOException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}
