/*=========================================================
 *Copyright(c) 2013 CyberLogitec
 *@FileName : CustomsDeclarationJapanTerminalSC.java
 *@FileTitle : CustomsDeclarationJapanTerminalSC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2013.10.18
 *@LastModifier :
 *@LastVersion : 1.0
 * 2013.10.18
 * 1.0 Creation
=======================================================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration;

import java.util.List;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.basic.JapanTerminalTransmissionBC;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.basic.JapanTerminalTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.event.EsmBkg0479Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.event.EsmBkg0480Event;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.event.JapanOpusBkgNaccsReplyEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgJapanTerminalEdiVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.BkgTerminalEdiJapanBlVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.JapanTerminalEdiCheckRsltVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.JapanTerminalEdiGroupVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.japanterminal.vo.VvdJapanTerminalEdiVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * OPUS-CustomsDeclarationJapanTerminal Business Logic ServiceCommand<br>
 * - OPUS-CustomsDeclarationJapanTerminal에 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author KIM, Sang-Soo
 * @see
 * @since J2EE 1.6
 */
public class CustomsDeclarationJapanTerminalSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * CustomsDeclarationJapanTerminal system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("CustomsDeclarationJapanTerminalSC 시작");

		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch(Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * CustomsDeclarationJapanTerminal system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("CustomsDeclarationJapanTerminalSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * OPUS-CustomsDeclarationJapanTerminal system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("JapanOpusBkgNaccsReplyEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = receiveJapanTerminalOpusBkgNaccs(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0479Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTerminalEdi(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageTerminalEdi(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = transmitTerminalEdi(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0480Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTerminalEdi(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTerminalEdi(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = transmitTerminalEdi(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageTerminalEdi(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = transmitTerminalEdi(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("JapanOpusBkgNaccsReplyEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = receiveJapanTerminalOpusBkgNaccs(e);
			}
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0479 : SEARCH, SEARCH01
	 * ESM_BKG_0480 : SEARCH, SEARCH01
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTerminalEdi(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanTerminalTransmissionBC command = null;

		try {
			// 이벤트별 Impl 생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0479Event")) {
				EsmBkg0479Event event =(EsmBkg0479Event) e;
				command = new JapanTerminalTransmissionBCImpl();
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					List<VvdJapanTerminalEdiVO> list = null;
					list = command.searchVesselListForSchedule(event.getJapanTerminalEdiCondVO(), account);
					eventResponse.setRsVoList(list);
				}
				if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					List<VvdJapanTerminalEdiVO> list1 = null;
					list1 = command.searchVesselListForBKGRoute(event.getJapanTerminalEdiCondVO());
					eventResponse.setRsVoList(list1);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0480Event")) {
				EsmBkg0480Event event =(EsmBkg0480Event) e;
				command = new JapanTerminalTransmissionBCImpl();
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					List<BkgJapanTerminalEdiVO> list = command.searchBkgInfoForSchedule(event.getJapanTerminalEdiCondVO(), account);
					eventResponse.setRsVoList(list);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					List<BkgJapanTerminalEdiVO> list = command.searchPartialBkgInfoForSchedule(event.getJapanTerminalEdiCondVO());
					eventResponse.setRsVoList(list);
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
	 * ESM_BKG_0479 : SAVE <br>
	 * [CHM-201216099] Sea-NACCS 프로젝트 SAVE
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTerminalEdi(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanTerminalTransmissionBC command = new JapanTerminalTransmissionBCImpl();

		try {
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0479Event")) {
				EsmBkg0479Event event =(EsmBkg0479Event) e;
				JapanTerminalEdiCheckRsltVO japanTerminalEdiCheckRsltVO = command.manageTerminalEdi(event.getVvdJapanTerminalEdiVOS(), account);
				eventResponse.setETCData("resultStr", japanTerminalEdiCheckRsltVO.getResultStr());
				eventResponse.setETCData("flg", japanTerminalEdiCheckRsltVO.getFlg());
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0480Event")) {
				EsmBkg0480Event event =(EsmBkg0480Event) e;
				command.managePartialBkgInfoForSchedule(event.getBkgJapanTerminalEdiVOS(), account);
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			}
			commit();
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0479 / ESM_BKG_0480 : Transmit to NACCS - MULTI01 <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitTerminalEdi(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanTerminalTransmissionBC command = new JapanTerminalTransmissionBCImpl();
		String chk_flg = "";
		int logno = 0;

		try {
			// 이벤트별 Impl생성
			if (e.getEventName().equalsIgnoreCase("EsmBkg0479Event")) {
				EsmBkg0479Event event = (EsmBkg0479Event) e;

				// 배치에서 호출될 경우가 아닐 경우에만 command.manageTerminalEdi 호출
				if (event.getVvdJapanTerminalEdiVOS().length > 0  && !"SYSTEM".equals(event.getVvdJapanTerminalEdiVOS()[0].getCreUsrId())) {
					command.manageTerminalEdi(event.getVvdJapanTerminalEdiVOS(), account);
				}

				JapanTerminalEdiGroupVO japanTerminalEdiGroupVO = new JapanTerminalEdiGroupVO();
				BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVvdChkVO = new BkgTerminalEdiJapanBlVO();

				for (VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO : event.getVvdJapanTerminalEdiVOS()) {
					// 배치에서 호출될 경우, account를 set해줌
					if ("SYSTEM".equals(event.getVvdJapanTerminalEdiVOS()[0].getCreUsrId())) {
						account = new SignOnUserAccount(vvdJapanTerminalEdiVO.getEdiSndUsrId(), "", "", "", "", "", "JP", "", "BATCH", "", "BATCH", "", vvdJapanTerminalEdiVO.getEdiSndOfcCd(), "", "", "", "", "", "", "", "", "", "", "");
					}

					for (BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO : command.searchNewBkgInfo(vvdJapanTerminalEdiVO)) {
						japanTerminalEdiGroupVO = command.searchNewBkgDetailInfo(bkgTerminalEdiJapanBlVO);

						// SNACCS_TML_EDI_STS_CD 가 'D' 일때 최초에는 보내지 않음.
						if (!("D".equals(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCd()) && "0".equals(bkgTerminalEdiJapanBlVO.getRStsCnt()))) {
							begin();
							// VVD_CD 수정된 경우 취소전송이 보내진 후에 신규 전송이 보내져야 함
							if ("V".equals(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCd()) && "0".equals(bkgTerminalEdiJapanBlVO.getVvdChkStsCnt())) {
								// D로 보내야한다.
								chk_flg = command.addNewBkgInfo(bkgTerminalEdiJapanBlVO, japanTerminalEdiGroupVO, account, "vvdChk");

								// by BKG 에서 VOL QTY Manual 선택시 부조건 보냄.
								if (e.getFormCommand().isCommand(FormCommand.MULTI02)) chk_flg = "Y";

								if ("Y".equals(chk_flg)) {
									logno++;
									// Partial container 가 아닌 것만 보낸다
									// if ("N".equals(bkgTerminalEdiJapanBlVO.getPrtFlg())) {
									// Flatfile 생성
									bkgTerminalEdiJapanBlVvdChkVO = command.searchNewBkgInfoForVvdChk(bkgTerminalEdiJapanBlVO.getBkgNo());
									command.sendTerminalEdi((BkgTerminalEdiJapanBlVO) bkgTerminalEdiJapanBlVvdChkVO, japanTerminalEdiGroupVO, account, logno);
									// }
									bkgTerminalEdiJapanBlVO.setSnaccsTmlEdiStsCd("R");
									chk_flg = command.addNewBkgInfo(bkgTerminalEdiJapanBlVO, japanTerminalEdiGroupVO, account, "");

									// Partial container가 아닌 것만 보낸다
									// if ("N".equals(bkgTerminalEdiJapanBlVO.getPrtFlg())) {
									// Flatfile 생성
									command.sendTerminalEdi(bkgTerminalEdiJapanBlVO, japanTerminalEdiGroupVO, account, logno);
									// }
									commit();
								} else {
									rollback();
								}

							} else {
								chk_flg = command.addNewBkgInfo(bkgTerminalEdiJapanBlVO, japanTerminalEdiGroupVO, account, "");
								if ("N".equals(chk_flg)) {
									rollback();
								} else {
									logno++;
									// Partial container 가 아닌 것만 보낸다
									if ("N".equals(bkgTerminalEdiJapanBlVO.getPrtFlg())) {
										command.sendTerminalEdi(bkgTerminalEdiJapanBlVO, japanTerminalEdiGroupVO, account, logno);// j
									}
									commit();
								}
							}
						}
					}
				}

			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0480Event")) {
				EsmBkg0480Event event = (EsmBkg0480Event) e;
				BkgJapanTerminalEdiVO[] bkgJapanTerminalEdiVOs = event.getBkgJapanTerminalEdiVOS();

				for (int i=0; i<event.getBkgJapanTerminalEdiVOS().length; i++) {
					VvdJapanTerminalEdiVO vvdJapanTerminalEdiVO = new VvdJapanTerminalEdiVO();
					vvdJapanTerminalEdiVO.setVvdCd(bkgJapanTerminalEdiVOs[i].getVvdCd());
					vvdJapanTerminalEdiVO.setPolCd(bkgJapanTerminalEdiVOs[i].getPolCd());
					vvdJapanTerminalEdiVO.setBkgNo(bkgJapanTerminalEdiVOs[i].getBkgNo());
					vvdJapanTerminalEdiVO.setPolYdCd(bkgJapanTerminalEdiVOs[i].getPolYdCd());
					vvdJapanTerminalEdiVO.setPorCd(bkgJapanTerminalEdiVOs[i].getPorCd());
					vvdJapanTerminalEdiVO.setPorYdCd(bkgJapanTerminalEdiVOs[i].getPorYdCd());
					vvdJapanTerminalEdiVO.setOtrNtfyYdCd(bkgJapanTerminalEdiVOs[i].getOtrNtfyYdCd());
					vvdJapanTerminalEdiVO.setJpTmlVslNo(bkgJapanTerminalEdiVOs[i].getJpTmlVslNo());

					List<BkgTerminalEdiJapanBlVO> list = command.searchNewBkgInfo(vvdJapanTerminalEdiVO);
					BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVO = new BkgTerminalEdiJapanBlVO();
					BkgTerminalEdiJapanBlVO bkgTerminalEdiJapanBlVvdChkVO = new BkgTerminalEdiJapanBlVO();

					for (int j=0; j<list.size(); j++) {
						bkgTerminalEdiJapanBlVO =(BkgTerminalEdiJapanBlVO) list.get(j);
						JapanTerminalEdiGroupVO groupVO = command.searchNewBkgDetailInfo(bkgTerminalEdiJapanBlVO);

						// SNACCS_TML_EDI_STS_CD 가 'D' 일때 최초에는 보내지 않음.
						if (!("D".equals(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCd()) && "0".equals(bkgTerminalEdiJapanBlVO.getRStsCnt()))) {

							begin();
							// VVD_CD 수정된 경우 취소전송이 보내진 수에 신규 전송이 보내져야 함
							if ("V".equals(bkgTerminalEdiJapanBlVO.getSnaccsTmlEdiStsCd()) && "0".equals(bkgTerminalEdiJapanBlVO.getVvdChkStsCnt())) {
								// D로 보내야한다.
								chk_flg = command.addNewBkgInfo(bkgTerminalEdiJapanBlVO, groupVO, account, "vvdChk");

								// by BKG 에서 VOL QTY Manual 선택시 부조건 보냄.
								if (e.getFormCommand().isCommand(FormCommand.MULTI02)) chk_flg = "Y";

								if ("Y".equals(chk_flg)) {
									logno++;
									// Partial container 가 아닌 것만 보낸다
									// if ("N".equals(bkgTerminalEdiJapanBlVO.getPrtFlg())) {
									// Flatfile 생성
									bkgTerminalEdiJapanBlVvdChkVO = command.searchNewBkgInfoForVvdChk(vvdJapanTerminalEdiVO.getBkgNo());
									// bkgTerminalEdiJapanBlVvdChkVO =
									//(BkgTerminalEdiJapanBlVO) list1.get(j);
									command.sendTerminalEdi((BkgTerminalEdiJapanBlVO) bkgTerminalEdiJapanBlVvdChkVO, groupVO, account, logno);
									// }
									bkgTerminalEdiJapanBlVO.setSnaccsTmlEdiStsCd("R");
									chk_flg = command.addNewBkgInfo(bkgTerminalEdiJapanBlVO, groupVO, account, "");
									// Partial container 가 아닌 것만 보낸다
									// if ("N".equals(bkgTerminalEdiJapanBlVO.getPrtFlg())) {
									// Flatfile 생성
									command.sendTerminalEdi(bkgTerminalEdiJapanBlVO, groupVO, account, logno);
									// }
									commit();
								} else {
									rollback();
								}

							} else {  // 변경 여부 체크
								chk_flg = command.addNewBkgInfo(bkgTerminalEdiJapanBlVO, groupVO, account, "");
								// by BKG 에서 VOL QTY Manual 선택시 부조건 보냄.
								if (e.getFormCommand().isCommand(FormCommand.MULTI02)) chk_flg = "Y";

								if ("Y".equals(chk_flg)) {
									logno++;
									// Partial container 가 아닌 것만 보낸다
									// if ("N".equals(bkgTerminalEdiJapanBlVO.getPrtFlg())) {
									// Flatfile 생성
									command.sendTerminalEdi(bkgTerminalEdiJapanBlVO, groupVO, account, logno);
									// }
									commit();
								} else {
									rollback();
								}
							}
						}
					}
					// BKG ROUTE Check
					if (list.size() == 0) {
						chk_flg = "ROUTE";
					}
				}
				eventResponse.setETCData("chk_flg", chk_flg);
			}
			// 전송 메세제 체크
			if (logno > 0) {
				// 전송 성공
				eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
			} else {
				// 전송할 데이타 없음
				eventResponse.setUserMessage(new ErrorHandler("BKG08232").getUserMessage());
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * JapanOpusBkgNaccsReplyEvent : SEARCH01 <br>
	 * NACCS_EDI_OPUSBKG_SEANACCS 연동<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receiveJapanTerminalOpusBkgNaccs(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		JapanTerminalTransmissionBC command = new JapanTerminalTransmissionBCImpl();
		JapanOpusBkgNaccsReplyEvent event =(JapanOpusBkgNaccsReplyEvent) e;

		try {
			begin();
			command.receiveJapanTerminalOpusBkgNaccs(event.getFlatFile(), account);
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


}

