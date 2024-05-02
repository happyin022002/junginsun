/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CodeMgtSC.java
 *@FileTitle : 공통코드및 기준정보 관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.05
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.10.05 박제성 , 진윤오 , 정행룡 , 양정란 , 윤세영
 * 1.0 Creation
 * ---------------------------------------------------------
 * History
 * 2010.12.10 이준범 [CHM-201007236-01]
 * 1.제목 : CNI Main Code Creation Logic 보완 및 Popup 화면 추가 요청
 * 2.처리내역
 *  2.1 Main code creation시 Code 생성 규칙에 따른 중복 유사 Code를 검색하여 
 *      그 결과를 Popup display하며 User의 선택에  따라 생성 또는 Detail 
 *      information을 확인할 수 있는 Main Code View 화면으로 이동하도록 보완  
 * 2013.07.24 강환  [CHM-201325246] Role Hard Coding 제거 및 대체 기능 개발
=========================================================*/
package com.hanjin.apps.alps.cps.cni.codemgt;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URLDecoder;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.basic.CodeMgtBC;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.basic.CodeMgtBCImpl;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.event.CpsCni0004Event;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.event.CpsCni0005Event;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.event.CpsCni0007Event;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.event.CpsCni0025Event;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.event.CpsCni0026Event;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.event.CpsCni0028Event;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.event.CpsCni0029Event;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.event.CpsCni0039Event;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.event.CpsCni0042Event;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.event.CpsCni0095Event;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.event.CpsCni0096Event;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.integration.CodeMgtDBDAO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.ClassCodeVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.CniClassCodeVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.CniMiscCodeVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.CniPartyVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.ContactPointVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.HandlerHistoryVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.MdmOrganizationVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.MiscCodeVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.PartyCntVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.PartyInquiryCondVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.PartyInquiryVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.PartyVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.VvdSkdVO;
import com.hanjin.apps.alps.cps.cni.codemgt.codemgt.vo.CniUsrRoleMtchVO;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.basic.FileMgtBC;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.basic.FileMgtBCImpl;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.event.CniFileEvent;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.event.CpsCni0011Event;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.vo.CniAtchFileVO;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.vo.CustomFileDwcInsuranceVO;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.vo.FileUploadVO;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.vo.SearchFileDwcInsuranceListVO;
import com.hanjin.apps.alps.cps.cni.codemgt.filemgt.vo.SearchFileInsuranceListVO;
import com.hanjin.apps.alps.cps.cni.common.CniConst;
import com.hanjin.apps.alps.cps.cni.common.CniUtil;
import com.hanjin.apps.alps.cps.cni.common.basic.CniCommonBC;
import com.hanjin.apps.alps.cps.cni.common.basic.CniCommonBCImpl;
import com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.event.CpsCni0003Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBC;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBCImpl;


/**
 * CNICommon Business Logic ServiceCommand
 * 코드및 기준정보 관리
 * 
 * @author 박제성 , 진윤오 , 정행룡 , 양정란 , 윤세영
 * @see CodeMgtDBDAO
 * @since J2EE 1.4
 */

public class CodeMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
	
	// 레포트 파일 구분자
	private final String SP = "|&&|";
	private final String EOR = "//EOR//";
	
	/**
	 * CNICommon system 선처리 작업<br>
	 * 객체 생성
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
			// 사용자 Role정보 
			String roles = CniUtil.getRoles(account);	
			
			if (StringUtils.isEmpty(roles)) {
				CniCommonBC cmd = new CniCommonBCImpl();				
				CniUtil.setRoles(account, 
						cmd.searchUserRoleList(account.getUsr_id()));
				
			}		
			
			// 사용자 Area정보 취득 
			String area = CniUtil.getAreaInfo(account);	
			
			if (StringUtils.isEmpty(area)) {
				CniCommonBC cmd = new CniCommonBCImpl();				
				CniUtil.setAreaInfo(account, 
						cmd.searchUserArea(account.getOfc_cd()));				
			}		
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
		}
	}

	/**
	 * CNICommon system 후처리 작업<br>
	 */
	public void doEnd() {
		log.debug("CNICommonSC 종료");
	}

	// ************************************************************************************************
	
	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * CNI 코드 관련 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {

		// 이벤트 정보
		//2011-12-08 사용하지 않는 지역 변수를 점검한다.
		//EventResponse eventResponse = null;
		// 이벤트 명 취득
		String eventName = e.getEventName();
		//String eventName = "CpsCni9999Event";
		// Command 명 취득
		FormCommand cmd = e.getFormCommand();
        
		
		// ===========================================================================
		// 진윤오
		// ===========================================================================
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0025] Main Code-Creation
		// [CPS_CNI_0027] Main Code-View
		// ---------------------------------------------------------------------------
		if ("CpsCni0025Event".equalsIgnoreCase(eventName)) {							
			// [Retrieve , Open]
			if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchPartyContactPoint(e);
			// [Save]
			} else if (cmd.isCommand(FormCommand.MULTI)) {
				return managePartyContactPoint(e);
			// [Delete]
			} else if (cmd.isCommand(FormCommand.REMOVE)) {				
				return removeParty(e);
			} 
		}
		
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0026] Main Code-Inquiry
		// [CPS_CNI_0041] Main Code-Inquiry Popup
		// ---------------------------------------------------------------------------
		else if ("CpsCni0026Event".equalsIgnoreCase(eventName)) {							
			// [Retrieve , Open]
			if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchPartyInquiryList(e);			
			} else if (cmd.isCommand(FormCommand.PRINT)) {
				return printPartyInquiryList(e);
			}
		}
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0011] File Upload
		// ---------------------------------------------------------------------------
		else if ("CpsCni0011Event".equalsIgnoreCase(eventName)) {							
			// [Save]
			if (cmd.isCommand(FormCommand.MULTI)) {
				return manageFileUpload(e);			
			} else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchFileUploadList(e);
			}
		}
		
		// ---------------------------------------------------------------------------
		// [CPS_CNI-0042] CCC VVD & SKD Inquiry
		// ---------------------------------------------------------------------------    
		else if ("CpsCni0042Event".equalsIgnoreCase(eventName)) {							
			// [Save]
			if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchVvdSkdList(e);			
			} 
		}
		
		
		// ===========================================================================
		// 정행룡
		// ===========================================================================
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0004] Handler History
		// ---------------------------------------------------------------------------		
		else if ("CpsCni0004Event".equalsIgnoreCase(eventName)) {
			// [Retrieve , Open]
			if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchHandlerHistoryList(e);
			}
		}
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0005] Manager History
		// ---------------------------------------------------------------------------		
		else if ("CpsCni0005Event".equalsIgnoreCase(eventName)) {
			log.debug("CpsCni0005Event");				
			// [Save]
			if (cmd.isCommand(FormCommand.MULTI)) {
				return manageManagerHistory(e);
			// [Retrieve , Open]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST02)) {
				return searchManagerHistoryList(e);
			}
		}	
		// ===========================================================================
		// 양정란
		// ===========================================================================
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0007] Office Code Table
		// ---------------------------------------------------------------------------		
		else if ("CpsCni0007Event".equalsIgnoreCase(eventName)) {
							
			if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				
				return searchMdmOrganization(e);
			
			}

		}
		
		
		// ===========================================================================
		// 박제성
		// ===========================================================================
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0039] Class Code Creation
		// ---------------------------------------------------------------------------		
		else if ("CpsCni0039Event".equalsIgnoreCase(eventName)) {
							
			// [Save]
			if (cmd.isCommand(FormCommand.MULTI)) {
				return manageClassCode(e);	
			// [Retrieve , Open]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchClassCode(e);	
			} else if (cmd.isCommand(FormCommand.PRINT)) {
				return printClassCode(e);
			}

		}
		
		// ===========================================================================
		// 박제성
		// ===========================================================================
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0028] Miscellaneous Code Creation
		// ---------------------------------------------------------------------------		
		else if ("CpsCni0028Event".equalsIgnoreCase(eventName)) {
							
			// [Save]
			if (cmd.isCommand(FormCommand.MULTI)) {
				return manageMiscCode(e);	
			// [Retrieve , Open]
			} else if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchMiscCode(e);
	
			} else if (cmd.isCommand(FormCommand.INIT)) {
				return initMiscCode(e);
			}
		}
		// ===========================================================================
		// 박제성
		// ===========================================================================
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0029] Miscellaneous Code Inquiry
		// ---------------------------------------------------------------------------		
		else if ("CpsCni0029Event".equalsIgnoreCase(eventName)) {
					
			// [Retrieve , Open]
			if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchMiscCodeInq(e);
			// [Grid Row]
			} else if (cmd.isCommand(FormCommand.PRINT)) {
				return printMiscCode(e);
			} else if (cmd.isCommand(FormCommand.INIT)) {
				return initMiscCode(e);
			}
		}
		// ===========================================================================
		// 윤세영
		// ===========================================================================
		// ---------------------------------------------------------------------------
		// File Attach
		// ---------------------------------------------------------------------------		
		else if ("CniFileEvent".equalsIgnoreCase(eventName)) {
			log.debug("CniFileEvent");				
			// [Save]
			if (cmd.isCommand(FormCommand.MULTI)) {
				return manageFileDwcInsurance(e);
			}
		}
		// ===========================================================================
		// 진윤오
		// ===========================================================================
		// ---------------------------------------------------------------------------
		// [CPS_CNI_0095] Main Code-Popup
		// ---------------------------------------------------------------------------
		else if ("CpsCni0095Event".equalsIgnoreCase(eventName)) {							
			// [Open]
			if (cmd.isCommand(FormCommand.SEARCHLIST01)) {
				return searchPartyPopupList(e);
			// [Save]
			} 
		}	

//		else if (e.getEventName().equalsIgnoreCase("CpsCni0096Event")) {
		else if ("CpsCni0096Event".equalsIgnoreCase(eventName)) {
//			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			if (cmd.isCommand(FormCommand.SEARCH)) {
//				eventResponse = searchCNIUserRoleInfoList(e);
				return  searchCNIUserRoleInfoList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				return  searchRoleDesc(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                return  manageCNIUserRoleInfoList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH22)) {
                return  checkUserID(e);		// User ID 존재 여부 확인
            }		
		}

		//return eventResponse;		2011-11-18 [소스품질 조치사항]객체에 null이 배정된 이후 객체에 대한 참조를 하지 말아야 한다.
		return null;
	}
	// ===========================================================================
	// 진윤오
	// ===========================================================================
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0095] Main Code Popup
	// ---------------------------------------------------------------------------

	/**
	 * Claim Party 정보 조회<br>
	 * @author 이준범
	 * @category CPS_CNI_0095
	 * @category searchPartyPopupList 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPartyPopupList(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try {		
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();	
			CpsCni0095Event event = (CpsCni0095Event)e;
			// Claim Party NO		
			String ptyNm = event.getPtyNm();

			
			// Party 정보 취득
			List<PartyInquiryVO> list = command.searchPartyPopupList(ptyNm);		
			eventResponse.setRsVoList(list);			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}	
	// ===========================================================================
	// 진윤오
	// ===========================================================================
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0025] Main Code Creation
	// ---------------------------------------------------------------------------

	/**
	 * Claim Party 정보 및 Contact Point 정보 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0025
	 * @category searchPartyContactPoint 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPartyContactPoint(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try {		
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();	
			CpsCni0025Event event = (CpsCni0025Event)e;
			// Claim Party NO		
			String clmPtyNo = event.getClmPtyNo();
			// Party 정보 취득
			PartyVO partyVO = command.searchPartyInfo(clmPtyNo);		
			eventResponse.setRsVo(partyVO);			
			// Contact Point List 취득
			List<ContactPointVO> list = command.searchContactPointList(clmPtyNo);		
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Claim Party 정보 및 Contact Point  수정 ,입력<br>
	 * @author 진윤오
	 * @category CPS_CNI_0025
	 * @category managePartyNContactPoint 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePartyContactPoint(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		try {
			
			begin();
			
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
	
			CpsCni0025Event event = (CpsCni0025Event)e;
			// party 컨테이너 VO		
			PartyCntVO partyCntVO = event.getPartyCntVO();
			
			//사용자 정보 설정
			CniPartyVO cniPartyVO = partyCntVO.getCniPartyVO();
			String usrId = account.getUsr_id();		
			cniPartyVO.setUpdUsrId(usrId);
			cniPartyVO.setCreUsrId(usrId);
					
			// Contact Point List 취득
			String clmPtyNo  = command.managePartyContactPoint(partyCntVO);			
			eventResponse.setETCData("CLM_PTY_NO", clmPtyNo);			
			// 성공 메세지설정
			eventResponse.setUserMessage(new ErrorHandler("CNI00008")
					.getUserMessage());
			
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	
	
		return eventResponse;
	}	
		

	
	/**
	 * Claim Party 정보 및 Contact Point  수정 ,입력<br>
	 * @author 진윤오
	 * @category CPS_CNI_0025
	 * @category removePartyContactPoint 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeParty(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		try {
			
			begin();
			
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
	
			CpsCni0025Event event = (CpsCni0025Event)e;
			
			//사용자 정보 설정
			CniPartyVO cniPartyVO = new CniPartyVO();
			String usrId = account.getUsr_id();		
			cniPartyVO.setUpdUsrId(usrId);
			cniPartyVO.setClmPtyNo(event.getClmPtyNo());
			
			// Contact Point List 취득
			command.removeParty(cniPartyVO);			
						
			// 성공 메세지설정
			//CNI00010	Data was deleted successfully.
			eventResponse.setUserMessage(new ErrorHandler("CNI00010")
					.getUserMessage());
			
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	
	
		return eventResponse;
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0026] Main Code-Inquiry
	// ---------------------------------------------------------------------------
	/**
	 * Claim Party 리스트 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0026
	 * @category searchPartyInquiryList 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPartyInquiryList(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		try {
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
	
			CpsCni0026Event event = (CpsCni0026Event)e;
			
			// 검색 조건 
			PartyInquiryCondVO partyInquiryCondVO = event.getPartyInquiryCondVO();
			
			// Party Inquiry  List 취득
			List<PartyInquiryVO> list = 
				command.searchPartyInquiryList(partyInquiryCondVO);		
			eventResponse.setRsVoList(list);		
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}		
	

	// ---------------------------------------------------------------------------
	// [CPS_CNI_0084] Main Code-Inquiry Print
	// ---------------------------------------------------------------------------
	/**
	 * Claim Party 리스트 프린트<br>
	 * @author 진윤오
	 * @category CPS_CNI_0084
	 * @category printPartyInquiryList 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse printPartyInquiryList(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try {
			
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();	
			CpsCni0026Event event = (CpsCni0026Event)e;			
			
			// 검색 조건 
			PartyInquiryCondVO partyInquiryCondVO = event.getPartyInquiryCondVO();
			
			// Party Inquiry  List 취득
			List<PartyInquiryVO> list = 
				command.searchPartyInquiryList(partyInquiryCondVO);		
			
		    StringWriter sw = new StringWriter();
		    PrintWriter pw = new PrintWriter(sw);
		    
	//	    clm_pty_abbr_nm
	//	    pty_nm
	//	    loc_cd
	//	    cre_usr_id
	//	    cre_ofc_cd
	//	    upd_usr_id
	//	    phn_no
	//	    fax_no
	//	    pty_eml
			//통계정보 페이지 
			for (int i = 0; i < list.size(); i++) {			
				PartyInquiryVO vo = list.get(i);
				pw.print(vo.getClmPtyAbbrNm()+SP); 
				pw.print(vo.getPtyNm()+SP); 
				pw.print(vo.getLocCd()+SP);			
				pw.print(vo.getCreUsrId()+SP);
				pw.print(vo.getCreOfcCd()+SP);
				pw.print(vo.getUpdDt()+SP);
				pw.print(vo.getIntlPhnNo()+SP);
				pw.print(vo.getPhnNo()+SP);
				pw.print(vo.getIntlFaxNo()+SP);
				pw.print(vo.getFaxNo()+SP);
				pw.println(vo.getPtyEml()+SP);			
			}
					
			eventResponse.setCustomData(CniConst.RD, sw.toString());
		
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
		
	}			
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0011] File Upload
	// ---------------------------------------------------------------------------	
	/**
	 * File Upload 수정 ,입력<br>
	 * @author 진윤오
	 * @category CPS_CNI_0011
	 * @category manageFileUpload 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageFileUpload(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		try {
			
			begin();
			
			// BC 객체 생성
			FileMgtBC command = new FileMgtBCImpl();
	
			CpsCni0011Event event = (CpsCni0011Event)e;
			
			CniAtchFileVO[] cniAtchFileVOs = event.getCniAtchFileVOs();
			CniAtchFileVO vo = cniAtchFileVOs[0];
			vo.setCreUsrId(account.getUsr_id());
			vo.setUpdUsrId(account.getUsr_id());
			
			command.manageFileUpload(cniAtchFileVOs);
			
			// 성공 메세지설정			
			eventResponse.setUserMessage(new ErrorHandler("CNI00008")
					.getUserMessage());
			
			eventResponse.setETCData("ERROR_YN", "N");
			
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	
	
		return eventResponse;
	}		
	
	
	/**
	 * File Upload 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0011
	 * @category searchFileUploadList 
	 * @param e  Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFileUploadList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try {			
			// BC 객체 생성
			FileMgtBC command = new FileMgtBCImpl();
			
			CpsCni0011Event event = (CpsCni0011Event)e;
			
			List<FileUploadVO> list = 
				command.searchFileUploadList(event.getFileUploadCondVO());			
			
			eventResponse.setRsVoList(list);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI-0042] 
	// ---------------------------------------------------------------------------    
    /**
     * CCC VVD & SKD Inquiry 
	 * vvd  Vessel schedule 리스트 조회<br>
	 * @author 진윤오
	 * @category CPS_CNI_0042
	 * @category searchVvdSkdList 
	 * @param e  Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVvdSkdList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try {			
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
			
			CpsCni0042Event event = (CpsCni0042Event)e;
			
			List<VvdSkdVO> list = 
				command.searchVvdSkdList(event.getVvdSkdCondVO());			
			
			eventResponse.setRsVoList(list);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}		
	// ===========================================================================
	// 정행룡
	// ===========================================================================
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0004] Handler History
	// ---------------------------------------------------------------------------

	/**
	 * Cargo Claim No Handler History 정보 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0004
	 * @category searchHandlerHistoryList 
	 * @param e  Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHandlerHistoryList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try {
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
			
			CpsCni0004Event event = (CpsCni0004Event)e;
			
			// Cargo Claim No 조회		
			String cgoClmNo = event.getCgoClmNo();
			
			// Manager Handler Division Cd 
			String mgrHdlrDivCd =  event.getMgrHdlrDivCd();
			
			// Handler History 목록 조회
			List<HandlerHistoryVO> list = command.searchHandlerHistoryList(cgoClmNo, mgrHdlrDivCd);		
			
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0005] Manager History
	// ---------------------------------------------------------------------------

	/**
	 * Cargo Claim No Manager History 정보 조회<br>
	 * @author 정행룡
	 * @category CPS_CNI_0005
	 * @category searchManagerHistoryList 
	 * @param e  Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManagerHistoryList(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		try {
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
			
			CpsCni0005Event event = (CpsCni0005Event)e;
			
			// Cargo Claim No 조회		
			String cgoClmNo = event.getCgoClmNo();
			
			// Manager Handler Division Cd 
			String mgrHdlrDivCd =  event.getMgrHdlrDivCd();
			
			// Handler History 목록 조회
			List<HandlerHistoryVO> list = command.searchManagerHistoryList(cgoClmNo, mgrHdlrDivCd);		
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}	
		return eventResponse;
	}	
	
	/**
	 * Manager History 등록, 수정, 삭제<br>
	 * @author 정행룡
	 * @category CPS_CNI_0005
	 * @category manageManagerHistory 
	 * @param e  Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManagerHistory(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		CodeMgtBC command = new CodeMgtBCImpl();

		CpsCni0005Event event = (CpsCni0005Event)e;
				
		try {			
			begin();

			// event관련 사용자정보 insert
			HandlerHistoryVO[] handlerHistoryVOs =  event.handlerHistoryVOs();
			
			for(int i=0; i < handlerHistoryVOs.length; i++) {
				//사용자 설정
				handlerHistoryVOs[i].setCreUsrId(account.getUsr_id());
				handlerHistoryVOs[i].setUpdUsrId(account.getUsr_id());
			}
			
			command.manageManagerHistory(handlerHistoryVOs);
			
			// 성공메세지설정
			eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());
			
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}


	
	// ===========================================================================
	// 양정란
	// ===========================================================================
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0007] Office Code Table
	// ---------------------------------------------------------------------------	
	
	/**
	 * Office Code 정보 조회<br>
	 * @author 양정란
	 * @category CPS_CNI_0007
	 * @category searchMdmOrganization 
	 * @param e  Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmOrganization(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		CodeMgtBC command = new CodeMgtBCImpl();

		CpsCni0007Event event = (CpsCni0007Event)e;
		
		// Office Code	
		String ofcCd = event.getOfcCd();		
		
		// Office Code 정보 취득
		List<MdmOrganizationVO> list = command.searchMdmOrganizationList(ofcCd);	
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}
	
	
	// ===========================================================================
	// 박제성
	// ===========================================================================
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0039] Class Code Creation
	// ---------------------------------------------------------------------------

	/**
	 * Class Code 정보 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0039
	 * @category searchClassCode 
	 * @param e  Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchClassCode(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		try {	
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();					
			// Class Code List 취득
			List<ClassCodeVO> list = command.searchClassCodeList();		
			eventResponse.setRsVoList(list);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Class Code  수정 ,입력<br>
	 * @author 박제성
	 * @category CPS_CNI_0039
	 * @category manageClassCode 
	 * @param e  Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageClassCode(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		CodeMgtBC command = new CodeMgtBCImpl();

		CpsCni0039Event event = (CpsCni0039Event)e;
				
		try {			
			begin();
						
			CniClassCodeVO[] cniClassCodeVOs =  event.getCniClassCodeVOs();
			
			for(int i=0; i<cniClassCodeVOs.length; i++) {
				//사용자 설정
				cniClassCodeVOs[i].setCreUsrId(account.getUsr_id());
				cniClassCodeVOs[i].setUpdUsrId(account.getUsr_id());
				cniClassCodeVOs[i].setCreOfcCd(account.getOfc_cd());
			}
			
			command.manageClassCode(cniClassCodeVOs);
			
			// 에러메세지설정
			eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());			
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback(); 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0091] Class Code Creation Print
	// ---------------------------------------------------------------------------

	/**
	 * Class Code 리스트 프린트<br>
	 * @author 박제성
	 * @category CPS_CNI_0091
	 * @category printClassCode 
	 * @param e  Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse printClassCode(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {	
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();		
					
			// Class Code List 취득
			List<ClassCodeVO> list = command.searchClassCodeList();		
			eventResponse.setRsVoList(list);		
			
		    StringWriter sw = new StringWriter();
		    PrintWriter pw = new PrintWriter(sw);
		    	   	    
			for (int i = 0; i < list.size(); i++) {			
				ClassCodeVO vo = list.get(i);
				pw.print(vo.getClssClmMiscCd()+SP); 
				pw.print(vo.getClssClmMiscNm() +SP); 					
				pw.print(vo.getCreUsrId()+SP);
				pw.print(vo.getCreOfcCd()+SP);
				pw.print(vo.getUpdDt()+SP);			
				pw.println(vo.getClssClmMiscRmk()+SP);			
			}
					
			eventResponse.setCustomData(CniConst.RD, sw.toString());
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	
	// ===========================================================================
	// 박제성
	// ===========================================================================
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0028] Miscellaneous Code Creation
	// ---------------------------------------------------------------------------

	/**
	 * Miscellaneous Code 정보 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0028
	 * @category initMiscCode 
	 * @param e  Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse initMiscCode(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		try {
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
			// Class Code List 취득
			List<ClassCodeVO> list = command.searchClassCodeList();		
			eventResponse.setRsVoList(list);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Miscellaneous Code 정보 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0028
	 * @category searchMiscCode 
	 * @param e  Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMiscCode(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		try {
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
	
			CpsCni0028Event event = (CpsCni0028Event)e;
			
			String clssClmMiscCd = event.getClssClmMiscCd();
			String clmMiscCd = event.getClmMiscCd();
			String clmMiscNm = event.getClmMiscNm();
					
			// Misc Code List 취득
			List<MiscCodeVO> list = command.searchMiscCodeList(clssClmMiscCd,clmMiscCd,clmMiscNm);		
			eventResponse.setRsVoList(list);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Miscellaneous Code 정보 조회<br>
	 * @author 박제성
	 * @category CPS_CNI_0029
	 * @category searchMiscCodeInq 
	 * @param e  Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMiscCodeInq(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		try {
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
	
			CpsCni0029Event event = (CpsCni0029Event)e;
			
			String clssClmMiscCd = event.getClssClmMiscCd();
			String clmMiscCd = event.getClmMiscCd();
			String clmMiscNm = event.getClmMiscNm();		
					
			// Misc Code List 취득
			List<MiscCodeVO> list = command.searchMiscCodeList(clssClmMiscCd,clmMiscCd,clmMiscNm);		
			eventResponse.setRsVoList(list);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Miscellaneous Code  수정 ,입력<br>
	 * @author 박제성
	 * @category CPS_CNI_0028
	 * @category manageMiscCode 
	 * @param e  Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMiscCode(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		// BC 객체 생성
		CodeMgtBC command = new CodeMgtBCImpl();

		CpsCni0028Event event = (CpsCni0028Event)e;
				
		try {			
			begin();
			
			// event관련 사용자정보 insert
			CniMiscCodeVO[] cniMiscCodeVOs =  event.getCniMiscCodeVOs();
			for(int i=0; i<cniMiscCodeVOs.length; i++) {
				//사용자 설정
				cniMiscCodeVOs[i].setCreUsrId(account.getUsr_id());
				cniMiscCodeVOs[i].setUpdUsrId(account.getUsr_id());
				cniMiscCodeVOs[i].setCreOfcCd(account.getOfc_cd());
			}
			
			command.manageMiscCode(cniMiscCodeVOs);
			
			// 에러메세지설정
			eventResponse.setUserMessage(new ErrorHandler("CNI00008").getUserMessage());			
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Dry Wet Claim & Insurance File를 생성 및 변경한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageFileDwcInsurance(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CniFileEvent event = (CniFileEvent)e;
		FileMgtBC command = new FileMgtBCImpl();
		try{
			begin();
			
			List<String> keys = event.getKeys();
			CustomFileDwcInsuranceVO[] customFileDwcInsuranceVOs = event.getCustomFileDwcInsuranceVOS();
			for ( int i=0; i<customFileDwcInsuranceVOs .length; i++ ) {
				customFileDwcInsuranceVOs[i].setFileNm(URLDecoder.decode(customFileDwcInsuranceVOs[i].getFileNm(),"UTF-8"));
				customFileDwcInsuranceVOs[i].setFileDesc(URLDecoder.decode(customFileDwcInsuranceVOs[i].getFileDesc(),"UTF-8"));
				customFileDwcInsuranceVOs[i].setInsurTpCd(URLDecoder.decode(customFileDwcInsuranceVOs[i].getInsurTpCd(),"UTF-8"));
				customFileDwcInsuranceVOs[i].setInstInsurTpCd(URLDecoder.decode(customFileDwcInsuranceVOs[i].getInstInsurTpCd(),"UTF-8"));
				customFileDwcInsuranceVOs[i].setInstPrmInsurTpCd(URLDecoder.decode(customFileDwcInsuranceVOs[i].getInstPrmInsurTpCd(),"UTF-8"));
			}
			command.manageFileDwcInsurance(customFileDwcInsuranceVOs, keys, account.getUsr_id());
	
			//Insurance
			if (event.getCustomFileDwcInsuranceVOS()[0].getDwClmNo().equals("")) {
				List<SearchFileInsuranceListVO> searchFileInsuranceListVO = null;
				String clmFileTpCd = customFileDwcInsuranceVOs[0].getClmFileTpCd();
				if (clmFileTpCd.equals("040109") || clmFileTpCd.equals("040110")) {//Premium
					searchFileInsuranceListVO = command.searchFileInsuranceList(customFileDwcInsuranceVOs[0].getInstInsurTpCd(), customFileDwcInsuranceVOs[0].getInstInsurPlcyYr(), customFileDwcInsuranceVOs[0].getInsurClmPtyNo(), customFileDwcInsuranceVOs[0].getInstPrmInsurTpCd(), clmFileTpCd);
				} else {//Insurance Main
					searchFileInsuranceListVO = command.searchFileInsuranceList(customFileDwcInsuranceVOs[0].getInsurTpCd(), customFileDwcInsuranceVOs[0].getInsurPlcyYr(), customFileDwcInsuranceVOs[0].getInsurClmPtyNo(), customFileDwcInsuranceVOs[0].getInstPrmInsurTpCd(), clmFileTpCd);
				}
				eventResponse.setRsVoList(searchFileInsuranceListVO);
			} else {//Dry Wet Claim
				List<SearchFileDwcInsuranceListVO> searchFileDwcInsuranceListVO = command.searchFileDwcInsuranceList(customFileDwcInsuranceVOs[0].getDwClmNo());
				eventResponse.setRsVoList(searchFileDwcInsuranceListVO);
			}

			commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	// ---------------------------------------------------------------------------
	// [CPS_CNI_0085] Miscellaneous Code Inquiry-Print
	// ---------------------------------------------------------------------------
	/**
	 * Miscellaneous Code Inquiry-Print<br>
	 * @author 박제성
	 * @category CPS_CNI_0085
	 * @category printMiscCode 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse printMiscCode(Event e) throws EventException {
		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try {
			
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();	
			CpsCni0029Event event = (CpsCni0029Event)e;			
			
			String clssClmMiscCd = event.getClssClmMiscCd();
			String clmMiscCd = event.getClmMiscCd();
			String clmMiscNm = event.getClmMiscNm();
			
			// Misc Code List 취득
			List<MiscCodeVO> list = command.searchMiscCodeList(clssClmMiscCd,clmMiscCd,clmMiscNm);		
						
		    StringWriter sw = new StringWriter();
		    PrintWriter pw = new PrintWriter(sw);

			//통계정보 페이지 
			for (int i = 0; i < list.size(); i++) {			
				MiscCodeVO vo = list.get(i);
				pw.print(vo.getClmMiscCd()+SP); 
				pw.print(vo.getClmMiscNm()+SP); 				
				pw.print(vo.getCreUsrId()+SP);
				pw.print(vo.getCreOfcCd()+SP);
				pw.print(vo.getUpdDt()+SP);
							
				pw.println(vo.getClmMiscRmk()+SP);	
			}
											
			eventResponse.setCustomData(CniConst.RD, sw.toString());
		
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
		
	}			

	/**
	 * [CPS_CNI_0096] : [search] <br>
	 * 사용자의 Role정보를 조회 합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCNIUserRoleInfoList(Event e) throws EventException {
		CodeMgtBC command = new CodeMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CniUsrRoleMtchVO cniUsrRoleMtchVO = new CniUsrRoleMtchVO();
		CpsCni0096Event event = (CpsCni0096Event)e;
		
		try{
			String usrId = (String)event.getAttribute("usr_id");
			String usrRoleCd = (String)event.getAttribute("usr_role_cd");
			
			cniUsrRoleMtchVO.setUsrId(usrId);
			cniUsrRoleMtchVO.setUsrRoleCd(usrRoleCd);
	         
			List<CniUsrRoleMtchVO> list = command.searchCNIUserRoleInfoList(cniUsrRoleMtchVO);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error(ex.getMessage(),ex);
			throw ex;
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new EventException(ex.getMessage(), ex);
		}	
		
		return eventResponse;
	}
	
	/**
	 * CPS_CNI_0096 : Save<br>
	 * 사용자의 Role정보를 생성, 삭제 합니다. <br> 
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCNIUserRoleInfoList(Event e) throws EventException {
		CodeMgtBC command = new CodeMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CpsCni0096Event event = (CpsCni0096Event)e;
		try{
			begin();
  			command.manageCNIUserRoleInfoList(event.getCniUsrRoleMtchVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("DMT00001").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * User ID가 등록되어 있는지 확인한다.<br>
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse checkUserID(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CommonFinderBC command = new CommonFinderBCImpl();
		String usrId ="";
		
		try {
			if (e instanceof CpsCni0096Event) {
				CpsCni0096Event event = (CpsCni0096Event)e;
				usrId = (String)event.getAttribute("usr_id");
			}
			
			// User ID 에 Offfic Code가 리턴된다.
  			String rtnStr = command.searchUserOfcCd(usrId);
  			String rtnVal = "Y";
  			
  			if (rtnStr.equals("")) {
  				rtnVal = "N";
  			}
  			
  			eventResponse.setETCData("EXISTS_FLAG", rtnVal);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * CPS_CNI_0096 : Save<br>
	 * 사용자의 Role Code Description을 조회합니다. <br> 
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRoleDesc(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		try{
		
			// BC 객체 생성
			CodeMgtBC command = new CodeMgtBCImpl();
	        CpsCni0096Event event = (CpsCni0096Event)e;

	        String roleCd = (String)event.getAttribute("role_code");
			
			log.debug("roleCd = " + roleCd);
			String isExist = command.searchRoleDesc(roleCd);
			eventResponse.setETCData("EXIST", isExist);
		
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CNI99999").getMessage(), ex);
		}
		
		return eventResponse;
	}	

}