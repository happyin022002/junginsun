/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ComSec0004Event.java
*@FileTitle : ALPS Role Authority Approval Monitoring
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.17
*@LastModifier : 김병국
*@LastVersion : 1.0
* 2013.05.10 김병국
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.role.event;

import java.util.HashMap;

import com.hanjin.framework.support.layer.event.EventSupport;
import com.hanjin.syscommon.management.alps.role.vo.AuthorityVO;


/**
 * COM_SEC_0004 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  COM_SEC_0004HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author KIM, Byung Kook
 * @see COM_SEC_0004HTMLAction 참조
 * @since J2EE 1.6
 */

public class ComSec0004Event extends EventSupport {

	private static final long serialVersionUID = 1L;

	/** Table Value Object 조회 조건 및 단건 처리  */
	
	/** subSysCd 변수 */
	String subSysCd;
	
	private AuthorityVO authorityVO = null;

	public AuthorityVO getAuthorityVO() {
		return authorityVO;
	}

	public void setAuthorityVO(AuthorityVO authorityVO) {
		this.authorityVO = authorityVO;
	}
	
	public String getSubSysCd() {
		return subSysCd;
	}

	public void setSubSysCd(String subSysCd) {
		this.subSysCd = subSysCd;
	}
	
	private HashMap<String, String> param = null;
	

	public ComSec0004Event(){
		param = new HashMap<String, String>();
	}
	
	public void setParam(String key, String value){
		param.put(key, value);
	}
	
	public HashMap<String, String> getParam() {
		return param;
	}
	
}