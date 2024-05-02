/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MenuProcessor.java
*@FileTitle : 메뉴관련 처리프로세서
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-22
*@LastModifier : SeongWook Kim
*@LastVersion : 1.0
* 2006-08-11 SeongWook Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.syscommon.common.menu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.support.controller.html.CommonWebKeys;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.menu.dao.MenuDBDAO;

/**
 * Menu Creation Business Logic ServiceCommand<br>
 * - Menu Creation에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author SeongWook Kim
 * @see MenuBean,MenuEventResponse,MenuDBDAO 참조
 * @since J2EE 1.4
 */
public class MenuProcessor {

	protected transient org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass().getName());

	/**
	 * ServletContext
	 */
	private ServletContext context;
	/**
	 * MenuDBDAO
	 */
	private MenuDBDAO menuDao = null;


	/**
	 * 프로세서 생성자
	 */
	public MenuProcessor() {
	}

	/**
	 * 프로세서 초기화 수행
	 * 업무 시나리오 선행작업<br>
	 * Menu업무 시나리오 호출시 관련 내부객체 생성<br>
	 * @param context
	 */
	public void init(ServletContext context) {
		this.context = context;
		menuDao = new MenuDBDAO();
	}

	/**
	 * 업무 시나리오 마감작업<br>
	 * Menu업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		menuDao = null;
	}

	/**
	 * 메뉴 정보를 조회한다.
	 * 권한을 체크 여부에 따라 필터링을 수행한다.
	 * @param request
	 * @param programId 프로그램ID
	 * @throws java.lang.Exception
	 */
	public void processEvent(HttpServletRequest request, String programId) throws Exception {
		processEvent(request, programId, 7);
	}

	/**
	 * 메뉴 정보를 조회한다.
	 * 권한을 체크 여부에 따라 필터링을 수행한다.
	 * @param request HttpServletRequest
	 * @param programId 프로그램ID
	 * @param depth 조회할 메뉴레벨
	 * @throws java.lang.Exception
	 */
	public void processEvent(HttpServletRequest request, String programId, int depth) throws Exception {
		HttpSession session = request.getSession(false);
		ServletContext context = session.getServletContext();
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		//String center_yn;
		String systemId = programId;
/*
		if (account != null) {
			center_yn = account.getCenter_yn().trim();
			if (center_yn.equals("")) {
				center_result = "branch";
			} else if (center_yn.equalsIgnoreCase("y")) {
				center_result = "center";
			} else {
				center_result = "branch";
			}
		}
*/

		//권한 체크여부에 따른 메뉴 필터링
		String auth = (String) context.getAttribute(CommonWebKeys.AUTHORIZED_CHEDK);
		String userId = account.getUsr_id();
		String ofcCd = account.getOfc_cd();
		String systemCd = account.getAccess_system();
		
		if (systemCd.equals("SPP")) ofcCd = "SELPIO";
		
		boolean authorizedCheck = false;
		if (auth != null && auth.equalsIgnoreCase("true")) {
			authorizedCheck = true;
		}

		Collection menuList = null;

		MenuEventResponse response = null;
		try {
			if (authorizedCheck) {
				if(depth<1){
					menuList = menuDao.getMenuListWithAuth(systemId, programId, userId, ofcCd);
				}else{
					menuList = menuDao.getMenuListWithAuth(systemId, programId, userId, ofcCd, depth);
				}
			} else {
				//menuList = menuDao.getMenuList(center_result, screenName);
				//매우 주의 > 아래 꼭 수정해야함
				if(depth<1){
					menuList = menuDao.getMenuListWithAuth(systemId, programId, userId, ofcCd);
				}else{
					menuList = menuDao.getMenuListWithAuth(systemId, programId, userId, ofcCd, depth);
				}
			}
			response = new MenuEventResponse(menuList);
			request.setAttribute("MenuEventResponse", response);
		} catch (Exception ex) {
			log.error(new ErrorHandler("FRM10201", ex.getMessage()).printMessage(true));
		}
	}

	/**
	 * 좌측메뉴 정보를 조회한다.
	 * 권한을 체크 여부에 따라 필터링을 수행한다.
	 * @param request
	 * @param programId 프로그램ID
	 * @throws java.lang.Exception
	 */
	public void processEventLeftMenu(HttpServletRequest request, String programId) throws Exception {
		processEventLeftMenu(request, programId, 7);
	}

	/**
	 * 좌측메뉴 정보를 조회한다.
	 * 권한을 체크 여부에 따라 필터링을 수행한다.
	 * @param request HttpServletRequest
	 * @param programId 프로그램ID
	 * @param depth 조회할 메뉴레벨
	 * @throws java.lang.Exception
	 */
	public void processEventLeftMenu(HttpServletRequest request, String programId, int depth) throws Exception {
		HttpSession session = request.getSession(false);
		ServletContext context = session.getServletContext();
		SignOnUserAccount account = (SignOnUserAccount) session.getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
		String systemId = programId;

		//권한 체크여부에 따른 메뉴 필터링
		String auth = (String) context.getAttribute(CommonWebKeys.AUTHORIZED_CHEDK);
		String userId = account.getUsr_id();
		boolean authorizedCheck = false;
		if (auth != null && auth.equalsIgnoreCase("true")) {
			authorizedCheck = true;
		}

		Collection menuList = null;

		MenuEventResponse response = null;
		try {
			if (authorizedCheck) {
				if(depth<1){
					menuList = menuDao.getLeftMenuListWithAuth(systemId, programId, userId, 7);
				}else{
					menuList = menuDao.getLeftMenuListWithAuth(systemId, programId, userId, depth);
				}
			} else {
				//menuList = menuDao.getMenuList(center_result, screenName);
				//매우 주의 > 아래 꼭 수정해야함
				if(depth<1){
					menuList = menuDao.getLeftMenuListWithAuth(systemId, programId, userId, 7);
				}else{
					menuList = menuDao.getLeftMenuListWithAuth(systemId, programId, userId, depth);
				}
			}
			response = new MenuEventResponse(menuList);
			request.setAttribute("MenuEventResponse", response);
		} catch (Exception ex) {
			log.error(new ErrorHandler("FRM10201", ex.getMessage()).printMessage(true));
		}
	}

	/**
	 * 타이틀 및 네비게이션 정보를 조회한다.
	 * 
	 * @param request
	 * @throws java.lang.Exception
	 */
	public void processEventNavigation(HttpServletRequest request) throws Exception {
		String pgmNo = request.getParameter("pgmNo");
		String pid = request.getParameter("pid");
		
		HashMap<String, String> menuInfo = new HashMap<String, String>();
		String[] info = menuDao.getUiInfo(pgmNo,pid);
		menuInfo.put("title", info[0]);
		menuInfo.put("description", info[1]);
		menuInfo.put("navigation", info[2]);
		request.setAttribute("MenuInformation", menuInfo);
	}

	/**
	 * 이웃 모듈 정보를 조회한다.
	 * 
	 * @param request
	 * @throws java.lang.Exception
	 */
	public void processEventSiblingMenu(HttpServletRequest request) throws Exception {
		String pgmNo = request.getParameter("pgmNo");
		ArrayList<MenuBean> menuInfo = menuDao.getSiblingMenu(pgmNo);
		request.setAttribute("SiblingInformation", menuInfo);
	}
}

