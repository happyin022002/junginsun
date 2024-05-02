/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CustomsDeclarationSC.java
 *@FileTitle : ESM_BKG-0017
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.basic.ChinaCustomsReportBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.basic.ChinaCustomsReportBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.event.EsmBkg0152Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.event.EsmBkg1047Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.event.EsmBkg1048Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.vo.ChinaManifestListTransmitHistDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.vo.ChinaManifestSendDetailListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.china.vo.DelModeListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.basic.ChinaCustomsTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.basic.ChinaCustomsTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.event.EdiBkgChinaSysAckEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.event.EsmBkg0217Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.event.EsmBkg0219Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.event.EsmBkg1046Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.event.EsmBkg1070Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.event.OpusBkgTCncusAckEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoListVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaBlInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.ChinaManifestTransmitVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo.InboundTSGRPVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.event.EsmBkg0540Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.basic.ChinaManifestListDownloadBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.basic.ChinaManifestListDownloadBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.event.EsmBkg0216Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.event.EsmBkg1508Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.china.vo.ChinaManifestListDetailVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;


/**
 * OPUS-CustomsDeclarationChinaBusiness Logic ServiceCommand<br>
 * - OPUS-CustomsDeclarationChinahandling business transaction.
 *
 * @author KIM SEUNG MIN
 * @see
 * @since J2EE 1.4
 */
public class CustomsDeclarationChinaSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationChinasystem <br>
	 * ESM_BKG-0017<br>
	 */
	public void doStart() {
		log.debug("CustomsDeclarationChinaSC 시작");
		try {
			account = getSignOnUserAccount();
		} catch(Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * CustomsDeclarationChinasystem <br>
	 * ESM_BKG-0017 <br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationChinaSC 종료");
	}

	/**
	 *
	 * OPUS-CustomsDeclarationChinasystem <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		log.info("[SC.perform] Start ---------------------------");
		log.info("[SC.perform] e.getEventName() : " + e.getEventName());
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("EsmBkg0152Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDelMode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDelMode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				GeneralEventResponse response = new GeneralEventResponse();
				// TRANSIT CODE 콤보 Display
				response.setRsVoList(searchComCodeCombo("CD02260"));
				eventResponse = response;
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				// POD, DEL Validation Check
				eventResponse = searchLocation(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0216Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = downloadManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = backEndJobResult(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0217Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBlInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				// searching Container No. information
				eventResponse = searchContainer(e);
			} else {
				GeneralEventResponse response = new GeneralEventResponse();
				// Trans Mod Id combo
				response.setRsVoList(searchCodeCombo("CD02260"));
				// Seal Kind Cd combo
				response.setRsVoList(searchCodeCombo("CD02184"));
				// Sealer combo
				response.setRsVoList(searchCodeCombo("CD02183"));
				// Weight combo
				response.setRsVoList(searchCodeCombo("CD00775"));
				// Measure combo
				response.setRsVoList(searchCodeCombo("CD01116"));
				// TRANSMIT MESSAGE TYPE ID
				response.setRsVoList(searchHardCoding(e, "TRSM_MSG_TP_ID"));
				eventResponse = response;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0219Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInboundTSManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1046Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBlByVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBlByVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = downloadManifestList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = transmitManifest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = backEndJobResult(e);
			} else {
				GeneralEventResponse response = new GeneralEventResponse();
				// TRANSMIT MESSAGE TYPE ID
				response.setRsVoList(searchHardCoding(e, "TRSM_MSG_TP_ID"));
				eventResponse = response;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1047Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTransmitHist(e);
			}// else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
			// eventResponse = transmitManifestForRe(e);
			// }
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1048Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTransmitHist(e);
			}// else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
			// eventResponse = transmitManifestForRe(e);
			// }
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1070Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlByVvd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = transmitManifest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("OpusBkgTCncusAckEvent")) {
			eventResponse = loadCstmsRcvMsg(e);
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1508Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChinaVslRgst(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageChinaVslRgst(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EdiBkgChinaSysAckEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.TRANS)) {
				eventResponse = receiveEDISysAck(e);
			}
		}
		log.info("[SC.perform] End ---------------------------");
		return eventResponse;
	}

	/**
	 * ESM_BKG_0428 : INIT <br>
	 * ESM_BKG_0429 : INIT <br>
	 * ESM_BKG_0217 <br>
	 *  searching combo data<br>
	 *
	 * @param String comCode
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	private List<BkgComboVO> searchCodeCombo(String comCode) throws EventException {
		try {
			BookingUtil bkgUtil = new BookingUtil();
			List<BkgComboVO> list = bkgUtil.searchCombo(comCode);
			return list;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0217 :  <br>
	 * ESM_BKG_1046 :  <br>
	 * ESM_BKG_0494 :  <br>
	 * HardCoding Table searching<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private List<BkgHrdCdgCtntVO> searchHardCoding(Event e, String hrdCdgId) throws EventException {
		BookingUtil bkgUtil = new BookingUtil();
		BkgHrdCdgCtntListCondVO hrdCdgVO = new BkgHrdCdgCtntListCondVO();
		hrdCdgVO.setHrdCdgId(hrdCdgId);
		String transMode = null;
		String prefix = null;
		StringBuffer sb = new StringBuffer();
		BkgHrdCdgCtntVO tempVO = null;
		List<BkgHrdCdgCtntVO> bkgHrdCdgCtntVOs = null;
		try {
			if ("TRSM_MSG_TP_ID".equalsIgnoreCase(hrdCdgId)) {
				// 이벤트별 Where 조건 생성
				if (e.getEventName().equalsIgnoreCase("EsmBkg0217Event")) {
					EsmBkg0217Event event =(EsmBkg0217Event) e;
					transMode = event.getTransMode();
				} else if (e.getEventName().equalsIgnoreCase("EsmBkg1046Event")) {
					EsmBkg1046Event event =(EsmBkg1046Event) e;
					transMode = event.getTransMode();
				}
				if ("O".equals(transMode)) {
					prefix = "O1";
					hrdCdgVO.setAttrCtnt5(transMode);
				} else if ("D".equals(transMode)) {
					prefix = "O2";
					hrdCdgVO.setAttrCtnt4(transMode);
				} else if ("P".equals(transMode)) {
					prefix = "P1";
					hrdCdgVO.setAttrCtnt6(transMode);
				}
			}
			bkgHrdCdgCtntVOs = bkgUtil.searchHardCoding(hrdCdgVO);
			if ("TRSM_MSG_TP_ID".equalsIgnoreCase(hrdCdgId)) {
				for(int i = 0; i < bkgHrdCdgCtntVOs.size(); i++) {
					tempVO =(BkgHrdCdgCtntVO) bkgHrdCdgCtntVOs.get(i).clone();
					if (sb.length() > 0) {
						sb.delete(0, sb.length());
					}
					sb.append(prefix).append(":");
					sb.append(tempVO.getAttrCtnt2());
					bkgHrdCdgCtntVOs.get(i).setAttrCtnt2(sb.toString());
				}
			}
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return bkgHrdCdgCtntVOs;
	}

	/**
	 * ESM_BKG_0152 : INIT <br>
	 * com_intg_cd_dtl Table searching<br>
	 *
	 * @param String comCode
	 * @return List<BkgComboVO>
	 * @exception EventException
	 */
	private List<BkgComboVO> searchComCodeCombo(String comCode) throws EventException {
		BookingUtil bkgUtil = new BookingUtil();
		List<BkgComboVO> list = bkgUtil.searchCombo(comCode);
		try {
			for(int j=0; j<list.size(); j++) {
				// 콤보 Text에 value + Name으로 보여주는 경우 사용
				list.get(j).setDesc(list.get(j).getVal() + " " + list.get(j).getName());
			}
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return list;
	}

	/**
	 * ESM_BKG_0216 : SEARCH <br>
	 *  searching Manifest List.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestList(Event e) throws EventException {
		ChinaManifestListDownloadBC command = new ChinaManifestListDownloadBCImpl();;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0216Event event =(EsmBkg0216Event) e;
		try {
			List<ManifestListDetailVO> list = command.searchManifestList(event.getManifestListCondVO());
			ChinaManifestListDetailVO detailVO = (ChinaManifestListDetailVO) list.get(0);
			list.remove(0);
			eventResponse.setRsVoList(list);
			if (detailVO != null) {
				eventResponse.setETCData(detailVO.getColumnValues());
			} else {
				throw new EventException(new ErrorHandler("BKG00889").getMessage());
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0462 : SEARCH <br>
	 * searching manifest information(Download data).<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse downloadManifestList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg0216Event")) {
				EsmBkg0216Event event =(EsmBkg0216Event) e;
				ChinaManifestListDownloadBC command = new ChinaManifestListDownloadBCImpl();
				String down_csv = command.downloadManifestList(event.getManifestListCondVO());
				eventResponse.setETCData("down_csv", down_csv);

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1046Event")) {
				EsmBkg1046Event event =(EsmBkg1046Event) e;
				ChinaCustomsTransmissionBC command = new ChinaCustomsTransmissionBCImpl();
				String down_csv = command.downloadManifestList(event.getVvdKeyVO());
				eventResponse.setETCData("down_csv", down_csv);
			}
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0216 : MULTI <br>
	 * Manifests to Customs to store items required to report operations<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChinaManifestListDownloadBC command = null;
		try {
			begin();
			EsmBkg0216Event event =(EsmBkg0216Event) e;
			command = new ChinaManifestListDownloadBCImpl();
			String key = command.manageManifest(event.getManifestListDetailVOs(), account);
			eventResponse.setETCData("KEY", key);
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * BackEndJob 실행 후 결과코드 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String sKey = "";
		if (e.getEventName().equalsIgnoreCase("EsmBkg0216Event")) {
			EsmBkg0216Event event =(EsmBkg0216Event) e;
			sKey = event.getKey();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1046Event")) {
			EsmBkg1046Event event =(EsmBkg1046Event) e;
			sKey = event.getKey();
		}
		String strResult = "";
		try {
			BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(sKey);
			DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
			while(rowSet.next()) {
				if ("2".equals(rowSet.getString("JB_STS_FLG"))) {
					// BackEndJob 처리중
					strResult = "PROCESSING";
				} else if ("3".equals(rowSet.getString("JB_STS_FLG"))) {
					// 성공메시지세팅
					if (e.getEventName().equalsIgnoreCase("EsmBkg1046Event")) {
						// Data Transmitted successufully!
						eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
					}
					strResult = "SUCCESS";
				} else if ("4".equals(rowSet.getString("JB_STS_FLG"))) {
					// 에러메시지세팅
					if (e.getEventName().equalsIgnoreCase("EsmBkg1046Event")) {
						if (!"".equals(rowSet.getString("JB_USR_ERR_MSG"))) {
							StringTokenizer st = new StringTokenizer(rowSet.getString("JB_USR_ERR_MSG"), "<||>");
							st.nextToken();
							st.nextToken();
							st.nextToken();
							String strErrMsg = st.nextToken();
							eventResponse.setUserMessage(strErrMsg);
						} else {
							eventResponse.setUserMessage(new ErrorHandler("BKG00205").getUserMessage());
						}
					}
					strResult = "FAIL";
				}
			}
			eventResponse.setETCData("jb_sts_flg", strResult);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0217 : SEARCH <br>
	 * searching(Discharging Cargo Declaration) information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChinaCustomsTransmissionBC command = new ChinaCustomsTransmissionBCImpl();
		EsmBkg0217Event event =(EsmBkg0217Event) e;
		try {
			ChinaBlInfoVO chinaBlInfoVO = command.searchBlInfo(event.getChinaBlInfoCondVO());
			if (chinaBlInfoVO.getChinaBlGeneralListVO() != null)
				eventResponse.setETCData(chinaBlInfoVO.getChinaBlGeneralListVO().getColumnValues());
			if (chinaBlInfoVO.getChinaBlCustListVO() != null)
				eventResponse.setETCData(chinaBlInfoVO.getChinaBlCustListVO().getColumnValues());
			eventResponse.setRsVoList(chinaBlInfoVO.getChinaBlCntrListVOs());
			eventResponse.setRsVoList(chinaBlInfoVO.getChinaBlDangerCntrListVOs());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0217 : SEARCH<br>
	 * DG Cargo Manifest List searching<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBlInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			ChinaManifestListDownloadBC command = new ChinaManifestListDownloadBCImpl();
			// 이벤트별 Impl생성
			EsmBkg0217Event event =(EsmBkg0217Event) e;
			// 등록, 수정, 삭제
			command.manageBlInfo(event.getChinaBlInfoVO(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1046 : SEARCH <br>
	 * ESM_BKG_0217 : SEARCH <br>
	 * ESM_BKG_0218 : SEARCH <br>
	 * modifying DG Cargo Manifest information <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitManifest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChinaCustomsTransmissionBC command = new ChinaCustomsTransmissionBCImpl();
		String flatFile = "";
		Map<String, String> etcData = new HashMap<String, String>();
		try {
			begin();
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg1046Event")) {
				// 중국 EDI FLAT FILE 생성 및 전송
				EsmBkg1046Event event =(EsmBkg1046Event) e;
				String key = command.transmitManifest(event.getChinaManifestTransmitVO(), account);
				eventResponse.setETCData("KEY", key);

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0217Event")) {
				// 중국 EDI FLAT FILE 생성 및 전송
				EsmBkg0217Event event =(EsmBkg0217Event) e;
				// BC에 작업 요청
				flatFile = command.transmitManifest(event.getChinaManifestTransmitVO(), account);
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218").getUserMessage());

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1070Event")) {
				// 중국 EDI FLAT FILE 생성 및 전송
				EsmBkg1070Event event =(EsmBkg1070Event) e;
				// BC에 작업 요청
				ChinaManifestTransmitVO transmitVO = event.getChinaManifestTransmitVO();
				flatFile = command.transmitTmlManifest(transmitVO, account);
				// BKG_NTC_HS 로그 저장
				BookingHistoryMgtBC command2 = new BookingHistoryMgtBCImpl();
				command2.createBkgNtcHis(transmitVO.getBkgNtcHisVOs(), transmitVO.getEdiRefId());
				eventResponse.setETCData("flatFile", flatFile);
				eventResponse.setETCData(etcData);
				eventResponse.setUserMessage(new ErrorHandler("BKG00218").getUserMessage());
			}
			commit();
		} catch(EventException ex) {
			log.error("EventException : " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch(Exception ex) {
			log.error("Exception : " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("BKG06088").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0730 : MULTI01 <br>
	 * ESM_BKG_0991 : MULTI <br>
	 * transmitting by EDI<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainer(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0217Event event =(EsmBkg0217Event) e;
			ChinaCustomsTransmissionBC command2 = new ChinaCustomsTransmissionBCImpl();
			String cntrTpszCd = command2.searchContainerType(event.getContainerCondVO());
			if (cntrTpszCd == null) {
				eventResponse.setETCData("cntr_no", "");
			} else {
				String[] cntrData = cntrTpszCd.split("\t");
				eventResponse.setETCData("cntr_no", cntrData[0]);
				eventResponse.setETCData("cntr_tpsz_cd", cntrData[1]);
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0219 : SEARCH <br>
	 * Vessel Stowage Plan Transmit 화면을 조회.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInboundTSManifest(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0219Event event =(EsmBkg0219Event) e;
		ChinaCustomsTransmissionBC command = new ChinaCustomsTransmissionBCImpl();
		try {
			InboundTSGRPVO inboundTSGRPVO = command.searchInboundTSManifest(event.getInboundTSInfoBLVO());
			// 순서에 주의
			if (inboundTSGRPVO.getInboundTSCustVO() != null)
				eventResponse.setETCData(inboundTSGRPVO.getInboundTSCustVO().getColumnValues());
			if (inboundTSGRPVO.getInboundTSInfoSKDVO() != null)
				eventResponse.setETCData(inboundTSGRPVO.getInboundTSInfoSKDVO().getColumnValues());
			if (inboundTSGRPVO.getInboundTSInfoBLVO() != null)
				eventResponse.setETCData(inboundTSGRPVO.getInboundTSInfoBLVO().getColumnValues());
			eventResponse.setRsVoList(inboundTSGRPVO.getInboundTSCntrVOList());
			eventResponse.setRsVoList(inboundTSGRPVO.getInboundTSDownExcelVOList());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1046 : SEARCH <br>
	 * ESM_BKG_1070 : SEARCH <br>
	 * searching Vessel Stowage Plan Transmit.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlByVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ChinaCustomsTransmissionBC command = new ChinaCustomsTransmissionBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// 이벤트별 Impl 생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg1046Event")) {
				EsmBkg1046Event event =(EsmBkg1046Event) e;
				List<ChinaBlInfoListVO> list = command.searchBlByVvd(event.getVvdKeyVO());
				eventResponse.setETCData(list.get(0).getColumnValues());
				list.remove(0);
				eventResponse.setRsVoList(list);

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1070Event")) {
				EsmBkg1070Event event =(EsmBkg1070Event) e;
				List<ChinaBlInfoListVO> list = command.searchBlByVvd(event.getVvdKeyVO());
				eventResponse.setETCData(list.get(0).getColumnValues());
				list.remove(0);
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1046 : MULTI <br>
	 *(Customer, Container)  deleting BL information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBlByVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ChinaManifestListDownloadBC command = new ChinaManifestListDownloadBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1046Event event =(EsmBkg1046Event) e;
		try {
			begin();
			command.manageBlByVvd(event.getChinaBlInfoListVOs());
			// 성공 메시지 셋팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00593").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0466 : MULTI <br>
	 * transmitting DOR <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse loadCstmsRcvMsg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChinaCustomsTransmissionBC command = new ChinaCustomsTransmissionBCImpl();
		try {
			begin();
			OpusBkgTCncusAckEvent event =(OpusBkgTCncusAckEvent) e;
			command = new ChinaCustomsTransmissionBCImpl();
			command.loadCstmsRcvMsg(event.getFlatFile());
			commit();
		} catch(EventException ex) {
			log.error("EventException : " + ex.getMessage());
			rollback();
			throw ex;
		} catch(Exception ex) {
			log.error("Exception : " + ex.getMessage());
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		log.info("SC [loadCstmsRcvMsg] End---------------------");
		return eventResponse;
	}

	/**
	 * ESM_BKG_0152 : SEARCH <br>
	 * searching<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDelMode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChinaCustomsReportBC command = null;
		List<DelModeListVO> list = null;
		try {
			// 이벤트별 Impl생성
			EsmBkg0152Event event =(EsmBkg0152Event) e;
			command = new ChinaCustomsReportBCImpl();
			list = command.searchDelMode(event.getBkgCstmsChnDeModCondVO());
			// eventResponse.setETCData("result", result);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0152 : MULTI <br>
	 * managing mode of China DEL<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDelMode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChinaCustomsReportBC command = null;
		try {
			// 이벤트별 Impl생성
			this.begin();
			EsmBkg0152Event event =(EsmBkg0152Event) e;
			command = new ChinaCustomsReportBCImpl();
			command.manageDelMode(event.getBkgCstmsChnDeModDetailVOs(), account);
			// 성공 메시지 셋팅
			// eventResponse.setUserMessage(new
			// ErrorHandler("BKG00101").getUserMessage());
			this.commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0152<br>
	 * checking China custom POD, DEL Validation.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChinaCustomsReportBC command = null;
		try {
			// 이벤트별 Impl생성
			if ("EsmBkg0152Event".equalsIgnoreCase(e.getEventName())) {
				EsmBkg0152Event event =(EsmBkg0152Event) e;
				command = new ChinaCustomsReportBCImpl();
				String locCd = command.searchLocation(event.getSearchLocationVO());
				if (locCd != null) {
					eventResponse.setETCData("locCd", locCd);
				}
				// 성공 메시지 셋팅
				// eventResponse.setUserMessage(new
				// ErrorHandler("BKG00101").getUserMessage());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0540Event")) {
				EsmBkg0540Event event =(EsmBkg0540Event) e;
				BookingUtil bkgUtil = new BookingUtil();
				String locNm = bkgUtil.searchMdmLocName(event.getStrLocCd());
				if (!"".equals(locNm)) {
					eventResponse.setETCData("result", locNm);
				}
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1046 : SEARCH, SEARCH01 <br>
	 * ESM_BKG_1048 : SEARCH <br>
	 *(Customer, Container) searching BL information<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchTransmitHist(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		ChinaCustomsReportBC command = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("EsmBkg1047Event")) {
				EsmBkg1047Event event =(EsmBkg1047Event) e;
				command = new ChinaCustomsReportBCImpl();
				List<ChinaManifestListTransmitHistDetailVO> chinaManifestListTransmitHistDetailVOs =(List<ChinaManifestListTransmitHistDetailVO>) (Object) (command.searchTransmitHist((TransmitHistCondVO) event.getChinaTransmitHistCondVO()));
				if (chinaManifestListTransmitHistDetailVOs.size() < 1) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
				} else {
					chinaManifestListTransmitHistDetailVOs.get(0).setMaxRows(Integer.parseInt(chinaManifestListTransmitHistDetailVOs.get(0).getTotal()));
				}
				eventResponse.setRsVoList(chinaManifestListTransmitHistDetailVOs);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1048Event")) {
				EsmBkg1048Event event =(EsmBkg1048Event) e;
				command = new ChinaCustomsReportBCImpl();
				List<ChinaManifestSendDetailListVO> chinaManifestSendDetailListVOs =
				//(List<ChinaManifestSendDetailListVO>) (Object) (command.searchChinaSendDetailList((TransmitHistCondVO) event.getChinaTransmitHistCondVO()));
				(List<ChinaManifestSendDetailListVO>) (Object) (command.searchChinaSendDetailList(event.getEdiRefId(), event.getPodCd()));
				if (chinaManifestSendDetailListVOs.size() < 1) {
					eventResponse.setUserMessage(new ErrorHandler("BKG00889").getUserMessage());
				} else {
					// chinaManifestSendDetailListVOs.get(0).setMaxRows(Integer.parseInt(chinaManifestSendDetailListVOs.get(0).getTotal()));
				}
				eventResponse.setRsVoList(chinaManifestSendDetailListVOs);
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * CHINA 24HR : [ESM_BKG_1508] Retrive<br>
	 * Vessel Registration 목록 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChinaVslRgst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1508Event event =(EsmBkg1508Event) e;
		ChinaManifestListDownloadBC command = new ChinaManifestListDownloadBCImpl();
		try {
			eventResponse.setRsVoList(command.searchChinaVslRgst(event.getChinaVslRgstVO()));
		} catch(EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * CHINA 24HR : [ESM_BKG_1508] Save<br>
	 * Vessel Registration 목록 저장
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageChinaVslRgst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1508Event event =(EsmBkg1508Event) e;
		ChinaManifestListDownloadBC command = new ChinaManifestListDownloadBCImpl();
		try {
			begin();
			command.manageChinaVslRgst(event.getChinaVslRgstVO(), event.getChinaVslRgstVOs(), account);
			commit();
		} catch(EventException ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			log.error("\n\n[Err] " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EDI_T_BKG_T_CNCUS_SYS_ACK]
	 *  China SYS ACK 메세지 수신
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receiveEDISysAck(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChinaCustomsTransmissionBC command = new ChinaCustomsTransmissionBCImpl();
		EdiBkgChinaSysAckEvent event = (EdiBkgChinaSysAckEvent) e;

		try {
			begin();
			command.receiveEDISysAck(event.getFlatFile());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}


}//end class
