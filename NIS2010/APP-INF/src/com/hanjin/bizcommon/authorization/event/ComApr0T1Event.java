/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ComApr0T1Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.08
*@LastModifier : 심성윤
*@LastVersion : 1.0
* 2015.07.08 심성윤
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.authorization.event;

import java.util.Arrays;

import com.hanjin.bizcommon.authorization.vo.AuthorizationCommonVO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationProgramInfoVO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationRouteVO;
import com.hanjin.bizcommon.authorization.vo.SearchAuthAproVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
//import com.hanjin.bizcommon.authorization.vo.AuthorizationCsrVO;
//import com.hanjin.bizcommon.authorization.vo.AuthorizationStaffVO;


/**
 * COM_APR_0T1 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - COM_APR_0T1HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 심성윤
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class ComApr0T1Event extends EventSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1619473780139237972L;
	
	
	/** Table Value Object Multi Data 처리 */ 
	private AuthorizationRouteVO authorizationRouteVO = null;
	private AuthorizationRouteVO[] authorizationRouteVOs = null;
	private AuthorizationCommonVO authorizationCommonVO = null;
	private SearchAuthAproVO searchAuthAproVO = null;
	private AuthorizationProgramInfoVO authorizationProgramInfoVO = null;

	public ComApr0T1Event(){}
	
	String xlsPrmt = "";
	
	/**
	 * 
	 * @param authorizationRouteVOs
	 */
	public void setAuthorizationRouteVOS(AuthorizationRouteVO[] authorizationRouteVOs){		
		if(authorizationRouteVOs != null){
			AuthorizationRouteVO[] tmpVOs = Arrays.copyOf(authorizationRouteVOs, authorizationRouteVOs.length);
			this.authorizationRouteVOs = tmpVOs;
		}
	}
	
	
	/**
	 * 
	 * @return AuthorizationRouteVO[]
	 */
	public AuthorizationRouteVO[] getAuthorizationRouteVOS(){		
		AuthorizationRouteVO[] rtnVOs = null;
		if (this.authorizationRouteVOs != null) {
			rtnVOs = Arrays.copyOf(authorizationRouteVOs, authorizationRouteVOs.length);
		}
		return rtnVOs;
	}
	
	/**
	 * 
	 *  @param authorizationCommonVO
	 */
	public void setAuthorizationCommonVO(AuthorizationCommonVO authorizationCommonVO){
		this.authorizationCommonVO = authorizationCommonVO;
	}
	
	/**
	 * 
	 * @return AuthorizationCommonVO
	 */
	public AuthorizationCommonVO getAuthorizationCommonVO(){
		return authorizationCommonVO;
	}
	
	/**
	 * 
	 *  @param authorizationCommonVO
	 */
	public void setSearchAuthAproVO(SearchAuthAproVO searchAuthAproVO){
		this.searchAuthAproVO = searchAuthAproVO;
	}
	
	/**
	 * 
	 * @return SearchAuthAproVO
	 */
	public SearchAuthAproVO getSearchAuthAproVO(){
		return searchAuthAproVO;
	}
	
	/**
	 * 
	 *  @param authorizationRouteVO
	 */
	public void setAuthorizationRouteVO(AuthorizationRouteVO authorizationRouteVO){
		this.authorizationRouteVO = authorizationRouteVO;
	}
	
	/**
	 * 
	 * @return AuthorizationRouteVO
	 */
	public AuthorizationRouteVO getAuthorizationRouteVO(){
		return authorizationRouteVO;
	}
	



	/**
	 * @return the authorizationProgramInfoVO
	 */
	public AuthorizationProgramInfoVO getAuthorizationProgramInfoVO() {
		return authorizationProgramInfoVO;
	}



	/**
	 * @param authorizationProgramInfoVO the authorizationProgramInfoVO to set
	 */
	public void setAuthorizationProgramInfoVO(
			AuthorizationProgramInfoVO authorizationProgramInfoVO) {
		this.authorizationProgramInfoVO = authorizationProgramInfoVO;
	}
	
	
//Authorization Excel	
	
	/**
	 * @return xmlPmt
	 */
	public String getxlsPrmt() {
		return xlsPrmt;
	}

	/**
	 * @param String xmlPmt
	 */
	public void setxlsPrmt(String xlsPrmt) {
		this.xlsPrmt = xlsPrmt;
	}
	
	
}
