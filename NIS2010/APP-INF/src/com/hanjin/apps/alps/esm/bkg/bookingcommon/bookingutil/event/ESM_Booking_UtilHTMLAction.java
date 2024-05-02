/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UI_Booking_UtilHTMLAction.java
 *@FileTitle : Booking Page
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.23 
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.04.23 김영출
 * 1.0 Creation
 * ------------------------------------------------------
 * HISTORY 
 * 2012.03.14 김경섭 [CHM-201216605] ANCS Main Menu 관련 ESM_BKG_0044,0494,0965,0970 화면의 POD조회 추가.
 * 2012.04.24 오요한 [CHM-201216516] BKG/DOC System 보완 요청
 * 2014.05.20 문동선 [CHM-201429384] 한국 지역 Manifest Generate 생성 이후 BKG 변경 시 Pop-Up Alert 설정 요청
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgCstmsHrdCdgCtntVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.ProductCatalogPoupCheckVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgVvdBdrLogVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.bkg.bookingcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의
 * Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BookingCommonSC로 실행요청<br>
 * - BookingCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Kim Youngchul
 * @see BookingCommonEvent 참조
 * @since J2EE 1.4
 * 
 * 2011.11.08 전성진 [] booking re-activate 기능 추가
 */

public class ESM_Booking_UtilHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * UI_Booking_UtilHTMLAction 객체를 생성
	 */
	public ESM_Booking_UtilHTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 BookingCommonEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsmBookingUtilEvent event = new EsmBookingUtilEvent();
		log.debug("##### CALL:ESM_Booking_UtilHTMLAction - " + command.getCommand());

		if (command.isCommand(FormCommand.SEARCHLIST01)) {
			/* searchCombo : 각종 Combo 값을 가져옴. */
			// event.setBkgBlNoVO((BkgBlNoVO) getVO(request, BkgBlNoVO.class));
			String comboCd = JSPUtil.getParameter(request, "cm_code");
			event.setComboCd(comboCd);

		} else if (command.isCommand(FormCommand.SEARCHLIST02)) {
			/* searchBkgNoByBlNo : BL_NO를 통해 BKG_NO를 가져옴. */
			event.setBkgBlNoVOS((BkgBlNoVO[]) getVOs(request, BkgBlNoVO.class, ""));
		} else if (command.isCommand(FormCommand.SEARCHLIST03)) {
			/* searchBkgStatusByBkg : BKG_NO를 통해 BKG_STATUS를 가져옴. */
			event.setBkgBlNoVOS((BkgBlNoVO[]) getVOs(request, BkgBlNoVO.class, ""));
		} else if (command.isCommand(FormCommand.SEARCHLIST04)) {
			/* searchBkgStatusByBkg : BKG_NO를 통해 BKG_NO_SPLIT를 가져옴. */
			// event.setBkgBlNoVOS((BkgBlNoVO[]) getVOs(request,
			// BkgBlNoVO.class, ""));
			String bkgNo = JSPUtil.getParameter(request, "bkg_no");
			event.setBkgNo(bkgNo);
		} else if (command.isCommand(FormCommand.SEARCHLIST05)) {
			/* searchSvcLaneByLoc : Location를 통해 SVC Lane 목록을 가져옴 */
			String podCd = JSPUtil.getParameter(request, "pod_cd");
			event.setComboCd(podCd);
		} else if (command.isCommand(FormCommand.SEARCHLIST06)) {
			/* MDM_COUNTRY TABLE country을 조회 */
			String cnt_cd = JSPUtil.getParameter(request, "input_text");
			event.setInputText(cnt_cd);
		} else if (command.isCommand(FormCommand.SEARCHLIST10)) {
			/* MDM TABLE COMBO LIST을 조회 */
			String comboCd = JSPUtil.getParameter(request, "comboCd");
			event.setComboCd(comboCd);
		} else if (command.isCommand(FormCommand.SEARCHLIST11)) {
			/* VVD와 POL, POD로 미주세관 신고 대상인지 확인 */
			String bkgTrunkVvd = JSPUtil.getParameter(request, "bkg_trunk_vvd");
			String polCd = JSPUtil.getParameter(request, "pol_cd");
			String podCd = JSPUtil.getParameter(request, "pod_cd");
			event.setBkgTrunkVvd(bkgTrunkVvd);
			event.setPolCd(polCd);
			event.setPodCd(podCd);
		} else if (command.isCommand(FormCommand.SEARCHLIST12)) {
			/* Rfa No 유효성 확인 */
			String rfaNo = JSPUtil.getParameter(request, "rfa_no");
			event.setRfaNo(rfaNo);
			event.setBkgBlNoVO ((BkgBlNoVO)   getVO (request, BkgBlNoVO.class));
		} else if (command.isCommand(FormCommand.SEARCHLIST13)) {
			/* Sc No 유효성 확인 */
			String scNo = JSPUtil.getParameter(request, "sc_no");
			event.setScNo(scNo);
			event.setBkgBlNoVO ((BkgBlNoVO)   getVO (request, BkgBlNoVO.class));
		} else if (command.isCommand(FormCommand.SEARCH06)) {
			/* Sc No 유효성 확인 */
			String taaNo = JSPUtil.getParameter(request, "taa_no");
			event.setTaaNo(taaNo);
			event.setBkgBlNoVO ((BkgBlNoVO)   getVO (request, BkgBlNoVO.class));
		}else if (command.isCommand(FormCommand.SEARCHLIST14)) {
			// BKG_NO 번호로 OLD ,NEW BKG_NO 번호 구분자($)로 가져오는 함수
			String input_text = JSPUtil.getParameter(request, "input_text");
			event.setInputText(input_text);
		} else if (command.isCommand(FormCommand.SEARCHLIST15)
				// BL_NO 번호로 OLD ,NEW BL_NO 번호 구분자($)로 가져오는 함수
				|| command.isCommand(FormCommand.SEARCHLIST16)
				// ChargeCode 코드번호로 존재여부 판단하는 함수
				|| command.isCommand(FormCommand.SEARCHLIST17)
				// ChargeCode 코드번호로 존재여부 판단하는 함수
				|| command.isCommand(FormCommand.SEARCHLIST18)
				// ChargeCode 코드번호로 존재여부 판단하는 함수
				|| command.isCommand(FormCommand.SEARCHLIST19)
				// Third (Offce cd) 유효성체크 
				|| command.isCommand(FormCommand.SEARCHLIST20)
				// Payer (custCntCd, custSeq) 유효성체크 
				|| command.isCommand(FormCommand.COMMAND01)
				// Per (PerCd) 유효성체크 
				|| command.isCommand(FormCommand.COMMAND02)
				// ExistNoteButtonColor 유효성체크 
				|| command.isCommand(FormCommand.COMMAND03)
				// AutoratingRfaAvailable 유효성체크 
				|| command.isCommand(FormCommand.COMMAND04)
				// AutoratingScAvailable 유효성체크 
				|| command.isCommand(FormCommand.COMMAND05)
				// AutoratingTaaAvailable 유효성체크 
				|| command.isCommand(FormCommand.COMMAND06)	
				// RepCustomer 데이터 
				|| command.isCommand(FormCommand.COMMAND07)	
				// SaveFileExist 데이터 
				|| command.isCommand(FormCommand.COMMAND08)		
				// RfaSpotPricingAvailable 유효성체크 
				|| command.isCommand(FormCommand.COMMAND11)
				// 3rdPartyBlReqOfcAvailable 유효성체크 
				|| command.isCommand(FormCommand.COMMAND12)
				// 3rdPartyBlReqAvailable 유효성체크 
				|| command.isCommand(FormCommand.COMMAND13)
				// 서아프리카 POD Port 체크 
				|| command.isCommand(FormCommand.COMMAND16)
				// BKG Route 조회
				|| command.isCommand(FormCommand.COMMAND17)
				// CountryName 데이터 
				|| command.isCommand(FormCommand.SEARCH01)		
				// ScNoValidationCheck 데이터 
				|| command.isCommand(FormCommand.SEARCH02)	
				// fnSearchBkgVvdCheck 데이터 
				|| command.isCommand(FormCommand.SEARCH03)		
				// autoRatingRFACheck 데이터 
				|| command.isCommand(FormCommand.SEARCH04)	
				// searchRtAplyDateCheck 데이터 
				|| command.isCommand(FormCommand.SEARCH07)
				// doc Perfomance Report User id
				|| command.isCommand(FormCommand.SEARCH08)
				// existCustomsEntryCode
				|| command.isCommand(FormCommand.SEARCH14)
				// checkBkgBlackCustomer
				|| command.isCommand(FormCommand.SEARCH17)
		) {
			
			String input_text = JSPUtil.getParameter(request, "input_text");
			event.setInputText(input_text);
			log.debug("##### input_text - " + input_text);
		} else if (command.isCommand(FormCommand.SEARCH11)) {
			// ANCS Main Menu 관련 ESM_BKG_0044,0494,0965,0970 화면의 POD조회
			event.setBkgCstmsHrdCdgCtntVO((BkgCstmsHrdCdgCtntVO)getVO(request, BkgCstmsHrdCdgCtntVO.class));
			
		} else if (command.isCommand(FormCommand.COMMAND10)) {
			event.setBkgVvdBdrLogVO((BkgVvdBdrLogVO)getVO(request, BkgVvdBdrLogVO .class));
			event.setBkgVvdBdrLogVOs((BkgVvdBdrLogVO[]) getVOs(request, BkgVvdBdrLogVO.class, ""));
			
		} else if (command.isCommand(FormCommand.COMMAND09)) {
			String bkgNo = JSPUtil.getParameter(request, "bkg_no");
			event.setBkgNo(bkgNo);
			log.debug("##### bkg_no - " + bkgNo);
		} else if (command.isCommand(FormCommand.COMMAND18)) { //addBkgBlckListMntr
			String bkgNo = JSPUtil.getParameter(request, "bkg_no");
			String blckKwNm = JSPUtil.getParameter(request, "blckKwNm");
			String blckTpCd = JSPUtil.getParameter(request, "blckTpCd");
			event.setBkgNo(bkgNo);
			event.setBlckKwNm(blckKwNm);
			event.setBlckTpCd(blckTpCd);
			log.debug("##### bkg_no - " + bkgNo);
		} else if (command.isCommand(FormCommand.MODIFY)) {
			// 화면에서 쿼리를 받아 실행 (CUD)
			String input_text = JSPUtil.getParameter(request, "sql");
			event.setSql(input_text);
		}
		else if (command.isCommand(FormCommand.SEARCH10)) {

		String ctrtType = JSPUtil.getParameter(request, "ctrtType");
		String ctrtNo = "";
		if(ctrtType.equalsIgnoreCase("sc"))
			ctrtNo = JSPUtil.getParameter(request, "sc_no");
		if(ctrtType.equalsIgnoreCase("rfa"))
			ctrtNo = JSPUtil.getParameter(request, "rfa_no");
		if(ctrtType.equalsIgnoreCase("taa"))
			ctrtNo = JSPUtil.getParameter(request, "taa_no");
		String bkgNo = JSPUtil.getParameter(request, "bkg_no");
		
		event.setCtrtType(ctrtType);
		event.setCtrtNo(ctrtNo);
		event.setBkgNo(bkgNo);
		} else if  (command.isCommand(FormCommand.SEARCH12)) {
			event.setBkgBlNoVO ((BkgBlNoVO)   getVO (request, BkgBlNoVO.class));
		} else if (command.isCommand(FormCommand.SEARCH15)) {
			// VVD의 한국세관 Download 여부 조회 ESM_BKG_0079_01, 등
			String vvdCd  = JSPUtil.getParameter(request, "vvd_cd");
			String podLoc = JSPUtil.getParameter(request, "pod_loc");
			event.setBkgTrunkVvd(vvdCd);//Trunk,Pre,Post VVD 무관
			event.setPodCd(podLoc);
		} else if (command.isCommand(FormCommand.SEARCH16)) {
			//ESM_BKG_0000_1.do 에서 BKG NO, CNTR NO로 BKG NO와 CNTR NO와 CNTR CYCLE NO를 조회한다
	      String bkgNo = JSPUtil.getParameter(request, "bkgNo");
	      String cntrNo = JSPUtil.getParameter(request, "cntrNo");

	      event.setBkgNo(bkgNo);
	      event.setCtrtNo(cntrNo);
		}else if (command.isCommand(FormCommand.COMMAND15)) {
			//ESM_BKG_0000_1.do 에서 CNTR CYCLE NO를 수정한다
	      event.setCntrInfoVOs((CntrInfoVO[])getVOs(request, CntrInfoVO.class, ""));
	    }else if (command.isCommand(FormCommand.COMMAND14)) {
	    	//No Ratus Status를 Firm 한다
	      String bkgNo = JSPUtil.getParameter(request, "bkg_no_norate");
	      event.setBkgNo(bkgNo);
	      this.log.debug("##### bkg_no - " + bkgNo);
	    } else if (command.isCommand(FormCommand.SEARCH19)) {
		      String ofcCd = JSPUtil.getParameter(request, "ofc_cd");
		      event.setOfcCd(ofcCd);
		} else if (command.isCommand(FormCommand.SEARCH20)) {
		      String htsCd = JSPUtil.getParameter(request, "hts_cd");
		      event.setHtsCd(htsCd);
		}else if (command.isCommand(FormCommand.SEARCH18)) {
			// checkWordBlackList
			String input_text = JSPUtil.getParameter(request, "input_text");
			String input_text1 = JSPUtil.getParameter(request, "input_text1");
			event.setInputText(input_text);
			event.setInputText1(input_text1);
			log.debug("##### input_text - " + input_text);
		}else if (command.isCommand(FormCommand.SEARCH22)) {
			// checkChaCalHypoBlckList
			String input_text = JSPUtil.getParameter(request, "input_text");
			event.setInputText(input_text);
			log.debug("##### input_text - " + input_text);
		}else if (command.isCommand(FormCommand.SEARCH23)) {
			// checkChaCalHypoBlckList
			String bkgNo = JSPUtil.getParameter(request, "bkg_no");
			event.setBkgNo(bkgNo);
		}else if (command.isCommand(FormCommand.COMMAND19)) {
			// checkChaCalHypoBlckList
			String bkgNo = JSPUtil.getParameter(request, "bkg_no");
			String serNo = JSPUtil.getParameter(request, "ser_no");
			event.setBkgNo(bkgNo);
			event.setSerNo(serNo);
		}else if (command.isCommand(FormCommand.SEARCH24)) {
			String bkgNo = JSPUtil.getParameter(request, "bkg_no");
			event.setBkgNo(bkgNo);
		}else if (command.isCommand(FormCommand.SEARCH25)) {
			String bkgNo = JSPUtil.getParameter(request, "bkg_no");
			event.setBkgNo(bkgNo);
		}else if (command.isCommand(FormCommand.COMMAND20)) {
			String bkgNo = JSPUtil.getParameter(request, "bkg_no");
			String serNo = JSPUtil.getParameter(request, "obl_inter_ser_no");
			String uiId = JSPUtil.getParameter(request, "ui_Id");
			event.setBkgNo(bkgNo);
			event.setSerNo(serNo);
			event.setUiId(uiId);
        }else if (command.isCommand(FormCommand.COMMAND21)) {
            String idaSacCd = JSPUtil.getParameter(request, "ida_sac_cd");
            event.setIdaSacCd(idaSacCd);
        }else if (command.isCommand(FormCommand.SEARCH26)) {
			event.setBkgNo(JSPUtil.getParameter(request, "bkg_no"));
			event.setSecuritySearchId(JSPUtil.getParameter(request, "security_search_id"));
		}else if (command.isCommand(FormCommand.SEARCH27)) {
			String porCd = JSPUtil.getParameter(request, "por_cd");
			event.setPorCd(porCd);
        }else if (command.isCommand(FormCommand.COMMAND22)) {
        	//@ BKG Customs Receive Message Test
        	event.setFlatFile(JSPUtil.getParameter(request, "flat_file"));
        	event.setCntCd   (JSPUtil.getParameter(request, "cnt_cd"));
        	event.setCommitYn(JSPUtil.getParameter(request, "commit_yn"));			
		}else if (command.isCommand(FormCommand.SEARCH28)) {
			/* PRD Constraint 체크 로직 추가 최종혁 부장님 요청 2018.01.16 */
			 event.setProductCatalogPoupCheckVO((ProductCatalogPoupCheckVO)getVO(request, ProductCatalogPoupCheckVO.class, ""));
		}
		request.setAttribute("Event", event);

		return event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param eventResponse
	 *            EventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param event
	 *            Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}