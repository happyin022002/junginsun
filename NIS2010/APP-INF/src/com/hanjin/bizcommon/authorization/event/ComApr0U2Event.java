/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ComApr0U2Event.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.15
*@LastModifier : 심성윤
*@LastVersion : 1.0
* 2015.07.15 심성윤
* 1.0 최초 생성
=========================================================*/
package com.hanjin.bizcommon.authorization.event;

import java.util.Arrays;

import com.hanjin.bizcommon.authorization.vo.AuthorizationInquiryVO;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;


/**
 * COM_APR_0U2 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - COM_APR_0U2HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author 심성윤
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class ComApr0U2Event extends EventSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1619473780139237972L;
	
	
	/** Table Value Object Multi Data 처리 */ 
	private AuthorizationInquiryVO[] authorizationInquiryVOs = null;
	private AuthorizationInquiryVO authorizationInquiryVO = null;

	public ComApr0U2Event(){}
	
	
	/**
	 * 
	 * @param authorizationInquiryVOs
	 */
	public void setAuthorizationInquiryVOS(AuthorizationInquiryVO[] authorizationInquiryVOs){		
		if(authorizationInquiryVOs != null){
			AuthorizationInquiryVO[] tmpVOs = Arrays.copyOf(authorizationInquiryVOs, authorizationInquiryVOs.length);
			this.authorizationInquiryVOs = tmpVOs;
		}
	}
	
	
	/**
	 * 
	 * @return AuthorizationInquiryVO[] rtnVOs
	 */
	public AuthorizationInquiryVO[] getAuthorizationInquiryVOS(){		
		AuthorizationInquiryVO[] rtnVOs = null;
		if (this.authorizationInquiryVOs != null) {
			rtnVOs = Arrays.copyOf(authorizationInquiryVOs, authorizationInquiryVOs.length);
		}
		return rtnVOs;
	}
	
	/**
	 * 
	 *  @param authorizationInquiryVO
	 */
	public void setAuthorizationInquiryVO(AuthorizationInquiryVO authorizationInquiryVO){
		this.authorizationInquiryVO = authorizationInquiryVO;
	}
	
	/**
	 * 
	 * @return authorizationInquiryVO
	 */
	public AuthorizationInquiryVO getAuthorizationInquiryVO(){
		return authorizationInquiryVO;
	}
	
	
	
	
	
}
