/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomsTransmissionBCImpl.java
*@FileTitle : UI_BKG-0017
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier :
*@LastVersion : 1.0
* 2009.05.25 
* 1.0 Creation
* 
* 2011.07.06 민정호 [CHM-201111866] US AMS : AMS Report 의 general의 조회 기능 보완
* 2011.07.15 민정호 [CHM-201111822] Split 05-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
* 2011.08.08 민정호 [CHM-201111822] Split 05-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치 건
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.basic;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.integration.UsaCustomsReportDBDAO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.AmsRailCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.BaplieMonitorCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.ContainerDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.DispoCdDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.MiTransmitHistoryCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.RailHistoryDetailListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.RailHistoryListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.RcvHistListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.ReceivedFileCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.ScacReportCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.TransmissionChkListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaAmsReportListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaCheckListDetailListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaTransmitHistFileCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaVesselArrivalCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.usa.vo.UsaVesselArrivalDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.AmsRailListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.AmsReportListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.AmsReportListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.CheckListDetailListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.RcvHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.RcvHistDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ReceiveLogCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ReceiveLogDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.ScacReportDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistFileCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistFileDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistListDetailVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.syscommon.common.table.MdmLocationVO;

/**
 * ALPS-CustomsReport Business Logic Basic Command implementation<br>
 * - ALPS-CustomsReport에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author charves
 * @see UI_BKG-0215EventResponse,CustomsReportBC 각 DAO클래스 참조
 * @since J2EE 1.6
 */
public class UsaCustomsReportBCImpl extends BasicCommandSupport implements UsaCustomsReportBC {
	private transient UsaCustomsReportDBDAO dbDao = null;
	
	public UsaCustomsReportBCImpl(){
		dbDao = new UsaCustomsReportDBDAO();
	}
	
	/**
	 * Scac Report를 조회한다.
	 * @param ScacReportCondVO scacReportCondVO
	 * @return List<ScacReportDetailVO>
	 * @exception EventException
	 */
	public List<ScacReportDetailVO> searchScacReportByVvdPod (ScacReportCondVO scacReportCondVO)	throws EventException
	{
		try
		{
			return dbDao.searchScacReport(scacReportCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Ams Pod를 조회한다.
	 * @param String code
	 * @return String
	 * @exception EventException
	 */
	public String searchCodeConversion (String code)	throws EventException
	{
		try
		{
			return dbDao.searchAmsPodCdByLocCd(code);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * MI Transaction History for IE를 조회한다.
	 * @param AmsReportListCondVO amsReportListCondVO
	 * @return List<AmsReportListDetailVO>
	 * @exception EventException
	 */
	public List<AmsReportListDetailVO> searchAmsReportList(AmsReportListCondVO amsReportListCondVO) throws EventException{
		try{
			String pgmNo = amsReportListCondVO.getPgmNo();
			List<AmsReportListDetailVO> list = null;
			//Ams Report 화면에서 호출되었을 경우.
			if(pgmNo.equals("ESM_BKG_0041") || pgmNo.equals("ESM_BKG_0041_2")) {
				UsaAmsReportListCondVO vo = (UsaAmsReportListCondVO)amsReportListCondVO;
				if ("ISF5".equals(vo.getGeneralOrRail())){
					return dbDao.searchAmsReportListbyDate(vo);
				} else if("GENERAL".equals(vo.getGeneralOrRail()) || "RAILAMS".equals(vo.getGeneralOrRail())) {
					/***********************************************************
					 * Customs Result Code 또는 그룹코드가 있을때는 D로 세팅<br>
					 * C 와 D의 차이는 외부조인이냐 아니냐의 차이
					 ***********************************************************/
					vo.setTmp1("C");
					if(!"".equals(vo.getCustomsResultCode()) || 
							(!"".equals(vo.getCustomsResultCodeGrp()) && !"ALL".equals(vo.getCustomsResultCodeGrp()))){
						vo.setTmp1("D");
					}else{
						// 날자중 Customs Reply로 조회하는 경우는 "D"타입으로 조회한다.
						if (!"".equals(vo.getDateSearch()) && "RCV".equals(vo.getCustArrExp())){
							vo.setTmp1("D");
						}
					}
	//				if(!"".equals(vo.getCustomsResultCode())){
	//					String dspoCd = vo.getCustomsResultCode();
	//					if ("1A,1B,1G,1F,1H,1I,2G,2F,2H,2I,3G,3F,3H,3I,5H,5I,6H,6I,71,72,73,74,75,76,77,78,79,80,81,82,7H,7I".indexOf(dspoCd) >= 0){
	//						vo.setTmp1("S");
	//					}else if ("1M,1N,10,2Z".indexOf(dspoCd) >= 0){
	//						vo.setTmp1("D");
	//					}else if ("1R,4A".indexOf(dspoCd) >= 0){
	//						vo.setTmp1("R");
	//					}else if ("1S".indexOf(dspoCd) >= 0){
	//						vo.setTmp1("S");
	//					}else{
	//						vo.setTmp1("D");
	//					}
	//					//위의 조건과 중복되는 항목이 있으나, 전달받은  "조회.조건세팅.TXT"파일의 로직 시퀀스를 그대로 구현함.
	//					//아래 1O는 숫자 10과 구분됨. 위의 10은 숫자임. 둘중 하나가 잘못 된 듯 하나,1O(영문)이 좀더 신빙성이 있으므로 그대로 놓아둠.  
	//					if ("1K,1L,53".indexOf(dspoCd) >= 0)
	//					{
	//						vo.setTmp1("W");
	//					}else if ("1M,1N,1O".indexOf(dspoCd) >= 0){
	//						vo.setTmp1("Q");
	//					}else if ("18".equals(dspoCd)){
	//						vo.setTmp1("M");
	//					}
	//				}else if (!"".equals(vo.getCustomsResultCodeGrp()) && !"ALL".equals(vo.getCustomsResultCodeGrp())){
	//					vo.setTmp1("D");
	//				}
					//Filer 조건 설정.
					String filer = vo.getFiler();
					StringBuffer sfFiler = new StringBuffer();
					if (!"".equals(filer) && filer.indexOf("All") < 0){
						String[] arrFiler = filer.split(",");
						for (int i = 0; i < arrFiler.length; i++){
							if ("01".equals(arrFiler[i])){
								sfFiler.append(" (A.CSTMS_FILE_TP_CD = '1' AND A.MF_NO IS NULL) ");
								if (i < arrFiler.length - 1){
									sfFiler.append(" OR ");
								}
							}else if ("02".equals(arrFiler[i])){
								sfFiler.append(" A.CSTMS_FILE_TP_CD = '2' ");
								if (i < arrFiler.length - 1){
									sfFiler.append(" OR ");
								}
							}else if ("03".equals(arrFiler[i])){
								sfFiler.append(" A.CSTMS_FILE_TP_CD = '3' ");
								if (i < arrFiler.length - 1){
									sfFiler.append(" OR ");
								}
							}else if ("00".equals(arrFiler[i])){
								sfFiler.append(" (A.CSTMS_FILE_TP_CD = '0' OR (A.CSTMS_FILE_TP_CD = '1' AND A.MF_NO IS NOT NULL) ) ");
								if (i < arrFiler.length - 1){
									sfFiler.append(" OR ");
								}
							}
						}
					}
					filer = sfFiler.toString();
					vo.setFiler(filer);
					// 조회실행.
					list = dbDao.searchAmsReportListbyDate(vo);
				} else {
					// 조회실행.
					list = dbDao.searchAmsReportListbyDate(vo);
				}
			}else{
				// 0819 화면.
				list = dbDao.searchMiTransmitHistoryForIE((MiTransmitHistoryCondVO) amsReportListCondVO);
			}
			return list;
		}catch (DAOException ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}catch (Exception ex){
			throw new EventException(new ErrorHandler("BKG06086", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 세관에 EDI를 통해 적하목록 신고 후 세관으로부터 수신한 메시지 목록을 조회한다.
	 * @param RcvHistCondVO rcvHistCondVO
	 * @return List<RcvHistDetailVO>
	 * @exception EventException
	 */
	public List<RcvHistDetailVO> searchReceiveHist(RcvHistCondVO rcvHistCondVO) throws EventException{
		try {
			return dbDao.searchReceivedHistoryList((RcvHistListCondVO)rcvHistCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}	
	}

	/**
	 * 세관에 EDI를 통해 적하목록 신고 후 세관으로부터 수신한 메시지 내역을 조회한다.
	 * @param ReceiveLogCondVO receiveLogCondVO
	 * @return List<ReceiveLogDetailVO>
	 * @exception EventException
	 */
	public List<ReceiveLogDetailVO> searchReceiveLog(ReceiveLogCondVO receiveLogCondVO) throws EventException{
		try
		{
			return dbDao.searchReceivedFile((ReceivedFileCondVO)receiveLogCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 세관에 EDI를 통해 적하목록 신고 후 신고 내역을 조회한다.
	 * @param TransmitHistListCondVO transmitHistListCondVO
	 * @return List<TransmitHistListDetailVO>
	 * @exception EventException
	 */
	public List<TransmitHistListDetailVO> searchTransmitHistList( TransmitHistListCondVO transmitHistListCondVO ) throws EventException {
		try {
			return dbDao.searchTransmitHistoryList(transmitHistListCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 세관에 EDI를 통해 적하목록 신고 후 전송한 메세지 내역을 조회한다.
	 * @param TransmitHistFileCondVO transmitHistFileCondVO
	 * @return List<TransmitHistFileDetailVO>
	 * @exception EventException
	 */
	public List<TransmitHistFileDetailVO> searchTransmitHistFile( TransmitHistFileCondVO transmitHistFileCondVO ) throws EventException {
		try {
			List<TransmitHistFileDetailVO> list = dbDao.searchTransmitHistoryFile(transmitHistFileCondVO);

			UsaTransmitHistFileCondVO condVo = (UsaTransmitHistFileCondVO) transmitHistFileCondVO;

			if(condVo.getOfmFlg().equals("Y")) {
				String filePath = null;
				if(list.size() > 0){
					filePath = generateCsv(list);
					list.get(0).setFilePath(filePath);
				}
			}
			
			return list;
			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
	}
		

	/**
	 * 객체를 txt 파일로 변환하고 파일명을 반환한다.
	 * @param List vos ValueObject 리스트를 담은 객체 
	 * @return String Excel 저장한 파일명
	 */
	@SuppressWarnings("unchecked")
	public String generateCsv(List vos) throws EventException {
//		String date = DateTime.getFormatDate(new Date(), "yyyyMMdd") + DateTime.getShortTimeString();
//		String fileName = "/tmp/" + "Transmission History Sent File_" + date + ".txt";
//		File f = new File(fileName);
//		BufferedOutputStream bo = null;
//		try{
//			bo = new BufferedOutputStream(new FileOutputStream(f));
//			StringBuffer body = new StringBuffer();
//			
//			UsaTransmitHistFileDetailVO vo = null;
//			
//			// BODY 생성
//			for ( int i=0; i<vos.size(); i++ ){
//				vo = (UsaTransmitHistFileDetailVO)vos.get(i);
//				body.append(vo.getLogCtnt()).append("\r\n"); 
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
		return "";
	}

	/**
	 * 컨테이너 넘버로 B/L내역을 조회
	 * @param String cntrNo
	 * @param String vvd
	 * @param String blType	
	 * @return List<ContainerDetailVO>
	 * @exception EventException
	 */
	public List<ContainerDetailVO> searchBlListByCntr(String cntrNo, String vvd, String blType) throws EventException {
		try {
			return dbDao.searchBlListByCntrNo(cntrNo, vvd, blType);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 0359 Manifest Status 와 B/L to be delete 내역을 조회한다.
	 * @param TransmissionChkListCondVO  transmissionChkListCondVO
	 * @return List<CheckListDetailListVO>
	 * @exception EventException
	 */
	public List<CheckListDetailListVO> searchTransmissionCheckList(TransmissionChkListCondVO  transmissionChkListCondVO) throws EventException{
		try
		{
			List<UsaCheckListDetailListVO> manifestStatusList = dbDao.searchTransmissionCheckListByVVD(transmissionChkListCondVO);
			List<UsaCheckListDetailListVO> tobeDeletedList = dbDao.searchToBeDeletedList(transmissionChkListCondVO);
			
			List<CheckListDetailListVO> list = new ArrayList<CheckListDetailListVO>();
			CheckListDetailListVO item = new CheckListDetailListVO();
			item.setManifestStatusResultList(manifestStatusList);
			item.setBlToBeDeletedResultList(tobeDeletedList);
			list.add(item);
			
			return list;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 0359에서 VVD, POL 입력후 Focus out할시 ETA를 조회한다.
	 * @param UsaVesselArrivalCondVO  usaVesselArrivalCondVO
	 * @return List<UsaVesselArrivalDetailVO>
	 * @exception EventException
	 */
	public List<UsaVesselArrivalDetailVO> searchVesselArrival(UsaVesselArrivalCondVO  usaVesselArrivalCondVO) throws EventException{
		try
		{
			return dbDao.searchVesselEta(usaVesselArrivalCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * Mail : Disposition 코드 리스트를 조회한다. 
	 * @return List<DispoCdDetailVO>
	 * @exception EventException
	 */
	public List<DispoCdDetailVO> searchDispositionCdList() throws EventException{
		try
		{
			return dbDao.searchUsaDespositionCdList();
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
	}
	

	/**
	 * Mail : US AMS : Rail AMS History를 조회한다.
	 * @param AmsRailCondVO amsRailCondVO
	 * @return List<AmsRailListVO>
	 * @exception EventException
	 */
	public List<AmsRailListVO> searchAmsRailHistoryList(AmsRailCondVO amsRailCondVO) throws EventException{
		try{
			List<AmsRailListVO> returnList = new ArrayList<AmsRailListVO>();
			AmsRailListVO resultVo = new AmsRailListVO();
			
			RailHistoryListCondVO vo = new RailHistoryListCondVO();
			vo.setCntrNo(amsRailCondVO.getCntrNo());
			vo.setVvd(amsRailCondVO.getVvd());
			String blNo = amsRailCondVO.getBlNo();
			
			// bl_no조건이 들어온 경우는 BL리스트를 구하지 않고, 
			// 들어오지 않은 경우는 리스트를 구한 후, 가장 첫 BL에 대해 조회를 실행한다.
			if(blNo != null && !"".equals(blNo)){
				vo.setBlNo(blNo);
			}else{
				List<RailHistoryDetailListVO> blList = dbDao.searchBlListByCntr(vo);
				resultVo.setBlList(blList);
				if(blList != null && blList.size() > 0){
					vo.setBlNo((blList.get(0)).getBlNo());
				}
			}
			// bl_no가 있는 경우에 아래 조회 실행.
			blNo = vo.getBlNo();
			if(blNo != null && !"".equals(blNo)){
				// 헤더 정보 조회.
				List<RailHistoryDetailListVO> header = dbDao.searchRailHistoryHeader(vo);
				if(header != null && header.size() > 0){
					resultVo.setHeader(header.get(0));
				}
				// 상세 리스트 조회.
				List<RailHistoryDetailListVO> detailList = dbDao.searchRailHistoryListByCntr(vo);
				resultVo.setDetailList(detailList);
			}
			returnList.add(resultVo);
			return returnList;
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
	}

	/**
	 * 미국 현재 날짜 가져오기<br>
	 * @return String
	 * @exception EventException
	 */
	public String searchLocalSysdate() throws EventException{
		try{
			return dbDao.searchUsaSysdate();
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} 
	}
	
	/**
	 * 미세관 VVD별 BAPLIE Manifest (Vessel Stowage Plan) 전송 현황 report 조회
	 * @param BaplieMonitorCondVO  baplieMonitorCondVO
	 * @return List<BaplieMonitorCondVO>
	 * @exception EventException
	 */
	public List<BaplieMonitorCondVO> searchBaplieMonitor(BaplieMonitorCondVO  baplieMonitorCondVO) throws EventException{
		try	{
			return dbDao.searchBaplieMonitor(baplieMonitorCondVO);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * 미세관 VVD별 BAPLIE Manifest (Vessel Stowage Plan) 전송 현황 report 조회
	 * @param String vvd
	 * @return String crrCd
	 * @exception EventException
	 */
	public List<BaplieMonitorCondVO> searchUsLastForeignPort(String vvd) throws EventException{
		try	{
			return dbDao.searchUsLastForeignPort(vvd);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * EQ Control OFC Cd 코드 리스트를 조회한다.
	 * @return List<MdmLocationVO>
	 * @exception EventException
	 */
	public List<MdmLocationVO> searchEQCtrlOfcCdList() throws EventException{
		try
		{
			return dbDao.searchEQCtrlOfcCdList();
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06086",new String[]{}).getMessage(), ex);
		}
	}
}
