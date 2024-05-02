/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthorizationSC.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.08
*@LastModifier : 심성윤
*@LastVersion : 1.0
* 2015.07.08 심성윤
* 1.0 Creation
=========================================================*/
package com.hanjin.bizcommon.authorization;

import java.util.List;

import com.hanjin.bizcommon.authorization.basic.AuthorizationBC;
import com.hanjin.bizcommon.authorization.basic.AuthorizationBCImpl;
import com.hanjin.bizcommon.authorization.vo.AuthorizationCommonVO;
import com.hanjin.bizcommon.authorization.event.ComApr0S1Event;
import com.hanjin.bizcommon.authorization.event.ComApr0S2Event;
import com.hanjin.bizcommon.authorization.event.ComApr0T1Event;
import com.hanjin.bizcommon.authorization.util.AuthorizationApprovalUtil;
import com.hanjin.bizcommon.authorization.vo.AuthEmlSndVO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationProgramInfoVO;
import com.hanjin.bizcommon.authorization.vo.SearchAuthAproVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-Authorization Business Logic ServiceCommand - ALPS-Authorization 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author 심성윤
 * @see 
 * @since J2EE 1.6
 */

public class AuthorizationSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * AuthorizationSC system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("AuthorizationSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * AuthorizationSC system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("AuthorizationSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-AuthorizationSC system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("ComApr0T1Event")) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
            	// Request 버튼 클릭 시 해당 Authorization Approval Route 저장
				eventResponse = saveAuthorizationRoute(e, account);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				// 결재대상이 복수개이며 apro no를 한꺼번에 줘야하는 경우 : TRS W/O Preview화면에서 요청
				eventResponse = saveAuthorizationRoute2(e, account);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAuthAproDflt(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAuthSelfApprovalCheck(e, account);
        	} else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
        		//Excel Download 승인 대상 화면인지 확인
				eventResponse = searchAuthChkXlsBtnPrmt(e);
        	}
		} else if(e.getEventName().equalsIgnoreCase("ComApr0S1Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAllAuthPgmInfo(e);
        	} else {
				eventResponse = searchAuthPgmInfo(e);	
			} 
		}else if(e.getEventName().equalsIgnoreCase("ComApr0S2Event")){
	    	
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = savePgmAuth(e, account);
        	}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getPgmNm(e);
        	}else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchPgmDetail(e);
        	}else {
				eventResponse = getComboData(e);	
			}
		}
		
		return eventResponse;
	}
 
	/**
	 * Authorization Approval Route 화면에 대한 저장 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @param SignOnUserAccount account
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse saveAuthorizationRoute(Event e, SignOnUserAccount account) throws EventException { 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComApr0T1Event event = (ComApr0T1Event)e;
    	AuthorizationBC command = new AuthorizationBCImpl();
    	AuthorizationApprovalUtil authorizationApprovalUtil = new AuthorizationApprovalUtil();
    	AuthEmlSndVO emlSndVO = null;
    	String authEmlSndNoSeq = null;
    	try{
			String authAproRqstNo = "";
			String xls_prmt = "";
			String snd_no = "";
			String noEmlMem = "";
			
			begin();
			//HDR, ROUT 정보 저장 후 auth_apro_rqst_no 리턴...
			authAproRqstNo = command.saveAuthorizationRoute(event.getAuthorizationRouteVOS(),event.getAuthorizationCommonVO(), account);
			commit();
			eventResponse.setETCData("AUTH_APRO_RQST_NO", authAproRqstNo);
			//eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"}).getUserMessage());
			
			xls_prmt = JSPUtil.getNull((String)event.getAttribute("xls_prmt"));
			if(xls_prmt != null && !"".equals(xls_prmt)){
				if("Y".equals(xls_prmt)){
					noEmlMem = command.searchNoEmlAddr(authAproRqstNo);
					if(!("".equals(noEmlMem))){
						String noEmlApro[] = noEmlMem.split("-");
						String noEmlApro2 = "";
						for(int i=0; i<noEmlApro.length; i++){
							
							if(i == noEmlApro.length -1){
								noEmlApro2 = noEmlApro2 + noEmlApro[i];
							}else{
								noEmlApro2 = noEmlApro2 + noEmlApro[i] + ", ";
							}
						}
						log.error("\n>>>>>No-Email>>>"+noEmlApro2+"<<<<<<<<<<<<<");
						eventResponse.setUserMessage("No E-mail Address : "+noEmlApro2);
						begin();
						command.updateNoEmlAddrRmk(authAproRqstNo, noEmlApro2);
						commit();
					}else{
						begin();
						authorizationApprovalUtil.updateAuthAproCfm(authAproRqstNo);
						log.error("\n>>>>>>>>SC E-mail 발송 로직");
						//E-mail 시퀀스 채번
						authEmlSndNoSeq = authorizationApprovalUtil.searchAuthEmlSndSeq();
						//이메일 컨텐츠 준비
						emlSndVO = authorizationApprovalUtil.authRdyToSndEml(authAproRqstNo, authEmlSndNoSeq, account, "P");
						commit();
						
						//이메일 발송
						snd_no = JSPUtil.getNull(authorizationApprovalUtil.authSndEml(emlSndVO));
						log.error("\n\n>>>>>>>>>>>Eml_Snd_No>>>>>"+snd_no+"<<<<<<<<<\n\n");
						emlSndVO.setEmlSndNo(snd_no);
						
						begin();
						//E-mail 성공 여부 Update
						authorizationApprovalUtil.updateAuthEmlSndSuccess(emlSndVO);
						commit();
					}
					
				}
			}					
		}catch(EventException ex){
			rollback();
			begin();
			//실패시 로그 기록
			authorizationApprovalUtil.updateAuthEmlSndFail(authEmlSndNoSeq);
			commit();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            begin();
			//실패시 로그 기록
			authorizationApprovalUtil.updateAuthEmlSndFail(authEmlSndNoSeq);
			commit();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Authorization Approval Route"}).getMessage(), ex);
		}
        
		return eventResponse;
	}
	
	/**
	 * 결재대상이 복수개이며 apro no를 '|'로 붙여서 한번에 줘야하는 경우 
	 * ex) TRS W/O Preview화면에서 요청
	 * <중> 사후결재 TRS만 요청한 상태로 사전결재 특히 Excel download 복수개 요청이오면 아래 e-mail발송도 복수로 처리 할 수 있게 작업해야한다.(-> '|'로 나눠서 처리한다) 
	 *      복수로 하되 1건이 오면 단일건으로 처리하게 되면 다른데 영향 없이 구현 가능하다.
	 *      앞서 언급한 것 처럼 복수 처리 METHOD를 잘 구성하면 단일건 처리도 다 통일할 수 있으나 나머지 MODULE들 모조리 다 test를 해야해서 일단 METHOD 자체를 분리한다.
	 *      나중에 큰거해서 전체 TEST할때 이 부분도 saveAuthorizationRoute2() 형식으로 통일하고 test도 다 해서 올린다.
	 * 
	 * @param Event e
	 * @param SignOnUserAccount account
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse saveAuthorizationRoute2(Event e, SignOnUserAccount account) throws EventException { 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComApr0T1Event event = (ComApr0T1Event)e;
    	AuthorizationBC command = new AuthorizationBCImpl();
    	AuthorizationCommonVO authorizationCommonVO = null;
    	int knt = 1;
    	
    	try{
			String authAproRqstNo = "";
			
			authorizationCommonVO = event!=null?event.getAuthorizationCommonVO():null;
			knt = authorizationCommonVO!=null&&authorizationCommonVO.getAuthRqstKnt()!=null&&!JSPUtil.getNull(authorizationCommonVO.getAuthRqstKnt()).equals("")?Integer.parseInt(JSPUtil.getNull(authorizationCommonVO.getAuthRqstKnt())):0;
			log.error("\n saveAuthorizationRoute2 - knt : " + JSPUtil.getNull(knt)  + "<<<<<<<<<<<<<<<<<\n");
			for (int k = 0; k < knt; k++){
				begin();
				authAproRqstNo = (authAproRqstNo!=null&&!authAproRqstNo.trim().equals("")?(authAproRqstNo+"|"):"") + command.saveAuthorizationRoute(event.getAuthorizationRouteVOS(),event.getAuthorizationCommonVO(), account);
				commit();
			}
			
			/*** 
			 * CANCEL처리 TEST용 
			 * 나중에 여기 FOR문안에 xls_prmt~ 처리를 넣으면 해결은 되나 업무상 EXCEL DOWNLOAD 메일쏘기가 복합으로 될리가 없다.
			 ***/
//			String[] tempAuthAproRqstNo = null;
//			tempAuthAproRqstNo = authAproRqstNo.split("\\|");
//			for (int j = 0; tempAuthAproRqstNo!=null && j < tempAuthAproRqstNo.length; j++){
//				if (tempAuthAproRqstNo[j]!=null && !tempAuthAproRqstNo[j].trim().equals("")){
//					begin();
//					new AuthorizationApprovalUtil().cancelAuthApro(tempAuthAproRqstNo[j]);
//					commit();
//				}
//			}
			
			log.error("\n saveAuthorizationRoute2 - authAproRqstNo : " + JSPUtil.getNull(authAproRqstNo)  + "<<<<<<<<<<<<<<<<<\n");
			eventResponse.setETCData("AUTH_APRO_RQST_NO", JSPUtil.getNull(authAproRqstNo));
			//eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"}).getUserMessage());
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			rollback();
			throw ex;
		} catch (NumberFormatException ex) {
			log.error("err " + ex.toString(), ex);
			rollback();
			throw ex;			
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Authorization Approval Route"}).getMessage(), ex);
		}
        
		return eventResponse;
	}	
	 
		/**
		 * Self 결재자 인지 Check 하는 로직<br>
		 * 
		 * @param Event e
		 * @param SignOnUserAccount account
		 * @return EventResponse eventResponse
		 * @exception EventException
		 */
		private EventResponse searchAuthSelfApprovalCheck(Event e, SignOnUserAccount account) throws EventException { 
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	    	ComApr0T1Event event = (ComApr0T1Event)e;
	    	AuthorizationBC command = new AuthorizationBCImpl();
	    	String retval = "";
	    	try{
				retval = command.searchAuthSelfApprovalCheck(event.getAuthorizationRouteVO(), account);
				eventResponse.setETCData("CHK_SELF_APRO", retval);
				log.error("\n"+ "    >>>>>>>>>>  "+retval+"   <<<<<<<<<<");
				//eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"}).getUserMessage());
			}catch(EventException ex){
				rollback();
				throw ex;
	        } catch (Exception ex) {
	            log.error("err " + ex.toString(), ex);
	            rollback();
	            throw new EventException(new ErrorHandler("COM12192", new String[]{"Authorization Approval Route"}).getMessage(), ex);
			}
	        
			return eventResponse;
		}
	
	
	
	/**
	 * Authorization Approval Default 라인 조회
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuthAproDflt (Event e) throws EventException { 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComApr0T1Event event = (ComApr0T1Event)e;
    	AuthorizationBC command = new AuthorizationBCImpl();
    	
    	try{
    		List<SearchAuthAproVO>  searchAuthAproVOs = command.searchAuthAproDflt(event.getSearchAuthAproVO());
        	eventResponse.setRsVoList(searchAuthAproVOs);			
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Authorization Approval Route"}).getMessage(), ex);
		}        
		return eventResponse;		
	}	
	
	/**
	 * Excel Download 승인 대상 화면인지 확인<br>
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuthChkXlsBtnPrmt(Event e) throws EventException { 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComApr0T1Event event = (ComApr0T1Event)e;
    	AuthorizationBC command = new AuthorizationBCImpl();
    	String retval = "";
    	String usrId = JSPUtil.getNull(event.getSignOnUserAccount().getUsr_id());
    	try{
    		event.getSearchAuthAproVO().setUsrId(usrId);
			retval = command.searchAuthChkXlsBtnPrmt(event.getSearchAuthAproVO());
			eventResponse.setETCData("XLS_PRMT_DATA", retval);
			log.error("\n"+ "    XLS_PRMT_DATA >>>>>>>>>>  "+retval+"   <<<<<<<<<<");
			//eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"}).getUserMessage());
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Authorization Approval Route"}).getMessage(), ex);
		}
        
		return eventResponse;
	}
	
	
	
	/**
	 * Authorization 설정 정보 조회
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuthPgmInfo (Event e) throws EventException { 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComApr0S1Event event = (ComApr0S1Event)e;
    	AuthorizationBC command = new AuthorizationBCImpl();
    	
    	try{
    		List<AuthorizationProgramInfoVO>  authorizationProgramInfoVO = command.searchAuthPgmInfo(event.getAuthorizationProgramInfoVO());
        	eventResponse.setRsVoList(authorizationProgramInfoVO);			
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Authorization Approval Route"}).getMessage(), ex);
		}        
		return eventResponse;		
	}
	
	
	/**
	 * Authorization 전체 설정 정보 조회
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchAllAuthPgmInfo(Event e) throws EventException { 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComApr0S1Event event = (ComApr0S1Event)e;
    	AuthorizationBC command = new AuthorizationBCImpl();
    	
    	try{
    		List<AuthorizationProgramInfoVO>  authorizationProgramInfoVO = command.searchAllAuthPgmInfo(event.getAuthorizationProgramInfoVO());
        	eventResponse.setRsVoList(authorizationProgramInfoVO);			
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Authorization Approval Route"}).getMessage(), ex);
		}        
		return eventResponse;		
	}
	
	/**
	 * 0S2 팝업 콤보 데이터 조회
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse getComboData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
    	ComApr0S2Event event = (ComApr0S2Event)e;
    	AuthorizationBC command = new AuthorizationBCImpl();
		try {
			eventResponse = command.getComboData(event.getAuthorizationProgramInfoVO());

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 0S2 팝업 콤보 데이터 조회
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse getPgmNm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
    	ComApr0S2Event event = (ComApr0S2Event)e;
    	AuthorizationBC command = new AuthorizationBCImpl();
		try {
			eventResponse = command.getPgmNm(event.getAuthorizationProgramInfoVO());

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 0S2 팝업 데이터 조회
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse searchPgmDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComApr0S2Event event = (ComApr0S2Event)e;
    	AuthorizationBC command = new AuthorizationBCImpl();
		try {
			
			AuthorizationProgramInfoVO  authorizationProgramInfoVO = command.searchPgmDetail(event.getAuthorizationProgramInfoVO());
			eventResponse.setRsVo(authorizationProgramInfoVO);	
        	

		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * 0S2 팝업 데이터 저장
	 * 
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	private EventResponse savePgmAuth(Event e, SignOnUserAccount account) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComApr0S2Event event = (ComApr0S2Event)e;
    	AuthorizationBC command = new AuthorizationBCImpl();
		try {
			command.savePgmAuth(event.getAuthorizationProgramInfoVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"}).getUserMessage());
			
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	
}