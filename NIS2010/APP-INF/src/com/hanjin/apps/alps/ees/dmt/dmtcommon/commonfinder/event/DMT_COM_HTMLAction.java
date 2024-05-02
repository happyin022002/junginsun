/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTCommonFinderHTMLAction.java
*@FileTitle : DMTCommonFinder
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.04.27 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.AttentionVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.BookingNoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.CommonCodeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.ContainerCargoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.CountryCdVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.CoverageVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.CustomerVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.DayVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.LocationCdVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.OfficeNameVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.PayerNameParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.RhqOfcCodeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.UserInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.SheetOptionByOfficeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.SheetSetVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.TariffNameVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.UserRoleVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.VendorNameVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.eeo.dmt.dmtcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DMTCommonSC로 실행요청<br>
 * - DMTCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SungHoon, Lee
 * @see DMTCommonEvent 참조
 * @since J2EE 1.4
 */

public class DMT_COM_HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * DMTCommonFinderHTMLAction 객체를 생성
	 */
	public DMT_COM_HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DMTCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		DmtComEvent event = new DmtComEvent();
		
		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setCoverageVO((CoverageVO)getVO(request, CoverageVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setCoverageVO((CoverageVO)getVO(request, CoverageVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setCoverageVO((CoverageVO)getVO(request, CoverageVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setCoverageVO((CoverageVO)getVO(request, CoverageVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setCoverageVO((CoverageVO)getVO(request, CoverageVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setCoverageVO((CoverageVO)getVO(request, CoverageVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH07)) {
			event.setCoverageVO((CoverageVO)getVO(request, CoverageVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH08)) {
			event.setCoverageVO((CoverageVO)getVO(request, CoverageVO .class));
		}			
		else if(command.isCommand(FormCommand.SEARCH09)) {
			event.setTariffNameVOS((TariffNameVO)getVO(request, TariffNameVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH10)) {
			event.setCoverageVO((CoverageVO)getVO(request, CoverageVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH11)) {
			event.setContainerCargoVO((ContainerCargoVO)getVO(request, ContainerCargoVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH12)) {
			event.setCoverageVO((CoverageVO)getVO(request, CoverageVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH13)) {
			event.setCoverageVO((CoverageVO)getVO(request, CoverageVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH14)) {
			event.setCoverageVO((CoverageVO)getVO(request, CoverageVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH15)) {
			event.setCommonCodeVO((CommonCodeVO)getVO(request, CommonCodeVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH16)) {
			event.setCoverageVO((CoverageVO)getVO(request, CoverageVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH17)) {
			event.setCoverageVO((CoverageVO)getVO(request, CoverageVO .class));
		}			
		else if(command.isCommand(FormCommand.SEARCH18)) {
			event.setCoverageVO((CoverageVO)getVO(request, CoverageVO .class));
		}	
		else if(command.isCommand(FormCommand.SEARCH19)) {
			event.setCustomerVO((CustomerVO)getVO(request, CustomerVO .class));
		}			
		else if(command.isCommand(FormCommand.SEARCH20)) {
			event.setPayerNameParamVO((PayerNameParamVO)getVO(request, PayerNameParamVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH21)) {
			event.setUserInfoVO((UserInfoVO)getVO(request, UserInfoVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setTariffNameVOS((TariffNameVO)getVO(request, TariffNameVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setOfficeNameVO((OfficeNameVO)getVO(request, OfficeNameVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST02)) {
			event.setRhqOfcCodeVO((RhqOfcCodeVO)getVO(request, RhqOfcCodeVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST03)) {
			event.setAttentionVO((AttentionVO)getVO(request, AttentionVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST04)) {
			event.setVendorNameVO((VendorNameVO)getVO(request, VendorNameVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST05)) {
			event.setOfficeNameVO((OfficeNameVO)getVO(request, OfficeNameVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST06)) {
			event.setOfficeNameVO((OfficeNameVO)getVO(request, OfficeNameVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST07)) {
			event.setCoverageVO((CoverageVO)getVO(request, CoverageVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST08)) {
			event.setCoverageVO((CoverageVO)getVO(request, CoverageVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST09)) {
			event.setCoverageVO((CoverageVO)getVO(request, CoverageVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST10)) {
			event.setCoverageVO((CoverageVO)getVO(request, CoverageVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND01)) {
			event.setOfficeNameVO((OfficeNameVO)getVO(request, OfficeNameVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND02)) {
			event.setBookingNoVO((BookingNoVO)getVO(request, BookingNoVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND03)) {
			//event.setOfficeNameVO((OfficeNameVO)getVO(request, OfficeNameVO .class));
			event.setCoverageVO((CoverageVO)getVO(request, CoverageVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND05)) {
			event.setCoverageVO((CoverageVO)getVO(request, CoverageVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND06)) {
			event.setOfficeNameVO((OfficeNameVO)getVO(request, OfficeNameVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND07)) {
			event.setLocationCdVO((LocationCdVO)getVO(request, LocationCdVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND08)) {
			event.setOfficeNameVO((OfficeNameVO)getVO(request, OfficeNameVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND09)) {
			event.setOfficeNameVO((OfficeNameVO)getVO(request, OfficeNameVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND11)) {
			event.setCountryCdVO((CountryCdVO)getVO(request, CountryCdVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND12)) {
			event.setUserRoleVO((UserRoleVO)getVO(request, UserRoleVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND13)) {
			event.setSheetSetVO((SheetSetVO)getVO(request, SheetSetVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND14)) {
			event.setSheetOptionByOfficeVO((SheetOptionByOfficeVO)getVO(request, SheetOptionByOfficeVO .class));
		}
        else if(command.isCommand(FormCommand.COMMAND15)) {
            String cmdt_cd =  JSPUtil.getParameter(request, "cmdt_cd".trim(), "");
            event.setAttribute("cmdt_cd", cmdt_cd);
        }
        else if(command.isCommand(FormCommand.COMMAND16)) {
            event.setLocationCdVO((LocationCdVO)getVO(request, LocationCdVO .class));
        }
        else if(command.isCommand(FormCommand.COMMAND18)) {
            event.setDayVO((DayVO)getVO(request, DayVO .class));
        }
        else if(command.isCommand(FormCommand.COMMAND19)) {
        	event.setRhqOfcCodeVO((RhqOfcCodeVO)getVO(request, RhqOfcCodeVO .class));
        }
		else if(command.isCommand(FormCommand.COMMAND20)) {
			 String yd_cd =  JSPUtil.getParameter(request, "yd_cd".trim(), "");
	         event.setAttribute("yd_cd", yd_cd);
		}
		// RHQ 산하 DMT OFC 조회 
		else if(command.isCommand(FormCommand.COMMAND21)) {
			event.setOfficeNameVO((OfficeNameVO)getVO(request, OfficeNameVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH21)) {
			String yd_cd =  JSPUtil.getParameter(request, "yd_cd".trim(), "");
	        event.setAttribute("yd_cd", yd_cd);
		}
		//Charge Deletion Attached File 존재여부 체크
		else if(command.isCommand(FormCommand.SEARCH26)) {
			String fileSavId =  JSPUtil.getParameter(request, "file_sav_id".trim(), "");
	        event.setFileSavId(fileSavId);
		}		
		//Payer 정보가 DMT_PAYR_INFO 테이블에 존재하는지 확인
		else if(command.isCommand(FormCommand.SEARCH28)) {
			String svrId =  JSPUtil.getParameter(request, "svr_id".trim(), "");
			String payerCd =  JSPUtil.getParameter(request, "payer_cd".trim(), "");
			event.setAttribute("svr_id", svrId);
			event.setAttribute("payer_cd", payerCd);
		}		
		request.setAttribute("Event", event);

		return  event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}