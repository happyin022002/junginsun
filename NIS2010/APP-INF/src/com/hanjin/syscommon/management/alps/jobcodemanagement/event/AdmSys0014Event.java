/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AdmSys0014Event.java
*@FileTitle : Job Code User Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2013-05-21
*@LastModifier : DukWoo Choi
*@LastVersion : 1.0
* 2013-05-21 DukWoo Choi
* 1.0 최초 생성 
=========================================================*/
package com.hanjin.syscommon.management.alps.jobcodemanagement.event;

import java.util.Arrays;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.management.alps.jobcodemanagement.vo.UserInquiryVO;



/**
 * UI_ADM_SYS_0014 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - UI_ADM_SYS_0014HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author SeongWook Kim
 * @see HTMLAction 참조
 * @since J2EE 1.6
 */
public class AdmSys0014Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	private UserInquiryVO userInquiryVO = null;

	/** Table Value Object Multi Data 처리 */
	private UserInquiryVO[] userInquiryVOs = null;

	/**
	 * @return the userInquiryVO
	 */
	public UserInquiryVO getUserInquiryVO() {
		return userInquiryVO;
	}

	/**
	 * @param userInquiryVO the userInquiryVO to set
	 */
	public void setUserInquiryVO(UserInquiryVO userInquiryVO) {
		this.userInquiryVO = userInquiryVO;
	}

	/**
	 * @return the userInquiryVOs
	 */
	public UserInquiryVO[] getUserInquiryVOs() {
		UserInquiryVO[] rtnVOs = null;
		if(this.userInquiryVOs != null){
			rtnVOs = Arrays.copyOf(this.userInquiryVOs, this.userInquiryVOs.length);
		}
		return rtnVOs;
	}

	/**
	 * @param userInquiryVOs the userInquiryVOs to set
	 */
	public void setUserInquiryVOs(UserInquiryVO[] userInquiryVOs) {
		if(userInquiryVOs != null){
			UserInquiryVO[] tempVOs = Arrays.copyOf(userInquiryVOs,userInquiryVOs.length);
			this.userInquiryVOs = tempVOs;
		}
	}
	
}
