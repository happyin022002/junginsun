/*=========================================================
 *Copyright(c) 2006
 *@FileName : SignOnFilter.java
 *@FileTitle : Signon filter
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-08-24
 *@LastModifier : Hoesoo_Jang
 *@LastVersion : 1.1
 * 2006-08-24 Hoesoo_Jang
 * 1.0 최초생성
 * 1.1 사용자 계정 현 업무에 맞게 수정
=========================================================*/

// 향후 SSO에 맞게 구현하려면 autoLogin 과 SSO 를 구현해야 한다. - J.H.S 2006.08.30
package com.hanjin.framework.support.view.signon.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.config.ResourceManager;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.controller.util.WebKeys;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.CommonWebKeys;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.view.signon.SignOnFacade;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.support.view.signon.dao.UserDAO;
import com.hanjin.framework.support.view.signon.exception.InvalidPasswordException;
import com.hanjin.framework.support.view.signon.exception.SignOnDAOFinderException;
import com.tobesoft.iam.utility.TBHttpUtil;
import com.tobesoft.iam.virtualagent.TBVirtualAgent;
import com.tobesoft.iam.virtualagent.TBVirtualConfig;

/**
 * SignOn에 관련하여 모든 처리를 담당하는 Filter 권한 체크와 Flow 처리를 담당한다.
 * 
 * @author 장회수
 * @see
 * @since 1.4
 */
public class SignOnFilter implements Filter {

	/**
	 * 환경 변수 값을 읽어들여 초기화 수행 환경 변수 리스트 : 1. 권한 체크 여부 2. signon-config.xml 3. 중복
	 * 로그인 여부 4. 세션 서버명(JNDI명)
	 * 
	 * @param config
	 * @throws ServletException
	 */
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		URL signOnConfigResourcesURL = null;
		try {

			signOnConfigResourcesURL = ResourceManager.getInstance().getURL(config.getServletContext(), "SIGNON-CONFIG");

			if (signOnConfigResourcesURL == null) {
				log.fatal("Can't find SIGNON-CONFIG id in the resource manager.");
				throw new RuntimeException("Can't find SIGNON-CONFIG id in the resource manager.");
			}

			SignOnConfigFileDAO dao = new SignOnConfigFileDAO(signOnConfigResourcesURL);

			signOnErrorPage = dao.getSignOnErrorPage();
			signOnPage = dao.getSignOnPage();
			signMainPage = dao.getSignMainPage();
			signOnNoAuthorityPage = dao.getSignOnNoAuthorityPage();
			adminPageUrl = dao.getAdminPageUrl();

			unProtectedResources = dao.getUnProtectedResources();
			firstPageResources = dao.getFirstResources();
			nonLoginedResources = dao.getNonLoginedResources();
			autoLoginedResources = dao.getAutoLoginedResources();
			//******************** Redirect 기능추가	************************
			//2013.03.15 ADD
			redirectLoginedResource = dao.getRedirectLoginedResources();
			
			//******************** ITSM AutoLogin 및 Redirect URL 기능추가(9300만 적용)	************************
			//2013.06.26 ADD
			autoLoginAndRedirectReferURLResources = dao.getAutoLoginAndRedirectReferURLResources();
			
			/////////////////////////////////////////////////////////////////
			/*
			 * ==================================================================
			 * ========== 권한 체크여부 여부 값 읽기 1. 서블릿 세션에 키값 보관 true 이면
			 * ==============
			 * ==============================================================
			 */
			// 제거 필요
			String auth = (String) config.getInitParameter(AUTHORIZED_CHECK_STRING);
			String history = (String) config.getInitParameter(ACCESS_HISTORY_STRING);
			config.getServletContext().setAttribute(CommonWebKeys.AUTHORIZED_CHEDK, auth);
			

			
			if (auth != null && auth.equalsIgnoreCase("true")) {
				authorizedCheck = true;
			}
			if (history != null && history.equalsIgnoreCase("true")) {
				accessHistory = true;
			}

			if (log.isDebugEnabled()) {
				StringBuffer sb = new StringBuffer();
				sb.append("------------------------------------------------------" + "\n");
				sb.append("     Signon Filter Parameter                          " + "\n");
				sb.append("------------------------------------------------------" + "\n");
				sb.append("Validation Role      : " + authorizedCheck + "\n"); // 권한
				// 검증
				sb.append("Login Error URL: " + signOnErrorPage + "\n");
				sb.append("------------------------------------------------------" + "\n");
				log.debug(sb.toString());
			}

		} catch (Exception ex) {
			log.error("SignonFilter: malformed URL exception: ", ex);
			throw new RuntimeException(ex.getMessage());
		}
	}

	/**
	 * <pre>
	 *   사용자 인증처리, 프로그램 사용 권한 관리 처리
	 *   성공조건: (사용자 인증=true) and (프로그램 사용권한=true)
	 * </pre>
	 * 
	 * @param request
	 * @param response
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try{
			// 사용자 인증 및 권한 검사 시작
			if (log.isDebugEnabled())
				log.debug("***  Start inspection audit and user authentication");
	
			HttpServletRequest hreq = (HttpServletRequest) request;
			HttpServletResponse hres = (HttpServletResponse) response;
			String currentURL = hreq.getRequestURI();

	
			// Context root 부분을 requestURI를 분석해서 가져온다.
			String context_root = hreq.getRequestURI();
			context_root = context_root.substring(0, context_root.indexOf("/", 1) + 1);
			//log.debug("context_root11111111=" + context_root);
		

			//******************** 개발 ,Live SSL 적용  START	************************
			//2010.06.11 ADD
			//ALPS LIVE, TEST SERVER 적용
			// SSL USE Y/N
			// 로그인 페이지 일부만 SSL 적용
			// SSL 사용한다면 flow
			 sslUse = SiteConfigFactory.get("COM.SSL.USE","");
			 sslPort = SiteConfigFactory.get("COM.SSL.PORT","");
			 noSslPort = SiteConfigFactory.get("COM.NOSSL.PORT","");

			 if(sslUse.equalsIgnoreCase("0"))
			{				
				// PORT 정보 및 URL
				String reqSvr = hreq.getServerName();
				String reqSvrPort = Integer.toString(hreq.getServerPort());	
				
				noSSLUrl = "http://" + reqSvr;
				
				//SSL 사용 PORT가 존재한다면 추가
				if((noSslPort!=null )&&(noSslPort.length()!=0)&&(noSslPort != ""))
					noSSLUrl = "http://" + reqSvr +  ":" + noSslPort;
			}
				//log.debug("noSSLUrl=" + noSSLUrl);
		
			//******************** 개발 ,Live SSL 적용  END  ************************
			
			
			if (log.isDebugEnabled()) {
				log.debug("currentURL=" + currentURL);
			}
			/*
			 * ======================================================================
			 * ====== 현재 호출한 .do, .screen URL을 request 속성으로 저장 - 김성욱
			 * ==================
			 * ==========================================================
			 */
	
			int iDOFind = currentURL.lastIndexOf(".do");
			int iGSDOFind = currentURL.lastIndexOf("GS.do");
			int iScreenFind = currentURL.lastIndexOf(".screen");
			if (iScreenFind > 0) {
				if (request.getAttribute(CommonWebKeys.CURRENT_URL) == null)
					request.setAttribute(CommonWebKeys.CURRENT_URL, currentURL.substring(0, iScreenFind + 7));
			}
	
			int FIRST_SLASH = currentURL.indexOf("/", 1);
			String targetURL = null;
	
			if (FIRST_SLASH != -1) {
				targetURL = currentURL.substring(FIRST_SLASH + 1, currentURL.length());
				if (log.isDebugEnabled())
					log.debug("targetURL=" + targetURL);
			} else {
				targetURL = currentURL;
			}
	
			/*
			 * ======================================================================
			 * ====== 세션 서버 존재 하지 않으므로 일단 세션서버에서 확인 하는 것은 제외 - 장회수
			 * ==================
			 * ==========================================================
			 */
			if ((targetURL != null) && targetURL.contains(FORM_SIGNON_URL_SSO)) {
				/*
				 * ==================================================================
				 * ========== SSO 관련 추가 2007.02.15 김성욱 SSO 인증 후 처리 - SSO 정책서버에 로긴정보를
				 * 업데이트
				 * ==============================================================
				 * ==============
				 */
				auditSSO(request);
	
				// 로그인 유형 : SSO 또는 LOCAL
				hreq.getSession().setAttribute(CommonWebKeys.FORM_LOGIN_TYPE, "SSO");
	
				// 사용자 로컬 인증처리
				validateSignOn(request, response, chain);
				return;
			} else if ((targetURL != null) && targetURL.contains(FORM_SIGNON_URL)) {
				// 로그인 유형 : SSO 또는 LOCAL
				hreq.getSession().setAttribute(CommonWebKeys.FORM_LOGIN_TYPE, "LOCAL");
				
				// 사용자 로컬 인증처리
				validateSignOn(request, response, chain);
				return;
			}
			
//			String no_login = (String) hreq.getParameter("nologin"); 
//			if(no_login.equals("Y")){				
//				// 로그인 유형 : SSO 또는 LOCAL
//				hreq.getSession().setAttribute(CommonWebKeys.FORM_LOGIN_TYPE, "LOCAL");
//				hreq.setAttribute(FORM_USER_ID, "2004611"); 
//				hreq.setAttribute(FORM_PASSWORD, "qwer1234");
//				
//				// 사용자 로컬 인증처리
//				validateSignOn(request, response, chain);
//				return;
//				
//			}
	
			// 이미 로그인 되어있는가?
			boolean isSignedOn = false;
			if (hreq.getSession().getAttribute(SIGNED_ON_USER) != null) {
				isSignedOn = ((Boolean) hreq.getSession().getAttribute(SIGNED_ON_USER)).booleanValue();
			} else {
				hreq.getSession().setAttribute(SIGNED_ON_USER, new Boolean(false));
			}
	
			if (log.isDebugEnabled())
				log.debug("signedOn:" + isSignedOn);
	
			// 프로그램ID 구하기
			String progId = getRequestURI(targetURL);
			if (log.isDebugEnabled())
				log.debug("Program ID [" + progId + "]");
			
	
			/*
			 * ======================================================================
			 * ====== 예외 처리 . 로그인이 필요없는 프로그램 Pass
			 * ====================================
			 * ========================================
			 */
			//log.debug("bbbb=" + targetURL);
			//if(targetURL.trim().indexOf("SignOn.do")>-1)
			//{
			//String reqSvr = hreq.getServerName();
			//String reqSvrPort = Integer.toString(hreq.getServerPort());	
			//String newUrl = "http://" + reqSvr + ":" + reqSvrPort;
			//hres.sendRedirect(newUrl + hreq.getRequestURI());
			//hres.sendRedirect(newUrl + context_root + signOnPage);
			//log.debug("aaaa=" + newUrl);
			//}

			if (isNonLoginedResource(progId)) {
				if (log.isDebugEnabled())
					log.debug("Program ID that is not needed to login : " + progId);
				chain.doFilter(request, response);
				return;
			}
			//log.debug("bbbb=" + targetURL);

			/*
			 * ======================================================================
			 * ====== 권한 체크 if 사용자 인증(로그인여부)= true then 권한 체크 권한체크=true then 다음
			 * Filter로 이동 =false then 권한 없음 에러 페이지로 이동 else 사용자 인증 페이지로 이동
			 * ==========
			 * ==================================================================
			 */
			if (isSignedOn) {
				if (log.isDebugEnabled())
					log.debug("Immediately Login User");
				// 권한 체크를 해야 하는 경우라면... 즉, web.xml에 <param-value>true</param-value>
				// 로 셋팅 했다면
				// 권한 체크에 대한 Rule이 생기고 나면 param에 체크를 한다.
				// 현재 한진 사이트의 경우는 SignOnFilter2 에만 param을 true로 주면 될것으로 보임
				// .do 에서만 체크를 하게 되므로- 권한 관리 프로그램에서
				if (iDOFind > 0) {
					if (authorizedCheck) {
						if (log.isDebugEnabled())
							log.debug("Start Authorization "); // 권한 검증 시작
						/*
						 * ==========================================================
						 * ==== ============== 프로그램에 대한 권한체크 & 로그인 되어있으나 권한 체크 필요없는
						 * 프로그램인지 검사 ==
						 * ==============================================
						 * ============== ==============
						 */
						boolean authorized = authCheckProcess(request, progId);
						if ( iGSDOFind > 0 ) authorized = true;
	
						// authorized가 true면 UnProtected Program이다.
						if (!authorized) {
							if (log.isDebugEnabled())
								log.debug("*** Trying to access to an unauthorized page " + "signOnNoAuthorityPage:[" + signOnNoAuthorityPage + "]");
							if (signOnNoAuthorityPage != null) {
								hres.sendRedirect(noSSLUrl+ context_root + signOnNoAuthorityPage);
							} else {
								hres.sendRedirect(noSSLUrl+ context_root + getSignOnErrorPage((String) hreq.getSession().getAttribute(CommonWebKeys.FORM_LOGIN_TYPE)) + "?FORM_MESSAGE="
										+ URLEncoder.encode("No Authority!", ENCODING_STRING));
							}
							return;
						}
					}
					if ("IBLeaders IBSheet".equals(hreq.getHeader("USER-AGENT"))) {
						request.setAttribute(CommonWebKeys.CURRENT_URL, currentURL);
					} else if (hreq.getParameter("AJAX") != null) {
						request.setAttribute(CommonWebKeys.CURRENT_URL, currentURL);
					} else {
						String fromMenu = request.getParameter("MENU");
						/* added by jun
						 * 2011 11 01
						 * 네비게이션 버그 수정 위해서 where 조건에 들어갈 조건 값 하나 더 추가함.
						 * 해당 메뉴의 부모 메뉴 id 값 추가함.
						 * param parentsId 요청 메뉴의 부모 메뉴 번호
						 */
						String parentsId = request.getParameter("pid");
						
						SignOnFacade signOn = new SignOnFacade();
						String[] uiInfo = signOn.getUiInfo(progId, parentsId);
						request.setAttribute("UI_NUMBER", progId);
						request.setAttribute("UI_TITLE", uiInfo[0]);
						request.setAttribute("UI_DESCRIPTION", uiInfo[1]);
						request.setAttribute("UI_NAVIGATION", uiInfo[2]);
						String menuUrl = uiInfo[3];
						if (menuUrl==null||menuUrl.equals("")||fromMenu==null) menuUrl = currentURL.substring(0, iDOFind + 3);
						request.setAttribute(CommonWebKeys.CURRENT_URL, menuUrl.substring(0, menuUrl.indexOf(".do")+3));
					}
					
					// accessHistory
					if ( accessHistory ) {
						SignOnUserAccount account = (SignOnUserAccount) hreq.getSession().getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
						String pgmNo = "";
						if ( progId.length() > 20 ) pgmNo = progId.substring(0, 20);
						else pgmNo = progId;
						try {
							
							/* BKG NO 조회할 수 있는 권한 체크 */
							String bkgNo = null;
							if(hreq.getParameterMap().containsKey("bkg_no"))
								bkgNo = hreq.getParameter("bkg_no");
							
							if(bkgNo != null && bkgNo.isEmpty() && hreq.getParameterMap().containsKey("bl_no"))
								bkgNo = hreq.getParameter("bl_no").replaceAll("W", "");
							
							if(bkgNo != null && !bkgNo.isEmpty() && bkgNo.length() < 15 && (new BookingUtil().bkgSecuritySearchCk(bkgNo, hreq, "BKG_MAIN", pgmNo, account)).equals("Y")){
								response.setContentType("text/xml; charset=UTF-8");
								PrintWriter writer = response.getWriter();
								StringBuilder xml = new StringBuilder();
								xml.append("<ERROR>\n");
								xml.append("<ETC-DATA>\n");
								xml.append("<ETC KEY='" + WebKeys.TRANS_RESULT_KEY + "'> <![CDATA[F]]></ETC>\n");
								xml.append("<ETC KEY='Exception'> <![CDATA[]]></ETC>\n");
								xml.append("</ETC-DATA>\n");
								xml.append("<MESSAGE> <![CDATA[You are not authorized to view " + bkgNo + "]]> </MESSAGE>\n");	
								xml.append("</ERROR>\n");	
								writer.write(xml.toString());
								return;
							}
							
			                (new UserDAO()).writeAccessHistory(account.getUsr_id(), pgmNo, (FormCommand.fromRequest(hreq)).getCommand(), account.getOfc_cd());
		                }
		                catch (DAOException ex) {
			                ex.printStackTrace();
		                }
					}
				} else {
					chain.doFilter(request, response);
					return;
				}
				
				
				/*
				 * ==================================================================
				 * ========== 날짜 : 2009-04-24 내용 : office change 기능의 사용에 따른 화면
				 * office_cd 와 session office_cd 비교 필요
				 * ==============================
				 * ==============================================
				 */
				// Office Change 기능 Y N
				String ocYN = (SiteConfigFactory.get(SiteConfigFactory.SYSTEM_OC_YN) == null) ? "N" : SiteConfigFactory.get(SiteConfigFactory.SYSTEM_OC_YN);
	
				if ("Y".equals(ocYN)) {
					String current_ofc_cd = (hreq.getParameter("current_ofc_cd") == null ? "" : hreq.getParameter("current_ofc_cd")); // 화면에서
					// 존재하는
					// office code
					log.debug("current_ofc_cd : " + current_ofc_cd);
					if (current_ofc_cd.length() > 0) {
						SignOnUserAccount account = (SignOnUserAccount) hreq.getSession().getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
						log.debug("account.getOfc_cd : " + account.getOfc_cd());
						log.debug("url : " + adminPageUrl);
	
						// IB시트 Request와 일반 Request 구분
						String userAgent = hreq.getHeader("USER-AGENT");
	
						if (!current_ofc_cd.equals(account.getOfc_cd())) {
							if ("IBLeaders IBSheet".equals(userAgent)) {
								StringBuffer sb = new StringBuffer();
								sb.append("<?xml version=\"1.0\"  ?>");
								sb.append("<SHEET SERVER-MSG=\"You tried to change office code ...  Upcoming window will move to Main Page.\">");
								sb.append("</SHEET>");
								// request.setAttribute(WebKeys.EXCEPTION_OBJECT,
								// new EventException(sb.toString()));
								response.getWriter().println(sb.toString());
							} else {
								StringBuffer sb = new StringBuffer();
								sb.append("<script>");
								sb.append("alert(\"You tried to change office code ...  Please wait and login again in upcoming window.\");");
								sb.append("</script>");
								response.getWriter().println(sb.toString());
								hres.sendRedirect(noSSLUrl+ context_root + signMainPage);
							}
							return;
						}
					}
	
					/*
					 * ==============================================================
					 * ============== Office Change 기능 수행 시, cng_ofc_flg가 "Y"로 넘어옴.
					 * ==
					 * ============================================================
					 * ==============
					 */
					String cng_ofc_flg = (hreq.getParameter("cng_ofc_flg") == null ? "N" : hreq.getParameter("cng_ofc_flg"));
					if ("Y".equals(cng_ofc_flg)) {
						String cng_ofc_cd = request.getParameter("cng_ofc_cd");
						UserDAO dao = new UserDAO();
						try {
							DBRowSet rowset = dao.getOfcInfo(cng_ofc_cd);
							SignOnUserAccount account = (SignOnUserAccount) hreq.getSession().getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
							if (rowset.next()) {
								account.setOfc_cd(cng_ofc_cd);
								account.setOfc_eng_nm(rowset.getString("OFC_ENG_NM"));
								account.setOfc_krn_nm(rowset.getString("OFC_KRN_NM"));
								account.setRhq_ofc_cd(rowset.getString("AR_HD_QTR_OFC_CD"));
								hreq.getSession().setAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT, account);
							}
						} catch (DAOException e) {
							log.error(e.getMessage(), e);
						} catch (SQLException se) {
							log.error(se.getMessage(), se);
						}
	
					}
				}
	
				chain.doFilter(request, response);
				return;
			} else { // 로그인 되 있지 않은 경우는 login.jsp로 보낸다.
				
				
				//String reqSvr = hreq.getServerName();
				//String reqSvrPort = Integer.toString(hreq.getServerPort());	
				//targetURL = "http://" + reqSvr + ":" + reqSvrPort;
				//log.debug("targetURL1111=" + targetURL);
				
				if (log.isDebugEnabled())
					log.debug("targetURL=" + targetURL);
	
				String userAgent = hreq.getHeader("USER-AGENT");
				if ("IBLeaders IBSheet".equals(userAgent)) {
					// if(currentURL.indexOf("GS.do")>0){ // IBSheet가 request한 경우는
					// 세션이 끊겼다고 xml로 Write 한다.
					try {
						response.setContentType("text/xml; charset=UTF-8");
	
						PrintWriter writer = response.getWriter();
						StringBuilder xml = new StringBuilder();
						xml.append("<SHEET SERVER-MSG='Session is disconnected!'>\n");
						xml.append("</SHEET>\n");
						writer.write(xml.toString());
					} catch (Exception ex) {
						log.error(ex.getMessage(), ex);
					}
				} else { // HTML이 request한 경우 login 페이지로 forward한다.
					// config.getServletContext().getRequestDispatcher("/" +
					// signOnPage).forward(request, response);
					//******************** Redirect 기능추가	************************
					//2013.03.15 ADD

					redirectURL ="";						
					//log.debug("redirectURL = [" + hreq.getRequestURI() + "]");
					if (isRedirectLoginedResource(getRedirectURI(currentURL))) {
						// targetURL = signMainPage;
						//log.debug("redirectURLYN = 0");
						String strparam = (hreq.getQueryString() == null ? "" : "?"+ hreq.getQueryString()); 

						redirectURL ="?redirectURL="+URLEncoder.encode(hreq.getRequestURI()+strparam,ENCODING_STRING);
					}
					
					//******************** Redirect 기능추가	End ************************
						
					
					// SSL USE Y/N
					if(sslUse.equalsIgnoreCase("0"))
					{
						//log.debug("signOnPage1111=" + signOnPage);
						// reqSvr = hreq.getServerName();
						// reqSvrPort = sslPort; //Integer.toString(hreq.getServerPort());	
		 			     
						//if(reqSvrPort.indexOf(sslPort)> -1)
						//	hres.sendRedirect("https://" + reqSvr + ":" + reqSvrPort + context_root + signOnPage);
						//else
						////	hres.sendRedirect("https://" + reqSvr + context_root + signOnPage);
						hres.sendRedirect(noSSLUrl+ context_root + signOnPage+redirectURL);
						//hres.sendRedirect(context_root + signOnPage);
					}
					else
					{
						hres.sendRedirect(noSSLUrl+ context_root + signOnPage+redirectURL);
						//hres.sendRedirect(context_root + signOnPage);
					}
				} 
			}
		}catch(Exception e){
			log.error(e.getMessage(), e);
			try {
				response.setContentType("text/xml; charset=UTF-8");

				PrintWriter writer = response.getWriter();
				StringBuilder xml = new StringBuilder();
				xml.append("<ERROR>\n");
				xml.append("<ETC-DATA>\n");
				xml.append("<ETC KEY='" + WebKeys.TRANS_RESULT_KEY + "'> <![CDATA[F]]></ETC>\n");
				xml.append("<ETC KEY='Exception'> <![CDATA[]]></ETC>\n");
				xml.append("</ETC-DATA>\n");
				xml.append("<MESSAGE> <![CDATA[Unexpected system error took place during data processing. Please try again later.]]> </MESSAGE>\n");	
				xml.append("</ERROR>\n");	
//				xml.append("<SHEET SERVER-MSG='Unexpected system error took place during data processing. Please try again later.'>\n");
//				xml.append("</SHEET>\n");
				writer.write(xml.toString());
			} catch (Exception ex) {
				log.error(ex.getMessage(), ex);
			}
		}
	}

	/**
	 * 사용자 인증 처리 및 메인 페이지로 이동
	 * 
	 * @param request
	 * @param response
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 */
	public void validateSignOn(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// convert to com.hanjin.framework.component.message http servlet
		// request for now
		HttpServletRequest hreq = (HttpServletRequest) request;
		HttpServletResponse hres = (HttpServletResponse) response;
		String loginType = (String) hreq.getSession().getAttribute(CommonWebKeys.FORM_LOGIN_TYPE);

		String userid = "";
		String password = "";

		/*
		 * ======================================================================
		 * ====== SSO 로긴인 경우엔 패스워드 값이 전달되지 않고, 로컬로그인처리할 때도 아이디만으로 로그인을 수행한다
		 * LOCAL 로긴인 경우엔 아이디와 패스워드로 로그인을 수행한다
		 * ====================================
		 * ========================================
		 */
		if (log.isDebugEnabled())
			log.debug("================================validateSignOn================================");
		if (loginType.equals("SSO")) {
			// TBVirtualAgent VA = new TBVirtualAgent();
			userid = TBHttpUtil.getHeader(FORM_USER_ID_SSO, hreq);
			password = TBHttpUtil.getHeader(FORM_PASSWORD_SSO, hreq);
			if (log.isDebugEnabled()) {
				log.debug("================================luid-" + userid);
				log.debug("================================lupw-" + password);
			}
		} else {
			userid = hreq.getParameter(FORM_USER_ID);
			String form_pw = hreq.getParameter(FORM_PASSWORD);

			// site-config.properties에 설정된 COM.HANJIN.SSO.ENABLED 상수 체크(added by
			// Roh, 20070625)
			// => TRUE가 아닌 경우, Password Decryption 안함
			// local signon 인 경우 패스워드 암호화 작업을 하지 않음
			// updated by desis 2009.08.10 (김기용cjn 요청)
			// String ssoEnabled =
			// SiteConfigFactory.get(SiteConfigFactory.SSO_ENABLED);
			// if("TRUE".equals(ssoEnabled)) {
			// TBVirtualAgent VA = new TBVirtualAgent();
			// password = (String)VA.encrypt(form_pw);
			// } else {
			// password = form_pw;
			// }
			
			 //updated by desis 2010.04.23 PRS domain 분리 global 계정 local login enable
			String ssoLocalLoginEnabled = SiteConfigFactory.get("COM.HANJIN.SSO.LOCAL.LOGIN.ENABLED");
			if ("TRUE".equals(ssoLocalLoginEnabled)) {
				TBVirtualAgent VA = new TBVirtualAgent();
				password = (String) VA.encrypt(form_pw);
			} else {
				password = form_pw;
			}

			if (log.isDebugEnabled()) {
				log.debug("================================userid-" + userid);
				log.debug("================================form_pw-" + form_pw);
				log.debug("================================password-" + password);
			}
		}

		// cookie를 사용하는 경우에 j_remember_username 파라미터 값을 form에서 전달하여 사용하게 된다.
		String rememberUserId = hreq.getParameter(REMEMBER_USERID);

		if (rememberUserId != null) {
			Cookie userIdCookie = new Cookie(COOKIE_NAME, userid);
			userIdCookie.setMaxAge(2678400);
			hres.addCookie(userIdCookie);
		} else {
			// see if the cookie exists and remove accordingly
			Cookie[] cookies = hreq.getCookies();
			if (cookies != null) {
				for (int loop = 0; loop < cookies.length; loop++) {
					if (cookies[loop].getName().equals(COOKIE_NAME)) {
						cookies[loop].setMaxAge(0);
						hres.addCookie(cookies[loop]);
					}
				}
			}
		}

		// 로그인 당시의 사용자 IP,인코딩 정보
		hreq.getSession().setAttribute(SIGNED_ON_CHARACTER_ENCODING, hreq.getCharacterEncoding());
		hreq.getSession().setAttribute(SIGNED_ON_REMOTE_ADDR, hreq.getRemoteAddr());

		SignOnFacade signOn = new SignOnFacade();

		// Context root 부분을 requestURI를 분석해서 가져온다.
		String context_root = hreq.getRequestURI();
		context_root = context_root.substring(0, context_root.indexOf("/", 1) + 1);
		//log.debug("context_root=" + context_root);

		try {


			boolean authenticated = signOn.authenticate(userid, password, loginType);
			
			//local 로그인 인경우 WAS 정보 확인
			//2012.08.09 heo			
			if (!loginType.equals("SSO")) {

				 java.util.Properties props = System.getProperties();
				 log.error("Weblogic JVM Name : " + props.getProperty("weblogic.Name"));		
				 log.error("authenticated : " + authenticated);		
				 log.error("userid : " + userid);		
			}

			if (authenticated) {
				// place com.hanjin.framework.component.message true boolean in
				// the session
				if (hreq.getSession().getAttribute(USER_ID) != null) {
					hreq.getSession().removeAttribute(USER_ID);
				}
				hreq.getSession().setAttribute(USER_ID, userid);

				// remove the sign on user key before putting it back in

				if (hreq.getSession().getAttribute(SIGNED_ON_USER) != null) {
					hreq.getSession().removeAttribute(SIGNED_ON_USER);
				}

				hreq.getSession().setAttribute(SIGNED_ON_USER, new Boolean(true));

				String targetURL = null;

				if (isTargetForMainPage(targetURL)) {
					// targetURL = signMainPage;
					targetURL = context_root + signMainPage;

					if (log.isDebugEnabled())
						log.debug("Forwarding to a main page [" + targetURL + "]");
				}
				
				//******************** redirect 적용	************************
				// 해당 redirecURL이 있으면 redirect
				redirectURL = (hreq.getParameter("redirectURL") == null ? "" : hreq.getParameter("redirectURL")); 
				log.debug("redirectURL [" + getRedirectURI(redirectURL) + "]");
				
				// ITSM 에서의 호출인 경우
				String REFERER = hreq.getHeader("referer");
				log.debug("boolean" + isAutoLoginAndRedirectReferURLResources(REFERER));
				if(isAutoLoginAndRedirectReferURLResources(REFERER) || isRedirectLoginedResource(getRedirectURI(redirectURL))) {					
					log.debug("redirectURLYN = 0");
					// targetURL = signMainPage;
					int lastDotLoc = redirectURL.lastIndexOf("/");
					if (lastDotLoc > 0) {
						String strURL = redirectURL.substring(lastDotLoc+1, redirectURL.length());
						redirectURL = strURL;
					}
					targetURL = context_root + redirectURL;
				}
				//==============================================================

				/*
				 * ==============================================================
				 * ============== 사용자 단일 계정으로 변경 후에는 관리자페이지 포워딩이 없어지기 때문에 아래
				 * 관리자페이지 분기처리문이 삭제되어야 한다 2007.04.27 eNIS 관리자페이지 자동분기 취소
				 * ========
				 * ======================================================
				 * ==============
				 */
				if ("BMS".equals((String) SiteConfigFactory.get(SiteConfigFactory.SYSTEM_TYPE)) && signOn.isAdmin()) {
					if (log.isDebugEnabled())
						log.debug("Forwarding to a admin page [" + adminPageUrl + "]");
					//hres.sendRedirect(noSSLUrl+ context_root + signOnPage);
					targetURL = context_root + adminPageUrl;
					// targetURL = adminPageUrl;
					// hres.sendRedirect( adminPageUrl );
					// return;
				}

				if (log.isDebugEnabled())
					log.debug("A body page to be forwarded finally [" + targetURL + "]");

				//log.debug("loagin_aaaa" + noSSLUrl+ targetURL);
				//redirect start
				hres.sendRedirect(noSSLUrl+ targetURL);
				
				return;
			} else {
				if (log.isDebugEnabled())
					log.debug("The password is not correct!");
				//hres.sendRedirect(noSSLUrl+ context_root + signOnPage);
				hres.sendRedirect(noSSLUrl+ context_root + getSignOnErrorPage(loginType) + "?FORM_MESSAGE=" + URLEncoder.encode("The ID or Password value is not correct!", ENCODING_STRING));
				return;
			}
		} catch (InvalidPasswordException ie) {
			if (log.isDebugEnabled())
				log.debug("Password Error", ie);
			hres.sendRedirect(noSSLUrl+ context_root + getSignOnErrorPage(loginType) + "?FORM_MESSAGE=" + URLEncoder.encode(ie.getMessage(), ENCODING_STRING));
			return;
		} catch (SignOnDAOFinderException fe) {
			if (log.isDebugEnabled())
				log.debug("Can't find the corresponding user!", fe);

			hres.sendRedirect(noSSLUrl+ context_root + getSignOnErrorPage(loginType) + "?FORM_MESSAGE=" + URLEncoder.encode(fe.getMessage(), ENCODING_STRING));

			return;
		} catch (Exception e) {
			log.error("An error occurred while processing login ", e);

			hres.sendRedirect(noSSLUrl+ context_root + getSignOnErrorPage(loginType) + "?FORM_MESSAGE=" + URLEncoder.encode("An error occurred while processing login", ENCODING_STRING));

			return;
		}
	}

	/**
	 * 권한 체크 프로세스
	 * 
	 * 매 리쿼스트마다 콜이 되므로 병목현상이 발생할 수 있음 향후 세션을 어떻게 할 것인가를 결정해야 할것
	 * 
	 * @param request
	 * @param progId
	 * @return true/false
	 * @throws IOException
	 * @throws ServletException
	 */
	public boolean authCheckProcess(ServletRequest request, String progId) throws IOException, ServletException {
		boolean authorized = false;
		SignOnFacade signOn = null;
		HttpServletRequest hreq = null;
		try {
			// login 되어있되 Protect 하지 않아야 할 프로그램 ID
			if (isUnprotectedResource(progId)) {
				// Protect 하지 않아야 할 프로그램
				return true;
			}
			hreq = (HttpServletRequest) request;
			SignOnUserAccount account = (SignOnUserAccount) hreq.getSession().getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
			signOn = new SignOnFacade();
			authorized = signOn.isAuthorized(account.getUsr_id(), progId, account.getOfc_cd());
			return authorized;
		} catch (Exception ex) {
			log.error("An error occurred while checking authority ", ex);
			return false;
		} finally {
			signOn = null;
		}
	}

	/**
	 * 메인 페이지를 위한 타겟인가?
	 * 
	 * @param urnString
	 * @return
	 */
	private boolean isTargetForMainPage(String urnString) {
		boolean retValue = false;
		if (urnString == null) {
			retValue = true;
		} else if (firstPageResources == null) {
			retValue = true;
		} else if (firstPageResources.containsKey(urnString)) {
			retValue = true;
		}
		return retValue;
	}

	/**
	 * 로그인이 되어있되 권한검증이 필요없는 리소스
	 * 
	 * @param prog_id
	 * @return
	 */
	private boolean isUnprotectedResource(String prog_id) {
		boolean retValue = false;
		if (prog_id == null) {
			retValue = true;
		} else if (unProtectedResources == null) {
			retValue = true;
		} else if (unProtectedResources.containsKey(prog_id)) {
			retValue = true;
		}
		return retValue;
	}

	/**
	 * 로그인이 필요없는 프로그램 id인가?
	 * 
	 * @param prog_id
	 * @return
	 */
	private boolean isNonLoginedResource(String prog_id) {
		if (log.isDebugEnabled())
			log.debug("Program ID that is not needed to login: " + prog_id);
		boolean retValue = false;
		if (prog_id == null) {
			retValue = false;
		} else if (nonLoginedResources == null) {
			retValue = false;
		} else if (nonLoginedResources.containsKey(prog_id)) {
			retValue = true;
		}
		if (log.isDebugEnabled())
			log.debug("A checking value of program ID that is not needed to login: " + retValue);
		return retValue;
	}

	/**
	 * redirectURL 리소스
	 * 
	 * @param prog_id
	 * @return
	 */
	//******************** Redirect 기능추가	************************
	//2013.03.15 ADD
	private boolean isRedirectLoginedResource(String prog_id) {
		log.debug("isRedirectLoginedResource: " + prog_id);
		
	boolean retValue = false;
		if (prog_id == null) {
			retValue = false;
		} else if (redirectLoginedResource == null) {
			//log.debug("redirectLoginedResource: NULL");
			retValue = false;
		} else if (redirectLoginedResource.containsKey(prog_id)) {
			//log.debug("redirectLoginedResource: true");
			retValue = true;
		}
		return retValue;
	}
	//******************** Redirect 기능추가	END************************
	
	
	/**
	 * isAutoLoginAndRedirectReferURLResources 리소스
	 * 
	 * @param prog_id
	 * @return
	 */
	//******************** ITSM AutoLogin 및 Redirect URL 기능추가(9300만 적용)	************************
	//2013.06.26 ADD
	private boolean isAutoLoginAndRedirectReferURLResources(String prog_id) {
		log.debug("isAutoLoginAndRedirectReferURLResources: " + prog_id);
		
	boolean retValue = false;
		if (prog_id == null) {
			retValue = false;
		} else if (autoLoginAndRedirectReferURLResources == null) {
			retValue = false;
		} else if (autoLoginAndRedirectReferURLResources != null & autoLoginAndRedirectReferURLResources.size() == 0 ) {
			retValue = false;
		} else {
			Iterator<String> autoLoginAndRedirectReferURLResourcesIterator = autoLoginAndRedirectReferURLResources.keySet().iterator();
			while(autoLoginAndRedirectReferURLResourcesIterator.hasNext()){
				String urlKey = autoLoginAndRedirectReferURLResourcesIterator.next();
				if(prog_id.contains(urlKey)){
					log.debug("isAutoLoginAndRedirectReferURLResources contains: " + prog_id);
					retValue = true;
				}
			}
		}
		
		return retValue;
	}
	//******************** Redirect 기능추가	END************************
	
	/**
	 * SSO 인증 처리 후 정책서버에 등록
	 * 
	 * @param request
	 * @param response
	 * @param chain
	 * @return boolean SSO 성공여부
	 * @throws IOException
	 * @throws ServletException
	 */
	public boolean auditSSO(ServletRequest request) throws IOException, ServletException {
		HttpServletRequest hreq = (HttpServletRequest) request;

		/** 0. VirtualAgent 초기화 */
		if (log.isDebugEnabled())
			log.debug("================================Initialize SSO VirtualAgent================================");
		TBVirtualAgent VA = new TBVirtualAgent();
		TBVirtualConfig VC = VA.getConfig();

		/** 1. Sub-System Audit */
		if (log.isDebugEnabled())
			log.debug("================================Audit SSO Sub-System================================");
		String SMSESSION = TBHttpUtil.getCookie(VC.getSessionName(), hreq);
		String clientIp = hreq.getHeader("Client-ip");
		if (clientIp == null)
			clientIp = hreq.getHeader("WL-Proxy-Client-IP");
		if (clientIp == null)
			clientIp = hreq.getHeader("Proxy-Client-IP");
		if (clientIp == null)
			clientIp = hreq.getHeader("X-Forwarded-For");
		if (clientIp == null)
			clientIp = hreq.getRemoteAddr();
		boolean ssoAuditResult = VA.ssoAudit(SMSESSION, "LOGIN", clientIp);

		if (ssoAuditResult) {
			if (log.isDebugEnabled())
				log.debug("================================SSO Audit is completed!================================");
			return true;
		} else {
			if (log.isDebugEnabled())
				log.debug("================================SSO Audit is failed!================================");
			/*
			 * hres.sendRedirect(signOnErrorPage + "?FORM_MESSAGE=" +
			 * URLEncoder.encode("SSO Audit is failed!", ENCODING_STRING));
			 */
			return false;
		}
	}

	
	/**
	 * Request 에서 요청하는 URI
	 * 
	 * @param targetURL
	 * @return
	 */
	// Synchronized method lock the execution of the method. Change synchronized
	// to nonsynchronized.
	// Oct,16th,2008 by seungyol lee.
	private String getRequestURI(String targetURL) {
		String progId = "";

		// 마지막 .를 찾는 것으로 변경함.
		int lastDotLoc = targetURL.lastIndexOf(".");
		if (lastDotLoc > 0) {
			progId = targetURL.substring(0, lastDotLoc);
		}
		int gsLoc = progId.lastIndexOf("GS");
		if ( gsLoc > 0 ) {
			progId = progId.substring(0, gsLoc);
		}
		return progId;
	}

	/**
	 * 로그인 실패시 이동할 페이지를 요청
	 * 
	 * @param loginType
	 * @return
	 */
	private String getSignOnErrorPage(String loginType) {
		String result = signOnErrorPage;
		if (loginType != null && loginType.equalsIgnoreCase("LOCAL")) {
			result = FORM_LOCAL_LOGIN_URL;
		}

		return result;
	}


	/**
	 * Request 에서 요청하는 URI
	 * 
	 * @param targetURL
	 * @return
	 */
	// Synchronized method lock the execution of the method. Change synchronized
	// 
	// 
	//******************** Redirect 기능추가	************************
	//2013.03.15 ADD
	private String getRedirectURI(String strURL) {
		String progId = "";

		int iDOFind = strURL.lastIndexOf(".do");
		int iGSDOFind = strURL.lastIndexOf("GS.do");
		int iScreenFind = strURL.lastIndexOf(".screen");

		int gsLoc = strURL.lastIndexOf("?");
		if ( gsLoc > 0 ) {
			strURL = strURL.substring(0, gsLoc);
		}
		
		int FIRST_SLASH = strURL.indexOf("/", 1);

		if (FIRST_SLASH != -1) {
			progId = strURL.substring(FIRST_SLASH + 1, strURL.length());
			if (log.isDebugEnabled())
				log.debug("strURL=" + progId);
		} else {
			progId = strURL;
		}
		return progId;
	}
	//******************** Redirect 기능추가	END************************

	/**
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		config = null;
		if (log.isDebugEnabled())
			log.debug("FilterConfig Unload");
	}

	private org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(this.getClass().getName());

	public static final String FORM_SIGNON_URL_SSO = "j_signon_check_sso.do";
	public static final String FORM_SIGNON_URL = "j_signon_check.do";
	public static final String FORM_LOCAL_LOGIN_URL = "SignOnLocal.do";

	// SSO 관련 UI 입력필드명 변경
	// 2007.02.15
	// 김성욱
	public static final String FORM_USER_ID_SSO = "luid";
	public static final String FORM_PASSWORD_SSO = "lupw";
	public static final String FORM_USER_ID = "j_username";
	public static final String FORM_PASSWORD = "j_password";
	public static final String FORM_LOGIN_TYPE = "loginType";

	public static final String REMEMBER_USERID = "j_remember_username";

	public static final String USER_ID = "j_signon_username";

	public static final String SIGNED_ON_USER = "j_signon";

	public static final String COOKIE_NAME = "bp_signon";

	public static final String AUTHORIZED_CHECK_STRING = "authorizedcheck";

	public static final String ACCESS_HISTORY_STRING = "accesshistory";

	public static final String SIGNED_ON_CHARACTER_ENCODING = "t_character_endoding";

	public static final String SIGNED_ON_REMOTE_ADDR = "t_remote_address";

	private static final String ENCODING_STRING = "UTF-8";

	private HashMap firstPageResources;

	private HashMap nonLoginedResources;

	private HashMap autoLoginedResources;

	private HashMap unProtectedResources;

	/** Redirect 기능추가	 */
	private HashMap redirectLoginedResource;  // redirect URL
	
	/** ITSM 화면 연동 - Rehearsal(9300) 사이트에만 적용 */
	private HashMap autoLoginAndRedirectReferURLResources;
	
	
	/** 메인 페이지 URL 지역변수 */
	private String signMainPage = null;

	/** FilterConfig */
	private FilterConfig config = null;

	/** 인증 페이지 */
	private String signOnPage = null;

	/** 인증 실패 페이지 URL 지역변수 */
	private String signOnErrorPage = null;

	/** 권한 없음 페이지 로컬 변수 */
	private String signOnNoAuthorityPage = null;

	/** 권한 관리 여부 */
	private boolean authorizedCheck = false;

	/** 접근 기록 여부 */
	private boolean accessHistory = false;

	/** 관리자 페이지 */
	private String adminPageUrl = null;

	/** No SSL http 
	 * SSL 사용 시 PORT 적용이 필요한 경우를 위한 config
	 * SSL PORT가 따로 존재하는 경우에 config에 등록
	 * */
	private String noSSLUrl = "";
	private String sslUse = ""; 
	private String sslPort = ""; 
	private String noSslPort = "";  
	private String redirectURL = "";  
}

